package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d$1
  implements DialogInterface.OnClickListener
{
  d$1(d paramd, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7406);
    paramDialogInterface = (List)this.vaN.vaL.get(this.uNP);
    if (paramDialogInterface == null)
    {
      ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
      AppMethodBeat.o(7406);
      return;
    }
    this.vaN.vaM.put(this.uNP, Boolean.FALSE);
    ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", new Object[] { Integer.valueOf(paramDialogInterface.size()) });
    Iterator localIterator = paramDialogInterface.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).cancel();
    }
    paramDialogInterface.clear();
    this.vaN.vaK.clearSslPreferences();
    new a();
    a.g((Activity)this.vaN.context, this.uNP);
    AppMethodBeat.o(7406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d.1
 * JD-Core Version:    0.7.0.1
 */