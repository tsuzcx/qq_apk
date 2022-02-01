package com.tencent.mm.plugin.setting.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.tencent.mm.am.h
{
  private a Pnn;
  private long Pno;
  private long Pnp;
  private long Pnq;
  private long Pnr;
  private boolean Pns;
  public boolean hks;
  private Runnable hkt;
  private Runnable hku;
  private AtomicBoolean hkv;
  private Context mContext;
  private int mScene;
  private int pTf;
  private w tipDialog;
  
  public a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, a parama)
  {
    AppMethodBeat.i(298524);
    this.hkv = new AtomicBoolean(false);
    this.Pns = false;
    this.mContext = paramContext;
    this.Pnn = parama;
    this.tipDialog = null;
    this.mScene = paramInt1;
    this.pTf = paramInt2;
    this.Pnp = paramLong1;
    this.Pno = paramLong2;
    AppMethodBeat.o(298524);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, a parama, byte paramByte)
  {
    AppMethodBeat.i(298529);
    this.hkv = new AtomicBoolean(false);
    this.Pns = false;
    this.mContext = paramContext;
    this.Pnn = parama;
    this.tipDialog = null;
    this.mScene = paramInt1;
    this.pTf = paramInt2;
    this.Pnr = paramLong1;
    this.Pnq = paramLong2;
    this.Pns = true;
    AppMethodBeat.o(298529);
  }
  
  private void a(boolean paramBoolean, app paramapp)
  {
    AppMethodBeat.i(298535);
    if (this.Pnn != null) {
      this.Pnn.b(paramBoolean, paramapp);
    }
    AppMethodBeat.o(298535);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(298537);
    if (this.hks)
    {
      if (this.hku != null) {
        MMHandlerThread.removeRunnable(this.hku);
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
    }
    MMHandlerThread.removeRunnable(this.hkt);
    com.tencent.mm.kernel.h.baD().mCm.b(4071, this);
    AppMethodBeat.o(298537);
  }
  
  public final void gUT()
  {
    AppMethodBeat.i(298553);
    if (this.hks)
    {
      this.hku = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(298569);
          Log.i("MicroMsg.CheckFinderManagerSwithFun", "startShowLoading");
          a locala = a.this;
          Context localContext = a.d(a.this);
          a.d(a.this).getString(c.h.app_tip);
          a.a(locala, k.a(localContext, a.d(a.this).getString(c.h.loading_tips_1), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(298562);
              a.c(a.this);
              a.b(a.this);
              AppMethodBeat.o(298562);
            }
          }));
          AppMethodBeat.o(298569);
        }
      };
      MMHandlerThread.postToMainThreadDelayed(this.hku, 200L);
    }
    this.hkt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(298566);
        Log.i("MicroMsg.CheckFinderManagerSwithFun", "check short link timeout");
        a.a(a.this).set(true);
        a.b(a.this);
        a.c(a.this);
        AppMethodBeat.o(298566);
      }
    };
    MMHandlerThread.postToMainThreadDelayed(this.hkt, 60000L);
    com.tencent.mm.kernel.h.baD().mCm.a(4071, this);
    if (this.Pns) {}
    for (f localf = new f(this.mScene, this.pTf, this.Pnr, this.Pnq, true);; localf = new f(this.mScene, this.pTf, this.Pnp, this.Pno, false))
    {
      com.tencent.mm.kernel.h.baD().mCm.a(localf, 0);
      AppMethodBeat.o(298553);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(298555);
    Log.i("MicroMsg.CheckFinderManagerSwithFun", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((!(paramp instanceof f)) || (paramp.getType() != 4071))
    {
      Log.w("MicroMsg.CheckFinderManagerSwithFun", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(298555);
      return;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      a(true, (app)c.c.b(((f)paramp).rr.otC));
      AppMethodBeat.o(298555);
      return;
    }
    if (!Util.isNullOrNil(paramString)) {
      k.c(this.mContext, paramString, "", true);
    }
    a(false, null);
    AppMethodBeat.o(298555);
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, app paramapp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.a
 * JD-Core Version:    0.7.0.1
 */