import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajgo
  implements View.OnClickListener
{
  public ajgo(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ajeg)) {}
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject2 = (ajeg)paramView.getTag();
        } while (((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 2);
        this.a.a((ajeg)localObject2);
        if (((ajeg)localObject2).jdField_a_of_type_Int == 82) {
          bdla.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", ((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        }
      } while (((ajeg)localObject2).jdField_a_of_type_Int != 91);
      localObject1 = (TroopManager)this.a.a.getManager(QQManagerFactory.TROOP_MANAGER);
    } while ((localObject1 == null) || (!(((ajeg)localObject2).jdField_a_of_type_Ajhy instanceof ajhw)));
    Object localObject2 = (ajhw)((ajeg)localObject2).jdField_a_of_type_Ajhy;
    Object localObject1 = ((TroopManager)localObject1).b(String.valueOf(((ajhw)localObject2).e));
    if (localObject1 != null) {}
    for (long l = ((TroopInfo)localObject1).dwGroupClassExt;; l = 0L)
    {
      bdla.b(null, "dc00898", "", String.valueOf(((ajhw)localObject2).e), "0X800B4B4", "0X800B4B4", 0, 0, String.valueOf(l), "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgo
 * JD-Core Version:    0.7.0.1
 */