package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.google.android.material.tabs.TabLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoThreeFragment;", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoThreeFragment$PagerAdapter;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getLayoutId", "", "initData", "", "initView", "view", "Landroid/view/View;", "PagerAdapter", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DemoThreeFragment
  extends BaseFragment
{
  private DemoThreeFragment.a Oyh;
  private ViewPager dyl;
  private TabLayout yaj;
  
  public final void aNi() {}
  
  public final int getLayoutId()
  {
    return b.d.OvM;
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(278503);
    s.u(paramView, "view");
    this.dyl = ((ViewPager)paramView.findViewById(b.c.viewPager));
    this.yaj = ((TabLayout)paramView.findViewById(b.c.tabLayout));
    paramView = getActivity();
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getSupportFragmentManager())
    {
      this.Oyh = new DemoThreeFragment.a(this, paramView);
      paramView = this.dyl;
      if (paramView != null) {
        paramView.setAdapter((a)this.Oyh);
      }
      paramView = this.yaj;
      if (paramView != null) {
        paramView.setupWithViewPager(this.dyl);
      }
      AppMethodBeat.o(278503);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoThreeFragment
 * JD-Core Version:    0.7.0.1
 */