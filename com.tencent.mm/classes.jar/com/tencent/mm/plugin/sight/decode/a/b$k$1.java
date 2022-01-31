package com.tencent.mm.plugin.sight.decode.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$k$1
  implements Runnable
{
  b$k$1(b.k paramk, View paramView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(70247);
    this.guT.setBackgroundDrawable(new BitmapDrawable(this.qTz));
    AppMethodBeat.o(70247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.k.1
 * JD-Core Version:    0.7.0.1
 */