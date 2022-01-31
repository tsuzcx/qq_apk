package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;

final class SearchConversationResultUI$3
  implements AdapterView.OnItemClickListener
{
  SearchConversationResultUI$3(SearchConversationResultUI paramSearchConversationResultUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < SearchConversationResultUI.a(this.wiJ).getHeaderViewsCount()) {
      return;
    }
    paramInt -= SearchConversationResultUI.a(this.wiJ).getHeaderViewsCount();
    paramAdapterView = (ak)SearchConversationResultUI.b(this.wiJ).getItem(paramInt);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + paramInt);
      return;
    }
    y.d("MicroMsg.VoiceSearchResultUI", "username " + paramAdapterView.field_username);
    if (com.tencent.mm.model.s.hq(paramAdapterView.field_username))
    {
      if (q.GC())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.wiJ.mController.uMN, "tmessage", ".ui.TConversationUI", paramAdapterView);
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hs(paramAdapterView.field_username))
    {
      if (q.Gz())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.wiJ.mController.uMN, "qmessage", ".ui.QConversationUI", paramAdapterView);
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hr(paramAdapterView.field_username))
    {
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hw(paramAdapterView.field_username))
    {
      MMAppMgr.cancelNotification(paramAdapterView.field_username);
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.ho(paramAdapterView.field_username))
    {
      if (q.GM())
      {
        SearchConversationResultUI.a(this.wiJ, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hB(paramAdapterView.field_username))
    {
      if (q.GG())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("type", 20);
        d.b(this.wiJ, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hJ(paramAdapterView.field_username))
    {
      if (q.GH())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("type", 11);
        d.b(this.wiJ, "readerapp", ".ui.ReaderAppUI", paramAdapterView);
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.ht(paramAdapterView.field_username))
    {
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hu(paramAdapterView.field_username))
    {
      if (q.GJ())
      {
        paramAdapterView = new Intent().putExtra("finish_direct", true);
        d.b(this.wiJ, "masssend", ".ui.MassSendHistoryUI", paramAdapterView);
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if (com.tencent.mm.model.s.hA(paramAdapterView.field_username))
    {
      if (q.GD())
      {
        SearchConversationResultUI.b(this.wiJ, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
        return;
      }
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    if ((com.tencent.mm.model.s.hy(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hz(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hv(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hD(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hE(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hp(SearchConversationResultUI.c(this.wiJ))) || (com.tencent.mm.model.s.hM(SearchConversationResultUI.c(this.wiJ))))
    {
      d.b(this.wiJ, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      return;
    }
    SearchConversationResultUI.c(this.wiJ, ChattingUI.class, new Intent().putExtra("Chat_User", paramAdapterView.field_username).putExtra("finish_direct", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.SearchConversationResultUI.3
 * JD-Core Version:    0.7.0.1
 */