package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.i;
import com.tencent.mm.ci.a.k;
import com.tencent.mm.ui.ap;

public class MMSwitchBtn
  extends View
{
  private int edgePadding;
  private int kYl;
  private int maxHeight;
  private int maxWidth;
  private Paint mwF = new Paint(1);
  private float pqG;
  private float pqH;
  private long wjH;
  private int wjI;
  private int wjJ;
  private int wjK;
  private boolean wjL = false;
  private boolean wjM = false;
  private float wjN;
  private float wjO;
  private int wjP;
  private int wjQ;
  private int wjR;
  public boolean wjS = false;
  private RectF wjT = new RectF();
  private RectF wjU = new RectF();
  private int wjV;
  private int wjW;
  private int wjX;
  private String wjY;
  private String wjZ;
  private MMSwitchBtn.b wka = new MMSwitchBtn.b(this, (byte)0);
  private MMSwitchBtn.a wkb;
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
    b(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    b(paramContext.obtainStyledAttributes(paramAttributeSet, a.k.MMSwitchBtn));
  }
  
  private void b(TypedArray paramTypedArray)
  {
    this.wjW = paramTypedArray.getColor(a.k.MMSwitchBtn_on_color, this.wjR);
    this.wjV = paramTypedArray.getColor(a.k.MMSwitchBtn_off_color, this.wjQ);
    this.wjX = paramTypedArray.getColor(a.k.MMSwitchBtn_slide_color, this.wjP);
    this.wjY = paramTypedArray.getString(a.k.MMSwitchBtn_on_text);
    this.wjZ = paramTypedArray.getString(a.k.MMSwitchBtn_off_text);
    paramTypedArray.recycle();
  }
  
  private void cJP()
  {
    if (this.wjK < this.maxHeight) {
      this.wjU.top = ((this.maxHeight - this.wjK) / 2 + this.edgePadding);
    }
    for (this.wjU.bottom = (this.wjU.top + this.wjK - this.edgePadding * 2); this.wjS; this.wjU.bottom = (this.maxHeight - this.edgePadding))
    {
      this.wjU.left = (this.wjJ + this.edgePadding);
      this.wjU.right = (this.maxWidth - this.edgePadding);
      return;
      this.wjU.top = this.edgePadding;
    }
    this.wjU.left = this.edgePadding;
    this.wjU.right = ((int)(this.wjO * 2.0F) + this.edgePadding);
  }
  
  private void cJQ()
  {
    if (this.wjU.left < this.edgePadding) {
      this.wjU.left = this.edgePadding;
    }
    if (this.wjU.left > this.wjJ + this.edgePadding) {
      this.wjU.left = (this.wjJ + this.edgePadding);
    }
    this.wjU.right = (this.wjU.left + (int)(this.wjO * 2.0F));
  }
  
  private void cJo()
  {
    if (this.wjU.left > this.wjI)
    {
      nQ(true);
      return;
    }
    nQ(false);
  }
  
  private void fg(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void init()
  {
    this.edgePadding = getResources().getDimensionPixelSize(a.d.SmallestPadding);
    this.wjN = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusOut);
    this.wjO = getResources().getDimensionPixelSize(a.d.SwitchBtnRadiusIn);
    this.wjP = getResources().getColor(a.c.white);
    this.wjQ = getResources().getColor(a.c.switch_btn_off_color);
    this.wjR = getResources().getColor(a.c.switch_btn_on_color);
    this.wjW = this.wjR;
    this.wjV = this.wjQ;
    this.wjX = this.wjP;
    this.kYl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void nQ(boolean paramBoolean)
  {
    this.wjL = true;
    this.wka.reset();
    if (paramBoolean) {
      this.wka.wkd = (this.wjJ - this.wjU.left + this.edgePadding);
    }
    for (this.wka.direction = 1;; this.wka.direction = 0)
    {
      this.wka.wkc = this.wjU.left;
      this.wka.setDuration(80L * this.wka.wkd / this.wjJ);
      startAnimation(this.wka);
      return;
      this.wka.wkd = (this.wjU.left);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.mwF.setColor(this.wjV);
    this.mwF.setAlpha(255);
    paramCanvas.drawRoundRect(this.wjT, this.wjN, this.wjN, this.mwF);
    this.mwF.setColor(this.wjW);
    this.mwF.setAlpha(Math.min(255, (int)((this.wjU.left - this.edgePadding) / this.wjJ * 255.0F)));
    paramCanvas.drawRoundRect(this.wjT, this.wjN, this.wjN, this.mwF);
    this.mwF.setColor(this.wjX);
    paramCanvas.drawRoundRect(this.wjU, this.wjO, this.wjO, this.mwF);
    if ((this.wjY != null) && (this.wjZ != null))
    {
      Paint localPaint = new Paint();
      localPaint.setTextSize(getResources().getDimension(a.d.SmallTextSize));
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setColor(getResources().getColor(a.c.white_text_color));
      localPaint.setAntiAlias(true);
      int i = Math.min(255, (int)((this.wjU.left - this.edgePadding) / this.wjJ * 255.0F));
      Rect localRect = new Rect();
      localPaint.getTextBounds(this.wjY, 0, this.wjY.length(), localRect);
      localPaint.setAlpha(i);
      float f2 = (this.wjT.left + this.wjT.right) / 2.0F;
      float f3 = this.wjO;
      float f4 = ap.fromDPToPix(getContext(), 1);
      float f1 = (this.wjT.top + this.wjT.bottom) / 2.0F;
      f1 = localRect.height() / 2.0F + f1 - ap.fromDPToPix(getContext(), 1);
      paramCanvas.drawText(this.wjY, f2 - f3 + f4, f1, localPaint);
      f2 = (this.wjT.left + this.wjT.right) / 2.0F;
      f3 = this.wjO;
      f4 = ap.fromDPToPix(getContext(), 1);
      localPaint.setAlpha(255 - i);
      paramCanvas.drawText(this.wjZ, f2 + f3 - f4, f1, localPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.wjJ = (this.maxWidth - (int)(this.wjO * 2.0F) - this.edgePadding * 2);
    this.wjI = (this.wjJ / 2);
    this.wjK = getResources().getDimensionPixelSize(a.d.SwitchBtnHeight);
    if (this.wjK < this.maxHeight) {
      this.wjT.top = ((this.maxHeight - this.wjK) / 2);
    }
    for (this.wjT.bottom = (this.wjT.top + this.wjK);; this.wjT.bottom = this.maxHeight)
    {
      this.wjT.left = 0.0F;
      this.wjT.right = this.maxWidth;
      cJP();
      this.mwF.setStyle(Paint.Style.FILL);
      this.mwF.setColor(this.wjQ);
      return;
      this.wjT.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (this.wjL) {}
    for (;;)
    {
      return true;
      if (isEnabled())
      {
        switch (paramMotionEvent.getAction())
        {
        }
        while (this.wjM)
        {
          invalidate();
          return true;
          clearAnimation();
          this.pqG = paramMotionEvent.getX();
          this.pqH = paramMotionEvent.getY();
          this.wjH = SystemClock.elapsedRealtime();
          this.wjM = false;
          continue;
          float f1;
          float f2;
          if (this.wjM)
          {
            fg(true);
            f1 = paramMotionEvent.getX();
            f2 = this.pqG;
            RectF localRectF = this.wjU;
            localRectF.left = (f1 - f2 + localRectF.left);
            cJQ();
          }
          for (;;)
          {
            this.pqG = paramMotionEvent.getX();
            this.pqH = paramMotionEvent.getY();
            break;
            float f3 = paramMotionEvent.getX() - this.pqG;
            f2 = paramMotionEvent.getY() - this.pqH;
            int i = j;
            if (Math.abs(f3) >= this.kYl / 10.0F)
            {
              f1 = f2;
              if (f2 == 0.0F) {
                f1 = 1.0F;
              }
              i = j;
              if (Math.abs(f3 / f1) > 3.0F) {
                i = 1;
              }
            }
            if (i != 0)
            {
              this.wjM = true;
              fg(true);
            }
          }
          boolean bool;
          if (SystemClock.elapsedRealtime() - this.wjH < 300L) {
            if (!this.wjS)
            {
              bool = true;
              label282:
              nQ(bool);
            }
          }
          for (;;)
          {
            fg(false);
            this.wjM = false;
            break;
            bool = false;
            break label282;
            cJo();
          }
          if (this.wjM) {
            cJo();
          }
          fg(false);
          this.wjM = false;
        }
      }
    }
  }
  
  public void setCheck(boolean paramBoolean)
  {
    if (this.wjS != paramBoolean)
    {
      clearAnimation();
      this.wjS = paramBoolean;
      cJP();
      this.wjL = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(a.i.switch_check_desc);; str = getContext().getString(a.i.switch_uncheck_desc))
    {
      setContentDescription(str);
      return;
    }
  }
  
  public void setSwitchListener(MMSwitchBtn.a parama)
  {
    this.wkb = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn
 * JD-Core Version:    0.7.0.1
 */