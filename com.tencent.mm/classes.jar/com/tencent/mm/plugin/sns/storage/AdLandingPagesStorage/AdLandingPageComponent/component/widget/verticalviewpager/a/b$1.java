package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;

final class b$1
  extends RecyclerView.m
{
  b$1(b paramb) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
    if ((b.a(this.oJz).oJI != null) && (b.a(this.oJz).oJI.getVisibility() == 0)) {
      b.a(this.oJz).oJI.scrollBy(paramInt1, paramInt2);
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    b.a(this.oJz, paramInt);
    if (paramInt == 0) {
      if (b.b(this.oJz)) {
        this.oJz.bFQ();
      }
    }
    while (paramInt != 1) {
      return;
    }
    this.oJz.bFP();
    ad.ee(this.oJz.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.1
 * JD-Core Version:    0.7.0.1
 */