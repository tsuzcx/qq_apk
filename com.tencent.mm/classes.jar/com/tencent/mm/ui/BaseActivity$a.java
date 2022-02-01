package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum BaseActivity$a
{
  static
  {
    AppMethodBeat.i(159094);
    ITx = new a("CUSTOM", 0);
    ITy = new a("BACK", 1);
    ITz = new a("CLOSE", 2);
    ITA = new a("NONE", 3);
    ITB = new a[] { ITx, ITy, ITz, ITA };
    AppMethodBeat.o(159094);
  }
  
  private BaseActivity$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.a
 * JD-Core Version:    0.7.0.1
 */