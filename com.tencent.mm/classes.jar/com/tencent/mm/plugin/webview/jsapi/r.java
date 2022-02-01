package com.tencent.mm.plugin.webview.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/WebTransApi;", "", "()V", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "weakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getContentFromWebpage", "", "content", "", "setJSApiHandler", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final a WEM;
  public j JZX;
  private WeakReference<Context> vKO;
  
  static
  {
    AppMethodBeat.i(295274);
    WEM = new a((byte)0);
    AppMethodBeat.o(295274);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void getContentFromWebpage(String paramString)
  {
    d locald = null;
    AppMethodBeat.i(295287);
    Object localObject = this.JZX;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null)
      {
        localObject = this.JZX;
        if (localObject != null) {
          break label115;
        }
      }
    }
    label115:
    for (localObject = locald;; localObject = ((j)localObject).getContext())
    {
      s.checkNotNull(localObject);
      this.vKO = new WeakReference(localObject);
      localObject = this.vKO;
      s.checkNotNull(localObject);
      localObject = (Context)((WeakReference)localObject).get();
      if ((localObject instanceof d))
      {
        Log.i("MicroMsg.WebTransApi", "getContentFromWebpage");
        locald = (d)localObject;
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        locald.bjj((String)localObject);
      }
      AppMethodBeat.o(295287);
      return;
      localObject = ((j)localObject).getContext();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/WebTransApi$Companion;", "", "()V", "TAG", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.r
 * JD-Core Version:    0.7.0.1
 */