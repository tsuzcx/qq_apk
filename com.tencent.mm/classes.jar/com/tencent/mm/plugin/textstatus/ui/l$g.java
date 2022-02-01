package com.tencent.mm.plugin.textstatus.ui;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusPagerUIC$initActionBar$3", "Lcom/google/android/material/tabs/TabLayout$TabLayoutOnPageChangeListener;", "onPageSelected", "", "position", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$g
  extends TabLayout.f
{
  l$g(TabLayout paramTabLayout)
  {
    super(paramTabLayout);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(291260);
    super.onPageSelected(paramInt);
    Log.d("MicroMsg.TextStatus.TextStatusPagerUIC", s.X("onPageSelected() called with: position = ", Integer.valueOf(paramInt)));
    AppMethodBeat.o(291260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.l.g
 * JD-Core Version:    0.7.0.1
 */