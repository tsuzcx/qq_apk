import android.arch.lifecycle.MutableLiveData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class alkq
  implements URLDrawable.URLDrawableListener
{
  alkq(alkp paramalkp, QQAppInterface paramQQAppInterface) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadCanceled");
    this.jdField_a_of_type_Alkp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadFailed");
    this.jdField_a_of_type_Alkp.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("NewerGuideBannerViewModel", 1, "onLoadSuccess");
    alkp.a(this.jdField_a_of_type_Alkp).setValue(alkb.a(alkp.a(this.jdField_a_of_type_Alkp), true));
    alkp.a(this.jdField_a_of_type_Alkp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkq
 * JD-Core Version:    0.7.0.1
 */