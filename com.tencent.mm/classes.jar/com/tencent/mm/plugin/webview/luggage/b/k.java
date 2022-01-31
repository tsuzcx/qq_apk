package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import com.tencent.luggage.e.n;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class k
  extends a
{
  public k()
  {
    super(2);
  }
  
  public final void a(Context paramContext, e parame)
  {
    parame.caX().RS("shareTimeline");
    parame.biT.a(new com.tencent.luggage.e.c()
    {
      public final String name()
      {
        return "menu:share:timeline";
      }
      
      public final JSONObject pV()
      {
        return null;
      }
    });
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    if (parame.BX(23)) {
      paraml.a(2, paramContext.getString(R.l.readerapp_alert_share_to_timeline), R.k.bottomsheet_icon_moment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */