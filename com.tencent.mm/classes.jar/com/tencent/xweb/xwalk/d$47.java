package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class d$47
  implements DialogInterface.OnClickListener
{
  d$47(d paramd, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(206537);
    paramDialogInterface = this.aaht;
    Object localObject = this.aahX;
    String str = this.aahU;
    u.cl((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.aahe.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.aahl.setVisibility(8);
    AppMethodBeat.o(206537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.47
 * JD-Core Version:    0.7.0.1
 */