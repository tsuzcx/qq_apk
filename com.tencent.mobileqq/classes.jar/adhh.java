import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class adhh
  implements bbbg
{
  public adhh(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onAction(View paramView)
  {
    int i = 3000;
    paramView = (bayp)paramView.getTag(2131380831);
    if (paramView == null) {
      return;
    }
    String str1 = paramView.b();
    String str2 = paramView.a().toString();
    if ((paramView instanceof baxd)) {
      paramView = ((baxd)paramView).e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onAction, uin = " + str1 + ", displayName = " + str2 + ", troopUin = " + paramView + ", type = " + i);
      }
      if ((i != -1) && (ForwardRecentActivity.a(this.a, new ResultRecord(str1, str2, i, paramView, "")))) {
        ForwardRecentActivity.a(this.a).notifyDataSetChanged();
      }
      ForwardRecentActivity.h(this.a);
      return;
      if ((paramView instanceof baxb))
      {
        paramView = ((baxb)paramView).b();
      }
      else if ((paramView instanceof baxj))
      {
        paramView = ((baxj)paramView).a;
        i = 1;
      }
      else if ((paramView instanceof baxo))
      {
        paramView = ((baxo)paramView).a().troopuin;
        i = 1;
      }
      else if ((paramView instanceof baxe))
      {
        i = 0;
        paramView = "-1";
      }
      else
      {
        i = -1;
        paramView = "-1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */