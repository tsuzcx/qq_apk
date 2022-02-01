package com.tencent.mm.plugin.sns.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(ajn paramajn, p paramp)
  {
    AppMethodBeat.i(97662);
    if (paramp != null) {
      a(paramajn, paramp.dYl());
    }
    AppMethodBeat.o(97662);
  }
  
  public static void a(ajn paramajn, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramajn != null) && (paramTimeLineObject != null) && (!bt.isNullOrNil(paramTimeLineObject.zRz))) {
      paramajn.aOD(paramTimeLineObject.zRz);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(cv paramcv, p paramp)
  {
    AppMethodBeat.i(97654);
    if (paramp == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(97654);
      return false;
    }
    akd localakd = new akd();
    Object localObject2 = new akj();
    TimeLineObject localTimeLineObject = paramp.dYl();
    byn localbyn = (byn)localTimeLineObject.HAT.GaQ.get(0);
    if ((paramp.QM(32)) && (localTimeLineObject.HAT.GaP == 15))
    {
      localTimeLineObject.HAY.hCk = paramp.dRK().dFy;
      localTimeLineObject.HAY.hCl = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramp.field_snsId), localbyn.Id });
    ((akj)localObject2).aPf(paramp.field_userName);
    ((akj)localObject2).aPg(u.aAm());
    ((akj)localObject2).ZR(2);
    ((akj)localObject2).CM(bt.flT());
    ((akj)localObject2).aPk(paramp.getSnsId());
    ((akj)localObject2).aPh((String)localObject1);
    localakd.a((akj)localObject2);
    localObject2 = new ajn();
    ((ajn)localObject2).aOx((String)localObject1);
    localObject1 = ao.jo(ag.getAccSnsPath(), localbyn.Id);
    Object localObject4 = com.tencent.mm.plugin.sns.data.q.i(localbyn);
    Object localObject3 = com.tencent.mm.plugin.sns.data.q.d(localbyn);
    if (bt.isNullOrNil(av.a(paramp.dYK(), localbyn)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcv.dnG.dnL = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!i.fv((String)localObject1 + (String)localObject4))
    {
      ad.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + i.fv(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + i.fv(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcv.dnG.dnL = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!i.fv((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localbyn.GSL != null)
      {
        j = m;
        i = k;
        if (localbyn.GSL.GTA > 0.0F)
        {
          j = m;
          i = k;
          if (localbyn.GSL.GTz > 0.0F)
          {
            i = (int)localbyn.GSL.GTz;
            j = (int)localbyn.GSL.GTA;
          }
        }
      }
      localBitmap = e.av((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        ad.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + i.fv(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcv.dnG.dnL = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        g.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((ajn)localObject2).aOt((String)localObject1 + (String)localObject4);
        ((ajn)localObject2).aOu((String)localObject1 + (String)localObject3);
        if (bt.isNullOrNil(localbyn.GST))
        {
          localObject1 = localTimeLineObject.HAQ;
          ((ajn)localObject2).aOf((String)localObject1);
          ((ajn)localObject2).aOE(localTimeLineObject.zTv);
          if (!bt.isNullOrNil(localTimeLineObject.zTv))
          {
            localObject1 = bw.M(localTimeLineObject.zTv, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((ajn)localObject2).aOf(bt.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((ajn)localObject2).aOg(bt.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramp.QM(32)) {
            break label1254;
          }
          localObject3 = paramp.dRL();
          localObject4 = new ajq();
          if (!bt.isNullOrNil(localbyn.GST)) {
            break label1224;
          }
          localObject1 = localTimeLineObject.HAQ;
          ((ajq)localObject4).hCg = ((String)localObject1);
          ((ajq)localObject4).Gje = localbyn.AqM;
          ((ajq)localObject4).hCe = localbyn.GSP;
          ((ajq)localObject4).hCk = localTimeLineObject.HAY.hCk;
          ((ajq)localObject4).hCl = localTimeLineObject.HAY.hCl;
          if (bt.isNullOrNil(((ajq)localObject4).hCl)) {
            ((ajq)localObject4).hCl = localTimeLineObject.Id;
          }
          if (!bt.isNullOrNil(localbyn.GSS)) {
            break label1234;
          }
          localObject1 = localbyn.GSI;
          ((ajq)localObject4).hCj = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvE == 0))
          {
            ((ajq)localObject4).hCi = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvG;
            ((ajq)localObject4).hCh = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvF;
          }
          ((ajn)localObject2).a((ajq)localObject4);
          i = 16;
          j = 15;
          ((ajn)localObject2).ZI(j);
          localObject1 = e.axx(((ajn)localObject2).Ghp);
          if (localObject1 == null) {
            break label1244;
          }
          ((ajn)localObject2).ZH(((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localakd.bl((LinkedList)localObject1);
          paramcv.dnG.dnI = localakd;
          paramcv.dnG.type = i;
          a((ajn)localObject2, paramp);
          ad.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramp)
      {
        ad.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramp, "save bmp error %s", new Object[] { paramp.getMessage() });
        ad.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + i.fv(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcv.dnG.dnL = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localbyn.GST;
      continue;
      label1224:
      localObject1 = localbyn.GST;
      continue;
      label1234:
      localObject1 = localbyn.GSS;
      continue;
      label1244:
      ((ajn)localObject2).ZH(1);
      continue;
      label1254:
      i = 4;
    }
  }
  
  public static boolean a(cv paramcv, p paramp, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramcv == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramp == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    byn localbyn = ak.a(paramp, paramString);
    if (localbyn == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramp.field_snsId), paramString });
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramp.field_userName });
    localakj.aPf(paramp.field_userName);
    localakj.aPg(u.aAm());
    localakj.ZR(2);
    localakj.CM(paramp.field_createTime * 1000L);
    localakj.aPk(paramp.getSnsId());
    localakj.aPh(str);
    localajn.aOx(str);
    localajn.aOt(ao.jo(ag.getAccSnsPath(), paramString) + com.tencent.mm.plugin.sns.data.q.k(localbyn));
    if (paramp.dYl() != null)
    {
      localajn.aOE(paramp.dYl().zTv);
      if (!bt.isNullOrNil(paramp.dYl().zTv))
      {
        paramString = bw.M(paramp.dYl().zTv, "adxml");
        if (paramString.size() > 0)
        {
          localajn.aOf(bt.bI((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localajn.aOg(bt.bI((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localajn, paramp);
    paramString = ao.jo(ag.getAccSnsPath(), localbyn.Id) + com.tencent.mm.plugin.sns.data.q.d(localbyn);
    if ((!i.fv(localajn.Ghp)) && (paramp.field_userName.endsWith(ag.dTJ())))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    if (i.fv(paramString)) {
      localajn.aOu(paramString);
    }
    for (;;)
    {
      localajn.ZI(2);
      localakd.nZa.add(localajn);
      localakd.a(localakj);
      paramcv.dnG.dnI = localakd;
      paramcv.dnG.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localajn.wl(true);
      localajn.aOo(localbyn.GSI);
      paramp = new aks();
      paramp.aPv(localbyn.GSI);
      localakd.b(paramp);
    }
  }
  
  public static boolean a(cv paramcv, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramcv == null) || (!x.aAx(paramString)))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (ag.dTN())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcv.dnG.dnL = 2131758903;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = h.aAa(paramString);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = ak.b((p)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((byn)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId), paramString });
    localObject2 = new akj();
    paramString = ((p)localObject1).dYl();
    if (paramString == null)
    {
      ad.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((p)localObject1).field_userName });
    ((akj)localObject2).aPf(((p)localObject1).field_userName);
    ((akj)localObject2).aPg(u.aAm());
    ((akj)localObject2).ZR(2);
    ((akj)localObject2).CM(((p)localObject1).field_createTime * 1000L);
    ((akj)localObject2).aPk(((p)localObject1).getSnsId());
    ((akj)localObject2).aPh(str);
    localObject1 = new gw();
    ((gw)localObject1).dsV.type = 30;
    ((gw)localObject1).dsV.dtc = 4;
    ((gw)localObject1).dsV.desc = paramString.HAT.GaS;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    ((gw)localObject1).dsV.dnI.a((akj)localObject2);
    paramcv.dnG.dnI = ((gw)localObject1).dsV.dnI;
    if (paramcv.dnG.dnI != null)
    {
      localObject1 = paramcv.dnG.dnI.nZa;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (ajn)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((ajn)localObject2).wk(true);
            ((ajn)localObject2).wl(true);
          }
          i += 1;
        }
      }
    }
    paramcv.dnG.desc = paramString.HAT.Title;
    paramcv.dnG.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(cv paramcv, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((x.aAy(paramString)) || (paramInt < 0))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(97660);
      return false;
    }
    if (ag.dTN())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcv.dnG.dnL = 2131758903;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = ag.dUe().aAa(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    byn localbyn = ak.b(paramString, paramInt);
    if (localbyn == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramcv, paramString, localbyn.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(cv paramcv, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((x.aAy(paramString)) || (paramCharSequence == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(97658);
      return false;
    }
    if (ag.dTN())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcv.dnG.dnL = 2131758903;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = ag.dUe().aAa(paramString);
    if (paramString == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramString.field_snsId) });
    akd localakd = new akd();
    akj localakj = new akj();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localakj.aPf(paramString.field_userName);
    localakj.aPg(u.aAm());
    localakj.ZR(2);
    localakj.CM(paramString.field_createTime * 1000L);
    localakj.aPk(paramString.getSnsId());
    localakj.aPh(str);
    localakd.a(localakj);
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.desc = paramCharSequence.toString();
    paramcv.dnG.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(cv paramcv, String paramString1, String paramString2)
  {
    AppMethodBeat.i(221350);
    boolean bool = b(paramcv, paramString1, paramString2);
    AppMethodBeat.o(221350);
    return bool;
  }
  
  private static boolean a(akd paramakd, TimeLineObject paramTimeLineObject, aks paramaks)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.HAT.GaT == null) || (paramTimeLineObject.HAT.GaT.hCZ == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    bww localbww = paramTimeLineObject.HAT.GaT;
    ajv localajv = new ajv();
    paramakd.f(localajv);
    localajv.hzj = paramTimeLineObject.HAT.GaT.hzj;
    localajv.hzh = localbww.hCZ;
    localajv.hzk = localbww.hzk;
    localajv.hzi = localbww.hzi;
    localajv.duration = localbww.duration;
    localajv.hzl = localbww.hzl;
    localajv.hzm = localbww.hzm;
    localajv.videoWidth = localbww.videoWidth;
    localajv.videoHeight = localbww.videoHeight;
    localajv.doK = paramTimeLineObject.HAU;
    localajv.hDe = paramTimeLineObject.EUR;
    localajv.hDm = localbww.coverUrl;
    paramaks.aPt(localbww.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(cv paramcv, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramcv == null) || (!x.aAx(paramString2)) || (paramString1 == null))
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (ag.dTN())
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcv.dnG.dnL = 2131758903;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = h.aAa(paramString2);
    if (localObject1 == null)
    {
      ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcv.dnG.dnL = 2131758886;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((p)localObject1).dYl().HAT != null) && (((p)localObject1).dYl().HAT.GaP == 26))
    {
      boolean bool = a(paramcv, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = ak.b((p)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((byn)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId), paramString2 });
    paramString2 = new akd();
    akj localakj = new akj();
    ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((p)localObject1).field_userName });
    localakj.aPf(((p)localObject1).field_userName);
    localakj.aPg(u.aAm());
    localakj.ZR(2);
    localakj.CM(((p)localObject1).field_createTime * 1000L);
    localakj.aPk(((p)localObject1).getSnsId());
    localakj.aPh((String)localObject3);
    localakj.aPm(paramString1);
    paramString1 = new ajn();
    paramString1.aOx((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ao.jo(ag.getAccSnsPath(), ((byn)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((byn)localObject2);
      if (i.fv((String)localObject3)) {
        paramString1.aOu((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.ZI(5);
      localObject1 = ((p)localObject1).dYl();
      paramString1.aOf(((TimeLineObject)localObject1).HAT.Title);
      paramString1.aOg(((TimeLineObject)localObject1).HAT.Desc);
      paramString1.aOE(((TimeLineObject)localObject1).zTv);
      if (!bt.isNullOrNil(((TimeLineObject)localObject1).zTv))
      {
        localObject2 = bw.M(((TimeLineObject)localObject1).zTv, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.aOf(bt.bI((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.aOg(bt.bI((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.wk(true);
      paramString2.nZa.add(paramString1);
      localObject2 = new aks();
      ((aks)localObject2).ZT(((TimeLineObject)localObject1).hzT);
      ((aks)localObject2).aPs(paramString1.title);
      if ((((TimeLineObject)localObject1).znS != null) && (!bt.isNullOrNil(((TimeLineObject)localObject1).znS.DBG)))
      {
        paramString1 = new ae();
        paramString1.DBG = ((TimeLineObject)localObject1).znS.DBG;
        paramString1.DBH = ((TimeLineObject)localObject1).znS.DBH;
        paramString1.DBI = ((TimeLineObject)localObject1).znS.DBI;
        paramString1.DBJ = ((TimeLineObject)localObject1).znS.DBJ;
        paramString1.DBK = ((TimeLineObject)localObject1).znS.DBK;
        paramString1.qeQ = ((TimeLineObject)localObject1).znS.qeQ;
        paramString1.qeR = ((TimeLineObject)localObject1).znS.qeR;
        paramString1.uaw = ((TimeLineObject)localObject1).znS.uaw;
        paramString1.DBL = ((TimeLineObject)localObject1).znS.DBL;
        paramString1.DBM = ((TimeLineObject)localObject1).znS.DBM;
        paramString1.DBN = ((TimeLineObject)localObject1).znS.DBN;
        paramString1.source = ((TimeLineObject)localObject1).znS.source;
        paramString1.lox = ((TimeLineObject)localObject1).znS.lox;
        paramString1.DBO = ((TimeLineObject)localObject1).znS.DBO;
        paramString1.DBP = ((TimeLineObject)localObject1).znS.DBP;
        paramString1.DBQ = ((TimeLineObject)localObject1).znS.DBQ;
        paramString1.DBR = ((TimeLineObject)localObject1).znS.DBR;
        paramString1.DBS = ((TimeLineObject)localObject1).znS.DBS;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).znS.thumbUrl;
        paramString1.DBT = ((TimeLineObject)localObject1).znS.DBT;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((aks)localObject2).aPx(((StringBuilder)localObject3).toString());
      }
      paramString2.b((aks)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (aks)localObject2);
      paramString2.a(localakj);
      paramcv.dnG.dnI = paramString2;
      paramcv.dnG.desc = ((TimeLineObject)localObject1).HAT.Title;
      paramcv.dnG.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.wl(true);
      paramString1.aOo(((byn)localObject2).GSI);
      localObject3 = new aks();
      ((aks)localObject3).aPv(((byn)localObject2).GSI);
      paramString2.b((aks)localObject3);
      continue;
      paramString1.wl(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */