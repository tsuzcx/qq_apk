import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class agts
  implements URLDrawable.URLDrawableListener
{
  agts(agtq paramagtq) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    agtq.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    agtq.a(this.a, paramURLDrawable);
    agtq.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = agtq.a(this.a);
    agtq.a(this.a, paramURLDrawable, l1 - l2);
    agtq.a(this.a, true);
    agtq.a(this.a).remove(paramURLDrawable);
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agts
 * JD-Core Version:    0.7.0.1
 */