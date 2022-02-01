package com.tencent.mm.plugin.sns.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(afy paramafy, p paramp)
  {
    AppMethodBeat.i(97662);
    if (paramp != null) {
      a(paramafy, paramp.dxy());
    }
    AppMethodBeat.o(97662);
  }
  
  private static void a(afy paramafy, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramafy != null) && (paramTimeLineObject != null) && (!bt.isNullOrNil(paramTimeLineObject.xns))) {
      paramafy.aDJ(paramTimeLineObject.xns);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(cs paramcs, p paramp)
  {
    AppMethodBeat.i(97654);
    if (paramp == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(97654);
      return false;
    }
    ago localago = new ago();
    Object localObject2 = new agu();
    TimeLineObject localTimeLineObject = paramp.dxy();
    bpi localbpi = (bpi)localTimeLineObject.Etm.DaC.get(0);
    if ((paramp.Nb(32)) && (localTimeLineObject.Etm.DaB == 15))
    {
      localTimeLineObject.Etr.gJB = paramp.dxu().dvK;
      localTimeLineObject.Etr.gJC = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId), localbpi.Id });
    ((agu)localObject2).aEl(paramp.field_userName);
    ((agu)localObject2).aEm(u.aqG());
    ((agu)localObject2).VM(2);
    ((agu)localObject2).vv(bt.eGO());
    ((agu)localObject2).aEq(paramp.getSnsId());
    ((agu)localObject2).aEn((String)localObject1);
    localago.a((agu)localObject2);
    localObject2 = new afy();
    ((afy)localObject2).aDD((String)localObject1);
    localObject1 = an.iF(af.getAccSnsPath(), localbpi.Id);
    Object localObject4 = com.tencent.mm.plugin.sns.data.q.i(localbpi);
    Object localObject3 = com.tencent.mm.plugin.sns.data.q.d(localbpi);
    if (bt.isNullOrNil(at.a(paramp.dxX(), localbpi)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcs.deQ.deV = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!i.eK((String)localObject1 + (String)localObject4))
    {
      ad.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + i.eK(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + i.eK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcs.deQ.deV = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!i.eK((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localbpi.DMT != null)
      {
        j = m;
        i = k;
        if (localbpi.DMT.DNI > 0.0F)
        {
          j = m;
          i = k;
          if (localbpi.DMT.DNH > 0.0F)
          {
            i = (int)localbpi.DMT.DNH;
            j = (int)localbpi.DMT.DNI;
          }
        }
      }
      localBitmap = e.at((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        ad.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + i.eK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcs.deQ.deV = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        f.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((afy)localObject2).aDz((String)localObject1 + (String)localObject4);
        ((afy)localObject2).aDA((String)localObject1 + (String)localObject3);
        if (bt.isNullOrNil(localbpi.DNb))
        {
          localObject1 = localTimeLineObject.Etj;
          ((afy)localObject2).aDl((String)localObject1);
          ((afy)localObject2).aDK(localTimeLineObject.xpl);
          if (!bt.isNullOrNil(localTimeLineObject.xpl))
          {
            localObject1 = bw.K(localTimeLineObject.xpl, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((afy)localObject2).aDl(bt.by((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((afy)localObject2).aDm(bt.by((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramp.Nb(32)) {
            break label1254;
          }
          localObject3 = paramp.dxs();
          localObject4 = new agb();
          if (!bt.isNullOrNil(localbpi.DNb)) {
            break label1224;
          }
          localObject1 = localTimeLineObject.Etj;
          ((agb)localObject4).gJx = ((String)localObject1);
          ((agb)localObject4).Dim = localbpi.xMj;
          ((agb)localObject4).gJv = localbpi.DMX;
          ((agb)localObject4).gJB = localTimeLineObject.Etr.gJB;
          ((agb)localObject4).gJC = localTimeLineObject.Etr.gJC;
          if (bt.isNullOrNil(((agb)localObject4).gJC)) {
            ((agb)localObject4).gJC = localTimeLineObject.Id;
          }
          if (!bt.isNullOrNil(localbpi.DNa)) {
            break label1234;
          }
          localObject1 = localbpi.DMQ;
          ((agb)localObject4).gJA = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).wSS == 0))
          {
            ((agb)localObject4).gJz = ((com.tencent.mm.plugin.sns.storage.b)localObject3).wSU;
            ((agb)localObject4).gJy = ((com.tencent.mm.plugin.sns.storage.b)localObject3).wST;
          }
          ((afy)localObject2).a((agb)localObject4);
          i = 16;
          j = 15;
          ((afy)localObject2).VD(j);
          localObject1 = e.ano(((afy)localObject2).Dgx);
          if (localObject1 == null) {
            break label1244;
          }
          ((afy)localObject2).VC(((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localago.bd((LinkedList)localObject1);
          paramcs.deQ.deS = localago;
          paramcs.deQ.type = i;
          a((afy)localObject2, paramp);
          ad.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramp)
      {
        ad.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramp, "save bmp error %s", new Object[] { paramp.getMessage() });
        ad.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + i.eK(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcs.deQ.deV = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localbpi.DNb;
      continue;
      label1224:
      localObject1 = localbpi.DNb;
      continue;
      label1234:
      localObject1 = localbpi.DNa;
      continue;
      label1244:
      ((afy)localObject2).VC(1);
      continue;
      label1254:
      i = 4;
    }
  }
  
  public static boolean a(cs paramcs, p paramp, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramcs == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramp == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    bpi localbpi = aj.a(paramp, paramString);
    if (localbpi == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId), paramString });
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramp.field_userName });
    localagu.aEl(paramp.field_userName);
    localagu.aEm(u.aqG());
    localagu.VM(2);
    localagu.vv(paramp.field_createTime * 1000L);
    localagu.aEq(paramp.getSnsId());
    localagu.aEn(str);
    localafy.aDD(str);
    localafy.aDz(an.iF(af.getAccSnsPath(), paramString) + com.tencent.mm.plugin.sns.data.q.k(localbpi));
    if (paramp.dxy() != null)
    {
      localafy.aDK(paramp.dxy().xpl);
      if (!bt.isNullOrNil(paramp.dxy().xpl))
      {
        paramString = bw.K(paramp.dxy().xpl, "adxml");
        if (paramString.size() > 0)
        {
          localafy.aDl(bt.by((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localafy.aDm(bt.by((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localafy, paramp);
    paramString = an.iF(af.getAccSnsPath(), localbpi.Id) + com.tencent.mm.plugin.sns.data.q.d(localbpi);
    if ((!i.eK(localafy.Dgx)) && (paramp.field_userName.endsWith(af.dta())))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    if (i.eK(paramString)) {
      localafy.aDA(paramString);
    }
    for (;;)
    {
      localafy.VD(2);
      localago.mVb.add(localafy);
      localago.a(localagu);
      paramcs.deQ.deS = localago;
      paramcs.deQ.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localafy.ux(true);
      localafy.aDu(localbpi.DMQ);
      paramp = new ahd();
      paramp.aEB(localbpi.DMQ);
      localago.b(paramp);
    }
  }
  
  public static boolean a(cs paramcs, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramcs == null) || (!x.aqh(paramString)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (af.dtd())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.deQ.deV = 2131758903;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = h.apK(paramString);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = aj.a((p)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((bpi)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(((p)localObject1).field_snsId), paramString });
    localObject2 = new agu();
    paramString = ((p)localObject1).dxy();
    if (paramString == null)
    {
      ad.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((p)localObject1).field_userName });
    ((agu)localObject2).aEl(((p)localObject1).field_userName);
    ((agu)localObject2).aEm(u.aqG());
    ((agu)localObject2).VM(2);
    ((agu)localObject2).vv(((p)localObject1).field_createTime * 1000L);
    ((agu)localObject2).aEq(((p)localObject1).getSnsId());
    ((agu)localObject2).aEn(str);
    localObject1 = new gs();
    ((gs)localObject1).dkc.type = 30;
    ((gs)localObject1).dkc.dkj = 4;
    ((gs)localObject1).dkc.desc = paramString.Etm.DaE;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    ((gs)localObject1).dkc.deS.a((agu)localObject2);
    paramcs.deQ.deS = ((gs)localObject1).dkc.deS;
    if (paramcs.deQ.deS != null)
    {
      localObject1 = paramcs.deQ.deS.mVb;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (afy)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((afy)localObject2).uw(true);
            ((afy)localObject2).ux(true);
          }
          i += 1;
        }
      }
    }
    paramcs.deQ.desc = paramString.Etm.Title;
    paramcs.deQ.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(cs paramcs, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((x.aqi(paramString)) || (paramInt < 0))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(97660);
      return false;
    }
    if (af.dtd())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.deQ.deV = 2131758903;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = af.dtu().apK(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    bpi localbpi = aj.a(paramString, paramInt);
    if (localbpi == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramcs, paramString, localbpi.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(cs paramcs, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((x.aqi(paramString)) || (paramCharSequence == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(97658);
      return false;
    }
    if (af.dtd())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.deQ.deV = 2131758903;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = af.dtu().apK(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramString.field_snsId) });
    ago localago = new ago();
    agu localagu = new agu();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localagu.aEl(paramString.field_userName);
    localagu.aEm(u.aqG());
    localagu.VM(2);
    localagu.vv(paramString.field_createTime * 1000L);
    localagu.aEq(paramString.getSnsId());
    localagu.aEn(str);
    localago.a(localagu);
    paramcs.deQ.deS = localago;
    paramcs.deQ.desc = paramCharSequence.toString();
    paramcs.deQ.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(cs paramcs, String paramString1, String paramString2)
  {
    AppMethodBeat.i(201282);
    boolean bool = b(paramcs, paramString1, paramString2);
    AppMethodBeat.o(201282);
    return bool;
  }
  
  private static boolean a(ago paramago, TimeLineObject paramTimeLineObject, ahd paramahd)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.Etm.DaF == null) || (paramTimeLineObject.Etm.DaF.gKq == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    bnt localbnt = paramTimeLineObject.Etm.DaF;
    agg localagg = new agg();
    paramago.f(localagg);
    localagg.gGz = paramTimeLineObject.Etm.DaF.gGz;
    localagg.gGx = localbnt.gKq;
    localagg.gGA = localbnt.gGA;
    localagg.gGy = localbnt.gGy;
    localagg.duration = localbnt.duration;
    localagg.gGB = localbnt.gGB;
    localagg.gGC = localbnt.gGC;
    localagg.videoWidth = localbnt.videoWidth;
    localagg.videoHeight = localbnt.videoHeight;
    localagg.dfT = paramTimeLineObject.Etn;
    localagg.gKv = paramTimeLineObject.BXw;
    localagg.gKD = localbnt.coverUrl;
    paramahd.aEz(localbnt.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(cs paramcs, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramcs == null) || (!x.aqh(paramString2)) || (paramString1 == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (af.dtd())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcs.deQ.deV = 2131758903;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = h.apK(paramString2);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcs.deQ.deV = 2131758886;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((p)localObject1).dxy().Etm != null) && (((p)localObject1).dxy().Etm.DaB == 26))
    {
      boolean bool = a(paramcs, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = aj.a((p)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((bpi)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(((p)localObject1).field_snsId), paramString2 });
    paramString2 = new ago();
    agu localagu = new agu();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((p)localObject1).field_userName });
    localagu.aEl(((p)localObject1).field_userName);
    localagu.aEm(u.aqG());
    localagu.VM(2);
    localagu.vv(((p)localObject1).field_createTime * 1000L);
    localagu.aEq(((p)localObject1).getSnsId());
    localagu.aEn((String)localObject3);
    localagu.aEs(paramString1);
    paramString1 = new afy();
    paramString1.aDD((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject2);
      if (i.eK((String)localObject3)) {
        paramString1.aDA((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.VD(5);
      localObject1 = ((p)localObject1).dxy();
      paramString1.aDl(((TimeLineObject)localObject1).Etm.Title);
      paramString1.aDm(((TimeLineObject)localObject1).Etm.Desc);
      paramString1.aDK(((TimeLineObject)localObject1).xpl);
      if (!bt.isNullOrNil(((TimeLineObject)localObject1).xpl))
      {
        localObject2 = bw.K(((TimeLineObject)localObject1).xpl, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.aDl(bt.by((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.aDm(bt.by((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.uw(true);
      paramString2.mVb.add(paramString1);
      localObject2 = new ahd();
      ((ahd)localObject2).VO(((TimeLineObject)localObject1).gHj);
      ((ahd)localObject2).aEy(paramString1.title);
      if ((((TimeLineObject)localObject1).wLn != null) && (!bt.isNullOrNil(((TimeLineObject)localObject1).wLn.AGs)))
      {
        paramString1 = new ab();
        paramString1.AGs = ((TimeLineObject)localObject1).wLn.AGs;
        paramString1.AGt = ((TimeLineObject)localObject1).wLn.AGt;
        paramString1.AGu = ((TimeLineObject)localObject1).wLn.AGu;
        paramString1.AGv = ((TimeLineObject)localObject1).wLn.AGv;
        paramString1.AGw = ((TimeLineObject)localObject1).wLn.AGw;
        paramString1.oYa = ((TimeLineObject)localObject1).wLn.oYa;
        paramString1.oYb = ((TimeLineObject)localObject1).wLn.oYb;
        paramString1.rUO = ((TimeLineObject)localObject1).wLn.rUO;
        paramString1.AGx = ((TimeLineObject)localObject1).wLn.AGx;
        paramString1.AGy = ((TimeLineObject)localObject1).wLn.AGy;
        paramString1.AGz = ((TimeLineObject)localObject1).wLn.AGz;
        paramString1.source = ((TimeLineObject)localObject1).wLn.source;
        paramString1.kqB = ((TimeLineObject)localObject1).wLn.kqB;
        paramString1.AGA = ((TimeLineObject)localObject1).wLn.AGA;
        paramString1.AGB = ((TimeLineObject)localObject1).wLn.AGB;
        paramString1.AGC = ((TimeLineObject)localObject1).wLn.AGC;
        paramString1.AGD = ((TimeLineObject)localObject1).wLn.AGD;
        paramString1.AGE = ((TimeLineObject)localObject1).wLn.AGE;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).wLn.thumbUrl;
        paramString1.AGF = ((TimeLineObject)localObject1).wLn.AGF;
        localObject3 = new StringBuilder();
        paramString1.b((StringBuilder)localObject3, null, null, null, 0, 0);
        ((ahd)localObject2).aED(((StringBuilder)localObject3).toString());
      }
      paramString2.b((ahd)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (ahd)localObject2);
      paramString2.a(localagu);
      paramcs.deQ.deS = paramString2;
      paramcs.deQ.desc = ((TimeLineObject)localObject1).Etm.Title;
      paramcs.deQ.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.ux(true);
      paramString1.aDu(((bpi)localObject2).DMQ);
      localObject3 = new ahd();
      ((ahd)localObject3).aEB(((bpi)localObject2).DMQ);
      paramString2.b((ahd)localObject3);
      continue;
      paramString1.ux(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.a
 * JD-Core Version:    0.7.0.1
 */