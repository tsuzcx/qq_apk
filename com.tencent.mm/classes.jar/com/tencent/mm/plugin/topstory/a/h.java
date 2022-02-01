package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
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
  private static List<dfc> F(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      dfc localdfc = new dfc();
      localdfc.id = localJSONObject.optString("id", "");
      localdfc.dyI = localJSONObject.optString("wording", "");
      localdfc.HMm = localJSONObject.optLong("category", 0L);
      localdfc.actionType = localJSONObject.optInt("actionType", 0);
      localdfc.url = localJSONObject.optString("url", "");
      localdfc.title = localJSONObject.optString("title", "");
      localdfc.nhq = localJSONObject.optString("subTitle", "");
      localdfc.dEM = localJSONObject.optString("icon", "");
      localArrayList.add(localdfc);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final dox a(dox paramdox)
  {
    AppMethodBeat.i(90977);
    dox localdox = new dox();
    localdox.rfA = paramdox.rfA;
    localdox.scene = paramdox.scene;
    localdox.dmf = paramdox.dmf;
    localdox.kid = paramdox.kid;
    localdox.HVT = paramdox.HVT;
    localdox.HVS = paramdox.HVS;
    localdox.HVP = paramdox.HVP;
    localdox.HVQ = paramdox.HVQ;
    localdox.HVR = paramdox.HVR;
    localdox.HVO = paramdox.HVO;
    localdox.DTg.addAll(paramdox.DTg);
    localdox.fOX = paramdox.fOX;
    localdox.HVZ = paramdox.HVZ;
    localdox.HWa = paramdox.HWa;
    AppMethodBeat.o(90977);
    return localdox;
  }
  
  public static final dox a(egh paramegh, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    dox localdox = new dox();
    localdox.rfA = UUID.randomUUID().toString();
    localdox.HVT = new dpa();
    localdox.HVT.title = paramegh.qlw;
    localdox.HVT.tFc = ("video-" + paramegh.DTD);
    localdox.HVT.udb = paramegh.DTD;
    localdox.HVT.HWg = paramegh.thumbUrl;
    if (bu.isNullOrNil(localdox.HVT.HWg)) {
      localdox.HVT.HWg = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramegh.DTD + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localdox.HVT.DTL = paramegh.DTL;
    localdox.HVT.source = paramegh.source;
    localdox.HVT.dJL = paramegh.dJL;
    localdox.HVT.HWj = paramegh.DTE;
    localdox.HVT.HWl = paramegh.DTE;
    localdox.HVT.DTJ = paramegh.DTJ;
    if (paramegh.DTP == 100203L)
    {
      localdox.HVT.thumbWidth = 360;
      localdox.HVT.thumbHeight = 640;
    }
    for (;;)
    {
      localdox.HVT.timestamp = System.currentTimeMillis();
      if (!bu.isNullOrNil(paramegh.DTO)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramegh.DTO);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            dfc localdfc = new dfc();
            localdfc.id = localJSONObject.optString("id");
            localdfc.dyI = localJSONObject.optString("wording");
            localdfc.HMm = localJSONObject.optLong("category");
            localdfc.actionType = localJSONObject.optInt("actionType");
            localdfc.url = localJSONObject.optString("url");
            localdfc.title = localJSONObject.optString("title");
            localdfc.nhq = localJSONObject.optString("subTitle");
            localdfc.dEM = localJSONObject.optString("icon");
            localdox.HVT.uda.add(localdfc);
            i += 1;
            continue;
            localdox.HVT.thumbWidth = 496;
            localdox.HVT.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localdox.HVO = paramegh.DTD;
    localdox.HVP = paramegh.DTE;
    localdox.HVQ = paramegh.DTF;
    localdox.HVR = paramegh.DTG;
    localdox.HVS = paramegh.DTP;
    if (localdox.HVS <= 0L) {
      localdox.HVS = 100201L;
    }
    localdox.HVV = false;
    if (!bu.isNullOrNil(paramegh.DTN)) {
      p(localdox.DTg, paramegh.DTN);
    }
    localdox.kid = "";
    localdox.scene = paramInt;
    localdox.dmf = paramString;
    if (!bu.isNullOrNil(paramegh.DTQ))
    {
      localdox.HVU = new dfc();
      localdox.HVU.title = paramegh.DTQ;
    }
    AppMethodBeat.o(90974);
    return localdox;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    AppMethodBeat.i(90983);
    HashMap localHashMap = new HashMap();
    if (!bu.isNullOrNil(paramString4)) {
      localHashMap.put("redPointMsgId", paramString4);
    }
    if (!bu.isNullOrNil(paramString1)) {
      localHashMap.put("sessionId", paramString1);
    }
    if (!bu.isNullOrNil(paramString2)) {
      localHashMap.put("query", paramString2);
    }
    if (!bu.isNullOrNil(paramString3))
    {
      localHashMap.put("requestId", paramString3);
      localHashMap.put("pRequestId", paramString3);
      localHashMap.put("seq", paramString3);
    }
    if (!bu.isNullOrNil(paramString7)) {
      localHashMap.put("extParams", paramString7);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    if (!bu.isNullOrNil(paramString5)) {
      localHashMap.put("tabInfo", paramString5);
    }
    if (paramInt2 > 0) {
      localHashMap.put("contentReddot", String.valueOf(paramInt2));
    }
    if (paramInt3 > 0) {
      localHashMap.put("numberReddot", String.valueOf(paramInt3));
    }
    localHashMap.put("profile", "1");
    if (!bu.isNullOrNil(paramString6)) {
      localHashMap.put("homeMsgId", paramString6);
    }
    try
    {
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.FFD);
      paramString1 = m(localHashMap);
      AppMethodBeat.o(90983);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static String aEf(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = ak.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static final dox aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    dox localdox = new dox();
    localdox.dmf = paramJSONObject.optString("query", "");
    localdox.scene = paramJSONObject.optInt("scene", 21);
    localdox.rfA = UUID.randomUUID().toString();
    localdox.HVQ = paramJSONObject.optString("searchId", "");
    if ((az.isConnected(ak.getContext())) && (!az.isWifi(ak.getContext()))) {
      localdox.HVV = true;
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
          dpc localdpc = new dpc();
          localdpc.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdpc);
          i += 1;
        }
      }
      if (bu.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localdox.HVT = new dpa();
    localdox.HVT.title = paramJSONObject.optString("title", "");
    localdox.HVT.HWg = paramJSONObject.optString("thumbUrl", "");
    localdox.HVT.AjG = paramJSONObject.optInt("mediaDuration", 0);
    localdox.HVT.udb = ((String)localObject2);
    localdox.HVT.DTL = paramJSONObject.optString("strPlayCount", "");
    localdox.HVT.qlv = paramJSONObject.optString("shareUrl", "");
    localdox.HVT.qlw = paramJSONObject.optString("shareTitle", "");
    localdox.HVT.DTM = paramJSONObject.optString("titleUrl", "");
    localdox.HVT.uly = paramJSONObject.optString("shareDesc", "");
    localdox.HVT.DTI = paramJSONObject.optString("shareImgUrl", "");
    localdox.HVT.DTJ = paramJSONObject.optString("shareString", "");
    localdox.HVT.DTK = paramJSONObject.optString("shareStringUrl", "");
    localdox.HVT.source = paramJSONObject.optString("source", "");
    localdox.HVT.dJL = paramJSONObject.optString("sourceUrl", "");
    localdox.HVT.HWh = paramJSONObject.optInt("relevant_category", -1);
    localdox.HVT.HWi = paramJSONObject.optString("shareOpenId", "");
    localdox.HVT.tFc = paramJSONObject.optString("docID", "");
    localdox.HVT.HWo = paramJSONObject.optInt("videoSize", 0);
    localdox.HVT.timestamp = bu.HQ();
    localdox.HVT.HWk = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localdox.HVT.HWn = ((JSONObject)localObject2).optLong("resultType");
      localdox.HVT.dmg = ((JSONObject)localObject2).optLong("type");
      label578:
      localdox.HVT.HWj = paramJSONObject.optString("expand", "");
      localdox.HVT.HWp.addAll((Collection)localObject1);
      localObject1 = gH((List)localObject1);
      if (localObject1 != null)
      {
        localdox.HVT.videoUrl = ((dpc)localObject1).url;
        localdox.HVT.HWy = ((dpc)localObject1).HWy;
      }
      if (bu.isNullOrNil(localdox.HVT.HWg)) {
        localdox.HVT.HWg = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdox.HVT.udb + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bu.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdox.HVT.uda.addAll(F((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localdox.HVT.HWx = new doy();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localdox.HVT.HWx.HWc = ((JSONObject)localObject1).optString("detailWording");
            localdox.HVT.HWx.HWd = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new alj();
                ((alj)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((alj)localObject2).dyI = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localdox.HVT.HWx.HWe.add(localObject2);
                i += 1;
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("show_tag_list", "");
        if (!bu.isNullOrNil((String)localObject1)) {}
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          localdox.HVT.uda.addAll(F((JSONArray)localObject1));
          label963:
          localdox.HVS = localdox.HVT.HWh;
          localdox.HVP = paramJSONObject.optString("expand", "");
          localdox.kid = "";
          localdox.HVO = localdox.HVT.udb;
          localdox.HVT.HWq = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localdox.HVT;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((dpa)localObject1).HWv = bool;
            localObject2 = localdox.HVT;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((dpa)localObject2).HWw = ((String)localObject1);
            if (localdox.HVS != 100203L) {
              break label1419;
            }
            localdox.HVT.thumbWidth = 360;
          }
          for (localdox.HVT.thumbHeight = 640;; localdox.HVT.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localdox.HVT.HWs = new dov();
                localdox.HVT.HWs.HVI = ((JSONObject)localObject1).optInt("videoSecondType");
                localdox.HVT.HWs.HVK = ((JSONObject)localObject1).optInt("requestDuration");
                localdox.HVT.HWs.HVL = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!bu.isNullOrNil((String)localObject1)) && ((localdox.HVS == 100202L) || (localdox.HVS == 100204L) || (localdox.HVS == 100205L)))
              {
                localdox.HVU = new dfc();
                localdox.HVU.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (bu.isNullOrNil((String)localObject1)) {
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
                  aaj localaaj = new aaj();
                  localaaj.key = ((JSONObject)localObject2).optString("key", "");
                  localaaj.GrE = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localaaj.GrF = ((JSONObject)localObject2).optString("textValue", "");
                  localdox.DTg.add(localaaj);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localdox.HVT.thumbWidth = 496;
          }
          localdox.HVZ = paramJSONObject.optString("preNetType", "");
          if (localdox.HVZ.equals("wangka")) {
            localdox.HWa = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localdox;
            if ((localdox.HVZ.equals("2g")) || (localdox.HVZ.equals("3g")) || (localdox.HVZ.equals("4g"))) {
              localdox.HWa = 2;
            } else {
              localdox.HWa = 0;
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
  
  public static final dox aV(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    dox localdox = new dox();
    localdox.dmf = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "query");
    localdox.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 21);
    localdox.rfA = UUID.randomUUID().toString();
    localdox.kid = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "searchId");
    if ((az.isConnected(ak.getContext())) && (!az.isWifi(ak.getContext()))) {
      localdox.HVV = true;
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          dpc localdpc = new dpc();
          localdpc.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdpc);
          i += 1;
        }
      }
      if (bu.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localdox.HVT = new dpa();
    localdox.HVT.title = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "title");
    localdox.HVT.HWg = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "thumbUrl");
    localdox.HVT.AjG = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "mediaDuration", 0);
    localdox.HVT.udb = ((String)localObject2);
    localdox.HVT.DTL = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "strPlayCount");
    localdox.HVT.qlv = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareUrl");
    localdox.HVT.qlw = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareTitle");
    localdox.HVT.DTM = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "titleUrl");
    localdox.HVT.uly = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareDesc");
    localdox.HVT.DTI = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareImgUrl");
    localdox.HVT.DTJ = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareString");
    localdox.HVT.DTK = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareStringUrl");
    localdox.HVT.source = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "source");
    localdox.HVT.dJL = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sourceUrl");
    localdox.HVT.HWh = com.tencent.mm.plugin.websearch.api.ad.a(paramMap, "relevant_category", -1L);
    localdox.HVT.HWi = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "shareOpenId");
    localdox.HVT.tFc = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "docID");
    localdox.HVT.HWo = com.tencent.mm.plugin.websearch.api.ad.a(paramMap, "videoSize", 0L);
    localdox.HVT.timestamp = bu.HQ();
    localdox.HVT.HWk = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "itemType", 0);
    localdox.HVT.HWq = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "switchFlag", 0);
    if (bu.isNullOrNil(localdox.HVT.HWg)) {
      localdox.HVT.HWg = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdox.HVT.udb + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "block"));
      localdox.HVT.HWn = ((JSONObject)localObject2).optLong("resultType");
      localdox.HVT.dmg = ((JSONObject)localObject2).optLong("type");
      label602:
      localdox.HVT.HWj = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "expand");
      localdox.HVT.HWp.addAll((Collection)localObject1);
      localObject1 = gH((List)localObject1);
      if (localObject1 != null)
      {
        localdox.HVT.videoUrl = ((dpc)localObject1).url;
        localdox.HVT.HWy = ((dpc)localObject1).HWy;
      }
      localObject1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "show_tag_list");
      if (!bu.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdox.HVT.uda.addAll(F((JSONArray)localObject1));
        label709:
        localdox.HVS = localdox.HVT.HWh;
        localdox.HVP = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "expand");
        localdox.HVQ = localdox.kid;
        localdox.HVO = localdox.HVT.udb;
        if (localdox.HVS == 100203L)
        {
          localdox.HVT.thumbWidth = 360;
          localdox.HVT.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "videoChannelTitle");
          if ((!bu.isNullOrNil(localdox.HVT.DTJ)) && ((localdox.HVS == 100202L) || (localdox.HVS == 100204L) || (localdox.HVS == 100205L)))
          {
            localdox.HVU = new dfc();
            localdox.HVU.title = ((String)localObject1);
          }
          paramMap = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "extReqParams");
          if (!bu.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new aaj();
                ((aaj)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((aaj)localObject2).GrE = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((aaj)localObject2).GrF = ((JSONObject)localObject1).optString("textValue", "");
                localdox.DTg.add(localObject2);
                i += 1;
                continue;
                localdox.HVT.thumbWidth = 496;
                localdox.HVT.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localdox;
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
  
  public static String esq()
  {
    AppMethodBeat.i(90978);
    String str = ak.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean esr()
  {
    AppMethodBeat.i(90980);
    if (1 >= ae.getLogLevel())
    {
      AppMethodBeat.o(90980);
      return true;
    }
    AppMethodBeat.o(90980);
    return false;
  }
  
  public static String ess()
  {
    AppMethodBeat.i(90986);
    String str = b.asc().replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String est()
  {
    AppMethodBeat.i(90987);
    String str = b.asc().replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean esu()
  {
    AppMethodBeat.i(90988);
    int i = ((a)g.ab(a.class)).dpg();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      ae.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(90988);
      return bool;
    }
  }
  
  public static String esv()
  {
    AppMethodBeat.i(90989);
    if (az.isWifi(ak.getContext()))
    {
      AppMethodBeat.o(90989);
      return "wifi";
    }
    if (esu())
    {
      AppMethodBeat.o(90989);
      return "wangka";
    }
    if (az.is4G(ak.getContext()))
    {
      AppMethodBeat.o(90989);
      return "4g";
    }
    if (az.is3G(ak.getContext()))
    {
      AppMethodBeat.o(90989);
      return "3g";
    }
    if (az.is2G(ak.getContext()))
    {
      AppMethodBeat.o(90989);
      return "2g";
    }
    if (!az.isConnected(ak.getContext()))
    {
      AppMethodBeat.o(90989);
      return "fail";
    }
    AppMethodBeat.o(90989);
    return "";
  }
  
  public static final dpc gH(List<dpc> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dpc localdpc = (dpc)paramList.next();
      if ((localdpc != null) && (!bu.isNullOrNil(localdpc.url)))
      {
        AppMethodBeat.o(90973);
        return localdpc;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray gI(List<dfc> paramList)
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
        dfc localdfc = (dfc)paramList.get(i);
        localJSONObject.put("id", localdfc.id);
        localJSONObject.put("wording", localdfc.dyI);
        localJSONObject.put("category", localdfc.HMm);
        localJSONObject.put("actionType", localdfc.actionType);
        localJSONObject.put("url", localdfc.url);
        localJSONObject.put("title", localdfc.title);
        localJSONObject.put("subTitle", localdfc.nhq);
        localJSONObject.put("icon", localdfc.dEM);
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
    paramHashMap.put("lang", com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.WJ(1).aHD()));
    paramHashMap.put("netType", com.tencent.mm.plugin.websearch.api.ad.UD());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", j.hju);
    AppMethodBeat.o(90985);
  }
  
  public static String m(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    h(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.WJ(1).eQf());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  public static final void p(List<aaj> paramList, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(90990);
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          aaj localaaj = new aaj();
          localaaj.key = localJSONObject.optString("key", "");
          localaaj.GrE = localJSONObject.optInt("uintValue", 0);
          localaaj.GrF = localJSONObject.optString("textValue", "");
          paramList.add(localaaj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */