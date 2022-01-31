import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ahlf
  implements View.OnClickListener
{
  public ahlf(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ahjv)) {}
    do
    {
      do
      {
        return;
        paramView = (ahjv)paramView.getTag();
      } while (paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 2);
      this.a.a(paramView);
    } while (paramView.jdField_a_of_type_Int != 82);
    azmj.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */