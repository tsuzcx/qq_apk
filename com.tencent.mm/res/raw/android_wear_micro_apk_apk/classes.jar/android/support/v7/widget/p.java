package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class p
  extends ai
{
  protected final DecelerateInterpolator rT = new DecelerateInterpolator();
  protected final LinearInterpolator uD = new LinearInterpolator();
  protected PointF uE;
  private final float uF = a(paramContext.getResources().getDisplayMetrics());
  protected int uG = 0;
  protected int uH = 0;
  
  public p(Context paramContext) {}
  
  private static int A(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
  }
  
  private int au(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.uF);
  }
  
  protected float a(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(int paramInt1, int paramInt2, aj paramaj)
  {
    if (getChildCount() == 0) {
      stop();
    }
    do
    {
      return;
      this.uG = A(this.uG, paramInt1);
      this.uH = A(this.uH, paramInt2);
    } while ((this.uG != 0) || (this.uH != 0));
    PointF localPointF = at(ek());
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
      paramaj.aJ(ek());
      stop();
      return;
    }
    double d = Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x = ((float)(localPointF.x / d));
    localPointF.y = ((float)(localPointF.y / d));
    this.uE = localPointF;
    this.uG = ((int)(localPointF.x * 10000.0F));
    this.uH = ((int)(localPointF.y * 10000.0F));
    paramInt1 = au(10000);
    paramaj.a((int)(this.uG * 1.2F), (int)(this.uH * 1.2F), (int)(paramInt1 * 1.2F), this.uD);
  }
  
  protected final void a(View paramView, aj paramaj)
  {
    int k = 0;
    ab localab;
    int j;
    if ((this.uE == null) || (this.uE.x == 0.0F))
    {
      i = 0;
      localab = jdMethod_do();
      if (localab.cX()) {
        break label151;
      }
      j = 0;
      label41:
      if ((this.uE != null) && (this.uE.y != 0.0F)) {
        break label206;
      }
      i = 0;
      label62:
      localab = jdMethod_do();
      if (localab.cY()) {
        break label228;
      }
    }
    label151:
    RecyclerView.LayoutParams localLayoutParams;
    for (int i = k;; i = b(ab.az(paramView) - localLayoutParams.topMargin, ab.aB(paramView) + localLayoutParams.bottomMargin, localab.getPaddingTop(), localab.getHeight() - localab.getPaddingBottom(), i))
    {
      k = (int)Math.ceil(au((int)Math.sqrt(j * j + i * i)) / 0.3356D);
      if (k > 0) {
        paramaj.a(-j, -i, k, this.rT);
      }
      return;
      if (this.uE.x > 0.0F)
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      j = b(ab.ay(paramView) - localLayoutParams.leftMargin, ab.aA(paramView) + localLayoutParams.rightMargin, localab.getPaddingLeft(), localab.getWidth() - localab.getPaddingRight(), i);
      break label41;
      label206:
      if (this.uE.y > 0.0F)
      {
        i = 1;
        break label62;
      }
      i = -1;
      break label62;
      label228:
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    }
  }
  
  public abstract PointF at(int paramInt);
  
  public int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt5)
    {
    default: 
      throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    case -1: 
      paramInt1 = paramInt3 - paramInt1;
    }
    do
    {
      do
      {
        return paramInt1;
        return paramInt4 - paramInt2;
        paramInt3 -= paramInt1;
        paramInt1 = paramInt3;
      } while (paramInt3 > 0);
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt2;
    } while (paramInt2 < 0);
    return 0;
  }
  
  protected final void onStop()
  {
    this.uH = 0;
    this.uG = 0;
    this.uE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.p
 * JD-Core Version:    0.7.0.1
 */