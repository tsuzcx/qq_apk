package com.tencent.mm.ui;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.a.tb;
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
    AppMethodBeat.i(249736);
    Log.d("MicroMsg.EmptyActivity", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    updataStatusBarIcon(aw.isDarkMode());
    if (aw.jlc()) {
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(249736);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(249748);
    super.onDestroy();
    Log.d("MicroMsg.EmptyActivity", "onDestroy %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(249748);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(249744);
    super.onPause();
    Log.d("MicroMsg.EmptyActivity", "onPause %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(249744);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249742);
    super.onResume();
    Log.i("MicroMsg.EmptyActivity", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    new tb().asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(249742);
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