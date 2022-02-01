package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.eor;
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

public final class l
{
  private static final SimpleDateFormat HCy;
  
  static
  {
    AppMethodBeat.i(30988);
    HCy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static anm a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    anm localanm = new anm();
    localanm.bsP(aY(paramca));
    localanm.bsE(paramb.lms);
    localanm.bsF(paramb.lmt);
    localanm.bsD(paramb.url);
    localanm.Ex(true);
    paramca = new com.tencent.mm.vfs.q(Util.nullAs(com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true), ""));
    if (paramca.ifE()) {
      localanm.bsM(paramca.bOF());
    }
    for (;;)
    {
      localanm.bsx(paramb.title);
      localanm.bsy(paramb.description);
      localanm.arq(paramInt);
      localanm.bsW(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localanm;
      localanm.Ey(true);
    }
  }
  
  private static anm a(ca paramca, String paramString, ann paramann)
  {
    AppMethodBeat.i(30984);
    anm localanm = new anm();
    localanm.bsP(aY(paramca));
    localanm.arq(1);
    localanm.bsy(paramString);
    localanm.Ey(true);
    localanm.Ex(true);
    localanm.a(paramann);
    localanm.bsS(a(paramann.Szn));
    localanm.bsT(b(paramann.Szn));
    if (as.bvK(paramann.Szn.SAb))
    {
      paramca = paramann.Szn.SAb;
      paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
      if (!Util.isNullOrNil(paramca)) {
        localanm.btb(paramca);
      }
    }
    AppMethodBeat.o(30984);
    return localanm;
  }
  
  private static String a(ano paramano)
  {
    AppMethodBeat.i(30973);
    String str2 = paramano.SAb;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramano.fLi;
    }
    if (com.tencent.mm.ao.a.e.Vb(str1))
    {
      paramano = com.tencent.mm.ao.a.e.Vd(str1);
      AppMethodBeat.o(30973);
      return paramano;
    }
    paramano = aa.PI(str1);
    AppMethodBeat.o(30973);
    return paramano;
  }
  
  private static void a(ca paramca, ann paramann, aor paramaor)
  {
    AppMethodBeat.i(30986);
    paramann.d(m.a(paramca, paramaor));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, dd paramdd, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(275056);
    ann localann = new ann();
    localann.c(aX(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(275056);
      return false;
    }
    localObject1 = k.b.OQ((String)localObject1);
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(275056);
      return false;
    }
    localann.Szn.btl(((k.b)localObject1).appId);
    localann.Szn.btn(((k.b)localObject1).fUd);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).Qv();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
      AppMethodBeat.o(275056);
      return false;
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.arq(1);
      paramContext.bsy(((k.b)localObject1).title);
      paramContext.Ey(true);
      paramContext.Ex(true);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAQ += 1;
      AppMethodBeat.o(275056);
      return true;
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(275056);
        return false;
      }
      localObject2 = ao.ctZ().bpR(((k.b)localObject1).fvr);
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      if (localObject2 != null) {
        paramContext.bsL(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.u.agG((String)localObject2)) {
        paramContext.bsM((String)localObject2);
      }
      paramContext.arq(2);
      paramContext.bsx(((k.b)localObject1).title);
      paramContext.bsy(((k.b)localObject1).description);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      paramContext.Ua(paramca.field_msgId);
      paramContext.btf(bs.RU(paramca.hxy));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.JCD += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 7);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAU += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 29);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      if (((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.btd(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bte(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
        paramca = new dbr();
        paramca.Ruu = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ruu;
        paramca.Ruv = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ruv;
        paramca.Ruw = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ruw;
        paramca.Rux = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Rux;
        paramca.singerName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ruy;
        paramca.albumName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).Ruz;
        paramca.musicGenre = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).RuA;
        paramca.issueDate = Util.safeParseLong(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).RuB);
        paramca.identification = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).RuC;
        paramca.FSG = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).FSG;
        paramca.extraInfo = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).RuD;
        localann.e(paramca);
      }
      paramContext.a(localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAU += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = a(paramca, (k.b)localObject1, 4);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      paramContext.Ua(paramca.field_msgId);
      paramContext.btf(bs.RU(paramca.hxy));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.xzT += 1;
      AppMethodBeat.o(275056);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localann.Szn.btm(((k.b)localObject1).url);
        paramContext = a(paramca, (k.b)localObject1, 5);
        paramContext.a(localann);
        paramContext.bsS(a(localann.Szn));
        paramContext.bsT(b(localann.Szn));
        if (as.bvK(localann.Szn.SAb))
        {
          localObject2 = localann.Szn.SAb;
          localObject2 = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject2));
          if (!Util.isNullOrNil((String)localObject2)) {
            paramContext.btb((String)localObject2);
          }
        }
        localObject2 = new aor();
        if (!Util.isNullOrNil(((k.b)localObject1).title)) {
          ((aor)localObject2).btK(((k.b)localObject1).title);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).description)) {
          ((aor)localObject2).btL(((k.b)localObject1).description);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((aor)localObject2).btN(((k.b)localObject1).thumburl);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((aor)localObject2).btO(((k.b)localObject1).canvasPageXml);
        }
        ((aor)localObject2).arC(((k.b)localObject1).loY);
        if (((aor)localObject2).computeSize() > 0)
        {
          ((aor)localObject2).arA(1);
          localann.b((aor)localObject2);
        }
        paramdd.fyI.fyK.syG.add(paramContext);
        paramContext = paramdd.fyI.fyL;
        paramContext.SAS += 1;
        a(paramca, localann, (aor)localObject2);
        AppMethodBeat.o(275056);
        return true;
      }
      paramdd.fyI.fyO = R.l.favorite_fail_empty_url;
      AppMethodBeat.o(275056);
      return false;
      paramContext = (f)((k.b)localObject1).ar(f.class);
      if (paramContext != null)
      {
        paramContext = paramContext.mbi;
        localObject1 = new anm();
        ((anm)localObject1).bsS(a(localann.Szn));
        ((anm)localObject1).bsT(b(localann.Szn));
        ((anm)localObject1).bsP(aY(paramca));
        ((anm)localObject1).Ex(true);
        ((anm)localObject1).bsx(paramContext.nickname + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail));
        ((anm)localObject1).bsy(paramContext.desc);
        ((anm)localObject1).arq(22);
        localann.c(paramContext);
        ((anm)localObject1).a(localann);
        paramdd.fyI.fyK.syG.add(localObject1);
        AppMethodBeat.o(275056);
        return true;
      }
      AppMethodBeat.o(275056);
      return false;
      paramdd.fyI.fyO = R.l.eEL;
      AppMethodBeat.o(275056);
      return false;
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(275056);
        return false;
      }
      localObject2 = ao.ctZ().bpR(((k.b)localObject1).fvr);
      paramContext = new anm();
      if (localObject2 != null) {
        paramContext.bsL(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.bsP(aY(paramca));
      paramContext.arq(8);
      paramContext.bsH(((k.b)localObject1).llY);
      localObject2 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.Ey(true);
      }
      if (com.tencent.mm.vfs.u.agG((String)localObject2)) {
        paramContext.bsM((String)localObject2);
      }
      paramContext.bsx(((k.b)localObject1).title);
      paramContext.bsy(((k.b)localObject1).description);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      paramContext.Ua(paramca.field_msgId);
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.fileCount += 1;
      AppMethodBeat.o(275056);
      return true;
      if ((((k.b)localObject1).fvr == null) || (((k.b)localObject1).fvr.length() == 0)) {
        paramdd.fyI.fyO = R.l.favorite_fail_attachment_not_exists;
      }
      do
      {
        paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(275056);
        return false;
        bh.beI();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(275056);
      return false;
      paramContext = new aob();
      paramContext.btq(((k.b)localObject1).title);
      paramContext.btr(((k.b)localObject1).description);
      paramContext.arw(((k.b)localObject1).lmv);
      paramContext.btt(((k.b)localObject1).lmw);
      paramContext.bts(((k.b)localObject1).thumburl);
      localann.a(paramContext);
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.arq(10);
      paramContext.Ey(true);
      paramContext.Ex(true);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAW += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = new aol();
      paramContext.btG(((k.b)localObject1).title);
      paramContext.btH(((k.b)localObject1).description);
      paramContext.btJ(((k.b)localObject1).lmz);
      paramContext.btI(((k.b)localObject1).thumburl);
      localann.a(paramContext);
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.arq(14);
      paramContext.Ey(true);
      paramContext.Ex(true);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SBa += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = new aob();
      paramContext.btq(((k.b)localObject1).title);
      paramContext.btr(((k.b)localObject1).description);
      paramContext.arw(((k.b)localObject1).lmB);
      paramContext.btt(((k.b)localObject1).lmC);
      paramContext.bts(((k.b)localObject1).thumburl);
      localann.a(paramContext);
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.arq(11);
      paramContext.Ey(true);
      paramContext.Ex(true);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAX += 1;
      AppMethodBeat.o(275056);
      return true;
      paramContext = a(paramca, paramContext.getString(R.l.app_not_show), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(275056);
      return true;
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.bsx(((k.b)localObject1).title);
      paramContext.bsy(((k.b)localObject1).description);
      paramContext.arq(19);
      localObject2 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.Ey(true);
      }
      if (com.tencent.mm.vfs.u.agG((String)localObject2)) {
        paramContext.bsM((String)localObject2);
      }
      localObject2 = new ank();
      if (!Util.isNullOrNil(((k.b)localObject1).loA)) {
        ((ank)localObject2).username = ((k.b)localObject1).loA;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).loB)) {
        ((ank)localObject2).appId = ((k.b)localObject1).loB;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).loV)) {
        ((ank)localObject2).iconUrl = ((k.b)localObject1).loV;
      }
      ((ank)localObject2).otE = ((k.b)localObject1).loJ;
      ((ank)localObject2).type = ((k.b)localObject1).loC;
      ((ank)localObject2).fES = ((k.b)localObject1).loE;
      ((ank)localObject2).fve = ((k.b)localObject1).loz;
      ((ank)localObject2).SxE = ((k.b)localObject1).fUe;
      localann.b((ank)localObject2);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      paramContext.Ua(paramca.field_msgId);
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(275056);
      return true;
      paramContext = a(paramca, paramContext.getString(R.l.app_game_recording) + ((k.b)localObject1).title, localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(275056);
      return true;
      paramContext = ((k.b)localObject1).z(paramContext, true);
      if (Util.isNullOrNil(paramContext))
      {
        paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(275056);
        return false;
      }
      paramContext = a(paramca, paramContext + ((k.b)localObject1).title, localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(275056);
      return true;
      if ((((k.b)localObject1).lmA != null) && (((k.b)localObject1).lmA.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new anm();
        ((anm)localObject2).bsP(aY(paramca));
        ((anm)localObject2).arq(17);
        ((anm)localObject2).Ey(true);
        ((anm)localObject2).bsx(((k.b)localObject1).title);
        ((anm)localObject2).bsX(((k.b)localObject1).lmA);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new sc();
        ((sc)localObject3).fRw.type = 0;
        ((sc)localObject3).fRw.fRy = ((k.b)localObject1).lmA;
        EventCenter.instance.publish((IEvent)localObject3);
        localObject1 = ((sc)localObject3).fRx.fRG;
        if (localObject1 == null) {
          break label3801;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).lpz.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (Util.isNullOrNil(((anm)((Iterator)localObject3).next()).Sze));
        paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(275056);
        return false;
      }
    }
    label3801:
    if (localObject1 != null) {
      paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
    }
    for (;;)
    {
      ((anm)localObject2).bsy(paramContext);
      ((anm)localObject2).a(localann);
      ((anm)localObject2).bsS(a(localann.Szn));
      ((anm)localObject2).bsT(b(localann.Szn));
      ((anm)localObject2).Ua(paramca.field_msgId);
      if (as.bvK(localann.Szn.SAb))
      {
        paramContext = localann.Szn.SAb;
        paramContext = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((anm)localObject2).btb(paramContext);
        }
      }
      paramdd.fyI.fyK.syG.add(localObject2);
      AppMethodBeat.o(275056);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, dd paramdd, String paramString, List<ca> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ca)((Iterator)localObject1).next();
      if (bs.D((ca)localObject2)) {
        switch (((ca)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((ca)localObject2).setContent(paramContext.getString(R.l.app_text));
          break;
        case 3: 
          ((ca)localObject2).setContent(paramContext.getString(R.l.app_pic));
          ((ca)localObject2).setType(1);
          break;
        case 43: 
          ((ca)localObject2).setContent(paramContext.getString(R.l.app_video));
          ((ca)localObject2).setType(1);
          break;
        case 49: 
          ((ca)localObject2).setContent(paramContext.getString(R.l.app_unknown_msg));
          ((ca)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.ao.g.KI(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (ca)paramList.get(0);
      if (paramList.hwA())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.aj.u)localObject1).lpz != null) && (((com.tencent.mm.aj.u)localObject1).lpz.size() == 1))
        {
          paramBoolean = j.d(paramdd, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramdd.fyI.fyK = new aoc();
        paramdd.fyI.fyL = new aoq();
        paramdd.fyI.fyK.a(bpF(paramString));
        paramdd.fyI.type = 14;
        paramBoolean = b(paramContext, paramdd, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = j.d(paramdd, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramdd.fyI.fyK = new aoc();
    paramdd.fyI.fyL = new aoq();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.ao.a.e.GB(((ca)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.ao.a.e.Vc((String)localObject1))
      {
        paramdd.fyI.fyK.btv(paramContext.getString(R.l.record_chatroom_title));
        Log.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramdd.fyI.fyK.title });
      }
    }
    else
    {
      paramdd.fyI.fyK.a(bpF(paramString));
      paramdd.fyI.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramdd, (ca)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.ao.a.e.Vf(paramString);
        if (localObject2 == null) {
          break;
        }
        paramdd.fyI.fyK.btv(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.ao.a.e.Vd((String)localObject1) }));
        break;
        label633:
        if (ab.Lj(paramString))
        {
          paramdd.fyI.fyK.btv(paramContext.getString(R.l.record_chatroom_title));
          break;
        }
        localObject1 = Util.nullAsNil(z.bdb());
        if (((String)localObject1).equals(Util.nullAsNil(aa.PI(paramString))))
        {
          paramdd.fyI.fyK.btv(paramContext.getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 }));
          break;
        }
        paramdd.fyI.fyK.btv(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { z.bdb(), aa.PI(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramdd.fyI.fyO > 0)) {
      paramdd.fyI.fyO = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30978);
    ann localann = new ann();
    localann.c(aX(paramca));
    Object localObject = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (localObject != null) {
      try
      {
        ant localant = new ant();
        localant.bto((String)((Map)localObject).get(".msg.location.$label"));
        localant.E(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localant.D(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localant.arv(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localant.btp((String)((Map)localObject).get(".msg.location.$poiname"));
        localann.c(localant);
        localObject = new anm();
        ((anm)localObject).bsP(aY(paramca));
        ((anm)localObject).arq(6);
        ((anm)localObject).Ey(true);
        ((anm)localObject).Ex(true);
        ((anm)localObject).a(localann);
        ((anm)localObject).bsS(a(localann.Szn));
        ((anm)localObject).bsT(b(localann.Szn));
        if (as.bvK(localann.Szn.SAb))
        {
          paramca = localann.Szn.SAb;
          paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
          if (!Util.isNullOrNil(paramca)) {
            ((anm)localObject).btb(paramca);
          }
        }
        paramdd.fyI.fyK.syG.add(localObject);
        paramca = paramdd.fyI.fyL;
        paramca.SAT += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static boolean a(dd paramdd, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(275050);
    Object localObject1 = null;
    if (paramca.field_msgId > 0L) {
      localObject1 = com.tencent.mm.ay.q.bmh().D(paramca.field_talker, (int)paramca.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.ay.g)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramca.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.ay.q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramdd.fyI.fyO = R.l.favorite_fail_image_not_exists;
      AppMethodBeat.o(275050);
      return false;
    }
    ann localann = new ann();
    localann.c(aX(paramca));
    localObject1 = new anm();
    ((anm)localObject1).bsP(aY(paramca));
    ((anm)localObject1).arq(2);
    ((anm)localObject1).bsL(com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c((com.tencent.mm.ay.g)localObject2), "", ""));
    if (((com.tencent.mm.ay.g)localObject2).blK())
    {
      localObject2 = com.tencent.mm.ay.q.bmh().wl(((com.tencent.mm.ay.g)localObject2).lNR);
      if (((com.tencent.mm.ay.g)localObject2).lAW > ((com.tencent.mm.ay.g)localObject2).offset) {
        ((anm)localObject1).bsL(com.tencent.mm.ay.q.bmh().r("SERVERID://" + paramca.field_msgSvrId, "", ""));
      }
    }
    ((anm)localObject1).bsM(com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true));
    ((anm)localObject1).a(localann);
    ((anm)localObject1).bsS(a(localann.Szn));
    ((anm)localObject1).bsT(b(localann.Szn));
    ((anm)localObject1).Ua(paramca.field_msgId);
    ((anm)localObject1).btf(bs.RU(paramca.hxy));
    if (as.bvK(localann.Szn.SAb))
    {
      paramca = localann.Szn.SAb;
      paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
      if (!Util.isNullOrNil(paramca)) {
        ((anm)localObject1).btb(paramca);
      }
    }
    paramdd.fyI.fyK.syG.add(localObject1);
    paramdd = paramdd.fyI.fyL;
    paramdd.JCD += 1;
    AppMethodBeat.o(275050);
    return true;
  }
  
  private static ano aX(ca paramca)
  {
    AppMethodBeat.i(30972);
    ano localano = new ano();
    if (paramca == null)
    {
      AppMethodBeat.o(30972);
      return localano;
    }
    Object localObject;
    if (paramca.field_isSend == 0)
    {
      localano.btg(paramca.field_talker);
      localano.bth(z.bcZ());
      if (ab.Lj(paramca.field_talker))
      {
        if (paramca.field_content == null) {
          break label367;
        }
        localObject = paramca.field_content.substring(0, Math.max(0, paramca.field_content.indexOf(':')));
        localano.btj((String)localObject);
        if ((!Util.isNullOrNil(localano.SAb)) && (!paramca.hwF()))
        {
          paramca.setContent(paramca.field_content.substring(localano.SAb.length() + 1));
          if ((paramca.field_content.length() > 0) && ('\n' == paramca.field_content.charAt(0))) {
            paramca.setContent(paramca.field_content.substring(1));
          }
          if (paramca.hzO())
          {
            if ((!Util.isNullOrNil(paramca.field_transContent)) && (paramca.field_transContent.startsWith(localano.SAb))) {
              paramca.Jp(paramca.field_transContent.substring(localano.SAb.length() + 1));
            }
            if ((paramca.field_transContent.length() > 0) && ('\n' == paramca.field_transContent.charAt(0))) {
              paramca.Jp(paramca.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.ao.g.KI(paramca.field_talker))
      {
        String str = paramca.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = bq.RR(paramca.hxy).userId;
        }
        localano.btj((String)localObject);
      }
      localano.aru(1);
      localano.Ub(paramca.field_createTime);
      localano.btk(paramca.field_msgSvrId);
      if (paramca.field_msgSvrId > 0L) {
        localano.bti(paramca.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localano;
      label367:
      localObject = "";
      break;
      localano.btg(z.bcZ());
      localano.bth(paramca.field_talker);
      if (ab.Lj(paramca.field_talker)) {
        localano.btj(localano.fLi);
      }
    }
  }
  
  private static String aY(ca paramca)
  {
    AppMethodBeat.i(30975);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Lj(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
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
  
  private static String b(ano paramano)
  {
    AppMethodBeat.i(30974);
    paramano = HCy.format(new Date(paramano.createTime));
    AppMethodBeat.o(30974);
    return paramano;
  }
  
  private static boolean b(Context paramContext, dd paramdd, ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramdd == null) || (paramca == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    paramca = ca.bs(paramca);
    if (paramca.hwH()) {
      bool = e(paramdd, paramca);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(paramca, paramdd, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (paramca.hwF()) {
        bool = b(paramdd, paramca, false);
      } else if (paramca.erm()) {
        bool = a(paramdd, paramca);
      } else if (paramca.hwG()) {
        bool = a(paramdd, paramca, false);
      } else if (paramca.dlR()) {
        bool = c(paramdd, paramca, false);
      } else if (paramca.dlT()) {
        bool = c(paramdd, paramca, false);
      } else if (paramca.dlS()) {
        bool = com.tencent.mm.plugin.record.b.c.b(paramdd, paramca);
      } else if (paramca.hwA()) {
        bool = c(paramdd, paramca);
      } else if (paramca.hzy()) {
        bool = c(paramContext, paramdd, paramca);
      } else if ((paramca.erk()) && (!paramca.hzC())) {
        bool = a(paramContext, paramdd, paramca, false);
      } else {
        paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
      }
    }
  }
  
  private static boolean b(dd paramdd, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(275051);
    ann localann = new ann();
    localann.c(aX(paramca));
    anm localanm = new anm();
    localanm.bsP(aY(paramca));
    localanm.arq(3);
    if (ab.QI(paramca.field_talker)) {
      localanm.bsL(bpE(paramca.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localanm.Ey(true);
      localb = com.tencent.mm.modelvoice.s.YC(paramca.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(275051);
      return false;
      localanm.bsL(com.tencent.mm.modelvoice.s.getFullPath(paramca.field_imgPath));
    }
    localanm.bsH(j.apC(localb.getFormat()));
    localanm.arp((int)new p(paramca.field_content).time);
    localanm.a(localann);
    localanm.bsS(a(localann.Szn));
    localanm.bsT(b(localann.Szn));
    if (as.bvK(localann.Szn.SAb))
    {
      paramca = localann.Szn.SAb;
      paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
      if (!Util.isNullOrNil(paramca)) {
        localanm.btb(paramca);
      }
    }
    paramdd.fyI.fyK.syG.add(localanm);
    paramdd = paramdd.fyI.fyL;
    paramdd.SAR += 1;
    AppMethodBeat.o(275051);
    return true;
  }
  
  private static String bpE(String paramString)
  {
    AppMethodBeat.i(30980);
    bh.beI();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.bbZ(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30980);
      return null;
    }
    if (new com.tencent.mm.vfs.q(paramString).ifE())
    {
      AppMethodBeat.o(30980);
      return paramString;
    }
    AppMethodBeat.o(30980);
    return paramString;
  }
  
  private static aoi bpF(String paramString)
  {
    AppMethodBeat.i(30971);
    aoi localaoi = new aoi();
    localaoi.btx(paramString);
    localaoi.arz(1);
    localaoi.Ue(Util.nowMilliSecond());
    localaoi.btz("");
    AppMethodBeat.o(30971);
    return localaoi;
  }
  
  private static boolean c(Context paramContext, dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30982);
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().aOU(paramca.field_content);
    ann localann = new ann();
    localann.c(aX(paramca));
    if ((localObject != null) && (ab.uL(((ca.a)localObject).PKJ)))
    {
      paramContext = new anm();
      paramContext.bsP(aY(paramca));
      paramContext.arq(16);
      paramContext.bsy(paramca.field_content);
      paramContext.Ey(true);
      paramContext.Ex(true);
      paramContext.a(localann);
      paramContext.bsS(a(localann.Szn));
      paramContext.bsT(b(localann.Szn));
      if (!as.bvK(localann.Szn.SAb)) {
        break label337;
      }
      paramca = localann.Szn.SAb;
      paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
      if (!Util.isNullOrNil(paramca)) {
        paramContext.btb(paramca);
      }
    }
    label337:
    for (;;)
    {
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SBb += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (as.bvK(((ca.a)localObject).fcC)))
      {
        localObject = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(((ca.a)localObject).VGK, "openim_card_type_name", a.a.mxX);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(R.l.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(paramca, paramContext, localann);
          break;
        }
      }
      paramContext = a(paramca, paramContext.getString(R.l.app_friend_card_personal), localann);
    }
  }
  
  private static boolean c(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30987);
    try
    {
      com.tencent.mm.aj.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
      Object localObject1 = localu.lpz;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          v localv = (v)((Iterator)localObject1).next();
          if (!m.OS(localv.lpP))
          {
            ann localann = new ann();
            localann.c(aX(paramca));
            localann.Szn.btn(localu.fUd);
            localann.Szn.btm(localv.url);
            Object localObject2 = new anm();
            ((anm)localObject2).bsx(localv.title);
            ((anm)localObject2).bsy(localv.lpM);
            ((anm)localObject2).bsP(aY(paramca));
            if (!Util.isNullOrNil(localv.lpK)) {
              ((anm)localObject2).bsM(w.bpO(localv.lpK));
            }
            for (;;)
            {
              ((anm)localObject2).Ex(true);
              aor localaor = new aor();
              if (!Util.isNullOrNil(localv.title)) {
                localaor.btK(localv.title);
              }
              if (!Util.isNullOrNil(localv.lpM)) {
                localaor.btL(localv.lpM);
              }
              if (!Util.isNullOrNil(localv.lpK)) {
                localaor.btN(m.a(localv));
              }
              if (localaor.computeSize() > 0)
              {
                localaor.arA(1);
                localann.b(localaor);
              }
              ((anm)localObject2).arq(5);
              ((anm)localObject2).a(localann);
              ((anm)localObject2).bsS(a(localann.Szn));
              ((anm)localObject2).bsT(b(localann.Szn));
              if (as.bvK(localann.Szn.SAb))
              {
                String str = localann.Szn.SAb;
                str = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(str));
                if (!Util.isNullOrNil(str)) {
                  ((anm)localObject2).btb(str);
                }
              }
              paramdd.fyI.fyK.syG.add(localObject2);
              localObject2 = paramdd.fyI.fyL;
              ((aoq)localObject2).SAS += 1;
              localann.d(m.a(localv, localaor, localu.fUd, localu.fUe));
              i += 1;
              break;
              ((anm)localObject2).Ey(true);
            }
          }
        }
      }
      if (i != 0) {
        break label558;
      }
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.GetFavRecordDataSource", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30987);
      return false;
    }
    paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
    AppMethodBeat.o(30987);
    return false;
    label558:
    AppMethodBeat.o(30987);
    return true;
  }
  
  private static boolean c(dd paramdd, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(275052);
    Object localObject = new ann();
    ((ann)localObject).c(aX(paramca));
    anm localanm = new anm();
    localanm.bsP(aY(paramca));
    com.tencent.mm.modelvideo.s.bqB();
    localanm.bsL(x.XT(paramca.field_imgPath));
    com.tencent.mm.modelvideo.s.bqB();
    localanm.bsM(x.XU(paramca.field_imgPath));
    localanm.bsH(com.tencent.mm.vfs.u.asq(localanm.Syl));
    if (paramca.dlT()) {
      localanm.arq(15);
    }
    com.tencent.mm.modelvideo.w localw;
    for (;;)
    {
      localw = y.Yk(paramca.field_imgPath);
      if (localw != null) {
        break;
      }
      Log.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramdd.fyI.fyO = R.l.favorite_fail;
      AppMethodBeat.o(275052);
      return false;
      localanm.arq(4);
    }
    Log.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(localw.lAW) });
    if (localw.lAW > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimit(false))
    {
      paramdd.fyI.fyO = R.l.favorite_too_large_format;
      AppMethodBeat.o(275052);
      return false;
    }
    if ((paramca.dlT()) && (y.Yl(localw.getFileName())))
    {
      paramdd.fyI.fyO = R.l.favorite_fail;
      AppMethodBeat.o(275052);
      return false;
    }
    localanm.arp(localw.lvw);
    localanm.a((ann)localObject);
    localanm.bsS(a(((ann)localObject).Szn));
    localanm.bsT(b(((ann)localObject).Szn));
    if (as.bvK(((ann)localObject).Szn.SAb))
    {
      localObject = ((ann)localObject).Szn.SAb;
      localObject = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject));
      if (!Util.isNullOrNil((String)localObject)) {
        localanm.btb((String)localObject);
      }
    }
    localanm.Ua(paramca.field_msgId);
    localanm.btf(bs.RU(paramca.hxy));
    localanm.TY(localw.lAW);
    paramdd.fyI.fyK.syG.add(localanm);
    paramdd = paramdd.fyI.fyL;
    paramdd.xzT += 1;
    paramdd = y.Yk(paramca.field_imgPath);
    localanm.bsV(paramdd.fUk);
    paramdd = paramdd.mhZ;
    if ((paramdd != null) && (!Util.isNullOrNil(paramdd.lox)))
    {
      paramca = new anp();
      paramca.lor = paramdd.lor;
      paramca.SAk = paramdd.SAk;
      paramca.lou = paramdd.lou;
      paramca.lov = paramdd.lov;
      paramca.lot = paramdd.lot;
      paramca.low = paramdd.low;
      paramca.lox = paramdd.lox;
      paramca.loy = paramdd.loy;
      localanm.a(paramca);
    }
    AppMethodBeat.o(275052);
    return true;
  }
  
  private static boolean e(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30976);
    ann localann = new ann();
    localann.c(aX(paramca));
    anm localanm = new anm();
    localanm.bsP(aY(paramca));
    localanm.arq(1);
    String str = "";
    if (paramca.hAk()) {
      str = MMApplicationContext.getContext().getString(R.l.eQH, new Object[] { "@" }) + '\n';
    }
    for (;;)
    {
      localanm.bsy(str + paramca.field_content);
      localanm.Ey(true);
      localanm.Ex(true);
      localanm.a(localann);
      localanm.bsS(a(localann.Szn));
      localanm.bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          localanm.btb(paramca);
        }
      }
      paramdd.fyI.fyK.syG.add(localanm);
      paramdd = paramdd.fyI.fyL;
      paramdd.SAQ += 1;
      AppMethodBeat.o(30976);
      return true;
      if (paramca.hAl()) {
        str = MMApplicationContext.getContext().getString(R.l.eRn) + '\n';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */