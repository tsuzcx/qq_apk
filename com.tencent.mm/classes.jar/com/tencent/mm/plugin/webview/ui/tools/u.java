package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.ui.tools.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewVideoFullScreenHelper;", "Lcom/tencent/mm/plugin/webview/ui/tools/BaseWebViewHelper;", "webViewUI", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;)V", "currentOrientation", "", "fullScreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "preOrientation", "webViewVideoOrientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "alive", "", "dead", "initOrientationListenerHelper", "isLockRotation", "", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends a
{
  public static final a WZG;
  private int PSI;
  com.tencent.mm.bj.a WZH;
  c WZI;
  private int cEQ;
  
  static
  {
    AppMethodBeat.i(296122);
    WZG = new a((byte)0);
    AppMethodBeat.o(296122);
  }
  
  public u(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(296111);
    this.PSI = -1;
    this.WZI = ((c)new c(this));
    AppMethodBeat.o(296111);
  }
  
  private static final void a(u paramu, a.a parama1, a.a parama2)
  {
    AppMethodBeat.i(296115);
    s.u(paramu, "this$0");
    if (parama2 == null) {}
    for (int i = -1;; i = u.b.$EnumSwitchMapping$0[parama2.ordinal()]) {
      switch (i)
      {
      default: 
        AppMethodBeat.o(296115);
        return;
      }
    }
    i = 90;
    for (;;)
    {
      paramu.cEQ = i;
      if (paramu.cEQ != paramu.PSI) {
        break;
      }
      AppMethodBeat.o(296115);
      return;
      i = -90;
      continue;
      i = 0;
      continue;
      i = 180;
    }
    paramu.PSI = paramu.cEQ;
    Log.i("MicroMsg.WebViewVideoFullScreenHelper", s.X("onOrientationsChange currentOrientation=", Integer.valueOf(paramu.cEQ)));
    for (;;)
    {
      try
      {
        parama1 = paramu.iwO();
        if (parama1 == null) {
          continue;
        }
        parama1 = parama1.WlX;
        if (parama1 == null) {
          continue;
        }
        int j = paramu.cEQ;
        i = Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation", 0);
        Log.i("MicroMsg.WebViewVideoFullScreenHelper", s.X("accRotation=", Integer.valueOf(i)));
        if (i == 0)
        {
          i = 1;
          break label314;
          if (parama1.UcS)
          {
            paramu = new HashMap();
            paramu.put("newOrientation", Integer.valueOf(j));
            paramu.put("sysLock", Integer.valueOf(i));
            paramu = p.a.b("onOrientationsChange", paramu, parama1.WDI, parama1.KQY);
            parama1.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramu + ")", null);
          }
          AppMethodBeat.o(296115);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException paramu)
      {
        Log.e("MicroMsg.WebViewVideoFullScreenHelper", "onOrientationsChange fail", new Object[] { paramu });
        AppMethodBeat.o(296115);
        return;
      }
      i = 0;
      continue;
      label314:
      if (i != 0) {
        i = 1;
      }
    }
  }
  
  final void izA()
  {
    AppMethodBeat.i(296128);
    if (iwO() == null)
    {
      Log.e("MicroMsg.WebViewVideoFullScreenHelper", "initOrientationListenerHelper  fail, ui is null");
      AppMethodBeat.o(296128);
      return;
    }
    this.WZH = new com.tencent.mm.bj.a((Context)iwO(), new u..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(296128);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewVideoFullScreenHelper$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/WebViewVideoFullScreenHelper$fullScreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends c
  {
    c(u paramu) {}
    
    public final void aqb()
    {
      AppMethodBeat.i(296092);
      try
      {
        localObject = this.WZJ.iwO();
        if (localObject != null)
        {
          localObject = ((WebViewUI)localObject).WlX;
          if ((localObject != null) && (((j)localObject).UcS))
          {
            String str = p.a.b("onExitFullscreen", new HashMap(), ((j)localObject).WDI, ((j)localObject).KQY);
            ((j)localObject).WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          Log.e("MicroMsg.WebViewVideoFullScreenHelper", "onExitFullscreen fail", new Object[] { localJSONException });
        }
      }
      localObject = u.a(this.WZJ);
      if (localObject != null) {
        ((com.tencent.mm.bj.a)localObject).disable();
      }
      AppMethodBeat.o(296092);
    }
    
    public final void cpc()
    {
      AppMethodBeat.i(296098);
      try
      {
        localObject = this.WZJ.iwO();
        if (localObject != null)
        {
          localObject = ((WebViewUI)localObject).WlX;
          if ((localObject != null) && (((j)localObject).UcS))
          {
            String str = p.a.b("onEnterFullscreen", new HashMap(), ((j)localObject).WDI, ((j)localObject).KQY);
            ((j)localObject).WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          Log.e("MicroMsg.WebViewVideoFullScreenHelper", "onEnterFullscreen fail", new Object[] { localJSONException });
        }
      }
      localObject = u.a(this.WZJ);
      if (localObject != null) {
        ((com.tencent.mm.bj.a)localObject).enable();
      }
      AppMethodBeat.o(296098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.u
 * JD-Core Version:    0.7.0.1
 */