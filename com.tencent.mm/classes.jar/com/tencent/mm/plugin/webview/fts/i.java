package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.flq;
import com.tencent.mm.protocal.protobuf.fvd;
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
  implements com.tencent.mm.am.h
{
  private static i WBA;
  private static final long WBs;
  private volatile boolean WBB;
  public IListener WBC;
  private MMHandler WBt;
  private Set<String> WBu;
  public a WBv;
  private volatile boolean WBw;
  private volatile boolean WBx;
  private volatile CountDownLatch WBy;
  private volatile w WBz;
  
  static
  {
    AppMethodBeat.i(77950);
    WBs = e.jhM() + 500;
    WBA = new i();
    AppMethodBeat.o(77950);
  }
  
  public i()
  {
    AppMethodBeat.i(77941);
    this.WBt = new MMHandler("RecommendLogic_worker");
    this.WBv = new a((byte)0);
    this.WBC = new RecommendLogic.1(this, f.hfK);
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    Log.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.WBC.alive();
    this.WBu = new HashSet();
    this.WBu.add("netType");
    this.WBu.add("time_zone_min");
    this.WBu.add("currentPage");
    this.WBu.add("is_prefetch");
    this.WBu.add("direction");
    this.WBu.add("seq");
    this.WBu.add("client_exposed_info");
    this.WBu.add("requestId");
    this.WBu.add("recType");
    this.WBu.add("redPointMsgId");
    itf();
    AppMethodBeat.o(77941);
  }
  
  private boolean H(Set<String> paramSet)
  {
    AppMethodBeat.i(77942);
    if ((paramSet == null) || (this.WBu.containsAll(paramSet)))
    {
      AppMethodBeat.o(77942);
      return true;
    }
    AppMethodBeat.o(77942);
    return false;
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(77947);
    this.WBt.postToWorker(new Runnable()
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
            int j = i.b(i.this).hVk;
            i = j;
            if (!i.b(i.this).Wos) {
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
        k.auP(i).b(paramString1, paramBoolean, paramString2, null);
        AppMethodBeat.o(77938);
      }
    });
    AppMethodBeat.o(77947);
  }
  
  /* Error */
  private static Set<String> cc(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 178
    //   8: invokestatic 184	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_0
    //   12: aload_0
    //   13: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   16: ifne +90 -> 106
    //   19: new 108	java/util/HashSet
    //   22: dup
    //   23: invokespecial 109	java/util/HashSet:<init>	()V
    //   26: astore_2
    //   27: new 192	org/json/JSONArray
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 193	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_2
    //   39: astore_0
    //   40: iload_1
    //   41: aload_3
    //   42: invokevirtual 196	org/json/JSONArray:length	()I
    //   45: if_icmpge +54 -> 99
    //   48: aload_3
    //   49: iload_1
    //   50: invokevirtual 200	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   53: astore_0
    //   54: new 202	com/tencent/mm/protocal/protobuf/aem
    //   57: dup
    //   58: invokespecial 203	com/tencent/mm/protocal/protobuf/aem:<init>	()V
    //   61: pop
    //   62: aload_2
    //   63: aload_0
    //   64: ldc 205
    //   66: ldc 207
    //   68: invokevirtual 213	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: invokeinterface 119 2 0
    //   76: pop
    //   77: iload_1
    //   78: iconst_1
    //   79: iadd
    //   80: istore_1
    //   81: goto -43 -> 38
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_0
    //   87: ldc 91
    //   89: aload_2
    //   90: ldc 207
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: ldc 176
    //   101: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: invokestatic 223	java/util/Collections:emptySet	()Ljava/util/Set;
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
  
  private static w cd(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77945);
    w localw = new w();
    localw.hAB = aj.au(paramMap, "query");
    localw.offset = aj.c(paramMap, "offset", 0);
    localw.businessType = aj.c(paramMap, "type", 0);
    localw.scene = aj.c(paramMap, "scene", 0);
    localw.Wod = aj.au(paramMap, "sugId");
    localw.Wof = aj.c(paramMap, "sugType", 0);
    localw.Woe = aj.au(paramMap, "prefixSug");
    localw.Woq = aj.au(paramMap, "poiInfo");
    int i;
    if (aj.av(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      localw.Wob = i;
      localw.xVe = aj.au(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localw.sessionId = aj.au(paramMap, "sessionId");
      }
      localw.hVr = aj.c(paramMap, "sceneActionType", 1);
      localw.Woh = aj.c(paramMap, "displayPattern", 2);
      localw.Woi = aj.c(paramMap, "sugPosition", 0);
      localw.Woj = aj.au(paramMap, "sugBuffer");
      localw.hOG = aj.au(paramMap, "requestId");
      localw.sessionId = aj.au(paramMap, "sessionId");
      localw.hVn = aj.au(paramMap, "subSessionId");
      localw.Wor = aj.au(paramMap, "tagId");
      Object localObject1 = aj.au(paramMap, "extReqParams");
      if (!Util.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new aem();
            ((aem)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((aem)localObject5).Zmx = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((aem)localObject5).Zmy = ((JSONObject)localObject4).optString("textValue", "");
            localw.Wol.add(localObject5);
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
    Object localObject2 = aj.au(paramMap, "matchUser");
    if (!Util.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new fvd();
      ((fvd)localObject4).UserName = ((JSONObject)localObject2).optString("userName");
      ((fvd)localObject4).abTC = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((fvd)localObject4).UserName)) {
        localw.Woc.add(localObject4);
      }
      localObject2 = aj.au(paramMap, "prefixQuery");
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
          localw.Wog.add(localObject4);
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
      Object localObject3 = aj.au(paramMap, "tagInfo");
      if (!Util.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        localw.Wok = new flq();
        localw.Wok.abMd = ((JSONObject)localObject3).optString("tagText");
        localw.Wok.abMc = ((JSONObject)localObject3).optInt("tagType");
        localw.Wok.abMe = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = aj.au(paramMap, "numConditions");
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
            localObject5 = new duw();
            ((duw)localObject5).abaM = ((JSONObject)localObject4).optLong("from");
            ((duw)localObject5).abaN = ((JSONObject)localObject4).optLong("to");
            ((duw)localObject5).abaL = ((JSONObject)localObject4).optInt("field");
            localw.Wom.add(localObject5);
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
        localw.hVk = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        localw.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        localw.subtype = aj.c(paramMap, "subType", 0);
        localw.channelId = aj.c(paramMap, "channelId", 0);
        localw.Wot = aj.au(paramMap, "navigationId");
        AppMethodBeat.o(77945);
      }
    }
    return localw;
  }
  
  public static i ite()
  {
    return WBA;
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
  
  public final boolean cb(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77943);
    Log.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    k.auP(Util.nullAsInt(paramMap.get("webview_instance_id"), -1)).d(aj.c(paramMap, "type", 0), aj.au(paramMap, "query"), paramMap);
    int i;
    if (this.WBw)
    {
      this.WBw = false;
      i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
      if (this.WBz != null) {
        this.WBz.hVk = i;
      }
      if (!H(cc(paramMap)))
      {
        Log.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.WBx = true;
        if (this.WBy != null) {
          this.WBy.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(77943);
      return false;
      if (this.WBy != null) {
        this.WBy.countDown();
      }
      if (this.WBz != null) {
        Log.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.WBz.hVk), this.WBz });
      }
      i = 1;
      continue;
      if (this.WBy != null) {
        this.WBy.countDown();
      }
      i = 0;
    }
    paramMap = cd(paramMap);
    a locala = this.WBv;
    if (locala.WBI != null) {
      locala.WBI.cBt = true;
    }
    locala.WBI = new i.a.a(locala, (byte)0);
    locala.WBI.WnS = paramMap;
    locala.WBD.WBz = paramMap;
    locala.WBI.run();
    AppMethodBeat.o(77943);
    return false;
  }
  
  public final void itf()
  {
    AppMethodBeat.i(77949);
    String str = aj.ipR();
    Log.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.WBB = true;
      AppMethodBeat.o(77949);
      return;
    }
    this.WBB = H(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(77949);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(77946);
    int i;
    if (paramp != null) {
      i = paramp.getType();
    }
    for (;;)
    {
      Log.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramp instanceof a))
      {
        com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
        paramString = (a)paramp;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.getKeyword() });
          paramp = new JSONObject();
        }
      }
      try
      {
        paramp.put("ret", -1);
        label128:
        paramp = paramp.toString();
        a(paramString.ipD(), paramp, paramString.ipE(), paramString.ipI());
        AppMethodBeat.o(77946);
        return;
        i = 0;
        continue;
        paramp = paramString.ipG();
        paramInt1 = paramString.ipH();
        Log.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.ipD(), paramp, paramString.ipE(), paramString.ipI());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.iJf();
          b.avS(27);
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
    public a WBH;
    public a WBI;
    
    private a() {}
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      w WnS;
      public volatile boolean cBt;
      
      private a() {}
      
      public final void run()
      {
        AppMethodBeat.i(77939);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77939);
          return;
        }
        if (Util.isNullOrNil(this.WnS.hAB))
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.WnS.businessType), Integer.valueOf(this.WnS.scene), Integer.valueOf(this.WnS.Wob), Integer.valueOf(this.WnS.hVr), this.WnS.xVe, Integer.valueOf(this.WnS.offset) });
          AppMethodBeat.o(77939);
          return;
        }
        Log.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[] { this.WnS.hAB, Integer.valueOf(this.WnS.hVk) });
        if (i.a.a(i.a.this) != null) {
          com.tencent.mm.kernel.h.aZW().a(i.a.a(i.a.this));
        }
        if (this.cBt)
        {
          Log.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
          AppMethodBeat.o(77939);
          return;
        }
        g.ivW().WAG.C(this.WnS.scene, this.WnS.hAB, this.WnS.businessType);
        i.a.a(i.a.this, i.a.b(this.WnS));
        com.tencent.mm.kernel.h.aZW().a(i.a.a(i.a.this).getType(), i.this);
        com.tencent.mm.kernel.h.aZW().a(i.a.a(i.a.this), 0);
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