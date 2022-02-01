package com.tencent.mm.ui.widget.pulldown;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/MMWeUIBounceView;", "Lcom/tencent/mm/ui/widget/pulldown/WeUIBounceViewV2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onNestedPreScrollInner", "", "target", "Landroid/view/View;", "dx", "dy", "consumed", "", "type", "onNestedScrollInternal", "", "dyUnconsumed", "onStopNestedScroll", "onTouchEvent", "event", "setPadding", "left", "top", "right", "bottom", "Companion", "libmmui_release"})
public final class MMWeUIBounceView
  extends WeUIBounceViewV2
{
  public static final a Yto;
  
  static
  {
    AppMethodBeat.i(220918);
    Yto = new a((byte)0);
    AppMethodBeat.o(220918);
  }
  
  public MMWeUIBounceView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(220916);
    AppMethodBeat.o(220916);
  }
  
  public MMWeUIBounceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220913);
    paramContext = i.YtH;
    paramContext = com.tencent.mm.util.i.YyX;
    paramContext = com.tencent.mm.util.i.a(b.a.YxO, Integer.valueOf(0));
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(220913);
      throw paramContext;
    }
    if (((Integer)paramContext).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      i.HP(bool);
      AppMethodBeat.o(220913);
      return;
    }
  }
  
  protected final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(220905);
    p.k(paramView, "target");
    try
    {
      super.a(paramView, paramInt1, paramInt2, paramArrayOfInt);
      AppMethodBeat.o(220905);
      return;
    }
    catch (Throwable paramView)
    {
      a.ayM(3);
      Log.printErrStackTrace("PullDownParentView", paramView, "onNestedScrollInternal err", new Object[0]);
      AppMethodBeat.o(220905);
    }
  }
  
  protected final int b(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(220904);
    p.k(paramView, "target");
    p.k(paramArrayOfInt, "consumed");
    try
    {
      paramInt1 = super.b(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      AppMethodBeat.o(220904);
      return paramInt1;
    }
    catch (Throwable paramView)
    {
      a.ayM(2);
      Log.printErrStackTrace("PullDownParentView", paramView, "onNestedPreScrollInner err", new Object[0]);
      AppMethodBeat.o(220904);
    }
    return 0;
  }
  
  public final void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(220908);
    p.k(paramView, "target");
    try
    {
      super.l(paramView, paramInt);
      AppMethodBeat.o(220908);
      return;
    }
    catch (Throwable paramView)
    {
      a.ayM(4);
      Log.printErrStackTrace("PullDownParentView", paramView, "onStopNestedScroll err", new Object[0]);
      AppMethodBeat.o(220908);
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(220894);
    try
    {
      boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        a.ayM(0);
        Log.printErrStackTrace("PullDownParentView", paramMotionEvent, "onInterceptTouchEvent err", new Object[0]);
      }
    }
    AppMethodBeat.o(220894);
    return bool1;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(220900);
    p.k(paramMotionEvent, "event");
    try
    {
      boolean bool2 = super.onTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    catch (Throwable paramMotionEvent)
    {
      for (;;)
      {
        a.ayM(1);
        Log.printErrStackTrace("PullDownParentView", paramMotionEvent, "onTouchEvent err", new Object[0]);
      }
    }
    AppMethodBeat.o(220900);
    return bool1;
  }
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(220891);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(220891);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/MMWeUIBounceView$Companion;", "", "()V", "KEY_onInterceptTouchEvent", "", "KEY_onNestedPreScroll", "KEY_onNestedScroll", "KEY_onStopNestedScroll", "KEY_onTouchEvent", "reportErr", "", "key", "libmmui_release"})
  public static final class a
  {
    public static void ayM(int paramInt)
    {
      AppMethodBeat.i(196749);
      f.Iyx.idkeyStat(1729L, paramInt, 1L, false);
      AppMethodBeat.o(196749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.MMWeUIBounceView
 * JD-Core Version:    0.7.0.1
 */