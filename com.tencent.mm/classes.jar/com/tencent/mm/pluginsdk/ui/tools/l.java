package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
{
  public static int wfw = 2;
  
  public static void a(int paramInt, f paramf, WXMediaMessage paramWXMediaMessage, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(79951);
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      String str1 = (String)paramLinkedList.next();
      String str2 = paramf.field_appId;
      String str3 = paramf.field_appName;
      int i;
      label52:
      int k;
      if (paramf.vY())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!t.lA(str1)) {
          break label376;
        }
      }
      label376:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = q.encode(bo.nullAsNil(b(paramWXMediaMessage)), "UTF-8");
          String str5 = q.encode(bo.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str6 = q.encode(bo.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          ab.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str5 + "," + str6 + "," + str4 + "," + "" + "," + "" + "," + "");
          h.qsU.e(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str5, str6, str4, "", "", "" });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        }
        break;
        i = 0;
        break label52;
      }
    }
    AppMethodBeat.o(79951);
  }
  
  public static void a(int paramInt, f paramf, WxaAttributes paramWxaAttributes, WXMediaMessage paramWXMediaMessage, WXMiniProgramObject paramWXMiniProgramObject, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(79950);
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      String str1 = (String)paramLinkedList.next();
      String str2 = paramf.field_appId;
      String str3 = paramf.field_appName;
      int i;
      label56:
      int k;
      if (paramf.vY())
      {
        i = 1;
        k = paramWXMediaMessage.getType();
        if (!t.lA(str1)) {
          break label412;
        }
      }
      label412:
      for (int j = 1;; j = 0)
      {
        try
        {
          String str4 = q.encode(bo.nullAsNil(paramWXMiniProgramObject.webpageUrl), "UTF-8");
          String str5 = q.encode(bo.nullAsNil(paramWXMediaMessage.title), "UTF-8");
          String str6 = q.encode(bo.nullAsNil(paramWXMediaMessage.description), "UTF-8");
          String str7 = paramWxaAttributes.field_appId;
          String str8 = q.encode(bo.nullAsNil(paramWXMiniProgramObject.path), "UTF-8");
          int m = paramWXMiniProgramObject.miniprogramType;
          ab.i("MicroMsg.ShareReport", paramInt + "," + str2 + "," + str3 + "," + i + "," + k + "," + j + ",1," + str1 + "," + str5 + "," + str6 + "," + str4 + "," + str7 + "," + str8 + "," + m);
          h.qsU.e(16492, new Object[] { Integer.valueOf(paramInt), str2, str3, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(1), str1, str5, str6, str4, str7, str8, Integer.valueOf(m) });
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        }
        break;
        i = 0;
        break label56;
      }
    }
    AppMethodBeat.o(79950);
  }
  
  public static void a(int paramInt, String paramString, WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(79954);
    Object localObject = g.ca(paramString, true);
    if (localObject == null)
    {
      AppMethodBeat.o(79954);
      return;
    }
    paramString = ((f)localObject).field_appId;
    String str1 = ((f)localObject).field_appName;
    if (((f)localObject).vY()) {}
    for (int i = 1;; i = 0)
    {
      int j = paramWXMediaMessage.getType();
      try
      {
        localObject = q.encode(bo.nullAsNil(b(paramWXMediaMessage)), "UTF-8");
        String str2 = q.encode(bo.nullAsNil(paramWXMediaMessage.title), "UTF-8");
        paramWXMediaMessage = q.encode(bo.nullAsNil(paramWXMediaMessage.description), "UTF-8");
        ab.i("MicroMsg.ShareReport", paramInt + "," + paramString + "," + str1 + "," + i + "," + j + ",3,1," + "" + "," + str2 + "," + paramWXMediaMessage + "," + (String)localObject);
        h.qsU.e(16492, new Object[] { Integer.valueOf(paramInt), paramString, str1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(1), "", localObject, str2, paramWXMediaMessage });
        AppMethodBeat.o(79954);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(79954);
      }
    }
  }
  
  public static void aF(Intent paramIntent)
  {
    AppMethodBeat.i(79953);
    Object localObject1 = paramIntent.getBundleExtra("Ksnsupload_timeline");
    if (localObject1 == null)
    {
      AppMethodBeat.o(79953);
      return;
    }
    String str1 = w.n(paramIntent, "Ksnsupload_appid");
    String str2 = w.n(paramIntent, "Ksnsupload_appname");
    int k = w.a(paramIntent, "Ksnsupload_open_sdk_version", 0);
    boolean bool1 = w.a(paramIntent, "KThrid_app", false);
    boolean bool2 = w.a(paramIntent, "Ksnsupload_app_is_game", false);
    paramIntent = new SendMessageToWX.Req();
    paramIntent.fromBundle((Bundle)localObject1);
    paramIntent = paramIntent.message;
    if (paramIntent == null)
    {
      AppMethodBeat.o(79953);
      return;
    }
    try
    {
      localObject1 = q.encode(bo.nullAsNil(b(paramIntent)), "UTF-8");
      String str3 = q.encode(bo.nullAsNil(paramIntent.title), "UTF-8");
      String str4 = q.encode(bo.nullAsNil(paramIntent.description), "UTF-8");
      Object localObject2 = new StringBuilder().append(k).append(",").append(str1).append(",").append(str2).append(",");
      int i;
      label214:
      int m;
      if (bool2)
      {
        i = 1;
        localObject2 = ((StringBuilder)localObject2).append(i).append(",").append(paramIntent.getType()).append(",2,");
        if (!bool1) {
          break label378;
        }
        i = 1;
        ab.i("MicroMsg.ShareReport", i + ",," + str3 + "," + str4 + "," + (String)localObject1);
        localObject2 = h.qsU;
        if (!bool2) {
          break label383;
        }
        i = 1;
        label270:
        m = paramIntent.getType();
        if (!bool1) {
          break label388;
        }
      }
      label388:
      for (int j = 1;; j = 2)
      {
        ((h)localObject2).e(16492, new Object[] { Integer.valueOf(k), str1, str2, Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(j), "", str3, str4, localObject1 });
        AppMethodBeat.o(79953);
        return;
        i = 0;
        break;
        label378:
        i = 2;
        break label214;
        label383:
        i = 0;
        break label270;
      }
      return;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
      AppMethodBeat.o(79953);
    }
  }
  
  private static String b(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(79955);
    if (paramWXMediaMessage == null)
    {
      ab.w("MicroMsg.ShareReport", "sendImgMsg msg not img");
      AppMethodBeat.o(79955);
      return null;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXImageObject))
    {
      paramWXMediaMessage = ((WXImageObject)paramWXMediaMessage.mediaObject).imagePath;
      AppMethodBeat.o(79955);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXVideoFileObject))
    {
      paramWXMediaMessage = ((WXVideoFileObject)paramWXMediaMessage.mediaObject).filePath;
      AppMethodBeat.o(79955);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXMusicObject))
    {
      paramWXMediaMessage = ((WXMusicObject)paramWXMediaMessage.mediaObject).musicUrl;
      AppMethodBeat.o(79955);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXVideoObject))
    {
      paramWXMediaMessage = ((WXVideoObject)paramWXMediaMessage.mediaObject).videoUrl;
      AppMethodBeat.o(79955);
      return paramWXMediaMessage;
    }
    if ((paramWXMediaMessage.mediaObject instanceof WXWebpageObject))
    {
      paramWXMediaMessage = ((WXWebpageObject)paramWXMediaMessage.mediaObject).webpageUrl;
      AppMethodBeat.o(79955);
      return paramWXMediaMessage;
    }
    AppMethodBeat.o(79955);
    return "";
  }
  
  public static void hY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79952);
    paramString1 = j.b.mX(bo.apU(paramString1));
    if (paramString1 == null)
    {
      AppMethodBeat.o(79952);
      return;
    }
    Object localObject = g.ca(paramString1.appId, true);
    if (localObject == null)
    {
      AppMethodBeat.o(79952);
      return;
    }
    String str1 = ((f)localObject).field_appId;
    String str2 = ((f)localObject).field_appName;
    int i;
    int k;
    if (((f)localObject).vY())
    {
      i = 1;
      k = paramString1.type;
      if (!t.lA(paramString2)) {
        break label402;
      }
    }
    label402:
    for (int j = 1;; j = 0)
    {
      int m = wfw;
      try
      {
        localObject = q.encode(bo.nullAsNil(paramString1.url), "UTF-8");
        String str3 = q.encode(bo.nullAsNil(paramString1.title), "UTF-8");
        String str4 = q.encode(bo.nullAsNil(paramString1.description), "UTF-8");
        String str5 = paramString1.fiY;
        String str6 = paramString1.fiW;
        int n = paramString1.fjh;
        ab.i("MicroMsg.ShareReport", "," + str1 + "," + str2 + "," + i + "," + k + "," + j + "," + m + "," + paramString2 + "," + str3 + "," + str4 + "," + (String)localObject + "," + str5 + "," + str6 + "," + n);
        h.qsU.e(16492, new Object[] { "", str1, str2, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m), paramString2, str3, str4, localObject, str5, str6, Integer.valueOf(n) });
        AppMethodBeat.o(79952);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
        AppMethodBeat.o(79952);
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */