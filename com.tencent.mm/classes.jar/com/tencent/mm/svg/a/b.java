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
  protected final Rect Ky = new Rect();
  protected Paint OuA = new Paint();
  protected WeakReference<View> OuB;
  protected int OuC = 0;
  protected int OuD = 0;
  protected int OuE = 0;
  protected int OuF = 0;
  protected float OuG;
  protected int Ouy = 0;
  protected boolean Ouz = false;
  public long mDuration = 0L;
  protected ColorFilter xo;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.OuE = paramInt1;
    this.OuF = paramInt2;
    this.OuG = 1.0F;
    this.OuC = this.OuE;
    this.OuD = this.OuF;
    setLevel(10000);
    this.Ouy = paramInt3;
  }
  
  private void gFR()
  {
    View localView = a.C(this);
    gr(localView);
    if (localView != null)
    {
      if (this.xo != null) {
        setColorFilter(this.xo);
      }
      a.b(localView, this.OuA);
    }
  }
  
  protected final void gFP()
  {
    this.Ky.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void gFQ()
  {
    if (this.Ouz)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Ky);
    }
    this.Ouz = false;
  }
  
  /* Error */
  protected final View gFS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/mm/svg/a/b:OuB	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 109	com/tencent/mm/svg/a/b:OuB	Ljava/lang/ref/WeakReference;
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
  
  public int getIntrinsicHeight()
  {
    return this.OuD;
  }
  
  public int getIntrinsicWidth()
  {
    return this.OuC;
  }
  
  public int getOpacity()
  {
    View localView = gFS();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.OuA != null) && (this.OuA.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void gr(View paramView)
  {
    try
    {
      this.OuB = new WeakReference(paramView);
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
    this.Ouz = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    gFR();
    return super.onLevelChange(paramInt);
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.OuA.setAlpha(paramInt);
    View localView = gFS();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.OuA);
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
    this.OuA.setColorFilter(paramColorFilter);
    View localView = gFS();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.OuA);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.xo = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    gFR();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  protected final void y(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.gFW())
    {
      int i = this.Ky.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Ky.width() - f, this.Ky.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */