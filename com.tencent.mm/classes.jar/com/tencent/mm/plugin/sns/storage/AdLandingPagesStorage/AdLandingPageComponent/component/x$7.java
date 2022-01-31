package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

final class x$7
  implements Runnable
{
  x$7(x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(37284);
    OfflineVideoView localOfflineVideoView = x.a(this.rxG);
    ab.i("MicroMsg.OfflineVideoView", "%d pause", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()) });
    ab.d("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()), bo.dtY() });
    localOfflineVideoView.rIX = false;
    if (localOfflineVideoView.kvG.isPlaying())
    {
      localOfflineVideoView.rIY = localOfflineVideoView.kvG.getCurrentPosition();
      ab.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()) });
      localOfflineVideoView.kvG.pause();
    }
    localOfflineVideoView.hideLoading();
    localOfflineVideoView.kvM.stopTimer();
    AppMethodBeat.o(37284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.7
 * JD-Core Version:    0.7.0.1
 */