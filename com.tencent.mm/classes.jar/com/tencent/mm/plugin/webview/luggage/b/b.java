package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;

public final class b
  extends a
{
  public b()
  {
    super(6);
  }
  
  public final void a(Context paramContext, e parame)
  {
    parame = parame.caW().RR(parame.getUrl());
    ClipboardManager localClipboardManager = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (localClipboardManager != null) {}
    try
    {
      localClipboardManager.setText(parame);
      Toast.makeText(paramContext, paramContext.getString(R.l.wv_alert_copy_link_toast), 0).show();
      return;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", paramContext, "clip.setText error", new Object[0]);
    }
  }
  
  public final void a(Context paramContext, e parame, l paraml)
  {
    if (parame.BX(44)) {
      paraml.a(6, paramContext.getString(R.l.wv_alert_copy_link), R.k.bottomsheet_icon_copy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */