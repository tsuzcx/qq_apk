package com.tencent.mm.pluginsdk.model;

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
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
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

public final class g
{
  private static final SimpleDateFormat pYf;
  
  static
  {
    AppMethodBeat.i(27295);
    pYf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(27295);
  }
  
  private static aca a(bi parambi, j.b paramb, int paramInt)
  {
    AppMethodBeat.i(27291);
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
      AppMethodBeat.o(27291);
      return localaca;
      localaca.pz(true);
    }
  }
  
  private static aca a(bi parambi, String paramString, acb paramacb)
  {
    AppMethodBeat.i(27292);
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
    AppMethodBeat.o(27292);
    return localaca;
  }
  
  private static String a(acc paramacc)
  {
    AppMethodBeat.i(27281);
    String str2 = paramacc.wUA;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = paramacc.czp;
    }
    if (com.tencent.mm.aj.a.e.sm(str1))
    {
      paramacc = com.tencent.mm.aj.a.e.so(str1);
      AppMethodBeat.o(27281);
      return paramacc;
    }
    paramacc = com.tencent.mm.model.s.nD(str1);
    AppMethodBeat.o(27281);
    return paramacc;
  }
  
  private static void a(bi parambi, acb paramacb, adf paramadf)
  {
    AppMethodBeat.i(153689);
    paramacb.b(l.a(parambi, paramadf));
    AppMethodBeat.o(153689);
  }
  
  private static boolean a(Context paramContext, cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27293);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    Object localObject1 = parambi.field_content;
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27293);
      return false;
    }
    localObject1 = j.b.mY((String)localObject1);
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27293);
      return false;
    }
    localacb.wUb.aob(((j.b)localObject1).appId);
    localacb.wUb.aod(((j.b)localObject1).cGN);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, true);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.f)localObject2).vY();
    }
    switch (((j.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcm.cpR.cpX = 2131299721;
      AppMethodBeat.o(27293);
      return false;
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
      AppMethodBeat.o(27293);
      return true;
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(27293);
        return false;
      }
      localObject2 = al.aUJ().alo(((j.b)localObject1).cmN);
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
      AppMethodBeat.o(27293);
      return true;
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
      AppMethodBeat.o(27293);
      return true;
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
      AppMethodBeat.o(27293);
      return true;
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
        a(parambi, localacb, (adf)localObject2);
        AppMethodBeat.o(27293);
        return true;
      }
      paramcm.cpR.cpX = 2131299717;
      AppMethodBeat.o(27293);
      return false;
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(27293);
        return false;
      }
      localObject2 = al.aUJ().alo(((j.b)localObject1).cmN);
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
      paramContext.fileCount += 1;
      AppMethodBeat.o(27293);
      return true;
      if ((((j.b)localObject1).cmN == null) || (((j.b)localObject1).cmN.length() == 0)) {
        paramcm.cpR.cpX = 2131299714;
      }
      do
      {
        paramcm.cpR.cpX = 2131299721;
        AppMethodBeat.o(27293);
        return false;
        aw.aaz();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcm.cpR.cpX = 2131299729;
      AppMethodBeat.o(27293);
      return false;
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
      AppMethodBeat.o(27293);
      return true;
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
      AppMethodBeat.o(27293);
      return true;
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
      AppMethodBeat.o(27293);
      return true;
      paramContext = a(parambi, paramContext.getString(2131297016), localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(27293);
      return true;
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
      AppMethodBeat.o(27293);
      return true;
      paramContext = a(parambi, paramContext.getString(2131296971) + ((j.b)localObject1).title, localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(27293);
      return true;
      paramContext = ((j.b)localObject1).q(paramContext, true);
      if (bo.isNullOrNil(paramContext))
      {
        paramcm.cpR.cpX = 2131299721;
        AppMethodBeat.o(27293);
        return false;
      }
      paramContext = a(parambi, paramContext + ((j.b)localObject1).title, localacb);
      paramcm.cpR.cpT.wVc.add(paramContext);
      AppMethodBeat.o(27293);
      return true;
      if ((((j.b)localObject1).fhc != null) && (((j.b)localObject1).fhc.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
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
        if (localObject1 == null) {
          break label3138;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).fjy.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (bo.isNullOrNil(((aca)((Iterator)localObject3).next()).wTU));
        paramcm.cpR.cpX = 2131299721;
        AppMethodBeat.o(27293);
        return false;
      }
    }
    label3138:
    if (localObject1 != null) {
      paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
    }
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
      AppMethodBeat.o(27293);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cm paramcm, String paramString, List<bi> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(27277);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ab.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(27277);
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
    boolean bool = com.tencent.mm.aj.f.lg(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (bi)paramList.get(0);
      if (paramList.dvV())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.af.p)localObject1).fjy != null) && (((com.tencent.mm.af.p)localObject1).fjy.size() == 1))
        {
          paramBoolean = e.d(paramcm, paramList);
          AppMethodBeat.o(27277);
          return paramBoolean;
        }
        paramcm.cpR.cpT = new acq();
        paramcm.cpR.cpU = new ade();
        paramcm.cpR.cpT.a(ali(paramString));
        paramcm.cpR.type = 14;
        paramBoolean = b(paramContext, paramcm, paramList);
        AppMethodBeat.o(27277);
        return paramBoolean;
      }
      paramBoolean = e.d(paramcm, paramList);
      AppMethodBeat.o(27277);
      return paramBoolean;
    }
    paramcm.cpR.cpT = new acq();
    paramcm.cpR.cpU = new ade();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.aj.a.e.gN(((bi)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.aj.a.e.sn((String)localObject1))
      {
        paramcm.cpR.cpT.aol(paramContext.getString(2131302353));
        ab.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcm.cpR.cpT.title });
      }
    }
    else
    {
      paramcm.cpR.cpT.a(ali(paramString));
      paramcm.cpR.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcm, (bi)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.aj.a.e.sq(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcm.cpR.cpT.aol(paramContext.getString(2131299789, new Object[] { ((com.tencent.mm.aj.a.j)localObject2).field_userName, com.tencent.mm.aj.a.e.so((String)localObject1) }));
        break;
        label633:
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
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcm.cpR.cpX > 0)) {
      paramcm.cpR.cpX = 0;
    }
    AppMethodBeat.o(27277);
    return paramBoolean;
  }
  
  private static boolean a(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27286);
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
        AppMethodBeat.o(27286);
        return true;
      }
      catch (Exception parambi)
      {
        ab.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambi.getStackTrace().toString() });
      }
    }
    paramcm.cpR.cpX = 2131299723;
    AppMethodBeat.o(27286);
    return false;
  }
  
  private static acc ag(bi parambi)
  {
    AppMethodBeat.i(27280);
    acc localacc = new acc();
    if (parambi == null)
    {
      AppMethodBeat.o(27280);
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
      AppMethodBeat.o(27280);
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
    AppMethodBeat.i(27283);
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.t.lA(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
      {
        parambi = String.format("%d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
        AppMethodBeat.o(27283);
        return parambi;
      }
      parambi = String.format("%s#%d", new Object[] { parambi.field_talker, Long.valueOf(parambi.field_msgSvrId) });
      AppMethodBeat.o(27283);
      return parambi;
    }
    long l = parambi.field_msgSvrId;
    AppMethodBeat.o(27283);
    return String.valueOf(l);
  }
  
  private static String alh(String paramString)
  {
    AppMethodBeat.i(27288);
    aw.aaz();
    paramString = com.tencent.mm.sdk.platformtools.j.b(com.tencent.mm.model.c.YN(), "recbiz_", paramString, ".rec", 2);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27288);
      return null;
    }
    if (new File(paramString).exists())
    {
      AppMethodBeat.o(27288);
      return paramString;
    }
    AppMethodBeat.o(27288);
    return paramString;
  }
  
  private static acw ali(String paramString)
  {
    AppMethodBeat.i(27279);
    acw localacw = new acw();
    localacw.aon(paramString);
    localacw.MR(1);
    localacw.nI(bo.aoy());
    localacw.aop("");
    AppMethodBeat.o(27279);
    return localacw;
  }
  
  private static String b(acc paramacc)
  {
    AppMethodBeat.i(27282);
    paramacc = pYf.format(new Date(paramacc.createTime));
    AppMethodBeat.o(27282);
    return paramacc;
  }
  
  private static boolean b(Context paramContext, cm paramcm, bi parambi)
  {
    boolean bool = false;
    AppMethodBeat.i(27278);
    if ((paramcm == null) || (parambi == null))
    {
      ab.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(27278);
      return false;
    }
    parambi = bi.as(parambi);
    if (parambi.isText()) {
      bool = e(paramcm, parambi);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.c.a(parambi, paramcm, bool);
      AppMethodBeat.o(27278);
      return bool;
      if (parambi.dvW()) {
        bool = k(paramcm, parambi);
      } else if (parambi.bCp()) {
        bool = a(paramcm, parambi);
      } else if (parambi.dvX()) {
        bool = j(paramcm, parambi);
      } else if (parambi.byj()) {
        bool = b(paramcm, parambi);
      } else if (parambi.byk()) {
        bool = b(paramcm, parambi);
      } else if (parambi.dvV()) {
        bool = c(paramcm, parambi);
      } else if (parambi.dxR()) {
        bool = c(paramContext, paramcm, parambi);
      } else if ((parambi.bCn()) && (!parambi.dxT())) {
        bool = a(paramContext, paramcm, parambi);
      } else {
        paramcm.cpR.cpX = 2131299721;
      }
    }
  }
  
  private static boolean b(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27289);
    Object localObject = new acb();
    ((acb)localObject).c(ag(parambi));
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
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = u.vr(parambi.field_imgPath);
      if (locals != null) {
        break;
      }
      ab.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(27289);
      return false;
      localaca.MI(4);
    }
    ab.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.fsd) });
    if (locals.fsd > com.tencent.mm.m.b.MX())
    {
      paramcm.cpR.cpX = 2131299848;
      AppMethodBeat.o(27289);
      return false;
    }
    if ((parambi.byk()) && (u.vt(locals.getFileName())))
    {
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(27289);
      return false;
    }
    localaca.MH(locals.fXx);
    localaca.a((acb)localObject);
    localaca.anL(a(((acb)localObject).wUb));
    localaca.anM(b(((acb)localObject).wUb));
    if (ad.arf(((acb)localObject).wUb.wUA))
    {
      localObject = ((acb)localObject).wUb.wUA;
      localObject = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject));
      if (!bo.isNullOrNil((String)localObject)) {
        localaca.anU((String)localObject);
      }
    }
    localaca.nE(parambi.field_msgId);
    localaca.nC(locals.fsd);
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
    AppMethodBeat.o(27289);
    return true;
  }
  
  private static boolean c(Context paramContext, cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27290);
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    if ((localObject != null) && (com.tencent.mm.model.t.ku(((bi.a)localObject).uOT)))
    {
      paramContext = new aca();
      paramContext.anI(ah(parambi));
      paramContext.MI(16);
      paramContext.anr(parambi.field_content);
      paramContext.pz(true);
      paramContext.py(true);
      paramContext.a(localacb);
      paramContext.anL(a(localacb.wUb));
      paramContext.anM(b(localacb.wUb));
      if (!ad.arf(localacb.wUb.wUA)) {
        break label337;
      }
      parambi = localacb.wUb.wUA;
      parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
      if (!bo.isNullOrNil(parambi)) {
        paramContext.anU(parambi);
      }
    }
    label337:
    for (;;)
    {
      paramcm.cpR.cpT.wVc.add(paramContext);
      paramContext = paramcm.cpR.cpU;
      paramContext.wVE += 1;
      AppMethodBeat.o(27290);
      return true;
      if ((localObject != null) && (ad.arf(((bi.a)localObject).tac)))
      {
        localObject = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).a(((bi.a)localObject).yOm, "openim_card_type_name", b.a.gfD);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131296969);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(parambi, paramContext, localacb);
          break;
        }
      }
      paramContext = a(parambi, paramContext.getString(2131296969), localacb);
    }
  }
  
  private static boolean c(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27294);
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
              ((aca)localObject2).anF(p.aln(localq.fjJ));
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
      ab.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambi, "", new Object[0]);
      ab.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambi.getLocalizedMessage() });
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27294);
      return false;
    }
    paramcm.cpR.cpX = 2131299721;
    AppMethodBeat.o(27294);
    return false;
    label557:
    AppMethodBeat.o(27294);
    return true;
  }
  
  private static boolean e(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27284);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    aca localaca = new aca();
    localaca.anI(ah(parambi));
    localaca.MI(1);
    String str;
    if (parambi.dyq())
    {
      str = ah.getContext().getString(2131302746, new Object[] { "@" }) + '\n';
      if (parambi.dyh()) {
        break label277;
      }
      localaca.anr(str + parambi.field_content);
    }
    for (;;)
    {
      localaca.pz(true);
      localaca.py(true);
      localaca.a(localacb);
      localaca.anL(a(localacb.wUb));
      localaca.anM(b(localacb.wUb));
      if (ad.arf(localacb.wUb.wUA))
      {
        parambi = localacb.wUb.wUA;
        parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
        if (!bo.isNullOrNil(parambi)) {
          localaca.anU(parambi);
        }
      }
      paramcm.cpR.cpT.wVc.add(localaca);
      paramcm = paramcm.cpR.cpU;
      paramcm.wVr += 1;
      AppMethodBeat.o(27284);
      return true;
      str = "";
      break;
      label277:
      localaca.anr(str + parambi.field_content + "\n\n" + parambi.field_transContent);
    }
  }
  
  private static boolean j(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27285);
    Object localObject1 = null;
    if (parambi.field_msgId > 0L) {
      localObject1 = com.tencent.mm.at.o.ahC().gT((int)parambi.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambi.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ab.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcm.cpR.cpX = 2131299719;
      AppMethodBeat.o(27285);
      return false;
    }
    acb localacb = new acb();
    localacb.c(ag(parambi));
    localObject1 = new aca();
    ((aca)localObject1).anI(ah(parambi));
    ((aca)localObject1).MI(2);
    ((aca)localObject1).anE(com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject2), "", ""));
    if (((com.tencent.mm.at.e)localObject2).ahh())
    {
      localObject2 = com.tencent.mm.at.o.ahC().lv(((com.tencent.mm.at.e)localObject2).fDW);
      if (((com.tencent.mm.at.e)localObject2).fsd > ((com.tencent.mm.at.e)localObject2).offset) {
        ((aca)localObject1).anE(com.tencent.mm.at.o.ahC().q("SERVERID://" + parambi.field_msgSvrId, "", ""));
      }
    }
    ((aca)localObject1).anF(com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true));
    ((aca)localObject1).a(localacb);
    ((aca)localObject1).anL(a(localacb.wUb));
    ((aca)localObject1).anM(b(localacb.wUb));
    ((aca)localObject1).nE(parambi.field_msgId);
    if (ad.arf(localacb.wUb.wUA))
    {
      parambi = localacb.wUb.wUA;
      parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
      if (!bo.isNullOrNil(parambi)) {
        ((aca)localObject1).anU(parambi);
      }
    }
    paramcm.cpR.cpT.wVc.add(localObject1);
    paramcm = paramcm.cpR.cpU;
    paramcm.wVs += 1;
    AppMethodBeat.o(27285);
    return true;
  }
  
  private static boolean k(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27287);
    acb localacb = new acb();
    localacb.c(ag(parambi));
    aca localaca = new aca();
    localaca.anI(ah(parambi));
    localaca.MI(3);
    if (com.tencent.mm.model.t.oq(parambi.field_talker)) {
      localaca.anE(alh(parambi.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localaca.pz(true);
      localb = com.tencent.mm.modelvoice.s.vK(parambi.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(27287);
      return false;
      localaca.anE(com.tencent.mm.modelvoice.s.getFullPath(parambi.field_imgPath));
    }
    localaca.anA(e.Lu(localb.getFormat()));
    localaca.MH((int)new com.tencent.mm.modelvoice.p(parambi.field_content).time);
    localaca.a(localacb);
    localaca.anL(a(localacb.wUb));
    localaca.anM(b(localacb.wUb));
    if (ad.arf(localacb.wUb.wUA))
    {
      parambi = localacb.wUb.wUA;
      parambi = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(parambi));
      if (!bo.isNullOrNil(parambi)) {
        localaca.anU(parambi);
      }
    }
    paramcm.cpR.cpT.wVc.add(localaca);
    paramcm = paramcm.cpR.cpU;
    paramcm.wVt += 1;
    AppMethodBeat.o(27287);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */