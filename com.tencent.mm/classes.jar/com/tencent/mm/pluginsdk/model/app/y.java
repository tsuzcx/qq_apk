package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.p;

public final class y
  implements u
{
  public a Dis;
  n dcV;
  public Context mContext;
  public p tipDialog;
  
  public y(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.Dis = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(151803);
    ac.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.dnB().b(7, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.Dis != null) {
      this.Dis.aRA();
    }
    q.eLh();
    AppMethodBeat.o(151803);
  }
  
  public static abstract interface a
  {
    public abstract void aRA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.y
 * JD-Core Version:    0.7.0.1
 */