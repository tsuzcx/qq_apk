package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(19)
public class DataTransferUI
  extends MMBaseActivity
{
  private p mcf;
  private long startTime = 0L;
  
  private void bi(Intent paramIntent)
  {
    AppMethodBeat.i(33018);
    boolean bool = paramIntent.getBooleanExtra("finish_data_transfer", false);
    ac.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + bool);
    if (bool) {
      finish();
    }
    AppMethodBeat.o(33018);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33016);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
    this.startTime = System.currentTimeMillis();
    getString(2131755906);
    this.mcf = h.b(this, getString(2131755704), false, null);
    new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(33015);
        if ((DataTransferUI.a(DataTransferUI.this) != null) && (DataTransferUI.a(DataTransferUI.this).isShowing()))
        {
          ac.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
          DataTransferUI.a(DataTransferUI.this).dismiss();
          DataTransferUI.this.finish();
        }
        AppMethodBeat.o(33015);
      }
    }.sendEmptyMessageDelayed(0, 60000L);
    bi(getIntent());
    AppMethodBeat.o(33016);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33020);
    super.onDestroy();
    ac.d("MicroMsg.DataTransferUI", "onDestroy");
    if ((this.mcf != null) && (this.mcf.isShowing())) {
      this.mcf.dismiss();
    }
    AppMethodBeat.o(33020);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33017);
    ac.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
    bi(paramIntent);
    AppMethodBeat.o(33017);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33019);
    ac.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
    super.onPause();
    AppMethodBeat.o(33019);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.DataTransferUI
 * JD-Core Version:    0.7.0.1
 */