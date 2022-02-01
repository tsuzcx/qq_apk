package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isFullscreenMode", "", "calculateLayout", "", "changed", "left", "top", "right", "bottom", "enableFullscreenMode", "onChangeVisibilityRect", "rectF", "Landroid/graphics/RectF;", "isHard", "onTouchCancel", "e1", "Landroid/view/MotionEvent;", "Companion", "plugin-vlog_release"})
public class MultiEditCropLayout
  extends CropLayout
{
  public static final a NGa;
  public boolean MZN;
  
  static
  {
    AppMethodBeat.i(239609);
    NGa = new a((byte)0);
    AppMethodBeat.o(239609);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239606);
    AppMethodBeat.o(239606);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(239607);
    AppMethodBeat.o(239607);
  }
  
  public final void am(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239604);
    p.k(paramMotionEvent, "e1");
    if (!this.MZN)
    {
      super.am(paramMotionEvent);
      AppMethodBeat.o(239604);
      return;
    }
    CropLayout.c localc = getOnChangeListener();
    paramMotionEvent = localc;
    if (!(localc instanceof CropLayout.d)) {
      paramMotionEvent = null;
    }
    paramMotionEvent = (CropLayout.d)paramMotionEvent;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.gvj();
      AppMethodBeat.o(239604);
      return;
    }
    AppMethodBeat.o(239604);
  }
  
  public final void b(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(239599);
    p.k(paramRectF, "rectF");
    if (!this.MZN)
    {
      super.b(paramRectF, paramBoolean);
      AppMethodBeat.o(239599);
      return;
    }
    getVisibilityRect().set(paramRectF);
    AppMethodBeat.o(239599);
  }
  
  public final void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239602);
    if (!this.MZN)
    {
      super.e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(239602);
      return;
    }
    View localView = getContentView();
    if (localView != null)
    {
      if (ica())
      {
        setShouldLayout(false);
        getContentBaseRect().set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        localView.setPivotX(getContentBaseRect().exactCenterX());
        localView.setPivotY(getContentBaseRect().exactCenterY());
        getTmpRectF().set(getContentBaseRect());
        getMainMatrix().mapRect(getTmpRectF());
        getTmpRectF().round(getContentRect());
        getContentRectF().set(getTmpRectF());
        if (((Boolean)getInitFinish().invoke(getMainMatrix())).booleanValue())
        {
          icj();
          getContentRectF().round(getContentCenterRect());
        }
      }
      AppMethodBeat.o(239602);
      return;
    }
    AppMethodBeat.o(239602);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout
 * JD-Core Version:    0.7.0.1
 */