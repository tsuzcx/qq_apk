package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  implements com.tencent.mm.al.g
{
  private static final long AOW;
  private static g APe;
  private ap AOX;
  private Set<String> AOY;
  public a AOZ;
  private volatile boolean APa;
  private volatile boolean APb;
  private volatile CountDownLatch APc;
  private volatile com.tencent.mm.plugin.websearch.api.q APd;
  private volatile boolean APf;
  public c APg;
  
  static
  {
    AppMethodBeat.i(77950);
    AOW = d.ePs() + 500;
    APe = new g();
    AppMethodBeat.o(77950);
  }
  
  public g()
  {
    AppMethodBeat.i(77941);
    this.AOX = new ap("RecommendLogic_worker");
    this.AOZ = new a((byte)0);
    this.APg = new g.1(this);
    ad.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    ad.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.APg.alive();
    this.AOY = new HashSet();
    this.AOY.add("netType");
    this.AOY.add("time_zone_min");
    this.AOY.add("currentPage");
    this.AOY.add("is_prefetch");
    this.AOY.add("direction");
    this.AOY.add("seq");
    this.AOY.add("client_exposed_info");
    this.AOY.add("requestId");
    this.AOY.add("recType");
    this.AOY.add("redPointMsgId");
    ejV();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.AOX.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77938);
        if (g.a(g.this) != null) {
          ad.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(g.a(g.this).getCount()) });
        }
        int i;
        for (;;)
        {
          try
          {
            g.a(g.this).await();
            i = paramInt;
            if (g.b(g.this) == null) {
              break;
            }
            int j = g.b(g.this).dtt;
            i = j;
            if (!g.b(g.this).AGf) {
              break;
            }
            i = j;
            if (!g.c(g.this)) {
              break;
            }
            ad.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
            AppMethodBeat.o(77938);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          ad.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        ad.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, g.b(g.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> bl(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 160
    //   8: invokestatic 166	com/tencent/mm/plugin/websearch/api/aa:w	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 172	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   16: ifne +90 -> 106
    //   19: new 103	java/util/HashSet
    //   22: dup
    //   23: invokespecial 104	java/util/HashSet:<init>	()V
    //   26: astore_2
    //   27: new 174	org/json/JSONArray
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 175	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_2
    //   39: astore_0
    //   40: iload_1
    //   41: aload_3
    //   42: invokevirtual 178	org/json/JSONArray:length	()I
    //   45: if_icmpge +54 -> 99
    //   48: aload_3
    //   49: iload_1
    //   50: invokevirtual 182	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   53: astore_0
    //   54: new 184	com/tencent/mm/protocal/protobuf/xp
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/protocal/protobuf/xp:<init>	()V
    //   61: pop
    //   62: aload_2
    //   63: aload_0
    //   64: ldc 187
    //   66: ldc 189
    //   68: invokevirtual 195	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: invokeinterface 114 2 0
    //   76: pop
    //   77: iload_1
    //   78: iconst_1
    //   79: iadd
    //   80: istore_1
    //   81: goto -43 -> 38
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_0
    //   87: ldc 85
    //   89: aload_2
    //   90: ldc 189
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 199	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: ldc 158
    //   101: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: invokestatic 205	java/util/Collections:emptySet	()Ljava/util/Set;
    //   109: astore_0
    //   110: goto -11 -> 99
    //   113: astore_3
    //   114: aload_2
    //   115: astore_0
    //   116: aload_3
    //   117: astore_2
    //   118: goto -31 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramMap	Map<String, Object>
    //   37	44	1	i	int
    //   26	37	2	localHashSet	HashSet
    //   84	31	2	localException1	Exception
    //   117	1	2	localObject	Object
    //   35	14	3	localJSONArray	JSONArray
    //   113	4	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   19	27	84	java/lang/Exception
    //   27	36	113	java/lang/Exception
    //   40	77	113	java/lang/Exception
  }
  
  private static com.tencent.mm.plugin.websearch.api.q bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    com.tencent.mm.plugin.websearch.api.q localq = new com.tencent.mm.plugin.websearch.api.q();
    localq.dcm = aa.w(paramMap, "query");
    localq.offset = aa.d(paramMap, "offset", 0);
    localq.businessType = aa.d(paramMap, "type", 0);
    localq.scene = aa.d(paramMap, "scene", 0);
    localq.AFP = aa.w(paramMap, "sugId");
    localq.AFR = aa.d(paramMap, "sugType", 0);
    localq.AFQ = aa.w(paramMap, "prefixSug");
    localq.AGc = aa.w(paramMap, "poiInfo");
    int i;
    if (aa.x(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localq.AFN = i;
      localq.oEK = aa.w(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localq.sessionId = aa.w(paramMap, "sessionId");
      }
      localq.dtA = aa.d(paramMap, "sceneActionType", 1);
      localq.AFT = aa.d(paramMap, "displayPattern", 2);
      localq.AFU = aa.d(paramMap, "sugPosition", 0);
      localq.AFV = aa.w(paramMap, "sugBuffer");
      localq.dnB = aa.w(paramMap, "requestId");
      localq.sessionId = aa.w(paramMap, "sessionId");
      localq.dtw = aa.w(paramMap, "subSessionId");
      localq.AGd = aa.w(paramMap, "tagId");
      Object localObject1 = aa.w(paramMap, "extReqParams");
      if (!bt.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new xp();
            ((xp)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((xp)localObject5).CZi = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((xp)localObject5).CZj = ((JSONObject)localObject4).optString("textValue", "");
            localq.AFX.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = aa.w(paramMap, "matchUser");
    if (!bt.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new dis();
      ((dis)localObject4).mAQ = ((JSONObject)localObject2).optString("userName");
      ((dis)localObject4).Ezd = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((dis)localObject4).mAQ)) {
        localq.AFO.add(localObject4);
      }
      localObject2 = aa.w(paramMap, "prefixQuery");
      if (bt.isNullOrNil((String)localObject2)) {}
    }
    catch (Exception localException2)
    {
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject4 = ((JSONArray)localObject2).getString(i);
          localq.AFS.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = aa.w(paramMap, "tagInfo");
      if (!bt.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localq.AFW = new day();
        localq.AFW.EsL = ((JSONObject)localObject3).optString("tagText");
        localq.AFW.EsK = ((JSONObject)localObject3).optInt("tagType");
        localq.AFW.EsM = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = aa.w(paramMap, "numConditions");
        if (bt.isNullOrNil((String)localObject3)) {}
      }
      catch (Exception localException4)
      {
        try
        {
          localObject3 = new JSONArray((String)localObject3);
          i = 0;
          while (i < ((JSONArray)localObject3).length())
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            localObject5 = new btq();
            ((btq)localObject5).DRf = ((JSONObject)localObject4).optLong("from");
            ((btq)localObject5).DRg = ((JSONObject)localObject4).optLong("to");
            ((btq)localObject5).DRe = ((JSONObject)localObject4).optInt("field");
            localq.AFY.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        localq.dtt = bt.i(paramMap.get("webview_instance_id"), -1);
        localq.aSt = ac.ir(aj.getContext());
        localq.roM = aa.d(paramMap, "subType", 0);
        localq.cJR = aa.d(paramMap, "channelId", 0);
        localq.AGg = aa.w(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return localq;
  }
  
  public static g ejU()
  {
    return APe;
  }
  
  private boolean i(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.AOY.containsAll(paramSet)))
    {
      AppMethodBeat.o(77942);
      return true;
    }
    AppMethodBeat.o(77942);
    return false;
  }
  
  public static void start()
  {
    AppMethodBeat.i(77948);
    try
    {
      Looper.prepare();
      AppMethodBeat.o(77948);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(77948);
    }
  }
  
  public final boolean bk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    ad.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(bt.i(paramMap.get("webview_instance_id"), -1)).d(aa.d(paramMap, "type", 0), aa.w(paramMap, "query"), paramMap);
    int i;
    if (this.APa)
    {
      this.APa = false;
      i = bt.i(paramMap.get("webview_instance_id"), -1);
      if (this.APd != null) {
        this.APd.dtt = i;
      }
      if (!i(bl(paramMap)))
      {
        ad.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.APb = true;
        if (this.APc != null) {
          this.APc.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.APc != null) {
        this.APc.countDown();
      }
      if (this.APd != null) {
        ad.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.APd.dtt), this.APd });
      }
      i = 1;
      continue;
      if (this.APc != null) {
        this.APc.countDown();
      }
      i = 0;
    }
    paramMap = bm(paramMap);
    a locala = this.AOZ;
    if (locala.APm != null) {
      locala.APm.stopped = true;
    }
    locala.APm = new g.a.a(locala, (byte)0);
    locala.APm.AGj = paramMap;
    locala.APh.APd = paramMap;
    locala.APm.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void ejV()
  {
    AppMethodBeat.i(77949);
    String str = aa.Se(1);
    ad.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.APf = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.APf = i(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(77949);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(77946);
    int i;
    if (paramn != null) {
      i = paramn.getType();
    }
    for (;;)
    {
      ad.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof a))
      {
        com.tencent.mm.kernel.g.aeS().b(paramn.getType(), this);
        paramString = (a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ad.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.cxj() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ehC(), paramn, paramString.ehD(), paramString.ehH());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramn = paramString.ehF();
        paramInt1 = paramString.ehG();
        ad.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.cxj() });
        a(paramString.ehC(), paramn, paramString.ehD(), paramString.ehH());
        if (paramInt1 > 0)
        {
          ad.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.h.a.a.b.ewn();
          com.tencent.mm.pluginsdk.h.a.a.b.Ur(27);
        }
        AppMethodBeat.o(77946);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label128;
      }
    }
  }
  
  public final class a
    implements Comparable
  {
    public a APl;
    public a APm;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      com.tencent.mm.plugin.websearch.api.q AGj;
      public volatile boolean stopped;
      
      private a() {}
      
      public final void run()
      {
        AppMethodBeat.i(77939);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77939);
          return;
        }
        if (bt.isNullOrNil(this.AGj.dcm))
        {
          ad.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.AGj.businessType), Integer.valueOf(this.AGj.scene), Integer.valueOf(this.AGj.AFN), Integer.valueOf(this.AGj.dtA), this.AGj.oEK, Integer.valueOf(this.AGj.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        ad.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.AGj.dcm, Integer.valueOf(this.AGj.dtt) });
        if (g.a.a(g.a.this) != null) {
          com.tencent.mm.kernel.g.aeS().a(g.a.a(g.a.this));
        }
        if (this.stopped)
        {
          ad.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.plugin.webview.modeltools.g.emC().AOw.s(this.AGj.scene, this.AGj.dcm, this.AGj.businessType);
        g.a.a(g.a.this, g.a.a(this.AGj));
        com.tencent.mm.kernel.g.aeS().a(g.a.a(g.a.this).getType(), g.this);
        com.tencent.mm.kernel.g.aeS().a(g.a.a(g.a.this), 0);
        ad.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(g.a.a(g.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */