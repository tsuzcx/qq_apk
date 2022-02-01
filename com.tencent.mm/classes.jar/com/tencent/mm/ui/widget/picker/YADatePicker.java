package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
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
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.an;
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
  public final b Jkn;
  
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
    this(paramContext, paramAttributeSet, 2130968899);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159633);
    this.Jkn = new c(this, paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DatePicker, paramInt, 0);
    paramInt = paramContext.getInt(6, 0);
    paramContext.recycle();
    if (paramInt != 0) {
      setFirstDayOfWeek(paramInt);
    }
    AppMethodBeat.o(159633);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    AppMethodBeat.i(159634);
    this.Jkn.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.Jkn.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
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
    CalendarView localCalendarView = this.Jkn.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.Jkn.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.Jkn.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.Jkn.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.Jkn.fwf().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.Jkn.fwe().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.Jkn.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.Jkn.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  @Keep
  public b getUIDelegate()
  {
    return this.Jkn;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.Jkn.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.Jkn.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.Jkn.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.Jkn.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Jkn.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.Jkn.f(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.Jkn.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.Jkn.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.Jkn.setEnabled(paramBoolean);
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
    this.Jkn.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.Jkn.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.Jkn.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.Jkn.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.Jkn.setValidationCallback(parame);
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
    protected YADatePicker Jko;
    protected Locale Jkp;
    protected YADatePicker.d Jkq;
    protected YADatePicker.e Jkr;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.Jko = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
    }
    
    protected void g(Locale paramLocale)
    {
      if (!paramLocale.equals(this.Jkp)) {
        this.Jkp = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.Jkr = parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Parcelable f(Parcelable paramParcelable);
    
    public abstract Calendar fwe();
    
    public abstract Calendar fwf();
    
    public abstract CalendarView getCalendarView();
    
    public abstract boolean getCalendarViewShown();
    
    public abstract int getDayOfMonth();
    
    public abstract int getFirstDayOfWeek();
    
    public abstract int getMonth();
    
    public abstract boolean getSpinnersShown();
    
    public abstract int getYear();
    
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
    private final java.text.DateFormat JkA;
    private int JkB;
    private Calendar JkC;
    private Calendar JkD;
    Calendar JkE;
    private boolean JkF;
    public final NumberPicker Jks;
    public final NumberPicker Jkt;
    public final NumberPicker Jku;
    private final LinearLayout Jkv;
    private final EditText Jkw;
    private final EditText Jkx;
    private final EditText Jky;
    private final CalendarView Jkz;
    Calendar mJY;
    private String[] mJZ;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.JkA = new SimpleDateFormat("MM/dd/yyyy");
      this.JkF = true;
      this.Jko = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DatePicker, paramInt, 0);
      boolean bool1 = localTypedArray.getBoolean(16, true);
      boolean bool2 = localTypedArray.getBoolean(1, true);
      paramInt = localTypedArray.getInt(17, 1900);
      int i = localTypedArray.getInt(5, 2100);
      paramYADatePicker = localTypedArray.getString(15);
      paramAttributeSet = localTypedArray.getString(14);
      int j = localTypedArray.getResourceId(13, 2131493682);
      localTypedArray.recycle();
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.Jko, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.this.mJY.setTimeInMillis(YADatePicker.c.this.JkE.getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.Jks)
          {
            i = YADatePicker.c.this.mJY.getActualMaximum(5);
            if ((paramAnonymousInt1 == i) && (paramAnonymousInt2 == 1)) {
              YADatePicker.c.this.mJY.add(5, 1);
            }
          }
          for (;;)
          {
            YADatePicker.c.this.aR(YADatePicker.c.this.mJY.get(1), YADatePicker.c.this.mJY.get(2), YADatePicker.c.this.mJY.get(5));
            YADatePicker.c.this.fwi();
            YADatePicker.c.this.fwj();
            YADatePicker.c.b(YADatePicker.c.this);
            AppMethodBeat.o(159594);
            return;
            if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == i))
            {
              YADatePicker.c.this.mJY.add(5, -1);
            }
            else
            {
              YADatePicker.c.this.mJY.add(5, paramAnonymousInt2 - paramAnonymousInt1);
              continue;
              if (paramAnonymousNumberPicker == YADatePicker.c.this.Jkt)
              {
                if ((paramAnonymousInt1 == 11) && (paramAnonymousInt2 == 0)) {
                  YADatePicker.c.this.mJY.add(2, 1);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 11)) {
                  YADatePicker.c.this.mJY.add(2, -1);
                } else {
                  YADatePicker.c.this.mJY.add(2, paramAnonymousInt2 - paramAnonymousInt1);
                }
              }
              else
              {
                if (paramAnonymousNumberPicker != YADatePicker.c.this.Jku) {
                  break;
                }
                YADatePicker.c.this.mJY.set(1, paramAnonymousInt2);
              }
            }
          }
          paramAnonymousNumberPicker = new IllegalArgumentException();
          AppMethodBeat.o(159594);
          throw paramAnonymousNumberPicker;
        }
      };
      this.Jkv = ((LinearLayout)this.Jko.findViewById(2131303267));
      this.Jkz = ((CalendarView)this.Jko.findViewById(2131297679));
      this.Jkz.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(159595);
          YADatePicker.c.this.aR(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          YADatePicker.c.this.fwi();
          YADatePicker.c.b(YADatePicker.c.this);
          AppMethodBeat.o(159595);
        }
      });
      this.Jks = ((NumberPicker)this.Jko.findViewById(2131298935));
      this.Jks.setFormatter(new i());
      this.Jks.setOnLongPressUpdateInterval(100L);
      this.Jks.setOnValueChangedListener(paramContext);
      this.Jkw = f.b(this.Jks);
      this.Jkt = ((NumberPicker)this.Jko.findViewById(2131302450));
      this.Jkt.setMinValue(0);
      this.Jkt.setMaxValue(this.JkB - 1);
      this.Jkt.setDisplayedValues(this.mJZ);
      this.Jkt.setOnLongPressUpdateInterval(200L);
      this.Jkt.setOnValueChangedListener(paramContext);
      this.Jkx = f.b(this.Jkt);
      this.Jku = ((NumberPicker)this.Jko.findViewById(2131307138));
      this.Jku.setOnLongPressUpdateInterval(100L);
      this.Jku.setOnValueChangedListener(paramContext);
      this.Jky = f.b(this.Jku);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.mJY.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.mJY))) {
          this.mJY.set(paramInt, 0, 1);
        }
        setMinDate(this.mJY.getTimeInMillis());
        this.mJY.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.mJY))) {
          this.mJY.set(i, 11, 31);
        }
        setMaxDate(this.mJY.getTimeInMillis());
        this.JkE.setTimeInMillis(System.currentTimeMillis());
        a(this.JkE.get(1), this.JkE.get(2), this.JkE.get(5), null);
        fwh();
        if (this.Jko.getImportantForAccessibility() == 0) {
          this.Jko.setImportantForAccessibility(1);
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
        paramNumberPicker = f.b(paramNumberPicker);
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
        paramCalendar.setTime(this.JkA.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        an.w(YADatePicker.fwd(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private boolean fwg()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.mJZ[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void fwh()
    {
      AppMethodBeat.i(159620);
      this.Jkv.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.Jko.getLayoutDirection() == 0))
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
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.Jko.getContext());
        }
      }
      this.Jkv.addView(this.Jks);
      a(this.Jks, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.Jkv.addView(this.Jkt);
        a(this.Jkt, j, i);
        continue;
        this.Jkv.addView(this.Jku);
        a(this.Jku, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      aR(paramInt1, paramInt2, paramInt3);
      fwi();
      fwj();
      this.Jkq = paramd;
      AppMethodBeat.o(159597);
    }
    
    final void aR(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.JkE.set(paramInt1, paramInt2, paramInt3);
      if (this.JkE.before(this.JkC))
      {
        this.JkE.setTimeInMillis(this.JkC.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.JkE.after(this.JkD)) {
        this.JkE.setTimeInMillis(this.JkD.getTimeInMillis());
      }
      AppMethodBeat.o(159622);
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(159615);
      onPopulateAccessibilityEvent(paramAccessibilityEvent);
      AppMethodBeat.o(159615);
      return true;
    }
    
    public final Parcelable f(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159613);
      paramParcelable = new YADatePicker.SavedState(paramParcelable, getYear(), getMonth(), getDayOfMonth(), (byte)0);
      AppMethodBeat.o(159613);
      return paramParcelable;
    }
    
    public final Calendar fwe()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.Jkz.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar fwf()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.Jkz.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
    }
    
    final void fwi()
    {
      AppMethodBeat.i(159623);
      if (this.JkE.equals(this.JkC))
      {
        this.Jks.setMinValue(this.JkE.get(5));
        this.Jks.setMaxValue(this.JkE.getActualMaximum(5));
        this.Jks.setWrapSelectorWheel(false);
        this.Jkt.setDisplayedValues(null);
        this.Jkt.setMinValue(this.JkE.get(2));
        this.Jkt.setMaxValue(this.JkE.getActualMaximum(2));
        this.Jkt.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.mJZ, this.Jkt.getMinValue(), this.Jkt.getMaxValue() + 1);
        this.Jkt.setDisplayedValues(arrayOfString);
        this.Jku.setMinValue(this.JkC.get(1));
        this.Jku.setMaxValue(this.JkD.get(1));
        this.Jku.setWrapSelectorWheel(false);
        this.Jku.setValue(this.JkE.get(1));
        this.Jkt.setValue(this.JkE.get(2));
        this.Jks.setValue(this.JkE.get(5));
        if (fwg()) {
          this.Jkx.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.JkE.equals(this.JkD))
        {
          this.Jks.setMinValue(this.JkE.getActualMinimum(5));
          this.Jks.setMaxValue(this.JkE.get(5));
          this.Jks.setWrapSelectorWheel(false);
          this.Jkt.setDisplayedValues(null);
          this.Jkt.setMinValue(this.JkE.getActualMinimum(2));
          this.Jkt.setMaxValue(this.JkE.get(2));
          this.Jkt.setWrapSelectorWheel(false);
        }
        else
        {
          this.Jks.setMinValue(1);
          this.Jks.setMaxValue(this.JkE.getActualMaximum(5));
          this.Jks.setWrapSelectorWheel(true);
          this.Jkt.setDisplayedValues(null);
          this.Jkt.setMinValue(0);
          this.Jkt.setMaxValue(11);
          this.Jkt.setWrapSelectorWheel(true);
        }
      }
    }
    
    final void fwj()
    {
      AppMethodBeat.i(159624);
      this.Jkz.setDate(this.JkE.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    protected final void g(Locale paramLocale)
    {
      AppMethodBeat.i(159617);
      super.g(paramLocale);
      this.mJY = a(this.mJY, paramLocale);
      this.JkC = a(this.JkC, paramLocale);
      this.JkD = a(this.JkD, paramLocale);
      this.JkE = a(this.JkE, paramLocale);
      this.JkB = (this.mJY.getActualMaximum(2) + 1);
      this.mJZ = new DateFormatSymbols().getShortMonths();
      if (fwg())
      {
        this.mJZ = new String[this.JkB];
        int i = 0;
        while (i < this.JkB)
        {
          this.mJZ[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.Jkz;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.Jkz.getVisibility() == 0)
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
      int i = this.JkE.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.Jkz.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.JkE.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.Jkv.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.JkE.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final boolean isEnabled()
    {
      return this.JkF;
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
      String str = DateUtils.formatDateTime(this.mContext, this.JkE.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      aR(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      fwi();
      fwj();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.Jkz;
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
      this.Jks.setEnabled(paramBoolean);
      this.Jkt.setEnabled(paramBoolean);
      this.Jku.setEnabled(paramBoolean);
      this.Jkz.setEnabled(paramBoolean);
      this.JkF = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.Jkz.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.mJY.setTimeInMillis(paramLong);
      if ((this.mJY.get(1) == this.JkD.get(1)) && (this.mJY.get(6) != this.JkD.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.JkD.setTimeInMillis(paramLong);
      this.Jkz.setMaxDate(paramLong);
      if (this.JkE.after(this.JkD))
      {
        this.JkE.setTimeInMillis(this.JkD.getTimeInMillis());
        fwj();
      }
      fwi();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.mJY.setTimeInMillis(paramLong);
      if ((this.mJY.get(1) == this.JkC.get(1)) && (this.mJY.get(6) != this.JkC.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.JkC.setTimeInMillis(paramLong);
      this.Jkz.setMinDate(paramLong);
      if (this.JkE.before(this.JkC))
      {
        this.JkE.setTimeInMillis(this.JkC.getTimeInMillis());
        fwj();
      }
      fwi();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.Jkv;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */