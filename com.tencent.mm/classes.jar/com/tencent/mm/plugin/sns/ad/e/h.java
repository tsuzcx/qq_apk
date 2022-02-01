package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.ad.a.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class h
{
  private static String Fg(String paramString)
  {
    AppMethodBeat.i(201934);
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(201934);
      return str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("FinderAdJumpHelper", "urlEncode exp=" + localException.toString());
        String str2 = paramString;
      }
    }
  }
  
  public static boolean a(Context paramContext, ADXml paramADXml, ADInfo paramADInfo, long paramLong)
  {
    AppMethodBeat.i(201930);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        paramADXml = paramADXml.adFinderInfo;
        Object localObject = r.Jb(paramLong);
        paramADInfo = jU(paramADInfo.uxInfo, (String)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("report_scene", 3);
        ((Intent)localObject).putExtra("from_user", paramADXml.finderUsername);
        ((Intent)localObject).putExtra("feed_encrypted_object_id", paramADXml.DrX);
        ((Intent)localObject).putExtra("feed_object_nonceId", paramADXml.objectNonceId);
        ((Intent)localObject).putExtra("key_from_user_name", paramADXml.finderUsername);
        ((Intent)localObject).putExtra("tab_type", 5);
        ((Intent)localObject).putExtra("key_detail_comment_scene", 42);
        ((Intent)localObject).putExtra("is_from_ad", true);
        ((Intent)localObject).putExtra("key_extra_info", paramADInfo);
        ((Intent)localObject).putExtra("key_comment_scene", 37);
        ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 4, 42, (Intent)localObject);
        ((aj)g.ah(aj.class)).enterFinderShareFeedUI(paramContext, (Intent)localObject);
        Log.i("FinderAdJumpHelper", "JumpFinderFeedsDetailUI, adInfoExtra=" + paramADInfo + ", objectNonceId=" + paramADXml.objectNonceId);
        AppMethodBeat.o(201930);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "JumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(201930);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(201932);
    if ((paramContext != null) && (paramSnsInfo != null)) {}
    try
    {
      if (paramSnsInfo.getAdInfo(paramInt) != null)
      {
        localObject1 = paramSnsInfo.getAdXml();
        if ((localObject1 == null) || (((ADXml)localObject1).headClickType != 4)) {
          break label66;
        }
        localObject1 = ((ADXml)localObject1).adHeadFinderProfile;
        if (localObject1 == null) {
          break label66;
        }
      }
      label66:
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(201932);
        return false;
      }
      Object localObject1 = paramSnsInfo.getAdXml();
      Object localObject2 = paramSnsInfo.getAdInfo(paramInt);
      localObject1 = ((ADXml)localObject1).adHeadFinderProfile.finderUsername;
      paramSnsInfo = r.Jb(paramSnsInfo.field_snsId);
      paramSnsInfo = jU(((ADInfo)localObject2).uxInfo, paramSnsInfo);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("key_from_profile_share_scene", 3);
      ((Intent)localObject2).putExtra("key_enter_profile_type", 1);
      ((Intent)localObject2).putExtra("finder_username", (String)localObject1);
      ((Intent)localObject2).putExtra("key_comment_scene", 37);
      ((Intent)localObject2).putExtra("is_from_ad", true);
      ((Intent)localObject2).putExtra("key_extra_info", paramSnsInfo);
      ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 4, 32, (Intent)localObject2);
      ((aj)g.ah(aj.class)).enterFinderProfileUI(paramContext, (Intent)localObject2);
      AppMethodBeat.o(201932);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "jumpToFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(201932);
    }
    return false;
  }
  
  public static boolean a(ADXml paramADXml, ADInfo paramADInfo)
  {
    return (paramADXml != null) && (paramADXml.adFinderInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 9);
  }
  
  public static boolean b(Context paramContext, ADXml paramADXml, ADInfo paramADInfo, long paramLong)
  {
    AppMethodBeat.i(201931);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        paramADXml = paramADXml.adFinderInfo;
        Object localObject = r.Jb(paramLong);
        paramADInfo = jU(paramADInfo.uxInfo, (String)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_from_profile_share_scene", 3);
        ((Intent)localObject).putExtra("key_enter_profile_type", 1);
        ((Intent)localObject).putExtra("finder_username", paramADXml.finderUsername);
        ((Intent)localObject).putExtra("key_comment_scene", 37);
        ((Intent)localObject).putExtra("is_from_ad", true);
        ((Intent)localObject).putExtra("key_extra_info", paramADInfo);
        ((aj)g.ah(aj.class)).fillContextIdToIntent(4, 4, 32, (Intent)localObject);
        ((aj)g.ah(aj.class)).enterFinderProfileUI(paramContext, (Intent)localObject);
        Log.i("FinderAdJumpHelper", "JumpFinderProfileUI, adInfoExtra=" + paramADInfo + ", objectNonceId=" + paramADXml.objectNonceId);
        AppMethodBeat.o(201931);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "JumpFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(201931);
    }
    return false;
  }
  
  public static String jU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201933);
    try
    {
      paramString1 = Fg(paramString1);
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uxinfo", Util.nullAsNil(paramString1));
      localJSONObject2.put("snsid", paramString2);
      localJSONObject1.put("sns_ad", localJSONObject2);
      paramString1 = localJSONObject1.toString();
      Log.d("FinderAdJumpHelper", "makeAdInfoExtra, ret=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(201933);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("FinderAdJumpHelper", "makeAdInfoExtra, exp=" + paramString1.toString());
      AppMethodBeat.o(201933);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.h
 * JD-Core Version:    0.7.0.1
 */