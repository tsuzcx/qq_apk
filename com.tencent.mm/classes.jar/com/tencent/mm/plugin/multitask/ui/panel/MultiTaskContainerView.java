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
import com.tencent.mm.plugin.multitask.ui.a.c;
import com.tencent.mm.plugin.multitask.ui.e.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "END_POINT_SIZE", "", "MAX_DISTANCE", "MIN_DISTANCE", "POINT_MARGIN_TOP", "START_POINT_SIZE", "mFillPaint", "Landroid/graphics/Paint;", "mLeftPoint", "Landroid/graphics/Point;", "mRightPoint", "mSlideOffset", "mStrokePaint", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getLoadingMode", "init", "updateLoadingMode", "mode", "updateSlideOffset", "slideOffset", "Companion", "ui-multitask_release"})
public final class MultiTaskContainerView
  extends FrameLayout
{
  private static int FLC;
  public static final MultiTaskContainerView.a FLD;
  private static int mState;
  private float FLA;
  private float FLB;
  private Point FLv;
  private Point FLw;
  private float FLx;
  private float FLy;
  private int FLz;
  private float anK;
  private final Paint auG;
  private final Paint auH;
  
  static
  {
    AppMethodBeat.i(197308);
    FLD = new MultiTaskContainerView.a((byte)0);
    AppMethodBeat.o(197308);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197302);
    this.FLv = new Point();
    this.FLw = new Point();
    this.auG = new Paint();
    this.auH = new Paint();
    init();
    AppMethodBeat.o(197302);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197307);
    this.FLv = new Point();
    this.FLw = new Point();
    this.auG = new Paint();
    this.auH = new Paint();
    init();
    AppMethodBeat.o(197307);
  }
  
  private final void init()
  {
    AppMethodBeat.i(197253);
    this.FLx = aw.fromDPToPix(getContext(), 4);
    this.FLy = aw.fromDPToPix(getContext(), 8);
    this.FLA = (aw.fromDPToPix(getContext(), 5) + this.FLy);
    this.FLB = (aw.fromDPToPix(getContext(), 20) + this.FLy);
    this.FLz = (aw.fromDPToPix(getContext(), 48) / 2 + ax.F(MMApplicationContext.getContext(), -1));
    this.auG.setColor(getResources().getColor(e.b.FIw));
    this.auG.setStyle(Paint.Style.STROKE);
    this.auG.setStrokeWidth(aw.fromDPToPix(getContext(), 1));
    this.auG.setFlags(1);
    this.auH.setColor(getResources().getColor(e.b.FIw));
    this.auH.setStyle(Paint.Style.FILL);
    this.auH.setFlags(1);
    AppMethodBeat.o(197253);
  }
  
  public final void Yl(int paramInt)
  {
    AppMethodBeat.i(197256);
    FLC = paramInt;
    invalidate();
    AppMethodBeat.o(197256);
  }
  
  public final void bG(float paramFloat)
  {
    AppMethodBeat.i(197254);
    this.anK = paramFloat;
    invalidate();
    AppMethodBeat.o(197254);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    int i = 0;
    AppMethodBeat.i(197295);
    p.k(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    mState = 0;
    float f3;
    int j;
    Object localObject;
    float f1;
    float f2;
    float f4;
    float f5;
    if ((FLC == 1) || (FLC == 2))
    {
      paramCanvas.save();
      f3 = this.FLx;
      j = getWidth();
      localObject = c.FNc;
      f1 = (j - c.fcy()) * this.anK;
      j = getWidth();
      localObject = c.FNc;
      j = j - c.fcy() - (int)f1 / 2;
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
      this.FLv.y = this.FLz;
      this.FLw.y = this.FLz;
      this.FLv.x = (j - (int)this.FLA / 2);
      this.FLw.x = ((int)this.FLA / 2 + j);
      if (mState == 1)
      {
        f2 = this.FLx;
        label207:
        if (FLC != 1) {
          break label519;
        }
        localObject = this.auG;
        if (f1 >= 0.0F) {
          break label495;
        }
        i = 0;
      }
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.FLv.x, this.FLv.y, f2 / 2.0F, this.auG);
        paramCanvas.drawCircle(this.FLw.x, this.FLw.y, f2 / 2.0F, this.auG);
        paramCanvas.restore();
        AppMethodBeat.o(197295);
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
          f2 = this.FLx;
          break label207;
        }
        if (mState == 3)
        {
          f3 = this.FLx + (this.FLy - this.FLx) * f2;
          this.FLv.x = (j - (int)((this.FLA + (this.FLB - this.FLA) * f2) / 2.0F));
          localObject = this.FLw;
          f4 = this.FLA;
          ((Point)localObject).x = ((int)((f2 * (this.FLB - this.FLA) + f4) / 2.0F) + j);
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
      localObject = this.auH;
      if (f1 < 0.0F) {}
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.FLv.x, this.FLv.y, f2 / 2.0F, this.auH);
        paramCanvas.drawCircle(this.FLw.x, this.FLw.y, f2 / 2.0F, this.auH);
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
    return FLC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView
 * JD-Core Version:    0.7.0.1
 */