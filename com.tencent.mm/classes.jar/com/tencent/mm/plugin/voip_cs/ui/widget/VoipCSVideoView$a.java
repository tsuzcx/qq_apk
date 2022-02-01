package com.tencent.mm.plugin.voip_cs.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VoipCSVideoView$a
{
  static
  {
    AppMethodBeat.i(125479);
    CNQ = new a("Avatar", 0);
    CNR = new a("Video", 1);
    CNS = new a("None", 2);
    CNT = new a[] { CNQ, CNR, CNS };
    AppMethodBeat.o(125479);
  }
  
  private VoipCSVideoView$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.widget.VoipCSVideoView.a
 * JD-Core Version:    0.7.0.1
 */