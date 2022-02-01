package com.tencent.mm.plugin.sns.ui.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.animation.AccelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;

public final class g
  extends a
{
  protected int asf;
  protected Bitmap mBmp;
  protected Scroller mScroller;
  protected int zlY;
  protected int zlZ;
  protected float zmd;
  
  public g(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(179431);
    this.mBmp = paramBitmap;
    this.mContext = paramContext;
    this.zlY = paramInt3;
    this.zlZ = paramInt4;
    this.asf = paramInt5;
    this.zlP = paramInt1;
    this.zlQ = paramInt2;
    this.zmd = 2.16F;
    this.zlR = (paramInt1 * paramInt2 / this.zlZ / this.zlY / 12);
    ac.i(this.TAG, "RoateScene, w=" + this.zlP + ", h=" + this.zlQ + ", speed=" + this.zmd + ", duration=" + paramInt5 + ", spriteNum=" + this.zlR);
    dST();
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.mScroller.startScroll(1, 0, this.zlR, 0, paramInt5);
    AppMethodBeat.o(179431);
  }
  
  private void dST()
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
        if (i < this.zlR)
        {
          ArrayList localArrayList = this.zlT;
          int j = 0;
          k = (int)f.ad(this.zlZ / 2, this.zlP - this.zlZ / 2);
          int m = (int)f.ad(this.zlZ / 2, this.zlQ - this.zlZ / 2);
          int n = (int)f.ad(this.zlY, this.zlZ);
          b localb = new b(this.mContext, this.mBmp, n, n);
          localb.i(new Point(k, m));
          k = 0;
          if (k < this.zlT.size())
          {
            if (!((b)this.zlT.get(k)).contains(localb.dSS())) {
              break label313;
            }
            k = 1;
            if (k == 0)
            {
              localb.setPaint(dSO());
              localArrayList.add(localb);
              i += 1;
              continue;
            }
            j += 1;
            if (j <= 20) {
              break label320;
            }
            localb.setPaint(dSO());
            continue;
          }
        }
        else
        {
          ac.i(this.TAG, "buildSprites, time=" + (System.currentTimeMillis() - l) + ", count=" + this.zlR + ", " + this);
          AppMethodBeat.o(179432);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e(this.TAG, "buildSprites,exp=" + localThrowable.toString());
        AppMethodBeat.o(179432);
        return;
      }
      int k = 0;
      continue;
      k += 1;
    }
  }
  
  protected final int dSP()
  {
    int i = 1;
    AppMethodBeat.i(179433);
    if (this.zlT.isEmpty())
    {
      AppMethodBeat.o(179433);
      return 0;
    }
    if (this.mScroller.computeScrollOffset()) {}
    for (int j = this.mScroller.getCurrX();; j = 1)
    {
      if (j > this.zlT.size()) {
        i = this.zlT.size();
      }
      for (;;)
      {
        j = 0;
        while (j < i)
        {
          b localb = (b)this.zlT.get(j);
          localb.zmf += this.zmd;
          if (localb.qHs)
          {
            localb.qHs = false;
            localb.dSR();
            localb.Qf(1000);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */