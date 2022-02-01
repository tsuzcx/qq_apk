import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class aftc
  implements URLDrawable.URLDrawableListener
{
  aftc(afsv paramafsv) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    afsv.d(this.a);
    QQToast.a(this.a.a, 0, 2131693358, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    afsv.d(this.a);
    QQToast.a(this.a.a, 0, 2131693358, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afsv.d(this.a);
    afsv.a(this.a, afsv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftc
 * JD-Core Version:    0.7.0.1
 */