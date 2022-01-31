import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.DrawableContainer.ContainerState;
import com.tencent.mobileqq.widget.XfermodeDrawable;

public class alfe
  extends DrawableContainer.ContainerState
{
  public Xfermode a;
  
  public Drawable newDrawable()
  {
    return new XfermodeDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfe
 * JD-Core Version:    0.7.0.1
 */