package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoActivity
  extends Activity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64678);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    bh.a(this).a(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(64678);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64673);
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
        bh.a(super.getApplicationContext()).a(null, paramBundle, null);
      }
      AppMethodBeat.o(64673);
      return;
    }
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(64677);
    super.onDestroy();
    bh.a(this).a(this, 4);
    AppMethodBeat.o(64677);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(64676);
    super.onPause();
    bh.a(this).a(this, 3);
    AppMethodBeat.o(64676);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(64674);
    super.onResume();
    bh.a(this).a(this, 2);
    AppMethodBeat.o(64674);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(64675);
    super.onStop();
    bh.a(this).a(this, 1);
    AppMethodBeat.o(64675);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.VideoActivity
 * JD-Core Version:    0.7.0.1
 */