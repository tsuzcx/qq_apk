package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/MultiTrackRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedPosition", "dispatchTouchEvent", "", "e", "Landroid/view/MotionEvent;", "getChildDrawingOrder", "childCount", "i", "onDraw", "", "c", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthSpec", "heightSpec", "onTouchEvent", "selectItem", "position", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiTrackRecyclerView
  extends RecyclerView
{
  public static final MultiTrackRecyclerView.a UpU;
  int dyx;
  
  static
  {
    AppMethodBeat.i(281599);
    UpU = new MultiTrackRecyclerView.a((byte)0);
    AppMethodBeat.o(281599);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281591);
    this.dyx = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(281591);
  }
  
  public MultiTrackRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281595);
    this.dyx = -1;
    setChildrenDrawingOrderEnabled(true);
    setClipToPadding(false);
    AppMethodBeat.o(281595);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281617);
    if (paramMotionEvent == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramMotionEvent.getAction()))
    {
      s.X("dispatchTouchEvent, action:", localObject);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(281617);
      return bool;
    }
  }
  
  public final int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281633);
    int j = this.dyx;
    Object localObject = getLayoutManager();
    if ((localObject instanceof LinearLayoutManager))
    {
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null) {
        break label71;
      }
    }
    label71:
    for (int i = 0;; i = ((LinearLayoutManager)localObject).Ju())
    {
      i = j - i;
      if ((i >= 0) && (paramInt2 >= i) && (i < paramInt1)) {
        break label80;
      }
      AppMethodBeat.o(281633);
      return paramInt2;
      localObject = null;
      break;
    }
    label80:
    if (paramInt2 == paramInt1 - 1)
    {
      AppMethodBeat.o(281633);
      return i;
    }
    AppMethodBeat.o(281633);
    return paramInt2 + 1;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(281612);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(281612);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281623);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(281623);
    return bool;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281606);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(281606);
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281601);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(281601);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(281626);
    if (paramMotionEvent == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramMotionEvent.getAction()))
    {
      s.X("onTouchEvent, action:", localObject);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(281626);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackRecyclerView
 * JD-Core Version:    0.7.0.1
 */