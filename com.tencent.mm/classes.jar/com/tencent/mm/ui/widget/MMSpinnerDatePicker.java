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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker
  extends DatePicker
  implements DatePicker.OnDateChangedListener
{
  private NumberPicker Jan;
  private NumberPicker Jao;
  private NumberPicker Jap;
  private a Jaq;
  private int Jar;
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143397);
    this.Jar = 0;
    init();
    AppMethodBeat.o(143397);
  }
  
  public MMSpinnerDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143398);
    this.Jar = 0;
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
      ac.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
      AppMethodBeat.o(143403);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      ac.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", paramNumberPicker, "", new Object[0]);
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
    this.Jan = ((NumberPicker)findViewById(i));
    this.Jao = ((NumberPicker)findViewById(j));
    this.Jap = ((NumberPicker)findViewById(k));
    localObject = getChildAt(0);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = -1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = (LinearLayout.LayoutParams)this.Jan.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.Jan.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Jao.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Jap.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setDescendantFocusability(393216);
    setPickerMode(2);
    AppMethodBeat.o(143399);
  }
  
  public final boolean fuH()
  {
    AppMethodBeat.i(143401);
    try
    {
      Field localField = NumberPicker.class.getDeclaredField("mSelectionDivider");
      localField.setAccessible(true);
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(getResources().getColor(2131101053));
      localField.set(this.Jan, localColorDrawable);
      localField.set(this.Jao, localColorDrawable);
      localField.set(this.Jap, localColorDrawable);
      invalidate();
      AppMethodBeat.o(143401);
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ac.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localIllegalAccessException, "", new Object[0]);
      AppMethodBeat.o(143401);
      return false;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", localNoSuchFieldException, "", new Object[0]);
      }
    }
  }
  
  public int getPickerMode()
  {
    return this.Jar;
  }
  
  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnDateChangeListener(a parama)
  {
    this.Jaq = parama;
  }
  
  public void setPickerMode(int paramInt)
  {
    AppMethodBeat.i(143400);
    this.Jar = paramInt;
    if (this.Jar == 0)
    {
      this.Jan.setVisibility(0);
      this.Jao.setVisibility(0);
      this.Jap.setVisibility(0);
      AppMethodBeat.o(143400);
      return;
    }
    if (this.Jar == 1)
    {
      this.Jan.setVisibility(0);
      this.Jao.setVisibility(0);
      this.Jap.setVisibility(8);
      AppMethodBeat.o(143400);
      return;
    }
    this.Jan.setVisibility(0);
    this.Jao.setVisibility(8);
    this.Jap.setVisibility(8);
    AppMethodBeat.o(143400);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(143402);
    a(this.Jan, paramInt);
    a(this.Jao, paramInt);
    a(this.Jap, paramInt);
    AppMethodBeat.o(143402);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSpinnerDatePicker
 * JD-Core Version:    0.7.0.1
 */