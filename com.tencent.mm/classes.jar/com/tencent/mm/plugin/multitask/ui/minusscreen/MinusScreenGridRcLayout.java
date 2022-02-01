package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "ui-multitask_release"})
public final class MinusScreenGridRcLayout
  extends FrameLayout
{
  private final float xyP;
  private final float[] xyQ;
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197505);
    this.xyP = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.xyQ = new float[] { this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP };
    AppMethodBeat.o(197505);
  }
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197508);
    this.xyP = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.xyQ = new float[] { this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP, this.xyP };
    AppMethodBeat.o(197508);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(197501);
    p.k(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(197501);
  }
  
  public final float getCornerDp()
  {
    return this.xyP;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197502);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(197502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridRcLayout
 * JD-Core Version:    0.7.0.1
 */