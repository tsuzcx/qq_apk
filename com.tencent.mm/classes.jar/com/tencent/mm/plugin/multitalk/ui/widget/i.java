package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(114733);
    tSC = new i("Init", 0);
    tSD = new i("Inviting", 1);
    tSE = new i("Creating", 2);
    tSF = new i("Starting", 3);
    tSG = new i("Talking", 4);
    tSH = new i[] { tSC, tSD, tSE, tSF, tSG };
    AppMethodBeat.o(114733);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */