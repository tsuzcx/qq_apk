package com.tencent.mm.view.e;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.l.a.e;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.view.SmileyPanelViewPager;

final class a$12
  implements AdapterView.OnItemClickListener
{
  a$12(a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a.k(this.wzg).IQ(paramInt);
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "info is null. ignore click action.");
      return;
    }
    if (paramAdapterView.field_productID.equalsIgnoreCase("TAG_STORE_MANEGER_TAB"))
    {
      a.l(this.wzg);
      return;
    }
    a.a(this.wzg, a.d(this.wzg).IW(a.e(this.wzg)), false, true);
    com.tencent.mm.view.c.a locala = a.d(this.wzg).afc(paramAdapterView.field_productID);
    a.a(this.wzg, locala.hxB);
    if (locala.wyF > locala.cLI() - 1)
    {
      paramInt = locala.cLI() - 1;
      label122:
      if (a.c(this.wzg) != null) {
        a.c(this.wzg).m(a.e(this.wzg) + paramInt, false);
      }
      if ((!a.d(this.wzg).cMh()) || (!locala.iZD.equals("TAG_DEFAULT_TAB"))) {
        break label317;
      }
    }
    label317:
    for (boolean bool = true;; bool = false)
    {
      a.a(this.wzg, locala.cLI(), paramInt, bool);
      a.d(this.wzg).wzE = paramInt;
      a.d(this.wzg).setShowProductId(paramAdapterView.field_productID);
      if ((!paramAdapterView.field_productID.equals(String.valueOf(EmojiGroupInfo.uCR))) || (a.d(this.wzg).fzn != ChatFooterPanel.rZv)) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11594, new Object[] { Integer.valueOf(0) });
      g.DP().Dz().c(ac.a.wuR, Boolean.valueOf(true));
      paramAdapterView = paramView.findViewById(a.e.smiley_listview_item_dot);
      if (paramAdapterView == null) {
        break;
      }
      paramAdapterView.setVisibility(8);
      return;
      paramInt = locala.wyF;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.e.a.12
 * JD-Core Version:    0.7.0.1
 */