package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public class MovingImageButton
  extends ImageView
{
  private int COg;
  private int COh;
  private int COi = 0;
  private int COj = 0;
  private ViewGroup.MarginLayoutParams COk;
  private final int COl = 100;
  private int COm;
  private boolean COn = false;
  private boolean COo = true;
  private int kWB;
  private int kWC;
  private int lDu;
  private int lDv;
  private Context mContext;
  private int qc;
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
    this.COm = a.fromDPToPix(this.mContext, 100);
    this.kWB = a.ig(this.mContext);
    this.kWC = a.ih(this.mContext);
    this.qc = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.COo)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.COi == 0) || (this.COj == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.COi = (localRect.right - localRect.left);
      this.COj = (localRect.bottom - localRect.top);
      ac.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.COi), Integer.valueOf(this.COj) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.lDu = this.x;
      this.lDv = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.COg = this.x;
      this.COh = this.y;
      continue;
      int i = this.x - this.lDu;
      int j = this.y - this.lDv;
      if ((i != 0) || (j != 0))
      {
        this.COk = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.COk;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.COk;
        paramMotionEvent.topMargin += j;
        if (this.COk.rightMargin < 0)
        {
          this.COk.rightMargin = 0;
          label346:
          if (this.COk.topMargin >= 0) {
            break label409;
          }
          this.COk.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.COk.rightMargin <= this.COi - getWidth()) {
            break label346;
          }
          this.COk.rightMargin = (this.COi - getWidth());
          break label346;
          label409:
          if (this.COk.topMargin > this.COj - getHeight()) {
            this.COk.topMargin = (this.COj - getHeight());
          }
        }
        if (Math.abs(this.COg - this.x) + Math.abs(this.COh - this.y) > this.qc)
        {
          if (this.y < this.COm) {
            this.COk.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.COj - this.COm) {
              this.COk.topMargin = (this.COj - getHeight());
            } else if (this.x > this.COi / 2) {
              this.COk.rightMargin = 0;
            } else {
              this.COk.rightMargin = (this.COi - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.COo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */