package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

@com.tencent.mm.ui.base.a(3)
public class MMBaseActivity
  extends Activity
{
  private boolean mIsPaused;
  
  public Resources getResources()
  {
    AppMethodBeat.i(106016);
    if ((getAssets() != null) && (ah.getResources() != null))
    {
      localResources = ah.getResources();
      AppMethodBeat.o(106016);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(106016);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(106017);
    Object localObject = super.getSystemService(paramString);
    if ((getAssets() != null) && ("layout_inflater".equals(paramString)))
    {
      paramString = w.b((LayoutInflater)localObject);
      AppMethodBeat.o(106017);
      return paramString;
    }
    AppMethodBeat.o(106017);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(156396);
    try
    {
      Object localObject = new Throwable().getStackTrace();
      if ((localObject != null) && (localObject.length >= 2) && (localObject[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(156396);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.MMBaseActivity", localThrowable.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(156396);
      return localWindowManager;
    }
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(106018);
    super.onDestroy();
    AppMethodBeat.o(106018);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(106020);
    this.mIsPaused = true;
    super.onPause();
    AppMethodBeat.o(106020);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(106019);
    this.mIsPaused = false;
    super.onResume();
    AppMethodBeat.o(106019);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(106024);
    super.startActivities(paramArrayOfIntent);
    AppMethodBeat.o(106024);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(106025);
    if (d.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle }))
    {
      AppMethodBeat.o(106025);
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    AppMethodBeat.o(106025);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(106023);
    super.startActivity(paramIntent);
    AppMethodBeat.o(106023);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(106026);
    super.startActivity(paramIntent, paramBundle);
    AppMethodBeat.o(106026);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(106021);
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(106021);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(106022);
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(106022);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(106022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMBaseActivity
 * JD-Core Version:    0.7.0.1
 */