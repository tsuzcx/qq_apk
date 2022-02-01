import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class aimd
  implements View.OnClickListener
{
  public aimd(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aikf)paramView.getTag();
    if (((aikf)localObject).a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.a(String.valueOf(((aikf)localObject).a.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.getActivity(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NetworkUtil.isNetSupport(this.a.getActivity())) {
        break;
      }
      QQToast.a(this.a.a, this.a.getActivity().getString(2131694062), 0).b(this.a.a());
    }
    ((FriendListHandler)TroopSuspiciousFragment.a(this.a).getBusinessHandler(1)).getFriendInfo(String.valueOf(((aikf)localObject).a.req_uin.get()));
    aimg.a((structmsg.StructMsg)((aikf)localObject).a.get());
    TroopSuspiciousFragment.a(this.a, (structmsg.StructMsg)((aikf)localObject).a.get(), ((aikf)localObject).c);
    String str1 = ((aikf)localObject).a.msg.group_info.msg_alert.get();
    String str2 = ((aikf)localObject).a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopSuspiciousFragment.a(this.a, 1, (structmsg.StructMsg)((aikf)localObject).a.get());
      if ((((aikf)localObject).a.msg.has()) && (((aikf)localObject).a.msg.req_uin_nick.has())) {
        ((TroopManager)TroopSuspiciousFragment.a(this.a).getManager(52)).a(str2, ((aikf)localObject).a.req_uin.get() + "", ((aikf)localObject).a.msg.req_uin_nick.get());
      }
      aimg.a(((aikf)localObject).a, "unnormal_join");
    }
    for (;;)
    {
      TroopSuspiciousFragment.c(this.a);
      TroopSuspiciousFragment.a(this.a).c(2131718142);
      TroopSuspiciousFragment.a(this.a).show();
      break;
      TroopSuspiciousFragment.a(this.a, 0, (structmsg.StructMsg)((aikf)localObject).a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimd
 * JD-Core Version:    0.7.0.1
 */