package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.l;
import com.tencent.mm.co.f;
import com.tencent.mm.emoji.a.b.b.b;
import com.tencent.mm.emoji.a.b.b.c;
import com.tencent.mm.emoji.a.b.b.d;
import com.tencent.mm.emoji.a.b.d.b;
import com.tencent.mm.emoji.a.b.e;
import com.tencent.mm.emoji.a.b.e.a;
import com.tencent.mm.emoji.a.b.f.b;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.pluginsdk.ui.chat.m.5;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.c.b.ag;
import d.a.v;
import d.g.b.k;
import d.g.b.v.a;
import java.util.ArrayList;
import java.util.List;

final class t$a
  implements TextWatcher
{
  private boolean GuY = false;
  private List<String> GuZ = null;
  
  private t$a(t paramt) {}
  
  private static boolean fY(String paramString, int paramInt)
  {
    AppMethodBeat.i(35312);
    if ((paramString == null) || (paramInt < 0) || (paramString.length() <= paramInt))
    {
      AppMethodBeat.o(35312);
      return false;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(35312);
      return true;
    }
    AppMethodBeat.o(35312);
    return true;
  }
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(35313);
    ad.i("MicroMsg.ChattingUI.FootComponent", "[onTextChanged]");
    ((ag)this.GuT.cOd.be(ag.class)).YQ(1);
    Object localObject1 = (com.tencent.mm.ui.chatting.c.b.d)this.GuT.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class);
    paramCharSequence = String.valueOf(paramCharSequence);
    Object localObject2 = paramCharSequence.substring(paramInt1, paramInt1 + paramInt3);
    Object localObject3;
    Object localObject4;
    if ((this.GuT.cOd.eZa()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(this.GuT.twb.getLastContent())) && (!this.GuT.twb.CbV))
    {
      this.GuT.twb.setLastContent(paramCharSequence);
      this.GuT.twb.setInsertPos(paramInt1 + 1);
      if (fY(paramCharSequence, paramInt1))
      {
        localObject3 = bt.n(q.rW(this.GuT.cOd.getTalkerUserName()), ",");
        localObject4 = new Intent();
        ((Intent)localObject4).setClass(this.GuT.cOd.GzJ.getContext(), AtSomeoneUI.class);
        ((Intent)localObject4).putExtra("Block_list", u.aqG());
        ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
        ((Intent)localObject4).putExtra("Chat_User", this.GuT.cOd.getTalkerUserName());
        ((Intent)localObject4).putExtra("Add_address_titile", this.GuT.cOd.GzJ.getMMString(2131762574));
        this.GuT.cOd.GzJ.startActivityForResult((Intent)localObject4, 212);
      }
      ((com.tencent.mm.ui.chatting.c.b.af)this.GuT.cOd.be(com.tencent.mm.ui.chatting.c.b.af.class)).F(paramCharSequence, paramInt1, (String)localObject2);
      if (!((com.tencent.mm.ui.chatting.c.b.d)localObject1).eWC())
      {
        localObject2 = this.GuT.twb;
        if ((((ChatFooter)localObject2).CbO != null) && (((ChatFooter)localObject2).fPz != null))
        {
          ((ChatFooter)localObject2).CbO.CgC = true;
          localObject1 = ((ChatFooter)localObject2).CbO;
          localObject3 = ((ChatFooter)localObject2).CcF.getTalkerUserName();
          if (!bt.isNullOrNil(paramCharSequence)) {
            break label753;
          }
          ((m)localObject1).mHandler.removeMessages(20003);
          ((m)localObject1).mHandler.sendEmptyMessage(20001);
          ((m)localObject1).ssg = paramCharSequence;
          if (((m)localObject1).CgG != null)
          {
            ((m)localObject1).CgG.dead();
            ((m)localObject1).CgG = null;
          }
        }
      }
    }
    label753:
    Object localObject6;
    for (;;)
    {
      if ((w.pF(this.GuT.cOd.getTalkerUserName())) && (!this.GuT.twb.ezx())) {
        this.GuT.twb.aCd(paramCharSequence);
      }
      AppMethodBeat.o(35313);
      return;
      if ((((com.tencent.mm.ui.chatting.c.b.d)localObject1).eWD()) && ("@".equals(localObject2)) && (!paramCharSequence.equals(this.GuT.twb.getLastContent())) && (!this.GuT.twb.CbV))
      {
        this.GuT.twb.setLastContent(paramCharSequence);
        this.GuT.twb.setInsertPos(paramInt1 + 1);
        if (!fY(paramCharSequence, paramInt1)) {
          break;
        }
        localObject3 = ((com.tencent.mm.ui.chatting.c.b.d)localObject1).eWA().field_userList;
        localObject4 = new Intent();
        ((Intent)localObject4).setClass(this.GuT.cOd.GzJ.getContext(), BizChatAtSomeoneUI.class);
        ((Intent)localObject4).putExtra("Block_list", com.tencent.mm.am.af.awi().eb(this.GuT.cOd.getTalkerUserName()));
        ((Intent)localObject4).putExtra("Chatroom_member_list", (String)localObject3);
        ((Intent)localObject4).putExtra("Chat_User", this.GuT.cOd.getTalkerUserName());
        ((Intent)localObject4).putExtra("Add_address_titile", this.GuT.cOd.GzJ.getMMString(2131762574));
        ((Intent)localObject4).putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d)this.GuT.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWP());
        this.GuT.cOd.GzJ.startActivityForResult((Intent)localObject4, 212);
        break;
      }
      if (paramCharSequence.equals(this.GuT.twb.getLastContent())) {
        break;
      }
      this.GuT.twb.setLastContent(paramCharSequence);
      break;
      if (!paramCharSequence.equals(((m)localObject1).ssg))
      {
        if (((m)localObject1).CgG != null)
        {
          ((m)localObject1).CgG.dead();
          ((m)localObject1).CgG = null;
        }
        ((m)localObject1).CgG = new com.tencent.mm.vending.e.c();
        localObject4 = String.valueOf(bt.eGO());
        localObject2 = ((m)localObject1).CgH;
        ((du)localObject2).dHr = ((du)localObject2).t("SessionId", (String)localObject4, true);
        ((m)localObject1).CgE.clear();
        ((m)localObject1).CgI = 0;
        localObject2 = new com.tencent.mm.emoji.a.b.b(((m)localObject1).CgG);
        k.h(localObject4, "sessionId");
        Object localObject5 = ((com.tencent.mm.emoji.a.b.b)localObject2).fOK;
        k.h(localObject4, "sessionId");
        ((e)localObject5).username = ((String)localObject3);
        ((e)localObject5).sessionId = ((String)localObject4);
        localObject3 = new m.5((m)localObject1);
        k.h(paramCharSequence, "content");
        localObject4 = new v.a();
        ((v.a)localObject4).Jhs = false;
        localObject5 = new Object();
        localObject6 = new v.a();
        ((v.a)localObject6).Jhs = false;
        Object localObject7 = new v.a();
        ((v.a)localObject7).Jhs = false;
        bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poG, false);
        ad.i(com.tencent.mm.emoji.a.b.g.abb(), "searchSuggest: start, remote ".concat(String.valueOf(bool)));
        localObject9 = new b.d((com.tencent.mm.emoji.a.b.b)localObject2, localObject5, (v.a)localObject6, (v.a)localObject4, (v.a)localObject7, (f.b)localObject3);
        localObject7 = new b.c((com.tencent.mm.emoji.a.b.b)localObject2, localObject5, (v.a)localObject7, (v.a)localObject6, (v.a)localObject4, (f.b)localObject3);
        if (bool) {
          break label1167;
        }
        ((v.a)localObject6).Jhs = true;
        bool = false;
        localObject6 = ((com.tencent.mm.emoji.a.b.b)localObject2).fOJ;
        localObject7 = (f.b)localObject7;
        k.h(paramCharSequence, "content");
        com.tencent.mm.ad.c.b("EmojiSuggestLocal_searchSuggest", (d.g.a.a)new d.b((com.tencent.mm.emoji.a.b.d)localObject6, paramCharSequence, (f.b)localObject7));
        if (bool)
        {
          long l = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poF, 500L);
          h.Iye.q((Runnable)new b.b((com.tencent.mm.emoji.a.b.b)localObject2, localObject5, (v.a)localObject4, (f.b)localObject3), l);
        }
      }
      ((m)localObject1).ssg = paramCharSequence;
    }
    label1167:
    Object localObject8 = ((com.tencent.mm.emoji.a.b.b)localObject2).fOK;
    Object localObject9 = (f.b)localObject9;
    k.h(paramCharSequence, "content");
    Object localObject10 = com.tencent.mm.emoji.a.b.c.fOU;
    boolean bool = com.tencent.mm.emoji.a.b.c.pW(paramCharSequence);
    ad.i(((e)localObject8).TAG, "searchSuggest: word match ".concat(String.valueOf(bool)));
    if (bool)
    {
      localObject10 = new cht();
      ((cht)localObject10).CLI = paramCharSequence;
      ((cht)localObject10).Edl = ((e)localObject8).username;
      ((cht)localObject10).CzY = ((e)localObject8).sessionId;
      ((cht)localObject10).Scene = 4;
      localObject9 = new com.tencent.mm.emoji.a.b((cht)localObject10).auK().g((com.tencent.mm.vending.c.a)new e.a((e)localObject8, (f.b)localObject9));
      localObject8 = ((e)localObject8).fOI;
      if (localObject8 != null) {
        ((com.tencent.mm.vending.e.b)localObject8).keep((com.tencent.mm.vending.e.a)localObject9);
      }
    }
    for (;;)
    {
      if (!bool) {
        ((v.a)localObject6).Jhs = true;
      }
      break;
      ((f.b)localObject9).ac((List)v.Jgl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.a
 * JD-Core Version:    0.7.0.1
 */