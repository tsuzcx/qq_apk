package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class c
  extends a
{
  protected Bitmap mBmp;
  private int xYZ;
  protected int xZa;
  protected int xZb;
  
  public c(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(179423);
    this.mBmp = paramBitmap;
    this.xYU = 14;
    this.mContext = paramContext;
    this.xZa = paramInt1;
    this.xZb = paramInt2;
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.xYS = Math.min(paramContext.getDefaultDisplay().getWidth(), paramContext.getDefaultDisplay().getHeight());
    this.xYT = paramInt3;
    this.xYZ = ((int)(this.xYT * 1.2D * 20.0D / paramInt4));
    ad.i(this.TAG, "FallDownScene, w=" + this.xYS + ", h=" + this.xYT + ", speed=" + this.xYZ + ", duration=" + paramInt4);
    dEu();
    AppMethodBeat.o(179423);
  }
  
  private void dEu()
  {
    AppMethodBeat.i(179424);
    label414:
    label417:
    label423:
    label432:
    label441:
    for (;;)
    {
      int n;
      int i1;
      try
      {
        clear();
        i = -this.xZb / 2;
        int i3 = -(int)(1.5D * this.xYT);
        int i4 = (i3 - i) / 4;
        m = -this.xZb / 2 + i;
        int k = 1;
        long l = System.currentTimeMillis();
        n = 0;
        int j = 0;
        i = m;
        if (n < this.xYU)
        {
          ArrayList localArrayList = this.xYW;
          i1 = 0;
          i2 = (int)e.Z(this.xZb / 2, this.xYS - this.xZb / 2);
          int i5 = (int)e.Z(m, i);
          int i6 = (int)e.Z(this.xZa, this.xZb);
          b localb = new b(this.mContext, this.mBmp, i6, i6);
          localb.g(new Point(i2, i5));
          i2 = 0;
          if (i2 >= this.xYW.size()) {
            break label417;
          }
          if (!((b)this.xYW.get(i2)).contains(localb.dEt())) {
            break label432;
          }
          i2 = 1;
          if (i2 == 0)
          {
            localb.setPaint(dEq());
            localArrayList.add(localb);
            j += 1;
            if (j < k) {
              break label414;
            }
            j = 0;
            k += 1;
            i1 = i + i4;
            if (n + k + (k + 1) > this.xYU)
            {
              k = this.xYU;
              m = i3;
              i1 = i;
              i = m;
              m = i1;
              break label423;
            }
          }
          else
          {
            i1 += 1;
            if (i1 <= 20) {
              break label441;
            }
            localb.setPaint(dEq());
            continue;
          }
        }
        else
        {
          ad.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.xYU + ", " + this);
          AppMethodBeat.o(179424);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e(this.TAG, "buildSprites, exp=" + localThrowable.toString());
        AppMethodBeat.o(179424);
        return;
      }
      int m = i;
      int i = i1;
      break label423;
      break label423;
      int i2 = 0;
      continue;
      n += 1;
      continue;
      i2 += 1;
    }
  }
  
  protected final int dEr()
  {
    AppMethodBeat.i(179425);
    if (this.xYW.isEmpty())
    {
      AppMethodBeat.o(179425);
      return 0;
    }
    int j = this.xYW.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)this.xYW.get(i);
      Point localPoint = localb.xZe;
      localPoint.y += this.xYZ;
      localb.g(localPoint);
      i += 1;
    }
    AppMethodBeat.o(179425);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.c
 * JD-Core Version:    0.7.0.1
 */