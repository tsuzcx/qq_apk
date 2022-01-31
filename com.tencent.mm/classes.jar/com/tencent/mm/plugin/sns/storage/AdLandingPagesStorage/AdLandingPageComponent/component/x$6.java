package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class x$6
  implements Runnable
{
  x$6(x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(37283);
    OfflineVideoView localOfflineVideoView = x.a(this.rxG);
    ab.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b], curPos [%d], duration [%d], shouldSeek [%d]", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()), Boolean.valueOf(localOfflineVideoView.rIW), Integer.valueOf(localOfflineVideoView.kvG.getCurrentPosition()), Integer.valueOf(localOfflineVideoView.kvG.getDuration()), Integer.valueOf(localOfflineVideoView.rIY) });
    localOfflineVideoView.rIX = true;
    if (localOfflineVideoView.rIW) {
      if (!bo.isNullOrNil(localOfflineVideoView.kvG.getVideoPath())) {
        if (localOfflineVideoView.kvG.getCurrentPosition() >= localOfflineVideoView.kvG.getDuration())
        {
          localOfflineVideoView.kvG.e(0.0D, true);
          if (localOfflineVideoView.rIV != null) {
            localOfflineVideoView.rIV.onStart(localOfflineVideoView.duration);
          }
        }
      }
    }
    for (;;)
    {
      localOfflineVideoView.startTimer();
      AppMethodBeat.o(37283);
      return;
      localOfflineVideoView.kvG.start();
      continue;
      localOfflineVideoView.onResume();
      continue;
      localOfflineVideoView.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.6
 * JD-Core Version:    0.7.0.1
 */