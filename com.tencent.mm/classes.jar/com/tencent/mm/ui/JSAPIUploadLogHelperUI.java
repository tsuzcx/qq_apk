package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static volatile boolean mIsRunning = false;
  private static byte[] yYJ = new byte[0];
  
  protected void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(29441);
    ab.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(2130968799);
    int i;
    for (;;)
    {
      synchronized (yYJ)
      {
        if (mIsRunning)
        {
          ab.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(r.Zn())))
        {
          bool = true;
          ab.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          ab.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          AppMethodBeat.o(29441);
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      ab.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      AppMethodBeat.o(29441);
      return;
    }
    getString(2131297087);
    com.tencent.mm.ui.base.p localp = h.b(this, getString(2131306046), false, null);
    aw.Rc().a(new bk(new JSAPIUploadLogHelperUI.1(this, ???, i)), 0);
    aw.a(new JSAPIUploadLogHelperUI.3(this, localp, new JSAPIUploadLogHelperUI.2(this)));
    AppMethodBeat.o(29441);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(29442);
    ab.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onDestroy();
    AppMethodBeat.o(29442);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI
 * JD-Core Version:    0.7.0.1
 */