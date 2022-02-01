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
  private boolean ozc;
  private boolean ozd;
  private NumberPicker oze;
  private NumberPicker ozf;
  private NumberPicker ozg;
  private Date ozh;
  private Date ozi;
  private Calendar ozj;
  private String[] ozk;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.ozc = true;
    this.ozd = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.ozc = true;
    this.ozd = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void hcd()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(2131234426);
    f.a(this.oze, localDrawable);
    f.a(this.ozf, localDrawable);
    f.a(this.ozg, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.ozk = new String[12];
    int i = 0;
    while (i < this.ozk.length)
    {
      this.ozk[i] = (i + 1);
      i += 1;
    }
    this.ozj = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.oze = ((YADatePicker.c)getUIDelegate()).QUi;
    this.ozf = ((YADatePicker.c)getUIDelegate()).QUh;
    this.ozg = ((YADatePicker.c)getUIDelegate()).QUg;
    hcd();
    f.d(this.oze);
    f.d(this.ozf);
    f.d(this.ozg);
    f.b(this.oze, getResources().getColor(2131100904));
    f.b(this.ozf, getResources().getColor(2131100904));
    f.b(this.ozg, getResources().getColor(2131100904));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.oze != null)
    {
      this.oze.setOnValueChangedListener(local1);
      this.oze.setMinValue(1900);
    }
    if (this.ozf != null) {
      this.ozf.setOnValueChangedListener(local1);
    }
    if (this.ozg != null) {
      this.ozg.setOnValueChangedListener(local1);
    }
    ccq();
    f.f(this.oze);
    f.f(this.ozf);
    f.f(this.ozg);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    ccq();
    AppMethodBeat.o(159500);
  }
  
  public final void ccq()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.oze == null) || (this.ozf == null) || (this.ozg == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.ozf.setDisplayedValues(null);
    if ((this.oze.getValue() == this.oze.getMaxValue()) && (this.ozi != null))
    {
      this.ozf.setMaxValue(this.ozi.getMonth());
      if ((this.ozf.getValue() != this.ozf.getMaxValue()) || (this.ozi == null)) {
        break label333;
      }
      this.ozg.setMaxValue(this.ozi.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.oze.getValue();
        int k = this.ozf.getValue();
        this.ozj.set(i, k, 1);
        i = this.ozj.getActualMaximum(5);
        this.ozg.setMaxValue(i);
      }
      if ((this.oze.getValue() != this.oze.getMinValue()) || (this.ozh == null)) {
        break label338;
      }
      this.ozf.setMinValue(this.ozh.getMonth());
      i = j;
      if (this.ozf.getValue() == this.ozf.getMinValue())
      {
        i = j;
        if (this.ozh != null) {
          this.ozg.setMinValue(this.ozh.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.ozg.setMinValue(1);
      }
      this.ozf.setDisplayedValues((String[])Arrays.copyOfRange(this.ozk, this.ozf.getMinValue(), this.ozf.getMaxValue() + 1));
      this.oze.setWrapSelectorWheel(true);
      this.ozf.setWrapSelectorWheel(true);
      this.ozg.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.ozf.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.ozf.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.ozg != null)
    {
      i = this.ozg.getValue();
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
    if (this.ozf != null) {}
    for (int i = this.ozf.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.oze != null)
    {
      i = this.oze.getValue();
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
    f.e(this.oze);
    f.e(this.ozf);
    f.e(this.ozg);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.ozi = new Date(paramLong);
    if (this.oze != null) {
      this.oze.setMaxValue(this.ozi.getYear() + 1900);
    }
    ccq();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.ozh = new Date(paramLong);
    if (this.oze != null) {
      this.oze.setMinValue(this.ozh.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */