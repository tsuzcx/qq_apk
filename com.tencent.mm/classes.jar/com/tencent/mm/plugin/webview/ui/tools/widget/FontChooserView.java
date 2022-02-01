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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.aq;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView
  extends View
{
  private static SoftReference<Bitmap> yKN = null;
  private static int yKW = 8;
  private FontChooserView.a Eqj;
  private float aTL;
  private float aTM;
  private int guN;
  private boolean sWc;
  private int topOffset;
  private int uCJ;
  private List<b> yKO;
  private int yKP;
  private int yKQ;
  private int yKR;
  private int yKS;
  private int yKT;
  private int yKU;
  private boolean yKX;
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82105);
    this.yKO = new ArrayList(8);
    this.yKP = 0;
    this.topOffset = 0;
    this.uCJ = 0;
    this.guN = 0;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.yKQ = 0;
    this.yKR = 0;
    this.yKS = 0;
    this.yKT = 0;
    this.yKU = 0;
    this.Eqj = null;
    this.yKX = false;
    this.sWc = false;
    AppMethodBeat.o(82105);
  }
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82106);
    this.yKO = new ArrayList(8);
    this.yKP = 0;
    this.topOffset = 0;
    this.uCJ = 0;
    this.guN = 0;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.yKQ = 0;
    this.yKR = 0;
    this.yKS = 0;
    this.yKT = 0;
    this.yKU = 0;
    this.Eqj = null;
    this.yKX = false;
    this.sWc = false;
    AppMethodBeat.o(82106);
  }
  
  private static int bA(float paramFloat)
  {
    AppMethodBeat.i(82111);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(82111);
    return i;
  }
  
  private void dOo()
  {
    AppMethodBeat.i(82108);
    if ((yKN == null) || (yKN.get() == null)) {
      yKN = new SoftReference(BitmapFactory.decodeResource(getResources(), 2131232423));
    }
    AppMethodBeat.o(82108);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(82109);
    super.onDraw(paramCanvas);
    if (paramCanvas == null)
    {
      AppMethodBeat.o(82109);
      return;
    }
    dOo();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.yKP, this.uCJ, i - this.yKP, this.uCJ, (Paint)localObject);
    i = 0;
    while (i < yKW)
    {
      paramCanvas.drawLine(this.yKP + this.guN * i, this.uCJ - j, this.yKP + this.guN * i, this.uCJ + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)yKN.get();
    if (localObject == null) {
      dOo();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.yKR, this.yKS, null);
    String str = getResources().getString(2131766146);
    getResources().getString(2131766145);
    getResources().getString(2131766147);
    float f = aq.ay(getContext(), 2131165517) * a.hY(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bA(f);
    localPaint.setColor(getResources().getColor(2131100711));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.yKP - i / 2, this.uCJ - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aq.ay(getContext(), 2131165517) * a.hZ(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = bA(f);
    paramCanvas.drawText(str, this.yKP + this.guN * 1 - i / 2, this.uCJ - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aq.ay(getContext(), 2131165517) * a.jdMethod_if(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bA(f);
    paramCanvas.drawText("A", this.yKP + this.guN * (yKW - 1) - i / 2, this.uCJ - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(82109);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82107);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    dOo();
    this.yKO.clear();
    setClickable(true);
    this.yKP = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.uCJ = (paramInt2 / 2 + paramInt3);
    yKW = 8;
    this.guN = ((paramInt1 - this.yKP * 2) / (yKW - 1));
    Object localObject2 = (Bitmap)yKN.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      dOo();
      localObject1 = (Bitmap)yKN.get();
    }
    paramInt1 = 0;
    while (paramInt1 < yKW)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.yKP + this.guN * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.uCJ - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.yKP + this.guN * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.uCJ + ((Bitmap)localObject1).getHeight() / 2);
      this.yKO.add(localObject2);
      paramInt1 += 1;
    }
    this.yKQ = this.yKU;
    if (this.yKT >= 0) {
      this.yKR = ((b)this.yKO.get(this.yKQ)).left;
    }
    for (;;)
    {
      this.yKS = ((b)this.yKO.get(this.yKQ)).top;
      invalidate();
      AppMethodBeat.o(82107);
      return;
      if (this.yKR <= ((b)this.yKO.get(this.yKQ)).right - this.guN / 2) {
        this.yKR = ((b)this.yKO.get(this.yKQ)).left;
      } else {
        this.yKR = ((b)this.yKO.get(this.yKQ)).right;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(82110);
    boolean bool;
    b localb;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (bool = true;; bool = true)
      {
        AppMethodBeat.o(82110);
        return bool;
        this.aTL = paramMotionEvent.getX();
        this.aTM = paramMotionEvent.getY();
        localb = (b)this.yKO.get(this.yKQ);
        i = j;
        if (this.aTL >= localb.left)
        {
          i = j;
          if (this.aTL <= localb.right)
          {
            i = j;
            if (this.aTM >= localb.top)
            {
              i = j;
              if (this.aTM <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.yKX = true;
      }
      this.sWc = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.yKX)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.yKT = ((int)(f1 - this.aTL));
        this.yKR = ((int)(f1 - this.yKP));
        this.aTL = f1;
        this.aTM = f2;
        paramMotionEvent = (b)this.yKO.get(0);
        localb = (b)this.yKO.get(yKW - 1);
        if (this.yKR <= paramMotionEvent.left) {
          this.yKR = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.yKR >= localb.left)
          {
            this.yKR = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= yKW) {
                break label424;
              }
              paramMotionEvent = (b)this.yKO.get(i);
              if ((this.yKR >= paramMotionEvent.left - 5) && (this.yKR <= paramMotionEvent.right + 5))
              {
                this.yKQ = i;
                this.yKU = this.yKQ;
                if (this.Eqj == null) {
                  break;
                }
                this.Eqj.Pe(this.yKQ);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.yKX)
      {
        i = 0;
        for (;;)
        {
          if (i < yKW - 1)
          {
            paramMotionEvent = (b)this.yKO.get(i);
            localb = (b)this.yKO.get(i + 1);
            if ((this.yKR > paramMotionEvent.left + this.guN / 2) || (this.yKR < paramMotionEvent.left)) {
              break label575;
            }
            this.yKQ = i;
          }
          for (this.yKR = paramMotionEvent.left;; this.yKR = localb.left)
          {
            this.yKU = this.yKQ;
            if (this.Eqj != null) {
              this.Eqj.Pe(this.yKQ);
            }
            invalidate();
            this.yKX = false;
            bool = true;
            break;
            if ((this.yKR < localb.left - this.guN / 2) || (this.yKR > localb.left)) {
              break label626;
            }
            this.yKQ = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.sWc);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.aTL) <= 10.0F) && (Math.abs(f2 - this.aTM) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < yKW)
      {
        paramMotionEvent = (b)this.yKO.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.yKQ = i;
        this.yKU = this.yKQ;
        this.yKR = paramMotionEvent.left;
        if (this.Eqj != null) {
          this.Eqj.Pe(this.yKQ);
        }
      }
      this.sWc = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontChooserView.a parama)
  {
    this.Eqj = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.yKU = paramInt;
  }
  
  static final class b
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView
 * JD-Core Version:    0.7.0.1
 */