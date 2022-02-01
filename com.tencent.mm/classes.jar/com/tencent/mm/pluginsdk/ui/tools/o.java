package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.model.w;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

public final class o
{
  public static int DFN = 2;
  
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
      if (paramg.CC())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!w.sQ(str1)) {
          break label406;
        }
      }
      label406:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = p.encode(bs.nullAsNil(b(paramWXMediaMessage)), "UTF-8");
          String str5 = p.encode(bs.nullAsNil(c(paramWXMediaMessage)), "UTF-8");
          String str6 = p.encode(bs.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str7 = p.encode(bs.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          ac.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str6 + "," + str7 + "," + str4 + "," + "" + "," + "" + "," + "" + "," + str5);
          com.tencent.mm.plugin.report.service.h.wUl.f(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str6, str7, str4, "", "", "", str5 });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ac.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
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
      if (paramg.CC())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!w.sQ(str1)) {
          break label418;
        }
      }
      label418:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = p.encode(bs.nullAsNil(paramWXMiniProgramObject.webpageUrl), "UTF-8");
          String str5 = p.encode(bs.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str6 = p.encode(bs.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          String str7 = paramWxaAttributes.field_appId;
          String str8 = p.encode(bs.nullAsNil(paramWXMiniProgramObject.path), "UTF-8");
          int m = paramWXMiniProgramObject.miniprogramType;
          ac.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str5 + "," + str6 + "," + str4 + "," + str7 + "," + str8 + "," + m);
          com.tencent.mm.plugin.report.service.h.wUl.f(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str5, str6, str4, str7, str8, Integer.valueOf(m), "" });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ac.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
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
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
    if (localObject == null)
    {
      AppMethodBeat.o(152423);
      return;
    }
    paramString = ((g)localObject).field_appId;
    String str1 = ((g)localObject).field_appName;
    if (((g)localObject).CC()) {}
    for (int i = 1;; i = 0)
    {
      int j = paramWXMediaMessage.getType();
      try
      {
        localObject = p.encode(bs.nullAsNil(b(paramWXMediaMessage)), "UTF-8");
        String str2 = p.encode(bs.nullAsNil(c(paramWXMediaMessage)), "UTF-8");
        String str3 = p.encode(bs.nullAsNil(paramWXMediaMessage.title), "UTF-8");
        paramWXMediaMessage = p.encode(bs.nullAsNil(paramWXMediaMessage.description), "UTF-8");
        ac.i("MicroMsg.ShareReport", paramInt + "," + paramString + "," + str1 + "," + i + "," + j + ",3,1," + "" + "," + str3 + "," + paramWXMediaMessage + "," + (String)localObject + "," + str2);
        com.tencent.mm.plugin.report.service.h.wUl.f(16492, new Object[] { Integer.valueOf(paramInt), paramString, str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(1), "", str3, paramWXMediaMessage, localObject, "", "", "", str2 });
        AppMethodBeat.o(152423);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        ac.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(152423);
      }
    }
  }
  
  public static void aY(Intent paramIntent)
  {
    AppMethodBeat.i(152422);
    Object localObject1 = paramIntent.getBundleExtra("Ksnsupload_timeline");
    if (localObject1 == null)
    {
      AppMethodBeat.o(152422);
      return;
    }
    String str1 = x.getStringExtra(paramIntent, "Ksnsupload_appid");
    String str2 = x.getStringExtra(paramIntent, "Ksnsupload_appname");
    int k = x.getIntExtra(paramIntent, "Ksnsupload_open_sdk_version", 0);
    boolean bool1 = x.getBooleanExtra(paramIntent, "KThrid_app", false);
    boolean bool2 = x.getBooleanExtra(paramIntent, "Ksnsupload_app_is_game", false);
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
      localObject1 = p.encode(bs.nullAsNil(b(paramIntent)), "UTF-8");
      String str3 = p.encode(bs.nullAsNil(c(paramIntent)), "UTF-8");
      String str4 = p.encode(bs.nullAsNil(paramIntent.title), "UTF-8");
      String str5 = p.encode(bs.nullAsNil(paramIntent.description), "UTF-8");
      Object localObject2 = new StringBuilder().append(k).append(",").append(str1).append(",").append(str2).append(",");
      int i;
      label228:
      int m;
      if (bool2)
      {
        i = 1;
        localObject2 = ((StringBuilder)localObject2).append(i).append(",").append(paramIntent.getType()).append(",2,");
        if (!bool1) {
          break label426;
        }
        i = 1;
        ac.i("MicroMsg.ShareReport", i + ",," + str4 + "," + str5 + "," + (String)localObject1 + "," + str3);
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool2) {
          break label431;
        }
        i = 1;
        label294:
        m = paramIntent.getType();
        if (!bool1) {
          break label436;
        }
      }
      label426:
      label431:
      label436:
      for (int j = 1;; j = 2)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).f(16492, new Object[] { Integer.valueOf(k), str1, str2, Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(j), "", str4, str5, localObject1, "", "", "", str3 });
        AppMethodBeat.o(152422);
        return;
        i = 0;
        break;
        i = 2;
        break label228;
        i = 0;
        break label294;
      }
      return;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      ac.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
      AppMethodBeat.o(152422);
    }
  }
  
  private static String b(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(152424);
    if (paramWXMediaMessage == null)
    {
      ac.w("MicroMsg.ShareReport", "sendImgMsg msg not img");
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
  
  private static String c(WXMediaMessage paramWXMediaMessage)
  {
    if (paramWXMediaMessage == null) {
      return null;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMusicObject)) {
      return ((WXMusicObject)paramWXMediaMessage.mediaObject).songAlbumUrl;
    }
    return "";
  }
  
  public static void lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152421);
    paramString1 = k.b.vz(bs.aLx(paramString1));
    if (paramString1 == null)
    {
      AppMethodBeat.o(152421);
      return;
    }
    Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(paramString1.appId, true, false);
    if (localObject == null)
    {
      AppMethodBeat.o(152421);
      return;
    }
    String str1 = ((g)localObject).field_appId;
    String str2 = ((g)localObject).field_appName;
    int i;
    int k;
    int j;
    label87:
    int m;
    if (((g)localObject).CC())
    {
      i = 1;
      k = paramString1.type;
      if (!w.sQ(paramString2)) {
        break label456;
      }
      j = 1;
      m = DFN;
    }
    for (;;)
    {
      try
      {
        localObject = p.encode(bs.nullAsNil(paramString1.url), "UTF-8");
        String str3 = p.encode(bs.nullAsNil(paramString1.title), "UTF-8");
        String str4 = p.encode(bs.nullAsNil(paramString1.description), "UTF-8");
        String str5 = paramString1.hkf;
        String str6 = paramString1.hkd;
        int n = paramString1.hkq;
        paramString1 = (b)paramString1.ao(b.class);
        if ((paramString1 == null) || (bs.isNullOrNil(paramString1.songAlbumUrl))) {
          break label476;
        }
        paramString1 = p.encode(paramString1.songAlbumUrl, "UTF-8");
        ac.i("MicroMsg.ShareReport", "," + str1 + "," + str2 + "," + i + "," + k + "," + j + "," + m + "," + paramString2 + "," + str3 + "," + str4 + "," + (String)localObject + "," + str5 + "," + str6 + "," + n + "," + paramString1);
        com.tencent.mm.plugin.report.service.h.wUl.f(16492, new Object[] { "", str1, str2, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), paramString2, str3, str4, localObject, str5, str6, Integer.valueOf(n), paramString1 });
        AppMethodBeat.o(152421);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        label456:
        ac.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(152421);
        return;
      }
      i = 0;
      break;
      j = 0;
      break label87;
      label476:
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */