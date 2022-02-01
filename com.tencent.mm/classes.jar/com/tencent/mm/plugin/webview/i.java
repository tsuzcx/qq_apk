package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransHelpButtonStatus;", "", "(Ljava/lang/String;I)V", "None", "Trans", "Revert", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum i
{
  static
  {
    AppMethodBeat.i(295860);
    WuK = new i("None", 0);
    WuL = new i("Trans", 1);
    WuM = new i("Revert", 2);
    WuN = new i[] { WuK, WuL, WuM };
    AppMethodBeat.o(295860);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i
 * JD-Core Version:    0.7.0.1
 */