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
  public List<Fragment> rzK;
  
  public b(g paramg, List<Fragment> paramList)
  {
    super(paramg);
    AppMethodBeat.i(37650);
    this.rzK = new ArrayList();
    this.rzK = paramList;
    AppMethodBeat.o(37650);
  }
  
  public final void b(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(37653);
    this.rzK.remove(paramFragment);
    if (paramInt >= this.rzK.size())
    {
      this.rzK.add(paramFragment);
      AppMethodBeat.o(37653);
      return;
    }
    this.rzK.add(paramInt, paramFragment);
    AppMethodBeat.o(37653);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37652);
    int i = this.rzK.size();
    AppMethodBeat.o(37652);
    return i;
  }
  
  public final Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(37651);
    Fragment localFragment = (Fragment)this.rzK.get(paramInt);
    AppMethodBeat.o(37651);
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