package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.a;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
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
  implements f
{
  private static final long uPe;
  private static g uPl;
  private al rzq;
  private Set<String> uPf;
  public g.a uPg;
  private volatile boolean uPh;
  private volatile boolean uPi;
  private volatile CountDownLatch uPj;
  private volatile s uPk;
  private volatile boolean uPm;
  public c uPn;
  
  static
  {
    AppMethodBeat.i(5735);
    uPe = d.dAU() + 500;
    uPl = new g();
    AppMethodBeat.o(5735);
  }
  
  public g()
  {
    AppMethodBeat.i(5726);
    this.rzq = new al("RecommendLogic_worker");
    this.uPg = new g.a(this, (byte)0);
    this.uPn = new c() {};
    ab.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    ab.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.uPn.alive();
    this.uPf = new HashSet();
    this.uPf.add("netType");
    this.uPf.add("time_zone_min");
    this.uPf.add("currentPage");
    this.uPf.add("is_prefetch");
    this.uPf.add("direction");
    this.uPf.add("seq");
    this.uPf.add("client_exposed_info");
    this.uPf.add("requestId");
    this.uPf.add("recType");
    this.uPf.add("redPointMsgId");
    daC();
    AppMethodBeat.o(5726);
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(5732);
    this.rzq.ac(new g.2(this, paramInt, paramString2, paramString1, paramBoolean));
    AppMethodBeat.o(5732);
  }
  
  /* Error */
  private static Set<String> aF(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: sipush 5729
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 151
    //   9: invokestatic 157	com/tencent/mm/plugin/websearch/api/aa:t	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 163	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   17: ifne +91 -> 108
    //   20: new 96	java/util/HashSet
    //   23: dup
    //   24: invokespecial 97	java/util/HashSet:<init>	()V
    //   27: astore_2
    //   28: new 165	org/json/JSONArray
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 166	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: iconst_0
    //   38: istore_1
    //   39: aload_2
    //   40: astore_0
    //   41: iload_1
    //   42: aload_3
    //   43: invokevirtual 169	org/json/JSONArray:length	()I
    //   46: if_icmpge +54 -> 100
    //   49: aload_3
    //   50: iload_1
    //   51: invokevirtual 173	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   54: astore_0
    //   55: new 175	com/tencent/mm/protocal/protobuf/up
    //   58: dup
    //   59: invokespecial 176	com/tencent/mm/protocal/protobuf/up:<init>	()V
    //   62: pop
    //   63: aload_2
    //   64: aload_0
    //   65: ldc 178
    //   67: ldc 180
    //   69: invokevirtual 186	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: invokeinterface 107 2 0
    //   77: pop
    //   78: iload_1
    //   79: iconst_1
    //   80: iadd
    //   81: istore_1
    //   82: goto -43 -> 39
    //   85: astore_2
    //   86: aconst_null
    //   87: astore_0
    //   88: ldc 78
    //   90: aload_2
    //   91: ldc 180
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: sipush 5729
    //   103: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: areturn
    //   108: invokestatic 196	java/util/Collections:emptySet	()Ljava/util/Set;
    //   111: astore_0
    //   112: goto -12 -> 100
    //   115: astore_3
    //   116: aload_2
    //   117: astore_0
    //   118: aload_3
    //   119: astore_2
    //   120: goto -32 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramMap	Map<String, Object>
    //   38	44	1	i	int
    //   27	37	2	localHashSet	HashSet
    //   85	32	2	localException1	Exception
    //   119	1	2	localObject	Object
    //   36	14	3	localJSONArray	JSONArray
    //   115	4	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   20	28	85	java/lang/Exception
    //   28	37	115	java/lang/Exception
    //   41	78	115	java/lang/Exception
  }
  
  private static s aG(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5730);
    s locals = new s();
    locals.cnv = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
    locals.scene = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
    locals.uIG = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sugId");
    locals.uII = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sugType", 0);
    locals.uIH = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "prefixSug");
    locals.uIT = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "poiInfo");
    int i;
    if (com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      locals.uIE = i;
      locals.low = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        locals.cpW = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sessionId");
      }
      locals.cDa = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sceneActionType", 1);
      locals.uIK = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "displayPattern", 2);
      locals.uIL = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sugPosition", 0);
      locals.uIM = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sugBuffer");
      locals.ohe = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "requestId");
      locals.cpW = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sessionId");
      locals.cCW = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "subSessionId");
      locals.uIU = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "tagId");
      Object localObject1 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "extReqParams");
      if (!bo.isNullOrNil((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new up();
            ((up)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((up)localObject5).wMM = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((up)localObject5).wMN = ((JSONObject)localObject4).optString("textValue", "");
            locals.uIO.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "matchUser");
    if (!bo.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new cpj();
      ((cpj)localObject4).jJA = ((JSONObject)localObject2).optString("userName");
      ((cpj)localObject4).xYv = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((cpj)localObject4).jJA)) {
        locals.uIF.add(localObject4);
      }
      localObject2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "prefixQuery");
      if (bo.isNullOrNil((String)localObject2)) {}
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
          locals.uIJ.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "tagInfo");
      if (!bo.isNullOrNil((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        locals.uIN = new cjh();
        locals.uIN.xTz = ((JSONObject)localObject3).optString("tagText");
        locals.uIN.xTy = ((JSONObject)localObject3).optInt("tagType");
        locals.uIN.xTA = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "numConditions");
        if (bo.isNullOrNil((String)localObject3)) {}
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
            localObject5 = new bgl();
            ((bgl)localObject5).xvK = ((JSONObject)localObject4).optLong("from");
            ((bgl)localObject5).xvL = ((JSONObject)localObject4).optLong("to");
            ((bgl)localObject5).xvJ = ((JSONObject)localObject4).optInt("field");
            locals.uIP.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ab.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.cCT = bo.f(paramMap.get("webview_instance_id"), -1);
        locals.axa = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
        locals.mRU = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0);
        locals.bWu = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "channelId", 0);
        locals.uIX = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "navigationId");
        if (r.aNU())
        {
          locals.uIQ = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0);
          if (locals.uIQ == 1)
          {
            locals.uIR = new dbf();
            ih localih = new ih();
            com.tencent.mm.sdk.b.a.ymk.l(localih);
            locals.uIR.yhq = localih.cxG.cxH;
            locals.uIR.yhs = com.tencent.mm.modelappbrand.b.fpR;
            locals.uIR.yhr = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0);
            locals.uIR.session_id = com.tencent.mm.modelappbrand.b.fpQ;
            locals.uIR.yht = locals.uIL;
            paramMap = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEW, null);
            if ((paramMap != null) && ((paramMap instanceof String))) {
              locals.uIR.ygb = ((String)paramMap);
            }
          }
        }
        AppMethodBeat.o(5730);
      }
    }
    return locals;
  }
  
  public static g daB()
  {
    return uPl;
  }
  
  private boolean j(Set<String> paramSet)
  {
    AppMethodBeat.i(5727);
    if ((paramSet == null) || (this.uPf.containsAll(paramSet)))
    {
      AppMethodBeat.o(5727);
      return true;
    }
    AppMethodBeat.o(5727);
    return false;
  }
  
  public static void start()
  {
    AppMethodBeat.i(5733);
    try
    {
      Looper.prepare();
      AppMethodBeat.o(5733);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(5733);
    }
  }
  
  public final boolean aE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5728);
    ab.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    h.KW(bo.f(paramMap.get("webview_instance_id"), -1)).c(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0), com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query"), paramMap);
    int i;
    if (this.uPh)
    {
      this.uPh = false;
      i = bo.f(paramMap.get("webview_instance_id"), -1);
      if (this.uPk != null) {
        this.uPk.cCT = i;
      }
      if (!j(aF(paramMap)))
      {
        ab.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.uPi = true;
        if (this.uPj != null) {
          this.uPj.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(5728);
      return false;
      if (this.uPj != null) {
        this.uPj.countDown();
      }
      if (this.uPk != null) {
        ab.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.uPk.cCT), this.uPk });
      }
      i = 1;
      continue;
      if (this.uPj != null) {
        this.uPj.countDown();
      }
      i = 0;
    }
    paramMap = aG(paramMap);
    g.a locala = this.uPg;
    if (locala.uPt != null) {
      locala.uPt.jFQ = true;
    }
    locala.uPt = new g.a.a(locala, (byte)0);
    locala.uPt.fpY = paramMap;
    locala.uPo.uPk = paramMap;
    locala.uPt.run();
    AppMethodBeat.o(5728);
    return false;
  }
  
  public final void daC()
  {
    AppMethodBeat.i(5734);
    String str = com.tencent.mm.plugin.websearch.api.aa.Jp(1);
    ab.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.uPm = true;
      AppMethodBeat.o(5734);
      return;
    }
    this.uPm = j(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(5734);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5731);
    int i;
    if (paramm != null) {
      i = paramm.getType();
    }
    for (;;)
    {
      ab.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramm instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.Rc().b(paramm.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ab.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.bBW() });
          paramm = new JSONObject();
        }
      }
      try
      {
        paramm.put("ret", -1);
        label128:
        paramm = paramm.toString();
        a(paramString.cZa(), paramm, paramString.cZb(), paramString.cZd());
        AppMethodBeat.o(5731);
        return;
        i = 0;
        continue;
        paramm = paramString.act();
        paramInt1 = paramString.acu();
        ab.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.bBW() });
        a(paramString.cZa(), paramm, paramString.cZb(), paramString.cZd());
        if (paramInt1 > 0)
        {
          ab.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.c.dmg();
          com.tencent.mm.pluginsdk.g.a.a.b.LE(27);
        }
        AppMethodBeat.o(5731);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label128;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */