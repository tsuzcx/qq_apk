package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
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
  public static boolean L(File paramFile)
  {
    if (paramFile.exists()) {}
    try
    {
      paramFile = FileOp.bP(paramFile.getAbsolutePath());
      boolean bool;
      if (!bk.bl(paramFile)) {
        bool = paramFile.contains("default#default");
      }
      return !bool;
    }
    catch (Exception paramFile) {}
    return false;
  }
  
  public static final byf M(Map<String, Object> paramMap)
  {
    int j = 0;
    byf localbyf = new byf();
    localbyf.bGm = aa.s(paramMap, "query");
    localbyf.scene = aa.c(paramMap, "scene", 21);
    localbyf.tNY = UUID.randomUUID().toString();
    localbyf.fTF = aa.s(paramMap, "searchId");
    if ((aq.isConnected(ae.getContext())) && (!aq.isWifi(ae.getContext()))) {
      localbyf.tOr = true;
    }
    Object localObject2 = aa.s(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(aa.s(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          ((ArrayList)localObject1).add(localJSONArray.getString(i));
          i += 1;
        }
      }
      if (bk.bl((String)localObject2)) {
        break label803;
      }
    }
    catch (JSONException localJSONException3) {}
    localbyf.tOp = new byg();
    localbyf.tOp.title = aa.s(paramMap, "title");
    localbyf.tOp.tOv = aa.s(paramMap, "thumbUrl");
    localbyf.tOp.tOw = aa.c(paramMap, "mediaDuration", 0);
    localbyf.tOp.tOx = ((String)localObject2);
    localbyf.tOp.dQQ = 496;
    localbyf.tOp.dQP = 280;
    localbyf.tOp.qUg = aa.s(paramMap, "strPlayCount");
    localbyf.tOp.jxR = aa.s(paramMap, "shareUrl");
    localbyf.tOp.jxS = aa.s(paramMap, "shareTitle");
    localbyf.tOp.qUh = aa.s(paramMap, "titleUrl");
    localbyf.tOp.oBT = aa.s(paramMap, "shareDesc");
    localbyf.tOp.qUd = aa.s(paramMap, "shareImgUrl");
    localbyf.tOp.qUe = aa.s(paramMap, "shareString");
    localbyf.tOp.qUf = aa.s(paramMap, "shareStringUrl");
    localbyf.tOp.aWf = aa.s(paramMap, "source");
    localbyf.tOp.mSy = aa.s(paramMap, "sourceUrl");
    localbyf.tOp.tOy = aa.a(paramMap, "relevant_category", -1L);
    localbyf.tOp.tOz = aa.s(paramMap, "shareOpenId");
    localbyf.tOp.qVw = aa.s(paramMap, "docID");
    localbyf.tOp.tOF = aa.a(paramMap, "videoSize", 0L);
    localbyf.tOp.timestamp = bk.UZ();
    localbyf.tOp.tOB = aa.c(paramMap, "itemType", 0);
    if (bk.bl(localbyf.tOp.tOv)) {
      localbyf.tOp.tOv = ("http://shp.qpic.cn/qqvideo_ori/0/" + localbyf.tOp.tOx + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(aa.s(paramMap, "block"));
      localbyf.tOp.tOE = ((JSONObject)localObject2).optLong("resultType");
      localbyf.tOp.bGn = ((JSONObject)localObject2).optLong("type");
      label564:
      localbyf.tOp.tOA = aa.s(paramMap, "expand");
      localbyf.tOp.tOG.addAll((Collection)localObject1);
      localbyf.tOp.videoUrl = cO((List)localObject1);
      localObject1 = aa.s(paramMap, "show_tag_list");
      if (!bk.bl((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localbyf.tOp.sXo.addAll(w((JSONArray)localObject1));
        label647:
        localbyf.tOo = localbyf.tOp.tOy;
        localbyf.tOl = aa.s(paramMap, "expand");
        localbyf.tOm = localbyf.fTF;
        localbyf.tOk = localbyf.tOp.tOx;
        paramMap = aa.s(paramMap, "extReqParams");
        if (!bk.bl(paramMap)) {
          try
          {
            paramMap = new JSONArray(paramMap);
            i = j;
            while (i < paramMap.length())
            {
              localObject1 = paramMap.getJSONObject(i);
              localObject2 = new rb();
              ((rb)localObject2).key = ((JSONObject)localObject1).optString("key", "");
              ((rb)localObject2).sOI = ((JSONObject)localObject1).optInt("uintValue", 0);
              ((rb)localObject2).sOJ = ((JSONObject)localObject1).optString("textValue", "");
              localbyf.qTG.add(localObject2);
              i += 1;
            }
            return localbyf;
          }
          catch (Exception paramMap) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        label803:
        break label647;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label564;
    }
  }
  
  public static String PJ(String paramString)
  {
    return ae.getContext().getCacheDir() + "topstory/" + paramString + "/";
  }
  
  public static final byf a(byf parambyf)
  {
    byf localbyf = new byf();
    localbyf.tNY = parambyf.tNY;
    localbyf.scene = parambyf.scene;
    localbyf.bGm = parambyf.bGm;
    localbyf.fTF = parambyf.fTF;
    localbyf.tOp = parambyf.tOp;
    localbyf.tOo = parambyf.tOo;
    localbyf.tOl = parambyf.tOl;
    localbyf.tOm = parambyf.tOm;
    localbyf.tOn = parambyf.tOn;
    localbyf.tOk = parambyf.tOk;
    localbyf.qTG.addAll(parambyf.qTG);
    localbyf.dnJ = parambyf.dnJ;
    return localbyf;
  }
  
  public static final byf a(ckw paramckw, int paramInt, String paramString)
  {
    int j = 0;
    byf localbyf = new byf();
    localbyf.tNY = UUID.randomUUID().toString();
    localbyf.tOp = new byg();
    localbyf.tOp.title = paramckw.jxS;
    localbyf.tOp.qVw = ("video-" + paramckw.qTY);
    localbyf.tOp.tOx = paramckw.qTY;
    localbyf.tOp.tOv = paramckw.thumbUrl;
    if (bk.bl(localbyf.tOp.tOv)) {
      localbyf.tOp.tOv = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramckw.qTY + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localbyf.tOp.qUg = paramckw.qUg;
    localbyf.tOp.aWf = paramckw.aWf;
    localbyf.tOp.mSy = paramckw.mSy;
    localbyf.tOp.tOA = paramckw.qTZ;
    localbyf.tOp.tOC = paramckw.qTZ;
    localbyf.tOp.qUe = paramckw.qUe;
    localbyf.tOp.dQQ = 496;
    localbyf.tOp.dQP = 280;
    localbyf.tOp.timestamp = System.currentTimeMillis();
    int i;
    Object localObject;
    if (!bk.bl(paramckw.qUj)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramckw.qUj);
        i = 0;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          bse localbse = new bse();
          localbse.id = ((JSONObject)localObject).optString("id");
          localbse.bQZ = ((JSONObject)localObject).optString("wording");
          localbse.tIP = ((JSONObject)localObject).optLong("category");
          localbse.actionType = ((JSONObject)localObject).optInt("actionType");
          localbse.url = ((JSONObject)localObject).optString("url");
          localbse.title = ((JSONObject)localObject).optString("title");
          localbse.imV = ((JSONObject)localObject).optString("subTitle");
          localbse.bVO = ((JSONObject)localObject).optString("icon");
          localbyf.tOp.sXo.add(localbse);
          i += 1;
        }
        localbyf.tOk = paramckw.qTY;
      }
      catch (Exception localException) {}
    }
    localbyf.tOl = paramckw.qTZ;
    localbyf.tOm = paramckw.qUa;
    localbyf.tOn = paramckw.qUb;
    localbyf.tOo = paramckw.qUk;
    if (localbyf.tOo <= 0L) {
      localbyf.tOo = 100201L;
    }
    localbyf.tOr = false;
    if (!bk.bl(paramckw.qUi)) {
      try
      {
        paramckw = new JSONArray(paramckw.qUi);
        i = j;
        while (i < paramckw.length())
        {
          JSONObject localJSONObject = paramckw.getJSONObject(i);
          localObject = new rb();
          ((rb)localObject).key = localJSONObject.optString("key", "");
          ((rb)localObject).sOI = localJSONObject.optInt("uintValue", 0);
          ((rb)localObject).sOJ = localJSONObject.optString("textValue", "");
          localbyf.qTG.add(localObject);
          i += 1;
        }
        localbyf.fTF = "";
      }
      catch (Exception paramckw) {}
    }
    localbyf.scene = paramInt;
    localbyf.bGm = paramString;
    return localbyf;
  }
  
  public static final byf ai(JSONObject paramJSONObject)
  {
    int j = 0;
    byf localbyf = new byf();
    localbyf.bGm = paramJSONObject.optString("query", "");
    localbyf.scene = paramJSONObject.optInt("scene", 21);
    localbyf.tNY = UUID.randomUUID().toString();
    localbyf.fTF = paramJSONObject.optString("searchId", "");
    if ((aq.isConnected(ae.getContext())) && (!aq.isWifi(ae.getContext()))) {
      localbyf.tOr = true;
    }
    Object localObject3 = paramJSONObject.optString("videoId", "");
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
          ((ArrayList)localObject1).add(localJSONArray.getString(i));
          i += 1;
        }
      }
      if (bk.bl((String)localObject3)) {
        break label1047;
      }
    }
    catch (JSONException localJSONException4) {}
    localbyf.tOp = new byg();
    localbyf.tOp.title = paramJSONObject.optString("title", "");
    localbyf.tOp.tOv = paramJSONObject.optString("thumbUrl", "");
    localbyf.tOp.tOw = paramJSONObject.optInt("mediaDuration", 0);
    localbyf.tOp.tOx = ((String)localObject3);
    localbyf.tOp.dQQ = 496;
    localbyf.tOp.dQP = 280;
    localbyf.tOp.qUg = paramJSONObject.optString("strPlayCount", "");
    localbyf.tOp.jxR = paramJSONObject.optString("shareUrl", "");
    localbyf.tOp.jxS = paramJSONObject.optString("shareTitle", "");
    localbyf.tOp.qUh = paramJSONObject.optString("titleUrl", "");
    localbyf.tOp.oBT = paramJSONObject.optString("shareDesc", "");
    localbyf.tOp.qUd = paramJSONObject.optString("shareImgUrl", "");
    localbyf.tOp.qUe = paramJSONObject.optString("shareString", "");
    localbyf.tOp.qUf = paramJSONObject.optString("shareStringUrl", "");
    localbyf.tOp.aWf = paramJSONObject.optString("source", "");
    localbyf.tOp.mSy = paramJSONObject.optString("sourceUrl", "");
    localbyf.tOp.tOy = paramJSONObject.optInt("relevant_category", -1);
    localbyf.tOp.tOz = paramJSONObject.optString("shareOpenId", "");
    localbyf.tOp.qVw = paramJSONObject.optString("docID", "");
    localbyf.tOp.tOF = paramJSONObject.optInt("videoSize", 0);
    localbyf.tOp.timestamp = bk.UZ();
    localbyf.tOp.tOB = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject3 = new JSONObject(paramJSONObject.optString("block", ""));
      localbyf.tOp.tOE = ((JSONObject)localObject3).optLong("resultType");
      localbyf.tOp.bGn = ((JSONObject)localObject3).optLong("type");
      label548:
      localbyf.tOp.tOA = paramJSONObject.optString("expand", "");
      localbyf.tOp.tOG.addAll((Collection)localObject1);
      localbyf.tOp.videoUrl = cO((List)localObject1);
      if (bk.bl(localbyf.tOp.tOv)) {
        localbyf.tOp.tOv = ("http://shp.qpic.cn/qqvideo_ori/0/" + localbyf.tOp.tOx + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!bk.bl((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localbyf.tOp.sXo.addAll(w((JSONArray)localObject1));
        label710:
        localObject1 = paramJSONObject.optString("feedback", "");
        if (!bk.bl((String)localObject1)) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject3 = new zc();
              ((zc)localObject3).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
              ((zc)localObject3).bQZ = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
              localbyf.tOp.tOH.add(localObject3);
              i += 1;
            }
            localObject2 = paramJSONObject.optString("show_tag_list", "");
          }
          catch (JSONException localJSONException1) {}
        }
        Object localObject2;
        if (!bk.bl((String)localObject2)) {}
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          localbyf.tOp.sXo.addAll(w((JSONArray)localObject2));
          label870:
          localbyf.tOo = localbyf.tOp.tOy;
          localbyf.tOl = paramJSONObject.optString("expand", "");
          localbyf.tOm = localbyf.fTF;
          localbyf.tOk = localbyf.tOp.tOx;
          localbyf.tOp.tOI = paramJSONObject.optInt("switchFlag", 0);
          paramJSONObject = paramJSONObject.optString("extReqParams", "");
          if (!bk.bl(paramJSONObject)) {
            try
            {
              paramJSONObject = new JSONArray(paramJSONObject);
              i = j;
              while (i < paramJSONObject.length())
              {
                localObject2 = paramJSONObject.getJSONObject(i);
                localObject3 = new rb();
                ((rb)localObject3).key = ((JSONObject)localObject2).optString("key", "");
                ((rb)localObject3).sOI = ((JSONObject)localObject2).optInt("uintValue", 0);
                ((rb)localObject3).sOJ = ((JSONObject)localObject2).optString("textValue", "");
                localbyf.qTG.add(localObject3);
                i += 1;
              }
              return localbyf;
            }
            catch (Exception paramJSONObject) {}
          }
        }
        catch (JSONException localJSONException2)
        {
          label1047:
          break label870;
        }
      }
      catch (Exception localException)
      {
        break label710;
      }
    }
    catch (JSONException localJSONException3)
    {
      break label548;
    }
  }
  
  public static String bNc()
  {
    return ae.getContext().getCacheDir() + "topstory/";
  }
  
  public static boolean bNd()
  {
    return 1 >= y.getLogLevel();
  }
  
  public static String bNe()
  {
    return e.dOQ.replace("/data/user/0", "/data/data") + "topstory/homecache/";
  }
  
  public static String bNf()
  {
    return e.dOQ.replace("/data/user/0", "/data/data") + "topstory/negcache/";
  }
  
  public static boolean bNg()
  {
    int i = ((a)com.tencent.mm.kernel.g.r(a.class)).bii();
    switch (i)
    {
    }
    for (boolean bool = false;; bool = true)
    {
      y.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      return bool;
    }
  }
  
  public static final String cO(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!bk.bl(str)) {
        return str;
      }
    }
    return null;
  }
  
  public static JSONArray cP(List<bse> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size()) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        bse localbse = (bse)paramList.get(i);
        localJSONObject.put("id", localbse.id);
        localJSONObject.put("wording", localbse.bQZ);
        localJSONObject.put("category", localbse.tIP);
        localJSONObject.put("actionType", localbse.actionType);
        localJSONObject.put("url", localbse.url);
        localJSONObject.put("title", localbse.title);
        localJSONObject.put("subTitle", localbse.imV);
        localJSONObject.put("icon", localbse.bVO);
        localJSONArray.put(localJSONObject);
        label149:
        i += 1;
        continue;
        return localJSONArray;
      }
      catch (Exception localException)
      {
        break label149;
      }
    }
  }
  
  public static String m(HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("lang", x.fB(ae.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(aa.Bn(1).NA()));
    paramHashMap.put("netType", aa.boM());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", d.CLIENT_VERSION);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aa.Bn(1).aoA());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(aa.T(paramHashMap));
    return localStringBuffer.toString();
  }
  
  private static List<bse> w(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      bse localbse = new bse();
      localbse.id = localJSONObject.optString("id", "");
      localbse.bQZ = localJSONObject.optString("wording", "");
      localbse.tIP = localJSONObject.optLong("category", 0L);
      localbse.actionType = localJSONObject.optInt("actionType", 0);
      localbse.url = localJSONObject.optString("url", "");
      localbse.title = localJSONObject.optString("title", "");
      localbse.imV = localJSONObject.optString("subTitle", "");
      localbse.bVO = localJSONObject.optString("icon", "");
      localArrayList.add(localbse);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.g
 * JD-Core Version:    0.7.0.1
 */