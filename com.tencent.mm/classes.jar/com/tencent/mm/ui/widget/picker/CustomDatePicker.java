package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  private boolean jsa;
  private boolean jsb;
  private NumberPicker jsc;
  private NumberPicker jsd;
  private NumberPicker jse;
  private Date jsf;
  private Date jsg;
  private Calendar jsh;
  private String[] jsi;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112782);
    this.jsa = true;
    this.jsb = true;
    initView();
    AppMethodBeat.o(112782);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112783);
    this.jsa = true;
    this.jsb = true;
    initView();
    AppMethodBeat.o(112783);
  }
  
  private void dPn()
  {
    AppMethodBeat.i(112785);
    Drawable localDrawable = getResources().getDrawable(2130839945);
    e.a(this.jsc, localDrawable);
    e.a(this.jsd, localDrawable);
    e.a(this.jse, localDrawable);
    AppMethodBeat.o(112785);
  }
  
  private void initView()
  {
    AppMethodBeat.i(112784);
    this.jsi = new String[12];
    int i = 0;
    while (i < this.jsi.length)
    {
      this.jsi[i] = (i + 1);
      i += 1;
    }
    this.jsh = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.jsc = ((YADatePicker.c)getUIDelegate()).AJv;
    this.jsd = ((YADatePicker.c)getUIDelegate()).AJu;
    this.jse = ((YADatePicker.c)getUIDelegate()).AJt;
    dPn();
    e.c(this.jsc);
    e.c(this.jsd);
    e.c(this.jse);
    CustomDatePicker.1 local1 = new CustomDatePicker.1(this);
    if (this.jsc != null)
    {
      this.jsc.setOnValueChangedListener(local1);
      this.jsc.setMinValue(1900);
    }
    if (this.jsd != null) {
      this.jsd.setOnValueChangedListener(local1);
    }
    if (this.jse != null) {
      this.jse.setOnValueChangedListener(local1);
    }
    aRQ();
    e.e(this.jsc);
    e.e(this.jsd);
    e.e(this.jse);
    AppMethodBeat.o(112784);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(112790);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    aRQ();
    AppMethodBeat.o(112790);
  }
  
  final void aRQ()
  {
    int j = 0;
    AppMethodBeat.i(112786);
    if ((this.jsc == null) || (this.jsd == null) || (this.jse == null))
    {
      AppMethodBeat.o(112786);
      return;
    }
    this.jsd.setDisplayedValues(null);
    if ((this.jsc.getValue() == this.jsc.getMaxValue()) && (this.jsg != null))
    {
      this.jsd.setMaxValue(this.jsg.getMonth());
      if ((this.jsd.getValue() != this.jsd.getMaxValue()) || (this.jsg == null)) {
        break label333;
      }
      this.jse.setMaxValue(this.jsg.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.jsc.getValue();
        int k = this.jsd.getValue();
        this.jsh.set(i, k, 1);
        i = this.jsh.getActualMaximum(5);
        this.jse.setMaxValue(i);
      }
      if ((this.jsc.getValue() != this.jsc.getMinValue()) || (this.jsf == null)) {
        break label338;
      }
      this.jsd.setMinValue(this.jsf.getMonth());
      i = j;
      if (this.jsd.getValue() == this.jsd.getMinValue())
      {
        i = j;
        if (this.jsf != null) {
          this.jse.setMinValue(this.jsf.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.jse.setMinValue(1);
      }
      this.jsd.setDisplayedValues((String[])Arrays.copyOfRange(this.jsi, this.jsd.getMinValue(), this.jsd.getMaxValue() + 1));
      this.jsc.setWrapSelectorWheel(true);
      this.jsd.setWrapSelectorWheel(true);
      this.jse.setWrapSelectorWheel(true);
      AppMethodBeat.o(112786);
      return;
      this.jsd.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.jsd.setMinValue(0);
    }
  }
  
  public final String aRR()
  {
    AppMethodBeat.i(139659);
    if (this.jsb)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth()) });
      AppMethodBeat.o(139659);
      return str;
    }
    if (this.jsa)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(getYear()), Integer.valueOf(getMonth()) });
      AppMethodBeat.o(139659);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(getYear()) });
    AppMethodBeat.o(139659);
    return str;
  }
  
  public final void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    AppMethodBeat.i(112795);
    this.jsa = paramBoolean1;
    this.jsb = paramBoolean2;
    if (this.jsc != null)
    {
      this.jsc.setEnabled(true);
      this.jsc.setVisibility(0);
    }
    NumberPicker localNumberPicker;
    if (this.jsd != null)
    {
      this.jsd.setEnabled(paramBoolean1);
      localNumberPicker = this.jsd;
      if (paramBoolean1)
      {
        i = 0;
        localNumberPicker.setVisibility(i);
      }
    }
    else if (this.jse != null)
    {
      this.jse.setEnabled(paramBoolean2);
      localNumberPicker = this.jse;
      if (!paramBoolean2) {
        break label120;
      }
    }
    label120:
    for (int i = j;; i = 8)
    {
      localNumberPicker.setVisibility(i);
      AppMethodBeat.o(112795);
      return;
      i = 8;
      break;
    }
  }
  
  public final void az(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112789);
    a(paramInt1, paramInt2, paramInt3, null);
    AppMethodBeat.o(112789);
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(112793);
    if (this.jse != null)
    {
      i = this.jse.getValue();
      AppMethodBeat.o(112793);
      return i;
    }
    int i = super.getDayOfMonth();
    AppMethodBeat.o(112793);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(112792);
    if (this.jsd != null) {}
    for (int i = this.jsd.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(112792);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(112791);
    if (this.jsc != null)
    {
      i = this.jsc.getValue();
      AppMethodBeat.o(112791);
      return i;
    }
    int i = super.getYear();
    AppMethodBeat.o(112791);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(112794);
    super.onAttachedToWindow();
    e.d(this.jsc);
    e.d(this.jsd);
    e.d(this.jse);
    AppMethodBeat.o(112794);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(112787);
    super.setMaxDate(paramLong);
    this.jsg = new Date(paramLong);
    if (this.jsc != null) {
      this.jsc.setMaxValue(this.jsg.getYear() + 1900);
    }
    aRQ();
    AppMethodBeat.o(112787);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(112788);
    super.setMinDate(paramLong);
    this.jsf = new Date(paramLong);
    if (this.jsc != null) {
      this.jsc.setMinValue(this.jsf.getYear() + 1900);
    }
    AppMethodBeat.o(112788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */