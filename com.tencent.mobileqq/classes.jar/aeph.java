import android.view.View;
import com.tencent.mobileqq.activity.ForwardTroopListFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;

public class aeph
  implements bcie
{
  public aeph(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void a(View paramView)
  {
    int i = 1;
    bcfn localbcfn = (bcfn)paramView.getTag(2131381109);
    if (localbcfn == null) {}
    for (;;)
    {
      return;
      String str1 = localbcfn.b();
      String str2 = localbcfn.a().toString();
      paramView = "-1";
      if ((localbcfn instanceof bceb))
      {
        paramView = ((bceb)localbcfn).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardTroopListFragment.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        this.a.a.notifyDataSetChanged();
        return;
        if ((localbcfn instanceof bceh)) {
          paramView = ((bceh)localbcfn).a;
        } else if ((localbcfn instanceof bcem)) {
          paramView = ((bcem)localbcfn).a().troopuin;
        } else if ((localbcfn instanceof bcec)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeph
 * JD-Core Version:    0.7.0.1
 */