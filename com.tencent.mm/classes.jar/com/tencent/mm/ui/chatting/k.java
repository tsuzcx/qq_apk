package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static a GmM;
  
  static
  {
    AppMethodBeat.i(34453);
    GmM = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void a(final Context paramContext, List<bl> paramList, final boolean paramBoolean, final String paramString, final z paramz)
  {
    AppMethodBeat.i(34443);
    eVm();
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
    Object localObject1 = paramList.iterator();
    Object localObject2;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bl)((Iterator)localObject1).next();
      if (!ab.bi((bl)localObject2))
      {
        com.tencent.mm.ui.base.t.makeText(paramContext, 2131761802, 0).show();
        AppMethodBeat.o(34443);
        return;
      }
      if ((paramz != null) && (paramz.apE()))
      {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqv, 0) == 1) {}
        for (i = 1; (i != 0) && (j.aY((bl)localObject2)); i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759586), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(34443);
          return;
        }
        if ((i != 0) && (j.aZ((bl)localObject2)))
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759587), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(34443);
          return;
        }
      }
    }
    if (!j.a(false, paramList, paramString, paramz))
    {
      com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131755884), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34437);
          paramAnonymousDialogInterface = this.GmN;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            ad.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label30:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label205;
            }
            ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramz != null) {
              paramz.c(z.a.gLj);
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            bl localbl = (bl)paramAnonymousDialogInterface.next();
            if (j.aS(localbl)) {
              break label30;
            }
            if ((localbl.eJN()) || (j.aN(localbl)) || (j.aP(localbl)) || (j.ba(localbl)) || (j.aQ(localbl)) || (localbl.getType() == -1879048186) || (j.aX(localbl)) || (j.aR(localbl)) || (j.aW(localbl)) || (j.aS(localbl)) || (localbl.getType() == 318767153) || (localbl.getType() == 788529201) || (localbl.getType() == 889192497)) {
              break;
            }
          }
          label205:
          k.c(paramContext, this.GmN, paramBoolean, paramString, paramz);
          AppMethodBeat.o(34437);
        }
      }, null);
      AppMethodBeat.o(34443);
      return;
    }
    label304:
    Iterator localIterator;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label382;
      i = 1;
      if (i == 0) {
        break label704;
      }
      ad.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if ((paramz == null) || ((!paramz.apE()) && (paramList.size() != 1))) {
        break label713;
      }
      com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131758628), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(34443);
    }
    else
    {
      localIterator = paramList.iterator();
    }
    label521:
    label698:
    label702:
    for (;;)
    {
      label382:
      if (!localIterator.hasNext()) {
        break label304;
      }
      bl localbl = (bl)localIterator.next();
      Object localObject3 = null;
      if (localbl.eMl()) {
        break;
      }
      if (localbl.eJO())
      {
        localObject1 = null;
        if (localbl.field_msgId > 0L) {
          localObject1 = com.tencent.mm.aw.o.ayF().ms(localbl.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).deI > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localbl.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.aw.o.ayF().mr(localbl.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c((e)localObject2), "", "");
        }
        if ((localbl.eJO()) || (localbl.cjM()) || (localbl.cjO()) || (j.bc(localbl))) {
          if ((System.currentTimeMillis() - localbl.field_createTime <= 259200000L) || ((!bt.isNullOrNil((String)localObject1)) && (i.eK((String)localObject1)))) {
            break label698;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label702;
        }
        i = 0;
        break;
        if ((localbl.cjO()) || (localbl.cjM()))
        {
          com.tencent.mm.modelvideo.o.aCI();
          localObject1 = com.tencent.mm.modelvideo.t.zQ(localbl.field_imgPath);
          break label521;
        }
        if (localbl.cxB())
        {
          localObject2 = k.b.rx(localbl.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label521;
          }
          localObject2 = m.aAV(((k.b)localObject2).dbA);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label521;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label521;
        }
        localObject1 = localbl.field_imgPath;
        break label521;
      }
    }
    label704:
    b(paramContext, paramList, paramBoolean, paramString, paramz);
    label713:
    AppMethodBeat.o(34443);
  }
  
  private static void b(Context paramContext, List<bl> paramList, boolean paramBoolean, String paramString, z paramz)
  {
    AppMethodBeat.i(34445);
    if (j.hx(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757937), "", paramContext.getString(2131755012), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34438);
          if (this.GmO != null) {
            this.GmO.a(z.a.gLj);
          }
          AppMethodBeat.o(34438);
        }
      });
      AppMethodBeat.o(34445);
      return;
    }
    e(paramContext, paramList);
    GmM.GmU = new LinkedList(paramList);
    GmM.GjM = paramBoolean;
    GmM.GmC = paramz;
    GmM.dvh = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    bl localbl;
    Object localObject;
    String str;
    int i;
    if (paramList.size() == 1)
    {
      localbl = (bl)paramList.get(0);
      if ((localbl.cxB()) || (localbl.eJL()))
      {
        paramList = y.tD(localbl.field_msgSvrId);
        localObject = y.arz().E(paramList, true);
        ((y.b)localObject).m("prePublishId", "msg_" + localbl.field_msgSvrId);
        ((y.b)localObject).m("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localbl, paramBoolean, false));
        ((y.b)localObject).m("preChatName", localbl.field_talker);
        ((y.b)localObject).m("preMsgIndex", Integer.valueOf(0));
        ((y.b)localObject).m("sendAppMsgScene", Integer.valueOf(1));
        ((y.b)localObject).m("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((y.b)localObject).m("fromScene", Integer.valueOf(2));
          ((com.tencent.mm.plugin.sns.c.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.j.class)).a("adExtStr", (y.b)localObject, localbl);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localbl.field_content;
        i = 12;
        if (!localbl.cxD()) {
          break label557;
        }
        i = 9;
        paramList = str;
        label346:
        if (!localbl.eJL()) {
          break label1163;
        }
      }
    }
    label393:
    label1163:
    for (int j = 1;; j = 2)
    {
      if ((paramz != null) && (!paramz.apE()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localbl.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
        i = j;
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        paramList = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.adn(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramList.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        l.hz(GmM.GmU);
        AppMethodBeat.o(34445);
        return;
        ((y.b)localObject).m("fromScene", Integer.valueOf(1));
        break;
        label557:
        if (localbl.eLY())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbl.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbl.eLX())
        {
          i = 8;
          paramList = str;
          break label346;
        }
        if (localbl.isText())
        {
          j = 4;
          i = j;
          paramList = str;
          if (!paramBoolean) {
            break label346;
          }
          i = j;
          paramList = str;
          if (localbl.field_isSend != 0) {
            break label346;
          }
          paramList = bi.ug(str);
          i = j;
          break label346;
        }
        if (localbl.eJO())
        {
          paramList = null;
          if (localbl.field_msgId > 0L) {
            paramList = com.tencent.mm.aw.o.ayF().ms(localbl.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.deI > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localbl.field_msgSvrId > 0L) {
              localObject = com.tencent.mm.aw.o.ayF().mr(localbl.field_msgSvrId);
            }
          }
          if ((((e)localObject).offset >= ((e)localObject).gTY) && (((e)localObject).gTY != 0)) {}
          for (paramList = com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c((e)localObject), "", "");; paramList = com.tencent.mm.aw.o.ayF().Q(localbl.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = str;
            break;
          }
        }
        if (localbl.cjO())
        {
          paramList = u.Ae(localbl.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.gOY);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbl.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbl.cjM())
        {
          paramList = u.Ae(localbl.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.gOY);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbl.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbl.cjN())
        {
          i = 1;
          paramList = str;
          break label346;
        }
        paramList = str;
        if (!localbl.cxB()) {
          break label346;
        }
        paramList = k.b.rx(str);
        if ((paramList != null) && (51 == paramList.type)) {
          j = 18;
        }
        for (;;)
        {
          i = j;
          paramList = str;
          if (!localbl.eJL()) {
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
        if (((paramz != null) && (paramz.apE())) || ((w.sE(paramString)) && (!com.tencent.mm.am.f.pc(paramString))) || (w.tp(paramString)))
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
  
  private static void e(Context paramContext, List<bl> paramList)
  {
    AppMethodBeat.i(34444);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if (bk.x(localbl))
      {
        switch (localbl.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bk.A(localbl);
          break;
          localbl.setContent(paramContext.getString(2131755904));
          continue;
          localbl.setContent(paramContext.getString(2131755853));
          localbl.setType(1);
          continue;
          localbl.setContent(paramContext.getString(2131755926));
          localbl.setType(1);
          continue;
          localbl.setContent(paramContext.getString(2131755914));
          localbl.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static boolean eVl()
  {
    AppMethodBeat.i(34449);
    if ((GmM.GmU == null) || (GmM.GmU.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = GmM.GmU.iterator();
    while (localIterator.hasNext())
    {
      bl localbl = (bl)localIterator.next();
      az.arV();
      bl.a locala = com.tencent.mm.model.c.apO().agC(localbl.field_content);
      if ((locala.yGA == null) || (locala.yGA.length() <= 0)) {
        ad.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!w.mZ(locala.AOL)) && (localbl.getType() == 42) && (localbl.eMn()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void eVm()
  {
    GmM.GmU = null;
    GmM.GjM = false;
    GmM.GmC = null;
    GmM.dvh = null;
    GmM.duB = null;
    GmM.GmV = null;
  }
  
  public static pn jN(Context paramContext)
  {
    AppMethodBeat.i(34448);
    pn localpn = new pn();
    localpn.dvb.type = 6;
    localpn.dvb.dvg = GmM.GmU;
    localpn.dvb.dvh = GmM.dvh;
    localpn.dvb.context = paramContext;
    com.tencent.mm.sdk.b.a.ESL.l(localpn);
    GmM.duB = localpn.dvc.duB;
    GmM.GmV = localpn.dvc.dvj;
    AppMethodBeat.o(34448);
    return localpn;
  }
  
  public static void m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(34446);
    Object localObject = new pn();
    ((pn)localObject).dvb.type = 5;
    ((pn)localObject).dvb.dvg = GmM.GmU;
    ((pn)localObject).dvb.toUser = paramString;
    ((pn)localObject).dvb.dvh = GmM.dvh;
    ((pn)localObject).dvb.context = paramContext;
    ((pn)localObject).dvb.duB = GmM.duB;
    ((pn)localObject).dvb.dvj = GmM.GmV;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    k.b localb;
    if (GmM.GmU != null)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(GmM.GmU.size()), Integer.valueOf(GmM.GmU.size() - j.hv(GmM.GmU)) });
      localObject = new LinkedList();
      Iterator localIterator = GmM.GmU.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (bl)localIterator.next();
        l = bt.aGK();
        localb = k.b.rx(bt.aGg(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!bt.isNullOrNil(localb.url))) {
          if (!paramContext.eJL()) {
            break label525;
          }
        }
      }
    }
    label525:
    for (int i = 1;; i = 2)
    {
      paramContext = "";
      try
      {
        paramString = URLEncoder.encode(localb.url, "UTF-8");
        paramContext = paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString, "", new Object[0]);
        }
      }
      ad.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext == null) {
        break;
      }
      ((List)localObject).add(paramContext.htg.objectId);
      break;
      if (((List)localObject).size() > 0) {
        ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).shareStatsReport((List)localObject);
      }
      if ((paramBoolean) && (GmM.GmC != null)) {
        GmM.GmC.c(z.a.gLj);
      }
      AppMethodBeat.o(34446);
      return;
    }
  }
  
  public static void n(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34450);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(34450);
      return;
    }
    if ((GmM.GmU == null) || (GmM.GmU.isEmpty()))
    {
      ad.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    ad.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.c.k.Gtr.c(new be.a()
    {
      public final boolean aus()
      {
        AppMethodBeat.i(34439);
        if (k.eVn().GmU == null)
        {
          AppMethodBeat.o(34439);
          return false;
        }
        Iterator localIterator = k.eVn().GmU.iterator();
        while (localIterator.hasNext())
        {
          bl localbl = (bl)localIterator.next();
          k.e(this.val$context, paramString, localbl, k.eVn().GjM);
        }
        AppMethodBeat.o(34439);
        return true;
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(34440);
        if (k.eVn().GmU != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(k.eVn().GmU.size()), Integer.valueOf(k.eVn().GmU.size() - j.hv(k.eVn().GmU)) });
        }
        Object localObject1 = k.eVn().GmU;
        if (localObject1 != null)
        {
          LinkedList localLinkedList = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bl)((Iterator)localObject1).next();
            if (((bl)localObject2).cxB())
            {
              localObject2 = k.b.rx(bt.aGg(((du)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject2).ao(com.tencent.mm.plugin.i.a.b.class);
                if (localObject2 != null) {
                  localLinkedList.add(((com.tencent.mm.plugin.i.a.b)localObject2).htg.objectId);
                }
              }
            }
          }
          if (localLinkedList.size() > 0) {
            ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).shareStatsReport(localLinkedList);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            ad.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (k.eVn().GmC != null) {
            k.eVn().GmC.c(z.a.gLj);
          }
          k.eVm();
        }
        AppMethodBeat.o(34440);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  public static void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (GmM.GmC != null)) {
      GmM.GmC.c(z.a.gLj);
    }
    AppMethodBeat.o(34447);
  }
  
  static final class a
  {
    boolean GjM;
    z GmC;
    List<bl> GmU;
    com.tencent.mm.protocal.b.a.d GmV;
    cs duB;
    String dvh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */