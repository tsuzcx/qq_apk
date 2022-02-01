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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.as;

public class CustomTimePicker
  extends TimePicker
{
  private int mMaxTimeHour;
  private int mMaxTimeMinute;
  private int mMinTimeHour;
  private int mMinTimeMinute;
  private NumberPicker ozT;
  private NumberPicker ozU;
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727), paramAttributeSet);
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
  
  private NumberPicker agd(String paramString)
  {
    AppMethodBeat.i(159517);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = agf(paramString);
      AppMethodBeat.o(159517);
      return paramString;
    }
    paramString = age(paramString);
    AppMethodBeat.o(159517);
    return paramString;
  }
  
  private NumberPicker age(String paramString)
  {
    AppMethodBeat.i(159518);
    try
    {
      paramString = (NumberPicker)new an(this, paramString).get();
      AppMethodBeat.o(159518);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(159518);
    }
    return null;
  }
  
  private NumberPicker agf(String paramString)
  {
    AppMethodBeat.i(159519);
    try
    {
      Object localObject = new an(this, "mDelegate").get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new an(localObject, paramString).get();
        AppMethodBeat.o(159519);
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      as.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(159519);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        as.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      }
    }
  }
  
  private void hcd()
  {
    AppMethodBeat.i(159520);
    Drawable localDrawable = getResources().getDrawable(2131234426);
    f.a(this.ozT, localDrawable);
    f.a(this.ozU, localDrawable);
    AppMethodBeat.o(159520);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159511);
    setIs24HourView(Boolean.TRUE);
    this.ozT = agd("mHourSpinner");
    this.ozU = agd("mMinuteSpinner");
    f.d(this.ozT);
    f.d(this.ozU);
    hcd();
    if (this.ozT != null) {
      this.ozT.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159508);
          CustomTimePicker.a(CustomTimePicker.this);
          AppMethodBeat.o(159508);
        }
      });
    }
    if ((this.ozU != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.ozU.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    f.f(this.ozT);
    f.f(this.ozU);
    AppMethodBeat.o(159511);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(159513);
    super.onAttachedToWindow();
    f.e(this.ozT);
    f.e(this.ozU);
    AppMethodBeat.o(159513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */