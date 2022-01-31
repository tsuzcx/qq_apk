package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(54199);
    oVO = new e("Init", 0);
    oVP = new e("Inviting", 1);
    oVQ = new e("Creating", 2);
    oVR = new e("Starting", 3);
    oVS = new e("Talking", 4);
    oVT = new e[] { oVO, oVP, oVQ, oVR, oVS };
    AppMethodBeat.o(54199);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */