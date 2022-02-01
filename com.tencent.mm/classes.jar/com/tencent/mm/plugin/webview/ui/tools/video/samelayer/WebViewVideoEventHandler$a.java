package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$BrightnessObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "weakEventHandler", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "(Landroid/os/Handler;Ljava/lang/ref/WeakReference;)V", "TAG", "", "onChange", "", "selfChange", "", "plugin-webview_release"})
public final class WebViewVideoEventHandler$a
  extends ContentObserver
{
  private final WeakReference<WebViewVideoEventHandler> Qwl;
  private final String TAG;
  
  public WebViewVideoEventHandler$a(Handler paramHandler, WeakReference<WebViewVideoEventHandler> paramWeakReference)
  {
    super(paramHandler);
    AppMethodBeat.i(226631);
    this.Qwl = paramWeakReference;
    this.TAG = "MicroMsg.BrightnessObserver";
    AppMethodBeat.o(226631);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(226629);
    Log.d(this.TAG, "onChange selfChange=".concat(String.valueOf(paramBoolean)));
    try
    {
      WebViewVideoEventHandler localWebViewVideoEventHandler = (WebViewVideoEventHandler)this.Qwl.get();
      if (localWebViewVideoEventHandler == null)
      {
        AppMethodBeat.o(226629);
        return;
      }
      p.j(localWebViewVideoEventHandler, "weakEventHandler.get() ?: return");
      JSONObject localJSONObject = WebViewVideoEventHandler.a(localWebViewVideoEventHandler);
      localJSONObject.put("selfChange", paramBoolean);
      WebViewVideoEventHandler.a(localWebViewVideoEventHandler, "onBrightnessChange", localJSONObject);
      AppMethodBeat.o(226629);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onBrightnessChange fail  " + localJSONException.getMessage());
      AppMethodBeat.o(226629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.a
 * JD-Core Version:    0.7.0.1
 */