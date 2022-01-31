import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aglr
  implements View.OnClickListener
{
  aglr(agld paramagld) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80087E6");
    aghg.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglr
 * JD-Core Version:    0.7.0.1
 */