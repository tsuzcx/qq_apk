import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class aenw
  implements URLDrawable.URLDrawableListener
{
  aenw(aenv paramaenv) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aenv.d(this.a);
    QQToast.a(this.a.a, 0, 2131693762, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aenv.d(this.a);
    QQToast.a(this.a.a, 0, 2131693762, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aenv.d(this.a);
    aenv.a(this.a, aenv.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenw
 * JD-Core Version:    0.7.0.1
 */