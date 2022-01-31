package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;

final class g$5
  implements Runnable
{
  g$5(g paramg, SparseArray paramSparseArray, g.c paramc) {}
  
  public final void run()
  {
    y.i("MicroMsg.ImageEngine", "begin do recycled");
    int i = 0;
    while (i < this.smo.size())
    {
      Bitmap localBitmap = (Bitmap)this.smo.valueAt(i);
      if (localBitmap != null)
      {
        y.d("MicroMsg.ImageEngine", "recycled def bmp %s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      i += 1;
    }
    this.smo.clear();
    y.i("MicroMsg.ImageEngine", "clear drawable cache");
    this.smp.clear();
    y.i("MicroMsg.ImageEngine", "end do recycled");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.5
 * JD-Core Version:    0.7.0.1
 */