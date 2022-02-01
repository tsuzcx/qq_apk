package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class d
  extends a
{
  protected Bitmap mBmp;
  protected int xYZ;
  protected int xZa;
  protected int xZb;
  
  public d(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(179426);
    this.mBmp = paramBitmap;
    this.xYU = 14;
    this.mContext = paramContext;
    this.xZa = paramInt1;
    this.xZb = paramInt2;
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.xYS = Math.min(paramContext.getDefaultDisplay().getWidth(), paramContext.getDefaultDisplay().getHeight());
    this.xYT = paramInt3;
    this.xYZ = ((int)(this.xYT * 1.2D * 20.0D / paramInt4));
    ad.i(this.TAG, "FloatUpScene, w=" + this.xYS + ", h=" + this.xYT + ", speed=" + this.xYZ + ", duration=" + paramInt4);
    dEu();
    AppMethodBeat.o(179426);
  }
  
  private void dEu()
  {
    AppMethodBeat.i(179427);
    label409:
    label412:
    label418:
    label427:
    label436:
    for (;;)
    {
      int n;
      int i1;
      try
      {
        clear();
        i = this.xYT;
        int i3 = (int)(2.5D * this.xYT);
        int i4 = (i3 - i) / 4;
        m = i + this.xZb / 2;
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
            break label412;
          }
          if (!((b)this.xYW.get(i2)).contains(localb.dEt())) {
            break label427;
          }
          i2 = 1;
          if (i2 == 0)
          {
            localb.setPaint(dEq());
            localArrayList.add(localb);
            j += 1;
            if (j < k) {
              break label409;
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
              break label418;
            }
          }
          else
          {
            i1 += 1;
            if (i1 <= 20) {
              break label436;
            }
            localb.setPaint(dEq());
            continue;
          }
        }
        else
        {
          ad.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.xYU + ", " + this);
          AppMethodBeat.o(179427);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e(this.TAG, "buildSprites, exp=" + localThrowable.toString());
        AppMethodBeat.o(179427);
        return;
      }
      int m = i;
      int i = i1;
      break label418;
      break label418;
      int i2 = 0;
      continue;
      n += 1;
      continue;
      i2 += 1;
    }
  }
  
  protected final int dEr()
  {
    AppMethodBeat.i(179428);
    if (this.xYW.isEmpty())
    {
      AppMethodBeat.o(179428);
      return 0;
    }
    int j = this.xYW.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.xYW.get(i);
      Point localPoint = localb.xZe;
      localPoint.y -= this.xYZ;
      if (localb.pYL)
      {
        if (localPoint.y > this.xYT) {
          break label114;
        }
        localb.Oa(500);
        localb.pYL = false;
      }
      for (;;)
      {
        localb.g(localPoint);
        i += 1;
        break;
        label114:
        localb.setAlpha(0.0F);
      }
    }
    i = this.xYW.size();
    AppMethodBeat.o(179428);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */