import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afwv
  implements View.OnClickListener
{
  public afwv(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ProfileActivity.AllInOne localAllInOne;
    if (((anyw)this.a.app.getManager(51)).b(TroopRequestActivity.a(this.a))) {
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 1);
    }
    for (;;)
    {
      bdll.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, localAllInOne);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localAllInOne = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 24);
      bguq.a(this.a.a, localAllInOne);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwv
 * JD-Core Version:    0.7.0.1
 */