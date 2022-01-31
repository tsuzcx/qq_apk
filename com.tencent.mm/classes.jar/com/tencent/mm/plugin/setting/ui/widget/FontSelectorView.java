package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static SoftReference<Bitmap> nXH = null;
  private static int nXQ = 8;
  private int aVl = 0;
  private int dDr = 0;
  private float hZz = 0.0F;
  private float kXk = 0.0F;
  private List<FontSelectorView.b> nXI = new ArrayList(8);
  private int nXJ = 0;
  private int nXK = 0;
  private int nXL = 0;
  private int nXM = 0;
  private int nXN = 0;
  private int nXO = 0;
  private FontSelectorView.a nXP = null;
  private boolean nXR = false;
  private boolean nXS = false;
  private int topOffset = 0;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static int aA(float paramFloat)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    return (int)Math.ceil(localPaint.getFontMetrics().bottom);
  }
  
  private float az(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  public static void bzC()
  {
    nXQ = 8;
  }
  
  private void bzD()
  {
    if ((nXH == null) || (nXH.get() == null)) {
      nXH = new SoftReference(BitmapFactory.decodeResource(getResources(), a.e.font_chooser_slider));
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    bzD();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.nXJ, this.aVl, i - this.nXJ, this.aVl, (Paint)localObject);
    i = 0;
    while (i < nXQ)
    {
      paramCanvas.drawLine(this.nXJ + this.dDr * i, this.aVl - j, this.nXJ + this.dDr * i, this.aVl + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)nXH.get();
    paramCanvas.drawBitmap((Bitmap)localObject, this.nXL, this.nXM, null);
    String str = getResources().getString(a.i.setting_text_size_normal);
    getResources().getString(a.i.setting_text_size_large);
    getResources().getString(a.i.setting_text_size_super);
    float f = az(SetTextSizeUI.ax(0.875F));
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = aA(f);
    localPaint.setColor(getResources().getColor(a.c.black));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.nXJ - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = az(SetTextSizeUI.ax(1.0F));
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = aA(f);
    paramCanvas.drawText(str, this.nXJ + this.dDr * 1 - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = az(SetTextSizeUI.ax(2.025F));
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = aA(f);
    paramCanvas.drawText("A", this.nXJ + this.dDr * (nXQ - 1) - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    bzD();
    this.nXI.clear();
    setClickable(true);
    this.nXJ = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.aVl = (paramInt2 / 2 + paramInt3);
    nXQ = 8;
    this.dDr = ((paramInt1 - this.nXJ * 2) / (nXQ - 1));
    Bitmap localBitmap = (Bitmap)nXH.get();
    paramInt1 = 0;
    while (paramInt1 < nXQ)
    {
      FontSelectorView.b localb = new FontSelectorView.b((byte)0);
      localb.left = (this.nXJ + this.dDr * paramInt1 - localBitmap.getWidth() / 2);
      localb.top = (this.aVl - localBitmap.getHeight() / 2);
      localb.right = (this.nXJ + this.dDr * paramInt1 + localBitmap.getWidth() / 2);
      localb.bottom = (this.aVl + localBitmap.getHeight() / 2);
      this.nXI.add(localb);
      paramInt1 += 1;
    }
    this.nXK = this.nXO;
    if (this.nXN >= 0) {
      this.nXL = ((FontSelectorView.b)this.nXI.get(this.nXK)).left;
    }
    for (;;)
    {
      this.nXM = ((FontSelectorView.b)this.nXI.get(this.nXK)).top;
      invalidate();
      return;
      if (this.nXL <= ((FontSelectorView.b)this.nXI.get(this.nXK)).right - this.dDr / 2) {
        this.nXL = ((FontSelectorView.b)this.nXI.get(this.nXK)).left;
      } else {
        this.nXL = ((FontSelectorView.b)this.nXI.get(this.nXK)).right;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    FontSelectorView.b localb;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.kXk = paramMotionEvent.getX();
      this.hZz = paramMotionEvent.getY();
      localb = (FontSelectorView.b)this.nXI.get(this.nXK);
      i = j;
      if (this.kXk >= localb.left)
      {
        i = j;
        if (this.kXk <= localb.right)
        {
          i = j;
          if (this.hZz >= localb.top)
          {
            i = j;
            if (this.hZz <= localb.bottom) {
              i = 1;
            }
          }
        }
      }
      if (i != 0)
      {
        this.nXR = true;
        return true;
      }
      this.nXS = true;
    }
    label395:
    label538:
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.nXR)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.nXN = ((int)(f1 - this.kXk));
        this.nXL += this.nXN;
        this.kXk = f1;
        this.hZz = f2;
        paramMotionEvent = (FontSelectorView.b)this.nXI.get(0);
        localb = (FontSelectorView.b)this.nXI.get(nXQ - 1);
        if (this.nXL <= paramMotionEvent.left) {
          this.nXL = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          return true;
          if (this.nXL >= localb.left)
          {
            this.nXL = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= nXQ) {
                break label395;
              }
              paramMotionEvent = (FontSelectorView.b)this.nXI.get(i);
              if ((this.nXL >= paramMotionEvent.left - 5) && (this.nXL <= paramMotionEvent.right + 5))
              {
                this.nXK = i;
                this.nXO = this.nXK;
                if (this.nXP == null) {
                  break;
                }
                this.nXP.xc(this.nXK);
                break;
              }
              i += 1;
            }
          }
        }
      }
      return super.onTouchEvent(paramMotionEvent);
      if (this.nXR)
      {
        i = 0;
        for (;;)
        {
          if (i < nXQ - 1)
          {
            paramMotionEvent = (FontSelectorView.b)this.nXI.get(i);
            localb = (FontSelectorView.b)this.nXI.get(i + 1);
            if ((this.nXL > paramMotionEvent.left + this.dDr / 2) || (this.nXL < paramMotionEvent.left)) {
              break label538;
            }
            this.nXK = i;
          }
          for (this.nXL = paramMotionEvent.left;; this.nXL = localb.left)
          {
            this.nXO = this.nXK;
            if (this.nXP != null) {
              this.nXP.xc(this.nXK);
            }
            invalidate();
            this.nXR = false;
            return true;
            if ((this.nXL < localb.left - this.dDr / 2) || (this.nXL > localb.left)) {
              break;
            }
            this.nXK = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.nXS);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.kXk) <= 10.0F) && (Math.abs(f2 - this.hZz) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < nXQ)
      {
        paramMotionEvent = (FontSelectorView.b)this.nXI.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label750;
        }
        this.nXK = i;
        this.nXO = this.nXK;
        this.nXL = paramMotionEvent.left;
        if (this.nXP != null) {
          this.nXP.xc(this.nXK);
        }
      }
      this.nXS = false;
      invalidate();
      return true;
      label750:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontSelectorView.a parama)
  {
    this.nXP = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.nXO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */