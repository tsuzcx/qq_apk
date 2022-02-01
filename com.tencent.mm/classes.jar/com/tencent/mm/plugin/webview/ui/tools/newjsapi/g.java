package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.c;
import d.n.n;
import d.v;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.xwalk.core.XWalkEnvironment;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleMPPageAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "checkParams", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "enterEmbedMpVideo", "fillMpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "handleMsg", "hasActivity", "insertVideoNativeView", "longPressEmbedMpVideo", "sendMPPageData", "shareEmbedMpVideo", "stringToBitmap", "Landroid/graphics/Bitmap;", "string", "wxConfig", "plugin-webview_release"})
public final class g
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int CHh = 345;
  public static final g CLG;
  private static final String dxZ = "handleMPPageAction";
  
  static
  {
    AppMethodBeat.i(82690);
    CLG = new g();
    CHh = 345;
    dxZ = "handleMPPageAction";
    AppMethodBeat.o(82690);
  }
  
  private static Bitmap aDW(String paramString)
  {
    AppMethodBeat.i(82689);
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.f.ck(Base64.decode((String)n.a((CharSequence)paramString, new String[] { "," }).get(1), 2));
      AppMethodBeat.o(82689);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.JsApiHandleMPPageAction", "stringToBitmap fail " + paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  private static boolean c(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189501);
    String str1 = (String)paraml.vUl.get("appid");
    String str3 = (String)paraml.vUl.get("webComptList");
    ac.i("MicroMsg.JsApiHandleMPPageAction", "wxConfig webComptList=" + str3 + ", appId=" + str1);
    Object localObject1;
    try
    {
      localObject1 = new JSONArray(str3);
      str3 = (String)paraml.vUl.get("url");
      if (str3 == null)
      {
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail invalid params", null);
        AppMethodBeat.o(189501);
        return true;
      }
      localObject2 = com.tencent.mm.plugin.webview.k.f.CSs;
      localObject1 = com.tencent.mm.plugin.webview.k.f.c(str3, (JSONArray)localObject1);
      if (bs.gY((List)localObject1))
      {
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail webComptList is null", null);
        AppMethodBeat.o(189501);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.JsApiHandleMPPageAction", "wxConfig ex " + localException.getMessage());
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail ex " + localException + ".message", null);
      AppMethodBeat.o(189501);
      return true;
    }
    Object localObject2 = paramd.Cjq.ezV();
    String str2 = bs.bG(localException, "");
    d.g.b.k.g(str2, "Util.nullAs(appId, \"\")");
    ((com.tencent.mm.plugin.webview.k.k)localObject2).c(str2, str3, (LinkedList)localObject1);
    paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
    AppMethodBeat.o(189501);
    return true;
  }
  
  private static boolean d(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189502);
    if (bs.isNullOrNil((String)paraml.vUl.get("mpUrl")))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail, mpUrl is null", null);
      AppMethodBeat.o(189502);
      return false;
    }
    if (bs.isNullOrNil((String)paraml.vUl.get("bizUsrName")))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail, bizUsrName is null", null);
      AppMethodBeat.o(189502);
      return false;
    }
    if (bs.isNullOrNil((String)paraml.vUl.get("videoUrl")))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail, videoUrl is null", null);
      AppMethodBeat.o(189502);
      return false;
    }
    if (bs.isNullOrNil((String)paraml.vUl.get("videoVid")))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail, videoVid is null", null);
      AppMethodBeat.o(189502);
      return false;
    }
    AppMethodBeat.o(189502);
    return true;
  }
  
  private static y e(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189503);
    String str1 = (String)paraml.vUl.get("mpUrl");
    String str2 = (String)paraml.vUl.get("bizUsrName");
    String str3 = (String)paraml.vUl.get("videoUrl");
    String str4 = (String)paraml.vUl.get("videoTitle");
    String str5 = (String)paraml.vUl.get("videoVid");
    String str6 = (String)paraml.vUl.get("bizNickName");
    Object localObject1 = paraml.vUl.get("videoThumbUrl");
    if (localObject1 == null)
    {
      paramd = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(189503);
      throw paramd;
    }
    localObject1 = (String)localObject1;
    Object localObject2 = (String)paraml.vUl.get("videoThumbData");
    String str7 = (String)paraml.vUl.get("headImgUrl");
    float f = bs.getFloat((String)paraml.vUl.get("videoDuration"), 0.0F);
    int j = bs.getInt((String)paraml.vUl.get("videoWidth"), 0);
    int i = bs.getInt((String)paraml.vUl.get("videoHeight"), 0);
    if (localObject2 != null)
    {
      localObject2 = aDW((String)localObject2);
      if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
      {
        j = ((Bitmap)localObject2).getWidth();
        i = ((Bitmap)localObject2).getHeight();
      }
    }
    for (;;)
    {
      try
      {
        aw localaw = aw.fK("MpShareVideoImage", 2);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localByteArrayOutputStream);
        localaw.encode(str5, localByteArrayOutputStream.toByteArray());
        localObject2 = new y();
        ((y)localObject2).ddo = str2;
        ((y)localObject2).hkV = str6;
        ((y)localObject2).DWF = str1;
        ((y)localObject2).videoUrl = str3;
        ((y)localObject2).DWG = str5;
        ((y)localObject2).title = str4;
        ((y)localObject2).hld = ((String)localObject1);
        ((y)localObject2).width = j;
        ((y)localObject2).height = i;
        ((y)localObject2).videoDuration = ((int)f);
        ((y)localObject2).hlG = str7;
        ((y)localObject2).url = "https://support.weixin.qq.com/update/";
        if (bs.getInt((String)paraml.vUl.get("forbidForward"), 0) == 1)
        {
          bool = true;
          ((y)localObject2).hlH = bool;
          paramd = paramd.context;
          if ((paramd instanceof WebViewUI))
          {
            ((y)localObject2).hkW = ((WebViewUI)paramd).getIntent().getStringExtra("prePublishId");
            ((y)localObject2).dCl = ((WebViewUI)paramd).getIntent().getStringExtra("preChatName");
            ((y)localObject2).dCk = ((WebViewUI)paramd).getIntent().getStringExtra("preUsername");
          }
          AppMethodBeat.o(189503);
          return localObject2;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.JsApiHandleMPPageAction", localException.getMessage());
        continue;
        boolean bool = false;
      }
    }
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189500);
    d.g.b.k.h(paramd, "env");
    d.g.b.k.h(paraml, "msg");
    Object localObject1 = (String)paraml.vUl.get("action");
    ac.i("MicroMsg.JsApiHandleMPPageAction", "handleMPPageAction action=%s", new Object[] { localObject1 });
    if (bs.isNullOrNil((String)localObject1))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail action is empty", null);
      AppMethodBeat.o(189500);
      return true;
    }
    Object localObject2;
    Object localObject3;
    if (d.g.b.k.g("enterEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(189500);
        return true;
      }
      localObject1 = e(paramd, paraml);
      localObject2 = paramd.context;
      if ((localObject2 instanceof WebViewUI))
      {
        float f2 = com.tencent.mm.cd.a.eSs();
        float f1 = f2;
        if (((WebViewUI)localObject2).eEt() != null)
        {
          localObject3 = ((WebViewUI)localObject2).eEt();
          d.g.b.k.g(localObject3, "ui.viewWV");
          f1 = f2;
          if (((MMWebView)localObject3).getWebCoreType() == WebView.c.KzZ)
          {
            f1 = f2;
            if (XWalkEnvironment.getUsingCustomContext())
            {
              localObject3 = ((WebViewUI)localObject2).eEt();
              d.g.b.k.g(localObject3, "ui.viewWV");
              localObject3 = ((MMWebView)localObject3).getResources();
              d.g.b.k.g(localObject3, "ui.viewWV.resources");
              f1 = ((Resources)localObject3).getDisplayMetrics().density;
            }
          }
        }
        i = ap.dT(paramd.context);
        int j = ap.ji(paramd.context);
        ((y)localObject1).hly = bs.getFloat((String)paraml.vUl.get("videoCurrTime"), 0.0F);
        ((y)localObject1).hlA = ((int)(bs.getFloat((String)paraml.vUl.get("playerX"), 0.0F) * f1));
        ((y)localObject1).hlB = ((int)(bs.getFloat((String)paraml.vUl.get("playerY"), 0.0F) * f1 + i + j));
        ((y)localObject1).hlC = ((int)(bs.getFloat((String)paraml.vUl.get("playerWidth"), 0.0F) * f1));
        ((y)localObject1).hlD = ((int)(bs.getFloat((String)paraml.vUl.get("playerHeight"), 0.0F) * f1));
        ((WebViewUI)localObject2).eDH().a((y)localObject1);
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      AppMethodBeat.o(189500);
      return true;
    }
    if (d.g.b.k.g("shareEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(189500);
        return true;
      }
      localObject1 = e(paramd, paraml);
      localObject2 = paramd.context;
      if ((localObject2 instanceof WebViewUI))
      {
        ((WebViewUI)localObject2).CAG.hhf = ((y)localObject1);
        ((y)localObject1).hlE = ((WebViewUI)localObject2).CzY;
        localObject3 = c.CKY;
        c.a((Context)localObject2, ((y)localObject1).hld, "", ((y)localObject1).title, ((y)localObject1).DWF, 2);
      }
      for (;;)
      {
        ac.i("MicroMsg.JsApiHandleMPPageAction", "shareEmbedMpVideo bizUsrName=" + ((y)localObject1).ddo + ", mpUrl=" + ((y)localObject1).DWF + ", videoUrl=" + ((y)localObject1).videoUrl + ", width=" + ((y)localObject1).width + ", height=" + ((y)localObject1).height + ", videoDuration=" + ((y)localObject1).videoDuration);
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
        h.wUl.f(18589, new Object[] { Integer.valueOf(14), Integer.valueOf(3) });
        AppMethodBeat.o(189500);
        return true;
        ac.e("MicroMsg.JsApiHandleMPPageAction", "not in WebViewUI now!");
      }
    }
    if (d.g.b.k.g("longPressEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(189500);
        return true;
      }
      localObject1 = e(paramd, paraml);
      if ((paramd.context instanceof WebViewUI))
      {
        localObject2 = paramd.context;
        if (localObject2 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          AppMethodBeat.o(189500);
          throw paramd;
        }
        ((y)localObject1).hlE = ((WebViewUI)localObject2).CzY;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.CLf;
      com.tencent.mm.plugin.webview.ui.tools.media.f.a(paramd.context, (y)localObject1, 1);
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      AppMethodBeat.o(189500);
      return true;
    }
    if (d.g.b.k.g("insertVideoNativeView", localObject1))
    {
      if ((paramd.context instanceof com.tencent.mm.plugin.webview.g.a.a))
      {
        localObject1 = paramd.context;
        if (localObject1 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.api.IBizVideoPage");
          AppMethodBeat.o(189500);
          throw paramd;
        }
        ((com.tencent.mm.plugin.webview.g.a.a)localObject1).S(paraml.vUl);
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      AppMethodBeat.o(189500);
      return true;
    }
    if (d.g.b.k.g("wxConfig", localObject1))
    {
      boolean bool = c(paramd, paraml);
      AppMethodBeat.o(189500);
      return bool;
    }
    if (d.g.b.k.g("sendMPPageData", localObject1))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("action", "sendMPPageData");
      localObject2 = paraml.vUl.get("data");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(189500);
        throw paramd;
      }
      ((Bundle)localObject1).putString("data", (String)localObject2);
      localObject2 = paraml.vUl.get("sendTo");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(189500);
        throw paramd;
      }
      ((Bundle)localObject1).putString("sendTo", (String)localObject2);
      if (!paraml.vUl.containsKey("webviewId")) {
        break label1435;
      }
      localObject2 = paraml.vUl.get("webviewId");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(189500);
        throw paramd;
      }
    }
    label1435:
    for (int i = bs.getInt((String)localObject2, 0);; i = 0)
    {
      ((Bundle)localObject1).putInt("webviewId", i);
      if ((paramd.context instanceof com.tencent.mm.plugin.webview.g.a.a))
      {
        localObject2 = paramd.context;
        if (localObject2 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.api.IBizVideoPage");
          AppMethodBeat.o(189500);
          throw paramd;
        }
        ((com.tencent.mm.plugin.webview.g.a.a)localObject2).R((Bundle)localObject1);
      }
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      AppMethodBeat.o(189500);
      return true;
      if (d.g.b.k.g("hasActivity", localObject1))
      {
        if ((paramd.context instanceof Activity)) {
          paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
        }
        for (;;)
        {
          AppMethodBeat.o(189500);
          return true;
          paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
        }
      }
      AppMethodBeat.o(189500);
      return false;
    }
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.g
 * JD-Core Version:    0.7.0.1
 */