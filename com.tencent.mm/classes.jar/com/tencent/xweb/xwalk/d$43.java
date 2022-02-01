package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class d$43
  implements DialogInterface.OnClickListener
{
  d$43(d paramd, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154206);
    paramDialogInterface = this.KFu;
    Object localObject = this.KFX;
    String str = this.KFU;
    u.mL((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.KFf.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.KFm.setVisibility(8);
    AppMethodBeat.o(154206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.43
 * JD-Core Version:    0.7.0.1
 */