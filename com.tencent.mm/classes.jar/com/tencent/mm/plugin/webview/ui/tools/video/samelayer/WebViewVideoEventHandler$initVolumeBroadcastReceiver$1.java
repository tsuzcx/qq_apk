package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.c.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import org.json.JSONException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initVolumeBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"})
public final class WebViewVideoEventHandler$initVolumeBroadcastReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(210108);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(210108);
      return;
    }
    if ((k.g("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
    {
      ac.d(j.d(this.CLZ), "initVolumeBroadcastReceiver onReceive action");
      try
      {
        paramContext = j.g(this.CLZ);
        j.a(this.CLZ, "onVolumeChange", paramContext);
        AppMethodBeat.o(210108);
        return;
      }
      catch (JSONException paramContext)
      {
        ac.e(j.d(this.CLZ), "OnXWebVideoError fail", new Object[] { paramContext });
      }
    }
    AppMethodBeat.o(210108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler.initVolumeBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */