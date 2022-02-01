package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static byte[] HkZ = new byte[0];
  private static volatile boolean mIsRunning = false;
  
  public void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(33288);
    ac.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(2131493128);
    final int i;
    for (;;)
    {
      synchronized (HkZ)
      {
        if (mIsRunning)
        {
          ac.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(u.axw())))
        {
          bool = true;
          ac.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          ac.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          AppMethodBeat.o(33288);
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      ac.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      AppMethodBeat.o(33288);
      return;
    }
    getString(2131755906);
    final p localp = com.tencent.mm.ui.base.h.b(this, getString(2131766294), false, null);
    az.agi().a(new bn(new bn.a()
    {
      public final void a(e arg1)
      {
        AppMethodBeat.i(33285);
        synchronized (JSAPIUploadLogHelperUI.afl())
        {
          JSAPIUploadLogHelperUI.access$102(true);
          az.agi().a(1, "", 0, false);
          ac.eUQ();
          az.agi().a(2, paramBundle, i, az.agM());
          AppMethodBeat.o(33285);
          return;
        }
      }
    }), 0);
    az.a(new ao()
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
      public final void nQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(33287);
        if (paramAnonymousInt < 0)
        {
          ac.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          az.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.l(JSAPIUploadLogHelperUI.this, 2131764589, 2131755906);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.Hlb);
          }
          synchronized (JSAPIUploadLogHelperUI.afl())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        if (paramAnonymousInt >= 100)
        {
          ac.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
          az.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = com.tencent.mm.ui.base.h.l(JSAPIUploadLogHelperUI.this, 2131764593, 2131755906);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.Hlb);
          }
          long l = System.currentTimeMillis() / 1000L;
          com.tencent.mm.plugin.report.service.h.wUl.f(12975, new Object[] { Long.valueOf(l) });
          synchronized (JSAPIUploadLogHelperUI.afl())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        ac.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (localp != null) {
          localp.setMessage(JSAPIUploadLogHelperUI.this.getString(2131764590) + paramAnonymousInt + "%");
        }
        AppMethodBeat.o(33287);
      }
    });
    AppMethodBeat.o(33288);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33289);
    ac.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onDestroy();
    AppMethodBeat.o(33289);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI
 * JD-Core Version:    0.7.0.1
 */