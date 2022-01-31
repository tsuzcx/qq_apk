package com.tencent.mm.plugin.topstory.ui.video;

import android.webkit.URLUtil;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.topstory.a.c.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.c.bse;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
  f eeo = new n.3(this);
  public b pEp;
  public boolean pFX;
  public int pFY;
  c pFZ;
  private int pGa;
  private int pGb;
  
  private static List<byg> a(boolean paramBoolean, JSONArray paramJSONArray)
  {
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
        long l3 = bk.UZ();
        int j = 0;
        if (j < localJSONArray1.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray1.get(j);
          String str2 = localJSONObject.optString("videoApi");
          String str3 = localJSONObject.optString("videoId");
          String str4 = localJSONObject.optString("videoPlatform");
          String str5 = localJSONObject.optString("docID");
          JSONArray localJSONArray3 = localJSONObject.optJSONArray("show_tag_list");
          JSONArray localJSONArray2 = localJSONObject.optJSONArray("feedback");
          int m = localJSONObject.optInt("mediaDuration", 0);
          Object localObject2 = localJSONObject.optJSONObject("videoInfo");
          localObject1 = null;
          if (localObject2 != null) {
            localObject1 = ((JSONObject)localObject2).optJSONObject("videoCdnInfo");
          }
          if (!bk.bl(str3))
          {
            localObject2 = new byg();
            ((byg)localObject2).tOx = str3;
            if ((localObject1 != null) && (((JSONObject)localObject1).optInt("cdnScene", 0) == 1))
            {
              if (!a((byg)localObject2, (JSONObject)localObject1)) {}
            }
            else
            {
              for (int k = 1;; k = 0)
              {
                ((byg)localObject2).videoUrl = com.tencent.mm.plugin.topstory.a.g.cO(((byg)localObject2).tOG);
                if (bk.bl(((byg)localObject2).videoUrl)) {
                  a.jdMethod_if(11);
                }
                ((byg)localObject2).tOw = m;
                ((byg)localObject2).title = localJSONObject.optString("title");
                ((byg)localObject2).jxS = localJSONObject.optString("shareTitle");
                ((byg)localObject2).oBT = localJSONObject.optString("shareDesc");
                ((byg)localObject2).qUd = localJSONObject.optString("shareImgUrl");
                ((byg)localObject2).qUe = localJSONObject.optString("shareString");
                ((byg)localObject2).qUf = localJSONObject.optString("shareStringUrl");
                ((byg)localObject2).aWf = localJSONObject.optString("source");
                ((byg)localObject2).mSy = localJSONObject.optString("sourceUrl");
                ((byg)localObject2).jxR = localJSONObject.optString("shareUrl");
                ((byg)localObject2).tOy = localJSONObject.optLong("relevant_category", -1L);
                ((byg)localObject2).tOz = localJSONObject.optString("shareOpenId");
                ((byg)localObject2).tOA = localJSONObject.optString("expand");
                ((byg)localObject2).qUg = localJSONObject.optString("strPlayCount");
                ((byg)localObject2).qUh = localJSONObject.optString("titleUrl");
                ((byg)localObject2).tOB = localJSONObject.optInt("itemType");
                ((byg)localObject2).tOD = localJSONObject.optString("bizIcon");
                ((byg)localObject2).tOJ = localJSONObject.optLong("shareChannelId", ((byg)localObject2).tOy);
                ((byg)localObject2).timestamp = l3;
                ((byg)localObject2).bHj = false;
                ((byg)localObject2).qVw = str5;
                ((byg)localObject2).tOE = l1;
                ((byg)localObject2).bGn = l2;
                ((byg)localObject2).tOC = str1;
                ((byg)localObject2).tOI = localJSONObject.optInt("switchFlag", 0);
                ((byg)localObject2).sgk = localJSONObject.optInt("insertPos", 0);
                if (localJSONArray3 == null) {
                  break;
                }
                m = 0;
                while (m < localJSONArray3.length())
                {
                  localObject1 = new bse();
                  ((bse)localObject1).id = localJSONArray3.getJSONObject(m).optString("id");
                  ((bse)localObject1).bQZ = localJSONArray3.getJSONObject(m).optString("wording");
                  ((bse)localObject1).tIP = localJSONArray3.getJSONObject(m).optLong("category");
                  ((bse)localObject1).actionType = localJSONArray3.getJSONObject(m).optInt("actionType");
                  ((bse)localObject1).url = localJSONArray3.getJSONObject(m).optString("url");
                  ((bse)localObject1).title = localJSONArray3.getJSONObject(m).optString("title");
                  ((bse)localObject1).imV = localJSONArray3.getJSONObject(m).optString("subTitle");
                  ((bse)localObject1).bVO = localJSONArray3.getJSONObject(m).optString("icon");
                  ((byg)localObject2).sXo.add(localObject1);
                  m += 1;
                }
                if (bk.bl(str2)) {
                  break label1017;
                }
                a((byg)localObject2, str2, str4);
              }
              if (localJSONArray2 != null)
              {
                m = 0;
                while (m < localJSONArray2.length())
                {
                  localObject1 = new zc();
                  ((zc)localObject1).id = localJSONArray2.optJSONObject(m).optString("id", "");
                  ((zc)localObject1).bQZ = localJSONArray2.optJSONObject(m).optString("wording", "");
                  ((byg)localObject2).tOH.add(localObject1);
                  m += 1;
                }
              }
              if (!paramBoolean) {
                break label1024;
              }
              ((byg)localObject2).dQQ = 360;
              ((byg)localObject2).dQP = 640;
              if (bk.bl(((byg)localObject2).tOv)) {
                ((byg)localObject2).tOv = localJSONObject.optString("thumbUrl");
              }
              label911:
              if (k != 0) {
                y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "useCdnData, vid:%s, title:%s, size:%s", new Object[] { ((byg)localObject2).tOx, ((byg)localObject2).title, Long.valueOf(((byg)localObject2).tOF) });
              }
              if (bk.bl(((byg)localObject2).videoUrl)) {
                break label1111;
              }
              y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "videoid: %s, videoUrl: %s, videoSize: %s", new Object[] { ((byg)localObject2).tOx, ((byg)localObject2).videoUrl, Long.valueOf(((byg)localObject2).tOF) });
              localArrayList.add(localObject2);
            }
          }
          for (;;)
          {
            label1017:
            j += 1;
            break;
            label1024:
            if (bk.bl(((byg)localObject2).tOv)) {
              ((byg)localObject2).tOv = ("http://shp.qpic.cn/qqvideo_ori/0/" + ((byg)localObject2).tOx + String.format("_%s_%s/0", new Object[] { Integer.valueOf(496), Integer.valueOf(280) }));
            }
            ((byg)localObject2).dQQ = 496;
            ((byg)localObject2).dQP = 280;
            break label911;
            label1111:
            y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "Can not add video %s", new Object[] { ((byg)localObject2).tOx });
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static void a(byg parambyg, String paramString1, String paramString2)
  {
    Object localObject5 = null;
    InputStream localInputStream1 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    u localu = null;
    String str3 = null;
    String str4 = null;
    Object localObject4 = null;
    Object localObject8 = new StringBuilder("");
    String str2 = str3;
    Object localObject2 = localObject6;
    InputStream localInputStream2 = localInputStream1;
    String str1 = str4;
    Object localObject1 = localObject7;
    Object localObject3 = localObject5;
    try
    {
      if (!com.tencent.mm.plugin.topstory.a.g.bNg()) {
        break label606;
      }
      k = 2;
    }
    catch (Exception parambyg)
    {
      int k;
      for (;;)
      {
        str1 = str2;
        localObject1 = localObject2;
        localObject3 = localInputStream2;
        y.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoDataMgr", parambyg, "getVideoUrlByVideoApi error: %s", new Object[] { parambyg.getMessage() });
        if (localObject2 != null) {
          ((u)localObject2).aRG.disconnect();
        }
        if (str2 != null) {
          str2.eOx.disconnect();
        }
        if (localInputStream2 != null) {
          com.tencent.mm.a.e.j(localInputStream2);
        }
        return;
        k = -1;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        str2 = str3;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = str4;
        localObject1 = localObject7;
        localObject3 = localObject5;
        if (aq.is3G(ae.getContext()))
        {
          i = 3;
        }
        else
        {
          str2 = str3;
          localObject2 = localObject6;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localObject7;
          localObject3 = localObject5;
          if (!aq.is4G(ae.getContext())) {
            break;
          }
          i = 4;
          continue;
          str2 = str3;
          localObject2 = localObject6;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localObject7;
          localObject3 = localObject5;
          localu = com.tencent.mm.network.b.a(paramString1, null);
          str2 = str3;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localu;
          localObject3 = localObject5;
          localu.setUseCaches(true);
          str2 = str3;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localu;
          localObject3 = localObject5;
          localu.setConnectTimeout(3000);
          str2 = str3;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localu;
          localObject3 = localObject5;
          localu.setReadTimeout(3000);
          str2 = str3;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = str4;
          localObject1 = localu;
          localObject3 = localObject5;
          localInputStream1 = localu.getInputStream();
          paramString1 = (String)localObject4;
        }
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject4 = new JSONObject(((StringBuilder)localObject8).toString().substring(13));
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject5 = ((JSONObject)localObject4).optJSONObject("fl");
      if (localObject5 == null) {
        break label1110;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject5 = ((JSONObject)localObject5).optJSONArray("fi");
      if (localObject5 == null) {
        break label1110;
      }
      m = 0;
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (m >= ((JSONArray)localObject5).length()) {
        break label1110;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject6 = ((JSONArray)localObject5).getJSONObject(m);
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (((JSONObject)localObject6).optInt("sl", 0) != 1) {
        break label2165;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      parambyg.tOF = ((JSONObject)localObject6).optLong("fs");
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject5 = ((JSONObject)localObject4).optJSONObject("vl");
      localObject7 = null;
      localObject6 = null;
      localObject4 = null;
      if (localObject5 == null) {
        break label2046;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject8 = ((JSONObject)localObject5).optJSONArray("vi");
      if (localObject8 == null) {
        break label2046;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (((JSONArray)localObject8).length() <= 0) {
        break label2046;
      }
      m = 0;
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (m >= ((JSONArray)localObject8).length()) {
        break label2046;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject9 = ((JSONArray)localObject8).getJSONObject(m);
      localObject5 = localObject4;
      if (localObject9 == null) {
        break label1589;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      str3 = ((JSONObject)localObject9).optString("fn");
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      str4 = ((JSONObject)localObject9).optString("fvkey");
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject9 = ((JSONObject)localObject9).optJSONObject("ul");
      localObject6 = str4;
      localObject7 = str3;
      localObject5 = localObject4;
      if (localObject9 == null) {
        break label1589;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject9 = ((JSONObject)localObject9).optJSONArray("ui");
      localObject6 = str4;
      localObject7 = str3;
      localObject5 = localObject4;
      if (localObject9 == null) {
        break label1589;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      localObject6 = str4;
      localObject7 = str3;
      localObject5 = localObject4;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (((JSONArray)localObject9).length() <= 0) {
        break label1589;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject9 = ((JSONArray)localObject9).getJSONObject(0);
      localObject6 = str4;
      localObject7 = str3;
      localObject5 = localObject4;
      if (localObject9 == null) {
        break label1589;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject5 = ((JSONObject)localObject9).optString("url");
      localObject7 = str3;
      localObject6 = str4;
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (bk.bl((String)localObject5)) {
        break label2152;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (bk.bl((String)localObject6)) {
        break label2152;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (bk.bl(localObject7)) {
        break label2152;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      str3 = (String)localObject5 + localObject7 + "?vkey=" + (String)localObject6;
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      localObject4 = str3;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (bk.bl(paramString2)) {
        break label1816;
      }
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      localObject4 = str3 + "&platform=" + paramString2;
      str2 = paramString1;
      localObject2 = localu;
      localInputStream2 = localInputStream1;
      str1 = paramString1;
      localObject1 = localu;
      localObject3 = localInputStream1;
      if (!bk.bl((String)localObject4)) {
        break label1881;
      }
      for (;;)
      {
        str2 = paramString1;
        localObject2 = localu;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localu;
        localObject3 = localInputStream1;
        parambyg.tOG.add(localObject4);
        break;
        str2 = paramString1;
        localObject2 = localu;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localu;
        localObject3 = localInputStream1;
        localObject4 = (String)localObject4 + "&" + "Unicomtype=" + k + "&newnettype=" + i + "&Netoperator=" + j;
        str2 = paramString1;
        localObject2 = localu;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localu;
        localObject3 = localInputStream1;
        y.d("MicroMsg.TopStory.TopStoryVideoDataMgr", "joinUrlWithNetInfo: " + (String)localObject4);
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label2021;
      }
      ((u)localObject1).aRG.disconnect();
      if (str1 == null) {
        break label2034;
      }
      str1.eOx.disconnect();
      if (localObject3 == null) {
        break label2044;
      }
      com.tencent.mm.a.e.j((InputStream)localObject3);
    }
    str2 = str3;
    localObject2 = localObject6;
    localInputStream2 = localInputStream1;
    str1 = str4;
    localObject1 = localObject7;
    localObject3 = localObject5;
    int i;
    label155:
    int m;
    int j;
    switch (aq.getNetType(ae.getContext()))
    {
    case -1: 
      str2 = str3;
      localObject2 = localObject6;
      localInputStream2 = localInputStream1;
      str1 = str4;
      localObject1 = localObject7;
      localObject3 = localObject5;
      if (aq.is2G(ae.getContext()))
      {
        i = 2;
        str2 = str3;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = str4;
        localObject1 = localObject7;
        localObject3 = localObject5;
        m = aq.getISPCode(ae.getContext());
        if (m == 0) {
          break label2146;
        }
        str2 = str3;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = str4;
        localObject1 = localObject7;
        localObject3 = localObject5;
        j = m / 100;
        m %= 100;
        if (j != 460) {
          break label2146;
        }
        if ((m == 0) || (m == 2)) {
          break label2084;
        }
        if (m != 7) {
          break label2095;
        }
        break label2084;
        label259:
        str2 = str3;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = str4;
        localObject1 = localObject7;
        localObject3 = localObject5;
        if (!URLUtil.isHttpsUrl(paramString1)) {
          break label698;
        }
        str2 = str3;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = str4;
        localObject1 = localObject7;
        localObject3 = localObject5;
        paramString1 = com.tencent.mm.network.b.oL(paramString1);
        str2 = paramString1;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localObject7;
        localObject3 = localObject5;
        paramString1.Uh();
        str2 = paramString1;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localObject7;
        localObject3 = localObject5;
        paramString1.Uf();
        str2 = paramString1;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localObject7;
        localObject3 = localObject5;
        paramString1.Ug();
        str2 = paramString1;
        localObject2 = localObject6;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localObject7;
        localObject3 = localObject5;
        localInputStream1 = paramString1.eOx.getInputStream();
        str2 = paramString1;
        localObject2 = localu;
        localInputStream2 = localInputStream1;
        str1 = paramString1;
        localObject1 = localu;
        localObject3 = localInputStream1;
        localObject4 = new BufferedReader(new InputStreamReader(localInputStream1));
        for (;;)
        {
          str2 = paramString1;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = paramString1;
          localObject1 = localu;
          localObject3 = localInputStream1;
          localObject5 = ((BufferedReader)localObject4).readLine();
          if (localObject5 == null) {
            break;
          }
          str2 = paramString1;
          localObject2 = localu;
          localInputStream2 = localInputStream1;
          str1 = paramString1;
          localObject1 = localu;
          localObject3 = localInputStream1;
          ((StringBuilder)localObject8).append((String)localObject5);
        }
      }
      break;
    }
    for (;;)
    {
      label606:
      Object localObject9;
      label698:
      label1110:
      label1881:
      label2021:
      label2034:
      label2044:
      label2046:
      if (localu != null) {
        localu.aRG.disconnect();
      }
      label1589:
      if (paramString1 != null) {
        paramString1.eOx.disconnect();
      }
      label1816:
      if (localInputStream1 != null)
      {
        com.tencent.mm.a.e.j(localInputStream1);
        return;
        break;
        label2084:
        j = 3;
        break label259;
        i = 0;
        break label155;
        label2095:
        if ((m == 1) || (m == 6) || (m == 9))
        {
          j = 2;
          break label259;
        }
        if ((m == 3) || (m == 5) || (m == 11))
        {
          j = 1;
          break label259;
        }
        label2146:
        j = 0;
        break label259;
        label2152:
        m += 1;
        localObject4 = localObject5;
        continue;
        label2165:
        m += 1;
      }
    }
  }
  
  private static boolean a(byg parambyg, JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("mpInfo");
        if ((paramJSONObject != null) && (paramJSONObject.optJSONArray("urlInfo") != null))
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("urlInfo");
          i = 0;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
            if ((!localJSONObject.has("url")) || (!localJSONObject.has("filesize"))) {
              break label175;
            }
            parambyg.tOF = localJSONObject.optInt("filesize", 0);
            parambyg.tOG.add(localJSONObject.optString("url"));
            break label175;
          }
          parambyg.tOv = paramJSONObject.optString("coverUrl");
          if (parambyg.tOF > 0L)
          {
            boolean bool = bk.dk(parambyg.tOG);
            if (!bool) {}
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception parambyg)
      {
        y.e("MicroMsg.TopStory.TopStoryVideoDataMgr", "setVideoInfoByCdn exception: " + parambyg.getMessage());
        return false;
      }
      return true;
      label175:
      i += 1;
    }
  }
  
  public final byg Es(int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < cnS().size())
      {
        byg localbyg = (byg)cnS().get(paramInt);
        return localbyg;
      }
      return null;
    }
    finally {}
  }
  
  public final void a(byf parambyf, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      List localList;
      try
      {
        localList = cnS();
        if ((!bk.dk(localList)) && (paramInt < localList.size())) {
          break;
        }
        return;
      }
      finally {}
      if ((i < localList.size()) && (i < paramInt + 10))
      {
        localArrayList.add(((byg)localList.get(i)).tOx);
        i += 1;
      }
      else
      {
        parambyf = new com.tencent.mm.plugin.topstory.a.c.b(parambyf, localArrayList);
        com.tencent.mm.kernel.g.Dk().a(parambyf, 0);
        com.tencent.mm.kernel.g.Dk().a(parambyf.getType(), new n.2(this, parambyf));
        return;
      }
    }
    if (paramInt > 0) {}
    for (int i = paramInt - 1;; i = paramInt) {
      break;
    }
  }
  
  public final void akT()
  {
    com.tencent.mm.kernel.g.Dk().b(1943, this.eeo);
  }
  
  public final int cVn()
  {
    return cnS().size();
  }
  
  public final List<byg> cnS()
  {
    return this.pEp.bNv().tOs;
  }
  
  public final void d(byg parambyg)
  {
    try
    {
      cnS().add(parambyg);
      return;
    }
    finally {}
  }
  
  public final boolean zE(int paramInt)
  {
    if (this.pFX)
    {
      y.w("MicroMsg.TopStory.TopStoryVideoDataMgr", "RequestingData");
      return false;
    }
    y.i("MicroMsg.TopStory.TopStoryVideoDataMgr", "requestData: %s", new Object[] { Integer.valueOf(paramInt) });
    this.pFX = true;
    byf localbyf = com.tencent.mm.plugin.topstory.a.g.a(this.pEp.bNv());
    localbyf.offset = paramInt;
    if (!bk.bl(this.pEp.bNv().tOk))
    {
      localObject1 = new rb();
      ((rb)localObject1).key = "relevant_vid";
      ((rb)localObject1).sOJ = this.pEp.bNv().tOk;
      localbyf.qTG.add(localObject1);
    }
    if (!bk.bl(this.pEp.bNv().tOl))
    {
      localObject1 = new rb();
      ((rb)localObject1).key = "relevant_expand";
      ((rb)localObject1).sOJ = this.pEp.bNv().tOl;
      localbyf.qTG.add(localObject1);
    }
    if (!bk.bl(this.pEp.bNv().tOm))
    {
      localObject1 = new rb();
      ((rb)localObject1).key = "relevant_pre_searchid";
      ((rb)localObject1).sOJ = this.pEp.bNv().tOm;
      localbyf.qTG.add(localObject1);
    }
    if (!bk.bl(this.pEp.bNv().tOn))
    {
      localObject1 = new rb();
      ((rb)localObject1).key = "relevant_shared_openid";
      ((rb)localObject1).sOJ = this.pEp.bNv().tOn;
      localbyf.qTG.add(localObject1);
    }
    Object localObject2;
    label532:
    com.tencent.mm.plugin.topstory.a.b.b localb;
    if (this.pEp.bNv().tOq != null)
    {
      localObject1 = new rb();
      ((rb)localObject1).key = "rec_category";
      ((rb)localObject1).sOI = this.pEp.bNv().tOq.tIP;
      localbyf.qTG.add(localObject1);
      if (this.pEp.bNv().tOq != null)
      {
        localObject1 = new rb();
        ((rb)localObject1).key = "show_tag_list";
        ((rb)localObject1).sOJ = this.pEp.bNv().tOq.id;
        localbyf.qTG.add(localObject1);
      }
      if (cVn() == 1)
      {
        localObject1 = Es(0);
        localObject2 = new rb();
        ((rb)localObject2).key = "first_video_tag_list";
        ((rb)localObject2).sOJ = com.tencent.mm.plugin.topstory.a.g.cP(((byg)localObject1).sXo).toString();
        localbyf.qTG.add(localObject2);
      }
      localObject1 = this.pEp.bNt();
      if (((o)localObject1).pGo.size() <= 0) {
        break label771;
      }
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(((o)localObject1).pGo.values());
      localObject1 = new StringBuffer("");
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label650;
      }
      localb = (com.tencent.mm.plugin.topstory.a.b.b)((Iterator)localObject2).next();
      if (!localb.pDz) {
        break label645;
      }
    }
    label645:
    for (paramInt = 1;; paramInt = 0)
    {
      ((StringBuffer)localObject1).append(paramInt);
      ((StringBuffer)localObject1).append("_");
      ((StringBuffer)localObject1).append(localb.pDy.tOx);
      ((StringBuffer)localObject1).append(";");
      break label532;
      localObject1 = new rb();
      ((rb)localObject1).key = "rec_category";
      ((rb)localObject1).sOI = this.pEp.bNv().tOo;
      localbyf.qTG.add(localObject1);
      break;
    }
    label650:
    for (Object localObject1 = ((StringBuffer)localObject1).toString();; localObject1 = null)
    {
      if (!bk.bl((String)localObject1))
      {
        localObject2 = new rb();
        ((rb)localObject2).key = "client_exposed_info";
        ((rb)localObject2).sOJ = ((String)localObject1);
        localbyf.qTG.add(localObject2);
      }
      localObject1 = new rb();
      ((rb)localObject1).key = "is_prefetch";
      ((rb)localObject1).sOI = this.pFY;
      localbyf.qTG.add(localObject1);
      this.pFZ = new c(localbyf);
      com.tencent.mm.kernel.g.Dk().a(this.pFZ, 0);
      com.tencent.mm.kernel.g.Dk().a(1943, this.eeo);
      a.jdMethod_if(0);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.n
 * JD-Core Version:    0.7.0.1
 */