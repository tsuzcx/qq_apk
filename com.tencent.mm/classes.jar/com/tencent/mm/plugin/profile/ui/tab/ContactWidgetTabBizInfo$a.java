package com.tencent.mm.plugin.profile.ui.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.profile.ui.tab.list.BaseBizProfileFragment;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$BizProfilePagerAdapter;", "Landroid/support/v4/app/FragmentStatePagerAdapter;", "fragments", "", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BaseBizProfileFragment;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Ljava/util/List;Landroid/support/v4/app/FragmentManager;)V", "getFragments", "()Ljava/util/List;", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "i", "app_release"})
public final class ContactWidgetTabBizInfo$a
  extends j
{
  private final List<BaseBizProfileFragment> fragments;
  
  public ContactWidgetTabBizInfo$a(List<? extends BaseBizProfileFragment> paramList, g paramg)
  {
    super(paramg);
    AppMethodBeat.i(230668);
    this.fragments = paramList;
    AppMethodBeat.o(230668);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(230666);
    int i = this.fragments.size();
    AppMethodBeat.o(230666);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(230667);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(230667);
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.a
 * JD-Core Version:    0.7.0.1
 */