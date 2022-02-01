import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class afyx
  implements URLDrawable.URLDrawableListener
{
  afyx(afyw paramafyw) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    afyw.d(this.a);
    QQToast.a(this.a.a, 0, 2131693109, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    afyw.d(this.a);
    QQToast.a(this.a.a, 0, 2131693109, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afyw.d(this.a);
    afyw.a(this.a, afyw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyx
 * JD-Core Version:    0.7.0.1
 */