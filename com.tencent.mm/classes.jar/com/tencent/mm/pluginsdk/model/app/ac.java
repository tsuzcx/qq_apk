package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;

public final class ac
  implements y
{
  public a XSL;
  p hEi;
  public Context mContext;
  public w tipDialog;
  
  public ac(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.XSL = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, ae paramae)
  {
    AppMethodBeat.i(151803);
    Log.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.gxq().b(7, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.XSL != null) {
      this.XSL.onFinished();
    }
    u.iID();
    AppMethodBeat.o(151803);
  }
  
  public static abstract interface a
  {
    public abstract void onFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */