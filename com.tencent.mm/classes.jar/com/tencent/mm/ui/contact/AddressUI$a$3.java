package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.voicesearch.b;

final class AddressUI$a$3
  implements AdapterView.OnItemLongClickListener
{
  AddressUI$a$3(AddressUI.a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + paramInt);
    if (paramInt < AddressUI.a.c(this.vJs).getHeaderViewsCount())
    {
      y.w("MicroMsg.AddressUI", "on item long click, but match header view");
      return true;
    }
    if ((AddressUI.a.g(this.vJs) != null) && (AddressUI.a.g(this.vJs).wiO)) {
      return true;
    }
    paramAdapterView = (f)AddressUI.a.a(this.vJs).FC(paramInt - AddressUI.a.c(this.vJs).getHeaderViewsCount());
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(AddressUI.a.c(this.vJs).getHeaderViewsCount()) });
      return true;
    }
    paramAdapterView = paramAdapterView.field_username;
    if ((s.hK(paramAdapterView)) || (s.hL(paramAdapterView))) {
      return true;
    }
    AddressUI.a.b(this.vJs, paramAdapterView);
    AddressUI.a.l(this.vJs).a(paramView, paramInt, paramLong, this.vJs, AddressUI.a.i(this.vJs), AddressUI.a.j(this.vJs), AddressUI.a.k(this.vJs));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.3
 * JD-Core Version:    0.7.0.1
 */