package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class c
  extends a
{
  protected Bitmap mBmp;
  private int zlX;
  protected int zlY;
  protected int zlZ;
  
  public c(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(179423);
    this.mBmp = paramBitmap;
    this.zlR = 14;
    this.mContext = paramContext;
    this.zlY = paramInt1;
    this.zlZ = paramInt2;
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.zlP = Math.min(paramContext.getDefaultDisplay().getWidth(), paramContext.getDefaultDisplay().getHeight());
    this.zlQ = paramInt3;
    this.zlX = ((int)(this.zlQ * 1.2D * 20.0D / paramInt4));
    ac.i(this.TAG, "FallDownScene, w=" + this.zlP + ", h=" + this.zlQ + ", speed=" + this.zlX + ", duration=" + paramInt4);
    dST();
    AppMethodBeat.o(179423);
  }
  
  private void dST()
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
        i = -this.zlZ / 2;
        int i3 = -(int)(1.5D * this.zlQ);
        int i4 = (i3 - i) / 4;
        m = -this.zlZ / 2 + i;
        int k = 1;
        long l = System.currentTimeMillis();
        n = 0;
        int j = 0;
        i = m;
        if (n < this.zlR)
        {
          ArrayList localArrayList = this.zlT;
          i1 = 0;
          i2 = (int)f.ad(this.zlZ / 2, this.zlP - this.zlZ / 2);
          int i5 = (int)f.ad(m, i);
          int i6 = (int)f.ad(this.zlY, this.zlZ);
          b localb = new b(this.mContext, this.mBmp, i6, i6);
          localb.i(new Point(i2, i5));
          i2 = 0;
          if (i2 >= this.zlT.size()) {
            break label417;
          }
          if (!((b)this.zlT.get(i2)).contains(localb.dSS())) {
            break label432;
          }
          i2 = 1;
          if (i2 == 0)
          {
            localb.setPaint(dSO());
            localArrayList.add(localb);
            j += 1;
            if (j < k) {
              break label414;
            }
            j = 0;
            k += 1;
            i1 = i + i4;
            if (n + k + (k + 1) > this.zlR)
            {
              k = this.zlR;
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
            localb.setPaint(dSO());
            continue;
          }
        }
        else
        {
          ac.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.zlR + ", " + this);
          AppMethodBeat.o(179424);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e(this.TAG, "buildSprites, exp=" + localThrowable.toString());
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
  
  protected final int dSP()
  {
    AppMethodBeat.i(179425);
    if (this.zlT.isEmpty())
    {
      AppMethodBeat.o(179425);
      return 0;
    }
    int j = this.zlT.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)this.zlT.get(i);
      Point localPoint = localb.zme;
      localPoint.y += this.zlX;
      localb.i(localPoint);
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