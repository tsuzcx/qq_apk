package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends g
{
  public List<Fragment> fragments;
  
  public b(e parame, List<Fragment> paramList)
  {
    super(parame);
    AppMethodBeat.i(254552);
    this.fragments = new ArrayList();
    this.fragments = paramList;
    AppMethodBeat.o(254552);
  }
  
  public final void c(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(254555);
    this.fragments.remove(paramFragment);
    if (paramInt >= this.fragments.size())
    {
      this.fragments.add(paramFragment);
      AppMethodBeat.o(254555);
      return;
    }
    this.fragments.add(paramInt, paramFragment);
    AppMethodBeat.o(254555);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(97126);
    int i = this.fragments.size();
    AppMethodBeat.o(97126);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(254554);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(254554);
    return localFragment;
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b
 * JD-Core Version:    0.7.0.1
 */