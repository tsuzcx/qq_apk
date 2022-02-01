package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends m
{
  public List<Fragment> fragments;
  
  public b(FragmentManager paramFragmentManager, List<Fragment> paramList)
  {
    super(paramFragmentManager);
    AppMethodBeat.i(307281);
    this.fragments = new ArrayList();
    this.fragments = paramList;
    AppMethodBeat.o(307281);
  }
  
  public final void c(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(307287);
    this.fragments.remove(paramFragment);
    if (paramInt >= this.fragments.size())
    {
      this.fragments.add(paramFragment);
      AppMethodBeat.o(307287);
      return;
    }
    this.fragments.add(paramInt, paramFragment);
    AppMethodBeat.o(307287);
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
    AppMethodBeat.i(307283);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(307283);
    return localFragment;
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b
 * JD-Core Version:    0.7.0.1
 */