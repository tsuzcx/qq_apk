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
  protected int FDE = 0;
  protected boolean FDF = false;
  protected Paint FDG = new Paint();
  protected WeakReference<View> FDH;
  protected int FDI = 0;
  protected int FDJ = 0;
  protected int FDK = 0;
  protected int FDL = 0;
  protected float FDM;
  protected final Rect Hy = new Rect();
  public long mDuration = 0L;
  protected ColorFilter up;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.FDK = paramInt1;
    this.FDL = paramInt2;
    this.FDM = 1.0F;
    this.FDI = this.FDK;
    this.FDJ = this.FDL;
    setLevel(10000);
    this.FDE = paramInt3;
  }
  
  private void eOq()
  {
    View localView = a.C(this);
    fA(localView);
    if (localView != null)
    {
      if (this.up != null) {
        setColorFilter(this.up);
      }
      a.b(localView, this.FDG);
    }
  }
  
  protected final void eOo()
  {
    this.Hy.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void eOp()
  {
    if (this.FDF)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Hy);
    }
    this.FDF = false;
  }
  
  /* Error */
  protected final View eOr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/mm/svg/a/b:FDH	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 109	com/tencent/mm/svg/a/b:FDH	Ljava/lang/ref/WeakReference;
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
  
  protected final void fA(View paramView)
  {
    try
    {
      this.FDH = new WeakReference(paramView);
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
    return this.FDJ;
  }
  
  public int getIntrinsicWidth()
  {
    return this.FDI;
  }
  
  public int getOpacity()
  {
    View localView = eOr();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.FDG != null) && (this.FDG.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.FDF = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    eOq();
    return super.onLevelChange(paramInt);
  }
  
  protected final void p(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.eOv())
    {
      int i = this.Hy.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Hy.width() - f, this.Hy.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.FDG.setAlpha(paramInt);
    View localView = eOr();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.FDG);
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
    this.FDG.setColorFilter(paramColorFilter);
    View localView = eOr();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.FDG);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.up = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    eOq();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */