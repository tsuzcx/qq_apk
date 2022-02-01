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
import com.tencent.mm.ba.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.d.b.a;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ae.class)
public class am
  extends a
  implements b.b, ae
{
  private com.tencent.mm.ui.chatting.o.a JLG;
  private com.tencent.mm.ui.chatting.o.b JLH;
  private com.tencent.mm.ui.chatting.o.d JLI;
  private com.tencent.mm.plugin.messenger.c.a JLJ;
  private com.tencent.mm.ui.chatting.o.c JLK;
  private com.tencent.mm.plugin.selectrecord.d.b JLL;
  private l contextMenuHelper;
  
  private void a(final View paramView, com.tencent.mm.ui.chatting.j.a parama)
  {
    AppMethodBeat.i(35514);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iub, Boolean.FALSE);
    final bu localbu = parama.dBd;
    if (cf.aCL() - parama.JVy >= 300000L)
    {
      ad.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      h.c(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131760419), this.cWM.JOR.getMMResources().getString(2131755906), true);
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35509);
          ad.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[] { Long.valueOf(localbu.field_msgId) });
          v.a(am.this.cWM.JOR.getMMResources().getString(2131757292), "", localbu, "");
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(localbu.field_msgId, localbu);
          aq.f(new Runnable()
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
    com.tencent.mm.plugin.report.service.g.yhR.f(15037, new Object[] { Integer.valueOf(1) });
    paramView = (s)this.cWM.bh(s.class);
    paramView.fDC().fdM();
    paramView.fDC().Zh(1);
    paramView.fDC().setLastText(paramView.fDC().getLastText() + parama.JVx);
    if (!paramView.fDC().uCj) {
      paramView.fDC().showVKB();
    }
    AppMethodBeat.o(35514);
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.cWM.JOR.getContext());
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
          ((f)am.this.cWM.bh(f.class)).b(-1L, paramLinkedList, 0);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.aPF(am.this.cWM.BYG.field_username).X(paramString, am.this.cWM.BYG.field_username);
          Activity localActivity = am.this.cWM.JOR.getContext();
          am.this.cWM.JOR.getMMResources().getString(2131755906);
          paramAnonymousMenuItem.a(localActivity, am.this.cWM.JOR.getMMResources().getString(2131762604), true, new DialogInterface.OnCancelListener()
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
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, bu parambu)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.cWM.JOR.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", parambu.field_msgId);
    localIntent.putExtra("msgSvrId", parambu.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.cWM.JOR.getMMResources().getString(2131755119, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", bt.m(paramLinkedList1, ","));
    localIntent.putExtra("nickname", bt.m(paramLinkedList2, ","));
    localIntent.putExtra("descid", bt.m(paramLinkedList3, ","));
    localIntent.putExtra("appid", bt.m(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", bt.m(paramLinkedList5, ","));
    paramString1 = this.cWM;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.ahp(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void c(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(194056);
    if (((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH())
    {
      ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).bp(paramLinkedList);
      AppMethodBeat.o(194056);
      return;
    }
    ((f)this.cWM.bh(f.class)).b(paramLong, paramLinkedList, paramInt);
    AppMethodBeat.o(194056);
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(194057);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      c(paramLong, paramLinkedList, paramInt);
    }
    AppMethodBeat.o(194057);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(194058);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(194058);
  }
  
  public final void a(final View paramView, bu parambu, final com.tencent.mm.ba.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      parambu = (e)parama;
      parama = bt.nullAsNil(parambu.ihP);
      ad.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()) });
      if (parambu.iid == null)
      {
        ad.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI()) || (this.cWM.fFu())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        ad.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        c(-1L, parambu.iid, 0);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, parambu.iid, parambu.dAD);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!bt.isNullOrNil(parambu.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambu.url);
        paramView.putExtra("geta8key_username", u.aAm());
        com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ba.d))
    {
      Object localObject = (com.tencent.mm.ba.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.ba.d)localObject).iia;
        parama = ((com.tencent.mm.ba.d)localObject).iib;
        String str1 = ((com.tencent.mm.ba.d)localObject).ihU;
        String str2 = ((com.tencent.mm.ba.d)localObject).dpf;
        LinkedList localLinkedList1 = ((com.tencent.mm.ba.d)localObject).ihV;
        LinkedList localLinkedList2 = ((com.tencent.mm.ba.d)localObject).ihY;
        localObject = ((com.tencent.mm.ba.d)localObject).ihZ;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, parambu);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ba.b))
    {
      paramView = (com.tencent.mm.ba.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.ihV);
      ((f)this.cWM.bh(f.class)).a(parama, paramView.dpf, parambu);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.j.a))
    {
      ba.aBQ();
      if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Iub, Boolean.TRUE)).booleanValue())
      {
        h.a(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131760418), this.cWM.JOR.getMMResources().getString(2131764439), this.cWM.JOR.getMMResources().getString(2131760315), new DialogInterface.OnClickListener()
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
    if ((parama instanceof com.tencent.mm.ba.c))
    {
      ad.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.cWM.fFu()) && (this.cWM.JOR.getContext() != null)) {
        if (this.cWM.BYG.ePs != 0) {
          break label972;
        }
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.roomexpt.d.class)).lj(bool);
      parambu = new Intent();
      parambu.putExtra("Chat_User", this.cWM.BYG.field_username);
      parambu.putExtra("RoomInfo_Id", this.cWM.getTalkerUserName());
      parambu.putExtra("Is_Chatroom", this.cWM.fFu());
      parambu.putExtra("fromChatting", true);
      parambu.putExtra("isShowSetMuteAnimation", true);
      parambu.setClass(this.cWM.JOR.getContext(), ChatroomInfoUI.class);
      paramView = this.cWM.JOR.getContext();
      parambu = new com.tencent.mm.hellhoundlib.b.a().bc(parambu);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, parambu.ahp(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambu.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof bs))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCO();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCP();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.iia, paramView.iHU, paramView.iHV, paramView.iib, paramView.ihU, paramView.dpf, paramView.ihV, paramView.ihY, paramView.iHS, paramView.iHT, paramView.ihZ, parambu);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35520);
    super.fwt();
    this.JLI = new com.tencent.mm.ui.chatting.o.d(this);
    this.JLH = new com.tencent.mm.ui.chatting.o.b(this);
    this.JLG = new com.tencent.mm.ui.chatting.o.a(this);
    this.JLJ = new com.tencent.mm.plugin.messenger.c.a(this);
    this.JLK = new com.tencent.mm.ui.chatting.o.c(this);
    this.JLL = new com.tencent.mm.plugin.selectrecord.d.b(this);
    AppMethodBeat.o(35520);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35521);
    if (this.JLG != null)
    {
      this.JLG.release();
      this.JLG = null;
    }
    if (this.JLH != null)
    {
      this.JLH.release();
      this.JLH = null;
    }
    if (this.JLI != null)
    {
      this.JLI.release();
      this.JLI = null;
    }
    if (this.JLJ != null)
    {
      this.JLJ.release();
      this.JLJ = null;
    }
    if (this.JLK != null)
    {
      this.JLK.release();
      this.JLK = null;
    }
    if (this.JLL != null)
    {
      this.JLL.release();
      this.JLL = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.am
 * JD-Core Version:    0.7.0.1
 */