package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.if.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.g;

public final class a
{
  a Bip = null;
  private Context mContext;
  private Dialog tipDialog = null;
  
  public a(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.Bip = parama;
  }
  
  public final void b(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69303);
    final if localif = new if();
    localif.djo = null;
    localif.djn.djp = paramBoolean;
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
    localif.djn.djq = paramInt;
    localif.djn.djr = paramString;
    localif.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69301);
        ac.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        if.b localb = localif.djo;
        if ((localb != null) && (localb.deB))
        {
          ac.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.closeTipDialog();
          if (a.this.Bip != null)
          {
            a.this.Bip.c(localb.deB, localb.djs, localb.djt);
            AppMethodBeat.o(69301);
          }
        }
        else
        {
          if ((localb != null) && (!localb.deB))
          {
            a.this.closeTipDialog();
            if (a.this.Bip != null) {
              a.this.Bip.c(localb.deB, localb.djs, localb.djt);
            }
            ac.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
            AppMethodBeat.o(69301);
            return;
          }
          ac.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
        }
        AppMethodBeat.o(69301);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.a(localif, Looper.getMainLooper());
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
    this.Bip = null;
    this.mContext = null;
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */