package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initVolumeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$initVolumeBroadcastReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199480);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(199480);
      return;
    }
    if ((p.i("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
    {
      ae.d(j.d(this.EIp), "initVolumeBroadcastReceiver onReceive action");
      try
      {
        paramContext = j.g(this.EIp);
        j.a(this.EIp, "onVolumeChange", paramContext);
        AppMethodBeat.o(199480);
        return;
      }
      catch (JSONException paramContext)
      {
        ae.e(j.d(this.EIp), "onVolumeChange fail " + paramContext.getMessage());
      }
    }
    AppMethodBeat.o(199480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.initVolumeBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */