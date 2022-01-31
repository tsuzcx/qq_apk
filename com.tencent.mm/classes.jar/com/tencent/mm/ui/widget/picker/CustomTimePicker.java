package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.mm.ci.a.e;
import com.tencent.mm.ci.a.j;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;

public class CustomTimePicker
  extends TimePicker
{
  public int gAa = -1;
  public int gzX = -1;
  public int gzY = -1;
  public int gzZ = -1;
  public NumberPicker hAo;
  private NumberPicker hAp;
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    initView();
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setIs24HourView(Boolean.valueOf(true));
    this.hAo = xf("mHourSpinner");
    this.hAp = xf("mMinuteSpinner");
    e.c(this.hAo);
    e.c(this.hAp);
    Drawable localDrawable = getResources().getDrawable(a.e.picker_divider);
    e.a(this.hAo, localDrawable);
    e.a(this.hAp, localDrawable);
    if (this.hAo != null) {
      this.hAo.setOnValueChangedListener(new CustomTimePicker.1(this));
    }
    if ((this.hAp != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.hAp.setOnValueChangedListener(new CustomTimePicker.2(this));
    }
    e.e(this.hAo);
    e.e(this.hAp);
  }
  
  private NumberPicker xf(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return xh(paramString);
    }
    return xg(paramString);
  }
  
  private NumberPicker xg(String paramString)
  {
    try
    {
      paramString = (NumberPicker)new aj(this, paramString).get();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private NumberPicker xh(String paramString)
  {
    try
    {
      Object localObject = new aj(this, "mDelegate").get();
      if (localObject != null)
      {
        paramString = (NumberPicker)new aj(localObject, paramString).get();
        return paramString;
      }
    }
    catch (NoSuchFieldException paramString)
    {
      ao.a(paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        ao.a(paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      }
    }
  }
  
  public final void asR()
  {
    if ((f.ne(this.gzX)) && (f.nd(this.gzY)) && (this.hAo != null) && (this.hAp != null))
    {
      if (this.hAo.getValue() != this.gzX) {
        break label109;
      }
      this.hAp.setMinValue(this.gzY);
    }
    for (;;)
    {
      if ((f.ne(this.gzZ)) && (this.hAo != null) && (this.hAp != null))
      {
        if (this.hAo.getValue() != this.gzZ) {
          break;
        }
        this.hAp.setMaxValue(this.gAa);
      }
      return;
      label109:
      this.hAp.setMinValue(0);
    }
    this.hAp.setMaxValue(59);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e.d(this.hAo);
    e.d(this.hAp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */