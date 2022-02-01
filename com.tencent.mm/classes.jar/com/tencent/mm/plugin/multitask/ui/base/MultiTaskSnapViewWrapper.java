package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/ui/base/IMultiTaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "snapView", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "getSnapView", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "setSnapView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;)V", "getView", "Landroid/view/View;", "initUI", "", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MultiTaskSnapViewWrapper
  extends FrameLayout
  implements a
{
  private MultiTaskSnapView LFj;
  
  public MultiTaskSnapViewWrapper(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(304566);
    initUI();
    AppMethodBeat.o(304566);
  }
  
  public MultiTaskSnapViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(304571);
    initUI();
    AppMethodBeat.o(304571);
  }
  
  public MultiTaskSnapViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(304579);
    initUI();
    AppMethodBeat.o(304579);
  }
  
  private final void initUI()
  {
    AppMethodBeat.i(304588);
    this.LFj = new MultiTaskSnapView(getContext());
    addView((View)this.LFj);
    MultiTaskSnapView localMultiTaskSnapView = this.LFj;
    if (localMultiTaskSnapView != null) {
      localMultiTaskSnapView.setScaleType(ImageView.ScaleType.MATRIX);
    }
    AppMethodBeat.o(304588);
  }
  
  public final MultiTaskSnapView getSnapView()
  {
    return this.LFj;
  }
  
  public View getView()
  {
    return (View)this;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(304608);
    s.u(paramBitmap, "bitmap");
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, 1.0F);
    MultiTaskSnapView localMultiTaskSnapView = this.LFj;
    if (localMultiTaskSnapView != null) {
      localMultiTaskSnapView.setImageMatrix((Matrix)localObject);
    }
    localObject = this.LFj;
    if (localObject != null) {
      ((MultiTaskSnapView)localObject).setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(304608);
  }
  
  public final void setSnapView(MultiTaskSnapView paramMultiTaskSnapView)
  {
    this.LFj = paramMultiTaskSnapView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.MultiTaskSnapViewWrapper
 * JD-Core Version:    0.7.0.1
 */