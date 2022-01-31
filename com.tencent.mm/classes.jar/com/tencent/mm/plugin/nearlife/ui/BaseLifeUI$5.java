package com.tencent.mm.plugin.nearlife.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.q.b;

final class BaseLifeUI$5
  implements q.b
{
  BaseLifeUI$5(BaseLifeUI paramBaseLifeUI) {}
  
  public final void apN()
  {
    AppMethodBeat.i(22943);
    ab.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
    this.pfa.gzX = false;
    this.pfa.ofL.setAdapter(BaseLifeUI.f(this.pfa));
    BaseLifeUI.f(this.pfa).notifyDataSetChanged();
    BaseLifeUI.g(this.pfa).AH(BaseLifeUI.f(this.pfa).pex);
    if ((!BaseLifeUI.f(this.pfa).bWK()) && (BaseLifeUI.h(this.pfa) != null)) {
      BaseLifeUI.h(this.pfa).setVisibility(0);
    }
    this.pfa.ofL.setOnTouchListener(null);
    BaseLifeUI.e(this.pfa);
    BaseLifeUI.a(this.pfa, BaseLifeUI.f(this.pfa));
    AppMethodBeat.o(22943);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(22944);
    ab.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
    this.pfa.peS = true;
    BaseLifeUI.i(this.pfa).setHint(this.pfa.getString(2131301745));
    this.pfa.gzX = true;
    BaseLifeUI.b(this.pfa).bWI();
    this.pfa.ofL.setAdapter(BaseLifeUI.b(this.pfa));
    BaseLifeUI.b(this.pfa).notifyDataSetChanged();
    this.pfa.ofL.dDZ();
    BaseLifeUI.g(this.pfa).AH(BaseLifeUI.b(this.pfa).pex);
    if (BaseLifeUI.h(this.pfa) != null) {
      BaseLifeUI.h(this.pfa).setVisibility(8);
    }
    this.pfa.ofL.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(22940);
        BaseLifeUI.5.this.pfa.hideVKB();
        AppMethodBeat.o(22940);
        return false;
      }
    });
    BaseLifeUI.a(this.pfa, BaseLifeUI.b(this.pfa));
    AppMethodBeat.o(22944);
  }
  
  public final void apP()
  {
    AppMethodBeat.i(22941);
    ab.d("MicroMsg.BaseLifeUI", "click clear");
    if (BaseLifeUI.c(this.pfa) != null)
    {
      aw.Rc().a(BaseLifeUI.c(this.pfa));
      BaseLifeUI.d(this.pfa);
    }
    BaseLifeUI.b(this.pfa).bWI();
    BaseLifeUI.e(this.pfa);
    AppMethodBeat.o(22941);
  }
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(22945);
    ab.d("MicroMsg.BaseLifeUI", "search key click");
    BaseLifeUI.b(this.pfa, paramString);
    AppMethodBeat.o(22945);
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(22942);
    ab.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      apP();
      AppMethodBeat.o(22942);
      return;
    }
    BaseLifeUI.a(this.pfa, paramString);
    AppMethodBeat.o(22942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.5
 * JD-Core Version:    0.7.0.1
 */