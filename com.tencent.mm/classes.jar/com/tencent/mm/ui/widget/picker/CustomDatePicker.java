package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.ci.a.e;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  public boolean hzK = true;
  public boolean hzL = true;
  NumberPicker hzM;
  NumberPicker hzN;
  NumberPicker hzO;
  private Date hzP;
  private Date hzQ;
  private Calendar hzR;
  private String[] hzS;
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.hzS = new String[12];
    int i = 0;
    while (i < this.hzS.length)
    {
      this.hzS[i] = (i + 1);
      i += 1;
    }
    this.hzR = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.hzM = ((YADatePicker.c)getUIDelegate()).woV;
    this.hzN = ((YADatePicker.c)getUIDelegate()).woU;
    this.hzO = ((YADatePicker.c)getUIDelegate()).woT;
    Object localObject = getResources().getDrawable(a.e.picker_divider);
    e.a(this.hzM, (Drawable)localObject);
    e.a(this.hzN, (Drawable)localObject);
    e.a(this.hzO, (Drawable)localObject);
    e.c(this.hzM);
    e.c(this.hzN);
    e.c(this.hzO);
    localObject = new CustomDatePicker.1(this);
    if (this.hzM != null)
    {
      this.hzM.setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject);
      this.hzM.setMinValue(1900);
    }
    if (this.hzN != null) {
      this.hzN.setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject);
    }
    if (this.hzO != null) {
      this.hzO.setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject);
    }
    asO();
    e.e(this.hzM);
    e.e(this.hzN);
    e.e(this.hzO);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, YADatePicker.d paramd)
  {
    super.a(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramd);
    asO();
  }
  
  public final void an(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, null);
  }
  
  final void asO()
  {
    int j = 0;
    if ((this.hzM == null) || (this.hzN == null) || (this.hzO == null)) {
      return;
    }
    this.hzN.setDisplayedValues(null);
    if ((this.hzM.getValue() == this.hzM.getMaxValue()) && (this.hzQ != null))
    {
      this.hzN.setMaxValue(this.hzQ.getMonth());
      if ((this.hzN.getValue() != this.hzN.getMaxValue()) || (this.hzQ == null)) {
        break label318;
      }
      this.hzO.setMaxValue(this.hzQ.getDate());
      i = 1;
      if (i == 0)
      {
        i = this.hzM.getValue();
        int k = this.hzN.getValue();
        this.hzR.set(i, k, 1);
        i = this.hzR.getActualMaximum(5);
        this.hzO.setMaxValue(i);
      }
      if ((this.hzM.getValue() != this.hzM.getMinValue()) || (this.hzP == null)) {
        break label323;
      }
      this.hzN.setMinValue(this.hzP.getMonth());
      i = j;
      if (this.hzN.getValue() == this.hzN.getMinValue())
      {
        i = j;
        if (this.hzP != null) {
          this.hzO.setMinValue(this.hzP.getDate());
        }
      }
    }
    for (int i = 1;; i = j)
    {
      if (i == 0) {
        this.hzO.setMinValue(1);
      }
      this.hzN.setDisplayedValues((String[])Arrays.copyOfRange(this.hzS, this.hzN.getMinValue(), this.hzN.getMaxValue() + 1));
      this.hzM.setWrapSelectorWheel(true);
      this.hzN.setWrapSelectorWheel(true);
      this.hzO.setWrapSelectorWheel(true);
      return;
      this.hzN.setMaxValue(11);
      label318:
      i = 0;
      break;
      label323:
      this.hzN.setMinValue(0);
    }
  }
  
  public int getDayOfMonth()
  {
    if (this.hzO != null) {
      return this.hzO.getValue();
    }
    return super.getDayOfMonth();
  }
  
  public int getMonth()
  {
    if (this.hzN != null) {}
    for (int i = this.hzN.getValue() + 1;; i = super.getMonth() + 1) {
      return Math.max(Math.min(i, 12), 0);
    }
  }
  
  public int getYear()
  {
    if (this.hzM != null) {
      return this.hzM.getValue();
    }
    return super.getYear();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e.d(this.hzM);
    e.d(this.hzN);
    e.d(this.hzO);
  }
  
  public void setMaxDate(long paramLong)
  {
    super.setMaxDate(paramLong);
    this.hzQ = new Date(paramLong);
    if (this.hzM != null) {
      this.hzM.setMaxValue(this.hzQ.getYear() + 1900);
    }
    asO();
  }
  
  public void setMinDate(long paramLong)
  {
    super.setMinDate(paramLong);
    this.hzP = new Date(paramLong);
    if (this.hzM != null) {
      this.hzM.setMinValue(this.hzP.getYear() + 1900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */