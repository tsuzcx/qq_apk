package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static List<cyv> D(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      cyv localcyv = new cyv();
      localcyv.id = localJSONObject.optString("id", "");
      localcyv.dlQ = localJSONObject.optString("wording", "");
      localcyv.FIb = localJSONObject.optLong("category", 0L);
      localcyv.actionType = localJSONObject.optInt("actionType", 0);
      localcyv.url = localJSONObject.optString("url", "");
      localcyv.title = localJSONObject.optString("title", "");
      localcyv.mBH = localJSONObject.optString("subTitle", "");
      localcyv.drM = localJSONObject.optString("icon", "");
      localArrayList.add(localcyv);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final dil a(dil paramdil)
  {
    AppMethodBeat.i(90977);
    dil localdil = new dil();
    localdil.qox = paramdil.qox;
    localdil.scene = paramdil.scene;
    localdil.cZL = paramdil.cZL;
    localdil.jKB = paramdil.jKB;
    localdil.FRA = paramdil.FRA;
    localdil.FRz = paramdil.FRz;
    localdil.FRw = paramdil.FRw;
    localdil.FRx = paramdil.FRx;
    localdil.FRy = paramdil.FRy;
    localdil.FRv = paramdil.FRv;
    localdil.BYq.addAll(paramdil.BYq);
    localdil.ftN = paramdil.ftN;
    localdil.FRG = paramdil.FRG;
    localdil.FRH = paramdil.FRH;
    AppMethodBeat.o(90977);
    return localdil;
  }
  
  public static final dil a(dyo paramdyo, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    dil localdil = new dil();
    localdil.qox = UUID.randomUUID().toString();
    localdil.FRA = new dio();
    localdil.FRA.title = paramdyo.pBm;
    localdil.FRA.sxK = ("video-" + paramdyo.BYK);
    localdil.FRA.sVF = paramdyo.BYK;
    localdil.FRA.FRN = paramdyo.thumbUrl;
    if (bs.isNullOrNil(localdil.FRA.FRN)) {
      localdil.FRA.FRN = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramdyo.BYK + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localdil.FRA.BYS = paramdyo.BYS;
    localdil.FRA.source = paramdyo.source;
    localdil.FRA.kRU = paramdyo.kRU;
    localdil.FRA.FRQ = paramdyo.BYL;
    localdil.FRA.FRS = paramdyo.BYL;
    localdil.FRA.BYQ = paramdyo.BYQ;
    if (paramdyo.BYW == 100203L)
    {
      localdil.FRA.thumbWidth = 360;
      localdil.FRA.thumbHeight = 640;
    }
    for (;;)
    {
      localdil.FRA.timestamp = System.currentTimeMillis();
      if (!bs.isNullOrNil(paramdyo.BYV)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramdyo.BYV);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            cyv localcyv = new cyv();
            localcyv.id = localJSONObject.optString("id");
            localcyv.dlQ = localJSONObject.optString("wording");
            localcyv.FIb = localJSONObject.optLong("category");
            localcyv.actionType = localJSONObject.optInt("actionType");
            localcyv.url = localJSONObject.optString("url");
            localcyv.title = localJSONObject.optString("title");
            localcyv.mBH = localJSONObject.optString("subTitle");
            localcyv.drM = localJSONObject.optString("icon");
            localdil.FRA.sVE.add(localcyv);
            i += 1;
            continue;
            localdil.FRA.thumbWidth = 496;
            localdil.FRA.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localdil.FRv = paramdyo.BYK;
    localdil.FRw = paramdyo.BYL;
    localdil.FRx = paramdyo.BYM;
    localdil.FRy = paramdyo.BYN;
    localdil.FRz = paramdyo.BYW;
    if (localdil.FRz <= 0L) {
      localdil.FRz = 100201L;
    }
    localdil.FRC = false;
    if (!bs.isNullOrNil(paramdyo.BYU)) {
      q(localdil.BYq, paramdyo.BYU);
    }
    localdil.jKB = "";
    localdil.scene = paramInt;
    localdil.cZL = paramString;
    if (!bs.isNullOrNil(paramdyo.BYX))
    {
      localdil.FRB = new cyv();
      localdil.FRB.title = paramdyo.BYX;
    }
    AppMethodBeat.o(90974);
    return localdil;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    AppMethodBeat.i(90983);
    HashMap localHashMap = new HashMap();
    if (!bs.isNullOrNil(paramString4)) {
      localHashMap.put("redPointMsgId", paramString4);
    }
    if (!bs.isNullOrNil(paramString1)) {
      localHashMap.put("sessionId", paramString1);
    }
    if (!bs.isNullOrNil(paramString2)) {
      localHashMap.put("query", paramString2);
    }
    if (!bs.isNullOrNil(paramString3))
    {
      localHashMap.put("requestId", paramString3);
      localHashMap.put("pRequestId", paramString3);
      localHashMap.put("seq", paramString3);
    }
    if (!bs.isNullOrNil(paramString7)) {
      localHashMap.put("extParams", paramString7);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    if (!bs.isNullOrNil(paramString5)) {
      localHashMap.put("tabInfo", paramString5);
    }
    if (paramInt2 > 0) {
      localHashMap.put("contentReddot", String.valueOf(paramInt2));
    }
    if (paramInt3 > 0) {
      localHashMap.put("numberReddot", String.valueOf(paramInt3));
    }
    localHashMap.put("profile", "1");
    if (!bs.isNullOrNil(paramString6)) {
      localHashMap.put("homeMsgId", paramString6);
    }
    try
    {
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.DHY);
      paramString1 = l(localHashMap);
      AppMethodBeat.o(90983);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static final dil aK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    dil localdil = new dil();
    localdil.cZL = paramJSONObject.optString("query", "");
    localdil.scene = paramJSONObject.optInt("scene", 21);
    localdil.qox = UUID.randomUUID().toString();
    localdil.FRx = paramJSONObject.optString("searchId", "");
    if ((ax.isConnected(ai.getContext())) && (!ax.isWifi(ai.getContext()))) {
      localdil.FRC = true;
    }
    Object localObject2 = paramJSONObject.optString("videoId", "");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramJSONObject.optString("videoUrls", ""));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          diq localdiq = new diq();
          localdiq.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdiq);
          i += 1;
        }
      }
      if (bs.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localdil.FRA = new dio();
    localdil.FRA.title = paramJSONObject.optString("title", "");
    localdil.FRA.FRN = paramJSONObject.optString("thumbUrl", "");
    localdil.FRA.yBk = paramJSONObject.optInt("mediaDuration", 0);
    localdil.FRA.sVF = ((String)localObject2);
    localdil.FRA.BYS = paramJSONObject.optString("strPlayCount", "");
    localdil.FRA.pBl = paramJSONObject.optString("shareUrl", "");
    localdil.FRA.pBm = paramJSONObject.optString("shareTitle", "");
    localdil.FRA.BYT = paramJSONObject.optString("titleUrl", "");
    localdil.FRA.tcG = paramJSONObject.optString("shareDesc", "");
    localdil.FRA.BYP = paramJSONObject.optString("shareImgUrl", "");
    localdil.FRA.BYQ = paramJSONObject.optString("shareString", "");
    localdil.FRA.BYR = paramJSONObject.optString("shareStringUrl", "");
    localdil.FRA.source = paramJSONObject.optString("source", "");
    localdil.FRA.kRU = paramJSONObject.optString("sourceUrl", "");
    localdil.FRA.FRO = paramJSONObject.optInt("relevant_category", -1);
    localdil.FRA.FRP = paramJSONObject.optString("shareOpenId", "");
    localdil.FRA.sxK = paramJSONObject.optString("docID", "");
    localdil.FRA.FRV = paramJSONObject.optInt("videoSize", 0);
    localdil.FRA.timestamp = bs.Gn();
    localdil.FRA.FRR = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localdil.FRA.FRU = ((JSONObject)localObject2).optLong("resultType");
      localdil.FRA.cZM = ((JSONObject)localObject2).optLong("type");
      label578:
      localdil.FRA.FRQ = paramJSONObject.optString("expand", "");
      localdil.FRA.FRW.addAll((Collection)localObject1);
      localObject1 = gn((List)localObject1);
      if (localObject1 != null)
      {
        localdil.FRA.videoUrl = ((diq)localObject1).url;
        localdil.FRA.FSf = ((diq)localObject1).FSf;
      }
      if (bs.isNullOrNil(localdil.FRA.FRN)) {
        localdil.FRA.FRN = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdil.FRA.sVF + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bs.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdil.FRA.sVE.addAll(D((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localdil.FRA.FSe = new dim();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localdil.FRA.FSe.FRJ = ((JSONObject)localObject1).optString("detailWording");
            localdil.FRA.FSe.FRK = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new aij();
                ((aij)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((aij)localObject2).dlQ = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localdil.FRA.FSe.FRL.add(localObject2);
                i += 1;
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("show_tag_list", "");
        if (!bs.isNullOrNil((String)localObject1)) {}
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          localdil.FRA.sVE.addAll(D((JSONArray)localObject1));
          label963:
          localdil.FRz = localdil.FRA.FRO;
          localdil.FRw = paramJSONObject.optString("expand", "");
          localdil.jKB = "";
          localdil.FRv = localdil.FRA.sVF;
          localdil.FRA.FRX = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localdil.FRA;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((dio)localObject1).FSc = bool;
            localObject2 = localdil.FRA;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((dio)localObject2).FSd = ((String)localObject1);
            if (localdil.FRz != 100203L) {
              break label1419;
            }
            localdil.FRA.thumbWidth = 360;
          }
          for (localdil.FRA.thumbHeight = 640;; localdil.FRA.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localdil.FRA.FRZ = new dij();
                localdil.FRA.FRZ.FRp = ((JSONObject)localObject1).optInt("videoSecondType");
                localdil.FRA.FRZ.FRr = ((JSONObject)localObject1).optInt("requestDuration");
                localdil.FRA.FRZ.FRs = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!bs.isNullOrNil((String)localObject1)) && ((localdil.FRz == 100202L) || (localdil.FRz == 100204L) || (localdil.FRz == 100205L)))
              {
                localdil.FRB = new cyv();
                localdil.FRB.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (bs.isNullOrNil((String)localObject1)) {
                break;
              }
              label1413:
              label1419:
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                i = 0;
                while (i < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                  yh localyh = new yh();
                  localyh.key = ((JSONObject)localObject2).optString("key", "");
                  localyh.ErV = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localyh.ErW = ((JSONObject)localObject2).optString("textValue", "");
                  localdil.BYq.add(localyh);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localdil.FRA.thumbWidth = 496;
          }
          localdil.FRG = paramJSONObject.optString("preNetType", "");
          if (localdil.FRG.equals("wangka")) {
            localdil.FRH = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localdil;
            if ((localdil.FRG.equals("2g")) || (localdil.FRG.equals("3g")) || (localdil.FRG.equals("4g"))) {
              localdil.FRH = 2;
            } else {
              localdil.FRH = 0;
            }
          }
        }
        catch (JSONException localJSONException1)
        {
          break label963;
        }
      }
      catch (Exception localException2)
      {
        break label758;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label578;
    }
  }
  
  public static final dil aM(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    dil localdil = new dil();
    localdil.cZL = z.x(paramMap, "query");
    localdil.scene = z.d(paramMap, "scene", 21);
    localdil.qox = UUID.randomUUID().toString();
    localdil.jKB = z.x(paramMap, "searchId");
    if ((ax.isConnected(ai.getContext())) && (!ax.isWifi(ai.getContext()))) {
      localdil.FRC = true;
    }
    Object localObject2 = z.x(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(z.x(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          diq localdiq = new diq();
          localdiq.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdiq);
          i += 1;
        }
      }
      if (bs.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localdil.FRA = new dio();
    localdil.FRA.title = z.x(paramMap, "title");
    localdil.FRA.FRN = z.x(paramMap, "thumbUrl");
    localdil.FRA.yBk = z.d(paramMap, "mediaDuration", 0);
    localdil.FRA.sVF = ((String)localObject2);
    localdil.FRA.BYS = z.x(paramMap, "strPlayCount");
    localdil.FRA.pBl = z.x(paramMap, "shareUrl");
    localdil.FRA.pBm = z.x(paramMap, "shareTitle");
    localdil.FRA.BYT = z.x(paramMap, "titleUrl");
    localdil.FRA.tcG = z.x(paramMap, "shareDesc");
    localdil.FRA.BYP = z.x(paramMap, "shareImgUrl");
    localdil.FRA.BYQ = z.x(paramMap, "shareString");
    localdil.FRA.BYR = z.x(paramMap, "shareStringUrl");
    localdil.FRA.source = z.x(paramMap, "source");
    localdil.FRA.kRU = z.x(paramMap, "sourceUrl");
    localdil.FRA.FRO = z.a(paramMap, "relevant_category", -1L);
    localdil.FRA.FRP = z.x(paramMap, "shareOpenId");
    localdil.FRA.sxK = z.x(paramMap, "docID");
    localdil.FRA.FRV = z.a(paramMap, "videoSize", 0L);
    localdil.FRA.timestamp = bs.Gn();
    localdil.FRA.FRR = z.d(paramMap, "itemType", 0);
    localdil.FRA.FRX = z.d(paramMap, "switchFlag", 0);
    if (bs.isNullOrNil(localdil.FRA.FRN)) {
      localdil.FRA.FRN = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdil.FRA.sVF + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(z.x(paramMap, "block"));
      localdil.FRA.FRU = ((JSONObject)localObject2).optLong("resultType");
      localdil.FRA.cZM = ((JSONObject)localObject2).optLong("type");
      label602:
      localdil.FRA.FRQ = z.x(paramMap, "expand");
      localdil.FRA.FRW.addAll((Collection)localObject1);
      localObject1 = gn((List)localObject1);
      if (localObject1 != null)
      {
        localdil.FRA.videoUrl = ((diq)localObject1).url;
        localdil.FRA.FSf = ((diq)localObject1).FSf;
      }
      localObject1 = z.x(paramMap, "show_tag_list");
      if (!bs.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdil.FRA.sVE.addAll(D((JSONArray)localObject1));
        label709:
        localdil.FRz = localdil.FRA.FRO;
        localdil.FRw = z.x(paramMap, "expand");
        localdil.FRx = localdil.jKB;
        localdil.FRv = localdil.FRA.sVF;
        if (localdil.FRz == 100203L)
        {
          localdil.FRA.thumbWidth = 360;
          localdil.FRA.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = z.x(paramMap, "videoChannelTitle");
          if ((!bs.isNullOrNil(localdil.FRA.BYQ)) && ((localdil.FRz == 100202L) || (localdil.FRz == 100204L) || (localdil.FRz == 100205L)))
          {
            localdil.FRB = new cyv();
            localdil.FRB.title = ((String)localObject1);
          }
          paramMap = z.x(paramMap, "extReqParams");
          if (!bs.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new yh();
                ((yh)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((yh)localObject2).ErV = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((yh)localObject2).ErW = ((JSONObject)localObject1).optString("textValue", "");
                localdil.BYq.add(localObject2);
                i += 1;
                continue;
                localdil.FRA.thumbWidth = 496;
                localdil.FRA.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localdil;
      }
      catch (JSONException localJSONException1)
      {
        break label709;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label602;
    }
  }
  
  public static String axH(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = ai.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static String ecs()
  {
    AppMethodBeat.i(90978);
    String str = ai.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean ect()
  {
    AppMethodBeat.i(90980);
    if (1 >= ac.getLogLevel())
    {
      AppMethodBeat.o(90980);
      return true;
    }
    AppMethodBeat.o(90980);
    return false;
  }
  
  public static String ecu()
  {
    AppMethodBeat.i(90986);
    String str = b.apa().replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String ecv()
  {
    AppMethodBeat.i(90987);
    String str = b.apa().replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean ecw()
  {
    AppMethodBeat.i(90988);
    int i = ((a)g.ab(a.class)).dcN();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      ac.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(90988);
      return bool;
    }
  }
  
  public static String ecx()
  {
    AppMethodBeat.i(90989);
    if (ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(90989);
      return "wifi";
    }
    if (ecw())
    {
      AppMethodBeat.o(90989);
      return "wangka";
    }
    if (ax.is4G(ai.getContext()))
    {
      AppMethodBeat.o(90989);
      return "4g";
    }
    if (ax.is3G(ai.getContext()))
    {
      AppMethodBeat.o(90989);
      return "3g";
    }
    if (ax.is2G(ai.getContext()))
    {
      AppMethodBeat.o(90989);
      return "2g";
    }
    if (!ax.isConnected(ai.getContext()))
    {
      AppMethodBeat.o(90989);
      return "fail";
    }
    AppMethodBeat.o(90989);
    return "";
  }
  
  public static final diq gn(List<diq> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      diq localdiq = (diq)paramList.next();
      if ((localdiq != null) && (!bs.isNullOrNil(localdiq.url)))
      {
        AppMethodBeat.o(90973);
        return localdiq;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray go(List<cyv> paramList)
  {
    AppMethodBeat.i(90981);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        cyv localcyv = (cyv)paramList.get(i);
        localJSONObject.put("id", localcyv.id);
        localJSONObject.put("wording", localcyv.dlQ);
        localJSONObject.put("category", localcyv.FIb);
        localJSONObject.put("actionType", localcyv.actionType);
        localJSONObject.put("url", localcyv.url);
        localJSONObject.put("title", localcyv.title);
        localJSONObject.put("subTitle", localcyv.mBH);
        localJSONObject.put("icon", localcyv.drM);
        localJSONArray.put(localJSONObject);
        label148:
        i += 1;
        continue;
        AppMethodBeat.o(90981);
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label148;
      }
    }
  }
  
  private static void h(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90985);
    paramHashMap.put("lang", ab.iC(ai.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(z.Uj(1).aEh()));
    paramHashMap.put("netType", z.dkv());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", com.tencent.mm.sdk.platformtools.h.gMJ);
    AppMethodBeat.o(90985);
  }
  
  public static String l(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    h(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(z.Uj(1).exF());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(z.aW(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  public static final void q(List<yh> paramList, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(90990);
    if (!bs.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          yh localyh = new yh();
          localyh.key = localJSONObject.optString("key", "");
          localyh.ErV = localJSONObject.optInt("uintValue", 0);
          localyh.ErW = localJSONObject.optString("textValue", "");
          paramList.add(localyh);
          i += 1;
        }
        AppMethodBeat.o(90990);
        return;
      }
      catch (Exception paramList) {}
    }
    AppMethodBeat.o(90990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */