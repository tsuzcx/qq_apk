import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adjf
  implements View.OnClickListener
{
  public adjf(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    bdla.b(this.a.app, "CliOper", "", "", "0X8007144", "0X8007144", 0, 0, "", "", "", "");
    bdxs localbdxs = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if ((localbdxs != null) && (localbdxs.a() >= 2)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "click top right manage btn underTwo = " + bool);
      }
      AssociatedAccountActivity.a(this.a, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjf
 * JD-Core Version:    0.7.0.1
 */