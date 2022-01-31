package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.e.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements e.b
{
  f$2(f paramf, Bitmap paramBitmap) {}
  
  public final int bl(int paramInt1, int paramInt2)
  {
    f.a(this.rZJ).JU();
    y.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      o.JQ();
      Bitmap localBitmap = d.kh(f.b(this.rZJ));
      if (localBitmap != null)
      {
        f localf = this.rZJ;
        o.JQ();
        f.a(localf, localBitmap, d.z(f.b(this.rZJ), true));
        if (f.c(this.rZJ) != null)
        {
          f.c(this.rZJ);
          f.b(this.rZJ);
        }
      }
    }
    do
    {
      return 0;
      f.a(this.rZJ, this.nSs, null);
      break;
      f.a(this.rZJ, this.nSs, null);
    } while (f.c(this.rZJ) == null);
    f.c(this.rZJ);
    f.b(this.rZJ);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.f.2
 * JD-Core Version:    0.7.0.1
 */