package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.v;
import com.tencent.mm.ak.j;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.b;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static String Ug(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static afy a(afy paramafy, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    afy localafy = new afy();
    afz localafz = new afz();
    localafz.c(q(paramafy));
    localafz.d(paramafy.DgT.AWL);
    localafy.a(localafz);
    localafy.aDG(paramafy.DgV);
    localafy.aDH(paramafy.DgX);
    localafy.aDP(paramafy.Dhu);
    localafy.aDQ(paramafy.Dhw);
    localafy.ux(true);
    localafy.uw(true);
    localafy.aDI(paramafy.Dhb);
    localafy.VF(paramafy.Dhh);
    localafy.aDw(paramafy.Dgq);
    localafy.aDx(paramafy.Dgs);
    localafy.vp(paramafy.Dgu);
    localafy.aDB(paramafy.DgB);
    localafy.aDC(paramafy.DgD);
    localafy.vq(paramafy.DgF);
    if (paramBoolean) {
      localafy.aDy(paramafy.dkb);
    }
    AppMethodBeat.o(30961);
    return localafy;
  }
  
  private static afy a(bl parambl, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    afy localafy = new afy();
    a(localafy, parambl);
    localafy.aDs(paramb.gHA);
    localafy.aDt(paramb.gHB);
    localafy.aDr(paramb.url);
    localafy.uw(true);
    parambl = new com.tencent.mm.vfs.e(bt.by(com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true), ""));
    if (parambl.exists()) {
      localafy.aDA(q.B(parambl.fhU()));
    }
    for (;;)
    {
      localafy.aDl(paramb.title);
      localafy.aDm(paramb.description);
      localafy.aDK(paramb.canvasPageXml);
      localafy.VD(paramInt);
      localafy.aDJ(paramb.dxG);
      parambl = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (parambl != null)
      {
        localafy.aDR(parambl.songAlbumUrl);
        localafy.aDS(parambl.songLyric);
      }
      AppMethodBeat.o(30955);
      return localafy;
      localafy.ux(true);
    }
  }
  
  private static void a(afy paramafy1, afy paramafy2)
  {
    AppMethodBeat.i(30962);
    paramafy1.aDs(paramafy2.Dgi);
    paramafy1.aDt(paramafy2.Dgk);
    paramafy1.aDr(paramafy2.Dgg);
    paramafy1.aDl(paramafy2.title);
    paramafy1.aDm(paramafy2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(afy paramafy, bl parambl)
  {
    AppMethodBeat.i(30950);
    if (parambl.field_isSend == 1)
    {
      if ((w.pF(parambl.field_talker)) || (parambl.field_talker.equals("filehelper")))
      {
        paramafy.aDD(String.valueOf(parambl.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramafy.aDD(parambl.field_talker + "#" + String.valueOf(parambl.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramafy.aDD(String.valueOf(parambl.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(bl parambl, ago paramago, ahd paramahd)
  {
    AppMethodBeat.i(30958);
    paramago.f(m.a(parambl, paramahd));
    AppMethodBeat.o(30958);
  }
  
  public static boolean a(cs paramcs, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramcs == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    ad.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localafy.VD(2);
    localafy.aDz(paramString);
    localafy.aDy(com.tencent.mm.b.g.getMessageDigest((localafy.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gs();
    ((gs)localObject).dkc.type = 27;
    ((gs)localObject).dkc.dke = localafy;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gs)localObject).dkd.thumbPath;
    com.tencent.mm.sdk.platformtools.f.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localafy.aDA((String)localObject);
    localagu.aEl(com.tencent.mm.model.u.aqG());
    localagu.aEm(com.tencent.mm.model.u.aqG());
    localagu.VM(paramInt);
    localagu.vv(bt.eGO());
    localago.a(localagu);
    localago.mVb.add(localafy);
    paramcs.deQ.title = localafy.title;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(cs paramcs, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(179755);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(179755);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcs.deQ.deV = 2131759025;; paramcs.deQ.deV = 2131759024)
      {
        AppMethodBeat.o(179755);
        return false;
      }
    }
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localafy.aDz(paramString1);
    localafy.VD(4);
    localafy.aDv(com.tencent.mm.vfs.i.RK(paramString1));
    localafy.aDA(paramString2);
    localafy.VC(0);
    localafy.aDl(paramString3);
    localafy.aDm(paramString4);
    localagu.aEl(com.tencent.mm.model.u.aqG());
    localagu.aEm(com.tencent.mm.model.u.aqG());
    localagu.VM(paramInt);
    localagu.vv(bt.eGO());
    localago.a(localagu);
    localago.mVb.add(localafy);
    paramcs.deQ.title = localafy.title;
    paramcs.deQ.desc = localafy.title;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 4;
    AppMethodBeat.o(179755);
    return true;
  }
  
  public static boolean a(cs paramcs, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = e(paramcs, ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(cs paramcs, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramcs == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(30940);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bt.by(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new agf();
    paramIntent.aEc((String)localObject1);
    paramIntent.C(d1);
    paramIntent.B(d2);
    paramIntent.VI(i);
    paramIntent.aEd((String)localObject2);
    localObject1 = new ago();
    localObject2 = new agu();
    String str = com.tencent.mm.model.u.aqG();
    ((agu)localObject2).aEl(str);
    ((agu)localObject2).aEm(str);
    ((agu)localObject2).VM(6);
    ((agu)localObject2).vv(bt.eGO());
    ((ago)localObject1).d(paramIntent);
    ((ago)localObject1).a((agu)localObject2);
    paramcs.deQ.deS = ((ago)localObject1);
    paramcs.deQ.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(cs paramcs, k.b paramb, ago paramago, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new pn();
    ((pn)localObject).dvb.type = 0;
    ((pn)localObject).dvb.dvd = paramb.gHI;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((pn)localObject).dvc.dvl;
    if (localc == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30959);
      return false;
    }
    paramago.aEj(localc.title);
    Iterator localIterator = localc.gKs.iterator();
    int i = 0;
    afy localafy;
    if (localIterator.hasNext())
    {
      localafy = (afy)localIterator.next();
      switch (localafy.dataType)
      {
      case 9: 
      case 13: 
      case 18: 
      case 21: 
      default: 
        paramb = null;
        label242:
        if (paramb != null) {
          if (parambl.field_isSend == 1) {
            if ((w.pF(parambl.field_talker)) || (parambl.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambl.field_msgSvrId), Integer.valueOf(i) });
              paramb.aDD((String)localObject);
              paramb.aDT(localafy.hAt);
              paramago.mVb.add(paramb);
              i += 1;
            }
          }
        }
        label307:
        break;
      }
    }
    for (;;)
    {
      break;
      long l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      paramb.VD(3);
      if (!bt.isNullOrNil(localafy.Dhb))
      {
        localObject = new pn();
        ((pn)localObject).dvb.type = 1;
        ((pn)localObject).dvb.djJ = localafy;
        ((pn)localObject).dvb.msgId = l;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
          ad.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.aDz(((pn)localObject).dvc.dvm);
        paramb.VC(localafy.duration);
        paramb.ux(true);
        paramb.uw(false);
        paramb.aDv(localafy.Dgo);
      }
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiU += 1;
      break label242;
      paramb = a(localafy, paramBoolean);
      paramb.VD(1);
      paramb.aDm(localafy.desc);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiS += 1;
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      paramb.VD(2);
      localObject = new pn();
      ((pn)localObject).dvb.type = 1;
      ((pn)localObject).dvb.djJ = localafy;
      ((pn)localObject).dvb.msgId = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.aDz(((pn)localObject).dvc.dvm);
      paramb.aDA(((pn)localObject).dvc.thumbPath);
      paramb.ux(false);
      paramb.uw(false);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiT += 1;
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      a(paramb, localafy);
      paramb.VD(5);
      localObject = new pn();
      ((pn)localObject).dvb.type = 1;
      ((pn)localObject).dvb.djJ = localafy;
      ((pn)localObject).dvb.msgId = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.aDA(((pn)localObject).dvc.thumbPath);
      paramb.ux(false);
      if ((localafy.DgT != null) && (localafy.DgT.DhE != null))
      {
        localObject = new ahd();
        ((ahd)localObject).aEy(localafy.DgT.DhE.title);
        ((ahd)localObject).aEz(localafy.DgT.DhE.desc);
        ((ahd)localObject).aEB(localafy.DgT.DhE.thumbUrl);
        ((ahd)localObject).VN(localafy.DgT.DhE.Djh);
        ((ahd)localObject).aEA(localafy.DgT.DhE.Djf);
        paramb.DgT.a((ahd)localObject);
      }
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiV += 1;
      break label242;
      paramb = a(localafy, paramBoolean);
      paramb.aDl(localafy.title);
      paramb.aDm(localafy.desc);
      paramb.DgT.b(localafy.DgT.DhW);
      paramb.VD(22);
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      a(paramb, localafy);
      if (localafy.dataType == 15) {
        paramb.VD(15);
      }
      for (;;)
      {
        localObject = new pn();
        ((pn)localObject).dvb.type = 1;
        ((pn)localObject).dvb.djJ = localafy;
        ((pn)localObject).dvb.msgId = l;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
          ad.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.uw(false);
        paramb.aDz(((pn)localObject).dvc.dvm);
        paramb.a(localafy.DgT);
        paramb.ux(false);
        paramb.aDA(((pn)localObject).dvc.thumbPath);
        paramb.VC(localafy.duration);
        localObject = paramcs.deQ.deT;
        ((ahc)localObject).rBj += 1;
        break;
        paramb.VD(4);
      }
      paramb = a(localafy, paramBoolean);
      paramb.VD(6);
      if ((localafy.DgT != null) && (localafy.DgT.DhC != null))
      {
        localObject = new agf();
        ((agf)localObject).aEc(localafy.DgT.DhC.label);
        ((agf)localObject).C(localafy.DgT.DhC.lat);
        ((agf)localObject).B(localafy.DgT.DhC.lng);
        ((agf)localObject).VI(localafy.DgT.DhC.dpd);
        ((agf)localObject).aEd(localafy.DgT.DhC.dtN);
        paramb.DgT.c((agf)localObject);
      }
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiW += 1;
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      a(paramb, localafy);
      paramb.aDR(localafy.songAlbumUrl);
      paramb.aDS(localafy.songLyric);
      paramb.VD(7);
      localObject = new pn();
      ((pn)localObject).dvb.type = 1;
      ((pn)localObject).dvb.djJ = localafy;
      ((pn)localObject).dvb.msgId = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.aDA(((pn)localObject).dvc.thumbPath);
      paramb.ux(false);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiX += 1;
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      a(paramb, localafy);
      paramb.VD(8);
      localObject = new pn();
      ((pn)localObject).dvb.type = 1;
      ((pn)localObject).dvb.djJ = localafy;
      ((pn)localObject).dvb.msgId = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((pn)localObject).dvc.dvm)) && (bt.isNullOrNil(((pn)localObject).dvc.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.aDz(((pn)localObject).dvc.dvm);
      paramb.aDA(((pn)localObject).dvc.thumbPath);
      paramb.uw(false);
      paramb.aDv(localafy.Dgo);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).fileCount += 1;
      break label242;
      paramb = b(localafy, localafy.dataType, paramBoolean);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).DiZ += 1;
      break label242;
      paramb = b(localafy, localafy.dataType, paramBoolean);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).Dja += 1;
      break label242;
      paramb = a(localafy, paramBoolean);
      paramb.VD(14);
      if ((localafy.DgT != null) && (localafy.DgT.DhI != null))
      {
        localObject = new agx();
        ((agx)localObject).aEu(localafy.DgT.DhI.title);
        ((agx)localObject).aEv(localafy.DgT.DhI.desc);
        ((agx)localObject).aEx(localafy.DgT.DhI.info);
        ((agx)localObject).aEw(localafy.DgT.DhI.thumbUrl);
        paramb.DgT.a((agx)localObject);
      }
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).Djd += 1;
      break label242;
      paramb = a(localafy, paramBoolean);
      paramb.VD(16);
      paramb.aDm(localafy.desc);
      localObject = paramcs.deQ.deT;
      ((ahc)localObject).Dje += 1;
      break label242;
      paramb = a(localafy, paramBoolean);
      paramb.aDl(localafy.title);
      paramb.aDm(localafy.desc);
      paramb.VD(17);
      paramb.aDL(localafy.Dhj);
      break label242;
      l = parambl.field_msgId;
      paramb = a(localafy, paramBoolean);
      paramb.aDl(localafy.title);
      paramb.aDm(localafy.desc);
      paramb.VD(19);
      localObject = new pn();
      ((pn)localObject).dvb.type = 1;
      ((pn)localObject).dvb.djJ = localafy;
      ((pn)localObject).dvb.msgId = l;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (bt.isNullOrNil(((pn)localObject).dvc.thumbPath)) {
        ad.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localafy.DgT != null) && (localafy.DgT.DhR != null))
        {
          localObject = new afw();
          ((afw)localObject).username = localafy.DgT.DhR.username;
          ((afw)localObject).appId = localafy.DgT.DhR.appId;
          ((afw)localObject).dkC = localafy.DgT.DhR.dkC;
          ((afw)localObject).iconUrl = localafy.DgT.DhR.iconUrl;
          ((afw)localObject).type = localafy.DgT.DhR.type;
          ((afw)localObject).dbu = localafy.DgT.DhR.dbu;
          ((afw)localObject).DfP = localafy.DgT.DhR.DfP;
          ((afw)localObject).version = localafy.DgT.DhR.version;
          ((afw)localObject).cfU = localafy.DgT.DhR.cfU;
          ((afw)localObject).jwB = localafy.DgT.DhR.jwB;
          ((afw)localObject).dzY = localafy.DgT.DhR.dzY;
          paramb.DgT.b((afw)localObject);
        }
        break;
        paramb.ux(false);
        paramb.aDA(((pn)localObject).dvc.thumbPath);
      }
      paramb = a(localafy, paramBoolean);
      paramb.VD(20);
      paramb.VC(localafy.duration);
      break label242;
      localObject = String.format("%s#%d$%d", new Object[] { parambl.field_talker, Long.valueOf(parambl.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambl.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      if (com.tencent.mm.plugin.fav.ui.l.j((afy)localc.gKs.get(0))) {}
      for (paramcs.deQ.type = 18;; paramcs.deQ.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30949);
    ago localago = new ago();
    localago.a(aA(parambl));
    parambl = bw.K(parambl.field_content, "msg");
    if (parambl != null) {
      try
      {
        agf localagf = new agf();
        localagf.aEc((String)parambl.get(".msg.location.$label"));
        localagf.C(Double.parseDouble((String)parambl.get(".msg.location.$x")));
        localagf.B(Double.parseDouble((String)parambl.get(".msg.location.$y")));
        localagf.VI(Integer.valueOf((String)parambl.get(".msg.location.$scale")).intValue());
        localagf.aEd((String)parambl.get(".msg.location.$poiname"));
        localago.d(localagf);
        paramcs.deQ.type = 6;
        paramcs.deQ.deS = localago;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception parambl)
      {
        ad.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambl.getStackTrace().toString() });
      }
    }
    paramcs.deQ.deV = 2131758895;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static boolean a(cs paramcs, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(30941);
    if ((paramcs == null) || (bt.isNullOrNil(paramString1)))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(30941);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcs.deQ.deV = 2131759025;; paramcs.deQ.deV = 2131759024)
      {
        AppMethodBeat.o(30941);
        return false;
      }
    }
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localafy.aDz(paramString1);
    localafy.VD(8);
    localafy.aDv(com.tencent.mm.vfs.i.RK(paramString1));
    localafy.ux(true);
    localafy.aDl(paramString2);
    localafy.aDm(paramString3);
    localagu.aEl(com.tencent.mm.model.u.aqG());
    localagu.aEm(com.tencent.mm.model.u.aqG());
    localagu.VM(13);
    localagu.vv(bt.eGO());
    localago.a(localagu);
    localago.mVb.add(localafy);
    paramcs.deQ.title = localafy.title;
    paramcs.deQ.desc = localafy.title;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 8;
    AppMethodBeat.o(30941);
    return true;
  }
  
  private static agu aA(bl parambl)
  {
    AppMethodBeat.i(30946);
    agu localagu = new agu();
    if (parambl.field_isSend == 1)
    {
      localagu.aEl(com.tencent.mm.model.u.aqG());
      localagu.aEm(parambl.field_talker);
      if (w.pF(parambl.field_talker)) {
        localagu.aEo(localagu.dpv);
      }
    }
    do
    {
      localagu.VM(1);
      localagu.vv(parambl.field_createTime);
      localagu.aEp(parambl.field_msgSvrId);
      if (parambl.field_msgSvrId > 0L) {
        localagu.aEn(parambl.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localagu;
      localagu.aEl(parambl.field_talker);
      localagu.aEm(com.tencent.mm.model.u.aqG());
    } while (!w.pF(parambl.field_talker));
    if (parambl.field_content != null) {}
    for (String str = parambl.field_content.substring(0, Math.max(0, parambl.field_content.indexOf(':')));; str = "")
    {
      localagu.aEo(str);
      if ((bt.isNullOrNil(localagu.Did)) || (parambl.eJN())) {
        break;
      }
      parambl.setContent(parambl.field_content.substring(localagu.Did.length() + 1));
      if ((parambl.field_content.length() > 0) && ('\n' == parambl.field_content.charAt(0))) {
        parambl.setContent(parambl.field_content.substring(1));
      }
      if (!parambl.eMj()) {
        break;
      }
      parambl.ob(parambl.field_transContent.substring(localagu.Did.length() + 1));
      if ((parambl.field_transContent.length() <= 0) || ('\n' != parambl.field_transContent.charAt(0))) {
        break;
      }
      parambl.ob(parambl.field_transContent.substring(1));
      break;
    }
  }
  
  private static String aAE(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = com.tencent.mm.sdk.platformtools.l.d(com.tencent.mm.plugin.record.b.apZ(), "recbiz_", paramString, ".rec", 2);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30952);
      return null;
    }
    if (new com.tencent.mm.vfs.e(paramString).exists())
    {
      AppMethodBeat.o(30952);
      return paramString;
    }
    AppMethodBeat.o(30952);
    return paramString;
  }
  
  private static afy b(afy paramafy, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    afy localafy = a(paramafy, paramBoolean);
    localafy.VD(paramInt);
    if ((paramafy.DgT != null) && (paramafy.DgT.DhG != null))
    {
      agn localagn = new agn();
      localagn.aEe(paramafy.DgT.DhG.title);
      localagn.aEf(paramafy.DgT.DhG.desc);
      localagn.VJ(paramafy.DgT.DhG.type);
      localagn.aEh(paramafy.DgT.DhG.info);
      localagn.aEg(paramafy.DgT.DhG.thumbUrl);
      localafy.DgT.a(localagn);
    }
    AppMethodBeat.o(30963);
    return localafy;
  }
  
  public static boolean b(cs paramcs, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcs.deQ.deV = 2131758885;
      AppMethodBeat.o(30942);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ago localago = new ago();
    agu localagu = new agu();
    localagu.aEl(com.tencent.mm.model.u.aqG());
    localagu.aEm(com.tencent.mm.model.u.aqG());
    localagu.VM(paramInt);
    localagu.vv(bt.eGO());
    localago.a(localagu);
    paramcs.deQ.desc = paramString;
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static boolean d(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30957);
    ago localago = new ago();
    Object localObject1 = aA(parambl);
    localago.a((agu)localObject1);
    try
    {
      com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
      Object localObject2 = localu.gKs;
      ((agu)localObject1).aEt(localu.dxz);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcs.deQ.deU))
      {
        ad.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcs.deQ.deU) });
        v localv = (v)((List)localObject2).get(paramcs.deQ.deU);
        if (m.rz(localv.gKI))
        {
          paramcs.deQ.deV = 2131758893;
          AppMethodBeat.o(30957);
          return false;
        }
        ((agu)localObject1).aEs(localv.url);
        if (paramcs.deQ.deU > 0) {
          ((agu)localObject1).aEn("");
        }
        afy localafy = new afy();
        localafy.aDl(localv.title);
        localafy.aDm(localv.gKF);
        a(localafy, parambl);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          parambl = com.tencent.mm.ak.p.auF().we(parambl.field_talker);
          localObject1 = localObject2;
          if (parambl != null) {
            localObject1 = parambl.aux();
          }
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          localafy.aDA(r.aAK((String)localObject1));
          localafy.ux(false);
          if ((bt.isNullOrNil(localafy.Dgz)) || (!com.tencent.mm.vfs.i.eK(localafy.Dgz)))
          {
            localafy.aDu((String)localObject1);
            localafy.ux(true);
          }
        }
        for (;;)
        {
          localafy.uw(true);
          localafy.VD(5);
          localago.mVb.add(localafy);
          paramcs.deQ.deS = localago;
          paramcs.deQ.desc = localv.title;
          paramcs.deQ.type = 5;
          parambl = new ahd();
          parambl.aEB((String)localObject1);
          parambl.aEy(localv.title);
          parambl.aEz(localv.gKF);
          localago.b(parambl);
          localago.f(m.a(localv, parambl, localu.dxz, localu.dxA));
          AppMethodBeat.o(30957);
          return true;
          localafy.ux(true);
        }
      }
      return false;
    }
    catch (Exception parambl)
    {
      ad.printErrStackTrace("MicroMsg.GetFavDataSource", parambl, "", new Object[0]);
      ad.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambl.getLocalizedMessage() });
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean e(cs paramcs, bl parambl)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramcs == null) || (parambl == null))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcs != null) {
        paramcs.deQ.deV = 2131758885;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    parambl = bl.aI(parambl);
    if (parambl.isText()) {
      bool = f(paramcs, parambl);
    }
    for (;;)
    {
      paramcs.deQ.deE = parambl.field_content;
      if ((bool) || (paramcs.deQ.deV == 0)) {
        com.tencent.mm.plugin.fav.ui.e.a(parambl, paramcs, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (parambl.eJN())
      {
        bool = h(paramcs, parambl);
      }
      else if (parambl.cxD())
      {
        bool = a(paramcs, parambl);
      }
      else if (parambl.eJO())
      {
        bool = g(paramcs, parambl);
      }
      else if ((parambl.cjM()) || (parambl.cjO()))
      {
        bool = j(paramcs, parambl);
      }
      else if (parambl.cjN())
      {
        bool = i(paramcs, parambl);
      }
      else if (parambl.eJL())
      {
        bool = d(paramcs, parambl);
      }
      else
      {
        if (parambl.eLX()) {}
        while ((!parambl.cxB()) || (parambl.eLZ()))
        {
          paramcs.deQ.deV = 2131758893;
          break;
        }
        bool = k(paramcs, parambl);
      }
    }
  }
  
  private static boolean f(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30947);
    ago localago = new ago();
    localago.a(aA(parambl));
    paramcs.deQ.deS = localago;
    paramcs.deQ.desc = parambl.field_content;
    paramcs.deQ.type = 1;
    if (com.tencent.mm.ui.tools.f.aLJ(paramcs.deQ.desc) > com.tencent.mm.m.b.YG())
    {
      paramcs.deQ.deV = 2131759022;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean g(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (parambl.field_msgId > 0L) {
      localObject1 = com.tencent.mm.aw.o.ayF().ms(parambl.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.e)localObject1).deI > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambl.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.aw.o.ayF().mr(parambl.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcs.deQ.deV = 2131758891;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new ago();
    ((ago)localObject1).a(aA(parambl));
    afy localafy = new afy();
    a(localafy, parambl);
    localafy.VD(2);
    localafy.aDz(com.tencent.mm.aw.o.ayF().p(com.tencent.mm.aw.f.c((com.tencent.mm.aw.e)localObject2), "", ""));
    if (((com.tencent.mm.aw.e)localObject2).ayi())
    {
      localObject2 = com.tencent.mm.aw.o.ayF().od(((com.tencent.mm.aw.e)localObject2).hgu);
      if (((com.tencent.mm.aw.e)localObject2).gTY > ((com.tencent.mm.aw.e)localObject2).offset) {
        localafy.aDz(com.tencent.mm.aw.o.ayF().p("SERVERID://" + parambl.field_msgSvrId, "", ""));
      }
    }
    localafy.aDA(com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true));
    localafy.aDT(bk.uo(parambl.esh));
    parambl = new LinkedList();
    parambl.add(localafy);
    ((ago)localObject1).bd(parambl);
    paramcs.deQ.deS = ((ago)localObject1);
    paramcs.deQ.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean h(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30951);
    ago localago = new ago();
    localago.a(aA(parambl));
    afy localafy = new afy();
    a(localafy, parambl);
    if (w.ta(parambl.field_talker)) {
      localafy.aDz(aAE(parambl.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localafy.VD(3);
      localafy.ux(true);
      localb = com.tencent.mm.modelvoice.s.Ax(parambl.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localafy.aDz(com.tencent.mm.modelvoice.s.getFullPath(parambl.field_imgPath));
    }
    localafy.aDv(Ug(localb.getFormat()));
    localafy.VC((int)new com.tencent.mm.modelvoice.p(parambl.field_content).time);
    parambl = new LinkedList();
    parambl.add(localafy);
    localago.bd(parambl);
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean i(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.ar(parambl.field_content, parambl.field_reserved);
    if (localObject == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    ago localago = new ago();
    localago.a(aA(parambl));
    afy localafy = new afy();
    a(localafy, parambl);
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDA(t.zR(parambl.field_imgPath));
    localafy.aDv(com.tencent.mm.vfs.i.RK(localafy.Dgx));
    localafy.aDz("");
    localafy.aDu(((k.b)localObject).thumburl);
    agg localagg = m.t(parambl);
    if (localagg == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localafy.VC(localagg.duration);
    localafy.aDl(((k.b)localObject).title);
    localafy.aDr(((k.b)localObject).url);
    localafy.uw(true);
    localafy.ux(true);
    localObject = new afz();
    if (parambl.cjN()) {
      ((afz)localObject).e(localagg);
    }
    localafy.a((afz)localObject);
    parambl = new LinkedList();
    parambl.add(localafy);
    localago.bd(parambl);
    paramcs.deQ.deS = localago;
    paramcs.deQ.type = 4;
    localafy.VD(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean j(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30954);
    ago localago = new ago();
    localago.a(aA(parambl));
    afy localafy = new afy();
    a(localafy, parambl);
    com.tencent.mm.modelvideo.o.aCI();
    localafy.aDA(t.zR(parambl.field_imgPath));
    localafy.aDv(com.tencent.mm.vfs.i.RK(localafy.Dgx));
    Object localObject = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    if (localObject == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    ad.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).gTY) });
    if (((com.tencent.mm.modelvideo.s)localObject).gTY > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcs.deQ.deV = 2131759025;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((parambl.cjO()) && (com.tencent.mm.modelvideo.u.Ag(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcs.deQ.deV = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).aCW())
    {
      com.tencent.mm.modelvideo.o.aCI();
      String str = t.zQ(parambl.field_imgPath);
      ad.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localafy.aDz(str);
      localafy.VC(((com.tencent.mm.modelvideo.s)localObject).gOY);
      localafy.aDT(bk.uo(parambl.esh));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localafy);
      localago.bd((LinkedList)localObject);
      paramcs.deQ.deS = localago;
      if (!parambl.cjO()) {
        break label469;
      }
      paramcs.deQ.type = 16;
      localafy.VD(15);
    }
    for (;;)
    {
      paramcs = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      localafy.aDJ(paramcs.dxG);
      paramcs = paramcs.hAq;
      if ((paramcs != null) && (!bt.isNullOrNil(paramcs.gJB)))
      {
        parambl = new agb();
        parambl.gJv = paramcs.gJv;
        parambl.Dim = paramcs.Dim;
        parambl.gJy = paramcs.gJy;
        parambl.gJz = paramcs.gJz;
        parambl.gJx = paramcs.gJx;
        parambl.gJA = paramcs.gJA;
        parambl.gJB = paramcs.gJB;
        parambl.gJC = paramcs.gJC;
        localafy.a(parambl);
      }
      AppMethodBeat.o(30954);
      return true;
      ad.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localafy.aDz("");
      break;
      label469:
      paramcs.deQ.type = 4;
      localafy.VD(4);
    }
  }
  
  private static boolean k(cs paramcs, bl parambl)
  {
    AppMethodBeat.i(30956);
    ago localago = new ago();
    localago.a(aA(parambl));
    Object localObject1 = parambl.field_content;
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.rx((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.deQ.deV = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    paramcs.deQ.deS = localago;
    Object localObject2 = localago.DiD;
    ((agu)localObject2).aEr(((k.b)localObject1).appId);
    ((agu)localObject2).aEt(((k.b)localObject1).dxz);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramcs.deQ.deV = 2131758893;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramcs.deQ.deS = localago;
      paramcs.deQ.desc = ((k.b)localObject1).title;
      paramcs.deQ.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bxS().aAL(((k.b)localObject1).dbA);
      localObject2 = new afy();
      a((afy)localObject2, parambl);
      if (localObject3 != null) {
        ((afy)localObject2).aDz(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eK((String)localObject3)) {
        ((afy)localObject2).aDA((String)localObject3);
      }
      ((afy)localObject2).VD(2);
      ((afy)localObject2).aDl(((k.b)localObject1).title);
      ((afy)localObject2).aDm(((k.b)localObject1).description);
      ((afy)localObject2).aDT(bk.uo(parambl.esh));
      localago.mVb.add(localObject2);
      paramcs.deQ.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      parambl = a(parambl, (k.b)localObject1, 7);
      localago.mVb.add(parambl);
      paramcs.deQ.type = 7;
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(parambl, (k.b)localObject1, 4);
      localago.aEj(((afy)localObject1).title);
      localago.aEk(((afy)localObject1).desc);
      ((afy)localObject1).aDT(bk.uo(parambl.esh));
      localago.mVb.add(localObject1);
      paramcs.deQ.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localago.DiD.aEs(((k.b)localObject1).url);
        localObject2 = new ahd();
        ((ahd)localObject2).aEB(((k.b)localObject1).thumburl);
        localObject3 = (ab)((k.b)localObject1).ao(ab.class);
        if ((localObject3 != null) && (!bt.isNullOrNil(((ab)localObject3).AGs)))
        {
          localObject4 = new StringBuilder();
          ((ab)localObject3).b((StringBuilder)localObject4, null, null, null, 0, 0);
          ((ahd)localObject2).aED(((StringBuilder)localObject4).toString());
        }
        localago.b((ahd)localObject2);
        a(parambl, localago, (ahd)localObject2);
        parambl = a(parambl, (k.b)localObject1, 5);
        localago.mVb.add(parambl);
        localago.aEj(parambl.title);
        localago.aEk(parambl.desc);
        paramcs.deQ.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramcs.deQ.deV = 2131758889;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      parambl = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (parambl != null)
      {
        parambl = parambl.htg;
        localago.aEj(parambl.nickname + aj.getContext().getString(2131759007));
        localago.aEk(parambl.desc);
        localago.c(parambl);
        paramcs.deQ.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bxS().aAL(((k.b)localObject1).dbA);
      localObject2 = new afy();
      if (localObject3 != null) {
        ((afy)localObject2).aDz(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((afy)localObject2, parambl);
      ((afy)localObject2).VD(8);
      ((afy)localObject2).aDv(((k.b)localObject1).gHf);
      parambl = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
      if (bt.isNullOrNil(parambl)) {
        ((afy)localObject2).ux(true);
      }
      if (com.tencent.mm.vfs.i.eK(parambl)) {
        ((afy)localObject2).aDA(parambl);
      }
      ((afy)localObject2).aDl(((k.b)localObject1).title);
      ((afy)localObject2).aDm(((k.b)localObject1).description);
      localago.mVb.add(localObject2);
      paramcs.deQ.desc = ((k.b)localObject1).title;
      paramcs.deQ.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).dbA == null) || (((k.b)localObject1).dbA.length() == 0)) {
        paramcs.deQ.deV = 2131758886;
      }
      while (com.tencent.mm.kernel.g.afB().isSDCardAvailable())
      {
        paramcs.deQ.deV = 2131758893;
        AppMethodBeat.o(30956);
        return false;
      }
      paramcs.deQ.deV = 2131758901;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      parambl = new agn();
      parambl.aEe(((k.b)localObject1).title);
      parambl.aEf(((k.b)localObject1).description);
      parambl.VJ(((k.b)localObject1).gHD);
      parambl.aEh(((k.b)localObject1).gHE);
      parambl.aEg(((k.b)localObject1).thumburl);
      paramcs.deQ.title = ((k.b)localObject1).title;
      paramcs.deQ.desc = ((k.b)localObject1).description;
      paramcs.deQ.type = 10;
      localago.b(parambl);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      parambl = new agx();
      parambl.aEu(((k.b)localObject1).title);
      parambl.aEv(((k.b)localObject1).description);
      parambl.aEx(((k.b)localObject1).gHH);
      parambl.aEw(((k.b)localObject1).thumburl);
      paramcs.deQ.title = ((k.b)localObject1).title;
      paramcs.deQ.desc = ((k.b)localObject1).description;
      paramcs.deQ.type = 15;
      localago.b(parambl);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      parambl = new agn();
      parambl.aEe(((k.b)localObject1).title);
      parambl.aEf(((k.b)localObject1).description);
      parambl.VJ(((k.b)localObject1).gHJ);
      parambl.aEh(((k.b)localObject1).gHK);
      parambl.aEg(((k.b)localObject1).thumburl);
      paramcs.deQ.title = ((k.b)localObject1).title;
      paramcs.deQ.desc = ((k.b)localObject1).description;
      paramcs.deQ.type = 11;
      localago.b(parambl);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramcs.deQ.deT = new ahc();
      bool = a(paramcs, (k.b)localObject1, localago, parambl, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramcs.deQ.deT = new ahc();
      bool = a(paramcs, (k.b)localObject1, localago, parambl, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new afw();
    ((afw)localObject3).username = ((k.b)localObject1).gJE;
    ((afw)localObject3).appId = ((k.b)localObject1).gJF;
    ((afw)localObject3).dkC = ((k.b)localObject1).gJQ;
    ((afw)localObject3).iconUrl = ((k.b)localObject1).gJS;
    ((afw)localObject3).dbu = ((k.b)localObject1).gJD;
    ((afw)localObject3).DfP = ((k.b)localObject1).dxA;
    ((afw)localObject3).jwB = ((k.b)localObject1).gJN;
    ((afw)localObject3).type = ((k.b)localObject1).gJG;
    Object localObject4 = (com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class);
    if (localObject4 != null)
    {
      ((afw)localObject3).cfU = ((com.tencent.mm.ai.a)localObject4).gFy;
      ((afw)localObject3).dzY = ((com.tencent.mm.ai.a)localObject4).gFA;
      ((afw)localObject3).subType = ((com.tencent.mm.ai.a)localObject4).gFB;
    }
    ((afw)localObject3).version = ((k.b)localObject1).gJR;
    localObject4 = new afy();
    a((afy)localObject4, parambl);
    ((afy)localObject4).VD(19);
    String str = com.tencent.mm.aw.o.ayF().Q(parambl.field_imgPath, true);
    if (bt.isNullOrNil(str)) {
      ((afy)localObject4).ux(true);
    }
    if (com.tencent.mm.vfs.i.eK(str)) {
      ((afy)localObject4).aDA(str);
    }
    ((afy)localObject4).aDl(((k.b)localObject1).title);
    ((afy)localObject4).aDm(((k.b)localObject1).description);
    localago.mVb.add(localObject4);
    localago.aEj(((k.b)localObject1).title);
    if (w.pF(parambl.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((agu)localObject2).VM(i);
      paramcs.deQ.title = ((k.b)localObject1).title;
      paramcs.deQ.desc = ((k.b)localObject1).description;
      paramcs.deQ.type = 19;
      localago.c((afw)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static aga q(afy paramafy)
  {
    AppMethodBeat.i(30960);
    aga localaga = new aga();
    paramafy = paramafy.DgT.DhA;
    if (paramafy.DhZ) {
      localaga.aDU(paramafy.dpv);
    }
    if (paramafy.Dia) {
      localaga.aDV(paramafy.toUser);
    }
    if (paramafy.Die) {
      localaga.aDX(paramafy.Did);
    }
    localaga.VH(1);
    localaga.vs(bt.eGO());
    AppMethodBeat.o(30960);
    return localaga;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */