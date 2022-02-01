package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.am.a.k;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
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

public final class c
{
  private static final SimpleDateFormat xqx;
  
  static
  {
    AppMethodBeat.i(9458);
    xqx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static ajn a(bu parambu, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localajn;
      localajn.wl(true);
    }
  }
  
  private static ajn a(bu parambu, String paramString, ajo paramajo)
  {
    AppMethodBeat.i(9455);
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
    AppMethodBeat.o(9455);
    return localajn;
  }
  
  private static String a(ajp paramajp)
  {
    AppMethodBeat.i(9448);
    String str2 = paramajp.GiV;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = paramajp.dyU;
    }
    if (com.tencent.mm.am.a.e.Ep(str1))
    {
      paramajp = com.tencent.mm.am.a.e.Er(str1);
      AppMethodBeat.o(9448);
      return paramajp;
    }
    paramajp = com.tencent.mm.model.v.ze(str1);
    AppMethodBeat.o(9448);
    return paramajp;
  }
  
  private static boolean a(Context paramContext, cv paramcv, bu parambu)
  {
    AppMethodBeat.i(9456);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    Object localObject1 = parambu.field_content;
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.yr((String)localObject1);
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(9456);
      return false;
    }
    localajo.Gis.aOT(((k.b)localObject1).appId);
    localajo.Gis.aOV(((k.b)localObject1).dHo);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).Eb()))
    {
      paramContext = a(parambu, paramContext.getString(2131755785), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(parambu, paramContext.getString(2131755898), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
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
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bIX().aLD(((k.b)localObject1).dks);
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
      AppMethodBeat.o(9456);
      return true;
    case 3: 
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
      if (((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.aOL(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.aOM(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ao(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.GjP += 1;
      AppMethodBeat.o(9456);
      return true;
    case 4: 
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
      AppMethodBeat.o(9456);
      return true;
    case 5: 
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
        localajo.d(m.a(parambu, (aks)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramcv.dnG.dnL = 2131758889;
      paramContext = a(parambu, paramContext.getString(2131755898), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
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
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.s.a.bIX().aLD(((k.b)localObject1).dks);
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
      paramContext.CG(((k.b)localObject1).hzO);
      paramContext.aOq(((k.b)localObject1).filemd5);
      if (am.aSQ(localajo.Gis.GiV))
      {
        parambu = localajo.Gis.GiV;
        parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
        if (!bt.isNullOrNil(parambu)) {
          paramContext.aOJ(parambu);
        }
      }
      paramContext.aOj(((k.b)localObject1).hAd);
      paramContext.aOk(((k.b)localObject1).gjI);
      paramContext.aOI(((k.b)localObject1).hzU);
      paramContext.aOG(((k.b)localObject1).gjI);
      paramContext.aOH(((k.b)localObject1).hAa);
      paramcv.dnG.dnI.nZa.add(paramContext);
      paramContext = paramcv.dnG.dnJ;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).dks == null) || (((k.b)localObject1).dks.length() == 0)) {
        paramcv.dnG.dnL = 2131758886;
      }
      do
      {
        paramcv.dnG.dnL = 2131758893;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.g.ajD();
      } while (com.tencent.mm.kernel.g.ajC().isSDCardAvailable());
      paramcv.dnG.dnL = 2131758901;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
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
      AppMethodBeat.o(9456);
      return true;
    case 20: 
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
      AppMethodBeat.o(9456);
      return true;
    case 13: 
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
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(parambu, paramContext.getString(2131755833), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if (((k.b)localObject1).hCp == 3)
      {
        paramContext = a(parambu, paramContext.getString(2131755833), localajo);
        paramcv.dnG.dnI.nZa.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
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
      ((ajl)localObject2).type = ((k.b)localObject1).hCp;
      ((ajl)localObject2).dtF = ((k.b)localObject1).hCz;
      ((ajl)localObject2).dki = ((k.b)localObject1).hCm;
      ((ajl)localObject2).GgH = ((k.b)localObject1).dHp;
      ((ajl)localObject2).kro = ((k.b)localObject1).hCw;
      localObject1 = (com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class);
      if (localObject1 != null)
      {
        ((ajl)localObject2).jXI = ((com.tencent.mm.ai.a)localObject1).hyh;
        ((ajl)localObject2).dJW = ((com.tencent.mm.ai.a)localObject1).hyj;
        ((ajl)localObject2).subType = ((com.tencent.mm.ai.a)localObject1).hyk;
      }
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
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(parambu, paramContext.getString(2131755786) + ((k.b)localObject1).title, localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).t(paramContext, true);
      if (bt.isNullOrNil((String)localObject2))
      {
        paramContext = a(parambu, paramContext.getString(2131755898), localajo);
        paramcv.dnG.dnI.nZa.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(parambu, (String)localObject2 + ((k.b)localObject1).title, localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).hAs != null) && (((k.b)localObject1).hAs.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).hDb.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!bt.isNullOrNil(((ajn)((Iterator)localObject3).next()).Gij))
              {
                paramcv.dnG.dnL = 2131758893;
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
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambu, paramContext.getString(2131759036), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(parambu, paramContext.getString(2131755860), localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
  }
  
  private static boolean a(Context paramContext, cv paramcv, bu parambu, int paramInt)
  {
    AppMethodBeat.i(9446);
    ajo localajo = new ajo();
    localajo.c(aB(parambu));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131755722);
    }
    for (;;)
    {
      paramContext = a(parambu, str, localajo);
      paramcv.dnG.dnI.nZa.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131755839);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131755898);
      }
    }
  }
  
  public static boolean a(Context paramContext, cv paramcv, String paramString, List<bu> paramList)
  {
    AppMethodBeat.i(9445);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(9445);
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
    boolean bool1 = com.tencent.mm.am.g.vd(paramString);
    paramList.size();
    paramcv.dnG.dnI = new akd();
    paramcv.dnG.dnJ = new akr();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.am.a.e.sa(((bu)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.am.a.e.Eq((String)localObject1))
      {
        paramcv.dnG.dnI.aPd(paramContext.getString(2131762236));
        ad.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcv.dnG.dnI.title });
      }
    }
    else
    {
      localObject1 = paramcv.dnG.dnI;
      localObject2 = new akj();
      ((akj)localObject2).aPf(paramString);
      ((akj)localObject2).ZR(1);
      ((akj)localObject2).CM(bt.flT());
      ((akj)localObject2).aPh("");
      ((akd)localObject1).a((akj)localObject2);
      paramcv.dnG.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label2329;
      }
      paramString = (bu)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcv.dnG.dnL = 2131758885;
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
        localObject2 = com.tencent.mm.am.a.e.Et(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcv.dnG.dnI.aPd(paramContext.getString(2131758963, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.am.a.e.Er((String)localObject1) }));
        break;
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
        localObject2 = bu.aN(paramString);
        bool1 = false;
        Object localObject3;
        if (((bu)localObject2).isText())
        {
          localObject3 = new ajo();
          ((ajo)localObject3).c(aB((bu)localObject2));
          paramList = new ajn();
          paramList.aOx(aC((bu)localObject2));
          paramList.ZI(1);
          if (((bu)localObject2).fso()) {}
          for (paramString = aj.getContext().getString(2131762657, new Object[] { "@" }) + '\n';; paramString = "")
          {
            paramList.aOg(paramString + ((ei)localObject2).field_content);
            paramList.wl(true);
            paramList.wk(true);
            paramList.a((ajo)localObject3);
            paramList.aOA(a(((ajo)localObject3).Gis));
            paramList.aOB(b(((ajo)localObject3).Gis));
            if (am.aSQ(((ajo)localObject3).Gis.GiV))
            {
              paramString = ((ajo)localObject3).Gis.GiV;
              paramString = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString));
              if (!bt.isNullOrNil(paramString)) {
                paramList.aOJ(paramString);
              }
            }
            paramcv.dnG.dnI.nZa.add(paramList);
            paramString = paramcv.dnG.dnJ;
            paramString.GjK += 1;
            bool1 = true;
            break;
          }
        }
        if (((bu)localObject2).fph())
        {
          paramList = new ajo();
          paramList.c(aB((bu)localObject2));
          paramString = new ajn();
          paramString.aOx(aC((bu)localObject2));
          paramString.ZI(3);
          paramString.wl(true);
          paramString.wk(true);
          paramString.a(paramList);
          paramString.aOA(a(paramList.Gis));
          paramString.aOB(b(paramList.Gis));
          if (am.aSQ(paramList.Gis.GiV))
          {
            paramList = paramList.Gis.GiV;
            paramList = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramList));
            if (!bt.isNullOrNil(paramList)) {
              paramString.aOJ(paramList);
            }
          }
          paramcv.dnG.dnI.nZa.add(paramString);
          paramString = paramcv.dnG.dnJ;
          paramString.GjM += 1;
          bool1 = true;
        }
        else if (((bu)localObject2).cTe())
        {
          bool1 = a(paramcv, (bu)localObject2);
        }
        else if (((bu)localObject2).fpi())
        {
          paramList = null;
          if (((ei)localObject2).field_msgId > 0L) {
            paramList = com.tencent.mm.aw.q.aIF().G(((ei)localObject2).field_talker, (int)((ei)localObject2).field_msgId);
          }
          if (paramList != null)
          {
            paramString = paramList;
            if (paramList.dnz > 0L) {}
          }
          else
          {
            paramString = paramList;
            if (((ei)localObject2).field_msgSvrId > 0L) {
              paramString = com.tencent.mm.aw.q.aIF().F(((ei)localObject2).field_talker, ((ei)localObject2).field_msgSvrId);
            }
          }
          if (paramString == null)
          {
            ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
            paramcv.dnG.dnL = 2131758891;
            bool1 = false;
            continue;
          }
          localObject3 = new ajo();
          ((ajo)localObject3).c(aB((bu)localObject2));
          paramList = new ajn();
          paramList.aOx(aC((bu)localObject2));
          paramList.ZI(2);
          paramList.aOt(com.tencent.mm.aw.q.aIF().o(com.tencent.mm.aw.h.c(paramString), "", ""));
          if (paramString.aIj())
          {
            com.tencent.mm.aw.g localg = com.tencent.mm.aw.q.aIF().pt(paramString.hZH);
            if (localg.hMP > localg.offset) {
              paramList.aOt(com.tencent.mm.aw.q.aIF().o("SERVERID://" + ((ei)localObject2).field_msgSvrId, "", ""));
            }
          }
          paramList.aOu(com.tencent.mm.aw.q.aIF().R(((ei)localObject2).field_imgPath, true));
          paramList.a((ajo)localObject3);
          paramList.aOA(a(((ajo)localObject3).Gis));
          paramList.aOB(b(((ajo)localObject3).Gis));
          paramList.CI(((ei)localObject2).field_msgId);
          paramList.aON(bl.Bt(((ei)localObject2).eLs));
          if (am.aSQ(((ajo)localObject3).Gis.GiV))
          {
            localObject3 = ((ajo)localObject3).Gis.GiV;
            localObject3 = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject3));
            if (!bt.isNullOrNil((String)localObject3)) {
              paramList.aOJ((String)localObject3);
            }
          }
          if ((!paramString.aIj()) || (paramString.hMP != 0)) {
            break label2364;
          }
          paramString = com.tencent.mm.aw.q.aIF().pt(paramString.hZH);
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
        if (paramString.aIj())
        {
          i = 1;
          localObject2 = bw.M(paramString.hZI, "msg");
          if (localObject2 == null) {
            break label1743;
          }
          if (i == 1)
          {
            paramList.aOj((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.CG(bt.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.aOk((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcv.dnG.dnI.nZa.add(paramList);
        paramString = paramcv.dnG.dnJ;
        paramString.GjL += 1;
        bool1 = true;
        break;
        i = 0;
        break label1564;
        if (!paramString.aIj())
        {
          i = 0;
          break label1564;
        }
        localObject2 = com.tencent.mm.aw.h.a(paramString);
        if (!com.tencent.mm.vfs.i.fv(com.tencent.mm.aw.q.aIF().o(((com.tencent.mm.aw.g)localObject2).hZw, "", "")))
        {
          i = 0;
          break label1564;
        }
        i = 1;
        break label1564;
        label1743:
        ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.hZI });
      }
      if (((bu)localObject2).cxf())
      {
        bool1 = c(paramcv, (bu)localObject2);
        break label468;
      }
      if (((bu)localObject2).cxg())
      {
        bool1 = b(paramcv, (bu)localObject2);
        break label468;
      }
      if (((bu)localObject2).cxh())
      {
        bool1 = c(paramcv, (bu)localObject2);
        break label468;
      }
      if (((bu)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcv, (bu)localObject2, 3);
        break label468;
      }
      if (((bu)localObject2).fpd())
      {
        bool1 = d(paramcv, (bu)localObject2);
        break label468;
      }
      if ((((bu)localObject2).frG()) || (((bu)localObject2).frH()))
      {
        bool1 = a(paramContext, paramcv, (bu)localObject2, 1);
        break label468;
      }
      if (((bu)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcv, (bu)localObject2, 2);
        break label468;
      }
      if (((bu)localObject2).frE())
      {
        paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqk(((ei)localObject2).field_content);
        paramList = new ajo();
        paramList.c(aB((bu)localObject2));
        if ((paramString != null) && (w.on(paramString.DKi)))
        {
          paramString = new ajn();
          paramString.aOx(aC((bu)localObject2));
          paramString.ZI(16);
          paramString.aOg(((ei)localObject2).field_content);
          paramString.wl(true);
          paramString.wk(true);
          paramString.a(paramList);
          paramString.aOA(a(paramList.Gis));
          paramString.aOB(b(paramList.Gis));
          if (!am.aSQ(paramList.Gis.GiV)) {
            break label2361;
          }
          paramList = paramList.Gis.GiV;
          paramList = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramList));
          if (!bt.isNullOrNil(paramList)) {
            paramString.aOJ(paramList);
          }
        }
      }
      for (;;)
      {
        paramcv.dnG.dnI.nZa.add(paramString);
        paramString = paramcv.dnG.dnJ;
        paramString.GjW += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (am.aSQ(paramString.dHm)))
        {
          paramString = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramString.IMq, "openim_card_type_name", b.a.iHt);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131755784);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((bu)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((bu)localObject2, paramContext.getString(2131755784), paramList);
        continue;
        if (((bu)localObject2).cTc())
        {
          if (((bu)localObject2).frH())
          {
            paramcv.dnG.dnL = 2131758893;
            break label468;
          }
          bool1 = a(paramContext, paramcv, (bu)localObject2);
          break label468;
        }
        paramcv.dnG.dnL = 2131758893;
        bool1 = a(paramContext, paramcv, (bu)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcv.dnG.dnL > 0)) {
          paramcv.dnG.dnL = 0;
        }
        AppMethodBeat.o(9445);
        return bool2;
      }
    }
  }
  
  private static boolean a(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(9451);
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
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception parambu)
      {
        ad.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { parambu.getStackTrace().toString() });
      }
    }
    paramcv.dnG.dnL = 2131758895;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static ajp aB(bu parambu)
  {
    AppMethodBeat.i(9447);
    ajp localajp = new ajp();
    if (parambu == null)
    {
      AppMethodBeat.o(9447);
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
      AppMethodBeat.o(9447);
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
    AppMethodBeat.i(9450);
    if (parambu.field_isSend == 1)
    {
      if ((w.vF(parambu.field_talker)) || (parambu.field_talker.equals("filehelper")))
      {
        parambu = String.format("%d", new Object[] { Long.valueOf(parambu.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return parambu;
      }
      parambu = String.format("%s#%d", new Object[] { parambu.field_talker, Long.valueOf(parambu.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return parambu;
    }
    long l = parambu.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static String b(ajp paramajp)
  {
    AppMethodBeat.i(9449);
    paramajp = xqx.format(new Date(paramajp.createTime));
    AppMethodBeat.o(9449);
    return paramajp;
  }
  
  public static boolean b(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.aA(parambu.field_content, parambu.field_reserved);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new akd();
    Object localObject3 = new akj();
    ((akj)localObject3).aPf(com.tencent.mm.model.u.aAm());
    ((akj)localObject3).aPg(com.tencent.mm.model.u.aAm());
    ((akj)localObject3).ZR(4);
    ((akj)localObject3).CM(bt.flT());
    ((akj)localObject3).aPm(((k.b)localObject2).url);
    ((akd)localObject1).a((akj)localObject3);
    localObject1 = new ajn();
    ((ajn)localObject1).aOt("");
    ((ajn)localObject1).aOo(((k.b)localObject2).thumburl);
    localObject3 = m.t(parambu);
    if (localObject3 == null)
    {
      ad.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((ajn)localObject1).ZH(((ajv)localObject3).duration);
    ((ajn)localObject1).aOf(((k.b)localObject2).title);
    ((ajn)localObject1).aOl(((k.b)localObject2).url);
    ((ajn)localObject1).wk(true);
    ((ajn)localObject1).wl(true);
    localObject2 = new ajo();
    ((ajo)localObject2).c(aB(parambu));
    if (parambu.cxg()) {
      ((ajo)localObject2).e((ajv)localObject3);
    }
    ((ajn)localObject1).a((ajo)localObject2);
    ((ajn)localObject1).CI(parambu.field_msgId);
    ((ajn)localObject1).aOA(a(((ajo)localObject2).Gis));
    ((ajn)localObject1).aOB(b(((ajo)localObject2).Gis));
    if (am.aSQ(((ajo)localObject2).Gis.GiV))
    {
      parambu = ((ajo)localObject2).Gis.GiV;
      parambu = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(parambu));
      if (!bt.isNullOrNil(parambu)) {
        ((ajn)localObject1).aOJ(parambu);
      }
    }
    paramcv.dnG.dnI.nZa.add(localObject1);
    paramcv = paramcv.dnG.dnJ;
    paramcv.tGM += 1;
    ((ajn)localObject1).ZI(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(9453);
    Object localObject2 = new ajo();
    ((ajo)localObject2).c(aB(parambu));
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
    for (;;)
    {
      localObject1 = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      if (localObject1 != null) {
        break;
      }
      ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(9453);
      return false;
      localajn.ZI(4);
    }
    ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(((s)localObject1).hMP) });
    if (((s)localObject1).hMP > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcv.dnG.dnL = 2131759025;
      AppMethodBeat.o(9453);
      return false;
    }
    if ((parambu.cxh()) && (com.tencent.mm.modelvideo.u.HA(((s)localObject1).getFileName())))
    {
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(9453);
      return false;
    }
    localajn.ZH(((s)localObject1).hHQ);
    localajn.a((ajo)localObject2);
    localajn.aOA(a(((ajo)localObject2).Gis));
    localajn.aOB(b(((ajo)localObject2).Gis));
    if (am.aSQ(((ajo)localObject2).Gis.GiV))
    {
      localObject2 = ((ajo)localObject2).Gis.GiV;
      localObject2 = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject2));
      if (!bt.isNullOrNil((String)localObject2)) {
        localajn.aOJ((String)localObject2);
      }
    }
    localajn.CI(parambu.field_msgId);
    localajn.aON(bl.Bt(parambu.eLs));
    localajn.CG(((s)localObject1).hMP);
    Object localObject1 = bw.M(((s)localObject1).aMV(), "msg");
    if (localObject1 != null)
    {
      localajn.aOj((String)((Map)localObject1).get(".msg.videomsg.$cdnvideourl"));
      localajn.aOk((String)((Map)localObject1).get(".msg.videomsg.$aeskey"));
    }
    for (;;)
    {
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
      AppMethodBeat.o(9453);
      return true;
      ad.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
    }
  }
  
  private static boolean d(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(9457);
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
          if (!m.yt(localv.hDr))
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
                localaks.aPv(m.a(localv));
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
              localajo.d(m.a(localv, localaks, localu.dHo, localu.dHp));
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
      ad.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", parambu, "", new Object[0]);
      ad.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { parambu.getLocalizedMessage() });
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(9457);
      return false;
    }
    paramcv.dnG.dnL = 2131758893;
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