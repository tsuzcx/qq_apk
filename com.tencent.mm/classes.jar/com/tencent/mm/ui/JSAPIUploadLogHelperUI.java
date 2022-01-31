package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static volatile boolean mIsRunning = false;
  private static byte[] uKH = new byte[0];
  
  protected void onCreate(Bundle arg1)
  {
    y.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(R.i.background_transparent);
    int i;
    for (;;)
    {
      synchronized (uKH)
      {
        if (mIsRunning)
        {
          y.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(q.Gj())))
        {
          bool = true;
          y.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          y.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      y.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      return;
    }
    getString(R.l.app_tip);
    com.tencent.mm.ui.base.p localp = h.b(this, getString(R.l.wv_uploading), false, null);
    au.Dk().a(new bi(new JSAPIUploadLogHelperUI.1(this, ???, i)), 0);
    au.a(new JSAPIUploadLogHelperUI.3(this, localp, new JSAPIUploadLogHelperUI.2(this)));
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI
 * JD-Core Version:    0.7.0.1
 */