package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;

final class VoiceSearchResultUI$2
  implements AdapterView.OnItemClickListener
{
  VoiceSearchResultUI$2(VoiceSearchResultUI paramVoiceSearchResultUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35370);
    if (!VoiceSearchResultUI.a(this.ABP))
    {
      paramAdapterView = h.qsU;
      paramView = new StringBuilder().append(VoiceSearchResultUI.b(this.ABP)).append(",").append(VoiceSearchResultUI.c(this.ABP)).append(",");
      if (VoiceSearchResultUI.d(this.ABP) != null) {
        break label143;
      }
    }
    Object localObject;
    label143:
    for (int i = 0;; i = VoiceSearchResultUI.d(this.ABP).length)
    {
      paramAdapterView.kvStat(10452, i + "," + paramInt);
      localObject = VoiceSearchResultUI.f(this.ABP).QV(paramInt);
      paramAdapterView = this.ABP;
      paramView = ((aq)localObject).field_username;
      localObject = ((ad)localObject).Of();
      if ((paramView != null) && (paramView.length() > 0)) {
        break;
      }
      AppMethodBeat.o(35370);
      return;
    }
    ab.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(paramView)));
    if (paramAdapterView.showType == 3)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Select_Conv_User", paramView);
      paramAdapterView.setResult(-1, (Intent)localObject);
      paramAdapterView.finish();
      AppMethodBeat.o(35370);
      return;
    }
    if ((paramAdapterView.showType == 1) || (t.oE(paramView)) || (t.nU(paramView)) || (t.lA(paramView)) || (t.nR(paramView)) || (VoiceSearchResultUI.avj((String)localObject)))
    {
      if (paramAdapterView.showType == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramView);
        if (t.nR(paramView)) {
          ((Intent)localObject).putExtra("Is_group_card", true);
        }
        if ((paramView != null) && (paramView.length() > 0))
        {
          e.a((Intent)localObject, paramView);
          if (paramAdapterView.ABO)
          {
            paramAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
            paramAdapterView.finish();
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        }
        AppMethodBeat.o(35370);
        return;
      }
      if (paramAdapterView.showType == 2)
      {
        if (bo.isNullOrNil(paramView))
        {
          ab.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(paramView)));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.nZ(paramView))
        {
          if (r.ZH())
          {
            paramView = new Intent().putExtra("finish_direct", true);
            d.b(paramAdapterView.getContext(), "tmessage", ".ui.TConversationUI", paramView);
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.ob(paramView))
        {
          if (r.ZE())
          {
            paramView = new Intent().putExtra("finish_direct", true);
            d.b(paramAdapterView.getContext(), "qmessage", ".ui.QConversationUI", paramView);
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.oa(paramView))
        {
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.of(paramView))
        {
          MMAppMgr.cancelNotification(paramView);
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.nX(paramView))
        {
          if (r.ZQ())
          {
            paramAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.ok(paramView))
        {
          if (r.ZK())
          {
            paramView = new Intent();
            paramView.putExtra("type", 20);
            d.b(paramAdapterView, "readerapp", ".ui.ReaderAppUI", paramView);
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.os(paramView))
        {
          if (r.ZL())
          {
            paramView = new Intent();
            paramView.putExtra("type", 11);
            d.b(paramAdapterView, "readerapp", ".ui.ReaderAppUI", paramView);
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.oc(paramView))
        {
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.od(paramView))
        {
          if (r.ZN())
          {
            d.b(paramAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if (t.oj(paramView))
        {
          if (r.ZI())
          {
            paramAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
            AppMethodBeat.o(35370);
            return;
          }
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        if ((t.oh(paramView)) || (t.oi(paramView)) || (t.oe(paramView)) || (t.om(paramView)) || (t.on(paramView)) || (t.nY(paramView)) || (t.ov(paramView)))
        {
          d.b(paramAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView));
          AppMethodBeat.o(35370);
          return;
        }
        paramAdapterView.startActivity(ChattingUI.class, new Intent().putExtra("Chat_User", paramView).putExtra("finish_direct", true));
        AppMethodBeat.o(35370);
      }
    }
    else
    {
      paramView = new Intent(paramAdapterView, SearchConversationResultUI.class);
      paramView.putExtra("SearchConversationResult_User", (String)localObject);
      paramAdapterView.startActivity(paramView);
    }
    AppMethodBeat.o(35370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.VoiceSearchResultUI.2
 * JD-Core Version:    0.7.0.1
 */