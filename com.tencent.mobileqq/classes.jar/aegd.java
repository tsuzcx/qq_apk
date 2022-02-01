import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class aegd
  implements bbpl
{
  public aegd(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
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
      while ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.a.a.notifyDataSetChanged();
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
 * Qualified Name:     aegd
 * JD-Core Version:    0.7.0.1
 */