package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class f
  extends a
{
  protected int ark;
  protected Bitmap mBmp;
  protected Scroller mScroller;
  protected int xZa;
  protected int xZb;
  protected float xZd;
  
  public f(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(179431);
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.xZa = paramInt3;
    this.xZb = paramInt4;
    this.ark = paramInt5;
    this.xYS = paramInt1;
    this.xYT = paramInt2;
    this.xZd = 2.16F;
    this.xYU = (paramInt1 * paramInt2 / this.xZb / this.xZa / 12);
    ad.i(this.TAG, "RoateScene, w=" + this.xYS + ", h=" + this.xYT + ", speed=" + this.xZd + ", duration=" + paramInt5 + ", spriteNum=" + this.xYU);
    dEu();
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.mScroller.startScroll(1, 0, this.xYU, 0, paramInt5);
    AppMethodBeat.o(179431);
  }
  
  private void dEu()
  {
    AppMethodBeat.i(179432);
    label313:
    label320:
    for (;;)
    {
      try
      {
        clear();
        long l = System.currentTimeMillis();
        int i = 0;
        if (i < this.xYU)
        {
          ArrayList localArrayList = this.xYW;
          int j = 0;
          k = (int)e.Z(this.xZb / 2, this.xYS - this.xZb / 2);
          int m = (int)e.Z(this.xZb / 2, this.xYT - this.xZb / 2);
          int n = (int)e.Z(this.xZa, this.xZb);
          b localb = new b(this.mContext, this.mBmp, n, n);
          localb.g(new Point(k, m));
          k = 0;
          if (k < this.xYW.size())
          {
            if (!((b)this.xYW.get(k)).contains(localb.dEt())) {
              break label313;
            }
            k = 1;
            if (k == 0)
            {
              localb.setPaint(dEq());
              localArrayList.add(localb);
              i += 1;
              continue;
            }
            j += 1;
            if (j <= 20) {
              break label320;
            }
            localb.setPaint(dEq());
            continue;
          }
        }
        else
        {
          ad.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.xYU + ", " + this);
          AppMethodBeat.o(179432);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e(this.TAG, "buildSprites,exp=" + localThrowable.toString());
        AppMethodBeat.o(179432);
        return;
      }
      int k = 0;
      continue;
      k += 1;
    }
  }
  
  protected final int dEr()
  {
    int i = 1;
    AppMethodBeat.i(179433);
    if (this.xYW.isEmpty())
    {
      AppMethodBeat.o(179433);
      return 0;
    }
    if (this.mScroller.computeScrollOffset()) {}
    for (int j = this.mScroller.getCurrX();; j = 1)
    {
      if (j > this.xYW.size()) {
        i = this.xYW.size();
      }
      for (;;)
      {
        j = 0;
        while (j < i)
        {
          b localb = (b)this.xYW.get(j);
          localb.xZf += this.xZd;
          if (localb.pYL)
          {
            localb.pYL = false;
            localb.dEs();
            localb.Oa(1000);
          }
          j += 1;
        }
        if (j > 0) {
          i = j;
        }
      }
      AppMethodBeat.o(179433);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */