package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.aj.j;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.b;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static String YR(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static ajx a(ajx paramajx, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    ajx localajx = new ajx();
    ajy localajy = new ajy();
    localajy.c(q(paramajx));
    localajy.d(paramajx.GAu.Ekw);
    localajx.a(localajy);
    localajx.aPX(paramajx.GAw);
    localajx.aPY(paramajx.GAy);
    localajx.aQg(paramajx.GAV);
    localajx.aQh(paramajx.GAX);
    localajx.wt(true);
    localajx.ws(true);
    localajx.aPZ(paramajx.GAC);
    localajx.aaq(paramajx.GAI);
    localajx.aPN(paramajx.GzR);
    localajx.aPO(paramajx.GzT);
    localajx.De(paramajx.GzV);
    localajx.aPS(paramajx.GAc);
    localajx.aPT(paramajx.GAe);
    localajx.Df(paramajx.GAg);
    if (paramBoolean) {
      localajx.aPP(paramajx.dua);
    }
    AppMethodBeat.o(30961);
    return localajx;
  }
  
  private static ajx a(bv parambv, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    ajx localajx = new ajx();
    a(localajx, parambv);
    localajx.aPJ(paramb.hCY);
    localajx.aPK(paramb.hCZ);
    localajx.aPI(paramb.url);
    localajx.ws(true);
    parambv = new k(bu.bI(q.aIX().R(parambv.field_imgPath, true), ""));
    if (parambv.exists()) {
      localajx.aPR(w.B(parambv.fTh()));
    }
    for (;;)
    {
      localajx.aPC(paramb.title);
      localajx.aPD(paramb.description);
      localajx.aQb(paramb.canvasPageXml);
      localajx.aao(paramInt);
      localajx.aQa(paramb.dIA);
      parambv = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (parambv != null)
      {
        localajx.aQi(parambv.songAlbumUrl);
        localajx.aQj(parambv.songLyric);
      }
      AppMethodBeat.o(30955);
      return localajx;
      localajx.wt(true);
    }
  }
  
  private static void a(ajx paramajx1, ajx paramajx2)
  {
    AppMethodBeat.i(30962);
    paramajx1.aPJ(paramajx2.GzJ);
    paramajx1.aPK(paramajx2.GzL);
    paramajx1.aPI(paramajx2.GzH);
    paramajx1.aPC(paramajx2.title);
    paramajx1.aPD(paramajx2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(ajx paramajx, bv parambv)
  {
    AppMethodBeat.i(30950);
    if (parambv.field_isSend == 1)
    {
      if ((x.wb(parambv.field_talker)) || (parambv.field_talker.equals("filehelper")))
      {
        paramajx.aPU(String.valueOf(parambv.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramajx.aPU(parambv.field_talker + "#" + String.valueOf(parambv.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramajx.aPU(String.valueOf(parambv.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(bv parambv, akn paramakn, alc paramalc)
  {
    AppMethodBeat.i(30958);
    paramakn.f(m.a(parambv, paramalc));
    AppMethodBeat.o(30958);
  }
  
  public static boolean a(cw paramcw, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramcw == null) || (bu.isNullOrNil(paramString)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localajx.aao(2);
    localajx.aPQ(paramString);
    localajx.aPP(com.tencent.mm.b.g.getMessageDigest((localajx.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gx();
    ((gx)localObject).dub.type = 27;
    ((gx)localObject).dub.dud = localajx;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gx)localObject).duc.thumbPath;
    com.tencent.mm.sdk.platformtools.h.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localajx.aPR((String)localObject);
    localakt.aQC(com.tencent.mm.model.v.aAC());
    localakt.aQD(com.tencent.mm.model.v.aAC());
    localakt.aax(paramInt);
    localakt.Dk(bu.fpO());
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    paramcw.doL.title = localajx.title;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(cw paramcw, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(179755);
    if (bu.isNullOrNil(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(179755);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt) });
    if (new k(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcw.doL.doQ = 2131759025;; paramcw.doL.doQ = 2131759024)
      {
        AppMethodBeat.o(179755);
        return false;
      }
    }
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localajx.aPQ(paramString1);
    localajx.aao(4);
    localajx.aPM(com.tencent.mm.vfs.o.aaw(paramString1));
    localajx.aPR(paramString2);
    localajx.aan(0);
    localajx.aPC(paramString3);
    localajx.aPD(paramString4);
    localakt.aQC(com.tencent.mm.model.v.aAC());
    localakt.aQD(com.tencent.mm.model.v.aAC());
    localakt.aax(paramInt);
    localakt.Dk(bu.fpO());
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    paramcw.doL.title = localajx.title;
    paramcw.doL.desc = localajx.title;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 4;
    AppMethodBeat.o(179755);
    return true;
  }
  
  public static boolean a(cw paramcw, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = e(paramcw, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(cw paramcw, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramcw == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(30940);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bu.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new ake();
    paramIntent.aQt((String)localObject1);
    paramIntent.B(d1);
    paramIntent.A(d2);
    paramIntent.aat(i);
    paramIntent.aQu((String)localObject2);
    localObject1 = new akn();
    localObject2 = new akt();
    String str = com.tencent.mm.model.v.aAC();
    ((akt)localObject2).aQC(str);
    ((akt)localObject2).aQD(str);
    ((akt)localObject2).aax(6);
    ((akt)localObject2).Dk(bu.fpO());
    ((akn)localObject1).d(paramIntent);
    ((akn)localObject1).a((akt)localObject2);
    paramcw.doL.doN = ((akn)localObject1);
    paramcw.doL.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(cw paramcw, k.b paramb, akn paramakn, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new qi();
    ((qi)localObject).dFS.type = 0;
    ((qi)localObject).dFS.dFU = paramb.hDg;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((qi)localObject).dFT.dGd;
    if (localc == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30959);
      return false;
    }
    paramakn.aQA(localc.title);
    Iterator localIterator = localc.hFT.iterator();
    int i = 0;
    ajx localajx;
    if (localIterator.hasNext())
    {
      localajx = (ajx)localIterator.next();
      switch (localajx.dataType)
      {
      case 9: 
      case 13: 
      case 18: 
      case 21: 
      default: 
        paramb = null;
        label242:
        if (paramb != null) {
          if (parambv.field_isSend == 1) {
            if ((x.wb(parambv.field_talker)) || (parambv.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambv.field_msgSvrId), Integer.valueOf(i) });
              paramb.aPU((String)localObject);
              paramb.aQk(localajx.ixk);
              paramakn.oeJ.add(paramb);
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
      long l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      paramb.aao(3);
      if (!bu.isNullOrNil(localajx.GAC))
      {
        localObject = new qi();
        ((qi)localObject).dFS.type = 1;
        ((qi)localObject).dFS.dtI = localajx;
        ((qi)localObject).dFS.msgId = l;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.aPQ(((qi)localObject).dFT.dGe);
        paramb.aan(localajx.duration);
        paramb.wt(true);
        paramb.ws(false);
        paramb.aPM(localajx.GzP);
      }
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCv += 1;
      break label242;
      paramb = a(localajx, paramBoolean);
      paramb.aao(1);
      paramb.aPD(localajx.desc);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCt += 1;
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      paramb.aao(2);
      localObject = new qi();
      ((qi)localObject).dFS.type = 1;
      ((qi)localObject).dFS.dtI = localajx;
      ((qi)localObject).dFS.msgId = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.aPQ(((qi)localObject).dFT.dGe);
      paramb.aPR(((qi)localObject).dFT.thumbPath);
      paramb.wt(false);
      paramb.ws(false);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCu += 1;
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      a(paramb, localajx);
      paramb.aao(5);
      localObject = new qi();
      ((qi)localObject).dFS.type = 1;
      ((qi)localObject).dFS.dtI = localajx;
      ((qi)localObject).dFS.msgId = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.aPR(((qi)localObject).dFT.thumbPath);
      paramb.wt(false);
      if ((localajx.GAu != null) && (localajx.GAu.GBf != null))
      {
        localObject = new alc();
        ((alc)localObject).aQP(localajx.GAu.GBf.title);
        ((alc)localObject).aQQ(localajx.GAu.GBf.desc);
        ((alc)localObject).aQS(localajx.GAu.GBf.thumbUrl);
        ((alc)localObject).aay(localajx.GAu.GBf.GCI);
        ((alc)localObject).aQR(localajx.GAu.GBf.GCG);
        paramb.GAu.a((alc)localObject);
      }
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCw += 1;
      break label242;
      paramb = a(localajx, paramBoolean);
      paramb.aPC(localajx.title);
      paramb.aPD(localajx.desc);
      paramb.GAu.c(localajx.GAu.GBx);
      paramb.aao(22);
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      a(paramb, localajx);
      if (localajx.dataType == 15) {
        paramb.aao(15);
      }
      for (;;)
      {
        localObject = new qi();
        ((qi)localObject).dFS.type = 1;
        ((qi)localObject).dFS.dtI = localajx;
        ((qi)localObject).dFS.msgId = l;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.ws(false);
        paramb.aPQ(((qi)localObject).dFT.dGe);
        paramb.a(localajx.GAu);
        paramb.wt(false);
        paramb.aPR(((qi)localObject).dFT.thumbPath);
        paramb.aan(localajx.duration);
        localObject = paramcw.doL.doO;
        ((alb)localObject).tRD += 1;
        break;
        paramb.aao(4);
      }
      paramb = a(localajx, paramBoolean);
      paramb.aao(6);
      if ((localajx.GAu != null) && (localajx.GAu.GBd != null))
      {
        localObject = new ake();
        ((ake)localObject).aQt(localajx.GAu.GBd.label);
        ((ake)localObject).B(localajx.GAu.GBd.lat);
        ((ake)localObject).A(localajx.GAu.GBd.lng);
        ((ake)localObject).aat(localajx.GAu.GBd.dzG);
        ((ake)localObject).aQu(localajx.GAu.GBd.dEv);
        paramb.GAu.c((ake)localObject);
      }
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCx += 1;
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      a(paramb, localajx);
      paramb.aQi(localajx.songAlbumUrl);
      paramb.aQj(localajx.songLyric);
      paramb.aao(7);
      localObject = new qi();
      ((qi)localObject).dFS.type = 1;
      ((qi)localObject).dFS.dtI = localajx;
      ((qi)localObject).dFS.msgId = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.aPR(((qi)localObject).dFT.thumbPath);
      paramb.wt(false);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCy += 1;
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      a(paramb, localajx);
      paramb.aao(8);
      localObject = new qi();
      ((qi)localObject).dFS.type = 1;
      ((qi)localObject).dFS.dtI = localajx;
      ((qi)localObject).dFS.msgId = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bu.isNullOrNil(((qi)localObject).dFT.dGe)) && (bu.isNullOrNil(((qi)localObject).dFT.thumbPath))) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.aPQ(((qi)localObject).dFT.dGe);
      paramb.aPR(((qi)localObject).dFT.thumbPath);
      paramb.ws(false);
      paramb.aPM(localajx.GzP);
      localObject = paramcw.doL.doO;
      ((alb)localObject).fileCount += 1;
      break label242;
      paramb = b(localajx, localajx.dataType, paramBoolean);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCA += 1;
      break label242;
      paramb = b(localajx, localajx.dataType, paramBoolean);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCB += 1;
      break label242;
      paramb = a(localajx, paramBoolean);
      paramb.aao(14);
      if ((localajx.GAu != null) && (localajx.GAu.GBj != null))
      {
        localObject = new akw();
        ((akw)localObject).aQL(localajx.GAu.GBj.title);
        ((akw)localObject).aQM(localajx.GAu.GBj.desc);
        ((akw)localObject).aQO(localajx.GAu.GBj.info);
        ((akw)localObject).aQN(localajx.GAu.GBj.thumbUrl);
        paramb.GAu.a((akw)localObject);
      }
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCE += 1;
      break label242;
      paramb = a(localajx, paramBoolean);
      paramb.aao(16);
      paramb.aPD(localajx.desc);
      localObject = paramcw.doL.doO;
      ((alb)localObject).GCF += 1;
      break label242;
      paramb = a(localajx, paramBoolean);
      paramb.aPC(localajx.title);
      paramb.aPD(localajx.desc);
      paramb.aao(17);
      paramb.aQc(localajx.GAK);
      break label242;
      l = parambv.field_msgId;
      paramb = a(localajx, paramBoolean);
      paramb.aPC(localajx.title);
      paramb.aPD(localajx.desc);
      paramb.aao(19);
      localObject = new qi();
      ((qi)localObject).dFS.type = 1;
      ((qi)localObject).dFS.dtI = localajx;
      ((qi)localObject).dFS.msgId = l;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (bu.isNullOrNil(((qi)localObject).dFT.thumbPath)) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localajx.GAu != null) && (localajx.GAu.GBs != null))
        {
          localObject = new ajv();
          ((ajv)localObject).username = localajx.GAu.GBs.username;
          ((ajv)localObject).appId = localajx.GAu.GBs.appId;
          ((ajv)localObject).duK = localajx.GAu.GBs.duK;
          ((ajv)localObject).iconUrl = localajx.GAu.GBs.iconUrl;
          ((ajv)localObject).type = localajx.GAu.GBs.type;
          ((ajv)localObject).dlk = localajx.GAu.GBs.dlk;
          ((ajv)localObject).Gzq = localajx.GAu.GBs.Gzq;
          ((ajv)localObject).version = localajx.GAu.GBs.version;
          ((ajv)localObject).kaX = localajx.GAu.GBs.kaX;
          ((ajv)localObject).kuE = localajx.GAu.GBs.kuE;
          ((ajv)localObject).dLl = localajx.GAu.GBs.dLl;
          paramb.GAu.b((ajv)localObject);
        }
        break;
        paramb.wt(false);
        paramb.aPR(((qi)localObject).dFT.thumbPath);
      }
      paramb = a(localajx, paramBoolean);
      paramb.aao(20);
      paramb.aan(localajx.duration);
      break label242;
      localObject = String.format("%s#%d$%d", new Object[] { parambv.field_talker, Long.valueOf(parambv.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambv.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      if (com.tencent.mm.plugin.fav.ui.l.j((ajx)localc.hFT.get(0))) {}
      for (paramcw.doL.type = 18;; paramcw.doL.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30949);
    akn localakn = new akn();
    localakn.a(aE(parambv));
    parambv = bx.M(parambv.field_content, "msg");
    if (parambv != null) {
      try
      {
        ake localake = new ake();
        localake.aQt((String)parambv.get(".msg.location.$label"));
        localake.B(Double.parseDouble((String)parambv.get(".msg.location.$x")));
        localake.A(Double.parseDouble((String)parambv.get(".msg.location.$y")));
        localake.aat(Integer.valueOf((String)parambv.get(".msg.location.$scale")).intValue());
        localake.aQu((String)parambv.get(".msg.location.$poiname"));
        localakn.d(localake);
        paramcw.doL.type = 6;
        paramcw.doL.doN = localakn;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception parambv)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambv.getStackTrace().toString() });
      }
    }
    paramcw.doL.doQ = 2131758895;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static boolean a(cw paramcw, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(30941);
    if ((paramcw == null) || (bu.isNullOrNil(paramString1)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(30941);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new k(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcw.doL.doQ = 2131759025;; paramcw.doL.doQ = 2131759024)
      {
        AppMethodBeat.o(30941);
        return false;
      }
    }
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localajx.aPQ(paramString1);
    localajx.aao(8);
    localajx.aPM(com.tencent.mm.vfs.o.aaw(paramString1));
    localajx.wt(true);
    localajx.aPC(paramString2);
    localajx.aPD(paramString3);
    localakt.aQC(com.tencent.mm.model.v.aAC());
    localakt.aQD(com.tencent.mm.model.v.aAC());
    localakt.aax(13);
    localakt.Dk(bu.fpO());
    localakn.a(localakt);
    localakn.oeJ.add(localajx);
    paramcw.doL.title = localajx.title;
    paramcw.doL.desc = localajx.title;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 8;
    AppMethodBeat.o(30941);
    return true;
  }
  
  private static akt aE(bv parambv)
  {
    AppMethodBeat.i(30946);
    akt localakt = new akt();
    if (parambv.field_isSend == 1)
    {
      localakt.aQC(com.tencent.mm.model.v.aAC());
      localakt.aQD(parambv.field_talker);
      if (x.wb(parambv.field_talker)) {
        localakt.aQF(localakt.dzZ);
      }
    }
    do
    {
      localakt.aax(1);
      localakt.Dk(parambv.field_createTime);
      localakt.aQG(parambv.field_msgSvrId);
      if (parambv.field_msgSvrId > 0L) {
        localakt.aQE(parambv.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localakt;
      localakt.aQC(parambv.field_talker);
      localakt.aQD(com.tencent.mm.model.v.aAC());
    } while (!x.wb(parambv.field_talker));
    if (parambv.field_content != null) {}
    for (String str = parambv.field_content.substring(0, Math.max(0, parambv.field_content.indexOf(':')));; str = "")
    {
      localakt.aQF(str);
      if ((bu.isNullOrNil(localakt.GBE)) || (parambv.ftf())) {
        break;
      }
      parambv.setContent(parambv.field_content.substring(localakt.GBE.length() + 1));
      if ((parambv.field_content.length() > 0) && ('\n' == parambv.field_content.charAt(0))) {
        parambv.setContent(parambv.field_content.substring(1));
      }
      if (!parambv.fvS()) {
        break;
      }
      if ((!bu.isNullOrNil(parambv.field_transContent)) && (parambv.field_transContent.startsWith(localakt.GBE))) {
        parambv.ul(parambv.field_transContent.substring(localakt.GBE.length() + 1));
      }
      if ((parambv.field_transContent.length() <= 0) || ('\n' != parambv.field_transContent.charAt(0))) {
        break;
      }
      parambv.ul(parambv.field_transContent.substring(1));
      break;
    }
  }
  
  private static String aMS(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = n.d(com.tencent.mm.plugin.record.b.azT(), "recbiz_", paramString, ".rec", 2);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30952);
      return null;
    }
    if (new k(paramString).exists())
    {
      AppMethodBeat.o(30952);
      return paramString;
    }
    AppMethodBeat.o(30952);
    return paramString;
  }
  
  private static ajx b(ajx paramajx, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    ajx localajx = a(paramajx, paramBoolean);
    localajx.aao(paramInt);
    if ((paramajx.GAu != null) && (paramajx.GAu.GBh != null))
    {
      akm localakm = new akm();
      localakm.aQv(paramajx.GAu.GBh.title);
      localakm.aQw(paramajx.GAu.GBh.desc);
      localakm.aau(paramajx.GAu.GBh.type);
      localakm.aQy(paramajx.GAu.GBh.info);
      localakm.aQx(paramajx.GAu.GBh.thumbUrl);
      localajx.GAu.a(localakm);
    }
    AppMethodBeat.o(30963);
    return localajx;
  }
  
  public static boolean b(cw paramcw, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(30942);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    akn localakn = new akn();
    akt localakt = new akt();
    localakt.aQC(com.tencent.mm.model.v.aAC());
    localakt.aQD(com.tencent.mm.model.v.aAC());
    localakt.aax(paramInt);
    localakt.Dk(bu.fpO());
    localakn.a(localakt);
    paramcw.doL.desc = paramString;
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static boolean d(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30957);
    akn localakn = new akn();
    Object localObject1 = aE(parambv);
    localakn.a((akt)localObject1);
    try
    {
      com.tencent.mm.ah.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
      Object localObject2 = localu.hFT;
      ((akt)localObject1).aQK(localu.dIt);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcw.doL.doP))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcw.doL.doP) });
        com.tencent.mm.ah.v localv = (com.tencent.mm.ah.v)((List)localObject2).get(paramcw.doL.doP);
        if (m.zd(localv.hGj))
        {
          paramcw.doL.doQ = 2131758893;
          AppMethodBeat.o(30957);
          return false;
        }
        ((akt)localObject1).aQJ(localv.url);
        if (paramcw.doL.doP > 0) {
          ((akt)localObject1).aQE("");
        }
        ajx localajx = new ajx();
        localajx.aPC(localv.title);
        localajx.aPD(localv.hGg);
        a(localajx, parambv);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2))
        {
          parambv = com.tencent.mm.aj.p.aEN().DL(parambv.field_talker);
          localObject1 = localObject2;
          if (parambv != null) {
            localObject1 = parambv.aEG();
          }
        }
        if (!bu.isNullOrNil((String)localObject1))
        {
          localajx.aPR(r.aMY((String)localObject1));
          localajx.wt(false);
          if ((bu.isNullOrNil(localajx.GAa)) || (!com.tencent.mm.vfs.o.fB(localajx.GAa)))
          {
            localajx.aPL((String)localObject1);
            localajx.wt(true);
          }
        }
        for (;;)
        {
          localajx.ws(true);
          localajx.aao(5);
          localakn.oeJ.add(localajx);
          paramcw.doL.doN = localakn;
          paramcw.doL.desc = localv.title;
          paramcw.doL.type = 5;
          parambv = new alc();
          parambv.aQS((String)localObject1);
          parambv.aQP(localv.title);
          parambv.aQQ(localv.hGg);
          localakn.b(parambv);
          localakn.f(m.a(localv, parambv, localu.dIt, localu.dIu));
          AppMethodBeat.o(30957);
          return true;
          localajx.wt(true);
        }
      }
      return false;
    }
    catch (Exception parambv)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.GetFavDataSource", parambv, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambv.getLocalizedMessage() });
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean e(cw paramcw, bv parambv)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramcw == null) || (parambv == null))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    parambv = bv.aM(parambv);
    if (parambv.isText()) {
      bool = f(paramcw, parambv);
    }
    for (;;)
    {
      paramcw.doL.dox = parambv.field_content;
      if ((bool) || (paramcw.doL.doQ == 0)) {
        com.tencent.mm.plugin.fav.ui.e.a(parambv, paramcw, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (parambv.ftf())
      {
        bool = h(paramcw, parambv);
      }
      else if (parambv.cVJ())
      {
        bool = a(paramcw, parambv);
      }
      else if (parambv.ftg())
      {
        bool = g(paramcw, parambv);
      }
      else if ((parambv.cyG()) || (parambv.cyI()))
      {
        bool = j(paramcw, parambv);
      }
      else if (parambv.cyH())
      {
        bool = i(paramcw, parambv);
      }
      else if (parambv.fta())
      {
        bool = d(paramcw, parambv);
      }
      else
      {
        if (parambv.fvE()) {}
        while ((!parambv.cVH()) || (parambv.fvH()))
        {
          paramcw.doL.doQ = 2131758893;
          break;
        }
        bool = k(paramcw, parambv);
      }
    }
  }
  
  private static boolean f(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30947);
    akn localakn = new akn();
    localakn.a(aE(parambv));
    paramcw.doL.doN = localakn;
    paramcw.doL.desc = parambv.field_content;
    paramcw.doL.type = 1;
    if (f.aYK(paramcw.doL.desc) > com.tencent.mm.n.b.acm())
    {
      paramcw.doL.doQ = 2131759022;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean g(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (parambv.field_msgId > 0L) {
      localObject1 = q.aIX().G(parambv.field_talker, parambv.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambv.field_msgSvrId > 0L) {
        localObject2 = q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcw.doL.doQ = 2131758891;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new akn();
    ((akn)localObject1).a(aE(parambv));
    ajx localajx = new ajx();
    a(localajx, parambv);
    localajx.aao(2);
    localajx.aPQ(q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", ""));
    if (((com.tencent.mm.av.g)localObject2).aIB())
    {
      localObject2 = q.aIX().pw(((com.tencent.mm.av.g)localObject2).icz);
      if (((com.tencent.mm.av.g)localObject2).hPI > ((com.tencent.mm.av.g)localObject2).offset) {
        localajx.aPQ(q.aIX().o("SERVERID://" + parambv.field_msgSvrId, "", ""));
      }
    }
    localajx.aPR(q.aIX().R(parambv.field_imgPath, true));
    localajx.aQk(bn.BV(parambv.eNd));
    parambv = new LinkedList();
    parambv.add(localajx);
    ((akn)localObject1).bm(parambv);
    paramcw.doL.doN = ((akn)localObject1);
    paramcw.doL.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean h(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30951);
    akn localakn = new akn();
    localakn.a(aE(parambv));
    ajx localajx = new ajx();
    a(localajx, parambv);
    if (x.AK(parambv.field_talker)) {
      localajx.aPQ(aMS(parambv.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localajx.aao(3);
      localajx.wt(true);
      localb = com.tencent.mm.modelvoice.s.It(parambv.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localajx.aPQ(com.tencent.mm.modelvoice.s.getFullPath(parambv.field_imgPath));
    }
    localajx.aPM(YR(localb.getFormat()));
    localajx.aan((int)new com.tencent.mm.modelvoice.p(parambv.field_content).time);
    parambv = new LinkedList();
    parambv.add(localajx);
    localakn.bm(parambv);
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean i(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.aB(parambv.field_content, parambv.field_reserved);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    akn localakn = new akn();
    localakn.a(aE(parambv));
    ajx localajx = new ajx();
    a(localajx, parambv);
    com.tencent.mm.modelvideo.o.aNh();
    localajx.aPR(t.HK(parambv.field_imgPath));
    localajx.aPM(com.tencent.mm.vfs.o.aaw(localajx.GzY));
    localajx.aPQ("");
    localajx.aPL(((k.b)localObject).thumburl);
    akf localakf = m.t(parambv);
    if (localakf == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localajx.aan(localakf.duration);
    localajx.aPC(((k.b)localObject).title);
    localajx.aPI(((k.b)localObject).url);
    localajx.ws(true);
    localajx.wt(true);
    localObject = new ajy();
    if (parambv.cyH()) {
      ((ajy)localObject).e(localakf);
    }
    localajx.a((ajy)localObject);
    parambv = new LinkedList();
    parambv.add(localajx);
    localakn.bm(parambv);
    paramcw.doL.doN = localakn;
    paramcw.doL.type = 4;
    localajx.aao(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean j(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30954);
    akn localakn = new akn();
    localakn.a(aE(parambv));
    ajx localajx = new ajx();
    a(localajx, parambv);
    com.tencent.mm.modelvideo.o.aNh();
    localajx.aPR(t.HK(parambv.field_imgPath));
    localajx.aPM(com.tencent.mm.vfs.o.aaw(localajx.GzY));
    Object localObject = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).hPI) });
    if (((com.tencent.mm.modelvideo.s)localObject).hPI > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcw.doL.doQ = 2131759025;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((parambv.cyI()) && (com.tencent.mm.modelvideo.u.Ic(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).aNw())
    {
      com.tencent.mm.modelvideo.o.aNh();
      String str = t.HJ(parambv.field_imgPath);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localajx.aPQ(str);
      localajx.aan(((com.tencent.mm.modelvideo.s)localObject).hKI);
      localajx.aQk(bn.BV(parambv.eNd));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localajx);
      localakn.bm((LinkedList)localObject);
      paramcw.doL.doN = localakn;
      if (!parambv.cyI()) {
        break label469;
      }
      paramcw.doL.type = 16;
      localajx.aao(15);
    }
    for (;;)
    {
      paramcw = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
      localajx.aQa(paramcw.dIA);
      paramcw = paramcw.ixh;
      if ((paramcw != null) && (!bu.isNullOrNil(paramcw.hEZ)))
      {
        parambv = new aka();
        parambv.hET = paramcw.hET;
        parambv.GBN = paramcw.GBN;
        parambv.hEW = paramcw.hEW;
        parambv.hEX = paramcw.hEX;
        parambv.hEV = paramcw.hEV;
        parambv.hEY = paramcw.hEY;
        parambv.hEZ = paramcw.hEZ;
        parambv.hFa = paramcw.hFa;
        localajx.a(parambv);
      }
      AppMethodBeat.o(30954);
      return true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localajx.aPQ("");
      break;
      label469:
      paramcw.doL.type = 4;
      localajx.aao(4);
    }
  }
  
  private static boolean k(cw paramcw, bv parambv)
  {
    AppMethodBeat.i(30956);
    akn localakn = new akn();
    localakn.a(aE(parambv));
    Object localObject1 = parambv.field_content;
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.zb((String)localObject1);
    if (localObject1 == null)
    {
      paramcw.doL.doQ = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    paramcw.doL.doN = localakn;
    Object localObject2 = localakn.GCe;
    ((akt)localObject2).aQI(((k.b)localObject1).appId);
    ((akt)localObject2).aQK(((k.b)localObject1).dIt);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramcw.doL.doQ = 2131758893;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramcw.doL.doN = localakn;
      paramcw.doL.desc = ((k.b)localObject1).title;
      paramcw.doL.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bJV().aMZ(((k.b)localObject1).dlu);
      localObject2 = new ajx();
      a((ajx)localObject2, parambv);
      if (localObject3 != null) {
        ((ajx)localObject2).aPQ(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = q.aIX().R(parambv.field_imgPath, true);
      if (com.tencent.mm.vfs.o.fB((String)localObject3)) {
        ((ajx)localObject2).aPR((String)localObject3);
      }
      ((ajx)localObject2).aao(2);
      ((ajx)localObject2).aPC(((k.b)localObject1).title);
      ((ajx)localObject2).aPD(((k.b)localObject1).description);
      ((ajx)localObject2).aQk(bn.BV(parambv.eNd));
      localakn.oeJ.add(localObject2);
      paramcw.doL.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      parambv = a(parambv, (k.b)localObject1, 7);
      localakn.oeJ.add(parambv);
      paramcw.doL.type = 7;
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(parambv, (k.b)localObject1, 4);
      localakn.aQA(((ajx)localObject1).title);
      localakn.aQB(((ajx)localObject1).desc);
      ((ajx)localObject1).aQk(bn.BV(parambv.eNd));
      localakn.oeJ.add(localObject1);
      paramcw.doL.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localakn.GCe.aQJ(((k.b)localObject1).url);
        localObject2 = new alc();
        ((alc)localObject2).aQS(((k.b)localObject1).thumburl);
        localObject3 = (com.tencent.mm.plugin.websearch.api.ae)((k.b)localObject1).ao(com.tencent.mm.plugin.websearch.api.ae.class);
        if ((localObject3 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.websearch.api.ae)localObject3).DTD)))
        {
          localObject4 = new StringBuilder();
          ((com.tencent.mm.plugin.websearch.api.ae)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((alc)localObject2).aQU(((StringBuilder)localObject4).toString());
        }
        localakn.b((alc)localObject2);
        a(parambv, localakn, (alc)localObject2);
        parambv = a(parambv, (k.b)localObject1, 5);
        localakn.oeJ.add(parambv);
        localakn.aQA(parambv.title);
        localakn.aQB(parambv.desc);
        paramcw.doL.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramcw.doL.doQ = 2131758889;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      parambv = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (parambv != null)
      {
        parambv = parambv.ipW;
        localakn.aQA(parambv.nickname + ak.getContext().getString(2131759007));
        localakn.aQB(parambv.desc);
        localakn.d(parambv);
        paramcw.doL.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bJV().aMZ(((k.b)localObject1).dlu);
      localObject2 = new ajx();
      if (localObject3 != null) {
        ((ajx)localObject2).aPQ(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((ajx)localObject2, parambv);
      ((ajx)localObject2).aao(8);
      ((ajx)localObject2).aPM(((k.b)localObject1).hCD);
      parambv = q.aIX().R(parambv.field_imgPath, true);
      if (bu.isNullOrNil(parambv)) {
        ((ajx)localObject2).wt(true);
      }
      if (com.tencent.mm.vfs.o.fB(parambv)) {
        ((ajx)localObject2).aPR(parambv);
      }
      ((ajx)localObject2).aPC(((k.b)localObject1).title);
      ((ajx)localObject2).aPD(((k.b)localObject1).description);
      localakn.oeJ.add(localObject2);
      paramcw.doL.desc = ((k.b)localObject1).title;
      paramcw.doL.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).dlu == null) || (((k.b)localObject1).dlu.length() == 0)) {
        paramcw.doL.doQ = 2131758886;
      }
      while (com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        paramcw.doL.doQ = 2131758893;
        AppMethodBeat.o(30956);
        return false;
      }
      paramcw.doL.doQ = 2131758901;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      parambv = new akm();
      parambv.aQv(((k.b)localObject1).title);
      parambv.aQw(((k.b)localObject1).description);
      parambv.aau(((k.b)localObject1).hDb);
      parambv.aQy(((k.b)localObject1).hDc);
      parambv.aQx(((k.b)localObject1).thumburl);
      paramcw.doL.title = ((k.b)localObject1).title;
      paramcw.doL.desc = ((k.b)localObject1).description;
      paramcw.doL.type = 10;
      localakn.b(parambv);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      parambv = new akw();
      parambv.aQL(((k.b)localObject1).title);
      parambv.aQM(((k.b)localObject1).description);
      parambv.aQO(((k.b)localObject1).hDf);
      parambv.aQN(((k.b)localObject1).thumburl);
      paramcw.doL.title = ((k.b)localObject1).title;
      paramcw.doL.desc = ((k.b)localObject1).description;
      paramcw.doL.type = 15;
      localakn.b(parambv);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      parambv = new akm();
      parambv.aQv(((k.b)localObject1).title);
      parambv.aQw(((k.b)localObject1).description);
      parambv.aau(((k.b)localObject1).hDh);
      parambv.aQy(((k.b)localObject1).hDi);
      parambv.aQx(((k.b)localObject1).thumburl);
      paramcw.doL.title = ((k.b)localObject1).title;
      paramcw.doL.desc = ((k.b)localObject1).description;
      paramcw.doL.type = 11;
      localakn.b(parambv);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramcw.doL.doO = new alb();
      bool = a(paramcw, (k.b)localObject1, localakn, parambv, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramcw.doL.doO = new alb();
      bool = a(paramcw, (k.b)localObject1, localakn, parambv, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new ajv();
    ((ajv)localObject3).username = ((k.b)localObject1).hFc;
    ((ajv)localObject3).appId = ((k.b)localObject1).hFd;
    ((ajv)localObject3).duK = ((k.b)localObject1).hFr;
    ((ajv)localObject3).iconUrl = ((k.b)localObject1).hFt;
    ((ajv)localObject3).dlk = ((k.b)localObject1).hFb;
    ((ajv)localObject3).Gzq = ((k.b)localObject1).dIu;
    ((ajv)localObject3).kuE = ((k.b)localObject1).hFl;
    ((ajv)localObject3).type = ((k.b)localObject1).hFe;
    Object localObject4 = (com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class);
    if (localObject4 != null)
    {
      ((ajv)localObject3).kaX = ((com.tencent.mm.ah.a)localObject4).hAV;
      ((ajv)localObject3).dLl = ((com.tencent.mm.ah.a)localObject4).hAX;
      ((ajv)localObject3).subType = ((com.tencent.mm.ah.a)localObject4).hAY;
    }
    ((ajv)localObject3).version = ((k.b)localObject1).hFs;
    localObject4 = new ajx();
    a((ajx)localObject4, parambv);
    ((ajx)localObject4).aao(19);
    String str = q.aIX().R(parambv.field_imgPath, true);
    if (bu.isNullOrNil(str)) {
      ((ajx)localObject4).wt(true);
    }
    if (com.tencent.mm.vfs.o.fB(str)) {
      ((ajx)localObject4).aPR(str);
    }
    ((ajx)localObject4).aPC(((k.b)localObject1).title);
    ((ajx)localObject4).aPD(((k.b)localObject1).description);
    localakn.oeJ.add(localObject4);
    localakn.aQA(((k.b)localObject1).title);
    if (x.wb(parambv.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((akt)localObject2).aax(i);
      paramcw.doL.title = ((k.b)localObject1).title;
      paramcw.doL.desc = ((k.b)localObject1).description;
      paramcw.doL.type = 19;
      localakn.c((ajv)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static ajz q(ajx paramajx)
  {
    AppMethodBeat.i(30960);
    ajz localajz = new ajz();
    paramajx = paramajx.GAu.GBb;
    if (paramajx.GBA) {
      localajz.aQl(paramajx.dzZ);
    }
    if (paramajx.GBB) {
      localajz.aQm(paramajx.toUser);
    }
    if (paramajx.GBF) {
      localajz.aQo(paramajx.GBE);
    }
    localajz.aas(1);
    localajz.Dh(bu.fpO());
    AppMethodBeat.o(30960);
    return localajz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */