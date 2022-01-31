package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.xweb.f;

final class WebViewUI$h$6
  implements DialogInterface.OnClickListener
{
  WebViewUI$h$6(WebViewUI.h paramh, PBool paramPBool, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.rqK.value = true;
    this.rqL.confirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h.6
 * JD-Core Version:    0.7.0.1
 */