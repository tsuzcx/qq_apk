package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class e$b
{
  e$b(e parame) {}
  
  public final View p(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(143341);
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        Class localClass = localView.getClass();
        ae.d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(localClass.getName())));
        ae.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + localClass.getSimpleName());
        if (("NumberPicker".equals(localClass.getSimpleName())) && (i == paramInt))
        {
          AppMethodBeat.o(143341);
          return localView;
        }
        if ((localView instanceof ViewGroup))
        {
          localView = p((ViewGroup)localView, paramInt);
          if (localView != null)
          {
            AppMethodBeat.o(143341);
            return localView;
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143341);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.e.b
 * JD-Core Version:    0.7.0.1
 */