import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class acmf
  implements URLDrawable.URLDrawableListener
{
  acmf(aclw paramaclw) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aclw.d(this.a);
    bbmy.a(this.a.a, 0, 2131628016, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aclw.d(this.a);
    bbmy.a(this.a.a, 0, 2131628016, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aclw.d(this.a);
    aclw.a(this.a, aclw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acmf
 * JD-Core Version:    0.7.0.1
 */