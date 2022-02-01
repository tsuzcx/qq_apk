import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.QQToast;

class agir
  implements URLDrawable.URLDrawableListener
{
  agir(agiq paramagiq) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    agiq.d(this.a);
    QQToast.a(this.a.a, 0, 2131693118, 1).a();
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    agiq.d(this.a);
    QQToast.a(this.a.a, 0, 2131693118, 1).a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    agiq.d(this.a);
    agiq.a(this.a, agiq.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agir
 * JD-Core Version:    0.7.0.1
 */