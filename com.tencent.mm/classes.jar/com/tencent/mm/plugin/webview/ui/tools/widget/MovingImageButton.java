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
import com.tencent.mm.sdk.platformtools.ad;

public class MovingImageButton
  extends ImageView
{
  private int Esg;
  private int Esh;
  private int Esi = 0;
  private int Esj = 0;
  private ViewGroup.MarginLayoutParams Esk;
  private final int Esl = 100;
  private int Esm;
  private boolean Esn = false;
  private boolean Eso = true;
  private int ltA;
  private int ltB;
  private Context mContext;
  private int mcX;
  private int mcY;
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
    this.Esm = a.fromDPToPix(this.mContext, 100);
    this.ltA = a.ip(this.mContext);
    this.ltB = a.iq(this.mContext);
    this.rW = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.Eso)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.Esi == 0) || (this.Esj == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.Esi = (localRect.right - localRect.left);
      this.Esj = (localRect.bottom - localRect.top);
      ad.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.Esi), Integer.valueOf(this.Esj) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.mcX = this.x;
      this.mcY = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.Esg = this.x;
      this.Esh = this.y;
      continue;
      int i = this.x - this.mcX;
      int j = this.y - this.mcY;
      if ((i != 0) || (j != 0))
      {
        this.Esk = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.Esk;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.Esk;
        paramMotionEvent.topMargin += j;
        if (this.Esk.rightMargin < 0)
        {
          this.Esk.rightMargin = 0;
          label346:
          if (this.Esk.topMargin >= 0) {
            break label409;
          }
          this.Esk.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.Esk.rightMargin <= this.Esi - getWidth()) {
            break label346;
          }
          this.Esk.rightMargin = (this.Esi - getWidth());
          break label346;
          label409:
          if (this.Esk.topMargin > this.Esj - getHeight()) {
            this.Esk.topMargin = (this.Esj - getHeight());
          }
        }
        if (Math.abs(this.Esg - this.x) + Math.abs(this.Esh - this.y) > this.rW)
        {
          if (this.y < this.Esm) {
            this.Esk.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.Esj - this.Esm) {
              this.Esk.topMargin = (this.Esj - getHeight());
            } else if (this.x > this.Esi / 2) {
              this.Esk.rightMargin = 0;
            } else {
              this.Esk.rightMargin = (this.Esi - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.Eso = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */