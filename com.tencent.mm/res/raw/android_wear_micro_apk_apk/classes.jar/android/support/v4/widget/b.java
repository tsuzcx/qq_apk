package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

final class b
  extends OvalShape
{
  private RadialGradient pc;
  private Paint pd = new Paint();
  
  b(a parama, int paramInt)
  {
    parama.pb = paramInt;
    R((int)rect().width());
  }
  
  private void R(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = paramInt / 2;
    float f3 = this.pe.pb;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.pc = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
    this.pd.setShader(this.pc);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.pe.getWidth();
    int j = this.pe.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.pd);
    paramCanvas.drawCircle(i / 2, j / 2, i / 2 - this.pe.pb, paramPaint);
  }
  
  protected final void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    R((int)paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.b
 * JD-Core Version:    0.7.0.1
 */