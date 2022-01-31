package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a$a
{
  private int code;
  
  static
  {
    AppMethodBeat.i(8856);
    vom = new a("RET_OK", 0, 0);
    von = new a("RET_FAIL", 1, -1);
    voo = new a("RET_REJECT", 2, -2);
    vop = new a("RET_ACCESS_DENIED", 3, -3);
    voq = new a[] { vom, von, voo, vop };
    AppMethodBeat.o(8856);
  }
  
  private c$a$a(int paramInt)
  {
    this.code = paramInt;
  }
  
  public final int getCode()
  {
    return this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a
 * JD-Core Version:    0.7.0.1
 */