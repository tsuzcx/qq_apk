package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.bc;

public class CustomTimePicker
  extends TimePicker
{
  private int mMaxTimeHour;
  private int mMaxTimeMinute;
  private int mMinTimeHour;
  private int mMinTimeMinute;
  private NumberPicker uNT;
  private NumberPicker uNU;
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(159509);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    initView();
    AppMethodBeat.o(159509);
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159510);
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    initView();
    AppMethodBeat.o(159510);
  }
  
  private NumberPicker ahe(String paramString)
  {
    AppMethodBeat.i(159517);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = ahg(paramString);
      AppMethodBeat.o(159517);
      return paramString;
    }
    paramString = ahf(paramString);
    AppMethodBeat.o(159517);
    return paramString;
  }
  
  private NumberPicker ahf(String paramString)
  {
    AppMethodBeat.i(159518);
    try
    {
      paramString = (NumberPicker)new av(this, paramString).get();
      AppMethodBeat.o(159518);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(159518);
    }
    return null;
  }
  
  private NumberPicker ahg(String paramString)
  {
    AppMethodBeat.i(159519);
    try
    {
      Object localObject = new av(this, "mDelegate").get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new av(localObject, paramString).get();
        AppMethodBeat.o(159519);
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      bc.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(159519);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        bc.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      }
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(159511);
    setIs24HourView(Boolean.TRUE);
    this.uNT = ahe("mHourSpinner");
    this.uNU = ahe("mMinuteSpinner");
    e.d(this.uNT);
    e.d(this.uNU);
    jIx();
    if (this.uNT != null) {
      this.uNT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159508);
          CustomTimePicker.a(CustomTimePicker.this);
          AppMethodBeat.o(159508);
        }
      });
    }
    if ((this.uNU != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.uNU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    e.f(this.uNT);
    e.f(this.uNU);
    AppMethodBeat.o(159511);
  }
  
  private void jIx()
  {
    AppMethodBeat.i(159520);
    Drawable localDrawable = getResources().getDrawable(a.e.picker_divider);
    e.a(this.uNT, localDrawable);
    e.a(this.uNU, localDrawable);
    AppMethodBeat.o(159520);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(159513);
    super.onAttachedToWindow();
    e.e(this.uNT);
    e.e(this.uNU);
    AppMethodBeat.o(159513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */