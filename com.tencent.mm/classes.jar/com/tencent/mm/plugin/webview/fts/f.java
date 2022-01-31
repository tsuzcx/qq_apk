package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.id;
import com.tencent.mm.h.a.id.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.u.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.bww;
import com.tencent.mm.protocal.c.ccd;
import com.tencent.mm.protocal.c.cmx;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
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

public final class f
  implements com.tencent.mm.ah.f
{
  private static f qZD = new f();
  private static final long qZw = d.cxX() + 500;
  private ai bjo = new ai("RecommendLogic_worker");
  private volatile boolean qZA;
  private volatile CountDownLatch qZB;
  private volatile s qZC;
  private volatile boolean qZE;
  public com.tencent.mm.sdk.b.c qZF = new f.1(this);
  private Set<String> qZx;
  public f.a qZy = new f.a(this, (byte)0);
  private volatile boolean qZz;
  
  public f()
  {
    y.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic");
    y.d("MicroMsg.TopStory.RecommendLogic", "create RecommendLogic, duplicate for patch fix");
    this.qZF.cqo();
    this.qZx = new HashSet();
    this.qZx.add("netType");
    this.qZx.add("time_zone_min");
    this.qZx.add("currentPage");
    this.qZx.add("is_prefetch");
    this.qZx.add("direction");
    this.qZx.add("seq");
    this.qZx.add("client_exposed_info");
    this.qZx.add("requestId");
    this.qZx.add("recType");
    this.qZx.add("redPointMsgId");
    caD();
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.bjo.O(new f.2(this, paramInt, paramString2, paramString1, paramBoolean));
  }
  
  /* Error */
  private static Set<String> aj(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 142
    //   3: invokestatic 148	com/tencent/mm/plugin/websearch/api/aa:s	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic 154	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   11: ifne +87 -> 98
    //   14: new 87	java/util/HashSet
    //   17: dup
    //   18: invokespecial 88	java/util/HashSet:<init>	()V
    //   21: astore_0
    //   22: new 156	org/json/JSONArray
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 157	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   30: astore_3
    //   31: iconst_0
    //   32: istore_1
    //   33: aload_0
    //   34: astore_2
    //   35: iload_1
    //   36: aload_3
    //   37: invokevirtual 160	org/json/JSONArray:length	()I
    //   40: if_icmpge +56 -> 96
    //   43: aload_3
    //   44: iload_1
    //   45: invokevirtual 164	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   48: astore_2
    //   49: new 166	com/tencent/mm/protocal/c/rb
    //   52: dup
    //   53: invokespecial 167	com/tencent/mm/protocal/c/rb:<init>	()V
    //   56: pop
    //   57: aload_0
    //   58: aload_2
    //   59: ldc 169
    //   61: ldc 171
    //   63: invokevirtual 177	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: invokeinterface 98 2 0
    //   71: pop
    //   72: iload_1
    //   73: iconst_1
    //   74: iadd
    //   75: istore_1
    //   76: goto -43 -> 33
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_0
    //   82: ldc 69
    //   84: aload_2
    //   85: ldc 171
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 181	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: astore_2
    //   96: aload_2
    //   97: areturn
    //   98: invokestatic 187	java/util/Collections:emptySet	()Ljava/util/Set;
    //   101: areturn
    //   102: astore_2
    //   103: goto -21 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramMap	Map<String, Object>
    //   32	44	1	i	int
    //   6	53	2	localObject	Object
    //   79	6	2	localException1	Exception
    //   95	2	2	localMap	Map<String, Object>
    //   102	1	2	localException2	Exception
    //   30	14	3	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   14	22	79	java/lang/Exception
    //   22	31	102	java/lang/Exception
    //   35	72	102	java/lang/Exception
  }
  
  private static s ak(Map<String, Object> paramMap)
  {
    s locals = new s();
    locals.bGm = aa.s(paramMap, "query");
    locals.offset = aa.c(paramMap, "offset", 0);
    locals.businessType = aa.c(paramMap, "type", 0);
    locals.scene = aa.c(paramMap, "scene", 0);
    locals.qTy = aa.s(paramMap, "sugId");
    locals.qTA = aa.c(paramMap, "sugType", 0);
    locals.qTz = aa.s(paramMap, "prefixSug");
    locals.qTL = aa.s(paramMap, "poiInfo");
    int i;
    if (aa.t(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      locals.qTw = i;
      locals.jfE = aa.s(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        locals.bIB = aa.s(paramMap, "sessionId");
      }
      locals.bVt = aa.c(paramMap, "sceneActionType", 1);
      locals.qTC = aa.c(paramMap, "displayPattern", 2);
      locals.qTD = aa.c(paramMap, "sugPosition", 0);
      locals.qTE = aa.s(paramMap, "sugBuffer");
      locals.lJQ = aa.s(paramMap, "requestId");
      locals.bIB = aa.s(paramMap, "sessionId");
      locals.bVp = aa.s(paramMap, "subSessionId");
      locals.qTM = aa.s(paramMap, "tagId");
      Object localObject1 = aa.s(paramMap, "extReqParams");
      if (!bk.bl((String)localObject1)) {
        try
        {
          localObject1 = new JSONArray((String)localObject1);
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject5 = new rb();
            ((rb)localObject5).key = ((JSONObject)localObject4).optString("key", "");
            ((rb)localObject5).sOI = ((JSONObject)localObject4).optInt("uintValue", 0);
            ((rb)localObject5).sOJ = ((JSONObject)localObject4).optString("textValue", "");
            locals.qTG.add(localObject5);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = aa.s(paramMap, "matchUser");
    if (!bk.bl((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject4 = new ccd();
      ((ccd)localObject4).hPY = ((JSONObject)localObject2).optString("userName");
      ((ccd)localObject4).tRz = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((ccd)localObject4).hPY)) {
        locals.qTx.add(localObject4);
      }
      localObject2 = aa.s(paramMap, "prefixQuery");
      if (bk.bl((String)localObject2)) {}
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
          locals.qTB.add(localObject4);
          i += 1;
          continue;
          localException2 = localException2;
          y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException3, "prefixQueryJSONArray", new Object[0]);
      }
      Object localObject3 = aa.s(paramMap, "tagInfo");
      if (!bk.bl((String)localObject3)) {}
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        locals.qTF = new bww();
        locals.qTF.tNd = ((JSONObject)localObject3).optString("tagText");
        locals.qTF.tNc = ((JSONObject)localObject3).optInt("tagType");
        locals.qTF.tNe = ((JSONObject)localObject3).optString("tagExtValue");
        localObject3 = aa.s(paramMap, "numConditions");
        if (bk.bl((String)localObject3)) {}
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
            localObject5 = new azi();
            ((azi)localObject5).tvz = ((JSONObject)localObject4).optLong("from");
            ((azi)localObject5).tvA = ((JSONObject)localObject4).optLong("to");
            ((azi)localObject5).tvy = ((JSONObject)localObject4).optInt("field");
            locals.qTH.add(localObject5);
            i += 1;
            continue;
            localException4 = localException4;
            y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          y.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.bVm = bk.e(paramMap.get("webview_instance_id"), -1);
        locals.auI = x.fB(ae.getContext());
        locals.kwf = aa.c(paramMap, "subType", 0);
        locals.bvj = aa.c(paramMap, "channelId", 0);
        locals.qTP = aa.s(paramMap, "navigationId");
        if (r.aqr())
        {
          locals.qTI = aa.c(paramMap, "isWeAppMore", 0);
          if (locals.qTI == 1)
          {
            locals.qTJ = new cmx();
            id localid = new id();
            com.tencent.mm.sdk.b.a.udP.m(localid);
            locals.qTJ.tZx = localid.bQn.bQo;
            locals.qTJ.tZz = com.tencent.mm.modelappbrand.b.dZM;
            locals.qTJ.tZy = aa.c(paramMap, "subType", 0);
            locals.qTJ.session_id = com.tencent.mm.modelappbrand.b.dZL;
            locals.qTJ.tZA = locals.qTD;
            au.Hx();
            paramMap = com.tencent.mm.model.c.Dz().get(ac.a.uuP, null);
            if ((paramMap != null) && ((paramMap instanceof String))) {
              locals.qTJ.tYI = ((String)paramMap);
            }
          }
        }
      }
    }
    return locals;
  }
  
  public static f caC()
  {
    return qZD;
  }
  
  private boolean i(Set<String> paramSet)
  {
    return (paramSet == null) || (this.qZx.containsAll(paramSet));
  }
  
  public static void start()
  {
    try
    {
      Looper.prepare();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final boolean ai(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.TopStory.RecommendLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    h.Db(bk.e(paramMap.get("webview_instance_id"), -1)).c(aa.c(paramMap, "type", 0), aa.s(paramMap, "query"), paramMap);
    int i;
    if (this.qZz)
    {
      this.qZz = false;
      i = bk.e(paramMap.get("webview_instance_id"), -1);
      if (this.qZC != null) {
        this.qZC.bVm = i;
      }
      if (!i(aj(paramMap)))
      {
        y.e("MicroMsg.TopStory.RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.qZA = true;
        if (this.qZB != null) {
          this.qZB.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      return false;
      if (this.qZB != null) {
        this.qZB.countDown();
      }
      if (this.qZC != null) {
        y.i("MicroMsg.TopStory.RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.qZC.bVm), this.qZC });
      }
      i = 1;
      continue;
      if (this.qZB != null) {
        this.qZB.countDown();
      }
      i = 0;
    }
    paramMap = ak(paramMap);
    f.a locala = this.qZy;
    if (locala.qZL != null) {
      locala.qZL.hMo = true;
    }
    locala.qZL = new f.a.a(locala, (byte)0);
    locala.qZL.dZR = paramMap;
    locala.qZG.qZC = paramMap;
    locala.qZL.run();
    return false;
  }
  
  public final void caD()
  {
    String str = aa.BB(1);
    y.i("MicroMsg.TopStory.RecommendLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.qZE = true;
      return;
    }
    this.qZE = i(new HashSet(Arrays.asList(str.split(","))));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i;
    if (paramm != null) {
      i = paramm.getType();
    }
    for (;;)
    {
      y.v("MicroMsg.TopStory.RecommendLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramm instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        au.Dk().b(paramm.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramm;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label154;
        }
        y.i("MicroMsg.TopStory.RecommendLogic", "net scene fail %s", new Object[] { paramString.qTu });
        paramm = new JSONObject();
      }
      try
      {
        paramm.put("ret", -1);
        label122:
        paramm = paramm.toString();
        a(paramString.qTt, paramm, paramString.bZj(), paramString.bVq);
        label154:
        do
        {
          return;
          i = 0;
          break;
          paramm = paramString.Jv();
          paramInt1 = paramString.Jw();
          y.i("MicroMsg.TopStory.RecommendLogic", "callback %s", new Object[] { paramString.qTu });
          a(paramString.qTt, paramm, paramString.bZj(), paramString.bVq);
        } while (paramInt1 <= 0);
        y.i("MicroMsg.TopStory.RecommendLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
        b.c.clv();
        com.tencent.mm.pluginsdk.g.a.a.b.DL(27);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label122;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.f
 * JD-Core Version:    0.7.0.1
 */