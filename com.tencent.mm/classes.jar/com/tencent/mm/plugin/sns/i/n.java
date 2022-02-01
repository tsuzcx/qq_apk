package com.tencent.mm.plugin.sns.i;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  public static String ntd = "<TimelineObject>";
  public static String nte = "</TimelineObject>";
  public static String nxj = "]]>";
  
  private static String azC(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String azD(String paramString)
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
  
  public static String e(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(96172);
    a locala = new a();
    Object localObject1 = new HashMap();
    locala.VY("TimelineObject");
    locala.VY("id");
    Object localObject2;
    label2318:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.VZ("id");
      if (paramTimeLineObject.nDo != null)
      {
        locala.VY("username");
        locala.setText(paramTimeLineObject.nDo);
        locala.VZ("username");
      }
      locala.VY("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.VZ("createTime");
      locala.VY("contentDescShowType");
      locala.setText(paramTimeLineObject.HAV);
      locala.VZ("contentDescShowType");
      locala.VY("contentDescScene");
      locala.setText(paramTimeLineObject.HAW);
      locala.VZ("contentDescScene");
      locala.VY("private");
      locala.setText(paramTimeLineObject.GSK);
      locala.VZ("private");
      if ((paramTimeLineObject.HAS != null) && (!bt.isNullOrNil(paramTimeLineObject.HAS.Id)))
      {
        locala.VY("appInfo");
        locala.VY("id");
        locala.setText(azC(paramTimeLineObject.HAS.Id));
        locala.VZ("id");
        locala.VY("version");
        locala.setText(azC(paramTimeLineObject.HAS.Version));
        locala.VZ("version");
        locala.VY("appName");
        locala.setText(azC(paramTimeLineObject.HAS.uiR));
        locala.VZ("appName");
        locala.VY("installUrl");
        locala.setText(azC(paramTimeLineObject.HAS.Fwk));
        locala.VZ("installUrl");
        locala.VY("fromUrl");
        locala.setText(azC(paramTimeLineObject.HAS.Fwl));
        locala.VZ("fromUrl");
        locala.VZ("appInfo");
      }
      if ((paramTimeLineObject.HAY != null) && (!bt.isNullOrNil(paramTimeLineObject.HAY.hCe)))
      {
        locala.VY("streamvideo");
        locala.VY("streamvideourl");
        locala.setText(azC(paramTimeLineObject.HAY.hCe));
        locala.VZ("streamvideourl");
        locala.VY("streamvideototaltime");
        locala.setText(paramTimeLineObject.HAY.hCf);
        locala.VZ("streamvideototaltime");
        locala.VY("streamvideotitle");
        locala.setText(azC(paramTimeLineObject.HAY.hCg));
        locala.VZ("streamvideotitle");
        locala.VY("streamvideowording");
        locala.setText(azC(paramTimeLineObject.HAY.hCh));
        locala.VZ("streamvideowording");
        locala.VY("streamvideoweburl");
        locala.setText(azC(paramTimeLineObject.HAY.hCi));
        locala.VZ("streamvideoweburl");
        locala.VY("streamvideothumburl");
        locala.setText(azC(paramTimeLineObject.HAY.hCj));
        locala.VZ("streamvideothumburl");
        locala.VY("streamvideoaduxinfo");
        locala.setText(azC(paramTimeLineObject.HAY.hCk));
        locala.VZ("streamvideoaduxinfo");
        locala.VY("streamvideopublishid");
        locala.setText(azC(paramTimeLineObject.HAY.hCl));
        locala.VZ("streamvideopublishid");
        locala.VZ("streamvideo");
      }
      if ((paramTimeLineObject.znS != null) && (!bt.isNullOrNil(paramTimeLineObject.znS.DBG)))
      {
        locala.VY("websearch");
        locala.VY("relevant_vid");
        locala.setText(azC(paramTimeLineObject.znS.DBG));
        locala.VZ("relevant_vid");
        locala.VY("relevant_expand");
        locala.setText(azC(paramTimeLineObject.znS.DBH));
        locala.VZ("relevant_expand");
        locala.VY("relevant_pre_searchid");
        locala.setText(azC(paramTimeLineObject.znS.DBI));
        locala.VZ("relevant_pre_searchid");
        locala.VY("relevant_shared_openid");
        locala.setText(azC(paramTimeLineObject.znS.DBJ));
        locala.VZ("relevant_shared_openid");
        locala.VY("rec_category");
        locala.setText(azC(paramTimeLineObject.znS.DBK));
        locala.VZ("rec_category");
        locala.VY("shareUrl");
        locala.setText(azC(paramTimeLineObject.znS.qeQ));
        locala.VZ("shareUrl");
        locala.VY("shareTitle");
        locala.setText(azC(paramTimeLineObject.znS.qeR));
        locala.VZ("shareTitle");
        locala.VY("shareDesc");
        locala.setText(azC(paramTimeLineObject.znS.uaw));
        locala.VZ("shareDesc");
        locala.VY("shareImgUrl");
        locala.setText(azC(paramTimeLineObject.znS.DBL));
        locala.VZ("shareImgUrl");
        locala.VY("shareString");
        locala.setText(azC(paramTimeLineObject.znS.DBM));
        locala.VZ("shareString");
        locala.VY("shareStringUrl");
        locala.setText(azC(paramTimeLineObject.znS.DBN));
        locala.VZ("shareStringUrl");
        locala.VY("source");
        locala.setText(azC(paramTimeLineObject.znS.source));
        locala.VZ("source");
        locala.VY("strPlayCount");
        locala.setText(azC(paramTimeLineObject.znS.DBO));
        locala.VZ("strPlayCount");
        locala.VY("titleUrl");
        locala.setText(azC(paramTimeLineObject.znS.DBP));
        locala.VZ("titleUrl");
        locala.VY("extReqParams");
        locala.setText(azC(paramTimeLineObject.znS.DBQ));
        locala.VZ("extReqParams");
        locala.VY("tagList");
        locala.setText(azC(paramTimeLineObject.znS.DBR));
        locala.VZ("tagList");
        locala.VY("channelId");
        locala.setText(azC(paramTimeLineObject.znS.DBS));
        locala.VZ("channelId");
        locala.VY("thumbUrl");
        locala.setText(azC(paramTimeLineObject.znS.thumbUrl));
        locala.VZ("thumbUrl");
        locala.VY("shareTag");
        locala.setText(azC(paramTimeLineObject.znS.DBT));
        locala.VZ("shareTag");
        locala.VZ("websearch");
      }
      locala.VY("contentDesc");
      locala.setText(azC(paramTimeLineObject.HAQ));
      locala.VZ("contentDesc");
      locala.VY("contentattr");
      locala.setText(paramTimeLineObject.hzT);
      locala.VZ("contentattr");
      locala.VY("sourceUserName");
      locala.setText(azC(paramTimeLineObject.jYs));
      locala.VZ("sourceUserName");
      locala.VY("sourceNickName");
      locala.setText(azC(paramTimeLineObject.EUR));
      locala.VZ("sourceNickName");
      locala.VY("statisticsData");
      locala.setText(azC(paramTimeLineObject.HAX));
      locala.VZ("statisticsData");
      locala.VY("weappInfo");
      locala.VY("appUserName");
      locala.setText(azC(paramTimeLineObject.HAZ.username));
      locala.VZ("appUserName");
      locala.VY("pagePath");
      locala.setText(azC(paramTimeLineObject.HAZ.path));
      locala.VZ("pagePath");
      locala.VY("version");
      locala.setText(azC(paramTimeLineObject.HAZ.version));
      locala.VZ("version");
      locala.VY("debugMode");
      locala.setText(azC(paramTimeLineObject.HAZ.DCU));
      locala.VZ("debugMode");
      locala.VY("shareActionId");
      locala.setText(azC(paramTimeLineObject.HAZ.HOB));
      locala.VZ("shareActionId");
      locala.VY("isGame");
      locala.setText(azC(paramTimeLineObject.HAZ.isGame));
      locala.VZ("isGame");
      locala.VY("messageExtraData");
      locala.setText(azC(paramTimeLineObject.HAZ.dJW));
      locala.VZ("messageExtraData");
      locala.VY("subType");
      locala.setText(azC(paramTimeLineObject.HAZ.subType));
      locala.VZ("subType");
      locala.VZ("weappInfo");
      locala.VY("canvasInfoXml");
      locala.setText(azC(paramTimeLineObject.zTv));
      locala.VZ("canvasInfoXml");
      if (paramTimeLineObject.HAR != null)
      {
        float f1 = paramTimeLineObject.HAR.FOA;
        float f2 = paramTimeLineObject.HAR.FOB;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.HAR.FOA);
          ((Map)localObject1).put("latitude", paramTimeLineObject.HAR.FOB);
          ((Map)localObject1).put("city", bt.aRc(azC(paramTimeLineObject.HAR.jde)));
          ((Map)localObject1).put("poiName", bt.aRc(azC(paramTimeLineObject.HAR.jDf)));
          ((Map)localObject1).put("poiAddress", bt.aRc(azC(paramTimeLineObject.HAR.zSk)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.HAR.GPP);
          ((Map)localObject1).put("poiClassifyId", azC(paramTimeLineObject.HAR.Gnu));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.HAR.zSm);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.HAR.GPQ);
          locala.r("location", (Map)localObject1);
          locala.VZ("location");
        }
      }
      locala.VY("ContentObject");
      locala.VY("contentStyle");
      locala.setText(paramTimeLineObject.HAT.GaP);
      locala.VZ("contentStyle");
      locala.VY("contentSubStyle");
      locala.setText(paramTimeLineObject.HAT.GaR);
      locala.VZ("contentSubStyle");
      locala.VY("title");
      locala.setText(azC(paramTimeLineObject.HAT.Title));
      locala.VZ("title");
      locala.VY("description");
      locala.setText(azC(paramTimeLineObject.HAT.Desc));
      locala.VZ("description");
      locala.VY("contentUrl");
      locala.setText(azC(paramTimeLineObject.HAT.Url));
      locala.VZ("contentUrl");
      if (paramTimeLineObject.HAT.GaQ.size() <= 0) {
        break label3264;
      }
      locala.VY("mediaList");
      localObject2 = paramTimeLineObject.HAT.GaQ.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3256;
      }
      localObject3 = (byn)((Iterator)localObject2).next();
      locala.VY("media");
      locala.VY("id");
      if (!azD(((byn)localObject3).Id).equals("")) {
        break label3240;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.VZ("id");
      locala.VY("type");
      locala.setText(((byn)localObject3).nEf);
      locala.VZ("type");
      locala.VY("title");
      locala.setText(azC(((byn)localObject3).Title));
      locala.VZ("title");
      locala.VY("description");
      locala.setText(azC(((byn)localObject3).Desc));
      locala.VZ("description");
      locala.VY("private");
      locala.setText(((byn)localObject3).GSK);
      locala.VZ("private");
      if (!bt.isNullOrNil(((byn)localObject3).songAlbumUrl))
      {
        locala.VY("songalbumurl");
        locala.setText(((byn)localObject3).songAlbumUrl);
        locala.VZ("songalbumurl");
      }
      if (!bt.isNullOrNil(((byn)localObject3).songLyric))
      {
        locala.VY("songlyric");
        locala.setText(((byn)localObject3).songLyric);
        locala.VZ("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((byn)localObject3).GEe);
      if (!bt.isNullOrNil(((byn)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((byn)localObject3).md5);
      }
      if (!bt.isNullOrNil(((byn)localObject3).GTd)) {
        ((Map)localObject1).put("videomd5", ((byn)localObject3).GTd);
      }
      locala.r("url", (Map)localObject1);
      locala.setText(azC(((byn)localObject3).Url));
      locala.VZ("url");
      if ((((byn)localObject3).GSI != null) && (!((byn)localObject3).GSI.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((byn)localObject3).GSJ);
        locala.r("thumb", (Map)localObject1);
        locala.setText(azC(((byn)localObject3).GSI));
        locala.VZ("thumb");
      }
      locala.VY("videoDuration");
      locala.setText(((byn)localObject3).GTe);
      locala.VZ("videoDuration");
      if (((byn)localObject3).subType > 0)
      {
        locala.VY("subType");
        locala.setText(((byn)localObject3).subType);
        locala.VZ("subType");
      }
      if (!bt.isNullOrNil(((byn)localObject3).zQh))
      {
        locala.VY("userData");
        locala.setText(((byn)localObject3).zQh);
        locala.VZ("userData");
      }
      if ((((byn)localObject3).GSM != null) && (!((byn)localObject3).GSM.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((byn)localObject3).GSN);
        locala.r("lowBandUrl", (Map)localObject1);
        locala.setText(azC(((byn)localObject3).GSM));
        locala.VZ("lowBandUrl");
      }
      if (((byn)localObject3).GSL != null)
      {
        ((Map)localObject1).clear();
        if (((byn)localObject3).GSL.GTz > 0.0F) {
          ((Map)localObject1).put("width", ((byn)localObject3).GSL.GTz);
        }
        if (((byn)localObject3).GSL.GTA > 0.0F) {
          ((Map)localObject1).put("height", ((byn)localObject3).GSL.GTA);
        }
        if (((byn)localObject3).GSL.GTB > 0.0F) {
          ((Map)localObject1).put("totalSize", ((byn)localObject3).GSL.GTB);
        }
        locala.r("size", (Map)localObject1);
        locala.VZ("size");
      }
      locala.VZ("media");
      break label2318;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3240:
      locala.setText(azD(((byn)localObject3).Id));
    }
    label3256:
    locala.VZ("mediaList");
    label3264:
    locala.nxl.append(azC(paramTimeLineObject.HAT.GaS));
    if ((paramTimeLineObject.HAT.GaT != null) && (paramTimeLineObject.HAT.GaT.hCZ != -1))
    {
      locala.VY("mmreadershare");
      locala.VY("itemshowtype");
      locala.setText(paramTimeLineObject.HAT.GaT.hCZ);
      locala.VZ("itemshowtype");
      locala.VY("ispaysubscribe");
      locala.setText(paramTimeLineObject.HAT.GaT.hzk);
      locala.VZ("ispaysubscribe");
      if (paramTimeLineObject.HAT.GaT.hCZ == 5)
      {
        locala.VY("pubtime");
        locala.setText(paramTimeLineObject.HAT.GaT.hzi);
        locala.VZ("pubtime");
        locala.VY("vid");
        locala.setText(paramTimeLineObject.HAT.GaT.hzm);
        locala.VZ("vid");
        locala.VY("funcflag");
        locala.setText(paramTimeLineObject.HAT.GaT.hzl);
        locala.VZ("funcflag");
        locala.VY("duration");
        locala.setText(paramTimeLineObject.HAT.GaT.duration);
        locala.VZ("duration");
        locala.VY("digest");
        locala.setText(paramTimeLineObject.HAT.GaT.desc);
        locala.VZ("digest");
        locala.VY("cover");
        locala.setText(paramTimeLineObject.HAT.GaT.coverUrl);
        locala.VZ("cover");
        if (!bt.isNullOrNil(paramTimeLineObject.HAT.GaT.hzm))
        {
          locala.VY("nativepage");
          locala.setText(1);
          locala.VZ("nativepage");
        }
        locala.VY("width");
        locala.setText(paramTimeLineObject.HAT.GaT.videoWidth);
        locala.VZ("width");
        locala.VY("height");
        locala.setText(paramTimeLineObject.HAT.GaT.videoHeight);
        locala.VZ("height");
      }
      locala.VZ("mmreadershare");
    }
    if (paramTimeLineObject.HAT.GaU != null)
    {
      localObject1 = new b();
      ((b)localObject1).inc = paramTimeLineObject.HAT.GaU;
      locala.append(e.b(((b)localObject1).inc));
    }
    if (paramTimeLineObject.HAT.GaV != null)
    {
      localObject1 = new c();
      ((c)localObject1).ind = paramTimeLineObject.HAT.GaV;
      locala.append(e.a(((c)localObject1).ind));
    }
    if (paramTimeLineObject.HAT.GaW != null)
    {
      localObject1 = new d();
      ((d)localObject1).ine = paramTimeLineObject.HAT.GaW;
      locala.append(d.b(((d)localObject1).ine));
    }
    locala.VZ("ContentObject");
    if (paramTimeLineObject.znQ != null)
    {
      locala.VY("actionInfo");
      if (paramTimeLineObject.znQ.Fsy != null)
      {
        locala.VY("appMsg");
        locala.VY("mediaTagName");
        locala.setText(paramTimeLineObject.znQ.Fsy.Fss);
        locala.VZ("mediaTagName");
        locala.VY("messageExt");
        locala.setText(paramTimeLineObject.znQ.Fsy.Fst);
        locala.VZ("messageExt");
        locala.VY("messageAction");
        locala.setText(paramTimeLineObject.znQ.Fsy.Fsu);
        locala.VZ("messageAction");
        locala.VZ("appMsg");
      }
      locala.VZ("actionInfo");
    }
    if ((paramTimeLineObject.HAS != null) && (!bt.isNullOrNil(paramTimeLineObject.HAS.Id)))
    {
      localObject1 = paramTimeLineObject.zRz;
      localObject2 = new dih();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((dih)localObject2).parseFrom((byte[])localObject3);
      label4011:
      ((dih)localObject2).Hxc = new dif();
      ((dih)localObject2).Hxc.ubt = paramTimeLineObject.HAS.Id;
      try
      {
        localObject2 = Base64.encodeToString(((dih)localObject2).toByteArray(), 0);
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
      paramTimeLineObject.zRz = ((String)localObject1);
      if (paramTimeLineObject.zRz != null)
      {
        locala.VY("statExtStr");
        locala.setText(paramTimeLineObject.zRz);
        locala.VZ("statExtStr");
      }
      locala.VZ("TimelineObject");
      paramTimeLineObject = locala.nxl.toString();
      ad.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (bw.M(paramTimeLineObject, "TimelineObject") == null)
      {
        ad.e("MicroMsg.TimelineConvert", "xml is error");
        AppMethodBeat.o(96172);
        return "";
      }
    }
    catch (Exception localException)
    {
      break label4011;
    }
  }
  
  static final class a
  {
    StringBuffer nxl;
    
    a()
    {
      AppMethodBeat.i(96165);
      this.nxl = new StringBuffer();
      AppMethodBeat.o(96165);
    }
    
    public final void VY(String paramString)
    {
      AppMethodBeat.i(96166);
      this.nxl.append("<" + paramString + ">");
      AppMethodBeat.o(96166);
    }
    
    public final void VZ(String paramString)
    {
      AppMethodBeat.i(96167);
      this.nxl.append("</" + paramString + ">");
      AppMethodBeat.o(96167);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(163073);
      if (!bt.isNullOrNil(paramString)) {
        this.nxl.append(paramString);
      }
      AppMethodBeat.o(163073);
    }
    
    public final void r(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(96170);
      this.nxl.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nxl.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.nxl.append(">");
      paramMap.clear();
      AppMethodBeat.o(96170);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(96169);
      this.nxl.append(paramInt);
      AppMethodBeat.o(96169);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(96168);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96168);
        return;
      }
      if (paramString.contains(n.nxj))
      {
        this.nxl.append("<![CDATA[" + bt.aRc(paramString) + "]]>");
        AppMethodBeat.o(96168);
        return;
      }
      this.nxl.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(96168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.n
 * JD-Core Version:    0.7.0.1
 */