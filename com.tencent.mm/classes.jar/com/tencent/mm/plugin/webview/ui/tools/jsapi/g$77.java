package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class g$77
  implements DialogInterface.OnKeyListener
{
  g$77(g paramg) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.a(g.i(this.rzi), true, g.i(this.rzi).getString(R.l.webview_jssdk_video_uploading_tips), "", g.i(this.rzi).getString(R.l.webview_jssdk_upload_video_cancel), g.i(this.rzi).getString(R.l.webview_jssdk_upload_video_continue), new g.77.1(this), new g.77.2(this));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.77
 * JD-Core Version:    0.7.0.1
 */