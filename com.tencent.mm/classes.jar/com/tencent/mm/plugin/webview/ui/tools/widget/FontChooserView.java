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
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.ao;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView
  extends View
{
  private static SoftReference<Bitmap> wkM = null;
  private static int wkV = 8;
  private FontChooserView.a Bua;
  private int fWw;
  private float qXK;
  private boolean qXU;
  private float seQ;
  private int ssk;
  private int topOffset;
  private List<b> wkN;
  private int wkO;
  private int wkP;
  private int wkQ;
  private int wkR;
  private int wkS;
  private int wkT;
  private boolean wkW;
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82105);
    this.wkN = new ArrayList(8);
    this.wkO = 0;
    this.topOffset = 0;
    this.ssk = 0;
    this.fWw = 0;
    this.qXK = 0.0F;
    this.seQ = 0.0F;
    this.wkP = 0;
    this.wkQ = 0;
    this.wkR = 0;
    this.wkS = 0;
    this.wkT = 0;
    this.Bua = null;
    this.wkW = false;
    this.qXU = false;
    AppMethodBeat.o(82105);
  }
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82106);
    this.wkN = new ArrayList(8);
    this.wkO = 0;
    this.topOffset = 0;
    this.ssk = 0;
    this.fWw = 0;
    this.qXK = 0.0F;
    this.seQ = 0.0F;
    this.wkP = 0;
    this.wkQ = 0;
    this.wkR = 0;
    this.wkS = 0;
    this.wkT = 0;
    this.Bua = null;
    this.wkW = false;
    this.qXU = false;
    AppMethodBeat.o(82106);
  }
  
  private static int bp(float paramFloat)
  {
    AppMethodBeat.i(82111);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(82111);
    return i;
  }
  
  private void doB()
  {
    AppMethodBeat.i(82108);
    if ((wkM == null) || (wkM.get() == null)) {
      wkM = new SoftReference(BitmapFactory.decodeResource(getResources(), 2131232423));
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
    doB();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.wkO, this.ssk, i - this.wkO, this.ssk, (Paint)localObject);
    i = 0;
    while (i < wkV)
    {
      paramCanvas.drawLine(this.wkO + this.fWw * i, this.ssk - j, this.wkO + this.fWw * i, this.ssk + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)wkM.get();
    if (localObject == null) {
      doB();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.wkQ, this.wkR, null);
    String str = getResources().getString(2131766146);
    getResources().getString(2131766145);
    getResources().getString(2131766147);
    float f = ao.ap(getContext(), 2131165517) * a.hE(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bp(f);
    localPaint.setColor(getResources().getColor(2131100711));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.wkO - i / 2, this.ssk - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = ao.ap(getContext(), 2131165517) * a.hF(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = bp(f);
    paramCanvas.drawText(str, this.wkO + this.fWw * 1 - i / 2, this.ssk - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = ao.ap(getContext(), 2131165517) * a.hL(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bp(f);
    paramCanvas.drawText("A", this.wkO + this.fWw * (wkV - 1) - i / 2, this.ssk - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(82109);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82107);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    doB();
    this.wkN.clear();
    setClickable(true);
    this.wkO = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.ssk = (paramInt2 / 2 + paramInt3);
    wkV = 8;
    this.fWw = ((paramInt1 - this.wkO * 2) / (wkV - 1));
    Object localObject2 = (Bitmap)wkM.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      doB();
      localObject1 = (Bitmap)wkM.get();
    }
    paramInt1 = 0;
    while (paramInt1 < wkV)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.wkO + this.fWw * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.ssk - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.wkO + this.fWw * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.ssk + ((Bitmap)localObject1).getHeight() / 2);
      this.wkN.add(localObject2);
      paramInt1 += 1;
    }
    this.wkP = this.wkT;
    if (this.wkS >= 0) {
      this.wkQ = ((b)this.wkN.get(this.wkP)).left;
    }
    for (;;)
    {
      this.wkR = ((b)this.wkN.get(this.wkP)).top;
      invalidate();
      AppMethodBeat.o(82107);
      return;
      if (this.wkQ <= ((b)this.wkN.get(this.wkP)).right - this.fWw / 2) {
        this.wkQ = ((b)this.wkN.get(this.wkP)).left;
      } else {
        this.wkQ = ((b)this.wkN.get(this.wkP)).right;
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
        this.qXK = paramMotionEvent.getX();
        this.seQ = paramMotionEvent.getY();
        localb = (b)this.wkN.get(this.wkP);
        i = j;
        if (this.qXK >= localb.left)
        {
          i = j;
          if (this.qXK <= localb.right)
          {
            i = j;
            if (this.seQ >= localb.top)
            {
              i = j;
              if (this.seQ <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.wkW = true;
      }
      this.qXU = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.wkW)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.wkS = ((int)(f1 - this.qXK));
        this.wkQ = ((int)(f1 - this.wkO));
        this.qXK = f1;
        this.seQ = f2;
        paramMotionEvent = (b)this.wkN.get(0);
        localb = (b)this.wkN.get(wkV - 1);
        if (this.wkQ <= paramMotionEvent.left) {
          this.wkQ = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.wkQ >= localb.left)
          {
            this.wkQ = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= wkV) {
                break label424;
              }
              paramMotionEvent = (b)this.wkN.get(i);
              if ((this.wkQ >= paramMotionEvent.left - 5) && (this.wkQ <= paramMotionEvent.right + 5))
              {
                this.wkP = i;
                this.wkT = this.wkP;
                if (this.Bua == null) {
                  break;
                }
                this.Bua.LB(this.wkP);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.wkW)
      {
        i = 0;
        for (;;)
        {
          if (i < wkV - 1)
          {
            paramMotionEvent = (b)this.wkN.get(i);
            localb = (b)this.wkN.get(i + 1);
            if ((this.wkQ > paramMotionEvent.left + this.fWw / 2) || (this.wkQ < paramMotionEvent.left)) {
              break label575;
            }
            this.wkP = i;
          }
          for (this.wkQ = paramMotionEvent.left;; this.wkQ = localb.left)
          {
            this.wkT = this.wkP;
            if (this.Bua != null) {
              this.Bua.LB(this.wkP);
            }
            invalidate();
            this.wkW = false;
            bool = true;
            break;
            if ((this.wkQ < localb.left - this.fWw / 2) || (this.wkQ > localb.left)) {
              break label626;
            }
            this.wkP = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.qXU);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.qXK) <= 10.0F) && (Math.abs(f2 - this.seQ) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < wkV)
      {
        paramMotionEvent = (b)this.wkN.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.wkP = i;
        this.wkT = this.wkP;
        this.wkQ = paramMotionEvent.left;
        if (this.Bua != null) {
          this.Bua.LB(this.wkP);
        }
      }
      this.qXU = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontChooserView.a parama)
  {
    this.Bua = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.wkT = paramInt;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView
 * JD-Core Version:    0.7.0.1
 */