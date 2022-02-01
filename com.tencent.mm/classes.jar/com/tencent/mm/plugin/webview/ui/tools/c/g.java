package com.tencent.mm.plugin.webview.ui.tools.c;

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
import com.tencent.mm.ai.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.media.MPVideoPlayFullScreenView;
import com.tencent.mm.plugin.webview.ui.tools.media.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleMPPageAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "checkParams", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "enterEmbedMpVideo", "fillMpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "handleMsg", "hasActivity", "insertVideoNativeView", "longPressEmbedMpVideo", "sendMPPageData", "shareEmbedMpVideo", "stringToBitmap", "Landroid/graphics/Bitmap;", "string", "wxConfig", "plugin-webview_release"})
public final class g
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int Bpa = 345;
  public static final g Btz;
  private static final String dAn = "handleMPPageAction";
  
  static
  {
    AppMethodBeat.i(82690);
    Btz = new g();
    Bpa = 345;
    dAn = "handleMPPageAction";
    AppMethodBeat.o(82690);
  }
  
  private static Bitmap ayF(String paramString)
  {
    AppMethodBeat.i(82689);
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.f.cl(Base64.decode((String)n.a((CharSequence)paramString, new String[] { "," }).get(1), 2));
      AppMethodBeat.o(82689);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiHandleMPPageAction", "stringToBitmap fail " + paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  private static boolean c(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188931);
    String str1 = (String)paraml.uLu.get("appid");
    String str3 = (String)paraml.uLu.get("webComptList");
    ad.i("MicroMsg.JsApiHandleMPPageAction", "wxConfig webComptList=" + str3 + ", appId=" + str1);
    Object localObject1;
    try
    {
      localObject1 = new JSONArray(str3);
      str3 = (String)paraml.uLu.get("url");
      if (str3 == null)
      {
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail invalid params", null);
        AppMethodBeat.o(188931);
        return true;
      }
      localObject2 = com.tencent.mm.plugin.webview.k.f.BAl;
      localObject1 = com.tencent.mm.plugin.webview.k.f.c(str3, (JSONArray)localObject1);
      if (bt.gL((List)localObject1))
      {
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail webComptList is null", null);
        AppMethodBeat.o(188931);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.JsApiHandleMPPageAction", "wxConfig ex " + localException.getMessage());
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail ex " + localException + ".message", null);
      AppMethodBeat.o(188931);
      return true;
    }
    Object localObject2 = paramd.ARd.ekz();
    String str2 = bt.by(localException, "");
    d.g.b.k.g(str2, "Util.nullAs(appId, \"\")");
    ((com.tencent.mm.plugin.webview.k.k)localObject2).c(str2, str3, (LinkedList)localObject1);
    paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
    AppMethodBeat.o(188931);
    return true;
  }
  
  private static boolean d(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188932);
    if (bt.isNullOrNil((String)paraml.uLu.get("mpUrl")))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail, mpUrl is null", null);
      AppMethodBeat.o(188932);
      return false;
    }
    if (bt.isNullOrNil((String)paraml.uLu.get("bizUsrName")))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail, bizUsrName is null", null);
      AppMethodBeat.o(188932);
      return false;
    }
    if (bt.isNullOrNil((String)paraml.uLu.get("videoUrl")))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail, videoUrl is null", null);
      AppMethodBeat.o(188932);
      return false;
    }
    if (bt.isNullOrNil((String)paraml.uLu.get("videoVid")))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail, videoVid is null", null);
      AppMethodBeat.o(188932);
      return false;
    }
    AppMethodBeat.o(188932);
    return true;
  }
  
  private static y e(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188933);
    String str1 = (String)paraml.uLu.get("mpUrl");
    String str2 = (String)paraml.uLu.get("bizUsrName");
    String str3 = (String)paraml.uLu.get("videoUrl");
    String str4 = (String)paraml.uLu.get("videoTitle");
    String str5 = (String)paraml.uLu.get("videoVid");
    String str6 = (String)paraml.uLu.get("bizNickName");
    Object localObject1 = paraml.uLu.get("videoThumbUrl");
    if (localObject1 == null)
    {
      paramd = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(188933);
      throw paramd;
    }
    localObject1 = (String)localObject1;
    Object localObject2 = (String)paraml.uLu.get("videoThumbData");
    String str7 = (String)paraml.uLu.get("headImgUrl");
    float f = bt.getFloat((String)paraml.uLu.get("videoDuration"), 0.0F);
    int j = bt.getInt((String)paraml.uLu.get("videoWidth"), 0);
    int i = bt.getInt((String)paraml.uLu.get("videoHeight"), 0);
    if (localObject2 != null)
    {
      localObject2 = ayF((String)localObject2);
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
        ax localax = ax.fF("MpShareVideoImage", 2);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localByteArrayOutputStream);
        localax.encode(str5, localByteArrayOutputStream.toByteArray());
        localObject2 = new y();
        ((y)localObject2).dfT = str2;
        ((y)localObject2).gKv = str6;
        ((y)localObject2).CEf = str1;
        ((y)localObject2).videoUrl = str3;
        ((y)localObject2).CEg = str5;
        ((y)localObject2).title = str4;
        ((y)localObject2).gKD = ((String)localObject1);
        ((y)localObject2).width = j;
        ((y)localObject2).height = i;
        ((y)localObject2).videoDuration = ((int)f);
        ((y)localObject2).gLg = str7;
        ((y)localObject2).url = "https://support.weixin.qq.com/update/";
        if (bt.getInt((String)paraml.uLu.get("forbidForward"), 0) == 1)
        {
          bool = true;
          ((y)localObject2).gLh = bool;
          paramd = paramd.context;
          if ((paramd instanceof WebViewUI))
          {
            ((y)localObject2).gKw = ((WebViewUI)paramd).getIntent().getStringExtra("prePublishId");
            ((y)localObject2).dEz = ((WebViewUI)paramd).getIntent().getStringExtra("preChatName");
            ((y)localObject2).dEy = ((WebViewUI)paramd).getIntent().getStringExtra("preUsername");
          }
          AppMethodBeat.o(188933);
          return localObject2;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.JsApiHandleMPPageAction", localException.getMessage());
        continue;
        boolean bool = false;
      }
    }
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(188930);
    d.g.b.k.h(paramd, "env");
    d.g.b.k.h(paraml, "msg");
    Object localObject1 = (String)paraml.uLu.get("action");
    ad.i("MicroMsg.JsApiHandleMPPageAction", "handleMPPageAction action=%s", new Object[] { localObject1 });
    if (bt.isNullOrNil((String)localObject1))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail action is empty", null);
      AppMethodBeat.o(188930);
      return true;
    }
    Object localObject2;
    Object localObject3;
    if (d.g.b.k.g("enterEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(188930);
        return true;
      }
      localObject1 = e(paramd, paraml);
      localObject2 = paramd.context;
      if ((localObject2 instanceof WebViewUI))
      {
        float f2 = com.tencent.mm.ce.a.eCY();
        float f1 = f2;
        if (((WebViewUI)localObject2).eoY() != null)
        {
          localObject3 = ((WebViewUI)localObject2).eoY();
          d.g.b.k.g(localObject3, "ui.viewWV");
          f1 = f2;
          if (((MMWebView)localObject3).getWebCoreType() == WebView.c.INC)
          {
            f1 = f2;
            if (XWalkEnvironment.getUsingCustomContext())
            {
              localObject3 = ((WebViewUI)localObject2).eoY();
              d.g.b.k.g(localObject3, "ui.viewWV");
              localObject3 = ((MMWebView)localObject3).getResources();
              d.g.b.k.g(localObject3, "ui.viewWV.resources");
              f1 = ((Resources)localObject3).getDisplayMetrics().density;
            }
          }
        }
        i = ap.dL(paramd.context);
        int j = ap.iX(paramd.context);
        ((y)localObject1).gKY = bt.getFloat((String)paraml.uLu.get("videoCurrTime"), 0.0F);
        ((y)localObject1).gLa = ((int)(bt.getFloat((String)paraml.uLu.get("playerX"), 0.0F) * f1));
        ((y)localObject1).gLb = ((int)(bt.getFloat((String)paraml.uLu.get("playerY"), 0.0F) * f1 + i + j));
        ((y)localObject1).gLc = ((int)(bt.getFloat((String)paraml.uLu.get("playerWidth"), 0.0F) * f1));
        ((y)localObject1).gLd = ((int)(bt.getFloat((String)paraml.uLu.get("playerHeight"), 0.0F) * f1));
        ((WebViewUI)localObject2).eom().a((y)localObject1);
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      AppMethodBeat.o(188930);
      return true;
    }
    if (d.g.b.k.g("shareEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(188930);
        return true;
      }
      localObject1 = e(paramd, paraml);
      localObject2 = paramd.context;
      if ((localObject2 instanceof WebViewUI))
      {
        ((WebViewUI)localObject2).Bit.gGE = ((y)localObject1);
        ((y)localObject1).gLe = ((WebViewUI)localObject2).BhL;
        localObject3 = c.BsS;
        c.a((Context)localObject2, ((y)localObject1).gKD, "", ((y)localObject1).title, ((y)localObject1).CEf, 2);
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiHandleMPPageAction", "shareEmbedMpVideo bizUsrName=" + ((y)localObject1).dfT + ", mpUrl=" + ((y)localObject1).CEf + ", videoUrl=" + ((y)localObject1).videoUrl + ", width=" + ((y)localObject1).width + ", height=" + ((y)localObject1).height + ", videoDuration=" + ((y)localObject1).videoDuration);
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
        h.vKh.f(18589, new Object[] { Integer.valueOf(14), Integer.valueOf(3) });
        AppMethodBeat.o(188930);
        return true;
        ad.e("MicroMsg.JsApiHandleMPPageAction", "not in WebViewUI now!");
      }
    }
    if (d.g.b.k.g("longPressEmbedMpVideo", localObject1))
    {
      if (!d(paramd, paraml))
      {
        AppMethodBeat.o(188930);
        return true;
      }
      localObject1 = e(paramd, paraml);
      if ((paramd.context instanceof WebViewUI))
      {
        localObject2 = paramd.context;
        if (localObject2 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          AppMethodBeat.o(188930);
          throw paramd;
        }
        ((y)localObject1).gLe = ((WebViewUI)localObject2).BhL;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.BsZ;
      com.tencent.mm.plugin.webview.ui.tools.media.f.a(paramd.context, (y)localObject1, 1);
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      AppMethodBeat.o(188930);
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
          AppMethodBeat.o(188930);
          throw paramd;
        }
        ((com.tencent.mm.plugin.webview.g.a.a)localObject1).S(paraml.uLu);
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      AppMethodBeat.o(188930);
      return true;
    }
    if (d.g.b.k.g("wxConfig", localObject1))
    {
      boolean bool = c(paramd, paraml);
      AppMethodBeat.o(188930);
      return bool;
    }
    if (d.g.b.k.g("sendMPPageData", localObject1))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("action", "sendMPPageData");
      localObject2 = paraml.uLu.get("data");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188930);
        throw paramd;
      }
      ((Bundle)localObject1).putString("data", (String)localObject2);
      localObject2 = paraml.uLu.get("sendTo");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188930);
        throw paramd;
      }
      ((Bundle)localObject1).putString("sendTo", (String)localObject2);
      if (!paraml.uLu.containsKey("webviewId")) {
        break label1435;
      }
      localObject2 = paraml.uLu.get("webviewId");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(188930);
        throw paramd;
      }
    }
    label1435:
    for (int i = bt.getInt((String)localObject2, 0);; i = 0)
    {
      ((Bundle)localObject1).putInt("webviewId", i);
      if ((paramd.context instanceof com.tencent.mm.plugin.webview.g.a.a))
      {
        localObject2 = paramd.context;
        if (localObject2 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.api.IBizVideoPage");
          AppMethodBeat.o(188930);
          throw paramd;
        }
        ((com.tencent.mm.plugin.webview.g.a.a)localObject2).Q((Bundle)localObject1);
      }
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      AppMethodBeat.o(188930);
      return true;
      if (d.g.b.k.g("hasActivity", localObject1))
      {
        if ((paramd.context instanceof Activity)) {
          paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
        }
        for (;;)
        {
          AppMethodBeat.o(188930);
          return true;
          paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
        }
      }
      AppMethodBeat.o(188930);
      return false;
    }
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.g
 * JD-Core Version:    0.7.0.1
 */