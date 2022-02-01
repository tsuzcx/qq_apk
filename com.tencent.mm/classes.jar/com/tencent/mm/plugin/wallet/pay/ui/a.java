package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.jd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.h;

public final class a
{
  a HFX = null;
  private Context mContext;
  private Dialog tipDialog = null;
  
  public a(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.HFX = parama;
  }
  
  public final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69303);
    final jd localjd = new jd();
    localjd.dNN = null;
    localjd.dNM.dNO = paramBoolean;
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(69302);
          a.this.closeTipDialog();
          AppMethodBeat.o(69302);
        }
      });
    }
    localjd.dNM.dNP = paramInt;
    localjd.dNM.dNQ = paramString;
    localjd.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69301);
        Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        jd.b localb = localjd.dNN;
        if ((localb != null) && (localb.isSuccess))
        {
          Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.closeTipDialog();
          if (a.this.HFX != null)
          {
            a.this.HFX.d(localb.isSuccess, localb.dNR, localb.dNS);
            AppMethodBeat.o(69301);
          }
        }
        else
        {
          if ((localb != null) && (!localb.isSuccess))
          {
            a.this.closeTipDialog();
            if (a.this.HFX != null) {
              a.this.HFX.d(localb.isSuccess, localb.dNR, localb.dNS);
            }
            Log.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
            AppMethodBeat.o(69301);
            return;
          }
          Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(69301);
      }
    };
    EventCenter.instance.asyncPublish(localjd, Looper.getMainLooper());
    AppMethodBeat.o(69303);
  }
  
  public final void closeTipDialog()
  {
    AppMethodBeat.i(69304);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(69304);
  }
  
  public final void release()
  {
    this.HFX = null;
    this.mContext = null;
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */