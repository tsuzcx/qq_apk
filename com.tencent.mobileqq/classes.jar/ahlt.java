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
import com.tencent.mobileqq.widget.QQToast;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ahlt
  implements View.OnClickListener
{
  public ahlt(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ahkp)paramView.getTag();
    if (paramView.a.msg.group_msg_type.get() == 80)
    {
      paramView = TroopInfoActivity.a(String.valueOf(paramView.a.msg.group_code.get()), 5);
      TroopInfoActivity.a(this.a.getActivity(), paramView);
      return;
    }
    if (!bdee.d(this.a.getActivity()))
    {
      QQToast.a(this.a.a, this.a.getActivity().getString(2131694764), 0).b(this.a.a());
      return;
    }
    ((FriendListHandler)TroopSuspiciousFragment.a(this.a).a(1)).b(String.valueOf(paramView.a.req_uin.get()));
    ahlw.a((structmsg.StructMsg)paramView.a.get());
    TroopSuspiciousFragment.a(this.a, (structmsg.StructMsg)paramView.a.get(), paramView.c);
    String str1 = paramView.a.msg.group_info.msg_alert.get();
    String str2 = paramView.a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopSuspiciousFragment.a(this.a, 1, (structmsg.StructMsg)paramView.a.get());
      if ((paramView.a.msg.has()) && (paramView.a.msg.req_uin_nick.has())) {
        ((TroopManager)TroopSuspiciousFragment.a(this.a).getManager(52)).b(str2, paramView.a.req_uin.get() + "", paramView.a.msg.req_uin_nick.get());
      }
      ahlw.a(paramView.a, "unnormal_join");
    }
    for (;;)
    {
      TroopSuspiciousFragment.c(this.a);
      TroopSuspiciousFragment.a(this.a).c(2131719773);
      TroopSuspiciousFragment.a(this.a).show();
      return;
      TroopSuspiciousFragment.a(this.a, 0, (structmsg.StructMsg)paramView.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlt
 * JD-Core Version:    0.7.0.1
 */