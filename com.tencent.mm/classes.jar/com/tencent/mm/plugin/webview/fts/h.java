package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.dsu;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.of;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  implements com.tencent.mm.al.g
{
  static final long AOW;
  public dsu AGb;
  private ap AOX;
  private Set<String> AOY;
  volatile boolean APa;
  volatile boolean APb;
  volatile CountDownLatch APc;
  private volatile com.tencent.mm.plugin.websearch.api.q APd;
  volatile boolean APf;
  public com.tencent.mm.sdk.b.c APg;
  public int APo;
  public dsu APp;
  public Map<String, Integer> APq;
  long APr;
  public com.tencent.mm.sdk.b.c APs;
  private com.tencent.mm.plugin.websearch.a.a.c APt;
  public a APu;
  public h.b APv;
  public com.tencent.mm.plugin.fts.a.a.a rpP;
  private l uzW;
  
  static
  {
    AppMethodBeat.i(77974);
    AOW = com.tencent.mm.ui.d.ePs() + 500;
    AppMethodBeat.o(77974);
  }
  
  public h()
  {
    AppMethodBeat.i(77960);
    this.AOX = new ap("WebSearchLogic_worker");
    this.APo = 0;
    this.APq = new HashMap();
    this.APg = new h.1(this);
    this.APs = new h.2(this);
    this.APt = new com.tencent.mm.plugin.websearch.a.a.b();
    this.APu = new a((byte)0);
    this.APv = new h.b(this, (byte)0);
    this.uzW = new h.6(this);
    ad.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.APg.alive();
    this.APs.alive();
    this.AOY = new HashSet();
    this.AOY.add("netType");
    this.AOY.add("currentPage");
    this.AOY.add("requestId");
    this.AOY.add("parentSearchID");
    ejV();
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramm.roN);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.XV(paramm.roN);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.roM)
    {
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      bool2 = false;
      bool1 = false;
      i = 0;
      j = 0;
      localObject1 = null;
      localObject2 = null;
    case 3: 
    case 7: 
      for (;;)
      {
        label264:
        if (j != 0)
        {
          localObject3 = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject3, paramh, bool1, bool2);
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).roV = com.tencent.mm.plugin.fts.a.a.e.a.rpe;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).rpa = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).rpb = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).rpj.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.roV = com.tencent.mm.plugin.fts.a.a.e.a.rpe;
            paramh.rpa = "<em class=\"highlight\">";
            paramh.rpb = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).rpj.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.XV(paramm.roN));
              ((JSONObject)localObject1).put("userName", paramm.roN);
              if (j != 0) {
                ((JSONObject)localObject1).put("nickNameHighlight", localObject3);
              }
              if (i != 0) {
                ((JSONObject)localObject1).put("extraHighlight", paramh);
              }
            }
            catch (JSONException paramm)
            {
              label331:
              break label331;
            }
            AppMethodBeat.o(77971);
            return localObject1;
            bool2 = true;
            label342:
            bool1 = true;
            label345:
            i = 0;
            j = 1;
            localObject1 = null;
            localObject2 = null;
            continue;
            bool2 = true;
          }
        }
      }
    }
    label361:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((au)localObject4).field_nickname;
      localObject2 = aj.getContext().getString(2131762930);
      i = 1;
      j = 0;
      break;
      localObject1 = ((au)localObject4).evI;
      localObject2 = aj.getContext().getString(2131762925);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((af)localObject4).Ss();
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = ((au)localObject4).field_username;
      }
      localObject2 = aj.getContext().getString(2131762935);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paramm.content;
      if (!bt.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label500:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramh.rpq)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = aj.getContext().getString(2131762929);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label500;
        localObject1 = paramm.content;
        localObject2 = aj.getContext().getString(2131762931);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramm.content;
        localObject2 = aj.getContext().getString(2131762924);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aaU(((au)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.rps;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.aaY(str).contains(localCharSequence))
            {
              ((StringBuffer)localObject2).append(str);
              ((StringBuffer)localObject2).append(",");
            }
          }
          i += 1;
        }
        ((StringBuffer)localObject2).trimToSize();
        if (((StringBuffer)localObject2).length() == 0) {}
        for (localObject1 = "";; localObject1 = ((StringBuffer)localObject2).substring(0, ((StringBuffer)localObject2).length() - 1))
        {
          localObject2 = aj.getContext().getString(2131762934);
          bool2 = false;
          bool1 = false;
          i = 1;
          j = 0;
          break;
        }
        paramh = (com.tencent.mm.plugin.fts.a.a.h)localObject1;
        break label264;
        break label197;
      }
      bool2 = false;
      break label342;
      bool2 = false;
      bool1 = false;
      break label345;
      bool2 = false;
      break label361;
      bool2 = false;
    }
  }
  
  private void a(final int paramInt, final String paramString1, final boolean paramBoolean, final String paramString2, final Bundle paramBundle)
  {
    AppMethodBeat.i(77969);
    this.AOX.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187856);
        if (h.b(h.this) != null) {
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(h.b(h.this).getCount()) });
        }
        int i;
        for (;;)
        {
          try
          {
            h.b(h.this).await();
            i = paramInt;
            if (h.c(h.this) == null) {
              break;
            }
            int j = h.c(h.this).dtt;
            i = j;
            if (!h.c(h.this).AGf) {
              break;
            }
            i = j;
            if (!h.d(h.this)) {
              break;
            }
            ad.w("MicroMsg.WebSearch.WebSearchLogic", "ingore pre get data");
            AppMethodBeat.o(187856);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "count down latch null");
        }
        ad.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, h.c(h.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(i).a(paramString1, paramBoolean, paramString2, paramBundle);
        AppMethodBeat.o(187856);
      }
    });
    AppMethodBeat.o(77969);
  }
  
  private boolean aU(LinkedList<xp> paramLinkedList)
  {
    AppMethodBeat.i(77966);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((xp)paramLinkedList.next()).key);
    }
    boolean bool = this.AOY.equals(localHashSet);
    AppMethodBeat.o(77966);
    return bool;
  }
  
  /* Error */
  private static Set<String> bl(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 445
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 447
    //   10: invokestatic 451	com/tencent/mm/plugin/websearch/api/aa:w	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 301	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifne +94 -> 112
    //   21: new 141	java/util/HashSet
    //   24: dup
    //   25: invokespecial 142	java/util/HashSet:<init>	()V
    //   28: astore_2
    //   29: new 453	org/json/JSONArray
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 454	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload_1
    //   43: aload_3
    //   44: invokevirtual 455	org/json/JSONArray:length	()I
    //   47: if_icmpge +57 -> 104
    //   50: aload_3
    //   51: iload_1
    //   52: invokevirtual 459	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore_0
    //   56: new 411	com/tencent/mm/protocal/protobuf/xp
    //   59: dup
    //   60: invokespecial 460	com/tencent/mm/protocal/protobuf/xp:<init>	()V
    //   63: pop
    //   64: aload_2
    //   65: aload_0
    //   66: ldc_w 461
    //   69: ldc_w 389
    //   72: invokevirtual 465	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokeinterface 152 2 0
    //   80: pop
    //   81: iload_1
    //   82: iconst_1
    //   83: iadd
    //   84: istore_1
    //   85: goto -45 -> 40
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: ldc 125
    //   93: aload_2
    //   94: ldc_w 389
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 469	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: ldc_w 445
    //   107: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: invokestatic 475	java/util/Collections:emptySet	()Ljava/util/Set;
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
  
  private com.tencent.mm.plugin.websearch.api.q bm(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = aa.d(paramMap, "scene", 0);
    com.tencent.mm.plugin.websearch.api.q localq = new com.tencent.mm.plugin.websearch.api.q();
    localq.dcm = aa.w(paramMap, "query");
    localq.offset = aa.d(paramMap, "offset", 0);
    localq.businessType = aa.d(paramMap, "type", 0);
    localq.scene = i;
    localq.AFP = aa.w(paramMap, "sugId");
    localq.AFR = aa.d(paramMap, "sugType", 0);
    localq.AFQ = aa.w(paramMap, "prefixSug");
    localq.AGc = aa.w(paramMap, "poiInfo");
    if (aa.x(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new xp();
            ((xp)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((xp)localObject6).CZi = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((xp)localObject6).CZj = ((JSONObject)localObject5).optString("textValue", "");
            localq.AFX.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = aa.w(paramMap, "matchUser");
    if (!bt.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new dis();
      ((dis)localObject5).mAQ = ((JSONObject)localObject2).optString("userName");
      ((dis)localObject5).Ezd = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((dis)localObject5).mAQ)) {
        localq.AFO.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          localq.AFS.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new btq();
            ((btq)localObject6).DRf = ((JSONObject)localObject5).optLong("from");
            ((btq)localObject6).DRg = ((JSONObject)localObject5).optLong("to");
            ((btq)localObject6).DRe = ((JSONObject)localObject5).optInt("field");
            localq.AFY.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        localq.dtt = bt.i(paramMap.get("webview_instance_id"), -1);
        localq.aSt = ac.ir(aj.getContext());
        localq.roM = aa.d(paramMap, "subType", 0);
        localq.AFZ = aa.d(paramMap, "isWeAppMore", 0);
        if (localq.AFZ == 1)
        {
          localq.AGa = new dwe();
          localq.AGa.EJV = aa.Sb(3);
          localq.AGa.EJW = com.tencent.mm.modelappbrand.b.gRw;
          localq.AGa.DQZ = aa.d(paramMap, "subType", 0);
          localq.AGa.session_id = com.tencent.mm.modelappbrand.b.gRv;
          localq.AGa.EJX = localq.AFU;
          localObject4 = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnF, null);
          if ((localObject4 != null) && ((localObject4 instanceof String))) {
            localq.AGa.EIq = ((String)localObject4);
          }
        }
        if (this.APo != 1) {
          break label1244;
        }
      }
      localq.AGb = this.AGb;
    }
    Object localObject4 = localq.dcm;
    com.tencent.mm.plugin.webview.fts.b.a.a.ejZ();
    localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.avP((String)localObject4);
    if (localObject4 == null) {}
    for (localObject4 = "";; localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APR)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localq.dcm = ((String)localObject4);
        localq.AGb = this.AGb;
      }
      if ((localq.scene == 33) && (this.APp != null))
      {
        if (localq.AGb == null) {
          localq.AGb = new dsu();
        }
        if (localq.AGb.EHt == null) {
          localq.AGb.EHt = new of();
        }
        if (this.APp.EHt != null)
        {
          localq.AGb.EHt.CLS = this.APp.EHt.CLS;
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.APp.EHt.CLS });
        }
        this.APp = null;
      }
      if ((localq.businessType == 262144) && (this.APp != null) && (this.APp.EHt.CLO == 1))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("isRefresh", 1);
        ((Bundle)localObject4).putString("widgetId", aa.w(paramMap, "widgetId"));
        localq.AGe = ((Bundle)localObject4);
        localq.AGb = this.APp;
        this.APp = null;
      }
      AppMethodBeat.o(77967);
      return localq;
      label1244:
      localq.AGb = null;
      break;
      ad.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APR, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dlB, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APO, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APQ });
      this.AGb = new dsu();
      this.AGb.EHs = 1L;
      this.AGb.EHt = new of();
      this.AGb.EHt.dlB = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dlB;
      this.AGb.EHt.CLK = bt.aGh(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APO);
      this.AGb.EHt.oec = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).APQ;
    }
  }
  
  private boolean i(Set<String> paramSet)
  {
    AppMethodBeat.i(77962);
    if ((paramSet == null) || (this.AOY.containsAll(paramSet)))
    {
      AppMethodBeat.o(77962);
      return true;
    }
    AppMethodBeat.o(77962);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(77964);
    ad.i("MicroMsg.WebSearch.WebSearchLogic", "preGetSearchData");
    HashMap localHashMap = new HashMap();
    localHashMap.put("displayPattern", "2");
    localHashMap.put("query", paramString4);
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", "0");
    localHashMap.put("isHomePage", "1");
    localHashMap.put("sugId", paramString6);
    localHashMap.put("sceneActionType", Integer.valueOf(paramInt2));
    paramString4 = new JSONArray();
    try
    {
      paramString6 = new JSONObject();
      paramString6.put("key", "netType");
      paramString6.put("textValue", aa.cWN());
      paramString4.put(paramString6);
      paramString6 = new JSONObject();
      paramString6.put("key", "currentPage");
      paramString6.put("textValue", 1);
      paramString4.put(paramString6);
      paramString6 = new JSONObject();
      paramString6.put("key", "requestId");
      paramString6.put("textValue", paramString1);
      paramString4.put(paramString6);
      paramString6 = new JSONObject();
      paramString6.put("key", "parentSearchID");
      paramString6.put("textValue", paramString5);
      paramString4.put(paramString6);
      localHashMap.put("extReqParams", paramString4.toString());
      localHashMap.put("sessionId", paramString2);
      localHashMap.put("subSessionId", paramString3);
      localHashMap.put("requestId", paramString1);
      paramString1 = bm(localHashMap);
      paramString1.AGf = true;
      if (!aU(paramString1.AFX))
      {
        paramString1 = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.o(77964);
        throw paramString1;
      }
    }
    catch (JSONException paramString5)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.APu.b(paramString1);
      AppMethodBeat.o(77964);
    }
    return false;
  }
  
  public final boolean bk(Map<String, Object> paramMap)
  {
    int j = 1;
    AppMethodBeat.i(77961);
    ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
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
        ad.e("MicroMsg.WebSearch.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.APb = true;
        if (this.APc != null) {
          this.APc.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      ad.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for pre getdata back");
      AppMethodBeat.o(77961);
      return false;
      if (this.APc != null) {
        this.APc.countDown();
      }
      i = j;
      if (this.APd != null)
      {
        ad.i("MicroMsg.WebSearch.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.APd.dtt), this.APd });
        i = j;
        continue;
        if (this.APc != null) {
          this.APc.countDown();
        }
        i = 0;
      }
    }
    paramMap = bm(paramMap);
    this.APu.b(paramMap);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean bn(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new com.tencent.mm.plugin.websearch.api.q();
    ((com.tencent.mm.plugin.websearch.api.q)localObject).dcm = aa.w(paramMap, "query");
    try
    {
      ((com.tencent.mm.plugin.websearch.api.q)localObject).dcm = URLDecoder.decode(((com.tencent.mm.plugin.websearch.api.q)localObject).dcm, "UTF-8");
      label59:
      ((com.tencent.mm.plugin.websearch.api.q)localObject).businessType = aa.d(paramMap, "type", 0);
      ((com.tencent.mm.plugin.websearch.api.q)localObject).scene = aa.d(paramMap, "scene", 0);
      int i;
      if (aa.x(paramMap, "isHomePage"))
      {
        i = 1;
        ((com.tencent.mm.plugin.websearch.api.q)localObject).AFN = i;
        ((com.tencent.mm.plugin.websearch.api.q)localObject).dtt = bt.i(paramMap.get("webview_instance_id"), -1);
        ((com.tencent.mm.plugin.websearch.api.q)localObject).AFS.add(aa.w(paramMap, "prefixQuery"));
        i = aa.d(paramMap, "requestType", 0);
        ((com.tencent.mm.plugin.websearch.api.q)localObject).roM = aa.d(paramMap, "subtype", 0);
        ((com.tencent.mm.plugin.websearch.api.q)localObject).AFZ = aa.d(paramMap, "isWeAppMore", 0);
        if (((com.tencent.mm.plugin.websearch.api.q)localObject).AFZ == 1)
        {
          ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa = new dwe();
          ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa.EJV = aa.Sb(3);
          ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa.EJW = com.tencent.mm.modelappbrand.b.gRw;
          ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa.DQZ = aa.d(paramMap, "subType", 0);
          ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa.session_id = com.tencent.mm.modelappbrand.b.gRv;
          paramMap = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnF, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((com.tencent.mm.plugin.websearch.api.q)localObject).AGa.EIq = ((String)paramMap);
          }
        }
        ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.websearch.api.q)localObject).dtt) });
        switch (i)
        {
        }
      }
      String str;
      int j;
      do
      {
        for (;;)
        {
          AppMethodBeat.o(77970);
          return false;
          i = 0;
          break;
          paramMap = this.APv;
          if (paramMap.APC != null)
          {
            com.tencent.mm.kernel.g.aeS().b(paramMap.APC.getType(), paramMap.APw);
            com.tencent.mm.kernel.g.aeS().a(paramMap.APC);
            paramMap.APC = null;
          }
          if (paramMap.APC == null)
          {
            paramMap.APC = new f((com.tencent.mm.plugin.websearch.api.q)localObject);
            com.tencent.mm.kernel.g.aeS().a(paramMap.APC.getType(), paramMap.APw);
            com.tencent.mm.kernel.g.aeS().a(paramMap.APC, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(((com.tencent.mm.plugin.websearch.api.q)localObject).dtt).avX(ae.eia());
          }
        }
        str = ((com.tencent.mm.plugin.websearch.api.q)localObject).dcm;
        i = ((com.tencent.mm.plugin.websearch.api.q)localObject).businessType;
        j = ((com.tencent.mm.plugin.websearch.api.q)localObject).dtt;
      } while (bt.isNullOrNil(str));
      if (this.rpP != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.rpP);
        this.rpP = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).iWB = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpJ = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpL = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpN = com.tencent.mm.plugin.fts.a.c.b.rqn;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpM = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).rpO = this.uzW;
        this.rpP = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.rpP.roI = Integer.valueOf(j);
        break;
        paramMap = new int[1];
        paramMap[0] = 131072;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label59;
    }
  }
  
  public final void ejV()
  {
    AppMethodBeat.i(77972);
    String str = aa.Se(0);
    ad.i("MicroMsg.WebSearch.WebSearchLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.APf = true;
      AppMethodBeat.o(77972);
      return;
    }
    this.APf = i(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(77972);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(77968);
    int i;
    if (paramn != null) {
      i = paramn.getType();
    }
    for (;;)
    {
      ad.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.aeS().b(paramn.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.cxj() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ehC(), paramn, paramString.ehD(), paramString.ehH(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramn = paramString.ehF();
        paramInt1 = paramString.ehG();
        ad.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.cxj() });
        a(paramString.ehC(), paramn, paramString.ehD(), paramString.ehH(), paramString.ehE());
        if (paramInt1 > 0)
        {
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.h.a.a.b.ewn();
          com.tencent.mm.pluginsdk.h.a.a.b.Ur(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.aeS().b(paramn.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramn;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            ad.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.ehC()).avX("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramn = paramString.ehF();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(paramString.ehC()).avX(paramn);
        }
        AppMethodBeat.o(77968);
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
    public a APA;
    public com.tencent.mm.plugin.websearch.api.a APl;
    private ThreadPoolExecutor cUW;
    
    private a()
    {
      AppMethodBeat.i(77957);
      this.cUW = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(com.tencent.mm.plugin.websearch.api.q paramq)
    {
      AppMethodBeat.i(77958);
      if (this.APA != null) {
        this.APA.stopped = true;
      }
      this.APA = new a((byte)0);
      this.APA.AGj = paramq;
      h.a(h.this, paramq);
      this.cUW.execute(this.APA);
      AppMethodBeat.o(77958);
    }
    
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
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if (bt.isNullOrNil(this.AGj.dcm))
        {
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.AGj.businessType), Integer.valueOf(this.AGj.scene), Integer.valueOf(this.AGj.AFN), Integer.valueOf(this.AGj.dtA), this.AGj.oEK, Integer.valueOf(this.AGj.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.AGj.scene)
        {
        }
        for (;;)
        {
          ad.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.AGj.dcm, Integer.valueOf(this.AGj.dtt) });
          if (h.a.a(h.a.this) != null) {
            com.tencent.mm.kernel.g.aeS().a(h.a.a(h.a.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.AGj.AFO != null)
          {
            localObject = localLinkedList;
            if (!this.AGj.AFO.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (h.ay(this.AGj.dcm, this.AGj.scene, this.AGj.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.a.a.e)h.a(h.this).avl(this.AGj.dcm);
              l = System.currentTimeMillis() - l;
              ad.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.h.vKh.f(14717, new Object[] { this.AGj.dcm, Integer.valueOf(w.ary()), Integer.valueOf(((com.tencent.mm.plugin.websearch.a.a.e)localObject).kLN.size()), Long.valueOf(l), Integer.valueOf(this.AGj.scene) });
            }
          }
          if (this.stopped)
          {
            ad.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.AGj.dcm);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label477:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.AGj.dcm + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.emC().AOw.s(this.AGj.scene, this.AGj.dcm, this.AGj.businessType);
            h.a.a(h.a.this, h.a.c(this.AGj));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.a.a.e)localObject).kLN).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.a.a.e.a locala = (com.tencent.mm.plugin.websearch.a.a.e.a)((Iterator)localObject).next();
                dis localdis = new dis();
                localdis.mAQ = locala.userName;
                localdis.Ezd = locala.AHX;
                localdis.mBV = locala.bNK;
                localdis.Dap = locala.iaz;
                localdis.ijR = locala.eKn;
                localdis.Cxw = locala.desc;
                localLinkedList.add(localdis);
              }
              h.a.a(h.a.this).aT(localLinkedList);
            }
            com.tencent.mm.kernel.g.aeS().a(h.a.a(h.a.this).getType(), h.this);
            com.tencent.mm.kernel.g.aeS().a(h.a.a(h.a.this), 0);
            ad.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(h.a.a(h.a.this).getType()) });
            AppMethodBeat.o(77956);
            return;
          }
          catch (Exception localException)
          {
            break label477;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */