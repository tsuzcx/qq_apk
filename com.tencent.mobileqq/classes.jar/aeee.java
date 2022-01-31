import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aeee
  implements View.OnClickListener
{
  aeee(aedo paramaedo) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80087E6");
    adzs.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeee
 * JD-Core Version:    0.7.0.1
 */