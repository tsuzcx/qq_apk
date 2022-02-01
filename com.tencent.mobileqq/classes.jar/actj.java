import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class actj
  implements URLDrawable.URLDrawableListener
{
  actj(acti paramacti) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    acti.a(this.a, paramURLDrawable);
    acqy.b("GdtDrawableLoader", "onLoadCanceled " + acti.a(this.a));
    acti.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    acti.a(this.a, paramURLDrawable);
    acqy.d("GdtDrawableLoader", "onLoadFialed " + acti.a(this.a), paramThrowable);
    if (!acti.a(this.a)) {
      acti.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    acti.a(this.a, paramURLDrawable);
    acqy.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + acti.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    acti.a(this.a, paramURLDrawable);
    acqy.b("GdtDrawableLoader", "onLoadSuccessed " + acti.a(this.a));
    acti.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actj
 * JD-Core Version:    0.7.0.1
 */