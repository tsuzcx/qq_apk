package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.sns.i.f;

final class DynamicGridView$2
  implements AbsListView.OnScrollListener
{
  private int doE;
  private int pqM = -1;
  private int pqN = -1;
  private int pqO;
  private int pqP;
  
  DynamicGridView$2(DynamicGridView paramDynamicGridView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pqO = paramInt1;
    this.pqP = paramInt2;
    int i;
    label44:
    label207:
    View localView;
    if (this.pqM == -1)
    {
      i = this.pqO;
      this.pqM = i;
      if (this.pqN != -1) {
        break label303;
      }
      i = this.pqP;
      this.pqN = i;
      if ((this.pqO != this.pqM) && (DynamicGridView.k(this.pqL)) && (DynamicGridView.h(this.pqL) != -1L))
      {
        DynamicGridView.a(this.pqL, DynamicGridView.h(this.pqL));
        DynamicGridView.p(this.pqL);
      }
      if ((this.pqO + this.pqP != this.pqM + this.pqN) && (DynamicGridView.k(this.pqL)) && (DynamicGridView.h(this.pqL) != -1L))
      {
        DynamicGridView.a(this.pqL, DynamicGridView.h(this.pqL));
        DynamicGridView.p(this.pqL);
      }
      this.pqM = this.pqO;
      this.pqN = this.pqP;
      if ((!DynamicGridView.bKz()) || (!DynamicGridView.i(this.pqL))) {
        break label369;
      }
      i = 0;
      if (i >= paramInt2) {
        break label369;
      }
      localView = this.pqL.getChildAt(i);
      if (localView != null)
      {
        if ((DynamicGridView.h(this.pqL) == -1L) || (Boolean.TRUE == localView.getTag(i.f.dgv_wobble_tag))) {
          break label324;
        }
        if (i % 2 != 0) {
          break label312;
        }
        DynamicGridView.c(this.pqL, localView);
        label273:
        localView.setTag(i.f.dgv_wobble_tag, Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      i += 1;
      break label207;
      i = this.pqM;
      break;
      label303:
      i = this.pqN;
      break label44;
      label312:
      DynamicGridView.d(this.pqL, localView);
      break label273;
      label324:
      if ((DynamicGridView.h(this.pqL) == -1L) && (localView.getRotation() != 0.0F))
      {
        localView.setRotation(0.0F);
        localView.setTag(i.f.dgv_wobble_tag, Boolean.valueOf(false));
      }
    }
    label369:
    if (DynamicGridView.j(this.pqL) != null) {
      DynamicGridView.j(this.pqL).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.doE = paramInt;
    DynamicGridView.c(this.pqL, paramInt);
    if ((this.pqP > 0) && (this.doE == 0))
    {
      if ((!DynamicGridView.k(this.pqL)) || (!DynamicGridView.l(this.pqL))) {
        break label80;
      }
      DynamicGridView.m(this.pqL);
    }
    for (;;)
    {
      if (DynamicGridView.j(this.pqL) != null) {
        DynamicGridView.j(this.pqL).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      label80:
      if (DynamicGridView.n(this.pqL)) {
        DynamicGridView.o(this.pqL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.2
 * JD-Core Version:    0.7.0.1
 */