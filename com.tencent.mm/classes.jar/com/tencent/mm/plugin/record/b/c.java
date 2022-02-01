package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.pluginsdk.model.ad;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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

public final class c
{
  private static final SimpleDateFormat HCy;
  
  static
  {
    AppMethodBeat.i(9458);
    HCy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static anm a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localanm;
      localanm.Ey(true);
    }
  }
  
  private static anm a(ca paramca, String paramString, ann paramann)
  {
    AppMethodBeat.i(9455);
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
    AppMethodBeat.o(9455);
    return localanm;
  }
  
  private static String a(ano paramano)
  {
    AppMethodBeat.i(9448);
    String str2 = paramano.SAb;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramano.fLi;
    }
    if (com.tencent.mm.ao.a.e.Vb(str1))
    {
      paramano = com.tencent.mm.ao.a.e.Vd(str1);
      AppMethodBeat.o(9448);
      return paramano;
    }
    paramano = aa.PI(str1);
    AppMethodBeat.o(9448);
    return paramano;
  }
  
  private static boolean a(Context paramContext, dd paramdd, ca paramca)
  {
    AppMethodBeat.i(9456);
    ann localann = new ann();
    localann.c(aX(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.OQ((String)localObject1);
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9456);
      return false;
    }
    localann.Szn.btl(((k.b)localObject1).appId);
    localann.Szn.btn(((k.b)localObject1).fUd);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).Qv()))
    {
      paramContext = a(paramca, paramContext.getString(a.c.app_game), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(paramca, paramContext.getString(a.c.app_special), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
    case 74: 
      localObject2 = new anm();
      ((anm)localObject2).bsP(aY(paramca));
      ((anm)localObject2).arq(1);
      paramca = new StringBuilder();
      if (((k.b)localObject1).type == 74) {
        paramca.append(paramContext.getString(a.c.app_file));
      }
      paramca.append(((k.b)localObject1).title);
      ((anm)localObject2).bsy(paramca.toString());
      ((anm)localObject2).Ey(true);
      ((anm)localObject2).Ex(true);
      ((anm)localObject2).a(localann);
      ((anm)localObject2).bsS(a(localann.Szn));
      ((anm)localObject2).bsT(b(localann.Szn));
      if (as.bvK(localann.Szn.SAb))
      {
        paramContext = localann.Szn.SAb;
        paramContext = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((anm)localObject2).btb(paramContext);
        }
      }
      paramdd.fyI.fyK.syG.add(localObject2);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAQ += 1;
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.h.aHH();
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramdd.fyI.fyO = a.c.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.ab.a.ctZ().bpR(((k.b)localObject1).fvr);
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
      AppMethodBeat.o(9456);
      return true;
    case 3: 
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
      if (((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.btd(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bte(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).ar(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.SAU += 1;
      AppMethodBeat.o(9456);
      return true;
    case 76: 
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
      AppMethodBeat.o(9456);
      return true;
    case 4: 
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
      AppMethodBeat.o(9456);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        if (((k.b)localObject1).bbw())
        {
          paramContext = a(paramca, paramContext.getString(a.c.app_not_show), localann);
          paramdd.fyI.fyK.syG.add(paramContext);
          AppMethodBeat.o(9456);
          return true;
        }
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
        localann.d(m.a(paramca, (aor)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramdd.fyI.fyO = a.c.favorite_fail_empty_url;
      paramContext = a(paramca, paramContext.getString(a.c.app_special), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.f.class);
      if (paramContext != null)
      {
        paramContext = paramContext.mbi;
        localObject1 = new anm();
        ((anm)localObject1).bsS(a(localann.Szn));
        ((anm)localObject1).bsT(b(localann.Szn));
        ((anm)localObject1).bsP(aY(paramca));
        ((anm)localObject1).Ex(true);
        ((anm)localObject1).bsx(paramContext.nickname + MMApplicationContext.getContext().getString(a.c.favorite_sub_title_finder_tail));
        ((anm)localObject1).bsy(paramContext.desc);
        ((anm)localObject1).arq(22);
        localann.c(paramContext);
        ((anm)localObject1).a(localann);
        paramdd.fyI.fyK.syG.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 63: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.Bvb;
        localObject1 = new anm();
        ((anm)localObject1).bsS(a(localann.Szn));
        ((anm)localObject1).bsT(b(localann.Szn));
        ((anm)localObject1).bsP(aY(paramca));
        ((anm)localObject1).Ex(true);
        ((anm)localObject1).bsx(paramContext.nickName + MMApplicationContext.getContext().getString(a.c.favorite_sub_title_finder_live_tail));
        ((anm)localObject1).bsy(paramContext.desc);
        ((anm)localObject1).arq(23);
        localann.f(paramContext);
        ((anm)localObject1).a(localann);
        paramdd.fyI.fyK.syG.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 59: 
    case 72: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.h)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.h.class);
      if (paramContext != null)
      {
        paramContext = paramContext.mbf;
        localObject1 = new anm();
        ((anm)localObject1).bsS(a(localann.Szn));
        ((anm)localObject1).bsT(b(localann.Szn));
        ((anm)localObject1).bsP(aY(paramca));
        ((anm)localObject1).Ex(true);
        if (paramContext.wXA == 1) {
          ((anm)localObject1).bsx(MMApplicationContext.getContext().getString(a.c.jfE, new Object[] { paramContext.topic }));
        }
        for (;;)
        {
          ((anm)localObject1).bsy(paramContext.desc);
          ((anm)localObject1).arq(27);
          localann.d(paramContext);
          ((anm)localObject1).a(localann);
          paramdd.fyI.fyK.syG.add(localObject1);
          AppMethodBeat.o(9456);
          return true;
          ((anm)localObject1).bsx(paramContext.topic);
        }
      }
      AppMethodBeat.o(9456);
      return false;
    case 50: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.e)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.e.class);
      if (paramContext != null)
      {
        localObject1 = paramContext.Bvc;
        localObject2 = new anm();
        ((anm)localObject2).bsS(a(localann.Szn));
        ((anm)localObject2).bsT(b(localann.Szn));
        ((anm)localObject2).bsP(aY(paramca));
        ((anm)localObject2).Ex(true);
        ((anm)localObject2).bsx(paramContext.nickname);
        ((anm)localObject2).arq(26);
        localann.a((bjd)localObject1);
        ((anm)localObject2).a(localann);
        paramdd.fyI.fyK.syG.add(localObject2);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 73: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.d)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.d.class);
      if (paramContext != null)
      {
        paramContext = paramContext.mbg;
        localObject1 = new anm();
        ((anm)localObject1).bsS(a(localann.Szn));
        ((anm)localObject1).bsT(b(localann.Szn));
        ((anm)localObject1).bsP(aY(paramca));
        ((anm)localObject1).Ex(true);
        ((anm)localObject1).bsx(paramContext.title);
        ((anm)localObject1).bsy(paramContext.rsw);
        ((anm)localObject1).arq(28);
        localann.c(paramContext);
        ((anm)localObject1).a(localann);
        paramdd.fyI.fyK.syG.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.h.aHH();
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramdd.fyI.fyO = a.c.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.ab.a.ctZ().bpR(((k.b)localObject1).fvr);
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
      paramContext.TY(((k.b)localObject1).llX);
      paramContext.bsI(((k.b)localObject1).filemd5);
      if (as.bvK(localann.Szn.SAb))
      {
        paramca = localann.Szn.SAb;
        paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.btb(paramca);
        }
      }
      paramContext.bsB(((k.b)localObject1).lml);
      paramContext.bsC(((k.b)localObject1).aesKey);
      paramContext.bta(((k.b)localObject1).lmc);
      paramContext.bsY(((k.b)localObject1).aesKey);
      paramContext.bsZ(((k.b)localObject1).lmi);
      paramdd.fyI.fyK.syG.add(paramContext);
      paramContext = paramdd.fyI.fyL;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).fvr == null) || (((k.b)localObject1).fvr.length() == 0)) {
        paramdd.fyI.fyO = a.c.favorite_fail_attachment_not_exists;
      }
      do
      {
        paramdd.fyI.fyO = a.c.favorite_fail_nonsupport;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.h.aHH();
      } while (com.tencent.mm.kernel.h.aHG().isSDCardAvailable());
      paramdd.fyI.fyO = a.c.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
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
      AppMethodBeat.o(9456);
      return true;
    case 20: 
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
      AppMethodBeat.o(9456);
      return true;
    case 13: 
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
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(paramca, paramContext.getString(a.c.app_not_show), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if ((((k.b)localObject1).loC == 3) || (((k.b)localObject1).loJ == 1))
      {
        paramContext = a(paramca, paramContext.getString(a.c.app_not_show), localann);
        paramdd.fyI.fyK.syG.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
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
      ((ank)localObject2).type = ((k.b)localObject1).loC;
      ((ank)localObject2).fES = ((k.b)localObject1).loT;
      ((ank)localObject2).fve = ((k.b)localObject1).loz;
      ((ank)localObject2).SxE = ((k.b)localObject1).fUe;
      ((ank)localObject2).otE = ((k.b)localObject1).loJ;
      localObject1 = (com.tencent.mm.aj.a)((k.b)localObject1).ar(com.tencent.mm.aj.a.class);
      if (localObject1 != null)
      {
        ((ank)localObject2).nYp = ((com.tencent.mm.aj.a)localObject1).lkl;
        ((ank)localObject2).fXg = ((com.tencent.mm.aj.a)localObject1).lkn;
        ((ank)localObject2).subType = ((com.tencent.mm.aj.a)localObject1).lko;
      }
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
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(paramca, paramContext.getString(a.c.app_game_recording) + ((k.b)localObject1).title, localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).z(paramContext, true);
      if (Util.isNullOrNil((String)localObject2))
      {
        paramContext = a(paramca, paramContext.getString(a.c.app_special), localann);
        paramdd.fyI.fyK.syG.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(paramca, (String)localObject2 + ((k.b)localObject1).title, localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).lmA != null) && (((k.b)localObject1).lmA.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).lpz.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!Util.isNullOrNil(((anm)((Iterator)localObject3).next()).Sze))
              {
                paramdd.fyI.fyO = a.c.favorite_fail_nonsupport;
                AppMethodBeat.o(9456);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label5420;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label5420:
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
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramca, paramContext.getString(a.c.favorite_wenote_msg), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramca, paramContext.getString(a.c.app_product_card_ticket), localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      switch (com.tencent.mm.plugin.findersdk.a.k.d(((k.b)localObject1).lpa, ((k.b)localObject1).loX))
      {
      default: 
        break;
      case 3: 
        paramContext = (com.tencent.mm.plugin.findersdk.a.c)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.c.class);
        if (paramContext != null)
        {
          paramContext = paramContext.mbf;
          localObject1 = new anm();
          ((anm)localObject1).bsS(a(localann.Szn));
          ((anm)localObject1).bsT(b(localann.Szn));
          ((anm)localObject1).bsP(aY(paramca));
          ((anm)localObject1).Ex(true);
          if (paramContext.wXA == 7) {
            ((anm)localObject1).bsx(MMApplicationContext.getContext().getString(a.c.HCu, new Object[] { paramContext.STw.SCS, paramContext.STw.SCR }));
          }
          for (;;)
          {
            ((anm)localObject1).bsy(paramContext.desc);
            ((anm)localObject1).arq(30);
            localann.e(paramContext);
            ((anm)localObject1).a(localann);
            paramdd.fyI.fyK.syG.add(localObject1);
            AppMethodBeat.o(9456);
            return true;
            ((anm)localObject1).bsx(paramContext.topic);
          }
        }
        AppMethodBeat.o(9456);
        return false;
      }
    }
  }
  
  private static boolean a(Context paramContext, dd paramdd, ca paramca, int paramInt)
  {
    AppMethodBeat.i(9446);
    ann localann = new ann();
    localann.c(aX(paramca));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(a.c.app_emoji);
    }
    for (;;)
    {
      paramContext = a(paramca, str, localann);
      paramdd.fyI.fyK.syG.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(a.c.app_pay);
      } else if (paramInt == 3) {
        str = paramContext.getString(a.c.app_special);
      }
    }
  }
  
  public static boolean a(Context paramContext, dd paramdd, String paramString, List<ca> paramList, int paramInt)
  {
    AppMethodBeat.i(210016);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramdd.fyI.fyO = a.c.favorite_fail_argument_error;
      AppMethodBeat.o(210016);
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
          ((ca)localObject2).setContent(paramContext.getString(a.c.app_text));
          break;
        case 3: 
          ((ca)localObject2).setContent(paramContext.getString(a.c.app_pic));
          ((ca)localObject2).setType(1);
          break;
        case 43: 
          ((ca)localObject2).setContent(paramContext.getString(a.c.app_video));
          ((ca)localObject2).setType(1);
          break;
        case 49: 
          ((ca)localObject2).setContent(paramContext.getString(a.c.app_unknown_msg));
          ((ca)localObject2).setType(1);
        }
      }
    }
    boolean bool1 = com.tencent.mm.ao.g.KI(paramString);
    paramList.size();
    paramdd.fyI.fyK = new aoc();
    paramdd.fyI.fyL = new aoq();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.ao.a.e.GB(((ca)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.ao.a.e.Vc((String)localObject1))
      {
        paramdd.fyI.fyK.btv(paramContext.getString(a.c.record_chatroom_title));
        Log.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramdd.fyI.fyK.title });
      }
    }
    else
    {
      localObject1 = paramdd.fyI.fyK;
      localObject2 = new aoi();
      ((aoi)localObject2).btx(paramString);
      ((aoi)localObject2).arz(1);
      ((aoi)localObject2).Ue(Util.nowMilliSecond());
      ((aoi)localObject2).btz("");
      ((aoc)localObject1).a((aoi)localObject2);
      paramdd.fyI.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label3666;
      }
      paramString = (ca)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramdd.fyI.fyO = a.c.favorite_fail_argument_error;
      bool1 = false;
    }
    label468:
    Object localObject3;
    for (;;)
    {
      if (bool1)
      {
        j = 1;
        break label421;
        localObject2 = com.tencent.mm.ao.a.e.Vf(paramString);
        if (localObject2 == null) {
          break;
        }
        paramdd.fyI.fyK.btv(paramContext.getString(a.c.favorite_record_chat_title, new Object[] { ((com.tencent.mm.ao.a.k)localObject2).field_userName, com.tencent.mm.ao.a.e.Vd((String)localObject1) }));
        break;
        label531:
        if (ab.Lj(paramString))
        {
          paramdd.fyI.fyK.btv(paramContext.getString(a.c.record_chatroom_title));
          break;
        }
        localObject1 = Util.nullAsNil(z.bdb());
        if (((String)localObject1).equals(Util.nullAsNil(aa.PI(paramString))))
        {
          paramdd.fyI.fyK.btv(paramContext.getString(a.c.favorite_record_chatroom_title, new Object[] { localObject1 }));
          break;
        }
        paramdd.fyI.fyK.btv(paramContext.getString(a.c.favorite_record_chat_title, new Object[] { z.bdb(), aa.PI(paramString) }));
        break;
        label650:
        localObject2 = ca.bs(paramString);
        bool1 = false;
        if (bs.W((ca)localObject2))
        {
          paramString = new ann();
          paramString.c(aX((ca)localObject2));
          paramString = a((ca)localObject2, paramContext.getString(a.c.app_msg), paramString);
          paramdd.fyI.fyK.syG.add(paramString);
          bool1 = true;
        }
        else
        {
          if (((ca)localObject2).hwH())
          {
            localObject3 = new ann();
            ((ann)localObject3).c(aX((ca)localObject2));
            paramList = new anm();
            paramList.bsP(aY((ca)localObject2));
            paramList.arq(1);
            paramString = "";
            if (((ca)localObject2).hAk()) {
              paramString = MMApplicationContext.getContext().getString(a.c.eQH, new Object[] { "@" }) + '\n';
            }
            for (;;)
            {
              paramList.bsy(paramString + ((et)localObject2).field_content);
              paramList.Ey(true);
              paramList.Ex(true);
              paramList.a((ann)localObject3);
              paramList.bsS(a(((ann)localObject3).Szn));
              paramList.bsT(b(((ann)localObject3).Szn));
              if (as.bvK(((ann)localObject3).Szn.SAb))
              {
                paramString = ((ann)localObject3).Szn.SAb;
                paramString = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString));
                if (!Util.isNullOrNil(paramString)) {
                  paramList.btb(paramString);
                }
              }
              paramdd.fyI.fyK.syG.add(paramList);
              paramString = paramdd.fyI.fyL;
              paramString.SAQ += 1;
              bool1 = true;
              break;
              if (((ca)localObject2).hAl()) {
                paramString = MMApplicationContext.getContext().getString(a.c.eRn) + '\n';
              }
            }
          }
          if (((ca)localObject2).hwF())
          {
            paramList = new ann();
            paramList.c(aX((ca)localObject2));
            paramString = new anm();
            paramString.bsP(aY((ca)localObject2));
            paramString.arq(3);
            paramString.Ey(true);
            paramString.Ex(true);
            paramString.a(paramList);
            paramString.bsS(a(paramList.Szn));
            paramString.bsT(b(paramList.Szn));
            if (as.bvK(paramList.Szn.SAb))
            {
              paramList = paramList.Szn.SAb;
              paramList = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramList));
              if (!Util.isNullOrNil(paramList)) {
                paramString.btb(paramList);
              }
            }
            paramdd.fyI.fyK.syG.add(paramString);
            paramString = paramdd.fyI.fyL;
            paramString.SAR += 1;
            bool1 = true;
          }
          else if (((ca)localObject2).erm())
          {
            bool1 = a(paramdd, (ca)localObject2);
          }
          else if (((ca)localObject2).hwG())
          {
            paramList = null;
            if (((et)localObject2).field_msgId > 0L) {
              paramList = com.tencent.mm.ay.q.bmh().D(((et)localObject2).field_talker, (int)((et)localObject2).field_msgId);
            }
            if (paramList != null)
            {
              paramString = paramList;
              if (paramList.localId > 0L) {}
            }
            else
            {
              paramString = paramList;
              if (((et)localObject2).field_msgSvrId > 0L) {
                paramString = com.tencent.mm.ay.q.bmh().C(((et)localObject2).field_talker, ((et)localObject2).field_msgSvrId);
              }
            }
            if (paramString == null)
            {
              Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
              paramdd.fyI.fyO = a.c.favorite_fail_image_not_exists;
              bool1 = false;
              continue;
            }
            localObject3 = new ann();
            ((ann)localObject3).c(aX((ca)localObject2));
            paramList = new anm();
            paramList.bsP(aY((ca)localObject2));
            paramList.arq(2);
            paramList.bsL(com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c(paramString), "", ""));
            if (paramString.blK())
            {
              com.tencent.mm.ay.g localg = com.tencent.mm.ay.q.bmh().wl(paramString.lNR);
              if (localg.lAW > localg.offset) {
                paramList.bsL(com.tencent.mm.ay.q.bmh().r("SERVERID://" + ((et)localObject2).field_msgSvrId, "", ""));
              }
            }
            paramList.bsM(com.tencent.mm.ay.q.bmh().T(((et)localObject2).field_imgPath, true));
            paramList.a((ann)localObject3);
            paramList.bsS(a(((ann)localObject3).Szn));
            paramList.bsT(b(((ann)localObject3).Szn));
            paramList.Ua(((et)localObject2).field_msgId);
            paramList.btf(bs.RU(((et)localObject2).hxy));
            if (as.bvK(((ann)localObject3).Szn.SAb))
            {
              localObject3 = ((ann)localObject3).Szn.SAb;
              localObject3 = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject3));
              if (!Util.isNullOrNil((String)localObject3)) {
                paramList.btb((String)localObject3);
              }
            }
            if ((!paramString.blK()) || (paramString.lAW != 0)) {
              break label3701;
            }
            paramString = com.tencent.mm.ay.q.bmh().wl(paramString.lNR);
          }
        }
      }
    }
    label1841:
    label2033:
    label3698:
    label3701:
    for (;;)
    {
      int i;
      if (((et)localObject2).field_isSend == 1) {
        if (paramString.blK())
        {
          i = 1;
          label1661:
          localObject2 = XmlParser.parseXml(paramString.lNS, "msg", null);
          if (localObject2 == null) {
            break label1841;
          }
          if (i == 1)
          {
            paramList.bsB((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.TY(Util.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.bsC((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramdd.fyI.fyK.syG.add(paramList);
        paramString = paramdd.fyI.fyL;
        paramString.JCD += 1;
        bool1 = true;
        break;
        i = 0;
        break label1661;
        if (!paramString.blK())
        {
          i = 0;
          break label1661;
        }
        localObject2 = com.tencent.mm.ay.h.a(paramString);
        if (!com.tencent.mm.vfs.u.agG(com.tencent.mm.ay.q.bmh().r(((com.tencent.mm.ay.g)localObject2).lNH, "", "")))
        {
          i = 0;
          break label1661;
        }
        i = 1;
        break label1661;
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.lNS });
      }
      if ((((ca)localObject2).dlR()) || (((ca)localObject2).dlT()))
      {
        if (paramInt == 10)
        {
          localObject3 = new ann();
          ((ann)localObject3).c(aX((ca)localObject2));
          paramString = new anm();
          paramString.bsP(aY((ca)localObject2));
          s.bqB();
          paramString.bsL(x.XT(((et)localObject2).field_imgPath));
          s.bqB();
          paramString.bsM(x.XU(((et)localObject2).field_imgPath));
          paramString.bsH(com.tencent.mm.vfs.u.asq(paramString.Syl));
          if (((ca)localObject2).dlT()) {
            paramString.arq(15);
          }
          for (;;)
          {
            paramList = y.Yk(((et)localObject2).field_imgPath);
            if (paramList != null) {
              break label2033;
            }
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
            paramdd.fyI.fyO = a.c.favorite_fail;
            bool1 = false;
            break;
            paramString.arq(4);
          }
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d maxFileLength:%s", new Object[] { Integer.valueOf(paramList.lAW), Integer.valueOf(ad.hhm()) });
          if (paramList.lAW > ad.hhm())
          {
            paramdd.fyI.fyO = a.c.favorite_too_large_format;
            bool1 = false;
            break label468;
          }
          if ((((ca)localObject2).dlT()) && (y.Yl(paramList.getFileName())))
          {
            paramdd.fyI.fyO = a.c.favorite_fail;
            bool1 = false;
            break label468;
          }
          paramString.arp(paramList.lvw);
          paramString.a((ann)localObject3);
          paramString.bsS(a(((ann)localObject3).Szn));
          paramString.bsT(b(((ann)localObject3).Szn));
          if (as.bvK(((ann)localObject3).Szn.SAb))
          {
            localObject3 = ((ann)localObject3).Szn.SAb;
            localObject3 = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject3));
            if (!Util.isNullOrNil((String)localObject3)) {
              paramString.btb((String)localObject3);
            }
          }
          paramString.Ua(((et)localObject2).field_msgId);
          paramString.btf(bs.RU(((et)localObject2).hxy));
          paramString.TY(paramList.lAW);
          localObject3 = XmlParser.parseXml(paramList.bqO(), "msg", null);
          if (localObject3 != null)
          {
            paramString.bsB((String)((Map)localObject3).get(".msg.videomsg.$cdnvideourl"));
            paramString.bsC((String)((Map)localObject3).get(".msg.videomsg.$aeskey"));
          }
          for (;;)
          {
            paramdd.fyI.fyK.syG.add(paramString);
            localObject3 = paramdd.fyI.fyL;
            ((aoq)localObject3).xzT += 1;
            localObject2 = y.Yk(((et)localObject2).field_imgPath);
            paramList = XmlParser.parseXml(paramList.bqO(), "msg", null);
            if (paramList != null) {
              paramString.bsI((String)paramList.get(".msg.videomsg.$md5"));
            }
            paramString.bsV(((com.tencent.mm.modelvideo.w)localObject2).fUk);
            paramList = ((com.tencent.mm.modelvideo.w)localObject2).mhZ;
            if ((paramList != null) && (!Util.isNullOrNil(paramList.lox)))
            {
              localObject2 = new anp();
              ((anp)localObject2).lor = paramList.lor;
              ((anp)localObject2).SAk = paramList.SAk;
              ((anp)localObject2).lou = paramList.lou;
              ((anp)localObject2).lov = paramList.lov;
              ((anp)localObject2).lot = paramList.lot;
              ((anp)localObject2).low = paramList.low;
              ((anp)localObject2).lox = paramList.lox;
              ((anp)localObject2).loy = paramList.loy;
              paramString.a((anp)localObject2);
            }
            bool1 = true;
            break;
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
          }
        }
        localObject3 = new ann();
        ((ann)localObject3).c(aX((ca)localObject2));
        paramString = new anm();
        paramString.bsP(aY((ca)localObject2));
        s.bqB();
        paramString.bsL(x.XT(((et)localObject2).field_imgPath));
        s.bqB();
        paramString.bsM(x.XU(((et)localObject2).field_imgPath));
        paramString.bsH(com.tencent.mm.vfs.u.asq(paramString.Syl));
        if (((ca)localObject2).dlT()) {
          paramString.arq(15);
        }
        for (;;)
        {
          paramList = y.Yk(((et)localObject2).field_imgPath);
          if (paramList != null) {
            break label2679;
          }
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
          paramdd.fyI.fyO = a.c.favorite_fail;
          bool1 = false;
          break;
          paramString.arq(4);
        }
        label2679:
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(paramList.lAW) });
        if (paramList.lAW > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimit(true))
        {
          paramdd.fyI.fyO = a.c.favorite_too_large_format;
          bool1 = false;
          break label468;
        }
        if ((((ca)localObject2).dlT()) && (y.Yl(paramList.getFileName())))
        {
          paramdd.fyI.fyO = a.c.favorite_fail;
          bool1 = false;
          break label468;
        }
        paramString.arp(paramList.lvw);
        paramString.a((ann)localObject3);
        paramString.bsS(a(((ann)localObject3).Szn));
        paramString.bsT(b(((ann)localObject3).Szn));
        if (as.bvK(((ann)localObject3).Szn.SAb))
        {
          localObject3 = ((ann)localObject3).Szn.SAb;
          localObject3 = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject3));
          if (!Util.isNullOrNil((String)localObject3)) {
            paramString.btb((String)localObject3);
          }
        }
        paramString.Ua(((et)localObject2).field_msgId);
        paramString.btf(bs.RU(((et)localObject2).hxy));
        paramString.TY(paramList.lAW);
        paramList = XmlParser.parseXml(paramList.bqO(), "msg", null);
        if (paramList != null)
        {
          paramString.bsB((String)paramList.get(".msg.videomsg.$cdnvideourl"));
          paramString.bsC((String)paramList.get(".msg.videomsg.$aeskey"));
        }
        for (;;)
        {
          paramdd.fyI.fyK.syG.add(paramString);
          paramList = paramdd.fyI.fyL;
          paramList.xzT += 1;
          paramList = y.Yk(((et)localObject2).field_imgPath);
          paramString.bsV(paramList.fUk);
          paramList = paramList.mhZ;
          if ((paramList != null) && (!Util.isNullOrNil(paramList.lox)))
          {
            localObject2 = new anp();
            ((anp)localObject2).lor = paramList.lor;
            ((anp)localObject2).SAk = paramList.SAk;
            ((anp)localObject2).lou = paramList.lou;
            ((anp)localObject2).lov = paramList.lov;
            ((anp)localObject2).lot = paramList.lot;
            ((anp)localObject2).low = paramList.low;
            ((anp)localObject2).lox = paramList.lox;
            ((anp)localObject2).loy = paramList.loy;
            paramString.a((anp)localObject2);
          }
          bool1 = true;
          break;
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
        }
      }
      if (((ca)localObject2).dlS())
      {
        bool1 = b(paramdd, (ca)localObject2);
        break label468;
      }
      if (((ca)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramdd, (ca)localObject2, 3);
        break label468;
      }
      if (((ca)localObject2).hwA())
      {
        bool1 = c(paramdd, (ca)localObject2);
        break label468;
      }
      if ((((ca)localObject2).hzB()) || (((ca)localObject2).hzC()))
      {
        bool1 = a(paramContext, paramdd, (ca)localObject2, 1);
        break label468;
      }
      if (((ca)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramdd, (ca)localObject2, 2);
        break label468;
      }
      if (((ca)localObject2).hzy())
      {
        paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOU(((et)localObject2).field_content);
        paramList = new ann();
        paramList.c(aX((ca)localObject2));
        if ((paramString != null) && (ab.uL(paramString.PKJ)))
        {
          paramString = new anm();
          paramString.bsP(aY((ca)localObject2));
          paramString.arq(16);
          paramString.bsy(((et)localObject2).field_content);
          paramString.Ey(true);
          paramString.Ex(true);
          paramString.a(paramList);
          paramString.bsS(a(paramList.Szn));
          paramString.bsT(b(paramList.Szn));
          if (!as.bvK(paramList.Szn.SAb)) {
            break label3698;
          }
          paramList = paramList.Szn.SAb;
          paramList = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramList));
          if (!Util.isNullOrNil(paramList)) {
            paramString.btb(paramList);
          }
        }
      }
      for (;;)
      {
        paramdd.fyI.fyK.syG.add(paramString);
        paramString = paramdd.fyI.fyL;
        paramString.SBb += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (as.bvK(paramString.fcC)))
        {
          paramString = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(paramString.VGK, "openim_card_type_name", a.a.mxX);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(a.c.app_friend_card_personal);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((ca)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((ca)localObject2, paramContext.getString(a.c.app_friend_card_personal), paramList);
        continue;
        if (((ca)localObject2).erk())
        {
          if (((ca)localObject2).hzC())
          {
            paramdd.fyI.fyO = a.c.favorite_fail_nonsupport;
            break label468;
          }
          bool1 = a(paramContext, paramdd, (ca)localObject2);
          break label468;
        }
        paramdd.fyI.fyO = a.c.favorite_fail_nonsupport;
        bool1 = a(paramContext, paramdd, (ca)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramdd.fyI.fyO > 0)) {
          paramdd.fyI.fyO = 0;
        }
        AppMethodBeat.o(210016);
        return bool2;
      }
    }
  }
  
  private static boolean a(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(9451);
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
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramdd.fyI.fyO = a.c.favorite_fail_parse_error;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static ano aX(ca paramca)
  {
    AppMethodBeat.i(9447);
    ano localano = new ano();
    if (paramca == null)
    {
      AppMethodBeat.o(9447);
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
      AppMethodBeat.o(9447);
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
    AppMethodBeat.i(9450);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Lj(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
      {
        paramca = String.format("%d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return paramca;
      }
      paramca = String.format("%s#%d", new Object[] { paramca.field_talker, Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return paramca;
    }
    long l = paramca.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static String b(ano paramano)
  {
    AppMethodBeat.i(9449);
    paramano = HCy.format(new Date(paramano.createTime));
    AppMethodBeat.o(9449);
    return paramano;
  }
  
  public static boolean b(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.aG(paramca.field_content, paramca.field_reserved);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new aoc();
    Object localObject3 = new aoi();
    ((aoi)localObject3).btx(z.bcZ());
    ((aoi)localObject3).bty(z.bcZ());
    ((aoi)localObject3).arz(4);
    ((aoi)localObject3).Ue(Util.nowMilliSecond());
    ((aoi)localObject3).btE(((k.b)localObject2).url);
    ((aoc)localObject1).a((aoi)localObject3);
    localObject1 = new anm();
    ((anm)localObject1).bsL("");
    ((anm)localObject1).bsG(((k.b)localObject2).thumburl);
    localObject3 = m.x(paramca);
    if (localObject3 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((anm)localObject1).arp(((anu)localObject3).duration);
    ((anm)localObject1).bsx(((k.b)localObject2).title);
    ((anm)localObject1).bsD(((k.b)localObject2).url);
    ((anm)localObject1).Ex(true);
    ((anm)localObject1).Ey(true);
    localObject2 = new ann();
    ((ann)localObject2).c(aX(paramca));
    if (paramca.dlS()) {
      ((ann)localObject2).e((anu)localObject3);
    }
    ((anm)localObject1).a((ann)localObject2);
    ((anm)localObject1).Ua(paramca.field_msgId);
    ((anm)localObject1).bsS(a(((ann)localObject2).Szn));
    ((anm)localObject1).bsT(b(((ann)localObject2).Szn));
    if (as.bvK(((ann)localObject2).Szn.SAb))
    {
      paramca = ((ann)localObject2).Szn.SAb;
      paramca = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca));
      if (!Util.isNullOrNil(paramca)) {
        ((anm)localObject1).btb(paramca);
      }
    }
    paramdd.fyI.fyK.syG.add(localObject1);
    paramdd = paramdd.fyI.fyL;
    paramdd.xzT += 1;
    ((anm)localObject1).arq(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(9457);
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
              ((anm)localObject2).bsM(com.tencent.mm.pluginsdk.model.w.bpO(localv.lpK));
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
      Log.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramdd.fyI.fyO = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9457);
      return false;
    }
    paramdd.fyI.fyO = a.c.favorite_fail_nonsupport;
    AppMethodBeat.o(9457);
    return false;
    label558:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */