package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.g;

public final class a
{
  a CID = null;
  private Context mContext;
  private Dialog tipDialog = null;
  
  public a(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.CID = parama;
  }
  
  public final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69303);
    final in localin = new in();
    localin.dvb = null;
    localin.dva.dvc = paramBoolean;
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = g.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(69302);
          a.this.closeTipDialog();
          AppMethodBeat.o(69302);
        }
      });
    }
    localin.dva.dvd = paramInt;
    localin.dva.dve = paramString;
    localin.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69301);
        ad.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        in.b localb = localin.dvb;
        if ((localb != null) && (localb.dpX))
        {
          ad.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.closeTipDialog();
          if (a.this.CID != null)
          {
            a.this.CID.d(localb.dpX, localb.dvf, localb.dvg);
            AppMethodBeat.o(69301);
          }
        }
        else
        {
          if ((localb != null) && (!localb.dpX))
          {
            a.this.closeTipDialog();
            if (a.this.CID != null) {
              a.this.CID.d(localb.dpX, localb.dvf, localb.dvg);
            }
            ad.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
            AppMethodBeat.o(69301);
            return;
          }
          ad.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(69301);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(localin, Looper.getMainLooper());
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
    this.CID = null;
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