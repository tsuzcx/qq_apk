package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.am.a.k;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final SimpleDateFormat xqx;
  
  static
  {
    AppMethodBeat.i(30988);
    xqx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static ajn a(bu parambu, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    ajn localajn = new ajn();
    localajn.aOx(aC(parambu));
    localajn.aOm(paramb.hAk);
    localajn.aOn(paramb.hAl);
    localajn.aOl(paramb.url);
    localajn.wk(true);
    parambu = new com.tencent.mm.vfs.e(bt.bI(com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true), ""));
    if (parambu.exists()) {
      localajn.aOu(com.tencent.mm.vfs.q.B(parambu.fOK()));
    }
    for (;;)
    {
      localajn.aOf(paramb.title);
      localajn.aOg(paramb.description);
      localajn.ZI(paramInt);
      localajn.aOE(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localajn;
      localajn.wl(true);
    }
  }
  
  private static ajn a(bu parambu, String paramString, ajo paramajo)
  {
    AppMethodBeat.i(30984);
    ajn localajn = new ajn();
    localajn.aOx(aC(parambu));
    localajn.ZI(1);
    localajn.aOg(paramString);
    localajn.wl(true);
    localajn.wk(true);
    localajn.a(paramajo);
    localajn.aOA(a(paramajo.Gis));
    localajn.aOB(b(paramajo.Gis));
    if (am.aSQ(paramajo.Gis.GiV))
    {
      parambu = paramajo.Gis.GiV;
      parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
      if (!bt.isNullOrNil(parambu)) {
        localajn.aOJ(parambu);
      }
    }
    AppMethodBeat.o(30984);
    return localajn;
  }
  
  private static String a(ajp paramajp)
  {
    AppMethodBeat.i(30973);
    String str2 = paramajp.GiV;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramajp.dyU;
    }
    if (com.tencent.mm.am.a.e.Ep(str1))
    {
      paramajp = com.tencent.mm.am.a.e.Er(str1);
      AppMethodBeat.o(30973);
      return paramajp;
    }
    paramajp = com.tencent.mm.model.v.ze(str1);
    AppMethodBeat.o(30973);
    return paramajp;
  }
  
  private static void a(bu parambu, ajo paramajo, aks paramaks)
  {
    AppMethodBeat.i(30986);
    paramajo.d(com.tencent.mm.ai.m.a(parambu, paramaks));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30985);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    Object localObject1 = parambu.field_content;
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localObject1 = k.b.yr((String)localObject1);
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30985);
      return false;
    }
    localajo.Gis.aOT(((k.b)localObject1).appId);
    localajo.Gis.aOV(((k.b)localObject1).dHo);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).Eb();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcv.dnG.dnL = 2131758893;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.ZI(1);
      paramContext.aOg(((k.b)localObject1).title);
      paramContext.wl(true);
      paramContext.wk(true);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjK += 1;
      AppMethodBeat.o(30985);
      return true;
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ao.bIX().aLD(((k.b)localObject1).dks);
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      if (localObject2 != null) {
        paramContext.aOt(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      if (com.tencent.mm.vfs.i.fv((String)localObject2)) {
        paramContext.aOu((String)localObject2);
      }
      paramContext.ZI(2);
      paramContext.aOf(((k.b)localObject1).title);
      paramContext.aOg(((k.b)localObject1).description);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      paramContext.CI(parambu.field_msgId);
      paramContext.aON(bl.Bt(parambu.eLs));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjL += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambu, (k.b)localObject1, 7);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjP += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambu, (k.b)localObject1, 4);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      paramContext.CI(parambu.field_msgId);
      paramContext.aON(bl.Bt(parambu.eLs));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.tGM += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localajo.Gis.aOU(((k.b)localObject1).url);
        paramContext = a(parambu, (k.b)localObject1, 5);
        paramContext.a(localajo);
        paramContext.aOA(a(localajo.Gis));
        paramContext.aOB(b(localajo.Gis));
        if (am.aSQ(localajo.Gis.GiV))
        {
          localObject2 = localajo.Gis.GiV;
          localObject2 = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject2));
          if (!bt.isNullOrNil((String)localObject2)) {
            paramContext.aOJ((String)localObject2);
          }
        }
        localObject2 = new aks();
        if (!bt.isNullOrNil(((k.b)localObject1).title)) {
          ((aks)localObject2).aPs(((k.b)localObject1).title);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).description)) {
          ((aks)localObject2).aPt(((k.b)localObject1).description);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((aks)localObject2).aPv(((k.b)localObject1).thumburl);
        }
        if (!bt.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((aks)localObject2).aPw(((k.b)localObject1).canvasPageXml);
        }
        if (((aks)localObject2).computeSize() > 0)
        {
          ((aks)localObject2).ZS(1);
          localajo.a((aks)localObject2);
        }
        paramcv.dnG.dnI.nZa.add(paramContext);
        paramContext = paramcv.dnG.dnJ;
        paramContext.GjN += 1;
        a(parambu, localajo, (aks)localObject2);
        AppMethodBeat.o(30985);
        return true;
      }
      paramcv.dnG.dnL = 2131758889;
      AppMethodBeat.o(30985);
      return false;
      paramContext = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.inc;
        localObject1 = new ajn();
        ((ajn)localObject1).aOA(a(localajo.Gis));
        ((ajn)localObject1).aOB(b(localajo.Gis));
        ((ajn)localObject1).aOx(aC(parambu));
        ((ajn)localObject1).wk(true);
        ((ajn)localObject1).aOf(paramContext.nickname + aj.getContext().getString(2131759007));
        ((ajn)localObject1).aOg(paramContext.desc);
        ((ajn)localObject1).ZI(22);
        localajo.c(paramContext);
        ((ajn)localObject1).a(localajo);
        paramcv.dnG.dnI.nZa.add(localObject1);
        AppMethodBeat.o(30985);
        return true;
      }
      AppMethodBeat.o(30985);
      return false;
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(30985);
        return false;
      }
      localObject2 = ao.bIX().aLD(((k.b)localObject1).dks);
      paramContext = new ajn();
      if (localObject2 != null) {
        paramContext.aOt(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.aOx(aC(parambu));
      paramContext.ZI(8);
      paramContext.aOp(((k.b)localObject1).hzP);
      localObject2 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      if (bt.isNullOrNil((String)localObject2)) {
        paramContext.wl(true);
      }
      if (com.tencent.mm.vfs.i.fv((String)localObject2)) {
        paramContext.aOu((String)localObject2);
      }
      paramContext.aOf(((k.b)localObject1).title);
      paramContext.aOg(((k.b)localObject1).description);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      paramContext.CI(parambu.field_msgId);
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.fileCount += 1;
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).dks == null) || (((k.b)localObject1).dks.length() == 0)) {
        paramcv.dnG.dnL = 2131758886;
      }
      do
      {
        paramcv.dnG.dnL = 2131758893;
        AppMethodBeat.o(30985);
        return false;
        ba.aBQ();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcv.dnG.dnL = 2131758901;
      AppMethodBeat.o(30985);
      return false;
      paramContext = new akc();
      paramContext.aOY(((k.b)localObject1).title);
      paramContext.aOZ(((k.b)localObject1).description);
      paramContext.ZO(((k.b)localObject1).hAn);
      paramContext.aPb(((k.b)localObject1).hAo);
      paramContext.aPa(((k.b)localObject1).thumburl);
      localajo.a(paramContext);
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.ZI(10);
      paramContext.wl(true);
      paramContext.wk(true);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjR += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new akm();
      paramContext.aPo(((k.b)localObject1).title);
      paramContext.aPp(((k.b)localObject1).description);
      paramContext.aPr(((k.b)localObject1).hAr);
      paramContext.aPq(((k.b)localObject1).thumburl);
      localajo.a(paramContext);
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.ZI(14);
      paramContext.wl(true);
      paramContext.wk(true);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjV += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = new akc();
      paramContext.aOY(((k.b)localObject1).title);
      paramContext.aOZ(((k.b)localObject1).description);
      paramContext.ZO(((k.b)localObject1).hAt);
      paramContext.aPb(((k.b)localObject1).hAu);
      paramContext.aPa(((k.b)localObject1).thumburl);
      localajo.a(paramContext);
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.ZI(11);
      paramContext.wl(true);
      paramContext.wk(true);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjS += 1;
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambu, paramContext.getString(2131755833), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.aOf(((k.b)localObject1).title);
      paramContext.aOg(((k.b)localObject1).description);
      paramContext.ZI(19);
      localObject2 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      if (bt.isNullOrNil((String)localObject2)) {
        paramContext.wl(true);
      }
      if (com.tencent.mm.vfs.i.fv((String)localObject2)) {
        paramContext.aOu((String)localObject2);
      }
      localObject2 = new ajl();
      if (!bt.isNullOrNil(((k.b)localObject1).hCn)) {
        ((ajl)localObject2).username = ((k.b)localObject1).hCn;
      }
      if (!bt.isNullOrNil(((k.b)localObject1).hCo)) {
        ((ajl)localObject2).appId = ((k.b)localObject1).hCo;
      }
      if (!bt.isNullOrNil(((k.b)localObject1).hCB)) {
        ((ajl)localObject2).iconUrl = ((k.b)localObject1).hCB;
      }
      ((ajl)localObject2).kro = ((k.b)localObject1).hCw;
      ((ajl)localObject2).type = ((k.b)localObject1).hCp;
      ((ajl)localObject2).dtF = ((k.b)localObject1).hCr;
      ((ajl)localObject2).dki = ((k.b)localObject1).hCm;
      ((ajl)localObject2).GgH = ((k.b)localObject1).dHp;
      localajo.b((ajl)localObject2);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      paramContext.CI(parambu.field_msgId);
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = a(parambu, paramContext.getString(2131755786) + ((k.b)localObject1).title, localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      paramContext = ((k.b)localObject1).t(paramContext, true);
      if (bt.isNullOrNil(paramContext))
      {
        paramcv.dnG.dnL = 2131758893;
        AppMethodBeat.o(30985);
        return false;
      }
      paramContext = a(parambu, paramContext + ((k.b)localObject1).title, localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(30985);
      return true;
      if ((((k.b)localObject1).hAs != null) && (((k.b)localObject1).hAs.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new ajn();
        ((ajn)localObject2).aOx(aC(parambu));
        ((ajn)localObject2).ZI(17);
        ((ajn)localObject2).wl(true);
        ((ajn)localObject2).aOf(((k.b)localObject1).title);
        ((ajn)localObject2).aOF(((k.b)localObject1).hAs);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new qh();
        ((qh)localObject3).dEN.type = 0;
        ((qh)localObject3).dEN.dEP = ((k.b)localObject1).hAs;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
        localObject1 = ((qh)localObject3).dEO.dEY;
        if (localObject1 == null) {
          break label3371;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hDb.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (bt.isNullOrNil(((ajn)((Iterator)localObject3).next()).Gij));
        paramcv.dnG.dnL = 2131758893;
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
      ((ajn)localObject2).aOg(paramContext);
      ((ajn)localObject2).a(localajo);
      ((ajn)localObject2).aOA(a(localajo.Gis));
      ((ajn)localObject2).aOB(b(localajo.Gis));
      ((ajn)localObject2).CI(parambu.field_msgId);
      if (am.aSQ(localajo.Gis.GiV))
      {
        paramContext = localajo.Gis.GiV;
        paramContext = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramContext));
        if (!bt.isNullOrNil(paramContext)) {
          ((ajn)localObject2).aOJ(paramContext);
        }
      }
      paramcv.dnG.dnI.nZa.add(localObject2);
      AppMethodBeat.o(30985);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cv paramcv, String paramString, List<bu> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bu)((Iterator)localObject1).next();
      if (bl.z((bu)localObject2)) {
        switch (((bu)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((bu)localObject2).setContent(paramContext.getString(2131755904));
          break;
        case 3: 
          ((bu)localObject2).setContent(paramContext.getString(2131755853));
          ((bu)localObject2).setType(1);
          break;
        case 43: 
          ((bu)localObject2).setContent(paramContext.getString(2131755926));
          ((bu)localObject2).setType(1);
          break;
        case 49: 
          ((bu)localObject2).setContent(paramContext.getString(2131755914));
          ((bu)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.am.g.vd(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (bu)paramList.get(0);
      if (paramList.fpd())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.ai.u)localObject1).hDb != null) && (((com.tencent.mm.ai.u)localObject1).hDb.size() == 1))
        {
          paramBoolean = g.e(paramcv, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramcv.dnG.dnI = new akd();
        paramcv.dnG.dnJ = new akr();
        paramcv.dnG.dnI.a(aLx(paramString));
        paramcv.dnG.type = 14;
        paramBoolean = b(paramContext, paramcv, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = g.e(paramcv, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramcv.dnG.dnI = new akd();
    paramcv.dnG.dnJ = new akr();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.am.a.e.sa(((bu)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.am.a.e.Eq((String)localObject1))
      {
        paramcv.dnG.dnI.aPd(paramContext.getString(2131762236));
        ad.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcv.dnG.dnI.title });
      }
    }
    else
    {
      paramcv.dnG.dnI.a(aLx(paramString));
      paramcv.dnG.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcv, (bu)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.am.a.e.Et(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcv.dnG.dnI.aPd(paramContext.getString(2131758963, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.am.a.e.Er((String)localObject1) }));
        break;
        label633:
        if (w.vF(paramString))
        {
          paramcv.dnG.dnI.aPd(paramContext.getString(2131762236));
          break;
        }
        localObject1 = bt.nullAsNil(com.tencent.mm.model.u.aAo());
        if (((String)localObject1).equals(bt.nullAsNil(com.tencent.mm.model.v.ze(paramString))))
        {
          paramcv.dnG.dnI.aPd(paramContext.getString(2131758964, new Object[] { localObject1 }));
          break;
        }
        paramcv.dnG.dnI.aPd(paramContext.getString(2131758963, new Object[] { com.tencent.mm.model.u.aAo(), com.tencent.mm.model.v.ze(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcv.dnG.dnL > 0)) {
      paramcv.dnG.dnL = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30978);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    Object localObject = bw.M(parambu.field_content, "msg");
    if (localObject != null) {
      try
      {
        aju localaju = new aju();
        localaju.aOW((String)((Map)localObject).get(".msg.location.$label"));
        localaju.B(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localaju.A(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localaju.ZN(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localaju.aOX((String)((Map)localObject).get(".msg.location.$poiname"));
        localajo.c(localaju);
        localObject = new ajn();
        ((ajn)localObject).aOx(aC(parambu));
        ((ajn)localObject).ZI(6);
        ((ajn)localObject).wl(true);
        ((ajn)localObject).wk(true);
        ((ajn)localObject).a(localajo);
        ((ajn)localObject).aOA(a(localajo.Gis));
        ((ajn)localObject).aOB(b(localajo.Gis));
        if (am.aSQ(localajo.Gis.GiV))
        {
          parambu = localajo.Gis.GiV;
          parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
          if (!bt.isNullOrNil(parambu)) {
            ((ajn)localObject).aOJ(parambu);
          }
        }
        paramcv.dnG.dnI.nZa.add(localObject);
        parambu = paramcv.dnG.dnJ;
        parambu.GjO += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception parambu)
      {
        ad.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { parambu.getStackTrace().toString() });
      }
    }
    paramcv.dnG.dnL = 2131758895;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static ajp aB(bu parambu)
  {
    AppMethodBeat.i(30972);
    ajp localajp = new ajp();
    if (parambu == null)
    {
      AppMethodBeat.o(30972);
      return localajp;
    }
    Object localObject;
    if (parambu.field_isSend == 0)
    {
      localajp.aOO(parambu.field_talker);
      localajp.aOP(com.tencent.mm.model.u.aAm());
      if (w.vF(parambu.field_talker))
      {
        if (parambu.field_content == null) {
          break label367;
        }
        localObject = parambu.field_content.substring(0, Math.max(0, parambu.field_content.indexOf(':')));
        localajp.aOR((String)localObject);
        if ((!bt.isNullOrNil(localajp.GiV)) && (!parambu.fph()))
        {
          parambu.setContent(parambu.field_content.substring(localajp.GiV.length() + 1));
          if ((parambu.field_content.length() > 0) && ('\n' == parambu.field_content.charAt(0))) {
            parambu.setContent(parambu.field_content.substring(1));
          }
          if (parambu.frS())
          {
            if ((!bt.isNullOrNil(parambu.field_transContent)) && (parambu.field_transContent.startsWith(localajp.GiV))) {
              parambu.tQ(parambu.field_transContent.substring(localajp.GiV.length() + 1));
            }
            if ((parambu.field_transContent.length() > 0) && ('\n' == parambu.field_transContent.charAt(0))) {
              parambu.tQ(parambu.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.am.g.vd(parambu.field_talker))
      {
        String str = parambu.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bj.Bq(parambu.eLs).userId;
        }
        localajp.aOR((String)localObject);
      }
      localajp.ZM(1);
      localajp.CJ(parambu.field_createTime);
      localajp.aOS(parambu.field_msgSvrId);
      if (parambu.field_msgSvrId > 0L) {
        localajp.aOQ(parambu.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localajp;
      label367:
      localObject = "";
      break;
      localajp.aOO(com.tencent.mm.model.u.aAm());
      localajp.aOP(parambu.field_talker);
      if (w.vF(parambu.field_talker)) {
        localajp.aOR(localajp.dyU);
      }
    }
  }
  
  private static String aC(bu parambu)
  {
    AppMethodBeat.i(30975);
    if (parambu.field_isSend == 1)
    {
      if ((w.vF(parambu.field_talker)) || (parambu.field_talker.equals("filehelper")))
      {
        parambu = String.format("%d", new Object[] { Long.valueOf(parambu.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return parambu;
      }
      parambu = String.format("%s#%d", new Object[] { parambu.field_talker, Long.valueOf(parambu.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return parambu;
    }
    long l = parambu.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String aLw(String paramString)
  {
    AppMethodBeat.i(30980);
    ba.aBQ();
    paramString = com.tencent.mm.sdk.platformtools.m.d(com.tencent.mm.model.c.azD(), "recbiz_", paramString, ".rec", 2);
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
  
  private static akj aLx(String paramString)
  {
    AppMethodBeat.i(30971);
    akj localakj = new akj();
    localakj.aPf(paramString);
    localakj.ZR(1);
    localakj.CM(bt.flT());
    localakj.aPh("");
    AppMethodBeat.o(30971);
    return localakj;
  }
  
  private static String b(ajp paramajp)
  {
    AppMethodBeat.i(30974);
    paramajp = xqx.format(new Date(paramajp.createTime));
    AppMethodBeat.o(30974);
    return paramajp;
  }
  
  private static boolean b(Context paramContext, cv paramcv, bu parambu)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramcv == null) || (parambu == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    parambu = bu.aN(parambu);
    if (parambu.isText()) {
      bool = f(paramcv, parambu);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(parambu, paramcv, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (parambu.fph()) {
        bool = m(paramcv, parambu);
      } else if (parambu.cTe()) {
        bool = a(paramcv, parambu);
      } else if (parambu.fpi()) {
        bool = l(paramcv, parambu);
      } else if (parambu.cxf()) {
        bool = c(paramcv, parambu);
      } else if (parambu.cxh()) {
        bool = c(paramcv, parambu);
      } else if (parambu.cxg()) {
        bool = com.tencent.mm.plugin.record.b.c.b(paramcv, parambu);
      } else if (parambu.fpd()) {
        bool = d(paramcv, parambu);
      } else if (parambu.frE()) {
        bool = c(paramContext, paramcv, parambu);
      } else if ((parambu.cTc()) && (!parambu.frH())) {
        bool = a(paramContext, paramcv, parambu);
      } else {
        paramcv.dnG.dnL = 2131758893;
      }
    }
  }
  
  private static boolean c(Context paramContext, cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30982);
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    if ((localObject != null) && (w.on(((bu.a)localObject).DKi)))
    {
      paramContext = new ajn();
      paramContext.aOx(aC(parambu));
      paramContext.ZI(16);
      paramContext.aOg(parambu.field_content);
      paramContext.wl(true);
      paramContext.wk(true);
      paramContext.a(localajo);
      paramContext.aOA(a(localajo.Gis));
      paramContext.aOB(b(localajo.Gis));
      if (!am.aSQ(localajo.Gis.GiV)) {
        break label337;
      }
      parambu = localajo.Gis.GiV;
      parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
      if (!bt.isNullOrNil(parambu)) {
        paramContext.aOJ(parambu);
      }
    }
    label337:
    for (;;)
    {
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjW += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (am.aSQ(((bu.a)localObject).dHm)))
      {
        localObject = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(((bu.a)localObject).IMq, "openim_card_type_name", b.a.iHt);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(parambu, paramContext, localajo);
          break;
        }
      }
      paramContext = a(parambu, paramContext.getString(2131755784), localajo);
    }
  }
  
  private static boolean c(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30981);
    Object localObject = new ajo();
    ((ajo)localObject).c(aB(parambu));
    ajn localajn = new ajn();
    localajn.aOx(aC(parambu));
    o.aMJ();
    localajn.aOt(t.Hh(parambu.field_imgPath));
    o.aMJ();
    localajn.aOu(t.Hi(parambu.field_imgPath));
    localajn.aOp(com.tencent.mm.vfs.i.ZF(localajn.Ghp));
    if (parambu.cxh()) {
      localajn.ZI(15);
    }
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      if (locals != null) {
        break;
      }
      ad.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(30981);
      return false;
      localajn.ZI(4);
    }
    ad.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.hMP) });
    if (locals.hMP > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(false))
    {
      paramcv.dnG.dnL = 2131759024;
      AppMethodBeat.o(30981);
      return false;
    }
    if ((parambu.cxh()) && (com.tencent.mm.modelvideo.u.HA(locals.getFileName())))
    {
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(30981);
      return false;
    }
    localajn.ZH(locals.hHQ);
    localajn.a((ajo)localObject);
    localajn.aOA(a(((ajo)localObject).Gis));
    localajn.aOB(b(((ajo)localObject).Gis));
    if (am.aSQ(((ajo)localObject).Gis.GiV))
    {
      localObject = ((ajo)localObject).Gis.GiV;
      localObject = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject));
      if (!bt.isNullOrNil((String)localObject)) {
        localajn.aOJ((String)localObject);
      }
    }
    localajn.CI(parambu.field_msgId);
    localajn.aON(bl.Bt(parambu.eLs));
    localajn.CG(locals.hMP);
    paramcv.dnG.dnI.nZa.add(localajn);
    paramcv = paramcv.dnG.dnJ;
    paramcv.tGM += 1;
    paramcv = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    localajn.aOD(paramcv.dHv);
    paramcv = paramcv.iun;
    if ((paramcv != null) && (!bt.isNullOrNil(paramcv.hCk)))
    {
      parambu = new ajq();
      parambu.hCe = paramcv.hCe;
      parambu.Gje = paramcv.Gje;
      parambu.hCh = paramcv.hCh;
      parambu.hCi = paramcv.hCi;
      parambu.hCg = paramcv.hCg;
      parambu.hCj = paramcv.hCj;
      parambu.hCk = paramcv.hCk;
      parambu.hCl = paramcv.hCl;
      localajn.a(parambu);
    }
    AppMethodBeat.o(30981);
    return true;
  }
  
  private static boolean d(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30987);
    try
    {
      com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
      Object localObject1 = localu.hDb;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.ai.v localv = (com.tencent.mm.ai.v)((Iterator)localObject1).next();
          if (!com.tencent.mm.ai.m.yt(localv.hDr))
          {
            ajo localajo = new ajo();
            localajo.c(aB(parambu));
            localajo.Gis.aOV(localu.dHo);
            localajo.Gis.aOU(localv.url);
            Object localObject2 = new ajn();
            ((ajn)localObject2).aOf(localv.title);
            ((ajn)localObject2).aOg(localv.hDo);
            ((ajn)localObject2).aOx(aC(parambu));
            if (!bt.isNullOrNil(localv.hDm)) {
              ((ajn)localObject2).aOu(r.aLC(localv.hDm));
            }
            for (;;)
            {
              ((ajn)localObject2).wk(true);
              aks localaks = new aks();
              if (!bt.isNullOrNil(localv.title)) {
                localaks.aPs(localv.title);
              }
              if (!bt.isNullOrNil(localv.hDo)) {
                localaks.aPt(localv.hDo);
              }
              if (!bt.isNullOrNil(localv.hDm)) {
                localaks.aPv(com.tencent.mm.ai.m.a(localv));
              }
              if (localaks.computeSize() > 0)
              {
                localaks.ZS(1);
                localajo.a(localaks);
              }
              ((ajn)localObject2).ZI(5);
              ((ajn)localObject2).a(localajo);
              ((ajn)localObject2).aOA(a(localajo.Gis));
              ((ajn)localObject2).aOB(b(localajo.Gis));
              if (am.aSQ(localajo.Gis.GiV))
              {
                String str = localajo.Gis.GiV;
                str = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str));
                if (!bt.isNullOrNil(str)) {
                  ((ajn)localObject2).aOJ(str);
                }
              }
              paramcv.dnG.dnI.nZa.add(localObject2);
              localObject2 = paramcv.dnG.dnJ;
              ((akr)localObject2).GjN += 1;
              localajo.d(com.tencent.mm.ai.m.a(localv, localaks, localu.dHo, localu.dHp));
              i += 1;
              break;
              ((ajn)localObject2).wl(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception parambu)
    {
      ad.printErrStackTrace("MicroMsg.GetFavRecordDataSource", parambu, "", new Object[0]);
      ad.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { parambu.getLocalizedMessage() });
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30987);
      return false;
    }
    paramcv.dnG.dnL = 2131758893;
    AppMethodBeat.o(30987);
    return false;
    label557:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean f(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30976);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    ajn localajn = new ajn();
    localajn.aOx(aC(parambu));
    localajn.ZI(1);
    if (parambu.fso()) {}
    for (String str = aj.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; str = "")
    {
      localajn.aOg(str + parambu.field_content);
      localajn.wl(true);
      localajn.wk(true);
      localajn.a(localajo);
      localajn.aOA(a(localajo.Gis));
      localajn.aOB(b(localajo.Gis));
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          localajn.aOJ(parambu);
        }
      }
      paramcv.dnG.dnI.nZa.add(localajn);
      paramcv = paramcv.dnG.dnJ;
      paramcv.GjK += 1;
      AppMethodBeat.o(30976);
      return true;
    }
  }
  
  private static boolean l(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30977);
    Object localObject1 = null;
    if (parambu.field_msgId > 0L) {
      localObject1 = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, (int)parambu.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambu.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.aw.q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcv.dnG.dnL = 2131758891;
      AppMethodBeat.o(30977);
      return false;
    }
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    localObject1 = new ajn();
    ((ajn)localObject1).aOx(aC(parambu));
    ((ajn)localObject1).ZI(2);
    ((ajn)localObject1).aOt(com.tencent.mm.aw.q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject2), "", ""));
    if (((com.tencent.mm.aw.g)localObject2).aIj())
    {
      localObject2 = com.tencent.mm.aw.q.aIF().pt(((com.tencent.mm.aw.g)localObject2).hZH);
      if (((com.tencent.mm.aw.g)localObject2).hMP > ((com.tencent.mm.aw.g)localObject2).offset) {
        ((ajn)localObject1).aOt(com.tencent.mm.aw.q.aIF().o("SERVERID://" + parambu.field_msgSvrId, "", ""));
      }
    }
    ((ajn)localObject1).aOu(com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true));
    ((ajn)localObject1).a(localajo);
    ((ajn)localObject1).aOA(a(localajo.Gis));
    ((ajn)localObject1).aOB(b(localajo.Gis));
    ((ajn)localObject1).CI(parambu.field_msgId);
    ((ajn)localObject1).aON(bl.Bt(parambu.eLs));
    if (am.aSQ(localajo.Gis.GiV))
    {
      parambu = localajo.Gis.GiV;
      parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
      if (!bt.isNullOrNil(parambu)) {
        ((ajn)localObject1).aOJ(parambu);
      }
    }
    paramcv.dnG.dnI.nZa.add(localObject1);
    paramcv = paramcv.dnG.dnJ;
    paramcv.GjL += 1;
    AppMethodBeat.o(30977);
    return true;
  }
  
  private static boolean m(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30979);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    ajn localajn = new ajn();
    localajn.aOx(aC(parambu));
    localajn.ZI(3);
    if (w.Aa(parambu.field_talker)) {
      localajn.aOt(aLw(parambu.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localajn.wl(true);
      localb = com.tencent.mm.modelvoice.s.HR(parambu.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30979);
      return false;
      localajn.aOt(com.tencent.mm.modelvoice.s.getFullPath(parambu.field_imgPath));
    }
    localajn.aOp(g.Yl(localb.getFormat()));
    localajn.ZH((int)new p(parambu.field_content).time);
    localajn.a(localajo);
    localajn.aOA(a(localajo.Gis));
    localajn.aOB(b(localajo.Gis));
    if (am.aSQ(localajo.Gis.GiV))
    {
      parambu = localajo.Gis.GiV;
      parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
      if (!bt.isNullOrNil(parambu)) {
        localajn.aOJ(parambu);
      }
    }
    paramcv.dnG.dnI.nZa.add(localajn);
    paramcv = paramcv.dnG.dnJ;
    paramcv.GjM += 1;
    AppMethodBeat.o(30979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */