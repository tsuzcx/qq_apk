package com.tencent.mm.plugin.sns.ad.widget.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.widget.a.e;

public final class c
{
  public final b JNr;
  final SnsInfo Jws;
  public View mContentView;
  public final Context mContext;
  public e rZT;
  
  public c(Context paramContext, SnsInfo paramSnsInfo, b paramb)
  {
    this.mContext = paramContext;
    this.Jws = paramSnsInfo;
    this.JNr = paramb;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(251571);
    try
    {
      if ((this.rZT != null) && (this.rZT.isShowing())) {
        this.rZT.bYF();
      }
      AppMethodBeat.o(251571);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(251571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.b.c
 * JD-Core Version:    0.7.0.1
 */