package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.t.a;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  private static k.a zyl;
  
  static
  {
    AppMethodBeat.i(30589);
    zyl = new k.a((byte)0);
    AppMethodBeat.o(30589);
  }
  
  public static void a(Context paramContext, List<bi> paramList, boolean paramBoolean, String paramString, com.tencent.mm.af.t paramt)
  {
    AppMethodBeat.i(153827);
    dGm();
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(153827);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(153827);
      return;
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (!ab.aP((bi)((Iterator)localObject1).next()))
      {
        com.tencent.mm.ui.base.t.makeText(paramContext, 2131302018, 0).show();
        AppMethodBeat.o(153827);
        return;
      }
    }
    if (!j.a(false, paramList, paramt))
    {
      com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131300748), "", paramContext.getString(2131297067), paramContext.getString(2131296888), new k.1(paramList, paramt, paramContext, paramBoolean, paramString), null);
      AppMethodBeat.o(153827);
      return;
    }
    label176:
    int i;
    Iterator localIterator;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label254;
      i = 1;
      if (i == 0) {
        break label576;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if ((paramt == null) || ((!paramt.Yr()) && (paramList.size() != 1))) {
        break label585;
      }
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131299496), paramContext.getString(2131297087), new k.2());
      AppMethodBeat.o(153827);
    }
    else
    {
      localIterator = paramList.iterator();
    }
    label393:
    label570:
    label574:
    for (;;)
    {
      label254:
      if (!localIterator.hasNext()) {
        break label176;
      }
      bi localbi = (bi)localIterator.next();
      Object localObject3 = null;
      if (localbi.dyc()) {
        break;
      }
      Object localObject2;
      if (localbi.dvX())
      {
        localObject1 = null;
        if (localbi.field_msgId > 0L) {
          localObject1 = com.tencent.mm.at.o.ahC().gT(localbi.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localbi.field_msgSvrId > 0L) {
            localObject2 = com.tencent.mm.at.o.ahC().gS(localbi.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject2), "", "");
        }
        if ((localbi.dvX()) || (localbi.byj()) || (localbi.byk()) || (j.aJ(localbi))) {
          if ((System.currentTimeMillis() - localbi.field_createTime <= 259200000L) || ((!bo.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.e.cN((String)localObject1)))) {
            break label570;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label574;
        }
        i = 0;
        break;
        if ((localbi.byk()) || (localbi.byj()))
        {
          com.tencent.mm.modelvideo.o.alE();
          localObject1 = com.tencent.mm.modelvideo.t.vf(localbi.field_imgPath);
          break label393;
        }
        if (localbi.bCn())
        {
          localObject2 = j.b.mY(localbi.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label393;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.l.alv(((j.b)localObject2).cmN);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label393;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
          break label393;
        }
        localObject1 = localbi.field_imgPath;
        break label393;
      }
    }
    label576:
    b(paramContext, paramList, paramBoolean, paramString, paramt);
    label585:
    AppMethodBeat.o(153827);
  }
  
  private static void b(Context paramContext, List<bi> paramList, boolean paramBoolean, String paramString, com.tencent.mm.af.t paramt)
  {
    AppMethodBeat.i(153828);
    if (j.fa(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131298859), "", paramContext.getString(2131296332), new k.3(paramt));
      AppMethodBeat.o(153828);
      return;
    }
    e(paramContext, paramList);
    zyl.zyt = new LinkedList(paramList);
    zyl.zvB = paramBoolean;
    zyl.zyb = paramt;
    zyl.cEG = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    bi localbi;
    Object localObject;
    String str;
    int i;
    if (paramList.size() == 1)
    {
      localbi = (bi)paramList.get(0);
      if ((localbi.bCn()) || (localbi.dvV()))
      {
        paramList = v.oQ(localbi.field_msgSvrId);
        localObject = v.aae().z(paramList, true);
        ((v.b)localObject).i("prePublishId", "msg_" + localbi.field_msgSvrId);
        ((v.b)localObject).i("preUsername", c.a(localbi, paramBoolean, false));
        ((v.b)localObject).i("preChatName", localbi.field_talker);
        ((v.b)localObject).i("preMsgIndex", Integer.valueOf(0));
        ((v.b)localObject).i("sendAppMsgScene", Integer.valueOf(1));
        ((v.b)localObject).i("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((v.b)localObject).i("fromScene", Integer.valueOf(2));
          ((i)com.tencent.mm.kernel.g.E(i.class)).a("adExtStr", (v.b)localObject, localbi);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localbi.field_content;
        i = 12;
        if (!localbi.bCp()) {
          break label490;
        }
        i = 9;
        paramList = str;
        label346:
        if (!localbi.dvV()) {
          break label1059;
        }
      }
    }
    label393:
    label1059:
    for (int j = 1;; j = 2)
    {
      if ((paramt != null) && (!paramt.Yr()))
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
        l.fc(zyl.zyt);
        AppMethodBeat.o(153828);
        return;
        ((v.b)localObject).i("fromScene", Integer.valueOf(1));
        break;
        label490:
        if (localbi.dxS())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbi.dxR())
        {
          i = 8;
          paramList = str;
          break label346;
        }
        if (localbi.isText())
        {
          j = 4;
          i = j;
          paramList = str;
          if (!paramBoolean) {
            break label346;
          }
          i = j;
          paramList = str;
          if (localbi.field_isSend != 0) {
            break label346;
          }
          paramList = bf.pv(str);
          i = j;
          break label346;
        }
        if (localbi.dvX())
        {
          paramList = null;
          if (localbi.field_msgId > 0L) {
            paramList = com.tencent.mm.at.o.ahC().gT(localbi.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.fDL > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localbi.field_msgSvrId > 0L) {
              localObject = com.tencent.mm.at.o.ahC().gS(localbi.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.at.e)localObject).offset >= ((com.tencent.mm.at.e)localObject).fsd) && (((com.tencent.mm.at.e)localObject).fsd != 0)) {}
          for (paramList = com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject), "", "");; paramList = com.tencent.mm.at.o.ahC().J(localbi.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = str;
            break;
          }
        }
        if (localbi.byk())
        {
          paramList = u.vr(localbi.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.fXx);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = str;
          break label346;
        }
        if (localbi.byj())
        {
          paramList = u.vr(localbi.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.fXx);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbi.field_imgPath);
          paramList = str;
          break label346;
        }
        paramList = str;
        if (!localbi.bCn()) {
          break label346;
        }
        paramList = j.b.mY(str);
        if ((paramList != null) && (19 == paramList.type)) {
          j = 10;
        }
        for (;;)
        {
          i = j;
          paramList = str;
          if (!localbi.dvV()) {
            break;
          }
          localIntent.putExtra("is_group_chat", paramBoolean);
          i = j;
          paramList = str;
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
        break label393;
        if (((paramt != null) && (paramt.Yr())) || ((com.tencent.mm.model.t.nU(paramString)) && (!com.tencent.mm.aj.f.lg(paramString))) || (com.tencent.mm.model.t.oE(paramString)))
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
  
  public static void dGm()
  {
    zyl.zyt = null;
    zyl.zvB = false;
    zyl.zyb = null;
    zyl.cEG = null;
    zyl.cDZ = null;
    zyl.zyu = null;
  }
  
  private static void e(Context paramContext, List<bi> paramList)
  {
    AppMethodBeat.i(30581);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if (bh.o(localbi))
      {
        switch (localbi.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bh.p(localbi);
          break;
          localbi.setContent(paramContext.getString(2131297085));
          continue;
          localbi.setContent(paramContext.getString(2131297036));
          localbi.setType(1);
          continue;
          localbi.setContent(paramContext.getString(2131297102));
          localbi.setType(1);
          continue;
          localbi.setContent(paramContext.getString(2131297095));
          localbi.setType(1);
        }
      }
    }
    AppMethodBeat.o(30581);
  }
  
  public static oa il(Context paramContext)
  {
    AppMethodBeat.i(30585);
    oa localoa = new oa();
    localoa.cEz.type = 6;
    localoa.cEz.cEF = zyl.zyt;
    localoa.cEz.cEG = zyl.cEG;
    localoa.cEz.context = paramContext;
    a.ymk.l(localoa);
    zyl.cDZ = localoa.cEA.cDZ;
    zyl.zyu = localoa.cEA.cEI;
    AppMethodBeat.o(30585);
    return localoa;
  }
  
  public static void k(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(30583);
    Object localObject = new oa();
    ((oa)localObject).cEz.type = 5;
    ((oa)localObject).cEz.cEF = zyl.zyt;
    ((oa)localObject).cEz.toUser = paramString;
    ((oa)localObject).cEz.cEG = zyl.cEG;
    ((oa)localObject).cEz.context = paramContext;
    ((oa)localObject).cEz.cDZ = zyl.cDZ;
    ((oa)localObject).cEz.cEI = zyl.zyu;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    long l;
    j.b localb;
    if (zyl.zyt != null)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(zyl.zyt.size()), Integer.valueOf(zyl.zyt.size() - j.eY(zyl.zyt)) });
      localObject = zyl.zyt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramContext = (bi)((Iterator)localObject).next();
        l = bo.aox();
        localb = j.b.mY(bo.apU(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!bo.isNullOrNil(localb.url))) {
          if (!paramContext.dvV()) {
            break label441;
          }
        }
      }
    }
    label441:
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
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString, "", new Object[0]);
        }
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((paramBoolean) && (zyl.zyb != null)) {
        zyl.zyb.c(t.a.fke);
      }
      AppMethodBeat.o(30583);
      return;
    }
  }
  
  public static void l(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(30586);
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(30586);
      return;
    }
    if ((zyl.zyt == null) || (zyl.zyt.isEmpty()))
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(30586);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.c.j.zEQ.e(new az.a()
    {
      public final boolean acS()
      {
        AppMethodBeat.i(30576);
        if (k.dGn().zyt == null)
        {
          AppMethodBeat.o(30576);
          return false;
        }
        Iterator localIterator = k.dGn().zyt.iterator();
        while (localIterator.hasNext())
        {
          bi localbi = (bi)localIterator.next();
          k.d(this.val$context, paramString, localbi, k.dGn().zvB);
        }
        AppMethodBeat.o(30576);
        return true;
      }
      
      public final boolean acT()
      {
        AppMethodBeat.i(30577);
        if (k.dGn().zyt != null) {
          com.tencent.mm.plugin.report.service.h.qsU.e(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(k.dGn().zyt.size()), Integer.valueOf(k.dGn().zyt.size() - j.eY(k.dGn().zyt)) });
        }
        if (paramBoolean)
        {
          if (this.bZt != null)
          {
            com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.bZt.run();
          }
          if (k.dGn().zyb != null) {
            k.dGn().zyb.c(t.a.fke);
          }
          k.dGm();
        }
        AppMethodBeat.o(30577);
        return true;
      }
    });
    AppMethodBeat.o(30586);
  }
  
  public static void qS(boolean paramBoolean)
  {
    AppMethodBeat.i(30584);
    if ((paramBoolean) && (zyl.zyb != null)) {
      zyl.zyb.c(t.a.fke);
    }
    AppMethodBeat.o(30584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */