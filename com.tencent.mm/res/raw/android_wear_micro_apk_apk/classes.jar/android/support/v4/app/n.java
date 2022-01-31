package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.PrintWriter;

final class n
  extends r<FragmentActivity>
{
  public n(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  public final boolean S()
  {
    return !this.cf.isFinishing();
  }
  
  public final void T()
  {
    this.cf.invalidateOptionsMenu();
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramBundle = this.cf;
    paramBundle.at = true;
    if (paramInt == -1) {}
    try
    {
      a.a(paramBundle, paramIntent, -1, null);
      return;
    }
    finally
    {
      paramBundle.at = false;
    }
    FragmentActivity.d(paramInt);
    if (paramBundle.ce.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    while (paramBundle.ce.indexOfKey(paramBundle.cd) >= 0) {
      paramBundle.cd = ((paramBundle.cd + 1) % 65534);
    }
    int i = paramBundle.cd;
    paramBundle.ce.put(i, paramFragment.aM);
    paramBundle.cd = ((paramBundle.cd + 1) % 65534);
    a.a(paramBundle, paramIntent, (i + 1 << 16) + (0xFFFF & paramInt), null);
    paramBundle.at = false;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.cf.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }
  
  public final View onFindViewById(int paramInt)
  {
    return this.cf.findViewById(paramInt);
  }
  
  public final LayoutInflater onGetLayoutInflater()
  {
    return this.cf.getLayoutInflater().cloneInContext(this.cf);
  }
  
  public final int onGetWindowAnimations()
  {
    Window localWindow = this.cf.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return localWindow.getAttributes().windowAnimations;
  }
  
  public final boolean onHasView()
  {
    Window localWindow = this.cf.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public final boolean onHasWindowAnimations()
  {
    return this.cf.getWindow() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.n
 * JD-Core Version:    0.7.0.1
 */