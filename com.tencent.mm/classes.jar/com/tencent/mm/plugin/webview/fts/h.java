package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g
{
  static final long Chm;
  public dyl BYu;
  public int ChE;
  public dyl ChF;
  public Map<String, Integer> ChG;
  long ChH;
  public com.tencent.mm.sdk.b.c ChI;
  private com.tencent.mm.plugin.websearch.a.a.c ChJ;
  public a ChK;
  public h.b ChL;
  private ao Chn;
  private Set<String> Cho;
  volatile boolean Chq;
  volatile boolean Chr;
  volatile CountDownLatch Chs;
  private volatile p Cht;
  volatile boolean Chv;
  public com.tencent.mm.sdk.b.c Chw;
  public com.tencent.mm.plugin.fts.a.a.a syJ;
  private l vIP;
  
  static
  {
    AppMethodBeat.i(77974);
    Chm = com.tencent.mm.ui.d.feW() + 500;
    AppMethodBeat.o(77974);
  }
  
  public h()
  {
    AppMethodBeat.i(77960);
    this.Chn = new ao("WebSearchLogic_worker");
    this.ChE = 0;
    this.ChG = new HashMap();
    this.Chw = new h.1(this);
    this.ChI = new h.2(this);
    this.ChJ = new com.tencent.mm.plugin.websearch.a.a.b();
    this.ChK = new a((byte)0);
    this.ChL = new h.b(this, (byte)0);
    this.vIP = new h.6(this);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.Chw.alive();
    this.ChI.alive();
    this.Cho = new HashSet();
    this.Cho.add("netType");
    this.Cho.add("currentPage");
    this.Cho.add("requestId");
    this.Cho.add("parentSearchID");
    ezq();
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramm.sxG);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.acr(paramm.sxG);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.sxF)
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
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).sxP = com.tencent.mm.plugin.fts.a.a.e.a.sxY;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).sxU = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).sxV = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).syd.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.sxP = com.tencent.mm.plugin.fts.a.a.e.a.sxY;
            paramh.sxU = "<em class=\"highlight\">";
            paramh.sxV = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).syd.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.acr(paramm.sxG));
              ((JSONObject)localObject1).put("userName", paramm.sxG);
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
      localObject1 = ((av)localObject4).field_nickname;
      localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762930);
      i = 1;
      j = 0;
      break;
      localObject1 = ((av)localObject4).eyf;
      localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762925);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((com.tencent.mm.storage.ai)localObject4).Tl();
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = ((av)localObject4).field_username;
      }
      localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762935);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paramm.content;
      if (!bs.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label500:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramh.syk)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762929);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label500;
        localObject1 = paramm.content;
        localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762931);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramm.content;
        localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762924);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().afM(((av)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.sym;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.afQ(str).contains(localCharSequence))
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
          localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131762934);
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
    this.Chn.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188282);
        if (h.b(h.this) != null) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(h.b(h.this).getCount()) });
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
            int j = h.c(h.this).drc;
            i = j;
            if (!h.c(h.this).BYx) {
              break;
            }
            i = j;
            if (!h.d(h.this)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.WebSearch.WebSearchLogic", "ingore pre get data");
            AppMethodBeat.o(188282);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "count down latch null");
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, h.c(h.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(i).a(paramString1, paramBoolean, paramString2, paramBundle);
        AppMethodBeat.o(188282);
      }
    });
    AppMethodBeat.o(77969);
  }
  
  private boolean bb(LinkedList<yh> paramLinkedList)
  {
    AppMethodBeat.i(77966);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((yh)paramLinkedList.next()).key);
    }
    boolean bool = this.Cho.equals(localHashSet);
    AppMethodBeat.o(77966);
    return bool;
  }
  
  /* Error */
  private static Set<String> bq(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 445
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 447
    //   10: invokestatic 451	com/tencent/mm/plugin/websearch/api/z:x	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 301	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
    //   56: new 432	com/tencent/mm/protocal/protobuf/yh
    //   59: dup
    //   60: invokespecial 460	com/tencent/mm/protocal/protobuf/yh:<init>	()V
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
    //   101: invokestatic 469	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private p br(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = z.d(paramMap, "scene", 0);
    p localp = new p();
    localp.cZL = z.x(paramMap, "query");
    localp.offset = z.d(paramMap, "offset", 0);
    localp.businessType = z.d(paramMap, "type", 0);
    localp.scene = i;
    localp.BYi = z.x(paramMap, "sugId");
    localp.BYk = z.d(paramMap, "sugType", 0);
    localp.BYj = z.x(paramMap, "prefixSug");
    localp.BYv = z.x(paramMap, "poiInfo");
    if (z.y(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new yh();
            ((yh)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((yh)localObject6).ErV = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((yh)localObject6).ErW = ((JSONObject)localObject5).optString("textValue", "");
            localp.BYq.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = z.x(paramMap, "matchUser");
    if (!bs.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new doh();
      ((doh)localObject5).ncR = ((JSONObject)localObject2).optString("userName");
      ((doh)localObject5).FWf = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((doh)localObject5).ncR)) {
        localp.BYh.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          localp.BYl.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new byh();
            ((byh)localObject6).Fnx = ((JSONObject)localObject5).optLong("from");
            ((byh)localObject6).Fny = ((JSONObject)localObject5).optLong("to");
            ((byh)localObject6).Fnw = ((JSONObject)localObject5).optInt("field");
            localp.BYr.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        localp.drc = bs.l(paramMap.get("webview_instance_id"), -1);
        localp.aTm = ab.iC(com.tencent.mm.sdk.platformtools.ai.getContext());
        localp.sxF = z.d(paramMap, "subType", 0);
        localp.BYs = z.d(paramMap, "isWeAppMore", 0);
        if (localp.BYs == 1)
        {
          localp.BYt = new ebv();
          localp.BYt.Ghh = z.Ul(3);
          localp.BYt.Ghi = com.tencent.mm.modelappbrand.b.hrW;
          localp.BYt.Fnr = z.d(paramMap, "subType", 0);
          localp.BYt.session_id = com.tencent.mm.modelappbrand.b.hrV;
          localp.BYt.Ghj = localp.BYn;
          localObject4 = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLu, null);
          if ((localObject4 != null) && ((localObject4 instanceof String))) {
            localp.BYt.GfC = ((String)localObject4);
          }
        }
        if (this.ChE != 1) {
          break label1244;
        }
      }
      localp.BYu = this.BYu;
    }
    Object localObject4 = localp.cZL;
    com.tencent.mm.plugin.webview.fts.b.a.a.ezu();
    localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.aBh((String)localObject4);
    if (localObject4 == null) {}
    for (localObject4 = "";; localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cie)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localp.cZL = ((String)localObject4);
        localp.BYu = this.BYu;
      }
      if ((localp.scene == 33) && (this.ChF != null))
      {
        if (localp.BYu == null) {
          localp.BYu = new dyl();
        }
        if (localp.BYu.GeF == null) {
          localp.BYu.GeF = new om();
        }
        if (this.ChF.GeF != null)
        {
          localp.BYu.GeF.Eeu = this.ChF.GeF.Eeu;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.ChF.GeF.Eeu });
        }
        this.ChF = null;
      }
      if ((localp.businessType == 262144) && (this.ChF != null) && (this.ChF.GeF.Eer == 1))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("isRefresh", 1);
        ((Bundle)localObject4).putString("widgetId", z.x(paramMap, "widgetId"));
        localp.wWc = ((Bundle)localObject4);
        localp.BYu = this.ChF;
        this.ChF = null;
      }
      AppMethodBeat.o(77967);
      return localp;
      label1244:
      localp.BYu = null;
      break;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cie, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).djj, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cic, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cid });
      this.BYu = new dyl();
      this.BYu.GeE = 1L;
      this.BYu.GeF = new om();
      this.BYu.GeF.djj = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).djj;
      this.BYu.GeF.Een = bs.aLy(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cic);
      this.BYu.GeF.oHB = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Cid;
    }
  }
  
  private boolean j(Set<String> paramSet)
  {
    AppMethodBeat.i(77962);
    if ((paramSet == null) || (this.Cho.containsAll(paramSet)))
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "preGetSearchData");
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
      paramString6.put("textValue", z.dkv());
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
      paramString1 = br(localHashMap);
      paramString1.BYx = true;
      if (!bb(paramString1.BYq))
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.ChK.b(paramString1);
      AppMethodBeat.o(77964);
    }
    return false;
  }
  
  public final boolean bp(Map<String, Object> paramMap)
  {
    int j = 1;
    AppMethodBeat.i(77961);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
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
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebSearch.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.Chr = true;
        if (this.Chs != null) {
          this.Chs.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for pre getdata back");
      AppMethodBeat.o(77961);
      return false;
      if (this.Chs != null) {
        this.Chs.countDown();
      }
      i = j;
      if (this.Cht != null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.Cht.drc), this.Cht });
        i = j;
        continue;
        if (this.Chs != null) {
          this.Chs.countDown();
        }
        i = 0;
      }
    }
    paramMap = br(paramMap);
    this.ChK.b(paramMap);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean bs(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new p();
    ((p)localObject).cZL = z.x(paramMap, "query");
    try
    {
      ((p)localObject).cZL = URLDecoder.decode(((p)localObject).cZL, "UTF-8");
      label59:
      ((p)localObject).businessType = z.d(paramMap, "type", 0);
      ((p)localObject).scene = z.d(paramMap, "scene", 0);
      int i;
      if (z.y(paramMap, "isHomePage"))
      {
        i = 1;
        ((p)localObject).BYg = i;
        ((p)localObject).drc = bs.l(paramMap.get("webview_instance_id"), -1);
        ((p)localObject).BYl.add(z.x(paramMap, "prefixQuery"));
        i = z.d(paramMap, "requestType", 0);
        ((p)localObject).sxF = z.d(paramMap, "subtype", 0);
        ((p)localObject).BYs = z.d(paramMap, "isWeAppMore", 0);
        if (((p)localObject).BYs == 1)
        {
          ((p)localObject).BYt = new ebv();
          ((p)localObject).BYt.Ghh = z.Ul(3);
          ((p)localObject).BYt.Ghi = com.tencent.mm.modelappbrand.b.hrW;
          ((p)localObject).BYt.Fnr = z.d(paramMap, "subType", 0);
          ((p)localObject).BYt.session_id = com.tencent.mm.modelappbrand.b.hrV;
          paramMap = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GLu, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((p)localObject).BYt.GfC = ((String)paramMap);
          }
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((p)localObject).drc) });
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
          paramMap = this.ChL;
          if (paramMap.ChS != null)
          {
            com.tencent.mm.kernel.g.agi().b(paramMap.ChS.getType(), paramMap.ChM);
            com.tencent.mm.kernel.g.agi().a(paramMap.ChS);
            paramMap.ChS = null;
          }
          if (paramMap.ChS == null)
          {
            paramMap.ChS = new f((p)localObject);
            com.tencent.mm.kernel.g.agi().a(paramMap.ChS.getType(), paramMap.ChM);
            com.tencent.mm.kernel.g.agi().a(paramMap.ChS, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(((p)localObject).drc).aBp(com.tencent.mm.plugin.websearch.api.ac.exu());
          }
        }
        str = ((p)localObject).cZL;
        i = ((p)localObject).businessType;
        j = ((p)localObject).drc;
      } while (bs.isNullOrNil(str));
      if (this.syJ != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.syJ);
        this.syJ = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jwR = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).syD = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).syF = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).syH = com.tencent.mm.plugin.fts.a.c.b.szh;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).syG = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).syI = this.vIP;
        this.syJ = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.syJ.sxB = Integer.valueOf(j);
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
  
  public final void ezq()
  {
    AppMethodBeat.i(77972);
    String str = z.Uo(0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.Chv = true;
      AppMethodBeat.o(77972);
      return;
    }
    this.Chv = j(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(77972);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(77968);
    int i;
    if (paramn != null) {
      i = paramn.getType();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.agi().b(paramn.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.cKv() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ewW(), paramn, paramString.ewX(), paramString.exb(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramn = paramString.ewZ();
        paramInt1 = paramString.exa();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.cKv() });
        a(paramString.ewW(), paramn, paramString.ewX(), paramString.exb(), paramString.ewY());
        if (paramInt1 > 0)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.h.a.a.b.eLH();
          com.tencent.mm.pluginsdk.h.a.a.b.WB(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.agi().b(paramn.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramn;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.ewW()).aBp("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramn = paramString.ewZ();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(paramString.ewW()).aBp(paramn);
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
    public com.tencent.mm.plugin.websearch.api.a ChB;
    public a ChQ;
    private ThreadPoolExecutor cSs;
    
    private a()
    {
      AppMethodBeat.i(77957);
      this.cSs = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(77958);
      if (this.ChQ != null) {
        this.ChQ.stopped = true;
      }
      this.ChQ = new a((byte)0);
      this.ChQ.BYB = paramp;
      h.a(h.this, paramp);
      this.cSs.execute(this.ChQ);
      AppMethodBeat.o(77958);
    }
    
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
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if (bs.isNullOrNil(this.BYB.cZL))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.BYB.businessType), Integer.valueOf(this.BYB.scene), Integer.valueOf(this.BYB.BYg), Integer.valueOf(this.BYB.drj), this.BYB.pik, Integer.valueOf(this.BYB.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.BYB.scene)
        {
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.BYB.cZL, Integer.valueOf(this.BYB.drc) });
          if (h.a.a(h.a.this) != null) {
            com.tencent.mm.kernel.g.agi().a(h.a.a(h.a.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.BYB.BYh != null)
          {
            localObject = localLinkedList;
            if (!this.BYB.BYh.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (h.ax(this.BYB.cZL, this.BYB.scene, this.BYB.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.a.a.e)h.a(h.this).aAD(this.BYB.cZL);
              l = System.currentTimeMillis() - l;
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.h.wUl.f(14717, new Object[] { this.BYB.cZL, Integer.valueOf(w.ayo()), Integer.valueOf(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lnk.size()), Long.valueOf(l), Integer.valueOf(this.BYB.scene) });
            }
          }
          if (this.stopped)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.BYB.cZL);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label477:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.BYB.cZL + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.eBX().CgO.u(this.BYB.scene, this.BYB.cZL, this.BYB.businessType);
            h.a.a(h.a.this, h.a.c(this.BYB));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lnk).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.a.a.e.a locala = (com.tencent.mm.plugin.websearch.a.a.e.a)((Iterator)localObject).next();
                doh localdoh = new doh();
                localdoh.ncR = locala.userName;
                localdoh.FWf = locala.Cao;
                localdoh.ndW = locala.bLs;
                localdoh.Etm = locala.iAC;
                localdoh.iJY = locala.eNf;
                localdoh.DPS = locala.desc;
                localLinkedList.add(localdoh);
              }
              h.a.a(h.a.this).ba(localLinkedList);
            }
            com.tencent.mm.kernel.g.agi().a(h.a.a(h.a.this).getType(), h.this);
            com.tencent.mm.kernel.g.agi().a(h.a.a(h.a.this), 0);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(h.a.a(h.a.this).getType()) });
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