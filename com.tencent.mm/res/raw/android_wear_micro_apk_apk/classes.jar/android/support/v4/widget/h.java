package android.support.v4.widget;

import android.view.View;

final class h
  extends ae
{
  private final int qH;
  private ad qI;
  private final Runnable qJ = new Runnable()
  {
    public final void run()
    {
      h.this.cm();
    }
  };
  
  h(DrawerLayout paramDrawerLayout, int paramInt)
  {
    this.qH = paramInt;
  }
  
  private void ck()
  {
    int i = 3;
    if (this.qH == 3) {
      i = 5;
    }
    View localView = this.qx.U(i);
    if (localView != null) {
      this.qx.M(localView);
    }
  }
  
  public final boolean P(View paramView)
  {
    return (DrawerLayout.K(paramView)) && (this.qx.i(paramView, this.qH)) && (this.qx.G(paramView) == 0);
  }
  
  public final void Q(View paramView)
  {
    ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).qA = false;
    ck();
  }
  
  public final int R(View paramView)
  {
    if (DrawerLayout.K(paramView)) {
      return paramView.getWidth();
    }
    return 0;
  }
  
  public final int S(View paramView)
  {
    return paramView.getTop();
  }
  
  public final void V(int paramInt)
  {
    this.qx.a(paramInt, this.qI.cD());
  }
  
  public final void a(ad paramad)
  {
    this.qI = paramad;
  }
  
  public final void cf()
  {
    this.qx.removeCallbacks(this.qJ);
  }
  
  public final void cl()
  {
    this.qx.postDelayed(this.qJ, 160L);
  }
  
  final void cm()
  {
    int j = 0;
    int k = this.qI.cC();
    int i;
    View localView;
    if (this.qH == 3)
    {
      i = 1;
      if (i == 0) {
        break label149;
      }
      localView = this.qx.U(3);
      if (localView != null) {
        j = -localView.getWidth();
      }
      j += k;
    }
    for (;;)
    {
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (this.qx.G(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.qI.b(localView, j, localView.getTop());
        localLayoutParams.qA = true;
        this.qx.invalidate();
        ck();
        this.qx.cj();
      }
      return;
      i = 0;
      break;
      label149:
      localView = this.qx.U(5);
      j = this.qx.getWidth() - k;
    }
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = this.qx.U(3);; localView = this.qx.U(5))
    {
      if ((localView != null) && (this.qx.G(localView) == 0)) {
        this.qI.l(localView, paramInt2);
      }
      return;
    }
  }
  
  public final void f(View paramView, float paramFloat)
  {
    float f = DrawerLayout.H(paramView);
    int k = paramView.getWidth();
    int i;
    if (this.qx.i(paramView, 3)) {
      if ((paramFloat > 0.0F) || ((paramFloat == 0.0F) && (f > 0.5F))) {
        i = 0;
      }
    }
    for (;;)
    {
      this.qI.j(i, paramView.getTop());
      this.qx.invalidate();
      return;
      i = -k;
      continue;
      int j = this.qx.getWidth();
      if (paramFloat >= 0.0F)
      {
        i = j;
        if (paramFloat == 0.0F)
        {
          i = j;
          if (f <= 0.5F) {}
        }
      }
      else
      {
        i = j - k;
      }
    }
  }
  
  public final void j(View paramView, int paramInt)
  {
    int i = paramView.getWidth();
    float f;
    if (this.qx.i(paramView, 3))
    {
      f = (i + paramInt) / i;
      this.qx.e(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt = 4;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      this.qx.invalidate();
      return;
      f = (this.qx.getWidth() - paramInt) / i;
      break;
    }
  }
  
  public final int k(View paramView, int paramInt)
  {
    if (this.qx.i(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
    }
    int i = this.qx.getWidth();
    return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */