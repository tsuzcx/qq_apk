import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class adye
  implements bchy
{
  public adye(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onAction(View paramView)
  {
    int i = 1;
    bcff localbcff = (bcff)paramView.getTag(2131381183);
    if (localbcff == null) {}
    for (;;)
    {
      return;
      String str1 = localbcff.b();
      String str2 = localbcff.a().toString();
      paramView = "-1";
      if ((localbcff instanceof bcdt))
      {
        paramView = ((bcdt)localbcff).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localbcff instanceof bcdz)) {
          paramView = ((bcdz)localbcff).a;
        } else if ((localbcff instanceof bcee)) {
          paramView = ((bcee)localbcff).a().troopuin;
        } else if ((localbcff instanceof bcdu)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adye
 * JD-Core Version:    0.7.0.1
 */