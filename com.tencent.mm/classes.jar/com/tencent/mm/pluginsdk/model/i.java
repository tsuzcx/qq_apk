package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final SimpleDateFormat xGu;
  
  static
  {
    AppMethodBeat.i(30988);
    xGu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static ajx a(bv parambv, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    ajx localajx = new ajx();
    localajx.aPU(aB(parambv));
    localajx.aPJ(paramb.hCY);
    localajx.aPK(paramb.hCZ);
    localajx.aPI(paramb.url);
    localajx.ws(true);
    parambv = new com.tencent.mm.vfs.k(bu.bI(q.aIX().R(parambv.field_imgPath, true), ""));
    if (parambv.exists()) {
      localajx.aPR(com.tencent.mm.vfs.w.B(parambv.fTh()));
    }
    for (;;)
    {
      localajx.aPC(paramb.title);
      localajx.aPD(paramb.description);
      localajx.aao(paramInt);
      localajx.aQb(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localajx;
      localajx.wt(true);
    }
  }
  
  private static ajx a(bv parambv, String paramString, ajy paramajy)
  {
    AppMethodBeat.i(30984);
    ajx localajx = new ajx();
    localajx.aPU(aB(parambv));
    localajx.aao(1);
    localajx.aPD(paramString);
    localajx.wt(true);
    localajx.ws(true);
    localajx.a(paramajy);
    localajx.aPX(a(paramajy.GBb));
    localajx.aPY(b(paramajy.GBb));
    if (an.aUq(paramajy.GBb.GBE))
    {
      parambv = paramajy.GBb.GBE;
      parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
      if (!bu.isNullOrNil(parambv)) {
        localajx.aQg(parambv);
      }
    }
    AppMethodBeat.o(30984);
    return localajx;
  }
  
  private static String a(ajz paramajz)
  {
    AppMethodBeat.i(30973);
    String str2 = paramajz.GBE;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = paramajz.dzZ;
    }
    if (com.tencent.mm.al.a.e.ER(str1))
    {
      paramajz = com.tencent.mm.al.a.e.ET(str1);
      AppMethodBeat.o(30973);
      return paramajz;
    }
    paramajz = com.tencent.mm.model.w.zO(str1);
    AppMethodBeat.o(30973);
    return paramajz;
  }
  
  private static void a(bv parambv, ajy paramajy, alc paramalc)
  {
    AppMethodBeat.i(30986);
    paramajy.d(m.a(parambv, paramalc));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30985);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    Object localObject1 = parambv.field_content;
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localObject1 = k.b.zb((String)localObject1);
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localajy.GBb.aQq(((k.b)localObject1).appId);
    localajy.GBb.aQs(((k.b)localObject1).dIt);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).Ee();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcw.doL.doQ = 2131758893;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aao(1);
      paramContext.aPD(((k.b)localObject1).title);
      paramContext.wt(true);
      paramContext.ws(true);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCt += 1;
      AppMethodBeat.o(30985);
      return true;
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ao.bJV().aMZ(((k.b)localObject1).dlu);
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      if (localObject2 != null) {
        paramContext.aPQ(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = q.aIX().R(parambv.field_imgPath, true);
      if (com.tencent.mm.vfs.o.fB((String)localObject2)) {
        paramContext.aPR((String)localObject2);
      }
      paramContext.aao(2);
      paramContext.aPC(((k.b)localObject1).title);
      paramContext.aPD(((k.b)localObject1).description);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      paramContext.Dg(parambv.field_msgId);
      paramContext.aQk(bn.BV(parambv.eNd));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCu += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambv, (k.b)localObject1, 7);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCy += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambv, (k.b)localObject1, 4);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      paramContext.Dg(parambv.field_msgId);
      paramContext.aQk(bn.BV(parambv.eNd));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.tRD += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localajy.GBb.aQr(((k.b)localObject1).url);
        paramContext = a(parambv, (k.b)localObject1, 5);
        paramContext.a(localajy);
        paramContext.aPX(a(localajy.GBb));
        paramContext.aPY(b(localajy.GBb));
        if (an.aUq(localajy.GBb.GBE))
        {
          localObject2 = localajy.GBb.GBE;
          localObject2 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject2));
          if (!bu.isNullOrNil((String)localObject2)) {
            paramContext.aQg((String)localObject2);
          }
        }
        localObject2 = new alc();
        if (!bu.isNullOrNil(((k.b)localObject1).title)) {
          ((alc)localObject2).aQP(((k.b)localObject1).title);
        }
        if (!bu.isNullOrNil(((k.b)localObject1).description)) {
          ((alc)localObject2).aQQ(((k.b)localObject1).description);
        }
        if (!bu.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((alc)localObject2).aQS(((k.b)localObject1).thumburl);
        }
        if (!bu.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((alc)localObject2).aQT(((k.b)localObject1).canvasPageXml);
        }
        if (((alc)localObject2).computeSize() > 0)
        {
          ((alc)localObject2).aay(1);
          localajy.a((alc)localObject2);
        }
        paramcw.doL.doN.oeJ.add(paramContext);
        paramContext = paramcw.doL.doO;
        paramContext.GCw += 1;
        a(parambv, localajy, (alc)localObject2);
        AppMethodBeat.o(30985);
        return true;
      }
      paramcw.doL.doQ = 2131758889;
      AppMethodBeat.o(30985);
      return false;
      paramContext = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.ipW;
        localObject1 = new ajx();
        ((ajx)localObject1).aPX(a(localajy.GBb));
        ((ajx)localObject1).aPY(b(localajy.GBb));
        ((ajx)localObject1).aPU(aB(parambv));
        ((ajx)localObject1).ws(true);
        ((ajx)localObject1).aPC(paramContext.nickname + ak.getContext().getString(2131759007));
        ((ajx)localObject1).aPD(paramContext.desc);
        ((ajx)localObject1).aao(22);
        localajy.c(paramContext);
        ((ajx)localObject1).a(localajy);
        paramcw.doL.doN.oeJ.add(localObject1);
        AppMethodBeat.o(30985);
        return true;
      }
      AppMethodBeat.o(30985);
      return false;
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ao.bJV().aMZ(((k.b)localObject1).dlu);
      paramContext = new ajx();
      if (localObject2 != null) {
        paramContext.aPQ(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.aPU(aB(parambv));
      paramContext.aao(8);
      paramContext.aPM(((k.b)localObject1).hCD);
      localObject2 = q.aIX().R(parambv.field_imgPath, true);
      if (bu.isNullOrNil((String)localObject2)) {
        paramContext.wt(true);
      }
      if (com.tencent.mm.vfs.o.fB((String)localObject2)) {
        paramContext.aPR((String)localObject2);
      }
      paramContext.aPC(((k.b)localObject1).title);
      paramContext.aPD(((k.b)localObject1).description);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      paramContext.Dg(parambv.field_msgId);
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.fileCount += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).dlu == null) || (((k.b)localObject1).dlu.length() == 0)) {
        paramcw.doL.doQ = 2131758886;
      }
      do
      {
        paramcw.doL.doQ = 2131758893;
        AppMethodBeat.o(30985);
        return false;
        bc.aCg();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcw.doL.doQ = 2131758901;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new akm();
      paramContext.aQv(((k.b)localObject1).title);
      paramContext.aQw(((k.b)localObject1).description);
      paramContext.aau(((k.b)localObject1).hDb);
      paramContext.aQy(((k.b)localObject1).hDc);
      paramContext.aQx(((k.b)localObject1).thumburl);
      localajy.a(paramContext);
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aao(10);
      paramContext.wt(true);
      paramContext.ws(true);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCA += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new akw();
      paramContext.aQL(((k.b)localObject1).title);
      paramContext.aQM(((k.b)localObject1).description);
      paramContext.aQO(((k.b)localObject1).hDf);
      paramContext.aQN(((k.b)localObject1).thumburl);
      localajy.a(paramContext);
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aao(14);
      paramContext.wt(true);
      paramContext.ws(true);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCE += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new akm();
      paramContext.aQv(((k.b)localObject1).title);
      paramContext.aQw(((k.b)localObject1).description);
      paramContext.aau(((k.b)localObject1).hDh);
      paramContext.aQy(((k.b)localObject1).hDi);
      paramContext.aQx(((k.b)localObject1).thumburl);
      localajy.a(paramContext);
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aao(11);
      paramContext.wt(true);
      paramContext.ws(true);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCB += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambv, paramContext.getString(2131755833), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aPC(((k.b)localObject1).title);
      paramContext.aPD(((k.b)localObject1).description);
      paramContext.aao(19);
      localObject2 = q.aIX().R(parambv.field_imgPath, true);
      if (bu.isNullOrNil((String)localObject2)) {
        paramContext.wt(true);
      }
      if (com.tencent.mm.vfs.o.fB((String)localObject2)) {
        paramContext.aPR((String)localObject2);
      }
      localObject2 = new ajv();
      if (!bu.isNullOrNil(((k.b)localObject1).hFc)) {
        ((ajv)localObject2).username = ((k.b)localObject1).hFc;
      }
      if (!bu.isNullOrNil(((k.b)localObject1).hFd)) {
        ((ajv)localObject2).appId = ((k.b)localObject1).hFd;
      }
      if (!bu.isNullOrNil(((k.b)localObject1).hFt)) {
        ((ajv)localObject2).iconUrl = ((k.b)localObject1).hFt;
      }
      ((ajv)localObject2).kuE = ((k.b)localObject1).hFl;
      ((ajv)localObject2).type = ((k.b)localObject1).hFe;
      ((ajv)localObject2).duK = ((k.b)localObject1).hFg;
      ((ajv)localObject2).dlk = ((k.b)localObject1).hFb;
      ((ajv)localObject2).Gzq = ((k.b)localObject1).dIu;
      localajy.b((ajv)localObject2);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      paramContext.Dg(parambv.field_msgId);
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambv, paramContext.getString(2131755786) + ((k.b)localObject1).title, localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = ((k.b)localObject1).t(paramContext, true);
      if (bu.isNullOrNil(paramContext))
      {
        paramcw.doL.doQ = 2131758893;
        AppMethodBeat.o(30985);
        return false;
      }
      paramContext = a(parambv, paramContext + ((k.b)localObject1).title, localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).hDg != null) && (((k.b)localObject1).hDg.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new ajx();
        ((ajx)localObject2).aPU(aB(parambv));
        ((ajx)localObject2).aao(17);
        ((ajx)localObject2).wt(true);
        ((ajx)localObject2).aPC(((k.b)localObject1).title);
        ((ajx)localObject2).aQc(((k.b)localObject1).hDg);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new qi();
        ((qi)localObject3).dFS.type = 0;
        ((qi)localObject3).dFS.dFU = ((k.b)localObject1).hDg;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((qi)localObject3).dFT.dGd;
        if (localObject1 == null) {
          break label3371;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hFT.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (bu.isNullOrNil(((ajx)((Iterator)localObject3).next()).GAS));
        paramcw.doL.doQ = 2131758893;
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
      ((ajx)localObject2).aPD(paramContext);
      ((ajx)localObject2).a(localajy);
      ((ajx)localObject2).aPX(a(localajy.GBb));
      ((ajx)localObject2).aPY(b(localajy.GBb));
      ((ajx)localObject2).Dg(parambv.field_msgId);
      if (an.aUq(localajy.GBb.GBE))
      {
        paramContext = localajy.GBb.GBE;
        paramContext = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramContext));
        if (!bu.isNullOrNil(paramContext)) {
          ((ajx)localObject2).aQg(paramContext);
        }
      }
      paramcw.doL.doN.oeJ.add(localObject2);
      AppMethodBeat.o(30985);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cw paramcw, String paramString, List<bv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ae.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bv)((Iterator)localObject1).next();
      if (bn.z((bv)localObject2)) {
        switch (((bv)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((bv)localObject2).setContent(paramContext.getString(2131755904));
          break;
        case 3: 
          ((bv)localObject2).setContent(paramContext.getString(2131755853));
          ((bv)localObject2).setType(1);
          break;
        case 43: 
          ((bv)localObject2).setContent(paramContext.getString(2131755926));
          ((bv)localObject2).setType(1);
          break;
        case 49: 
          ((bv)localObject2).setContent(paramContext.getString(2131755914));
          ((bv)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.al.g.vz(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (bv)paramList.get(0);
      if (paramList.fta())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.ah.u)localObject1).hFT != null) && (((com.tencent.mm.ah.u)localObject1).hFT.size() == 1))
        {
          paramBoolean = g.e(paramcw, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramcw.doL.doN = new akn();
        paramcw.doL.doO = new alb();
        paramcw.doL.doN.a(aMT(paramString));
        paramcw.doL.type = 14;
        paramBoolean = b(paramContext, paramcw, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = g.e(paramcw, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramcw.doL.doN = new akn();
    paramcw.doL.doO = new alb();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.al.a.e.sn(((bv)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.ES((String)localObject1))
      {
        paramcw.doL.doN.aQA(paramContext.getString(2131762236));
        ae.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcw.doL.doN.title });
      }
    }
    else
    {
      paramcw.doL.doN.a(aMT(paramString));
      paramcw.doL.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcw, (bv)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.al.a.e.EV(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcw.doL.doN.aQA(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.al.a.k)localObject2).field_userName, com.tencent.mm.al.a.e.ET((String)localObject1) }));
        break;
        label633:
        if (x.wb(paramString))
        {
          paramcw.doL.doN.aQA(paramContext.getString(2131762236));
          break;
        }
        localObject1 = bu.nullAsNil(com.tencent.mm.model.v.aAE());
        if (((String)localObject1).equals(bu.nullAsNil(com.tencent.mm.model.w.zO(paramString))))
        {
          paramcw.doL.doN.aQA(paramContext.getString(2131758964, new Object[] { localObject1 }));
          break;
        }
        paramcw.doL.doN.aQA(paramContext.getString(2131758963, new Object[] { com.tencent.mm.model.v.aAE(), com.tencent.mm.model.w.zO(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcw.doL.doQ > 0)) {
      paramcw.doL.doQ = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30978);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    Object localObject = bx.M(parambv.field_content, "msg");
    if (localObject != null) {
      try
      {
        ake localake = new ake();
        localake.aQt((String)((Map)localObject).get(".msg.location.$label"));
        localake.B(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localake.A(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localake.aat(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localake.aQu((String)((Map)localObject).get(".msg.location.$poiname"));
        localajy.c(localake);
        localObject = new ajx();
        ((ajx)localObject).aPU(aB(parambv));
        ((ajx)localObject).aao(6);
        ((ajx)localObject).wt(true);
        ((ajx)localObject).ws(true);
        ((ajx)localObject).a(localajy);
        ((ajx)localObject).aPX(a(localajy.GBb));
        ((ajx)localObject).aPY(b(localajy.GBb));
        if (an.aUq(localajy.GBb.GBE))
        {
          parambv = localajy.GBb.GBE;
          parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
          if (!bu.isNullOrNil(parambv)) {
            ((ajx)localObject).aQg(parambv);
          }
        }
        paramcw.doL.doN.oeJ.add(localObject);
        parambv = paramcw.doL.doO;
        parambv.GCx += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception parambv)
      {
        ae.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambv.getStackTrace().toString() });
      }
    }
    paramcw.doL.doQ = 2131758895;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static ajz aA(bv parambv)
  {
    AppMethodBeat.i(30972);
    ajz localajz = new ajz();
    if (parambv == null)
    {
      AppMethodBeat.o(30972);
      return localajz;
    }
    Object localObject;
    if (parambv.field_isSend == 0)
    {
      localajz.aQl(parambv.field_talker);
      localajz.aQm(com.tencent.mm.model.v.aAC());
      if (x.wb(parambv.field_talker))
      {
        if (parambv.field_content == null) {
          break label367;
        }
        localObject = parambv.field_content.substring(0, Math.max(0, parambv.field_content.indexOf(':')));
        localajz.aQo((String)localObject);
        if ((!bu.isNullOrNil(localajz.GBE)) && (!parambv.ftf()))
        {
          parambv.setContent(parambv.field_content.substring(localajz.GBE.length() + 1));
          if ((parambv.field_content.length() > 0) && ('\n' == parambv.field_content.charAt(0))) {
            parambv.setContent(parambv.field_content.substring(1));
          }
          if (parambv.fvS())
          {
            if ((!bu.isNullOrNil(parambv.field_transContent)) && (parambv.field_transContent.startsWith(localajz.GBE))) {
              parambv.ul(parambv.field_transContent.substring(localajz.GBE.length() + 1));
            }
            if ((parambv.field_transContent.length() > 0) && ('\n' == parambv.field_transContent.charAt(0))) {
              parambv.ul(parambv.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.al.g.vz(parambv.field_talker))
      {
        String str = parambv.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bl.BS(parambv.eNd).userId;
        }
        localajz.aQo((String)localObject);
      }
      localajz.aas(1);
      localajz.Dh(parambv.field_createTime);
      localajz.aQp(parambv.field_msgSvrId);
      if (parambv.field_msgSvrId > 0L) {
        localajz.aQn(parambv.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localajz;
      label367:
      localObject = "";
      break;
      localajz.aQl(com.tencent.mm.model.v.aAC());
      localajz.aQm(parambv.field_talker);
      if (x.wb(parambv.field_talker)) {
        localajz.aQo(localajz.dzZ);
      }
    }
  }
  
  private static String aB(bv parambv)
  {
    AppMethodBeat.i(30975);
    if (parambv.field_isSend == 1)
    {
      if ((x.wb(parambv.field_talker)) || (parambv.field_talker.equals("filehelper")))
      {
        parambv = String.format("%d", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return parambv;
      }
      parambv = String.format("%s#%d", new Object[] { parambv.field_talker, Long.valueOf(parambv.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return parambv;
    }
    long l = parambv.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String aMS(String paramString)
  {
    AppMethodBeat.i(30980);
    bc.aCg();
    paramString = n.d(com.tencent.mm.model.c.azT(), "recbiz_", paramString, ".rec", 2);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30980);
      return null;
    }
    if (new com.tencent.mm.vfs.k(paramString).exists())
    {
      AppMethodBeat.o(30980);
      return paramString;
    }
    AppMethodBeat.o(30980);
    return paramString;
  }
  
  private static akt aMT(String paramString)
  {
    AppMethodBeat.i(30971);
    akt localakt = new akt();
    localakt.aQC(paramString);
    localakt.aax(1);
    localakt.Dk(bu.fpO());
    localakt.aQE("");
    AppMethodBeat.o(30971);
    return localakt;
  }
  
  private static String b(ajz paramajz)
  {
    AppMethodBeat.i(30974);
    paramajz = xGu.format(new Date(paramajz.createTime));
    AppMethodBeat.o(30974);
    return paramajz;
  }
  
  private static boolean b(Context paramContext, cw paramcw, bv parambv)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramcw == null) || (parambv == null))
    {
      ae.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    parambv = bv.aM(parambv);
    if (parambv.isText()) {
      bool = f(paramcw, parambv);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(parambv, paramcw, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (parambv.ftf()) {
        bool = m(paramcw, parambv);
      } else if (parambv.cVJ()) {
        bool = a(paramcw, parambv);
      } else if (parambv.ftg()) {
        bool = l(paramcw, parambv);
      } else if (parambv.cyG()) {
        bool = c(paramcw, parambv);
      } else if (parambv.cyI()) {
        bool = c(paramcw, parambv);
      } else if (parambv.cyH()) {
        bool = com.tencent.mm.plugin.record.b.c.b(paramcw, parambv);
      } else if (parambv.fta()) {
        bool = d(paramcw, parambv);
      } else if (parambv.fvE()) {
        bool = c(paramContext, paramcw, parambv);
      } else if ((parambv.cVH()) && (!parambv.fvH())) {
        bool = a(paramContext, paramcw, parambv);
      } else {
        paramcw.doL.doQ = 2131758893;
      }
    }
  }
  
  private static boolean c(Context paramContext, cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30982);
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().arp(parambv.field_content);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    if ((localObject != null) && (x.oq(((bv.a)localObject).Ecg)))
    {
      paramContext = new ajx();
      paramContext.aPU(aB(parambv));
      paramContext.aao(16);
      paramContext.aPD(parambv.field_content);
      paramContext.wt(true);
      paramContext.ws(true);
      paramContext.a(localajy);
      paramContext.aPX(a(localajy.GBb));
      paramContext.aPY(b(localajy.GBb));
      if (!an.aUq(localajy.GBb.GBE)) {
        break label337;
      }
      parambv = localajy.GBb.GBE;
      parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
      if (!bu.isNullOrNil(parambv)) {
        paramContext.aQg(parambv);
      }
    }
    label337:
    for (;;)
    {
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCF += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (an.aUq(((bv.a)localObject).cUA)))
      {
        localObject = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(((bv.a)localObject).JgX, "openim_card_type_name", a.a.iKm);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(parambv, paramContext, localajy);
          break;
        }
      }
      paramContext = a(parambv, paramContext.getString(2131755784), localajy);
    }
  }
  
  private static boolean c(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30981);
    Object localObject = new ajy();
    ((ajy)localObject).c(aA(parambv));
    ajx localajx = new ajx();
    localajx.aPU(aB(parambv));
    com.tencent.mm.modelvideo.o.aNh();
    localajx.aPQ(t.HJ(parambv.field_imgPath));
    com.tencent.mm.modelvideo.o.aNh();
    localajx.aPR(t.HK(parambv.field_imgPath));
    localajx.aPM(com.tencent.mm.vfs.o.aaw(localajx.GzY));
    if (parambv.cyI()) {
      localajx.aao(15);
    }
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
      if (locals != null) {
        break;
      }
      ae.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(30981);
      return false;
      localajx.aao(4);
    }
    ae.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.hPI) });
    if (locals.hPI > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(false))
    {
      paramcw.doL.doQ = 2131759024;
      AppMethodBeat.o(30981);
      return false;
    }
    if ((parambv.cyI()) && (com.tencent.mm.modelvideo.u.Ic(locals.getFileName())))
    {
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(30981);
      return false;
    }
    localajx.aan(locals.hKI);
    localajx.a((ajy)localObject);
    localajx.aPX(a(((ajy)localObject).GBb));
    localajx.aPY(b(((ajy)localObject).GBb));
    if (an.aUq(((ajy)localObject).GBb.GBE))
    {
      localObject = ((ajy)localObject).GBb.GBE;
      localObject = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject));
      if (!bu.isNullOrNil((String)localObject)) {
        localajx.aQg((String)localObject);
      }
    }
    localajx.Dg(parambv.field_msgId);
    localajx.aQk(bn.BV(parambv.eNd));
    localajx.De(locals.hPI);
    paramcw.doL.doN.oeJ.add(localajx);
    paramcw = paramcw.doL.doO;
    paramcw.tRD += 1;
    paramcw = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    localajx.aQa(paramcw.dIA);
    paramcw = paramcw.ixh;
    if ((paramcw != null) && (!bu.isNullOrNil(paramcw.hEZ)))
    {
      parambv = new aka();
      parambv.hET = paramcw.hET;
      parambv.GBN = paramcw.GBN;
      parambv.hEW = paramcw.hEW;
      parambv.hEX = paramcw.hEX;
      parambv.hEV = paramcw.hEV;
      parambv.hEY = paramcw.hEY;
      parambv.hEZ = paramcw.hEZ;
      parambv.hFa = paramcw.hFa;
      localajx.a(parambv);
    }
    AppMethodBeat.o(30981);
    return true;
  }
  
  private static boolean d(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30987);
    try
    {
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
      Object localObject1 = localu.hFT;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ah.v localv = (com.tencent.mm.ah.v)((Iterator)localObject1).next();
          if (!m.zd(localv.hGj))
          {
            ajy localajy = new ajy();
            localajy.c(aA(parambv));
            localajy.GBb.aQs(localu.dIt);
            localajy.GBb.aQr(localv.url);
            Object localObject2 = new ajx();
            ((ajx)localObject2).aPC(localv.title);
            ((ajx)localObject2).aPD(localv.hGg);
            ((ajx)localObject2).aPU(aB(parambv));
            if (!bu.isNullOrNil(localv.hGe)) {
              ((ajx)localObject2).aPR(r.aMY(localv.hGe));
            }
            for (;;)
            {
              ((ajx)localObject2).ws(true);
              alc localalc = new alc();
              if (!bu.isNullOrNil(localv.title)) {
                localalc.aQP(localv.title);
              }
              if (!bu.isNullOrNil(localv.hGg)) {
                localalc.aQQ(localv.hGg);
              }
              if (!bu.isNullOrNil(localv.hGe)) {
                localalc.aQS(m.a(localv));
              }
              if (localalc.computeSize() > 0)
              {
                localalc.aay(1);
                localajy.a(localalc);
              }
              ((ajx)localObject2).aao(5);
              ((ajx)localObject2).a(localajy);
              ((ajx)localObject2).aPX(a(localajy.GBb));
              ((ajx)localObject2).aPY(b(localajy.GBb));
              if (an.aUq(localajy.GBb.GBE))
              {
                String str = localajy.GBb.GBE;
                str = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str));
                if (!bu.isNullOrNil(str)) {
                  ((ajx)localObject2).aQg(str);
                }
              }
              paramcw.doL.doN.oeJ.add(localObject2);
              localObject2 = paramcw.doL.doO;
              ((alb)localObject2).GCw += 1;
              localajy.d(m.a(localv, localalc, localu.dIt, localu.dIu));
              i += 1;
              break;
              ((ajx)localObject2).wt(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception parambv)
    {
      ae.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambv, "", new Object[0]);
      ae.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambv.getLocalizedMessage() });
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30987);
      return false;
    }
    paramcw.doL.doQ = 2131758893;
    AppMethodBeat.o(30987);
    return false;
    label557:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean f(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30976);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    ajx localajx = new ajx();
    localajx.aPU(aB(parambv));
    localajx.aao(1);
    if (parambv.fwp()) {}
    for (String str = ak.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; str = "")
    {
      localajx.aPD(str + parambv.field_content);
      localajx.wt(true);
      localajx.ws(true);
      localajx.a(localajy);
      localajx.aPX(a(localajy.GBb));
      localajx.aPY(b(localajy.GBb));
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          localajx.aQg(parambv);
        }
      }
      paramcw.doL.doN.oeJ.add(localajx);
      paramcw = paramcw.doL.doO;
      paramcw.GCt += 1;
      AppMethodBeat.o(30976);
      return true;
    }
  }
  
  private static boolean l(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30977);
    Object localObject1 = null;
    if (parambv.field_msgId > 0L) {
      localObject1 = q.aIX().G(parambv.field_talker, (int)parambv.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambv.field_msgSvrId > 0L) {
        localObject2 = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ae.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcw.doL.doQ = 2131758891;
      AppMethodBeat.o(30977);
      return false;
    }
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    localObject1 = new ajx();
    ((ajx)localObject1).aPU(aB(parambv));
    ((ajx)localObject1).aao(2);
    ((ajx)localObject1).aPQ(q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", ""));
    if (((com.tencent.mm.av.g)localObject2).aIB())
    {
      localObject2 = q.aIX().pw(((com.tencent.mm.av.g)localObject2).icz);
      if (((com.tencent.mm.av.g)localObject2).hPI > ((com.tencent.mm.av.g)localObject2).offset) {
        ((ajx)localObject1).aPQ(q.aIX().o("SERVERID://" + parambv.field_msgSvrId, "", ""));
      }
    }
    ((ajx)localObject1).aPR(q.aIX().R(parambv.field_imgPath, true));
    ((ajx)localObject1).a(localajy);
    ((ajx)localObject1).aPX(a(localajy.GBb));
    ((ajx)localObject1).aPY(b(localajy.GBb));
    ((ajx)localObject1).Dg(parambv.field_msgId);
    ((ajx)localObject1).aQk(bn.BV(parambv.eNd));
    if (an.aUq(localajy.GBb.GBE))
    {
      parambv = localajy.GBb.GBE;
      parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
      if (!bu.isNullOrNil(parambv)) {
        ((ajx)localObject1).aQg(parambv);
      }
    }
    paramcw.doL.doN.oeJ.add(localObject1);
    paramcw = paramcw.doL.doO;
    paramcw.GCu += 1;
    AppMethodBeat.o(30977);
    return true;
  }
  
  private static boolean m(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30979);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    ajx localajx = new ajx();
    localajx.aPU(aB(parambv));
    localajx.aao(3);
    if (x.AK(parambv.field_talker)) {
      localajx.aPQ(aMS(parambv.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localajx.wt(true);
      localb = com.tencent.mm.modelvoice.s.It(parambv.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30979);
      return false;
      localajx.aPQ(com.tencent.mm.modelvoice.s.getFullPath(parambv.field_imgPath));
    }
    localajx.aPM(g.YR(localb.getFormat()));
    localajx.aan((int)new p(parambv.field_content).time);
    localajx.a(localajy);
    localajx.aPX(a(localajy.GBb));
    localajx.aPY(b(localajy.GBb));
    if (an.aUq(localajy.GBb.GBE))
    {
      parambv = localajy.GBb.GBE;
      parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
      if (!bu.isNullOrNil(parambv)) {
        localajx.aQg(parambv);
      }
    }
    paramcw.doL.doN.oeJ.add(localajx);
    paramcw = paramcw.doL.doO;
    paramcw.GCv += 1;
    AppMethodBeat.o(30979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */