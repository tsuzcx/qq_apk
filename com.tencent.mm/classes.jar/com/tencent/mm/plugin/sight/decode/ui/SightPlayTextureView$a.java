package com.tencent.mm.plugin.sight.decode.ui;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightPlayTextureView$a
  implements Runnable
{
  Surface qUg = null;
  
  public final void run()
  {
    AppMethodBeat.i(24976);
    if (this.qUg == null)
    {
      AppMethodBeat.o(24976);
      return;
    }
    this.qUg.release();
    AppMethodBeat.o(24976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.a
 * JD-Core Version:    0.7.0.1
 */