package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.as.g;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  private static com.tencent.mm.ui.base.p vja = null;
  private static n.a vjw;
  
  public static void a(com.tencent.mm.ui.chatting.c.a parama, String paramString, long paramLong)
  {
    Activity localActivity = parama.vtz.getContext();
    if ((!ah.bl(paramString)) && (paramString.length() > 0))
    {
      localActivity.getString(R.l.app_tip);
      vja = com.tencent.mm.ui.base.h.b(localActivity, localActivity.getString(R.l.sending_message), false, null);
      com.tencent.mm.ui.chatting.b.j.vpo.c(new n.b(parama, localActivity, paramString, paramLong, vjw));
    }
    ((com.tencent.mm.ui.chatting.b.b.h)parama.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEf();
  }
  
  public static void a(final com.tencent.mm.ui.chatting.c.a parama, List<bi> paramList, boolean paramBoolean, final com.tencent.mm.ui.chatting.b.j paramj, final ad paramad)
  {
    if (parama == null) {
      y.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
    }
    final Activity localActivity;
    do
    {
      return;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        y.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        return;
      }
      localObject = new n.a((byte)0);
      vjw = (n.a)localObject;
      ((n.a)localObject).vju = new LinkedList(paramList);
      vjw.vgB = paramBoolean;
      vjw.bWQ = paramad.field_username;
      vjw.vjD = true;
      localActivity = parama.vtz.getContext();
    } while (localActivity == null);
    com.tencent.mm.ui.tools.j localj = new com.tencent.mm.ui.tools.j(localActivity);
    localj.wdr = new n.1();
    localj.wds = new n.2(localActivity);
    if (com.tencent.mm.pluginsdk.model.app.p.o(localActivity, "com.tencent.wework")) {}
    for (Object localObject = k.cCy();; localObject = k.cCx())
    {
      localj.phH = new n.c()
      {
        public final void a(l paramAnonymousl)
        {
          paramAnonymousl.ak(1193046, R.l.menu_item_email, R.g.chat_more_email_btn);
          Iterator localIterator = this.vjx.iterator();
          while (localIterator.hasNext()) {
            paramAnonymousl.add((String)localIterator.next());
          }
        }
      };
      localj.phI = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (k.dR(this.vjn)) {
              com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_remuxing_msg), "", localActivity.getString(R.l.I_known), new n.4.1(this));
            }
            do
            {
              return;
              if (k.dS(this.vjn))
              {
                com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_shortvideo_msg), "", localActivity.getString(R.l.I_known), new n.4.2(this));
                return;
              }
              if (k.dQ(this.vjn))
              {
                com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_undownload_msg), "", new n.4.3(this), null);
                return;
              }
            } while ((!o.a(parama, this.vjn, paramad)) || (paramj == null));
            paramj.cEf();
            return;
          }
          if (k.dR(this.vjn))
          {
            com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_remuxing_msg), "", localActivity.getString(R.l.I_known), new n.4.4(this));
            return;
          }
          if (k.dS(this.vjn))
          {
            com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_shortvideo_msg), "", localActivity.getString(R.l.I_known), new n.4.5(this));
            return;
          }
          Object localObject = this.vjn;
          if (localObject == null)
          {
            y.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            label295:
            break label350;
            break label350;
          }
          label298:
          label350:
          bi localbi;
          do
          {
            Iterator localIterator;
            do
            {
              paramAnonymousInt = 0;
              if ((paramAnonymousInt == 0) && (!k.dQ(this.vjn))) {
                break;
              }
              com.tencent.mm.ui.base.h.a(localActivity, localActivity.getString(R.l.contain_undownload_msg), "", new n.4.6(this), null);
              return;
              localIterator = ((List)localObject).iterator();
            } while (!localIterator.hasNext());
            localbi = (bi)localIterator.next();
          } while (localbi.field_isSend == 1);
          if (localbi.ctB()) {
            if (localbi.field_msgId <= 0L) {
              break label826;
            }
          }
          label824:
          label826:
          for (localObject = com.tencent.mm.as.o.OJ().bY(localbi.field_msgId);; localObject = null)
          {
            if (((localObject == null) || (((com.tencent.mm.as.e)localObject).enp <= 0L)) && (localbi.field_msgSvrId > 0L)) {
              localObject = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.as.e)localObject).offset >= ((com.tencent.mm.as.e)localObject).ebK) && (((com.tencent.mm.as.e)localObject).ebK != 0))) {
                break label824;
              }
              paramAnonymousInt = 1;
              break label298;
              if (localbi.aRQ())
              {
                localObject = com.tencent.mm.modelvideo.o.Sr().nQ(localbi.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break label295;
                }
                paramAnonymousInt = 1;
                break label298;
              }
              if (localbi.aRR())
              {
                localObject = u.oe(localbi.field_imgPath);
                if ((localObject == null) || (((s)localObject).status == 199) || (((s)localObject).status == 199)) {
                  break label295;
                }
                paramAnonymousInt = 1;
                break label298;
              }
              if (!localbi.cvp()) {
                break label295;
              }
              if (!k.ap(localbi))
              {
                paramAnonymousInt = 1;
                break label298;
              }
              paramAnonymousInt = 0;
              break label298;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (f.la((String)localObject))
              {
                if (this.vjn.size() <= 1)
                {
                  n.cCB().vjD = true;
                  n.a((String)localObject, parama, this.vjn);
                  return;
                }
                new com.tencent.mm.ui.tools.j(localActivity).b(paramAnonymousMenuItem.getActionView(), new n.4.7(this), new n.4.8(this, (String)localObject));
                return;
              }
              if (k.dO(this.vjn))
              {
                localObject = localActivity.getString(R.l.invalid_brand_msg_warning);
                com.tencent.mm.ui.base.h.a(localActivity, (String)localObject, "", new n.4.9(this, paramAnonymousMenuItem), null);
                return;
              }
              localObject = localActivity;
              localActivity.getString(R.l.app_tip);
              n.a(com.tencent.mm.ui.base.h.b((Context)localObject, localActivity.getString(R.l.sending_message), false, null));
              com.tencent.mm.ui.chatting.b.j.vpo.c(new n.b(parama, localActivity, paramAnonymousMenuItem.getTitle(), -1L, n.cCB()));
              if (paramj == null) {
                break;
              }
              paramj.cEf();
              return;
            }
            break label350;
          }
        }
      };
      localj.bJQ();
      return;
    }
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.c.a parama)
  {
    Object localObject = f.kX(paramString);
    if (localObject == null) {}
    do
    {
      return;
      if (((com.tencent.mm.ai.d)localObject).LA())
      {
        localObject = new Intent(parama.vtz.getContext(), BizChatSelectConversationUI.class);
        ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
        ((Intent)localObject).putExtra("biz_chat_scene", 2);
        ((Intent)localObject).putExtra("enterprise_extra_params", vjw.vjD);
        parama.a((Intent)localObject, 225, new n.6(parama));
        return;
      }
    } while (!((com.tencent.mm.ai.d)localObject).Ly());
    localObject = new Intent();
    ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
    ((Intent)localObject).putExtra("enterprise_scene", 1);
    com.tencent.mm.br.d.a(parama.vtz, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
  }
  
  public static void a(String paramString, com.tencent.mm.ui.chatting.c.a parama, List<bi> paramList)
  {
    Activity localActivity = parama.vtz.getContext();
    if (localActivity == null) {}
    Object localObject;
    do
    {
      return;
      localObject = f.kX(paramString);
    } while (localObject == null);
    boolean bool1 = ((com.tencent.mm.ai.d)localObject).LA();
    boolean bool2;
    int i;
    if (vjw.vjD)
    {
      bool2 = k.dO(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          y.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          vjw.vju = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label237;
          }
          paramList = localActivity.getString(R.l.enterprise_invalid_chat_msg_warning);
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        com.tencent.mm.ui.base.h.a(localActivity, paramList, "", new n.5(paramString, parama), null);
        return;
        localObject = paramList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            bi localbi = (bi)((Iterator)localObject).next();
            if ((!localbi.isText()) && (!localbi.ctA()) && (!localbi.ctB()) && (!localbi.aVM()) && (!k.aw(localbi)))
            {
              i = 1;
              break;
            }
          }
        }
        i = 0;
        break;
        if (!bool2) {
          break label237;
        }
        paramList = localActivity.getString(R.l.enterprise_invalid_msg_warning);
        continue;
      }
      a(paramString, parama);
      return;
      label237:
      paramList = null;
    }
  }
  
  public static nd bD(Context paramContext, String paramString)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 6;
    localnd.bWJ.bWP = vjw.vju;
    localnd.bWJ.toUser = paramString;
    localnd.bWJ.bWQ = vjw.bWQ;
    localnd.bWJ.context = paramContext;
    com.tencent.mm.sdk.b.a.udP.m(localnd);
    vjw.bWm = localnd.bWK.bWm;
    vjw.vjv = localnd.bWK.bWS;
    return localnd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */