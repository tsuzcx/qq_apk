package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.v;
import com.tencent.mm.aj.j;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static String Wq(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static agx a(agx paramagx, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    agx localagx = new agx();
    agy localagy = new agy();
    localagy.c(q(paramagx));
    localagy.d(paramagx.EzZ.CoY);
    localagx.a(localagy);
    localagx.aIX(paramagx.EAb);
    localagx.aIY(paramagx.EAd);
    localagx.aJg(paramagx.EAA);
    localagx.aJh(paramagx.EAC);
    localagx.vz(true);
    localagx.vy(true);
    localagx.aIZ(paramagx.EAh);
    localagx.XO(paramagx.EAn);
    localagx.aIN(paramagx.Ezw);
    localagx.aIO(paramagx.Ezy);
    localagx.zS(paramagx.EzA);
    localagx.aIS(paramagx.EzH);
    localagx.aIT(paramagx.EzJ);
    localagx.zT(paramagx.EzL);
    if (paramBoolean) {
      localagx.aIP(paramagx.dhw);
    }
    AppMethodBeat.o(30961);
    return localagx;
  }
  
  private static agx a(bo parambo, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    agx localagx = new agx();
    a(localagx, parambo);
    localagx.aIJ(paramb.hib);
    localagx.aIK(paramb.hic);
    localagx.aII(paramb.url);
    localagx.vy(true);
    parambo = new com.tencent.mm.vfs.e(bs.bG(com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true), ""));
    if (parambo.exists()) {
      localagx.aIR(q.B(parambo.fxV()));
    }
    for (;;)
    {
      localagx.aIC(paramb.title);
      localagx.aID(paramb.description);
      localagx.aJb(paramb.canvasPageXml);
      localagx.XM(paramInt);
      localagx.aJa(paramb.dvs);
      parambo = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (parambo != null)
      {
        localagx.aJi(parambo.songAlbumUrl);
        localagx.aJj(parambo.songLyric);
      }
      AppMethodBeat.o(30955);
      return localagx;
      localagx.vz(true);
    }
  }
  
  private static void a(agx paramagx1, agx paramagx2)
  {
    AppMethodBeat.i(30962);
    paramagx1.aIJ(paramagx2.Ezo);
    paramagx1.aIK(paramagx2.Ezq);
    paramagx1.aII(paramagx2.Ezm);
    paramagx1.aIC(paramagx2.title);
    paramagx1.aID(paramagx2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(agx paramagx, bo parambo)
  {
    AppMethodBeat.i(30950);
    if (parambo.field_isSend == 1)
    {
      if ((w.sQ(parambo.field_talker)) || (parambo.field_talker.equals("filehelper")))
      {
        paramagx.aIU(String.valueOf(parambo.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramagx.aIU(parambo.field_talker + "#" + String.valueOf(parambo.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramagx.aIU(String.valueOf(parambo.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(bo parambo, ahn paramahn, aic paramaic)
  {
    AppMethodBeat.i(30958);
    paramahn.f(m.a(parambo, paramaic));
    AppMethodBeat.o(30958);
  }
  
  public static boolean a(cs paramcs, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramcs == null) || (bs.isNullOrNil(paramString)))
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    ac.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localagx.XM(2);
    localagx.aIQ(paramString);
    localagx.aIP(com.tencent.mm.b.g.getMessageDigest((localagx.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gt();
    ((gt)localObject).dhx.type = 27;
    ((gt)localObject).dhx.dhz = localagx;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gt)localObject).dhy.thumbPath;
    com.tencent.mm.sdk.platformtools.f.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localagx.aIR((String)localObject);
    localaht.aJC(com.tencent.mm.model.u.axw());
    localaht.aJD(com.tencent.mm.model.u.axw());
    localaht.XV(paramInt);
    localaht.zY(bs.eWj());
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    paramcs.dck.title = localagx.title;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(cs paramcs, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(179755);
    if (bs.isNullOrNil(paramString1))
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(179755);
      return false;
    }
    ac.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcs.dck.dcp = 2131759025;; paramcs.dck.dcp = 2131759024)
      {
        AppMethodBeat.o(179755);
        return false;
      }
    }
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localagx.aIQ(paramString1);
    localagx.XM(4);
    localagx.aIM(com.tencent.mm.vfs.i.VW(paramString1));
    localagx.aIR(paramString2);
    localagx.XL(0);
    localagx.aIC(paramString3);
    localagx.aID(paramString4);
    localaht.aJC(com.tencent.mm.model.u.axw());
    localaht.aJD(com.tencent.mm.model.u.axw());
    localaht.XV(paramInt);
    localaht.zY(bs.eWj());
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    paramcs.dck.title = localagx.title;
    paramcs.dck.desc = localagx.title;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 4;
    AppMethodBeat.o(179755);
    return true;
  }
  
  public static boolean a(cs paramcs, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = e(paramcs, ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(cs paramcs, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramcs == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(30940);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bs.bG(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new ahe();
    paramIntent.aJt((String)localObject1);
    paramIntent.B(d1);
    paramIntent.A(d2);
    paramIntent.XR(i);
    paramIntent.aJu((String)localObject2);
    localObject1 = new ahn();
    localObject2 = new aht();
    String str = com.tencent.mm.model.u.axw();
    ((aht)localObject2).aJC(str);
    ((aht)localObject2).aJD(str);
    ((aht)localObject2).XV(6);
    ((aht)localObject2).zY(bs.eWj());
    ((ahn)localObject1).d(paramIntent);
    ((ahn)localObject1).a((aht)localObject2);
    paramcs.dck.dcm = ((ahn)localObject1);
    paramcs.dck.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(cs paramcs, k.b paramb, ahn paramahn, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new pw();
    ((pw)localObject).dsN.type = 0;
    ((pw)localObject).dsN.dsP = paramb.hij;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((pw)localObject).dsO.dsX;
    if (localc == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30959);
      return false;
    }
    paramahn.aJA(localc.title);
    Iterator localIterator = localc.hkS.iterator();
    int i = 0;
    agx localagx;
    if (localIterator.hasNext())
    {
      localagx = (agx)localIterator.next();
      switch (localagx.dataType)
      {
      case 9: 
      case 13: 
      case 18: 
      case 21: 
      default: 
        paramb = null;
        label242:
        if (paramb != null) {
          if (parambo.field_isSend == 1) {
            if ((w.sQ(parambo.field_talker)) || (parambo.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambo.field_msgSvrId), Integer.valueOf(i) });
              paramb.aIU((String)localObject);
              paramb.aJk(localagx.iaU);
              paramahn.nxC.add(paramb);
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
      long l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      paramb.XM(3);
      if (!bs.isNullOrNil(localagx.EAh))
      {
        localObject = new pw();
        ((pw)localObject).dsN.type = 1;
        ((pw)localObject).dsN.dhe = localagx;
        ((pw)localObject).dsN.msgId = l;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
          ac.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.aIQ(((pw)localObject).dsO.dsY);
        paramb.XL(localagx.duration);
        paramb.vz(true);
        paramb.vy(false);
        paramb.aIM(localagx.Ezu);
      }
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECa += 1;
      break label242;
      paramb = a(localagx, paramBoolean);
      paramb.XM(1);
      paramb.aID(localagx.desc);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).EBY += 1;
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      paramb.XM(2);
      localObject = new pw();
      ((pw)localObject).dsN.type = 1;
      ((pw)localObject).dsN.dhe = localagx;
      ((pw)localObject).dsN.msgId = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
        ac.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.aIQ(((pw)localObject).dsO.dsY);
      paramb.aIR(((pw)localObject).dsO.thumbPath);
      paramb.vz(false);
      paramb.vy(false);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).EBZ += 1;
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      a(paramb, localagx);
      paramb.XM(5);
      localObject = new pw();
      ((pw)localObject).dsN.type = 1;
      ((pw)localObject).dsN.dhe = localagx;
      ((pw)localObject).dsN.msgId = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
        ac.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.aIR(((pw)localObject).dsO.thumbPath);
      paramb.vz(false);
      if ((localagx.EzZ != null) && (localagx.EzZ.EAK != null))
      {
        localObject = new aic();
        ((aic)localObject).aJP(localagx.EzZ.EAK.title);
        ((aic)localObject).aJQ(localagx.EzZ.EAK.desc);
        ((aic)localObject).aJS(localagx.EzZ.EAK.thumbUrl);
        ((aic)localObject).XW(localagx.EzZ.EAK.ECn);
        ((aic)localObject).aJR(localagx.EzZ.EAK.ECl);
        paramb.EzZ.a((aic)localObject);
      }
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECb += 1;
      break label242;
      paramb = a(localagx, paramBoolean);
      paramb.aIC(localagx.title);
      paramb.aID(localagx.desc);
      paramb.EzZ.c(localagx.EzZ.EBc);
      paramb.XM(22);
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      a(paramb, localagx);
      if (localagx.dataType == 15) {
        paramb.XM(15);
      }
      for (;;)
      {
        localObject = new pw();
        ((pw)localObject).dsN.type = 1;
        ((pw)localObject).dsN.dhe = localagx;
        ((pw)localObject).dsN.msgId = l;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
          ac.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.vy(false);
        paramb.aIQ(((pw)localObject).dsO.dsY);
        paramb.a(localagx.EzZ);
        paramb.vz(false);
        paramb.aIR(((pw)localObject).dsO.thumbPath);
        paramb.XL(localagx.duration);
        localObject = paramcs.dck.dcn;
        ((aib)localObject).sKb += 1;
        break;
        paramb.XM(4);
      }
      paramb = a(localagx, paramBoolean);
      paramb.XM(6);
      if ((localagx.EzZ != null) && (localagx.EzZ.EAI != null))
      {
        localObject = new ahe();
        ((ahe)localObject).aJt(localagx.EzZ.EAI.label);
        ((ahe)localObject).B(localagx.EzZ.EAI.lat);
        ((ahe)localObject).A(localagx.EzZ.EAI.lng);
        ((ahe)localObject).XR(localagx.EzZ.EAI.dmN);
        ((ahe)localObject).aJu(localagx.EzZ.EAI.dry);
        paramb.EzZ.c((ahe)localObject);
      }
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECc += 1;
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      a(paramb, localagx);
      paramb.aJi(localagx.songAlbumUrl);
      paramb.aJj(localagx.songLyric);
      paramb.XM(7);
      localObject = new pw();
      ((pw)localObject).dsN.type = 1;
      ((pw)localObject).dsN.dhe = localagx;
      ((pw)localObject).dsN.msgId = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
        ac.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.aIR(((pw)localObject).dsO.thumbPath);
      paramb.vz(false);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECd += 1;
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      a(paramb, localagx);
      paramb.XM(8);
      localObject = new pw();
      ((pw)localObject).dsN.type = 1;
      ((pw)localObject).dsN.dhe = localagx;
      ((pw)localObject).dsN.msgId = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bs.isNullOrNil(((pw)localObject).dsO.dsY)) && (bs.isNullOrNil(((pw)localObject).dsO.thumbPath))) {
        ac.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.aIQ(((pw)localObject).dsO.dsY);
      paramb.aIR(((pw)localObject).dsO.thumbPath);
      paramb.vy(false);
      paramb.aIM(localagx.Ezu);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).fileCount += 1;
      break label242;
      paramb = b(localagx, localagx.dataType, paramBoolean);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECf += 1;
      break label242;
      paramb = b(localagx, localagx.dataType, paramBoolean);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECg += 1;
      break label242;
      paramb = a(localagx, paramBoolean);
      paramb.XM(14);
      if ((localagx.EzZ != null) && (localagx.EzZ.EAO != null))
      {
        localObject = new ahw();
        ((ahw)localObject).aJL(localagx.EzZ.EAO.title);
        ((ahw)localObject).aJM(localagx.EzZ.EAO.desc);
        ((ahw)localObject).aJO(localagx.EzZ.EAO.info);
        ((ahw)localObject).aJN(localagx.EzZ.EAO.thumbUrl);
        paramb.EzZ.a((ahw)localObject);
      }
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECj += 1;
      break label242;
      paramb = a(localagx, paramBoolean);
      paramb.XM(16);
      paramb.aID(localagx.desc);
      localObject = paramcs.dck.dcn;
      ((aib)localObject).ECk += 1;
      break label242;
      paramb = a(localagx, paramBoolean);
      paramb.aIC(localagx.title);
      paramb.aID(localagx.desc);
      paramb.XM(17);
      paramb.aJc(localagx.EAp);
      break label242;
      l = parambo.field_msgId;
      paramb = a(localagx, paramBoolean);
      paramb.aIC(localagx.title);
      paramb.aID(localagx.desc);
      paramb.XM(19);
      localObject = new pw();
      ((pw)localObject).dsN.type = 1;
      ((pw)localObject).dsN.dhe = localagx;
      ((pw)localObject).dsN.msgId = l;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (bs.isNullOrNil(((pw)localObject).dsO.thumbPath)) {
        ac.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localagx.EzZ != null) && (localagx.EzZ.EAX != null))
        {
          localObject = new agv();
          ((agv)localObject).username = localagx.EzZ.EAX.username;
          ((agv)localObject).appId = localagx.EzZ.EAX.appId;
          ((agv)localObject).dib = localagx.EzZ.EAX.dib;
          ((agv)localObject).iconUrl = localagx.EzZ.EAX.iconUrl;
          ((agv)localObject).type = localagx.EzZ.EAX.type;
          ((agv)localObject).cYQ = localagx.EzZ.EAX.cYQ;
          ((agv)localObject).EyV = localagx.EzZ.EAX.EyV;
          ((agv)localObject).version = localagx.EzZ.EAX.version;
          ((agv)localObject).ccR = localagx.EzZ.EAX.ccR;
          ((agv)localObject).jWX = localagx.EzZ.EAX.jWX;
          ((agv)localObject).dxK = localagx.EzZ.EAX.dxK;
          paramb.EzZ.b((agv)localObject);
        }
        break;
        paramb.vz(false);
        paramb.aIR(((pw)localObject).dsO.thumbPath);
      }
      paramb = a(localagx, paramBoolean);
      paramb.XM(20);
      paramb.XL(localagx.duration);
      break label242;
      localObject = String.format("%s#%d$%d", new Object[] { parambo.field_talker, Long.valueOf(parambo.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambo.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      if (com.tencent.mm.plugin.fav.ui.l.j((agx)localc.hkS.get(0))) {}
      for (paramcs.dck.type = 18;; paramcs.dck.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30949);
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    parambo = bv.L(parambo.field_content, "msg");
    if (parambo != null) {
      try
      {
        ahe localahe = new ahe();
        localahe.aJt((String)parambo.get(".msg.location.$label"));
        localahe.B(Double.parseDouble((String)parambo.get(".msg.location.$x")));
        localahe.A(Double.parseDouble((String)parambo.get(".msg.location.$y")));
        localahe.XR(Integer.valueOf((String)parambo.get(".msg.location.$scale")).intValue());
        localahe.aJu((String)parambo.get(".msg.location.$poiname"));
        localahn.d(localahe);
        paramcs.dck.type = 6;
        paramcs.dck.dcm = localahn;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception parambo)
      {
        ac.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambo.getStackTrace().toString() });
      }
    }
    paramcs.dck.dcp = 2131758895;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static boolean a(cs paramcs, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(30941);
    if ((paramcs == null) || (bs.isNullOrNil(paramString1)))
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(30941);
      return false;
    }
    ac.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcs.dck.dcp = 2131759025;; paramcs.dck.dcp = 2131759024)
      {
        AppMethodBeat.o(30941);
        return false;
      }
    }
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localagx.aIQ(paramString1);
    localagx.XM(8);
    localagx.aIM(com.tencent.mm.vfs.i.VW(paramString1));
    localagx.vz(true);
    localagx.aIC(paramString2);
    localagx.aID(paramString3);
    localaht.aJC(com.tencent.mm.model.u.axw());
    localaht.aJD(com.tencent.mm.model.u.axw());
    localaht.XV(13);
    localaht.zY(bs.eWj());
    localahn.a(localaht);
    localahn.nxC.add(localagx);
    paramcs.dck.title = localagx.title;
    paramcs.dck.desc = localagx.title;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 8;
    AppMethodBeat.o(30941);
    return true;
  }
  
  private static aht aC(bo parambo)
  {
    AppMethodBeat.i(30946);
    aht localaht = new aht();
    if (parambo.field_isSend == 1)
    {
      localaht.aJC(com.tencent.mm.model.u.axw());
      localaht.aJD(parambo.field_talker);
      if (w.sQ(parambo.field_talker)) {
        localaht.aJF(localaht.dng);
      }
    }
    do
    {
      localaht.XV(1);
      localaht.zY(parambo.field_createTime);
      localaht.aJG(parambo.field_msgSvrId);
      if (parambo.field_msgSvrId > 0L) {
        localaht.aJE(parambo.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localaht;
      localaht.aJC(parambo.field_talker);
      localaht.aJD(com.tencent.mm.model.u.axw());
    } while (!w.sQ(parambo.field_talker));
    if (parambo.field_content != null) {}
    for (String str = parambo.field_content.substring(0, Math.max(0, parambo.field_content.indexOf(':')));; str = "")
    {
      localaht.aJF(str);
      if ((bs.isNullOrNil(localaht.EBj)) || (parambo.eZl())) {
        break;
      }
      parambo.setContent(parambo.field_content.substring(localaht.EBj.length() + 1));
      if ((parambo.field_content.length() > 0) && ('\n' == parambo.field_content.charAt(0))) {
        parambo.setContent(parambo.field_content.substring(1));
      }
      if (!parambo.fbO()) {
        break;
      }
      parambo.rh(parambo.field_transContent.substring(localaht.EBj.length() + 1));
      if ((parambo.field_transContent.length() <= 0) || ('\n' != parambo.field_transContent.charAt(0))) {
        break;
      }
      parambo.rh(parambo.field_transContent.substring(1));
      break;
    }
  }
  
  private static String aFW(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = com.tencent.mm.sdk.platformtools.l.d(com.tencent.mm.plugin.record.b.awO(), "recbiz_", paramString, ".rec", 2);
    if (bs.isNullOrNil(paramString))
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
  
  private static agx b(agx paramagx, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    agx localagx = a(paramagx, paramBoolean);
    localagx.XM(paramInt);
    if ((paramagx.EzZ != null) && (paramagx.EzZ.EAM != null))
    {
      ahm localahm = new ahm();
      localahm.aJv(paramagx.EzZ.EAM.title);
      localahm.aJw(paramagx.EzZ.EAM.desc);
      localahm.XS(paramagx.EzZ.EAM.type);
      localahm.aJy(paramagx.EzZ.EAM.info);
      localahm.aJx(paramagx.EzZ.EAM.thumbUrl);
      localagx.EzZ.a(localahm);
    }
    AppMethodBeat.o(30963);
    return localagx;
  }
  
  public static boolean b(cs paramcs, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcs.dck.dcp = 2131758885;
      AppMethodBeat.o(30942);
      return false;
    }
    ac.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ahn localahn = new ahn();
    aht localaht = new aht();
    localaht.aJC(com.tencent.mm.model.u.axw());
    localaht.aJD(com.tencent.mm.model.u.axw());
    localaht.XV(paramInt);
    localaht.zY(bs.eWj());
    localahn.a(localaht);
    paramcs.dck.desc = paramString;
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static boolean d(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30957);
    ahn localahn = new ahn();
    Object localObject1 = aC(parambo);
    localahn.a((aht)localObject1);
    try
    {
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
      Object localObject2 = localu.hkS;
      ((aht)localObject1).aJK(localu.dvl);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcs.dck.dco))
      {
        ac.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcs.dck.dco) });
        v localv = (v)((List)localObject2).get(paramcs.dck.dco);
        if (m.vC(localv.hli))
        {
          paramcs.dck.dcp = 2131758893;
          AppMethodBeat.o(30957);
          return false;
        }
        ((aht)localObject1).aJJ(localv.url);
        if (paramcs.dck.dco > 0) {
          ((aht)localObject1).aJE("");
        }
        agx localagx = new agx();
        localagx.aIC(localv.title);
        localagx.aID(localv.hlf);
        a(localagx, parambo);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2))
        {
          parambo = com.tencent.mm.aj.p.aBw().Ak(parambo.field_talker);
          localObject1 = localObject2;
          if (parambo != null) {
            localObject1 = parambo.aBo();
          }
        }
        if (!bs.isNullOrNil((String)localObject1))
        {
          localagx.aIR(r.aGc((String)localObject1));
          localagx.vz(false);
          if ((bs.isNullOrNil(localagx.EzF)) || (!com.tencent.mm.vfs.i.eA(localagx.EzF)))
          {
            localagx.aIL((String)localObject1);
            localagx.vz(true);
          }
        }
        for (;;)
        {
          localagx.vy(true);
          localagx.XM(5);
          localahn.nxC.add(localagx);
          paramcs.dck.dcm = localahn;
          paramcs.dck.desc = localv.title;
          paramcs.dck.type = 5;
          parambo = new aic();
          parambo.aJS((String)localObject1);
          parambo.aJP(localv.title);
          parambo.aJQ(localv.hlf);
          localahn.b(parambo);
          localahn.f(m.a(localv, parambo, localu.dvl, localu.dvm));
          AppMethodBeat.o(30957);
          return true;
          localagx.vz(true);
        }
      }
      return false;
    }
    catch (Exception parambo)
    {
      ac.printErrStackTrace("MicroMsg.GetFavDataSource", parambo, "", new Object[0]);
      ac.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambo.getLocalizedMessage() });
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean e(cs paramcs, bo parambo)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramcs == null) || (parambo == null))
    {
      ac.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcs != null) {
        paramcs.dck.dcp = 2131758885;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    parambo = bo.aK(parambo);
    if (parambo.isText()) {
      bool = f(paramcs, parambo);
    }
    for (;;)
    {
      paramcs.dck.dbZ = parambo.field_content;
      if ((bool) || (paramcs.dck.dcp == 0)) {
        com.tencent.mm.plugin.fav.ui.e.a(parambo, paramcs, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (parambo.eZl())
      {
        bool = h(paramcs, parambo);
      }
      else if (parambo.cKP())
      {
        bool = a(paramcs, parambo);
      }
      else if (parambo.eZm())
      {
        bool = g(paramcs, parambo);
      }
      else if ((parambo.crt()) || (parambo.crv()))
      {
        bool = j(paramcs, parambo);
      }
      else if (parambo.cru())
      {
        bool = i(paramcs, parambo);
      }
      else if (parambo.eZj())
      {
        bool = d(paramcs, parambo);
      }
      else
      {
        if (parambo.fbB()) {}
        while ((!parambo.cKN()) || (parambo.fbD()))
        {
          paramcs.dck.dcp = 2131758893;
          break;
        }
        bool = k(paramcs, parambo);
      }
    }
  }
  
  private static boolean f(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30947);
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    paramcs.dck.dcm = localahn;
    paramcs.dck.desc = parambo.field_content;
    paramcs.dck.type = 1;
    if (com.tencent.mm.ui.tools.f.aRl(paramcs.dck.desc) > com.tencent.mm.m.b.ZD())
    {
      paramcs.dck.dcp = 2131759022;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean g(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (parambo.field_msgId > 0L) {
      localObject1 = com.tencent.mm.av.o.aFx().qg(parambo.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.e)localObject1).dcd > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambo.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.av.o.aFx().qf(parambo.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcs.dck.dcp = 2131758891;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new ahn();
    ((ahn)localObject1).a(aC(parambo));
    agx localagx = new agx();
    a(localagx, parambo);
    localagx.XM(2);
    localagx.aIQ(com.tencent.mm.av.o.aFx().p(com.tencent.mm.av.f.c((com.tencent.mm.av.e)localObject2), "", ""));
    if (((com.tencent.mm.av.e)localObject2).aFa())
    {
      localObject2 = com.tencent.mm.av.o.aFx().oR(((com.tencent.mm.av.e)localObject2).hGX);
      if (((com.tencent.mm.av.e)localObject2).hux > ((com.tencent.mm.av.e)localObject2).offset) {
        localagx.aIQ(com.tencent.mm.av.o.aFx().p("SERVERID://" + parambo.field_msgSvrId, "", ""));
      }
    }
    localagx.aIR(com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true));
    localagx.aJk(bk.yu(parambo.eul));
    parambo = new LinkedList();
    parambo.add(localagx);
    ((ahn)localObject1).bk(parambo);
    paramcs.dck.dcm = ((ahn)localObject1);
    paramcs.dck.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean h(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30951);
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    agx localagx = new agx();
    a(localagx, parambo);
    if (w.xd(parambo.field_talker)) {
      localagx.aIQ(aFW(parambo.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localagx.XM(3);
      localagx.vz(true);
      localb = com.tencent.mm.modelvoice.s.EC(parambo.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localagx.aIQ(com.tencent.mm.modelvoice.s.getFullPath(parambo.field_imgPath));
    }
    localagx.aIM(Wq(localb.getFormat()));
    localagx.XL((int)new com.tencent.mm.modelvoice.p(parambo.field_content).time);
    parambo = new LinkedList();
    parambo.add(localagx);
    localahn.bk(parambo);
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean i(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.az(parambo.field_content, parambo.field_reserved);
    if (localObject == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    agx localagx = new agx();
    a(localagx, parambo);
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIR(t.DW(parambo.field_imgPath));
    localagx.aIM(com.tencent.mm.vfs.i.VW(localagx.EzD));
    localagx.aIQ("");
    localagx.aIL(((k.b)localObject).thumburl);
    ahf localahf = m.t(parambo);
    if (localahf == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localagx.XL(localahf.duration);
    localagx.aIC(((k.b)localObject).title);
    localagx.aII(((k.b)localObject).url);
    localagx.vy(true);
    localagx.vz(true);
    localObject = new agy();
    if (parambo.cru()) {
      ((agy)localObject).e(localahf);
    }
    localagx.a((agy)localObject);
    parambo = new LinkedList();
    parambo.add(localagx);
    localahn.bk(parambo);
    paramcs.dck.dcm = localahn;
    paramcs.dck.type = 4;
    localagx.XM(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean j(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30954);
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    agx localagx = new agx();
    a(localagx, parambo);
    com.tencent.mm.modelvideo.o.aJy();
    localagx.aIR(t.DW(parambo.field_imgPath));
    localagx.aIM(com.tencent.mm.vfs.i.VW(localagx.EzD));
    Object localObject = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    if (localObject == null)
    {
      ac.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    ac.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).hux) });
    if (((com.tencent.mm.modelvideo.s)localObject).hux > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcs.dck.dcp = 2131759025;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((parambo.crv()) && (com.tencent.mm.modelvideo.u.El(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcs.dck.dcp = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).aJN())
    {
      com.tencent.mm.modelvideo.o.aJy();
      String str = t.DV(parambo.field_imgPath);
      ac.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localagx.aIQ(str);
      localagx.XL(((com.tencent.mm.modelvideo.s)localObject).hpy);
      localagx.aJk(bk.yu(parambo.eul));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localagx);
      localahn.bk((LinkedList)localObject);
      paramcs.dck.dcm = localahn;
      if (!parambo.crv()) {
        break label469;
      }
      paramcs.dck.type = 16;
      localagx.XM(15);
    }
    for (;;)
    {
      paramcs = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      localagx.aJa(paramcs.dvs);
      paramcs = paramcs.iaR;
      if ((paramcs != null) && (!bs.isNullOrNil(paramcs.hkb)))
      {
        parambo = new aha();
        parambo.hjV = paramcs.hjV;
        parambo.EBs = paramcs.EBs;
        parambo.hjY = paramcs.hjY;
        parambo.hjZ = paramcs.hjZ;
        parambo.hjX = paramcs.hjX;
        parambo.hka = paramcs.hka;
        parambo.hkb = paramcs.hkb;
        parambo.hkc = paramcs.hkc;
        localagx.a(parambo);
      }
      AppMethodBeat.o(30954);
      return true;
      ac.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localagx.aIQ("");
      break;
      label469:
      paramcs.dck.type = 4;
      localagx.XM(4);
    }
  }
  
  private static boolean k(cs paramcs, bo parambo)
  {
    AppMethodBeat.i(30956);
    ahn localahn = new ahn();
    localahn.a(aC(parambo));
    Object localObject1 = parambo.field_content;
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.vA((String)localObject1);
    if (localObject1 == null)
    {
      paramcs.dck.dcp = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    paramcs.dck.dcm = localahn;
    Object localObject2 = localahn.EBJ;
    ((aht)localObject2).aJI(((k.b)localObject1).appId);
    ((aht)localObject2).aJK(((k.b)localObject1).dvl);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramcs.dck.dcp = 2131758893;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramcs.dck.dcm = localahn;
      paramcs.dck.desc = ((k.b)localObject1).title;
      paramcs.dck.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bEO().aGd(((k.b)localObject1).cZa);
      localObject2 = new agx();
      a((agx)localObject2, parambo);
      if (localObject3 != null) {
        ((agx)localObject2).aIQ(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (com.tencent.mm.vfs.i.eA((String)localObject3)) {
        ((agx)localObject2).aIR((String)localObject3);
      }
      ((agx)localObject2).XM(2);
      ((agx)localObject2).aIC(((k.b)localObject1).title);
      ((agx)localObject2).aID(((k.b)localObject1).description);
      ((agx)localObject2).aJk(bk.yu(parambo.eul));
      localahn.nxC.add(localObject2);
      paramcs.dck.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      parambo = a(parambo, (k.b)localObject1, 7);
      localahn.nxC.add(parambo);
      paramcs.dck.type = 7;
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(parambo, (k.b)localObject1, 4);
      localahn.aJA(((agx)localObject1).title);
      localahn.aJB(((agx)localObject1).desc);
      ((agx)localObject1).aJk(bk.yu(parambo.eul));
      localahn.nxC.add(localObject1);
      paramcs.dck.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localahn.EBJ.aJJ(((k.b)localObject1).url);
        localObject2 = new aic();
        ((aic)localObject2).aJS(((k.b)localObject1).thumburl);
        localObject3 = (aa)((k.b)localObject1).ao(aa.class);
        if ((localObject3 != null) && (!bs.isNullOrNil(((aa)localObject3).BYK)))
        {
          localObject4 = new StringBuilder();
          ((aa)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((aic)localObject2).aJU(((StringBuilder)localObject4).toString());
        }
        localahn.b((aic)localObject2);
        a(parambo, localahn, (aic)localObject2);
        parambo = a(parambo, (k.b)localObject1, 5);
        localahn.nxC.add(parambo);
        localahn.aJA(parambo.title);
        localahn.aJB(parambo.desc);
        paramcs.dck.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramcs.dck.dcp = 2131758889;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      parambo = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (parambo != null)
      {
        parambo = parambo.hTI;
        localahn.aJA(parambo.nickname + ai.getContext().getString(2131759007));
        localahn.aJB(parambo.desc);
        localahn.d(parambo);
        paramcs.dck.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bEO().aGd(((k.b)localObject1).cZa);
      localObject2 = new agx();
      if (localObject3 != null) {
        ((agx)localObject2).aIQ(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((agx)localObject2, parambo);
      ((agx)localObject2).XM(8);
      ((agx)localObject2).aIM(((k.b)localObject1).hhG);
      parambo = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
      if (bs.isNullOrNil(parambo)) {
        ((agx)localObject2).vz(true);
      }
      if (com.tencent.mm.vfs.i.eA(parambo)) {
        ((agx)localObject2).aIR(parambo);
      }
      ((agx)localObject2).aIC(((k.b)localObject1).title);
      ((agx)localObject2).aID(((k.b)localObject1).description);
      localahn.nxC.add(localObject2);
      paramcs.dck.desc = ((k.b)localObject1).title;
      paramcs.dck.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).cZa == null) || (((k.b)localObject1).cZa.length() == 0)) {
        paramcs.dck.dcp = 2131758886;
      }
      while (com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        paramcs.dck.dcp = 2131758893;
        AppMethodBeat.o(30956);
        return false;
      }
      paramcs.dck.dcp = 2131758901;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      parambo = new ahm();
      parambo.aJv(((k.b)localObject1).title);
      parambo.aJw(((k.b)localObject1).description);
      parambo.XS(((k.b)localObject1).hie);
      parambo.aJy(((k.b)localObject1).hif);
      parambo.aJx(((k.b)localObject1).thumburl);
      paramcs.dck.title = ((k.b)localObject1).title;
      paramcs.dck.desc = ((k.b)localObject1).description;
      paramcs.dck.type = 10;
      localahn.b(parambo);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      parambo = new ahw();
      parambo.aJL(((k.b)localObject1).title);
      parambo.aJM(((k.b)localObject1).description);
      parambo.aJO(((k.b)localObject1).hii);
      parambo.aJN(((k.b)localObject1).thumburl);
      paramcs.dck.title = ((k.b)localObject1).title;
      paramcs.dck.desc = ((k.b)localObject1).description;
      paramcs.dck.type = 15;
      localahn.b(parambo);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      parambo = new ahm();
      parambo.aJv(((k.b)localObject1).title);
      parambo.aJw(((k.b)localObject1).description);
      parambo.XS(((k.b)localObject1).hik);
      parambo.aJy(((k.b)localObject1).hil);
      parambo.aJx(((k.b)localObject1).thumburl);
      paramcs.dck.title = ((k.b)localObject1).title;
      paramcs.dck.desc = ((k.b)localObject1).description;
      paramcs.dck.type = 11;
      localahn.b(parambo);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramcs.dck.dcn = new aib();
      bool = a(paramcs, (k.b)localObject1, localahn, parambo, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramcs.dck.dcn = new aib();
      bool = a(paramcs, (k.b)localObject1, localahn, parambo, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new agv();
    ((agv)localObject3).username = ((k.b)localObject1).hke;
    ((agv)localObject3).appId = ((k.b)localObject1).hkf;
    ((agv)localObject3).dib = ((k.b)localObject1).hkq;
    ((agv)localObject3).iconUrl = ((k.b)localObject1).hks;
    ((agv)localObject3).cYQ = ((k.b)localObject1).hkd;
    ((agv)localObject3).EyV = ((k.b)localObject1).dvm;
    ((agv)localObject3).jWX = ((k.b)localObject1).hkn;
    ((agv)localObject3).type = ((k.b)localObject1).hkg;
    Object localObject4 = (com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class);
    if (localObject4 != null)
    {
      ((agv)localObject3).ccR = ((com.tencent.mm.ah.a)localObject4).hfZ;
      ((agv)localObject3).dxK = ((com.tencent.mm.ah.a)localObject4).hgb;
      ((agv)localObject3).subType = ((com.tencent.mm.ah.a)localObject4).hgc;
    }
    ((agv)localObject3).version = ((k.b)localObject1).hkr;
    localObject4 = new agx();
    a((agx)localObject4, parambo);
    ((agx)localObject4).XM(19);
    String str = com.tencent.mm.av.o.aFx().R(parambo.field_imgPath, true);
    if (bs.isNullOrNil(str)) {
      ((agx)localObject4).vz(true);
    }
    if (com.tencent.mm.vfs.i.eA(str)) {
      ((agx)localObject4).aIR(str);
    }
    ((agx)localObject4).aIC(((k.b)localObject1).title);
    ((agx)localObject4).aID(((k.b)localObject1).description);
    localahn.nxC.add(localObject4);
    localahn.aJA(((k.b)localObject1).title);
    if (w.sQ(parambo.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((aht)localObject2).XV(i);
      paramcs.dck.title = ((k.b)localObject1).title;
      paramcs.dck.desc = ((k.b)localObject1).description;
      paramcs.dck.type = 19;
      localahn.c((agv)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static agz q(agx paramagx)
  {
    AppMethodBeat.i(30960);
    agz localagz = new agz();
    paramagx = paramagx.EzZ.EAG;
    if (paramagx.EBf) {
      localagz.aJl(paramagx.dng);
    }
    if (paramagx.EBg) {
      localagz.aJm(paramagx.toUser);
    }
    if (paramagx.EBk) {
      localagz.aJo(paramagx.EBj);
    }
    localagz.XQ(1);
    localagz.zV(bs.eWj());
    AppMethodBeat.o(30960);
    return localagz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */