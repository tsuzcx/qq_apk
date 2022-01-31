package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;

public final class e
  extends a
{
  public e()
  {
    super(27);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame)
  {
    if ((!parame.caS()) && (!parame.bil.qj().qe())) {
      ((Activity)parame.mContext).finish();
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, l paraml)
  {
    if (parame.isFullScreen()) {
      paraml.a(27, paramContext.getString(R.l.readerapp_finish_webview), R.k.bottomsheet_icon_exit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.e
 * JD-Core Version:    0.7.0.1
 */