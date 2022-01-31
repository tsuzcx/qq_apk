import android.os.SystemClock;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class acob
  implements URLDrawable.URLDrawableListener
{
  acob(acoa paramacoa, long paramLong) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage Load URLDrawable Successed, is to call showFastImage,queryTime = " + l);
    }
    if (l > 2000L) {
      return;
    }
    this.jdField_a_of_type_Acoa.a.jdField_a_of_type_MqqOsMqqHandler.sendMessage(this.jdField_a_of_type_Acoa.a.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(32));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acob
 * JD-Core Version:    0.7.0.1
 */