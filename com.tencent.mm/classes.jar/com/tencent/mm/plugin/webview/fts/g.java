package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  private static final long Chm;
  private static g Chu;
  private ao Chn;
  private Set<String> Cho;
  public a Chp;
  private volatile boolean Chq;
  private volatile boolean Chr;
  private volatile CountDownLatch Chs;
  private volatile p Cht;
  private volatile boolean Chv;
  public c Chw;
  
  static
  {
    AppMethodBeat.i(77950);
    Chm = d.feW() + 500;
    Chu = new g();
    AppMethodBeat.o(77950);
  }
  
  public g()
  {
    AppMethodBeat.i(77941);
    this.Chn = new ao("RecommendLogic_worker");
    this.Chp = new a((byte)0);
    this.Chw = new g.1(this);
    ac.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    ac.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.Chw.alive();
    this.Cho = new HashSet();
    this.Cho.add("netType");
    this.Cho.add("time_zone_min");
    this.Cho.add("currentPage");
    this.Cho.add("is_prefetch");
    this.Cho.add("direction");
    this.Cho.add("seq");
    this.Cho.add("client_exposed_info");
    this.Cho.add("requestId");
    this.Cho.add("recType");
    this.Cho.add("redPointMsgId");
    ezq();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.Chn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77938);
        if (g.a(g.this) != null) {
          ac.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(g.a(g.this).getCount()) });
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
            int j = g.b(g.this).drc;
            i = j;
            if (!g.b(g.this).BYx) {
              break;
            }
            i = j;
            if (!g.c(g.this)) {
              break;
            }
            ac.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
            AppMethodBeat.o(77938);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          ac.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        ac.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, g.b(g.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> bq(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 160
    //   8: invokestatic 166	com/tencent/mm/plugin/websearch/api/z:x	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 172	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   54: new 184	com/tencent/mm/protocal/protobuf/yh
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/protocal/protobuf/yh:<init>	()V
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
    //   96: invokestatic 199	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static p br(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    p localp = new p();
    localp.cZL = z.x(paramMap, "query");
    localp.offset = z.d(paramMap, "offset", 0);
    localp.businessType = z.d(paramMap, "type", 0);
    localp.scene = z.d(paramMap, "scene", 0);
    localp.BYi = z.x(paramMap, "sugId");
    localp.BYk = z.d(paramMap, "sugType", 0);
    localp.BYj = z.x(paramMap, "prefixSug");
    localp.BYv = z.x(paramMap, "poiInfo");
    int i;
    if (z.y(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localp.BYg = i;
      localp.pik = z.x(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localp.sessionId = z.x(paramMap, "sessionId");
      }
      localp.drj = z.d(paramMap, "sceneActionType", 1);
      localp.BYm = z.d(paramMap, "displayPattern", 2);
      localp.BYn = z.d(paramMap, "sugPosition", 0);
      localp.BYo = z.x(paramMap, "sugBuffer");
      localp.dlj = z.x(paramMap, "requestId");
      localp.sessionId = z.x(paramMap, "sessionId");
      localp.drf = z.x(paramMap, "subSessionId");
      localp.BYw = z.x(paramMap, "tagId");
      Object localObject1 = z.x(paramMap, "extReqParams");
      if (!bs.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new yh();
            ((yh)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((yh)localObject5).ErV = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((yh)localObject5).ErW = ((JSONObject)localObject4).optString("textValue", "");
            localp.BYq.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = z.x(paramMap, "matchUser");
    if (!bs.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new doh();
      ((doh)localObject4).ncR = ((JSONObject)localObject2).optString("userName");
      ((doh)localObject4).FWf = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((doh)localObject4).ncR)) {
        localp.BYh.add(localObject4);
      }
      localObject2 = z.x(paramMap, "prefixQuery");
      if (bs.isNullOrNil((String)localObject2)) {}
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
          localp.BYl.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = z.x(paramMap, "tagInfo");
      if (!bs.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localp.BYp = new dgk();
        localp.BYp.FPN = ((JSONObject)localObject3).optString("tagText");
        localp.BYp.FPM = ((JSONObject)localObject3).optInt("tagType");
        localp.BYp.FPO = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = z.x(paramMap, "numConditions");
        if (bs.isNullOrNil((String)localObject3)) {}
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
            localObject5 = new byh();
            ((byh)localObject5).Fnx = ((JSONObject)localObject4).optLong("from");
            ((byh)localObject5).Fny = ((JSONObject)localObject4).optLong("to");
            ((byh)localObject5).Fnw = ((JSONObject)localObject4).optInt("field");
            localp.BYr.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        localp.drc = bs.l(paramMap.get("webview_instance_id"), -1);
        localp.aTm = ab.iC(ai.getContext());
        localp.sxF = z.d(paramMap, "subType", 0);
        localp.cGY = z.d(paramMap, "channelId", 0);
        localp.BYy = z.x(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return localp;
  }
  
  public static g ezp()
  {
    return Chu;
  }
  
  private boolean j(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.Cho.containsAll(paramSet)))
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
  
  public final boolean bp(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    ac.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(bs.l(paramMap.get("webview_instance_id"), -1)).d(z.d(paramMap, "type", 0), z.x(paramMap, "query"), paramMap);
    int i;
    if (this.Chq)
    {
      this.Chq = false;
      i = bs.l(paramMap.get("webview_instance_id"), -1);
      if (this.Cht != null) {
        this.Cht.drc = i;
      }
      if (!j(bq(paramMap)))
      {
        ac.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.Chr = true;
        if (this.Chs != null) {
          this.Chs.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.Chs != null) {
        this.Chs.countDown();
      }
      if (this.Cht != null) {
        ac.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.Cht.drc), this.Cht });
      }
      i = 1;
      continue;
      if (this.Chs != null) {
        this.Chs.countDown();
      }
      i = 0;
    }
    paramMap = br(paramMap);
    a locala = this.Chp;
    if (locala.ChC != null) {
      locala.ChC.stopped = true;
    }
    locala.ChC = new g.a.a(locala, (byte)0);
    locala.ChC.BYB = paramMap;
    locala.Chx.Cht = paramMap;
    locala.ChC.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void ezq()
  {
    AppMethodBeat.i(77949);
    String str = z.Uo(1);
    ac.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.Chv = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.Chv = j(new HashSet(Arrays.asList(str.split(","))));
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
      ac.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof a))
      {
        com.tencent.mm.kernel.g.agi().b(paramn.getType(), this);
        paramString = (a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ac.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.cKv() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ewW(), paramn, paramString.ewX(), paramString.exb());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramn = paramString.ewZ();
        paramInt1 = paramString.exa();
        ac.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.cKv() });
        a(paramString.ewW(), paramn, paramString.ewX(), paramString.exb());
        if (paramInt1 > 0)
        {
          ac.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.h.a.a.b.eLH();
          com.tencent.mm.pluginsdk.h.a.a.b.WB(27);
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
    public a ChB;
    public a ChC;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      p BYB;
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
        if (bs.isNullOrNil(this.BYB.cZL))
        {
          ac.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.BYB.businessType), Integer.valueOf(this.BYB.scene), Integer.valueOf(this.BYB.BYg), Integer.valueOf(this.BYB.drj), this.BYB.pik, Integer.valueOf(this.BYB.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        ac.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.BYB.cZL, Integer.valueOf(this.BYB.drc) });
        if (g.a.a(g.a.this) != null) {
          com.tencent.mm.kernel.g.agi().a(g.a.a(g.a.this));
        }
        if (this.stopped)
        {
          ac.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.plugin.webview.modeltools.g.eBX().CgO.u(this.BYB.scene, this.BYB.cZL, this.BYB.businessType);
        g.a.a(g.a.this, g.a.a(this.BYB));
        com.tencent.mm.kernel.g.agi().a(g.a.a(g.a.this).getType(), g.this);
        com.tencent.mm.kernel.g.agi().a(g.a.a(g.a.this), 0);
        ac.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(g.a.a(g.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */