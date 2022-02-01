package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.t;
import com.tencent.mm.app.t.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;

public class JSAPIUploadLogHelperUI
  extends MMBaseActivity
{
  private static final byte[] adBt = new byte[0];
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
      synchronized (adBt)
      {
        if (mIsRunning)
        {
          Log.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
          finish();
        }
        ??? = getIntent().getStringExtra("key_user");
        i = getIntent().getIntExtra("key_time", 0);
        if ((??? != null) && (???.equals(z.bAM())))
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
    ??? = k.a(this, getString(R.l.wv_uploading), false, null);
    bh.aZW().a(new bw(new bw.a()
    {
      public final void b(g arg1)
      {
        AppMethodBeat.i(33285);
        for (;;)
        {
          synchronized (JSAPIUploadLogHelperUI.aCv())
          {
            JSAPIUploadLogHelperUI.access$102(true);
            ??? = new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(249095);
                if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                  JSAPIUploadLogHelperUI.this.finish();
                }
                AppMethodBeat.o(249095);
              }
            };
            bh.aZW().bFP();
            Log.appenderFlush();
            if (bh.baz())
            {
              com.tencent.mm.kernel.h.baC();
              i = b.getUin();
              int j = i;
              boolean bool = bh.baz();
              long l = i;
              ??? = new t.a()
              {
                public final void V(String arg1, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(249106);
                  if (paramAnonymous2Int == 100)
                  {
                    Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                    if (JSAPIUploadLogHelperUI.1.this.val$progressDialog != null) {
                      JSAPIUploadLogHelperUI.1.this.val$progressDialog.dismiss();
                    }
                    ??? = k.s(JSAPIUploadLogHelperUI.this, R.l.gXA, R.l.app_tip);
                    if (??? != null) {
                      ???.setOnDismissListener(paramAnonymousg);
                    }
                    long l = System.currentTimeMillis() / 1000L;
                    com.tencent.mm.plugin.report.service.h.OAn.b(12975, new Object[] { Long.valueOf(l) });
                    synchronized (JSAPIUploadLogHelperUI.aCv())
                    {
                      JSAPIUploadLogHelperUI.access$102(false);
                      AppMethodBeat.o(249106);
                      return;
                    }
                  }
                  Log.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  if (JSAPIUploadLogHelperUI.1.this.val$progressDialog != null) {
                    JSAPIUploadLogHelperUI.1.this.val$progressDialog.setMessage(JSAPIUploadLogHelperUI.this.getString(R.l.gXx) + paramAnonymous2Int + "%");
                  }
                  AppMethodBeat.o(249106);
                }
                
                public final void onError(String arg1)
                {
                  AppMethodBeat.i(249108);
                  Log.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened.");
                  if (JSAPIUploadLogHelperUI.1.this.val$progressDialog != null) {
                    JSAPIUploadLogHelperUI.1.this.val$progressDialog.dismiss();
                  }
                  ??? = k.s(JSAPIUploadLogHelperUI.this, R.l.gXw, R.l.app_tip);
                  if (??? != null) {
                    ???.setOnDismissListener(paramAnonymousg);
                  }
                  synchronized (JSAPIUploadLogHelperUI.aCv())
                  {
                    JSAPIUploadLogHelperUI.access$102(false);
                    AppMethodBeat.o(249108);
                    return;
                  }
                }
              };
              t.a(new int[] { j }, bool, l, ???);
              AppMethodBeat.o(33285);
              return;
            }
          }
          int i = 0;
        }
      }
    }), 0);
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