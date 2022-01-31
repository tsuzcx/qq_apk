package com.tencent.mm.pluginsdk.ui.tools;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$2
  implements Runnable
{
  VideoTextureView$2(VideoTextureView paramVideoTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(146030);
    try
    {
      if ((this.wfH != null) && (this.wfH.isValid()))
      {
        ab.i("MicroMsg.VideoTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.wga.hashCode()), Integer.valueOf(this.wfH.hashCode()) });
        this.wfH.release();
      }
      AppMethodBeat.o(146030);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(146030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */