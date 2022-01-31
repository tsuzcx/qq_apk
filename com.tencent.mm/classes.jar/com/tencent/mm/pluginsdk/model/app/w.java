package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class w
  implements t
{
  m cqE;
  public Context mContext;
  public com.tencent.mm.ui.base.p tipDialog;
  public w.a vLu;
  
  public w(Context paramContext, w.a parama)
  {
    this.mContext = paramContext;
    this.vLu = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    AppMethodBeat.i(79365);
    ab.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.caf().b(7, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.vLu != null) {
      this.vLu.asg();
    }
    p.dlG();
    AppMethodBeat.o(79365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.w
 * JD-Core Version:    0.7.0.1
 */