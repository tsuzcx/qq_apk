package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView
  extends MMWebView
{
  private GestureDetector nhs = new GestureDetector(new EmbedWebView.1(this));
  private boolean nht = false;
  private float[] nhu = new float[2];
  private float[] nhv = new float[2];
  private float[] nhw = new float[2];
  private float[] nhx = new float[2];
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    postDelayed(new EmbedWebView.2(this), 100L);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int j = 0;
    int i = 0;
    this.nhs.onTouchEvent(paramMotionEvent);
    int m;
    int k;
    if (this.nht)
    {
      m = paramMotionEvent.getAction();
      k = paramMotionEvent.getPointerCount();
      if (k == 2) {
        break label58;
      }
    }
    for (;;)
    {
      if (i == 0) {
        bool = super.onTouchEvent(paramMotionEvent);
      }
      return bool;
      label58:
      i = j;
      switch (m & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        i = 1;
      }
    }
    while (i < k)
    {
      this.nhu[i] = paramMotionEvent.getX(i);
      this.nhv[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      this.nhw[i] = paramMotionEvent.getX(i);
      this.nhx[i] = paramMotionEvent.getY(i);
      i += 1;
    }
    float f1 = (float)(Math.pow(this.nhu[1] - this.nhu[0], 2.0D) + Math.pow(this.nhv[1] - this.nhv[0], 2.0D));
    float f2 = (float)(Math.pow(this.nhw[1] - this.nhw[0], 2.0D) + Math.pow(this.nhx[1] - this.nhx[0], 2.0D));
    if (f1 - f2 > 20000.0F) {
      zoomOut();
    }
    for (;;)
    {
      this.nhu[0] = this.nhw[0];
      this.nhu[1] = this.nhw[1];
      this.nhv[0] = this.nhx[0];
      this.nhv[1] = this.nhx[1];
      break;
      if (f2 - f1 > 20000.0F) {
        zoomIn();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */