package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static a JAs;
  
  static
  {
    AppMethodBeat.i(34453);
    JAs = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void a(final Context paramContext, List<bu> paramList, final boolean paramBoolean, final String paramString, final z paramz)
  {
    AppMethodBeat.i(34443);
    fBo();
    if (paramContext == null)
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(34443);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(34443);
      return;
    }
    long l3;
    Object localObject1;
    long l1;
    Object localObject2;
    if ((paramz != null) && (!paramz.azg()))
    {
      l3 = com.tencent.mm.n.b.ack();
      localObject1 = paramList.iterator();
      l1 = 0L;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bu)((Iterator)localObject1).next();
        if ((((bu)localObject2).cxf()) || (((bu)localObject2).cxh()))
        {
          localObject2 = u.Hy(((ei)localObject2).field_imgPath);
          if (localObject2 == null) {
            break label1354;
          }
        }
      }
    }
    label1156:
    label1333:
    label1337:
    label1338:
    label1339:
    label1348:
    label1354:
    for (int i = ((s)localObject2).hMP;; i = 0)
    {
      long l2 = i;
      ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "sumSelectedMsgFileSize, videoSize:%s", new Object[] { Integer.valueOf(i) });
      l1 = l2 + l1;
      break;
      if (((bu)localObject2).fpi())
      {
        localObject2 = q.aIF().F(((ei)localObject2).field_talker, ((ei)localObject2).field_msgSvrId);
        l2 = ((com.tencent.mm.aw.g)localObject2).hMP;
        ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "sumSelectedMsgFileSize, imgSize:%s", new Object[] { Integer.valueOf(((com.tencent.mm.aw.g)localObject2).hMP) });
        l1 = l2 + l1;
        break;
      }
      l2 = l1;
      Object localObject3;
      Object localObject4;
      if (((bu)localObject2).cTc())
      {
        localObject2 = k.b.yr(((ei)localObject2).field_content);
        if ((localObject2 != null) && (((k.b)localObject2).type == 6))
        {
          l2 = ((k.b)localObject2).hzO;
          ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "sumSelectedMsgFileSize, fileSize:%s", new Object[] { Integer.valueOf(((k.b)localObject2).hzO) });
          l1 = l2 + l1;
          break;
        }
        l2 = l1;
        if (localObject2 != null) {
          if (((k.b)localObject2).type != 24)
          {
            l2 = l1;
            if (((k.b)localObject2).type != 19) {}
          }
          else
          {
            localObject2 = p.avr(((k.b)localObject2).hAs);
            if (localObject2 != null)
            {
              localObject2 = ((com.tencent.mm.protocal.b.a.c)localObject2).hDb.iterator();
              i = 0;
              for (;;)
              {
                j = i;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject3 = (ajn)((Iterator)localObject2).next();
                if (((ajn)localObject3).dataType == 17)
                {
                  localObject3 = p.avr(((ajn)localObject3).Gib);
                  if (localObject3 != null)
                  {
                    localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject3).hDb.iterator();
                    for (j = 0;; j = (int)(((ajn)localObject4).Ghm + l2))
                    {
                      k = j;
                      if (!((Iterator)localObject3).hasNext()) {
                        break;
                      }
                      localObject4 = (ajn)((Iterator)localObject3).next();
                      l2 = j;
                    }
                  }
                  int k = 0;
                  i += k;
                }
                else
                {
                  l2 = i;
                  i = (int)(((ajn)localObject3).Ghm + l2);
                }
              }
            }
            int j = 0;
            l2 = l1 + j;
            ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "sumSelectedMsgFileSize, noteSize:%s", new Object[] { Integer.valueOf(j) });
          }
        }
      }
      l1 = l2;
      break;
      ad.i("MicroMsg.ChattingEditModeRetransmitMsg", "sumSelectedMsgFileSize, totalSize:%s", new Object[] { Long.valueOf(l1) });
      if (l1 > l3) {}
      for (i = 1; i != 0; i = 0)
      {
        com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131759065, new Object[] { bt.sy(l3) }), "", true);
        AppMethodBeat.o(34443);
        return;
      }
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bu)((Iterator)localObject1).next();
        if (!ab.bn((bu)localObject2))
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766957), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(34443);
          return;
        }
        if (!ab.bo((bu)localObject2))
        {
          com.tencent.mm.ui.base.t.makeText(paramContext, 2131761802, 0).show();
          AppMethodBeat.o(34443);
          return;
        }
        if ((paramz != null) && (paramz.azg()))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyO, 0) == 1) {}
          for (i = 1; (i != 0) && (j.bd((bu)localObject2)); i = 0)
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759586), "", paramContext.getString(2131766205), null);
            AppMethodBeat.o(34443);
            return;
          }
          if ((i != 0) && (j.be((bu)localObject2)))
          {
            com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759587), "", paramContext.getString(2131766205), null);
            AppMethodBeat.o(34443);
            return;
          }
        }
      }
      if (!j.a(false, paramList, paramString, paramz))
      {
        com.tencent.mm.ui.base.h.e(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131755884), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(34437);
            paramAnonymousDialogInterface = this.JAt;
            if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
              ad.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
            }
            label30:
            for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
            {
              if (paramAnonymousInt == 0) {
                break label214;
              }
              ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
              if (paramz != null) {
                paramz.c(z.a.hDT);
              }
              AppMethodBeat.o(34437);
              return;
              paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
              if (!paramAnonymousDialogInterface.hasNext()) {
                break label30;
              }
              bu localbu = (bu)paramAnonymousDialogInterface.next();
              if (j.aX(localbu)) {
                break label30;
              }
              if ((localbu.fph()) || (j.aS(localbu)) || (j.aU(localbu)) || (j.bf(localbu)) || (j.aV(localbu)) || (localbu.getType() == -1879048186) || (j.bc(localbu)) || (j.aW(localbu)) || (j.bb(localbu)) || (j.aX(localbu)) || (localbu.getType() == 318767153) || (localbu.getType() == 788529201) || (localbu.getType() == 889192497) || (localbu.getType() == 922746929)) {
                break;
              }
            }
            label214:
            k.c(paramContext, this.JAt, paramBoolean, paramString, paramz);
            AppMethodBeat.o(34437);
          }
        }, null);
        AppMethodBeat.o(34443);
        return;
      }
      if ((paramList == null) || (paramList.isEmpty())) {
        ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      }
      for (;;)
      {
        i = 1;
        if (i == 0) {
          break label1339;
        }
        ad.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
        if ((paramz == null) || ((!paramz.azg()) && (paramList.size() != 1))) {
          break label1348;
        }
        com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131758628), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(34443);
        return;
        localObject4 = paramList.iterator();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label1338;
          }
          bu localbu = (bu)((Iterator)localObject4).next();
          localObject3 = null;
          if (localbu.frT()) {
            break;
          }
          if (localbu.fpi())
          {
            localObject1 = null;
            if (localbu.field_msgId > 0L) {
              localObject1 = q.aIF().G(localbu.field_talker, localbu.field_msgId);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
            }
            else
            {
              localObject2 = localObject1;
              if (localbu.field_msgSvrId > 0L) {
                localObject2 = q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
              }
            }
            localObject1 = localObject3;
            if (localObject2 != null) {
              localObject1 = q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject2), "", "");
            }
            if ((localbu.fpi()) || (localbu.cxf()) || (localbu.cxh()) || (j.bh(localbu))) {
              if ((System.currentTimeMillis() - localbu.field_createTime <= 259200000L) || ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.i.fv((String)localObject1)))) {
                break label1333;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1337;
            }
            i = 0;
            break;
            if ((localbu.cxh()) || (localbu.cxf()))
            {
              o.aMJ();
              localObject1 = com.tencent.mm.modelvideo.t.Hh(localbu.field_imgPath);
              break label1156;
            }
            if (localbu.cTc())
            {
              localObject2 = k.b.yr(localbu.field_content);
              localObject1 = localObject3;
              if (localObject2 == null) {
                break label1156;
              }
              localObject2 = com.tencent.mm.pluginsdk.model.app.m.aLN(((k.b)localObject2).dks);
              localObject1 = localObject3;
              if (localObject2 == null) {
                break label1156;
              }
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
              break label1156;
            }
            localObject1 = localbu.field_imgPath;
            break label1156;
          }
        }
      }
      b(paramContext, paramList, paramBoolean, paramString, paramz);
      AppMethodBeat.o(34443);
      return;
    }
  }
  
  private static void b(Context paramContext, List<bu> paramList, boolean paramBoolean, String paramString, z paramz)
  {
    AppMethodBeat.i(34445);
    if (j.hW(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757937), "", paramContext.getString(2131755012), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34438);
          if (this.JAu != null) {
            this.JAu.a(z.a.hDT);
          }
          AppMethodBeat.o(34438);
        }
      });
      AppMethodBeat.o(34445);
      return;
    }
    e(paramContext, paramList);
    JAs.JAA = new LinkedList(paramList);
    JAs.Jxs = paramBoolean;
    JAs.JAi = paramz;
    JAs.dET = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    bu localbu;
    Object localObject;
    String str;
    int i;
    if (paramList.size() == 1)
    {
      localbu = (bu)paramList.get(0);
      if ((localbu.cTc()) || (localbu.fpd()))
      {
        paramList = y.AH(localbu.field_msgSvrId);
        localObject = y.aBq().F(paramList, true);
        ((y.b)localObject).k("prePublishId", "msg_" + localbu.field_msgSvrId);
        ((y.b)localObject).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localbu, paramBoolean, false));
        ((y.b)localObject).k("preChatName", localbu.field_talker);
        ((y.b)localObject).k("preMsgIndex", Integer.valueOf(0));
        ((y.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
        ((y.b)localObject).k("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((y.b)localObject).k("fromScene", Integer.valueOf(2));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject, localbu);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localbu.field_content;
        i = 12;
        if (!localbu.cTe()) {
          break label599;
        }
        i = 9;
        paramList = str;
        label346:
        if (!localbu.fpd()) {
          break label1215;
        }
      }
    }
    label393:
    label1215:
    for (int j = 1;; j = 2)
    {
      if ((paramz != null) && (!paramz.azg()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localbu.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
        i = j;
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        if ((paramz == null) || (!paramz.azh()))
        {
          paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.ahp(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramList.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        l.hY(JAs.JAA);
        if ((paramz != null) && (paramz.azh())) {
          paramz.u(localIntent.getExtras());
        }
        AppMethodBeat.o(34445);
        return;
        ((y.b)localObject).k("fromScene", Integer.valueOf(1));
        break;
        label599:
        if (localbu.frG())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbu.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbu.frE())
        {
          i = 8;
          paramList = str;
          break label346;
        }
        if (localbu.isText())
        {
          j = 4;
          i = j;
          paramList = str;
          if (!paramBoolean) {
            break label346;
          }
          i = j;
          paramList = str;
          if (localbu.field_isSend != 0) {
            break label346;
          }
          paramList = bj.Bl(str);
          i = j;
          break label346;
        }
        if (localbu.fpi())
        {
          paramList = null;
          if (localbu.field_msgId > 0L) {
            paramList = q.aIF().G(localbu.field_talker, localbu.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.dnz > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localbu.field_msgSvrId > 0L) {
              localObject = q.aIF().F(localbu.field_talker, localbu.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.aw.g)localObject).offset >= ((com.tencent.mm.aw.g)localObject).hMP) && (((com.tencent.mm.aw.g)localObject).hMP != 0)) {}
          for (paramList = q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject), "", "");; paramList = q.aIF().R(localbu.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = str;
            break;
          }
        }
        if (localbu.cxh())
        {
          paramList = u.Hy(localbu.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hHQ);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbu.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbu.cxf())
        {
          paramList = u.Hy(localbu.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hHQ);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbu.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbu.cxg())
        {
          i = 1;
          paramList = str;
          break label346;
        }
        paramList = str;
        if (!localbu.cTc()) {
          break label346;
        }
        paramList = k.b.yr(str);
        if ((paramList != null) && (51 == paramList.type)) {
          j = 18;
        }
        for (;;)
        {
          i = j;
          paramList = str;
          if (!localbu.fpd()) {
            break;
          }
          localIntent.putExtra("is_group_chat", paramBoolean);
          i = j;
          paramList = str;
          break;
          if ((paramList != null) && (19 == paramList.type)) {
            j = 10;
          } else if ((paramList != null) && (24 == paramList.type)) {
            j = 10;
          } else if ((paramList != null) && (16 == paramList.type)) {
            j = 14;
          } else {
            j = 2;
          }
        }
        localIntent.putExtra("Retr_Msg_Type", i);
        break label393;
        if (((paramz != null) && (paramz.azg())) || ((w.zE(paramString)) && (!com.tencent.mm.am.g.vd(paramString))) || (w.Aq(paramString)))
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
  
  public static Pair<Long, Boolean> c(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(193846);
    qh localqh = new qh();
    localqh.dEN.type = 5;
    localqh.dEN.dES = JAs.JAA;
    localqh.dEN.toUser = paramString1;
    localqh.dEN.dET = JAs.dET;
    localqh.dEN.context = paramContext;
    localqh.dEN.dEg = JAs.dEg;
    localqh.dEN.dEV = JAs.JAB;
    localqh.dEN.dEX = paramString2;
    com.tencent.mm.sdk.b.a.IbL.l(localqh);
    long l;
    k.b localb;
    if (JAs.JAA != null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(JAs.JAA.size()), Integer.valueOf(JAs.JAA.size() - j.hU(JAs.JAA)) });
      paramString2 = new LinkedList();
      Iterator localIterator = JAs.JAA.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (bu)localIterator.next();
        l = bt.aQJ();
        localb = k.b.yr(bt.aRd(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!bt.isNullOrNil(localb.url))) {
          if (!paramContext.fpd()) {
            break label564;
          }
        }
      }
    }
    label564:
    for (int i = 1;; i = 2)
    {
      paramContext = "";
      try
      {
        paramString1 = URLEncoder.encode(localb.url, "UTF-8");
        paramContext = paramString1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString1, "", new Object[0]);
        }
      }
      ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext == null) {
        break;
      }
      paramString2.add(paramContext.inc.objectId);
      break;
      if (paramString2.size() > 0) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).shareStatsReport(paramString2);
      }
      if ((paramBoolean) && (JAs.JAi != null)) {
        JAs.JAi.c(z.a.hDT);
      }
      paramContext = new Pair(Long.valueOf(localqh.dEO.msgId), Boolean.valueOf(localqh.dEO.dFc));
      AppMethodBeat.o(193846);
      return paramContext;
    }
  }
  
  private static void e(Context paramContext, List<bu> paramList)
  {
    AppMethodBeat.i(34444);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bu localbu = (bu)paramList.next();
      if (bl.z(localbu))
      {
        switch (localbu.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bl.C(localbu);
          break;
          localbu.setContent(paramContext.getString(2131755904));
          continue;
          localbu.setContent(paramContext.getString(2131755853));
          localbu.setType(1);
          continue;
          localbu.setContent(paramContext.getString(2131755926));
          localbu.setType(1);
          continue;
          localbu.setContent(paramContext.getString(2131755914));
          localbu.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static int fBm()
  {
    AppMethodBeat.i(193844);
    if (JAs.JAA != null)
    {
      int i = JAs.JAA.size();
      AppMethodBeat.o(193844);
      return i;
    }
    AppMethodBeat.o(193844);
    return 0;
  }
  
  public static boolean fBn()
  {
    AppMethodBeat.i(34449);
    if ((JAs.JAA == null) || (JAs.JAA.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = JAs.JAA.iterator();
    while (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      ba.aBQ();
      bu.a locala = com.tencent.mm.model.c.azs().aqk(localbu.field_content);
      if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
        ad.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!w.on(locala.DKi)) && (localbu.getType() == 42) && (localbu.frV()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void fBo()
  {
    JAs.JAA = null;
    JAs.Jxs = false;
    JAs.JAi = null;
    JAs.dET = null;
    JAs.dEg = null;
    JAs.JAB = null;
  }
  
  public static qh kj(Context paramContext)
  {
    AppMethodBeat.i(34448);
    qh localqh = new qh();
    localqh.dEN.type = 6;
    localqh.dEN.dES = JAs.JAA;
    localqh.dEN.dET = JAs.dET;
    localqh.dEN.context = paramContext;
    com.tencent.mm.sdk.b.a.IbL.l(localqh);
    JAs.dEg = localqh.dEO.dEg;
    JAs.JAB = localqh.dEO.dEV;
    AppMethodBeat.o(34448);
    return localqh;
  }
  
  public static Pair<Long, Boolean> l(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193845);
    paramContext = c(paramContext, paramString, paramBoolean, paramString);
    AppMethodBeat.o(193845);
    return paramContext;
  }
  
  public static void m(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34450);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(34450);
      return;
    }
    if ((JAs.JAA == null) || (JAs.JAA.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    ad.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.d.m.JHH.c(new be.a()
    {
      public final boolean aEm()
      {
        AppMethodBeat.i(34439);
        if (k.fBp().JAA == null)
        {
          AppMethodBeat.o(34439);
          return false;
        }
        Iterator localIterator = k.fBp().JAA.iterator();
        while (localIterator.hasNext())
        {
          bu localbu = (bu)localIterator.next();
          k.d(this.val$context, paramString, localbu, k.fBp().Jxs);
        }
        AppMethodBeat.o(34439);
        return true;
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(34440);
        if (k.fBp().JAA != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(k.fBp().JAA.size()), Integer.valueOf(k.fBp().JAA.size() - j.hU(k.fBp().JAA)) });
        }
        Object localObject1 = k.fBp().JAA;
        if (localObject1 != null)
        {
          LinkedList localLinkedList = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bu)((Iterator)localObject1).next();
            if (((bu)localObject2).cTc())
            {
              localObject2 = k.b.yr(bt.aRd(((ei)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject2).ao(com.tencent.mm.plugin.i.a.b.class);
                if (localObject2 != null) {
                  localLinkedList.add(((com.tencent.mm.plugin.i.a.b)localObject2).inc.objectId);
                }
              }
            }
          }
          if (localLinkedList.size() > 0) {
            ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).shareStatsReport(localLinkedList);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            ad.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (k.fBp().JAi != null) {
            k.fBp().JAi.c(z.a.hDT);
          }
          k.fBo();
        }
        AppMethodBeat.o(34440);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  public static void xQ(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (JAs.JAi != null)) {
      JAs.JAi.c(z.a.hDT);
    }
    AppMethodBeat.o(34447);
  }
  
  static final class a
  {
    List<bu> JAA;
    com.tencent.mm.protocal.b.a.d JAB;
    z JAi;
    boolean Jxs;
    String dET;
    cv dEg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */