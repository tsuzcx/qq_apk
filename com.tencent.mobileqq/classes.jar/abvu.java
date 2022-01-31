import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class abvu
  implements View.OnClickListener
{
  public abvu(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377153: 
      do
      {
        return;
        localObject = null;
        if ((paramView.getTag() instanceof String)) {
          localObject = String.valueOf(paramView.getTag());
        }
        if ("0X8004001".equals(localObject))
        {
          azmj.b(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
          paramView = new Intent(this.a, SubAccountUgActivity.class);
          paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          this.a.startActivity(paramView);
          return;
        }
      } while (!"0X8004456".equals(localObject));
      azmj.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, SubAccountBindActivity.class);
      paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      this.a.startActivity(paramView);
      bdbx.a().a(this.a.app.getCurrentAccountUin(), true);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramView.getContext(), AssociatedAccountActivity.class);
    ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    paramView.getContext().startActivity((Intent)localObject);
    azmj.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
    azmj.b(this.a.app, "dc00898", "", "", "0X800AC39", "0X800AC39", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvu
 * JD-Core Version:    0.7.0.1
 */