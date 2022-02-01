package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.sa;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pluginsdk.k.a.a.b;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;
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
  implements com.tencent.mm.an.i
{
  private static final long PLf;
  private static i PLn;
  private MMHandler PLg;
  private Set<String> PLh;
  public a PLi;
  private volatile boolean PLj;
  private volatile boolean PLk;
  private volatile CountDownLatch PLl;
  private volatile v PLm;
  private volatile boolean PLo;
  public IListener PLp;
  
  static
  {
    AppMethodBeat.i(77950);
    PLf = e.hFA() + 500;
    PLn = new i();
    AppMethodBeat.o(77950);
  }
  
  public i()
  {
    AppMethodBeat.i(77941);
    this.PLg = new MMHandler("RecommendLogic_worker");
    this.PLi = new a((byte)0);
    this.PLp = new IListener() {};
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.PLp.alive();
    this.PLh = new HashSet();
    this.PLh.add("netType");
    this.PLh.add("time_zone_min");
    this.PLh.add("currentPage");
    this.PLh.add("is_prefetch");
    this.PLh.add("direction");
    this.PLh.add("seq");
    this.PLh.add("client_exposed_info");
    this.PLh.add("requestId");
    this.PLh.add("recType");
    this.PLh.add("redPointMsgId");
    gTu();
    AppMethodBeat.o(77941);
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.PLg.postToWorker(new Runnable()
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
            int j = i.b(i.this).fPp;
            i = j;
            if (!i.b(i.this).Pyl) {
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).a(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> bI(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 160
    //   8: invokestatic 166	com/tencent/mm/plugin/websearch/api/ai:aa	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
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
    //   54: new 184	com/tencent/mm/protocal/protobuf/aci
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/protocal/protobuf/aci:<init>	()V
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
    //   101: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static v bJ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    v localv = new v();
    localv.fwe = ai.aa(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = ai.b(paramMap, "scene", 0);
    localv.PxW = ai.aa(paramMap, "sugId");
    localv.PxY = ai.b(paramMap, "sugType", 0);
    localv.PxX = ai.aa(paramMap, "prefixSug");
    localv.Pyj = ai.aa(paramMap, "poiInfo");
    int i;
    if (ai.ab(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localv.PxU = i;
      localv.uMC = ai.aa(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.aa(paramMap, "sessionId");
      }
      localv.fPw = ai.b(paramMap, "sceneActionType", 1);
      localv.Pya = ai.b(paramMap, "displayPattern", 2);
      localv.Pyb = ai.b(paramMap, "sugPosition", 0);
      localv.Pyc = ai.aa(paramMap, "sugBuffer");
      localv.fIY = ai.aa(paramMap, "requestId");
      localv.sessionId = ai.aa(paramMap, "sessionId");
      localv.fPs = ai.aa(paramMap, "subSessionId");
      localv.Pyk = ai.aa(paramMap, "tagId");
      Object localObject1 = ai.aa(paramMap, "extReqParams");
      if (!Util.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aci();
            ((aci)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aci)localObject5).SnV = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aci)localObject5).SnW = ((JSONObject)localObject4).optString("textValue", "");
            localv.Pye.add(localObject5);
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
    Object localObject2 = ai.aa(paramMap, "matchUser");
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new ezc();
      ((ezc)localObject4).UserName = ((JSONObject)localObject2).optString("userName");
      ((ezc)localObject4).UzH = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((ezc)localObject4).UserName)) {
        localv.PxV.add(localObject4);
      }
      localObject2 = ai.aa(paramMap, "prefixQuery");
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
          localv.PxZ.add(localObject4);
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
      Object localObject3 = ai.aa(paramMap, "tagInfo");
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localv.Pyd = new eqm();
        localv.Pyd.UsW = ((JSONObject)localObject3).optString("tagText");
        localv.Pyd.UsV = ((JSONObject)localObject3).optInt("tagType");
        localv.Pyd.UsX = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = ai.aa(paramMap, "numConditions");
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
            localObject5 = new ddb();
            ((ddb)localObject5).TKT = ((JSONObject)localObject4).optLong("from");
            ((ddb)localObject5).TKU = ((JSONObject)localObject4).optLong("to");
            ((ddb)localObject5).TKS = ((JSONObject)localObject4).optInt("field");
            localv.Pyf.add(localObject5);
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
        localv.fPp = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        localv.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        localv.BHR = ai.b(paramMap, "subType", 0);
        localv.channelId = ai.b(paramMap, "channelId", 0);
        localv.Pym = ai.aa(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return localv;
  }
  
  public static i gTt()
  {
    return PLn;
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
    if ((paramSet == null) || (this.PLh.containsAll(paramSet)))
    {
      AppMethodBeat.o(77942);
      return true;
    }
    AppMethodBeat.o(77942);
    return false;
  }
  
  public final boolean bH(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    Log.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(Util.nullAsInt(paramMap.get("webview_instance_id"), -1)).d(ai.b(paramMap, "type", 0), ai.aa(paramMap, "query"), paramMap);
    int i;
    if (this.PLj)
    {
      this.PLj = false;
      i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
      if (this.PLm != null) {
        this.PLm.fPp = i;
      }
      if (!w(bI(paramMap)))
      {
        Log.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.PLk = true;
        if (this.PLl != null) {
          this.PLl.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.PLl != null) {
        this.PLl.countDown();
      }
      if (this.PLm != null) {
        Log.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.PLm.fPp), this.PLm });
      }
      i = 1;
      continue;
      if (this.PLl != null) {
        this.PLl.countDown();
      }
      i = 0;
    }
    paramMap = bJ(paramMap);
    a locala = this.PLi;
    if (locala.PLv != null) {
      locala.PLv.aFI = true;
    }
    locala.PLv = new i.a.a(locala, (byte)0);
    locala.PLv.PxJ = paramMap;
    locala.PLq.PLm = paramMap;
    locala.PLv.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void gTu()
  {
    AppMethodBeat.i(77949);
    String str = ai.gQH();
    Log.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.PLo = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.PLo = w(new HashSet(Arrays.asList(str.split(","))));
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
        com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
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
        a(paramString.gQm(), paramq, paramString.gQn(), paramString.gQr());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramq = paramString.gQp();
        paramInt1 = paramString.gQq();
        Log.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.gQm(), paramq, paramString.gQn(), paramString.gQr());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.hii();
          b.apP(27);
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
    public a PLu;
    public a PLv;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      v PxJ;
      public volatile boolean aFI;
      
      private a() {}
      
      public final void run()
      {
        AppMethodBeat.i(77939);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77939);
          return;
        }
        if (Util.isNullOrNil(this.PxJ.fwe))
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.PxJ.businessType), Integer.valueOf(this.PxJ.scene), Integer.valueOf(this.PxJ.PxU), Integer.valueOf(this.PxJ.fPw), this.PxJ.uMC, Integer.valueOf(this.PxJ.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        Log.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.PxJ.fwe, Integer.valueOf(this.PxJ.fPp) });
        if (i.a.a(i.a.this) != null) {
          com.tencent.mm.kernel.h.aGY().a(i.a.a(i.a.this));
        }
        if (this.aFI)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        f.gWq().PKu.x(this.PxJ.scene, this.PxJ.fwe, this.PxJ.businessType);
        i.a.a(i.a.this, i.a.a(this.PxJ));
        com.tencent.mm.kernel.h.aGY().a(i.a.a(i.a.this).getType(), i.this);
        com.tencent.mm.kernel.h.aGY().a(i.a.a(i.a.this), 0);
        Log.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(i.a.a(i.a.this).getType()) });
        AppMethodBeat.o(77939);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i
 * JD-Core Version:    0.7.0.1
 */