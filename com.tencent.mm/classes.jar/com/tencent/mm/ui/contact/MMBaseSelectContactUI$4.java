package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;

final class MMBaseSelectContactUI$4
  implements AbsListView.OnScrollListener
{
  MMBaseSelectContactUI$4(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(105218);
    if ((!this.Adz.apa()) && (MMBaseSelectContactUI.d(this.Adz) != null))
    {
      paramAbsListView = MMBaseSelectContactUI.e(this.Adz).getChildAt(MMBaseSelectContactUI.e(this.Adz).getFirstVisiblePosition());
      if ((paramAbsListView == null) || (paramAbsListView.getTop() != 0)) {
        break label80;
      }
      MMBaseSelectContactUI.f(this.Adz).setVisibility(8);
    }
    while (paramInt1 < 2)
    {
      AppMethodBeat.o(105218);
      return;
      label80:
      MMBaseSelectContactUI.f(this.Adz).setVisibility(0);
    }
    g.RM();
    if (!bo.e((Boolean)g.RL().Ru().get(12296, null)))
    {
      g.RM();
      g.RL().Ru().set(12296, Boolean.TRUE);
      if (MMBaseSelectContactUI.g(this.Adz) != null) {
        MMBaseSelectContactUI.g(this.Adz).dismiss();
      }
      MMBaseSelectContactUI.a(this.Adz, t.a(this.Adz, this.Adz.getString(2131301429), 4000L));
    }
    AppMethodBeat.o(105218);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(105217);
    if (paramInt != 0)
    {
      this.Adz.hideVKB();
      this.Adz.dMd();
    }
    AppMethodBeat.o(105217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */