package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.vfs.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final SimpleDateFormat wiM;
  
  static
  {
    AppMethodBeat.i(30988);
    wiM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static agx a(bo parambo, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    localagx.aIJ(paramb.hib);
    localagx.aIK(paramb.hic);
    localagx.aII(paramb.url);
    localagx.vy(true);
    parambo = new com.tencent.mm.vfs.e(bs.bG(com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true), ""));
    if (parambo.exists()) {
      localagx.aIR(q.B(parambo.fxV()));
    }
    for (;;)
    {
      localagx.aIC(paramb.title);
      localagx.aID(paramb.description);
      localagx.XM(paramInt);
      localagx.aJb(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localagx;
      localagx.vz(true);
    }
  }
  
  private static agx a(bo parambo, String paramString, agy paramagy)
  {
    AppMethodBeat.i(30984);
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    localagx.XM(1);
    localagx.aID(paramString);
    localagx.vz(true);
    localagx.vy(true);
    localagx.a(paramagy);
    localagx.aIX(a(paramagy.EAG));
    localagx.aIY(b(paramagy.EAG));
    if (com.tencent.mm.storage.ai.aNc(paramagy.EAG.EBj))
    {
      parambo = paramagy.EAG.EBj;
      parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
      if (!bs.isNullOrNil(parambo)) {
        localagx.aJg(parambo);
      }
    }
    AppMethodBeat.o(30984);
    return localagx;
  }
  
  private static String a(agz paramagz)
  {
    AppMethodBeat.i(30973);
    String str2 = paramagz.EBj;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = paramagz.dng;
    }
    if (com.tencent.mm.al.a.e.Bq(str1))
    {
      paramagz = com.tencent.mm.al.a.e.Bs(str1);
      AppMethodBeat.o(30973);
      return paramagz;
    }
    paramagz = com.tencent.mm.model.v.wj(str1);
    AppMethodBeat.o(30973);
    return paramagz;
  }
  
  private static void a(bo parambo, agy paramagy, aic paramaic)
  {
    AppMethodBeat.i(30986);
    paramagy.d(m.a(parambo, paramaic));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30985);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    Object localObject1 = parambo.field_content;
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localObject1 = k.b.vA((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localagy.EAG.aJq(((k.b)localObject1).appId);
    localagy.EAG.aJs(((k.b)localObject1).dvl);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).CC();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcs.dck.dcp = 2131758893;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.XM(1);
      paramContext.aID(((k.b)localObject1).title);
      paramContext.vz(true);
      paramContext.vy(true);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.EBY += 1;
      AppMethodBeat.o(30985);
      return true;
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ap.bEO().aGd(((k.b)localObject1).cZa);
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      if (localObject2 != null) {
        paramContext.aIQ(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eA((String)localObject2)) {
        paramContext.aIR((String)localObject2);
      }
      paramContext.XM(2);
      paramContext.aIC(((k.b)localObject1).title);
      paramContext.aID(((k.b)localObject1).description);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      paramContext.zU(parambo.field_msgId);
      paramContext.aJk(bk.yu(parambo.eul));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.EBZ += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambo, (k.b)localObject1, 7);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECd += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambo, (k.b)localObject1, 4);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      paramContext.zU(parambo.field_msgId);
      paramContext.aJk(bk.yu(parambo.eul));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.sKb += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localagy.EAG.aJr(((k.b)localObject1).url);
        paramContext = a(parambo, (k.b)localObject1, 5);
        paramContext.a(localagy);
        paramContext.aIX(a(localagy.EAG));
        paramContext.aIY(b(localagy.EAG));
        if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
        {
          localObject2 = localagy.EAG.EBj;
          localObject2 = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject2));
          if (!bs.isNullOrNil((String)localObject2)) {
            paramContext.aJg((String)localObject2);
          }
        }
        localObject2 = new aic();
        if (!bs.isNullOrNil(((k.b)localObject1).title)) {
          ((aic)localObject2).aJP(((k.b)localObject1).title);
        }
        if (!bs.isNullOrNil(((k.b)localObject1).description)) {
          ((aic)localObject2).aJQ(((k.b)localObject1).description);
        }
        if (!bs.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((aic)localObject2).aJS(((k.b)localObject1).thumburl);
        }
        if (!bs.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((aic)localObject2).aJT(((k.b)localObject1).canvasPageXml);
        }
        if (((aic)localObject2).computeSize() > 0)
        {
          ((aic)localObject2).XW(1);
          localagy.a((aic)localObject2);
        }
        paramcs.dck.dcm.nxC.add(paramContext);
        paramContext = paramcs.dck.dcn;
        paramContext.ECb += 1;
        a(parambo, localagy, (aic)localObject2);
        AppMethodBeat.o(30985);
        return true;
      }
      paramcs.dck.dcp = 2131758889;
      AppMethodBeat.o(30985);
      return false;
      paramContext = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.hTI;
        localObject1 = new agx();
        ((agx)localObject1).aIX(a(localagy.EAG));
        ((agx)localObject1).aIY(b(localagy.EAG));
        ((agx)localObject1).aIU(az(parambo));
        ((agx)localObject1).vy(true);
        ((agx)localObject1).aIC(paramContext.nickname + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759007));
        ((agx)localObject1).aID(paramContext.desc);
        ((agx)localObject1).XM(22);
        localagy.c(paramContext);
        ((agx)localObject1).a(localagy);
        paramcs.dck.dcm.nxC.add(localObject1);
        AppMethodBeat.o(30985);
        return true;
      }
      AppMethodBeat.o(30985);
      return false;
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ap.bEO().aGd(((k.b)localObject1).cZa);
      paramContext = new agx();
      if (localObject2 != null) {
        paramContext.aIQ(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.aIU(az(parambo));
      paramContext.XM(8);
      paramContext.aIM(((k.b)localObject1).hhG);
      localObject2 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (bs.isNullOrNil((String)localObject2)) {
        paramContext.vz(true);
      }
      if (com.tencent.mm.vfs.i.eA((String)localObject2)) {
        paramContext.aIR((String)localObject2);
      }
      paramContext.aIC(((k.b)localObject1).title);
      paramContext.aID(((k.b)localObject1).description);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      paramContext.zU(parambo.field_msgId);
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.fileCount += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).cZa == null) || (((k.b)localObject1).cZa.length() == 0)) {
        paramcs.dck.dcp = 2131758886;
      }
      do
      {
        paramcs.dck.dcp = 2131758893;
        AppMethodBeat.o(30985);
        return false;
        az.ayM();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcs.dck.dcp = 2131758901;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new ahm();
      paramContext.aJv(((k.b)localObject1).title);
      paramContext.aJw(((k.b)localObject1).description);
      paramContext.XS(((k.b)localObject1).hie);
      paramContext.aJy(((k.b)localObject1).hif);
      paramContext.aJx(((k.b)localObject1).thumburl);
      localagy.a(paramContext);
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.XM(10);
      paramContext.vz(true);
      paramContext.vy(true);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECf += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new ahw();
      paramContext.aJL(((k.b)localObject1).title);
      paramContext.aJM(((k.b)localObject1).description);
      paramContext.aJO(((k.b)localObject1).hii);
      paramContext.aJN(((k.b)localObject1).thumburl);
      localagy.a(paramContext);
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.XM(14);
      paramContext.vz(true);
      paramContext.vy(true);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECj += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new ahm();
      paramContext.aJv(((k.b)localObject1).title);
      paramContext.aJw(((k.b)localObject1).description);
      paramContext.XS(((k.b)localObject1).hik);
      paramContext.aJy(((k.b)localObject1).hil);
      paramContext.aJx(((k.b)localObject1).thumburl);
      localagy.a(paramContext);
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.XM(11);
      paramContext.vz(true);
      paramContext.vy(true);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECg += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambo, paramContext.getString(2131755833), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.aIC(((k.b)localObject1).title);
      paramContext.aID(((k.b)localObject1).description);
      paramContext.XM(19);
      localObject2 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (bs.isNullOrNil((String)localObject2)) {
        paramContext.vz(true);
      }
      if (com.tencent.mm.vfs.i.eA((String)localObject2)) {
        paramContext.aIR((String)localObject2);
      }
      localObject2 = new agv();
      if (!bs.isNullOrNil(((k.b)localObject1).hke)) {
        ((agv)localObject2).username = ((k.b)localObject1).hke;
      }
      if (!bs.isNullOrNil(((k.b)localObject1).hkf)) {
        ((agv)localObject2).appId = ((k.b)localObject1).hkf;
      }
      if (!bs.isNullOrNil(((k.b)localObject1).hks)) {
        ((agv)localObject2).iconUrl = ((k.b)localObject1).hks;
      }
      ((agv)localObject2).jWX = ((k.b)localObject1).hkn;
      ((agv)localObject2).type = ((k.b)localObject1).hkg;
      ((agv)localObject2).dib = ((k.b)localObject1).hki;
      ((agv)localObject2).cYQ = ((k.b)localObject1).hkd;
      ((agv)localObject2).EyV = ((k.b)localObject1).dvm;
      localagy.b((agv)localObject2);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      paramContext.zU(parambo.field_msgId);
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambo, paramContext.getString(2131755786) + ((k.b)localObject1).title, localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = ((k.b)localObject1).r(paramContext, true);
      if (bs.isNullOrNil(paramContext))
      {
        paramcs.dck.dcp = 2131758893;
        AppMethodBeat.o(30985);
        return false;
      }
      paramContext = a(parambo, paramContext + ((k.b)localObject1).title, localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).hij != null) && (((k.b)localObject1).hij.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new agx();
        ((agx)localObject2).aIU(az(parambo));
        ((agx)localObject2).XM(17);
        ((agx)localObject2).vz(true);
        ((agx)localObject2).aIC(((k.b)localObject1).title);
        ((agx)localObject2).aJc(((k.b)localObject1).hij);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new pw();
        ((pw)localObject3).dsN.type = 0;
        ((pw)localObject3).dsN.dsP = ((k.b)localObject1).hij;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((pw)localObject3).dsO.dsX;
        if (localObject1 == null) {
          break label3371;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hkS.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (bs.isNullOrNil(((agx)((Iterator)localObject3).next()).EAx));
        paramcs.dck.dcp = 2131758893;
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
      ((agx)localObject2).aID(paramContext);
      ((agx)localObject2).a(localagy);
      ((agx)localObject2).aIX(a(localagy.EAG));
      ((agx)localObject2).aIY(b(localagy.EAG));
      ((agx)localObject2).zU(parambo.field_msgId);
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        paramContext = localagy.EAG.EBj;
        paramContext = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramContext));
        if (!bs.isNullOrNil(paramContext)) {
          ((agx)localObject2).aJg(paramContext);
        }
      }
      paramcs.dck.dcm.nxC.add(localObject2);
      AppMethodBeat.o(30985);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cs paramcs, String paramString, List<bo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ac.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bo)((Iterator)localObject1).next();
      if (bk.x((bo)localObject2)) {
        switch (((bo)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((bo)localObject2).setContent(paramContext.getString(2131755904));
          break;
        case 3: 
          ((bo)localObject2).setContent(paramContext.getString(2131755853));
          ((bo)localObject2).setType(1);
          break;
        case 43: 
          ((bo)localObject2).setContent(paramContext.getString(2131755926));
          ((bo)localObject2).setType(1);
          break;
        case 49: 
          ((bo)localObject2).setContent(paramContext.getString(2131755914));
          ((bo)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.al.f.so(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (bo)paramList.get(0);
      if (paramList.eZj())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.ah.u)localObject1).hkS != null) && (((com.tencent.mm.ah.u)localObject1).hkS.size() == 1))
        {
          paramBoolean = g.e(paramcs, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramcs.dck.dcm = new ahn();
        paramcs.dck.dcn = new aib();
        paramcs.dck.dcm.a(aFX(paramString));
        paramcs.dck.type = 14;
        paramBoolean = b(paramContext, paramcs, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = g.e(paramcs, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramcs.dck.dcm = new ahn();
    paramcs.dck.dcn = new aib();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.al.a.e.qb(((bo)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.Br((String)localObject1))
      {
        paramcs.dck.dcm.aJA(paramContext.getString(2131762236));
        ac.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcs.dck.dcm.title });
      }
    }
    else
    {
      paramcs.dck.dcm.a(aFX(paramString));
      paramcs.dck.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcs, (bo)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.al.a.e.Bu(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcs.dck.dcm.aJA(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.al.a.k)localObject2).field_userName, com.tencent.mm.al.a.e.Bs((String)localObject1) }));
        break;
        label633:
        if (w.sQ(paramString))
        {
          paramcs.dck.dcm.aJA(paramContext.getString(2131762236));
          break;
        }
        localObject1 = bs.nullAsNil(com.tencent.mm.model.u.axy());
        if (((String)localObject1).equals(bs.nullAsNil(com.tencent.mm.model.v.wj(paramString))))
        {
          paramcs.dck.dcm.aJA(paramContext.getString(2131758964, new Object[] { localObject1 }));
          break;
        }
        paramcs.dck.dcm.aJA(paramContext.getString(2131758963, new Object[] { com.tencent.mm.model.u.axy(), com.tencent.mm.model.v.wj(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcs.dck.dcp > 0)) {
      paramcs.dck.dcp = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30978);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    Object localObject = bv.L(parambo.field_content, "msg");
    if (localObject != null) {
      try
      {
        ahe localahe = new ahe();
        localahe.aJt((String)((Map)localObject).get(".msg.location.$label"));
        localahe.B(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localahe.A(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localahe.XR(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localahe.aJu((String)((Map)localObject).get(".msg.location.$poiname"));
        localagy.c(localahe);
        localObject = new agx();
        ((agx)localObject).aIU(az(parambo));
        ((agx)localObject).XM(6);
        ((agx)localObject).vz(true);
        ((agx)localObject).vy(true);
        ((agx)localObject).a(localagy);
        ((agx)localObject).aIX(a(localagy.EAG));
        ((agx)localObject).aIY(b(localagy.EAG));
        if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
        {
          parambo = localagy.EAG.EBj;
          parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
          if (!bs.isNullOrNil(parambo)) {
            ((agx)localObject).aJg(parambo);
          }
        }
        paramcs.dck.dcm.nxC.add(localObject);
        parambo = paramcs.dck.dcn;
        parambo.ECc += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception parambo)
      {
        ac.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambo.getStackTrace().toString() });
      }
    }
    paramcs.dck.dcp = 2131758895;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static String aFW(String paramString)
  {
    AppMethodBeat.i(30980);
    az.ayM();
    paramString = l.d(com.tencent.mm.model.c.awO(), "recbiz_", paramString, ".rec", 2);
    if (bs.isNullOrNil(paramString))
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
  
  private static aht aFX(String paramString)
  {
    AppMethodBeat.i(30971);
    aht localaht = new aht();
    localaht.aJC(paramString);
    localaht.XV(1);
    localaht.zY(bs.eWj());
    localaht.aJE("");
    AppMethodBeat.o(30971);
    return localaht;
  }
  
  private static agz ay(bo parambo)
  {
    AppMethodBeat.i(30972);
    agz localagz = new agz();
    if (parambo == null)
    {
      AppMethodBeat.o(30972);
      return localagz;
    }
    Object localObject;
    if (parambo.field_isSend == 0)
    {
      localagz.aJl(parambo.field_talker);
      localagz.aJm(com.tencent.mm.model.u.axw());
      if (w.sQ(parambo.field_talker))
      {
        if (parambo.field_content == null) {
          break label343;
        }
        localObject = parambo.field_content.substring(0, Math.max(0, parambo.field_content.indexOf(':')));
        localagz.aJo((String)localObject);
        if ((!bs.isNullOrNil(localagz.EBj)) && (!parambo.eZl()))
        {
          parambo.setContent(parambo.field_content.substring(localagz.EBj.length() + 1));
          if ((parambo.field_content.length() > 0) && ('\n' == parambo.field_content.charAt(0))) {
            parambo.setContent(parambo.field_content.substring(1));
          }
          if (parambo.fbO())
          {
            parambo.rh(parambo.field_transContent.substring(localagz.EBj.length() + 1));
            if ((parambo.field_transContent.length() > 0) && ('\n' == parambo.field_transContent.charAt(0))) {
              parambo.rh(parambo.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.al.f.so(parambo.field_talker))
      {
        String str = parambo.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bi.yr(parambo.eul).userId;
        }
        localagz.aJo((String)localObject);
      }
      localagz.XQ(1);
      localagz.zV(parambo.field_createTime);
      localagz.aJp(parambo.field_msgSvrId);
      if (parambo.field_msgSvrId > 0L) {
        localagz.aJn(parambo.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localagz;
      label343:
      localObject = "";
      break;
      localagz.aJl(com.tencent.mm.model.u.axw());
      localagz.aJm(parambo.field_talker);
      if (w.sQ(parambo.field_talker)) {
        localagz.aJo(localagz.dng);
      }
    }
  }
  
  private static String az(bo parambo)
  {
    AppMethodBeat.i(30975);
    if (parambo.field_isSend == 1)
    {
      if ((w.sQ(parambo.field_talker)) || (parambo.field_talker.equals("filehelper")))
      {
        parambo = String.format("%d", new Object[] { Long.valueOf(parambo.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return parambo;
      }
      parambo = String.format("%s#%d", new Object[] { parambo.field_talker, Long.valueOf(parambo.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return parambo;
    }
    long l = parambo.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String b(agz paramagz)
  {
    AppMethodBeat.i(30974);
    paramagz = wiM.format(new Date(paramagz.createTime));
    AppMethodBeat.o(30974);
    return paramagz;
  }
  
  private static boolean b(Context paramContext, cs paramcs, bo parambo)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramcs == null) || (parambo == null))
    {
      ac.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    parambo = bo.aK(parambo);
    if (parambo.isText()) {
      bool = f(paramcs, parambo);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(parambo, paramcs, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (parambo.eZl()) {
        bool = m(paramcs, parambo);
      } else if (parambo.cKP()) {
        bool = a(paramcs, parambo);
      } else if (parambo.eZm()) {
        bool = l(paramcs, parambo);
      } else if (parambo.crt()) {
        bool = c(paramcs, parambo);
      } else if (parambo.crv()) {
        bool = c(paramcs, parambo);
      } else if (parambo.cru()) {
        bool = com.tencent.mm.plugin.record.b.b.b(paramcs, parambo);
      } else if (parambo.eZj()) {
        bool = d(paramcs, parambo);
      } else if (parambo.fbB()) {
        bool = c(paramContext, paramcs, parambo);
      } else if ((parambo.cKN()) && (!parambo.fbD())) {
        bool = a(paramContext, paramcs, parambo);
      } else {
        paramcs.dck.dcp = 2131758893;
      }
    }
  }
  
  private static boolean c(Context paramContext, cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30982);
    az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().alw(parambo.field_content);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    if ((localObject != null) && (w.nN(((bo.a)localObject).Chb)))
    {
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.XM(16);
      paramContext.aID(parambo.field_content);
      paramContext.vz(true);
      paramContext.vy(true);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      if (!com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj)) {
        break label337;
      }
      parambo = localagy.EAG.EBj;
      parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
      if (!bs.isNullOrNil(parambo)) {
        paramContext.aJg(parambo);
      }
    }
    label337:
    for (;;)
    {
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECk += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (com.tencent.mm.storage.ai.aNc(((bo.a)localObject).zTO)))
      {
        localObject = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(((bo.a)localObject).GZb, "openim_card_type_name", b.a.inW);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(parambo, paramContext, localagy);
          break;
        }
      }
      paramContext = a(parambo, paramContext.getString(2131755784), localagy);
    }
  }
  
  private static boolean c(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30981);
    Object localObject = new agy();
    ((agy)localObject).c(ay(parambo));
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIQ(t.DV(parambo.field_imgPath));
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIR(t.DW(parambo.field_imgPath));
    localagx.aIM(com.tencent.mm.vfs.i.VW(localagx.EzD));
    if (parambo.crv()) {
      localagx.XM(15);
    }
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      if (locals != null) {
        break;
      }
      ac.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(30981);
      return false;
      localagx.XM(4);
    }
    ac.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.hux) });
    if (locals.hux > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(false))
    {
      paramcs.dck.dcp = 2131759024;
      AppMethodBeat.o(30981);
      return false;
    }
    if ((parambo.crv()) && (com.tencent.mm.modelvideo.u.El(locals.getFileName())))
    {
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(30981);
      return false;
    }
    localagx.XL(locals.hpy);
    localagx.a((agy)localObject);
    localagx.aIX(a(((agy)localObject).EAG));
    localagx.aIY(b(((agy)localObject).EAG));
    if (com.tencent.mm.storage.ai.aNc(((agy)localObject).EAG.EBj))
    {
      localObject = ((agy)localObject).EAG.EBj;
      localObject = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject));
      if (!bs.isNullOrNil((String)localObject)) {
        localagx.aJg((String)localObject);
      }
    }
    localagx.zU(parambo.field_msgId);
    localagx.aJk(bk.yu(parambo.eul));
    localagx.zS(locals.hux);
    paramcs.dck.dcm.nxC.add(localagx);
    paramcs = paramcs.dck.dcn;
    paramcs.sKb += 1;
    paramcs = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    localagx.aJa(paramcs.dvs);
    paramcs = paramcs.iaR;
    if ((paramcs != null) && (!bs.isNullOrNil(paramcs.hkb)))
    {
      parambo = new aha();
      parambo.hjV = paramcs.hjV;
      parambo.EBs = paramcs.EBs;
      parambo.hjY = paramcs.hjY;
      parambo.hjZ = paramcs.hjZ;
      parambo.hjX = paramcs.hjX;
      parambo.hka = paramcs.hka;
      parambo.hkb = paramcs.hkb;
      parambo.hkc = paramcs.hkc;
      localagx.a(parambo);
    }
    AppMethodBeat.o(30981);
    return true;
  }
  
  private static boolean d(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30987);
    try
    {
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
      Object localObject1 = localu.hkS;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ah.v localv = (com.tencent.mm.ah.v)((Iterator)localObject1).next();
          if (!m.vC(localv.hli))
          {
            agy localagy = new agy();
            localagy.c(ay(parambo));
            localagy.EAG.aJs(localu.dvl);
            localagy.EAG.aJr(localv.url);
            Object localObject2 = new agx();
            ((agx)localObject2).aIC(localv.title);
            ((agx)localObject2).aID(localv.hlf);
            ((agx)localObject2).aIU(az(parambo));
            if (!bs.isNullOrNil(localv.hld)) {
              ((agx)localObject2).aIR(r.aGc(localv.hld));
            }
            for (;;)
            {
              ((agx)localObject2).vy(true);
              aic localaic = new aic();
              if (!bs.isNullOrNil(localv.title)) {
                localaic.aJP(localv.title);
              }
              if (!bs.isNullOrNil(localv.hlf)) {
                localaic.aJQ(localv.hlf);
              }
              if (!bs.isNullOrNil(localv.hld)) {
                localaic.aJS(m.a(localv));
              }
              if (localaic.computeSize() > 0)
              {
                localaic.XW(1);
                localagy.a(localaic);
              }
              ((agx)localObject2).XM(5);
              ((agx)localObject2).a(localagy);
              ((agx)localObject2).aIX(a(localagy.EAG));
              ((agx)localObject2).aIY(b(localagy.EAG));
              if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
              {
                String str = localagy.EAG.EBj;
                str = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str));
                if (!bs.isNullOrNil(str)) {
                  ((agx)localObject2).aJg(str);
                }
              }
              paramcs.dck.dcm.nxC.add(localObject2);
              localObject2 = paramcs.dck.dcn;
              ((aib)localObject2).ECb += 1;
              localagy.d(m.a(localv, localaic, localu.dvl, localu.dvm));
              i += 1;
              break;
              ((agx)localObject2).vz(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception parambo)
    {
      ac.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambo, "", new Object[0]);
      ac.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambo.getLocalizedMessage() });
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30987);
      return false;
    }
    paramcs.dck.dcp = 2131758893;
    AppMethodBeat.o(30987);
    return false;
    label557:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean f(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30976);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    localagx.XM(1);
    if (parambo.fch()) {}
    for (String str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; str = "")
    {
      localagx.aID(str + parambo.field_content);
      localagx.vz(true);
      localagx.vy(true);
      localagx.a(localagy);
      localagx.aIX(a(localagy.EAG));
      localagx.aIY(b(localagy.EAG));
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          localagx.aJg(parambo);
        }
      }
      paramcs.dck.dcm.nxC.add(localagx);
      paramcs = paramcs.dck.dcn;
      paramcs.EBY += 1;
      AppMethodBeat.o(30976);
      return true;
    }
  }
  
  private static boolean l(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30977);
    Object localObject1 = null;
    if (parambo.field_msgId > 0L) {
      localObject1 = com.tencent.mm.av.o.aFx().qg((int)parambo.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.e)localObject1).dcd > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambo.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.av.o.aFx().qf(parambo.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ac.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcs.dck.dcp = 2131758891;
      AppMethodBeat.o(30977);
      return false;
    }
    agy localagy = new agy();
    localagy.c(ay(parambo));
    localObject1 = new agx();
    ((agx)localObject1).aIU(az(parambo));
    ((agx)localObject1).XM(2);
    ((agx)localObject1).aIQ(com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c((com.tencent.mm.av.e)localObject2), "", ""));
    if (((com.tencent.mm.av.e)localObject2).aFa())
    {
      localObject2 = com.tencent.mm.av.o.aFx().oR(((com.tencent.mm.av.e)localObject2).hGX);
      if (((com.tencent.mm.av.e)localObject2).hux > ((com.tencent.mm.av.e)localObject2).offset) {
        ((agx)localObject1).aIQ(com.tencent.mm.av.o.aFx().p("SERVERID://" + parambo.field_msgSvrId, "", ""));
      }
    }
    ((agx)localObject1).aIR(com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true));
    ((agx)localObject1).a(localagy);
    ((agx)localObject1).aIX(a(localagy.EAG));
    ((agx)localObject1).aIY(b(localagy.EAG));
    ((agx)localObject1).zU(parambo.field_msgId);
    ((agx)localObject1).aJk(bk.yu(parambo.eul));
    if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
    {
      parambo = localagy.EAG.EBj;
      parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
      if (!bs.isNullOrNil(parambo)) {
        ((agx)localObject1).aJg(parambo);
      }
    }
    paramcs.dck.dcm.nxC.add(localObject1);
    paramcs = paramcs.dck.dcn;
    paramcs.EBZ += 1;
    AppMethodBeat.o(30977);
    return true;
  }
  
  private static boolean m(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30979);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    localagx.XM(3);
    if (w.xd(parambo.field_talker)) {
      localagx.aIQ(aFW(parambo.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localagx.vz(true);
      localb = com.tencent.mm.modelvoice.s.EC(parambo.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30979);
      return false;
      localagx.aIQ(com.tencent.mm.modelvoice.s.getFullPath(parambo.field_imgPath));
    }
    localagx.aIM(g.Wq(localb.getFormat()));
    localagx.XL((int)new p(parambo.field_content).time);
    localagx.a(localagy);
    localagx.aIX(a(localagy.EAG));
    localagx.aIY(b(localagy.EAG));
    if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
    {
      parambo = localagy.EAG.EBj;
      parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
      if (!bs.isNullOrNil(parambo)) {
        localagx.aJg(parambo);
      }
    }
    paramcs.dck.dcm.nxC.add(localagx);
    paramcs = paramcs.dck.dcn;
    paramcs.ECa += 1;
    AppMethodBeat.o(30979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */