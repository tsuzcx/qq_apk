package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class l
{
  private static String Mc(String paramString)
  {
    AppMethodBeat.i(228025);
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(228025);
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
    AppMethodBeat.i(227985);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        String str1 = paramADXml.adFinderInfo.finderUsername;
        String str2 = paramADXml.adFinderInfo.objectNonceId;
        paramADXml = paramADXml.adFinderInfo.fwa;
        boolean bool = a(paramContext, paramADInfo.uxInfo, str1, str2, paramADXml, paramLong, 3);
        AppMethodBeat.o(227985);
        return bool;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "checkJumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(227985);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, ADXml paramADXml, ADInfo paramADInfo, long paramLong, int paramInt)
  {
    AppMethodBeat.i(228013);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        paramADXml = paramADXml.adFinderInfo;
        String str = t.Qu(paramLong);
        boolean bool = a(paramContext, paramADXml.finderUsername, paramADInfo.uxInfo, str, paramInt);
        AppMethodBeat.o(228013);
        return bool;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "checkJumpFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(228013);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(228018);
    try
    {
      paramString2 = an(paramString2, paramString3, paramInt);
      Log.i("FinderAdJumpHelper", "doJumpToFinderProfileUI, finderUsername=" + paramString1 + ", adInfoExtra=" + paramString2 + ", scene=" + paramInt);
      paramString3 = new Intent();
      paramString3.putExtra("key_from_profile_share_scene", 3);
      paramString3.putExtra("key_enter_profile_type", 1);
      paramString3.putExtra("finder_username", paramString1);
      paramString3.putExtra("key_comment_scene", 37);
      paramString3.putExtra("is_from_ad", true);
      paramString3.putExtra("key_extra_info", paramString2);
      ((ak)h.ag(ak.class)).fillContextIdToIntent(4, 4, 32, paramString3);
      ((ak)h.ag(ak.class)).enterFinderProfileUI(paramContext, paramString3);
      AppMethodBeat.o(228018);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "doJumpToFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(228018);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    AppMethodBeat.i(227992);
    try
    {
      a(null, paramContext, paramString2, paramString3, paramString4, an(paramString1, t.Qu(paramLong), paramInt));
      AppMethodBeat.o(227992);
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(227992);
    }
    return false;
  }
  
  public static boolean a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(228006);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {}
    try
    {
      localIntent = new Intent();
      localIntent.putExtra("report_scene", 3);
      localIntent.putExtra("from_user", paramString1);
      localIntent.putExtra("feed_encrypted_object_id", paramString3);
      localIntent.putExtra("feed_object_nonceId", paramString2);
      localIntent.putExtra("key_from_user_name", paramString1);
      localIntent.putExtra("tab_type", 5);
      localIntent.putExtra("key_detail_comment_scene", 42);
      localIntent.putExtra("is_from_ad", true);
      localIntent.putExtra("key_extra_info", paramString4);
      localIntent.putExtra("key_comment_scene", 37);
      if (!localIntent.hasExtra("key_context_id")) {
        ((ak)h.ag(ak.class)).fillContextIdToIntent(4, 4, 42, localIntent);
      }
      ((ak)h.ag(ak.class)).enterFinderShareFeedUI(paramContext, localIntent);
      Log.i("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI, adInfoExtra=" + paramString4 + ", objectNonceId=" + paramString2 + ", finderUsername=" + paramString1 + ", exportId=" + paramString3);
      AppMethodBeat.o(228006);
      return true;
    }
    catch (Throwable paramIntent)
    {
      Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + paramIntent.toString());
      AppMethodBeat.o(228006);
    }
    return false;
  }
  
  public static boolean a(ADXml paramADXml, ADInfo paramADInfo)
  {
    return (paramADXml != null) && (paramADXml.adFinderInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 9);
  }
  
  public static int aeJ(int paramInt)
  {
    int i = 4;
    switch (paramInt)
    {
    default: 
      i = 0;
    case 1: 
    case 4: 
      return i;
    case 2: 
      return 6;
    }
    return 3;
  }
  
  public static String an(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(228022);
    try
    {
      paramString1 = Mc(paramString1);
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uxinfo", Util.nullAsNil(paramString1));
      localJSONObject2.put("snsid", paramString2);
      localJSONObject2.put("scene", paramInt);
      localJSONObject1.put("sns_ad", localJSONObject2);
      paramString1 = localJSONObject1.toString();
      Log.d("FinderAdJumpHelper", "makeAdInfoExtra, ret=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(228022);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("FinderAdJumpHelper", "makeAdInfoExtra, exp=" + paramString1.toString());
      AppMethodBeat.o(228022);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.l
 * JD-Core Version:    0.7.0.1
 */