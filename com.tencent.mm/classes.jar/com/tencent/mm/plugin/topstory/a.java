package com.tencent.mm.plugin.topstory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.fuu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.tencent.mm.am.h
{
  private a THR;
  boolean hks;
  Runnable hkt;
  Runnable hku;
  private AtomicBoolean hkv;
  private Context mContext;
  private w tipDialog;
  int zZv;
  
  public a(Context paramContext, int paramInt, a parama)
  {
    AppMethodBeat.i(271629);
    this.hkv = new AtomicBoolean(false);
    this.mContext = paramContext;
    this.THR = parama;
    this.tipDialog = null;
    this.zZv = paramInt;
    AppMethodBeat.o(271629);
  }
  
  private void a(boolean paramBoolean, fuu paramfuu)
  {
    AppMethodBeat.i(271631);
    if (this.THR != null) {
      this.THR.b(paramBoolean, paramfuu);
    }
    AppMethodBeat.o(271631);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(271637);
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
    AppMethodBeat.o(271637);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(271653);
    Log.i("MicroMsg.CheckFinderManagerSwithFun", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((!(paramp instanceof b)) || (paramp.getType() != 4071))
    {
      Log.w("MicroMsg.CheckFinderManagerSwithFun", "not expected action,  type = " + paramp.getType());
      AppMethodBeat.o(271653);
      return;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      a(true, (fuu)c.c.b(((b)paramp).rr.otC));
      AppMethodBeat.o(271653);
      return;
    }
    if (!Util.isNullOrNil(paramString)) {
      k.c(this.mContext, paramString, "", true);
    }
    a(false, null);
    AppMethodBeat.o(271653);
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, fuu paramfuu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a
 * JD-Core Version:    0.7.0.1
 */