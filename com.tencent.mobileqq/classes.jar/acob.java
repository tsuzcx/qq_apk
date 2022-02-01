import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class acob
  implements Application.ActivityLifecycleCallbacks
{
  acob(acnw paramacnw) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == acnw.a(this.a)) {
      acnw.a(this.a).l();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == acnw.a(this.a)) {
      acnw.a(this.a).j();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == acnw.a(this.a)) {
      acnw.a(this.a).k();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acob
 * JD-Core Version:    0.7.0.1
 */