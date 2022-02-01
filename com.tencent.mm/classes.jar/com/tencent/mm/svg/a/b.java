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
  protected final Rect KV = new Rect();
  protected int VKA = 0;
  protected int VKB = 0;
  protected int VKC = 0;
  protected int VKD = 0;
  protected float VKE;
  protected int VKw = 0;
  protected boolean VKx = false;
  protected Paint VKy = new Paint();
  protected WeakReference<View> VKz;
  protected ColorFilter jC;
  public long mDuration = 0L;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.VKC = paramInt1;
    this.VKD = paramInt2;
    this.VKE = 1.0F;
    this.VKA = this.VKC;
    this.VKB = this.VKD;
    setLevel(10000);
    this.VKw = paramInt3;
  }
  
  private void hCi()
  {
    View localView = a.I(this);
    hB(localView);
    if (localView != null)
    {
      if (this.jC != null) {
        setColorFilter(this.jC);
      }
      a.b(localView, this.VKy);
    }
  }
  
  protected final void B(Canvas paramCanvas)
  {
    if (com.tencent.mm.svg.b.b.hCo())
    {
      int i = this.KV.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.KV.width() - f, this.KV.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.VKB;
  }
  
  public int getIntrinsicWidth()
  {
    return this.VKA;
  }
  
  public int getOpacity()
  {
    View localView = hCj();
    if ((localView != null) && (localView.getAlpha() < 1.0F)) {}
    while ((this.VKy != null) && (this.VKy.getAlpha() < 255)) {
      return -3;
    }
    return 0;
  }
  
  protected final void hB(View paramView)
  {
    try
    {
      this.VKz = new WeakReference(paramView);
      return;
    }
    finally
    {
      paramView = finally;
      throw paramView;
    }
  }
  
  protected final void hCg()
  {
    this.KV.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
  }
  
  protected final void hCh()
  {
    if (this.VKx)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.KV);
    }
    this.VKx = false;
  }
  
  /* Error */
  protected final View hCj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	com/tencent/mm/svg/a/b:VKz	Ljava/lang/ref/WeakReference;
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
    //   18: getfield 165	com/tencent/mm/svg/a/b:VKz	Ljava/lang/ref/WeakReference;
    //   21: invokevirtual 189	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   24: checkcast 152	android/view/View
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
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.VKx = true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    hCi();
    return super.onLevelChange(paramInt);
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    this.VKy.setAlpha(paramInt);
    View localView = hCj();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    try
    {
      localView.setLayerPaint(this.VKy);
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
    this.VKy.setColorFilter(paramColorFilter);
    View localView = hCj();
    if ((localView != null) && (Build.VERSION.SDK_INT >= 17)) {}
    while (localView != null) {
      try
      {
        localView.setLayerPaint(this.VKy);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "samsung", new Object[0]);
        return;
      }
    }
    this.jC = paramColorFilter;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    hCi();
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.svg.a.b
 * JD-Core Version:    0.7.0.1
 */