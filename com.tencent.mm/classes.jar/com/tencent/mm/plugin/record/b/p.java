package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.sb;
import com.tencent.mm.f.a.zs;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.vfs.u;
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
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> jla;
  
  static
  {
    AppMethodBeat.i(9549);
    jla = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  public static String PK(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((as)localObject).ays();
    localObject = str;
    if (ab.Lj(str))
    {
      paramString = v.Ps(paramString);
      localObject = z.bcZ();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label107;
      }
      Log.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = v.e(paramString, 3))
    {
      AppMethodBeat.o(9547);
      return localObject;
      label107:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  private static com.tencent.mm.vfs.q Pp(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = new com.tencent.mm.vfs.q(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.h.aHG().kcB + "record/", Long.valueOf(paramLong) }));
    if ((!((com.tencent.mm.vfs.q)localObject).ifE()) || (!((com.tencent.mm.vfs.q)localObject).isDirectory())) {
      ((com.tencent.mm.vfs.q)localObject).ifL();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void Pq(long paramLong)
  {
    AppMethodBeat.i(9531);
    com.tencent.mm.vfs.q localq = Pp(paramLong);
    boolean bool = u.deleteDir(localq.getPath());
    Log.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { localq.bOF(), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
  
  public static int a(final String paramString1, final aoc paramaoc, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramaoc == null) || (paramaoc.syG.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramaoc);
    final ca localca = new ca();
    paramString2 = null;
    if (!Util.isNullOrNil(paramString4))
    {
      paramString2 = Util.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label364;
        }
      }
    }
    long l;
    label364:
    for (paramString2 = com.tencent.mm.ay.q.bmh().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.ay.q.bmh().aA(paramString2))
    {
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + paramString2);
      if (!Util.isNullOrNil(paramString2)) {
        localca.Jn(paramString2);
      }
      localca.setContent(k.b.a(paramString3, null, null));
      localca.setStatus(1);
      localca.Jm(paramString1);
      localca.setCreateTime(bq.RP(paramString1));
      localca.pJ(1);
      localca.setType(49);
      if (com.tencent.mm.ao.g.KI(paramString1)) {
        localca.Ip(com.tencent.mm.ao.a.e.apc());
      }
      l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label375;
      }
      Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
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
      paramString2 = BitmapUtil.Bitmap2Bytes(com.tencent.mm.am.d.a(paramString5, false, -1, null));
      break;
    }
    label375:
    Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localca.setMsgId(l);
    paramString2 = new com.tencent.mm.aj.k();
    paramString2.field_xml = localca.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.ab.a.fmA().insert(paramString2);
    paramString2 = paramaoc.syG.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (anm)paramString2.next();
    } while ((Util.isNullOrNil(paramString4.Rwb)) && (Util.isNullOrNil(paramString4.lmm)));
    paramString2 = b(paramString1, paramaoc);
    if (paramString2.size() > 0) {
      com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.pluginsdk.h.a(paramString2, new com.tencent.mm.pluginsdk.h.a.a()
      {
        public final void bQ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(210358);
          if (paramAnonymousInt == 0)
          {
            p.d(this.fgE, paramString1.getTitle(), paramString1.getDescription(), paramaoc, localca);
            AppMethodBeat.o(210358);
            return;
          }
          if (-3200 == paramAnonymousInt)
          {
            Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.fgE), paramaoc });
            p.c(this.fgE, this.lrk);
            p.b(this.fgE, this.lrk, paramaoc);
            ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).K(this.fgE, paramaoc);
            AppMethodBeat.o(210358);
            return;
          }
          this.lrk.setStatus(5);
          ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fgE, this.lrk);
          p.ek(paramaoc, paramAnonymousString);
          AppMethodBeat.o(210358);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(9528);
      return 0;
      b(l, paramString3.getTitle(), paramString3.getDescription(), paramString1, paramaoc);
    }
  }
  
  public static int a(String paramString1, String paramString2, ca paramca)
  {
    AppMethodBeat.i(9525);
    int i = a(paramString1, paramString2, paramca, false);
    AppMethodBeat.o(9525);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, ca paramca, final boolean paramBoolean)
  {
    AppMethodBeat.i(9526);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9526);
      return -1;
    }
    if ((paramca == null) || (Util.isNullOrNil(paramca.field_content)))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      AppMethodBeat.o(9526);
      return -1;
    }
    if (1 == paramca.field_status)
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      AppMethodBeat.o(9526);
      return -1;
    }
    paramString1 = Util.stringsToList(paramString1.split(",")).iterator();
    label785:
    while (paramString1.hasNext())
    {
      final String str = (String)paramString1.next();
      Log.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(paramca.field_msgId), Integer.valueOf(paramca.field_status) });
      Object localObject1 = bq.RM(paramca.field_content);
      final k.b localb = k.b.OQ((String)localObject1);
      if (localb == null)
      {
        Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final com.tencent.mm.protocal.b.a.c localc = aVz(localb.lmA);
      if (localc == null)
      {
        Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final ca localca = new ca();
      Object localObject2;
      if (!Util.isNullOrNil(paramca.field_imgPath))
      {
        localObject2 = Util.readFromFile(com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true));
        localObject2 = com.tencent.mm.ay.q.bmh().aA((byte[])localObject2);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData from msg MsgInfo path:" + (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          localca.Jn((String)localObject2);
        }
      }
      localca.setContent((String)localObject1);
      localca.setStatus(1);
      localca.Jm(str);
      localca.setCreateTime(bq.RP(str));
      localca.pJ(1);
      localca.setType(49);
      long l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      localObject1 = new zs();
      ((zs)localObject1).fYX.fYY = paramca.field_msgId;
      ((zs)localObject1).fYX.fYZ = l;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new com.tencent.mm.aj.k();
      ((com.tencent.mm.aj.k)localObject1).field_xml = localca.field_content;
      ((com.tencent.mm.aj.k)localObject1).field_title = localb.title;
      ((com.tencent.mm.aj.k)localObject1).field_type = localb.type;
      ((com.tencent.mm.aj.k)localObject1).field_description = localb.description;
      ((com.tencent.mm.aj.k)localObject1).field_msgId = l;
      ((com.tencent.mm.aj.k)localObject1).field_appId = localb.appId;
      com.tencent.mm.plugin.ab.a.fmA().insert((IAutoDBItem)localObject1);
      if (l(localc.lpz, paramBoolean))
      {
        localObject1 = new aoc();
        ((aoc)localObject1).syG.addAll(localc.lpz);
        localObject2 = b(str, (aoc)localObject1);
        if (((List)localObject2).size() > 0) {
          com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.pluginsdk.h.a((List)localObject2, new com.tencent.mm.pluginsdk.h.a.a()
          {
            public final void bQ(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(210114);
              if (paramAnonymousInt == 0)
              {
                p.b(this.fgE, str.field_msgId, localb, localc, this.HDk, paramBoolean, localca);
                AppMethodBeat.o(210114);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.fgE), localb });
                p.c(this.fgE, this.lrk);
                p.a(this.fgE, str.field_msgId, this.lrk, localb, localca);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).K(this.fgE, localb);
                AppMethodBeat.o(210114);
                return;
              }
              this.lrk.setStatus(5);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fgE, this.lrk);
              p.ek(localb, paramAnonymousString);
              AppMethodBeat.o(210114);
            }
          }), 0);
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramString2)) {
          break label785;
        }
        com.tencent.mm.plugin.messenger.a.g.eRW().ai(str, paramString2, ab.QZ(str));
        break;
        a(l, paramca.field_msgId, str, localb, localc, (aoc)localObject1, paramBoolean);
        continue;
        Log.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.g.class)).Pm(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static Pair<Long, Boolean> a(Context paramContext, final String paramString1, final String paramString2, List<ca> paramList, dd paramdd, com.tencent.mm.protocal.b.a.d paramd, String paramString3)
  {
    AppMethodBeat.i(210492);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(210492);
      return paramContext;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(210492);
      return paramContext;
    }
    if ((paramdd == null) || (paramd == null))
    {
      paramdd = new dd();
      if (!c.a(paramContext, paramdd, paramString2, paramList, -1))
      {
        paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
        AppMethodBeat.o(210492);
        return paramContext;
      }
      paramd = a(paramContext, paramdd, paramString2);
    }
    for (paramString2 = paramdd;; paramString2 = paramdd)
    {
      paramdd = a(paramd.title, paramd.desc, paramString2.fyI.fyK);
      final ca localca = new ca();
      paramList = null;
      if (!Util.isNullOrNil(paramd.thumbPath))
      {
        paramContext = Util.readFromFile(paramd.thumbPath);
        if (paramContext != null) {
          if (paramContext.length <= 65536) {
            break label501;
          }
        }
      }
      long l;
      label501:
      for (paramContext = com.tencent.mm.ay.q.bmh().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.ay.q.bmh().aA(paramContext))
      {
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " thumbData MsgInfo path:" + paramContext);
        if (!Util.isNullOrNil(paramContext)) {
          localca.Jn(paramContext);
        }
        localca.setContent(k.b.a(paramdd, null, null));
        localca.setStatus(1);
        localca.Jm(paramString1);
        localca.setCreateTime(bq.RP(paramString1));
        localca.pJ(1);
        localca.setType(49);
        if (com.tencent.mm.ao.g.KI(paramString1)) {
          localca.Ip(com.tencent.mm.ao.a.e.apc());
        }
        l = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(localca);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label512;
        }
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.avD() + "insert msg failed :" + l);
        paramContext = new Pair(Long.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Boolean.FALSE);
        AppMethodBeat.o(210492);
        return paramContext;
        paramContext = paramList;
        if (paramd.fRA != 0) {
          break;
        }
        paramContext = paramList;
        if (Util.isNullOrNil(paramd.wMd)) {
          break;
        }
        paramContext = BitmapUtil.Bitmap2Bytes(com.tencent.mm.am.d.a(paramd.wMd, false, -1, null));
        break;
      }
      label512:
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      paramContext = new com.tencent.mm.aj.k();
      paramContext.field_xml = localca.field_content;
      paramContext.field_title = paramdd.title;
      paramContext.field_type = paramdd.type;
      paramContext.field_description = paramdd.description;
      paramContext.field_msgId = l;
      paramContext.field_appId = paramdd.appId;
      com.tencent.mm.plugin.ab.a.fmA().insert(paramContext);
      paramContext = paramString2.fyI.fyK.syG.iterator();
      for (boolean bool = false; paramContext.hasNext(); bool = true)
      {
        label635:
        paramList = (anm)paramContext.next();
        if (Util.isNullOrNil(paramList.fEa)) {
          paramList.bsK(dN(paramList.toString(), paramList.dataType));
        }
        if ((!bool) && (!u.agG(paramList.Syl)) && (!u.agG(paramList.Syn)) && (Util.isNullOrNil(paramList.Rwb)) && (Util.isNullOrNil(paramList.lmm)) && (Util.isNullOrNil(paramList.Sze)) && (Util.isNullOrNil(paramList.lmd))) {
          break label635;
        }
      }
      Log.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        if ((!ab.Qh(paramString1)) || (Util.isNullOrNil(paramString3))) {
          break label956;
        }
      }
      for (;;)
      {
        paramContext = b(paramString3, paramString2.fyI.fyK);
        if (paramContext.size() > 0)
        {
          com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.pluginsdk.h.a(paramContext, new com.tencent.mm.pluginsdk.h.a.a()
          {
            public final void bQ(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(210049);
              if (paramAnonymousInt == 0)
              {
                p.c(this.fgE, paramString1.getTitle(), paramString1.getDescription(), paramString2, localca.fyI.fyK);
                AppMethodBeat.o(210049);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                p.c(this.fgE, this.lrk);
                p.a(this.fgE, this.lrk, paramString2);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).K(this.fgE, paramString2);
                AppMethodBeat.o(210049);
                return;
              }
              this.lrk.setStatus(5);
              ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fgE, this.lrk);
              if (!p.a(paramString2, this.fgE, false, paramAnonymousString)) {
                p.ek(paramString2, paramAnonymousString);
              }
              AppMethodBeat.o(210049);
            }
          }), 0);
          if (bool) {
            break label950;
          }
        }
        label950:
        for (bool = true;; bool = false)
        {
          paramContext = new Pair(Long.valueOf(l), Boolean.valueOf(bool));
          AppMethodBeat.o(210492);
          return paramContext;
          a(l, paramdd.getTitle(), paramdd.getDescription(), paramString1, paramString2.fyI.fyK);
          break;
          Log.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
          if (ab.Qh(paramString1)) {
            break;
          }
          ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.g.class)).Pm(l);
          break;
        }
        label956:
        paramString3 = paramString1;
      }
    }
  }
  
  public static k.b a(String paramString1, String paramString2, aoc paramaoc)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramaoc.syG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramaoc);
    localStringBuilder.append(q.dK(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(z.bcZ())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramaoc = new k.b();
    paramaoc.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramaoc.description = paramString1;
    if ((!Util.isNullOrNil(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((anm)localLinkedList.get(0)))) {
      paramaoc.type = 24;
    }
    for (paramaoc.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramaoc.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramaoc.action = "view";
      paramaoc.lmA = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramaoc;
      paramaoc.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, dd paramdd, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.ao.g.KI(paramString))
    {
      locald.title = paramdd.fyI.fyK.title;
      Log.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramdd.fyI.fyK == null) {
        break label457;
      }
      paramdd = paramdd.fyI.fyK.syG;
      localObject2 = paramdd.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1614;
      }
      Object localObject3 = (anm)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((anm)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((anm)localObject3).dataType, j + 1);
      switch (((anm)localObject3).dataType)
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
          paramString.add(((anm)localObject3).SyI + ":" + ((anm)localObject3).desc + "\n");
          continue;
          if (ab.Lj(paramString))
          {
            locald.title = paramContext.getString(a.c.record_chatroom_title);
            break;
          }
          localObject2 = z.bdb();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PI(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(a.c.favorite_record_chatroom_title, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(a.c.favorite_record_chat_title, new Object[] { localObject2, paramString });
          break;
          paramdd = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_voice) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_pic) + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.a.app_attach_file_icon_pic);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_url) + ((anm)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_webpage);
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
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_url) + ((anm)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_video) + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_video);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramdd = ((anm)localObject3).SyG.Szp;
          localObject3 = new StringBuilder().append(((anm)localObject3).SyI).append(":").append(paramContext.getString(a.c.app_location));
          if ((!Util.isNullOrNil(paramdd.fPN)) && (!paramdd.fPN.equals(paramContext.getString(a.c.app_location)))) {
            break label1031;
          }
        }
        for (paramdd = paramdd.label;; paramdd = paramdd.fPN)
        {
          paramString.add(paramdd + "\n");
          if (i != 0) {
            break;
          }
          locald.fRA = com.tencent.mm.plugin.record.a.b.app_attach_file_icon_location;
          i = 1;
          break;
        }
      case 7: 
      case 29: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_music) + ((anm)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_music);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_file) + ((anm)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_product) + ((anm)localObject3).SyG.Szt.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_app) + "\n");
        }
        if (i == 0)
        {
          a(locald, (anm)localObject3, com.tencent.mm.plugin.record.a.b.app_attach_file_icon_unknow);
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
            paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_friend_card) + "\n");
          }
          if (i == 0)
          {
            locald.wMd = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOU(((anm)localObject3).desc).fcC;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_record) + "\n");
        }
        break;
      case 19: 
        label457:
        if (paramString.size() < 5) {
          paramString.add(((anm)localObject3).SyI + ":" + paramContext.getString(a.c.app_app_brand) + ((anm)localObject3).title + "\n");
        }
        label1031:
        break;
      }
    }
    label1614:
    locald.desc = "";
    paramdd = paramString.iterator();
    for (paramContext = ""; paramdd.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramdd.next();
    }
    paramdd = paramContext.trim();
    paramContext = paramdd;
    if (paramString.size() >= 5) {
      paramContext = paramdd + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.lpz == null))
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
    anw localanw = paramc.RDh;
    if (localanw != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(Util.escapeStringForXml(localanw.SAu)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(Util.escapeStringForXml(localanw.SAv)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(Util.escapeStringForXml(localanw.SAv)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.uTt).append("</edittime>");
    paramString.append(q.dK(paramc.lpz));
    paramString.append("<favusername>").append(Util.escapeStringForXml(paramc.HCx)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(anm paramanm, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramanm == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = fL(paramanm.fEa, paramInt);
    if ((Util.isNullOrNil((String)localObject1)) || (!MMApplicationContext.isMMProcess()) || (!com.tencent.mm.kernel.h.aHB()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = Pp(paramLong);
    Object localObject3;
    if ((paramanm.dataType == 8) && (!Util.isNullOrNil(paramanm.title)))
    {
      localObject3 = paramanm.title;
      paramInt = paramanm.fEa.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.h.aHG().kcB + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (localq.ifE())
      {
        paramInt = i;
        localObject2 = localq;
        localObject1 = localObject3;
        if (localq.isDirectory()) {}
      }
      else
      {
        localq.ifL();
        localObject1 = localObject3;
        localObject2 = localq;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramanm.Syc != null)
      {
        localObject3 = localObject1;
        if (paramanm.Syc.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramanm.Syc;
          }
        }
      }
      paramanm = new com.tencent.mm.vfs.q((com.tencent.mm.vfs.q)localObject2, (String)localObject3).bOF();
      AppMethodBeat.o(9532);
      return paramanm;
    }
  }
  
  public static String a(String paramString1, String paramString2, aoc paramaoc, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramaoc == null) || (paramaoc.syG == null))
    {
      Log.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramaoc.syG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramaoc);
    localStringBuilder.append(q.dK(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramaoc = new k.b();
    paramaoc.title = paramString1;
    paramaoc.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((anm)localLinkedList.get(0)))) {
      paramaoc.type = 24;
    }
    for (paramaoc.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramaoc.url = ("https://" + WeChatHosts.domainString(a.c.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramaoc.action = "view";
      paramaoc.lmA = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.ab.a.fmA().NR(paramLong);
      if (paramString1 != null) {
        paramaoc.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramaoc, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramaoc.type = 19;
    }
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString, k.b paramb, com.tencent.mm.protocal.b.a.c paramc, aoc paramaoc, boolean paramBoolean)
  {
    AppMethodBeat.i(210485);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong1;
    localk.field_oriMsgId = paramLong2;
    localk.field_toUser = paramString;
    localk.field_title = paramb.title;
    localk.field_desc = Util.nullAs(paramc.desc, paramb.description);
    localk.field_dataProto = paramaoc;
    localk.field_type = 0;
    localk.field_favFrom = paramc.HCx;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk, paramBoolean);
    AppMethodBeat.o(210485);
  }
  
  private static void a(long paramLong, String paramString1, String paramString2, String paramString3, aoc paramaoc)
  {
    AppMethodBeat.i(210483);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramaoc;
    localk.field_type = 3;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(210483);
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, anm paramanm, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramanm = paramanm.Syn;
    if (u.agG(paramanm))
    {
      paramd.thumbPath = paramanm;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.fRA = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.lpz.clear();
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
            paramString.bsy(paramString.desc.replaceAll("‮", ""));
          }
          paramc.lpz.add(paramString);
        }
        catch (Exception paramString)
        {
          anm localanm;
          String str;
          Object localObject6;
          Object localObject5;
          Object localObject4;
          LinkedList localLinkedList;
          Log.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          Log.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.lpz.clear();
        }
        localanm = new anm();
        localanm.arq(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localanm.bsP((String)paramString.get(".dataitem" + ".$datasourceid"));
        localanm.arr(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localanm.bsH((String)paramString.get(".dataitem" + ".datafmt"));
        localanm.bsx((String)paramString.get(".dataitem" + ".datatitle"));
        localanm.bsy((String)paramString.get(".dataitem" + ".datadesc"));
        localanm.bsz((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localanm.bsA((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localanm.arn(Util.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localanm.aro(Util.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localanm.bsB((String)paramString.get(".dataitem" + ".cdndataurl"));
        localanm.bsC((String)paramString.get(".dataitem" + ".cdndatakey"));
        localanm.lmd = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localanm.Sza = true;
        localanm.bsY((String)paramString.get(".dataitem" + ".tpaeskey"));
        localanm.bsZ((String)paramString.get(".dataitem" + ".tpauthkey"));
        localanm.bta((String)paramString.get(".dataitem" + ".tpdataurl"));
        localanm.lmj = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localanm.Szg = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localanm.arp(Util.getInt((String)localObject2, 0));
        }
        localanm.bsE((String)paramString.get(".dataitem" + ".streamdataurl"));
        localanm.bsF((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localanm.bsD((String)paramString.get(".dataitem" + ".streamweburl"));
        localanm.bsI((String)paramString.get(".dataitem" + ".fullmd5"));
        localanm.bsJ((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localanm.TY(Util.getInt((String)localObject2, 0));
        }
        localanm.bsG((String)paramString.get(".dataitem" + ".dataext"));
        localanm.bsN((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localanm.bsO((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localanm.TZ(Util.getInt((String)localObject2, 0));
        }
        localanm.bsQ((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localanm.bsK((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!Util.isNullOrNil((String)localObject2)) {
          localanm.bsU((String)localObject2);
        }
        localanm.ars(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localanm.bsR((String)paramString.get(".dataitem" + ".sourcetitle"));
        localanm.bsS((String)paramString.get(".dataitem" + ".sourcename"));
        localanm.btb((String)paramString.get(".dataitem" + ".sourcedesc"));
        localanm.btc((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localanm.bsT((String)paramString.get(".dataitem" + ".sourcetime"));
        localanm.bsV((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localanm.bsX((String)localObject1);
        }
        localanm.btd((String)paramString.get(".dataitem" + ".songalbumurl"));
        localanm.bte((String)paramString.get(".dataitem" + ".songlyric"));
        localanm.btf((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject2 = new ann();
        localObject1 = new ano();
        ((ano)localObject1).aru(Util.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ano)localObject1).btg((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((ano)localObject1).fLi });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((ano)localObject1).btj((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((ano)localObject1).SAb });
        }
        ((ano)localObject1).btl((String)paramString.get(".dataitem" + ".appid"));
        ((ano)localObject1).btm((String)paramString.get(".dataitem" + ".link"));
        ((ano)localObject1).btn((String)paramString.get(".dataitem" + ".brandid"));
        ((ann)localObject2).c((ano)localObject1);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject1 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject1)) {
            break label4045;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          ((ann)localObject2).c(com.tencent.mm.plugin.findersdk.a.k.w(".dataitem", paramString));
          ((ann)localObject2).f(com.tencent.mm.plugin.findersdk.a.k.u(".dataitem", paramString));
          ((ann)localObject2).e(com.tencent.mm.plugin.findersdk.a.k.z(".dataitem", paramString));
          ((ann)localObject2).d(com.tencent.mm.plugin.findersdk.a.k.z(".dataitem", paramString));
          localObject1 = new bjd();
          localObject3 = ".dataitem" + ".finderShareNameCard";
          if (paramString.isEmpty()) {
            break label4289;
          }
          ((bjd)localObject1).username = Util.nullAsNil((String)paramString.get((String)localObject3 + ".username"));
          ((bjd)localObject1).nickname = Util.nullAsNil((String)paramString.get((String)localObject3 + ".nickname"));
          ((bjd)localObject1).avatar = Util.nullAsNil((String)paramString.get((String)localObject3 + ".avatar"));
          ((bjd)localObject1).Bvd = Util.nullAsNil((String)paramString.get((String)localObject3 + ".authJob"));
          ((bjd)localObject1).Bve = Util.getInt((String)paramString.get((String)localObject3 + ".authIcon"), -1);
          ((ann)localObject2).a((bjd)localObject1);
          localObject3 = new bja();
          str = ".dataitem" + ".finderContentColumnSharedItem";
          if (paramString.isEmpty()) {
            break label4326;
          }
          ((bja)localObject3).xGO = new com.tencent.mm.cd.b(Base64.decode(Util.nullAsNil((String)paramString.get(str + ".cardbuffer")), 0));
          localObject1 = Util.nullAsNil((String)paramString.get(str + ".iconUrl"));
          localObject6 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_1"));
          localObject5 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_2"));
          localObject4 = Util.nullAsNil((String)paramString.get(str + ".iconUrl_3"));
          localObject1 = ((String)localObject1).split("&token");
          ((bja)localObject3).STk.add(localObject1[0]);
          localLinkedList = ((bja)localObject3).STl;
          if (localObject1.length <= 1) {
            break label5250;
          }
          localObject1 = "&token" + localObject1[1];
          localLinkedList.add(localObject1);
          localObject1 = ((String)localObject6).split("&token");
          ((bja)localObject3).STk.add(localObject1[0]);
          localObject6 = ((bja)localObject3).STl;
          if (localObject1.length <= 1) {
            break label5257;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject6).add(localObject1);
          localObject1 = ((String)localObject5).split("&token");
          ((bja)localObject3).STk.add(localObject1[0]);
          localObject5 = ((bja)localObject3).STl;
          if (localObject1.length <= 1) {
            break label5264;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject5).add(localObject1);
          localObject1 = ((String)localObject4).split("&token");
          ((bja)localObject3).STk.add(localObject1[0]);
          localObject4 = ((bja)localObject3).STl;
          if (localObject1.length <= 1) {
            break label5271;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject4).add(localObject1);
          ((bja)localObject3).cardId = Util.nullAsNil((String)paramString.get(str + ".cardId"));
          ((bja)localObject3).title = Util.nullAsNil((String)paramString.get(str + ".title"));
          ((bja)localObject3).rsw = Util.nullAsNil((String)paramString.get(str + ".secondTitle"));
          ((ann)localObject2).c((bja)localObject3);
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
          ((ann)localObject2).e(am.C(".dataitem", paramString));
          localanm.a((ann)localObject2);
          paramString = localanm;
          continue;
        }
        localObject1 = new ant();
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((ant)localObject1).bto((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((ant)localObject1).btp((String)paramString.get((String)localObject3 + ".poiname"));
        }
        str = (String)paramString.get((String)localObject3 + ".lng");
        if (!Util.isNullOrNil(str)) {
          ((ant)localObject1).D(Util.getDouble(str, 0.0D));
        }
        str = (String)paramString.get((String)localObject3 + ".lat");
        if (!Util.isNullOrNil(str)) {
          ((ant)localObject1).E(Util.getDouble(str, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!Util.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((ant)localObject1).arv(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((ann)localObject2).c((ant)localObject1);
          continue;
        }
        ((ant)localObject1).arv(Util.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label4045:
      Object localObject3 = new aor();
      ((aor)localObject3).btK((String)paramString.get((String)localObject1 + ".title"));
      ((aor)localObject3).btL((String)paramString.get((String)localObject1 + ".desc"));
      ((aor)localObject3).btN((String)paramString.get((String)localObject1 + ".thumburl"));
      ((aor)localObject3).btM((String)paramString.get((String)localObject1 + ".link"));
      ((aor)localObject3).arA(Util.getInt((String)paramString.get((String)localObject1 + ".opencache"), 0));
      ((aor)localObject3).arC(Util.getInt((String)paramString.get((String)localObject1 + ".forwardflag"), 0));
      ((ann)localObject2).b((aor)localObject3);
      continue;
      label4289:
      ((bjd)localObject1).username = "";
      ((bjd)localObject1).nickname = "";
      ((bjd)localObject1).avatar = "";
      ((bjd)localObject1).Bvd = "";
      ((bjd)localObject1).Bve = -1;
      continue;
      label4326:
      ((bja)localObject3).cardId = "";
      ((bja)localObject3).title = "";
      ((bja)localObject3).rsw = "";
      ((bja)localObject3).xGO = null;
      continue;
      label4356:
      localObject3 = new aob();
      ((aob)localObject3).btq((String)paramString.get((String)localObject1 + ".title"));
      ((aob)localObject3).btr((String)paramString.get((String)localObject1 + ".desc"));
      ((aob)localObject3).bts((String)paramString.get((String)localObject1 + ".thumburl"));
      ((aob)localObject3).btt((String)paramString.get((String)localObject1 + ".productinfo"));
      ((aob)localObject3).arw(Util.getInt((String)paramString.get((String)localObject1 + ".$type"), 0));
      ((ann)localObject2).a((aob)localObject3);
      continue;
      label4560:
      localObject3 = new aol();
      ((aol)localObject3).btG((String)paramString.get((String)localObject1 + ".title"));
      ((aol)localObject3).btH((String)paramString.get((String)localObject1 + ".desc"));
      ((aol)localObject3).btI((String)paramString.get((String)localObject1 + ".thumburl"));
      ((aol)localObject3).btJ((String)paramString.get((String)localObject1 + ".tvinfo"));
      ((ann)localObject2).a((aol)localObject3);
      continue;
      label4724:
      localObject3 = new ank();
      ((ank)localObject3).username = ((String)paramString.get((String)localObject1 + ".username"));
      ((ank)localObject3).appId = ((String)paramString.get((String)localObject1 + ".appid"));
      ((ank)localObject3).fES = Util.getInt((String)paramString.get((String)localObject1 + ".pkgtype"), 0);
      ((ank)localObject3).iconUrl = ((String)paramString.get((String)localObject1 + ".iconurl"));
      ((ank)localObject3).type = Util.getInt((String)paramString.get((String)localObject1 + ".type"), 0);
      ((ank)localObject3).fve = ((String)paramString.get((String)localObject1 + ".pagepath"));
      ((ank)localObject3).SxE = ((String)paramString.get((String)localObject1 + ".sourcedisplayname"));
      ((ank)localObject3).version = Util.getInt((String)paramString.get((String)localObject1 + ".version"), 0);
      ((ank)localObject3).otE = Util.getInt((String)paramString.get((String)localObject1 + ".disableforward"), 0);
      ((ank)localObject3).nYp = Util.getInt((String)paramString.get((String)localObject1 + ".tradingguaranteeflag"), 0);
      ((ank)localObject3).fXg = ((String)paramString.get((String)localObject1 + ".messageextradata"));
      ((ank)localObject3).subType = Util.getInt((String)paramString.get((String)localObject1 + ".subtype"), 0);
      ((ann)localObject2).b((ank)localObject3);
      continue;
      label5188:
      ((ann)localObject2).d(com.tencent.mm.plugin.fav.a.a.b.s((String)localObject1, paramString));
      continue;
      label5203:
      ((ann)localObject2).e(com.tencent.mm.plugin.fav.a.a.b.t((String)localObject1, paramString));
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
  
  private static void a(StringBuilder paramStringBuilder, aoc paramaoc)
  {
    AppMethodBeat.i(9521);
    if (paramaoc.RDh != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(Util.escapeStringForXml(paramaoc.RDh.SAu)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(Util.escapeStringForXml(paramaoc.RDh.SAv)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramaoc.uTt).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(Util.escapeStringForXml(paramaoc.RDh.SAv)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(210507);
    if (ab.Qh(paramString1))
    {
      paramString1 = new sb();
      paramString1.fRv.msgId = paramLong;
      paramString1.fRv.fJQ = paramBoolean;
      paramString1.fRv.errMsg = Util.nullAs(paramString2, "");
      EventCenter.instance.publish(paramString1);
      AppMethodBeat.o(210507);
      return true;
    }
    AppMethodBeat.o(210507);
    return false;
  }
  
  public static com.tencent.mm.protocal.b.a.c aVz(String paramString)
  {
    AppMethodBeat.i(9541);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)jla.get(Integer.valueOf(i));
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
    localc.HCx = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      anw localanw = new anw();
      localanw.SAv = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localanw.SAu = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.RDh = localanw;
      localc.uTt = Util.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    jla.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String azJ(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static String b(anm paramanm, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramanm == null) || (Util.isNullOrNil(paramanm.fEa)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramanm = fL(azJ(paramanm.fEa), paramInt);
    paramanm = new com.tencent.mm.vfs.q(Pp(paramLong), paramanm).bOF();
    AppMethodBeat.o(9536);
    return paramanm;
  }
  
  private static List<com.tencent.mm.pluginsdk.h.a.b> b(String paramString, aoc paramaoc)
  {
    AppMethodBeat.i(210475);
    List localList = Collections.synchronizedList(new ArrayList());
    if (paramaoc != null)
    {
      Iterator localIterator = paramaoc.syG.iterator();
      while (localIterator.hasNext())
      {
        anm localanm = (anm)localIterator.next();
        if (localanm.Syi > 26214400L)
        {
          com.tencent.mm.pluginsdk.h.a.b localb = new com.tencent.mm.pluginsdk.h.a.b();
          String str = localanm.Syl;
          paramaoc = u.buc(str);
          localb.filePath = str;
          localb.toUser = paramString;
          localb.fileSize = localanm.Syi;
          localb.jmx = localanm.Syc;
          if (Util.isNullOrNil(localanm.Sye)) {}
          for (;;)
          {
            localb.smU = paramaoc;
            localb.aesKey = localanm.SxP;
            localb.fileName = localanm.title;
            localList.add(localb);
            break;
            paramaoc = localanm.Sye;
          }
        }
      }
    }
    AppMethodBeat.o(210475);
    return localList;
  }
  
  private static void b(long paramLong, String paramString1, String paramString2, String paramString3, aoc paramaoc)
  {
    AppMethodBeat.i(210488);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramaoc;
    localk.field_type = 1;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(210488);
  }
  
  public static boolean b(anm paramanm, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramanm == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = f(paramanm.fEa, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(str);
    if (localObject == null)
    {
      j localj = new j();
      localj.field_cdnKey = paramanm.SxP;
      localj.field_cdnUrl = paramanm.Rwb;
      localj.field_dataId = paramanm.fEa;
      localj.field_mediaId = str;
      localj.field_totalLen = ((int)paramanm.Syi);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = a(paramanm, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = iW(paramanm.dataType, (int)paramanm.Syi);
      localj.field_isThumb = false;
      localj.field_tpaeskey = paramanm.Szb;
      localj.field_tpauthkey = paramanm.lmi;
      localj.field_tpdataurl = paramanm.Sze;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
      localObject = localj;
      if (!Util.isNullOrNil(paramanm.SyO))
      {
        localObject = localj;
        if (paramanm.SyO.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(localj);
          localObject = localj;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localObject });
      if (4 == ((j)localObject).field_status)
      {
        Log.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(((j)localObject).field_errCode) });
        AppMethodBeat.o(9544);
        return false;
      }
      if (3 == ((j)localObject).field_status)
      {
        Log.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(((j)localObject).field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          ((j)localObject).field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9544);
        return true;
      }
      AppMethodBeat.o(9544);
      return false;
    }
  }
  
  public static String c(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramanm = a(paramanm, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramanm;
  }
  
  public static boolean c(anm paramanm, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramanm == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = azJ(paramanm.fEa);
    String str2 = f(str1, paramLong, true);
    j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(str2);
    if (localj == null)
    {
      localj = new j();
      localj.field_cdnKey = paramanm.SxK;
      localj.field_cdnUrl = paramanm.lmm;
      localj.field_dataId = str1;
      localj.field_mediaId = str2;
      localj.field_totalLen = ((int)paramanm.Sys);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = b(paramanm, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      localj.field_isThumb = true;
      localj.field_tpdataurl = paramanm.lmd;
      localj.field_tpauthkey = paramanm.lmi;
      localj.field_tpaeskey = paramanm.lmj;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
    }
    for (paramanm = localj;; paramanm = localj)
    {
      Log.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramanm });
      if (4 == paramanm.field_status)
      {
        Log.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramanm.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramanm.field_status)
      {
        Log.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramanm.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramanm.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramanm, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9546);
        return true;
      }
      AppMethodBeat.o(9546);
      return false;
    }
  }
  
  public static boolean d(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new com.tencent.mm.vfs.q(a(paramanm, paramLong, 1)).ifE();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static String dN(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean e(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new com.tencent.mm.vfs.q(b(paramanm, paramLong, 1)).ifE();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  private static final b f(k.b paramb)
  {
    AppMethodBeat.i(210480);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
      AppMethodBeat.o(210480);
      return null;
    }
    paramb = aVz(paramb.lmA);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
      AppMethodBeat.o(210480);
      return null;
    }
    aoc localaoc = new aoc();
    localaoc.syG = new LinkedList();
    localaoc.a(paramb.RDh);
    localaoc.Ud(paramb.uTt);
    localaoc.btv(paramb.title);
    String str = MMApplicationContext.getContext().getString(a.c.app_big_file);
    Object localObject1 = MMApplicationContext.getContext().getString(a.c.app_file);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramb.lpz.iterator();
    anm localanm;
    while (((Iterator)localObject2).hasNext())
    {
      localanm = (anm)((Iterator)localObject2).next();
      if ((localanm.dataType == 8) && (localanm.Syi > 26214400L))
      {
        localanm.arq(1);
        localanm.bsy(str);
        localArrayList.add((String)localObject1 + localanm.title);
        localanm.bsx(null);
        localanm.bsH(null);
        localanm.bsC(null);
        localanm.bsB(null);
        localanm.SxR = 0;
        localanm.SxS = true;
        localanm.TY(str.length());
      }
      localaoc.syG.add(localanm);
    }
    localObject1 = paramb.desc.split("\n");
    localObject2 = new StringBuffer();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localanm = localObject1[i];
      String[] arrayOfString = localanm.split(":");
      if (arrayOfString.length != 2)
      {
        Log.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", new Object[] { localanm, paramb.desc });
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
          ((StringBuffer)localObject2).append(localanm);
        }
      }
    }
    str = ((StringBuffer)localObject2).toString();
    str = str.substring(0, str.length() - 1);
    localaoc.btw(str);
    paramb = new b(str, paramb.HCx, localaoc);
    AppMethodBeat.o(210480);
    return paramb;
  }
  
  public static String f(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(292712);
    paramanm = b(paramanm, paramLong, 1);
    AppMethodBeat.o(292712);
    return paramanm;
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
  
  public static String fL(String paramString, int paramInt)
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
  
  public static boolean g(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(210505);
    if (paramanm == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try pause download data fail, dataitem is null");
      AppMethodBeat.o(210505);
      return false;
    }
    paramanm = f(paramanm.fEa, paramLong, true);
    paramanm = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(paramanm);
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().b(paramanm);
    AppMethodBeat.o(210505);
    return true;
  }
  
  public static boolean h(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramanm == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramanm = f(paramanm.fEa, paramLong, true);
    paramanm = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(paramanm);
    if (paramanm == null)
    {
      Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramanm.field_status)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramanm.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramanm.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  public static boolean i(anm paramanm, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = ImgUtil.isGif(a(paramanm, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static int iW(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.iTW;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  public static anm jM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210508);
    paramString1 = aVz(paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "get record msg data error, empty");
      AppMethodBeat.o(210508);
      return null;
    }
    paramString1 = paramString1.lpz.iterator();
    while (paramString1.hasNext())
    {
      anm localanm = (anm)paramString1.next();
      if (localanm.fEa.equals(paramString2))
      {
        AppMethodBeat.o(210508);
        return localanm;
      }
      if (localanm.dataType == 17)
      {
        localanm = jM(localanm.SyW, paramString2);
        if (localanm != null)
        {
          AppMethodBeat.o(210508);
          return localanm;
        }
      }
    }
    AppMethodBeat.o(210508);
    return null;
  }
  
  public static com.tencent.mm.protocal.b.a.c jN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210509);
    paramString1 = aVz(paramString1);
    if (paramString1 == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "get record msg data error, empty");
      AppMethodBeat.o(210509);
      return null;
    }
    Iterator localIterator = paramString1.lpz.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (anm)localIterator.next();
      if (((anm)localObject).fEa.equals(paramString2))
      {
        AppMethodBeat.o(210509);
        return paramString1;
      }
      if (((anm)localObject).dataType == 17)
      {
        localObject = jN(((anm)localObject).SyW, paramString2);
        if (localObject != null)
        {
          AppMethodBeat.o(210509);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(210509);
    return null;
  }
  
  private static boolean l(List<anm> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (anm)paramList.next();
        int i = ((anm)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = aVz(((anm)localObject).SyW);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = l(((com.tencent.mm.protocal.b.a.c)localObject).lpz, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((Util.isNullOrNil(((anm)localObject).Rwb)) && (Util.isNullOrNil(((anm)localObject).lmm)) && (Util.isNullOrNil(((anm)localObject).Sze)) && (Util.isNullOrNil(((anm)localObject).lmd))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.p
 * JD-Core Version:    0.7.0.1
 */