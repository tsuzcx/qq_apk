package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class d
{
  public static boolean a(Context paramContext, b paramb, a parama, long paramLong)
  {
    AppMethodBeat.i(219008);
    try
    {
      if (a(paramb, parama))
      {
        paramb = paramb.zOa;
        Object localObject = r.zV(paramLong);
        parama = ji(parama.dGD, (String)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("report_scene", 3);
        ((Intent)localObject).putExtra("from_user", paramb.sbR);
        ((Intent)localObject).putExtra("feed_encrypted_object_id", paramb.zOf);
        ((Intent)localObject).putExtra("feed_object_nonceId", paramb.objectNonceId);
        ((Intent)localObject).putExtra("key_from_user_name", paramb.sbR);
        ((Intent)localObject).putExtra("tab_type", 5);
        ((Intent)localObject).putExtra("key_detail_comment_scene", 42);
        ((Intent)localObject).putExtra("is_from_ad", true);
        ((Intent)localObject).putExtra("key_ad_extra_info", parama);
        ((Intent)localObject).putExtra("key_comment_scene", 37);
        ((t)g.ad(t.class)).fillContextIdToIntent(4, 4, 42, (Intent)localObject);
        ((t)g.ad(t.class)).enterFinderShareFeedUI(paramContext, (Intent)localObject);
        ae.i("FinderAdJumpHelper", "JumpFinderFeedsDetailUI, adInfoExtra=" + parama + ", objectNonceId=" + paramb.objectNonceId);
        AppMethodBeat.o(219008);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      ae.e("FinderAdJumpHelper", "JumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(219008);
    }
    return false;
  }
  
  public static boolean a(b paramb, a parama)
  {
    return (paramb != null) && (paramb.zOa != null) && (parama != null) && (parama.zLR == 9);
  }
  
  public static boolean b(Context paramContext, b paramb, a parama, long paramLong)
  {
    AppMethodBeat.i(219009);
    try
    {
      if (a(paramb, parama))
      {
        paramb = paramb.zOa;
        Object localObject = r.zV(paramLong);
        parama = ji(parama.dGD, (String)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 3);
        ((Intent)localObject).putExtra("key_enter_profile_type", 1);
        ((Intent)localObject).putExtra("finder_username", paramb.sbR);
        ((Intent)localObject).putExtra("key_comment_scene", 37);
        ((Intent)localObject).putExtra("is_from_ad", true);
        ((Intent)localObject).putExtra("key_ad_extra_info", parama);
        ((t)g.ad(t.class)).fillContextIdToIntent(4, 4, 32, (Intent)localObject);
        ((t)g.ad(t.class)).enterFinderProfileUI(paramContext, (Intent)localObject);
        ae.i("FinderAdJumpHelper", "JumpFinderProfileUI, adInfoExtra=" + parama + ", objectNonceId=" + paramb.objectNonceId);
        AppMethodBeat.o(219009);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      ae.e("FinderAdJumpHelper", "JumpFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(219009);
    }
    return false;
  }
  
  private static String ji(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219010);
    try
    {
      paramString1 = wS(paramString1);
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uxinfo", bu.nullAsNil(paramString1));
      localJSONObject2.put("snsid", paramString2);
      localJSONObject1.put("sns_ad", localJSONObject2);
      paramString1 = localJSONObject1.toString();
      ae.d("FinderAdJumpHelper", "makeAdInfoExtra, ret=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(219010);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.e("FinderAdJumpHelper", "makeAdInfoExtra, exp=" + paramString1.toString());
      AppMethodBeat.o(219010);
    }
    return "";
  }
  
  private static String wS(String paramString)
  {
    AppMethodBeat.i(219011);
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(219011);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("FinderAdJumpHelper", "urlEncode exp=" + localException.toString());
        String str2 = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.d
 * JD-Core Version:    0.7.0.1
 */