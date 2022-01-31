package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class h
{
  private static final j oW = new j();
  private EdgeEffect oV;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      oW = new i();
      return;
    }
  }
  
  @Deprecated
  public h(Context paramContext)
  {
    this.oV = new EdgeEffect(paramContext);
  }
  
  public static void a(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    oW.a(paramEdgeEffect, paramFloat1, paramFloat2);
  }
  
  @Deprecated
  public final boolean L(int paramInt)
  {
    this.oV.onAbsorb(paramInt);
    return true;
  }
  
  @Deprecated
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    oW.a(this.oV, paramFloat1, paramFloat2);
    return true;
  }
  
  @Deprecated
  public final boolean ci()
  {
    this.oV.onRelease();
    return this.oV.isFinished();
  }
  
  @Deprecated
  public final boolean draw(Canvas paramCanvas)
  {
    return this.oV.draw(paramCanvas);
  }
  
  @Deprecated
  public final boolean isFinished()
  {
    return this.oV.isFinished();
  }
  
  @Deprecated
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.oV.setSize(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.h
 * JD-Core Version:    0.7.0.1
 */