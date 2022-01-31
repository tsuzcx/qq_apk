package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$b
{
  e$b(e parame) {}
  
  public final View e(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(107864);
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        Class localClass = localView.getClass();
        ab.d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(localClass.getName())));
        ab.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + localClass.getSimpleName());
        if (("NumberPicker".equals(localClass.getSimpleName())) && (i == paramInt))
        {
          AppMethodBeat.o(107864);
          return localView;
        }
        if ((localView instanceof ViewGroup))
        {
          localView = e((ViewGroup)localView, paramInt);
          if (localView != null)
          {
            AppMethodBeat.o(107864);
            return localView;
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(107864);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.e.b
 * JD-Core Version:    0.7.0.1
 */