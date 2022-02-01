package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
{
  public static int Yug = 2;
  
  public static void a(int paramInt, g paramg, WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(152420);
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      String str1 = (String)paramLinkedList.next();
      String str2 = paramg.field_appId;
      String str3 = paramg.field_appName;
      int i;
      label52:
      int k;
      if (paramg.aqJ())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!au.bwE(str1)) {
          break label406;
        }
      }
      label406:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(c(paramWXMediaMessage)), "UTF-8");
          String str5 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(d(paramWXMediaMessage)), "UTF-8");
          String str6 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str7 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          Log.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str6 + "," + str7 + "," + str4 + "," + "" + "," + "" + "," + "" + "," + str5);
          com.tencent.mm.plugin.report.service.h.OAn.b(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str6, str7, str4, "", "", "", str5 });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        }
        break;
        i = 0;
        break label52;
      }
    }
    AppMethodBeat.o(152420);
  }
  
  public static void a(int paramInt, g paramg, WxaAttributes paramWxaAttributes, WXMediaMessage paramWXMediaMessage, WXMiniProgramObject paramWXMiniProgramObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(152419);
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      String str1 = (String)paramLinkedList.next();
      String str2 = paramg.field_appId;
      String str3 = paramg.field_appName;
      int i;
      label56:
      int k;
      if (paramg.aqJ())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!au.bwE(str1)) {
          break label418;
        }
      }
      label418:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMiniProgramObject.webpageUrl), "UTF-8");
          String str5 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str6 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          String str7 = paramWxaAttributes.field_appId;
          String str8 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMiniProgramObject.path), "UTF-8");
          int m = paramWXMiniProgramObject.miniprogramType;
          Log.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str5 + "," + str6 + "," + str4 + "," + str7 + "," + str8 + "," + m);
          com.tencent.mm.plugin.report.service.h.OAn.b(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str5, str6, str4, str7, str8, Integer.valueOf(m), "" });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        }
        break;
        i = 0;
        break label56;
      }
    }
    AppMethodBeat.o(152419);
  }
  
  public static void a(int paramInt, String paramString, WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(152423);
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
    if (localObject == null)
    {
      AppMethodBeat.o(152423);
      return;
    }
    paramString = ((g)localObject).field_appId;
    String str1 = ((g)localObject).field_appName;
    if (((g)localObject).aqJ()) {}
    for (int i = 1;; i = 0)
    {
      int j = paramWXMediaMessage.getType();
      try
      {
        localObject = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(c(paramWXMediaMessage)), "UTF-8");
        String str2 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(d(paramWXMediaMessage)), "UTF-8");
        String str3 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.title), "UTF-8");
        paramWXMediaMessage = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramWXMediaMessage.description), "UTF-8");
        Log.i("MicroMsg.ShareReport", paramInt + "," + paramString + "," + str1 + "," + i + "," + j + ",3,1," + "" + "," + str3 + "," + paramWXMediaMessage + "," + (String)localObject + "," + str2);
        com.tencent.mm.plugin.report.service.h.OAn.b(16492, new Object[] { Integer.valueOf(paramInt), paramString, str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(1), "", str3, paramWXMediaMessage, localObject, "", "", "", str2 });
        AppMethodBeat.o(152423);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(152423);
      }
    }
  }
  
  public static void a(cc paramcc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(245511);
    Object localObject2 = k.b.Hf(Util.processXml(paramString1));
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!Util.isNullOrNil(((k.b)localObject2).appId)) {}
    }
    else
    {
      paramString1 = k.b.M(0, Util.processXml(paramString1));
      localObject1 = paramString1;
      if (paramString1 != null)
      {
        localObject1 = paramString1;
        if (paramcc != null) {
          if ((paramcc.iYk()) || (paramcc.jbK())) {
            paramString1.type = 2;
          }
        }
      }
    }
    for (paramcc = paramString1; paramcc == null; paramcc = (cc)localObject1)
    {
      Log.e("MicroMsg.ShareReport", "reportMsgTransmit msgContent parse failed");
      AppMethodBeat.o(245511);
      return;
      localObject1 = paramString1;
      if (paramcc.dSH())
      {
        paramString1.type = 38;
        localObject1 = paramString1;
      }
    }
    localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(paramcc.appId, true, false);
    if (localObject2 == null)
    {
      AppMethodBeat.o(245511);
      return;
    }
    paramString1 = ((g)localObject2).field_appId;
    Object localObject1 = ((g)localObject2).field_appName;
    int i;
    int k;
    int j;
    label181:
    int m;
    if (((g)localObject2).aqJ())
    {
      i = 1;
      k = paramcc.type;
      if (!au.bwE(paramString2)) {
        break label548;
      }
      j = 1;
      m = Yug;
    }
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramcc.url), "UTF-8");
        String str1 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramcc.title), "UTF-8");
        String str2 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramcc.description), "UTF-8");
        String str3 = paramcc.nTE;
        String str4 = paramcc.nTC;
        int n = paramcc.nTW;
        paramcc = (b)paramcc.aK(b.class);
        if ((paramcc == null) || (Util.isNullOrNil(paramcc.songAlbumUrl))) {
          break label568;
        }
        paramcc = com.tencent.mm.compatible.util.r.as(paramcc.songAlbumUrl, "UTF-8");
        Log.i("MicroMsg.ShareReport", "," + paramString1 + "," + (String)localObject1 + "," + i + "," + k + "," + j + "," + m + "," + paramString2 + "," + str1 + "," + str2 + "," + (String)localObject2 + "," + str3 + "," + str4 + "," + n + "," + paramcc);
        com.tencent.mm.plugin.report.service.h.OAn.b(16492, new Object[] { "", paramString1, localObject1, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), paramString2, str1, str2, localObject2, str3, str4, Integer.valueOf(n), paramcc });
        AppMethodBeat.o(245511);
        return;
      }
      catch (UnsupportedEncodingException paramcc)
      {
        label548:
        Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(245511);
        return;
      }
      i = 0;
      break;
      j = 0;
      break label181;
      label568:
      paramcc = "";
    }
  }
  
  public static void bU(Intent paramIntent)
  {
    AppMethodBeat.i(152422);
    Object localObject1 = paramIntent.getBundleExtra("Ksnsupload_timeline");
    if (localObject1 == null)
    {
      AppMethodBeat.o(152422);
      return;
    }
    String str1 = IntentUtil.getStringExtra(paramIntent, "Ksnsupload_appid");
    String str2 = IntentUtil.getStringExtra(paramIntent, "Ksnsupload_appname");
    int k = IntentUtil.getIntExtra(paramIntent, "Ksnsupload_open_sdk_version", 0);
    boolean bool1 = IntentUtil.getBooleanExtra(paramIntent, "KThrid_app", false);
    boolean bool2 = IntentUtil.getBooleanExtra(paramIntent, "Ksnsupload_app_is_game", false);
    paramIntent = new SendMessageToWX.Req();
    paramIntent.fromBundle((Bundle)localObject1);
    paramIntent = paramIntent.message;
    if (paramIntent == null)
    {
      AppMethodBeat.o(152422);
      return;
    }
    try
    {
      localObject1 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(c(paramIntent)), "UTF-8");
      String str3 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(d(paramIntent)), "UTF-8");
      String str4 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramIntent.title), "UTF-8");
      String str5 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramIntent.description), "UTF-8");
      Object localObject2 = new StringBuilder().append(k).append(",").append(str1).append(",").append(str2).append(",");
      int i;
      label233:
      int m;
      if (bool2)
      {
        i = 1;
        localObject2 = ((StringBuilder)localObject2).append(i).append(",").append(paramIntent.getType()).append(",2,");
        if (!bool1) {
          break label432;
        }
        i = 1;
        Log.i("MicroMsg.ShareReport", i + ",," + str4 + "," + str5 + "," + (String)localObject1 + "," + str3);
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        if (!bool2) {
          break label437;
        }
        i = 1;
        label300:
        m = paramIntent.getType();
        if (!bool1) {
          break label442;
        }
      }
      label432:
      label437:
      label442:
      for (int j = 1;; j = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).b(16492, new Object[] { Integer.valueOf(k), str1, str2, Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(j), "", str4, str5, localObject1, "", "", "", str3 });
        AppMethodBeat.o(152422);
        return;
        i = 0;
        break;
        i = 2;
        break label233;
        i = 0;
        break label300;
      }
      return;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
      AppMethodBeat.o(152422);
    }
  }
  
  private static String c(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(152424);
    if (paramWXMediaMessage == null)
    {
      Log.w("MicroMsg.ShareReport", "sendImgMsg msg not img");
      AppMethodBeat.o(152424);
      return null;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXImageObject))
    {
      paramWXMediaMessage = ((WXImageObject)paramWXMediaMessage.mediaObject).imagePath;
      AppMethodBeat.o(152424);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXVideoFileObject))
    {
      paramWXMediaMessage = ((WXVideoFileObject)paramWXMediaMessage.mediaObject).filePath;
      AppMethodBeat.o(152424);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMusicObject))
    {
      paramWXMediaMessage = ((WXMusicObject)paramWXMediaMessage.mediaObject).musicUrl;
      AppMethodBeat.o(152424);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXVideoObject))
    {
      paramWXMediaMessage = ((WXVideoObject)paramWXMediaMessage.mediaObject).videoUrl;
      AppMethodBeat.o(152424);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXWebpageObject))
    {
      paramWXMediaMessage = ((WXWebpageObject)paramWXMediaMessage.mediaObject).webpageUrl;
      AppMethodBeat.o(152424);
      return paramWXMediaMessage;
    }
    AppMethodBeat.o(152424);
    return "";
  }
  
  private static String d(WXMediaMessage paramWXMediaMessage)
  {
    if (paramWXMediaMessage == null) {
      return null;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMusicObject)) {
      return ((WXMusicObject)paramWXMediaMessage.mediaObject).songAlbumUrl;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */