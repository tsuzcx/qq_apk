package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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

public final class i
  implements com.tencent.mm.al.f
{
  static final long DKt;
  public een DBn;
  private volatile s DKA;
  volatile boolean DKC;
  public com.tencent.mm.sdk.b.c DKD;
  public int DKL;
  public een DKM;
  public Map<String, Integer> DKN;
  long DKO;
  public com.tencent.mm.sdk.b.c DKP;
  private com.tencent.mm.plugin.websearch.a.a.c DKQ;
  public a DKR;
  public i.b DKS;
  private ap DKu;
  private Set<String> DKv;
  volatile boolean DKx;
  volatile boolean DKy;
  volatile CountDownLatch DKz;
  public com.tencent.mm.plugin.fts.a.a.a tvk;
  private com.tencent.mm.plugin.fts.a.l wPW;
  
  static
  {
    AppMethodBeat.i(77974);
    DKt = com.tencent.mm.ui.d.fve() + 500;
    AppMethodBeat.o(77974);
  }
  
  public i()
  {
    AppMethodBeat.i(77960);
    this.DKu = new ap("WebSearchLogic_worker");
    this.DKL = 0;
    this.DKN = new HashMap();
    this.DKD = new i.1(this);
    this.DKP = new com.tencent.mm.sdk.b.c() {};
    this.DKQ = new com.tencent.mm.plugin.websearch.a.a.b();
    this.DKR = new a((byte)0);
    this.DKS = new i.b(this, (byte)0);
    this.wPW = new i.6(this);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.DKD.alive();
    this.DKP.alive();
    this.DKv = new HashSet();
    this.DKv.add("netType");
    this.DKv.add("currentPage");
    this.DKv.add("requestId");
    this.DKv.add("parentSearchID");
    eOf();
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramm.tuh);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.agg(paramm.tuh);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.tug)
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
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tuq = com.tencent.mm.plugin.fts.a.a.e.a.tuz;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tuv = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tuw = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).tuE.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.tuq = com.tencent.mm.plugin.fts.a.a.e.a.tuz;
            paramh.tuv = "<em class=\"highlight\">";
            paramh.tuw = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).tuE.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.agg(paramm.tuh));
              ((JSONObject)localObject1).put("userName", paramm.tuh);
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
      localObject1 = ((aw)localObject4).field_nickname;
      localObject2 = aj.getContext().getString(2131762930);
      i = 1;
      j = 0;
      break;
      localObject1 = ((aw)localObject4).ePD;
      localObject2 = aj.getContext().getString(2131762925);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((am)localObject4).VA();
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = ((aw)localObject4).field_username;
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
          if (((String)localObject2).startsWith(paramh.tuL)) {
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
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().akk(((aw)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.tuN;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.ako(str).contains(localCharSequence))
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
        paramh = (h)localObject1;
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
    this.DKu.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207816);
        if (i.b(i.this) != null) {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(i.b(i.this).getCount()) });
        }
        int i;
        for (;;)
        {
          try
          {
            i.b(i.this).await();
            i = paramInt;
            if (i.c(i.this) == null) {
              break;
            }
            int j = i.c(i.this).dCT;
            i = j;
            if (!i.c(i.this).DBq) {
              break;
            }
            i = j;
            if (!i.d(i.this)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WebSearch.WebSearchLogic", "ingore pre get data");
            AppMethodBeat.o(207816);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "count down latch null");
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, i.c(i.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(i).a(paramString1, paramBoolean, paramString2, paramBundle);
        AppMethodBeat.o(207816);
      }
    });
    AppMethodBeat.o(77969);
  }
  
  private boolean bc(LinkedList<aag> paramLinkedList)
  {
    AppMethodBeat.i(77966);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((aag)paramLinkedList.next()).key);
    }
    boolean bool = this.DKv.equals(localHashSet);
    AppMethodBeat.o(77966);
    return bool;
  }
  
  /* Error */
  private static Set<String> bt(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 443
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 445
    //   10: invokestatic 449	com/tencent/mm/plugin/websearch/api/ad:z	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 299	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifne +94 -> 112
    //   21: new 141	java/util/HashSet
    //   24: dup
    //   25: invokespecial 142	java/util/HashSet:<init>	()V
    //   28: astore_2
    //   29: new 451	org/json/JSONArray
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 452	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload_1
    //   43: aload_3
    //   44: invokevirtual 453	org/json/JSONArray:length	()I
    //   47: if_icmpge +57 -> 104
    //   50: aload_3
    //   51: iload_1
    //   52: invokevirtual 457	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore_0
    //   56: new 430	com/tencent/mm/protocal/protobuf/aag
    //   59: dup
    //   60: invokespecial 458	com/tencent/mm/protocal/protobuf/aag:<init>	()V
    //   63: pop
    //   64: aload_2
    //   65: aload_0
    //   66: ldc_w 459
    //   69: ldc_w 387
    //   72: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   94: ldc_w 387
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 467	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: ldc_w 443
    //   107: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: invokestatic 473	java/util/Collections:emptySet	()Ljava/util/Set;
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
  
  private s bu(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    s locals = new s();
    locals.dld = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    locals.scene = i;
    locals.DBb = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "sugId");
    locals.DBd = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugType", 0);
    locals.DBc = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "prefixSug");
    locals.DBo = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "poiInfo");
    if (com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new aag();
            ((aag)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((aag)localObject6).FZe = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((aag)localObject6).FZf = ((JSONObject)localObject5).optString("textValue", "");
            locals.DBj.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "matchUser");
    if (!bt.isNullOrNil((String)localObject2)) {}
    Object localObject4;
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new dty();
      ((dty)localObject5).nDo = ((JSONObject)localObject2).optString("userName");
      ((dty)localObject5).HGV = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((dty)localObject5).nDo)) {
        locals.DBa.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          locals.DBe.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new ccy();
            ((ccy)localObject6).GXg = ((JSONObject)localObject5).optLong("from");
            ((ccy)localObject6).GXh = ((JSONObject)localObject5).optLong("to");
            ((ccy)localObject6).GXf = ((JSONObject)localObject5).optInt("field");
            locals.DBk.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.dCT = bt.m(paramMap.get("webview_instance_id"), -1);
        locals.language = ac.iM(aj.getContext());
        locals.tug = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
        locals.DBl = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0);
        if (locals.DBl == 1)
        {
          locals.DBm = new eib();
          locals.DBm.FFA = com.tencent.mm.plugin.websearch.api.ad.We(3);
          locals.DBm.HSw = com.tencent.mm.modelappbrand.b.hKo;
          locals.DBm.GXa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
          locals.DBm.session_id = com.tencent.mm.modelappbrand.b.hKn;
          locals.DBm.HSx = locals.DBg;
          localObject4 = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxM, null);
          if ((localObject4 != null) && ((localObject4 instanceof String))) {
            locals.DBm.HjZ = ((String)localObject4);
          }
        }
        if (this.DKL != 1) {
          break label1299;
        }
      }
      locals.DBn = this.DBn;
    }
    for (;;)
    {
      localObject4 = locals.dld;
      com.tencent.mm.plugin.webview.fts.b.a.a.eOj();
      localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.aGC((String)localObject4);
      if (localObject4 == null)
      {
        localObject4 = "";
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          locals.dld = ((String)localObject4);
          locals.DBn = this.DBn;
        }
        if ((locals.scene == 33) && (this.DKM != null))
        {
          if (locals.DBn == null) {
            locals.DBn = new een();
          }
          if (locals.DBn.HPL == null) {
            locals.DBn.HPL = new pr();
          }
          if (this.DKM.HPL != null)
          {
            locals.DBn.HPL.FKT = this.DKM.HPL.FKT;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.DKM.HPL.FKT });
          }
          this.DKM = null;
        }
        if ((locals.businessType == 262144) && (this.DKM != null) && (this.DKM.HPL.FKQ == 1))
        {
          localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("isRefresh", 1);
          ((Bundle)localObject4).putString("widgetId", com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "widgetId"));
          locals.yjJ = ((Bundle)localObject4);
          locals.DBn = this.DKM;
          this.DKM = null;
        }
        paramMap = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "specialSearch");
        if (bt.isNullOrNil(paramMap)) {}
      }
      try
      {
        paramMap = new JSONObject(paramMap);
        locals.DBs = paramMap.optInt("type", 0);
        locals.dlu = paramMap.optJSONObject("params").optString("reqKey");
        label1290:
        AppMethodBeat.o(77967);
        return locals;
        label1299:
        locals.DBn = null;
        continue;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLl, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).duW, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLj, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLk });
        this.DBn = new een();
        this.DBn.HPK = 1L;
        this.DBn.HPL = new pr();
        this.DBn.HPL.duW = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).duW;
        this.DBn.HPL.FKM = bt.aRe(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLj);
        this.DBn.HPL.plf = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLk;
        localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).DLl;
      }
      catch (Exception paramMap)
      {
        break label1290;
      }
    }
  }
  
  private boolean q(Set<String> paramSet)
  {
    AppMethodBeat.i(77962);
    if ((paramSet == null) || (this.DKv.containsAll(paramSet)))
    {
      AppMethodBeat.o(77962);
      return true;
    }
    AppMethodBeat.o(77962);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(207819);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "preGetSearchData");
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
      paramString6.put("textValue", com.tencent.mm.plugin.websearch.api.ad.Ux());
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
      paramString1 = bu(localHashMap);
      if (paramInt3 == 1) {
        paramString1.DBs = 1;
      }
      paramString1.DBq = true;
      if (!bc(paramString1.DBj))
      {
        paramString1 = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.o(207819);
        throw paramString1;
      }
    }
    catch (JSONException paramString5)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.DKR.b(paramString1);
      AppMethodBeat.o(207819);
    }
    return false;
  }
  
  public final boolean bs(Map<String, Object> paramMap)
  {
    int j = 1;
    AppMethodBeat.i(77961);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebSearch.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.DKy = true;
        if (this.DKz != null) {
          this.DKz.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for pre getdata back");
      AppMethodBeat.o(77961);
      return false;
      if (this.DKz != null) {
        this.DKz.countDown();
      }
      i = j;
      if (this.DKA != null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.DKA.dCT), this.DKA });
        i = j;
        continue;
        if (this.DKz != null) {
          this.DKz.countDown();
        }
        i = 0;
      }
    }
    paramMap = bu(paramMap);
    this.DKR.b(paramMap);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean bv(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new s();
    ((s)localObject).dld = com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "query");
    try
    {
      ((s)localObject).dld = URLDecoder.decode(((s)localObject).dld, "UTF-8");
      label59:
      ((s)localObject).businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
      ((s)localObject).scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
      int i;
      if (com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "isHomePage"))
      {
        i = 1;
        ((s)localObject).DAZ = i;
        ((s)localObject).dCT = bt.m(paramMap.get("webview_instance_id"), -1);
        ((s)localObject).DBe.add(com.tencent.mm.plugin.websearch.api.ad.z(paramMap, "prefixQuery"));
        i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "requestType", 0);
        ((s)localObject).tug = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subtype", 0);
        ((s)localObject).DBl = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0);
        if (((s)localObject).DBl == 1)
        {
          ((s)localObject).DBm = new eib();
          ((s)localObject).DBm.FFA = com.tencent.mm.plugin.websearch.api.ad.We(3);
          ((s)localObject).DBm.HSw = com.tencent.mm.modelappbrand.b.hKo;
          ((s)localObject).DBm.GXa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
          ((s)localObject).DBm.session_id = com.tencent.mm.modelappbrand.b.hKn;
          paramMap = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxM, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((s)localObject).DBm.HjZ = ((String)paramMap);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((s)localObject).dCT) });
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
          paramMap = this.DKS;
          if (paramMap.DKZ != null)
          {
            com.tencent.mm.kernel.g.aiU().b(paramMap.DKZ.getType(), paramMap.DKT);
            com.tencent.mm.kernel.g.aiU().a(paramMap.DKZ);
            paramMap.DKZ = null;
          }
          if (paramMap.DKZ == null)
          {
            paramMap.DKZ = new g((s)localObject);
            com.tencent.mm.kernel.g.aiU().a(paramMap.DKZ.getType(), paramMap.DKT);
            com.tencent.mm.kernel.g.aiU().a(paramMap.DKZ, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(((s)localObject).dCT).aGL(ag.eMl());
          }
        }
        str = ((s)localObject).dld;
        i = ((s)localObject).businessType;
        j = ((s)localObject).dCT;
      } while (bt.isNullOrNil(str));
      if (this.tvk != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tvk);
        this.tvk = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jQN = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tve = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvg = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvi = com.tencent.mm.plugin.fts.a.c.b.tvI;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvh = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tvj = this.wPW;
        this.tvk = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.tvk.tuc = Integer.valueOf(j);
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
  
  public final void eOf()
  {
    AppMethodBeat.i(77972);
    String str = com.tencent.mm.plugin.websearch.api.ad.Wh(0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.DKC = true;
      AppMethodBeat.o(77972);
      return;
    }
    this.DKC = q(new HashSet(Arrays.asList(str.split(","))));
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
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.aiU().b(paramn.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.cSK() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.eLK(), paramn, paramString.eLL(), paramString.eLP(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramn = paramString.eLN();
        paramInt1 = paramString.eLO();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.cSK() });
        a(paramString.eLK(), paramn, paramString.eLL(), paramString.eLP(), paramString.eLM());
        if (paramInt1 > 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.j.a.a.b.faE();
          com.tencent.mm.pluginsdk.j.a.a.b.Yx(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.aiU().b(paramn.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramn;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.eLK()).aGL("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramn = paramString.eLN();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.XN(paramString.eLK()).aGL(paramn);
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
    public com.tencent.mm.plugin.websearch.api.a DKI;
    public a DKX;
    private ThreadPoolExecutor ddI;
    
    private a()
    {
      AppMethodBeat.i(77957);
      this.ddI = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(s params)
    {
      AppMethodBeat.i(77958);
      if (this.DKX != null) {
        this.DKX.stopped = true;
      }
      this.DKX = new a((byte)0);
      this.DKX.DBv = params;
      i.a(i.this, params);
      this.ddI.execute(this.DKX);
      AppMethodBeat.o(77958);
    }
    
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
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if ((bt.isNullOrNil(this.DBv.dld)) && (this.DBv.DBs != 2))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.DBv.businessType), Integer.valueOf(this.DBv.scene), Integer.valueOf(this.DBv.DAZ), Integer.valueOf(this.DBv.dDa), this.DBv.pLL, Integer.valueOf(this.DBv.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.DBv.scene)
        {
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.DBv.dld, Integer.valueOf(this.DBv.dCT) });
          if (i.a.a(i.a.this) != null) {
            com.tencent.mm.kernel.g.aiU().a(i.a.a(i.a.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.DBv.DBa != null)
          {
            localObject = localLinkedList;
            if (!this.DBv.DBa.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (i.aB(this.DBv.dld, this.DBv.scene, this.DBv.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.a.a.e)i.a(i.this).aFX(this.DBv.dld);
              l = System.currentTimeMillis() - l;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.g.yhR.f(14717, new Object[] { this.DBv.dld, Integer.valueOf(w.aBo()), Integer.valueOf(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lKC.size()), Long.valueOf(l), Integer.valueOf(this.DBv.scene) });
            }
          }
          if (this.stopped)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.DBv.dld);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label489:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.DBv.dld + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.eQR().DJV.t(this.DBv.scene, this.DBv.dld, this.DBv.businessType);
            i.a.a(i.a.this, i.a.c(this.DBv));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lKC).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.a.a.e.a locala = (com.tencent.mm.plugin.websearch.a.a.e.a)((Iterator)localObject).next();
                dty localdty = new dty();
                localdty.nDo = locala.userName;
                localdty.HGV = locala.DDj;
                localdty.nEt = locala.bVF;
                localdty.GaD = locala.iTM;
                localdty.jdh = locala.ffB;
                localdty.Fvh = locala.desc;
                localLinkedList.add(localdty);
              }
              i.a.a(i.a.this).bb(localLinkedList);
            }
            com.tencent.mm.kernel.g.aiU().a(i.a.a(i.a.this).getType(), i.this);
            com.tencent.mm.kernel.g.aiU().a(i.a.a(i.a.this), 0);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(i.a.a(i.a.this).getType()) });
            AppMethodBeat.o(77956);
            return;
          }
          catch (Exception localException)
          {
            break label489;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i
 * JD-Core Version:    0.7.0.1
 */