import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class aapw
  implements URLDrawable.URLDrawableListener
{
  aapw(aapv paramaapv) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aapv.a(this.a, paramURLDrawable);
    aanp.b("GdtDrawableLoader", "onLoadCanceled " + aapv.a(this.a));
    aapv.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aapv.a(this.a, paramURLDrawable);
    aanp.d("GdtDrawableLoader", "onLoadFialed " + aapv.a(this.a), paramThrowable);
    if (!aapv.a(this.a)) {
      aapv.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    aapv.a(this.a, paramURLDrawable);
    aanp.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + aapv.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    aapv.a(this.a, paramURLDrawable);
    aanp.b("GdtDrawableLoader", "onLoadSuccessed " + aapv.a(this.a));
    aapv.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapw
 * JD-Core Version:    0.7.0.1
 */