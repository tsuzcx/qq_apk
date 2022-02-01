package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "ui-multitask_release"})
public final class MinusScreenGridRcLayout
  extends FrameLayout
{
  private final float tOp;
  private final float[] tOq;
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(236450);
    this.tOp = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(236450);
  }
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236451);
    this.tOp = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.tOq = new float[] { this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp, this.tOp };
    AppMethodBeat.o(236451);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236448);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(236448);
  }
  
  public final float getCornerDp()
  {
    return this.tOp;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236449);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(236449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridRcLayout
 * JD-Core Version:    0.7.0.1
 */