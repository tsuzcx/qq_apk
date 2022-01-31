package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends b
  implements Checkable
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean isChecked()
  {
    AppMethodBeat.i(113021);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
    {
      boolean bool = ((Checkable)localView).isChecked();
      AppMethodBeat.o(113021);
      return bool;
    }
    AppMethodBeat.o(113021);
    return false;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(113022);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(113022);
  }
  
  public final void toggle()
  {
    AppMethodBeat.i(113023);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
    AppMethodBeat.o(113023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.c
 * JD-Core Version:    0.7.0.1
 */