package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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

public final class i
  implements com.tencent.mm.ak.i
{
  private static final long IOO;
  private static i IOX;
  private MMHandler IOP;
  private Set<String> IOQ;
  public a IOR;
  private volatile boolean IOT;
  private volatile boolean IOU;
  private volatile CountDownLatch IOV;
  private volatile v IOW;
  private volatile boolean IOY;
  public IListener IOZ;
  
  static
  {
    AppMethodBeat.i(77950);
    IOO = d.gGT() + 500;
    IOX = new i();
    AppMethodBeat.o(77950);
  }
  
  public i()
  {
    AppMethodBeat.i(77941);
    this.IOP = new MMHandler("RecommendLogic_worker");
    this.IOR = new a((byte)0);
    this.IOZ = new i.1(this);
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.IOZ.alive();
    this.IOQ = new HashSet();
    this.IOQ.add("netType");
    this.IOQ.add("time_zone_min");
    this.IOQ.add("currentPage");
    this.IOQ.add("is_prefetch");
    this.IOQ.add("direction");
    this.IOQ.add("seq");
    this.IOQ.add("client_exposed_info");
    this.IOQ.add("requestId");
    this.IOQ.add("recType");
    this.IOQ.add("redPointMsgId");
    gaA();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.IOP.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77938);
        if (i.a(i.this) != null) {
          Log.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(i.a(i.this).getCount()) });
        }
        int i;
        for (;;)
        {
          try
          {
            i.a(i.this).await();
            i = paramInt;
            if (i.b(i.this) == null) {
              break;
            }
            int j = i.b(i.this).dVL;
            i = j;
            if (!i.b(i.this).IDV) {
              break;
            }
            i = j;
            if (!i.c(i.this)) {
              break;
            }
            Log.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
            AppMethodBeat.o(77938);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          Log.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        Log.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, i.b(i.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> bD(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 160
    //   8: invokestatic 166	com/tencent/mm/plugin/websearch/api/ai:N	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
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
    //   54: new 184	com/tencent/mm/protocal/protobuf/aca
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/protocal/protobuf/aca:<init>	()V
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
    //   96: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private static v bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    v localv = new v();
    localv.dDv = ai.N(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = ai.b(paramMap, "scene", 0);
    localv.IDG = ai.N(paramMap, "sugId");
    localv.IDI = ai.b(paramMap, "sugType", 0);
    localv.IDH = ai.N(paramMap, "prefixSug");
    localv.IDT = ai.N(paramMap, "poiInfo");
    int i;
    if (ai.O(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localv.IDE = i;
      localv.rjq = ai.N(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.N(paramMap, "sessionId");
      }
      localv.dVS = ai.b(paramMap, "sceneActionType", 1);
      localv.IDK = ai.b(paramMap, "displayPattern", 2);
      localv.IDL = ai.b(paramMap, "sugPosition", 0);
      localv.IDM = ai.N(paramMap, "sugBuffer");
      localv.dPI = ai.N(paramMap, "requestId");
      localv.sessionId = ai.N(paramMap, "sessionId");
      localv.dVO = ai.N(paramMap, "subSessionId");
      localv.IDU = ai.N(paramMap, "tagId");
      Object localObject1 = ai.N(paramMap, "extReqParams");
      if (!Util.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aca();
            ((aca)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aca)localObject5).LmC = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aca)localObject5).LmD = ((JSONObject)localObject4).optString("textValue", "");
            localv.IDO.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = ai.N(paramMap, "matchUser");
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new eou();
      ((eou)localObject4).UserName = ((JSONObject)localObject2).optString("userName");
      ((eou)localObject4).NmU = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((eou)localObject4).UserName)) {
        localv.IDF.add(localObject4);
      }
      localObject2 = ai.N(paramMap, "prefixQuery");
      if (Util.isNullOrNil((String)localObject2)) {}
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
          localv.IDJ.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = ai.N(paramMap, "tagInfo");
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localv.IDN = new egk();
        localv.IDN.Ngs = ((JSONObject)localObject3).optString("tagText");
        localv.IDN.Ngr = ((JSONObject)localObject3).optInt("tagType");
        localv.IDN.Ngt = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = ai.N(paramMap, "numConditions");
        if (Util.isNullOrNil((String)localObject3)) {}
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
            localObject5 = new ctz();
            ((ctz)localObject5).Mzn = ((JSONObject)localObject4).optLong("from");
            ((ctz)localObject5).Mzo = ((JSONObject)localObject4).optLong("to");
            ((ctz)localObject5).Mzm = ((JSONObject)localObject4).optInt("field");
            localv.IDP.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        localv.dVL = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        localv.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        localv.wVW = ai.b(paramMap, "subType", 0);
        localv.channelId = ai.b(paramMap, "channelId", 0);
        localv.IDW = ai.N(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return localv;
  }
  
  public static i gaz()
  {
    return IOX;
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
  
  private boolean w(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.IOQ.containsAll(paramSet)))
    {
      AppMethodBeat.o(77942);
      return true;
    }
    AppMethodBeat.o(77942);
    return false;
  }
  
  public final boolean bC(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    Log.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(Util.nullAsInt(paramMap.get("webview_instance_id"), -1)).d(ai.b(paramMap, "type", 0), ai.N(paramMap, "query"), paramMap);
    int i;
    if (this.IOT)
    {
      this.IOT = false;
      i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
      if (this.IOW != null) {
        this.IOW.dVL = i;
      }
      if (!w(bD(paramMap)))
      {
        Log.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.IOU = true;
        if (this.IOV != null) {
          this.IOV.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.IOV != null) {
        this.IOV.countDown();
      }
      if (this.IOW != null) {
        Log.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.IOW.dVL), this.IOW });
      }
      i = 1;
      continue;
      if (this.IOV != null) {
        this.IOV.countDown();
      }
      i = 0;
    }
    paramMap = bE(paramMap);
    a locala = this.IOR;
    if (locala.IPf != null) {
      locala.IPf.stopped = true;
    }
    locala.IPf = new i.a.a(locala, (byte)0);
    locala.IPf.IDt = paramMap;
    locala.IPa.IOW = paramMap;
    locala.IPf.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void gaA()
  {
    AppMethodBeat.i(77949);
    String str = ai.fXW();
    Log.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.IOY = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.IOY = w(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(77949);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(77946);
    int i;
    if (paramq != null) {
      i = paramq.getType();
    }
    for (;;)
    {
      Log.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramq instanceof a))
      {
        com.tencent.mm.kernel.g.azz().b(paramq.getType(), this);
        paramString = (a)paramq;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.getKeyword() });
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("ret", -1);
        label128:
        paramq = paramq.toString();
        a(paramString.fXz(), paramq, paramString.fXA(), paramString.fXE());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramq = paramString.fXC();
        paramInt1 = paramString.fXD();
        Log.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.fXz(), paramq, paramString.fXA(), paramString.fXE());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.gnC();
          b.ahP(27);
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
    public a IPe;
    public a IPf;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      v IDt;
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
        if (Util.isNullOrNil(this.IDt.dDv))
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.IDt.businessType), Integer.valueOf(this.IDt.scene), Integer.valueOf(this.IDt.IDE), Integer.valueOf(this.IDt.dVS), this.IDt.rjq, Integer.valueOf(this.IDt.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        Log.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.IDt.dDv, Integer.valueOf(this.IDt.dVL) });
        if (i.a.a(i.a.this) != null) {
          com.tencent.mm.kernel.g.azz().a(i.a.a(i.a.this));
        }
        if (this.stopped)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        com.tencent.mm.plugin.webview.modeltools.g.gds().IOd.v(this.IDt.scene, this.IDt.dDv, this.IDt.businessType);
        i.a.a(i.a.this, i.a.a(this.IDt));
        com.tencent.mm.kernel.g.azz().a(i.a.a(i.a.this).getType(), i.this);
        com.tencent.mm.kernel.g.azz().a(i.a.a(i.a.this), 0);
        Log.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(i.a.a(i.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i
 * JD-Core Version:    0.7.0.1
 */