package com.tencent.mm.ui.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements c
{
  private final float aecI;
  private float aecJ;
  private float aecK;
  private b aecL;
  private Bitmap aecM;
  final View aecN;
  private final Rect aecO;
  private final int[] aecP;
  private final ViewTreeObserver.OnPreDrawListener aecQ;
  boolean aecR;
  private boolean aecS;
  private final Runnable aecT;
  private Drawable aecU;
  private boolean aecV;
  private boolean aecW;
  private Canvas avB;
  private float ayo;
  private int left;
  private final Paint paint;
  private final ViewGroup pzj;
  private int top;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.aecI = 8.0F;
    this.ayo = 16.0F;
    this.aecJ = 1.0F;
    this.aecK = 1.0F;
    this.aecO = new Rect();
    this.aecP = new int[2];
    this.aecQ = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.aecR)
        {
          a locala = a.this;
          locala.aecR = true;
          locala.aecN.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.aecS = true;
    this.aecT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.aecR = false;
        AppMethodBeat.o(142706);
      }
    };
    this.aecV = true;
    this.paint = new Paint();
    this.pzj = paramViewGroup;
    this.aecN = paramView;
    this.aecL = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (op(i, j))
    {
      this.aecN.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.aecN.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.aecN.getMeasuredWidth();
            int j = a.this.aecN.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.aecN.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int aBw(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int dZ(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void jnU()
  {
    AppMethodBeat.i(142713);
    this.aecN.getDrawingRect(this.aecO);
    if (this.aecV) {}
    for (;;)
    {
      try
      {
        this.pzj.offsetDescendantRectToMyCoords(this.aecN, this.aecO);
        this.aecO.offset(this.left, this.top);
        float f1 = this.aecJ * 8.0F;
        float f2 = this.aecK * 8.0F;
        float f3 = -this.aecO.left / f1;
        float f4 = -this.aecO.top / f2;
        float f5 = this.aecN.getTranslationX() / f1;
        float f6 = this.aecN.getTranslationY() / f2;
        this.avB.translate(f3 - f5, f4 - f6);
        this.avB.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.aecV = false;
        continue;
      }
      this.aecN.getLocationInWindow(this.aecP);
      this.aecO.offset(this.aecP[0], this.aecP[1]);
    }
  }
  
  private static boolean op(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((dZ(paramInt2) == 0) || (dZ(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void oq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = dZ(paramInt1);
    paramInt2 = dZ(paramInt2);
    int i = aBw(paramInt1);
    int j = aBw(paramInt2);
    this.aecK = (paramInt2 / j);
    this.aecJ = (paramInt1 / i);
    this.aecM = Bitmap.createBitmap(i, j, this.aecL.jnZ());
    AppMethodBeat.o(142712);
  }
  
  public final void LN(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.aecS = paramBoolean;
    LO(paramBoolean);
    this.aecN.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void LO(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.aecN.getViewTreeObserver().removeOnPreDrawListener(this.aecQ);
    if (paramBoolean) {
      this.aecN.getViewTreeObserver().addOnPreDrawListener(this.aecQ);
    }
    AppMethodBeat.o(142719);
  }
  
  public final void U(Drawable paramDrawable)
  {
    this.aecU = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.aecL = paramb;
  }
  
  public final void aBx(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    LO(false);
    this.aecL.destroy();
    if (this.aecM != null) {
      this.aecM.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void ea(float paramFloat)
  {
    this.ayo = paramFloat;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (op(paramInt1, paramInt2))
    {
      this.aecS = false;
      this.aecN.setWillNotDraw(true);
      LO(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.aecS = true;
    this.aecN.setWillNotDraw(false);
    oq(paramInt1, paramInt2);
    this.avB = new Canvas(this.aecM);
    LO(true);
    if (this.aecW) {
      jnU();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void jnV()
  {
    AppMethodBeat.i(142715);
    this.aecN.post(this.aecT);
    AppMethodBeat.o(142715);
  }
  
  public final void jnW()
  {
    AppMethodBeat.i(142716);
    init(this.aecN.getMeasuredWidth(), this.aecN.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void jnX()
  {
    this.aecW = true;
  }
  
  public final void jnY()
  {
    this.aecV = false;
  }
  
  public final void x(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.aecR = true;
    if (this.aecS)
    {
      if (this.aecU != null) {
        break label120;
      }
      this.aecM.eraseColor(0);
      if (!this.aecW) {
        break label134;
      }
      this.pzj.draw(this.avB);
    }
    for (;;)
    {
      this.aecM = this.aecL.c(this.aecM, this.ayo);
      paramCanvas.save();
      paramCanvas.scale(this.aecJ * 8.0F, this.aecK * 8.0F);
      paramCanvas.drawBitmap(this.aecM, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.aecU.draw(this.avB);
      break;
      label134:
      this.avB.save();
      jnU();
      this.pzj.draw(this.avB);
      this.avB.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */