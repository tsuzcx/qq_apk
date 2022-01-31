import com.tencent.mobileqq.activity.weather.WeatherServlet.PermissionCallback.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public final class akgy
  implements QQPermissionCallback
{
  private WeakReference<QQAppInterface> a;
  private WeakReference<NewIntent> b;
  private WeakReference<AppActivity> c;
  
  private akgy(QQAppInterface paramQQAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramNewIntent);
    this.c = new WeakReference(paramAppActivity);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 1, "User requestPermissions denied...");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    NewIntent localNewIntent = (NewIntent)this.b.get();
    AppActivity localAppActivity = (AppActivity)this.c.get();
    if ((localQQAppInterface != null) && (localNewIntent != null) && (localAppActivity != null))
    {
      ThreadManager.getSubThreadHandler().post(new WeatherServlet.PermissionCallback.1(this, localNewIntent, localQQAppInterface));
      bdgm.a(localAppActivity, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 1, "User requestPermissions grant...");
    }
    paramArrayOfString = (QQAppInterface)this.a.get();
    paramArrayOfInt = (NewIntent)this.b.get();
    if ((paramArrayOfString != null) && (paramArrayOfInt != null)) {
      akgw.a(paramArrayOfString, paramArrayOfInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgy
 * JD-Core Version:    0.7.0.1
 */