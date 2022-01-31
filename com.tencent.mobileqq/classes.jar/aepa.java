import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aepa
  implements View.OnClickListener
{
  aepa(aeom paramaeom) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80087E6");
    aekp.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepa
 * JD-Core Version:    0.7.0.1
 */