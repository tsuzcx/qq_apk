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
  boolean afeo;
  boolean afep;
  boolean afeq;
  float afer;
  float afes;
  float afet;
  float afeu;
  private a afev;
  private int bsL;
  boolean bsW;
  float btb;
  float btc;
  float btd;
  float bte;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102845);
    this.bsW = true;
    this.afeo = false;
    this.afep = true;
    this.afeq = false;
    initConfig();
    AppMethodBeat.o(102845);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102844);
    this.bsW = true;
    this.afeo = false;
    this.afep = true;
    this.afeq = false;
    initConfig();
    AppMethodBeat.o(102844);
  }
  
  private void initConfig()
  {
    AppMethodBeat.i(102847);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.bsL = (i * i);
    AppMethodBeat.o(102847);
  }
  
  public final void dCv()
  {
    AppMethodBeat.i(102850);
    this.afev.dCv();
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
      this.afep = true;
      this.afes = f2;
      this.afer = f2;
      this.afeu = f1;
      this.afet = f1;
      this.afeq = true;
      continue;
      i = (int)(f2 - this.afer);
      j = (int)(f1 - this.afet);
      if (j * j + i * i > this.bsL)
      {
        this.afep = false;
        AppMethodBeat.o(102846);
        return true;
        this.afep = true;
        this.afeq = false;
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
      this.bsW = true;
      this.btb = f2;
      this.btd = f2;
      this.btc = f1;
      this.bte = f1;
      this.afeo = true;
      continue;
      if (!this.afeo)
      {
        this.bsW = true;
        this.btb = f2;
        this.btd = f2;
        this.btc = f1;
        this.bte = f1;
        this.afeo = true;
      }
      if (this.afev != null) {
        this.afev.dCw();
      }
      i = (int)(f2 - this.btd);
      j = (int)(f1 - this.bte);
      if (j * j + i * i > this.bsL)
      {
        this.bsW = false;
        continue;
        if (((this.bsW) || (!this.afeo)) && (this.afev != null)) {
          this.afev.dCv();
        }
        this.bsW = true;
        this.afeo = false;
      }
    }
  }
  
  public void setOnLabelContainerListener(a parama)
  {
    this.afev = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dCv();
    
    public abstract void dCw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.LabelContainerView
 * JD-Core Version:    0.7.0.1
 */