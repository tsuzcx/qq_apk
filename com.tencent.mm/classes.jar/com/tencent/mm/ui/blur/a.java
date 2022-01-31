package com.tencent.mm.ui.blur;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements c
{
  private float blurRadius;
  private int left;
  private final ViewGroup oPl;
  private final Paint paint;
  private int top;
  private float zuA;
  private b zuB;
  private Canvas zuC;
  private Bitmap zuD;
  final View zuE;
  private final Rect zuF;
  private final int[] zuG;
  private final ViewTreeObserver.OnPreDrawListener zuH;
  boolean zuI;
  private boolean zuJ;
  private final Runnable zuK;
  private Drawable zuL;
  private boolean zuM;
  private boolean zuN;
  private final float zuy;
  private float zuz;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(155343);
    this.zuy = 8.0F;
    this.blurRadius = 16.0F;
    this.zuz = 1.0F;
    this.zuA = 1.0F;
    this.zuF = new Rect();
    this.zuG = new int[2];
    this.zuH = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(155341);
        if (!a.this.zuI)
        {
          a locala = a.this;
          locala.zuI = true;
          locala.zuE.invalidate();
        }
        AppMethodBeat.o(155341);
        return true;
      }
    };
    this.zuJ = true;
    this.zuK = new Runnable()
    {
      public final void run()
      {
        a.this.zuI = false;
      }
    };
    this.zuM = true;
    this.paint = new Paint();
    this.oPl = paramViewGroup;
    this.zuE = paramView;
    this.zuB = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (hD(i, j))
    {
      this.zuE.getViewTreeObserver().addOnGlobalLayoutListener(new a.3(this));
      AppMethodBeat.o(155343);
      return;
    }
    init(i, j);
    AppMethodBeat.o(155343);
  }
  
  private static int Pb(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int bu(float paramFloat)
  {
    AppMethodBeat.i(155344);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(155344);
    return i;
  }
  
  private void dFh()
  {
    AppMethodBeat.i(155348);
    this.zuE.getDrawingRect(this.zuF);
    if (this.zuM) {}
    for (;;)
    {
      try
      {
        this.oPl.offsetDescendantRectToMyCoords(this.zuE, this.zuF);
        this.zuF.offset(this.left, this.top);
        float f1 = this.zuz * 8.0F;
        float f2 = this.zuA * 8.0F;
        float f3 = -this.zuF.left / f1;
        float f4 = -this.zuF.top / f2;
        float f5 = this.zuE.getTranslationX() / f1;
        float f6 = this.zuE.getTranslationY() / f2;
        this.zuC.translate(f3 - f5, f4 - f6);
        this.zuC.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(155348);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.zuM = false;
        continue;
      }
      this.zuE.getLocationInWindow(this.zuG);
      this.zuF.offset(this.zuG[0], this.zuG[1]);
    }
  }
  
  private static boolean hD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155346);
    if ((bu(paramInt2) == 0) || (bu(paramInt1) == 0))
    {
      AppMethodBeat.o(155346);
      return true;
    }
    AppMethodBeat.o(155346);
    return false;
  }
  
  private void hE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155347);
    paramInt1 = bu(paramInt1);
    paramInt2 = bu(paramInt2);
    int i = Pb(paramInt1);
    int j = Pb(paramInt2);
    this.zuA = (paramInt2 / j);
    this.zuz = (paramInt1 / i);
    this.zuD = Bitmap.createBitmap(i, j, this.zuB.dFm());
    AppMethodBeat.o(155347);
  }
  
  public final void Pc(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void a(b paramb)
  {
    this.zuB = paramb;
  }
  
  public final void bv(float paramFloat)
  {
    this.blurRadius = paramFloat;
  }
  
  public final void dFi()
  {
    AppMethodBeat.i(155350);
    this.zuE.post(this.zuK);
    AppMethodBeat.o(155350);
  }
  
  public final void dFj()
  {
    AppMethodBeat.i(155351);
    init(this.zuE.getMeasuredWidth(), this.zuE.getMeasuredHeight());
    AppMethodBeat.o(155351);
  }
  
  public final void dFk()
  {
    this.zuN = true;
  }
  
  public final void dFl()
  {
    this.zuM = false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(155352);
    qP(false);
    this.zuB.destroy();
    if (this.zuD != null) {
      this.zuD.recycle();
    }
    AppMethodBeat.o(155352);
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155345);
    if (hD(paramInt1, paramInt2))
    {
      this.zuJ = false;
      this.zuE.setWillNotDraw(true);
      qP(false);
      AppMethodBeat.o(155345);
      return;
    }
    this.zuJ = true;
    this.zuE.setWillNotDraw(false);
    hE(paramInt1, paramInt2);
    this.zuC = new Canvas(this.zuD);
    qP(true);
    if (this.zuN) {
      dFh();
    }
    AppMethodBeat.o(155345);
  }
  
  public final void n(Canvas paramCanvas)
  {
    AppMethodBeat.i(155349);
    this.zuI = true;
    if (this.zuJ)
    {
      if (this.zuL != null) {
        break label120;
      }
      this.zuD.eraseColor(0);
      if (!this.zuN) {
        break label134;
      }
      this.oPl.draw(this.zuC);
    }
    for (;;)
    {
      this.zuD = this.zuB.e(this.zuD, this.blurRadius);
      paramCanvas.save();
      paramCanvas.scale(this.zuz * 8.0F, this.zuA * 8.0F);
      paramCanvas.drawBitmap(this.zuD, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(155349);
      return;
      label120:
      this.zuL.draw(this.zuC);
      break;
      label134:
      this.zuC.save();
      dFh();
      this.oPl.draw(this.zuC);
      this.zuC.restore();
    }
  }
  
  public final void qO(boolean paramBoolean)
  {
    AppMethodBeat.i(155353);
    this.zuJ = paramBoolean;
    qP(paramBoolean);
    this.zuE.invalidate();
    AppMethodBeat.o(155353);
  }
  
  public final void qP(boolean paramBoolean)
  {
    AppMethodBeat.i(155354);
    this.zuE.getViewTreeObserver().removeOnPreDrawListener(this.zuH);
    if (paramBoolean) {
      this.zuE.getViewTreeObserver().addOnPreDrawListener(this.zuH);
    }
    AppMethodBeat.o(155354);
  }
  
  public final void w(Drawable paramDrawable)
  {
    this.zuL = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */