import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class afbk
  implements URLDrawable.URLDrawableListener
{
  afbk(afbj paramafbj) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    afbj.d(this.a);
    QQToast.a(this.a.a, 0, 2131693180, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    afbj.d(this.a);
    QQToast.a(this.a.a, 0, 2131693180, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afbj.d(this.a);
    afbj.a(this.a, afbj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbk
 * JD-Core Version:    0.7.0.1
 */