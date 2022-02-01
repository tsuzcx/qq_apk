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
  private final float Pce;
  private float Pcf;
  private float Pcg;
  private b Pch;
  private Canvas Pci;
  private Bitmap Pcj;
  final View Pck;
  private final Rect Pcl;
  private final int[] Pcm;
  private final ViewTreeObserver.OnPreDrawListener Pcn;
  boolean Pco;
  private boolean Pcp;
  private final Runnable Pcq;
  private Drawable Pcr;
  private boolean Pcs;
  private boolean Pct;
  private final ViewGroup jLy;
  private int left;
  private final Paint paint;
  private int top;
  private float uIj;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.Pce = 8.0F;
    this.uIj = 16.0F;
    this.Pcf = 1.0F;
    this.Pcg = 1.0F;
    this.Pcl = new Rect();
    this.Pcm = new int[2];
    this.Pcn = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.Pco)
        {
          a locala = a.this;
          locala.Pco = true;
          locala.Pck.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.Pcp = true;
    this.Pcq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.Pco = false;
        AppMethodBeat.o(142706);
      }
    };
    this.Pcs = true;
    this.paint = new Paint();
    this.jLy = paramViewGroup;
    this.Pck = paramView;
    this.Pch = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (lc(i, j))
    {
      this.Pck.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.Pck.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.Pck.getMeasuredWidth();
            int j = a.this.Pck.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.Pck.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int alU(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int ct(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void gMl()
  {
    AppMethodBeat.i(142713);
    this.Pck.getDrawingRect(this.Pcl);
    if (this.Pcs) {}
    for (;;)
    {
      try
      {
        this.jLy.offsetDescendantRectToMyCoords(this.Pck, this.Pcl);
        this.Pcl.offset(this.left, this.top);
        float f1 = this.Pcf * 8.0F;
        float f2 = this.Pcg * 8.0F;
        float f3 = -this.Pcl.left / f1;
        float f4 = -this.Pcl.top / f2;
        float f5 = this.Pck.getTranslationX() / f1;
        float f6 = this.Pck.getTranslationY() / f2;
        this.Pci.translate(f3 - f5, f4 - f6);
        this.Pci.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.Pcs = false;
        continue;
      }
      this.Pck.getLocationInWindow(this.Pcm);
      this.Pcl.offset(this.Pcm[0], this.Pcm[1]);
    }
  }
  
  private static boolean lc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((ct(paramInt2) == 0) || (ct(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = ct(paramInt1);
    paramInt2 = ct(paramInt2);
    int i = alU(paramInt1);
    int j = alU(paramInt2);
    this.Pcg = (paramInt2 / j);
    this.Pcf = (paramInt1 / i);
    this.Pcj = Bitmap.createBitmap(i, j, this.Pch.gMq());
    AppMethodBeat.o(142712);
  }
  
  public final void BH(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.Pcp = paramBoolean;
    BI(paramBoolean);
    this.Pck.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void BI(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.Pck.getViewTreeObserver().removeOnPreDrawListener(this.Pcn);
    if (paramBoolean) {
      this.Pck.getViewTreeObserver().addOnPreDrawListener(this.Pcn);
    }
    AppMethodBeat.o(142719);
  }
  
  public final void E(Drawable paramDrawable)
  {
    this.Pcr = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.Pch = paramb;
  }
  
  public final void alV(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void cu(float paramFloat)
  {
    this.uIj = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    BI(false);
    this.Pch.destroy();
    if (this.Pcj != null) {
      this.Pcj.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void gMm()
  {
    AppMethodBeat.i(142715);
    this.Pck.post(this.Pcq);
    AppMethodBeat.o(142715);
  }
  
  public final void gMn()
  {
    AppMethodBeat.i(142716);
    init(this.Pck.getMeasuredWidth(), this.Pck.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void gMo()
  {
    this.Pct = true;
  }
  
  public final void gMp()
  {
    this.Pcs = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (lc(paramInt1, paramInt2))
    {
      this.Pcp = false;
      this.Pck.setWillNotDraw(true);
      BI(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.Pcp = true;
    this.Pck.setWillNotDraw(false);
    ld(paramInt1, paramInt2);
    this.Pci = new Canvas(this.Pcj);
    BI(true);
    if (this.Pct) {
      gMl();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void z(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.Pco = true;
    if (this.Pcp)
    {
      if (this.Pcr != null) {
        break label120;
      }
      this.Pcj.eraseColor(0);
      if (!this.Pct) {
        break label134;
      }
      this.jLy.draw(this.Pci);
    }
    for (;;)
    {
      this.Pcj = this.Pch.b(this.Pcj, this.uIj);
      paramCanvas.save();
      paramCanvas.scale(this.Pcf * 8.0F, this.Pcg * 8.0F);
      paramCanvas.drawBitmap(this.Pcj, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.Pcr.draw(this.Pci);
      break;
      label134:
      this.Pci.save();
      gMl();
      this.jLy.draw(this.Pci);
      this.Pci.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */