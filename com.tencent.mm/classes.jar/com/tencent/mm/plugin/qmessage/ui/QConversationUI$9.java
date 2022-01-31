package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.storage.ak;

final class QConversationUI$9
  implements AdapterView.OnItemClickListener
{
  QConversationUI$9(QConversationUI paramQConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24135);
    paramAdapterView = (ak)QConversationUI.b(this.pIm).getItem(paramInt);
    paramView = new Intent();
    paramView.addFlags(67108864);
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("key_need_send_video", false);
    a.gmO.d(paramView, this.pIm.getContext());
    AppMethodBeat.o(24135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.QConversationUI.9
 * JD-Core Version:    0.7.0.1
 */