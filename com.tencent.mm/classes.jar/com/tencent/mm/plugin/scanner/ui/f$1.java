package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements Runnable
{
  f$1(f paramf, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(81030);
    f.a(this.qxl).setImageBitmap(this.val$bitmap);
    f.a(this.qxl).setBackgroundColor(0);
    if (f.b(this.qxl) != null) {
      f.b(this.qxl).notifyDataSetChanged();
    }
    AppMethodBeat.o(81030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.f.1
 * JD-Core Version:    0.7.0.1
 */