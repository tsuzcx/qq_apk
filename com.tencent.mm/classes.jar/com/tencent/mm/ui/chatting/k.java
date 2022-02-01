package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.av.e;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
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
  private static a HMC;
  
  static
  {
    AppMethodBeat.i(34453);
    HMC = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static void a(final Context paramContext, List<bo> paramList, final boolean paramBoolean, final String paramString, final z paramz)
  {
    AppMethodBeat.i(34443);
    fkY();
    if (paramContext == null)
    {
      ac.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(34443);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(34443);
      return;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bo)((Iterator)localObject1).next();
      if (!ab.bk((bo)localObject2))
      {
        com.tencent.mm.ui.base.t.makeText(paramContext, 2131761802, 0).show();
        AppMethodBeat.o(34443);
        return;
      }
      if ((paramz != null) && (paramz.awt()))
      {
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUi, 0) == 1) {}
        for (i = 1; (i != 0) && (j.ba((bo)localObject2)); i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759586), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(34443);
          return;
        }
        if ((i != 0) && (j.bb((bo)localObject2)))
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
          paramAnonymousDialogInterface = this.HMD;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            ac.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label30:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label205;
            }
            ac.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramz != null) {
              paramz.c(z.a.hlJ);
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            bo localbo = (bo)paramAnonymousDialogInterface.next();
            if (j.aU(localbo)) {
              break label30;
            }
            if ((localbo.eZl()) || (j.aP(localbo)) || (j.aR(localbo)) || (j.bc(localbo)) || (j.aS(localbo)) || (localbo.getType() == -1879048186) || (j.aZ(localbo)) || (j.aT(localbo)) || (j.aY(localbo)) || (j.aU(localbo)) || (localbo.getType() == 318767153) || (localbo.getType() == 788529201) || (localbo.getType() == 889192497)) {
              break;
            }
          }
          label205:
          k.c(paramContext, this.HMD, paramBoolean, paramString, paramz);
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
      ac.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label382;
      i = 1;
      if (i == 0) {
        break label704;
      }
      ac.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if ((paramz == null) || ((!paramz.awt()) && (paramList.size() != 1))) {
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
      bo localbo = (bo)localIterator.next();
      Object localObject3 = null;
      if (localbo.fbQ()) {
        break;
      }
      if (localbo.eZm())
      {
        localObject1 = null;
        if (localbo.field_msgId > 0L) {
          localObject1 = com.tencent.mm.av.o.aFx().qg(localbo.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((e)localObject1).dcd > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localbo.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c((e)localObject2), "", "");
        }
        if ((localbo.eZm()) || (localbo.crt()) || (localbo.crv()) || (j.be(localbo))) {
          if ((System.currentTimeMillis() - localbo.field_createTime <= 259200000L) || ((!bs.isNullOrNil((String)localObject1)) && (i.eA((String)localObject1)))) {
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
        if ((localbo.crv()) || (localbo.crt()))
        {
          com.tencent.mm.modelvideo.o.aJy();
          localObject1 = com.tencent.mm.modelvideo.t.DV(localbo.field_imgPath);
          break label521;
        }
        if (localbo.cKN())
        {
          localObject2 = k.b.vA(localbo.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label521;
          }
          localObject2 = m.aGn(((k.b)localObject2).cZa);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label521;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label521;
        }
        localObject1 = localbo.field_imgPath;
        break label521;
      }
    }
    label704:
    b(paramContext, paramList, paramBoolean, paramString, paramz);
    label713:
    AppMethodBeat.o(34443);
  }
  
  private static void b(Context paramContext, List<bo> paramList, boolean paramBoolean, String paramString, z paramz)
  {
    AppMethodBeat.i(34445);
    if (j.hK(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757937), "", paramContext.getString(2131755012), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34438);
          if (this.HME != null) {
            this.HME.a(z.a.hlJ);
          }
          AppMethodBeat.o(34438);
        }
      });
      AppMethodBeat.o(34445);
      return;
    }
    e(paramContext, paramList);
    HMC.HMK = new LinkedList(paramList);
    HMC.HJB = paramBoolean;
    HMC.HMs = paramz;
    HMC.dsT = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    bo localbo;
    Object localObject;
    String str;
    int i;
    if (paramList.size() == 1)
    {
      localbo = (bo)paramList.get(0);
      if ((localbo.cKN()) || (localbo.eZj()))
      {
        paramList = y.xJ(localbo.field_msgSvrId);
        localObject = y.ayq().F(paramList, true);
        ((y.b)localObject).l("prePublishId", "msg_" + localbo.field_msgSvrId);
        ((y.b)localObject).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localbo, paramBoolean, false));
        ((y.b)localObject).l("preChatName", localbo.field_talker);
        ((y.b)localObject).l("preMsgIndex", Integer.valueOf(0));
        ((y.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
        ((y.b)localObject).l("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((y.b)localObject).l("fromScene", Integer.valueOf(2));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject, localbo);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localbo.field_content;
        i = 12;
        if (!localbo.cKP()) {
          break label557;
        }
        i = 9;
        paramList = str;
        label346:
        if (!localbo.eZj()) {
          break label1163;
        }
      }
    }
    label393:
    label1163:
    for (int j = 1;; j = 2)
    {
      if ((paramz != null) && (!paramz.awt()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localbo.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
        i = j;
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        paramList = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.aeD(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramList.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        l.hM(HMC.HMK);
        AppMethodBeat.o(34445);
        return;
        ((y.b)localObject).l("fromScene", Integer.valueOf(1));
        break;
        label557:
        if (localbo.fbC())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbo.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbo.fbB())
        {
          i = 8;
          paramList = str;
          break label346;
        }
        if (localbo.isText())
        {
          j = 4;
          i = j;
          paramList = str;
          if (!paramBoolean) {
            break label346;
          }
          i = j;
          paramList = str;
          if (localbo.field_isSend != 0) {
            break label346;
          }
          paramList = bi.ym(str);
          i = j;
          break label346;
        }
        if (localbo.eZm())
        {
          paramList = null;
          if (localbo.field_msgId > 0L) {
            paramList = com.tencent.mm.av.o.aFx().qg(localbo.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.dcd > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localbo.field_msgSvrId > 0L) {
              localObject = com.tencent.mm.av.o.aFx().qf(localbo.field_msgSvrId);
            }
          }
          if ((((e)localObject).offset >= ((e)localObject).hux) && (((e)localObject).hux != 0)) {}
          for (paramList = com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c((e)localObject), "", "");; paramList = com.tencent.mm.av.o.aFx().R(localbo.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = str;
            break;
          }
        }
        if (localbo.crv())
        {
          paramList = u.Ej(localbo.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hpy);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbo.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbo.crt())
        {
          paramList = u.Ej(localbo.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hpy);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbo.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbo.cru())
        {
          i = 1;
          paramList = str;
          break label346;
        }
        paramList = str;
        if (!localbo.cKN()) {
          break label346;
        }
        paramList = k.b.vA(str);
        if ((paramList != null) && (51 == paramList.type)) {
          j = 18;
        }
        for (;;)
        {
          i = j;
          paramList = str;
          if (!localbo.eZj()) {
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
        if (((paramz != null) && (paramz.awt())) || ((w.wH(paramString)) && (!com.tencent.mm.al.f.so(paramString))) || (w.xs(paramString)))
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
  
  private static void e(Context paramContext, List<bo> paramList)
  {
    AppMethodBeat.i(34444);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      if (bk.x(localbo))
      {
        switch (localbo.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bk.A(localbo);
          break;
          localbo.setContent(paramContext.getString(2131755904));
          continue;
          localbo.setContent(paramContext.getString(2131755853));
          localbo.setType(1);
          continue;
          localbo.setContent(paramContext.getString(2131755926));
          localbo.setType(1);
          continue;
          localbo.setContent(paramContext.getString(2131755914));
          localbo.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static boolean fkX()
  {
    AppMethodBeat.i(34449);
    if ((HMC.HMK == null) || (HMC.HMK.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = HMC.HMK.iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      az.ayM();
      bo.a locala = com.tencent.mm.model.c.awD().alw(localbo.field_content);
      if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
        ac.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!w.nN(locala.Chb)) && (localbo.getType() == 42) && (localbo.fbS()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void fkY()
  {
    HMC.HMK = null;
    HMC.HJB = false;
    HMC.HMs = null;
    HMC.dsT = null;
    HMC.dsm = null;
    HMC.HML = null;
  }
  
  public static pw jY(Context paramContext)
  {
    AppMethodBeat.i(34448);
    pw localpw = new pw();
    localpw.dsN.type = 6;
    localpw.dsN.dsS = HMC.HMK;
    localpw.dsN.dsT = HMC.dsT;
    localpw.dsN.context = paramContext;
    com.tencent.mm.sdk.b.a.GpY.l(localpw);
    HMC.dsm = localpw.dsO.dsm;
    HMC.HML = localpw.dsO.dsV;
    AppMethodBeat.o(34448);
    return localpw;
  }
  
  public static void l(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(34446);
    Object localObject = new pw();
    ((pw)localObject).dsN.type = 5;
    ((pw)localObject).dsN.dsS = HMC.HMK;
    ((pw)localObject).dsN.toUser = paramString;
    ((pw)localObject).dsN.dsT = HMC.dsT;
    ((pw)localObject).dsN.context = paramContext;
    ((pw)localObject).dsN.dsm = HMC.dsm;
    ((pw)localObject).dsN.dsV = HMC.HML;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    k.b localb;
    if (HMC.HMK != null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(HMC.HMK.size()), Integer.valueOf(HMC.HMK.size() - j.hI(HMC.HMK)) });
      localObject = new LinkedList();
      Iterator localIterator = HMC.HMK.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (bo)localIterator.next();
        l = bs.aNx();
        localb = k.b.vA(bs.aLx(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!bs.isNullOrNil(localb.url))) {
          if (!paramContext.eZj()) {
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
          ac.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString, "", new Object[0]);
        }
      }
      ac.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext == null) {
        break;
      }
      ((List)localObject).add(paramContext.hTI.objectId);
      break;
      if (((List)localObject).size() > 0) {
        ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).shareStatsReport((List)localObject);
      }
      if ((paramBoolean) && (HMC.HMs != null)) {
        HMC.HMs.c(z.a.hlJ);
      }
      AppMethodBeat.o(34446);
      return;
    }
  }
  
  public static void m(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34450);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(34450);
      return;
    }
    if ((HMC.HMK == null) || (HMC.HMK.isEmpty()))
    {
      ac.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    ac.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.c.k.HTk.c(new bd.a()
    {
      public final boolean aBj()
      {
        AppMethodBeat.i(34439);
        if (k.fkZ().HMK == null)
        {
          AppMethodBeat.o(34439);
          return false;
        }
        Iterator localIterator = k.fkZ().HMK.iterator();
        while (localIterator.hasNext())
        {
          bo localbo = (bo)localIterator.next();
          k.d(this.val$context, paramString, localbo, k.fkZ().HJB);
        }
        AppMethodBeat.o(34439);
        return true;
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(34440);
        if (k.fkZ().HMK != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(k.fkZ().HMK.size()), Integer.valueOf(k.fkZ().HMK.size() - j.hI(k.fkZ().HMK)) });
        }
        Object localObject1 = k.fkZ().HMK;
        if (localObject1 != null)
        {
          LinkedList localLinkedList = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bo)((Iterator)localObject1).next();
            if (((bo)localObject2).cKN())
            {
              localObject2 = k.b.vA(bs.aLx(((dy)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject2).ao(com.tencent.mm.plugin.i.a.b.class);
                if (localObject2 != null) {
                  localLinkedList.add(((com.tencent.mm.plugin.i.a.b)localObject2).hTI.objectId);
                }
              }
            }
          }
          if (localLinkedList.size() > 0) {
            ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).shareStatsReport(localLinkedList);
          }
        }
        if (paramBoolean)
        {
          if (this.val$callback != null)
          {
            ac.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (k.fkZ().HMs != null) {
            k.fkZ().HMs.c(z.a.hlJ);
          }
          k.fkY();
        }
        AppMethodBeat.o(34440);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  public static void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (HMC.HMs != null)) {
      HMC.HMs.c(z.a.hlJ);
    }
    AppMethodBeat.o(34447);
  }
  
  static final class a
  {
    boolean HJB;
    List<bo> HMK;
    com.tencent.mm.protocal.b.a.d HML;
    z HMs;
    String dsT;
    cs dsm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */