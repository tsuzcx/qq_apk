import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public abstract class aaop
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaop
 * JD-Core Version:    0.7.0.1
 */