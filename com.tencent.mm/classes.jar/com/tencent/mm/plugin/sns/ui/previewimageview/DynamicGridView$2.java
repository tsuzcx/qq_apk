package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$2
  implements AbsListView.OnScrollListener
{
  private int ega;
  private int slE = -1;
  private int slF = -1;
  private int slG;
  private int slH;
  
  DynamicGridView$2(DynamicGridView paramDynamicGridView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40344);
    this.slG = paramInt1;
    this.slH = paramInt2;
    int i;
    label49:
    label212:
    View localView;
    if (this.slE == -1)
    {
      i = this.slG;
      this.slE = i;
      if (this.slF != -1) {
        break label305;
      }
      i = this.slH;
      this.slF = i;
      if ((this.slG != this.slE) && (DynamicGridView.k(this.slD)) && (DynamicGridView.h(this.slD) != -1L))
      {
        DynamicGridView.a(this.slD, DynamicGridView.h(this.slD));
        DynamicGridView.p(this.slD);
      }
      if ((this.slG + this.slH != this.slE + this.slF) && (DynamicGridView.k(this.slD)) && (DynamicGridView.h(this.slD) != -1L))
      {
        DynamicGridView.a(this.slD, DynamicGridView.h(this.slD));
        DynamicGridView.p(this.slD);
      }
      this.slE = this.slG;
      this.slF = this.slH;
      if ((!DynamicGridView.cxn()) || (!DynamicGridView.i(this.slD))) {
        break label369;
      }
      i = 0;
      if (i >= paramInt2) {
        break label369;
      }
      localView = this.slD.getChildAt(i);
      if (localView != null)
      {
        if ((DynamicGridView.h(this.slD) == -1L) || (Boolean.TRUE == localView.getTag(2131820591))) {
          break label326;
        }
        if (i % 2 != 0) {
          break label314;
        }
        DynamicGridView.c(this.slD, localView);
        label277:
        localView.setTag(2131820591, Boolean.TRUE);
      }
    }
    for (;;)
    {
      i += 1;
      break label212;
      i = this.slE;
      break;
      label305:
      i = this.slF;
      break label49;
      label314:
      DynamicGridView.d(this.slD, localView);
      break label277;
      label326:
      if ((DynamicGridView.h(this.slD) == -1L) && (localView.getRotation() != 0.0F))
      {
        localView.setRotation(0.0F);
        localView.setTag(2131820591, Boolean.FALSE);
      }
    }
    label369:
    if (DynamicGridView.j(this.slD) != null) {
      DynamicGridView.j(this.slD).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(40344);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(40345);
    this.ega = paramInt;
    DynamicGridView.c(this.slD, paramInt);
    if ((this.slH > 0) && (this.ega == 0))
    {
      if ((!DynamicGridView.k(this.slD)) || (!DynamicGridView.l(this.slD))) {
        break label90;
      }
      DynamicGridView.m(this.slD);
    }
    for (;;)
    {
      if (DynamicGridView.j(this.slD) != null) {
        DynamicGridView.j(this.slD).onScrollStateChanged(paramAbsListView, paramInt);
      }
      AppMethodBeat.o(40345);
      return;
      label90:
      if (DynamicGridView.n(this.slD)) {
        DynamicGridView.o(this.slD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.2
 * JD-Core Version:    0.7.0.1
 */