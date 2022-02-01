package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.v;
import com.tencent.mm.ak.j;
import com.tencent.mm.aw.h;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.b;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.tools.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g
{
  public static String Yl(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static ajn a(ajn paramajn, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    ajn localajn = new ajn();
    ajo localajo = new ajo();
    localajo.c(q(paramajn));
    localajo.d(paramajn.GhL.DSw);
    localajn.a(localajo);
    localajn.aOA(paramajn.GhN);
    localajn.aOB(paramajn.GhP);
    localajn.aOJ(paramajn.Gim);
    localajn.aOK(paramajn.Gio);
    localajn.wl(true);
    localajn.wk(true);
    localajn.aOC(paramajn.GhT);
    localajn.ZK(paramajn.GhZ);
    localajn.aOq(paramajn.Ghi);
    localajn.aOr(paramajn.Ghk);
    localajn.CG(paramajn.Ghm);
    localajn.aOv(paramajn.Ght);
    localajn.aOw(paramajn.Ghv);
    localajn.CH(paramajn.Ghx);
    if (paramBoolean) {
      localajn.aOs(paramajn.dsU);
    }
    AppMethodBeat.o(30961);
    return localajn;
  }
  
  private static ajn a(bu parambu, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    ajn localajn = new ajn();
    a(localajn, parambu);
    localajn.aOm(paramb.hAk);
    localajn.aOn(paramb.hAl);
    localajn.aOl(paramb.url);
    localajn.wk(true);
    parambu = new com.tencent.mm.vfs.e(bt.bI(com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true), ""));
    if (parambu.exists()) {
      localajn.aOu(com.tencent.mm.vfs.q.B(parambu.fOK()));
    }
    for (;;)
    {
      localajn.aOf(paramb.title);
      localajn.aOg(paramb.description);
      localajn.aOE(paramb.canvasPageXml);
      localajn.ZI(paramInt);
      localajn.aOD(paramb.dHv);
      parambu = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (parambu != null)
      {
        localajn.aOL(parambu.songAlbumUrl);
        localajn.aOM(parambu.songLyric);
      }
      AppMethodBeat.o(30955);
      return localajn;
      localajn.wl(true);
    }
  }
  
  private static void a(ajn paramajn1, ajn paramajn2)
  {
    AppMethodBeat.i(30962);
    paramajn1.aOm(paramajn2.Gha);
    paramajn1.aOn(paramajn2.Ghc);
    paramajn1.aOl(paramajn2.GgY);
    paramajn1.aOf(paramajn2.title);
    paramajn1.aOg(paramajn2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(ajn paramajn, bu parambu)
  {
    AppMethodBeat.i(30950);
    if (parambu.field_isSend == 1)
    {
      if ((w.vF(parambu.field_talker)) || (parambu.field_talker.equals("filehelper")))
      {
        paramajn.aOx(String.valueOf(parambu.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramajn.aOx(parambu.field_talker + "#" + String.valueOf(parambu.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramajn.aOx(String.valueOf(parambu.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(bu parambu, akd paramakd, aks paramaks)
  {
    AppMethodBeat.i(30958);
    paramakd.f(com.tencent.mm.ai.m.a(parambu, paramaks));
    AppMethodBeat.o(30958);
  }
  
  public static boolean a(cv paramcv, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramcv == null) || (bt.isNullOrNil(paramString)))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    ad.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localajn.ZI(2);
    localajn.aOt(paramString);
    localajn.aOs(com.tencent.mm.b.g.getMessageDigest((localajn.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new gw();
    ((gw)localObject).dsV.type = 27;
    ((gw)localObject).dsV.dsX = localajn;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((gw)localObject).dsW.thumbPath;
    com.tencent.mm.sdk.platformtools.g.c(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localajn.aOu((String)localObject);
    localakj.aPf(com.tencent.mm.model.u.aAm());
    localakj.aPg(com.tencent.mm.model.u.aAm());
    localakj.ZR(paramInt);
    localakj.CM(bt.flT());
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    paramcv.dnG.title = localajn.title;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(cv paramcv, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(179755);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(179755);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcv.dnG.dnL = 2131759025;; paramcv.dnG.dnL = 2131759024)
      {
        AppMethodBeat.o(179755);
        return false;
      }
    }
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localajn.aOt(paramString1);
    localajn.ZI(4);
    localajn.aOp(com.tencent.mm.vfs.i.ZF(paramString1));
    localajn.aOu(paramString2);
    localajn.ZH(0);
    localajn.aOf(paramString3);
    localajn.aOg(paramString4);
    localakj.aPf(com.tencent.mm.model.u.aAm());
    localakj.aPg(com.tencent.mm.model.u.aAm());
    localakj.ZR(paramInt);
    localakj.CM(bt.flT());
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    paramcv.dnG.title = localajn.title;
    paramcv.dnG.desc = localajn.title;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 4;
    AppMethodBeat.o(179755);
    return true;
  }
  
  public static boolean a(cv paramcv, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = e(paramcv, ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(cv paramcv, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramcv == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      AppMethodBeat.o(30940);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bt.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new aju();
    paramIntent.aOW((String)localObject1);
    paramIntent.B(d1);
    paramIntent.A(d2);
    paramIntent.ZN(i);
    paramIntent.aOX((String)localObject2);
    localObject1 = new akd();
    localObject2 = new akj();
    String str = com.tencent.mm.model.u.aAm();
    ((akj)localObject2).aPf(str);
    ((akj)localObject2).aPg(str);
    ((akj)localObject2).ZR(6);
    ((akj)localObject2).CM(bt.flT());
    ((akd)localObject1).d(paramIntent);
    ((akd)localObject1).a((akj)localObject2);
    paramcv.dnG.dnI = ((akd)localObject1);
    paramcv.dnG.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(cv paramcv, k.b paramb, akd paramakd, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new qh();
    ((qh)localObject).dEN.type = 0;
    ((qh)localObject).dEN.dEP = paramb.hAs;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.protocal.b.a.c localc = ((qh)localObject).dEO.dEY;
    if (localc == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30959);
      return false;
    }
    paramakd.aPd(localc.title);
    Iterator localIterator = localc.hDb.iterator();
    int i = 0;
    ajn localajn;
    if (localIterator.hasNext())
    {
      localajn = (ajn)localIterator.next();
      switch (localajn.dataType)
      {
      case 9: 
      case 13: 
      case 18: 
      case 21: 
      default: 
        paramb = null;
        label242:
        if (paramb != null) {
          if (parambu.field_isSend == 1) {
            if ((w.vF(parambu.field_talker)) || (parambu.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambu.field_msgSvrId), Integer.valueOf(i) });
              paramb.aOx((String)localObject);
              paramb.aON(localajn.iuq);
              paramakd.nZa.add(paramb);
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
      long l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      paramb.ZI(3);
      if (!bt.isNullOrNil(localajn.GhT))
      {
        localObject = new qh();
        ((qh)localObject).dEN.type = 1;
        ((qh)localObject).dEN.dsC = localajn;
        ((qh)localObject).dEN.msgId = l;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
          ad.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.aOt(((qh)localObject).dEO.dEZ);
        paramb.ZH(localajn.duration);
        paramb.wl(true);
        paramb.wk(false);
        paramb.aOp(localajn.Ghg);
      }
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjM += 1;
      break label242;
      paramb = a(localajn, paramBoolean);
      paramb.ZI(1);
      paramb.aOg(localajn.desc);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjK += 1;
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      paramb.ZI(2);
      localObject = new qh();
      ((qh)localObject).dEN.type = 1;
      ((qh)localObject).dEN.dsC = localajn;
      ((qh)localObject).dEN.msgId = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.aOt(((qh)localObject).dEO.dEZ);
      paramb.aOu(((qh)localObject).dEO.thumbPath);
      paramb.wl(false);
      paramb.wk(false);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjL += 1;
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      a(paramb, localajn);
      paramb.ZI(5);
      localObject = new qh();
      ((qh)localObject).dEN.type = 1;
      ((qh)localObject).dEN.dsC = localajn;
      ((qh)localObject).dEN.msgId = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.aOu(((qh)localObject).dEO.thumbPath);
      paramb.wl(false);
      if ((localajn.GhL != null) && (localajn.GhL.Giw != null))
      {
        localObject = new aks();
        ((aks)localObject).aPs(localajn.GhL.Giw.title);
        ((aks)localObject).aPt(localajn.GhL.Giw.desc);
        ((aks)localObject).aPv(localajn.GhL.Giw.thumbUrl);
        ((aks)localObject).ZS(localajn.GhL.Giw.GjZ);
        ((aks)localObject).aPu(localajn.GhL.Giw.GjX);
        paramb.GhL.a((aks)localObject);
      }
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjN += 1;
      break label242;
      paramb = a(localajn, paramBoolean);
      paramb.aOf(localajn.title);
      paramb.aOg(localajn.desc);
      paramb.GhL.c(localajn.GhL.GiO);
      paramb.ZI(22);
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      a(paramb, localajn);
      if (localajn.dataType == 15) {
        paramb.ZI(15);
      }
      for (;;)
      {
        localObject = new qh();
        ((qh)localObject).dEN.type = 1;
        ((qh)localObject).dEN.dsC = localajn;
        ((qh)localObject).dEN.msgId = l;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
          ad.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.wk(false);
        paramb.aOt(((qh)localObject).dEO.dEZ);
        paramb.a(localajn.GhL);
        paramb.wl(false);
        paramb.aOu(((qh)localObject).dEO.thumbPath);
        paramb.ZH(localajn.duration);
        localObject = paramcv.dnG.dnJ;
        ((akr)localObject).tGM += 1;
        break;
        paramb.ZI(4);
      }
      paramb = a(localajn, paramBoolean);
      paramb.ZI(6);
      if ((localajn.GhL != null) && (localajn.GhL.Giu != null))
      {
        localObject = new aju();
        ((aju)localObject).aOW(localajn.GhL.Giu.label);
        ((aju)localObject).B(localajn.GhL.Giu.lat);
        ((aju)localObject).A(localajn.GhL.Giu.lng);
        ((aju)localObject).ZN(localajn.GhL.Giu.dyB);
        ((aju)localObject).aOX(localajn.GhL.Giu.dDq);
        paramb.GhL.c((aju)localObject);
      }
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjO += 1;
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      a(paramb, localajn);
      paramb.aOL(localajn.songAlbumUrl);
      paramb.aOM(localajn.songLyric);
      paramb.ZI(7);
      localObject = new qh();
      ((qh)localObject).dEN.type = 1;
      ((qh)localObject).dEN.dsC = localajn;
      ((qh)localObject).dEN.msgId = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.aOu(((qh)localObject).dEO.thumbPath);
      paramb.wl(false);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjP += 1;
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      a(paramb, localajn);
      paramb.ZI(8);
      localObject = new qh();
      ((qh)localObject).dEN.type = 1;
      ((qh)localObject).dEN.dsC = localajn;
      ((qh)localObject).dEN.msgId = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((bt.isNullOrNil(((qh)localObject).dEO.dEZ)) && (bt.isNullOrNil(((qh)localObject).dEO.thumbPath))) {
        ad.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.aOt(((qh)localObject).dEO.dEZ);
      paramb.aOu(((qh)localObject).dEO.thumbPath);
      paramb.wk(false);
      paramb.aOp(localajn.Ghg);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).fileCount += 1;
      break label242;
      paramb = b(localajn, localajn.dataType, paramBoolean);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjR += 1;
      break label242;
      paramb = b(localajn, localajn.dataType, paramBoolean);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjS += 1;
      break label242;
      paramb = a(localajn, paramBoolean);
      paramb.ZI(14);
      if ((localajn.GhL != null) && (localajn.GhL.GiA != null))
      {
        localObject = new akm();
        ((akm)localObject).aPo(localajn.GhL.GiA.title);
        ((akm)localObject).aPp(localajn.GhL.GiA.desc);
        ((akm)localObject).aPr(localajn.GhL.GiA.info);
        ((akm)localObject).aPq(localajn.GhL.GiA.thumbUrl);
        paramb.GhL.a((akm)localObject);
      }
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjV += 1;
      break label242;
      paramb = a(localajn, paramBoolean);
      paramb.ZI(16);
      paramb.aOg(localajn.desc);
      localObject = paramcv.dnG.dnJ;
      ((akr)localObject).GjW += 1;
      break label242;
      paramb = a(localajn, paramBoolean);
      paramb.aOf(localajn.title);
      paramb.aOg(localajn.desc);
      paramb.ZI(17);
      paramb.aOF(localajn.Gib);
      break label242;
      l = parambu.field_msgId;
      paramb = a(localajn, paramBoolean);
      paramb.aOf(localajn.title);
      paramb.aOg(localajn.desc);
      paramb.ZI(19);
      localObject = new qh();
      ((qh)localObject).dEN.type = 1;
      ((qh)localObject).dEN.dsC = localajn;
      ((qh)localObject).dEN.msgId = l;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (bt.isNullOrNil(((qh)localObject).dEO.thumbPath)) {
        ad.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localajn.GhL != null) && (localajn.GhL.GiJ != null))
        {
          localObject = new ajl();
          ((ajl)localObject).username = localajn.GhL.GiJ.username;
          ((ajl)localObject).appId = localajn.GhL.GiJ.appId;
          ((ajl)localObject).dtF = localajn.GhL.GiJ.dtF;
          ((ajl)localObject).iconUrl = localajn.GhL.GiJ.iconUrl;
          ((ajl)localObject).type = localajn.GhL.GiJ.type;
          ((ajl)localObject).dki = localajn.GhL.GiJ.dki;
          ((ajl)localObject).GgH = localajn.GhL.GiJ.GgH;
          ((ajl)localObject).version = localajn.GhL.GiJ.version;
          ((ajl)localObject).jXI = localajn.GhL.GiJ.jXI;
          ((ajl)localObject).kro = localajn.GhL.GiJ.kro;
          ((ajl)localObject).dJW = localajn.GhL.GiJ.dJW;
          paramb.GhL.b((ajl)localObject);
        }
        break;
        paramb.wl(false);
        paramb.aOu(((qh)localObject).dEO.thumbPath);
      }
      paramb = a(localajn, paramBoolean);
      paramb.ZI(20);
      paramb.ZH(localajn.duration);
      break label242;
      localObject = String.format("%s#%d$%d", new Object[] { parambu.field_talker, Long.valueOf(parambu.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(parambu.field_msgSvrId), Integer.valueOf(i) });
      break label307;
      if (com.tencent.mm.plugin.fav.ui.l.j((ajn)localc.hDb.get(0))) {}
      for (paramcv.dnG.type = 18;; paramcv.dnG.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30949);
    akd localakd = new akd();
    localakd.a(aF(parambu));
    parambu = bw.M(parambu.field_content, "msg");
    if (parambu != null) {
      try
      {
        aju localaju = new aju();
        localaju.aOW((String)parambu.get(".msg.location.$label"));
        localaju.B(Double.parseDouble((String)parambu.get(".msg.location.$x")));
        localaju.A(Double.parseDouble((String)parambu.get(".msg.location.$y")));
        localaju.ZN(Integer.valueOf((String)parambu.get(".msg.location.$scale")).intValue());
        localaju.aOX((String)parambu.get(".msg.location.$poiname"));
        localakd.d(localaju);
        paramcv.dnG.type = 6;
        paramcv.dnG.dnI = localakd;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception parambu)
      {
        ad.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { parambu.getStackTrace().toString() });
      }
    }
    paramcv.dnG.dnL = 2131758895;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static boolean a(cv paramcv, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(30941);
    if ((paramcv == null) || (bt.isNullOrNil(paramString1)))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(30941);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(13) });
    if (new com.tencent.mm.vfs.e(paramString1).length() > ((af)com.tencent.mm.kernel.g.ad(af.class)).getFileSizeLimit(paramBoolean))
    {
      if (paramBoolean) {}
      for (paramcv.dnG.dnL = 2131759025;; paramcv.dnG.dnL = 2131759024)
      {
        AppMethodBeat.o(30941);
        return false;
      }
    }
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localajn.aOt(paramString1);
    localajn.ZI(8);
    localajn.aOp(com.tencent.mm.vfs.i.ZF(paramString1));
    localajn.wl(true);
    localajn.aOf(paramString2);
    localajn.aOg(paramString3);
    localakj.aPf(com.tencent.mm.model.u.aAm());
    localakj.aPg(com.tencent.mm.model.u.aAm());
    localakj.ZR(13);
    localakj.CM(bt.flT());
    localakd.a(localakj);
    localakd.nZa.add(localajn);
    paramcv.dnG.title = localajn.title;
    paramcv.dnG.desc = localajn.title;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 8;
    AppMethodBeat.o(30941);
    return true;
  }
  
  private static akj aF(bu parambu)
  {
    AppMethodBeat.i(30946);
    akj localakj = new akj();
    if (parambu.field_isSend == 1)
    {
      localakj.aPf(com.tencent.mm.model.u.aAm());
      localakj.aPg(parambu.field_talker);
      if (w.vF(parambu.field_talker)) {
        localakj.aPi(localakj.dyU);
      }
    }
    do
    {
      localakj.ZR(1);
      localakj.CM(parambu.field_createTime);
      localakj.aPj(parambu.field_msgSvrId);
      if (parambu.field_msgSvrId > 0L) {
        localakj.aPh(parambu.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localakj;
      localakj.aPf(parambu.field_talker);
      localakj.aPg(com.tencent.mm.model.u.aAm());
    } while (!w.vF(parambu.field_talker));
    if (parambu.field_content != null) {}
    for (String str = parambu.field_content.substring(0, Math.max(0, parambu.field_content.indexOf(':')));; str = "")
    {
      localakj.aPi(str);
      if ((bt.isNullOrNil(localakj.GiV)) || (parambu.fph())) {
        break;
      }
      parambu.setContent(parambu.field_content.substring(localakj.GiV.length() + 1));
      if ((parambu.field_content.length() > 0) && ('\n' == parambu.field_content.charAt(0))) {
        parambu.setContent(parambu.field_content.substring(1));
      }
      if (!parambu.frS()) {
        break;
      }
      if ((!bt.isNullOrNil(parambu.field_transContent)) && (parambu.field_transContent.startsWith(localakj.GiV))) {
        parambu.tQ(parambu.field_transContent.substring(localakj.GiV.length() + 1));
      }
      if ((parambu.field_transContent.length() <= 0) || ('\n' != parambu.field_transContent.charAt(0))) {
        break;
      }
      parambu.tQ(parambu.field_transContent.substring(1));
      break;
    }
  }
  
  private static String aLw(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = com.tencent.mm.sdk.platformtools.m.d(com.tencent.mm.plugin.record.b.azD(), "recbiz_", paramString, ".rec", 2);
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
  
  private static ajn b(ajn paramajn, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    ajn localajn = a(paramajn, paramBoolean);
    localajn.ZI(paramInt);
    if ((paramajn.GhL != null) && (paramajn.GhL.Giy != null))
    {
      akc localakc = new akc();
      localakc.aOY(paramajn.GhL.Giy.title);
      localakc.aOZ(paramajn.GhL.Giy.desc);
      localakc.ZO(paramajn.GhL.Giy.type);
      localakc.aPb(paramajn.GhL.Giy.info);
      localakc.aPa(paramajn.GhL.Giy.thumbUrl);
      localajn.GhL.a(localakc);
    }
    AppMethodBeat.o(30963);
    return localajn;
  }
  
  public static boolean b(cv paramcv, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcv.dnG.dnL = 2131758885;
      AppMethodBeat.o(30942);
      return false;
    }
    ad.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    akd localakd = new akd();
    akj localakj = new akj();
    localakj.aPf(com.tencent.mm.model.u.aAm());
    localakj.aPg(com.tencent.mm.model.u.aAm());
    localakj.ZR(paramInt);
    localakj.CM(bt.flT());
    localakd.a(localakj);
    paramcv.dnG.desc = paramString;
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static boolean d(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30957);
    akd localakd = new akd();
    Object localObject1 = aF(parambu);
    localakd.a((akj)localObject1);
    try
    {
      com.tencent.mm.ai.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
      Object localObject2 = localu.hDb;
      ((akj)localObject1).aPn(localu.dHo);
      if ((localObject2 != null) && (((List)localObject2).size() > paramcv.dnG.dnK))
      {
        ad.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcv.dnG.dnK) });
        v localv = (v)((List)localObject2).get(paramcv.dnG.dnK);
        if (com.tencent.mm.ai.m.yt(localv.hDr))
        {
          paramcv.dnG.dnL = 2131758893;
          AppMethodBeat.o(30957);
          return false;
        }
        ((akj)localObject1).aPm(localv.url);
        if (paramcv.dnG.dnK > 0) {
          ((akj)localObject1).aPh("");
        }
        ajn localajn = new ajn();
        localajn.aOf(localv.title);
        localajn.aOg(localv.hDo);
        a(localajn, parambu);
        localObject2 = com.tencent.mm.ai.m.a(localv);
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          parambu = com.tencent.mm.ak.p.aEx().Dj(parambu.field_talker);
          localObject1 = localObject2;
          if (parambu != null) {
            localObject1 = parambu.aEq();
          }
        }
        if (!bt.isNullOrNil((String)localObject1))
        {
          localajn.aOu(r.aLC((String)localObject1));
          localajn.wl(false);
          if ((bt.isNullOrNil(localajn.Ghr)) || (!com.tencent.mm.vfs.i.fv(localajn.Ghr)))
          {
            localajn.aOo((String)localObject1);
            localajn.wl(true);
          }
        }
        for (;;)
        {
          localajn.wk(true);
          localajn.ZI(5);
          localakd.nZa.add(localajn);
          paramcv.dnG.dnI = localakd;
          paramcv.dnG.desc = localv.title;
          paramcv.dnG.type = 5;
          parambu = new aks();
          parambu.aPv((String)localObject1);
          parambu.aPs(localv.title);
          parambu.aPt(localv.hDo);
          localakd.b(parambu);
          localakd.f(com.tencent.mm.ai.m.a(localv, parambu, localu.dHo, localu.dHp));
          AppMethodBeat.o(30957);
          return true;
          localajn.wl(true);
        }
      }
      return false;
    }
    catch (Exception parambu)
    {
      ad.printErrStackTrace("MicroMsg.GetFavDataSource", parambu, "", new Object[0]);
      ad.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { parambu.getLocalizedMessage() });
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean e(cv paramcv, bu parambu)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramcv == null) || (parambu == null))
    {
      ad.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcv != null) {
        paramcv.dnG.dnL = 2131758885;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    parambu = bu.aN(parambu);
    if (parambu.isText()) {
      bool = f(paramcv, parambu);
    }
    for (;;)
    {
      paramcv.dnG.dnv = parambu.field_content;
      if ((bool) || (paramcv.dnG.dnL == 0)) {
        com.tencent.mm.plugin.fav.ui.e.a(parambu, paramcv, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (parambu.fph())
      {
        bool = h(paramcv, parambu);
      }
      else if (parambu.cTe())
      {
        bool = a(paramcv, parambu);
      }
      else if (parambu.fpi())
      {
        bool = g(paramcv, parambu);
      }
      else if ((parambu.cxf()) || (parambu.cxh()))
      {
        bool = j(paramcv, parambu);
      }
      else if (parambu.cxg())
      {
        bool = i(paramcv, parambu);
      }
      else if (parambu.fpd())
      {
        bool = d(paramcv, parambu);
      }
      else
      {
        if (parambu.frE()) {}
        while ((!parambu.cTc()) || (parambu.frH()))
        {
          paramcv.dnG.dnL = 2131758893;
          break;
        }
        bool = k(paramcv, parambu);
      }
    }
  }
  
  private static boolean f(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30947);
    akd localakd = new akd();
    localakd.a(aF(parambu));
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.desc = parambu.field_content;
    paramcv.dnG.type = 1;
    if (f.aXj(paramcv.dnG.desc) > com.tencent.mm.n.b.acd())
    {
      paramcv.dnG.dnL = 2131759022;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean g(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (parambu.field_msgId > 0L) {
      localObject1 = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, parambu.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (parambu.field_msgSvrId > 0L) {
        localObject2 = com.tencent.mm.aw.q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramcv.dnG.dnL = 2131758891;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new akd();
    ((akd)localObject1).a(aF(parambu));
    ajn localajn = new ajn();
    a(localajn, parambu);
    localajn.ZI(2);
    localajn.aOt(com.tencent.mm.aw.q.aIF().o(h.c((com.tencent.mm.aw.g)localObject2), "", ""));
    if (((com.tencent.mm.aw.g)localObject2).aIj())
    {
      localObject2 = com.tencent.mm.aw.q.aIF().pt(((com.tencent.mm.aw.g)localObject2).hZH);
      if (((com.tencent.mm.aw.g)localObject2).hMP > ((com.tencent.mm.aw.g)localObject2).offset) {
        localajn.aOt(com.tencent.mm.aw.q.aIF().o("SERVERID://" + parambu.field_msgSvrId, "", ""));
      }
    }
    localajn.aOu(com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true));
    localajn.aON(bl.Bt(parambu.eLs));
    parambu = new LinkedList();
    parambu.add(localajn);
    ((akd)localObject1).bl(parambu);
    paramcv.dnG.dnI = ((akd)localObject1);
    paramcv.dnG.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean h(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30951);
    akd localakd = new akd();
    localakd.a(aF(parambu));
    ajn localajn = new ajn();
    a(localajn, parambu);
    if (w.Aa(parambu.field_talker)) {
      localajn.aOt(aLw(parambu.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localajn.ZI(3);
      localajn.wl(true);
      localb = com.tencent.mm.modelvoice.s.HR(parambu.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localajn.aOt(com.tencent.mm.modelvoice.s.getFullPath(parambu.field_imgPath));
    }
    localajn.aOp(Yl(localb.getFormat()));
    localajn.ZH((int)new com.tencent.mm.modelvoice.p(parambu.field_content).time);
    parambu = new LinkedList();
    parambu.add(localajn);
    localakd.bl(parambu);
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean i(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.aA(parambu.field_content, parambu.field_reserved);
    if (localObject == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    akd localakd = new akd();
    localakd.a(aF(parambu));
    ajn localajn = new ajn();
    a(localajn, parambu);
    o.aMJ();
    localajn.aOu(t.Hi(parambu.field_imgPath));
    localajn.aOp(com.tencent.mm.vfs.i.ZF(localajn.Ghp));
    localajn.aOt("");
    localajn.aOo(((k.b)localObject).thumburl);
    ajv localajv = com.tencent.mm.ai.m.t(parambu);
    if (localajv == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localajn.ZH(localajv.duration);
    localajn.aOf(((k.b)localObject).title);
    localajn.aOl(((k.b)localObject).url);
    localajn.wk(true);
    localajn.wl(true);
    localObject = new ajo();
    if (parambu.cxg()) {
      ((ajo)localObject).e(localajv);
    }
    localajn.a((ajo)localObject);
    parambu = new LinkedList();
    parambu.add(localajn);
    localakd.bl(parambu);
    paramcv.dnG.dnI = localakd;
    paramcv.dnG.type = 4;
    localajn.ZI(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean j(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30954);
    akd localakd = new akd();
    localakd.a(aF(parambu));
    ajn localajn = new ajn();
    a(localajn, parambu);
    o.aMJ();
    localajn.aOu(t.Hi(parambu.field_imgPath));
    localajn.aOp(com.tencent.mm.vfs.i.ZF(localajn.Ghp));
    Object localObject = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    if (localObject == null)
    {
      ad.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    ad.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).hMP) });
    if (((com.tencent.mm.modelvideo.s)localObject).hMP > ((af)com.tencent.mm.kernel.g.ad(af.class)).getVideoSizeLimit(true))
    {
      paramcv.dnG.dnL = 2131759025;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((parambu.cxh()) && (com.tencent.mm.modelvideo.u.HA(((com.tencent.mm.modelvideo.s)localObject).getFileName())))
    {
      paramcv.dnG.dnL = 2131758884;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).aMY())
    {
      o.aMJ();
      String str = t.Hh(parambu.field_imgPath);
      ad.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { str });
      localajn.aOt(str);
      localajn.ZH(((com.tencent.mm.modelvideo.s)localObject).hHQ);
      localajn.aON(bl.Bt(parambu.eLs));
      localObject = new LinkedList();
      ((LinkedList)localObject).add(localajn);
      localakd.bl((LinkedList)localObject);
      paramcv.dnG.dnI = localakd;
      if (!parambu.cxh()) {
        break label469;
      }
      paramcv.dnG.type = 16;
      localajn.ZI(15);
    }
    for (;;)
    {
      paramcv = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      localajn.aOD(paramcv.dHv);
      paramcv = paramcv.iun;
      if ((paramcv != null) && (!bt.isNullOrNil(paramcv.hCk)))
      {
        parambu = new ajq();
        parambu.hCe = paramcv.hCe;
        parambu.Gje = paramcv.Gje;
        parambu.hCh = paramcv.hCh;
        parambu.hCi = paramcv.hCi;
        parambu.hCg = paramcv.hCg;
        parambu.hCj = paramcv.hCj;
        parambu.hCk = paramcv.hCk;
        parambu.hCl = paramcv.hCl;
        localajn.a(parambu);
      }
      AppMethodBeat.o(30954);
      return true;
      ad.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localajn.aOt("");
      break;
      label469:
      paramcv.dnG.type = 4;
      localajn.ZI(4);
    }
  }
  
  private static boolean k(cv paramcv, bu parambu)
  {
    AppMethodBeat.i(30956);
    akd localakd = new akd();
    localakd.a(aF(parambu));
    Object localObject1 = parambu.field_content;
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.yr((String)localObject1);
    if (localObject1 == null)
    {
      paramcv.dnG.dnL = 2131758895;
      AppMethodBeat.o(30956);
      return false;
    }
    paramcv.dnG.dnI = localakd;
    Object localObject2 = localakd.Gjv;
    ((akj)localObject2).aPl(((k.b)localObject1).appId);
    ((akj)localObject2).aPn(((k.b)localObject1).dHo);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramcv.dnG.dnL = 2131758893;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramcv.dnG.dnI = localakd;
      paramcv.dnG.desc = ((k.b)localObject1).title;
      paramcv.dnG.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bIX().aLD(((k.b)localObject1).dks);
      localObject2 = new ajn();
      a((ajn)localObject2, parambu);
      if (localObject3 != null) {
        ((ajn)localObject2).aOt(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      if (com.tencent.mm.vfs.i.fv((String)localObject3)) {
        ((ajn)localObject2).aOu((String)localObject3);
      }
      ((ajn)localObject2).ZI(2);
      ((ajn)localObject2).aOf(((k.b)localObject1).title);
      ((ajn)localObject2).aOg(((k.b)localObject1).description);
      ((ajn)localObject2).aON(bl.Bt(parambu.eLs));
      localakd.nZa.add(localObject2);
      paramcv.dnG.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      parambu = a(parambu, (k.b)localObject1, 7);
      localakd.nZa.add(parambu);
      paramcv.dnG.type = 7;
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(parambu, (k.b)localObject1, 4);
      localakd.aPd(((ajn)localObject1).title);
      localakd.aPe(((ajn)localObject1).desc);
      ((ajn)localObject1).aON(bl.Bt(parambu.eLs));
      localakd.nZa.add(localObject1);
      paramcv.dnG.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localakd.Gjv.aPm(((k.b)localObject1).url);
        localObject2 = new aks();
        ((aks)localObject2).aPv(((k.b)localObject1).thumburl);
        localObject3 = (ae)((k.b)localObject1).ao(ae.class);
        if ((localObject3 != null) && (!bt.isNullOrNil(((ae)localObject3).DBG)))
        {
          localObject4 = new StringBuilder();
          ((ae)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((aks)localObject2).aPx(((StringBuilder)localObject4).toString());
        }
        localakd.b((aks)localObject2);
        a(parambu, localakd, (aks)localObject2);
        parambu = a(parambu, (k.b)localObject1, 5);
        localakd.nZa.add(parambu);
        localakd.aPd(parambu.title);
        localakd.aPe(parambu.desc);
        paramcv.dnG.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramcv.dnG.dnL = 2131758889;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      parambu = (com.tencent.mm.plugin.i.a.b)((k.b)localObject1).ao(com.tencent.mm.plugin.i.a.b.class);
      if (parambu != null)
      {
        parambu = parambu.inc;
        localakd.aPd(parambu.nickname + aj.getContext().getString(2131759007));
        localakd.aPe(parambu.desc);
        localakd.d(parambu);
        paramcv.dnG.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758901;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.s.a.bIX().aLD(((k.b)localObject1).dks);
      localObject2 = new ajn();
      if (localObject3 != null) {
        ((ajn)localObject2).aOt(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((ajn)localObject2, parambu);
      ((ajn)localObject2).ZI(8);
      ((ajn)localObject2).aOp(((k.b)localObject1).hzP);
      parambu = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      if (bt.isNullOrNil(parambu)) {
        ((ajn)localObject2).wl(true);
      }
      if (com.tencent.mm.vfs.i.fv(parambu)) {
        ((ajn)localObject2).aOu(parambu);
      }
      ((ajn)localObject2).aOf(((k.b)localObject1).title);
      ((ajn)localObject2).aOg(((k.b)localObject1).description);
      localakd.nZa.add(localObject2);
      paramcv.dnG.desc = ((k.b)localObject1).title;
      paramcv.dnG.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).dks == null) || (((k.b)localObject1).dks.length() == 0)) {
        paramcv.dnG.dnL = 2131758886;
      }
      while (com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        paramcv.dnG.dnL = 2131758893;
        AppMethodBeat.o(30956);
        return false;
      }
      paramcv.dnG.dnL = 2131758901;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      parambu = new akc();
      parambu.aOY(((k.b)localObject1).title);
      parambu.aOZ(((k.b)localObject1).description);
      parambu.ZO(((k.b)localObject1).hAn);
      parambu.aPb(((k.b)localObject1).hAo);
      parambu.aPa(((k.b)localObject1).thumburl);
      paramcv.dnG.title = ((k.b)localObject1).title;
      paramcv.dnG.desc = ((k.b)localObject1).description;
      paramcv.dnG.type = 10;
      localakd.b(parambu);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      parambu = new akm();
      parambu.aPo(((k.b)localObject1).title);
      parambu.aPp(((k.b)localObject1).description);
      parambu.aPr(((k.b)localObject1).hAr);
      parambu.aPq(((k.b)localObject1).thumburl);
      paramcv.dnG.title = ((k.b)localObject1).title;
      paramcv.dnG.desc = ((k.b)localObject1).description;
      paramcv.dnG.type = 15;
      localakd.b(parambu);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      parambu = new akc();
      parambu.aOY(((k.b)localObject1).title);
      parambu.aOZ(((k.b)localObject1).description);
      parambu.ZO(((k.b)localObject1).hAt);
      parambu.aPb(((k.b)localObject1).hAu);
      parambu.aPa(((k.b)localObject1).thumburl);
      paramcv.dnG.title = ((k.b)localObject1).title;
      paramcv.dnG.desc = ((k.b)localObject1).description;
      paramcv.dnG.type = 11;
      localakd.b(parambu);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramcv.dnG.dnJ = new akr();
      bool = a(paramcv, (k.b)localObject1, localakd, parambu, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramcv.dnG.dnJ = new akr();
      bool = a(paramcv, (k.b)localObject1, localakd, parambu, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new ajl();
    ((ajl)localObject3).username = ((k.b)localObject1).hCn;
    ((ajl)localObject3).appId = ((k.b)localObject1).hCo;
    ((ajl)localObject3).dtF = ((k.b)localObject1).hCz;
    ((ajl)localObject3).iconUrl = ((k.b)localObject1).hCB;
    ((ajl)localObject3).dki = ((k.b)localObject1).hCm;
    ((ajl)localObject3).GgH = ((k.b)localObject1).dHp;
    ((ajl)localObject3).kro = ((k.b)localObject1).hCw;
    ((ajl)localObject3).type = ((k.b)localObject1).hCp;
    Object localObject4 = (com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class);
    if (localObject4 != null)
    {
      ((ajl)localObject3).jXI = ((com.tencent.mm.ai.a)localObject4).hyh;
      ((ajl)localObject3).dJW = ((com.tencent.mm.ai.a)localObject4).hyj;
      ((ajl)localObject3).subType = ((com.tencent.mm.ai.a)localObject4).hyk;
    }
    ((ajl)localObject3).version = ((k.b)localObject1).hCA;
    localObject4 = new ajn();
    a((ajn)localObject4, parambu);
    ((ajn)localObject4).ZI(19);
    String str = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
    if (bt.isNullOrNil(str)) {
      ((ajn)localObject4).wl(true);
    }
    if (com.tencent.mm.vfs.i.fv(str)) {
      ((ajn)localObject4).aOu(str);
    }
    ((ajn)localObject4).aOf(((k.b)localObject1).title);
    ((ajn)localObject4).aOg(((k.b)localObject1).description);
    localakd.nZa.add(localObject4);
    localakd.aPd(((k.b)localObject1).title);
    if (w.vF(parambu.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((akj)localObject2).ZR(i);
      paramcv.dnG.title = ((k.b)localObject1).title;
      paramcv.dnG.desc = ((k.b)localObject1).description;
      paramcv.dnG.type = 19;
      localakd.c((ajl)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static ajp q(ajn paramajn)
  {
    AppMethodBeat.i(30960);
    ajp localajp = new ajp();
    paramajn = paramajn.GhL.Gis;
    if (paramajn.GiR) {
      localajp.aOO(paramajn.dyU);
    }
    if (paramajn.GiS) {
      localajp.aOP(paramajn.toUser);
    }
    if (paramajn.GiW) {
      localajp.aOR(paramajn.GiV);
    }
    localajp.ZM(1);
    localajp.CJ(bt.flT());
    AppMethodBeat.o(30960);
    return localajp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.g
 * JD-Core Version:    0.7.0.1
 */