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
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  private static a aehk;
  
  static
  {
    AppMethodBeat.i(34453);
    aehk = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void LU(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (aehk.aehs != null) && (aehk.aehs.get() != null)) {
      ((com.tencent.mm.message.z)aehk.aehs.get()).c(z.a.nVv);
    }
    AppMethodBeat.o(34447);
  }
  
  public static boolean a(final Context paramContext, List<cc> paramList, final boolean paramBoolean, final String paramString, final com.tencent.mm.message.z paramz)
  {
    AppMethodBeat.i(253860);
    jpj();
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(253860);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(253860);
      return false;
    }
    if ((paramz != null) && (!paramz.bws()))
    {
      long l = com.tencent.mm.k.c.aRk();
      localObject1 = j.aegW;
      if (j.j(paramList, l))
      {
        k.a(paramContext, paramContext.getString(R.l.gHM, new Object[] { Util.getSizeKB(l) }), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(253860);
        return false;
      }
      l = com.tencent.mm.k.c.aRn();
      localObject1 = j.aegW;
      if (j.i(paramList, l))
      {
        k.a(paramContext, paramContext.getString(R.l.gHI, new Object[] { Util.getSizeKB(l) }), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(253860);
        return false;
      }
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if (!ae.cj((cc)localObject2))
      {
        k.a(paramContext, paramContext.getString(R.l.gHq), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(253860);
        return false;
      }
      if (!ae.ck((cc)localObject2))
      {
        com.tencent.mm.ui.base.aa.makeText(paramContext, R.l.gRg, 0).show();
        AppMethodBeat.o(253860);
        return false;
      }
      if ((paramz != null) && (paramz.bws()))
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVK, 0) == 1) {}
        for (i = 1; (i != 0) && (m.ca((cc)localObject2)); i = 0)
        {
          k.a(paramContext, paramContext.getString(R.l.gIO), "", paramContext.getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(253860);
          return false;
        }
        if ((i != 0) && (m.cb((cc)localObject2)))
        {
          k.a(paramContext, paramContext.getString(R.l.gIP), "", paramContext.getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(253860);
          return false;
        }
      }
    }
    if (!m.a(false, paramList, paramString, paramz)) {
      k.b(paramContext, paramContext.getString(R.l.gJH), "", paramContext.getString(R.l.app_send), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34437);
          paramAnonymousDialogInterface = n.this;
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
              paramz.c(z.a.nVv);
              if (paramz.bwu()) {
                com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
              }
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            cc localcc = (cc)paramAnonymousDialogInterface.next();
            if (m.bR(localcc)) {
              break label30;
            }
            if ((localcc.iYj()) || (m.bM(localcc)) || (m.bO(localcc)) || (m.cc(localcc)) || (m.bP(localcc)) || (localcc.getType() == -1879048186) || (m.bY(localcc)) || (m.bQ(localcc)) || (m.bX(localcc)) || (m.bR(localcc)) || (m.bT(localcc)) || (localcc.getType() == 318767153) || (localcc.getType() == 788529201) || (localcc.getType() == 1076887601) || (localcc.getType() == 889192497) || (localcc.getType() == 922746929)) {
              break;
            }
          }
          label249:
          if ((!n.c(paramContext, n.this, paramBoolean, paramString, paramz)) && (paramz != null) && (paramz.bwu())) {
            com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
          }
          AppMethodBeat.o(34437);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253840);
          if ((n.this != null) && (n.this.bwu())) {
            com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
          }
          AppMethodBeat.o(253840);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(253860);
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
        if ((paramz.bws()) || (paramList.size() == 1)) {
          k.d(paramContext, paramContext.getString(R.l.gHh), paramContext.getString(R.l.app_tip), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34438);
              AppMethodBeat.o(34438);
            }
          });
        }
        if (paramz.bwu()) {
          com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
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
      cc localcc = (cc)localIterator.next();
      Object localObject3 = null;
      if (localcc.isClean()) {
        break;
      }
      if (localcc.iYk())
      {
        localObject1 = null;
        if (localcc.field_msgId > 0L) {
          localObject1 = r.bKa().H(localcc.field_talker, localcc.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localcc.field_msgSvrId > 0L) {
            localObject2 = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", "");
        }
        label741:
        if ((localcc.iYk()) || (localcc.dSH()) || (localcc.dSJ()) || (m.ce(localcc))) {
          if ((System.currentTimeMillis() - localcc.getCreateTime() <= 259200000L) || ((!Util.isNullOrNil((String)localObject1)) && (y.ZC((String)localObject1)))) {
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
        if ((localcc.dSJ()) || (localcc.dSH()))
        {
          v.bOh();
          localObject1 = com.tencent.mm.modelvideo.aa.PX(localcc.field_imgPath);
          break label741;
        }
        if (localcc.fxR())
        {
          localObject2 = k.b.Hf(localcc.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label741;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.n.bpU(((k.b)localObject2).hzM);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label741;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label741;
        }
        localObject1 = localcc.field_imgPath;
        break label741;
      }
    }
    label924:
    paramBoolean = b(paramContext, paramList, paramBoolean, paramString, paramz);
    AppMethodBeat.o(253860);
    return paramBoolean;
  }
  
  public static Pair<Long, Boolean> b(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(253896);
    tr localtr = new tr();
    localtr.hXt.type = 5;
    localtr.hXt.hXy = aehk.aehr;
    localtr.hXt.toUser = paramString1;
    localtr.hXt.from = aehk.from;
    localtr.hXt.context = paramContext;
    localtr.hXt.hWG = aehk.hWG;
    localtr.hXt.hXA = aehk.aeht;
    localtr.hXt.hXC = paramString2;
    localtr.publish();
    long l;
    k.b localb;
    if (aehk.aehr != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(aehk.aehr.size()), Integer.valueOf(aehk.aehr.size() - m.no(aehk.aehr)) });
      paramString2 = new LinkedList();
      Iterator localIterator = aehk.aehr.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (cc)localIterator.next();
        l = Util.nowSecond();
        localb = k.b.Hf(Util.processXml(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!Util.isNullOrNil(localb.url))) {
          if (!paramContext.iYe()) {
            break label594;
          }
        }
      }
    }
    label594:
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
      com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (f)localb.aK(f.class);
      if (paramContext == null) {
        break;
      }
      paramString2.add(new Pair(paramContext.oUc.objectId, paramContext.oUc.objectNonceId));
      break;
      if (paramString2.size() > 0) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport(paramString2, false);
      }
      if ((paramBoolean) && (aehk.aehs != null) && (aehk.aehs.get() != null)) {
        ((com.tencent.mm.message.z)aehk.aehs.get()).c(z.a.nVv);
      }
      paramContext = new Pair(Long.valueOf(localtr.hXu.msgId), Boolean.valueOf(localtr.hXu.hXG));
      AppMethodBeat.o(253896);
      return paramContext;
    }
  }
  
  private static boolean b(Context paramContext, List<cc> paramList, boolean paramBoolean, String paramString, com.tencent.mm.message.z paramz)
  {
    AppMethodBeat.i(253874);
    if (m.nq(paramList))
    {
      k.a(paramContext, paramContext.getString(R.l.gDk), "", paramContext.getString(R.l.gps), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253605);
          if (n.this != null) {
            n.this.a(z.a.nVv);
          }
          AppMethodBeat.o(253605);
        }
      });
      AppMethodBeat.o(253874);
      return false;
    }
    if (m.nr(paramList))
    {
      k.a(paramContext, paramContext.getString(R.l.gDj), "", paramContext.getString(R.l.gps), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253608);
          if (n.this != null) {
            n.this.a(z.a.nVv);
          }
          AppMethodBeat.o(253608);
        }
      });
      AppMethodBeat.o(253874);
      return false;
    }
    Object localObject = aehk;
    paramList = f(paramContext, paramList);
    ((a)localObject).aehr = paramList;
    aehk.aedO = paramBoolean;
    aehk.aehs = new WeakReference(paramz);
    aehk.from = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    if ((paramz != null) && (paramz.bwu())) {
      localIntent.putExtra("Retr_MsgFromMoreSelectRetransmit", true);
    }
    cc localcc;
    String str;
    int j;
    if (paramList.size() == 1)
    {
      localcc = (cc)paramList.get(0);
      if ((localcc.fxR()) || (localcc.iYe()))
      {
        paramList = ad.Jo(localcc.field_msgSvrId);
        localObject = ad.bCb().M(paramList, true);
        ((ad.b)localObject).q("prePublishId", "msg_" + localcc.field_msgSvrId);
        ((ad.b)localObject).q("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(localcc, paramBoolean, false));
        ((ad.b)localObject).q("preChatName", localcc.field_talker);
        ((ad.b)localObject).q("preMsgIndex", Integer.valueOf(0));
        ((ad.b)localObject).q("sendAppMsgScene", Integer.valueOf(1));
        ((ad.b)localObject).q("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((ad.b)localObject).q("fromScene", Integer.valueOf(2));
          ((l)com.tencent.mm.kernel.h.ax(l.class)).a("adExtStr", (ad.b)localObject, localcc);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localcc.field_content;
        i = 12;
        if (!localcc.fxT()) {
          break label683;
        }
        j = 9;
        paramList = str;
        label422:
        if (!localcc.iYe()) {
          break label1539;
        }
      }
    }
    label1539:
    for (int i = 1;; i = 2)
    {
      if ((paramz != null) && (!paramz.bws()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        label469:
        localIntent.putExtra("Retr_Msg_Id", localcc.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        localIntent.putExtra("scene_from", 17);
        if ((paramz == null) || (!paramz.bwt()))
        {
          paramList = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramList.aYi(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramList.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        o.nt(aehk.aehr);
        if ((paramz != null) && (paramz.bwt())) {
          paramz.O(localIntent.getExtras());
        }
        AppMethodBeat.o(253874);
        return true;
        ((ad.b)localObject).q("fromScene", Integer.valueOf(1));
        break;
        label683:
        if (localcc.jbG())
        {
          j = 5;
          localIntent.putExtra("Retr_File_Name", localcc.field_imgPath);
          paramList = str;
          break label422;
        }
        if ((localcc.jbB()) || (localcc.jbC()))
        {
          j = 8;
          paramList = str;
          break label422;
        }
        if (localcc.iYl())
        {
          i = 4;
          j = i;
          paramList = str;
          if (!paramBoolean) {
            break label422;
          }
          j = i;
          paramList = str;
          if (localcc.field_isSend != 0) {
            break label422;
          }
          paramList = br.JK(str);
          j = i;
          break label422;
        }
        if (localcc.iYk())
        {
          paramList = null;
          if (localcc.field_msgId > 0L) {
            paramList = r.bKa().H(localcc.field_talker, localcc.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.localId > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localcc.field_msgSvrId > 0L) {
              localObject = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.modelimage.h)localObject).offset >= ((com.tencent.mm.modelimage.h)localObject).osy) && (((com.tencent.mm.modelimage.h)localObject).osy != 0)) {}
          for (paramList = r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject), "", "");; paramList = r.bKa().X(localcc.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            j = 0;
            paramList = str;
            break;
          }
        }
        if (localcc.dSJ())
        {
          paramList = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.omT);
          }
          j = 11;
          localIntent.putExtra("Retr_File_Name", localcc.field_imgPath);
          paramList = str;
          break label422;
        }
        if (localcc.dSH())
        {
          paramList = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.omT);
          }
          j = 1;
          localIntent.putExtra("Retr_File_Name", localcc.field_imgPath);
          paramList = str;
          break label422;
        }
        if (localcc.dSI())
        {
          j = 1;
          paramList = str;
          break label422;
        }
        j = i;
        paramList = str;
        if (!localcc.fxR()) {
          break label422;
        }
        paramList = k.b.Hf(str);
        if ((paramList != null) && (71 == paramList.type)) {
          i = 26;
        }
        for (;;)
        {
          j = i;
          paramList = str;
          if (!localcc.iYe()) {
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
          else if ((paramList != null) && (88 == paramList.type))
          {
            i = 31;
          }
          else if ((paramList != null) && (82 == paramList.type))
          {
            i = 30;
          }
          else
          {
            if ((paramList != null) && (75 == paramList.type)) {}
            switch (q.f(paramList.nUd, paramList.nUa))
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
        break label469;
        localObject = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          ((ArrayList)localObject).add(Long.valueOf(((cc)paramList.next()).field_msgId));
        }
        localIntent.putExtra("Retr_Msg_Id_List", (Serializable)localObject);
        if (((paramz != null) && (paramz.bws())) || ((com.tencent.mm.model.ab.IS(paramString)) && (!g.Dn(paramString))) || (com.tencent.mm.model.ab.IW(paramString)))
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
  
  private static LinkedList<cc> f(Context paramContext, List<cc> paramList)
  {
    AppMethodBeat.i(253866);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      paramList = localcc;
      if (bt.F(localcc))
      {
        paramList = new cc();
        paramList.setType(localcc.getType());
        paramList.setCreateTime(localcc.getCreateTime());
        paramList.BX(localcc.aJO());
        paramList.BS(localcc.field_talker);
        paramList.BY(localcc.aJP());
        switch (paramList.getType() & 0xFFFF)
        {
        }
      }
      for (;;)
      {
        bt.V(paramList);
        localLinkedList.add(paramList);
        break;
        paramList.setContent(paramContext.getString(R.l.app_text));
        continue;
        paramList.setContent(paramContext.getString(R.l.app_pic));
        paramList.setType(1);
        continue;
        paramList.setContent(paramContext.getString(R.l.app_video));
        paramList.setType(1);
        continue;
        paramList.setContent(paramContext.getString(R.l.app_unknown_msg));
        paramList.setType(1);
        continue;
        paramList.setContent(paramContext.getString(R.l.app_unknown_msg));
        paramList.setType(1);
      }
    }
    AppMethodBeat.o(253866);
    return localLinkedList;
  }
  
  public static int jpg()
  {
    AppMethodBeat.i(253881);
    if (aehk.aehr != null)
    {
      int i = aehk.aehr.size();
      AppMethodBeat.o(253881);
      return i;
    }
    AppMethodBeat.o(253881);
    return 0;
  }
  
  public static List<cc> jph()
  {
    return aehk.aehr;
  }
  
  public static boolean jpi()
  {
    AppMethodBeat.i(34449);
    if ((aehk.aehr == null) || (aehk.aehr.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = aehk.aehr.iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      bh.bCz();
      cc.a locala = com.tencent.mm.model.c.bzD().aLU(localcc.field_content);
      if ((locala.hgk == null) || (locala.hgk.length() <= 0)) {
        Log.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!com.tencent.mm.model.ab.uY(locala.WAW)) && (localcc.getType() == 42) && (localcc.jbV()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void jpj()
  {
    aehk.aehr = null;
    aehk.aedO = false;
    aehk.aehs = null;
    aehk.from = null;
    aehk.hWG = null;
    aehk.aeht = null;
  }
  
  public static Pair<Long, Boolean> m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(253887);
    paramContext = b(paramContext, paramString, paramBoolean, paramString);
    AppMethodBeat.o(253887);
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
    if ((aehk.aehr == null) || (aehk.aehr.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.component.o.aeqs.add(new QueueWorkerThread.ThreadObject()
    {
      public final boolean doInBackground()
      {
        AppMethodBeat.i(253611);
        if (n.jpk().aehr == null)
        {
          AppMethodBeat.o(253611);
          return false;
        }
        Iterator localIterator = n.jpk().aehr.iterator();
        while (localIterator.hasNext())
        {
          cc localcc = (cc)localIterator.next();
          n.d(n.this, paramString, localcc, n.jpk().aedO);
        }
        AppMethodBeat.o(253611);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(253621);
        if (n.jpk().aehr != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(n.jpk().aehr.size()), Integer.valueOf(n.jpk().aehr.size() - m.no(n.jpk().aehr)) });
        }
        Object localObject1 = n.jpk().aehr;
        if (localObject1 != null)
        {
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (cc)((Iterator)localObject1).next();
            if (((cc)localObject2).fxR())
            {
              localObject2 = k.b.Hf(Util.processXml(((fi)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                f localf = (f)((k.b)localObject2).aK(f.class);
                if (localf != null) {
                  localLinkedList1.add(new Pair(localf.oUc.objectId, localf.oUc.objectNonceId));
                }
              }
              if ((localObject2 != null) && (((k.b)localObject2).type == 71))
              {
                localObject2 = (com.tencent.mm.plugin.findersdk.a.j)((k.b)localObject2).aK(com.tencent.mm.plugin.findersdk.a.j.class);
                if (localObject2 != null) {
                  localLinkedList2.add(new Pair(((com.tencent.mm.plugin.findersdk.a.j)localObject2).oUe.objectId, ((com.tencent.mm.plugin.findersdk.a.j)localObject2).oUe.objectNonceId));
                }
              }
            }
          }
          if (localLinkedList1.size() > 0) {
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport(localLinkedList1, false);
          }
          if (localLinkedList2.size() > 0) {
            ((cn)com.tencent.mm.kernel.h.az(cn.class)).shareStatsReport(localLinkedList2, true);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            Log.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if ((n.jpk().aehs != null) && (n.jpk().aehs.get() != null)) {
            ((com.tencent.mm.message.z)n.jpk().aehs.get()).c(z.a.nVv);
          }
          n.jpj();
        }
        AppMethodBeat.o(253621);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  public static tr nk(Context paramContext)
  {
    AppMethodBeat.i(34448);
    tr localtr = new tr();
    localtr.hXt.type = 10;
    localtr.hXt.hXy = aehk.aehr;
    localtr.hXt.from = aehk.from;
    localtr.hXt.context = paramContext;
    localtr.publish();
    aehk.hWG = localtr.hXu.hWG;
    aehk.aeht = localtr.hXu.hXA;
    AppMethodBeat.o(34448);
    return localtr;
  }
  
  static final class a
  {
    boolean aedO;
    List<cc> aehr;
    WeakReference<com.tencent.mm.message.z> aehs;
    com.tencent.mm.protocal.b.a.d aeht;
    String from;
    dn hWG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n
 * JD-Core Version:    0.7.0.1
 */