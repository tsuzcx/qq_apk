import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class akni
  implements Runnable
{
  public akni(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_Boolean) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435282);
    }
    if (str != null) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, str, 0).b(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akni
 * JD-Core Version:    0.7.0.1
 */