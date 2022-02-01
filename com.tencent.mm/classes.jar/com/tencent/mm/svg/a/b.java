package com.tencent.mm.svg.a;

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
  protected int adoA = 0;
  protected boolean adoB = false;
  protected Paint adoC = new Paint();
  protected WeakReference<View> adoD;
  protected int adoE = 0;
  protected int adoF = 0;
  protected int adoG = 0;
  protected int adoH = 0;
  protected float adoI;
  protected final Rect bre = new Rect();
  protected ColorFilter kx;
  public long mDuration = 0L;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.adoG = paramInt1;
    this.adoH = paramInt2;
    this.adoI = 1.0F;
    this.adoE = this.adoG;
    this.adoF = this.adoH;
    setLevel(10000);
    this.adoA = paramInt3;
  }
  
  private void jeo()
  {
    View localView = a.S(this);
    kU(localView);
    if (localView != null)
    {
      if (this.kx != null) {
        setColorFilter(this.kx);
      }
      a.b(localView, this.adoC);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.adoF;
  }
  
  public int getIntrinsicWidth()
  {
    return this.adoE;
  }
  
  public int getOpacity()
  {
    View localView = jep();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.adoC != null) && (this.adoC.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void jem()
  {
    this.bre.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void jen()
  {
    if (this.adoB)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.bre);
    }
    this.adoB = false;
  }
  
  /* Error */
  protected final View jep()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 120	com/tencent/mm/svg/a/b:adoD	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 120	com/tencent/mm/svg/a/b:adoD	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 126	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 92	android/view/View
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
  
  protected final void kU(View paramView)
  {
    try
    {
      this.adoD = new WeakReference(paramView);
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.adoB = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    jeo();
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.adoC.setAlpha(paramInt);
    View localView = jep();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.adoC);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      c.printErrStackTrace("MicroMsg.SVGDrawable", localNoSuchMethodError, "samsung", new Object[0]);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.adoC.setColorFilter(paramColorFilter);
    View localView = jep();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.adoC);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.kx = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    jeo();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  protected final void w(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.jeu())
    {
      int i = this.bre.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.bre.width() - f, this.bre.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */