import android.support.annotation.Nullable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import java.lang.ref.WeakReference;

public class alec
{
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public alec(QQToast paramQQToast, QQToast.IToastValidListener paramIToastValidListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = paramQQToast;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIToastValidListener);
  }
  
  private boolean a()
  {
    QQToast.IToastValidListener localIToastValidListener = (QQToast.IToastValidListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localIToastValidListener != null) && (localIToastValidListener.a());
  }
  
  @Nullable
  QQToast a()
  {
    if (a()) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alec
 * JD-Core Version:    0.7.0.1
 */