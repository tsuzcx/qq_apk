package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.sdk.platformtools.ac;
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

public final class h
  implements com.tencent.mm.al.f
{
  private static h DKB;
  private static final long DKt;
  private volatile s DKA;
  private volatile boolean DKC;
  public com.tencent.mm.sdk.b.c DKD;
  private ap DKu;
  private Set<String> DKv;
  public a DKw;
  private volatile boolean DKx;
  private volatile boolean DKy;
  private volatile CountDownLatch DKz;
  
  static
  {
    AppMethodBeat.i(77950);
    DKt = d.fve() + 500;
    DKB = new h();
    AppMethodBeat.o(77950);
  }
  
  public h()
  {
    AppMethodBeat.i(77941);
    this.DKu = new ap("RecommendLogic_worker");
    this.DKw = new a((byte)0);
    this.DKD = new h.1(this);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.DKD.alive();
    this.DKv = new HashSet();
    this.DKv.add("netType");
    this.DKv.add("time_zone_min");
    this.DKv.add("currentPage");
    this.DKv.add("is_prefetch");
    this.DKv.add("direction");
    this.DKv.add("seq");
    this.DKv.add("client_exposed_info");
    this.DKv.add("requestId");
    this.DKv.add("recType");
    this.DKv.add("redPointMsgId");
    eOf();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.DKu.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77938);
        if (h.a(h.this) != null) {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(h.a(h.this).getCount()) });
        }
        int i;
        for (;;)
        {
          try
          {
            h.a(h.this).await();
            i = paramInt;
            if (h.b(h.this) == null) {
              break;
            }
            int j = h.b(h.this).dCT;
            i = j;
            if (!h.b(h.this).DBq) {
              break;
            }
            i = j;
            if (!h.c(h.this)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
            AppMethodBeat.o(77938);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, h.b(h.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> bt(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 160
    //   8: invokestatic 166	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
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
    //   54: new 184	com/tencent/mm/protocal/protobuf/aag
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/protocal/protobuf/aag:<init>	()V
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
  
  private static s bu(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    s locals = new s();
    locals.dld = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    locals.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    locals.DBb = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sugId");
    locals.DBd = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugType", 0);
    locals.DBc = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "prefixSug");
    locals.DBo = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "poiInfo");
    int i;
    if (com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      locals.DAZ = i;
      locals.pLL = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        locals.sessionId = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sessionId");
      }
      locals.dDa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sceneActionType", 1);
      locals.DBf = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "displayPattern", 2);
      locals.DBg = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugPosition", 0);
      locals.DBh = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sugBuffer");
      locals.dwW = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "requestId");
      locals.sessionId = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sessionId");
      locals.dCW = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "subSessionId");
      locals.DBp = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "tagId");
      Object localObject1 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "extReqParams");
      if (!bt.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aag();
            ((aag)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aag)localObject5).FZe = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aag)localObject5).FZf = ((JSONObject)localObject4).optString("textValue", "");
            locals.DBj.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "matchUser");
    if (!bt.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new dty();
      ((dty)localObject4).nDo = ((JSONObject)localObject2).optString("userName");
      ((dty)localObject4).HGV = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((dty)localObject4).nDo)) {
        locals.DBa.add(localObject4);
      }
      localObject2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "prefixQuery");
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
          locals.DBe.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "tagInfo");
      if (!bt.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        locals.DBi = new dlx();
        locals.DBi.HAs = ((JSONObject)localObject3).optString("tagText");
        locals.DBi.HAr = ((JSONObject)localObject3).optInt("tagType");
        locals.DBi.HAt = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "numConditions");
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
            localObject5 = new ccy();
            ((ccy)localObject5).GXg = ((JSONObject)localObject4).optLong("from");
            ((ccy)localObject5).GXh = ((JSONObject)localObject4).optLong("to");
            ((ccy)localObject5).GXf = ((JSONObject)localObject4).optInt("field");
            locals.DBk.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.dCT = bt.m(paramMap.get("webview_instance_id"), -1);
        locals.language = ac.iM(aj.getContext());
        locals.tug = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
        locals.cSc = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "channelId", 0);
        locals.DBr = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return locals;
  }
  
  public static h eOe()
  {
    return DKB;
  }
  
  private boolean q(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.DKv.containsAll(paramSet)))
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
  
  public final boolean bs(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(bt.m(paramMap.get("webview_instance_id"), -1)).e(com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0), com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query"), paramMap);
    int i;
    if (this.DKx)
    {
      this.DKx = false;
      i = bt.m(paramMap.get("webview_instance_id"), -1);
      if (this.DKA != null) {
        this.DKA.dCT = i;
      }
      if (!q(bt(paramMap)))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.DKy = true;
        if (this.DKz != null) {
          this.DKz.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.DKz != null) {
        this.DKz.countDown();
      }
      if (this.DKA != null) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.DKA.dCT), this.DKA });
      }
      i = 1;
      continue;
      if (this.DKz != null) {
        this.DKz.countDown();
      }
      i = 0;
    }
    paramMap = bu(paramMap);
    a locala = this.DKw;
    if (locala.DKJ != null) {
      locala.DKJ.stopped = true;
    }
    locala.DKJ = new h.a.a(locala, (byte)0);
    locala.DKJ.DBv = paramMap;
    locala.DKE.DKA = paramMap;
    locala.DKJ.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void eOf()
  {
    AppMethodBeat.i(77949);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wh(1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.DKC = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.DKC = q(new HashSet(Arrays.asList(str.split(","))));
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
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof a))
      {
        com.tencent.mm.kernel.g.aiU().b(paramn.getType(), this);
        paramString = (a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.cSK() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.eLK(), paramn, paramString.eLL(), paramString.eLP());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramn = paramString.eLN();
        paramInt1 = paramString.eLO();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.cSK() });
        a(paramString.eLK(), paramn, paramString.eLL(), paramString.eLP());
        if (paramInt1 > 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.faE();
          b.Yx(27);
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
    public a DKI;
    public a DKJ;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      s DBv;
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
        if (bt.isNullOrNil(this.DBv.dld))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.DBv.businessType), Integer.valueOf(this.DBv.scene), Integer.valueOf(this.DBv.DAZ), Integer.valueOf(this.DBv.dDa), this.DBv.pLL, Integer.valueOf(this.DBv.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.DBv.dld, Integer.valueOf(this.DBv.dCT) });
        if (h.a.a(h.a.this) != null) {
          com.tencent.mm.kernel.g.aiU().a(h.a.a(h.a.this));
        }
        if (this.stopped)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.plugin.webview.modeltools.g.eQR().DJV.t(this.DBv.scene, this.DBv.dld, this.DBv.businessType);
        h.a.a(h.a.this, h.a.a(this.DBv));
        com.tencent.mm.kernel.g.aiU().a(h.a.a(h.a.this).getType(), h.this);
        com.tencent.mm.kernel.g.aiU().a(h.a.a(h.a.this), 0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(h.a.a(h.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */