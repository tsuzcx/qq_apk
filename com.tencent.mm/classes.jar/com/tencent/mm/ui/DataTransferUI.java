package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

@a(19)
public class DataTransferUI
  extends MMBaseActivity
{
  private s oTk;
  private long startTime = 0L;
  
  private void by(Intent paramIntent)
  {
    AppMethodBeat.i(33018);
    boolean bool = paramIntent.getBooleanExtra("finish_data_transfer", false);
    Log.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + bool);
    if (bool) {
      finish();
    }
    AppMethodBeat.o(33018);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33016);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
    this.startTime = System.currentTimeMillis();
    getString(R.l.app_tip);
    this.oTk = h.a(this, getString(R.l.app_data_transfering), false, null);
    new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33015);
        if ((DataTransferUI.a(DataTransferUI.this) != null) && (DataTransferUI.a(DataTransferUI.this).isShowing()))
        {
          Log.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
          DataTransferUI.a(DataTransferUI.this).dismiss();
          DataTransferUI.this.finish();
        }
        AppMethodBeat.o(33015);
      }
    }.sendEmptyMessageDelayed(0, 60000L);
    by(getIntent());
    AppMethodBeat.o(33016);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33020);
    super.onDestroy();
    Log.d("MicroMsg.DataTransferUI", "onDestroy");
    if ((this.oTk != null) && (this.oTk.isShowing())) {
      this.oTk.dismiss();
    }
    AppMethodBeat.o(33020);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33017);
    Log.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
    by(paramIntent);
    AppMethodBeat.o(33017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33019);
    Log.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
    super.onPause();
    AppMethodBeat.o(33019);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.DataTransferUI
 * JD-Core Version:    0.7.0.1
 */