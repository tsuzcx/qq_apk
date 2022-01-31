package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class a$1
  implements Runnable
{
  a$1(a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(80898);
    a.a(this.qvx).setImageBitmap(this.val$bitmap);
    a.a(this.qvx).setVisibility(0);
    if (a.b(this.qvx) != null) {
      a.b(this.qvx).notifyDataSetChanged();
    }
    AppMethodBeat.o(80898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a.1
 * JD-Core Version:    0.7.0.1
 */