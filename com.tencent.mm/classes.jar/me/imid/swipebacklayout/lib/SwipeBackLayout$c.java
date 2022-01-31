package me.imid.swipebacklayout.lib;

import android.graphics.drawable.Drawable;
import android.support.v4.widget.p;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class SwipeBackLayout$c
  extends a.a
{
  private boolean CLc;
  
  private SwipeBackLayout$c(SwipeBackLayout paramSwipeBackLayout) {}
  
  public final boolean QM(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(91200);
    int j = SwipeBackLayout.b(this.CLd).iM(SwipeBackLayout.a(this.CLd), paramInt);
    if (j != 0)
    {
      if (SwipeBackLayout.b(this.CLd).iM(1, paramInt)) {
        SwipeBackLayout.a(this.CLd, 1);
      }
      while ((SwipeBackLayout.c(this.CLd) != null) && (!SwipeBackLayout.c(this.CLd).isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.c(this.CLd).iterator();
        while (localIterator.hasNext())
        {
          SwipeBackLayout.a locala = (SwipeBackLayout.a)localIterator.next();
          SwipeBackLayout.d(this.CLd);
          locala.uA();
        }
        if (SwipeBackLayout.b(this.CLd).iM(2, paramInt)) {
          SwipeBackLayout.a(this.CLd, 2);
        } else if (SwipeBackLayout.b(this.CLd).iM(8, paramInt)) {
          SwipeBackLayout.a(this.CLd, 8);
        }
      }
      this.CLc = true;
    }
    if ((SwipeBackLayout.a(this.CLd) == 1) || (SwipeBackLayout.a(this.CLd) == 2)) {
      if (!SwipeBackLayout.b(this.CLd).iL(2, paramInt))
      {
        paramInt = 1;
        i = paramInt;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(91200);
      return j & i;
      paramInt = 0;
      break;
      if (SwipeBackLayout.a(this.CLd) == 8)
      {
        if (SwipeBackLayout.b(this.CLd).iL(1, paramInt)) {
          i = 0;
        }
      }
      else if (SwipeBackLayout.a(this.CLd) != 11) {
        i = 0;
      }
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(91204);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((SwipeBackLayout.d(this.CLd) & 0x1) != 0) {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.i(this.CLd) > SwipeBackLayout.j(this.CLd))))
      {
        i = i + SwipeBackLayout.f(this.CLd).getIntrinsicWidth() + 10;
        j = 0;
      }
    }
    for (;;)
    {
      if ((SwipeBackLayout.c(this.CLd) != null) && (!SwipeBackLayout.c(this.CLd).isEmpty()))
      {
        paramView = SwipeBackLayout.c(this.CLd).iterator();
        label321:
        for (;;)
        {
          if (!paramView.hasNext()) {
            break label323;
          }
          SwipeBackLayout.a locala = (SwipeBackLayout.a)paramView.next();
          if (i != 0) {}
          for (boolean bool = true;; bool = false)
          {
            if (!locala.aZ(bool)) {
              break label321;
            }
            AppMethodBeat.o(91204);
            return;
            i = 0;
            break;
            if ((SwipeBackLayout.d(this.CLd) & 0x2) != 0)
            {
              if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.i(this.CLd) > SwipeBackLayout.j(this.CLd)))) {}
              for (i = -(i + SwipeBackLayout.f(this.CLd).getIntrinsicWidth() + 10);; i = 0)
              {
                j = 0;
                break;
              }
            }
            if ((SwipeBackLayout.d(this.CLd) & 0x8) == 0) {
              break label654;
            }
            if ((paramFloat2 < 0.0F) || ((paramFloat2 == 0.0F) && (SwipeBackLayout.i(this.CLd) > SwipeBackLayout.j(this.CLd)))) {}
            for (i = -(SwipeBackLayout.h(this.CLd).getIntrinsicHeight() + j + 10);; i = 0)
            {
              j = i;
              i = 0;
              break;
            }
          }
        }
      }
      label323:
      paramView = SwipeBackLayout.b(this.CLd);
      if (!paramView.MN)
      {
        paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        AppMethodBeat.o(91204);
        throw paramView;
      }
      int n = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
      int i1 = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
      int k = paramView.MM.getLeft();
      int m = paramView.MM.getTop();
      i -= k;
      j -= m;
      if ((i == 0) && (j == 0))
      {
        paramView.jtz.jR.abortAnimation();
        paramView.aL(0);
        this.CLd.invalidate();
        AppMethodBeat.o(91204);
        return;
      }
      n = a.h(n, (int)paramView.MI, (int)paramView.MH);
      i1 = a.h(i1, (int)paramView.MI, (int)paramView.MH);
      int i2 = Math.abs(i);
      int i3 = Math.abs(j);
      int i4 = Math.abs(n);
      int i5 = Math.abs(i1);
      int i6 = i4 + i5;
      int i7 = i2 + i3;
      if (n != 0)
      {
        paramFloat1 = i4 / i6;
        label542:
        if (i1 == 0) {
          break label643;
        }
      }
      label643:
      for (paramFloat2 = i5 / i6;; paramFloat2 = i3 / i7)
      {
        n = paramView.g(i, n, paramView.CLf.dNq());
        i1 = paramView.g(j, i1, paramView.CLf.aY());
        float f = n;
        n = (int)(paramFloat2 * i1 + paramFloat1 * f);
        paramView.jtz.startScroll(k, m, i, j, n);
        paramView.aL(2);
        break;
        paramFloat1 = i2 / i7;
        break label542;
      }
      label654:
      j = 0;
      i = 0;
    }
  }
  
  public final int aY()
  {
    AppMethodBeat.i(91202);
    int i = SwipeBackLayout.a(this.CLd);
    AppMethodBeat.o(91202);
    return i & 0x8;
  }
  
  public final int c(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(91206);
    if ((SwipeBackLayout.d(this.CLd) & 0x8) != 0) {
      i = Math.min(0, Math.max(paramInt, -paramView.getHeight()));
    }
    AppMethodBeat.o(91206);
    return i;
  }
  
  public final int d(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(91205);
    if ((SwipeBackLayout.d(this.CLd) & 0x1) != 0) {
      i = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
    }
    for (;;)
    {
      AppMethodBeat.o(91205);
      return i;
      if ((SwipeBackLayout.d(this.CLd) & 0x2) != 0) {
        i = Math.min(0, Math.max(paramInt, -paramView.getWidth()));
      }
    }
  }
  
  public final int dNq()
  {
    AppMethodBeat.i(91201);
    int i = SwipeBackLayout.a(this.CLd);
    AppMethodBeat.o(91201);
    return i & 0x3;
  }
  
  public final void o(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(91203);
    super.o(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((SwipeBackLayout.d(this.CLd) & 0x1) != 0) {
      SwipeBackLayout.a(this.CLd, Math.abs(paramInt1 / (SwipeBackLayout.e(this.CLd).getWidth() + SwipeBackLayout.f(this.CLd).getIntrinsicWidth())));
    }
    for (;;)
    {
      SwipeBackLayout.b(this.CLd, paramInt1);
      SwipeBackLayout.c(this.CLd, paramInt2);
      this.CLd.invalidate();
      if ((SwipeBackLayout.i(this.CLd) < SwipeBackLayout.j(this.CLd)) && (!this.CLc)) {
        this.CLc = true;
      }
      if ((SwipeBackLayout.c(this.CLd) == null) || (SwipeBackLayout.c(this.CLd).isEmpty())) {
        break;
      }
      paramView = SwipeBackLayout.c(this.CLd).iterator();
      while (paramView.hasNext()) {
        ((SwipeBackLayout.a)paramView.next()).g(SwipeBackLayout.b(this.CLd).Mw, SwipeBackLayout.i(this.CLd));
      }
      if ((SwipeBackLayout.d(this.CLd) & 0x2) != 0) {
        SwipeBackLayout.a(this.CLd, Math.abs(paramInt1 / (SwipeBackLayout.e(this.CLd).getWidth() + SwipeBackLayout.g(this.CLd).getIntrinsicWidth())));
      } else if ((SwipeBackLayout.d(this.CLd) & 0x8) != 0) {
        SwipeBackLayout.a(this.CLd, Math.abs(paramInt2 / (SwipeBackLayout.e(this.CLd).getHeight() + SwipeBackLayout.h(this.CLd).getIntrinsicHeight())));
      }
    }
    if ((SwipeBackLayout.c(this.CLd) != null) && (!SwipeBackLayout.c(this.CLd).isEmpty()) && (SwipeBackLayout.b(this.CLd).Mw == 1) && (SwipeBackLayout.i(this.CLd) >= SwipeBackLayout.j(this.CLd)) && (this.CLc))
    {
      this.CLc = false;
      paramView = SwipeBackLayout.c(this.CLd).iterator();
      while (paramView.hasNext()) {
        paramView.next();
      }
    }
    if ((SwipeBackLayout.i(this.CLd) >= 1.0F) && (SwipeBackLayout.c(this.CLd) != null) && (!SwipeBackLayout.c(this.CLd).isEmpty()))
    {
      paramView = SwipeBackLayout.c(this.CLd).iterator();
      while (paramView.hasNext())
      {
        SwipeBackLayout.a locala = (SwipeBackLayout.a)paramView.next();
        if ((locala instanceof SwipeBackLayout.b)) {
          ((SwipeBackLayout.b)locala).aIN();
        }
      }
    }
    AppMethodBeat.o(91203);
  }
  
  public final void w(int paramInt)
  {
    AppMethodBeat.i(91207);
    super.w(paramInt);
    if ((SwipeBackLayout.c(this.CLd) != null) && (!SwipeBackLayout.c(this.CLd).isEmpty()))
    {
      Iterator localIterator = SwipeBackLayout.c(this.CLd).iterator();
      while (localIterator.hasNext()) {
        ((SwipeBackLayout.a)localIterator.next()).g(paramInt, SwipeBackLayout.i(this.CLd));
      }
    }
    AppMethodBeat.o(91207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout.c
 * JD-Core Version:    0.7.0.1
 */