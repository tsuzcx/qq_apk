package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;

final class SearchConversationResultUI$3
  implements AdapterView.OnItemClickListener
{
  SearchConversationResultUI$3(SearchConversationResultUI paramSearchConversationResultUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35317);
    if (paramInt < SearchConversationResultUI.a(this.ABB).getHeaderViewsCount())
    {
      AppMethodBeat.o(35317);
      return;
    }
    paramInt -= SearchConversationResultUI.a(this.ABB).getHeaderViewsCount();
    paramAdapterView = (ak)SearchConversationResultUI.b(this.ABB).getItem(paramInt);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(35317);
      return;
    }
    ab.d("MicroMsg.VoiceSearchResultUI", "username " + paramAdapterView.field_username);
    if (t.nZ(paramAdapterView.field_username))
    {
      if (r.ZH())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.ABB.getContext(), "tmessage", ".ui.TConversationUI", paramAdapterView);
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.ob(paramAdapterView.field_username))
    {
      if (r.ZE())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.ABB.getContext(), "qmessage", ".ui.QConversationUI", paramAdapterView);
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.oa(paramAdapterView.field_username))
    {
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.of(paramAdapterView.field_username))
    {
      MMAppMgr.cancelNotification(paramAdapterView.field_username);
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.nX(paramAdapterView.field_username))
    {
      if (r.ZQ())
      {
        SearchConversationResultUI.a(this.ABB, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.ok(paramAdapterView.field_username))
    {
      if (r.ZK())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("type", 20);
        d.b(this.ABB, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.os(paramAdapterView.field_username))
    {
      if (r.ZL())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("type", 11);
        d.b(this.ABB, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.oc(paramAdapterView.field_username))
    {
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.od(paramAdapterView.field_username))
    {
      if (r.ZN())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.ABB, "masssend", ".ui.MassSendHistoryUI", paramAdapterView);
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if (t.oj(paramAdapterView.field_username))
    {
      if (r.ZI())
      {
        SearchConversationResultUI.b(this.ABB, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
        AppMethodBeat.o(35317);
        return;
      }
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    if ((t.oh(SearchConversationResultUI.c(this.ABB))) || (t.oi(SearchConversationResultUI.c(this.ABB))) || (t.oe(SearchConversationResultUI.c(this.ABB))) || (t.om(SearchConversationResultUI.c(this.ABB))) || (t.on(SearchConversationResultUI.c(this.ABB))) || (t.nY(SearchConversationResultUI.c(this.ABB))) || (t.ov(SearchConversationResultUI.c(this.ABB))))
    {
      d.b(this.ABB, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      AppMethodBeat.o(35317);
      return;
    }
    SearchConversationResultUI.c(this.ABB, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
    AppMethodBeat.o(35317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI.3
 * JD-Core Version:    0.7.0.1
 */