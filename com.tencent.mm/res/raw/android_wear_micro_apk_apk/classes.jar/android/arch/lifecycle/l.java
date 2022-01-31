package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class l
  extends Fragment
{
  private m M;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new l(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void c(c paramc)
  {
    Object localObject = getActivity();
    if ((localObject instanceof h)) {
      ((h)localObject).g().a(paramc);
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof e));
      localObject = ((e)localObject).d();
    } while (!(localObject instanceof f));
    ((f)localObject).a(paramc);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c(c.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    c(c.ON_DESTROY);
    this.M = null;
  }
  
  public final void onPause()
  {
    super.onPause();
    c(c.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    c(c.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    c(c.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    c(c.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.l
 * JD-Core Version:    0.7.0.1
 */