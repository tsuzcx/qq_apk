package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.io.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.h;

public final class a
{
  a Daj = null;
  private Context mContext;
  private Dialog tipDialog = null;
  
  public a(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.Daj = parama;
  }
  
  public final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69303);
    final io localio = new io();
    localio.dwg = null;
    localio.dwf.dwh = paramBoolean;
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
    localio.dwf.dwi = paramInt;
    localio.dwf.dwj = paramString;
    localio.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69301);
        ae.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        io.b localb = localio.dwg;
        if ((localb != null) && (localb.drc))
        {
          ae.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.closeTipDialog();
          if (a.this.Daj != null)
          {
            a.this.Daj.d(localb.drc, localb.dwk, localb.dwl);
            AppMethodBeat.o(69301);
          }
        }
        else
        {
          if ((localb != null) && (!localb.drc))
          {
            a.this.closeTipDialog();
            if (a.this.Daj != null) {
              a.this.Daj.d(localb.drc, localb.dwk, localb.dwl);
            }
            ae.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
            AppMethodBeat.o(69301);
            return;
          }
          ae.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(69301);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localio, Looper.getMainLooper());
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
    this.Daj = null;
    this.mContext = null;
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */