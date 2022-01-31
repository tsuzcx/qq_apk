package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSuperAlert
  extends Activity
{
  public static void Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4784);
    Intent localIntent = new Intent(paramContext, MMSuperAlert.class);
    localIntent.putExtra("MMSuperAlert_title", 2131297087);
    localIntent.putExtra("MMSuperAlert_msg", paramInt);
    localIntent.putExtra("MMSuperAlert_cancelable", false);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(4784);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(4785);
    if ((getAssets() != null) && (ah.getResources() != null))
    {
      localResources = ah.getResources();
      AppMethodBeat.o(4785);
      return localResources;
    }
    Resources localResources = super.getResources();
    AppMethodBeat.o(4785);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(4783);
    super.onCreate(paramBundle);
    setContentView(2130970275);
    int i = getIntent().getIntExtra("MMSuperAlert_msg", 0);
    int j = getIntent().getIntExtra("MMSuperAlert_title", 0);
    boolean bool = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
    new ak().postDelayed(new MMSuperAlert.1(this, i, j, bool), 50L);
    AppMethodBeat.o(4783);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert
 * JD-Core Version:    0.7.0.1
 */