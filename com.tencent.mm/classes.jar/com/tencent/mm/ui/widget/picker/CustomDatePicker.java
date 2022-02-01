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
  private Date npA;
  private Date npB;
  private Calendar npC;
  private String[] npD;
  private boolean npv;
  private boolean npw;
  private NumberPicker npx;
  private NumberPicker npy;
  private NumberPicker npz;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159492);
    this.npv = true;
    this.npw = true;
    initView();
    AppMethodBeat.o(159492);
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159493);
    this.npv = true;
    this.npw = true;
    initView();
    AppMethodBeat.o(159493);
  }
  
  private void fRd()
  {
    AppMethodBeat.i(159495);
    Drawable localDrawable = getResources().getDrawable(2131233617);
    f.a(this.npx, localDrawable);
    f.a(this.npy, localDrawable);
    f.a(this.npz, localDrawable);
    AppMethodBeat.o(159495);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159494);
    this.npD = new String[12];
    int i = 0;
    while (i < this.npD.length)
    {
      this.npD[i] = (i + 1);
      i += 1;
    }
    this.npC = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.npx = ((YADatePicker.c)getUIDelegate()).Lys;
    this.npy = ((YADatePicker.c)getUIDelegate()).Lyr;
    this.npz = ((YADatePicker.c)getUIDelegate()).Lyq;
    fRd();
    f.d(this.npx);
    f.d(this.npy);
    f.d(this.npz);
    f.b(this.npx, getResources().getColor(2131100711));
    f.b(this.npy, getResources().getColor(2131100711));
    f.b(this.npz, getResources().getColor(2131100711));
    NumberPicker.OnValueChangeListener local1 = new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(159491);
        CustomDatePicker.a(CustomDatePicker.this);
        AppMethodBeat.o(159491);
      }
    };
    if (this.npx != null)
    {
      this.npx.setOnValueChangedListener(local1);
      this.npx.setMinValue(1900);
    }
    if (this.npy != null) {
      this.npy.setOnValueChangedListener(local1);
    }
    if (this.npz != null) {
      this.npz.setOnValueChangedListener(local1);
    }
    bGa();
    f.f(this.npx);
    f.f(this.npy);
    f.f(this.npz);
    AppMethodBeat.o(159494);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159500);
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    bGa();
    AppMethodBeat.o(159500);
  }
  
  public final void bGa()
  {
    int j = 0;
    AppMethodBeat.i(159496);
    if ((this.npx == null) || (this.npy == null) || (this.npz == null))
    {
      AppMethodBeat.o(159496);
      return;
    }
    this.npy.setDisplayedValues(null);
    if ((this.npx.getValue() == this.npx.getMaxValue()) && (this.npB != null))
    {
      this.npy.setMaxValue(this.npB.getMonth());
      if ((this.npy.getValue() != this.npy.getMaxValue()) || (this.npB == null)) {
        break label333;
      }
      this.npz.setMaxValue(this.npB.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.npx.getValue();
        int k = this.npy.getValue();
        this.npC.set(i, k, 1);
        i = this.npC.getActualMaximum(5);
        this.npz.setMaxValue(i);
      }
      if ((this.npx.getValue() != this.npx.getMinValue()) || (this.npA == null)) {
        break label338;
      }
      this.npy.setMinValue(this.npA.getMonth());
      i = j;
      if (this.npy.getValue() == this.npy.getMinValue())
      {
        i = j;
        if (this.npA != null) {
          this.npz.setMinValue(this.npA.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.npz.setMinValue(1);
      }
      this.npy.setDisplayedValues((String[])Arrays.copyOfRange(this.npD, this.npy.getMinValue(), this.npy.getMaxValue() + 1));
      this.npx.setWrapSelectorWheel(true);
      this.npy.setWrapSelectorWheel(true);
      this.npz.setWrapSelectorWheel(true);
      AppMethodBeat.o(159496);
      return;
      this.npy.setMaxValue(11);
      label333:
      i = 0;
      break;
      label338:
      this.npy.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159503);
    if (this.npz != null)
    {
      i = this.npz.getValue();
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
    if (this.npy != null) {}
    for (int i = this.npy.getValue() + 1;; i = super.getMonth() + 1)
    {
      i = Math.max(Math.min(i, 12), 0);
      AppMethodBeat.o(159502);
      return i;
    }
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159501);
    if (this.npx != null)
    {
      i = this.npx.getValue();
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
    f.e(this.npx);
    f.e(this.npy);
    f.e(this.npz);
    AppMethodBeat.o(159504);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159497);
    super.setMaxDate(paramLong);
    this.npB = new Date(paramLong);
    if (this.npx != null) {
      this.npx.setMaxValue(this.npB.getYear() + 1900);
    }
    bGa();
    AppMethodBeat.o(159497);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159498);
    super.setMinDate(paramLong);
    this.npA = new Date(paramLong);
    if (this.npx != null) {
      this.npx.setMinValue(this.npA.getYear() + 1900);
    }
    AppMethodBeat.o(159498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */