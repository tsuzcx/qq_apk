package me.imid.swipebacklayout.lib;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.n;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class SwipeBackLayout$b
  extends a.a
{
  private boolean xpa;
  
  private SwipeBackLayout$b(SwipeBackLayout paramSwipeBackLayout) {}
  
  public final boolean Ia(int paramInt)
  {
    int i = 1;
    int j = SwipeBackLayout.b(this.xpb).gx(SwipeBackLayout.a(this.xpb), paramInt);
    if (j != 0)
    {
      if (SwipeBackLayout.b(this.xpb).gx(1, paramInt)) {
        SwipeBackLayout.a(this.xpb, 1);
      }
      while ((SwipeBackLayout.c(this.xpb) != null) && (!SwipeBackLayout.c(this.xpb).isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.c(this.xpb).iterator();
        while (localIterator.hasNext())
        {
          SwipeBackLayout.a locala = (SwipeBackLayout.a)localIterator.next();
          SwipeBackLayout.d(this.xpb);
          locala.qs();
        }
        if (SwipeBackLayout.b(this.xpb).gx(2, paramInt)) {
          SwipeBackLayout.a(this.xpb, 2);
        } else if (SwipeBackLayout.b(this.xpb).gx(8, paramInt)) {
          SwipeBackLayout.a(this.xpb, 8);
        }
      }
      this.xpa = true;
    }
    if ((SwipeBackLayout.a(this.xpb) == 1) || (SwipeBackLayout.a(this.xpb) == 2)) {
      if (!SwipeBackLayout.b(this.xpb).gw(2, paramInt))
      {
        paramInt = 1;
        i = paramInt;
      }
    }
    for (;;)
    {
      return j & i;
      paramInt = 0;
      break;
      if (SwipeBackLayout.a(this.xpb) == 8)
      {
        if (SwipeBackLayout.b(this.xpb).gw(1, paramInt)) {
          i = 0;
        }
      }
      else if (SwipeBackLayout.a(this.xpb) != 11) {
        i = 0;
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((SwipeBackLayout.d(this.xpb) & 0x1) != 0) {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.i(this.xpb) > SwipeBackLayout.j(this.xpb))))
      {
        i = i + SwipeBackLayout.f(this.xpb).getIntrinsicWidth() + 10;
        j = 0;
      }
    }
    for (;;)
    {
      if ((SwipeBackLayout.c(this.xpb) != null) && (!SwipeBackLayout.c(this.xpb).isEmpty()))
      {
        paramView = SwipeBackLayout.c(this.xpb).iterator();
        label311:
        for (;;)
        {
          if (!paramView.hasNext()) {
            break label313;
          }
          localObject = (SwipeBackLayout.a)paramView.next();
          if (i != 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (!((SwipeBackLayout.a)localObject).aK(bool)) {
              break label311;
            }
            return;
            i = 0;
            break;
            if ((SwipeBackLayout.d(this.xpb) & 0x2) != 0)
            {
              if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.i(this.xpb) > SwipeBackLayout.j(this.xpb)))) {}
              for (i = -(i + SwipeBackLayout.f(this.xpb).getIntrinsicWidth() + 10);; i = 0)
              {
                j = 0;
                break;
              }
            }
            if ((SwipeBackLayout.d(this.xpb) & 0x8) == 0) {
              break label638;
            }
            if ((paramFloat2 < 0.0F) || ((paramFloat2 == 0.0F) && (SwipeBackLayout.i(this.xpb) > SwipeBackLayout.j(this.xpb)))) {}
            for (i = -(SwipeBackLayout.h(this.xpb).getIntrinsicHeight() + j + 10);; i = 0)
            {
              j = i;
              i = 0;
              break;
            }
          }
        }
      }
      label313:
      paramView = SwipeBackLayout.b(this.xpb);
      if (!paramView.MX) {
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
      }
      int n = (int)paramView.fB.getXVelocity(paramView.fC);
      int i1 = (int)paramView.fB.getYVelocity(paramView.fC);
      int k = paramView.MW.getLeft();
      int m = paramView.MW.getTop();
      i -= k;
      j -= m;
      if ((i == 0) && (j == 0))
      {
        paramView.hBk.iY.abortAnimation();
        paramView.aP(0);
        this.xpb.invalidate();
        return;
      }
      Object localObject = paramView.MW;
      n = a.h(n, (int)paramView.MS, (int)paramView.MR);
      i1 = a.h(i1, (int)paramView.MS, (int)paramView.MR);
      int i2 = Math.abs(i);
      int i3 = Math.abs(j);
      int i4 = Math.abs(n);
      int i5 = Math.abs(i1);
      int i6 = i4 + i5;
      int i7 = i2 + i3;
      if (n != 0)
      {
        paramFloat1 = i4 / i6;
        label526:
        if (i1 == 0) {
          break label627;
        }
      }
      label627:
      for (paramFloat2 = i5 / i6;; paramFloat2 = i3 / i7)
      {
        n = paramView.g(i, n, paramView.xpd.cIF());
        i1 = paramView.g(j, i1, paramView.xpd.au());
        float f = n;
        n = (int)(paramFloat2 * i1 + paramFloat1 * f);
        paramView.hBk.startScroll(k, m, i, j, n);
        paramView.aP(2);
        break;
        paramFloat1 = i2 / i7;
        break label526;
      }
      label638:
      j = 0;
      i = 0;
    }
  }
  
  public final int au()
  {
    return SwipeBackLayout.a(this.xpb) & 0x8;
  }
  
  public final int c(View paramView, int paramInt)
  {
    int i = 0;
    if ((SwipeBackLayout.d(this.xpb) & 0x8) != 0) {
      i = Math.min(0, Math.max(paramInt, -paramView.getHeight()));
    }
    return i;
  }
  
  public final int cIF()
  {
    return SwipeBackLayout.a(this.xpb) & 0x3;
  }
  
  public final int d(View paramView, int paramInt)
  {
    int i = 0;
    if ((SwipeBackLayout.d(this.xpb) & 0x1) != 0) {
      i = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
    }
    while ((SwipeBackLayout.d(this.xpb) & 0x2) == 0) {
      return i;
    }
    return Math.min(0, Math.max(paramInt, -paramView.getWidth()));
  }
  
  public final void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.k(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((SwipeBackLayout.d(this.xpb) & 0x1) != 0) {
      SwipeBackLayout.a(this.xpb, Math.abs(paramInt1 / (SwipeBackLayout.e(this.xpb).getWidth() + SwipeBackLayout.f(this.xpb).getIntrinsicWidth())));
    }
    for (;;)
    {
      SwipeBackLayout.b(this.xpb, paramInt1);
      SwipeBackLayout.c(this.xpb, paramInt2);
      this.xpb.invalidate();
      if ((SwipeBackLayout.i(this.xpb) < SwipeBackLayout.j(this.xpb)) && (!this.xpa)) {
        this.xpa = true;
      }
      if ((SwipeBackLayout.c(this.xpb) == null) || (SwipeBackLayout.c(this.xpb).isEmpty())) {
        break;
      }
      paramView = SwipeBackLayout.c(this.xpb).iterator();
      while (paramView.hasNext()) {
        ((SwipeBackLayout.a)paramView.next()).e(SwipeBackLayout.b(this.xpb).MI, SwipeBackLayout.i(this.xpb));
      }
      if ((SwipeBackLayout.d(this.xpb) & 0x2) != 0) {
        SwipeBackLayout.a(this.xpb, Math.abs(paramInt1 / (SwipeBackLayout.e(this.xpb).getWidth() + SwipeBackLayout.g(this.xpb).getIntrinsicWidth())));
      } else if ((SwipeBackLayout.d(this.xpb) & 0x8) != 0) {
        SwipeBackLayout.a(this.xpb, Math.abs(paramInt2 / (SwipeBackLayout.e(this.xpb).getHeight() + SwipeBackLayout.h(this.xpb).getIntrinsicHeight())));
      }
    }
    if ((SwipeBackLayout.c(this.xpb) != null) && (!SwipeBackLayout.c(this.xpb).isEmpty()) && (SwipeBackLayout.b(this.xpb).MI == 1) && (SwipeBackLayout.i(this.xpb) >= SwipeBackLayout.j(this.xpb)) && (this.xpa))
    {
      this.xpa = false;
      paramView = SwipeBackLayout.c(this.xpb).iterator();
      while (paramView.hasNext()) {
        paramView.next();
      }
    }
    if ((SwipeBackLayout.i(this.xpb) >= 1.0F) && (SwipeBackLayout.c(this.xpb) != null) && (!SwipeBackLayout.c(this.xpb).isEmpty()))
    {
      paramView = SwipeBackLayout.c(this.xpb).iterator();
      while (paramView.hasNext()) {
        paramView.next();
      }
    }
  }
  
  public final void x(int paramInt)
  {
    super.x(paramInt);
    if ((SwipeBackLayout.c(this.xpb) != null) && (!SwipeBackLayout.c(this.xpb).isEmpty()))
    {
      Iterator localIterator = SwipeBackLayout.c(this.xpb).iterator();
      while (localIterator.hasNext()) {
        ((SwipeBackLayout.a)localIterator.next()).e(paramInt, SwipeBackLayout.i(this.xpb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout.b
 * JD-Core Version:    0.7.0.1
 */