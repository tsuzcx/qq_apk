import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajei
  implements View.OnClickListener
{
  public ajei(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    ajeg localajeg = (ajeg)paramView.getTag();
    if (localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 2)
    {
      this.a.a(localajeg);
      if (localajeg.jdField_a_of_type_Int == 82) {
        bdla.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajei
 * JD-Core Version:    0.7.0.1
 */