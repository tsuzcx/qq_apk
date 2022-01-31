package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae;

final class ContentFragment$1
  extends RecyclerView.m
{
  ContentFragment$1(ContentFragment paramContentFragment) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37613);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if ((ContentFragment.a(this.rzA).rzF != null) && (ContentFragment.a(this.rzA).rzF.getVisibility() == 0)) {
      ContentFragment.a(this.rzA).rzF.scrollBy(paramInt1, paramInt2);
    }
    AppMethodBeat.o(37613);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(37614);
    super.c(paramRecyclerView, paramInt);
    ContentFragment.a(this.rzA, paramInt);
    if (paramInt == 0)
    {
      if (ContentFragment.b(this.rzA))
      {
        this.rzA.crJ();
        AppMethodBeat.o(37614);
      }
    }
    else if (paramInt == 1)
    {
      this.rzA.crK();
      ae.eV(this.rzA.getContext());
    }
    AppMethodBeat.o(37614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment.1
 * JD-Core Version:    0.7.0.1
 */