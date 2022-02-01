import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;

public class aeka
  implements View.OnClickListener
{
  public aeka(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = bhdj.a(this.a, this.a.getResources().getDrawable(2130849611), 2131692024);
    localProgressDialog.setOnDismissListener(new aekb(this));
    awoi.a(this.a.app.getAccount());
    this.a.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "log_upload");
    Object localObject2 = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject2 != null)
    {
      localObject1 = (TicketManager)((AppRuntime)localObject2).getManager(2);
      localObject2 = ((AppRuntime)localObject2).getAccount();
      if (localObject1 == null) {
        break label176;
      }
    }
    label176:
    for (Object localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationActivity", 2, new Object[] { " NotificationActivity crash uin=", localObject2, ",skey=", localObject1 });
      }
      awoi.a(this.a.app.getHttpCommunicatort(), this.a.app.getApp(), localProgressDialog, (String)localObject2, (String)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeka
 * JD-Core Version:    0.7.0.1
 */