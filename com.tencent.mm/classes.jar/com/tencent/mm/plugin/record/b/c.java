package com.tencent.mm.plugin.record.b;

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
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
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
  private static final SimpleDateFormat BGt;
  
  static
  {
    AppMethodBeat.i(9458);
    BGt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    AppMethodBeat.o(9458);
  }
  
  private static aml a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(9454);
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
      AppMethodBeat.o(9454);
      return localaml;
      localaml.At(true);
    }
  }
  
  private static aml a(ca paramca, String paramString, amm paramamm)
  {
    AppMethodBeat.i(9455);
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
      paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        localaml.bgJ(paramca);
      }
    }
    AppMethodBeat.o(9455);
    return localaml;
  }
  
  private static String a(amn paramamn)
  {
    AppMethodBeat.i(9448);
    String str2 = paramamn.LxA;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = paramamn.dRL;
    }
    if (com.tencent.mm.al.a.e.NF(str1))
    {
      paramamn = com.tencent.mm.al.a.e.NH(str1);
      AppMethodBeat.o(9448);
      return paramamn;
    }
    paramamn = com.tencent.mm.model.aa.Ir(str1);
    AppMethodBeat.o(9448);
    return paramamn;
  }
  
  private static boolean a(Context paramContext, cz paramcz, ca paramca)
  {
    AppMethodBeat.i(9456);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(9456);
      return false;
    }
    localObject1 = k.b.HD((String)localObject1);
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(9456);
      return false;
    }
    localamm.LwO.bgT(((k.b)localObject1).appId);
    localamm.LwO.bgV(((k.b)localObject1).eag);
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).NA()))
    {
      paramContext = a(paramca, paramContext.getString(2131755865), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    }
    switch (((k.b)localObject1).type)
    {
    default: 
      paramContext = a(paramca, paramContext.getString(2131755990), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 1: 
    case 53: 
    case 57: 
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
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyp += 1;
      AppMethodBeat.o(9456);
      return true;
    case 2: 
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.r.a.cgO().bdx(((k.b)localObject1).dCK);
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
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyq += 1;
      AppMethodBeat.o(9456);
      return true;
    case 3: 
      paramContext = a(paramca, (k.b)localObject1, 7);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      if (((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class) != null)
      {
        paramContext.bgL(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songAlbumUrl);
        paramContext.bgM(((com.tencent.mm.pluginsdk.ui.tools.b)((k.b)localObject1).as(com.tencent.mm.pluginsdk.ui.tools.b.class)).songLyric);
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyu += 1;
      AppMethodBeat.o(9456);
      return true;
    case 76: 
      paramContext = a(paramca, (k.b)localObject1, 29);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
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
      AppMethodBeat.o(9456);
      return true;
    case 4: 
      paramContext = a(paramca, (k.b)localObject1, 4);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      paramContext.bgN(br.KB(paramca.fqK));
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.xiP += 1;
      AppMethodBeat.o(9456);
      return true;
    case 5: 
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
          localObject2 = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject2));
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
        localamm.d(m.a(paramca, (anq)localObject2));
        AppMethodBeat.o(9456);
        return true;
      }
      paramcz.dFZ.dGe = 2131759213;
      paramContext = a(paramca, paramContext.getString(2131755990), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 51: 
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
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 63: 
      paramContext = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).as(com.tencent.mm.plugin.i.a.b.class);
      if (paramContext != null)
      {
        paramContext = paramContext.wDV;
        localObject1 = new aml();
        ((aml)localObject1).bgA(a(localamm.LwO));
        ((aml)localObject1).bgB(b(localamm.LwO));
        ((aml)localObject1).bgx(aM(paramca));
        ((aml)localObject1).As(true);
        ((aml)localObject1).bgf(paramContext.nickName + MMApplicationContext.getContext().getString(2131759332));
        ((aml)localObject1).bgg(paramContext.desc);
        ((aml)localObject1).ajd(23);
        localamm.e(paramContext);
        ((aml)localObject1).a(localamm);
        paramcz.dFZ.dGb.ppH.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 59: 
    case 72: 
      paramContext = (com.tencent.mm.plugin.i.a.h)((k.b)localObject1).as(com.tencent.mm.plugin.i.a.h.class);
      if (paramContext != null)
      {
        paramContext = paramContext.jld;
        localObject1 = new aml();
        ((aml)localObject1).bgA(a(localamm.LwO));
        ((aml)localObject1).bgB(b(localamm.LwO));
        ((aml)localObject1).bgx(aM(paramca));
        ((aml)localObject1).As(true);
        if (paramContext.tvC == 1) {
          ((aml)localObject1).bgf(MMApplicationContext.getContext().getString(2131764281, new Object[] { paramContext.dST }));
        }
        for (;;)
        {
          ((aml)localObject1).bgg(paramContext.desc);
          ((aml)localObject1).ajd(27);
          localamm.c(paramContext);
          ((aml)localObject1).a(localamm);
          paramcz.dFZ.dGb.ppH.add(localObject1);
          AppMethodBeat.o(9456);
          return true;
          ((aml)localObject1).bgf(paramContext.dST);
        }
      }
      AppMethodBeat.o(9456);
      return false;
    case 50: 
      paramContext = (com.tencent.mm.plugin.i.a.e)((k.b)localObject1).as(com.tencent.mm.plugin.i.a.e.class);
      if (paramContext != null)
      {
        localObject1 = paramContext.wDW;
        localObject2 = new aml();
        ((aml)localObject2).bgA(a(localamm.LwO));
        ((aml)localObject2).bgB(b(localamm.LwO));
        ((aml)localObject2).bgx(aM(paramca));
        ((aml)localObject2).As(true);
        ((aml)localObject2).bgf(paramContext.nickname);
        ((aml)localObject2).ajd(26);
        localamm.a((bci)localObject1);
        ((aml)localObject2).a(localamm);
        paramcz.dFZ.dGb.ppH.add(localObject2);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 73: 
      paramContext = (com.tencent.mm.plugin.i.a.d)((k.b)localObject1).as(com.tencent.mm.plugin.i.a.d.class);
      if (paramContext != null)
      {
        paramContext = paramContext.jle;
        localObject1 = new aml();
        ((aml)localObject1).bgA(a(localamm.LwO));
        ((aml)localObject1).bgB(b(localamm.LwO));
        ((aml)localObject1).bgx(aM(paramca));
        ((aml)localObject1).As(true);
        ((aml)localObject1).bgf(paramContext.title);
        ((aml)localObject1).bgg(paramContext.oqZ);
        ((aml)localObject1).ajd(28);
        localamm.c(paramContext);
        ((aml)localObject1).a(localamm);
        paramcz.dFZ.dGb.ppH.add(localObject1);
        AppMethodBeat.o(9456);
        return true;
      }
      AppMethodBeat.o(9456);
      return false;
    case 6: 
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(9456);
        return false;
      }
      localObject2 = com.tencent.mm.plugin.r.a.cgO().bdx(((k.b)localObject1).dCK);
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
      paramContext.Mu(((k.b)localObject1).iwI);
      paramContext.bgq(((k.b)localObject1).filemd5);
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramContext.bgj(((k.b)localObject1).iwW);
      paramContext.bgk(((k.b)localObject1).aesKey);
      paramContext.bgI(((k.b)localObject1).iwN);
      paramContext.bgG(((k.b)localObject1).aesKey);
      paramContext.bgH(((k.b)localObject1).iwT);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.fileCount += 1;
      AppMethodBeat.o(9456);
      return true;
    case 7: 
      if ((((k.b)localObject1).dCK == null) || (((k.b)localObject1).dCK.length() == 0)) {
        paramcz.dFZ.dGe = 2131759210;
      }
      do
      {
        paramcz.dFZ.dGe = 2131759217;
        AppMethodBeat.o(9456);
        return false;
        com.tencent.mm.kernel.g.aAi();
      } while (com.tencent.mm.kernel.g.aAh().isSDCardAvailable());
      paramcz.dFZ.dGe = 2131759225;
      AppMethodBeat.o(9456);
      return false;
    case 10: 
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
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyw += 1;
      AppMethodBeat.o(9456);
      return true;
    case 20: 
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
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.LyA += 1;
      AppMethodBeat.o(9456);
      return true;
    case 13: 
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
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      paramContext = paramcz.dFZ.dGc;
      paramContext.Lyx += 1;
      AppMethodBeat.o(9456);
      return true;
    case 46: 
      paramContext = a(paramca, paramContext.getString(2131755919), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 33: 
    case 36: 
      if (((k.b)localObject1).izk == 3)
      {
        paramContext = a(paramca, paramContext.getString(2131755919), localamm);
        paramcz.dFZ.dGb.ppH.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
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
      ((amj)localObject2).type = ((k.b)localObject1).izk;
      ((amj)localObject2).dMe = ((k.b)localObject1).izz;
      ((amj)localObject2).dCx = ((k.b)localObject1).izh;
      ((amj)localObject2).Lve = ((k.b)localObject1).eah;
      ((amj)localObject2).lyE = ((k.b)localObject1).izr;
      localObject1 = (com.tencent.mm.ag.a)((k.b)localObject1).as(com.tencent.mm.ag.a.class);
      if (localObject1 != null)
      {
        ((amj)localObject2).leb = ((com.tencent.mm.ag.a)localObject1).ivc;
        ((amj)localObject2).eda = ((com.tencent.mm.ag.a)localObject1).ive;
        ((amj)localObject2).subType = ((com.tencent.mm.ag.a)localObject1).ivf;
      }
      localamm.b((amj)localObject2);
      paramContext.a(localamm);
      paramContext.bgA(a(localamm.LwO));
      paramContext.bgB(b(localamm.LwO));
      paramContext.Mw(paramca.field_msgId);
      if (as.bjp(localamm.LwO.LxA))
      {
        paramca = localamm.LwO.LxA;
        paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
        if (!Util.isNullOrNil(paramca)) {
          paramContext.bgJ(paramca);
        }
      }
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 48: 
      paramContext = a(paramca, paramContext.getString(2131755867) + ((k.b)localObject1).title, localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 44: 
      localObject2 = ((k.b)localObject1).w(paramContext, true);
      if (Util.isNullOrNil((String)localObject2))
      {
        paramContext = a(paramca, paramContext.getString(2131755990), localamm);
        paramcz.dFZ.dGb.ppH.add(paramContext);
        AppMethodBeat.o(9456);
        return true;
      }
      paramContext = a(paramca, (String)localObject2 + ((k.b)localObject1).title, localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
    case 19: 
      int i;
      if ((((k.b)localObject1).ixl != null) && (((k.b)localObject1).ixl.contains("<recordxml>"))) {
        i = 1;
      }
      while (i == 0)
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
        if (localObject1 != null)
        {
          localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject1).iAd.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext()) {
              if (!Util.isNullOrNil(((aml)((Iterator)localObject3).next()).LwF))
              {
                paramcz.dFZ.dGe = 2131759217;
                AppMethodBeat.o(9456);
                return false;
                i = 0;
                break;
              }
            }
          }
        }
        if (localObject1 == null) {
          break label5080;
        }
        paramContext = ((com.tencent.mm.protocal.b.a.c)localObject1).desc;
      }
    }
    label5080:
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
        paramContext = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramContext));
        if (!Util.isNullOrNil(paramContext)) {
          ((aml)localObject2).bgJ(paramContext);
        }
      }
      paramcz.dFZ.dGb.ppH.add(localObject2);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramca, paramContext.getString(2131759362), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      paramContext = a(paramca, paramContext.getString(2131755949), localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9456);
      return true;
      com.tencent.mm.plugin.i.a.l.d(((k.b)localObject1).izF, ((k.b)localObject1).izD);
      break;
    }
  }
  
  private static boolean a(Context paramContext, cz paramcz, ca paramca, int paramInt)
  {
    AppMethodBeat.i(9446);
    amm localamm = new amm();
    localamm.c(aL(paramca));
    String str = null;
    if (paramInt == 1) {
      str = paramContext.getString(2131755793);
    }
    for (;;)
    {
      paramContext = a(paramca, str, localamm);
      paramcz.dFZ.dGb.ppH.add(paramContext);
      AppMethodBeat.o(9446);
      return true;
      if (paramInt == 2) {
        str = paramContext.getString(2131755925);
      } else if (paramInt == 3) {
        str = paramContext.getString(2131755990);
      }
    }
  }
  
  public static boolean a(Context paramContext, cz paramcz, String paramString, List<ca> paramList, int paramInt)
  {
    AppMethodBeat.i(215180);
    if ((paramList == null) || (paramList.isEmpty()) || (paramContext == null))
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msgs is null");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(215180);
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
    boolean bool1 = com.tencent.mm.al.g.DQ(paramString);
    paramList.size();
    paramcz.dFZ.dGb = new anb();
    paramcz.dFZ.dGc = new anp();
    int j;
    boolean bool2;
    if (paramContext != null)
    {
      if (!bool1) {
        break label531;
      }
      localObject1 = com.tencent.mm.al.a.e.At(((ca)paramList.get(0)).field_bizChatId);
      if (com.tencent.mm.al.a.e.NG((String)localObject1))
      {
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131764266));
        Log.d("MicroMsg.GetFavRecordDataSourceForRecordMsg", "title %s", new Object[] { paramcz.dFZ.dGb.title });
      }
    }
    else
    {
      localObject1 = paramcz.dFZ.dGb;
      localObject2 = new anh();
      ((anh)localObject2).bhf(paramString);
      ((anh)localObject2).ajm(1);
      ((anh)localObject2).MA(Util.nowMilliSecond());
      ((anh)localObject2).bhh("");
      ((anb)localObject1).a((anh)localObject2);
      paramcz.dFZ.type = 14;
      localObject1 = paramList.iterator();
      j = 0;
      bool2 = true;
      label421:
      if (!((Iterator)localObject1).hasNext()) {
        break label3628;
      }
      paramString = (ca)((Iterator)localObject1).next();
      if (paramString != null) {
        break label650;
      }
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "fill favorite event fail, event or msg is null");
      paramcz.dFZ.dGe = 2131759209;
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
        localObject2 = com.tencent.mm.al.a.e.NJ(paramString);
        if (localObject2 == null) {
          break;
        }
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131759287, new Object[] { ((k)localObject2).field_userName, com.tencent.mm.al.a.e.NH((String)localObject1) }));
        break;
        label531:
        if (ab.Eq(paramString))
        {
          paramcz.dFZ.dGb.bhd(paramContext.getString(2131764266));
          break;
        }
        localObject1 = Util.nullAsNil(com.tencent.mm.model.z.aUa());
        if (((String)localObject1).equals(Util.nullAsNil(com.tencent.mm.model.aa.Ir(paramString))))
        {
          paramcz.dFZ.dGb.bhd(paramContext.getString(2131759288, new Object[] { localObject1 }));
          break;
        }
        paramcz.dFZ.dGb.bhd(paramContext.getString(2131759287, new Object[] { com.tencent.mm.model.z.aUa(), com.tencent.mm.model.aa.Ir(paramString) }));
        break;
        label650:
        localObject2 = ca.aZ(paramString);
        bool1 = false;
        if (br.Q((ca)localObject2))
        {
          paramString = new amm();
          paramString.c(aL((ca)localObject2));
          paramString = a((ca)localObject2, paramContext.getString(2131755901), paramString);
          paramcz.dFZ.dGb.ppH.add(paramString);
          bool1 = true;
        }
        else
        {
          if (((ca)localObject2).isText())
          {
            localObject3 = new amm();
            ((amm)localObject3).c(aL((ca)localObject2));
            paramList = new aml();
            paramList.bgx(aM((ca)localObject2));
            paramList.ajd(1);
            if (((ca)localObject2).gDV()) {}
            for (paramString = MMApplicationContext.getContext().getString(2131764740, new Object[] { "@" }) + '\n';; paramString = "")
            {
              paramList.bgg(paramString + ((eo)localObject2).field_content);
              paramList.At(true);
              paramList.As(true);
              paramList.a((amm)localObject3);
              paramList.bgA(a(((amm)localObject3).LwO));
              paramList.bgB(b(((amm)localObject3).LwO));
              if (as.bjp(((amm)localObject3).LwO.LxA))
              {
                paramString = ((amm)localObject3).LwO.LxA;
                paramString = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString));
                if (!Util.isNullOrNil(paramString)) {
                  paramList.bgJ(paramString);
                }
              }
              paramcz.dFZ.dGb.ppH.add(paramList);
              paramString = paramcz.dFZ.dGc;
              paramString.Lyp += 1;
              bool1 = true;
              break;
            }
          }
          if (((ca)localObject2).gAy())
          {
            paramList = new amm();
            paramList.c(aL((ca)localObject2));
            paramString = new aml();
            paramString.bgx(aM((ca)localObject2));
            paramString.ajd(3);
            paramString.At(true);
            paramString.As(true);
            paramString.a(paramList);
            paramString.bgA(a(paramList.LwO));
            paramString.bgB(b(paramList.LwO));
            if (as.bjp(paramList.LwO.LxA))
            {
              paramList = paramList.LwO.LxA;
              paramList = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramList));
              if (!Util.isNullOrNil(paramList)) {
                paramString.bgJ(paramList);
              }
            }
            paramcz.dFZ.dGb.ppH.add(paramString);
            paramString = paramcz.dFZ.dGc;
            paramString.Lyr += 1;
            bool1 = true;
          }
          else if (((ca)localObject2).dOS())
          {
            bool1 = a(paramcz, (ca)localObject2);
          }
          else if (((ca)localObject2).gAz())
          {
            paramList = null;
            if (((eo)localObject2).field_msgId > 0L) {
              paramList = q.bcR().H(((eo)localObject2).field_talker, (int)((eo)localObject2).field_msgId);
            }
            if (paramList != null)
            {
              paramString = paramList;
              if (paramList.localId > 0L) {}
            }
            else
            {
              paramString = paramList;
              if (((eo)localObject2).field_msgSvrId > 0L) {
                paramString = q.bcR().G(((eo)localObject2).field_talker, ((eo)localObject2).field_msgSvrId);
              }
            }
            if (paramString == null)
            {
              Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "getImgDataPath: try get imgInfo fail");
              paramcz.dFZ.dGe = 2131759215;
              bool1 = false;
              continue;
            }
            localObject3 = new amm();
            ((amm)localObject3).c(aL((ca)localObject2));
            paramList = new aml();
            paramList.bgx(aM((ca)localObject2));
            paramList.ajd(2);
            paramList.bgt(q.bcR().o(com.tencent.mm.av.h.c(paramString), "", ""));
            if (paramString.bcv())
            {
              com.tencent.mm.av.g localg = q.bcR().tl(paramString.iXx);
              if (localg.iKP > localg.offset) {
                paramList.bgt(q.bcR().o("SERVERID://" + ((eo)localObject2).field_msgSvrId, "", ""));
              }
            }
            paramList.bgu(q.bcR().R(((eo)localObject2).field_imgPath, true));
            paramList.a((amm)localObject3);
            paramList.bgA(a(((amm)localObject3).LwO));
            paramList.bgB(b(((amm)localObject3).LwO));
            paramList.Mw(((eo)localObject2).field_msgId);
            paramList.bgN(br.KB(((eo)localObject2).fqK));
            if (as.bjp(((amm)localObject3).LwO.LxA))
            {
              localObject3 = ((amm)localObject3).LwO.LxA;
              localObject3 = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject3));
              if (!Util.isNullOrNil((String)localObject3)) {
                paramList.bgJ((String)localObject3);
              }
            }
            if ((!paramString.bcv()) || (paramString.iKP != 0)) {
              break label3663;
            }
            paramString = q.bcR().tl(paramString.iXx);
          }
        }
      }
    }
    label1805:
    label1997:
    label3663:
    for (;;)
    {
      int i;
      if (((eo)localObject2).field_isSend == 1) {
        if (paramString.bcv())
        {
          i = 1;
          label1625:
          localObject2 = XmlParser.parseXml(paramString.iXy, "msg", null);
          if (localObject2 == null) {
            break label1805;
          }
          if (i == 1)
          {
            paramList.bgj((String)((Map)localObject2).get(".msg.img.$cdnbigimgurl"));
            paramList.Mu(Util.getInt((String)((Map)localObject2).get(".msg.img.$length"), 0));
            paramList.bgk((String)((Map)localObject2).get(".msg.img.$aeskey"));
          }
        }
      }
      for (;;)
      {
        paramcz.dFZ.dGb.ppH.add(paramList);
        paramString = paramcz.dFZ.dGc;
        paramString.Lyq += 1;
        bool1 = true;
        break;
        i = 0;
        break label1625;
        if (!paramString.bcv())
        {
          i = 0;
          break label1625;
        }
        localObject2 = com.tencent.mm.av.h.a(paramString);
        if (!com.tencent.mm.vfs.s.YS(q.bcR().o(((com.tencent.mm.av.g)localObject2).iXm, "", "")))
        {
          i = 0;
          break label1625;
        }
        i = 1;
        break label1625;
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse cdnInfo failed. [%s]", new Object[] { paramString.iXy });
      }
      if ((((ca)localObject2).cWJ()) || (((ca)localObject2).cWL()))
      {
        if (paramInt == 10)
        {
          localObject3 = new amm();
          ((amm)localObject3).c(aL((ca)localObject2));
          paramString = new aml();
          paramString.bgx(aM((ca)localObject2));
          com.tencent.mm.modelvideo.o.bhj();
          paramString.bgt(t.Qw(((eo)localObject2).field_imgPath));
          com.tencent.mm.modelvideo.o.bhj();
          paramString.bgu(t.Qx(((eo)localObject2).field_imgPath));
          paramString.bgp(com.tencent.mm.vfs.s.akC(paramString.LvL));
          if (((ca)localObject2).cWL()) {
            paramString.ajd(15);
          }
          for (;;)
          {
            paramList = com.tencent.mm.modelvideo.u.QN(((eo)localObject2).field_imgPath);
            if (paramList != null) {
              break label1997;
            }
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
            paramcz.dFZ.dGe = 2131759208;
            bool1 = false;
            break;
            paramString.ajd(4);
          }
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d maxFileLength:%s", new Object[] { Integer.valueOf(paramList.iKP), Integer.valueOf(com.tencent.mm.pluginsdk.model.z.gmL()) });
          if (paramList.iKP > com.tencent.mm.pluginsdk.model.z.gmL())
          {
            paramcz.dFZ.dGe = 2131759351;
            bool1 = false;
            break label468;
          }
          if ((((ca)localObject2).cWL()) && (com.tencent.mm.modelvideo.u.QO(paramList.getFileName())))
          {
            paramcz.dFZ.dGe = 2131759208;
            bool1 = false;
            break label468;
          }
          paramString.ajc(paramList.iFw);
          paramString.a((amm)localObject3);
          paramString.bgA(a(((amm)localObject3).LwO));
          paramString.bgB(b(((amm)localObject3).LwO));
          if (as.bjp(((amm)localObject3).LwO.LxA))
          {
            localObject3 = ((amm)localObject3).LwO.LxA;
            localObject3 = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject3));
            if (!Util.isNullOrNil((String)localObject3)) {
              paramString.bgJ((String)localObject3);
            }
          }
          paramString.Mw(((eo)localObject2).field_msgId);
          paramString.bgN(br.KB(((eo)localObject2).fqK));
          paramString.Mu(paramList.iKP);
          localObject3 = XmlParser.parseXml(paramList.bhv(), "msg", null);
          if (localObject3 != null)
          {
            paramString.bgj((String)((Map)localObject3).get(".msg.videomsg.$cdnvideourl"));
            paramString.bgk((String)((Map)localObject3).get(".msg.videomsg.$aeskey"));
          }
          for (;;)
          {
            paramcz.dFZ.dGb.ppH.add(paramString);
            localObject3 = paramcz.dFZ.dGc;
            ((anp)localObject3).xiP += 1;
            localObject2 = com.tencent.mm.modelvideo.u.QN(((eo)localObject2).field_imgPath);
            paramList = XmlParser.parseXml(paramList.bhv(), "msg", null);
            if (paramList != null) {
              paramString.bgq((String)paramList.get(".msg.videomsg.$md5"));
            }
            paramString.bgD(((com.tencent.mm.modelvideo.s)localObject2).ean);
            paramList = ((com.tencent.mm.modelvideo.s)localObject2).jsw;
            if ((paramList != null) && (!Util.isNullOrNil(paramList.izf)))
            {
              localObject2 = new amo();
              ((amo)localObject2).iyZ = paramList.iyZ;
              ((amo)localObject2).LxJ = paramList.LxJ;
              ((amo)localObject2).izc = paramList.izc;
              ((amo)localObject2).izd = paramList.izd;
              ((amo)localObject2).izb = paramList.izb;
              ((amo)localObject2).ize = paramList.ize;
              ((amo)localObject2).izf = paramList.izf;
              ((amo)localObject2).izg = paramList.izg;
              paramString.a((amo)localObject2);
            }
            bool1 = true;
            break;
            Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
          }
        }
        localObject3 = new amm();
        ((amm)localObject3).c(aL((ca)localObject2));
        paramString = new aml();
        paramString.bgx(aM((ca)localObject2));
        com.tencent.mm.modelvideo.o.bhj();
        paramString.bgt(t.Qw(((eo)localObject2).field_imgPath));
        com.tencent.mm.modelvideo.o.bhj();
        paramString.bgu(t.Qx(((eo)localObject2).field_imgPath));
        paramString.bgp(com.tencent.mm.vfs.s.akC(paramString.LvL));
        if (((ca)localObject2).cWL()) {
          paramString.ajd(15);
        }
        for (;;)
        {
          paramList = com.tencent.mm.modelvideo.u.QN(((eo)localObject2).field_imgPath);
          if (paramList != null) {
            break label2643;
          }
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video info null");
          paramcz.dFZ.dGe = 2131759208;
          bool1 = false;
          break;
          paramString.ajd(4);
        }
        label2643:
        Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "video length is %d", new Object[] { Integer.valueOf(paramList.iKP) });
        if (paramList.iKP > ((af)com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(true))
        {
          paramcz.dFZ.dGe = 2131759351;
          bool1 = false;
          break label468;
        }
        if ((((ca)localObject2).cWL()) && (com.tencent.mm.modelvideo.u.QO(paramList.getFileName())))
        {
          paramcz.dFZ.dGe = 2131759208;
          bool1 = false;
          break label468;
        }
        paramString.ajc(paramList.iFw);
        paramString.a((amm)localObject3);
        paramString.bgA(a(((amm)localObject3).LwO));
        paramString.bgB(b(((amm)localObject3).LwO));
        if (as.bjp(((amm)localObject3).LwO.LxA))
        {
          localObject3 = ((amm)localObject3).LwO.LxA;
          localObject3 = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject3));
          if (!Util.isNullOrNil((String)localObject3)) {
            paramString.bgJ((String)localObject3);
          }
        }
        paramString.Mw(((eo)localObject2).field_msgId);
        paramString.bgN(br.KB(((eo)localObject2).fqK));
        paramString.Mu(paramList.iKP);
        paramList = XmlParser.parseXml(paramList.bhv(), "msg", null);
        if (paramList != null)
        {
          paramString.bgj((String)paramList.get(".msg.videomsg.$cdnvideourl"));
          paramString.bgk((String)paramList.get(".msg.videomsg.$aeskey"));
        }
        for (;;)
        {
          paramcz.dFZ.dGb.ppH.add(paramString);
          paramList = paramcz.dFZ.dGc;
          paramList.xiP += 1;
          paramList = com.tencent.mm.modelvideo.u.QN(((eo)localObject2).field_imgPath);
          paramString.bgD(paramList.ean);
          paramList = paramList.jsw;
          if ((paramList != null) && (!Util.isNullOrNil(paramList.izf)))
          {
            localObject2 = new amo();
            ((amo)localObject2).iyZ = paramList.iyZ;
            ((amo)localObject2).LxJ = paramList.LxJ;
            ((amo)localObject2).izc = paramList.izc;
            ((amo)localObject2).izd = paramList.izd;
            ((amo)localObject2).izb = paramList.izb;
            ((amo)localObject2).ize = paramList.ize;
            ((amo)localObject2).izf = paramList.izf;
            ((amo)localObject2).izg = paramList.izg;
            paramString.a((amo)localObject2);
          }
          bool1 = true;
          break;
          Log.i("MicroMsg.GetFavRecordDataSourceForRecordMsg", "cdntra parse video recv xml failed");
        }
      }
      if (((ca)localObject2).cWK())
      {
        bool1 = b(paramcz, (ca)localObject2);
        break label468;
      }
      if (((ca)localObject2).getType() == 318767153)
      {
        bool1 = a(paramContext, paramcz, (ca)localObject2, 3);
        break label468;
      }
      if (((ca)localObject2).gAt())
      {
        bool1 = c(paramcz, (ca)localObject2);
        break label468;
      }
      if ((((ca)localObject2).gDn()) || (((ca)localObject2).gDo()))
      {
        bool1 = a(paramContext, paramcz, (ca)localObject2, 1);
        break label468;
      }
      if (((ca)localObject2).getType() == 419430449)
      {
        bool1 = a(paramContext, paramcz, (ca)localObject2, 2);
        break label468;
      }
      if (((ca)localObject2).gDl())
      {
        paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(((eo)localObject2).field_content);
        paramList = new amm();
        paramList.c(aL((ca)localObject2));
        if ((paramString != null) && (ab.rR(paramString.IOs)))
        {
          paramString = new aml();
          paramString.bgx(aM((ca)localObject2));
          paramString.ajd(16);
          paramString.bgg(((eo)localObject2).field_content);
          paramString.At(true);
          paramString.As(true);
          paramString.a(paramList);
          paramString.bgA(a(paramList.LwO));
          paramString.bgB(b(paramList.LwO));
          if (!as.bjp(paramList.LwO.LxA)) {
            break label3660;
          }
          paramList = paramList.LwO.LxA;
          paramList = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramList));
          if (!Util.isNullOrNil(paramList)) {
            paramString.bgJ(paramList);
          }
        }
      }
      for (;;)
      {
        paramcz.dFZ.dGb.ppH.add(paramString);
        paramString = paramcz.dFZ.dGc;
        paramString.LyB += 1;
        bool1 = true;
        break label468;
        if ((paramString != null) && (as.bjp(paramString.dkU)))
        {
          paramString = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(paramString.OqO, "openim_card_type_name", a.a.jGS);
          if (TextUtils.isEmpty(paramString)) {}
          for (paramString = paramContext.getResources().getString(2131755864);; paramString = String.format("[%s]", new Object[] { paramString }))
          {
            paramString = a((ca)localObject2, paramString, paramList);
            break;
          }
        }
        paramString = a((ca)localObject2, paramContext.getString(2131755864), paramList);
        continue;
        if (((ca)localObject2).dOQ())
        {
          if (((ca)localObject2).gDo())
          {
            paramcz.dFZ.dGe = 2131759217;
            break label468;
          }
          bool1 = a(paramContext, paramcz, (ca)localObject2);
          break label468;
        }
        paramcz.dFZ.dGe = 2131759217;
        bool1 = a(paramContext, paramcz, (ca)localObject2, 3);
        break label468;
        bool2 = false;
        break;
        if ((j != 0) && (paramcz.dFZ.dGe > 0)) {
          paramcz.dFZ.dGe = 0;
        }
        AppMethodBeat.o(215180);
        return bool2;
      }
    }
  }
  
  private static boolean a(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(9451);
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
          paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
          if (!Util.isNullOrNil(paramca)) {
            ((aml)localObject).bgJ(paramca);
          }
        }
        paramcz.dFZ.dGb.ppH.add(localObject);
        paramca = paramcz.dFZ.dGc;
        paramca.Lyt += 1;
        AppMethodBeat.o(9451);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramcz.dFZ.dGe = 2131759219;
    AppMethodBeat.o(9451);
    return false;
  }
  
  private static amn aL(ca paramca)
  {
    AppMethodBeat.i(9447);
    amn localamn = new amn();
    if (paramca == null)
    {
      AppMethodBeat.o(9447);
      return localamn;
    }
    Object localObject;
    if (paramca.field_isSend == 0)
    {
      localamn.bgO(paramca.field_talker);
      localamn.bgP(com.tencent.mm.model.z.aTY());
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
      AppMethodBeat.o(9447);
      return localamn;
      label367:
      localObject = "";
      break;
      localamn.bgO(com.tencent.mm.model.z.aTY());
      localamn.bgP(paramca.field_talker);
      if (ab.Eq(paramca.field_talker)) {
        localamn.bgR(localamn.dRL);
      }
    }
  }
  
  private static String aM(ca paramca)
  {
    AppMethodBeat.i(9450);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Eq(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
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
  
  private static String b(amn paramamn)
  {
    AppMethodBeat.i(9449);
    paramamn = BGt.format(new Date(paramamn.createTime));
    AppMethodBeat.o(9449);
    return paramamn;
  }
  
  public static boolean b(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(9452);
    Object localObject2 = k.b.aD(paramca.field_content, paramca.field_reserved);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(9452);
      return false;
    }
    Object localObject1 = new anb();
    Object localObject3 = new anh();
    ((anh)localObject3).bhf(com.tencent.mm.model.z.aTY());
    ((anh)localObject3).bhg(com.tencent.mm.model.z.aTY());
    ((anh)localObject3).ajm(4);
    ((anh)localObject3).MA(Util.nowMilliSecond());
    ((anh)localObject3).bhm(((k.b)localObject2).url);
    ((anb)localObject1).a((anh)localObject3);
    localObject1 = new aml();
    ((aml)localObject1).bgt("");
    ((aml)localObject1).bgo(((k.b)localObject2).thumburl);
    localObject3 = m.v(paramca);
    if (localObject3 == null)
    {
      Log.w("MicroMsg.GetFavRecordDataSourceForRecordMsg", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(9452);
      return false;
    }
    ((aml)localObject1).ajc(((amt)localObject3).duration);
    ((aml)localObject1).bgf(((k.b)localObject2).title);
    ((aml)localObject1).bgl(((k.b)localObject2).url);
    ((aml)localObject1).As(true);
    ((aml)localObject1).At(true);
    localObject2 = new amm();
    ((amm)localObject2).c(aL(paramca));
    if (paramca.cWK()) {
      ((amm)localObject2).e((amt)localObject3);
    }
    ((aml)localObject1).a((amm)localObject2);
    ((aml)localObject1).Mw(paramca.field_msgId);
    ((aml)localObject1).bgA(a(((amm)localObject2).LwO));
    ((aml)localObject1).bgB(b(((amm)localObject2).LwO));
    if (as.bjp(((amm)localObject2).LwO.LxA))
    {
      paramca = ((amm)localObject2).LwO.LxA;
      paramca = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca));
      if (!Util.isNullOrNil(paramca)) {
        ((aml)localObject1).bgJ(paramca);
      }
    }
    paramcz.dFZ.dGb.ppH.add(localObject1);
    paramcz = paramcz.dFZ.dGc;
    paramcz.xiP += 1;
    ((aml)localObject1).ajd(4);
    AppMethodBeat.o(9452);
    return true;
  }
  
  private static boolean c(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(9457);
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
              ((aml)localObject2).bgu(com.tencent.mm.pluginsdk.model.s.bdu(localv.iAo));
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
                str = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str));
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
      Log.printErrStackTrace("MicroMsg.GetFavRecordDataSourceForRecordMsg", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavRecordDataSourceForRecordMsg", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(9457);
      return false;
    }
    paramcz.dFZ.dGe = 2131759217;
    AppMethodBeat.o(9457);
    return false;
    label557:
    AppMethodBeat.o(9457);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.c
 * JD-Core Version:    0.7.0.1
 */