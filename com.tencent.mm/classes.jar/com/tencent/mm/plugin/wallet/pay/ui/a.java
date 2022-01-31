package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import com.tencent.mm.h.a.hb;
import com.tencent.mm.h.a.hb.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.g;

public final class a
{
  private Dialog ftk = null;
  private Context mContext;
  a.a qms = null;
  
  public a(Context paramContext, a.a parama)
  {
    this.mContext = paramContext;
    this.qms = parama;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    final hb localhb = new hb();
    localhb.bOQ = null;
    localhb.bOP.bOR = paramBoolean;
    if ((paramBoolean) && ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing()))))
    {
      if (this.ftk != null) {
        this.ftk.dismiss();
      }
      this.ftk = g.a(this.mContext, false, new a.2(this));
    }
    localhb.bOP.bOS = paramInt;
    localhb.bOP.bOT = paramString;
    localhb.bFJ = new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
        hb.b localb = localhb.bOQ;
        if ((localb != null) && (localb.bKQ))
        {
          y.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
          a.this.bTT();
          if (a.this.qms != null) {
            a.this.qms.b(localb.bKQ, localb.bOU, localb.bOV);
          }
          return;
        }
        if ((localb != null) && (!localb.bKQ))
        {
          a.this.bTT();
          if (a.this.qms != null) {
            a.this.qms.b(localb.bKQ, localb.bOU, localb.bOV);
          }
          y.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
          return;
        }
        y.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
      }
    };
    com.tencent.mm.sdk.b.a.udP.a(localhb, Looper.getMainLooper());
  }
  
  public final void bTT()
  {
    if (this.ftk != null)
    {
      this.ftk.dismiss();
      this.ftk = null;
    }
  }
  
  public final void release()
  {
    this.qms = null;
    this.mContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */