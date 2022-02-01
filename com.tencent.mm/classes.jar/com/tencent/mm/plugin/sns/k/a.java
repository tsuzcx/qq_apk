package com.tencent.mm.plugin.sns.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(agx paramagx, p paramp)
  {
    AppMethodBeat.i(97662);
    if (paramp != null) {
      a(paramagx, paramp.dLV());
    }
    AppMethodBeat.o(97662);
  }
  
  private static void a(agx paramagx, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramagx != null) && (paramTimeLineObject != null) && (!bs.isNullOrNil(paramTimeLineObject.yAj))) {
      paramagx.aJa(paramTimeLineObject.yAj);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(cs paramcs, p paramp)
  {
    AppMethodBeat.i(97654);
    if (paramp == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(97654);
      return false;
    }
    ahn localahn = new ahn();
    Object localObject2 = new aht();
    TimeLineObject localTimeLineObject = paramp.dLV();
    btz localbtz = (btz)localTimeLineObject.FQo.Etz.get(0);
    if ((paramp.Pe(32)) && (localTimeLineObject.FQo.Ety == 15))
    {
      localTimeLineObject.FQt.hkb = paramp.dFQ().dtx;
      localTimeLineObject.FQt.hkc = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId), localbtz.Id });
    ((aht)localObject2).aJC(paramp.field_userName);
    ((aht)localObject2).aJD(u.axw());
    ((aht)localObject2).XV(2);
    ((aht)localObject2).zY(bs.eWj());
    ((aht)localObject2).aJH(paramp.getSnsId());
    ((aht)localObject2).aJE((String)localObject1);
    localahn.a((aht)localObject2);
    localObject2 = new agx();
    ((agx)localObject2).aIU((String)localObject1);
    localObject1 = an.jc(af.getAccSnsPath(), localbtz.Id);
    Object localObject4 = com.tencent.mm.plugin.sns.data.q.i(localbtz);
    Object localObject3 = com.tencent.mm.plugin.sns.data.q.d(localbtz);
    if (bs.isNullOrNil(au.a(paramp.dMu(), localbtz)))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcs.dck.dcp = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!i.eA((String)localObject1 + (String)localObject4))
    {
      ac.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + i.eA(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + i.eA(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcs.dck.dcp = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!i.eA((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localbtz.Fjk != null)
      {
        j = m;
        i = k;
        if (localbtz.Fjk.FjZ > 0.0F)
        {
          j = m;
          i = k;
          if (localbtz.Fjk.FjY > 0.0F)
          {
            i = (int)localbtz.Fjk.FjY;
            j = (int)localbtz.Fjk.FjZ;
          }
        }
      }
      localBitmap = e.as((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        ac.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + i.eA(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcs.dck.dcp = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        f.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((agx)localObject2).aIQ((String)localObject1 + (String)localObject4);
        ((agx)localObject2).aIR((String)localObject1 + (String)localObject3);
        if (bs.isNullOrNil(localbtz.Fjs))
        {
          localObject1 = localTimeLineObject.FQl;
          ((agx)localObject2).aIC((String)localObject1);
          ((agx)localObject2).aJb(localTimeLineObject.yCb);
          if (!bs.isNullOrNil(localTimeLineObject.yCb))
          {
            localObject1 = bv.L(localTimeLineObject.yCb, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((agx)localObject2).aIC(bs.bG((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((agx)localObject2).aID(bs.bG((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramp.Pe(32)) {
            break label1254;
          }
          localObject3 = paramp.dFR();
          localObject4 = new aha();
          if (!bs.isNullOrNil(localbtz.Fjs)) {
            break label1224;
          }
          localObject1 = localTimeLineObject.FQl;
          ((aha)localObject4).hjX = ((String)localObject1);
          ((aha)localObject4).EBs = localbtz.yYY;
          ((aha)localObject4).hjV = localbtz.Fjo;
          ((aha)localObject4).hkb = localTimeLineObject.FQt.hkb;
          ((aha)localObject4).hkc = localTimeLineObject.FQt.hkc;
          if (bs.isNullOrNil(((aha)localObject4).hkc)) {
            ((aha)localObject4).hkc = localTimeLineObject.Id;
          }
          if (!bs.isNullOrNil(localbtz.Fjr)) {
            break label1234;
          }
          localObject1 = localbtz.Fjh;
          ((aha)localObject4).hka = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfC == 0))
          {
            ((aha)localObject4).hjZ = ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfE;
            ((aha)localObject4).hjY = ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfD;
          }
          ((agx)localObject2).a((aha)localObject4);
          i = 16;
          j = 15;
          ((agx)localObject2).XM(j);
          localObject1 = e.asx(((agx)localObject2).EzD);
          if (localObject1 == null) {
            break label1244;
          }
          ((agx)localObject2).XL(((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localahn.bk((LinkedList)localObject1);
          paramcs.dck.dcm = localahn;
          paramcs.dck.type = i;
          a((agx)localObject2, paramp);
          ac.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramp)
      {
        ac.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramp, "save bmp error %s", new Object[] { paramp.getMessage() });
        ac.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + i.eA(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcs.dck.dcp = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localbtz.Fjs;
      continue;
      label1224:
      localObject1 = localbtz.Fjs;
      continue;
      label1234:
      localObject1 = localbtz.Fjr;
      continue;
      label1244:
      ((agx)localObject2).XL(1);
      continue;
      label1254:
      i = 4;
    }
  }
  
  public static boolean a(cs paramcs, p paramp, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramcs == null) || (bs.isNullOrNil(paramString)))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramp == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    btz localbtz = aj.a(paramp, paramString);
    if (localbtz == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId), paramString });
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    ac.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramp.field_userName });
    localaht.aJC(paramp.field_userName);
    localaht.aJD(u.axw());
    localaht.XV(2);
    localaht.zY(paramp.field_createTime * 1000L);
    localaht.aJH(paramp.getSnsId());
    localaht.aJE(str);
    localagx.aIU(str);
    localagx.aIQ(an.jc(af.getAccSnsPath(), paramString) + com.tencent.mm.plugin.sns.data.q.k(localbtz));
    if (paramp.dLV() != null)
    {
      localagx.aJb(paramp.dLV().yCb);
      if (!bs.isNullOrNil(paramp.dLV().yCb))
      {
        paramString = bv.L(paramp.dLV().yCb, "adxml");
        if (paramString.size() > 0)
        {
          localagx.aIC(bs.bG((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localagx.aID(bs.bG((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localagx, paramp);
    paramString = an.jc(af.getAccSnsPath(), localbtz.Id) + com.tencent.mm.plugin.sns.data.q.d(localbtz);
    if ((!i.eA(localagx.EzD)) && (paramp.field_userName.endsWith(af.dHx())))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    if (i.eA(paramString)) {
      localagx.aIR(paramString);
    }
    for (;;)
    {
      localagx.XM(2);
      localahn.nxC.add(localagx);
      localahn.a(localaht);
      paramcs.dck.dcm = localahn;
      paramcs.dck.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localagx.vz(true);
      localagx.aIL(localbtz.Fjh);
      paramp = new aic();
      paramp.aJS(localbtz.Fjh);
      localahn.b(paramp);
    }
  }
  
  public static boolean a(cs paramcs, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramcs == null) || (!x.avq(paramString)))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (af.dHA())
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.dck.dcp = 2131758903;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = h.auT(paramString);
    if (localObject1 == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = aj.a((p)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((btz)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(((p)localObject1).field_snsId), paramString });
    localObject2 = new aht();
    paramString = ((p)localObject1).dLV();
    if (paramString == null)
    {
      ac.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    ac.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((p)localObject1).field_userName });
    ((aht)localObject2).aJC(((p)localObject1).field_userName);
    ((aht)localObject2).aJD(u.axw());
    ((aht)localObject2).XV(2);
    ((aht)localObject2).zY(((p)localObject1).field_createTime * 1000L);
    ((aht)localObject2).aJH(((p)localObject1).getSnsId());
    ((aht)localObject2).aJE(str);
    localObject1 = new gt();
    ((gt)localObject1).dhx.type = 30;
    ((gt)localObject1).dhx.dhE = 4;
    ((gt)localObject1).dhx.desc = paramString.FQo.EtB;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    ((gt)localObject1).dhx.dcm.a((aht)localObject2);
    paramcs.dck.dcm = ((gt)localObject1).dhx.dcm;
    if (paramcs.dck.dcm != null)
    {
      localObject1 = paramcs.dck.dcm.nxC;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (agx)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((agx)localObject2).vy(true);
            ((agx)localObject2).vz(true);
          }
          i += 1;
        }
      }
    }
    paramcs.dck.desc = paramString.FQo.Title;
    paramcs.dck.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(cs paramcs, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((x.avr(paramString)) || (paramInt < 0))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(97660);
      return false;
    }
    if (af.dHA())
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.dck.dcp = 2131758903;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = af.dHR().auT(paramString);
    if (paramString == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    btz localbtz = aj.a(paramString, paramInt);
    if (localbtz == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramcs, paramString, localbtz.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(cs paramcs, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((x.avr(paramString)) || (paramCharSequence == null))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(97658);
      return false;
    }
    if (af.dHA())
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.dck.dcp = 2131758903;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = af.dHR().auT(paramString);
    if (paramString == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramString.field_snsId) });
    ahn localahn = new ahn();
    aht localaht = new aht();
    ac.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localaht.aJC(paramString.field_userName);
    localaht.aJD(u.axw());
    localaht.XV(2);
    localaht.zY(paramString.field_createTime * 1000L);
    localaht.aJH(paramString.getSnsId());
    localaht.aJE(str);
    localahn.a(localaht);
    paramcs.dck.dcm = localahn;
    paramcs.dck.desc = paramCharSequence.toString();
    paramcs.dck.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(cs paramcs, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210270);
    boolean bool = b(paramcs, paramString1, paramString2);
    AppMethodBeat.o(210270);
    return bool;
  }
  
  private static boolean a(ahn paramahn, TimeLineObject paramTimeLineObject, aic paramaic)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.FQo.EtC == null) || (paramTimeLineObject.FQo.EtC.hkQ == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    bsj localbsj = paramTimeLineObject.FQo.EtC;
    ahf localahf = new ahf();
    paramahn.f(localahf);
    localahf.hha = paramTimeLineObject.FQo.EtC.hha;
    localahf.hgY = localbsj.hkQ;
    localahf.hhb = localbsj.hhb;
    localahf.hgZ = localbsj.hgZ;
    localahf.duration = localbsj.duration;
    localahf.hhc = localbsj.hhc;
    localahf.hhd = localbsj.hhd;
    localahf.videoWidth = localbsj.videoWidth;
    localahf.videoHeight = localbsj.videoHeight;
    localahf.ddo = paramTimeLineObject.FQp;
    localahf.hkV = paramTimeLineObject.DpN;
    localahf.hld = localbsj.coverUrl;
    paramaic.aJQ(localbsj.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(cs paramcs, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramcs == null) || (!x.avq(paramString2)) || (paramString1 == null))
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (af.dHA())
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.dck.dcp = 2131758903;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = h.auT(paramString2);
    if (localObject1 == null)
    {
      ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.dck.dcp = 2131758886;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((p)localObject1).dLV().FQo != null) && (((p)localObject1).dLV().FQo.Ety == 26))
    {
      boolean bool = a(paramcs, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = aj.a((p)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((btz)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(((p)localObject1).field_snsId), paramString2 });
    paramString2 = new ahn();
    aht localaht = new aht();
    ac.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((p)localObject1).field_userName });
    localaht.aJC(((p)localObject1).field_userName);
    localaht.aJD(u.axw());
    localaht.XV(2);
    localaht.zY(((p)localObject1).field_createTime * 1000L);
    localaht.aJH(((p)localObject1).getSnsId());
    localaht.aJE((String)localObject3);
    localaht.aJJ(paramString1);
    paramString1 = new agx();
    paramString1.aIU((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = an.jc(af.getAccSnsPath(), ((btz)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((btz)localObject2);
      if (i.eA((String)localObject3)) {
        paramString1.aIR((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.XM(5);
      localObject1 = ((p)localObject1).dLV();
      paramString1.aIC(((TimeLineObject)localObject1).FQo.Title);
      paramString1.aID(((TimeLineObject)localObject1).FQo.Desc);
      paramString1.aJb(((TimeLineObject)localObject1).yCb);
      if (!bs.isNullOrNil(((TimeLineObject)localObject1).yCb))
      {
        localObject2 = bv.L(((TimeLineObject)localObject1).yCb, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.aIC(bs.bG((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.aID(bs.bG((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.vy(true);
      paramString2.nxC.add(paramString1);
      localObject2 = new aic();
      ((aic)localObject2).XX(((TimeLineObject)localObject1).hhK);
      ((aic)localObject2).aJP(paramString1.title);
      if ((((TimeLineObject)localObject1).xXT != null) && (!bs.isNullOrNil(((TimeLineObject)localObject1).xXT.BYK)))
      {
        paramString1 = new aa();
        paramString1.BYK = ((TimeLineObject)localObject1).xXT.BYK;
        paramString1.BYL = ((TimeLineObject)localObject1).xXT.BYL;
        paramString1.BYM = ((TimeLineObject)localObject1).xXT.BYM;
        paramString1.BYN = ((TimeLineObject)localObject1).xXT.BYN;
        paramString1.BYO = ((TimeLineObject)localObject1).xXT.BYO;
        paramString1.pBl = ((TimeLineObject)localObject1).xXT.pBl;
        paramString1.pBm = ((TimeLineObject)localObject1).xXT.pBm;
        paramString1.tcG = ((TimeLineObject)localObject1).xXT.tcG;
        paramString1.BYP = ((TimeLineObject)localObject1).xXT.BYP;
        paramString1.BYQ = ((TimeLineObject)localObject1).xXT.BYQ;
        paramString1.BYR = ((TimeLineObject)localObject1).xXT.BYR;
        paramString1.source = ((TimeLineObject)localObject1).xXT.source;
        paramString1.kRU = ((TimeLineObject)localObject1).xXT.kRU;
        paramString1.BYS = ((TimeLineObject)localObject1).xXT.BYS;
        paramString1.BYT = ((TimeLineObject)localObject1).xXT.BYT;
        paramString1.BYU = ((TimeLineObject)localObject1).xXT.BYU;
        paramString1.BYV = ((TimeLineObject)localObject1).xXT.BYV;
        paramString1.BYW = ((TimeLineObject)localObject1).xXT.BYW;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).xXT.thumbUrl;
        paramString1.BYX = ((TimeLineObject)localObject1).xXT.BYX;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((aic)localObject2).aJU(((StringBuilder)localObject3).toString());
      }
      paramString2.b((aic)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (aic)localObject2);
      paramString2.a(localaht);
      paramcs.dck.dcm = paramString2;
      paramcs.dck.desc = ((TimeLineObject)localObject1).FQo.Title;
      paramcs.dck.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.vz(true);
      paramString1.aIL(((btz)localObject2).Fjh);
      localObject3 = new aic();
      ((aic)localObject3).aJS(((btz)localObject2).Fjh);
      paramString2.b((aic)localObject3);
      continue;
      paramString1.vz(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */