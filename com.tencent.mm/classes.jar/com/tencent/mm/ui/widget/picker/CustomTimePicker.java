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
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ap;

public class CustomTimePicker
  extends TimePicker
{
  private int mMaxTimeHour;
  private int mMaxTimeMinute;
  private int mMinTimeHour;
  private int mMinTimeMinute;
  private NumberPicker nlc;
  private NumberPicker nld;
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
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
  
  private NumberPicker Vv(String paramString)
  {
    AppMethodBeat.i(159517);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = Vx(paramString);
      AppMethodBeat.o(159517);
      return paramString;
    }
    paramString = Vw(paramString);
    AppMethodBeat.o(159517);
    return paramString;
  }
  
  private NumberPicker Vw(String paramString)
  {
    AppMethodBeat.i(159518);
    try
    {
      paramString = (NumberPicker)new ak(this, paramString).get();
      AppMethodBeat.o(159518);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(159518);
    }
    return null;
  }
  
  private NumberPicker Vx(String paramString)
  {
    AppMethodBeat.i(159519);
    try
    {
      Object localObject = new ak(this, "mDelegate").get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new ak(localObject, paramString).get();
        AppMethodBeat.o(159519);
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      ap.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(159519);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        ap.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      }
    }
  }
  
  private void fMJ()
  {
    AppMethodBeat.i(159520);
    Drawable localDrawable = getResources().getDrawable(2131233617);
    f.a(this.nlc, localDrawable);
    f.a(this.nld, localDrawable);
    AppMethodBeat.o(159520);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159511);
    setIs24HourView(Boolean.TRUE);
    this.nlc = Vv("mHourSpinner");
    this.nld = Vv("mMinuteSpinner");
    f.d(this.nlc);
    f.d(this.nld);
    fMJ();
    if (this.nlc != null) {
      this.nlc.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159508);
          CustomTimePicker.a(CustomTimePicker.this);
          AppMethodBeat.o(159508);
        }
      });
    }
    if ((this.nld != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.nld.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2) {}
      });
    }
    f.f(this.nlc);
    f.f(this.nld);
    AppMethodBeat.o(159511);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(159513);
    super.onAttachedToWindow();
    f.e(this.nlc);
    f.e(this.nld);
    AppMethodBeat.o(159513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */