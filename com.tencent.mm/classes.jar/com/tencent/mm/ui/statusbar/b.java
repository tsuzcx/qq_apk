package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.ui.ak;

public class b
  extends FrameLayout
  implements c.a
{
  static final boolean vXr = c.vXv;
  private int heA;
  private final Activity mActivity;
  private final Paint mPaint;
  private int vXs;
  private int vXt;
  private boolean vXu = false;
  
  public b(Context paramContext)
  {
    super(paramContext);
    if (vXr)
    {
      this.mActivity = d.cx(paramContext);
      c.af(this.mActivity).a(this);
      this.mPaint = new Paint(1);
      this.mPaint.setStyle(Paint.Style.FILL);
      setWillNotDraw(false);
      return;
    }
    this.mActivity = null;
    this.mPaint = null;
  }
  
  private void Ic(int paramInt)
  {
    this.heA = Math.max(0, paramInt);
    if (this.vXu) {}
    for (paramInt = 0;; paramInt = this.heA)
    {
      setPadding(0, paramInt, 0, 0);
      postInvalidate();
      return;
    }
  }
  
  public final void av(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    this.vXs = paramInt;
    if (!vXr) {
      return;
    }
    Object localObject = this.mActivity.getWindow();
    d.a((Window)localObject);
    if ((Build.VERSION.SDK_INT >= 23) && (d.a((Window)localObject, paramBoolean))) {
      this.vXs = paramInt;
    }
    for (;;)
    {
      localObject = this;
      paramInt = j;
      for (;;)
      {
        ((b)localObject).vXt = paramInt;
        do
        {
          postInvalidate();
          return;
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean) {
          i = ak.Cx(paramInt);
        }
        this.vXs = i;
        if (!paramBoolean) {
          break;
        }
        paramInt = Color.argb(51, 0, 0, 0);
        localObject = this;
      }
    }
  }
  
  public final void dN(boolean paramBoolean)
  {
    this.vXu = paramBoolean;
    Ic(this.heA);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.heA <= 0) || (!vXr) || (this.vXu)) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.heA > 0) && (vXr) && (this.vXu)) {
        break;
      }
      return;
      this.mPaint.setColor(this.vXs);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.heA, this.mPaint);
    }
    this.mPaint.setColor(this.vXt);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.heA, this.mPaint);
  }
  
  public final void ml(int paramInt)
  {
    Ic(paramInt);
  }
  
  public void setStatusBarColor(int paramInt)
  {
    if (!vXr) {
      return;
    }
    av(paramInt, d.c(this.mActivity.getWindow()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */