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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker
  extends DatePicker
  implements DatePicker.OnDateChangedListener
{
  private NumberPicker ADj;
  private NumberPicker ADk;
  private NumberPicker ADl;
  private MMSpinnerDatePicker.a ADm;
  private int ADn;
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107914);
    this.ADn = 0;
    init();
    AppMethodBeat.o(107914);
  }
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107915);
    this.ADn = 0;
    init();
    AppMethodBeat.o(107915);
  }
  
  private void a(NumberPicker paramNumberPicker, int paramInt)
  {
    AppMethodBeat.i(107920);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(107920);
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
      AppMethodBeat.o(107920);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      AppMethodBeat.o(107920);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      AppMethodBeat.o(107920);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(107916);
    setCalendarViewShown(false);
    Object localObject = Resources.getSystem();
    int i = ((Resources)localObject).getIdentifier("year", "id", "android");
    int j = ((Resources)localObject).getIdentifier("month", "id", "android");
    int k = ((Resources)localObject).getIdentifier("day", "id", "android");
    this.ADj = ((NumberPicker)findViewById(i));
    this.ADk = ((NumberPicker)findViewById(j));
    this.ADl = ((NumberPicker)findViewById(k));
    localObject = getChildAt(0);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (LinearLayout.LayoutParams)this.ADj.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.ADj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ADk.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ADl.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setDescendantFocusability(393216);
    setPickerMode(2);
    AppMethodBeat.o(107916);
  }
  
  public final boolean dOG()
  {
    AppMethodBeat.i(107918);
    try
    {
      Field localField = NumberPicker.class.getDeclaredField("mSelectionDivider");
      localField.setAccessible(true);
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(getResources().getColor(2131690605));
      localField.set(this.ADj, localColorDrawable);
      localField.set(this.ADk, localColorDrawable);
      localField.set(this.ADl, localColorDrawable);
      invalidate();
      AppMethodBeat.o(107918);
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(107918);
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localNoSuchFieldException, "", new Object[0]);
      }
    }
  }
  
  public int getPickerMode()
  {
    return this.ADn;
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnDateChangeListener(MMSpinnerDatePicker.a parama)
  {
    this.ADm = parama;
  }
  
  public void setPickerMode(int paramInt)
  {
    AppMethodBeat.i(107917);
    this.ADn = paramInt;
    if (this.ADn == 0)
    {
      this.ADj.setVisibility(0);
      this.ADk.setVisibility(0);
      this.ADl.setVisibility(0);
      AppMethodBeat.o(107917);
      return;
    }
    if (this.ADn == 1)
    {
      this.ADj.setVisibility(0);
      this.ADk.setVisibility(0);
      this.ADl.setVisibility(8);
      AppMethodBeat.o(107917);
      return;
    }
    this.ADj.setVisibility(0);
    this.ADk.setVisibility(8);
    this.ADl.setVisibility(8);
    AppMethodBeat.o(107917);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(107919);
    a(this.ADj, paramInt);
    a(this.ADk, paramInt);
    a(this.ADl, paramInt);
    AppMethodBeat.o(107919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSpinnerDatePicker
 * JD-Core Version:    0.7.0.1
 */