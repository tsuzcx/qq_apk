package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(19)
public class DataTransferUI
  extends MMBaseActivity
{
  private p hdi;
  private long startTime = 0L;
  
  private void an(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("finish_data_transfer", false);
    y.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + bool);
    if (bool) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
    this.startTime = System.currentTimeMillis();
    getString(R.l.app_tip);
    this.hdi = h.b(this, getString(R.l.app_data_transfering), false, null);
    new DataTransferUI.1(this).sendEmptyMessageDelayed(0, 60000L);
    an(getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.d("MicroMsg.DataTransferUI", "onDestroy");
    if ((this.hdi != null) && (this.hdi.isShowing())) {
      this.hdi.dismiss();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
    an(paramIntent);
  }
  
  protected void onPause()
  {
    y.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.DataTransferUI
 * JD-Core Version:    0.7.0.1
 */