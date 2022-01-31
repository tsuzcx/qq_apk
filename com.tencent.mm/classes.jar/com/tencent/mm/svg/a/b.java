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
  protected final Rect Aq = new Rect();
  public long mDuration = 0L;
  protected int uFm = 0;
  protected boolean uFn = false;
  protected Paint uFo = new Paint();
  protected int uFp = 0;
  protected int uFq = 0;
  protected int uFr = 0;
  protected int uFs = 0;
  protected float uFt;
  protected WeakReference<View> wWg;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.uFr = paramInt1;
    this.uFs = paramInt2;
    this.uFt = 1.0F;
    this.uFp = this.uFr;
    this.uFq = this.uFs;
    setLevel(10000);
    this.uFm = paramInt3;
  }
  
  private void cxp()
  {
    View localView = a.r(this);
    ev(localView);
    if (localView != null) {
      a.b(localView, this.uFo);
    }
  }
  
  /* Error */
  protected final View cVu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/mm/svg/a/b:wWg	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 78	com/tencent/mm/svg/a/b:wWg	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 86	android/view/View
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
  
  protected final void cxn()
  {
    this.Aq.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void cxo()
  {
    if (this.uFn)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Aq);
    }
    this.uFn = false;
  }
  
  protected final void ev(View paramView)
  {
    try
    {
      this.wWg = new WeakReference(paramView);
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
    return this.uFq;
  }
  
  public int getIntrinsicWidth()
  {
    return this.uFp;
  }
  
  public int getOpacity()
  {
    View localView = cVu();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.uFo != null) && (this.uFo.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void m(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.cxr())
    {
      int i = this.Aq.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Aq.width() - f, this.Aq.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.uFn = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    cxp();
    return super.onLevelChange(paramInt);
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.uFo.setAlpha(paramInt);
    View localView = cVu();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.uFo);
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
    this.uFo.setColorFilter(paramColorFilter);
    paramColorFilter = cVu();
    if ((paramColorFilter != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      paramColorFilter.setLayerPaint(this.uFo);
      return;
    }
    catch (NoSuchMethodError paramColorFilter)
    {
      c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    cxp();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */