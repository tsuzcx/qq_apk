import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneClickReport;

class adyc
  implements View.OnClickListener
{
  adyc(adya paramadya) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      paramView = new bgyj();
      paramView.c = "330";
      paramView.d = "3";
      paramView.e = "2";
      QZoneClickReport.startReportImediately(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      paramView = bgyw.a();
      bgyp.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyc
 * JD-Core Version:    0.7.0.1
 */