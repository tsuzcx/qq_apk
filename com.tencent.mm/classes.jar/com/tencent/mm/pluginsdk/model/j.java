package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.v;
import com.tencent.mm.am.k;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.b;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j
{
  private static anm a(anm paramanm, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    anm localanm = new anm();
    ann localann = new ann();
    localann.c(q(paramanm));
    localann.d(paramanm.SyG.PTL);
    localanm.a(localann);
    localanm.bsS(paramanm.SyI);
    localanm.bsT(paramanm.SyK);
    localanm.btb(paramanm.Szh);
    localanm.btc(paramanm.Szj);
    localanm.Ey(true);
    localanm.Ex(true);
    localanm.bsU(paramanm.SyO);
    localanm.ars(paramanm.SyU);
    localanm.bsI(paramanm.Sye);
    localanm.bsJ(paramanm.Syg);
    localanm.TY(paramanm.Syi);
    localanm.bsN(paramanm.Kll);
    localanm.bsO(paramanm.Syq);
    localanm.TZ(paramanm.Sys);
    if (paramBoolean) {
      localanm.bsK(paramanm.fEa);
    }
    AppMethodBeat.o(30961);
    return localanm;
  }
  
  private static anm a(ca paramca, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    anm localanm = new anm();
    a(localanm, paramca);
    localanm.bsE(paramb.lms);
    localanm.bsF(paramb.lmt);
    localanm.bsD(paramb.url);
    localanm.Ex(true);
    paramca = new com.tencent.mm.vfs.q(Util.nullAs(com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true), ""));
    if (paramca.ifE()) {
      localanm.bsM(paramca.bOF());
    }
    for (;;)
    {
      localanm.bsx(paramb.title);
      localanm.bsy(paramb.description);
      localanm.bsW(paramb.canvasPageXml);
      localanm.arq(paramInt);
      localanm.bsV(paramb.fUk);
      paramca = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (paramca != null)
      {
        localanm.btd(paramca.songAlbumUrl);
        localanm.bte(paramca.songLyric);
        if (paramInt == 29)
        {
          paramb = new ann();
          dbr localdbr = new dbr();
          localdbr.Ruu = paramca.Ruu;
          localdbr.Ruv = paramca.Ruv;
          localdbr.Ruw = paramca.Ruw;
          localdbr.Rux = paramca.Rux;
          localdbr.singerName = paramca.Ruy;
          localdbr.albumName = paramca.Ruz;
          localdbr.musicGenre = paramca.RuA;
          localdbr.issueDate = Util.safeParseLong(paramca.RuB);
          localdbr.identification = paramca.RuC;
          localdbr.FSG = paramca.FSG;
          localdbr.extraInfo = paramca.RuD;
          paramb.e(localdbr);
          localanm.a(paramb);
        }
      }
      AppMethodBeat.o(30955);
      return localanm;
      localanm.Ey(true);
    }
  }
  
  private static void a(anm paramanm1, anm paramanm2)
  {
    AppMethodBeat.i(30962);
    paramanm1.bsE(paramanm2.SxW);
    paramanm1.bsF(paramanm2.SxY);
    paramanm1.bsD(paramanm2.SxU);
    paramanm1.bsx(paramanm2.title);
    paramanm1.bsy(paramanm2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(anm paramanm, ca paramca)
  {
    AppMethodBeat.i(30950);
    if (paramca.field_isSend == 1)
    {
      if ((ab.Lj(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
      {
        paramanm.bsP(String.valueOf(paramca.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramanm.bsP(paramca.field_talker + "#" + String.valueOf(paramca.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramanm.bsP(String.valueOf(paramca.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(ca paramca, aoc paramaoc, aor paramaor)
  {
    AppMethodBeat.i(30958);
    paramaoc.f(m.a(paramca, paramaor));
    AppMethodBeat.o(30958);
  }
  
  private static void a(boolean paramBoolean, ca paramca, k.b paramb, dd paramdd, aoc paramaoc)
  {
    AppMethodBeat.i(282983);
    int i;
    if (paramBoolean) {
      i = 29;
    }
    for (int j = 21;; j = 7)
    {
      paramca = a(paramca, paramb, i);
      paramaoc.syG.add(paramca);
      paramdd.fyI.type = j;
      AppMethodBeat.o(282983);
      return;
      i = 7;
    }
  }
  
  public static boolean a(dd paramdd, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramdd == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdd != null) {
        paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localanm.arq(2);
    localanm.bsL(paramString);
    localanm.bsK(com.tencent.mm.b.g.getMessageDigest((localanm.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new hi();
    ((hi)localObject).fEb.type = 27;
    ((hi)localObject).fEb.fEd = localanm;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((hi)localObject).fEc.thumbPath;
    BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
    localanm.bsM((String)localObject);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(paramInt);
    localaoi.Ue(Util.nowMilliSecond());
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    paramdd.fyI.title = localanm.title;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(dd paramdd, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(282973);
    if ((paramdd == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdd != null) {
        paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(282973);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt1) });
    if (new com.tencent.mm.vfs.q(paramString1).length() > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimit(paramBoolean))
    {
      paramdd.fyI.fyO = R.l.favorite_too_large_format;
      AppMethodBeat.o(282973);
      return false;
    }
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localanm.bsL(paramString1);
    localanm.arq(4);
    localanm.bsH(com.tencent.mm.vfs.u.asq(paramString1));
    localanm.bsM(paramString2);
    localanm.arp(paramInt2);
    localanm.bsx(paramString3);
    localanm.bsy(paramString4);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(paramInt1);
    localaoi.Ue(Util.nowMilliSecond());
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    paramdd.fyI.title = localanm.title;
    paramdd.fyI.desc = localanm.title;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 4;
    AppMethodBeat.o(282973);
    return true;
  }
  
  public static boolean a(dd paramdd, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(282974);
    if ((paramdd == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdd != null) {
        paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(282974);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.q(paramString1).length() > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFileSizeLimit(paramBoolean))
    {
      paramdd.fyI.fyO = R.l.favorite_too_large_format;
      AppMethodBeat.o(282974);
      return false;
    }
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localanm.bsL(paramString1);
    localanm.arq(8);
    localanm.bsH(com.tencent.mm.vfs.u.asq(paramString1));
    localanm.Ey(true);
    localanm.bsx(paramString2);
    localanm.bsy(paramString3);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(paramInt);
    localaoi.Ue(Util.nowMilliSecond());
    localaoc.a(localaoi);
    localaoc.syG.add(localanm);
    paramdd.fyI.title = localanm.title;
    paramdd.fyI.desc = localanm.title;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 8;
    AppMethodBeat.o(282974);
    return true;
  }
  
  public static boolean a(dd paramdd, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = d(paramdd, ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(dd paramdd, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramdd == null)
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
    paramIntent = new ant();
    paramIntent.bto((String)localObject1);
    paramIntent.E(d1);
    paramIntent.D(d2);
    paramIntent.arv(i);
    paramIntent.btp((String)localObject2);
    localObject1 = new aoc();
    localObject2 = new aoi();
    String str = z.bcZ();
    ((aoi)localObject2).btx(str);
    ((aoi)localObject2).bty(str);
    ((aoi)localObject2).arz(6);
    ((aoi)localObject2).Ue(Util.nowMilliSecond());
    ((aoc)localObject1).d(paramIntent);
    ((aoc)localObject1).a((aoi)localObject2);
    paramdd.fyI.fyK = ((aoc)localObject1);
    paramdd.fyI.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(dd paramdd, k.b paramb, aoc paramaoc, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new sc();
    ((sc)localObject).fRw.type = 0;
    ((sc)localObject).fRw.fRy = paramb.lmA;
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((sc)localObject).fRx.fRG;
    if (localc == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30959);
      return false;
    }
    paramaoc.btv(localc.title);
    Iterator localIterator = localc.lpz.iterator();
    int i = 0;
    anm localanm;
    if (localIterator.hasNext())
    {
      localanm = (anm)localIterator.next();
      switch (localanm.dataType)
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
            if ((ab.Lj(paramca.field_talker)) || (paramca.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
              label335:
              paramb.bsP((String)localObject);
              paramb.btf(localanm.mic);
              paramaoc.syG.add(paramb);
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
      paramb = a(localanm, paramBoolean);
      paramb.arq(3);
      if (!Util.isNullOrNil(localanm.SyO))
      {
        localObject = new sc();
        ((sc)localObject).fRw.type = 1;
        ((sc)localObject).fRw.fDI = localanm;
        ((sc)localObject).fRw.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.bsL(((sc)localObject).fRx.dataPath);
        paramb.arp(localanm.duration);
        paramb.Ey(true);
        paramb.Ex(false);
        paramb.bsH(localanm.Syc);
      }
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAR += 1;
      break label270;
      paramb = a(localanm, paramBoolean);
      paramb.arq(1);
      paramb.bsy(localanm.desc);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAQ += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      paramb.arq(2);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.bsL(((sc)localObject).fRx.dataPath);
      paramb.bsM(((sc)localObject).fRx.thumbPath);
      paramb.Ey(false);
      paramb.Ex(false);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).JCD += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      a(paramb, localanm);
      paramb.arq(5);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.bsM(((sc)localObject).fRx.thumbPath);
      paramb.Ey(false);
      if ((localanm.SyG != null) && (localanm.SyG.Szr != null))
      {
        localObject = new aor();
        ((aor)localObject).btK(localanm.SyG.Szr.title);
        ((aor)localObject).btL(localanm.SyG.Szr.desc);
        ((aor)localObject).btN(localanm.SyG.Szr.thumbUrl);
        ((aor)localObject).arA(localanm.SyG.Szr.SBe);
        ((aor)localObject).btM(localanm.SyG.Szr.SBc);
        ((aor)localObject).arC(localanm.SyG.Szr.mjT);
        paramb.SyG.b((aor)localObject);
      }
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAS += 1;
      break label270;
      paramb = a(localanm, paramBoolean);
      paramb.bsx(localanm.title);
      paramb.bsy(localanm.desc);
      paramb.SyG.c(localanm.SyG.SzJ);
      paramb.arq(22);
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      a(paramb, localanm);
      if (localanm.dataType == 15) {
        paramb.arq(15);
      }
      for (;;)
      {
        localObject = new sc();
        ((sc)localObject).fRw.type = 1;
        ((sc)localObject).fRw.fDI = localanm;
        ((sc)localObject).fRw.msgId = l;
        EventCenter.instance.publish((IEvent)localObject);
        if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.Ex(false);
        paramb.bsL(((sc)localObject).fRx.dataPath);
        paramb.a(localanm.SyG);
        paramb.Ey(false);
        paramb.bsM(((sc)localObject).fRx.thumbPath);
        paramb.arp(localanm.duration);
        localObject = paramdd.fyI.fyL;
        ((aoq)localObject).xzT += 1;
        break;
        paramb.arq(4);
      }
      paramb = a(localanm, paramBoolean);
      paramb.arq(6);
      if ((localanm.SyG != null) && (localanm.SyG.Szp != null))
      {
        localObject = new ant();
        ((ant)localObject).bto(localanm.SyG.Szp.label);
        ((ant)localObject).E(localanm.SyG.Szp.lat);
        ((ant)localObject).D(localanm.SyG.Szp.lng);
        ((ant)localObject).arv(localanm.SyG.Szp.fKJ);
        ((ant)localObject).btp(localanm.SyG.Szp.fPN);
        paramb.SyG.c((ant)localObject);
      }
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAT += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      a(paramb, localanm);
      paramb.btd(localanm.songAlbumUrl);
      paramb.bte(localanm.songLyric);
      paramb.arq(7);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bsM(((sc)localObject).fRx.thumbPath);
      paramb.Ey(false);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAU += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      a(paramb, localanm);
      if ((localanm != null) && (localanm.SyG != null)) {
        paramb.SyG.e(localanm.SyG.SzR);
      }
      paramb.btd(localanm.songAlbumUrl);
      paramb.bte(localanm.songLyric);
      paramb.arq(29);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bsM(((sc)localObject).fRx.thumbPath);
      paramb.Ey(false);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAU += 1;
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      a(paramb, localanm);
      paramb.arq(8);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if ((Util.isNullOrNil(((sc)localObject).fRx.dataPath)) && (Util.isNullOrNil(((sc)localObject).fRx.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.bsL(((sc)localObject).fRx.dataPath);
      paramb.bsM(((sc)localObject).fRx.thumbPath);
      paramb.Ex(false);
      paramb.bsH(localanm.Syc);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).fileCount += 1;
      break label270;
      paramb = b(localanm, localanm.dataType, paramBoolean);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAW += 1;
      break label270;
      paramb = b(localanm, localanm.dataType, paramBoolean);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SAX += 1;
      break label270;
      paramb = a(localanm, paramBoolean);
      paramb.arq(14);
      if ((localanm.SyG != null) && (localanm.SyG.Szv != null))
      {
        localObject = new aol();
        ((aol)localObject).btG(localanm.SyG.Szv.title);
        ((aol)localObject).btH(localanm.SyG.Szv.desc);
        ((aol)localObject).btJ(localanm.SyG.Szv.fTp);
        ((aol)localObject).btI(localanm.SyG.Szv.thumbUrl);
        paramb.SyG.a((aol)localObject);
      }
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SBa += 1;
      break label270;
      paramb = a(localanm, paramBoolean);
      paramb.arq(16);
      paramb.bsy(localanm.desc);
      localObject = paramdd.fyI.fyL;
      ((aoq)localObject).SBb += 1;
      break label270;
      paramb = a(localanm, paramBoolean);
      paramb.bsx(localanm.title);
      paramb.bsy(localanm.desc);
      paramb.arq(17);
      paramb.bsX(localanm.SyW);
      break label270;
      l = paramca.field_msgId;
      paramb = a(localanm, paramBoolean);
      paramb.bsx(localanm.title);
      paramb.bsy(localanm.desc);
      paramb.arq(19);
      localObject = new sc();
      ((sc)localObject).fRw.type = 1;
      ((sc)localObject).fRw.fDI = localanm;
      ((sc)localObject).fRw.msgId = l;
      EventCenter.instance.publish((IEvent)localObject);
      if (Util.isNullOrNil(((sc)localObject).fRx.thumbPath)) {
        Log.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localanm.SyG != null) && (localanm.SyG.SzE != null))
        {
          localObject = new ank();
          ((ank)localObject).username = localanm.SyG.SzE.username;
          ((ank)localObject).appId = localanm.SyG.SzE.appId;
          ((ank)localObject).fES = localanm.SyG.SzE.fES;
          ((ank)localObject).iconUrl = localanm.SyG.SzE.iconUrl;
          ((ank)localObject).type = localanm.SyG.SzE.type;
          ((ank)localObject).fve = localanm.SyG.SzE.fve;
          ((ank)localObject).SxE = localanm.SyG.SzE.SxE;
          ((ank)localObject).version = localanm.SyG.SzE.version;
          ((ank)localObject).nYp = localanm.SyG.SzE.nYp;
          ((ank)localObject).otE = localanm.SyG.SzE.otE;
          ((ank)localObject).fXg = localanm.SyG.SzE.fXg;
          paramb.SyG.b((ank)localObject);
        }
        break;
        paramb.Ey(false);
        paramb.bsM(((sc)localObject).fRx.thumbPath);
      }
      paramb = a(localanm, paramBoolean);
      paramb.arq(20);
      paramb.arp(localanm.duration);
      break label270;
      localObject = String.format("%s#%d$%d", new Object[] { paramca.field_talker, Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
      break label335;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramca.field_msgSvrId), Integer.valueOf(i) });
      break label335;
      if (l.j((anm)localc.lpz.get(0))) {}
      for (paramdd.fyI.type = 18;; paramdd.fyI.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30949);
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    paramca = XmlParser.parseXml(paramca.field_content, "msg", null);
    if (paramca != null) {
      try
      {
        ant localant = new ant();
        localant.bto((String)paramca.get(".msg.location.$label"));
        localant.E(Double.parseDouble((String)paramca.get(".msg.location.$x")));
        localant.D(Double.parseDouble((String)paramca.get(".msg.location.$y")));
        localant.arv(Integer.valueOf((String)paramca.get(".msg.location.$scale")).intValue());
        localant.btp((String)paramca.get(".msg.location.$poiname"));
        localaoc.d(localant);
        paramdd.fyI.type = 6;
        paramdd.fyI.fyK = localaoc;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception paramca)
      {
        Log.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { paramca.getStackTrace().toString() });
      }
    }
    paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static String apC(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static anm b(anm paramanm, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    anm localanm = a(paramanm, paramBoolean);
    localanm.arq(paramInt);
    if ((paramanm.SyG != null) && (paramanm.SyG.Szt != null))
    {
      aob localaob = new aob();
      localaob.btq(paramanm.SyG.Szt.title);
      localaob.btr(paramanm.SyG.Szt.desc);
      localaob.arw(paramanm.SyG.Szt.type);
      localaob.btt(paramanm.SyG.Szt.fTp);
      localaob.bts(paramanm.SyG.Szt.thumbUrl);
      localanm.SyG.a(localaob);
    }
    AppMethodBeat.o(30963);
    return localanm;
  }
  
  public static boolean b(dd paramdd, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      AppMethodBeat.o(30942);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(paramInt);
    localaoi.Ue(Util.nowMilliSecond());
    localaoc.a(localaoi);
    paramdd.fyI.desc = paramString;
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static aoi bf(ca paramca)
  {
    AppMethodBeat.i(30946);
    aoi localaoi = new aoi();
    if (paramca.field_isSend == 1)
    {
      localaoi.btx(z.bcZ());
      localaoi.bty(paramca.field_talker);
      if (ab.Lj(paramca.field_talker)) {
        localaoi.btA(localaoi.fLi);
      }
    }
    do
    {
      localaoi.arz(1);
      localaoi.Ue(paramca.field_createTime);
      localaoi.btB(paramca.field_msgSvrId);
      if (paramca.field_msgSvrId > 0L) {
        localaoi.btz(paramca.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localaoi;
      localaoi.btx(paramca.field_talker);
      localaoi.bty(z.bcZ());
    } while (!ab.Lj(paramca.field_talker));
    if (paramca.field_content != null) {}
    for (String str = paramca.field_content.substring(0, Math.max(0, paramca.field_content.indexOf(':')));; str = "")
    {
      localaoi.btA(str);
      if ((Util.isNullOrNil(localaoi.SAb)) || (paramca.hwF())) {
        break;
      }
      paramca.setContent(paramca.field_content.substring(localaoi.SAb.length() + 1));
      if ((paramca.field_content.length() > 0) && ('\n' == paramca.field_content.charAt(0))) {
        paramca.setContent(paramca.field_content.substring(1));
      }
      if (!paramca.hzO()) {
        break;
      }
      if ((!Util.isNullOrNil(paramca.field_transContent)) && (paramca.field_transContent.startsWith(localaoi.SAb))) {
        paramca.Jp(paramca.field_transContent.substring(localaoi.SAb.length() + 1));
      }
      if ((paramca.field_transContent.length() <= 0) || ('\n' != paramca.field_transContent.charAt(0))) {
        break;
      }
      paramca.Jp(paramca.field_transContent.substring(1));
      break;
    }
  }
  
  private static String bpE(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = FilePathGenerator.genPath(com.tencent.mm.plugin.record.c.bbZ(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30952);
      return null;
    }
    if (new com.tencent.mm.vfs.q(paramString).ifE())
    {
      AppMethodBeat.o(30952);
      return paramString;
    }
    AppMethodBeat.o(30952);
    return paramString;
  }
  
  private static boolean c(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30957);
    aoc localaoc = new aoc();
    Object localObject1 = bf(paramca);
    localaoc.a((aoi)localObject1);
    try
    {
      com.tencent.mm.aj.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
      Object localObject2 = localu.lpz;
      ((aoi)localObject1).btF(localu.fUd);
      if ((localObject2 != null) && (((List)localObject2).size() > paramdd.fyI.fyM))
      {
        Log.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramdd.fyI.fyM) });
        v localv = (v)((List)localObject2).get(paramdd.fyI.fyM);
        if (m.OS(localv.lpP))
        {
          paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
          AppMethodBeat.o(30957);
          return false;
        }
        ((aoi)localObject1).btE(localv.url);
        if (paramdd.fyI.fyM > 0) {
          ((aoi)localObject1).btz("");
        }
        anm localanm = new anm();
        localanm.bsx(localv.title);
        localanm.bsy(localv.lpM);
        a(localanm, paramca);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          paramca = com.tencent.mm.am.q.bhP().TS(paramca.field_talker);
          localObject1 = localObject2;
          if (paramca != null) {
            localObject1 = paramca.bhH();
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localanm.bsM(w.bpO((String)localObject1));
          localanm.Ey(false);
          if ((Util.isNullOrNil(localanm.Syn)) || (!com.tencent.mm.vfs.u.agG(localanm.Syn)))
          {
            localanm.bsG((String)localObject1);
            localanm.Ey(true);
          }
        }
        for (;;)
        {
          localanm.Ex(true);
          localanm.arq(5);
          localaoc.syG.add(localanm);
          paramdd.fyI.fyK = localaoc;
          paramdd.fyI.desc = localv.title;
          paramdd.fyI.type = 5;
          paramca = new aor();
          paramca.btN((String)localObject1);
          paramca.btK(localv.title);
          paramca.btL(localv.lpM);
          localaoc.c(paramca);
          localaoc.f(m.a(localv, paramca, localu.fUd, localu.fUe));
          AppMethodBeat.o(30957);
          return true;
          localanm.Ey(true);
        }
      }
      return false;
    }
    catch (Exception paramca)
    {
      Log.printErrStackTrace("MicroMsg.GetFavDataSource", paramca, "", new Object[0]);
      Log.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { paramca.getLocalizedMessage() });
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean d(dd paramdd, ca paramca)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramdd == null) || (paramca == null))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    paramca = ca.bs(paramca);
    if (paramca.hwH()) {
      bool = e(paramdd, paramca);
    }
    for (;;)
    {
      paramdd.fyI.fyu = paramca.field_content;
      if ((bool) || (paramdd.fyI.fyO == 0)) {
        e.a(paramca, paramdd, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (paramca.hwF())
      {
        bool = g(paramdd, paramca);
      }
      else if (paramca.erm())
      {
        bool = a(paramdd, paramca);
      }
      else if (paramca.hwG())
      {
        bool = f(paramdd, paramca);
      }
      else if ((paramca.dlR()) || (paramca.dlT()))
      {
        bool = i(paramdd, paramca);
      }
      else if (paramca.dlS())
      {
        bool = h(paramdd, paramca);
      }
      else if (paramca.hwA())
      {
        bool = c(paramdd, paramca);
      }
      else
      {
        if (paramca.hzy()) {}
        while ((!paramca.erk()) || (paramca.hzC()))
        {
          paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
          break;
        }
        bool = j(paramdd, paramca);
      }
    }
  }
  
  private static boolean e(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30947);
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.desc = paramca.field_content;
    paramdd.fyI.type = 1;
    if (com.tencent.mm.ui.tools.g.bAB(paramdd.fyI.desc) > com.tencent.mm.n.c.awE())
    {
      paramdd.fyI.fyO = R.l.favorite_text_length_over_limit;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean f(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (paramca.field_msgId > 0L) {
      localObject1 = com.tencent.mm.ay.q.bmh().D(paramca.field_talker, paramca.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.ay.g)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramca.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.ay.q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramdd.fyI.fyO = R.l.favorite_fail_image_not_exists;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new aoc();
    ((aoc)localObject1).a(bf(paramca));
    anm localanm = new anm();
    a(localanm, paramca);
    localanm.arq(2);
    localanm.bsL(com.tencent.mm.ay.q.bmh().r(com.tencent.mm.ay.h.c((com.tencent.mm.ay.g)localObject2), "", ""));
    if (((com.tencent.mm.ay.g)localObject2).blK())
    {
      localObject2 = com.tencent.mm.ay.q.bmh().wl(((com.tencent.mm.ay.g)localObject2).lNR);
      if (((com.tencent.mm.ay.g)localObject2).lAW > ((com.tencent.mm.ay.g)localObject2).offset) {
        localanm.bsL(com.tencent.mm.ay.q.bmh().r("SERVERID://" + paramca.field_msgSvrId, "", ""));
      }
    }
    localanm.bsM(com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true));
    localanm.btf(bs.RU(paramca.hxy));
    paramca = new LinkedList();
    paramca.add(localanm);
    ((aoc)localObject1).cg(paramca);
    paramdd.fyI.fyK = ((aoc)localObject1);
    paramdd.fyI.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean g(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30951);
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    anm localanm = new anm();
    a(localanm, paramca);
    if (ab.QI(paramca.field_talker)) {
      localanm.bsL(bpE(paramca.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localanm.arq(3);
      localanm.Ey(true);
      localb = com.tencent.mm.modelvoice.s.YC(paramca.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localanm.bsL(com.tencent.mm.modelvoice.s.getFullPath(paramca.field_imgPath));
    }
    localanm.bsH(apC(localb.getFormat()));
    localanm.arp((int)new p(paramca.field_content).time);
    paramca = new LinkedList();
    paramca.add(localanm);
    localaoc.cg(paramca);
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean h(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.aG(paramca.field_content, paramca.field_reserved);
    if (localObject == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    anm localanm = new anm();
    a(localanm, paramca);
    com.tencent.mm.modelvideo.s.bqB();
    localanm.bsM(x.XU(paramca.field_imgPath));
    localanm.bsH(com.tencent.mm.vfs.u.asq(localanm.Syl));
    localanm.bsL("");
    localanm.bsG(((k.b)localObject).thumburl);
    anu localanu = m.x(paramca);
    if (localanu == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localanm.arp(localanu.duration);
    localanm.bsx(((k.b)localObject).title);
    localanm.bsD(((k.b)localObject).url);
    localanm.Ex(true);
    localanm.Ey(true);
    localObject = new ann();
    if (paramca.dlS()) {
      ((ann)localObject).e(localanu);
    }
    localanm.a((ann)localObject);
    paramca = new LinkedList();
    paramca.add(localanm);
    localaoc.cg(paramca);
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.type = 4;
    localanm.arq(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean i(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30954);
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    anm localanm = new anm();
    a(localanm, paramca);
    com.tencent.mm.modelvideo.s.bqB();
    localanm.bsM(x.XU(paramca.field_imgPath));
    localanm.bsH(com.tencent.mm.vfs.u.asq(localanm.Syl));
    if (paramca.dlT())
    {
      paramdd.fyI.type = 16;
      localanm.arq(15);
    }
    Object localObject;
    for (;;)
    {
      localObject = y.Yk(paramca.field_imgPath);
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramdd.fyI.fyO = R.l.favorite_fail;
      AppMethodBeat.o(30954);
      return false;
      paramdd.fyI.type = 4;
      localanm.arq(4);
    }
    Log.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.w)localObject).lAW) });
    if (((com.tencent.mm.modelvideo.w)localObject).lAW > ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getVideoSizeLimit(true))
    {
      paramdd.fyI.fyO = R.l.favorite_too_large_format;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((paramca.dlT()) && (y.Yl(((com.tencent.mm.modelvideo.w)localObject).getFileName())))
    {
      paramdd.fyI.fyO = R.l.favorite_fail;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.w)localObject).bqS())
    {
      com.tencent.mm.modelvideo.s.bqB();
      String str = x.XT(paramca.field_imgPath);
      Log.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localanm.bsL(str);
    }
    for (;;)
    {
      localanm.arp(((com.tencent.mm.modelvideo.w)localObject).lvw);
      localanm.btf(bs.RU(paramca.hxy));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localanm);
      localaoc.cg((LinkedList)localObject);
      paramdd.fyI.fyK = localaoc;
      paramdd = y.Yk(paramca.field_imgPath);
      localanm.bsV(paramdd.fUk);
      paramdd = paramdd.mhZ;
      if ((paramdd != null) && (!Util.isNullOrNil(paramdd.lox)))
      {
        paramca = new anp();
        paramca.lor = paramdd.lor;
        paramca.SAk = paramdd.SAk;
        paramca.lou = paramdd.lou;
        paramca.lov = paramdd.lov;
        paramca.lot = paramdd.lot;
        paramca.low = paramdd.low;
        paramca.lox = paramdd.lox;
        paramca.loy = paramdd.loy;
        localanm.a(paramca);
      }
      AppMethodBeat.o(30954);
      return true;
      Log.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localanm.bsL("");
    }
  }
  
  private static boolean j(dd paramdd, ca paramca)
  {
    AppMethodBeat.i(30956);
    aoc localaoc = new aoc();
    localaoc.a(bf(paramca));
    Object localObject1 = paramca.field_content;
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.OQ((String)localObject1);
    if (localObject1 == null)
    {
      paramdd.fyI.fyO = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30956);
      return false;
    }
    paramdd.fyI.fyK = localaoc;
    Object localObject2 = localaoc.SAB;
    ((aoi)localObject2).btD(((k.b)localObject1).appId);
    ((aoi)localObject2).btF(((k.b)localObject1).fUd);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramdd.fyI.fyK = localaoc;
      paramdd.fyI.desc = ((k.b)localObject1).title;
      paramdd.fyI.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.ab.a.ctZ().bpR(((k.b)localObject1).fvr);
      localObject2 = new anm();
      a((anm)localObject2, paramca);
      if (localObject3 != null) {
        ((anm)localObject2).bsL(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      if (com.tencent.mm.vfs.u.agG((String)localObject3)) {
        ((anm)localObject2).bsM((String)localObject3);
      }
      ((anm)localObject2).arq(2);
      ((anm)localObject2).bsx(((k.b)localObject1).title);
      ((anm)localObject2).bsy(((k.b)localObject1).description);
      ((anm)localObject2).btf(bs.RU(paramca.hxy));
      localaoc.syG.add(localObject2);
      paramdd.fyI.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      a(false, paramca, (k.b)localObject1, paramdd, localaoc);
      AppMethodBeat.o(30956);
      return true;
    case 76: 
      a(true, paramca, (k.b)localObject1, paramdd, localaoc);
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(paramca, (k.b)localObject1, 4);
      localaoc.btv(((anm)localObject1).title);
      localaoc.btw(((anm)localObject1).desc);
      ((anm)localObject1).btf(bs.RU(paramca.hxy));
      localaoc.syG.add(localObject1);
      paramdd.fyI.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localaoc.SAB.btE(((k.b)localObject1).url);
        localObject2 = new aor();
        ((aor)localObject2).btN(((k.b)localObject1).thumburl);
        ((aor)localObject2).arC(((k.b)localObject1).loY);
        localObject3 = (aj)((k.b)localObject1).ar(aj.class);
        if ((localObject3 != null) && (!Util.isNullOrNil(((aj)localObject3).PyQ)))
        {
          localObject4 = new StringBuilder();
          ((aj)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((aor)localObject2).btP(((StringBuilder)localObject4).toString());
        }
        localaoc.c((aor)localObject2);
        a(paramca, localaoc, (aor)localObject2);
        paramca = a(paramca, (k.b)localObject1, 5);
        localaoc.syG.add(paramca);
        localaoc.btv(paramca.title);
        localaoc.btw(paramca.desc);
        paramdd.fyI.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramdd.fyI.fyO = R.l.favorite_fail_empty_url;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      paramca = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.f.class);
      if (paramca != null)
      {
        paramca = paramca.mbi;
        localaoc.btv(paramca.nickname + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail));
        localaoc.btw(paramca.desc);
        localaoc.d(paramca);
        paramdd.fyI.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.ab.a.ctZ().bpR(((k.b)localObject1).fvr);
      localObject2 = new anm();
      if (localObject3 != null) {
        ((anm)localObject2).bsL(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((anm)localObject2, paramca);
      ((anm)localObject2).arq(8);
      ((anm)localObject2).bsH(((k.b)localObject1).llY);
      paramca = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      if (Util.isNullOrNil(paramca)) {
        ((anm)localObject2).Ey(true);
      }
      if (com.tencent.mm.vfs.u.agG(paramca)) {
        ((anm)localObject2).bsM(paramca);
      }
      ((anm)localObject2).bsx(((k.b)localObject1).title);
      ((anm)localObject2).bsy(((k.b)localObject1).description);
      localaoc.syG.add(localObject2);
      paramdd.fyI.desc = ((k.b)localObject1).title;
      paramdd.fyI.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).fvr == null) || (((k.b)localObject1).fvr.length() == 0)) {
        paramdd.fyI.fyO = R.l.favorite_fail_attachment_not_exists;
      }
      while (com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramdd.fyI.fyO = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(30956);
        return false;
      }
      paramdd.fyI.fyO = R.l.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      paramca = new aob();
      paramca.btq(((k.b)localObject1).title);
      paramca.btr(((k.b)localObject1).description);
      paramca.arw(((k.b)localObject1).lmv);
      paramca.btt(((k.b)localObject1).lmw);
      paramca.bts(((k.b)localObject1).thumburl);
      paramdd.fyI.title = ((k.b)localObject1).title;
      paramdd.fyI.desc = ((k.b)localObject1).description;
      paramdd.fyI.type = 10;
      localaoc.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      paramca = new aol();
      paramca.btG(((k.b)localObject1).title);
      paramca.btH(((k.b)localObject1).description);
      paramca.btJ(((k.b)localObject1).lmz);
      paramca.btI(((k.b)localObject1).thumburl);
      paramdd.fyI.title = ((k.b)localObject1).title;
      paramdd.fyI.desc = ((k.b)localObject1).description;
      paramdd.fyI.type = 15;
      localaoc.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      paramca = new aob();
      paramca.btq(((k.b)localObject1).title);
      paramca.btr(((k.b)localObject1).description);
      paramca.arw(((k.b)localObject1).lmB);
      paramca.btt(((k.b)localObject1).lmC);
      paramca.bts(((k.b)localObject1).thumburl);
      paramdd.fyI.title = ((k.b)localObject1).title;
      paramdd.fyI.desc = ((k.b)localObject1).description;
      paramdd.fyI.type = 11;
      localaoc.b(paramca);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramdd.fyI.fyL = new aoq();
      bool = a(paramdd, (k.b)localObject1, localaoc, paramca, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramdd.fyI.fyL = new aoq();
      bool = a(paramdd, (k.b)localObject1, localaoc, paramca, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new ank();
    ((ank)localObject3).username = ((k.b)localObject1).loA;
    ((ank)localObject3).appId = ((k.b)localObject1).loB;
    ((ank)localObject3).fES = ((k.b)localObject1).loT;
    ((ank)localObject3).iconUrl = ((k.b)localObject1).loV;
    ((ank)localObject3).fve = ((k.b)localObject1).loz;
    ((ank)localObject3).SxE = ((k.b)localObject1).fUe;
    ((ank)localObject3).otE = ((k.b)localObject1).loJ;
    ((ank)localObject3).type = ((k.b)localObject1).loC;
    Object localObject4 = (com.tencent.mm.aj.a)((k.b)localObject1).ar(com.tencent.mm.aj.a.class);
    if (localObject4 != null)
    {
      ((ank)localObject3).nYp = ((com.tencent.mm.aj.a)localObject4).lkl;
      ((ank)localObject3).fXg = ((com.tencent.mm.aj.a)localObject4).lkn;
      ((ank)localObject3).subType = ((com.tencent.mm.aj.a)localObject4).lko;
    }
    ((ank)localObject3).version = ((k.b)localObject1).loU;
    localObject4 = new anm();
    a((anm)localObject4, paramca);
    ((anm)localObject4).arq(19);
    String str = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
    if (Util.isNullOrNil(str)) {
      ((anm)localObject4).Ey(true);
    }
    if (com.tencent.mm.vfs.u.agG(str)) {
      ((anm)localObject4).bsM(str);
    }
    ((anm)localObject4).bsx(((k.b)localObject1).title);
    ((anm)localObject4).bsy(((k.b)localObject1).description);
    localaoc.syG.add(localObject4);
    localaoc.btv(((k.b)localObject1).title);
    if (ab.Lj(paramca.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((aoi)localObject2).arz(i);
      paramdd.fyI.title = ((k.b)localObject1).title;
      paramdd.fyI.desc = ((k.b)localObject1).description;
      paramdd.fyI.type = 19;
      localaoc.c((ank)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static ano q(anm paramanm)
  {
    AppMethodBeat.i(30960);
    ano localano = new ano();
    paramanm = paramanm.SyG.Szn;
    if (paramanm.SzY) {
      localano.btg(paramanm.fLi);
    }
    if (paramanm.SzZ) {
      localano.bth(paramanm.toUser);
    }
    if (paramanm.SAc) {
      localano.btj(paramanm.SAb);
    }
    localano.aru(1);
    localano.Ub(Util.nowMilliSecond());
    AppMethodBeat.o(30960);
    return localano;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j
 * JD-Core Version:    0.7.0.1
 */