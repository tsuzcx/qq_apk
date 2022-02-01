import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ailr
  implements View.OnClickListener
{
  public ailr(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof aijj)) {}
    aijj localaijj;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localaijj = (aijj)paramView.getTag();
      } while (localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 2);
      this.a.a(localaijj);
      if (localaijj.jdField_a_of_type_Int == 82) {
        bcef.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", localaijj.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      }
    } while (localaijj.jdField_a_of_type_Int != 91);
    Object localObject = (TroopManager)this.a.a.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(String.valueOf(localaijj.f));
      if (localObject == null) {}
    }
    for (long l = ((TroopInfo)localObject).dwGroupClassExt;; l = 0L)
    {
      bcef.b(null, "dc00898", "", String.valueOf(localaijj.f), "0X800B4B4", "0X800B4B4", 0, 0, String.valueOf(l), "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailr
 * JD-Core Version:    0.7.0.1
 */