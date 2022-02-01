package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$VolumeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "weakEventHandler", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$VolumeBroadcastReceiver
  extends BroadcastReceiver
{
  private final WeakReference<WebViewVideoEventHandler> Qwl;
  private final String TAG;
  
  public WebViewVideoEventHandler$VolumeBroadcastReceiver(WeakReference<WebViewVideoEventHandler> paramWeakReference)
  {
    AppMethodBeat.i(216269);
    this.Qwl = paramWeakReference;
    this.TAG = "MicroMsg.VolumeBroadcastReceiver";
    AppMethodBeat.o(216269);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(216265);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(216265);
      return;
    }
    if ((p.h("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
    {
      Log.d(this.TAG, "onReceive action");
      try
      {
        paramContext = (WebViewVideoEventHandler)this.Qwl.get();
        if (paramContext != null) {
          break label105;
        }
        AppMethodBeat.o(216265);
        return;
      }
      catch (JSONException paramContext)
      {
        Log.e(this.TAG, "onVolumeChange fail " + paramContext.getMessage());
      }
    }
    else
    {
      AppMethodBeat.o(216265);
      return;
    }
    label105:
    p.j(paramContext, "weakEventHandler.get() ?: return");
    WebViewVideoEventHandler.a(paramContext, "onVolumeChange", WebViewVideoEventHandler.a(paramContext));
    AppMethodBeat.o(216265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.VolumeBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */