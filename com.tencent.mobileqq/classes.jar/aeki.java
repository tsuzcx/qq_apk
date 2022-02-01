import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class aeki
  implements DialogInterface.OnClickListener
{
  public aeki(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.app.logout(true);
    bhhr.a(this.a.app.getApp(), this.a.app.getCurrentAccountUin(), false);
    paramDialogInterface = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.a();; paramDialogInterface = null)
    {
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          String str = (String)paramDialogInterface.next();
          if (!azit.a().a(this.a.app, str))
          {
            this.a.app.updateSubAccountLogin(str, false);
            this.a.app.getApplication().refreAccountList();
          }
        }
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).addFlags(67108864));
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeki
 * JD-Core Version:    0.7.0.1
 */