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
import com.tencent.mm.sdk.platformtools.ab;

public class MovingImageButton
  extends ImageView
{
  private int iiW;
  private int iiX;
  private int ixS;
  private int ixT;
  private Context mContext;
  private int nwj;
  private int vsU;
  private int vsV;
  private int vsW = 0;
  private int vsX = 0;
  private ViewGroup.MarginLayoutParams vsY;
  private final int vsZ = 100;
  private int vta;
  private boolean vtb = false;
  private boolean vtc = true;
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
    AppMethodBeat.i(10056);
    super.onFinishInflate();
    this.vta = a.fromDPToPix(this.mContext, 100);
    this.iiW = a.gw(this.mContext);
    this.iiX = a.gx(this.mContext);
    this.nwj = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(10056);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(10057);
    if (!this.vtc)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(10057);
      return bool;
    }
    if ((this.vsW == 0) || (this.vsX == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.vsW = (localRect.right - localRect.left);
      this.vsX = (localRect.bottom - localRect.top);
      ab.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.vsW), Integer.valueOf(this.vsX) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.ixS = this.x;
      this.ixT = this.y;
      AppMethodBeat.o(10057);
      return true;
      this.vsU = this.x;
      this.vsV = this.y;
      continue;
      int i = this.x - this.ixS;
      int j = this.y - this.ixT;
      if ((i != 0) || (j != 0))
      {
        this.vsY = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.vsY;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.vsY;
        paramMotionEvent.topMargin += j;
        if (this.vsY.rightMargin < 0)
        {
          this.vsY.rightMargin = 0;
          label347:
          if (this.vsY.topMargin >= 0) {
            break label410;
          }
          this.vsY.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.vsY.rightMargin <= this.vsW - getWidth()) {
            break label347;
          }
          this.vsY.rightMargin = (this.vsW - getWidth());
          break label347;
          label410:
          if (this.vsY.topMargin > this.vsX - getHeight()) {
            this.vsY.topMargin = (this.vsX - getHeight());
          }
        }
        if (Math.abs(this.vsU - this.x) + Math.abs(this.vsV - this.y) > this.nwj)
        {
          if (this.y < this.vta) {
            this.vsY.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.vsX - this.vta) {
              this.vsY.topMargin = (this.vsX - getHeight());
            } else if (this.x > this.vsW / 2) {
              this.vsY.rightMargin = 0;
            } else {
              this.vsY.rightMargin = (this.vsW - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.vtc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */