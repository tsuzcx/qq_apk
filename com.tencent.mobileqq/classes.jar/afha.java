import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afha
  implements View.OnClickListener
{
  public afha(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.c > 0L) && (l - TroopRequestActivity.c < 800L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopRequestActivity.c = l;
    if (((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.m)) {
      localAllInOne = new ProfileActivity.AllInOne(this.a.m, 1);
    }
    for (;;)
    {
      bdla.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, localAllInOne);
      break;
      if ((this.a.a.msg.group_msg_type.get() != 2) || (this.a.a.msg.sub_type.get() != 3)) {
        break label225;
      }
      localAllInOne = new ProfileActivity.AllInOne(this.a.m, 26);
      localAllInOne.d = 1;
    }
    label225:
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.a.m, 24);
    TroopUtils.prepareTroopNotifyData(this.a.a, localAllInOne);
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
 * Qualified Name:     afha
 * JD-Core Version:    0.7.0.1
 */