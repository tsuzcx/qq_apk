package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class s<E>
  extends q
{
  final u cI = new u();
  private final Handler dG;
  private final Activity dU;
  final int dV;
  final Context mContext;
  
  private s(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.dU = paramActivity;
    this.mContext = paramContext;
    this.dG = paramHandler;
    this.dV = 0;
  }
  
  s(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.dG);
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    this.mContext.startActivity(paramIntent);
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean aj()
  {
    return true;
  }
  
  public void ak() {}
  
  final Activity getActivity()
  {
    return this.dU;
  }
  
  final Handler getHandler()
  {
    return this.dG;
  }
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    return LayoutInflater.from(this.mContext);
  }
  
  public int onGetWindowAnimations()
  {
    return this.dV;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.s
 * JD-Core Version:    0.7.0.1
 */