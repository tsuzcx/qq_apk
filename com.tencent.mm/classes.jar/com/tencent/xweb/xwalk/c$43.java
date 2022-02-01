package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class c$43
  implements DialogInterface.OnClickListener
{
  c$43(c paramc, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154206);
    paramDialogInterface = this.IST;
    Object localObject = this.ITw;
    String str = this.ITt;
    s.mk((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.ISE.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.ISL.setVisibility(8);
    AppMethodBeat.o(154206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.43
 * JD-Core Version:    0.7.0.1
 */