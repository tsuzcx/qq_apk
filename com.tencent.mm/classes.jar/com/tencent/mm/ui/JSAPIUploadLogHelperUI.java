package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static byte[] ODG = new byte[0];
  private static volatile boolean mIsRunning = false;
  
  public void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(33288);
    Log.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(2131493171);
    final int i;
    for (;;)
    {
      synchronized (ODG)
      {
        if (mIsRunning)
        {
          Log.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(z.aTY())))
        {
          bool = true;
          Log.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          Log.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          AppMethodBeat.o(33288);
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      Log.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      AppMethodBeat.o(33288);
      return;
    }
    getString(2131755998);
    final q localq = com.tencent.mm.ui.base.h.a(this, getString(2131768805), false, null);
    bg.azz().a(new bu(new bu.a()
    {
      public final void a(g arg1)
      {
        AppMethodBeat.i(33285);
        synchronized (JSAPIUploadLogHelperUI.ayC())
        {
          JSAPIUploadLogHelperUI.access$102(true);
          bg.azz().a(1, "", 0, false);
          Log.appenderFlush();
          bg.azz().a(2, paramBundle, i, bg.aAc());
          AppMethodBeat.o(33285);
          return;
        }
      }
    }), 0);
    bg.a(new av()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33286);
        if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
          JSAPIUploadLogHelperUI.this.finish();
        }
        AppMethodBeat.o(33286);
      }
    }
    {
      public final void rU(int paramAnonymousInt)
      {
        AppMethodBeat.i(33287);
        if (paramAnonymousInt < 0)
        {
          Log.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          bg.a(null);
          if (localq != null) {
            localq.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.n(JSAPIUploadLogHelperUI.this, 2131766947, 2131755998);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.ODI);
          }
          synchronized (JSAPIUploadLogHelperUI.ayC())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        if (paramAnonymousInt >= 100)
        {
          Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
          bg.a(null);
          if (localq != null) {
            localq.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.n(JSAPIUploadLogHelperUI.this, 2131766951, 2131755998);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.ODI);
          }
          long l = System.currentTimeMillis() / 1000L;
          com.tencent.mm.plugin.report.service.h.CyF.a(12975, new Object[] { Long.valueOf(l) });
          synchronized (JSAPIUploadLogHelperUI.ayC())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (localq != null) {
          localq.setMessage(JSAPIUploadLogHelperUI.this.getString(2131766948) + paramAnonymousInt + "%");
        }
        AppMethodBeat.o(33287);
      }
    });
    AppMethodBeat.o(33288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33289);
    Log.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onDestroy();
    AppMethodBeat.o(33289);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI
 * JD-Core Version:    0.7.0.1
 */