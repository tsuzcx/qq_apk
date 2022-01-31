package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.voicesearch.b;

final class AddressUI$AddressUIFragment$5
  implements AdapterView.OnItemLongClickListener
{
  AddressUI$AddressUIFragment$5(AddressUI.AddressUIFragment paramAddressUIFragment) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33487);
    ab.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramInt)));
    if (paramInt < AddressUI.AddressUIFragment.d(this.AaO).getHeaderViewsCount())
    {
      ab.w("MicroMsg.AddressUI", "on item long click, but match header view");
      AppMethodBeat.o(33487);
      return true;
    }
    if ((AddressUI.AddressUIFragment.h(this.AaO) != null) && (AddressUI.AddressUIFragment.h(this.AaO).ABF))
    {
      AppMethodBeat.o(33487);
      return true;
    }
    paramAdapterView = (f)AddressUI.AddressUIFragment.a(this.AaO).NM(paramInt - AddressUI.AddressUIFragment.d(this.AaO).getHeaderViewsCount());
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AddressUI.AddressUIFragment.d(this.AaO).getHeaderViewsCount()) });
      AppMethodBeat.o(33487);
      return true;
    }
    paramAdapterView = paramAdapterView.field_username;
    if ((t.ot(paramAdapterView)) || (t.ou(paramAdapterView)))
    {
      AppMethodBeat.o(33487);
      return true;
    }
    AddressUI.AddressUIFragment.b(this.AaO, paramAdapterView);
    AddressUI.AddressUIFragment.m(this.AaO).a(paramView, paramInt, paramLong, this.AaO, AddressUI.AddressUIFragment.j(this.AaO), AddressUI.AddressUIFragment.k(this.AaO), AddressUI.AddressUIFragment.l(this.AaO));
    AppMethodBeat.o(33487);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment.5
 * JD-Core Version:    0.7.0.1
 */