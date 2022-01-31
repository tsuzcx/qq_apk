package android.support.v4.widget;

import android.view.View;

final class g
  extends ad
{
  private final int oR;
  private ac oS;
  private final Runnable oT = new Runnable()
  {
    public final void run()
    {
      g.this.ch();
    }
  };
  
  g(DrawerLayout paramDrawerLayout, int paramInt)
  {
    this.oR = paramInt;
  }
  
  private void cf()
  {
    int i = 3;
    if (this.oR == 3) {
      i = 5;
    }
    View localView = this.oH.J(i);
    if (localView != null) {
      this.oH.H(localView);
    }
  }
  
  public final boolean J(View paramView)
  {
    return (DrawerLayout.F(paramView)) && (this.oH.f(paramView, this.oR)) && (this.oH.B(paramView) == 0);
  }
  
  public final void K(int paramInt)
  {
    this.oH.a(paramInt, this.oS.cw());
  }
  
  public final void K(View paramView)
  {
    ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).oK = false;
    cf();
  }
  
  public final int L(View paramView)
  {
    if (DrawerLayout.F(paramView)) {
      return paramView.getWidth();
    }
    return 0;
  }
  
  public final int M(View paramView)
  {
    return paramView.getTop();
  }
  
  public final void a(ac paramac)
  {
    this.oS = paramac;
  }
  
  public final void cb()
  {
    this.oH.removeCallbacks(this.oT);
  }
  
  public final void cg()
  {
    this.oH.postDelayed(this.oT, 160L);
  }
  
  final void ch()
  {
    int j = 0;
    int k = this.oS.cv();
    int i;
    View localView;
    if (this.oR == 3)
    {
      i = 1;
      if (i == 0) {
        break label149;
      }
      localView = this.oH.J(3);
      if (localView != null) {
        j = -localView.getWidth();
      }
      j += k;
    }
    for (;;)
    {
      if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (this.oH.B(localView) == 0))))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        this.oS.b(localView, j, localView.getTop());
        localLayoutParams.oK = true;
        this.oH.invalidate();
        cf();
        this.oH.ce();
      }
      return;
      i = 0;
      break;
      label149:
      localView = this.oH.J(5);
      j = this.oH.getWidth() - k;
    }
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = this.oH.J(3);; localView = this.oH.J(5))
    {
      if ((localView != null) && (this.oH.B(localView) == 0)) {
        this.oS.i(localView, paramInt2);
      }
      return;
    }
  }
  
  public final void f(View paramView, float paramFloat)
  {
    float f = DrawerLayout.C(paramView);
    int k = paramView.getWidth();
    int i;
    if (this.oH.f(paramView, 3)) {
      if ((paramFloat > 0.0F) || ((paramFloat == 0.0F) && (f > 0.5F))) {
        i = 0;
      }
    }
    for (;;)
    {
      this.oS.i(i, paramView.getTop());
      this.oH.invalidate();
      return;
      i = -k;
      continue;
      int j = this.oH.getWidth();
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
  
  public final void g(View paramView, int paramInt)
  {
    int i = paramView.getWidth();
    float f;
    if (this.oH.f(paramView, 3))
    {
      f = (i + paramInt) / i;
      this.oH.e(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt = 4;; paramInt = 0)
    {
      paramView.setVisibility(paramInt);
      this.oH.invalidate();
      return;
      f = (this.oH.getWidth() - paramInt) / i;
      break;
    }
  }
  
  public final int h(View paramView, int paramInt)
  {
    if (this.oH.f(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
    }
    int i = this.oH.getWidth();
    return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.g
 * JD-Core Version:    0.7.0.1
 */