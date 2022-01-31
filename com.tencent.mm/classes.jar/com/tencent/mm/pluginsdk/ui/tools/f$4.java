package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class f$4
  implements Runnable
{
  f$4(f paramf, SparseArray paramSparseArray, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(79929);
    ab.i("MicroMsg.ImageEngine", "begin do recycled");
    int i = 0;
    while (i < this.weQ.size())
    {
      Bitmap localBitmap = (Bitmap)this.weQ.valueAt(i);
      if (localBitmap != null)
      {
        ab.d("MicroMsg.ImageEngine", "recycled def bmp %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      i += 1;
    }
    this.weQ.clear();
    ab.i("MicroMsg.ImageEngine", "clear drawable cache");
    this.weR.clear();
    ab.i("MicroMsg.ImageEngine", "end do recycled");
    AppMethodBeat.o(79929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.4
 * JD-Core Version:    0.7.0.1
 */