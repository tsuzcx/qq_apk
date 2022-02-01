package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import java.io.ByteArrayInputStream;
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
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> fwL;
  
  static
  {
    AppMethodBeat.i(9549);
    fwL = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static String XS(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, List<bl> paramList, cs paramcs, com.tencent.mm.protocal.b.a.d paramd)
  {
    AppMethodBeat.i(9522);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9522);
      return -1;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9522);
      return -1;
    }
    com.tencent.mm.protocal.b.a.d locald;
    if (paramcs != null)
    {
      locald = paramd;
      if (paramd != null) {}
    }
    else
    {
      paramcs = new cs();
      if (!b.a(paramContext, paramcs, paramString2, paramList))
      {
        AppMethodBeat.o(9522);
        return -1;
      }
      locald = a(paramContext, paramcs, paramString2);
    }
    paramList = a(locald.title, locald.desc, paramcs.deQ.deS);
    paramd = new bl();
    paramString2 = null;
    if (!bt.isNullOrNil(locald.thumbPath))
    {
      paramContext = bt.readFromFile(locald.thumbPath);
      if (paramContext != null) {
        if (paramContext.length <= 65536) {
          break label434;
        }
      }
    }
    long l;
    label434:
    for (paramContext = com.tencent.mm.aw.o.ayF().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.aw.o.ayF().ab(paramContext))
    {
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " thumbData MsgInfo path:" + paramContext);
      if (!bt.isNullOrNil(paramContext)) {
        paramd.nZ(paramContext);
      }
      paramd.setContent(k.b.a(paramList, null, null));
      paramd.setStatus(1);
      paramd.nY(paramString1);
      paramd.kY(bi.uj(paramString1));
      paramd.jV(1);
      paramd.setType(49);
      if (com.tencent.mm.am.f.pc(paramString1)) {
        paramd.mZ(com.tencent.mm.am.a.e.SM());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(paramd);
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label445;
      }
      ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
      int i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9522);
      return 0 - i;
      paramContext = paramString2;
      if (locald.dvf != 0) {
        break;
      }
      paramContext = paramString2;
      if (bt.isNullOrNil(locald.qfw)) {
        break;
      }
      paramContext = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.ak.c.a(locald.qfw, false, -1, null));
      break;
    }
    label445:
    ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    paramd.setMsgId(l);
    paramContext = new com.tencent.mm.ai.k();
    paramContext.field_xml = paramd.field_content;
    paramContext.field_title = paramList.title;
    paramContext.field_type = paramList.type;
    paramContext.field_description = paramList.description;
    paramContext.field_msgId = l;
    paramContext.field_appId = paramList.appId;
    com.tencent.mm.plugin.s.a.cZR().insert(paramContext);
    paramContext = paramcs.deQ.deS.mVb.iterator();
    for (boolean bool = false; paramContext.hasNext(); bool = true)
    {
      label564:
      paramString2 = (afy)paramContext.next();
      if (bt.isNullOrNil(paramString2.dkb)) {
        paramString2.aDy(cT(paramString2.toString(), paramString2.dataType));
      }
      if ((!bool) && (!com.tencent.mm.vfs.i.eK(paramString2.Dgx)) && (!com.tencent.mm.vfs.i.eK(paramString2.Dgz)) && (bt.isNullOrNil(paramString2.DfZ)) && (bt.isNullOrNil(paramString2.gHu)) && (bt.isNullOrNil(paramString2.Dhr)) && (bt.isNullOrNil(paramString2.gHl))) {
        break label564;
      }
    }
    ad.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new com.tencent.mm.plugin.record.a.j();
      paramContext.field_msgId = l;
      paramContext.field_title = paramList.title;
      paramContext.field_desc = paramList.description;
      paramContext.field_toUser = paramString1;
      paramContext.field_dataProto = paramcs.deQ.deS;
      paramContext.field_type = 3;
      paramContext.field_localId = (new Random().nextInt(2147483645) + 1);
      ad.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramContext)), Long.valueOf(l), Integer.valueOf(paramContext.field_localId) });
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramContext);
    }
    for (;;)
    {
      AppMethodBeat.o(9522);
      return 0;
      ad.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).rN(l);
    }
  }
  
  public static int a(String paramString1, ago paramago, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramago == null) || (paramago.mVb.isEmpty()))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramago);
    bl localbl = new bl();
    paramString2 = null;
    if (!bt.isNullOrNil(paramString4))
    {
      paramString2 = bt.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label363;
        }
      }
    }
    long l;
    label363:
    for (paramString2 = com.tencent.mm.aw.o.ayF().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.aw.o.ayF().ab(paramString2))
    {
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " thumbData MsgInfo path:" + paramString2);
      if (!bt.isNullOrNil(paramString2)) {
        localbl.nZ(paramString2);
      }
      localbl.setContent(k.b.a(paramString3, null, null));
      localbl.setStatus(1);
      localbl.nY(paramString1);
      localbl.kY(bi.uj(paramString1));
      localbl.jV(1);
      localbl.setType(49);
      if (com.tencent.mm.am.f.pc(paramString1)) {
        localbl.mZ(com.tencent.mm.am.a.e.SM());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(localbl);
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label374;
      }
      ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9528);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.sdk.platformtools.f.Wf(paramInt));
        break;
      }
      if (bt.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.ak.c.a(paramString5, false, -1, null));
      break;
    }
    label374:
    ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localbl.setMsgId(l);
    paramString2 = new com.tencent.mm.ai.k();
    paramString2.field_xml = localbl.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.s.a.cZR().insert(paramString2);
    paramString2 = paramago.mVb.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (afy)paramString2.next();
    } while ((bt.isNullOrNil(paramString4.DfZ)) && (bt.isNullOrNil(paramString4.gHu)));
    paramString2 = new com.tencent.mm.plugin.record.a.j();
    paramString2.field_msgId = l;
    paramString2.field_title = paramString3.title;
    paramString2.field_desc = paramString3.description;
    paramString2.field_toUser = paramString1;
    paramString2.field_dataProto = paramago;
    paramString2.field_type = 1;
    paramString2.field_localId = (new Random().nextInt(2147483645) + 1);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramString2);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramString2);
    AppMethodBeat.o(9528);
    return 0;
  }
  
  public static int a(String paramString1, String paramString2, bl parambl)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, parambl, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((parambl == null) || (bt.isNullOrNil(parambl.field_content)))
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == parambl.field_status)
    {
      ad.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = bt.S(paramString1.split(",")).iterator();
    label850:
    while (paramString1.hasNext())
    {
      String str = (String)paramString1.next();
      ad.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambl.field_msgId), Integer.valueOf(parambl.field_status) });
      Object localObject2 = bi.ug(parambl.field_content);
      k.b localb = k.b.rx((String)localObject2);
      if (localb == null)
      {
        ad.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      com.tencent.mm.protocal.b.a.c localc = alt(localb.gHI);
      if (localc == null)
      {
        ad.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      Object localObject1 = new bl();
      if (!bt.isNullOrNil(parambl.field_imgPath))
      {
        Object localObject3 = bt.readFromFile(com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true));
        localObject3 = com.tencent.mm.aw.o.ayF().ab((byte[])localObject3);
        ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " thumbData from msg MsgInfo path:" + (String)localObject3);
        if (!bt.isNullOrNil((String)localObject3)) {
          ((bl)localObject1).nZ((String)localObject3);
        }
      }
      ((bl)localObject1).setContent((String)localObject2);
      ((bl)localObject1).setStatus(1);
      ((bl)localObject1).nY(str);
      ((bl)localObject1).kY(bi.uj(str));
      ((bl)localObject1).jV(1);
      ((bl)localObject1).setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an((bl)localObject1);
      ad.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ad.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.XJ() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      ad.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bl)localObject1).setMsgId(l);
      localObject2 = new wc();
      ((wc)localObject2).dBB.dBC = parambl.field_msgId;
      ((wc)localObject2).dBB.dBD = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = new com.tencent.mm.ai.k();
      ((com.tencent.mm.ai.k)localObject2).field_xml = ((du)localObject1).field_content;
      ((com.tencent.mm.ai.k)localObject2).field_title = localb.title;
      ((com.tencent.mm.ai.k)localObject2).field_type = localb.type;
      ((com.tencent.mm.ai.k)localObject2).field_description = localb.description;
      ((com.tencent.mm.ai.k)localObject2).field_msgId = l;
      ((com.tencent.mm.ai.k)localObject2).field_appId = localb.appId;
      com.tencent.mm.plugin.s.a.cZR().insert((com.tencent.mm.sdk.e.c)localObject2);
      if (f(localc.gKs, paramBoolean))
      {
        localObject1 = new com.tencent.mm.plugin.record.a.j();
        localObject2 = new ago();
        ((ago)localObject2).mVb.addAll(localc.gKs);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_msgId = l;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_oriMsgId = parambl.field_msgId;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_toUser = str;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_title = localb.title;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_desc = bt.by(localc.desc, localb.description);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_dataProto = ((ago)localObject2);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_type = 0;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_favFrom = localc.Csg;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_localId = (new Random().nextInt(2147483645) + 1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert((com.tencent.mm.sdk.e.c)localObject1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a((com.tencent.mm.plugin.record.a.j)localObject1, paramBoolean);
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramString2)) {
          break label850;
        }
        com.tencent.mm.plugin.messenger.a.j.cOB().W(str, paramString2, w.tq(str));
        break;
        ad.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).rN(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static k.b a(String paramString1, String paramString2, ago paramago)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramago.mVb;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bt.aGf(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bt.aGf(paramString2)).append("</desc>");
    a(localStringBuilder, paramago);
    localStringBuilder.append(o.dj(localLinkedList));
    localStringBuilder.append("<favusername>").append(bt.aGf(u.aqG())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramago = new k.b();
    paramago.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramago.description = paramString1;
    if ((!bt.gL(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((afy)localLinkedList.get(0)))) {
      paramago.type = 24;
    }
    for (paramago.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramago.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramago.action = "view";
      paramago.gHI = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramago;
      paramago.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cs paramcs, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.am.f.pc(paramString))
    {
      locald.title = paramcs.deQ.deS.title;
      ad.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcs.deQ.deS == null) {
        break label425;
      }
      paramcs = paramcs.deQ.deS.mVb;
      localObject2 = paramcs.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1582;
      }
      Object localObject3 = (afy)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((afy)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((afy)localObject3).dataType, j + 1);
      switch (((afy)localObject3).dataType)
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
          paramString.add(((afy)localObject3).DgV + ":" + ((afy)localObject3).desc + "\n");
          continue;
          if (w.pF(paramString))
          {
            locald.title = paramContext.getString(2131762236);
            break;
          }
          localObject2 = u.aqI();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sg(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(2131758964, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(2131758963, new Object[] { localObject2, paramString });
          break;
          paramcs = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755929) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755853) + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131230944);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755920) + ((afy)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 22: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755920) + ((afy)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcs = ((afy)localObject3).DgT.DhC;
          localObject3 = new StringBuilder().append(((afy)localObject3).DgV).append(":").append(paramContext.getString(2131755806));
          if ((!bt.isNullOrNil(paramcs.dtN)) && (!paramcs.dtN.equals(paramContext.getString(2131755806)))) {
            break label999;
          }
        }
        for (paramcs = paramcs.label;; paramcs = paramcs.dtN)
        {
          paramString.add(paramcs + "\n");
          if (i != 0) {
            break;
          }
          locald.dvf = 2131689562;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755820) + ((afy)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689564);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755773) + ((afy)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755858) + ((afy)localObject3).DgT.DhG.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755278) + "\n");
        }
        if (i == 0)
        {
          a(locald, (afy)localObject3, 2131689577);
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
            paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755782) + "\n");
          }
          if (i == 0)
          {
            locald.qfw = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agC(((afy)localObject3).desc).yGA;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755872) + "\n");
        }
        break;
      case 19: 
        label425:
        label999:
        if (paramString.size() < 5) {
          paramString.add(((afy)localObject3).DgV + ":" + paramContext.getString(2131755279) + ((afy)localObject3).title + "\n");
        }
        break;
      }
    }
    label1582:
    locald.desc = "";
    paramcs = paramString.iterator();
    for (paramContext = ""; paramcs.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcs.next();
    }
    paramcs = paramContext.trim();
    paramContext = paramcs;
    if (paramString.size() >= 5) {
      paramContext = paramcs + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.gKs == null))
    {
      ad.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = bt.by(paramString, "");
      AppMethodBeat.o(9543);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(bt.aGf(paramc.title)).append("</title>");
    paramString.append("<desc>").append(bt.aGf(paramc.desc)).append("</desc>");
    agi localagi = paramc.Csh;
    if (localagi != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(bt.aGf(localagi.Diw)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(bt.aGf(localagi.Dix)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(bt.aGf(localagi.Dix)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.oJi).append("</edittime>");
    paramString.append(o.dj(paramc.gKs));
    paramString.append("<favusername>").append(bt.aGf(paramc.Csg)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(afy paramafy, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramafy == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = ej(paramafy.dkb, paramInt);
    if ((bt.isNullOrNil((String)localObject1)) || (!aj.cbv()) || (!com.tencent.mm.kernel.g.afw()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = rQ(paramLong);
    Object localObject3;
    if ((paramafy.dataType == 8) && (!bt.isNullOrNil(paramafy.title)))
    {
      localObject3 = paramafy.title;
      paramInt = paramafy.dkb.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.afB().gcW + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
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
      if (paramafy.Dgo != null)
      {
        localObject3 = localObject1;
        if (paramafy.Dgo.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramafy.Dgo;
          }
        }
      }
      paramafy = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((com.tencent.mm.vfs.e)localObject2, (String)localObject3).fhU());
      AppMethodBeat.o(9532);
      return paramafy;
    }
  }
  
  public static String a(String paramString1, String paramString2, ago paramago, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramago == null) || (paramago.mVb == null))
    {
      ad.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramago.mVb;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bt.aGf(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bt.aGf(paramString2)).append("</desc>");
    a(localStringBuilder, paramago);
    localStringBuilder.append(o.dj(localLinkedList));
    localStringBuilder.append("<favusername>").append(bt.aGf(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramago = new k.b();
    paramago.title = paramString1;
    paramago.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((afy)localLinkedList.get(0)))) {
      paramago.type = 24;
    }
    for (paramago.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramago.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramago.action = "view";
      paramago.gHI = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.s.a.cZR().vk(paramLong);
      if (paramString1 != null) {
        paramago.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramago, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramago.type = 19;
    }
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, afy paramafy, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramafy = paramafy.Dgz;
    if (com.tencent.mm.vfs.i.eK(paramafy))
    {
      paramd.thumbPath = paramafy;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.dvf = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.gKs.clear();
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
        paramString = bw.K(paramString, "dataitem");
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.aDm(paramString.desc.replaceAll("‮", ""));
          }
          paramc.gKs.add(paramString);
        }
        catch (Exception paramString)
        {
          afy localafy;
          String str;
          ad.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          ad.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.gKs.clear();
        }
        localafy = new afy();
        localafy.VD(bt.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localafy.aDD((String)paramString.get(".dataitem" + ".$datasourceid"));
        localafy.VE(bt.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localafy.aDv((String)paramString.get(".dataitem" + ".datafmt"));
        localafy.aDl((String)paramString.get(".dataitem" + ".datatitle"));
        localafy.aDm((String)paramString.get(".dataitem" + ".datadesc"));
        localafy.aDn((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localafy.aDo((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localafy.VA(bt.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localafy.VB(bt.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localafy.aDp((String)paramString.get(".dataitem" + ".cdndataurl"));
        localafy.aDq((String)paramString.get(".dataitem" + ".cdndatakey"));
        localafy.gHl = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localafy.Dhn = true;
        localafy.aDM((String)paramString.get(".dataitem" + ".tpaeskey"));
        localafy.aDN((String)paramString.get(".dataitem" + ".tpauthkey"));
        localafy.aDO((String)paramString.get(".dataitem" + ".tpdataurl"));
        localafy.gHr = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localafy.Dht = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localafy.VC(bt.getInt((String)localObject2, 0));
        }
        localafy.aDs((String)paramString.get(".dataitem" + ".streamdataurl"));
        localafy.aDt((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localafy.aDr((String)paramString.get(".dataitem" + ".streamweburl"));
        localafy.aDw((String)paramString.get(".dataitem" + ".fullmd5"));
        localafy.aDx((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localafy.vp(bt.getInt((String)localObject2, 0));
        }
        localafy.aDu((String)paramString.get(".dataitem" + ".dataext"));
        localafy.aDB((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localafy.aDC((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!bt.isNullOrNil((String)localObject2)) {
          localafy.vq(bt.getInt((String)localObject2, 0));
        }
        localafy.aDE((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (bt.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localafy.aDy((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!bt.isNullOrNil((String)localObject2)) {
          localafy.aDI((String)localObject2);
        }
        localafy.VF(bt.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localafy.aDF((String)paramString.get(".dataitem" + ".sourcetitle"));
        localafy.aDG((String)paramString.get(".dataitem" + ".sourcename"));
        localafy.aDP((String)paramString.get(".dataitem" + ".sourcedesc"));
        localafy.aDQ((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localafy.aDH((String)paramString.get(".dataitem" + ".sourcetime"));
        localafy.aDJ((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localafy.aDL((String)localObject1);
        }
        localafy.aDR((String)paramString.get(".dataitem" + ".songalbumurl"));
        localafy.aDS((String)paramString.get(".dataitem" + ".songlyric"));
        localafy.aDT((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject1 = new afz();
        localObject2 = new aga();
        ((aga)localObject2).VH(bt.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((aga)localObject2).aDU((String)localObject3);
          ad.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((aga)localObject2).dpv });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!bt.isNullOrNil((String)localObject3))
        {
          ((aga)localObject2).aDX((String)localObject3);
          ad.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((aga)localObject2).Did });
        }
        ((aga)localObject2).aDZ((String)paramString.get(".dataitem" + ".appid"));
        ((aga)localObject2).aEa((String)paramString.get(".dataitem" + ".link"));
        ((aga)localObject2).aEb((String)paramString.get(".dataitem" + ".brandid"));
        ((afz)localObject1).c((aga)localObject2);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject2 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject2)) {
            break label3132;
          }
          ad.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          ((afz)localObject1).b(com.tencent.mm.plugin.i.a.d.s(".dataitem", paramString));
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
          localafy.a((afz)localObject1);
          paramString = localafy;
          continue;
        }
        localObject2 = new agf();
        if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((agf)localObject2).aEc((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!bt.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((agf)localObject2).aEd((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!bt.isNullOrNil(str)) {
          ((agf)localObject2).B(bt.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!bt.isNullOrNil(str)) {
          ((agf)localObject2).C(bt.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!bt.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((agf)localObject2).VI(bt.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((afz)localObject1).c((agf)localObject2);
          continue;
        }
        ((agf)localObject2).VI(bt.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label3132:
      Object localObject3 = new ahd();
      ((ahd)localObject3).aEy((String)paramString.get((String)localObject2 + ".title"));
      ((ahd)localObject3).aEz((String)paramString.get((String)localObject2 + ".desc"));
      ((ahd)localObject3).aEB((String)paramString.get((String)localObject2 + ".thumburl"));
      ((ahd)localObject3).aEA((String)paramString.get((String)localObject2 + ".link"));
      ((ahd)localObject3).VN(bt.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((afz)localObject1).a((ahd)localObject3);
      continue;
      label3336:
      localObject3 = new agn();
      ((agn)localObject3).aEe((String)paramString.get((String)localObject2 + ".title"));
      ((agn)localObject3).aEf((String)paramString.get((String)localObject2 + ".desc"));
      ((agn)localObject3).aEg((String)paramString.get((String)localObject2 + ".thumburl"));
      ((agn)localObject3).aEh((String)paramString.get((String)localObject2 + ".productinfo"));
      ((agn)localObject3).VJ(bt.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((afz)localObject1).a((agn)localObject3);
      continue;
      label3540:
      localObject3 = new agx();
      ((agx)localObject3).aEu((String)paramString.get((String)localObject2 + ".title"));
      ((agx)localObject3).aEv((String)paramString.get((String)localObject2 + ".desc"));
      ((agx)localObject3).aEw((String)paramString.get((String)localObject2 + ".thumburl"));
      ((agx)localObject3).aEx((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((afz)localObject1).a((agx)localObject3);
      continue;
      label3704:
      localObject3 = new afw();
      ((afw)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((afw)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((afw)localObject3).dkC = bt.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((afw)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((afw)localObject3).type = bt.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((afw)localObject3).dbu = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((afw)localObject3).DfP = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((afw)localObject3).version = bt.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((afw)localObject3).jwB = bt.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((afw)localObject3).cfU = bt.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((afw)localObject3).dzY = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((afw)localObject3).subType = bt.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((afz)localObject1).b((afw)localObject3);
      continue;
      label4168:
      ((afz)localObject1).d(com.tencent.mm.plugin.fav.a.a.b.q((String)localObject2, paramString));
      continue;
      label4183:
      ((afz)localObject1).e(com.tencent.mm.plugin.fav.a.a.b.r((String)localObject2, paramString));
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
  
  private static void a(StringBuilder paramStringBuilder, ago paramago)
  {
    AppMethodBeat.i(9521);
    if (paramago.Csh != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bt.aGf(paramago.Csh.Diw)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bt.aGf(paramago.Csh.Dix)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramago.oJi).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(bt.aGf(paramago.Csh.Dix)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static com.tencent.mm.protocal.b.a.c alt(String paramString)
  {
    AppMethodBeat.i(9541);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)fwL.get(Integer.valueOf(i));
    if (localObject != null)
    {
      ad.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(9541);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = bw.K(paramString, "recordinfo"); localObject == null; localObject = bw.K("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      ad.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(9541);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.Csg = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      agi localagi = new agi();
      localagi.Dix = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localagi.Diw = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.Csh = localagi;
      localc.oJi = bt.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    fwL.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String b(afy paramafy, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramafy == null) || (bt.isNullOrNil(paramafy.dkb)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramafy = ej(XS(paramafy.dkb), paramInt);
    paramafy = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(rQ(paramLong), paramafy).fhU());
    AppMethodBeat.o(9536);
    return paramafy;
  }
  
  public static boolean b(afy paramafy, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramafy == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = h(paramafy.dkb, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(str);
    if (localObject == null)
    {
      com.tencent.mm.plugin.record.a.i locali = new com.tencent.mm.plugin.record.a.i();
      locali.field_cdnKey = paramafy.Dgb;
      locali.field_cdnUrl = paramafy.DfZ;
      locali.field_dataId = paramafy.dkb;
      locali.field_mediaId = str;
      locali.field_totalLen = ((int)paramafy.Dgu);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = a(paramafy, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = gH(paramafy.dataType, (int)paramafy.Dgu);
      locali.field_isThumb = false;
      locali.field_tpaeskey = paramafy.Dho;
      locali.field_tpauthkey = paramafy.gHq;
      locali.field_tpdataurl = paramafy.Dhr;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ad.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
      localObject = locali;
      if (!bt.isNullOrNil(paramafy.Dhb))
      {
        localObject = locali;
        if (paramafy.Dhb.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(locali);
          localObject = locali;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)
      {
        ad.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)
      {
        ad.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          ((com.tencent.mm.plugin.record.a.i)localObject).field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.i)localObject, new String[] { "localId" });
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
  
  public static String c(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramafy = a(paramafy, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramafy;
  }
  
  public static boolean c(afy paramafy, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramafy == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = XS(paramafy.dkb);
    String str2 = h(str1, paramLong, true);
    com.tencent.mm.plugin.record.a.i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(str2);
    if (locali == null)
    {
      locali = new com.tencent.mm.plugin.record.a.i();
      locali.field_cdnKey = paramafy.DfV;
      locali.field_cdnUrl = paramafy.gHu;
      locali.field_dataId = str1;
      locali.field_mediaId = str2;
      locali.field_totalLen = ((int)paramafy.DgF);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = b(paramafy, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      locali.field_isThumb = true;
      locali.field_tpdataurl = paramafy.gHl;
      locali.field_tpauthkey = paramafy.gHq;
      locali.field_tpaeskey = paramafy.gHr;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ad.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
    }
    for (paramafy = locali;; paramafy = locali)
    {
      ad.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramafy });
      if (4 == paramafy.field_status)
      {
        ad.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramafy.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramafy.field_status)
      {
        ad.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramafy.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramafy.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramafy, new String[] { "localId" });
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
  
  public static String cT(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean d(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new com.tencent.mm.vfs.e(a(paramafy, paramLong, 1)).exists();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static boolean e(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new com.tencent.mm.vfs.e(b(paramafy, paramLong, 1)).exists();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  public static String ej(String paramString, int paramInt)
  {
    AppMethodBeat.i(9539);
    if (bt.iY(paramInt, 1))
    {
      AppMethodBeat.o(9539);
      return paramString;
    }
    paramString = paramInt + "_" + paramString;
    AppMethodBeat.o(9539);
    return paramString;
  }
  
  public static String f(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(204816);
    paramafy = b(paramafy, paramLong, 1);
    AppMethodBeat.o(204816);
    return paramafy;
  }
  
  private static boolean f(List<afy> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (afy)paramList.next();
        int i = ((afy)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = alt(((afy)localObject).Dhj);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = f(((com.tencent.mm.protocal.b.a.c)localObject).gKs, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((bt.isNullOrNil(((afy)localObject).DfZ)) && (bt.isNullOrNil(((afy)localObject).gHu)) && (bt.isNullOrNil(((afy)localObject).Dhr)) && (bt.isNullOrNil(((afy)localObject).gHl))) {
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
  
  public static boolean g(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramafy == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramafy = h(paramafy.dkb, paramLong, true);
    paramafy = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().als(paramafy);
    if (paramafy == null)
    {
      ad.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramafy.field_status)
    {
      ad.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramafy.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    ad.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramafy.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  public static int gH(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.fmX;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  public static String h(String paramString, long paramLong, boolean paramBoolean)
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
  
  public static boolean h(afy paramafy, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = t.aFm(a(paramafy, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  private static com.tencent.mm.vfs.e rQ(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = new com.tencent.mm.vfs.e(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.afB().gcW + "record/", Long.valueOf(paramLong) }));
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory())) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void rR(long paramLong)
  {
    AppMethodBeat.i(9531);
    com.tencent.mm.vfs.e locale = rQ(paramLong);
    boolean bool = com.tencent.mm.vfs.i.cO(com.tencent.mm.vfs.q.B(locale.mUri), true);
    ad.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { com.tencent.mm.vfs.q.B(locale.fhU()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
  
  public static String si(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if (localObject == null)
    {
      ad.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((af)localObject).ZX();
    localObject = str;
    if (w.pF(str))
    {
      paramString = com.tencent.mm.model.q.rW(paramString);
      localObject = u.aqG();
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
 * Qualified Name:     com.tencent.mm.plugin.record.b.n
 * JD-Core Version:    0.7.0.1
 */