package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.l.a.a;
import com.tencent.mm.ui.chatting.l.a.b;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.chatting.b.a.a(cFA=w.class)
public class ac
  extends a
  implements w, a.b
{
  private j contextMenuHelper;
  private com.tencent.mm.ui.chatting.l.c vrA;
  private com.tencent.mm.ui.chatting.l.d vrB;
  private com.tencent.mm.ui.chatting.l.b vrz;
  
  private void a(View paramView, com.tencent.mm.ui.chatting.g.a parama)
  {
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.urz, Boolean.valueOf(false));
    bi localbi = parama.bWO;
    if (System.currentTimeMillis() - parama.vyx >= 300000L)
    {
      y.w("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] it's over time to copy invoke message!");
      com.tencent.mm.ui.base.h.b(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.invoke_message_overtime_tip), this.byx.vtz.getMMResources().getString(R.l.app_tip), true);
      com.tencent.mm.sdk.f.e.post(new ac.2(this, localbi, paramView), "deleteInvokeMsg");
    }
    do
    {
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(15037, new Object[] { Integer.valueOf(1) });
      paramView = (n)this.byx.ac(n.class);
      paramView.cEq().setLastText(paramView.cEq().getLastText() + parama.vyw);
    } while (paramView.cEq().cnF());
    paramView.cEq().showVKB();
  }
  
  private void a(View paramView, LinkedList<String> paramLinkedList, String paramString)
  {
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new j(this.byx.vtz.getContext());
    }
    this.contextMenuHelper.b(paramView, new ac.3(this), new ac.4(this, paramLinkedList, paramString));
  }
  
  private void aF(LinkedList<String> paramLinkedList)
  {
    if (((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG())
    {
      ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).aC(paramLinkedList);
      return;
    }
    ((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).aE(paramLinkedList);
  }
  
  public final void a(View paramView, bi parambi, com.tencent.mm.ax.a parama, int paramInt)
  {
    if ((parama instanceof com.tencent.mm.ax.e))
    {
      parambi = (com.tencent.mm.ax.e)parama;
      parama = bk.pm(parambi.evz);
      y.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()) });
      if (parambi.evN == null) {
        y.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH()) || (this.byx.cFD())) {}
          for (paramInt = 1; paramInt == 0; paramInt = 0)
          {
            y.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
            return;
          }
          if (parama.equals("invite"))
          {
            aF(parambi.evN);
            return;
          }
          if (parama.equals("qrcode"))
          {
            a(paramView, parambi.evN, parambi.bTq);
            return;
          }
        } while ((!parama.equals("webview")) || (bk.bl(parambi.url)));
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambi.url);
        paramView.putExtra("geta8key_username", q.Gj());
        com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
        return;
        if (!(parama instanceof com.tencent.mm.ax.d)) {
          break;
        }
        localObject = (com.tencent.mm.ax.d)parama;
      } while (paramInt != 0);
      paramView = ((com.tencent.mm.ax.d)localObject).evK;
      parama = ((com.tencent.mm.ax.d)localObject).evL;
      String str1 = ((com.tencent.mm.ax.d)localObject).evE;
      String str2 = ((com.tencent.mm.ax.d)localObject).bJY;
      LinkedList localLinkedList1 = ((com.tencent.mm.ax.d)localObject).evF;
      LinkedList localLinkedList2 = ((com.tencent.mm.ax.d)localObject).evI;
      Object localObject = ((com.tencent.mm.ax.d)localObject).evJ;
      Intent localIntent = new Intent(this.byx.vtz.getContext(), SeeAccessVerifyInfoUI.class);
      localIntent.putExtra("msgLocalId", parambi.field_msgId);
      localIntent.putExtra("msgSvrId", parambi.field_msgSvrId);
      localIntent.putExtra("invitertitle", this.byx.vtz.getMMResources().getString(R.l.access_invite_content_title, new Object[] { Integer.valueOf(localLinkedList1.size()) }));
      localIntent.putExtra("inviterusername", paramView);
      localIntent.putExtra("chatroom", str1);
      localIntent.putExtra("invitationreason", parama);
      localIntent.putExtra("ticket", str2);
      localIntent.putExtra("username", bk.c(localLinkedList1, ","));
      localIntent.putExtra("nickname", bk.c(localLinkedList2, ","));
      localIntent.putExtra("headimgurl", bk.c((List)localObject, ","));
      this.byx.startActivity(localIntent);
      return;
      if ((parama instanceof com.tencent.mm.ax.b))
      {
        paramView = (com.tencent.mm.ax.b)parama;
        parama = new ArrayList();
        parama.addAll(paramView.evF);
        ((com.tencent.mm.ui.chatting.b.b.e)this.byx.ac(com.tencent.mm.ui.chatting.b.b.e.class)).a(parama, paramView.bJY, parambi);
        return;
      }
      if ((parama instanceof com.tencent.mm.ui.chatting.g.a))
      {
        au.Hx();
        if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.urz, Boolean.valueOf(true))).booleanValue())
        {
          com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.invoke_edit_tip), this.byx.vtz.getMMResources().getString(R.l.tip_title), this.byx.vtz.getMMResources().getString(R.l.i_know_it), new ac.1(this, paramView, parama));
          return;
        }
        a(paramView, (com.tencent.mm.ui.chatting.g.a)parama);
        return;
      }
      if (!(parama instanceof com.tencent.mm.ax.c)) {
        break;
      }
      y.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
    } while (!this.byx.cFD());
    if (this.byx.pSb.cCy == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)g.r(com.tencent.mm.plugin.expt.roomexpt.d.class)).fG(bool);
      paramView = new Intent();
      paramView.putExtra("Chat_User", this.byx.pSb.field_username);
      paramView.putExtra("RoomInfo_Id", this.byx.getTalkerUserName());
      paramView.putExtra("Is_Chatroom", this.byx.cFD());
      paramView.putExtra("fromChatting", true);
      paramView.putExtra("isShowSetMuteAnimation", true);
      com.tencent.mm.br.d.b(this.byx.vtz.getContext(), "chatroom", ".ui.ChatroomInfoUI", paramView);
      return;
      if (!(parama instanceof bm)) {
        break;
      }
      ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDN();
      return;
    }
  }
  
  public final void a(View paramView, a.a parama)
  {
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.eAl);
    }
  }
  
  public final void aG(LinkedList<String> paramLinkedList)
  {
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      aF(paramLinkedList);
    }
  }
  
  public final void cyN()
  {
    super.cyN();
    this.vrB = new com.tencent.mm.ui.chatting.l.d(this);
    this.vrA = new com.tencent.mm.ui.chatting.l.c(this);
    this.vrz = new com.tencent.mm.ui.chatting.l.b(this);
  }
  
  public final void cyR()
  {
    if (this.vrz != null)
    {
      this.vrz.release();
      this.vrz = null;
    }
    if (this.vrA != null)
    {
      this.vrA.release();
      this.vrA = null;
    }
    if (this.vrB != null)
    {
      this.vrB.release();
      this.vrB = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ac
 * JD-Core Version:    0.7.0.1
 */