import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.qphone.base.util.QLog;

public class alnr
  extends BroadcastReceiver
{
  public alnr(LoginView paramLoginView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("LoginActivity.LoginView", 1, "AutoLoginReceiver onReceive");
    LoginView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnr
 * JD-Core Version:    0.7.0.1
 */