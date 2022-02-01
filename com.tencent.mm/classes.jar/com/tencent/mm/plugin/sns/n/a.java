package com.tencent.mm.plugin.sns.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.Map;

public final class a
{
  public static void a(arf paramarf, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97662);
    if (paramSnsInfo != null) {
      a(paramarf, paramSnsInfo.getTimeLine());
    }
    AppMethodBeat.o(97662);
  }
  
  public static void a(arf paramarf, TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97661);
    if ((paramarf != null) && (paramTimeLineObject != null) && (!Util.isNullOrNil(paramTimeLineObject.statExtStr))) {
      paramarf.bsM(paramTimeLineObject.statExtStr);
    }
    AppMethodBeat.o(97661);
  }
  
  public static boolean a(dn paramdn, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97654);
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
      paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      AppMethodBeat.o(97654);
      return false;
    }
    arv localarv = new arv();
    Object localObject2 = new asb();
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    dmz localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
    if ((paramSnsInfo.isAd()) && (localTimeLineObject.ContentObj.Zpq == 15))
    {
      localTimeLineObject.streamvideo.nTA = paramSnsInfo.getAdInfo().uxInfo;
      localTimeLineObject.streamvideo.nTB = localTimeLineObject.Id;
    }
    Object localObject1 = String.format("%s#%s", new Object[] { t.uA(paramSnsInfo.field_snsId), localdmz.Id });
    ((asb)localObject2).bto(paramSnsInfo.field_userName);
    ((asb)localObject2).btp(z.bAM());
    ((asb)localObject2).axH(2);
    ((asb)localObject2).yu(Util.nowMilliSecond());
    ((asb)localObject2).btt(paramSnsInfo.getSnsId());
    ((asb)localObject2).btq((String)localObject1);
    localarv.a((asb)localObject2);
    localObject2 = new arf();
    ((arf)localObject2).bsG((String)localObject1);
    localObject1 = as.mg(al.getAccSnsPath(), localdmz.Id);
    Object localObject4 = t.i(localdmz);
    Object localObject3 = t.d(localdmz);
    if (Util.isNullOrNil(az.a(paramSnsInfo.getLocalid(), localdmz)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
      paramdn.hDr.hDx = b.j.favorite_fail_sns_sight;
      AppMethodBeat.o(97654);
      return false;
    }
    if (!y.ZC((String)localObject1 + (String)localObject4))
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + y.ZC(new StringBuilder().append((String)localObject1).append((String)localObject4).toString()) + " thumb:" + y.ZC(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
      paramdn.hDr.hDx = b.j.favorite_fail_sns_sight;
      AppMethodBeat.o(97654);
      return false;
    }
    int j;
    int i;
    Bitmap localBitmap;
    if (!y.ZC((String)localObject1 + (String)localObject3))
    {
      int k = 320;
      int m = 240;
      j = m;
      i = k;
      if (localdmz.aaTn != null)
      {
        j = m;
        i = k;
        if (localdmz.aaTn.aaUc > 0.0F)
        {
          j = m;
          i = k;
          if (localdmz.aaTn.aaUb > 0.0F)
          {
            i = (int)localdmz.aaTn.aaUb;
            j = (int)localdmz.aaTn.aaUc;
          }
        }
      }
      localBitmap = f.aK((String)localObject1 + (String)localObject4, i, j);
      if (localBitmap == null)
      {
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + y.ZC(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramdn.hDr.hDx = b.j.favorite_fail_sns_sight;
        AppMethodBeat.o(97654);
        return false;
      }
    }
    for (;;)
    {
      try
      {
        BitmapUtil.saveBitmapToImage(localBitmap, 60, Bitmap.CompressFormat.JPEG, (String)localObject1 + (String)localObject3, true);
        ((arf)localObject2).bsC((String)localObject1 + (String)localObject4);
        ((arf)localObject2).bsD((String)localObject1 + (String)localObject3);
        if (Util.isNullOrNil(localdmz.aaTv))
        {
          localObject1 = localTimeLineObject.ContentDesc;
          ((arf)localObject2).bso((String)localObject1);
          ((arf)localObject2).bsN(localTimeLineObject.canvasInfo);
          if (!Util.isNullOrNil(localTimeLineObject.canvasInfo))
          {
            localObject1 = XmlParser.parseXml(localTimeLineObject.canvasInfo, "adxml", null);
            if (((Map)localObject1).size() > 0)
            {
              ((arf)localObject2).bso(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareTitle"), ""));
              ((arf)localObject2).bsp(Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareDesc"), ""));
            }
          }
          j = 4;
          if (!paramSnsInfo.isAd()) {
            break label1256;
          }
          localObject3 = paramSnsInfo.getAdXml();
          localObject4 = new ari();
          if (!Util.isNullOrNil(localdmz.aaTv)) {
            break label1226;
          }
          localObject1 = localTimeLineObject.ContentDesc;
          ((ari)localObject4).nTw = ((String)localObject1);
          ((ari)localObject4).ZBc = localdmz.RGm;
          ((ari)localObject4).nTu = localdmz.aaTr;
          ((ari)localObject4).nTA = localTimeLineObject.streamvideo.nTA;
          ((ari)localObject4).nTB = localTimeLineObject.streamvideo.nTB;
          if (Util.isNullOrNil(((ari)localObject4).nTB)) {
            ((ari)localObject4).nTB = localTimeLineObject.Id;
          }
          if (!Util.isNullOrNil(localdmz.aaTu)) {
            break label1236;
          }
          localObject1 = localdmz.aaTl;
          ((ari)localObject4).nTz = ((String)localObject1);
          if ((localObject3 != null) && (((ADXml)localObject3).attachShareLinkIsHidden == 0))
          {
            ((ari)localObject4).nTy = ((ADXml)localObject3).attachShareLinkUrl;
            ((ari)localObject4).nTx = ((ADXml)localObject3).attachShareLinkWording;
          }
          ((arf)localObject2).a((ari)localObject4);
          i = 16;
          j = 15;
          ((arf)localObject2).axy(j);
          localObject1 = f.aVX(((arf)localObject2).Zzd);
          if (localObject1 == null) {
            break label1246;
          }
          ((arf)localObject2).axx(((b)localObject1).getVideoDuration());
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          localarv.cs((LinkedList)localObject1);
          paramdn.hDr.hDt = localarv;
          paramdn.hDr.type = i;
          a((arf)localObject2, paramSnsInfo);
          Log.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(97654);
          return true;
        }
      }
      catch (Exception paramSnsInfo)
      {
        Log.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", paramSnsInfo, "save bmp error %s", new Object[] { paramSnsInfo.getMessage() });
        Log.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + y.ZC(new StringBuilder().append((String)localObject1).append((String)localObject3).toString()));
        paramdn.hDr.hDx = b.j.favorite_fail_sns_sight;
        AppMethodBeat.o(97654);
        return false;
      }
      localObject1 = localdmz.aaTv;
      continue;
      label1226:
      localObject1 = localdmz.aaTv;
      continue;
      label1236:
      localObject1 = localdmz.aaTu;
      continue;
      label1246:
      ((arf)localObject2).axx(1);
      continue;
      label1256:
      i = 4;
    }
  }
  
  public static boolean a(dn paramdn, SnsInfo paramSnsInfo, String paramString)
  {
    AppMethodBeat.i(97659);
    if ((paramdn == null) || (Util.isNullOrNil(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97659);
      return false;
    }
    if (paramSnsInfo == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    dmz localdmz = ap.a(paramSnsInfo, paramString);
    if (localdmz == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    String str = String.format("%s#%s", new Object[] { t.uA(paramSnsInfo.field_snsId), paramString });
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[] { paramSnsInfo.getUserName() });
    localasb.bto(paramSnsInfo.getUserName());
    localasb.btp(z.bAM());
    localasb.axH(2);
    localasb.yu(paramSnsInfo.getCreateTime() * 1000L);
    localasb.btt(paramSnsInfo.getSnsId());
    localasb.btq(str);
    localarf.bsG(str);
    localarf.bsC(as.mg(al.getAccSnsPath(), paramString) + t.k(localdmz));
    if (paramSnsInfo.getTimeLine() != null)
    {
      localarf.bsN(paramSnsInfo.getTimeLine().canvasInfo);
      if (!Util.isNullOrNil(paramSnsInfo.getTimeLine().canvasInfo))
      {
        paramString = XmlParser.parseXml(paramSnsInfo.getTimeLine().canvasInfo, "adxml", null);
        if (paramString.size() > 0)
        {
          localarf.bso(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareTitle"), ""));
          localarf.bsp(Util.nullAs((String)paramString.get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
    }
    a(localarf, paramSnsInfo);
    paramString = as.mg(al.getAccSnsPath(), localdmz.Id) + t.d(localdmz);
    if ((!y.ZC(localarf.Zzd)) && (paramSnsInfo.getUserName().endsWith(al.hgg())))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97659);
      return false;
    }
    if (y.ZC(paramString)) {
      localarf.bsD(paramString);
    }
    for (;;)
    {
      localarf.axy(2);
      localarv.vEn.add(localarf);
      localarv.a(localasb);
      paramdn.hDr.hDt = localarv;
      paramdn.hDr.type = 2;
      AppMethodBeat.o(97659);
      return true;
      localarf.Kk(true);
      localarf.bsx(localdmz.aaTl);
      paramSnsInfo = new ask();
      paramSnsInfo.btE(localdmz.aaTl);
      localarv.c(paramSnsInfo);
    }
  }
  
  public static boolean a(dn paramdn, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(97663);
    if ((paramdn == null) || (!ai.baq(paramString)))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97663);
      return false;
    }
    if (al.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdn.hDr.hDx = b.j.favorite_fail_system_error;
      AppMethodBeat.o(97663);
      return false;
    }
    Object localObject1 = l.aZL(paramString);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97663);
      return false;
    }
    paramString = "0";
    Object localObject2 = ap.d((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString = ((dmz)localObject2).Id;
    }
    String str = String.format("%s#%s", new Object[] { t.uA(((SnsInfo)localObject1).field_snsId), paramString });
    localObject2 = new asb();
    paramString = ((SnsInfo)localObject1).getTimeLine();
    if (paramString == null)
    {
      Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
      AppMethodBeat.o(97663);
      return false;
    }
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    ((asb)localObject2).bto(((SnsInfo)localObject1).getUserName());
    ((asb)localObject2).btp(z.bAM());
    ((asb)localObject2).axH(2);
    ((asb)localObject2).yu(((SnsInfo)localObject1).getCreateTime() * 1000L);
    ((asb)localObject2).btt(((SnsInfo)localObject1).getSnsId());
    ((asb)localObject2).btq(str);
    localObject1 = new ht();
    ((ht)localObject1).hIR.type = 30;
    ((ht)localObject1).hIR.hIY = 4;
    ((ht)localObject1).hIR.desc = paramString.ContentObj.Zpt;
    ((ht)localObject1).publish();
    ((ht)localObject1).hIR.hDt.a((asb)localObject2);
    paramdn.hDr.hDt = ((ht)localObject1).hIR.hDt;
    if (paramdn.hDr.hDt != null)
    {
      localObject1 = paramdn.hDr.hDt.vEn;
      if (localObject1 != null) {
        while (i < ((LinkedList)localObject1).size())
        {
          localObject2 = (arf)((LinkedList)localObject1).get(i);
          if (localObject2 != null)
          {
            ((arf)localObject2).Kj(true);
            ((arf)localObject2).Kk(true);
          }
          i += 1;
        }
      }
    }
    paramdn.hDr.desc = paramString.ContentObj.hAP;
    paramdn.hDr.type = 18;
    AppMethodBeat.o(97663);
    return true;
  }
  
  public static boolean a(dn paramdn, String paramString, int paramInt)
  {
    AppMethodBeat.i(97660);
    if ((ai.bar(paramString)) || (paramInt < 0))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
      paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      AppMethodBeat.o(97660);
      return false;
    }
    if (al.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdn.hDr.hDx = b.j.favorite_fail_system_error;
      AppMethodBeat.o(97660);
      return false;
    }
    paramString = al.hgB().aZL(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97660);
      return false;
    }
    dmz localdmz = ap.d(paramString, paramInt);
    if (localdmz == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97660);
      return false;
    }
    boolean bool = a(paramdn, paramString, localdmz.Id);
    AppMethodBeat.o(97660);
    return bool;
  }
  
  public static boolean a(dn paramdn, String paramString, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(97658);
    if ((ai.bar(paramString)) || (paramCharSequence == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
      paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      AppMethodBeat.o(97658);
      return false;
    }
    if (al.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdn.hDr.hDx = b.j.favorite_fail_system_error;
      AppMethodBeat.o(97658);
      return false;
    }
    paramString = al.hgB().aZL(paramString);
    if (paramString == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97658);
      return false;
    }
    if (0L == paramString.field_snsId)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
      paramdn.hDr.hDx = b.j.favorite_fail;
      AppMethodBeat.o(97658);
      return false;
    }
    String str = String.format("%s#0", new Object[] { t.uA(paramString.field_snsId) });
    arv localarv = new arv();
    asb localasb = new asb();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[] { paramString.getUserName() });
    localasb.bto(paramString.getUserName());
    localasb.btp(z.bAM());
    localasb.axH(2);
    localasb.yu(paramString.getCreateTime() * 1000L);
    localasb.btt(paramString.getSnsId());
    localasb.btq(str);
    localarv.a(localasb);
    paramdn.hDr.hDt = localarv;
    paramdn.hDr.desc = paramCharSequence.toString();
    paramdn.hDr.type = 1;
    AppMethodBeat.o(97658);
    return true;
  }
  
  public static boolean a(dn paramdn, String paramString1, String paramString2)
  {
    AppMethodBeat.i(369891);
    boolean bool = b(paramdn, paramString1, paramString2);
    AppMethodBeat.o(369891);
    return bool;
  }
  
  private static boolean a(arv paramarv, TimeLineObject paramTimeLineObject, ask paramask)
  {
    AppMethodBeat.i(97657);
    if ((paramTimeLineObject.ContentObj.Zpu == null) || (paramTimeLineObject.ContentObj.Zpu.nUA == -1))
    {
      AppMethodBeat.o(97657);
      return false;
    }
    dll localdll = paramTimeLineObject.ContentObj.Zpu;
    arn localarn = new arn();
    paramarv.f(localarn);
    localarn.nQo = paramTimeLineObject.ContentObj.Zpu.nQo;
    localarn.nQm = localdll.nUA;
    localarn.nQp = localdll.nQp;
    localarn.nQn = localdll.nQn;
    localarn.duration = localdll.duration;
    localarn.nQq = localdll.nQq;
    localarn.vid = localdll.vid;
    localarn.videoWidth = localdll.videoWidth;
    localarn.videoHeight = localdll.videoHeight;
    localarn.hEE = paramTimeLineObject.publicUserName;
    localarn.nUF = paramTimeLineObject.sourceNickName;
    localarn.nUM = localdll.coverUrl;
    paramask.btC(localdll.desc);
    AppMethodBeat.o(97657);
    return true;
  }
  
  public static boolean b(dn paramdn, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97656);
    if ((paramdn == null) || (!ai.baq(paramString2)) || (paramString1 == null))
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
      if (paramdn != null) {
        paramdn.hDr.hDx = b.j.favorite_fail_argument_error;
      }
      AppMethodBeat.o(97656);
      return false;
    }
    if (al.isInValid())
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
      paramdn.hDr.hDx = b.j.favorite_fail_system_error;
      AppMethodBeat.o(97656);
      return false;
    }
    Object localObject1 = l.aZL(paramString2);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
      paramdn.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      AppMethodBeat.o(97656);
      return false;
    }
    if ((((SnsInfo)localObject1).getTimeLine().ContentObj != null) && (((SnsInfo)localObject1).getTimeLine().ContentObj.Zpq == 26))
    {
      boolean bool = a(paramdn, paramString2);
      AppMethodBeat.o(97656);
      return bool;
    }
    paramString2 = "0";
    Object localObject2 = ap.d((SnsInfo)localObject1, 0);
    if (localObject2 != null) {
      paramString2 = ((dmz)localObject2).Id;
    }
    Object localObject3 = String.format("%s#%s", new Object[] { t.uA(((SnsInfo)localObject1).field_snsId), paramString2 });
    paramString2 = new arv();
    asb localasb = new asb();
    Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[] { ((SnsInfo)localObject1).getUserName() });
    localasb.bto(((SnsInfo)localObject1).getUserName());
    localasb.btp(z.bAM());
    localasb.axH(2);
    localasb.yu(((SnsInfo)localObject1).getCreateTime() * 1000L);
    localasb.btt(((SnsInfo)localObject1).getSnsId());
    localasb.btq((String)localObject3);
    localasb.btv(paramString1);
    paramString1 = new arf();
    paramString1.bsG((String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = as.mg(al.getAccSnsPath(), ((dmz)localObject2).Id) + t.d((dmz)localObject2);
      if (y.ZC((String)localObject3)) {
        paramString1.bsD((String)localObject3);
      }
    }
    for (;;)
    {
      paramString1.axy(5);
      localObject1 = ((SnsInfo)localObject1).getTimeLine();
      paramString1.bso(((TimeLineObject)localObject1).ContentObj.hAP);
      paramString1.bsp(((TimeLineObject)localObject1).ContentObj.IGG);
      paramString1.bsN(((TimeLineObject)localObject1).canvasInfo);
      if (!Util.isNullOrNil(((TimeLineObject)localObject1).canvasInfo))
      {
        localObject2 = XmlParser.parseXml(((TimeLineObject)localObject1).canvasInfo, "adxml", null);
        if (((Map)localObject2).size() > 0)
        {
          paramString1.bso(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareTitle"), ""));
          paramString1.bsp(Util.nullAs((String)((Map)localObject2).get(".adxml.adCanvasInfo.shareDesc"), ""));
        }
      }
      a(paramString1, (TimeLineObject)localObject1);
      paramString1.Kj(true);
      paramString2.vEn.add(paramString1);
      localObject2 = new ask();
      ((ask)localObject2).axJ(((TimeLineObject)localObject1).contentattr);
      ((ask)localObject2).btB(paramString1.title);
      if ((((TimeLineObject)localObject1).webSearchInfo != null) && (!Util.isNullOrNil(((TimeLineObject)localObject1).webSearchInfo.WoZ)))
      {
        paramString1 = new ak();
        paramString1.WoZ = ((TimeLineObject)localObject1).webSearchInfo.WoZ;
        paramString1.Wpa = ((TimeLineObject)localObject1).webSearchInfo.Wpa;
        paramString1.Wpb = ((TimeLineObject)localObject1).webSearchInfo.Wpb;
        paramString1.Wpc = ((TimeLineObject)localObject1).webSearchInfo.Wpc;
        paramString1.Wpd = ((TimeLineObject)localObject1).webSearchInfo.Wpd;
        paramString1.ytZ = ((TimeLineObject)localObject1).webSearchInfo.ytZ;
        paramString1.svG = ((TimeLineObject)localObject1).webSearchInfo.svG;
        paramString1.ICb = ((TimeLineObject)localObject1).webSearchInfo.ICb;
        paramString1.Wpe = ((TimeLineObject)localObject1).webSearchInfo.Wpe;
        paramString1.Wpf = ((TimeLineObject)localObject1).webSearchInfo.Wpf;
        paramString1.Wpg = ((TimeLineObject)localObject1).webSearchInfo.Wpg;
        paramString1.source = ((TimeLineObject)localObject1).webSearchInfo.source;
        paramString1.ibx = ((TimeLineObject)localObject1).webSearchInfo.ibx;
        paramString1.Wph = ((TimeLineObject)localObject1).webSearchInfo.Wph;
        paramString1.Wpi = ((TimeLineObject)localObject1).webSearchInfo.Wpi;
        paramString1.Wpj = ((TimeLineObject)localObject1).webSearchInfo.Wpj;
        paramString1.Wpk = ((TimeLineObject)localObject1).webSearchInfo.Wpk;
        paramString1.Wpl = ((TimeLineObject)localObject1).webSearchInfo.Wpl;
        paramString1.thumbUrl = ((TimeLineObject)localObject1).webSearchInfo.thumbUrl;
        paramString1.Wpm = ((TimeLineObject)localObject1).webSearchInfo.Wpm;
        localObject3 = new StringBuilder();
        paramString1.a((StringBuilder)localObject3, null, null, null, 0, 0);
        ((ask)localObject2).btG(((StringBuilder)localObject3).toString());
      }
      paramString2.c((ask)localObject2);
      a(paramString2, (TimeLineObject)localObject1, (ask)localObject2);
      paramString2.a(localasb);
      paramdn.hDr.hDt = paramString2;
      paramdn.hDr.desc = ((TimeLineObject)localObject1).ContentObj.hAP;
      paramdn.hDr.type = 5;
      AppMethodBeat.o(97656);
      return true;
      paramString1.Kk(true);
      paramString1.bsx(((dmz)localObject2).aaTl);
      localObject3 = new ask();
      ((ask)localObject3).btE(((dmz)localObject2).aaTl);
      paramString2.c((ask)localObject3);
      continue;
      paramString1.Kk(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.n.a
 * JD-Core Version:    0.7.0.1
 */