package com.tencent.mm.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;

final class d$b
{
  d$b(d paramd) {}
  
  public final View f(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramViewGroup.getChildAt(i);
        Object localObject2 = localObject1.getClass();
        String str = ((Class)localObject2).getName();
        y.d("MicroMsg.MMDatePickerDialog", "NAME = " + str);
        y.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + ((Class)localObject2).getSimpleName());
        if (("NumberPicker".equals(((Class)localObject2).getSimpleName())) && (i == paramInt)) {}
        do
        {
          return localObject1;
          if (!(localObject1 instanceof ViewGroup)) {
            break;
          }
          localObject2 = f((ViewGroup)localObject1, paramInt);
          localObject1 = localObject2;
        } while (localObject2 != null);
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.d.b
 * JD-Core Version:    0.7.0.1
 */