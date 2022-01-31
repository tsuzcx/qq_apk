import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class afnq
  implements bfoq
{
  public afnq(TroopActivity paramTroopActivity, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = (akfd)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(22);
    long l = 0L;
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    case 0: 
      for (i = 0;; i = 1)
      {
        this.jdField_a_of_type_Bfol.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().c(ajsf.W, 9000, -paramInt);
        paramView = (akfc)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getManager(33);
        if (i == 0) {
          break;
        }
        paramView.a(ajsf.W, 9000);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.getHandler(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        paramInt = aydb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
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
      i = akfd.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app);
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
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app.a().b(ajsf.N, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (i = 1;; i = 0)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.app, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      axqw.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_del", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(ajsf.W, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afnq
 * JD-Core Version:    0.7.0.1
 */