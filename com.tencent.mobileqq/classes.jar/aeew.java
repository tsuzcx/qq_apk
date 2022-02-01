import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class aeew
  implements bbpl
{
  public aeew(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(View paramView)
  {
    int i = 1;
    bbmu localbbmu = (bbmu)paramView.getTag(2131380929);
    if (localbbmu == null) {}
    for (;;)
    {
      return;
      String str1 = localbbmu.b();
      String str2 = localbbmu.a().toString();
      paramView = "-1";
      if ((localbbmu instanceof bbli))
      {
        paramView = ((bbli)localbbmu).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localbbmu instanceof bblo)) {
          paramView = ((bblo)localbbmu).a;
        } else if ((localbbmu instanceof bblt)) {
          paramView = ((bblt)localbbmu).a().troopuin;
        } else if ((localbbmu instanceof bblj)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeew
 * JD-Core Version:    0.7.0.1
 */