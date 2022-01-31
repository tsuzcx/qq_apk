import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;

public class adkl
  implements View.OnClickListener
{
  public adkl(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = bdgm.a(this.a, this.a.getResources().getDrawable(2130849056), 2131692270);
    localProgressDialog.setOnDismissListener(new adkm(this));
    atvd.a(this.a.app.getAccount());
    this.a.app.a(ServerConfigManager.ConfigType.app, "log_upload");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null)
    {
      paramView = (TicketManager)((AppRuntime)localObject).getManager(2);
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramView == null) {
        break label161;
      }
    }
    label161:
    for (paramView = paramView.getSkey((String)localObject);; paramView = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationActivity", 2, new Object[] { " NotificationActivity crash uin=", localObject, ",skey=", paramView });
      }
      atvd.a(this.a.app.getHttpCommunicatort(), this.a.app.getApp(), localProgressDialog, (String)localObject, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adkl
 * JD-Core Version:    0.7.0.1
 */