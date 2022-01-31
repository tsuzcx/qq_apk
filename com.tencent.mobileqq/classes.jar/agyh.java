import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class agyh
  implements URLDrawable.URLDrawableListener
{
  agyh(agyf paramagyf) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    agyf.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    agyf.a(this.a, paramURLDrawable);
    agyf.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = agyf.a(this.a);
    agyf.a(this.a, paramURLDrawable, l1 - l2);
    agyf.a(this.a, true);
    agyf.a(this.a).remove(paramURLDrawable);
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyh
 * JD-Core Version:    0.7.0.1
 */