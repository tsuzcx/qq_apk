package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.ak.f
{
  private static final long Ecr;
  private static h Ecz;
  private volatile boolean EcA;
  public com.tencent.mm.sdk.b.c EcB;
  private aq Ecs;
  private Set<String> Ect;
  public a Ecu;
  private volatile boolean Ecv;
  private volatile boolean Ecw;
  private volatile CountDownLatch Ecx;
  private volatile s Ecy;
  
  static
  {
    AppMethodBeat.i(77950);
    Ecr = d.fzf() + 500;
    Ecz = new h();
    AppMethodBeat.o(77950);
  }
  
  public h()
  {
    AppMethodBeat.i(77941);
    this.Ecs = new aq("RecommendLogic_worker");
    this.Ecu = new a((byte)0);
    this.EcB = new h.1(this);
    ae.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    ae.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.EcB.alive();
    this.Ect = new HashSet();
    this.Ect.add("netType");
    this.Ect.add("time_zone_min");
    this.Ect.add("currentPage");
    this.Ect.add("is_prefetch");
    this.Ect.add("direction");
    this.Ect.add("seq");
    this.Ect.add("client_exposed_info");
    this.Ect.add("requestId");
    this.Ect.add("recType");
    this.Ect.add("redPointMsgId");
    eRQ();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.Ecs.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77938);
        if (h.a(h.this) != null) {
          ae.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(h.a(h.this).getCount()) });
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
            int j = h.b(h.this).dDY;
            i = j;
            if (!h.b(h.this).DTn) {
              break;
            }
            i = j;
            if (!h.c(h.this)) {
              break;
            }
            ae.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
            AppMethodBeat.o(77938);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          ae.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        ae.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, h.b(h.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  private static s bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    s locals = new s();
    locals.dmf = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    locals.scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    locals.DSY = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sugId");
    locals.DTa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugType", 0);
    locals.DSZ = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "prefixSug");
    locals.DTl = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "poiInfo");
    int i;
    if (com.tencent.mm.plugin.websearch.api.ad.B(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      locals.DSW = i;
      locals.pSq = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        locals.sessionId = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sessionId");
      }
      locals.dEf = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sceneActionType", 1);
      locals.DTc = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "displayPattern", 2);
      locals.DTd = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugPosition", 0);
      locals.DTe = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sugBuffer");
      locals.dyb = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "requestId");
      locals.sessionId = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sessionId");
      locals.dEb = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "subSessionId");
      locals.DTm = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "tagId");
      Object localObject1 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "extReqParams");
      if (!bu.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aaj();
            ((aaj)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aaj)localObject5).GrE = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aaj)localObject5).GrF = ((JSONObject)localObject4).optString("textValue", "");
            locals.DTg.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "matchUser");
    if (!bu.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new duv();
      ((duv)localObject4).nIJ = ((JSONObject)localObject2).optString("userName");
      ((duv)localObject4).IaI = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((duv)localObject4).nIJ)) {
        locals.DSX.add(localObject4);
      }
      localObject2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "prefixQuery");
      if (bu.isNullOrNil((String)localObject2)) {}
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
          locals.DTb.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "tagInfo");
      if (!bu.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        locals.DTf = new dmu();
        locals.DTf.HUf = ((JSONObject)localObject3).optString("tagText");
        locals.DTf.HUe = ((JSONObject)localObject3).optInt("tagType");
        locals.DTf.HUg = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "numConditions");
        if (bu.isNullOrNil((String)localObject3)) {}
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
            localObject5 = new cds();
            ((cds)localObject5).HqG = ((JSONObject)localObject4).optLong("from");
            ((cds)localObject5).HqH = ((JSONObject)localObject4).optLong("to");
            ((cds)localObject5).HqF = ((JSONObject)localObject4).optInt("field");
            locals.DTh.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.dDY = bu.m(paramMap.get("webview_instance_id"), -1);
        locals.language = com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext());
        locals.tEX = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
        locals.cSM = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "channelId", 0);
        locals.DTo = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return locals;
  }
  
  /* Error */
  private static Set<String> bz(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 476
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 268
    //   10: invokestatic 169	com/tencent/mm/plugin/websearch/api/ad:A	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 274	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifne +94 -> 112
    //   21: new 103	java/util/HashSet
    //   24: dup
    //   25: invokespecial 104	java/util/HashSet:<init>	()V
    //   28: astore_2
    //   29: new 276	org/json/JSONArray
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 277	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload_1
    //   43: aload_3
    //   44: invokevirtual 280	org/json/JSONArray:length	()I
    //   47: if_icmpge +57 -> 104
    //   50: aload_3
    //   51: iload_1
    //   52: invokevirtual 284	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore_0
    //   56: new 286	com/tencent/mm/protocal/protobuf/aaj
    //   59: dup
    //   60: invokespecial 287	com/tencent/mm/protocal/protobuf/aaj:<init>	()V
    //   63: pop
    //   64: aload_2
    //   65: aload_0
    //   66: ldc_w 289
    //   69: ldc_w 291
    //   72: invokevirtual 297	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokeinterface 114 2 0
    //   80: pop
    //   81: iload_1
    //   82: iconst_1
    //   83: iadd
    //   84: istore_1
    //   85: goto -45 -> 40
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: ldc 85
    //   93: aload_2
    //   94: ldc_w 291
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 326	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: ldc_w 476
    //   107: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: invokestatic 482	java/util/Collections:emptySet	()Ljava/util/Set;
    //   115: astore_0
    //   116: goto -12 -> 104
    //   119: astore_3
    //   120: aload_2
    //   121: astore_0
    //   122: aload_3
    //   123: astore_2
    //   124: goto -33 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramMap	Map<String, Object>
    //   39	46	1	i	int
    //   28	37	2	localHashSet	HashSet
    //   88	33	2	localException1	Exception
    //   123	1	2	localObject	Object
    //   37	14	3	localJSONArray	JSONArray
    //   119	4	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   21	29	88	java/lang/Exception
    //   29	38	119	java/lang/Exception
    //   42	81	119	java/lang/Exception
  }
  
  public static h eRP()
  {
    return Ecz;
  }
  
  private boolean q(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.Ect.containsAll(paramSet)))
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
  
  public final boolean by(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    ae.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(bu.m(paramMap.get("webview_instance_id"), -1)).e(com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0), com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "query"), paramMap);
    int i;
    if (this.Ecv)
    {
      this.Ecv = false;
      i = bu.m(paramMap.get("webview_instance_id"), -1);
      if (this.Ecy != null) {
        this.Ecy.dDY = i;
      }
      if (!q(bz(paramMap)))
      {
        ae.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.Ecw = true;
        if (this.Ecx != null) {
          this.Ecx.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.Ecx != null) {
        this.Ecx.countDown();
      }
      if (this.Ecy != null) {
        ae.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.Ecy.dDY), this.Ecy });
      }
      i = 1;
      continue;
      if (this.Ecx != null) {
        this.Ecx.countDown();
      }
      i = 0;
    }
    paramMap = bA(paramMap);
    a locala = this.Ecu;
    if (locala.EcH != null) {
      locala.EcH.stopped = true;
    }
    locala.EcH = new h.a.a(locala, (byte)0);
    locala.EcH.DTs = paramMap;
    locala.EcC.Ecy = paramMap;
    locala.EcH.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void eRQ()
  {
    AppMethodBeat.i(77949);
    String str = com.tencent.mm.plugin.websearch.api.ad.WO(1);
    ae.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.EcA = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.EcA = q(new HashSet(Arrays.asList(str.split(","))));
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
      ae.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof a))
      {
        com.tencent.mm.kernel.g.ajj().b(paramn.getType(), this);
        paramString = (a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ae.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.cVp() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ePt(), paramn, paramString.ePu(), paramString.ePy());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramn = paramString.ePw();
        paramInt1 = paramString.ePx();
        ae.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.cVp() });
        a(paramString.ePt(), paramn, paramString.ePu(), paramString.ePy());
        if (paramInt1 > 0)
        {
          ae.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.fes();
          b.Zd(27);
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
    public a EcG;
    public a EcH;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      s DTs;
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
        if (bu.isNullOrNil(this.DTs.dmf))
        {
          ae.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.DTs.businessType), Integer.valueOf(this.DTs.scene), Integer.valueOf(this.DTs.DSW), Integer.valueOf(this.DTs.dEf), this.DTs.pSq, Integer.valueOf(this.DTs.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        ae.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.DTs.dmf, Integer.valueOf(this.DTs.dDY) });
        if (h.a.a(h.a.this) != null) {
          com.tencent.mm.kernel.g.ajj().a(h.a.a(h.a.this));
        }
        if (this.stopped)
        {
          ae.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.plugin.webview.modeltools.g.eUD().EbT.t(this.DTs.scene, this.DTs.dmf, this.DTs.businessType);
        h.a.a(h.a.this, h.a.a(this.DTs));
        com.tencent.mm.kernel.g.ajj().a(h.a.a(h.a.this).getType(), h.this);
        com.tencent.mm.kernel.g.ajj().a(h.a.a(h.a.this), 0);
        ae.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(h.a.a(h.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */