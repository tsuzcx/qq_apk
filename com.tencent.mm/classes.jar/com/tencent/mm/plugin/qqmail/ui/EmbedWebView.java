package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class EmbedWebView
  extends MMWebView
{
  private GestureDetector uOR;
  private boolean uOS;
  private float[] uOT;
  private float[] uOU;
  private float[] uOV;
  private float[] uOW;
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123006);
    this.uOS = false;
    this.uOT = new float[2];
    this.uOU = new float[2];
    this.uOV = new float[2];
    this.uOW = new float[2];
    this.uOR = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123003);
        paramAnonymousMotionEvent = EmbedWebView.this;
        ad.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + paramAnonymousMotionEvent.getScale());
        int i = 10;
        while (paramAnonymousMotionEvent.getScale() != 1.0F)
        {
          i -= 1;
          if (i <= 0) {
            break;
          }
          if (paramAnonymousMotionEvent.getScale() > 1.0F) {
            paramAnonymousMotionEvent.zoomOut();
          } else {
            paramAnonymousMotionEvent.zoomIn();
          }
        }
        ad.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + EmbedWebView.this.getScale());
        AppMethodBeat.o(123003);
        return true;
      }
    });
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
    this.uOR.onTouchEvent(paramMotionEvent);
    int m;
    int k;
    if (this.uOS)
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
          this.uOT[i] = paramMotionEvent.getX(i);
          this.uOU[i] = paramMotionEvent.getY(i);
          i += 1;
        }
      case 2: 
        i = 0;
        while (i < k)
        {
          this.uOV[i] = paramMotionEvent.getX(i);
          this.uOW[i] = paramMotionEvent.getY(i);
          i += 1;
        }
        float f1 = (float)(Math.pow(this.uOT[1] - this.uOT[0], 2.0D) + Math.pow(this.uOU[1] - this.uOU[0], 2.0D));
        float f2 = (float)(Math.pow(this.uOV[1] - this.uOV[0], 2.0D) + Math.pow(this.uOW[1] - this.uOW[0], 2.0D));
        if (f1 - f2 > 20000.0F) {
          zoomOut();
        }
        for (;;)
        {
          this.uOT[0] = this.uOV[0];
          this.uOT[1] = this.uOV[1];
          this.uOU[0] = this.uOW[0];
          this.uOU[1] = this.uOW[1];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */