package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

final class GroupCardSelectUI$1
  implements AdapterView.OnItemClickListener
{
  GroupCardSelectUI$1(GroupCardSelectUI paramGroupCardSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(33728);
    paramAdapterView = (ad)GroupCardSelectUI.a(this.AcZ).getItem(paramInt);
    if (paramAdapterView == null)
    {
      ab.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
      AppMethodBeat.o(33728);
      return;
    }
    GroupCardSelectUI.a(this.AcZ, paramAdapterView);
    GroupCardSelectUI.b(this.AcZ);
    AppMethodBeat.o(33728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI.1
 * JD-Core Version:    0.7.0.1
 */