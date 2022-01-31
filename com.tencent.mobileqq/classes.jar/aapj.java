import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class aapj
  implements Application.ActivityLifecycleCallbacks
{
  aapj(aape paramaape) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == aape.a(this.a)) {
      aape.a(this.a).g();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == aape.a(this.a)) {
      aape.a(this.a).e();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity == aape.a(this.a)) {
      aape.a(this.a).f();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapj
 * JD-Core Version:    0.7.0.1
 */