package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView
  extends View
{
  private static SoftReference<Bitmap> qLR = null;
  private int blU;
  private int eAS;
  private float nvl;
  private float nvm;
  private List<FontChooserView.b> qLS;
  private int qLT;
  private int qLU;
  private int qLV;
  private int qLW;
  private int qLY;
  private boolean qMb;
  private boolean qMc;
  private int topOffset;
  private FontChooserView.a vsi;
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9896);
    this.qLS = new ArrayList(4);
    this.qLT = 0;
    this.topOffset = 0;
    this.blU = 0;
    this.eAS = 0;
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.qLU = 0;
    this.qLV = 0;
    this.qLW = 0;
    this.qLY = 0;
    this.vsi = null;
    this.qMb = false;
    this.qMc = false;
    AppMethodBeat.o(9896);
  }
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(9897);
    this.qLS = new ArrayList(4);
    this.qLT = 0;
    this.topOffset = 0;
    this.blU = 0;
    this.eAS = 0;
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.qLU = 0;
    this.qLV = 0;
    this.qLW = 0;
    this.qLY = 0;
    this.vsi = null;
    this.qMb = false;
    this.qMc = false;
    AppMethodBeat.o(9897);
  }
  
  private static int KX(int paramInt)
  {
    AppMethodBeat.i(9902);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramInt);
    localPaint.setAntiAlias(true);
    paramInt = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(9902);
    return paramInt;
  }
  
  private void ckN()
  {
    AppMethodBeat.i(9899);
    if ((qLR == null) || (qLR.get() == null)) {
      qLR = new SoftReference(BitmapFactory.decodeResource(getResources(), 2130838884));
    }
    AppMethodBeat.o(9899);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9900);
    super.onDraw(paramCanvas);
    ckN();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.qLT, this.blU, i - this.qLT, this.blU, (Paint)localObject);
    i = 0;
    while (i < 4)
    {
      paramCanvas.drawLine(this.qLT + this.eAS * i, this.blU - j, this.qLT + this.eAS * i, this.blU + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)qLR.get();
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap((Bitmap)localObject, this.qLV, this.qLW, null);
    }
    for (i = ((Bitmap)localObject).getHeight();; i = getResources().getDrawable(2130838884).getIntrinsicHeight())
    {
      localObject = getResources().getString(2131305860);
      String str1 = getResources().getString(2131305861);
      String str2 = getResources().getString(2131305858);
      String str3 = getResources().getString(2131305859);
      int k = getResources().getDimensionPixelSize(2131428427);
      Paint localPaint = new Paint();
      localPaint.setTextSize(k);
      j = (int)localPaint.measureText((String)localObject);
      k = KX(k);
      localPaint.setColor(getResources().getColor(2131690689));
      localPaint.setAntiAlias(true);
      paramCanvas.drawText((String)localObject, this.qLT - j / 2, this.blU - k - i / 3, localPaint);
      k = getResources().getDimensionPixelSize(2131428428);
      localPaint.setTextSize(k);
      j = (int)localPaint.measureText(str1);
      k = KX(k);
      paramCanvas.drawText(str1, this.qLT + this.eAS * 1 - j / 2, this.blU - k - i / 3, localPaint);
      k = getResources().getDimensionPixelSize(2131428425);
      localPaint.setTextSize(k);
      j = (int)localPaint.measureText(str2);
      k = KX(k);
      paramCanvas.drawText(str2, this.qLT + this.eAS * 2 - j / 2, this.blU - k - i / 3, localPaint);
      k = getResources().getDimensionPixelSize(2131428426);
      localPaint.setTextSize(k);
      j = (int)localPaint.measureText(str3);
      k = KX(k);
      paramCanvas.drawText(str3, this.qLT + this.eAS * 3 - j / 2, this.blU - k - i / 3, localPaint);
      AppMethodBeat.o(9900);
      return;
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9898);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ckN();
    this.qLS.clear();
    setClickable(true);
    this.qLT = a.fromDPToPix(getContext(), 50);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.blU = (paramInt2 / 2 + paramInt3);
    this.eAS = ((paramInt1 - this.qLT * 2) / 3);
    Object localObject = (Bitmap)qLR.get();
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramInt1 = ((Bitmap)localObject).getHeight();
    }
    for (paramInt2 = ((Bitmap)localObject).getWidth();; paramInt2 = ((Drawable)localObject).getIntrinsicWidth())
    {
      paramInt3 = 0;
      while (paramInt3 < 4)
      {
        localObject = new FontChooserView.b((byte)0);
        ((FontChooserView.b)localObject).left = (this.qLT + this.eAS * paramInt3 - paramInt2 / 2);
        ((FontChooserView.b)localObject).top = (this.blU - paramInt1 / 2);
        ((FontChooserView.b)localObject).right = (this.qLT + this.eAS * paramInt3 + paramInt2 / 2);
        ((FontChooserView.b)localObject).bottom = (this.blU + paramInt1 / 2);
        this.qLS.add(localObject);
        paramInt3 += 1;
      }
      localObject = getResources().getDrawable(2130838884);
      paramInt1 = ((Drawable)localObject).getIntrinsicHeight();
    }
    this.qLU = this.qLY;
    this.qLV = ((FontChooserView.b)this.qLS.get(this.qLU)).left;
    this.qLW = ((FontChooserView.b)this.qLS.get(this.qLU)).top;
    invalidate();
    AppMethodBeat.o(9898);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(9901);
    boolean bool;
    FontChooserView.b localb;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (bool = true;; bool = true)
      {
        AppMethodBeat.o(9901);
        return bool;
        this.nvl = paramMotionEvent.getX();
        this.nvm = paramMotionEvent.getY();
        localb = (FontChooserView.b)this.qLS.get(this.qLU);
        i = j;
        if (this.nvl >= localb.left)
        {
          i = j;
          if (this.nvl <= localb.right)
          {
            i = j;
            if (this.nvm >= localb.top)
            {
              i = j;
              if (this.nvm <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.qMb = true;
      }
      this.qMc = true;
    }
    label556:
    label607:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.qMb)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.qLV += (int)(f1 - this.nvl);
        this.nvl = f1;
        this.nvm = f2;
        paramMotionEvent = (FontChooserView.b)this.qLS.get(0);
        localb = (FontChooserView.b)this.qLS.get(3);
        if (this.qLV <= paramMotionEvent.left) {
          this.qLV = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.qLV >= localb.left)
          {
            this.qLV = localb.left;
          }
          else
          {
            do
            {
              i += 1;
              if (i >= 4) {
                break;
              }
              paramMotionEvent = (FontChooserView.b)this.qLS.get(i);
            } while ((this.qLV < paramMotionEvent.left - 5) || (this.qLV > paramMotionEvent.right + 5));
            this.qLU = i;
            this.qLY = this.qLU;
            if (this.vsi != null) {
              this.vsi.Da(this.qLU);
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.qMb)
      {
        i = 0;
        for (;;)
        {
          if (i < 3)
          {
            paramMotionEvent = (FontChooserView.b)this.qLS.get(i);
            localb = (FontChooserView.b)this.qLS.get(i + 1);
            if ((this.qLV > paramMotionEvent.left + this.eAS / 2) || (this.qLV < paramMotionEvent.left)) {
              break label556;
            }
            this.qLU = i;
          }
          for (this.qLV = paramMotionEvent.left;; this.qLV = localb.left)
          {
            this.qLY = this.qLU;
            if (this.vsi != null) {
              this.vsi.Da(this.qLU);
            }
            invalidate();
            this.qMb = false;
            bool = true;
            break;
            if ((this.qLV < localb.left - this.eAS / 2) || (this.qLV > localb.left)) {
              break label607;
            }
            this.qLU = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.qMc);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.nvl) <= 10.0F) && (Math.abs(f2 - this.nvm) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < 4)
      {
        paramMotionEvent = (FontChooserView.b)this.qLS.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label770;
        }
        this.qLU = i;
        this.qLY = this.qLU;
        this.qLV = paramMotionEvent.left;
        if (this.vsi != null) {
          this.vsi.Da(this.qLU);
        }
      }
      this.qMc = false;
      invalidate();
      bool = true;
      break;
      label770:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontChooserView.a parama)
  {
    this.vsi = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.qLY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView
 * JD-Core Version:    0.7.0.1
 */