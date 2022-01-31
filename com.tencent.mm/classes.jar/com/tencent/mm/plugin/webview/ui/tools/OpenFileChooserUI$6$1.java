package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class OpenFileChooserUI$6$1
  implements Runnable
{
  OpenFileChooserUI$6$1(OpenFileChooserUI.6 param6) {}
  
  public final void run()
  {
    if ((OpenFileChooserUI.b(this.rlF.rlE) == 7) && (OpenFileChooserUI.c(this.rlF.rlE) == 2))
    {
      h.a(this.rlF.rlE, this.rlF.rlE.getString(R.l.webview_jssdk_choose_video_exceed_20M), this.rlF.rlE.getString(R.l.app_tip), this.rlF.rlE.getString(R.l.app_i_known), false, new OpenFileChooserUI.6.1.1(this));
      return;
    }
    Toast.makeText(this.rlF.rlE, this.rlF.rlE.getString(R.l.video_export_file_too_big), 0).show();
    this.rlF.rlE.setResult(1);
    this.rlF.rlE.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6.1
 * JD-Core Version:    0.7.0.1
 */