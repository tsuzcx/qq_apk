package com.tencent.mm.pluginsdk.model;

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
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
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
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final SimpleDateFormat uZY;
  
  static
  {
    AppMethodBeat.i(30988);
    uZY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static afy a(bl parambl, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
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
      AppMethodBeat.o(30983);
      return localafy;
      localafy.ux(true);
    }
  }
  
  private static afy a(bl parambl, String paramString, afz paramafz)
  {
    AppMethodBeat.i(30984);
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
    AppMethodBeat.o(30984);
    return localafy;
  }
  
  private static String a(aga paramaga)
  {
    AppMethodBeat.i(30973);
    String str2 = paramaga.Did;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramaga.dpv;
    }
    if (com.tencent.mm.am.a.e.xk(str1))
    {
      paramaga = com.tencent.mm.am.a.e.xm(str1);
      AppMethodBeat.o(30973);
      return paramaga;
    }
    paramaga = com.tencent.mm.model.v.sg(str1);
    AppMethodBeat.o(30973);
    return paramaga;
  }
  
  private static void a(bl parambl, afz paramafz, ahd paramahd)
  {
    AppMethodBeat.i(30986);
    paramafz.d(m.a(parambl, paramahd));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30985);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    Object localObject1 = parambl.field_content;
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localObject1 = k.b.rx((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localafz.DhA.aDZ(((k.b)localObject1).appId);
    localafz.DhA.aEb(((k.b)localObject1).dxz);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).CZ();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcs.deQ.deV = 2131758893;
      AppMethodBeat.o(30985);
      return false;
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
      AppMethodBeat.o(30985);
      return true;
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ap.bxS().aAL(((k.b)localObject1).dbA);
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      if (localObject2 != null) {
        paramContext.aDz(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eK((String)localObject2)) {
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
      AppMethodBeat.o(30985);
      return true;
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
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.DiX += 1;
      AppMethodBeat.o(30985);
      return true;
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
      AppMethodBeat.o(30985);
      return true;
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
        a(parambl, localafz, (ahd)localObject2);
        AppMethodBeat.o(30985);
        return true;
      }
      paramcs.deQ.deV = 2131758889;
      AppMethodBeat.o(30985);
      return false;
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
        AppMethodBeat.o(30985);
        return true;
      }
      AppMethodBeat.o(30985);
      return false;
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ap.bxS().aAL(((k.b)localObject1).dbA);
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
      if (com.tencent.mm.vfs.i.eK((String)localObject2)) {
        paramContext.aDA((String)localObject2);
      }
      paramContext.aDl(((k.b)localObject1).title);
      paramContext.aDm(((k.b)localObject1).description);
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
      paramContext = paramcs.deQ.deT;
      paramContext.fileCount += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).dbA == null) || (((k.b)localObject1).dbA.length() == 0)) {
        paramcs.deQ.deV = 2131758886;
      }
      do
      {
        paramcs.deQ.deV = 2131758893;
        AppMethodBeat.o(30985);
        return false;
        az.arV();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcs.deQ.deV = 2131758901;
      AppMethodBeat.o(30985);
      return false;
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
      AppMethodBeat.o(30985);
      return true;
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
      AppMethodBeat.o(30985);
      return true;
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
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambl, paramContext.getString(2131755833), localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.aDl(((k.b)localObject1).title);
      paramContext.aDm(((k.b)localObject1).description);
      paramContext.VD(19);
      localObject2 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (bt.isNullOrNil((String)localObject2)) {
        paramContext.ux(true);
      }
      if (com.tencent.mm.vfs.i.eK((String)localObject2)) {
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
      ((afw)localObject2).jwB = ((k.b)localObject1).gJN;
      ((afw)localObject2).type = ((k.b)localObject1).gJG;
      ((afw)localObject2).dkC = ((k.b)localObject1).gJI;
      ((afw)localObject2).dbu = ((k.b)localObject1).gJD;
      ((afw)localObject2).DfP = ((k.b)localObject1).dxA;
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
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambl, paramContext.getString(2131755786) + ((k.b)localObject1).title, localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = ((k.b)localObject1).r(paramContext, true);
      if (bt.isNullOrNil(paramContext))
      {
        paramcs.deQ.deV = 2131758893;
        AppMethodBeat.o(30985);
        return false;
      }
      paramContext = a(parambl, paramContext + ((k.b)localObject1).title, localafz);
      paramcs.deQ.deS.mVb.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).gHI != null) && (((k.b)localObject1).gHI.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
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
        if (localObject1 == null) {
          break label3371;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).gKs.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (bt.isNullOrNil(((afy)((Iterator)localObject3).next()).Dhr));
        paramcs.deQ.deV = 2131758893;
        AppMethodBeat.o(30985);
        return false;
      }
    }
    label3371:
    if (localObject1 != null) {
      paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
    }
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
      AppMethodBeat.o(30985);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cs paramcs, String paramString, List<bl> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(30969);
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
    boolean bool = com.tencent.mm.am.f.pc(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (bl)paramList.get(0);
      if (paramList.eJL())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.ai.u)localObject1).gKs != null) && (((com.tencent.mm.ai.u)localObject1).gKs.size() == 1))
        {
          paramBoolean = g.e(paramcs, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramcs.deQ.deS = new ago();
        paramcs.deQ.deT = new ahc();
        paramcs.deQ.deS.a(aAF(paramString));
        paramcs.deQ.type = 14;
        paramBoolean = b(paramContext, paramcs, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = g.e(paramcs, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramcs.deQ.deS = new ago();
    paramcs.deQ.deT = new ahc();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.am.a.e.mn(((bl)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.am.a.e.xl((String)localObject1))
      {
        paramcs.deQ.deS.aEj(paramContext.getString(2131762236));
        ad.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcs.deQ.deS.title });
      }
    }
    else
    {
      paramcs.deQ.deS.a(aAF(paramString));
      paramcs.deQ.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcs, (bl)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.am.a.e.xo(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcs.deQ.deS.aEj(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.am.a.k)localObject2).field_userName, com.tencent.mm.am.a.e.xm((String)localObject1) }));
        break;
        label633:
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
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcs.deQ.deV > 0)) {
      paramcs.deQ.deV = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30978);
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
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception parambl)
      {
        ad.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambl.getStackTrace().toString() });
      }
    }
    paramcs.deQ.deV = 2131758895;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static String aAE(String paramString)
  {
    AppMethodBeat.i(30980);
    az.arV();
    paramString = l.d(com.tencent.mm.model.c.apZ(), "recbiz_", paramString, ".rec", 2);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30980);
      return null;
    }
    if (new com.tencent.mm.vfs.e(paramString).exists())
    {
      AppMethodBeat.o(30980);
      return paramString;
    }
    AppMethodBeat.o(30980);
    return paramString;
  }
  
  private static agu aAF(String paramString)
  {
    AppMethodBeat.i(30971);
    agu localagu = new agu();
    localagu.aEl(paramString);
    localagu.VM(1);
    localagu.vv(bt.eGO());
    localagu.aEn("");
    AppMethodBeat.o(30971);
    return localagu;
  }
  
  private static aga aw(bl parambl)
  {
    AppMethodBeat.i(30972);
    aga localaga = new aga();
    if (parambl == null)
    {
      AppMethodBeat.o(30972);
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
      AppMethodBeat.o(30972);
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
    AppMethodBeat.i(30975);
    if (parambl.field_isSend == 1)
    {
      if ((w.pF(parambl.field_talker)) || (parambl.field_talker.equals("filehelper")))
      {
        parambl = String.format("%d", new Object[] { Long.valueOf(parambl.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return parambl;
      }
      parambl = String.format("%s#%d", new Object[] { parambl.field_talker, Long.valueOf(parambl.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return parambl;
    }
    long l = parambl.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String b(aga paramaga)
  {
    AppMethodBeat.i(30974);
    paramaga = uZY.format(new Date(paramaga.createTime));
    AppMethodBeat.o(30974);
    return paramaga;
  }
  
  private static boolean b(Context paramContext, cs paramcs, bl parambl)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramcs == null) || (parambl == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    parambl = bl.aI(parambl);
    if (parambl.isText()) {
      bool = f(paramcs, parambl);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(parambl, paramcs, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (parambl.eJN()) {
        bool = m(paramcs, parambl);
      } else if (parambl.cxD()) {
        bool = a(paramcs, parambl);
      } else if (parambl.eJO()) {
        bool = l(paramcs, parambl);
      } else if (parambl.cjM()) {
        bool = c(paramcs, parambl);
      } else if (parambl.cjO()) {
        bool = c(paramcs, parambl);
      } else if (parambl.cjN()) {
        bool = com.tencent.mm.plugin.record.b.b.b(paramcs, parambl);
      } else if (parambl.eJL()) {
        bool = d(paramcs, parambl);
      } else if (parambl.eLX()) {
        bool = c(paramContext, paramcs, parambl);
      } else if ((parambl.cxB()) && (!parambl.eLZ())) {
        bool = a(paramContext, paramcs, parambl);
      } else {
        paramcs.deQ.deV = 2131758893;
      }
    }
  }
  
  private static boolean c(Context paramContext, cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30982);
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().agC(parambl.field_content);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    if ((localObject != null) && (w.mZ(((bl.a)localObject).AOL)))
    {
      paramContext = new afy();
      paramContext.aDD(ax(parambl));
      paramContext.VD(16);
      paramContext.aDm(parambl.field_content);
      paramContext.ux(true);
      paramContext.uw(true);
      paramContext.a(localafz);
      paramContext.aDG(a(localafz.DhA));
      paramContext.aDH(b(localafz.DhA));
      if (!com.tencent.mm.storage.af.aHH(localafz.DhA.Did)) {
        break label337;
      }
      parambl = localafz.DhA.Did;
      parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
      if (!bt.isNullOrNil(parambl)) {
        paramContext.aDP(parambl);
      }
    }
    label337:
    for (;;)
    {
      paramcs.deQ.deS.mVb.add(paramContext);
      paramContext = paramcs.deQ.deT;
      paramContext.Dje += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (com.tencent.mm.storage.af.aHH(((bl.a)localObject).yGA)))
      {
        localObject = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(((bl.a)localObject).FzZ, "openim_card_type_name", b.a.hNA);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(parambl, paramContext, localafz);
          break;
        }
      }
      paramContext = a(parambl, paramContext.getString(2131755784), localafz);
    }
  }
  
  private static boolean c(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30981);
    Object localObject = new afz();
    ((afz)localObject).c(aw(parambl));
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDz(t.zQ(parambl.field_imgPath));
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDA(t.zR(parambl.field_imgPath));
    localafy.aDv(com.tencent.mm.vfs.i.RK(localafy.Dgx));
    if (parambl.cjO()) {
      localafy.VD(15);
    }
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      if (locals != null) {
        break;
      }
      ad.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(30981);
      return false;
      localafy.VD(4);
    }
    ad.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.gTY) });
    if (locals.gTY > ((com.tencent.mm.plugin.fav.a.af)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fav.a.af.class)).getVideoSizeLimit(false))
    {
      paramcs.deQ.deV = 2131759024;
      AppMethodBeat.o(30981);
      return false;
    }
    if ((parambl.cjO()) && (com.tencent.mm.modelvideo.u.Ag(locals.getFileName())))
    {
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(30981);
      return false;
    }
    localafy.VC(locals.gOY);
    localafy.a((afz)localObject);
    localafy.aDG(a(((afz)localObject).DhA));
    localafy.aDH(b(((afz)localObject).DhA));
    if (com.tencent.mm.storage.af.aHH(((afz)localObject).DhA.Did))
    {
      localObject = ((afz)localObject).DhA.Did;
      localObject = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject));
      if (!bt.isNullOrNil((String)localObject)) {
        localafy.aDP((String)localObject);
      }
    }
    localafy.vr(parambl.field_msgId);
    localafy.aDT(bk.uo(parambl.esh));
    localafy.vp(locals.gTY);
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
    AppMethodBeat.o(30981);
    return true;
  }
  
  private static boolean d(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30987);
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
      ad.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambl, "", new Object[0]);
      ad.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambl.getLocalizedMessage() });
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30987);
      return false;
    }
    paramcs.deQ.deV = 2131758893;
    AppMethodBeat.o(30987);
    return false;
    label557:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean f(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30976);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    localafy.VD(1);
    String str;
    if (parambl.eMC())
    {
      str = aj.getContext().getString(2131762657, new Object[] { "@" }) + '\n';
      if (parambl.eMt()) {
        break label277;
      }
      localafy.aDm(str + parambl.field_content);
    }
    for (;;)
    {
      localafy.ux(true);
      localafy.uw(true);
      localafy.a(localafz);
      localafy.aDG(a(localafz.DhA));
      localafy.aDH(b(localafz.DhA));
      if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
      {
        parambl = localafz.DhA.Did;
        parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
        if (!bt.isNullOrNil(parambl)) {
          localafy.aDP(parambl);
        }
      }
      paramcs.deQ.deS.mVb.add(localafy);
      paramcs = paramcs.deQ.deT;
      paramcs.DiS += 1;
      AppMethodBeat.o(30976);
      return true;
      str = "";
      break;
      label277:
      localafy.aDm(str + parambl.field_content + "\n\n" + parambl.field_transContent);
    }
  }
  
  private static boolean l(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30977);
    Object localObject1 = null;
    if (parambl.field_msgId > 0L) {
      localObject1 = com.tencent.mm.aw.o.ayF().ms((int)parambl.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.e)localObject1).deI > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambl.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.aw.o.ayF().mr(parambl.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcs.deQ.deV = 2131758891;
      AppMethodBeat.o(30977);
      return false;
    }
    afz localafz = new afz();
    localafz.c(aw(parambl));
    localObject1 = new afy();
    ((afy)localObject1).aDD(ax(parambl));
    ((afy)localObject1).VD(2);
    ((afy)localObject1).aDz(com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c((com.tencent.mm.aw.e)localObject2), "", ""));
    if (((com.tencent.mm.aw.e)localObject2).ayi())
    {
      localObject2 = com.tencent.mm.aw.o.ayF().od(((com.tencent.mm.aw.e)localObject2).hgu);
      if (((com.tencent.mm.aw.e)localObject2).gTY > ((com.tencent.mm.aw.e)localObject2).offset) {
        ((afy)localObject1).aDz(com.tencent.mm.aw.o.ayF().p("SERVERID://" + parambl.field_msgSvrId, "", ""));
      }
    }
    ((afy)localObject1).aDA(com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true));
    ((afy)localObject1).a(localafz);
    ((afy)localObject1).aDG(a(localafz.DhA));
    ((afy)localObject1).aDH(b(localafz.DhA));
    ((afy)localObject1).vr(parambl.field_msgId);
    ((afy)localObject1).aDT(bk.uo(parambl.esh));
    if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
    {
      parambl = localafz.DhA.Did;
      parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
      if (!bt.isNullOrNil(parambl)) {
        ((afy)localObject1).aDP(parambl);
      }
    }
    paramcs.deQ.deS.mVb.add(localObject1);
    paramcs = paramcs.deQ.deT;
    paramcs.DiT += 1;
    AppMethodBeat.o(30977);
    return true;
  }
  
  private static boolean m(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30979);
    afz localafz = new afz();
    localafz.c(aw(parambl));
    afy localafy = new afy();
    localafy.aDD(ax(parambl));
    localafy.VD(3);
    if (w.ta(parambl.field_talker)) {
      localafy.aDz(aAE(parambl.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localafy.ux(true);
      localb = com.tencent.mm.modelvoice.s.Ax(parambl.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30979);
      return false;
      localafy.aDz(com.tencent.mm.modelvoice.s.getFullPath(parambl.field_imgPath));
    }
    localafy.aDv(g.Ug(localb.getFormat()));
    localafy.VC((int)new p(parambl.field_content).time);
    localafy.a(localafz);
    localafy.aDG(a(localafz.DhA));
    localafy.aDH(b(localafz.DhA));
    if (com.tencent.mm.storage.af.aHH(localafz.DhA.Did))
    {
      parambl = localafz.DhA.Did;
      parambl = com.tencent.mm.openim.room.a.a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(parambl));
      if (!bt.isNullOrNil(parambl)) {
        localafy.aDP(parambl);
      }
    }
    paramcs.deQ.deS.mVb.add(localafy);
    paramcs = paramcs.deQ.deT;
    paramcs.DiU += 1;
    AppMethodBeat.o(30979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */