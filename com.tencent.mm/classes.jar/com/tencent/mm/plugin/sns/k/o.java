package com.tencent.mm.plugin.sns.k;

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
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.protocal.protobuf.gom;
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
  public static String uWA = "<TimelineObject>";
  public static String uWB = "</TimelineObject>";
  
  public static String e(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(96172);
    a locala = new a();
    Object localObject1 = new HashMap();
    locala.startTag("TimelineObject");
    locala.startTag("id");
    Object localObject2;
    label2355:
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
        locala.setText(filterNull(paramTimeLineObject.AppInfo.IKJ));
        locala.endTag("appName");
        locala.startTag("installUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.YHb));
        locala.endTag("installUrl");
        locala.startTag("fromUrl");
        locala.setText(filterNull(paramTimeLineObject.AppInfo.YHc));
        locala.endTag("fromUrl");
        locala.endTag("appInfo");
      }
      if ((paramTimeLineObject.streamvideo != null) && (!Util.isNullOrNil(paramTimeLineObject.streamvideo.nTu)))
      {
        locala.startTag("streamvideo");
        locala.startTag("streamvideourl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTu));
        locala.endTag("streamvideourl");
        locala.startTag("streamvideototaltime");
        locala.setText(paramTimeLineObject.streamvideo.nTv);
        locala.endTag("streamvideototaltime");
        locala.startTag("streamvideotitle");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTw));
        locala.endTag("streamvideotitle");
        locala.startTag("streamvideowording");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTx));
        locala.endTag("streamvideowording");
        locala.startTag("streamvideoweburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTy));
        locala.endTag("streamvideoweburl");
        locala.startTag("streamvideothumburl");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTz));
        locala.endTag("streamvideothumburl");
        locala.startTag("streamvideoaduxinfo");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTA));
        locala.endTag("streamvideoaduxinfo");
        locala.startTag("streamvideopublishid");
        locala.setText(filterNull(paramTimeLineObject.streamvideo.nTB));
        locala.endTag("streamvideopublishid");
        locala.endTag("streamvideo");
      }
      if ((paramTimeLineObject.webSearchInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.webSearchInfo.WoZ)))
      {
        locala.startTag("websearch");
        locala.startTag("relevant_vid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.WoZ));
        locala.endTag("relevant_vid");
        locala.startTag("relevant_expand");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpa));
        locala.endTag("relevant_expand");
        locala.startTag("relevant_pre_searchid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpb));
        locala.endTag("relevant_pre_searchid");
        locala.startTag("relevant_shared_openid");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpc));
        locala.endTag("relevant_shared_openid");
        locala.startTag("rec_category");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpd));
        locala.endTag("rec_category");
        locala.startTag("shareUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.ytZ));
        locala.endTag("shareUrl");
        locala.startTag("shareTitle");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.svG));
        locala.endTag("shareTitle");
        locala.startTag("shareDesc");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.ICb));
        locala.endTag("shareDesc");
        locala.startTag("shareImgUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpe));
        locala.endTag("shareImgUrl");
        locala.startTag("shareString");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpf));
        locala.endTag("shareString");
        locala.startTag("shareStringUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpg));
        locala.endTag("shareStringUrl");
        locala.startTag("source");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.source));
        locala.endTag("source");
        locala.startTag("strPlayCount");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wph));
        locala.endTag("strPlayCount");
        locala.startTag("titleUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpi));
        locala.endTag("titleUrl");
        locala.startTag("extReqParams");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpj));
        locala.endTag("extReqParams");
        locala.startTag("tagList");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpk));
        locala.endTag("tagList");
        locala.startTag("channelId");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpl));
        locala.endTag("channelId");
        locala.startTag("thumbUrl");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.thumbUrl));
        locala.endTag("thumbUrl");
        locala.startTag("shareTag");
        locala.setText(filterNull(paramTimeLineObject.webSearchInfo.Wpm));
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
      locala.setText(filterNull(paramTimeLineObject.weappInfo.tgv));
      locala.endTag("debugMode");
      locala.startTag("shareActionId");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.hzD));
      locala.endTag("shareActionId");
      locala.startTag("isGame");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.accE));
      locala.endTag("isGame");
      locala.startTag("messageExtraData");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.idf));
      locala.endTag("messageExtraData");
      locala.startTag("subType");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.subType));
      locala.endTag("subType");
      locala.startTag("preloadResources");
      locala.setText(filterNull(paramTimeLineObject.weappInfo.accF));
      locala.endTag("preloadResources");
      locala.endTag("weappInfo");
      locala.startTag("canvasInfoXml");
      locala.setText(filterNull(paramTimeLineObject.canvasInfo));
      locala.endTag("canvasInfoXml");
      if (paramTimeLineObject.Location != null)
      {
        float f1 = paramTimeLineObject.Location.ZaG;
        float f2 = paramTimeLineObject.Location.ZaH;
        if ((f1 != -1000.0F) && (f2 != -1000.0F))
        {
          ((Map)localObject1).clear();
          ((Map)localObject1).put("longitude", paramTimeLineObject.Location.ZaG);
          ((Map)localObject1).put("latitude", paramTimeLineObject.Location.ZaH);
          ((Map)localObject1).put("city", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.pSh)));
          ((Map)localObject1).put("poiName", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.poiName)));
          ((Map)localObject1).put("poiAddress", Util.escapeStringForXml(filterNull(paramTimeLineObject.Location.ReU)));
          ((Map)localObject1).put("poiScale", paramTimeLineObject.Location.aaPN);
          ((Map)localObject1).put("poiClassifyId", filterNull(paramTimeLineObject.Location.ZWG));
          ((Map)localObject1).put("poiClassifyType", paramTimeLineObject.Location.ReW);
          ((Map)localObject1).put("poiClickableStatus", paramTimeLineObject.Location.aaPO);
          locala.startTag("location", (Map)localObject1);
          locala.endTag("location");
        }
      }
      locala.startTag("ContentObject");
      locala.startTag("contentStyle");
      locala.setText(paramTimeLineObject.ContentObj.Zpq);
      locala.endTag("contentStyle");
      locala.startTag("contentSubStyle");
      locala.setText(paramTimeLineObject.ContentObj.Zps);
      locala.endTag("contentSubStyle");
      locala.startTag("title");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.hAP));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.IGG));
      locala.endTag("description");
      locala.startTag("contentUrl");
      locala.setText(filterNull(paramTimeLineObject.ContentObj.Url));
      locala.endTag("contentUrl");
      if (paramTimeLineObject.ContentObj.Zpr.size() <= 0) {
        break label3317;
      }
      locala.startTag("mediaList");
      localObject2 = paramTimeLineObject.ContentObj.Zpr.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label3309;
      }
      localObject3 = (dmz)((Iterator)localObject2).next();
      locala.startTag("media");
      locala.startTag("id");
      if (!filterId(((dmz)localObject3).Id).equals("")) {
        break label3293;
      }
      locala.setText("0");
    }
    for (;;)
    {
      locala.endTag("id");
      locala.startTag("type");
      locala.setText(((dmz)localObject3).vhJ);
      locala.endTag("type");
      locala.startTag("title");
      locala.setText(filterNull(((dmz)localObject3).hAP));
      locala.endTag("title");
      locala.startTag("description");
      locala.setText(filterNull(((dmz)localObject3).IGG));
      locala.endTag("description");
      locala.startTag("private");
      locala.setText(((dmz)localObject3).Privated);
      locala.endTag("private");
      if (!Util.isNullOrNil(((dmz)localObject3).songAlbumUrl))
      {
        locala.startTag("songalbumurl");
        locala.setText(((dmz)localObject3).songAlbumUrl);
        locala.endTag("songalbumurl");
      }
      if (!Util.isNullOrNil(((dmz)localObject3).songLyric))
      {
        locala.startTag("songlyric");
        locala.setText(((dmz)localObject3).songLyric);
        locala.endTag("songlyric");
      }
      ((Map)localObject1).clear();
      ((Map)localObject1).put("type", ((dmz)localObject3).aazR);
      if (!Util.isNullOrNil(((dmz)localObject3).md5)) {
        ((Map)localObject1).put("md5", ((dmz)localObject3).md5);
      }
      if (!Util.isNullOrNil(((dmz)localObject3).aaTE)) {
        ((Map)localObject1).put("videomd5", ((dmz)localObject3).aaTE);
      }
      locala.startTag("url", (Map)localObject1);
      locala.setText(filterNull(((dmz)localObject3).Url));
      locala.endTag("url");
      if ((((dmz)localObject3).aaTl != null) && (!((dmz)localObject3).aaTl.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((dmz)localObject3).aaTm);
        locala.startTag("thumb", (Map)localObject1);
        locala.setText(filterNull(((dmz)localObject3).aaTl));
        locala.endTag("thumb");
      }
      locala.startTag("videoDuration");
      locala.setText(((dmz)localObject3).aaTF);
      locala.endTag("videoDuration");
      if (((dmz)localObject3).subType > 0)
      {
        locala.startTag("subType");
        locala.setText(((dmz)localObject3).subType);
        locala.endTag("subType");
      }
      if (!Util.isNullOrNil(((dmz)localObject3).RcB))
      {
        locala.startTag("userData");
        locala.setText(((dmz)localObject3).RcB);
        locala.endTag("userData");
      }
      if ((((dmz)localObject3).aaTo != null) && (!((dmz)localObject3).aaTo.equals("")))
      {
        ((Map)localObject1).clear();
        ((Map)localObject1).put("type", ((dmz)localObject3).aaTp);
        locala.startTag("lowBandUrl", (Map)localObject1);
        locala.setText(filterNull(((dmz)localObject3).aaTo));
        locala.endTag("lowBandUrl");
      }
      if (((dmz)localObject3).aaTn != null)
      {
        ((Map)localObject1).clear();
        if (((dmz)localObject3).aaTn.aaUb > 0.0F) {
          ((Map)localObject1).put("width", ((dmz)localObject3).aaTn.aaUb);
        }
        if (((dmz)localObject3).aaTn.aaUc > 0.0F) {
          ((Map)localObject1).put("height", ((dmz)localObject3).aaTn.aaUc);
        }
        if (((dmz)localObject3).aaTn.aaUd > 0.0F) {
          ((Map)localObject1).put("totalSize", ((dmz)localObject3).aaTn.aaUd);
        }
        locala.startTag("size", (Map)localObject1);
        locala.endTag("size");
      }
      locala.endTag("media");
      break label2355;
      locala.setText(paramTimeLineObject.Id);
      break;
      label3293:
      locala.setText(filterId(((dmz)localObject3).Id));
    }
    label3309:
    locala.endTag("mediaList");
    label3317:
    locala.sb.append(filterNull(paramTimeLineObject.ContentObj.Zpt));
    if ((paramTimeLineObject.ContentObj.Zpu != null) && (paramTimeLineObject.ContentObj.Zpu.nUA != -1))
    {
      locala.startTag("mmreadershare");
      locala.startTag("itemshowtype");
      locala.setText(paramTimeLineObject.ContentObj.Zpu.nUA);
      locala.endTag("itemshowtype");
      locala.startTag("ispaysubscribe");
      locala.setText(paramTimeLineObject.ContentObj.Zpu.nQp);
      locala.endTag("ispaysubscribe");
      if ((paramTimeLineObject.ContentObj.Zpu.nUA == 5) || (paramTimeLineObject.ContentObj.Zpu.nUA == 16))
      {
        locala.startTag("pubtime");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.nQn);
        locala.endTag("pubtime");
        locala.startTag("vid");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.vid);
        locala.endTag("vid");
        locala.startTag("funcflag");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.nQq);
        locala.endTag("funcflag");
        locala.startTag("duration");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.duration);
        locala.endTag("duration");
        locala.startTag("digest");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.desc);
        locala.endTag("digest");
        locala.startTag("cover");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.coverUrl);
        locala.endTag("cover");
        if (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpu.vid))
        {
          locala.startTag("nativepage");
          locala.setText(1);
          locala.endTag("nativepage");
        }
        locala.startTag("width");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.videoWidth);
        locala.endTag("width");
        locala.startTag("height");
        locala.setText(paramTimeLineObject.ContentObj.Zpu.videoHeight);
        locala.endTag("height");
      }
      locala.endTag("mmreadershare");
    }
    if (paramTimeLineObject.ContentObj.hKU != null)
    {
      localObject1 = new e();
      ((e)localObject1).oUc = paramTimeLineObject.ContentObj.hKU;
      locala.append(q.d(((e)localObject1).oUc));
    }
    if (paramTimeLineObject.ContentObj.oPb != null)
    {
      localObject1 = new j();
      ((j)localObject1).oUg = paramTimeLineObject.ContentObj.oPb;
      locala.append(cq.a(((j)localObject1).oUg));
    }
    if (paramTimeLineObject.ContentObj.Zpy != null)
    {
      localObject1 = new h();
      ((h)localObject1).oUe = paramTimeLineObject.ContentObj.Zpy;
      locala.append(q.b(((h)localObject1).oUe));
    }
    if (paramTimeLineObject.ContentObj.Zpv != null)
    {
      localObject1 = new g();
      ((g)localObject1).oTZ = paramTimeLineObject.ContentObj.Zpv;
      locala.append(q.a(((g)localObject1).oTZ));
    }
    if (paramTimeLineObject.ContentObj.Zpz != null)
    {
      localObject1 = new b();
      ((b)localObject1).oTZ = paramTimeLineObject.ContentObj.Zpz;
      locala.append(((b)localObject1).bMC());
    }
    if (paramTimeLineObject.ContentObj.Zpw != null)
    {
      localObject1 = new i();
      ((i)localObject1).oUf = paramTimeLineObject.ContentObj.Zpw;
      locala.append(i.b(((i)localObject1).oUf));
    }
    if (paramTimeLineObject.ContentObj.DHa != null)
    {
      localObject1 = new d();
      ((d)localObject1).a(paramTimeLineObject.ContentObj.DHa);
      locala.append(((d)localObject1).bMC());
    }
    if (paramTimeLineObject.ContentObj.Zpx != null)
    {
      localObject1 = new c();
      ((c)localObject1).oUa = paramTimeLineObject.ContentObj.Zpx;
      locala.append(q.a(((c)localObject1).oUa));
    }
    if (paramTimeLineObject.ContentObj.ZpA != null)
    {
      localObject1 = new f();
      ((f)localObject1).oUd = paramTimeLineObject.ContentObj.ZpA;
      locala.append(((f)localObject1).bMC());
    }
    int i;
    if (paramTimeLineObject.ContentObj.akiL != null)
    {
      localObject1 = paramTimeLineObject.ContentObj.akiL;
      locala.startTag("Tiger2022");
      locala.startTag("EnterLiveMode");
      locala.setText(((gom)localObject1).aklr);
      locala.endTag("EnterLiveMode");
      locala.startTag("LinkEnabled");
      if (!((gom)localObject1).aklp) {
        break label5021;
      }
      i = 1;
    }
    for (;;)
    {
      locala.setText(i);
      locala.endTag("LinkEnabled");
      if (((gom)localObject1).aklq != null)
      {
        localObject2 = new d();
        ((d)localObject2).a(((gom)localObject1).aklq);
        locala.append(((d)localObject2).bMC());
      }
      locala.endTag("Tiger2022");
      locala.endTag("ContentObject");
      if (paramTimeLineObject.actionInfo != null)
      {
        locala.startTag("actionInfo");
        if (paramTimeLineObject.actionInfo.YCC != null)
        {
          locala.startTag("appMsg");
          locala.startTag("mediaTagName");
          locala.setText(paramTimeLineObject.actionInfo.YCC.YCm);
          locala.endTag("mediaTagName");
          locala.startTag("messageExt");
          locala.setText(paramTimeLineObject.actionInfo.YCC.YCn);
          locala.endTag("messageExt");
          locala.startTag("messageAction");
          locala.setText(paramTimeLineObject.actionInfo.YCC.YCo);
          locala.endTag("messageAction");
          locala.endTag("appMsg");
        }
        locala.endTag("actionInfo");
      }
      if ((paramTimeLineObject.AppInfo != null) && (!Util.isNullOrNil(paramTimeLineObject.AppInfo.Id)))
      {
        localObject1 = paramTimeLineObject.statExtStr;
        localObject2 = new fhn();
        if (localObject1 != null) {
          localObject3 = Base64.decode((String)localObject1, 0);
        }
      }
      try
      {
        ((fhn)localObject2).parseFrom((byte[])localObject3);
        label4476:
        ((fhn)localObject2).abIe = new fhl();
        ((fhn)localObject2).abIe.ICZ = paramTimeLineObject.AppInfo.Id;
        try
        {
          localObject2 = Base64.encodeToString(((fhn)localObject2).toByteArray(), 0);
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
        if ((paramTimeLineObject.videoTemplate != null) && (!Util.isNullOrNil(paramTimeLineObject.videoTemplate.nSg)))
        {
          locala.startTag("VideoTemplate");
          if (paramTimeLineObject.videoTemplate.type != null)
          {
            locala.startTag("Type");
            locala.setText(paramTimeLineObject.videoTemplate.type);
            locala.endTag("Type");
          }
          if (paramTimeLineObject.videoTemplate.nSg != null)
          {
            locala.startTag("TemplateId");
            locala.setText(paramTimeLineObject.videoTemplate.nSg);
            locala.endTag("TemplateId");
          }
          if (paramTimeLineObject.videoTemplate.musicId != null)
          {
            locala.startTag("MusicId");
            locala.setText(paramTimeLineObject.videoTemplate.musicId);
            locala.endTag("MusicId");
          }
          locala.startTag("VersionInfo");
          locala.startTag("IosSdkVersionMin");
          locala.setText(paramTimeLineObject.videoTemplate.abFS);
          locala.endTag("IosSdkVersionMin");
          locala.startTag("AndroidSdkVersionMin");
          locala.setText(paramTimeLineObject.videoTemplate.abFR);
          locala.endTag("AndroidSdkVersionMin");
          locala.endTag("VersionInfo");
          locala.endTag("VideoTemplate");
        }
        locala.endTag("TimelineObject");
        paramTimeLineObject = locala.sb.toString();
        Log.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(paramTimeLineObject)));
        if (XmlParser.parseXml(paramTimeLineObject, "TimelineObject", null) == null)
        {
          Log.e("MicroMsg.TimelineConvert", "xml is error");
          AppMethodBeat.o(96172);
          return "";
          label5021:
          i = 0;
        }
      }
      catch (Exception localException)
      {
        break label4476;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.o
 * JD-Core Version:    0.7.0.1
 */