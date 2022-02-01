package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.n;

final class d$55
  implements DialogInterface.OnClickListener
{
  d$55(d paramd, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(212981);
    paramDialogInterface = this.ainW;
    Object localObject = this.aioC;
    String str = this.aioy;
    n.cB((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.ainK.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.ainP.setVisibility(8);
    AppMethodBeat.o(212981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.55
 * JD-Core Version:    0.7.0.1
 */