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
import com.tencent.mm.ui.ap;
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
  public final b LbK;
  
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
    this.LbK = new c(this, paramContext, paramAttributeSet, paramInt);
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
    this.LbK.a(paramInt1, paramInt2, paramInt3, paramd);
    AppMethodBeat.o(159634);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159645);
    boolean bool = this.LbK.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
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
    CalendarView localCalendarView = this.LbK.getCalendarView();
    AppMethodBeat.o(159653);
    return localCalendarView;
  }
  
  public boolean getCalendarViewShown()
  {
    AppMethodBeat.i(159651);
    boolean bool = this.LbK.getCalendarViewShown();
    AppMethodBeat.o(159651);
    return bool;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(159637);
    int i = this.LbK.getDayOfMonth();
    AppMethodBeat.o(159637);
    return i;
  }
  
  public int getFirstDayOfWeek()
  {
    AppMethodBeat.i(159649);
    int i = this.LbK.getFirstDayOfWeek();
    AppMethodBeat.o(159649);
    return i;
  }
  
  public long getMaxDate()
  {
    AppMethodBeat.i(159640);
    long l = this.LbK.fMT().getTimeInMillis();
    AppMethodBeat.o(159640);
    return l;
  }
  
  public long getMinDate()
  {
    AppMethodBeat.i(159638);
    long l = this.LbK.fMS().getTimeInMillis();
    AppMethodBeat.o(159638);
    return l;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(159636);
    int i = this.LbK.getMonth();
    AppMethodBeat.o(159636);
    return i;
  }
  
  public boolean getSpinnersShown()
  {
    AppMethodBeat.i(159654);
    boolean bool = this.LbK.getSpinnersShown();
    AppMethodBeat.o(159654);
    return bool;
  }
  
  @Keep
  public b getUIDelegate()
  {
    return this.LbK;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(159635);
    int i = this.LbK.getYear();
    AppMethodBeat.o(159635);
    return i;
  }
  
  public boolean isEnabled()
  {
    AppMethodBeat.i(159643);
    boolean bool = this.LbK.isEnabled();
    AppMethodBeat.o(159643);
    return bool;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(159648);
    super.onConfigurationChanged(paramConfiguration);
    this.LbK.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(159648);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(159646);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.LbK.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(159646);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159658);
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.LbK.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159658);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(159657);
    Parcelable localParcelable = super.onSaveInstanceState();
    localParcelable = this.LbK.f(localParcelable);
    AppMethodBeat.o(159657);
    return localParcelable;
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159652);
    this.LbK.setCalendarViewShown(paramBoolean);
    AppMethodBeat.o(159652);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(159644);
    if (this.LbK.isEnabled() == paramBoolean)
    {
      AppMethodBeat.o(159644);
      return;
    }
    super.setEnabled(paramBoolean);
    this.LbK.setEnabled(paramBoolean);
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
    this.LbK.setFirstDayOfWeek(paramInt);
    AppMethodBeat.o(159650);
  }
  
  public void setMaxDate(long paramLong)
  {
    AppMethodBeat.i(159641);
    this.LbK.setMaxDate(paramLong);
    AppMethodBeat.o(159641);
  }
  
  public void setMinDate(long paramLong)
  {
    AppMethodBeat.i(159639);
    this.LbK.setMinDate(paramLong);
    AppMethodBeat.o(159639);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    AppMethodBeat.i(159655);
    this.LbK.setSpinnersShown(paramBoolean);
    AppMethodBeat.o(159655);
  }
  
  public void setValidationCallback(e parame)
  {
    AppMethodBeat.i(159642);
    this.LbK.setValidationCallback(parame);
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
    protected YADatePicker LbL;
    protected Locale LbM;
    protected YADatePicker.d LbN;
    protected YADatePicker.e LbO;
    protected Context mContext;
    
    protected a(YADatePicker paramYADatePicker, Context paramContext)
    {
      this.LbL = paramYADatePicker;
      this.mContext = paramContext;
      g(Locale.getDefault());
    }
    
    protected void g(Locale paramLocale)
    {
      if (!paramLocale.equals(this.LbM)) {
        this.LbM = paramLocale;
      }
    }
    
    public void setValidationCallback(YADatePicker.e parame)
    {
      this.LbO = parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Parcelable f(Parcelable paramParcelable);
    
    public abstract Calendar fMS();
    
    public abstract Calendar fMT();
    
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
    public final NumberPicker LbP;
    public final NumberPicker LbQ;
    public final NumberPicker LbR;
    private final LinearLayout LbS;
    private final EditText LbT;
    private final EditText LbU;
    private final EditText LbV;
    private final CalendarView LbW;
    private final java.text.DateFormat LbX;
    private int LbY;
    private Calendar LbZ;
    private Calendar Lca;
    Calendar Lcb;
    private boolean Lcc;
    Calendar nku;
    private String[] nkv;
    
    c(YADatePicker paramYADatePicker, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramContext);
      AppMethodBeat.i(159596);
      this.LbX = new SimpleDateFormat("MM/dd/yyyy");
      this.Lcc = true;
      this.LbL = paramYADatePicker;
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
      ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(j, this.LbL, true);
      paramContext = new NumberPicker.OnValueChangeListener()
      {
        public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(159594);
          YADatePicker.c.a(YADatePicker.c.this);
          YADatePicker.c.this.nku.setTimeInMillis(YADatePicker.c.this.Lcb.getTimeInMillis());
          int i;
          if (paramAnonymousNumberPicker == YADatePicker.c.this.LbP)
          {
            i = YADatePicker.c.this.nku.getActualMaximum(5);
            if ((paramAnonymousInt1 == i) && (paramAnonymousInt2 == 1)) {
              YADatePicker.c.this.nku.add(5, 1);
            }
          }
          for (;;)
          {
            YADatePicker.c.this.aS(YADatePicker.c.this.nku.get(1), YADatePicker.c.this.nku.get(2), YADatePicker.c.this.nku.get(5));
            YADatePicker.c.this.fMW();
            YADatePicker.c.this.fMX();
            YADatePicker.c.b(YADatePicker.c.this);
            AppMethodBeat.o(159594);
            return;
            if ((paramAnonymousInt1 == 1) && (paramAnonymousInt2 == i))
            {
              YADatePicker.c.this.nku.add(5, -1);
            }
            else
            {
              YADatePicker.c.this.nku.add(5, paramAnonymousInt2 - paramAnonymousInt1);
              continue;
              if (paramAnonymousNumberPicker == YADatePicker.c.this.LbQ)
              {
                if ((paramAnonymousInt1 == 11) && (paramAnonymousInt2 == 0)) {
                  YADatePicker.c.this.nku.add(2, 1);
                } else if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 11)) {
                  YADatePicker.c.this.nku.add(2, -1);
                } else {
                  YADatePicker.c.this.nku.add(2, paramAnonymousInt2 - paramAnonymousInt1);
                }
              }
              else
              {
                if (paramAnonymousNumberPicker != YADatePicker.c.this.LbR) {
                  break;
                }
                YADatePicker.c.this.nku.set(1, paramAnonymousInt2);
              }
            }
          }
          paramAnonymousNumberPicker = new IllegalArgumentException();
          AppMethodBeat.o(159594);
          throw paramAnonymousNumberPicker;
        }
      };
      this.LbS = ((LinearLayout)this.LbL.findViewById(2131303267));
      this.LbW = ((CalendarView)this.LbL.findViewById(2131297679));
      this.LbW.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public final void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(159595);
          YADatePicker.c.this.aS(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          YADatePicker.c.this.fMW();
          YADatePicker.c.b(YADatePicker.c.this);
          AppMethodBeat.o(159595);
        }
      });
      this.LbP = ((NumberPicker)this.LbL.findViewById(2131298935));
      this.LbP.setFormatter(new i());
      this.LbP.setOnLongPressUpdateInterval(100L);
      this.LbP.setOnValueChangedListener(paramContext);
      this.LbT = f.b(this.LbP);
      this.LbQ = ((NumberPicker)this.LbL.findViewById(2131302450));
      this.LbQ.setMinValue(0);
      this.LbQ.setMaxValue(this.LbY - 1);
      this.LbQ.setDisplayedValues(this.nkv);
      this.LbQ.setOnLongPressUpdateInterval(200L);
      this.LbQ.setOnValueChangedListener(paramContext);
      this.LbU = f.b(this.LbQ);
      this.LbR = ((NumberPicker)this.LbL.findViewById(2131307138));
      this.LbR.setOnLongPressUpdateInterval(100L);
      this.LbR.setOnValueChangedListener(paramContext);
      this.LbV = f.b(this.LbR);
      if ((!bool1) && (!bool2)) {
        setSpinnersShown(true);
      }
      for (;;)
      {
        this.nku.clear();
        if ((TextUtils.isEmpty(paramYADatePicker)) || (!a(paramYADatePicker, this.nku))) {
          this.nku.set(paramInt, 0, 1);
        }
        setMinDate(this.nku.getTimeInMillis());
        this.nku.clear();
        if ((TextUtils.isEmpty(paramAttributeSet)) || (!a(paramAttributeSet, this.nku))) {
          this.nku.set(i, 11, 31);
        }
        setMaxDate(this.nku.getTimeInMillis());
        this.Lcb.setTimeInMillis(System.currentTimeMillis());
        a(this.Lcb.get(1), this.Lcb.get(2), this.Lcb.get(5), null);
        fMV();
        if (this.LbL.getImportantForAccessibility() == 0) {
          this.LbL.setImportantForAccessibility(1);
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
        paramCalendar.setTime(this.LbX.parse(paramString));
        AppMethodBeat.o(159621);
        return true;
      }
      catch (ParseException paramCalendar)
      {
        ap.w(YADatePicker.fMR(), "Date: " + paramString + " not in format: MM/dd/yyyy", new Object[0]);
        AppMethodBeat.o(159621);
      }
      return false;
    }
    
    private boolean fMU()
    {
      AppMethodBeat.i(159618);
      boolean bool = Character.isDigit(this.nkv[0].charAt(0));
      AppMethodBeat.o(159618);
      return bool;
    }
    
    private void fMV()
    {
      AppMethodBeat.i(159620);
      this.LbS.removeAllViews();
      Object localObject;
      if ((Build.VERSION.SDK_INT < 17) || (this.LbL.getLayoutDirection() == 0))
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
          localObject = android.text.format.DateFormat.getDateFormatOrder(this.LbL.getContext());
        }
      }
      this.LbS.addView(this.LbP);
      a(this.LbP, j, i);
      for (;;)
      {
        i += 1;
        break;
        this.LbS.addView(this.LbQ);
        a(this.LbQ, j, i);
        continue;
        this.LbS.addView(this.LbR);
        a(this.LbR, j, i);
      }
      AppMethodBeat.o(159620);
    }
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
    {
      AppMethodBeat.i(159597);
      aS(paramInt1, paramInt2, paramInt3);
      fMW();
      fMX();
      this.LbN = paramd;
      AppMethodBeat.o(159597);
    }
    
    final void aS(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(159622);
      this.Lcb.set(paramInt1, paramInt2, paramInt3);
      if (this.Lcb.before(this.LbZ))
      {
        this.Lcb.setTimeInMillis(this.LbZ.getTimeInMillis());
        AppMethodBeat.o(159622);
        return;
      }
      if (this.Lcb.after(this.Lca)) {
        this.Lcb.setTimeInMillis(this.Lca.getTimeInMillis());
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
    
    public final Calendar fMS()
    {
      AppMethodBeat.i(159603);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.LbW.getMinDate());
      AppMethodBeat.o(159603);
      return localCalendar;
    }
    
    public final Calendar fMT()
    {
      AppMethodBeat.i(159605);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(this.LbW.getMaxDate());
      AppMethodBeat.o(159605);
      return localCalendar;
    }
    
    final void fMW()
    {
      AppMethodBeat.i(159623);
      if (this.Lcb.equals(this.LbZ))
      {
        this.LbP.setMinValue(this.Lcb.get(5));
        this.LbP.setMaxValue(this.Lcb.getActualMaximum(5));
        this.LbP.setWrapSelectorWheel(false);
        this.LbQ.setDisplayedValues(null);
        this.LbQ.setMinValue(this.Lcb.get(2));
        this.LbQ.setMaxValue(this.Lcb.getActualMaximum(2));
        this.LbQ.setWrapSelectorWheel(false);
      }
      for (;;)
      {
        String[] arrayOfString = (String[])Arrays.copyOfRange(this.nkv, this.LbQ.getMinValue(), this.LbQ.getMaxValue() + 1);
        this.LbQ.setDisplayedValues(arrayOfString);
        this.LbR.setMinValue(this.LbZ.get(1));
        this.LbR.setMaxValue(this.Lca.get(1));
        this.LbR.setWrapSelectorWheel(false);
        this.LbR.setValue(this.Lcb.get(1));
        this.LbQ.setValue(this.Lcb.get(2));
        this.LbP.setValue(this.Lcb.get(5));
        if (fMU()) {
          this.LbU.setRawInputType(2);
        }
        AppMethodBeat.o(159623);
        return;
        if (this.Lcb.equals(this.Lca))
        {
          this.LbP.setMinValue(this.Lcb.getActualMinimum(5));
          this.LbP.setMaxValue(this.Lcb.get(5));
          this.LbP.setWrapSelectorWheel(false);
          this.LbQ.setDisplayedValues(null);
          this.LbQ.setMinValue(this.Lcb.getActualMinimum(2));
          this.LbQ.setMaxValue(this.Lcb.get(2));
          this.LbQ.setWrapSelectorWheel(false);
        }
        else
        {
          this.LbP.setMinValue(1);
          this.LbP.setMaxValue(this.Lcb.getActualMaximum(5));
          this.LbP.setWrapSelectorWheel(true);
          this.LbQ.setDisplayedValues(null);
          this.LbQ.setMinValue(0);
          this.LbQ.setMaxValue(11);
          this.LbQ.setWrapSelectorWheel(true);
        }
      }
    }
    
    final void fMX()
    {
      AppMethodBeat.i(159624);
      this.LbW.setDate(this.Lcb.getTimeInMillis(), false, false);
      AppMethodBeat.o(159624);
    }
    
    protected final void g(Locale paramLocale)
    {
      AppMethodBeat.i(159617);
      super.g(paramLocale);
      this.nku = a(this.nku, paramLocale);
      this.LbZ = a(this.LbZ, paramLocale);
      this.Lca = a(this.Lca, paramLocale);
      this.Lcb = a(this.Lcb, paramLocale);
      this.LbY = (this.nku.getActualMaximum(2) + 1);
      this.nkv = new DateFormatSymbols().getShortMonths();
      if (fMU())
      {
        this.nkv = new String[this.LbY];
        int i = 0;
        while (i < this.LbY)
        {
          this.nkv[i] = String.format("%d", new Object[] { Integer.valueOf(i + 1) });
          i += 1;
        }
      }
      AppMethodBeat.o(159617);
    }
    
    public final CalendarView getCalendarView()
    {
      return this.LbW;
    }
    
    public final boolean getCalendarViewShown()
    {
      AppMethodBeat.i(159608);
      if (this.LbW.getVisibility() == 0)
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
      int i = this.Lcb.get(5);
      AppMethodBeat.o(159600);
      return i;
    }
    
    public final int getFirstDayOfWeek()
    {
      AppMethodBeat.i(159601);
      int i = this.LbW.getFirstDayOfWeek();
      AppMethodBeat.o(159601);
      return i;
    }
    
    public final int getMonth()
    {
      AppMethodBeat.i(159599);
      int i = this.Lcb.get(2);
      AppMethodBeat.o(159599);
      return i;
    }
    
    public final boolean getSpinnersShown()
    {
      AppMethodBeat.i(159610);
      boolean bool = this.LbS.isShown();
      AppMethodBeat.o(159610);
      return bool;
    }
    
    public final int getYear()
    {
      AppMethodBeat.i(159598);
      int i = this.Lcb.get(1);
      AppMethodBeat.o(159598);
      return i;
    }
    
    public final boolean isEnabled()
    {
      return this.Lcc;
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
      String str = DateUtils.formatDateTime(this.mContext, this.Lcb.getTimeInMillis(), 20);
      paramAccessibilityEvent.getText().add(str);
      AppMethodBeat.o(159616);
    }
    
    public final void onRestoreInstanceState(Parcelable paramParcelable)
    {
      AppMethodBeat.i(159614);
      paramParcelable = (YADatePicker.SavedState)paramParcelable;
      aS(YADatePicker.SavedState.a(paramParcelable), YADatePicker.SavedState.b(paramParcelable), YADatePicker.SavedState.c(paramParcelable));
      fMW();
      fMX();
      AppMethodBeat.o(159614);
    }
    
    public final void setCalendarViewShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159609);
      CalendarView localCalendarView = this.LbW;
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
      this.LbP.setEnabled(paramBoolean);
      this.LbQ.setEnabled(paramBoolean);
      this.LbR.setEnabled(paramBoolean);
      this.LbW.setEnabled(paramBoolean);
      this.Lcc = paramBoolean;
      AppMethodBeat.o(159607);
    }
    
    public final void setFirstDayOfWeek(int paramInt)
    {
      AppMethodBeat.i(159602);
      this.LbW.setFirstDayOfWeek(paramInt);
      AppMethodBeat.o(159602);
    }
    
    public final void setMaxDate(long paramLong)
    {
      AppMethodBeat.i(159606);
      this.nku.setTimeInMillis(paramLong);
      if ((this.nku.get(1) == this.Lca.get(1)) && (this.nku.get(6) != this.Lca.get(6)))
      {
        AppMethodBeat.o(159606);
        return;
      }
      this.Lca.setTimeInMillis(paramLong);
      this.LbW.setMaxDate(paramLong);
      if (this.Lcb.after(this.Lca))
      {
        this.Lcb.setTimeInMillis(this.Lca.getTimeInMillis());
        fMX();
      }
      fMW();
      AppMethodBeat.o(159606);
    }
    
    public final void setMinDate(long paramLong)
    {
      AppMethodBeat.i(159604);
      this.nku.setTimeInMillis(paramLong);
      if ((this.nku.get(1) == this.LbZ.get(1)) && (this.nku.get(6) != this.LbZ.get(6)))
      {
        AppMethodBeat.o(159604);
        return;
      }
      this.LbZ.setTimeInMillis(paramLong);
      this.LbW.setMinDate(paramLong);
      if (this.Lcb.before(this.LbZ))
      {
        this.Lcb.setTimeInMillis(this.LbZ.getTimeInMillis());
        fMX();
      }
      fMW();
      AppMethodBeat.o(159604);
    }
    
    public final void setSpinnersShown(boolean paramBoolean)
    {
      AppMethodBeat.i(159611);
      LinearLayout localLinearLayout = this.LbS;
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