package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.v;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.o.a;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class k
{
  public static String A(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34421);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramInt == 0) {
          str = bp.Kt(paramString);
        }
      }
    }
    AppMethodBeat.o(34421);
    return str;
  }
  
  static void a(Context paramContext, final com.tencent.mm.av.g paramg, ca paramca, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c(paramg), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = paramg.iXp;
    long l1 = com.tencent.mm.av.q.bcR().a(paramca.field_talker, (String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = com.tencent.mm.av.q.bcR().c(Long.valueOf(l1));
    ((com.tencent.mm.av.g)localObject2).tj(1);
    ca localca = new ca();
    localca.setType(ab.JH(paramString1));
    localca.Cy(paramString1);
    localca.nv(1);
    localca.setStatus(1);
    localca.Cz(((PString)localObject1).value);
    localca.nG(localPInt1.value);
    localca.nH(localPInt2.value);
    localca.setCreateTime(bp.Kw(localca.field_talker));
    if (com.tencent.mm.al.g.DQ(localca.field_talker)) {
      paramca.BB(com.tencent.mm.al.a.e.ajw());
    }
    bg.aVF();
    long l2 = com.tencent.mm.model.c.aSQ().aC(localca);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.av.g)localObject2).Aw((int)l2);
      com.tencent.mm.av.q.bcR().a(Long.valueOf(l1), (com.tencent.mm.av.g)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), paramg);
      com.tencent.mm.av.q.bcS().a(paramg.localId, paramca.field_msgId, i, localObject1, 2131231628, new e.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.ak.q paramAnonymousq) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(34392);
          if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
          for (paramAnonymousInt2 = 1; (paramAnonymousObject instanceof HashMap); paramAnonymousInt2 = 0)
          {
            paramAnonymousObject = (HashMap)paramAnonymousObject;
            if (paramAnonymousObject == null) {
              break;
            }
            paramAnonymousObject = paramAnonymousObject.entrySet().iterator();
            while (paramAnonymousObject.hasNext())
            {
              paramAnonymousq = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousq.getKey();
              paramAnonymousq = (com.tencent.mm.av.g)paramAnonymousq.getValue();
              paramAnonymousq = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c(paramAnonymousq), "", "");
              if (paramAnonymousInt2 != 0)
              {
                bg.aVF();
                com.tencent.mm.model.c.aSQ().Hc(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.g.eir().a(this.val$context, paramString1, paramAnonymousq, paramAnonymousInt1, paramg.iXy, paramString2, paramAnonymousLong2, null);
              }
            }
          }
          AppMethodBeat.o(34392);
        }
      });
      AppMethodBeat.o(34428);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, ca paramca)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, paramca, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = be.bkr(paramca.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (paramca = paramca.field_imgPath;; paramca = str)
    {
      if (paramca == null)
      {
        Log.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(paramContext, paramString, paramca);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, paramca, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    paramContext = A(paramca.field_content, paramca.field_isSend, paramBoolean);
    if ((paramContext == null) || (paramContext.equals("")))
    {
      Log.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.eir().ad(paramString, paramContext, ab.JG(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      ca localca = new ca();
      localca.setContent(paramString2);
      localca.nv(paramInt);
      paramInt = paramString2.indexOf("<msg>");
      String str = paramString2;
      if (paramInt > 0)
      {
        str = paramString2;
        if (paramInt < paramString2.length()) {
          str = paramString2.substring(paramInt).trim();
        }
      }
      paramString2 = XmlParser.parseXml(str, "msg", null);
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        localca.CA(SemiXml.encode(paramString2));
      }
      b(paramContext, paramString1, localca, paramBoolean);
      AppMethodBeat.o(34435);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
      Log.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
      AppMethodBeat.o(34435);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(163284);
    Log.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str1 = t.Qv(paramString2);
    com.tencent.mm.modelvideo.o.bhj();
    String str2 = t.Qw(paramString1);
    String str3 = t.Qw(str1);
    paramString1 = t.Qx(paramString1);
    String str4 = t.Qx(str1);
    Log.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { str2, str3, paramString1, str4 });
    com.tencent.mm.vfs.s.nw(str2, str3);
    com.tencent.mm.vfs.s.nw(paramString1, str4);
    com.tencent.mm.modelvideo.u.a(str1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, (int)paramLong);
    com.tencent.mm.modelvideo.u.QG(str1);
    AppMethodBeat.o(163284);
  }
  
  static boolean a(Context paramContext, String paramString1, ca paramca, String paramString2)
  {
    AppMethodBeat.i(34425);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<ca> paramList, String paramString, com.tencent.mm.ag.z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.aSC())) || (paramBoolean)))
    {
      paramList = (ca)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1) {}
      for (i = 1; ((bu(paramList)) && ((i == 0) || (bs(paramList)) || (g(paramList, paramString)))) || (paramList.gAy()) || (bh(paramList)) || (bj(paramList)) || (bk(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (br(paramList)) || (bl(paramList)) || (bv(paramList)) || (bq(paramList)) || (bm(paramList)) || (f(paramList, paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 889192497) || (paramList.getType() == 922746929); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    ca localca;
    if (paramList.hasNext())
    {
      localca = (ca)paramList.next();
      if (((paramz != null) && (paramz.aSC())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1)
        {
          i = 1;
          label354:
          if ((!localca.gAy()) && (!bh(localca)) && (!bj(localca)) && (!bk(localca)) && (localca.getType() != -1879048186) && ((localca.getType() != 486539313) || (!paramBoolean)) && (!br(localca)) && (!bl(localca)) && ((!bn(localca)) || ((paramz != null) && (paramz.aSC()))) && ((!bo(localca)) || ((paramz != null) && (paramz.aSC()))) && (localca.getType() != 318767153) && ((!bu(localca)) || ((i != 0) && (!bs(localca)) && (!g(localca, paramString)))) && (!bv(localca)) && (!bq(localca)) && (!bm(localca)) && (!f(localca, paramBoolean)) && (localca.getType() != 788529201) && (localca.getType() != 889192497) && (localca.getType() != 922746929)) {
            break label668;
          }
          paramList.remove();
          bool = false;
        }
      }
    }
    label668:
    for (;;)
    {
      break;
      i = 0;
      break label354;
      if ((bn(localca)) || (bo(localca)) || (localca.getType() == 788529201) || (localca.getType() == 889192497) || (localca.getType() == 922746929))
      {
        paramList.remove();
        bool = false;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(34404);
        return bool;
      }
    }
  }
  
  public static void b(final Context paramContext, final String paramString, ca paramca)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, paramca, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (paramca.field_msgId > 0L) {
      localObject1 = com.tencent.mm.av.q.bcR().H(paramca.field_talker, paramca.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramca.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.av.q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.av.g)localObject2).bcv())
    {
      i = j;
      if (!com.tencent.mm.av.h.a((com.tencent.mm.av.g)localObject2).iXm.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
    String str1 = com.tencent.mm.av.q.bcR().o(((com.tencent.mm.av.g)localObject2).iXo, "th_", "");
    if ((((com.tencent.mm.av.g)localObject2).offset < ((com.tencent.mm.av.g)localObject2).iKP) || (((com.tencent.mm.av.g)localObject2).iKP == 0))
    {
      final String str2 = com.tencent.mm.model.z.aTY();
      final String str3 = ((com.tencent.mm.av.g)localObject2).iXy;
      Object localObject3 = XmlParser.parseXml(((com.tencent.mm.av.g)localObject2).iXy, "msg", null);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.av.g)localObject2).iXy });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.av.g)localObject2, paramca, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.av.g)localObject2).iXp;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          Log.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!Util.isNullOrNil((String)localObject1)) {
            break label376;
          }
          Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label376:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (Util.isNullOrNil(str4))
        {
          Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (Util.isNullOrNil(com.tencent.mm.an.c.a("downimg", ((com.tencent.mm.av.g)localObject2).iXu, paramca.field_talker, paramca.field_msgId)))
        {
          Log.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
          localg.taskName = "task_ChattingEditModeLogic_1";
          localg.gqy = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(34390);
              Object localObject2;
              int i;
              Object localObject1;
              String str1;
              String str2;
              int j;
              String str3;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              long l3;
              if (paramAnonymousd != null)
              {
                if (!paramAnonymousd.field_exist_whencheck) {
                  break label771;
                }
                Log.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject2 = this.iBF;
                i = this.psA;
                localObject1 = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.lhI;
                j = j;
                str3 = com.tencent.mm.av.q.bcR().R(((eo)localObject2).field_imgPath, true);
                localObject3 = new PString();
                localObject4 = new PInt();
                localObject5 = new PInt();
                ((PString)localObject3).value = "";
                paramAnonymousc = new ca();
                paramAnonymousc.setType(ab.JH((String)localObject1));
                paramAnonymousc.Cy((String)localObject1);
                paramAnonymousc.nv(1);
                paramAnonymousc.setStatus(1);
                paramAnonymousc.setCreateTime(bp.Kw(paramAnonymousc.field_talker));
                paramAnonymousc.setContent(paramAnonymousString);
                a.a.anC().n(paramAnonymousc);
                l3 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC(paramAnonymousc);
                if (l3 < 0L) {
                  break label765;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                Log.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label834;
                }
              }
              label771:
              label834:
              for (long l1 = com.tencent.mm.av.q.bcR().a((String)localObject1, null, l3, true, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);; l1 = 0L)
              {
                long l2 = com.tencent.mm.av.q.bcR().a((String)localObject1, null, l3, false, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);
                localObject4 = XmlParser.parseXml(paramAnonymousString, "msg", null);
                paramAnonymousInt = Util.getInt((String)((Map)localObject4).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = com.tencent.mm.av.q.bcR().c(Long.valueOf(l2));
                paramAnonymousString.Aw((int)l3);
                if (l2 > 0L)
                {
                  localObject5 = com.tencent.mm.av.q.bcR().a(((PString)localObject3).value, "th_", "", false);
                  Log.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject5 });
                  com.tencent.mm.vfs.s.nw(str3, (String)localObject5);
                  paramAnonymousc.Cz(((PString)localObject3).value);
                  paramAnonymousc.nG(((eo)localObject2).fQS);
                  paramAnonymousc.nH(((eo)localObject2).fQT);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.tk(1);
                    paramAnonymousString.tg((int)l1);
                    paramAnonymousInt = Util.getInt((String)((Map)localObject4).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  com.tencent.mm.av.q.bcR().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = com.tencent.mm.av.q.bcR().c(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(l3, paramAnonymousc);
                    com.tencent.mm.av.q.bcR().a(Long.valueOf(l1), paramAnonymousString);
                    localObject3 = com.tencent.mm.an.c.a("upimg", paramAnonymousc.field_createTime, paramAnonymousc.field_talker, paramAnonymousc.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new enu();
                    ((enu)localObject2).KHl = new dqi().bhy(str1);
                    ((enu)localObject2).KHm = new dqi().bhy((String)localObject1);
                    ((enu)localObject2).xKb = paramAnonymousc.getType();
                    ((enu)localObject2).KHq = paramAnonymousc.fqK;
                    ((enu)localObject2).LbM = paramAnonymousString.iXq;
                    ((enu)localObject2).NlB = new dqi().bhy((String)localObject3);
                    ((enu)localObject2).LYt = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)com.tencent.mm.vfs.s.boW(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    localObject1 = com.tencent.mm.av.c.bcn();
                    ((com.tencent.mm.av.c)localObject1).hmk = i;
                    ((com.tencent.mm.av.c)localObject1).iWW = ((enu)localObject2);
                    ((com.tencent.mm.av.c)localObject1).iWX = paramAnonymousString;
                    ((com.tencent.mm.av.c)localObject1).hmq = paramAnonymousd;
                    ((com.tencent.mm.av.c)localObject1).iWY = new k.2(l2, l3);
                    ((o.e)localObject1).toUser = paramAnonymousc.field_talker;
                    ((o.e)localObject1).bdQ().execute();
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label765:
                      paramAnonymousBoolean = false;
                      break;
                      Log.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = com.tencent.mm.av.q.bcR().o(this.iZh.iXo, "th_", "");
                      k.a(paramContext, this.iZh, this.iBF, this.psA, paramString, paramAnonymousString);
                    }
                    l1 = l2;
                  }
                }
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          localg.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), paramString, paramca.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.i.a.gpM;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.an.f.baQ().f(localg))
          {
            Log.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download img before retransmit");
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
    }
    if (!Util.isNullOrNil((String)localObject1)) {
      com.tencent.mm.plugin.messenger.a.g.eir().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.av.g)localObject2).iXy, str1, paramca.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, paramca, "appmsg"))
    {
      AppMethodBeat.o(34432);
      return;
    }
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(34432);
      return;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = com.tencent.mm.av.q.bcR().d(paramca.field_imgPath, false, false);
    if ((!af.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (com.tencent.mm.vfs.s.YS(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
        localObject2 = ((com.tencent.mm.ag.u)localObject1).iAd;
        if ((localObject2 == null) || (((List)localObject2).size() <= 0))
        {
          if ((paramca == null) || ((!paramca.dOQ()) && (!paramca.gAt()))) {
            break label759;
          }
          localObject1 = ad.JX(paramca.field_msgSvrId);
          localObject2 = ad.aVe().G((String)localObject1, true);
          ((ad.b)localObject2).l("prePublishId", "msg_" + paramca.field_msgSvrId);
          ((ad.b)localObject2).l("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(paramca, paramBoolean, false));
          ((ad.b)localObject2).l("preChatName", paramca.field_talker);
          ((ad.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
          ((ad.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
          ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (ad.b)localObject2, paramca);
          com.tencent.mm.plugin.messenger.a.g.eir().a(paramString, Util.readFromFile(paramContext), Util.processXml(paramca.field_content), (String)localObject1);
          AppMethodBeat.o(34432);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", paramContext, "", new Object[0]);
        Log.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[] { paramContext.getLocalizedMessage() });
        AppMethodBeat.o(34432);
        return;
      }
      paramca = ((List)localObject2).iterator();
      while (paramca.hasNext())
      {
        Object localObject3 = (v)paramca.next();
        localObject2 = new k.b();
        if (com.tencent.mm.ag.m.HF(((v)localObject3).iAt))
        {
          m.b(paramString, m.a(paramString, (v)localObject3), ((v)localObject3).iAw);
        }
        else
        {
          ((k.b)localObject2).title = ((v)localObject3).title;
          ((k.b)localObject2).description = ((v)localObject3).iAq;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((v)localObject3).url;
          ((k.b)localObject2).eag = ((com.tencent.mm.ag.u)localObject1).eag;
          ((k.b)localObject2).eah = ((com.tencent.mm.ag.u)localObject1).eah;
          ((k.b)localObject2).fQR = ((com.tencent.mm.ag.u)localObject1).fQR;
          ((k.b)localObject2).thumburl = com.tencent.mm.ag.m.a((v)localObject3);
          com.tencent.mm.ag.e locale = new com.tencent.mm.ag.e();
          locale.iwc = ((v)localObject3).type;
          locale.iwf = ((v)localObject3).iwf;
          if (((v)localObject3).type == 5)
          {
            locale.vid = ((v)localObject3).vid;
            locale.iwd = ((int)((v)localObject3).time);
            locale.duration = ((v)localObject3).iAs;
            locale.videoWidth = ((v)localObject3).videoWidth;
            locale.videoHeight = ((v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((Util.isNullOrNil(((k.b)localObject2).thumburl)) && (!Util.isNullOrNil(((k.b)localObject2).eag)))
          {
            localObject3 = p.aYB().Mx(((k.b)localObject2).eag);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.aj.i)localObject3).aYt();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.eir().a(paramString, Util.readFromFile(paramContext), Util.processXml((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
      label759:
      Object localObject1 = null;
    }
  }
  
  public static boolean bh(ca paramca)
  {
    AppMethodBeat.i(34397);
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (paramca.gDo())
    {
      be localbe = new be(paramca.field_content);
      paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (paramca != null) {
        break label314;
      }
      paramca = new k.b();
      paramca.iwK = localbe.md5;
    }
    label314:
    for (;;)
    {
      for (paramca = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.iwK); (paramca != null) && ((paramca.field_catalog == EmojiInfo.Uuv) || ((!Util.isNullOrNil(paramca.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amq(paramca.field_groupId)))); paramca = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (paramca != null)
      {
        if ((Util.isNullOrNil(paramca.field_app_id)) && (!Util.isNullOrNil(paramca.field_groupId)) && (!paramca.field_groupId.equals(String.valueOf(EmojiGroupInfo.Uun))) && (!paramca.field_groupId.equals(String.valueOf(EmojiGroupInfo.Uum))) && (!paramca.field_groupId.equals(String.valueOf(EmojiGroupInfo.Uuo))) && (!paramca.field_groupId.equals(String.valueOf(EmojiInfo.Uup))) && (!paramca.field_groupId.equals("capture"))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(34397);
          return true;
        }
      }
      AppMethodBeat.o(34397);
      return false;
    }
  }
  
  public static boolean bi(ca paramca)
  {
    AppMethodBeat.i(34398);
    if (paramca.gDo())
    {
      be localbe = new be(paramca.field_content);
      paramca = k.b.aD(paramca.field_content, paramca.field_reserved);
      if (paramca != null) {
        break label99;
      }
      paramca = new k.b();
      paramca.iwK = localbe.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.iwK) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean bj(ca paramca)
  {
    AppMethodBeat.i(34399);
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (paramca.field_isSend == 0) {}
    for (paramca = bp.Kt(paramca.field_content);; paramca = paramca.field_content)
    {
      paramca = k.b.HD(paramca);
      if (paramca != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    paramca = com.tencent.mm.pluginsdk.model.app.h.o(paramca.appId, false, false);
    if ((paramca != null) && (paramca.NA()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean bk(ca paramca)
  {
    AppMethodBeat.i(34400);
    if (paramca.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean bl(ca paramca)
  {
    AppMethodBeat.i(34401);
    if ((paramca.getType() == 436207665) || (paramca.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean bm(ca paramca)
  {
    AppMethodBeat.i(34402);
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (paramca.field_isSend == 0) {}
    for (paramca = bp.Kt(paramca.field_content);; paramca = paramca.field_content)
    {
      paramca = k.b.HD(paramca);
      if (paramca != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((paramca.izr != 0) || ((paramca.type == 33) && (paramca.izk == 3)) || ((paramca.type == 36) && (paramca.izk == 3)) || ((paramca.type == 46) && (paramca.izk == 3)) || ((paramca.type == 44) && ((paramca.izk == 3) || (!paramca.fn(false)))) || ((paramca.type == 48) && (paramca.izk == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  private static boolean bn(ca paramca)
  {
    AppMethodBeat.i(34405);
    if (paramca != null)
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 19))
      {
        Object localObject = new rc();
        ((rc)localObject).dXF.type = 0;
        ((rc)localObject).dXF.dXH = paramca.ixl;
        EventCenter.instance.publish((IEvent)localObject);
        localObject = ((rc)localObject).dXG.dXP;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).iAd.iterator();
          while (((Iterator)localObject).hasNext())
          {
            aml localaml = (aml)((Iterator)localObject).next();
            if (!Util.isNullOrNil(localaml.LwF))
            {
              Log.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localaml.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((paramca.ixl != null) && (paramca.ixl.contains("<recordxml>")))
        {
          AppMethodBeat.o(34405);
          return true;
        }
        AppMethodBeat.o(34405);
        return false;
      }
    }
    AppMethodBeat.o(34405);
    return false;
  }
  
  private static boolean bo(ca paramca)
  {
    AppMethodBeat.i(34406);
    if (paramca != null)
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static boolean bp(ca paramca)
  {
    AppMethodBeat.i(34407);
    if (paramca != null)
    {
      paramca = k.b.HD(paramca.field_content);
      if (paramca == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((paramca.type == 6) || (paramca.type == 5) || (paramca.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static boolean bq(ca paramca)
  {
    AppMethodBeat.i(34408);
    if ((paramca == null) || (!paramca.gAt()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.ag.m.c(paramca.field_msgId, paramca.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean br(ca paramca)
  {
    AppMethodBeat.i(34409);
    if (paramca != null)
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((paramca != null) && (paramca.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  public static boolean bs(ca paramca)
  {
    AppMethodBeat.i(34412);
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!ab.rR(locala.IOs)) && (paramca.getType() == 42))
    {
      boolean bool = paramca.gDD();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean bt(ca paramca)
  {
    AppMethodBeat.i(34413);
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!ab.rR(locala.IOs)) && (paramca.getType() == 42))
    {
      if ((paramca.fqJ & 0x800) > 0)
      {
        AppMethodBeat.o(34413);
        return true;
      }
      AppMethodBeat.o(34413);
      return false;
    }
    AppMethodBeat.o(34413);
    return false;
  }
  
  static boolean bu(ca paramca)
  {
    AppMethodBeat.i(34414);
    if (!paramca.gDl())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    bg.aVF();
    paramca = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((paramca == null) || (Util.isNullOrNil(paramca.dkU)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (ab.IT(paramca.dkU))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean bv(ca paramca)
  {
    AppMethodBeat.i(232858);
    if ((paramca != null) && (paramca.dOQ()))
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 6) && (paramca.iwI >= 1073741824))
      {
        AppMethodBeat.o(232858);
        return true;
      }
    }
    AppMethodBeat.o(232858);
    return false;
  }
  
  public static boolean bw(ca paramca)
  {
    AppMethodBeat.i(34416);
    if ((paramca != null) && (paramca.dOQ()))
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final ca paramca)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, paramca, "video")) || (paramca == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((paramca != null) && (paramca.cWL()) && (com.tencent.mm.modelvideo.u.QO(paramca.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    if ((localObject != null) && (((com.tencent.mm.modelvideo.s)localObject).status == 199))
    {
      a(paramca.field_imgPath, paramString, ((com.tencent.mm.modelvideo.s)localObject).jsr, ((com.tencent.mm.modelvideo.s)localObject).iFw, ((com.tencent.mm.modelvideo.s)localObject).bhv(), paramca.getType(), paramca.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = XmlParser.parseXml(((com.tencent.mm.modelvideo.s)localObject).bhv(), "msg", null);
    final int i;
    if (localMap == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, paramca);
      }
      AppMethodBeat.o(34430);
      return;
      paramContext = (String)localMap.get(".msg.videomsg.$cdnvideourl");
      if (Util.isNullOrNil(paramContext))
      {
        i = 0;
      }
      else
      {
        final String str1 = (String)localMap.get(".msg.videomsg.$aeskey");
        final String str2 = (String)localMap.get(".msg.videomsg.$md5");
        final String str3 = (String)localMap.get(".msg.videomsg.$newmd5");
        i = Util.getInt((String)localMap.get(".msg.videomsg.$length"), 0);
        final int j = Util.getInt((String)localMap.get(".msg.videomsg.$playlength"), 0);
        final int k = Util.getInt((String)localMap.get(".msg.videomsg.$cdnthumblength"), 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1328L, 12L, 1L, true);
        if (Util.isNullOrNil(str2))
        {
          com.tencent.mm.modelvideo.o.bhj();
          if (!com.tencent.mm.vfs.s.YS(t.Qw(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
          {
            Log.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject).taskName = "task_ChattingEditModeLogic_2";
        ((com.tencent.mm.i.g)localObject).gqy = new g.a()
        {
          public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(34394);
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label369;
              }
              paramAnonymousd.field_fileId = this.val$url;
              paramAnonymousd.field_aesKey = str1;
              paramAnonymousd.field_thumbimgLength = k;
              paramAnonymousd.field_fileLength = i;
              paramAnonymousd.field_toUser = paramString;
              paramAnonymousd.field_filemd5 = str2;
              paramAnonymousd.field_mp4identifymd5 = str3;
              Log.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = t.Qv(paramString);
              com.tencent.mm.modelvideo.o.bhj();
              paramAnonymousc = t.Qx(paramAnonymousString);
              com.tencent.mm.modelvideo.o.bhj();
              com.tencent.mm.vfs.s.nw(t.Qx(paramca.field_imgPath), paramAnonymousc);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + this.val$url + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              Log.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.u.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)paramca.field_msgId);
              paramAnonymousc = com.tencent.mm.av.s.bcY();
              paramAnonymousc.fileName = paramAnonymousString;
              paramAnonymousc.jaB = 0;
              paramAnonymousc.jaC = paramAnonymousd;
              paramAnonymousc.jaD = new com.tencent.mm.av.f()
              {
                public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramAnonymousString);
                  locals.status = 111;
                  locals.cSx = 256;
                  com.tencent.mm.modelvideo.o.bhj().c(locals);
                  Log.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              };
              paramAnonymousc.jdR = 4;
              paramAnonymousc.bdQ().execute();
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label369:
              k.f(paramString, paramca);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.i.g)localObject).field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), paramString, paramca.field_msgId);
        ((com.tencent.mm.i.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.i.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.i.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.i.g)localObject).field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        ((com.tencent.mm.i.g)localObject).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.gpM;
        ((com.tencent.mm.i.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.i.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject))
        {
          Log.e("MicroMsg.ChattingEditModeLogic", "check exist fail! download video before retransmit");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
  }
  
  public static void c(Context paramContext, String paramString, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, paramca, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = A(paramca.field_content, paramca.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.eir().ad(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static void d(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    String str = paramEmojiInfo.hRM();
    if (com.tencent.mm.vfs.s.boW(str + "_thumb") > 0L)
    {
      int i = (int)com.tencent.mm.vfs.s.boW(str + "_thumb");
      localWXMediaMessage.thumbData = com.tencent.mm.vfs.s.aW(str + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject(str);
      com.tencent.mm.pluginsdk.model.app.m.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.getMd5());
      AppMethodBeat.o(34436);
      return;
      try
      {
        InputStream localInputStream = com.tencent.mm.vfs.s.openRead(str);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.BitmapFactory.decodeStream(localInputStream, 1.0F));
        localInputStream.close();
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ChattingEditModeLogic", localException, "", new Object[0]);
        Log.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
  
  static void f(final String paramString, ca paramca)
  {
    AppMethodBeat.i(34429);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        com.tencent.mm.modelvideo.o.bho().a(this.iBF.field_imgPath, new t.a()
        {
          public final void a(t.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.u.QN(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              k.a(k.5.this.iBF.field_imgPath, k.5.this.gtu, paramAnonymous2a.jsr, paramAnonymous2a.iFw, paramAnonymous2a.bhv(), k.5.this.iBF.getType(), k.5.this.iBF.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  private static boolean f(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (paramca != null)
    {
      paramca = k.b.HD(paramca.field_content);
      if ((paramca != null) && (paramca.type == 33) && (paramca.izk == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  private static boolean g(ca paramca, String paramString)
  {
    AppMethodBeat.i(34411);
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0))
    {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1) {}
    for (int i = 1; (i != 0) && ((as.bjp(paramString)) || (as.bjq(paramString)) || (paramca.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  public static List<String> gNu()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = ag.bah().sN(25);
    Object localObject2 = ag.bah();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.al.f.a((StringBuilder)localObject4);
    com.tencent.mm.al.f.c((StringBuilder)localObject4);
    com.tencent.mm.al.f.d((StringBuilder)localObject4);
    com.tencent.mm.al.f.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.al.f.aZD());
    localObject4 = ((StringBuilder)localObject4).toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.al.f)localObject2).rawQuery((String)localObject4, new String[0]);
    if (localObject2 != null)
    {
      if (((Cursor)localObject2).moveToFirst()) {
        do
        {
          ((ArrayList)localObject3).add(((Cursor)localObject2).getString(0));
        } while (((Cursor)localObject2).moveToNext());
      }
      ((Cursor)localObject2).close();
    }
    localObject2 = new HashMap();
    localObject3 = ((List)localObject3).iterator();
    String str;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      str = com.tencent.mm.al.g.fJ((String)localObject4).UN();
      if (!Util.isNullOrNil(str)) {
        ((HashMap)localObject2).put(str, localObject4);
      }
    }
    localObject3 = new LinkedList();
    localObject4 = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (com.tencent.mm.al.g.Ne(str))
      {
        if (com.tencent.mm.al.g.Ni(str))
        {
          str = com.tencent.mm.al.g.fJ(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.al.g.Ng(str)))
          {
            ((List)localObject4).add(str);
            str = (String)((HashMap)localObject2).get(str);
            if (!Util.isNullOrNil(str)) {
              ((List)localObject4).add(str);
            }
          }
        }
      }
      else {
        ((List)localObject3).add(str);
      }
    }
    localObject1 = ((HashMap)localObject2).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!Util.isNullOrNil((String)localObject2)) && (!((List)localObject4).contains(localObject2))) {
        ((List)localObject4).add(localObject2);
      }
    }
    ((List)localObject3).addAll((Collection)localObject4);
    Log.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
    AppMethodBeat.o(34422);
    return localObject3;
  }
  
  public static List<String> gNv()
  {
    AppMethodBeat.i(34423);
    Object localObject = ag.bah().sN(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.al.g.Ne(str)) {
        localLinkedList.add(str);
      }
    }
    Log.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  public static boolean jg(List<ca> paramList)
  {
    AppMethodBeat.i(34403);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
      AppMethodBeat.o(34403);
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if ((localca.gAy()) || (bh(localca)) || (localca.gDl()) || (bj(localca)) || (bk(localca)) || (localca.getType() == -1879048186) || (br(localca)) || (bl(localca)) || (bq(localca)) || (bm(localca)) || (bw(localca)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int jh(List<ca> paramList)
  {
    AppMethodBeat.i(34417);
    if (paramList == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
      AppMethodBeat.o(34417);
      return 0;
    }
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if ((!localca.gAy()) && (!bh(localca)) && (!localca.dOS()) && (!bj(localca)) && (!bk(localca)) && (!bl(localca))) {
        break label111;
      }
      i += 1;
    }
    label111:
    for (;;)
    {
      break;
      AppMethodBeat.o(34417);
      return i;
    }
  }
  
  public static boolean ji(List<ca> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label390:
    label391:
    for (;;)
    {
      ca localca;
      if (localIterator.hasNext())
      {
        localca = (ca)localIterator.next();
        if ((localca.gAz()) || (localca.gDr()))
        {
          paramList = null;
          if (localca.field_msgId > 0L) {
            paramList = com.tencent.mm.av.q.bcR().H(localca.field_talker, localca.field_msgId);
          }
          if (((paramList != null) && (paramList.localId > 0L)) || (localca.field_msgSvrId <= 0L)) {
            break label390;
          }
          paramList = com.tencent.mm.av.q.bcR().G(localca.field_talker, localca.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.iKP) && (paramList.iKP != 0))) {
          break label391;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localca.cWJ())
        {
          paramList = com.tencent.mm.modelvideo.o.bhj().Qq(localca.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localca.gDo())
        {
          if (bi(localca)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localca.dOQ())
        {
          paramList = k.b.aD(localca.field_content, localca.field_content);
          if (paramList == null)
          {
            AppMethodBeat.o(34418);
            return true;
          }
          switch (paramList.type)
          {
          default: 
            break;
          case 6: 
            paramList = ao.cgO().bdx(paramList.dCK);
            if (paramList == null)
            {
              AppMethodBeat.o(34418);
              return true;
            }
            if (new com.tencent.mm.vfs.o(paramList.field_fileFullPath).exists()) {
              break;
            }
            AppMethodBeat.o(34418);
            return true;
          }
        }
        if (!localca.cWL()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
        if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
          break;
        }
        AppMethodBeat.o(34418);
        return true;
        AppMethodBeat.o(34418);
        return false;
      }
    }
  }
  
  public static boolean jj(List<ca> paramList)
  {
    AppMethodBeat.i(34419);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34419);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if ((localca.cWJ()) && (com.tencent.mm.pluginsdk.model.m.bdr(localca.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean jk(List<ca> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((ca)paramList.next()).cWL())
      {
        AppMethodBeat.o(34420);
        return true;
      }
    }
    AppMethodBeat.o(34420);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k
 * JD-Core Version:    0.7.0.1
 */