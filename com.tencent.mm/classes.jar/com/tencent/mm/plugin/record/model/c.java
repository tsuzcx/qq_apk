package com.tencent.mm.plugin.record.model;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.k;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.pluginsdk.model.af;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
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

public final class c
{
  private static final SimpleDateFormat NAb;
  
  static
  {
    AppMethodBeat.i(9458);
    NAb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static arf a(cc paramcc, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localarf;
      localarf.Kk(true);
    }
  }
  
  private static arf a(cc paramcc, String paramString, arg paramarg)
  {
    AppMethodBeat.i(9455);
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
      paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        localarf.bsS(paramcc);
      }
    }
    AppMethodBeat.o(9455);
    return localarf;
  }
  
  private static String a(arh paramarh)
  {
    AppMethodBeat.i(9448);
    String str2 = paramarh.ZAT;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramarh.hQQ;
    }
    if (com.tencent.mm.an.a.e.Na(str1))
    {
      paramarh = com.tencent.mm.an.a.e.Nc(str1);
      AppMethodBeat.o(9448);
      return paramarh;
    }
    paramarh = com.tencent.mm.model.aa.ID(str1);
    AppMethodBeat.o(9448);
    return paramarh;
  }
  
  private static boolean a(Context paramContext, dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(9456);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    Object localObject1 = paramcc.field_content;
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9456);
      return false;
    }
    localarg.ZAf.btc(((k.b)localObject1).appId);
    localarg.ZAf.bte(((k.b)localObject1).iaa);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).aqJ()))
    {
      paramContext = a(paramcc, paramContext.getString(a.c.app_game), localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(paramcc, paramContext.getString(a.c.app_special), localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
    case 74: 
      localObject2 = new arf();
      ((arf)localObject2).bsG(bp(paramcc));
      ((arf)localObject2).axy(1);
      paramcc = new StringBuilder();
      if (((k.b)localObject1).type == 74) {
        paramcc.append(paramContext.getString(a.c.app_file));
      }
      paramcc.append(((k.b)localObject1).title);
      ((arf)localObject2).bsp(paramcc.toString());
      ((arf)localObject2).Kk(true);
      ((arf)localObject2).Kj(true);
      ((arf)localObject2).a(localarg);
      ((arf)localObject2).bsJ(a(localarg.ZAf));
      ((arf)localObject2).bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramContext = localarg.ZAf.ZAT;
        paramContext = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((arf)localObject2).bsS(paramContext);
        }
      }
      paramdn.hDr.hDt.vEn.add(localObject2);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBI += 1;
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramdn.hDr.hDx = a.c.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.openapi.a.cWJ().bpI(((k.b)localObject1).hzM);
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
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.PTe += 1;
      AppMethodBeat.o(9456);
      return true;
    case 3: 
      paramContext = a(paramcc, (k.b)localObject1, 7);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      if (((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.bsU(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bsV(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).aK(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBM += 1;
      AppMethodBeat.o(9456);
      return true;
    case 76: 
      paramContext = a(paramcc, (k.b)localObject1, 29);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
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
      AppMethodBeat.o(9456);
      return true;
    case 4: 
      paramContext = a(paramcc, (k.b)localObject1, 4);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      paramContext.bsW(bt.JV(paramcc.jUr));
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.AXs += 1;
      AppMethodBeat.o(9456);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        if (((k.b)localObject1).bwp())
        {
          paramContext = a(paramcc, paramContext.getString(a.c.app_not_show), localarg);
          paramdn.hDr.hDt.vEn.add(paramContext);
          AppMethodBeat.o(9456);
          return true;
        }
        localarg.ZAf.btd(((k.b)localObject1).url);
        paramContext = a(paramcc, (k.b)localObject1, 5);
        paramContext.a(localarg);
        paramContext.bsJ(a(localarg.ZAf));
        paramContext.bsK(b(localarg.ZAf));
        if (au.bwO(localarg.ZAf.ZAT))
        {
          localObject2 = localarg.ZAf.ZAT;
          localObject2 = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject2));
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
        localarg.d(m.a(paramcc, (ask)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramdn.hDr.hDx = a.c.favorite_fail_empty_url;
      paramContext = a(paramcc, paramContext.getString(a.c.app_special), localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.f.class);
      if (paramContext != null)
      {
        localObject1 = paramContext.oUc;
        localObject2 = new arf();
        ((arf)localObject2).bsJ(a(localarg.ZAf));
        ((arf)localObject2).bsK(b(localarg.ZAf));
        ((arf)localObject2).bsG(bp(paramcc));
        ((arf)localObject2).Kj(true);
        ((arf)localObject2).bso(paramContext.getNickname() + MMApplicationContext.getContext().getString(a.c.favorite_sub_title_finder_tail));
        ((arf)localObject2).bsp(((bvl)localObject1).desc);
        ((arf)localObject2).axy(22);
        localarg.g((bvl)localObject1);
        ((arf)localObject2).a(localarg);
        paramdn.hDr.hDt.vEn.add(localObject2);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 63: 
    case 88: 
      paramContext = (com.tencent.mm.plugin.findersdk.a.b)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.HbV;
        localObject1 = new arf();
        ((arf)localObject1).bsJ(a(localarg.ZAf));
        ((arf)localObject1).bsK(b(localarg.ZAf));
        ((arf)localObject1).bsG(bp(paramcc));
        ((arf)localObject1).Kj(true);
        ((arf)localObject1).bso(paramContext.nickName + MMApplicationContext.getContext().getString(a.c.favorite_sub_title_finder_live_tail));
        ((arf)localObject1).bsp(paramContext.desc);
        ((arf)localObject1).axy(23);
        localarg.g(paramContext);
        ((arf)localObject1).a(localarg);
        paramdn.hDr.hDt.vEn.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 82: 
      localObject1 = (com.tencent.mm.plugin.findersdk.a.h)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.h.class);
      paramContext = paramContext.getString(a.c.app_url);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.h)localObject1).HbZ.aabi))) {
        paramContext = paramContext + ((com.tencent.mm.plugin.findersdk.a.h)localObject1).HbZ.aabi;
      }
      break;
    }
    for (;;)
    {
      paramContext = a(paramcc, paramContext, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = (com.tencent.mm.plugin.findersdk.a.i)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.i.class);
      if (paramContext != null)
      {
        paramContext = paramContext.oTZ;
        localObject1 = new arf();
        ((arf)localObject1).bsJ(a(localarg.ZAf));
        ((arf)localObject1).bsK(b(localarg.ZAf));
        ((arf)localObject1).bsG(bp(paramcc));
        ((arf)localObject1).Kj(true);
        if (paramContext.Auy == 1) {
          ((arf)localObject1).bso(MMApplicationContext.getContext().getString(a.c.lHP, new Object[] { paramContext.topic }));
        }
        for (;;)
        {
          ((arf)localObject1).bsp(paramContext.desc);
          ((arf)localObject1).axy(27);
          localarg.c(paramContext);
          ((arf)localObject1).a(localarg);
          paramdn.hDr.hDt.vEn.add(localObject1);
          AppMethodBeat.o(9456);
          return true;
          ((arf)localObject1).bso(paramContext.topic);
        }
      }
      AppMethodBeat.o(9456);
      return false;
      paramContext = (com.tencent.mm.plugin.findersdk.a.e)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.e.class);
      if (paramContext != null)
      {
        localObject1 = paramContext.HbW;
        localObject2 = new arf();
        ((arf)localObject2).bsJ(a(localarg.ZAf));
        ((arf)localObject2).bsK(b(localarg.ZAf));
        ((arf)localObject2).bsG(bp(paramcc));
        ((arf)localObject2).Kj(true);
        ((arf)localObject2).bso(paramContext.nickname);
        ((arf)localObject2).axy(26);
        localarg.a((bvk)localObject1);
        ((arf)localObject2).a(localarg);
        paramdn.hDr.hDt.vEn.add(localObject2);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
      paramContext = (com.tencent.mm.plugin.findersdk.a.d)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.d.class);
      if (paramContext != null)
      {
        paramContext = paramContext.oUa;
        localObject1 = new arf();
        ((arf)localObject1).bsJ(a(localarg.ZAf));
        ((arf)localObject1).bsK(b(localarg.ZAf));
        ((arf)localObject1).bsG(bp(paramcc));
        ((arf)localObject1).Kj(true);
        ((arf)localObject1).bso(paramContext.title);
        ((arf)localObject1).bsp(paramContext.uCW);
        ((arf)localObject1).axy(28);
        localarg.c(paramContext);
        ((arf)localObject1).a(localarg);
        paramdn.hDr.hDt.vEn.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramdn.hDr.hDx = a.c.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.openapi.a.cWJ().bpI(((k.b)localObject1).hzM);
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
      paramContext.yo(((k.b)localObject1).nRd);
      paramContext.bsz(((k.b)localObject1).filemd5);
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramContext.bss(((k.b)localObject1).nRq);
      paramContext.bst(((k.b)localObject1).aesKey);
      paramContext.bsR(((k.b)localObject1).tpurl);
      paramContext.bsP(((k.b)localObject1).aesKey);
      paramContext.bsQ(((k.b)localObject1).nRn);
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBN += 1;
      AppMethodBeat.o(9456);
      return true;
      if ((((k.b)localObject1).hzM == null) || (((k.b)localObject1).hzM.length() == 0)) {
        paramdn.hDr.hDx = a.c.favorite_fail_attachment_not_exists;
      }
      do
      {
        paramdn.hDr.hDx = a.c.favorite_fail_nonsupport;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.h.baF();
      } while (com.tencent.mm.kernel.h.baE().isSDCardAvailable());
      paramdn.hDr.hDx = a.c.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(9456);
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
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBP += 1;
      AppMethodBeat.o(9456);
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
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBT += 1;
      AppMethodBeat.o(9456);
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
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      paramContext = paramdn.hDr.hDu;
      paramContext.ZBQ += 1;
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramcc, paramContext.getString(a.c.app_not_show), localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      if ((((k.b)localObject1).nTF == 3) || (((k.b)localObject1).nTM == 1))
      {
        paramContext = a(paramcc, paramContext.getString(a.c.app_not_show), localarg);
        paramdn.hDr.hDt.vEn.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
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
      ((ard)localObject2).type = ((k.b)localObject1).nTF;
      ((ard)localObject2).hJK = ((k.b)localObject1).nTW;
      ((ard)localObject2).hzy = ((k.b)localObject1).nTC;
      ((ard)localObject2).Zyw = ((k.b)localObject1).iab;
      ((ard)localObject2).rxs = ((k.b)localObject1).nTM;
      localObject1 = (com.tencent.mm.message.a)((k.b)localObject1).aK(com.tencent.mm.message.a.class);
      if (localObject1 != null)
      {
        ((ard)localObject2).nOX = ((com.tencent.mm.message.a)localObject1).nOX;
        ((ard)localObject2).idf = ((com.tencent.mm.message.a)localObject1).nOZ;
        ((ard)localObject2).subType = ((com.tencent.mm.message.a)localObject1).nPa;
      }
      localarg.b((ard)localObject2);
      paramContext.a(localarg);
      paramContext.bsJ(a(localarg.ZAf));
      paramContext.bsK(b(localarg.ZAf));
      paramContext.yq(paramcc.field_msgId);
      if (au.bwO(localarg.ZAf.ZAT))
      {
        paramcc = localarg.ZAf.ZAT;
        paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
        if (!Util.isNullOrNil(paramcc)) {
          paramContext.bsS(paramcc);
        }
      }
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramcc, paramContext.getString(a.c.app_game_recording) + ((k.b)localObject1).title, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      localObject2 = ((k.b)localObject1).B(paramContext, true);
      if (Util.isNullOrNil((String)localObject2))
      {
        paramContext = a(paramcc, paramContext.getString(a.c.app_special), localarg);
        paramdn.hDr.hDt.vEn.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(paramcc, (String)localObject2 + ((k.b)localObject1).title, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      int i;
      if ((((k.b)localObject1).nRF != null) && (((k.b)localObject1).nRF.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).nUC.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!Util.isNullOrNil(((arf)((Iterator)localObject3).next()).ZzW))
              {
                paramdn.hDr.hDx = a.c.favorite_fail_nonsupport;
                AppMethodBeat.o(9456);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label5616;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
      label5616:
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
          paramContext = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramContext));
          if (!Util.isNullOrNil(paramContext)) {
            ((arf)localObject2).bsS(paramContext);
          }
        }
        paramdn.hDr.hDt.vEn.add(localObject2);
        AppMethodBeat.o(9456);
        return true;
        paramContext = a(paramcc, paramContext.getString(a.c.favorite_wenote_msg), localarg);
        paramdn.hDr.hDt.vEn.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
        paramContext = a(paramcc, paramContext.getString(a.c.app_product_card_ticket), localarg);
        paramdn.hDr.hDt.vEn.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
        switch (q.f(((k.b)localObject1).nUd, ((k.b)localObject1).nUa))
        {
        default: 
          break;
        case 3: 
          paramContext = (com.tencent.mm.plugin.findersdk.a.c)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.c.class);
          if (paramContext != null)
          {
            localObject1 = paramContext.oTZ;
            localObject2 = new arf();
            ((arf)localObject2).bsJ(a(localarg.ZAf));
            ((arf)localObject2).bsK(b(localarg.ZAf));
            ((arf)localObject2).bsG(bp(paramcc));
            ((arf)localObject2).Kj(true);
            if ((((bvn)localObject1).Auy == 7) && (((bvn)localObject1).aade != null))
            {
              paramContext = ((bvn)localObject1).aade;
              if ((TextUtils.isEmpty(paramContext.ZDL)) || ((paramContext.FOi & 1L) == 1L))
              {
                paramContext = paramContext.ZDK;
                ((arf)localObject2).bso(paramContext);
              }
            }
            for (;;)
            {
              ((arf)localObject2).bsp(((bvn)localObject1).desc);
              ((arf)localObject2).axy(30);
              localarg.d((bvn)localObject1);
              ((arf)localObject2).a(localarg);
              paramdn.hDr.hDt.vEn.add(localObject2);
              AppMethodBeat.o(9456);
              return true;
              paramContext = MMApplicationContext.getContext().getString(a.c.NzX, new Object[] { paramContext.ZDL, paramContext.ZDK });
              break;
              ((arf)localObject2).bso(((bvn)localObject1).topic);
            }
          }
          AppMethodBeat.o(9456);
          return false;
        }
      }
    }
  }
  
  private static boolean a(Context paramContext, dn paramdn, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(9446);
    arg localarg = new arg();
    localarg.c(bo(paramcc));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(a.c.app_emoji);
    }
    for (;;)
    {
      paramContext = a(paramcc, str, localarg);
      paramdn.hDr.hDt.vEn.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(a.c.app_pay);
      } else if (paramInt == 3) {
        str = paramContext.getString(a.c.app_special);
      }
    }
  }
  
  public static boolean a(Context paramContext, dn paramdn, String paramString, List<cc> paramList, int paramInt)
  {
    AppMethodBeat.i(305347);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramdn.hDr.hDx = a.c.favorite_fail_argument_error;
      AppMethodBeat.o(305347);
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
          ((cc)localObject2).setContent(paramContext.getString(a.c.app_text));
          break;
        case 3: 
          ((cc)localObject2).setContent(paramContext.getString(a.c.app_pic));
          ((cc)localObject2).setType(1);
          break;
        case 43: 
          ((cc)localObject2).setContent(paramContext.getString(a.c.app_video));
          ((cc)localObject2).setType(1);
          break;
        case 49: 
          ((cc)localObject2).setContent(paramContext.getString(a.c.app_unknown_msg));
          ((cc)localObject2).setType(1);
        }
      }
    }
    boolean bool1 = com.tencent.mm.an.g.Dn(paramString);
    paramList.size();
    paramdn.hDr.hDt = new arv();
    paramdn.hDr.hDu = new asj();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.an.a.e.iM(((cc)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.an.a.e.Nb((String)localObject1))
      {
        paramdn.hDr.hDt.btm(paramContext.getString(a.c.record_chatroom_title));
        Log.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramdn.hDr.hDt.title });
      }
    }
    else
    {
      localObject1 = paramdn.hDr.hDt;
      localObject2 = new asb();
      ((asb)localObject2).bto(paramString);
      ((asb)localObject2).axH(1);
      ((asb)localObject2).yu(Util.nowMilliSecond());
      ((asb)localObject2).btq("");
      ((arv)localObject1).a((asb)localObject2);
      paramdn.hDr.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label3859;
      }
      paramString = (cc)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramdn.hDr.hDx = a.c.favorite_fail_argument_error;
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
        localObject2 = com.tencent.mm.an.a.e.Ne(paramString);
        if (localObject2 == null) {
          break;
        }
        paramdn.hDr.hDt.btm(paramContext.getString(a.c.favorite_record_chat_title, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.an.a.e.Nc((String)localObject1) }));
        break;
        label531:
        if (au.bwE(paramString))
        {
          paramdn.hDr.hDt.btm(paramContext.getString(a.c.record_chatroom_title));
          break;
        }
        localObject1 = Util.nullAsNil(com.tencent.mm.model.z.bAO());
        if (((String)localObject1).equals(Util.nullAsNil(com.tencent.mm.model.aa.ID(paramString))))
        {
          paramdn.hDr.hDt.btm(paramContext.getString(a.c.favorite_record_chatroom_title, new Object[] { localObject1 }));
          break;
        }
        paramdn.hDr.hDt.btm(paramContext.getString(a.c.favorite_record_chat_title, new Object[] { com.tencent.mm.model.z.bAO(), com.tencent.mm.model.aa.ID(paramString) }));
        break;
        label650:
        localObject2 = cc.bI(paramString);
        bool1 = false;
        if (bt.aa((cc)localObject2))
        {
          paramString = new arg();
          paramString.c(bo((cc)localObject2));
          paramString = a((cc)localObject2, paramContext.getString(a.c.app_msg), paramString);
          paramdn.hDr.hDt.vEn.add(paramString);
          bool1 = true;
        }
        else
        {
          if (((cc)localObject2).iYl())
          {
            localObject3 = new arg();
            ((arg)localObject3).c(bo((cc)localObject2));
            paramList = new arf();
            paramList.bsG(bp((cc)localObject2));
            paramList.axy(1);
            paramString = "";
            if (((cc)localObject2).jcr()) {
              paramString = MMApplicationContext.getContext().getString(a.c.gTn, new Object[] { "@" }) + '\n';
            }
            for (;;)
            {
              paramList.bsp(paramString + ((fi)localObject2).field_content);
              paramList.Kk(true);
              paramList.Kj(true);
              paramList.a((arg)localObject3);
              paramList.bsJ(a(((arg)localObject3).ZAf));
              paramList.bsK(b(((arg)localObject3).ZAf));
              if (au.bwO(((arg)localObject3).ZAf.ZAT))
              {
                paramString = ((arg)localObject3).ZAf.ZAT;
                paramString = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString));
                if (!Util.isNullOrNil(paramString)) {
                  paramList.bsS(paramString);
                }
              }
              paramdn.hDr.hDt.vEn.add(paramList);
              paramString = paramdn.hDr.hDu;
              paramString.ZBI += 1;
              bool1 = true;
              break;
              if (((cc)localObject2).jcs()) {
                paramString = MMApplicationContext.getContext().getString(a.c.gTT) + '\n';
              }
            }
          }
          if (((cc)localObject2).iYj())
          {
            paramList = new arg();
            paramList.c(bo((cc)localObject2));
            paramString = new arf();
            paramString.bsG(bp((cc)localObject2));
            paramString.axy(3);
            paramString.Kk(true);
            paramString.Kj(true);
            paramString.a(paramList);
            paramString.bsJ(a(paramList.ZAf));
            paramString.bsK(b(paramList.ZAf));
            if (au.bwO(paramList.ZAf.ZAT))
            {
              paramList = paramList.ZAf.ZAT;
              paramList = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramList));
              if (!Util.isNullOrNil(paramList)) {
                paramString.bsS(paramList);
              }
            }
            paramdn.hDr.hDt.vEn.add(paramString);
            paramString = paramdn.hDr.hDu;
            paramString.ZBJ += 1;
            bool1 = true;
          }
          else if (((cc)localObject2).fxT())
          {
            bool1 = a(paramdn, (cc)localObject2);
          }
          else if (((cc)localObject2).iYk())
          {
            paramList = null;
            if (((fi)localObject2).field_msgId > 0L) {
              paramList = r.bKa().H(((fi)localObject2).field_talker, (int)((fi)localObject2).field_msgId);
            }
            if (paramList != null)
            {
              paramString = paramList;
              if (paramList.localId > 0L) {}
            }
            else
            {
              paramString = paramList;
              if (((fi)localObject2).field_msgSvrId > 0L) {
                paramString = r.bKa().G(((fi)localObject2).field_talker, ((fi)localObject2).field_msgSvrId);
              }
            }
            if (paramString == null)
            {
              Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
              paramdn.hDr.hDx = a.c.favorite_fail_image_not_exists;
              bool1 = false;
              continue;
            }
            localObject3 = new arg();
            ((arg)localObject3).c(bo((cc)localObject2));
            paramList = new arf();
            paramList.bsG(bp((cc)localObject2));
            paramList.axy(2);
            paramList.bsC(r.bKa().v(com.tencent.mm.modelimage.i.c(paramString), "", ""));
            if (paramString.bJE())
            {
              com.tencent.mm.modelimage.h localh = r.bKa().wq(paramString.oGB);
              if (localh.osy > localh.offset) {
                paramList.bsC(r.bKa().v("SERVERID://" + ((fi)localObject2).field_msgSvrId, "", ""));
              }
            }
            paramList.bsD(r.bKa().X(((fi)localObject2).field_imgPath, true));
            paramList.a((arg)localObject3);
            paramList.bsJ(a(((arg)localObject3).ZAf));
            paramList.bsK(b(((arg)localObject3).ZAf));
            paramList.yq(((fi)localObject2).field_msgId);
            paramList.bsW(bt.JV(((fi)localObject2).jUr));
            if (au.bwO(((arg)localObject3).ZAf.ZAT))
            {
              localObject3 = ((arg)localObject3).ZAf.ZAT;
              localObject3 = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject3));
              if (!Util.isNullOrNil((String)localObject3)) {
                paramList.bsS((String)localObject3);
              }
            }
            if ((!paramString.bJE()) || (paramString.osy != 0)) {
              break label3894;
            }
            paramString = r.bKa().wq(paramString.oGB);
          }
        }
      }
    }
    label1841:
    label3891:
    label3894:
    for (;;)
    {
      int i;
      if (((fi)localObject2).field_isSend == 1) {
        if (paramString.bJE())
        {
          i = 1;
          label1661:
          localObject2 = XmlParser.parseXml(paramString.oGC, "msg", null);
          if (localObject2 == null) {
            break label1841;
          }
          if (i == 1)
          {
            paramList.bss((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.yo(Util.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.bst((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramdn.hDr.hDt.vEn.add(paramList);
        paramString = paramdn.hDr.hDu;
        paramString.PTe += 1;
        bool1 = true;
        break;
        i = 0;
        break label1661;
        if (!paramString.bJE())
        {
          i = 0;
          break label1661;
        }
        localObject2 = com.tencent.mm.modelimage.i.a(paramString);
        if (!com.tencent.mm.vfs.y.ZC(r.bKa().v(((com.tencent.mm.modelimage.h)localObject2).oGr, "", "")))
        {
          i = 0;
          break label1661;
        }
        i = 1;
        break label1661;
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.oGC });
      }
      if ((((cc)localObject2).dSH()) || (((cc)localObject2).dSJ()))
      {
        if (paramInt == 10)
        {
          localObject3 = new arg();
          ((arg)localObject3).c(bo((cc)localObject2));
          paramString = new arf();
          paramString.bsG(bp((cc)localObject2));
          com.tencent.mm.modelvideo.v.bOh();
          paramString.bsC(com.tencent.mm.modelvideo.aa.PX(((fi)localObject2).field_imgPath));
          com.tencent.mm.modelvideo.v.bOh();
          paramString.bsD(com.tencent.mm.modelvideo.aa.PY(((fi)localObject2).field_imgPath));
          paramString.bsy(com.tencent.mm.vfs.y.alV(paramString.Zzd));
          if (((cc)localObject2).dSJ()) {
            paramString.axy(15);
          }
          for (;;)
          {
            paramList = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject2).field_imgPath);
            if (paramList != null) {
              break label2033;
            }
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
            paramdn.hDr.hDx = a.c.favorite_fail;
            bool1 = false;
            break;
            paramString.axy(4);
          }
          label2033:
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d maxFileLength:%s", new Object[] { Integer.valueOf(paramList.osy), Integer.valueOf(af.iIm()) });
          if (paramList.osy > af.iIm())
          {
            paramdn.hDr.hDx = a.c.favorite_too_large_format;
            bool1 = false;
            break label468;
          }
          if ((((cc)localObject2).dSJ()) && (com.tencent.mm.modelvideo.ab.Qp(paramList.getFileName())))
          {
            paramdn.hDr.hDx = a.c.favorite_fail;
            bool1 = false;
            break label468;
          }
          paramString.axx(paramList.omT);
          paramString.a((arg)localObject3);
          paramString.bsJ(a(((arg)localObject3).ZAf));
          paramString.bsK(b(((arg)localObject3).ZAf));
          if (au.bwO(((arg)localObject3).ZAf.ZAT))
          {
            localObject3 = ((arg)localObject3).ZAf.ZAT;
            localObject3 = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject3));
            if (!Util.isNullOrNil((String)localObject3)) {
              paramString.bsS((String)localObject3);
            }
          }
          paramString.yq(((fi)localObject2).field_msgId);
          paramString.bsW(bt.JV(((fi)localObject2).jUr));
          paramString.yo(paramList.osy);
          localObject3 = XmlParser.parseXml(paramList.bOu(), "msg", null);
          if (localObject3 != null)
          {
            paramString.bss((String)((Map)localObject3).get(".msg.videomsg.$cdnvideourl"));
            paramString.bst((String)((Map)localObject3).get(".msg.videomsg.$aeskey"));
          }
          for (;;)
          {
            paramdn.hDr.hDt.vEn.add(paramString);
            localObject3 = paramdn.hDr.hDu;
            ((asj)localObject3).AXs += 1;
            localObject2 = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject2).field_imgPath);
            paramList = XmlParser.parseXml(paramList.bOu(), "msg", null);
            if (paramList != null) {
              paramString.bsz((String)paramList.get(".msg.videomsg.$md5"));
            }
            paramString.bsM(((com.tencent.mm.modelvideo.z)localObject2).iah);
            paramList = ((com.tencent.mm.modelvideo.z)localObject2).pbk;
            if ((paramList != null) && (!Util.isNullOrNil(paramList.nTA)))
            {
              localObject2 = new ari();
              ((ari)localObject2).nTu = paramList.nTu;
              ((ari)localObject2).ZBc = paramList.ZBc;
              ((ari)localObject2).nTx = paramList.nTx;
              ((ari)localObject2).nTy = paramList.nTy;
              ((ari)localObject2).nTw = paramList.nTw;
              ((ari)localObject2).nTz = paramList.nTz;
              ((ari)localObject2).nTA = paramList.nTA;
              ((ari)localObject2).nTB = paramList.nTB;
              paramString.a((ari)localObject2);
            }
            bool1 = true;
            break;
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
          }
        }
        localObject3 = new arg();
        ((arg)localObject3).c(bo((cc)localObject2));
        paramString = new arf();
        paramString.bsG(bp((cc)localObject2));
        com.tencent.mm.modelvideo.v.bOh();
        paramString.bsC(com.tencent.mm.modelvideo.aa.PX(((fi)localObject2).field_imgPath));
        com.tencent.mm.modelvideo.v.bOh();
        paramString.bsD(com.tencent.mm.modelvideo.aa.PY(((fi)localObject2).field_imgPath));
        paramString.bsy(com.tencent.mm.vfs.y.alV(paramString.Zzd));
        if (((cc)localObject2).dSJ()) {
          paramString.axy(15);
        }
        for (;;)
        {
          paramList = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject2).field_imgPath);
          if (paramList != null) {
            break label2679;
          }
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
          paramdn.hDr.hDx = a.c.favorite_fail;
          bool1 = false;
          break;
          paramString.axy(4);
        }
        label2679:
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(paramList.osy) });
        if (paramList.osy > ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getVideoSizeLimit(true))
        {
          paramdn.hDr.hDx = a.c.favorite_too_large_format;
          bool1 = false;
          break label468;
        }
        if ((((cc)localObject2).dSJ()) && (com.tencent.mm.modelvideo.ab.Qp(paramList.getFileName())))
        {
          paramdn.hDr.hDx = a.c.favorite_fail;
          bool1 = false;
          break label468;
        }
        paramString.axx(paramList.omT);
        paramString.a((arg)localObject3);
        paramString.bsJ(a(((arg)localObject3).ZAf));
        paramString.bsK(b(((arg)localObject3).ZAf));
        if (au.bwO(((arg)localObject3).ZAf.ZAT))
        {
          localObject3 = ((arg)localObject3).ZAf.ZAT;
          localObject3 = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject3));
          if (!Util.isNullOrNil((String)localObject3)) {
            paramString.bsS((String)localObject3);
          }
        }
        paramString.yq(((fi)localObject2).field_msgId);
        paramString.bsW(bt.JV(((fi)localObject2).jUr));
        paramString.yo(paramList.osy);
        paramList = XmlParser.parseXml(paramList.bOu(), "msg", null);
        if (paramList != null)
        {
          paramString.bss((String)paramList.get(".msg.videomsg.$cdnvideourl"));
          paramString.bst((String)paramList.get(".msg.videomsg.$aeskey"));
        }
        for (;;)
        {
          paramdn.hDr.hDt.vEn.add(paramString);
          paramList = paramdn.hDr.hDu;
          paramList.AXs += 1;
          paramList = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject2).field_imgPath);
          paramString.bsM(paramList.iah);
          paramList = paramList.pbk;
          if ((paramList != null) && (!Util.isNullOrNil(paramList.nTA)))
          {
            localObject2 = new ari();
            ((ari)localObject2).nTu = paramList.nTu;
            ((ari)localObject2).ZBc = paramList.ZBc;
            ((ari)localObject2).nTx = paramList.nTx;
            ((ari)localObject2).nTy = paramList.nTy;
            ((ari)localObject2).nTw = paramList.nTw;
            ((ari)localObject2).nTz = paramList.nTz;
            ((ari)localObject2).nTA = paramList.nTA;
            ((ari)localObject2).nTB = paramList.nTB;
            paramString.a((ari)localObject2);
          }
          bool1 = true;
          break;
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
        }
      }
      if (((cc)localObject2).dSI())
      {
        bool1 = b(paramdn, (cc)localObject2);
        break label468;
      }
      if (((cc)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramdn, (cc)localObject2, 3);
        break label468;
      }
      if (((cc)localObject2).iYe())
      {
        bool1 = c(paramdn, (cc)localObject2);
        break label468;
      }
      if ((((cc)localObject2).jbG()) || (((cc)localObject2).jbH()))
      {
        bool1 = a(paramContext, paramdn, (cc)localObject2, 1);
        break label468;
      }
      if (((cc)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramdn, (cc)localObject2, 2);
        break label468;
      }
      if (((cc)localObject2).jbB())
      {
        paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLU(((fi)localObject2).field_content);
        paramList = new arg();
        paramList.c(bo((cc)localObject2));
        if ((paramString != null) && (com.tencent.mm.model.ab.uY(paramString.WAW)))
        {
          paramString = new arf();
          paramString.bsG(bp((cc)localObject2));
          paramString.axy(16);
          paramString.bsp(((fi)localObject2).field_content);
          paramString.Kk(true);
          paramString.Kj(true);
          paramString.a(paramList);
          paramString.bsJ(a(paramList.ZAf));
          paramString.bsK(b(paramList.ZAf));
          if (!au.bwO(paramList.ZAf.ZAT)) {
            break label3891;
          }
          paramList = paramList.ZAf.ZAT;
          paramList = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramList));
          if (!Util.isNullOrNil(paramList)) {
            paramString.bsS(paramList);
          }
        }
      }
      for (;;)
      {
        paramdn.hDr.hDt.vEn.add(paramString);
        paramString = paramdn.hDr.hDu;
        paramString.ZBU += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (au.bwO(paramString.hgk)))
        {
          paramString = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(paramString.adkD, "openim_card_type_name", e.a.prb);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(a.c.app_friend_card_personal);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((cc)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((cc)localObject2, paramContext.getString(a.c.app_friend_card_personal), paramList);
        continue;
        if (((cc)localObject2).jbC())
        {
          paramString = new arg();
          paramString.c(bo((cc)localObject2));
          paramList = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RD(((fi)localObject2).field_content);
          localObject3 = new arf();
          if (paramList != null) {
            ((arf)localObject3).bso(Util.nullAs(paramList.getDisplayName(), paramList.username));
          }
          ((arf)localObject3).bsG(bp((cc)localObject2));
          ((arf)localObject3).axy(31);
          ((arf)localObject3).bsp(((fi)localObject2).field_content);
          ((arf)localObject3).Kk(true);
          ((arf)localObject3).Kj(true);
          ((arf)localObject3).a(paramString);
          ((arf)localObject3).bsJ(a(paramString.ZAf));
          ((arf)localObject3).bsK(b(paramString.ZAf));
          paramdn.hDr.hDt.vEn.add(localObject3);
          paramString = paramdn.hDr.hDu;
          paramString.ZBU += 1;
          bool1 = true;
          break label468;
        }
        if (((cc)localObject2).fxR())
        {
          if (((cc)localObject2).jbH())
          {
            paramdn.hDr.hDx = a.c.favorite_fail_nonsupport;
            break label468;
          }
          bool1 = a(paramContext, paramdn, (cc)localObject2);
          break label468;
        }
        paramdn.hDr.hDx = a.c.favorite_fail_nonsupport;
        bool1 = a(paramContext, paramdn, (cc)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramdn.hDr.hDx > 0)) {
          paramdn.hDr.hDx = 0;
        }
        AppMethodBeat.o(305347);
        return bool2;
      }
    }
  }
  
  private static boolean a(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(9451);
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
          paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
          if (!Util.isNullOrNil(paramcc)) {
            ((arf)localObject).bsS(paramcc);
          }
        }
        paramdn.hDr.hDt.vEn.add(localObject);
        paramcc = paramdn.hDr.hDu;
        paramcc.ZBL += 1;
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception paramcc)
      {
        Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { paramcc.getStackTrace().toString() });
      }
    }
    paramdn.hDr.hDx = a.c.favorite_fail_parse_error;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static String b(arh paramarh)
  {
    AppMethodBeat.i(9449);
    paramarh = NAb.format(new Date(paramarh.createTime));
    AppMethodBeat.o(9449);
    return paramarh;
  }
  
  public static boolean b(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.aP(paramcc.field_content, paramcc.field_reserved);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new arv();
    Object localObject3 = new asb();
    ((asb)localObject3).bto(com.tencent.mm.model.z.bAM());
    ((asb)localObject3).btp(com.tencent.mm.model.z.bAM());
    ((asb)localObject3).axH(4);
    ((asb)localObject3).yu(Util.nowMilliSecond());
    ((asb)localObject3).btv(((k.b)localObject2).url);
    ((arv)localObject1).a((asb)localObject3);
    localObject1 = new arf();
    ((arf)localObject1).bsC("");
    ((arf)localObject1).bsx(((k.b)localObject2).thumburl);
    localObject3 = m.x(paramcc);
    if (localObject3 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((arf)localObject1).axx(((arn)localObject3).duration);
    ((arf)localObject1).bso(((k.b)localObject2).title);
    ((arf)localObject1).bsu(((k.b)localObject2).url);
    ((arf)localObject1).Kj(true);
    ((arf)localObject1).Kk(true);
    localObject2 = new arg();
    ((arg)localObject2).c(bo(paramcc));
    if (paramcc.dSI()) {
      ((arg)localObject2).e((arn)localObject3);
    }
    ((arf)localObject1).a((arg)localObject2);
    ((arf)localObject1).yq(paramcc.field_msgId);
    ((arf)localObject1).bsJ(a(((arg)localObject2).ZAf));
    ((arf)localObject1).bsK(b(((arg)localObject2).ZAf));
    if (au.bwO(((arg)localObject2).ZAf.ZAT))
    {
      paramcc = ((arg)localObject2).ZAf.ZAT;
      paramcc = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc));
      if (!Util.isNullOrNil(paramcc)) {
        ((arf)localObject1).bsS(paramcc);
      }
    }
    paramdn.hDr.hDt.vEn.add(localObject1);
    paramdn = paramdn.hDr.hDu;
    paramdn.AXs += 1;
    ((arf)localObject1).axy(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static arh bo(cc paramcc)
  {
    AppMethodBeat.i(9447);
    arh localarh = new arh();
    if (paramcc == null)
    {
      AppMethodBeat.o(9447);
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
          localObject = br.JP(paramcc.jUr).userId;
        }
        localarh.bta((String)localObject);
      }
      localarh.axC(1);
      localarh.yr(paramcc.getCreateTime());
      localarh.btb(paramcc.field_msgSvrId);
      if (paramcc.field_msgSvrId > 0L) {
        localarh.bsZ(paramcc.field_msgSvrId);
      }
      AppMethodBeat.o(9447);
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
    AppMethodBeat.i(9450);
    if (paramcc.field_isSend == 1)
    {
      if ((au.bwE(paramcc.field_talker)) || (paramcc.field_talker.equals("filehelper")))
      {
        paramcc = String.format("%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId) });
        AppMethodBeat.o(9450);
        return paramcc;
      }
      paramcc = String.format("%s#%d", new Object[] { paramcc.field_talker, Long.valueOf(paramcc.field_msgSvrId) });
      AppMethodBeat.o(9450);
      return paramcc;
    }
    long l = paramcc.field_msgSvrId;
    AppMethodBeat.o(9450);
    return String.valueOf(l);
  }
  
  private static boolean c(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(9457);
    try
    {
      com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
      Object localObject1 = localu.nUC;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          com.tencent.mm.message.v localv = (com.tencent.mm.message.v)((Iterator)localObject1).next();
          if (!m.Hh(localv.nUR))
          {
            arg localarg = new arg();
            localarg.c(bo(paramcc));
            localarg.ZAf.bte(localu.iaa);
            localarg.ZAf.btd(localv.url);
            Object localObject2 = new arf();
            ((arf)localObject2).bso(localv.title);
            ((arf)localObject2).bsp(localv.nUO);
            ((arf)localObject2).bsG(bp(paramcc));
            if (!Util.isNullOrNil(localv.nUM)) {
              ((arf)localObject2).bsD(com.tencent.mm.pluginsdk.model.y.bpF(localv.nUM));
            }
            for (;;)
            {
              ((arf)localObject2).Kj(true);
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
              ((arf)localObject2).axy(5);
              ((arf)localObject2).a(localarg);
              ((arf)localObject2).bsJ(a(localarg.ZAf));
              ((arf)localObject2).bsK(b(localarg.ZAf));
              if (au.bwO(localarg.ZAf.ZAT))
              {
                String str = localarg.ZAf.ZAT;
                str = com.tencent.mm.openim.room.a.a.X(((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str));
                if (!Util.isNullOrNil(str)) {
                  ((arf)localObject2).bsS(str);
                }
              }
              paramdn.hDr.hDt.vEn.add(localObject2);
              localObject2 = paramdn.hDr.hDu;
              ((asj)localObject2).ZBK += 1;
              localarg.d(m.a(localv, localask, localu.iaa, localu.iab));
              i += 1;
              break;
              ((arf)localObject2).Kk(true);
            }
          }
        }
      }
      if (i != 0) {
        break label558;
      }
    }
    catch (Exception paramcc)
    {
      Log.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", paramcc, "", new Object[0]);
      Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { paramcc.getLocalizedMessage() });
      paramdn.hDr.hDx = a.c.favorite_fail_parse_error;
      AppMethodBeat.o(9457);
      return false;
    }
    paramdn.hDr.hDx = a.c.favorite_fail_nonsupport;
    AppMethodBeat.o(9457);
    return false;
    label558:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.c
 * JD-Core Version:    0.7.0.1
 */