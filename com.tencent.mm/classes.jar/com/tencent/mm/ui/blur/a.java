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
  boolean WvA;
  private boolean WvB;
  private final Runnable WvC;
  private Drawable WvD;
  private boolean WvE;
  private boolean WvF;
  private final float Wvq;
  private float Wvr;
  private float Wvs;
  private b Wvt;
  private Canvas Wvu;
  private Bitmap Wvv;
  final View Wvw;
  private final Rect Wvx;
  private final int[] Wvy;
  private final ViewTreeObserver.OnPreDrawListener Wvz;
  private int left;
  private final ViewGroup mCC;
  private final Paint paint;
  private int top;
  private float ztt;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.Wvq = 8.0F;
    this.ztt = 16.0F;
    this.Wvr = 1.0F;
    this.Wvs = 1.0F;
    this.Wvx = new Rect();
    this.Wvy = new int[2];
    this.Wvz = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.WvA)
        {
          a locala = a.this;
          locala.WvA = true;
          locala.Wvw.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.WvB = true;
    this.WvC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.WvA = false;
        AppMethodBeat.o(142706);
      }
    };
    this.WvE = true;
    this.paint = new Paint();
    this.mCC = paramViewGroup;
    this.Wvw = paramView;
    this.Wvt = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (mv(i, j))
    {
      this.Wvw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.Wvw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.Wvw.getMeasuredWidth();
            int j = a.this.Wvw.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.Wvw.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int auU(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int cL(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void hLs()
  {
    AppMethodBeat.i(142713);
    this.Wvw.getDrawingRect(this.Wvx);
    if (this.WvE) {}
    for (;;)
    {
      try
      {
        this.mCC.offsetDescendantRectToMyCoords(this.Wvw, this.Wvx);
        this.Wvx.offset(this.left, this.top);
        float f1 = this.Wvr * 8.0F;
        float f2 = this.Wvs * 8.0F;
        float f3 = -this.Wvx.left / f1;
        float f4 = -this.Wvx.top / f2;
        float f5 = this.Wvw.getTranslationX() / f1;
        float f6 = this.Wvw.getTranslationY() / f2;
        this.Wvu.translate(f3 - f5, f4 - f6);
        this.Wvu.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.WvE = false;
        continue;
      }
      this.Wvw.getLocationInWindow(this.Wvy);
      this.Wvx.offset(this.Wvy[0], this.Wvy[1]);
    }
  }
  
  private static boolean mv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((cL(paramInt2) == 0) || (cL(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void mw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = cL(paramInt1);
    paramInt2 = cL(paramInt2);
    int i = auU(paramInt1);
    int j = auU(paramInt2);
    this.Wvs = (paramInt2 / j);
    this.Wvr = (paramInt1 / i);
    this.Wvv = Bitmap.createBitmap(i, j, this.Wvt.hLx());
    AppMethodBeat.o(142712);
  }
  
  public final void C(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.WvA = true;
    if (this.WvB)
    {
      if (this.WvD != null) {
        break label118;
      }
      this.Wvv.eraseColor(0);
      if (!this.WvF) {
        break label132;
      }
      this.mCC.draw(this.Wvu);
    }
    for (;;)
    {
      this.Wvv = this.Wvt.b(this.Wvv, this.ztt);
      paramCanvas.save();
      paramCanvas.scale(this.Wvr * 8.0F, this.Wvs * 8.0F);
      paramCanvas.drawBitmap(this.Wvv, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label118:
      this.WvD.draw(this.Wvu);
      break;
      label132:
      this.Wvu.save();
      hLs();
      this.mCC.draw(this.Wvu);
      this.Wvu.restore();
    }
  }
  
  public final void Gb(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.WvB = paramBoolean;
    Gc(paramBoolean);
    this.Wvw.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void Gc(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.Wvw.getViewTreeObserver().removeOnPreDrawListener(this.Wvz);
    if (paramBoolean) {
      this.Wvw.getViewTreeObserver().addOnPreDrawListener(this.Wvz);
    }
    AppMethodBeat.o(142719);
  }
  
  public final void K(Drawable paramDrawable)
  {
    this.WvD = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.Wvt = paramb;
  }
  
  public final void auV(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void cM(float paramFloat)
  {
    this.ztt = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    Gc(false);
    this.Wvt.destroy();
    if (this.Wvv != null) {
      this.Wvv.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void hLt()
  {
    AppMethodBeat.i(142715);
    this.Wvw.post(this.WvC);
    AppMethodBeat.o(142715);
  }
  
  public final void hLu()
  {
    AppMethodBeat.i(142716);
    init(this.Wvw.getMeasuredWidth(), this.Wvw.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void hLv()
  {
    this.WvF = true;
  }
  
  public final void hLw()
  {
    this.WvE = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (mv(paramInt1, paramInt2))
    {
      this.WvB = false;
      this.Wvw.setWillNotDraw(true);
      Gc(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.WvB = true;
    this.Wvw.setWillNotDraw(false);
    mw(paramInt1, paramInt2);
    this.Wvu = new Canvas(this.Wvv);
    Gc(true);
    if (this.WvF) {
      hLs();
    }
    AppMethodBeat.o(142710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */