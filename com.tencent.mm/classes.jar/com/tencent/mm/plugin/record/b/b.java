package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final SimpleDateFormat uZY;
  
  static
  {
    AppMethodBeat.i(9458);
    uZY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static afy a(bl parambl, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    localafy.aDs(paramb.gHA);
    localafy.aDt(paramb.gHB);
    localafy.aDr(paramb.url);
    localafy.uw(true);
    parambl = new com.tencent.mm.vfs.e(bt.by(com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true), ""));
    if (parambl.exists()) {
      localafy.aDA(q.B(parambl.fhU()));
    }
    for (;;)
    {
      localafy.aDl(paramb.title);
      localafy.aDm(paramb.description);
      localafy.VD(paramInt);
      localafy.aDK(paramb.canvasPageXml);
      AppMethodBeat.o(9454);
      return localafy;
      localafy.ux(true);
    }
  }
  
  private static afy a(bl parambl, String paramString, afz paramafz)
  {
    AppMethodBeat.i(9455);
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    localafy.VD(1);
    localafy.aDm(paramString);
    localafy.ux(true);
    localafy.uw(true);
    localafy.a(paramafz);
    localafy.aDG(a(paramafz.DhA));
    localafy.aDH(b(paramafz.DhA));
    if (com.tencent.mm.storage.af.aHH(paramafz.DhA.Did))
    {
      parambl = paramafz.DhA.Did;
      parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
      if (!bt.isNullOrNil(parambl)) {
        localafy.aDP(parambl);
      }
    }
    AppMethodBeat.o(9455);
    return localafy;
  }
  
  private static String a(aga paramaga)
  {
    AppMethodBeat.i(9448);
    String str2 = paramaga.Did;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramaga.dpv;
    }
    if (com.tencent.mm.am.a.e.xk(str1))
    {
      paramaga = com.tencent.mm.am.a.e.xm(str1);
      AppMethodBeat.o(9448);
      return paramaga;
    }
    paramaga = com.tencent.mm.model.v.sg(str1);
    AppMethodBeat.o(9448);
    return paramaga;
  }
  
  private static boolean a(Context paramContext, cs paramcs, bl parambl)
  {
    AppMethodBeat.i(9456);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    Object localObject1 = parambl.field_content;
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.rx((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localafz.DhA.aDZ(((k.b)localObject1).appId);
    localafz.DhA.aEb(((k.b)localObject1).dxz);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).CZ()))
    {
      paramContext = a(parambl, paramContext.getString(2131755785), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(parambl, paramContext.getString(2131755898), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.VD(1);
      paramContext.aDm(((k.b)localObject1).title);
      paramContext.ux(true);
      paramContext.uw(true);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.DiS += 1;
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bxS().aAL(((k.b)localObject1).dbA);
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      if (localObject2 != null) {
        paramContext.aDz(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (i.eK((String)localObject2)) {
        paramContext.aDA((String)localObject2);
      }
      paramContext.VD(2);
      paramContext.aDl(((k.b)localObject1).title);
      paramContext.aDm(((k.b)localObject1).description);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      paramContext.vr(parambl.field_msgId);
      paramContext.aDT(bk.uo(parambl.esh));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.DiT += 1;
      AppMethodBeat.o(9456);
      return true;
    case 3: 
      paramContext = a(parambl, (k.b)localObject1, 7);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      if (((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.aDR(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.aDS(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.DiX += 1;
      AppMethodBeat.o(9456);
      return true;
    case 4: 
      paramContext = a(parambl, (k.b)localObject1, 4);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      paramContext.vr(parambl.field_msgId);
      paramContext.aDT(bk.uo(parambl.esh));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.rBj += 1;
      AppMethodBeat.o(9456);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localafz.DhA.aEa(((k.b)localObject1).url);
        paramContext = a(parambl, (k.b)localObject1, 5);
        paramContext.a(localafz);
        paramContext.aDG(a(localafz.DhA));
        paramContext.aDH(b(localafz.DhA));
        if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
        {
          localObject2 = localafz.DhA.Did;
          localObject2 = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject2));
          if (!bt.isNullOrNil((String)localObject2)) {
            paramContext.aDP((String)localObject2);
          }
        }
        localObject2 = new ahd();
        if (!bt.isNullOrNil(((k.b)localObject1).title)) {
          ((ahd)localObject2).aEy(((k.b)localObject1).title);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).description)) {
          ((ahd)localObject2).aEz(((k.b)localObject1).description);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((ahd)localObject2).aEB(((k.b)localObject1).thumburl);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((ahd)localObject2).aEC(((k.b)localObject1).canvasPageXml);
        }
        if (((ahd)localObject2).computeSize() > 0)
        {
          ((ahd)localObject2).VN(1);
          localafz.a((ahd)localObject2);
        }
        paramcs.deQ.deS.mVb.add(paramContext);
        paramContext = paramcs.deQ.deT;
        paramContext.DiV += 1;
        localafz.d(m.a(parambl, (ahd)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramcs.deQ.deV = 2131758889;
      paramContext = a(parambl, paramContext.getString(2131755898), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
      paramContext = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.htg;
        localObject1 = new afy();
        ((afy)localObject1).aDG(a(localafz.DhA));
        ((afy)localObject1).aDH(b(localafz.DhA));
        ((afy)localObject1).aDD(ax(parambl));
        ((afy)localObject1).uw(true);
        ((afy)localObject1).aDl(paramContext.nickname + aj.getContext().getString(2131759007));
        ((afy)localObject1).aDm(paramContext.desc);
        ((afy)localObject1).VD(22);
        localafz.b(paramContext);
        ((afy)localObject1).a(localafz);
        paramcs.deQ.deS.mVb.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bxS().aAL(((k.b)localObject1).dbA);
      paramContext = new afy();
      if (localObject2 != null) {
        paramContext.aDz(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.aDD(ax(parambl));
      paramContext.VD(8);
      paramContext.aDv(((k.b)localObject1).gHf);
      localObject2 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (bt.isNullOrNil((String)localObject2)) {
        paramContext.ux(true);
      }
      if (i.eK((String)localObject2)) {
        paramContext.aDA((String)localObject2);
      }
      paramContext.aDl(((k.b)localObject1).title);
      paramContext.aDm(((k.b)localObject1).description);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      paramContext.vr(parambl.field_msgId);
      paramContext.vp(((k.b)localObject1).gHe);
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramContext.aDp(((k.b)localObject1).gHt);
      paramContext.aDq(((k.b)localObject1).fMw);
      paramContext.aDO(((k.b)localObject1).gHk);
      paramContext.aDM(((k.b)localObject1).fMw);
      paramContext.aDN(((k.b)localObject1).gHq);
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).dbA == null) || (((k.b)localObject1).dbA.length() == 0)) {
        paramcs.deQ.deV = 2131758886;
      }
      do
      {
        paramcs.deQ.deV = 2131758893;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.g.afC();
      } while (com.tencent.mm.kernel.g.afB().isSDCardAvailable());
      paramcs.deQ.deV = 2131758901;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
      paramContext = new agn();
      paramContext.aEe(((k.b)localObject1).title);
      paramContext.aEf(((k.b)localObject1).description);
      paramContext.VJ(((k.b)localObject1).gHD);
      paramContext.aEh(((k.b)localObject1).gHE);
      paramContext.aEg(((k.b)localObject1).thumburl);
      localafz.a(paramContext);
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.VD(10);
      paramContext.ux(true);
      paramContext.uw(true);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.DiZ += 1;
      AppMethodBeat.o(9456);
      return true;
    case 20: 
      paramContext = new agx();
      paramContext.aEu(((k.b)localObject1).title);
      paramContext.aEv(((k.b)localObject1).description);
      paramContext.aEx(((k.b)localObject1).gHH);
      paramContext.aEw(((k.b)localObject1).thumburl);
      localafz.a(paramContext);
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.VD(14);
      paramContext.ux(true);
      paramContext.uw(true);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.Djd += 1;
      AppMethodBeat.o(9456);
      return true;
    case 13: 
      paramContext = new agn();
      paramContext.aEe(((k.b)localObject1).title);
      paramContext.aEf(((k.b)localObject1).description);
      paramContext.VJ(((k.b)localObject1).gHJ);
      paramContext.aEh(((k.b)localObject1).gHK);
      paramContext.aEg(((k.b)localObject1).thumburl);
      localafz.a(paramContext);
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.VD(11);
      paramContext.ux(true);
      paramContext.uw(true);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.Dja += 1;
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(parambl, paramContext.getString(2131755833), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if (((k.b)localObject1).gJG == 3)
      {
        paramContext = a(parambl, paramContext.getString(2131755833), localafz);
        paramcs.deQ.deS.mVb.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.aDl(((k.b)localObject1).title);
      paramContext.aDm(((k.b)localObject1).description);
      paramContext.VD(19);
      localObject2 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (bt.isNullOrNil((String)localObject2)) {
        paramContext.ux(true);
      }
      if (i.eK((String)localObject2)) {
        paramContext.aDA((String)localObject2);
      }
      localObject2 = new afw();
      if (!bt.isNullOrNil(((k.b)localObject1).gJE)) {
        ((afw)localObject2).username = ((k.b)localObject1).gJE;
      }
      if (!bt.isNullOrNil(((k.b)localObject1).gJF)) {
        ((afw)localObject2).appId = ((k.b)localObject1).gJF;
      }
      if (!bt.isNullOrNil(((k.b)localObject1).gJS)) {
        ((afw)localObject2).iconUrl = ((k.b)localObject1).gJS;
      }
      ((afw)localObject2).type = ((k.b)localObject1).gJG;
      ((afw)localObject2).dkC = ((k.b)localObject1).gJQ;
      ((afw)localObject2).dbu = ((k.b)localObject1).gJD;
      ((afw)localObject2).DfP = ((k.b)localObject1).dxA;
      ((afw)localObject2).jwB = ((k.b)localObject1).gJN;
      localObject1 = (com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class);
      if (localObject1 != null)
      {
        ((afw)localObject2).cfU = ((com.tencent.mm.ai.a)localObject1).gFy;
        ((afw)localObject2).dzY = ((com.tencent.mm.ai.a)localObject1).gFA;
        ((afw)localObject2).subType = ((com.tencent.mm.ai.a)localObject1).gFB;
      }
      localafz.b((afw)localObject2);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      paramContext.vr(parambl.field_msgId);
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          paramContext.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(parambl, paramContext.getString(2131755786) + ((k.b)localObject1).title, localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).r(paramContext, true);
      if (bt.isNullOrNil((String)localObject2))
      {
        paramContext = a(parambl, paramContext.getString(2131755898), localafz);
        paramcs.deQ.deS.mVb.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(parambl, (String)localObject2 + ((k.b)localObject1).title, localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).gHI != null) && (((k.b)localObject1).gHI.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
      {
        localObject2 = new afy();
        ((afy)localObject2).aDD(ax(parambl));
        ((afy)localObject2).VD(17);
        ((afy)localObject2).ux(true);
        ((afy)localObject2).aDl(((k.b)localObject1).title);
        ((afy)localObject2).aDL(((k.b)localObject1).gHI);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new pn();
        ((pn)localObject3).dvb.type = 0;
        ((pn)localObject3).dvb.dvd = ((k.b)localObject1).gHI;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((pn)localObject3).dvc.dvl;
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).gKs.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bt.isNullOrNil(((afy)((Iterator)localObject3).next()).Dhr))
              {
                paramcs.deQ.deV = 2131758893;
                AppMethodBeat.o(9456);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label3936;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label3936:
    for (;;)
    {
      ((afy)localObject2).aDm(paramContext);
      ((afy)localObject2).a(localafz);
      ((afy)localObject2).aDG(a(localafz.DhA));
      ((afy)localObject2).aDH(b(localafz.DhA));
      ((afy)localObject2).vr(parambl.field_msgId);
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        paramContext = localafz.DhA.Did;
        paramContext = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramContext));
        if (!bt.isNullOrNil(paramContext)) {
          ((afy)localObject2).aDP(paramContext);
        }
      }
      paramcs.deQ.deS.mVb.add(localObject2);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambl, paramContext.getString(2131759036), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambl, paramContext.getString(2131755860), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
  }
  
  private static boolean a(Context paramContext, cs paramcs, bl parambl, int paramInt)
  {
    AppMethodBeat.i(9446);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131755722);
    }
    for (;;)
    {
      paramContext = a(parambl, str, localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131755839);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131755898);
      }
    }
  }
  
  public static boolean a(Context paramContext, cs paramcs, String paramString, List<bl> paramList)
  {
    AppMethodBeat.i(9445);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(9445);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bl)((Iterator)localObject1).next();
      if (bk.x((bl)localObject2)) {
        switch (((bl)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((bl)localObject2).setContent(paramContext.getString(2131755904));
          break;
        case 3: 
          ((bl)localObject2).setContent(paramContext.getString(2131755853));
          ((bl)localObject2).setType(1);
          break;
        case 43: 
          ((bl)localObject2).setContent(paramContext.getString(2131755926));
          ((bl)localObject2).setType(1);
          break;
        case 49: 
          ((bl)localObject2).setContent(paramContext.getString(2131755914));
          ((bl)localObject2).setType(1);
        }
      }
    }
    boolean bool1 = com.tencent.mm.am.f.pc(paramString);
    paramList.size();
    paramcs.deQ.deS = new ago();
    paramcs.deQ.deT = new ahc();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.am.a.e.mn(((bl)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.am.a.e.xl((String)localObject1))
      {
        paramcs.deQ.deS.aEj(paramContext.getString(2131762236));
        ad.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcs.deQ.deS.title });
      }
    }
    else
    {
      localObject1 = paramcs.deQ.deS;
      localObject2 = new agu();
      ((agu)localObject2).aEl(paramString);
      ((agu)localObject2).VM(1);
      ((agu)localObject2).vv(bt.eGO());
      ((agu)localObject2).aEn("");
      ((ago)localObject1).a((agu)localObject2);
      paramcs.deQ.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label2371;
      }
      paramString = (bl)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcs.deQ.deV = 2131758885;
      bool1 = false;
    }
    label531:
    label941:
    for (;;)
    {
      label468:
      if (bool1)
      {
        j = 1;
        break label421;
        localObject2 = com.tencent.mm.am.a.e.xo(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcs.deQ.deS.aEj(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.am.a.k)localObject2).field_userName, com.tencent.mm.am.a.e.xm((String)localObject1) }));
        break;
        if (w.pF(paramString))
        {
          paramcs.deQ.deS.aEj(paramContext.getString(2131762236));
          break;
        }
        localObject1 = bt.nullAsNil(com.tencent.mm.model.u.aqI());
        if (((String)localObject1).equals(bt.nullAsNil(com.tencent.mm.model.v.sg(paramString))))
        {
          paramcs.deQ.deS.aEj(paramContext.getString(2131758964, new Object[] { localObject1 }));
          break;
        }
        paramcs.deQ.deS.aEj(paramContext.getString(2131758963, new Object[] { com.tencent.mm.model.u.aqI(), com.tencent.mm.model.v.sg(paramString) }));
        break;
        localObject2 = bl.aI(paramString);
        bool1 = false;
        Object localObject3;
        if (((bl)localObject2).isText())
        {
          localObject3 = new afz();
          ((afz)localObject3).c(aw((bl)localObject2));
          paramList = new afy();
          paramList.aDD(ax((bl)localObject2));
          paramList.VD(1);
          if (((bl)localObject2).eMC())
          {
            paramString = aj.getContext().getString(2131762657, new Object[] { "@" }) + '\n';
            label757:
            if (((bl)localObject2).eMt()) {
              break label941;
            }
            paramList.aDm(paramString + ((du)localObject2).field_content);
          }
          for (;;)
          {
            paramList.ux(true);
            paramList.uw(true);
            paramList.a((afz)localObject3);
            paramList.aDG(a(((afz)localObject3).DhA));
            paramList.aDH(b(((afz)localObject3).DhA));
            if (com.tencent.mm.storage.af.aHH(((afz)localObject3).DhA.Did))
            {
              paramString = ((afz)localObject3).DhA.Did;
              paramString = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString));
              if (!bt.isNullOrNil(paramString)) {
                paramList.aDP(paramString);
              }
            }
            paramcs.deQ.deS.mVb.add(paramList);
            paramString = paramcs.deQ.deT;
            paramString.DiS += 1;
            bool1 = true;
            break;
            paramString = "";
            break label757;
            paramList.aDm(paramString + ((du)localObject2).field_content + "\n\n" + ((du)localObject2).field_transContent);
          }
        }
        if (((bl)localObject2).eJN())
        {
          paramList = new afz();
          paramList.c(aw((bl)localObject2));
          paramString = new afy();
          paramString.aDD(ax((bl)localObject2));
          paramString.VD(3);
          paramString.ux(true);
          paramString.uw(true);
          paramString.a(paramList);
          paramString.aDG(a(paramList.DhA));
          paramString.aDH(b(paramList.DhA));
          if (com.tencent.mm.storage.af.aHH(paramList.DhA.Did))
          {
            paramList = paramList.DhA.Did;
            paramList = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramList));
            if (!bt.isNullOrNil(paramList)) {
              paramString.aDP(paramList);
            }
          }
          paramcs.deQ.deS.mVb.add(paramString);
          paramString = paramcs.deQ.deT;
          paramString.DiU += 1;
          bool1 = true;
        }
        else if (((bl)localObject2).cxD())
        {
          bool1 = a(paramcs, (bl)localObject2);
        }
        else if (((bl)localObject2).eJO())
        {
          paramList = null;
          if (((du)localObject2).field_msgId > 0L) {
            paramList = com.tencent.mm.aw.o.ayF().ms((int)((du)localObject2).field_msgId);
          }
          if (paramList != null)
          {
            paramString = paramList;
            if (paramList.deI > 0L) {}
          }
          else
          {
            paramString = paramList;
            if (((du)localObject2).field_msgSvrId > 0L) {
              paramString = com.tencent.mm.aw.o.ayF().mr(((du)localObject2).field_msgSvrId);
            }
          }
          if (paramString == null)
          {
            ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
            paramcs.deQ.deV = 2131758891;
            bool1 = false;
            continue;
          }
          localObject3 = new afz();
          ((afz)localObject3).c(aw((bl)localObject2));
          paramList = new afy();
          paramList.aDD(ax((bl)localObject2));
          paramList.VD(2);
          paramList.aDz(com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c(paramString), "", ""));
          if (paramString.ayi())
          {
            com.tencent.mm.aw.e locale = com.tencent.mm.aw.o.ayF().od(paramString.hgu);
            if (locale.gTY > locale.offset) {
              paramList.aDz(com.tencent.mm.aw.o.ayF().p("SERVERID://" + ((du)localObject2).field_msgSvrId, "", ""));
            }
          }
          paramList.aDA(com.tencent.mm.aw.o.ayF().Q(((du)localObject2).field_imgPath, true));
          paramList.a((afz)localObject3);
          paramList.aDG(a(((afz)localObject3).DhA));
          paramList.aDH(b(((afz)localObject3).DhA));
          paramList.vr(((du)localObject2).field_msgId);
          paramList.aDT(bk.uo(((du)localObject2).esh));
          if (com.tencent.mm.storage.af.aHH(((afz)localObject3).DhA.Did))
          {
            localObject3 = ((afz)localObject3).DhA.Did;
            localObject3 = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject3));
            if (!bt.isNullOrNil((String)localObject3)) {
              paramList.aDP((String)localObject3);
            }
          }
          if ((!paramString.ayi()) || (paramString.gTY != 0)) {
            break label2406;
          }
          paramString = com.tencent.mm.aw.o.ayF().od(paramString.hgu);
        }
      }
    }
    label650:
    label1606:
    label2403:
    label2406:
    for (;;)
    {
      int i;
      if (((du)localObject2).field_isSend == 1) {
        if (paramString.ayi())
        {
          i = 1;
          localObject2 = bw.K(paramString.hgv, "msg");
          if (localObject2 == null) {
            break label1785;
          }
          if (i == 1)
          {
            paramList.aDp((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.vp(bt.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.aDq((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcs.deQ.deS.mVb.add(paramList);
        paramString = paramcs.deQ.deT;
        paramString.DiT += 1;
        bool1 = true;
        break;
        i = 0;
        break label1606;
        if (!paramString.ayi())
        {
          i = 0;
          break label1606;
        }
        localObject2 = com.tencent.mm.aw.f.a(paramString);
        if (!i.eK(com.tencent.mm.aw.o.ayF().p(((com.tencent.mm.aw.e)localObject2).hgj, "", "")))
        {
          i = 0;
          break label1606;
        }
        i = 1;
        break label1606;
        label1785:
        ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.hgv });
      }
      if (((bl)localObject2).cjM())
      {
        bool1 = c(paramcs, (bl)localObject2);
        break label468;
      }
      if (((bl)localObject2).cjN())
      {
        bool1 = b(paramcs, (bl)localObject2);
        break label468;
      }
      if (((bl)localObject2).cjO())
      {
        bool1 = c(paramcs, (bl)localObject2);
        break label468;
      }
      if (((bl)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcs, (bl)localObject2, 3);
        break label468;
      }
      if (((bl)localObject2).eJL())
      {
        bool1 = d(paramcs, (bl)localObject2);
        break label468;
      }
      if ((((bl)localObject2).eLY()) || (((bl)localObject2).eLZ()))
      {
        bool1 = a(paramContext, paramcs, (bl)localObject2, 1);
        break label468;
      }
      if (((bl)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcs, (bl)localObject2, 2);
        break label468;
      }
      if (((bl)localObject2).eLX())
      {
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().agC(((du)localObject2).field_content);
        paramList = new afz();
        paramList.c(aw((bl)localObject2));
        if ((paramString != null) && (w.mZ(paramString.AOL)))
        {
          paramString = new afy();
          paramString.aDD(ax((bl)localObject2));
          paramString.VD(16);
          paramString.aDm(((du)localObject2).field_content);
          paramString.ux(true);
          paramString.uw(true);
          paramString.a(paramList);
          paramString.aDG(a(paramList.DhA));
          paramString.aDH(b(paramList.DhA));
          if (!com.tencent.mm.storage.af.aHH(paramList.DhA.Did)) {
            break label2403;
          }
          paramList = paramList.DhA.Did;
          paramList = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramList));
          if (!bt.isNullOrNil(paramList)) {
            paramString.aDP(paramList);
          }
        }
      }
      for (;;)
      {
        paramcs.deQ.deS.mVb.add(paramString);
        paramString = paramcs.deQ.deT;
        paramString.Dje += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (com.tencent.mm.storage.af.aHH(paramString.yGA)))
        {
          paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramString.FzZ, "openim_card_type_name", b.a.hNA);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131755784);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((bl)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((bl)localObject2, paramContext.getString(2131755784), paramList);
        continue;
        if (((bl)localObject2).cxB())
        {
          if (((bl)localObject2).eLZ())
          {
            paramcs.deQ.deV = 2131758893;
            break label468;
          }
          bool1 = a(paramContext, paramcs, (bl)localObject2);
          break label468;
        }
        paramcs.deQ.deV = 2131758893;
        bool1 = a(paramContext, paramcs, (bl)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcs.deQ.deV > 0)) {
          paramcs.deQ.deV = 0;
        }
        AppMethodBeat.o(9445);
        return bool2;
      }
    }
  }
  
  private static boolean a(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(9451);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    Object localObject = bw.K(parambl.field_content, "msg");
    if (localObject != null) {
      try
      {
        agf localagf = new agf();
        localagf.aEc((String)((Map)localObject).get(".msg.location.$label"));
        localagf.C(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localagf.B(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localagf.VI(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localagf.aEd((String)((Map)localObject).get(".msg.location.$poiname"));
        localafz.c(localagf);
        localObject = new afy();
        ((afy)localObject).aDD(ax(parambl));
        ((afy)localObject).VD(6);
        ((afy)localObject).ux(true);
        ((afy)localObject).uw(true);
        ((afy)localObject).a(localafz);
        ((afy)localObject).aDG(a(localafz.DhA));
        ((afy)localObject).aDH(b(localafz.DhA));
        if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
        {
          parambl = localafz.DhA.Did;
          parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
          if (!bt.isNullOrNil(parambl)) {
            ((afy)localObject).aDP(parambl);
          }
        }
        paramcs.deQ.deS.mVb.add(localObject);
        parambl = paramcs.deQ.deT;
        parambl.DiW += 1;
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception parambl)
      {
        ad.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { parambl.getStackTrace().toString() });
      }
    }
    paramcs.deQ.deV = 2131758895;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static aga aw(bl parambl)
  {
    AppMethodBeat.i(9447);
    aga localaga = new aga();
    if (parambl == null)
    {
      AppMethodBeat.o(9447);
      return localaga;
    }
    Object localObject;
    if (parambl.field_isSend == 0)
    {
      localaga.aDU(parambl.field_talker);
      localaga.aDV(com.tencent.mm.model.u.aqG());
      if (w.pF(parambl.field_talker))
      {
        if (parambl.field_content == null) {
          break label343;
        }
        localObject = parambl.field_content.substring(0, Math.max(0, parambl.field_content.indexOf(':')));
        localaga.aDX((String)localObject);
        if ((!bt.isNullOrNil(localaga.Did)) && (!parambl.eJN()))
        {
          parambl.setContent(parambl.field_content.substring(localaga.Did.length() + 1));
          if ((parambl.field_content.length() > 0) && ('\n' == parambl.field_content.charAt(0))) {
            parambl.setContent(parambl.field_content.substring(1));
          }
          if (parambl.eMj())
          {
            parambl.ob(parambl.field_transContent.substring(localaga.Did.length() + 1));
            if ((parambl.field_transContent.length() > 0) && ('\n' == parambl.field_transContent.charAt(0))) {
              parambl.ob(parambl.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.am.f.pc(parambl.field_talker))
      {
        String str = parambl.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bi.ul(parambl.esh).userId;
        }
        localaga.aDX((String)localObject);
      }
      localaga.VH(1);
      localaga.vs(parambl.field_createTime);
      localaga.aDY(parambl.field_msgSvrId);
      if (parambl.field_msgSvrId > 0L) {
        localaga.aDW(parambl.field_msgSvrId);
      }
      AppMethodBeat.o(9447);
      return localaga;
      label343:
      localObject = "";
      break;
      localaga.aDU(com.tencent.mm.model.u.aqG());
      localaga.aDV(parambl.field_talker);
      if (w.pF(parambl.field_talker)) {
        localaga.aDX(localaga.dpv);
      }
    }
  }
  
  private static String ax(bl parambl)
  {
    AppMethodBeat.i(9450);
    if (parambl.field_isSend == 1)
    {
      if ((w.pF(parambl.field_talker)) || (parambl.field_talker.equals("filehelper")))
      {
        parambl = String.format("%d", new Object[] { Long.valueOf(parambl.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return parambl;
      }
      parambl = String.format("%s#%d", new Object[] { parambl.field_talker, Long.valueOf(parambl.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return parambl;
    }
    long l = parambl.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static String b(aga paramaga)
  {
    AppMethodBeat.i(9449);
    paramaga = uZY.format(new Date(paramaga.createTime));
    AppMethodBeat.o(9449);
    return paramaga;
  }
  
  public static boolean b(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.ar(parambl.field_content, parambl.field_reserved);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new ago();
    Object localObject3 = new agu();
    ((agu)localObject3).aEl(com.tencent.mm.model.u.aqG());
    ((agu)localObject3).aEm(com.tencent.mm.model.u.aqG());
    ((agu)localObject3).VM(4);
    ((agu)localObject3).vv(bt.eGO());
    ((agu)localObject3).aEs(((k.b)localObject2).url);
    ((ago)localObject1).a((agu)localObject3);
    localObject1 = new afy();
    ((afy)localObject1).aDz("");
    ((afy)localObject1).aDu(((k.b)localObject2).thumburl);
    localObject3 = m.t(parambl);
    if (localObject3 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((afy)localObject1).VC(((agg)localObject3).duration);
    ((afy)localObject1).aDl(((k.b)localObject2).title);
    ((afy)localObject1).aDr(((k.b)localObject2).url);
    ((afy)localObject1).uw(true);
    ((afy)localObject1).ux(true);
    localObject2 = new afz();
    ((afz)localObject2).c(aw(parambl));
    if (parambl.cjN()) {
      ((afz)localObject2).e((agg)localObject3);
    }
    ((afy)localObject1).a((afz)localObject2);
    ((afy)localObject1).vr(parambl.field_msgId);
    ((afy)localObject1).aDG(a(((afz)localObject2).DhA));
    ((afy)localObject1).aDH(b(((afz)localObject2).DhA));
    if (com.tencent.mm.storage.af.aHH(((afz)localObject2).DhA.Did))
    {
      parambl = ((afz)localObject2).DhA.Did;
      parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
      if (!bt.isNullOrNil(parambl)) {
        ((afy)localObject1).aDP(parambl);
      }
    }
    paramcs.deQ.deS.mVb.add(localObject1);
    paramcs = paramcs.deQ.deT;
    paramcs.rBj += 1;
    ((afy)localObject1).VD(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(9453);
    Object localObject2 = new afz();
    ((afz)localObject2).c(aw(parambl));
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDz(t.zQ(parambl.field_imgPath));
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDA(t.zR(parambl.field_imgPath));
    localafy.aDv(i.RK(localafy.Dgx));
    if (parambl.cjO()) {
      localafy.VD(15);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(9453);
      return false;
      localafy.VD(4);
    }
    ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(((s)localObject1).gTY) });
    if (((s)localObject1).gTY > ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimit(true))
    {
      paramcs.deQ.deV = 2131759025;
      AppMethodBeat.o(9453);
      return false;
    }
    if ((parambl.cjO()) && (com.tencent.mm.modelvideo.u.Ag(((s)localObject1).getFileName())))
    {
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(9453);
      return false;
    }
    localafy.VC(((s)localObject1).gOY);
    localafy.a((afz)localObject2);
    localafy.aDG(a(((afz)localObject2).DhA));
    localafy.aDH(b(((afz)localObject2).DhA));
    if (com.tencent.mm.storage.af.aHH(((afz)localObject2).DhA.Did))
    {
      localObject2 = ((afz)localObject2).DhA.Did;
      localObject2 = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject2));
      if (!bt.isNullOrNil((String)localObject2)) {
        localafy.aDP((String)localObject2);
      }
    }
    localafy.vr(parambl.field_msgId);
    localafy.aDT(bk.uo(parambl.esh));
    localafy.vp(((s)localObject1).gTY);
    Object localObject1 = bw.K(((s)localObject1).aCT(), "msg");
    if (localObject1 != null)
    {
      localafy.aDp((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localafy.aDq((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
      paramcs.deQ.deS.mVb.add(localafy);
      paramcs = paramcs.deQ.deT;
      paramcs.rBj += 1;
      paramcs = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      localafy.aDJ(paramcs.dxG);
      paramcs = paramcs.hAq;
      if ((paramcs != null) && (!bt.isNullOrNil(paramcs.gJB)))
      {
        parambl = new agb();
        parambl.gJv = paramcs.gJv;
        parambl.Dim = paramcs.Dim;
        parambl.gJy = paramcs.gJy;
        parambl.gJz = paramcs.gJz;
        parambl.gJx = paramcs.gJx;
        parambl.gJA = paramcs.gJA;
        parambl.gJB = paramcs.gJB;
        parambl.gJC = paramcs.gJC;
        localafy.a(parambl);
      }
      AppMethodBeat.o(9453);
      return true;
      ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
    }
  }
  
  private static boolean d(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(9457);
    try
    {
      com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
      Object localObject1 = localu.gKs;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ai.v localv = (com.tencent.mm.ai.v)((Iterator)localObject1).next();
          if (!m.rz(localv.gKI))
          {
            afz localafz = new afz();
            localafz.c(aw(parambl));
            localafz.DhA.aEb(localu.dxz);
            localafz.DhA.aEa(localv.url);
            Object localObject2 = new afy();
            ((afy)localObject2).aDl(localv.title);
            ((afy)localObject2).aDm(localv.gKF);
            ((afy)localObject2).aDD(ax(parambl));
            if (!bt.isNullOrNil(localv.gKD)) {
              ((afy)localObject2).aDA(r.aAK(localv.gKD));
            }
            for (;;)
            {
              ((afy)localObject2).uw(true);
              ahd localahd = new ahd();
              if (!bt.isNullOrNil(localv.title)) {
                localahd.aEy(localv.title);
              }
              if (!bt.isNullOrNil(localv.gKF)) {
                localahd.aEz(localv.gKF);
              }
              if (!bt.isNullOrNil(localv.gKD)) {
                localahd.aEB(m.a(localv));
              }
              if (localahd.computeSize() > 0)
              {
                localahd.VN(1);
                localafz.a(localahd);
              }
              ((afy)localObject2).VD(5);
              ((afy)localObject2).a(localafz);
              ((afy)localObject2).aDG(a(localafz.DhA));
              ((afy)localObject2).aDH(b(localafz.DhA));
              if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
              {
                String str = localafz.DhA.Did;
                str = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str));
                if (!bt.isNullOrNil(str)) {
                  ((afy)localObject2).aDP(str);
                }
              }
              paramcs.deQ.deS.mVb.add(localObject2);
              localObject2 = paramcs.deQ.deT;
              ((ahc)localObject2).DiV += 1;
              localafz.d(m.a(localv, localahd, localu.dxz, localu.dxA));
              i += 1;
              break;
              ((afy)localObject2).ux(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception parambl)
    {
      ad.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", parambl, "", new Object[0]);
      ad.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { parambl.getLocalizedMessage() });
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(9457);
      return false;
    }
    paramcs.deQ.deV = 2131758893;
    AppMethodBeat.o(9457);
    return false;
    label557:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.b
 * JD-Core Version:    0.7.0.1
 */