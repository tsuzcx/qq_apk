package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView
  extends MMTagPanelScrollView
{
  boolean Adb;
  boolean Adc;
  boolean Add;
  float Ade;
  float Adf;
  float Adg;
  float Adh;
  private LabelContainerView.a Adi;
  boolean FF;
  float FK;
  float FL;
  float FM;
  float FN;
  private int Ft;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105209);
    this.FF = true;
    this.Adb = false;
    this.Adc = true;
    this.Add = false;
    dLV();
    AppMethodBeat.o(105209);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105208);
    this.FF = true;
    this.Adb = false;
    this.Adc = true;
    this.Add = false;
    dLV();
    AppMethodBeat.o(105208);
  }
  
  private void dLV()
  {
    AppMethodBeat.i(105211);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.Ft = (i * i);
    AppMethodBeat.o(105211);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105212);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105212);
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105210);
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label110;
      }
    }
    int m;
    float f1;
    float f2;
    label110:
    for (int j = paramMotionEvent.getActionIndex();; j = -1)
    {
      m = paramMotionEvent.getPointerCount();
      int k = 0;
      f1 = 0.0F;
      float f3;
      for (f2 = 0.0F; k < m; f2 = f3)
      {
        float f4 = f1;
        f3 = f2;
        if (j != k)
        {
          f3 = f2 + paramMotionEvent.getX(k);
          f4 = f1 + paramMotionEvent.getY(k);
        }
        k += 1;
        f1 = f4;
      }
      i = 0;
      break;
    }
    if (i != 0)
    {
      i = m - 1;
      f2 /= i;
      f1 /= i;
      switch (n)
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105210);
      return bool;
      i = m;
      break;
      this.Adc = true;
      this.Adf = f2;
      this.Ade = f2;
      this.Adh = f1;
      this.Adg = f1;
      this.Add = true;
      continue;
      i = (int)(f2 - this.Ade);
      j = (int)(f1 - this.Adg);
      if (j * j + i * i > this.Ft)
      {
        this.Adc = false;
        AppMethodBeat.o(105210);
        return true;
        this.Adc = true;
        this.Add = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105213);
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label110;
      }
    }
    int m;
    float f1;
    float f2;
    label110:
    for (int j = paramMotionEvent.getActionIndex();; j = -1)
    {
      m = paramMotionEvent.getPointerCount();
      int k = 0;
      f1 = 0.0F;
      float f3;
      for (f2 = 0.0F; k < m; f2 = f3)
      {
        float f4 = f1;
        f3 = f2;
        if (j != k)
        {
          f3 = f2 + paramMotionEvent.getX(k);
          f4 = f1 + paramMotionEvent.getY(k);
        }
        k += 1;
        f1 = f4;
      }
      i = 0;
      break;
    }
    if (i != 0)
    {
      i = m - 1;
      f2 /= i;
      f1 /= i;
      switch (n)
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105213);
      return bool;
      i = m;
      break;
      this.FF = true;
      this.FK = f2;
      this.FM = f2;
      this.FL = f1;
      this.FN = f1;
      this.Adb = true;
      continue;
      if (!this.Adb)
      {
        this.FF = true;
        this.FK = f2;
        this.FM = f2;
        this.FL = f1;
        this.FN = f1;
        this.Adb = true;
      }
      if (this.Adi != null) {
        this.Adi.bnp();
      }
      i = (int)(f2 - this.FM);
      j = (int)(f1 - this.FN);
      if (j * j + i * i > this.Ft)
      {
        this.FF = false;
        continue;
        if (((this.FF) || (!this.Adb)) && (this.Adi != null)) {
          this.Adi.bno();
        }
        this.FF = true;
        this.Adb = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(LabelContainerView.a parama)
  {
    this.Adi = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */