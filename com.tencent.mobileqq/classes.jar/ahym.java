import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahym
  implements View.OnClickListener
{
  ahym(ahyk paramahyk) {}
  
  public void onClick(View paramView)
  {
    if (!ampj.e()) {
      ((amhd)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().a(this.a.a(), 319);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "[onClick] click audio button too fast.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahym
 * JD-Core Version:    0.7.0.1
 */