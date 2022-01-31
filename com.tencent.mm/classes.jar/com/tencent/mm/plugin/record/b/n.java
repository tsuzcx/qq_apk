package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import java.io.ByteArrayInputStream;
import java.io.File;
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

public final class n
{
  private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> eka;
  
  static
  {
    AppMethodBeat.i(135720);
    eka = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(135720);
  }
  
  public static String Ny(String paramString)
  {
    AppMethodBeat.i(135711);
    paramString = paramString + "_t";
    AppMethodBeat.o(135711);
    return paramString;
  }
  
  public static com.tencent.mm.protocal.b.a.c XS(String paramString)
  {
    AppMethodBeat.i(135713);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(135713);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)eka.get(Integer.valueOf(i));
    if (localObject != null)
    {
      ab.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(135713);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = br.F(paramString, "recordinfo"); localObject == null; localObject = br.F("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      ab.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(135713);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.wjU = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      ack localack = new ack();
      localack.wUU = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localack.wUT = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.wjV = localack;
      localc.lsP = bo.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    eka.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(135713);
    return localc;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, List<bi> paramList, cm paramcm, com.tencent.mm.protocal.b.a.d paramd)
  {
    AppMethodBeat.i(135700);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(135700);
      return -1;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(135700);
      return -1;
    }
    com.tencent.mm.protocal.b.a.d locald;
    if (paramcm != null)
    {
      locald = paramd;
      if (paramd != null) {}
    }
    else
    {
      paramcm = new cm();
      if (!b.a(paramContext, paramcm, paramString2, paramList))
      {
        AppMethodBeat.o(135700);
        return -1;
      }
      locald = a(paramContext, paramcm, paramString2);
    }
    paramList = a(locald.title, locald.desc, paramcm.cpR.cpT);
    paramd = new bi();
    paramString2 = null;
    if (!bo.isNullOrNil(locald.thumbPath))
    {
      paramContext = bo.readFromFile(locald.thumbPath);
      if (paramContext != null) {
        if (paramContext.length <= 65536) {
          break label431;
        }
      }
    }
    long l;
    label431:
    for (paramContext = com.tencent.mm.at.o.ahC().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.at.o.ahC().T(paramContext))
    {
      ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + paramContext);
      if (!bo.isNullOrNil(paramContext)) {
        paramd.kk(paramContext);
      }
      paramd.setContent(j.b.a(paramList, null, null));
      paramd.setStatus(1);
      paramd.kj(paramString1);
      paramd.fQ(bf.py(paramString1));
      paramd.hL(1);
      paramd.setType(49);
      if (com.tencent.mm.aj.f.lg(paramString1)) {
        paramd.jl(com.tencent.mm.aj.a.e.aaQ());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(paramd);
      ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label442;
      }
      ab.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
      int i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(135700);
      return 0 - i;
      paramContext = paramString2;
      if (locald.cED != 0) {
        break;
      }
      paramContext = paramString2;
      if (bo.isNullOrNil(locald.mxW)) {
        break;
      }
      paramContext = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.ah.b.b(locald.mxW, false, -1));
      break;
    }
    label442:
    ab.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    paramd.setMsgId(l);
    paramContext = new com.tencent.mm.af.j();
    paramContext.field_xml = paramd.field_content;
    paramContext.field_title = paramList.title;
    paramContext.field_type = paramList.type;
    paramContext.field_description = paramList.description;
    paramContext.field_msgId = l;
    paramContext.field_appId = paramList.appId;
    com.tencent.mm.plugin.s.a.cad().insert(paramContext);
    paramContext = paramcm.cpR.cpT.wVc.iterator();
    for (boolean bool = false; paramContext.hasNext(); bool = true)
    {
      label562:
      paramString2 = (aca)paramContext.next();
      if (bo.isNullOrNil(paramString2.mBq)) {
        paramString2.anD(cj(paramString2.toString(), paramString2.dataType));
      }
      if ((!bool) && (!com.tencent.mm.a.e.cN(paramString2.wTa)) && (!com.tencent.mm.a.e.cN(paramString2.wTc)) && (bo.isNullOrNil(paramString2.wSC)) && (bo.isNullOrNil(paramString2.fgM)) && (bo.isNullOrNil(paramString2.wTU)) && (bo.isNullOrNil(paramString2.fgD))) {
        break label562;
      }
    }
    ab.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new com.tencent.mm.plugin.record.a.j();
      paramContext.field_msgId = l;
      paramContext.field_title = paramList.title;
      paramContext.field_desc = paramList.description;
      paramContext.field_toUser = paramString1;
      paramContext.field_dataProto = paramcm.cpR.cpT;
      paramContext.field_type = 3;
      paramContext.field_localId = (new Random().nextInt(2147483645) + 1);
      ab.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramContext)), Long.valueOf(l), Integer.valueOf(paramContext.field_localId) });
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramContext);
    }
    for (;;)
    {
      AppMethodBeat.o(135700);
      return 0;
      ab.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.record.a.f.class)).kW(l);
    }
  }
  
  public static int a(String paramString1, acq paramacq, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(135704);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(135704);
      return -1;
    }
    if ((paramacq == null) || (paramacq.wVc.isEmpty()))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(135704);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramacq);
    bi localbi = new bi();
    paramString2 = null;
    if (!bo.isNullOrNil(paramString4))
    {
      paramString2 = bo.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label365;
        }
      }
    }
    long l;
    label365:
    for (paramString2 = com.tencent.mm.at.o.ahC().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.at.o.ahC().T(paramString2))
    {
      ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " thumbData MsgInfo path:" + paramString2);
      if (!bo.isNullOrNil(paramString2)) {
        localbi.kk(paramString2);
      }
      localbi.setContent(j.b.a(paramString3, null, null));
      localbi.setStatus(1);
      localbi.kj(paramString1);
      localbi.fQ(bf.py(paramString1));
      localbi.hL(1);
      localbi.setType(49);
      if (com.tencent.mm.aj.f.lg(paramString1)) {
        localbi.jl(com.tencent.mm.aj.a.e.aaQ());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z(localbi);
      ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label376;
      }
      ab.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(135704);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.sdk.platformtools.d.Na(paramInt));
        break;
      }
      if (bo.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.d.ai(com.tencent.mm.ah.b.b(paramString5, false, -1));
      break;
    }
    label376:
    ab.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    localbi.setMsgId(l);
    paramString2 = new com.tencent.mm.af.j();
    paramString2.field_xml = localbi.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.s.a.cad().insert(paramString2);
    paramString2 = paramacq.wVc.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (aca)paramString2.next();
    } while ((bo.isNullOrNil(paramString4.wSC)) && (bo.isNullOrNil(paramString4.fgM)));
    paramString2 = new com.tencent.mm.plugin.record.a.j();
    paramString2.field_msgId = l;
    paramString2.field_title = paramString3.title;
    paramString2.field_desc = paramString3.description;
    paramString2.field_toUser = paramString1;
    paramString2.field_dataProto = paramacq;
    paramString2.field_type = 1;
    paramString2.field_localId = (new Random().nextInt(2147483645) + 1);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramString2);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramString2);
    AppMethodBeat.o(135704);
    return 0;
  }
  
  public static int a(String paramString1, String paramString2, bi parambi)
  {
    AppMethodBeat.i(135703);
    int i = a(paramString1, paramString2, parambi, false);
    AppMethodBeat.o(135703);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(146005);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(146005);
      return -1;
    }
    if ((parambi == null) || (bo.isNullOrNil(parambi.field_content)))
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(146005);
      return -1;
    }
    if (1 == parambi.field_status)
    {
      ab.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(146005);
      return -1;
    }
    paramString1 = bo.P(paramString1.split(",")).iterator();
    label854:
    while (paramString1.hasNext())
    {
      String str = (String)paramString1.next();
      ab.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.field_status) });
      Object localObject2 = bf.pv(parambi.field_content);
      j.b localb = j.b.mY((String)localObject2);
      if (localb == null)
      {
        ab.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(146005);
        return -1;
      }
      com.tencent.mm.protocal.b.a.c localc = XS(localb.fhc);
      if (localc == null)
      {
        ab.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(146005);
        return -1;
      }
      Object localObject1 = new bi();
      if (!bo.isNullOrNil(parambi.field_imgPath))
      {
        Object localObject3 = bo.readFromFile(com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true));
        localObject3 = com.tencent.mm.at.o.ahC().T((byte[])localObject3);
        ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " thumbData from msg MsgInfo path:" + (String)localObject3);
        if (!bo.isNullOrNil((String)localObject3)) {
          ((bi)localObject1).kk((String)localObject3);
        }
      }
      ((bi)localObject1).setContent((String)localObject2);
      ((bi)localObject1).setStatus(1);
      ((bi)localObject1).kj(str);
      ((bi)localObject1).fQ(bf.py(str));
      ((bi)localObject1).hL(1);
      ((bi)localObject1).setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Z((bi)localObject1);
      ab.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ab.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.Ml() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(146005);
        return 0 - i;
      }
      ab.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
      ((bi)localObject1).setMsgId(l);
      localObject2 = new ud();
      ((ud)localObject2).cKE.cKF = parambi.field_msgId;
      ((ud)localObject2).cKE.cKG = l;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = new com.tencent.mm.af.j();
      ((com.tencent.mm.af.j)localObject2).field_xml = ((dd)localObject1).field_content;
      ((com.tencent.mm.af.j)localObject2).field_title = localb.title;
      ((com.tencent.mm.af.j)localObject2).field_type = localb.type;
      ((com.tencent.mm.af.j)localObject2).field_description = localb.description;
      ((com.tencent.mm.af.j)localObject2).field_msgId = l;
      ((com.tencent.mm.af.j)localObject2).field_appId = localb.appId;
      com.tencent.mm.plugin.s.a.cad().insert((com.tencent.mm.sdk.e.c)localObject2);
      if (e(localc.fjy, paramBoolean))
      {
        localObject1 = new com.tencent.mm.plugin.record.a.j();
        localObject2 = new acq();
        ((acq)localObject2).wVc.addAll(localc.fjy);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_msgId = l;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_oriMsgId = parambi.field_msgId;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_toUser = str;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_title = localb.title;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_desc = bo.bf(localc.desc, localb.description);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_dataProto = ((acq)localObject2);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_type = 0;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_favFrom = localc.wjU;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_localId = (new Random().nextInt(2147483645) + 1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert((com.tencent.mm.sdk.e.c)localObject1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a((com.tencent.mm.plugin.record.a.j)localObject1, paramBoolean);
      }
      for (;;)
      {
        if (bo.isNullOrNil(paramString2)) {
          break label854;
        }
        com.tencent.mm.plugin.messenger.a.g.bPJ().K(str, paramString2, t.oF(str));
        break;
        ab.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.record.a.f.class)).kW(l);
      }
    }
    AppMethodBeat.o(146005);
    return 0;
  }
  
  public static j.b a(String paramString1, String paramString2, acq paramacq)
  {
    AppMethodBeat.i(135698);
    LinkedList localLinkedList = paramacq.wVc;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bo.apT(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bo.apT(paramString2)).append("</desc>");
    a(localStringBuilder, paramacq);
    localStringBuilder.append(o.bH(localLinkedList));
    localStringBuilder.append("<favusername>").append(bo.apT(com.tencent.mm.model.r.Zn())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramacq = new j.b();
    paramacq.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramacq.description = paramString1;
    if ((!bo.es(localLinkedList)) && (!bo.isNullOrNil(((aca)localLinkedList.get(0)).wSR)) && (((aca)localLinkedList.get(0)).wSR.equals(".htm"))) {
      paramacq.type = 24;
    }
    for (paramacq.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramacq.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramacq.action = "view";
      paramacq.fhc = localStringBuilder.toString();
      AppMethodBeat.o(135698);
      return paramacq;
      paramacq.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cm paramcm, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(135701);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.aj.f.lg(paramString))
    {
      locald.title = paramcm.cpR.cpT.title;
      ab.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcm.cpR.cpT == null) {
        break label413;
      }
      paramcm = paramcm.cpR.cpT.wVc;
      localObject2 = paramcm.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1503;
      }
      Object localObject3 = (aca)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((aca)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((aca)localObject3).dataType, j + 1);
      switch (((aca)localObject3).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      default: 
        break;
      case 1: 
        if (paramString.size() < 5)
        {
          paramString.add(((aca)localObject3).wTy + ":" + ((aca)localObject3).desc + "\n");
          continue;
          if (t.lA(paramString))
          {
            locald.title = paramContext.getString(2131302353);
            break;
          }
          localObject2 = com.tencent.mm.model.r.Zp();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nD(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(2131299790, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(2131299789, new Object[] { localObject2, paramString });
          break;
          paramcm = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297105) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297036) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2130837708);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297097) + ((aca)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230829);
          i = 1;
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297102) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230826);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297102) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230826);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcm = ((aca)localObject3).wTw.wUd;
          localObject3 = new StringBuilder().append(((aca)localObject3).wTy).append(":").append(paramContext.getString(2131296989));
          if ((!bo.isNullOrNil(paramcm.cDl)) && (!paramcm.cDl.equals(paramContext.getString(2131296989)))) {
            break label919;
          }
        }
        for (paramcm = paramcm.label;; paramcm = paramcm.cDl)
        {
          paramString.add(paramcm + "\n");
          if (i != 0) {
            break;
          }
          locald.cED = 2131230807;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297003) + ((aca)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230809);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131296962) + ((aca)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230822);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297041) + ((aca)localObject3).wTw.wUh.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230822);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131296543) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aca)localObject3, 2131230822);
          i = 1;
        }
        break;
      case 16: 
        if (localObject3 == null)
        {
          ab.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        }
        else
        {
          if (paramString.size() < 5) {
            paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131296967) + "\n");
          }
          if (i == 0)
          {
            locald.mxW = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ty(((aca)localObject3).desc).tac;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131297055) + "\n");
        }
        break;
      case 19: 
        label413:
        if (paramString.size() < 5) {
          paramString.add(((aca)localObject3).wTy + ":" + paramContext.getString(2131296544) + ((aca)localObject3).title + "\n");
        }
        label919:
        break;
      }
    }
    label1503:
    locald.desc = "";
    paramcm = paramString.iterator();
    for (paramContext = ""; paramcm.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcm.next();
    }
    paramcm = paramContext.trim();
    paramContext = paramcm;
    if (paramString.size() >= 5) {
      paramContext = paramcm + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(135701);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(146012);
    if ((paramc == null) || (paramc.fjy == null))
    {
      ab.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = bo.bf(paramString, "");
      AppMethodBeat.o(146012);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(bo.apT(paramc.title)).append("</title>");
    paramString.append("<desc>").append(bo.apT(paramc.desc)).append("</desc>");
    ack localack = paramc.wjV;
    if (localack != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(bo.apT(localack.wUT)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(bo.apT(localack.wUU)).append("</noteeditor>");
      paramString.append("</noteinfo>");
    }
    paramString.append("<edittime>").append(paramc.lsP).append("</edittime>");
    paramString.append(o.bH(paramc.fjy));
    paramString.append("<favusername>").append(bo.apT(paramc.wjU)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(146012);
    return paramc;
  }
  
  public static String a(aca paramaca, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(146008);
    if (paramaca == null)
    {
      AppMethodBeat.o(146008);
      return "";
    }
    Object localObject1 = df(paramaca.mBq, paramInt);
    if ((bo.isNullOrNil((String)localObject1)) || (!ah.brt()) || (!com.tencent.mm.kernel.g.RG()))
    {
      AppMethodBeat.o(146008);
      return "";
    }
    Object localObject2 = kZ(paramLong);
    Object localObject3;
    if ((paramaca.dataType == 8) && (!bo.isNullOrNil(paramaca.title)))
    {
      localObject3 = paramaca.title;
      paramInt = paramaca.mBq.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.RM();
      File localFile = new File(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.RL().eHR + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (localFile.exists())
      {
        paramInt = i;
        localObject2 = localFile;
        localObject1 = localObject3;
        if (localFile.isDirectory()) {}
      }
      else
      {
        localFile.mkdirs();
        localObject1 = localObject3;
        localObject2 = localFile;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramaca.wSR != null)
      {
        localObject3 = localObject1;
        if (paramaca.wSR.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramaca.wSR;
          }
        }
      }
      paramaca = new File((File)localObject2, (String)localObject3).getAbsolutePath();
      AppMethodBeat.o(146008);
      return paramaca;
    }
  }
  
  public static String a(String paramString1, String paramString2, acq paramacq, String paramString3, long paramLong)
  {
    AppMethodBeat.i(146004);
    if ((paramacq == null) || (paramacq.wVc == null))
    {
      ab.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(146004);
      return "";
    }
    LinkedList localLinkedList = paramacq.wVc;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bo.apT(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bo.apT(paramString2)).append("</desc>");
    a(localStringBuilder, paramacq);
    localStringBuilder.append(o.bH(localLinkedList));
    localStringBuilder.append("<favusername>").append(bo.apT(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramacq = new j.b();
    paramacq.title = paramString1;
    paramacq.description = paramString2;
    if ((localLinkedList.size() > 0) && (!bo.isNullOrNil(((aca)localLinkedList.get(0)).wSR)) && (((aca)localLinkedList.get(0)).wSR.equals(".htm"))) {
      paramacq.type = 24;
    }
    for (paramacq.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramacq.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramacq.action = "view";
      paramacq.fhc = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.s.a.cad().nx(paramLong);
      if (paramString1 != null) {
        paramacq.appId = paramString1.field_appId;
      }
      paramString1 = j.b.a(paramacq, null, null);
      AppMethodBeat.o(146004);
      return paramString1;
      paramacq.type = 19;
    }
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, aca paramaca, int paramInt)
  {
    AppMethodBeat.i(135702);
    paramaca = paramaca.wTc;
    if (com.tencent.mm.a.e.cN(paramaca))
    {
      paramd.thumbPath = paramaca;
      AppMethodBeat.o(135702);
      return;
    }
    paramd.cED = paramInt;
    AppMethodBeat.o(135702);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(135714);
    paramc.fjy.clear();
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
          break label3782;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label3782;
        }
        int k = localNodeList.getLength();
        i = 0;
        if (i >= k) {
          break label3782;
        }
        localObject1 = localNodeList.item(i);
        paramString = br.b((Node)localObject1);
        if (!(localObject1 instanceof Element)) {
          break label3800;
        }
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label3794;
        }
        localObject1 = ((NodeList)localObject1).item(0).getChildNodes();
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label3794;
        }
        int m = ((NodeList)localObject1).getLength();
        j = 0;
        if (j >= m) {
          break label3794;
        }
        localObject2 = ((NodeList)localObject1).item(j);
        if (!(localObject2 instanceof Element)) {
          break label3807;
        }
        localObject1 = br.b((Node)localObject2);
        ab.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label3789;
        }
        paramString = br.F(paramString, "dataitem");
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          paramc.fjy.add(paramString);
        }
        catch (Exception paramString)
        {
          aca localaca;
          String str;
          ab.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          ab.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.fjy.clear();
        }
        localaca = new aca();
        localaca.MI(bo.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localaca.anI((String)paramString.get(".dataitem" + ".$datasourceid"));
        localaca.MJ(bo.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localaca.anA((String)paramString.get(".dataitem" + ".datafmt"));
        localaca.anq((String)paramString.get(".dataitem" + ".datatitle"));
        localaca.anr((String)paramString.get(".dataitem" + ".datadesc"));
        localaca.ans((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localaca.ant((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localaca.MF(bo.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localaca.MG(bo.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localaca.anu((String)paramString.get(".dataitem" + ".cdndataurl"));
        localaca.anv((String)paramString.get(".dataitem" + ".cdndatakey"));
        localaca.fgD = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localaca.wTQ = true;
        localaca.anR((String)paramString.get(".dataitem" + ".tpaeskey"));
        localaca.anS((String)paramString.get(".dataitem" + ".tpauthkey"));
        localaca.anT((String)paramString.get(".dataitem" + ".tpdataurl"));
        localaca.fgJ = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localaca.wTW = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localaca.MH(bo.getInt((String)localObject2, 0));
        }
        localaca.anx((String)paramString.get(".dataitem" + ".streamdataurl"));
        localaca.any((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localaca.anw((String)paramString.get(".dataitem" + ".streamweburl"));
        localaca.anB((String)paramString.get(".dataitem" + ".fullmd5"));
        localaca.anC((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!bo.isNullOrNil((String)localObject2)) {
          localaca.nC(bo.getInt((String)localObject2, 0));
        }
        localaca.anz((String)paramString.get(".dataitem" + ".dataext"));
        localaca.anG((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localaca.anH((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!bo.isNullOrNil((String)localObject2)) {
          localaca.nD(bo.getInt((String)localObject2, 0));
        }
        localaca.anJ((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (bo.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localaca.anD((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!bo.isNullOrNil((String)localObject2)) {
          localaca.anN((String)localObject2);
        }
        localaca.MK(bo.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localaca.anK((String)paramString.get(".dataitem" + ".sourcetitle"));
        localaca.anL((String)paramString.get(".dataitem" + ".sourcename"));
        localaca.anU((String)paramString.get(".dataitem" + ".sourcedesc"));
        localaca.anV((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localaca.anM((String)paramString.get(".dataitem" + ".sourcetime"));
        localaca.anO((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localaca.anQ((String)localObject1);
        }
        localObject1 = new acb();
        localObject2 = new acc();
        ((acc)localObject2).MM(bo.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!bo.isNullOrNil((String)localObject3))
        {
          ((acc)localObject2).anW((String)localObject3);
          ab.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((acc)localObject2).czp });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!bo.isNullOrNil((String)localObject3))
        {
          ((acc)localObject2).anZ((String)localObject3);
          ab.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((acc)localObject2).wUA });
        }
        ((acc)localObject2).aob((String)paramString.get(".dataitem" + ".appid"));
        ((acc)localObject2).aoc((String)paramString.get(".dataitem" + ".link"));
        ((acc)localObject2).aod((String)paramString.get(".dataitem" + ".brandid"));
        ((acb)localObject1).c((acc)localObject2);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject2 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject2)) {
            break label2922;
          }
          ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject2)) {
            break label3126;
          }
          ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject2)) {
            break label3330;
          }
          ab.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject2)) {
            break label3494;
          }
          ab.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject2)) {
            break label3767;
          }
          ab.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localaca.a((acb)localObject1);
          paramString = localaca;
          continue;
        }
        localObject2 = new ach();
        if (!bo.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((ach)localObject2).aoe((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!bo.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((ach)localObject2).aof((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!bo.isNullOrNil(str)) {
          ((ach)localObject2).C(bo.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!bo.isNullOrNil(str)) {
          ((ach)localObject2).D(bo.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!bo.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((ach)localObject2).MN(bo.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((acb)localObject1).a((ach)localObject2);
          continue;
        }
        ((ach)localObject2).MN(bo.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(135714);
        return;
      }
      continue;
      label2922:
      Object localObject3 = new adf();
      ((adf)localObject3).aoA((String)paramString.get((String)localObject2 + ".title"));
      ((adf)localObject3).aoB((String)paramString.get((String)localObject2 + ".desc"));
      ((adf)localObject3).aoD((String)paramString.get((String)localObject2 + ".thumburl"));
      ((adf)localObject3).aoC((String)paramString.get((String)localObject2 + ".link"));
      ((adf)localObject3).MS(bo.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((acb)localObject1).a((adf)localObject3);
      continue;
      label3126:
      localObject3 = new acp();
      ((acp)localObject3).aog((String)paramString.get((String)localObject2 + ".title"));
      ((acp)localObject3).aoh((String)paramString.get((String)localObject2 + ".desc"));
      ((acp)localObject3).aoi((String)paramString.get((String)localObject2 + ".thumburl"));
      ((acp)localObject3).aoj((String)paramString.get((String)localObject2 + ".productinfo"));
      ((acp)localObject3).MO(bo.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((acb)localObject1).a((acp)localObject3);
      continue;
      label3330:
      localObject3 = new acz();
      ((acz)localObject3).aow((String)paramString.get((String)localObject2 + ".title"));
      ((acz)localObject3).aox((String)paramString.get((String)localObject2 + ".desc"));
      ((acz)localObject3).aoy((String)paramString.get((String)localObject2 + ".thumburl"));
      ((acz)localObject3).aoz((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((acb)localObject1).a((acz)localObject3);
      continue;
      label3494:
      localObject3 = new aby();
      ((aby)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((aby)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((aby)localObject3).cvs = bo.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((aby)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((aby)localObject3).type = bo.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((aby)localObject3).cmG = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((aby)localObject3).wSs = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((acb)localObject1).a((aby)localObject3);
      continue;
      label3767:
      ((acb)localObject1).b(com.tencent.mm.plugin.fav.a.a.b.o((String)localObject2, paramString));
      continue;
      label3782:
      AppMethodBeat.o(135714);
      return;
      label3789:
      paramString = null;
      continue;
      label3794:
      localObject1 = null;
      continue;
      label3800:
      i += 1;
      continue;
      label3807:
      j += 1;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, acq paramacq)
  {
    AppMethodBeat.i(135699);
    if (paramacq.wjV != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bo.apT(paramacq.wjV.wUT)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bo.apT(paramacq.wjV.wUU)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramacq.lsP).append("</edittime>");
    }
    AppMethodBeat.o(135699);
  }
  
  public static String b(aca paramaca, long paramLong, int paramInt)
  {
    AppMethodBeat.i(146009);
    if ((paramaca == null) || (bo.isNullOrNil(paramaca.mBq)))
    {
      AppMethodBeat.o(146009);
      return "";
    }
    paramaca = df(Ny(paramaca.mBq), paramInt);
    paramaca = new File(kZ(paramLong), paramaca).getAbsolutePath();
    AppMethodBeat.o(146009);
    return paramaca;
  }
  
  public static boolean b(aca paramaca, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(135715);
    if (paramaca == null)
    {
      ab.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(135715);
      return false;
    }
    String str = h(paramaca.mBq, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(str);
    if (localObject == null)
    {
      i locali = new i();
      locali.field_cdnKey = paramaca.wSE;
      locali.field_cdnUrl = paramaca.wSC;
      locali.field_dataId = paramaca.mBq;
      locali.field_mediaId = str;
      locali.field_totalLen = ((int)paramaca.wSX);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = a(paramaca, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = fl(paramaca.dataType, (int)paramaca.wSX);
      locali.field_isThumb = false;
      locali.field_tpaeskey = paramaca.wTR;
      locali.field_tpauthkey = paramaca.fgI;
      locali.field_tpdataurl = paramaca.wTU;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ab.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
      localObject = locali;
      if (!bo.isNullOrNil(paramaca.wTE))
      {
        localObject = locali;
        if (paramaca.wTE.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(locali);
          localObject = locali;
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((i)localObject).field_status)
      {
        ab.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((i)localObject).field_errCode) });
        AppMethodBeat.o(135715);
        return false;
      }
      if (3 == ((i)localObject).field_status)
      {
        ab.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((i)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          ((i)localObject).field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((i)localObject, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(135715);
        return true;
      }
      AppMethodBeat.o(135715);
      return false;
    }
  }
  
  public static String c(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(135707);
    paramaca = a(paramaca, paramLong, 1);
    AppMethodBeat.o(135707);
    return paramaca;
  }
  
  public static boolean c(aca paramaca, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(135717);
    if (paramaca == null)
    {
      ab.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(135717);
      return false;
    }
    String str1 = Ny(paramaca.mBq);
    String str2 = h(str1, paramLong, true);
    i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(str2);
    if (locali == null)
    {
      locali = new i();
      locali.field_cdnKey = paramaca.wSy;
      locali.field_cdnUrl = paramaca.fgM;
      locali.field_dataId = str1;
      locali.field_mediaId = str2;
      locali.field_totalLen = ((int)paramaca.wTi);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = b(paramaca, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      locali.field_isThumb = true;
      locali.field_tpdataurl = paramaca.fgD;
      locali.field_tpauthkey = paramaca.fgI;
      locali.field_tpaeskey = paramaca.fgJ;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ab.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
    }
    for (paramaca = locali;; paramaca = locali)
    {
      ab.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramaca });
      if (4 == paramaca.field_status)
      {
        ab.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramaca.field_errCode) });
        AppMethodBeat.o(135717);
        return false;
      }
      if (3 == paramaca.field_status)
      {
        ab.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramaca.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramaca.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramaca, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(135717);
        return true;
      }
      AppMethodBeat.o(135717);
      return false;
    }
  }
  
  public static String cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(146007);
    paramString = com.tencent.mm.a.g.w((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(146007);
    return paramString;
  }
  
  public static boolean d(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(135708);
    boolean bool = new File(a(paramaca, paramLong, 1)).exists();
    AppMethodBeat.o(135708);
    return bool;
  }
  
  public static String df(String paramString, int paramInt)
  {
    AppMethodBeat.i(146011);
    if (bo.hl(paramInt, 1))
    {
      AppMethodBeat.o(146011);
      return paramString;
    }
    paramString = paramInt + "_" + paramString;
    AppMethodBeat.o(146011);
    return paramString;
  }
  
  public static boolean e(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(135709);
    boolean bool = new File(b(paramaca, paramLong, 1)).exists();
    AppMethodBeat.o(135709);
    return bool;
  }
  
  private static boolean e(List<aca> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(146006);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (aca)paramList.next();
        int i = ((aca)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = XS(((aca)localObject).wTM);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = e(((com.tencent.mm.protocal.b.a.c)localObject).fjy, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((bo.isNullOrNil(((aca)localObject).wSC)) && (bo.isNullOrNil(((aca)localObject).fgM)) && (bo.isNullOrNil(((aca)localObject).wTU)) && (bo.isNullOrNil(((aca)localObject).fgD))) {
            continue;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(146006);
      return bool1;
    }
  }
  
  public static String f(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(156870);
    paramaca = b(paramaca, paramLong, 1);
    AppMethodBeat.o(156870);
    return paramaca;
  }
  
  public static int fl(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.ecH;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  public static boolean g(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(135716);
    if (paramaca == null)
    {
      ab.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(135716);
      return true;
    }
    paramaca = h(paramaca.mBq, paramLong, true);
    paramaca = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().XR(paramaca);
    if (paramaca == null)
    {
      ab.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(135716);
      return false;
    }
    if (4 == paramaca.field_status)
    {
      ab.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramaca.field_errCode) });
      AppMethodBeat.o(135716);
      return true;
    }
    ab.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramaca.field_status) });
    AppMethodBeat.o(135716);
    return false;
  }
  
  public static String h(String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(135712);
    if (paramBoolean)
    {
      paramString = paramString + "@record_download@" + paramLong;
      AppMethodBeat.o(135712);
      return paramString;
    }
    paramString = paramString + "@record_upload@" + paramLong;
    AppMethodBeat.o(135712);
    return paramString;
  }
  
  public static boolean h(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(135719);
    boolean bool = com.tencent.mm.sdk.platformtools.r.aoY(a(paramaca, paramLong, 1));
    AppMethodBeat.o(135719);
    return bool;
  }
  
  private static File kZ(long paramLong)
  {
    AppMethodBeat.i(135705);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = new File(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.RL().eHR + "record/", Long.valueOf(paramLong) }));
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      ((File)localObject).mkdirs();
    }
    AppMethodBeat.o(135705);
    return localObject;
  }
  
  public static void la(long paramLong)
  {
    AppMethodBeat.i(135706);
    File localFile = kZ(paramLong);
    boolean bool = com.tencent.mm.a.e.o(localFile);
    ab.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { localFile.getAbsolutePath(), Boolean.valueOf(bool) });
    AppMethodBeat.o(135706);
  }
  
  public static String nF(String paramString)
  {
    AppMethodBeat.i(135718);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if (localObject == null)
    {
      ab.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(135718);
      return "";
    }
    String str = ((ad)localObject).Of();
    localObject = str;
    if (t.lA(str))
    {
      paramString = com.tencent.mm.model.n.nt(paramString);
      localObject = com.tencent.mm.model.r.Zn();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label111;
      }
      ab.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = com.tencent.mm.model.n.f(paramString, 3))
    {
      AppMethodBeat.o(135718);
      return localObject;
      label111:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.n
 * JD-Core Version:    0.7.0.1
 */