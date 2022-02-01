import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajft
  implements View.OnClickListener
{
  public ajft(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    azry.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView.jdField_a_of_type_Ajdx.a(), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.action_uin.get()), -1, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajft
 * JD-Core Version:    0.7.0.1
 */