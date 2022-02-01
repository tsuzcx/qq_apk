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
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker
  extends DatePicker
  implements DatePicker.OnDateChangedListener
{
  private NumberPicker LnW;
  private NumberPicker LnX;
  private NumberPicker LnY;
  private a LnZ;
  private int Loa;
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143397);
    this.Loa = 0;
    init();
    AppMethodBeat.o(143397);
  }
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143398);
    this.Loa = 0;
    init();
    AppMethodBeat.o(143398);
  }
  
  private void a(NumberPicker paramNumberPicker, int paramInt)
  {
    AppMethodBeat.i(143403);
    if (paramNumberPicker == null)
    {
      AppMethodBeat.o(143403);
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
      AppMethodBeat.o(143403);
      return;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      ae.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      AppMethodBeat.o(143403);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ae.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      AppMethodBeat.o(143403);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(143399);
    setCalendarViewShown(false);
    Object localObject = Resources.getSystem();
    int i = ((Resources)localObject).getIdentifier("year", "id", "android");
    int j = ((Resources)localObject).getIdentifier("month", "id", "android");
    int k = ((Resources)localObject).getIdentifier("day", "id", "android");
    this.LnW = ((NumberPicker)findViewById(i));
    this.LnX = ((NumberPicker)findViewById(j));
    this.LnY = ((NumberPicker)findViewById(k));
    localObject = getChildAt(0);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (LinearLayout.LayoutParams)this.LnW.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.LnW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.LnX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.LnY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setDescendantFocusability(393216);
    setPickerMode(2);
    AppMethodBeat.o(143399);
  }
  
  public final boolean fPO()
  {
    AppMethodBeat.i(143401);
    try
    {
      Field localField = NumberPicker.class.getDeclaredField("mSelectionDivider");
      localField.setAccessible(true);
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(getResources().getColor(2131101053));
      localField.set(this.LnW, localColorDrawable);
      localField.set(this.LnX, localColorDrawable);
      localField.set(this.LnY, localColorDrawable);
      invalidate();
      AppMethodBeat.o(143401);
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ae.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(143401);
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localNoSuchFieldException, "", new Object[0]);
      }
    }
  }
  
  public int getPickerMode()
  {
    return this.Loa;
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnDateChangeListener(a parama)
  {
    this.LnZ = parama;
  }
  
  public void setPickerMode(int paramInt)
  {
    AppMethodBeat.i(143400);
    this.Loa = paramInt;
    if (this.Loa == 0)
    {
      this.LnW.setVisibility(0);
      this.LnX.setVisibility(0);
      this.LnY.setVisibility(0);
      AppMethodBeat.o(143400);
      return;
    }
    if (this.Loa == 1)
    {
      this.LnW.setVisibility(0);
      this.LnX.setVisibility(0);
      this.LnY.setVisibility(8);
      AppMethodBeat.o(143400);
      return;
    }
    this.LnW.setVisibility(0);
    this.LnX.setVisibility(8);
    this.LnY.setVisibility(8);
    AppMethodBeat.o(143400);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(143402);
    a(this.LnW, paramInt);
    a(this.LnX, paramInt);
    a(this.LnY, paramInt);
    AppMethodBeat.o(143402);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSpinnerDatePicker
 * JD-Core Version:    0.7.0.1
 */