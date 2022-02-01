package com.tencent.mm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.f.a.rm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;

@a(3)
public class EmptyActivity
  extends MMActivity
{
  protected int getLayoutId()
  {
    return R.i.empty_layout;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264226);
    Log.d("MicroMsg.EmptyActivity", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    if (ar.hIO()) {
      overridePendingTransition(0, 0);
    }
    getWindow().setFlags(201327616, 201327616);
    AppMethodBeat.o(264226);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(264230);
    super.onDestroy();
    Log.d("MicroMsg.EmptyActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(264230);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(264229);
    super.onPause();
    Log.d("MicroMsg.EmptyActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(264229);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(264227);
    super.onResume();
    Log.i("MicroMsg.EmptyActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    EventCenter.instance.asyncPublish(new rm(), Looper.getMainLooper());
    AppMethodBeat.o(264227);
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