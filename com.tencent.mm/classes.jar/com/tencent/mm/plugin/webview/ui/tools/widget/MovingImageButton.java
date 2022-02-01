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
import com.tencent.mm.sdk.platformtools.Log;

public class MovingImageButton
  extends ImageView
{
  private int Xri;
  private int Xrj;
  private int Xrk = 0;
  private int Xrl = 0;
  private ViewGroup.MarginLayoutParams Xrm;
  private final int Xrn = 100;
  private int Xro;
  private boolean Xrp = false;
  private boolean Xrq = true;
  private int doK;
  private Context mContext;
  private int pvg;
  private int sJv;
  private int tyh;
  private int tyi;
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
    this.Xro = a.fromDPToPix(this.mContext, 100);
    this.sJv = a.ms(this.mContext);
    this.pvg = a.mt(this.mContext);
    this.doK = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    AppMethodBeat.o(82287);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(82288);
    if (!this.Xrq)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(82288);
      return bool;
    }
    if ((this.Xrk == 0) || (this.Xrl == 0))
    {
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      this.Xrk = (localRect.right - localRect.left);
      this.Xrl = (localRect.bottom - localRect.top);
      Log.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", new Object[] { Integer.valueOf(localRect.right), Integer.valueOf(localRect.top), Integer.valueOf(localRect.left), Integer.valueOf(localRect.bottom), Integer.valueOf(this.Xrk), Integer.valueOf(this.Xrl) });
    }
    this.x = ((int)paramMotionEvent.getRawX());
    this.y = ((int)paramMotionEvent.getRawY());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.tyh = this.x;
      this.tyi = this.y;
      AppMethodBeat.o(82288);
      return true;
      this.Xri = this.x;
      this.Xrj = this.y;
      continue;
      int i = this.x - this.tyh;
      int j = this.y - this.tyi;
      if ((i != 0) || (j != 0))
      {
        this.Xrm = ((ViewGroup.MarginLayoutParams)getLayoutParams());
        paramMotionEvent = this.Xrm;
        int k = paramMotionEvent.rightMargin;
        paramMotionEvent.rightMargin = (-i + k);
        paramMotionEvent = this.Xrm;
        paramMotionEvent.topMargin += j;
        if (this.Xrm.rightMargin < 0)
        {
          this.Xrm.rightMargin = 0;
          label346:
          if (this.Xrm.topMargin >= 0) {
            break label409;
          }
          this.Xrm.topMargin = 0;
        }
        for (;;)
        {
          requestLayout();
          break;
          if (this.Xrm.rightMargin <= this.Xrk - getWidth()) {
            break label346;
          }
          this.Xrm.rightMargin = (this.Xrk - getWidth());
          break label346;
          label409:
          if (this.Xrm.topMargin > this.Xrl - getHeight()) {
            this.Xrm.topMargin = (this.Xrl - getHeight());
          }
        }
        if (Math.abs(this.Xri - this.x) + Math.abs(this.Xrj - this.y) > this.doK)
        {
          if (this.y < this.Xro) {
            this.Xrm.topMargin = 0;
          }
          for (;;)
          {
            requestLayout();
            break;
            if (this.y > this.Xrl - this.Xro) {
              this.Xrm.topMargin = (this.Xrl - getHeight());
            } else if (this.x > this.Xrk / 2) {
              this.Xrm.rightMargin = 0;
            } else {
              this.Xrm.rightMargin = (this.Xrk - getWidth());
            }
          }
        }
        performClick();
      }
    }
  }
  
  public void setCanMove(boolean paramBoolean)
  {
    this.Xrq = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton
 * JD-Core Version:    0.7.0.1
 */