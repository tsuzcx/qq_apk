import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class abtw
  implements URLDrawable.URLDrawableListener
{
  abtw(abtv paramabtv) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    abtv.a(this.a, paramURLDrawable);
    abrl.b("GdtDrawableLoader", "onLoadCanceled " + abtv.a(this.a));
    abtv.a(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    abtv.a(this.a, paramURLDrawable);
    abrl.d("GdtDrawableLoader", "onLoadFialed " + abtv.a(this.a), paramThrowable);
    if (!abtv.a(this.a)) {
      abtv.a(this.a, false);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    abtv.a(this.a, paramURLDrawable);
    abrl.b("GdtDrawableLoader", "onLoadProgressed " + paramInt + " " + abtv.a(this.a));
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    abtv.a(this.a, paramURLDrawable);
    abrl.b("GdtDrawableLoader", "onLoadSuccessed " + abtv.a(this.a));
    abtv.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtw
 * JD-Core Version:    0.7.0.1
 */