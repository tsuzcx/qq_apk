package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class OnlineVideoView$7
  implements b
{
  OnlineVideoView$7(OnlineVideoView paramOnlineVideoView) {}
  
  public final long bin()
  {
    y.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[] { Integer.valueOf(this.oRM.hashCode()) });
    g.DQ();
    g.DP().Dz().c(ac.a.uuT, Boolean.valueOf(true));
    try
    {
      if ((OnlineVideoView.x(this.oRM)) && (OnlineVideoView.k(this.oRM) != null))
      {
        int i = OnlineVideoView.k(this.oRM).eFy;
        return i;
      }
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.7
 * JD-Core Version:    0.7.0.1
 */