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
    AppMethodBeat.i(207269);
    paramDialogInterface = this.SGe;
    Object localObject = this.SGI;
    String str = this.SGF;
    u.cg((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.SFP.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.SFW.setVisibility(8);
    AppMethodBeat.o(207269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.47
 * JD-Core Version:    0.7.0.1
 */