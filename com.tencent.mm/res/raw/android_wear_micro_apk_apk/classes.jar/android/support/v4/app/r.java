package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.b.q;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class r<E>
  extends p
{
  final t aY = new t();
  private ak bs;
  private boolean bt;
  private boolean bu;
  private final Activity cj;
  final int ck;
  private q<String, ai> cl;
  private boolean cm;
  final Context mContext;
  private final Handler mHandler;
  
  private r(Activity paramActivity, Context paramContext, Handler paramHandler)
  {
    this.cj = paramActivity;
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.ck = 0;
  }
  
  r(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, paramFragmentActivity.mHandler);
  }
  
  public boolean S()
  {
    return true;
  }
  
  public void T() {}
  
  final q<String, ai> X()
  {
    int k;
    if (this.cl != null)
    {
      int m = this.cl.size();
      ak[] arrayOfak = new ak[m];
      int i = m - 1;
      while (i >= 0)
      {
        arrayOfak[i] = ((ak)this.cl.valueAt(i));
        i -= 1;
      }
      boolean bool = this.cm;
      int j = 0;
      i = 0;
      k = i;
      if (j < m)
      {
        ak localak = arrayOfak[j];
        if ((!localak.bj) && (bool))
        {
          if (!localak.ej) {
            localak.as();
          }
          localak.au();
        }
        if (localak.bj) {
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          localak.ax();
          this.cl.remove(localak.aM);
        }
      }
    }
    else
    {
      k = 0;
    }
    if (k != 0) {
      return this.cl;
    }
    return null;
  }
  
  final boolean Y()
  {
    return this.cm;
  }
  
  final ak a(String paramString, boolean paramBoolean)
  {
    if (this.cl == null) {
      this.cl = new q();
    }
    paramString = (ak)this.cl.get(paramString);
    if ((paramBoolean) && (paramString != null) && (!paramString.ej)) {
      paramString.as();
    }
    return paramString;
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    this.mContext.startActivity(paramIntent);
  }
  
  final void a(q<String, ai> paramq)
  {
    if (paramq != null)
    {
      int j = paramq.size();
      int i = 0;
      while (i < j)
      {
        ((ak)paramq.valueAt(i)).aZ = this;
        i += 1;
      }
    }
    this.cl = paramq;
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  final void b(String paramString)
  {
    if (this.cl != null)
    {
      ak localak = (ak)this.cl.get(paramString);
      if ((localak != null) && (!localak.bj))
      {
        localak.ax();
        this.cl.remove(paramString);
      }
    }
  }
  
  final void doLoaderDestroy()
  {
    if (this.bs == null) {
      return;
    }
    this.bs.ax();
  }
  
  final void doLoaderStart()
  {
    if (this.bt) {
      return;
    }
    this.bt = true;
    if (this.bs != null) {
      this.bs.as();
    }
    for (;;)
    {
      this.bu = true;
      return;
      if (!this.bu)
      {
        this.bs = a("(root)", this.bt);
        if ((this.bs != null) && (!this.bs.ej)) {
          this.bs.as();
        }
      }
    }
  }
  
  final void doLoaderStop(boolean paramBoolean)
  {
    this.cm = paramBoolean;
    if (this.bs == null) {}
    while (!this.bt) {
      return;
    }
    this.bt = false;
    if (paramBoolean)
    {
      this.bs.au();
      return;
    }
    this.bs.at();
  }
  
  final void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.bt);
    if (this.bs != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.bs)));
      paramPrintWriter.println(":");
      this.bs.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  final Activity getActivity()
  {
    return this.cj;
  }
  
  final Handler getHandler()
  {
    return this.mHandler;
  }
  
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    return (LayoutInflater)this.mContext.getSystemService("layout_inflater");
  }
  
  public int onGetWindowAnimations()
  {
    return this.ck;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
  
  final void reportLoaderStart()
  {
    if (this.cl != null)
    {
      int k = this.cl.size();
      ak[] arrayOfak = new ak[k];
      int i = k - 1;
      while (i >= 0)
      {
        arrayOfak[i] = ((ak)this.cl.valueAt(i));
        i -= 1;
      }
      i = 0;
      while (i < k)
      {
        ak localak = arrayOfak[i];
        if (localak.bj)
        {
          if (ak.DEBUG) {
            Log.v("LoaderManager", "Finished Retaining in " + localak);
          }
          localak.bj = false;
          int j = localak.eh.size() - 1;
          while (j >= 0)
          {
            al localal = (al)localak.eh.valueAt(j);
            if (localal.bj)
            {
              if (ak.DEBUG) {
                Log.v("LoaderManager", "  Finished Retaining: " + localal);
              }
              localal.bj = false;
              if ((localal.ej != localal.eq) && (!localal.ej)) {
                localal.stop();
              }
            }
            if ((localal.ej) && (localal.en) && (!localal.er)) {
              localal.a(localal.em, localal.ep);
            }
            j -= 1;
          }
        }
        localak.aw();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.r
 * JD-Core Version:    0.7.0.1
 */