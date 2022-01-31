import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class advc
  implements View.OnClickListener
{
  public advc(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onAddAccountClick.onClick:add account");
    }
    paramView = (azyu)this.a.app.getManager(61);
    if (paramView != null) {}
    for (int i = paramView.a();; i = 0)
    {
      if (i < 2)
      {
        paramView = new Intent(this.a, SubLoginActivity.class);
        paramView.putExtra("fromWhere", this.a.b);
        this.a.startActivity(paramView);
        return;
      }
      azyl.a(this.a.app, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advc
 * JD-Core Version:    0.7.0.1
 */