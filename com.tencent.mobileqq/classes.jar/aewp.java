import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aewp
  implements URLDrawable.URLDrawableListener
{
  aewp(aewn paramaewn) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    aewn.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aewn.a(this.a, paramURLDrawable);
    aewn.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = aewn.a(this.a);
    aewn.a(this.a, paramURLDrawable, l1 - l2);
    aewn.a(this.a, true);
    aewn.a(this.a).remove(paramURLDrawable);
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewp
 * JD-Core Version:    0.7.0.1
 */