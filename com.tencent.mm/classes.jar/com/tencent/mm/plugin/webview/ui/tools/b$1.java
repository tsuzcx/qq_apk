package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (List)this.rll.rli.get(this.rlk);
    if (paramDialogInterface == null)
    {
      y.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
      return;
    }
    this.rll.rlj.put(this.rlk, Boolean.valueOf(true));
    y.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", new Object[] { Integer.valueOf(paramDialogInterface.size()) });
    Iterator localIterator = paramDialogInterface.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).proceed();
    }
    paramDialogInterface.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.b.1
 * JD-Core Version:    0.7.0.1
 */