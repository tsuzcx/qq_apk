package com.tencent.mm.pluginsdk.ui.tools;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class VideoTextureView$2
  implements Runnable
{
  VideoTextureView$2(VideoTextureView paramVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(134065);
    try
    {
      if ((this.lxx != null) && (this.lxx.isValid()))
      {
        ae.i("MicroMsg.VideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.FDM.hashCode()), Integer.valueOf(this.lxx.hashCode()) });
        this.lxx.release();
      }
      AppMethodBeat.o(134065);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(134065);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */