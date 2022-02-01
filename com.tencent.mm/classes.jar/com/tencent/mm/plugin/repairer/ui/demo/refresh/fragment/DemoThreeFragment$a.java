package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoThreeFragment$PagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoThreeFragment;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
final class DemoThreeFragment$a
  extends m
{
  public DemoThreeFragment$a(FragmentManager paramFragmentManager)
  {
    super(localObject);
    AppMethodBeat.i(278552);
    AppMethodBeat.o(278552);
  }
  
  public final int getCount()
  {
    return 3;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(278557);
    Fragment localFragment = (Fragment)new DemoOneFragment();
    AppMethodBeat.o(278557);
    return localFragment;
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    AppMethodBeat.i(278576);
    CharSequence localCharSequence = (CharSequence)s.X("页面", Integer.valueOf(paramInt + 1));
    AppMethodBeat.o(278576);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoThreeFragment.a
 * JD-Core Version:    0.7.0.1
 */