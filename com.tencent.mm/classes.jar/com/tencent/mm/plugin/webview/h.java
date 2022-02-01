package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/WebTransHelpButtonAction;", "", "(Ljava/lang/String;I)V", "None", "SwitchToOrgImmediate", "SwitchToHelpImmediate", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum h
{
  static
  {
    AppMethodBeat.i(295533);
    WuG = new h("None", 0);
    WuH = new h("SwitchToOrgImmediate", 1);
    WuI = new h("SwitchToHelpImmediate", 2);
    WuJ = new h[] { WuG, WuH, WuI };
    AppMethodBeat.o(295533);
  }
  
  private h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h
 * JD-Core Version:    0.7.0.1
 */