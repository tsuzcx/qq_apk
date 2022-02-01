import android.view.View;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class adgy
  implements bbbg
{
  public adgy(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onAction(View paramView)
  {
    int i = 1;
    bayp localbayp = (bayp)paramView.getTag(2131380831);
    if (localbayp == null) {}
    for (;;)
    {
      return;
      String str1 = localbayp.b();
      String str2 = localbayp.a().toString();
      paramView = "-1";
      if ((localbayp instanceof baxd))
      {
        paramView = ((baxd)localbayp).e();
        i = 3000;
      }
      while ((i != -1) && (ForwardFriendListActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, ""))))
      {
        ForwardFriendListActivity.a(this.a).notifyDataSetChanged();
        return;
        if ((localbayp instanceof baxj)) {
          paramView = ((baxj)localbayp).a;
        } else if ((localbayp instanceof baxo)) {
          paramView = ((baxo)localbayp).a().troopuin;
        } else if ((localbayp instanceof baxe)) {
          i = 0;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgy
 * JD-Core Version:    0.7.0.1
 */