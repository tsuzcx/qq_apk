package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kv;
import com.tencent.mm.autogen.a.kv.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.l;

public final class a
{
  a Vnb = null;
  private Context mContext;
  private Dialog tipDialog = null;
  
  public a(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.Vnb = parama;
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
  
  public final void d(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(69303);
    final kv localkv = new kv();
    localkv.hMv = null;
    localkv.hMu.hMw = paramBoolean;
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = l.a(this.mContext, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(69302);
          a.this.closeTipDialog();
          AppMethodBeat.o(69302);
        }
      });
    }
    localkv.hMu.hMx = paramInt;
    localkv.hMu.hMy = paramString;
    localkv.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(69301);
        Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        kv.b localb = localkv.hMv;
        if ((localb != null) && (localb.isSuccess))
        {
          Log.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.closeTipDialog();
          if (a.this.Vnb != null)
          {
            a.this.Vnb.g(localb.isSuccess, localb.hMz, localb.hMA);
            AppMethodBeat.o(69301);
          }
        }
        else
        {
          if ((localb != null) && (!localb.isSuccess))
          {
            a.this.closeTipDialog();
            if (a.this.Vnb != null) {
              a.this.Vnb.g(localb.isSuccess, localb.hMz, localb.hMA);
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
    localkv.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(69303);
  }
  
  public final void release()
  {
    this.Vnb = null;
    this.mContext = null;
  }
  
  public static abstract interface a
  {
    public abstract void g(boolean paramBoolean, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */