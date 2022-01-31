import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView.ARMapLoadingLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class abpx
  extends BroadcastReceiver
{
  public abpx(ARMapSplashView paramARMapSplashView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("onReceive action=%s", new Object[] { paramContext }));
    }
    if (("com.tencent.mobileqq.armap.ACTION_START_ARMAP_LOADING_COMPLETED".equals(paramContext)) && (ARMapSplashView.a(this.a) != null))
    {
      ARMapSplashView.a(this.a).b();
      ARMapSplashView.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpx
 * JD-Core Version:    0.7.0.1
 */