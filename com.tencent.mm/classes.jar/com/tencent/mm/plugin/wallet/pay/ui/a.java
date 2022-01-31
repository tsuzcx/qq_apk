package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.wallet_core.ui.g;

public final class a
{
  private Dialog gKM = null;
  private Context mContext;
  a.a tVH = null;
  
  public a(Context paramContext, a.a parama)
  {
    this.mContext = paramContext;
    this.tVH = parama;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String paramString)
  {
    AppMethodBeat.i(45954);
    he localhe = new he();
    localhe.cwh = null;
    localhe.cwg.cwi = paramBoolean;
    if ((paramBoolean) && ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing()))))
    {
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      this.gKM = g.a(this.mContext, false, new a.2(this));
    }
    localhe.cwg.cwj = paramInt;
    localhe.cwg.cwk = paramString;
    localhe.callback = new a.1(this, localhe);
    com.tencent.mm.sdk.b.a.ymk.a(localhe, Looper.getMainLooper());
    AppMethodBeat.o(45954);
  }
  
  public final void cRP()
  {
    AppMethodBeat.i(45955);
    if (this.gKM != null)
    {
      this.gKM.dismiss();
      this.gKM = null;
    }
    AppMethodBeat.o(45955);
  }
  
  public final void release()
  {
    this.tVH = null;
    this.mContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.a
 * JD-Core Version:    0.7.0.1
 */