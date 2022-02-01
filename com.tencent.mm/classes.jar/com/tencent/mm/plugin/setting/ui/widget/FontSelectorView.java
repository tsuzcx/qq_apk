package com.tencent.mm.plugin.setting.ui.widget;

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
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.ui.bd;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static SoftReference<Bitmap> Pyl = null;
  private static int Pys = 8;
  private boolean Abi;
  private int EBz;
  private int Ips;
  private int Jkv;
  private int LGn;
  private List<b> Pym;
  private int Pyn;
  private int Pyo;
  private int Pyp;
  private int Pyq;
  private FontSelectorView.a Pyr;
  private boolean Pyt;
  private float cxM;
  private float cxN;
  private int interval;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74626);
    this.Pym = new ArrayList(8);
    this.Ips = 0;
    this.LGn = 0;
    this.Jkv = 0;
    this.interval = 0;
    this.cxM = 0.0F;
    this.cxN = 0.0F;
    this.Pyn = 0;
    this.Pyo = 0;
    this.Pyp = 0;
    this.EBz = 0;
    this.Pyq = 0;
    this.Pyr = null;
    this.Pyt = false;
    this.Abi = false;
    AppMethodBeat.o(74626);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(74627);
    this.Pym = new ArrayList(8);
    this.Ips = 0;
    this.LGn = 0;
    this.Jkv = 0;
    this.interval = 0;
    this.cxM = 0.0F;
    this.cxN = 0.0F;
    this.Pyn = 0;
    this.Pyo = 0;
    this.Pyp = 0;
    this.EBz = 0;
    this.Pyq = 0;
    this.Pyr = null;
    this.Pyt = false;
    this.Abi = false;
    AppMethodBeat.o(74627);
  }
  
  private static int de(float paramFloat)
  {
    AppMethodBeat.i(74632);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(74632);
    return i;
  }
  
  public static void gWB()
  {
    Pys = 8;
  }
  
  private void gWC()
  {
    AppMethodBeat.i(74629);
    if ((Pyl == null) || (Pyl.get() == null)) {
      Pyl = new SoftReference(BitmapFactory.decodeResource(getResources(), b.e.font_chooser_slider));
    }
    AppMethodBeat.o(74629);
  }
  
  public int getSliderIndex()
  {
    return this.Pyq;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(74630);
    super.onDraw(paramCanvas);
    if (paramCanvas == null)
    {
      AppMethodBeat.o(74630);
      return;
    }
    gWC();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.Ips, this.Jkv, i - this.Ips, this.Jkv, (Paint)localObject);
    i = 0;
    while (i < Pys)
    {
      paramCanvas.drawLine(this.Ips + this.interval * i, this.Jkv - j, this.Ips + this.interval * i, this.Jkv + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)Pyl.get();
    if (localObject == null) {
      gWC();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.Pyo, this.Pyp, null);
    String str = getResources().getString(b.i.setting_text_size_normal);
    getResources().getString(b.i.setting_text_size_large);
    getResources().getString(b.i.setting_text_size_super);
    float f = bd.bs(getContext(), b.d.NormalTextSize) * a.mc(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = de(f);
    localPaint.setColor(getResources().getColor(b.c.normal_text_color));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.Ips - i / 2, this.Jkv - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = bd.bs(getContext(), b.d.NormalTextSize) * a.md(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = de(f);
    paramCanvas.drawText(str, this.Ips + this.interval * 1 - i / 2, this.Jkv - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = bd.bs(getContext(), b.d.NormalTextSize) * a.mj(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = de(f);
    paramCanvas.drawText("A", this.Ips + this.interval * (Pys - 1) - i / 2, this.Jkv - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(74630);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(74628);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    gWC();
    this.Pym.clear();
    setClickable(true);
    this.Ips = a.fromDPToPix(getContext(), 30);
    this.LGn = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.LGn;
    this.Jkv = (paramInt2 / 2 + paramInt3);
    Pys = 8;
    this.interval = ((paramInt1 - this.Ips * 2) / (Pys - 1));
    Object localObject2 = (Bitmap)Pyl.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      gWC();
      localObject1 = (Bitmap)Pyl.get();
    }
    paramInt1 = 0;
    while (paramInt1 < Pys)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.Ips + this.interval * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.Jkv - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.Ips + this.interval * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.Jkv + ((Bitmap)localObject1).getHeight() / 2);
      this.Pym.add(localObject2);
      paramInt1 += 1;
    }
    this.Pyn = this.Pyq;
    if (this.EBz >= 0) {
      this.Pyo = ((b)this.Pym.get(this.Pyn)).left;
    }
    for (;;)
    {
      this.Pyp = ((b)this.Pym.get(this.Pyn)).top;
      invalidate();
      AppMethodBeat.o(74628);
      return;
      if (this.Pyo <= ((b)this.Pym.get(this.Pyn)).right - this.interval / 2) {
        this.Pyo = ((b)this.Pym.get(this.Pyn)).left;
      } else {
        this.Pyo = ((b)this.Pym.get(this.Pyn)).right;
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
        this.cxM = paramMotionEvent.getX();
        this.cxN = paramMotionEvent.getY();
        localb = (b)this.Pym.get(this.Pyn);
        i = j;
        if (this.cxM >= localb.left)
        {
          i = j;
          if (this.cxM <= localb.right)
          {
            i = j;
            if (this.cxN >= localb.top)
            {
              i = j;
              if (this.cxN <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.Pyt = true;
      }
      this.Abi = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.Pyt)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.EBz = ((int)(f1 - this.cxM));
        this.Pyo = ((int)(f1 - this.Ips));
        this.cxM = f1;
        this.cxN = f2;
        paramMotionEvent = (b)this.Pym.get(0);
        localb = (b)this.Pym.get(Pys - 1);
        if (this.Pyo <= paramMotionEvent.left) {
          this.Pyo = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.Pyo >= localb.left)
          {
            this.Pyo = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= Pys) {
                break label424;
              }
              paramMotionEvent = (b)this.Pym.get(i);
              if ((this.Pyo >= paramMotionEvent.left - 5) && (this.Pyo <= paramMotionEvent.right + 5))
              {
                this.Pyn = i;
                this.Pyq = this.Pyn;
                if (this.Pyr == null) {
                  break;
                }
                this.Pyr.mL(this.Pyn);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.Pyt)
      {
        i = 0;
        for (;;)
        {
          if (i < Pys - 1)
          {
            paramMotionEvent = (b)this.Pym.get(i);
            localb = (b)this.Pym.get(i + 1);
            if ((this.Pyo > paramMotionEvent.left + this.interval / 2) || (this.Pyo < paramMotionEvent.left)) {
              break label575;
            }
            this.Pyn = i;
          }
          for (this.Pyo = paramMotionEvent.left;; this.Pyo = localb.left)
          {
            this.Pyq = this.Pyn;
            if (this.Pyr != null) {
              this.Pyr.mL(this.Pyn);
            }
            invalidate();
            this.Pyt = false;
            bool = true;
            break;
            if ((this.Pyo < localb.left - this.interval / 2) || (this.Pyo > localb.left)) {
              break label626;
            }
            this.Pyn = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.Abi);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.cxM) <= 10.0F) && (Math.abs(f2 - this.cxN) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < Pys)
      {
        paramMotionEvent = (b)this.Pym.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.Pyn = i;
        this.Pyq = this.Pyn;
        this.Pyo = paramMotionEvent.left;
        if (this.Pyr != null) {
          this.Pyr.mL(this.Pyn);
        }
      }
      this.Abi = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontSelectorView.a parama)
  {
    this.Pyr = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    AppMethodBeat.i(298643);
    paramInt = Math.min(7, Math.max(0, paramInt));
    this.Pyq = paramInt;
    if (this.Pyr != null) {
      this.Pyr.mL(paramInt);
    }
    AppMethodBeat.o(298643);
  }
  
  static final class b
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */