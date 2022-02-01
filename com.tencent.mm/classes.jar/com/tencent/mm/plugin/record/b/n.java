package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
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
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> fAs;
  
  static
  {
    AppMethodBeat.i(9549);
    fAs = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, List<bo> paramList, cs paramcs, d paramd)
  {
    AppMethodBeat.i(9522);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9522);
      return -1;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9522);
      return -1;
    }
    d locald;
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
    paramList = a(locald.title, locald.desc, paramcs.dck.dcm);
    paramd = new bo();
    paramString2 = null;
    if (!bs.isNullOrNil(locald.thumbPath))
    {
      paramContext = bs.readFromFile(locald.thumbPath);
      if (paramContext != null) {
        if (paramContext.length <= 65536) {
          break label434;
        }
      }
    }
    long l;
    label434:
    for (paramContext = com.tencent.mm.av.o.aFx().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.av.o.aFx().aa(paramContext))
    {
      ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " thumbData MsgInfo path:" + paramContext);
      if (!bs.isNullOrNil(paramContext)) {
        paramd.rf(paramContext);
      }
      paramd.setContent(k.b.a(paramList, null, null));
      paramd.setStatus(1);
      paramd.re(paramString1);
      paramd.oA(bi.yp(paramString1));
      paramd.jT(1);
      paramd.setType(49);
      if (com.tencent.mm.al.f.so(paramString1)) {
        paramd.qf(com.tencent.mm.al.a.e.TG());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(paramd);
      ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label445;
      }
      ac.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
      int i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9522);
      return 0 - i;
      paramContext = paramString2;
      if (locald.dsR != 0) {
        break;
      }
      paramContext = paramString2;
      if (bs.isNullOrNil(locald.qNY)) {
        break;
      }
      paramContext = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.aj.c.a(locald.qNY, false, -1, null));
      break;
    }
    label445:
    ac.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    paramd.setMsgId(l);
    paramContext = new com.tencent.mm.ah.k();
    paramContext.field_xml = paramd.field_content;
    paramContext.field_title = paramList.title;
    paramContext.field_type = paramList.type;
    paramContext.field_description = paramList.description;
    paramContext.field_msgId = l;
    paramContext.field_appId = paramList.appId;
    com.tencent.mm.plugin.s.a.dnz().insert(paramContext);
    paramContext = paramcs.dck.dcm.nxC.iterator();
    for (boolean bool = false; paramContext.hasNext(); bool = true)
    {
      label564:
      paramString2 = (agx)paramContext.next();
      if (bs.isNullOrNil(paramString2.dhw)) {
        paramString2.aIP(cY(paramString2.toString(), paramString2.dataType));
      }
      if ((!bool) && (!com.tencent.mm.vfs.i.eA(paramString2.EzD)) && (!com.tencent.mm.vfs.i.eA(paramString2.EzF)) && (bs.isNullOrNil(paramString2.Ezf)) && (bs.isNullOrNil(paramString2.hhV)) && (bs.isNullOrNil(paramString2.EAx)) && (bs.isNullOrNil(paramString2.hhM))) {
        break label564;
      }
    }
    ac.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new com.tencent.mm.plugin.record.a.j();
      paramContext.field_msgId = l;
      paramContext.field_title = paramList.title;
      paramContext.field_desc = paramList.description;
      paramContext.field_toUser = paramString1;
      paramContext.field_dataProto = paramcs.dck.dcm;
      paramContext.field_type = 3;
      paramContext.field_localId = (new Random().nextInt(2147483645) + 1);
      ac.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramContext)), Long.valueOf(l), Integer.valueOf(paramContext.field_localId) });
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramContext);
    }
    for (;;)
    {
      AppMethodBeat.o(9522);
      return 0;
      ac.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).wq(l);
    }
  }
  
  public static int a(String paramString1, ahn paramahn, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramahn == null) || (paramahn.nxC.isEmpty()))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramahn);
    bo localbo = new bo();
    paramString2 = null;
    if (!bs.isNullOrNil(paramString4))
    {
      paramString2 = bs.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label363;
        }
      }
    }
    long l;
    label363:
    for (paramString2 = com.tencent.mm.av.o.aFx().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.av.o.aFx().aa(paramString2))
    {
      ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " thumbData MsgInfo path:" + paramString2);
      if (!bs.isNullOrNil(paramString2)) {
        localbo.rf(paramString2);
      }
      localbo.setContent(k.b.a(paramString3, null, null));
      localbo.setStatus(1);
      localbo.re(paramString1);
      localbo.oA(bi.yp(paramString1));
      localbo.jT(1);
      localbo.setType(49);
      if (com.tencent.mm.al.f.so(paramString1)) {
        localbo.qf(com.tencent.mm.al.a.e.TG());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(localbo);
      ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label374;
      }
      ac.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9528);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.sdk.platformtools.f.Yo(paramInt));
        break;
      }
      if (bs.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.f.Bitmap2Bytes(com.tencent.mm.aj.c.a(paramString5, false, -1, null));
      break;
    }
    label374:
    ac.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localbo.setMsgId(l);
    paramString2 = new com.tencent.mm.ah.k();
    paramString2.field_xml = localbo.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.s.a.dnz().insert(paramString2);
    paramString2 = paramahn.nxC.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (agx)paramString2.next();
    } while ((bs.isNullOrNil(paramString4.Ezf)) && (bs.isNullOrNil(paramString4.hhV)));
    paramString2 = new com.tencent.mm.plugin.record.a.j();
    paramString2.field_msgId = l;
    paramString2.field_title = paramString3.title;
    paramString2.field_desc = paramString3.description;
    paramString2.field_toUser = paramString1;
    paramString2.field_dataProto = paramahn;
    paramString2.field_type = 1;
    paramString2.field_localId = (new Random().nextInt(2147483645) + 1);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(paramString2);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(paramString2);
    AppMethodBeat.o(9528);
    return 0;
  }
  
  public static int a(String paramString1, String paramString2, bo parambo)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, parambo, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((parambo == null) || (bs.isNullOrNil(parambo.field_content)))
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == parambo.field_status)
    {
      ac.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = bs.S(paramString1.split(",")).iterator();
    label850:
    while (paramString1.hasNext())
    {
      String str = (String)paramString1.next();
      ac.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambo.field_msgId), Integer.valueOf(parambo.field_status) });
      Object localObject2 = bi.ym(parambo.field_content);
      k.b localb = k.b.vA((String)localObject2);
      if (localb == null)
      {
        ac.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      com.tencent.mm.protocal.b.a.c localc = aqs(localb.hij);
      if (localc == null)
      {
        ac.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      Object localObject1 = new bo();
      if (!bs.isNullOrNil(parambo.field_imgPath))
      {
        Object localObject3 = bs.readFromFile(com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true));
        localObject3 = com.tencent.mm.av.o.aFx().aa((byte[])localObject3);
        ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " thumbData from msg MsgInfo path:" + (String)localObject3);
        if (!bs.isNullOrNil((String)localObject3)) {
          ((bo)localObject1).rf((String)localObject3);
        }
      }
      ((bo)localObject1).setContent((String)localObject2);
      ((bo)localObject1).setStatus(1);
      ((bo)localObject1).re(str);
      ((bo)localObject1).oA(bi.yp(str));
      ((bo)localObject1).jT(1);
      ((bo)localObject1).setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap((bo)localObject1);
      ac.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        ac.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.YG() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      ac.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      ((bo)localObject1).setMsgId(l);
      localObject2 = new wn();
      ((wn)localObject2).dzp.dzq = parambo.field_msgId;
      ((wn)localObject2).dzp.dzr = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = new com.tencent.mm.ah.k();
      ((com.tencent.mm.ah.k)localObject2).field_xml = ((dy)localObject1).field_content;
      ((com.tencent.mm.ah.k)localObject2).field_title = localb.title;
      ((com.tencent.mm.ah.k)localObject2).field_type = localb.type;
      ((com.tencent.mm.ah.k)localObject2).field_description = localb.description;
      ((com.tencent.mm.ah.k)localObject2).field_msgId = l;
      ((com.tencent.mm.ah.k)localObject2).field_appId = localb.appId;
      com.tencent.mm.plugin.s.a.dnz().insert((com.tencent.mm.sdk.e.c)localObject2);
      if (f(localc.hkS, paramBoolean))
      {
        localObject1 = new com.tencent.mm.plugin.record.a.j();
        localObject2 = new ahn();
        ((ahn)localObject2).nxC.addAll(localc.hkS);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_msgId = l;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_oriMsgId = parambo.field_msgId;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_toUser = str;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_title = localb.title;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_desc = bs.bG(localc.desc, localb.description);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_dataProto = ((ahn)localObject2);
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_type = 0;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_favFrom = localc.DKy;
        ((com.tencent.mm.plugin.record.a.j)localObject1).field_localId = (new Random().nextInt(2147483645) + 1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert((com.tencent.mm.sdk.e.c)localObject1);
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a((com.tencent.mm.plugin.record.a.j)localObject1, paramBoolean);
      }
      for (;;)
      {
        if (bs.isNullOrNil(paramString2)) {
          break label850;
        }
        com.tencent.mm.plugin.messenger.a.j.dck().X(str, paramString2, w.xt(str));
        break;
        ac.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).wq(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static k.b a(String paramString1, String paramString2, ahn paramahn)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramahn.nxC;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bs.aLw(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bs.aLw(paramString2)).append("</desc>");
    a(localStringBuilder, paramahn);
    localStringBuilder.append(o.dl(localLinkedList));
    localStringBuilder.append("<favusername>").append(bs.aLw(u.axw())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramahn = new k.b();
    paramahn.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramahn.description = paramString1;
    if ((!bs.gY(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((agx)localLinkedList.get(0)))) {
      paramahn.type = 24;
    }
    for (paramahn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramahn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramahn.action = "view";
      paramahn.hij = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramahn;
      paramahn.type = 19;
    }
  }
  
  public static d a(Context paramContext, cs paramcs, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    d locald = new d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.al.f.so(paramString))
    {
      locald.title = paramcs.dck.dcm.title;
      ac.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcs.dck.dcm == null) {
        break label425;
      }
      paramcs = paramcs.dck.dcm.nxC;
      localObject2 = paramcs.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1582;
      }
      Object localObject3 = (agx)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((agx)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((agx)localObject3).dataType, j + 1);
      switch (((agx)localObject3).dataType)
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
          paramString.add(((agx)localObject3).EAb + ":" + ((agx)localObject3).desc + "\n");
          continue;
          if (w.sQ(paramString))
          {
            locald.title = paramContext.getString(2131762236);
            break;
          }
          localObject2 = u.axy();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wj(paramString);
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
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755929) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755853) + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131230944);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755920) + ((agx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 22: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755920) + ((agx)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755926) + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689581);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcs = ((agx)localObject3).EzZ.EAI;
          localObject3 = new StringBuilder().append(((agx)localObject3).EAb).append(":").append(paramContext.getString(2131755806));
          if ((!bs.isNullOrNil(paramcs.dry)) && (!paramcs.dry.equals(paramContext.getString(2131755806)))) {
            break label999;
          }
        }
        for (paramcs = paramcs.label;; paramcs = paramcs.dry)
        {
          paramString.add(paramcs + "\n");
          if (i != 0) {
            break;
          }
          locald.dsR = 2131689562;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755820) + ((agx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689564);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755773) + ((agx)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755858) + ((agx)localObject3).EzZ.EAM.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755278) + "\n");
        }
        if (i == 0)
        {
          a(locald, (agx)localObject3, 2131689577);
          i = 1;
        }
        break;
      case 16: 
        if (localObject3 == null)
        {
          ac.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        }
        else
        {
          if (paramString.size() < 5) {
            paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755782) + "\n");
          }
          if (i == 0)
          {
            locald.qNY = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alw(((agx)localObject3).desc).zTO;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755872) + "\n");
        }
        break;
      case 19: 
        label425:
        label999:
        if (paramString.size() < 5) {
          paramString.add(((agx)localObject3).EAb + ":" + paramContext.getString(2131755279) + ((agx)localObject3).title + "\n");
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
    if ((paramc == null) || (paramc.hkS == null))
    {
      ac.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = bs.bG(paramString, "");
      AppMethodBeat.o(9543);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(bs.aLw(paramc.title)).append("</title>");
    paramString.append("<desc>").append(bs.aLw(paramc.desc)).append("</desc>");
    ahh localahh = paramc.DKz;
    if (localahh != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(bs.aLw(localahh.EBC)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(bs.aLw(localahh.EBD)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(bs.aLw(localahh.EBD)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.pmI).append("</edittime>");
    paramString.append(o.dl(paramc.hkS));
    paramString.append("<favusername>").append(bs.aLw(paramc.DKy)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(agx paramagx, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramagx == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = eq(paramagx.dhw, paramInt);
    if ((bs.isNullOrNil((String)localObject1)) || (!com.tencent.mm.sdk.platformtools.ai.ciE()) || (!com.tencent.mm.kernel.g.agM()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = wt(paramLong);
    Object localObject3;
    if ((paramagx.dataType == 8) && (!bs.isNullOrNil(paramagx.title)))
    {
      localObject3 = paramagx.title;
      paramInt = paramagx.dhw.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.agR().ghC + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
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
      if (paramagx.Ezu != null)
      {
        localObject3 = localObject1;
        if (paramagx.Ezu.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramagx.Ezu;
          }
        }
      }
      paramagx = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((com.tencent.mm.vfs.e)localObject2, (String)localObject3).fxV());
      AppMethodBeat.o(9532);
      return paramagx;
    }
  }
  
  public static String a(String paramString1, String paramString2, ahn paramahn, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramahn == null) || (paramahn.nxC == null))
    {
      ac.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramahn.nxC;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bs.aLw(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bs.aLw(paramString2)).append("</desc>");
    a(localStringBuilder, paramahn);
    localStringBuilder.append(o.dl(localLinkedList));
    localStringBuilder.append("<favusername>").append(bs.aLw(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramahn = new k.b();
    paramahn.title = paramString1;
    paramahn.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((agx)localLinkedList.get(0)))) {
      paramahn.type = 24;
    }
    for (paramahn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramahn.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramahn.action = "view";
      paramahn.hij = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.s.a.dnz().zN(paramLong);
      if (paramString1 != null) {
        paramahn.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramahn, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramahn.type = 19;
    }
  }
  
  private static void a(d paramd, agx paramagx, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramagx = paramagx.EzF;
    if (com.tencent.mm.vfs.i.eA(paramagx))
    {
      paramd.thumbPath = paramagx;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.dsR = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.hkS.clear();
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
        paramString = bv.b((Node)localObject1);
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
        localObject1 = bv.b((Node)localObject2);
        ac.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label4205;
        }
        paramString = bv.L(paramString, "dataitem");
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.aID(paramString.desc.replaceAll("‮", ""));
          }
          paramc.hkS.add(paramString);
        }
        catch (Exception paramString)
        {
          agx localagx;
          String str;
          ac.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          ac.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.hkS.clear();
        }
        localagx = new agx();
        localagx.XM(bs.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localagx.aIU((String)paramString.get(".dataitem" + ".$datasourceid"));
        localagx.XN(bs.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localagx.aIM((String)paramString.get(".dataitem" + ".datafmt"));
        localagx.aIC((String)paramString.get(".dataitem" + ".datatitle"));
        localagx.aID((String)paramString.get(".dataitem" + ".datadesc"));
        localagx.aIE((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localagx.aIF((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localagx.XJ(bs.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localagx.XK(bs.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localagx.aIG((String)paramString.get(".dataitem" + ".cdndataurl"));
        localagx.aIH((String)paramString.get(".dataitem" + ".cdndatakey"));
        localagx.hhM = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localagx.EAt = true;
        localagx.aJd((String)paramString.get(".dataitem" + ".tpaeskey"));
        localagx.aJe((String)paramString.get(".dataitem" + ".tpauthkey"));
        localagx.aJf((String)paramString.get(".dataitem" + ".tpdataurl"));
        localagx.hhS = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localagx.EAz = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localagx.XL(bs.getInt((String)localObject2, 0));
        }
        localagx.aIJ((String)paramString.get(".dataitem" + ".streamdataurl"));
        localagx.aIK((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localagx.aII((String)paramString.get(".dataitem" + ".streamweburl"));
        localagx.aIN((String)paramString.get(".dataitem" + ".fullmd5"));
        localagx.aIO((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!bs.isNullOrNil((String)localObject2)) {
          localagx.zS(bs.getInt((String)localObject2, 0));
        }
        localagx.aIL((String)paramString.get(".dataitem" + ".dataext"));
        localagx.aIS((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localagx.aIT((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!bs.isNullOrNil((String)localObject2)) {
          localagx.zT(bs.getInt((String)localObject2, 0));
        }
        localagx.aIV((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (bs.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localagx.aIP((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!bs.isNullOrNil((String)localObject2)) {
          localagx.aIZ((String)localObject2);
        }
        localagx.XO(bs.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localagx.aIW((String)paramString.get(".dataitem" + ".sourcetitle"));
        localagx.aIX((String)paramString.get(".dataitem" + ".sourcename"));
        localagx.aJg((String)paramString.get(".dataitem" + ".sourcedesc"));
        localagx.aJh((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localagx.aIY((String)paramString.get(".dataitem" + ".sourcetime"));
        localagx.aJa((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localagx.aJc((String)localObject1);
        }
        localagx.aJi((String)paramString.get(".dataitem" + ".songalbumurl"));
        localagx.aJj((String)paramString.get(".dataitem" + ".songlyric"));
        localagx.aJk((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject1 = new agy();
        localObject2 = new agz();
        ((agz)localObject2).XQ(bs.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!bs.isNullOrNil((String)localObject3))
        {
          ((agz)localObject2).aJl((String)localObject3);
          ac.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((agz)localObject2).dng });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!bs.isNullOrNil((String)localObject3))
        {
          ((agz)localObject2).aJo((String)localObject3);
          ac.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((agz)localObject2).EBj });
        }
        ((agz)localObject2).aJq((String)paramString.get(".dataitem" + ".appid"));
        ((agz)localObject2).aJr((String)paramString.get(".dataitem" + ".link"));
        ((agz)localObject2).aJs((String)paramString.get(".dataitem" + ".brandid"));
        ((agy)localObject1).c((agz)localObject2);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          ac.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject2 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject2)) {
            break label3132;
          }
          ac.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          ((agy)localObject1).c(com.tencent.mm.plugin.i.a.e.t(".dataitem", paramString));
          localObject2 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject2)) {
            break label3336;
          }
          ac.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject2)) {
            break label3540;
          }
          ac.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject2)) {
            break label3704;
          }
          ac.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject2)) {
            break label4168;
          }
          ac.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localObject2 = ".dataitem" + ".favbrandmpvideo";
          if (paramString.containsKey(localObject2)) {
            break label4183;
          }
          ac.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
          localagx.a((agy)localObject1);
          paramString = localagx;
          continue;
        }
        localObject2 = new ahe();
        if (!bs.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((ahe)localObject2).aJt((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!bs.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((ahe)localObject2).aJu((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!bs.isNullOrNil(str)) {
          ((ahe)localObject2).A(bs.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!bs.isNullOrNil(str)) {
          ((ahe)localObject2).B(bs.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!bs.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((ahe)localObject2).XR(bs.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((agy)localObject1).c((ahe)localObject2);
          continue;
        }
        ((ahe)localObject2).XR(bs.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label3132:
      Object localObject3 = new aic();
      ((aic)localObject3).aJP((String)paramString.get((String)localObject2 + ".title"));
      ((aic)localObject3).aJQ((String)paramString.get((String)localObject2 + ".desc"));
      ((aic)localObject3).aJS((String)paramString.get((String)localObject2 + ".thumburl"));
      ((aic)localObject3).aJR((String)paramString.get((String)localObject2 + ".link"));
      ((aic)localObject3).XW(bs.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((agy)localObject1).a((aic)localObject3);
      continue;
      label3336:
      localObject3 = new ahm();
      ((ahm)localObject3).aJv((String)paramString.get((String)localObject2 + ".title"));
      ((ahm)localObject3).aJw((String)paramString.get((String)localObject2 + ".desc"));
      ((ahm)localObject3).aJx((String)paramString.get((String)localObject2 + ".thumburl"));
      ((ahm)localObject3).aJy((String)paramString.get((String)localObject2 + ".productinfo"));
      ((ahm)localObject3).XS(bs.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((agy)localObject1).a((ahm)localObject3);
      continue;
      label3540:
      localObject3 = new ahw();
      ((ahw)localObject3).aJL((String)paramString.get((String)localObject2 + ".title"));
      ((ahw)localObject3).aJM((String)paramString.get((String)localObject2 + ".desc"));
      ((ahw)localObject3).aJN((String)paramString.get((String)localObject2 + ".thumburl"));
      ((ahw)localObject3).aJO((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((agy)localObject1).a((ahw)localObject3);
      continue;
      label3704:
      localObject3 = new agv();
      ((agv)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((agv)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((agv)localObject3).dib = bs.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((agv)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((agv)localObject3).type = bs.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((agv)localObject3).cYQ = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((agv)localObject3).EyV = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((agv)localObject3).version = bs.getInt((String)paramString.get((String)localObject2 + ".version"), 0);
      ((agv)localObject3).jWX = bs.getInt((String)paramString.get((String)localObject2 + ".disableforward"), 0);
      ((agv)localObject3).ccR = bs.getInt((String)paramString.get((String)localObject2 + ".tradingguaranteeflag"), 0);
      ((agv)localObject3).dxK = ((String)paramString.get((String)localObject2 + ".messageextradata"));
      ((agv)localObject3).subType = bs.getInt((String)paramString.get((String)localObject2 + ".subtype"), 0);
      ((agy)localObject1).b((agv)localObject3);
      continue;
      label4168:
      ((agy)localObject1).d(com.tencent.mm.plugin.fav.a.a.b.r((String)localObject2, paramString));
      continue;
      label4183:
      ((agy)localObject1).e(com.tencent.mm.plugin.fav.a.a.b.s((String)localObject2, paramString));
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
  
  private static void a(StringBuilder paramStringBuilder, ahn paramahn)
  {
    AppMethodBeat.i(9521);
    if (paramahn.DKz != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bs.aLw(paramahn.DKz.EBC)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bs.aLw(paramahn.DKz.EBD)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramahn.pmI).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(bs.aLw(paramahn.DKz.EBD)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static String aco(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static com.tencent.mm.protocal.b.a.c aqs(String paramString)
  {
    AppMethodBeat.i(9541);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)fAs.get(Integer.valueOf(i));
    if (localObject != null)
    {
      ac.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(9541);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = bv.L(paramString, "recordinfo"); localObject == null; localObject = bv.L("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      ac.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(9541);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.DKy = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      ahh localahh = new ahh();
      localahh.EBD = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localahh.EBC = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.DKz = localahh;
      localc.pmI = bs.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    fAs.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String b(agx paramagx, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramagx == null) || (bs.isNullOrNil(paramagx.dhw)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramagx = eq(aco(paramagx.dhw), paramInt);
    paramagx = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(wt(paramLong), paramagx).fxV());
    AppMethodBeat.o(9536);
    return paramagx;
  }
  
  public static boolean b(agx paramagx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramagx == null)
    {
      ac.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = h(paramagx.dhw, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(str);
    if (localObject == null)
    {
      com.tencent.mm.plugin.record.a.i locali = new com.tencent.mm.plugin.record.a.i();
      locali.field_cdnKey = paramagx.Ezh;
      locali.field_cdnUrl = paramagx.Ezf;
      locali.field_dataId = paramagx.dhw;
      locali.field_mediaId = str;
      locali.field_totalLen = ((int)paramagx.EzA);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = a(paramagx, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = gO(paramagx.dataType, (int)paramagx.EzA);
      locali.field_isThumb = false;
      locali.field_tpaeskey = paramagx.EAu;
      locali.field_tpauthkey = paramagx.hhR;
      locali.field_tpdataurl = paramagx.EAx;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ac.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
      localObject = locali;
      if (!bs.isNullOrNil(paramagx.EAh))
      {
        localObject = locali;
        if (paramagx.EAh.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(locali);
          localObject = locali;
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)
      {
        ac.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)
      {
        ac.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.i)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
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
  
  public static String c(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramagx = a(paramagx, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramagx;
  }
  
  public static boolean c(agx paramagx, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramagx == null)
    {
      ac.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = aco(paramagx.dhw);
    String str2 = h(str1, paramLong, true);
    com.tencent.mm.plugin.record.a.i locali = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(str2);
    if (locali == null)
    {
      locali = new com.tencent.mm.plugin.record.a.i();
      locali.field_cdnKey = paramagx.Ezb;
      locali.field_cdnUrl = paramagx.hhV;
      locali.field_dataId = str1;
      locali.field_mediaId = str2;
      locali.field_totalLen = ((int)paramagx.EzL);
      locali.field_localId = (new Random().nextInt(2147483645) + 1);
      locali.field_path = b(paramagx, paramLong, 1);
      locali.field_type = 1;
      locali.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      locali.field_isThumb = true;
      locali.field_tpdataurl = paramagx.hhM;
      locali.field_tpauthkey = paramagx.hhR;
      locali.field_tpaeskey = paramagx.hhS;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(locali);
      ac.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(locali.field_localId), Boolean.valueOf(bool) });
    }
    for (paramagx = locali;; paramagx = locali)
    {
      ac.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramagx });
      if (4 == paramagx.field_status)
      {
        ac.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramagx.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramagx.field_status)
      {
        ac.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramagx.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramagx.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramagx, new String[] { "localId" });
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
  
  public static String cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean d(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new com.tencent.mm.vfs.e(a(paramagx, paramLong, 1)).exists();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static boolean e(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new com.tencent.mm.vfs.e(b(paramagx, paramLong, 1)).exists();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  public static String eq(String paramString, int paramInt)
  {
    AppMethodBeat.i(9539);
    if (bs.jl(paramInt, 1))
    {
      AppMethodBeat.o(9539);
      return paramString;
    }
    paramString = paramInt + "_" + paramString;
    AppMethodBeat.o(9539);
    return paramString;
  }
  
  public static String f(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(210013);
    paramagx = b(paramagx, paramLong, 1);
    AppMethodBeat.o(210013);
    return paramagx;
  }
  
  private static boolean f(List<agx> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (agx)paramList.next();
        int i = ((agx)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = aqs(((agx)localObject).EAp);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = f(((com.tencent.mm.protocal.b.a.c)localObject).hkS, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((bs.isNullOrNil(((agx)localObject).Ezf)) && (bs.isNullOrNil(((agx)localObject).hhV)) && (bs.isNullOrNil(((agx)localObject).EAx)) && (bs.isNullOrNil(((agx)localObject).hhM))) {
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
  
  public static boolean g(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramagx == null)
    {
      ac.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramagx = h(paramagx.dhw, paramLong, true);
    paramagx = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(paramagx);
    if (paramagx == null)
    {
      ac.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramagx.field_status)
    {
      ac.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramagx.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    ac.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramagx.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  public static int gO(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.fqr;
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
  
  public static boolean h(agx paramagx, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = s.aKD(a(paramagx, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static String wl(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if (localObject == null)
    {
      ac.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((com.tencent.mm.storage.ai)localObject).aaS();
    localObject = str;
    if (w.sQ(str))
    {
      paramString = com.tencent.mm.model.q.vZ(paramString);
      localObject = u.axw();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label110;
      }
      ac.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
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
  
  private static com.tencent.mm.vfs.e wt(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = new com.tencent.mm.vfs.e(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.agR().ghC + "record/", Long.valueOf(paramLong) }));
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) || (!((com.tencent.mm.vfs.e)localObject).isDirectory())) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void wu(long paramLong)
  {
    AppMethodBeat.i(9531);
    com.tencent.mm.vfs.e locale = wt(paramLong);
    boolean bool = com.tencent.mm.vfs.i.cU(com.tencent.mm.vfs.q.B(locale.mUri), true);
    ac.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { com.tencent.mm.vfs.q.B(locale.fxV()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.n
 * JD-Core Version:    0.7.0.1
 */