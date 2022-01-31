import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class aasf
  implements avrb
{
  public aasf(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void a(View paramView)
  {
    int i = 1;
    avoj localavoj = (avoj)paramView.getTag(2131313373);
    if (localavoj == null) {}
    for (;;)
    {
      return;
      String str1 = localavoj.b();
      String str2 = localavoj.a().toString();
      paramView = "-1";
      if ((localavoj instanceof avmx))
      {
        paramView = ((avmx)localavoj).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localavoj instanceof avnd)) {
          paramView = ((avnd)localavoj).a;
        } else if ((localavoj instanceof avni)) {
          paramView = ((avni)localavoj).a().troopuin;
        } else if ((localavoj instanceof avmy)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasf
 * JD-Core Version:    0.7.0.1
 */