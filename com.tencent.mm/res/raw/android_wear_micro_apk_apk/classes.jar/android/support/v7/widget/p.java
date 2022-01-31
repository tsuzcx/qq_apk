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
  protected final DecelerateInterpolator qf = new DecelerateInterpolator();
  protected final LinearInterpolator sN = new LinearInterpolator();
  protected PointF sO;
  private final float sP = a(paramContext.getResources().getDisplayMetrics());
  protected int sQ = 0;
  protected int sR = 0;
  
  public p(Context paramContext) {}
  
  private int ai(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * this.sP);
  }
  
  private static int z(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - paramInt2;
    paramInt2 = i;
    if (paramInt1 * i <= 0) {
      paramInt2 = 0;
    }
    return paramInt2;
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
      this.sQ = z(this.sQ, paramInt1);
      this.sR = z(this.sR, paramInt2);
    } while ((this.sQ != 0) || (this.sR != 0));
    PointF localPointF = ah(dW());
    if ((localPointF == null) || ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)))
    {
      Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
      paramaj.ax(dW());
      stop();
      return;
    }
    double d = Math.sqrt(localPointF.x * localPointF.x + localPointF.y * localPointF.y);
    localPointF.x = ((float)(localPointF.x / d));
    localPointF.y = ((float)(localPointF.y / d));
    this.sO = localPointF;
    this.sQ = ((int)(localPointF.x * 10000.0F));
    this.sR = ((int)(localPointF.y * 10000.0F));
    paramInt1 = ai(10000);
    paramaj.a((int)(this.sQ * 1.2F), (int)(this.sR * 1.2F), (int)(paramInt1 * 1.2F), this.sN);
  }
  
  protected final void a(View paramView, aj paramaj)
  {
    int k = 0;
    ab localab;
    int j;
    if ((this.sO == null) || (this.sO.x == 0.0F))
    {
      i = 0;
      localab = df();
      if (localab.cP()) {
        break label151;
      }
      j = 0;
      label41:
      if ((this.sO != null) && (this.sO.y != 0.0F)) {
        break label206;
      }
      i = 0;
      label62:
      localab = df();
      if (localab.cQ()) {
        break label228;
      }
    }
    label151:
    RecyclerView.LayoutParams localLayoutParams;
    for (int i = k;; i = b(ab.as(paramView) - localLayoutParams.topMargin, ab.au(paramView) + localLayoutParams.bottomMargin, localab.getPaddingTop(), localab.getHeight() - localab.getPaddingBottom(), i))
    {
      k = (int)Math.ceil(ai((int)Math.sqrt(j * j + i * i)) / 0.3356D);
      if (k > 0) {
        paramaj.a(-j, -i, k, this.qf);
      }
      return;
      if (this.sO.x > 0.0F)
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      j = b(ab.ar(paramView) - localLayoutParams.leftMargin, ab.at(paramView) + localLayoutParams.rightMargin, localab.getPaddingLeft(), localab.getWidth() - localab.getPaddingRight(), i);
      break label41;
      label206:
      if (this.sO.y > 0.0F)
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
  
  public abstract PointF ah(int paramInt);
  
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
    this.sR = 0;
    this.sQ = 0;
    this.sO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.p
 * JD-Core Version:    0.7.0.1
 */