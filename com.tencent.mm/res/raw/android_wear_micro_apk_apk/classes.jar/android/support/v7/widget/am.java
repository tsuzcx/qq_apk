package android.support.v7.widget;

import android.support.v4.os.f;
import android.support.v4.view.r;
import android.support.v4.widget.m;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

final class am
  implements Runnable
{
  private Interpolator mInterpolator = RecyclerView.dR();
  private int wO;
  private int wP;
  private m wQ;
  private boolean wR = false;
  private boolean wS = false;
  
  public am(RecyclerView paramRecyclerView)
  {
    this.wQ = m.a(paramRecyclerView.getContext(), RecyclerView.dR());
  }
  
  public final void H(int paramInt1, int paramInt2)
  {
    RecyclerView.c(this.vQ, 2);
    this.wP = 0;
    this.wO = 0;
    this.wQ.g(paramInt1, paramInt2);
    er();
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.wQ = m.a(this.vQ.getContext(), paramInterpolator);
    }
    RecyclerView.c(this.vQ, 2);
    this.wP = 0;
    this.wO = 0;
    this.wQ.c(paramInt1, paramInt2, paramInt3);
    er();
  }
  
  final void er()
  {
    if (this.wR)
    {
      this.wS = true;
      return;
    }
    this.vQ.removeCallbacks(this);
    r.b(this.vQ, this);
  }
  
  public final void g(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3, RecyclerView.dR());
  }
  
  public final void run()
  {
    this.wS = false;
    this.wR = true;
    RecyclerView.f(this.vQ);
    m localm = this.wQ;
    ai localai = RecyclerView.e(this.vQ).wb;
    int i6;
    int i7;
    int i4;
    int i5;
    int i1;
    int j;
    int i2;
    int m;
    int i3;
    int i;
    int n;
    if (localm.computeScrollOffset())
    {
      i6 = localm.getCurrX();
      i7 = localm.getCurrY();
      i4 = i6 - this.wO;
      i5 = i7 - this.wP;
      i1 = 0;
      j = 0;
      i2 = 0;
      m = 0;
      this.wO = i6;
      this.wP = i7;
      i3 = 0;
      i = 0;
      n = 0;
      k = 0;
      if (RecyclerView.g(this.vQ) != null)
      {
        this.vQ.dr();
        RecyclerView.h(this.vQ);
        f.beginSection("RV Scroll");
        if (i4 != 0)
        {
          j = RecyclerView.e(this.vQ).a(i4, this.vQ.uO, this.vQ.vC);
          i = i4 - j;
        }
        if (i5 != 0)
        {
          m = RecyclerView.e(this.vQ).b(i5, this.vQ.uO, this.vQ.vC);
          k = i5 - m;
        }
        f.endSection();
        if (RecyclerView.i(this.vQ))
        {
          i1 = this.vQ.uR.getChildCount();
          n = 0;
          while (n < i1)
          {
            View localView = this.vQ.uR.getChildAt(n);
            Object localObject = this.vQ.af(localView);
            if ((localObject != null) && (((an)localObject).wZ != null))
            {
              localObject = ((an)localObject).wZ.wT;
              i2 = localView.getLeft();
              i3 = localView.getTop();
              if ((i2 != ((View)localObject).getLeft()) || (i3 != ((View)localObject).getTop())) {
                ((View)localObject).layout(i2, i3, ((View)localObject).getWidth() + i2, ((View)localObject).getHeight() + i3);
              }
            }
            n += 1;
          }
        }
        RecyclerView.j(this.vQ);
        this.vQ.r(false);
        n = k;
        i2 = m;
        i3 = i;
        i1 = j;
        if (localai != null)
        {
          n = k;
          i2 = m;
          i3 = i;
          i1 = j;
          if (!localai.ej())
          {
            n = k;
            i2 = m;
            i3 = i;
            i1 = j;
            if (localai.isRunning())
            {
              n = this.vQ.vC.getItemCount();
              if (n != 0) {
                break label807;
              }
              localai.stop();
              i1 = j;
              i3 = i;
              i2 = m;
              n = k;
            }
          }
        }
      }
      if (!RecyclerView.k(this.vQ).isEmpty()) {
        this.vQ.invalidate();
      }
      if (r.d(this.vQ) != 2) {
        RecyclerView.a(this.vQ, i4, i5);
      }
      if ((i3 != 0) || (n != 0))
      {
        j = (int)localm.getCurrVelocity();
        if (i3 == i6) {
          break label909;
        }
        if (i3 >= 0) {
          break label855;
        }
        i = -j;
      }
    }
    label548:
    for (int k = i;; k = 0)
    {
      if (n != i7) {
        if (n < 0) {
          i = -j;
        }
      }
      for (;;)
      {
        label565:
        if (r.d(this.vQ) != 2) {
          this.vQ.D(k, i);
        }
        if (((k != 0) || (i3 == i6) || (localm.getFinalX() == 0)) && ((i != 0) || (n == i7) || (localm.getFinalY() == 0))) {
          localm.abortAnimation();
        }
        if ((i1 != 0) || (i2 != 0)) {
          this.vQ.aw(i2);
        }
        if (!RecyclerView.l(this.vQ)) {
          this.vQ.invalidate();
        }
        if ((i5 != 0) && (RecyclerView.e(this.vQ).cY()) && (i2 == i5))
        {
          i = 1;
          label691:
          if ((i4 == 0) || (!RecyclerView.e(this.vQ).cX()) || (i1 != i4)) {
            break label887;
          }
          j = 1;
          label718:
          if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
            break label892;
          }
          i = 1;
          label738:
          if ((!localm.isFinished()) && (i != 0)) {
            break label897;
          }
          RecyclerView.c(this.vQ, 0);
        }
        for (;;)
        {
          if (localai != null)
          {
            if (localai.ej()) {
              ai.a(localai, 0, 0);
            }
            if (!this.wS) {
              localai.stop();
            }
          }
          this.wR = false;
          if (this.wS) {
            er();
          }
          return;
          label807:
          if (localai.ek() >= n) {
            localai.aI(n - 1);
          }
          ai.a(localai, i4 - i, i5 - k);
          n = k;
          i2 = m;
          i3 = i;
          i1 = j;
          break;
          label855:
          if (i3 > 0)
          {
            i = j;
            break label548;
          }
          i = 0;
          break label548;
          i = j;
          if (n > 0) {
            break label565;
          }
          i = 0;
          break label565;
          i = 0;
          break label691;
          label887:
          j = 0;
          break label718;
          label892:
          i = 0;
          break label738;
          er();
        }
        i = 0;
      }
    }
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n;
    int i1;
    if (k > m)
    {
      j = 1;
      n = (int)Math.sqrt(0.0D);
      i1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (j == 0) {
        break label157;
      }
    }
    label157:
    for (int i = this.vQ.getWidth();; i = this.vQ.getHeight())
    {
      int i2 = i / 2;
      float f3 = Math.min(1.0F, i1 * 1.0F / i);
      float f1 = i2;
      float f2 = i2;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.47123891676382D));
      if (n <= 0) {
        break label169;
      }
      i = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / n)) * 4;
      g(paramInt1, paramInt2, Math.min(i, 2000));
      return;
      j = 0;
      break;
    }
    label169:
    if (j != 0) {}
    for (int j = k;; j = m)
    {
      i = (int)((j / i + 1.0F) * 300.0F);
      break;
    }
  }
  
  public final void stop()
  {
    this.vQ.removeCallbacks(this);
    this.wQ.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.am
 * JD-Core Version:    0.7.0.1
 */