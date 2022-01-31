package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public class MovingImageButton
  extends ImageView
{
  private int gHR;
  private int gHS;
  private int gUJ;
  private int gUK;
  private int kYl;
  private Context mContext;
  private int rCI;
  private int rCJ;
  private int rCK = 0;
  private int rCL = 0;
  private ViewGroup.MarginLayoutParams rCM;
  private final int rCN = 100;
  private int rCO;
  private boolean rCP = false;
  private boolean rCQ = true;
  private int x;
  private int y;
  
  public MovingImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public MovingImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.rCO = a.fromDPToPix(this.mContext, 100);
    this.gHR = a.fj(this.mContext);
    this.gHS = a.fk(this.mContext);
    this.kYl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.rCQ) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if ((this.rCK == 0) || (this.rCL == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.rCK = (localRect.right - localRect.left);
      this.rCL = (localRect.bottom - localRect.top);
      y.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.rCK), Integer.valueOf(this.rCL) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.gUJ = this.x;
      this.gUK = this.y;
      return true;
      this.rCI = this.x;
      this.rCJ = this.y;
      continue;
      int i = this.x - this.gUJ;
      int j = this.y - this.gUK;
      if ((i != 0) || (j != 0))
      {
        this.rCM = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.rCM;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.rCM;
        paramMotionEvent.topMargin += j;
        if (this.rCM.rightMargin < 0)
        {
          this.rCM.rightMargin = 0;
          label325:
          if (this.rCM.topMargin >= 0) {
            break label388;
          }
          this.rCM.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.rCM.rightMargin <= this.rCK - getWidth()) {
            break label325;
          }
          this.rCM.rightMargin = (this.rCK - getWidth());
          break label325;
          label388:
          if (this.rCM.topMargin > this.rCL - getHeight()) {
            this.rCM.topMargin = (this.rCL - getHeight());
          }
        }
        if (Math.abs(this.rCI - this.x) + Math.abs(this.rCJ - this.y) > this.kYl)
        {
          if (this.y < this.rCO) {
            this.rCM.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.rCL - this.rCO) {
              this.rCM.topMargin = (this.rCL - getHeight());
            } else if (this.x > this.rCK / 2) {
              this.rCM.rightMargin = 0;
            } else {
              this.rCM.rightMargin = (this.rCK - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.rCQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */