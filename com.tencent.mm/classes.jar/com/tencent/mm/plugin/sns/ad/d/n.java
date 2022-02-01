package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bk;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

public final class n
{
  private static String EL(String paramString)
  {
    AppMethodBeat.i(310019);
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str1 = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(310019);
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
    AppMethodBeat.i(309966);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        String str1 = paramADXml.adFinderInfo.finderUsername;
        String str2 = paramADXml.adFinderInfo.objectNonceId;
        paramADXml = paramADXml.adFinderInfo.hAx;
        boolean bool = a(paramContext, paramADInfo.uxInfo, str1, str2, paramADXml, paramLong, paramADInfo.preloadFinderFeed, 3);
        AppMethodBeat.o(309966);
        return bool;
      }
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "checkJumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(309966);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, ADXml paramADXml, ADInfo paramADInfo, long paramLong, int paramInt)
  {
    AppMethodBeat.i(309996);
    try
    {
      if (a(paramADXml, paramADInfo))
      {
        paramADXml = paramADXml.adFinderInfo;
        String str = t.uA(paramLong);
        boolean bool = a(paramContext, paramADXml.finderUsername, paramADInfo.uxInfo, str, paramInt);
        AppMethodBeat.o(309996);
        return bool;
      }
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "checkJumpFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(309996);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(310005);
    try
    {
      paramString2 = aw(paramString2, paramString3, paramInt);
      Log.i("FinderAdJumpHelper", "doJumpToFinderProfileUI, finderUsername=" + paramString1 + ", adInfoExtra=" + paramString2 + ", scene=" + paramInt);
      paramString3 = new Intent();
      paramString3.putExtra("key_from_profile_share_scene", 3);
      paramString3.putExtra("key_enter_profile_type", 1);
      paramString3.putExtra("finder_username", paramString1);
      paramString3.putExtra("key_from_comment_scene", 37);
      paramString3.putExtra("is_from_ad", true);
      paramString3.putExtra("key_extra_info", paramString2);
      ((cn)h.az(cn.class)).fillContextIdToIntent(4, 4, 32, paramString3);
      ((cn)h.az(cn.class)).enterFinderProfileUI(paramContext, paramString3);
      AppMethodBeat.o(310005);
      return true;
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "doJumpToFinderProfileUI exp=" + paramContext.toString());
      AppMethodBeat.o(310005);
    }
    return false;
  }
  
  private static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(309980);
    try
    {
      paramString1 = aw(paramString1, t.uA(paramLong), paramInt);
      Intent localIntent = new Intent();
      if (paramLong1 != null) {
        localIntent.putExtra("feed_object_id", paramLong1);
      }
      a(localIntent, paramContext, paramString2, paramString3, paramString4, paramString1);
      AppMethodBeat.o(309980);
      return true;
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(309980);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(309974);
    Object localObject = null;
    if (paramBoolean) {}
    try
    {
      Long localLong = (Long)o.POm.get(paramString4);
      if (localLong == null)
      {
        localLong = Long.valueOf(MMApplicationContext.getContext().getSharedPreferences("ad_finder_feeds_preload_id_app_related", 0).getLong(paramString4, 0L));
        o.POm.put(paramString4, localLong);
        Log.i("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI, no memory objectId, should read sp and put objectId to map, and objectId is ".concat(String.valueOf(localLong)));
      }
      for (;;)
      {
        bk localbk = o.gZS();
        localObject = localLong;
        if (localbk != null)
        {
          localbk.pS(localLong.longValue());
          localObject = localLong;
        }
        paramBoolean = a(paramContext, paramString1, paramString2, paramString3, paramString4, paramLong, localObject, paramInt);
        AppMethodBeat.o(309974);
        return paramBoolean;
        Log.i("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI, objectId is ".concat(String.valueOf(localLong)));
      }
      return false;
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + paramContext.toString());
      AppMethodBeat.o(309974);
    }
  }
  
  public static boolean a(Intent paramIntent, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(309988);
    try
    {
      paramIntent.putExtra("report_scene", 3);
      paramIntent.putExtra("from_user", paramString1);
      paramIntent.putExtra("feed_encrypted_object_id", paramString3);
      paramIntent.putExtra("feed_object_nonceId", paramString2);
      paramIntent.putExtra("key_from_user_name", paramString1);
      paramIntent.putExtra("tab_type", 5);
      paramIntent.putExtra("key_detail_comment_scene", 42);
      paramIntent.putExtra("is_from_ad", true);
      paramIntent.putExtra("key_extra_info", paramString4);
      paramIntent.putExtra("key_from_comment_scene", 37);
      if (!paramIntent.hasExtra("key_context_id")) {
        ((cn)h.az(cn.class)).fillContextIdToIntent(4, 4, 42, paramIntent);
      }
      ((cn)h.az(cn.class)).enterFinderShareFeedUI(paramContext, paramIntent);
      Log.i("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI, adInfoExtra=" + paramString4 + ", objectNonceId=" + paramString2 + ", finderUsername=" + paramString1 + ", exportId=" + paramString3);
      AppMethodBeat.o(309988);
      return true;
    }
    finally
    {
      Log.e("FinderAdJumpHelper", "doJumpFinderFeedsDetailUI exp=" + paramIntent.toString());
      AppMethodBeat.o(309988);
    }
    return false;
  }
  
  public static boolean a(ADXml paramADXml)
  {
    AppMethodBeat.i(309954);
    if ((paramADXml != null) && (paramADXml.adActionLinkClickInfo != null) && (paramADXml.adActionLinkClickInfo.PLm == 14) && (!c.hm(paramADXml.adActionLinkClickInfo.finderUsername)))
    {
      AppMethodBeat.o(309954);
      return true;
    }
    AppMethodBeat.o(309954);
    return false;
  }
  
  public static boolean a(ADXml paramADXml, ADInfo paramADInfo)
  {
    return (paramADXml != null) && (paramADXml.adFinderInfo != null) && (paramADInfo != null) && (paramADInfo.adActionType == 9);
  }
  
  public static int ajs(int paramInt)
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
  
  public static String aw(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(310012);
    try
    {
      paramString1 = EL(paramString1);
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uxinfo", Util.nullAsNil(paramString1));
      localJSONObject2.put("snsid", paramString2);
      localJSONObject2.put("scene", paramInt);
      localJSONObject1.put("sns_ad", localJSONObject2);
      paramString1 = localJSONObject1.toString();
      Log.d("FinderAdJumpHelper", "makeAdInfoExtra, ret=".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(310012);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("FinderAdJumpHelper", "makeAdInfoExtra, exp=" + paramString1.toString());
      AppMethodBeat.o(310012);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.n
 * JD-Core Version:    0.7.0.1
 */