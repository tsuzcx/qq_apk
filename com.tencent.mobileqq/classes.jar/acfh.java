import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acfh
  implements View.OnClickListener
{
  public acfh(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    azqs.b(this.a.app, "CliOper", "", "", "0X8007144", "0X8007144", 0, 0, "", "", "", "");
    paramView = (badd)this.a.app.getManager(61);
    if ((paramView != null) && (paramView.a() >= 2)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "click top right manage btn underTwo = " + bool);
      }
      AssociatedAccountActivity.a(this.a, bool);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfh
 * JD-Core Version:    0.7.0.1
 */