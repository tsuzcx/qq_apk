package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.n;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.messenger.d.b.a;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.ae.class)
public class am
  extends a
  implements b.b, com.tencent.mm.ui.chatting.d.b.ae
{
  private com.tencent.mm.ui.chatting.o.a KgC;
  private com.tencent.mm.ui.chatting.o.b KgD;
  private com.tencent.mm.ui.chatting.o.d KgE;
  private com.tencent.mm.plugin.messenger.c.a KgF;
  private com.tencent.mm.ui.chatting.o.c KgG;
  private com.tencent.mm.plugin.selectrecord.e.b KgH;
  private l contextMenuHelper;
  
  private void a(final View paramView, com.tencent.mm.ui.chatting.j.a parama)
  {
    AppMethodBeat.i(35514);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IOy, Boolean.FALSE);
    final bv localbv = parama.dCi;
    if (ch.aDb() - parama.KrQ >= 300000L)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      h.c(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131760419), this.cXJ.Kkd.getMMResources().getString(2131755906), true);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35509);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(localbv.field_msgId) });
          w.a(am.this.cXJ.Kkd.getMMResources().getString(2131757292), "", localbv, "");
          bc.aCg();
          com.tencent.mm.model.c.azI().a(localbv.field_msgId, localbv);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35508);
              am.2.this.val$view.invalidate();
              AppMethodBeat.o(35508);
            }
          });
          AppMethodBeat.o(35509);
        }
      }, "deleteInvokeMsg");
      AppMethodBeat.o(35514);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(15037, new Object[] { Integer.valueOf(1) });
    paramView = (s)this.cXJ.bh(s.class);
    paramView.fHF().fhB();
    paramView.fHF().ZN(1);
    paramView.fHF().setLastText(paramView.fHF().getLastText() + parama.KrP);
    if (!paramView.fHF().uNO) {
      paramView.fHF().showVKB();
    }
    AppMethodBeat.o(35514);
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.cXJ.Kkd.getContext());
    }
    this.contextMenuHelper.b(paramView, new View.OnCreateContextMenuListener()new n.e
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(35510);
        paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView.getContext().getString(2131762609));
        paramAnonymousContextMenu.add(0, 1, 1, paramAnonymousView.getContext().getString(2131762601));
        AppMethodBeat.o(35510);
      }
    }, new n.e()
    {
      public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(35512);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(35512);
          return;
          ((f)am.this.cXJ.bh(f.class)).b(-1L, paramLinkedList, 0);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.aRc(am.this.cXJ.Cqh.field_username).X(paramString, am.this.cXJ.Cqh.field_username);
          Activity localActivity = am.this.cXJ.Kkd.getContext();
          am.this.cXJ.Kkd.getMMResources().getString(2131755906);
          paramAnonymousMenuItem.a(localActivity, am.this.cXJ.Kkd.getMMResources().getString(2131762604), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(35511);
              paramAnonymousMenuItem.cancel();
              AppMethodBeat.o(35511);
            }
          });
        }
      }
    });
    AppMethodBeat.o(35515);
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, bv parambv)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.cXJ.Kkd.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", parambv.field_msgId);
    localIntent.putExtra("msgSvrId", parambv.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.cXJ.Kkd.getMMResources().getString(2131755119, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", com.tencent.mm.sdk.platformtools.bu.m(paramLinkedList1, ","));
    localIntent.putExtra("nickname", com.tencent.mm.sdk.platformtools.bu.m(paramLinkedList2, ","));
    localIntent.putExtra("descid", com.tencent.mm.sdk.platformtools.bu.m(paramLinkedList3, ","));
    localIntent.putExtra("appid", com.tencent.mm.sdk.platformtools.bu.m(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", com.tencent.mm.sdk.platformtools.bu.m(paramLinkedList5, ","));
    paramString1 = this.cXJ;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.ahE(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void c(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(187365);
    if (((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ())
    {
      ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).bq(paramLinkedList);
      AppMethodBeat.o(187365);
      return;
    }
    ((f)this.cXJ.bh(f.class)).b(paramLong, paramLinkedList, paramInt);
    AppMethodBeat.o(187365);
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(187366);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      c(paramLong, paramLinkedList, paramInt);
    }
    AppMethodBeat.o(187366);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(187367);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(187367);
  }
  
  public final void a(final View paramView, bv parambv, final com.tencent.mm.az.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      parambv = (e)parama;
      parama = com.tencent.mm.sdk.platformtools.bu.nullAsNil(parambv.ikI);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()) });
      if (parambv.ikW == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK()) || (this.cXJ.fJB())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        c(-1L, parambv.ikW, 0);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, parambv.ikW, parambv.dBI);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(parambv.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambv.url);
        paramView.putExtra("geta8key_username", v.aAC());
        com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.d))
    {
      Object localObject = (com.tencent.mm.az.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.az.d)localObject).ikT;
        parama = ((com.tencent.mm.az.d)localObject).ikU;
        String str1 = ((com.tencent.mm.az.d)localObject).ikN;
        String str2 = ((com.tencent.mm.az.d)localObject).dqk;
        LinkedList localLinkedList1 = ((com.tencent.mm.az.d)localObject).ikO;
        LinkedList localLinkedList2 = ((com.tencent.mm.az.d)localObject).ikR;
        localObject = ((com.tencent.mm.az.d)localObject).ikS;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, parambv);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.b))
    {
      paramView = (com.tencent.mm.az.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.ikO);
      ((f)this.cXJ.bh(f.class)).a(parama, paramView.dqk, parambv);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.j.a))
    {
      bc.aCg();
      if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IOy, Boolean.TRUE)).booleanValue())
      {
        h.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131760418), this.cXJ.Kkd.getMMResources().getString(2131764439), this.cXJ.Kkd.getMMResources().getString(2131760315), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35507);
            am.a(am.this, paramView, (com.tencent.mm.ui.chatting.j.a)parama);
            AppMethodBeat.o(35507);
          }
        });
        AppMethodBeat.o(35513);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.j.a)parama);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.c))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.cXJ.fJB()) && (this.cXJ.Kkd.getContext() != null)) {
        if (this.cXJ.Cqh.eRd != 0) {
          break label972;
        }
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).lj(bool);
      parambv = new Intent();
      parambv.putExtra("Chat_User", this.cXJ.Cqh.field_username);
      parambv.putExtra("RoomInfo_Id", this.cXJ.getTalkerUserName());
      parambv.putExtra("Is_Chatroom", this.cXJ.fJB());
      parambv.putExtra("fromChatting", true);
      parambv.putExtra("isShowSetMuteAnimation", true);
      parambv.setClass(this.cXJ.Kkd.getContext(), ChatroomInfoUI.class);
      paramView = this.cXJ.Kkd.getContext();
      parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parambv);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, parambv.ahE(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambv.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof com.tencent.mm.model.bu))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGQ();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGR();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.ikT, paramView.iKN, paramView.iKO, paramView.ikU, paramView.ikN, paramView.dqk, paramView.ikO, paramView.ikR, paramView.iKL, paramView.iKM, paramView.ikS, parambv);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35520);
    super.fAt();
    this.KgE = new com.tencent.mm.ui.chatting.o.d(this);
    this.KgD = new com.tencent.mm.ui.chatting.o.b(this);
    this.KgC = new com.tencent.mm.ui.chatting.o.a(this);
    this.KgF = new com.tencent.mm.plugin.messenger.c.a(this);
    this.KgG = new com.tencent.mm.ui.chatting.o.c(this);
    this.KgH = new com.tencent.mm.plugin.selectrecord.e.b(this);
    AppMethodBeat.o(35520);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35521);
    if (this.KgC != null)
    {
      this.KgC.release();
      this.KgC = null;
    }
    if (this.KgD != null)
    {
      this.KgD.release();
      this.KgD = null;
    }
    if (this.KgE != null)
    {
      this.KgE.release();
      this.KgE = null;
    }
    if (this.KgF != null)
    {
      this.KgF.release();
      this.KgF = null;
    }
    if (this.KgG != null)
    {
      this.KgG.release();
      this.KgG = null;
    }
    if (this.KgH != null)
    {
      this.KgH.release();
      this.KgH = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.am
 * JD-Core Version:    0.7.0.1
 */