package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.aj.j;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.b;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.d;
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
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class h
{
  private static aml a(aml paramaml, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    aml localaml = new aml();
    amm localamm = new amm();
    localamm.c(q(paramaml));
    localamm.d(paramaml.Lwh.IXu);
    localaml.a(localamm);
    localaml.bgA(paramaml.Lwj);
    localaml.bgB(paramaml.Lwl);
    localaml.bgJ(paramaml.LwI);
    localaml.bgK(paramaml.LwK);
    localaml.At(true);
    localaml.As(true);
    localaml.bgC(paramaml.Lwp);
    localaml.ajf(paramaml.Lwv);
    localaml.bgq(paramaml.LvE);
    localaml.bgr(paramaml.LvG);
    localaml.Mu(paramaml.LvI);
    localaml.bgv(paramaml.LvP);
    localaml.bgw(paramaml.LvR);
    localaml.Mv(paramaml.LvT);
    if (paramBoolean) {
      localaml.bgs(paramaml.dLl);
    }
    AppMethodBeat.o(30961);
    return localaml;
  }
  
  private static aml a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    aml localaml = new aml();
    a(localaml, paramca);
    localaml.bgm(paramb.ixd);
    localaml.bgn(paramb.ixe);
    localaml.bgl(paramb.url);
    localaml.As(true);
    paramca = new com.tencent.mm.vfs.o(Util.nullAs(q.bcR().R(paramca.field_imgPath, true), ""));
    if (paramca.exists()) {
      localaml.bgu(aa.z(paramca.her()));
    }
    for (;;)
    {
      localaml.bgf(paramb.title);
      localaml.bgg(paramb.description);
      localaml.bgE(paramb.canvasPageXml);
      localaml.ajd(paramInt);
      localaml.bgD(paramb.ean);
      paramca = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (paramca != null)
      {
        localaml.bgL(paramca.songAlbumUrl);
        localaml.bgM(paramca.songLyric);
        if (paramInt == 29)
        {
          paramb = new amm();
          css localcss = new css();
          localcss.Ktn = paramca.Ktn;
          localcss.Kto = paramca.Kto;
          localcss.Ktp = paramca.Ktp;
          localcss.Ktq = paramca.Ktq;
          localcss.singerName = paramca.Ktr;
          localcss.albumName = paramca.Kts;
          localcss.musicGenre = paramca.Ktt;
          localcss.issueDate = Util.safeParseLong(paramca.Ktu);
          localcss.identification = paramca.Ktv;
          localcss.Alz = paramca.Alz;
          localcss.extraInfo = paramca.Ktw;
          paramb.e(localcss);
          localaml.a(paramb);
        }
      }
      AppMethodBeat.o(30955);
      return localaml;
      localaml.At(true);
    }
  }
  
  private static void a(aml paramaml1, aml paramaml2)
  {
    AppMethodBeat.i(30962);
    paramaml1.bgm(paramaml2.Lvw);
    paramaml1.bgn(paramaml2.Lvy);
    paramaml1.bgl(paramaml2.Lvu);
    paramaml1.bgf(paramaml2.title);
    paramaml1.bgg(paramaml2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(aml paramaml, ca paramca)
  {
    AppMethodBeat.i(30950);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Eq(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
      {
        paramaml.bgx(String.valueOf(paramca.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramaml.bgx(paramca.field_talker + "#" + String.valueOf(paramca.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramaml.bgx(String.valueOf(paramca.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(ca paramca, anb paramanb, anq paramanq)
  {
    AppMethodBeat.i(30958);
    paramanb.f(m.a(paramca, paramanq));
    AppMethodBeat.o(30958);
  }
  
  private static void a(boolean paramBoolean, ca paramca, k.b paramb, cz paramcz, anb paramanb)
  {
    AppMethodBeat.i(232142);
    int i;
    if (paramBoolean) {
      i = 29;
    }
    for (int j = 21;; j = 7)
    {
      paramca = a(paramca, paramb, i);
      paramanb.ppH.add(paramca);
      paramcz.dFZ.type = j;
      AppMethodBeat.o(232142);
      return;
      i = 7;
    }
  }
  
  public static boolean a(cz paramcz, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramcz == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localaml.ajd(2);
    localaml.bgt(paramString);
    localaml.bgs(com.tencent.mm.b.g.getMessageDigest((localaml.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new hb();
    ((hb)localObject).dLm.type = 27;
    ((hb)localObject).dLm.dLo = localaml;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((hb)localObject).dLn.thumbPath;
    BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
    localaml.bgu((String)localObject);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(paramInt);
    localanh.MA(Util.nowMilliSecond());
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    paramcz.dFZ.title = localaml.title;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(cz paramcz, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(232140);
    if ((paramcz == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(232140);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt1) });
    if (new com.tencent.mm.vfs.o(paramString1).length() > ((af)com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcz.dFZ.dGe = 2131759351;; paramcz.dFZ.dGe = 2131759350)
      {
        AppMethodBeat.o(232140);
        return false;
      }
    }
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localaml.bgt(paramString1);
    localaml.ajd(4);
    localaml.bgp(com.tencent.mm.vfs.s.akC(paramString1));
    localaml.bgu(paramString2);
    localaml.ajc(paramInt2);
    localaml.bgf(paramString3);
    localaml.bgg(paramString4);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(paramInt1);
    localanh.MA(Util.nowMilliSecond());
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    paramcz.dFZ.title = localaml.title;
    paramcz.dFZ.desc = localaml.title;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 4;
    AppMethodBeat.o(232140);
    return true;
  }
  
  public static boolean a(cz paramcz, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(232141);
    if ((paramcz == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(232141);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.o(paramString1).length() > ((af)com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcz.dFZ.dGe = 2131759351;; paramcz.dFZ.dGe = 2131759350)
      {
        AppMethodBeat.o(232141);
        return false;
      }
    }
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localaml.bgt(paramString1);
    localaml.ajd(8);
    localaml.bgp(com.tencent.mm.vfs.s.akC(paramString1));
    localaml.At(true);
    localaml.bgf(paramString2);
    localaml.bgg(paramString3);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(paramInt);
    localanh.MA(Util.nowMilliSecond());
    localanb.a(localanh);
    localanb.ppH.add(localaml);
    paramcz.dFZ.title = localaml.title;
    paramcz.dFZ.desc = localaml.title;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 8;
    AppMethodBeat.o(232141);
    return true;
  }
  
  public static boolean a(cz paramcz, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = d(paramcz, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(cz paramcz, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramcz == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(30940);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = Util.nullAs(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new ams();
    paramIntent.bgW((String)localObject1);
    paramIntent.C(d1);
    paramIntent.B(d2);
    paramIntent.aji(i);
    paramIntent.bgX((String)localObject2);
    localObject1 = new anb();
    localObject2 = new anh();
    String str = z.aTY();
    ((anh)localObject2).bhf(str);
    ((anh)localObject2).bhg(str);
    ((anh)localObject2).ajm(6);
    ((anh)localObject2).MA(Util.nowMilliSecond());
    ((anb)localObject1).d(paramIntent);
    ((anb)localObject1).a((anh)localObject2);
    paramcz.dFZ.dGb = ((anb)localObject1);
    paramcz.dFZ.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(cz paramcz, k.b paramb, anb paramanb, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new rc();
    ((rc)localObject).dXF.type = 0;
    ((rc)localObject).dXF.dXH = paramb.ixl;
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((rc)localObject).dXG.dXP;
    if (localc == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(30959);
      return false;
    }
    paramanb.bhd(localc.title);
    Iterator localIterator = localc.iAd.iterator();
    int i = 0;
    aml localaml;
    if (localIterator.hasNext())
    {
      localaml = (aml)localIterator.next();
      switch (localaml.dataType)
      {
      case 9: 
      case 13: 
      case 18: 
      case 21: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      default: 
        paramb = null;
        label270:
        if (paramb != null) {
          if (paramca.field_isSend == 1) {
            if ((ab.Eq(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
              label335:
              paramb.bgx((String)localObject);
              paramb.bgN(localaml.jsz);
              paramanb.ppH.add(paramb);
              i += 1;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      break;
      long l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      paramb.ajd(3);
      if (!Util.isNullOrNil(localaml.Lwp))
      {
        localObject = new rc();
        ((rc)localObject).dXF.type = 1;
        ((rc)localObject).dXF.dKT = localaml;
        ((rc)localObject).dXF.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.bgt(((rc)localObject).dXG.dataPath);
        paramb.ajc(localaml.duration);
        paramb.At(true);
        paramb.As(false);
        paramb.bgp(localaml.LvC);
      }
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyr += 1;
      break label270;
      paramb = a(localaml, paramBoolean);
      paramb.ajd(1);
      paramb.bgg(localaml.desc);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyp += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      paramb.ajd(2);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.bgt(((rc)localObject).dXG.dataPath);
      paramb.bgu(((rc)localObject).dXG.thumbPath);
      paramb.At(false);
      paramb.As(false);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyq += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      a(paramb, localaml);
      paramb.ajd(5);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.bgu(((rc)localObject).dXG.thumbPath);
      paramb.At(false);
      if ((localaml.Lwh != null) && (localaml.Lwh.LwS != null))
      {
        localObject = new anq();
        ((anq)localObject).bhs(localaml.Lwh.LwS.title);
        ((anq)localObject).bht(localaml.Lwh.LwS.desc);
        ((anq)localObject).bhv(localaml.Lwh.LwS.thumbUrl);
        ((anq)localObject).ajn(localaml.Lwh.LwS.LyE);
        ((anq)localObject).bhu(localaml.Lwh.LwS.LyC);
        paramb.Lwh.a((anq)localObject);
      }
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lys += 1;
      break label270;
      paramb = a(localaml, paramBoolean);
      paramb.bgf(localaml.title);
      paramb.bgg(localaml.desc);
      paramb.Lwh.c(localaml.Lwh.Lxk);
      paramb.ajd(22);
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      a(paramb, localaml);
      if (localaml.dataType == 15) {
        paramb.ajd(15);
      }
      for (;;)
      {
        localObject = new rc();
        ((rc)localObject).dXF.type = 1;
        ((rc)localObject).dXF.dKT = localaml;
        ((rc)localObject).dXF.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.As(false);
        paramb.bgt(((rc)localObject).dXG.dataPath);
        paramb.a(localaml.Lwh);
        paramb.At(false);
        paramb.bgu(((rc)localObject).dXG.thumbPath);
        paramb.ajc(localaml.duration);
        localObject = paramcz.dFZ.dGc;
        ((anp)localObject).xiP += 1;
        break;
        paramb.ajd(4);
      }
      paramb = a(localaml, paramBoolean);
      paramb.ajd(6);
      if ((localaml.Lwh != null) && (localaml.Lwh.LwQ != null))
      {
        localObject = new ams();
        ((ams)localObject).bgW(localaml.Lwh.LwQ.label);
        ((ams)localObject).C(localaml.Lwh.LwQ.lat);
        ((ams)localObject).B(localaml.Lwh.LwQ.lng);
        ((ams)localObject).aji(localaml.Lwh.LwQ.dRt);
        ((ams)localObject).bgX(localaml.Lwh.LwQ.dWi);
        paramb.Lwh.c((ams)localObject);
      }
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyt += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      a(paramb, localaml);
      paramb.bgL(localaml.songAlbumUrl);
      paramb.bgM(localaml.songLyric);
      paramb.ajd(7);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bgu(((rc)localObject).dXG.thumbPath);
      paramb.At(false);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyu += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      a(paramb, localaml);
      if ((localaml != null) && (localaml.Lwh != null)) {
        paramb.Lwh.e(localaml.Lwh.Lxs);
      }
      paramb.bgL(localaml.songAlbumUrl);
      paramb.bgM(localaml.songLyric);
      paramb.ajd(29);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bgu(((rc)localObject).dXG.thumbPath);
      paramb.At(false);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyu += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      a(paramb, localaml);
      paramb.ajd(8);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((rc)localObject).dXG.dataPath)) && (Util.isNullOrNil(((rc)localObject).dXG.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.bgt(((rc)localObject).dXG.dataPath);
      paramb.bgu(((rc)localObject).dXG.thumbPath);
      paramb.As(false);
      paramb.bgp(localaml.LvC);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).fileCount += 1;
      break label270;
      paramb = b(localaml, localaml.dataType, paramBoolean);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyw += 1;
      break label270;
      paramb = b(localaml, localaml.dataType, paramBoolean);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).Lyx += 1;
      break label270;
      paramb = a(localaml, paramBoolean);
      paramb.ajd(14);
      if ((localaml.Lwh != null) && (localaml.Lwh.LwW != null))
      {
        localObject = new ank();
        ((ank)localObject).bho(localaml.Lwh.LwW.title);
        ((ank)localObject).bhp(localaml.Lwh.LwW.desc);
        ((ank)localObject).bhr(localaml.Lwh.LwW.info);
        ((ank)localObject).bhq(localaml.Lwh.LwW.thumbUrl);
        paramb.Lwh.a((ank)localObject);
      }
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).LyA += 1;
      break label270;
      paramb = a(localaml, paramBoolean);
      paramb.ajd(16);
      paramb.bgg(localaml.desc);
      localObject = paramcz.dFZ.dGc;
      ((anp)localObject).LyB += 1;
      break label270;
      paramb = a(localaml, paramBoolean);
      paramb.bgf(localaml.title);
      paramb.bgg(localaml.desc);
      paramb.ajd(17);
      paramb.bgF(localaml.Lwx);
      break label270;
      l = paramca.field_msgId;
      paramb = a(localaml, paramBoolean);
      paramb.bgf(localaml.title);
      paramb.bgg(localaml.desc);
      paramb.ajd(19);
      localObject = new rc();
      ((rc)localObject).dXF.type = 1;
      ((rc)localObject).dXF.dKT = localaml;
      ((rc)localObject).dXF.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if (Util.isNullOrNil(((rc)localObject).dXG.thumbPath)) {
        Log.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localaml.Lwh != null) && (localaml.Lwh.Lxf != null))
        {
          localObject = new amj();
          ((amj)localObject).username = localaml.Lwh.Lxf.username;
          ((amj)localObject).appId = localaml.Lwh.Lxf.appId;
          ((amj)localObject).dMe = localaml.Lwh.Lxf.dMe;
          ((amj)localObject).iconUrl = localaml.Lwh.Lxf.iconUrl;
          ((amj)localObject).type = localaml.Lwh.Lxf.type;
          ((amj)localObject).dCx = localaml.Lwh.Lxf.dCx;
          ((amj)localObject).Lve = localaml.Lwh.Lxf.Lve;
          ((amj)localObject).version = localaml.Lwh.Lxf.version;
          ((amj)localObject).leb = localaml.Lwh.Lxf.leb;
          ((amj)localObject).lyE = localaml.Lwh.Lxf.lyE;
          ((amj)localObject).eda = localaml.Lwh.Lxf.eda;
          paramb.Lwh.b((amj)localObject);
        }
        break;
        paramb.At(false);
        paramb.bgu(((rc)localObject).dXG.thumbPath);
      }
      paramb = a(localaml, paramBoolean);
      paramb.ajd(20);
      paramb.ajc(localaml.duration);
      break label270;
      localObject = String.format("%s#%d$%d", new Object[] { paramca.field_talker, Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
      break label335;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
      break label335;
      if (com.tencent.mm.plugin.fav.ui.l.j((aml)localc.iAd.get(0))) {}
      for (paramcz.dFZ.type = 18;; paramcz.dFZ.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30949);
    anb localanb = new anb();
    localanb.a(aR(paramca));
    paramca = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (paramca != null) {
      try
      {
        ams localams = new ams();
        localams.bgW((String)paramca.get(".msg.location.$label"));
        localams.C(Double.parseDouble((String)paramca.get(".msg.location.$x")));
        localams.B(Double.parseDouble((String)paramca.get(".msg.location.$y")));
        localams.aji(Integer.valueOf((String)paramca.get(".msg.location.$scale")).intValue());
        localams.bgX((String)paramca.get(".msg.location.$poiname"));
        localanb.d(localams);
        paramcz.dFZ.type = 6;
        paramcz.dFZ.dGb = localanb;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramcz.dFZ.dGe = 2131759219;
    AppMethodBeat.o(30949);
    return false;
  }
  
  private static anh aR(ca paramca)
  {
    AppMethodBeat.i(30946);
    anh localanh = new anh();
    if (paramca.field_isSend == 1)
    {
      localanh.bhf(z.aTY());
      localanh.bhg(paramca.field_talker);
      if (ab.Eq(paramca.field_talker)) {
        localanh.bhi(localanh.dRL);
      }
    }
    do
    {
      localanh.ajm(1);
      localanh.MA(paramca.field_createTime);
      localanh.bhj(paramca.field_msgSvrId);
      if (paramca.field_msgSvrId > 0L) {
        localanh.bhh(paramca.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localanh;
      localanh.bhf(paramca.field_talker);
      localanh.bhg(z.aTY());
    } while (!ab.Eq(paramca.field_talker));
    if (paramca.field_content != null) {}
    for (String str = paramca.field_content.substring(0, Math.max(0, paramca.field_content.indexOf(':')));; str = "")
    {
      localanh.bhi(str);
      if ((Util.isNullOrNil(localanh.LxA)) || (paramca.gAy())) {
        break;
      }
      paramca.setContent(paramca.field_content.substring(localanh.LxA.length() + 1));
      if ((paramca.field_content.length() > 0) && ('\n' == paramca.field_content.charAt(0))) {
        paramca.setContent(paramca.field_content.substring(1));
      }
      if (!paramca.gDz()) {
        break;
      }
      if ((!Util.isNullOrNil(paramca.field_transContent)) && (paramca.field_transContent.startsWith(localanh.LxA))) {
        paramca.CB(paramca.field_transContent.substring(localanh.LxA.length() + 1));
      }
      if ((paramca.field_transContent.length() <= 0) || ('\n' != paramca.field_transContent.charAt(0))) {
        break;
      }
      paramca.CB(paramca.field_transContent.substring(1));
      break;
    }
  }
  
  public static String ahD(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static aml b(aml paramaml, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    aml localaml = a(paramaml, paramBoolean);
    localaml.ajd(paramInt);
    if ((paramaml.Lwh != null) && (paramaml.Lwh.LwU != null))
    {
      ana localana = new ana();
      localana.bgY(paramaml.Lwh.LwU.title);
      localana.bgZ(paramaml.Lwh.LwU.desc);
      localana.ajj(paramaml.Lwh.LwU.type);
      localana.bhb(paramaml.Lwh.LwU.info);
      localana.bha(paramaml.Lwh.LwU.thumbUrl);
      localaml.Lwh.a(localana);
    }
    AppMethodBeat.o(30963);
    return localaml;
  }
  
  public static boolean b(cz paramcz, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(30942);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    anb localanb = new anb();
    anh localanh = new anh();
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(paramInt);
    localanh.MA(Util.nowMilliSecond());
    localanb.a(localanh);
    paramcz.dFZ.desc = paramString;
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static String bdo(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = FilePathGenerator.genPath(com.tencent.mm.plugin.record.b.aTb(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30952);
      return null;
    }
    if (new com.tencent.mm.vfs.o(paramString).exists())
    {
      AppMethodBeat.o(30952);
      return paramString;
    }
    AppMethodBeat.o(30952);
    return paramString;
  }
  
  private static boolean c(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30957);
    anb localanb = new anb();
    Object localObject1 = aR(paramca);
    localanb.a((anh)localObject1);
    try
    {
      com.tencent.mm.ag.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
      Object localObject2 = localu.iAd;
      ((anh)localObject1).bhn(localu.eag);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcz.dFZ.dGd))
      {
        Log.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcz.dFZ.dGd) });
        v localv = (v)((List)localObject2).get(paramcz.dFZ.dGd);
        if (m.HF(localv.iAt))
        {
          paramcz.dFZ.dGe = 2131759217;
          AppMethodBeat.o(30957);
          return false;
        }
        ((anh)localObject1).bhm(localv.url);
        if (paramcz.dFZ.dGd > 0) {
          ((anh)localObject1).bhh("");
        }
        aml localaml = new aml();
        localaml.bgf(localv.title);
        localaml.bgg(localv.iAq);
        a(localaml, paramca);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          paramca = com.tencent.mm.aj.p.aYB().Mx(paramca.field_talker);
          localObject1 = localObject2;
          if (paramca != null) {
            localObject1 = paramca.aYt();
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localaml.bgu(s.bdu((String)localObject1));
          localaml.At(false);
          if ((Util.isNullOrNil(localaml.LvN)) || (!com.tencent.mm.vfs.s.YS(localaml.LvN)))
          {
            localaml.bgo((String)localObject1);
            localaml.At(true);
          }
        }
        for (;;)
        {
          localaml.As(true);
          localaml.ajd(5);
          localanb.ppH.add(localaml);
          paramcz.dFZ.dGb = localanb;
          paramcz.dFZ.desc = localv.title;
          paramcz.dFZ.type = 5;
          paramca = new anq();
          paramca.bhv((String)localObject1);
          paramca.bhs(localv.title);
          paramca.bht(localv.iAq);
          localanb.b(paramca);
          localanb.f(m.a(localv, paramca, localu.eag, localu.eah));
          AppMethodBeat.o(30957);
          return true;
          localaml.At(true);
        }
      }
      return false;
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.GetFavDataSource", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean d(cz paramcz, ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramcz == null) || (paramca == null))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    paramca = ca.aZ(paramca);
    if (paramca.isText()) {
      bool = e(paramcz, paramca);
    }
    for (;;)
    {
      paramcz.dFZ.dFN = paramca.field_content;
      if ((bool) || (paramcz.dFZ.dGe == 0)) {
        com.tencent.mm.plugin.fav.ui.e.a(paramca, paramcz, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (paramca.gAy())
      {
        bool = g(paramcz, paramca);
      }
      else if (paramca.dOS())
      {
        bool = a(paramcz, paramca);
      }
      else if (paramca.gAz())
      {
        bool = f(paramcz, paramca);
      }
      else if ((paramca.cWJ()) || (paramca.cWL()))
      {
        bool = i(paramcz, paramca);
      }
      else if (paramca.cWK())
      {
        bool = h(paramcz, paramca);
      }
      else if (paramca.gAt())
      {
        bool = c(paramcz, paramca);
      }
      else
      {
        if (paramca.gDl()) {}
        while ((!paramca.dOQ()) || (paramca.gDo()))
        {
          paramcz.dFZ.dGe = 2131759217;
          break;
        }
        bool = j(paramcz, paramca);
      }
    }
  }
  
  private static boolean e(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30947);
    anb localanb = new anb();
    localanb.a(aR(paramca));
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.desc = paramca.field_content;
    paramcz.dFZ.type = 1;
    if (com.tencent.mm.ui.tools.f.bnP(paramcz.dFZ.desc) > com.tencent.mm.n.c.aql())
    {
      paramcz.dFZ.dGe = 2131759348;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean f(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (paramca.field_msgId > 0L) {
      localObject1 = q.bcR().H(paramca.field_talker, paramca.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramca.field_msgSvrId > 0L) {
        localObject2 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcz.dFZ.dGe = 2131759215;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new anb();
    ((anb)localObject1).a(aR(paramca));
    aml localaml = new aml();
    a(localaml, paramca);
    localaml.ajd(2);
    localaml.bgt(q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", ""));
    if (((com.tencent.mm.av.g)localObject2).bcv())
    {
      localObject2 = q.bcR().tl(((com.tencent.mm.av.g)localObject2).iXx);
      if (((com.tencent.mm.av.g)localObject2).iKP > ((com.tencent.mm.av.g)localObject2).offset) {
        localaml.bgt(q.bcR().o("SERVERID://" + paramca.field_msgSvrId, "", ""));
      }
    }
    localaml.bgu(q.bcR().R(paramca.field_imgPath, true));
    localaml.bgN(br.KB(paramca.fqK));
    paramca = new LinkedList();
    paramca.add(localaml);
    ((anb)localObject1).bH(paramca);
    paramcz.dFZ.dGb = ((anb)localObject1);
    paramcz.dFZ.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean g(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30951);
    anb localanb = new anb();
    localanb.a(aR(paramca));
    aml localaml = new aml();
    a(localaml, paramca);
    if (ab.Jp(paramca.field_talker)) {
      localaml.bgt(bdo(paramca.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localaml.ajd(3);
      localaml.At(true);
      localb = com.tencent.mm.modelvoice.s.Rf(paramca.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localaml.bgt(com.tencent.mm.modelvoice.s.getFullPath(paramca.field_imgPath));
    }
    localaml.bgp(ahD(localb.getFormat()));
    localaml.ajc((int)new com.tencent.mm.modelvoice.p(paramca.field_content).time);
    paramca = new LinkedList();
    paramca.add(localaml);
    localanb.bH(paramca);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean h(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.aD(paramca.field_content, paramca.field_reserved);
    if (localObject == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    anb localanb = new anb();
    localanb.a(aR(paramca));
    aml localaml = new aml();
    a(localaml, paramca);
    com.tencent.mm.modelvideo.o.bhj();
    localaml.bgu(t.Qx(paramca.field_imgPath));
    localaml.bgp(com.tencent.mm.vfs.s.akC(localaml.LvL));
    localaml.bgt("");
    localaml.bgo(((k.b)localObject).thumburl);
    amt localamt = m.v(paramca);
    if (localamt == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localaml.ajc(localamt.duration);
    localaml.bgf(((k.b)localObject).title);
    localaml.bgl(((k.b)localObject).url);
    localaml.As(true);
    localaml.At(true);
    localObject = new amm();
    if (paramca.cWK()) {
      ((amm)localObject).e(localamt);
    }
    localaml.a((amm)localObject);
    paramca = new LinkedList();
    paramca.add(localaml);
    localanb.bH(paramca);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 4;
    localaml.ajd(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean i(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30954);
    anb localanb = new anb();
    localanb.a(aR(paramca));
    aml localaml = new aml();
    a(localaml, paramca);
    com.tencent.mm.modelvideo.o.bhj();
    localaml.bgu(t.Qx(paramca.field_imgPath));
    localaml.bgp(com.tencent.mm.vfs.s.akC(localaml.LvL));
    if (paramca.cWL())
    {
      paramcz.dFZ.type = 16;
      localaml.ajd(15);
    }
    Object localObject;
    for (;;)
    {
      localObject = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcz.dFZ.dGe = 2131759208;
      AppMethodBeat.o(30954);
      return false;
      paramcz.dFZ.type = 4;
      localaml.ajd(4);
    }
    Log.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).iKP) });
    if (((com.tencent.mm.modelvideo.s)localObject).iKP > ((af)com.tencent.mm.kernel.g.ah(af.class)).getVideoSizeLimit(true))
    {
      paramcz.dFZ.dGe = 2131759351;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((paramca.cWL()) && (com.tencent.mm.modelvideo.u.QO(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcz.dFZ.dGe = 2131759208;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).bhy())
    {
      com.tencent.mm.modelvideo.o.bhj();
      String str = t.Qw(paramca.field_imgPath);
      Log.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localaml.bgt(str);
    }
    for (;;)
    {
      localaml.ajc(((com.tencent.mm.modelvideo.s)localObject).iFw);
      localaml.bgN(br.KB(paramca.fqK));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localaml);
      localanb.bH((LinkedList)localObject);
      paramcz.dFZ.dGb = localanb;
      paramcz = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
      localaml.bgD(paramcz.ean);
      paramcz = paramcz.jsw;
      if ((paramcz != null) && (!Util.isNullOrNil(paramcz.izf)))
      {
        paramca = new amo();
        paramca.iyZ = paramcz.iyZ;
        paramca.LxJ = paramcz.LxJ;
        paramca.izc = paramcz.izc;
        paramca.izd = paramcz.izd;
        paramca.izb = paramcz.izb;
        paramca.ize = paramcz.ize;
        paramca.izf = paramcz.izf;
        paramca.izg = paramcz.izg;
        localaml.a(paramca);
      }
      AppMethodBeat.o(30954);
      return true;
      Log.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localaml.bgt("");
    }
  }
  
  private static boolean j(cz paramcz, ca paramca)
  {
    AppMethodBeat.i(30956);
    anb localanb = new anb();
    localanb.a(aR(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.HD((String)localObject1);
    if (localObject1 == null)
    {
      paramcz.dFZ.dGe = 2131759219;
      AppMethodBeat.o(30956);
      return false;
    }
    paramcz.dFZ.dGb = localanb;
    Object localObject2 = localanb.Lya;
    ((anh)localObject2).bhl(((k.b)localObject1).appId);
    ((anh)localObject2).bhn(((k.b)localObject1).eag);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramcz.dFZ.dGe = 2131759217;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramcz.dFZ.dGb = localanb;
      paramcz.dFZ.desc = ((k.b)localObject1).title;
      paramcz.dFZ.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.r.a.cgO().bdx(((k.b)localObject1).dCK);
      localObject2 = new aml();
      a((aml)localObject2, paramca);
      if (localObject3 != null) {
        ((aml)localObject2).bgt(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = q.bcR().R(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.s.YS((String)localObject3)) {
        ((aml)localObject2).bgu((String)localObject3);
      }
      ((aml)localObject2).ajd(2);
      ((aml)localObject2).bgf(((k.b)localObject1).title);
      ((aml)localObject2).bgg(((k.b)localObject1).description);
      ((aml)localObject2).bgN(br.KB(paramca.fqK));
      localanb.ppH.add(localObject2);
      paramcz.dFZ.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      a(false, paramca, (k.b)localObject1, paramcz, localanb);
      AppMethodBeat.o(30956);
      return true;
    case 76: 
      a(true, paramca, (k.b)localObject1, paramcz, localanb);
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(paramca, (k.b)localObject1, 4);
      localanb.bhd(((aml)localObject1).title);
      localanb.bhe(((aml)localObject1).desc);
      ((aml)localObject1).bgN(br.KB(paramca.fqK));
      localanb.ppH.add(localObject1);
      paramcz.dFZ.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localanb.Lya.bhm(((k.b)localObject1).url);
        localObject2 = new anq();
        ((anq)localObject2).bhv(((k.b)localObject1).thumburl);
        localObject3 = (aj)((k.b)localObject1).as(aj.class);
        if ((localObject3 != null) && (!Util.isNullOrNil(((aj)localObject3).IEy)))
        {
          localObject4 = new StringBuilder();
          ((aj)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((anq)localObject2).bhx(((StringBuilder)localObject4).toString());
        }
        localanb.b((anq)localObject2);
        a(paramca, localanb, (anq)localObject2);
        paramca = a(paramca, (k.b)localObject1, 5);
        localanb.ppH.add(paramca);
        localanb.bhd(paramca.title);
        localanb.bhe(paramca.desc);
        paramcz.dFZ.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramcz.dFZ.dGe = 2131759213;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      paramca = (com.tencent.mm.plugin.i.a.f)((k.b)localObject1).as(com.tencent.mm.plugin.i.a.f.class);
      if (paramca != null)
      {
        paramca = paramca.jlg;
        localanb.bhd(paramca.nickname + MMApplicationContext.getContext().getString(2131759333));
        localanb.bhe(paramca.desc);
        localanb.d(paramca);
        paramcz.dFZ.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759225;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.r.a.cgO().bdx(((k.b)localObject1).dCK);
      localObject2 = new aml();
      if (localObject3 != null) {
        ((aml)localObject2).bgt(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((aml)localObject2, paramca);
      ((aml)localObject2).ajd(8);
      ((aml)localObject2).bgp(((k.b)localObject1).iwJ);
      paramca = q.bcR().R(paramca.field_imgPath, true);
      if (Util.isNullOrNil(paramca)) {
        ((aml)localObject2).At(true);
      }
      if (com.tencent.mm.vfs.s.YS(paramca)) {
        ((aml)localObject2).bgu(paramca);
      }
      ((aml)localObject2).bgf(((k.b)localObject1).title);
      ((aml)localObject2).bgg(((k.b)localObject1).description);
      localanb.ppH.add(localObject2);
      paramcz.dFZ.desc = ((k.b)localObject1).title;
      paramcz.dFZ.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).dCK == null) || (((k.b)localObject1).dCK.length() == 0)) {
        paramcz.dFZ.dGe = 2131759210;
      }
      while (com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramcz.dFZ.dGe = 2131759217;
        AppMethodBeat.o(30956);
        return false;
      }
      paramcz.dFZ.dGe = 2131759225;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      paramca = new ana();
      paramca.bgY(((k.b)localObject1).title);
      paramca.bgZ(((k.b)localObject1).description);
      paramca.ajj(((k.b)localObject1).ixg);
      paramca.bhb(((k.b)localObject1).ixh);
      paramca.bha(((k.b)localObject1).thumburl);
      paramcz.dFZ.title = ((k.b)localObject1).title;
      paramcz.dFZ.desc = ((k.b)localObject1).description;
      paramcz.dFZ.type = 10;
      localanb.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      paramca = new ank();
      paramca.bho(((k.b)localObject1).title);
      paramca.bhp(((k.b)localObject1).description);
      paramca.bhr(((k.b)localObject1).ixk);
      paramca.bhq(((k.b)localObject1).thumburl);
      paramcz.dFZ.title = ((k.b)localObject1).title;
      paramcz.dFZ.desc = ((k.b)localObject1).description;
      paramcz.dFZ.type = 15;
      localanb.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      paramca = new ana();
      paramca.bgY(((k.b)localObject1).title);
      paramca.bgZ(((k.b)localObject1).description);
      paramca.ajj(((k.b)localObject1).ixm);
      paramca.bhb(((k.b)localObject1).ixn);
      paramca.bha(((k.b)localObject1).thumburl);
      paramcz.dFZ.title = ((k.b)localObject1).title;
      paramcz.dFZ.desc = ((k.b)localObject1).description;
      paramcz.dFZ.type = 11;
      localanb.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramcz.dFZ.dGc = new anp();
      bool = a(paramcz, (k.b)localObject1, localanb, paramca, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramcz.dFZ.dGc = new anp();
      bool = a(paramcz, (k.b)localObject1, localanb, paramca, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new amj();
    ((amj)localObject3).username = ((k.b)localObject1).izi;
    ((amj)localObject3).appId = ((k.b)localObject1).izj;
    ((amj)localObject3).dMe = ((k.b)localObject1).izz;
    ((amj)localObject3).iconUrl = ((k.b)localObject1).izB;
    ((amj)localObject3).dCx = ((k.b)localObject1).izh;
    ((amj)localObject3).Lve = ((k.b)localObject1).eah;
    ((amj)localObject3).lyE = ((k.b)localObject1).izr;
    ((amj)localObject3).type = ((k.b)localObject1).izk;
    Object localObject4 = (com.tencent.mm.ag.a)((k.b)localObject1).as(com.tencent.mm.ag.a.class);
    if (localObject4 != null)
    {
      ((amj)localObject3).leb = ((com.tencent.mm.ag.a)localObject4).ivc;
      ((amj)localObject3).eda = ((com.tencent.mm.ag.a)localObject4).ive;
      ((amj)localObject3).subType = ((com.tencent.mm.ag.a)localObject4).ivf;
    }
    ((amj)localObject3).version = ((k.b)localObject1).izA;
    localObject4 = new aml();
    a((aml)localObject4, paramca);
    ((aml)localObject4).ajd(19);
    String str = q.bcR().R(paramca.field_imgPath, true);
    if (Util.isNullOrNil(str)) {
      ((aml)localObject4).At(true);
    }
    if (com.tencent.mm.vfs.s.YS(str)) {
      ((aml)localObject4).bgu(str);
    }
    ((aml)localObject4).bgf(((k.b)localObject1).title);
    ((aml)localObject4).bgg(((k.b)localObject1).description);
    localanb.ppH.add(localObject4);
    localanb.bhd(((k.b)localObject1).title);
    if (ab.Eq(paramca.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((anh)localObject2).ajm(i);
      paramcz.dFZ.title = ((k.b)localObject1).title;
      paramcz.dFZ.desc = ((k.b)localObject1).description;
      paramcz.dFZ.type = 19;
      localanb.c((amj)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static amn q(aml paramaml)
  {
    AppMethodBeat.i(30960);
    amn localamn = new amn();
    paramaml = paramaml.Lwh.LwO;
    if (paramaml.Lxx) {
      localamn.bgO(paramaml.dRL);
    }
    if (paramaml.Lxy) {
      localamn.bgP(paramaml.toUser);
    }
    if (paramaml.LxB) {
      localamn.bgR(paramaml.LxA);
    }
    localamn.ajh(1);
    localamn.Mx(Util.nowMilliSecond());
    AppMethodBeat.o(30960);
    return localamn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.h
 * JD-Core Version:    0.7.0.1
 */