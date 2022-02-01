package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.a.k;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j
{
  private static final SimpleDateFormat BGt;
  
  static
  {
    AppMethodBeat.i(30988);
    BGt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static aml a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    aml localaml = new aml();
    localaml.bgx(aM(paramca));
    localaml.bgm(paramb.ixd);
    localaml.bgn(paramb.ixe);
    localaml.bgl(paramb.url);
    localaml.As(true);
    paramca = new com.tencent.mm.vfs.o(Util.nullAs(q.bcR().R(paramca.field_imgPath, true), ""));
    if (paramca.exists()) {
      localaml.bgu(com.tencent.mm.vfs.aa.z(paramca.her()));
    }
    for (;;)
    {
      localaml.bgf(paramb.title);
      localaml.bgg(paramb.description);
      localaml.ajd(paramInt);
      localaml.bgE(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localaml;
      localaml.At(true);
    }
  }
  
  private static aml a(ca paramca, String paramString, amm paramamm)
  {
    AppMethodBeat.i(30984);
    aml localaml = new aml();
    localaml.bgx(aM(paramca));
    localaml.ajd(1);
    localaml.bgg(paramString);
    localaml.At(true);
    localaml.As(true);
    localaml.a(paramamm);
    localaml.bgA(a(paramamm.LwO));
    localaml.bgB(b(paramamm.LwO));
    if (as.bjp(paramamm.LwO.LxA))
    {
      paramca = paramamm.LwO.LxA;
      paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        localaml.bgJ(paramca);
      }
    }
    AppMethodBeat.o(30984);
    return localaml;
  }
  
  private static String a(amn paramamn)
  {
    AppMethodBeat.i(30973);
    String str2 = paramamn.LxA;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramamn.dRL;
    }
    if (com.tencent.mm.al.a.e.NF(str1))
    {
      paramamn = com.tencent.mm.al.a.e.NH(str1);
      AppMethodBeat.o(30973);
      return paramamn;
    }
    paramamn = com.tencent.mm.model.aa.Ir(str1);
    AppMethodBeat.o(30973);
    return paramamn;
  }
  
  private static void a(ca paramca, amm paramamm, anq paramanq)
  {
    AppMethodBeat.i(30986);
    paramamm.d(m.a(paramca, paramanq));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, cz paramcz, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(232148);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(232148);
      return false;
    }
    localObject1 = k.b.HD((String)localObject1);
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(232148);
      return false;
    }
    localamm.LwO.bgT(((k.b)localObject1).appId);
    localamm.LwO.bgV(((k.b)localObject1).eag);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).NA();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramcz.dFZ.dGe = 2131759217;
      AppMethodBeat.o(232148);
      return false;
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.ajd(1);
      paramContext.bgg(((k.b)localObject1).title);
      paramContext.At(true);
      paramContext.As(true);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyp += 1;
      AppMethodBeat.o(232148);
      return true;
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(232148);
        return false;
      }
      localObject2 = ao.cgO().bdx(((k.b)localObject1).dCK);
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      if (localObject2 != null) {
        paramContext.bgt(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = q.bcR().R(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.s.YS((String)localObject2)) {
        paramContext.bgu((String)localObject2);
      }
      paramContext.ajd(2);
      paramContext.bgf(((k.b)localObject1).title);
      paramContext.bgg(((k.b)localObject1).description);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      paramContext.bgN(br.KB(paramca.fqK));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyq += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 7);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyu += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 29);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      if (((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.bgL(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bgM(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
        paramca = new css();
        paramca.Ktn = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktn;
        paramca.Kto = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Kto;
        paramca.Ktp = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktp;
        paramca.Ktq = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktq;
        paramca.singerName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktr;
        paramca.albumName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Kts;
        paramca.musicGenre = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktt;
        paramca.issueDate = Util.safeParseLong(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktu);
        paramca.identification = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktv;
        paramca.Alz = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Alz;
        paramca.extraInfo = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ktw;
        localamm.e(paramca);
      }
      paramContext.a(localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyu += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 4);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      paramContext.bgN(br.KB(paramca.fqK));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.xiP += 1;
      AppMethodBeat.o(232148);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localamm.LwO.bgU(((k.b)localObject1).url);
        paramContext = a(paramca, (k.b)localObject1, 5);
        paramContext.a(localamm);
        paramContext.bgA(a(localamm.LwO));
        paramContext.bgB(b(localamm.LwO));
        if (as.bjp(localamm.LwO.LxA))
        {
          localObject2 = localamm.LwO.LxA;
          localObject2 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localObject2));
          if (!Util.isNullOrNil((String)localObject2)) {
            paramContext.bgJ((String)localObject2);
          }
        }
        localObject2 = new anq();
        if (!Util.isNullOrNil(((k.b)localObject1).title)) {
          ((anq)localObject2).bhs(((k.b)localObject1).title);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).description)) {
          ((anq)localObject2).bht(((k.b)localObject1).description);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((anq)localObject2).bhv(((k.b)localObject1).thumburl);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((anq)localObject2).bhw(((k.b)localObject1).canvasPageXml);
        }
        if (((anq)localObject2).computeSize() > 0)
        {
          ((anq)localObject2).ajn(1);
          localamm.a((anq)localObject2);
        }
        paramcz.dFZ.dGb.ppH.add(paramContext);
        paramContext = paramcz.dFZ.dGc;
        paramContext.Lys += 1;
        a(paramca, localamm, (anq)localObject2);
        AppMethodBeat.o(232148);
        return true;
      }
      paramcz.dFZ.dGe = 2131759213;
      AppMethodBeat.o(232148);
      return false;
      paramContext = (f)((k.b)localObject1).as(f.class);
      if (paramContext != null)
      {
        paramContext = paramContext.jlg;
        localObject1 = new aml();
        ((aml)localObject1).bgA(a(localamm.LwO));
        ((aml)localObject1).bgB(b(localamm.LwO));
        ((aml)localObject1).bgx(aM(paramca));
        ((aml)localObject1).As(true);
        ((aml)localObject1).bgf(paramContext.nickname + MMApplicationContext.getContext().getString(2131759333));
        ((aml)localObject1).bgg(paramContext.desc);
        ((aml)localObject1).ajd(22);
        localamm.c(paramContext);
        ((aml)localObject1).a(localamm);
        paramcz.dFZ.dGb.ppH.add(localObject1);
        AppMethodBeat.o(232148);
        return true;
      }
      AppMethodBeat.o(232148);
      return false;
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(232148);
        return false;
      }
      localObject2 = ao.cgO().bdx(((k.b)localObject1).dCK);
      paramContext = new aml();
      if (localObject2 != null) {
        paramContext.bgt(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.bgx(aM(paramca));
      paramContext.ajd(8);
      paramContext.bgp(((k.b)localObject1).iwJ);
      localObject2 = q.bcR().R(paramca.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.At(true);
      }
      if (com.tencent.mm.vfs.s.YS((String)localObject2)) {
        paramContext.bgu((String)localObject2);
      }
      paramContext.bgf(((k.b)localObject1).title);
      paramContext.bgg(((k.b)localObject1).description);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.fileCount += 1;
      AppMethodBeat.o(232148);
      return true;
      if ((((k.b)localObject1).dCK == null) || (((k.b)localObject1).dCK.length() == 0)) {
        paramcz.dFZ.dGe = 2131759210;
      }
      do
      {
        paramcz.dFZ.dGe = 2131759217;
        AppMethodBeat.o(232148);
        return false;
        bg.aVF();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramcz.dFZ.dGe = 2131759225;
      AppMethodBeat.o(232148);
      return false;
      paramContext = new ana();
      paramContext.bgY(((k.b)localObject1).title);
      paramContext.bgZ(((k.b)localObject1).description);
      paramContext.ajj(((k.b)localObject1).ixg);
      paramContext.bhb(((k.b)localObject1).ixh);
      paramContext.bha(((k.b)localObject1).thumburl);
      localamm.a(paramContext);
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.ajd(10);
      paramContext.At(true);
      paramContext.As(true);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyw += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = new ank();
      paramContext.bho(((k.b)localObject1).title);
      paramContext.bhp(((k.b)localObject1).description);
      paramContext.bhr(((k.b)localObject1).ixk);
      paramContext.bhq(((k.b)localObject1).thumburl);
      localamm.a(paramContext);
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.ajd(14);
      paramContext.At(true);
      paramContext.As(true);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.LyA += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = new ana();
      paramContext.bgY(((k.b)localObject1).title);
      paramContext.bgZ(((k.b)localObject1).description);
      paramContext.ajj(((k.b)localObject1).ixm);
      paramContext.bhb(((k.b)localObject1).ixn);
      paramContext.bha(((k.b)localObject1).thumburl);
      localamm.a(paramContext);
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.ajd(11);
      paramContext.At(true);
      paramContext.As(true);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyx += 1;
      AppMethodBeat.o(232148);
      return true;
      paramContext = a(paramca, paramContext.getString(2131755919), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(232148);
      return true;
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.bgf(((k.b)localObject1).title);
      paramContext.bgg(((k.b)localObject1).description);
      paramContext.ajd(19);
      localObject2 = q.bcR().R(paramca.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.At(true);
      }
      if (com.tencent.mm.vfs.s.YS((String)localObject2)) {
        paramContext.bgu((String)localObject2);
      }
      localObject2 = new amj();
      if (!Util.isNullOrNil(((k.b)localObject1).izi)) {
        ((amj)localObject2).username = ((k.b)localObject1).izi;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).izj)) {
        ((amj)localObject2).appId = ((k.b)localObject1).izj;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).izB)) {
        ((amj)localObject2).iconUrl = ((k.b)localObject1).izB;
      }
      ((amj)localObject2).lyE = ((k.b)localObject1).izr;
      ((amj)localObject2).type = ((k.b)localObject1).izk;
      ((amj)localObject2).dMe = ((k.b)localObject1).izm;
      ((amj)localObject2).dCx = ((k.b)localObject1).izh;
      ((amj)localObject2).Lve = ((k.b)localObject1).eah;
      localamm.b((amj)localObject2);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(232148);
      return true;
      paramContext = a(paramca, paramContext.getString(2131755867) + ((k.b)localObject1).title, localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(232148);
      return true;
      paramContext = ((k.b)localObject1).w(paramContext, true);
      if (Util.isNullOrNil(paramContext))
      {
        paramcz.dFZ.dGe = 2131759217;
        AppMethodBeat.o(232148);
        return false;
      }
      paramContext = a(paramca, paramContext + ((k.b)localObject1).title, localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(232148);
      return true;
      if ((((k.b)localObject1).ixl != null) && (((k.b)localObject1).ixl.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new aml();
        ((aml)localObject2).bgx(aM(paramca));
        ((aml)localObject2).ajd(17);
        ((aml)localObject2).At(true);
        ((aml)localObject2).bgf(((k.b)localObject1).title);
        ((aml)localObject2).bgF(((k.b)localObject1).ixl);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new rc();
        ((rc)localObject3).dXF.type = 0;
        ((rc)localObject3).dXF.dXH = ((k.b)localObject1).ixl;
        EventCenter.instance.publish((IEvent)localObject3);
        localObject1 = ((rc)localObject3).dXG.dXP;
        if (localObject1 == null) {
          break label3761;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).iAd.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (Util.isNullOrNil(((aml)((Iterator)localObject3).next()).LwF));
        paramcz.dFZ.dGe = 2131759217;
        AppMethodBeat.o(232148);
        return false;
      }
    }
    label3761:
    if (localObject1 != null) {
      paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
    }
    for (;;)
    {
      ((aml)localObject2).bgg(paramContext);
      ((aml)localObject2).a(localamm);
      ((aml)localObject2).bgA(a(localamm.LwO));
      ((aml)localObject2).bgB(b(localamm.LwO));
      ((aml)localObject2).Mw(paramca.field_msgId);
      if (as.bjp(localamm.LwO.LxA))
      {
        paramContext = localamm.LwO.LxA;
        paramContext = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((aml)localObject2).bgJ(paramContext);
        }
      }
      paramcz.dFZ.dGb.ppH.add(localObject2);
      AppMethodBeat.o(232148);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, cz paramcz, String paramString, List<ca> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ca)((Iterator)localObject1).next();
      if (br.B((ca)localObject2)) {
        switch (((ca)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((ca)localObject2).setContent(paramContext.getString(2131755996));
          break;
        case 3: 
          ((ca)localObject2).setContent(paramContext.getString(2131755939));
          ((ca)localObject2).setType(1);
          break;
        case 43: 
          ((ca)localObject2).setContent(paramContext.getString(2131756018));
          ((ca)localObject2).setType(1);
          break;
        case 49: 
          ((ca)localObject2).setContent(paramContext.getString(2131756006));
          ((ca)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.al.g.DQ(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (ca)paramList.get(0);
      if (paramList.gAt())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.ag.u)localObject1).iAd != null) && (((com.tencent.mm.ag.u)localObject1).iAd.size() == 1))
        {
          paramBoolean = h.d(paramcz, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramcz.dFZ.dGb = new anb();
        paramcz.dFZ.dGc = new anp();
        paramcz.dFZ.dGb.a(bdp(paramString));
        paramcz.dFZ.type = 14;
        paramBoolean = b(paramContext, paramcz, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = h.d(paramcz, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramcz.dFZ.dGb = new anb();
    paramcz.dFZ.dGc = new anp();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.al.a.e.At(((ca)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.NG((String)localObject1))
      {
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131764266));
        Log.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramcz.dFZ.dGb.title });
      }
    }
    else
    {
      paramcz.dFZ.dGb.a(bdp(paramString));
      paramcz.dFZ.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramcz, (ca)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.al.a.e.NJ(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131759287, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.al.a.e.NH((String)localObject1) }));
        break;
        label633:
        if (ab.Eq(paramString))
        {
          paramcz.dFZ.dGb.bhd(paramContext.getString(2131764266));
          break;
        }
        localObject1 = Util.nullAsNil(z.aUa());
        if (((String)localObject1).equals(Util.nullAsNil(com.tencent.mm.model.aa.Ir(paramString))))
        {
          paramcz.dFZ.dGb.bhd(paramContext.getString(2131759288, new Object[] { localObject1 }));
          break;
        }
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131759287, new Object[] { z.aUa(), com.tencent.mm.model.aa.Ir(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramcz.dFZ.dGe > 0)) {
      paramcz.dFZ.dGe = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30978);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    Object localObject = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (localObject != null) {
      try
      {
        ams localams = new ams();
        localams.bgW((String)((Map)localObject).get(".msg.location.$label"));
        localams.C(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localams.B(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localams.aji(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localams.bgX((String)((Map)localObject).get(".msg.location.$poiname"));
        localamm.c(localams);
        localObject = new aml();
        ((aml)localObject).bgx(aM(paramca));
        ((aml)localObject).ajd(6);
        ((aml)localObject).At(true);
        ((aml)localObject).As(true);
        ((aml)localObject).a(localamm);
        ((aml)localObject).bgA(a(localamm.LwO));
        ((aml)localObject).bgB(b(localamm.LwO));
        if (as.bjp(localamm.LwO.LxA))
        {
          paramca = localamm.LwO.LxA;
          paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
          if (!Util.isNullOrNil(paramca)) {
            ((aml)localObject).bgJ(paramca);
          }
        }
        paramcz.dFZ.dGb.ppH.add(localObject);
        paramca = paramcz.dFZ.dGc;
        paramca.Lyt += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramcz.dFZ.dGe = 2131759219;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static boolean a(cz paramcz, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(232145);
    Object localObject1 = null;
    if (paramca.field_msgId > 0L) {
      localObject1 = q.bcR().H(paramca.field_talker, (int)paramca.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramca.field_msgSvrId > 0L) {
        localObject2 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramcz.dFZ.dGe = 2131759215;
      AppMethodBeat.o(232145);
      return false;
    }
    amm localamm = new amm();
    localamm.c(aL(paramca));
    localObject1 = new aml();
    ((aml)localObject1).bgx(aM(paramca));
    ((aml)localObject1).ajd(2);
    ((aml)localObject1).bgt(q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", ""));
    if (((com.tencent.mm.av.g)localObject2).bcv())
    {
      localObject2 = q.bcR().tl(((com.tencent.mm.av.g)localObject2).iXx);
      if (((com.tencent.mm.av.g)localObject2).iKP > ((com.tencent.mm.av.g)localObject2).offset) {
        ((aml)localObject1).bgt(q.bcR().o("SERVERID://" + paramca.field_msgSvrId, "", ""));
      }
    }
    ((aml)localObject1).bgu(q.bcR().R(paramca.field_imgPath, true));
    ((aml)localObject1).a(localamm);
    ((aml)localObject1).bgA(a(localamm.LwO));
    ((aml)localObject1).bgB(b(localamm.LwO));
    ((aml)localObject1).Mw(paramca.field_msgId);
    ((aml)localObject1).bgN(br.KB(paramca.fqK));
    if (as.bjp(localamm.LwO.LxA))
    {
      paramca = localamm.LwO.LxA;
      paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        ((aml)localObject1).bgJ(paramca);
      }
    }
    paramcz.dFZ.dGb.ppH.add(localObject1);
    paramcz = paramcz.dFZ.dGc;
    paramcz.Lyq += 1;
    AppMethodBeat.o(232145);
    return true;
  }
  
  private static amn aL(ca paramca)
  {
    AppMethodBeat.i(30972);
    amn localamn = new amn();
    if (paramca == null)
    {
      AppMethodBeat.o(30972);
      return localamn;
    }
    Object localObject;
    if (paramca.field_isSend == 0)
    {
      localamn.bgO(paramca.field_talker);
      localamn.bgP(z.aTY());
      if (ab.Eq(paramca.field_talker))
      {
        if (paramca.field_content == null) {
          break label367;
        }
        localObject = paramca.field_content.substring(0, Math.max(0, paramca.field_content.indexOf(':')));
        localamn.bgR((String)localObject);
        if ((!Util.isNullOrNil(localamn.LxA)) && (!paramca.gAy()))
        {
          paramca.setContent(paramca.field_content.substring(localamn.LxA.length() + 1));
          if ((paramca.field_content.length() > 0) && ('\n' == paramca.field_content.charAt(0))) {
            paramca.setContent(paramca.field_content.substring(1));
          }
          if (paramca.gDz())
          {
            if ((!Util.isNullOrNil(paramca.field_transContent)) && (paramca.field_transContent.startsWith(localamn.LxA))) {
              paramca.CB(paramca.field_transContent.substring(localamn.LxA.length() + 1));
            }
            if ((paramca.field_transContent.length() > 0) && ('\n' == paramca.field_transContent.charAt(0))) {
              paramca.CB(paramca.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.al.g.DQ(paramca.field_talker))
      {
        String str = paramca.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bp.Ky(paramca.fqK).userId;
        }
        localamn.bgR((String)localObject);
      }
      localamn.ajh(1);
      localamn.Mx(paramca.field_createTime);
      localamn.bgS(paramca.field_msgSvrId);
      if (paramca.field_msgSvrId > 0L) {
        localamn.bgQ(paramca.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localamn;
      label367:
      localObject = "";
      break;
      localamn.bgO(z.aTY());
      localamn.bgP(paramca.field_talker);
      if (ab.Eq(paramca.field_talker)) {
        localamn.bgR(localamn.dRL);
      }
    }
  }
  
  private static String aM(ca paramca)
  {
    AppMethodBeat.i(30975);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Eq(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
      {
        paramca = String.format("%d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return paramca;
      }
      paramca = String.format("%s#%d", new Object[] { paramca.field_talker, Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return paramca;
    }
    long l = paramca.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String b(amn paramamn)
  {
    AppMethodBeat.i(30974);
    paramamn = BGt.format(new Date(paramamn.createTime));
    AppMethodBeat.o(30974);
    return paramamn;
  }
  
  private static boolean b(Context paramContext, cz paramcz, ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramcz == null) || (paramca == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    paramca = ca.aZ(paramca);
    if (paramca.isText()) {
      bool = e(paramcz, paramca);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(paramca, paramcz, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (paramca.gAy()) {
        bool = b(paramcz, paramca, false);
      } else if (paramca.dOS()) {
        bool = a(paramcz, paramca);
      } else if (paramca.gAz()) {
        bool = a(paramcz, paramca, false);
      } else if (paramca.cWJ()) {
        bool = c(paramcz, paramca, false);
      } else if (paramca.cWL()) {
        bool = c(paramcz, paramca, false);
      } else if (paramca.cWK()) {
        bool = com.tencent.mm.plugin.record.b.c.b(paramcz, paramca);
      } else if (paramca.gAt()) {
        bool = c(paramcz, paramca);
      } else if (paramca.gDl()) {
        bool = c(paramContext, paramcz, paramca);
      } else if ((paramca.dOQ()) && (!paramca.gDo())) {
        bool = a(paramContext, paramcz, paramca, false);
      } else {
        paramcz.dFZ.dGe = 2131759217;
      }
    }
  }
  
  private static boolean b(cz paramcz, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(232146);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    aml localaml = new aml();
    localaml.bgx(aM(paramca));
    localaml.ajd(3);
    if (ab.Jp(paramca.field_talker)) {
      localaml.bgt(bdo(paramca.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localaml.At(true);
      localb = com.tencent.mm.modelvoice.s.Rf(paramca.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(232146);
      return false;
      localaml.bgt(com.tencent.mm.modelvoice.s.getFullPath(paramca.field_imgPath));
    }
    localaml.bgp(h.ahD(localb.getFormat()));
    localaml.ajc((int)new p(paramca.field_content).time);
    localaml.a(localamm);
    localaml.bgA(a(localamm.LwO));
    localaml.bgB(b(localamm.LwO));
    if (as.bjp(localamm.LwO.LxA))
    {
      paramca = localamm.LwO.LxA;
      paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        localaml.bgJ(paramca);
      }
    }
    paramcz.dFZ.dGb.ppH.add(localaml);
    paramcz = paramcz.dFZ.dGc;
    paramcz.Lyr += 1;
    AppMethodBeat.o(232146);
    return true;
  }
  
  private static String bdo(String paramString)
  {
    AppMethodBeat.i(30980);
    bg.aVF();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.aTb(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30980);
      return null;
    }
    if (new com.tencent.mm.vfs.o(paramString).exists())
    {
      AppMethodBeat.o(30980);
      return paramString;
    }
    AppMethodBeat.o(30980);
    return paramString;
  }
  
  private static anh bdp(String paramString)
  {
    AppMethodBeat.i(30971);
    anh localanh = new anh();
    localanh.bhf(paramString);
    localanh.ajm(1);
    localanh.MA(Util.nowMilliSecond());
    localanh.bhh("");
    AppMethodBeat.o(30971);
    return localanh;
  }
  
  private static boolean c(Context paramContext, cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30982);
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    if ((localObject != null) && (ab.rR(((ca.a)localObject).IOs)))
    {
      paramContext = new aml();
      paramContext.bgx(aM(paramca));
      paramContext.ajd(16);
      paramContext.bgg(paramca.field_content);
      paramContext.At(true);
      paramContext.As(true);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (!as.bjp(localamm.LwO.LxA)) {
        break label337;
      }
      paramca = localamm.LwO.LxA;
      paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        paramContext.bgJ(paramca);
      }
    }
    label337:
    for (;;)
    {
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.LyB += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (as.bjp(((ca.a)localObject).dkU)))
      {
        localObject = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(((ca.a)localObject).OqO, "openim_card_type_name", a.a.jGS);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(2131755864);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(paramca, paramContext, localamm);
          break;
        }
      }
      paramContext = a(paramca, paramContext.getString(2131755864), localamm);
    }
  }
  
  private static boolean c(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30987);
    try
    {
      com.tencent.mm.ag.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
      Object localObject1 = localu.iAd;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          v localv = (v)((Iterator)localObject1).next();
          if (!m.HF(localv.iAt))
          {
            amm localamm = new amm();
            localamm.c(aL(paramca));
            localamm.LwO.bgV(localu.eag);
            localamm.LwO.bgU(localv.url);
            Object localObject2 = new aml();
            ((aml)localObject2).bgf(localv.title);
            ((aml)localObject2).bgg(localv.iAq);
            ((aml)localObject2).bgx(aM(paramca));
            if (!Util.isNullOrNil(localv.iAo)) {
              ((aml)localObject2).bgu(s.bdu(localv.iAo));
            }
            for (;;)
            {
              ((aml)localObject2).As(true);
              anq localanq = new anq();
              if (!Util.isNullOrNil(localv.title)) {
                localanq.bhs(localv.title);
              }
              if (!Util.isNullOrNil(localv.iAq)) {
                localanq.bht(localv.iAq);
              }
              if (!Util.isNullOrNil(localv.iAo)) {
                localanq.bhv(m.a(localv));
              }
              if (localanq.computeSize() > 0)
              {
                localanq.ajn(1);
                localamm.a(localanq);
              }
              ((aml)localObject2).ajd(5);
              ((aml)localObject2).a(localamm);
              ((aml)localObject2).bgA(a(localamm.LwO));
              ((aml)localObject2).bgB(b(localamm.LwO));
              if (as.bjp(localamm.LwO.LxA))
              {
                String str = localamm.LwO.LxA;
                str = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(str));
                if (!Util.isNullOrNil(str)) {
                  ((aml)localObject2).bgJ(str);
                }
              }
              paramcz.dFZ.dGb.ppH.add(localObject2);
              localObject2 = paramcz.dFZ.dGc;
              ((anp)localObject2).Lys += 1;
              localamm.d(m.a(localv, localanq, localu.eag, localu.eah));
              i += 1;
              break;
              ((aml)localObject2).At(true);
            }
          }
        }
      }
      if (i != 0) {
        break label557;
      }
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.GetFavRecordDataSource", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(30987);
      return false;
    }
    paramcz.dFZ.dGe = 2131759217;
    AppMethodBeat.o(30987);
    return false;
    label557:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean c(cz paramcz, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(232147);
    Object localObject = new amm();
    ((amm)localObject).c(aL(paramca));
    aml localaml = new aml();
    localaml.bgx(aM(paramca));
    com.tencent.mm.modelvideo.o.bhj();
    localaml.bgt(t.Qw(paramca.field_imgPath));
    com.tencent.mm.modelvideo.o.bhj();
    localaml.bgu(t.Qx(paramca.field_imgPath));
    localaml.bgp(com.tencent.mm.vfs.s.akC(localaml.LvL));
    if (paramca.cWL()) {
      localaml.ajd(15);
    }
    com.tencent.mm.modelvideo.s locals;
    for (;;)
    {
      locals = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
      if (locals != null) {
        break;
      }
      Log.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramcz.dFZ.dGe = 2131759208;
      AppMethodBeat.o(232147);
      return false;
      localaml.ajd(4);
    }
    Log.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(locals.iKP) });
    if (locals.iKP > ((af)com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(false))
    {
      paramcz.dFZ.dGe = 2131759350;
      AppMethodBeat.o(232147);
      return false;
    }
    if ((paramca.cWL()) && (com.tencent.mm.modelvideo.u.QO(locals.getFileName())))
    {
      paramcz.dFZ.dGe = 2131759208;
      AppMethodBeat.o(232147);
      return false;
    }
    localaml.ajc(locals.iFw);
    localaml.a((amm)localObject);
    localaml.bgA(a(((amm)localObject).LwO));
    localaml.bgB(b(((amm)localObject).LwO));
    if (as.bjp(((amm)localObject).LwO.LxA))
    {
      localObject = ((amm)localObject).LwO.LxA;
      localObject = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localObject));
      if (!Util.isNullOrNil((String)localObject)) {
        localaml.bgJ((String)localObject);
      }
    }
    localaml.Mw(paramca.field_msgId);
    localaml.bgN(br.KB(paramca.fqK));
    localaml.Mu(locals.iKP);
    paramcz.dFZ.dGb.ppH.add(localaml);
    paramcz = paramcz.dFZ.dGc;
    paramcz.xiP += 1;
    paramcz = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    localaml.bgD(paramcz.ean);
    paramcz = paramcz.jsw;
    if ((paramcz != null) && (!Util.isNullOrNil(paramcz.izf)))
    {
      paramca = new amo();
      paramca.iyZ = paramcz.iyZ;
      paramca.LxJ = paramcz.LxJ;
      paramca.izc = paramcz.izc;
      paramca.izd = paramcz.izd;
      paramca.izb = paramcz.izb;
      paramca.ize = paramcz.ize;
      paramca.izf = paramcz.izf;
      paramca.izg = paramcz.izg;
      localaml.a(paramca);
    }
    AppMethodBeat.o(232147);
    return true;
  }
  
  private static boolean e(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30976);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    aml localaml = new aml();
    localaml.bgx(aM(paramca));
    localaml.ajd(1);
    if (paramca.gDV()) {}
    for (String str = MMApplicationContext.getContext().getString(2131764740, new Object[] { "@" }) + '\n';; str = "")
    {
      localaml.bgg(str + paramca.field_content);
      localaml.At(true);
      localaml.As(true);
      localaml.a(localamm);
      localaml.bgA(a(localamm.LwO));
      localaml.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          localaml.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(localaml);
      paramcz = paramcz.dFZ.dGc;
      paramcz.Lyp += 1;
      AppMethodBeat.o(30976);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j
 * JD-Core Version:    0.7.0.1
 */