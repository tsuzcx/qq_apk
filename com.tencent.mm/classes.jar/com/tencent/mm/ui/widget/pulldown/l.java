package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isAtEnd", "", "Landroid/view/View;", "Landroid/widget/AbsListView;", "Landroid/widget/ScrollView;", "isAtStart", "setAtEndCallback", "", "callback", "Lcom/tencent/mm/ui/widget/pulldown/AtEndCallback;", "setAtStartCallback", "Lcom/tencent/mm/ui/widget/pulldown/AtStartCallback;", "weui-native-android-lib_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  private static boolean a(ScrollView paramScrollView)
  {
    AppMethodBeat.i(251942);
    s.u(paramScrollView, "<this>");
    if (!paramScrollView.canScrollVertically(-1))
    {
      AppMethodBeat.o(251942);
      return true;
    }
    AppMethodBeat.o(251942);
    return false;
  }
  
  private static boolean b(AbsListView paramAbsListView)
  {
    AppMethodBeat.i(251952);
    s.u(paramAbsListView, "<this>");
    if (paramAbsListView.getChildCount() <= 0)
    {
      AppMethodBeat.o(251952);
      return true;
    }
    int i = paramAbsListView.getChildAt(0).getTop();
    if ((paramAbsListView.getFirstVisiblePosition() <= 0) && (i >= paramAbsListView.getListPaddingTop()))
    {
      AppMethodBeat.o(251952);
      return true;
    }
    AppMethodBeat.o(251952);
    return false;
  }
  
  private static boolean b(ScrollView paramScrollView)
  {
    AppMethodBeat.i(251948);
    s.u(paramScrollView, "<this>");
    if (!paramScrollView.canScrollVertically(1))
    {
      AppMethodBeat.o(251948);
      return true;
    }
    AppMethodBeat.o(251948);
    return false;
  }
  
  private static boolean c(AbsListView paramAbsListView)
  {
    AppMethodBeat.i(251959);
    s.u(paramAbsListView, "<this>");
    if (paramAbsListView.getChildCount() <= 0)
    {
      AppMethodBeat.o(251959);
      return false;
    }
    int i = paramAbsListView.getChildCount();
    int j = paramAbsListView.getCount();
    int k = paramAbsListView.getFirstVisiblePosition();
    int m = paramAbsListView.getChildAt(i - 1).getBottom();
    if ((k + i >= j) && (m <= paramAbsListView.getHeight() - paramAbsListView.getListPaddingBottom()))
    {
      AppMethodBeat.o(251959);
      return true;
    }
    AppMethodBeat.o(251959);
    return false;
  }
  
  public static final boolean mq(View paramView)
  {
    AppMethodBeat.i(251931);
    s.u(paramView, "<this>");
    Object localObject = paramView.getTag(a.f.weui_at_start_callback);
    boolean bool;
    if ((localObject instanceof b))
    {
      bool = ((b)localObject).grG();
      AppMethodBeat.o(251931);
      return bool;
    }
    if ((paramView instanceof ScrollView))
    {
      bool = a((ScrollView)paramView);
      AppMethodBeat.o(251931);
      return bool;
    }
    if ((paramView instanceof AbsListView))
    {
      bool = b((AbsListView)paramView);
      AppMethodBeat.o(251931);
      return bool;
    }
    AppMethodBeat.o(251931);
    return true;
  }
  
  public static final boolean mr(View paramView)
  {
    AppMethodBeat.i(251936);
    s.u(paramView, "<this>");
    Object localObject = paramView.getTag(a.f.weui_at_end_callback);
    boolean bool;
    if ((localObject instanceof a))
    {
      bool = ((a)localObject).aau();
      AppMethodBeat.o(251936);
      return bool;
    }
    if ((paramView instanceof ScrollView))
    {
      bool = b((ScrollView)paramView);
      AppMethodBeat.o(251936);
      return bool;
    }
    if ((paramView instanceof AbsListView))
    {
      bool = c((AbsListView)paramView);
      AppMethodBeat.o(251936);
      return bool;
    }
    AppMethodBeat.o(251936);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.l
 * JD-Core Version:    0.7.0.1
 */