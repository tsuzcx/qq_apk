package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public final class r
{
  private final s<?> cJ;
  
  private r(s<?> params)
  {
    this.cJ = params;
  }
  
  public static r a(s<?> params)
  {
    return new r(params);
  }
  
  public final Fragment a(String paramString)
  {
    return this.cJ.cI.a(paramString);
  }
  
  public final void a(Parcelable paramParcelable, ae paramae)
  {
    this.cJ.cI.a(paramParcelable, paramae);
  }
  
  public final t ah()
  {
    return this.cJ.cI;
  }
  
  public final void al()
  {
    this.cJ.cI.a(this.cJ, this.cJ, null);
  }
  
  public final ae am()
  {
    return this.cJ.cI.ay();
  }
  
  public final void an()
  {
    this.cJ.cI.an();
  }
  
  public final void dispatchActivityCreated()
  {
    this.cJ.cI.dispatchActivityCreated();
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    this.cJ.cI.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    return this.cJ.cI.dispatchContextItemSelected(paramMenuItem);
  }
  
  public final void dispatchCreate()
  {
    this.cJ.cI.dispatchCreate();
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.cJ.cI.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public final void dispatchDestroy()
  {
    this.cJ.cI.dispatchDestroy();
  }
  
  public final void dispatchLowMemory()
  {
    this.cJ.cI.dispatchLowMemory();
  }
  
  public final void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    this.cJ.cI.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.cJ.cI.dispatchOptionsItemSelected(paramMenuItem);
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    this.cJ.cI.dispatchOptionsMenuClosed(paramMenu);
  }
  
  public final void dispatchPause()
  {
    this.cJ.cI.dispatchPause();
  }
  
  public final void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.cJ.cI.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    return this.cJ.cI.dispatchPrepareOptionsMenu(paramMenu);
  }
  
  public final void dispatchResume()
  {
    this.cJ.cI.dispatchResume();
  }
  
  public final void dispatchStart()
  {
    this.cJ.cI.dispatchStart();
  }
  
  public final void dispatchStop()
  {
    this.cJ.cI.dispatchStop();
  }
  
  public final boolean execPendingActions()
  {
    return this.cJ.cI.execPendingActions();
  }
  
  public final void noteStateNotSaved()
  {
    this.cJ.cI.noteStateNotSaved();
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.cJ.cI.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final Parcelable saveAllState()
  {
    return this.cJ.cI.saveAllState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.r
 * JD-Core Version:    0.7.0.1
 */