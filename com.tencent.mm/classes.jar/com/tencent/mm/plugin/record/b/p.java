package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.yl;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.pluginsdk.g.a.b;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcl;
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
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> gAU;
  
  static
  {
    AppMethodBeat.i(9549);
    gAU = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(9549);
  }
  
  private static o HU(long paramLong)
  {
    AppMethodBeat.i(174299);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = new o(String.format("%s/%d/", new Object[] { com.tencent.mm.kernel.g.aAh().hqG + "record/", Long.valueOf(paramLong) }));
    if ((!((o)localObject).exists()) || (!((o)localObject).isDirectory())) {
      ((o)localObject).mkdirs();
    }
    AppMethodBeat.o(174299);
    return localObject;
  }
  
  public static void HV(long paramLong)
  {
    AppMethodBeat.i(9531);
    o localo = HU(paramLong);
    boolean bool = s.dy(aa.z(localo.mUri), true);
    Log.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { aa.z(localo.her()), Boolean.valueOf(bool) });
    AppMethodBeat.o(9531);
  }
  
  public static String Is(String paramString)
  {
    AppMethodBeat.i(9547);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if (localObject == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      AppMethodBeat.o(9547);
      return "";
    }
    String str = ((as)localObject).arJ();
    localObject = str;
    if (ab.Eq(str))
    {
      paramString = v.Ic(paramString);
      localObject = z.aTY();
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
  
  public static int a(final String paramString1, final anb paramanb, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    AppMethodBeat.i(9528);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      AppMethodBeat.o(9528);
      return -1;
    }
    if ((paramanb == null) || (paramanb.ppH.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      AppMethodBeat.o(9528);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramanb);
    final ca localca = new ca();
    paramString2 = null;
    if (!Util.isNullOrNil(paramString4))
    {
      paramString2 = Util.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 65536) {
          break label365;
        }
      }
    }
    long l;
    label365:
    for (paramString2 = com.tencent.mm.av.q.bcR().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.av.q.bcR().ap(paramString2))
    {
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + paramString2);
      if (!Util.isNullOrNil(paramString2)) {
        localca.Cz(paramString2);
      }
      localca.setContent(k.b.a(paramString3, null, null));
      localca.setStatus(1);
      localca.Cy(paramString1);
      localca.setCreateTime(bp.Kw(paramString1));
      localca.nv(1);
      localca.setType(49);
      if (com.tencent.mm.al.g.DQ(paramString1)) {
        localca.BB(com.tencent.mm.al.a.e.ajw());
      }
      l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label376;
      }
      Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
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
      paramString2 = BitmapUtil.Bitmap2Bytes(com.tencent.mm.aj.c.a(paramString5, false, -1, null));
      break;
    }
    label376:
    Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
    localca.setMsgId(l);
    paramString2 = new com.tencent.mm.ag.k();
    paramString2.field_xml = localca.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    paramString2.field_appId = paramString3.appId;
    com.tencent.mm.plugin.r.a.eAT().insert(paramString2);
    paramString2 = paramanb.ppH.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (aml)paramString2.next();
    } while ((Util.isNullOrNil(paramString4.KuR)) && (Util.isNullOrNil(paramString4.iwX)));
    paramString2 = b(paramString1, paramanb);
    if (paramString2.size() > 0) {
      com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.pluginsdk.g.a(paramString2, new a.a()
      {
        public final void bS(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(215188);
          if (paramAnonymousInt == 0)
          {
            p.d(this.dnZ, paramString1.getTitle(), paramString1.getDescription(), paramanb, localca);
            AppMethodBeat.o(215188);
            return;
          }
          if (-3200 == paramAnonymousInt)
          {
            Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.dnZ), paramanb });
            p.c(this.dnZ, this.iBF);
            p.b(this.dnZ, this.iBF, paramanb);
            ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).C(this.dnZ, paramanb);
            AppMethodBeat.o(215188);
            return;
          }
          this.iBF.setStatus(5);
          ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.dnZ, this.iBF);
          p.dZ(paramanb, paramAnonymousString);
          AppMethodBeat.o(215188);
        }
      }), 0);
    }
    for (;;)
    {
      AppMethodBeat.o(9528);
      return 0;
      b(l, paramString3.getTitle(), paramString3.getDescription(), paramString1, paramanb);
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
      Object localObject1 = bp.Kt(paramca.field_content);
      final k.b localb = k.b.HD((String)localObject1);
      if (localb == null)
      {
        Log.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        AppMethodBeat.o(9526);
        return -1;
      }
      final com.tencent.mm.protocal.b.a.c localc = aKY(localb.ixl);
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
        localObject2 = Util.readFromFile(com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true));
        localObject2 = com.tencent.mm.av.q.bcR().ap((byte[])localObject2);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData from msg MsgInfo path:" + (String)localObject2);
        if (!Util.isNullOrNil((String)localObject2)) {
          localca.Cz((String)localObject2);
        }
      }
      localca.setContent((String)localObject1);
      localca.setStatus(1);
      localca.Cy(str);
      localca.setCreateTime(bp.Kw(str));
      localca.nv(1);
      localca.setType(49);
      long l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
      Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
        int i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(9526);
        return 0 - i;
      }
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      localObject1 = new yl();
      ((yl)localObject1).eeI.eeJ = paramca.field_msgId;
      ((yl)localObject1).eeI.eeK = l;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new com.tencent.mm.ag.k();
      ((com.tencent.mm.ag.k)localObject1).field_xml = localca.field_content;
      ((com.tencent.mm.ag.k)localObject1).field_title = localb.title;
      ((com.tencent.mm.ag.k)localObject1).field_type = localb.type;
      ((com.tencent.mm.ag.k)localObject1).field_description = localb.description;
      ((com.tencent.mm.ag.k)localObject1).field_msgId = l;
      ((com.tencent.mm.ag.k)localObject1).field_appId = localb.appId;
      com.tencent.mm.plugin.r.a.eAT().insert((IAutoDBItem)localObject1);
      if (k(localc.iAd, paramBoolean))
      {
        localObject1 = new anb();
        ((anb)localObject1).ppH.addAll(localc.iAd);
        localObject2 = b(str, (anb)localObject1);
        if (((List)localObject2).size() > 0) {
          com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.pluginsdk.g.a((List)localObject2, new a.a()
          {
            public final void bS(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(215187);
              if (paramAnonymousInt == 0)
              {
                p.b(this.dnZ, str.field_msgId, localb, localc, this.BHe, paramBoolean, localca);
                AppMethodBeat.o(215187);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                Log.w("MicroMsg.RecordMsgLogic", "errcode equals %s, errMsg:%s, msgId:%s, toUser:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Long.valueOf(this.dnZ), localb });
                p.c(this.dnZ, this.iBF);
                p.a(this.dnZ, str.field_msgId, this.iBF, localb, localca);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).C(this.dnZ, localb);
                AppMethodBeat.o(215187);
                return;
              }
              this.iBF.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.dnZ, this.iBF);
              p.dZ(localb, paramAnonymousString);
              AppMethodBeat.o(215187);
            }
          }), 0);
        }
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramString2)) {
          break label785;
        }
        com.tencent.mm.plugin.messenger.a.g.eir().ad(str, paramString2, ab.JG(str));
        break;
        a(l, paramca.field_msgId, str, localb, localc, (anb)localObject1, paramBoolean);
        continue;
        Log.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(l);
      }
    }
    AppMethodBeat.o(9526);
    return 0;
  }
  
  public static Pair<Long, Boolean> a(Context paramContext, final String paramString1, final String paramString2, List<ca> paramList, cz paramcz, com.tencent.mm.protocal.b.a.d paramd, String paramString3)
  {
    AppMethodBeat.i(215194);
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(215194);
      return paramContext;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
      AppMethodBeat.o(215194);
      return paramContext;
    }
    if ((paramcz == null) || (paramd == null))
    {
      paramcz = new cz();
      if (!c.a(paramContext, paramcz, paramString2, paramList, -1))
      {
        paramContext = new Pair(Long.valueOf(-1L), Boolean.FALSE);
        AppMethodBeat.o(215194);
        return paramContext;
      }
      paramd = a(paramContext, paramcz, paramString2);
    }
    for (paramString2 = paramcz;; paramString2 = paramcz)
    {
      paramcz = a(paramd.title, paramd.desc, paramString2.dFZ.dGb);
      final ca localca = new ca();
      paramList = null;
      if (!Util.isNullOrNil(paramd.thumbPath))
      {
        paramContext = Util.readFromFile(paramd.thumbPath);
        if (paramContext != null) {
          if (paramContext.length <= 65536) {
            break label502;
          }
        }
      }
      long l;
      label502:
      for (paramContext = com.tencent.mm.av.q.bcR().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.av.q.bcR().ap(paramContext))
      {
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " thumbData MsgInfo path:" + paramContext);
        if (!Util.isNullOrNil(paramContext)) {
          localca.Cz(paramContext);
        }
        localca.setContent(k.b.a(paramcz, null, null));
        localca.setStatus(1);
        localca.Cy(paramString1);
        localca.setCreateTime(bp.Kw(paramString1));
        localca.nv(1);
        localca.setType(49);
        if (com.tencent.mm.al.g.DQ(paramString1)) {
          localca.BB(com.tencent.mm.al.a.e.ajw());
        }
        l = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(localca);
        Log.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + " msginfo insert id: " + l);
        if (l >= 0L) {
          break label513;
        }
        Log.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.apq() + "insert msg failed :" + l);
        paramContext = new Pair(Long.valueOf(0 - com.tencent.mm.compatible.util.f.getLine()), Boolean.FALSE);
        AppMethodBeat.o(215194);
        return paramContext;
        paramContext = paramList;
        if (paramd.dXJ != 0) {
          break;
        }
        paramContext = paramList;
        if (Util.isNullOrNil(paramd.tfO)) {
          break;
        }
        paramContext = BitmapUtil.Bitmap2Bytes(com.tencent.mm.aj.c.a(paramd.tfO, false, -1, null));
        break;
      }
      label513:
      Log.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.f.getLine() + " new msg inserted to db , local id = " + l);
      localca.setMsgId(l);
      paramContext = new com.tencent.mm.ag.k();
      paramContext.field_xml = localca.field_content;
      paramContext.field_title = paramcz.title;
      paramContext.field_type = paramcz.type;
      paramContext.field_description = paramcz.description;
      paramContext.field_msgId = l;
      paramContext.field_appId = paramcz.appId;
      com.tencent.mm.plugin.r.a.eAT().insert(paramContext);
      paramContext = paramString2.dFZ.dGb.ppH.iterator();
      for (boolean bool = false; paramContext.hasNext(); bool = true)
      {
        label636:
        paramList = (aml)paramContext.next();
        if (Util.isNullOrNil(paramList.dLl)) {
          paramList.bgs(ds(paramList.toString(), paramList.dataType));
        }
        if ((!bool) && (!s.YS(paramList.LvL)) && (!s.YS(paramList.LvN)) && (Util.isNullOrNil(paramList.KuR)) && (Util.isNullOrNil(paramList.iwX)) && (Util.isNullOrNil(paramList.LwF)) && (Util.isNullOrNil(paramList.iwO))) {
          break label636;
        }
      }
      Log.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        if ((!ab.IO(paramString1)) || (Util.isNullOrNil(paramString3))) {
          break label957;
        }
      }
      for (;;)
      {
        paramContext = b(paramString3, paramString2.dFZ.dGb);
        if (paramContext.size() > 0)
        {
          com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.pluginsdk.g.a(paramContext, new a.a()
          {
            public final void bS(int paramAnonymousInt, String paramAnonymousString)
            {
              AppMethodBeat.i(215186);
              if (paramAnonymousInt == 0)
              {
                p.c(this.dnZ, paramString1.getTitle(), paramString1.getDescription(), paramString2, localca.dFZ.dGb);
                AppMethodBeat.o(215186);
                return;
              }
              if (-3200 == paramAnonymousInt)
              {
                p.c(this.dnZ, this.iBF);
                p.a(this.dnZ, this.iBF, paramString2);
                ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).C(this.dnZ, paramString2);
                AppMethodBeat.o(215186);
                return;
              }
              this.iBF.setStatus(5);
              ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.dnZ, this.iBF);
              if (!p.a(paramString2, this.dnZ, false, paramAnonymousString)) {
                p.dZ(paramString2, paramAnonymousString);
              }
              AppMethodBeat.o(215186);
            }
          }), 0);
          if (bool) {
            break label951;
          }
        }
        label951:
        for (bool = true;; bool = false)
        {
          paramContext = new Pair(Long.valueOf(l), Boolean.valueOf(bool));
          AppMethodBeat.o(215194);
          return paramContext;
          a(l, paramcz.getTitle(), paramcz.getDescription(), paramString1, paramString2.dFZ.dGb);
          break;
          Log.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
          if (ab.IO(paramString1)) {
            break;
          }
          ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).HR(l);
          break;
        }
        label957:
        paramString3 = paramString1;
      }
    }
  }
  
  public static k.b a(String paramString1, String paramString2, anb paramanb)
  {
    AppMethodBeat.i(9520);
    LinkedList localLinkedList = paramanb.ppH;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramanb);
    localStringBuilder.append(q.dE(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(z.aTY())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramanb = new k.b();
    paramanb.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    paramanb.description = paramString1;
    if ((!Util.isNullOrNil(localLinkedList)) && (com.tencent.mm.plugin.fav.ui.l.j((aml)localLinkedList.get(0)))) {
      paramanb.type = 24;
    }
    for (paramanb.url = ("https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramanb.url = ("https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramanb.action = "view";
      paramanb.ixl = localStringBuilder.toString();
      AppMethodBeat.o(9520);
      return paramanb;
      paramanb.type = 19;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cz paramcz, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(9523);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    Object localObject2;
    if (com.tencent.mm.al.g.DQ(paramString))
    {
      locald.title = paramcz.dFZ.dGb.title;
      Log.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      paramString = new LinkedList();
      if (paramcz.dFZ.dGb == null) {
        break label453;
      }
      paramcz = paramcz.dFZ.dGb.ppH;
      localObject2 = paramcz.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1610;
      }
      Object localObject3 = (aml)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((aml)localObject3).dataType);
      ((SparseIntArray)localObject1).put(((aml)localObject3).dataType, j + 1);
      switch (((aml)localObject3).dataType)
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
          paramString.add(((aml)localObject3).Lwj + ":" + ((aml)localObject3).desc + "\n");
          continue;
          if (ab.Eq(paramString))
          {
            locald.title = paramContext.getString(2131764266);
            break;
          }
          localObject2 = z.aUa();
          paramString = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).Ir(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(2131759288, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(2131759287, new Object[] { localObject2, paramString });
          break;
          paramcz = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131756022) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755939) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131230967);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131756012) + ((aml)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689587);
          i = 1;
        }
        break;
      case 22: 
      case 23: 
      case 26: 
      case 27: 
      case 28: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131756012) + ((aml)localObject3).title + "\n");
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131756018) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131756018) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689584);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcz = ((aml)localObject3).Lwh.LwQ;
          localObject3 = new StringBuilder().append(((aml)localObject3).Lwj).append(":").append(paramContext.getString(2131755888));
          if ((!Util.isNullOrNil(paramcz.dWi)) && (!paramcz.dWi.equals(paramContext.getString(2131755888)))) {
            break label1027;
          }
        }
        for (paramcz = paramcz.label;; paramcz = paramcz.dWi)
        {
          paramString.add(paramcz + "\n");
          if (i != 0) {
            break;
          }
          locald.dXJ = 2131689565;
          i = 1;
          break;
        }
      case 7: 
      case 29: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755905) + ((aml)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689567);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755851) + ((aml)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689580);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755947) + ((aml)localObject3).Lwh.LwU.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689580);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755313) + "\n");
        }
        if (i == 0)
        {
          a(locald, (aml)localObject3, 2131689580);
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
            paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755862) + "\n");
          }
          if (i == 0)
          {
            locald.tfO = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(((aml)localObject3).desc).dkU;
            i = 1;
          }
        }
        break;
      case 17: 
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755961) + "\n");
        }
        break;
      case 19: 
        label453:
        if (paramString.size() < 5) {
          paramString.add(((aml)localObject3).Lwj + ":" + paramContext.getString(2131755314) + ((aml)localObject3).title + "\n");
        }
        label1027:
        break;
      }
    }
    label1610:
    locald.desc = "";
    paramcz = paramString.iterator();
    for (paramContext = ""; paramcz.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcz.next();
    }
    paramcz = paramContext.trim();
    paramContext = paramcz;
    if (paramString.size() >= 5) {
      paramContext = paramcz + "...";
    }
    locald.desc = paramContext;
    AppMethodBeat.o(9523);
    return locald;
  }
  
  public static String a(com.tencent.mm.protocal.b.a.c paramc, String paramString)
  {
    AppMethodBeat.i(9543);
    if ((paramc == null) || (paramc.iAd == null))
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
    amv localamv = paramc.KBr;
    if (localamv != null)
    {
      paramString.append("<noteinfo>");
      paramString.append("<noteauthor>").append(Util.escapeStringForXml(localamv.LxT)).append("</noteauthor>");
      paramString.append("<noteeditor>").append(Util.escapeStringForXml(localamv.LxU)).append("</noteeditor>");
      paramString.append("</noteinfo>");
      paramString.append("<editusr>").append(Util.escapeStringForXml(localamv.LxU)).append("</editusr>");
    }
    paramString.append("<edittime>").append(paramc.rnM).append("</edittime>");
    paramString.append(q.dE(paramc.iAd));
    paramString.append("<favusername>").append(Util.escapeStringForXml(paramc.BGs)).append("</favusername>");
    paramString.append("</recordinfo>");
    paramc = paramString.toString();
    AppMethodBeat.o(9543);
    return paramc;
  }
  
  public static String a(aml paramaml, long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(9532);
    if (paramaml == null)
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject1 = fj(paramaml.dLl, paramInt);
    if ((Util.isNullOrNil((String)localObject1)) || (!MMApplicationContext.isMMProcess()) || (!com.tencent.mm.kernel.g.aAc()))
    {
      AppMethodBeat.o(9532);
      return "";
    }
    Object localObject2 = HU(paramLong);
    Object localObject3;
    if ((paramaml.dataType == 8) && (!Util.isNullOrNil(paramaml.title)))
    {
      localObject3 = paramaml.title;
      paramInt = paramaml.dLl.hashCode();
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.g.aAi();
      o localo = new o(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.kernel.g.aAh().hqG + "record/", Long.valueOf(paramLong), Integer.valueOf(paramInt & 0xFF) }));
      if (localo.exists())
      {
        paramInt = i;
        localObject2 = localo;
        localObject1 = localObject3;
        if (localo.isDirectory()) {}
      }
      else
      {
        localo.mkdirs();
        localObject1 = localObject3;
        localObject2 = localo;
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject3 = localObject1;
      if (paramaml.LvC != null)
      {
        localObject3 = localObject1;
        if (paramaml.LvC.trim().length() > 0)
        {
          localObject3 = localObject1;
          if (paramInt == 0) {
            localObject3 = (String)localObject1 + "." + paramaml.LvC;
          }
        }
      }
      paramaml = aa.z(new o((o)localObject2, (String)localObject3).her());
      AppMethodBeat.o(9532);
      return paramaml;
    }
  }
  
  public static String a(String paramString1, String paramString2, anb paramanb, String paramString3, long paramLong)
  {
    AppMethodBeat.i(9519);
    if ((paramanb == null) || (paramanb.ppH == null))
    {
      Log.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
      AppMethodBeat.o(9519);
      return "";
    }
    LinkedList localLinkedList = paramanb.ppH;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(Util.escapeStringForXml(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(Util.escapeStringForXml(paramString2)).append("</desc>");
    a(localStringBuilder, paramanb);
    localStringBuilder.append(q.dE(localLinkedList));
    localStringBuilder.append("<favusername>").append(Util.escapeStringForXml(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramanb = new k.b();
    paramanb.title = paramString1;
    paramanb.description = paramString2;
    if ((localLinkedList.size() > 0) && (com.tencent.mm.plugin.fav.ui.l.j((aml)localLinkedList.get(0)))) {
      paramanb.type = 24;
    }
    for (paramanb.url = ("https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008");; paramanb.url = ("https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0"))
    {
      paramanb.action = "view";
      paramanb.ixl = localStringBuilder.toString();
      paramString1 = com.tencent.mm.plugin.r.a.eAT().GL(paramLong);
      if (paramString1 != null) {
        paramanb.appId = paramString1.field_appId;
      }
      paramString1 = k.b.a(paramanb, null, null);
      AppMethodBeat.o(9519);
      return paramString1;
      paramanb.type = 19;
    }
  }
  
  private static void a(long paramLong1, long paramLong2, String paramString, k.b paramb, com.tencent.mm.protocal.b.a.c paramc, anb paramanb, boolean paramBoolean)
  {
    AppMethodBeat.i(215192);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong1;
    localk.field_oriMsgId = paramLong2;
    localk.field_toUser = paramString;
    localk.field_title = paramb.title;
    localk.field_desc = Util.nullAs(paramc.desc, paramb.description);
    localk.field_dataProto = paramanb;
    localk.field_type = 0;
    localk.field_favFrom = paramc.BGs;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Normal RecordMsgStorage insert ret:%b, id:%d, oriMsgId:%d localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk, paramBoolean);
    AppMethodBeat.o(215192);
  }
  
  private static void a(long paramLong, String paramString1, String paramString2, String paramString3, anb paramanb)
  {
    AppMethodBeat.i(215191);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramanb;
    localk.field_type = 3;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Download RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(215191);
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, aml paramaml, int paramInt)
  {
    AppMethodBeat.i(9524);
    paramaml = paramaml.LvN;
    if (s.YS(paramaml))
    {
      paramd.thumbPath = paramaml;
      AppMethodBeat.o(9524);
      return;
    }
    paramd.dXJ = paramInt;
    AppMethodBeat.o(9524);
  }
  
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    AppMethodBeat.i(9542);
    paramc.iAd.clear();
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
          break label5724;
        }
        NodeList localNodeList = paramString.item(0).getChildNodes();
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label5724;
        }
        int k = localNodeList.getLength();
        i = 0;
        if (i >= k) {
          break label5724;
        }
        localObject1 = localNodeList.item(i);
        paramString = XmlParser.nodeToString((Node)localObject1);
        if (!(localObject1 instanceof Element)) {
          break label5742;
        }
        localObject1 = ((Element)localObject1).getElementsByTagName("recordxml");
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label5736;
        }
        localObject1 = ((NodeList)localObject1).item(0).getChildNodes();
        if ((localObject1 == null) || (((NodeList)localObject1).getLength() <= 0)) {
          break label5736;
        }
        int m = ((NodeList)localObject1).getLength();
        j = 0;
        if (j >= m) {
          break label5736;
        }
        localObject2 = ((NodeList)localObject1).item(j);
        if (!(localObject2 instanceof Element)) {
          break label5749;
        }
        localObject1 = XmlParser.nodeToString((Node)localObject2);
        Log.d("MicroMsg.RecordMsgLogic", "recordXml: %s", new Object[] { localObject1 });
        if (!paramString.trim().startsWith("<dataitem")) {
          break label5731;
        }
        paramString = XmlParser.parseXml(paramString, "dataitem", null);
        if (paramString == null) {
          paramString = null;
        }
        try
        {
          if ((paramString.dataType == 1) && (paramString.desc != null)) {
            paramString.bgg(paramString.desc.replaceAll("‮", ""));
          }
          paramc.iAd.add(paramString);
        }
        catch (Exception paramString)
        {
          aml localaml;
          Object localObject4;
          Object localObject7;
          Object localObject6;
          Object localObject5;
          LinkedList localLinkedList;
          Log.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[] { paramString.getMessage() });
          Log.printErrStackTrace("MicroMsg.RecordMsgLogic", paramString, "", new Object[0]);
          paramc.iAd.clear();
        }
        localaml = new aml();
        localaml.ajd(Util.getInt((String)paramString.get(".dataitem" + ".$datatype"), 0));
        localaml.bgx((String)paramString.get(".dataitem" + ".$datasourceid"));
        localaml.aje(Util.getInt((String)paramString.get(".dataitem" + ".$datastatus"), 0));
        localaml.bgp((String)paramString.get(".dataitem" + ".datafmt"));
        localaml.bgf((String)paramString.get(".dataitem" + ".datatitle"));
        localaml.bgg((String)paramString.get(".dataitem" + ".datadesc"));
        localaml.bgh((String)paramString.get(".dataitem" + ".cdnthumburl"));
        localaml.bgi((String)paramString.get(".dataitem" + ".cdnthumbkey"));
        localaml.aja(Util.getInt((String)paramString.get(".dataitem" + ".thumbwidth"), 0));
        localaml.ajb(Util.getInt((String)paramString.get(".dataitem" + ".thumbheight"), 0));
        localaml.bgj((String)paramString.get(".dataitem" + ".cdndataurl"));
        localaml.bgk((String)paramString.get(".dataitem" + ".cdndatakey"));
        localaml.iwO = ((String)paramString.get(".dataitem" + ".tpthumburl"));
        localaml.LwB = true;
        localaml.bgG((String)paramString.get(".dataitem" + ".tpaeskey"));
        localaml.bgH((String)paramString.get(".dataitem" + ".tpauthkey"));
        localaml.bgI((String)paramString.get(".dataitem" + ".tpdataurl"));
        localaml.iwU = ((String)paramString.get(".dataitem" + ".tpthumbaeskey"));
        localaml.LwH = true;
        localObject2 = (String)paramString.get(".dataitem" + ".duration");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          localaml.ajc(Util.getInt((String)localObject2, 0));
        }
        localaml.bgm((String)paramString.get(".dataitem" + ".streamdataurl"));
        localaml.bgn((String)paramString.get(".dataitem" + ".streamlowbandurl"));
        localaml.bgl((String)paramString.get(".dataitem" + ".streamweburl"));
        localaml.bgq((String)paramString.get(".dataitem" + ".fullmd5"));
        localaml.bgr((String)paramString.get(".dataitem" + ".head256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".datasize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localaml.Mu(Util.getInt((String)localObject2, 0));
        }
        localaml.bgo((String)paramString.get(".dataitem" + ".dataext"));
        localaml.bgv((String)paramString.get(".dataitem" + ".thumbfullmd5"));
        localaml.bgw((String)paramString.get(".dataitem" + ".thumbhead256md5"));
        localObject2 = (String)paramString.get(".dataitem" + ".thumbsize");
        if (!Util.isNullOrNil((String)localObject2)) {
          localaml.Mv(Util.getInt((String)localObject2, 0));
        }
        localaml.bgy((String)paramString.get(".dataitem" + ".streamvideoid"));
        localObject3 = (String)paramString.get(".dataitem" + ".$dataid");
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject2 = String.valueOf(i);
        }
        localaml.bgs((String)localObject2);
        localObject2 = (String)paramString.get(".dataitem" + ".$htmlid");
        if (!Util.isNullOrNil((String)localObject2)) {
          localaml.bgC((String)localObject2);
        }
        localaml.ajf(Util.getInt((String)paramString.get(".dataitem" + ".$dataillegaltype"), 0));
        localaml.bgz((String)paramString.get(".dataitem" + ".sourcetitle"));
        localaml.bgA((String)paramString.get(".dataitem" + ".sourcename"));
        localaml.bgJ((String)paramString.get(".dataitem" + ".sourcedesc"));
        localaml.bgK((String)paramString.get(".dataitem" + ".sourceheadurl"));
        localaml.bgB((String)paramString.get(".dataitem" + ".sourcetime"));
        localaml.bgD((String)paramString.get(".dataitem" + ".statextstr"));
        if (localObject1 != null) {
          localaml.bgF((String)localObject1);
        }
        localaml.bgL((String)paramString.get(".dataitem" + ".songalbumurl"));
        localaml.bgM((String)paramString.get(".dataitem" + ".songlyric"));
        localaml.bgN((String)paramString.get(".dataitem" + ".messageuuid"));
        localObject2 = new amm();
        localObject1 = new amn();
        ((amn)localObject1).ajh(Util.getInt((String)paramString.get(".dataitem" + ".$sourcetype"), 0));
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.fromusr");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((amn)localObject1).bgO((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[] { ((amn)localObject1).dRL });
        }
        localObject3 = (String)paramString.get(".dataitem" + ".dataitemsource.realchatname");
        if (!Util.isNullOrNil((String)localObject3))
        {
          ((amn)localObject1).bgR((String)localObject3);
          Log.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[] { ((amn)localObject1).LxA });
        }
        ((amn)localObject1).bgT((String)paramString.get(".dataitem" + ".appid"));
        ((amn)localObject1).bgU((String)paramString.get(".dataitem" + ".link"));
        ((amn)localObject1).bgV((String)paramString.get(".dataitem" + ".brandid"));
        ((amm)localObject2).c((amn)localObject1);
        localObject3 = ".dataitem" + ".locitem";
        if (!paramString.containsKey(localObject3))
        {
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject3 });
          localObject1 = ".dataitem" + ".weburlitem";
          if (paramString.containsKey(localObject1)) {
            break label4549;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          ((amm)localObject2).c(com.tencent.mm.plugin.i.a.l.x(".dataitem", paramString));
          ((amm)localObject2).e(com.tencent.mm.plugin.i.a.l.v(".dataitem", paramString));
          localObject1 = new bcl();
          localObject3 = ".dataitem" + ".finderTopicShareItem";
          if (paramString.isEmpty()) {
            break label4753;
          }
          ((bcl)localObject1).dST = Util.nullAsNil((String)paramString.get((String)localObject3 + ".topic"));
          ((bcl)localObject1).tvC = Util.getInt((String)paramString.get((String)localObject3 + ".topicType"), -1);
          ((bcl)localObject1).iconUrl = Util.nullAsNil((String)paramString.get((String)localObject3 + ".iconUrl"));
          ((bcl)localObject1).desc = Util.nullAsNil((String)paramString.get((String)localObject3 + ".desc"));
          ((bcl)localObject1).LLC = Util.nullAsNil((String)paramString.get((String)localObject3 + ".patMusicId"));
          localObject4 = new bcg();
          ((bcg)localObject4).LIb = ((String)paramString.get((String)localObject3 + ".location.poiClassifyId"));
          ((bcg)localObject4).dTj = Util.getFloat((String)paramString.get((String)localObject3 + ".location.longitude"), 0.0F);
          ((bcg)localObject4).latitude = Util.getFloat((String)paramString.get((String)localObject3 + ".location.latitude"), 0.0F);
          ((bcl)localObject1).LLB = ((bcg)localObject4);
          if (paramString.get((String)localObject3 + ".event.topicId") != null)
          {
            localObject4 = new aoi();
            ((aoi)localObject4).LAp = Util.nullAsNil((String)paramString.get((String)localObject3 + ".event.topicId"));
            ((aoi)localObject4).LAq = Util.nullAsNil((String)paramString.get((String)localObject3 + ".event.topicEventName"));
            ((aoi)localObject4).LAr = Util.nullAsNil((String)paramString.get((String)localObject3 + ".event.creatorNickName"));
            ((bcl)localObject1).LLD = ((aoi)localObject4);
          }
          ((amm)localObject2).c((bcl)localObject1);
          localObject1 = new bci();
          localObject3 = ".dataitem" + ".finderShareNameCard";
          if (paramString.isEmpty()) {
            break label4795;
          }
          ((bci)localObject1).username = Util.nullAsNil((String)paramString.get((String)localObject3 + ".username"));
          ((bci)localObject1).nickname = Util.nullAsNil((String)paramString.get((String)localObject3 + ".nickname"));
          ((bci)localObject1).uNR = Util.nullAsNil((String)paramString.get((String)localObject3 + ".avatar"));
          ((bci)localObject1).wDX = Util.nullAsNil((String)paramString.get((String)localObject3 + ".authJob"));
          ((bci)localObject1).wDY = Util.getInt((String)paramString.get((String)localObject3 + ".authIcon"), -1);
          ((amm)localObject2).a((bci)localObject1);
          localObject3 = new bcf();
          localObject4 = ".dataitem" + ".finderContentColumnSharedItem";
          if (paramString.isEmpty()) {
            break label4832;
          }
          ((bcf)localObject3).tVe = new com.tencent.mm.bw.b(Base64.decode(Util.nullAsNil((String)paramString.get((String)localObject4 + ".cardbuffer")), 0));
          localObject1 = Util.nullAsNil((String)paramString.get((String)localObject4 + ".iconUrl"));
          localObject7 = Util.nullAsNil((String)paramString.get((String)localObject4 + ".iconUrl_1"));
          localObject6 = Util.nullAsNil((String)paramString.get((String)localObject4 + ".iconUrl_2"));
          localObject5 = Util.nullAsNil((String)paramString.get((String)localObject4 + ".iconUrl_3"));
          localObject1 = ((String)localObject1).split("&token");
          ((bcf)localObject3).LLt.add(localObject1[0]);
          localLinkedList = ((bcf)localObject3).LLu;
          if (localObject1.length <= 1) {
            break label5756;
          }
          localObject1 = "&token" + localObject1[1];
          localLinkedList.add(localObject1);
          localObject1 = ((String)localObject7).split("&token");
          ((bcf)localObject3).LLt.add(localObject1[0]);
          localObject7 = ((bcf)localObject3).LLu;
          if (localObject1.length <= 1) {
            break label5763;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject7).add(localObject1);
          localObject1 = ((String)localObject6).split("&token");
          ((bcf)localObject3).LLt.add(localObject1[0]);
          localObject6 = ((bcf)localObject3).LLu;
          if (localObject1.length <= 1) {
            break label5770;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject6).add(localObject1);
          localObject1 = ((String)localObject5).split("&token");
          ((bcf)localObject3).LLt.add(localObject1[0]);
          localObject5 = ((bcf)localObject3).LLu;
          if (localObject1.length <= 1) {
            break label5777;
          }
          localObject1 = "&token" + localObject1[1];
          ((LinkedList)localObject5).add(localObject1);
          ((bcf)localObject3).cardId = Util.nullAsNil((String)paramString.get((String)localObject4 + ".cardId"));
          ((bcf)localObject3).title = Util.nullAsNil((String)paramString.get((String)localObject4 + ".title"));
          ((bcf)localObject3).oqZ = Util.nullAsNil((String)paramString.get((String)localObject4 + ".secondTitle"));
          ((amm)localObject2).c((bcf)localObject3);
          localObject1 = ".dataitem" + ".productitem";
          if (paramString.containsKey(localObject1)) {
            break label4862;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".tvitem";
          if (paramString.containsKey(localObject1)) {
            break label5066;
          }
          Log.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".appbranditem";
          if (paramString.containsKey(localObject1)) {
            break label5230;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".weburlitem.appmsgshareitem";
          if (paramString.containsKey(localObject1)) {
            break label5694;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          localObject1 = ".dataitem" + ".favbrandmpvideo";
          if (paramString.containsKey(localObject1)) {
            break label5709;
          }
          Log.v("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[] { localObject1 });
          ((amm)localObject2).e(ak.C(".dataitem", paramString));
          localaml.a((amm)localObject2);
          paramString = localaml;
          continue;
        }
        localObject1 = new ams();
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".label"))) {
          ((ams)localObject1).bgW((String)paramString.get((String)localObject3 + ".label"));
        }
        if (!Util.isNullOrNil((String)paramString.get((String)localObject3 + ".poiname"))) {
          ((ams)localObject1).bgX((String)paramString.get((String)localObject3 + ".poiname"));
        }
        localObject4 = (String)paramString.get((String)localObject3 + ".lng");
        if (!Util.isNullOrNil((String)localObject4)) {
          ((ams)localObject1).B(Util.getDouble((String)localObject4, 0.0D));
        }
        localObject4 = (String)paramString.get((String)localObject3 + ".lat");
        if (!Util.isNullOrNil((String)localObject4)) {
          ((ams)localObject1).C(Util.getDouble((String)localObject4, 0.0D));
        }
        localObject3 = (String)paramString.get((String)localObject3 + ".scale");
        if (!Util.isNullOrNil((String)localObject3))
        {
          if (((String)localObject3).indexOf('.') != -1) {
            ((ams)localObject1).aji(Util.getInt(((String)localObject3).substring(0, ((String)localObject3).indexOf('.')), -1));
          }
        }
        else
        {
          ((amm)localObject2).c((ams)localObject1);
          continue;
        }
        ((ams)localObject1).aji(Util.getInt((String)localObject3, -1));
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[] { paramString.toString() });
        AppMethodBeat.o(9542);
        return;
      }
      continue;
      label4549:
      Object localObject3 = new anq();
      ((anq)localObject3).bhs((String)paramString.get((String)localObject1 + ".title"));
      ((anq)localObject3).bht((String)paramString.get((String)localObject1 + ".desc"));
      ((anq)localObject3).bhv((String)paramString.get((String)localObject1 + ".thumburl"));
      ((anq)localObject3).bhu((String)paramString.get((String)localObject1 + ".link"));
      ((anq)localObject3).ajn(Util.getInt((String)paramString.get((String)localObject1 + ".opencache"), 0));
      ((amm)localObject2).a((anq)localObject3);
      continue;
      label4753:
      ((bcl)localObject1).dST = "";
      ((bcl)localObject1).tvC = -1;
      ((bcl)localObject1).iconUrl = "";
      ((bcl)localObject1).desc = "";
      ((bcl)localObject1).LLB = new bcg();
      continue;
      label4795:
      ((bci)localObject1).username = "";
      ((bci)localObject1).nickname = "";
      ((bci)localObject1).uNR = "";
      ((bci)localObject1).wDX = "";
      ((bci)localObject1).wDY = -1;
      continue;
      label4832:
      ((bcf)localObject3).cardId = "";
      ((bcf)localObject3).title = "";
      ((bcf)localObject3).oqZ = "";
      ((bcf)localObject3).tVe = null;
      continue;
      label4862:
      localObject3 = new ana();
      ((ana)localObject3).bgY((String)paramString.get((String)localObject1 + ".title"));
      ((ana)localObject3).bgZ((String)paramString.get((String)localObject1 + ".desc"));
      ((ana)localObject3).bha((String)paramString.get((String)localObject1 + ".thumburl"));
      ((ana)localObject3).bhb((String)paramString.get((String)localObject1 + ".productinfo"));
      ((ana)localObject3).ajj(Util.getInt((String)paramString.get((String)localObject1 + ".$type"), 0));
      ((amm)localObject2).a((ana)localObject3);
      continue;
      label5066:
      localObject3 = new ank();
      ((ank)localObject3).bho((String)paramString.get((String)localObject1 + ".title"));
      ((ank)localObject3).bhp((String)paramString.get((String)localObject1 + ".desc"));
      ((ank)localObject3).bhq((String)paramString.get((String)localObject1 + ".thumburl"));
      ((ank)localObject3).bhr((String)paramString.get((String)localObject1 + ".tvinfo"));
      ((amm)localObject2).a((ank)localObject3);
      continue;
      label5230:
      localObject3 = new amj();
      ((amj)localObject3).username = ((String)paramString.get((String)localObject1 + ".username"));
      ((amj)localObject3).appId = ((String)paramString.get((String)localObject1 + ".appid"));
      ((amj)localObject3).dMe = Util.getInt((String)paramString.get((String)localObject1 + ".pkgtype"), 0);
      ((amj)localObject3).iconUrl = ((String)paramString.get((String)localObject1 + ".iconurl"));
      ((amj)localObject3).type = Util.getInt((String)paramString.get((String)localObject1 + ".type"), 0);
      ((amj)localObject3).dCx = ((String)paramString.get((String)localObject1 + ".pagepath"));
      ((amj)localObject3).Lve = ((String)paramString.get((String)localObject1 + ".sourcedisplayname"));
      ((amj)localObject3).version = Util.getInt((String)paramString.get((String)localObject1 + ".version"), 0);
      ((amj)localObject3).lyE = Util.getInt((String)paramString.get((String)localObject1 + ".disableforward"), 0);
      ((amj)localObject3).leb = Util.getInt((String)paramString.get((String)localObject1 + ".tradingguaranteeflag"), 0);
      ((amj)localObject3).eda = ((String)paramString.get((String)localObject1 + ".messageextradata"));
      ((amj)localObject3).subType = Util.getInt((String)paramString.get((String)localObject1 + ".subtype"), 0);
      ((amm)localObject2).b((amj)localObject3);
      continue;
      label5694:
      ((amm)localObject2).d(com.tencent.mm.plugin.fav.a.a.b.t((String)localObject1, paramString));
      continue;
      label5709:
      ((amm)localObject2).e(com.tencent.mm.plugin.fav.a.a.b.u((String)localObject1, paramString));
      continue;
      label5724:
      AppMethodBeat.o(9542);
      return;
      label5731:
      paramString = null;
      continue;
      label5736:
      localObject1 = null;
      continue;
      label5742:
      i += 1;
      continue;
      label5749:
      j += 1;
      continue;
      label5756:
      localObject1 = "";
      continue;
      label5763:
      localObject1 = "";
      continue;
      label5770:
      localObject1 = "";
      continue;
      label5777:
      localObject1 = "";
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, anb paramanb)
  {
    AppMethodBeat.i(9521);
    if (paramanb.KBr != null)
    {
      paramStringBuilder.append("<noteinfo>");
      paramStringBuilder.append("<noteauthor>").append(Util.escapeStringForXml(paramanb.KBr.LxT)).append("</noteauthor>");
      paramStringBuilder.append("<noteeditor>").append(Util.escapeStringForXml(paramanb.KBr.LxU)).append("</noteeditor>");
      paramStringBuilder.append("</noteinfo>");
      paramStringBuilder.append("<edittime>").append(paramanb.rnM).append("</edittime>");
      paramStringBuilder.append("<editusr>").append(Util.escapeStringForXml(paramanb.KBr.LxU)).append("</editusr>");
    }
    AppMethodBeat.o(9521);
  }
  
  public static boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(215196);
    if (ab.IO(paramString1))
    {
      paramString1 = new rb();
      paramString1.dXE.msgId = paramLong;
      paramString1.dXE.dQA = paramBoolean;
      paramString1.dXE.errMsg = Util.nullAs(paramString2, "");
      EventCenter.instance.publish(paramString1);
      AppMethodBeat.o(215196);
      return true;
    }
    AppMethodBeat.o(215196);
    return false;
  }
  
  public static com.tencent.mm.protocal.b.a.c aKY(String paramString)
  {
    AppMethodBeat.i(9541);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.RecordMsgLogic", "xml is null");
      AppMethodBeat.o(9541);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)gAU.get(Integer.valueOf(i));
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
    localc.BGs = ((String)((Map)localObject).get(".recordinfo.favusername"));
    if (((Map)localObject).get(".recordinfo.noteinfo") != null)
    {
      amv localamv = new amv();
      localamv.LxU = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteeditor"));
      localamv.LxT = ((String)((Map)localObject).get(".recordinfo.noteinfo.noteauthor"));
      localc.KBr = localamv;
      localc.rnM = Util.getLong((String)((Map)localObject).get(".recordinfo.edittime"), 0L);
    }
    a(paramString, localc);
    gAU.put(Integer.valueOf(i), localc);
    AppMethodBeat.o(9541);
    return localc;
  }
  
  public static String arI(String paramString)
  {
    AppMethodBeat.i(9538);
    paramString = paramString + "_t";
    AppMethodBeat.o(9538);
    return paramString;
  }
  
  public static String b(aml paramaml, long paramLong, int paramInt)
  {
    AppMethodBeat.i(9536);
    if ((paramaml == null) || (Util.isNullOrNil(paramaml.dLl)))
    {
      AppMethodBeat.o(9536);
      return "";
    }
    paramaml = fj(arI(paramaml.dLl), paramInt);
    paramaml = aa.z(new o(HU(paramLong), paramaml).her());
    AppMethodBeat.o(9536);
    return paramaml;
  }
  
  private static List<a.b> b(String paramString, anb paramanb)
  {
    AppMethodBeat.i(215189);
    List localList = Collections.synchronizedList(new ArrayList());
    if (paramanb != null)
    {
      Iterator localIterator = paramanb.ppH.iterator();
      while (localIterator.hasNext())
      {
        aml localaml = (aml)localIterator.next();
        if (localaml.LvI > 26214400L)
        {
          a.b localb = new a.b();
          String str = localaml.LvL;
          paramanb = s.bhK(str);
          localb.filePath = str;
          localb.toUser = paramString;
          localb.fileSize = localaml.LvI;
          localb.gCr = localaml.LvC;
          if (Util.isNullOrNil(localaml.LvE)) {}
          for (;;)
          {
            localb.pkL = paramanb;
            localb.aesKey = localaml.Lvp;
            localb.fileName = localaml.title;
            localList.add(localb);
            break;
            paramanb = localaml.LvE;
          }
        }
      }
    }
    AppMethodBeat.o(215189);
    return localList;
  }
  
  private static void b(long paramLong, String paramString1, String paramString2, String paramString3, anb paramanb)
  {
    AppMethodBeat.i(215193);
    com.tencent.mm.plugin.record.a.k localk = new com.tencent.mm.plugin.record.a.k();
    localk.field_msgId = paramLong;
    localk.field_title = paramString1;
    localk.field_desc = paramString2;
    localk.field_toUser = paramString3;
    localk.field_dataProto = paramanb;
    localk.field_type = 1;
    localk.field_localId = (new Random().nextInt(2147483645) + 1);
    Log.i("MicroMsg.RecordMsgLogic", "summerrecord Fav RecordMsgStorage insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgStorage().insert(localk)), Long.valueOf(paramLong), Integer.valueOf(localk.field_localId) });
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgService().a(localk);
    AppMethodBeat.o(215193);
  }
  
  public static boolean b(aml paramaml, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9544);
    if (paramaml == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      AppMethodBeat.o(9544);
      return false;
    }
    String str = g(paramaml.dLl, paramLong, true);
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str);
    if (localObject == null)
    {
      j localj = new j();
      localj.field_cdnKey = paramaml.Lvp;
      localj.field_cdnUrl = paramaml.KuR;
      localj.field_dataId = paramaml.dLl;
      localj.field_mediaId = str;
      localj.field_totalLen = ((int)paramaml.LvI);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = a(paramaml, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = hR(paramaml.dataType, (int)paramaml.LvI);
      localj.field_isThumb = false;
      localj.field_tpaeskey = paramaml.LwC;
      localj.field_tpauthkey = paramaml.iwT;
      localj.field_tpdataurl = paramaml.LwF;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
      localObject = localj;
      if (!Util.isNullOrNil(paramaml.Lwp))
      {
        localObject = localj;
        if (paramaml.Lwp.equals("WeNoteHtmlFile"))
        {
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().a(localj);
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
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b((j)localObject, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9544);
        return true;
      }
      AppMethodBeat.o(9544);
      return false;
    }
  }
  
  public static String c(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(9533);
    paramaml = a(paramaml, paramLong, 1);
    AppMethodBeat.o(9533);
    return paramaml;
  }
  
  public static boolean c(aml paramaml, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(9546);
    if (paramaml == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      AppMethodBeat.o(9546);
      return false;
    }
    String str1 = arI(paramaml.dLl);
    String str2 = g(str1, paramLong, true);
    j localj = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(str2);
    if (localj == null)
    {
      localj = new j();
      localj.field_cdnKey = paramaml.Lvk;
      localj.field_cdnUrl = paramaml.iwX;
      localj.field_dataId = str1;
      localj.field_mediaId = str2;
      localj.field_totalLen = ((int)paramaml.LvT);
      localj.field_localId = (new Random().nextInt(2147483645) + 1);
      localj.field_path = b(paramaml, paramLong, 1);
      localj.field_type = 1;
      localj.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      localj.field_isThumb = true;
      localj.field_tpdataurl = paramaml.iwO;
      localj.field_tpauthkey = paramaml.iwT;
      localj.field_tpaeskey = paramaml.iwU;
      boolean bool = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(localj);
      Log.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localj.field_localId), Boolean.valueOf(bool) });
    }
    for (paramaml = localj;; paramaml = localj)
    {
      Log.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { paramaml });
      if (4 == paramaml.field_status)
      {
        Log.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(paramaml.field_errCode) });
        AppMethodBeat.o(9546);
        return false;
      }
      if (3 == paramaml.field_status)
      {
        Log.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(paramaml.field_errCode), Boolean.valueOf(paramBoolean) });
        if (paramBoolean)
        {
          paramaml.field_status = 1;
          ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(paramaml, new String[] { "localId" });
        }
      }
      else
      {
        ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNService().run();
        AppMethodBeat.o(9546);
        return true;
      }
      AppMethodBeat.o(9546);
      return false;
    }
  }
  
  public static boolean d(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(9534);
    boolean bool = new o(a(paramaml, paramLong, 1)).exists();
    AppMethodBeat.o(9534);
    return bool;
  }
  
  public static String ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(9529);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + paramInt + System.currentTimeMillis()).getBytes());
    AppMethodBeat.o(9529);
    return paramString;
  }
  
  public static boolean e(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(9535);
    boolean bool = new o(b(paramaml, paramLong, 1)).exists();
    AppMethodBeat.o(9535);
    return bool;
  }
  
  private static final b f(k.b paramb)
  {
    AppMethodBeat.i(215190);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse appmsg error");
      AppMethodBeat.o(215190);
      return null;
    }
    paramb = aKY(paramb.ixl);
    if (paramb == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "fixMsgContent error, parse record data error");
      AppMethodBeat.o(215190);
      return null;
    }
    anb localanb = new anb();
    localanb.ppH = new LinkedList();
    localanb.a(paramb.KBr);
    localanb.Mz(paramb.rnM);
    localanb.bhd(paramb.title);
    String str = MMApplicationContext.getContext().getString(2131755317);
    Object localObject1 = MMApplicationContext.getContext().getString(2131755851);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramb.iAd.iterator();
    aml localaml;
    while (((Iterator)localObject2).hasNext())
    {
      localaml = (aml)((Iterator)localObject2).next();
      if ((localaml.dataType == 8) && (localaml.LvI > 26214400L))
      {
        localaml.ajd(1);
        localaml.bgg(str);
        localArrayList.add((String)localObject1 + localaml.title);
        localaml.bgf(null);
        localaml.bgp(null);
        localaml.bgk(null);
        localaml.bgj(null);
        localaml.Lvr = 0;
        localaml.Lvs = true;
        localaml.Mu(str.length());
      }
      localanb.ppH.add(localaml);
    }
    localObject1 = paramb.desc.split("\n");
    localObject2 = new StringBuffer();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localaml = localObject1[i];
      String[] arrayOfString = localaml.split(":");
      if (arrayOfString.length != 2)
      {
        Log.e("MicroMsg.RecordMsgLogic", "parse str(%s) of desc(%s) fail", new Object[] { localaml, paramb.desc });
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
          ((StringBuffer)localObject2).append(localaml);
        }
      }
    }
    str = ((StringBuffer)localObject2).toString();
    str = str.substring(0, str.length() - 1);
    localanb.bhe(str);
    paramb = new b(str, paramb.BGs, localanb);
    AppMethodBeat.o(215190);
    return paramb;
  }
  
  public static String f(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(258373);
    paramaml = b(paramaml, paramLong, 1);
    AppMethodBeat.o(258373);
    return paramaml;
  }
  
  public static String fj(String paramString, int paramInt)
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
  
  public static boolean g(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(9545);
    if (paramaml == null)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      AppMethodBeat.o(9545);
      return true;
    }
    paramaml = g(paramaml.dLl, paramLong, true);
    paramaml = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(paramaml);
    if (paramaml == null)
    {
      Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      AppMethodBeat.o(9545);
      return false;
    }
    if (4 == paramaml.field_status)
    {
      Log.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramaml.field_errCode) });
      AppMethodBeat.o(9545);
      return true;
    }
    Log.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramaml.field_status) });
    AppMethodBeat.o(9545);
    return false;
  }
  
  public static boolean h(aml paramaml, long paramLong)
  {
    AppMethodBeat.i(9548);
    boolean bool = ImgUtil.isGif(a(paramaml, paramLong, 1));
    AppMethodBeat.o(9548);
    return bool;
  }
  
  public static int hR(int paramInt1, int paramInt2)
  {
    if (2 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    }
    if (4 == paramInt1) {
      return com.tencent.mm.i.a.MediaType_VIDEO;
    }
    if (paramInt2 > 26214400) {
      return com.tencent.mm.i.a.gpO;
    }
    return com.tencent.mm.i.a.MediaType_FILE;
  }
  
  private static boolean k(List<aml> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(9527);
    paramList = paramList.iterator();
    boolean bool1 = false;
    for (;;)
    {
      if (paramList.hasNext())
      {
        Object localObject = (aml)paramList.next();
        int i = ((aml)localObject).dataType;
        if ((paramBoolean) && (i == 17))
        {
          localObject = aKY(((aml)localObject).Lwx);
          if (localObject == null) {
            continue;
          }
          boolean bool2 = k(((com.tencent.mm.protocal.b.a.c)localObject).iAd, paramBoolean);
          bool1 = bool2;
          if (!bool2) {
            bool1 = bool2;
          }
        }
        else
        {
          if ((Util.isNullOrNil(((aml)localObject).KuR)) && (Util.isNullOrNil(((aml)localObject).iwX)) && (Util.isNullOrNil(((aml)localObject).LwF)) && (Util.isNullOrNil(((aml)localObject).iwO))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.p
 * JD-Core Version:    0.7.0.1
 */