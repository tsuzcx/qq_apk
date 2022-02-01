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
  private int MI;
  boolean MU;
  float MZ;
  float Na;
  float Nb;
  float Nc;
  boolean XsN;
  boolean XsO;
  boolean XsP;
  float XsQ;
  float XsR;
  float XsS;
  float XsT;
  private a XsU;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102845);
    this.MU = true;
    this.XsN = false;
    this.XsO = true;
    this.XsP = false;
    dbH();
    AppMethodBeat.o(102845);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102844);
    this.MU = true;
    this.XsN = false;
    this.XsO = true;
    this.XsP = false;
    dbH();
    AppMethodBeat.o(102844);
  }
  
  private void dbH()
  {
    AppMethodBeat.i(102847);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.MI = (i * i);
    AppMethodBeat.o(102847);
  }
  
  public final void cWP()
  {
    AppMethodBeat.i(102850);
    this.XsU.cWP();
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
      this.XsO = true;
      this.XsR = f2;
      this.XsQ = f2;
      this.XsT = f1;
      this.XsS = f1;
      this.XsP = true;
      continue;
      i = (int)(f2 - this.XsQ);
      j = (int)(f1 - this.XsS);
      if (j * j + i * i > this.MI)
      {
        this.XsO = false;
        AppMethodBeat.o(102846);
        return true;
        this.XsO = true;
        this.XsP = false;
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
      this.MU = true;
      this.MZ = f2;
      this.Nb = f2;
      this.Na = f1;
      this.Nc = f1;
      this.XsN = true;
      continue;
      if (!this.XsN)
      {
        this.MU = true;
        this.MZ = f2;
        this.Nb = f2;
        this.Na = f1;
        this.Nc = f1;
        this.XsN = true;
      }
      if (this.XsU != null) {
        this.XsU.cWQ();
      }
      i = (int)(f2 - this.Nb);
      j = (int)(f1 - this.Nc);
      if (j * j + i * i > this.MI)
      {
        this.MU = false;
        continue;
        if (((this.MU) || (!this.XsN)) && (this.XsU != null)) {
          this.XsU.cWP();
        }
        this.MU = true;
        this.XsN = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(a parama)
  {
    this.XsU = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cWP();
    
    public abstract void cWQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */