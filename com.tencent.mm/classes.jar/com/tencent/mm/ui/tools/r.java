package com.tencent.mm.ui.tools;

import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends s
{
  private boolean Qwb = true;
  
  public r()
  {
    super((byte)0);
  }
  
  public final void CJ(boolean paramBoolean)
  {
    this.Qwb = paramBoolean;
  }
  
  public final void c(Menu paramMenu)
  {
    AppMethodBeat.i(205378);
    super.c(paramMenu);
    AppMethodBeat.o(205378);
  }
  
  public final boolean gXO()
  {
    AppMethodBeat.i(205379);
    if (this.Qwb)
    {
      boolean bool = super.gXO();
      AppMethodBeat.o(205379);
      return bool;
    }
    AppMethodBeat.o(205379);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */