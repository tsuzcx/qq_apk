import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class acxn
  implements URLDrawable.URLDrawableListener
{
  acxn(acxm paramacxm) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    acxm.a(this.a, paramURLDrawable);
    acvc.b("GdtDrawableLoader", "onLoadCanceled " + acxm.a(this.a));
    acxm.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    acxm.a(this.a, paramURLDrawable);
    acvc.d("GdtDrawableLoader", "onLoadFialed " + acxm.a(this.a), paramThrowable);
    if (!acxm.a(this.a)) {
      acxm.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    acxm.a(this.a, paramURLDrawable);
    acvc.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + acxm.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    acxm.a(this.a, paramURLDrawable);
    acvc.b("GdtDrawableLoader", "onLoadSuccessed " + acxm.a(this.a));
    acxm.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxn
 * JD-Core Version:    0.7.0.1
 */