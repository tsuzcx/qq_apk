import android.view.View;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class aeoj
  implements bcie
{
  public aeoj(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void a(View paramView)
  {
    int i = 3000;
    paramView = (bcfn)paramView.getTag(2131381109);
    if (paramView == null) {
      return;
    }
    String str1 = paramView.b();
    String str2 = paramView.a().toString();
    if ((paramView instanceof bceb)) {
      paramView = ((bceb)paramView).e();
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
      if ((paramView instanceof bcdz))
      {
        paramView = ((bcdz)paramView).b();
      }
      else if ((paramView instanceof bceh))
      {
        paramView = ((bceh)paramView).a;
        i = 1;
      }
      else if ((paramView instanceof bcem))
      {
        paramView = ((bcem)paramView).a().troopuin;
        i = 1;
      }
      else if ((paramView instanceof bcec))
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
 * Qualified Name:     aeoj
 * JD-Core Version:    0.7.0.1
 */