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
  boolean GVJ;
  boolean GVK;
  boolean GVL;
  float GVM;
  float GVN;
  float GVO;
  float GVP;
  private a GVQ;
  boolean MF;
  float MK;
  float ML;
  float MM;
  float MN;
  private int Mr;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102845);
    this.MF = true;
    this.GVJ = false;
    this.GVK = true;
    this.GVL = false;
    csj();
    AppMethodBeat.o(102845);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102844);
    this.MF = true;
    this.GVJ = false;
    this.GVK = true;
    this.GVL = false;
    csj();
    AppMethodBeat.o(102844);
  }
  
  private void csj()
  {
    AppMethodBeat.i(102847);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.Mr = (i * i);
    AppMethodBeat.o(102847);
  }
  
  public final void bXa()
  {
    AppMethodBeat.i(102850);
    this.GVQ.bXa();
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
      this.GVK = true;
      this.GVN = f2;
      this.GVM = f2;
      this.GVP = f1;
      this.GVO = f1;
      this.GVL = true;
      continue;
      i = (int)(f2 - this.GVM);
      j = (int)(f1 - this.GVO);
      if (j * j + i * i > this.Mr)
      {
        this.GVK = false;
        AppMethodBeat.o(102846);
        return true;
        this.GVK = true;
        this.GVL = false;
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
      this.MF = true;
      this.MK = f2;
      this.MM = f2;
      this.ML = f1;
      this.MN = f1;
      this.GVJ = true;
      continue;
      if (!this.GVJ)
      {
        this.MF = true;
        this.MK = f2;
        this.MM = f2;
        this.ML = f1;
        this.MN = f1;
        this.GVJ = true;
      }
      if (this.GVQ != null) {
        this.GVQ.bXb();
      }
      i = (int)(f2 - this.MM);
      j = (int)(f1 - this.MN);
      if (j * j + i * i > this.Mr)
      {
        this.MF = false;
        continue;
        if (((this.MF) || (!this.GVJ)) && (this.GVQ != null)) {
          this.GVQ.bXa();
        }
        this.MF = true;
        this.GVJ = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(a parama)
  {
    this.GVQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bXa();
    
    public abstract void bXb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */