package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isAtEnd", "", "Landroid/view/View;", "Landroid/widget/AbsListView;", "Landroid/widget/ScrollView;", "isAtStart", "setAtEndCallback", "", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "weui-native-android-lib_release"})
public final class k
{
  private static boolean a(AbsListView paramAbsListView)
  {
    AppMethodBeat.i(251082);
    p.k(paramAbsListView, "$this$isAtStart");
    if (paramAbsListView.getChildCount() <= 0)
    {
      AppMethodBeat.o(251082);
      return true;
    }
    View localView = paramAbsListView.getChildAt(0);
    p.j(localView, "getChildAt(0)");
    int i = localView.getTop();
    if ((paramAbsListView.getFirstVisiblePosition() <= 0) && (i >= paramAbsListView.getListPaddingTop()))
    {
      AppMethodBeat.o(251082);
      return true;
    }
    AppMethodBeat.o(251082);
    return false;
  }
  
  private static boolean a(ScrollView paramScrollView)
  {
    AppMethodBeat.i(251080);
    p.k(paramScrollView, "$this$isAtStart");
    if (!paramScrollView.canScrollVertically(-1))
    {
      AppMethodBeat.o(251080);
      return true;
    }
    AppMethodBeat.o(251080);
    return false;
  }
  
  private static boolean b(AbsListView paramAbsListView)
  {
    AppMethodBeat.i(251083);
    p.k(paramAbsListView, "$this$isAtEnd");
    if (paramAbsListView.getChildCount() <= 0)
    {
      AppMethodBeat.o(251083);
      return false;
    }
    int i = paramAbsListView.getChildCount();
    int j = paramAbsListView.getCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    View localView = paramAbsListView.getChildAt(i - 1);
    p.j(localView, "getChildAt(childCount - 1)");
    int m = localView.getBottom();
    if ((k + i >= j) && (m <= paramAbsListView.getHeight() - paramAbsListView.getListPaddingBottom()))
    {
      AppMethodBeat.o(251083);
      return true;
    }
    AppMethodBeat.o(251083);
    return false;
  }
  
  private static boolean b(ScrollView paramScrollView)
  {
    AppMethodBeat.i(251081);
    p.k(paramScrollView, "$this$isAtEnd");
    if (!paramScrollView.canScrollVertically(1))
    {
      AppMethodBeat.o(251081);
      return true;
    }
    AppMethodBeat.o(251081);
    return false;
  }
  
  public static final boolean iT(View paramView)
  {
    AppMethodBeat.i(251078);
    p.k(paramView, "$this$isAtStart");
    Object localObject = paramView.getTag(a.f.weui_at_start_callback);
    boolean bool;
    if ((localObject instanceof b))
    {
      bool = ((b)localObject).fhP();
      AppMethodBeat.o(251078);
      return bool;
    }
    if ((paramView instanceof ScrollView))
    {
      bool = a((ScrollView)paramView);
      AppMethodBeat.o(251078);
      return bool;
    }
    if ((paramView instanceof AbsListView))
    {
      bool = a((AbsListView)paramView);
      AppMethodBeat.o(251078);
      return bool;
    }
    AppMethodBeat.o(251078);
    return true;
  }
  
  public static final boolean iU(View paramView)
  {
    AppMethodBeat.i(251079);
    p.k(paramView, "$this$isAtEnd");
    Object localObject = paramView.getTag(a.f.weui_at_end_callback);
    boolean bool;
    if ((localObject instanceof a))
    {
      bool = ((a)localObject).hWy();
      AppMethodBeat.o(251079);
      return bool;
    }
    if ((paramView instanceof ScrollView))
    {
      bool = b((ScrollView)paramView);
      AppMethodBeat.o(251079);
      return bool;
    }
    if ((paramView instanceof AbsListView))
    {
      bool = b((AbsListView)paramView);
      AppMethodBeat.o(251079);
      return bool;
    }
    AppMethodBeat.o(251079);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.k
 * JD-Core Version:    0.7.0.1
 */