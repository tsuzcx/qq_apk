package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initVolumeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$initVolumeBroadcastReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(210703);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(210703);
      return;
    }
    if ((p.j("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
    {
      Log.d(j.d(this.Jye), "initVolumeBroadcastReceiver onReceive action");
      try
      {
        paramContext = j.g(this.Jye);
        j.a(this.Jye, "onVolumeChange", paramContext);
        AppMethodBeat.o(210703);
        return;
      }
      catch (JSONException paramContext)
      {
        Log.e(j.d(this.Jye), "onVolumeChange fail " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(210703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.initVolumeBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */