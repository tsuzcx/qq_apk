package com.tencent.mm.ui.bizchat;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.a.l;
import com.tencent.mm.model.au;

final class BizChatSearchUI$1
  implements AbsListView.OnScrollListener
{
  boolean icY = false;
  
  BizChatSearchUI$1(BizChatSearchUI paramBizChatSearchUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt2 == paramInt3)
    {
      this.icY = true;
      return;
    }
    this.icY = false;
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.icY) && (BizChatSearchUI.a(this.vfi).vfw))
    {
      paramAbsListView = BizChatSearchUI.a(this.vfi);
      if ((paramAbsListView.cBF()) && (!paramAbsListView.vfy))
      {
        paramAbsListView.vfy = true;
        l locall = new l(paramAbsListView.idQ, paramAbsListView.drv, paramAbsListView.vfC);
        au.Dk().a(locall, 0);
        paramAbsListView.cBH();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI.1
 * JD-Core Version:    0.7.0.1
 */