package com.tencent.mm.view.refreshLayout.f;

import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.g.k;
import androidx.core.g.o;
import androidx.core.g.w;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.refreshLayout.b.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/util/RefreshUtil;", "", "()V", "fling", "", "scrollableView", "Landroid/view/View;", "velocity", "", "isContentView", "", "view", "isScrollableView", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a agRg;
  
  static
  {
    AppMethodBeat.i(235204);
    agRg = new a();
    AppMethodBeat.o(235204);
  }
  
  public static boolean aU(View paramView)
  {
    AppMethodBeat.i(235191);
    if ((!(paramView instanceof f)) && ((mF(paramView)) || ((paramView instanceof ViewPager)) || ((paramView instanceof o))))
    {
      AppMethodBeat.o(235191);
      return true;
    }
    AppMethodBeat.o(235191);
    return false;
  }
  
  public static void bF(View paramView, int paramInt)
  {
    AppMethodBeat.i(235197);
    if ((paramView instanceof ScrollView))
    {
      ((ScrollView)paramView).fling(paramInt);
      AppMethodBeat.o(235197);
      return;
    }
    if ((paramView instanceof AbsListView))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        ((AbsListView)paramView).fling(paramInt);
        AppMethodBeat.o(235197);
      }
    }
    else
    {
      if ((paramView instanceof WebView))
      {
        ((WebView)paramView).flingScroll(0, paramInt);
        AppMethodBeat.o(235197);
        return;
      }
      if ((paramView instanceof NestedScrollView))
      {
        ((NestedScrollView)paramView).eJ(paramInt);
        AppMethodBeat.o(235197);
        return;
      }
      if ((paramView instanceof RecyclerView)) {
        ((RecyclerView)paramView).bs(0, paramInt);
      }
    }
    AppMethodBeat.o(235197);
  }
  
  public static boolean mF(View paramView)
  {
    return (!(paramView instanceof f)) && (((paramView instanceof AbsListView)) || ((paramView instanceof ScrollView)) || ((paramView instanceof w)) || ((paramView instanceof WebView)) || ((paramView instanceof k)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.f.a
 * JD-Core Version:    0.7.0.1
 */