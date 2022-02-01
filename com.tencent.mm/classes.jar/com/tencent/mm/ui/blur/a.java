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
  private final Rect HIA;
  private final int[] HIB;
  private final ViewTreeObserver.OnPreDrawListener HIC;
  boolean HID;
  private boolean HIE;
  private final Runnable HIF;
  private Drawable HIG;
  private boolean HIH;
  private boolean HII;
  private final float HIs;
  private float HIt;
  private float HIu;
  private float HIv;
  private b HIw;
  private Canvas HIx;
  private Bitmap HIy;
  final View HIz;
  private final ViewGroup isN;
  private int left;
  private final Paint paint;
  private int top;
  
  a(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142708);
    this.HIs = 8.0F;
    this.HIt = 16.0F;
    this.HIu = 1.0F;
    this.HIv = 1.0F;
    this.HIA = new Rect();
    this.HIB = new int[2];
    this.HIC = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(142705);
        if (!a.this.HID)
        {
          a locala = a.this;
          locala.HID = true;
          locala.HIz.invalidate();
        }
        AppMethodBeat.o(142705);
        return true;
      }
    };
    this.HIE = true;
    this.HIF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142706);
        a.this.HID = false;
        AppMethodBeat.o(142706);
      }
    };
    this.HIH = true;
    this.paint = new Paint();
    this.isN = paramViewGroup;
    this.HIz = paramView;
    this.HIw = new d();
    this.paint.setFilterBitmap(true);
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (jD(i, j))
    {
      this.HIz.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(142707);
          if (Build.VERSION.SDK_INT >= 16) {
            a.this.HIz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
          for (;;)
          {
            int i = a.this.HIz.getMeasuredWidth();
            int j = a.this.HIz.getMeasuredHeight();
            a.this.init(i, j);
            AppMethodBeat.o(142707);
            return;
            a.this.HIz.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      });
      AppMethodBeat.o(142708);
      return;
    }
    init(i, j);
    AppMethodBeat.o(142708);
  }
  
  private static int aas(int paramInt)
  {
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    return paramInt - paramInt % 16 + 16;
  }
  
  private static int bO(float paramFloat)
  {
    AppMethodBeat.i(142709);
    int i = (int)Math.ceil(paramFloat / 8.0F);
    AppMethodBeat.o(142709);
    return i;
  }
  
  private void fjN()
  {
    AppMethodBeat.i(142713);
    this.HIz.getDrawingRect(this.HIA);
    if (this.HIH) {}
    for (;;)
    {
      try
      {
        this.isN.offsetDescendantRectToMyCoords(this.HIz, this.HIA);
        this.HIA.offset(this.left, this.top);
        float f1 = this.HIu * 8.0F;
        float f2 = this.HIv * 8.0F;
        float f3 = -this.HIA.left / f1;
        float f4 = -this.HIA.top / f2;
        float f5 = this.HIz.getTranslationX() / f1;
        float f6 = this.HIz.getTranslationY() / f2;
        this.HIx.translate(f3 - f5, f4 - f6);
        this.HIx.scale(1.0F / f1, 1.0F / f2);
        AppMethodBeat.o(142713);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.HIH = false;
        continue;
      }
      this.HIz.getLocationInWindow(this.HIB);
      this.HIA.offset(this.HIB[0], this.HIB[1]);
    }
  }
  
  private static boolean jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142711);
    if ((bO(paramInt2) == 0) || (bO(paramInt1) == 0))
    {
      AppMethodBeat.o(142711);
      return true;
    }
    AppMethodBeat.o(142711);
    return false;
  }
  
  private void jE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142712);
    paramInt1 = bO(paramInt1);
    paramInt2 = bO(paramInt2);
    int i = aas(paramInt1);
    int j = aas(paramInt2);
    this.HIv = (paramInt2 / j);
    this.HIu = (paramInt1 / i);
    this.HIy = Bitmap.createBitmap(i, j, this.HIw.fjS());
    AppMethodBeat.o(142712);
  }
  
  public final void E(Drawable paramDrawable)
  {
    this.HIG = paramDrawable;
  }
  
  public final void a(b paramb)
  {
    this.HIw = paramb;
  }
  
  public final void aat(int paramInt)
  {
    this.top = paramInt;
  }
  
  public final void bP(float paramFloat)
  {
    this.HIt = paramFloat;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(142717);
    xb(false);
    this.HIw.destroy();
    if (this.HIy != null) {
      this.HIy.recycle();
    }
    AppMethodBeat.o(142717);
  }
  
  public final void fjO()
  {
    AppMethodBeat.i(142715);
    this.HIz.post(this.HIF);
    AppMethodBeat.o(142715);
  }
  
  public final void fjP()
  {
    AppMethodBeat.i(142716);
    init(this.HIz.getMeasuredWidth(), this.HIz.getMeasuredHeight());
    AppMethodBeat.o(142716);
  }
  
  public final void fjQ()
  {
    this.HII = true;
  }
  
  public final void fjR()
  {
    this.HIH = false;
  }
  
  final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142710);
    if (jD(paramInt1, paramInt2))
    {
      this.HIE = false;
      this.HIz.setWillNotDraw(true);
      xb(false);
      AppMethodBeat.o(142710);
      return;
    }
    this.HIE = true;
    this.HIz.setWillNotDraw(false);
    jE(paramInt1, paramInt2);
    this.HIx = new Canvas(this.HIy);
    xb(true);
    if (this.HII) {
      fjN();
    }
    AppMethodBeat.o(142710);
  }
  
  public final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(142714);
    this.HID = true;
    if (this.HIE)
    {
      if (this.HIG != null) {
        break label120;
      }
      this.HIy.eraseColor(0);
      if (!this.HII) {
        break label134;
      }
      this.isN.draw(this.HIx);
    }
    for (;;)
    {
      this.HIy = this.HIw.d(this.HIy, this.HIt);
      paramCanvas.save();
      paramCanvas.scale(this.HIu * 8.0F, this.HIv * 8.0F);
      paramCanvas.drawBitmap(this.HIy, 0.0F, 0.0F, this.paint);
      paramCanvas.restore();
      AppMethodBeat.o(142714);
      return;
      label120:
      this.HIG.draw(this.HIx);
      break;
      label134:
      this.HIx.save();
      fjN();
      this.isN.draw(this.HIx);
      this.HIx.restore();
    }
  }
  
  public final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(142718);
    this.HIE = paramBoolean;
    xb(paramBoolean);
    this.HIz.invalidate();
    AppMethodBeat.o(142718);
  }
  
  public final void xb(boolean paramBoolean)
  {
    AppMethodBeat.i(142719);
    this.HIz.getViewTreeObserver().removeOnPreDrawListener(this.HIC);
    if (paramBoolean) {
      this.HIz.getViewTreeObserver().addOnPreDrawListener(this.HIC);
    }
    AppMethodBeat.o(142719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a
 * JD-Core Version:    0.7.0.1
 */