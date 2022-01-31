package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$3
  implements AdapterView.OnItemClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$3(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    AppMethodBeat.i(34419);
    ak localak = (ak)EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.AkO).getItem(paramInt);
    if (localak == null)
    {
      ab.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.AkO).getCount()) });
      EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.AkO).notifyDataSetChanged();
      AppMethodBeat.o(34419);
      return;
    }
    if (f.lg(localak.field_username))
    {
      paramAdapterView = new Intent(this.AkO.thisActivity(), BizChatConversationUI.class);
      paramAdapterView.putExtra("Contact_User", localak.field_username);
      paramAdapterView.putExtra("biz_chat_from_scene", 7);
      paramAdapterView.addFlags(67108864);
      this.AkO.startActivity(paramAdapterView);
      AppMethodBeat.o(34419);
      return;
    }
    if (f.rY(localak.field_username))
    {
      com.tencent.mm.aj.d locald = f.rS(localak.field_username);
      if (locald == null) {}
      for (;;)
      {
        paramView = paramAdapterView;
        if (paramAdapterView == null) {
          paramView = "";
        }
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("rawUrl", paramView);
        paramAdapterView.putExtra("useJs", true);
        paramAdapterView.putExtra("srcUsername", localak.field_username);
        paramAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        paramAdapterView.putExtra("geta8key_scene", 51);
        paramAdapterView.addFlags(67108864);
        com.tencent.mm.bq.d.b(this.AkO.getContext(), "webview", ".ui.tools.WebViewUI", paramAdapterView);
        EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.AkO, locald, 2, localak.field_unReadCount);
        AppMethodBeat.o(34419);
        return;
        paramAdapterView = locald.aek();
      }
    }
    this.AkO.ui.startChatting(localak.field_username, null, true);
    EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.AkO, f.rS(localak.field_username), 1, localak.field_unReadCount);
    AppMethodBeat.o(34419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.3
 * JD-Core Version:    0.7.0.1
 */