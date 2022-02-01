package com.tencent.mm.plugin.sight.decode.ui;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SightPlayTextureView$a
  implements Runnable
{
  Surface DnG = null;
  
  public final void run()
  {
    AppMethodBeat.i(28646);
    if (this.DnG == null)
    {
      AppMethodBeat.o(28646);
      return;
    }
    this.DnG.release();
    AppMethodBeat.o(28646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.a
 * JD-Core Version:    0.7.0.1
 */