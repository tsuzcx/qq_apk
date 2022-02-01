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
    AppMethodBeat.i(159751);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable))
    {
      boolean bool = ((Checkable)localView).isChecked();
      AppMethodBeat.o(159751);
      return bool;
    }
    AppMethodBeat.o(159751);
    return false;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(159752);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(159752);
  }
  
  public final void toggle()
  {
    AppMethodBeat.i(159753);
    View localView = getChildAt(0);
    if ((localView instanceof Checkable)) {
      ((Checkable)localView).toggle();
    }
    AppMethodBeat.o(159753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.c
 * JD-Core Version:    0.7.0.1
 */