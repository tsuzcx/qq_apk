package com.tencent.mm.plugin.vlog.ui.thumb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedPosition", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "getChildDrawingOrder", "childCount", "i", "onDraw", "", "c", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthSpec", "heightSpec", "onTouchEvent", "selectItem", "position", "Companion", "plugin-vlog_release"})
@SuppressLint({"LongLogTag"})
public final class MultiTrackRecyclerView
  extends RecyclerView
{
  public static final a NDu;
  int bFx;
  
  static
  {
    AppMethodBeat.i(243424);
    NDu = new a((byte)0);
    AppMethodBeat.o(243424);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243421);
    this.bFx = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(243421);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(243422);
    this.bFx = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(243422);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(243415);
    StringBuilder localStringBuilder = new StringBuilder("dispatchTouchEvent, action:");
    if (paramMotionEvent != null) {}
    for (Integer localInteger = Integer.valueOf(paramMotionEvent.getAction());; localInteger = null)
    {
      localStringBuilder.append(localInteger);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(243415);
      return bool;
    }
  }
  
  public final int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243420);
    int j = this.bFx;
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    Object localObject = localLayoutManager;
    if (!(localLayoutManager instanceof LinearLayoutManager)) {
      localObject = null;
    }
    localObject = (LinearLayoutManager)localObject;
    if (localObject != null) {}
    for (int i = ((LinearLayoutManager)localObject).kJ();; i = 0)
    {
      i = j - i;
      if ((i >= 0) && (paramInt2 >= i) && (i < paramInt1)) {
        break;
      }
      AppMethodBeat.o(243420);
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1)
    {
      AppMethodBeat.o(243420);
      return i;
    }
    AppMethodBeat.o(243420);
    return paramInt2 + 1;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(243413);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(243413);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(243417);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(243417);
    return bool;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(243411);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(243411);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243410);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(243410);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(243419);
    StringBuilder localStringBuilder = new StringBuilder("onTouchEvent, action:");
    if (paramMotionEvent != null) {}
    for (Integer localInteger = Integer.valueOf(paramMotionEvent.getAction());; localInteger = null)
    {
      localStringBuilder.append(localInteger);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(243419);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackRecyclerView
 * JD-Core Version:    0.7.0.1
 */