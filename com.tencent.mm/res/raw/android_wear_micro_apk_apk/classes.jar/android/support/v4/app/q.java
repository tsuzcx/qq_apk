package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class q
{
  private final r<?> aZ;
  
  private q(r<?> paramr)
  {
    this.aZ = paramr;
  }
  
  public static final q a(r<?> paramr)
  {
    return new q(paramr);
  }
  
  public final s R()
  {
    return this.aZ.aY;
  }
  
  public final void U()
  {
    this.aZ.aY.a(this.aZ, this.aZ, null);
  }
  
  public final ac V()
  {
    return this.aZ.aY.aj();
  }
  
  public final void W()
  {
    this.aZ.aY.W();
  }
  
  public final android.support.v4.b.q<String, ai> X()
  {
    return this.aZ.X();
  }
  
  public final Fragment a(String paramString)
  {
    return this.aZ.aY.a(paramString);
  }
  
  public final void a(Parcelable paramParcelable, ac paramac)
  {
    this.aZ.aY.a(paramParcelable, paramac);
  }
  
  public final void a(android.support.v4.b.q<String, ai> paramq)
  {
    this.aZ.a(paramq);
  }
  
  public final void dispatchActivityCreated()
  {
    this.aZ.aY.dispatchActivityCreated();
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    this.aZ.aY.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    return this.aZ.aY.dispatchContextItemSelected(paramMenuItem);
  }
  
  public final void dispatchCreate()
  {
    this.aZ.aY.dispatchCreate();
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.aZ.aY.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public final void dispatchDestroy()
  {
    this.aZ.aY.dispatchDestroy();
  }
  
  public final void dispatchLowMemory()
  {
    this.aZ.aY.dispatchLowMemory();
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    this.aZ.aY.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.aZ.aY.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    this.aZ.aY.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public final void dispatchPause()
  {
    this.aZ.aY.dispatchPause();
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.aZ.aY.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    return this.aZ.aY.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  public final void dispatchResume()
  {
    this.aZ.aY.dispatchResume();
  }
  
  public final void dispatchStart()
  {
    this.aZ.aY.dispatchStart();
  }
  
  public final void dispatchStop()
  {
    this.aZ.aY.dispatchStop();
  }
  
  public final void doLoaderDestroy()
  {
    this.aZ.doLoaderDestroy();
  }
  
  public final void doLoaderStart()
  {
    this.aZ.doLoaderStart();
  }
  
  public final void doLoaderStop(boolean paramBoolean)
  {
    this.aZ.doLoaderStop(paramBoolean);
  }
  
  public final void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.aZ.dumpLoaders(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean execPendingActions()
  {
    return this.aZ.aY.execPendingActions();
  }
  
  public final void noteStateNotSaved()
  {
    this.aZ.aY.noteStateNotSaved();
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.aZ.aY.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final void reportLoaderStart()
  {
    this.aZ.reportLoaderStart();
  }
  
  public final Parcelable saveAllState()
  {
    return this.aZ.aY.saveAllState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.q
 * JD-Core Version:    0.7.0.1
 */