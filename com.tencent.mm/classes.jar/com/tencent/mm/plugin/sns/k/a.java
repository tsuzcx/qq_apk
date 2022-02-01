package com.tencent.mm.plugin.sns.k;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(ajx paramajx, p paramp)
  {
    AppMethodBeat.i(97662);
    if (paramp != null) {
      a(paramajx, paramp.ebP());
    }
    AppMethodBeat.o(97662);
  }
  
  public static void a(ajx paramajx, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramajx != null) && (paramTimeLineObject != null) && (!bu.isNullOrNil(paramTimeLineObject.AiG))) {
      paramajx.aQa(paramTimeLineObject.AiG);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(cw paramcw, p paramp)
  {
    AppMethodBeat.i(97654);
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(97654);
      return false;
    }
    akn localakn = new akn();
    Object localObject2 = new akt();
    TimeLineObject localTimeLineObject = paramp.ebP();
    bzh localbzh = (bzh)localTimeLineObject.HUG.Gtx.get(0);
    if ((paramp.Rt(32)) && (localTimeLineObject.HUG.Gtw == 15))
    {
      localTimeLineObject.HUL.hEZ = paramp.dVi().dGD;
      localTimeLineObject.HUL.hFa = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { r.zV(paramp.field_snsId), localbzh.Id });
    ((akt)localObject2).aQC(paramp.field_userName);
    ((akt)localObject2).aQD(v.aAC());
    ((akt)localObject2).aax(2);
    ((akt)localObject2).Dk(bu.fpO());
    ((akt)localObject2).aQH(paramp.getSnsId());
    ((akt)localObject2).aQE((String)localObject1);
    localakn.a((akt)localObject2);
    localObject2 = new ajx();
    ((ajx)localObject2).aPU((String)localObject1);
    localObject1 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
    Object localObject4 = r.i(localbzh);
    Object localObject3 = r.d(localbzh);
    if (bu.isNullOrNil(aw.a(paramp.eco(), localbzh)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcw.doL.doQ = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!o.fB((String)localObject1 + (String)localObject4))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + o.fB(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + o.fB(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcw.doL.doQ = 2131758902;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!o.fB((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localbzh.Hmm != null)
      {
        j = m;
        i = k;
        if (localbzh.Hmm.Hnb > 0.0F)
        {
          j = m;
          i = k;
          if (localbzh.Hmm.Hna > 0.0F)
          {
            i = (int)localbzh.Hmm.Hna;
            j = (int)localbzh.Hmm.Hnb;
          }
        }
      }
      localBitmap = e.aw((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + o.fB(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcw.doL.doQ = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((ajx)localObject2).aPQ((String)localObject1 + (String)localObject4);
        ((ajx)localObject2).aPR((String)localObject1 + (String)localObject3);
        if (bu.isNullOrNil(localbzh.Hmu))
        {
          localObject1 = localTimeLineObject.HUD;
          ((ajx)localObject2).aPC((String)localObject1);
          ((ajx)localObject2).aQb(localTimeLineObject.AkC);
          if (!bu.isNullOrNil(localTimeLineObject.AkC))
          {
            localObject1 = bx.M(localTimeLineObject.AkC, "adxml");
            if (((Map)localObject1).size() > 0)
            {
              ((ajx)localObject2).aPC(bu.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((ajx)localObject2).aPD(bu.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramp.Rt(32)) {
            break label1254;
          }
          localObject3 = paramp.dVj();
          localObject4 = new aka();
          if (!bu.isNullOrNil(localbzh.Hmu)) {
            break label1224;
          }
          localObject1 = localTimeLineObject.HUD;
          ((aka)localObject4).hEV = ((String)localObject1);
          ((aka)localObject4).GBN = localbzh.AIa;
          ((aka)localObject4).hET = localbzh.Hmq;
          ((aka)localObject4).hEZ = localTimeLineObject.HUL.hEZ;
          ((aka)localObject4).hFa = localTimeLineObject.HUL.hFa;
          if (bu.isNullOrNil(((aka)localObject4).hFa)) {
            ((aka)localObject4).hFa = localTimeLineObject.Id;
          }
          if (!bu.isNullOrNil(localbzh.Hmt)) {
            break label1234;
          }
          localObject1 = localbzh.Hmj;
          ((aka)localObject4).hEY = ((String)localObject1);
          if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zMZ == 0))
          {
            ((aka)localObject4).hEX = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNb;
            ((aka)localObject4).hEW = ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNa;
          }
          ((ajx)localObject2).a((aka)localObject4);
          i = 16;
          j = 15;
          ((ajx)localObject2).aao(j);
          localObject1 = e.ayN(((ajx)localObject2).GzY);
          if (localObject1 == null) {
            break label1244;
          }
          ((ajx)localObject2).aan(((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localakn.bm((LinkedList)localObject1);
          paramcw.doL.doN = localakn;
          paramcw.doL.type = i;
          a((ajx)localObject2, paramp);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramp)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramp, "save bmp error %s", new Object[] { paramp.getMessage() });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + o.fB(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcw.doL.doQ = 2131758902;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localbzh.Hmu;
      continue;
      label1224:
      localObject1 = localbzh.Hmu;
      continue;
      label1234:
      localObject1 = localbzh.Hmt;
      continue;
      label1244:
      ((ajx)localObject2).aan(1);
      continue;
      label1254:
      i = 4;
    }
  }
  
  public static boolean a(cw paramcw, p paramp, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramcw == null) || (bu.isNullOrNil(paramString)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramp == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    bzh localbzh = al.a(paramp, paramString);
    if (localbzh == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { r.zV(paramp.field_snsId), paramString });
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramp.field_userName });
    localakt.aQC(paramp.field_userName);
    localakt.aQD(v.aAC());
    localakt.aax(2);
    localakt.Dk(paramp.field_createTime * 1000L);
    localakt.aQH(paramp.getSnsId());
    localakt.aQE(str);
    localajx.aPU(str);
    localajx.aPQ(ap.jv(ah.getAccSnsPath(), paramString) + r.k(localbzh));
    if (paramp.ebP() != null)
    {
      localajx.aQb(paramp.ebP().AkC);
      if (!bu.isNullOrNil(paramp.ebP().AkC))
      {
        paramString = bx.M(paramp.ebP().AkC, "adxml");
        if (paramString.size() > 0)
        {
          localajx.aPC(bu.bI((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localajx.aPD(bu.bI((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localajx, paramp);
    paramString = ap.jv(ah.getAccSnsPath(), localbzh.Id) + r.d(localbzh);
    if ((!o.fB(localajx.GzY)) && (paramp.field_userName.endsWith(ah.dXj())))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97659);
      return false;
    }
    if (o.fB(paramString)) {
      localajx.aPR(paramString);
    }
    for (;;)
    {
      localajx.aao(2);
      localakn.oeJ.add(localajx);
      localakn.a(localakt);
      paramcw.doL.doN = localakn;
      paramcw.doL.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localajx.wt(true);
      localajx.aPL(localbzh.Hmj);
      paramp = new alc();
      paramp.aQS(localbzh.Hmj);
      localakn.b(paramp);
    }
  }
  
  public static boolean a(cw paramcw, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramcw == null) || (!x.aBO(paramString)))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (ah.dXn())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcw.doL.doQ = 2131758903;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.storage.h.aBr(paramString);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = al.b((p)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((bzh)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { r.zV(((p)localObject1).field_snsId), paramString });
    localObject2 = new akt();
    paramString = ((p)localObject1).ebP();
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((p)localObject1).field_userName });
    ((akt)localObject2).aQC(((p)localObject1).field_userName);
    ((akt)localObject2).aQD(v.aAC());
    ((akt)localObject2).aax(2);
    ((akt)localObject2).Dk(((p)localObject1).field_createTime * 1000L);
    ((akt)localObject2).aQH(((p)localObject1).getSnsId());
    ((akt)localObject2).aQE(str);
    localObject1 = new gx();
    ((gx)localObject1).dub.type = 30;
    ((gx)localObject1).dub.dui = 4;
    ((gx)localObject1).dub.desc = paramString.HUG.Gtz;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    ((gx)localObject1).dub.doN.a((akt)localObject2);
    paramcw.doL.doN = ((gx)localObject1).dub.doN;
    if (paramcw.doL.doN != null)
    {
      localObject1 = paramcw.doL.doN.oeJ;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (ajx)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((ajx)localObject2).ws(true);
            ((ajx)localObject2).wt(true);
          }
          i += 1;
        }
      }
    }
    paramcw.doL.desc = paramString.HUG.Title;
    paramcw.doL.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(cw paramcw, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((x.aBP(paramString)) || (paramInt < 0))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(97660);
      return false;
    }
    if (ah.dXn())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcw.doL.doQ = 2131758903;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = ah.dXE().aBr(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    bzh localbzh = al.b(paramString, paramInt);
    if (localbzh == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramcw, paramString, localbzh.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(cw paramcw, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((x.aBP(paramString)) || (paramCharSequence == null))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcw.doL.doQ = 2131758885;
      AppMethodBeat.o(97658);
      return false;
    }
    if (ah.dXn())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcw.doL.doQ = 2131758903;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = ah.dXE().aBr(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcw.doL.doQ = 2131758884;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { r.zV(paramString.field_snsId) });
    akn localakn = new akn();
    akt localakt = new akt();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.field_userName });
    localakt.aQC(paramString.field_userName);
    localakt.aQD(v.aAC());
    localakt.aax(2);
    localakt.Dk(paramString.field_createTime * 1000L);
    localakt.aQH(paramString.getSnsId());
    localakt.aQE(str);
    localakn.a(localakt);
    paramcw.doL.doN = localakn;
    paramcw.doL.desc = paramCharSequence.toString();
    paramcw.doL.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(cw paramcw, String paramString1, String paramString2)
  {
    AppMethodBeat.i(224108);
    boolean bool = b(paramcw, paramString1, paramString2);
    AppMethodBeat.o(224108);
    return bool;
  }
  
  private static boolean a(akn paramakn, TimeLineObject paramTimeLineObject, alc paramalc)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.HUG.GtA == null) || (paramTimeLineObject.HUG.GtA.hFR == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    bxq localbxq = paramTimeLineObject.HUG.GtA;
    akf localakf = new akf();
    paramakn.f(localakf);
    localakf.hBX = paramTimeLineObject.HUG.GtA.hBX;
    localakf.hBV = localbxq.hFR;
    localakf.hBY = localbxq.hBY;
    localakf.hBW = localbxq.hBW;
    localakf.duration = localbxq.duration;
    localakf.hBZ = localbxq.hBZ;
    localakf.hCa = localbxq.hCa;
    localakf.videoWidth = localbxq.videoWidth;
    localakf.videoHeight = localbxq.videoHeight;
    localakf.dpP = paramTimeLineObject.HUH;
    localakf.hFW = paramTimeLineObject.Fnm;
    localakf.hGe = localbxq.coverUrl;
    paramalc.aQQ(localbxq.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(cw paramcw, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramcw == null) || (!x.aBO(paramString2)) || (paramString1 == null))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcw != null) {
        paramcw.doL.doQ = 2131758885;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (ah.dXn())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcw.doL.doQ = 2131758903;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.storage.h.aBr(paramString2);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcw.doL.doQ = 2131758886;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((p)localObject1).ebP().HUG != null) && (((p)localObject1).ebP().HUG.Gtw == 26))
    {
      boolean bool = a(paramcw, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = al.b((p)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((bzh)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { r.zV(((p)localObject1).field_snsId), paramString2 });
    paramString2 = new akn();
    akt localakt = new akt();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((p)localObject1).field_userName });
    localakt.aQC(((p)localObject1).field_userName);
    localakt.aQD(v.aAC());
    localakt.aax(2);
    localakt.Dk(((p)localObject1).field_createTime * 1000L);
    localakt.aQH(((p)localObject1).getSnsId());
    localakt.aQE((String)localObject3);
    localakt.aQJ(paramString1);
    paramString1 = new ajx();
    paramString1.aPU((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject2).Id) + r.d((bzh)localObject2);
      if (o.fB((String)localObject3)) {
        paramString1.aPR((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.aao(5);
      localObject1 = ((p)localObject1).ebP();
      paramString1.aPC(((TimeLineObject)localObject1).HUG.Title);
      paramString1.aPD(((TimeLineObject)localObject1).HUG.Desc);
      paramString1.aQb(((TimeLineObject)localObject1).AkC);
      if (!bu.isNullOrNil(((TimeLineObject)localObject1).AkC))
      {
        localObject2 = bx.M(((TimeLineObject)localObject1).AkC, "adxml");
        if (((Map)localObject2).size() > 0)
        {
          paramString1.aPC(bu.bI((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.aPD(bu.bI((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.ws(true);
      paramString2.oeJ.add(paramString1);
      localObject2 = new alc();
      ((alc)localObject2).aaz(((TimeLineObject)localObject1).hCH);
      ((alc)localObject2).aQP(paramString1.title);
      if ((((TimeLineObject)localObject1).zFh != null) && (!bu.isNullOrNil(((TimeLineObject)localObject1).zFh.DTD)))
      {
        paramString1 = new com.tencent.mm.plugin.websearch.api.ae();
        paramString1.DTD = ((TimeLineObject)localObject1).zFh.DTD;
        paramString1.DTE = ((TimeLineObject)localObject1).zFh.DTE;
        paramString1.DTF = ((TimeLineObject)localObject1).zFh.DTF;
        paramString1.DTG = ((TimeLineObject)localObject1).zFh.DTG;
        paramString1.DTH = ((TimeLineObject)localObject1).zFh.DTH;
        paramString1.qlv = ((TimeLineObject)localObject1).zFh.qlv;
        paramString1.qlw = ((TimeLineObject)localObject1).zFh.qlw;
        paramString1.uly = ((TimeLineObject)localObject1).zFh.uly;
        paramString1.DTI = ((TimeLineObject)localObject1).zFh.DTI;
        paramString1.DTJ = ((TimeLineObject)localObject1).zFh.DTJ;
        paramString1.DTK = ((TimeLineObject)localObject1).zFh.DTK;
        paramString1.source = ((TimeLineObject)localObject1).zFh.source;
        paramString1.dJL = ((TimeLineObject)localObject1).zFh.dJL;
        paramString1.DTL = ((TimeLineObject)localObject1).zFh.DTL;
        paramString1.DTM = ((TimeLineObject)localObject1).zFh.DTM;
        paramString1.DTN = ((TimeLineObject)localObject1).zFh.DTN;
        paramString1.DTO = ((TimeLineObject)localObject1).zFh.DTO;
        paramString1.DTP = ((TimeLineObject)localObject1).zFh.DTP;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).zFh.thumbUrl;
        paramString1.DTQ = ((TimeLineObject)localObject1).zFh.DTQ;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((alc)localObject2).aQU(((StringBuilder)localObject3).toString());
      }
      paramString2.b((alc)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (alc)localObject2);
      paramString2.a(localakt);
      paramcw.doL.doN = paramString2;
      paramcw.doL.desc = ((TimeLineObject)localObject1).HUG.Title;
      paramcw.doL.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.wt(true);
      paramString1.aPL(((bzh)localObject2).Hmj);
      localObject3 = new alc();
      ((alc)localObject3).aQS(((bzh)localObject2).Hmj);
      paramString2.b((alc)localObject3);
      continue;
      paramString1.wt(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */