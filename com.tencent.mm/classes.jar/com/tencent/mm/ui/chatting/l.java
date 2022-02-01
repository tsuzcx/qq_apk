package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
{
  private static a JVj;
  
  static
  {
    AppMethodBeat.i(34453);
    JVj = new a((byte)0);
    AppMethodBeat.o(34453);
  }
  
  public static boolean a(final Context paramContext, List<bv> paramList, final boolean paramBoolean, final String paramString, final com.tencent.mm.ah.z paramz)
  {
    AppMethodBeat.i(187146);
    fFq();
    if (paramContext == null)
    {
      ae.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
      AppMethodBeat.o(187146);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
      AppMethodBeat.o(187146);
      return false;
    }
    int i;
    if ((paramz != null) && (!paramz.azv()))
    {
      i = com.tencent.mm.n.b.acs();
      localObject1 = h.JUT;
      if (h.h(paramList, i))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759076, new Object[] { bu.sL(i) }), "", paramContext.getString(2131766205), null);
        AppMethodBeat.o(187146);
        return false;
      }
      long l = com.tencent.mm.n.b.acv();
      localObject1 = h.JUT;
      if (h.g(paramList, l))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759065, new Object[] { bu.sL(l) }), "", paramContext.getString(2131766205), null);
        AppMethodBeat.o(187146);
        return false;
      }
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bv)((Iterator)localObject1).next();
      if (!ac.bm((bv)localObject2))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766957), "", paramContext.getString(2131766205), null);
        AppMethodBeat.o(187146);
        return false;
      }
      if (!ac.bn((bv)localObject2))
      {
        com.tencent.mm.ui.base.t.makeText(paramContext, 2131761802, 0).show();
        AppMethodBeat.o(187146);
        return false;
      }
      if ((paramz != null) && (paramz.azv()))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1) {}
        for (i = 1; (i != 0) && (k.bc((bv)localObject2)); i = 0)
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759586), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(187146);
          return false;
        }
        if ((i != 0) && (k.bd((bv)localObject2)))
        {
          com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759587), "", paramContext.getString(2131766205), null);
          AppMethodBeat.o(187146);
          return false;
        }
      }
    }
    if (!k.a(false, paramList, paramString, paramz)) {
      com.tencent.mm.ui.base.h.e(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131755884), paramContext.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34437);
          paramAnonymousDialogInterface = this.JVk;
          if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.isEmpty())) {
            ae.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to friend msg error, select item empty");
          }
          label30:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            if (paramAnonymousInt == 0) {
              break label233;
            }
            ae.w("MicroMsg.ChattingEditModeRetransmitMsg", "only contain invalid msg, exit long click mode");
            if (paramz != null)
            {
              paramz.c(z.a.hGL);
              if (paramz.azx()) {
                com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
              }
            }
            AppMethodBeat.o(34437);
            return;
            paramAnonymousDialogInterface = paramAnonymousDialogInterface.iterator();
            if (!paramAnonymousDialogInterface.hasNext()) {
              break label30;
            }
            bv localbv = (bv)paramAnonymousDialogInterface.next();
            if (k.aW(localbv)) {
              break label30;
            }
            if ((localbv.ftf()) || (k.aR(localbv)) || (k.aT(localbv)) || (k.be(localbv)) || (k.aU(localbv)) || (localbv.getType() == -1879048186) || (k.bb(localbv)) || (k.aV(localbv)) || (k.ba(localbv)) || (k.aW(localbv)) || (localbv.getType() == 318767153) || (localbv.getType() == 788529201) || (localbv.getType() == 889192497) || (localbv.getType() == 922746929)) {
              break;
            }
          }
          label233:
          if ((!l.c(paramContext, this.JVk, paramBoolean, paramString, paramz)) && (paramz != null) && (paramz.azx())) {
            com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
          }
          AppMethodBeat.o(34437);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187140);
          if ((this.JVl != null) && (this.JVl.azx())) {
            com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
          }
          AppMethodBeat.o(187140);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(187146);
      return true;
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
      ae.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      break label578;
      label486:
      i = 1;
      if (i == 0) {
        break label910;
      }
      ae.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
      if (paramz != null)
      {
        if ((paramz.azv()) || (paramList.size() == 1)) {
          com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131758628), paramContext.getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34438);
              AppMethodBeat.o(34438);
            }
          });
        }
        if (paramz.azx()) {
          com.tencent.mm.plugin.selectrecord.b.b.dQy().dQA();
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
      bv localbv = (bv)localIterator.next();
      Object localObject3 = null;
      if (localbv.fvU()) {
        break;
      }
      if (localbv.ftg())
      {
        localObject1 = null;
        if (localbv.field_msgId > 0L) {
          localObject1 = q.aIX().G(localbv.field_talker, localbv.field_msgId);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
        }
        else
        {
          localObject2 = localObject1;
          if (localbv.field_msgSvrId > 0L) {
            localObject2 = q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
          }
        }
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
        }
        label727:
        if ((localbv.ftg()) || (localbv.cyG()) || (localbv.cyI()) || (k.bg(localbv))) {
          if ((System.currentTimeMillis() - localbv.field_createTime <= 259200000L) || ((!bu.isNullOrNil((String)localObject1)) && (com.tencent.mm.vfs.o.fB((String)localObject1)))) {
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
        if ((localbv.cyI()) || (localbv.cyG()))
        {
          com.tencent.mm.modelvideo.o.aNh();
          localObject1 = com.tencent.mm.modelvideo.t.HJ(localbv.field_imgPath);
          break label727;
        }
        if (localbv.cVH())
        {
          localObject2 = k.b.zb(localbv.field_content);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label727;
          }
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.aNj(((k.b)localObject2).dlu);
          localObject1 = localObject3;
          if (localObject2 == null) {
            break label727;
          }
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          break label727;
        }
        localObject1 = localbv.field_imgPath;
        break label727;
      }
    }
    label910:
    paramBoolean = b(paramContext, paramList, paramBoolean, paramString, paramz);
    AppMethodBeat.o(187146);
    return paramBoolean;
  }
  
  private static boolean b(Context paramContext, List<bv> paramList, boolean paramBoolean, String paramString, com.tencent.mm.ah.z paramz)
  {
    AppMethodBeat.i(187147);
    if (k.ig(paramList))
    {
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757937), "", paramContext.getString(2131755012), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187141);
          if (this.JVl != null) {
            this.JVl.a(z.a.hGL);
          }
          AppMethodBeat.o(187141);
        }
      });
      AppMethodBeat.o(187147);
      return false;
    }
    e(paramContext, paramList);
    JVj.JVr = new LinkedList(paramList);
    JVj.JSi = paramBoolean;
    JVj.JUZ = paramz;
    JVj.dFY = paramString;
    Intent localIntent = new Intent(paramContext, MsgRetransmitUI.class);
    if ((paramz != null) && (paramz.azx())) {
      localIntent.putExtra("Retr_MsgFromMoreSelectRetransmit", true);
    }
    bv localbv;
    Object localObject;
    String str;
    int i;
    if (paramList.size() == 1)
    {
      localbv = (bv)paramList.get(0);
      if ((localbv.cVH()) || (localbv.fta()))
      {
        paramList = com.tencent.mm.model.z.Br(localbv.field_msgSvrId);
        localObject = com.tencent.mm.model.z.aBG().F(paramList, true);
        ((z.b)localObject).k("prePublishId", "msg_" + localbv.field_msgSvrId);
        ((z.b)localObject).k("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(localbv, paramBoolean, false));
        ((z.b)localObject).k("preChatName", localbv.field_talker);
        ((z.b)localObject).k("preMsgIndex", Integer.valueOf(0));
        ((z.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
        ((z.b)localObject).k("moreRetrAction", Boolean.TRUE);
        if (paramBoolean)
        {
          ((z.b)localObject).k("fromScene", Integer.valueOf(2));
          ((j)com.tencent.mm.kernel.g.ab(j.class)).a("adExtStr", (z.b)localObject, localbv);
          localIntent.putExtra("reportSessionId", paramList);
        }
      }
      else
      {
        str = localbv.field_content;
        i = 12;
        if (!localbv.cVJ()) {
          break label626;
        }
        i = 9;
        paramList = str;
        label372:
        if (!localbv.fta()) {
          break label1242;
        }
      }
    }
    label419:
    label1242:
    for (int j = 1;; j = 2)
    {
      if ((paramz != null) && (!paramz.azv()))
      {
        localIntent.putExtra("Retr_Msg_Type", 13);
        localIntent.putExtra("Retr_Multi_Msg_List_from", paramString);
        localIntent.putExtra("Retr_Msg_Id", localbv.field_msgId);
        localIntent.putExtra("Retr_Msg_content", paramList);
        localIntent.putExtra("Edit_Mode_Sigle_Msg", true);
        i = j;
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromScene", i);
        localIntent.putExtra("Retr_show_success_tips", true);
        if ((paramz == null) || (!paramz.azw()))
        {
          paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramList.ahE(), "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramList.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/ChattingEditModeRetransmitMsg", "doJob", "(Landroid/content/Context;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/mm/message/MsgJobCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        m.ii(JVj.JVr);
        if ((paramz != null) && (paramz.azw())) {
          paramz.v(localIntent.getExtras());
        }
        AppMethodBeat.o(187147);
        return true;
        ((z.b)localObject).k("fromScene", Integer.valueOf(1));
        break;
        label626:
        if (localbv.fvG())
        {
          i = 5;
          localIntent.putExtra("Retr_File_Name", localbv.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localbv.fvE())
        {
          i = 8;
          paramList = str;
          break label372;
        }
        if (localbv.isText())
        {
          j = 4;
          i = j;
          paramList = str;
          if (!paramBoolean) {
            break label372;
          }
          i = j;
          paramList = str;
          if (localbv.field_isSend != 0) {
            break label372;
          }
          paramList = bl.BN(str);
          i = j;
          break label372;
        }
        if (localbv.ftg())
        {
          paramList = null;
          if (localbv.field_msgId > 0L) {
            paramList = q.aIX().G(localbv.field_talker, localbv.field_msgId);
          }
          if (paramList != null)
          {
            localObject = paramList;
            if (paramList.doE > 0L) {}
          }
          else
          {
            localObject = paramList;
            if (localbv.field_msgSvrId > 0L) {
              localObject = q.aIX().F(localbv.field_talker, localbv.field_msgSvrId);
            }
          }
          if ((((com.tencent.mm.av.g)localObject).offset >= ((com.tencent.mm.av.g)localObject).hPI) && (((com.tencent.mm.av.g)localObject).hPI != 0)) {}
          for (paramList = q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject), "", "");; paramList = q.aIX().R(localbv.field_imgPath, true))
          {
            localIntent.putExtra("Retr_File_Name", paramList);
            i = 0;
            paramList = str;
            break;
          }
        }
        if (localbv.cyI())
        {
          paramList = u.Ia(localbv.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hKI);
          }
          i = 11;
          localIntent.putExtra("Retr_File_Name", localbv.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localbv.cyG())
        {
          paramList = u.Ia(localbv.field_imgPath);
          if (paramList != null) {
            localIntent.putExtra("Retr_length", paramList.hKI);
          }
          i = 1;
          localIntent.putExtra("Retr_File_Name", localbv.field_imgPath);
          paramList = str;
          break label372;
        }
        if (localbv.cyH())
        {
          i = 1;
          paramList = str;
          break label372;
        }
        paramList = str;
        if (!localbv.cVH()) {
          break label372;
        }
        paramList = k.b.zb(str);
        if ((paramList != null) && (51 == paramList.type)) {
          j = 18;
        }
        for (;;)
        {
          i = j;
          paramList = str;
          if (!localbv.fta()) {
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
        break label419;
        if (((paramz != null) && (paramz.azv())) || ((x.Ao(paramString)) && (!com.tencent.mm.al.g.vz(paramString))) || (x.Ba(paramString)))
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
    AppMethodBeat.i(187150);
    qi localqi = new qi();
    localqi.dFS.type = 5;
    localqi.dFS.dFX = JVj.JVr;
    localqi.dFS.toUser = paramString1;
    localqi.dFS.dFY = JVj.dFY;
    localqi.dFS.context = paramContext;
    localqi.dFS.dFl = JVj.dFl;
    localqi.dFS.dGa = JVj.JVs;
    localqi.dFS.dGc = paramString2;
    com.tencent.mm.sdk.b.a.IvT.l(localqi);
    long l;
    k.b localb;
    if (JVj.JVr != null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10811, new Object[] { Integer.valueOf(8), Integer.valueOf(JVj.JVr.size()), Integer.valueOf(JVj.JVr.size() - k.ie(JVj.JVr)) });
      paramString2 = new LinkedList();
      Iterator localIterator = JVj.JVr.iterator();
      if (localIterator.hasNext())
      {
        paramContext = (bv)localIterator.next();
        l = bu.aRi();
        localb = k.b.zb(bu.aSA(paramContext.field_content));
        if ((localb != null) && (localb.type == 5) && (!bu.isNullOrNil(localb.url))) {
          if (!paramContext.fta()) {
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
          ae.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", paramString1, "", new Object[0]);
        }
      }
      ae.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localb.url, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1) });
      break;
      if ((localb == null) || (localb.type != 51)) {
        break;
      }
      paramContext = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext == null) {
        break;
      }
      paramString2.add(paramContext.ipW.objectId);
      break;
      if (paramString2.size() > 0) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).shareStatsReport(paramString2);
      }
      if ((paramBoolean) && (JVj.JUZ != null)) {
        JVj.JUZ.c(z.a.hGL);
      }
      paramContext = new Pair(Long.valueOf(localqi.dFT.msgId), Boolean.valueOf(localqi.dFT.dGh));
      AppMethodBeat.o(187150);
      return paramContext;
    }
  }
  
  private static void e(Context paramContext, List<bv> paramList)
  {
    AppMethodBeat.i(34444);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if (bn.z(localbv))
      {
        switch (localbv.getType() & 0xFFFF)
        {
        }
        for (;;)
        {
          bn.C(localbv);
          break;
          localbv.setContent(paramContext.getString(2131755904));
          continue;
          localbv.setContent(paramContext.getString(2131755853));
          localbv.setType(1);
          continue;
          localbv.setContent(paramContext.getString(2131755926));
          localbv.setType(1);
          continue;
          localbv.setContent(paramContext.getString(2131755914));
          localbv.setType(1);
        }
      }
    }
    AppMethodBeat.o(34444);
  }
  
  public static int fFo()
  {
    AppMethodBeat.i(187148);
    if (JVj.JVr != null)
    {
      int i = JVj.JVr.size();
      AppMethodBeat.o(187148);
      return i;
    }
    AppMethodBeat.o(187148);
    return 0;
  }
  
  public static boolean fFp()
  {
    AppMethodBeat.i(34449);
    if ((JVj.JVr == null) || (JVj.JVr.isEmpty()))
    {
      AppMethodBeat.o(34449);
      return false;
    }
    Iterator localIterator = JVj.JVr.iterator();
    while (localIterator.hasNext())
    {
      bv localbv = (bv)localIterator.next();
      bc.aCg();
      bv.a locala = com.tencent.mm.model.c.azI().arp(localbv.field_content);
      if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
        ae.e("MicroMsg.ChattingEditModeRetransmitMsg", "getView : parse possible friend msg failed");
      }
      if ((!x.oq(locala.Ecg)) && (localbv.getType() == 42) && (localbv.fvW()))
      {
        AppMethodBeat.o(34449);
        return true;
      }
    }
    AppMethodBeat.o(34449);
    return false;
  }
  
  public static void fFq()
  {
    JVj.JVr = null;
    JVj.JSi = false;
    JVj.JUZ = null;
    JVj.dFY = null;
    JVj.dFl = null;
    JVj.JVs = null;
  }
  
  public static qi kq(Context paramContext)
  {
    AppMethodBeat.i(34448);
    qi localqi = new qi();
    localqi.dFS.type = 6;
    localqi.dFS.dFX = JVj.JVr;
    localqi.dFS.dFY = JVj.dFY;
    localqi.dFS.context = paramContext;
    com.tencent.mm.sdk.b.a.IvT.l(localqi);
    JVj.dFl = localqi.dFT.dFl;
    JVj.JVs = localqi.dFT.dGa;
    AppMethodBeat.o(34448);
    return localqi;
  }
  
  public static Pair<Long, Boolean> m(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(187149);
    paramContext = c(paramContext, paramString, paramBoolean, paramString);
    AppMethodBeat.o(187149);
    return paramContext;
  }
  
  public static void n(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(34450);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
      AppMethodBeat.o(34450);
      return;
    }
    if ((JVj.JVr == null) || (JVj.JVr.isEmpty()))
    {
      ae.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
      AppMethodBeat.o(34450);
      return;
    }
    ae.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[] { paramString });
    com.tencent.mm.ui.chatting.d.m.KcB.c(new bf.a()
    {
      public final boolean aEC()
      {
        AppMethodBeat.i(187142);
        if (l.fFr().JVr == null)
        {
          AppMethodBeat.o(187142);
          return false;
        }
        Iterator localIterator = l.fFr().JVr.iterator();
        while (localIterator.hasNext())
        {
          bv localbv = (bv)localIterator.next();
          l.d(this.val$context, paramString, localbv, l.fFr().JSi);
        }
        AppMethodBeat.o(187142);
        return true;
      }
      
      public final boolean aED()
      {
        AppMethodBeat.i(187143);
        if (l.fFr().JVr != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(10811, new Object[] { Integer.valueOf(5), Integer.valueOf(l.fFr().JVr.size()), Integer.valueOf(l.fFr().JVr.size() - k.ie(l.fFr().JVr)) });
        }
        Object localObject1 = l.fFr().JVr;
        if (localObject1 != null)
        {
          LinkedList localLinkedList = new LinkedList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (bv)((Iterator)localObject1).next();
            if (((bv)localObject2).cVH())
            {
              localObject2 = k.b.zb(bu.aSA(((ei)localObject2).field_content));
              if ((localObject2 != null) && (((k.b)localObject2).type == 51))
              {
                localObject2 = (com.tencent.mm.plugin.i.a.b)((k.b)localObject2).ao(com.tencent.mm.plugin.i.a.b.class);
                if (localObject2 != null) {
                  localLinkedList.add(((com.tencent.mm.plugin.i.a.b)localObject2).ipW.objectId);
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
            ae.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
            this.val$callback.run();
          }
          if (l.fFr().JUZ != null) {
            l.fFr().JUZ.c(z.a.hGL);
          }
          l.fFq();
        }
        AppMethodBeat.o(187143);
        return true;
      }
    });
    AppMethodBeat.o(34450);
  }
  
  public static void xX(boolean paramBoolean)
  {
    AppMethodBeat.i(34447);
    if ((paramBoolean) && (JVj.JUZ != null)) {
      JVj.JUZ.c(z.a.hGL);
    }
    AppMethodBeat.o(34447);
  }
  
  static final class a
  {
    boolean JSi;
    com.tencent.mm.ah.z JUZ;
    List<bv> JVr;
    com.tencent.mm.protocal.b.a.d JVs;
    String dFY;
    cw dFl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l
 * JD-Core Version:    0.7.0.1
 */