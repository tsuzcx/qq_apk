package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.plugin.wxpay.a.c;

final class SnsLuckyMoneyDetailUI$1
  implements AbsListView.OnScrollListener
{
  private boolean lMc = false;
  private boolean lMd;
  
  SnsLuckyMoneyDetailUI$1(SnsLuckyMoneyDetailUI paramSnsLuckyMoneyDetailUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((paramInt3 == 0) || (!this.lMc)) {
      return;
    }
    if (paramInt1 > 0) {}
    label20:
    label51:
    label87:
    label93:
    label96:
    for (;;)
    {
      if (this.lMd != bool)
      {
        if (!bool) {
          break label87;
        }
        this.ooi.getResources().getDrawable(a.c.sns_lucky_background_start_color);
        SnsLuckyMoneyDetailUI.bCx();
        this.lMd = bool;
        return;
        paramAbsListView = paramAbsListView.getChildAt(paramInt1);
        if (paramAbsListView == null) {
          break label93;
        }
      }
      for (paramInt1 = 0 - paramAbsListView.getTop();; paramInt1 = 0)
      {
        if (paramInt1 > 100) {
          break label96;
        }
        bool = false;
        break label20;
        break;
        SnsLuckyMoneyDetailUI.bCy();
        break label51;
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView.getCount() == 0) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.lMc = false;
      return;
    }
    this.lMc = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.1
 * JD-Core Version:    0.7.0.1
 */