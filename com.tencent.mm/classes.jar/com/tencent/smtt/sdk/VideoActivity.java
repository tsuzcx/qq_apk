package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class VideoActivity
  extends HellActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55103);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    t.a(this).a(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(55103);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55098);
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
    paramBundle = super.getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getBundleExtra("extraData");; paramBundle = null)
    {
      if (paramBundle != null)
      {
        paramBundle.putInt("callMode", 1);
        t.a(super.getApplicationContext()).a(null, paramBundle, null);
      }
      AppMethodBeat.o(55098);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55102);
    super.onDestroy();
    t.a(this).a(this, 4);
    AppMethodBeat.o(55102);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55101);
    super.onPause();
    t.a(this).a(this, 3);
    AppMethodBeat.o(55101);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55099);
    super.onResume();
    t.a(this).a(this, 2);
    AppMethodBeat.o(55099);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(55100);
    super.onStop();
    t.a(this).a(this, 1);
    AppMethodBeat.o(55100);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.VideoActivity
 * JD-Core Version:    0.7.0.1
 */