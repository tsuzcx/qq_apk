import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;

public class akkb
  extends BroadcastReceiver
{
  public akkb(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (this.a.getAppInterface() != null)) {
      QLog.d("AgentActivity", 2, "-->onReceive, intent.getAction(): " + paramIntent.getAction());
    }
    if (("action_login_sucess".equals(paramIntent.getAction())) && (AgentActivity.a(this.a) != null))
    {
      paramContext = paramIntent.getStringExtra("login_success_uin");
      if (!TextUtils.isEmpty(paramContext)) {
        AgentActivity.a(this.a).putExtra("login_success_uin", paramContext);
      }
      this.a.startActivityForResult(AgentActivity.a(this.a), 0);
    }
    this.a.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkb
 * JD-Core Version:    0.7.0.1
 */