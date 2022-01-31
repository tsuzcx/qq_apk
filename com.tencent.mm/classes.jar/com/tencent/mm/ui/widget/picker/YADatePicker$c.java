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
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.ak;
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
  private final CalendarView AJA;
  private final java.text.DateFormat AJB;
  private int AJC;
  private Calendar AJD;
  private Calendar AJE;
  Calendar AJF;
  private boolean AJG;
  public final NumberPicker AJt;
  public final NumberPicker AJu;
  public final NumberPicker AJv;
  private final LinearLayout AJw;
  private final EditText AJx;
  private final EditText AJy;
  private final EditText AJz;
  Calendar jsh;
  private String[] jsi;
  
  YADatePicker$c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramYADatePicker, paramContext);
    AppMethodBeat.i(112872);
    this.AJB = new SimpleDateFormat("MM/dd/yyyy");
    this.AJG = true;
    this.AJp = paramYADatePicker;
    this.mContext = paramContext;
    f(Locale.getDefault());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DatePicker, paramInt, 0);
    boolean bool1 = localTypedArray.getBoolean(3, true);
    boolean bool2 = localTypedArray.getBoolean(4, true);
    paramInt = localTypedArray.getInt(13, 1900);
    int i = localTypedArray.getInt(14, 2100);
    paramYADatePicker = localTypedArray.getString(1);
    paramAttributeSet = localTypedArray.getString(2);
    int j = localTypedArray.getResourceId(6, 2130969294);
    localTypedArray.recycle();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.AJp, true);
    paramContext = new YADatePicker.c.1(this);
    this.AJw = ((LinearLayout)this.AJp.findViewById(2131823296));
    this.AJA = ((CalendarView)this.AJp.findViewById(2131823300));
    this.AJA.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
    {
      public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(112871);
        YADatePicker.c.this.aD(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        YADatePicker.c.this.dPw();
        YADatePicker.c.b(YADatePicker.c.this);
        AppMethodBeat.o(112871);
      }
    });
    this.AJt = ((NumberPicker)this.AJp.findViewById(2131823298));
    this.AJt.setFormatter(new g());
    this.AJt.setOnLongPressUpdateInterval(100L);
    this.AJt.setOnValueChangedListener(paramContext);
    this.AJx = e.b(this.AJt);
    this.AJu = ((NumberPicker)this.AJp.findViewById(2131823297));
    this.AJu.setMinValue(0);
    this.AJu.setMaxValue(this.AJC - 1);
    this.AJu.setDisplayedValues(this.jsi);
    this.AJu.setOnLongPressUpdateInterval(200L);
    this.AJu.setOnValueChangedListener(paramContext);
    this.AJy = e.b(this.AJu);
    this.AJv = ((NumberPicker)this.AJp.findViewById(2131823299));
    this.AJv.setOnLongPressUpdateInterval(100L);
    this.AJv.setOnValueChangedListener(paramContext);
    this.AJz = e.b(this.AJv);
    if ((!bool1) && (!bool2)) {
      setSpinnersShown(true);
    }
    for (;;)
    {
      this.jsh.clear();
      if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.jsh))) {
        this.jsh.set(paramInt, 0, 1);
      }
      setMinDate(this.jsh.getTimeInMillis());
      this.jsh.clear();
      if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.jsh))) {
        this.jsh.set(i, 11, 31);
      }
      setMaxDate(this.jsh.getTimeInMillis());
      this.AJF.setTimeInMillis(System.currentTimeMillis());
      a(this.AJF.get(1), this.AJF.get(2), this.AJF.get(5), null);
      dPv();
      if (this.AJp.getImportantForAccessibility() == 0) {
        this.AJp.setImportantForAccessibility(1);
      }
      AppMethodBeat.o(112872);
      return;
      setSpinnersShown(bool1);
      setCalendarViewShown(bool2);
    }
  }
  
  private static Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    AppMethodBeat.i(112895);
    if (paramCalendar == null)
    {
      paramCalendar = Calendar.getInstance(paramLocale);
      AppMethodBeat.o(112895);
      return paramCalendar;
    }
    long l = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l);
    AppMethodBeat.o(112895);
    return paramCalendar;
  }
  
  private static void a(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112901);
    if (paramInt2 < paramInt1 - 1) {}
    for (paramInt1 = 5;; paramInt1 = 6)
    {
      paramNumberPicker = e.b(paramNumberPicker);
      if (paramNumberPicker != null) {
        paramNumberPicker.setImeOptions(paramInt1);
      }
      AppMethodBeat.o(112901);
      return;
    }
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    AppMethodBeat.i(112897);
    try
    {
      paramCalendar.setTime(this.AJB.parse(paramString));
      AppMethodBeat.o(112897);
      return true;
    }
    catch (ParseException paramCalendar)
    {
      ak.w(YADatePicker.access$1100(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
      AppMethodBeat.o(112897);
    }
    return false;
  }
  
  private boolean dPu()
  {
    AppMethodBeat.i(112894);
    boolean bool = Character.isDigit(this.jsi[0].charAt(0));
    AppMethodBeat.o(112894);
    return bool;
  }
  
  private void dPv()
  {
    AppMethodBeat.i(112896);
    this.AJw.removeAllViews();
    Object localObject;
    if ((Build.VERSION.SDK_INT < 17) || (this.AJp.getLayoutDirection() == 0))
    {
      localObject = new char[3];
      Object tmp36_35 = localObject;
      tmp36_35[0] = 121;
      Object tmp42_36 = tmp36_35;
      tmp42_36[1] = 77;
      Object tmp48_42 = tmp42_36;
      tmp48_42[2] = 100;
      tmp48_42;
    }
    int j;
    int i;
    for (;;)
    {
      j = localObject.length;
      i = 0;
      if (i >= j) {
        break;
      }
      switch (localObject[i])
      {
      default: 
        localObject = new IllegalArgumentException(Arrays.toString((char[])localObject));
        AppMethodBeat.o(112896);
        throw ((Throwable)localObject);
        localObject = android.text.format.DateFormat.getDateFormatOrder(this.AJp.getContext());
      }
    }
    this.AJw.addView(this.AJt);
    a(this.AJt, j, i);
    for (;;)
    {
      i += 1;
      break;
      this.AJw.addView(this.AJu);
      a(this.AJu, j, i);
      continue;
      this.AJw.addView(this.AJv);
      a(this.AJv, j, i);
    }
    AppMethodBeat.o(112896);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(112873);
    aD(paramInt1, paramInt2, paramInt3);
    dPw();
    dPx();
    this.AJr = paramd;
    AppMethodBeat.o(112873);
  }
  
  final void aD(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112898);
    this.AJF.set(paramInt1, paramInt2, paramInt3);
    if (this.AJF.before(this.AJD))
    {
      this.AJF.setTimeInMillis(this.AJD.getTimeInMillis());
      AppMethodBeat.o(112898);
      return;
    }
    if (this.AJF.after(this.AJE)) {
      this.AJF.setTimeInMillis(this.AJE.getTimeInMillis());
    }
    AppMethodBeat.o(112898);
  }
  
  public final Calendar dPs()
  {
    AppMethodBeat.i(112879);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.AJA.getMinDate());
    AppMethodBeat.o(112879);
    return localCalendar;
  }
  
  public final Calendar dPt()
  {
    AppMethodBeat.i(112881);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.AJA.getMaxDate());
    AppMethodBeat.o(112881);
    return localCalendar;
  }
  
  final void dPw()
  {
    AppMethodBeat.i(112899);
    if (this.AJF.equals(this.AJD))
    {
      this.AJt.setMinValue(this.AJF.get(5));
      this.AJt.setMaxValue(this.AJF.getActualMaximum(5));
      this.AJt.setWrapSelectorWheel(false);
      this.AJu.setDisplayedValues(null);
      this.AJu.setMinValue(this.AJF.get(2));
      this.AJu.setMaxValue(this.AJF.getActualMaximum(2));
      this.AJu.setWrapSelectorWheel(false);
    }
    for (;;)
    {
      String[] arrayOfString = (String[])Arrays.copyOfRange(this.jsi, this.AJu.getMinValue(), this.AJu.getMaxValue() + 1);
      this.AJu.setDisplayedValues(arrayOfString);
      this.AJv.setMinValue(this.AJD.get(1));
      this.AJv.setMaxValue(this.AJE.get(1));
      this.AJv.setWrapSelectorWheel(false);
      this.AJv.setValue(this.AJF.get(1));
      this.AJu.setValue(this.AJF.get(2));
      this.AJt.setValue(this.AJF.get(5));
      if (dPu()) {
        this.AJy.setRawInputType(2);
      }
      AppMethodBeat.o(112899);
      return;
      if (this.AJF.equals(this.AJE))
      {
        this.AJt.setMinValue(this.AJF.getActualMinimum(5));
        this.AJt.setMaxValue(this.AJF.get(5));
        this.AJt.setWrapSelectorWheel(false);
        this.AJu.setDisplayedValues(null);
        this.AJu.setMinValue(this.AJF.getActualMinimum(2));
        this.AJu.setMaxValue(this.AJF.get(2));
        this.AJu.setWrapSelectorWheel(false);
      }
      else
      {
        this.AJt.setMinValue(1);
        this.AJt.setMaxValue(this.AJF.getActualMaximum(5));
        this.AJt.setWrapSelectorWheel(true);
        this.AJu.setDisplayedValues(null);
        this.AJu.setMinValue(0);
        this.AJu.setMaxValue(11);
        this.AJu.setWrapSelectorWheel(true);
      }
    }
  }
  
  final void dPx()
  {
    AppMethodBeat.i(112900);
    this.AJA.setDate(this.AJF.getTimeInMillis(), false, false);
    AppMethodBeat.o(112900);
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(112891);
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(112891);
    return true;
  }
  
  public final Parcelable e(Parcelable paramParcelable)
  {
    AppMethodBeat.i(112889);
    paramParcelable = new YADatePicker.SavedState(paramParcelable, getYear(), getMonth(), getDayOfMonth(), (byte)0);
    AppMethodBeat.o(112889);
    return paramParcelable;
  }
  
  protected final void f(Locale paramLocale)
  {
    AppMethodBeat.i(112893);
    super.f(paramLocale);
    this.jsh = a(this.jsh, paramLocale);
    this.AJD = a(this.AJD, paramLocale);
    this.AJE = a(this.AJE, paramLocale);
    this.AJF = a(this.AJF, paramLocale);
    this.AJC = (this.jsh.getActualMaximum(2) + 1);
    this.jsi = new DateFormatSymbols().getShortMonths();
    if (dPu())
    {
      this.jsi = new String[this.AJC];
      int i = 0;
      while (i < this.AJC)
      {
        this.jsi[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
        i += 1;
      }
    }
    AppMethodBeat.o(112893);
  }
  
  public final CalendarView getCalendarView()
  {
    return this.AJA;
  }
  
  public final boolean getCalendarViewShown()
  {
    AppMethodBeat.i(112884);
    if (this.AJA.getVisibility() == 0)
    {
      AppMethodBeat.o(112884);
      return true;
    }
    AppMethodBeat.o(112884);
    return false;
  }
  
  public final int getDayOfMonth()
  {
    AppMethodBeat.i(112876);
    int i = this.AJF.get(5);
    AppMethodBeat.o(112876);
    return i;
  }
  
  public final int getFirstDayOfWeek()
  {
    AppMethodBeat.i(112877);
    int i = this.AJA.getFirstDayOfWeek();
    AppMethodBeat.o(112877);
    return i;
  }
  
  public final int getMonth()
  {
    AppMethodBeat.i(112875);
    int i = this.AJF.get(2);
    AppMethodBeat.o(112875);
    return i;
  }
  
  public final boolean getSpinnersShown()
  {
    AppMethodBeat.i(112886);
    boolean bool = this.AJw.isShown();
    AppMethodBeat.o(112886);
    return bool;
  }
  
  public final int getYear()
  {
    AppMethodBeat.i(112874);
    int i = this.AJF.get(1);
    AppMethodBeat.o(112874);
    return i;
  }
  
  public final boolean isEnabled()
  {
    return this.AJG;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(112888);
    f(paramConfiguration.locale);
    AppMethodBeat.o(112888);
  }
  
  public final void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(112892);
    String str = DateUtils.formatDateTime(this.mContext, this.AJF.getTimeInMillis(), 20);
    paramAccessibilityEvent.getText().add(str);
    AppMethodBeat.o(112892);
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(112890);
    paramParcelable = (YADatePicker.SavedState)paramParcelable;
    aD(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
    dPw();
    dPx();
    AppMethodBeat.o(112890);
  }
  
  public final void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(112885);
    CalendarView localCalendarView = this.AJA;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localCalendarView.setVisibility(i);
      AppMethodBeat.o(112885);
      return;
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(112883);
    this.AJt.setEnabled(paramBoolean);
    this.AJu.setEnabled(paramBoolean);
    this.AJv.setEnabled(paramBoolean);
    this.AJA.setEnabled(paramBoolean);
    this.AJG = paramBoolean;
    AppMethodBeat.o(112883);
  }
  
  public final void setFirstDayOfWeek(int paramInt)
  {
    AppMethodBeat.i(112878);
    this.AJA.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(112878);
  }
  
  public final void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(112882);
    this.jsh.setTimeInMillis(paramLong);
    if ((this.jsh.get(1) == this.AJE.get(1)) && (this.jsh.get(6) != this.AJE.get(6)))
    {
      AppMethodBeat.o(112882);
      return;
    }
    this.AJE.setTimeInMillis(paramLong);
    this.AJA.setMaxDate(paramLong);
    if (this.AJF.after(this.AJE))
    {
      this.AJF.setTimeInMillis(this.AJE.getTimeInMillis());
      dPx();
    }
    dPw();
    AppMethodBeat.o(112882);
  }
  
  public final void setMinDate(long paramLong)
  {
    AppMethodBeat.i(112880);
    this.jsh.setTimeInMillis(paramLong);
    if ((this.jsh.get(1) == this.AJD.get(1)) && (this.jsh.get(6) != this.AJD.get(6)))
    {
      AppMethodBeat.o(112880);
      return;
    }
    this.AJD.setTimeInMillis(paramLong);
    this.AJA.setMinDate(paramLong);
    if (this.AJF.before(this.AJD))
    {
      this.AJF.setTimeInMillis(this.AJD.getTimeInMillis());
      dPx();
    }
    dPw();
    AppMethodBeat.o(112880);
  }
  
  public final void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(112887);
    LinearLayout localLinearLayout = this.AJw;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      AppMethodBeat.o(112887);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.c
 * JD-Core Version:    0.7.0.1
 */