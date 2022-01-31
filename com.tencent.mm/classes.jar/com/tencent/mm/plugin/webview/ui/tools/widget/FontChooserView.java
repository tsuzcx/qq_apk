package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView
  extends View
{
  private static SoftReference<Bitmap> nXH = null;
  private int aVl = 0;
  private int dDr = 0;
  private float hZz = 0.0F;
  private float kXk = 0.0F;
  private List<FontChooserView.b> nXI = new ArrayList(4);
  private int nXJ = 0;
  private int nXK = 0;
  private int nXL = 0;
  private int nXM = 0;
  private int nXO = 0;
  private boolean nXR = false;
  private boolean nXS = false;
  private FontChooserView.a rBW = null;
  private int topOffset = 0;
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static int Df(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramInt);
    localPaint.setAntiAlias(true);
    return (int)Math.ceil(localPaint.getFontMetrics().bottom);
  }
  
  private void bzD()
  {
    if ((nXH == null) || (nXH.get() == null)) {
      nXH = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.font_chooser_slider));
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
    while (i < 4)
    {
      paramCanvas.drawLine(this.nXJ + this.dDr * i, this.aVl - j, this.nXJ + this.dDr * i, this.aVl + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)nXH.get();
    paramCanvas.drawBitmap((Bitmap)localObject, this.nXL, this.nXM, null);
    String str1 = getResources().getString(R.l.webview_font_chooser_small);
    String str2 = getResources().getString(R.l.webview_font_chooser_standar);
    String str3 = getResources().getString(R.l.webview_font_chooser_big);
    String str4 = getResources().getString(R.l.webview_font_chooser_bigger);
    j = getResources().getDimensionPixelSize(R.f.font_chooser_small_text_size);
    Paint localPaint = new Paint();
    localPaint.setTextSize(j);
    i = (int)localPaint.measureText(str1);
    j = Df(j);
    localPaint.setColor(getResources().getColor(R.e.web_view_font_chooser_font_color));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText(str1, this.nXJ - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    j = getResources().getDimensionPixelSize(R.f.font_chooser_standar_text_size);
    localPaint.setTextSize(j);
    i = (int)localPaint.measureText(str2);
    j = Df(j);
    paramCanvas.drawText(str2, this.nXJ + this.dDr * 1 - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    j = getResources().getDimensionPixelSize(R.f.font_chooser_big_text_size);
    localPaint.setTextSize(j);
    i = (int)localPaint.measureText(str3);
    j = Df(j);
    paramCanvas.drawText(str3, this.nXJ + this.dDr * 2 - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    j = getResources().getDimensionPixelSize(R.f.font_chooser_bigger_text_size);
    localPaint.setTextSize(j);
    i = (int)localPaint.measureText(str4);
    j = Df(j);
    paramCanvas.drawText(str4, this.nXJ + this.dDr * 3 - i / 2, this.aVl - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    bzD();
    this.nXI.clear();
    setClickable(true);
    this.nXJ = a.fromDPToPix(getContext(), 50);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.aVl = (paramInt2 / 2 + paramInt3);
    this.dDr = ((paramInt1 - this.nXJ * 2) / 3);
    Bitmap localBitmap = (Bitmap)nXH.get();
    paramInt1 = 0;
    while (paramInt1 < 4)
    {
      FontChooserView.b localb = new FontChooserView.b((byte)0);
      localb.left = (this.nXJ + this.dDr * paramInt1 - localBitmap.getWidth() / 2);
      localb.top = (this.aVl - localBitmap.getHeight() / 2);
      localb.right = (this.nXJ + this.dDr * paramInt1 + localBitmap.getWidth() / 2);
      localb.bottom = (this.aVl + localBitmap.getHeight() / 2);
      this.nXI.add(localb);
      paramInt1 += 1;
    }
    this.nXK = this.nXO;
    this.nXL = ((FontChooserView.b)this.nXI.get(this.nXK)).left;
    this.nXM = ((FontChooserView.b)this.nXI.get(this.nXK)).top;
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    FontChooserView.b localb;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      this.kXk = paramMotionEvent.getX();
      this.hZz = paramMotionEvent.getY();
      localb = (FontChooserView.b)this.nXI.get(this.nXK);
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
    label518:
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.nXR)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.nXL += (int)(f1 - this.kXk);
        this.kXk = f1;
        this.hZz = f2;
        paramMotionEvent = (FontChooserView.b)this.nXI.get(0);
        localb = (FontChooserView.b)this.nXI.get(3);
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
            do
            {
              i += 1;
              if (i >= 4) {
                break;
              }
              paramMotionEvent = (FontChooserView.b)this.nXI.get(i);
            } while ((this.nXL < paramMotionEvent.left - 5) || (this.nXL > paramMotionEvent.right + 5));
            this.nXK = i;
            this.nXO = this.nXK;
            if (this.rBW != null) {
              this.rBW.xc(this.nXK);
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
          if (i < 3)
          {
            paramMotionEvent = (FontChooserView.b)this.nXI.get(i);
            localb = (FontChooserView.b)this.nXI.get(i + 1);
            if ((this.nXL > paramMotionEvent.left + this.dDr / 2) || (this.nXL < paramMotionEvent.left)) {
              break label518;
            }
            this.nXK = i;
          }
          for (this.nXL = paramMotionEvent.left;; this.nXL = localb.left)
          {
            this.nXO = this.nXK;
            if (this.rBW != null) {
              this.rBW.xc(this.nXK);
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
      if (i < 4)
      {
        paramMotionEvent = (FontChooserView.b)this.nXI.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label728;
        }
        this.nXK = i;
        this.nXO = this.nXK;
        this.nXL = paramMotionEvent.left;
        if (this.rBW != null) {
          this.rBW.xc(this.nXK);
        }
      }
      this.nXS = false;
      invalidate();
      return true;
      label728:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontChooserView.a parama)
  {
    this.rBW = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.nXO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView
 * JD-Core Version:    0.7.0.1
 */