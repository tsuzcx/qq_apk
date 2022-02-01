package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i
{
  static
  {
    AppMethodBeat.i(114733);
    wgs = new i("Init", 0);
    wgt = new i("Inviting", 1);
    wgu = new i("Creating", 2);
    wgv = new i("Starting", 3);
    wgw = new i("Talking", 4);
    wgx = new i[] { wgs, wgt, wgu, wgv, wgw };
    AppMethodBeat.o(114733);
  }
  
  private i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */