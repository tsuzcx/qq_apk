import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class acwu
  implements URLDrawable.URLDrawableListener
{
  acwu(acwl paramacwl) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    acwl.d(this.a);
    bcql.a(this.a.a, 0, 2131693658, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    acwl.d(this.a);
    bcql.a(this.a.a, 0, 2131693658, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    acwl.d(this.a);
    acwl.a(this.a, acwl.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwu
 * JD-Core Version:    0.7.0.1
 */