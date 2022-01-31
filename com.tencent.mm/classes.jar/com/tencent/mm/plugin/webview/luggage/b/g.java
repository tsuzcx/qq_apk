package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.j.d;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.ui.base.l;
import java.util.Set;

public final class g
  extends a
{
  private com.tencent.mm.plugin.webview.modeltools.a reo = new com.tencent.mm.plugin.webview.modeltools.a();
  
  public g()
  {
    super(7);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame)
  {
    Object localObject = parame.caW().RR(parame.getUrl());
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.plugin.webview.modeltools.a.e((Activity)paramContext, (String)localObject);
      localObject = parame.bil.ql();
      paramContext = new g.1(this, parame, paramContext);
      ((d)localObject).bjH.add(paramContext);
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, l paraml)
  {
    paraml.a(7, paramContext.getString(R.l.wv_alert_open_in_browser), R.k.bottomsheet_icon_brower);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */