package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

final class GroupCardSelectUI$1
  implements AdapterView.OnItemClickListener
{
  GroupCardSelectUI$1(GroupCardSelectUI paramGroupCardSelectUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ad)GroupCardSelectUI.a(this.vLx).getItem(paramInt);
    if (paramAdapterView == null)
    {
      y.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
      return;
    }
    GroupCardSelectUI.a(this.vLx, paramAdapterView);
    GroupCardSelectUI.b(this.vLx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI.1
 * JD-Core Version:    0.7.0.1
 */