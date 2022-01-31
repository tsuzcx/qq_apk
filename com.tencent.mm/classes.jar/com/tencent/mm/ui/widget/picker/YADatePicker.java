package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import com.tencent.mm.ci.a.b;
import com.tencent.mm.ci.a.k;
import java.util.Calendar;

public class YADatePicker
  extends FrameLayout
{
  private static final String LT = YADatePicker.class.getSimpleName();
  public final YADatePicker.b woO;
  
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
    this.woO = new YADatePicker.c(this, paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.DatePicker, paramInt, 0);
    paramInt = paramContext.getInt(a.k.DatePicker_firstDayOfWeek, 0);
    paramContext.recycle();
    if (paramInt != 0) {
      setFirstDayOfWeek(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    this.woO.a(paramInt1, paramInt2, paramInt3, paramd);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.woO.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return YADatePicker.class.getName();
  }
  
  public CalendarView getCalendarView()
  {
    return this.woO.getCalendarView();
  }
  
  public boolean getCalendarViewShown()
  {
    return this.woO.getCalendarViewShown();
  }
  
  public int getDayOfMonth()
  {
    return this.woO.getDayOfMonth();
  }
  
  public int getFirstDayOfWeek()
  {
    return this.woO.getFirstDayOfWeek();
  }
  
  public long getMaxDate()
  {
    return this.woO.cKo().getTimeInMillis();
  }
  
  public long getMinDate()
  {
    return this.woO.cKn().getTimeInMillis();
  }
  
  public int getMonth()
  {
    return this.woO.getMonth();
  }
  
  public boolean getSpinnersShown()
  {
    return this.woO.getSpinnersShown();
  }
  
  @Keep
  public YADatePicker.b getUIDelegate()
  {
    return this.woO;
  }
  
  public int getYear()
  {
    return this.woO.getYear();
  }
  
  public boolean isEnabled()
  {
    return this.woO.isEnabled();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.woO.onConfigurationChanged(paramConfiguration);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.woO.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.woO.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    return this.woO.c(localParcelable);
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    this.woO.setCalendarViewShown(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.woO.isEnabled() == paramBoolean) {
      return;
    }
    super.setEnabled(paramBoolean);
    this.woO.setEnabled(paramBoolean);
  }
  
  public void setFirstDayOfWeek(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 7)) {
      throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
    }
    this.woO.setFirstDayOfWeek(paramInt);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.woO.setMaxDate(paramLong);
  }
  
  public void setMinDate(long paramLong)
  {
    this.woO.setMinDate(paramLong);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    this.woO.setSpinnersShown(paramBoolean);
  }
  
  public void setValidationCallback(YADatePicker.e parame)
  {
    this.woO.setValidationCallback(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */