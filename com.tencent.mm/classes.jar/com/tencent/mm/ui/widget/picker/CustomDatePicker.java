package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  private boolean mJR;
  private boolean mJS;
  private NumberPicker mJT;
  private NumberPicker mJU;
  private NumberPicker mJV;
  private Date mJW;
  private Date mJX;
  private Calendar mJY;
  private String[] mJZ;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.mJR = true;
    this.mJS = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.mJR = true;
    this.mJS = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void fvV()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(2131233617);
    f.a(this.mJT, localDrawable);
    f.a(this.mJU, localDrawable);
    f.a(this.mJV, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.mJZ = new String[12];
    int i = 0;
    while (i < this.mJZ.length)
    {
      this.mJZ[i] = (i + 1);
      i += 1;
    }
    this.mJY = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.mJT = ((YADatePicker.c)getUIDelegate()).Jku;
    this.mJU = ((YADatePicker.c)getUIDelegate()).Jkt;
    this.mJV = ((YADatePicker.c)getUIDelegate()).Jks;
    fvV();
    f.d(this.mJT);
    f.d(this.mJU);
    f.d(this.mJV);
    f.b(this.mJT, getResources().getColor(2131100711));
    f.b(this.mJU, getResources().getColor(2131100711));
    f.b(this.mJV, getResources().getColor(2131100711));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.mJT != null)
    {
      this.mJT.setOnValueChangedListener(local1);
      this.mJT.setMinValue(1900);
    }
    if (this.mJU != null) {
      this.mJU.setOnValueChangedListener(local1);
    }
    if (this.mJV != null) {
      this.mJV.setOnValueChangedListener(local1);
    }
    bBg();
    f.f(this.mJT);
    f.f(this.mJU);
    f.f(this.mJV);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bBg();
    AppMethodBeat.o(159500);
  }
  
  public final void bBg()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.mJT == null) || (this.mJU == null) || (this.mJV == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.mJU.setDisplayedValues(null);
    if ((this.mJT.getValue() == this.mJT.getMaxValue()) && (this.mJX != null))
    {
      this.mJU.setMaxValue(this.mJX.getMonth());
      if ((this.mJU.getValue() != this.mJU.getMaxValue()) || (this.mJX == null)) {
        break label333;
      }
      this.mJV.setMaxValue(this.mJX.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.mJT.getValue();
        int k = this.mJU.getValue();
        this.mJY.set(i, k, 1);
        i = this.mJY.getActualMaximum(5);
        this.mJV.setMaxValue(i);
      }
      if ((this.mJT.getValue() != this.mJT.getMinValue()) || (this.mJW == null)) {
        break label338;
      }
      this.mJU.setMinValue(this.mJW.getMonth());
      i = j;
      if (this.mJU.getValue() == this.mJU.getMinValue())
      {
        i = j;
        if (this.mJW != null) {
          this.mJV.setMinValue(this.mJW.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.mJV.setMinValue(1);
      }
      this.mJU.setDisplayedValues((String[])Arrays.copyOfRange(this.mJZ, this.mJU.getMinValue(), this.mJU.getMaxValue() + 1));
      this.mJT.setWrapSelectorWheel(true);
      this.mJU.setWrapSelectorWheel(true);
      this.mJV.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.mJU.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.mJU.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.mJV != null)
    {
      i = this.mJV.getValue();
      AppMethodBeat.o(159503);
      return i;
    }
    int i = super.getDayOfMonth();
    AppMethodBeat.o(159503);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159502);
    if (this.mJU != null) {}
    for (int i = this.mJU.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.mJT != null)
    {
      i = this.mJT.getValue();
      AppMethodBeat.o(159501);
      return i;
    }
    int i = super.getYear();
    AppMethodBeat.o(159501);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(159504);
    super.onAttachedToWindow();
    f.e(this.mJT);
    f.e(this.mJU);
    f.e(this.mJV);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.mJX = new Date(paramLong);
    if (this.mJT != null) {
      this.mJT.setMaxValue(this.mJX.getYear() + 1900);
    }
    bBg();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.mJW = new Date(paramLong);
    if (this.mJT != null) {
      this.mJT.setMinValue(this.mJW.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */