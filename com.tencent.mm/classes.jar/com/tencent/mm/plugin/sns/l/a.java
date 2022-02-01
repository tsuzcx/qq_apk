package com.tencent.mm.plugin.sns.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(aml paramaml, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97662);
    if (paramSnsInfo != null) {
      a(paramaml, paramSnsInfo.getTimeLine());
    }
    AppMethodBeat.o(97662);
  }
  
  private static void a(aml paramaml, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramaml != null) && (paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.statExtStr))) {
      paramaml.bgD(paramTimeLineObject.statExtStr);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(cz paramcz, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97654);
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(97654);
      return false;
    }
    anb localanb = new anb();
    Object localObject2 = new anh();
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    cnb localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
    if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.LoU == 15))
    {
      localTimeLineObject.streamvideo.izf = paramSnsInfo.getAdInfo().uxInfo;
      localTimeLineObject.streamvideo.izg = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { r.Jb(paramSnsInfo.field_snsId), localcnb.Id });
    ((anh)localObject2).bhf(paramSnsInfo.field_userName);
    ((anh)localObject2).bhg(z.aTY());
    ((anh)localObject2).ajm(2);
    ((anh)localObject2).MA(Util.nowMilliSecond());
    ((anh)localObject2).bhk(paramSnsInfo.getSnsId());
    ((anh)localObject2).bhh((String)localObject1);
    localanb.a((anh)localObject2);
    localObject2 = new aml();
    ((aml)localObject2).bgx((String)localObject1);
    localObject1 = ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), localcnb.Id);
    Object localObject4 = r.j(localcnb);
    Object localObject3 = r.e(localcnb);
    if (Util.isNullOrNil(ay.a(paramSnsInfo.getLocalid(), localcnb)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramcz.dFZ.dGe = 2131759226;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!s.YS((String)localObject1 + (String)localObject4))
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + s.YS(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + s.YS(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramcz.dFZ.dGe = 2131759226;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!s.YS((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localcnb.MsB != null)
      {
        j = m;
        i = k;
        if (localcnb.MsB.Mtp > 0.0F)
        {
          j = m;
          i = k;
          if (localcnb.MsB.Mto > 0.0F)
          {
            i = (int)localcnb.MsB.Mto;
            j = (int)localcnb.MsB.Mtp;
          }
        }
      }
      localBitmap = e.az((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + s.YS(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcz.dFZ.dGe = 2131759226;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((aml)localObject2).bgt((String)localObject1 + (String)localObject4);
        ((aml)localObject2).bgu((String)localObject1 + (String)localObject3);
        if (Util.isNullOrNil(localcnb.MsJ))
        {
          localObject1 = localTimeLineObject.ContentDesc;
          ((aml)localObject2).bgf((String)localObject1);
          ((aml)localObject2).bgE(localTimeLineObject.canvasInfo);
          if (!Util.isNullOrNil(localTimeLineObject.canvasInfo))
          {
            localObject1 = XmlParser.parseXml(localTimeLineObject.canvasInfo, "adxml", null);
            if (((Map)localObject1).size() > 0)
            {
              ((aml)localObject2).bgf(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((aml)localObject2).bgg(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramSnsInfo.isAd()) {
            break label1251;
          }
          localObject3 = paramSnsInfo.getAdXml();
          localObject4 = new amo();
          if (!Util.isNullOrNil(localcnb.MsJ)) {
            break label1221;
          }
          localObject1 = localTimeLineObject.ContentDesc;
          ((amo)localObject4).izb = ((String)localObject1);
          ((amo)localObject4).LxJ = localcnb.ERX;
          ((amo)localObject4).iyZ = localcnb.MsF;
          ((amo)localObject4).izf = localTimeLineObject.streamvideo.izf;
          ((amo)localObject4).izg = localTimeLineObject.streamvideo.izg;
          if (Util.isNullOrNil(((amo)localObject4).izg)) {
            ((amo)localObject4).izg = localTimeLineObject.Id;
          }
          if (!Util.isNullOrNil(localcnb.MsI)) {
            break label1231;
          }
          localObject1 = localcnb.Msz;
          ((amo)localObject4).ize = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            ((amo)localObject4).izd = ((ADXml)localObject3).attachShareLinkUrl;
            ((amo)localObject4).izc = ((ADXml)localObject3).attachShareLinkWording;
          }
          ((aml)localObject2).a((amo)localObject4);
          i = 16;
          j = 15;
          ((aml)localObject2).ajd(j);
          localObject1 = e.aNx(((aml)localObject2).LvL);
          if (localObject1 == null) {
            break label1241;
          }
          ((aml)localObject2).ajc(((com.tencent.mm.plugin.sight.base.a)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localanb.bH((LinkedList)localObject1);
          paramcz.dFZ.dGb = localanb;
          paramcz.dFZ.type = i;
          a((aml)localObject2, paramSnsInfo);
          Log.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramSnsInfo, "save bmp error %s", new Object[] { paramSnsInfo.getMessage() });
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + s.YS(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramcz.dFZ.dGe = 2131759226;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localcnb.MsJ;
      continue;
      label1221:
      localObject1 = localcnb.MsJ;
      continue;
      label1231:
      localObject1 = localcnb.MsI;
      continue;
      label1241:
      ((aml)localObject2).ajc(1);
      continue;
      label1251:
      i = 4;
    }
  }
  
  public static boolean a(cz paramcz, SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramcz == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97659);
      return false;
    }
    cnb localcnb = an.a(paramSnsInfo, paramString);
    if (localcnb == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { r.Jb(paramSnsInfo.field_snsId), paramString });
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramSnsInfo.getUserName() });
    localanh.bhf(paramSnsInfo.getUserName());
    localanh.bhg(z.aTY());
    localanh.ajm(2);
    localanh.MA(paramSnsInfo.getCreateTime() * 1000L);
    localanh.bhk(paramSnsInfo.getSnsId());
    localanh.bhh(str);
    localaml.bgx(str);
    localaml.bgt(ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), paramString) + r.l(localcnb));
    if (paramSnsInfo.getTimeLine() != null)
    {
      localaml.bgE(paramSnsInfo.getTimeLine().canvasInfo);
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo))
      {
        paramString = XmlParser.parseXml(paramSnsInfo.getTimeLine().canvasInfo, "adxml", null);
        if (paramString.size() > 0)
        {
          localaml.bgf(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localaml.bgg(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localaml, paramSnsInfo);
    paramString = ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), localcnb.Id) + r.e(localcnb);
    if ((!s.YS(localaml.LvL)) && (paramSnsInfo.getUserName().endsWith(com.tencent.mm.plugin.sns.model.aj.fau())))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97659);
      return false;
    }
    if (s.YS(paramString)) {
      localaml.bgu(paramString);
    }
    for (;;)
    {
      localaml.ajd(2);
      localanb.ppH.add(localaml);
      localanb.a(localanh);
      paramcz.dFZ.dGb = localanb;
      paramcz.dFZ.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localaml.At(true);
      localaml.bgo(localcnb.Msz);
      paramSnsInfo = new anq();
      paramSnsInfo.bhv(localcnb.Msz);
      localanb.b(paramSnsInfo);
    }
  }
  
  public static boolean a(cz paramcz, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(203226);
    if (paramTimeLineObject == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(203226);
      return false;
    }
    Object localObject = String.format("%s", new Object[] { paramTimeLineObject.Id });
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localanh.bhf(paramTimeLineObject.UserName);
    localanh.bhg(z.aTY());
    localanh.ajm(2);
    localanh.MA(paramTimeLineObject.CreateTime * 1000L);
    localanh.bhk(paramTimeLineObject.Id);
    localanh.bhh((String)localObject);
    localaml.bgx((String)localObject);
    a(localaml, paramTimeLineObject);
    localaml.ajd(20);
    if (paramTimeLineObject.ContentObj.jfy != null)
    {
      localObject = new amm();
      ((amm)localObject).e(paramTimeLineObject.ContentObj.jfy);
      localaml.a((amm)localObject);
    }
    localanb.ppH.add(localaml);
    localanb.a(localanh);
    localanb.d(paramTimeLineObject.ContentObj.dME);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.type = 20;
    AppMethodBeat.o(203226);
    return true;
  }
  
  public static boolean a(cz paramcz, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramcz == null) || (!y.aQJ(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcz.dFZ.dGe = 2131759227;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = f.aQm(paramString);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = an.b((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((cnb)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { r.Jb(((SnsInfo)localObject1).field_snsId), paramString });
    localObject2 = new anh();
    paramString = ((SnsInfo)localObject1).getTimeLine();
    if (paramString == null)
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    ((anh)localObject2).bhf(((SnsInfo)localObject1).getUserName());
    ((anh)localObject2).bhg(z.aTY());
    ((anh)localObject2).ajm(2);
    ((anh)localObject2).MA(((SnsInfo)localObject1).getCreateTime() * 1000L);
    ((anh)localObject2).bhk(((SnsInfo)localObject1).getSnsId());
    ((anh)localObject2).bhh(str);
    localObject1 = new hb();
    ((hb)localObject1).dLm.type = 30;
    ((hb)localObject1).dLm.dLt = 4;
    ((hb)localObject1).dLm.desc = paramString.ContentObj.LoX;
    EventCenter.instance.publish((IEvent)localObject1);
    ((hb)localObject1).dLm.dGb.a((anh)localObject2);
    paramcz.dFZ.dGb = ((hb)localObject1).dLm.dGb;
    if (paramcz.dFZ.dGb != null)
    {
      localObject1 = paramcz.dFZ.dGb.ppH;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (aml)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((aml)localObject2).As(true);
            ((aml)localObject2).At(true);
          }
          i += 1;
        }
      }
    }
    paramcz.dFZ.desc = paramString.ContentObj.Title;
    paramcz.dFZ.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(cz paramcz, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((y.aQK(paramString)) || (paramInt < 0))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(97660);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcz.dFZ.dGe = 2131759227;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = com.tencent.mm.plugin.sns.model.aj.faO().aQm(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97660);
      return false;
    }
    cnb localcnb = an.b(paramString, paramInt);
    if (localcnb == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramcz, paramString, localcnb.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(cz paramcz, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((y.aQK(paramString)) || (paramCharSequence == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramcz.dFZ.dGe = 2131759209;
      AppMethodBeat.o(97658);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcz.dFZ.dGe = 2131759227;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = com.tencent.mm.plugin.sns.model.aj.faO().aQm(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramcz.dFZ.dGe = 2131759208;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { r.Jb(paramString.field_snsId) });
    anb localanb = new anb();
    anh localanh = new anh();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.getUserName() });
    localanh.bhf(paramString.getUserName());
    localanh.bhg(z.aTY());
    localanh.ajm(2);
    localanh.MA(paramString.getCreateTime() * 1000L);
    localanh.bhk(paramString.getSnsId());
    localanh.bhh(str);
    localanb.a(localanh);
    paramcz.dFZ.dGb = localanb;
    paramcz.dFZ.desc = paramCharSequence.toString();
    paramcz.dFZ.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(cz paramcz, String paramString1, String paramString2)
  {
    AppMethodBeat.i(258600);
    boolean bool = b(paramcz, paramString1, paramString2);
    AppMethodBeat.o(258600);
    return bool;
  }
  
  private static boolean a(anb paramanb, TimeLineObject paramTimeLineObject, anq paramanq)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.ContentObj.LoY == null) || (paramTimeLineObject.ContentObj.LoY.iAb == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    cli localcli = paramTimeLineObject.ContentObj.LoY;
    amt localamt = new amt();
    paramanb.f(localamt);
    localamt.iwe = paramTimeLineObject.ContentObj.LoY.iwe;
    localamt.iwc = localcli.iAb;
    localamt.iwf = localcli.iwf;
    localamt.iwd = localcli.iwd;
    localamt.duration = localcli.duration;
    localamt.iwg = localcli.iwg;
    localamt.vid = localcli.vid;
    localamt.videoWidth = localcli.videoWidth;
    localamt.videoHeight = localcli.videoHeight;
    localamt.dHc = paramTimeLineObject.publicUserName;
    localamt.iAg = paramTimeLineObject.sourceNickName;
    localamt.iAo = localcli.coverUrl;
    paramanq.bht(localcli.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(cz paramcz, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramcz == null) || (!y.aQJ(paramString2)) || (paramString1 == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramcz != null) {
        paramcz.dFZ.dGe = 2131759209;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (com.tencent.mm.plugin.sns.model.aj.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramcz.dFZ.dGe = 2131759227;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = f.aQm(paramString2);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramcz.dFZ.dGe = 2131759210;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((SnsInfo)localObject1).getTimeLine().ContentObj != null) && (((SnsInfo)localObject1).getTimeLine().ContentObj.LoU == 26))
    {
      boolean bool = a(paramcz, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = an.b((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((cnb)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { r.Jb(((SnsInfo)localObject1).field_snsId), paramString2 });
    paramString2 = new anb();
    anh localanh = new anh();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    localanh.bhf(((SnsInfo)localObject1).getUserName());
    localanh.bhg(z.aTY());
    localanh.ajm(2);
    localanh.MA(((SnsInfo)localObject1).getCreateTime() * 1000L);
    localanh.bhk(((SnsInfo)localObject1).getSnsId());
    localanh.bhh((String)localObject3);
    localanh.bhm(paramString1);
    paramString1 = new aml();
    paramString1.bgx((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), ((cnb)localObject2).Id) + r.e((cnb)localObject2);
      if (s.YS((String)localObject3)) {
        paramString1.bgu((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.ajd(5);
      localObject1 = ((SnsInfo)localObject1).getTimeLine();
      paramString1.bgf(((TimeLineObject)localObject1).ContentObj.Title);
      paramString1.bgg(((TimeLineObject)localObject1).ContentObj.Desc);
      paramString1.bgE(((TimeLineObject)localObject1).canvasInfo);
      if (!Util.isNullOrNil(((TimeLineObject)localObject1).canvasInfo))
      {
        localObject2 = XmlParser.parseXml(((TimeLineObject)localObject1).canvasInfo, "adxml", null);
        if (((Map)localObject2).size() > 0)
        {
          paramString1.bgf(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.bgg(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.As(true);
      paramString2.ppH.add(paramString1);
      localObject2 = new anq();
      ((anq)localObject2).ajo(((TimeLineObject)localObject1).contentattr);
      ((anq)localObject2).bhs(paramString1.title);
      if ((((TimeLineObject)localObject1).webSearchInfo != null) && (!Util.isNullOrNil(((TimeLineObject)localObject1).webSearchInfo.IEy)))
      {
        paramString1 = new com.tencent.mm.plugin.websearch.api.aj();
        paramString1.IEy = ((TimeLineObject)localObject1).webSearchInfo.IEy;
        paramString1.IEz = ((TimeLineObject)localObject1).webSearchInfo.IEz;
        paramString1.IEA = ((TimeLineObject)localObject1).webSearchInfo.IEA;
        paramString1.IEB = ((TimeLineObject)localObject1).webSearchInfo.IEB;
        paramString1.IEC = ((TimeLineObject)localObject1).webSearchInfo.IEC;
        paramString1.rCq = ((TimeLineObject)localObject1).webSearchInfo.rCq;
        paramString1.msN = ((TimeLineObject)localObject1).webSearchInfo.msN;
        paramString1.xDQ = ((TimeLineObject)localObject1).webSearchInfo.xDQ;
        paramString1.IED = ((TimeLineObject)localObject1).webSearchInfo.IED;
        paramString1.IEE = ((TimeLineObject)localObject1).webSearchInfo.IEE;
        paramString1.IEF = ((TimeLineObject)localObject1).webSearchInfo.IEF;
        paramString1.source = ((TimeLineObject)localObject1).webSearchInfo.source;
        paramString1.eby = ((TimeLineObject)localObject1).webSearchInfo.eby;
        paramString1.IEG = ((TimeLineObject)localObject1).webSearchInfo.IEG;
        paramString1.IEH = ((TimeLineObject)localObject1).webSearchInfo.IEH;
        paramString1.IEI = ((TimeLineObject)localObject1).webSearchInfo.IEI;
        paramString1.IEJ = ((TimeLineObject)localObject1).webSearchInfo.IEJ;
        paramString1.IEK = ((TimeLineObject)localObject1).webSearchInfo.IEK;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).webSearchInfo.thumbUrl;
        paramString1.IEL = ((TimeLineObject)localObject1).webSearchInfo.IEL;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((anq)localObject2).bhx(((StringBuilder)localObject3).toString());
      }
      paramString2.b((anq)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (anq)localObject2);
      paramString2.a(localanh);
      paramcz.dFZ.dGb = paramString2;
      paramcz.dFZ.desc = ((TimeLineObject)localObject1).ContentObj.Title;
      paramcz.dFZ.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.At(true);
      paramString1.bgo(((cnb)localObject2).Msz);
      localObject3 = new anq();
      ((anq)localObject3).bhv(((cnb)localObject2).Msz);
      paramString2.b((anq)localObject3);
      continue;
      paramString1.At(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.l.a
 * JD-Core Version:    0.7.0.1
 */