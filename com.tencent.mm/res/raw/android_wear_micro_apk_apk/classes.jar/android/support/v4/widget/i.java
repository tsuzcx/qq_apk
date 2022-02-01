package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class i
{
  private static final k qM = new k();
  private EdgeEffect qL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      qM = new j();
      return;
    }
  }
  
  @Deprecated
  public i(Context paramContext)
  {
    this.qL = new EdgeEffect(paramContext);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    qM.a(paramEdgeEffect, paramFloat1, paramFloat2);
  }
  
  @Deprecated
  public final boolean W(int paramInt)
  {
    this.qL.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    qM.a(this.qL, paramFloat1, paramFloat2);
    return true;
  }
  
  @Deprecated
  public final boolean cn()
  {
    this.qL.onRelease();
    return this.qL.isFinished();
  }
  
  @Deprecated
  public final boolean draw(Canvas paramCanvas)
  {
    return this.qL.draw(paramCanvas);
  }
  
  @Deprecated
  public final boolean isFinished()
  {
    return this.qL.isFinished();
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.qL.setSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.i
 * JD-Core Version:    0.7.0.1
 */