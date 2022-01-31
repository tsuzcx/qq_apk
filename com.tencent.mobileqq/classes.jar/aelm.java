import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public class aelm
  implements Runnable
{
  public aelm(NearbyAppInterface paramNearbyAppInterface) {}
  
  public void run()
  {
    if (!this.a.a.verifyAuthentication())
    {
      QLog.e("NearbyAppInterface", 1, "verify fail!");
      if (this.a.isLogin()) {
        this.a.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", "登录失败");
      localIntent.putExtra("msg", "登录失败");
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.sApplication.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aelm
 * JD-Core Version:    0.7.0.1
 */