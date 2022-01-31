package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ci.a.k;
import com.tencent.mm.ui.ao;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public final class YADatePicker$c
  extends YADatePicker.a
{
  Calendar hzR;
  private String[] hzS;
  public final NumberPicker woT;
  public final NumberPicker woU;
  public final NumberPicker woV;
  private final LinearLayout woW;
  private final EditText woX;
  private final EditText woY;
  private final EditText woZ;
  private final CalendarView wpa;
  private final java.text.DateFormat wpb = new SimpleDateFormat("MM/dd/yyyy");
  private int wpc;
  private Calendar wpd;
  private Calendar wpe;
  Calendar wpf;
  private boolean wpg = true;
  
  YADatePicker$c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramYADatePicker, paramContext);
    this.woP = paramYADatePicker;
    this.mContext = paramContext;
    e(Locale.getDefault());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.DatePicker, paramInt, 0);
    boolean bool1 = localTypedArray.getBoolean(a.k.DatePicker_spinnersShown, true);
    boolean bool2 = localTypedArray.getBoolean(a.k.DatePicker_calendarViewShown, true);
    paramInt = localTypedArray.getInt(a.k.DatePicker_startYear, 1900);
    int i = localTypedArray.getInt(a.k.DatePicker_endYear, 2100);
    paramYADatePicker = localTypedArray.getString(a.k.DatePicker_minDate);
    paramAttributeSet = localTypedArray.getString(a.k.DatePicker_maxDate);
    int j = localTypedArray.getResourceId(a.k.DatePicker_legacyLayout, a.g.date_picker_legacy);
    localTypedArray.recycle();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.woP, true);
    paramContext = new YADatePicker.c.1(this);
    this.woW = ((LinearLayout)this.woP.findViewById(a.f.pickers));
    this.wpa = ((CalendarView)this.woP.findViewById(a.f.calendar_view));
    this.wpa.setOnDateChangeListener(new YADatePicker.c.2(this));
    this.woT = ((NumberPicker)this.woP.findViewById(a.f.day));
    this.woT.setFormatter(new g());
    this.woT.setOnLongPressUpdateInterval(100L);
    this.woT.setOnValueChangedListener(paramContext);
    this.woX = e.b(this.woT);
    this.woU = ((NumberPicker)this.woP.findViewById(a.f.month));
    this.woU.setMinValue(0);
    this.woU.setMaxValue(this.wpc - 1);
    this.woU.setDisplayedValues(this.hzS);
    this.woU.setOnLongPressUpdateInterval(200L);
    this.woU.setOnValueChangedListener(paramContext);
    this.woY = e.b(this.woU);
    this.woV = ((NumberPicker)this.woP.findViewById(a.f.year));
    this.woV.setOnLongPressUpdateInterval(100L);
    this.woV.setOnValueChangedListener(paramContext);
    this.woZ = e.b(this.woV);
    if ((!bool1) && (!bool2)) {
      setSpinnersShown(true);
    }
    for (;;)
    {
      this.hzR.clear();
      if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.hzR))) {
        this.hzR.set(paramInt, 0, 1);
      }
      setMinDate(this.hzR.getTimeInMillis());
      this.hzR.clear();
      if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.hzR))) {
        this.hzR.set(i, 11, 31);
      }
      setMaxDate(this.hzR.getTimeInMillis());
      this.wpf.setTimeInMillis(System.currentTimeMillis());
      a(this.wpf.get(1), this.wpf.get(2), this.wpf.get(5), null);
      cKq();
      if (this.woP.getImportantForAccessibility() == 0) {
        this.woP.setImportantForAccessibility(1);
      }
      return;
      setSpinnersShown(bool1);
      setCalendarViewShown(bool2);
    }
  }
  
  private static Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    if (paramCalendar == null) {
      return Calendar.getInstance(paramLocale);
    }
    long l = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l);
    return paramCalendar;
  }
  
  private static void a(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1 - 1) {}
    for (paramInt1 = 5;; paramInt1 = 6)
    {
      paramNumberPicker = e.b(paramNumberPicker);
      if (paramNumberPicker != null) {
        paramNumberPicker.setImeOptions(paramInt1);
      }
      return;
    }
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.wpb.parse(paramString));
      return true;
    }
    catch (ParseException paramCalendar)
    {
      YADatePicker.sz();
      ao.u("Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
    }
    return false;
  }
  
  private boolean cKp()
  {
    return Character.isDigit(this.hzS[0].charAt(0));
  }
  
  private void cKq()
  {
    this.woW.removeAllViews();
    char[] arrayOfChar;
    if ((Build.VERSION.SDK_INT < 17) || (this.woP.getLayoutDirection() == 0))
    {
      arrayOfChar = new char[3];
      char[] tmp30_29 = arrayOfChar;
      tmp30_29[0] = 121;
      char[] tmp36_30 = tmp30_29;
      tmp36_30[1] = 77;
      char[] tmp42_36 = tmp36_30;
      tmp42_36[2] = 100;
      tmp42_36;
    }
    int j;
    int i;
    for (;;)
    {
      j = arrayOfChar.length;
      i = 0;
      if (i >= j) {
        break;
      }
      switch (arrayOfChar[i])
      {
      default: 
        throw new IllegalArgumentException(Arrays.toString(arrayOfChar));
        arrayOfChar = android.text.format.DateFormat.getDateFormatOrder(this.woP.getContext());
      }
    }
    this.woW.addView(this.woT);
    a(this.woT, j, i);
    for (;;)
    {
      i += 1;
      break;
      this.woW.addView(this.woU);
      a(this.woU, j, i);
      continue;
      this.woW.addView(this.woV);
      a(this.woV, j, i);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    ar(paramInt1, paramInt2, paramInt3);
    cKr();
    cKs();
    this.woR = paramd;
  }
  
  final void ar(int paramInt1, int paramInt2, int paramInt3)
  {
    this.wpf.set(paramInt1, paramInt2, paramInt3);
    if (this.wpf.before(this.wpd)) {
      this.wpf.setTimeInMillis(this.wpd.getTimeInMillis());
    }
    while (!this.wpf.after(this.wpe)) {
      return;
    }
    this.wpf.setTimeInMillis(this.wpe.getTimeInMillis());
  }
  
  public final Parcelable c(Parcelable paramParcelable)
  {
    return new YADatePicker.SavedState(paramParcelable, getYear(), getMonth(), getDayOfMonth(), (byte)0);
  }
  
  public final Calendar cKn()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.wpa.getMinDate());
    return localCalendar;
  }
  
  public final Calendar cKo()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.wpa.getMaxDate());
    return localCalendar;
  }
  
  final void cKr()
  {
    if (this.wpf.equals(this.wpd))
    {
      this.woT.setMinValue(this.wpf.get(5));
      this.woT.setMaxValue(this.wpf.getActualMaximum(5));
      this.woT.setWrapSelectorWheel(false);
      this.woU.setDisplayedValues(null);
      this.woU.setMinValue(this.wpf.get(2));
      this.woU.setMaxValue(this.wpf.getActualMaximum(2));
      this.woU.setWrapSelectorWheel(false);
    }
    for (;;)
    {
      String[] arrayOfString = (String[])Arrays.copyOfRange(this.hzS, this.woU.getMinValue(), this.woU.getMaxValue() + 1);
      this.woU.setDisplayedValues(arrayOfString);
      this.woV.setMinValue(this.wpd.get(1));
      this.woV.setMaxValue(this.wpe.get(1));
      this.woV.setWrapSelectorWheel(false);
      this.woV.setValue(this.wpf.get(1));
      this.woU.setValue(this.wpf.get(2));
      this.woT.setValue(this.wpf.get(5));
      if (cKp()) {
        this.woY.setRawInputType(2);
      }
      return;
      if (this.wpf.equals(this.wpe))
      {
        this.woT.setMinValue(this.wpf.getActualMinimum(5));
        this.woT.setMaxValue(this.wpf.get(5));
        this.woT.setWrapSelectorWheel(false);
        this.woU.setDisplayedValues(null);
        this.woU.setMinValue(this.wpf.getActualMinimum(2));
        this.woU.setMaxValue(this.wpf.get(2));
        this.woU.setWrapSelectorWheel(false);
      }
      else
      {
        this.woT.setMinValue(1);
        this.woT.setMaxValue(this.wpf.getActualMaximum(5));
        this.woT.setWrapSelectorWheel(true);
        this.woU.setDisplayedValues(null);
        this.woU.setMinValue(0);
        this.woU.setMaxValue(11);
        this.woU.setWrapSelectorWheel(true);
      }
    }
  }
  
  final void cKs()
  {
    this.wpa.setDate(this.wpf.getTimeInMillis(), false, false);
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected final void e(Locale paramLocale)
  {
    super.e(paramLocale);
    this.hzR = a(this.hzR, paramLocale);
    this.wpd = a(this.wpd, paramLocale);
    this.wpe = a(this.wpe, paramLocale);
    this.wpf = a(this.wpf, paramLocale);
    this.wpc = (this.hzR.getActualMaximum(2) + 1);
    this.hzS = new DateFormatSymbols().getShortMonths();
    if (cKp())
    {
      this.hzS = new String[this.wpc];
      int i = 0;
      while (i < this.wpc)
      {
        this.hzS[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
        i += 1;
      }
    }
  }
  
  public final CalendarView getCalendarView()
  {
    return this.wpa;
  }
  
  public final boolean getCalendarViewShown()
  {
    return this.wpa.getVisibility() == 0;
  }
  
  public final int getDayOfMonth()
  {
    return this.wpf.get(5);
  }
  
  public final int getFirstDayOfWeek()
  {
    return this.wpa.getFirstDayOfWeek();
  }
  
  public final int getMonth()
  {
    return this.wpf.get(2);
  }
  
  public final boolean getSpinnersShown()
  {
    return this.woW.isShown();
  }
  
  public final int getYear()
  {
    return this.wpf.get(1);
  }
  
  public final boolean isEnabled()
  {
    return this.wpg;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    e(paramConfiguration.locale);
  }
  
  public final void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    String str = DateUtils.formatDateTime(this.mContext, this.wpf.getTimeInMillis(), 20);
    paramAccessibilityEvent.getText().add(str);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (YADatePicker.SavedState)paramParcelable;
    ar(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
    cKr();
    cKs();
  }
  
  public final void setCalendarViewShown(boolean paramBoolean)
  {
    CalendarView localCalendarView = this.wpa;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localCalendarView.setVisibility(i);
      return;
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.woT.setEnabled(paramBoolean);
    this.woU.setEnabled(paramBoolean);
    this.woV.setEnabled(paramBoolean);
    this.wpa.setEnabled(paramBoolean);
    this.wpg = paramBoolean;
  }
  
  public final void setFirstDayOfWeek(int paramInt)
  {
    this.wpa.setFirstDayOfWeek(paramInt);
  }
  
  public final void setMaxDate(long paramLong)
  {
    this.hzR.setTimeInMillis(paramLong);
    if ((this.hzR.get(1) == this.wpe.get(1)) && (this.hzR.get(6) != this.wpe.get(6))) {
      return;
    }
    this.wpe.setTimeInMillis(paramLong);
    this.wpa.setMaxDate(paramLong);
    if (this.wpf.after(this.wpe))
    {
      this.wpf.setTimeInMillis(this.wpe.getTimeInMillis());
      cKs();
    }
    cKr();
  }
  
  public final void setMinDate(long paramLong)
  {
    this.hzR.setTimeInMillis(paramLong);
    if ((this.hzR.get(1) == this.wpd.get(1)) && (this.hzR.get(6) != this.wpd.get(6))) {
      return;
    }
    this.wpd.setTimeInMillis(paramLong);
    this.wpa.setMinDate(paramLong);
    if (this.wpf.before(this.wpd))
    {
      this.wpf.setTimeInMillis(this.wpd.getTimeInMillis());
      cKs();
    }
    cKr();
  }
  
  public final void setSpinnersShown(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.woW;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.c
 * JD-Core Version:    0.7.0.1
 */