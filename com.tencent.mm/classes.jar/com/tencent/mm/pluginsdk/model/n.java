package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.k;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n
{
  private static final SimpleDateFormat NAb;
  
  static
  {
    AppMethodBeat.i(30988);
    NAb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(30988);
  }
  
  private static arf a(cc paramcc, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30983);
    arf localarf = new arf();
    localarf.bsG(bp(paramcc));
    localarf.bsv(paramb.nRx);
    localarf.bsw(paramb.nRy);
    localarf.bsu(paramb.url);
    localarf.Kj(true);
    paramcc = new com.tencent.mm.vfs.u(Util.nullAs(r.bKa().X(paramcc.field_imgPath, true), ""));
    if (paramcc.jKS()) {
      localarf.bsD(com.tencent.mm.vfs.ah.v(paramcc.jKT()));
    }
    for (;;)
    {
      localarf.bso(paramb.title);
      localarf.bsp(paramb.description);
      localarf.axy(paramInt);
      localarf.bsN(paramb.canvasPageXml);
      AppMethodBeat.o(30983);
      return localarf;
      localarf.Kk(true);
    }
  }
  
  private static arf a(cc paramcc, String paramString, arg paramarg)
  {
    AppMethodBeat.i(30984);
    arf localarf = new arf();
    localarf.bsG(bp(paramcc));
    localarf.axy(1);
    localarf.bsp(paramString);
    localarf.Kk(true);
    localarf.Kj(true);
    localarf.a(paramarg);
    localarf.bsJ(a(paramarg.ZAf));
    localarf.bsK(b(paramarg.ZAf));
    if (au.bwO(paramarg.ZAf.ZAT))
    {
      paramcc = paramarg.ZAf.ZAT;
      paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        localarf.bsS(paramcc);
      }
    }
    AppMethodBeat.o(30984);
    return localarf;
  }
  
  private static String a(arh paramarh)
  {
    AppMethodBeat.i(30973);
    String str2 = paramarh.ZAT;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramarh.hQQ;
    }
    if (com.tencent.mm.an.a.e.Na(str1))
    {
      paramarh = com.tencent.mm.an.a.e.Nc(str1);
      AppMethodBeat.o(30973);
      return paramarh;
    }
    paramarh = com.tencent.mm.model.aa.ID(str1);
    AppMethodBeat.o(30973);
    return paramarh;
  }
  
  private static void a(cc paramcc, arg paramarg, ask paramask)
  {
    AppMethodBeat.i(30986);
    paramarg.d(m.a(paramcc, paramask));
    AppMethodBeat.o(30986);
  }
  
  private static boolean a(Context paramContext, dn paramdn, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(244848);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    Object localObject1 = paramcc.field_content;
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(244848);
      return false;
    }
    localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(244848);
      return false;
    }
    localarg.ZAf.btc(((k.b)localObject1).appId);
    localarg.ZAf.bte(((k.b)localObject1).iaa);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
    if (localObject2 != null) {
      ((com.tencent.mm.pluginsdk.model.app.g)localObject2).aqJ();
    }
    switch (((k.b)localObject1).type)
    {
    }
    for (;;)
    {
      paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
      AppMethodBeat.o(244848);
      return false;
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.axy(1);
      paramContext.bsp(((k.b)localObject1).title);
      paramContext.Kk(true);
      paramContext.Kj(true);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBI += 1;
      AppMethodBeat.o(244848);
      return true;
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(244848);
        return false;
      }
      localObject2 = as.cWJ().bpI(((k.b)localObject1).hzM);
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      if (localObject2 != null) {
        paramContext.bsC(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      localObject2 = r.bKa().X(paramcc.field_imgPath, true);
      if (com.tencent.mm.vfs.y.ZC((String)localObject2)) {
        paramContext.bsD((String)localObject2);
      }
      paramContext.axy(2);
      paramContext.bso(((k.b)localObject1).title);
      paramContext.bsp(((k.b)localObject1).description);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      paramContext.bsW(bt.JV(paramcc.jUr));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.PTe += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = a(paramcc, (k.b)localObject1, 7);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBM += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = a(paramcc, (k.b)localObject1, 29);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      if (((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.bsU(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bsV(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
        paramcc = new dtj();
        paramcc.YqN = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqN;
        paramcc.YqO = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqO;
        paramcc.YqP = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqP;
        paramcc.YqQ = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqQ;
        paramcc.singerName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqR;
        paramcc.albumName = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqS;
        paramcc.musicGenre = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqT;
        paramcc.issueDate = Util.safeParseLong(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqU);
        paramcc.identification = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqV;
        paramcc.LNC = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).LNC;
        paramcc.extraInfo = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqW;
        paramcc.musicOperationUrl = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).YqX;
        paramcc.oOZ = ((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).oOZ;
        localarg.e(paramcc);
      }
      paramContext.a(localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBM += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = a(paramcc, (k.b)localObject1, 4);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      paramContext.bsW(bt.JV(paramcc.jUr));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.AXs += 1;
      AppMethodBeat.o(244848);
      return true;
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localarg.ZAf.btd(((k.b)localObject1).url);
        paramContext = a(paramcc, (k.b)localObject1, 5);
        paramContext.a(localarg);
        paramContext.bsJ(a(localarg.ZAf));
        paramContext.bsK(b(localarg.ZAf));
        if (au.bwO(localarg.ZAf.ZAT))
        {
          localObject2 = localarg.ZAf.ZAT;
          localObject2 = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject2));
          if (!Util.isNullOrNil((String)localObject2)) {
            paramContext.bsS((String)localObject2);
          }
        }
        localObject2 = new ask();
        if (!Util.isNullOrNil(((k.b)localObject1).title)) {
          ((ask)localObject2).btB(((k.b)localObject1).title);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).description)) {
          ((ask)localObject2).btC(((k.b)localObject1).description);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).thumburl)) {
          ((ask)localObject2).btE(((k.b)localObject1).thumburl);
        }
        if (!Util.isNullOrNil(((k.b)localObject1).canvasPageXml)) {
          ((ask)localObject2).btF(((k.b)localObject1).canvasPageXml);
        }
        ((ask)localObject2).axK(((k.b)localObject1).nUb);
        if (((ask)localObject2).computeSize() > 0)
        {
          ((ask)localObject2).axI(1);
          localarg.b((ask)localObject2);
        }
        paramdn.hDr.hDt.vEn.add(paramContext);
        paramContext = paramdn.hDr.hDu;
        paramContext.ZBK += 1;
        a(paramcc, localarg, (ask)localObject2);
        AppMethodBeat.o(244848);
        return true;
      }
      paramdn.hDr.hDx = R.l.favorite_fail_empty_url;
      AppMethodBeat.o(244848);
      return false;
      paramContext = (f)((k.b)localObject1).aK(f.class);
      if (paramContext != null)
      {
        localObject1 = paramContext.oUc;
        localObject2 = new arf();
        ((arf)localObject2).bsJ(a(localarg.ZAf));
        ((arf)localObject2).bsK(b(localarg.ZAf));
        ((arf)localObject2).bsG(bp(paramcc));
        ((arf)localObject2).Kj(true);
        ((arf)localObject2).bso(paramContext.getNickname() + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail));
        ((arf)localObject2).bsp(((bvl)localObject1).desc);
        ((arf)localObject2).axy(22);
        localarg.g((bvl)localObject1);
        ((arf)localObject2).a(localarg);
        paramdn.hDr.hDt.vEn.add(localObject2);
        AppMethodBeat.o(244848);
        return true;
      }
      AppMethodBeat.o(244848);
      return false;
      paramdn.hDr.hDx = R.l.gHE;
      AppMethodBeat.o(244848);
      return false;
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(244848);
        return false;
      }
      localObject2 = as.cWJ().bpI(((k.b)localObject1).hzM);
      paramContext = new arf();
      if (localObject2 != null) {
        paramContext.bsC(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
      }
      paramContext.bsG(bp(paramcc));
      paramContext.axy(8);
      paramContext.bsy(((k.b)localObject1).nRe);
      localObject2 = r.bKa().X(paramcc.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.Kk(true);
      }
      if (com.tencent.mm.vfs.y.ZC((String)localObject2)) {
        paramContext.bsD((String)localObject2);
      }
      paramContext.bso(((k.b)localObject1).title);
      paramContext.bsp(((k.b)localObject1).description);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBN += 1;
      AppMethodBeat.o(244848);
      return true;
      if ((((k.b)localObject1).hzM == null) || (((k.b)localObject1).hzM.length() == 0)) {
        paramdn.hDr.hDx = R.l.favorite_fail_attachment_not_exists;
      }
      do
      {
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(244848);
        return false;
        bh.bCz();
      } while (com.tencent.mm.model.c.isSDCardAvailable());
      paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(244848);
      return false;
      paramContext = new aru();
      paramContext.bth(((k.b)localObject1).title);
      paramContext.bti(((k.b)localObject1).description);
      paramContext.axE(((k.b)localObject1).nRA);
      paramContext.btk(((k.b)localObject1).nRB);
      paramContext.btj(((k.b)localObject1).thumburl);
      localarg.a(paramContext);
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.axy(10);
      paramContext.Kk(true);
      paramContext.Kj(true);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBP += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = new ase();
      paramContext.btx(((k.b)localObject1).title);
      paramContext.bty(((k.b)localObject1).description);
      paramContext.btA(((k.b)localObject1).nRE);
      paramContext.btz(((k.b)localObject1).thumburl);
      localarg.a(paramContext);
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.axy(14);
      paramContext.Kk(true);
      paramContext.Kj(true);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBT += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = new aru();
      paramContext.bth(((k.b)localObject1).title);
      paramContext.bti(((k.b)localObject1).description);
      paramContext.axE(((k.b)localObject1).nRG);
      paramContext.btk(((k.b)localObject1).nRH);
      paramContext.btj(((k.b)localObject1).thumburl);
      localarg.a(paramContext);
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.axy(11);
      paramContext.Kk(true);
      paramContext.Kj(true);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBQ += 1;
      AppMethodBeat.o(244848);
      return true;
      paramContext = a(paramcc, paramContext.getString(R.l.app_not_show), localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(244848);
      return true;
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.bso(((k.b)localObject1).title);
      paramContext.bsp(((k.b)localObject1).description);
      paramContext.axy(19);
      localObject2 = r.bKa().X(paramcc.field_imgPath, true);
      if (Util.isNullOrNil((String)localObject2)) {
        paramContext.Kk(true);
      }
      if (com.tencent.mm.vfs.y.ZC((String)localObject2)) {
        paramContext.bsD((String)localObject2);
      }
      localObject2 = new ard();
      if (!Util.isNullOrNil(((k.b)localObject1).nTD)) {
        ((ard)localObject2).username = ((k.b)localObject1).nTD;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).nTE)) {
        ((ard)localObject2).appId = ((k.b)localObject1).nTE;
      }
      if (!Util.isNullOrNil(((k.b)localObject1).nTY)) {
        ((ard)localObject2).iconUrl = ((k.b)localObject1).nTY;
      }
      ((ard)localObject2).rxs = ((k.b)localObject1).nTM;
      ((ard)localObject2).type = ((k.b)localObject1).nTF;
      ((ard)localObject2).hJK = ((k.b)localObject1).nTH;
      ((ard)localObject2).hzy = ((k.b)localObject1).nTC;
      ((ard)localObject2).Zyw = ((k.b)localObject1).iab;
      localarg.b((ard)localObject2);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(244848);
      return true;
      paramContext = a(paramcc, paramContext.getString(R.l.app_game_recording) + ((k.b)localObject1).title, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(244848);
      return true;
      paramContext = ((k.b)localObject1).B(paramContext, true);
      if (Util.isNullOrNil(paramContext))
      {
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(244848);
        return false;
      }
      paramContext = a(paramcc, paramContext + ((k.b)localObject1).title, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(244848);
      return true;
      if ((((k.b)localObject1).nRF != null) && (((k.b)localObject1).nRF.contains("<recordxml>"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject2 = new arf();
        ((arf)localObject2).bsG(bp(paramcc));
        ((arf)localObject2).axy(17);
        ((arf)localObject2).Kk(true);
        ((arf)localObject2).bso(((k.b)localObject1).title);
        ((arf)localObject2).bsO(((k.b)localObject1).nRF);
        paramContext = ((k.b)localObject1).description;
        Object localObject3 = new tr();
        ((tr)localObject3).hXt.type = 0;
        ((tr)localObject3).hXt.hXv = ((k.b)localObject1).nRF;
        ((tr)localObject3).publish();
        localObject1 = ((tr)localObject3).hXu.hXD;
        if (localObject1 == null) {
          break label3837;
        }
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).nUC.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (Util.isNullOrNil(((arf)((Iterator)localObject3).next()).ZzW));
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(244848);
        return false;
      }
    }
    label3837:
    if (localObject1 != null) {
      paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
    }
    for (;;)
    {
      ((arf)localObject2).bsp(paramContext);
      ((arf)localObject2).a(localarg);
      ((arf)localObject2).bsJ(a(localarg.ZAf));
      ((arf)localObject2).bsK(b(localarg.ZAf));
      ((arf)localObject2).yq(paramcc.field_msgId);
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramContext = localarg.ZAf.ZAT;
        paramContext = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((arf)localObject2).bsS(paramContext);
        }
      }
      paramdn.hDr.hDt.vEn.add(localObject2);
      AppMethodBeat.o(244848);
      return true;
    }
  }
  
  public static boolean a(Context paramContext, dn paramdn, String paramString, List<cc> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(30969);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
      paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      AppMethodBeat.o(30969);
      return false;
    }
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if (bt.F((cc)localObject2)) {
        switch (((cc)localObject2).getType() & 0xFFFF)
        {
        default: 
          break;
        case 1: 
          ((cc)localObject2).setContent(paramContext.getString(R.l.app_text));
          break;
        case 3: 
          ((cc)localObject2).setContent(paramContext.getString(R.l.app_pic));
          ((cc)localObject2).setType(1);
          break;
        case 43: 
          ((cc)localObject2).setContent(paramContext.getString(R.l.app_video));
          ((cc)localObject2).setType(1);
          break;
        case 49: 
          ((cc)localObject2).setContent(paramContext.getString(R.l.app_unknown_msg));
          ((cc)localObject2).setType(1);
        }
      }
    }
    boolean bool = com.tencent.mm.an.g.Dn(paramString);
    if ((paramList.size() == 1) && (!paramBoolean))
    {
      paramList = (cc)paramList.get(0);
      if (paramList.iYe())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramList.field_msgId, paramList.field_content);
        if ((((com.tencent.mm.message.u)localObject1).nUC != null) && (((com.tencent.mm.message.u)localObject1).nUC.size() == 1))
        {
          paramBoolean = l.d(paramdn, paramList);
          AppMethodBeat.o(30969);
          return paramBoolean;
        }
        paramdn.hDr.hDt = new arv();
        paramdn.hDr.hDu = new asj();
        paramdn.hDr.hDt.a(bpv(paramString));
        paramdn.hDr.type = 14;
        paramBoolean = b(paramContext, paramdn, paramList);
        AppMethodBeat.o(30969);
        return paramBoolean;
      }
      paramBoolean = l.d(paramdn, paramList);
      AppMethodBeat.o(30969);
      return paramBoolean;
    }
    paramdn.hDr.hDt = new arv();
    paramdn.hDr.hDu = new asj();
    int i;
    if (paramContext != null)
    {
      if (!bool) {
        break label633;
      }
      localObject1 = com.tencent.mm.an.a.e.iM(((cc)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.an.a.e.Nb((String)localObject1))
      {
        paramdn.hDr.hDt.btm(paramContext.getString(R.l.record_chatroom_title));
        Log.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[] { paramdn.hDr.hDt.title });
      }
    }
    else
    {
      paramdn.hDr.hDt.a(bpv(paramString));
      paramdn.hDr.type = 14;
      paramString = paramList.iterator();
      paramBoolean = true;
      i = 0;
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        break label758;
      }
      if (b(paramContext, paramdn, (cc)paramString.next()))
      {
        i = 1;
        continue;
        localObject2 = com.tencent.mm.an.a.e.Ne(paramString);
        if (localObject2 == null) {
          break;
        }
        paramdn.hDr.hDt.btm(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.an.a.e.Nc((String)localObject1) }));
        break;
        label633:
        if (au.bwE(paramString))
        {
          paramdn.hDr.hDt.btm(paramContext.getString(R.l.record_chatroom_title));
          break;
        }
        localObject1 = Util.nullAsNil(com.tencent.mm.model.z.bAO());
        if (((String)localObject1).equals(Util.nullAsNil(com.tencent.mm.model.aa.ID(paramString))))
        {
          paramdn.hDr.hDt.btm(paramContext.getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 }));
          break;
        }
        paramdn.hDr.hDt.btm(paramContext.getString(R.l.favorite_record_chat_title, new Object[] { com.tencent.mm.model.z.bAO(), com.tencent.mm.model.aa.ID(paramString) }));
        break;
      }
      paramBoolean = false;
    }
    label758:
    if ((i != 0) && (paramdn.hDr.hDx > 0)) {
      paramdn.hDr.hDx = 0;
    }
    AppMethodBeat.o(30969);
    return paramBoolean;
  }
  
  private static boolean a(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30978);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    Object localObject = XmlParser.parseXml(paramcc.field_content, "msg", null);
    if (localObject != null) {
      try
      {
        arm localarm = new arm();
        localarm.btf((String)((Map)localObject).get(".msg.location.$label"));
        localarm.W(Double.parseDouble((String)((Map)localObject).get(".msg.location.$x")));
        localarm.V(Double.parseDouble((String)((Map)localObject).get(".msg.location.$y")));
        localarm.axD(Integer.valueOf((String)((Map)localObject).get(".msg.location.$scale")).intValue());
        localarm.btg((String)((Map)localObject).get(".msg.location.$poiname"));
        localarg.c(localarm);
        localObject = new arf();
        ((arf)localObject).bsG(bp(paramcc));
        ((arf)localObject).axy(6);
        ((arf)localObject).Kk(true);
        ((arf)localObject).Kj(true);
        ((arf)localObject).a(localarg);
        ((arf)localObject).bsJ(a(localarg.ZAf));
        ((arf)localObject).bsK(b(localarg.ZAf));
        if (au.bwO(localarg.ZAf.ZAT))
        {
          paramcc = localarg.ZAf.ZAT;
          paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
          if (!Util.isNullOrNil(paramcc)) {
            ((arf)localObject).bsS(paramcc);
          }
        }
        paramdn.hDr.hDt.vEn.add(localObject);
        paramcc = paramdn.hDr.hDu;
        paramcc.ZBL += 1;
        AppMethodBeat.o(30978);
        return true;
      }
      catch (Exception paramcc)
      {
        Log.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[] { paramcc.getStackTrace().toString() });
      }
    }
    paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
    AppMethodBeat.o(30978);
    return false;
  }
  
  private static boolean a(dn paramdn, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(244787);
    Object localObject1 = null;
    if (paramcc.field_msgId > 0L) {
      localObject1 = r.bKa().H(paramcc.field_talker, (int)paramcc.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramcc.field_msgSvrId > 0L) {
        localObject2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
      paramdn.hDr.hDx = R.l.favorite_fail_image_not_exists;
      AppMethodBeat.o(244787);
      return false;
    }
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    localObject1 = new arf();
    ((arf)localObject1).bsG(bp(paramcc));
    ((arf)localObject1).axy(2);
    ((arf)localObject1).bsC(r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", ""));
    if (((com.tencent.mm.modelimage.h)localObject2).bJE())
    {
      localObject2 = r.bKa().wq(((com.tencent.mm.modelimage.h)localObject2).oGB);
      if (((com.tencent.mm.modelimage.h)localObject2).osy > ((com.tencent.mm.modelimage.h)localObject2).offset) {
        ((arf)localObject1).bsC(r.bKa().v("SERVERID://" + paramcc.field_msgSvrId, "", ""));
      }
    }
    ((arf)localObject1).bsD(r.bKa().X(paramcc.field_imgPath, true));
    ((arf)localObject1).a(localarg);
    ((arf)localObject1).bsJ(a(localarg.ZAf));
    ((arf)localObject1).bsK(b(localarg.ZAf));
    ((arf)localObject1).yq(paramcc.field_msgId);
    ((arf)localObject1).bsW(bt.JV(paramcc.jUr));
    if (au.bwO(localarg.ZAf.ZAT))
    {
      paramcc = localarg.ZAf.ZAT;
      paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        ((arf)localObject1).bsS(paramcc);
      }
    }
    paramdn.hDr.hDt.vEn.add(localObject1);
    paramdn = paramdn.hDr.hDu;
    paramdn.PTe += 1;
    AppMethodBeat.o(244787);
    return true;
  }
  
  private static String b(arh paramarh)
  {
    AppMethodBeat.i(30974);
    paramarh = NAb.format(new Date(paramarh.createTime));
    AppMethodBeat.o(30974);
    return paramarh;
  }
  
  private static boolean b(Context paramContext, dn paramdn, cc paramcc)
  {
    boolean bool = false;
    AppMethodBeat.i(30970);
    if ((paramdn == null) || (paramcc == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30970);
      return false;
    }
    paramcc = cc.bI(paramcc);
    if (paramcc.iYl()) {
      bool = e(paramdn, paramcc);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fav.ui.e.a(paramcc, paramdn, bool);
      AppMethodBeat.o(30970);
      return bool;
      if (paramcc.iYj()) {
        bool = b(paramdn, paramcc, false);
      } else if (paramcc.fxT()) {
        bool = a(paramdn, paramcc);
      } else if (paramcc.iYk()) {
        bool = a(paramdn, paramcc, false);
      } else if (paramcc.dSH()) {
        bool = c(paramdn, paramcc, false);
      } else if (paramcc.dSJ()) {
        bool = c(paramdn, paramcc, false);
      } else if (paramcc.dSI()) {
        bool = com.tencent.mm.plugin.record.model.c.b(paramdn, paramcc);
      } else if (paramcc.iYe()) {
        bool = c(paramdn, paramcc);
      } else if (paramcc.jbB()) {
        bool = c(paramContext, paramdn, paramcc);
      } else if (paramcc.jbC()) {
        bool = k(paramdn, paramcc);
      } else if ((paramcc.fxR()) && (!paramcc.jbH())) {
        bool = a(paramContext, paramdn, paramcc, false);
      } else {
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
      }
    }
  }
  
  private static boolean b(dn paramdn, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(244800);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    arf localarf = new arf();
    localarf.bsG(bp(paramcc));
    localarf.axy(3);
    if (au.bwm(paramcc.field_talker)) {
      localarf.bsC(bpu(paramcc.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localarf.Kk(true);
      localb = s.QH(paramcc.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(244800);
      return false;
      localarf.bsC(s.getFullPath(paramcc.field_imgPath));
    }
    localarf.bsy(l.avF(localb.getFormat()));
    localarf.axx((int)new p(paramcc.field_content).time);
    localarf.a(localarg);
    localarf.bsJ(a(localarg.ZAf));
    localarf.bsK(b(localarg.ZAf));
    if (au.bwO(localarg.ZAf.ZAT))
    {
      paramcc = localarg.ZAf.ZAT;
      paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        localarf.bsS(paramcc);
      }
    }
    paramdn.hDr.hDt.vEn.add(localarf);
    paramdn = paramdn.hDr.hDu;
    paramdn.ZBJ += 1;
    AppMethodBeat.o(244800);
    return true;
  }
  
  private static arh bo(cc paramcc)
  {
    AppMethodBeat.i(30972);
    arh localarh = new arh();
    if (paramcc == null)
    {
      AppMethodBeat.o(30972);
      return localarh;
    }
    Object localObject;
    if (paramcc.field_isSend == 0)
    {
      localarh.bsX(paramcc.field_talker);
      localarh.bsY(com.tencent.mm.model.z.bAM());
      if (au.bwE(paramcc.field_talker))
      {
        if (paramcc.field_content == null) {
          break label367;
        }
        localObject = paramcc.field_content.substring(0, Math.max(0, paramcc.field_content.indexOf(':')));
        localarh.bta((String)localObject);
        if ((!Util.isNullOrNil(localarh.ZAT)) && (!paramcc.iYj()))
        {
          paramcc.setContent(paramcc.field_content.substring(localarh.ZAT.length() + 1));
          if ((paramcc.field_content.length() > 0) && ('\n' == paramcc.field_content.charAt(0))) {
            paramcc.setContent(paramcc.field_content.substring(1));
          }
          if (paramcc.jbT())
          {
            if ((!Util.isNullOrNil(paramcc.field_transContent)) && (paramcc.field_transContent.startsWith(localarh.ZAT))) {
              paramcc.BV(paramcc.field_transContent.substring(localarh.ZAT.length() + 1));
            }
            if ((paramcc.field_transContent.length() > 0) && ('\n' == paramcc.field_transContent.charAt(0))) {
              paramcc.BV(paramcc.field_transContent.substring(1));
            }
          }
        }
      }
    }
    for (;;)
    {
      if (com.tencent.mm.an.g.Dn(paramcc.field_talker))
      {
        String str = paramcc.field_bizChatUserId;
        localObject = str;
        if (str == null) {
          localObject = com.tencent.mm.model.br.JP(paramcc.jUr).userId;
        }
        localarh.bta((String)localObject);
      }
      localarh.axC(1);
      localarh.yr(paramcc.getCreateTime());
      localarh.btb(paramcc.field_msgSvrId);
      if (paramcc.field_msgSvrId > 0L) {
        localarh.bsZ(paramcc.field_msgSvrId);
      }
      AppMethodBeat.o(30972);
      return localarh;
      label367:
      localObject = "";
      break;
      localarh.bsX(com.tencent.mm.model.z.bAM());
      localarh.bsY(paramcc.field_talker);
      if (au.bwE(paramcc.field_talker)) {
        localarh.bta(localarh.hQQ);
      }
    }
  }
  
  private static String bp(cc paramcc)
  {
    AppMethodBeat.i(30975);
    if (paramcc.field_isSend == 1)
    {
      if ((au.bwE(paramcc.field_talker)) || (paramcc.field_talker.equals("filehelper")))
      {
        paramcc = String.format("%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId) });
        AppMethodBeat.o(30975);
        return paramcc;
      }
      paramcc = String.format("%s#%d", new Object[] { paramcc.field_talker, Long.valueOf(paramcc.field_msgSvrId) });
      AppMethodBeat.o(30975);
      return paramcc;
    }
    long l = paramcc.field_msgSvrId;
    AppMethodBeat.o(30975);
    return String.valueOf(l);
  }
  
  private static String bpu(String paramString)
  {
    AppMethodBeat.i(30980);
    bh.bCz();
    paramString = FilePathGenerator.genPath(com.tencent.mm.model.c.bzO(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30980);
      return null;
    }
    if (new com.tencent.mm.vfs.u(paramString).jKS())
    {
      AppMethodBeat.o(30980);
      return paramString;
    }
    AppMethodBeat.o(30980);
    return paramString;
  }
  
  private static asb bpv(String paramString)
  {
    AppMethodBeat.i(30971);
    asb localasb = new asb();
    localasb.bto(paramString);
    localasb.axH(1);
    localasb.yu(Util.nowMilliSecond());
    localasb.btq("");
    AppMethodBeat.o(30971);
    return localasb;
  }
  
  private static boolean c(Context paramContext, dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30982);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    if ((localObject != null) && (com.tencent.mm.model.ab.uY(((cc.a)localObject).WAW)))
    {
      paramContext = new arf();
      paramContext.bsG(bp(paramcc));
      paramContext.axy(16);
      paramContext.bsp(paramcc.field_content);
      paramContext.Kk(true);
      paramContext.Kj(true);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (!au.bwO(localarg.ZAf.ZAT)) {
        break label337;
      }
      paramcc = localarg.ZAf.ZAT;
      paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        paramContext.bsS(paramcc);
      }
    }
    label337:
    for (;;)
    {
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBU += 1;
      AppMethodBeat.o(30982);
      return true;
      if ((localObject != null) && (au.bwO(((cc.a)localObject).hgk)))
      {
        localObject = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(((cc.a)localObject).adkD, "openim_card_type_name", e.a.prb);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (paramContext = paramContext.getResources().getString(R.l.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { localObject }))
        {
          paramContext = a(paramcc, paramContext, localarg);
          break;
        }
      }
      paramContext = a(paramcc, paramContext.getString(R.l.app_friend_card_personal), localarg);
    }
  }
  
  private static boolean c(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30987);
    for (;;)
    {
      int i;
      arf localarf;
      try
      {
        com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
        localObject1 = localu.nUC;
        if (localObject1 != null)
        {
          Iterator localIterator = ((List)localObject1).iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label826;
          }
          com.tencent.mm.message.v localv = (com.tencent.mm.message.v)localIterator.next();
          if (m.Hh(localv.nUR)) {
            continue;
          }
          arg localarg = new arg();
          localarg.c(bo(paramcc));
          localarg.ZAf.bte(localu.iaa);
          localarg.ZAf.btd(localv.url);
          localarf = new arf();
          localarf.bso(localv.title);
          localarf.bsp(localv.nUO);
          localarf.bsG(bp(paramcc));
          if (!Util.isNullOrNil(localv.nUM))
          {
            localarf.bsD(y.bpF(localv.nUM));
            localarf.Kj(true);
            ask localask = new ask();
            if (!Util.isNullOrNil(localv.title)) {
              localask.btB(localv.title);
            }
            if (!Util.isNullOrNil(localv.nUO)) {
              localask.btC(localv.nUO);
            }
            if (!Util.isNullOrNil(localv.nUM)) {
              localask.btE(m.a(localv));
            }
            if (localask.computeSize() > 0)
            {
              localask.axI(1);
              localarg.b(localask);
            }
            localarf.axy(5);
            localarf.a(localarg);
            localarf.bsJ(a(localarg.ZAf));
            localarf.bsK(b(localarg.ZAf));
            if (au.bwO(localarg.ZAf.ZAT))
            {
              localObject1 = localarg.ZAf.ZAT;
              localObject1 = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject1));
              if (!Util.isNullOrNil((String)localObject1)) {
                localarf.bsS((String)localObject1);
              }
            }
            if ((localv.type != 5) || (Util.isNullOrNil(localv.nVi)) || (SemiXml.decode(localv.nVi) == null)) {
              break label856;
            }
            Object localObject2 = SemiXml.decode(localv.nVi);
            if (i != 0) {
              break label817;
            }
            localObject1 = "";
            localObject1 = ".msg.appmsg.mmreader.category.item".concat(String.valueOf(localObject1));
            bvl localbvl = ((com.tencent.mm.plugin.findersdk.a.br)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.findersdk.a.br.class)).y((String)localObject1, (Map)localObject2);
            if ((localbvl == null) || (Util.isNullOrNil(localbvl.objectId))) {
              break label856;
            }
            Log.i("MicroMsg.GetFavRecordDataSource", "biz enter finder logic");
            j = 1;
            localarf = new arf();
            localarf.bsJ(a(localarg.ZAf));
            localarf.bsK(b(localarg.ZAf));
            localarf.bsG(bp(paramcc));
            localarf.Kj(true);
            localObject2 = localbvl.nickname;
            localObject1 = localObject2;
            if (localbvl.mIK != null)
            {
              localObject1 = localObject2;
              if (!localbvl.mIK.isEmpty()) {
                localObject1 = localbvl.mIK;
              }
            }
            localarf.bso((String)localObject1 + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail));
            localarf.bsp(localbvl.desc);
            localarf.axy(22);
            localarg.g(localbvl);
            localarf.a(localarg);
            localObject1 = localarf;
            paramdn.hDr.hDt.vEn.add(localObject1);
            localObject1 = paramdn.hDr.hDu;
            ((asj)localObject1).ZBK += 1;
            if (j != 0) {
              break label865;
            }
            localarg.d(m.a(localv, localask, localu.iaa, localu.iab));
            break label865;
          }
          localarf.Kk(true);
          continue;
        }
        localObject1 = String.valueOf(i);
      }
      catch (Exception paramcc)
      {
        Log.printErrStackTrace("MicroMsg.GetFavRecordDataSource", paramcc, "", new Object[0]);
        Log.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[] { paramcc.getLocalizedMessage() });
        paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
        AppMethodBeat.o(30987);
        return false;
      }
      label817:
      continue;
      label826:
      if (i == 0)
      {
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(30987);
        return false;
      }
      AppMethodBeat.o(30987);
      return true;
      label856:
      int j = 0;
      Object localObject1 = localarf;
      continue;
      label865:
      i += 1;
    }
  }
  
  private static boolean c(dn paramdn, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(244814);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    arf localarf = new arf();
    localarf.bsG(bp(paramcc));
    com.tencent.mm.modelvideo.v.bOh();
    localarf.bsC(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath));
    com.tencent.mm.modelvideo.v.bOh();
    localarf.bsD(com.tencent.mm.modelvideo.aa.PY(paramcc.field_imgPath));
    localarf.bsy(com.tencent.mm.vfs.y.alV(localarf.Zzd));
    if (paramcc.dSJ()) {
      localarf.axy(15);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
      if (localObject2 != null) {
        break;
      }
      Log.i("MicroMsg.GetFavRecordDataSource", "video info null");
      paramdn.hDr.hDx = R.l.favorite_fail;
      AppMethodBeat.o(244814);
      return false;
      localarf.axy(4);
    }
    com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(((com.tencent.mm.modelvideo.z)localObject2).oYk);
    Object localObject1 = localObject2;
    if (localz != null)
    {
      localObject1 = localObject2;
      if (localz.status == 199)
      {
        com.tencent.mm.modelvideo.v.bOh();
        localarf.bsC(com.tencent.mm.modelvideo.aa.PX(localz.getFileName()));
        localObject1 = localz;
      }
    }
    Log.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.z)localObject1).osy) });
    if (((com.tencent.mm.modelvideo.z)localObject1).osy > ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getVideoSizeLimit(false))
    {
      paramdn.hDr.hDx = R.l.favorite_too_large_format;
      AppMethodBeat.o(244814);
      return false;
    }
    if ((paramcc.dSJ()) && (com.tencent.mm.modelvideo.ab.Qp(((com.tencent.mm.modelvideo.z)localObject1).getFileName())))
    {
      paramdn.hDr.hDx = R.l.favorite_fail;
      AppMethodBeat.o(244814);
      return false;
    }
    localarf.axx(((com.tencent.mm.modelvideo.z)localObject1).omT);
    localarf.a(localarg);
    localarf.bsJ(a(localarg.ZAf));
    localarf.bsK(b(localarg.ZAf));
    if (au.bwO(localarg.ZAf.ZAT))
    {
      localObject2 = localarg.ZAf.ZAT;
      localObject2 = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject2));
      if (!Util.isNullOrNil((String)localObject2)) {
        localarf.bsS((String)localObject2);
      }
    }
    localarf.yq(paramcc.field_msgId);
    localarf.bsW(bt.JV(paramcc.jUr));
    localarf.yo(((com.tencent.mm.modelvideo.z)localObject1).osy);
    paramdn.hDr.hDt.vEn.add(localarf);
    paramdn = paramdn.hDr.hDu;
    paramdn.AXs += 1;
    paramdn = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    localarf.bsM(paramdn.iah);
    paramdn = paramdn.pbk;
    if ((paramdn != null) && (!Util.isNullOrNil(paramdn.nTA)))
    {
      paramcc = new ari();
      paramcc.nTu = paramdn.nTu;
      paramcc.ZBc = paramdn.ZBc;
      paramcc.nTx = paramdn.nTx;
      paramcc.nTy = paramdn.nTy;
      paramcc.nTw = paramdn.nTw;
      paramcc.nTz = paramdn.nTz;
      paramcc.nTA = paramdn.nTA;
      paramcc.nTB = paramdn.nTB;
      localarf.a(paramcc);
    }
    AppMethodBeat.o(244814);
    return true;
  }
  
  private static boolean e(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30976);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    arf localarf = new arf();
    localarf.bsG(bp(paramcc));
    localarf.axy(1);
    String str = "";
    if (paramcc.jcr()) {
      str = MMApplicationContext.getContext().getString(R.l.gTn, new Object[] { "@" }) + '\n';
    }
    for (;;)
    {
      localarf.bsp(str + paramcc.field_content);
      localarf.Kk(true);
      localarf.Kj(true);
      localarf.a(localarg);
      localarf.bsJ(a(localarg.ZAf));
      localarf.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          localarf.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(localarf);
      paramdn = paramdn.hDr.hDu;
      paramdn.ZBI += 1;
      AppMethodBeat.o(30976);
      return true;
      if (paramcc.jcs()) {
        str = MMApplicationContext.getContext().getString(R.l.gTT) + '\n';
      }
    }
  }
  
  private static boolean k(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(244825);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    com.tencent.mm.openim.a.e locale = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RD(paramcc.field_content);
    arf localarf = new arf();
    if (locale != null) {
      localarf.bso(Util.nullAs(locale.getDisplayName(), locale.username));
    }
    localarf.bsG(bp(paramcc));
    localarf.axy(31);
    localarf.bsp(paramcc.field_content);
    localarf.Kk(true);
    localarf.Kj(true);
    localarf.a(localarg);
    localarf.bsJ(a(localarg.ZAf));
    localarf.bsK(b(localarg.ZAf));
    paramdn.hDr.hDt.vEn.add(localarf);
    paramdn = paramdn.hDr.hDu;
    paramdn.ZBU += 1;
    AppMethodBeat.o(244825);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */