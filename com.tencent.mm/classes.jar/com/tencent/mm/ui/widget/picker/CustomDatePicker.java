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
  private boolean mhQ;
  private boolean mhR;
  private NumberPicker mhS;
  private NumberPicker mhT;
  private NumberPicker mhU;
  private Date mhV;
  private Date mhW;
  private Calendar mhX;
  private String[] mhY;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.mhQ = true;
    this.mhR = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.mhQ = true;
    this.mhR = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void ffW()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(2131233617);
    f.a(this.mhS, localDrawable);
    f.a(this.mhT, localDrawable);
    f.a(this.mhU, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.mhY = new String[12];
    int i = 0;
    while (i < this.mhY.length)
    {
      this.mhY[i] = (i + 1);
      i += 1;
    }
    this.mhX = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.mhS = ((YADatePicker.c)getUIDelegate()).HJX;
    this.mhT = ((YADatePicker.c)getUIDelegate()).HJW;
    this.mhU = ((YADatePicker.c)getUIDelegate()).HJV;
    ffW();
    f.d(this.mhS);
    f.d(this.mhT);
    f.d(this.mhU);
    f.b(this.mhS, getResources().getColor(2131100711));
    f.b(this.mhT, getResources().getColor(2131100711));
    f.b(this.mhU, getResources().getColor(2131100711));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.mhS != null)
    {
      this.mhS.setOnValueChangedListener(local1);
      this.mhS.setMinValue(1900);
    }
    if (this.mhT != null) {
      this.mhT.setOnValueChangedListener(local1);
    }
    if (this.mhU != null) {
      this.mhU.setOnValueChangedListener(local1);
    }
    bui();
    f.f(this.mhS);
    f.f(this.mhT);
    f.f(this.mhU);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bui();
    AppMethodBeat.o(159500);
  }
  
  public final void bui()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.mhS == null) || (this.mhT == null) || (this.mhU == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.mhT.setDisplayedValues(null);
    if ((this.mhS.getValue() == this.mhS.getMaxValue()) && (this.mhW != null))
    {
      this.mhT.setMaxValue(this.mhW.getMonth());
      if ((this.mhT.getValue() != this.mhT.getMaxValue()) || (this.mhW == null)) {
        break label333;
      }
      this.mhU.setMaxValue(this.mhW.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.mhS.getValue();
        int k = this.mhT.getValue();
        this.mhX.set(i, k, 1);
        i = this.mhX.getActualMaximum(5);
        this.mhU.setMaxValue(i);
      }
      if ((this.mhS.getValue() != this.mhS.getMinValue()) || (this.mhV == null)) {
        break label338;
      }
      this.mhT.setMinValue(this.mhV.getMonth());
      i = j;
      if (this.mhT.getValue() == this.mhT.getMinValue())
      {
        i = j;
        if (this.mhV != null) {
          this.mhU.setMinValue(this.mhV.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.mhU.setMinValue(1);
      }
      this.mhT.setDisplayedValues((String[])Arrays.copyOfRange(this.mhY, this.mhT.getMinValue(), this.mhT.getMaxValue() + 1));
      this.mhS.setWrapSelectorWheel(true);
      this.mhT.setWrapSelectorWheel(true);
      this.mhU.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.mhT.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.mhT.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.mhU != null)
    {
      i = this.mhU.getValue();
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
    if (this.mhT != null) {}
    for (int i = this.mhT.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.mhS != null)
    {
      i = this.mhS.getValue();
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
    f.e(this.mhS);
    f.e(this.mhT);
    f.e(this.mhU);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.mhW = new Date(paramLong);
    if (this.mhS != null) {
      this.mhS.setMaxValue(this.mhW.getYear() + 1900);
    }
    bui();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.mhV = new Date(paramLong);
    if (this.mhS != null) {
      this.mhS.setMinValue(this.mhV.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */