package com.tencent.mm.ui.contact;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ch.d;
import com.tencent.mm.sdk.platformtools.y;

final class OpenIMAddressUI$a$4
  implements AbsListView.OnScrollListener
{
  OpenIMAddressUI$a$4(OpenIMAddressUI.a parama) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    y.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2) {
      d.cxA().dA(OpenIMAddressUI.class.getName() + ".Listview", 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a.4
 * JD-Core Version:    0.7.0.1
 */