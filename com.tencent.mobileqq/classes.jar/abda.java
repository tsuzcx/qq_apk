import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class abda
  implements awqw
{
  public abda(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(View paramView)
  {
    int i = 1;
    awoe localawoe = (awoe)paramView.getTag(2131379213);
    if (localawoe == null) {}
    for (;;)
    {
      return;
      String str1 = localawoe.b();
      String str2 = localawoe.a().toString();
      paramView = "-1";
      if ((localawoe instanceof awms))
      {
        paramView = ((awms)localawoe).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.a.a.notifyDataSetChanged();
        return;
        if ((localawoe instanceof awmy)) {
          paramView = ((awmy)localawoe).a;
        } else if ((localawoe instanceof awnd)) {
          paramView = ((awnd)localawoe).a().troopuin;
        } else if ((localawoe instanceof awmt)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abda
 * JD-Core Version:    0.7.0.1
 */