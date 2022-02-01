package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class p
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> fTI;
  
  static
  {
    AppMethodBeat.i(9549);
    fTI = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static int a(final String paramString1, final akd paramakd, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramakd == null) || (paramakd.nZa.isEmpty()))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramakd);
    final bu localbu = new bu();
    paramString2 = null;
    if (!bt.isNullOrNil(paramString4))
    {
      paramString2 = bt.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label362;
        }
      }
    }
    long l;
    label362:
    for (paramString2 = com.tencent.mm.aw.q.aIF().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.aw.q.aIF().aa(paramString2))
    {
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " thumbData MsgInfo path:" + paramString2);
      if (!bt.isNullOrNil(paramString2)) {
        localbu.tO(paramString2);
      }
      localbu.setContent(k.b.a(paramString3, null, null));
      localbu.setStatus(1);
      localbu.tN(paramString1);
      localbu.qA(bj.Bo(paramString1));
      localbu.kr(1);
      localbu.setType(49);
      if (com.tencent.mm.am.g.vd(paramString1)) {
        localbu.sP(com.tencent.mm.am.a.e.VW());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label373;
      }
      ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9528);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.g.Bitmap2Bytes(com.tencent.mm.sdk.platformtools.g.aat(paramInt));
        break;
      }
      if (bt.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.g.Bitmap2Bytes(com.tencent.mm.ak.c.a(paramString5, false, -1, null));
      break;
    }
    label373:
    ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localbu.setMsgId(l);
    paramString2 = new com.tencent.mm.ai.k();
    paramString2.field_xml = localbu.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.s.a.dxR().insert(paramString2);
    paramString2 = paramakd.nZa.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (ajn)paramString2.next();
    } while ((bt.isNullOrNil(paramString4.GgR)) && (bt.isNullOrNil(paramString4.hAe)));
    paramString2 = b(paramString1, paramakd);
    if (paramString2.size() > 0) {
      com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.pluginsdk.g.a(paramString2, new a.a()
      {
        public final void bE(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(213099);
          if (paramAnonymousInt == 0)
          {
            p.d(this.cWB, paramString1.getTitle(), paramString1.getDescription(), paramakd, localbu);
            AppMethodBeat.o(213099);
            return;
          }
          if (-3200 == paramAnonymousInt)
          {
            ad.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.cWB), paramakd });
            p.c(this.cWB, this.hED);
            p.b(this.cWB, this.hED, paramakd);
            ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).w(this.cWB, paramakd);
            AppMethodBeat.o(213099);
            return;
          }
          this.hED.setStatus(5);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.cWB, this.hED);
          p.iH(paramakd, paramAnonymousString);
          AppMethodBeat.o(213099);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(9528);
      return 0;
      b(l, paramString3.getTitle(), paramString3.getDescription(), paramString1, paramakd);
    }
  }
  
  public static int a(String paramString1, String paramString2, bu parambu)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, parambu, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, bu parambu, final boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((parambu == null) || (bt.isNullOrNil(parambu.field_content)))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == parambu.field_status)
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = bt.U(paramString1.split(",")).iterator();
    label782:
    while (paramString1.hasNext())
    {
      final String str = (String)paramString1.next();
      ad.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambu.field_msgId), Integer.valueOf(parambu.field_status) });
      Object localObject1 = bj.Bl(parambu.field_content);
      final k.b localb = k.b.yr((String)localObject1);
      if (localb == null)
      {
        ad.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final com.tencent.mm.protocal.b.a.c localc = avr(localb.hAs);
      if (localc == null)
      {
        ad.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final bu localbu = new bu();
      Object localObject2;
      if (!bt.isNullOrNil(parambu.field_imgPath))
      {
        localObject2 = bt.readFromFile(com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true));
        localObject2 = com.tencent.mm.aw.q.aIF().aa((byte[])localObject2);
        ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " thumbData from msg MsgInfo path:" + (String)localObject2);
        if (!bt.isNullOrNil((String)localObject2)) {
          localbu.tO((String)localObject2);
        }
      }
      localbu.setContent((String)localObject1);
      localbu.setStatus(1);
      localbu.tN(str);
      localbu.qA(bj.Bo(str));
      localbu.kr(1);
      localbu.setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbu.setMsgId(l);
      localObject1 = new xg();
      ((xg)localObject1).dLB.dLC = parambu.field_msgId;
      ((xg)localObject1).dLB.dLD = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new com.tencent.mm.ai.k();
      ((com.tencent.mm.ai.k)localObject1).field_xml = localbu.field_content;
      ((com.tencent.mm.ai.k)localObject1).field_title = localb.title;
      ((com.tencent.mm.ai.k)localObject1).field_type = localb.type;
      ((com.tencent.mm.ai.k)localObject1).field_description = localb.description;
      ((com.tencent.mm.ai.k)localObject1).field_msgId = l;
      ((com.tencent.mm.ai.k)localObject1).field_appId = localb.appId;
      com.tencent.mm.plugin.s.a.dxR().insert((com.tencent.mm.sdk.e.c)localObject1);
      if (g(localc.hDb, paramBoolean))
      {
        localObject1 = new akd();
        ((akd)localObject1).nZa.addAll(localc.hDb);
        localObject2 = b(str, (akd)localObject1);
        if (((List)localObject2).size() > 0) {
          com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.pluginsdk.g.a((List)localObject2, new a.a()
          {
            public final void bE(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(213098);
              if (paramAnonymousInt == 0)
              {
                p.b(this.cWB, str.field_msgId, localb, localc, this.xri, paramBoolean, localbu);
                AppMethodBeat.o(213098);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                ad.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.cWB), localb });
                p.c(this.cWB, this.hED);
                p.a(this.cWB, str.field_msgId, this.hED, localb, localbu);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).w(this.cWB, localb);
                AppMethodBeat.o(213098);
                return;
              }
              this.hED.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.cWB, this.hED);
              p.iH(localb, paramAnonymousString);
              AppMethodBeat.o(213098);
            }
          }), 0);
        }
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramString2)) {
          break label782;
        }
        com.tencent.mm.plugin.messenger.a.g.dlD().aa(str, paramString2, w.Ar(str));
        break;
        a(l, parambu.field_msgId, str, localb, localc, (akd)localObject1, paramBoolean);
        continue;
        ad.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).yC(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static Pair<Long, Boolean> a(Context paramContext, final String paramString1, final String paramString2, List<bu> paramList, cv paramcv, com.tencent.mm.protocal.b.a.d paramd, String paramString3)
  {
    AppMethodBeat.i(213105);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(213105);
      return paramContext;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(213105);
      return paramContext;
    }
    if ((paramcv == null) || (paramd == null))
    {
      paramcv = new cv();
      if (!c.a(paramContext, paramcv, paramString2, paramList))
      {
        paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
        AppMethodBeat.o(213105);
        return paramContext;
      }
      paramd = a(paramContext, paramcv, paramString2);
    }
    for (paramString2 = paramcv;; paramString2 = paramcv)
    {
      paramcv = a(paramd.title, paramd.desc, paramString2.dnG.dnI);
      final bu localbu = new bu();
      paramList = null;
      if (!bt.isNullOrNil(paramd.thumbPath))
      {
        paramContext = bt.readFromFile(paramd.thumbPath);
        if (paramContext != null) {
          if (paramContext.length <= 65536) {
            break label498;
          }
        }
      }
      long l;
      label498:
      for (paramContext = com.tencent.mm.aw.q.aIF().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.aw.q.aIF().aa(paramContext))
      {
        ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " thumbData MsgInfo path:" + paramContext);
        if (!bt.isNullOrNil(paramContext)) {
          localbu.tO(paramContext);
        }
        localbu.setContent(k.b.a(paramcv, null, null));
        localbu.setStatus(1);
        localbu.tN(paramString1);
        localbu.qA(bj.Bo(paramString1));
        localbu.kr(1);
        localbu.setType(49);
        if (com.tencent.mm.am.g.vd(paramString1)) {
          localbu.sP(com.tencent.mm.am.a.e.VW());
        }
        l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(localbu);
        ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label509;
        }
        ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abi() + "insert msg failed :" + l);
        paramContext = new Pair(Long.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Boolean.FALSE);
        AppMethodBeat.o(213105);
        return paramContext;
        paramContext = paramList;
        if (paramd.dER != 0) {
          break;
        }
        paramContext = paramList;
        if (bt.isNullOrNil(paramd.rxX)) {
          break;
        }
        paramContext = com.tencent.mm.sdk.platformtools.g.Bitmap2Bytes(com.tencent.mm.ak.c.a(paramd.rxX, false, -1, null));
        break;
      }
      label509:
      ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbu.setMsgId(l);
      paramContext = new com.tencent.mm.ai.k();
      paramContext.field_xml = localbu.field_content;
      paramContext.field_title = paramcv.title;
      paramContext.field_type = paramcv.type;
      paramContext.field_description = paramcv.description;
      paramContext.field_msgId = l;
      paramContext.field_appId = paramcv.appId;
      com.tencent.mm.plugin.s.a.dxR().insert(paramContext);
      paramContext = paramString2.dnG.dnI.nZa.iterator();
      for (boolean bool = false; paramContext.hasNext(); bool = true)
      {
        label631:
        paramList = (ajn)paramContext.next();
        if (bt.isNullOrNil(paramList.dsU)) {
          paramList.aOs(di(paramList.toString(), paramList.dataType));
        }
        if ((!bool) && (!com.tencent.mm.vfs.i.fv(paramList.Ghp)) && (!com.tencent.mm.vfs.i.fv(paramList.Ghr)) && (bt.isNullOrNil(paramList.GgR)) && (bt.isNullOrNil(paramList.hAe)) && (bt.isNullOrNil(paramList.Gij)) && (bt.isNullOrNil(paramList.hzV))) {
          break label631;
        }
      }
      ad.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        if ((!w.zz(paramString1)) || (bt.isNullOrNil(paramString3))) {
          break label952;
        }
      }
      for (;;)
      {
        paramContext = b(paramString3, paramString2.dnG.dnI);
        if (paramContext.size() > 0)
        {
          com.tencent.mm.kernel.g.aiU().a(new com.tencent.mm.pluginsdk.g.a(paramContext, new a.a()
          {
            public final void bE(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(213097);
              if (paramAnonymousInt == 0)
              {
                p.c(this.cWB, paramString1.getTitle(), paramString1.getDescription(), paramString2, localbu.dnG.dnI);
                AppMethodBeat.o(213097);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                p.c(this.cWB, this.hED);
                p.a(this.cWB, this.hED, paramString2);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).w(this.cWB, paramString2);
                AppMethodBeat.o(213097);
                return;
              }
              this.hED.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.cWB, this.hED);
              if (!p.a(paramString2, this.cWB, false, paramAnonymousString)) {
                p.iH(paramString2, paramAnonymousString);
              }
              AppMethodBeat.o(213097);
            }
          }), 0);
          if (bool) {
            break label946;
          }
        }
        label946:
        for (bool = true;; bool = false)
        {
          paramContext = new Pair(Long.valueOf(l), Boolean.valueOf(bool));
          AppMethodBeat.o(213105);
          return paramContext;
          a(l, paramcv.getTitle(), paramcv.getDescription(), paramString1, paramString2.dnG.dnI);
          break;
          ad.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
          if (w.zz(paramString1)) {
            break;
          }
          ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).yC(l);
          break;
        }
        label952:
        paramString3 = paramString1;
      }
    }
  }
  
  public static k.b a(String paramString1, String paramString2, akd paramakd)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramakd.nZa;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bt.aRc(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bt.aRc(paramString2)).append("</desc>");
    a(localStringBuilder, paramakd);
    localStringBuilder.append(q.dn(localLinkedList));
    localStringBuilder.append("<favusername>").append(bt.aRc(u.aAm())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramakd = new k.b();
    paramakd.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramakd.description = paramString1;
    if ((!bt.hj(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((ajn)localLinkedList.get(0)))) {
      paramakd.type = 24;
    }
    for (paramakd.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramakd.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramakd.action = "view";
      paramakd.hAs = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramakd;
      paramakd.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cv paramcv, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.am.g.vd(paramString))
    {
      locald.title = paramcv.dnG.dnI.title;
      ad.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcv.dnG.dnI == null) {
        break label425;
      }
      paramcv = paramcv.dnG.dnI.nZa;
      localObject2 = paramcv.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1582;
      }
      Object localObject3 = (ajn)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((ajn)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((ajn)localObject3).dataType, j + 1);
      switch (((ajn)localObject3).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 20: 
      case 21: 
      default: 
        break;
      case 1: 
        if (paramString.size() < 5)
        {
          paramString.add(((ajn)localObject3).GhN + ":" + ((ajn)localObject3).desc + "\n");
          continue;
          if (w.vF(paramString))
          {
            locald.title = paramContext.getString(2131762236);
            break;
          }
          localObject2 = u.aAo();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).ze(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(2131758964, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(2131758963, new Object[] { localObject2, paramString });
          break;
          paramcv = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755929) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755853) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131230944);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755920) + ((ajn)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 22: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755920) + ((ajn)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcv = ((ajn)localObject3).GhL.Giu;
          localObject3 = new StringBuilder().append(((ajn)localObject3).GhN).append(":").append(paramContext.getString(2131755806));
          if ((!bt.isNullOrNil(paramcv.dDq)) && (!paramcv.dDq.equals(paramContext.getString(2131755806)))) {
            break label999;
          }
        }
        for (paramcv = paramcv.label;; paramcv = paramcv.dDq)
        {
          paramString.add(paramcv + "\n");
          if (i != 0) {
            break;
          }
          locald.dER = 2131689562;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755820) + ((ajn)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689564);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755773) + ((ajn)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755858) + ((ajn)localObject3).GhL.Giy.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755278) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajn)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 16: 
        if (localObject3 == null)
        {
          ad.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        }
        else
        {
          if (paramString.size() < 5) {
            paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755782) + "\n");
          }
          if (i == 0)
          {
            locald.rxX = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqk(((ajn)localObject3).desc).dHm;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755872) + "\n");
        }
        break;
      case 19: 
        label425:
        label999:
        if (paramString.size() < 5) {
          paramString.add(((ajn)localObject3).GhN + ":" + paramContext.getString(2131755279) + ((ajn)localObject3).title + "\n");
        }
        break;
      }
    }
    label1582:
    locald.desc = "";
    paramcv = paramString.iterator();
    for (paramContext = ""; paramcv.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcv.next();
    }
    paramcv = paramContext.trim();
    paramContext = paramcv;
    if (paramString.size() >= 5) {
      paramContext = paramcv + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.hDb == null))
    {
      ad.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = bt.bI(paramString, "");
      AppMethodBeat.o(9543);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(bt.aRc(paramc.title)).append("</title>");
    paramString.append("<desc>").append(bt.aRc(paramc.desc)).append("</desc>");
    ajx localajx = paramc.FpF;
    if (localajx != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(bt.aRc(localajx.Gjo)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(bt.aRc(localajx.Gjp)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(bt.aRc(localajx.Gjp)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.pQi).append("</edittime>");
    paramString.append(q.dn(paramc.hDb));
    paramString.append("<favusername>").append(bt.aRc(paramc.xqw)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(ajn paramajn, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramajn == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = eJ(paramajn.dsU, paramInt);
    if ((bt.isNullOrNil((String)localObject1)) || (!aj.cnC()) || (!com.tencent.mm.kernel.g.ajx()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = yF(paramLong);
    Object localObject3;
    if ((paramajn.dataType == 8) && (!bt.isNullOrNil(paramajn.title)))
    {
      localObject3 = paramajn.title;
      paramInt = paramajn.dsU.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.ajC().gBm + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (locale.exists())
      {
        paramInt = i;
        localObject2 = locale;
        localObject1 = localObject3;
        if (locale.isDirectory()) {}
      }
      else
      {
        locale.mkdirs();
        localObject1 = localObject3;
        localObject2 = locale;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramajn.Ghg != null)
      {
        localObject3 = localObject1;
        if (paramajn.Ghg.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramajn.Ghg;
          }
        }
      }
      paramajn = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((com.tencent.mm.vfs.e)localObject2, (String)localObject3).fOK());
      AppMethodBeat.o(9532);
      return paramajn;
    }
  }
  
  public static String a(String paramString1, String paramString2, akd paramakd, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramakd == null) || (paramakd.nZa == null))
    {
      ad.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramakd.nZa;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bt.aRc(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bt.aRc(paramString2)).append("</desc>");
    a(localStringBuilder, paramakd);
    localStringBuilder.append(q.dn(localLinkedList));
    localStringBuilder.append("<favusername>").append(bt.aRc(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramakd = new k.b();
    paramakd.title = paramString1;
    paramakd.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((ajn)localLinkedList.get(0)))) {
      paramakd.type = 24;
    }
    for (paramakd.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramakd.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramakd.action = "view";
      paramakd.hAs = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.s.a.dxR().xH(paramLong);
      if (paramString1 != null) {
        paramakd.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramakd, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramakd.type = 19;
    }
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString, k.b paramb, com.tencent.mm.protocal.b.a.c paramc, akd paramakd, boolean paramBoolean)
  {
    AppMethodBeat.i(213103);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong1;
    localk.field_oriMsgId = paramLong2;
    localk.field_toUser = paramString;
    localk.field_title = paramb.title;
    localk.field_desc = bt.bI(paramc.desc, paramb.description);
    localk.field_dataProto = paramakd;
    localk.field_type = 0;
    localk.field_favFrom = paramc.xqw;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ad.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk, paramBoolean);
    AppMethodBeat.o(213103);
  }
  
  private static void a(long paramLong, String paramString1, String paramString2, String paramString3, akd paramakd)
  {
    AppMethodBeat.i(213102);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramakd;
    localk.field_type = 3;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ad.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(213102);
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, ajn paramajn, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramajn = paramajn.Ghr;
    if (com.tencent.mm.vfs.i.fv(paramajn))
    {
      paramd.thumbPath = paramajn;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.dER = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.hDb.clear();
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      int j;
      Object localObject2;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("datalist");
        if (paramString == null) {
          break label4198;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label4198;
        }
        int k = localNodeList.getLength();
        i = 0;
        if (i >= k) {
          break label4198;
        }
        localObject1 = localNodeList.item(i);
        paramString = bw.b((Node)localObject1);
        if (!(localObject1 instanceof Element)) {
          break label4216;
        }
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4210;
        }
        localObject1 = ((NodeList)localObject1).item(0).getChildNodes();
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label4210;
        }
        int m = ((NodeList)localObject1).getLength();
        j = 0;
        if (j >= m) {
          break label4210;
        }
        localObject2 = ((NodeList)localObject1).item(j);
        if (!(localObject2 instanceof Element)) {
          break label4223;
        }
        localObject1 = bw.b((Node)localObject2);
        ad.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4205;
        }
        paramString = bw.M(paramString, "dataitem");
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.aOg(paramString.desc.replaceAll("‮", ""));
          }
          paramc.hDb.add(paramString);
        }
        catch (Exception paramString)
        {
          ajn localajn;
          String str;
          ad.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          ad.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.hDb.clear();
        }
        localajn = new ajn();
        localajn.ZI(bt.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localajn.aOx((String)paramString.get(".dataitem" + ".$datasourceid"));
        localajn.ZJ(bt.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localajn.aOp((String)paramString.get(".dataitem" + ".datafmt"));
        localajn.aOf((String)paramString.get(".dataitem" + ".datatitle"));
        localajn.aOg((String)paramString.get(".dataitem" + ".datadesc"));
        localajn.aOh((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localajn.aOi((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localajn.ZF(bt.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localajn.ZG(bt.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localajn.aOj((String)paramString.get(".dataitem" + ".cdndataurl"));
        localajn.aOk((String)paramString.get(".dataitem" + ".cdndatakey"));
        localajn.hzV = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localajn.Gif = true;
        localajn.aOG((String)paramString.get(".dataitem" + ".tpaeskey"));
        localajn.aOH((String)paramString.get(".dataitem" + ".tpauthkey"));
        localajn.aOI((String)paramString.get(".dataitem" + ".tpdataurl"));
        localajn.hAb = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localajn.Gil = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localajn.ZH(bt.getInt((String)localObject2, 0));
        }
        localajn.aOm((String)paramString.get(".dataitem" + ".streamdataurl"));
        localajn.aOn((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localajn.aOl((String)paramString.get(".dataitem" + ".streamweburl"));
        localajn.aOq((String)paramString.get(".dataitem" + ".fullmd5"));
        localajn.aOr((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localajn.CG(bt.getInt((String)localObject2, 0));
        }
        localajn.aOo((String)paramString.get(".dataitem" + ".dataext"));
        localajn.aOv((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localajn.aOw((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localajn.CH(bt.getInt((String)localObject2, 0));
        }
        localajn.aOy((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (bt.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localajn.aOs((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!bt.isNullOrNil((String)localObject2)) {
          localajn.aOC((String)localObject2);
        }
        localajn.ZK(bt.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localajn.aOz((String)paramString.get(".dataitem" + ".sourcetitle"));
        localajn.aOA((String)paramString.get(".dataitem" + ".sourcename"));
        localajn.aOJ((String)paramString.get(".dataitem" + ".sourcedesc"));
        localajn.aOK((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localajn.aOB((String)paramString.get(".dataitem" + ".sourcetime"));
        localajn.aOD((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localajn.aOF((String)localObject1);
        }
        localajn.aOL((String)paramString.get(".dataitem" + ".songalbumurl"));
        localajn.aOM((String)paramString.get(".dataitem" + ".songlyric"));
        localajn.aON((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject1 = new ajo();
        localObject2 = new ajp();
        ((ajp)localObject2).ZM(bt.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((ajp)localObject2).aOO((String)localObject3);
          ad.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((ajp)localObject2).dyU });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((ajp)localObject2).aOR((String)localObject3);
          ad.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((ajp)localObject2).GiV });
        }
        ((ajp)localObject2).aOT((String)paramString.get(".dataitem" + ".appid"));
        ((ajp)localObject2).aOU((String)paramString.get(".dataitem" + ".link"));
        ((ajp)localObject2).aOV((String)paramString.get(".dataitem" + ".brandid"));
        ((ajo)localObject1).c((ajp)localObject2);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject2 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject2)) {
            break label3132;
          }
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          ((ajo)localObject1).c(com.tencent.mm.plugin.i.a.e.v(".dataitem", paramString));
          localObject2 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject2)) {
            break label3336;
          }
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject2)) {
            break label3540;
          }
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject2)) {
            break label3704;
          }
          ad.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject2)) {
            break label4168;
          }
          ad.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".favbrandmpvideo";
          if (paramString.containsKey(localObject2)) {
            break label4183;
          }
          ad.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localajn.a((ajo)localObject1);
          paramString = localajn;
          continue;
        }
        localObject2 = new aju();
        if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((aju)localObject2).aOW((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((aju)localObject2).aOX((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!bt.isNullOrNil(str)) {
          ((aju)localObject2).A(bt.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!bt.isNullOrNil(str)) {
          ((aju)localObject2).B(bt.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!bt.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((aju)localObject2).ZN(bt.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((ajo)localObject1).c((aju)localObject2);
          continue;
        }
        ((aju)localObject2).ZN(bt.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label3132:
      Object localObject3 = new aks();
      ((aks)localObject3).aPs((String)paramString.get((String)localObject2 + ".title"));
      ((aks)localObject3).aPt((String)paramString.get((String)localObject2 + ".desc"));
      ((aks)localObject3).aPv((String)paramString.get((String)localObject2 + ".thumburl"));
      ((aks)localObject3).aPu((String)paramString.get((String)localObject2 + ".link"));
      ((aks)localObject3).ZS(bt.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((ajo)localObject1).a((aks)localObject3);
      continue;
      label3336:
      localObject3 = new akc();
      ((akc)localObject3).aOY((String)paramString.get((String)localObject2 + ".title"));
      ((akc)localObject3).aOZ((String)paramString.get((String)localObject2 + ".desc"));
      ((akc)localObject3).aPa((String)paramString.get((String)localObject2 + ".thumburl"));
      ((akc)localObject3).aPb((String)paramString.get((String)localObject2 + ".productinfo"));
      ((akc)localObject3).ZO(bt.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((ajo)localObject1).a((akc)localObject3);
      continue;
      label3540:
      localObject3 = new akm();
      ((akm)localObject3).aPo((String)paramString.get((String)localObject2 + ".title"));
      ((akm)localObject3).aPp((String)paramString.get((String)localObject2 + ".desc"));
      ((akm)localObject3).aPq((String)paramString.get((String)localObject2 + ".thumburl"));
      ((akm)localObject3).aPr((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((ajo)localObject1).a((akm)localObject3);
      continue;
      label3704:
      localObject3 = new ajl();
      ((ajl)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ajl)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ajl)localObject3).dtF = bt.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ajl)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ajl)localObject3).type = bt.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ajl)localObject3).dki = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ajl)localObject3).GgH = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ajl)localObject3).version = bt.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ajl)localObject3).kro = bt.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ajl)localObject3).jXI = bt.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ajl)localObject3).dJW = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ajl)localObject3).subType = bt.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((ajo)localObject1).b((ajl)localObject3);
      continue;
      label4168:
      ((ajo)localObject1).d(com.tencent.mm.plugin.fav.a.a.b.t((String)localObject2, paramString));
      continue;
      label4183:
      ((ajo)localObject1).e(com.tencent.mm.plugin.fav.a.a.b.u((String)localObject2, paramString));
      continue;
      label4198:
      AppMethodBeat.o(9542);
      return;
      label4205:
      paramString = null;
      continue;
      label4210:
      localObject1 = null;
      continue;
      label4216:
      i += 1;
      continue;
      label4223:
      j += 1;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, akd paramakd)
  {
    AppMethodBeat.i(9521);
    if (paramakd.FpF != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bt.aRc(paramakd.FpF.Gjo)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bt.aRc(paramakd.FpF.Gjp)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramakd.pQi).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(bt.aRc(paramakd.FpF.Gjp)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(213107);
    if (w.zz(paramString1))
    {
      paramString1 = new qg();
      paramString1.dEM.msgId = paramLong;
      paramString1.dEM.dxG = paramBoolean;
      paramString1.dEM.errMsg = bt.bI(paramString2, "");
      com.tencent.mm.sdk.b.a.IbL.l(paramString1);
      AppMethodBeat.o(213107);
      return true;
    }
    AppMethodBeat.o(213107);
    return false;
  }
  
  public static String agd(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static com.tencent.mm.protocal.b.a.c avr(String paramString)
  {
    AppMethodBeat.i(9541);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)fTI.get(Integer.valueOf(i));
    if (localObject != null)
    {
      ad.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(9541);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = bw.M(paramString, "recordinfo"); localObject == null; localObject = bw.M("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      ad.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(9541);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.xqw = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      ajx localajx = new ajx();
      localajx.Gjp = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localajx.Gjo = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.FpF = localajx;
      localc.pQi = bt.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    fTI.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String b(ajn paramajn, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramajn == null) || (bt.isNullOrNil(paramajn.dsU)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramajn = eJ(agd(paramajn.dsU), paramInt);
    paramajn = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(yF(paramLong), paramajn).fOK());
    AppMethodBeat.o(9536);
    return paramajn;
  }
  
  private static List<a.b> b(String paramString, akd paramakd)
  {
    AppMethodBeat.i(213100);
    List localList = Collections.synchronizedList(new ArrayList());
    if (paramakd != null)
    {
      Iterator localIterator = paramakd.nZa.iterator();
      while (localIterator.hasNext())
      {
        ajn localajn = (ajn)localIterator.next();
        if (localajn.Ghm > 26214400L)
        {
          a.b localb = new a.b();
          String str = localajn.Ghp;
          paramakd = com.tencent.mm.vfs.i.aPK(str);
          localb.filePath = str;
          localb.toUser = paramString;
          localb.fileSize = localajn.Ghm;
          localb.fVf = localajn.Ghg;
          if (bt.isNullOrNil(localajn.Ghi)) {}
          for (;;)
          {
            localb.nUg = paramakd;
            localb.gjI = localajn.GgT;
            localb.fileName = localajn.title;
            localList.add(localb);
            break;
            paramakd = localajn.Ghi;
          }
        }
      }
    }
    AppMethodBeat.o(213100);
    return localList;
  }
  
  private static void b(long paramLong, String paramString1, String paramString2, String paramString3, akd paramakd)
  {
    AppMethodBeat.i(213104);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramakd;
    localk.field_type = 1;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ad.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(213104);
  }
  
  public static boolean b(ajn paramajn, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramajn == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = g(paramajn.dsU, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(str);
    if (localObject == null)
    {
      j localj = new j();
      localj.field_cdnKey = paramajn.GgT;
      localj.field_cdnUrl = paramajn.GgR;
      localj.field_dataId = paramajn.dsU;
      localj.field_mediaId = str;
      localj.field_totalLen = ((int)paramajn.Ghm);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = a(paramajn, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = hf(paramajn.dataType, (int)paramajn.Ghm);
      localj.field_isThumb = false;
      localj.field_tpaeskey = paramajn.Gig;
      localj.field_tpauthkey = paramajn.hAa;
      localj.field_tpdataurl = paramajn.Gij;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      ad.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
      localObject = localj;
      if (!bt.isNullOrNil(paramajn.GhT))
      {
        localObject = localj;
        if (paramajn.GhT.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(localj);
          localObject = localj;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((j)localObject).field_status)
      {
        ad.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((j)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((j)localObject).field_status)
      {
        ad.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((j)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          ((j)localObject).field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9544);
        return true;
      }
      AppMethodBeat.o(9544);
      return false;
    }
  }
  
  public static String c(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramajn = a(paramajn, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramajn;
  }
  
  public static boolean c(ajn paramajn, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramajn == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = agd(paramajn.dsU);
    String str2 = g(str1, paramLong, true);
    j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(str2);
    if (localj == null)
    {
      localj = new j();
      localj.field_cdnKey = paramajn.GgN;
      localj.field_cdnUrl = paramajn.hAe;
      localj.field_dataId = str1;
      localj.field_mediaId = str2;
      localj.field_totalLen = ((int)paramajn.Ghx);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = b(paramajn, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      localj.field_isThumb = true;
      localj.field_tpdataurl = paramajn.hzV;
      localj.field_tpauthkey = paramajn.hAa;
      localj.field_tpaeskey = paramajn.hAb;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      ad.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
    }
    for (paramajn = localj;; paramajn = localj)
    {
      ad.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramajn });
      if (4 == paramajn.field_status)
      {
        ad.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramajn.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramajn.field_status)
      {
        ad.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramajn.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramajn.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramajn, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9546);
        return true;
      }
      AppMethodBeat.o(9546);
      return false;
    }
  }
  
  public static boolean d(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new com.tencent.mm.vfs.e(a(paramajn, paramLong, 1)).exists();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static String di(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean e(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new com.tencent.mm.vfs.e(b(paramajn, paramLong, 1)).exists();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  public static String eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(9539);
    if (bt.jx(paramInt, 1))
    {
      AppMethodBeat.o(9539);
      return paramString;
    }
    paramString = paramInt + "_" + paramString;
    AppMethodBeat.o(9539);
    return paramString;
  }
  
  private static final b f(k.b paramb)
  {
    AppMethodBeat.i(213101);
    if (paramb == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
      AppMethodBeat.o(213101);
      return null;
    }
    paramb = avr(paramb.hAs);
    if (paramb == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
      AppMethodBeat.o(213101);
      return null;
    }
    akd localakd = new akd();
    localakd.nZa = new LinkedList();
    localakd.a(paramb.FpF);
    localakd.CL(paramb.pQi);
    localakd.aPd(paramb.title);
    String str = aj.getContext().getString(2131755344);
    Object localObject1 = aj.getContext().getString(2131755773);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramb.hDb.iterator();
    ajn localajn;
    while (((Iterator)localObject2).hasNext())
    {
      localajn = (ajn)((Iterator)localObject2).next();
      if ((localajn.dataType == 8) && (localajn.Ghm > 26214400L))
      {
        localajn.ZI(1);
        localajn.aOg(str);
        localArrayList.add((String)localObject1 + localajn.title);
        localajn.aOf(null);
        localajn.aOp(null);
        localajn.aOk(null);
        localajn.aOj(null);
        localajn.GgV = 0;
        localajn.GgW = true;
        localajn.CG(str.length());
      }
      localakd.nZa.add(localajn);
    }
    localObject1 = paramb.desc.split("\n");
    localObject2 = new StringBuffer();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localajn = localObject1[i];
      String[] arrayOfString = localajn.split(":");
      if (arrayOfString.length != 2)
      {
        ad.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", new Object[] { localajn, paramb.desc });
        i += 1;
      }
      else
      {
        if (localArrayList.contains(arrayOfString[1])) {
          ((StringBuffer)localObject2).append(arrayOfString[0] + ":" + str);
        }
        for (;;)
        {
          ((StringBuffer)localObject2).append('\n');
          break;
          ((StringBuffer)localObject2).append(localajn);
        }
      }
    }
    str = ((StringBuffer)localObject2).toString();
    str = str.substring(0, str.length() - 1);
    localakd.aPe(str);
    paramb = new b(str, paramb.xqw, localakd);
    AppMethodBeat.o(213101);
    return paramb;
  }
  
  public static String f(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(221618);
    paramajn = b(paramajn, paramLong, 1);
    AppMethodBeat.o(221618);
    return paramajn;
  }
  
  public static String g(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9540);
    if (paramBoolean)
    {
      paramString = paramString + "@record_download@" + paramLong;
      AppMethodBeat.o(9540);
      return paramString;
    }
    paramString = paramString + "@record_upload@" + paramLong;
    AppMethodBeat.o(9540);
    return paramString;
  }
  
  public static boolean g(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramajn == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramajn = g(paramajn.dsU, paramLong, true);
    paramajn = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(paramajn);
    if (paramajn == null)
    {
      ad.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramajn.field_status)
    {
      ad.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramajn.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    ad.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramajn.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  private static boolean g(List<ajn> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (ajn)paramList.next();
        int i = ((ajn)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = avr(((ajn)localObject).Gib);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = g(((com.tencent.mm.protocal.b.a.c)localObject).hDb, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((bt.isNullOrNil(((ajn)localObject).GgR)) && (bt.isNullOrNil(((ajn)localObject).hAe)) && (bt.isNullOrNil(((ajn)localObject).Gij)) && (bt.isNullOrNil(((ajn)localObject).hzV))) {
            continue;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(9527);
      return bool1;
    }
  }
  
  public static boolean h(ajn paramajn, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = t.aQj(a(paramajn, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static int hf(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.fIy;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  private static com.tencent.mm.vfs.e yF(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = new com.tencent.mm.vfs.e(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.ajC().gBm + "record/", Long.valueOf(paramLong) }));
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory())) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void yG(long paramLong)
  {
    AppMethodBeat.i(9531);
    com.tencent.mm.vfs.e locale = yF(paramLong);
    boolean bool = com.tencent.mm.vfs.i.cZ(com.tencent.mm.vfs.q.B(locale.mUri), true);
    ad.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { com.tencent.mm.vfs.q.B(locale.fOK()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
  
  public static String zg(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramString);
    if (localObject == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((am)localObject).adv();
    localObject = str;
    if (w.vF(str))
    {
      paramString = com.tencent.mm.model.q.yQ(paramString);
      localObject = u.aAm();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      ad.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.q.e(paramString, 3))
    {
      AppMethodBeat.o(9547);
      return localObject;
      label110:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.p
 * JD-Core Version:    0.7.0.1
 */