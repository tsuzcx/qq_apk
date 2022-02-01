package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  implements u
{
  public a JWu;
  com.tencent.mm.ak.q dGJ;
  public Context mContext;
  public com.tencent.mm.ui.base.q tipDialog;
  
  public y(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.JWu = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151803);
    Log.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.eAV().b(7, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.JWu != null) {
      this.JWu.onFinished();
    }
    q.gna();
    AppMethodBeat.o(151803);
  }
  
  public static abstract interface a
  {
    public abstract void onFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.y
 * JD-Core Version:    0.7.0.1
 */