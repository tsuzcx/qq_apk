import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajfg
  implements View.OnClickListener
{
  public ajfg(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ajeg)paramView.getTag();
    if (((ajeg)localObject).a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(((ajeg)localObject).a.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (bgnt.d(this.a.a())) {
        break;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131693946), 0).b(this.a.a());
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(String.valueOf(((ajeg)localObject).a.req_uin.get()));
    ajga.a((structmsg.StructMsg)((ajeg)localObject).a.get());
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)((ajeg)localObject).a.get(), ((ajeg)localObject).c);
    String str1 = ((ajeg)localObject).a.msg.group_info.msg_alert.get();
    String str2 = ((ajeg)localObject).a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopNotifyAndRecommendView.b(this.a, 1, (structmsg.StructMsg)((ajeg)localObject).a.get());
      if ((((ajeg)localObject).a.msg.has()) && (((ajeg)localObject).a.msg.req_uin_nick.has())) {
        ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(str2, ((ajeg)localObject).a.req_uin.get() + "", ((ajeg)localObject).a.msg.req_uin_nick.get());
      }
      ajga.a(((ajeg)localObject).a, "unnormal_join");
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.h(this.a);
      this.a.jdField_a_of_type_Biau.c(2131717771);
      this.a.jdField_a_of_type_Biau.show();
      break;
      TroopNotifyAndRecommendView.b(this.a, 0, (structmsg.StructMsg)((ajeg)localObject).a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfg
 * JD-Core Version:    0.7.0.1
 */