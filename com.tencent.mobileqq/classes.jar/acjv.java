import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class acjv
  implements URLDrawable.URLDrawableListener
{
  acjv(acju paramacju) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    acju.a(this.a, paramURLDrawable);
    acho.b("GdtDrawableLoader", "onLoadCanceled " + acju.a(this.a));
    acju.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    acju.a(this.a, paramURLDrawable);
    acho.d("GdtDrawableLoader", "onLoadFialed " + acju.a(this.a), paramThrowable);
    if (!acju.a(this.a)) {
      acju.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    acju.a(this.a, paramURLDrawable);
    acho.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + acju.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    acju.a(this.a, paramURLDrawable);
    acho.b("GdtDrawableLoader", "onLoadSuccessed " + acju.a(this.a));
    acju.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjv
 * JD-Core Version:    0.7.0.1
 */