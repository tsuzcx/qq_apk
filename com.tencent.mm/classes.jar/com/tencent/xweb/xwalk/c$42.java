package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class c$42
  implements DialogInterface.OnClickListener
{
  c$42(c paramc, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(139576);
    paramDialogInterface = this.BIO;
    Object localObject = this.BJg;
    String str = this.BJd;
    o.jf((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.BID.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.BIK.setVisibility(8);
    AppMethodBeat.o(139576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.42
 * JD-Core Version:    0.7.0.1
 */