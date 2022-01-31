package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.l;
import com.tencent.mm.af.q;
import com.tencent.mm.ah.i;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e
{
  public static String Lu(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static aca a(aca paramaca, int paramInt)
  {
    AppMethodBeat.i(27268);
    aca localaca = p(paramaca);
    localaca.MI(paramInt);
    if ((paramaca.wTw != null) && (paramaca.wTw.wUh != null))
    {
      acp localacp = new acp();
      localacp.aog(paramaca.wTw.wUh.title);
      localacp.aoh(paramaca.wTw.wUh.desc);
      localacp.MO(paramaca.wTw.wUh.type);
      localacp.aoj(paramaca.wTw.wUh.info);
      localacp.aoi(paramaca.wTw.wUh.thumbUrl);
      localaca.wTw.a(localacp);
    }
    AppMethodBeat.o(27268);
    return localaca;
  }
  
  private static aca a(bi parambi, j.b paramb, int paramInt)
  {
    AppMethodBeat.i(27251);
    aca localaca = new aca();
    a(localaca, parambi);
    localaca.anx(paramb.fgU);
    localaca.any(paramb.fgV);
    localaca.anw(paramb.url);
    localaca.py(true);
    parambi = new com.tencent.mm.vfs.b(bo.bf(com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true), ""));
    if (parambi.exists()) {
      localaca.anF(com.tencent.mm.vfs.j.p(parambi.dQJ()));
    }
    for (;;)
    {
      localaca.anq(paramb.title);
      localaca.anr(paramb.description);
      localaca.anP(paramb.canvasPageXml);
      localaca.MI(paramInt);
      localaca.anO(paramb.cGU);
      AppMethodBeat.o(27251);
      return localaca;
      localaca.pz(true);
    }
  }
  
  private static void a(aca paramaca1, aca paramaca2)
  {
    AppMethodBeat.i(27257);
    paramaca1.anx(paramaca2.wSL);
    paramaca1.any(paramaca2.wSN);
    paramaca1.anw(paramaca2.wSJ);
    paramaca1.anq(paramaca2.title);
    paramaca1.anr(paramaca2.desc);
    AppMethodBeat.o(27257);
  }
  
  private static void a(aca paramaca, bi parambi)
  {
    AppMethodBeat.i(27247);
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.t.lA(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
      {
        paramaca.anI(String.valueOf(parambi.field_msgSvrId));
        AppMethodBeat.o(27247);
        return;
      }
      paramaca.anI(parambi.field_talker + "#" + String.valueOf(parambi.field_msgSvrId));
      AppMethodBeat.o(27247);
      return;
    }
    paramaca.anI(String.valueOf(parambi.field_msgSvrId));
    AppMethodBeat.o(27247);
  }
  
  private static void a(bi parambi, acq paramacq, adf paramadf)
  {
    AppMethodBeat.i(153688);
    paramacq.c(l.a(parambi, paramadf));
    AppMethodBeat.o(153688);
  }
  
  public static boolean a(cm paramcm, int paramInt, String paramString)
  {
    AppMethodBeat.i(27240);
    if ((paramcm == null) || (bo.isNullOrNil(paramString)))
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(27240);
      return false;
    }
    ab.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localaca.MI(2);
    localaca.anE(paramString);
    localaca.anD(com.tencent.mm.a.g.w((localaca.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gi();
    ((gi)localObject).cuX.type = 27;
    ((gi)localObject).cuX.cuZ = localaca;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gi)localObject).cuY.thumbPath;
    d.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localaca.anF((String)localObject);
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(paramInt);
    localacw.nI(bo.aoy());
    localacq.a(localacw);
    localacq.wVc.add(localaca);
    paramcm.cpR.title = localaca.title;
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 2;
    AppMethodBeat.o(27240);
    return true;
  }
  
  public static boolean a(cm paramcm, long paramLong)
  {
    AppMethodBeat.i(27241);
    boolean bool = d(paramcm, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(paramLong));
    AppMethodBeat.o(27241);
    return bool;
  }
  
  public static boolean a(cm paramcm, Intent paramIntent)
  {
    AppMethodBeat.i(27237);
    if (paramcm == null)
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(27237);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bo.bf(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new ach();
    paramIntent.aoe((String)localObject1);
    paramIntent.D(d1);
    paramIntent.C(d2);
    paramIntent.MN(i);
    paramIntent.aof((String)localObject2);
    localObject1 = new acq();
    localObject2 = new acw();
    String str = r.Zn();
    ((acw)localObject2).aon(str);
    ((acw)localObject2).aoo(str);
    ((acw)localObject2).MR(6);
    ((acw)localObject2).nI(bo.aoy());
    ((acq)localObject1).b(paramIntent);
    ((acq)localObject1).a((acw)localObject2);
    paramcm.cpR.cpT = ((acq)localObject1);
    paramcm.cpR.type = 6;
    AppMethodBeat.o(27237);
    return true;
  }
  
  private static boolean a(cm paramcm, j.b paramb, acq paramacq, bi parambi)
  {
    AppMethodBeat.i(27255);
    Object localObject = new oa();
    ((oa)localObject).cEz.type = 0;
    ((oa)localObject).cEz.cEB = paramb.fhc;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((oa)localObject).cEA.cEK;
    if (localc == null)
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27255);
      return false;
    }
    paramacq.aol(localc.title);
    Iterator localIterator = localc.fjy.iterator();
    int i = 0;
    aca localaca;
    if (localIterator.hasNext())
    {
      localaca = (aca)localIterator.next();
      localObject = null;
      paramb = (j.b)localObject;
      switch (localaca.dataType)
      {
      default: 
        paramb = (j.b)localObject;
      case 9: 
      case 13: 
      case 18: 
        label239:
        if (paramb != null)
        {
          int j = i + 1;
          paramb.anI(e(parambi, i));
          paramacq.wVc.add(paramb);
          i = j;
        }
        break;
      }
    }
    for (;;)
    {
      break;
      paramb = i(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVt += 1;
      break label239;
      paramb = q(localaca);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVr += 1;
      break label239;
      paramb = j(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVs += 1;
      break label239;
      paramb = k(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVv += 1;
      break label239;
      paramb = l(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVu += 1;
      break label239;
      paramb = r(localaca);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVw += 1;
      break label239;
      paramb = m(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVx += 1;
      break label239;
      paramb = n(localaca, parambi.field_msgId);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).fileCount += 1;
      break label239;
      paramb = a(localaca, localaca.dataType);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVz += 1;
      break label239;
      paramb = a(localaca, localaca.dataType);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVA += 1;
      break label239;
      paramb = t(localaca);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVD += 1;
      break label239;
      paramb = u(localaca);
      localObject = paramcm.cpR.cpU;
      ((ade)localObject).wVE += 1;
      break label239;
      paramb = s(localaca);
      break label239;
      paramb = o(localaca, parambi.field_msgId);
      break label239;
      paramb = v(localaca);
      break label239;
      if ((!bo.isNullOrNil(((aca)localc.fjy.get(0)).wSR)) && (((aca)localc.fjy.get(0)).wSR.equals(".htm"))) {}
      for (paramcm.cpR.type = 18;; paramcm.cpR.type = 14)
      {
        AppMethodBeat.o(27255);
        return true;
      }
    }
  }
  
  private static boolean a(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27246);
    acq localacq = new acq();
    localacq.a(ak(parambi));
    parambi = br.F(parambi.field_content, "msg");
    if (parambi != null) {
      try
      {
        ach localach = new ach();
        localach.aoe((String)parambi.get(".msg.location.$label"));
        localach.D(Double.parseDouble((String)parambi.get(".msg.location.$x")));
        localach.C(Double.parseDouble((String)parambi.get(".msg.location.$y")));
        localach.MN(Integer.valueOf((String)parambi.get(".msg.location.$scale")).intValue());
        localach.aof((String)parambi.get(".msg.location.$poiname"));
        localacq.b(localach);
        paramcm.cpR.type = 6;
        paramcm.cpR.cpT = localacq;
        AppMethodBeat.o(27246);
        return true;
      }
      catch (Exception parambi)
      {
        ab.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambi.getStackTrace().toString() });
      }
    }
    paramcm.cpR.cpX = 2131299723;
    AppMethodBeat.o(27246);
    return false;
  }
  
  public static boolean a(cm paramcm, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(27238);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(27238);
      return false;
    }
    ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new com.tencent.mm.vfs.b(paramString1).length() > com.tencent.mm.m.b.MX())
    {
      paramcm.cpR.cpX = 2131299848;
      AppMethodBeat.o(27238);
      return false;
    }
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localaca.anE(paramString1);
    localaca.MI(8);
    localaca.anA(com.tencent.mm.vfs.e.cP(paramString1));
    localaca.pz(true);
    localaca.anq(paramString2);
    localaca.anr(paramString3);
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(13);
    localacw.nI(bo.aoy());
    localacq.a(localacw);
    localacq.wVc.add(localaca);
    paramcm.cpR.title = localaca.title;
    paramcm.cpR.desc = localaca.title;
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 8;
    AppMethodBeat.o(27238);
    return true;
  }
  
  private static acw ak(bi parambi)
  {
    AppMethodBeat.i(27243);
    acw localacw = new acw();
    if (parambi.field_isSend == 1)
    {
      localacw.aon(r.Zn());
      localacw.aoo(parambi.field_talker);
      if (com.tencent.mm.model.t.lA(parambi.field_talker)) {
        localacw.aoq(localacw.czp);
      }
    }
    do
    {
      localacw.MR(1);
      localacw.nI(parambi.field_createTime);
      localacw.aor(parambi.field_msgSvrId);
      if (parambi.field_msgSvrId > 0L) {
        localacw.aop(parambi.field_msgSvrId);
      }
      AppMethodBeat.o(27243);
      return localacw;
      localacw.aon(parambi.field_talker);
      localacw.aoo(r.Zn());
    } while (!com.tencent.mm.model.t.lA(parambi.field_talker));
    if (parambi.field_content != null) {}
    for (String str = parambi.field_content.substring(0, Math.max(0, parambi.field_content.indexOf(':')));; str = "")
    {
      localacw.aoq(str);
      if ((bo.isNullOrNil(localacw.wUA)) || (parambi.dvW())) {
        break;
      }
      parambi.setContent(parambi.field_content.substring(localacw.wUA.length() + 1));
      if ((parambi.field_content.length() > 0) && ('\n' == parambi.field_content.charAt(0))) {
        parambi.setContent(parambi.field_content.substring(1));
      }
      if (!parambi.dya()) {
        break;
      }
      parambi.km(parambi.field_transContent.substring(localacw.wUA.length() + 1));
      if ((parambi.field_transContent.length() <= 0) || ('\n' != parambi.field_transContent.charAt(0))) {
        break;
      }
      parambi.km(parambi.field_transContent.substring(1));
      break;
    }
  }
  
  private static String alh(String paramString)
  {
    AppMethodBeat.i(27249);
    paramString = com.tencent.mm.sdk.platformtools.j.b(com.tencent.mm.plugin.record.b.YN(), "recbiz_", paramString, ".rec", 2);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(27249);
      return null;
    }
    if (new com.tencent.mm.vfs.b(paramString).exists())
    {
      AppMethodBeat.o(27249);
      return paramString;
    }
    AppMethodBeat.o(27249);
    return paramString;
  }
  
  public static boolean b(cm paramcm, String paramString, int paramInt)
  {
    AppMethodBeat.i(27239);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(27239);
      return false;
    }
    ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    acq localacq = new acq();
    acw localacw = new acw();
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(paramInt);
    localacw.nI(bo.aoy());
    localacq.a(localacw);
    paramcm.cpR.desc = paramString;
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 1;
    AppMethodBeat.o(27239);
    return true;
  }
  
  private static boolean c(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27253);
    acq localacq = new acq();
    Object localObject1 = ak(parambi);
    localacq.a((acw)localObject1);
    try
    {
      com.tencent.mm.af.p localp = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
      Object localObject2 = localp.fjy;
      ((acw)localObject1).aov(localp.cGN);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcm.cpR.cpV))
      {
        ab.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcm.cpR.cpV) });
        q localq = (q)((List)localObject2).get(paramcm.cpR.cpV);
        if (l.na(localq.fjO))
        {
          paramcm.cpR.cpX = 2131299721;
          AppMethodBeat.o(27253);
          return false;
        }
        ((acw)localObject1).aou(localq.url);
        if (paramcm.cpR.cpV > 0) {
          ((acw)localObject1).aop("");
        }
        aca localaca = new aca();
        localaca.anq(localq.title);
        localaca.anr(localq.fjL);
        a(localaca, parambi);
        localObject2 = l.a(localq);
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2))
        {
          parambi = com.tencent.mm.ah.o.adg().rj(parambi.field_talker);
          localObject1 = localObject2;
          if (parambi != null) {
            localObject1 = parambi.acX();
          }
        }
        if (!bo.isNullOrNil((String)localObject1))
        {
          localaca.anF(p.aln((String)localObject1));
          localaca.pz(false);
          if ((bo.isNullOrNil(localaca.wTc)) || (!com.tencent.mm.vfs.e.cN(localaca.wTc)))
          {
            localaca.anz((String)localObject1);
            localaca.pz(true);
          }
        }
        for (;;)
        {
          localaca.py(true);
          localaca.MI(5);
          localacq.wVc.add(localaca);
          paramcm.cpR.cpT = localacq;
          paramcm.cpR.desc = localq.title;
          paramcm.cpR.type = 5;
          parambi = new adf();
          parambi.aoD((String)localObject1);
          parambi.aoA(localq.title);
          parambi.aoB(localq.fjL);
          localacq.b(parambi);
          localacq.c(l.a(localq, parambi, localp.cGN, localp.cGO));
          AppMethodBeat.o(27253);
          return true;
          localaca.pz(true);
        }
      }
      return false;
    }
    catch (Exception parambi)
    {
      ab.printErrStackTrace("MicroMsg.GetFavDataSource", parambi, "", new Object[0]);
      ab.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambi.getLocalizedMessage() });
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27253);
    }
  }
  
  public static boolean d(cm paramcm, bi parambi)
  {
    boolean bool = false;
    AppMethodBeat.i(27242);
    if ((paramcm == null) || (parambi == null))
    {
      ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(27242);
      return false;
    }
    parambi = bi.as(parambi);
    if (parambi.isText()) {
      bool = e(paramcm, parambi);
    }
    for (;;)
    {
      paramcm.cpR.cpH = parambi.field_content;
      if ((bool) || (paramcm.cpR.cpX == 0)) {
        com.tencent.mm.plugin.fav.ui.c.a(parambi, paramcm, bool);
      }
      AppMethodBeat.o(27242);
      return bool;
      if (parambi.dvW())
      {
        bool = g(paramcm, parambi);
      }
      else if (parambi.bCp())
      {
        bool = a(paramcm, parambi);
      }
      else if (parambi.dvX())
      {
        bool = f(paramcm, parambi);
      }
      else if ((parambi.byj()) || (parambi.byk()))
      {
        bool = h(paramcm, parambi);
      }
      else if (parambi.dvV())
      {
        bool = c(paramcm, parambi);
      }
      else
      {
        if (parambi.dxR()) {}
        while ((!parambi.bCn()) || (parambi.dxT()))
        {
          paramcm.cpR.cpX = 2131299721;
          break;
        }
        bool = i(paramcm, parambi);
      }
    }
  }
  
  private static String e(bi parambi, int paramInt)
  {
    AppMethodBeat.i(27254);
    if (parambi.field_isSend == 1)
    {
      if ((com.tencent.mm.model.t.lA(parambi.field_talker)) || (parambi.field_talker.equals("filehelper")))
      {
        parambi = String.format("%d$%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(paramInt) });
        AppMethodBeat.o(27254);
        return parambi;
      }
      parambi = String.format("%s#%d$%d", new Object[] { parambi.field_talker, Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(paramInt) });
      AppMethodBeat.o(27254);
      return parambi;
    }
    parambi = String.format("%d$%d", new Object[] { Long.valueOf(parambi.field_msgSvrId), Integer.valueOf(paramInt) });
    AppMethodBeat.o(27254);
    return parambi;
  }
  
  private static boolean e(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27244);
    acq localacq = new acq();
    localacq.a(ak(parambi));
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.desc = parambi.field_content;
    paramcm.cpR.type = 1;
    if (com.tencent.mm.ui.tools.f.auQ(paramcm.cpR.desc) > com.tencent.mm.m.b.MT())
    {
      paramcm.cpR.cpX = 2131299846;
      AppMethodBeat.o(27244);
      return false;
    }
    AppMethodBeat.o(27244);
    return true;
  }
  
  private static boolean f(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27245);
    Object localObject1 = null;
    if (parambi.field_msgId > 0L) {
      localObject1 = com.tencent.mm.at.o.ahC().gT(parambi.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambi.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ab.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcm.cpR.cpX = 2131299719;
      AppMethodBeat.o(27245);
      return false;
    }
    localObject1 = new acq();
    ((acq)localObject1).a(ak(parambi));
    aca localaca = new aca();
    a(localaca, parambi);
    localaca.MI(2);
    localaca.anE(com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject2), "", ""));
    if (((com.tencent.mm.at.e)localObject2).ahh())
    {
      localObject2 = com.tencent.mm.at.o.ahC().lv(((com.tencent.mm.at.e)localObject2).fDW);
      if (((com.tencent.mm.at.e)localObject2).fsd > ((com.tencent.mm.at.e)localObject2).offset) {
        localaca.anE(com.tencent.mm.at.o.ahC().q("SERVERID://" + parambi.field_msgSvrId, "", ""));
      }
    }
    localaca.anF(com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true));
    parambi = new LinkedList();
    parambi.add(localaca);
    ((acq)localObject1).aJ(parambi);
    paramcm.cpR.cpT = ((acq)localObject1);
    paramcm.cpR.type = 2;
    AppMethodBeat.o(27245);
    return true;
  }
  
  private static boolean g(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27248);
    acq localacq = new acq();
    localacq.a(ak(parambi));
    aca localaca = new aca();
    a(localaca, parambi);
    if (com.tencent.mm.model.t.oq(parambi.field_talker)) {
      localaca.anE(alh(parambi.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localaca.MI(3);
      localaca.pz(true);
      localb = com.tencent.mm.modelvoice.s.vK(parambi.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(27248);
      return false;
      localaca.anE(com.tencent.mm.modelvoice.s.getFullPath(parambi.field_imgPath));
    }
    localaca.anA(Lu(localb.getFormat()));
    localaca.MH((int)new com.tencent.mm.modelvoice.p(parambi.field_content).time);
    parambi = new LinkedList();
    parambi.add(localaca);
    localacq.aJ(parambi);
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.type = 3;
    AppMethodBeat.o(27248);
    return true;
  }
  
  private static boolean h(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27250);
    acq localacq = new acq();
    localacq.a(ak(parambi));
    aca localaca = new aca();
    a(localaca, parambi);
    com.tencent.mm.modelvideo.o.alE();
    localaca.anF(com.tencent.mm.modelvideo.t.vg(parambi.field_imgPath));
    localaca.anA(com.tencent.mm.vfs.e.cP(localaca.wTa));
    Object localObject = u.vr(parambi.field_imgPath);
    if (localObject == null)
    {
      ab.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(27250);
      return false;
    }
    ab.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).fsd) });
    if (((com.tencent.mm.modelvideo.s)localObject).fsd > com.tencent.mm.m.b.MX())
    {
      paramcm.cpR.cpX = 2131299848;
      AppMethodBeat.o(27250);
      return false;
    }
    if ((parambi.byk()) && (u.vt(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(27250);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).alS())
    {
      com.tencent.mm.modelvideo.o.alE();
      String str = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
      ab.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localaca.anE(str);
      localaca.MH(((com.tencent.mm.modelvideo.s)localObject).fXx);
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localaca);
      localacq.aJ((LinkedList)localObject);
      paramcm.cpR.cpT = localacq;
      if (!parambi.byk()) {
        break label445;
      }
      paramcm.cpR.type = 16;
      localaca.MI(15);
    }
    for (;;)
    {
      paramcm = u.vr(parambi.field_imgPath);
      localaca.anO(paramcm.cGU);
      paramcm = paramcm.fXG;
      if ((paramcm != null) && (!bo.isNullOrNil(paramcm.fiU)))
      {
        parambi = new acd();
        parambi.fiO = paramcm.fiO;
        parambi.wUJ = paramcm.wUJ;
        parambi.fiR = paramcm.fiR;
        parambi.fiS = paramcm.fiS;
        parambi.fiQ = paramcm.fiQ;
        parambi.fiT = paramcm.fiT;
        parambi.fiU = paramcm.fiU;
        parambi.fiV = paramcm.fiV;
        localaca.a(parambi);
      }
      AppMethodBeat.o(27250);
      return true;
      ab.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localaca.anE("");
      break;
      label445:
      paramcm.cpR.type = 4;
      localaca.MI(4);
    }
  }
  
  private static aca i(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27259);
    aca localaca = p(paramaca);
    localaca.MI(3);
    if (!bo.isNullOrNil(paramaca.wTE))
    {
      oa localoa = new oa();
      localoa.cEz.type = 1;
      localoa.cEz.cuL = paramaca;
      localoa.cEz.cpO = paramLong;
      com.tencent.mm.sdk.b.a.ymk.l(localoa);
      if ((bo.isNullOrNil(localoa.cEA.dataPath)) && (bo.isNullOrNil(localoa.cEA.thumbPath))) {
        ab.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      localaca.anE(localoa.cEA.dataPath);
      localaca.MH(paramaca.duration);
      localaca.pz(true);
      localaca.py(false);
      localaca.anA(paramaca.wSR);
    }
    AppMethodBeat.o(27259);
    return localaca;
  }
  
  private static boolean i(cm paramcm, bi parambi)
  {
    AppMethodBeat.i(27252);
    acq localacq = new acq();
    localacq.a(ak(parambi));
    Object localObject1 = parambi.field_content;
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27252);
      return false;
    }
    localObject1 = j.b.mY((String)localObject1);
    if (localObject1 == null)
    {
      paramcm.cpR.cpX = 2131299723;
      AppMethodBeat.o(27252);
      return false;
    }
    paramcm.cpR.cpT = localacq;
    Object localObject2 = localacq.wVa;
    ((acw)localObject2).aot(((j.b)localObject1).appId);
    ((acw)localObject2).aov(((j.b)localObject1).cGN);
    switch (((j.b)localObject1).type)
    {
    default: 
      paramcm.cpR.cpX = 2131299721;
      AppMethodBeat.o(27252);
      return false;
    case 1: 
      paramcm.cpR.cpT = localacq;
      paramcm.cpR.desc = ((j.b)localObject1).title;
      paramcm.cpR.type = 1;
      AppMethodBeat.o(27252);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(27252);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.aUJ().alo(((j.b)localObject1).cmN);
      localObject2 = new aca();
      a((aca)localObject2, parambi);
      if (localObject3 != null) {
        ((aca)localObject2).anE(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
      }
      parambi = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
      if (com.tencent.mm.vfs.e.cN(parambi)) {
        ((aca)localObject2).anF(parambi);
      }
      ((aca)localObject2).MI(2);
      ((aca)localObject2).anq(((j.b)localObject1).title);
      ((aca)localObject2).anr(((j.b)localObject1).description);
      localacq.wVc.add(localObject2);
      paramcm.cpR.type = 2;
      AppMethodBeat.o(27252);
      return true;
    case 3: 
      parambi = a(parambi, (j.b)localObject1, 7);
      localacq.wVc.add(parambi);
      paramcm.cpR.type = 7;
      AppMethodBeat.o(27252);
      return true;
    case 4: 
      parambi = a(parambi, (j.b)localObject1, 4);
      localacq.aol(parambi.title);
      localacq.aom(parambi.desc);
      localacq.wVc.add(parambi);
      paramcm.cpR.type = 4;
      AppMethodBeat.o(27252);
      return true;
    case 5: 
      if ((((j.b)localObject1).url != null) && (!((j.b)localObject1).url.equals("")))
      {
        localacq.wVa.aou(((j.b)localObject1).url);
        localObject2 = new adf();
        ((adf)localObject2).aoD(((j.b)localObject1).thumburl);
        localacq.b((adf)localObject2);
        a(parambi, localacq, (adf)localObject2);
        parambi = a(parambi, (j.b)localObject1, 5);
        localacq.wVc.add(parambi);
        localacq.aol(parambi.title);
        localacq.aom(parambi.desc);
        paramcm.cpR.type = 5;
        AppMethodBeat.o(27252);
        return true;
      }
      paramcm.cpR.cpX = 2131299717;
      AppMethodBeat.o(27252);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299729;
        AppMethodBeat.o(27252);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.aUJ().alo(((j.b)localObject1).cmN);
      localObject2 = new aca();
      if (localObject3 != null) {
        ((aca)localObject2).anE(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
      }
      a((aca)localObject2, parambi);
      ((aca)localObject2).MI(8);
      ((aca)localObject2).anA(((j.b)localObject1).fgx);
      parambi = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
      if (bo.isNullOrNil(parambi)) {
        ((aca)localObject2).pz(true);
      }
      if (com.tencent.mm.vfs.e.cN(parambi)) {
        ((aca)localObject2).anF(parambi);
      }
      ((aca)localObject2).anq(((j.b)localObject1).title);
      ((aca)localObject2).anr(((j.b)localObject1).description);
      localacq.wVc.add(localObject2);
      paramcm.cpR.desc = ((j.b)localObject1).title;
      paramcm.cpR.type = 8;
      AppMethodBeat.o(27252);
      return true;
    case 7: 
      if ((((j.b)localObject1).cmN == null) || (((j.b)localObject1).cmN.length() == 0)) {
        paramcm.cpR.cpX = 2131299714;
      }
      while (com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        paramcm.cpR.cpX = 2131299721;
        AppMethodBeat.o(27252);
        return false;
      }
      paramcm.cpR.cpX = 2131299729;
      AppMethodBeat.o(27252);
      return false;
    case 10: 
      parambi = new acp();
      parambi.aog(((j.b)localObject1).title);
      parambi.aoh(((j.b)localObject1).description);
      parambi.MO(((j.b)localObject1).fgX);
      parambi.aoj(((j.b)localObject1).fgY);
      parambi.aoi(((j.b)localObject1).thumburl);
      paramcm.cpR.title = ((j.b)localObject1).title;
      paramcm.cpR.desc = ((j.b)localObject1).description;
      paramcm.cpR.type = 10;
      localacq.b(parambi);
      AppMethodBeat.o(27252);
      return true;
    case 20: 
      parambi = new acz();
      parambi.aow(((j.b)localObject1).title);
      parambi.aox(((j.b)localObject1).description);
      parambi.aoz(((j.b)localObject1).fhb);
      parambi.aoy(((j.b)localObject1).thumburl);
      paramcm.cpR.title = ((j.b)localObject1).title;
      paramcm.cpR.desc = ((j.b)localObject1).description;
      paramcm.cpR.type = 15;
      localacq.b(parambi);
      AppMethodBeat.o(27252);
      return true;
    case 13: 
      parambi = new acp();
      parambi.aog(((j.b)localObject1).title);
      parambi.aoh(((j.b)localObject1).description);
      parambi.MO(((j.b)localObject1).fhd);
      parambi.aoj(((j.b)localObject1).fhe);
      parambi.aoi(((j.b)localObject1).thumburl);
      paramcm.cpR.title = ((j.b)localObject1).title;
      paramcm.cpR.desc = ((j.b)localObject1).description;
      paramcm.cpR.type = 11;
      localacq.b(parambi);
      AppMethodBeat.o(27252);
      return true;
    case 19: 
    case 24: 
      paramcm.cpR.cpU = new ade();
      boolean bool = a(paramcm, (j.b)localObject1, localacq, parambi);
      AppMethodBeat.o(27252);
      return bool;
    }
    localObject2 = new aby();
    ((aby)localObject2).username = ((j.b)localObject1).fiX;
    ((aby)localObject2).appId = ((j.b)localObject1).fiY;
    ((aby)localObject2).cvs = ((j.b)localObject1).fjb;
    ((aby)localObject2).iconUrl = ((j.b)localObject1).fjj;
    ((aby)localObject2).cmG = ((j.b)localObject1).fiW;
    ((aby)localObject2).wSs = ((j.b)localObject1).cGO;
    Object localObject3 = new aca();
    a((aca)localObject3, parambi);
    ((aca)localObject3).MI(19);
    parambi = com.tencent.mm.at.o.ahC().J(parambi.field_imgPath, true);
    if (bo.isNullOrNil(parambi)) {
      ((aca)localObject3).pz(true);
    }
    if (com.tencent.mm.vfs.e.cN(parambi)) {
      ((aca)localObject3).anF(parambi);
    }
    ((aca)localObject3).anq(((j.b)localObject1).title);
    ((aca)localObject3).anr(((j.b)localObject1).description);
    localacq.wVc.add(localObject3);
    paramcm.cpR.title = ((j.b)localObject1).title;
    paramcm.cpR.desc = ((j.b)localObject1).description;
    paramcm.cpR.type = 19;
    localacq.b((aby)localObject2);
    AppMethodBeat.o(27252);
    return true;
  }
  
  private static aca j(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27260);
    aca localaca = p(paramaca);
    localaca.MI(2);
    oa localoa = new oa();
    localoa.cEz.type = 1;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = paramLong;
    com.tencent.mm.sdk.b.a.ymk.l(localoa);
    if ((bo.isNullOrNil(localoa.cEA.dataPath)) && (bo.isNullOrNil(localoa.cEA.thumbPath))) {
      ab.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
    }
    localaca.anE(localoa.cEA.dataPath);
    localaca.anF(localoa.cEA.thumbPath);
    localaca.pz(false);
    localaca.py(false);
    AppMethodBeat.o(27260);
    return localaca;
  }
  
  private static aca k(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27261);
    aca localaca = p(paramaca);
    a(localaca, paramaca);
    localaca.MI(5);
    Object localObject = new oa();
    ((oa)localObject).cEz.type = 1;
    ((oa)localObject).cEz.cuL = paramaca;
    ((oa)localObject).cEz.cpO = paramLong;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if ((bo.isNullOrNil(((oa)localObject).cEA.dataPath)) && (bo.isNullOrNil(((oa)localObject).cEA.thumbPath))) {
      ab.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
    }
    localaca.anF(((oa)localObject).cEA.thumbPath);
    localaca.pz(false);
    if ((paramaca.wTw != null) && (paramaca.wTw.wUf != null))
    {
      localObject = new adf();
      ((adf)localObject).aoA(paramaca.wTw.wUf.title);
      ((adf)localObject).aoB(paramaca.wTw.wUf.desc);
      ((adf)localObject).aoD(paramaca.wTw.wUf.thumbUrl);
      ((adf)localObject).MS(paramaca.wTw.wUf.wVH);
      ((adf)localObject).aoC(paramaca.wTw.wUf.wVF);
      localaca.wTw.a((adf)localObject);
    }
    AppMethodBeat.o(27261);
    return localaca;
  }
  
  private static aca l(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27262);
    aca localaca = p(paramaca);
    a(localaca, paramaca);
    if (paramaca.dataType == 15) {
      localaca.MI(15);
    }
    for (;;)
    {
      oa localoa = new oa();
      localoa.cEz.type = 1;
      localoa.cEz.cuL = paramaca;
      localoa.cEz.cpO = paramLong;
      com.tencent.mm.sdk.b.a.ymk.l(localoa);
      if ((bo.isNullOrNil(localoa.cEA.dataPath)) && (bo.isNullOrNil(localoa.cEA.thumbPath))) {
        ab.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
      }
      localaca.py(false);
      localaca.anE(localoa.cEA.dataPath);
      localaca.pz(false);
      localaca.anF(localoa.cEA.thumbPath);
      localaca.MH(paramaca.duration);
      AppMethodBeat.o(27262);
      return localaca;
      localaca.MI(4);
    }
  }
  
  private static aca m(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27264);
    aca localaca = p(paramaca);
    a(localaca, paramaca);
    localaca.MI(7);
    oa localoa = new oa();
    localoa.cEz.type = 1;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = paramLong;
    com.tencent.mm.sdk.b.a.ymk.l(localoa);
    if ((bo.isNullOrNil(localoa.cEA.dataPath)) && (bo.isNullOrNil(localoa.cEA.thumbPath))) {
      ab.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
    }
    localaca.anF(localoa.cEA.thumbPath);
    localaca.pz(false);
    AppMethodBeat.o(27264);
    return localaca;
  }
  
  private static aca n(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27265);
    aca localaca = p(paramaca);
    a(localaca, paramaca);
    localaca.MI(8);
    oa localoa = new oa();
    localoa.cEz.type = 1;
    localoa.cEz.cuL = paramaca;
    localoa.cEz.cpO = paramLong;
    com.tencent.mm.sdk.b.a.ymk.l(localoa);
    if ((bo.isNullOrNil(localoa.cEA.dataPath)) && (bo.isNullOrNil(localoa.cEA.thumbPath))) {
      ab.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
    }
    localaca.anE(localoa.cEA.dataPath);
    localaca.anF(localoa.cEA.thumbPath);
    localaca.py(false);
    localaca.anA(paramaca.wSR);
    AppMethodBeat.o(27265);
    return localaca;
  }
  
  private static aca o(aca paramaca, long paramLong)
  {
    AppMethodBeat.i(27267);
    aca localaca = p(paramaca);
    localaca.anq(paramaca.title);
    localaca.anr(paramaca.desc);
    localaca.MI(19);
    Object localObject = new oa();
    ((oa)localObject).cEz.type = 1;
    ((oa)localObject).cEz.cuL = paramaca;
    ((oa)localObject).cEz.cpO = paramLong;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (bo.isNullOrNil(((oa)localObject).cEA.thumbPath)) {
      ab.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
    }
    for (;;)
    {
      if ((paramaca.wTw != null) && (paramaca.wTw.wUs != null))
      {
        localObject = new aby();
        ((aby)localObject).username = paramaca.wTw.wUs.username;
        ((aby)localObject).appId = paramaca.wTw.wUs.appId;
        ((aby)localObject).cvs = paramaca.wTw.wUs.cvs;
        ((aby)localObject).iconUrl = paramaca.wTw.wUs.iconUrl;
        ((aby)localObject).type = paramaca.wTw.wUs.type;
        ((aby)localObject).cmG = paramaca.wTw.wUs.cmG;
        ((aby)localObject).wSs = paramaca.wTw.wUs.wSs;
        localaca.wTw.a((aby)localObject);
      }
      AppMethodBeat.o(27267);
      return localaca;
      localaca.pz(false);
      localaca.anF(((oa)localObject).cEA.thumbPath);
    }
  }
  
  private static aca p(aca paramaca)
  {
    AppMethodBeat.i(27256);
    aca localaca = new aca();
    acb localacb = new acb();
    acc localacc1 = new acc();
    acc localacc2 = paramaca.wTw.wUb;
    if (localacc2.wUw) {
      localacc1.anW(localacc2.czp);
    }
    if (localacc2.wUx) {
      localacc1.anX(localacc2.toUser);
    }
    if (localacc2.wUB) {
      localacc1.anZ(localacc2.wUA);
    }
    localacc1.MM(1);
    localacc1.nF(bo.aoy());
    localacb.c(localacc1);
    localacb.b(paramaca.wTw.uVl);
    localaca.a(localacb);
    localaca.anL(paramaca.wTy);
    localaca.anM(paramaca.wTA);
    localaca.anU(paramaca.wTX);
    localaca.anV(paramaca.wTZ);
    localaca.pz(true);
    localaca.py(true);
    localaca.anN(paramaca.wTE);
    localaca.MK(paramaca.wTK);
    localaca.anB(paramaca.wST);
    localaca.anC(paramaca.wSV);
    localaca.nC(paramaca.wSX);
    localaca.anG(paramaca.wTe);
    localaca.anH(paramaca.wTg);
    localaca.nD(paramaca.wTi);
    AppMethodBeat.o(27256);
    return localaca;
  }
  
  private static aca q(aca paramaca)
  {
    AppMethodBeat.i(27258);
    aca localaca = p(paramaca);
    localaca.MI(1);
    localaca.anr(paramaca.desc);
    AppMethodBeat.o(27258);
    return localaca;
  }
  
  private static aca r(aca paramaca)
  {
    AppMethodBeat.i(27263);
    aca localaca = p(paramaca);
    localaca.MI(6);
    if ((paramaca.wTw != null) && (paramaca.wTw.wUd != null))
    {
      ach localach = new ach();
      localach.aoe(paramaca.wTw.wUd.label);
      localach.D(paramaca.wTw.wUd.lat);
      localach.C(paramaca.wTw.wUd.lng);
      localach.MN(paramaca.wTw.wUd.cyX);
      localach.aof(paramaca.wTw.wUd.cDl);
      localaca.wTw.a(localach);
    }
    AppMethodBeat.o(27263);
    return localaca;
  }
  
  private static aca s(aca paramaca)
  {
    AppMethodBeat.i(27266);
    aca localaca = p(paramaca);
    localaca.anq(paramaca.title);
    localaca.anr(paramaca.desc);
    localaca.MI(17);
    localaca.anQ(paramaca.wTM);
    AppMethodBeat.o(27266);
    return localaca;
  }
  
  private static aca t(aca paramaca)
  {
    AppMethodBeat.i(27269);
    aca localaca = p(paramaca);
    localaca.MI(14);
    if ((paramaca.wTw != null) && (paramaca.wTw.wUj != null))
    {
      acz localacz = new acz();
      localacz.aow(paramaca.wTw.wUj.title);
      localacz.aox(paramaca.wTw.wUj.desc);
      localacz.aoz(paramaca.wTw.wUj.info);
      localacz.aoy(paramaca.wTw.wUj.thumbUrl);
      localaca.wTw.a(localacz);
    }
    AppMethodBeat.o(27269);
    return localaca;
  }
  
  private static aca u(aca paramaca)
  {
    AppMethodBeat.i(27270);
    aca localaca = p(paramaca);
    localaca.MI(16);
    localaca.anr(paramaca.desc);
    AppMethodBeat.o(27270);
    return localaca;
  }
  
  private static aca v(aca paramaca)
  {
    AppMethodBeat.i(27271);
    aca localaca = p(paramaca);
    localaca.MI(20);
    localaca.MH(paramaca.duration);
    AppMethodBeat.o(27271);
    return localaca;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.e
 * JD-Core Version:    0.7.0.1
 */