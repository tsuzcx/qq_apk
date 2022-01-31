package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

final class MMBaseSelectContactUI$4
  implements AbsListView.OnScrollListener
{
  MMBaseSelectContactUI$4(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.vLX.VC()) && (MMBaseSelectContactUI.d(this.vLX) != null))
    {
      paramAbsListView = MMBaseSelectContactUI.e(this.vLX).getChildAt(MMBaseSelectContactUI.e(this.vLX).getFirstVisiblePosition());
      if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0)) {
        MMBaseSelectContactUI.f(this.vLX).setVisibility(8);
      }
    }
    else
    {
      if (paramInt1 >= 2) {
        break label84;
      }
    }
    label84:
    do
    {
      return;
      MMBaseSelectContactUI.f(this.vLX).setVisibility(0);
      break;
      g.DQ();
    } while (bk.d((Boolean)g.DP().Dz().get(12296, null)));
    g.DQ();
    g.DP().Dz().o(12296, Boolean.valueOf(true));
    if (MMBaseSelectContactUI.g(this.vLX) != null) {
      MMBaseSelectContactUI.g(this.vLX).dismiss();
    }
    MMBaseSelectContactUI.a(this.vLX, s.a(this.vLX, this.vLX.getString(a.h.main_slide_toast), 4000L));
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      this.vLX.XM();
      this.vLX.cHL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */