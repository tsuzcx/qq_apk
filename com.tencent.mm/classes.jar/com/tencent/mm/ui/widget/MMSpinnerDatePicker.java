package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker
  extends DatePicker
  implements DatePicker.OnDateChangedListener
{
  private NumberPicker wjC;
  private NumberPicker wjD;
  private NumberPicker wjE;
  private MMSpinnerDatePicker.a wjF;
  private int wjG = 0;
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(NumberPicker paramNumberPicker, int paramInt)
  {
    if (paramNumberPicker == null) {
      return;
    }
    Object localObject = (EditText)paramNumberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"));
    ((EditText)localObject).setTextSize(0, getResources().getDimension(paramInt));
    paramInt = (int)((EditText)localObject).getTextSize();
    try
    {
      localObject = NumberPicker.class.getDeclaredField("mTextSize");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(paramNumberPicker, Integer.valueOf(paramInt));
      localObject = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
      ((Field)localObject).setAccessible(true);
      Paint localPaint = (Paint)((Field)localObject).get(paramNumberPicker);
      localPaint.setTextSize(paramInt);
      ((Field)localObject).set(paramNumberPicker, localPaint);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      y.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      y.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
    }
  }
  
  private void init()
  {
    setCalendarViewShown(false);
    Object localObject = Resources.getSystem();
    int i = ((Resources)localObject).getIdentifier("year", "id", "android");
    int j = ((Resources)localObject).getIdentifier("month", "id", "android");
    int k = ((Resources)localObject).getIdentifier("day", "id", "android");
    this.wjC = ((NumberPicker)findViewById(i));
    this.wjD = ((NumberPicker)findViewById(j));
    this.wjE = ((NumberPicker)findViewById(k));
    localObject = getChildAt(0);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (LinearLayout.LayoutParams)this.wjC.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.wjC.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wjD.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.wjE.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setDescendantFocusability(393216);
    setPickerMode(2);
  }
  
  public final boolean Il(int paramInt)
  {
    try
    {
      Field localField = NumberPicker.class.getDeclaredField("mSelectionDivider");
      localField.setAccessible(true);
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(getResources().getColor(paramInt));
      localField.set(this.wjC, localColorDrawable);
      localField.set(this.wjD, localColorDrawable);
      localField.set(this.wjE, localColorDrawable);
      invalidate();
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      y.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localIllegalAccessException, "", new Object[0]);
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localNoSuchFieldException, "", new Object[0]);
      }
    }
  }
  
  public int getPickerMode()
  {
    return this.wjG;
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnDateChangeListener(MMSpinnerDatePicker.a parama)
  {
    this.wjF = parama;
  }
  
  public void setPickerMode(int paramInt)
  {
    this.wjG = paramInt;
    if (this.wjG == 0)
    {
      this.wjC.setVisibility(0);
      this.wjD.setVisibility(0);
      this.wjE.setVisibility(0);
      return;
    }
    if (this.wjG == 1)
    {
      this.wjC.setVisibility(0);
      this.wjD.setVisibility(0);
      this.wjE.setVisibility(8);
      return;
    }
    this.wjC.setVisibility(0);
    this.wjD.setVisibility(8);
    this.wjE.setVisibility(8);
  }
  
  public void setTextSize(int paramInt)
  {
    a(this.wjC, paramInt);
    a(this.wjD, paramInt);
    a(this.wjE, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSpinnerDatePicker
 * JD-Core Version:    0.7.0.1
 */