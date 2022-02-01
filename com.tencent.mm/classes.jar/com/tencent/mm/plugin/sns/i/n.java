package com.tencent.mm.plugin.sns.i;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  public static String mSF = "<TimelineObject>";
  public static String mSG = "</TimelineObject>";
  public static String mWM = "]]>";
  
  private static String auw(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String aux(String paramString)
  {
    AppMethodBeat.i(96171);
    if (bs.isNullOrNil(paramString))
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
    locala.SA("TimelineObject");
    locala.SA("id");
    Object localObject2;
    label2318:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.SB("id");
      if (paramTimeLineObject.ncR != null)
      {
        locala.SA("username");
        locala.setText(paramTimeLineObject.ncR);
        locala.SB("username");
      }
      locala.SA("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.SB("createTime");
      locala.SA("contentDescShowType");
      locala.setText(paramTimeLineObject.FQq);
      locala.SB("contentDescShowType");
      locala.SA("contentDescScene");
      locala.setText(paramTimeLineObject.FQr);
      locala.SB("contentDescScene");
      locala.SA("private");
      locala.setText(paramTimeLineObject.Fjj);
      locala.SB("private");
      if ((paramTimeLineObject.FQn != null) && (!bs.isNullOrNil(paramTimeLineObject.FQn.Id)))
      {
        locala.SA("appInfo");
        locala.SA("id");
        locala.setText(auw(paramTimeLineObject.FQn.Id));
        locala.SB("id");
        locala.SA("version");
        locala.setText(auw(paramTimeLineObject.FQn.Version));
        locala.SB("version");
        locala.SA("appName");
        locala.setText(auw(paramTimeLineObject.FQn.tkL));
        locala.SB("appName");
        locala.SA("installUrl");
        locala.setText(auw(paramTimeLineObject.FQn.DQS));
        locala.SB("installUrl");
        locala.SA("fromUrl");
        locala.setText(auw(paramTimeLineObject.FQn.DQT));
        locala.SB("fromUrl");
        locala.SB("appInfo");
      }
      if ((paramTimeLineObject.FQt != null) && (!bs.isNullOrNil(paramTimeLineObject.FQt.hjV)))
      {
        locala.SA("streamvideo");
        locala.SA("streamvideourl");
        locala.setText(auw(paramTimeLineObject.FQt.hjV));
        locala.SB("streamvideourl");
        locala.SA("streamvideototaltime");
        locala.setText(paramTimeLineObject.FQt.hjW);
        locala.SB("streamvideototaltime");
        locala.SA("streamvideotitle");
        locala.setText(auw(paramTimeLineObject.FQt.hjX));
        locala.SB("streamvideotitle");
        locala.SA("streamvideowording");
        locala.setText(auw(paramTimeLineObject.FQt.hjY));
        locala.SB("streamvideowording");
        locala.SA("streamvideoweburl");
        locala.setText(auw(paramTimeLineObject.FQt.hjZ));
        locala.SB("streamvideoweburl");
        locala.SA("streamvideothumburl");
        locala.setText(auw(paramTimeLineObject.FQt.hka));
        locala.SB("streamvideothumburl");
        locala.SA("streamvideoaduxinfo");
        locala.setText(auw(paramTimeLineObject.FQt.hkb));
        locala.SB("streamvideoaduxinfo");
        locala.SA("streamvideopublishid");
        locala.setText(auw(paramTimeLineObject.FQt.hkc));
        locala.SB("streamvideopublishid");
        locala.SB("streamvideo");
      }
      if ((paramTimeLineObject.xXT != null) && (!bs.isNullOrNil(paramTimeLineObject.xXT.BYK)))
      {
        locala.SA("websearch");
        locala.SA("relevant_vid");
        locala.setText(auw(paramTimeLineObject.xXT.BYK));
        locala.SB("relevant_vid");
        locala.SA("relevant_expand");
        locala.setText(auw(paramTimeLineObject.xXT.BYL));
        locala.SB("relevant_expand");
        locala.SA("relevant_pre_searchid");
        locala.setText(auw(paramTimeLineObject.xXT.BYM));
        locala.SB("relevant_pre_searchid");
        locala.SA("relevant_shared_openid");
        locala.setText(auw(paramTimeLineObject.xXT.BYN));
        locala.SB("relevant_shared_openid");
        locala.SA("rec_category");
        locala.setText(auw(paramTimeLineObject.xXT.BYO));
        locala.SB("rec_category");
        locala.SA("shareUrl");
        locala.setText(auw(paramTimeLineObject.xXT.pBl));
        locala.SB("shareUrl");
        locala.SA("shareTitle");
        locala.setText(auw(paramTimeLineObject.xXT.pBm));
        locala.SB("shareTitle");
        locala.SA("shareDesc");
        locala.setText(auw(paramTimeLineObject.xXT.tcG));
        locala.SB("shareDesc");
        locala.SA("shareImgUrl");
        locala.setText(auw(paramTimeLineObject.xXT.BYP));
        locala.SB("shareImgUrl");
        locala.SA("shareString");
        locala.setText(auw(paramTimeLineObject.xXT.BYQ));
        locala.SB("shareString");
        locala.SA("shareStringUrl");
        locala.setText(auw(paramTimeLineObject.xXT.BYR));
        locala.SB("shareStringUrl");
        locala.SA("source");
        locala.setText(auw(paramTimeLineObject.xXT.source));
        locala.SB("source");
        locala.SA("strPlayCount");
        locala.setText(auw(paramTimeLineObject.xXT.BYS));
        locala.SB("strPlayCount");
        locala.SA("titleUrl");
        locala.setText(auw(paramTimeLineObject.xXT.BYT));
        locala.SB("titleUrl");
        locala.SA("extReqParams");
        locala.setText(auw(paramTimeLineObject.xXT.BYU));
        locala.SB("extReqParams");
        locala.SA("tagList");
        locala.setText(auw(paramTimeLineObject.xXT.BYV));
        locala.SB("tagList");
        locala.SA("channelId");
        locala.setText(auw(paramTimeLineObject.xXT.BYW));
        locala.SB("channelId");
        locala.SA("thumbUrl");
        locala.setText(auw(paramTimeLineObject.xXT.thumbUrl));
        locala.SB("thumbUrl");
        locala.SA("shareTag");
        locala.setText(auw(paramTimeLineObject.xXT.BYX));
        locala.SB("shareTag");
        locala.SB("websearch");
      }
      locala.SA("contentDesc");
      locala.setText(auw(paramTimeLineObject.FQl));
      locala.SB("contentDesc");
      locala.SA("contentattr");
      locala.setText(paramTimeLineObject.hhK);
      locala.SB("contentattr");
      locala.SA("sourceUserName");
      locala.setText(auw(paramTimeLineObject.jEq));
      locala.SB("sourceUserName");
      locala.SA("sourceNickName");
      locala.setText(auw(paramTimeLineObject.DpN));
      locala.SB("sourceNickName");
      locala.SA("statisticsData");
      locala.setText(auw(paramTimeLineObject.FQs));
      locala.SB("statisticsData");
      locala.SA("weappInfo");
      locala.SA("appUserName");
      locala.setText(auw(paramTimeLineObject.FQu.username));
      locala.SB("appUserName");
      locala.SA("pagePath");
      locala.setText(auw(paramTimeLineObject.FQu.path));
      locala.SB("pagePath");
      locala.SA("version");
      locala.setText(auw(paramTimeLineObject.FQu.version));
      locala.SB("version");
      locala.SA("debugMode");
      locala.setText(auw(paramTimeLineObject.FQu.BZZ));
      locala.SB("debugMode");
      locala.SA("shareActionId");
      locala.setText(auw(paramTimeLineObject.FQu.Gdv));
      locala.SB("shareActionId");
      locala.SA("isGame");
      locala.setText(auw(paramTimeLineObject.FQu.isGame));
      locala.SB("isGame");
      locala.SA("messageExtraData");
      locala.setText(auw(paramTimeLineObject.FQu.dxK));
      locala.SB("messageExtraData");
      locala.SA("subType");
      locala.setText(auw(paramTimeLineObject.FQu.subType));
      locala.SB("subType");
      locala.SB("weappInfo");
      locala.SA("canvasInfoXml");
      locala.setText(auw(paramTimeLineObject.yCb));
      locala.SB("canvasInfoXml");
      if (paramTimeLineObject.FQm != null)
      {
        float f1 = paramTimeLineObject.FQm.Eht;
        float f2 = paramTimeLineObject.FQm.Ehu;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.FQm.Eht);
          ((Map)localObject1).put("latitude", paramTimeLineObject.FQm.Ehu);
          ((Map)localObject1).put("city", bs.aLw(auw(paramTimeLineObject.FQm.iJV)));
          ((Map)localObject1).put("poiName", bs.aLw(auw(paramTimeLineObject.FQm.gPy)));
          ((Map)localObject1).put("poiAddress", bs.aLw(auw(paramTimeLineObject.FQm.yAV)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.FQm.Fgn);
          ((Map)localObject1).put("poiClassifyId", auw(paramTimeLineObject.FQm.EFm));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.FQm.yAX);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.FQm.Fgo);
          locala.p("location", (Map)localObject1);
          locala.SB("location");
        }
      }
      locala.SA("ContentObject");
      locala.SA("contentStyle");
      locala.setText(paramTimeLineObject.FQo.Ety);
      locala.SB("contentStyle");
      locala.SA("contentSubStyle");
      locala.setText(paramTimeLineObject.FQo.EtA);
      locala.SB("contentSubStyle");
      locala.SA("title");
      locala.setText(auw(paramTimeLineObject.FQo.Title));
      locala.SB("title");
      locala.SA("description");
      locala.setText(auw(paramTimeLineObject.FQo.Desc));
      locala.SB("description");
      locala.SA("contentUrl");
      locala.setText(auw(paramTimeLineObject.FQo.Url));
      locala.SB("contentUrl");
      if (paramTimeLineObject.FQo.Etz.size() <= 0) {
        break label3264;
      }
      locala.SA("mediaList");
      localObject2 = paramTimeLineObject.FQo.Etz.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3256;
      }
      localObject3 = (btz)((Iterator)localObject2).next();
      locala.SA("media");
      locala.SA("id");
      if (!aux(((btz)localObject3).Id).equals("")) {
        break label3240;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.SB("id");
      locala.SA("type");
      locala.setText(((btz)localObject3).ndI);
      locala.SB("type");
      locala.SA("title");
      locala.setText(auw(((btz)localObject3).Title));
      locala.SB("title");
      locala.SA("description");
      locala.setText(auw(((btz)localObject3).Desc));
      locala.SB("description");
      locala.SA("private");
      locala.setText(((btz)localObject3).Fjj);
      locala.SB("private");
      if (!bs.isNullOrNil(((btz)localObject3).songAlbumUrl))
      {
        locala.SA("songalbumurl");
        locala.setText(((btz)localObject3).songAlbumUrl);
        locala.SB("songalbumurl");
      }
      if (!bs.isNullOrNil(((btz)localObject3).songLyric))
      {
        locala.SA("songlyric");
        locala.setText(((btz)localObject3).songLyric);
        locala.SB("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((btz)localObject3).EUH);
      if (!bs.isNullOrNil(((btz)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((btz)localObject3).md5);
      }
      if (!bs.isNullOrNil(((btz)localObject3).FjC)) {
        ((Map)localObject1).put("videomd5", ((btz)localObject3).FjC);
      }
      locala.p("url", (Map)localObject1);
      locala.setText(auw(((btz)localObject3).Url));
      locala.SB("url");
      if ((((btz)localObject3).Fjh != null) && (!((btz)localObject3).Fjh.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((btz)localObject3).Fji);
        locala.p("thumb", (Map)localObject1);
        locala.setText(auw(((btz)localObject3).Fjh));
        locala.SB("thumb");
      }
      locala.SA("videoDuration");
      locala.setText(((btz)localObject3).FjD);
      locala.SB("videoDuration");
      if (((btz)localObject3).subType > 0)
      {
        locala.SA("subType");
        locala.setText(((btz)localObject3).subType);
        locala.SB("subType");
      }
      if (!bs.isNullOrNil(((btz)localObject3).yyV))
      {
        locala.SA("userData");
        locala.setText(((btz)localObject3).yyV);
        locala.SB("userData");
      }
      if ((((btz)localObject3).Fjl != null) && (!((btz)localObject3).Fjl.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((btz)localObject3).Fjm);
        locala.p("lowBandUrl", (Map)localObject1);
        locala.setText(auw(((btz)localObject3).Fjl));
        locala.SB("lowBandUrl");
      }
      if (((btz)localObject3).Fjk != null)
      {
        ((Map)localObject1).clear();
        if (((btz)localObject3).Fjk.FjY > 0.0F) {
          ((Map)localObject1).put("width", ((btz)localObject3).Fjk.FjY);
        }
        if (((btz)localObject3).Fjk.FjZ > 0.0F) {
          ((Map)localObject1).put("height", ((btz)localObject3).Fjk.FjZ);
        }
        if (((btz)localObject3).Fjk.Fka > 0.0F) {
          ((Map)localObject1).put("totalSize", ((btz)localObject3).Fjk.Fka);
        }
        locala.p("size", (Map)localObject1);
        locala.SB("size");
      }
      locala.SB("media");
      break label2318;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3240:
      locala.setText(aux(((btz)localObject3).Id));
    }
    label3256:
    locala.SB("mediaList");
    label3264:
    locala.mWO.append(auw(paramTimeLineObject.FQo.EtB));
    if ((paramTimeLineObject.FQo.EtC != null) && (paramTimeLineObject.FQo.EtC.hkQ != -1))
    {
      locala.SA("mmreadershare");
      locala.SA("itemshowtype");
      locala.setText(paramTimeLineObject.FQo.EtC.hkQ);
      locala.SB("itemshowtype");
      locala.SA("ispaysubscribe");
      locala.setText(paramTimeLineObject.FQo.EtC.hhb);
      locala.SB("ispaysubscribe");
      if (paramTimeLineObject.FQo.EtC.hkQ == 5)
      {
        locala.SA("pubtime");
        locala.setText(paramTimeLineObject.FQo.EtC.hgZ);
        locala.SB("pubtime");
        locala.SA("vid");
        locala.setText(paramTimeLineObject.FQo.EtC.hhd);
        locala.SB("vid");
        locala.SA("funcflag");
        locala.setText(paramTimeLineObject.FQo.EtC.hhc);
        locala.SB("funcflag");
        locala.SA("duration");
        locala.setText(paramTimeLineObject.FQo.EtC.duration);
        locala.SB("duration");
        locala.SA("digest");
        locala.setText(paramTimeLineObject.FQo.EtC.desc);
        locala.SB("digest");
        locala.SA("cover");
        locala.setText(paramTimeLineObject.FQo.EtC.coverUrl);
        locala.SB("cover");
        if (!bs.isNullOrNil(paramTimeLineObject.FQo.EtC.hhd))
        {
          locala.SA("nativepage");
          locala.setText(1);
          locala.SB("nativepage");
        }
        locala.SA("width");
        locala.setText(paramTimeLineObject.FQo.EtC.videoWidth);
        locala.SB("width");
        locala.SA("height");
        locala.setText(paramTimeLineObject.FQo.EtC.videoHeight);
        locala.SB("height");
      }
      locala.SB("mmreadershare");
    }
    if (paramTimeLineObject.FQo.EtD != null)
    {
      localObject1 = new b();
      ((b)localObject1).hTI = paramTimeLineObject.FQo.EtD;
      locala.append(e.b(((b)localObject1).hTI));
    }
    if (paramTimeLineObject.FQo.EtE != null)
    {
      localObject1 = new c();
      ((c)localObject1).hTJ = paramTimeLineObject.FQo.EtE;
      locala.append(e.a(((c)localObject1).hTJ));
    }
    locala.SB("ContentObject");
    if (paramTimeLineObject.xXR != null)
    {
      locala.SA("actionInfo");
      if (paramTimeLineObject.xXR.DNt != null)
      {
        locala.SA("appMsg");
        locala.SA("mediaTagName");
        locala.setText(paramTimeLineObject.xXR.DNt.DNn);
        locala.SB("mediaTagName");
        locala.SA("messageExt");
        locala.setText(paramTimeLineObject.xXR.DNt.DNo);
        locala.SB("messageExt");
        locala.SA("messageAction");
        locala.setText(paramTimeLineObject.xXR.DNt.DNp);
        locala.SB("messageAction");
        locala.SB("appMsg");
      }
      locala.SB("actionInfo");
    }
    if ((paramTimeLineObject.FQn != null) && (!bs.isNullOrNil(paramTimeLineObject.FQn.Id)))
    {
      localObject1 = paramTimeLineObject.yAj;
      localObject2 = new dcu();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((dcu)localObject2).parseFrom((byte[])localObject3);
      label3970:
      ((dcu)localObject2).FMu = new dcs();
      ((dcu)localObject2).FMu.tdD = paramTimeLineObject.FQn.Id;
      try
      {
        localObject2 = Base64.encodeToString(((dcu)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
        AppMethodBeat.o(96172);
        return paramTimeLineObject;
      }
      paramTimeLineObject.yAj = ((String)localObject1);
      if (paramTimeLineObject.yAj != null)
      {
        locala.SA("statExtStr");
        locala.setText(paramTimeLineObject.yAj);
        locala.SB("statExtStr");
      }
      locala.SB("TimelineObject");
      paramTimeLineObject = locala.mWO.toString();
      ac.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (bv.L(paramTimeLineObject, "TimelineObject") == null)
      {
        ac.e("MicroMsg.TimelineConvert", "xml is error");
        AppMethodBeat.o(96172);
        return "";
      }
    }
    catch (Exception localException)
    {
      break label3970;
    }
  }
  
  static final class a
  {
    StringBuffer mWO;
    
    a()
    {
      AppMethodBeat.i(96165);
      this.mWO = new StringBuffer();
      AppMethodBeat.o(96165);
    }
    
    public final void SA(String paramString)
    {
      AppMethodBeat.i(96166);
      this.mWO.append("<" + paramString + ">");
      AppMethodBeat.o(96166);
    }
    
    public final void SB(String paramString)
    {
      AppMethodBeat.i(96167);
      this.mWO.append("</" + paramString + ">");
      AppMethodBeat.o(96167);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(163073);
      if (!bs.isNullOrNil(paramString)) {
        this.mWO.append(paramString);
      }
      AppMethodBeat.o(163073);
    }
    
    public final void p(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(96170);
      this.mWO.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.mWO.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.mWO.append(">");
      paramMap.clear();
      AppMethodBeat.o(96170);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(96169);
      this.mWO.append(paramInt);
      AppMethodBeat.o(96169);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(96168);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96168);
        return;
      }
      if (paramString.contains(n.mWM))
      {
        this.mWO.append("<![CDATA[" + bs.aLw(paramString) + "]]>");
        AppMethodBeat.o(96168);
        return;
      }
      this.mWO.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(96168);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.n
 * JD-Core Version:    0.7.0.1
 */