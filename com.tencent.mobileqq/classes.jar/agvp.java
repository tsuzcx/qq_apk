import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager;
import com.tencent.qphone.base.util.QLog;

public class agvp
  extends BroadcastReceiver
{
  public agvp(SpringHbReportManager paramSpringHbReportManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {}
    while ((!"com.tencent.plugin.state.change".equals(paramContext)) || (paramIntent.getIntExtra("key_plugin_state", 0) != 0)) {
      return;
    }
    QLog.i("springHb_report_SpringHbReportManager", 1, "[onReceive] bg action");
    this.a.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agvp
 * JD-Core Version:    0.7.0.1
 */