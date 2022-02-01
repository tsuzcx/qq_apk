package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SynchronizedVideoPlayTextureView$1
  implements Runnable
{
  public SynchronizedVideoPlayTextureView$1(SynchronizedVideoPlayTextureView paramSynchronizedVideoPlayTextureView) {}
  
  public final void run()
  {
    AppMethodBeat.i(169156);
    synchronized (SynchronizedVideoPlayTextureView.a(this.FkT))
    {
      SynchronizedVideoPlayTextureView.b(this.FkT);
      AppMethodBeat.o(169156);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */