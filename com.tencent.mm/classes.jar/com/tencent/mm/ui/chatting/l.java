package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.z;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  private static a Pgw;
  
  static
  {
    AppMethodBeat.i(34453);
    Pgw = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void BM(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (Pgw.Pgm != null)) {
      Pgw.Pgm.c(z.a.iAU);
    }
    AppMethodBeat.o(34447);
  }
  
  public static boolean a(final Context paramContext, List<ca> paramList, final boolean paramBoolean, final String paramString, final z paramz)
  {
    AppMethodBeat.i(232865);
    gNy();
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(232865);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(232865);
      return false;
    }
    int i;
    if ((paramz != null) && (!paramz.aSC()))
    {
      i = com.tencent.mm.n.c.aqr();
      localObject1 = h.Pgg;
      if (h.i(paramList, i))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759408, new Object[] { Util.getSizeKB(i) }), "", paramContext.getString(2131768713), null);
        AppMethodBeat.o(232865);
        return false;
      }
      long l = com.tencent.mm.n.c.aqu();
      localObject1 = h.Pgg;
      if (h.h(paramList, l))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759397, new Object[] { Util.getSizeKB(l) }), "", paramContext.getString(2131768713), null);
        AppMethodBeat.o(232865);
        return false;
      }
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ca)((Iterator)localObject1).next();
      if (!ac.bB((ca)localObject2))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759141), "", paramContext.getString(2131768713), null);
        AppMethodBeat.o(232865);
        return false;
      }
      if (!ac.bC((ca)localObject2))
      {
        com.tencent.mm.ui.base.u.makeText(paramContext, 2131763773, 0).show();
        AppMethodBeat.o(232865);
        return false;
      }
      if ((paramz != null) && (paramz.aSC()))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1) {}
        for (i = 1; (i != 0) && (k.bs((ca)localObject2)); i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131760907), "", paramContext.getString(2131768713), null);
          AppMethodBeat.o(232865);
          return false;
        }
        if ((i != 0) && (k.bt((ca)localObject2)))
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131760908), "", paramContext.getString(2131768713), null);
          AppMethodBeat.o(232865);
          return false;
        }
      }
    }
    if (!k.a(false, paramList, paramString, paramz)) {
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131761794), "", paramContext.getString(2131755976), paramContext.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34437);
          paramAnonymousDialogInterface = this.Pgx;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label30:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label233;
            }
            Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramz != null)
            {
              paramz.c(z.a.iAU);
              if (paramz.aSE()) {
                com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
              }
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            ca localca = (ca)paramAnonymousDialogInterface.next();
            if (k.bm(localca)) {
              break label30;
            }
            if ((localca.gAy()) || (k.bh(localca)) || (k.bj(localca)) || (k.bu(localca)) || (k.bk(localca)) || (localca.getType() == -1879048186) || (k.br(localca)) || (k.bl(localca)) || (k.bq(localca)) || (k.bm(localca)) || (localca.getType() == 318767153) || (localca.getType() == 788529201) || (localca.getType() == 889192497) || (localca.getType() == 922746929)) {
              break;
            }
          }
          label233:
          if ((!l.c(paramContext, this.Pgx, paramBoolean, paramString, paramz)) && (paramz != null) && (paramz.aSE())) {
            com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
          }
          AppMethodBeat.o(34437);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(232859);
          if ((this.Pgy != null) && (this.Pgy.aSE())) {
            com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
          }
          AppMethodBeat.o(232859);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(232865);
      return true;
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label578;
      label486:
      i = 1;
      if (i == 0) {
        break label910;
      }
      Log.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if (paramz != null)
      {
        if ((paramz.aSC()) || (paramList.size() == 1)) {
          com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131758935), paramContext.getString(2131755998), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34438);
              AppMethodBeat.o(34438);
            }
          });
        }
        if (paramz.aSE()) {
          com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
        }
      }
    }
    Iterator localIterator = paramList.iterator();
    label904:
    label908:
    for (;;)
    {
      label578:
      if (!localIterator.hasNext()) {
        break label486;
      }
      ca localca = (ca)localIterator.next();
      Object localObject3 = null;
      if (localca.gDB()) {
        break;
      }
      if (localca.gAz())
      {
        localObject1 = null;
        if (localca.field_msgId > 0L) {
          localObject1 = q.bcR().H(localca.field_talker, localca.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localca.field_msgSvrId > 0L) {
            localObject2 = q.bcR().G(localca.field_talker, localca.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
        }
        label727:
        if ((localca.gAz()) || (localca.cWJ()) || (localca.cWL()) || (k.bw(localca))) {
          if ((System.currentTimeMillis() - localca.field_createTime <= 259200000L) || ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.s.YS((String)localObject1)))) {
            break label904;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label908;
        }
        i = 0;
        break;
        if ((localca.cWL()) || (localca.cWJ()))
        {
          o.bhj();
          localObject1 = t.Qw(localca.field_imgPath);
          break label727;
        }
        if (localca.dOQ())
        {
          localObject2 = k.b.HD(localca.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label727;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.bdJ(((k.b)localObject2).dCK);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label727;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label727;
        }
        localObject1 = localca.field_imgPath;
        break label727;
      }
    }
    label910:
    paramBoolean = b(paramContext, paramList, paramBoolean, paramString, paramz);
    AppMethodBeat.o(232865);
    return paramBoolean;
  }
  
  private static boolean b(Context paramContext, List<ca> paramList, boolean paramBoolean, String paramString, z paramz)
  {
    AppMethodBeat.i(232866);
    if (k.jj(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758177), "", paramContext.getString(2131755013), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(232860);
          if (this.Pgy != null) {
            this.Pgy.a(z.a.iAU);
          }
          AppMethodBeat.o(232860);
        }
      });
      AppMethodBeat.o(232866);
      return false;
    }
    e(paramContext, paramList);
    Pgw.PgD = new LinkedList(paramList);
    Pgw.Pdm = paramBoolean;
    Pgw.Pgm = paramz;
    Pgw.from = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    if ((paramz != null) && (paramz.aSE())) {
      localIntent.putExtra("Retr_MsgFromMoreSelectRetransmit", true);
    }
    ca localca;
    Object localObject;
    String str;
    int j;
    if (paramList.size() == 1)
    {
      localca = (ca)paramList.get(0);
      if ((localca.dOQ()) || (localca.gAt()))
      {
        paramList = ad.JX(localca.field_msgSvrId);
        localObject = ad.aVe().G(paramList, true);
        ((ad.b)localObject).l("prePublishId", "msg_" + localca.field_msgSvrId);
        ((ad.b)localObject).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localca, paramBoolean, false));
        ((ad.b)localObject).l("preChatName", localca.field_talker);
        ((ad.b)localObject).l("preMsgIndex", Integer.valueOf(0));
        ((ad.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
        ((ad.b)localObject).l("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((ad.b)localObject).l("fromScene", Integer.valueOf(2));
          ((j)com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", (ad.b)localObject, localca);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localca.field_content;
        i = 12;
        if (!localca.dOS()) {
          break label622;
        }
        j = 9;
        paramList = str;
        label372:
        if (!localca.gAt()) {
          break label1365;
        }
      }
    }
    label419:
    label1365:
    for (int i = 1;; i = 2)
    {
      if ((paramz != null) && (!paramz.aSC()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localca.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        if ((paramz == null) || (!paramz.aSD()))
        {
          paramList = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.axQ(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramList.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        m.jl(Pgw.PgD);
        if ((paramz != null) && (paramz.aSD())) {
          paramz.B(localIntent.getExtras());
        }
        AppMethodBeat.o(232866);
        return true;
        ((ad.b)localObject).l("fromScene", Integer.valueOf(1));
        break;
        label622:
        if (localca.gDn())
        {
          j = 5;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.gDl())
        {
          j = 8;
          paramList = str;
          break label372;
        }
        if (localca.isText())
        {
          i = 4;
          j = i;
          paramList = str;
          if (!paramBoolean) {
            break label372;
          }
          j = i;
          paramList = str;
          if (localca.field_isSend != 0) {
            break label372;
          }
          paramList = bp.Kt(str);
          j = i;
          break label372;
        }
        if (localca.gAz())
        {
          paramList = null;
          if (localca.field_msgId > 0L) {
            paramList = q.bcR().H(localca.field_talker, localca.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.localId > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localca.field_msgSvrId > 0L) {
              localObject = q.bcR().G(localca.field_talker, localca.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).iKP) && (((com.tencent.mm.av.g)localObject).iKP != 0)) {}
          for (paramList = q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", "");; paramList = q.bcR().R(localca.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            j = 0;
            paramList = str;
            break;
          }
        }
        if (localca.cWL())
        {
          paramList = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.iFw);
          }
          j = 11;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.cWJ())
        {
          paramList = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.iFw);
          }
          j = 1;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.cWK())
        {
          j = 1;
          paramList = str;
          break label372;
        }
        j = i;
        paramList = str;
        if (!localca.dOQ()) {
          break label372;
        }
        paramList = k.b.HD(str);
        if ((paramList != null) && (71 == paramList.type)) {
          i = 26;
        }
        for (;;)
        {
          j = i;
          paramList = str;
          if (!localca.gAt()) {
            break;
          }
          localIntent.putExtra("is_group_chat", paramBoolean);
          j = i;
          paramList = str;
          break;
          if ((paramList != null) && (73 == paramList.type))
          {
            i = 22;
          }
          else if ((paramList != null) && (51 == paramList.type))
          {
            i = 18;
          }
          else if ((paramList != null) && (19 == paramList.type))
          {
            i = 10;
          }
          else if ((paramList != null) && (24 == paramList.type))
          {
            i = 10;
          }
          else if ((paramList != null) && (16 == paramList.type))
          {
            i = 14;
          }
          else if ((paramList != null) && (63 == paramList.type))
          {
            i = 23;
          }
          else
          {
            if ((paramList != null) && (75 == paramList.type)) {}
            switch (com.tencent.mm.plugin.i.a.l.d(paramList.izF, paramList.izD))
            {
            default: 
              break;
            case 1: 
              i = 27;
              break;
            case 2: 
              i = 28;
              continue;
              i = 2;
            }
          }
        }
        localIntent.putExtra("Retr_Msg_Type", j);
        break label419;
        if (((paramz != null) && (paramz.aSC())) || ((ab.IT(paramString)) && (!com.tencent.mm.al.g.DQ(paramString))) || (ab.JF(paramString)))
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
    AppMethodBeat.i(232869);
    rc localrc = new rc();
    localrc.dXF.type = 5;
    localrc.dXF.dXK = Pgw.PgD;
    localrc.dXF.toUser = paramString1;
    localrc.dXF.from = Pgw.from;
    localrc.dXF.context = paramContext;
    localrc.dXF.dWX = Pgw.dWX;
    localrc.dXF.dXM = Pgw.PgE;
    localrc.dXF.dXO = paramString2;
    EventCenter.instance.publish(localrc);
    long l;
    k.b localb;
    if (Pgw.PgD != null)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(Pgw.PgD.size()), Integer.valueOf(Pgw.PgD.size() - k.jh(Pgw.PgD)) });
      paramString2 = new LinkedList();
      Iterator localIterator = Pgw.PgD.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (ca)localIterator.next();
        l = Util.nowSecond();
        localb = k.b.HD(Util.processXml(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!Util.isNullOrNil(localb.url))) {
          if (!paramContext.gAt()) {
            break label579;
          }
        }
      }
    }
    label579:
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
          Log.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString1, "", new Object[0]);
        }
      }
      Log.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (f)localb.as(f.class);
      if (paramContext == null) {
        break;
      }
      paramString2.add(new Pair(paramContext.jlg.objectId, paramContext.jlg.objectNonceId));
      break;
      if (paramString2.size() > 0) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(paramString2, false);
      }
      if ((paramBoolean) && (Pgw.Pgm != null)) {
        Pgw.Pgm.c(z.a.iAU);
      }
      paramContext = new Pair(Long.valueOf(localrc.dXG.msgId), Boolean.valueOf(localrc.dXG.dXS));
      AppMethodBeat.o(232869);
      return paramContext;
    }
  }
  
  private static void e(Context paramContext, List<ca> paramList)
  {
    AppMethodBeat.i(34444);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if (br.B(localca))
      {
        switch (localca.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          br.L(localca);
          break;
          localca.setContent(paramContext.getString(2131755996));
          continue;
          localca.setContent(paramContext.getString(2131755939));
          localca.setType(1);
          continue;
          localca.setContent(paramContext.getString(2131756018));
          localca.setType(1);
          continue;
          localca.setContent(paramContext.getString(2131756006));
          localca.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static int gNw()
  {
    AppMethodBeat.i(232867);
    if (Pgw.PgD != null)
    {
      int i = Pgw.PgD.size();
      AppMethodBeat.o(232867);
      return i;
    }
    AppMethodBeat.o(232867);
    return 0;
  }
  
  public static boolean gNx()
  {
    AppMethodBeat.i(34449);
    if ((Pgw.PgD == null) || (Pgw.PgD.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = Pgw.PgD.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      bg.aVF();
      ca.a locala = com.tencent.mm.model.c.aSQ().aEK(localca.field_content);
      if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
        Log.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!ab.rR(locala.IOs)) && (localca.getType() == 42) && (localca.gDD()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void gNy()
  {
    Pgw.PgD = null;
    Pgw.Pdm = false;
    Pgw.Pgm = null;
    Pgw.from = null;
    Pgw.dWX = null;
    Pgw.PgE = null;
  }
  
  public static rc ki(Context paramContext)
  {
    AppMethodBeat.i(34448);
    rc localrc = new rc();
    localrc.dXF.type = 10;
    localrc.dXF.dXK = Pgw.PgD;
    localrc.dXF.from = Pgw.from;
    localrc.dXF.context = paramContext;
    EventCenter.instance.publish(localrc);
    Pgw.dWX = localrc.dXG.dWX;
    Pgw.PgE = localrc.dXG.dXM;
    AppMethodBeat.o(34448);
    return localrc;
  }
  
  public static Pair<Long, Boolean> m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(232868);
    paramContext = c(paramContext, paramString, paramBoolean, paramString);
    AppMethodBeat.o(232868);
    return paramContext;
  }
  
  public static void n(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34450);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(34450);
      return;
    }
    if ((Pgw.PgD == null) || (Pgw.PgD.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.d.m.PnZ.add(new QueueWorkerThread.ThreadObject()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(232861);
        if (l.gNz().PgD == null)
        {
          AppMethodBeat.o(232861);
          return false;
        }
        Iterator localIterator = l.gNz().PgD.iterator();
        while (localIterator.hasNext())
        {
          ca localca = (ca)localIterator.next();
          l.d(this.val$context, paramString, localca, l.gNz().Pdm);
        }
        AppMethodBeat.o(232861);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(232862);
        if (l.gNz().PgD != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(l.gNz().PgD.size()), Integer.valueOf(l.gNz().PgD.size() - k.jh(l.gNz().PgD)) });
        }
        Object localObject1 = l.gNz().PgD;
        if (localObject1 != null)
        {
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ca)((Iterator)localObject1).next();
            if (((ca)localObject2).dOQ())
            {
              localObject2 = k.b.HD(Util.processXml(((eo)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                f localf = (f)((k.b)localObject2).as(f.class);
                if (localf != null) {
                  localLinkedList1.add(new Pair(localf.jlg.objectId, localf.jlg.objectNonceId));
                }
              }
              if ((localObject2 != null) && (((k.b)localObject2).type == 71))
              {
                localObject2 = (com.tencent.mm.plugin.i.a.i)((k.b)localObject2).as(com.tencent.mm.plugin.i.a.i.class);
                if (localObject2 != null) {
                  localLinkedList2.add(new Pair(((com.tencent.mm.plugin.i.a.i)localObject2).jlh.objectId, ((com.tencent.mm.plugin.i.a.i)localObject2).jlh.objectNonceId));
                }
              }
            }
          }
          if (localLinkedList1.size() > 0) {
            ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(localLinkedList1, false);
          }
          if (localLinkedList2.size() > 0) {
            ((aj)com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(localLinkedList2, true);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (l.gNz().Pgm != null) {
            l.gNz().Pgm.c(z.a.iAU);
          }
          l.gNy();
        }
        AppMethodBeat.o(232862);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  static final class a
  {
    boolean Pdm;
    List<ca> PgD;
    com.tencent.mm.protocal.b.a.d PgE;
    z Pgm;
    cz dWX;
    String from;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */