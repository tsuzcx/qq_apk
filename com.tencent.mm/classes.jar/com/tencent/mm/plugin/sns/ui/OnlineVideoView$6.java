package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class OnlineVideoView$6
  implements e.e
{
  OnlineVideoView$6(OnlineVideoView paramOnlineVideoView) {}
  
  public final void bSk()
  {
    AppMethodBeat.i(38395);
    ab.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
    try
    {
      OnlineVideoView.k(this.rJD);
      AppMethodBeat.o(38395);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OnlineVideoView", "texture view update. error " + localException.toString());
      AppMethodBeat.o(38395);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.6
 * JD-Core Version:    0.7.0.1
 */