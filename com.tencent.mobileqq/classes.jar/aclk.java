import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aclk
  implements View.OnClickListener
{
  public aclk(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L)) {
      return;
    }
    TroopRequestActivity.c = l;
    if (((ajxl)this.a.app.getManager(51)).b(this.a.l)) {
      paramView = new ProfileActivity.AllInOne(this.a.l, 1);
    }
    for (;;)
    {
      axqy.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, paramView);
      return;
      if ((this.a.a.msg.group_msg_type.get() != 2) || (this.a.a.msg.sub_type.get() != 3)) {
        break;
      }
      paramView = new ProfileActivity.AllInOne(this.a.l, 26);
      paramView.d = 1;
    }
    paramView = new ProfileActivity.AllInOne(this.a.l, 24);
    banb.a(this.a.a, paramView);
    switch (this.a.b)
    {
    }
    for (;;)
    {
      break;
      paramView.l = 3;
      break;
      paramView.l = 1;
      break;
      paramView.l = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aclk
 * JD-Core Version:    0.7.0.1
 */