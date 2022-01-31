import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class abde
  implements awqu
{
  public abde(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(View paramView)
  {
    int i = 1;
    awoc localawoc = (awoc)paramView.getTag(2131379208);
    if (localawoc == null) {}
    for (;;)
    {
      return;
      String str1 = localawoc.b();
      String str2 = localawoc.a().toString();
      paramView = "-1";
      if ((localawoc instanceof awmq))
      {
        paramView = ((awmq)localawoc).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.a.a.notifyDataSetChanged();
        return;
        if ((localawoc instanceof awmw)) {
          paramView = ((awmw)localawoc).a;
        } else if ((localawoc instanceof awnb)) {
          paramView = ((awnb)localawoc).a().troopuin;
        } else if ((localawoc instanceof awmr)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abde
 * JD-Core Version:    0.7.0.1
 */