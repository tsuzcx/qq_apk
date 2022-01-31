import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class acwy
  implements URLDrawable.URLDrawableListener
{
  acwy(acwp paramacwp) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    acwp.d(this.a);
    bcpw.a(this.a.a, 0, 2131693657, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    acwp.d(this.a);
    bcpw.a(this.a.a, 0, 2131693657, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    acwp.d(this.a);
    acwp.a(this.a, acwp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwy
 * JD-Core Version:    0.7.0.1
 */