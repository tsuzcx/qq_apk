package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransCheckResult;", "", "(Ljava/lang/String;I)V", "Unknown", "NeedTrans", "NoNeedTrans", "NotSure", "BadNet", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum e
{
  static
  {
    AppMethodBeat.i(294675);
    Wut = new e("Unknown", 0);
    Wuu = new e("NeedTrans", 1);
    Wuv = new e("NoNeedTrans", 2);
    Wuw = new e("NotSure", 3);
    Wux = new e("BadNet", 4);
    Wuy = new e[] { Wut, Wuu, Wuv, Wuw, Wux };
    AppMethodBeat.o(294675);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e
 * JD-Core Version:    0.7.0.1
 */