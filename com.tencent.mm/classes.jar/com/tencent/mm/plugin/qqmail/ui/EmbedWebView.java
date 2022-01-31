package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView
  extends MMWebView
{
  private GestureDetector pMF;
  private boolean pMG;
  private float[] pMH;
  private float[] pMI;
  private float[] pMJ;
  private float[] pMK;
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68280);
    this.pMG = false;
    this.pMH = new float[2];
    this.pMI = new float[2];
    this.pMJ = new float[2];
    this.pMK = new float[2];
    this.pMF = new GestureDetector(new EmbedWebView.1(this));
    postDelayed(new EmbedWebView.2(this), 100L);
    AppMethodBeat.o(68280);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(68281);
    this.pMF.onTouchEvent(paramMotionEvent);
    int m;
    int k;
    if (this.pMG)
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
      AppMethodBeat.o(68281);
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
          this.pMH[i] = paramMotionEvent.getX(i);
          this.pMI[i] = paramMotionEvent.getY(i);
          i += 1;
        }
      case 2: 
        i = 0;
        while (i < k)
        {
          this.pMJ[i] = paramMotionEvent.getX(i);
          this.pMK[i] = paramMotionEvent.getY(i);
          i += 1;
        }
        float f1 = (float)(Math.pow(this.pMH[1] - this.pMH[0], 2.0D) + Math.pow(this.pMI[1] - this.pMI[0], 2.0D));
        float f2 = (float)(Math.pow(this.pMJ[1] - this.pMJ[0], 2.0D) + Math.pow(this.pMK[1] - this.pMK[0], 2.0D));
        if (f1 - f2 > 20000.0F) {
          zoomOut();
        }
        for (;;)
        {
          this.pMH[0] = this.pMJ[0];
          this.pMH[1] = this.pMJ[1];
          this.pMI[0] = this.pMK[0];
          this.pMI[1] = this.pMK[1];
          break;
          if (f2 - f1 > 20000.0F) {
            zoomIn();
          }
        }
      }
    }
    AppMethodBeat.o(68281);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */