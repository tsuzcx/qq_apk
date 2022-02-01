package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public class MovingImageButton
  extends ImageView
{
  private int BvY;
  private int BvZ;
  private int Bwa = 0;
  private int Bwb = 0;
  private ViewGroup.MarginLayoutParams Bwc;
  private final int Bwd = 100;
  private int Bwe;
  private boolean Bwf = false;
  private boolean Bwg = true;
  private int kvn;
  private int kvo;
  private int ldD;
  private int ldE;
  private Context mContext;
  private int pd;
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
    this.Bwe = a.fromDPToPix(this.mContext, 100);
    this.kvn = a.hV(this.mContext);
    this.kvo = a.hW(this.mContext);
    this.pd = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.Bwg)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.Bwa == 0) || (this.Bwb == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.Bwa = (localRect.right - localRect.left);
      this.Bwb = (localRect.bottom - localRect.top);
      ad.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.Bwa), Integer.valueOf(this.Bwb) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.ldD = this.x;
      this.ldE = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.BvY = this.x;
      this.BvZ = this.y;
      continue;
      int i = this.x - this.ldD;
      int j = this.y - this.ldE;
      if ((i != 0) || (j != 0))
      {
        this.Bwc = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.Bwc;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.Bwc;
        paramMotionEvent.topMargin += j;
        if (this.Bwc.rightMargin < 0)
        {
          this.Bwc.rightMargin = 0;
          label346:
          if (this.Bwc.topMargin >= 0) {
            break label409;
          }
          this.Bwc.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.Bwc.rightMargin <= this.Bwa - getWidth()) {
            break label346;
          }
          this.Bwc.rightMargin = (this.Bwa - getWidth());
          break label346;
          label409:
          if (this.Bwc.topMargin > this.Bwb - getHeight()) {
            this.Bwc.topMargin = (this.Bwb - getHeight());
          }
        }
        if (Math.abs(this.BvY - this.x) + Math.abs(this.BvZ - this.y) > this.pd)
        {
          if (this.y < this.Bwe) {
            this.Bwc.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.Bwb - this.Bwe) {
              this.Bwc.topMargin = (this.Bwb - getHeight());
            } else if (this.x > this.Bwa / 2) {
              this.Bwc.rightMargin = 0;
            } else {
              this.Bwc.rightMargin = (this.Bwa - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.Bwg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */