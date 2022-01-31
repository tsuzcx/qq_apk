package com.tencent.mm.ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import java.lang.reflect.Field;

public final class e
{
  public static void a(NumberPicker paramNumberPicker, Drawable paramDrawable)
  {
    if (paramNumberPicker != null) {
      try
      {
        paramNumberPicker = new aj(paramNumberPicker, "mSelectionDivider");
        paramNumberPicker.prepare();
        if (paramNumberPicker.dyY == null) {
          throw new NoSuchFieldException();
        }
        paramNumberPicker.dyY.set(paramNumberPicker.obj, paramDrawable);
        return;
      }
      catch (Exception paramNumberPicker) {}
    }
  }
  
  public static EditText b(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return null;
    }
    try
    {
      paramNumberPicker = (EditText)new aj(paramNumberPicker, "mInputText").get();
      return paramNumberPicker;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ao.a(paramNumberPicker, "getInputText IllegalAccessException", new Object[0]);
      return null;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      for (;;)
      {
        ao.a(paramNumberPicker, "getInputText NoSuchFieldException", new Object[0]);
      }
    }
  }
  
  public static void c(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return;
    }
    paramNumberPicker.setDescendantFocusability(393216);
  }
  
  public static void d(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {}
    for (;;)
    {
      return;
      try
      {
        paramNumberPicker = (EditText)new aj(paramNumberPicker, "mInputText").get();
        if (paramNumberPicker != null)
        {
          paramNumberPicker.setFilters(new InputFilter[0]);
          return;
        }
      }
      catch (IllegalAccessException paramNumberPicker)
      {
        ao.a(paramNumberPicker, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
        return;
      }
      catch (NoSuchFieldException paramNumberPicker)
      {
        ao.a(paramNumberPicker, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
      }
    }
  }
  
  public static void e(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {}
    for (;;)
    {
      return;
      try
      {
        Runnable localRunnable = (Runnable)new aj(paramNumberPicker, "mSetSelectionCommand").get();
        if (localRunnable != null)
        {
          paramNumberPicker.removeCallbacks(localRunnable);
          return;
        }
      }
      catch (IllegalAccessException paramNumberPicker)
      {
        ao.a(paramNumberPicker, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
        return;
      }
      catch (NoSuchFieldException paramNumberPicker)
      {
        ao.a(paramNumberPicker, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */