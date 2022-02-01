package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/WebTransApi;", "", "()V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "weakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContentFromWebpage", "", "content", "", "setJSApiHandler", "Companion", "webview-sdk_release"})
public final class p
{
  public static final a POz;
  h PNo;
  private WeakReference<Context> sFh;
  
  static
  {
    AppMethodBeat.i(207731);
    POz = new a((byte)0);
    AppMethodBeat.o(207731);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void getContentFromWebpage(String paramString)
  {
    b localb = null;
    AppMethodBeat.i(207727);
    Object localObject = this.PNo;
    if (localObject != null) {}
    for (localObject = ((h)localObject).getContext();; localObject = null)
    {
      if (localObject != null)
      {
        h localh = this.PNo;
        localObject = localb;
        if (localh != null) {
          localObject = localh.getContext();
        }
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        this.sFh = new WeakReference(localObject);
        localObject = this.sFh;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        localObject = (Context)((WeakReference)localObject).get();
        if ((localObject instanceof b))
        {
          Log.i("MicroMsg.WebTransApi", "getContentFromWebpage");
          localb = (b)localObject;
          localObject = paramString;
          if (paramString == null) {
            localObject = "";
          }
          localb.bjx((String)localObject);
        }
      }
      AppMethodBeat.o(207727);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/jsapi/WebTransApi$Companion;", "", "()V", "TAG", "", "webview-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.p
 * JD-Core Version:    0.7.0.1
 */