import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajgi
  implements View.OnClickListener
{
  public ajgi(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ajfc)paramView.getTag();
    if (((ajfc)localObject).a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(((ajfc)localObject).a.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.a(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isNetSupport(this.a.a())) {
        break;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.a().getString(2131694253), 0).b(this.a.a());
    }
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(((ajfc)localObject).a.req_uin.get()));
    ajhg.a((structmsg.StructMsg)((ajfc)localObject).a.get());
    TroopNotifyAndRecommendView.a(this.a, (structmsg.StructMsg)((ajfc)localObject).a.get(), ((ajfc)localObject).c);
    String str1 = ((ajfc)localObject).a.msg.group_info.msg_alert.get();
    String str2 = ((ajfc)localObject).a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopNotifyAndRecommendView.b(this.a, 1, (structmsg.StructMsg)((ajfc)localObject).a.get());
      if ((((ajfc)localObject).a.msg.has()) && (((ajfc)localObject).a.msg.req_uin_nick.has())) {
        ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(str2, ((ajfc)localObject).a.req_uin.get() + "", ((ajfc)localObject).a.msg.req_uin_nick.get());
      }
      ajhg.a(((ajfc)localObject).a, "unnormal_join");
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.o(this.a);
      this.a.jdField_a_of_type_Bisl.c(2131718527);
      this.a.jdField_a_of_type_Bisl.show();
      break;
      TroopNotifyAndRecommendView.b(this.a, 0, (structmsg.StructMsg)((ajfc)localObject).a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgi
 * JD-Core Version:    0.7.0.1
 */