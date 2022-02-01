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
import com.tencent.mm.ui.aq;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView
  extends View
{
  private static SoftReference<Bitmap> zaX = null;
  private static int zbg = 8;
  private float aTL;
  private float aTM;
  private int gxu;
  private boolean ryP;
  private int topOffset;
  private int uOo;
  private List<b> zaY;
  private int zaZ;
  private int zba;
  private int zbb;
  private int zbc;
  private int zbd;
  private int zbe;
  private a zbf;
  private boolean zbh;
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74626);
    this.zaY = new ArrayList(8);
    this.zaZ = 0;
    this.topOffset = 0;
    this.uOo = 0;
    this.gxu = 0;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.zba = 0;
    this.zbb = 0;
    this.zbc = 0;
    this.zbd = 0;
    this.zbe = 0;
    this.zbf = null;
    this.zbh = false;
    this.ryP = false;
    AppMethodBeat.o(74626);
  }
  
  public FontSelectorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(74627);
    this.zaY = new ArrayList(8);
    this.zaZ = 0;
    this.topOffset = 0;
    this.uOo = 0;
    this.gxu = 0;
    this.aTL = 0.0F;
    this.aTM = 0.0F;
    this.zba = 0;
    this.zbb = 0;
    this.zbc = 0;
    this.zbd = 0;
    this.zbe = 0;
    this.zbf = null;
    this.zbh = false;
    this.ryP = false;
    AppMethodBeat.o(74627);
  }
  
  private static int by(float paramFloat)
  {
    AppMethodBeat.i(74632);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(74632);
    return i;
  }
  
  public static void dRK()
  {
    zbg = 8;
  }
  
  private void dRL()
  {
    AppMethodBeat.i(74629);
    if ((zaX == null) || (zaX.get() == null)) {
      zaX = new SoftReference(BitmapFactory.decodeResource(getResources(), 2131232423));
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
    dRL();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.zaZ, this.uOo, i - this.zaZ, this.uOo, (Paint)localObject);
    i = 0;
    while (i < zbg)
    {
      paramCanvas.drawLine(this.zaZ + this.gxu * i, this.uOo - j, this.zaZ + this.gxu * i, this.uOo + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)zaX.get();
    if (localObject == null) {
      dRL();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.zbb, this.zbc, null);
    String str = getResources().getString(2131763125);
    getResources().getString(2131763124);
    getResources().getString(2131763127);
    float f = aq.ay(getContext(), 2131165517) * a.id(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = by(f);
    localPaint.setColor(getResources().getColor(2131100711));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.zaZ - i / 2, this.uOo - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aq.ay(getContext(), 2131165517) * a.ie(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = by(f);
    paramCanvas.drawText(str, this.zaZ + this.gxu * 1 - i / 2, this.uOo - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = aq.ay(getContext(), 2131165517) * a.ik(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = by(f);
    paramCanvas.drawText("A", this.zaZ + this.gxu * (zbg - 1) - i / 2, this.uOo - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(74630);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(74628);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    dRL();
    this.zaY.clear();
    setClickable(true);
    this.zaZ = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.uOo = (paramInt2 / 2 + paramInt3);
    zbg = 8;
    this.gxu = ((paramInt1 - this.zaZ * 2) / (zbg - 1));
    Object localObject2 = (Bitmap)zaX.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      dRL();
      localObject1 = (Bitmap)zaX.get();
    }
    paramInt1 = 0;
    while (paramInt1 < zbg)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.zaZ + this.gxu * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.uOo - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.zaZ + this.gxu * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.uOo + ((Bitmap)localObject1).getHeight() / 2);
      this.zaY.add(localObject2);
      paramInt1 += 1;
    }
    this.zba = this.zbe;
    if (this.zbd >= 0) {
      this.zbb = ((b)this.zaY.get(this.zba)).left;
    }
    for (;;)
    {
      this.zbc = ((b)this.zaY.get(this.zba)).top;
      invalidate();
      AppMethodBeat.o(74628);
      return;
      if (this.zbb <= ((b)this.zaY.get(this.zba)).right - this.gxu / 2) {
        this.zbb = ((b)this.zaY.get(this.zba)).left;
      } else {
        this.zbb = ((b)this.zaY.get(this.zba)).right;
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
        this.aTL = paramMotionEvent.getX();
        this.aTM = paramMotionEvent.getY();
        localb = (b)this.zaY.get(this.zba);
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
        this.zbh = true;
      }
      this.ryP = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.zbh)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.zbd = ((int)(f1 - this.aTL));
        this.zbb = ((int)(f1 - this.zaZ));
        this.aTL = f1;
        this.aTM = f2;
        paramMotionEvent = (b)this.zaY.get(0);
        localb = (b)this.zaY.get(zbg - 1);
        if (this.zbb <= paramMotionEvent.left) {
          this.zbb = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.zbb >= localb.left)
          {
            this.zbb = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= zbg) {
                break label424;
              }
              paramMotionEvent = (b)this.zaY.get(i);
              if ((this.zbb >= paramMotionEvent.left - 5) && (this.zbb <= paramMotionEvent.right + 5))
              {
                this.zba = i;
                this.zbe = this.zba;
                if (this.zbf == null) {
                  break;
                }
                this.zbf.PL(this.zba);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.zbh)
      {
        i = 0;
        for (;;)
        {
          if (i < zbg - 1)
          {
            paramMotionEvent = (b)this.zaY.get(i);
            localb = (b)this.zaY.get(i + 1);
            if ((this.zbb > paramMotionEvent.left + this.gxu / 2) || (this.zbb < paramMotionEvent.left)) {
              break label575;
            }
            this.zba = i;
          }
          for (this.zbb = paramMotionEvent.left;; this.zbb = localb.left)
          {
            this.zbe = this.zba;
            if (this.zbf != null) {
              this.zbf.PL(this.zba);
            }
            invalidate();
            this.zbh = false;
            bool = true;
            break;
            if ((this.zbb < localb.left - this.gxu / 2) || (this.zbb > localb.left)) {
              break label626;
            }
            this.zba = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.ryP);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.aTL) <= 10.0F) && (Math.abs(f2 - this.aTM) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < zbg)
      {
        paramMotionEvent = (b)this.zaY.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.zba = i;
        this.zbe = this.zba;
        this.zbb = paramMotionEvent.left;
        if (this.zbf != null) {
          this.zbf.PL(this.zba);
        }
      }
      this.ryP = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(a parama)
  {
    this.zbf = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.zbe = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void PL(int paramInt);
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.FontSelectorView
 * JD-Core Version:    0.7.0.1
 */