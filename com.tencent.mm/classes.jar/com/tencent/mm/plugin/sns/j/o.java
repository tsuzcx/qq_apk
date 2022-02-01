package com.tencent.mm.plugin.sns.j;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelsns.i;
import com.tencent.mm.modelsns.j;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.plugin.findersdk.a.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class o
{
  public static String INVALID_TAG = "]]>";
  public static String rLm = "<TimelineObject>";
  public static String rLn = "</TimelineObject>";
  
  public static String e(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(96172);
    a locala = new a();
    Object localObject1 = new HashMap();
    locala.startTag("TimelineObject");
    locala.startTag("id");
    Object localObject2;
    label2343:
    Object localObject3;
    if ((paramTimeLineObject.Id == null) || (paramTimeLineObject.Id.equals("")))
    {
      locala.setText("0");
      locala.endTag("id");
      if (paramTimeLineObject.UserName != null)
      {
        locala.startTag("username");
        locala.setText(paramTimeLineObject.UserName);
        locala.endTag("username");
      }
      locala.startTag("createTime");
      locala.setText(paramTimeLineObject.CreateTime);
      locala.endTag("createTime");
      locala.startTag("contentDescShowType");
      locala.setText(paramTimeLineObject.contentDescShowType);
      locala.endTag("contentDescShowType");
      locala.startTag("contentDescScene");
      locala.setText(paramTimeLineObject.contentDescScene);
      locala.endTag("contentDescScene");
      locala.startTag("private");
      locala.setText(paramTimeLineObject.Privated);
      locala.endTag("private");
      if ((paramTimeLineObject.AppInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.AppInfo.Id)))
      {
        locala.startTag("appInfo");
        locala.startTag("id");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.Id));
        locala.endTag("id");
        locala.startTag("version");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.Version));
        locala.endTag("version");
        locala.startTag("appName");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.CQz));
        locala.endTag("appName");
        locala.startTag("installUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.RJH));
        locala.endTag("installUrl");
        locala.startTag("fromUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.RJI));
        locala.endTag("fromUrl");
        locala.endTag("appInfo");
      }
      if ((paramTimeLineObject.streamvideo != null) && (!Util.isNullOrNil(paramTimeLineObject.streamvideo.lor)))
      {
        locala.startTag("streamvideo");
        locala.startTag("streamvideourl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.lor));
        locala.endTag("streamvideourl");
        locala.startTag("streamvideototaltime");
        locala.setText(paramTimeLineObject.streamvideo.los);
        locala.endTag("streamvideototaltime");
        locala.startTag("streamvideotitle");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.lot));
        locala.endTag("streamvideotitle");
        locala.startTag("streamvideowording");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.lou));
        locala.endTag("streamvideowording");
        locala.startTag("streamvideoweburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.lov));
        locala.endTag("streamvideoweburl");
        locala.startTag("streamvideothumburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.low));
        locala.endTag("streamvideothumburl");
        locala.startTag("streamvideoaduxinfo");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.lox));
        locala.endTag("streamvideoaduxinfo");
        locala.startTag("streamvideopublishid");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.loy));
        locala.endTag("streamvideopublishid");
        locala.endTag("streamvideo");
      }
      if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.PyQ)))
      {
        locala.startTag("websearch");
        locala.startTag("relevant_vid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyQ));
        locala.endTag("relevant_vid");
        locala.startTag("relevant_expand");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyR));
        locala.endTag("relevant_expand");
        locala.startTag("relevant_pre_searchid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyS));
        locala.endTag("relevant_pre_searchid");
        locala.startTag("relevant_shared_openid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyT));
        locala.endTag("relevant_shared_openid");
        locala.startTag("rec_category");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyU));
        locala.endTag("rec_category");
        locala.startTag("shareUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.vhY));
        locala.endTag("shareUrl");
        locala.startTag("shareTitle");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.pqW));
        locala.endTag("shareTitle");
        locala.startTag("shareDesc");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.CHR));
        locala.endTag("shareDesc");
        locala.startTag("shareImgUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyV));
        locala.endTag("shareImgUrl");
        locala.startTag("shareString");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyW));
        locala.endTag("shareString");
        locala.startTag("shareStringUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyX));
        locala.endTag("shareStringUrl");
        locala.startTag("source");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.source));
        locala.endTag("source");
        locala.startTag("strPlayCount");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyY));
        locala.endTag("strPlayCount");
        locala.startTag("titleUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.PyZ));
        locala.endTag("titleUrl");
        locala.startTag("extReqParams");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Pza));
        locala.endTag("extReqParams");
        locala.startTag("tagList");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Pzb));
        locala.endTag("tagList");
        locala.startTag("channelId");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Pzc));
        locala.endTag("channelId");
        locala.startTag("thumbUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.thumbUrl));
        locala.endTag("thumbUrl");
        locala.startTag("shareTag");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Pzd));
        locala.endTag("shareTag");
        locala.endTag("websearch");
      }
      locala.startTag("contentDesc");
      locala.setText(filterNull(paramTimeLineObject.ContentDesc));
      locala.endTag("contentDesc");
      locala.startTag("contentattr");
      locala.setText(paramTimeLineObject.contentattr);
      locala.endTag("contentattr");
      locala.startTag("sourceUserName");
      locala.setText(filterNull(paramTimeLineObject.sourceUserName));
      locala.endTag("sourceUserName");
      locala.startTag("sourceNickName");
      locala.setText(filterNull(paramTimeLineObject.sourceNickName));
      locala.endTag("sourceNickName");
      locala.startTag("statisticsData");
      locala.setText(filterNull(paramTimeLineObject.statisticsData));
      locala.endTag("statisticsData");
      locala.startTag("weappInfo");
      locala.startTag("appUserName");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.username));
      locala.endTag("appUserName");
      locala.startTag("pagePath");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.path));
      locala.endTag("pagePath");
      locala.startTag("version");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.version));
      locala.endTag("version");
      locala.startTag("debugMode");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.qbu));
      locala.endTag("debugMode");
      locala.startTag("shareActionId");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.fvj));
      locala.endTag("shareActionId");
      locala.startTag("isGame");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.UIv));
      locala.endTag("isGame");
      locala.startTag("messageExtraData");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.fXg));
      locala.endTag("messageExtraData");
      locala.startTag("subType");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.subType));
      locala.endTag("subType");
      locala.startTag("preloadResources");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.UIw));
      locala.endTag("preloadResources");
      locala.endTag("weappInfo");
      locala.startTag("canvasInfoXml");
      locala.setText(filterNull(paramTimeLineObject.canvasInfo));
      locala.endTag("canvasInfoXml");
      if (paramTimeLineObject.Location != null)
      {
        float f1 = paramTimeLineObject.Location.ScO;
        float f2 = paramTimeLineObject.Location.ScP;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.Location.ScO);
          ((Map)localObject1).put("latitude", paramTimeLineObject.Location.ScP);
          ((Map)localObject1).put("city", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.mVA)));
          ((Map)localObject1).put("poiName", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.poiName)));
          ((Map)localObject1).put("poiAddress", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.KFu)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.Location.TAz);
          ((Map)localObject1).put("poiClassifyId", filterNull(paramTimeLineObject.Location.SOz));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.Location.KFw);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.Location.TAA);
          locala.startTag("location", (Map)localObject1);
          locala.endTag("location");
        }
      }
      locala.startTag("ContentObject");
      locala.startTag("contentStyle");
      locala.setText(paramTimeLineObject.ContentObj.Sqq);
      locala.endTag("contentStyle");
      locala.startTag("contentSubStyle");
      locala.setText(paramTimeLineObject.ContentObj.Sqs);
      locala.endTag("contentSubStyle");
      locala.startTag("title");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.fwr));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.CMB));
      locala.endTag("description");
      locala.startTag("contentUrl");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.Url));
      locala.endTag("contentUrl");
      if (paramTimeLineObject.ContentObj.Sqr.size() <= 0) {
        break label3289;
      }
      locala.startTag("mediaList");
      localObject2 = paramTimeLineObject.ContentObj.Sqr.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3281;
      }
      localObject3 = (cvt)((Iterator)localObject2).next();
      locala.startTag("media");
      locala.startTag("id");
      if (!filterId(((cvt)localObject3).Id).equals("")) {
        break label3265;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.endTag("id");
      locala.startTag("type");
      locala.setText(((cvt)localObject3).rWu);
      locala.endTag("type");
      locala.startTag("title");
      locala.setText(filterNull(((cvt)localObject3).fwr));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(((cvt)localObject3).CMB));
      locala.endTag("description");
      locala.startTag("private");
      locala.setText(((cvt)localObject3).Privated);
      locala.endTag("private");
      if (!Util.isNullOrNil(((cvt)localObject3).songAlbumUrl))
      {
        locala.startTag("songalbumurl");
        locala.setText(((cvt)localObject3).songAlbumUrl);
        locala.endTag("songalbumurl");
      }
      if (!Util.isNullOrNil(((cvt)localObject3).songLyric))
      {
        locala.startTag("songlyric");
        locala.setText(((cvt)localObject3).songLyric);
        locala.endTag("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((cvt)localObject3).TlV);
      if (!Util.isNullOrNil(((cvt)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((cvt)localObject3).md5);
      }
      if (!Util.isNullOrNil(((cvt)localObject3).TDY)) {
        ((Map)localObject1).put("videomd5", ((cvt)localObject3).TDY);
      }
      locala.startTag("url", (Map)localObject1);
      locala.setText(filterNull(((cvt)localObject3).Url));
      locala.endTag("url");
      if ((((cvt)localObject3).TDF != null) && (!((cvt)localObject3).TDF.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((cvt)localObject3).TDG);
        locala.startTag("thumb", (Map)localObject1);
        locala.setText(filterNull(((cvt)localObject3).TDF));
        locala.endTag("thumb");
      }
      locala.startTag("videoDuration");
      locala.setText(((cvt)localObject3).TDZ);
      locala.endTag("videoDuration");
      if (((cvt)localObject3).subType > 0)
      {
        locala.startTag("subType");
        locala.setText(((cvt)localObject3).subType);
        locala.endTag("subType");
      }
      if (!Util.isNullOrNil(((cvt)localObject3).KCT))
      {
        locala.startTag("userData");
        locala.setText(((cvt)localObject3).KCT);
        locala.endTag("userData");
      }
      if ((((cvt)localObject3).TDI != null) && (!((cvt)localObject3).TDI.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((cvt)localObject3).TDJ);
        locala.startTag("lowBandUrl", (Map)localObject1);
        locala.setText(filterNull(((cvt)localObject3).TDI));
        locala.endTag("lowBandUrl");
      }
      if (((cvt)localObject3).TDH != null)
      {
        ((Map)localObject1).clear();
        if (((cvt)localObject3).TDH.TEu > 0.0F) {
          ((Map)localObject1).put("width", ((cvt)localObject3).TDH.TEu);
        }
        if (((cvt)localObject3).TDH.TEv > 0.0F) {
          ((Map)localObject1).put("height", ((cvt)localObject3).TDH.TEv);
        }
        if (((cvt)localObject3).TDH.TEw > 0.0F) {
          ((Map)localObject1).put("totalSize", ((cvt)localObject3).TDH.TEw);
        }
        locala.startTag("size", (Map)localObject1);
        locala.endTag("size");
      }
      locala.endTag("media");
      break label2343;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3265:
      locala.setText(filterId(((cvt)localObject3).Id));
    }
    label3281:
    locala.endTag("mediaList");
    label3289:
    locala.sb.append(filterNull(paramTimeLineObject.ContentObj.Sqt));
    if ((paramTimeLineObject.ContentObj.Squ != null) && (paramTimeLineObject.ContentObj.Squ.lpx != -1))
    {
      locala.startTag("mmreadershare");
      locala.startTag("itemshowtype");
      locala.setText(paramTimeLineObject.ContentObj.Squ.lpx);
      locala.endTag("itemshowtype");
      locala.startTag("ispaysubscribe");
      locala.setText(paramTimeLineObject.ContentObj.Squ.lls);
      locala.endTag("ispaysubscribe");
      if (paramTimeLineObject.ContentObj.Squ.lpx == 5)
      {
        locala.startTag("pubtime");
        locala.setText(paramTimeLineObject.ContentObj.Squ.llq);
        locala.endTag("pubtime");
        locala.startTag("vid");
        locala.setText(paramTimeLineObject.ContentObj.Squ.vid);
        locala.endTag("vid");
        locala.startTag("funcflag");
        locala.setText(paramTimeLineObject.ContentObj.Squ.llt);
        locala.endTag("funcflag");
        locala.startTag("duration");
        locala.setText(paramTimeLineObject.ContentObj.Squ.duration);
        locala.endTag("duration");
        locala.startTag("digest");
        locala.setText(paramTimeLineObject.ContentObj.Squ.desc);
        locala.endTag("digest");
        locala.startTag("cover");
        locala.setText(paramTimeLineObject.ContentObj.Squ.coverUrl);
        locala.endTag("cover");
        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Squ.vid))
        {
          locala.startTag("nativepage");
          locala.setText(1);
          locala.endTag("nativepage");
        }
        locala.startTag("width");
        locala.setText(paramTimeLineObject.ContentObj.Squ.videoWidth);
        locala.endTag("width");
        locala.startTag("height");
        locala.setText(paramTimeLineObject.ContentObj.Squ.videoHeight);
        locala.endTag("height");
      }
      locala.endTag("mmreadershare");
    }
    if (paramTimeLineObject.ContentObj.fFJ != null)
    {
      localObject1 = new e();
      ((e)localObject1).mbi = paramTimeLineObject.ContentObj.fFJ;
      locala.append(k.b(((e)localObject1).mbi));
    }
    if (paramTimeLineObject.ContentObj.lVY != null)
    {
      localObject1 = new j();
      ((j)localObject1).mbm = paramTimeLineObject.ContentObj.lVY;
      locala.append(am.a(((j)localObject1).mbm));
    }
    if (paramTimeLineObject.ContentObj.Sqy != null)
    {
      localObject1 = new h();
      ((h)localObject1).mbk = paramTimeLineObject.ContentObj.Sqy;
      locala.append(k.a(((h)localObject1).mbk));
    }
    if (paramTimeLineObject.ContentObj.Sqv != null)
    {
      localObject1 = new g();
      ((g)localObject1).mbf = paramTimeLineObject.ContentObj.Sqv;
      locala.append(k.b(((g)localObject1).mbf));
    }
    if (paramTimeLineObject.ContentObj.Sqz != null)
    {
      localObject1 = new b();
      ((b)localObject1).mbf = paramTimeLineObject.ContentObj.Sqz;
      locala.append(((b)localObject1).boV());
    }
    if (paramTimeLineObject.ContentObj.Sqw != null)
    {
      localObject1 = new i();
      ((i)localObject1).mbl = paramTimeLineObject.ContentObj.Sqw;
      locala.append(i.b(((i)localObject1).mbl));
    }
    if (paramTimeLineObject.ContentObj.yNL != null)
    {
      localObject1 = new d();
      ((d)localObject1).a(paramTimeLineObject.ContentObj.yNL);
      locala.append(((d)localObject1).boV());
    }
    if (paramTimeLineObject.ContentObj.Sqx != null)
    {
      localObject1 = new c();
      ((c)localObject1).mbg = paramTimeLineObject.ContentObj.Sqx;
      locala.append(k.a(((c)localObject1).mbg));
    }
    if (paramTimeLineObject.ContentObj.SqA != null)
    {
      localObject1 = new f();
      ((f)localObject1).mbj = paramTimeLineObject.ContentObj.SqA;
      locala.append(((f)localObject1).boV());
    }
    locala.endTag("ContentObject");
    if (paramTimeLineObject.actionInfo != null)
    {
      locala.startTag("actionInfo");
      if (paramTimeLineObject.actionInfo.RFO != null)
      {
        locala.startTag("appMsg");
        locala.startTag("mediaTagName");
        locala.setText(paramTimeLineObject.actionInfo.RFO.RFI);
        locala.endTag("mediaTagName");
        locala.startTag("messageExt");
        locala.setText(paramTimeLineObject.actionInfo.RFO.RFJ);
        locala.endTag("messageExt");
        locala.startTag("messageAction");
        locala.setText(paramTimeLineObject.actionInfo.RFO.RFK);
        locala.endTag("messageAction");
        locala.endTag("appMsg");
      }
      locala.endTag("actionInfo");
    }
    if ((paramTimeLineObject.AppInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.AppInfo.Id)))
    {
      localObject1 = paramTimeLineObject.statExtStr;
      localObject2 = new emp();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((emp)localObject2).parseFrom((byte[])localObject3);
      label4273:
      ((emp)localObject2).Upg = new emn();
      ((emp)localObject2).Upg.CIO = paramTimeLineObject.AppInfo.Id;
      try
      {
        localObject2 = Base64.encodeToString(((emp)localObject2).toByteArray(), 0);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).replace("\n", "");
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TimelineConvert", localIOException, "", new Object[0]);
        }
        AppMethodBeat.o(96172);
        return paramTimeLineObject;
      }
      paramTimeLineObject.statExtStr = ((String)localObject1);
      if (paramTimeLineObject.statExtStr != null)
      {
        locala.startTag("statExtStr");
        locala.setText(paramTimeLineObject.statExtStr);
        locala.endTag("statExtStr");
      }
      if ((paramTimeLineObject.liteappInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.liteappInfo.appId)))
      {
        locala.startTag("liteApp");
        locala.startTag("appId");
        locala.setText(filterNull(paramTimeLineObject.liteappInfo.appId));
        locala.endTag("appId");
        locala.startTag("path");
        locala.setText(filterNull(paramTimeLineObject.liteappInfo.path));
        locala.endTag("path");
        locala.startTag("query");
        locala.setText(filterNull(paramTimeLineObject.liteappInfo.query));
        locala.endTag("query");
        locala.endTag("liteApp");
      }
      locala.endTag("TimelineObject");
      paramTimeLineObject = locala.sb.toString();
      Log.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
      if (XmlParser.parseXml(paramTimeLineObject, "TimelineObject", null) == null)
      {
        Log.e("MicroMsg.TimelineConvert", "xml is error");
        AppMethodBeat.o(96172);
        return "";
      }
    }
    catch (Exception localException)
    {
      break label4273;
    }
  }
  
  private static String filterId(String paramString)
  {
    AppMethodBeat.i(96171);
    if (Util.isNullOrNil(paramString))
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
  
  private static String filterNull(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  static final class a
  {
    StringBuffer sb;
    
    a()
    {
      AppMethodBeat.i(96165);
      this.sb = new StringBuffer();
      AppMethodBeat.o(96165);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(163073);
      if (!Util.isNullOrNil(paramString)) {
        this.sb.append(paramString);
      }
      AppMethodBeat.o(163073);
    }
    
    public final void endTag(String paramString)
    {
      AppMethodBeat.i(96167);
      this.sb.append("</" + paramString + ">");
      AppMethodBeat.o(96167);
    }
    
    public final void setText(int paramInt)
    {
      AppMethodBeat.i(96169);
      this.sb.append(paramInt);
      AppMethodBeat.o(96169);
    }
    
    public final void setText(String paramString)
    {
      AppMethodBeat.i(96168);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(96168);
        return;
      }
      if (paramString.contains(o.INVALID_TAG))
      {
        this.sb.append("<![CDATA[" + Util.escapeStringForXml(paramString) + "]]>");
        AppMethodBeat.o(96168);
        return;
      }
      this.sb.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(96168);
    }
    
    public final void startTag(String paramString)
    {
      AppMethodBeat.i(96166);
      this.sb.append("<" + paramString + ">");
      AppMethodBeat.o(96166);
    }
    
    public final void startTag(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(96170);
      this.sb.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.sb.append(" " + str1 + "=\"" + str2 + "\" ");
      }
      this.sb.append(">");
      paramMap.clear();
      AppMethodBeat.o(96170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.o
 * JD-Core Version:    0.7.0.1
 */