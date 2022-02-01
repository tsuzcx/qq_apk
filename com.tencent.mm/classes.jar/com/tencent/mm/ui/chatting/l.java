package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.chatting.d.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  private static a WzP;
  
  static
  {
    AppMethodBeat.i(34453);
    WzP = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void Gh(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (WzP.WzF != null)) {
      WzP.WzF.c(z.a.lqs);
    }
    AppMethodBeat.o(34447);
  }
  
  public static boolean a(final Context paramContext, List<ca> paramList, final boolean paramBoolean, final String paramString, final z paramz)
  {
    AppMethodBeat.i(292316);
    hMH();
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(292316);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(292316);
      return false;
    }
    if ((paramz != null) && (!paramz.bbA()))
    {
      long l = com.tencent.mm.n.c.awK();
      localObject1 = h.Wzz;
      if (h.h(paramList, l))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eET, new Object[] { Util.getSizeKB(l) }), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(292316);
        return false;
      }
      l = com.tencent.mm.n.c.awN();
      localObject1 = h.Wzz;
      if (h.g(paramList, l))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eEP, new Object[] { Util.getSizeKB(l) }), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(292316);
        return false;
      }
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ca)((Iterator)localObject1).next();
      if (!ac.bV((ca)localObject2))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eEx), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(292316);
        return false;
      }
      if (!ac.bW((ca)localObject2))
      {
        com.tencent.mm.ui.base.w.makeText(paramContext, R.l.eOJ, 0).show();
        AppMethodBeat.o(292316);
        return false;
      }
      if ((paramz != null) && (paramz.bbA()))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGe, 0) == 1) {}
        for (i = 1; (i != 0) && (k.bM((ca)localObject2)); i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eFT), "", paramContext.getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(292316);
          return false;
        }
        if ((i != 0) && (k.bN((ca)localObject2)))
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eFU), "", paramContext.getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(292316);
          return false;
        }
      }
    }
    if (!k.a(false, paramList, paramString, paramz)) {
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(R.l.eIa), "", paramContext.getString(R.l.app_send), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34437);
          paramAnonymousDialogInterface = this.WzQ;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            Log.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label30:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label249;
            }
            Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramz != null)
            {
              paramz.c(z.a.lqs);
              if (paramz.bbC()) {
                com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
              }
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            ca localca = (ca)paramAnonymousDialogInterface.next();
            if (k.bF(localca)) {
              break label30;
            }
            if ((localca.hwF()) || (k.bA(localca)) || (k.bC(localca)) || (k.bO(localca)) || (k.bD(localca)) || (localca.getType() == -1879048186) || (k.bL(localca)) || (k.bE(localca)) || (k.bK(localca)) || (k.bF(localca)) || (k.bG(localca)) || (localca.getType() == 318767153) || (localca.getType() == 788529201) || (localca.getType() == 1076887601) || (localca.getType() == 889192497) || (localca.getType() == 922746929)) {
              break;
            }
          }
          label249:
          if ((!l.c(paramContext, this.WzQ, paramBoolean, paramString, paramz)) && (paramz != null) && (paramz.bbC())) {
            com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
          }
          AppMethodBeat.o(34437);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(224057);
          if ((this.WzR != null) && (this.WzR.bbC())) {
            com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
          }
          AppMethodBeat.o(224057);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(292316);
      return true;
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label592;
      label498:
      i = 1;
      if (i == 0) {
        break label924;
      }
      Log.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if (paramz != null)
      {
        if ((paramz.bbA()) || (paramList.size() == 1)) {
          com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(R.l.eEo), paramContext.getString(R.l.app_tip), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34438);
              AppMethodBeat.o(34438);
            }
          });
        }
        if (paramz.bbC()) {
          com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
        }
      }
    }
    Iterator localIterator = paramList.iterator();
    label918:
    label922:
    for (;;)
    {
      label592:
      if (!localIterator.hasNext()) {
        break label498;
      }
      ca localca = (ca)localIterator.next();
      Object localObject3 = null;
      if (localca.Ic()) {
        break;
      }
      if (localca.hwG())
      {
        localObject1 = null;
        if (localca.field_msgId > 0L) {
          localObject1 = q.bmh().D(localca.field_talker, localca.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.ay.g)localObject1).localId > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localca.field_msgSvrId > 0L) {
            localObject2 = q.bmh().C(localca.field_talker, localca.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = q.bmh().r(com.tencent.mm.ay.h.c((com.tencent.mm.ay.g)localObject2), "", "");
        }
        label741:
        if ((localca.hwG()) || (localca.dlR()) || (localca.dlT()) || (k.bQ(localca))) {
          if ((System.currentTimeMillis() - localca.field_createTime <= 259200000L) || ((!Util.isNullOrNil((String)localObject1)) && (u.agG((String)localObject1)))) {
            break label918;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label922;
        }
        i = 0;
        break;
        if ((localca.dlT()) || (localca.dlR()))
        {
          s.bqB();
          localObject1 = x.XT(localca.field_imgPath);
          break label741;
        }
        if (localca.erk())
        {
          localObject2 = k.b.OQ(localca.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label741;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.bqf(((k.b)localObject2).fvr);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label741;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label741;
        }
        localObject1 = localca.field_imgPath;
        break label741;
      }
    }
    label924:
    paramBoolean = b(paramContext, paramList, paramBoolean, paramString, paramz);
    AppMethodBeat.o(292316);
    return paramBoolean;
  }
  
  private static boolean b(Context paramContext, List<ca> paramList, boolean paramBoolean, String paramString, z paramz)
  {
    AppMethodBeat.i(292317);
    if (k.kb(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eAr), "", paramContext.getString(R.l.emp), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(289812);
          if (this.WzR != null) {
            this.WzR.a(z.a.lqs);
          }
          AppMethodBeat.o(289812);
        }
      });
      AppMethodBeat.o(292317);
      return false;
    }
    e(paramContext, paramList);
    WzP.WzW = new LinkedList(paramList);
    WzP.Wwx = paramBoolean;
    WzP.WzF = paramz;
    WzP.from = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    if ((paramz != null) && (paramz.bbC())) {
      localIntent.putExtra("Retr_MsgFromMoreSelectRetransmit", true);
    }
    ca localca;
    Object localObject;
    String str;
    int j;
    if (paramList.size() == 1)
    {
      localca = (ca)paramList.get(0);
      if ((localca.erk()) || (localca.hwA()))
      {
        paramList = ad.Rp(localca.field_msgSvrId);
        localObject = ad.beh().I(paramList, true);
        ((ad.b)localObject).k("prePublishId", "msg_" + localca.field_msgSvrId);
        ((ad.b)localObject).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(localca, paramBoolean, false));
        ((ad.b)localObject).k("preChatName", localca.field_talker);
        ((ad.b)localObject).k("preMsgIndex", Integer.valueOf(0));
        ((ad.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
        ((ad.b)localObject).k("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((ad.b)localObject).k("fromScene", Integer.valueOf(2));
          ((com.tencent.mm.plugin.sns.b.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sns.b.k.class)).a("adExtStr", (ad.b)localObject, localca);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localca.field_content;
        i = 12;
        if (!localca.erm()) {
          break label633;
        }
        j = 9;
        paramList = str;
        label372:
        if (!localca.hwA()) {
          break label1443;
        }
      }
    }
    label1443:
    for (int i = 1;; i = 2)
    {
      if ((paramz != null) && (!paramz.bbA()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        label419:
        localIntent.putExtra("Retr_Msg_Id", localca.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        localIntent.putExtra("scene_from", 17);
        if ((paramz == null) || (!paramz.bbB()))
        {
          paramList = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramList.aFh(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramList.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        m.kd(WzP.WzW);
        if ((paramz != null) && (paramz.bbB())) {
          paramz.H(localIntent.getExtras());
        }
        AppMethodBeat.o(292317);
        return true;
        ((ad.b)localObject).k("fromScene", Integer.valueOf(1));
        break;
        label633:
        if (localca.hzB())
        {
          j = 5;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.hzy())
        {
          j = 8;
          paramList = str;
          break label372;
        }
        if (localca.hwH())
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
          paramList = bq.RM(str);
          j = i;
          break label372;
        }
        if (localca.hwG())
        {
          paramList = null;
          if (localca.field_msgId > 0L) {
            paramList = q.bmh().D(localca.field_talker, localca.field_msgId);
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
              localObject = q.bmh().C(localca.field_talker, localca.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.ay.g)localObject).offset >= ((com.tencent.mm.ay.g)localObject).lAW) && (((com.tencent.mm.ay.g)localObject).lAW != 0)) {}
          for (paramList = q.bmh().r(com.tencent.mm.ay.h.c((com.tencent.mm.ay.g)localObject), "", "");; paramList = q.bmh().T(localca.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            j = 0;
            paramList = str;
            break;
          }
        }
        if (localca.dlT())
        {
          paramList = y.Yk(localca.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.lvw);
          }
          j = 11;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.dlR())
        {
          paramList = y.Yk(localca.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.lvw);
          }
          j = 1;
          localIntent.putExtra("Retr_File_Name", localca.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localca.dlS())
        {
          j = 1;
          paramList = str;
          break label372;
        }
        j = i;
        paramList = str;
        if (!localca.erk()) {
          break label372;
        }
        paramList = k.b.OQ(str);
        if ((paramList != null) && (71 == paramList.type)) {
          i = 26;
        }
        for (;;)
        {
          j = i;
          paramList = str;
          if (!localca.hwA()) {
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
            switch (com.tencent.mm.plugin.findersdk.a.k.d(paramList.lpa, paramList.loX))
            {
            default: 
              break;
            case 2: 
              i = 28;
              break;
            case 3: 
              i = 27;
              continue;
              i = 2;
            }
          }
        }
        localIntent.putExtra("Retr_Msg_Type", j);
        break label419;
        localObject = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          ((ArrayList)localObject).add(Long.valueOf(((ca)paramList.next()).field_msgId));
        }
        localIntent.putExtra("Retr_Msg_Id_List", (Serializable)localObject);
        if (((paramz != null) && (paramz.bbA())) || ((ab.Qm(paramString)) && (!com.tencent.mm.ao.g.KI(paramString))) || (ab.QY(paramString)))
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
    AppMethodBeat.i(292321);
    sc localsc = new sc();
    localsc.fRw.type = 5;
    localsc.fRw.fRB = WzP.WzW;
    localsc.fRw.toUser = paramString1;
    localsc.fRw.from = WzP.from;
    localsc.fRw.context = paramContext;
    localsc.fRw.fQJ = WzP.fQJ;
    localsc.fRw.fRD = WzP.WzX;
    localsc.fRw.fRF = paramString2;
    EventCenter.instance.publish(localsc);
    long l;
    k.b localb;
    if (WzP.WzW != null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(WzP.WzW.size()), Integer.valueOf(WzP.WzW.size() - k.jZ(WzP.WzW)) });
      paramString2 = new LinkedList();
      Iterator localIterator = WzP.WzW.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (ca)localIterator.next();
        l = Util.nowSecond();
        localb = k.b.OQ(Util.processXml(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!Util.isNullOrNil(localb.url))) {
          if (!paramContext.hwA()) {
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
      com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (f)localb.ar(f.class);
      if (paramContext == null) {
        break;
      }
      paramString2.add(new Pair(paramContext.mbi.objectId, paramContext.mbi.objectNonceId));
      break;
      if (paramString2.size() > 0) {
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).shareStatsReport(paramString2, false);
      }
      if ((paramBoolean) && (WzP.WzF != null)) {
        WzP.WzF.c(z.a.lqs);
      }
      paramContext = new Pair(Long.valueOf(localsc.fRx.msgId), Boolean.valueOf(localsc.fRx.fRJ));
      AppMethodBeat.o(292321);
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
      if (bs.D(localca))
      {
        switch (localca.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bs.R(localca);
          break;
          localca.setContent(paramContext.getString(R.l.app_text));
          continue;
          localca.setContent(paramContext.getString(R.l.app_pic));
          localca.setType(1);
          continue;
          localca.setContent(paramContext.getString(R.l.app_video));
          localca.setType(1);
          continue;
          localca.setContent(paramContext.getString(R.l.app_unknown_msg));
          localca.setType(1);
          continue;
          localca.setContent(paramContext.getString(R.l.app_unknown_msg));
          localca.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static int hMF()
  {
    AppMethodBeat.i(292318);
    if (WzP.WzW != null)
    {
      int i = WzP.WzW.size();
      AppMethodBeat.o(292318);
      return i;
    }
    AppMethodBeat.o(292318);
    return 0;
  }
  
  public static boolean hMG()
  {
    AppMethodBeat.i(34449);
    if ((WzP.WzW == null) || (WzP.WzW.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = WzP.WzW.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      bh.beI();
      ca.a locala = com.tencent.mm.model.c.bbO().aOU(localca.field_content);
      if ((locala.fcC == null) || (locala.fcC.length() <= 0)) {
        Log.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!ab.uL(locala.PKJ)) && (localca.getType() == 42) && (localca.hzQ()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void hMH()
  {
    WzP.WzW = null;
    WzP.Wwx = false;
    WzP.WzF = null;
    WzP.from = null;
    WzP.fQJ = null;
    WzP.WzX = null;
  }
  
  public static sc lg(Context paramContext)
  {
    AppMethodBeat.i(34448);
    sc localsc = new sc();
    localsc.fRw.type = 10;
    localsc.fRw.fRB = WzP.WzW;
    localsc.fRw.from = WzP.from;
    localsc.fRw.context = paramContext;
    EventCenter.instance.publish(localsc);
    WzP.fQJ = localsc.fRx.fQJ;
    WzP.WzX = localsc.fRx.fRD;
    AppMethodBeat.o(34448);
    return localsc;
  }
  
  public static Pair<Long, Boolean> m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(292320);
    paramContext = c(paramContext, paramString, paramBoolean, paramString);
    AppMethodBeat.o(292320);
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
    if ((WzP.WzW == null) || (WzP.WzW.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    n.WIm.add(new QueueWorkerThread.ThreadObject()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(282762);
        if (l.hMI().WzW == null)
        {
          AppMethodBeat.o(282762);
          return false;
        }
        Iterator localIterator = l.hMI().WzW.iterator();
        while (localIterator.hasNext())
        {
          ca localca = (ca)localIterator.next();
          l.d(this.val$context, paramString, localca, l.hMI().Wwx);
        }
        AppMethodBeat.o(282762);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(282763);
        if (l.hMI().WzW != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(l.hMI().WzW.size()), Integer.valueOf(l.hMI().WzW.size() - k.jZ(l.hMI().WzW)) });
        }
        Object localObject1 = l.hMI().WzW;
        if (localObject1 != null)
        {
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ca)((Iterator)localObject1).next();
            if (((ca)localObject2).erk())
            {
              localObject2 = k.b.OQ(Util.processXml(((et)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                f localf = (f)((k.b)localObject2).ar(f.class);
                if (localf != null) {
                  localLinkedList1.add(new Pair(localf.mbi.objectId, localf.mbi.objectNonceId));
                }
              }
              if ((localObject2 != null) && (((k.b)localObject2).type == 71))
              {
                localObject2 = (com.tencent.mm.plugin.findersdk.a.i)((k.b)localObject2).ar(com.tencent.mm.plugin.findersdk.a.i.class);
                if (localObject2 != null) {
                  localLinkedList2.add(new Pair(((com.tencent.mm.plugin.findersdk.a.i)localObject2).mbk.objectId, ((com.tencent.mm.plugin.findersdk.a.i)localObject2).mbk.objectNonceId));
                }
              }
            }
          }
          if (localLinkedList1.size() > 0) {
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).shareStatsReport(localLinkedList1, false);
          }
          if (localLinkedList2.size() > 0) {
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).shareStatsReport(localLinkedList2, true);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (l.hMI().WzF != null) {
            l.hMI().WzF.c(z.a.lqs);
          }
          l.hMH();
        }
        AppMethodBeat.o(282763);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  static final class a
  {
    boolean Wwx;
    z WzF;
    List<ca> WzW;
    com.tencent.mm.protocal.b.a.d WzX;
    dd fQJ;
    String from;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */