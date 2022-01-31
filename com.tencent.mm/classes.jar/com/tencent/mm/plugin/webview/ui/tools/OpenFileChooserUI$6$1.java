package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class OpenFileChooserUI$6$1
  implements Runnable
{
  OpenFileChooserUI$6$1(OpenFileChooserUI.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(7448);
    if ((OpenFileChooserUI.b(this.vbh.vbg) == 7) && (OpenFileChooserUI.c(this.vbh.vbg) == 2))
    {
      h.a(this.vbh.vbg, this.vbh.vbg.getString(2131305868), this.vbh.vbg.getString(2131297087), this.vbh.vbg.getString(2131296977), false, new OpenFileChooserUI.6.1.1(this));
      AppMethodBeat.o(7448);
      return;
    }
    Toast.makeText(this.vbh.vbg, this.vbh.vbg.getString(2131304514), 0).show();
    this.vbh.vbg.setResult(1);
    this.vbh.vbg.finish();
    AppMethodBeat.o(7448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6.1
 * JD-Core Version:    0.7.0.1
 */