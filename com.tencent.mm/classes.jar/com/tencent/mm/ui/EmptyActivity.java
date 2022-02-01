package com.tencent.mm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;

@a(3)
public class EmptyActivity
  extends MMActivity
{
  protected int getLayoutId()
  {
    return 2131493990;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232471);
    Log.d("MicroMsg.EmptyActivity", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    if (ao.gJN()) {
      overridePendingTransition(0, 0);
    }
    getWindow().setFlags(201327616, 201327616);
    AppMethodBeat.o(232471);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(232474);
    super.onDestroy();
    Log.d("MicroMsg.EmptyActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(232474);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(232473);
    super.onPause();
    Log.d("MicroMsg.EmptyActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(232473);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(232472);
    super.onResume();
    Log.i("MicroMsg.EmptyActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.asyncPublish(new qm(), Looper.getMainLooper());
    AppMethodBeat.o(232472);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.EmptyActivity
 * JD-Core Version:    0.7.0.1
 */