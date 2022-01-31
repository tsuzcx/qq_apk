import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class acss
  implements aylz
{
  public acss(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(View paramView)
  {
    int i = 1;
    ayjh localayjh = (ayjh)paramView.getTag(2131379913);
    if (localayjh == null) {}
    for (;;)
    {
      return;
      String str1 = localayjh.b();
      String str2 = localayjh.a().toString();
      paramView = "-1";
      if ((localayjh instanceof ayhv))
      {
        paramView = ((ayhv)localayjh).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localayjh instanceof ayib)) {
          paramView = ((ayib)localayjh).a;
        } else if ((localayjh instanceof ayig)) {
          paramView = ((ayig)localayjh).a().troopuin;
        } else if ((localayjh instanceof ayhw)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acss
 * JD-Core Version:    0.7.0.1
 */