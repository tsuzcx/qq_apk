package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView
  extends MMWebView
{
  private GestureDetector vXH;
  private boolean vXI;
  private float[] vXJ;
  private float[] vXK;
  private float[] vXL;
  private float[] vXM;
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123006);
    this.vXI = false;
    this.vXJ = new float[2];
    this.vXK = new float[2];
    this.vXL = new float[2];
    this.vXM = new float[2];
    this.vXH = new GestureDetector(new EmbedWebView.1(this));
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123005);
        View localView = (View)EmbedWebView.this.getParent();
        if (localView == null)
        {
          AppMethodBeat.o(123005);
          return;
        }
        localView = (View)localView.getParent();
        if ((localView != null) && ((localView instanceof ScrollView)))
        {
          EmbedWebView.a(EmbedWebView.this);
          localView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(123004);
              if (paramAnonymous2MotionEvent.getPointerCount() == 2) {
                EmbedWebView.this.onTouchEvent(paramAnonymous2MotionEvent);
              }
              AppMethodBeat.o(123004);
              return false;
            }
          });
        }
        AppMethodBeat.o(123005);
      }
    }, 100L);
    AppMethodBeat.o(123006);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(123007);
    this.vXH.onTouchEvent(paramMotionEvent);
    int m;
    int k;
    if (this.vXI)
    {
      m = paramMotionEvent.getAction();
      k = paramMotionEvent.getPointerCount();
      if (k == 2) {
        break label65;
      }
    }
    while (i == 0)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(123007);
      return bool;
      label65:
      i = j;
      switch (m & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        i = 1;
        break;
      case 5: 
        while (i < k)
        {
          this.vXJ[i] = paramMotionEvent.getX(i);
          this.vXK[i] = paramMotionEvent.getY(i);
          i += 1;
        }
      case 2: 
        i = 0;
        while (i < k)
        {
          this.vXL[i] = paramMotionEvent.getX(i);
          this.vXM[i] = paramMotionEvent.getY(i);
          i += 1;
        }
        float f1 = (float)(Math.pow(this.vXJ[1] - this.vXJ[0], 2.0D) + Math.pow(this.vXK[1] - this.vXK[0], 2.0D));
        float f2 = (float)(Math.pow(this.vXL[1] - this.vXL[0], 2.0D) + Math.pow(this.vXM[1] - this.vXM[0], 2.0D));
        if (f1 - f2 > 20000.0F) {
          zoomOut();
        }
        for (;;)
        {
          this.vXJ[0] = this.vXL[0];
          this.vXJ[1] = this.vXL[1];
          this.vXK[0] = this.vXM[0];
          this.vXK[1] = this.vXM[1];
          break;
          if (f2 - f1 > 20000.0F) {
            zoomIn();
          }
        }
      }
    }
    AppMethodBeat.o(123007);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */