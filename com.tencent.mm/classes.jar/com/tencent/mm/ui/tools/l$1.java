package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.m;
import java.util.Iterator;
import java.util.List;

final class l$1
  implements AdapterView.OnItemLongClickListener
{
  l$1(l paraml, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107701);
    l.a(this.Awb).clear();
    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
    paramAdapterView = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    this.Awa.onCreateContextMenu(l.a(this.Awb), paramView, paramAdapterView);
    paramView = l.a(this.Awb).zkW.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).zkZ = paramAdapterView;
    }
    this.Awb.cwt();
    AppMethodBeat.o(107701);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l.1
 * JD-Core Version:    0.7.0.1
 */