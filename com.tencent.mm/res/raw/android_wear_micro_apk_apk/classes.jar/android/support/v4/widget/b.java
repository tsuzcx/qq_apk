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
  private RadialGradient no;
  private Paint np = new Paint();
  
  b(a parama, int paramInt)
  {
    parama.nn = paramInt;
    G((int)rect().width());
  }
  
  private void G(int paramInt)
  {
    float f1 = paramInt / 2;
    float f2 = paramInt / 2;
    float f3 = this.nq.nn;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.no = new RadialGradient(f1, f2, f3, new int[] { 1023410176, 0 }, null, localTileMode);
    this.np.setShader(this.no);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    int i = this.nq.getWidth();
    int j = this.nq.getHeight();
    paramCanvas.drawCircle(i / 2, j / 2, i / 2, this.np);
    paramCanvas.drawCircle(i / 2, j / 2, i / 2 - this.nq.nn, paramPaint);
  }
  
  protected final void onResize(float paramFloat1, float paramFloat2)
  {
    super.onResize(paramFloat1, paramFloat2);
    G((int)paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.b
 * JD-Core Version:    0.7.0.1
 */