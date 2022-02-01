package com.tencent.mm.pluginsdk.ui.tools;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class VideoPlayerTextureView$3
  implements Runnable
{
  VideoPlayerTextureView$3(VideoPlayerTextureView paramVideoPlayerTextureView, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(134039);
    try
    {
      if ((this.mEu != null) && (this.mEu.isValid()))
      {
        Log.i("MicroMsg.VideoPlayerTextureView", "%d release surface [%d]", new Object[] { Integer.valueOf(this.KwC.hashCode()), Integer.valueOf(this.mEu.hashCode()) });
        this.mEu.release();
      }
      AppMethodBeat.o(134039);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoPlayerTextureView", localException, "release Surface error", new Object[0]);
      AppMethodBeat.o(134039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView.3
 * JD-Core Version:    0.7.0.1
 */