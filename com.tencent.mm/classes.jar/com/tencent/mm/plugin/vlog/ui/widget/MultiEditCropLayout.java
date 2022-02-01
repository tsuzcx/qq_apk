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
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isFullscreenMode", "", "calculateLayout", "", "changed", "left", "top", "right", "bottom", "enableFullscreenMode", "onChangeVisibilityRect", "rectF", "Landroid/graphics/RectF;", "isHard", "onTouchCancel", "e1", "Landroid/view/MotionEvent;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class MultiEditCropLayout
  extends CropLayout
{
  public static final MultiEditCropLayout.a Usg;
  public boolean TMw;
  
  static
  {
    AppMethodBeat.i(281828);
    Usg = new MultiEditCropLayout.a((byte)0);
    AppMethodBeat.o(281828);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281811);
    AppMethodBeat.o(281811);
  }
  
  public MultiEditCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281819);
    AppMethodBeat.o(281819);
  }
  
  public final void ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281850);
    s.u(paramMotionEvent, "e1");
    if (!this.TMw)
    {
      super.ap(paramMotionEvent);
      AppMethodBeat.o(281850);
      return;
    }
    paramMotionEvent = getOnChangeListener();
    if ((paramMotionEvent instanceof CropLayout.d)) {}
    for (paramMotionEvent = (CropLayout.d)paramMotionEvent;; paramMotionEvent = null)
    {
      if (paramMotionEvent != null) {
        paramMotionEvent.hSZ();
      }
      AppMethodBeat.o(281850);
      return;
    }
  }
  
  public final void b(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(281836);
    s.u(paramRectF, "rectF");
    if (!this.TMw)
    {
      super.b(paramRectF, paramBoolean);
      AppMethodBeat.o(281836);
      return;
    }
    getVisibilityRect().set(paramRectF);
    AppMethodBeat.o(281836);
  }
  
  public final void e(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281843);
    if (!this.TMw)
    {
      super.e(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(281843);
      return;
    }
    View localView = getContentView();
    if ((localView != null) && (jHo()))
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
        jHx();
        getContentRectF().round(getContentCenterRect());
      }
    }
    AppMethodBeat.o(281843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout
 * JD-Core Version:    0.7.0.1
 */