package com.tencent.mm.ui.widget.picker;

import android.content.res.Configuration;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import java.util.Calendar;

public abstract interface YADatePicker$b
{
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd);
  
  public abstract Parcelable c(Parcelable paramParcelable);
  
  public abstract Calendar cKn();
  
  public abstract Calendar cKo();
  
  public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.b
 * JD-Core Version:    0.7.0.1
 */