package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
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
  private static List<dei> E(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      dei localdei = new dei();
      localdei.id = localJSONObject.optString("id", "");
      localdei.dxD = localJSONObject.optString("wording", "");
      localdei.HsJ = localJSONObject.optLong("category", 0L);
      localdei.actionType = localJSONObject.optInt("actionType", 0);
      localdei.url = localJSONObject.optString("url", "");
      localdei.title = localJSONObject.optString("title", "");
      localdei.nch = localJSONObject.optString("subTitle", "");
      localdei.dDH = localJSONObject.optString("icon", "");
      localArrayList.add(localdei);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final doa a(doa paramdoa)
  {
    AppMethodBeat.i(90977);
    doa localdoa = new doa();
    localdoa.qXu = paramdoa.qXu;
    localdoa.scene = paramdoa.scene;
    localdoa.dld = paramdoa.dld;
    localdoa.keN = paramdoa.keN;
    localdoa.HCg = paramdoa.HCg;
    localdoa.HCf = paramdoa.HCf;
    localdoa.HCc = paramdoa.HCc;
    localdoa.HCd = paramdoa.HCd;
    localdoa.HCe = paramdoa.HCe;
    localdoa.HCb = paramdoa.HCb;
    localdoa.DBj.addAll(paramdoa.DBj);
    localdoa.fMP = paramdoa.fMP;
    localdoa.HCm = paramdoa.HCm;
    localdoa.HCn = paramdoa.HCn;
    AppMethodBeat.o(90977);
    return localdoa;
  }
  
  public static final doa a(eeq parameeq, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    doa localdoa = new doa();
    localdoa.qXu = UUID.randomUUID().toString();
    localdoa.HCg = new dod();
    localdoa.HCg.title = parameeq.qeR;
    localdoa.HCg.tul = ("video-" + parameeq.DBG);
    localdoa.HCg.tSk = parameeq.DBG;
    localdoa.HCg.HCt = parameeq.thumbUrl;
    if (bt.isNullOrNil(localdoa.HCg.HCt)) {
      localdoa.HCg.HCt = ("http://shp.qpic.cn/qqvideo_ori/0/" + parameeq.DBG + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localdoa.HCg.DBO = parameeq.DBO;
    localdoa.HCg.source = parameeq.source;
    localdoa.HCg.lox = parameeq.lox;
    localdoa.HCg.HCw = parameeq.DBH;
    localdoa.HCg.HCy = parameeq.DBH;
    localdoa.HCg.DBM = parameeq.DBM;
    if (parameeq.DBS == 100203L)
    {
      localdoa.HCg.thumbWidth = 360;
      localdoa.HCg.thumbHeight = 640;
    }
    for (;;)
    {
      localdoa.HCg.timestamp = System.currentTimeMillis();
      if (!bt.isNullOrNil(parameeq.DBR)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(parameeq.DBR);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            dei localdei = new dei();
            localdei.id = localJSONObject.optString("id");
            localdei.dxD = localJSONObject.optString("wording");
            localdei.HsJ = localJSONObject.optLong("category");
            localdei.actionType = localJSONObject.optInt("actionType");
            localdei.url = localJSONObject.optString("url");
            localdei.title = localJSONObject.optString("title");
            localdei.nch = localJSONObject.optString("subTitle");
            localdei.dDH = localJSONObject.optString("icon");
            localdoa.HCg.tSj.add(localdei);
            i += 1;
            continue;
            localdoa.HCg.thumbWidth = 496;
            localdoa.HCg.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localdoa.HCb = parameeq.DBG;
    localdoa.HCc = parameeq.DBH;
    localdoa.HCd = parameeq.DBI;
    localdoa.HCe = parameeq.DBJ;
    localdoa.HCf = parameeq.DBS;
    if (localdoa.HCf <= 0L) {
      localdoa.HCf = 100201L;
    }
    localdoa.HCi = false;
    if (!bt.isNullOrNil(parameeq.DBQ)) {
      p(localdoa.DBj, parameeq.DBQ);
    }
    localdoa.keN = "";
    localdoa.scene = paramInt;
    localdoa.dld = paramString;
    if (!bt.isNullOrNil(parameeq.DBT))
    {
      localdoa.HCh = new dei();
      localdoa.HCh.title = parameeq.DBT;
    }
    AppMethodBeat.o(90974);
    return localdoa;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7)
  {
    AppMethodBeat.i(90983);
    HashMap localHashMap = new HashMap();
    if (!bt.isNullOrNil(paramString4)) {
      localHashMap.put("redPointMsgId", paramString4);
    }
    if (!bt.isNullOrNil(paramString1)) {
      localHashMap.put("sessionId", paramString1);
    }
    if (!bt.isNullOrNil(paramString2)) {
      localHashMap.put("query", paramString2);
    }
    if (!bt.isNullOrNil(paramString3))
    {
      localHashMap.put("requestId", paramString3);
      localHashMap.put("pRequestId", paramString3);
      localHashMap.put("seq", paramString3);
    }
    if (!bt.isNullOrNil(paramString7)) {
      localHashMap.put("extParams", paramString7);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    if (!bt.isNullOrNil(paramString5)) {
      localHashMap.put("tabInfo", paramString5);
    }
    if (paramInt2 > 0) {
      localHashMap.put("contentReddot", String.valueOf(paramInt2));
    }
    if (paramInt3 > 0) {
      localHashMap.put("numberReddot", String.valueOf(paramInt3));
    }
    localHashMap.put("profile", "1");
    if (!bt.isNullOrNil(paramString6)) {
      localHashMap.put("homeMsgId", paramString6);
    }
    try
    {
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.Fnf);
      paramString1 = l(localHashMap);
      AppMethodBeat.o(90983);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static String aCM(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = aj.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static final doa aP(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    doa localdoa = new doa();
    localdoa.dld = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    localdoa.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 21);
    localdoa.qXu = UUID.randomUUID().toString();
    localdoa.keN = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchId");
    if ((ay.isConnected(aj.getContext())) && (!ay.isWifi(aj.getContext()))) {
      localdoa.HCi = true;
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          dof localdof = new dof();
          localdof.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdof);
          i += 1;
        }
      }
      if (bt.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localdoa.HCg = new dod();
    localdoa.HCg.title = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "title");
    localdoa.HCg.HCt = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "thumbUrl");
    localdoa.HCg.zSz = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "mediaDuration", 0);
    localdoa.HCg.tSk = ((String)localObject2);
    localdoa.HCg.DBO = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "strPlayCount");
    localdoa.HCg.qeQ = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareUrl");
    localdoa.HCg.qeR = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareTitle");
    localdoa.HCg.DBP = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "titleUrl");
    localdoa.HCg.uaw = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareDesc");
    localdoa.HCg.DBL = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareImgUrl");
    localdoa.HCg.DBM = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareString");
    localdoa.HCg.DBN = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareStringUrl");
    localdoa.HCg.source = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "source");
    localdoa.HCg.lox = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sourceUrl");
    localdoa.HCg.HCu = com.tencent.mm.plugin.websearch.api.ad.a(paramMap, "relevant_category", -1L);
    localdoa.HCg.HCv = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "shareOpenId");
    localdoa.HCg.tul = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "docID");
    localdoa.HCg.HCB = com.tencent.mm.plugin.websearch.api.ad.a(paramMap, "videoSize", 0L);
    localdoa.HCg.timestamp = bt.HI();
    localdoa.HCg.HCx = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "itemType", 0);
    localdoa.HCg.HCD = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "switchFlag", 0);
    if (bt.isNullOrNil(localdoa.HCg.HCt)) {
      localdoa.HCg.HCt = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdoa.HCg.tSk + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "block"));
      localdoa.HCg.HCA = ((JSONObject)localObject2).optLong("resultType");
      localdoa.HCg.dle = ((JSONObject)localObject2).optLong("type");
      label602:
      localdoa.HCg.HCw = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "expand");
      localdoa.HCg.HCC.addAll((Collection)localObject1);
      localObject1 = gy((List)localObject1);
      if (localObject1 != null)
      {
        localdoa.HCg.videoUrl = ((dof)localObject1).url;
        localdoa.HCg.HCL = ((dof)localObject1).HCL;
      }
      localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "show_tag_list");
      if (!bt.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdoa.HCg.tSj.addAll(E((JSONArray)localObject1));
        label709:
        localdoa.HCf = localdoa.HCg.HCu;
        localdoa.HCc = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "expand");
        localdoa.HCd = localdoa.keN;
        localdoa.HCb = localdoa.HCg.tSk;
        if (localdoa.HCf == 100203L)
        {
          localdoa.HCg.thumbWidth = 360;
          localdoa.HCg.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "videoChannelTitle");
          if ((!bt.isNullOrNil(localdoa.HCg.DBM)) && ((localdoa.HCf == 100202L) || (localdoa.HCf == 100204L) || (localdoa.HCf == 100205L)))
          {
            localdoa.HCh = new dei();
            localdoa.HCh.title = ((String)localObject1);
          }
          paramMap = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "extReqParams");
          if (!bt.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new aag();
                ((aag)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((aag)localObject2).FZe = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((aag)localObject2).FZf = ((JSONObject)localObject1).optString("textValue", "");
                localdoa.DBj.add(localObject2);
                i += 1;
                continue;
                localdoa.HCg.thumbWidth = 496;
                localdoa.HCg.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localdoa;
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
  
  public static final doa aS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    doa localdoa = new doa();
    localdoa.dld = paramJSONObject.optString("query", "");
    localdoa.scene = paramJSONObject.optInt("scene", 21);
    localdoa.qXu = UUID.randomUUID().toString();
    localdoa.HCd = paramJSONObject.optString("searchId", "");
    if ((ay.isConnected(aj.getContext())) && (!ay.isWifi(aj.getContext()))) {
      localdoa.HCi = true;
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
          dof localdof = new dof();
          localdof.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localdof);
          i += 1;
        }
      }
      if (bt.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localdoa.HCg = new dod();
    localdoa.HCg.title = paramJSONObject.optString("title", "");
    localdoa.HCg.HCt = paramJSONObject.optString("thumbUrl", "");
    localdoa.HCg.zSz = paramJSONObject.optInt("mediaDuration", 0);
    localdoa.HCg.tSk = ((String)localObject2);
    localdoa.HCg.DBO = paramJSONObject.optString("strPlayCount", "");
    localdoa.HCg.qeQ = paramJSONObject.optString("shareUrl", "");
    localdoa.HCg.qeR = paramJSONObject.optString("shareTitle", "");
    localdoa.HCg.DBP = paramJSONObject.optString("titleUrl", "");
    localdoa.HCg.uaw = paramJSONObject.optString("shareDesc", "");
    localdoa.HCg.DBL = paramJSONObject.optString("shareImgUrl", "");
    localdoa.HCg.DBM = paramJSONObject.optString("shareString", "");
    localdoa.HCg.DBN = paramJSONObject.optString("shareStringUrl", "");
    localdoa.HCg.source = paramJSONObject.optString("source", "");
    localdoa.HCg.lox = paramJSONObject.optString("sourceUrl", "");
    localdoa.HCg.HCu = paramJSONObject.optInt("relevant_category", -1);
    localdoa.HCg.HCv = paramJSONObject.optString("shareOpenId", "");
    localdoa.HCg.tul = paramJSONObject.optString("docID", "");
    localdoa.HCg.HCB = paramJSONObject.optInt("videoSize", 0);
    localdoa.HCg.timestamp = bt.HI();
    localdoa.HCg.HCx = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localdoa.HCg.HCA = ((JSONObject)localObject2).optLong("resultType");
      localdoa.HCg.dle = ((JSONObject)localObject2).optLong("type");
      label578:
      localdoa.HCg.HCw = paramJSONObject.optString("expand", "");
      localdoa.HCg.HCC.addAll((Collection)localObject1);
      localObject1 = gy((List)localObject1);
      if (localObject1 != null)
      {
        localdoa.HCg.videoUrl = ((dof)localObject1).url;
        localdoa.HCg.HCL = ((dof)localObject1).HCL;
      }
      if (bt.isNullOrNil(localdoa.HCg.HCt)) {
        localdoa.HCg.HCt = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdoa.HCg.tSk + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bt.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdoa.HCg.tSj.addAll(E((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localdoa.HCg.HCK = new dob();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localdoa.HCg.HCK.HCp = ((JSONObject)localObject1).optString("detailWording");
            localdoa.HCg.HCK.HCq = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new akz();
                ((akz)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((akz)localObject2).dxD = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localdoa.HCg.HCK.HCr.add(localObject2);
                i += 1;
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("show_tag_list", "");
        if (!bt.isNullOrNil((String)localObject1)) {}
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          localdoa.HCg.tSj.addAll(E((JSONArray)localObject1));
          label963:
          localdoa.HCf = localdoa.HCg.HCu;
          localdoa.HCc = paramJSONObject.optString("expand", "");
          localdoa.keN = "";
          localdoa.HCb = localdoa.HCg.tSk;
          localdoa.HCg.HCD = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localdoa.HCg;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((dod)localObject1).HCI = bool;
            localObject2 = localdoa.HCg;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((dod)localObject2).HCJ = ((String)localObject1);
            if (localdoa.HCf != 100203L) {
              break label1419;
            }
            localdoa.HCg.thumbWidth = 360;
          }
          for (localdoa.HCg.thumbHeight = 640;; localdoa.HCg.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localdoa.HCg.HCF = new dny();
                localdoa.HCg.HCF.HBV = ((JSONObject)localObject1).optInt("videoSecondType");
                localdoa.HCg.HCF.HBX = ((JSONObject)localObject1).optInt("requestDuration");
                localdoa.HCg.HCF.HBY = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!bt.isNullOrNil((String)localObject1)) && ((localdoa.HCf == 100202L) || (localdoa.HCf == 100204L) || (localdoa.HCf == 100205L)))
              {
                localdoa.HCh = new dei();
                localdoa.HCh.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (bt.isNullOrNil((String)localObject1)) {
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
                  aag localaag = new aag();
                  localaag.key = ((JSONObject)localObject2).optString("key", "");
                  localaag.FZe = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localaag.FZf = ((JSONObject)localObject2).optString("textValue", "");
                  localdoa.DBj.add(localaag);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localdoa.HCg.thumbWidth = 496;
          }
          localdoa.HCm = paramJSONObject.optString("preNetType", "");
          if (localdoa.HCm.equals("wangka")) {
            localdoa.HCn = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localdoa;
            if ((localdoa.HCm.equals("2g")) || (localdoa.HCm.equals("3g")) || (localdoa.HCm.equals("4g"))) {
              localdoa.HCn = 2;
            } else {
              localdoa.HCn = 0;
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
  
  public static String eoJ()
  {
    AppMethodBeat.i(90978);
    String str = aj.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean eoK()
  {
    AppMethodBeat.i(90980);
    if (1 >= com.tencent.mm.sdk.platformtools.ad.getLogLevel())
    {
      AppMethodBeat.o(90980);
      return true;
    }
    AppMethodBeat.o(90980);
    return false;
  }
  
  public static String eoL()
  {
    AppMethodBeat.i(90986);
    String str = b.arN().replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String eoM()
  {
    AppMethodBeat.i(90987);
    String str = b.arN().replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean eoN()
  {
    AppMethodBeat.i(90988);
    int i = ((a)g.ab(a.class)).dmh();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(90988);
      return bool;
    }
  }
  
  public static String eoO()
  {
    AppMethodBeat.i(90989);
    if (ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "wifi";
    }
    if (eoN())
    {
      AppMethodBeat.o(90989);
      return "wangka";
    }
    if (ay.is4G(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "4g";
    }
    if (ay.is3G(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "3g";
    }
    if (ay.is2G(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "2g";
    }
    if (!ay.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "fail";
    }
    AppMethodBeat.o(90989);
    return "";
  }
  
  public static final dof gy(List<dof> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dof localdof = (dof)paramList.next();
      if ((localdof != null) && (!bt.isNullOrNil(localdof.url)))
      {
        AppMethodBeat.o(90973);
        return localdof;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray gz(List<dei> paramList)
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
        dei localdei = (dei)paramList.get(i);
        localJSONObject.put("id", localdei.id);
        localJSONObject.put("wording", localdei.dxD);
        localJSONObject.put("category", localdei.HsJ);
        localJSONObject.put("actionType", localdei.actionType);
        localJSONObject.put("url", localdei.url);
        localJSONObject.put("title", localdei.title);
        localJSONObject.put("subTitle", localdei.nch);
        localJSONObject.put("icon", localdei.dDH);
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
    paramHashMap.put("lang", ac.iM(aj.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.Wc(1).aHm()));
    paramHashMap.put("netType", com.tencent.mm.plugin.websearch.api.ad.Ux());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", i.hgG);
    AppMethodBeat.o(90985);
  }
  
  public static String l(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    h(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.Wc(1).eMw());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  public static final void p(List<aag> paramList, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(90990);
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        paramString = new JSONArray(paramString);
        while (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          aag localaag = new aag();
          localaag.key = localJSONObject.optString("key", "");
          localaag.FZe = localJSONObject.optInt("uintValue", 0);
          localaag.FZf = localJSONObject.optString("textValue", "");
          paramList.add(localaag);
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