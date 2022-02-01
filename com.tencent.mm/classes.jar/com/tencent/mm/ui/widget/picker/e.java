package com.tencent.mm.ui.widget.picker;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.av;

public final class e
{
  public static void a(NumberPicker paramNumberPicker, Drawable paramDrawable)
  {
    AppMethodBeat.i(159575);
    if (paramNumberPicker != null) {}
    try
    {
      new aq(paramNumberPicker, "mSelectionDivider").set(paramDrawable);
      AppMethodBeat.o(159575);
      return;
    }
    catch (Exception paramNumberPicker)
    {
      AppMethodBeat.o(159575);
    }
  }
  
  public static EditText b(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(159576);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(159576);
      return null;
    }
    try
    {
      paramNumberPicker = (EditText)new aq(paramNumberPicker, "mInputText").get();
      AppMethodBeat.o(159576);
      return paramNumberPicker;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getInputText IllegalAccessException", new Object[0]);
      AppMethodBeat.o(159576);
      return null;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      for (;;)
      {
        av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getInputText NoSuchFieldException", new Object[0]);
      }
    }
  }
  
  public static void b(NumberPicker paramNumberPicker, int paramInt)
  {
    AppMethodBeat.i(159574);
    int j = paramNumberPicker.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramNumberPicker.getChildAt(i);
      if ((localView instanceof EditText))
      {
        Paint localPaint = c(paramNumberPicker);
        if (localPaint != null) {
          localPaint.setColor(paramInt);
        }
        ((EditText)localView).setTextColor(paramInt);
        paramNumberPicker.invalidate();
      }
      i += 1;
    }
    AppMethodBeat.o(159574);
  }
  
  private static Paint c(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(159577);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(159577);
      return null;
    }
    try
    {
      paramNumberPicker = (Paint)new aq(paramNumberPicker, "mSelectorWheelPaint").get();
      AppMethodBeat.o(159577);
      return paramNumberPicker;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getSelectorWheelPaint IllegalAccessException", new Object[0]);
      AppMethodBeat.o(159577);
      return null;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      for (;;)
      {
        av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getSelectorWheelPaint NoSuchFieldException", new Object[0]);
      }
    }
  }
  
  public static void d(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(159578);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(159578);
      return;
    }
    paramNumberPicker.setDescendantFocusability(393216);
    AppMethodBeat.o(159578);
  }
  
  public static void e(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(159579);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(159579);
      return;
    }
    try
    {
      paramNumberPicker = (EditText)new aq(paramNumberPicker, "mInputText").get();
      if (paramNumberPicker != null) {
        paramNumberPicker.setFilters(new InputFilter[0]);
      }
      AppMethodBeat.o(159579);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
      AppMethodBeat.o(159579);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(159579);
    }
  }
  
  public static void f(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(159580);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(159580);
      return;
    }
    try
    {
      Runnable localRunnable = (Runnable)new aq(paramNumberPicker, "mSetSelectionCommand").get();
      if (localRunnable != null) {
        paramNumberPicker.removeCallbacks(localRunnable);
      }
      AppMethodBeat.o(159580);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
      AppMethodBeat.o(159580);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      av.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(159580);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */