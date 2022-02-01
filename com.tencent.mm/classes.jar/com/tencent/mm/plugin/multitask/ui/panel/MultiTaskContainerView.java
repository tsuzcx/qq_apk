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
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "END_POINT_SIZE", "", "MAX_DISTANCE", "MIN_DISTANCE", "POINT_MARGIN_TOP", "START_POINT_SIZE", "mFillPaint", "Landroid/graphics/Paint;", "mLeftPoint", "Landroid/graphics/Point;", "mRightPoint", "mSlideOffset", "mStrokePaint", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getLoadingMode", "init", "updateLoadingMode", "mode", "updateSlideOffset", "slideOffset", "Companion", "ui-multitask_release"})
public final class MultiTaskContainerView
  extends FrameLayout
{
  private static int AeZ;
  public static final MultiTaskContainerView.a Afa;
  private static int mState;
  private Point AeS;
  private Point AeT;
  private float AeU;
  private float AeV;
  private int AeW;
  private float AeX;
  private float AeY;
  public float Vm;
  private final Paint xX;
  private final Paint xY;
  
  static
  {
    AppMethodBeat.i(236588);
    Afa = new MultiTaskContainerView.a((byte)0);
    AppMethodBeat.o(236588);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236586);
    this.AeS = new Point();
    this.AeT = new Point();
    this.xX = new Paint();
    this.xY = new Paint();
    init();
    AppMethodBeat.o(236586);
  }
  
  public MultiTaskContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236587);
    this.AeS = new Point();
    this.AeT = new Point();
    this.xX = new Paint();
    this.xY = new Paint();
    init();
    AppMethodBeat.o(236587);
  }
  
  private final void init()
  {
    AppMethodBeat.i(236583);
    this.AeU = at.fromDPToPix(getContext(), 4);
    this.AeV = at.fromDPToPix(getContext(), 8);
    this.AeX = (at.fromDPToPix(getContext(), 5) + this.AeV);
    this.AeY = (at.fromDPToPix(getContext(), 20) + this.AeV);
    this.AeW = (at.fromDPToPix(getContext(), 48) / 2 + au.D(MMApplicationContext.getContext(), -1));
    this.xX.setColor(getResources().getColor(2131100858));
    this.xX.setStyle(Paint.Style.STROKE);
    this.xX.setStrokeWidth(at.fromDPToPix(getContext(), 1));
    this.xX.setFlags(1);
    this.xY.setColor(getResources().getColor(2131100858));
    this.xY.setStyle(Paint.Style.FILL);
    this.xY.setFlags(1);
    AppMethodBeat.o(236583);
  }
  
  public final void RT(int paramInt)
  {
    AppMethodBeat.i(236584);
    AeZ = paramInt;
    invalidate();
    AppMethodBeat.o(236584);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    int i = 0;
    AppMethodBeat.i(236585);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    mState = 0;
    float f3;
    int j;
    Object localObject;
    float f1;
    float f2;
    float f4;
    float f5;
    if ((AeZ == 1) || (AeZ == 2))
    {
      paramCanvas.save();
      f3 = this.AeU;
      j = getWidth();
      localObject = MultiTaskUIC.Ago;
      f1 = (j - MultiTaskUIC.esq()) * this.Vm;
      j = getWidth();
      localObject = MultiTaskUIC.Ago;
      j = j - MultiTaskUIC.esq() - (int)f1 / 2;
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
      this.AeS.y = this.AeW;
      this.AeT.y = this.AeW;
      this.AeS.x = (j - (int)this.AeX / 2);
      this.AeT.x = ((int)this.AeX / 2 + j);
      if (mState == 1)
      {
        f2 = this.AeU;
        label207:
        if (AeZ != 1) {
          break label519;
        }
        localObject = this.xX;
        if (f1 >= 0.0F) {
          break label495;
        }
        i = 0;
      }
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.AeS.x, this.AeS.y, f2 / 2.0F, this.xX);
        paramCanvas.drawCircle(this.AeT.x, this.AeT.y, f2 / 2.0F, this.xX);
        paramCanvas.restore();
        AppMethodBeat.o(236585);
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
          f2 = this.AeU;
          break label207;
        }
        if (mState == 3)
        {
          f3 = this.AeU + (this.AeV - this.AeU) * f2;
          this.AeS.x = (j - (int)((this.AeX + (this.AeY - this.AeX) * f2) / 2.0F));
          localObject = this.AeT;
          f4 = this.AeX;
          ((Point)localObject).x = ((int)((f2 * (this.AeY - this.AeX) + f4) / 2.0F) + j);
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
      localObject = this.xY;
      if (f1 < 0.0F) {}
      for (;;)
      {
        ((Paint)localObject).setAlpha(i);
        paramCanvas.drawCircle(this.AeS.x, this.AeS.y, f2 / 2.0F, this.xY);
        paramCanvas.drawCircle(this.AeT.x, this.AeT.y, f2 / 2.0F, this.xY);
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
    return AeZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView
 * JD-Core Version:    0.7.0.1
 */