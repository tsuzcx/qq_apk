package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
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

public final class c
{
  private static final SimpleDateFormat xGu;
  
  static
  {
    AppMethodBeat.i(9458);
    xGu = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static ajx a(bv parambv, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localajx;
      localajx.wt(true);
    }
  }
  
  private static ajx a(bv parambv, String paramString, ajy paramajy)
  {
    AppMethodBeat.i(9455);
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
    AppMethodBeat.o(9455);
    return localajx;
  }
  
  private static String a(ajz paramajz)
  {
    AppMethodBeat.i(9448);
    String str2 = paramajz.GBE;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = paramajz.dzZ;
    }
    if (com.tencent.mm.al.a.e.ER(str1))
    {
      paramajz = com.tencent.mm.al.a.e.ET(str1);
      AppMethodBeat.o(9448);
      return paramajz;
    }
    paramajz = com.tencent.mm.model.w.zO(str1);
    AppMethodBeat.o(9448);
    return paramajz;
  }
  
  private static boolean a(Context paramContext, cw paramcw, bv parambv)
  {
    AppMethodBeat.i(9456);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    Object localObject1 = parambv.field_content;
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.zb((String)localObject1);
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localajy.GBb.aQq(((k.b)localObject1).appId);
    localajy.GBb.aQs(((k.b)localObject1).dIt);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).Ee()))
    {
      paramContext = a(parambv, paramContext.getString(2131755785), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(parambv, paramContext.getString(2131755898), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
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
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bJV().aMZ(((k.b)localObject1).dlu);
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
      AppMethodBeat.o(9456);
      return true;
    case 3: 
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
      if (((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.aQi(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.aQj(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.GCy += 1;
      AppMethodBeat.o(9456);
      return true;
    case 4: 
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
      AppMethodBeat.o(9456);
      return true;
    case 5: 
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
        localajy.d(m.a(parambv, (alc)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramcw.doL.doQ = 2131758889;
      paramContext = a(parambv, paramContext.getString(2131755898), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
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
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bJV().aMZ(((k.b)localObject1).dlu);
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
      paramContext.De(((k.b)localObject1).hCC);
      paramContext.aPN(((k.b)localObject1).filemd5);
      if (an.aUq(localajy.GBb.GBE))
      {
        parambv = localajy.GBb.GBE;
        parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
        if (!bu.isNullOrNil(parambv)) {
          paramContext.aQg(parambv);
        }
      }
      paramContext.aPG(((k.b)localObject1).hCR);
      paramContext.aPH(((k.b)localObject1).gmb);
      paramContext.aQf(((k.b)localObject1).hCI);
      paramContext.aQd(((k.b)localObject1).gmb);
      paramContext.aQe(((k.b)localObject1).hCO);
      paramcw.doL.doN.oeJ.add(paramContext);
      paramContext = paramcw.doL.doO;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).dlu == null) || (((k.b)localObject1).dlu.length() == 0)) {
        paramcw.doL.doQ = 2131758886;
      }
      do
      {
        paramcw.doL.doQ = 2131758893;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.g.ajS();
      } while (com.tencent.mm.kernel.g.ajR().isSDCardAvailable());
      paramcw.doL.doQ = 2131758901;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
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
      AppMethodBeat.o(9456);
      return true;
    case 20: 
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
      AppMethodBeat.o(9456);
      return true;
    case 13: 
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
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(parambv, paramContext.getString(2131755833), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if (((k.b)localObject1).hFe == 3)
      {
        paramContext = a(parambv, paramContext.getString(2131755833), localajy);
        paramcw.doL.doN.oeJ.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
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
      ((ajv)localObject2).type = ((k.b)localObject1).hFe;
      ((ajv)localObject2).duK = ((k.b)localObject1).hFr;
      ((ajv)localObject2).dlk = ((k.b)localObject1).hFb;
      ((ajv)localObject2).Gzq = ((k.b)localObject1).dIu;
      ((ajv)localObject2).kuE = ((k.b)localObject1).hFl;
      localObject1 = (com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class);
      if (localObject1 != null)
      {
        ((ajv)localObject2).kaX = ((com.tencent.mm.ah.a)localObject1).hAV;
        ((ajv)localObject2).dLl = ((com.tencent.mm.ah.a)localObject1).hAX;
        ((ajv)localObject2).subType = ((com.tencent.mm.ah.a)localObject1).hAY;
      }
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
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(parambv, paramContext.getString(2131755786) + ((k.b)localObject1).title, localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).t(paramContext, true);
      if (bu.isNullOrNil((String)localObject2))
      {
        paramContext = a(parambv, paramContext.getString(2131755898), localajy);
        paramcw.doL.doN.oeJ.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(parambv, (String)localObject2 + ((k.b)localObject1).title, localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).hDg != null) && (((k.b)localObject1).hDg.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hFT.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bu.isNullOrNil(((ajx)((Iterator)localObject3).next()).GAS))
              {
                paramcw.doL.doQ = 2131758893;
                AppMethodBeat.o(9456);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label3946;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label3946:
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
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambv, paramContext.getString(2131759036), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambv, paramContext.getString(2131755860), localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
  }
  
  private static boolean a(Context paramContext, cw paramcw, bv parambv, int paramInt)
  {
    AppMethodBeat.i(9446);
    ajy localajy = new ajy();
    localajy.c(aA(parambv));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131755722);
    }
    for (;;)
    {
      paramContext = a(parambv, str, localajy);
      paramcw.doL.doN.oeJ.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131755839);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131755898);
      }
    }
  }
  
  public static boolean a(Context paramContext, cw paramcw, String paramString, List<bv> paramList)
  {
    AppMethodBeat.i(9445);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ae.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(9445);
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
    boolean bool1 = com.tencent.mm.al.g.vz(paramString);
    paramList.size();
    paramcw.doL.doN = new akn();
    paramcw.doL.doO = new alb();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.al.a.e.sn(((bv)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.ES((String)localObject1))
      {
        paramcw.doL.doN.aQA(paramContext.getString(2131762236));
        ae.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcw.doL.doN.title });
      }
    }
    else
    {
      localObject1 = paramcw.doL.doN;
      localObject2 = new akt();
      ((akt)localObject2).aQC(paramString);
      ((akt)localObject2).aax(1);
      ((akt)localObject2).Dk(bu.fpO());
      ((akt)localObject2).aQE("");
      ((akn)localObject1).a((akt)localObject2);
      paramcw.doL.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label2329;
      }
      paramString = (bv)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      ae.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcw.doL.doQ = 2131758885;
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
        localObject2 = com.tencent.mm.al.a.e.EV(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcw.doL.doN.aQA(paramContext.getString(2131758963, new Object[] { ((com.tencent.mm.al.a.k)localObject2).field_userName, com.tencent.mm.al.a.e.ET((String)localObject1) }));
        break;
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
        localObject2 = bv.aM(paramString);
        bool1 = false;
        Object localObject3;
        if (((bv)localObject2).isText())
        {
          localObject3 = new ajy();
          ((ajy)localObject3).c(aA((bv)localObject2));
          paramList = new ajx();
          paramList.aPU(aB((bv)localObject2));
          paramList.aao(1);
          if (((bv)localObject2).fwp()) {}
          for (paramString = ak.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; paramString = "")
          {
            paramList.aPD(paramString + ((ei)localObject2).field_content);
            paramList.wt(true);
            paramList.ws(true);
            paramList.a((ajy)localObject3);
            paramList.aPX(a(((ajy)localObject3).GBb));
            paramList.aPY(b(((ajy)localObject3).GBb));
            if (an.aUq(((ajy)localObject3).GBb.GBE))
            {
              paramString = ((ajy)localObject3).GBb.GBE;
              paramString = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString));
              if (!bu.isNullOrNil(paramString)) {
                paramList.aQg(paramString);
              }
            }
            paramcw.doL.doN.oeJ.add(paramList);
            paramString = paramcw.doL.doO;
            paramString.GCt += 1;
            bool1 = true;
            break;
          }
        }
        if (((bv)localObject2).ftf())
        {
          paramList = new ajy();
          paramList.c(aA((bv)localObject2));
          paramString = new ajx();
          paramString.aPU(aB((bv)localObject2));
          paramString.aao(3);
          paramString.wt(true);
          paramString.ws(true);
          paramString.a(paramList);
          paramString.aPX(a(paramList.GBb));
          paramString.aPY(b(paramList.GBb));
          if (an.aUq(paramList.GBb.GBE))
          {
            paramList = paramList.GBb.GBE;
            paramList = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramList));
            if (!bu.isNullOrNil(paramList)) {
              paramString.aQg(paramList);
            }
          }
          paramcw.doL.doN.oeJ.add(paramString);
          paramString = paramcw.doL.doO;
          paramString.GCv += 1;
          bool1 = true;
        }
        else if (((bv)localObject2).cVJ())
        {
          bool1 = a(paramcw, (bv)localObject2);
        }
        else if (((bv)localObject2).ftg())
        {
          paramList = null;
          if (((ei)localObject2).field_msgId > 0L) {
            paramList = q.aIX().G(((ei)localObject2).field_talker, (int)((ei)localObject2).field_msgId);
          }
          if (paramList != null)
          {
            paramString = paramList;
            if (paramList.doE > 0L) {}
          }
          else
          {
            paramString = paramList;
            if (((ei)localObject2).field_msgSvrId > 0L) {
              paramString = q.aIX().F(((ei)localObject2).field_talker, ((ei)localObject2).field_msgSvrId);
            }
          }
          if (paramString == null)
          {
            ae.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
            paramcw.doL.doQ = 2131758891;
            bool1 = false;
            continue;
          }
          localObject3 = new ajy();
          ((ajy)localObject3).c(aA((bv)localObject2));
          paramList = new ajx();
          paramList.aPU(aB((bv)localObject2));
          paramList.aao(2);
          paramList.aPQ(q.aIX().o(com.tencent.mm.av.h.c(paramString), "", ""));
          if (paramString.aIB())
          {
            com.tencent.mm.av.g localg = q.aIX().pw(paramString.icz);
            if (localg.hPI > localg.offset) {
              paramList.aPQ(q.aIX().o("SERVERID://" + ((ei)localObject2).field_msgSvrId, "", ""));
            }
          }
          paramList.aPR(q.aIX().R(((ei)localObject2).field_imgPath, true));
          paramList.a((ajy)localObject3);
          paramList.aPX(a(((ajy)localObject3).GBb));
          paramList.aPY(b(((ajy)localObject3).GBb));
          paramList.Dg(((ei)localObject2).field_msgId);
          paramList.aQk(bn.BV(((ei)localObject2).eNd));
          if (an.aUq(((ajy)localObject3).GBb.GBE))
          {
            localObject3 = ((ajy)localObject3).GBb.GBE;
            localObject3 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject3));
            if (!bu.isNullOrNil((String)localObject3)) {
              paramList.aQg((String)localObject3);
            }
          }
          if ((!paramString.aIB()) || (paramString.hPI != 0)) {
            break label2364;
          }
          paramString = q.aIX().pw(paramString.icz);
        }
      }
    }
    label650:
    label1564:
    label2361:
    label2364:
    for (;;)
    {
      int i;
      if (((ei)localObject2).field_isSend == 1) {
        if (paramString.aIB())
        {
          i = 1;
          localObject2 = bx.M(paramString.icA, "msg");
          if (localObject2 == null) {
            break label1743;
          }
          if (i == 1)
          {
            paramList.aPG((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.De(bu.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.aPH((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcw.doL.doN.oeJ.add(paramList);
        paramString = paramcw.doL.doO;
        paramString.GCu += 1;
        bool1 = true;
        break;
        i = 0;
        break label1564;
        if (!paramString.aIB())
        {
          i = 0;
          break label1564;
        }
        localObject2 = com.tencent.mm.av.h.a(paramString);
        if (!com.tencent.mm.vfs.o.fB(q.aIX().o(((com.tencent.mm.av.g)localObject2).ico, "", "")))
        {
          i = 0;
          break label1564;
        }
        i = 1;
        break label1564;
        label1743:
        ae.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.icA });
      }
      if (((bv)localObject2).cyG())
      {
        bool1 = c(paramcw, (bv)localObject2);
        break label468;
      }
      if (((bv)localObject2).cyH())
      {
        bool1 = b(paramcw, (bv)localObject2);
        break label468;
      }
      if (((bv)localObject2).cyI())
      {
        bool1 = c(paramcw, (bv)localObject2);
        break label468;
      }
      if (((bv)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcw, (bv)localObject2, 3);
        break label468;
      }
      if (((bv)localObject2).fta())
      {
        bool1 = d(paramcw, (bv)localObject2);
        break label468;
      }
      if ((((bv)localObject2).fvG()) || (((bv)localObject2).fvH()))
      {
        bool1 = a(paramContext, paramcw, (bv)localObject2, 1);
        break label468;
      }
      if (((bv)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcw, (bv)localObject2, 2);
        break label468;
      }
      if (((bv)localObject2).fvE())
      {
        paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arp(((ei)localObject2).field_content);
        paramList = new ajy();
        paramList.c(aA((bv)localObject2));
        if ((paramString != null) && (x.oq(paramString.Ecg)))
        {
          paramString = new ajx();
          paramString.aPU(aB((bv)localObject2));
          paramString.aao(16);
          paramString.aPD(((ei)localObject2).field_content);
          paramString.wt(true);
          paramString.ws(true);
          paramString.a(paramList);
          paramString.aPX(a(paramList.GBb));
          paramString.aPY(b(paramList.GBb));
          if (!an.aUq(paramList.GBb.GBE)) {
            break label2361;
          }
          paramList = paramList.GBb.GBE;
          paramList = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramList));
          if (!bu.isNullOrNil(paramList)) {
            paramString.aQg(paramList);
          }
        }
      }
      for (;;)
      {
        paramcw.doL.doN.oeJ.add(paramString);
        paramString = paramcw.doL.doO;
        paramString.GCF += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (an.aUq(paramString.cUA)))
        {
          paramString = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(paramString.JgX, "openim_card_type_name", a.a.iKm);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131755784);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((bv)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((bv)localObject2, paramContext.getString(2131755784), paramList);
        continue;
        if (((bv)localObject2).cVH())
        {
          if (((bv)localObject2).fvH())
          {
            paramcw.doL.doQ = 2131758893;
            break label468;
          }
          bool1 = a(paramContext, paramcw, (bv)localObject2);
          break label468;
        }
        paramcw.doL.doQ = 2131758893;
        bool1 = a(paramContext, paramcw, (bv)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcw.doL.doQ > 0)) {
          paramcw.doL.doQ = 0;
        }
        AppMethodBeat.o(9445);
        return bool2;
      }
    }
  }
  
  private static boolean a(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(9451);
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
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception parambv)
      {
        ae.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { parambv.getStackTrace().toString() });
      }
    }
    paramcw.doL.doQ = 2131758895;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static ajz aA(bv parambv)
  {
    AppMethodBeat.i(9447);
    ajz localajz = new ajz();
    if (parambv == null)
    {
      AppMethodBeat.o(9447);
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
      AppMethodBeat.o(9447);
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
    AppMethodBeat.i(9450);
    if (parambv.field_isSend == 1)
    {
      if ((x.wb(parambv.field_talker)) || (parambv.field_talker.equals("filehelper")))
      {
        parambv = String.format("%d", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return parambv;
      }
      parambv = String.format("%s#%d", new Object[] { parambv.field_talker, Long.valueOf(parambv.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return parambv;
    }
    long l = parambv.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static String b(ajz paramajz)
  {
    AppMethodBeat.i(9449);
    paramajz = xGu.format(new Date(paramajz.createTime));
    AppMethodBeat.o(9449);
    return paramajz;
  }
  
  public static boolean b(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.aB(parambv.field_content, parambv.field_reserved);
    if (localObject2 == null)
    {
      ae.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new akn();
    Object localObject3 = new akt();
    ((akt)localObject3).aQC(com.tencent.mm.model.v.aAC());
    ((akt)localObject3).aQD(com.tencent.mm.model.v.aAC());
    ((akt)localObject3).aax(4);
    ((akt)localObject3).Dk(bu.fpO());
    ((akt)localObject3).aQJ(((k.b)localObject2).url);
    ((akn)localObject1).a((akt)localObject3);
    localObject1 = new ajx();
    ((ajx)localObject1).aPQ("");
    ((ajx)localObject1).aPL(((k.b)localObject2).thumburl);
    localObject3 = m.t(parambv);
    if (localObject3 == null)
    {
      ae.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((ajx)localObject1).aan(((akf)localObject3).duration);
    ((ajx)localObject1).aPC(((k.b)localObject2).title);
    ((ajx)localObject1).aPI(((k.b)localObject2).url);
    ((ajx)localObject1).ws(true);
    ((ajx)localObject1).wt(true);
    localObject2 = new ajy();
    ((ajy)localObject2).c(aA(parambv));
    if (parambv.cyH()) {
      ((ajy)localObject2).e((akf)localObject3);
    }
    ((ajx)localObject1).a((ajy)localObject2);
    ((ajx)localObject1).Dg(parambv.field_msgId);
    ((ajx)localObject1).aPX(a(((ajy)localObject2).GBb));
    ((ajx)localObject1).aPY(b(((ajy)localObject2).GBb));
    if (an.aUq(((ajy)localObject2).GBb.GBE))
    {
      parambv = ((ajy)localObject2).GBb.GBE;
      parambv = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(parambv));
      if (!bu.isNullOrNil(parambv)) {
        ((ajx)localObject1).aQg(parambv);
      }
    }
    paramcw.doL.doN.oeJ.add(localObject1);
    paramcw = paramcw.doL.doO;
    paramcw.tRD += 1;
    ((ajx)localObject1).aao(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(9453);
    Object localObject2 = new ajy();
    ((ajy)localObject2).c(aA(parambv));
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
    for (;;)
    {
      localObject1 = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      ae.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(9453);
      return false;
      localajx.aao(4);
    }
    ae.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(((s)localObject1).hPI) });
    if (((s)localObject1).hPI > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcw.doL.doQ = 2131759025;
      AppMethodBeat.o(9453);
      return false;
    }
    if ((parambv.cyI()) && (com.tencent.mm.modelvideo.u.Ic(((s)localObject1).getFileName())))
    {
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(9453);
      return false;
    }
    localajx.aan(((s)localObject1).hKI);
    localajx.a((ajy)localObject2);
    localajx.aPX(a(((ajy)localObject2).GBb));
    localajx.aPY(b(((ajy)localObject2).GBb));
    if (an.aUq(((ajy)localObject2).GBb.GBE))
    {
      localObject2 = ((ajy)localObject2).GBb.GBE;
      localObject2 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject2));
      if (!bu.isNullOrNil((String)localObject2)) {
        localajx.aQg((String)localObject2);
      }
    }
    localajx.Dg(parambv.field_msgId);
    localajx.aQk(bn.BV(parambv.eNd));
    localajx.De(((s)localObject1).hPI);
    Object localObject1 = bx.M(((s)localObject1).aNt(), "msg");
    if (localObject1 != null)
    {
      localajx.aPG((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localajx.aPH((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
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
      AppMethodBeat.o(9453);
      return true;
      ae.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
    }
  }
  
  private static boolean d(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(9457);
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
      ae.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", parambv, "", new Object[0]);
      ae.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { parambv.getLocalizedMessage() });
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(9457);
      return false;
    }
    paramcw.doL.doQ = 2131758893;
    AppMethodBeat.o(9457);
    return false;
    label557:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */