package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum FtsWebVideoView$c
{
  static
  {
    AppMethodBeat.i(78075);
    PMM = new c("UNKNOWN", 0);
    PMN = new c("MOBILE_NET", 1);
    PMO = new c("NO_NET", 2);
    PMP = new c[] { PMM, PMN, PMO };
    AppMethodBeat.o(78075);
  }
  
  private FtsWebVideoView$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.c
 * JD-Core Version:    0.7.0.1
 */