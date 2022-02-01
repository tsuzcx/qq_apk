package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Color;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarColor;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "setNavigationBarColor", "plugin-webview_release"})
public final class aa
  extends a
{
  private static final int IIl = 182;
  public static final aa QvM;
  private static final String TAG = "MicroMsg.JsApiSetNavigationBarColor";
  private static final String fXz = "setNavigationBarColor";
  
  static
  {
    AppMethodBeat.i(262940);
    QvM = new aa();
    TAG = "MicroMsg.JsApiSetNavigationBarColor";
    IIl = 182;
    fXz = "setNavigationBarColor";
    AppMethodBeat.o(262940);
  }
  
  private static boolean k(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    i = -1;
    AppMethodBeat.i(262937);
    Log.i(TAG, "setNavigationBarColor");
    boolean bool = p.h("1", (String)paramn.params.get("actionCode"));
    localBundle = new Bundle();
    if (bool) {
      localBundle.putBoolean("set_navigation_bar_color_reset", true);
    }
    for (;;)
    {
      paramn = paramf.context;
      paramf = paramn;
      if (!(paramn instanceof WebViewUI)) {
        paramf = null;
      }
      paramf = (WebViewUI)paramf;
      if (paramf != null)
      {
        paramf = paramf.POP;
        if (paramf != null) {
          paramf.l(53, localBundle);
        }
      }
      AppMethodBeat.o(262937);
      return true;
      try
      {
        localObject2 = ab.bsf((String)paramn.params.get("wxcolor"));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = (String)paramn.params.get("color");
        }
        j = Color.parseColor((String)localObject1);
        k = j | 0xFF000000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1;
          Log.e(TAG, localException.getMessage());
          localBundle.putBoolean("set_navigation_bar_color_reset", true);
          int k = -1;
          continue;
          m = 0;
          continue;
          m = 0;
        }
      }
      j = i;
      try
      {
        localObject1 = (String)paramn.params.get("alpha");
        j = i;
        localObject2 = (CharSequence)localObject1;
        if (localObject2 == null) {
          break label398;
        }
        j = i;
        if (!kotlin.n.n.ba((CharSequence)localObject2)) {
          break;
        }
      }
      catch (Exception paramn)
      {
        for (;;)
        {
          i = j;
          Log.e(TAG, paramn.getMessage());
          continue;
          i = j;
          continue;
          int m = 1;
          continue;
          i = 255;
          continue;
          m = 1;
        }
      }
      j = i;
      if (m != 0) {
        break label393;
      }
      j = i;
      m = (int)(Util.getFloat((String)localObject1, 1.0F) * 255.0F);
      if (m < 0) {
        break label404;
      }
      i = m;
      if (m > 255) {
        break label404;
      }
      j = i;
      paramn = (String)paramn.params.get("titleAlphaAdjustment");
      j = i;
      localObject1 = (CharSequence)paramn;
      if (localObject1 == null) {
        break label411;
      }
      j = i;
      if (!kotlin.n.n.ba((CharSequence)localObject1)) {
        break label371;
      }
      break label411;
      j = i;
      if (m != 0) {
        break label393;
      }
      j = i;
      localBundle.putBoolean("set_navigation_bar_color_titleAlphaAdjustment", Util.getBoolean(paramn, false));
      localBundle.putInt("set_navigation_bar_color_color", k);
      localBundle.putInt("set_navigation_bar_color_alpha", i);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(262934);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    k(paramf, paramn);
    paramf.PNo.h(paramn.POu, "setNavigationBarColor:ok", null);
    AppMethodBeat.o(262934);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.aa
 * JD-Core Version:    0.7.0.1
 */