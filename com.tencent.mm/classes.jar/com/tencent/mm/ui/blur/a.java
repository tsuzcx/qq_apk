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
  private final float GiD;
  private float GiE;
  private float GiF;
  private float GiG;
  private b GiH;
  private Canvas GiI;
  private Bitmap GiJ;
  final View GiK;
  private final Rect GiL;
  private final int[] GiM;
  private final ViewTreeObserver.OnPreDrawListener GiN;
  boolean GiO;
  private boolean GiP;
  private final Runnable GiQ;
  private Drawable GiR;
  private boolean GiS;
  private boolean GiT;
  private final ViewGroup hSI;
  private int left;
  private final Paint paint;
  private int top;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.GiD = 8.0F;
    this.GiE = 16.0F;
    this.GiF = 1.0F;
    this.GiG = 1.0F;
    this.GiL = new Rect();
    this.GiM = new int[2];
    this.GiN = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.GiO)
        {
          a locala = a.this;
          locala.GiO = true;
          locala.GiK.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.GiP = true;
    this.GiQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.GiO = false;
        AppMethodBeat.o(142706);
      }
    };
    this.GiS = true;
    this.paint = new Paint();
    this.hSI = paramViewGroup;
    this.GiK = paramView;
    this.GiH = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (jr(i, j))
    {
      this.GiK.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.GiK.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.GiK.getMeasuredWidth();
            int j = a.this.GiK.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.GiK.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int Yh(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int bG(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void eUa()
  {
    AppMethodBeat.i(142713);
    this.GiK.getDrawingRect(this.GiL);
    if (this.GiS) {}
    for (;;)
    {
      try
      {
        this.hSI.offsetDescendantRectToMyCoords(this.GiK, this.GiL);
        this.GiL.offset(this.left, this.top);
        float f1 = this.GiF * 8.0F;
        float f2 = this.GiG * 8.0F;
        float f3 = -this.GiL.left / f1;
        float f4 = -this.GiL.top / f2;
        float f5 = this.GiK.getTranslationX() / f1;
        float f6 = this.GiK.getTranslationY() / f2;
        this.GiI.translate(f3 - f5, f4 - f6);
        this.GiI.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.GiS = false;
        continue;
      }
      this.GiK.getLocationInWindow(this.GiM);
      this.GiL.offset(this.GiM[0], this.GiM[1]);
    }
  }
  
  private static boolean jr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((bG(paramInt2) == 0) || (bG(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void js(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = bG(paramInt1);
    paramInt2 = bG(paramInt2);
    int i = Yh(paramInt1);
    int j = Yh(paramInt2);
    this.GiG = (paramInt2 / j);
    this.GiF = (paramInt1 / i);
    this.GiJ = Bitmap.createBitmap(i, j, this.GiH.eUf());
    AppMethodBeat.o(142712);
  }
  
  public final void F(Drawable paramDrawable)
  {
    this.GiR = paramDrawable;
  }
  
  public final void Yi(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void a(b paramb)
  {
    this.GiH = paramb;
  }
  
  public final void bH(float paramFloat)
  {
    this.GiE = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    vX(false);
    this.GiH.destroy();
    if (this.GiJ != null) {
      this.GiJ.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void eUb()
  {
    AppMethodBeat.i(142715);
    this.GiK.post(this.GiQ);
    AppMethodBeat.o(142715);
  }
  
  public final void eUc()
  {
    AppMethodBeat.i(142716);
    init(this.GiK.getMeasuredWidth(), this.GiK.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void eUd()
  {
    this.GiT = true;
  }
  
  public final void eUe()
  {
    this.GiS = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (jr(paramInt1, paramInt2))
    {
      this.GiP = false;
      this.GiK.setWillNotDraw(true);
      vX(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.GiP = true;
    this.GiK.setWillNotDraw(false);
    js(paramInt1, paramInt2);
    this.GiI = new Canvas(this.GiJ);
    vX(true);
    if (this.GiT) {
      eUa();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.GiO = true;
    if (this.GiP)
    {
      if (this.GiR != null) {
        break label120;
      }
      this.GiJ.eraseColor(0);
      if (!this.GiT) {
        break label134;
      }
      this.hSI.draw(this.GiI);
    }
    for (;;)
    {
      this.GiJ = this.GiH.d(this.GiJ, this.GiE);
      paramCanvas.save();
      paramCanvas.scale(this.GiF * 8.0F, this.GiG * 8.0F);
      paramCanvas.drawBitmap(this.GiJ, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.GiR.draw(this.GiI);
      break;
      label134:
      this.GiI.save();
      eUa();
      this.hSI.draw(this.GiI);
      this.GiI.restore();
    }
  }
  
  public final void vW(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.GiP = paramBoolean;
    vX(paramBoolean);
    this.GiK.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.GiK.getViewTreeObserver().removeOnPreDrawListener(this.GiN);
    if (paramBoolean) {
      this.GiK.getViewTreeObserver().addOnPreDrawListener(this.GiN);
    }
    AppMethodBeat.o(142719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */