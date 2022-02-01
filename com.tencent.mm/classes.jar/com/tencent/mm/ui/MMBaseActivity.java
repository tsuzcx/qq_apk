package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@com.tencent.mm.ui.base.a(3)
public class MMBaseActivity
  extends HellActivity
{
  private boolean mIsPaused;
  
  public final Resources getOriginalResources()
  {
    AppMethodBeat.i(175957);
    Resources localResources = super.getResources();
    AppMethodBeat.o(175957);
    return localResources;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(141354);
    if ((getAssets() != null) && (MMApplicationContext.getResources() != null))
    {
      localResources = MMApplicationContext.getResources();
      AppMethodBeat.o(141354);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(141354);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(141355);
    Object localObject = super.getSystemService(paramString);
    if ((getAssets() != null) && ("layout_inflater".equals(paramString)))
    {
      paramString = af.b((LayoutInflater)localObject);
      AppMethodBeat.o(141355);
      return paramString;
    }
    AppMethodBeat.o(141355);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(141366);
    Object localObject1;
    if (!isDestroyed())
    {
      localObject1 = super.getWindowManager();
      AppMethodBeat.o(141366);
      return localObject1;
    }
    try
    {
      localObject1 = new Throwable().getStackTrace();
      if ((localObject1 != null) && (localObject1.length >= 2) && (localObject1[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject1 = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(141366);
        return localObject1;
      }
    }
    finally
    {
      Log.e("MicroMsg.MMBaseActivity", localObject2.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(141366);
      return localWindowManager;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(141356);
    super.onDestroy();
    AppMethodBeat.o(141356);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(141358);
    this.mIsPaused = true;
    super.onPause();
    AppMethodBeat.o(141358);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(141357);
    this.mIsPaused = false;
    super.onResume();
    AppMethodBeat.o(141357);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(141359);
    if (!AndroidOSafety.safety(this, paramInt))
    {
      Log.e("MicroMsg.MMBaseActivity", "AndroidOSafety.safety false ignore setRequestedOrientation %s for activity %s", new Object[] { Integer.valueOf(paramInt), this });
      AppMethodBeat.o(141359);
      return;
    }
    Log.d("MicroMsg.MMBaseActivity", "setRequestedOrientation %s, %s", new Object[] { this, Integer.valueOf(paramInt) });
    try
    {
      super.setRequestedOrientation(paramInt);
      AppMethodBeat.o(141359);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMBaseActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(141359);
    }
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(141363);
    super.startActivities(paramArrayOfIntent);
    AppMethodBeat.o(141363);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141364);
    if (e.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle }))
    {
      AppMethodBeat.o(141364);
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    AppMethodBeat.o(141364);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(141362);
    super.startActivity(paramIntent);
    AppMethodBeat.o(141362);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141365);
    super.startActivity(paramIntent, paramBundle);
    AppMethodBeat.o(141365);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141360);
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(141360);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141361);
    if (e.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(141361);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(141361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.MMBaseActivity
 * JD-Core Version:    0.7.0.1
 */