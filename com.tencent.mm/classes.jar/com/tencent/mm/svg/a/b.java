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
  protected int IPX = 0;
  protected boolean IPY = false;
  protected Paint IPZ = new Paint();
  protected WeakReference<View> IQa;
  protected int IQb = 0;
  protected int IQc = 0;
  protected int IQd = 0;
  protected int IQe = 0;
  protected float IQf;
  protected final Rect Ko = new Rect();
  public long mDuration = 0L;
  protected ColorFilter xh;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.IQd = paramInt1;
    this.IQe = paramInt2;
    this.IQf = 1.0F;
    this.IQb = this.IQd;
    this.IQc = this.IQe;
    setLevel(10000);
    this.IPX = paramInt3;
  }
  
  private void fuc()
  {
    View localView = a.B(this);
    gc(localView);
    if (localView != null)
    {
      if (this.xh != null) {
        setColorFilter(this.xh);
      }
      a.b(localView, this.IPZ);
    }
  }
  
  protected final void fua()
  {
    this.Ko.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void fub()
  {
    if (this.IPY)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Ko);
    }
    this.IPY = false;
  }
  
  /* Error */
  protected final View fud()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/mm/svg/a/b:IQa	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 109	com/tencent/mm/svg/a/b:IQa	Ljava/lang/ref/WeakReference;
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
  
  protected final void gc(View paramView)
  {
    try
    {
      this.IQa = new WeakReference(paramView);
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
    return this.IQc;
  }
  
  public int getIntrinsicWidth()
  {
    return this.IQb;
  }
  
  public int getOpacity()
  {
    View localView = fud();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.IPZ != null) && (this.IPZ.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void o(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.fuh())
    {
      int i = this.Ko.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Ko.width() - f, this.Ko.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.IPY = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    fuc();
    return super.onLevelChange(paramInt);
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.IPZ.setAlpha(paramInt);
    View localView = fud();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.IPZ);
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
    this.IPZ.setColorFilter(paramColorFilter);
    View localView = fud();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.IPZ);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.xh = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    fuc();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */