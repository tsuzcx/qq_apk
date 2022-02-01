import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class agmh
  implements View.OnClickListener
{
  agmh(agmf paramagmf) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).actionType = "330";
      ((QZoneClickReport.ReportInfo)localObject).subactionType = "3";
      ((QZoneClickReport.ReportInfo)localObject).reserves = "2";
      QZoneClickReport.startReportImediately(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject);
      localObject = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToUserHome((Activity)this.a.jdField_a_of_type_AndroidContentContext, (QZoneHelper.UserInfo)localObject, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmh
 * JD-Core Version:    0.7.0.1
 */