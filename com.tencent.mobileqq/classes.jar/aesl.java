import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class aesl
  implements URLDrawable.URLDrawableListener
{
  aesl(aesk paramaesk) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aesk.d(this.a);
    QQToast.a(this.a.a, 0, 2131693764, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aesk.d(this.a);
    QQToast.a(this.a.a, 0, 2131693764, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aesk.d(this.a);
    aesk.a(this.a, aesk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesl
 * JD-Core Version:    0.7.0.1
 */