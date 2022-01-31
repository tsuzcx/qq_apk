package android.support.wearable.view;

import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;

final class d
{
  private final Shader AK = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, -16777216, 0, Shader.TileMode.CLAMP);
  private final Paint AL = new Paint();
  private final Matrix AM = new Matrix();
  
  public d()
  {
    this.AL.setShader(this.AK);
    this.AL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.d
 * JD-Core Version:    0.7.0.1
 */