import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afnq
  implements View.OnClickListener
{
  public afnq(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopRequestActivity.c = l;
    if (((anmw)this.a.app.getManager(51)).b(this.a.l)) {
      localAllInOne = new ProfileActivity.AllInOne(this.a.l, 1);
    }
    for (;;)
    {
      bcst.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, localAllInOne);
      break;
      if ((this.a.a.msg.group_msg_type.get() != 2) || (this.a.a.msg.sub_type.get() != 3)) {
        break label224;
      }
      localAllInOne = new ProfileActivity.AllInOne(this.a.l, 26);
      localAllInOne.d = 1;
    }
    label224:
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.a.l, 24);
    bfup.a(this.a.a, localAllInOne);
    switch (this.a.b)
    {
    }
    for (;;)
    {
      break;
      localAllInOne.l = 3;
      break;
      localAllInOne.l = 1;
      break;
      localAllInOne.l = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnq
 * JD-Core Version:    0.7.0.1
 */