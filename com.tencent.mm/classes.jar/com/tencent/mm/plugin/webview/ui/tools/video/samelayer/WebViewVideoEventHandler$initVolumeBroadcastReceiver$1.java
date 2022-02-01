package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import org.json.JSONException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initVolumeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$initVolumeBroadcastReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(207706);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(207706);
      return;
    }
    if ((p.i("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
    {
      ad.d(j.d(this.EpZ), "initVolumeBroadcastReceiver onReceive action");
      try
      {
        paramContext = j.g(this.EpZ);
        j.a(this.EpZ, "onVolumeChange", paramContext);
        AppMethodBeat.o(207706);
        return;
      }
      catch (JSONException paramContext)
      {
        ad.e(j.d(this.EpZ), "onVolumeChange fail " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(207706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.initVolumeBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */