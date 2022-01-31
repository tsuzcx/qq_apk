package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$d
  implements Runnable
{
  ImageView cuM;
  Bitmap nfX;
  
  private f$d(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(79940);
    if (this.cuM != null)
    {
      if ((this.nfX == null) || (!this.nfX.isRecycled())) {
        break label63;
      }
      f.c.l(this.cuM);
    }
    for (;;)
    {
      this.cuM = null;
      this.nfX = null;
      this.weP.weL.cr(this);
      AppMethodBeat.o(79940);
      return;
      label63:
      f.c.d(this.cuM, this.nfX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.d
 * JD-Core Version:    0.7.0.1
 */