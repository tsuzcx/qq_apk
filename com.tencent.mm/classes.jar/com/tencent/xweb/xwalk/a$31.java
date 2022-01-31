package com.tencent.xweb.xwalk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.xweb.WebView;

final class a$31
  implements DialogInterface.OnClickListener
{
  a$31(a parama, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.xlg;
    Object localObject = this.xlt;
    String str = this.xlq;
    m.gT((String)localObject, str);
    localObject = str.split("\\.");
    if (localObject.length == 2) {
      paramDialogInterface.xkX.loadUrl("file://" + localObject[0] + "/main.html");
    }
    paramDialogInterface.xld.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.31
 * JD-Core Version:    0.7.0.1
 */