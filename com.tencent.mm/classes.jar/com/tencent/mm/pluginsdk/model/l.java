package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.m;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
{
  private static arf a(arf paramarf, boolean paramBoolean)
  {
    AppMethodBeat.i(30961);
    arf localarf = new arf();
    arg localarg = new arg();
    localarg.c(q(paramarf));
    localarg.d(paramarf.Zzy.WKx);
    localarf.a(localarg);
    localarf.bsJ(paramarf.ZzA);
    localarf.bsK(paramarf.ZzC);
    localarf.bsS(paramarf.ZzZ);
    localarf.bsT(paramarf.ZAb);
    localarf.Kk(true);
    localarf.Kj(true);
    localarf.bsL(paramarf.ZzG);
    localarf.axA(paramarf.ZzM);
    localarf.bsz(paramarf.ZyW);
    localarf.bsA(paramarf.ZyY);
    localarf.yo(paramarf.Zza);
    localarf.bsE(paramarf.QJs);
    localarf.bsF(paramarf.Zzi);
    localarf.yp(paramarf.Zzk);
    if (paramBoolean) {
      localarf.bsB(paramarf.hIQ);
    }
    AppMethodBeat.o(30961);
    return localarf;
  }
  
  private static arf a(cc paramcc, k.b paramb, int paramInt)
  {
    AppMethodBeat.i(30955);
    arf localarf = new arf();
    a(localarf, paramcc);
    localarf.bsv(paramb.nRx);
    localarf.bsw(paramb.nRy);
    localarf.bsu(paramb.url);
    localarf.Kj(true);
    paramcc = new com.tencent.mm.vfs.u(Util.nullAs(r.bKa().X(paramcc.field_imgPath, true), ""));
    if (paramcc.jKS()) {
      localarf.bsD(com.tencent.mm.vfs.ah.v(paramcc.jKT()));
    }
    for (;;)
    {
      localarf.bso(paramb.title);
      localarf.bsp(paramb.description);
      localarf.bsN(paramb.canvasPageXml);
      localarf.axy(paramInt);
      localarf.bsM(paramb.iah);
      paramcc = (com.tencent.mm.pluginsdk.ui.tools.b)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
      if (paramcc != null)
      {
        localarf.bsU(paramcc.songAlbumUrl);
        localarf.bsV(paramcc.songLyric);
        if (paramInt == 29)
        {
          paramb = new arg();
          dtj localdtj = new dtj();
          localdtj.YqN = paramcc.YqN;
          localdtj.YqO = paramcc.YqO;
          localdtj.YqP = paramcc.YqP;
          localdtj.YqQ = paramcc.YqQ;
          localdtj.singerName = paramcc.YqR;
          localdtj.albumName = paramcc.YqS;
          localdtj.musicGenre = paramcc.YqT;
          localdtj.issueDate = Util.safeParseLong(paramcc.YqU);
          localdtj.identification = paramcc.YqV;
          localdtj.LNC = paramcc.LNC;
          localdtj.extraInfo = paramcc.YqW;
          localdtj.musicOperationUrl = paramcc.YqX;
          localdtj.oOZ = paramcc.oOZ;
          paramb.e(localdtj);
          localarf.a(paramb);
        }
      }
      AppMethodBeat.o(30955);
      return localarf;
      localarf.Kk(true);
    }
  }
  
  private static void a(arf paramarf1, arf paramarf2)
  {
    AppMethodBeat.i(30962);
    paramarf1.bsv(paramarf2.ZyO);
    paramarf1.bsw(paramarf2.ZyQ);
    paramarf1.bsu(paramarf2.ZyM);
    paramarf1.bso(paramarf2.title);
    paramarf1.bsp(paramarf2.desc);
    AppMethodBeat.o(30962);
  }
  
  private static void a(arf paramarf, cc paramcc)
  {
    AppMethodBeat.i(30950);
    if (paramcc.field_isSend == 1)
    {
      if ((au.bwE(paramcc.field_talker)) || (paramcc.field_talker.equals("filehelper")))
      {
        paramarf.bsG(String.valueOf(paramcc.field_msgSvrId));
        AppMethodBeat.o(30950);
        return;
      }
      paramarf.bsG(paramcc.field_talker + "#" + String.valueOf(paramcc.field_msgSvrId));
      AppMethodBeat.o(30950);
      return;
    }
    paramarf.bsG(String.valueOf(paramcc.field_msgSvrId));
    AppMethodBeat.o(30950);
  }
  
  private static void a(cc paramcc, arv paramarv, ask paramask)
  {
    AppMethodBeat.i(30958);
    paramarv.f(m.a(paramcc, paramask));
    AppMethodBeat.o(30958);
  }
  
  private static void a(boolean paramBoolean, cc paramcc, k.b paramb, dn paramdn, arv paramarv)
  {
    AppMethodBeat.i(244820);
    int i;
    if (paramBoolean) {
      i = 29;
    }
    for (int j = 21;; j = 7)
    {
      paramcc = a(paramcc, paramb, i);
      paramarv.vEn.add(paramcc);
      paramdn.hDr.type = j;
      AppMethodBeat.o(244820);
      return;
      i = 7;
    }
  }
  
  public static boolean a(dn paramdn, int paramInt, String paramString)
  {
    AppMethodBeat.i(30943);
    if ((paramdn == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdn != null) {
        paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30943);
      return false;
    }
    Log.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.axy(2);
    localarf.bsC(paramString);
    localarf.bsB(com.tencent.mm.b.g.getMessageDigest((localarf.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new ht();
    ((ht)localObject).hIR.type = 27;
    ((ht)localObject).hIR.hIT = localarf;
    ((ht)localObject).publish();
    localObject = ((ht)localObject).hIS.thumbPath;
    BitmapUtil.createThumbNail(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject, true);
    localarf.bsD((String)localObject);
    localasb.bto(com.tencent.mm.model.z.bAM());
    localasb.btp(com.tencent.mm.model.z.bAM());
    localasb.axH(paramInt);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    paramdn.hDr.title = localarf.title;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 2;
    AppMethodBeat.o(30943);
    return true;
  }
  
  public static boolean a(dn paramdn, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, boolean paramBoolean)
  {
    AppMethodBeat.i(244746);
    if ((paramdn == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdn != null) {
        paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(244746);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString3, paramString4, paramString1, Integer.valueOf(paramInt1) });
    if (new com.tencent.mm.vfs.u(paramString1).length() > ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getVideoSizeLimit(paramBoolean))
    {
      paramdn.hDr.hDx = R.l.favorite_too_large_format;
      AppMethodBeat.o(244746);
      return false;
    }
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.bsC(paramString1);
    localarf.axy(4);
    localarf.bsy(com.tencent.mm.vfs.y.alV(paramString1));
    localarf.bsD(paramString2);
    localarf.axx(paramInt2);
    localarf.bso(paramString3);
    localarf.bsp(paramString4);
    localasb.bto(com.tencent.mm.model.z.bAM());
    localasb.btp(com.tencent.mm.model.z.bAM());
    localasb.axH(paramInt1);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    paramdn.hDr.title = localarf.title;
    paramdn.hDr.desc = localarf.title;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 4;
    AppMethodBeat.o(244746);
    return true;
  }
  
  public static boolean a(dn paramdn, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(244754);
    if ((paramdn == null) || (Util.isNullOrNil(paramString1)))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      if (paramdn != null) {
        paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(244754);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(paramInt) });
    if (new com.tencent.mm.vfs.u(paramString1).length() > ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFileSizeLimit(paramBoolean))
    {
      paramdn.hDr.hDx = R.l.favorite_too_large_format;
      AppMethodBeat.o(244754);
      return false;
    }
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.bsC(paramString1);
    localarf.axy(8);
    localarf.bsy(com.tencent.mm.vfs.y.alV(paramString1));
    localarf.Kk(true);
    localarf.bso(paramString2);
    localarf.bsp(paramString3);
    localasb.bto(com.tencent.mm.model.z.bAM());
    localasb.btp(com.tencent.mm.model.z.bAM());
    localasb.axH(paramInt);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    localarv.vEn.add(localarf);
    paramdn.hDr.title = localarf.title;
    paramdn.hDr.desc = localarf.title;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 8;
    AppMethodBeat.o(244754);
    return true;
  }
  
  public static boolean a(dn paramdn, long paramLong)
  {
    AppMethodBeat.i(30944);
    boolean bool = d(paramdn, ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramLong));
    AppMethodBeat.o(30944);
    return bool;
  }
  
  public static boolean a(dn paramdn, Intent paramIntent)
  {
    AppMethodBeat.i(30940);
    if (paramdn == null)
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
    paramIntent = new arm();
    paramIntent.btf((String)localObject1);
    paramIntent.W(d1);
    paramIntent.V(d2);
    paramIntent.axD(i);
    paramIntent.btg((String)localObject2);
    localObject1 = new arv();
    localObject2 = new asb();
    String str = com.tencent.mm.model.z.bAM();
    ((asb)localObject2).bto(str);
    ((asb)localObject2).btp(str);
    ((asb)localObject2).axH(6);
    ((asb)localObject2).yu(Util.nowMilliSecond());
    ((arv)localObject1).d(paramIntent);
    ((arv)localObject1).a((asb)localObject2);
    paramdn.hDr.hDt = ((arv)localObject1);
    paramdn.hDr.type = 6;
    AppMethodBeat.o(30940);
    return true;
  }
  
  private static boolean a(dn paramdn, k.b paramb, arv paramarv, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(30959);
    Object localObject = new tr();
    ((tr)localObject).hXt.type = 0;
    ((tr)localObject).hXt.hXv = paramb.nRF;
    ((tr)localObject).publish();
    com.tencent.mm.protocal.b.a.c localc = ((tr)localObject).hXu.hXD;
    if (localc == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30959);
      return false;
    }
    paramarv.btm(localc.title);
    Iterator localIterator = localc.nUC.iterator();
    int i = 0;
    arf localarf;
    if (localIterator.hasNext())
    {
      localarf = (arf)localIterator.next();
      switch (localarf.dataType)
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
      case 30: 
      default: 
        paramb = null;
        label274:
        if (paramb != null) {
          if (paramcc.field_isSend == 1) {
            if ((au.bwE(paramcc.field_talker)) || (paramcc.field_talker.equals("filehelper")))
            {
              localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId), Integer.valueOf(i) });
              label339:
              paramb.bsG((String)localObject);
              paramb.bsW(localarf.pbn);
              paramarv.vEn.add(paramb);
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
      long l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      paramb.axy(3);
      if (!Util.isNullOrNil(localarf.ZzG))
      {
        localObject = new tr();
        ((tr)localObject).hXt.type = 1;
        ((tr)localObject).hXt.hIy = localarf;
        ((tr)localObject).hXt.msgId = l;
        ((tr)localObject).publish();
        if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        paramb.bsC(((tr)localObject).hXu.dataPath);
        paramb.axx(localarf.duration);
        paramb.Kk(true);
        paramb.Kj(false);
        paramb.bsy(localarf.ZyU);
      }
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBJ += 1;
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.axy(1);
      paramb.bsp(localarf.desc);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBI += 1;
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      paramb.axy(2);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      paramb.bsC(((tr)localObject).hXu.dataPath);
      paramb.bsD(((tr)localObject).hXu.thumbPath);
      paramb.Kk(false);
      paramb.Kj(false);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).PTe += 1;
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      a(paramb, localarf);
      paramb.axy(5);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      paramb.bsD(((tr)localObject).hXu.thumbPath);
      paramb.Kk(false);
      if ((localarf.Zzy != null) && (localarf.Zzy.ZAj != null))
      {
        localObject = new ask();
        ((ask)localObject).btB(localarf.Zzy.ZAj.title);
        ((ask)localObject).btC(localarf.Zzy.ZAj.desc);
        ((ask)localObject).btE(localarf.Zzy.ZAj.thumbUrl);
        ((ask)localObject).axI(localarf.Zzy.ZAj.ZBX);
        ((ask)localObject).btD(localarf.Zzy.ZAj.ZBV);
        ((ask)localObject).axK(localarf.Zzy.ZAj.pdq);
        paramb.Zzy.b((ask)localObject);
      }
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBK += 1;
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.bso(localarf.title);
      paramb.bsp(localarf.desc);
      paramb.Zzy.g(localarf.Zzy.ZAB);
      paramb.axy(22);
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      a(paramb, localarf);
      if (localarf.dataType == 15) {
        paramb.axy(15);
      }
      for (;;)
      {
        localObject = new tr();
        ((tr)localObject).hXt.type = 1;
        ((tr)localObject).hXt.hIy = localarf;
        ((tr)localObject).hXt.msgId = l;
        ((tr)localObject).publish();
        if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
          Log.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        paramb.Kj(false);
        paramb.bsC(((tr)localObject).hXu.dataPath);
        paramb.a(localarf.Zzy);
        paramb.Kk(false);
        paramb.bsD(((tr)localObject).hXu.thumbPath);
        paramb.axx(localarf.duration);
        localObject = paramdn.hDr.hDu;
        ((asj)localObject).AXs += 1;
        break;
        paramb.axy(4);
      }
      paramb = a(localarf, paramBoolean);
      paramb.axy(6);
      if ((localarf.Zzy != null) && (localarf.Zzy.ZAh != null))
      {
        localObject = new arm();
        ((arm)localObject).btf(localarf.Zzy.ZAh.label);
        ((arm)localObject).W(localarf.Zzy.ZAh.lat);
        ((arm)localObject).V(localarf.Zzy.ZAh.lng);
        ((arm)localObject).axD(localarf.Zzy.ZAh.hQp);
        ((arm)localObject).btg(localarf.Zzy.ZAh.hVI);
        paramb.Zzy.c((arm)localObject);
      }
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBL += 1;
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      a(paramb, localarf);
      paramb.bsU(localarf.songAlbumUrl);
      paramb.bsV(localarf.songLyric);
      paramb.axy(7);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bsD(((tr)localObject).hXu.thumbPath);
      paramb.Kk(false);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBM += 1;
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      a(paramb, localarf);
      if ((localarf != null) && (localarf.Zzy != null)) {
        paramb.Zzy.e(localarf.Zzy.ZAJ);
      }
      paramb.bsU(localarf.songAlbumUrl);
      paramb.bsV(localarf.songLyric);
      paramb.axy(29);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      paramb.bsD(((tr)localObject).hXu.thumbPath);
      paramb.Kk(false);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBM += 1;
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      a(paramb, localarf);
      paramb.axy(8);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if ((Util.isNullOrNil(((tr)localObject).hXu.dataPath)) && (Util.isNullOrNil(((tr)localObject).hXu.thumbPath))) {
        Log.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      paramb.bsC(((tr)localObject).hXu.dataPath);
      paramb.bsD(((tr)localObject).hXu.thumbPath);
      paramb.Kj(false);
      paramb.bsy(localarf.ZyU);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBN += 1;
      break label274;
      paramb = b(localarf, localarf.dataType, paramBoolean);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBP += 1;
      break label274;
      paramb = b(localarf, localarf.dataType, paramBoolean);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBQ += 1;
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.axy(14);
      if ((localarf.Zzy != null) && (localarf.Zzy.ZAn != null))
      {
        localObject = new ase();
        ((ase)localObject).btx(localarf.Zzy.ZAn.title);
        ((ase)localObject).bty(localarf.Zzy.ZAn.desc);
        ((ase)localObject).btA(localarf.Zzy.ZAn.hZn);
        ((ase)localObject).btz(localarf.Zzy.ZAn.thumbUrl);
        paramb.Zzy.a((ase)localObject);
      }
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBT += 1;
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.axy(16);
      paramb.bsp(localarf.desc);
      localObject = paramdn.hDr.hDu;
      ((asj)localObject).ZBU += 1;
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.axy(31);
      paramb.bsp(localarf.desc);
      break label274;
      paramb = a(localarf, paramBoolean);
      paramb.bso(localarf.title);
      paramb.bsp(localarf.desc);
      paramb.axy(17);
      paramb.bsO(localarf.ZzO);
      break label274;
      l = paramcc.field_msgId;
      paramb = a(localarf, paramBoolean);
      paramb.bso(localarf.title);
      paramb.bsp(localarf.desc);
      paramb.axy(19);
      localObject = new tr();
      ((tr)localObject).hXt.type = 1;
      ((tr)localObject).hXt.hIy = localarf;
      ((tr)localObject).hXt.msgId = l;
      ((tr)localObject).publish();
      if (Util.isNullOrNil(((tr)localObject).hXu.thumbPath)) {
        Log.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
      }
      for (;;)
      {
        if ((localarf.Zzy != null) && (localarf.Zzy.ZAw != null))
        {
          localObject = new ard();
          ((ard)localObject).username = localarf.Zzy.ZAw.username;
          ((ard)localObject).appId = localarf.Zzy.ZAw.appId;
          ((ard)localObject).hJK = localarf.Zzy.ZAw.hJK;
          ((ard)localObject).iconUrl = localarf.Zzy.ZAw.iconUrl;
          ((ard)localObject).type = localarf.Zzy.ZAw.type;
          ((ard)localObject).hzy = localarf.Zzy.ZAw.hzy;
          ((ard)localObject).Zyw = localarf.Zzy.ZAw.Zyw;
          ((ard)localObject).version = localarf.Zzy.ZAw.version;
          ((ard)localObject).nOX = localarf.Zzy.ZAw.nOX;
          ((ard)localObject).rxs = localarf.Zzy.ZAw.rxs;
          ((ard)localObject).idf = localarf.Zzy.ZAw.idf;
          paramb.Zzy.b((ard)localObject);
        }
        break;
        paramb.Kk(false);
        paramb.bsD(((tr)localObject).hXu.thumbPath);
      }
      paramb = a(localarf, paramBoolean);
      paramb.axy(20);
      paramb.axx(localarf.duration);
      break label274;
      localObject = String.format("%s#%d$%d", new Object[] { paramcc.field_talker, Long.valueOf(paramcc.field_msgSvrId), Integer.valueOf(i) });
      break label339;
      localObject = String.format("%d$%d", new Object[] { Long.valueOf(paramcc.field_msgSvrId), Integer.valueOf(i) });
      break label339;
      if (com.tencent.mm.plugin.fav.ui.l.j((arf)localc.nUC.get(0))) {}
      for (paramdn.hDr.type = 18;; paramdn.hDr.type = 14)
      {
        AppMethodBeat.o(30959);
        return true;
      }
    }
  }
  
  private static boolean a(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30949);
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    paramcc = XmlParser.parseXml(paramcc.field_content, "msg", null);
    if (paramcc != null) {
      try
      {
        arm localarm = new arm();
        localarm.btf((String)paramcc.get(".msg.location.$label"));
        localarm.W(Double.parseDouble((String)paramcc.get(".msg.location.$x")));
        localarm.V(Double.parseDouble((String)paramcc.get(".msg.location.$y")));
        localarm.axD(Integer.valueOf((String)paramcc.get(".msg.location.$scale")).intValue());
        localarm.btg((String)paramcc.get(".msg.location.$poiname"));
        localarv.d(localarm);
        paramdn.hDr.type = 6;
        paramdn.hDr.hDt = localarv;
        AppMethodBeat.o(30949);
        return true;
      }
      catch (Exception paramcc)
      {
        Log.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { paramcc.getStackTrace().toString() });
      }
    }
    paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
    AppMethodBeat.o(30949);
    return false;
  }
  
  public static String avF(int paramInt)
  {
    if (paramInt == 1) {
      return "speex";
    }
    if (paramInt == 4) {
      return "silk";
    }
    return "amr";
  }
  
  private static arf b(arf paramarf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30963);
    arf localarf = a(paramarf, paramBoolean);
    localarf.axy(paramInt);
    if ((paramarf.Zzy != null) && (paramarf.Zzy.ZAl != null))
    {
      aru localaru = new aru();
      localaru.bth(paramarf.Zzy.ZAl.title);
      localaru.bti(paramarf.Zzy.ZAl.desc);
      localaru.axE(paramarf.Zzy.ZAl.type);
      localaru.btk(paramarf.Zzy.ZAl.hZn);
      localaru.btj(paramarf.Zzy.ZAl.thumbUrl);
      localarf.Zzy.a(localaru);
    }
    AppMethodBeat.o(30963);
    return localarf;
  }
  
  public static boolean b(dn paramdn, String paramString, int paramInt)
  {
    AppMethodBeat.i(30942);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      AppMethodBeat.o(30942);
      return false;
    }
    Log.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    arv localarv = new arv();
    asb localasb = new asb();
    localasb.bto(com.tencent.mm.model.z.bAM());
    localasb.btp(com.tencent.mm.model.z.bAM());
    localasb.axH(paramInt);
    localasb.yu(Util.nowMilliSecond());
    localarv.a(localasb);
    paramdn.hDr.desc = paramString;
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 1;
    AppMethodBeat.o(30942);
    return true;
  }
  
  private static String bpu(String paramString)
  {
    AppMethodBeat.i(30952);
    paramString = FilePathGenerator.genPath(com.tencent.mm.plugin.record.c.bzO(), "recbiz_", paramString, ".rec", 2);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(30952);
      return null;
    }
    if (new com.tencent.mm.vfs.u(paramString).jKS())
    {
      AppMethodBeat.o(30952);
      return paramString;
    }
    AppMethodBeat.o(30952);
    return paramString;
  }
  
  private static asb bw(cc paramcc)
  {
    AppMethodBeat.i(30946);
    asb localasb = new asb();
    if (paramcc.field_isSend == 1)
    {
      localasb.bto(com.tencent.mm.model.z.bAM());
      localasb.btp(paramcc.field_talker);
      if (au.bwE(paramcc.field_talker)) {
        localasb.btr(localasb.hQQ);
      }
    }
    do
    {
      localasb.axH(1);
      localasb.yu(paramcc.getCreateTime());
      localasb.bts(paramcc.field_msgSvrId);
      if (paramcc.field_msgSvrId > 0L) {
        localasb.btq(paramcc.field_msgSvrId);
      }
      AppMethodBeat.o(30946);
      return localasb;
      localasb.bto(paramcc.field_talker);
      localasb.btp(com.tencent.mm.model.z.bAM());
    } while (!au.bwE(paramcc.field_talker));
    if (paramcc.field_content != null) {}
    for (String str = paramcc.field_content.substring(0, Math.max(0, paramcc.field_content.indexOf(':')));; str = "")
    {
      localasb.btr(str);
      if ((Util.isNullOrNil(localasb.ZAT)) || (paramcc.iYj())) {
        break;
      }
      paramcc.setContent(paramcc.field_content.substring(localasb.ZAT.length() + 1));
      if ((paramcc.field_content.length() > 0) && ('\n' == paramcc.field_content.charAt(0))) {
        paramcc.setContent(paramcc.field_content.substring(1));
      }
      if (!paramcc.jbT()) {
        break;
      }
      if ((!Util.isNullOrNil(paramcc.field_transContent)) && (paramcc.field_transContent.startsWith(localasb.ZAT))) {
        paramcc.BV(paramcc.field_transContent.substring(localasb.ZAT.length() + 1));
      }
      if ((paramcc.field_transContent.length() <= 0) || ('\n' != paramcc.field_transContent.charAt(0))) {
        break;
      }
      paramcc.BV(paramcc.field_transContent.substring(1));
      break;
    }
  }
  
  private static boolean c(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30957);
    arv localarv = new arv();
    Object localObject1 = bw(paramcc);
    localarv.a((asb)localObject1);
    try
    {
      com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
      Object localObject2 = localu.nUC;
      ((asb)localObject1).btw(localu.iaa);
      if ((localObject2 != null) && (((List)localObject2).size() > paramdn.hDr.hDv))
      {
        Log.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramdn.hDr.hDv) });
        com.tencent.mm.message.v localv = (com.tencent.mm.message.v)((List)localObject2).get(paramdn.hDr.hDv);
        if (m.Hh(localv.nUR))
        {
          paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
          AppMethodBeat.o(30957);
          return false;
        }
        ((asb)localObject1).btv(localv.url);
        if (paramdn.hDr.hDv > 0) {
          ((asb)localObject1).btq("");
        }
        arf localarf = new arf();
        localarf.bso(localv.title);
        localarf.bsp(localv.nUO);
        a(localarf, paramcc);
        localObject2 = m.a(localv);
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          paramcc = q.bFE().LS(paramcc.field_talker);
          localObject1 = localObject2;
          if (paramcc != null) {
            localObject1 = paramcc.bFw();
          }
        }
        if (!Util.isNullOrNil((String)localObject1))
        {
          localarf.bsD(y.bpF((String)localObject1));
          localarf.Kk(false);
          if ((Util.isNullOrNil(localarf.Zzf)) || (!com.tencent.mm.vfs.y.ZC(localarf.Zzf)))
          {
            localarf.bsx((String)localObject1);
            localarf.Kk(true);
          }
        }
        for (;;)
        {
          localarf.Kj(true);
          localarf.axy(5);
          localarv.vEn.add(localarf);
          paramdn.hDr.hDt = localarv;
          paramdn.hDr.desc = localv.title;
          paramdn.hDr.type = 5;
          paramcc = new ask();
          paramcc.btE((String)localObject1);
          paramcc.btB(localv.title);
          paramcc.btC(localv.nUO);
          localarv.c(paramcc);
          localarv.f(m.a(localv, paramcc, localu.iaa, localu.iab));
          AppMethodBeat.o(30957);
          return true;
          localarf.Kk(true);
        }
      }
      return false;
    }
    catch (Exception paramcc)
    {
      Log.printErrStackTrace("MicroMsg.GetFavDataSource", paramcc, "", new Object[0]);
      Log.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { paramcc.getLocalizedMessage() });
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30957);
    }
  }
  
  public static boolean d(dn paramdn, cc paramcc)
  {
    boolean bool = false;
    AppMethodBeat.i(30945);
    if ((paramdn == null) || (paramcc == null))
    {
      Log.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = R.l.favorite_fail_argument_error;
      }
      AppMethodBeat.o(30945);
      return false;
    }
    paramcc = cc.bI(paramcc);
    if (paramcc.iYl()) {
      bool = e(paramdn, paramcc);
    }
    for (;;)
    {
      paramdn.hDr.hDd = paramcc.field_content;
      if ((bool) || (paramdn.hDr.hDx == 0)) {
        e.a(paramcc, paramdn, bool);
      }
      AppMethodBeat.o(30945);
      return bool;
      if (paramcc.iYj())
      {
        bool = g(paramdn, paramcc);
      }
      else if (paramcc.fxT())
      {
        bool = a(paramdn, paramcc);
      }
      else if (paramcc.iYk())
      {
        bool = f(paramdn, paramcc);
      }
      else if ((paramcc.dSH()) || (paramcc.dSJ()))
      {
        bool = i(paramdn, paramcc);
      }
      else if (paramcc.dSI())
      {
        bool = h(paramdn, paramcc);
      }
      else if (paramcc.iYe())
      {
        bool = c(paramdn, paramcc);
      }
      else
      {
        if ((paramcc.jbB()) || (paramcc.jbC())) {}
        while ((!paramcc.fxR()) || (paramcc.jbH()))
        {
          paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
          break;
        }
        bool = j(paramdn, paramcc);
      }
    }
  }
  
  private static boolean e(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30947);
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.desc = paramcc.field_content;
    paramdn.hDr.type = 1;
    if (com.tencent.mm.ui.tools.g.bCx(paramdn.hDr.desc) > com.tencent.mm.k.c.aRe())
    {
      paramdn.hDr.hDx = R.l.favorite_text_length_over_limit;
      AppMethodBeat.o(30947);
      return false;
    }
    AppMethodBeat.o(30947);
    return true;
  }
  
  private static boolean f(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30948);
    Object localObject1 = null;
    if (paramcc.field_msgId > 0L) {
      localObject1 = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
    }
    else
    {
      localObject2 = localObject1;
      if (paramcc.field_msgSvrId > 0L) {
        localObject2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
      }
    }
    if (localObject2 == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
      paramdn.hDr.hDx = R.l.favorite_fail_image_not_exists;
      AppMethodBeat.o(30948);
      return false;
    }
    localObject1 = new arv();
    ((arv)localObject1).a(bw(paramcc));
    arf localarf = new arf();
    a(localarf, paramcc);
    localarf.axy(2);
    localarf.bsC(r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", ""));
    if (((com.tencent.mm.modelimage.h)localObject2).bJE())
    {
      localObject2 = r.bKa().wq(((com.tencent.mm.modelimage.h)localObject2).oGB);
      if (((com.tencent.mm.modelimage.h)localObject2).osy > ((com.tencent.mm.modelimage.h)localObject2).offset) {
        localarf.bsC(r.bKa().v("SERVERID://" + paramcc.field_msgSvrId, "", ""));
      }
    }
    localarf.bsD(r.bKa().X(paramcc.field_imgPath, true));
    localarf.bsW(bt.JV(paramcc.jUr));
    paramcc = new LinkedList();
    paramcc.add(localarf);
    ((arv)localObject1).cs(paramcc);
    paramdn.hDr.hDt = ((arv)localObject1);
    paramdn.hDr.type = 2;
    AppMethodBeat.o(30948);
    return true;
  }
  
  private static boolean g(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30951);
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    arf localarf = new arf();
    a(localarf, paramcc);
    if (au.bwm(paramcc.field_talker)) {
      localarf.bsC(bpu(paramcc.field_imgPath));
    }
    com.tencent.mm.modelvoice.b localb;
    for (;;)
    {
      localarf.axy(3);
      localarf.Kk(true);
      localb = s.QH(paramcc.field_imgPath);
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(30951);
      return false;
      localarf.bsC(s.getFullPath(paramcc.field_imgPath));
    }
    localarf.bsy(avF(localb.getFormat()));
    localarf.axx((int)new p(paramcc.field_content).time);
    paramcc = new LinkedList();
    paramcc.add(localarf);
    localarv.cs(paramcc);
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 3;
    AppMethodBeat.o(30951);
    return true;
  }
  
  private static boolean h(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30953);
    Object localObject = k.b.aP(paramcc.field_content, paramcc.field_reserved);
    if (localObject == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo content is null");
      AppMethodBeat.o(30953);
      return false;
    }
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    arf localarf = new arf();
    a(localarf, paramcc);
    com.tencent.mm.modelvideo.v.bOh();
    localarf.bsD(aa.PY(paramcc.field_imgPath));
    localarf.bsy(com.tencent.mm.vfs.y.alV(localarf.Zzd));
    localarf.bsC("");
    localarf.bsx(((k.b)localObject).thumburl);
    arn localarn = m.x(paramcc);
    if (localarn == null)
    {
      Log.w("MicroMsg.GetFavDataSource", "doFillMpVideoEventInfo favMpMsgItem is null");
      AppMethodBeat.o(30953);
      return false;
    }
    localarf.axx(localarn.duration);
    localarf.bso(((k.b)localObject).title);
    localarf.bsu(((k.b)localObject).url);
    localarf.Kj(true);
    localarf.Kk(true);
    localObject = new arg();
    if (paramcc.dSI()) {
      ((arg)localObject).e(localarn);
    }
    localarf.a((arg)localObject);
    paramcc = new LinkedList();
    paramcc.add(localarf);
    localarv.cs(paramcc);
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.type = 4;
    localarf.axy(4);
    AppMethodBeat.o(30953);
    return true;
  }
  
  private static boolean i(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30954);
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    arf localarf = new arf();
    a(localarf, paramcc);
    com.tencent.mm.modelvideo.v.bOh();
    localarf.bsD(aa.PY(paramcc.field_imgPath));
    localarf.bsy(com.tencent.mm.vfs.y.alV(localarf.Zzd));
    if (paramcc.dSJ())
    {
      paramdn.hDr.type = 16;
      localarf.axy(15);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = ab.Qo(paramcc.field_imgPath);
      if (localObject2 != null) {
        break;
      }
      Log.w("MicroMsg.GetFavDataSource", "[doFileFavVideoEventInfo] null == info");
      paramdn.hDr.hDx = R.l.favorite_fail;
      AppMethodBeat.o(30954);
      return false;
      paramdn.hDr.type = 4;
      localarf.axy(4);
    }
    com.tencent.mm.modelvideo.z localz = ab.Qo(((com.tencent.mm.modelvideo.z)localObject2).oYk);
    Object localObject1 = localObject2;
    if (localz != null)
    {
      localObject1 = localObject2;
      if (localz.status == 199)
      {
        Log.i("MicroMsg.GetFavDataSource", "origin video length is %d", new Object[] { Integer.valueOf(localz.osy) });
        localObject1 = localz;
      }
    }
    Log.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.z)localObject1).osy) });
    if (((com.tencent.mm.modelvideo.z)localObject1).osy > ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getVideoSizeLimit(true))
    {
      paramdn.hDr.hDx = R.l.favorite_too_large_format;
      AppMethodBeat.o(30954);
      return false;
    }
    if ((paramcc.dSJ()) && (ab.Qp(paramcc.field_imgPath)))
    {
      paramdn.hDr.hDx = R.l.favorite_fail;
      AppMethodBeat.o(30954);
      return false;
    }
    if (((com.tencent.mm.modelvideo.z)localObject1).bOx())
    {
      com.tencent.mm.modelvideo.v.bOh();
      localObject2 = aa.PX(((com.tencent.mm.modelvideo.z)localObject1).getFileName());
      Log.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { localObject2 });
      localarf.bsC((String)localObject2);
    }
    for (;;)
    {
      localarf.axx(((com.tencent.mm.modelvideo.z)localObject1).omT);
      localarf.bsW(bt.JV(paramcc.jUr));
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(localarf);
      localarv.cs((LinkedList)localObject1);
      paramdn.hDr.hDt = localarv;
      paramdn = ab.Qo(paramcc.field_imgPath);
      localarf.bsM(paramdn.iah);
      paramdn = paramdn.pbk;
      if ((paramdn != null) && (!Util.isNullOrNil(paramdn.nTA)))
      {
        paramcc = new ari();
        paramcc.nTu = paramdn.nTu;
        paramcc.ZBc = paramdn.ZBc;
        paramcc.nTx = paramdn.nTx;
        paramcc.nTy = paramdn.nTy;
        paramcc.nTw = paramdn.nTw;
        paramcc.nTz = paramdn.nTz;
        paramcc.nTA = paramdn.nTA;
        paramcc.nTB = paramdn.nTB;
        localarf.a(paramcc);
      }
      AppMethodBeat.o(30954);
      return true;
      Log.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
      localarf.bsC("");
    }
  }
  
  private static boolean j(dn paramdn, cc paramcc)
  {
    AppMethodBeat.i(30956);
    arv localarv = new arv();
    localarv.a(bw(paramcc));
    Object localObject1 = paramcc.field_content;
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30956);
      return false;
    }
    localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 == null)
    {
      paramdn.hDr.hDx = R.l.favorite_fail_parse_error;
      AppMethodBeat.o(30956);
      return false;
    }
    paramdn.hDr.hDt = localarv;
    Object localObject2 = localarv.ZBt;
    ((asb)localObject2).btu(((k.b)localObject1).appId);
    ((asb)localObject2).btw(((k.b)localObject1).iaa);
    boolean bool;
    switch (((k.b)localObject1).type)
    {
    default: 
      paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
      AppMethodBeat.o(30956);
      return false;
    case 1: 
    case 53: 
    case 57: 
    case 60: 
      paramdn.hDr.hDt = localarv;
      paramdn.hDr.desc = ((k.b)localObject1).title;
      paramdn.hDr.type = 1;
      AppMethodBeat.o(30956);
      return true;
    case 2: 
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.openapi.a.cWJ().bpI(((k.b)localObject1).hzM);
      localObject2 = new arf();
      a((arf)localObject2, paramcc);
      if (localObject3 != null) {
        ((arf)localObject2).bsC(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      localObject3 = r.bKa().X(paramcc.field_imgPath, true);
      if (com.tencent.mm.vfs.y.ZC((String)localObject3)) {
        ((arf)localObject2).bsD((String)localObject3);
      }
      ((arf)localObject2).axy(2);
      ((arf)localObject2).bso(((k.b)localObject1).title);
      ((arf)localObject2).bsp(((k.b)localObject1).description);
      ((arf)localObject2).bsW(bt.JV(paramcc.jUr));
      localarv.vEn.add(localObject2);
      paramdn.hDr.type = 2;
      AppMethodBeat.o(30956);
      return true;
    case 3: 
      a(false, paramcc, (k.b)localObject1, paramdn, localarv);
      AppMethodBeat.o(30956);
      return true;
    case 76: 
      a(true, paramcc, (k.b)localObject1, paramdn, localarv);
      AppMethodBeat.o(30956);
      return true;
    case 4: 
      localObject1 = a(paramcc, (k.b)localObject1, 4);
      localarv.btm(((arf)localObject1).title);
      localarv.btn(((arf)localObject1).desc);
      ((arf)localObject1).bsW(bt.JV(paramcc.jUr));
      localarv.vEn.add(localObject1);
      paramdn.hDr.type = 4;
      AppMethodBeat.o(30956);
      return true;
    case 5: 
      if ((((k.b)localObject1).url != null) && (!((k.b)localObject1).url.equals("")))
      {
        localarv.ZBt.btv(((k.b)localObject1).url);
        localObject2 = new ask();
        ((ask)localObject2).btE(((k.b)localObject1).thumburl);
        ((ask)localObject2).axK(((k.b)localObject1).nUb);
        localObject3 = (ak)((k.b)localObject1).aK(ak.class);
        if ((localObject3 != null) && (!Util.isNullOrNil(((ak)localObject3).WoZ)))
        {
          localObject4 = new StringBuilder();
          ((ak)localObject3).a((StringBuilder)localObject4, null, null, null, 0, 0);
          ((ask)localObject2).btG(((StringBuilder)localObject4).toString());
        }
        localarv.c((ask)localObject2);
        a(paramcc, localarv, (ask)localObject2);
        paramcc = a(paramcc, (k.b)localObject1, 5);
        localarv.vEn.add(paramcc);
        localarv.btm(paramcc.title);
        localarv.btn(paramcc.desc);
        paramdn.hDr.type = 5;
        AppMethodBeat.o(30956);
        return true;
      }
      paramdn.hDr.hDx = R.l.favorite_fail_empty_url;
      AppMethodBeat.o(30956);
      return false;
    case 51: 
      paramcc = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.f.class);
      if (paramcc != null)
      {
        localObject1 = paramcc.oUc;
        localarv.btm(paramcc.getNickname() + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail));
        localarv.btn(((bvl)localObject1).desc);
        localarv.h((bvl)localObject1);
        paramdn.hDr.type = 20;
        AppMethodBeat.o(30956);
        return true;
      }
      AppMethodBeat.o(30956);
      return false;
    case 6: 
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
        AppMethodBeat.o(30956);
        return false;
      }
      localObject3 = com.tencent.mm.plugin.openapi.a.cWJ().bpI(((k.b)localObject1).hzM);
      localObject2 = new arf();
      if (localObject3 != null) {
        ((arf)localObject2).bsC(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath);
      }
      a((arf)localObject2, paramcc);
      ((arf)localObject2).axy(8);
      ((arf)localObject2).bsy(((k.b)localObject1).nRe);
      paramcc = r.bKa().X(paramcc.field_imgPath, true);
      if (Util.isNullOrNil(paramcc)) {
        ((arf)localObject2).Kk(true);
      }
      if (com.tencent.mm.vfs.y.ZC(paramcc)) {
        ((arf)localObject2).bsD(paramcc);
      }
      ((arf)localObject2).bso(((k.b)localObject1).title);
      ((arf)localObject2).bsp(((k.b)localObject1).description);
      localarv.vEn.add(localObject2);
      paramdn.hDr.desc = ((k.b)localObject1).title;
      paramdn.hDr.type = 8;
      AppMethodBeat.o(30956);
      return true;
    case 7: 
      if ((((k.b)localObject1).hzM == null) || (((k.b)localObject1).hzM.length() == 0)) {
        paramdn.hDr.hDx = R.l.favorite_fail_attachment_not_exists;
      }
      while (com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramdn.hDr.hDx = R.l.favorite_fail_nonsupport;
        AppMethodBeat.o(30956);
        return false;
      }
      paramdn.hDr.hDx = R.l.favorite_fail_sdcard_not_available;
      AppMethodBeat.o(30956);
      return false;
    case 10: 
      paramcc = new aru();
      paramcc.bth(((k.b)localObject1).title);
      paramcc.bti(((k.b)localObject1).description);
      paramcc.axE(((k.b)localObject1).nRA);
      paramcc.btk(((k.b)localObject1).nRB);
      paramcc.btj(((k.b)localObject1).thumburl);
      paramdn.hDr.title = ((k.b)localObject1).title;
      paramdn.hDr.desc = ((k.b)localObject1).description;
      paramdn.hDr.type = 10;
      localarv.b(paramcc);
      AppMethodBeat.o(30956);
      return true;
    case 20: 
      paramcc = new ase();
      paramcc.btx(((k.b)localObject1).title);
      paramcc.bty(((k.b)localObject1).description);
      paramcc.btA(((k.b)localObject1).nRE);
      paramcc.btz(((k.b)localObject1).thumburl);
      paramdn.hDr.title = ((k.b)localObject1).title;
      paramdn.hDr.desc = ((k.b)localObject1).description;
      paramdn.hDr.type = 15;
      localarv.b(paramcc);
      AppMethodBeat.o(30956);
      return true;
    case 13: 
      paramcc = new aru();
      paramcc.bth(((k.b)localObject1).title);
      paramcc.bti(((k.b)localObject1).description);
      paramcc.axE(((k.b)localObject1).nRG);
      paramcc.btk(((k.b)localObject1).nRH);
      paramcc.btj(((k.b)localObject1).thumburl);
      paramdn.hDr.title = ((k.b)localObject1).title;
      paramdn.hDr.desc = ((k.b)localObject1).description;
      paramdn.hDr.type = 11;
      localarv.b(paramcc);
      AppMethodBeat.o(30956);
      return true;
    case 24: 
      paramdn.hDr.hDu = new asj();
      bool = a(paramdn, (k.b)localObject1, localarv, paramcc, true);
      AppMethodBeat.o(30956);
      return bool;
    case 19: 
      paramdn.hDr.hDu = new asj();
      bool = a(paramdn, (k.b)localObject1, localarv, paramcc, false);
      AppMethodBeat.o(30956);
      return bool;
    }
    Object localObject3 = new ard();
    ((ard)localObject3).username = ((k.b)localObject1).nTD;
    ((ard)localObject3).appId = ((k.b)localObject1).nTE;
    ((ard)localObject3).hJK = ((k.b)localObject1).nTW;
    ((ard)localObject3).iconUrl = ((k.b)localObject1).nTY;
    ((ard)localObject3).hzy = ((k.b)localObject1).nTC;
    ((ard)localObject3).Zyw = ((k.b)localObject1).iab;
    ((ard)localObject3).rxs = ((k.b)localObject1).nTM;
    ((ard)localObject3).type = ((k.b)localObject1).nTF;
    Object localObject4 = (com.tencent.mm.message.a)((k.b)localObject1).aK(com.tencent.mm.message.a.class);
    if (localObject4 != null)
    {
      ((ard)localObject3).nOX = ((com.tencent.mm.message.a)localObject4).nOX;
      ((ard)localObject3).idf = ((com.tencent.mm.message.a)localObject4).nOZ;
      ((ard)localObject3).subType = ((com.tencent.mm.message.a)localObject4).nPa;
    }
    ((ard)localObject3).version = ((k.b)localObject1).nTX;
    localObject4 = new arf();
    a((arf)localObject4, paramcc);
    ((arf)localObject4).axy(19);
    String str = r.bKa().X(paramcc.field_imgPath, true);
    if (Util.isNullOrNil(str)) {
      ((arf)localObject4).Kk(true);
    }
    if (com.tencent.mm.vfs.y.ZC(str)) {
      ((arf)localObject4).bsD(str);
    }
    ((arf)localObject4).bso(((k.b)localObject1).title);
    ((arf)localObject4).bsp(((k.b)localObject1).description);
    localarv.vEn.add(localObject4);
    localarv.btm(((k.b)localObject1).title);
    if (au.bwE(paramcc.field_talker)) {}
    for (int i = 22;; i = 21)
    {
      ((asb)localObject2).axH(i);
      paramdn.hDr.title = ((k.b)localObject1).title;
      paramdn.hDr.desc = ((k.b)localObject1).description;
      paramdn.hDr.type = 19;
      localarv.c((ard)localObject3);
      AppMethodBeat.o(30956);
      return true;
    }
  }
  
  private static arh q(arf paramarf)
  {
    AppMethodBeat.i(30960);
    arh localarh = new arh();
    paramarf = paramarf.Zzy.ZAf;
    if (paramarf.ZAQ) {
      localarh.bsX(paramarf.hQQ);
    }
    if (paramarf.ZAR) {
      localarh.bsY(paramarf.toUser);
    }
    if (paramarf.ZAU) {
      localarh.bta(paramarf.ZAT);
    }
    localarh.axC(1);
    localarh.yr(Util.nowMilliSecond());
    AppMethodBeat.o(30960);
    return localarh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */