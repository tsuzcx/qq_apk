import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.forward.ForwardMarketFaceOption;
import com.tencent.mobileqq.utils.ImageUtil;

class aday
  implements URLDrawable.URLDrawableListener
{
  aday(adax paramadax) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(ImageUtil.a(paramURLDrawable, 36, 100, this.a.a.a));
    this.a.a.a(paramURLDrawable, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aday
 * JD-Core Version:    0.7.0.1
 */