package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.e;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  private boolean rBJ;
  private boolean rBK;
  private NumberPicker rBL;
  private NumberPicker rBM;
  private NumberPicker rBN;
  private Date rBO;
  private Date rBP;
  private Calendar rBQ;
  private String[] rBR;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.rBJ = true;
    this.rBK = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.rBJ = true;
    this.rBK = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void idm()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(a.e.picker_divider);
    e.a(this.rBL, localDrawable);
    e.a(this.rBM, localDrawable);
    e.a(this.rBN, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.rBR = new String[12];
    int i = 0;
    while (i < this.rBR.length)
    {
      this.rBR[i] = (i + 1);
      i += 1;
    }
    this.rBQ = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.rBL = ((YADatePicker.c)getUIDelegate()).Yst;
    this.rBM = ((YADatePicker.c)getUIDelegate()).Yss;
    this.rBN = ((YADatePicker.c)getUIDelegate()).Ysr;
    idm();
    e.d(this.rBL);
    e.d(this.rBM);
    e.d(this.rBN);
    e.b(this.rBL, getResources().getColor(a.c.normal_text_color));
    e.b(this.rBM, getResources().getColor(a.c.normal_text_color));
    e.b(this.rBN, getResources().getColor(a.c.normal_text_color));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.rBL != null)
    {
      this.rBL.setOnValueChangedListener(local1);
      this.rBL.setMinValue(1900);
    }
    if (this.rBM != null) {
      this.rBM.setOnValueChangedListener(local1);
    }
    if (this.rBN != null) {
      this.rBN.setOnValueChangedListener(local1);
    }
    cpH();
    e.f(this.rBL);
    e.f(this.rBM);
    e.f(this.rBN);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    cpH();
    AppMethodBeat.o(159500);
  }
  
  public final void cpH()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.rBL == null) || (this.rBM == null) || (this.rBN == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.rBM.setDisplayedValues(null);
    if ((this.rBL.getValue() == this.rBL.getMaxValue()) && (this.rBP != null))
    {
      this.rBM.setMaxValue(this.rBP.getMonth());
      if ((this.rBM.getValue() != this.rBM.getMaxValue()) || (this.rBP == null)) {
        break label333;
      }
      this.rBN.setMaxValue(this.rBP.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.rBL.getValue();
        int k = this.rBM.getValue();
        this.rBQ.set(i, k, 1);
        i = this.rBQ.getActualMaximum(5);
        this.rBN.setMaxValue(i);
      }
      if ((this.rBL.getValue() != this.rBL.getMinValue()) || (this.rBO == null)) {
        break label338;
      }
      this.rBM.setMinValue(this.rBO.getMonth());
      i = j;
      if (this.rBM.getValue() == this.rBM.getMinValue())
      {
        i = j;
        if (this.rBO != null) {
          this.rBN.setMinValue(this.rBO.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.rBN.setMinValue(1);
      }
      this.rBM.setDisplayedValues((String[])Arrays.copyOfRange(this.rBR, this.rBM.getMinValue(), this.rBM.getMaxValue() + 1));
      this.rBL.setWrapSelectorWheel(true);
      this.rBM.setWrapSelectorWheel(true);
      this.rBN.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.rBM.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.rBM.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.rBN != null)
    {
      i = this.rBN.getValue();
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
    if (this.rBM != null) {}
    for (int i = this.rBM.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.rBL != null)
    {
      i = this.rBL.getValue();
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
    e.e(this.rBL);
    e.e(this.rBM);
    e.e(this.rBN);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.rBP = new Date(paramLong);
    if (this.rBL != null) {
      this.rBL.setMaxValue(this.rBP.getYear() + 1900);
    }
    cpH();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.rBO = new Date(paramLong);
    if (this.rBL != null) {
      this.rBL.setMinValue(this.rBO.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */