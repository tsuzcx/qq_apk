package com.tencent.mm.plugin.multitask.ui.minusscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/minusscreen/MinusScreenGridRcLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "getCornerDp", "()F", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MinusScreenGridRcLayout
  extends FrameLayout
{
  private final float AVY;
  private final float[] AVZ;
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304345);
    this.AVY = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.AVZ = new float[] { this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY };
    AppMethodBeat.o(304345);
  }
  
  public MinusScreenGridRcLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304352);
    this.AVY = (a.fromDPToPix(getContext(), 8) * 1.0F);
    this.AVZ = new float[] { this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY };
    AppMethodBeat.o(304352);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(304362);
    s.u(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(304362);
  }
  
  public final float getCornerDp()
  {
    return this.AVY;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304367);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824));
    AppMethodBeat.o(304367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.minusscreen.MinusScreenGridRcLayout
 * JD-Core Version:    0.7.0.1
 */