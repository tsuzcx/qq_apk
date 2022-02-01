package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class s
  extends Fragment
{
  private t an;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new s(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void c(f paramf)
  {
    Object localObject = getActivity();
    if ((localObject instanceof l)) {
      ((l)localObject).k().a(paramf);
    }
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof i));
      localObject = ((i)localObject).h();
    } while (!(localObject instanceof j));
    ((j)localObject).a(paramf);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c(f.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    c(f.ON_DESTROY);
    this.an = null;
  }
  
  public final void onPause()
  {
    super.onPause();
    c(f.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    c(f.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    c(f.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    c(f.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.s
 * JD-Core Version:    0.7.0.1
 */