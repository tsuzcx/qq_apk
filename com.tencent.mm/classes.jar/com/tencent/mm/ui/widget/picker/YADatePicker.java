package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.b;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.k;
import com.tencent.mm.ui.av;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class YADatePicker
  extends FrameLayout
{
  private static final String LOG_TAG;
  public final b Ysm;
  
  static
  {
    AppMethodBeat.i(159659);
    LOG_TAG = YADatePicker.class.getSimpleName();
    AppMethodBeat.o(159659);
  }
  
  public YADatePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.datePickerStyle);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159633);
    this.Ysm = new c(this, paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.DatePicker, paramInt, 0);
    paramInt = paramContext.getInt(a.k.DatePicker_firstDayOfWeek, 0);
    paramContext.recycle();
    if (paramInt != 0) {
      setFirstDayOfWeek(paramInt);
    }
    AppMethodBeat.o(159633);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159634);
    this.Ysm.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.Ysm.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159645);
    return bool;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    AppMethodBeat.i(159656);
    dispatchThawSelfOnly(paramSparseArray);
    AppMethodBeat.o(159656);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(159647);
    String str = YADatePicker.class.getName();
    AppMethodBeat.o(159647);
    return str;
  }
  
  public CalendarView getCalendarView()
  {
    AppMethodBeat.i(159653);
    CalendarView localCalendarView = this.Ysm.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.Ysm.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.Ysm.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.Ysm.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.Ysm.idv().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.Ysm.idu().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.Ysm.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.Ysm.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  @Keep
  public b getUIDelegate()
  {
    return this.Ysm;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.Ysm.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.Ysm.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.Ysm.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.Ysm.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Ysm.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.Ysm.e(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.Ysm.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.Ysm.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.Ysm.setEnabled(paramBoolean);
    AppMethodBeat.o(159644);
  }
  
  public void setFirstDayOfWeek(int paramInt)
  {
    AppMethodBeat.i(159650);
    if ((paramInt <= 0) || (paramInt > 7))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
      AppMethodBeat.o(159650);
      throw localIllegalArgumentException;
    }
    this.Ysm.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.Ysm.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.Ysm.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.Ysm.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.Ysm.setValidationCallback(parame);
    AppMethodBeat.o(159642);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    private final int mDay;
    private final int mMonth;
    private final int mYear;
    
    static
    {
      AppMethodBeat.i(159632);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(159632);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(159630);
      this.mYear = paramParcel.readInt();
      this.mMonth = paramParcel.readInt();
      this.mDay = paramParcel.readInt();
      AppMethodBeat.o(159630);
    }
    
    private SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      this.mYear = paramInt1;
      this.mMonth = paramInt2;
      this.mDay = paramInt3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(159631);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mYear);
      paramParcel.writeInt(this.mMonth);
      paramParcel.writeInt(this.mDay);
      AppMethodBeat.o(159631);
    }
  }
  
  static abstract class a
    implements YADatePicker.b
  {
    protected YADatePicker Ysn;
    protected Locale Yso;
    protected YADatePicker.d Ysp;
    protected YADatePicker.e Ysq;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.Ysn = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
    }
    
    protected void g(Locale paramLocale)
    {
      if (!paramLocale.equals(this.Yso)) {
        this.Yso = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.Ysq = parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Parcelable e(Parcelable paramParcelable);
    
    public abstract CalendarView getCalendarView();
    
    public abstract boolean getCalendarViewShown();
    
    public abstract int getDayOfMonth();
    
    public abstract int getFirstDayOfWeek();
    
    public abstract int getMonth();
    
    public abstract boolean getSpinnersShown();
    
    public abstract int getYear();
    
    public abstract Calendar idu();
    
    public abstract Calendar idv();
    
    public abstract boolean isEnabled();
    
    public abstract void onConfigurationChanged(Configuration paramConfiguration);
    
    public abstract void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onRestoreInstanceState(Parcelable paramParcelable);
    
    public abstract void setCalendarViewShown(boolean paramBoolean);
    
    public abstract void setEnabled(boolean paramBoolean);
    
    public abstract void setFirstDayOfWeek(int paramInt);
    
    public abstract void setMaxDate(long paramLong);
    
    public abstract void setMinDate(long paramLong);
    
    public abstract void setSpinnersShown(boolean paramBoolean);
    
    public abstract void setValidationCallback(YADatePicker.e parame);
  }
  
  public static final class c
    extends YADatePicker.a
  {
    private int YsA;
    private Calendar YsB;
    private Calendar YsC;
    private Calendar YsD;
    private boolean YsE;
    public final NumberPicker Ysr;
    public final NumberPicker Yss;
    public final NumberPicker Yst;
    private final LinearLayout Ysu;
    private final EditText Ysv;
    private final EditText Ysw;
    private final EditText Ysx;
    private final CalendarView Ysy;
    private final java.text.DateFormat Ysz;
    private Calendar rBQ;
    private String[] rBR;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.Ysz = new SimpleDateFormat("MM/dd/yyyy");
      this.YsE = true;
      this.Ysn = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.DatePicker, paramInt, 0);
      boolean bool1 = localTypedArray.getBoolean(a.k.DatePicker_spinnersShown, true);
      boolean bool2 = localTypedArray.getBoolean(a.k.DatePicker_calendarViewShown, true);
      paramInt = localTypedArray.getInt(a.k.DatePicker_startYear, 1900);
      int i = localTypedArray.getInt(a.k.DatePicker_endYear, 2100);
      paramYADatePicker = localTypedArray.getString(a.k.DatePicker_minDate);
      paramAttributeSet = localTypedArray.getString(a.k.DatePicker_maxDate);
      int j = localTypedArray.getResourceId(a.k.DatePicker_legacyLayout, a.g.date_picker_legacy);
      localTypedArray.recycle();
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.Ysn, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.c(YADatePicker.c.this).setTimeInMillis(YADatePicker.c.b(YADatePicker.c.this).getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.Ysr)
          {
            i = YADatePicker.c.c(YADatePicker.c.this).getActualMaximum(5);
            if ((paramAnonymousInt1 == i) && (paramAnonymousInt2 == 1)) {
              YADatePicker.c.c(YADatePicker.c.this).add(5, 1);
            }
          }
          for (;;)
          {
            YADatePicker.c.a(YADatePicker.c.this, YADatePicker.c.c(YADatePicker.c.this).get(1), YADatePicker.c.c(YADatePicker.c.this).get(2), YADatePicker.c.c(YADatePicker.c.this).get(5));
            YADatePicker.c.d(YADatePicker.c.this);
            YADatePicker.c.e(YADatePicker.c.this);
            YADatePicker.c.f(YADatePicker.c.this);
            AppMethodBeat.o(159594);
            return;
            if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == i))
            {
              YADatePicker.c.c(YADatePicker.c.this).add(5, -1);
            }
            else
            {
              YADatePicker.c.c(YADatePicker.c.this).add(5, paramAnonymousInt2 - paramAnonymousInt1);
              continue;
              if (paramAnonymousNumberPicker == YADatePicker.c.this.Yss)
              {
                if ((paramAnonymousInt1 == 11) && (paramAnonymousInt2 == 0)) {
                  YADatePicker.c.c(YADatePicker.c.this).add(2, 1);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 11)) {
                  YADatePicker.c.c(YADatePicker.c.this).add(2, -1);
                } else {
                  YADatePicker.c.c(YADatePicker.c.this).add(2, paramAnonymousInt2 - paramAnonymousInt1);
                }
              }
              else
              {
                if (paramAnonymousNumberPicker != YADatePicker.c.this.Yst) {
                  break;
                }
                YADatePicker.c.c(YADatePicker.c.this).set(1, paramAnonymousInt2);
              }
            }
          }
          paramAnonymousNumberPicker = new IllegalArgumentException();
          AppMethodBeat.o(159594);
          throw paramAnonymousNumberPicker;
        }
      };
      this.Ysu = ((LinearLayout)this.Ysn.findViewById(a.f.pickers));
      this.Ysy = ((CalendarView)this.Ysn.findViewById(a.f.calendar_view));
      this.Ysy.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(159595);
          YADatePicker.c.a(YADatePicker.c.this, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          YADatePicker.c.d(YADatePicker.c.this);
          YADatePicker.c.f(YADatePicker.c.this);
          AppMethodBeat.o(159595);
        }
      });
      this.Ysr = ((NumberPicker)this.Ysn.findViewById(a.f.day));
      this.Ysr.setFormatter(new g());
      this.Ysr.setOnLongPressUpdateInterval(100L);
      this.Ysr.setOnValueChangedListener(paramContext);
      this.Ysv = e.b(this.Ysr);
      this.Yss = ((NumberPicker)this.Ysn.findViewById(a.f.month));
      this.Yss.setMinValue(0);
      this.Yss.setMaxValue(this.YsA - 1);
      this.Yss.setDisplayedValues(this.rBR);
      this.Yss.setOnLongPressUpdateInterval(200L);
      this.Yss.setOnValueChangedListener(paramContext);
      this.Ysw = e.b(this.Yss);
      this.Yst = ((NumberPicker)this.Ysn.findViewById(a.f.year));
      this.Yst.setOnLongPressUpdateInterval(100L);
      this.Yst.setOnValueChangedListener(paramContext);
      this.Ysx = e.b(this.Yst);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.rBQ.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.rBQ))) {
          this.rBQ.set(paramInt, 0, 1);
        }
        setMinDate(this.rBQ.getTimeInMillis());
        this.rBQ.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.rBQ))) {
          this.rBQ.set(i, 11, 31);
        }
        setMaxDate(this.rBQ.getTimeInMillis());
        this.YsD.setTimeInMillis(System.currentTimeMillis());
        a(this.YsD.get(1), this.YsD.get(2), this.YsD.get(5), null);
        idx();
        if (this.Ysn.getImportantForAccessibility() == 0) {
          this.Ysn.setImportantForAccessibility(1);
        }
        AppMethodBeat.o(159596);
        return;
        setSpinnersShown(bool1);
        setCalendarViewShown(bool2);
      }
    }
    
    private static Calendar a(Calendar paramCalendar, Locale paramLocale)
    {
      AppMethodBeat.i(159619);
      if (paramCalendar == null)
      {
        paramCalendar = Calendar.getInstance(paramLocale);
        AppMethodBeat.o(159619);
        return paramCalendar;
      }
      long l = paramCalendar.getTimeInMillis();
      paramCalendar = Calendar.getInstance(paramLocale);
      paramCalendar.setTimeInMillis(l);
      AppMethodBeat.o(159619);
      return paramCalendar;
    }
    
    private static void a(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(159625);
      if (paramInt2 < paramInt1 - 1) {}
      for (paramInt1 = 5;; paramInt1 = 6)
      {
        paramNumberPicker = e.b(paramNumberPicker);
        if (paramNumberPicker != null) {
          paramNumberPicker.setImeOptions(paramInt1);
        }
        AppMethodBeat.o(159625);
        return;
      }
    }
    
    private boolean a(String paramString, Calendar paramCalendar)
    {
      AppMethodBeat.i(159621);
      try
      {
        paramCalendar.setTime(this.Ysz.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        av.w(YADatePicker.idt(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private void be(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.YsD.set(paramInt1, paramInt2, paramInt3);
      if (this.YsD.before(this.YsB))
      {
        this.YsD.setTimeInMillis(this.YsB.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.YsD.after(this.YsC)) {
        this.YsD.setTimeInMillis(this.YsC.getTimeInMillis());
      }
      AppMethodBeat.o(159622);
    }
    
    private boolean idw()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.rBR[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void idx()
    {
      AppMethodBeat.i(159620);
      this.Ysu.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.Ysn.getLayoutDirection() == 0))
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
          AppMethodBeat.o(159620);
          throw ((Throwable)localObject);
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.Ysn.getContext());
        }
      }
      this.Ysu.addView(this.Ysr);
      a(this.Ysr, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.Ysu.addView(this.Yss);
        a(this.Yss, j, i);
        continue;
        this.Ysu.addView(this.Yst);
        a(this.Yst, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    private void idy()
    {
      AppMethodBeat.i(159623);
      if (this.YsD.equals(this.YsB))
      {
        this.Ysr.setMinValue(this.YsD.get(5));
        this.Ysr.setMaxValue(this.YsD.getActualMaximum(5));
        this.Ysr.setWrapSelectorWheel(false);
        this.Yss.setDisplayedValues(null);
        this.Yss.setMinValue(this.YsD.get(2));
        this.Yss.setMaxValue(this.YsD.getActualMaximum(2));
        this.Yss.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.rBR, this.Yss.getMinValue(), this.Yss.getMaxValue() + 1);
        this.Yss.setDisplayedValues(arrayOfString);
        this.Yst.setMinValue(this.YsB.get(1));
        this.Yst.setMaxValue(this.YsC.get(1));
        this.Yst.setWrapSelectorWheel(false);
        this.Yst.setValue(this.YsD.get(1));
        this.Yss.setValue(this.YsD.get(2));
        this.Ysr.setValue(this.YsD.get(5));
        if (idw()) {
          this.Ysw.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.YsD.equals(this.YsC))
        {
          this.Ysr.setMinValue(this.YsD.getActualMinimum(5));
          this.Ysr.setMaxValue(this.YsD.get(5));
          this.Ysr.setWrapSelectorWheel(false);
          this.Yss.setDisplayedValues(null);
          this.Yss.setMinValue(this.YsD.getActualMinimum(2));
          this.Yss.setMaxValue(this.YsD.get(2));
          this.Yss.setWrapSelectorWheel(false);
        }
        else
        {
          this.Ysr.setMinValue(1);
          this.Ysr.setMaxValue(this.YsD.getActualMaximum(5));
          this.Ysr.setWrapSelectorWheel(true);
          this.Yss.setDisplayedValues(null);
          this.Yss.setMinValue(0);
          this.Yss.setMaxValue(11);
          this.Yss.setWrapSelectorWheel(true);
        }
      }
    }
    
    private void idz()
    {
      AppMethodBeat.i(159624);
      this.Ysy.setDate(this.YsD.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      be(paramInt1, paramInt2, paramInt3);
      idy();
      idz();
      this.Ysp = paramd;
      AppMethodBeat.o(159597);
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(159615);
      onPopulateAccessibilityEvent(paramAccessibilityEvent);
      AppMethodBeat.o(159615);
      return true;
    }
    
    public final Parcelable e(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159613);
      paramParcelable = new YADatePicker.SavedState(paramParcelable, getYear(), getMonth(), getDayOfMonth(), (byte)0);
      AppMethodBeat.o(159613);
      return paramParcelable;
    }
    
    protected final void g(Locale paramLocale)
    {
      AppMethodBeat.i(159617);
      super.g(paramLocale);
      this.rBQ = a(this.rBQ, paramLocale);
      this.YsB = a(this.YsB, paramLocale);
      this.YsC = a(this.YsC, paramLocale);
      this.YsD = a(this.YsD, paramLocale);
      this.YsA = (this.rBQ.getActualMaximum(2) + 1);
      this.rBR = new DateFormatSymbols().getShortMonths();
      if (idw())
      {
        this.rBR = new String[this.YsA];
        int i = 0;
        while (i < this.YsA)
        {
          this.rBR[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.Ysy;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.Ysy.getVisibility() == 0)
      {
        AppMethodBeat.o(159608);
        return true;
      }
      AppMethodBeat.o(159608);
      return false;
    }
    
    public final int getDayOfMonth()
    {
      AppMethodBeat.i(159600);
      int i = this.YsD.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.Ysy.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.YsD.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.Ysu.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.YsD.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final Calendar idu()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.Ysy.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar idv()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.Ysy.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
    }
    
    public final boolean isEnabled()
    {
      return this.YsE;
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration)
    {
      AppMethodBeat.i(159612);
      g(paramConfiguration.locale);
      AppMethodBeat.o(159612);
    }
    
    public final void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(159616);
      String str = DateUtils.formatDateTime(this.mContext, this.YsD.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      be(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      idy();
      idz();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.Ysy;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localCalendarView.setVisibility(i);
        AppMethodBeat.o(159609);
        return;
      }
    }
    
    public final void setEnabled(boolean paramBoolean)
    {
      AppMethodBeat.i(159607);
      this.Ysr.setEnabled(paramBoolean);
      this.Yss.setEnabled(paramBoolean);
      this.Yst.setEnabled(paramBoolean);
      this.Ysy.setEnabled(paramBoolean);
      this.YsE = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.Ysy.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.rBQ.setTimeInMillis(paramLong);
      if ((this.rBQ.get(1) == this.YsC.get(1)) && (this.rBQ.get(6) != this.YsC.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.YsC.setTimeInMillis(paramLong);
      this.Ysy.setMaxDate(paramLong);
      if (this.YsD.after(this.YsC))
      {
        this.YsD.setTimeInMillis(this.YsC.getTimeInMillis());
        idz();
      }
      idy();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.rBQ.setTimeInMillis(paramLong);
      if ((this.rBQ.get(1) == this.YsB.get(1)) && (this.rBQ.get(6) != this.YsB.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.YsB.setTimeInMillis(paramLong);
      this.Ysy.setMinDate(paramLong);
      if (this.YsD.before(this.YsB))
      {
        this.YsD.setTimeInMillis(this.YsB.getTimeInMillis());
        idz();
      }
      idy();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.Ysu;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localLinearLayout.setVisibility(i);
        AppMethodBeat.o(159611);
        return;
      }
    }
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */