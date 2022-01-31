package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class OnlineVideoView$7
  implements b
{
  OnlineVideoView$7(OnlineVideoView paramOnlineVideoView) {}
  
  public final long bQp()
  {
    AppMethodBeat.i(38396);
    ab.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(this.rJD.hashCode()) });
    g.RM();
    g.RL().Ru().set(ac.a.yFa, Boolean.TRUE);
    try
    {
      if ((OnlineVideoView.w(this.rJD)) && (this.rJD.rJi != null))
      {
        int i = this.rJD.rJi.fVp;
        long l = i;
        AppMethodBeat.o(38396);
        return l;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(38396);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.7
 * JD-Core Version:    0.7.0.1
 */