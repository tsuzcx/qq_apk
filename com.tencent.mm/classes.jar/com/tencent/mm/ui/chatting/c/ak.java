package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.br;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.n;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.d.b.a;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.ac.class)
public class ak
  extends a
  implements b.b, com.tencent.mm.ui.chatting.c.b.ac
{
  private com.tencent.mm.ui.chatting.n.a HXb;
  private com.tencent.mm.ui.chatting.n.b HXc;
  private com.tencent.mm.ui.chatting.n.c HXd;
  private com.tencent.mm.plugin.messenger.c.a HXe;
  private l contextMenuHelper;
  
  private void a(final View paramView, com.tencent.mm.ui.chatting.i.a parama)
  {
    AppMethodBeat.i(35514);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GHJ, Boolean.FALSE);
    final bo localbo = parama.dpq;
    if (ce.azI() - parama.Ifl >= 300000L)
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      com.tencent.mm.ui.base.h.c(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131760419), this.cLy.HZF.getMMResources().getString(2131755906), true);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35509);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(localbo.field_msgId) });
          v.a(ak.this.cLy.HZF.getMMResources().getString(2131757292), "", localbo, "");
          az.ayM();
          com.tencent.mm.model.c.awD().a(localbo.field_msgId, localbo);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(35508);
              ak.2.this.val$view.invalidate();
              AppMethodBeat.o(35508);
            }
          });
          AppMethodBeat.o(35509);
        }
      }, "deleteInvokeMsg");
      AppMethodBeat.o(35514);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(15037, new Object[] { Integer.valueOf(1) });
    paramView = (q)this.cLy.bf(q.class);
    paramView.fne().eOM();
    paramView.fne().Xl(1);
    paramView.fne().setLastText(paramView.fne().getLastText() + parama.Ifk);
    if (!paramView.fne().tzA) {
      paramView.fne().showVKB();
    }
    AppMethodBeat.o(35514);
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.cLy.HZF.getContext());
    }
    this.contextMenuHelper.b(paramView, new View.OnCreateContextMenuListener()new n.d
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(35510);
        paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView.getContext().getString(2131762609));
        paramAnonymousContextMenu.add(0, 1, 1, paramAnonymousView.getContext().getString(2131762601));
        AppMethodBeat.o(35510);
      }
    }, new n.d()
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
          ((f)ak.this.cLy.bf(f.class)).bq(paramLinkedList);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.aJZ(ak.this.cLy.AzG.field_username).V(paramString, ak.this.cLy.AzG.field_username);
          Activity localActivity = ak.this.cLy.HZF.getContext();
          ak.this.cLy.HZF.getMMResources().getString(2131755906);
          paramAnonymousMenuItem.a(localActivity, ak.this.cLy.HZF.getMMResources().getString(2131762604), true, new DialogInterface.OnCancelListener()
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
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, bo parambo)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.cLy.HZF.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", parambo.field_msgId);
    localIntent.putExtra("msgSvrId", parambo.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.cLy.HZF.getMMResources().getString(2131755119, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", bs.n(paramLinkedList1, ","));
    localIntent.putExtra("nickname", bs.n(paramLinkedList2, ","));
    localIntent.putExtra("descid", bs.n(paramLinkedList3, ","));
    localIntent.putExtra("appid", bs.n(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", bs.n(paramLinkedList5, ","));
    paramString1 = this.cLy;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.aeD(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void br(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35516);
    if (((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo())
    {
      ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).bo(paramLinkedList);
      AppMethodBeat.o(35516);
      return;
    }
    ((f)this.cLy.bf(f.class)).bq(paramLinkedList);
    AppMethodBeat.o(35516);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(196509);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(196509);
  }
  
  public final void a(final View paramView, bo parambo, final com.tencent.mm.az.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      parambo = (e)parama;
      parama = bs.nullAsNil(parambo.hOB);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo()) });
      if (parambo.hOP == null)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp()) || (this.cLy.foP())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        br(parambo.hOP);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, parambo.hOP, parambo.doP);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!bs.isNullOrNil(parambo.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambo.url);
        paramView.putExtra("geta8key_username", u.axw());
        com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.d))
    {
      Object localObject = (com.tencent.mm.az.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.az.d)localObject).hOM;
        parama = ((com.tencent.mm.az.d)localObject).hON;
        String str1 = ((com.tencent.mm.az.d)localObject).hOG;
        String str2 = ((com.tencent.mm.az.d)localObject).ddJ;
        LinkedList localLinkedList1 = ((com.tencent.mm.az.d)localObject).hOH;
        LinkedList localLinkedList2 = ((com.tencent.mm.az.d)localObject).hOK;
        localObject = ((com.tencent.mm.az.d)localObject).hOL;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, parambo);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.b))
    {
      paramView = (com.tencent.mm.az.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.hOH);
      ((f)this.cLy.bf(f.class)).a(parama, paramView.ddJ, parambo);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.i.a))
    {
      az.ayM();
      if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GHJ, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131760418), this.cLy.HZF.getMMResources().getString(2131764439), this.cLy.HZF.getMMResources().getString(2131760315), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35507);
            ak.a(ak.this, paramView, (com.tencent.mm.ui.chatting.i.a)parama);
            AppMethodBeat.o(35507);
          }
        });
        AppMethodBeat.o(35513);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.i.a)parama);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.c))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.cLy.foP()) && (this.cLy.HZF.getContext() != null)) {
        if (this.cLy.AzG.exT != 0) {
          break label968;
        }
      }
    }
    label968:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).kQ(bool);
      parambo = new Intent();
      parambo.putExtra("Chat_User", this.cLy.AzG.field_username);
      parambo.putExtra("RoomInfo_Id", this.cLy.getTalkerUserName());
      parambo.putExtra("Is_Chatroom", this.cLy.foP());
      parambo.putExtra("fromChatting", true);
      parambo.putExtra("isShowSetMuteAnimation", true);
      parambo.setClass(this.cLy.HZF.getContext(), ChatroomInfoUI.class);
      paramView = this.cLy.HZF.getContext();
      parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parambo);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, parambo.aeD(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambo.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof br))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmv();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmw();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.hOM, paramView.iox, paramView.ioy, paramView.hON, paramView.hOG, paramView.ddJ, paramView.hOH, paramView.hOK, paramView.iov, paramView.iow, paramView.hOL, parambo);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void aG(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35518);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      br(paramLinkedList);
    }
    AppMethodBeat.o(35518);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35520);
    super.fgh();
    this.HXd = new com.tencent.mm.ui.chatting.n.c(this);
    this.HXc = new com.tencent.mm.ui.chatting.n.b(this);
    this.HXb = new com.tencent.mm.ui.chatting.n.a(this);
    this.HXe = new com.tencent.mm.plugin.messenger.c.a(this);
    AppMethodBeat.o(35520);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35521);
    if (this.HXb != null)
    {
      this.HXb.release();
      this.HXb = null;
    }
    if (this.HXc != null)
    {
      this.HXc.release();
      this.HXc = null;
    }
    if (this.HXd != null)
    {
      this.HXd.release();
      this.HXd = null;
    }
    if (this.HXe != null)
    {
      this.HXe.release();
      this.HXe = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak
 * JD-Core Version:    0.7.0.1
 */