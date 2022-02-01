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
import com.tencent.mm.ba.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ac;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ac.class)
public class ak
  extends a
  implements b.b, ac
{
  private com.tencent.mm.ui.chatting.n.a Gxk;
  private com.tencent.mm.ui.chatting.n.b Gxl;
  private com.tencent.mm.ui.chatting.n.c Gxm;
  private com.tencent.mm.plugin.messenger.c.a Gxn;
  private l contextMenuHelper;
  
  private void a(final View paramView, com.tencent.mm.ui.chatting.i.a parama)
  {
    AppMethodBeat.i(35514);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FjU, Boolean.FALSE);
    final bl localbl = parama.drF;
    if (ce.asR() - parama.GFp >= 300000L)
    {
      ad.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      com.tencent.mm.ui.base.h.c(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131760419), this.cOd.GzJ.getMMResources().getString(2131755906), true);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35509);
          ad.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(localbl.field_msgId) });
          v.a(ak.this.cOd.GzJ.getMMResources().getString(2131757292), "", localbl, "");
          az.arV();
          com.tencent.mm.model.c.apO().a(localbl.field_msgId, localbl);
          aq.f(new Runnable()
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
    com.tencent.mm.plugin.report.service.h.vKh.f(15037, new Object[] { Integer.valueOf(1) });
    paramView = (q)this.cOd.be(q.class);
    paramView.eXs().ezs();
    paramView.eXs().Vc(1);
    paramView.eXs().setLastText(paramView.eXs().getLastText() + parama.GFo);
    if (!paramView.eXs().srJ) {
      paramView.eXs().showVKB();
    }
    AppMethodBeat.o(35514);
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.cOd.GzJ.getContext());
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
          ((f)ak.this.cOd.be(f.class)).bj(paramLinkedList);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.aEI(ak.this.cOd.zgX.field_username).U(paramString, ak.this.cOd.zgX.field_username);
          Activity localActivity = ak.this.cOd.GzJ.getContext();
          ak.this.cOd.GzJ.getMMResources().getString(2131755906);
          paramAnonymousMenuItem.a(localActivity, ak.this.cOd.GzJ.getMMResources().getString(2131762604), true, new DialogInterface.OnCancelListener()
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
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, bl parambl)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.cOd.GzJ.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", parambl.field_msgId);
    localIntent.putExtra("msgSvrId", parambl.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.cOd.GzJ.getMMResources().getString(2131755119, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", bt.n(paramLinkedList1, ","));
    localIntent.putExtra("nickname", bt.n(paramLinkedList2, ","));
    localIntent.putExtra("descid", bt.n(paramLinkedList3, ","));
    localIntent.putExtra("appid", bt.n(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", bt.n(paramLinkedList5, ","));
    paramString1 = this.cOd;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.adn(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void bk(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35516);
    if (((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC())
    {
      ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).bh(paramLinkedList);
      AppMethodBeat.o(35516);
      return;
    }
    ((f)this.cOd.be(f.class)).bj(paramLinkedList);
    AppMethodBeat.o(35516);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(191539);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(191539);
  }
  
  public final void a(final View paramView, bl parambl, final com.tencent.mm.ba.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      parambl = (e)parama;
      parama = bt.nullAsNil(parambl.hnY);
      ad.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()) });
      if (parambl.hom == null)
      {
        ad.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD()) || (this.cOd.eZa())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        ad.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        bk(parambl.hom);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, parambl.hom, parambl.dre);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!bt.isNullOrNil(parambl.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambl.url);
        paramView.putExtra("geta8key_username", u.aqG());
        com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ba.d))
    {
      Object localObject = (com.tencent.mm.ba.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.ba.d)localObject).hoj;
        parama = ((com.tencent.mm.ba.d)localObject).hok;
        String str1 = ((com.tencent.mm.ba.d)localObject).hod;
        String str2 = ((com.tencent.mm.ba.d)localObject).dgo;
        LinkedList localLinkedList1 = ((com.tencent.mm.ba.d)localObject).hoe;
        LinkedList localLinkedList2 = ((com.tencent.mm.ba.d)localObject).hoh;
        localObject = ((com.tencent.mm.ba.d)localObject).hoi;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, parambl);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ba.b))
    {
      paramView = (com.tencent.mm.ba.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.hoe);
      ((f)this.cOd.be(f.class)).a(parama, paramView.dgo, parambl);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.i.a))
    {
      az.arV();
      if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FjU, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131760418), this.cOd.GzJ.getMMResources().getString(2131764439), this.cOd.GzJ.getMMResources().getString(2131760315), new DialogInterface.OnClickListener()
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
    if ((parama instanceof com.tencent.mm.ba.c))
    {
      ad.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.cOd.eZa()) && (this.cOd.GzJ.getContext() != null)) {
        if (this.cOd.zgX.evx != 0) {
          break label968;
        }
      }
    }
    label968:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).km(bool);
      parambl = new Intent();
      parambl.putExtra("Chat_User", this.cOd.zgX.field_username);
      parambl.putExtra("RoomInfo_Id", this.cOd.getTalkerUserName());
      parambl.putExtra("Is_Chatroom", this.cOd.eZa());
      parambl.putExtra("fromChatting", true);
      parambl.putExtra("isShowSetMuteAnimation", true);
      parambl.setClass(this.cOd.GzJ.getContext(), ChatroomInfoUI.class);
      paramView = this.cOd.GzJ.getContext();
      parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parambl);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, parambl.adn(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambl.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof br))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWJ();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWK();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.hoj, paramView.hOb, paramView.hOc, paramView.hok, paramView.hod, paramView.dgo, paramView.hoe, paramView.hoh, paramView.hNZ, paramView.hOa, paramView.hoi, parambl);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void az(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(35518);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      bk(paramLinkedList);
    }
    AppMethodBeat.o(35518);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35520);
    super.eQB();
    this.Gxm = new com.tencent.mm.ui.chatting.n.c(this);
    this.Gxl = new com.tencent.mm.ui.chatting.n.b(this);
    this.Gxk = new com.tencent.mm.ui.chatting.n.a(this);
    this.Gxn = new com.tencent.mm.plugin.messenger.c.a(this);
    AppMethodBeat.o(35520);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35521);
    if (this.Gxk != null)
    {
      this.Gxk.release();
      this.Gxk = null;
    }
    if (this.Gxl != null)
    {
      this.Gxl.release();
      this.Gxl = null;
    }
    if (this.Gxm != null)
    {
      this.Gxm.release();
      this.Gxm = null;
    }
    if (this.Gxn != null)
    {
      this.Gxn.release();
      this.Gxn = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak
 * JD-Core Version:    0.7.0.1
 */