package com.tencent.mm.plugin.sns.j;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class n
{
  public static String mqD = "<TimelineObject>";
  public static String mqE = "</TimelineObject>";
  public static String muL = "]]>";
  
  private static String apk(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String apl(String paramString)
  {
    AppMethodBeat.i(96171);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96171);
      return "";
    }
    if (paramString.matches("\\d*")) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(96171);
      return paramString;
    }
    AppMethodBeat.o(96171);
    return "";
  }
  
  public static String f(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(96172);
    n.a locala = new n.a();
    Object localObject1 = new HashMap();
    locala.Oq("TimelineObject");
    locala.Oq("id");
    Object localObject2;
    label2318:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.Or("id");
      if (paramTimeLineObject.mAQ != null)
      {
        locala.Oq("username");
        locala.setText(paramTimeLineObject.mAQ);
        locala.Or("username");
      }
      locala.Oq("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.Or("createTime");
      locala.Oq("contentDescShowType");
      locala.setText(paramTimeLineObject.Eto);
      locala.Or("contentDescShowType");
      locala.Oq("contentDescScene");
      locala.setText(paramTimeLineObject.Etp);
      locala.Or("contentDescScene");
      locala.Oq("private");
      locala.setText(paramTimeLineObject.DMS);
      locala.Or("private");
      if ((paramTimeLineObject.Etl != null) && (!bt.isNullOrNil(paramTimeLineObject.Etl.Id)))
      {
        locala.Oq("appInfo");
        locala.Oq("id");
        locala.setText(apk(paramTimeLineObject.Etl.Id));
        locala.Or("id");
        locala.Oq("version");
        locala.setText(apk(paramTimeLineObject.Etl.Version));
        locala.Or("version");
        locala.Oq("appName");
        locala.setText(apk(paramTimeLineObject.Etl.scR));
        locala.Or("appName");
        locala.Oq("installUrl");
        locala.setText(apk(paramTimeLineObject.Etl.Cyw));
        locala.Or("installUrl");
        locala.Oq("fromUrl");
        locala.setText(apk(paramTimeLineObject.Etl.Cyx));
        locala.Or("fromUrl");
        locala.Or("appInfo");
      }
      if ((paramTimeLineObject.Etr != null) && (!bt.isNullOrNil(paramTimeLineObject.Etr.gJv)))
      {
        locala.Oq("streamvideo");
        locala.Oq("streamvideourl");
        locala.setText(apk(paramTimeLineObject.Etr.gJv));
        locala.Or("streamvideourl");
        locala.Oq("streamvideototaltime");
        locala.setText(paramTimeLineObject.Etr.gJw);
        locala.Or("streamvideototaltime");
        locala.Oq("streamvideotitle");
        locala.setText(apk(paramTimeLineObject.Etr.gJx));
        locala.Or("streamvideotitle");
        locala.Oq("streamvideowording");
        locala.setText(apk(paramTimeLineObject.Etr.gJy));
        locala.Or("streamvideowording");
        locala.Oq("streamvideoweburl");
        locala.setText(apk(paramTimeLineObject.Etr.gJz));
        locala.Or("streamvideoweburl");
        locala.Oq("streamvideothumburl");
        locala.setText(apk(paramTimeLineObject.Etr.gJA));
        locala.Or("streamvideothumburl");
        locala.Oq("streamvideoaduxinfo");
        locala.setText(apk(paramTimeLineObject.Etr.gJB));
        locala.Or("streamvideoaduxinfo");
        locala.Oq("streamvideopublishid");
        locala.setText(apk(paramTimeLineObject.Etr.gJC));
        locala.Or("streamvideopublishid");
        locala.Or("streamvideo");
      }
      if ((paramTimeLineObject.wLn != null) && (!bt.isNullOrNil(paramTimeLineObject.wLn.AGs)))
      {
        locala.Oq("websearch");
        locala.Oq("relevant_vid");
        locala.setText(apk(paramTimeLineObject.wLn.AGs));
        locala.Or("relevant_vid");
        locala.Oq("relevant_expand");
        locala.setText(apk(paramTimeLineObject.wLn.AGt));
        locala.Or("relevant_expand");
        locala.Oq("relevant_pre_searchid");
        locala.setText(apk(paramTimeLineObject.wLn.AGu));
        locala.Or("relevant_pre_searchid");
        locala.Oq("relevant_shared_openid");
        locala.setText(apk(paramTimeLineObject.wLn.AGv));
        locala.Or("relevant_shared_openid");
        locala.Oq("rec_category");
        locala.setText(apk(paramTimeLineObject.wLn.AGw));
        locala.Or("rec_category");
        locala.Oq("shareUrl");
        locala.setText(apk(paramTimeLineObject.wLn.oYa));
        locala.Or("shareUrl");
        locala.Oq("shareTitle");
        locala.setText(apk(paramTimeLineObject.wLn.oYb));
        locala.Or("shareTitle");
        locala.Oq("shareDesc");
        locala.setText(apk(paramTimeLineObject.wLn.rUO));
        locala.Or("shareDesc");
        locala.Oq("shareImgUrl");
        locala.setText(apk(paramTimeLineObject.wLn.AGx));
        locala.Or("shareImgUrl");
        locala.Oq("shareString");
        locala.setText(apk(paramTimeLineObject.wLn.AGy));
        locala.Or("shareString");
        locala.Oq("shareStringUrl");
        locala.setText(apk(paramTimeLineObject.wLn.AGz));
        locala.Or("shareStringUrl");
        locala.Oq("source");
        locala.setText(apk(paramTimeLineObject.wLn.source));
        locala.Or("source");
        locala.Oq("strPlayCount");
        locala.setText(apk(paramTimeLineObject.wLn.AGA));
        locala.Or("strPlayCount");
        locala.Oq("titleUrl");
        locala.setText(apk(paramTimeLineObject.wLn.AGB));
        locala.Or("titleUrl");
        locala.Oq("extReqParams");
        locala.setText(apk(paramTimeLineObject.wLn.AGC));
        locala.Or("extReqParams");
        locala.Oq("tagList");
        locala.setText(apk(paramTimeLineObject.wLn.AGD));
        locala.Or("tagList");
        locala.Oq("channelId");
        locala.setText(apk(paramTimeLineObject.wLn.AGE));
        locala.Or("channelId");
        locala.Oq("thumbUrl");
        locala.setText(apk(paramTimeLineObject.wLn.thumbUrl));
        locala.Or("thumbUrl");
        locala.Oq("shareTag");
        locala.setText(apk(paramTimeLineObject.wLn.AGF));
        locala.Or("shareTag");
        locala.Or("websearch");
      }
      locala.Oq("contentDesc");
      locala.setText(apk(paramTimeLineObject.Etj));
      locala.Or("contentDesc");
      locala.Oq("contentattr");
      locala.setText(paramTimeLineObject.gHj);
      locala.Or("contentattr");
      locala.Oq("sourceUserName");
      locala.setText(apk(paramTimeLineObject.jec));
      locala.Or("sourceUserName");
      locala.Oq("sourceNickName");
      locala.setText(apk(paramTimeLineObject.BXw));
      locala.Or("sourceNickName");
      locala.Oq("statisticsData");
      locala.setText(apk(paramTimeLineObject.Etq));
      locala.Or("statisticsData");
      locala.Oq("weappInfo");
      locala.Oq("appUserName");
      locala.setText(apk(paramTimeLineObject.Ets.username));
      locala.Or("appUserName");
      locala.Oq("pagePath");
      locala.setText(apk(paramTimeLineObject.Ets.path));
      locala.Or("pagePath");
      locala.Oq("version");
      locala.setText(apk(paramTimeLineObject.Ets.version));
      locala.Or("version");
      locala.Oq("debugMode");
      locala.setText(apk(paramTimeLineObject.Ets.AHI));
      locala.Or("debugMode");
      locala.Oq("shareActionId");
      locala.setText(apk(paramTimeLineObject.Ets.EGj));
      locala.Or("shareActionId");
      locala.Oq("isGame");
      locala.setText(apk(paramTimeLineObject.Ets.isGame));
      locala.Or("isGame");
      locala.Oq("messageExtraData");
      locala.setText(apk(paramTimeLineObject.Ets.dzY));
      locala.Or("messageExtraData");
      locala.Oq("subType");
      locala.setText(apk(paramTimeLineObject.Ets.subType));
      locala.Or("subType");
      locala.Or("weappInfo");
      locala.Oq("canvasInfoXml");
      locala.setText(apk(paramTimeLineObject.xpl));
      locala.Or("canvasInfoXml");
      if (paramTimeLineObject.Etk != null)
      {
        float f1 = paramTimeLineObject.Etk.COI;
        float f2 = paramTimeLineObject.Etk.COJ;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.Etk.COI);
          ((Map)localObject1).put("latitude", paramTimeLineObject.Etk.COJ);
          ((Map)localObject1).put("city", bt.aGf(apk(paramTimeLineObject.Etk.ijO)));
          ((Map)localObject1).put("poiName", bt.aGf(apk(paramTimeLineObject.Etk.goQ)));
          ((Map)localObject1).put("poiAddress", bt.aGf(apk(paramTimeLineObject.Etk.xoe)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.Etk.DJY);
          ((Map)localObject1).put("poiClassifyId", apk(paramTimeLineObject.Etk.DlE));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.Etk.xog);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.Etk.DJZ);
          locala.p("location", (Map)localObject1);
          locala.Or("location");
        }
      }
      locala.Oq("ContentObject");
      locala.Oq("contentStyle");
      locala.setText(paramTimeLineObject.Etm.DaB);
      locala.Or("contentStyle");
      locala.Oq("contentSubStyle");
      locala.setText(paramTimeLineObject.Etm.DaD);
      locala.Or("contentSubStyle");
      locala.Oq("title");
      locala.setText(apk(paramTimeLineObject.Etm.Title));
      locala.Or("title");
      locala.Oq("description");
      locala.setText(apk(paramTimeLineObject.Etm.Desc));
      locala.Or("description");
      locala.Oq("contentUrl");
      locala.setText(apk(paramTimeLineObject.Etm.Url));
      locala.Or("contentUrl");
      if (paramTimeLineObject.Etm.DaC.size() <= 0) {
        break label3264;
      }
      locala.Oq("mediaList");
      localObject2 = paramTimeLineObject.Etm.DaC.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3256;
      }
      localObject3 = (bpi)((Iterator)localObject2).next();
      locala.Oq("media");
      locala.Oq("id");
      if (!apl(((bpi)localObject3).Id).equals("")) {
        break label3240;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.Or("id");
      locala.Oq("type");
      locala.setText(((bpi)localObject3).mBH);
      locala.Or("type");
      locala.Oq("title");
      locala.setText(apk(((bpi)localObject3).Title));
      locala.Or("title");
      locala.Oq("description");
      locala.setText(apk(((bpi)localObject3).Desc));
      locala.Or("description");
      locala.Oq("private");
      locala.setText(((bpi)localObject3).DMS);
      locala.Or("private");
      if (!bt.isNullOrNil(((bpi)localObject3).songAlbumUrl))
      {
        locala.Oq("songalbumurl");
        locala.setText(((bpi)localObject3).songAlbumUrl);
        locala.Or("songalbumurl");
      }
      if (!bt.isNullOrNil(((bpi)localObject3).songLyric))
      {
        locala.Oq("songlyric");
        locala.setText(((bpi)localObject3).songLyric);
        locala.Or("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((bpi)localObject3).Dzl);
      if (!bt.isNullOrNil(((bpi)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((bpi)localObject3).md5);
      }
      if (!bt.isNullOrNil(((bpi)localObject3).DNl)) {
        ((Map)localObject1).put("videomd5", ((bpi)localObject3).DNl);
      }
      locala.p("url", (Map)localObject1);
      locala.setText(apk(((bpi)localObject3).Url));
      locala.Or("url");
      if ((((bpi)localObject3).DMQ != null) && (!((bpi)localObject3).DMQ.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bpi)localObject3).DMR);
        locala.p("thumb", (Map)localObject1);
        locala.setText(apk(((bpi)localObject3).DMQ));
        locala.Or("thumb");
      }
      locala.Oq("videoDuration");
      locala.setText(((bpi)localObject3).DNm);
      locala.Or("videoDuration");
      if (((bpi)localObject3).subType > 0)
      {
        locala.Oq("subType");
        locala.setText(((bpi)localObject3).subType);
        locala.Or("subType");
      }
      if (!bt.isNullOrNil(((bpi)localObject3).xmd))
      {
        locala.Oq("userData");
        locala.setText(((bpi)localObject3).xmd);
        locala.Or("userData");
      }
      if ((((bpi)localObject3).DMU != null) && (!((bpi)localObject3).DMU.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bpi)localObject3).DMV);
        locala.p("lowBandUrl", (Map)localObject1);
        locala.setText(apk(((bpi)localObject3).DMU));
        locala.Or("lowBandUrl");
      }
      if (((bpi)localObject3).DMT != null)
      {
        ((Map)localObject1).clear();
        if (((bpi)localObject3).DMT.DNH > 0.0F) {
          ((Map)localObject1).put("width", ((bpi)localObject3).DMT.DNH);
        }
        if (((bpi)localObject3).DMT.DNI > 0.0F) {
          ((Map)localObject1).put("height", ((bpi)localObject3).DMT.DNI);
        }
        if (((bpi)localObject3).DMT.DNJ > 0.0F) {
          ((Map)localObject1).put("totalSize", ((bpi)localObject3).DMT.DNJ);
        }
        locala.p("size", (Map)localObject1);
        locala.Or("size");
      }
      locala.Or("media");
      break label2318;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3240:
      locala.setText(apl(((bpi)localObject3).Id));
    }
    label3256:
    locala.Or("mediaList");
    label3264:
    locala.muN.append(apk(paramTimeLineObject.Etm.DaE));
    if ((paramTimeLineObject.Etm.DaF != null) && (paramTimeLineObject.Etm.DaF.gKq != -1))
    {
      locala.Oq("mmreadershare");
      locala.Oq("itemshowtype");
      locala.setText(paramTimeLineObject.Etm.DaF.gKq);
      locala.Or("itemshowtype");
      locala.Oq("ispaysubscribe");
      locala.setText(paramTimeLineObject.Etm.DaF.gGA);
      locala.Or("ispaysubscribe");
      if (paramTimeLineObject.Etm.DaF.gKq == 5)
      {
        locala.Oq("pubtime");
        locala.setText(paramTimeLineObject.Etm.DaF.gGy);
        locala.Or("pubtime");
        locala.Oq("vid");
        locala.setText(paramTimeLineObject.Etm.DaF.gGC);
        locala.Or("vid");
        locala.Oq("funcflag");
        locala.setText(paramTimeLineObject.Etm.DaF.gGB);
        locala.Or("funcflag");
        locala.Oq("duration");
        locala.setText(paramTimeLineObject.Etm.DaF.duration);
        locala.Or("duration");
        locala.Oq("digest");
        locala.setText(paramTimeLineObject.Etm.DaF.desc);
        locala.Or("digest");
        locala.Oq("cover");
        locala.setText(paramTimeLineObject.Etm.DaF.coverUrl);
        locala.Or("cover");
        if (!bt.isNullOrNil(paramTimeLineObject.Etm.DaF.gGC))
        {
          locala.Oq("nativepage");
          locala.setText(1);
          locala.Or("nativepage");
        }
        locala.Oq("width");
        locala.setText(paramTimeLineObject.Etm.DaF.videoWidth);
        locala.Or("width");
        locala.Oq("height");
        locala.setText(paramTimeLineObject.Etm.DaF.videoHeight);
        locala.Or("height");
      }
      locala.Or("mmreadershare");
    }
    if (paramTimeLineObject.Etm.DaG != null)
    {
      localObject1 = new b();
      ((b)localObject1).htg = paramTimeLineObject.Etm.DaG;
      locala.append(d.a(((b)localObject1).htg));
    }
    if (paramTimeLineObject.Etm.DaH != null)
    {
      localObject1 = new c();
      ((c)localObject1).hth = paramTimeLineObject.Etm.DaH;
      locala.append(d.a(((c)localObject1).hth));
    }
    locala.Or("ContentObject");
    if (paramTimeLineObject.wLl != null)
    {
      locala.Oq("actionInfo");
      if (paramTimeLineObject.wLl.CuY != null)
      {
        locala.Oq("appMsg");
        locala.Oq("mediaTagName");
        locala.setText(paramTimeLineObject.wLl.CuY.CuS);
        locala.Or("mediaTagName");
        locala.Oq("messageExt");
        locala.setText(paramTimeLineObject.wLl.CuY.CuT);
        locala.Or("messageExt");
        locala.Oq("messageAction");
        locala.setText(paramTimeLineObject.wLl.CuY.CuU);
        locala.Or("messageAction");
        locala.Or("appMsg");
      }
      locala.Or("actionInfo");
    }
    if ((paramTimeLineObject.Etl != null) && (!bt.isNullOrNil(paramTimeLineObject.Etl.Id)))
    {
      localObject1 = paramTimeLineObject.xns;
      localObject2 = new cxi();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((cxi)localObject2).parseFrom((byte[])localObject3);
      label3970:
      ((cxi)localObject2).Epv = new cxg();
      ((cxi)localObject2).Epv.rVL = paramTimeLineObject.Etl.Id;
      try
      {
        localObject2 = Base64.encodeToString(((cxi)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
        AppMethodBeat.o(96172);
        return paramTimeLineObject;
      }
      paramTimeLineObject.xns = ((String)localObject1);
      if (paramTimeLineObject.xns != null)
      {
        locala.Oq("statExtStr");
        locala.setText(paramTimeLineObject.xns);
        locala.Or("statExtStr");
      }
      locala.Or("TimelineObject");
      paramTimeLineObject = locala.muN.toString();
      ad.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (bw.K(paramTimeLineObject, "TimelineObject") == null)
      {
        ad.e("MicroMsg.TimelineConvert", "xml is error");
        AppMethodBeat.o(96172);
        return "";
      }
    }
    catch (Exception localException)
    {
      break label3970;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.n
 * JD-Core Version:    0.7.0.1
 */