package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "END_POINT_SIZE", "", "MAX_DISTANCE", "MIN_DISTANCE", "POINT_MARGIN_TOP", "START_POINT_SIZE", "mFillPaint", "Landroid/graphics/Paint;", "mLeftPoint", "Landroid/graphics/Point;", "mRightPoint", "mSlideOffset", "mStrokePaint", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getLoadingMode", "init", "updateLoadingMode", "mode", "updateSlideOffset", "slideOffset", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTaskContainerView
  extends FrameLayout
{
  public static final MultiTaskContainerView.a LGA;
  private static int LGI;
  private static int mState;
  private Point LGB;
  private Point LGC;
  private float LGD;
  private float LGE;
  private int LGF;
  private float LGG;
  private float LGH;
  private float ccq;
  private final Paint cjd;
  private final Paint cje;
  
  static
  {
    AppMethodBeat.i(304539);
    LGA = new MultiTaskContainerView.a((byte)0);
    AppMethodBeat.o(304539);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304520);
    this.LGB = new Point();
    this.LGC = new Point();
    this.cjd = new Paint();
    this.cje = new Paint();
    init();
    AppMethodBeat.o(304520);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304526);
    this.LGB = new Point();
    this.LGC = new Point();
    this.cjd = new Paint();
    this.cje = new Paint();
    init();
    AppMethodBeat.o(304526);
  }
  
  private final void init()
  {
    AppMethodBeat.i(304533);
    this.LGD = bd.fromDPToPix(getContext(), 4);
    this.LGE = bd.fromDPToPix(getContext(), 8);
    this.LGG = (bd.fromDPToPix(getContext(), 5) + this.LGE);
    this.LGH = (bd.fromDPToPix(getContext(), 20) + this.LGE);
    this.LGF = (bd.fromDPToPix(getContext(), 48) / 2 + bf.I(MMApplicationContext.getContext(), -1));
    this.cjd.setColor(getResources().getColor(e.b.LDG));
    this.cjd.setStyle(Paint.Style.STROKE);
    this.cjd.setStrokeWidth(bd.fromDPToPix(getContext(), 1));
    this.cjd.setFlags(1);
    this.cje.setColor(getResources().getColor(e.b.LDG));
    this.cje.setStyle(Paint.Style.FILL);
    this.cje.setFlags(1);
    AppMethodBeat.o(304533);
  }
  
  public final void acx(int paramInt)
  {
    AppMethodBeat.i(304550);
    LGI = paramInt;
    invalidate();
    AppMethodBeat.o(304550);
  }
  
  public final void cK(float paramFloat)
  {
    AppMethodBeat.i(304547);
    this.ccq = paramFloat;
    invalidate();
    AppMethodBeat.o(304547);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    int i = 0;
    AppMethodBeat.i(304569);
    s.u(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    mState = 0;
    float f3;
    int j;
    Object localObject;
    float f1;
    float f2;
    float f4;
    float f5;
    if ((LGI == 1) || (LGI == 2))
    {
      paramCanvas.save();
      f3 = this.LGD;
      j = getWidth();
      localObject = c.LHl;
      f1 = (j - c.glB()) * this.ccq;
      j = getWidth();
      localObject = c.LHl;
      j = j - c.glB() - (int)f1 / 2;
      f2 = getWidth() * 0.15F;
      f4 = getWidth() * 0.18F;
      f5 = getWidth() * 0.25F;
      if (f1 >= f2) {
        break label300;
      }
      mState = 1;
      f2 = 0.0F;
      f1 = 0.0F;
    }
    for (;;)
    {
      this.LGB.y = this.LGF;
      this.LGC.y = this.LGF;
      this.LGB.x = (j - (int)this.LGG / 2);
      this.LGC.x = ((int)this.LGG / 2 + j);
      if (mState == 1)
      {
        f2 = this.LGD;
        label207:
        if (LGI != 1) {
          break label519;
        }
        localObject = this.cjd;
        if (f1 >= 0.0F) {
          break label495;
        }
        i = 0;
      }
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.LGB.x, this.LGB.y, f2 / 2.0F, this.cjd);
        paramCanvas.drawCircle(this.LGC.x, this.LGC.y, f2 / 2.0F, this.cjd);
        paramCanvas.restore();
        AppMethodBeat.o(304569);
        return;
        label300:
        if ((f1 >= f2) && (f1 < f4))
        {
          f1 = (f1 - f2) / (f4 - f2);
          mState = 2;
          f2 = 0.0F;
          break;
        }
        if ((f1 >= f4) && (f1 < f5))
        {
          f2 = (f1 - f4) / (f5 - f4);
          mState = 3;
          f1 = 1.0F;
          break;
        }
        if (f1 < f5) {
          break label619;
        }
        mState = 3;
        f2 = 1.0F;
        f1 = 1.0F;
        break;
        if (mState == 2)
        {
          f2 = this.LGD;
          break label207;
        }
        if (mState == 3)
        {
          f3 = this.LGD + (this.LGE - this.LGD) * f2;
          this.LGB.x = (j - (int)((this.LGG + (this.LGH - this.LGG) * f2) / 2.0F));
          localObject = this.LGC;
          f4 = this.LGG;
          ((Point)localObject).x = ((int)((f2 * (this.LGH - this.LGG) + f4) / 2.0F) + j);
        }
        f2 = f3;
        break label207;
        label495:
        if (f1 > 1.0F) {
          i = 176;
        } else {
          i = (int)(176.0F * f1);
        }
      }
      label519:
      localObject = this.cje;
      if (f1 < 0.0F) {}
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.LGB.x, this.LGB.y, f2 / 2.0F, this.cje);
        paramCanvas.drawCircle(this.LGC.x, this.LGC.y, f2 / 2.0F, this.cje);
        break;
        if (f1 > 1.0F) {
          i = 176;
        } else {
          i = (int)(176.0F * f1);
        }
      }
      label619:
      f2 = 0.0F;
      f1 = 0.0F;
    }
  }
  
  public final int getLoadingMode()
  {
    return LGI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView
 * JD-Core Version:    0.7.0.1
 */