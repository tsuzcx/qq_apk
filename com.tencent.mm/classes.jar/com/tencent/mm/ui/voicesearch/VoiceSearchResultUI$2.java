package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;

final class VoiceSearchResultUI$2
  implements AdapterView.OnItemClickListener
{
  VoiceSearchResultUI$2(VoiceSearchResultUI paramVoiceSearchResultUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i;
    Object localObject;
    if (!VoiceSearchResultUI.a(this.wiX))
    {
      paramAdapterView = h.nFQ;
      paramView = new StringBuilder().append(VoiceSearchResultUI.b(this.wiX)).append(",").append(VoiceSearchResultUI.c(this.wiX)).append(",");
      if (VoiceSearchResultUI.d(this.wiX) == null)
      {
        i = 0;
        paramAdapterView.aC(10452, i + "," + paramInt);
      }
    }
    else
    {
      localObject = VoiceSearchResultUI.f(this.wiX).Ij(paramInt);
      paramAdapterView = this.wiX;
      paramView = ((ao)localObject).field_username;
      localObject = ((ad)localObject).Bq();
      if ((paramView != null) && (paramView.length() > 0)) {
        break label146;
      }
    }
    label146:
    label356:
    do
    {
      do
      {
        return;
        i = VoiceSearchResultUI.d(this.wiX).length;
        break;
        y.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + paramView);
        if (paramAdapterView.showType == 3)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("Select_Conv_User", paramView);
          paramAdapterView.setResult(-1, (Intent)localObject);
          paramAdapterView.finish();
          return;
        }
        if ((paramAdapterView.showType != 1) && (!com.tencent.mm.model.s.hV(paramView)) && (!com.tencent.mm.model.s.hl(paramView)) && (!com.tencent.mm.model.s.fn(paramView)) && (!com.tencent.mm.model.s.hi(paramView)) && (!VoiceSearchResultUI.aew((String)localObject))) {
          break label1016;
        }
        if (paramAdapterView.showType != 1) {
          break label356;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramView);
        if (com.tencent.mm.model.s.hi(paramView)) {
          ((Intent)localObject).putExtra("Is_group_card", true);
        }
      } while ((paramView == null) || (paramView.length() <= 0));
      e.a((Intent)localObject, paramView);
      if (paramAdapterView.wiW)
      {
        paramAdapterView.a(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
        paramAdapterView.finish();
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      return;
    } while (paramAdapterView.showType != 2);
    if (bk.bl(paramView))
    {
      y.e("MicroMsg.VoiceSearchResultUI", "username is null " + paramView);
      return;
    }
    if (com.tencent.mm.model.s.hq(paramView))
    {
      if (q.GC())
      {
        paramView = new Intent().putExtra("finish_direct", true);
        d.b(paramAdapterView.mController.uMN, "tmessage", ".ui.TConversationUI", paramView);
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hs(paramView))
    {
      if (q.Gz())
      {
        paramView = new Intent().putExtra("finish_direct", true);
        d.b(paramAdapterView.mController.uMN, "qmessage", ".ui.QConversationUI", paramView);
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hr(paramView))
    {
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hw(paramView))
    {
      MMAppMgr.cancelNotification(paramView);
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.ho(paramView))
    {
      if (q.GM())
      {
        paramAdapterView.a(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hB(paramView))
    {
      if (q.GG())
      {
        paramView = new Intent();
        paramView.putExtra("type", 20);
        d.b(paramAdapterView, "readerapp", ".ui.ReaderAppUI", paramView);
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hJ(paramView))
    {
      if (q.GH())
      {
        paramView = new Intent();
        paramView.putExtra("type", 11);
        d.b(paramAdapterView, "readerapp", ".ui.ReaderAppUI", paramView);
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.ht(paramView))
    {
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hu(paramView))
    {
      if (q.GJ())
      {
        d.b(paramAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if (com.tencent.mm.model.s.hA(paramView))
    {
      if (q.GD())
      {
        paramAdapterView.a(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
        return;
      }
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    if ((com.tencent.mm.model.s.hy(paramView)) || (com.tencent.mm.model.s.hz(paramView)) || (com.tencent.mm.model.s.hv(paramView)) || (com.tencent.mm.model.s.hD(paramView)) || (com.tencent.mm.model.s.hE(paramView)) || (com.tencent.mm.model.s.hp(paramView)) || (com.tencent.mm.model.s.hM(paramView)))
    {
      d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
      return;
    }
    paramAdapterView.a(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
    return;
    label1016:
    paramView = new Intent(paramAdapterView, SearchConversationResultUI.class);
    paramView.putExtra("SearchConversationResult_User", (String)localObject);
    paramAdapterView.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI.2
 * JD-Core Version:    0.7.0.1
 */