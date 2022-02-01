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
import com.tencent.mm.cm.a.a;
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
  public final b HJQ;
  
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
    this.HJQ = new c(this, paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DatePicker, paramInt, 0);
    paramInt = paramContext.getInt(6, 0);
    paramContext.recycle();
    if (paramInt != 0) {
      setFirstDayOfWeek(paramInt);
    }
    AppMethodBeat.o(159633);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, d paramd)
  {
    AppMethodBeat.i(159634);
    this.HJQ.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.HJQ.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
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
    CalendarView localCalendarView = this.HJQ.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.HJQ.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.HJQ.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.HJQ.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.HJQ.fgf().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.HJQ.fge().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.HJQ.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.HJQ.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  @Keep
  public b getUIDelegate()
  {
    return this.HJQ;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.HJQ.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.HJQ.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.HJQ.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.HJQ.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.HJQ.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.HJQ.f(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.HJQ.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.HJQ.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.HJQ.setEnabled(paramBoolean);
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
    this.HJQ.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.HJQ.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.HJQ.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.HJQ.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.HJQ.setValidationCallback(parame);
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
    protected YADatePicker HJR;
    protected Locale HJS;
    protected YADatePicker.d HJT;
    protected YADatePicker.e HJU;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.HJR = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
    }
    
    protected void g(Locale paramLocale)
    {
      if (!paramLocale.equals(this.HJS)) {
        this.HJS = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.HJU = parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Parcelable f(Parcelable paramParcelable);
    
    public abstract Calendar fge();
    
    public abstract Calendar fgf();
    
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
    public final NumberPicker HJV;
    public final NumberPicker HJW;
    public final NumberPicker HJX;
    private final LinearLayout HJY;
    private final EditText HJZ;
    private final EditText HKa;
    private final EditText HKb;
    private final CalendarView HKc;
    private final java.text.DateFormat HKd;
    private int HKe;
    private Calendar HKf;
    private Calendar HKg;
    Calendar HKh;
    private boolean HKi;
    Calendar mhX;
    private String[] mhY;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.HKd = new SimpleDateFormat("MM/dd/yyyy");
      this.HKi = true;
      this.HJR = paramYADatePicker;
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
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.HJR, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.this.mhX.setTimeInMillis(YADatePicker.c.this.HKh.getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.HJV)
          {
            i = YADatePicker.c.this.mhX.getActualMaximum(5);
            if ((paramAnonymousInt1 == i) && (paramAnonymousInt2 == 1)) {
              YADatePicker.c.this.mhX.add(5, 1);
            }
          }
          for (;;)
          {
            YADatePicker.c.this.aP(YADatePicker.c.this.mhX.get(1), YADatePicker.c.this.mhX.get(2), YADatePicker.c.this.mhX.get(5));
            YADatePicker.c.this.fgi();
            YADatePicker.c.this.fgj();
            YADatePicker.c.b(YADatePicker.c.this);
            AppMethodBeat.o(159594);
            return;
            if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == i))
            {
              YADatePicker.c.this.mhX.add(5, -1);
            }
            else
            {
              YADatePicker.c.this.mhX.add(5, paramAnonymousInt2 - paramAnonymousInt1);
              continue;
              if (paramAnonymousNumberPicker == YADatePicker.c.this.HJW)
              {
                if ((paramAnonymousInt1 == 11) && (paramAnonymousInt2 == 0)) {
                  YADatePicker.c.this.mhX.add(2, 1);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 11)) {
                  YADatePicker.c.this.mhX.add(2, -1);
                } else {
                  YADatePicker.c.this.mhX.add(2, paramAnonymousInt2 - paramAnonymousInt1);
                }
              }
              else
              {
                if (paramAnonymousNumberPicker != YADatePicker.c.this.HJX) {
                  break;
                }
                YADatePicker.c.this.mhX.set(1, paramAnonymousInt2);
              }
            }
          }
          paramAnonymousNumberPicker = new IllegalArgumentException();
          AppMethodBeat.o(159594);
          throw paramAnonymousNumberPicker;
        }
      };
      this.HJY = ((LinearLayout)this.HJR.findViewById(2131303267));
      this.HKc = ((CalendarView)this.HJR.findViewById(2131297679));
      this.HKc.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(159595);
          YADatePicker.c.this.aP(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          YADatePicker.c.this.fgi();
          YADatePicker.c.b(YADatePicker.c.this);
          AppMethodBeat.o(159595);
        }
      });
      this.HJV = ((NumberPicker)this.HJR.findViewById(2131298935));
      this.HJV.setFormatter(new i());
      this.HJV.setOnLongPressUpdateInterval(100L);
      this.HJV.setOnValueChangedListener(paramContext);
      this.HJZ = f.b(this.HJV);
      this.HJW = ((NumberPicker)this.HJR.findViewById(2131302450));
      this.HJW.setMinValue(0);
      this.HJW.setMaxValue(this.HKe - 1);
      this.HJW.setDisplayedValues(this.mhY);
      this.HJW.setOnLongPressUpdateInterval(200L);
      this.HJW.setOnValueChangedListener(paramContext);
      this.HKa = f.b(this.HJW);
      this.HJX = ((NumberPicker)this.HJR.findViewById(2131307138));
      this.HJX.setOnLongPressUpdateInterval(100L);
      this.HJX.setOnValueChangedListener(paramContext);
      this.HKb = f.b(this.HJX);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.mhX.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.mhX))) {
          this.mhX.set(paramInt, 0, 1);
        }
        setMinDate(this.mhX.getTimeInMillis());
        this.mhX.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.mhX))) {
          this.mhX.set(i, 11, 31);
        }
        setMaxDate(this.mhX.getTimeInMillis());
        this.HKh.setTimeInMillis(System.currentTimeMillis());
        a(this.HKh.get(1), this.HKh.get(2), this.HKh.get(5), null);
        fgh();
        if (this.HJR.getImportantForAccessibility() == 0) {
          this.HJR.setImportantForAccessibility(1);
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
        paramCalendar.setTime(this.HKd.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        an.w(YADatePicker.fgd(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private boolean fgg()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.mhY[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void fgh()
    {
      AppMethodBeat.i(159620);
      this.HJY.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.HJR.getLayoutDirection() == 0))
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
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.HJR.getContext());
        }
      }
      this.HJY.addView(this.HJV);
      a(this.HJV, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.HJY.addView(this.HJW);
        a(this.HJW, j, i);
        continue;
        this.HJY.addView(this.HJX);
        a(this.HJX, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      aP(paramInt1, paramInt2, paramInt3);
      fgi();
      fgj();
      this.HJT = paramd;
      AppMethodBeat.o(159597);
    }
    
    final void aP(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.HKh.set(paramInt1, paramInt2, paramInt3);
      if (this.HKh.before(this.HKf))
      {
        this.HKh.setTimeInMillis(this.HKf.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.HKh.after(this.HKg)) {
        this.HKh.setTimeInMillis(this.HKg.getTimeInMillis());
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
    
    public final Calendar fge()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.HKc.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar fgf()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.HKc.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
    }
    
    final void fgi()
    {
      AppMethodBeat.i(159623);
      if (this.HKh.equals(this.HKf))
      {
        this.HJV.setMinValue(this.HKh.get(5));
        this.HJV.setMaxValue(this.HKh.getActualMaximum(5));
        this.HJV.setWrapSelectorWheel(false);
        this.HJW.setDisplayedValues(null);
        this.HJW.setMinValue(this.HKh.get(2));
        this.HJW.setMaxValue(this.HKh.getActualMaximum(2));
        this.HJW.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.mhY, this.HJW.getMinValue(), this.HJW.getMaxValue() + 1);
        this.HJW.setDisplayedValues(arrayOfString);
        this.HJX.setMinValue(this.HKf.get(1));
        this.HJX.setMaxValue(this.HKg.get(1));
        this.HJX.setWrapSelectorWheel(false);
        this.HJX.setValue(this.HKh.get(1));
        this.HJW.setValue(this.HKh.get(2));
        this.HJV.setValue(this.HKh.get(5));
        if (fgg()) {
          this.HKa.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.HKh.equals(this.HKg))
        {
          this.HJV.setMinValue(this.HKh.getActualMinimum(5));
          this.HJV.setMaxValue(this.HKh.get(5));
          this.HJV.setWrapSelectorWheel(false);
          this.HJW.setDisplayedValues(null);
          this.HJW.setMinValue(this.HKh.getActualMinimum(2));
          this.HJW.setMaxValue(this.HKh.get(2));
          this.HJW.setWrapSelectorWheel(false);
        }
        else
        {
          this.HJV.setMinValue(1);
          this.HJV.setMaxValue(this.HKh.getActualMaximum(5));
          this.HJV.setWrapSelectorWheel(true);
          this.HJW.setDisplayedValues(null);
          this.HJW.setMinValue(0);
          this.HJW.setMaxValue(11);
          this.HJW.setWrapSelectorWheel(true);
        }
      }
    }
    
    final void fgj()
    {
      AppMethodBeat.i(159624);
      this.HKc.setDate(this.HKh.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    protected final void g(Locale paramLocale)
    {
      AppMethodBeat.i(159617);
      super.g(paramLocale);
      this.mhX = a(this.mhX, paramLocale);
      this.HKf = a(this.HKf, paramLocale);
      this.HKg = a(this.HKg, paramLocale);
      this.HKh = a(this.HKh, paramLocale);
      this.HKe = (this.mhX.getActualMaximum(2) + 1);
      this.mhY = new DateFormatSymbols().getShortMonths();
      if (fgg())
      {
        this.mhY = new String[this.HKe];
        int i = 0;
        while (i < this.HKe)
        {
          this.mhY[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.HKc;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.HKc.getVisibility() == 0)
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
      int i = this.HKh.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.HKc.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.HKh.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.HJY.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.HKh.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final boolean isEnabled()
    {
      return this.HKi;
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
      String str = DateUtils.formatDateTime(this.mContext, this.HKh.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      aP(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      fgi();
      fgj();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.HKc;
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
      this.HJV.setEnabled(paramBoolean);
      this.HJW.setEnabled(paramBoolean);
      this.HJX.setEnabled(paramBoolean);
      this.HKc.setEnabled(paramBoolean);
      this.HKi = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.HKc.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.mhX.setTimeInMillis(paramLong);
      if ((this.mhX.get(1) == this.HKg.get(1)) && (this.mhX.get(6) != this.HKg.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.HKg.setTimeInMillis(paramLong);
      this.HKc.setMaxDate(paramLong);
      if (this.HKh.after(this.HKg))
      {
        this.HKh.setTimeInMillis(this.HKg.getTimeInMillis());
        fgj();
      }
      fgi();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.mhX.setTimeInMillis(paramLong);
      if ((this.mhX.get(1) == this.HKf.get(1)) && (this.mhX.get(6) != this.HKf.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.HKf.setTimeInMillis(paramLong);
      this.HKc.setMinDate(paramLong);
      if (this.HKh.before(this.HKf))
      {
        this.HKh.setTimeInMillis(this.HKf.getTimeInMillis());
        fgj();
      }
      fgi();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.HJY;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localLinearLayout.setVisibility(i);
        AppMethodBeat.o(159611);
        return;
      }
    }
  }
  
  public static abstract interface d {}
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */