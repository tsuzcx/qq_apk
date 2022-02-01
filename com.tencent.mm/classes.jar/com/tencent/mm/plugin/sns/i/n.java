package com.tencent.mm.plugin.sns.i;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  public static String nCE = "]]>";
  public static String nyy = "<TimelineObject>";
  public static String nyz = "</TimelineObject>";
  
  private static String aAT(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String aAU(String paramString)
  {
    AppMethodBeat.i(96171);
    if (bu.isNullOrNil(paramString))
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
    locala.WK("TimelineObject");
    locala.WK("id");
    Object localObject2;
    label2318:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.WL("id");
      if (paramTimeLineObject.nIJ != null)
      {
        locala.WK("username");
        locala.setText(paramTimeLineObject.nIJ);
        locala.WL("username");
      }
      locala.WK("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.WL("createTime");
      locala.WK("contentDescShowType");
      locala.setText(paramTimeLineObject.HUI);
      locala.WL("contentDescShowType");
      locala.WK("contentDescScene");
      locala.setText(paramTimeLineObject.HUJ);
      locala.WL("contentDescScene");
      locala.WK("private");
      locala.setText(paramTimeLineObject.Hml);
      locala.WL("private");
      if ((paramTimeLineObject.HUF != null) && (!bu.isNullOrNil(paramTimeLineObject.HUF.Id)))
      {
        locala.WK("appInfo");
        locala.WK("id");
        locala.setText(aAT(paramTimeLineObject.HUF.Id));
        locala.WL("id");
        locala.WK("version");
        locala.setText(aAT(paramTimeLineObject.HUF.Version));
        locala.WL("version");
        locala.WK("appName");
        locala.setText(aAT(paramTimeLineObject.HUF.uuo));
        locala.WL("appName");
        locala.WK("installUrl");
        locala.setText(aAT(paramTimeLineObject.HUF.FOI));
        locala.WL("installUrl");
        locala.WK("fromUrl");
        locala.setText(aAT(paramTimeLineObject.HUF.FOJ));
        locala.WL("fromUrl");
        locala.WL("appInfo");
      }
      if ((paramTimeLineObject.HUL != null) && (!bu.isNullOrNil(paramTimeLineObject.HUL.hET)))
      {
        locala.WK("streamvideo");
        locala.WK("streamvideourl");
        locala.setText(aAT(paramTimeLineObject.HUL.hET));
        locala.WL("streamvideourl");
        locala.WK("streamvideototaltime");
        locala.setText(paramTimeLineObject.HUL.hEU);
        locala.WL("streamvideototaltime");
        locala.WK("streamvideotitle");
        locala.setText(aAT(paramTimeLineObject.HUL.hEV));
        locala.WL("streamvideotitle");
        locala.WK("streamvideowording");
        locala.setText(aAT(paramTimeLineObject.HUL.hEW));
        locala.WL("streamvideowording");
        locala.WK("streamvideoweburl");
        locala.setText(aAT(paramTimeLineObject.HUL.hEX));
        locala.WL("streamvideoweburl");
        locala.WK("streamvideothumburl");
        locala.setText(aAT(paramTimeLineObject.HUL.hEY));
        locala.WL("streamvideothumburl");
        locala.WK("streamvideoaduxinfo");
        locala.setText(aAT(paramTimeLineObject.HUL.hEZ));
        locala.WL("streamvideoaduxinfo");
        locala.WK("streamvideopublishid");
        locala.setText(aAT(paramTimeLineObject.HUL.hFa));
        locala.WL("streamvideopublishid");
        locala.WL("streamvideo");
      }
      if ((paramTimeLineObject.zFh != null) && (!bu.isNullOrNil(paramTimeLineObject.zFh.DTD)))
      {
        locala.WK("websearch");
        locala.WK("relevant_vid");
        locala.setText(aAT(paramTimeLineObject.zFh.DTD));
        locala.WL("relevant_vid");
        locala.WK("relevant_expand");
        locala.setText(aAT(paramTimeLineObject.zFh.DTE));
        locala.WL("relevant_expand");
        locala.WK("relevant_pre_searchid");
        locala.setText(aAT(paramTimeLineObject.zFh.DTF));
        locala.WL("relevant_pre_searchid");
        locala.WK("relevant_shared_openid");
        locala.setText(aAT(paramTimeLineObject.zFh.DTG));
        locala.WL("relevant_shared_openid");
        locala.WK("rec_category");
        locala.setText(aAT(paramTimeLineObject.zFh.DTH));
        locala.WL("rec_category");
        locala.WK("shareUrl");
        locala.setText(aAT(paramTimeLineObject.zFh.qlv));
        locala.WL("shareUrl");
        locala.WK("shareTitle");
        locala.setText(aAT(paramTimeLineObject.zFh.qlw));
        locala.WL("shareTitle");
        locala.WK("shareDesc");
        locala.setText(aAT(paramTimeLineObject.zFh.uly));
        locala.WL("shareDesc");
        locala.WK("shareImgUrl");
        locala.setText(aAT(paramTimeLineObject.zFh.DTI));
        locala.WL("shareImgUrl");
        locala.WK("shareString");
        locala.setText(aAT(paramTimeLineObject.zFh.DTJ));
        locala.WL("shareString");
        locala.WK("shareStringUrl");
        locala.setText(aAT(paramTimeLineObject.zFh.DTK));
        locala.WL("shareStringUrl");
        locala.WK("source");
        locala.setText(aAT(paramTimeLineObject.zFh.source));
        locala.WL("source");
        locala.WK("strPlayCount");
        locala.setText(aAT(paramTimeLineObject.zFh.DTL));
        locala.WL("strPlayCount");
        locala.WK("titleUrl");
        locala.setText(aAT(paramTimeLineObject.zFh.DTM));
        locala.WL("titleUrl");
        locala.WK("extReqParams");
        locala.setText(aAT(paramTimeLineObject.zFh.DTN));
        locala.WL("extReqParams");
        locala.WK("tagList");
        locala.setText(aAT(paramTimeLineObject.zFh.DTO));
        locala.WL("tagList");
        locala.WK("channelId");
        locala.setText(aAT(paramTimeLineObject.zFh.DTP));
        locala.WL("channelId");
        locala.WK("thumbUrl");
        locala.setText(aAT(paramTimeLineObject.zFh.thumbUrl));
        locala.WL("thumbUrl");
        locala.WK("shareTag");
        locala.setText(aAT(paramTimeLineObject.zFh.DTQ));
        locala.WL("shareTag");
        locala.WL("websearch");
      }
      locala.WK("contentDesc");
      locala.setText(aAT(paramTimeLineObject.HUD));
      locala.WL("contentDesc");
      locala.WK("contentattr");
      locala.setText(paramTimeLineObject.hCH);
      locala.WL("contentattr");
      locala.WK("sourceUserName");
      locala.setText(aAT(paramTimeLineObject.kbH));
      locala.WL("sourceUserName");
      locala.WK("sourceNickName");
      locala.setText(aAT(paramTimeLineObject.Fnm));
      locala.WL("sourceNickName");
      locala.WK("statisticsData");
      locala.setText(aAT(paramTimeLineObject.HUK));
      locala.WL("statisticsData");
      locala.WK("weappInfo");
      locala.WK("appUserName");
      locala.setText(aAT(paramTimeLineObject.HUM.username));
      locala.WL("appUserName");
      locala.WK("pagePath");
      locala.setText(aAT(paramTimeLineObject.HUM.path));
      locala.WL("pagePath");
      locala.WK("version");
      locala.setText(aAT(paramTimeLineObject.HUM.version));
      locala.WL("version");
      locala.WK("debugMode");
      locala.setText(aAT(paramTimeLineObject.HUM.DUS));
      locala.WL("debugMode");
      locala.WK("shareActionId");
      locala.setText(aAT(paramTimeLineObject.HUM.IiI));
      locala.WL("shareActionId");
      locala.WK("isGame");
      locala.setText(aAT(paramTimeLineObject.HUM.isGame));
      locala.WL("isGame");
      locala.WK("messageExtraData");
      locala.setText(aAT(paramTimeLineObject.HUM.dLl));
      locala.WL("messageExtraData");
      locala.WK("subType");
      locala.setText(aAT(paramTimeLineObject.HUM.subType));
      locala.WL("subType");
      locala.WL("weappInfo");
      locala.WK("canvasInfoXml");
      locala.setText(aAT(paramTimeLineObject.AkC));
      locala.WL("canvasInfoXml");
      if (paramTimeLineObject.HUE != null)
      {
        float f1 = paramTimeLineObject.HUE.GgZ;
        float f2 = paramTimeLineObject.HUE.Gha;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.HUE.GgZ);
          ((Map)localObject1).put("latitude", paramTimeLineObject.HUE.Gha);
          ((Map)localObject1).put("city", bu.aSz(aAT(paramTimeLineObject.HUE.jfX)));
          ((Map)localObject1).put("poiName", bu.aSz(aAT(paramTimeLineObject.HUE.jGd)));
          ((Map)localObject1).put("poiAddress", bu.aSz(aAT(paramTimeLineObject.HUE.Ajr)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.HUE.Hjr);
          ((Map)localObject1).put("poiClassifyId", aAT(paramTimeLineObject.HUE.GGA));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.HUE.Ajt);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.HUE.Hjs);
          locala.s("location", (Map)localObject1);
          locala.WL("location");
        }
      }
      locala.WK("ContentObject");
      locala.WK("contentStyle");
      locala.setText(paramTimeLineObject.HUG.Gtw);
      locala.WL("contentStyle");
      locala.WK("contentSubStyle");
      locala.setText(paramTimeLineObject.HUG.Gty);
      locala.WL("contentSubStyle");
      locala.WK("title");
      locala.setText(aAT(paramTimeLineObject.HUG.Title));
      locala.WL("title");
      locala.WK("description");
      locala.setText(aAT(paramTimeLineObject.HUG.Desc));
      locala.WL("description");
      locala.WK("contentUrl");
      locala.setText(aAT(paramTimeLineObject.HUG.Url));
      locala.WL("contentUrl");
      if (paramTimeLineObject.HUG.Gtx.size() <= 0) {
        break label3264;
      }
      locala.WK("mediaList");
      localObject2 = paramTimeLineObject.HUG.Gtx.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3256;
      }
      localObject3 = (bzh)((Iterator)localObject2).next();
      locala.WK("media");
      locala.WK("id");
      if (!aAU(((bzh)localObject3).Id).equals("")) {
        break label3240;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.WL("id");
      locala.WK("type");
      locala.setText(((bzh)localObject3).nJA);
      locala.WL("type");
      locala.WK("title");
      locala.setText(aAT(((bzh)localObject3).Title));
      locala.WL("title");
      locala.WK("description");
      locala.setText(aAT(((bzh)localObject3).Desc));
      locala.WL("description");
      locala.WK("private");
      locala.setText(((bzh)localObject3).Hml);
      locala.WL("private");
      if (!bu.isNullOrNil(((bzh)localObject3).songAlbumUrl))
      {
        locala.WK("songalbumurl");
        locala.setText(((bzh)localObject3).songAlbumUrl);
        locala.WL("songalbumurl");
      }
      if (!bu.isNullOrNil(((bzh)localObject3).songLyric))
      {
        locala.WK("songlyric");
        locala.setText(((bzh)localObject3).songLyric);
        locala.WL("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((bzh)localObject3).GXH);
      if (!bu.isNullOrNil(((bzh)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((bzh)localObject3).md5);
      }
      if (!bu.isNullOrNil(((bzh)localObject3).HmE)) {
        ((Map)localObject1).put("videomd5", ((bzh)localObject3).HmE);
      }
      locala.s("url", (Map)localObject1);
      locala.setText(aAT(((bzh)localObject3).Url));
      locala.WL("url");
      if ((((bzh)localObject3).Hmj != null) && (!((bzh)localObject3).Hmj.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bzh)localObject3).Hmk);
        locala.s("thumb", (Map)localObject1);
        locala.setText(aAT(((bzh)localObject3).Hmj));
        locala.WL("thumb");
      }
      locala.WK("videoDuration");
      locala.setText(((bzh)localObject3).HmF);
      locala.WL("videoDuration");
      if (((bzh)localObject3).subType > 0)
      {
        locala.WK("subType");
        locala.setText(((bzh)localObject3).subType);
        locala.WL("subType");
      }
      if (!bu.isNullOrNil(((bzh)localObject3).Aho))
      {
        locala.WK("userData");
        locala.setText(((bzh)localObject3).Aho);
        locala.WL("userData");
      }
      if ((((bzh)localObject3).Hmn != null) && (!((bzh)localObject3).Hmn.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bzh)localObject3).Hmo);
        locala.s("lowBandUrl", (Map)localObject1);
        locala.setText(aAT(((bzh)localObject3).Hmn));
        locala.WL("lowBandUrl");
      }
      if (((bzh)localObject3).Hmm != null)
      {
        ((Map)localObject1).clear();
        if (((bzh)localObject3).Hmm.Hna > 0.0F) {
          ((Map)localObject1).put("width", ((bzh)localObject3).Hmm.Hna);
        }
        if (((bzh)localObject3).Hmm.Hnb > 0.0F) {
          ((Map)localObject1).put("height", ((bzh)localObject3).Hmm.Hnb);
        }
        if (((bzh)localObject3).Hmm.Hnc > 0.0F) {
          ((Map)localObject1).put("totalSize", ((bzh)localObject3).Hmm.Hnc);
        }
        locala.s("size", (Map)localObject1);
        locala.WL("size");
      }
      locala.WL("media");
      break label2318;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3240:
      locala.setText(aAU(((bzh)localObject3).Id));
    }
    label3256:
    locala.WL("mediaList");
    label3264:
    locala.nCG.append(aAT(paramTimeLineObject.HUG.Gtz));
    if ((paramTimeLineObject.HUG.GtA != null) && (paramTimeLineObject.HUG.GtA.hFR != -1))
    {
      locala.WK("mmreadershare");
      locala.WK("itemshowtype");
      locala.setText(paramTimeLineObject.HUG.GtA.hFR);
      locala.WL("itemshowtype");
      locala.WK("ispaysubscribe");
      locala.setText(paramTimeLineObject.HUG.GtA.hBY);
      locala.WL("ispaysubscribe");
      if (paramTimeLineObject.HUG.GtA.hFR == 5)
      {
        locala.WK("pubtime");
        locala.setText(paramTimeLineObject.HUG.GtA.hBW);
        locala.WL("pubtime");
        locala.WK("vid");
        locala.setText(paramTimeLineObject.HUG.GtA.hCa);
        locala.WL("vid");
        locala.WK("funcflag");
        locala.setText(paramTimeLineObject.HUG.GtA.hBZ);
        locala.WL("funcflag");
        locala.WK("duration");
        locala.setText(paramTimeLineObject.HUG.GtA.duration);
        locala.WL("duration");
        locala.WK("digest");
        locala.setText(paramTimeLineObject.HUG.GtA.desc);
        locala.WL("digest");
        locala.WK("cover");
        locala.setText(paramTimeLineObject.HUG.GtA.coverUrl);
        locala.WL("cover");
        if (!bu.isNullOrNil(paramTimeLineObject.HUG.GtA.hCa))
        {
          locala.WK("nativepage");
          locala.setText(1);
          locala.WL("nativepage");
        }
        locala.WK("width");
        locala.setText(paramTimeLineObject.HUG.GtA.videoWidth);
        locala.WL("width");
        locala.WK("height");
        locala.setText(paramTimeLineObject.HUG.GtA.videoHeight);
        locala.WL("height");
      }
      locala.WL("mmreadershare");
    }
    if (paramTimeLineObject.HUG.GtB != null)
    {
      localObject1 = new b();
      ((b)localObject1).ipW = paramTimeLineObject.HUG.GtB;
      locala.append(e.b(((b)localObject1).ipW));
    }
    if (paramTimeLineObject.HUG.GtC != null)
    {
      localObject1 = new c();
      ((c)localObject1).ipX = paramTimeLineObject.HUG.GtC;
      locala.append(e.a(((c)localObject1).ipX));
    }
    if (paramTimeLineObject.HUG.GtD != null)
    {
      localObject1 = new d();
      ((d)localObject1).ipY = paramTimeLineObject.HUG.GtD;
      locala.append(d.b(((d)localObject1).ipY));
    }
    locala.WL("ContentObject");
    if (paramTimeLineObject.zFf != null)
    {
      locala.WK("actionInfo");
      if (paramTimeLineObject.zFf.FKW != null)
      {
        locala.WK("appMsg");
        locala.WK("mediaTagName");
        locala.setText(paramTimeLineObject.zFf.FKW.FKQ);
        locala.WL("mediaTagName");
        locala.WK("messageExt");
        locala.setText(paramTimeLineObject.zFf.FKW.FKR);
        locala.WL("messageExt");
        locala.WK("messageAction");
        locala.setText(paramTimeLineObject.zFf.FKW.FKS);
        locala.WL("messageAction");
        locala.WL("appMsg");
      }
      locala.WL("actionInfo");
    }
    if ((paramTimeLineObject.HUF != null) && (!bu.isNullOrNil(paramTimeLineObject.HUF.Id)))
    {
      localObject1 = paramTimeLineObject.AiG;
      localObject2 = new djc();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((djc)localObject2).parseFrom((byte[])localObject3);
      label4011:
      ((djc)localObject2).HQL = new dja();
      ((djc)localObject2).HQL.umv = paramTimeLineObject.HUF.Id;
      try
      {
        localObject2 = Base64.encodeToString(((djc)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
        AppMethodBeat.o(96172);
        return paramTimeLineObject;
      }
      paramTimeLineObject.AiG = ((String)localObject1);
      if (paramTimeLineObject.AiG != null)
      {
        locala.WK("statExtStr");
        locala.setText(paramTimeLineObject.AiG);
        locala.WL("statExtStr");
      }
      locala.WL("TimelineObject");
      paramTimeLineObject = locala.nCG.toString();
      ae.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (bx.M(paramTimeLineObject, "TimelineObject") == null)
      {
        ae.e("MicroMsg.TimelineConvert", "xml is error");
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
    StringBuffer nCG;
    
    a()
    {
      AppMethodBeat.i(96165);
      this.nCG = new StringBuffer();
      AppMethodBeat.o(96165);
    }
    
    public final void WK(String paramString)
    {
      AppMethodBeat.i(96166);
      this.nCG.append("<" + paramString + ">");
      AppMethodBeat.o(96166);
    }
    
    public final void WL(String paramString)
    {
      AppMethodBeat.i(96167);
      this.nCG.append("</" + paramString + ">");
      AppMethodBeat.o(96167);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(163073);
      if (!bu.isNullOrNil(paramString)) {
        this.nCG.append(paramString);
      }
      AppMethodBeat.o(163073);
    }
    
    public final void s(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(96170);
      this.nCG.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nCG.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.nCG.append(">");
      paramMap.clear();
      AppMethodBeat.o(96170);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(96169);
      this.nCG.append(paramInt);
      AppMethodBeat.o(96169);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(96168);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96168);
        return;
      }
      if (paramString.contains(n.nCE))
      {
        this.nCG.append("<![CDATA[" + bu.aSz(paramString) + "]]>");
        AppMethodBeat.o(96168);
        return;
      }
      this.nCG.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(96168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.n
 * JD-Core Version:    0.7.0.1
 */