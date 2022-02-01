package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class e$b
{
  e$b(e parame) {}
  
  public final View n(ViewGroup paramViewGroup, int paramInt)
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
        ad.d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(localClass.getName())));
        ad.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + localClass.getSimpleName());
        if (("NumberPicker".equals(localClass.getSimpleName())) && (i == paramInt))
        {
          AppMethodBeat.o(143341);
          return localView;
        }
        if ((localView instanceof ViewGroup))
        {
          localView = n((ViewGroup)localView, paramInt);
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