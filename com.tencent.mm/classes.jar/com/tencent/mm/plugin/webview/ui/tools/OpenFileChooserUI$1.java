package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class OpenFileChooserUI$1
  implements u.g
{
  OpenFileChooserUI$1(OpenFileChooserUI paramOpenFileChooserUI) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(175749);
    params.c(1, this.WSM.getString(c.i.webview_jssdk_take_photo));
    AppMethodBeat.o(175749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.1
 * JD-Core Version:    0.7.0.1
 */