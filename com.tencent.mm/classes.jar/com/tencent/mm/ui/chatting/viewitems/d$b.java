package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.File;

final class d$b
{
  private static void a(com.tencent.mm.ui.chatting.c.a parama, Intent paramIntent, bi parambi, String paramString)
  {
    if ((parambi.cvx()) || (e(parambi, paramString)))
    {
      y.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
      com.tencent.mm.ui.base.h.a(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.file_fail_or_clean), parama.vtz.getContext().getString(R.l.app_tip), new d.b.2());
      return;
    }
    parama.startActivity(paramIntent);
  }
  
  static void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi, String paramString)
  {
    Object localObject1 = bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend);
    Intent localIntent = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", (String)localObject1);
    localIntent.putExtra("Retr_MsgFromScene", 2);
    localObject1 = g.a.gp((String)localObject1);
    if ((localObject1 != null) && (19 == ((g.a)localObject1).type))
    {
      localIntent.putExtra("Retr_Msg_Type", 10);
      localIntent.putExtra("Retr_Msg_Id", parambi.field_msgId);
      if ((localObject1 != null) && (((g.a)localObject1).type == 6)) {
        break label461;
      }
      parama.startActivity(localIntent);
    }
    label437:
    label461:
    boolean bool;
    label650:
    label656:
    label693:
    do
    {
      return;
      if ((localObject1 != null) && (24 == ((g.a)localObject1).type))
      {
        localIntent.putExtra("Retr_Msg_Type", 10);
        break;
      }
      if ((localObject1 != null) && (16 == ((g.a)localObject1).type))
      {
        localIntent.putExtra("Retr_Msg_Type", 14);
        break;
      }
      localIntent.putExtra("Retr_Msg_Type", 2);
      Object localObject2 = parambi.field_talker;
      Object localObject3 = u.ij(parambi.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = u.Hc().v((String)localObject3, true);
      ((u.b)localObject3).h("prePublishId", "msg_" + parambi.field_msgSvrId);
      ((u.b)localObject3).h("preUsername", paramString);
      ((u.b)localObject3).h("preChatName", localObject2);
      if ((localObject1 != null) && (((g.a)localObject1).A(com.tencent.mm.ae.a.class) != null))
      {
        ((u.b)localObject3).h("appservicetype", Integer.valueOf(((com.tencent.mm.ae.a)((g.a)localObject1).A(com.tencent.mm.ae.a.class)).dPF));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ae.a)((g.a)localObject1).A(com.tencent.mm.ae.a.class)).dPF);
      }
      if ((localObject1 != null) && (33 == ((g.a)localObject1).type))
      {
        if (!parama.cFE()) {
          break label437;
        }
        ((u.b)localObject3).h("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", parambi.field_talker);
        ((u.b)localObject3).h("sendAppMsgScene", Integer.valueOf(1));
        ((i)com.tencent.mm.kernel.g.r(i.class)).a("adExtStr", (u.b)localObject3, parambi);
        break;
        ((u.b)localObject3).h("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
      localObject3 = ((g.a)localObject1).dQK;
      int i;
      if (((g.a)localObject1).dQz == 1)
      {
        i = 7;
        ((com.tencent.mm.plugin.report.service.h)localObject2).f(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((g.a)localObject1).dQv), Integer.valueOf(2), Long.valueOf((System.currentTimeMillis() - parambi.field_createTime) / 1000L), ((g.a)localObject1).dQw });
        if ((((g.a)localObject1).dQz == 0) && (((g.a)localObject1).dQv <= 26214400)) {
          break label650;
        }
      }
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = l.VX(((g.a)localObject1).bFE);
        if (localObject2 == null) {
          break label693;
        }
        localObject3 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
        if ((!((File)localObject3).exists()) || (((File)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen)) {
          break label656;
        }
        parama.startActivity(localIntent);
        return;
        i = 5;
        break;
      }
      if ((((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset))
      {
        a(parama, localIntent, parambi, ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
        return;
      }
      y.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((g.a)localObject1).dQv), ((g.a)localObject1).dQK, bk.aac(((g.a)localObject1).dQR) });
      if (!bool)
      {
        a(parama, localIntent, parambi, null);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.j.f();
      ((com.tencent.mm.j.f)localObject3).dlP = new d.b.1(parama, localIntent, parambi, (com.tencent.mm.pluginsdk.model.app.b)localObject2);
      ((com.tencent.mm.j.f)localObject3).field_mediaId = c.a("checkExist", bk.UY(), paramString, parambi.field_msgId);
      ((com.tencent.mm.j.f)localObject3).field_fileId = ((g.a)localObject1).dQK;
      ((com.tencent.mm.j.f)localObject3).field_aesKey = ((g.a)localObject1).dQR;
      ((com.tencent.mm.j.f)localObject3).field_filemd5 = ((g.a)localObject1).filemd5;
      ((com.tencent.mm.j.f)localObject3).field_fileType = com.tencent.mm.j.a.dlm;
      ((com.tencent.mm.j.f)localObject3).field_talker = paramString;
      ((com.tencent.mm.j.f)localObject3).field_priority = com.tencent.mm.j.a.dlk;
      ((com.tencent.mm.j.f)localObject3).field_svr_signature = "";
      ((com.tencent.mm.j.f)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject3);
      y.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.j.f)localObject3).field_fileId, ((com.tencent.mm.j.f)localObject3).field_mediaId, bk.aac(((com.tencent.mm.j.f)localObject3).field_aesKey) });
    } while (bool);
    a(parama, localIntent, parambi, null);
  }
  
  static boolean a(Context paramContext, g.a parama)
  {
    if ((parama == null) || (paramContext == null)) {}
    do
    {
      do
      {
        return false;
        if (parama.type == 3) {
          return com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 16L);
        }
        if (parama.type == 4) {
          return com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 8L);
        }
        if (parama.type == 5) {
          return com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 32L);
        }
      } while (parama.type != 6);
      parama = b.a.Vx(parama.dQw);
    } while (parama == null);
    return com.tencent.mm.pluginsdk.model.app.g.m(paramContext, parama.longValue());
  }
  
  public static boolean e(bi parambi, String paramString)
  {
    return (System.currentTimeMillis() - parambi.field_createTime > 259200000L) && ((bk.bl(paramString)) || (!com.tencent.mm.vfs.e.bK(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.b
 * JD-Core Version:    0.7.0.1
 */