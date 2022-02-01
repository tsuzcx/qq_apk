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
  protected int HcH = 0;
  protected boolean HcI = false;
  protected Paint HcJ = new Paint();
  protected WeakReference<View> HcK;
  protected int HcL = 0;
  protected int HcM = 0;
  protected int HcN = 0;
  protected int HcO = 0;
  protected float HcP;
  protected final Rect Iw = new Rect();
  public long mDuration = 0L;
  protected ColorFilter vo;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.HcN = paramInt1;
    this.HcO = paramInt2;
    this.HcP = 1.0F;
    this.HcL = this.HcN;
    this.HcM = this.HcO;
    setLevel(10000);
    this.HcH = paramInt3;
  }
  
  private void fdU()
  {
    View localView = a.B(this);
    fN(localView);
    if (localView != null)
    {
      if (this.vo != null) {
        setColorFilter(this.vo);
      }
      a.b(localView, this.HcJ);
    }
  }
  
  protected final void fN(View paramView)
  {
    try
    {
      this.HcK = new WeakReference(paramView);
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
  
  protected final void fdS()
  {
    this.Iw.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void fdT()
  {
    if (this.HcI)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.Iw);
    }
    this.HcI = false;
  }
  
  /* Error */
  protected final View fdV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/tencent/mm/svg/a/b:HcK	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 89	com/tencent/mm/svg/a/b:HcK	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 118	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 120	android/view/View
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
    return this.HcM;
  }
  
  public int getIntrinsicWidth()
  {
    return this.HcL;
  }
  
  public int getOpacity()
  {
    View localView = fdV();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.HcJ != null) && (this.HcJ.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.HcI = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    fdU();
    return super.onLevelChange(paramInt);
  }
  
  protected final void p(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.fdZ())
    {
      int i = this.Iw.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.Iw.width() - f, this.Iw.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.HcJ.setAlpha(paramInt);
    View localView = fdV();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.HcJ);
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
    this.HcJ.setColorFilter(paramColorFilter);
    View localView = fdV();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.HcJ);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.vo = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    fdU();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */