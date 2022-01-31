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
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.al;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static SoftReference<Bitmap> qLR = null;
  private static int qMa = 8;
  private int blU;
  private int eAS;
  private float nvl;
  private float nvm;
  private List<FontSelectorView.b> qLS;
  private int qLT;
  private int qLU;
  private int qLV;
  private int qLW;
  private int qLX;
  private int qLY;
  private FontSelectorView.a qLZ;
  private boolean qMb;
  private boolean qMc;
  private int topOffset;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127690);
    this.qLS = new ArrayList(8);
    this.qLT = 0;
    this.topOffset = 0;
    this.blU = 0;
    this.eAS = 0;
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.qLU = 0;
    this.qLV = 0;
    this.qLW = 0;
    this.qLX = 0;
    this.qLY = 0;
    this.qLZ = null;
    this.qMb = false;
    this.qMc = false;
    AppMethodBeat.o(127690);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127691);
    this.qLS = new ArrayList(8);
    this.qLT = 0;
    this.topOffset = 0;
    this.blU = 0;
    this.eAS = 0;
    this.nvl = 0.0F;
    this.nvm = 0.0F;
    this.qLU = 0;
    this.qLV = 0;
    this.qLW = 0;
    this.qLX = 0;
    this.qLY = 0;
    this.qLZ = null;
    this.qMb = false;
    this.qMc = false;
    AppMethodBeat.o(127691);
  }
  
  private static int aY(float paramFloat)
  {
    AppMethodBeat.i(127697);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(127697);
    return i;
  }
  
  public static void ckM()
  {
    qMa = 8;
  }
  
  private void ckN()
  {
    AppMethodBeat.i(127693);
    if ((qLR == null) || (qLR.get() == null)) {
      qLR = new SoftReference(BitmapFactory.decodeResource(getResources(), 2130838884));
    }
    AppMethodBeat.o(127693);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(127694);
    super.onDraw(paramCanvas);
    if (paramCanvas == null)
    {
      AppMethodBeat.o(127694);
      return;
    }
    ckN();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.qLT, this.blU, i - this.qLT, this.blU, (Paint)localObject);
    i = 0;
    while (i < qMa)
    {
      paramCanvas.drawLine(this.qLT + this.eAS * i, this.blU - j, this.qLT + this.eAS * i, this.blU + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)qLR.get();
    if (localObject == null) {
      ckN();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.qLV, this.qLW, null);
    String str = getResources().getString(2131303159);
    getResources().getString(2131303158);
    getResources().getString(2131303161);
    float f = al.ap(getContext(), 2131427809) * a.gf(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = aY(f);
    localPaint.setColor(getResources().getColor(2131689763));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.qLT - i / 2, this.blU - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = al.ap(getContext(), 2131427809) * a.gg(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = aY(f);
    paramCanvas.drawText(str, this.qLT + this.eAS * 1 - i / 2, this.blU - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = al.ap(getContext(), 2131427809) * a.gm(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = aY(f);
    paramCanvas.drawText("A", this.qLT + this.eAS * (qMa - 1) - i / 2, this.blU - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(127694);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(127692);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ckN();
    this.qLS.clear();
    setClickable(true);
    this.qLT = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.blU = (paramInt2 / 2 + paramInt3);
    qMa = 8;
    this.eAS = ((paramInt1 - this.qLT * 2) / (qMa - 1));
    Bitmap localBitmap = (Bitmap)qLR.get();
    if (localBitmap == null) {
      ckN();
    }
    paramInt1 = 0;
    while (paramInt1 < qMa)
    {
      FontSelectorView.b localb = new FontSelectorView.b((byte)0);
      localb.left = (this.qLT + this.eAS * paramInt1 - localBitmap.getWidth() / 2);
      localb.top = (this.blU - localBitmap.getHeight() / 2);
      localb.right = (this.qLT + this.eAS * paramInt1 + localBitmap.getWidth() / 2);
      localb.bottom = (this.blU + localBitmap.getHeight() / 2);
      this.qLS.add(localb);
      paramInt1 += 1;
    }
    this.qLU = this.qLY;
    if (this.qLX >= 0) {
      this.qLV = ((FontSelectorView.b)this.qLS.get(this.qLU)).left;
    }
    for (;;)
    {
      this.qLW = ((FontSelectorView.b)this.qLS.get(this.qLU)).top;
      invalidate();
      AppMethodBeat.o(127692);
      return;
      if (this.qLV <= ((FontSelectorView.b)this.qLS.get(this.qLU)).right - this.eAS / 2) {
        this.qLV = ((FontSelectorView.b)this.qLS.get(this.qLU)).left;
      } else {
        this.qLV = ((FontSelectorView.b)this.qLS.get(this.qLU)).right;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(127695);
    boolean bool;
    FontSelectorView.b localb;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (bool = true;; bool = true)
      {
        AppMethodBeat.o(127695);
        return bool;
        this.nvl = paramMotionEvent.getX();
        this.nvm = paramMotionEvent.getY();
        localb = (FontSelectorView.b)this.qLS.get(this.qLU);
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
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.qMb)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.qLX = ((int)(f1 - this.nvl));
        this.qLV = ((int)(f1 - this.qLT));
        this.nvl = f1;
        this.nvm = f2;
        paramMotionEvent = (FontSelectorView.b)this.qLS.get(0);
        localb = (FontSelectorView.b)this.qLS.get(qMa - 1);
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
            i = 0;
            for (;;)
            {
              if (i >= qMa) {
                break label424;
              }
              paramMotionEvent = (FontSelectorView.b)this.qLS.get(i);
              if ((this.qLV >= paramMotionEvent.left - 5) && (this.qLV <= paramMotionEvent.right + 5))
              {
                this.qLU = i;
                this.qLY = this.qLU;
                if (this.qLZ == null) {
                  break;
                }
                this.qLZ.Da(this.qLU);
                break;
              }
              i += 1;
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
          if (i < qMa - 1)
          {
            paramMotionEvent = (FontSelectorView.b)this.qLS.get(i);
            localb = (FontSelectorView.b)this.qLS.get(i + 1);
            if ((this.qLV > paramMotionEvent.left + this.eAS / 2) || (this.qLV < paramMotionEvent.left)) {
              break label575;
            }
            this.qLU = i;
          }
          for (this.qLV = paramMotionEvent.left;; this.qLV = localb.left)
          {
            this.qLY = this.qLU;
            if (this.qLZ != null) {
              this.qLZ.Da(this.qLU);
            }
            invalidate();
            this.qMb = false;
            bool = true;
            break;
            if ((this.qLV < localb.left - this.eAS / 2) || (this.qLV > localb.left)) {
              break label626;
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
      if (i < qMa)
      {
        paramMotionEvent = (FontSelectorView.b)this.qLS.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.qLU = i;
        this.qLY = this.qLU;
        this.qLV = paramMotionEvent.left;
        if (this.qLZ != null) {
          this.qLZ.Da(this.qLU);
        }
      }
      this.qMc = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontSelectorView.a parama)
  {
    this.qLZ = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.qLY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */