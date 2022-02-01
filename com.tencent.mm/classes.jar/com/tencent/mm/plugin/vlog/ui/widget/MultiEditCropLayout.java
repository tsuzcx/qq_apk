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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isFullscreenMode", "", "calculateLayout", "", "changed", "left", "top", "right", "bottom", "enableFullscreenMode", "onChangeVisibilityRect", "rectF", "Landroid/graphics/RectF;", "isHard", "onTouchCancel", "e1", "Landroid/view/MotionEvent;", "Companion", "plugin-vlog_release"})
public class MultiEditCropLayout
  extends CropLayout
{
  public static final MultiEditCropLayout.a GQj;
  public boolean Gna;
  
  static
  {
    AppMethodBeat.i(192177);
    GQj = new MultiEditCropLayout.a((byte)0);
    AppMethodBeat.o(192177);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192175);
    AppMethodBeat.o(192175);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192176);
    AppMethodBeat.o(192176);
  }
  
  public final void ad(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192174);
    p.h(paramMotionEvent, "e1");
    if (!this.Gna)
    {
      super.ad(paramMotionEvent);
      AppMethodBeat.o(192174);
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
      paramMotionEvent.fDk();
      AppMethodBeat.o(192174);
      return;
    }
    AppMethodBeat.o(192174);
  }
  
  public final void b(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(192172);
    p.h(paramRectF, "rectF");
    if (!this.Gna)
    {
      super.b(paramRectF, paramBoolean);
      AppMethodBeat.o(192172);
      return;
    }
    getVisibilityRect().set(paramRectF);
    AppMethodBeat.o(192172);
  }
  
  public final void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192173);
    if (!this.Gna)
    {
      super.e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(192173);
      return;
    }
    View localView = getContentView();
    if (localView != null)
    {
      if (this.QMf)
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
          hbh();
          getContentRectF().round(getContentCenterRect());
        }
      }
      AppMethodBeat.o(192173);
      return;
    }
    AppMethodBeat.o(192173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout
 * JD-Core Version:    0.7.0.1
 */