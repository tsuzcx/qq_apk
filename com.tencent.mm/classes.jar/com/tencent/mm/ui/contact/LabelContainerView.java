package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView
  extends MMTagPanelScrollView
{
  private int EK;
  boolean EW = true;
  float Fb;
  float Fc;
  float Fd;
  float Fe;
  boolean vLA = true;
  boolean vLB = false;
  float vLC;
  float vLD;
  float vLE;
  float vLF;
  private LabelContainerView.a vLG;
  boolean vLz = false;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cHD();
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cHD();
  }
  
  private void cHD()
  {
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.EK = (i * i);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
    }
    int m;
    float f1;
    float f2;
    label105:
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
      return super.onInterceptTouchEvent(paramMotionEvent);
      i = m;
      break;
      this.vLA = true;
      this.vLD = f2;
      this.vLC = f2;
      this.vLF = f1;
      this.vLE = f1;
      this.vLB = true;
      continue;
      i = (int)(f2 - this.vLC);
      j = (int)(f1 - this.vLE);
      if (j * j + i * i > this.EK)
      {
        this.vLA = false;
        return true;
        this.vLA = true;
        this.vLB = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label105;
      }
    }
    int m;
    float f1;
    float f2;
    label105:
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
      return super.onTouchEvent(paramMotionEvent);
      i = m;
      break;
      this.EW = true;
      this.Fb = f2;
      this.Fd = f2;
      this.Fc = f1;
      this.Fe = f1;
      this.vLz = true;
      continue;
      if (!this.vLz)
      {
        this.EW = true;
        this.Fb = f2;
        this.Fd = f2;
        this.Fc = f1;
        this.Fe = f1;
        this.vLz = true;
      }
      if (this.vLG != null) {
        this.vLG.aJH();
      }
      i = (int)(f2 - this.Fd);
      j = (int)(f1 - this.Fe);
      if (j * j + i * i > this.EK)
      {
        this.EW = false;
        continue;
        if (((this.EW) || (!this.vLz)) && (this.vLG != null)) {
          this.vLG.aJG();
        }
        this.EW = true;
        this.vLz = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(LabelContainerView.a parama)
  {
    this.vLG = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */