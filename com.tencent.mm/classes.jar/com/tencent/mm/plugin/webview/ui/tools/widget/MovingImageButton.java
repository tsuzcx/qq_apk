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
import com.tencent.mm.sdk.platformtools.Log;

public class MovingImageButton
  extends ImageView
{
  private int JAl;
  private int JAm;
  private int JAn = 0;
  private int JAo = 0;
  private ViewGroup.MarginLayoutParams JAp;
  private final int JAq = 100;
  private int JAr;
  private boolean JAs = false;
  private boolean JAt = true;
  private Context mContext;
  private int mEX;
  private int mEY;
  private int nrK;
  private int nrL;
  private int rZ;
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
    this.JAr = a.fromDPToPix(this.mContext, 100);
    this.mEX = a.jn(this.mContext);
    this.mEY = a.jo(this.mContext);
    this.rZ = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.JAt)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.JAn == 0) || (this.JAo == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.JAn = (localRect.right - localRect.left);
      this.JAo = (localRect.bottom - localRect.top);
      Log.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.JAn), Integer.valueOf(this.JAo) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.nrK = this.x;
      this.nrL = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.JAl = this.x;
      this.JAm = this.y;
      continue;
      int i = this.x - this.nrK;
      int j = this.y - this.nrL;
      if ((i != 0) || (j != 0))
      {
        this.JAp = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.JAp;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.JAp;
        paramMotionEvent.topMargin += j;
        if (this.JAp.rightMargin < 0)
        {
          this.JAp.rightMargin = 0;
          label346:
          if (this.JAp.topMargin >= 0) {
            break label409;
          }
          this.JAp.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.JAp.rightMargin <= this.JAn - getWidth()) {
            break label346;
          }
          this.JAp.rightMargin = (this.JAn - getWidth());
          break label346;
          label409:
          if (this.JAp.topMargin > this.JAo - getHeight()) {
            this.JAp.topMargin = (this.JAo - getHeight());
          }
        }
        if (Math.abs(this.JAl - this.x) + Math.abs(this.JAm - this.y) > this.rZ)
        {
          if (this.y < this.JAr) {
            this.JAp.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.JAo - this.JAr) {
              this.JAp.topMargin = (this.JAo - getHeight());
            } else if (this.x > this.JAn / 2) {
              this.JAp.rightMargin = 0;
            } else {
              this.JAp.rightMargin = (this.JAn - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.JAt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */