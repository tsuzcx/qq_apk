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
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.fat;
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
  public static String oJw = "<TimelineObject>";
  public static String oJx = "</TimelineObject>";
  
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
        locala.setText(filterNull(paramTimeLineObject.AppInfo.xMq));
        locala.endTag("appName");
        locala.startTag("installUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.KIq));
        locala.endTag("installUrl");
        locala.startTag("fromUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.KIr));
        locala.endTag("fromUrl");
        locala.endTag("appInfo");
      }
      if ((paramTimeLineObject.streamvideo != null) && (!Util.isNullOrNil(paramTimeLineObject.streamvideo.iyZ)))
      {
        locala.startTag("streamvideo");
        locala.startTag("streamvideourl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.iyZ));
        locala.endTag("streamvideourl");
        locala.startTag("streamvideototaltime");
        locala.setText(paramTimeLineObject.streamvideo.iza);
        locala.endTag("streamvideototaltime");
        locala.startTag("streamvideotitle");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.izb));
        locala.endTag("streamvideotitle");
        locala.startTag("streamvideowording");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.izc));
        locala.endTag("streamvideowording");
        locala.startTag("streamvideoweburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.izd));
        locala.endTag("streamvideoweburl");
        locala.startTag("streamvideothumburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.ize));
        locala.endTag("streamvideothumburl");
        locala.startTag("streamvideoaduxinfo");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.izf));
        locala.endTag("streamvideoaduxinfo");
        locala.startTag("streamvideopublishid");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.izg));
        locala.endTag("streamvideopublishid");
        locala.endTag("streamvideo");
      }
      if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.IEy)))
      {
        locala.startTag("websearch");
        locala.startTag("relevant_vid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEy));
        locala.endTag("relevant_vid");
        locala.startTag("relevant_expand");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEz));
        locala.endTag("relevant_expand");
        locala.startTag("relevant_pre_searchid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEA));
        locala.endTag("relevant_pre_searchid");
        locala.startTag("relevant_shared_openid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEB));
        locala.endTag("relevant_shared_openid");
        locala.startTag("rec_category");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEC));
        locala.endTag("rec_category");
        locala.startTag("shareUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.rCq));
        locala.endTag("shareUrl");
        locala.startTag("shareTitle");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.msN));
        locala.endTag("shareTitle");
        locala.startTag("shareDesc");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.xDQ));
        locala.endTag("shareDesc");
        locala.startTag("shareImgUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IED));
        locala.endTag("shareImgUrl");
        locala.startTag("shareString");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEE));
        locala.endTag("shareString");
        locala.startTag("shareStringUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEF));
        locala.endTag("shareStringUrl");
        locala.startTag("source");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.source));
        locala.endTag("source");
        locala.startTag("strPlayCount");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEG));
        locala.endTag("strPlayCount");
        locala.startTag("titleUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEH));
        locala.endTag("titleUrl");
        locala.startTag("extReqParams");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEI));
        locala.endTag("extReqParams");
        locala.startTag("tagList");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEJ));
        locala.endTag("tagList");
        locala.startTag("channelId");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEK));
        locala.endTag("channelId");
        locala.startTag("thumbUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.thumbUrl));
        locala.endTag("thumbUrl");
        locala.startTag("shareTag");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.IEL));
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
      locala.setText(filterNull(paramTimeLineObject.weappInfo.nbf));
      locala.endTag("debugMode");
      locala.startTag("shareActionId");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.dCC));
      locala.endTag("shareActionId");
      locala.startTag("isGame");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.isGame));
      locala.endTag("isGame");
      locala.startTag("messageExtraData");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.eda));
      locala.endTag("messageExtraData");
      locala.startTag("subType");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.subType));
      locala.endTag("subType");
      locala.startTag("preloadResources");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.Nvm));
      locala.endTag("preloadResources");
      locala.endTag("weappInfo");
      locala.startTag("canvasInfoXml");
      locala.setText(filterNull(paramTimeLineObject.canvasInfo));
      locala.endTag("canvasInfoXml");
      if (paramTimeLineObject.Location != null)
      {
        float f1 = paramTimeLineObject.Location.LbC;
        float f2 = paramTimeLineObject.Location.LbD;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.Location.LbC);
          ((Map)localObject1).put("latitude", paramTimeLineObject.Location.LbD);
          ((Map)localObject1).put("city", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.kea)));
          ((Map)localObject1).put("poiName", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.kHV)));
          ((Map)localObject1).put("poiAddress", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.ErZ)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.Location.Mpu);
          ((Map)localObject1).put("poiClassifyId", filterNull(paramTimeLineObject.Location.LIb));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.Location.Esb);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.Location.Mpv);
          locala.startTag("location", (Map)localObject1);
          locala.endTag("location");
        }
      }
      locala.startTag("ContentObject");
      locala.startTag("contentStyle");
      locala.setText(paramTimeLineObject.ContentObj.LoU);
      locala.endTag("contentStyle");
      locala.startTag("contentSubStyle");
      locala.setText(paramTimeLineObject.ContentObj.LoW);
      locala.endTag("contentSubStyle");
      locala.startTag("title");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.Title));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.Desc));
      locala.endTag("description");
      locala.startTag("contentUrl");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.Url));
      locala.endTag("contentUrl");
      if (paramTimeLineObject.ContentObj.LoV.size() <= 0) {
        break label3289;
      }
      locala.startTag("mediaList");
      localObject2 = paramTimeLineObject.ContentObj.LoV.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3281;
      }
      localObject3 = (cnb)((Iterator)localObject2).next();
      locala.startTag("media");
      locala.startTag("id");
      if (!filterId(((cnb)localObject3).Id).equals("")) {
        break label3265;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.endTag("id");
      locala.startTag("type");
      locala.setText(((cnb)localObject3).oUv);
      locala.endTag("type");
      locala.startTag("title");
      locala.setText(filterNull(((cnb)localObject3).Title));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(((cnb)localObject3).Desc));
      locala.endTag("description");
      locala.startTag("private");
      locala.setText(((cnb)localObject3).Privated);
      locala.endTag("private");
      if (!Util.isNullOrNil(((cnb)localObject3).songAlbumUrl))
      {
        locala.startTag("songalbumurl");
        locala.setText(((cnb)localObject3).songAlbumUrl);
        locala.endTag("songalbumurl");
      }
      if (!Util.isNullOrNil(((cnb)localObject3).songLyric))
      {
        locala.startTag("songlyric");
        locala.setText(((cnb)localObject3).songLyric);
        locala.endTag("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((cnb)localObject3).Mcw);
      if (!Util.isNullOrNil(((cnb)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((cnb)localObject3).md5);
      }
      if (!Util.isNullOrNil(((cnb)localObject3).MsS)) {
        ((Map)localObject1).put("videomd5", ((cnb)localObject3).MsS);
      }
      locala.startTag("url", (Map)localObject1);
      locala.setText(filterNull(((cnb)localObject3).Url));
      locala.endTag("url");
      if ((((cnb)localObject3).Msz != null) && (!((cnb)localObject3).Msz.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((cnb)localObject3).MsA);
        locala.startTag("thumb", (Map)localObject1);
        locala.setText(filterNull(((cnb)localObject3).Msz));
        locala.endTag("thumb");
      }
      locala.startTag("videoDuration");
      locala.setText(((cnb)localObject3).MsT);
      locala.endTag("videoDuration");
      if (((cnb)localObject3).subType > 0)
      {
        locala.startTag("subType");
        locala.setText(((cnb)localObject3).subType);
        locala.endTag("subType");
      }
      if (!Util.isNullOrNil(((cnb)localObject3).EpK))
      {
        locala.startTag("userData");
        locala.setText(((cnb)localObject3).EpK);
        locala.endTag("userData");
      }
      if ((((cnb)localObject3).MsC != null) && (!((cnb)localObject3).MsC.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((cnb)localObject3).MsD);
        locala.startTag("lowBandUrl", (Map)localObject1);
        locala.setText(filterNull(((cnb)localObject3).MsC));
        locala.endTag("lowBandUrl");
      }
      if (((cnb)localObject3).MsB != null)
      {
        ((Map)localObject1).clear();
        if (((cnb)localObject3).MsB.Mto > 0.0F) {
          ((Map)localObject1).put("width", ((cnb)localObject3).MsB.Mto);
        }
        if (((cnb)localObject3).MsB.Mtp > 0.0F) {
          ((Map)localObject1).put("height", ((cnb)localObject3).MsB.Mtp);
        }
        if (((cnb)localObject3).MsB.Mtq > 0.0F) {
          ((Map)localObject1).put("totalSize", ((cnb)localObject3).MsB.Mtq);
        }
        locala.startTag("size", (Map)localObject1);
        locala.endTag("size");
      }
      locala.endTag("media");
      break label2343;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3265:
      locala.setText(filterId(((cnb)localObject3).Id));
    }
    label3281:
    locala.endTag("mediaList");
    label3289:
    locala.sb.append(filterNull(paramTimeLineObject.ContentObj.LoX));
    if ((paramTimeLineObject.ContentObj.LoY != null) && (paramTimeLineObject.ContentObj.LoY.iAb != -1))
    {
      locala.startTag("mmreadershare");
      locala.startTag("itemshowtype");
      locala.setText(paramTimeLineObject.ContentObj.LoY.iAb);
      locala.endTag("itemshowtype");
      locala.startTag("ispaysubscribe");
      locala.setText(paramTimeLineObject.ContentObj.LoY.iwf);
      locala.endTag("ispaysubscribe");
      if (paramTimeLineObject.ContentObj.LoY.iAb == 5)
      {
        locala.startTag("pubtime");
        locala.setText(paramTimeLineObject.ContentObj.LoY.iwd);
        locala.endTag("pubtime");
        locala.startTag("vid");
        locala.setText(paramTimeLineObject.ContentObj.LoY.vid);
        locala.endTag("vid");
        locala.startTag("funcflag");
        locala.setText(paramTimeLineObject.ContentObj.LoY.iwg);
        locala.endTag("funcflag");
        locala.startTag("duration");
        locala.setText(paramTimeLineObject.ContentObj.LoY.duration);
        locala.endTag("duration");
        locala.startTag("digest");
        locala.setText(paramTimeLineObject.ContentObj.LoY.desc);
        locala.endTag("digest");
        locala.startTag("cover");
        locala.setText(paramTimeLineObject.ContentObj.LoY.coverUrl);
        locala.endTag("cover");
        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.LoY.vid))
        {
          locala.startTag("nativepage");
          locala.setText(1);
          locala.endTag("nativepage");
        }
        locala.startTag("width");
        locala.setText(paramTimeLineObject.ContentObj.LoY.videoWidth);
        locala.endTag("width");
        locala.startTag("height");
        locala.setText(paramTimeLineObject.ContentObj.LoY.videoHeight);
        locala.endTag("height");
      }
      locala.endTag("mmreadershare");
    }
    if (paramTimeLineObject.ContentObj.dME != null)
    {
      localObject1 = new e();
      ((e)localObject1).jlg = paramTimeLineObject.ContentObj.dME;
      locala.append(l.b(((e)localObject1).jlg));
    }
    if (paramTimeLineObject.ContentObj.jfy != null)
    {
      localObject1 = new i();
      ((i)localObject1).jlj = paramTimeLineObject.ContentObj.jfy;
      locala.append(ak.a(((i)localObject1).jlj));
    }
    if (paramTimeLineObject.ContentObj.Lpd != null)
    {
      localObject1 = new g();
      ((g)localObject1).jlh = paramTimeLineObject.ContentObj.Lpd;
      locala.append(l.a(((g)localObject1).jlh));
    }
    if (paramTimeLineObject.ContentObj.LoZ != null)
    {
      localObject1 = new f();
      ((f)localObject1).jld = paramTimeLineObject.ContentObj.LoZ;
      locala.append(l.b(((f)localObject1).jld));
    }
    if (paramTimeLineObject.ContentObj.Lpe != null)
    {
      localObject1 = new b();
      ((b)localObject1).jld = paramTimeLineObject.ContentObj.Lpe;
      locala.append(((b)localObject1).bfF());
    }
    if (paramTimeLineObject.ContentObj.Lpa != null)
    {
      localObject1 = new h();
      ((h)localObject1).jli = paramTimeLineObject.ContentObj.Lpa;
      locala.append(h.b(((h)localObject1).jli));
    }
    if (paramTimeLineObject.ContentObj.Lpc != null)
    {
      localObject1 = new d();
      ((d)localObject1).a(paramTimeLineObject.ContentObj.Lpc);
      locala.append(((d)localObject1).bfF());
    }
    if (paramTimeLineObject.ContentObj.Lpb != null)
    {
      localObject1 = new c();
      ((c)localObject1).jle = paramTimeLineObject.ContentObj.Lpb;
      locala.append(l.a(((c)localObject1).jle));
    }
    locala.endTag("ContentObject");
    if (paramTimeLineObject.actionInfo != null)
    {
      locala.startTag("actionInfo");
      if (paramTimeLineObject.actionInfo.KEw != null)
      {
        locala.startTag("appMsg");
        locala.startTag("mediaTagName");
        locala.setText(paramTimeLineObject.actionInfo.KEw.KEq);
        locala.endTag("mediaTagName");
        locala.startTag("messageExt");
        locala.setText(paramTimeLineObject.actionInfo.KEw.KEr);
        locala.endTag("messageExt");
        locala.startTag("messageAction");
        locala.setText(paramTimeLineObject.actionInfo.KEw.KEs);
        locala.endTag("messageAction");
        locala.endTag("appMsg");
      }
      locala.endTag("actionInfo");
    }
    if ((paramTimeLineObject.AppInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.AppInfo.Id)))
    {
      localObject1 = paramTimeLineObject.statExtStr;
      localObject2 = new eco();
      if (localObject1 != null) {
        localObject3 = Base64.decode((String)localObject1, 0);
      }
    }
    try
    {
      ((eco)localObject2).parseFrom((byte[])localObject3);
      label4235:
      ((eco)localObject2).NcJ = new ecm();
      ((eco)localObject2).NcJ.xEN = paramTimeLineObject.AppInfo.Id;
      try
      {
        localObject2 = Base64.encodeToString(((eco)localObject2).toByteArray(), 0);
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
      break label4235;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.o
 * JD-Core Version:    0.7.0.1
 */