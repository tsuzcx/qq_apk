package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.view.ViewGroup;
import android.widget.NumberPicker;

final class d$a
{
  d$a(d paramd) {}
  
  @TargetApi(11)
  public final NumberPicker s(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramViewGroup.getChildAt(i);
        Object localObject1;
        if ((localObject2 instanceof NumberPicker))
        {
          localObject1 = (NumberPicker)localObject2;
          if ((((NumberPicker)localObject1).getMaxValue() < 28) || (((NumberPicker)localObject1).getMaxValue() > 31)) {}
        }
        do
        {
          return localObject1;
          if (!(localObject2 instanceof ViewGroup)) {
            break;
          }
          localObject2 = s((ViewGroup)localObject2);
          localObject1 = localObject2;
        } while (localObject2 != null);
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.d.a
 * JD-Core Version:    0.7.0.1
 */