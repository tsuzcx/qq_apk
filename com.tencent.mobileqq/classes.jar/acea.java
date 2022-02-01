import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class acea
  implements Application.ActivityLifecycleCallbacks
{
  acea(acdv paramacdv) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == acdv.a(this.a)) {
      acdv.a(this.a).j();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == acdv.a(this.a)) {
      acdv.a(this.a).h();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == acdv.a(this.a)) {
      acdv.a(this.a).i();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acea
 * JD-Core Version:    0.7.0.1
 */