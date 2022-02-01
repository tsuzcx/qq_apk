package com.tencent.mm.plugin.profile.ui.tab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;)V", "getFragments", "()Ljava/util/List;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "i", "app_release"})
public final class ContactWidgetTabBizInfo$a
  extends h
{
  private final List<BaseBizProfileFragment> fragments;
  
  public ContactWidgetTabBizInfo$a(List<? extends BaseBizProfileFragment> paramList, e parame)
  {
    super(parame);
    AppMethodBeat.i(285924);
    this.fragments = paramList;
    AppMethodBeat.o(285924);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(285920);
    int i = this.fragments.size();
    AppMethodBeat.o(285920);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(285922);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(285922);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.a
 * JD-Core Version:    0.7.0.1
 */