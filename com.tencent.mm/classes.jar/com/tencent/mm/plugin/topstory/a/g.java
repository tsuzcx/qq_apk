package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.io.File;
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

public final class g
{
  private static List<ccp> B(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96360);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      ccp localccp = new ccp();
      localccp.id = localJSONObject.optString("id", "");
      localccp.cyA = localJSONObject.optString("wording", "");
      localccp.xNd = localJSONObject.optLong("category", 0L);
      localccp.actionType = localJSONObject.optInt("actionType", 0);
      localccp.url = localJSONObject.optString("url", "");
      localccp.title = localJSONObject.optString("title", "");
      localccp.jjP = localJSONObject.optString("subTitle", "");
      localccp.cDz = localJSONObject.optString("icon", "");
      localArrayList.add(localccp);
      i += 1;
    }
    AppMethodBeat.o(96360);
    return localArrayList;
  }
  
  public static boolean T(File paramFile)
  {
    AppMethodBeat.i(96364);
    if (paramFile.exists()) {
      try
      {
        paramFile = FileOp.cS(paramFile.getAbsolutePath());
        if (!bo.isNullOrNil(paramFile))
        {
          boolean bool = paramFile.contains("default#default");
          if (bool)
          {
            AppMethodBeat.o(96364);
            return false;
          }
          AppMethodBeat.o(96364);
          return true;
        }
        AppMethodBeat.o(96364);
        return false;
      }
      catch (Exception paramFile)
      {
        AppMethodBeat.o(96364);
        return false;
      }
    }
    AppMethodBeat.o(96364);
    return false;
  }
  
  public static final ckw a(ckw paramckw)
  {
    AppMethodBeat.i(96355);
    ckw localckw = new ckw();
    localckw.xUt = paramckw.xUt;
    localckw.scene = paramckw.scene;
    localckw.cnv = paramckw.cnv;
    localckw.hng = paramckw.hng;
    localckw.xUP = paramckw.xUP;
    localckw.xUO = paramckw.xUO;
    localckw.xUL = paramckw.xUL;
    localckw.xUM = paramckw.xUM;
    localckw.xUN = paramckw.xUN;
    localckw.xUK = paramckw.xUK;
    localckw.uIO.addAll(paramckw.uIO);
    localckw.efg = paramckw.efg;
    localckw.xUV = paramckw.xUV;
    localckw.xUW = paramckw.xUW;
    AppMethodBeat.o(96355);
    return localckw;
  }
  
  public static final ckw a(cyl paramcyl, int paramInt, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(96352);
    ckw localckw = new ckw();
    localckw.xUt = UUID.randomUUID().toString();
    localckw.xUP = new ckx();
    localckw.xUP.title = paramcyl.lHr;
    localckw.xUP.uKI = ("video-" + paramcyl.uJi);
    localckw.xUP.xVa = paramcyl.uJi;
    localckw.xUP.xUY = paramcyl.thumbUrl;
    if (bo.isNullOrNil(localckw.xUP.xUY)) {
      localckw.xUP.xUY = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramcyl.uJi + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localckw.xUP.uJq = paramcyl.uJq;
    localckw.xUP.source = paramcyl.source;
    localckw.xUP.puE = paramcyl.puE;
    localckw.xUP.xVd = paramcyl.uJj;
    localckw.xUP.xVf = paramcyl.uJj;
    localckw.xUP.uJo = paramcyl.uJo;
    if (paramcyl.uJu == 100203L)
    {
      localckw.xUP.fgR = 360;
      localckw.xUP.fgQ = 640;
    }
    int i;
    JSONObject localJSONObject;
    Object localObject;
    for (;;)
    {
      localckw.xUP.timestamp = System.currentTimeMillis();
      if (!bo.isNullOrNil(paramcyl.uJt)) {
        try
        {
          JSONArray localJSONArray1 = new JSONArray(paramcyl.uJt);
          i = 0;
          while (i < localJSONArray1.length())
          {
            localJSONObject = localJSONArray1.getJSONObject(i);
            localObject = new ccp();
            ((ccp)localObject).id = localJSONObject.optString("id");
            ((ccp)localObject).cyA = localJSONObject.optString("wording");
            ((ccp)localObject).xNd = localJSONObject.optLong("category");
            ((ccp)localObject).actionType = localJSONObject.optInt("actionType");
            ((ccp)localObject).url = localJSONObject.optString("url");
            ((ccp)localObject).title = localJSONObject.optString("title");
            ((ccp)localObject).jjP = localJSONObject.optString("subTitle");
            ((ccp)localObject).cDz = localJSONObject.optString("icon");
            localckw.xUP.wVo.add(localObject);
            i += 1;
            continue;
            localckw.xUP.fgR = 496;
            localckw.xUP.fgQ = 280;
          }
        }
        catch (Exception localException1) {}
      }
    }
    localckw.xUK = paramcyl.uJi;
    localckw.xUL = paramcyl.uJj;
    localckw.xUM = paramcyl.uJk;
    localckw.xUN = paramcyl.uJl;
    localckw.xUO = paramcyl.uJu;
    if (localckw.xUO <= 0L) {
      localckw.xUO = 100201L;
    }
    localckw.xUR = false;
    if (!bo.isNullOrNil(paramcyl.uJs)) {
      try
      {
        JSONArray localJSONArray2 = new JSONArray(paramcyl.uJs);
        i = j;
        while (i < localJSONArray2.length())
        {
          localJSONObject = localJSONArray2.getJSONObject(i);
          localObject = new up();
          ((up)localObject).key = localJSONObject.optString("key", "");
          ((up)localObject).wMM = localJSONObject.optInt("uintValue", 0);
          ((up)localObject).wMN = localJSONObject.optString("textValue", "");
          localckw.uIO.add(localObject);
          i += 1;
        }
        localckw.hng = "";
      }
      catch (Exception localException2) {}
    }
    localckw.scene = paramInt;
    localckw.cnv = paramString;
    if (!bo.isNullOrNil(paramcyl.uJv))
    {
      localckw.xUQ = new ccp();
      localckw.xUQ.title = paramcyl.uJv;
    }
    AppMethodBeat.o(96352);
    return localckw;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6)
  {
    AppMethodBeat.i(155512);
    HashMap localHashMap = new HashMap();
    if (!bo.isNullOrNil(paramString4)) {
      localHashMap.put("redPointMsgId", paramString4);
    }
    if (!bo.isNullOrNil(paramString1)) {
      localHashMap.put("sessionId", paramString1);
    }
    if (!bo.isNullOrNil(paramString2)) {
      localHashMap.put("query", paramString2);
    }
    if (!bo.isNullOrNil(paramString3))
    {
      localHashMap.put("requestId", paramString3);
      localHashMap.put("pRequestId", paramString3);
      localHashMap.put("seq", paramString3);
    }
    localHashMap.put("scene", String.valueOf(paramInt1));
    if (!bo.isNullOrNil(paramString5)) {
      localHashMap.put("tabInfo", paramString5);
    }
    if (paramInt2 > 0) {
      localHashMap.put("contentReddot", String.valueOf(paramInt2));
    }
    if (paramInt3 > 0) {
      localHashMap.put("numberReddot", String.valueOf(paramInt3));
    }
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSx, 0) == 1) {
      localHashMap.put("profile", "1");
    }
    if (!bo.isNullOrNil(paramString6)) {
      localHashMap.put("homeMsgId", paramString6);
    }
    try
    {
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.whD);
      paramString1 = o(localHashMap);
      AppMethodBeat.o(155512);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", paramString1, "", new Object[0]);
      }
    }
  }
  
  public static String aef(String paramString)
  {
    AppMethodBeat.i(96357);
    paramString = ah.getContext().getCacheDir() + "topstory/" + paramString + "/";
    AppMethodBeat.o(96357);
    return paramString;
  }
  
  public static final ckw ag(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(96354);
    ckw localckw = new ckw();
    localckw.cnv = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    localckw.scene = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 21);
    localckw.xUt = UUID.randomUUID().toString();
    localckw.hng = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
    if ((at.isConnected(ah.getContext())) && (!at.isWifi(ah.getContext()))) {
      localckw.xUR = true;
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          ckz localckz = new ckz();
          localckz.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localckz);
          i += 1;
        }
      }
      if (bo.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localckw.xUP = new ckx();
    localckw.xUP.title = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "title");
    localckw.xUP.xUY = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "thumbUrl");
    localckw.xUP.xUZ = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "mediaDuration", 0);
    localckw.xUP.xVa = ((String)localObject2);
    localckw.xUP.uJq = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "strPlayCount");
    localckw.xUP.lHq = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareUrl");
    localckw.xUP.lHr = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareTitle");
    localckw.xUP.uJr = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "titleUrl");
    localckw.xUP.rrm = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareDesc");
    localckw.xUP.uJn = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareImgUrl");
    localckw.xUP.uJo = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareString");
    localckw.xUP.uJp = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareStringUrl");
    localckw.xUP.source = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "source");
    localckw.xUP.puE = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sourceUrl");
    localckw.xUP.xVb = com.tencent.mm.plugin.websearch.api.aa.a(paramMap, "relevant_category", -1L);
    localckw.xUP.xVc = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "shareOpenId");
    localckw.xUP.uKI = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "docID");
    localckw.xUP.xVi = com.tencent.mm.plugin.websearch.api.aa.a(paramMap, "videoSize", 0L);
    localckw.xUP.timestamp = bo.yB();
    localckw.xUP.xVe = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "itemType", 0);
    localckw.xUP.xVl = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "switchFlag", 0);
    if (bo.isNullOrNil(localckw.xUP.xUY)) {
      localckw.xUP.xUY = ("http://shp.qpic.cn/qqvideo_ori/0/" + localckw.xUP.xVa + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "block"));
      localckw.xUP.xVh = ((JSONObject)localObject2).optLong("resultType");
      localckw.xUP.cnw = ((JSONObject)localObject2).optLong("type");
      label602:
      localckw.xUP.xVd = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "expand");
      localckw.xUP.xVj.addAll((Collection)localObject1);
      localObject1 = dQ((List)localObject1);
      if (localObject1 != null)
      {
        localckw.xUP.videoUrl = ((ckz)localObject1).url;
        localckw.xUP.xVo = ((ckz)localObject1).xVo;
      }
      localObject1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "show_tag_list");
      if (!bo.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localckw.xUP.wVo.addAll(B((JSONArray)localObject1));
        label709:
        localckw.xUO = localckw.xUP.xVb;
        localckw.xUL = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "expand");
        localckw.xUM = localckw.hng;
        localckw.xUK = localckw.xUP.xVa;
        if (localckw.xUO == 100203L)
        {
          localckw.xUP.fgR = 360;
          localckw.xUP.fgQ = 640;
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "videoChannelTitle");
          if ((!bo.isNullOrNil(localckw.xUP.uJo)) && ((localckw.xUO == 100202L) || (localckw.xUO == 100204L) || (localckw.xUO == 100205L)))
          {
            localckw.xUQ = new ccp();
            localckw.xUQ.title = ((String)localObject1);
          }
          paramMap = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "extReqParams");
          if (!bo.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new up();
                ((up)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((up)localObject2).wMM = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((up)localObject2).wMN = ((JSONObject)localObject1).optString("textValue", "");
                localckw.uIO.add(localObject2);
                i += 1;
                continue;
                localckw.xUP.fgR = 496;
                localckw.xUP.fgQ = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(96354);
        return localckw;
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
  
  public static final ckw ar(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96353);
    ckw localckw = new ckw();
    localckw.cnv = paramJSONObject.optString("query", "");
    localckw.scene = paramJSONObject.optInt("scene", 21);
    localckw.xUt = UUID.randomUUID().toString();
    localckw.xUM = paramJSONObject.optString("searchId", "");
    if ((at.isConnected(ah.getContext())) && (!at.isWifi(ah.getContext()))) {
      localckw.xUR = true;
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
          ckz localckz = new ckz();
          localckz.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localckz);
          i += 1;
        }
      }
      if (bo.isNullOrNil((String)localObject2)) {
        break label1344;
      }
    }
    catch (JSONException localJSONException3) {}
    localckw.xUP = new ckx();
    localckw.xUP.title = paramJSONObject.optString("title", "");
    localckw.xUP.xUY = paramJSONObject.optString("thumbUrl", "");
    localckw.xUP.xUZ = paramJSONObject.optInt("mediaDuration", 0);
    localckw.xUP.xVa = ((String)localObject2);
    localckw.xUP.uJq = paramJSONObject.optString("strPlayCount", "");
    localckw.xUP.lHq = paramJSONObject.optString("shareUrl", "");
    localckw.xUP.lHr = paramJSONObject.optString("shareTitle", "");
    localckw.xUP.uJr = paramJSONObject.optString("titleUrl", "");
    localckw.xUP.rrm = paramJSONObject.optString("shareDesc", "");
    localckw.xUP.uJn = paramJSONObject.optString("shareImgUrl", "");
    localckw.xUP.uJo = paramJSONObject.optString("shareString", "");
    localckw.xUP.uJp = paramJSONObject.optString("shareStringUrl", "");
    localckw.xUP.source = paramJSONObject.optString("source", "");
    localckw.xUP.puE = paramJSONObject.optString("sourceUrl", "");
    localckw.xUP.xVb = paramJSONObject.optInt("relevant_category", -1);
    localckw.xUP.xVc = paramJSONObject.optString("shareOpenId", "");
    localckw.xUP.uKI = paramJSONObject.optString("docID", "");
    localckw.xUP.xVi = paramJSONObject.optInt("videoSize", 0);
    localckw.xUP.timestamp = bo.yB();
    localckw.xUP.xVe = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localckw.xUP.xVh = ((JSONObject)localObject2).optLong("resultType");
      localckw.xUP.cnw = ((JSONObject)localObject2).optLong("type");
      label578:
      localckw.xUP.xVd = paramJSONObject.optString("expand", "");
      localckw.xUP.xVj.addAll((Collection)localObject1);
      localObject1 = dQ((List)localObject1);
      if (localObject1 != null)
      {
        localckw.xUP.videoUrl = ((ckz)localObject1).url;
        localckw.xUP.xVo = ((ckz)localObject1).xVo;
      }
      if (bo.isNullOrNil(localckw.xUP.xUY)) {
        localckw.xUP.xUY = ("http://shp.qpic.cn/qqvideo_ori/0/" + localckw.xUP.xVa + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bo.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localckw.xUP.wVo.addAll(B((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new adl();
                ((adl)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((adl)localObject2).cyA = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localckw.xUP.xVk.add(localObject2);
                i += 1;
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("show_tag_list", "");
        if (!bo.isNullOrNil((String)localObject1)) {}
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          localckw.xUP.wVo.addAll(B((JSONArray)localObject1));
          label909:
          localckw.xUO = localckw.xUP.xVb;
          localckw.xUL = paramJSONObject.optString("expand", "");
          localckw.hng = "";
          localckw.xUK = localckw.xUP.xVa;
          localckw.xUP.xVl = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localckw.xUP;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((ckx)localObject1).xVp = bool;
            localObject2 = localckw.xUP;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1278;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1044:
            ((ckx)localObject2).xVq = ((String)localObject1);
            if (localckw.xUO != 100203L) {
              break label1284;
            }
            localckw.xUP.fgR = 360;
          }
          for (localckw.xUP.fgQ = 640;; localckw.xUP.fgQ = 280)
          {
            label1284:
            for (;;)
            {
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!bo.isNullOrNil((String)localObject1)) && ((localckw.xUO == 100202L) || (localckw.xUO == 100204L) || (localckw.xUO == 100205L)))
              {
                localckw.xUQ = new ccp();
                localckw.xUQ.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (bo.isNullOrNil((String)localObject1)) {
                break;
              }
              label1278:
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                i = 0;
                while (i < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                  up localup = new up();
                  localup.key = ((JSONObject)localObject2).optString("key", "");
                  localup.wMM = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localup.wMN = ((JSONObject)localObject2).optString("textValue", "");
                  localckw.uIO.add(localup);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1044;
            localckw.xUP.fgR = 496;
          }
          localckw.xUV = paramJSONObject.optString("preNetType", "");
          if (localckw.xUV.equals("wangka")) {
            localckw.xUW = 1;
          }
          for (;;)
          {
            label1344:
            AppMethodBeat.o(96353);
            return localckw;
            if ((localckw.xUV.equals("2g")) || (localckw.xUV.equals("3g")) || (localckw.xUV.equals("4g"))) {
              localckw.xUW = 2;
            } else {
              localckw.xUW = 0;
            }
          }
        }
        catch (JSONException localJSONException1)
        {
          break label909;
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
  
  public static String cIA()
  {
    AppMethodBeat.i(96368);
    if (at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(96368);
      return "wifi";
    }
    if (cIz())
    {
      AppMethodBeat.o(96368);
      return "wangka";
    }
    if (at.is4G(ah.getContext()))
    {
      AppMethodBeat.o(96368);
      return "4g";
    }
    if (at.is3G(ah.getContext()))
    {
      AppMethodBeat.o(96368);
      return "3g";
    }
    if (at.is2G(ah.getContext()))
    {
      AppMethodBeat.o(96368);
      return "2g";
    }
    if (!at.isConnected(ah.getContext()))
    {
      AppMethodBeat.o(96368);
      return "fail";
    }
    AppMethodBeat.o(96368);
    return "";
  }
  
  public static String cIv()
  {
    AppMethodBeat.i(96356);
    String str = ah.getContext().getCacheDir() + "topstory/";
    AppMethodBeat.o(96356);
    return str;
  }
  
  public static boolean cIw()
  {
    AppMethodBeat.i(96358);
    if (1 >= ab.getLogLevel())
    {
      AppMethodBeat.o(96358);
      return true;
    }
    AppMethodBeat.o(96358);
    return false;
  }
  
  public static String cIx()
  {
    AppMethodBeat.i(96365);
    String str = e.eQw.replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(96365);
    return str;
  }
  
  public static String cIy()
  {
    AppMethodBeat.i(96366);
    String str = e.eQw.replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(96366);
    return str;
  }
  
  public static boolean cIz()
  {
    AppMethodBeat.i(96367);
    int i = ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.misc.a.a.class)).bQj();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      ab.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(96367);
      return bool;
    }
  }
  
  public static final ckz dQ(List<ckz> paramList)
  {
    AppMethodBeat.i(96351);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ckz localckz = (ckz)paramList.next();
      if ((localckz != null) && (!bo.isNullOrNil(localckz.url)))
      {
        AppMethodBeat.o(96351);
        return localckz;
      }
    }
    AppMethodBeat.o(96351);
    return null;
  }
  
  public static JSONArray dR(List<ccp> paramList)
  {
    AppMethodBeat.i(96359);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        ccp localccp = (ccp)paramList.get(i);
        localJSONObject.put("id", localccp.id);
        localJSONObject.put("wording", localccp.cyA);
        localJSONObject.put("category", localccp.xNd);
        localJSONObject.put("actionType", localccp.actionType);
        localJSONObject.put("url", localccp.url);
        localJSONObject.put("title", localccp.title);
        localJSONObject.put("subTitle", localccp.jjP);
        localJSONObject.put("icon", localccp.cDz);
        localJSONArray.put(localJSONObject);
        label148:
        i += 1;
        continue;
        AppMethodBeat.o(96359);
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label148;
      }
    }
  }
  
  public static String o(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(96362);
    p(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.aa.Ja(1).aLw());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.aa.an(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(96362);
    return paramHashMap;
  }
  
  private static void p(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(96363);
    paramHashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.aa.Ja(1).agn()));
    paramHashMap.put("netType", com.tencent.mm.plugin.websearch.api.aa.bXn());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", f.CLIENT_VERSION);
    AppMethodBeat.o(96363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.g
 * JD-Core Version:    0.7.0.1
 */