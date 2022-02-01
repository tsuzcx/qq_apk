package com.tencent.mm.plugin.vlog.ui.thumb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedPosition", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "getChildDrawingOrder", "childCount", "i", "onDraw", "", "c", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthSpec", "heightSpec", "onTouchEvent", "selectItem", "position", "Companion", "plugin-vlog_release"})
@SuppressLint({"LongLogTag"})
public final class MultiTrackRecyclerView
  extends RecyclerView
{
  public static final MultiTrackRecyclerView.a GPM;
  int va;
  
  static
  {
    AppMethodBeat.i(192133);
    GPM = new MultiTrackRecyclerView.a((byte)0);
    AppMethodBeat.o(192133);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192131);
    this.va = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(192131);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192132);
    this.va = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(192132);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192127);
    StringBuilder localStringBuilder = new StringBuilder("dispatchTouchEvent, action:");
    if (paramMotionEvent != null) {}
    for (Integer localInteger = Integer.valueOf(paramMotionEvent.getAction());; localInteger = null)
    {
      localStringBuilder.append(localInteger);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192127);
      return bool;
    }
  }
  
  public final int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192130);
    int j = this.va;
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    Object localObject = localLayoutManager;
    if (!(localLayoutManager instanceof LinearLayoutManager)) {
      localObject = null;
    }
    localObject = (LinearLayoutManager)localObject;
    if (localObject != null) {}
    for (int i = ((LinearLayoutManager)localObject).ks();; i = 0)
    {
      i = j - i;
      if ((i >= 0) && (paramInt2 >= i) && (i < paramInt1)) {
        break;
      }
      AppMethodBeat.o(192130);
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1)
    {
      AppMethodBeat.o(192130);
      return i;
    }
    AppMethodBeat.o(192130);
    return paramInt2 + 1;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192126);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(192126);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192128);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(192128);
    return bool;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192125);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(192125);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192124);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(192124);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192129);
    StringBuilder localStringBuilder = new StringBuilder("onTouchEvent, action:");
    if (paramMotionEvent != null) {}
    for (Integer localInteger = Integer.valueOf(paramMotionEvent.getAction());; localInteger = null)
    {
      localStringBuilder.append(localInteger);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192129);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackRecyclerView
 * JD-Core Version:    0.7.0.1
 */