package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  public List<Fragment> fragments;
  
  public b(g paramg, List<Fragment> paramList)
  {
    super(paramg);
    AppMethodBeat.i(97124);
    this.fragments = new ArrayList();
    this.fragments = paramList;
    AppMethodBeat.o(97124);
  }
  
  public final void c(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(97127);
    this.fragments.remove(paramFragment);
    if (paramInt >= this.fragments.size())
    {
      this.fragments.add(paramFragment);
      AppMethodBeat.o(97127);
      return;
    }
    this.fragments.add(paramInt, paramFragment);
    AppMethodBeat.o(97127);
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
    AppMethodBeat.i(97125);
    Fragment localFragment = (Fragment)this.fragments.get(paramInt);
    AppMethodBeat.o(97125);
    return localFragment;
  }
  
  public final CharSequence getPageTitle(int paramInt)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.b
 * JD-Core Version:    0.7.0.1
 */