package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
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
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
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
  private static final SimpleDateFormat wiM;
  
  static
  {
    AppMethodBeat.i(9458);
    wiM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static agx a(bo parambo, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localagx;
      localagx.vz(true);
    }
  }
  
  private static agx a(bo parambo, String paramString, agy paramagy)
  {
    AppMethodBeat.i(9455);
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
    AppMethodBeat.o(9455);
    return localagx;
  }
  
  private static String a(agz paramagz)
  {
    AppMethodBeat.i(9448);
    String str2 = paramagz.EBj;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = paramagz.dng;
    }
    if (com.tencent.mm.al.a.e.Bq(str1))
    {
      paramagz = com.tencent.mm.al.a.e.Bs(str1);
      AppMethodBeat.o(9448);
      return paramagz;
    }
    paramagz = com.tencent.mm.model.v.wj(str1);
    AppMethodBeat.o(9448);
    return paramagz;
  }
  
  private static boolean a(Context paramContext, cs paramcs, bo parambo)
  {
    AppMethodBeat.i(9456);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    Object localObject1 = parambo.field_content;
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.vA((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localagy.EAG.aJq(((k.b)localObject1).appId);
    localagy.EAG.aJs(((k.b)localObject1).dvl);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).CC()))
    {
      paramContext = a(parambo, paramContext.getString(2131755785), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(parambo, paramContext.getString(2131755898), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
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
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bEO().aGd(((k.b)localObject1).cZa);
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      if (localObject2 != null) {
        paramContext.aIQ(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (i.eA((String)localObject2)) {
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
      AppMethodBeat.o(9456);
      return true;
    case 3: 
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
      if (((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.aJi(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.aJj(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.ECd += 1;
      AppMethodBeat.o(9456);
      return true;
    case 4: 
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
      AppMethodBeat.o(9456);
      return true;
    case 5: 
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
        localagy.d(m.a(parambo, (aic)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramcs.dck.dcp = 2131758889;
      paramContext = a(parambo, paramContext.getString(2131755898), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
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
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bEO().aGd(((k.b)localObject1).cZa);
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
      if (i.eA((String)localObject2)) {
        paramContext.aIR((String)localObject2);
      }
      paramContext.aIC(((k.b)localObject1).title);
      paramContext.aID(((k.b)localObject1).description);
      paramContext.a(localagy);
      paramContext.aIX(a(localagy.EAG));
      paramContext.aIY(b(localagy.EAG));
      paramContext.zU(parambo.field_msgId);
      paramContext.zS(((k.b)localObject1).hhF);
      if (com.tencent.mm.storage.ai.aNc(localagy.EAG.EBj))
      {
        parambo = localagy.EAG.EBj;
        parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
        if (!bs.isNullOrNil(parambo)) {
          paramContext.aJg(parambo);
        }
      }
      paramContext.aIG(((k.b)localObject1).hhU);
      paramContext.aIH(((k.b)localObject1).fQi);
      paramContext.aJf(((k.b)localObject1).hhL);
      paramContext.aJd(((k.b)localObject1).fQi);
      paramContext.aJe(((k.b)localObject1).hhR);
      paramcs.dck.dcm.nxC.add(paramContext);
      paramContext = paramcs.dck.dcn;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).cZa == null) || (((k.b)localObject1).cZa.length() == 0)) {
        paramcs.dck.dcp = 2131758886;
      }
      do
      {
        paramcs.dck.dcp = 2131758893;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.g.agS();
      } while (com.tencent.mm.kernel.g.agR().isSDCardAvailable());
      paramcs.dck.dcp = 2131758901;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
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
      AppMethodBeat.o(9456);
      return true;
    case 20: 
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
      AppMethodBeat.o(9456);
      return true;
    case 13: 
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
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(parambo, paramContext.getString(2131755833), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if (((k.b)localObject1).hkg == 3)
      {
        paramContext = a(parambo, paramContext.getString(2131755833), localagy);
        paramcs.dck.dcm.nxC.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = new agx();
      paramContext.aIU(az(parambo));
      paramContext.aIC(((k.b)localObject1).title);
      paramContext.aID(((k.b)localObject1).description);
      paramContext.XM(19);
      localObject2 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (bs.isNullOrNil((String)localObject2)) {
        paramContext.vz(true);
      }
      if (i.eA((String)localObject2)) {
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
      ((agv)localObject2).type = ((k.b)localObject1).hkg;
      ((agv)localObject2).dib = ((k.b)localObject1).hkq;
      ((agv)localObject2).cYQ = ((k.b)localObject1).hkd;
      ((agv)localObject2).EyV = ((k.b)localObject1).dvm;
      ((agv)localObject2).jWX = ((k.b)localObject1).hkn;
      localObject1 = (com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class);
      if (localObject1 != null)
      {
        ((agv)localObject2).ccR = ((com.tencent.mm.ah.a)localObject1).hfZ;
        ((agv)localObject2).dxK = ((com.tencent.mm.ah.a)localObject1).hgb;
        ((agv)localObject2).subType = ((com.tencent.mm.ah.a)localObject1).hgc;
      }
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
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(parambo, paramContext.getString(2131755786) + ((k.b)localObject1).title, localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).r(paramContext, true);
      if (bs.isNullOrNil((String)localObject2))
      {
        paramContext = a(parambo, paramContext.getString(2131755898), localagy);
        paramcs.dck.dcm.nxC.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(parambo, (String)localObject2 + ((k.b)localObject1).title, localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).hij != null) && (((k.b)localObject1).hij.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hkS.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bs.isNullOrNil(((agx)((Iterator)localObject3).next()).EAx))
              {
                paramcs.dck.dcp = 2131758893;
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
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambo, paramContext.getString(2131759036), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambo, paramContext.getString(2131755860), localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
  }
  
  private static boolean a(Context paramContext, cs paramcs, bo parambo, int paramInt)
  {
    AppMethodBeat.i(9446);
    agy localagy = new agy();
    localagy.c(ay(parambo));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131755722);
    }
    for (;;)
    {
      paramContext = a(parambo, str, localagy);
      paramcs.dck.dcm.nxC.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131755839);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131755898);
      }
    }
  }
  
  public static boolean a(Context paramContext, cs paramcs, String paramString, List<bo> paramList)
  {
    AppMethodBeat.i(9445);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ac.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(9445);
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
    boolean bool1 = com.tencent.mm.al.f.so(paramString);
    paramList.size();
    paramcs.dck.dcm = new ahn();
    paramcs.dck.dcn = new aib();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.al.a.e.qb(((bo)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.Br((String)localObject1))
      {
        paramcs.dck.dcm.aJA(paramContext.getString(2131762236));
        ac.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcs.dck.dcm.title });
      }
    }
    else
    {
      localObject1 = paramcs.dck.dcm;
      localObject2 = new aht();
      ((aht)localObject2).aJC(paramString);
      ((aht)localObject2).XV(1);
      ((aht)localObject2).zY(bs.eWj());
      ((aht)localObject2).aJE("");
      ((ahn)localObject1).a((aht)localObject2);
      paramcs.dck.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label2319;
      }
      paramString = (bo)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      ac.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcs.dck.dcp = 2131758885;
      bool1 = false;
    }
    label531:
    for (;;)
    {
      label468:
      if (bool1)
      {
        j = 1;
        break label421;
        localObject2 = com.tencent.mm.al.a.e.Bu(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcs.dck.dcm.aJA(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.al.a.k)localObject2).field_userName, com.tencent.mm.al.a.e.Bs((String)localObject1) }));
        break;
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
        localObject2 = bo.aK(paramString);
        bool1 = false;
        Object localObject3;
        if (((bo)localObject2).isText())
        {
          localObject3 = new agy();
          ((agy)localObject3).c(ay((bo)localObject2));
          paramList = new agx();
          paramList.aIU(az((bo)localObject2));
          paramList.XM(1);
          if (((bo)localObject2).fch()) {}
          for (paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; paramString = "")
          {
            paramList.aID(paramString + ((dy)localObject2).field_content);
            paramList.vz(true);
            paramList.vy(true);
            paramList.a((agy)localObject3);
            paramList.aIX(a(((agy)localObject3).EAG));
            paramList.aIY(b(((agy)localObject3).EAG));
            if (com.tencent.mm.storage.ai.aNc(((agy)localObject3).EAG.EBj))
            {
              paramString = ((agy)localObject3).EAG.EBj;
              paramString = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString));
              if (!bs.isNullOrNil(paramString)) {
                paramList.aJg(paramString);
              }
            }
            paramcs.dck.dcm.nxC.add(paramList);
            paramString = paramcs.dck.dcn;
            paramString.EBY += 1;
            bool1 = true;
            break;
          }
        }
        if (((bo)localObject2).eZl())
        {
          paramList = new agy();
          paramList.c(ay((bo)localObject2));
          paramString = new agx();
          paramString.aIU(az((bo)localObject2));
          paramString.XM(3);
          paramString.vz(true);
          paramString.vy(true);
          paramString.a(paramList);
          paramString.aIX(a(paramList.EAG));
          paramString.aIY(b(paramList.EAG));
          if (com.tencent.mm.storage.ai.aNc(paramList.EAG.EBj))
          {
            paramList = paramList.EAG.EBj;
            paramList = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramList));
            if (!bs.isNullOrNil(paramList)) {
              paramString.aJg(paramList);
            }
          }
          paramcs.dck.dcm.nxC.add(paramString);
          paramString = paramcs.dck.dcn;
          paramString.ECa += 1;
          bool1 = true;
        }
        else if (((bo)localObject2).cKP())
        {
          bool1 = a(paramcs, (bo)localObject2);
        }
        else if (((bo)localObject2).eZm())
        {
          paramList = null;
          if (((dy)localObject2).field_msgId > 0L) {
            paramList = com.tencent.mm.av.o.aFx().qg((int)((dy)localObject2).field_msgId);
          }
          if (paramList != null)
          {
            paramString = paramList;
            if (paramList.dcd > 0L) {}
          }
          else
          {
            paramString = paramList;
            if (((dy)localObject2).field_msgSvrId > 0L) {
              paramString = com.tencent.mm.av.o.aFx().qf(((dy)localObject2).field_msgSvrId);
            }
          }
          if (paramString == null)
          {
            ac.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
            paramcs.dck.dcp = 2131758891;
            bool1 = false;
            continue;
          }
          localObject3 = new agy();
          ((agy)localObject3).c(ay((bo)localObject2));
          paramList = new agx();
          paramList.aIU(az((bo)localObject2));
          paramList.XM(2);
          paramList.aIQ(com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c(paramString), "", ""));
          if (paramString.aFa())
          {
            com.tencent.mm.av.e locale = com.tencent.mm.av.o.aFx().oR(paramString.hGX);
            if (locale.hux > locale.offset) {
              paramList.aIQ(com.tencent.mm.av.o.aFx().p("SERVERID://" + ((dy)localObject2).field_msgSvrId, "", ""));
            }
          }
          paramList.aIR(com.tencent.mm.av.o.aFx().R(((dy)localObject2).field_imgPath, true));
          paramList.a((agy)localObject3);
          paramList.aIX(a(((agy)localObject3).EAG));
          paramList.aIY(b(((agy)localObject3).EAG));
          paramList.zU(((dy)localObject2).field_msgId);
          paramList.aJk(bk.yu(((dy)localObject2).eul));
          if (com.tencent.mm.storage.ai.aNc(((agy)localObject3).EAG.EBj))
          {
            localObject3 = ((agy)localObject3).EAG.EBj;
            localObject3 = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject3));
            if (!bs.isNullOrNil((String)localObject3)) {
              paramList.aJg((String)localObject3);
            }
          }
          if ((!paramString.aFa()) || (paramString.hux != 0)) {
            break label2354;
          }
          paramString = com.tencent.mm.av.o.aFx().oR(paramString.hGX);
        }
      }
    }
    label650:
    label1554:
    label2351:
    label2354:
    for (;;)
    {
      int i;
      if (((dy)localObject2).field_isSend == 1) {
        if (paramString.aFa())
        {
          i = 1;
          localObject2 = bv.L(paramString.hGY, "msg");
          if (localObject2 == null) {
            break label1733;
          }
          if (i == 1)
          {
            paramList.aIG((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.zS(bs.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.aIH((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcs.dck.dcm.nxC.add(paramList);
        paramString = paramcs.dck.dcn;
        paramString.EBZ += 1;
        bool1 = true;
        break;
        i = 0;
        break label1554;
        if (!paramString.aFa())
        {
          i = 0;
          break label1554;
        }
        localObject2 = com.tencent.mm.av.f.a(paramString);
        if (!i.eA(com.tencent.mm.av.o.aFx().p(((com.tencent.mm.av.e)localObject2).hGM, "", "")))
        {
          i = 0;
          break label1554;
        }
        i = 1;
        break label1554;
        label1733:
        ac.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.hGY });
      }
      if (((bo)localObject2).crt())
      {
        bool1 = c(paramcs, (bo)localObject2);
        break label468;
      }
      if (((bo)localObject2).cru())
      {
        bool1 = b(paramcs, (bo)localObject2);
        break label468;
      }
      if (((bo)localObject2).crv())
      {
        bool1 = c(paramcs, (bo)localObject2);
        break label468;
      }
      if (((bo)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcs, (bo)localObject2, 3);
        break label468;
      }
      if (((bo)localObject2).eZj())
      {
        bool1 = d(paramcs, (bo)localObject2);
        break label468;
      }
      if ((((bo)localObject2).fbC()) || (((bo)localObject2).fbD()))
      {
        bool1 = a(paramContext, paramcs, (bo)localObject2, 1);
        break label468;
      }
      if (((bo)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcs, (bo)localObject2, 2);
        break label468;
      }
      if (((bo)localObject2).fbB())
      {
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().alw(((dy)localObject2).field_content);
        paramList = new agy();
        paramList.c(ay((bo)localObject2));
        if ((paramString != null) && (w.nN(paramString.Chb)))
        {
          paramString = new agx();
          paramString.aIU(az((bo)localObject2));
          paramString.XM(16);
          paramString.aID(((dy)localObject2).field_content);
          paramString.vz(true);
          paramString.vy(true);
          paramString.a(paramList);
          paramString.aIX(a(paramList.EAG));
          paramString.aIY(b(paramList.EAG));
          if (!com.tencent.mm.storage.ai.aNc(paramList.EAG.EBj)) {
            break label2351;
          }
          paramList = paramList.EAG.EBj;
          paramList = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramList));
          if (!bs.isNullOrNil(paramList)) {
            paramString.aJg(paramList);
          }
        }
      }
      for (;;)
      {
        paramcs.dck.dcm.nxC.add(paramString);
        paramString = paramcs.dck.dcn;
        paramString.ECk += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (com.tencent.mm.storage.ai.aNc(paramString.zTO)))
        {
          paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramString.GZb, "openim_card_type_name", b.a.inW);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131755784);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((bo)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((bo)localObject2, paramContext.getString(2131755784), paramList);
        continue;
        if (((bo)localObject2).cKN())
        {
          if (((bo)localObject2).fbD())
          {
            paramcs.dck.dcp = 2131758893;
            break label468;
          }
          bool1 = a(paramContext, paramcs, (bo)localObject2);
          break label468;
        }
        paramcs.dck.dcp = 2131758893;
        bool1 = a(paramContext, paramcs, (bo)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcs.dck.dcp > 0)) {
          paramcs.dck.dcp = 0;
        }
        AppMethodBeat.o(9445);
        return bool2;
      }
    }
  }
  
  private static boolean a(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(9451);
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
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception parambo)
      {
        ac.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { parambo.getStackTrace().toString() });
      }
    }
    paramcs.dck.dcp = 2131758895;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static agz ay(bo parambo)
  {
    AppMethodBeat.i(9447);
    agz localagz = new agz();
    if (parambo == null)
    {
      AppMethodBeat.o(9447);
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
      AppMethodBeat.o(9447);
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
    AppMethodBeat.i(9450);
    if (parambo.field_isSend == 1)
    {
      if ((w.sQ(parambo.field_talker)) || (parambo.field_talker.equals("filehelper")))
      {
        parambo = String.format("%d", new Object[] { Long.valueOf(parambo.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return parambo;
      }
      parambo = String.format("%s#%d", new Object[] { parambo.field_talker, Long.valueOf(parambo.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return parambo;
    }
    long l = parambo.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static String b(agz paramagz)
  {
    AppMethodBeat.i(9449);
    paramagz = wiM.format(new Date(paramagz.createTime));
    AppMethodBeat.o(9449);
    return paramagz;
  }
  
  public static boolean b(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.az(parambo.field_content, parambo.field_reserved);
    if (localObject2 == null)
    {
      ac.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new ahn();
    Object localObject3 = new aht();
    ((aht)localObject3).aJC(com.tencent.mm.model.u.axw());
    ((aht)localObject3).aJD(com.tencent.mm.model.u.axw());
    ((aht)localObject3).XV(4);
    ((aht)localObject3).zY(bs.eWj());
    ((aht)localObject3).aJJ(((k.b)localObject2).url);
    ((ahn)localObject1).a((aht)localObject3);
    localObject1 = new agx();
    ((agx)localObject1).aIQ("");
    ((agx)localObject1).aIL(((k.b)localObject2).thumburl);
    localObject3 = m.t(parambo);
    if (localObject3 == null)
    {
      ac.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((agx)localObject1).XL(((ahf)localObject3).duration);
    ((agx)localObject1).aIC(((k.b)localObject2).title);
    ((agx)localObject1).aII(((k.b)localObject2).url);
    ((agx)localObject1).vy(true);
    ((agx)localObject1).vz(true);
    localObject2 = new agy();
    ((agy)localObject2).c(ay(parambo));
    if (parambo.cru()) {
      ((agy)localObject2).e((ahf)localObject3);
    }
    ((agx)localObject1).a((agy)localObject2);
    ((agx)localObject1).zU(parambo.field_msgId);
    ((agx)localObject1).aIX(a(((agy)localObject2).EAG));
    ((agx)localObject1).aIY(b(((agy)localObject2).EAG));
    if (com.tencent.mm.storage.ai.aNc(((agy)localObject2).EAG.EBj))
    {
      parambo = ((agy)localObject2).EAG.EBj;
      parambo = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parambo));
      if (!bs.isNullOrNil(parambo)) {
        ((agx)localObject1).aJg(parambo);
      }
    }
    paramcs.dck.dcm.nxC.add(localObject1);
    paramcs = paramcs.dck.dcn;
    paramcs.sKb += 1;
    ((agx)localObject1).XM(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(9453);
    Object localObject2 = new agy();
    ((agy)localObject2).c(ay(parambo));
    agx localagx = new agx();
    localagx.aIU(az(parambo));
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIQ(t.DV(parambo.field_imgPath));
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIR(t.DW(parambo.field_imgPath));
    localagx.aIM(i.VW(localagx.EzD));
    if (parambo.crv()) {
      localagx.XM(15);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      ac.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(9453);
      return false;
      localagx.XM(4);
    }
    ac.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(((s)localObject1).hux) });
    if (((s)localObject1).hux > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcs.dck.dcp = 2131759025;
      AppMethodBeat.o(9453);
      return false;
    }
    if ((parambo.crv()) && (com.tencent.mm.modelvideo.u.El(((s)localObject1).getFileName())))
    {
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(9453);
      return false;
    }
    localagx.XL(((s)localObject1).hpy);
    localagx.a((agy)localObject2);
    localagx.aIX(a(((agy)localObject2).EAG));
    localagx.aIY(b(((agy)localObject2).EAG));
    if (com.tencent.mm.storage.ai.aNc(((agy)localObject2).EAG.EBj))
    {
      localObject2 = ((agy)localObject2).EAG.EBj;
      localObject2 = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject2));
      if (!bs.isNullOrNil((String)localObject2)) {
        localagx.aJg((String)localObject2);
      }
    }
    localagx.zU(parambo.field_msgId);
    localagx.aJk(bk.yu(parambo.eul));
    localagx.zS(((s)localObject1).hux);
    Object localObject1 = bv.L(((s)localObject1).aJK(), "msg");
    if (localObject1 != null)
    {
      localagx.aIG((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localagx.aIH((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
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
      AppMethodBeat.o(9453);
      return true;
      ac.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
    }
  }
  
  private static boolean d(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(9457);
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
      ac.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", parambo, "", new Object[0]);
      ac.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { parambo.getLocalizedMessage() });
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(9457);
      return false;
    }
    paramcs.dck.dcp = 2131758893;
    AppMethodBeat.o(9457);
    return false;
    label557:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.b
 * JD-Core Version:    0.7.0.1
 */