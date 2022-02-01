package com.tencent.mm.plugin.topstory.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.protocal.protobuf.fat;
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
  private static List<dyi> I(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(90982);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      dyi localdyi = new dyi();
      localdyi.id = localJSONObject.optString("id", "");
      localdyi.dQx = localJSONObject.optString("wording", "");
      localdyi.MXW = localJSONObject.optLong("category", 0L);
      localdyi.actionType = localJSONObject.optInt("actionType", 0);
      localdyi.url = localJSONObject.optString("url", "");
      localdyi.title = localJSONObject.optString("title", "");
      localdyi.oqZ = localJSONObject.optString("subTitle", "");
      localdyi.icon = localJSONObject.optString("icon", "");
      localArrayList.add(localdyi);
      i += 1;
    }
    AppMethodBeat.o(90982);
    return localArrayList;
  }
  
  public static final eit a(eit parameit)
  {
    AppMethodBeat.i(90977);
    eit localeit = new eit();
    localeit.sGQ = parameit.sGQ;
    localeit.scene = parameit.scene;
    localeit.dDv = parameit.dDv;
    localeit.hes = parameit.hes;
    localeit.Nic = parameit.Nic;
    localeit.Nib = parameit.Nib;
    localeit.NhY = parameit.NhY;
    localeit.NhZ = parameit.NhZ;
    localeit.Nia = parameit.Nia;
    localeit.NhX = parameit.NhX;
    localeit.IDO.addAll(parameit.IDO);
    localeit.guh = parameit.guh;
    localeit.Nii = parameit.Nii;
    localeit.Nij = parameit.Nij;
    AppMethodBeat.o(90977);
    return localeit;
  }
  
  public static final eit a(fat paramfat, int paramInt, String paramString)
  {
    AppMethodBeat.i(90974);
    eit localeit = new eit();
    localeit.sGQ = UUID.randomUUID().toString();
    localeit.Nic = new eiw();
    localeit.Nic.title = paramfat.msN;
    localeit.Nic.wWb = ("video-" + paramfat.IEy);
    localeit.Nic.psI = paramfat.IEy;
    localeit.Nic.Nio = paramfat.thumbUrl;
    if (Util.isNullOrNil(localeit.Nic.Nio)) {
      localeit.Nic.Nio = ("http://shp.qpic.cn/qqvideo_ori/0/" + paramfat.IEy + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    localeit.Nic.IEG = paramfat.IEG;
    localeit.Nic.source = paramfat.source;
    localeit.Nic.eby = paramfat.eby;
    localeit.Nic.Nir = paramfat.IEz;
    localeit.Nic.Nit = paramfat.IEz;
    localeit.Nic.IEE = paramfat.IEE;
    if (paramfat.IEK == 100203L)
    {
      localeit.Nic.thumbWidth = 360;
      localeit.Nic.thumbHeight = 640;
    }
    for (;;)
    {
      localeit.Nic.timestamp = System.currentTimeMillis();
      if (!Util.isNullOrNil(paramfat.IEJ)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(paramfat.IEJ);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            dyi localdyi = new dyi();
            localdyi.id = localJSONObject.optString("id");
            localdyi.dQx = localJSONObject.optString("wording");
            localdyi.MXW = localJSONObject.optLong("category");
            localdyi.actionType = localJSONObject.optInt("actionType");
            localdyi.url = localJSONObject.optString("url");
            localdyi.title = localJSONObject.optString("title");
            localdyi.oqZ = localJSONObject.optString("subTitle");
            localdyi.icon = localJSONObject.optString("icon");
            localeit.Nic.xuO.add(localdyi);
            i += 1;
            continue;
            localeit.Nic.thumbWidth = 496;
            localeit.Nic.thumbHeight = 280;
          }
        }
        catch (Exception localException) {}
      }
    }
    localeit.NhX = paramfat.IEy;
    localeit.NhY = paramfat.IEz;
    localeit.NhZ = paramfat.IEA;
    localeit.Nia = paramfat.IEB;
    localeit.Nib = paramfat.IEK;
    if (localeit.Nib <= 0L) {
      localeit.Nib = 100201L;
    }
    localeit.Nie = false;
    if (!Util.isNullOrNil(paramfat.IEI)) {
      q(localeit.IDO, paramfat.IEI);
    }
    localeit.hes = "";
    localeit.scene = paramInt;
    localeit.dDv = paramString;
    if (!Util.isNullOrNil(paramfat.IEL))
    {
      localeit.Nid = new dyi();
      localeit.Nid.title = paramfat.IEL;
    }
    AppMethodBeat.o(90974);
    return localeit;
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
      localHashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
      localHashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
      localHashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
      localHashMap.put("ostype", d.KyK);
      paramString1 = n(localHashMap);
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
  
  public static String aTv(String paramString)
  {
    AppMethodBeat.i(90979);
    paramString = MMApplicationContext.getContext().getCacheDir() + "/topstory/" + paramString + "/";
    AppMethodBeat.o(90979);
    return paramString;
  }
  
  public static final eit aU(Map<String, Object> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(90976);
    eit localeit = new eit();
    localeit.dDv = ai.N(paramMap, "query");
    localeit.scene = ai.b(paramMap, "scene", 21);
    localeit.sGQ = UUID.randomUUID().toString();
    localeit.hes = ai.N(paramMap, "searchId");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localeit.Nie = true;
    }
    Object localObject2 = ai.N(paramMap, "videoId");
    Object localObject1 = new ArrayList();
    int i;
    try
    {
      JSONArray localJSONArray = new JSONArray(ai.N(paramMap, "videoUrls"));
      if (localJSONArray.length() > 0)
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          eiy localeiy = new eiy();
          localeiy.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localeiy);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label992;
      }
    }
    catch (JSONException localJSONException3) {}
    localeit.Nic = new eiw();
    localeit.Nic.title = ai.N(paramMap, "title");
    localeit.Nic.Nio = ai.N(paramMap, "thumbUrl");
    localeit.Nic.Eso = ai.b(paramMap, "mediaDuration", 0);
    localeit.Nic.psI = ((String)localObject2);
    localeit.Nic.IEG = ai.N(paramMap, "strPlayCount");
    localeit.Nic.rCq = ai.N(paramMap, "shareUrl");
    localeit.Nic.msN = ai.N(paramMap, "shareTitle");
    localeit.Nic.IEH = ai.N(paramMap, "titleUrl");
    localeit.Nic.xDQ = ai.N(paramMap, "shareDesc");
    localeit.Nic.IED = ai.N(paramMap, "shareImgUrl");
    localeit.Nic.IEE = ai.N(paramMap, "shareString");
    localeit.Nic.IEF = ai.N(paramMap, "shareStringUrl");
    localeit.Nic.source = ai.N(paramMap, "source");
    localeit.Nic.eby = ai.N(paramMap, "sourceUrl");
    localeit.Nic.Nip = ai.a(paramMap, "relevant_category", -1L);
    localeit.Nic.Niq = ai.N(paramMap, "shareOpenId");
    localeit.Nic.wWb = ai.N(paramMap, "docID");
    localeit.Nic.Niv = ai.a(paramMap, "videoSize", 0L);
    localeit.Nic.timestamp = Util.currentTicks();
    localeit.Nic.Nis = ai.b(paramMap, "itemType", 0);
    localeit.Nic.Nix = ai.b(paramMap, "switchFlag", 0);
    if (Util.isNullOrNil(localeit.Nic.Nio)) {
      localeit.Nic.Nio = ("http://shp.qpic.cn/qqvideo_ori/0/" + localeit.Nic.psI + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
    }
    try
    {
      localObject2 = new JSONObject(ai.N(paramMap, "block"));
      localeit.Nic.Niu = ((JSONObject)localObject2).optLong("resultType");
      localeit.Nic.dDw = ((JSONObject)localObject2).optLong("type");
      label602:
      localeit.Nic.Nir = ai.N(paramMap, "expand");
      localeit.Nic.Niw.addAll((Collection)localObject1);
      localObject1 = hJ((List)localObject1);
      if (localObject1 != null)
      {
        localeit.Nic.videoUrl = ((eiy)localObject1).url;
        localeit.Nic.NiF = ((eiy)localObject1).NiF;
      }
      localObject1 = ai.N(paramMap, "show_tag_list");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localeit.Nic.xuO.addAll(I((JSONArray)localObject1));
        label709:
        localeit.Nib = localeit.Nic.Nip;
        localeit.NhY = ai.N(paramMap, "expand");
        localeit.NhZ = localeit.hes;
        localeit.NhX = localeit.Nic.psI;
        if (localeit.Nib == 100203L)
        {
          localeit.Nic.thumbWidth = 360;
          localeit.Nic.thumbHeight = 640;
        }
        for (;;)
        {
          localObject1 = ai.N(paramMap, "videoChannelTitle");
          if ((!Util.isNullOrNil(localeit.Nic.IEE)) && ((localeit.Nib == 100202L) || (localeit.Nib == 100204L) || (localeit.Nib == 100205L)))
          {
            localeit.Nid = new dyi();
            localeit.Nid.title = ((String)localObject1);
          }
          paramMap = ai.N(paramMap, "extReqParams");
          if (!Util.isNullOrNil(paramMap)) {
            try
            {
              paramMap = new JSONArray(paramMap);
              i = j;
              while (i < paramMap.length())
              {
                localObject1 = paramMap.getJSONObject(i);
                localObject2 = new aca();
                ((aca)localObject2).key = ((JSONObject)localObject1).optString("key", "");
                ((aca)localObject2).LmC = ((JSONObject)localObject1).optInt("uintValue", 0);
                ((aca)localObject2).LmD = ((JSONObject)localObject1).optString("textValue", "");
                localeit.IDO.add(localObject2);
                i += 1;
                continue;
                localeit.Nic.thumbWidth = 496;
                localeit.Nic.thumbHeight = 280;
              }
            }
            catch (Exception paramMap) {}
          }
        }
        label992:
        AppMethodBeat.o(90976);
        return localeit;
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
  
  public static final eit br(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90975);
    eit localeit = new eit();
    localeit.dDv = paramJSONObject.optString("query", "");
    localeit.scene = paramJSONObject.optInt("scene", 21);
    localeit.sGQ = UUID.randomUUID().toString();
    localeit.NhZ = paramJSONObject.optString("searchId", "");
    if ((NetStatusUtil.isConnected(MMApplicationContext.getContext())) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {
      localeit.Nie = true;
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
          eiy localeiy = new eiy();
          localeiy.url = localJSONArray.getString(i);
          ((ArrayList)localObject1).add(localeiy);
          i += 1;
        }
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break label1479;
      }
    }
    catch (JSONException localJSONException3) {}
    localeit.Nic = new eiw();
    localeit.Nic.title = paramJSONObject.optString("title", "");
    localeit.Nic.Nio = paramJSONObject.optString("thumbUrl", "");
    localeit.Nic.Eso = paramJSONObject.optInt("mediaDuration", 0);
    localeit.Nic.psI = ((String)localObject2);
    localeit.Nic.IEG = paramJSONObject.optString("strPlayCount", "");
    localeit.Nic.rCq = paramJSONObject.optString("shareUrl", "");
    localeit.Nic.msN = paramJSONObject.optString("shareTitle", "");
    localeit.Nic.IEH = paramJSONObject.optString("titleUrl", "");
    localeit.Nic.xDQ = paramJSONObject.optString("shareDesc", "");
    localeit.Nic.IED = paramJSONObject.optString("shareImgUrl", "");
    localeit.Nic.IEE = paramJSONObject.optString("shareString", "");
    localeit.Nic.IEF = paramJSONObject.optString("shareStringUrl", "");
    localeit.Nic.source = paramJSONObject.optString("source", "");
    localeit.Nic.eby = paramJSONObject.optString("sourceUrl", "");
    localeit.Nic.Nip = paramJSONObject.optInt("relevant_category", -1);
    localeit.Nic.Niq = paramJSONObject.optString("shareOpenId", "");
    localeit.Nic.wWb = paramJSONObject.optString("docID", "");
    localeit.Nic.Niv = paramJSONObject.optInt("videoSize", 0);
    localeit.Nic.timestamp = Util.currentTicks();
    localeit.Nic.Nis = paramJSONObject.optInt("itemType", 0);
    try
    {
      localObject2 = new JSONObject(paramJSONObject.optString("block", ""));
      localeit.Nic.Niu = ((JSONObject)localObject2).optLong("resultType");
      localeit.Nic.dDw = ((JSONObject)localObject2).optLong("type");
      label578:
      localeit.Nic.Nir = paramJSONObject.optString("expand", "");
      localeit.Nic.Niw.addAll((Collection)localObject1);
      localObject1 = hJ((List)localObject1);
      if (localObject1 != null)
      {
        localeit.Nic.videoUrl = ((eiy)localObject1).url;
        localeit.Nic.NiF = ((eiy)localObject1).NiF;
      }
      if (Util.isNullOrNil(localeit.Nic.Nio)) {
        localeit.Nic.Nio = ("http://shp.qpic.cn/qqvideo_ori/0/" + localeit.Nic.psI + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
      }
      localObject1 = paramJSONObject.optString("tagList", "");
      if (!Util.isNullOrNil((String)localObject1)) {}
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localeit.Nic.xuO.addAll(I((JSONArray)localObject1));
        label758:
        if (!paramJSONObject.optBoolean("not_show_feedback", false))
        {
          localeit.Nic.NiE = new eiu();
          localObject1 = paramJSONObject.optJSONObject("feedbackObj");
          if (localObject1 != null)
          {
            localeit.Nic.NiE.Nil = ((JSONObject)localObject1).optString("detailWording");
            localeit.Nic.NiE.Nim = ((JSONObject)localObject1).optString("detailUrl");
            localObject1 = ((JSONObject)localObject1).optJSONArray("feedbackData");
            if (localObject1 != null)
            {
              i = 0;
              while (i < ((JSONArray)localObject1).length())
              {
                localObject2 = new any();
                ((any)localObject2).id = ((JSONArray)localObject1).optJSONObject(i).optString("id", "");
                ((any)localObject2).dQx = ((JSONArray)localObject1).optJSONObject(i).optString("wording", "");
                localeit.Nic.NiE.Nin.add(localObject2);
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
          localeit.Nic.xuO.addAll(I((JSONArray)localObject1));
          label963:
          localeit.Nib = localeit.Nic.Nip;
          localeit.NhY = paramJSONObject.optString("expand", "");
          localeit.hes = "";
          localeit.NhX = localeit.Nic.psI;
          localeit.Nic.Nix = paramJSONObject.optInt("switchFlag", 0);
          localObject1 = localeit.Nic;
          boolean bool;
          if ((paramJSONObject.optJSONObject("colikeInfo") != null) && (paramJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb")))
          {
            bool = true;
            ((eiw)localObject1).NiC = bool;
            localObject2 = localeit.Nic;
            if (paramJSONObject.optJSONObject("colikeInfo") == null) {
              break label1413;
            }
            localObject1 = paramJSONObject.optJSONObject("colikeInfo").optString("byPass", "");
            label1098:
            ((eiw)localObject2).NiD = ((String)localObject1);
            if (localeit.Nib != 100203L) {
              break label1419;
            }
            localeit.Nic.thumbWidth = 360;
          }
          for (localeit.Nic.thumbHeight = 640;; localeit.Nic.thumbHeight = 280)
          {
            for (;;)
            {
              localObject1 = paramJSONObject.optJSONObject("secondVideoInfo");
              if (localObject1 != null)
              {
                localeit.Nic.Niz = new eir();
                localeit.Nic.Niz.NhR = ((JSONObject)localObject1).optInt("videoSecondType");
                localeit.Nic.Niz.NhT = ((JSONObject)localObject1).optInt("requestDuration");
                localeit.Nic.Niz.NhU = ((JSONObject)localObject1).optInt("requestPercent");
              }
              localObject1 = paramJSONObject.optString("videoChannelTitle", "");
              if ((!Util.isNullOrNil((String)localObject1)) && ((localeit.Nib == 100202L) || (localeit.Nib == 100204L) || (localeit.Nib == 100205L)))
              {
                localeit.Nid = new dyi();
                localeit.Nid.title = ((String)localObject1);
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
                  aca localaca = new aca();
                  localaca.key = ((JSONObject)localObject2).optString("key", "");
                  localaca.LmC = ((JSONObject)localObject2).optInt("uintValue", 0);
                  localaca.LmD = ((JSONObject)localObject2).optString("textValue", "");
                  localeit.IDO.add(localaca);
                  i += 1;
                }
                bool = false;
              }
              catch (Exception localException1) {}
            }
            localObject1 = "";
            break label1098;
            localeit.Nic.thumbWidth = 496;
          }
          localeit.Nii = paramJSONObject.optString("preNetType", "");
          if (localeit.Nii.equals("wangka")) {
            localeit.Nij = 1;
          }
          for (;;)
          {
            label1479:
            AppMethodBeat.o(90975);
            return localeit;
            if ((localeit.Nii.equals("2g")) || (localeit.Nii.equals("3g")) || (localeit.Nii.equals("4g"))) {
              localeit.Nij = 2;
            } else {
              localeit.Nij = 0;
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
  
  public static String fxQ()
  {
    AppMethodBeat.i(90978);
    String str = MMApplicationContext.getContext().getCacheDir() + "/topstory/";
    AppMethodBeat.o(90978);
    return str;
  }
  
  public static boolean fxR()
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
  
  public static String fxS()
  {
    AppMethodBeat.i(90986);
    String str = b.aKC().replace("/data/user/0", "/data/data") + "topstory/homecache/";
    AppMethodBeat.o(90986);
    return str;
  }
  
  public static String fxT()
  {
    AppMethodBeat.i(90987);
    String str = b.aKC().replace("/data/user/0", "/data/data") + "topstory/negcache/";
    AppMethodBeat.o(90987);
    return str;
  }
  
  public static final eiy hJ(List<eiy> paramList)
  {
    AppMethodBeat.i(90973);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      eiy localeiy = (eiy)paramList.next();
      if ((localeiy != null) && (!Util.isNullOrNil(localeiy.url)))
      {
        AppMethodBeat.o(90973);
        return localeiy;
      }
    }
    AppMethodBeat.o(90973);
    return null;
  }
  
  public static JSONArray hK(List<dyi> paramList)
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
        dyi localdyi = (dyi)paramList.get(i);
        localJSONObject.put("id", localdyi.id);
        localJSONObject.put("wording", localdyi.dQx);
        localJSONObject.put("category", localdyi.MXW);
        localJSONObject.put("actionType", localdyi.actionType);
        localJSONObject.put("url", localdyi.url);
        localJSONObject.put("title", localdyi.title);
        localJSONObject.put("subTitle", localdyi.oqZ);
        localJSONObject.put("icon", localdyi.icon);
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
  
  public static boolean isFreeSimCard()
  {
    AppMethodBeat.i(90988);
    int i = ((a)g.af(a.class)).eiV();
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
  
  public static String n(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90984);
    o(paramHashMap);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(ai.afr(1).fYs());
    localStringBuffer.append("/");
    localStringBuffer.append("app.html");
    localStringBuffer.append("?");
    localStringBuffer.append(ai.toUrlParams(paramHashMap));
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(90984);
    return paramHashMap;
  }
  
  private static void o(HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(90985);
    paramHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    paramHashMap.put("platform", "android");
    paramHashMap.put("version", String.valueOf(ai.afr(1).bbw()));
    paramHashMap.put("netType", ai.ait());
    paramHashMap.put("isClientLoading", "1");
    paramHashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
    AppMethodBeat.o(90985);
  }
  
  public static final void q(List<aca> paramList, String paramString)
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
          aca localaca = new aca();
          localaca.key = localJSONObject.optString("key", "");
          localaca.LmC = localJSONObject.optInt("uintValue", 0);
          localaca.LmD = localJSONObject.optString("textValue", "");
          paramList.add(localaca);
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