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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.ui.aw;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static int JlC = 8;
  private static SoftReference<Bitmap> Jlv = null;
  private int Cxs;
  private int DqN;
  private int FLg;
  private int JlA;
  private a JlB;
  private boolean JlD;
  private List<b> Jlw;
  private int Jlx;
  private int Jly;
  private int Jlz;
  private float aCa;
  private float aCb;
  private int interval;
  private boolean wEW;
  private int zyG;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74626);
    this.Jlw = new ArrayList(8);
    this.Cxs = 0;
    this.FLg = 0;
    this.DqN = 0;
    this.interval = 0;
    this.aCa = 0.0F;
    this.aCb = 0.0F;
    this.Jlx = 0;
    this.Jly = 0;
    this.Jlz = 0;
    this.zyG = 0;
    this.JlA = 0;
    this.JlB = null;
    this.JlD = false;
    this.wEW = false;
    AppMethodBeat.o(74626);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(74627);
    this.Jlw = new ArrayList(8);
    this.Cxs = 0;
    this.FLg = 0;
    this.DqN = 0;
    this.interval = 0;
    this.aCa = 0.0F;
    this.aCb = 0.0F;
    this.Jlx = 0;
    this.Jly = 0;
    this.Jlz = 0;
    this.zyG = 0;
    this.JlA = 0;
    this.JlB = null;
    this.JlD = false;
    this.wEW = false;
    AppMethodBeat.o(74627);
  }
  
  private static int bY(float paramFloat)
  {
    AppMethodBeat.i(74632);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(74632);
    return i;
  }
  
  public static void fGO()
  {
    JlC = 8;
  }
  
  private void fGP()
  {
    AppMethodBeat.i(74629);
    if ((Jlv == null) || (Jlv.get() == null)) {
      Jlv = new SoftReference(BitmapFactory.decodeResource(getResources(), b.e.font_chooser_slider));
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
    fGP();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.Cxs, this.DqN, i - this.Cxs, this.DqN, (Paint)localObject);
    i = 0;
    while (i < JlC)
    {
      paramCanvas.drawLine(this.Cxs + this.interval * i, this.DqN - j, this.Cxs + this.interval * i, this.DqN + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)Jlv.get();
    if (localObject == null) {
      fGP();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.Jly, this.Jlz, null);
    String str = getResources().getString(b.i.setting_text_size_normal);
    getResources().getString(b.i.setting_text_size_large);
    getResources().getString(b.i.setting_text_size_super);
    float f = aw.aZ(getContext(), b.d.NormalTextSize) * a.ka(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bY(f);
    localPaint.setColor(getResources().getColor(b.c.normal_text_color));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.Cxs - i / 2, this.DqN - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aw.aZ(getContext(), b.d.NormalTextSize) * a.kb(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = bY(f);
    paramCanvas.drawText(str, this.Cxs + this.interval * 1 - i / 2, this.DqN - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aw.aZ(getContext(), b.d.NormalTextSize) * a.kh(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bY(f);
    paramCanvas.drawText("A", this.Cxs + this.interval * (JlC - 1) - i / 2, this.DqN - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(74630);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(74628);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    fGP();
    this.Jlw.clear();
    setClickable(true);
    this.Cxs = a.fromDPToPix(getContext(), 30);
    this.FLg = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.FLg;
    this.DqN = (paramInt2 / 2 + paramInt3);
    JlC = 8;
    this.interval = ((paramInt1 - this.Cxs * 2) / (JlC - 1));
    Object localObject2 = (Bitmap)Jlv.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      fGP();
      localObject1 = (Bitmap)Jlv.get();
    }
    paramInt1 = 0;
    while (paramInt1 < JlC)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.Cxs + this.interval * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.DqN - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.Cxs + this.interval * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.DqN + ((Bitmap)localObject1).getHeight() / 2);
      this.Jlw.add(localObject2);
      paramInt1 += 1;
    }
    this.Jlx = this.JlA;
    if (this.zyG >= 0) {
      this.Jly = ((b)this.Jlw.get(this.Jlx)).left;
    }
    for (;;)
    {
      this.Jlz = ((b)this.Jlw.get(this.Jlx)).top;
      invalidate();
      AppMethodBeat.o(74628);
      return;
      if (this.Jly <= ((b)this.Jlw.get(this.Jlx)).right - this.interval / 2) {
        this.Jly = ((b)this.Jlw.get(this.Jlx)).left;
      } else {
        this.Jly = ((b)this.Jlw.get(this.Jlx)).right;
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
        this.aCa = paramMotionEvent.getX();
        this.aCb = paramMotionEvent.getY();
        localb = (b)this.Jlw.get(this.Jlx);
        i = j;
        if (this.aCa >= localb.left)
        {
          i = j;
          if (this.aCa <= localb.right)
          {
            i = j;
            if (this.aCb >= localb.top)
            {
              i = j;
              if (this.aCb <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.JlD = true;
      }
      this.wEW = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.JlD)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.zyG = ((int)(f1 - this.aCa));
        this.Jly = ((int)(f1 - this.Cxs));
        this.aCa = f1;
        this.aCb = f2;
        paramMotionEvent = (b)this.Jlw.get(0);
        localb = (b)this.Jlw.get(JlC - 1);
        if (this.Jly <= paramMotionEvent.left) {
          this.Jly = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.Jly >= localb.left)
          {
            this.Jly = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= JlC) {
                break label424;
              }
              paramMotionEvent = (b)this.Jlw.get(i);
              if ((this.Jly >= paramMotionEvent.left - 5) && (this.Jly <= paramMotionEvent.right + 5))
              {
                this.Jlx = i;
                this.JlA = this.Jlx;
                if (this.JlB == null) {
                  break;
                }
                this.JlB.jj(this.Jlx);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.JlD)
      {
        i = 0;
        for (;;)
        {
          if (i < JlC - 1)
          {
            paramMotionEvent = (b)this.Jlw.get(i);
            localb = (b)this.Jlw.get(i + 1);
            if ((this.Jly > paramMotionEvent.left + this.interval / 2) || (this.Jly < paramMotionEvent.left)) {
              break label575;
            }
            this.Jlx = i;
          }
          for (this.Jly = paramMotionEvent.left;; this.Jly = localb.left)
          {
            this.JlA = this.Jlx;
            if (this.JlB != null) {
              this.JlB.jj(this.Jlx);
            }
            invalidate();
            this.JlD = false;
            bool = true;
            break;
            if ((this.Jly < localb.left - this.interval / 2) || (this.Jly > localb.left)) {
              break label626;
            }
            this.Jlx = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.wEW);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.aCa) <= 10.0F) && (Math.abs(f2 - this.aCb) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < JlC)
      {
        paramMotionEvent = (b)this.Jlw.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.Jlx = i;
        this.JlA = this.Jlx;
        this.Jly = paramMotionEvent.left;
        if (this.JlB != null) {
          this.JlB.jj(this.Jlx);
        }
      }
      this.wEW = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(a parama)
  {
    this.JlB = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.JlA = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void jj(int paramInt);
  }
  
  static final class b
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */