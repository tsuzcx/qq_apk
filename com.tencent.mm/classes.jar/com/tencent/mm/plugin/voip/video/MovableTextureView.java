package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class MovableTextureView
  extends MMTextureView
{
  private float bAA;
  private float bAB;
  private View.OnClickListener mOnClickListener;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public int mWidth = 320;
  public int qaN = 800;
  public int qaO = 480;
  private long qaP;
  public int qav = 240;
  
  public MovableTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MovableTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    y.d("MicroMsg.MovableTextureView", "event: " + paramMotionEvent.getAction());
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
 * Qualified Name:     com.tencent.mm.plugin.voip.video.MovableTextureView
 * JD-Core Version:    0.7.0.1
 */