package com.tencent.mm.ui.contact;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenIMAddressUI$OpenIMAddressUIFragment$4
  implements AbsListView.OnScrollListener
{
  OpenIMAddressUI$OpenIMAddressUIFragment$4(OpenIMAddressUI.OpenIMAddressUIFragment paramOpenIMAddressUIFragment) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(33768);
    ab.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(33768);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(33769);
    ab.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2) {
      d.dAt().eJ(OpenIMAddressUI.class.getName() + ".Listview", 4);
    }
    AppMethodBeat.o(33769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.4
 * JD-Core Version:    0.7.0.1
 */