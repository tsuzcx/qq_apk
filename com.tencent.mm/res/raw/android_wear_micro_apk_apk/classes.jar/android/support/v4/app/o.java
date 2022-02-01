package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.PrintWriter;

final class o
  extends s<FragmentActivity>
{
  public o(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramBundle = this.dQ;
    paramBundle.cc = true;
    if (paramInt == -1) {}
    try
    {
      a.a(paramBundle, paramIntent, -1, null);
      return;
    }
    finally
    {
      paramBundle.cc = false;
    }
    FragmentActivity.m(paramInt);
    if (paramBundle.dP.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    while (paramBundle.dP.indexOfKey(paramBundle.dO) >= 0) {
      paramBundle.dO = ((paramBundle.dO + 1) % 65534);
    }
    int i = paramBundle.dO;
    paramBundle.dP.put(i, paramFragment.cw);
    paramBundle.dO = ((paramBundle.dO + 1) % 65534);
    a.a(paramBundle, paramIntent, (i + 1 << 16) + (0xFFFF & paramInt), null);
    paramBundle.cc = false;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.dQ.dump(paramString, null, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean aj()
  {
    return !this.dQ.isFinishing();
  }
  
  public final void ak()
  {
    this.dQ.invalidateOptionsMenu();
  }
  
  public final View onFindViewById(int paramInt)
  {
    return this.dQ.findViewById(paramInt);
  }
  
  public final LayoutInflater onGetLayoutInflater()
  {
    return this.dQ.getLayoutInflater().cloneInContext(this.dQ);
  }
  
  public final int onGetWindowAnimations()
  {
    Window localWindow = this.dQ.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return localWindow.getAttributes().windowAnimations;
  }
  
  public final boolean onHasView()
  {
    Window localWindow = this.dQ.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public final boolean onHasWindowAnimations()
  {
    return this.dQ.getWindow() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.o
 * JD-Core Version:    0.7.0.1
 */