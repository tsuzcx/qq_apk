package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.est;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esw;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static List<eij> K(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      eij localeij = new eij();
      localeij.id = localJSONObject.optString("id", "");
      localeij.wording = localJSONObject.optString("wording", "");
      localeij.Ukr = localJSONObject.optLong("category", 0L);
      localeij.actionType = localJSONObject.optInt("actionType", 0);
      localeij.url = localJSONObject.optString("url", "");
      localeij.title = localJSONObject.optString("title", "");
      localeij.rsw = localJSONObject.optString("subTitle", "");
      localeij.icon = localJSONObject.optString("icon", "");
      localArrayList.add(localeij);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final esv a(esv paramesv)
  {
    AppMethodBeat.i(90977);
    esv localesv = new esv();
    localesv.wmL = paramesv.wmL;
    localesv.scene = paramesv.scene;
    localesv.fwe = paramesv.fwe;
    localesv.jQi = paramesv.jQi;
    localesv.UuI = paramesv.UuI;
    localesv.UuH = paramesv.UuH;
    localesv.UuE = paramesv.UuE;
    localesv.UuF = paramesv.UuF;
    localesv.UuG = paramesv.UuG;
    localesv.UuD = paramesv.UuD;
    localesv.Pye.addAll(paramesv.Pye);
    localesv.iYs = paramesv.iYs;
    localesv.UuO = paramesv.UuO;
    localesv.UuP = paramesv.UuP;
    AppMethodBeat.o(90977);
    return localesv;
  }
  
  public static final esv a(flm paramflm, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    esv localesv = new esv();
    localesv.wmL = UUID.randomUUID().toString();
    localesv.UuI = new esy();
    localesv.UuI.title = paramflm.pqW;
    localesv.UuI.BHW = ("video-" + paramflm.PyQ);
    localesv.UuI.Crh = paramflm.PyQ;
    localesv.UuI.UuU = paramflm.thumbUrl;
    if (Util.isNullOrNil(localesv.UuI.UuU)) {
      localesv.UuI.UuU = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramflm.PyQ + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localesv.UuI.PyY = paramflm.PyY;
    localesv.UuI.source = paramflm.source;
    localesv.UuI.fVx = paramflm.fVx;
    localesv.UuI.UuX = paramflm.PyR;
    localesv.UuI.UuZ = paramflm.PyR;
    localesv.UuI.PyW = paramflm.PyW;
    if (paramflm.Pzc == 100203L)
    {
      localesv.UuI.thumbWidth = 360;
      localesv.UuI.thumbHeight = 640;
    }
    for (;;)
    {
      localesv.UuI.timestamp = System.currentTimeMillis();
      if (!Util.isNullOrNil(paramflm.Pzb)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramflm.Pzb);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            eij localeij = new eij();
            localeij.id = localJSONObject.optString("id");
            localeij.wording = localJSONObject.optString("wording");
            localeij.Ukr = localJSONObject.optLong("category");
            localeij.actionType = localJSONObject.optInt("actionType");
            localeij.url = localJSONObject.optString("url");
            localeij.title = localJSONObject.optString("title");
            localeij.rsw = localJSONObject.optString("subTitle");
            localeij.icon = localJSONObject.optString("icon");
            localesv.UuI.Crg.add(localeij);
            i += 1;
            continue;
            localesv.UuI.thumbWidth = 496;
            localesv.UuI.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localesv.UuD = paramflm.PyQ;
    localesv.UuE = paramflm.PyR;
    localesv.UuF = paramflm.PyS;
    localesv.UuG = paramflm.PyT;
    localesv.UuH = paramflm.Pzc;
    if (localesv.UuH <= 0L) {
      localesv.UuH = 100201L;
    }
    localesv.UuK = false;
    if (!Util.isNullOrNil(paramflm.Pza)) {
      s(localesv.Pye, paramflm.Pza);
    }
    localesv.jQi = "";
    localesv.scene = paramInt;
    localesv.fwe = paramString;
    if (!Util.isNullOrNil(paramflm.Pzd))
    {
      localesv.UuJ = new eij();
      localesv.UuJ.title = paramflm.Pzd;
    }
    AppMethodBeat.o(90974);
    return localesv;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    AppMethodBeat.i(90983);
    HashMap localHashMap = new HashMap();
    if (!Util.isNullOrNil(paramString4)) {
      localHashMap.put("redPointMsgId", paramString4);
    }
    if (!Util.isNullOrNil(paramString1)) {
      localHashMap.put("sessionId", paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      localHashMap.put("query", paramString2);
    }
    if (!Util.isNullOrNil(paramString3))
    {
      localHashMap.put("requestId", paramString3);
      localHashMap.put("pRequestId", paramString3);
      localHashMap.put("seq", paramString3);
    }
    if (!Util.isNullOrNil(paramString7)) {
      localHashMap.put("extParams", paramString7);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    if (!Util.isNullOrNil(paramString5)) {
      localHashMap.put("tabInfo", paramString5);
    }
    if (paramInt2 > 0) {
      localHashMap.put("contentReddot", String.valueOf(paramInt2));
    }
    if (paramInt3 > 0) {
      localHashMap.put("numberReddot", String.valueOf(paramInt3));
    }
    localHashMap.put("profile", "1");
    if (!Util.isNullOrNil(paramString6)) {
      localHashMap.put("homeMsgId", paramString6);
    }
    try
    {
      localHashMap.put("deviceName", URLEncoder.encode(d.RAB, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.RAy);
      paramString1 = q(localHashMap);
      AppMethodBeat.o(90983);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static final esv aO(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    esv localesv = new esv();
    localesv.fwe = ai.aa(paramMap, "query");
    localesv.scene = ai.b(paramMap, "scene", 21);
    localesv.wmL = UUID.randomUUID().toString();
    localesv.jQi = ai.aa(paramMap, "searchId");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localesv.UuK = true;
    }
    Object localObject2 = ai.aa(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(ai.aa(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          eta localeta = new eta();
          localeta.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localeta);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localesv.UuI = new esy();
    localesv.UuI.title = ai.aa(paramMap, "title");
    localesv.UuI.UuU = ai.aa(paramMap, "thumbUrl");
    localesv.UuI.KFK = ai.b(paramMap, "mediaDuration", 0);
    localesv.UuI.Crh = ((String)localObject2);
    localesv.UuI.PyY = ai.aa(paramMap, "strPlayCount");
    localesv.UuI.vhY = ai.aa(paramMap, "shareUrl");
    localesv.UuI.pqW = ai.aa(paramMap, "shareTitle");
    localesv.UuI.PyZ = ai.aa(paramMap, "titleUrl");
    localesv.UuI.CHR = ai.aa(paramMap, "shareDesc");
    localesv.UuI.PyV = ai.aa(paramMap, "shareImgUrl");
    localesv.UuI.PyW = ai.aa(paramMap, "shareString");
    localesv.UuI.PyX = ai.aa(paramMap, "shareStringUrl");
    localesv.UuI.source = ai.aa(paramMap, "source");
    localesv.UuI.fVx = ai.aa(paramMap, "sourceUrl");
    localesv.UuI.UuV = ai.a(paramMap, "relevant_category", -1L);
    localesv.UuI.UuW = ai.aa(paramMap, "shareOpenId");
    localesv.UuI.BHW = ai.aa(paramMap, "docID");
    localesv.UuI.Uvb = ai.a(paramMap, "videoSize", 0L);
    localesv.UuI.timestamp = Util.currentTicks();
    localesv.UuI.UuY = ai.b(paramMap, "itemType", 0);
    localesv.UuI.Uvd = ai.b(paramMap, "switchFlag", 0);
    if (Util.isNullOrNil(localesv.UuI.UuU)) {
      localesv.UuI.UuU = ("http://shp.qpic.cn/qqvideo_ori/0/" + localesv.UuI.Crh + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(ai.aa(paramMap, "block"));
      localesv.UuI.Uva = ((JSONObject)localObject2).optLong("resultType");
      localesv.UuI.fwf = ((JSONObject)localObject2).optLong("type");
      label602:
      localesv.UuI.UuX = ai.aa(paramMap, "expand");
      localesv.UuI.Uvc.addAll((Collection)localObject1);
      localObject1 = iy((List)localObject1);
      if (localObject1 != null)
      {
        localesv.UuI.videoUrl = ((eta)localObject1).url;
        localesv.UuI.Uvk = ((eta)localObject1).Uvk;
      }
      localObject1 = ai.aa(paramMap, "show_tag_list");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localesv.UuI.Crg.addAll(K((JSONArray)localObject1));
        label709:
        localesv.UuH = localesv.UuI.UuV;
        localesv.UuE = ai.aa(paramMap, "expand");
        localesv.UuF = localesv.jQi;
        localesv.UuD = localesv.UuI.Crh;
        if (localesv.UuH == 100203L)
        {
          localesv.UuI.thumbWidth = 360;
          localesv.UuI.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = ai.aa(paramMap, "videoChannelTitle");
          if ((!Util.isNullOrNil(localesv.UuI.PyW)) && ((localesv.UuH == 100202L) || (localesv.UuH == 100204L) || (localesv.UuH == 100205L)))
          {
            localesv.UuJ = new eij();
            localesv.UuJ.title = ((String)localObject1);
          }
          paramMap = ai.aa(paramMap, "extReqParams");
          if (!Util.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new aci();
                ((aci)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((aci)localObject2).SnV = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((aci)localObject2).SnW = ((JSONObject)localObject1).optString("textValue", "");
                localesv.Pye.add(localObject2);
                i += 1;
                continue;
                localesv.UuI.thumbWidth = 496;
                localesv.UuI.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localesv;
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
  
  public static final boolean aju(int paramInt)
  {
    return (paramInt == 110) || (paramInt == 700);
  }
  
  public static final esv bA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    esv localesv = new esv();
    localesv.fwe = paramJSONObject.optString("query", "");
    localesv.scene = paramJSONObject.optInt("scene", 21);
    localesv.wmL = UUID.randomUUID().toString();
    localesv.UuF = paramJSONObject.optString("searchId", "");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localesv.UuK = true;
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
          eta localeta = new eta();
          localeta.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localeta);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localesv.UuI = new esy();
    localesv.UuI.title = paramJSONObject.optString("title", "");
    localesv.UuI.UuU = paramJSONObject.optString("thumbUrl", "");
    localesv.UuI.KFK = paramJSONObject.optInt("mediaDuration", 0);
    localesv.UuI.Crh = ((String)localObject2);
    localesv.UuI.PyY = paramJSONObject.optString("strPlayCount", "");
    localesv.UuI.vhY = paramJSONObject.optString("shareUrl", "");
    localesv.UuI.pqW = paramJSONObject.optString("shareTitle", "");
    localesv.UuI.PyZ = paramJSONObject.optString("titleUrl", "");
    localesv.UuI.CHR = paramJSONObject.optString("shareDesc", "");
    localesv.UuI.PyV = paramJSONObject.optString("shareImgUrl", "");
    localesv.UuI.PyW = paramJSONObject.optString("shareString", "");
    localesv.UuI.PyX = paramJSONObject.optString("shareStringUrl", "");
    localesv.UuI.source = paramJSONObject.optString("source", "");
    localesv.UuI.fVx = paramJSONObject.optString("sourceUrl", "");
    localesv.UuI.UuV = paramJSONObject.optInt("relevant_category", -1);
    localesv.UuI.UuW = paramJSONObject.optString("shareOpenId", "");
    localesv.UuI.BHW = paramJSONObject.optString("docID", "");
    localesv.UuI.Uvb = paramJSONObject.optInt("videoSize", 0);
    localesv.UuI.timestamp = Util.currentTicks();
    localesv.UuI.UuY = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localesv.UuI.Uva = ((JSONObject)localObject2).optLong("resultType");
      localesv.UuI.fwf = ((JSONObject)localObject2).optLong("type");
      label578:
      localesv.UuI.UuX = paramJSONObject.optString("expand", "");
      localesv.UuI.Uvc.addAll((Collection)localObject1);
      localObject1 = iy((List)localObject1);
      if (localObject1 != null)
      {
        localesv.UuI.videoUrl = ((eta)localObject1).url;
        localesv.UuI.Uvk = ((eta)localObject1).Uvk;
      }
      if (Util.isNullOrNil(localesv.UuI.UuU)) {
        localesv.UuI.UuU = ("http://shp.qpic.cn/qqvideo_ori/0/" + localesv.UuI.Crh + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localesv.UuI.Crg.addAll(K((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localesv.UuI.Uvj = new esw();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localesv.UuI.Uvj.UuR = ((JSONObject)localObject1).optString("detailWording");
            localesv.UuI.Uvj.UuS = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new aoz();
                ((aoz)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((aoz)localObject2).wording = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localesv.UuI.Uvj.UuT.add(localObject2);
                i += 1;
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("show_tag_list", "");
        if (!Util.isNullOrNil((String)localObject1)) {}
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          localesv.UuI.Crg.addAll(K((JSONArray)localObject1));
          label963:
          localesv.UuH = localesv.UuI.UuV;
          localesv.UuE = paramJSONObject.optString("expand", "");
          localesv.jQi = "";
          localesv.UuD = localesv.UuI.Crh;
          localesv.UuI.Uvd = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localesv.UuI;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((esy)localObject1).Uvi = bool;
            localObject2 = localesv.UuI;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((esy)localObject2).zGJ = ((String)localObject1);
            if (localesv.UuH != 100203L) {
              break label1419;
            }
            localesv.UuI.thumbWidth = 360;
          }
          for (localesv.UuI.thumbHeight = 640;; localesv.UuI.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localesv.UuI.Uvf = new est();
                localesv.UuI.Uvf.Uux = ((JSONObject)localObject1).optInt("videoSecondType");
                localesv.UuI.Uvf.Uuz = ((JSONObject)localObject1).optInt("requestDuration");
                localesv.UuI.Uvf.UuA = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!Util.isNullOrNil((String)localObject1)) && ((localesv.UuH == 100202L) || (localesv.UuH == 100204L) || (localesv.UuH == 100205L)))
              {
                localesv.UuJ = new eij();
                localesv.UuJ.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (Util.isNullOrNil((String)localObject1)) {
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
                  aci localaci = new aci();
                  localaci.key = ((JSONObject)localObject2).optString("key", "");
                  localaci.SnV = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localaci.SnW = ((JSONObject)localObject2).optString("textValue", "");
                  localesv.Pye.add(localaci);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localesv.UuI.thumbWidth = 496;
          }
          localesv.UuO = paramJSONObject.optString("preNetType", "");
          if (localesv.UuO.equals("wangka")) {
            localesv.UuP = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localesv;
            if ((localesv.UuO.equals("2g")) || (localesv.UuO.equals("3g")) || (localesv.UuO.equals("4g"))) {
              localesv.UuP = 2;
            } else {
              localesv.UuP = 0;
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
  
  public static String beT(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = MMApplicationContext.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static String gpL()
  {
    AppMethodBeat.i(90978);
    String str = MMApplicationContext.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean gpM()
  {
    AppMethodBeat.i(90980);
    if (1 >= Log.getLogLevel())
    {
      AppMethodBeat.o(90980);
      return true;
    }
    AppMethodBeat.o(90980);
    return false;
  }
  
  public static String gpN()
  {
    AppMethodBeat.i(90986);
    String str = b.aSE() + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String gpO()
  {
    AppMethodBeat.i(90987);
    String str = b.aSE() + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean isFreeSimCard()
  {
    AppMethodBeat.i(90988);
    int i = ((a)com.tencent.mm.kernel.h.ae(a.class)).eSB();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(90988);
      return bool;
    }
  }
  
  public static final eta iy(List<eta> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      eta localeta = (eta)paramList.next();
      if ((localeta != null) && (!Util.isNullOrNil(localeta.url)))
      {
        AppMethodBeat.o(90973);
        return localeta;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray iz(List<eij> paramList)
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
        eij localeij = (eij)paramList.get(i);
        localJSONObject.put("id", localeij.id);
        localJSONObject.put("wording", localeij.wording);
        localJSONObject.put("category", localeij.Ukr);
        localJSONObject.put("actionType", localeij.actionType);
        localJSONObject.put("url", localeij.url);
        localJSONObject.put("title", localeij.title);
        localJSONObject.put("subTitle", localeij.rsw);
        localJSONObject.put("icon", localeij.icon);
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
  
  public static String q(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    r(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(ai.anf(1).gRd());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  private static void r(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90985);
    paramHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(ai.anf(1).bkM()));
    paramHashMap.put("netType", ai.anV());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
    AppMethodBeat.o(90985);
  }
  
  public static final void s(List<aci> paramList, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(90990);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          aci localaci = new aci();
          localaci.key = localJSONObject.optString("key", "");
          localaci.SnV = localJSONObject.optInt("uintValue", 0);
          localaci.SnW = localJSONObject.optString("textValue", "");
          paramList.add(localaci);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */