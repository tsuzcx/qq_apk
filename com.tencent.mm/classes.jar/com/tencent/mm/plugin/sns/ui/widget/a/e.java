package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class e
  extends a
{
  protected Bitmap mBmp;
  protected int zlY;
  protected int zlZ;
  private float zma;
  private float zmb;
  
  public e(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(200685);
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.zlY = paramInt3;
    this.zlZ = paramInt4;
    this.zlP = paramInt1;
    this.zlQ = paramInt2;
    this.zlR = (paramInt1 * paramInt2 / this.zlZ / paramInt3 / 12);
    this.zma = (com.tencent.mm.cc.a.fromDPToPix(this.mContext, 170) / 50.0F);
    this.zmb = (com.tencent.mm.cc.a.fromDPToPix(this.mContext, 140) / 50.0F);
    ac.i(this.TAG, "LeftToRightScene, w=" + this.zlP + ", h=" + this.zlQ + ", mMinSpeed=" + this.zmb + ", mMaxSpeed=" + this.zma + ", duration=" + paramInt5 + ", FRAME_DELAY=20");
    dST();
    AppMethodBeat.o(200685);
  }
  
  private void dST()
  {
    AppMethodBeat.i(200686);
    for (;;)
    {
      int n;
      int i1;
      try
      {
        clear();
        i = -this.zlZ / 2;
        int i3 = -this.zlP;
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
          int i5 = (int)f.ad(m, i);
          int i6 = (int)f.ad(this.zlZ / 2, this.zlQ - this.zlZ / 2);
          i2 = 0;
          if (i2 >= this.zlT.size()) {
            break label414;
          }
          if (Math.abs(i6 - ((h)this.zlT.get(i2)).zme.y) >= this.zlZ) {
            break label441;
          }
          i2 = 1;
          break label417;
          i1 = Math.round(f.ad(this.zlY, this.zlZ));
          b localb = new b(this.mContext, this.mBmp, i1, i1);
          localb.i(new Point(i5, i6));
          localb.setPaint(dSO());
          localb.Qe(Math.round(f.ad(this.zmb, this.zma)));
          localArrayList.add(localb);
          j += 1;
          if (j < k) {
            break label411;
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
            break label432;
          }
        }
        else
        {
          ac.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.zlR + ", " + this);
          AppMethodBeat.o(200686);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e(this.TAG, "buildSprites, exp=" + localThrowable.toString());
        AppMethodBeat.o(200686);
        return;
      }
      int m = i;
      int i = i1;
      break label432;
      label411:
      break label432;
      label414:
      int i2 = 0;
      label417:
      if (i2 != 0) {
        if (i1 > 20)
        {
          continue;
          label432:
          n += 1;
          continue;
          label441:
          i2 += 1;
        }
        else
        {
          i1 += 1;
        }
      }
    }
  }
  
  protected final int dSP()
  {
    AppMethodBeat.i(200687);
    if (this.zlT.isEmpty())
    {
      AppMethodBeat.o(200687);
      return 0;
    }
    int j = this.zlT.size();
    int i = 0;
    while (i < j)
    {
      b localb = (b)this.zlT.get(i);
      Point localPoint = localb.zme;
      localPoint.x += localb.dSQ();
      if (localPoint.x > this.zlP + this.zlZ / 2)
      {
        localPoint.x = (-this.zlZ / 2);
        int k = (int)f.ad(-this.zlZ, this.zlZ);
        if ((localPoint.y + k > this.zlZ / 2) && (localPoint.y + k < this.zlQ - this.zlZ / 2)) {
          localPoint.y = (k + localPoint.y);
        }
      }
      localb.i(localPoint);
      i += 1;
    }
    AppMethodBeat.o(200687);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */