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
  private final float JQZ;
  private float JRa;
  private float JRb;
  private float JRc;
  private b JRd;
  private Canvas JRe;
  private Bitmap JRf;
  final View JRg;
  private final Rect JRh;
  private final int[] JRi;
  private final ViewTreeObserver.OnPreDrawListener JRj;
  boolean JRk;
  private boolean JRl;
  private final Runnable JRm;
  private Drawable JRn;
  private boolean JRo;
  private boolean JRp;
  private final ViewGroup iOJ;
  private int left;
  private final Paint paint;
  private int top;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.JQZ = 8.0F;
    this.JRa = 16.0F;
    this.JRb = 1.0F;
    this.JRc = 1.0F;
    this.JRh = new Rect();
    this.JRi = new int[2];
    this.JRj = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.JRk)
        {
          a locala = a.this;
          locala.JRk = true;
          locala.JRg.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.JRl = true;
    this.JRm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.JRk = false;
        AppMethodBeat.o(142706);
      }
    };
    this.JRo = true;
    this.paint = new Paint();
    this.iOJ = paramViewGroup;
    this.JRg = paramView;
    this.JRd = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (jT(i, j))
    {
      this.JRg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.JRg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.JRg.getMeasuredWidth();
            int j = a.this.JRg.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.JRg.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int adk(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int bR(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void fEe()
  {
    AppMethodBeat.i(142713);
    this.JRg.getDrawingRect(this.JRh);
    if (this.JRo) {}
    for (;;)
    {
      try
      {
        this.iOJ.offsetDescendantRectToMyCoords(this.JRg, this.JRh);
        this.JRh.offset(this.left, this.top);
        float f1 = this.JRb * 8.0F;
        float f2 = this.JRc * 8.0F;
        float f3 = -this.JRh.left / f1;
        float f4 = -this.JRh.top / f2;
        float f5 = this.JRg.getTranslationX() / f1;
        float f6 = this.JRg.getTranslationY() / f2;
        this.JRe.translate(f3 - f5, f4 - f6);
        this.JRe.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.JRo = false;
        continue;
      }
      this.JRg.getLocationInWindow(this.JRi);
      this.JRh.offset(this.JRi[0], this.JRi[1]);
    }
  }
  
  private static boolean jT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((bR(paramInt2) == 0) || (bR(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void jU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = bR(paramInt1);
    paramInt2 = bR(paramInt2);
    int i = adk(paramInt1);
    int j = adk(paramInt2);
    this.JRc = (paramInt2 / j);
    this.JRb = (paramInt1 / i);
    this.JRf = Bitmap.createBitmap(i, j, this.JRd.fEj());
    AppMethodBeat.o(142712);
  }
  
  public final void F(Drawable paramDrawable)
  {
    this.JRn = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.JRd = paramb;
  }
  
  public final void adl(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void bS(float paramFloat)
  {
    this.JRa = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    xT(false);
    this.JRd.destroy();
    if (this.JRf != null) {
      this.JRf.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void fEf()
  {
    AppMethodBeat.i(142715);
    this.JRg.post(this.JRm);
    AppMethodBeat.o(142715);
  }
  
  public final void fEg()
  {
    AppMethodBeat.i(142716);
    init(this.JRg.getMeasuredWidth(), this.JRg.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void fEh()
  {
    this.JRp = true;
  }
  
  public final void fEi()
  {
    this.JRo = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (jT(paramInt1, paramInt2))
    {
      this.JRl = false;
      this.JRg.setWillNotDraw(true);
      xT(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.JRl = true;
    this.JRg.setWillNotDraw(false);
    jU(paramInt1, paramInt2);
    this.JRe = new Canvas(this.JRf);
    xT(true);
    if (this.JRp) {
      fEe();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void p(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.JRk = true;
    if (this.JRl)
    {
      if (this.JRn != null) {
        break label120;
      }
      this.JRf.eraseColor(0);
      if (!this.JRp) {
        break label134;
      }
      this.iOJ.draw(this.JRe);
    }
    for (;;)
    {
      this.JRf = this.JRd.d(this.JRf, this.JRa);
      paramCanvas.save();
      paramCanvas.scale(this.JRb * 8.0F, this.JRc * 8.0F);
      paramCanvas.drawBitmap(this.JRf, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.JRn.draw(this.JRe);
      break;
      label134:
      this.JRe.save();
      fEe();
      this.iOJ.draw(this.JRe);
      this.JRe.restore();
    }
  }
  
  public final void xS(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.JRl = paramBoolean;
    xT(paramBoolean);
    this.JRg.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void xT(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.JRg.getViewTreeObserver().removeOnPreDrawListener(this.JRj);
    if (paramBoolean) {
      this.JRg.getViewTreeObserver().addOnPreDrawListener(this.JRj);
    }
    AppMethodBeat.o(142719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */