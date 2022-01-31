package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.e;

final class OpenIMAddressUI$a$16
  implements AdapterView.OnItemLongClickListener
{
  OpenIMAddressUI$a$16(OpenIMAddressUI.a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + paramInt);
    if (paramInt < OpenIMAddressUI.a.c(this.vMP).getHeaderViewsCount())
    {
      y.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
      return true;
    }
    if ((OpenIMAddressUI.a.d(this.vMP) != null) && (OpenIMAddressUI.a.d(this.vMP).wiO)) {
      return true;
    }
    paramAdapterView = (f)OpenIMAddressUI.a.a(this.vMP).FC(paramInt - OpenIMAddressUI.a.c(this.vMP).getHeaderViewsCount());
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(OpenIMAddressUI.a.c(this.vMP).getHeaderViewsCount()) });
      return true;
    }
    paramAdapterView = paramAdapterView.field_username;
    if ((s.hK(paramAdapterView)) || (s.hL(paramAdapterView))) {
      return true;
    }
    OpenIMAddressUI.a.b(this.vMP, paramAdapterView);
    OpenIMAddressUI.a.h(this.vMP).a(paramView, paramInt, paramLong, this.vMP, OpenIMAddressUI.a.e(this.vMP), OpenIMAddressUI.a.f(this.vMP), OpenIMAddressUI.a.g(this.vMP));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a.16
 * JD-Core Version:    0.7.0.1
 */