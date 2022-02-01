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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.as;
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
  public final b QUb;
  
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
    this(paramContext, paramAttributeSet, 2130968918);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159633);
    this.QUb = new c(this, paramContext, paramAttributeSet, paramInt);
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
    this.QUb.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.QUb.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
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
    CalendarView localCalendarView = this.QUb.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.QUb.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.QUb.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.QUb.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.QUb.hcq().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.QUb.hcp().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.QUb.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.QUb.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  @Keep
  public b getUIDelegate()
  {
    return this.QUb;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.QUb.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.QUb.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.QUb.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.QUb.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.QUb.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.QUb.f(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.QUb.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.QUb.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.QUb.setEnabled(paramBoolean);
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
    this.QUb.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.QUb.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.QUb.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.QUb.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.QUb.setValidationCallback(parame);
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
    protected YADatePicker QUc;
    protected Locale QUd;
    protected YADatePicker.d QUe;
    protected YADatePicker.e QUf;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.QUc = paramYADatePicker;
      this.mContext = paramContext;
      f(Locale.getDefault());
    }
    
    protected void f(Locale paramLocale)
    {
      if (!paramLocale.equals(this.QUd)) {
        this.QUd = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.QUf = parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Parcelable f(Parcelable paramParcelable);
    
    public abstract CalendarView getCalendarView();
    
    public abstract boolean getCalendarViewShown();
    
    public abstract int getDayOfMonth();
    
    public abstract int getFirstDayOfWeek();
    
    public abstract int getMonth();
    
    public abstract boolean getSpinnersShown();
    
    public abstract int getYear();
    
    public abstract Calendar hcp();
    
    public abstract Calendar hcq();
    
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
    public final NumberPicker QUg;
    public final NumberPicker QUh;
    public final NumberPicker QUi;
    private final LinearLayout QUj;
    private final EditText QUk;
    private final EditText QUl;
    private final EditText QUm;
    private final CalendarView QUn;
    private final java.text.DateFormat QUo;
    private int QUp;
    private Calendar QUq;
    private Calendar QUr;
    Calendar QUs;
    private boolean QUt;
    Calendar ozj;
    private String[] ozk;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.QUo = new SimpleDateFormat("MM/dd/yyyy");
      this.QUt = true;
      this.QUc = paramYADatePicker;
      this.mContext = paramContext;
      f(Locale.getDefault());
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DatePicker, paramInt, 0);
      boolean bool1 = localTypedArray.getBoolean(16, true);
      boolean bool2 = localTypedArray.getBoolean(1, true);
      paramInt = localTypedArray.getInt(17, 1900);
      int i = localTypedArray.getInt(5, 2100);
      paramYADatePicker = localTypedArray.getString(15);
      paramAttributeSet = localTypedArray.getString(14);
      int j = localTypedArray.getResourceId(13, 2131493813);
      localTypedArray.recycle();
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.QUc, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.this.ozj.setTimeInMillis(YADatePicker.c.this.QUs.getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.QUg)
          {
            i = YADatePicker.c.this.ozj.getActualMaximum(5);
            if ((paramAnonymousInt1 == i) && (paramAnonymousInt2 == 1)) {
              YADatePicker.c.this.ozj.add(5, 1);
            }
          }
          for (;;)
          {
            YADatePicker.c.this.ba(YADatePicker.c.this.ozj.get(1), YADatePicker.c.this.ozj.get(2), YADatePicker.c.this.ozj.get(5));
            YADatePicker.c.this.hct();
            YADatePicker.c.this.hcu();
            YADatePicker.c.b(YADatePicker.c.this);
            AppMethodBeat.o(159594);
            return;
            if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == i))
            {
              YADatePicker.c.this.ozj.add(5, -1);
            }
            else
            {
              YADatePicker.c.this.ozj.add(5, paramAnonymousInt2 - paramAnonymousInt1);
              continue;
              if (paramAnonymousNumberPicker == YADatePicker.c.this.QUh)
              {
                if ((paramAnonymousInt1 == 11) && (paramAnonymousInt2 == 0)) {
                  YADatePicker.c.this.ozj.add(2, 1);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 11)) {
                  YADatePicker.c.this.ozj.add(2, -1);
                } else {
                  YADatePicker.c.this.ozj.add(2, paramAnonymousInt2 - paramAnonymousInt1);
                }
              }
              else
              {
                if (paramAnonymousNumberPicker != YADatePicker.c.this.QUi) {
                  break;
                }
                YADatePicker.c.this.ozj.set(1, paramAnonymousInt2);
              }
            }
          }
          paramAnonymousNumberPicker = new IllegalArgumentException();
          AppMethodBeat.o(159594);
          throw paramAnonymousNumberPicker;
        }
      };
      this.QUj = ((LinearLayout)this.QUc.findViewById(2131305939));
      this.QUn = ((CalendarView)this.QUc.findViewById(2131297950));
      this.QUn.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(159595);
          YADatePicker.c.this.ba(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          YADatePicker.c.this.hct();
          YADatePicker.c.b(YADatePicker.c.this);
          AppMethodBeat.o(159595);
        }
      });
      this.QUg = ((NumberPicker)this.QUc.findViewById(2131299421));
      this.QUg.setFormatter(new i());
      this.QUg.setOnLongPressUpdateInterval(100L);
      this.QUg.setOnValueChangedListener(paramContext);
      this.QUk = f.b(this.QUg);
      this.QUh = ((NumberPicker)this.QUc.findViewById(2131304853));
      this.QUh.setMinValue(0);
      this.QUh.setMaxValue(this.QUp - 1);
      this.QUh.setDisplayedValues(this.ozk);
      this.QUh.setOnLongPressUpdateInterval(200L);
      this.QUh.setOnValueChangedListener(paramContext);
      this.QUl = f.b(this.QUh);
      this.QUi = ((NumberPicker)this.QUc.findViewById(2131310679));
      this.QUi.setOnLongPressUpdateInterval(100L);
      this.QUi.setOnValueChangedListener(paramContext);
      this.QUm = f.b(this.QUi);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.ozj.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.ozj))) {
          this.ozj.set(paramInt, 0, 1);
        }
        setMinDate(this.ozj.getTimeInMillis());
        this.ozj.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.ozj))) {
          this.ozj.set(i, 11, 31);
        }
        setMaxDate(this.ozj.getTimeInMillis());
        this.QUs.setTimeInMillis(System.currentTimeMillis());
        a(this.QUs.get(1), this.QUs.get(2), this.QUs.get(5), null);
        hcs();
        if (this.QUc.getImportantForAccessibility() == 0) {
          this.QUc.setImportantForAccessibility(1);
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
        paramCalendar.setTime(this.QUo.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        as.w(YADatePicker.hco(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private boolean hcr()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.ozk[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void hcs()
    {
      AppMethodBeat.i(159620);
      this.QUj.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.QUc.getLayoutDirection() == 0))
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
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.QUc.getContext());
        }
      }
      this.QUj.addView(this.QUg);
      a(this.QUg, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.QUj.addView(this.QUh);
        a(this.QUh, j, i);
        continue;
        this.QUj.addView(this.QUi);
        a(this.QUi, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      ba(paramInt1, paramInt2, paramInt3);
      hct();
      hcu();
      this.QUe = paramd;
      AppMethodBeat.o(159597);
    }
    
    final void ba(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.QUs.set(paramInt1, paramInt2, paramInt3);
      if (this.QUs.before(this.QUq))
      {
        this.QUs.setTimeInMillis(this.QUq.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.QUs.after(this.QUr)) {
        this.QUs.setTimeInMillis(this.QUr.getTimeInMillis());
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
    
    protected final void f(Locale paramLocale)
    {
      AppMethodBeat.i(159617);
      super.f(paramLocale);
      this.ozj = a(this.ozj, paramLocale);
      this.QUq = a(this.QUq, paramLocale);
      this.QUr = a(this.QUr, paramLocale);
      this.QUs = a(this.QUs, paramLocale);
      this.QUp = (this.ozj.getActualMaximum(2) + 1);
      this.ozk = new DateFormatSymbols().getShortMonths();
      if (hcr())
      {
        this.ozk = new String[this.QUp];
        int i = 0;
        while (i < this.QUp)
        {
          this.ozk[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.QUn;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.QUn.getVisibility() == 0)
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
      int i = this.QUs.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.QUn.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.QUs.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.QUj.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.QUs.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final Calendar hcp()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.QUn.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar hcq()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.QUn.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
    }
    
    final void hct()
    {
      AppMethodBeat.i(159623);
      if (this.QUs.equals(this.QUq))
      {
        this.QUg.setMinValue(this.QUs.get(5));
        this.QUg.setMaxValue(this.QUs.getActualMaximum(5));
        this.QUg.setWrapSelectorWheel(false);
        this.QUh.setDisplayedValues(null);
        this.QUh.setMinValue(this.QUs.get(2));
        this.QUh.setMaxValue(this.QUs.getActualMaximum(2));
        this.QUh.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.ozk, this.QUh.getMinValue(), this.QUh.getMaxValue() + 1);
        this.QUh.setDisplayedValues(arrayOfString);
        this.QUi.setMinValue(this.QUq.get(1));
        this.QUi.setMaxValue(this.QUr.get(1));
        this.QUi.setWrapSelectorWheel(false);
        this.QUi.setValue(this.QUs.get(1));
        this.QUh.setValue(this.QUs.get(2));
        this.QUg.setValue(this.QUs.get(5));
        if (hcr()) {
          this.QUl.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.QUs.equals(this.QUr))
        {
          this.QUg.setMinValue(this.QUs.getActualMinimum(5));
          this.QUg.setMaxValue(this.QUs.get(5));
          this.QUg.setWrapSelectorWheel(false);
          this.QUh.setDisplayedValues(null);
          this.QUh.setMinValue(this.QUs.getActualMinimum(2));
          this.QUh.setMaxValue(this.QUs.get(2));
          this.QUh.setWrapSelectorWheel(false);
        }
        else
        {
          this.QUg.setMinValue(1);
          this.QUg.setMaxValue(this.QUs.getActualMaximum(5));
          this.QUg.setWrapSelectorWheel(true);
          this.QUh.setDisplayedValues(null);
          this.QUh.setMinValue(0);
          this.QUh.setMaxValue(11);
          this.QUh.setWrapSelectorWheel(true);
        }
      }
    }
    
    final void hcu()
    {
      AppMethodBeat.i(159624);
      this.QUn.setDate(this.QUs.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    public final boolean isEnabled()
    {
      return this.QUt;
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration)
    {
      AppMethodBeat.i(159612);
      f(paramConfiguration.locale);
      AppMethodBeat.o(159612);
    }
    
    public final void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(159616);
      String str = DateUtils.formatDateTime(this.mContext, this.QUs.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      ba(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      hct();
      hcu();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.QUn;
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
      this.QUg.setEnabled(paramBoolean);
      this.QUh.setEnabled(paramBoolean);
      this.QUi.setEnabled(paramBoolean);
      this.QUn.setEnabled(paramBoolean);
      this.QUt = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.QUn.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.ozj.setTimeInMillis(paramLong);
      if ((this.ozj.get(1) == this.QUr.get(1)) && (this.ozj.get(6) != this.QUr.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.QUr.setTimeInMillis(paramLong);
      this.QUn.setMaxDate(paramLong);
      if (this.QUs.after(this.QUr))
      {
        this.QUs.setTimeInMillis(this.QUr.getTimeInMillis());
        hcu();
      }
      hct();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.ozj.setTimeInMillis(paramLong);
      if ((this.ozj.get(1) == this.QUq.get(1)) && (this.ozj.get(6) != this.QUq.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.QUq.setTimeInMillis(paramLong);
      this.QUn.setMinDate(paramLong);
      if (this.QUs.before(this.QUq))
      {
        this.QUs.setTimeInMillis(this.QUq.getTimeInMillis());
        hcu();
      }
      hct();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.QUj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */