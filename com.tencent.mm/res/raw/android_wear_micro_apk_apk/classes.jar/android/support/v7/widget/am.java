package android.support.v7.widget;

import android.support.v4.os.f;
import android.support.v4.view.r;
import android.support.v4.widget.l;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

final class am
  implements Runnable
{
  private Interpolator mInterpolator = RecyclerView.dD();
  private int uZ;
  private int va;
  private l vb;
  private boolean vc = false;
  private boolean vd = false;
  
  public am(RecyclerView paramRecyclerView)
  {
    this.vb = l.a(paramRecyclerView.getContext(), RecyclerView.dD());
  }
  
  public final void F(int paramInt1, int paramInt2)
  {
    RecyclerView.c(this.ua, 2);
    this.va = 0;
    this.uZ = 0;
    this.vb.f(paramInt1, paramInt2);
    ed();
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.vb = l.a(this.ua.getContext(), paramInterpolator);
    }
    RecyclerView.c(this.ua, 2);
    this.va = 0;
    this.uZ = 0;
    this.vb.c(paramInt1, paramInt2, paramInt3);
    ed();
  }
  
  final void ed()
  {
    if (this.vc)
    {
      this.vd = true;
      return;
    }
    this.ua.removeCallbacks(this);
    r.b(this.ua, this);
  }
  
  public final void g(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3, RecyclerView.dD());
  }
  
  public final void run()
  {
    this.vd = false;
    this.vc = true;
    RecyclerView.f(this.ua);
    l locall = this.vb;
    ai localai = RecyclerView.e(this.ua).ul;
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
    if (locall.computeScrollOffset())
    {
      i6 = locall.getCurrX();
      i7 = locall.getCurrY();
      i4 = i6 - this.uZ;
      i5 = i7 - this.va;
      i1 = 0;
      j = 0;
      i2 = 0;
      m = 0;
      this.uZ = i6;
      this.va = i7;
      i3 = 0;
      i = 0;
      n = 0;
      k = 0;
      if (RecyclerView.g(this.ua) != null)
      {
        this.ua.di();
        RecyclerView.h(this.ua);
        f.beginSection("RV Scroll");
        if (i4 != 0)
        {
          j = RecyclerView.e(this.ua).a(i4, this.ua.sY, this.ua.tM);
          i = i4 - j;
        }
        if (i5 != 0)
        {
          m = RecyclerView.e(this.ua).b(i5, this.ua.sY, this.ua.tM);
          k = i5 - m;
        }
        f.endSection();
        if (RecyclerView.i(this.ua))
        {
          i1 = this.ua.tb.getChildCount();
          n = 0;
          while (n < i1)
          {
            View localView = this.ua.tb.getChildAt(n);
            Object localObject = this.ua.Z(localView);
            if ((localObject != null) && (((an)localObject).vk != null))
            {
              localObject = ((an)localObject).vk.ve;
              i2 = localView.getLeft();
              i3 = localView.getTop();
              if ((i2 != ((View)localObject).getLeft()) || (i3 != ((View)localObject).getTop())) {
                ((View)localObject).layout(i2, i3, ((View)localObject).getWidth() + i2, ((View)localObject).getHeight() + i3);
              }
            }
            n += 1;
          }
        }
        RecyclerView.j(this.ua);
        this.ua.o(false);
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
          if (!localai.dV())
          {
            n = k;
            i2 = m;
            i3 = i;
            i1 = j;
            if (localai.isRunning())
            {
              n = this.ua.tM.getItemCount();
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
      if (!RecyclerView.k(this.ua).isEmpty()) {
        this.ua.invalidate();
      }
      if (r.c(this.ua) != 2) {
        RecyclerView.a(this.ua, i4, i5);
      }
      if ((i3 != 0) || (n != 0))
      {
        j = (int)locall.getCurrVelocity();
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
        if (r.c(this.ua) != 2) {
          this.ua.C(k, i);
        }
        if (((k != 0) || (i3 == i6) || (locall.getFinalX() == 0)) && ((i != 0) || (n == i7) || (locall.getFinalY() == 0))) {
          locall.abortAnimation();
        }
        if ((i1 != 0) || (i2 != 0)) {
          this.ua.ak(i2);
        }
        if (!RecyclerView.l(this.ua)) {
          this.ua.invalidate();
        }
        if ((i5 != 0) && (RecyclerView.e(this.ua).cQ()) && (i2 == i5))
        {
          i = 1;
          label691:
          if ((i4 == 0) || (!RecyclerView.e(this.ua).cP()) || (i1 != i4)) {
            break label887;
          }
          j = 1;
          label718:
          if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
            break label892;
          }
          i = 1;
          label738:
          if ((!locall.isFinished()) && (i != 0)) {
            break label897;
          }
          RecyclerView.c(this.ua, 0);
        }
        for (;;)
        {
          if (localai != null)
          {
            if (localai.dV()) {
              ai.a(localai, 0, 0);
            }
            if (!this.vd) {
              localai.stop();
            }
          }
          this.vc = false;
          if (this.vd) {
            ed();
          }
          return;
          label807:
          if (localai.dW() >= n) {
            localai.aw(n - 1);
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
          ed();
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
    for (int i = this.ua.getWidth();; i = this.ua.getHeight())
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
    this.ua.removeCallbacks(this);
    this.vb.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.am
 * JD-Core Version:    0.7.0.1
 */