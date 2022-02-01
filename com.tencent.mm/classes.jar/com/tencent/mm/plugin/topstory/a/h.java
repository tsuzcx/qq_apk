package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static List<ctk> D(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      ctk localctk = new ctk();
      localctk.id = localJSONObject.optString("id", "");
      localctk.doh = localJSONObject.optString("wording", "");
      localctk.Eld = localJSONObject.optLong("category", 0L);
      localctk.actionType = localJSONObject.optInt("actionType", 0);
      localctk.url = localJSONObject.optString("url", "");
      localctk.title = localJSONObject.optString("title", "");
      localctk.lZG = localJSONObject.optString("subTitle", "");
      localctk.dub = localJSONObject.optString("icon", "");
      localArrayList.add(localctk);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final dcy a(dcy paramdcy)
  {
    AppMethodBeat.i(90977);
    dcy localdcy = new dcy();
    localdcy.qwV = paramdcy.qwV;
    localdcy.scene = paramdcy.scene;
    localdcy.dcm = paramdcy.dcm;
    localdcy.jko = paramdcy.jko;
    localdcy.Euz = paramdcy.Euz;
    localdcy.Euy = paramdcy.Euy;
    localdcy.Euv = paramdcy.Euv;
    localdcy.Euw = paramdcy.Euw;
    localdcy.Eux = paramdcy.Eux;
    localdcy.Euu = paramdcy.Euu;
    localdcy.AFX.addAll(paramdcy.AFX);
    localdcy.fqj = paramdcy.fqj;
    localdcy.EuF = paramdcy.EuF;
    localdcy.EuG = paramdcy.EuG;
    AppMethodBeat.o(90977);
    return localdcy;
  }
  
  public static final dcy a(dsx paramdsx, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    dcy localdcy = new dcy();
    localdcy.qwV = UUID.randomUUID().toString();
    localdcy.Euz = new ddb();
    localdcy.Euz.title = paramdsx.oYb;
    localdcy.Euz.roQ = ("video-" + paramdsx.AGs);
    localdcy.Euz.rNP = paramdsx.AGs;
    localdcy.Euz.EuM = paramdsx.thumbUrl;
    if (bt.isNullOrNil(localdcy.Euz.EuM)) {
      localdcy.Euz.EuM = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramdsx.AGs + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localdcy.Euz.AGA = paramdsx.AGA;
    localdcy.Euz.source = paramdsx.source;
    localdcy.Euz.kqB = paramdsx.kqB;
    localdcy.Euz.EuP = paramdsx.AGt;
    localdcy.Euz.EuR = paramdsx.AGt;
    localdcy.Euz.AGy = paramdsx.AGy;
    if (paramdsx.AGE == 100203L)
    {
      localdcy.Euz.thumbWidth = 360;
      localdcy.Euz.thumbHeight = 640;
    }
    for (;;)
    {
      localdcy.Euz.timestamp = System.currentTimeMillis();
      if (!bt.isNullOrNil(paramdsx.AGD)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramdsx.AGD);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            ctk localctk = new ctk();
            localctk.id = localJSONObject.optString("id");
            localctk.doh = localJSONObject.optString("wording");
            localctk.Eld = localJSONObject.optLong("category");
            localctk.actionType = localJSONObject.optInt("actionType");
            localctk.url = localJSONObject.optString("url");
            localctk.title = localJSONObject.optString("title");
            localctk.lZG = localJSONObject.optString("subTitle");
            localctk.dub = localJSONObject.optString("icon");
            localdcy.Euz.rNO.add(localctk);
            i += 1;
            continue;
            localdcy.Euz.thumbWidth = 496;
            localdcy.Euz.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localdcy.Euu = paramdsx.AGs;
    localdcy.Euv = paramdsx.AGt;
    localdcy.Euw = paramdsx.AGu;
    localdcy.Eux = paramdsx.AGv;
    localdcy.Euy = paramdsx.AGE;
    if (localdcy.Euy <= 0L) {
      localdcy.Euy = 100201L;
    }
    localdcy.EuB = false;
    if (!bt.isNullOrNil(paramdsx.AGC)) {
      q(localdcy.AFX, paramdsx.AGC);
    }
    localdcy.jko = "";
    localdcy.scene = paramInt;
    localdcy.dcm = paramString;
    if (!bt.isNullOrNil(paramdsx.AGF))
    {
      localdcy.EuA = new ctk();
      localdcy.EuA.title = paramdsx.AGF;
    }
    AppMethodBeat.o(90974);
    return localdcy;
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
      localHashMap.put("ostype", d.CpG);
      paramString1 = k(localHashMap);
      AppMethodBeat.o(90983);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static final dcy aI(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    dcy localdcy = new dcy();
    localdcy.dcm = aa.w(paramMap, "query");
    localdcy.scene = aa.d(paramMap, "scene", 21);
    localdcy.qwV = UUID.randomUUID().toString();
    localdcy.jko = aa.w(paramMap, "searchId");
    if ((ay.isConnected(aj.getContext())) && (!ay.isWifi(aj.getContext()))) {
      localdcy.EuB = true;
    }
    Object localObject2 = aa.w(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(aa.w(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          ddd localddd = new ddd();
          localddd.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localddd);
          i += 1;
        }
      }
      if (bt.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localdcy.Euz = new ddb();
    localdcy.Euz.title = aa.w(paramMap, "title");
    localdcy.Euz.EuM = aa.w(paramMap, "thumbUrl");
    localdcy.Euz.xot = aa.d(paramMap, "mediaDuration", 0);
    localdcy.Euz.rNP = ((String)localObject2);
    localdcy.Euz.AGA = aa.w(paramMap, "strPlayCount");
    localdcy.Euz.oYa = aa.w(paramMap, "shareUrl");
    localdcy.Euz.oYb = aa.w(paramMap, "shareTitle");
    localdcy.Euz.AGB = aa.w(paramMap, "titleUrl");
    localdcy.Euz.rUO = aa.w(paramMap, "shareDesc");
    localdcy.Euz.AGx = aa.w(paramMap, "shareImgUrl");
    localdcy.Euz.AGy = aa.w(paramMap, "shareString");
    localdcy.Euz.AGz = aa.w(paramMap, "shareStringUrl");
    localdcy.Euz.source = aa.w(paramMap, "source");
    localdcy.Euz.kqB = aa.w(paramMap, "sourceUrl");
    localdcy.Euz.EuN = aa.a(paramMap, "relevant_category", -1L);
    localdcy.Euz.EuO = aa.w(paramMap, "shareOpenId");
    localdcy.Euz.roQ = aa.w(paramMap, "docID");
    localdcy.Euz.EuU = aa.a(paramMap, "videoSize", 0L);
    localdcy.Euz.timestamp = bt.GC();
    localdcy.Euz.EuQ = aa.d(paramMap, "itemType", 0);
    localdcy.Euz.EuW = aa.d(paramMap, "switchFlag", 0);
    if (bt.isNullOrNil(localdcy.Euz.EuM)) {
      localdcy.Euz.EuM = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdcy.Euz.rNP + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(aa.w(paramMap, "block"));
      localdcy.Euz.EuT = ((JSONObject)localObject2).optLong("resultType");
      localdcy.Euz.dcn = ((JSONObject)localObject2).optLong("type");
      label602:
      localdcy.Euz.EuP = aa.w(paramMap, "expand");
      localdcy.Euz.EuV.addAll((Collection)localObject1);
      localObject1 = gg((List)localObject1);
      if (localObject1 != null)
      {
        localdcy.Euz.videoUrl = ((ddd)localObject1).url;
        localdcy.Euz.Eve = ((ddd)localObject1).Eve;
      }
      localObject1 = aa.w(paramMap, "show_tag_list");
      if (!bt.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdcy.Euz.rNO.addAll(D((JSONArray)localObject1));
        label709:
        localdcy.Euy = localdcy.Euz.EuN;
        localdcy.Euv = aa.w(paramMap, "expand");
        localdcy.Euw = localdcy.jko;
        localdcy.Euu = localdcy.Euz.rNP;
        if (localdcy.Euy == 100203L)
        {
          localdcy.Euz.thumbWidth = 360;
          localdcy.Euz.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = aa.w(paramMap, "videoChannelTitle");
          if ((!bt.isNullOrNil(localdcy.Euz.AGy)) && ((localdcy.Euy == 100202L) || (localdcy.Euy == 100204L) || (localdcy.Euy == 100205L)))
          {
            localdcy.EuA = new ctk();
            localdcy.EuA.title = ((String)localObject1);
          }
          paramMap = aa.w(paramMap, "extReqParams");
          if (!bt.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new xp();
                ((xp)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((xp)localObject2).CZi = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((xp)localObject2).CZj = ((JSONObject)localObject1).optString("textValue", "");
                localdcy.AFX.add(localObject2);
                i += 1;
                continue;
                localdcy.Euz.thumbWidth = 496;
                localdcy.Euz.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localdcy;
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
  
  public static final dcy aJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    dcy localdcy = new dcy();
    localdcy.dcm = paramJSONObject.optString("query", "");
    localdcy.scene = paramJSONObject.optInt("scene", 21);
    localdcy.qwV = UUID.randomUUID().toString();
    localdcy.Euw = paramJSONObject.optString("searchId", "");
    if ((ay.isConnected(aj.getContext())) && (!ay.isWifi(aj.getContext()))) {
      localdcy.EuB = true;
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
          ddd localddd = new ddd();
          localddd.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localddd);
          i += 1;
        }
      }
      if (bt.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localdcy.Euz = new ddb();
    localdcy.Euz.title = paramJSONObject.optString("title", "");
    localdcy.Euz.EuM = paramJSONObject.optString("thumbUrl", "");
    localdcy.Euz.xot = paramJSONObject.optInt("mediaDuration", 0);
    localdcy.Euz.rNP = ((String)localObject2);
    localdcy.Euz.AGA = paramJSONObject.optString("strPlayCount", "");
    localdcy.Euz.oYa = paramJSONObject.optString("shareUrl", "");
    localdcy.Euz.oYb = paramJSONObject.optString("shareTitle", "");
    localdcy.Euz.AGB = paramJSONObject.optString("titleUrl", "");
    localdcy.Euz.rUO = paramJSONObject.optString("shareDesc", "");
    localdcy.Euz.AGx = paramJSONObject.optString("shareImgUrl", "");
    localdcy.Euz.AGy = paramJSONObject.optString("shareString", "");
    localdcy.Euz.AGz = paramJSONObject.optString("shareStringUrl", "");
    localdcy.Euz.source = paramJSONObject.optString("source", "");
    localdcy.Euz.kqB = paramJSONObject.optString("sourceUrl", "");
    localdcy.Euz.EuN = paramJSONObject.optInt("relevant_category", -1);
    localdcy.Euz.EuO = paramJSONObject.optString("shareOpenId", "");
    localdcy.Euz.roQ = paramJSONObject.optString("docID", "");
    localdcy.Euz.EuU = paramJSONObject.optInt("videoSize", 0);
    localdcy.Euz.timestamp = bt.GC();
    localdcy.Euz.EuQ = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localdcy.Euz.EuT = ((JSONObject)localObject2).optLong("resultType");
      localdcy.Euz.dcn = ((JSONObject)localObject2).optLong("type");
      label578:
      localdcy.Euz.EuP = paramJSONObject.optString("expand", "");
      localdcy.Euz.EuV.addAll((Collection)localObject1);
      localObject1 = gg((List)localObject1);
      if (localObject1 != null)
      {
        localdcy.Euz.videoUrl = ((ddd)localObject1).url;
        localdcy.Euz.Eve = ((ddd)localObject1).Eve;
      }
      if (bt.isNullOrNil(localdcy.Euz.EuM)) {
        localdcy.Euz.EuM = ("http://shp.qpic.cn/qqvideo_ori/0/" + localdcy.Euz.rNP + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bt.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localdcy.Euz.rNO.addAll(D((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localdcy.Euz.Evd = new dcz();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localdcy.Euz.Evd.EuI = ((JSONObject)localObject1).optString("detailWording");
            localdcy.Euz.Evd.EuJ = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new ahk();
                ((ahk)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((ahk)localObject2).doh = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localdcy.Euz.Evd.EuK.add(localObject2);
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
          localdcy.Euz.rNO.addAll(D((JSONArray)localObject1));
          label963:
          localdcy.Euy = localdcy.Euz.EuN;
          localdcy.Euv = paramJSONObject.optString("expand", "");
          localdcy.jko = "";
          localdcy.Euu = localdcy.Euz.rNP;
          localdcy.Euz.EuW = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localdcy.Euz;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((ddb)localObject1).Evb = bool;
            localObject2 = localdcy.Euz;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((ddb)localObject2).Evc = ((String)localObject1);
            if (localdcy.Euy != 100203L) {
              break label1419;
            }
            localdcy.Euz.thumbWidth = 360;
          }
          for (localdcy.Euz.thumbHeight = 640;; localdcy.Euz.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localdcy.Euz.EuY = new dcw();
                localdcy.Euz.EuY.Euo = ((JSONObject)localObject1).optInt("videoSecondType");
                localdcy.Euz.EuY.Euq = ((JSONObject)localObject1).optInt("requestDuration");
                localdcy.Euz.EuY.Eur = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!bt.isNullOrNil((String)localObject1)) && ((localdcy.Euy == 100202L) || (localdcy.Euy == 100204L) || (localdcy.Euy == 100205L)))
              {
                localdcy.EuA = new ctk();
                localdcy.EuA.title = ((String)localObject1);
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
                  xp localxp = new xp();
                  localxp.key = ((JSONObject)localObject2).optString("key", "");
                  localxp.CZi = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localxp.CZj = ((JSONObject)localObject2).optString("textValue", "");
                  localdcy.AFX.add(localxp);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localdcy.Euz.thumbWidth = 496;
          }
          localdcy.EuF = paramJSONObject.optString("preNetType", "");
          if (localdcy.EuF.equals("wangka")) {
            localdcy.EuG = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localdcy;
            if ((localdcy.EuF.equals("2g")) || (localdcy.EuF.equals("3g")) || (localdcy.EuF.equals("4g"))) {
              localdcy.EuG = 2;
            } else {
              localdcy.EuG = 0;
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
  
  public static String asy(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = aj.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static String dNS()
  {
    AppMethodBeat.i(90978);
    String str = aj.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean dNT()
  {
    AppMethodBeat.i(90980);
    if (1 >= ad.getLogLevel())
    {
      AppMethodBeat.o(90980);
      return true;
    }
    AppMethodBeat.o(90980);
    return false;
  }
  
  public static String dNU()
  {
    AppMethodBeat.i(90986);
    String str = b.aia().replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String dNV()
  {
    AppMethodBeat.i(90987);
    String str = b.aia().replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean dNW()
  {
    AppMethodBeat.i(90988);
    int i = ((a)g.ab(a.class)).cPe();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      ad.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(90988);
      return bool;
    }
  }
  
  public static String dNX()
  {
    AppMethodBeat.i(90989);
    if (ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(90989);
      return "wifi";
    }
    if (dNW())
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
  
  public static final ddd gg(List<ddd> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ddd localddd = (ddd)paramList.next();
      if ((localddd != null) && (!bt.isNullOrNil(localddd.url)))
      {
        AppMethodBeat.o(90973);
        return localddd;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray gh(List<ctk> paramList)
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
        ctk localctk = (ctk)paramList.get(i);
        localJSONObject.put("id", localctk.id);
        localJSONObject.put("wording", localctk.doh);
        localJSONObject.put("category", localctk.Eld);
        localJSONObject.put("actionType", localctk.actionType);
        localJSONObject.put("url", localctk.url);
        localJSONObject.put("title", localctk.title);
        localJSONObject.put("subTitle", localctk.lZG);
        localJSONObject.put("icon", localctk.dub);
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
    paramHashMap.put("lang", ac.ir(aj.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(aa.RZ(1).axp()));
    paramHashMap.put("netType", aa.cWN());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", com.tencent.mm.sdk.platformtools.h.glW);
    AppMethodBeat.o(90985);
  }
  
  public static String k(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    h(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aa.RZ(1).eil());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(aa.aS(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  public static final void q(List<xp> paramList, String paramString)
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
          xp localxp = new xp();
          localxp.key = localJSONObject.optString("key", "");
          localxp.CZi = localJSONObject.optInt("uintValue", 0);
          localxp.CZj = localJSONObject.optString("textValue", "");
          paramList.add(localxp);
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