package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.mm.svg.b.c;
import java.lang.ref.WeakReference;

public abstract class b
  extends Drawable
{
  protected final Rect Bc = new Rect();
  public long mDuration = 0L;
  protected ColorFilter nO;
  protected int yRU = 0;
  protected boolean yRV = false;
  protected Paint yRW = new Paint();
  protected WeakReference<View> yRX;
  protected int yRY = 0;
  protected int yRZ = 0;
  protected int ySa = 0;
  protected int ySb = 0;
  protected float ySc;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ySa = paramInt1;
    this.ySb = paramInt2;
    this.ySc = 1.0F;
    this.yRY = this.ySa;
    this.yRZ = this.ySb;
    setLevel(10000);
    this.yRU = paramInt3;
  }
  
  private void dAe()
  {
    View localView = a.v(this);
    eJ(localView);
    if (localView != null)
    {
      if (this.nO != null) {
        setColorFilter(this.nO);
      }
      a.b(localView, this.yRW);
    }
  }
  
  protected final void dAc()
  {
    this.Bc.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void dAd()
  {
    if (this.yRV)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Bc);
    }
    this.yRV = false;
  }
  
  /* Error */
  protected final View dAf()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/mm/svg/a/b:yRX	Ljava/lang/ref/WeakReference;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 109	com/tencent/mm/svg/a/b:yRX	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 115	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 117	android/view/View
    //   27: astore_1
    //   28: goto -15 -> 13
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	b
    //   6	22	1	localObject1	Object
    //   31	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   17	28	31	finally
  }
  
  protected final void eJ(View paramView)
  {
    try
    {
      this.yRX = new WeakReference(paramView);
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.yRZ;
  }
  
  public int getIntrinsicWidth()
  {
    return this.yRY;
  }
  
  public int getOpacity()
  {
    View localView = dAf();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.yRW != null) && (this.yRW.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void m(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.dAj())
    {
      int i = this.Bc.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Bc.width() - f, this.Bc.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.yRV = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    dAe();
    return super.onLevelChange(paramInt);
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.yRW.setAlpha(paramInt);
    View localView = dAf();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.yRW);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      c.printErrStackTrace("MicroMsg.SVGDrawable", localNoSuchMethodError, "samsung", new Object[0]);
    }
  }
  
  @TargetApi(17)
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.yRW.setColorFilter(paramColorFilter);
    View localView = dAf();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.yRW);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.nO = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    dAe();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */