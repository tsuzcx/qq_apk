package com.tencent.mm.plugin.sns.ad.widget.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.widget.a.f;

public final class c
{
  final SnsInfo PJQ;
  public final b QhR;
  public View mContentView;
  public final Context mContext;
  public f vlk;
  
  public c(Context paramContext, SnsInfo paramSnsInfo, b paramb)
  {
    this.mContext = paramContext;
    this.PJQ = paramSnsInfo;
    this.QhR = paramb;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(310115);
    try
    {
      if ((this.vlk != null) && (this.vlk.isShowing())) {
        this.vlk.cyW();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.b.c
 * JD-Core Version:    0.7.0.1
 */