import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class acyo
  implements ayqi
{
  public acyo(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(View paramView)
  {
    int i = 1;
    aynq localaynq = (aynq)paramView.getTag(2131379971);
    if (localaynq == null) {}
    for (;;)
    {
      return;
      String str1 = localaynq.b();
      String str2 = localaynq.a().toString();
      paramView = "-1";
      if ((localaynq instanceof ayme))
      {
        paramView = ((ayme)localaynq).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.a.a.notifyDataSetChanged();
        return;
        if ((localaynq instanceof aymk)) {
          paramView = ((aymk)localaynq).a;
        } else if ((localaynq instanceof aymp)) {
          paramView = ((aymp)localaynq).a().troopuin;
        } else if ((localaynq instanceof aymf)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyo
 * JD-Core Version:    0.7.0.1
 */