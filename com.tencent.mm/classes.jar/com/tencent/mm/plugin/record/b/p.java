package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> fVO;
  
  static
  {
    AppMethodBeat.i(9549);
    fVO = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static int a(final String paramString1, final akn paramakn, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramakn == null) || (paramakn.oeJ.isEmpty()))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramakn);
    final bv localbv = new bv();
    paramString2 = null;
    if (!bu.isNullOrNil(paramString4))
    {
      paramString2 = bu.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label362;
        }
      }
    }
    long l;
    label362:
    for (paramString2 = com.tencent.mm.av.q.aIX().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.av.q.aIX().aa(paramString2))
    {
      ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " thumbData MsgInfo path:" + paramString2);
      if (!bu.isNullOrNil(paramString2)) {
        localbv.uj(paramString2);
      }
      localbv.setContent(k.b.a(paramString3, null, null));
      localbv.setStatus(1);
      localbv.ui(paramString1);
      localbv.qN(bl.BQ(paramString1));
      localbv.kt(1);
      localbv.setType(49);
      if (com.tencent.mm.al.g.vz(paramString1)) {
        localbv.tk(com.tencent.mm.al.a.e.We());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
      ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label373;
      }
      ae.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9528);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes(com.tencent.mm.sdk.platformtools.h.aaZ(paramInt));
        break;
      }
      if (bu.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes(com.tencent.mm.aj.c.a(paramString5, false, -1, null));
      break;
    }
    label373:
    ae.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localbv.setMsgId(l);
    paramString2 = new com.tencent.mm.ah.k();
    paramString2.field_xml = localbv.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.s.a.dBh().insert(paramString2);
    paramString2 = paramakn.oeJ.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (ajx)paramString2.next();
    } while ((bu.isNullOrNil(paramString4.GzA)) && (bu.isNullOrNil(paramString4.hCS)));
    paramString2 = b(paramString1, paramakn);
    if (paramString2.size() > 0) {
      com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.pluginsdk.g.a(paramString2, new a.a()
      {
        public final void bE(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(221839);
          if (paramAnonymousInt == 0)
          {
            p.d(this.cXy, paramString1.getTitle(), paramString1.getDescription(), paramakn, localbv);
            AppMethodBeat.o(221839);
            return;
          }
          if (-3200 == paramAnonymousInt)
          {
            ae.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.cXy), paramakn });
            p.c(this.cXy, this.hHv);
            p.b(this.cXy, this.hHv, paramakn);
            ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).x(this.cXy, paramakn);
            AppMethodBeat.o(221839);
            return;
          }
          this.hHv.setStatus(5);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.cXy, this.hHv);
          p.iN(paramakn, paramAnonymousString);
          AppMethodBeat.o(221839);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(9528);
      return 0;
      b(l, paramString3.getTitle(), paramString3.getDescription(), paramString1, paramakn);
    }
  }
  
  public static int a(String paramString1, String paramString2, bv parambv)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, parambv, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, bv parambv, final boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((parambv == null) || (bu.isNullOrNil(parambv.field_content)))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == parambv.field_status)
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = bu.U(paramString1.split(",")).iterator();
    label782:
    while (paramString1.hasNext())
    {
      final String str = (String)paramString1.next();
      ae.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambv.field_msgId), Integer.valueOf(parambv.field_status) });
      Object localObject1 = bl.BN(parambv.field_content);
      final k.b localb = k.b.zb((String)localObject1);
      if (localb == null)
      {
        ae.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final com.tencent.mm.protocal.b.a.c localc = awG(localb.hDg);
      if (localc == null)
      {
        ae.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final bv localbv = new bv();
      Object localObject2;
      if (!bu.isNullOrNil(parambv.field_imgPath))
      {
        localObject2 = bu.readFromFile(com.tencent.mm.av.q.aIX().R(parambv.field_imgPath, true));
        localObject2 = com.tencent.mm.av.q.aIX().aa((byte[])localObject2);
        ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " thumbData from msg MsgInfo path:" + (String)localObject2);
        if (!bu.isNullOrNil((String)localObject2)) {
          localbv.uj((String)localObject2);
        }
      }
      localbv.setContent((String)localObject1);
      localbv.setStatus(1);
      localbv.ui(str);
      localbv.qN(bl.BQ(str));
      localbv.kt(1);
      localbv.setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
      ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ae.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      ae.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbv.setMsgId(l);
      localObject1 = new xk();
      ((xk)localObject1).dMQ.dMR = parambv.field_msgId;
      ((xk)localObject1).dMQ.dMS = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new com.tencent.mm.ah.k();
      ((com.tencent.mm.ah.k)localObject1).field_xml = localbv.field_content;
      ((com.tencent.mm.ah.k)localObject1).field_title = localb.title;
      ((com.tencent.mm.ah.k)localObject1).field_type = localb.type;
      ((com.tencent.mm.ah.k)localObject1).field_description = localb.description;
      ((com.tencent.mm.ah.k)localObject1).field_msgId = l;
      ((com.tencent.mm.ah.k)localObject1).field_appId = localb.appId;
      com.tencent.mm.plugin.s.a.dBh().insert((com.tencent.mm.sdk.e.c)localObject1);
      if (g(localc.hFT, paramBoolean))
      {
        localObject1 = new akn();
        ((akn)localObject1).oeJ.addAll(localc.hFT);
        localObject2 = b(str, (akn)localObject1);
        if (((List)localObject2).size() > 0) {
          com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.pluginsdk.g.a((List)localObject2, new a.a()
          {
            public final void bE(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(221838);
              if (paramAnonymousInt == 0)
              {
                p.b(this.cXy, str.field_msgId, localb, localc, this.xHf, paramBoolean, localbv);
                AppMethodBeat.o(221838);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                ae.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.cXy), localb });
                p.c(this.cXy, this.hHv);
                p.a(this.cXy, str.field_msgId, this.hHv, localb, localbv);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).x(this.cXy, localb);
                AppMethodBeat.o(221838);
                return;
              }
              this.hHv.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.cXy, this.hHv);
              p.iN(localb, paramAnonymousString);
              AppMethodBeat.o(221838);
            }
          }), 0);
        }
      }
      for (;;)
      {
        if (bu.isNullOrNil(paramString2)) {
          break label782;
        }
        com.tencent.mm.plugin.messenger.a.g.doC().aa(str, paramString2, x.Bb(str));
        break;
        a(l, parambv.field_msgId, str, localb, localc, (akn)localObject1, paramBoolean);
        continue;
        ae.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).zb(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static Pair<Long, Boolean> a(Context paramContext, final String paramString1, final String paramString2, List<bv> paramList, cw paramcw, com.tencent.mm.protocal.b.a.d paramd, String paramString3)
  {
    AppMethodBeat.i(221845);
    if (bu.isNullOrNil(paramString1))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(221845);
      return paramContext;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(221845);
      return paramContext;
    }
    if ((paramcw == null) || (paramd == null))
    {
      paramcw = new cw();
      if (!c.a(paramContext, paramcw, paramString2, paramList))
      {
        paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
        AppMethodBeat.o(221845);
        return paramContext;
      }
      paramd = a(paramContext, paramcw, paramString2);
    }
    for (paramString2 = paramcw;; paramString2 = paramcw)
    {
      paramcw = a(paramd.title, paramd.desc, paramString2.doL.doN);
      final bv localbv = new bv();
      paramList = null;
      if (!bu.isNullOrNil(paramd.thumbPath))
      {
        paramContext = bu.readFromFile(paramd.thumbPath);
        if (paramContext != null) {
          if (paramContext.length <= 65536) {
            break label498;
          }
        }
      }
      long l;
      label498:
      for (paramContext = com.tencent.mm.av.q.aIX().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.av.q.aIX().aa(paramContext))
      {
        ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " thumbData MsgInfo path:" + paramContext);
        if (!bu.isNullOrNil(paramContext)) {
          localbv.uj(paramContext);
        }
        localbv.setContent(k.b.a(paramcw, null, null));
        localbv.setStatus(1);
        localbv.ui(paramString1);
        localbv.qN(bl.BQ(paramString1));
        localbv.kt(1);
        localbv.setType(49);
        if (com.tencent.mm.al.g.vz(paramString1)) {
          localbv.tk(com.tencent.mm.al.a.e.We());
        }
        l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(localbv);
        ae.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label509;
        }
        ae.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.abr() + "insert msg failed :" + l);
        paramContext = new Pair(Long.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Boolean.FALSE);
        AppMethodBeat.o(221845);
        return paramContext;
        paramContext = paramList;
        if (paramd.dFW != 0) {
          break;
        }
        paramContext = paramList;
        if (bu.isNullOrNil(paramd.rGi)) {
          break;
        }
        paramContext = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes(com.tencent.mm.aj.c.a(paramd.rGi, false, -1, null));
        break;
      }
      label509:
      ae.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localbv.setMsgId(l);
      paramContext = new com.tencent.mm.ah.k();
      paramContext.field_xml = localbv.field_content;
      paramContext.field_title = paramcw.title;
      paramContext.field_type = paramcw.type;
      paramContext.field_description = paramcw.description;
      paramContext.field_msgId = l;
      paramContext.field_appId = paramcw.appId;
      com.tencent.mm.plugin.s.a.dBh().insert(paramContext);
      paramContext = paramString2.doL.doN.oeJ.iterator();
      for (boolean bool = false; paramContext.hasNext(); bool = true)
      {
        label631:
        paramList = (ajx)paramContext.next();
        if (bu.isNullOrNil(paramList.dua)) {
          paramList.aPP(dm(paramList.toString(), paramList.dataType));
        }
        if ((!bool) && (!o.fB(paramList.GzY)) && (!o.fB(paramList.GAa)) && (bu.isNullOrNil(paramList.GzA)) && (bu.isNullOrNil(paramList.hCS)) && (bu.isNullOrNil(paramList.GAS)) && (bu.isNullOrNil(paramList.hCJ))) {
          break label631;
        }
      }
      ae.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        if ((!x.Aj(paramString1)) || (bu.isNullOrNil(paramString3))) {
          break label952;
        }
      }
      for (;;)
      {
        paramContext = b(paramString3, paramString2.doL.doN);
        if (paramContext.size() > 0)
        {
          com.tencent.mm.kernel.g.ajj().a(new com.tencent.mm.pluginsdk.g.a(paramContext, new a.a()
          {
            public final void bE(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(221837);
              if (paramAnonymousInt == 0)
              {
                p.c(this.cXy, paramString1.getTitle(), paramString1.getDescription(), paramString2, localbv.doL.doN);
                AppMethodBeat.o(221837);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                p.c(this.cXy, this.hHv);
                p.a(this.cXy, this.hHv, paramString2);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).x(this.cXy, paramString2);
                AppMethodBeat.o(221837);
                return;
              }
              this.hHv.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.cXy, this.hHv);
              if (!p.a(paramString2, this.cXy, false, paramAnonymousString)) {
                p.iN(paramString2, paramAnonymousString);
              }
              AppMethodBeat.o(221837);
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
          AppMethodBeat.o(221845);
          return paramContext;
          a(l, paramcw.getTitle(), paramcw.getDescription(), paramString1, paramString2.doL.doN);
          break;
          ae.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
          if (x.Aj(paramString1)) {
            break;
          }
          ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).zb(l);
          break;
        }
        label952:
        paramString3 = paramString1;
      }
    }
  }
  
  public static k.b a(String paramString1, String paramString2, akn paramakn)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramakn.oeJ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bu.aSz(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bu.aSz(paramString2)).append("</desc>");
    a(localStringBuilder, paramakn);
    localStringBuilder.append(q.dq(localLinkedList));
    localStringBuilder.append("<favusername>").append(bu.aSz(v.aAC())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramakn = new k.b();
    paramakn.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramakn.description = paramString1;
    if ((!bu.ht(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((ajx)localLinkedList.get(0)))) {
      paramakn.type = 24;
    }
    for (paramakn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramakn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramakn.action = "view";
      paramakn.hDg = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramakn;
      paramakn.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cw paramcw, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.al.g.vz(paramString))
    {
      locald.title = paramcw.doL.doN.title;
      ae.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcw.doL.doN == null) {
        break label425;
      }
      paramcw = paramcw.doL.doN.oeJ;
      localObject2 = paramcw.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1582;
      }
      Object localObject3 = (ajx)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((ajx)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((ajx)localObject3).dataType, j + 1);
      switch (((ajx)localObject3).dataType)
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
          paramString.add(((ajx)localObject3).GAw + ":" + ((ajx)localObject3).desc + "\n");
          continue;
          if (x.wb(paramString))
          {
            locald.title = paramContext.getString(2131762236);
            break;
          }
          localObject2 = v.aAE();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zO(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(2131758964, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(2131758963, new Object[] { localObject2, paramString });
          break;
          paramcw = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755929) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755853) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131230944);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755920) + ((ajx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 22: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755920) + ((ajx)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcw = ((ajx)localObject3).GAu.GBd;
          localObject3 = new StringBuilder().append(((ajx)localObject3).GAw).append(":").append(paramContext.getString(2131755806));
          if ((!bu.isNullOrNil(paramcw.dEv)) && (!paramcw.dEv.equals(paramContext.getString(2131755806)))) {
            break label999;
          }
        }
        for (paramcw = paramcw.label;; paramcw = paramcw.dEv)
        {
          paramString.add(paramcw + "\n");
          if (i != 0) {
            break;
          }
          locald.dFW = 2131689562;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755820) + ((ajx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689564);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755773) + ((ajx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755858) + ((ajx)localObject3).GAu.GBh.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755278) + "\n");
        }
        if (i == 0)
        {
          a(locald, (ajx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 16: 
        if (localObject3 == null)
        {
          ae.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        }
        else
        {
          if (paramString.size() < 5) {
            paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755782) + "\n");
          }
          if (i == 0)
          {
            locald.rGi = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arp(((ajx)localObject3).desc).cUA;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755872) + "\n");
        }
        break;
      case 19: 
        label425:
        label999:
        if (paramString.size() < 5) {
          paramString.add(((ajx)localObject3).GAw + ":" + paramContext.getString(2131755279) + ((ajx)localObject3).title + "\n");
        }
        break;
      }
    }
    label1582:
    locald.desc = "";
    paramcw = paramString.iterator();
    for (paramContext = ""; paramcw.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcw.next();
    }
    paramcw = paramContext.trim();
    paramContext = paramcw;
    if (paramString.size() >= 5) {
      paramContext = paramcw + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.hFT == null))
    {
      ae.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = bu.bI(paramString, "");
      AppMethodBeat.o(9543);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(bu.aSz(paramc.title)).append("</title>");
    paramString.append("<desc>").append(bu.aSz(paramc.desc)).append("</desc>");
    akh localakh = paramc.FId;
    if (localakh != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(bu.aSz(localakh.GBX)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(bu.aSz(localakh.GBY)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(bu.aSz(localakh.GBY)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.pWN).append("</edittime>");
    paramString.append(q.dq(paramc.hFT));
    paramString.append("<favusername>").append(bu.aSz(paramc.xGt)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(ajx paramajx, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramajx == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = eR(paramajx.dua, paramInt);
    if ((bu.isNullOrNil((String)localObject1)) || (!ak.cpe()) || (!com.tencent.mm.kernel.g.ajM()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = ze(paramLong);
    Object localObject3;
    if ((paramajx.dataType == 8) && (!bu.isNullOrNil(paramajx.title)))
    {
      localObject3 = paramajx.title;
      paramInt = paramajx.dua.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.ajR().gDT + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (localk.exists())
      {
        paramInt = i;
        localObject2 = localk;
        localObject1 = localObject3;
        if (localk.isDirectory()) {}
      }
      else
      {
        localk.mkdirs();
        localObject1 = localObject3;
        localObject2 = localk;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramajx.GzP != null)
      {
        localObject3 = localObject1;
        if (paramajx.GzP.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramajx.GzP;
          }
        }
      }
      paramajx = w.B(new com.tencent.mm.vfs.k((com.tencent.mm.vfs.k)localObject2, (String)localObject3).fTh());
      AppMethodBeat.o(9532);
      return paramajx;
    }
  }
  
  public static String a(String paramString1, String paramString2, akn paramakn, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramakn == null) || (paramakn.oeJ == null))
    {
      ae.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramakn.oeJ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bu.aSz(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bu.aSz(paramString2)).append("</desc>");
    a(localStringBuilder, paramakn);
    localStringBuilder.append(q.dq(localLinkedList));
    localStringBuilder.append("<favusername>").append(bu.aSz(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramakn = new k.b();
    paramakn.title = paramString1;
    paramakn.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((ajx)localLinkedList.get(0)))) {
      paramakn.type = 24;
    }
    for (paramakn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramakn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramakn.action = "view";
      paramakn.hDg = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.s.a.dBh().yb(paramLong);
      if (paramString1 != null) {
        paramakn.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramakn, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramakn.type = 19;
    }
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString, k.b paramb, com.tencent.mm.protocal.b.a.c paramc, akn paramakn, boolean paramBoolean)
  {
    AppMethodBeat.i(221843);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong1;
    localk.field_oriMsgId = paramLong2;
    localk.field_toUser = paramString;
    localk.field_title = paramb.title;
    localk.field_desc = bu.bI(paramc.desc, paramb.description);
    localk.field_dataProto = paramakn;
    localk.field_type = 0;
    localk.field_favFrom = paramc.xGt;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ae.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk, paramBoolean);
    AppMethodBeat.o(221843);
  }
  
  private static void a(long paramLong, String paramString1, String paramString2, String paramString3, akn paramakn)
  {
    AppMethodBeat.i(221842);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramakn;
    localk.field_type = 3;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ae.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(221842);
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, ajx paramajx, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramajx = paramajx.GAa;
    if (o.fB(paramajx))
    {
      paramd.thumbPath = paramajx;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.dFW = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.hFT.clear();
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
        paramString = bx.b((Node)localObject1);
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
        localObject1 = bx.b((Node)localObject2);
        ae.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4205;
        }
        paramString = bx.M(paramString, "dataitem");
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.aPD(paramString.desc.replaceAll("‮", ""));
          }
          paramc.hFT.add(paramString);
        }
        catch (Exception paramString)
        {
          ajx localajx;
          String str;
          ae.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          ae.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.hFT.clear();
        }
        localajx = new ajx();
        localajx.aao(bu.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localajx.aPU((String)paramString.get(".dataitem" + ".$datasourceid"));
        localajx.aap(bu.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localajx.aPM((String)paramString.get(".dataitem" + ".datafmt"));
        localajx.aPC((String)paramString.get(".dataitem" + ".datatitle"));
        localajx.aPD((String)paramString.get(".dataitem" + ".datadesc"));
        localajx.aPE((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localajx.aPF((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localajx.aal(bu.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localajx.aam(bu.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localajx.aPG((String)paramString.get(".dataitem" + ".cdndataurl"));
        localajx.aPH((String)paramString.get(".dataitem" + ".cdndatakey"));
        localajx.hCJ = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localajx.GAO = true;
        localajx.aQd((String)paramString.get(".dataitem" + ".tpaeskey"));
        localajx.aQe((String)paramString.get(".dataitem" + ".tpauthkey"));
        localajx.aQf((String)paramString.get(".dataitem" + ".tpdataurl"));
        localajx.hCP = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localajx.GAU = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localajx.aan(bu.getInt((String)localObject2, 0));
        }
        localajx.aPJ((String)paramString.get(".dataitem" + ".streamdataurl"));
        localajx.aPK((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localajx.aPI((String)paramString.get(".dataitem" + ".streamweburl"));
        localajx.aPN((String)paramString.get(".dataitem" + ".fullmd5"));
        localajx.aPO((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!bu.isNullOrNil((String)localObject2)) {
          localajx.De(bu.getInt((String)localObject2, 0));
        }
        localajx.aPL((String)paramString.get(".dataitem" + ".dataext"));
        localajx.aPS((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localajx.aPT((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!bu.isNullOrNil((String)localObject2)) {
          localajx.Df(bu.getInt((String)localObject2, 0));
        }
        localajx.aPV((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (bu.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localajx.aPP((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!bu.isNullOrNil((String)localObject2)) {
          localajx.aPZ((String)localObject2);
        }
        localajx.aaq(bu.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localajx.aPW((String)paramString.get(".dataitem" + ".sourcetitle"));
        localajx.aPX((String)paramString.get(".dataitem" + ".sourcename"));
        localajx.aQg((String)paramString.get(".dataitem" + ".sourcedesc"));
        localajx.aQh((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localajx.aPY((String)paramString.get(".dataitem" + ".sourcetime"));
        localajx.aQa((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localajx.aQc((String)localObject1);
        }
        localajx.aQi((String)paramString.get(".dataitem" + ".songalbumurl"));
        localajx.aQj((String)paramString.get(".dataitem" + ".songlyric"));
        localajx.aQk((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject1 = new ajy();
        localObject2 = new ajz();
        ((ajz)localObject2).aas(bu.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!bu.isNullOrNil((String)localObject3))
        {
          ((ajz)localObject2).aQl((String)localObject3);
          ae.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((ajz)localObject2).dzZ });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!bu.isNullOrNil((String)localObject3))
        {
          ((ajz)localObject2).aQo((String)localObject3);
          ae.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((ajz)localObject2).GBE });
        }
        ((ajz)localObject2).aQq((String)paramString.get(".dataitem" + ".appid"));
        ((ajz)localObject2).aQr((String)paramString.get(".dataitem" + ".link"));
        ((ajz)localObject2).aQs((String)paramString.get(".dataitem" + ".brandid"));
        ((ajy)localObject1).c((ajz)localObject2);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          ae.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject2 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject2)) {
            break label3132;
          }
          ae.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          ((ajy)localObject1).c(com.tencent.mm.plugin.i.a.e.w(".dataitem", paramString));
          localObject2 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject2)) {
            break label3336;
          }
          ae.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject2)) {
            break label3540;
          }
          ae.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject2)) {
            break label3704;
          }
          ae.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject2)) {
            break label4168;
          }
          ae.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".favbrandmpvideo";
          if (paramString.containsKey(localObject2)) {
            break label4183;
          }
          ae.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localajx.a((ajy)localObject1);
          paramString = localajx;
          continue;
        }
        localObject2 = new ake();
        if (!bu.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((ake)localObject2).aQt((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!bu.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((ake)localObject2).aQu((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!bu.isNullOrNil(str)) {
          ((ake)localObject2).A(bu.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!bu.isNullOrNil(str)) {
          ((ake)localObject2).B(bu.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!bu.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((ake)localObject2).aat(bu.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((ajy)localObject1).c((ake)localObject2);
          continue;
        }
        ((ake)localObject2).aat(bu.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label3132:
      Object localObject3 = new alc();
      ((alc)localObject3).aQP((String)paramString.get((String)localObject2 + ".title"));
      ((alc)localObject3).aQQ((String)paramString.get((String)localObject2 + ".desc"));
      ((alc)localObject3).aQS((String)paramString.get((String)localObject2 + ".thumburl"));
      ((alc)localObject3).aQR((String)paramString.get((String)localObject2 + ".link"));
      ((alc)localObject3).aay(bu.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((ajy)localObject1).a((alc)localObject3);
      continue;
      label3336:
      localObject3 = new akm();
      ((akm)localObject3).aQv((String)paramString.get((String)localObject2 + ".title"));
      ((akm)localObject3).aQw((String)paramString.get((String)localObject2 + ".desc"));
      ((akm)localObject3).aQx((String)paramString.get((String)localObject2 + ".thumburl"));
      ((akm)localObject3).aQy((String)paramString.get((String)localObject2 + ".productinfo"));
      ((akm)localObject3).aau(bu.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((ajy)localObject1).a((akm)localObject3);
      continue;
      label3540:
      localObject3 = new akw();
      ((akw)localObject3).aQL((String)paramString.get((String)localObject2 + ".title"));
      ((akw)localObject3).aQM((String)paramString.get((String)localObject2 + ".desc"));
      ((akw)localObject3).aQN((String)paramString.get((String)localObject2 + ".thumburl"));
      ((akw)localObject3).aQO((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((ajy)localObject1).a((akw)localObject3);
      continue;
      label3704:
      localObject3 = new ajv();
      ((ajv)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((ajv)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((ajv)localObject3).duK = bu.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((ajv)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((ajv)localObject3).type = bu.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((ajv)localObject3).dlk = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((ajv)localObject3).Gzq = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((ajv)localObject3).version = bu.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((ajv)localObject3).kuE = bu.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((ajv)localObject3).kaX = bu.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((ajv)localObject3).dLl = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((ajv)localObject3).subType = bu.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((ajy)localObject1).b((ajv)localObject3);
      continue;
      label4168:
      ((ajy)localObject1).d(com.tencent.mm.plugin.fav.a.a.b.u((String)localObject2, paramString));
      continue;
      label4183:
      ((ajy)localObject1).e(com.tencent.mm.plugin.fav.a.a.b.v((String)localObject2, paramString));
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
  
  private static void a(StringBuilder paramStringBuilder, akn paramakn)
  {
    AppMethodBeat.i(9521);
    if (paramakn.FId != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bu.aSz(paramakn.FId.GBX)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bu.aSz(paramakn.FId.GBY)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramakn.pWN).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(bu.aSz(paramakn.FId.GBY)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(221847);
    if (x.Aj(paramString1))
    {
      paramString1 = new qh();
      paramString1.dFR.msgId = paramLong;
      paramString1.dFR.dyL = paramBoolean;
      paramString1.dFR.errMsg = bu.bI(paramString2, "");
      com.tencent.mm.sdk.b.a.IvT.l(paramString1);
      AppMethodBeat.o(221847);
      return true;
    }
    AppMethodBeat.o(221847);
    return false;
  }
  
  public static String aha(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static com.tencent.mm.protocal.b.a.c awG(String paramString)
  {
    AppMethodBeat.i(9541);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)fVO.get(Integer.valueOf(i));
    if (localObject != null)
    {
      ae.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(9541);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = bx.M(paramString, "recordinfo"); localObject == null; localObject = bx.M("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      ae.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(9541);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.xGt = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      akh localakh = new akh();
      localakh.GBY = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localakh.GBX = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.FId = localakh;
      localc.pWN = bu.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    fVO.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String b(ajx paramajx, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramajx == null) || (bu.isNullOrNil(paramajx.dua)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramajx = eR(aha(paramajx.dua), paramInt);
    paramajx = w.B(new com.tencent.mm.vfs.k(ze(paramLong), paramajx).fTh());
    AppMethodBeat.o(9536);
    return paramajx;
  }
  
  private static List<a.b> b(String paramString, akn paramakn)
  {
    AppMethodBeat.i(221840);
    List localList = Collections.synchronizedList(new ArrayList());
    if (paramakn != null)
    {
      Iterator localIterator = paramakn.oeJ.iterator();
      while (localIterator.hasNext())
      {
        ajx localajx = (ajx)localIterator.next();
        if (localajx.GzV > 26214400L)
        {
          a.b localb = new a.b();
          String str = localajx.GzY;
          paramakn = o.aRh(str);
          localb.filePath = str;
          localb.toUser = paramString;
          localb.fileSize = localajx.GzV;
          localb.fXl = localajx.GzP;
          if (bu.isNullOrNil(localajx.GzR)) {}
          for (;;)
          {
            localb.nZM = paramakn;
            localb.gmb = localajx.GzC;
            localb.fileName = localajx.title;
            localList.add(localb);
            break;
            paramakn = localajx.GzR;
          }
        }
      }
    }
    AppMethodBeat.o(221840);
    return localList;
  }
  
  private static void b(long paramLong, String paramString1, String paramString2, String paramString3, akn paramakn)
  {
    AppMethodBeat.i(221844);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramakn;
    localk.field_type = 1;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    ae.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(221844);
  }
  
  public static boolean b(ajx paramajx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramajx == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = g(paramajx.dua, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(str);
    if (localObject == null)
    {
      j localj = new j();
      localj.field_cdnKey = paramajx.GzC;
      localj.field_cdnUrl = paramajx.GzA;
      localj.field_dataId = paramajx.dua;
      localj.field_mediaId = str;
      localj.field_totalLen = ((int)paramajx.GzV);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = a(paramajx, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = hh(paramajx.dataType, (int)paramajx.GzV);
      localj.field_isThumb = false;
      localj.field_tpaeskey = paramajx.GAP;
      localj.field_tpauthkey = paramajx.hCO;
      localj.field_tpdataurl = paramajx.GAS;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      ae.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
      localObject = localj;
      if (!bu.isNullOrNil(paramajx.GAC))
      {
        localObject = localj;
        if (paramajx.GAC.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(localj);
          localObject = localj;
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((j)localObject).field_status)
      {
        ae.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((j)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((j)localObject).field_status)
      {
        ae.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((j)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
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
  
  public static String c(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramajx = a(paramajx, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramajx;
  }
  
  public static boolean c(ajx paramajx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramajx == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = aha(paramajx.dua);
    String str2 = g(str1, paramLong, true);
    j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(str2);
    if (localj == null)
    {
      localj = new j();
      localj.field_cdnKey = paramajx.Gzw;
      localj.field_cdnUrl = paramajx.hCS;
      localj.field_dataId = str1;
      localj.field_mediaId = str2;
      localj.field_totalLen = ((int)paramajx.GAg);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = b(paramajx, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      localj.field_isThumb = true;
      localj.field_tpdataurl = paramajx.hCJ;
      localj.field_tpauthkey = paramajx.hCO;
      localj.field_tpaeskey = paramajx.hCP;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      ae.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
    }
    for (paramajx = localj;; paramajx = localj)
    {
      ae.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramajx });
      if (4 == paramajx.field_status)
      {
        ae.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramajx.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramajx.field_status)
      {
        ae.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramajx.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramajx.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramajx, new String[] { "localId" });
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
  
  public static boolean d(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new com.tencent.mm.vfs.k(a(paramajx, paramLong, 1)).exists();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static String dm(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean e(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new com.tencent.mm.vfs.k(b(paramajx, paramLong, 1)).exists();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  public static String eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(9539);
    if (bu.jB(paramInt, 1))
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
    AppMethodBeat.i(221841);
    if (paramb == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
      AppMethodBeat.o(221841);
      return null;
    }
    paramb = awG(paramb.hDg);
    if (paramb == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
      AppMethodBeat.o(221841);
      return null;
    }
    akn localakn = new akn();
    localakn.oeJ = new LinkedList();
    localakn.a(paramb.FId);
    localakn.Dj(paramb.pWN);
    localakn.aQA(paramb.title);
    String str = ak.getContext().getString(2131755344);
    Object localObject1 = ak.getContext().getString(2131755773);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramb.hFT.iterator();
    ajx localajx;
    while (((Iterator)localObject2).hasNext())
    {
      localajx = (ajx)((Iterator)localObject2).next();
      if ((localajx.dataType == 8) && (localajx.GzV > 26214400L))
      {
        localajx.aao(1);
        localajx.aPD(str);
        localArrayList.add((String)localObject1 + localajx.title);
        localajx.aPC(null);
        localajx.aPM(null);
        localajx.aPH(null);
        localajx.aPG(null);
        localajx.GzE = 0;
        localajx.GzF = true;
        localajx.De(str.length());
      }
      localakn.oeJ.add(localajx);
    }
    localObject1 = paramb.desc.split("\n");
    localObject2 = new StringBuffer();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localajx = localObject1[i];
      String[] arrayOfString = localajx.split(":");
      if (arrayOfString.length != 2)
      {
        ae.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", new Object[] { localajx, paramb.desc });
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
          ((StringBuffer)localObject2).append(localajx);
        }
      }
    }
    str = ((StringBuffer)localObject2).toString();
    str = str.substring(0, str.length() - 1);
    localakn.aQB(str);
    paramb = new b(str, paramb.xGt, localakn);
    AppMethodBeat.o(221841);
    return paramb;
  }
  
  public static String f(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(224263);
    paramajx = b(paramajx, paramLong, 1);
    AppMethodBeat.o(224263);
    return paramajx;
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
  
  public static boolean g(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramajx == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramajx = g(paramajx.dua, paramLong, true);
    paramajx = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(paramajx);
    if (paramajx == null)
    {
      ae.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramajx.field_status)
    {
      ae.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramajx.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    ae.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramajx.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  private static boolean g(List<ajx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (ajx)paramList.next();
        int i = ((ajx)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = awG(((ajx)localObject).GAK);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = g(((com.tencent.mm.protocal.b.a.c)localObject).hFT, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((bu.isNullOrNil(((ajx)localObject).GzA)) && (bu.isNullOrNil(((ajx)localObject).hCS)) && (bu.isNullOrNil(((ajx)localObject).GAS)) && (bu.isNullOrNil(((ajx)localObject).hCJ))) {
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
  
  public static boolean h(ajx paramajx, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = u.aRG(a(paramajx, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static int hh(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.fKC;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  public static String zQ(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString);
    if (localObject == null)
    {
      ae.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((an)localObject).adG();
    localObject = str;
    if (x.wb(str))
    {
      paramString = r.zA(paramString);
      localObject = v.aAC();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      ae.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = r.e(paramString, 3))
    {
      AppMethodBeat.o(9547);
      return localObject;
      label110:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  private static com.tencent.mm.vfs.k ze(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = new com.tencent.mm.vfs.k(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.ajR().gDT + "record/", Long.valueOf(paramLong) }));
    if ((!((com.tencent.mm.vfs.k)localObject).exists()) || (!((com.tencent.mm.vfs.k)localObject).isDirectory())) {
      ((com.tencent.mm.vfs.k)localObject).mkdirs();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void zf(long paramLong)
  {
    AppMethodBeat.i(9531);
    com.tencent.mm.vfs.k localk = ze(paramLong);
    boolean bool = o.dd(w.B(localk.mUri), true);
    ae.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { w.B(localk.fTh()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.p
 * JD-Core Version:    0.7.0.1
 */