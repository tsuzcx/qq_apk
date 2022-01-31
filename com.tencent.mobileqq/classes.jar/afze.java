import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneClickReport;

class afze
  implements View.OnClickListener
{
  afze(afzc paramafzc) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      paramView = new bjdn();
      paramView.c = "330";
      paramView.d = "3";
      paramView.e = "2";
      QZoneClickReport.startReportImediately(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      paramView = bjea.a();
      bjdt.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afze
 * JD-Core Version:    0.7.0.1
 */