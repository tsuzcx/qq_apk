package com.tencent.mm.ui.tools;

import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends s
{
  public boolean afKs = true;
  
  public r()
  {
    super(true);
  }
  
  public final void c(Menu paramMenu)
  {
    AppMethodBeat.i(251063);
    super.c(paramMenu);
    AppMethodBeat.o(251063);
  }
  
  public final boolean jDj()
  {
    AppMethodBeat.i(251066);
    if (this.afKs)
    {
      boolean bool = super.jDj();
      AppMethodBeat.o(251066);
      return bool;
    }
    AppMethodBeat.o(251066);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.r
 * JD-Core Version:    0.7.0.1
 */