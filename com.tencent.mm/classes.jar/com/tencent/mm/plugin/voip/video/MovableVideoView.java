package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

public class MovableVideoView
  extends OpenGlView
{
  private float bAA;
  private float bAB;
  private View.OnClickListener mOnClickListener;
  private int mScreenHeight = 0;
  private int mScreenWidth = 0;
  int mWidth = 320;
  private int qaN = 800;
  private int qaO = 480;
  private long qaP;
  int qav = 240;
  
  public MovableVideoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MovableVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void eo(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.qav = paramInt2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    if (this.mScreenWidth == 0)
    {
      this.mScreenWidth = localWindowManager.getDefaultDisplay().getWidth();
      this.mScreenHeight = localWindowManager.getDefaultDisplay().getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams.topMargin = (a.fromDPToPix(getContext(), 12) + s.gO(getContext()));
    localLayoutParams.leftMargin = (this.mScreenWidth - this.mWidth - localLayoutParams.topMargin + s.gO(getContext()));
    setLayoutParams(localLayoutParams);
    this.qaN = (this.mScreenHeight - this.qav);
    this.qaO = (this.mScreenWidth - this.mWidth);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
  }
  
  public final void ep(int paramInt1, int paramInt2)
  {
    eo(paramInt1, paramInt2);
  }
  
  public final void eq(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    this.mWidth = paramInt1;
    this.qav = paramInt2;
    setLayoutParams(localLayoutParams2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    y.d("MicroMsg.MovableVideoView", "event: " + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      float f1;
      float f2;
      do
      {
        return true;
        this.bAA = paramMotionEvent.getRawX();
        this.bAB = paramMotionEvent.getRawY();
        this.qaP = System.currentTimeMillis();
        return true;
        f1 = paramMotionEvent.getRawX() - this.bAA;
        f2 = paramMotionEvent.getRawY() - this.bAB;
      } while ((Math.abs(f1) <= 1.0F) && (Math.abs(f2) <= 1.0F));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      int m = (int)(f1 + localLayoutParams.leftMargin);
      int k = (int)(f2 + localLayoutParams.topMargin);
      int i;
      if (m < 0)
      {
        i = 0;
        localLayoutParams.leftMargin = i;
        if (k >= 0) {
          break label229;
        }
        i = j;
      }
      for (;;)
      {
        localLayoutParams.topMargin = i;
        setLayoutParams(localLayoutParams);
        this.bAA = paramMotionEvent.getRawX();
        this.bAB = paramMotionEvent.getRawY();
        return true;
        i = m;
        if (m <= this.qaO) {
          break;
        }
        i = this.qaO;
        break;
        label229:
        if (k > this.qaN) {
          i = this.qaN;
        } else {
          i = k;
        }
      }
    }
    long l = System.currentTimeMillis();
    if ((this.qaP != 0L) && (l - this.qaP < 300L) && (l - this.qaP >= 0L) && (this.mOnClickListener != null)) {
      this.mOnClickListener.onClick(this);
    }
    h.nFQ.f(11079, new Object[] { Integer.valueOf(2) });
    return true;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.MovableVideoView
 * JD-Core Version:    0.7.0.1
 */