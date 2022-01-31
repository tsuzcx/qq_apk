import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ahpj
  implements bhuk
{
  public ahpj(TroopActivity paramTroopActivity, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = (ambh)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(22);
    long l = 0L;
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    case 0: 
      for (i = 0;; i = 1)
      {
        this.jdField_a_of_type_Bhuf.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().d(alof.W, 9000, -paramInt);
        paramView = (ambg)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(33);
        if (i == 0) {
          break;
        }
        paramView.a(alof.W, 9000);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        paramInt = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(NotificationView.class);
        MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(TroopNotifyAndRecommendView.class);
        if (paramView != null) {
          paramView.sendEmptyMessage(1014);
        }
        if (localMqqHandler != null) {
          localMqqHandler.sendEmptyMessage(1014);
        }
      }
    }
    paramInt = i;
    if (paramView != null)
    {
      i = ambh.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
      paramView.c();
      paramView.b();
      paramView.a(1);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(TroopNotifyAndRecommendView.class);
      paramInt = i;
      if (paramView != null)
      {
        paramView.sendEmptyMessage(105);
        paramInt = i;
      }
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().b(alof.N, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (i = 1;; i = 0)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      azqs.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_del", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(alof.W, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpj
 * JD-Core Version:    0.7.0.1
 */