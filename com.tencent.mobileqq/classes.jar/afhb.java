import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afhb
  implements View.OnClickListener
{
  public afhb(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne;
    if (((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(TroopRequestActivity.a(this.a))) {
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 1);
    }
    for (;;)
    {
      bdla.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, localAllInOne);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 24);
      TroopUtils.prepareTroopNotifyData(this.a.a, localAllInOne);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhb
 * JD-Core Version:    0.7.0.1
 */