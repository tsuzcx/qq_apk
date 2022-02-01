package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public class MovingImageButton
  extends ImageView
{
  private ViewGroup.MarginLayoutParams EKA;
  private final int EKB = 100;
  private int EKC;
  private boolean EKD = false;
  private boolean EKE = true;
  private int EKw;
  private int EKx;
  private int EKy = 0;
  private int EKz = 0;
  private int lxZ;
  private int lya;
  private Context mContext;
  private int mhp;
  private int mhq;
  private int rW;
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
    AppMethodBeat.i(82287);
    super.onFinishInflate();
    this.EKC = a.fromDPToPix(this.mContext, 100);
    this.lxZ = a.iu(this.mContext);
    this.lya = a.iv(this.mContext);
    this.rW = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.EKE)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.EKy == 0) || (this.EKz == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.EKy = (localRect.right - localRect.left);
      this.EKz = (localRect.bottom - localRect.top);
      ae.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.EKy), Integer.valueOf(this.EKz) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.mhp = this.x;
      this.mhq = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.EKw = this.x;
      this.EKx = this.y;
      continue;
      int i = this.x - this.mhp;
      int j = this.y - this.mhq;
      if ((i != 0) || (j != 0))
      {
        this.EKA = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.EKA;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.EKA;
        paramMotionEvent.topMargin += j;
        if (this.EKA.rightMargin < 0)
        {
          this.EKA.rightMargin = 0;
          label346:
          if (this.EKA.topMargin >= 0) {
            break label409;
          }
          this.EKA.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.EKA.rightMargin <= this.EKy - getWidth()) {
            break label346;
          }
          this.EKA.rightMargin = (this.EKy - getWidth());
          break label346;
          label409:
          if (this.EKA.topMargin > this.EKz - getHeight()) {
            this.EKA.topMargin = (this.EKz - getHeight());
          }
        }
        if (Math.abs(this.EKw - this.x) + Math.abs(this.EKx - this.y) > this.rW)
        {
          if (this.y < this.EKC) {
            this.EKA.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.EKz - this.EKC) {
              this.EKA.topMargin = (this.EKz - getHeight());
            } else if (this.x > this.EKy / 2) {
              this.EKA.rightMargin = 0;
            } else {
              this.EKA.rightMargin = (this.EKy - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.EKE = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */