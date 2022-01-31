package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean ojw = false;
  private boolean ojx;
  
  SnsLuckyMoneyDetailUI$1(SnsLuckyMoneyDetailUI paramSnsLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(45183);
    if ((paramInt3 == 0) || (!this.ojw))
    {
      AppMethodBeat.o(45183);
      return;
    }
    if (paramInt1 > 0) {}
    label60:
    label107:
    label110:
    for (;;)
    {
      if (this.ojx != bool)
      {
        if (bool)
        {
          this.rcz.getResources().getDrawable(2131690493);
          SnsLuckyMoneyDetailUI.cnZ();
          this.ojx = bool;
        }
      }
      else
      {
        AppMethodBeat.o(45183);
        return;
        paramAbsListView = paramAbsListView.getChildAt(paramInt1);
        if (paramAbsListView == null) {
          break label107;
        }
      }
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label110;
        }
        bool = false;
        break;
        SnsLuckyMoneyDetailUI.coa();
        break label60;
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(45182);
    if (paramAbsListView.getCount() == 0)
    {
      AppMethodBeat.o(45182);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45182);
      return;
      this.ojw = false;
      AppMethodBeat.o(45182);
      return;
      this.ojw = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */