import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aehk
  implements View.OnClickListener
{
  public aehk(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (((alto)this.a.app.getManager(51)).b(TroopRequestActivity.a(this.a))) {
      paramView = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 1);
    }
    for (;;)
    {
      azqs.b(this.a.app, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, this.a.a.msg.group_code.get() + "", "3", "", "");
      ProfileActivity.b(this.a, paramView);
      return;
      paramView = new ProfileActivity.AllInOne(TroopRequestActivity.a(this.a), 24);
      bcpx.a(this.a.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehk
 * JD-Core Version:    0.7.0.1
 */