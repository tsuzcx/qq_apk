package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.l;
import com.tencent.mm.af.q;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
{
  private static final SimpleDateFormat pYf;
  
  static
  {
    AppMethodBeat.i(135638);
    pYf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(135638);
  }
  
  private static aca a(bi parambi, j.b paramb, int paramInt)
  {
    AppMethodBeat.i(135634);
    aca localaca = new aca();
    localaca.anI(ah(parambi));
    localaca.anx(paramb.fgU);
    localaca.any(paramb.fgV);
    localaca.anw(paramb.url);
    localaca.py(true);
    parambi = new File(bo.bf(com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true), ""));
    if (parambi.exists()) {
      localaca.anF(parambi.getAbsolutePath());
    }
    for (;;)
    {
      localaca.anq(paramb.title);
      localaca.anr(paramb.description);
      localaca.MI(paramInt);
      localaca.anP(paramb.canvasPageXml);
      AppMethodBeat.o(135634);
      return localaca;
      localaca.pz(true);
    }
  }
  
  private static aca a(bi parambi, String paramString, acb paramacb)
  {
    AppMethodBeat.i(135635);
    aca localaca = new aca();
    localaca.anI(ah(parambi));
    localaca.MI(1);
    localaca.anr(paramString);
    localaca.pz(true);
    localaca.py(true);
    localaca.a(paramacb);
    localaca.anL(a(paramacb.wUb));
    localaca.anM(b(paramacb.wUb));
    if (ad.arf(paramacb.wUb.wUA))
    {
      parambi = paramacb.wUb.wUA;
      parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
      if (!bo.isNullOrNil(parambi)) {
        localaca.anU(parambi);
      }
    }
    AppMethodBeat.o(135635);
    return localaca;
  }
  
  private static String a(acc paramacc)
  {
    AppMethodBeat.i(135629);
    String str2 = paramacc.wUA;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = paramacc.czp;
    }
    if (com.tencent.mm.aj.a.e.sm(str1))
    {
      paramacc = com.tencent.mm.aj.a.e.so(str1);
      AppMethodBeat.o(135629);
      return paramacc;
    }
    paramacc = com.tencent.mm.model.s.nD(str1);
    AppMethodBeat.o(135629);
    return paramacc;
  }
  
  private static boolean a(Context paramContext, cm paramcm, bi parambi)
  {
    AppMethodBeat.i(135636);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    Object localObject1 = parambi.field_content;
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(135636);
      return false;
    }
    localObject1 = j.b.mY((String)localObject1);
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(135636);
      return false;
    }
    localacb.wUb.aob(((j.b)localObject1).appId);
    localacb.wUb.aod(((j.b)localObject1).cGN);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, true);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).vY()))
    {
      paramContext = a(parambi, paramContext.getString(2131296970), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    }
    switch (((j.b)localObject1).type)
    {
    default: 
      paramContext = a(parambi, paramContext.getString(2131297080), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 1: 
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.MI(1);
      paramContext.anr(((j.b)localObject1).title);
      paramContext.pz(true);
      paramContext.py(true);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVr += 1;
      AppMethodBeat.o(135636);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(135636);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.aUJ().alo(((j.b)localObject1).cmN);
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      if (localObject2 != null) {
        paramContext.anE(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
      if (com.tencent.mm.a.e.cN((String)localObject2)) {
        paramContext.anF((String)localObject2);
      }
      paramContext.MI(2);
      paramContext.anq(((j.b)localObject1).title);
      paramContext.anr(((j.b)localObject1).description);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      paramContext.nE(parambi.field_msgId);
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVs += 1;
      AppMethodBeat.o(135636);
      return true;
    case 3: 
      paramContext = a(parambi, (j.b)localObject1, 7);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVx += 1;
      AppMethodBeat.o(135636);
      return true;
    case 4: 
      paramContext = a(parambi, (j.b)localObject1, 4);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      paramContext.nE(parambi.field_msgId);
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVu += 1;
      AppMethodBeat.o(135636);
      return true;
    case 5: 
      if ((((j.b)localObject1).url != null) && (!((j.b)localObject1).url.equals("")))
      {
        localacb.wUb.aoc(((j.b)localObject1).url);
        paramContext = a(parambi, (j.b)localObject1, 5);
        paramContext.a(localacb);
        paramContext.anL(a(localacb.wUb));
        paramContext.anM(b(localacb.wUb));
        if (ad.arf(localacb.wUb.wUA))
        {
          localObject2 = localacb.wUb.wUA;
          localObject2 = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject2));
          if (!bo.isNullOrNil((String)localObject2)) {
            paramContext.anU((String)localObject2);
          }
        }
        localObject2 = new adf();
        if (!bo.isNullOrNil(((j.b)localObject1).title)) {
          ((adf)localObject2).aoA(((j.b)localObject1).title);
        }
        if (!bo.isNullOrNil(((j.b)localObject1).description)) {
          ((adf)localObject2).aoB(((j.b)localObject1).description);
        }
        if (!bo.isNullOrNil(((j.b)localObject1).thumburl)) {
          ((adf)localObject2).aoD(((j.b)localObject1).thumburl);
        }
        if (!bo.isNullOrNil(((j.b)localObject1).canvasPageXml)) {
          ((adf)localObject2).aoE(((j.b)localObject1).canvasPageXml);
        }
        if (((adf)localObject2).computeSize() > 0)
        {
          ((adf)localObject2).MS(1);
          localacb.a((adf)localObject2);
        }
        paramcm.cpR.cpT.wVc.add(paramContext);
        paramContext = paramcm.cpR.cpU;
        paramContext.wVv += 1;
        localacb.b(l.a(parambi, (adf)localObject2));
        AppMethodBeat.o(135636);
        return true;
      }
      paramcm.cpR.cpX = 2131299717;
      paramContext = a(parambi, paramContext.getString(2131297080), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 6: 
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(135636);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.aUJ().alo(((j.b)localObject1).cmN);
      paramContext = new aca();
      if (localObject2 != null) {
        paramContext.anE(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      }
      paramContext.anI(ah(parambi));
      paramContext.MI(8);
      paramContext.anA(((j.b)localObject1).fgx);
      localObject2 = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
      if (bo.isNullOrNil((String)localObject2)) {
        paramContext.pz(true);
      }
      if (com.tencent.mm.a.e.cN((String)localObject2)) {
        paramContext.anF((String)localObject2);
      }
      paramContext.anq(((j.b)localObject1).title);
      paramContext.anr(((j.b)localObject1).description);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      paramContext.nE(parambi.field_msgId);
      paramContext.nC(((j.b)localObject1).fgw);
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramContext.anu(((j.b)localObject1).fgL);
      paramContext.anv(((j.b)localObject1).ewj);
      paramContext.anT(((j.b)localObject1).fgC);
      paramContext.anR(((j.b)localObject1).ewj);
      paramContext.anS(((j.b)localObject1).fgI);
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.fileCount += 1;
      AppMethodBeat.o(135636);
      return true;
    case 7: 
      if ((((j.b)localObject1).cmN == null) || (((j.b)localObject1).cmN.length() == 0)) {
        paramcm.cpR.cpX = 2131299714;
      }
      do
      {
        paramcm.cpR.cpX = 2131299721;
        AppMethodBeat.o(135636);
        return false;
        com.tencent.mm.kernel.g.RM();
      } while (com.tencent.mm.kernel.g.RL().isSDCardAvailable());
      paramcm.cpR.cpX = 2131299729;
      AppMethodBeat.o(135636);
      return false;
    case 10: 
      paramContext = new acp();
      paramContext.aog(((j.b)localObject1).title);
      paramContext.aoh(((j.b)localObject1).description);
      paramContext.MO(((j.b)localObject1).fgX);
      paramContext.aoj(((j.b)localObject1).fgY);
      paramContext.aoi(((j.b)localObject1).thumburl);
      localacb.a(paramContext);
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.MI(10);
      paramContext.pz(true);
      paramContext.py(true);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVz += 1;
      AppMethodBeat.o(135636);
      return true;
    case 20: 
      paramContext = new acz();
      paramContext.aow(((j.b)localObject1).title);
      paramContext.aox(((j.b)localObject1).description);
      paramContext.aoz(((j.b)localObject1).fhb);
      paramContext.aoy(((j.b)localObject1).thumburl);
      localacb.a(paramContext);
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.MI(14);
      paramContext.pz(true);
      paramContext.py(true);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVD += 1;
      AppMethodBeat.o(135636);
      return true;
    case 13: 
      paramContext = new acp();
      paramContext.aog(((j.b)localObject1).title);
      paramContext.aoh(((j.b)localObject1).description);
      paramContext.MO(((j.b)localObject1).fhd);
      paramContext.aoj(((j.b)localObject1).fhe);
      paramContext.aoi(((j.b)localObject1).thumburl);
      localacb.a(paramContext);
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.MI(11);
      paramContext.pz(true);
      paramContext.py(true);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVA += 1;
      AppMethodBeat.o(135636);
      return true;
    case 46: 
      paramContext = a(parambi, paramContext.getString(2131297016), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 33: 
    case 36: 
      if (((j.b)localObject1).fiZ == 3)
      {
        paramContext = a(parambi, paramContext.getString(2131297016), localacb);
        paramcm.cpR.cpT.wVc.add(paramContext);
        AppMethodBeat.o(135636);
        return true;
      }
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.anq(((j.b)localObject1).title);
      paramContext.anr(((j.b)localObject1).description);
      paramContext.MI(19);
      localObject2 = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
      if (bo.isNullOrNil((String)localObject2)) {
        paramContext.pz(true);
      }
      if (com.tencent.mm.a.e.cN((String)localObject2)) {
        paramContext.anF((String)localObject2);
      }
      localObject2 = new aby();
      if (!bo.isNullOrNil(((j.b)localObject1).fiX)) {
        ((aby)localObject2).username = ((j.b)localObject1).fiX;
      }
      if (!bo.isNullOrNil(((j.b)localObject1).fiY)) {
        ((aby)localObject2).appId = ((j.b)localObject1).fiY;
      }
      if (!bo.isNullOrNil(((j.b)localObject1).fjj)) {
        ((aby)localObject2).iconUrl = ((j.b)localObject1).fjj;
      }
      ((aby)localObject2).type = ((j.b)localObject1).fiZ;
      ((aby)localObject2).cvs = ((j.b)localObject1).fjb;
      ((aby)localObject2).cmG = ((j.b)localObject1).fiW;
      ((aby)localObject2).wSs = ((j.b)localObject1).cGO;
      localacb.a((aby)localObject2);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      paramContext.nE(parambi.field_msgId);
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          paramContext.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 48: 
      paramContext = a(parambi, paramContext.getString(2131296971) + ((j.b)localObject1).title, localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 44: 
      localObject2 = ((j.b)localObject1).q(paramContext, true);
      if (bo.isNullOrNil((String)localObject2))
      {
        paramContext = a(parambi, paramContext.getString(2131297080), localacb);
        paramcm.cpR.cpT.wVc.add(paramContext);
        AppMethodBeat.o(135636);
        return true;
      }
      paramContext = a(parambi, (String)localObject2 + ((j.b)localObject1).title, localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    case 19: 
      int i;
      if ((((j.b)localObject1).fhc != null) && (((j.b)localObject1).fhc.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
      {
        localObject2 = new aca();
        ((aca)localObject2).anI(ah(parambi));
        ((aca)localObject2).MI(17);
        ((aca)localObject2).pz(true);
        ((aca)localObject2).anq(((j.b)localObject1).title);
        ((aca)localObject2).anQ(((j.b)localObject1).fhc);
        paramContext = ((j.b)localObject1).description;
        Object localObject3 = new oa();
        ((oa)localObject3).cEz.type = 0;
        ((oa)localObject3).cEz.cEB = ((j.b)localObject1).fhc;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((oa)localObject3).cEA.cEK;
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).fjy.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bo.isNullOrNil(((aca)((Iterator)localObject3).next()).wTU))
              {
                paramcm.cpR.cpX = 2131299721;
                AppMethodBeat.o(135636);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label3577;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label3577:
    for (;;)
    {
      ((aca)localObject2).anr(paramContext);
      ((aca)localObject2).a(localacb);
      ((aca)localObject2).anL(a(localacb.wUb));
      ((aca)localObject2).anM(b(localacb.wUb));
      ((aca)localObject2).nE(parambi.field_msgId);
      if (ad.arf(localacb.wUb.wUA))
      {
        paramContext = localacb.wUb.wUA;
        paramContext = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramContext));
        if (!bo.isNullOrNil(paramContext)) {
          ((aca)localObject2).anU(paramContext);
        }
      }
      paramcm.cpR.cpT.wVc.add(localObject2);
      AppMethodBeat.o(135636);
      return true;
      paramContext = a(parambi, paramContext.getString(2131299859), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
      paramContext = a(parambi, paramContext.getString(2131297043), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135636);
      return true;
    }
  }
  
  private static boolean a(Context paramContext, cm paramcm, bi parambi, int paramInt)
  {
    AppMethodBeat.i(135627);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131296915);
    }
    for (;;)
    {
      paramContext = a(parambi, str, localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(135627);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131297022);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131297080);
      }
    }
  }
  
  public static boolean a(Context paramContext, cm paramcm, String paramString, List<bi> paramList)
  {
    AppMethodBeat.i(135626);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ab.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(135626);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bi)((Iterator)localObject1).next();
      if (bh.o((bi)localObject2)) {
        switch (((bi)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((bi)localObject2).setContent(paramContext.getString(2131297085));
          break;
        case 3: 
          ((bi)localObject2).setContent(paramContext.getString(2131297036));
          ((bi)localObject2).setType(1);
          break;
        case 43: 
          ((bi)localObject2).setContent(paramContext.getString(2131297102));
          ((bi)localObject2).setType(1);
          break;
        case 49: 
          ((bi)localObject2).setContent(paramContext.getString(2131297095));
          ((bi)localObject2).setType(1);
        }
      }
    }
    boolean bool1 = com.tencent.mm.aj.f.lg(paramString);
    paramList.size();
    paramcm.cpR.cpT = new acq();
    paramcm.cpR.cpU = new ade();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.aj.a.e.gN(((bi)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.aj.a.e.sn((String)localObject1))
      {
        paramcm.cpR.cpT.aol(paramContext.getString(2131302353));
        ab.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcm.cpR.cpT.title });
      }
    }
    else
    {
      localObject1 = paramcm.cpR.cpT;
      localObject2 = new acw();
      ((acw)localObject2).aon(paramString);
      ((acw)localObject2).MR(1);
      ((acw)localObject2).nI(bo.aoy());
      ((acw)localObject2).aop("");
      ((acq)localObject1).a((acw)localObject2);
      paramcm.cpR.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label2339;
      }
      paramString = (bi)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      ab.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcm.cpR.cpX = 2131299713;
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
        localObject2 = com.tencent.mm.aj.a.e.sq(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcm.cpR.cpT.aol(paramContext.getString(2131299789, new Object[] { ((com.tencent.mm.aj.a.j)localObject2).field_userName, com.tencent.mm.aj.a.e.so((String)localObject1) }));
        break;
        if (com.tencent.mm.model.t.lA(paramString))
        {
          paramcm.cpR.cpT.aol(paramContext.getString(2131302353));
          break;
        }
        localObject1 = bo.nullAsNil(r.Zp());
        if (((String)localObject1).equals(bo.nullAsNil(com.tencent.mm.model.s.nD(paramString))))
        {
          paramcm.cpR.cpT.aol(paramContext.getString(2131299790, new Object[] { localObject1 }));
          break;
        }
        paramcm.cpR.cpT.aol(paramContext.getString(2131299789, new Object[] { r.Zp(), com.tencent.mm.model.s.nD(paramString) }));
        break;
        localObject2 = bi.as(paramString);
        bool1 = false;
        Object localObject3;
        if (((bi)localObject2).isText())
        {
          localObject3 = new acb();
          ((acb)localObject3).c(ag((bi)localObject2));
          paramList = new aca();
          paramList.anI(ah((bi)localObject2));
          paramList.MI(1);
          if (((bi)localObject2).dyq())
          {
            paramString = ah.getContext().getString(2131302746, new Object[] { "@" }) + '\n';
            label757:
            if (((bi)localObject2).dyh()) {
              break label941;
            }
            paramList.anr(paramString + ((dd)localObject2).field_content);
          }
          for (;;)
          {
            paramList.pz(true);
            paramList.py(true);
            paramList.a((acb)localObject3);
            paramList.anL(a(((acb)localObject3).wUb));
            paramList.anM(b(((acb)localObject3).wUb));
            if (ad.arf(((acb)localObject3).wUb.wUA))
            {
              paramString = ((acb)localObject3).wUb.wUA;
              paramString = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString));
              if (!bo.isNullOrNil(paramString)) {
                paramList.anU(paramString);
              }
            }
            paramcm.cpR.cpT.wVc.add(paramList);
            paramString = paramcm.cpR.cpU;
            paramString.wVr += 1;
            bool1 = true;
            break;
            paramString = "";
            break label757;
            paramList.anr(paramString + ((dd)localObject2).field_content + "\n\n" + ((dd)localObject2).field_transContent);
          }
        }
        if (((bi)localObject2).dvW())
        {
          paramList = new acb();
          paramList.c(ag((bi)localObject2));
          paramString = new aca();
          paramString.anI(ah((bi)localObject2));
          paramString.MI(3);
          paramString.pz(true);
          paramString.py(true);
          paramString.a(paramList);
          paramString.anL(a(paramList.wUb));
          paramString.anM(b(paramList.wUb));
          if (ad.arf(paramList.wUb.wUA))
          {
            paramList = paramList.wUb.wUA;
            paramList = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramList));
            if (!bo.isNullOrNil(paramList)) {
              paramString.anU(paramList);
            }
          }
          paramcm.cpR.cpT.wVc.add(paramString);
          paramString = paramcm.cpR.cpU;
          paramString.wVt += 1;
          bool1 = true;
        }
        else if (((bi)localObject2).bCp())
        {
          bool1 = a(paramcm, (bi)localObject2);
        }
        else if (((bi)localObject2).dvX())
        {
          paramList = null;
          if (((dd)localObject2).field_msgId > 0L) {
            paramList = com.tencent.mm.at.o.ahC().gT((int)((dd)localObject2).field_msgId);
          }
          if (paramList != null)
          {
            paramString = paramList;
            if (paramList.fDL > 0L) {}
          }
          else
          {
            paramString = paramList;
            if (((dd)localObject2).field_msgSvrId > 0L) {
              paramString = com.tencent.mm.at.o.ahC().gS(((dd)localObject2).field_msgSvrId);
            }
          }
          if (paramString == null)
          {
            ab.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
            paramcm.cpR.cpX = 2131299719;
            bool1 = false;
            continue;
          }
          localObject3 = new acb();
          ((acb)localObject3).c(ag((bi)localObject2));
          paramList = new aca();
          paramList.anI(ah((bi)localObject2));
          paramList.MI(2);
          paramList.anE(com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c(paramString), "", ""));
          if (paramString.ahh())
          {
            com.tencent.mm.at.e locale = com.tencent.mm.at.o.ahC().lv(paramString.fDW);
            if (locale.fsd > locale.offset) {
              paramList.anE(com.tencent.mm.at.o.ahC().q("SERVERID://" + ((dd)localObject2).field_msgSvrId, "", ""));
            }
          }
          paramList.anF(com.tencent.mm.at.o.ahC().J(((dd)localObject2).field_imgPath, true));
          paramList.a((acb)localObject3);
          paramList.anL(a(((acb)localObject3).wUb));
          paramList.anM(b(((acb)localObject3).wUb));
          paramList.nE(((dd)localObject2).field_msgId);
          if (ad.arf(((acb)localObject3).wUb.wUA))
          {
            localObject3 = ((acb)localObject3).wUb.wUA;
            localObject3 = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject3));
            if (!bo.isNullOrNil((String)localObject3)) {
              paramList.anU((String)localObject3);
            }
          }
          if ((!paramString.ahh()) || (paramString.fsd != 0)) {
            break label2374;
          }
          paramString = com.tencent.mm.at.o.ahC().lv(paramString.fDW);
        }
      }
    }
    label650:
    label1593:
    label2371:
    label2374:
    for (;;)
    {
      int i;
      if (((dd)localObject2).field_isSend == 1) {
        if (paramString.ahh())
        {
          i = 1;
          localObject2 = br.F(paramString.fDX, "msg");
          if (localObject2 == null) {
            break label1772;
          }
          if (i == 1)
          {
            paramList.anu((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.nC(bo.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.anv((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcm.cpR.cpT.wVc.add(paramList);
        paramString = paramcm.cpR.cpU;
        paramString.wVs += 1;
        bool1 = true;
        break;
        i = 0;
        break label1593;
        if (!paramString.ahh())
        {
          i = 0;
          break label1593;
        }
        localObject2 = com.tencent.mm.at.f.a(paramString);
        if (!com.tencent.mm.a.e.cN(com.tencent.mm.at.o.ahC().q(((com.tencent.mm.at.e)localObject2).fDM, "", "")))
        {
          i = 0;
          break label1593;
        }
        i = 1;
        break label1593;
        label1772:
        ab.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.fDX });
      }
      if (((bi)localObject2).byj())
      {
        bool1 = b(paramcm, (bi)localObject2);
        break label468;
      }
      if (((bi)localObject2).byk())
      {
        bool1 = b(paramcm, (bi)localObject2);
        break label468;
      }
      if (((bi)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcm, (bi)localObject2, 3);
        break label468;
      }
      if (((bi)localObject2).dvV())
      {
        bool1 = c(paramcm, (bi)localObject2);
        break label468;
      }
      if ((((bi)localObject2).dxS()) || (((bi)localObject2).dxT()))
      {
        bool1 = a(paramContext, paramcm, (bi)localObject2, 1);
        break label468;
      }
      if (((bi)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcm, (bi)localObject2, 2);
        break label468;
      }
      if (((bi)localObject2).dxR())
      {
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Ty(((dd)localObject2).field_content);
        paramList = new acb();
        paramList.c(ag((bi)localObject2));
        if ((paramString != null) && (com.tencent.mm.model.t.ku(paramString.uOT)))
        {
          paramString = new aca();
          paramString.anI(ah((bi)localObject2));
          paramString.MI(16);
          paramString.anr(((dd)localObject2).field_content);
          paramString.pz(true);
          paramString.py(true);
          paramString.a(paramList);
          paramString.anL(a(paramList.wUb));
          paramString.anM(b(paramList.wUb));
          if (!ad.arf(paramList.wUb.wUA)) {
            break label2371;
          }
          paramList = paramList.wUb.wUA;
          paramList = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramList));
          if (!bo.isNullOrNil(paramList)) {
            paramString.anU(paramList);
          }
        }
      }
      for (;;)
      {
        paramcm.cpR.cpT.wVc.add(paramString);
        paramString = paramcm.cpR.cpU;
        paramString.wVE += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (ad.arf(paramString.tac)))
        {
          paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).a(paramString.yOm, "openim_card_type_name", b.a.gfD);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131296969);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((bi)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((bi)localObject2, paramContext.getString(2131296969), paramList);
        continue;
        if (((bi)localObject2).bCn())
        {
          if (((bi)localObject2).dxT())
          {
            paramcm.cpR.cpX = 2131299721;
            break label468;
          }
          bool1 = a(paramContext, paramcm, (bi)localObject2);
          break label468;
        }
        paramcm.cpR.cpX = 2131299721;
        bool1 = a(paramContext, paramcm, (bi)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcm.cpR.cpX > 0)) {
          paramcm.cpR.cpX = 0;
        }
        AppMethodBeat.o(135626);
        return bool2;
      }
    }
  }
  
  private static boolean a(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(135632);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    Object localObject = br.F(parambi.field_content, "msg");
    if (localObject != null) {
      try
      {
        ach localach = new ach();
        localach.aoe((String)((Map)localObject).get(".msg.location.$label"));
        localach.D(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localach.C(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localach.MN(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localach.aof((String)((Map)localObject).get(".msg.location.$poiname"));
        localacb.a(localach);
        localObject = new aca();
        ((aca)localObject).anI(ah(parambi));
        ((aca)localObject).MI(6);
        ((aca)localObject).pz(true);
        ((aca)localObject).py(true);
        ((aca)localObject).a(localacb);
        ((aca)localObject).anL(a(localacb.wUb));
        ((aca)localObject).anM(b(localacb.wUb));
        if (ad.arf(localacb.wUb.wUA))
        {
          parambi = localacb.wUb.wUA;
          parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
          if (!bo.isNullOrNil(parambi)) {
            ((aca)localObject).anU(parambi);
          }
        }
        paramcm.cpR.cpT.wVc.add(localObject);
        parambi = paramcm.cpR.cpU;
        parambi.wVw += 1;
        AppMethodBeat.o(135632);
        return true;
      }
      catch (Exception parambi)
      {
        ab.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { parambi.getStackTrace().toString() });
      }
    }
    paramcm.cpR.cpX = 2131299723;
    AppMethodBeat.o(135632);
    return false;
  }
  
  private static acc ag(bi parambi)
  {
    AppMethodBeat.i(135628);
    acc localacc = new acc();
    if (parambi == null)
    {
      AppMethodBeat.o(135628);
      return localacc;
    }
    Object localObject;
    if (parambi.field_isSend == 0)
    {
      localacc.anW(parambi.field_talker);
      localacc.anX(r.Zn());
      if (com.tencent.mm.model.t.lA(parambi.field_talker))
      {
        if (parambi.field_content == null) {
          break label343;
        }
        localObject = parambi.field_content.substring(0, Math.max(0, parambi.field_content.indexOf(':')));
        localacc.anZ((String)localObject);
        if ((!bo.isNullOrNil(localacc.wUA)) && (!parambi.dvW()))
        {
          parambi.setContent(parambi.field_content.substring(localacc.wUA.length() + 1));
          if ((parambi.field_content.length() > 0) && ('\n' == parambi.field_content.charAt(0))) {
            parambi.setContent(parambi.field_content.substring(1));
          }
          if (parambi.dya())
          {
            parambi.km(parambi.field_transContent.substring(localacc.wUA.length() + 1));
            if ((parambi.field_transContent.length() > 0) && ('\n' == parambi.field_transContent.charAt(0))) {
              parambi.km(parambi.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.aj.f.lg(parambi.field_talker))
      {
        String str = parambi.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bf.pA(parambi.dns).userId;
        }
        localacc.anZ((String)localObject);
      }
      localacc.MM(1);
      localacc.nF(parambi.field_createTime);
      localacc.aoa(parambi.field_msgSvrId);
      if (parambi.field_msgSvrId > 0L) {
        localacc.anY(parambi.field_msgSvrId);
      }
      AppMethodBeat.o(135628);
      return localacc;
      label343:
      localObject = "";
      break;
      localacc.anW(r.Zn());
      localacc.anX(parambi.field_talker);
      if (com.tencent.mm.model.t.lA(parambi.field_talker)) {
        localacc.anZ(localacc.czp);
      }
    }
  }
  
  private static String ah(bi parambi)
  {
    AppMethodBeat.i(135631);
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.t.lA(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
      {
        parambi = String.format("%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
        AppMethodBeat.o(135631);
        return parambi;
      }
      parambi = String.format("%s#%d", new Object[] { parambi.field_talker, Long.valueOf(parambi.field_msgSvrId) });
      AppMethodBeat.o(135631);
      return parambi;
    }
    long l = parambi.field_msgSvrId;
    AppMethodBeat.o(135631);
    return String.valueOf(l);
  }
  
  private static String b(acc paramacc)
  {
    AppMethodBeat.i(135630);
    paramacc = pYf.format(new Date(paramacc.createTime));
    AppMethodBeat.o(135630);
    return paramacc;
  }
  
  private static boolean b(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(135633);
    Object localObject2 = new acb();
    ((acb)localObject2).c(ag(parambi));
    aca localaca = new aca();
    localaca.anI(ah(parambi));
    com.tencent.mm.modelvideo.o.alE();
    localaca.anE(com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath));
    com.tencent.mm.modelvideo.o.alE();
    localaca.anF(com.tencent.mm.modelvideo.t.vg(parambi.field_imgPath));
    localaca.anA(com.tencent.mm.a.e.cP(localaca.wTa));
    if (parambi.byk()) {
      localaca.MI(15);
    }
    for (;;)
    {
      localObject1 = u.vr(parambi.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      ab.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(135633);
      return false;
      localaca.MI(4);
    }
    ab.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject1).fsd) });
    if (((com.tencent.mm.modelvideo.s)localObject1).fsd > com.tencent.mm.m.b.MX())
    {
      paramcm.cpR.cpX = 2131299848;
      AppMethodBeat.o(135633);
      return false;
    }
    if ((parambi.byk()) && (u.vt(((com.tencent.mm.modelvideo.s)localObject1).getFileName())))
    {
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(135633);
      return false;
    }
    localaca.MH(((com.tencent.mm.modelvideo.s)localObject1).fXx);
    localaca.a((acb)localObject2);
    localaca.anL(a(((acb)localObject2).wUb));
    localaca.anM(b(((acb)localObject2).wUb));
    if (ad.arf(((acb)localObject2).wUb.wUA))
    {
      localObject2 = ((acb)localObject2).wUb.wUA;
      localObject2 = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject2));
      if (!bo.isNullOrNil((String)localObject2)) {
        localaca.anU((String)localObject2);
      }
    }
    localaca.nE(parambi.field_msgId);
    localaca.nC(((com.tencent.mm.modelvideo.s)localObject1).fsd);
    Object localObject1 = br.F(((com.tencent.mm.modelvideo.s)localObject1).alP(), "msg");
    if (localObject1 != null)
    {
      localaca.anu((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localaca.anv((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
      paramcm.cpR.cpT.wVc.add(localaca);
      paramcm = paramcm.cpR.cpU;
      paramcm.wVu += 1;
      paramcm = u.vr(parambi.field_imgPath);
      localaca.anO(paramcm.cGU);
      paramcm = paramcm.fXG;
      if ((paramcm != null) && (!bo.isNullOrNil(paramcm.fiU)))
      {
        parambi = new acd();
        parambi.fiO = paramcm.fiO;
        parambi.wUJ = paramcm.wUJ;
        parambi.fiR = paramcm.fiR;
        parambi.fiS = paramcm.fiS;
        parambi.fiQ = paramcm.fiQ;
        parambi.fiT = paramcm.fiT;
        parambi.fiU = paramcm.fiU;
        parambi.fiV = paramcm.fiV;
        localaca.a(parambi);
      }
      AppMethodBeat.o(135633);
      return true;
      ab.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
    }
  }
  
  private static boolean c(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(135637);
    try
    {
      com.tencent.mm.af.p localp = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
      Object localObject1 = localp.fjy;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          q localq = (q)((Iterator)localObject1).next();
          if (!l.na(localq.fjO))
          {
            acb localacb = new acb();
            localacb.c(ag(parambi));
            localacb.wUb.aod(localp.cGN);
            localacb.wUb.aoc(localq.url);
            Object localObject2 = new aca();
            ((aca)localObject2).anq(localq.title);
            ((aca)localObject2).anr(localq.fjL);
            ((aca)localObject2).anI(ah(parambi));
            if (!bo.isNullOrNil(localq.fjJ)) {
              ((aca)localObject2).anF(com.tencent.mm.pluginsdk.model.p.aln(localq.fjJ));
            }
            for (;;)
            {
              ((aca)localObject2).py(true);
              adf localadf = new adf();
              if (!bo.isNullOrNil(localq.title)) {
                localadf.aoA(localq.title);
              }
              if (!bo.isNullOrNil(localq.fjL)) {
                localadf.aoB(localq.fjL);
              }
              if (!bo.isNullOrNil(localq.fjJ)) {
                localadf.aoD(l.a(localq));
              }
              if (localadf.computeSize() > 0)
              {
                localadf.MS(1);
                localacb.a(localadf);
              }
              ((aca)localObject2).MI(5);
              ((aca)localObject2).a(localacb);
              ((aca)localObject2).anL(a(localacb.wUb));
              ((aca)localObject2).anM(b(localacb.wUb));
              if (ad.arf(localacb.wUb.wUA))
              {
                String str = localacb.wUb.wUA;
                str = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str));
                if (!bo.isNullOrNil(str)) {
                  ((aca)localObject2).anU(str);
                }
              }
              paramcm.cpR.cpT.wVc.add(localObject2);
              localObject2 = paramcm.cpR.cpU;
              ((ade)localObject2).wVv += 1;
              localacb.b(l.a(localq, localadf, localp.cGN, localp.cGO));
              i += 1;
              break;
              ((aca)localObject2).pz(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception parambi)
    {
      ab.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", parambi, "", new Object[0]);
      ab.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { parambi.getLocalizedMessage() });
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(135637);
      return false;
    }
    paramcm.cpR.cpX = 2131299721;
    AppMethodBeat.o(135637);
    return false;
    label557:
    AppMethodBeat.o(135637);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.b
 * JD-Core Version:    0.7.0.1
 */