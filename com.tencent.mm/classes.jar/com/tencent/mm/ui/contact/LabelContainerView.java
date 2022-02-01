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
  boolean IvX;
  boolean IvY;
  boolean IvZ;
  float Iwa;
  float Iwb;
  float Iwc;
  float Iwd;
  private a Iwe;
  boolean NA;
  float NF;
  float NG;
  float NH;
  float NI;
  private int No;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102845);
    this.NA = true;
    this.IvX = false;
    this.IvY = true;
    this.IvZ = false;
    cDI();
    AppMethodBeat.o(102845);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102844);
    this.NA = true;
    this.IvX = false;
    this.IvY = true;
    this.IvZ = false;
    cDI();
    AppMethodBeat.o(102844);
  }
  
  private void cDI()
  {
    AppMethodBeat.i(102847);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.No = (i * i);
    AppMethodBeat.o(102847);
  }
  
  public final void cen()
  {
    AppMethodBeat.i(102850);
    this.Iwe.cen();
    AppMethodBeat.o(102850);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(102848);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(102848);
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(102846);
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
      AppMethodBeat.o(102846);
      return bool;
      i = m;
      break;
      this.IvY = true;
      this.Iwb = f2;
      this.Iwa = f2;
      this.Iwd = f1;
      this.Iwc = f1;
      this.IvZ = true;
      continue;
      i = (int)(f2 - this.Iwa);
      j = (int)(f1 - this.Iwc);
      if (j * j + i * i > this.No)
      {
        this.IvY = false;
        AppMethodBeat.o(102846);
        return true;
        this.IvY = true;
        this.IvZ = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(102849);
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
      AppMethodBeat.o(102849);
      return bool;
      i = m;
      break;
      this.NA = true;
      this.NF = f2;
      this.NH = f2;
      this.NG = f1;
      this.NI = f1;
      this.IvX = true;
      continue;
      if (!this.IvX)
      {
        this.NA = true;
        this.NF = f2;
        this.NH = f2;
        this.NG = f1;
        this.NI = f1;
        this.IvX = true;
      }
      if (this.Iwe != null) {
        this.Iwe.ceo();
      }
      i = (int)(f2 - this.NH);
      j = (int)(f1 - this.NI);
      if (j * j + i * i > this.No)
      {
        this.NA = false;
        continue;
        if (((this.NA) || (!this.IvX)) && (this.Iwe != null)) {
          this.Iwe.cen();
        }
        this.NA = true;
        this.IvX = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(a parama)
  {
    this.Iwe = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cen();
    
    public abstract void ceo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */