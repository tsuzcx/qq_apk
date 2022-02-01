package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class d
  extends a
{
  protected Bitmap mBmp;
  protected int zlX;
  protected int zlY;
  protected int zlZ;
  
  public d(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(179426);
    this.mBmp = paramBitmap;
    this.zlR = 14;
    this.mContext = paramContext;
    this.zlY = paramInt1;
    this.zlZ = paramInt2;
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.zlP = Math.min(paramContext.getDefaultDisplay().getWidth(), paramContext.getDefaultDisplay().getHeight());
    this.zlQ = paramInt3;
    this.zlX = ((int)(this.zlQ * 1.2D * 20.0D / paramInt4));
    ac.i(this.TAG, "FloatUpScene, w=" + this.zlP + ", h=" + this.zlQ + ", speed=" + this.zlX + ", duration=" + paramInt4);
    dST();
    AppMethodBeat.o(179426);
  }
  
  private void dST()
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
        i = this.zlQ;
        int i3 = (int)(2.5D * this.zlQ);
        int i4 = (i3 - i) / 4;
        m = i + this.zlZ / 2;
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
            break label412;
          }
          if (!((b)this.zlT.get(i2)).contains(localb.dSS())) {
            break label427;
          }
          i2 = 1;
          if (i2 == 0)
          {
            localb.setPaint(dSO());
            localArrayList.add(localb);
            j += 1;
            if (j < k) {
              break label409;
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
              break label418;
            }
          }
          else
          {
            i1 += 1;
            if (i1 <= 20) {
              break label436;
            }
            localb.setPaint(dSO());
            continue;
          }
        }
        else
        {
          ac.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.zlR + ", " + this);
          AppMethodBeat.o(179427);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e(this.TAG, "buildSprites, exp=" + localThrowable.toString());
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
  
  protected final int dSP()
  {
    AppMethodBeat.i(179428);
    if (this.zlT.isEmpty())
    {
      AppMethodBeat.o(179428);
      return 0;
    }
    int j = this.zlT.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.zlT.get(i);
      Point localPoint = localb.zme;
      localPoint.y -= this.zlX;
      if (localb.qHs)
      {
        if (localPoint.y > this.zlQ) {
          break label114;
        }
        localb.Qf(500);
        localb.qHs = false;
      }
      for (;;)
      {
        localb.i(localPoint);
        i += 1;
        break;
        label114:
        localb.setAlpha(0.0F);
      }
    }
    i = this.zlT.size();
    AppMethodBeat.o(179428);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.d
 * JD-Core Version:    0.7.0.1
 */