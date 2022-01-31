import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class aaul
  implements URLDrawable.URLDrawableListener
{
  aaul(aauk paramaauk) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aauk.a(this.a, paramURLDrawable);
    aase.b("GdtDrawableLoader", "onLoadCanceled " + aauk.a(this.a));
    aauk.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aauk.a(this.a, paramURLDrawable);
    aase.d("GdtDrawableLoader", "onLoadFialed " + aauk.a(this.a), paramThrowable);
    if (!aauk.a(this.a)) {
      aauk.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    aauk.a(this.a, paramURLDrawable);
    aase.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + aauk.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aauk.a(this.a, paramURLDrawable);
    aase.b("GdtDrawableLoader", "onLoadSuccessed " + aauk.a(this.a));
    aauk.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaul
 * JD-Core Version:    0.7.0.1
 */