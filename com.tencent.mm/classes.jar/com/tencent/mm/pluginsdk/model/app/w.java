package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

public final class w
  implements t
{
  m bJk;
  public Context mContext;
  public w.a rUw;
  public p tipDialog;
  
  public w(Context paramContext, w.a parama)
  {
    this.mContext = paramContext;
    this.rUw = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    y.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.brq().b(7, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.rUw != null) {
      this.rUw.Yw();
    }
    g.ckQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.w
 * JD-Core Version:    0.7.0.1
 */