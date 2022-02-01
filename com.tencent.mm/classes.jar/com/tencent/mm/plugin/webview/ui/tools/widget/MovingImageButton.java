package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MovingImageButton
  extends ImageView
{
  private int QyA = 0;
  private ViewGroup.MarginLayoutParams QyB;
  private final int QyC = 100;
  private int QyD;
  private boolean QyE = false;
  private boolean QyF = true;
  private int Qyx;
  private int Qyy;
  private int Qyz = 0;
  private int bvH;
  private Context mContext;
  private int pEj;
  private int pEk;
  private int qtC;
  private int qtD;
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
    this.QyD = a.fromDPToPix(this.mContext, 100);
    this.pEj = a.kr(this.mContext);
    this.pEk = a.ks(this.mContext);
    this.bvH = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.QyF)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.Qyz == 0) || (this.QyA == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.Qyz = (localRect.right - localRect.left);
      this.QyA = (localRect.bottom - localRect.top);
      Log.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.Qyz), Integer.valueOf(this.QyA) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.qtC = this.x;
      this.qtD = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.Qyx = this.x;
      this.Qyy = this.y;
      continue;
      int i = this.x - this.qtC;
      int j = this.y - this.qtD;
      if ((i != 0) || (j != 0))
      {
        this.QyB = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.QyB;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.QyB;
        paramMotionEvent.topMargin += j;
        if (this.QyB.rightMargin < 0)
        {
          this.QyB.rightMargin = 0;
          label346:
          if (this.QyB.topMargin >= 0) {
            break label409;
          }
          this.QyB.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.QyB.rightMargin <= this.Qyz - getWidth()) {
            break label346;
          }
          this.QyB.rightMargin = (this.Qyz - getWidth());
          break label346;
          label409:
          if (this.QyB.topMargin > this.QyA - getHeight()) {
            this.QyB.topMargin = (this.QyA - getHeight());
          }
        }
        if (Math.abs(this.Qyx - this.x) + Math.abs(this.Qyy - this.y) > this.bvH)
        {
          if (this.y < this.QyD) {
            this.QyB.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.QyA - this.QyD) {
              this.QyB.topMargin = (this.QyA - getHeight());
            } else if (this.x > this.Qyz / 2) {
              this.QyB.rightMargin = 0;
            } else {
              this.QyB.rightMargin = (this.Qyz - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.QyF = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */