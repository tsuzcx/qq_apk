package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/MMWeUIBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceViewV2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onNestedPreScrollInner", "", "target", "Landroid/view/View;", "dx", "dy", "consumed", "", "type", "onNestedScrollInternal", "", "dyUnconsumed", "onStopNestedScroll", "onTouchEvent", "event", "reportOverScrollTimes", "scrollTime", "setBackgroundResource", "resid", "setOffset", "child", "offset", "setPadding", "left", "top", "right", "bottom", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMWeUIBounceView
  extends WeUIBounceViewV2
{
  public static final MMWeUIBounceView.a aglC;
  
  static
  {
    AppMethodBeat.i(251935);
    aglC = new MMWeUIBounceView.a((byte)0);
    AppMethodBeat.o(251935);
  }
  
  public MMWeUIBounceView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(251930);
    AppMethodBeat.o(251930);
  }
  
  public MMWeUIBounceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251925);
    paramContext = j.aglL;
    paramContext = i.agtt;
    if (((Integer)i.a(b.a.agqx, Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      j.NK(bool);
      AppMethodBeat.o(251925);
      return;
    }
  }
  
  public final void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(251940);
    super.P(paramView, paramInt);
    AppMethodBeat.o(251940);
  }
  
  protected final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251971);
    s.u(paramView, "target");
    try
    {
      super.a(paramView, paramInt1, paramInt2, paramArrayOfInt);
      AppMethodBeat.o(251971);
      return;
    }
    finally
    {
      MMWeUIBounceView.a.aFs(3);
      Log.printErrStackTrace("PullDownParentView", paramView, "onNestedScrollInternal err", new Object[0]);
      AppMethodBeat.o(251971);
    }
  }
  
  protected final int b(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(251965);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    try
    {
      paramInt1 = super.b(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      AppMethodBeat.o(251965);
      return paramInt1;
    }
    finally
    {
      MMWeUIBounceView.a.aFs(2);
      Log.printErrStackTrace("PullDownParentView", paramView, "onNestedPreScrollInner err", new Object[0]);
      AppMethodBeat.o(251965);
    }
    return 0;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(251976);
    s.u(paramView, "target");
    try
    {
      super.l(paramView, paramInt);
      AppMethodBeat.o(251976);
      return;
    }
    finally
    {
      MMWeUIBounceView.a.aFs(4);
      Log.printErrStackTrace("PullDownParentView", paramView, "onStopNestedScroll err", new Object[0]);
      AppMethodBeat.o(251976);
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(251950);
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        MMWeUIBounceView.a.aFs(0);
        Log.printErrStackTrace("PullDownParentView", paramMotionEvent, "onInterceptTouchEvent err", new Object[0]);
      }
    }
    AppMethodBeat.o(251950);
    return bool1;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(251958);
    s.u(paramMotionEvent, "event");
    try
    {
      boolean bool2 = super.onTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    finally
    {
      for (;;)
      {
        MMWeUIBounceView.a.aFs(1);
        Log.printErrStackTrace("PullDownParentView", paramMotionEvent, "onTouchEvent err", new Object[0]);
      }
    }
    AppMethodBeat.o(251958);
    return bool1;
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(251981);
    View localView = getMContentView();
    if (localView != null) {
      localView.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(251981);
  }
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251945);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(251945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.MMWeUIBounceView
 * JD-Core Version:    0.7.0.1
 */