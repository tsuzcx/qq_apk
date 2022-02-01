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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.b;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.k;
import com.tencent.mm.ui.bc;
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
  public final b agkB;
  
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
    this.agkB = new c(this, paramContext, paramAttributeSet, paramInt);
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
    this.agkB.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.agkB.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
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
    CalendarView localCalendarView = this.agkB.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.agkB.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.agkB.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.agkB.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.agkB.jID().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.agkB.jIC().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.agkB.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.agkB.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  public b getUIDelegate()
  {
    return this.agkB;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.agkB.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.agkB.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.agkB.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.agkB.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.agkB.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.agkB.e(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.agkB.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.agkB.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.agkB.setEnabled(paramBoolean);
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
    this.agkB.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.agkB.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.agkB.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.agkB.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.agkB.setValidationCallback(parame);
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
    protected YADatePicker agkC;
    protected Locale agkD;
    protected YADatePicker.d agkE;
    protected YADatePicker.e agkF;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.agkC = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
    }
    
    protected void g(Locale paramLocale)
    {
      if (!paramLocale.equals(this.agkD)) {
        this.agkD = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.agkF = parame;
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
    
    public abstract boolean isEnabled();
    
    public abstract Calendar jIC();
    
    public abstract Calendar jID();
    
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
    public final NumberPicker agkG;
    public final NumberPicker agkH;
    public final NumberPicker agkI;
    private final LinearLayout agkJ;
    private final EditText agkK;
    private final EditText agkL;
    private final EditText agkM;
    private final CalendarView agkN;
    private final java.text.DateFormat agkO;
    private int agkP;
    private Calendar agkQ;
    private Calendar agkR;
    private Calendar agkS;
    private boolean agkT;
    private Calendar uNf;
    private String[] uNg;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.agkO = new SimpleDateFormat("MM/dd/yyyy");
      this.agkT = true;
      this.agkC = paramYADatePicker;
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
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.agkC, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.c(YADatePicker.c.this).setTimeInMillis(YADatePicker.c.b(YADatePicker.c.this).getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.agkG)
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
              if (paramAnonymousNumberPicker == YADatePicker.c.this.agkH)
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
                if (paramAnonymousNumberPicker != YADatePicker.c.this.agkI) {
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
      this.agkJ = ((LinearLayout)this.agkC.findViewById(a.f.pickers));
      this.agkN = ((CalendarView)this.agkC.findViewById(a.f.calendar_view));
      this.agkN.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
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
      this.agkG = ((NumberPicker)this.agkC.findViewById(a.f.day));
      this.agkG.setFormatter(new g());
      this.agkG.setOnLongPressUpdateInterval(100L);
      this.agkG.setOnValueChangedListener(paramContext);
      this.agkK = e.b(this.agkG);
      this.agkH = ((NumberPicker)this.agkC.findViewById(a.f.month));
      this.agkH.setMinValue(0);
      this.agkH.setMaxValue(this.agkP - 1);
      this.agkH.setDisplayedValues(this.uNg);
      this.agkH.setOnLongPressUpdateInterval(200L);
      this.agkH.setOnValueChangedListener(paramContext);
      this.agkL = e.b(this.agkH);
      this.agkI = ((NumberPicker)this.agkC.findViewById(a.f.year));
      this.agkI.setOnLongPressUpdateInterval(100L);
      this.agkI.setOnValueChangedListener(paramContext);
      this.agkM = e.b(this.agkI);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.uNf.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.uNf))) {
          this.uNf.set(paramInt, 0, 1);
        }
        setMinDate(this.uNf.getTimeInMillis());
        this.uNf.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.uNf))) {
          this.uNf.set(i, 11, 31);
        }
        setMaxDate(this.uNf.getTimeInMillis());
        this.agkS.setTimeInMillis(System.currentTimeMillis());
        a(this.agkS.get(1), this.agkS.get(2), this.agkS.get(5), null);
        jIF();
        if (this.agkC.getImportantForAccessibility() == 0) {
          this.agkC.setImportantForAccessibility(1);
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
        paramCalendar.setTime(this.agkO.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        bc.w(YADatePicker.gyD(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private void bF(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.agkS.set(paramInt1, paramInt2, paramInt3);
      if (this.agkS.before(this.agkQ))
      {
        this.agkS.setTimeInMillis(this.agkQ.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.agkS.after(this.agkR)) {
        this.agkS.setTimeInMillis(this.agkR.getTimeInMillis());
      }
      AppMethodBeat.o(159622);
    }
    
    private boolean jIE()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.uNg[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void jIF()
    {
      AppMethodBeat.i(159620);
      this.agkJ.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.agkC.getLayoutDirection() == 0))
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
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.agkC.getContext());
        }
      }
      this.agkJ.addView(this.agkG);
      a(this.agkG, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.agkJ.addView(this.agkH);
        a(this.agkH, j, i);
        continue;
        this.agkJ.addView(this.agkI);
        a(this.agkI, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    private void jIG()
    {
      AppMethodBeat.i(159623);
      if (this.agkS.equals(this.agkQ))
      {
        this.agkG.setMinValue(this.agkS.get(5));
        this.agkG.setMaxValue(this.agkS.getActualMaximum(5));
        this.agkG.setWrapSelectorWheel(false);
        this.agkH.setDisplayedValues(null);
        this.agkH.setMinValue(this.agkS.get(2));
        this.agkH.setMaxValue(this.agkS.getActualMaximum(2));
        this.agkH.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.uNg, this.agkH.getMinValue(), this.agkH.getMaxValue() + 1);
        this.agkH.setDisplayedValues(arrayOfString);
        this.agkI.setMinValue(this.agkQ.get(1));
        this.agkI.setMaxValue(this.agkR.get(1));
        this.agkI.setWrapSelectorWheel(false);
        this.agkI.setValue(this.agkS.get(1));
        this.agkH.setValue(this.agkS.get(2));
        this.agkG.setValue(this.agkS.get(5));
        if (jIE()) {
          this.agkL.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.agkS.equals(this.agkR))
        {
          this.agkG.setMinValue(this.agkS.getActualMinimum(5));
          this.agkG.setMaxValue(this.agkS.get(5));
          this.agkG.setWrapSelectorWheel(false);
          this.agkH.setDisplayedValues(null);
          this.agkH.setMinValue(this.agkS.getActualMinimum(2));
          this.agkH.setMaxValue(this.agkS.get(2));
          this.agkH.setWrapSelectorWheel(false);
        }
        else
        {
          this.agkG.setMinValue(1);
          this.agkG.setMaxValue(this.agkS.getActualMaximum(5));
          this.agkG.setWrapSelectorWheel(true);
          this.agkH.setDisplayedValues(null);
          this.agkH.setMinValue(0);
          this.agkH.setMaxValue(11);
          this.agkH.setWrapSelectorWheel(true);
        }
      }
    }
    
    private void jIH()
    {
      AppMethodBeat.i(159624);
      this.agkN.setDate(this.agkS.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      bF(paramInt1, paramInt2, paramInt3);
      jIG();
      jIH();
      this.agkE = paramd;
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
      this.uNf = a(this.uNf, paramLocale);
      this.agkQ = a(this.agkQ, paramLocale);
      this.agkR = a(this.agkR, paramLocale);
      this.agkS = a(this.agkS, paramLocale);
      this.agkP = (this.uNf.getActualMaximum(2) + 1);
      this.uNg = new DateFormatSymbols().getShortMonths();
      if (jIE())
      {
        this.uNg = new String[this.agkP];
        int i = 0;
        while (i < this.agkP)
        {
          this.uNg[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.agkN;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.agkN.getVisibility() == 0)
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
      int i = this.agkS.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.agkN.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.agkS.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.agkJ.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.agkS.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final boolean isEnabled()
    {
      return this.agkT;
    }
    
    public final Calendar jIC()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.agkN.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar jID()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.agkN.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
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
      String str = DateUtils.formatDateTime(this.mContext, this.agkS.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      bF(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      jIG();
      jIH();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.agkN;
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
      this.agkG.setEnabled(paramBoolean);
      this.agkH.setEnabled(paramBoolean);
      this.agkI.setEnabled(paramBoolean);
      this.agkN.setEnabled(paramBoolean);
      this.agkT = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.agkN.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.uNf.setTimeInMillis(paramLong);
      if ((this.uNf.get(1) == this.agkR.get(1)) && (this.uNf.get(6) != this.agkR.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.agkR.setTimeInMillis(paramLong);
      this.agkN.setMaxDate(paramLong);
      if (this.agkS.after(this.agkR))
      {
        this.agkS.setTimeInMillis(this.agkR.getTimeInMillis());
        jIH();
      }
      jIG();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.uNf.setTimeInMillis(paramLong);
      if ((this.uNf.get(1) == this.agkQ.get(1)) && (this.uNf.get(6) != this.agkQ.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.agkQ.setTimeInMillis(paramLong);
      this.agkN.setMinDate(paramLong);
      if (this.agkS.before(this.agkQ))
      {
        this.agkS.setTimeInMillis(this.agkQ.getTimeInMillis());
        jIH();
      }
      jIG();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.agkJ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */