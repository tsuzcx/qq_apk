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
import com.tencent.mm.ui.at;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static SoftReference<Bitmap> DfP = null;
  private static int DfY = 8;
  private List<b> DfQ;
  private int DfR;
  private int DfS;
  private int DfT;
  private int DfU;
  private int DfV;
  private int DfW;
  private FontSelectorView.a DfX;
  private boolean DfZ;
  private float aTD;
  private float aTE;
  private int gTn;
  private boolean sYU;
  private int topOffset;
  private int ygL;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74626);
    this.DfQ = new ArrayList(8);
    this.DfR = 0;
    this.topOffset = 0;
    this.ygL = 0;
    this.gTn = 0;
    this.aTD = 0.0F;
    this.aTE = 0.0F;
    this.DfS = 0;
    this.DfT = 0;
    this.DfU = 0;
    this.DfV = 0;
    this.DfW = 0;
    this.DfX = null;
    this.DfZ = false;
    this.sYU = false;
    AppMethodBeat.o(74626);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(74627);
    this.DfQ = new ArrayList(8);
    this.DfR = 0;
    this.topOffset = 0;
    this.ygL = 0;
    this.gTn = 0;
    this.aTD = 0.0F;
    this.aTE = 0.0F;
    this.DfS = 0;
    this.DfT = 0;
    this.DfU = 0;
    this.DfV = 0;
    this.DfW = 0;
    this.DfX = null;
    this.DfZ = false;
    this.sYU = false;
    AppMethodBeat.o(74627);
  }
  
  private static int bR(float paramFloat)
  {
    AppMethodBeat.i(74632);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(74632);
    return i;
  }
  
  public static void eTL()
  {
    DfY = 8;
  }
  
  private void eTM()
  {
    AppMethodBeat.i(74629);
    if ((DfP == null) || (DfP.get() == null)) {
      DfP = new SoftReference(BitmapFactory.decodeResource(getResources(), 2131232802));
    }
    AppMethodBeat.o(74629);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(74630);
    super.onDraw(paramCanvas);
    if (paramCanvas == null)
    {
      AppMethodBeat.o(74630);
      return;
    }
    eTM();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.DfR, this.ygL, i - this.DfR, this.ygL, (Paint)localObject);
    i = 0;
    while (i < DfY)
    {
      paramCanvas.drawLine(this.DfR + this.gTn * i, this.ygL - j, this.DfR + this.gTn * i, this.ygL + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)DfP.get();
    if (localObject == null) {
      eTM();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.DfT, this.DfU, null);
    String str = getResources().getString(2131765291);
    getResources().getString(2131765290);
    getResources().getString(2131765293);
    float f = at.aH(getContext(), 2131165535) * a.iW(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bR(f);
    localPaint.setColor(getResources().getColor(2131100904));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.DfR - i / 2, this.ygL - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = at.aH(getContext(), 2131165535) * a.iX(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = bR(f);
    paramCanvas.drawText(str, this.DfR + this.gTn * 1 - i / 2, this.ygL - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = at.aH(getContext(), 2131165535) * a.jd(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bR(f);
    paramCanvas.drawText("A", this.DfR + this.gTn * (DfY - 1) - i / 2, this.ygL - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(74630);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(74628);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    eTM();
    this.DfQ.clear();
    setClickable(true);
    this.DfR = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.ygL = (paramInt2 / 2 + paramInt3);
    DfY = 8;
    this.gTn = ((paramInt1 - this.DfR * 2) / (DfY - 1));
    Object localObject2 = (Bitmap)DfP.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      eTM();
      localObject1 = (Bitmap)DfP.get();
    }
    paramInt1 = 0;
    while (paramInt1 < DfY)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.DfR + this.gTn * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.ygL - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.DfR + this.gTn * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.ygL + ((Bitmap)localObject1).getHeight() / 2);
      this.DfQ.add(localObject2);
      paramInt1 += 1;
    }
    this.DfS = this.DfW;
    if (this.DfV >= 0) {
      this.DfT = ((b)this.DfQ.get(this.DfS)).left;
    }
    for (;;)
    {
      this.DfU = ((b)this.DfQ.get(this.DfS)).top;
      invalidate();
      AppMethodBeat.o(74628);
      return;
      if (this.DfT <= ((b)this.DfQ.get(this.DfS)).right - this.gTn / 2) {
        this.DfT = ((b)this.DfQ.get(this.DfS)).left;
      } else {
        this.DfT = ((b)this.DfQ.get(this.DfS)).right;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(74631);
    boolean bool;
    b localb;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (bool = true;; bool = true)
      {
        AppMethodBeat.o(74631);
        return bool;
        this.aTD = paramMotionEvent.getX();
        this.aTE = paramMotionEvent.getY();
        localb = (b)this.DfQ.get(this.DfS);
        i = j;
        if (this.aTD >= localb.left)
        {
          i = j;
          if (this.aTD <= localb.right)
          {
            i = j;
            if (this.aTE >= localb.top)
            {
              i = j;
              if (this.aTE <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.DfZ = true;
      }
      this.sYU = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.DfZ)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.DfV = ((int)(f1 - this.aTD));
        this.DfT = ((int)(f1 - this.DfR));
        this.aTD = f1;
        this.aTE = f2;
        paramMotionEvent = (b)this.DfQ.get(0);
        localb = (b)this.DfQ.get(DfY - 1);
        if (this.DfT <= paramMotionEvent.left) {
          this.DfT = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.DfT >= localb.left)
          {
            this.DfT = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= DfY) {
                break label424;
              }
              paramMotionEvent = (b)this.DfQ.get(i);
              if ((this.DfT >= paramMotionEvent.left - 5) && (this.DfT <= paramMotionEvent.right + 5))
              {
                this.DfS = i;
                this.DfW = this.DfS;
                if (this.DfX == null) {
                  break;
                }
                this.DfX.ig(this.DfS);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.DfZ)
      {
        i = 0;
        for (;;)
        {
          if (i < DfY - 1)
          {
            paramMotionEvent = (b)this.DfQ.get(i);
            localb = (b)this.DfQ.get(i + 1);
            if ((this.DfT > paramMotionEvent.left + this.gTn / 2) || (this.DfT < paramMotionEvent.left)) {
              break label575;
            }
            this.DfS = i;
          }
          for (this.DfT = paramMotionEvent.left;; this.DfT = localb.left)
          {
            this.DfW = this.DfS;
            if (this.DfX != null) {
              this.DfX.ig(this.DfS);
            }
            invalidate();
            this.DfZ = false;
            bool = true;
            break;
            if ((this.DfT < localb.left - this.gTn / 2) || (this.DfT > localb.left)) {
              break label626;
            }
            this.DfS = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.sYU);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.aTD) <= 10.0F) && (Math.abs(f2 - this.aTE) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < DfY)
      {
        paramMotionEvent = (b)this.DfQ.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.DfS = i;
        this.DfW = this.DfS;
        this.DfT = paramMotionEvent.left;
        if (this.DfX != null) {
          this.DfX.ig(this.DfS);
        }
      }
      this.sYU = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontSelectorView.a parama)
  {
    this.DfX = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.DfW = paramInt;
  }
  
  static final class b
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */