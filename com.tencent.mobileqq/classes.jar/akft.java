import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class akft
  implements Runnable
{
  public akft(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    if (this.jdField_a_of_type_Boolean) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435266);
    }
    for (String str2 = "0";; str2 = "1")
    {
      if (str1 != null) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, str1, 0).b(this.jdField_a_of_type_Int);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.jdField_a_of_type_JavaLangString, str2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akft
 * JD-Core Version:    0.7.0.1
 */