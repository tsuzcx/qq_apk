package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/ui/base/IMultiTaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "snapView", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "getSnapView", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "setSnapView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;)V", "getView", "Landroid/view/View;", "initUI", "", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "plugin-multitask_release"})
public class MultiTaskSnapViewWrapper
  extends FrameLayout
  implements a
{
  private MultiTaskSnapView FJT;
  
  public MultiTaskSnapViewWrapper(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248652);
    initUI();
    AppMethodBeat.o(248652);
  }
  
  public MultiTaskSnapViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248654);
    initUI();
    AppMethodBeat.o(248654);
  }
  
  public MultiTaskSnapViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248656);
    initUI();
    AppMethodBeat.o(248656);
  }
  
  private final void initUI()
  {
    AppMethodBeat.i(248650);
    this.FJT = new MultiTaskSnapView(getContext());
    addView((View)this.FJT);
    MultiTaskSnapView localMultiTaskSnapView = this.FJT;
    if (localMultiTaskSnapView != null)
    {
      localMultiTaskSnapView.setScaleType(ImageView.ScaleType.MATRIX);
      AppMethodBeat.o(248650);
      return;
    }
    AppMethodBeat.o(248650);
  }
  
  public final MultiTaskSnapView getSnapView()
  {
    return this.FJT;
  }
  
  public View getView()
  {
    return (View)this;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(248647);
    p.k(paramBitmap, "bitmap");
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, 1.0F);
    MultiTaskSnapView localMultiTaskSnapView = this.FJT;
    if (localMultiTaskSnapView != null) {
      localMultiTaskSnapView.setImageMatrix((Matrix)localObject);
    }
    localObject = this.FJT;
    if (localObject != null)
    {
      ((MultiTaskSnapView)localObject).setImageBitmap(paramBitmap);
      AppMethodBeat.o(248647);
      return;
    }
    AppMethodBeat.o(248647);
  }
  
  public final void setSnapView(MultiTaskSnapView paramMultiTaskSnapView)
  {
    this.FJT = paramMultiTaskSnapView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper
 * JD-Core Version:    0.7.0.1
 */