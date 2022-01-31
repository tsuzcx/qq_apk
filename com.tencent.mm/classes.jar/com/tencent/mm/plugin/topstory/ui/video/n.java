package com.tencent.mm.plugin.topstory.ui.video;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.v;
import com.tencent.mm.network.w;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  f fur;
  public b thM;
  public boolean tju;
  public int tjv;
  j tjw;
  private int tjx;
  private int tjy;
  
  public n()
  {
    AppMethodBeat.i(1762);
    this.fur = new n.3(this);
    AppMethodBeat.o(1762);
  }
  
  public static int LZ()
  {
    AppMethodBeat.i(1774);
    switch (at.getNetType(ah.getContext()))
    {
    default: 
      if (at.is2G(ah.getContext()))
      {
        AppMethodBeat.o(1774);
        return 2;
      }
      break;
    case -1: 
      AppMethodBeat.o(1774);
      return 0;
    case 0: 
      AppMethodBeat.o(1774);
      return 1;
    }
    if (at.is3G(ah.getContext()))
    {
      AppMethodBeat.o(1774);
      return 3;
    }
    if (at.is4G(ah.getContext()))
    {
      AppMethodBeat.o(1774);
      return 4;
    }
    AppMethodBeat.o(1774);
    return 0;
  }
  
  private static List<ckx> a(boolean paramBoolean, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(1771);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject1 = (JSONObject)paramJSONArray.get(i);
      long l1 = ((JSONObject)localObject1).optLong("resultType");
      long l2 = ((JSONObject)localObject1).optLong("type");
      String str1 = ((JSONObject)localObject1).optString("expand");
      JSONArray localJSONArray1 = ((JSONObject)localObject1).optJSONArray("items");
      if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
      {
        long l3 = bo.yB();
        int j = 0;
        if (j < localJSONArray1.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray1.get(j);
          String str3 = localJSONObject.optString("videoApi");
          String str4 = localJSONObject.optString("videoId");
          String str5 = localJSONObject.optString("videoPlatform");
          String str2 = localJSONObject.optString("docID");
          JSONArray localJSONArray2 = localJSONObject.optJSONArray("show_tag_list");
          boolean bool = localJSONObject.optBoolean("not_show_feedback", false);
          Object localObject2 = null;
          localObject1 = localObject2;
          if (!bool)
          {
            localObject3 = localJSONObject.optJSONObject("feedbackObj");
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((JSONObject)localObject3).optJSONArray("feedbackData");
            }
          }
          int n = localJSONObject.optInt("mediaDuration", 0);
          Object localObject3 = localJSONObject.optJSONObject("videoInfo");
          localObject2 = null;
          if (localObject3 != null) {
            localObject2 = ((JSONObject)localObject3).optJSONObject("videoCdnInfo");
          }
          if (!bo.isNullOrNil(str4))
          {
            localObject3 = new ckx();
            ((ckx)localObject3).xVa = str4;
            int k = 0;
            int m = 0;
            if (localObject2 != null)
            {
              k = ((JSONObject)localObject2).optInt("cdnScene", 0);
              m = ((JSONObject)localObject2).optInt("cdnSourceType", 0);
            }
            ((ckx)localObject3).xVs = k;
            ((ckx)localObject3).xVr = m;
            if ((k == 1) || (k == 2))
            {
              if (!a(k, (ckx)localObject3, (JSONObject)localObject2)) {
                break label1283;
              }
              m = 1;
              localObject2 = com.tencent.mm.plugin.topstory.a.g.dQ(((ckx)localObject3).xVj);
              if (localObject2 != null)
              {
                ((ckx)localObject3).videoUrl = ((ckz)localObject2).url;
                ((ckx)localObject3).xVo = ((ckz)localObject2).xVo;
              }
              if (bo.isNullOrNil(((ckx)localObject3).videoUrl)) {
                a.kS(11);
              }
              ((ckx)localObject3).xUZ = n;
              ((ckx)localObject3).title = localJSONObject.optString("title");
              ((ckx)localObject3).lHr = localJSONObject.optString("shareTitle");
              ((ckx)localObject3).rrm = localJSONObject.optString("shareDesc");
              ((ckx)localObject3).uJn = localJSONObject.optString("shareImgUrl");
              ((ckx)localObject3).uJo = localJSONObject.optString("shareString");
              ((ckx)localObject3).uJp = localJSONObject.optString("shareStringUrl");
              ((ckx)localObject3).source = localJSONObject.optString("source");
              ((ckx)localObject3).puE = localJSONObject.optString("sourceUrl");
              ((ckx)localObject3).lHq = localJSONObject.optString("shareUrl");
              ((ckx)localObject3).xVb = localJSONObject.optLong("relevant_category", -1L);
              ((ckx)localObject3).xVc = localJSONObject.optString("shareOpenId");
              ((ckx)localObject3).xVd = localJSONObject.optString("expand");
              ((ckx)localObject3).uJq = localJSONObject.optString("strPlayCount");
              ((ckx)localObject3).uJr = localJSONObject.optString("titleUrl");
              ((ckx)localObject3).xVe = localJSONObject.optInt("itemType");
              ((ckx)localObject3).xVg = localJSONObject.optString("bizIcon");
              ((ckx)localObject3).xVm = localJSONObject.optLong("shareChannelId", ((ckx)localObject3).xVb);
              ((ckx)localObject3).timestamp = l3;
              ((ckx)localObject3).coy = false;
              ((ckx)localObject3).uKI = str2;
              ((ckx)localObject3).xVh = l1;
              ((ckx)localObject3).cnw = l2;
              ((ckx)localObject3).xVf = str1;
              ((ckx)localObject3).xVl = localJSONObject.optInt("switchFlag", 0);
              if ((localJSONObject.optJSONObject("colikeInfo") == null) || (!localJSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb"))) {
                break label1003;
              }
              bool = true;
              label698:
              ((ckx)localObject3).xVp = bool;
              if (localJSONObject.optJSONObject("colikeInfo") == null) {
                break label1009;
              }
            }
            label1003:
            label1009:
            for (localObject2 = localJSONObject.optJSONObject("colikeInfo").optString("byPass", "");; localObject2 = "")
            {
              ((ckx)localObject3).xVq = ((String)localObject2);
              ((ckx)localObject3).vYf = localJSONObject.optInt("insertPos", 0);
              if (localJSONArray2 == null) {
                break label1017;
              }
              n = 0;
              while (n < localJSONArray2.length())
              {
                localObject2 = new ccp();
                ((ccp)localObject2).id = localJSONArray2.getJSONObject(n).optString("id");
                ((ccp)localObject2).cyA = localJSONArray2.getJSONObject(n).optString("wording");
                ((ccp)localObject2).xNd = localJSONArray2.getJSONObject(n).optLong("category");
                ((ccp)localObject2).actionType = localJSONArray2.getJSONObject(n).optInt("actionType");
                ((ccp)localObject2).url = localJSONArray2.getJSONObject(n).optString("url");
                ((ccp)localObject2).title = localJSONArray2.getJSONObject(n).optString("title");
                ((ccp)localObject2).jjP = localJSONArray2.getJSONObject(n).optString("subTitle");
                ((ccp)localObject2).cDz = localJSONArray2.getJSONObject(n).optString("icon");
                ((ckx)localObject3).wVo.add(localObject2);
                n += 1;
              }
              if (bo.isNullOrNil(str3)) {
                break label1283;
              }
              a((ckx)localObject3, str3, str5);
              if (bo.es(((ckx)localObject3).xVj))
              {
                a.kS(29);
                ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi retry");
                a((ckx)localObject3, str3, str5);
              }
              m = 0;
              break;
              bool = false;
              break label698;
            }
            label1017:
            if (localObject1 != null)
            {
              n = 0;
              while (n < ((JSONArray)localObject1).length())
              {
                localObject2 = new adl();
                ((adl)localObject2).id = ((JSONArray)localObject1).optJSONObject(n).optString("id", "");
                ((adl)localObject2).cyA = ((JSONArray)localObject1).optJSONObject(n).optString("wording", "");
                ((adl)localObject2).wWx = ((JSONArray)localObject1).optJSONObject(n).optBoolean("isUseToConfirm", false);
                ((ckx)localObject3).xVk.add(localObject2);
                n += 1;
              }
            }
            if (!paramBoolean) {
              break label1290;
            }
            ((ckx)localObject3).fgR = 360;
            ((ckx)localObject3).fgQ = 640;
            if (bo.isNullOrNil(((ckx)localObject3).xUY)) {
              ((ckx)localObject3).xUY = localJSONObject.optString("thumbUrl");
            }
            label1169:
            if (m != 0) {
              ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, cdnScene:%s, vid:%s, title:%s, size:%s", new Object[] { Integer.valueOf(k), ((ckx)localObject3).xVa, ((ckx)localObject3).title, Long.valueOf(((ckx)localObject3).xVi) });
            }
            if (bo.isNullOrNil(((ckx)localObject3).videoUrl)) {
              break label1377;
            }
            ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { ((ckx)localObject3).xVa, ((ckx)localObject3).videoUrl, Long.valueOf(((ckx)localObject3).xVi) });
            localArrayList.add(localObject3);
          }
          for (;;)
          {
            label1283:
            j += 1;
            break;
            label1290:
            if (bo.isNullOrNil(((ckx)localObject3).xUY)) {
              ((ckx)localObject3).xUY = ("http://shp.qpic.cn/qqvideo_ori/0/" + ((ckx)localObject3).xVa + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
            }
            ((ckx)localObject3).fgR = 496;
            ((ckx)localObject3).fgQ = 280;
            break label1169;
            label1377:
            ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", new Object[] { ((ckx)localObject3).xVa });
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(1771);
    return localArrayList;
  }
  
  private static void a(ckx paramckx, String paramString1, String paramString2)
  {
    AppMethodBeat.i(1773);
    Object localObject7 = null;
    InputStream localInputStream1 = null;
    Object localObject8 = null;
    String str = null;
    v localv = null;
    JSONArray localJSONArray = null;
    Object localObject9 = null;
    Object localObject6 = null;
    StringBuilder localStringBuilder = new StringBuilder("");
    Object localObject3 = localJSONArray;
    Object localObject4 = localObject8;
    InputStream localInputStream2 = localInputStream1;
    Object localObject1 = localObject9;
    Object localObject2 = str;
    Object localObject5 = localObject7;
    int i;
    try
    {
      if (!com.tencent.mm.plugin.topstory.a.g.cIz()) {
        break label600;
      }
      j = 2;
    }
    catch (Throwable paramckx)
    {
      int j;
      int m;
      for (;;)
      {
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject5 = localInputStream2;
        ab.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", paramckx, "getVideoUrlByVideoApi error: %s", new Object[] { paramckx.getMessage() });
        if (localObject4 != null) {
          ((v)localObject4).disconnect();
        }
        if (localObject3 != null) {
          ((w)localObject3).disconnect();
        }
        if (localInputStream2 == null) {
          break;
        }
        com.tencent.mm.a.e.l(localInputStream2);
        AppMethodBeat.o(1773);
        return;
        j = -1;
        continue;
        if ((k == 1) || (k == 6) || (k == 9))
        {
          i = 2;
        }
        else if ((k == 3) || (k == 5) || (k == 11))
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          localObject3 = localJSONArray;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = str;
          localObject5 = localObject7;
          localv = com.tencent.mm.network.b.a(paramString1, null);
          localObject3 = localJSONArray;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = localv;
          localObject5 = localObject7;
          localv.setUseCaches(true);
          localObject3 = localJSONArray;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = localv;
          localObject5 = localObject7;
          localv.setConnectTimeout(3000);
          localObject3 = localJSONArray;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = localv;
          localObject5 = localObject7;
          localv.setReadTimeout(3000);
          localObject3 = localJSONArray;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = localv;
          localObject5 = localObject7;
          localInputStream1 = localv.getInputStream();
          paramString1 = (String)localObject6;
        }
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = new JSONObject(localStringBuilder.toString().substring(13));
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject6).optJSONObject("fl");
      if (localObject7 == null) {
        break label1072;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject7).optJSONArray("fi");
      if (localObject7 == null) {
        break label1072;
      }
      k = 0;
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (k >= ((JSONArray)localObject7).length()) {
        break label1072;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject8 = ((JSONArray)localObject7).getJSONObject(k);
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (((JSONObject)localObject8).optInt("sl", 0) != 1) {
        break label2110;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      paramckx.xVi = ((JSONObject)localObject8).optLong("fs");
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = ((JSONObject)localObject6).optJSONObject("vl");
      if (localObject6 == null) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = ((JSONObject)localObject6).optJSONArray("vi");
      if (localObject6 == null) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (((JSONArray)localObject6).length() <= 0) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = ((JSONArray)localObject6).getJSONObject(0);
      if (localObject6 == null) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject8 = ((JSONObject)localObject6).optString("fn");
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      str = ((JSONObject)localObject6).optString("fvkey");
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = ((JSONObject)localObject6).optJSONObject("ul");
      if (localObject6 == null) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localJSONArray = ((JSONObject)localObject6).optJSONArray("ui");
      if (localJSONArray == null) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (localJSONArray.length() <= 0) {
        break label2054;
      }
      k = 0;
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (k >= localJSONArray.length()) {
        break label2054;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = localJSONArray.getJSONObject(k);
      if (localObject6 == null) {
        break label2101;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = ((JSONObject)localObject6).optString("url");
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      n = ((JSONObject)localObject6).optInt("vt", 0);
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (bo.isNullOrNil((String)localObject7)) {
        break label2101;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (bo.isNullOrNil(str)) {
        break label2101;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (bo.isNullOrNil((String)localObject8)) {
        break label2101;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject7 = (String)localObject7 + (String)localObject8 + "?vkey=" + str;
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject6 = localObject7;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (bo.isNullOrNil(paramString2)) {
        break label1742;
      }
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      localObject6 = (String)localObject7 + "&platform=" + paramString2;
      localObject3 = paramString1;
      localObject4 = localv;
      localInputStream2 = localInputStream1;
      localObject1 = paramString1;
      localObject2 = localv;
      localObject5 = localInputStream1;
      if (!bo.isNullOrNil((String)localObject6)) {
        break label1896;
      }
      for (;;)
      {
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        localObject7 = new ckz();
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        ((ckz)localObject7).url = ((String)localObject6);
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        ((ckz)localObject7).xVo = n;
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        paramckx.xVj.add(localObject7);
        break;
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        localObject6 = (String)localObject6 + "&" + "Unicomtype=" + j + "&newnettype=" + m + "&Netoperator=" + i;
        localObject3 = paramString1;
        localObject4 = localv;
        localInputStream2 = localInputStream1;
        localObject1 = paramString1;
        localObject2 = localv;
        localObject5 = localInputStream1;
        ab.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: ".concat(String.valueOf(localObject6)));
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label2026;
      }
      ((v)localObject2).disconnect();
      if (localObject1 == null) {
        break label2036;
      }
      ((w)localObject1).disconnect();
      if (localObject5 == null) {
        break label2046;
      }
      com.tencent.mm.a.e.l((InputStream)localObject5);
      AppMethodBeat.o(1773);
    }
    localObject3 = localJSONArray;
    localObject4 = localObject8;
    localInputStream2 = localInputStream1;
    localObject1 = localObject9;
    localObject2 = str;
    localObject5 = localObject7;
    m = LZ();
    localObject3 = localJSONArray;
    localObject4 = localObject8;
    localInputStream2 = localInputStream1;
    localObject1 = localObject9;
    localObject2 = str;
    localObject5 = localObject7;
    int k = at.getISPCode(ah.getContext());
    if (k != 0)
    {
      localObject3 = localJSONArray;
      localObject4 = localObject8;
      localInputStream2 = localInputStream1;
      localObject1 = localObject9;
      localObject2 = str;
      localObject5 = localObject7;
      i = k / 100;
      k %= 100;
      if (i == 460)
      {
        if ((k == 0) || (k == 2)) {
          break label2096;
        }
        if (k == 7)
        {
          break label2096;
          localObject3 = localJSONArray;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = str;
          localObject5 = localObject7;
          ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByVideoApi, videoapi: %s", new Object[] { paramString1 });
          localObject3 = localJSONArray;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = str;
          localObject5 = localObject7;
          if (!URLUtil.isHttpsUrl(paramString1)) {
            break label660;
          }
          localObject3 = localJSONArray;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = localObject9;
          localObject2 = str;
          localObject5 = localObject7;
          paramString1 = com.tencent.mm.network.b.wb(paramString1);
          localObject3 = paramString1;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = str;
          localObject5 = localObject7;
          paramString1.ans();
          localObject3 = paramString1;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = str;
          localObject5 = localObject7;
          paramString1.setConnectTimeout(3000);
          localObject3 = paramString1;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = str;
          localObject5 = localObject7;
          paramString1.setReadTimeout(3000);
          localObject3 = paramString1;
          localObject4 = localObject8;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = str;
          localObject5 = localObject7;
          localInputStream1 = paramString1.gel.getInputStream();
          localObject3 = paramString1;
          localObject4 = localv;
          localInputStream2 = localInputStream1;
          localObject1 = paramString1;
          localObject2 = localv;
          localObject5 = localInputStream1;
          localObject6 = new BufferedReader(new InputStreamReader(localInputStream1));
          for (;;)
          {
            localObject3 = paramString1;
            localObject4 = localv;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localv;
            localObject5 = localInputStream1;
            localObject7 = ((BufferedReader)localObject6).readLine();
            if (localObject7 == null) {
              break;
            }
            localObject3 = paramString1;
            localObject4 = localv;
            localInputStream2 = localInputStream1;
            localObject1 = paramString1;
            localObject2 = localv;
            localObject5 = localInputStream1;
            localStringBuilder.append((String)localObject7);
          }
        }
      }
    }
    for (;;)
    {
      label600:
      int n;
      label660:
      label1072:
      label1742:
      label1896:
      label2026:
      label2036:
      label2046:
      if (localv != null) {
        localv.disconnect();
      }
      label2054:
      if (paramString1 != null) {
        paramString1.disconnect();
      }
      if (localInputStream1 != null)
      {
        com.tencent.mm.a.e.l(localInputStream1);
        AppMethodBeat.o(1773);
        return;
      }
      AppMethodBeat.o(1773);
      return;
      label2096:
      i = 3;
      break;
      label2101:
      k += 1;
      continue;
      label2110:
      k += 1;
    }
  }
  
  private static boolean a(int paramInt, ckx paramckx, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(1772);
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("mpInfo");
        if ((paramJSONObject != null) && (paramJSONObject.optJSONArray("urlInfo") != null))
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("urlInfo");
          paramInt = 0;
          if (paramInt < localJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)localJSONArray.get(paramInt);
            if ((!localJSONObject.has("url")) || (!localJSONObject.has("filesize"))) {
              break label243;
            }
            paramckx.xVi = localJSONObject.optInt("filesize", 0);
            ckz localckz = new ckz();
            localckz.url = localJSONObject.optString("url");
            localckz.xVo = 0;
            paramckx.xVj.add(localckz);
            break label243;
            paramJSONObject = paramJSONObject.optJSONObject("ctnInfo");
            continue;
          }
          paramckx.xUY = paramJSONObject.optString("coverUrl");
          if (paramckx.xVi > 0L)
          {
            boolean bool = bo.es(paramckx.xVj);
            if (!bool) {}
          }
          else
          {
            AppMethodBeat.o(1772);
            return false;
          }
        }
        else
        {
          AppMethodBeat.o(1772);
          return false;
        }
      }
      catch (Exception paramckx)
      {
        ab.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + paramckx.getMessage());
        AppMethodBeat.o(1772);
        return false;
      }
      AppMethodBeat.o(1772);
      return true;
      label243:
      paramInt += 1;
    }
  }
  
  public final void GH(int paramInt)
  {
    AppMethodBeat.i(1766);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < cKb().size()) {
        cKb().remove(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(1766);
    }
  }
  
  public final ckx GI(int paramInt)
  {
    AppMethodBeat.i(1767);
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < cKb().size())
      {
        ckx localckx = (ckx)cKb().get(paramInt);
        return localckx;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(1767);
    }
  }
  
  public final boolean GJ(int paramInt)
  {
    AppMethodBeat.i(1768);
    if (this.tju)
    {
      ab.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      AppMethodBeat.o(1768);
      return false;
    }
    ab.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.tju = true;
    ckw localckw = com.tencent.mm.plugin.topstory.a.g.a(this.thM.cJf());
    localckw.offset = paramInt;
    Object localObject1;
    if (!bo.isNullOrNil(this.thM.cJf().xUK))
    {
      localObject1 = new up();
      ((up)localObject1).key = "relevant_vid";
      ((up)localObject1).wMN = this.thM.cJf().xUK;
      localckw.uIO.add(localObject1);
    }
    if (!bo.isNullOrNil(this.thM.cJf().xUL))
    {
      localObject1 = new up();
      ((up)localObject1).key = "relevant_expand";
      ((up)localObject1).wMN = this.thM.cJf().xUL;
      localckw.uIO.add(localObject1);
    }
    if (!bo.isNullOrNil(this.thM.cJf().xUM))
    {
      localObject1 = new up();
      ((up)localObject1).key = "relevant_pre_searchid";
      ((up)localObject1).wMN = this.thM.cJf().xUM;
      localckw.uIO.add(localObject1);
    }
    if (!bo.isNullOrNil(this.thM.cJf().xUN))
    {
      localObject1 = new up();
      ((up)localObject1).key = "relevant_shared_openid";
      ((up)localObject1).wMN = this.thM.cJf().xUN;
      localckw.uIO.add(localObject1);
    }
    if (this.thM.cJf().xUQ != null)
    {
      localObject1 = new up();
      ((up)localObject1).key = "rec_category";
      ((up)localObject1).wMM = this.thM.cJf().xUQ.xNd;
      localckw.uIO.add(localObject1);
      localObject1 = localckw.uIO.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!"show_tag_list".equals(((up)((Iterator)localObject1).next()).key));
    }
    label519:
    label905:
    for (paramInt = 0;; paramInt = 1)
    {
      if ((this.thM.cJf().xUQ != null) && (paramInt != 0))
      {
        localObject1 = new up();
        ((up)localObject1).key = "show_tag_list";
        ((up)localObject1).wMN = this.thM.cJf().xUQ.id;
        localckw.uIO.add(localObject1);
      }
      localObject1 = new up();
      ((up)localObject1).key = "fetch_seed_videoinfo";
      Object localObject2;
      label652:
      com.tencent.mm.plugin.topstory.a.b.b localb;
      if ((this.thM.cJf().xUQ != null) && (!bo.isNullOrNil(this.thM.cJf().xUQ.id)))
      {
        ((up)localObject1).wMM = 0L;
        localckw.uIO.add(localObject1);
        if (cKc() == 1)
        {
          localObject1 = GI(0);
          localObject2 = new up();
          ((up)localObject2).key = "first_video_tag_list";
          ((up)localObject2).wMN = com.tencent.mm.plugin.topstory.a.g.dR(((ckx)localObject1).wVo).toString();
          localckw.uIO.add(localObject2);
        }
        localObject1 = this.thM.cJd();
        if (((o)localObject1).tjJ.size() <= 0) {
          break label905;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(((o)localObject1).tjJ.values());
        localObject1 = new StringBuffer("");
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label778;
        }
        localb = (com.tencent.mm.plugin.topstory.a.b.b)((Iterator)localObject2).next();
        if (!localb.tfn) {
          break label773;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        ((StringBuffer)localObject1).append(paramInt);
        ((StringBuffer)localObject1).append("_");
        ((StringBuffer)localObject1).append(localb.tfm.xVa);
        ((StringBuffer)localObject1).append(";");
        break label652;
        localObject1 = new up();
        ((up)localObject1).key = "rec_category";
        ((up)localObject1).wMM = this.thM.cJf().xUO;
        localckw.uIO.add(localObject1);
        break;
        ((up)localObject1).wMM = 1L;
        break label519;
      }
      label778:
      for (localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
      {
        if (!bo.isNullOrNil((String)localObject1))
        {
          localObject2 = new up();
          ((up)localObject2).key = "client_exposed_info";
          ((up)localObject2).wMN = ((String)localObject1);
          localckw.uIO.add(localObject2);
        }
        localObject1 = new up();
        ((up)localObject1).key = "is_prefetch";
        ((up)localObject1).wMM = this.tjv;
        localckw.uIO.add(localObject1);
        this.tjw = new j(localckw);
        com.tencent.mm.kernel.g.Rc().a(this.tjw, 0);
        com.tencent.mm.kernel.g.Rc().a(1943, this.fur);
        a.kS(0);
        AppMethodBeat.o(1768);
        return true;
      }
    }
  }
  
  public final void a(ckw paramckw, int paramInt)
  {
    AppMethodBeat.i(1769);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        List localList = cKb();
        if ((bo.es(localList)) || (paramInt >= localList.size())) {
          return;
        }
        if (paramInt > 0)
        {
          i = paramInt - 1;
          if ((i < localList.size()) && (i < paramInt + 10))
          {
            localArrayList.add(((ckx)localList.get(i)).xVa);
            i += 1;
            continue;
          }
          paramckw = new com.tencent.mm.plugin.topstory.a.c.e(paramckw, localArrayList);
          com.tencent.mm.kernel.g.Rc().a(paramckw, 0);
          com.tencent.mm.kernel.g.Rc().a(paramckw.getType(), new n.2(this, paramckw));
          AppMethodBeat.o(1769);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(1769);
      }
      int i = paramInt;
    }
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1770);
    com.tencent.mm.kernel.g.Rc().b(1943, this.fur);
    AppMethodBeat.o(1770);
  }
  
  public final List<ckx> cKb()
  {
    AppMethodBeat.i(1763);
    LinkedList localLinkedList = this.thM.cJf().xUS;
    AppMethodBeat.o(1763);
    return localLinkedList;
  }
  
  public final int cKc()
  {
    AppMethodBeat.i(1764);
    int i = cKb().size();
    AppMethodBeat.o(1764);
    return i;
  }
  
  public final void e(ckx paramckx)
  {
    AppMethodBeat.i(1765);
    try
    {
      cKb().add(paramckx);
      return;
    }
    finally
    {
      AppMethodBeat.o(1765);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */