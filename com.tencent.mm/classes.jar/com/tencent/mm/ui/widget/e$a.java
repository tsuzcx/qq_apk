package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
{
  e$a(e parame) {}
  
  @TargetApi(11)
  public final NumberPicker x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107863);
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramViewGroup.getChildAt(i);
        if ((localObject instanceof NumberPicker))
        {
          NumberPicker localNumberPicker = (NumberPicker)localObject;
          if ((localNumberPicker.getMaxValue() >= 28) && (localNumberPicker.getMaxValue() <= 31))
          {
            AppMethodBeat.o(107863);
            return localNumberPicker;
          }
        }
        if ((localObject instanceof ViewGroup))
        {
          localObject = x((ViewGroup)localObject);
          if (localObject != null)
          {
            AppMethodBeat.o(107863);
            return localObject;
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(107863);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.e.a
 * JD-Core Version:    0.7.0.1
 */