package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.g;
import android.arch.lifecycle.j;
import android.arch.lifecycle.x;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.b.s;
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
  extends h
  implements b, d
{
  private x cM;
  boolean cU;
  final Handler dG = new Handler()
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
        } while (!FragmentActivity.this.dL);
        FragmentActivity.this.g(false);
        return;
      }
      FragmentActivity.this.dH.dispatchResume();
      FragmentActivity.this.dH.execPendingActions();
    }
  };
  final r dH = r.a(new o(this));
  al dI;
  boolean dJ;
  boolean dK;
  boolean dL = true;
  boolean dM = true;
  boolean dN;
  int dO;
  s<String> dP;
  
  private static boolean a(t paramt, g paramg)
  {
    paramt = paramt.getFragments().iterator();
    boolean bool = false;
    while (paramt.hasNext())
    {
      Object localObject = (Fragment)paramt.next();
      if (localObject != null)
      {
        if (((Fragment)localObject).h().g().a(g.K))
        {
          ((Fragment)localObject).dk.b(paramg);
          bool = true;
        }
        localObject = ((Fragment)localObject).cK;
        if (localObject == null) {
          break label83;
        }
        bool = a((t)localObject, paramg) | bool;
      }
    }
    label83:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private void ai()
  {
    while (a(this.dH.ah(), g.J)) {}
  }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.dH.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final t ah()
  {
    return this.dH.ah();
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
    paramPrintWriter.print(this.dJ);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.dK);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.dL);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.dM);
    if (this.dI != null) {
      this.dI.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.dH.ah().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  final void g(boolean paramBoolean)
  {
    if (!this.dM)
    {
      this.dM = true;
      this.cU = paramBoolean;
      this.dG.removeMessages(1);
      this.dH.an();
    }
  }
  
  public final e h()
  {
    return super.h();
  }
  
  public final void j(int paramInt)
  {
    if (!this.dN) {
      m(0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.dH.noteStateNotSaved();
    int i = paramInt1 >> 16;
    Object localObject;
    if (i != 0)
    {
      i -= 1;
      localObject = (String)this.dP.get(i);
      this.dP.remove(i);
      if (localObject == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
      }
    }
    do
    {
      return;
      Fragment localFragment = this.dH.a((String)localObject);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for who: ".concat(String.valueOf(localObject)));
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
      localObject = a.z();
    } while ((localObject != null) && (((c)localObject).B()));
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    t localt = this.dH.ah();
    boolean bool = localt.isStateSaved();
    if ((bool) && (Build.VERSION.SDK_INT <= 25)) {}
    while ((!bool) && (localt.popBackStackImmediate())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.dH.noteStateNotSaved();
    this.dH.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.dH.al();
    super.onCreate(paramBundle);
    Object localObject = (p)getLastNonConfigurationInstance();
    if (localObject != null) {
      this.cM = ((p)localObject).dS;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      r localr = this.dH;
      if (localObject == null) {
        break label160;
      }
      localObject = ((p)localObject).dT;
      localr.a(localParcelable, (ae)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.dO = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject != null) && (paramBundle != null) && (localObject.length == paramBundle.length)) {
          break label165;
        }
        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
      }
    }
    for (;;)
    {
      if (this.dP == null)
      {
        this.dP = new s();
        this.dO = 0;
      }
      this.dH.dispatchCreate();
      return;
      label160:
      localObject = null;
      break;
      label165:
      this.dP = new s(localObject.length);
      int i = 0;
      while (i < localObject.length)
      {
        this.dP.put(localObject[i], paramBundle[i]);
        i += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0) {
      return super.onCreatePanelMenu(paramInt, paramMenu) | this.dH.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g(false);
    if ((this.cM != null) && (!this.cU)) {
      this.cM.clear();
    }
    this.dH.dispatchDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.dH.dispatchLowMemory();
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
      return this.dH.dispatchOptionsItemSelected(paramMenuItem);
    }
    return this.dH.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.dH.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.dH.noteStateNotSaved();
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
      this.dH.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.dK = false;
    if (this.dG.hasMessages(2))
    {
      this.dG.removeMessages(2);
      this.dH.dispatchResume();
    }
    this.dH.dispatchPause();
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.dH.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.dG.removeMessages(2);
    this.dH.dispatchResume();
    this.dH.execPendingActions();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return super.onPreparePanel(0, paramView, paramMenu) | this.dH.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.dH.noteStateNotSaved();
    paramInt = paramInt >> 16 & 0xFFFF;
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = (String)this.dP.get(paramInt);
      this.dP.remove(paramInt);
      if (paramArrayOfString != null) {
        break label56;
      }
      Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
    }
    label56:
    while (this.dH.a(paramArrayOfString) != null) {
      return;
    }
    Log.w("FragmentActivity", "Activity result no fragment exists for who: ".concat(String.valueOf(paramArrayOfString)));
  }
  
  protected void onResume()
  {
    super.onResume();
    this.dG.sendEmptyMessage(2);
    this.dK = true;
    this.dH.execPendingActions();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.dL) {
      g(true);
    }
    ae localae = this.dH.am();
    if ((localae == null) && (this.cM == null)) {
      return null;
    }
    p localp = new p();
    localp.dR = null;
    localp.dS = this.cM;
    localp.dT = localae;
    return localp;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    ai();
    Object localObject = this.dH.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.dP.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.dO);
      localObject = new int[this.dP.size()];
      String[] arrayOfString = new String[this.dP.size()];
      int i = 0;
      while (i < this.dP.size())
      {
        localObject[i] = this.dP.keyAt(i);
        arrayOfString[i] = ((String)this.dP.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.dL = false;
    this.dM = false;
    this.dG.removeMessages(1);
    if (!this.dJ)
    {
      this.dJ = true;
      this.dH.dispatchActivityCreated();
    }
    this.dH.noteStateNotSaved();
    this.dH.execPendingActions();
    this.dH.dispatchStart();
  }
  
  public void onStateNotSaved()
  {
    this.dH.noteStateNotSaved();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.dL = true;
    ai();
    this.dG.sendEmptyMessage(1);
    this.dH.dispatchStop();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.cc) && (paramInt != -1)) {
      m(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */