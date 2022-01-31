package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.k;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.x;
import com.tencent.mm.ui.chatting.m.a.a;
import com.tencent.mm.ui.chatting.m.a.b;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(dJy=x.class)
public class ad
  extends a
  implements x, a.b
{
  private l contextMenuHelper;
  private com.tencent.mm.ui.chatting.m.b zHe;
  private com.tencent.mm.ui.chatting.m.c zHf;
  private com.tencent.mm.ui.chatting.m.d zHg;
  
  private void a(View paramView, com.tencent.mm.ui.chatting.h.a parama)
  {
    AppMethodBeat.i(31619);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yBy, Boolean.FALSE);
    bi localbi = parama.cEE;
    if (cb.abq() - parama.zOT >= 300000L)
    {
      ab.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      com.tencent.mm.ui.base.h.b(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131300818), this.caz.zJz.getMMResources().getString(2131297087), true);
      com.tencent.mm.sdk.g.d.post(new ad.2(this, localbi, paramView), "deleteInvokeMsg");
      AppMethodBeat.o(31619);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(15037, new Object[] { Integer.valueOf(1) });
    paramView = (o)this.caz.ay(o.class);
    paramView.dIg().doD();
    paramView.dIg().Mk(1);
    paramView.dIg().setLastText(paramView.dIg().getLastText() + parama.zOS);
    if (!paramView.dIg().vWC) {
      paramView.dIg().showVKB();
    }
    AppMethodBeat.o(31619);
  }
  
  private void a(View paramView, LinkedList<String> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(31620);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.caz.zJz.getContext());
    }
    this.contextMenuHelper.b(paramView, new ad.3(this), new ad.4(this, paramLinkedList, paramString));
    AppMethodBeat.o(31620);
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, bi parambi)
  {
    AppMethodBeat.i(31622);
    Intent localIntent = new Intent(this.caz.zJz.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", parambi.field_msgId);
    localIntent.putExtra("msgSvrId", parambi.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.caz.zJz.getMMResources().getString(2131296393, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", com.tencent.mm.sdk.platformtools.bo.d(paramLinkedList1, ","));
    localIntent.putExtra("nickname", com.tencent.mm.sdk.platformtools.bo.d(paramLinkedList2, ","));
    localIntent.putExtra("descid", com.tencent.mm.sdk.platformtools.bo.d(paramLinkedList3, ","));
    localIntent.putExtra("appid", com.tencent.mm.sdk.platformtools.bo.d(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", com.tencent.mm.sdk.platformtools.bo.d(paramLinkedList5, ","));
    this.caz.startActivity(localIntent);
    AppMethodBeat.o(31622);
  }
  
  private void aP(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(31621);
    if (((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv())
    {
      ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).aM(paramLinkedList);
      AppMethodBeat.o(31621);
      return;
    }
    ((f)this.caz.ay(f.class)).aO(paramLinkedList);
    AppMethodBeat.o(31621);
  }
  
  public final void a(View paramView, bi parambi, com.tencent.mm.ay.a parama, int paramInt)
  {
    AppMethodBeat.i(31618);
    if ((parama instanceof e))
    {
      parambi = (e)parama;
      parama = com.tencent.mm.sdk.platformtools.bo.nullAsNil(parambi.fLm);
      ab.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()) });
      if (parambi.fLA == null)
      {
        ab.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(31618);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw()) || (this.caz.dJF())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        ab.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(31618);
        return;
      }
      if (parama.equals("invite"))
      {
        aP(parambi.fLA);
        AppMethodBeat.o(31618);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, parambi.fLA, parambi.cAV);
        AppMethodBeat.o(31618);
        return;
      }
      if ((parama.equals("webview")) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(parambi.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambi.url);
        paramView.putExtra("geta8key_username", r.Zn());
        com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(31618);
      return;
    }
    if ((parama instanceof com.tencent.mm.ay.d))
    {
      Object localObject = (com.tencent.mm.ay.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.ay.d)localObject).fLx;
        parama = ((com.tencent.mm.ay.d)localObject).fLy;
        String str1 = ((com.tencent.mm.ay.d)localObject).fLr;
        String str2 = ((com.tencent.mm.ay.d)localObject).crs;
        LinkedList localLinkedList1 = ((com.tencent.mm.ay.d)localObject).fLs;
        LinkedList localLinkedList2 = ((com.tencent.mm.ay.d)localObject).fLv;
        localObject = ((com.tencent.mm.ay.d)localObject).fLw;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, parambi);
      }
      AppMethodBeat.o(31618);
      return;
    }
    if ((parama instanceof com.tencent.mm.ay.b))
    {
      paramView = (com.tencent.mm.ay.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.fLs);
      ((f)this.caz.ay(f.class)).a(parama, paramView.crs, parambi);
      AppMethodBeat.o(31618);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.h.a))
    {
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBy, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131300817), this.caz.zJz.getMMResources().getString(2131304313), this.caz.zJz.getMMResources().getString(2131300718), new ad.1(this, paramView, parama));
        AppMethodBeat.o(31618);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.h.a)parama);
      AppMethodBeat.o(31618);
      return;
    }
    if ((parama instanceof com.tencent.mm.ay.c))
    {
      ab.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.caz.dJF()) && (this.caz.zJz.getContext() != null)) {
        if (this.caz.txj.dqK != 0) {
          break label899;
        }
      }
    }
    label899:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)g.E(com.tencent.mm.plugin.expt.roomexpt.d.class)).hj(bool);
      paramView = new Intent();
      paramView.putExtra("Chat_User", this.caz.txj.field_username);
      paramView.putExtra("RoomInfo_Id", this.caz.getTalkerUserName());
      paramView.putExtra("Is_Chatroom", this.caz.dJF());
      paramView.putExtra("fromChatting", true);
      paramView.putExtra("isShowSetMuteAnimation", true);
      paramView.setClass(this.caz.zJz.getContext(), ChatroomInfoUI.class);
      this.caz.zJz.getContext().startActivity(paramView);
      AppMethodBeat.o(31618);
      return;
      if ((parama instanceof com.tencent.mm.model.bo))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHC();
        AppMethodBeat.o(31618);
        return;
      }
      if ((parama instanceof k))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHD();
        AppMethodBeat.o(31618);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.fLx, paramView.ggf, paramView.ggg, paramView.fLy, paramView.fLr, paramView.crs, paramView.fLs, paramView.fLv, paramView.ggd, paramView.gge, paramView.fLw, parambi);
        }
      }
      AppMethodBeat.o(31618);
      return;
    }
  }
  
  public final void a(View paramView, a.a parama)
  {
    AppMethodBeat.i(31624);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(31624);
  }
  
  public final void aQ(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(31623);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      aP(paramLinkedList);
    }
    AppMethodBeat.o(31623);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31625);
    super.dBZ();
    this.zHg = new com.tencent.mm.ui.chatting.m.d(this);
    this.zHf = new com.tencent.mm.ui.chatting.m.c(this);
    this.zHe = new com.tencent.mm.ui.chatting.m.b(this);
    AppMethodBeat.o(31625);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31626);
    if (this.zHe != null)
    {
      this.zHe.release();
      this.zHe = null;
    }
    if (this.zHf != null)
    {
      this.zHf.release();
      this.zHf = null;
    }
    if (this.zHg != null)
    {
      this.zHg.release();
      this.zHg = null;
    }
    AppMethodBeat.o(31626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ad
 * JD-Core Version:    0.7.0.1
 */