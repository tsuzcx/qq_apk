import android.content.Context;
import android.graphics.Canvas;
import com.tencent.image.URLImageView;

public final class acpu
  extends URLImageView
{
  private acxl a = new acxl();
  
  public acpu(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(float paramFloat)
  {
    this.a.a(Double.valueOf(paramFloat * 2.0F).intValue(), Double.valueOf(paramFloat * 2.0F).intValue());
    this.a.a(paramFloat, paramFloat);
    this.a.a(paramFloat);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.a(paramCanvas, getDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpu
 * JD-Core Version:    0.7.0.1
 */