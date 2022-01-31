package android.support.v4.app;

import android.arch.lifecycle.d;
import android.arch.lifecycle.f;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.b.r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class FragmentActivity
  extends g
  implements b, c
{
  final q bX = q.a(new n(this));
  boolean bY;
  boolean bZ;
  boolean bj;
  boolean ca = true;
  boolean cb = true;
  boolean cc;
  int cd;
  r<String> ce;
  final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!FragmentActivity.this.ca);
        FragmentActivity.this.d(false);
        return;
      }
      FragmentActivity.this.bX.dispatchResume();
      FragmentActivity.this.bX.execPendingActions();
    }
  };
  
  private static void a(s params, d paramd)
  {
    params = params.getFragments().iterator();
    while (params.hasNext())
    {
      Fragment localFragment = (Fragment)params.next();
      if (localFragment != null)
      {
        localFragment.bB.a(paramd);
        a(localFragment.p(), paramd);
      }
    }
  }
  
  public final s R()
  {
    return this.bX.R();
  }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.bX.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final void a(int paramInt)
  {
    if (!this.cc) {
      d(0);
    }
  }
  
  public final android.arch.lifecycle.b d()
  {
    return super.d();
  }
  
  final void d(boolean paramBoolean)
  {
    if (!this.cb)
    {
      this.cb = true;
      this.bj = paramBoolean;
      this.mHandler.removeMessages(1);
      this.bX.doLoaderStop(this.bj);
      this.bX.W();
    }
    while (!paramBoolean) {
      return;
    }
    this.bX.doLoaderStart();
    this.bX.doLoaderStop(true);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.bY);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.bZ);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.ca);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.cb);
    this.bX.dumpLoaders(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    this.bX.R().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.bX.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i -= 1;
      String str = (String)this.ce.get(i);
      this.ce.remove(i);
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = this.bX.a(str);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    s locals = this.bX.R();
    boolean bool = locals.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {}
    while ((!bool) && (locals.popBackStackImmediate())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.bX.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.bX.U();
    super.onCreate(paramBundle);
    Object localObject = (o)getLastNonConfigurationInstance();
    if (localObject != null) {
      this.bX.a(((o)localObject).ci);
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      q localq = this.bX;
      if (localObject == null) {
        break label163;
      }
      localObject = ((o)localObject).ch;
      localq.a(localParcelable, (ac)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.cd = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject != null) && (paramBundle != null) && (localObject.length == paramBundle.length)) {
          break label168;
        }
        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
      }
    }
    for (;;)
    {
      if (this.ce == null)
      {
        this.ce = new r();
        this.cd = 0;
      }
      this.bX.dispatchCreate();
      return;
      label163:
      localObject = null;
      break;
      label168:
      this.ce = new r(localObject.length);
      int i = 0;
      while (i < localObject.length)
      {
        this.ce.put(localObject[i], paramBundle[i]);
        i += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      return super.onCreatePanelMenu(paramInt, paramMenu) | this.bX.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d(false);
    this.bX.dispatchDestroy();
    this.bX.doLoaderDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.bX.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.bX.dispatchOptionsItemSelected(paramMenuItem);
    }
    return this.bX.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.bX.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.bX.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.bX.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.bZ = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      this.bX.dispatchResume();
    }
    this.bX.dispatchPause();
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.bX.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    this.bX.dispatchResume();
    this.bX.execPendingActions();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return super.onPreparePanel(0, paramView, paramMenu) | this.bX.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramInt = paramInt >> 16 & 0xFFFF;
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = (String)this.ce.get(paramInt);
      this.ce.remove(paramInt);
      if (paramArrayOfString == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
      }
    }
    else
    {
      return;
    }
    if (this.bX.a(paramArrayOfString) == null)
    {
      Log.w("FragmentActivity", "Activity result no fragment exists for who: " + paramArrayOfString);
      return;
    }
    Fragment.r();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.bZ = true;
    this.bX.execPendingActions();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.ca) {
      d(true);
    }
    ac localac = this.bX.V();
    android.support.v4.b.q localq = this.bX.X();
    if ((localac == null) && (localq == null)) {
      return null;
    }
    o localo = new o();
    localo.cg = null;
    localo.ch = localac;
    localo.ci = localq;
    return localo;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    a(this.bX.R(), d.p);
    Object localObject = this.bX.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.ce.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.cd);
      localObject = new int[this.ce.size()];
      String[] arrayOfString = new String[this.ce.size()];
      int i = 0;
      while (i < this.ce.size())
      {
        localObject[i] = this.ce.keyAt(i);
        arrayOfString[i] = ((String)this.ce.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.ca = false;
    this.cb = false;
    this.mHandler.removeMessages(1);
    if (!this.bY)
    {
      this.bY = true;
      this.bX.dispatchActivityCreated();
    }
    this.bX.noteStateNotSaved();
    this.bX.execPendingActions();
    this.bX.doLoaderStart();
    this.bX.dispatchStart();
    this.bX.reportLoaderStart();
  }
  
  public void onStateNotSaved()
  {
    this.bX.noteStateNotSaved();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.ca = true;
    a(this.bX.R(), d.p);
    this.mHandler.sendEmptyMessage(1);
    this.bX.dispatchStop();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.at) && (paramInt != -1)) {
      d(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */