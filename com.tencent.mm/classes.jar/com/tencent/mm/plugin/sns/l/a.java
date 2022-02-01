package com.tencent.mm.plugin.sns.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(anm paramanm, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97662);
    if (paramSnsInfo != null) {
      a(paramanm, paramSnsInfo.getTimeLine());
    }
    AppMethodBeat.o(97662);
  }
  
  public static void a(anm paramanm, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramanm != null) && (paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.statExtStr))) {
      paramanm.bsV(paramTimeLineObject.statExtStr);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(dd paramdd, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97654);
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      AppMethodBeat.o(97654);
      return false;
    }
    aoc localaoc = new aoc();
    Object localObject2 = new aoi();
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    cvt localcvt = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
    if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Sqq == 15))
    {
      localTimeLineObject.streamvideo.lox = paramSnsInfo.getAdInfo().uxInfo;
      localTimeLineObject.streamvideo.loy = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { t.Qu(paramSnsInfo.field_snsId), localcvt.Id });
    ((aoi)localObject2).btx(paramSnsInfo.field_userName);
    ((aoi)localObject2).bty(z.bcZ());
    ((aoi)localObject2).arz(2);
    ((aoi)localObject2).Ue(Util.nowMilliSecond());
    ((aoi)localObject2).btC(paramSnsInfo.getSnsId());
    ((aoi)localObject2).btz((String)localObject1);
    localaoc.a((aoi)localObject2);
    localObject2 = new anm();
    ((anm)localObject2).bsP((String)localObject1);
    localObject1 = aq.kD(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), localcvt.Id);
    Object localObject4 = t.i(localcvt);
    Object localObject3 = t.d(localcvt);
    if (Util.isNullOrNil(ax.a(paramSnsInfo.getLocalid(), localcvt)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramdd.fyI.fyO = i.j.favorite_fail_sns_sight;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!u.agG((String)localObject1 + (String)localObject4))
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + u.agG(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + u.agG(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramdd.fyI.fyO = i.j.favorite_fail_sns_sight;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!u.agG((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localcvt.TDH != null)
      {
        j = m;
        i = k;
        if (localcvt.TDH.TEv > 0.0F)
        {
          j = m;
          i = k;
          if (localcvt.TDH.TEu > 0.0F)
          {
            i = (int)localcvt.TDH.TEu;
            j = (int)localcvt.TDH.TEv;
          }
        }
      }
      localBitmap = com.tencent.mm.plugin.sight.base.f.aC((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + u.agG(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramdd.fyI.fyO = i.j.favorite_fail_sns_sight;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((anm)localObject2).bsL((String)localObject1 + (String)localObject4);
        ((anm)localObject2).bsM((String)localObject1 + (String)localObject3);
        if (Util.isNullOrNil(localcvt.TDP))
        {
          localObject1 = localTimeLineObject.ContentDesc;
          ((anm)localObject2).bsx((String)localObject1);
          ((anm)localObject2).bsW(localTimeLineObject.canvasInfo);
          if (!Util.isNullOrNil(localTimeLineObject.canvasInfo))
          {
            localObject1 = XmlParser.parseXml(localTimeLineObject.canvasInfo, "adxml", null);
            if (((Map)localObject1).size() > 0)
            {
              ((anm)localObject2).bsx(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((anm)localObject2).bsy(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramSnsInfo.isAd()) {
            break label1256;
          }
          localObject3 = paramSnsInfo.getAdXml();
          localObject4 = new anp();
          if (!Util.isNullOrNil(localcvt.TDP)) {
            break label1226;
          }
          localObject1 = localTimeLineObject.ContentDesc;
          ((anp)localObject4).lot = ((String)localObject1);
          ((anp)localObject4).SAk = localcvt.Lgc;
          ((anp)localObject4).lor = localcvt.TDL;
          ((anp)localObject4).lox = localTimeLineObject.streamvideo.lox;
          ((anp)localObject4).loy = localTimeLineObject.streamvideo.loy;
          if (Util.isNullOrNil(((anp)localObject4).loy)) {
            ((anp)localObject4).loy = localTimeLineObject.Id;
          }
          if (!Util.isNullOrNil(localcvt.TDO)) {
            break label1236;
          }
          localObject1 = localcvt.TDF;
          ((anp)localObject4).low = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            ((anp)localObject4).lov = ((ADXml)localObject3).attachShareLinkUrl;
            ((anp)localObject4).lou = ((ADXml)localObject3).attachShareLinkWording;
          }
          ((anm)localObject2).a((anp)localObject4);
          i = 16;
          j = 15;
          ((anm)localObject2).arq(j);
          localObject1 = com.tencent.mm.plugin.sight.base.f.aYg(((anm)localObject2).Syl);
          if (localObject1 == null) {
            break label1246;
          }
          ((anm)localObject2).arp(((b)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localaoc.cg((LinkedList)localObject1);
          paramdd.fyI.fyK = localaoc;
          paramdd.fyI.type = i;
          a((anm)localObject2, paramSnsInfo);
          Log.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramSnsInfo, "save bmp error %s", new Object[] { paramSnsInfo.getMessage() });
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + u.agG(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramdd.fyI.fyO = i.j.favorite_fail_sns_sight;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localcvt.TDP;
      continue;
      label1226:
      localObject1 = localcvt.TDP;
      continue;
      label1236:
      localObject1 = localcvt.TDO;
      continue;
      label1246:
      ((anm)localObject2).arp(1);
      continue;
      label1256:
      i = 4;
    }
  }
  
  public static boolean a(dd paramdd, SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramdd == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    cvt localcvt = an.a(paramSnsInfo, paramString);
    if (localcvt == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { t.Qu(paramSnsInfo.field_snsId), paramString });
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramSnsInfo.getUserName() });
    localaoi.btx(paramSnsInfo.getUserName());
    localaoi.bty(z.bcZ());
    localaoi.arz(2);
    localaoi.Ue(paramSnsInfo.getCreateTime() * 1000L);
    localaoi.btC(paramSnsInfo.getSnsId());
    localaoi.btz(str);
    localanm.bsP(str);
    localanm.bsL(aq.kD(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), paramString) + t.k(localcvt));
    if (paramSnsInfo.getTimeLine() != null)
    {
      localanm.bsW(paramSnsInfo.getTimeLine().canvasInfo);
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo))
      {
        paramString = XmlParser.parseXml(paramSnsInfo.getTimeLine().canvasInfo, "adxml", null);
        if (paramString.size() > 0)
        {
          localanm.bsx(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localanm.bsy(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localanm, paramSnsInfo);
    paramString = aq.kD(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), localcvt.Id) + t.d(localcvt);
    if ((!u.agG(localanm.Syl)) && (paramSnsInfo.getUserName().endsWith(com.tencent.mm.plugin.sns.model.aj.fOo())))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    if (u.agG(paramString)) {
      localanm.bsM(paramString);
    }
    for (;;)
    {
      localanm.arq(2);
      localaoc.syG.add(localanm);
      localaoc.a(localaoi);
      paramdd.fyI.fyK = localaoc;
      paramdd.fyI.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localanm.Ey(true);
      localanm.bsG(localcvt.TDF);
      paramSnsInfo = new aor();
      paramSnsInfo.btN(localcvt.TDF);
      localaoc.c(paramSnsInfo);
    }
  }
  
  public static boolean a(dd paramdd, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramdd == null) || (!y.bbJ(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdd.fyI.fyO = i.j.favorite_fail_system_error;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.storage.f.bbl(paramString);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = an.c((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((cvt)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { t.Qu(((SnsInfo)localObject1).field_snsId), paramString });
    localObject2 = new aoi();
    paramString = ((SnsInfo)localObject1).getTimeLine();
    if (paramString == null)
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    ((aoi)localObject2).btx(((SnsInfo)localObject1).getUserName());
    ((aoi)localObject2).bty(z.bcZ());
    ((aoi)localObject2).arz(2);
    ((aoi)localObject2).Ue(((SnsInfo)localObject1).getCreateTime() * 1000L);
    ((aoi)localObject2).btC(((SnsInfo)localObject1).getSnsId());
    ((aoi)localObject2).btz(str);
    localObject1 = new hi();
    ((hi)localObject1).fEb.type = 30;
    ((hi)localObject1).fEb.fEi = 4;
    ((hi)localObject1).fEb.desc = paramString.ContentObj.Sqt;
    EventCenter.instance.publish((IEvent)localObject1);
    ((hi)localObject1).fEb.fyK.a((aoi)localObject2);
    paramdd.fyI.fyK = ((hi)localObject1).fEb.fyK;
    if (paramdd.fyI.fyK != null)
    {
      localObject1 = paramdd.fyI.fyK.syG;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (anm)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((anm)localObject2).Ex(true);
            ((anm)localObject2).Ey(true);
          }
          i += 1;
        }
      }
    }
    paramdd.fyI.desc = paramString.ContentObj.fwr;
    paramdd.fyI.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(dd paramdd, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((y.bbK(paramString)) || (paramInt < 0))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      AppMethodBeat.o(97660);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdd.fyI.fyO = i.j.favorite_fail_system_error;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = com.tencent.mm.plugin.sns.model.aj.fOI().bbl(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97660);
      return false;
    }
    cvt localcvt = an.c(paramString, paramInt);
    if (localcvt == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramdd, paramString, localcvt.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(dd paramdd, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((y.bbK(paramString)) || (paramCharSequence == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      AppMethodBeat.o(97658);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdd.fyI.fyO = i.j.favorite_fail_system_error;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = com.tencent.mm.plugin.sns.model.aj.fOI().bbl(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramdd.fyI.fyO = i.j.favorite_fail;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { t.Qu(paramString.field_snsId) });
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.getUserName() });
    localaoi.btx(paramString.getUserName());
    localaoi.bty(z.bcZ());
    localaoi.arz(2);
    localaoi.Ue(paramString.getCreateTime() * 1000L);
    localaoi.btC(paramString.getSnsId());
    localaoi.btz(str);
    localaoc.a(localaoi);
    paramdd.fyI.fyK = localaoc;
    paramdd.fyI.desc = paramCharSequence.toString();
    paramdd.fyI.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(dd paramdd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(292903);
    boolean bool = b(paramdd, paramString1, paramString2);
    AppMethodBeat.o(292903);
    return bool;
  }
  
  private static boolean a(aoc paramaoc, TimeLineObject paramTimeLineObject, aor paramaor)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.ContentObj.Squ == null) || (paramTimeLineObject.ContentObj.Squ.lpx == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    cuf localcuf = paramTimeLineObject.ContentObj.Squ;
    anu localanu = new anu();
    paramaoc.f(localanu);
    localanu.llr = paramTimeLineObject.ContentObj.Squ.llr;
    localanu.llp = localcuf.lpx;
    localanu.lls = localcuf.lls;
    localanu.llq = localcuf.llq;
    localanu.duration = localcuf.duration;
    localanu.llt = localcuf.llt;
    localanu.vid = localcuf.vid;
    localanu.videoWidth = localcuf.videoWidth;
    localanu.videoHeight = localcuf.videoHeight;
    localanu.fzT = paramTimeLineObject.publicUserName;
    localanu.lpC = paramTimeLineObject.sourceNickName;
    localanu.lpK = localcuf.coverUrl;
    paramaor.btL(localcuf.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(dd paramdd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramdd == null) || (!y.bbJ(paramString2)) || (paramString1 == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramdd != null) {
        paramdd.fyI.fyO = i.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdd.fyI.fyO = i.j.favorite_fail_system_error;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.storage.f.bbl(paramString2);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdd.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((SnsInfo)localObject1).getTimeLine().ContentObj != null) && (((SnsInfo)localObject1).getTimeLine().ContentObj.Sqq == 26))
    {
      boolean bool = a(paramdd, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = an.c((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((cvt)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { t.Qu(((SnsInfo)localObject1).field_snsId), paramString2 });
    paramString2 = new aoc();
    aoi localaoi = new aoi();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    localaoi.btx(((SnsInfo)localObject1).getUserName());
    localaoi.bty(z.bcZ());
    localaoi.arz(2);
    localaoi.Ue(((SnsInfo)localObject1).getCreateTime() * 1000L);
    localaoi.btC(((SnsInfo)localObject1).getSnsId());
    localaoi.btz((String)localObject3);
    localaoi.btE(paramString1);
    paramString1 = new anm();
    paramString1.bsP((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = aq.kD(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), ((cvt)localObject2).Id) + t.d((cvt)localObject2);
      if (u.agG((String)localObject3)) {
        paramString1.bsM((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.arq(5);
      localObject1 = ((SnsInfo)localObject1).getTimeLine();
      paramString1.bsx(((TimeLineObject)localObject1).ContentObj.fwr);
      paramString1.bsy(((TimeLineObject)localObject1).ContentObj.CMB);
      paramString1.bsW(((TimeLineObject)localObject1).canvasInfo);
      if (!Util.isNullOrNil(((TimeLineObject)localObject1).canvasInfo))
      {
        localObject2 = XmlParser.parseXml(((TimeLineObject)localObject1).canvasInfo, "adxml", null);
        if (((Map)localObject2).size() > 0)
        {
          paramString1.bsx(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.bsy(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.Ex(true);
      paramString2.syG.add(paramString1);
      localObject2 = new aor();
      ((aor)localObject2).arB(((TimeLineObject)localObject1).contentattr);
      ((aor)localObject2).btK(paramString1.title);
      if ((((TimeLineObject)localObject1).webSearchInfo != null) && (!Util.isNullOrNil(((TimeLineObject)localObject1).webSearchInfo.PyQ)))
      {
        paramString1 = new com.tencent.mm.plugin.websearch.api.aj();
        paramString1.PyQ = ((TimeLineObject)localObject1).webSearchInfo.PyQ;
        paramString1.PyR = ((TimeLineObject)localObject1).webSearchInfo.PyR;
        paramString1.PyS = ((TimeLineObject)localObject1).webSearchInfo.PyS;
        paramString1.PyT = ((TimeLineObject)localObject1).webSearchInfo.PyT;
        paramString1.PyU = ((TimeLineObject)localObject1).webSearchInfo.PyU;
        paramString1.vhY = ((TimeLineObject)localObject1).webSearchInfo.vhY;
        paramString1.pqW = ((TimeLineObject)localObject1).webSearchInfo.pqW;
        paramString1.CHR = ((TimeLineObject)localObject1).webSearchInfo.CHR;
        paramString1.PyV = ((TimeLineObject)localObject1).webSearchInfo.PyV;
        paramString1.PyW = ((TimeLineObject)localObject1).webSearchInfo.PyW;
        paramString1.PyX = ((TimeLineObject)localObject1).webSearchInfo.PyX;
        paramString1.source = ((TimeLineObject)localObject1).webSearchInfo.source;
        paramString1.fVx = ((TimeLineObject)localObject1).webSearchInfo.fVx;
        paramString1.PyY = ((TimeLineObject)localObject1).webSearchInfo.PyY;
        paramString1.PyZ = ((TimeLineObject)localObject1).webSearchInfo.PyZ;
        paramString1.Pza = ((TimeLineObject)localObject1).webSearchInfo.Pza;
        paramString1.Pzb = ((TimeLineObject)localObject1).webSearchInfo.Pzb;
        paramString1.Pzc = ((TimeLineObject)localObject1).webSearchInfo.Pzc;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).webSearchInfo.thumbUrl;
        paramString1.Pzd = ((TimeLineObject)localObject1).webSearchInfo.Pzd;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((aor)localObject2).btP(((StringBuilder)localObject3).toString());
      }
      paramString2.c((aor)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (aor)localObject2);
      paramString2.a(localaoi);
      paramdd.fyI.fyK = paramString2;
      paramdd.fyI.desc = ((TimeLineObject)localObject1).ContentObj.fwr;
      paramdd.fyI.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.Ey(true);
      paramString1.bsG(((cvt)localObject2).TDF);
      localObject3 = new aor();
      ((aor)localObject3).btN(((cvt)localObject2).TDF);
      paramString2.c((aor)localObject3);
      continue;
      paramString1.Ey(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.a
 * JD-Core Version:    0.7.0.1
 */