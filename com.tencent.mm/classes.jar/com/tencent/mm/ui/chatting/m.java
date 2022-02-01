package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.g.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.p.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ftv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
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

public final class m
{
  public static String G(String paramString, int paramInt, boolean paramBoolean)
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
          str = br.JK(paramString);
        }
      }
    }
    AppMethodBeat.o(34421);
    return str;
  }
  
  static void a(Context paramContext, final com.tencent.mm.modelimage.h paramh, cc paramcc, int paramInt, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(34428);
    Object localObject2 = r.bKa().v(com.tencent.mm.modelimage.i.c(paramh), "", "");
    Object localObject1 = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    ((PString)localObject1).value = ((String)localObject2);
    int i = paramh.oGu;
    long l1 = r.bKa().a(paramcc.field_talker, (String)localObject2, i, paramInt, (PString)localObject1, localPInt1, localPInt2);
    localObject2 = r.bKa().b(Long.valueOf(l1));
    ((com.tencent.mm.modelimage.h)localObject2).wo(1);
    cc localcc = new cc();
    localcc.setType(com.tencent.mm.model.ab.IY(paramString1));
    localcc.BS(paramString1);
    localcc.pI(1);
    localcc.setStatus(1);
    localcc.BT(((PString)localObject1).value);
    localcc.pW(localPInt1.value);
    localcc.pX(localPInt2.value);
    localcc.setCreateTime(br.JN(localcc.field_talker));
    if (com.tencent.mm.an.g.Dn(localcc.field_talker)) {
      paramcc.AU(com.tencent.mm.an.a.e.bCQ());
    }
    bh.bCz();
    long l2 = com.tencent.mm.model.c.bzD().ba(localcc);
    if (l2 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l2)));
      ((com.tencent.mm.modelimage.h)localObject2).iP((int)l2);
      r.bKa().a(Long.valueOf(l1), (com.tencent.mm.modelimage.h)localObject2);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(Long.valueOf(l2), paramh);
      r.bKb().a(paramh.localId, paramcc.field_msgId, i, localObject1, R.g.chat_img_template, new f.a()
      {
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, p paramAnonymousp) {}
        
        public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, p paramAnonymousp)
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
              paramAnonymousp = (Map.Entry)paramAnonymousObject.next();
              paramAnonymousString = (Long)paramAnonymousp.getKey();
              paramAnonymousp = (com.tencent.mm.modelimage.h)paramAnonymousp.getValue();
              paramAnonymousp = r.bKa().v(com.tencent.mm.modelimage.i.c(paramAnonymousp), "", "");
              if (paramAnonymousInt2 != 0)
              {
                bh.bCz();
                com.tencent.mm.model.c.bzD().sm(paramAnonymousString.longValue());
                com.tencent.mm.plugin.messenger.a.g.gaI().a(m.this, paramString1, paramAnonymousp, paramAnonymousInt1, paramh.oGC, paramString2, paramAnonymousLong2, null);
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
  
  public static void a(Context paramContext, String paramString, cc paramcc)
  {
    AppMethodBeat.i(34426);
    if (!a(paramContext, paramString, paramcc, "emoji"))
    {
      AppMethodBeat.o(34426);
      return;
    }
    String str = bg.byj(paramcc.field_content).md5;
    if ((str == null) || (str.endsWith("-1"))) {}
    for (paramcc = paramcc.field_imgPath;; paramcc = str)
    {
      if (paramcc == null)
      {
        Log.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
        AppMethodBeat.o(34426);
        return;
      }
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().y(paramContext, paramString, paramcc);
      AppMethodBeat.o(34426);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(34431);
    if (!a(paramContext, paramString, paramcc, "text"))
    {
      AppMethodBeat.o(34431);
      return;
    }
    paramContext = G(paramcc.field_content, paramcc.field_isSend, paramBoolean);
    if ((paramContext == null) || (paramContext.equals("")))
    {
      Log.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
      AppMethodBeat.o(34431);
      return;
    }
    com.tencent.mm.plugin.messenger.a.g.gaI().ap(paramString, paramContext, com.tencent.mm.model.ab.IX(paramString));
    AppMethodBeat.o(34431);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(34435);
    try
    {
      cc localcc = new cc();
      localcc.setContent(paramString2);
      localcc.pI(paramInt);
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
        localcc.BU(SemiXml.encode(paramString2));
      }
      b(paramContext, paramString1, localcc, paramBoolean);
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
    String str2 = aa.PW(paramString2);
    com.tencent.mm.modelvideo.v.bOh();
    Object localObject1 = aa.PX(paramString1);
    String str1 = aa.PX(str2);
    String str3 = aa.PY(paramString1);
    Object localObject2 = aa.PY(str2);
    Log.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[] { localObject1, str1, str3, localObject2 });
    y.O((String)localObject1, str1, false);
    y.O(str3, (String)localObject2, false);
    str1 = null;
    localObject1 = str1;
    if (com.tencent.mm.modelvideo.ab.bOG())
    {
      paramString1 = com.tencent.mm.modelvideo.ab.Qo(paramString1);
      localObject1 = str1;
      if (paramString1 != null)
      {
        localObject2 = com.tencent.mm.modelvideo.ab.Qo(paramString1.oYk);
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (((com.tencent.mm.modelvideo.z)localObject2).status == 199)
          {
            localObject1 = str2 + "origin";
            paramString1 = aa.PX(paramString1.oYk);
            str1 = aa.PX((String)localObject1);
            localObject2 = aa.PY((String)localObject1);
            Log.d("MicroMsg.ChattingEditModeLogic", "copy origin video: src path[%s] dst path[%s]", new Object[] { paramString1, str1 });
            y.O(paramString1, str1, false);
            y.O(str3, (String)localObject2, false);
            com.tencent.mm.modelvideo.ab.a((String)localObject1, null, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, null, "", (int)paramLong, null, "", true);
          }
        }
      }
    }
    if (Util.isNullOrNil((String)localObject1)) {
      com.tencent.mm.modelvideo.ab.a(str2, paramInt2, paramString2, paramInt1, paramString3, paramInt3, (int)paramLong, "");
    }
    for (;;)
    {
      com.tencent.mm.modelvideo.ab.Qh(str2);
      AppMethodBeat.o(163284);
      return;
      com.tencent.mm.modelvideo.ab.a(str2, (String)localObject1, paramInt2, paramString2, null, paramInt1, paramString3, paramInt3, null, "", (int)paramLong, null, "");
    }
  }
  
  static boolean a(Context paramContext, String paramString1, cc paramcc, String paramString2)
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
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[] { paramString2 });
      AppMethodBeat.o(34425);
      return false;
    }
    AppMethodBeat.o(34425);
    return true;
  }
  
  public static boolean a(boolean paramBoolean, List<cc> paramList, String paramString, com.tencent.mm.message.z paramz)
  {
    AppMethodBeat.i(34404);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
      AppMethodBeat.o(34404);
      return false;
    }
    int i;
    if ((paramList.size() == 1) && (((paramz != null) && (paramz.bws())) || (paramBoolean)))
    {
      paramList = (cc)paramList.get(0);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVK, 0) == 1) {}
      for (i = 1; ((cc(paramList)) && ((i == 0) || (ca(paramList)) || (i(paramList, paramString)) || (bZ(paramList)))) || (paramList.iYj()) || (bM(paramList)) || (bO(paramList)) || (bP(paramList)) || (paramList.getType() == -1879048186) || (paramList.getType() == 318767153) || ((paramList.getType() == 486539313) && (paramBoolean)) || (bY(paramList)) || (bQ(paramList)) || (cd(paramList)) || (bX(paramList)) || (bR(paramList)) || (g(paramList, paramBoolean)) || (bT(paramList)) || ((paramList.getType() == 754974769) && (paramBoolean)) || (paramList.getType() == 788529201) || (paramList.getType() == 1076887601) || (paramList.getType() == 889192497) || (paramList.getType() == 922746929); i = 0)
      {
        AppMethodBeat.o(34404);
        return false;
      }
      AppMethodBeat.o(34404);
      return true;
    }
    paramList = paramList.iterator();
    boolean bool = true;
    cc localcc;
    if (paramList.hasNext())
    {
      localcc = (cc)paramList.next();
      if (((paramz != null) && (paramz.bws())) || (paramBoolean)) {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVK, 0) == 1)
        {
          i = 1;
          label392:
          if ((!localcc.iYj()) && (!bM(localcc)) && (!bO(localcc)) && (!bP(localcc)) && (localcc.getType() != -1879048186) && ((localcc.getType() != 486539313) || (!paramBoolean)) && (!bY(localcc)) && (!bQ(localcc)) && ((!bU(localcc)) || ((paramz != null) && (paramz.bws()))) && ((!bV(localcc)) || ((paramz != null) && (paramz.bws()))) && (localcc.getType() != 318767153) && ((!cc(localcc)) || ((i != 0) && (!ca(localcc)) && (!i(localcc, paramString)) && (!bZ(localcc)))) && (!cd(localcc)) && (!bX(localcc)) && (!bR(localcc)) && (!g(localcc, paramBoolean)) && (!bT(localcc)) && (localcc.getType() != 788529201) && (localcc.getType() != 1076887601) && (localcc.getType() != 889192497) && (localcc.getType() != 922746929) && (localcc.getType() != 536936497)) {
            break label755;
          }
          paramList.remove();
          bool = false;
        }
      }
    }
    label755:
    for (;;)
    {
      break;
      i = 0;
      break label392;
      if ((bU(localcc)) || (bV(localcc)) || (localcc.getType() == 788529201) || (localcc.getType() == 1076887601) || (localcc.getType() == 889192497) || (localcc.getType() == 922746929))
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
  
  public static void b(final Context paramContext, final String paramString, cc paramcc)
  {
    AppMethodBeat.i(34427);
    if (!a(paramContext, paramString, paramcc, "image"))
    {
      AppMethodBeat.o(34427);
      return;
    }
    Object localObject1 = null;
    if (paramcc.field_msgId > 0L) {
      localObject1 = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramcc.field_msgSvrId > 0L) {
        localObject2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(34427);
      return;
    }
    final int j = 0;
    final int i = j;
    if (((com.tencent.mm.modelimage.h)localObject2).bJE())
    {
      i = j;
      if (!com.tencent.mm.modelimage.i.a((com.tencent.mm.modelimage.h)localObject2).oGr.startsWith("SERVERID://")) {
        i = 1;
      }
    }
    localObject1 = r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", "");
    String str1 = r.bKa().v(((com.tencent.mm.modelimage.h)localObject2).oGt, "th_", "");
    if ((localObject2 != null) && ((((com.tencent.mm.modelimage.h)localObject2).offset < ((com.tencent.mm.modelimage.h)localObject2).osy) || (((com.tencent.mm.modelimage.h)localObject2).osy == 0)))
    {
      final String str2 = com.tencent.mm.model.z.bAM();
      final String str3 = ((com.tencent.mm.modelimage.h)localObject2).oGC;
      Object localObject3 = XmlParser.parseXml(((com.tencent.mm.modelimage.h)localObject2).oGC, "msg", null);
      if (localObject3 == null)
      {
        Log.e("MicroMsg.ChattingEditModeLogic", "parse cdnInfo failed. [%s]", new Object[] { ((com.tencent.mm.modelimage.h)localObject2).oGC });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          a(paramContext, (com.tencent.mm.modelimage.h)localObject2, paramcc, 4, paramString, str1);
        }
        AppMethodBeat.o(34427);
        return;
        j = ((com.tencent.mm.modelimage.h)localObject2).oGu;
        if (j != 1) {
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnmidimgurl");
        }
        for (i = 2;; i = 1)
        {
          Log.d("MicroMsg.ChattingEditModeLogic", "cdntra read xml  comptype:%d url:[%s]", new Object[] { Integer.valueOf(j), localObject1 });
          if (!Util.isNullOrNil((String)localObject1)) {
            break label381;
          }
          Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get cdnUrlfailed.");
          i = 0;
          break;
          localObject1 = (String)((Map)localObject3).get(".msg.img.$cdnbigimgurl");
        }
        label381:
        String str4 = (String)((Map)localObject3).get(".msg.img.$aeskey");
        if (Util.isNullOrNil(str4))
        {
          Log.e("MicroMsg.ChattingEditModeLogic", "cdntra get aes key failed.");
          i = 0;
        }
        else if (Util.isNullOrNil(com.tencent.mm.modelcdntran.h.a("downimg", ((com.tencent.mm.modelimage.h)localObject2).createTime, paramcc.field_talker, paramcc.field_msgId)))
        {
          Log.w("MicroMsg.ChattingEditModeLogic", "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId) });
          i = 0;
        }
        else
        {
          localObject3 = (String)((Map)localObject3).get(".msg.img.$md5");
          com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
          localg.taskName = "task_ChattingEditModeLogic_1";
          localg.lwL = new g.a()
          {
            public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
                  break label772;
                }
                Log.d("MicroMsg.ChattingEditModeLogic", "support second !! sceneResult:[%s]", new Object[] { paramAnonymousd });
                localObject2 = m.this;
                i = this.vHo;
                localObject1 = paramString;
                str1 = str2;
                paramAnonymousString = str3;
                str2 = this.oJE;
                j = j;
                str3 = r.bKa().X(((fi)localObject2).field_imgPath, true);
                localObject3 = new PString();
                localObject4 = new PInt();
                localObject5 = new PInt();
                ((PString)localObject3).value = "";
                paramAnonymousc = new cc();
                paramAnonymousc.setType(com.tencent.mm.model.ab.IY((String)localObject1));
                paramAnonymousc.BS((String)localObject1);
                paramAnonymousc.pI(1);
                paramAnonymousc.setStatus(1);
                paramAnonymousc.setCreateTime(br.JN(paramAnonymousc.field_talker));
                paramAnonymousc.setContent(paramAnonymousString);
                a.a.aOb().n(paramAnonymousc);
                l3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(paramAnonymousc);
                if (l3 < 0L) {
                  break label766;
                }
                paramAnonymousBoolean = true;
                Assert.assertTrue(paramAnonymousBoolean);
                Log.i("MicroMsg.ChattingEditModeLogic", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(l3)));
                if (j != 1) {
                  break label835;
                }
              }
              label772:
              label835:
              for (long l1 = r.bKa().a((String)localObject1, null, l3, true, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);; l1 = 0L)
              {
                long l2 = r.bKa().a((String)localObject1, null, l3, false, paramAnonymousc.field_content, (PString)localObject3, (PInt)localObject4, (PInt)localObject5);
                localObject4 = XmlParser.parseXml(paramAnonymousString, "msg", null);
                paramAnonymousInt = Util.getInt((String)((Map)localObject4).get(".msg.img.$length"), paramAnonymousd.field_thumbimgLength);
                paramAnonymousString = r.bKa().b(Long.valueOf(l2));
                paramAnonymousString.iP((int)l3);
                if (l2 > 0L)
                {
                  localObject5 = r.bKa().a(((PString)localObject3).value, "th_", "", false);
                  Log.i("MicroMsg.ChattingEditModeLogic", "deal send img for cdn [%s]", new Object[] { localObject5 });
                  y.O(str3, (String)localObject5, false);
                  paramAnonymousc.BT(((PString)localObject3).value);
                  paramAnonymousc.pW(((fi)localObject2).kLh);
                  paramAnonymousc.pX(((fi)localObject2).kLi);
                  if (l1 > 0L)
                  {
                    paramAnonymousString.wp(1);
                    paramAnonymousString.wl((int)l1);
                    paramAnonymousInt = Util.getInt((String)((Map)localObject4).get(".msg.img.$hdlength"), paramAnonymousd.field_thumbimgLength);
                  }
                }
                for (;;)
                {
                  r.bKa().a(Long.valueOf(l2), paramAnonymousString);
                  if (j == 1) {
                    paramAnonymousString = r.bKa().b(Long.valueOf(l1));
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(l3, paramAnonymousc);
                    r.bKa().a(Long.valueOf(l1), paramAnonymousString);
                    localObject3 = com.tencent.mm.modelcdntran.h.a("upimg", paramAnonymousc.getCreateTime(), paramAnonymousc.field_talker, paramAnonymousc.field_msgId + "_" + l1 + "_" + j);
                    localObject2 = new ftv();
                    ((ftv)localObject2).YFE = new etl().btH(str1);
                    ((ftv)localObject2).YFF = new etl().btH((String)localObject1);
                    ((ftv)localObject2).IIs = paramAnonymousc.getType();
                    ((ftv)localObject2).YFJ = paramAnonymousc.jUr;
                    ((ftv)localObject2).ZaQ = paramAnonymousString.oGv;
                    ((ftv)localObject2).abRT = new etl().btH((String)localObject3);
                    ((ftv)localObject2).aava = j;
                    paramAnonymousd.field_filemd5 = str2;
                    paramAnonymousd.field_thumbimgLength = ((int)y.bEl(str3));
                    paramAnonymousd.field_fileLength = paramAnonymousInt;
                    localObject1 = com.tencent.mm.modelimage.d.bJA();
                    ((com.tencent.mm.modelimage.d)localObject1).mxO = i;
                    ((com.tencent.mm.modelimage.d)localObject1).oGa = ((ftv)localObject2);
                    ((com.tencent.mm.modelimage.d)localObject1).oGb = paramAnonymousString;
                    ((com.tencent.mm.modelimage.d)localObject1).mxU = paramAnonymousd;
                    ((com.tencent.mm.modelimage.d)localObject1).oGc = new m.2(l2, l3);
                    ((t.e)localObject1).toUser = paramAnonymousc.field_talker;
                    ((t.e)localObject1).bKW().aXz();
                    for (;;)
                    {
                      AppMethodBeat.o(34390);
                      return 0;
                      label766:
                      paramAnonymousBoolean = false;
                      break;
                      Log.d("MicroMsg.ChattingEditModeLogic", "not support second !! dealDownLoadImg");
                      paramAnonymousString = r.bKa().v(this.oIE.oGt, "th_", "");
                      m.a(paramContext, this.oIE, m.this, this.vHo, paramString, paramAnonymousString);
                    }
                    l1 = l2;
                  }
                }
              }
            }
            
            public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
            
            public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
            {
              return new byte[0];
            }
          };
          localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, paramcc.field_msgId);
          localg.field_fileId = ((String)localObject1);
          localg.field_aesKey = str4;
          localg.field_filemd5 = ((String)localObject3);
          localg.field_fileType = i;
          localg.field_talker = paramString;
          localg.field_priority = com.tencent.mm.g.a.lvZ;
          localg.field_svr_signature = "";
          localg.field_onlycheckexist = true;
          localg.field_trysafecdn = true;
          if (!com.tencent.mm.modelcdntran.k.bHW().g(localg))
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
      com.tencent.mm.plugin.messenger.a.g.gaI().a(paramContext, paramString, (String)localObject1, i, ((com.tencent.mm.modelimage.h)localObject2).oGC, str1, paramcc.field_msgId, null);
    }
    AppMethodBeat.o(34427);
  }
  
  public static void b(Context paramContext, String paramString, cc paramcc, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(34432);
    if (!a(paramContext, paramString, paramcc, "appmsg"))
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
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(34432);
      return;
    }
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(34432);
      return;
    }
    paramContext = r.bKa().d(paramcc.field_imgPath, false, false);
    if ((!com.tencent.mm.platformtools.ab.isNullOrNil(paramContext)) && (!paramContext.endsWith("hd")) && (y.ZC(paramContext + "hd"))) {
      paramContext = paramContext + "hd";
    }
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
        localObject3 = ((com.tencent.mm.message.u)localObject1).nUC;
        if ((localObject3 == null) || (((List)localObject3).size() <= 0))
        {
          localObject1 = localObject2;
          if (paramcc != null) {
            if (!paramcc.fxR())
            {
              localObject1 = localObject2;
              if (!paramcc.iYe()) {}
            }
            else
            {
              localObject1 = ad.Jo(paramcc.field_msgSvrId);
              localObject2 = ad.bCb().M((String)localObject1, true);
              ((ad.b)localObject2).q("prePublishId", "msg_" + paramcc.field_msgSvrId);
              ((ad.b)localObject2).q("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(paramcc, paramBoolean, false));
              ((ad.b)localObject2).q("preChatName", paramcc.field_talker);
              ((ad.b)localObject2).q("preMsgIndex", Integer.valueOf(0));
              ((ad.b)localObject2).q("sendAppMsgScene", Integer.valueOf(1));
              ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).a("adExtStr", (ad.b)localObject2, paramcc);
            }
          }
          com.tencent.mm.plugin.messenger.a.g.gaI().a(paramString, Util.readFromFile(paramContext), Util.processXml(paramcc.field_content), (String)localObject1, bt.JV(paramcc.jUr));
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
      paramcc = ((List)localObject3).iterator();
      while (paramcc.hasNext())
      {
        localObject3 = (com.tencent.mm.message.v)paramcc.next();
        localObject2 = new k.b();
        if (com.tencent.mm.message.m.Hh(((com.tencent.mm.message.v)localObject3).nUR))
        {
          o.b(paramString, o.a(paramString, (com.tencent.mm.message.v)localObject3), ((com.tencent.mm.message.v)localObject3).nUW);
        }
        else
        {
          ((k.b)localObject2).title = ((com.tencent.mm.message.v)localObject3).title;
          ((k.b)localObject2).description = ((com.tencent.mm.message.v)localObject3).nUO;
          ((k.b)localObject2).action = "view";
          ((k.b)localObject2).type = 5;
          ((k.b)localObject2).url = ((com.tencent.mm.message.v)localObject3).url;
          ((k.b)localObject2).iaa = ((com.tencent.mm.message.u)localObject1).iaa;
          ((k.b)localObject2).iab = ((com.tencent.mm.message.u)localObject1).iab;
          ((k.b)localObject2).kLg = ((com.tencent.mm.message.u)localObject1).kLg;
          ((k.b)localObject2).thumburl = com.tencent.mm.message.m.a((com.tencent.mm.message.v)localObject3);
          com.tencent.mm.message.e locale = new com.tencent.mm.message.e();
          locale.nQm = ((com.tencent.mm.message.v)localObject3).type;
          locale.nQp = ((com.tencent.mm.message.v)localObject3).nQp;
          if (((com.tencent.mm.message.v)localObject3).type == 5)
          {
            locale.vid = ((com.tencent.mm.message.v)localObject3).vid;
            locale.nQn = ((int)((com.tencent.mm.message.v)localObject3).time);
            locale.duration = ((com.tencent.mm.message.v)localObject3).nUQ;
            locale.videoWidth = ((com.tencent.mm.message.v)localObject3).videoWidth;
            locale.videoHeight = ((com.tencent.mm.message.v)localObject3).videoHeight;
          }
          ((k.b)localObject2).a(locale);
          if ((Util.isNullOrNil(((k.b)localObject2).thumburl)) && (!Util.isNullOrNil(((k.b)localObject2).iaa)))
          {
            localObject3 = com.tencent.mm.modelavatar.q.bFE().LS(((k.b)localObject2).iaa);
            if (localObject3 != null) {
              ((k.b)localObject2).thumburl = ((com.tencent.mm.modelavatar.j)localObject3).bFw();
            }
          }
          localObject2 = k.b.a((k.b)localObject2, null, null);
          com.tencent.mm.plugin.messenger.a.g.gaI().a(paramString, Util.readFromFile(paramContext), Util.processXml((String)localObject2), null);
        }
      }
      AppMethodBeat.o(34432);
      return;
    }
  }
  
  public static boolean bM(cc paramcc)
  {
    AppMethodBeat.i(34397);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
      AppMethodBeat.o(34397);
      return true;
    }
    if (paramcc.jbH())
    {
      bg localbg = new bg(paramcc.field_content);
      paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramcc != null) {
        break label314;
      }
      paramcc = new k.b();
      paramcc.nRf = localbg.md5;
    }
    label314:
    for (;;)
    {
      for (paramcc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.nRf); (paramcc != null) && ((paramcc.field_catalog == EmojiInfo.aklM) || ((!Util.isNullOrNil(paramcc.field_groupId)) && (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoj(paramcc.field_groupId)))); paramcc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath))
      {
        AppMethodBeat.o(34397);
        return false;
      }
      if (paramcc != null)
      {
        if ((Util.isNullOrNil(paramcc.field_app_id)) && (!Util.isNullOrNil(paramcc.field_groupId)) && (!paramcc.field_groupId.equals(String.valueOf(EmojiGroupInfo.aklE))) && (!paramcc.field_groupId.equals(String.valueOf(EmojiGroupInfo.aklD))) && (!paramcc.field_groupId.equals(String.valueOf(EmojiGroupInfo.aklF))) && (!paramcc.field_groupId.equals(String.valueOf(EmojiInfo.aklG))) && (!paramcc.field_groupId.equals("capture"))) {}
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
  
  public static boolean bN(cc paramcc)
  {
    AppMethodBeat.i(34398);
    if (paramcc.jbH())
    {
      bg localbg = new bg(paramcc.field_content);
      paramcc = k.b.aP(paramcc.field_content, paramcc.field_reserved);
      if (paramcc != null) {
        break label99;
      }
      paramcc = new k.b();
      paramcc.nRf = localbg.md5;
    }
    label99:
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.nRf) == null)
      {
        AppMethodBeat.o(34398);
        return false;
      }
      AppMethodBeat.o(34398);
      return true;
    }
  }
  
  public static boolean bO(cc paramcc)
  {
    AppMethodBeat.i(34399);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
      AppMethodBeat.o(34399);
      return true;
    }
    if (paramcc.field_isSend == 0) {}
    for (paramcc = br.JK(paramcc.field_content);; paramcc = paramcc.field_content)
    {
      paramcc = k.b.Hf(paramcc);
      if (paramcc != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
      AppMethodBeat.o(34399);
      return false;
    }
    paramcc = com.tencent.mm.pluginsdk.model.app.h.s(paramcc.appId, false, false);
    if ((paramcc != null) && (paramcc.aqJ()))
    {
      AppMethodBeat.o(34399);
      return true;
    }
    AppMethodBeat.o(34399);
    return false;
  }
  
  public static boolean bP(cc paramcc)
  {
    AppMethodBeat.i(34400);
    if (paramcc.getType() == 419430449)
    {
      AppMethodBeat.o(34400);
      return true;
    }
    AppMethodBeat.o(34400);
    return false;
  }
  
  public static boolean bQ(cc paramcc)
  {
    AppMethodBeat.i(34401);
    if ((paramcc.getType() == 436207665) || (paramcc.getType() == 469762097))
    {
      AppMethodBeat.o(34401);
      return true;
    }
    AppMethodBeat.o(34401);
    return false;
  }
  
  public static boolean bR(cc paramcc)
  {
    AppMethodBeat.i(34402);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(34402);
      return true;
    }
    if (paramcc.field_isSend == 0) {}
    for (paramcc = br.JK(paramcc.field_content);; paramcc = paramcc.field_content)
    {
      paramcc = k.b.Hf(paramcc);
      if (paramcc != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(34402);
      return false;
    }
    if ((paramcc.nTM != 0) || ((paramcc.type == 33) && (paramcc.nTF == 3)) || ((paramcc.type == 36) && (paramcc.nTF == 3)) || ((paramcc.type == 46) && (paramcc.nTF == 3)) || ((paramcc.type == 44) && ((paramcc.nTF == 3) || (!paramcc.gK(false)))) || ((paramcc.type == 48) && (paramcc.nTF == 3)))
    {
      AppMethodBeat.o(34402);
      return true;
    }
    AppMethodBeat.o(34402);
    return false;
  }
  
  public static boolean bS(cc paramcc)
  {
    AppMethodBeat.i(253872);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "isTeenModeAuthForbidForwardMsg, check msg error, msg is null");
      AppMethodBeat.o(253872);
      return true;
    }
    if (paramcc.field_isSend == 0) {}
    for (paramcc = br.JK(paramcc.field_content);; paramcc = paramcc.field_content)
    {
      paramcc = k.b.Hf(paramcc);
      if (paramcc != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "isTeenModeAuthForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(253872);
      return false;
    }
    if ((paramcc.type == 83) || (paramcc.type == 84))
    {
      AppMethodBeat.o(253872);
      return true;
    }
    AppMethodBeat.o(253872);
    return false;
  }
  
  public static boolean bT(cc paramcc)
  {
    AppMethodBeat.i(253877);
    if (paramcc == null)
    {
      AppMethodBeat.o(253877);
      return false;
    }
    if (paramcc.field_isSend == 0) {}
    for (paramcc = br.JK(paramcc.field_content);; paramcc = paramcc.field_content)
    {
      paramcc = k.b.Hf(paramcc);
      if (paramcc != null) {
        break;
      }
      Log.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
      AppMethodBeat.o(253877);
      return false;
    }
    boolean bool = paramcc.bwp();
    AppMethodBeat.o(253877);
    return bool;
  }
  
  private static boolean bU(cc paramcc)
  {
    AppMethodBeat.i(34405);
    if (paramcc != null)
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 19))
      {
        Object localObject = new tr();
        ((tr)localObject).hXt.type = 0;
        ((tr)localObject).hXt.hXv = paramcc.nRF;
        ((tr)localObject).publish();
        localObject = ((tr)localObject).hXu.hXD;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.protocal.b.a.c)localObject).nUC.iterator();
          while (((Iterator)localObject).hasNext())
          {
            arf localarf = (arf)((Iterator)localObject).next();
            if (!Util.isNullOrNil(localarf.ZzW))
            {
              Log.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[] { Integer.valueOf(localarf.dataType) });
              AppMethodBeat.o(34405);
              return true;
            }
          }
        }
        if ((paramcc.nRF != null) && (paramcc.nRF.contains("<recordxml>")))
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
  
  private static boolean bV(cc paramcc)
  {
    AppMethodBeat.i(34406);
    if (paramcc != null)
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 24))
      {
        AppMethodBeat.o(34406);
        return true;
      }
    }
    AppMethodBeat.o(34406);
    return false;
  }
  
  public static boolean bW(cc paramcc)
  {
    AppMethodBeat.i(34407);
    if (paramcc != null)
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if (paramcc == null)
      {
        AppMethodBeat.o(34407);
        return false;
      }
      if ((paramcc.type == 6) || (paramcc.type == 5) || (paramcc.type == 19))
      {
        AppMethodBeat.o(34407);
        return true;
      }
    }
    AppMethodBeat.o(34407);
    return false;
  }
  
  public static boolean bX(cc paramcc)
  {
    AppMethodBeat.i(34408);
    if ((paramcc == null) || (!paramcc.iYe()))
    {
      AppMethodBeat.o(34408);
      return false;
    }
    boolean bool = com.tencent.mm.message.m.e(paramcc.field_msgId, paramcc.field_content);
    AppMethodBeat.o(34408);
    return bool;
  }
  
  static boolean bY(cc paramcc)
  {
    AppMethodBeat.i(34409);
    if (paramcc != null)
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 16))
      {
        AppMethodBeat.o(34409);
        return true;
      }
      if ((paramcc != null) && (paramcc.type == 34))
      {
        AppMethodBeat.o(34409);
        return true;
      }
    }
    AppMethodBeat.o(34409);
    return false;
  }
  
  private static boolean bZ(cc paramcc)
  {
    AppMethodBeat.i(253915);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVK, 0) == 1) {}
    for (int i = 1; (i != 0) && (paramcc.getType() == 67); i = 0)
    {
      AppMethodBeat.o(253915);
      return true;
    }
    AppMethodBeat.o(253915);
    return false;
  }
  
  public static void c(Context paramContext, final String paramString, final cc paramcc)
  {
    AppMethodBeat.i(34430);
    if ((!a(paramContext, paramString, paramcc, "video")) || (paramcc == null))
    {
      AppMethodBeat.o(34430);
      return;
    }
    if ((paramcc != null) && (paramcc.dSJ()) && (com.tencent.mm.modelvideo.ab.Qp(paramcc.field_imgPath)))
    {
      AppMethodBeat.o(34430);
      return;
    }
    Object localObject = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    if ((localObject != null) && (((com.tencent.mm.modelvideo.z)localObject).status == 199))
    {
      a(paramcc.field_imgPath, paramString, ((com.tencent.mm.modelvideo.z)localObject).pbf, ((com.tencent.mm.modelvideo.z)localObject).omT, ((com.tencent.mm.modelvideo.z)localObject).bOu(), paramcc.getType(), paramcc.field_msgId);
      AppMethodBeat.o(34430);
      return;
    }
    Map localMap = XmlParser.parseXml(((com.tencent.mm.modelvideo.z)localObject).bOu(), "msg", null);
    final int i;
    if (localMap == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "%s cdntra parse video recv xml failed");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        f(paramString, paramcc);
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1328L, 12L, 1L, true);
        if (Util.isNullOrNil(str2))
        {
          com.tencent.mm.modelvideo.v.bOh();
          if (!y.ZC(aa.PX(((com.tencent.mm.modelvideo.z)localObject).getFileName())))
          {
            Log.i("MicroMsg.ChattingEditModeLogic", "checkVideoCdnInfo md5 %s", new Object[] { str2 });
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1328L, 2L, 1L, true);
            i = 0;
            continue;
          }
        }
        localObject = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject).taskName = "task_ChattingEditModeLogic_2";
        ((com.tencent.mm.g.g)localObject).lwL = new g.a()
        {
          public final int a(final String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(34394);
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label370;
              }
              paramAnonymousd.field_fileId = m.this;
              paramAnonymousd.field_aesKey = str1;
              paramAnonymousd.field_thumbimgLength = k;
              paramAnonymousd.field_fileLength = i;
              paramAnonymousd.field_toUser = paramString;
              paramAnonymousd.field_filemd5 = str2;
              paramAnonymousd.field_mp4identifymd5 = str3;
              Log.i("MicroMsg.ChattingEditModeLogic", "support second!! sceneResult: %s", new Object[] { paramAnonymousd });
              paramAnonymousString = aa.PW(paramString);
              com.tencent.mm.modelvideo.v.bOh();
              paramAnonymousc = aa.PY(paramAnonymousString);
              com.tencent.mm.modelvideo.v.bOh();
              y.O(aa.PY(paramcc.field_imgPath), paramAnonymousc, false);
              paramAnonymousc = "<msg><videomsg aeskey=\"" + str1 + "\" cdnthumbaeskey=\"" + str1 + "\" cdnvideourl=\"" + m.this + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumburl=\"" + m.this + "\" ";
              paramAnonymousc = paramAnonymousc + "length=\"" + i + "\" ";
              paramAnonymousc = paramAnonymousc + "cdnthumblength=\"" + k + "\"/></msg>";
              Log.i("MicroMsg.ChattingEditModeLogic", "cdn callback new build cdnInfo:%s", new Object[] { paramAnonymousc });
              com.tencent.mm.modelvideo.ab.b(paramAnonymousString, j, paramString, paramAnonymousc, (int)paramcc.field_msgId);
              paramAnonymousc = t.bKi();
              paramAnonymousc.fileName = paramAnonymousString;
              paramAnonymousc.oJI = 0;
              paramAnonymousc.oJJ = paramAnonymousd;
              paramAnonymousc.oJK = new com.tencent.mm.modelimage.g()
              {
                public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(34393);
                  com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(paramAnonymousString);
                  localz.status = 111;
                  localz.eQp = 256;
                  com.tencent.mm.modelvideo.v.bOh().c(localz);
                  Log.d("MicroMsg.ChattingEditModeLogic", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                  AppMethodBeat.o(34393);
                }
              };
              paramAnonymousc.oNj = 4;
              paramAnonymousc.bKW().aXz();
            }
            for (;;)
            {
              AppMethodBeat.o(34394);
              return 0;
              label370:
              m.f(paramString, paramcc);
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.g.g)localObject).field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, paramcc.field_msgId);
        ((com.tencent.mm.g.g)localObject).field_fileId = paramContext;
        ((com.tencent.mm.g.g)localObject).field_aesKey = str1;
        ((com.tencent.mm.g.g)localObject).field_filemd5 = str2;
        ((com.tencent.mm.g.g)localObject).field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
        ((com.tencent.mm.g.g)localObject).field_talker = paramString;
        ((com.tencent.mm.g.g)localObject).field_priority = com.tencent.mm.g.a.lvZ;
        ((com.tencent.mm.g.g)localObject).field_svr_signature = "";
        ((com.tencent.mm.g.g)localObject).field_onlycheckexist = true;
        ((com.tencent.mm.g.g)localObject).field_trysafecdn = true;
        if (!com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject))
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
  
  public static void c(Context paramContext, String paramString, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(34433);
    if (!a(paramContext, paramString, paramcc, "location"))
    {
      AppMethodBeat.o(34433);
      return;
    }
    paramContext = G(paramcc.field_content, paramcc.field_isSend, paramBoolean);
    com.tencent.mm.plugin.messenger.a.g.gaI().ap(paramString, paramContext, 48);
    AppMethodBeat.o(34433);
  }
  
  public static boolean ca(cc paramcc)
  {
    AppMethodBeat.i(34412);
    if (paramcc.jbC())
    {
      AppMethodBeat.o(34412);
      return false;
    }
    bh.bCz();
    cc.a locala = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((locala.hgk == null) || (locala.hgk.length() <= 0)) {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!com.tencent.mm.model.ab.uY(locala.WAW)) && (paramcc.getType() == 42))
    {
      boolean bool = paramcc.jbV();
      AppMethodBeat.o(34412);
      return bool;
    }
    AppMethodBeat.o(34412);
    return false;
  }
  
  public static boolean cb(cc paramcc)
  {
    AppMethodBeat.i(34413);
    bh.bCz();
    cc.a locala = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((locala.hgk == null) || (locala.hgk.length() <= 0)) {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
    }
    if ((!com.tencent.mm.model.ab.uY(locala.WAW)) && (paramcc.getType() == 42))
    {
      if ((paramcc.jUq & 0x800) > 0)
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
  
  static boolean cc(cc paramcc)
  {
    AppMethodBeat.i(34414);
    if (paramcc.jbC())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    if (!paramcc.jbB())
    {
      AppMethodBeat.o(34414);
      return false;
    }
    bh.bCz();
    paramcc = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((paramcc == null) || (Util.isNullOrNil(paramcc.hgk)))
    {
      AppMethodBeat.o(34414);
      return true;
    }
    if (com.tencent.mm.model.ab.IS(paramcc.hgk))
    {
      AppMethodBeat.o(34414);
      return false;
    }
    AppMethodBeat.o(34414);
    return true;
  }
  
  private static boolean cd(cc paramcc)
  {
    AppMethodBeat.i(253924);
    if ((paramcc != null) && (paramcc.fxR()))
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 6) && (paramcc.nRd >= 1073741824))
      {
        AppMethodBeat.o(253924);
        return true;
      }
    }
    AppMethodBeat.o(253924);
    return false;
  }
  
  public static boolean ce(cc paramcc)
  {
    AppMethodBeat.i(34416);
    if ((paramcc != null) && (paramcc.fxR()))
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 6))
      {
        AppMethodBeat.o(34416);
        return true;
      }
    }
    AppMethodBeat.o(34416);
    return false;
  }
  
  public static void d(EmojiInfo paramEmojiInfo, String paramString)
  {
    AppMethodBeat.i(34436);
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    String str = paramEmojiInfo.kMn();
    if (y.bEl(str + "_thumb") > 0L)
    {
      int i = (int)y.bEl(str + "_thumb");
      localWXMediaMessage.thumbData = y.bi(str + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject(str);
      com.tencent.mm.pluginsdk.model.app.n.a(localWXMediaMessage, paramEmojiInfo.field_app_id, null, paramString, 1, paramEmojiInfo.getMd5());
      AppMethodBeat.o(34436);
      return;
      try
      {
        InputStream localInputStream = y.Lh(str);
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
  
  static void f(final String paramString, cc paramcc)
  {
    AppMethodBeat.i(34429);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34396);
        com.tencent.mm.modelvideo.v.bOm().a(m.this.field_imgPath, new aa.a()
        {
          public final void a(aa.a.a paramAnonymous2a)
          {
            AppMethodBeat.i(34395);
            paramAnonymous2a = com.tencent.mm.modelvideo.ab.Qo(paramAnonymous2a.fileName);
            if ((paramAnonymous2a != null) && (paramAnonymous2a.status == 199)) {
              m.a(m.this.field_imgPath, m.5.this.lzC, paramAnonymous2a.pbf, paramAnonymous2a.omT, paramAnonymous2a.bOu(), m.this.getType(), m.this.field_msgId);
            }
            AppMethodBeat.o(34395);
          }
        });
        AppMethodBeat.o(34396);
      }
    });
    AppMethodBeat.o(34429);
  }
  
  private static boolean g(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(34410);
    if (!paramBoolean)
    {
      AppMethodBeat.o(34410);
      return false;
    }
    if (paramcc != null)
    {
      paramcc = k.b.Hf(paramcc.field_content);
      if ((paramcc != null) && (paramcc.type == 33) && (paramcc.nTF == 1))
      {
        AppMethodBeat.o(34410);
        return true;
      }
    }
    AppMethodBeat.o(34410);
    return false;
  }
  
  private static boolean i(cc paramcc, String paramString)
  {
    AppMethodBeat.i(34411);
    bh.bCz();
    cc.a locala = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((locala.hgk == null) || (locala.hgk.length() <= 0))
    {
      Log.e("MicroMsg.ChattingEditModeLogic", "getView : parse possible friend msg failed");
      AppMethodBeat.o(34411);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yVK, 0) == 1) {}
    for (int i = 1; (i != 0) && ((au.bwO(paramString)) || (au.bwP(paramString)) || (paramcc.getType() == 66)); i = 0)
    {
      AppMethodBeat.o(34411);
      return true;
    }
    AppMethodBeat.o(34411);
    return false;
  }
  
  public static List<String> jpe()
  {
    AppMethodBeat.i(34422);
    Object localObject1 = af.bHf().vP(25);
    Object localObject2 = af.bHf();
    Object localObject3 = new ArrayList();
    Object localObject4 = new StringBuilder();
    com.tencent.mm.an.f.b((StringBuilder)localObject4);
    com.tencent.mm.an.f.d((StringBuilder)localObject4);
    com.tencent.mm.an.f.e((StringBuilder)localObject4);
    com.tencent.mm.an.f.a((StringBuilder)localObject4, true);
    ((StringBuilder)localObject4).append(" order by ");
    ((StringBuilder)localObject4).append(com.tencent.mm.an.f.bGD());
    localObject4 = ((StringBuilder)localObject4).toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[] { localObject4 });
    localObject2 = ((com.tencent.mm.an.f)localObject2).rawQuery((String)localObject4, new String[0]);
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
      str = com.tencent.mm.an.g.hU((String)localObject4).aAX();
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
      if (com.tencent.mm.an.g.Mz(str))
      {
        if (com.tencent.mm.an.g.MD(str))
        {
          str = com.tencent.mm.an.g.hU(str).field_enterpriseFather;
          if ((!((List)localObject4).contains(str)) && (com.tencent.mm.an.g.MB(str)))
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
  
  public static List<String> jpf()
  {
    AppMethodBeat.i(34423);
    Object localObject = af.bHf().vP(25);
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!com.tencent.mm.an.g.Mz(str)) {
        localLinkedList.add(str);
      }
    }
    Log.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    AppMethodBeat.o(34423);
    return localLinkedList;
  }
  
  public static boolean nn(List<cc> paramList)
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
      cc localcc = (cc)paramList.next();
      if ((localcc.iYj()) || (bM(localcc)) || (localcc.jbB()) || (bO(localcc)) || (bP(localcc)) || (localcc.getType() == -1879048186) || (bY(localcc)) || (bQ(localcc)) || (bX(localcc)) || (bR(localcc)) || (ce(localcc)) || (bT(localcc)))
      {
        AppMethodBeat.o(34403);
        return true;
      }
    }
    AppMethodBeat.o(34403);
    return false;
  }
  
  public static int no(List<cc> paramList)
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
      cc localcc = (cc)paramList.next();
      if ((!localcc.iYj()) && (!bM(localcc)) && (!localcc.fxT()) && (!bO(localcc)) && (!bP(localcc)) && (!bQ(localcc))) {
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
  
  public static boolean np(List<cc> paramList)
  {
    AppMethodBeat.i(34418);
    if (paramList == null)
    {
      Log.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
      AppMethodBeat.o(34418);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    label406:
    label407:
    for (;;)
    {
      cc localcc;
      if (localIterator.hasNext())
      {
        localcc = (cc)localIterator.next();
        if ((localcc.iYk()) || (localcc.jbK()))
        {
          paramList = null;
          if (localcc.field_msgId > 0L) {
            paramList = r.bKa().H(localcc.field_talker, localcc.field_msgId);
          }
          if (((paramList != null) && (paramList.localId > 0L)) || (localcc.field_msgSvrId <= 0L)) {
            break label406;
          }
          paramList = r.bKa().G(localcc.field_talker, localcc.field_msgSvrId);
        }
      }
      for (;;)
      {
        if ((paramList == null) || ((paramList.offset >= paramList.osy) && (paramList.osy != 0))) {
          break label407;
        }
        AppMethodBeat.o(34418);
        return true;
        if (localcc.dSH())
        {
          paramList = com.tencent.mm.modelvideo.v.bOh().PR(localcc.field_imgPath);
          if ((paramList == null) || (paramList.status == 199) || (paramList.status == 199)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localcc.jbH())
        {
          if (bN(localcc)) {
            break;
          }
          AppMethodBeat.o(34418);
          return true;
        }
        if (localcc.fxR())
        {
          paramList = k.b.aP(localcc.field_content, localcc.field_content);
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
            paramList = as.cWJ().bpI(paramList.hzM);
            if (paramList == null)
            {
              AppMethodBeat.o(34418);
              return true;
            }
          case 74: 
            AppMethodBeat.o(34418);
            return true;
            if (new com.tencent.mm.vfs.u(paramList.field_fileFullPath).jKS()) {
              break;
            }
            AppMethodBeat.o(34418);
            return true;
          }
        }
        if (!localcc.dSJ()) {
          break;
        }
        paramList = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
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
  
  public static boolean nq(List<cc> paramList)
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
      cc localcc = (cc)paramList.next();
      if ((localcc.dSH()) && (com.tencent.mm.pluginsdk.model.q.bpy(localcc.field_imgPath)))
      {
        AppMethodBeat.o(34419);
        return true;
      }
    }
    AppMethodBeat.o(34419);
    return false;
  }
  
  public static boolean nr(List<cc> paramList)
  {
    AppMethodBeat.i(253939);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(253939);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (cc)paramList.next();
      if (((cc)localObject).dSH())
      {
        ae.a locala = ae.pbN;
        localObject = ae.a.Qv(((fi)localObject).field_reserved);
        if ((localObject != null) && (((ae)localObject).pbO))
        {
          AppMethodBeat.o(253939);
          return true;
        }
      }
    }
    AppMethodBeat.o(253939);
    return false;
  }
  
  public static boolean ns(List<cc> paramList)
  {
    AppMethodBeat.i(34420);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(34420);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((cc)paramList.next()).dSJ())
      {
        AppMethodBeat.o(34420);
        return true;
      }
    }
    AppMethodBeat.o(34420);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m
 * JD-Core Version:    0.7.0.1
 */