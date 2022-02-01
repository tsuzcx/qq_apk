package com.tencent.mm.plugin.record.model;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abo;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.tq;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
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

public final class q
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> lNS;
  
  static
  {
    AppMethodBeat.i(9549);
    lNS = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static String IE(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((au)localObject).aSV();
    localObject = str;
    if (au.bwE(str))
    {
      paramString = v.Il(paramString);
      localObject = z.bAM();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label107;
      }
      Log.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = v.a(paramString, 3, str))
    {
      AppMethodBeat.o(9547);
      return localObject;
      label107:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static int a(final String paramString1, final arv paramarv, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramarv == null) || (paramarv.vEn.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramarv);
    final cc localcc = new cc();
    paramString2 = null;
    if (!Util.isNullOrNil(paramString4))
    {
      paramString2 = Util.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label362;
        }
      }
    }
    long l;
    label362:
    for (paramString2 = com.tencent.mm.modelimage.r.bKa().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.modelimage.r.bKa().aA(paramString2))
    {
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " thumbData MsgInfo path:" + paramString2);
      if (!Util.isNullOrNil(paramString2)) {
        localcc.BT(paramString2);
      }
      localcc.setContent(k.b.a(paramString3, null, null));
      localcc.setStatus(1);
      localcc.BS(paramString1);
      localcc.setCreateTime(br.JN(paramString1));
      localcc.pI(1);
      localcc.setType(49);
      if (com.tencent.mm.an.g.Dn(paramString1)) {
        localcc.AU(com.tencent.mm.an.a.e.bCQ());
      }
      l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label373;
      }
      Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(9528);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = BitmapUtil.Bitmap2Bytes(BitmapUtil.getBitmapNative(paramInt));
        break;
      }
      if (Util.isNullOrNil(paramString5)) {
        break;
      }
      paramString2 = BitmapUtil.Bitmap2Bytes(com.tencent.mm.modelavatar.d.a(paramString5, false, -1, null));
      break;
    }
    label373:
    Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localcc.setMsgId(l);
    paramString2 = new com.tencent.mm.message.k();
    paramString2.field_xml = localcc.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.openapi.a.gxo().insert(paramString2);
    paramString2 = paramarv.vEn.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (arf)paramString2.next();
    } while ((Util.isNullOrNil(paramString4.Ysw)) && (Util.isNullOrNil(paramString4.nRr)));
    paramString2 = b(paramString1, paramarv);
    if (paramString2.size() > 0) {
      com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.pluginsdk.h.a(paramString2, new com.tencent.mm.pluginsdk.h.a.a()
      {
        public final void cy(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(305342);
          if (paramAnonymousInt == 0)
          {
            q.d(this.hkO, paramString1.getTitle(), paramString1.getDescription(), paramarv, localcc);
            AppMethodBeat.o(305342);
            return;
          }
          if (-3200 == paramAnonymousInt)
          {
            Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.hkO), paramarv });
            q.c(this.hkO, this.oiL);
            q.b(this.hkO, this.oiL, paramarv);
            ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.f.class)).Z(this.hkO, paramarv);
            AppMethodBeat.o(305342);
            return;
          }
          this.oiL.setStatus(5);
          ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hkO, this.oiL);
          q.eD(paramarv, paramAnonymousString);
          AppMethodBeat.o(305342);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(9528);
      return 0;
      b(l, paramString3.getTitle(), paramString3.getDescription(), paramString1, paramarv);
    }
  }
  
  public static int a(String paramString1, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, paramcc, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, cc paramcc, final boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((paramcc == null) || (Util.isNullOrNil(paramcc.field_content)))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == paramcc.field_status)
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = Util.stringsToList(paramString1.split(",")).iterator();
    label795:
    while (paramString1.hasNext())
    {
      final String str = (String)paramString1.next();
      Log.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramcc.field_status) });
      Object localObject1 = br.JK(paramcc.field_content);
      final k.b localb = k.b.Hf((String)localObject1);
      if (localb == null)
      {
        Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final com.tencent.mm.protocal.b.a.c localc = aSH(localb.nRF);
      if (localc == null)
      {
        Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final cc localcc = new cc();
      Object localObject2;
      if (!Util.isNullOrNil(paramcc.field_imgPath))
      {
        localObject2 = Util.readFromFile(com.tencent.mm.modelimage.r.bKa().X(paramcc.field_imgPath, true));
        localObject2 = com.tencent.mm.modelimage.r.bKa().aA((byte[])localObject2);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " thumbData from msg MsgInfo path:" + (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          localcc.BT((String)localObject2);
        }
      }
      localcc.setContent((String)localObject1);
      localcc.AU(bt.JW(bt.JV(paramcc.jUr)));
      localcc.setStatus(1);
      localcc.BS(str);
      localcc.setCreateTime(br.JN(str));
      localcc.pI(1);
      localcc.setType(49);
      long l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localcc.setMsgId(l);
      localObject1 = new abo();
      ((abo)localObject1).ifb.ifc = paramcc.field_msgId;
      ((abo)localObject1).ifb.ifd = l;
      ((abo)localObject1).publish();
      localObject1 = new com.tencent.mm.message.k();
      ((com.tencent.mm.message.k)localObject1).field_xml = localcc.field_content;
      ((com.tencent.mm.message.k)localObject1).field_title = localb.title;
      ((com.tencent.mm.message.k)localObject1).field_type = localb.type;
      ((com.tencent.mm.message.k)localObject1).field_description = localb.description;
      ((com.tencent.mm.message.k)localObject1).field_msgId = l;
      ((com.tencent.mm.message.k)localObject1).field_appId = localb.appId;
      com.tencent.mm.plugin.openapi.a.gxo().insert((IAutoDBItem)localObject1);
      if (z(localc.nUC, paramBoolean))
      {
        localObject1 = new arv();
        ((arv)localObject1).vEn.addAll(localc.nUC);
        localObject2 = b(str, (arv)localObject1);
        if (((List)localObject2).size() > 0) {
          com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.pluginsdk.h.a((List)localObject2, new com.tencent.mm.pluginsdk.h.a.a()
          {
            public final void cy(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(305340);
              if (paramAnonymousInt == 0)
              {
                q.b(this.hkO, str.field_msgId, localb, localc, this.NAM, paramBoolean, localcc);
                AppMethodBeat.o(305340);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.hkO), localb });
                q.c(this.hkO, this.oiL);
                q.a(this.hkO, str.field_msgId, this.oiL, localb, localcc);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.f.class)).Z(this.hkO, localb);
                AppMethodBeat.o(305340);
                return;
              }
              this.oiL.setStatus(5);
              ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hkO, this.oiL);
              q.eD(localb, paramAnonymousString);
              AppMethodBeat.o(305340);
            }
          }), 0);
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramString2)) {
          break label795;
        }
        com.tencent.mm.plugin.messenger.a.g.gaI().ap(str, paramString2, ab.IX(str));
        break;
        a(l, paramcc.field_msgId, str, localb, localc, (arv)localObject1, paramBoolean);
        continue;
        Log.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.g.class)).tm(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static Pair<Long, Boolean> a(Context paramContext, final String paramString1, final String paramString2, List<cc> paramList, dn paramdn, com.tencent.mm.protocal.b.a.d paramd, String paramString3)
  {
    AppMethodBeat.i(305422);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(305422);
      return paramContext;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(305422);
      return paramContext;
    }
    if ((paramdn == null) || (paramd == null))
    {
      paramdn = new dn();
      if (!c.a(paramContext, paramdn, paramString2, paramList, -1))
      {
        paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
        AppMethodBeat.o(305422);
        return paramContext;
      }
      paramd = a(paramContext, paramdn, paramString2);
    }
    for (paramString2 = paramdn;; paramString2 = paramdn)
    {
      paramdn = a(paramd.title, paramd.desc, paramString2.hDr.hDt);
      final cc localcc = new cc();
      paramList = null;
      if (!Util.isNullOrNil(paramd.thumbPath))
      {
        paramContext = Util.readFromFile(paramd.thumbPath);
        if (paramContext != null) {
          if (paramContext.length <= 65536) {
            break label499;
          }
        }
      }
      long l;
      label499:
      for (paramContext = com.tencent.mm.modelimage.r.bKa().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.modelimage.r.bKa().aA(paramContext))
      {
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " thumbData MsgInfo path:" + paramContext);
        if (!Util.isNullOrNil(paramContext)) {
          localcc.BT(paramContext);
        }
        localcc.setContent(k.b.a(paramdn, null, null));
        localcc.setStatus(1);
        localcc.BS(paramString1);
        localcc.setCreateTime(br.JN(paramString1));
        localcc.pI(1);
        localcc.setType(49);
        if (com.tencent.mm.an.g.Dn(paramString1)) {
          localcc.AU(com.tencent.mm.an.a.e.bCQ());
        }
        l = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba(localcc);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label510;
        }
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.aPX() + "insert msg failed :" + l);
        paramContext = new Pair(Long.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Boolean.FALSE);
        AppMethodBeat.o(305422);
        return paramContext;
        paramContext = paramList;
        if (paramd.hXx != 0) {
          break;
        }
        paramContext = paramList;
        if (Util.isNullOrNil(paramd.AiA)) {
          break;
        }
        paramContext = BitmapUtil.Bitmap2Bytes(com.tencent.mm.modelavatar.d.a(paramd.AiA, false, -1, null));
        break;
      }
      label510:
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localcc.setMsgId(l);
      paramContext = new com.tencent.mm.message.k();
      paramContext.field_xml = localcc.field_content;
      paramContext.field_title = paramdn.title;
      paramContext.field_type = paramdn.type;
      paramContext.field_description = paramdn.description;
      paramContext.field_msgId = l;
      paramContext.field_appId = paramdn.appId;
      com.tencent.mm.plugin.openapi.a.gxo().insert(paramContext);
      paramContext = paramString2.hDr.hDt.vEn.iterator();
      for (boolean bool = false; paramContext.hasNext(); bool = true)
      {
        label633:
        paramList = (arf)paramContext.next();
        if (Util.isNullOrNil(paramList.hIQ)) {
          paramList.bsB(er(paramList.toString(), paramList.dataType));
        }
        if ((!bool) && (!y.ZC(paramList.Zzd)) && (!y.ZC(paramList.Zzf)) && (Util.isNullOrNil(paramList.Ysw)) && (Util.isNullOrNil(paramList.nRr)) && (Util.isNullOrNil(paramList.ZzW)) && (Util.isNullOrNil(paramList.nRi))) {
          break label633;
        }
      }
      Log.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        if ((!ab.IO(paramString1)) || (Util.isNullOrNil(paramString3))) {
          break label954;
        }
      }
      for (;;)
      {
        paramContext = b(paramString3, paramString2.hDr.hDt);
        if (paramContext.size() > 0)
        {
          com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.pluginsdk.h.a(paramContext, new com.tencent.mm.pluginsdk.h.a.a()
          {
            public final void cy(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(305328);
              if (paramAnonymousInt == 0)
              {
                q.c(this.hkO, paramString1.getTitle(), paramString1.getDescription(), paramString2, localcc.hDr.hDt);
                AppMethodBeat.o(305328);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                q.c(this.hkO, this.oiL);
                q.a(this.hkO, this.oiL, paramString2);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.f.class)).Z(this.hkO, paramString2);
                AppMethodBeat.o(305328);
                return;
              }
              this.oiL.setStatus(5);
              ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hkO, this.oiL);
              if (!q.a(paramString2, this.hkO, false, paramAnonymousString)) {
                q.eD(paramString2, paramAnonymousString);
              }
              AppMethodBeat.o(305328);
            }
          }), 0);
          if (bool) {
            break label948;
          }
        }
        label948:
        for (bool = true;; bool = false)
        {
          paramContext = new Pair(Long.valueOf(l), Boolean.valueOf(bool));
          AppMethodBeat.o(305422);
          return paramContext;
          a(l, paramdn.getTitle(), paramdn.getDescription(), paramString1, paramString2.hDr.hDt);
          break;
          Log.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
          if (ab.IO(paramString1)) {
            break;
          }
          ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.g.class)).tm(l);
          break;
        }
        label954:
        paramString3 = paramString1;
      }
    }
  }
  
  public static k.b a(String paramString1, String paramString2, arv paramarv)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramarv.vEn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramarv);
    localStringBuilder.append(r.fF(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(z.bAM())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramarv = new k.b();
    paramarv.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramarv.description = paramString1;
    if ((!Util.isNullOrNil(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((arf)localLinkedList.get(0)))) {
      paramarv.type = 24;
    }
    for (paramarv.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramarv.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramarv.action = "view";
      paramarv.nRF = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramarv;
      paramarv.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, dn paramdn, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.an.g.Dn(paramString))
    {
      locald.title = paramdn.hDr.hDt.title;
      Log.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramdn.hDr.hDt == null) {
        break label461;
      }
      paramdn = paramdn.hDr.hDt.vEn;
      localObject2 = paramdn.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1694;
      }
      Object localObject3 = (arf)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((arf)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((arf)localObject3).dataType, j + 1);
      switch (((arf)localObject3).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 20: 
      case 21: 
      case 24: 
      case 25: 
      default: 
        break;
      case 1: 
        if (paramString.size() < 5)
        {
          paramString.add(((arf)localObject3).ZzA + ":" + ((arf)localObject3).desc + "\n");
          continue;
          if (au.bwE(paramString))
          {
            locald.title = paramContext.getString(a.c.record_chatroom_title);
            break;
          }
          localObject2 = z.bAO();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).ID(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(a.c.favorite_record_chatroom_title, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(a.c.favorite_record_chat_title, new Object[] { localObject2, paramString });
          break;
          paramdn = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_voice) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_pic) + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.a.app_attach_file_icon_pic);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_url) + ((arf)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_webpage);
          i = 1;
        }
        break;
      case 22: 
      case 23: 
      case 26: 
      case 27: 
      case 28: 
      case 30: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_url) + ((arf)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramdn = ((arf)localObject3).Zzy.ZAh;
          localObject3 = new StringBuilder().append(((arf)localObject3).ZzA).append(":").append(paramContext.getString(a.c.app_location));
          if ((!Util.isNullOrNil(paramdn.hVI)) && (!paramdn.hVI.equals(paramContext.getString(a.c.app_location)))) {
            break label1035;
          }
        }
        for (paramdn = paramdn.label;; paramdn = paramdn.hVI)
        {
          paramString.add(paramdn + "\n");
          if (i != 0) {
            break;
          }
          locald.hXx = com.tencent.mm.plugin.record.a.b.app_attach_file_icon_location;
          i = 1;
          break;
        }
      case 7: 
      case 29: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_music) + ((arf)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_music);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_file) + ((arf)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_product) + ((arf)localObject3).Zzy.ZAl.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_app) + "\n");
        }
        if (i == 0)
        {
          a(locald, (arf)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 16: 
        if (localObject3 == null)
        {
          Log.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        }
        else
        {
          if (paramString.size() < 5) {
            paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_friend_card) + "\n");
          }
          if (i == 0)
          {
            locald.AiA = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(((arf)localObject3).desc).hgk;
            i = 1;
          }
        }
        break;
      case 31: 
        if (localObject3 == null) {
          Log.e("MicroMsg.RecordMsgLogic", "favDataItem is null!");
        } else if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_friend_card_kefu) + "\n");
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_record) + "\n");
        }
        break;
      case 19: 
        label461:
        if (paramString.size() < 5) {
          paramString.add(((arf)localObject3).ZzA + ":" + paramContext.getString(a.c.app_app_brand) + ((arf)localObject3).title + "\n");
        }
        label1035:
        break;
      }
    }
    label1694:
    locald.desc = "";
    paramdn = paramString.iterator();
    for (paramContext = ""; paramdn.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramdn.next();
    }
    paramdn = paramContext.trim();
    paramContext = paramdn;
    if (paramString.size() >= 5) {
      paramContext = paramdn + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.nUC == null))
    {
      Log.e("MicroMsg.RecordMsgLogic", "buildRecordInfoXML error: msgData or msgData.items is null");
      paramc = Util.nullAs(paramString, "");
      AppMethodBeat.o(9543);
      return paramc;
    }
    paramString = new StringBuilder();
    paramString.append("<recordinfo>");
    paramString.append("<title>").append(Util.escapeStringForXml(paramc.title)).append("</title>");
    paramString.append("<desc>").append(Util.escapeStringForXml(paramc.desc)).append("</desc>");
    arp localarp = paramc.YzK;
    if (localarp != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(Util.escapeStringForXml(localarp.ZBm)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(Util.escapeStringForXml(localarp.ZBn)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(Util.escapeStringForXml(localarp.ZBn)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.ygh).append("</edittime>");
    paramString.append(r.fF(paramc.nUC));
    paramString.append("<favusername>").append(Util.escapeStringForXml(paramc.NAa)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(arf paramarf, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramarf == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = gD(paramarf.hIQ, paramInt);
    if ((Util.isNullOrNil((String)localObject1)) || (!MMApplicationContext.isMMProcess()) || (!com.tencent.mm.kernel.h.baz()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = tp(paramLong);
    Object localObject3;
    if ((paramarf.dataType == 8) && (!Util.isNullOrNil(paramarf.title)))
    {
      localObject3 = paramarf.title;
      paramInt = paramarf.hIQ.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.baF();
      u localu = new u(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.h.baE().mCJ + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (localu.jKS())
      {
        paramInt = i;
        localObject2 = localu;
        localObject1 = localObject3;
        if (localu.isDirectory()) {}
      }
      else
      {
        localu.jKY();
        localObject1 = localObject3;
        localObject2 = localu;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramarf.ZyU != null)
      {
        localObject3 = localObject1;
        if (paramarf.ZyU.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramarf.ZyU;
          }
        }
      }
      paramarf = ah.v(new u((u)localObject2, (String)localObject3).jKT());
      AppMethodBeat.o(9532);
      return paramarf;
    }
  }
  
  public static String a(String paramString1, String paramString2, arv paramarv, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramarv == null) || (paramarv.vEn == null))
    {
      Log.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramarv.vEn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramarv);
    localStringBuilder.append(r.fF(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramarv = new k.b();
    paramarv.title = paramString1;
    paramarv.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((arf)localLinkedList.get(0)))) {
      paramarv.type = 24;
    }
    for (paramarv.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramarv.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramarv.action = "view";
      paramarv.nRF = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.openapi.a.gxo().rI(paramLong);
      if (paramString1 != null) {
        paramarv.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramarv, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramarv.type = 19;
    }
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString, k.b paramb, com.tencent.mm.protocal.b.a.c paramc, arv paramarv, boolean paramBoolean)
  {
    AppMethodBeat.i(305384);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong1;
    localk.field_oriMsgId = paramLong2;
    localk.field_toUser = paramString;
    localk.field_title = paramb.title;
    localk.field_desc = Util.nullAs(paramc.desc, paramb.description);
    localk.field_dataProto = paramarv;
    localk.field_type = 0;
    localk.field_favFrom = paramc.NAa;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk, paramBoolean);
    AppMethodBeat.o(305384);
  }
  
  private static void a(long paramLong, String paramString1, String paramString2, String paramString3, arv paramarv)
  {
    AppMethodBeat.i(305376);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramarv;
    localk.field_type = 3;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(305376);
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, arf paramarf, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramarf = paramarf.Zzf;
    if (y.ZC(paramarf))
    {
      paramd.thumbPath = paramarf;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.hXx = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.nUC.clear();
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
          break label5218;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label5218;
        }
        int k = localNodeList.getLength();
        i = 0;
        if (i >= k) {
          break label5218;
        }
        localObject1 = localNodeList.item(i);
        paramString = XmlParser.nodeToString((Node)localObject1);
        if (!(localObject1 instanceof Element)) {
          break label5236;
        }
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label5230;
        }
        localObject1 = ((NodeList)localObject1).item(0).getChildNodes();
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label5230;
        }
        int m = ((NodeList)localObject1).getLength();
        j = 0;
        if (j >= m) {
          break label5230;
        }
        localObject2 = ((NodeList)localObject1).item(j);
        if (!(localObject2 instanceof Element)) {
          break label5243;
        }
        localObject1 = XmlParser.nodeToString((Node)localObject2);
        Log.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label5225;
        }
        paramString = XmlParser.parseXml(paramString, "dataitem", null);
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.bsp(paramString.desc.replaceAll("‮", ""));
          }
          paramc.nUC.add(paramString);
        }
        catch (Exception paramString)
        {
          arf localarf;
          String str;
          Object localObject6;
          Object localObject5;
          Object localObject4;
          LinkedList localLinkedList;
          Log.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          Log.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.nUC.clear();
        }
        localarf = new arf();
        localarf.axy(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localarf.bsG((String)paramString.get(".dataitem" + ".$datasourceid"));
        localarf.axz(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localarf.bsy((String)paramString.get(".dataitem" + ".datafmt"));
        localarf.bso((String)paramString.get(".dataitem" + ".datatitle"));
        localarf.bsp((String)paramString.get(".dataitem" + ".datadesc"));
        localarf.bsq((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localarf.bsr((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localarf.axv(Util.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localarf.axw(Util.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localarf.bss((String)paramString.get(".dataitem" + ".cdndataurl"));
        localarf.bst((String)paramString.get(".dataitem" + ".cdndatakey"));
        localarf.nRi = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localarf.ZzS = true;
        localarf.bsP((String)paramString.get(".dataitem" + ".tpaeskey"));
        localarf.bsQ((String)paramString.get(".dataitem" + ".tpauthkey"));
        localarf.bsR((String)paramString.get(".dataitem" + ".tpdataurl"));
        localarf.nRo = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localarf.ZzY = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localarf.axx(Util.getInt((String)localObject2, 0));
        }
        localarf.bsv((String)paramString.get(".dataitem" + ".streamdataurl"));
        localarf.bsw((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localarf.bsu((String)paramString.get(".dataitem" + ".streamweburl"));
        localarf.bsz((String)paramString.get(".dataitem" + ".fullmd5"));
        localarf.bsA((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localarf.yo(Util.getInt((String)localObject2, 0));
        }
        localarf.bsx((String)paramString.get(".dataitem" + ".dataext"));
        localarf.bsE((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localarf.bsF((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localarf.yp(Util.getInt((String)localObject2, 0));
        }
        localarf.bsH((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localarf.bsB((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!Util.isNullOrNil((String)localObject2)) {
          localarf.bsL((String)localObject2);
        }
        localarf.axA(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localarf.bsI((String)paramString.get(".dataitem" + ".sourcetitle"));
        localarf.bsJ((String)paramString.get(".dataitem" + ".sourcename"));
        localarf.bsS((String)paramString.get(".dataitem" + ".sourcedesc"));
        localarf.bsT((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localarf.bsK((String)paramString.get(".dataitem" + ".sourcetime"));
        localarf.bsM((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localarf.bsO((String)localObject1);
        }
        localarf.bsU((String)paramString.get(".dataitem" + ".songalbumurl"));
        localarf.bsV((String)paramString.get(".dataitem" + ".songlyric"));
        localarf.bsW((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject2 = new arg();
        localObject1 = new arh();
        ((arh)localObject1).axC(Util.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((arh)localObject1).bsX((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((arh)localObject1).hQQ });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((arh)localObject1).bta((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((arh)localObject1).ZAT });
        }
        ((arh)localObject1).btc((String)paramString.get(".dataitem" + ".appid"));
        ((arh)localObject1).btd((String)paramString.get(".dataitem" + ".link"));
        ((arh)localObject1).bte((String)paramString.get(".dataitem" + ".brandid"));
        ((arg)localObject2).c((arh)localObject1);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject1 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject1)) {
            break label4045;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          ((arg)localObject2).g(com.tencent.mm.plugin.findersdk.a.q.C(".dataitem", paramString));
          ((arg)localObject2).g(com.tencent.mm.plugin.findersdk.a.q.z(".dataitem", paramString));
          ((arg)localObject2).d(com.tencent.mm.plugin.findersdk.a.q.G(".dataitem", paramString));
          ((arg)localObject2).c(com.tencent.mm.plugin.findersdk.a.q.G(".dataitem", paramString));
          localObject1 = new bvk();
          localObject3 = ".dataitem" + ".finderShareNameCard";
          if (paramString.isEmpty()) {
            break label4289;
          }
          ((bvk)localObject1).username = Util.nullAsNil((String)paramString.get((String)localObject3 + ".username"));
          ((bvk)localObject1).nickname = Util.nullAsNil((String)paramString.get((String)localObject3 + ".nickname"));
          ((bvk)localObject1).avatar = Util.nullAsNil((String)paramString.get((String)localObject3 + ".avatar"));
          ((bvk)localObject1).HbX = Util.nullAsNil((String)paramString.get((String)localObject3 + ".authJob"));
          ((bvk)localObject1).HbY = Util.getInt((String)paramString.get((String)localObject3 + ".authIcon"), -1);
          ((arg)localObject2).a((bvk)localObject1);
          localObject3 = new bvh();
          str = ".dataitem" + ".finderContentColumnSharedItem";
          if (paramString.isEmpty()) {
            break label4326;
          }
          ((bvh)localObject3).AEA = new com.tencent.mm.bx.b(Base64.decode(Util.nullAsNil((String)paramString.get(str + ".cardbuffer")), 0));
          localObject1 = Util.nullAsNil((String)paramString.get(str + ".iconUrl"));
          localObject6 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_1"));
          localObject5 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_2"));
          localObject4 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_3"));
          localObject1 = ((String)localObject1).split("&token");
          ((bvh)localObject3).aacP.add(localObject1[0]);
          localLinkedList = ((bvh)localObject3).aacQ;
          if (localObject1.length <= 1) {
            break label5250;
          }
          localObject1 = "&token" + localObject1[1];
          localLinkedList.add(localObject1);
          localObject1 = ((String)localObject6).split("&token");
          ((bvh)localObject3).aacP.add(localObject1[0]);
          localObject6 = ((bvh)localObject3).aacQ;
          if (localObject1.length <= 1) {
            break label5257;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject6).add(localObject1);
          localObject1 = ((String)localObject5).split("&token");
          ((bvh)localObject3).aacP.add(localObject1[0]);
          localObject5 = ((bvh)localObject3).aacQ;
          if (localObject1.length <= 1) {
            break label5264;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject5).add(localObject1);
          localObject1 = ((String)localObject4).split("&token");
          ((bvh)localObject3).aacP.add(localObject1[0]);
          localObject4 = ((bvh)localObject3).aacQ;
          if (localObject1.length <= 1) {
            break label5271;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject4).add(localObject1);
          ((bvh)localObject3).cardId = Util.nullAsNil((String)paramString.get(str + ".cardId"));
          ((bvh)localObject3).title = Util.nullAsNil((String)paramString.get(str + ".title"));
          ((bvh)localObject3).uCW = Util.nullAsNil((String)paramString.get(str + ".secondTitle"));
          ((arg)localObject2).c((bvh)localObject3);
          localObject1 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject1)) {
            break label4356;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject1)) {
            break label4560;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject1)) {
            break label4724;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject1)) {
            break label5188;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".favbrandmpvideo";
          if (paramString.containsKey(localObject1)) {
            break label5203;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          ((arg)localObject2).e(cq.J(".dataitem", paramString));
          localarf.a((arg)localObject2);
          paramString = localarf;
          continue;
        }
        localObject1 = new arm();
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((arm)localObject1).btf((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((arm)localObject1).btg((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!Util.isNullOrNil(str)) {
          ((arm)localObject1).V(Util.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!Util.isNullOrNil(str)) {
          ((arm)localObject1).W(Util.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!Util.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((arm)localObject1).axD(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((arg)localObject2).c((arm)localObject1);
          continue;
        }
        ((arm)localObject1).axD(Util.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label4045:
      Object localObject3 = new ask();
      ((ask)localObject3).btB((String)paramString.get((String)localObject1 + ".title"));
      ((ask)localObject3).btC((String)paramString.get((String)localObject1 + ".desc"));
      ((ask)localObject3).btE((String)paramString.get((String)localObject1 + ".thumburl"));
      ((ask)localObject3).btD((String)paramString.get((String)localObject1 + ".link"));
      ((ask)localObject3).axI(Util.getInt((String)paramString.get((String)localObject1 + ".opencache"), 0));
      ((ask)localObject3).axK(Util.getInt((String)paramString.get((String)localObject1 + ".forwardflag"), 0));
      ((arg)localObject2).b((ask)localObject3);
      continue;
      label4289:
      ((bvk)localObject1).username = "";
      ((bvk)localObject1).nickname = "";
      ((bvk)localObject1).avatar = "";
      ((bvk)localObject1).HbX = "";
      ((bvk)localObject1).HbY = -1;
      continue;
      label4326:
      ((bvh)localObject3).cardId = "";
      ((bvh)localObject3).title = "";
      ((bvh)localObject3).uCW = "";
      ((bvh)localObject3).AEA = null;
      continue;
      label4356:
      localObject3 = new aru();
      ((aru)localObject3).bth((String)paramString.get((String)localObject1 + ".title"));
      ((aru)localObject3).bti((String)paramString.get((String)localObject1 + ".desc"));
      ((aru)localObject3).btj((String)paramString.get((String)localObject1 + ".thumburl"));
      ((aru)localObject3).btk((String)paramString.get((String)localObject1 + ".productinfo"));
      ((aru)localObject3).axE(Util.getInt((String)paramString.get((String)localObject1 + ".$type"), 0));
      ((arg)localObject2).a((aru)localObject3);
      continue;
      label4560:
      localObject3 = new ase();
      ((ase)localObject3).btx((String)paramString.get((String)localObject1 + ".title"));
      ((ase)localObject3).bty((String)paramString.get((String)localObject1 + ".desc"));
      ((ase)localObject3).btz((String)paramString.get((String)localObject1 + ".thumburl"));
      ((ase)localObject3).btA((String)paramString.get((String)localObject1 + ".tvinfo"));
      ((arg)localObject2).a((ase)localObject3);
      continue;
      label4724:
      localObject3 = new ard();
      ((ard)localObject3).username = ((String)paramString.get((String)localObject1 + ".username"));
      ((ard)localObject3).appId = ((String)paramString.get((String)localObject1 + ".appid"));
      ((ard)localObject3).hJK = Util.getInt((String)paramString.get((String)localObject1 + ".pkgtype"), 0);
      ((ard)localObject3).iconUrl = ((String)paramString.get((String)localObject1 + ".iconurl"));
      ((ard)localObject3).type = Util.getInt((String)paramString.get((String)localObject1 + ".type"), 0);
      ((ard)localObject3).hzy = ((String)paramString.get((String)localObject1 + ".pagepath"));
      ((ard)localObject3).Zyw = ((String)paramString.get((String)localObject1 + ".sourcedisplayname"));
      ((ard)localObject3).version = Util.getInt((String)paramString.get((String)localObject1 + ".version"), 0);
      ((ard)localObject3).rxs = Util.getInt((String)paramString.get((String)localObject1 + ".disableforward"), 0);
      ((ard)localObject3).nOX = Util.getInt((String)paramString.get((String)localObject1 + ".showRelievedBuyFlag"), 0);
      ((ard)localObject3).idf = ((String)paramString.get((String)localObject1 + ".messageextradata"));
      ((ard)localObject3).subType = Util.getInt((String)paramString.get((String)localObject1 + ".subtype"), 0);
      ((arg)localObject2).b((ard)localObject3);
      continue;
      label5188:
      ((arg)localObject2).d(com.tencent.mm.plugin.fav.a.a.b.u((String)localObject1, paramString));
      continue;
      label5203:
      ((arg)localObject2).e(com.tencent.mm.plugin.fav.a.a.b.v((String)localObject1, paramString));
      continue;
      label5218:
      AppMethodBeat.o(9542);
      return;
      label5225:
      paramString = null;
      continue;
      label5230:
      localObject1 = null;
      continue;
      label5236:
      i += 1;
      continue;
      label5243:
      j += 1;
      continue;
      label5250:
      localObject1 = "";
      continue;
      label5257:
      localObject1 = "";
      continue;
      label5264:
      localObject1 = "";
      continue;
      label5271:
      localObject1 = "";
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, arv paramarv)
  {
    AppMethodBeat.i(9521);
    if (paramarv.YzK != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(Util.escapeStringForXml(paramarv.YzK.ZBm)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(Util.escapeStringForXml(paramarv.YzK.ZBn)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramarv.ygh).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(Util.escapeStringForXml(paramarv.YzK.ZBn)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(305575);
    if (ab.IO(paramString1))
    {
      paramString1 = new tq();
      paramString1.hXs.msgId = paramLong;
      paramString1.hXs.hPw = paramBoolean;
      paramString1.hXs.errMsg = Util.nullAs(paramString2, "");
      paramString1.publish();
      AppMethodBeat.o(305575);
      return true;
    }
    AppMethodBeat.o(305575);
    return false;
  }
  
  public static com.tencent.mm.protocal.b.a.c aSH(String paramString)
  {
    AppMethodBeat.i(9541);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)lNS.get(Integer.valueOf(i));
    if (localObject != null)
    {
      Log.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      AppMethodBeat.o(9541);
      return localObject;
    }
    if (paramString.trim().contains("<recordinfo>")) {}
    for (localObject = XmlParser.parseXml(paramString, "recordinfo", null); localObject == null; localObject = XmlParser.parseXml("<recordinfo>" + paramString + "</recordinfo>", "recordinfo", null))
    {
      Log.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      AppMethodBeat.o(9541);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.NAa = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      arp localarp = new arp();
      localarp.ZBn = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localarp.ZBm = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.YzK = localarp;
      localc.ygh = Util.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    lNS.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String atP(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static String b(arf paramarf, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramarf == null) || (Util.isNullOrNil(paramarf.hIQ)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramarf = gD(atP(paramarf.hIQ), paramInt);
    paramarf = ah.v(new u(tp(paramLong), paramarf).jKT());
    AppMethodBeat.o(9536);
    return paramarf;
  }
  
  private static List<com.tencent.mm.pluginsdk.h.a.b> b(String paramString, arv paramarv)
  {
    AppMethodBeat.i(305370);
    List localList = Collections.synchronizedList(new ArrayList());
    if (paramarv != null)
    {
      Iterator localIterator = paramarv.vEn.iterator();
      while (localIterator.hasNext())
      {
        arf localarf = (arf)localIterator.next();
        if (localarf.Zza > 26214400L)
        {
          com.tencent.mm.pluginsdk.h.a.b localb = new com.tencent.mm.pluginsdk.h.a.b();
          String str = localarf.Zzd;
          paramarv = y.bub(str);
          localb.filePath = str;
          localb.toUser = paramString;
          localb.fileSize = localarf.Zza;
          localb.lPJ = localarf.ZyU;
          if (Util.isNullOrNil(localarf.ZyW)) {}
          for (;;)
          {
            localb.vyS = paramarv;
            localb.aesKey = localarf.ZyH;
            localb.fileName = localarf.title;
            localList.add(localb);
            break;
            paramarv = localarf.ZyW;
          }
        }
      }
    }
    AppMethodBeat.o(305370);
    return localList;
  }
  
  private static void b(long paramLong, String paramString1, String paramString2, String paramString3, arv paramarv)
  {
    AppMethodBeat.i(305389);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramarv;
    localk.field_type = 1;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(305389);
  }
  
  public static boolean b(arf paramarf, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramarf == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = f(paramarf.hIQ, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(str);
    if (localObject == null)
    {
      com.tencent.mm.plugin.record.a.j localj = new com.tencent.mm.plugin.record.a.j();
      localj.field_cdnKey = paramarf.ZyH;
      localj.field_cdnUrl = paramarf.Ysw;
      localj.field_dataId = paramarf.hIQ;
      localj.field_mediaId = str;
      localj.field_totalLen = ((int)paramarf.Zza);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = a(paramarf, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = kC(paramarf.dataType, (int)paramarf.Zza);
      localj.field_isThumb = false;
      localj.field_tpaeskey = paramarf.ZzT;
      localj.field_tpauthkey = paramarf.nRn;
      localj.field_tpdataurl = paramarf.ZzW;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
      localObject = localj;
      if (!Util.isNullOrNil(paramarf.ZzG))
      {
        localObject = localj;
        if (paramarf.ZzG.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(localj);
          localObject = localj;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((com.tencent.mm.plugin.record.a.j)localObject).field_status)
      {
        Log.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((com.tencent.mm.plugin.record.a.j)localObject).field_status)
      {
        Log.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.a.j)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          ((com.tencent.mm.plugin.record.a.j)localObject).field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((com.tencent.mm.plugin.record.a.j)localObject, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9544);
        return true;
      }
      AppMethodBeat.o(9544);
      return false;
    }
  }
  
  public static String c(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramarf = a(paramarf, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramarf;
  }
  
  public static boolean c(arf paramarf, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramarf == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = atP(paramarf.hIQ);
    String str2 = f(str1, paramLong, true);
    com.tencent.mm.plugin.record.a.j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(str2);
    if (localj == null)
    {
      localj = new com.tencent.mm.plugin.record.a.j();
      localj.field_cdnKey = paramarf.ZyC;
      localj.field_cdnUrl = paramarf.nRr;
      localj.field_dataId = str1;
      localj.field_mediaId = str2;
      localj.field_totalLen = ((int)paramarf.Zzk);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = b(paramarf, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
      localj.field_isThumb = true;
      localj.field_tpdataurl = paramarf.nRi;
      localj.field_tpauthkey = paramarf.nRn;
      localj.field_tpaeskey = paramarf.nRo;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
    }
    for (paramarf = localj;; paramarf = localj)
    {
      Log.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramarf });
      if (4 == paramarf.field_status)
      {
        Log.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramarf.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramarf.field_status)
      {
        Log.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramarf.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramarf.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramarf, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9546);
        return true;
      }
      AppMethodBeat.o(9546);
      return false;
    }
  }
  
  public static boolean d(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new u(a(paramarf, paramLong, 1)).jKS();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static boolean e(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new u(b(paramarf, paramLong, 1)).jKS();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  public static String er(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static String f(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(369890);
    paramarf = b(paramarf, paramLong, 1);
    AppMethodBeat.o(369890);
    return paramarf;
  }
  
  public static String f(String paramString, long paramLong, boolean paramBoolean)
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
  
  private static final b g(k.b paramb)
  {
    AppMethodBeat.i(305374);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
      AppMethodBeat.o(305374);
      return null;
    }
    paramb = aSH(paramb.nRF);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
      AppMethodBeat.o(305374);
      return null;
    }
    arv localarv = new arv();
    localarv.vEn = new LinkedList();
    localarv.a(paramb.YzK);
    localarv.yt(paramb.ygh);
    localarv.btm(paramb.title);
    String str = MMApplicationContext.getContext().getString(a.c.app_big_file);
    Object localObject1 = MMApplicationContext.getContext().getString(a.c.app_file);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramb.nUC.iterator();
    arf localarf;
    while (((Iterator)localObject2).hasNext())
    {
      localarf = (arf)((Iterator)localObject2).next();
      if ((localarf.dataType == 8) && (localarf.Zza > 26214400L))
      {
        localarf.axy(1);
        localarf.bsp(str);
        localArrayList.add((String)localObject1 + localarf.title);
        localarf.bso(null);
        localarf.bsy(null);
        localarf.bst(null);
        localarf.bss(null);
        localarf.ZyJ = 0;
        localarf.ZyK = true;
        localarf.yo(str.length());
      }
      localarv.vEn.add(localarf);
    }
    localObject1 = paramb.desc.split("\n");
    localObject2 = new StringBuffer();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localarf = localObject1[i];
      String[] arrayOfString = localarf.split(":");
      if (arrayOfString.length != 2)
      {
        Log.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", new Object[] { localarf, paramb.desc });
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
          ((StringBuffer)localObject2).append(localarf);
        }
      }
    }
    str = ((StringBuffer)localObject2).toString();
    str = str.substring(0, str.length() - 1);
    localarv.btn(str);
    paramb = new b(str, paramb.NAa, localarv);
    AppMethodBeat.o(305374);
    return paramb;
  }
  
  public static boolean g(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(305556);
    if (paramarf == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try pause download data fail, dataitem is null");
      AppMethodBeat.o(305556);
      return false;
    }
    paramarf = f(paramarf.hIQ, paramLong, true);
    paramarf = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(paramarf);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().b(paramarf);
    AppMethodBeat.o(305556);
    return true;
  }
  
  public static String gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(9539);
    if (Util.isEqual(paramInt, 1))
    {
      AppMethodBeat.o(9539);
      return paramString;
    }
    paramString = paramInt + "_" + paramString;
    AppMethodBeat.o(9539);
    return paramString;
  }
  
  public static boolean h(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramarf == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramarf = f(paramarf.hIQ, paramLong, true);
    paramarf = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(paramarf);
    if (paramarf == null)
    {
      Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramarf.field_status)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramarf.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramarf.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  public static boolean i(arf paramarf, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = ImgUtil.isGif(a(paramarf, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static int kC(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.g.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.g.a.lwb;
    }
    return com.tencent.mm.g.a.MediaType_FILE;
  }
  
  public static arf lh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305579);
    paramString1 = aSH(paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "get record msg data error, empty");
      AppMethodBeat.o(305579);
      return null;
    }
    paramString1 = paramString1.nUC.iterator();
    while (paramString1.hasNext())
    {
      arf localarf = (arf)paramString1.next();
      if (localarf.hIQ.equals(paramString2))
      {
        AppMethodBeat.o(305579);
        return localarf;
      }
      if (localarf.dataType == 17)
      {
        localarf = lh(localarf.ZzO, paramString2);
        if (localarf != null)
        {
          AppMethodBeat.o(305579);
          return localarf;
        }
      }
    }
    AppMethodBeat.o(305579);
    return null;
  }
  
  public static com.tencent.mm.protocal.b.a.c li(String paramString1, String paramString2)
  {
    AppMethodBeat.i(305582);
    paramString1 = aSH(paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "get record msg data error, empty");
      AppMethodBeat.o(305582);
      return null;
    }
    Iterator localIterator = paramString1.nUC.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (arf)localIterator.next();
      if (((arf)localObject).hIQ.equals(paramString2))
      {
        AppMethodBeat.o(305582);
        return paramString1;
      }
      if (((arf)localObject).dataType == 17)
      {
        localObject = li(((arf)localObject).ZzO, paramString2);
        if (localObject != null)
        {
          AppMethodBeat.o(305582);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(305582);
    return null;
  }
  
  private static u tp(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = new u(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.h.baE().mCJ + "record/", Long.valueOf(paramLong) }));
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory())) {
      ((u)localObject).jKY();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void tq(long paramLong)
  {
    AppMethodBeat.i(9531);
    u localu = tp(paramLong);
    boolean bool = y.ew(ah.v(localu.mUri), true);
    Log.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { ah.v(localu.jKT()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
  
  private static boolean z(List<arf> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (arf)paramList.next();
        int i = ((arf)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = aSH(((arf)localObject).ZzO);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = z(((com.tencent.mm.protocal.b.a.c)localObject).nUC, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((Util.isNullOrNil(((arf)localObject).Ysw)) && (Util.isNullOrNil(((arf)localObject).nRr)) && (Util.isNullOrNil(((arf)localObject).ZzW)) && (Util.isNullOrNil(((arf)localObject).nRi))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.q
 * JD-Core Version:    0.7.0.1
 */