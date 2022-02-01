package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.fof;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.protocal.protobuf.gib;
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

public final class g
{
  public static final void H(List<aem> paramList, String paramString)
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
          aem localaem = new aem();
          localaem.key = localJSONObject.optString("key", "");
          localaem.Zmx = localJSONObject.optInt("uintValue", 0);
          localaem.Zmy = localJSONObject.optString("textValue", "");
          paramList.add(localaem);
          i += 1;
        }
        AppMethodBeat.o(90990);
        return;
      }
      catch (Exception paramList) {}
    }
    AppMethodBeat.o(90990);
  }
  
  private static List<fcl> P(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      fcl localfcl = new fcl();
      localfcl.id = localJSONObject.optString("id", "");
      localfcl.wording = localJSONObject.optString("wording", "");
      localfcl.abCa = localJSONObject.optLong("category", 0L);
      localfcl.actionType = localJSONObject.optInt("actionType", 0);
      localfcl.url = localJSONObject.optString("url", "");
      localfcl.title = localJSONObject.optString("title", "");
      localfcl.uCW = localJSONObject.optString("subTitle", "");
      localfcl.icon = localJSONObject.optString("icon", "");
      localArrayList.add(localfcl);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final foe a(foe paramfoe)
  {
    AppMethodBeat.i(90977);
    foe localfoe = new foe();
    localfoe.zIO = paramfoe.zIO;
    localfoe.scene = paramfoe.scene;
    localfoe.hAB = paramfoe.hAB;
    localfoe.mpa = paramfoe.mpa;
    localfoe.abOk = paramfoe.abOk;
    localfoe.abOj = paramfoe.abOj;
    localfoe.abOg = paramfoe.abOg;
    localfoe.abOh = paramfoe.abOh;
    localfoe.abOi = paramfoe.abOi;
    localfoe.abOf = paramfoe.abOf;
    localfoe.Wol.addAll(paramfoe.Wol);
    localfoe.lAj = paramfoe.lAj;
    localfoe.abOq = paramfoe.abOq;
    localfoe.abOr = paramfoe.abOr;
    AppMethodBeat.o(90977);
    return localfoe;
  }
  
  public static final foe a(gib paramgib, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    foe localfoe = new foe();
    localfoe.zIO = UUID.randomUUID().toString();
    localfoe.abOk = new foh();
    localfoe.abOk.title = paramgib.svG;
    localfoe.abOk.HsD = ("video-" + paramgib.WoZ);
    localfoe.abOk.Ido = paramgib.WoZ;
    localfoe.abOk.oeS = paramgib.thumbUrl;
    if (Util.isNullOrNil(localfoe.abOk.oeS)) {
      localfoe.abOk.oeS = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramgib.WoZ + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localfoe.abOk.Wph = paramgib.Wph;
    localfoe.abOk.source = paramgib.source;
    localfoe.abOk.ibx = paramgib.ibx;
    localfoe.abOk.abOy = paramgib.Wpa;
    localfoe.abOk.abOA = paramgib.Wpa;
    localfoe.abOk.Wpf = paramgib.Wpf;
    if (paramgib.Wpl == 100203L)
    {
      localfoe.abOk.thumbWidth = 360;
      localfoe.abOk.thumbHeight = 640;
    }
    for (;;)
    {
      localfoe.abOk.timestamp = System.currentTimeMillis();
      if (!Util.isNullOrNil(paramgib.Wpk)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramgib.Wpk);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            fcl localfcl = new fcl();
            localfcl.id = localJSONObject.optString("id");
            localfcl.wording = localJSONObject.optString("wording");
            localfcl.abCa = localJSONObject.optLong("category");
            localfcl.actionType = localJSONObject.optInt("actionType");
            localfcl.url = localJSONObject.optString("url");
            localfcl.title = localJSONObject.optString("title");
            localfcl.uCW = localJSONObject.optString("subTitle");
            localfcl.icon = localJSONObject.optString("icon");
            localfoe.abOk.Idn.add(localfcl);
            i += 1;
            continue;
            localfoe.abOk.thumbWidth = 496;
            localfoe.abOk.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localfoe.abOf = paramgib.WoZ;
    localfoe.abOg = paramgib.Wpa;
    localfoe.abOh = paramgib.Wpb;
    localfoe.abOi = paramgib.Wpc;
    localfoe.abOj = paramgib.Wpl;
    if (localfoe.abOj <= 0L) {
      localfoe.abOj = 100201L;
    }
    localfoe.abOm = false;
    if (!Util.isNullOrNil(paramgib.Wpj)) {
      H(localfoe.Wol, paramgib.Wpj);
    }
    localfoe.mpa = "";
    localfoe.scene = paramInt;
    localfoe.hAB = paramString;
    if (!Util.isNullOrNil(paramgib.Wpm))
    {
      localfoe.abOl = new fcl();
      localfoe.abOl.title = paramgib.Wpm;
    }
    AppMethodBeat.o(90974);
    return localfoe;
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
      localHashMap.put("deviceName", URLEncoder.encode(d.Yxf, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(q.aPo(), "utf8"));
      localHashMap.put("ostype", d.Yxc);
      paramString1 = t(localHashMap);
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
  
  public static final boolean aoJ(int paramInt)
  {
    return (paramInt == 110) || (paramInt == 700);
  }
  
  public static final boolean aoK(int paramInt)
  {
    return paramInt == 100;
  }
  
  public static final boolean aoL(int paramInt)
  {
    return paramInt == 666;
  }
  
  public static final foe bS(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    foe localfoe = new foe();
    localfoe.hAB = paramJSONObject.optString("query", "");
    localfoe.scene = paramJSONObject.optInt("scene", 21);
    localfoe.zIO = UUID.randomUUID().toString();
    localfoe.abOh = paramJSONObject.optString("searchId", "");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localfoe.abOm = true;
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
          foj localfoj = new foj();
          localfoj.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localfoj);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label1476;
      }
    }
    catch (JSONException localJSONException3) {}
    localfoe.abOk = new foh();
    localfoe.abOk.title = paramJSONObject.optString("title", "");
    localfoe.abOk.oeS = paramJSONObject.optString("thumbUrl", "");
    localfoe.abOk.Rfk = paramJSONObject.optInt("mediaDuration", 0);
    localfoe.abOk.Ido = ((String)localObject2);
    localfoe.abOk.Wph = paramJSONObject.optString("strPlayCount", "");
    localfoe.abOk.ytZ = paramJSONObject.optString("shareUrl", "");
    localfoe.abOk.svG = paramJSONObject.optString("shareTitle", "");
    localfoe.abOk.Wpi = paramJSONObject.optString("titleUrl", "");
    localfoe.abOk.ICb = paramJSONObject.optString("shareDesc", "");
    localfoe.abOk.Wpe = paramJSONObject.optString("shareImgUrl", "");
    localfoe.abOk.Wpf = paramJSONObject.optString("shareString", "");
    localfoe.abOk.Wpg = paramJSONObject.optString("shareStringUrl", "");
    localfoe.abOk.source = paramJSONObject.optString("source", "");
    localfoe.abOk.ibx = paramJSONObject.optString("sourceUrl", "");
    localfoe.abOk.abOw = paramJSONObject.optInt("relevant_category", -1);
    localfoe.abOk.abOx = paramJSONObject.optString("shareOpenId", "");
    localfoe.abOk.HsD = paramJSONObject.optString("docID", "");
    localfoe.abOk.abOC = paramJSONObject.optInt("videoSize", 0);
    localfoe.abOk.timestamp = Util.currentTicks();
    localfoe.abOk.abOz = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localfoe.abOk.abOB = ((JSONObject)localObject2).optLong("resultType");
      localfoe.abOk.beV = ((JSONObject)localObject2).optLong("type");
      label578:
      localfoe.abOk.abOy = paramJSONObject.optString("expand", "");
      localfoe.abOk.abOD.addAll((Collection)localObject1);
      localObject1 = lD((List)localObject1);
      if (localObject1 != null)
      {
        localfoe.abOk.videoUrl = ((foj)localObject1).url;
        localfoe.abOk.abOL = ((foj)localObject1).abOL;
      }
      if (Util.isNullOrNil(localfoe.abOk.oeS)) {
        localfoe.abOk.oeS = ("http://shp.qpic.cn/qqvideo_ori/0/" + localfoe.abOk.Ido + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localfoe.abOk.Idn.addAll(P((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localfoe.abOk.abOK = new fof();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localfoe.abOk.abOK.abOt = ((JSONObject)localObject1).optString("detailWording");
            localfoe.abOk.abOK.abOu = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new ass();
                ((ass)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((ass)localObject2).wording = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localfoe.abOk.abOK.abOv.add(localObject2);
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
          localfoe.abOk.Idn.addAll(P((JSONArray)localObject1));
          label963:
          localfoe.abOj = localfoe.abOk.abOw;
          localfoe.abOg = paramJSONObject.optString("expand", "");
          localfoe.mpa = "";
          localfoe.abOf = localfoe.abOk.Ido;
          localfoe.abOk.abOE = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localfoe.abOk;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((foh)localObject1).abOJ = bool;
            localObject2 = localfoe.abOk;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1410;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((foh)localObject2).ELy = ((String)localObject1);
            if (localfoe.abOj != 100203L) {
              break label1416;
            }
            localfoe.abOk.thumbWidth = 360;
          }
          for (localfoe.abOk.thumbHeight = 640;; localfoe.abOk.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localfoe.abOk.abOG = new foc();
                localfoe.abOk.abOG.abNZ = ((JSONObject)localObject1).optInt("videoSecondType");
                localfoe.abOk.abOG.abOb = ((JSONObject)localObject1).optInt("requestDuration");
                localfoe.abOk.abOG.abOc = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!Util.isNullOrNil((String)localObject1)) && ((localfoe.abOj == 100202L) || (localfoe.abOj == 100204L) || (localfoe.abOj == 100205L)))
              {
                localfoe.abOl = new fcl();
                localfoe.abOl.title = ((String)localObject1);
              }
              localObject1 = paramJSONObject.optString("extReqParams", "");
              if (Util.isNullOrNil((String)localObject1)) {
                break;
              }
              label1410:
              label1416:
              try
              {
                localObject1 = new JSONArray((String)localObject1);
                i = 0;
                while (i < ((JSONArray)localObject1).length())
                {
                  localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                  aem localaem = new aem();
                  localaem.key = ((JSONObject)localObject2).optString("key", "");
                  localaem.Zmx = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localaem.Zmy = ((JSONObject)localObject2).optString("textValue", "");
                  localfoe.Wol.add(localaem);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localfoe.abOk.thumbWidth = 496;
          }
          localfoe.abOq = paramJSONObject.optString("preNetType", "");
          if (localfoe.abOq.equals("wangka")) {
            localfoe.abOr = 1;
          }
          for (;;)
          {
            label1476:
            AppMethodBeat.o(90975);
            return localfoe;
            if ((localfoe.abOq.equals("2g")) || (localfoe.abOq.equals("3g")) || (localfoe.abOq.equals("4g"))) {
              localfoe.abOr = 2;
            } else {
              localfoe.abOr = 0;
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
  
  public static String beq(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = MMApplicationContext.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static final foe bf(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    foe localfoe = new foe();
    localfoe.hAB = aj.au(paramMap, "query");
    localfoe.scene = aj.c(paramMap, "scene", 21);
    localfoe.zIO = UUID.randomUUID().toString();
    localfoe.mpa = aj.au(paramMap, "searchId");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localfoe.abOm = true;
    }
    Object localObject2 = aj.au(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(aj.au(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          foj localfoj = new foj();
          localfoj.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localfoj);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label989;
      }
    }
    catch (JSONException localJSONException3) {}
    localfoe.abOk = new foh();
    localfoe.abOk.title = aj.au(paramMap, "title");
    localfoe.abOk.oeS = aj.au(paramMap, "thumbUrl");
    localfoe.abOk.Rfk = aj.c(paramMap, "mediaDuration", 0);
    localfoe.abOk.Ido = ((String)localObject2);
    localfoe.abOk.Wph = aj.au(paramMap, "strPlayCount");
    localfoe.abOk.ytZ = aj.au(paramMap, "shareUrl");
    localfoe.abOk.svG = aj.au(paramMap, "shareTitle");
    localfoe.abOk.Wpi = aj.au(paramMap, "titleUrl");
    localfoe.abOk.ICb = aj.au(paramMap, "shareDesc");
    localfoe.abOk.Wpe = aj.au(paramMap, "shareImgUrl");
    localfoe.abOk.Wpf = aj.au(paramMap, "shareString");
    localfoe.abOk.Wpg = aj.au(paramMap, "shareStringUrl");
    localfoe.abOk.source = aj.au(paramMap, "source");
    localfoe.abOk.ibx = aj.au(paramMap, "sourceUrl");
    localfoe.abOk.abOw = aj.a(paramMap, "relevant_category", -1L);
    localfoe.abOk.abOx = aj.au(paramMap, "shareOpenId");
    localfoe.abOk.HsD = aj.au(paramMap, "docID");
    localfoe.abOk.abOC = aj.a(paramMap, "videoSize", 0L);
    localfoe.abOk.timestamp = Util.currentTicks();
    localfoe.abOk.abOz = aj.c(paramMap, "itemType", 0);
    localfoe.abOk.abOE = aj.c(paramMap, "switchFlag", 0);
    if (Util.isNullOrNil(localfoe.abOk.oeS)) {
      localfoe.abOk.oeS = ("http://shp.qpic.cn/qqvideo_ori/0/" + localfoe.abOk.Ido + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(aj.au(paramMap, "block"));
      localfoe.abOk.abOB = ((JSONObject)localObject2).optLong("resultType");
      localfoe.abOk.beV = ((JSONObject)localObject2).optLong("type");
      label602:
      localfoe.abOk.abOy = aj.au(paramMap, "expand");
      localfoe.abOk.abOD.addAll((Collection)localObject1);
      localObject1 = lD((List)localObject1);
      if (localObject1 != null)
      {
        localfoe.abOk.videoUrl = ((foj)localObject1).url;
        localfoe.abOk.abOL = ((foj)localObject1).abOL;
      }
      localObject1 = aj.au(paramMap, "show_tag_list");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localfoe.abOk.Idn.addAll(P((JSONArray)localObject1));
        label709:
        localfoe.abOj = localfoe.abOk.abOw;
        localfoe.abOg = aj.au(paramMap, "expand");
        localfoe.abOh = localfoe.mpa;
        localfoe.abOf = localfoe.abOk.Ido;
        if (localfoe.abOj == 100203L)
        {
          localfoe.abOk.thumbWidth = 360;
          localfoe.abOk.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = aj.au(paramMap, "videoChannelTitle");
          if ((!Util.isNullOrNil(localfoe.abOk.Wpf)) && ((localfoe.abOj == 100202L) || (localfoe.abOj == 100204L) || (localfoe.abOj == 100205L)))
          {
            localfoe.abOl = new fcl();
            localfoe.abOl.title = ((String)localObject1);
          }
          paramMap = aj.au(paramMap, "extReqParams");
          if (!Util.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new aem();
                ((aem)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((aem)localObject2).Zmx = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((aem)localObject2).Zmy = ((JSONObject)localObject1).optString("textValue", "");
                localfoe.Wol.add(localObject2);
                i += 1;
                continue;
                localfoe.abOk.thumbWidth = 496;
                localfoe.abOk.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label989:
        AppMethodBeat.o(90976);
        return localfoe;
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
  
  public static String hMH()
  {
    AppMethodBeat.i(90978);
    String str = MMApplicationContext.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean hMI()
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
  
  public static String hMJ()
  {
    AppMethodBeat.i(90986);
    String str = b.bms() + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String hMK()
  {
    AppMethodBeat.i(90987);
    String str = b.bms() + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static boolean isFreeSimCard()
  {
    AppMethodBeat.i(90988);
    int i = ((a)h.ax(a.class)).gbv();
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
  
  public static final foj lD(List<foj> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      foj localfoj = (foj)paramList.next();
      if ((localfoj != null) && (!Util.isNullOrNil(localfoj.url)))
      {
        AppMethodBeat.o(90973);
        return localfoj;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray lE(List<fcl> paramList)
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
        fcl localfcl = (fcl)paramList.get(i);
        localJSONObject.put("id", localfcl.id);
        localJSONObject.put("wording", localfcl.wording);
        localJSONObject.put("category", localfcl.abCa);
        localJSONObject.put("actionType", localfcl.actionType);
        localJSONObject.put("url", localfcl.url);
        localJSONObject.put("title", localfcl.title);
        localJSONObject.put("subTitle", localfcl.uCW);
        localJSONObject.put("icon", localfcl.icon);
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
  
  public static String t(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    u(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aj.asW(1).iqp());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(aj.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  private static void u(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90985);
    paramHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(aj.asW(1).bIG()));
    paramHashMap.put("netType", aj.gtA());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
    AppMethodBeat.o(90985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.g
 * JD-Core Version:    0.7.0.1
 */