package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.j;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.storage.bi;>;

public final class l
{
  private static l.a vjm = new l.a((byte)0);
  
  public static void a(final Context paramContext, List<bi> paramList, final boolean paramBoolean, final String paramString, final aj paramaj)
  {
    
    if (paramContext == null) {
      y.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
    }
    Object localObject1;
    label154:
    int i;
    do
    {
      return;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        y.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        return;
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (!ae.aF((bi)((Iterator)localObject1).next()))
        {
          com.tencent.mm.ui.base.s.makeText(paramContext, R.l.open_im_fail_open_im_withdown_download, 0).show();
          return;
        }
      }
      if (!k.a(paramList, paramaj))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.invalid_friend_msg_warning), "", paramContext.getString(R.l.app_send), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = this.vjn;
            if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
              y.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
            }
            label25:
            for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
            {
              if (paramAnonymousInt == 0) {
                break label177;
              }
              y.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
              if (paramaj != null) {
                paramaj.b(aj.a.vmx);
              }
              return;
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
              if (!paramAnonymousDialogInterface.hasNext()) {
                break label25;
              }
              bi localbi = (bi)paramAnonymousDialogInterface.next();
              if (k.at(localbi)) {
                break label25;
              }
              if ((localbi.ctA()) || (k.ao(localbi)) || (k.aq(localbi)) || (k.az(localbi)) || (k.ar(localbi)) || (localbi.getType() == -1879048186) || (k.ay(localbi)) || (k.as(localbi)) || (k.ax(localbi)) || (k.at(localbi)) || (localbi.getType() == 318767153)) {
                break;
              }
            }
            label177:
            l.c(paramContext, this.vjn, paramBoolean, paramString, paramaj);
          }
        }, null);
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      y.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label229;
      i = 1;
      if (i == 0) {
        break label551;
      }
      y.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
    } while ((paramaj == null) || ((!paramaj.cDf()) && (paramList.size() != 1)));
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.expired_msg_warning), paramContext.getString(R.l.app_tip), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    return;
    Iterator localIterator = paramList.iterator();
    label545:
    label549:
    for (;;)
    {
      label229:
      if (!localIterator.hasNext()) {
        break label154;
      }
      bi localbi = (bi)localIterator.next();
      Object localObject3 = null;
      if (localbi.cvx()) {
        break;
      }
      Object localObject2;
      if (localbi.ctB())
      {
        localObject1 = null;
        if (localbi.field_msgId > 0L) {
          localObject1 = com.tencent.mm.as.o.OJ().bY(localbi.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.as.e)localObject1).enp > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localbi.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c((com.tencent.mm.as.e)localObject2), "", "");
        }
        label368:
        if ((localbi.ctB()) || (localbi.aRQ()) || (localbi.aRR()) || (k.aB(localbi))) {
          if ((System.currentTimeMillis() - localbi.field_createTime <= 259200000L) || ((!bk.bl((String)localObject1)) && (com.tencent.mm.vfs.e.bK((String)localObject1)))) {
            break label545;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label549;
        }
        i = 0;
        break;
        if ((localbi.aRR()) || (localbi.aRQ()))
        {
          com.tencent.mm.modelvideo.o.Sr();
          localObject1 = t.nS(localbi.field_imgPath);
          break label368;
        }
        if (localbi.aVK())
        {
          localObject2 = g.a.gp(localbi.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label368;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.l.VX(((g.a)localObject2).bFE);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label368;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
          break label368;
        }
        localObject1 = localbi.field_imgPath;
        break label368;
      }
    }
    label551:
    b(paramContext, paramList, paramBoolean, paramString, paramaj);
  }
  
  private static void b(Context paramContext, List<bi> paramList, boolean paramBoolean, String paramString, aj paramaj)
  {
    if (k.dR(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.contain_remuxing_msg), "", paramContext.getString(R.l.I_known), new l.3(paramaj));
      return;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bi)((Iterator)localObject1).next();
      if (bf.k((bi)localObject2))
      {
        switch (((bi)localObject2).getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bf.l((bi)localObject2);
          break;
          ((bi)localObject2).setContent(paramContext.getString(R.l.app_text));
          continue;
          ((bi)localObject2).setContent(paramContext.getString(R.l.app_pic));
          ((bi)localObject2).setType(1);
          continue;
          ((bi)localObject2).setContent(paramContext.getString(R.l.app_video));
          ((bi)localObject2).setType(1);
          continue;
          ((bi)localObject2).setContent(paramContext.getString(R.l.app_unknown_msg));
          ((bi)localObject2).setType(1);
        }
      }
    }
    vjm.vju = new LinkedList(paramList);
    vjm.vgB = paramBoolean;
    vjm.vjb = paramaj;
    vjm.bWQ = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    bi localbi;
    int i;
    if (paramList.size() == 1)
    {
      localbi = (bi)paramList.get(0);
      if ((localbi.aVK()) || (localbi.ctz()))
      {
        paramList = com.tencent.mm.model.u.ij(localbi.field_msgSvrId);
        localObject1 = com.tencent.mm.model.u.Hc().v(paramList, true);
        ((u.b)localObject1).h("prePublishId", "msg_" + localbi.field_msgSvrId);
        ((u.b)localObject1).h("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localbi, paramBoolean, false));
        ((u.b)localObject1).h("preChatName", localbi.field_talker);
        ((u.b)localObject1).h("preMsgIndex", Integer.valueOf(0));
        ((u.b)localObject1).h("sendAppMsgScene", Integer.valueOf(1));
        ((u.b)localObject1).h("moreRetrAction", Boolean.valueOf(true));
        if (paramBoolean)
        {
          ((u.b)localObject1).h("fromScene", Integer.valueOf(2));
          ((i)com.tencent.mm.kernel.g.r(i.class)).a("adExtStr", (u.b)localObject1, localbi);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        localObject2 = localbi.field_content;
        i = 12;
        if (!localbi.aVM()) {
          break label657;
        }
        i = 9;
        paramList = (List<bi>)localObject2;
        label506:
        if (!localbi.ctz()) {
          break label1226;
        }
      }
    }
    label553:
    label1226:
    for (int j = 1;; j = 2)
    {
      if ((paramaj != null) && (!paramaj.cDf()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localbi.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
        i = j;
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        paramContext.startActivity(localIntent);
        paramContext = vjm.vju;
        au.DS().O(new m.1(paramContext));
        return;
        ((u.b)localObject1).h("fromScene", Integer.valueOf(1));
        break;
        if (localbi.cvo())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = (List<bi>)localObject2;
          break label506;
        }
        if (localbi.cvn())
        {
          i = 8;
          paramList = (List<bi>)localObject2;
          break label506;
        }
        if (localbi.isText())
        {
          j = 4;
          i = j;
          paramList = (List<bi>)localObject2;
          if (!paramBoolean) {
            break label506;
          }
          i = j;
          paramList = (List<bi>)localObject2;
          if (localbi.field_isSend != 0) {
            break label506;
          }
          paramList = bd.iJ((String)localObject2);
          i = j;
          break label506;
        }
        if (localbi.ctB())
        {
          paramList = null;
          if (localbi.field_msgId > 0L) {
            paramList = com.tencent.mm.as.o.OJ().bY(localbi.field_msgId);
          }
          if (paramList != null)
          {
            localObject1 = paramList;
            if (paramList.enp > 0L) {}
          }
          else
          {
            localObject1 = paramList;
            if (localbi.field_msgSvrId > 0L) {
              localObject1 = com.tencent.mm.as.o.OJ().bX(localbi.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.as.e)localObject1).offset >= ((com.tencent.mm.as.e)localObject1).ebK) && (((com.tencent.mm.as.e)localObject1).ebK != 0)) {}
          for (paramList = com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c((com.tencent.mm.as.e)localObject1), "", "");; paramList = com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = (List<bi>)localObject2;
            break;
          }
        }
        if (localbi.aRR())
        {
          paramList = com.tencent.mm.modelvideo.u.oe(localbi.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.eHH);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = (List<bi>)localObject2;
          break label506;
        }
        if (localbi.aRQ())
        {
          paramList = com.tencent.mm.modelvideo.u.oe(localbi.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.eHH);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = (List<bi>)localObject2;
          break label506;
        }
        paramList = (List<bi>)localObject2;
        if (!localbi.aVK()) {
          break label506;
        }
        paramList = g.a.gp((String)localObject2);
        if ((paramList != null) && (19 == paramList.type)) {
          j = 10;
        }
        for (;;)
        {
          i = j;
          paramList = (List<bi>)localObject2;
          if (!localbi.ctz()) {
            break;
          }
          localIntent.putExtra("is_group_chat", paramBoolean);
          i = j;
          paramList = (List<bi>)localObject2;
          break;
          if ((paramList != null) && (24 == paramList.type)) {
            j = 10;
          } else if ((paramList != null) && (16 == paramList.type)) {
            j = 14;
          } else {
            j = 2;
          }
        }
        localIntent.putExtra("Retr_Msg_Type", i);
        break label553;
        if (((paramaj != null) && (paramaj.cDf())) || ((com.tencent.mm.model.s.hl(paramString)) && (!com.tencent.mm.ai.f.eW(paramString))) || (com.tencent.mm.model.s.hV(paramString)))
        {
          localIntent.putExtra("Retr_Msg_Type", 12);
          i = 2;
        }
        else
        {
          localIntent.putExtra("Retr_Msg_Type", 13);
          localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
          i = 2;
        }
      }
    }
  }
  
  public static void cCz()
  {
    vjm.vju = null;
    vjm.vgB = false;
    vjm.vjb = null;
    vjm.bWQ = null;
    vjm.bWm = null;
    vjm.vjv = null;
  }
  
  public static nd gQ(Context paramContext)
  {
    nd localnd = new nd();
    localnd.bWJ.type = 6;
    localnd.bWJ.bWP = vjm.vju;
    localnd.bWJ.bWQ = vjm.bWQ;
    localnd.bWJ.context = paramContext;
    a.udP.m(localnd);
    vjm.bWm = localnd.bWK.bWm;
    vjm.vjv = localnd.bWK.bWS;
    return localnd;
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = new nd();
    ((nd)localObject).bWJ.type = 5;
    ((nd)localObject).bWJ.bWP = vjm.vju;
    ((nd)localObject).bWJ.toUser = paramString;
    ((nd)localObject).bWJ.bWQ = vjm.bWQ;
    ((nd)localObject).bWJ.context = paramContext;
    ((nd)localObject).bWJ.bWm = vjm.bWm;
    ((nd)localObject).bWJ.bWS = vjm.vjv;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    long l;
    g.a locala;
    if (vjm.vju != null)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(vjm.vju.size()), Integer.valueOf(vjm.vju.size() - k.dP(vjm.vju)) });
      localObject = vjm.vju.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (bi)((Iterator)localObject).next();
        l = bk.UX();
        locala = g.a.gp(bk.ZQ(paramContext.field_content));
        if ((locala != null) && (locala.type == 5) && (!bk.bl(locala.url))) {
          if (!paramContext.ctz()) {
            break label429;
          }
        }
      }
    }
    label429:
    for (int i = 1;; i = 2)
    {
      paramContext = "";
      try
      {
        paramString = URLEncoder.encode(locala.url, "UTF-8");
        paramContext = paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString, "", new Object[0]);
        }
      }
      y.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), locala.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((paramBoolean) && (vjm.vjb != null)) {
        vjm.vjb.b(aj.a.vmx);
      }
      return;
    }
  }
  
  public static void k(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    if (paramContext == null)
    {
      y.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
      return;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      return;
    }
    if ((vjm.vju == null) || (vjm.vju.isEmpty()))
    {
      y.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      return;
    }
    y.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    j.vpo.c(new av.a()
    {
      public final boolean JS()
      {
        if (l.cCA().vju == null) {
          return false;
        }
        Iterator localIterator = l.cCA().vju.iterator();
        while (localIterator.hasNext())
        {
          bi localbi = (bi)localIterator.next();
          l.d(this.val$context, paramString, localbi, l.cCA().vgB);
        }
        return true;
      }
      
      public final boolean JT()
      {
        if (l.cCA().vju != null) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(l.cCA().vju.size()), Integer.valueOf(l.cCA().vju.size() - k.dP(l.cCA().vju)) });
        }
        if (paramBoolean)
        {
          if (this.bxs != null)
          {
            y.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.bxs.run();
          }
          if (l.cCA().vjb != null) {
            l.cCA().vjb.b(aj.a.vmx);
          }
          l.cCz();
        }
        return true;
      }
    });
  }
  
  public static void nj(boolean paramBoolean)
  {
    if ((paramBoolean) && (vjm.vjb != null)) {
      vjm.vjb.b(aj.a.vmx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */