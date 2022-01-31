package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ak;

public class CustomTimePicker
  extends TimePicker
{
  public int hWY;
  public int hWZ;
  public int hXa;
  public int hXb;
  public NumberPicker jsD;
  private NumberPicker jsE;
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131493844), paramAttributeSet);
    AppMethodBeat.i(112798);
    this.hWY = -1;
    this.hWZ = -1;
    this.hXa = -1;
    this.hXb = -1;
    initView();
    AppMethodBeat.o(112798);
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112799);
    this.hWY = -1;
    this.hWZ = -1;
    this.hXa = -1;
    this.hXb = -1;
    initView();
    AppMethodBeat.o(112799);
  }
  
  private NumberPicker FS(String paramString)
  {
    AppMethodBeat.i(112803);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramString = FU(paramString);
      AppMethodBeat.o(112803);
      return paramString;
    }
    paramString = FT(paramString);
    AppMethodBeat.o(112803);
    return paramString;
  }
  
  private NumberPicker FT(String paramString)
  {
    AppMethodBeat.i(112804);
    try
    {
      paramString = (NumberPicker)new ae(this, paramString).get();
      AppMethodBeat.o(112804);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(112804);
    }
    return null;
  }
  
  private NumberPicker FU(String paramString)
  {
    AppMethodBeat.i(112805);
    try
    {
      Object localObject = new ae(this, "mDelegate").get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new ae(localObject, paramString).get();
        AppMethodBeat.o(112805);
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      ak.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
      AppMethodBeat.o(112805);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        ak.printErrStackTrace("CustomTimePicker", paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      }
    }
  }
  
  private void dPn()
  {
    AppMethodBeat.i(112806);
    Drawable localDrawable = getResources().getDrawable(2130839945);
    e.a(this.jsD, localDrawable);
    e.a(this.jsE, localDrawable);
    AppMethodBeat.o(112806);
  }
  
  private void initView()
  {
    AppMethodBeat.i(112800);
    setIs24HourView(Boolean.TRUE);
    this.jsD = FS("mHourSpinner");
    this.jsE = FS("mMinuteSpinner");
    e.c(this.jsD);
    e.c(this.jsE);
    dPn();
    if (this.jsD != null) {
      this.jsD.setOnValueChangedListener(new CustomTimePicker.1(this));
    }
    if ((this.jsE != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.jsE.setOnValueChangedListener(new CustomTimePicker.2(this));
    }
    e.e(this.jsD);
    e.e(this.jsE);
    AppMethodBeat.o(112800);
  }
  
  public final void aRT()
  {
    AppMethodBeat.i(112801);
    if ((f.qL(this.hWY)) && (f.qK(this.hWZ)) && (this.jsD != null) && (this.jsE != null))
    {
      if (this.jsD.getValue() != this.hWY) {
        break label119;
      }
      this.jsE.setMinValue(this.hWZ);
    }
    while ((f.qL(this.hXa)) && (this.jsD != null) && (this.jsE != null)) {
      if (this.jsD.getValue() == this.hXa)
      {
        this.jsE.setMaxValue(this.hXb);
        AppMethodBeat.o(112801);
        return;
        label119:
        this.jsE.setMinValue(0);
      }
      else
      {
        this.jsE.setMaxValue(59);
      }
    }
    AppMethodBeat.o(112801);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(112802);
    super.onAttachedToWindow();
    e.d(this.jsD);
    e.d(this.jsE);
    AppMethodBeat.o(112802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */