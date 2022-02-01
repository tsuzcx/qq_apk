package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static byte[] IYG = new byte[0];
  private static volatile boolean mIsRunning = false;
  
  public void onCreate(Bundle arg1)
  {
    AppMethodBeat.i(33288);
    ad.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
    super.onCreate(???);
    setContentView(2131493128);
    final int i;
    for (;;)
    {
      synchronized (IYG)
      {
        if (mIsRunning)
        {
          ad.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(u.aAm())))
        {
          bool = true;
          ad.i("MicroMsg.JSAPIUploadLogHelperUI", "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          if (??? != null) {
            break;
          }
          ad.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
          finish();
          AppMethodBeat.o(33288);
          return;
        }
      }
      boolean bool = false;
    }
    if (i < 0)
    {
      ad.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[] { Integer.valueOf(i) });
      finish();
      AppMethodBeat.o(33288);
      return;
    }
    getString(2131755906);
    final p localp = h.b(this, getString(2131766294), false, null);
    ba.aiU().a(new bo(new bo.a()
    {
      public final void a(e arg1)
      {
        AppMethodBeat.i(33285);
        synchronized (JSAPIUploadLogHelperUI.ahX())
        {
          JSAPIUploadLogHelperUI.access$102(true);
          ba.aiU().a(1, "", 0, false);
          ad.fku();
          ba.aiU().a(2, paramBundle, i, ba.ajx());
          AppMethodBeat.o(33285);
          return;
        }
      }
    }), 0);
    ba.a(new ap()
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
      public final void oq(int paramAnonymousInt)
      {
        AppMethodBeat.i(33287);
        if (paramAnonymousInt < 0)
        {
          ad.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          ba.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = h.l(JSAPIUploadLogHelperUI.this, 2131764589, 2131755906);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.IYI);
          }
          synchronized (JSAPIUploadLogHelperUI.ahX())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        if (paramAnonymousInt >= 100)
        {
          ad.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
          ba.a(null);
          if (localp != null) {
            localp.dismiss();
          }
          ??? = h.l(JSAPIUploadLogHelperUI.this, 2131764593, 2131755906);
          if (??? != null) {
            ((d)???).setOnDismissListener(this.IYI);
          }
          long l = System.currentTimeMillis() / 1000L;
          g.yhR.f(12975, new Object[] { Long.valueOf(l) });
          synchronized (JSAPIUploadLogHelperUI.ahX())
          {
            JSAPIUploadLogHelperUI.access$102(false);
            AppMethodBeat.o(33287);
            return;
          }
        }
        ad.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
    ad.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[] { Boolean.valueOf(mIsRunning) });
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