import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class adgi
  implements DialogInterface.OnClickListener
{
  public adgi(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    localBundle.putBoolean("is_from_account_another_login_exit", true);
    if (!awdr.a().a(this.a.app, this.a.app.getCurrentAccountUin()))
    {
      this.a.app.updateSubAccountLogin(this.a.app.getCurrentAccountUin(), false);
      this.a.app.getApplication().refreAccountList();
    }
    paramDialogInterface = (azyu)this.a.app.getManager(61);
    if (paramDialogInterface != null) {}
    for (paramDialogInterface = paramDialogInterface.a();; paramDialogInterface = null)
    {
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          String str = (String)paramDialogInterface.next();
          if (!awdr.a().a(this.a.app, str))
          {
            this.a.app.updateSubAccountLogin(str, false);
            this.a.app.getApplication().refreAccountList();
          }
        }
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras(localBundle).addFlags(67108864));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adgi
 * JD-Core Version:    0.7.0.1
 */