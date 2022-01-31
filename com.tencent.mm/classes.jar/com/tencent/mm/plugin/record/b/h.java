package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.sl;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.xt;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
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

public final class h
{
  private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> dss = new com.tencent.mm.a.f(32);
  
  public static String Cw(String paramString)
  {
    return paramString + "_t";
  }
  
  public static com.tencent.mm.protocal.b.a.c LH(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.RecordMsgLogic", "xml is null");
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)dss.get(Integer.valueOf(i));
    if (localObject != null)
    {
      y.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = bn.s(paramString, "recordinfo"); localObject == null; localObject = bn.s("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      y.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.srn = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      yd localyd = new yd();
      localyd.sWU = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localyd.sWT = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.sro = localyd;
      localc.srp = bk.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    dss.put(Integer.valueOf(i), localc);
    return localc;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, List<bi> paramList, cj paramcj, com.tencent.mm.protocal.b.a.d paramd)
  {
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      return -1;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      return -1;
    }
    com.tencent.mm.protocal.b.a.d locald;
    if (paramcj != null)
    {
      locald = paramd;
      if (paramd != null) {}
    }
    else
    {
      paramcj = new cj();
      if (!com.tencent.mm.pluginsdk.model.g.a(paramContext, paramcj, paramString2, paramList, true, true)) {
        return -1;
      }
      locald = a(paramContext, paramcj, paramString2);
    }
    paramList = a(locald.title, locald.desc, paramcj.bIw.bIy);
    paramd = new bi();
    paramString2 = null;
    if (!bk.bl(locald.thumbPath))
    {
      paramContext = bk.readFromFile(locald.thumbPath);
      if (paramContext != null) {
        if (paramContext.length <= 32768) {
          break label397;
        }
      }
    }
    long l;
    label397:
    for (paramContext = com.tencent.mm.as.o.OJ().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.as.o.OJ().g(8, paramContext))
    {
      y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + paramContext);
      if (!bk.bl(paramContext)) {
        paramd.ed(paramContext);
      }
      paramd.setContent(g.a.a(paramList, null, null));
      paramd.setStatus(1);
      paramd.ec(paramString1);
      paramd.bg(com.tencent.mm.model.bd.iK(paramString1));
      paramd.fA(1);
      paramd.setType(49);
      if (com.tencent.mm.ai.f.eW(paramString1)) {
        paramd.cY(com.tencent.mm.ai.a.e.HR());
      }
      au.Hx();
      l = com.tencent.mm.model.c.Fy().T(paramd);
      y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label410;
      }
      y.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
      paramContext = paramString2;
      if (locald.bWN != 0) {
        break;
      }
      paramContext = paramString2;
      if (bk.bl(locald.kdm)) {
        break;
      }
      paramContext = com.tencent.mm.sdk.platformtools.c.T(com.tencent.mm.ag.b.a(locald.kdm, false, -1));
      break;
    }
    label410:
    y.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    paramd.setMsgId(l);
    paramContext = new com.tencent.mm.ae.g();
    paramContext.field_xml = paramd.field_content;
    paramContext.field_title = paramList.title;
    paramContext.field_type = paramList.type;
    paramContext.field_description = paramList.description;
    paramContext.field_msgId = l;
    ap.clc().b(paramContext);
    paramContext = paramcj.bIw.bIy.sXc.iterator();
    for (boolean bool = false; paramContext.hasNext(); bool = true)
    {
      label522:
      paramString2 = (xv)paramContext.next();
      if (bk.bl(paramString2.kgC))
      {
        paramd = paramString2.toString();
        int i = paramString2.aYU;
        paramString2.XH(com.tencent.mm.a.g.o((paramd + i + System.currentTimeMillis()).getBytes()));
      }
      if ((!bool) && (!com.tencent.mm.a.e.bK(paramString2.sVe)) && (!com.tencent.mm.a.e.bK(paramString2.sVg)) && (bk.bl(paramString2.sUG)) && (bk.bl(paramString2.dQL)) && (bk.bl(paramString2.sVY)) && (bk.bl(paramString2.dQC))) {
        break label522;
      }
    }
    y.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new com.tencent.mm.plugin.record.a.g();
      paramContext.field_msgId = l;
      paramContext.field_title = paramList.title;
      paramContext.field_desc = paramList.description;
      paramContext.field_toUser = paramString1;
      paramContext.field_dataProto = paramcj.bIw.bIy;
      paramContext.field_type = 3;
      paramContext.field_localId = (new Random().nextInt(2147483645) + 1);
      y.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(n.bvz().b(paramContext)), Long.valueOf(l), Integer.valueOf(paramContext.field_localId) });
      n.bvA().a(paramContext);
    }
    for (;;)
    {
      return 0;
      y.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
      ap.cle();
      ao.a.hd(l);
    }
  }
  
  public static int a(String paramString1, yj paramyj, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      return -1;
    }
    if ((paramyj == null) || (paramyj.sXc.isEmpty()))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramyj);
    bi localbi = new bi();
    paramString2 = null;
    if (!bk.bl(paramString4))
    {
      paramString2 = bk.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 32768) {
          break label330;
        }
      }
    }
    long l;
    label330:
    for (paramString2 = com.tencent.mm.as.o.OJ().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.as.o.OJ().g(8, paramString2))
    {
      y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " thumbData MsgInfo path:" + paramString2);
      if (!bk.bl(paramString2)) {
        localbi.ed(paramString2);
      }
      localbi.setContent(g.a.a(paramString3, null, null));
      localbi.setStatus(1);
      localbi.ec(paramString1);
      localbi.bg(com.tencent.mm.model.bd.iK(paramString1));
      localbi.fA(1);
      localbi.setType(49);
      if (com.tencent.mm.ai.f.eW(paramString1)) {
        localbi.cY(com.tencent.mm.ai.a.e.HR());
      }
      au.Hx();
      l = com.tencent.mm.model.c.Fy().T(localbi);
      y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label343;
      }
      y.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
      return 0 - com.tencent.mm.compatible.util.g.getLine();
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.c.T(com.tencent.mm.sdk.platformtools.c.EX(paramInt));
        break;
      }
      if (bk.bl(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.c.T(com.tencent.mm.ag.b.a(paramString5, false, -1));
      break;
    }
    label343:
    y.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
    localbi.setMsgId(l);
    paramString2 = new com.tencent.mm.ae.g();
    paramString2.field_xml = localbi.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    ap.clc().b(paramString2);
    paramString2 = paramyj.sXc.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (xv)paramString2.next();
    } while ((bk.bl(paramString4.sUG)) && (bk.bl(paramString4.dQL)));
    paramString2 = new com.tencent.mm.plugin.record.a.g();
    paramString2.field_msgId = l;
    paramString2.field_title = paramString3.title;
    paramString2.field_desc = paramString3.description;
    paramString2.field_toUser = paramString1;
    paramString2.field_dataProto = paramyj;
    paramString2.field_type = 1;
    paramString2.field_localId = (new Random().nextInt(2147483645) + 1);
    n.bvz().b(paramString2);
    n.bvA().a(paramString2);
    return 0;
  }
  
  public static int a(String paramString1, String paramString2, bi parambi)
  {
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      return -1;
    }
    if ((parambi == null) || (bk.bl(parambi.field_content)))
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      return -1;
    }
    if (1 == parambi.field_status)
    {
      y.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      return -1;
    }
    paramString1 = bk.G(paramString1.split(",")).iterator();
    String str;
    Object localObject2;
    g.a locala;
    com.tencent.mm.protocal.b.a.c localc;
    Object localObject1;
    long l;
    if (paramString1.hasNext())
    {
      str = (String)paramString1.next();
      y.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.field_status) });
      localObject2 = com.tencent.mm.model.bd.iJ(parambi.field_content);
      locala = g.a.gp((String)localObject2);
      if (locala == null)
      {
        y.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        return -1;
      }
      localc = LH(locala.dRd);
      if (localc == null)
      {
        y.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        return -1;
      }
      localObject1 = new bi();
      if (!bk.bl(parambi.field_imgPath))
      {
        Object localObject3 = bk.readFromFile(com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true));
        localObject3 = com.tencent.mm.as.o.OJ().g(8, (byte[])localObject3);
        y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " thumbData from msg MsgInfo path:" + (String)localObject3);
        if (!bk.bl((String)localObject3)) {
          ((bi)localObject1).ed((String)localObject3);
        }
      }
      ((bi)localObject1).setContent((String)localObject2);
      ((bi)localObject1).setStatus(1);
      ((bi)localObject1).ec(str);
      ((bi)localObject1).bg(com.tencent.mm.model.bd.iK(str));
      ((bi)localObject1).fA(1);
      ((bi)localObject1).setType(49);
      au.Hx();
      l = com.tencent.mm.model.c.Fy().T((bi)localObject1);
      y.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        y.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.zI() + "insert msg failed :" + l);
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      y.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.getLine() + " new msg inserted to db , local id = " + l);
      ((bi)localObject1).setMsgId(l);
      localObject2 = new sl();
      ((sl)localObject2).cbY.cbZ = parambi.field_msgId;
      ((sl)localObject2).cbY.cca = l;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = new com.tencent.mm.ae.g();
      ((com.tencent.mm.ae.g)localObject2).field_xml = ((cs)localObject1).field_content;
      ((com.tencent.mm.ae.g)localObject2).field_title = locala.title;
      ((com.tencent.mm.ae.g)localObject2).field_type = locala.type;
      ((com.tencent.mm.ae.g)localObject2).field_description = locala.description;
      ((com.tencent.mm.ae.g)localObject2).field_msgId = l;
      ap.clc().b((com.tencent.mm.sdk.e.c)localObject2);
      localObject1 = localc.dTx.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (xv)((Iterator)localObject1).next();
      } while ((bk.bl(((xv)localObject2).sUG)) && (bk.bl(((xv)localObject2).dQL)) && (bk.bl(((xv)localObject2).sVY)) && (bk.bl(((xv)localObject2).dQC)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new com.tencent.mm.plugin.record.a.g();
        localObject2 = new yj();
        ((yj)localObject2).sXc.addAll(localc.dTx);
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_msgId = l;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_oriMsgId = parambi.field_msgId;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_toUser = str;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_title = locala.title;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_desc = bk.aM(localc.desc, locala.description);
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_dataProto = ((yj)localObject2);
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_type = 0;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_favFrom = localc.srn;
        ((com.tencent.mm.plugin.record.a.g)localObject1).field_localId = (new Random().nextInt(2147483645) + 1);
        n.bvz().b((com.tencent.mm.sdk.e.c)localObject1);
        n.bvA().a((com.tencent.mm.plugin.record.a.g)localObject1);
      }
      for (;;)
      {
        if (bk.bl(paramString2)) {
          break label831;
        }
        com.tencent.mm.plugin.messenger.a.g.bhI().D(str, paramString2, s.hW(str));
        break;
        y.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ap.cle();
        ao.a.hd(l);
      }
      label831:
      break;
      return 0;
    }
  }
  
  public static g.a a(String paramString1, String paramString2, yj paramyj)
  {
    LinkedList localLinkedList = paramyj.sXc;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bk.ZP(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bk.ZP(paramString2)).append("</desc>");
    a(localStringBuilder, paramyj);
    localStringBuilder.append(i.bo(localLinkedList));
    localStringBuilder.append("<favusername>").append(bk.ZP(q.Gj())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramyj = new g.a();
    paramyj.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramyj.description = paramString1;
    if ((!bk.dk(localLinkedList)) && (!bk.bl(((xv)localLinkedList.get(0)).sUV)) && (((xv)localLinkedList.get(0)).sUV.equals(".htm"))) {
      paramyj.type = 24;
    }
    for (paramyj.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramyj.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramyj.action = "view";
      paramyj.dRd = localStringBuilder.toString();
      return paramyj;
      paramyj.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cj paramcj, String paramString)
  {
    int i = 0;
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.ai.f.eW(paramString))
    {
      locald.title = paramcj.bIw.bIy.title;
      y.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcj.bIw.bIy == null) {
        break label398;
      }
      paramcj = paramcj.bIw.bIy.sXc;
      localObject2 = paramcj.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1465;
      }
      Object localObject3 = (xv)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((xv)localObject3).aYU);
      ((SparseIntArray)localObject1).put(((xv)localObject3).aYU, j + 1);
      switch (((xv)localObject3).aYU)
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
          paramString.add(((xv)localObject3).sVC + ":" + ((xv)localObject3).desc + "\n");
          continue;
          if (s.fn(paramString))
          {
            locald.title = paramContext.getString(R.l.record_chatroom_title);
            break;
          }
          localObject2 = q.Gl();
          paramString = r.gU(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(R.l.favorite_record_chatroom_title, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(R.l.favorite_record_chat_title, new Object[] { localObject2, paramString });
          break;
          paramcj = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_voice) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_pic) + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.g.app_attach_file_icon_pic);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_url) + ((xv)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_webpage);
          i = 1;
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcj = ((xv)localObject3).sVA.sWf;
          localObject3 = new StringBuilder().append(((xv)localObject3).sVC).append(":").append(paramContext.getString(R.l.app_location));
          if ((!bk.bl(paramcj.bVA)) && (!paramcj.bVA.equals(paramContext.getString(R.l.location_selected)))) {
            break label904;
          }
        }
        for (paramcj = paramcj.label;; paramcj = paramcj.bVA)
        {
          paramString.add(paramcj + "\n");
          if (i != 0) {
            break;
          }
          locald.bWN = R.k.app_attach_file_icon_location;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_music) + ((xv)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_music);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_file) + ((xv)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_product) + ((xv)localObject3).sVA.sWj.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_app) + "\n");
        }
        if (i == 0)
        {
          a(locald, (xv)localObject3, R.k.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 16: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_friend_card) + "\n");
        }
        if (i == 0)
        {
          au.Hx();
          locald.kdm = com.tencent.mm.model.c.Fy().HN(((xv)localObject3).desc).pyp;
          i = 1;
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_record) + "\n");
        }
        break;
      case 19: 
        label398:
        if (paramString.size() < 5) {
          paramString.add(((xv)localObject3).sVC + ":" + paramContext.getString(R.l.app_app_brand) + ((xv)localObject3).title + "\n");
        }
        label904:
        break;
      }
    }
    label1465:
    locald.desc = "";
    paramcj = paramString.iterator();
    for (paramContext = ""; paramcj.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcj.next();
    }
    paramcj = paramContext.trim();
    paramContext = paramcj;
    if (paramString.size() >= 5) {
      paramContext = paramcj + "...";
    }
    locald.desc = paramContext;
    return locald;
  }
  
  public static String a(String paramString1, String paramString2, yj paramyj, String paramString3)
  {
    if ((paramyj == null) || (paramyj.sXc == null))
    {
      y.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      return "";
    }
    LinkedList localLinkedList = paramyj.sXc;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bk.ZP(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bk.ZP(paramString2)).append("</desc>");
    a(localStringBuilder, paramyj);
    localStringBuilder.append(i.bo(localLinkedList));
    localStringBuilder.append("<favusername>").append(bk.ZP(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramyj = new g.a();
    paramyj.title = paramString1;
    paramyj.description = paramString2;
    if ((!bk.bl(((xv)localLinkedList.get(0)).sUV)) && (((xv)localLinkedList.get(0)).sUV.equals(".htm"))) {
      paramyj.type = 24;
    }
    for (paramyj.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramyj.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramyj.action = "view";
      paramyj.dRd = localStringBuilder.toString();
      return g.a.a(paramyj, null, null);
      paramyj.type = 19;
    }
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, xv paramxv, int paramInt)
  {
    paramxv = paramxv.sVg;
    if (com.tencent.mm.a.e.bK(paramxv))
    {
      paramd.thumbPath = paramxv;
      return;
    }
    paramd.bWN = paramInt;
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    paramc.dTx.clear();
    paramString = paramString.replaceAll("\\n\\t*", "");
    Object localObject1 = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes())));
        paramString.normalize();
        paramString = paramString.getDocumentElement().getElementsByTagName("datalist");
        if (paramString != null)
        {
          NodeList localNodeList = paramString.item(0).getChildNodes();
          if ((localNodeList != null) && (localNodeList.getLength() > 0))
          {
            int j = localNodeList.getLength();
            i = 0;
            if (i < j)
            {
              localObject1 = localNodeList.item(i);
              paramString = bn.b((Node)localObject1);
              localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
              if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
                break label3600;
              }
              localObject1 = bn.b(((NodeList)localObject1).item(0).getFirstChild());
              if (!paramString.trim().startsWith("<dataitem")) {
                break label3595;
              }
              paramString = bn.s(paramString, "dataitem");
              if (paramString == null) {
                paramString = null;
              }
              try
              {
                paramc.dTx.add(paramString);
              }
              catch (Exception paramString)
              {
                xv localxv;
                String str;
                y.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
                y.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
                paramc.dTx.clear();
              }
              localxv = new xv();
              localxv.EH(bk.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
              localxv.XM((String)paramString.get(".dataitem" + ".$datasourceid"));
              localxv.EI(bk.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
              localxv.XE((String)paramString.get(".dataitem" + ".datafmt"));
              localxv.Xu((String)paramString.get(".dataitem" + ".datatitle"));
              localxv.Xv((String)paramString.get(".dataitem" + ".datadesc"));
              localxv.Xw((String)paramString.get(".dataitem" + ".cdnthumburl"));
              localxv.Xx((String)paramString.get(".dataitem" + ".cdnthumbkey"));
              localxv.EE(bk.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
              localxv.EF(bk.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
              localxv.Xy((String)paramString.get(".dataitem" + ".cdndataurl"));
              localxv.Xz((String)paramString.get(".dataitem" + ".cdndatakey"));
              localxv.dQC = ((String)paramString.get(".dataitem" + ".tpthumburl"));
              localxv.sVU = true;
              localxv.XV((String)paramString.get(".dataitem" + ".tpaeskey"));
              localxv.XW((String)paramString.get(".dataitem" + ".tpauthkey"));
              localxv.XX((String)paramString.get(".dataitem" + ".tpdataurl"));
              localxv.dQI = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
              localxv.sWa = true;
              localObject2 = (String)paramString.get(".dataitem" + ".duration");
              if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
                localxv.EG(bk.getInt((String)localObject2, 0));
              }
              localxv.XB((String)paramString.get(".dataitem" + ".streamdataurl"));
              localxv.XC((String)paramString.get(".dataitem" + ".streamlowbandurl"));
              localxv.XA((String)paramString.get(".dataitem" + ".streamweburl"));
              localxv.XF((String)paramString.get(".dataitem" + ".fullmd5"));
              localxv.XG((String)paramString.get(".dataitem" + ".head256md5"));
              localObject2 = (String)paramString.get(".dataitem" + ".datasize");
              if (!bk.bl((String)localObject2)) {
                localxv.hf(bk.getInt((String)localObject2, 0));
              }
              localxv.XD((String)paramString.get(".dataitem" + ".dataext"));
              localxv.XK((String)paramString.get(".dataitem" + ".thumbfullmd5"));
              localxv.XL((String)paramString.get(".dataitem" + ".thumbhead256md5"));
              localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
              if (!bk.bl((String)localObject2)) {
                localxv.hg(bk.getInt((String)localObject2, 0));
              }
              localxv.XN((String)paramString.get(".dataitem" + ".streamvideoid"));
              localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
              localObject2 = localObject3;
              if (bk.bl((String)localObject3)) {
                localObject2 = String.valueOf(i);
              }
              localxv.XH((String)localObject2);
              localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
              if (!bk.bl((String)localObject2)) {
                localxv.XR((String)localObject2);
              }
              localxv.EJ(bk.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
              localxv.XO((String)paramString.get(".dataitem" + ".sourcetitle"));
              localxv.XP((String)paramString.get(".dataitem" + ".sourcename"));
              localxv.XY((String)paramString.get(".dataitem" + ".sourcedesc"));
              localxv.XQ((String)paramString.get(".dataitem" + ".sourcetime"));
              localxv.XS((String)paramString.get(".dataitem" + ".statextstr"));
              if (localObject1 != null) {
                localxv.XU((String)localObject1);
              }
              localObject1 = new xw();
              localObject2 = new xx();
              ((xx)localObject2).EL(bk.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
              localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
              if (!bk.bl((String)localObject3))
              {
                ((xx)localObject2).XZ((String)localObject3);
                y.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((xx)localObject2).bRO });
              }
              localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
              if (!bk.bl((String)localObject3))
              {
                ((xx)localObject2).Yc((String)localObject3);
                y.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((xx)localObject2).sWB });
              }
              ((xx)localObject2).Ye((String)paramString.get(".dataitem" + ".appid"));
              ((xx)localObject2).Yf((String)paramString.get(".dataitem" + ".link"));
              ((xx)localObject2).Yg((String)paramString.get(".dataitem" + ".brandid"));
              ((xw)localObject1).c((xx)localObject2);
              localObject3 = ".dataitem" + ".locitem";
              if (!paramString.containsKey(localObject3))
              {
                y.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
                localObject2 = ".dataitem" + ".weburlitem";
                if (paramString.containsKey(localObject2)) {
                  break label2750;
                }
                y.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".productitem";
                if (paramString.containsKey(localObject2)) {
                  break label2954;
                }
                y.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".tvitem";
                if (paramString.containsKey(localObject2)) {
                  break label3158;
                }
                y.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
                localObject2 = ".dataitem" + ".appbranditem";
                if (paramString.containsKey(localObject2)) {
                  break label3322;
                }
                y.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject2 });
                localxv.a((xw)localObject1);
                paramString = localxv;
                continue;
              }
              localObject2 = new yc();
              if (!bk.bl((String)paramString.get((String)localObject3 + ".label"))) {
                ((yc)localObject2).Yh((String)paramString.get((String)localObject3 + ".label"));
              }
              if (!bk.bl((String)paramString.get((String)localObject3 + ".poiname"))) {
                ((yc)localObject2).Yi((String)paramString.get((String)localObject3 + ".poiname"));
              }
              str = (String)paramString.get((String)localObject3 + ".lng");
              if (!bk.bl(str)) {
                ((yc)localObject2).y(bk.getDouble(str, 0.0D));
              }
              str = (String)paramString.get((String)localObject3 + ".lat");
              if (!bk.bl(str)) {
                ((yc)localObject2).z(bk.getDouble(str, 0.0D));
              }
              localObject3 = (String)paramString.get((String)localObject3 + ".scale");
              if (!bk.bl((String)localObject3))
              {
                if (((String)localObject3).indexOf('.') == -1) {
                  break label2735;
                }
                ((yc)localObject2).EM(bk.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
              }
              ((xw)localObject1).a((yc)localObject2);
              continue;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
      }
      label2735:
      ((yc)localObject2).EM(bk.getInt((String)localObject3, -1));
      continue;
      label2750:
      Object localObject3 = new yy();
      ((yy)localObject3).YD((String)paramString.get((String)localObject2 + ".title"));
      ((yy)localObject3).YE((String)paramString.get((String)localObject2 + ".desc"));
      ((yy)localObject3).YG((String)paramString.get((String)localObject2 + ".thumburl"));
      ((yy)localObject3).YF((String)paramString.get((String)localObject2 + ".link"));
      ((yy)localObject3).ER(bk.getInt((String)paramString.get((String)localObject2 + ".opencache"), 0));
      ((xw)localObject1).a((yy)localObject3);
      continue;
      label2954:
      localObject3 = new yi();
      ((yi)localObject3).Yj((String)paramString.get((String)localObject2 + ".title"));
      ((yi)localObject3).Yk((String)paramString.get((String)localObject2 + ".desc"));
      ((yi)localObject3).Yl((String)paramString.get((String)localObject2 + ".thumburl"));
      ((yi)localObject3).Ym((String)paramString.get((String)localObject2 + ".productinfo"));
      ((yi)localObject3).EN(bk.getInt((String)paramString.get((String)localObject2 + ".$type"), 0));
      ((xw)localObject1).a((yi)localObject3);
      continue;
      label3158:
      localObject3 = new ys();
      ((ys)localObject3).Yz((String)paramString.get((String)localObject2 + ".title"));
      ((ys)localObject3).YA((String)paramString.get((String)localObject2 + ".desc"));
      ((ys)localObject3).YB((String)paramString.get((String)localObject2 + ".thumburl"));
      ((ys)localObject3).YC((String)paramString.get((String)localObject2 + ".tvinfo"));
      ((xw)localObject1).a((ys)localObject3);
      continue;
      label3322:
      localObject3 = new xt();
      ((xt)localObject3).username = ((String)paramString.get((String)localObject2 + ".username"));
      ((xt)localObject3).appId = ((String)paramString.get((String)localObject2 + ".appid"));
      ((xt)localObject3).bOa = bk.getInt((String)paramString.get((String)localObject2 + ".pkgtype"), 0);
      ((xt)localObject3).iconUrl = ((String)paramString.get((String)localObject2 + ".iconurl"));
      ((xt)localObject3).type = bk.getInt((String)paramString.get((String)localObject2 + ".type"), 0);
      ((xt)localObject3).bFw = ((String)paramString.get((String)localObject2 + ".pagepath"));
      ((xt)localObject3).sUv = ((String)paramString.get((String)localObject2 + ".sourcedisplayname"));
      ((xw)localObject1).a((xt)localObject3);
      continue;
      label3595:
      paramString = null;
      continue;
      label3600:
      localObject1 = null;
      continue;
      i += 1;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, yj paramyj)
  {
    if (paramyj.sro != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(bk.ZP(paramyj.sro.sWT)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(bk.ZP(paramyj.sro.sWU)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramyj.srp).append("</edittime>");
    }
  }
  
  public static boolean b(xv paramxv, long paramLong, boolean paramBoolean)
  {
    if (paramxv == null)
    {
      y.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      return false;
    }
    String str = h(paramxv.kgC, paramLong, true);
    com.tencent.mm.plugin.record.a.f localf2 = n.getRecordMsgCDNStorage().LG(str);
    com.tencent.mm.plugin.record.a.f localf1 = localf2;
    if (localf2 == null)
    {
      localf2 = new com.tencent.mm.plugin.record.a.f();
      localf2.field_cdnKey = paramxv.sUI;
      localf2.field_cdnUrl = paramxv.sUG;
      localf2.field_dataId = paramxv.kgC;
      localf2.field_mediaId = str;
      localf2.field_totalLen = ((int)paramxv.sVb);
      localf2.field_localId = (new Random().nextInt(2147483645) + 1);
      localf2.field_path = c(paramxv, paramLong);
      localf2.field_type = 1;
      localf2.field_fileType = wB(paramxv.aYU);
      localf2.field_isThumb = false;
      localf2.field_tpaeskey = paramxv.sVV;
      localf2.field_tpauthkey = paramxv.dQH;
      localf2.field_tpdataurl = paramxv.sVY;
      boolean bool = n.getRecordMsgCDNStorage().b(localf2);
      y.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localf2.field_localId), Boolean.valueOf(bool) });
      localf1 = localf2;
      if (!bk.bl(paramxv.sVI))
      {
        localf1 = localf2;
        if (paramxv.sVI.equals("WeNoteHtmlFile"))
        {
          n.bvB().a(localf2, true);
          localf1 = localf2;
        }
      }
    }
    y.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localf1 });
    if (4 == localf1.field_status)
    {
      y.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(localf1.field_errCode) });
      return false;
    }
    if (3 == localf1.field_status)
    {
      y.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(localf1.field_errCode), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        localf1.field_status = 1;
        n.getRecordMsgCDNStorage().b(localf1, new String[] { "localId" });
      }
    }
    else
    {
      n.bvB().run();
      return true;
    }
    return false;
  }
  
  public static String c(xv paramxv, long paramLong)
  {
    int j = 1;
    if (paramxv == null) {
      return "";
    }
    Object localObject1 = paramxv.kgC;
    if ((bk.bl((String)localObject1)) || (!au.DK())) {
      return "";
    }
    Object localObject2 = fv(paramLong);
    Object localObject3;
    if ((paramxv.aYU == 8) && (!bk.bl(paramxv.title)))
    {
      localObject3 = paramxv.title;
      i = paramxv.kgC.hashCode();
      au.Hx();
      File localFile = new File(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.model.c.FQ(), Long.valueOf(paramLong), Integer.valueOf(i & 0xFF) }));
      if (localFile.exists())
      {
        i = j;
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
    for (int i = j;; i = 0)
    {
      localObject3 = localObject1;
      if (paramxv.sUV != null)
      {
        localObject3 = localObject1;
        if (paramxv.sUV.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (i == 0) {
            localObject3 = (String)localObject1 + "." + paramxv.sUV;
          }
        }
      }
      return new File((File)localObject2, (String)localObject3).getAbsolutePath();
    }
  }
  
  public static boolean c(xv paramxv, long paramLong, boolean paramBoolean)
  {
    if (paramxv == null)
    {
      y.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      return false;
    }
    String str1 = Cw(paramxv.kgC);
    String str2 = h(str1, paramLong, true);
    com.tencent.mm.plugin.record.a.f localf2 = n.getRecordMsgCDNStorage().LG(str2);
    com.tencent.mm.plugin.record.a.f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new com.tencent.mm.plugin.record.a.f();
      localf1.field_cdnKey = paramxv.sUC;
      localf1.field_cdnUrl = paramxv.dQL;
      localf1.field_dataId = str1;
      localf1.field_mediaId = str2;
      localf1.field_totalLen = ((int)paramxv.sVm);
      localf1.field_localId = (new Random().nextInt(2147483645) + 1);
      localf1.field_path = f(paramxv, paramLong);
      localf1.field_type = 1;
      localf1.field_fileType = com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE;
      localf1.field_isThumb = true;
      localf1.field_tpdataurl = paramxv.dQC;
      localf1.field_tpauthkey = paramxv.dQH;
      localf1.field_tpaeskey = paramxv.dQI;
      boolean bool = n.getRecordMsgCDNStorage().b(localf1);
      y.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localf1.field_localId), Boolean.valueOf(bool) });
    }
    y.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { localf1 });
    if (4 == localf1.field_status)
    {
      y.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(localf1.field_errCode) });
      return false;
    }
    if (3 == localf1.field_status)
    {
      y.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(localf1.field_errCode), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        localf1.field_status = 1;
        n.getRecordMsgCDNStorage().b(localf1, new String[] { "localId" });
      }
    }
    else
    {
      n.bvB().run();
      return true;
    }
    return false;
  }
  
  public static boolean d(xv paramxv, long paramLong)
  {
    return new File(c(paramxv, paramLong)).exists();
  }
  
  public static boolean e(xv paramxv, long paramLong)
  {
    return new File(f(paramxv, paramLong)).exists();
  }
  
  public static String f(xv paramxv, long paramLong)
  {
    if ((paramxv == null) || (bk.bl(paramxv.kgC))) {
      return "";
    }
    paramxv = Cw(paramxv.kgC);
    return new File(fv(paramLong), paramxv).getAbsolutePath();
  }
  
  private static File fv(long paramLong)
  {
    au.Hx();
    File localFile = new File(String.format("%s/%d/", new Object[] { com.tencent.mm.model.c.FQ(), Long.valueOf(paramLong) }));
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static void fw(long paramLong)
  {
    File localFile = fv(paramLong);
    boolean bool = com.tencent.mm.a.e.k(localFile);
    y.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { localFile.getAbsolutePath(), Boolean.valueOf(bool) });
  }
  
  public static boolean g(xv paramxv, long paramLong)
  {
    if (paramxv == null)
    {
      y.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      return true;
    }
    paramxv = h(paramxv.kgC, paramLong, true);
    paramxv = n.getRecordMsgCDNStorage().LG(paramxv);
    if (paramxv == null)
    {
      y.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      return false;
    }
    if (4 == paramxv.field_status)
    {
      y.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramxv.field_errCode) });
      return true;
    }
    y.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramxv.field_status) });
    return false;
  }
  
  public static String gW(String paramString)
  {
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fw().abl(paramString);
    if (localObject == null)
    {
      y.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((ad)localObject).Bq();
      localObject = str;
    } while (!s.fn(str));
    paramString = m.gK(paramString);
    localObject = q.Gj();
    if ((paramString == null) || (paramString.isEmpty()))
    {
      y.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
      return str;
    }
    paramString.remove(localObject);
    paramString.add(0, localObject);
    return m.c(paramString, 3);
  }
  
  public static String h(String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramString + "@record_download@" + paramLong;
    }
    return paramString + "@record_upload@" + paramLong;
  }
  
  public static boolean h(xv paramxv, long paramLong)
  {
    return com.tencent.mm.sdk.platformtools.o.Za(c(paramxv, paramLong));
  }
  
  public static int wB(int paramInt)
  {
    if (2 == paramInt) {
      return com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt) {
      return com.tencent.mm.j.a.MediaType_VIDEO;
    }
    return com.tencent.mm.j.a.MediaType_FILE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */