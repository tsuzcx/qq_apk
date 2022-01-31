package com.tencent.mm.plugin.sns.j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(aca paramaca, n paramn)
  {
    AppMethodBeat.i(38042);
    if (paramn != null) {
      a(paramaca, paramn.csh());
    }
    AppMethodBeat.o(38042);
  }
  
  private static void a(aca paramaca, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(38041);
    if ((paramaca != null) && (paramTimeLineObject != null) && (!bo.isNullOrNil(paramTimeLineObject.rHA))) {
      paramaca.anO(paramTimeLineObject.rHA);
    }
    AppMethodBeat.o(38041);
  }
  
  public static boolean a(cm paramcm, n paramn)
  {
    AppMethodBeat.i(38035);
    if (paramn == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(38035);
      return false;
    }
    acq localacq = new acq();
    Object localObject2 = new acw();
    TimeLineObject localTimeLineObject = paramn.csh();
    bcs localbcs = (bcs)localTimeLineObject.xTS.wOa.get(0);
    if ((paramn.Ex(32)) && (localTimeLineObject.xTS.wNZ == 15))
    {
      localTimeLineObject.xTX.fiU = paramn.csd().cFe;
      localTimeLineObject.xTX.fiV = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { i.lq(paramn.field_snsId), localbcs.Id });
    ((acw)localObject2).aon(paramn.field_userName);
    ((acw)localObject2).aoo(r.Zn());
    ((acw)localObject2).MR(2);
    ((acw)localObject2).nI(bo.aoy());
    ((acw)localObject2).aos(paramn.getSnsId());
    ((acw)localObject2).aop((String)localObject1);
    localacq.a((acw)localObject2);
    localObject2 = new aca();
    ((aca)localObject2).anI((String)localObject1);
    localObject1 = ao.gl(ag.getAccSnsPath(), localbcs.Id);
    Object localObject4 = i.j(localbcs);
    Object localObject3 = i.e(localbcs);
    if (bo.isNullOrNil(ar.a(paramn.csH(), localbcs)))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcm.cpR.cpX = 2131299730;
      AppMethodBeat.o(38035);
      return false;
    }
    if (!e.cN((String)localObject1 + (String)localObject4))
    {
      ab.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + e.cN(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + e.cN(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcm.cpR.cpX = 2131299730;
      AppMethodBeat.o(38035);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!e.cN((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localbcs.xrV != null)
      {
        j = m;
        i = k;
        if (localbcs.xrV.xsI > 0.0F)
        {
          j = m;
          i = k;
          if (localbcs.xrV.xsH > 0.0F)
          {
            i = (int)localbcs.xrV.xsH;
            j = (int)localbcs.xrV.xsI;
          }
        }
      }
      localBitmap = com.tencent.mm.plugin.sight.base.d.as((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        ab.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + e.cN(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcm.cpR.cpX = 2131299730;
        AppMethodBeat.o(38035);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((aca)localObject2).anE((String)localObject1 + (String)localObject4);
        ((aca)localObject2).anF((String)localObject1 + (String)localObject3);
        if (bo.isNullOrNil(localbcs.xsd))
        {
          localObject1 = localTimeLineObject.xTP;
          ((aca)localObject2).anq((String)localObject1);
          ((aca)localObject2).anP(localTimeLineObject.sbN);
          if (!bo.isNullOrNil(localTimeLineObject.sbN))
          {
            localObject1 = br.F(localTimeLineObject.sbN, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((aca)localObject2).anq(bo.bf((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((aca)localObject2).anr(bo.bf((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramn.Ex(32)) {
            break label1253;
          }
          localObject3 = paramn.csb();
          localObject4 = new acd();
          if (!bo.isNullOrNil(localbcs.xsd)) {
            break label1223;
          }
          localObject1 = localTimeLineObject.xTP;
          ((acd)localObject4).fiQ = ((String)localObject1);
          ((acd)localObject4).wUJ = localbcs.sdf;
          ((acd)localObject4).fiO = localbcs.xrZ;
          ((acd)localObject4).fiU = localTimeLineObject.xTX.fiU;
          ((acd)localObject4).fiV = localTimeLineObject.xTX.fiV;
          if (bo.isNullOrNil(((acd)localObject4).fiV)) {
            ((acd)localObject4).fiV = localTimeLineObject.Id;
          }
          if (!bo.isNullOrNil(localbcs.xsc)) {
            break label1233;
          }
          localObject1 = localbcs.xrS;
          ((acd)localObject4).fiT = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).rpX == 0))
          {
            ((acd)localObject4).fiS = ((com.tencent.mm.plugin.sns.storage.b)localObject3).rpZ;
            ((acd)localObject4).fiR = ((com.tencent.mm.plugin.sns.storage.b)localObject3).rpY;
          }
          ((aca)localObject2).a((acd)localObject4);
          i = 16;
          j = 15;
          ((aca)localObject2).MI(j);
          localObject1 = com.tencent.mm.plugin.sight.base.d.Zo(((aca)localObject2).wTa);
          if (localObject1 == null) {
            break label1243;
          }
          ((aca)localObject2).MH(((com.tencent.mm.plugin.sight.base.a)localObject1).cmu());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localacq.aJ((LinkedList)localObject1);
          paramcm.cpR.cpT = localacq;
          paramcm.cpR.type = i;
          a((aca)localObject2, paramn);
          ab.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(38035);
          return true;
        }
      }
      catch (Exception paramn)
      {
        ab.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramn, "save bmp error %s", new Object[] { paramn.getMessage() });
        ab.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + e.cN(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcm.cpR.cpX = 2131299730;
        AppMethodBeat.o(38035);
        return false;
      }
      localObject1 = localbcs.xsd;
      continue;
      label1223:
      localObject1 = localbcs.xsd;
      continue;
      label1233:
      localObject1 = localbcs.xsc;
      continue;
      label1243:
      ((aca)localObject2).MH(1);
      continue;
      label1253:
      i = 4;
    }
  }
  
  public static boolean a(cm paramcm, n paramn, String paramString)
  {
    AppMethodBeat.i(38039);
    if ((paramcm == null) || (bo.isNullOrNil(paramString)))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(38039);
      return false;
    }
    if (paramn == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38039);
      return false;
    }
    bcs localbcs = ak.a(paramn, paramString);
    if (localbcs == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38039);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { i.lq(paramn.field_snsId), paramString });
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramn.field_userName });
    localacw.aon(paramn.field_userName);
    localacw.aoo(r.Zn());
    localacw.MR(2);
    localacw.nI(paramn.field_createTime * 1000L);
    localacw.aos(paramn.getSnsId());
    localacw.aop(str);
    localaca.anI(str);
    localaca.anE(ao.gl(ag.getAccSnsPath(), paramString) + i.l(localbcs));
    if (paramn.csh() != null)
    {
      localaca.anP(paramn.csh().sbN);
      if (!bo.isNullOrNil(paramn.csh().sbN))
      {
        paramString = br.F(paramn.csh().sbN, "adxml");
        if (paramString.size() > 0)
        {
          localaca.anq(bo.bf((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localaca.anr(bo.bf((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localaca, paramn);
    paramString = ao.gl(ag.getAccSnsPath(), localbcs.Id) + i.e(localbcs);
    if ((!e.cN(localaca.wTa)) && (paramn.field_userName.endsWith(ag.coK())))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38039);
      return false;
    }
    if (e.cN(paramString)) {
      localaca.anF(paramString);
    }
    for (;;)
    {
      localaca.MI(2);
      localacq.wVc.add(localaca);
      localacq.a(localacw);
      paramcm.cpR.cpT = localacq;
      paramcm.cpR.type = 2;
      AppMethodBeat.o(38039);
      return true;
      localaca.pz(true);
      localaca.anz(localbcs.xrS);
      paramn = new adf();
      paramn.aoD(localbcs.xrS);
      localacq.b(paramn);
    }
  }
  
  public static boolean a(cm paramcm, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(38043);
    if ((paramcm == null) || (!v.abQ(paramString)))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(38043);
      return false;
    }
    if (ag.coN())
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcm.cpR.cpX = 2131299731;
      AppMethodBeat.o(38043);
      return false;
    }
    Object localObject1 = h.abv(paramString);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38043);
      return false;
    }
    paramString = "0";
    Object localObject2 = ak.a((n)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((bcs)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { i.lq(((n)localObject1).field_snsId), paramString });
    localObject2 = new acw();
    paramString = ((n)localObject1).csh();
    if (paramString == null)
    {
      ab.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(38043);
      return false;
    }
    ab.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((n)localObject1).field_userName });
    ((acw)localObject2).aon(((n)localObject1).field_userName);
    ((acw)localObject2).aoo(r.Zn());
    ((acw)localObject2).MR(2);
    ((acw)localObject2).nI(((n)localObject1).field_createTime * 1000L);
    ((acw)localObject2).aos(((n)localObject1).getSnsId());
    ((acw)localObject2).aop(str);
    localObject1 = new gi();
    ((gi)localObject1).cuX.type = 30;
    ((gi)localObject1).cuX.cve = 4;
    ((gi)localObject1).cuX.desc = paramString.xTS.wOc;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    ((gi)localObject1).cuX.cpT.a((acw)localObject2);
    paramcm.cpR.cpT = ((gi)localObject1).cuX.cpT;
    if (paramcm.cpR.cpT != null)
    {
      localObject1 = paramcm.cpR.cpT.wVc;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (aca)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((aca)localObject2).py(true);
            ((aca)localObject2).pz(true);
          }
          i += 1;
        }
      }
    }
    paramcm.cpR.desc = paramString.xTS.Title;
    paramcm.cpR.type = 18;
    AppMethodBeat.o(38043);
    return true;
  }
  
  public static boolean a(cm paramcm, String paramString, int paramInt)
  {
    AppMethodBeat.i(38040);
    if ((v.abR(paramString)) || (paramInt < 0))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(38040);
      return false;
    }
    if (ag.coN())
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcm.cpR.cpX = 2131299731;
      AppMethodBeat.o(38040);
      return false;
    }
    paramString = ag.cpf().abv(paramString);
    if (paramString == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38040);
      return false;
    }
    bcs localbcs = ak.a(paramString, paramInt);
    if (localbcs == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38040);
      return false;
    }
    boolean bool = a(paramcm, paramString, localbcs.Id);
    AppMethodBeat.o(38040);
    return bool;
  }
  
  public static boolean a(cm paramcm, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(38038);
    if ((v.abR(paramString)) || (paramCharSequence == null))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcm.cpR.cpX = 2131299713;
      AppMethodBeat.o(38038);
      return false;
    }
    if (ag.coN())
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcm.cpR.cpX = 2131299731;
      AppMethodBeat.o(38038);
      return false;
    }
    paramString = ag.cpf().abv(paramString);
    if (paramString == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38038);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcm.cpR.cpX = 2131299712;
      AppMethodBeat.o(38038);
      return false;
    }
    String str = String.format("%s#0", new Object[] { i.lq(paramString.field_snsId) });
    acq localacq = new acq();
    acw localacw = new acw();
    ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localacw.aon(paramString.field_userName);
    localacw.aoo(r.Zn());
    localacw.MR(2);
    localacw.nI(paramString.field_createTime * 1000L);
    localacw.aos(paramString.getSnsId());
    localacw.aop(str);
    localacq.a(localacw);
    paramcm.cpR.cpT = localacq;
    paramcm.cpR.desc = paramCharSequence.toString();
    paramcm.cpR.type = 1;
    AppMethodBeat.o(38038);
    return true;
  }
  
  public static boolean a(cm paramcm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(156759);
    boolean bool = b(paramcm, paramString1, paramString2);
    AppMethodBeat.o(156759);
    return bool;
  }
  
  private static boolean a(acq paramacq, TimeLineObject paramTimeLineObject, adf paramadf)
  {
    AppMethodBeat.i(145448);
    if ((paramTimeLineObject.xTS.wOd == null) || (paramTimeLineObject.xTS.wOd.fgj != 1))
    {
      AppMethodBeat.o(145448);
      return false;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rT(paramTimeLineObject.xTS.wOd.wqp))
    {
      AppMethodBeat.o(145448);
      return false;
    }
    bbs localbbs = paramTimeLineObject.xTS.wOd;
    aci localaci = new aci();
    paramacq.c(localaci);
    localaci.fgj = 1;
    localaci.fgh = localbbs.wqp;
    localaci.fgi = localbbs.fgi;
    localaci.duration = localbbs.duration;
    localaci.fgk = localbbs.fgk;
    localaci.fgl = localbbs.fgl;
    localaci.videoWidth = localbbs.videoWidth;
    localaci.videoHeight = localbbs.videoHeight;
    localaci.cqX = paramTimeLineObject.xTT;
    localaci.fjB = paramTimeLineObject.vSR;
    localaci.fjJ = localbbs.lHo;
    paramadf.aoB(localbbs.desc);
    AppMethodBeat.o(145448);
    return true;
  }
  
  public static boolean b(cm paramcm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(38037);
    if ((paramcm == null) || (!v.abQ(paramString2)) || (paramString1 == null))
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcm != null) {
        paramcm.cpR.cpX = 2131299713;
      }
      AppMethodBeat.o(38037);
      return false;
    }
    if (ag.coN())
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcm.cpR.cpX = 2131299731;
      AppMethodBeat.o(38037);
      return false;
    }
    Object localObject1 = h.abv(paramString2);
    if (localObject1 == null)
    {
      ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcm.cpR.cpX = 2131299714;
      AppMethodBeat.o(38037);
      return false;
    }
    if ((((n)localObject1).csh().xTS != null) && (((n)localObject1).csh().xTS.wNZ == 26))
    {
      boolean bool = a(paramcm, paramString2);
      AppMethodBeat.o(38037);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = ak.a((n)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((bcs)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { i.lq(((n)localObject1).field_snsId), paramString2 });
    paramString2 = new acq();
    acw localacw = new acw();
    ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((n)localObject1).field_userName });
    localacw.aon(((n)localObject1).field_userName);
    localacw.aoo(r.Zn());
    localacw.MR(2);
    localacw.nI(((n)localObject1).field_createTime * 1000L);
    localacw.aos(((n)localObject1).getSnsId());
    localacw.aop((String)localObject3);
    localacw.aou(paramString1);
    paramString1 = new aca();
    paramString1.anI((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject2).Id) + i.e((bcs)localObject2);
      if (e.cN((String)localObject3)) {
        paramString1.anF((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.MI(5);
      localObject1 = ((n)localObject1).csh();
      paramString1.anq(((TimeLineObject)localObject1).xTS.Title);
      paramString1.anr(((TimeLineObject)localObject1).xTS.Desc);
      paramString1.anP(((TimeLineObject)localObject1).sbN);
      if (!bo.isNullOrNil(((TimeLineObject)localObject1).sbN))
      {
        localObject2 = br.F(((TimeLineObject)localObject1).sbN, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.anq(bo.bf((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.anr(bo.bf((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.py(true);
      paramString2.wVc.add(paramString1);
      localObject2 = new adf();
      ((adf)localObject2).MT(((TimeLineObject)localObject1).fgB);
      ((adf)localObject2).aoA(paramString1.title);
      paramString2.b((adf)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (adf)localObject2);
      paramString2.a(localacw);
      paramcm.cpR.cpT = paramString2;
      paramcm.cpR.desc = ((TimeLineObject)localObject1).xTS.Title;
      paramcm.cpR.type = 5;
      AppMethodBeat.o(38037);
      return true;
      paramString1.pz(true);
      paramString1.anz(((bcs)localObject2).xrS);
      localObject3 = new adf();
      ((adf)localObject3).aoD(((bcs)localObject2).xrS);
      paramString2.b((adf)localObject3);
      continue;
      paramString1.pz(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */