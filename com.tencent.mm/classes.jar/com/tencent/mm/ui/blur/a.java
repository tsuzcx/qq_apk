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
  private final float Jwj;
  private float Jwk;
  private float Jwl;
  private float Jwm;
  private b Jwn;
  private Canvas Jwo;
  private Bitmap Jwp;
  final View Jwq;
  private final Rect Jwr;
  private final int[] Jws;
  private final ViewTreeObserver.OnPreDrawListener Jwt;
  boolean Jwu;
  private boolean Jwv;
  private final Runnable Jww;
  private Drawable Jwx;
  private boolean Jwy;
  private boolean Jwz;
  private final ViewGroup iLQ;
  private int left;
  private final Paint paint;
  private int top;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.Jwj = 8.0F;
    this.Jwk = 16.0F;
    this.Jwl = 1.0F;
    this.Jwm = 1.0F;
    this.Jwr = new Rect();
    this.Jws = new int[2];
    this.Jwt = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.Jwu)
        {
          a locala = a.this;
          locala.Jwu = true;
          locala.Jwq.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.Jwv = true;
    this.Jww = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.Jwu = false;
        AppMethodBeat.o(142706);
      }
    };
    this.Jwy = true;
    this.paint = new Paint();
    this.iLQ = paramViewGroup;
    this.Jwq = paramView;
    this.Jwn = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (jP(i, j))
    {
      this.Jwq.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.Jwq.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.Jwq.getMeasuredWidth();
            int j = a.this.Jwq.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.Jwq.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int acC(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int bT(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void fAc()
  {
    AppMethodBeat.i(142713);
    this.Jwq.getDrawingRect(this.Jwr);
    if (this.Jwy) {}
    for (;;)
    {
      try
      {
        this.iLQ.offsetDescendantRectToMyCoords(this.Jwq, this.Jwr);
        this.Jwr.offset(this.left, this.top);
        float f1 = this.Jwl * 8.0F;
        float f2 = this.Jwm * 8.0F;
        float f3 = -this.Jwr.left / f1;
        float f4 = -this.Jwr.top / f2;
        float f5 = this.Jwq.getTranslationX() / f1;
        float f6 = this.Jwq.getTranslationY() / f2;
        this.Jwo.translate(f3 - f5, f4 - f6);
        this.Jwo.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.Jwy = false;
        continue;
      }
      this.Jwq.getLocationInWindow(this.Jws);
      this.Jwr.offset(this.Jws[0], this.Jws[1]);
    }
  }
  
  private static boolean jP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((bT(paramInt2) == 0) || (bT(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void jQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = bT(paramInt1);
    paramInt2 = bT(paramInt2);
    int i = acC(paramInt1);
    int j = acC(paramInt2);
    this.Jwm = (paramInt2 / j);
    this.Jwl = (paramInt1 / i);
    this.Jwp = Bitmap.createBitmap(i, j, this.Jwn.fAh());
    AppMethodBeat.o(142712);
  }
  
  public final void E(Drawable paramDrawable)
  {
    this.Jwx = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.Jwn = paramb;
  }
  
  public final void acD(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void bU(float paramFloat)
  {
    this.Jwk = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    xM(false);
    this.Jwn.destroy();
    if (this.Jwp != null) {
      this.Jwp.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void fAd()
  {
    AppMethodBeat.i(142715);
    this.Jwq.post(this.Jww);
    AppMethodBeat.o(142715);
  }
  
  public final void fAe()
  {
    AppMethodBeat.i(142716);
    init(this.Jwq.getMeasuredWidth(), this.Jwq.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void fAf()
  {
    this.Jwz = true;
  }
  
  public final void fAg()
  {
    this.Jwy = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (jP(paramInt1, paramInt2))
    {
      this.Jwv = false;
      this.Jwq.setWillNotDraw(true);
      xM(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.Jwv = true;
    this.Jwq.setWillNotDraw(false);
    jQ(paramInt1, paramInt2);
    this.Jwo = new Canvas(this.Jwp);
    xM(true);
    if (this.Jwz) {
      fAc();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void p(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.Jwu = true;
    if (this.Jwv)
    {
      if (this.Jwx != null) {
        break label120;
      }
      this.Jwp.eraseColor(0);
      if (!this.Jwz) {
        break label134;
      }
      this.iLQ.draw(this.Jwo);
    }
    for (;;)
    {
      this.Jwp = this.Jwn.d(this.Jwp, this.Jwk);
      paramCanvas.save();
      paramCanvas.scale(this.Jwl * 8.0F, this.Jwm * 8.0F);
      paramCanvas.drawBitmap(this.Jwp, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.Jwx.draw(this.Jwo);
      break;
      label134:
      this.Jwo.save();
      fAc();
      this.iLQ.draw(this.Jwo);
      this.Jwo.restore();
    }
  }
  
  public final void xL(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.Jwv = paramBoolean;
    xM(paramBoolean);
    this.Jwq.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.Jwq.getViewTreeObserver().removeOnPreDrawListener(this.Jwt);
    if (paramBoolean) {
      this.Jwq.getViewTreeObserver().addOnPreDrawListener(this.Jwt);
    }
    AppMethodBeat.o(142719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */