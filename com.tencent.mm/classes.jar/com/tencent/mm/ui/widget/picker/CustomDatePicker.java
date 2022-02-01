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
  private boolean nkn;
  private boolean nko;
  private NumberPicker nkp;
  private NumberPicker nkq;
  private NumberPicker nkr;
  private Date nks;
  private Date nkt;
  private Calendar nku;
  private String[] nkv;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.nkn = true;
    this.nko = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.nkn = true;
    this.nko = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void fMJ()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(2131233617);
    f.a(this.nkp, localDrawable);
    f.a(this.nkq, localDrawable);
    f.a(this.nkr, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.nkv = new String[12];
    int i = 0;
    while (i < this.nkv.length)
    {
      this.nkv[i] = (i + 1);
      i += 1;
    }
    this.nku = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.nkp = ((YADatePicker.c)getUIDelegate()).LbR;
    this.nkq = ((YADatePicker.c)getUIDelegate()).LbQ;
    this.nkr = ((YADatePicker.c)getUIDelegate()).LbP;
    fMJ();
    f.d(this.nkp);
    f.d(this.nkq);
    f.d(this.nkr);
    f.b(this.nkp, getResources().getColor(2131100711));
    f.b(this.nkq, getResources().getColor(2131100711));
    f.b(this.nkr, getResources().getColor(2131100711));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.nkp != null)
    {
      this.nkp.setOnValueChangedListener(local1);
      this.nkp.setMinValue(1900);
    }
    if (this.nkq != null) {
      this.nkq.setOnValueChangedListener(local1);
    }
    if (this.nkr != null) {
      this.nkr.setOnValueChangedListener(local1);
    }
    bFi();
    f.f(this.nkp);
    f.f(this.nkq);
    f.f(this.nkr);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bFi();
    AppMethodBeat.o(159500);
  }
  
  public final void bFi()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.nkp == null) || (this.nkq == null) || (this.nkr == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.nkq.setDisplayedValues(null);
    if ((this.nkp.getValue() == this.nkp.getMaxValue()) && (this.nkt != null))
    {
      this.nkq.setMaxValue(this.nkt.getMonth());
      if ((this.nkq.getValue() != this.nkq.getMaxValue()) || (this.nkt == null)) {
        break label333;
      }
      this.nkr.setMaxValue(this.nkt.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.nkp.getValue();
        int k = this.nkq.getValue();
        this.nku.set(i, k, 1);
        i = this.nku.getActualMaximum(5);
        this.nkr.setMaxValue(i);
      }
      if ((this.nkp.getValue() != this.nkp.getMinValue()) || (this.nks == null)) {
        break label338;
      }
      this.nkq.setMinValue(this.nks.getMonth());
      i = j;
      if (this.nkq.getValue() == this.nkq.getMinValue())
      {
        i = j;
        if (this.nks != null) {
          this.nkr.setMinValue(this.nks.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.nkr.setMinValue(1);
      }
      this.nkq.setDisplayedValues((String[])Arrays.copyOfRange(this.nkv, this.nkq.getMinValue(), this.nkq.getMaxValue() + 1));
      this.nkp.setWrapSelectorWheel(true);
      this.nkq.setWrapSelectorWheel(true);
      this.nkr.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.nkq.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.nkq.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.nkr != null)
    {
      i = this.nkr.getValue();
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
    if (this.nkq != null) {}
    for (int i = this.nkq.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.nkp != null)
    {
      i = this.nkp.getValue();
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
    f.e(this.nkp);
    f.e(this.nkq);
    f.e(this.nkr);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.nkt = new Date(paramLong);
    if (this.nkp != null) {
      this.nkp.setMaxValue(this.nkt.getYear() + 1900);
    }
    bFi();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.nks = new Date(paramLong);
    if (this.nkp != null) {
      this.nkp.setMinValue(this.nks.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */