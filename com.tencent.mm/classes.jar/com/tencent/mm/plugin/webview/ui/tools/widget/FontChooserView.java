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
import com.tencent.mm.ui.ao;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView
  extends View
{
  private static SoftReference<Bitmap> xwc = null;
  private static int xwl = 8;
  private FontChooserView.a CMj;
  private int gbd;
  private float rYu;
  private boolean rZg;
  private int tAa;
  private float tmJ;
  private int topOffset;
  private List<b> xwd;
  private int xwe;
  private int xwf;
  private int xwg;
  private int xwh;
  private int xwi;
  private int xwj;
  private boolean xwm;
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82105);
    this.xwd = new ArrayList(8);
    this.xwe = 0;
    this.topOffset = 0;
    this.tAa = 0;
    this.gbd = 0;
    this.rYu = 0.0F;
    this.tmJ = 0.0F;
    this.xwf = 0;
    this.xwg = 0;
    this.xwh = 0;
    this.xwi = 0;
    this.xwj = 0;
    this.CMj = null;
    this.xwm = false;
    this.rZg = false;
    AppMethodBeat.o(82105);
  }
  
  public FontChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82106);
    this.xwd = new ArrayList(8);
    this.xwe = 0;
    this.topOffset = 0;
    this.tAa = 0;
    this.gbd = 0;
    this.rYu = 0.0F;
    this.tmJ = 0.0F;
    this.xwf = 0;
    this.xwg = 0;
    this.xwh = 0;
    this.xwi = 0;
    this.xwj = 0;
    this.CMj = null;
    this.xwm = false;
    this.rZg = false;
    AppMethodBeat.o(82106);
  }
  
  private static int bx(float paramFloat)
  {
    AppMethodBeat.i(82111);
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramFloat);
    localPaint.setAntiAlias(true);
    int i = (int)Math.ceil(localPaint.getFontMetrics().bottom);
    AppMethodBeat.o(82111);
    return i;
  }
  
  private void dCL()
  {
    AppMethodBeat.i(82108);
    if ((xwc == null) || (xwc.get() == null)) {
      xwc = new SoftReference(BitmapFactory.decodeResource(getResources(), 2131232423));
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
    dCL();
    Object localObject = new Paint();
    ((Paint)localObject).setARGB(255, 152, 152, 152);
    ((Paint)localObject).setStrokeWidth(2.0F);
    int i = getWidth();
    int j = a.fromDPToPix(getContext(), 5);
    paramCanvas.drawLine(this.xwe, this.tAa, i - this.xwe, this.tAa, (Paint)localObject);
    i = 0;
    while (i < xwl)
    {
      paramCanvas.drawLine(this.xwe + this.gbd * i, this.tAa - j, this.xwe + this.gbd * i, this.tAa + j, (Paint)localObject);
      i += 1;
    }
    localObject = (Bitmap)xwc.get();
    if (localObject == null) {
      dCL();
    }
    paramCanvas.drawBitmap((Bitmap)localObject, this.xwg, this.xwh, null);
    String str = getResources().getString(2131766146);
    getResources().getString(2131766145);
    getResources().getString(2131766147);
    float f = ao.av(getContext(), 2131165517) * a.hP(getContext());
    Paint localPaint = new Paint();
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bx(f);
    localPaint.setColor(getResources().getColor(2131100711));
    localPaint.setAntiAlias(true);
    paramCanvas.drawText("A", this.xwe - i / 2, this.tAa - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = ao.av(getContext(), 2131165517) * a.hQ(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText(str);
    j = bx(f);
    paramCanvas.drawText(str, this.xwe + this.gbd * 1 - i / 2, this.tAa - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    f = ao.av(getContext(), 2131165517) * a.hW(getContext());
    localPaint.setTextSize(f);
    i = (int)localPaint.measureText("A");
    j = bx(f);
    paramCanvas.drawText("A", this.xwe + this.gbd * (xwl - 1) - i / 2, this.tAa - j - ((Bitmap)localObject).getHeight() / 3, localPaint);
    AppMethodBeat.o(82109);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82107);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    dCL();
    this.xwd.clear();
    setClickable(true);
    this.xwe = a.fromDPToPix(getContext(), 30);
    this.topOffset = a.fromDPToPix(getContext(), 10);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    paramInt3 = this.topOffset;
    this.tAa = (paramInt2 / 2 + paramInt3);
    xwl = 8;
    this.gbd = ((paramInt1 - this.xwe * 2) / (xwl - 1));
    Object localObject2 = (Bitmap)xwc.get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      dCL();
      localObject1 = (Bitmap)xwc.get();
    }
    paramInt1 = 0;
    while (paramInt1 < xwl)
    {
      localObject2 = new b((byte)0);
      ((b)localObject2).left = (this.xwe + this.gbd * paramInt1 - ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).top = (this.tAa - ((Bitmap)localObject1).getHeight() / 2);
      ((b)localObject2).right = (this.xwe + this.gbd * paramInt1 + ((Bitmap)localObject1).getWidth() / 2);
      ((b)localObject2).bottom = (this.tAa + ((Bitmap)localObject1).getHeight() / 2);
      this.xwd.add(localObject2);
      paramInt1 += 1;
    }
    this.xwf = this.xwj;
    if (this.xwi >= 0) {
      this.xwg = ((b)this.xwd.get(this.xwf)).left;
    }
    for (;;)
    {
      this.xwh = ((b)this.xwd.get(this.xwf)).top;
      invalidate();
      AppMethodBeat.o(82107);
      return;
      if (this.xwg <= ((b)this.xwd.get(this.xwf)).right - this.gbd / 2) {
        this.xwg = ((b)this.xwd.get(this.xwf)).left;
      } else {
        this.xwg = ((b)this.xwd.get(this.xwf)).right;
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
        this.rYu = paramMotionEvent.getX();
        this.tmJ = paramMotionEvent.getY();
        localb = (b)this.xwd.get(this.xwf);
        i = j;
        if (this.rYu >= localb.left)
        {
          i = j;
          if (this.rYu <= localb.right)
          {
            i = j;
            if (this.tmJ >= localb.top)
            {
              i = j;
              if (this.tmJ <= localb.bottom) {
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        this.xwm = true;
      }
      this.rZg = true;
    }
    label424:
    label575:
    label626:
    do
    {
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.xwm)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.xwi = ((int)(f1 - this.rYu));
        this.xwg = ((int)(f1 - this.xwe));
        this.rYu = f1;
        this.tmJ = f2;
        paramMotionEvent = (b)this.xwd.get(0);
        localb = (b)this.xwd.get(xwl - 1);
        if (this.xwg <= paramMotionEvent.left) {
          this.xwg = paramMotionEvent.left;
        }
        for (;;)
        {
          invalidate();
          bool = true;
          break;
          if (this.xwg >= localb.left)
          {
            this.xwg = localb.left;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= xwl) {
                break label424;
              }
              paramMotionEvent = (b)this.xwd.get(i);
              if ((this.xwg >= paramMotionEvent.left - 5) && (this.xwg <= paramMotionEvent.right + 5))
              {
                this.xwf = i;
                this.xwj = this.xwf;
                if (this.CMj == null) {
                  break;
                }
                this.CMj.NB(this.xwf);
                break;
              }
              i += 1;
            }
          }
        }
      }
      bool = super.onTouchEvent(paramMotionEvent);
      break;
      if (this.xwm)
      {
        i = 0;
        for (;;)
        {
          if (i < xwl - 1)
          {
            paramMotionEvent = (b)this.xwd.get(i);
            localb = (b)this.xwd.get(i + 1);
            if ((this.xwg > paramMotionEvent.left + this.gbd / 2) || (this.xwg < paramMotionEvent.left)) {
              break label575;
            }
            this.xwf = i;
          }
          for (this.xwg = paramMotionEvent.left;; this.xwg = localb.left)
          {
            this.xwj = this.xwf;
            if (this.CMj != null) {
              this.CMj.NB(this.xwf);
            }
            invalidate();
            this.xwm = false;
            bool = true;
            break;
            if ((this.xwg < localb.left - this.gbd / 2) || (this.xwg > localb.left)) {
              break label626;
            }
            this.xwf = (i + 1);
          }
          i += 1;
        }
      }
    } while (!this.rZg);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((Math.abs(f1 - this.rYu) <= 10.0F) && (Math.abs(f2 - this.tmJ) <= 10.0F)) {
      i = 0;
    }
    for (;;)
    {
      if (i < xwl)
      {
        paramMotionEvent = (b)this.xwd.get(i);
        if ((f1 < paramMotionEvent.left - 5) || (f1 > paramMotionEvent.right + 5)) {
          break label791;
        }
        this.xwf = i;
        this.xwj = this.xwf;
        this.xwg = paramMotionEvent.left;
        if (this.CMj != null) {
          this.CMj.NB(this.xwf);
        }
      }
      this.rZg = false;
      invalidate();
      bool = true;
      break;
      label791:
      i += 1;
    }
  }
  
  public void setOnChangeListener(FontChooserView.a parama)
  {
    this.CMj = parama;
  }
  
  public void setSliderIndex(int paramInt)
  {
    this.xwj = paramInt;
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