package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

final class SnsChatRoomMemberUI$1
  implements AdapterView.OnItemClickListener
{
  SnsChatRoomMemberUI$1(SnsChatRoomMemberUI paramSnsChatRoomMemberUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(145527);
    if (SnsChatRoomMemberUI.a(this.rOn).EL(paramInt).type == 1)
    {
      ad localad = SnsChatRoomMemberUI.a(this.rOn).EL(paramInt).contact;
      if (localad == null)
      {
        ab.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
        AppMethodBeat.o(145527);
        return;
      }
      String str1 = localad.field_username;
      String str2 = localad.field_nickname;
      paramView = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.b(this.rOn), str1);
      paramAdapterView = paramView;
      if (bo.isNullOrNil(paramView)) {
        paramAdapterView = localad.Of();
      }
      SnsChatRoomMemberUI.a(this.rOn, str1, paramAdapterView, str2);
    }
    AppMethodBeat.o(145527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.1
 * JD-Core Version:    0.7.0.1
 */