import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;

class ahgi
  implements View.OnClickListener
{
  ahgi(ahgg paramahgg) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = new blrv();
      ((blrv)localObject).c = "330";
      ((blrv)localObject).d = "3";
      ((blrv)localObject).e = "2";
      QZoneClickReport.startReportImediately(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (blrv)localObject);
      localObject = blsi.a();
      blsb.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (blsi)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgi
 * JD-Core Version:    0.7.0.1
 */