package com.tencent.mm.ui.tools;

import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends t
{
  private boolean XUe = true;
  
  public s()
  {
    super((byte)0);
  }
  
  public final void Hd(boolean paramBoolean)
  {
    this.XUe = paramBoolean;
  }
  
  public final void c(Menu paramMenu)
  {
    AppMethodBeat.i(222001);
    super.c(paramMenu);
    AppMethodBeat.o(222001);
  }
  
  public final boolean hYA()
  {
    AppMethodBeat.i(222003);
    if (this.XUe)
    {
      boolean bool = super.hYA();
      AppMethodBeat.o(222003);
      return bool;
    }
    AppMethodBeat.o(222003);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.s
 * JD-Core Version:    0.7.0.1
 */