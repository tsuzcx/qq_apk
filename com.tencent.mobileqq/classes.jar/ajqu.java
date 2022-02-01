import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajqu
  implements View.OnClickListener
{
  public ajqu(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ajov)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ajov localajov = (ajov)paramView.getTag();
      if (localajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 2)
      {
        this.a.a(localajov);
        if (localajov.jdField_a_of_type_Int == 82) {
          bdll.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", localajov.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqu
 * JD-Core Version:    0.7.0.1
 */