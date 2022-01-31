package com.tencent.mm.plugin.sns.h;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class l
{
  public static String jDr = "]]>";
  public static String jzf = "<TimelineObject>";
  public static String jzg = "</TimelineObject>";
  
  private static String abd(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String abe(String paramString)
  {
    AppMethodBeat.i(36840);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36840);
      return "";
    }
    if (paramString.matches("\\d*")) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(36840);
      return paramString;
    }
    AppMethodBeat.o(36840);
    return "";
  }
  
  public static String b(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(36841);
    l.a locala = new l.a();
    Object localObject1 = new HashMap();
    locala.Gp("TimelineObject");
    locala.Gp("id");
    Object localObject2;
    label2082:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.Gq("id");
      if (paramTimeLineObject.jJA != null)
      {
        locala.Gp("username");
        locala.setText(paramTimeLineObject.jJA);
        locala.Gq("username");
      }
      locala.Gp("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.Gq("createTime");
      locala.Gp("contentDescShowType");
      locala.setText(paramTimeLineObject.xTU);
      locala.Gq("contentDescShowType");
      locala.Gp("contentDescScene");
      locala.setText(paramTimeLineObject.xTV);
      locala.Gq("contentDescScene");
      locala.Gp("private");
      locala.setText(paramTimeLineObject.xrU);
      locala.Gq("private");
      if ((paramTimeLineObject.xTR != null) && (!bo.isNullOrNil(paramTimeLineObject.xTR.Id)))
      {
        locala.Gp("appInfo");
        locala.Gp("id");
        locala.setText(abd(paramTimeLineObject.xTR.Id));
        locala.Gq("id");
        locala.Gp("version");
        locala.setText(abd(paramTimeLineObject.xTR.jKg));
        locala.Gq("version");
        locala.Gp("appName");
        locala.setText(abd(paramTimeLineObject.xTR.ntp));
        locala.Gq("appName");
        locala.Gp("installUrl");
        locala.setText(abd(paramTimeLineObject.xTR.wpJ));
        locala.Gq("installUrl");
        locala.Gp("fromUrl");
        locala.setText(abd(paramTimeLineObject.xTR.wpK));
        locala.Gq("fromUrl");
        locala.Gq("appInfo");
      }
      if ((paramTimeLineObject.xTX != null) && (!bo.isNullOrNil(paramTimeLineObject.xTX.fiO)))
      {
        locala.Gp("streamvideo");
        locala.Gp("streamvideourl");
        locala.setText(abd(paramTimeLineObject.xTX.fiO));
        locala.Gq("streamvideourl");
        locala.Gp("streamvideototaltime");
        locala.setText(paramTimeLineObject.xTX.fiP);
        locala.Gq("streamvideototaltime");
        locala.Gp("streamvideotitle");
        locala.setText(abd(paramTimeLineObject.xTX.fiQ));
        locala.Gq("streamvideotitle");
        locala.Gp("streamvideowording");
        locala.setText(abd(paramTimeLineObject.xTX.fiR));
        locala.Gq("streamvideowording");
        locala.Gp("streamvideoweburl");
        locala.setText(abd(paramTimeLineObject.xTX.fiS));
        locala.Gq("streamvideoweburl");
        locala.Gp("streamvideothumburl");
        locala.setText(abd(paramTimeLineObject.xTX.fiT));
        locala.Gq("streamvideothumburl");
        locala.Gp("streamvideoaduxinfo");
        locala.setText(abd(paramTimeLineObject.xTX.fiU));
        locala.Gq("streamvideoaduxinfo");
        locala.Gp("streamvideopublishid");
        locala.setText(abd(paramTimeLineObject.xTX.fiV));
        locala.Gq("streamvideopublishid");
        locala.Gq("streamvideo");
      }
      if ((paramTimeLineObject.rjx != null) && (!bo.isNullOrNil(paramTimeLineObject.rjx.uJi)))
      {
        locala.Gp("websearch");
        locala.Gp("relevant_vid");
        locala.setText(abd(paramTimeLineObject.rjx.uJi));
        locala.Gq("relevant_vid");
        locala.Gp("relevant_expand");
        locala.setText(abd(paramTimeLineObject.rjx.uJj));
        locala.Gq("relevant_expand");
        locala.Gp("relevant_pre_searchid");
        locala.setText(abd(paramTimeLineObject.rjx.uJk));
        locala.Gq("relevant_pre_searchid");
        locala.Gp("relevant_shared_openid");
        locala.setText(abd(paramTimeLineObject.rjx.uJl));
        locala.Gq("relevant_shared_openid");
        locala.Gp("rec_category");
        locala.setText(abd(paramTimeLineObject.rjx.uJm));
        locala.Gq("rec_category");
        locala.Gp("shareUrl");
        locala.setText(abd(paramTimeLineObject.rjx.lHq));
        locala.Gq("shareUrl");
        locala.Gp("shareTitle");
        locala.setText(abd(paramTimeLineObject.rjx.lHr));
        locala.Gq("shareTitle");
        locala.Gp("shareDesc");
        locala.setText(abd(paramTimeLineObject.rjx.rrm));
        locala.Gq("shareDesc");
        locala.Gp("shareImgUrl");
        locala.setText(abd(paramTimeLineObject.rjx.uJn));
        locala.Gq("shareImgUrl");
        locala.Gp("shareString");
        locala.setText(abd(paramTimeLineObject.rjx.uJo));
        locala.Gq("shareString");
        locala.Gp("shareStringUrl");
        locala.setText(abd(paramTimeLineObject.rjx.uJp));
        locala.Gq("shareStringUrl");
        locala.Gp("source");
        locala.setText(abd(paramTimeLineObject.rjx.source));
        locala.Gq("source");
        locala.Gp("strPlayCount");
        locala.setText(abd(paramTimeLineObject.rjx.uJq));
        locala.Gq("strPlayCount");
        locala.Gp("titleUrl");
        locala.setText(abd(paramTimeLineObject.rjx.uJr));
        locala.Gq("titleUrl");
        locala.Gp("extReqParams");
        locala.setText(abd(paramTimeLineObject.rjx.uJs));
        locala.Gq("extReqParams");
        locala.Gp("tagList");
        locala.setText(abd(paramTimeLineObject.rjx.uJt));
        locala.Gq("tagList");
        locala.Gp("channelId");
        locala.setText(abd(paramTimeLineObject.rjx.uJu));
        locala.Gq("channelId");
        locala.Gp("thumbUrl");
        locala.setText(abd(paramTimeLineObject.rjx.thumbUrl));
        locala.Gq("thumbUrl");
        locala.Gp("shareTag");
        locala.setText(abd(paramTimeLineObject.rjx.uJv));
        locala.Gq("shareTag");
        locala.Gq("websearch");
      }
      locala.Gp("contentDesc");
      locala.setText(abd(paramTimeLineObject.xTP));
      locala.Gq("contentDesc");
      locala.Gp("contentattr");
      locala.setText(paramTimeLineObject.fgB);
      locala.Gq("contentattr");
      locala.Gp("sourceUserName");
      locala.setText(abd(paramTimeLineObject.inF));
      locala.Gq("sourceUserName");
      locala.Gp("sourceNickName");
      locala.setText(abd(paramTimeLineObject.vSR));
      locala.Gq("sourceNickName");
      locala.Gp("statisticsData");
      locala.setText(abd(paramTimeLineObject.xTW));
      locala.Gq("statisticsData");
      locala.Gp("weappInfo");
      locala.Gp("appUserName");
      locala.setText(abd(paramTimeLineObject.xTY.username));
      locala.Gq("appUserName");
      locala.Gp("pagePath");
      locala.setText(abd(paramTimeLineObject.xTY.path));
      locala.Gq("pagePath");
      locala.Gq("weappInfo");
      locala.Gp("canvasInfoXml");
      locala.setText(abd(paramTimeLineObject.sbN));
      locala.Gq("canvasInfoXml");
      if (paramTimeLineObject.xTQ != null)
      {
        float f1 = paramTimeLineObject.xTQ.wDh;
        float f2 = paramTimeLineObject.xTQ.wDi;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.xTQ.wDh);
          ((Map)localObject1).put("latitude", paramTimeLineObject.xTQ.wDi);
          ((Map)localObject1).put("city", bo.apT(abd(paramTimeLineObject.xTQ.gwR)));
          ((Map)localObject1).put("poiName", bo.apT(abd(paramTimeLineObject.xTQ.eSM)));
          ((Map)localObject1).put("poiAddress", bo.apT(abd(paramTimeLineObject.xTQ.rIe)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.xTQ.xpP);
          ((Map)localObject1).put("poiClassifyId", abd(paramTimeLineObject.xTQ.xpN));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.xTQ.rIg);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.xTQ.xpQ);
          locala.n("location", (Map)localObject1);
          locala.Gq("location");
        }
      }
      locala.Gp("ContentObject");
      locala.Gp("contentStyle");
      locala.setText(paramTimeLineObject.xTS.wNZ);
      locala.Gq("contentStyle");
      locala.Gp("contentSubStyle");
      locala.setText(paramTimeLineObject.xTS.wOb);
      locala.Gq("contentSubStyle");
      locala.Gp("title");
      locala.setText(abd(paramTimeLineObject.xTS.Title));
      locala.Gq("title");
      locala.Gp("description");
      locala.setText(abd(paramTimeLineObject.xTS.Desc));
      locala.Gq("description");
      locala.Gp("contentUrl");
      locala.setText(abd(paramTimeLineObject.xTS.Url));
      locala.Gq("contentUrl");
      if (paramTimeLineObject.xTS.wOa.size() <= 0) {
        break label2915;
      }
      locala.Gp("mediaList");
      localObject2 = paramTimeLineObject.xTS.wOa.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label2907;
      }
      localObject3 = (bcs)((Iterator)localObject2).next();
      locala.Gp("media");
      locala.Gp("id");
      if (!abe(((bcs)localObject3).Id).equals("")) {
        break label2891;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.Gq("id");
      locala.Gp("type");
      locala.setText(((bcs)localObject3).jKs);
      locala.Gq("type");
      locala.Gp("title");
      locala.setText(abd(((bcs)localObject3).Title));
      locala.Gq("title");
      locala.Gp("description");
      locala.setText(abd(((bcs)localObject3).Desc));
      locala.Gq("description");
      locala.Gp("private");
      locala.setText(((bcs)localObject3).xrU);
      locala.Gq("private");
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((bcs)localObject3).xrR);
      if (!bo.isNullOrNil(((bcs)localObject3).cqq)) {
        ((Map)localObject1).put("md5", ((bcs)localObject3).cqq);
      }
      if (!bo.isNullOrNil(((bcs)localObject3).xsn)) {
        ((Map)localObject1).put("videomd5", ((bcs)localObject3).xsn);
      }
      locala.n("url", (Map)localObject1);
      locala.setText(abd(((bcs)localObject3).Url));
      locala.Gq("url");
      if ((((bcs)localObject3).xrS != null) && (!((bcs)localObject3).xrS.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bcs)localObject3).xrT);
        locala.n("thumb", (Map)localObject1);
        locala.setText(abd(((bcs)localObject3).xrS));
        locala.Gq("thumb");
      }
      if (((bcs)localObject3).subType > 0)
      {
        locala.Gp("subType");
        locala.setText(((bcs)localObject3).subType);
        locala.Gq("subType");
      }
      if (!bo.isNullOrNil(((bcs)localObject3).rGh))
      {
        locala.Gp("userData");
        locala.setText(((bcs)localObject3).rGh);
        locala.Gq("userData");
      }
      if ((((bcs)localObject3).xrW != null) && (!((bcs)localObject3).xrW.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((bcs)localObject3).xrX);
        locala.n("lowBandUrl", (Map)localObject1);
        locala.setText(abd(((bcs)localObject3).xrW));
        locala.Gq("lowBandUrl");
      }
      if (((bcs)localObject3).xrV != null)
      {
        ((Map)localObject1).clear();
        if (((bcs)localObject3).xrV.xsH > 0.0F) {
          ((Map)localObject1).put("width", ((bcs)localObject3).xrV.xsH);
        }
        if (((bcs)localObject3).xrV.xsI > 0.0F) {
          ((Map)localObject1).put("height", ((bcs)localObject3).xrV.xsI);
        }
        if (((bcs)localObject3).xrV.xsJ > 0.0F) {
          ((Map)localObject1).put("totalSize", ((bcs)localObject3).xrV.xsJ);
        }
        locala.n("size", (Map)localObject1);
        locala.Gq("size");
      }
      locala.Gq("media");
      break label2082;
      locala.setText(paramTimeLineObject.Id);
      break;
      label2891:
      locala.setText(abe(((bcs)localObject3).Id));
    }
    label2907:
    locala.Gq("mediaList");
    label2915:
    locala.jDt.append(abd(paramTimeLineObject.xTS.wOc));
    if ((paramTimeLineObject.xTS.wOd != null) && (paramTimeLineObject.xTS.wOd.wqp != -1))
    {
      locala.Gp("mmreadershare");
      if (paramTimeLineObject.xTS.wOd.wqp == 5)
      {
        locala.Gp("itemshowtype");
        locala.setText(paramTimeLineObject.xTS.wOd.wqp);
        locala.Gq("itemshowtype");
        locala.Gp("pubtime");
        locala.setText(paramTimeLineObject.xTS.wOd.fgi);
        locala.Gq("pubtime");
        locala.Gp("vid");
        locala.setText(paramTimeLineObject.xTS.wOd.fgl);
        locala.Gq("vid");
        locala.Gp("funcflag");
        locala.setText(paramTimeLineObject.xTS.wOd.fgk);
        locala.Gq("funcflag");
        locala.Gp("duration");
        locala.setText(paramTimeLineObject.xTS.wOd.duration);
        locala.Gq("duration");
        locala.Gp("digest");
        locala.setText(paramTimeLineObject.xTS.wOd.desc);
        locala.Gq("digest");
        locala.Gp("cover");
        locala.setText(paramTimeLineObject.xTS.wOd.lHo);
        locala.Gq("cover");
        if (!bo.isNullOrNil(paramTimeLineObject.xTS.wOd.fgl))
        {
          locala.Gp("nativepage");
          locala.setText(1);
          locala.Gq("nativepage");
        }
        locala.Gp("width");
        locala.setText(paramTimeLineObject.xTS.wOd.videoWidth);
        locala.Gq("width");
        locala.Gp("height");
        locala.setText(paramTimeLineObject.xTS.wOd.videoHeight);
        locala.Gq("height");
      }
      locala.Gq("mmreadershare");
    }
    locala.Gq("ContentObject");
    if (paramTimeLineObject.rjv != null)
    {
      locala.Gp("actionInfo");
      if (paramTimeLineObject.rjv.wmJ != null)
      {
        locala.Gp("appMsg");
        locala.Gp("mediaTagName");
        locala.setText(paramTimeLineObject.rjv.wmJ.wmD);
        locala.Gq("mediaTagName");
        locala.Gp("messageExt");
        locala.setText(paramTimeLineObject.rjv.wmJ.wmE);
        locala.Gq("messageExt");
        locala.Gp("messageAction");
        locala.setText(paramTimeLineObject.rjv.wmJ.wmF);
        locala.Gq("messageAction");
        locala.Gq("appMsg");
      }
      locala.Gq("actionInfo");
    }
    if ((paramTimeLineObject.xTR != null) && (!bo.isNullOrNil(paramTimeLineObject.xTR.Id)))
    {
      localObject1 = paramTimeLineObject.rHA;
      localObject2 = new cgh();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((cgh)localObject2).parseFrom((byte[])localObject3);
      label3508:
      ((cgh)localObject2).xRa = new cgf();
      ((cgh)localObject2).xRa.nmH = paramTimeLineObject.xTR.Id;
      try
      {
        localObject2 = Base64.encodeToString(((cgh)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
        AppMethodBeat.o(36841);
        return paramTimeLineObject;
      }
      paramTimeLineObject.rHA = ((String)localObject1);
      if (paramTimeLineObject.rHA != null)
      {
        locala.Gp("statExtStr");
        locala.setText(paramTimeLineObject.rHA);
        locala.Gq("statExtStr");
      }
      locala.Gq("TimelineObject");
      paramTimeLineObject = locala.jDt.toString();
      ab.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (br.F(paramTimeLineObject, "TimelineObject") == null)
      {
        ab.e("MicroMsg.TimelineConvert", "xml is error");
        AppMethodBeat.o(36841);
        return "";
      }
    }
    catch (Exception localException)
    {
      break label3508;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.l
 * JD-Core Version:    0.7.0.1
 */