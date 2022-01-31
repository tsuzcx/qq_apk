package com.tencent.mm.ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ak;

public final class e
{
  public static void a(NumberPicker paramNumberPicker, Drawable paramDrawable)
  {
    AppMethodBeat.i(112852);
    if (paramNumberPicker != null) {}
    try
    {
      new ae(paramNumberPicker, "mSelectionDivider").set(paramDrawable);
      AppMethodBeat.o(112852);
      return;
    }
    catch (Exception paramNumberPicker)
    {
      AppMethodBeat.o(112852);
    }
  }
  
  public static EditText b(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(112853);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(112853);
      return null;
    }
    try
    {
      paramNumberPicker = (EditText)new ae(paramNumberPicker, "mInputText").get();
      AppMethodBeat.o(112853);
      return paramNumberPicker;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getInputText IllegalAccessException", new Object[0]);
      AppMethodBeat.o(112853);
      return null;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      for (;;)
      {
        ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "getInputText NoSuchFieldException", new Object[0]);
      }
    }
  }
  
  public static void c(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(112854);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(112854);
      return;
    }
    paramNumberPicker.setDescendantFocusability(393216);
    AppMethodBeat.o(112854);
  }
  
  public static void d(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(112855);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(112855);
      return;
    }
    try
    {
      paramNumberPicker = (EditText)new ae(paramNumberPicker, "mInputText").get();
      if (paramNumberPicker != null) {
        paramNumberPicker.setFilters(new InputFilter[0]);
      }
      AppMethodBeat.o(112855);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
      AppMethodBeat.o(112855);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(112855);
    }
  }
  
  public static void e(NumberPicker paramNumberPicker)
  {
    AppMethodBeat.i(112856);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(112856);
      return;
    }
    try
    {
      Runnable localRunnable = (Runnable)new ae(paramNumberPicker, "mSetSelectionCommand").get();
      if (localRunnable != null) {
        paramNumberPicker.removeCallbacks(localRunnable);
      }
      AppMethodBeat.o(112856);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
      AppMethodBeat.o(112856);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      ak.printErrStackTrace("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(112856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */