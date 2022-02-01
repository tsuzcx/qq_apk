import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class abom
  implements Application.ActivityLifecycleCallbacks
{
  abom(aboh paramaboh) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == aboh.a(this.a)) {
      aboh.a(this.a).l();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == aboh.a(this.a)) {
      aboh.a(this.a).j();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == aboh.a(this.a)) {
      aboh.a(this.a).k();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abom
 * JD-Core Version:    0.7.0.1
 */