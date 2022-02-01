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
  boolean KIZ;
  boolean KJa;
  boolean KJb;
  float KJc;
  float KJd;
  float KJe;
  float KJf;
  private a KJg;
  private int Pf;
  boolean Pr;
  float Pw;
  float Px;
  float Py;
  float Pz;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102845);
    this.Pr = true;
    this.KIZ = false;
    this.KJa = true;
    this.KJb = false;
    coH();
    AppMethodBeat.o(102845);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102844);
    this.Pr = true;
    this.KIZ = false;
    this.KJa = true;
    this.KJb = false;
    coH();
    AppMethodBeat.o(102844);
  }
  
  private void coH()
  {
    AppMethodBeat.i(102847);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.Pf = (i * i);
    AppMethodBeat.o(102847);
  }
  
  public final void ckg()
  {
    AppMethodBeat.i(102850);
    this.KJg.ckg();
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
      this.KJa = true;
      this.KJd = f2;
      this.KJc = f2;
      this.KJf = f1;
      this.KJe = f1;
      this.KJb = true;
      continue;
      i = (int)(f2 - this.KJc);
      j = (int)(f1 - this.KJe);
      if (j * j + i * i > this.Pf)
      {
        this.KJa = false;
        AppMethodBeat.o(102846);
        return true;
        this.KJa = true;
        this.KJb = false;
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
      this.Pr = true;
      this.Pw = f2;
      this.Py = f2;
      this.Px = f1;
      this.Pz = f1;
      this.KIZ = true;
      continue;
      if (!this.KIZ)
      {
        this.Pr = true;
        this.Pw = f2;
        this.Py = f2;
        this.Px = f1;
        this.Pz = f1;
        this.KIZ = true;
      }
      if (this.KJg != null) {
        this.KJg.ckh();
      }
      i = (int)(f2 - this.Py);
      j = (int)(f1 - this.Pz);
      if (j * j + i * i > this.Pf)
      {
        this.Pr = false;
        continue;
        if (((this.Pr) || (!this.KIZ)) && (this.KJg != null)) {
          this.KJg.ckg();
        }
        this.Pr = true;
        this.KIZ = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(a parama)
  {
    this.KJg = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ckg();
    
    public abstract void ckh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */