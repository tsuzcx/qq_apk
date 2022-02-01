package com.tencent.mm.plugin.sns.ad.widget.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.widget.a.e;

public final class c
{
  public final b DBG;
  final SnsInfo DqO;
  public View mContentView;
  public final Context mContext;
  public e oXS;
  
  public c(Context paramContext, SnsInfo paramSnsInfo, b paramb)
  {
    this.mContext = paramContext;
    this.DqO = paramSnsInfo;
    this.DBG = paramb;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(202492);
    try
    {
      if ((this.oXS != null) && (this.oXS.isShowing())) {
        this.oXS.bMo();
      }
      AppMethodBeat.o(202492);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202492);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.b.c
 * JD-Core Version:    0.7.0.1
 */