package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.e;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  private boolean uMY;
  private boolean uMZ;
  private NumberPicker uNa;
  private NumberPicker uNb;
  private NumberPicker uNc;
  private Date uNd;
  private Date uNe;
  private Calendar uNf;
  private String[] uNg;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.uMY = true;
    this.uMZ = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.uMY = true;
    this.uMZ = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.uNg = new String[12];
    int i = 0;
    while (i < this.uNg.length)
    {
      this.uNg[i] = (i + 1);
      i += 1;
    }
    this.uNf = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.uNa = ((YADatePicker.c)getUIDelegate()).agkI;
    this.uNb = ((YADatePicker.c)getUIDelegate()).agkH;
    this.uNc = ((YADatePicker.c)getUIDelegate()).agkG;
    jIx();
    e.d(this.uNa);
    e.d(this.uNb);
    e.d(this.uNc);
    e.b(this.uNa, getResources().getColor(a.c.normal_text_color));
    e.b(this.uNb, getResources().getColor(a.c.normal_text_color));
    e.b(this.uNc, getResources().getColor(a.c.normal_text_color));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.uNa != null)
    {
      this.uNa.setOnValueChangedListener(local1);
      this.uNa.setMinValue(1900);
    }
    if (this.uNb != null) {
      this.uNb.setOnValueChangedListener(local1);
    }
    if (this.uNc != null) {
      this.uNc.setOnValueChangedListener(local1);
    }
    cSm();
    e.f(this.uNa);
    e.f(this.uNb);
    e.f(this.uNc);
    AppMethodBeat.o(159494);
  }
  
  private void jIx()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(a.e.picker_divider);
    e.a(this.uNa, localDrawable);
    e.a(this.uNb, localDrawable);
    e.a(this.uNc, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    cSm();
    AppMethodBeat.o(159500);
  }
  
  public final void cSm()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.uNa == null) || (this.uNb == null) || (this.uNc == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.uNb.setDisplayedValues(null);
    if ((this.uNa.getValue() == this.uNa.getMaxValue()) && (this.uNe != null))
    {
      this.uNb.setMaxValue(this.uNe.getMonth());
      if ((this.uNb.getValue() != this.uNb.getMaxValue()) || (this.uNe == null)) {
        break label333;
      }
      this.uNc.setMaxValue(this.uNe.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.uNa.getValue();
        int k = this.uNb.getValue();
        this.uNf.set(i, k, 1);
        i = this.uNf.getActualMaximum(5);
        this.uNc.setMaxValue(i);
      }
      if ((this.uNa.getValue() != this.uNa.getMinValue()) || (this.uNd == null)) {
        break label338;
      }
      this.uNb.setMinValue(this.uNd.getMonth());
      i = j;
      if (this.uNb.getValue() == this.uNb.getMinValue())
      {
        i = j;
        if (this.uNd != null) {
          this.uNc.setMinValue(this.uNd.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.uNc.setMinValue(1);
      }
      this.uNb.setDisplayedValues((String[])Arrays.copyOfRange(this.uNg, this.uNb.getMinValue(), this.uNb.getMaxValue() + 1));
      this.uNa.setWrapSelectorWheel(true);
      this.uNb.setWrapSelectorWheel(true);
      this.uNc.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.uNb.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.uNb.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.uNc != null)
    {
      i = this.uNc.getValue();
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
    if (this.uNb != null) {}
    for (int i = this.uNb.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.uNa != null)
    {
      i = this.uNa.getValue();
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
    e.e(this.uNa);
    e.e(this.uNb);
    e.e(this.uNc);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.uNe = new Date(paramLong);
    if (this.uNa != null) {
      this.uNa.setMaxValue(this.uNe.getYear() + 1900);
    }
    cSm();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.uNd = new Date(paramLong);
    if (this.uNa != null) {
      this.uNa.setMinValue(this.uNd.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */