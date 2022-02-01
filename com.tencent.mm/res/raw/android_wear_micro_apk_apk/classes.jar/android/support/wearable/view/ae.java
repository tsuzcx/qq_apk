package android.support.wearable.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.p;
import android.util.DisplayMetrics;

final class ae
  extends p
{
  private final z Hk;
  
  public ae(Context paramContext, z paramz)
  {
    super(paramContext);
    this.Hk = paramz;
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF at(int paramInt)
  {
    if (paramInt < this.Hk.fT()) {
      return new PointF(0.0F, -1.0F);
    }
    return new PointF(0.0F, 1.0F);
  }
  
  public final int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt3 + paramInt4) / 2 - (paramInt1 + paramInt2) / 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ae
 * JD-Core Version:    0.7.0.1
 */