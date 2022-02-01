package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static byte[] VWY = new byte[0];
  private static volatile boolean mIsRunning = false;
  
  public void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(33288);
    Log.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(R.i.background_transparent);
    final int i;
    for (;;)
    {
      synchronized (VWY)
      {
        if (mIsRunning)
        {
          Log.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(z.bcZ())))
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
    getString(R.l.app_tip);
    final s locals = com.tencent.mm.ui.base.h.a(this, getString(R.l.wv_uploading), false, null);
    bh.aGY().a(new bv(new bv.a()
    {
      public final void a(g arg1)
      {
        AppMethodBeat.i(33285);
        synchronized (JSAPIUploadLogHelperUI.aFV())
        {
          JSAPIUploadLogHelperUI.access$102(true);
          bh.aGY().a(1, "", 0, false);
          Log.appenderFlush();
          bh.aGY().a(2, paramBundle, i, bh.aHB());
          AppMethodBeat.o(33285);
          return;
        }
      }
    }), 0);
    bh.a(new aw()
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
      public final void uR(int paramAnonymousInt)
      {
        AppMethodBeat.i(33287);
        if (paramAnonymousInt < 0)
        {
          Log.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          bh.a(null);
          if (locals != null) {
            locals.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.p(JSAPIUploadLogHelperUI.this, R.l.eUx, R.l.app_tip);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.VXa);
          }
          synchronized (JSAPIUploadLogHelperUI.aFV())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        if (paramAnonymousInt >= 100)
        {
          Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
          bh.a(null);
          if (locals != null) {
            locals.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.p(JSAPIUploadLogHelperUI.this, R.l.eUB, R.l.app_tip);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.VXa);
          }
          long l = System.currentTimeMillis() / 1000L;
          com.tencent.mm.plugin.report.service.h.IzE.a(12975, new Object[] { Long.valueOf(l) });
          synchronized (JSAPIUploadLogHelperUI.aFV())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (locals != null) {
          locals.setMessage(JSAPIUploadLogHelperUI.this.getString(R.l.eUy) + paramAnonymousInt + "%");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI
 * JD-Core Version:    0.7.0.1
 */