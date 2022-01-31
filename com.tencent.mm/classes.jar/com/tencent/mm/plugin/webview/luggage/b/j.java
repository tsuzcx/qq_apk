package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.ak;
import com.tencent.mm.plugin.webview.luggage.permission.c;
import com.tencent.mm.ui.base.l;

public final class j
  extends a
{
  public j()
  {
    super(1);
  }
  
  public final void a(Context paramContext, e parame)
  {
    ak.BY(0);
    parame.caX().RS("sendAppMessage");
    parame.biT.a(new j.1(this));
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    if (parame.BX(21)) {
      paraml.a(this.id, paramContext.getString(R.l.readerapp_alert_retransmit), R.k.bottomsheet_icon_transmit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */