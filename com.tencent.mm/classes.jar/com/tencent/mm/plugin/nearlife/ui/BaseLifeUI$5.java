package com.tencent.mm.plugin.nearlife.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.tools.n.b;

final class BaseLifeUI$5
  implements n.b
{
  BaseLifeUI$5(BaseLifeUI paramBaseLifeUI) {}
  
  public final void Wl()
  {
    y.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
    this.mEV.fiq = false;
    this.mEV.lIy.setAdapter(BaseLifeUI.f(this.mEV));
    BaseLifeUI.f(this.mEV).notifyDataSetChanged();
    BaseLifeUI.g(this.mEV).vj(BaseLifeUI.f(this.mEV).mEu);
    if ((!BaseLifeUI.f(this.mEV).bol()) && (BaseLifeUI.h(this.mEV) != null)) {
      BaseLifeUI.h(this.mEV).setVisibility(0);
    }
    this.mEV.lIy.setOnTouchListener(null);
    BaseLifeUI.e(this.mEV);
    BaseLifeUI.a(this.mEV, BaseLifeUI.f(this.mEV));
  }
  
  public final void Wm()
  {
    y.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
    this.mEV.mEP = true;
    BaseLifeUI.i(this.mEV).setHint(this.mEV.getString(R.l.near_life_search_hint));
    this.mEV.fiq = true;
    BaseLifeUI.b(this.mEV).boj();
    this.mEV.lIy.setAdapter(BaseLifeUI.b(this.mEV));
    BaseLifeUI.b(this.mEV).notifyDataSetChanged();
    this.mEV.lIy.cAP();
    BaseLifeUI.g(this.mEV).vj(BaseLifeUI.b(this.mEV).mEu);
    if (BaseLifeUI.h(this.mEV) != null) {
      BaseLifeUI.h(this.mEV).setVisibility(8);
    }
    this.mEV.lIy.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        BaseLifeUI.5.this.mEV.XM();
        return false;
      }
    });
    BaseLifeUI.a(this.mEV, BaseLifeUI.b(this.mEV));
  }
  
  public final void Wn()
  {
    y.d("MicroMsg.BaseLifeUI", "click clear");
    if (BaseLifeUI.c(this.mEV) != null)
    {
      au.Dk().c(BaseLifeUI.c(this.mEV));
      BaseLifeUI.d(this.mEV);
    }
    BaseLifeUI.b(this.mEV).boj();
    BaseLifeUI.e(this.mEV);
  }
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    y.d("MicroMsg.BaseLifeUI", "search key click");
    BaseLifeUI.b(this.mEV, paramString);
    return false;
  }
  
  public final void pC(String paramString)
  {
    y.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramString });
    if (bk.bl(paramString))
    {
      Wn();
      return;
    }
    BaseLifeUI.a(this.mEV, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.5
 * JD-Core Version:    0.7.0.1
 */