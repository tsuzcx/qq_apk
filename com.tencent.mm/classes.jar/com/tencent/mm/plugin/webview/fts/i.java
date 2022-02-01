package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.duv;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f
{
  static final long Ecr;
  public ege DTk;
  volatile boolean EcA;
  public com.tencent.mm.sdk.b.c EcB;
  public int EcJ;
  public ege EcK;
  public Map<String, Integer> EcL;
  long EcM;
  public com.tencent.mm.sdk.b.c EcN;
  private com.tencent.mm.plugin.websearch.a.a.c EcO;
  public a EcP;
  public i.b EcQ;
  private aq Ecs;
  private Set<String> Ect;
  volatile boolean Ecv;
  volatile boolean Ecw;
  volatile CountDownLatch Ecx;
  private volatile s Ecy;
  public com.tencent.mm.plugin.fts.a.a.a tGb;
  private com.tencent.mm.plugin.fts.a.l xfN;
  
  static
  {
    AppMethodBeat.i(77974);
    Ecr = com.tencent.mm.ui.d.fzf() + 500;
    AppMethodBeat.o(77974);
  }
  
  public i()
  {
    AppMethodBeat.i(77960);
    this.Ecs = new aq("WebSearchLogic_worker");
    this.EcJ = 0;
    this.EcL = new HashMap();
    this.EcB = new i.1(this);
    this.EcN = new i.2(this);
    this.EcO = new com.tencent.mm.plugin.websearch.a.a.b();
    this.EcP = new a((byte)0);
    this.EcQ = new i.b(this, (byte)0);
    this.xfN = new i.6(this);
    ae.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.EcB.alive();
    this.EcN.alive();
    this.Ect = new HashSet();
    this.Ect.add("netType");
    this.Ect.add("currentPage");
    this.Ect.add("requestId");
    this.Ect.add("parentSearchID");
    eRQ();
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramm.tEY);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.ahd(paramm.tEY);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.tEX)
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
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tFh = com.tencent.mm.plugin.fts.a.a.e.a.tFq;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tFm = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).tFn = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).tFv.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.tFh = com.tencent.mm.plugin.fts.a.a.e.a.tFq;
            paramh.tFm = "<em class=\"highlight\">";
            paramh.tFn = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).tFv.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.ahd(paramm.tEY));
              ((JSONObject)localObject1).put("userName", paramm.tEY);
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
      localObject2 = ak.getContext().getString(2131762930);
      i = 1;
      j = 0;
      break;
      localObject1 = ((aw)localObject4).eRo;
      localObject2 = ak.getContext().getString(2131762925);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((an)localObject4).VI();
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = ((aw)localObject4).field_username;
      }
      localObject2 = ak.getContext().getString(2131762935);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paramm.content;
      if (!bu.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label500:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramh.tFC)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = ak.getContext().getString(2131762929);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label500;
        localObject1 = paramm.content;
        localObject2 = ak.getContext().getString(2131762931);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramm.content;
        localObject2 = ak.getContext().getString(2131762924);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().ali(((aw)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.tFE;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.alm(str).contains(localCharSequence))
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
          localObject2 = ak.getContext().getString(2131762934);
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
    this.Ecs.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197992);
        if (i.b(i.this) != null) {
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for countdown, %d", new Object[] { Long.valueOf(i.b(i.this).getCount()) });
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
            int j = i.c(i.this).dDY;
            i = j;
            if (!i.c(i.this).DTn) {
              break;
            }
            i = j;
            if (!i.d(i.this)) {
              break;
            }
            ae.w("MicroMsg.WebSearch.WebSearchLogic", "ingore pre get data");
            AppMethodBeat.o(197992);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localInterruptedException, "", new Object[0]);
            continue;
          }
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "count down latch null");
        }
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramString2, i.c(i.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(i).a(paramString1, paramBoolean, paramString2, paramBundle);
        AppMethodBeat.o(197992);
      }
    });
    AppMethodBeat.o(77969);
  }
  
  private s bA(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
    s locals = new s();
    locals.dmf = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
    locals.scene = i;
    locals.DSY = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "sugId");
    locals.DTa = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "sugType", 0);
    locals.DSZ = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "prefixSug");
    locals.DTl = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "poiInfo");
    if (com.tencent.mm.plugin.websearch.api.ad.B(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new aaj();
            ((aaj)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((aaj)localObject6).GrE = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((aaj)localObject6).GrF = ((JSONObject)localObject5).optString("textValue", "");
            locals.DTg.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "matchUser");
    if (!bu.isNullOrNil((String)localObject2)) {}
    Object localObject4;
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new duv();
      ((duv)localObject5).nIJ = ((JSONObject)localObject2).optString("userName");
      ((duv)localObject5).IaI = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((duv)localObject5).nIJ)) {
        locals.DSX.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          locals.DTb.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new cds();
            ((cds)localObject6).HqG = ((JSONObject)localObject5).optLong("from");
            ((cds)localObject6).HqH = ((JSONObject)localObject5).optLong("to");
            ((cds)localObject6).HqF = ((JSONObject)localObject5).optInt("field");
            locals.DTh.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.dDY = bu.m(paramMap.get("webview_instance_id"), -1);
        locals.language = com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext());
        locals.tEX = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
        locals.DTi = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0);
        if (locals.DTi == 1)
        {
          locals.DTj = new ejs();
          locals.DTj.FXW = com.tencent.mm.plugin.websearch.api.ad.WL(3);
          locals.DTj.ImD = com.tencent.mm.modelappbrand.b.hNh;
          locals.DTj.HqA = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
          locals.DTj.session_id = com.tencent.mm.modelappbrand.b.hNg;
          locals.DTj.ImE = locals.DTd;
          localObject4 = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISk, null);
          if ((localObject4 != null) && ((localObject4 instanceof String))) {
            locals.DTj.HDz = ((String)localObject4);
          }
        }
        if (this.EcJ != 1) {
          break label1299;
        }
      }
      locals.DTk = this.DTk;
    }
    for (;;)
    {
      localObject4 = locals.dmf;
      com.tencent.mm.plugin.webview.fts.b.a.a.eRU();
      localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.aHW((String)localObject4);
      if (localObject4 == null)
      {
        localObject4 = "";
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          locals.dmf = ((String)localObject4);
          locals.DTk = this.DTk;
        }
        if ((locals.scene == 33) && (this.EcK != null))
        {
          if (locals.DTk == null) {
            locals.DTk = new ege();
          }
          if (locals.DTk.IjS == null) {
            locals.DTk.IjS = new pt();
          }
          if (this.EcK.IjS != null)
          {
            locals.DTk.IjS.Gds = this.EcK.IjS.Gds;
            ae.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.EcK.IjS.Gds });
          }
          this.EcK = null;
        }
        if ((locals.businessType == 262144) && (this.EcK != null) && (this.EcK.IjS.Gdp == 1))
        {
          localObject4 = new Bundle();
          ((Bundle)localObject4).putInt("isRefresh", 1);
          ((Bundle)localObject4).putString("widgetId", com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "widgetId"));
          locals.yzF = ((Bundle)localObject4);
          locals.DTk = this.EcK;
          this.EcK = null;
        }
        paramMap = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "specialSearch");
        if (bu.isNullOrNil(paramMap)) {}
      }
      try
      {
        paramMap = new JSONObject(paramMap);
        locals.DTp = paramMap.optInt("type", 0);
        locals.dmw = paramMap.optJSONObject("params").optString("reqKey");
        label1290:
        AppMethodBeat.o(77967);
        return locals;
        label1299:
        locals.DTk = null;
        continue;
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edj, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dwb, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edh, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edi });
        this.DTk = new ege();
        this.DTk.IjR = 1L;
        this.DTk.IjS = new pt();
        this.DTk.IjS.dwb = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dwb;
        this.DTk.IjS.Gdl = bu.aSB(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edh);
        this.DTk.IjS.prK = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edi;
        localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).Edj;
      }
      catch (Exception paramMap)
      {
        break label1290;
      }
    }
  }
  
  private boolean bd(LinkedList<aaj> paramLinkedList)
  {
    AppMethodBeat.i(77966);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((aaj)paramLinkedList.next()).key);
    }
    boolean bool = this.Ect.equals(localHashSet);
    AppMethodBeat.o(77966);
    return bool;
  }
  
  /* Error */
  private static Set<String> bz(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 869
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 533
    //   10: invokestatic 441	com/tencent/mm/plugin/websearch/api/ad:A	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 299	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifne +94 -> 112
    //   21: new 141	java/util/HashSet
    //   24: dup
    //   25: invokespecial 142	java/util/HashSet:<init>	()V
    //   28: astore_2
    //   29: new 535	org/json/JSONArray
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 536	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload_1
    //   43: aload_3
    //   44: invokevirtual 537	org/json/JSONArray:length	()I
    //   47: if_icmpge +57 -> 104
    //   50: aload_3
    //   51: iload_1
    //   52: invokevirtual 541	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore_0
    //   56: new 543	com/tencent/mm/protocal/protobuf/aaj
    //   59: dup
    //   60: invokespecial 544	com/tencent/mm/protocal/protobuf/aaj:<init>	()V
    //   63: pop
    //   64: aload_2
    //   65: aload_0
    //   66: ldc_w 546
    //   69: ldc_w 387
    //   72: invokevirtual 550	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   101: invokestatic 579	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: ldc_w 869
    //   107: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: invokestatic 875	java/util/Collections:emptySet	()Ljava/util/Set;
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
  
  private boolean q(Set<String> paramSet)
  {
    AppMethodBeat.i(77962);
    if ((paramSet == null) || (this.Ect.containsAll(paramSet)))
    {
      AppMethodBeat.o(77962);
      return true;
    }
    AppMethodBeat.o(77962);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197995);
    ae.i("MicroMsg.WebSearch.WebSearchLogic", "preGetSearchData");
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
      paramString6.put("textValue", com.tencent.mm.plugin.websearch.api.ad.UD());
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
      paramString1 = bA(localHashMap);
      if (paramInt3 == 1) {
        paramString1.DTp = 1;
      }
      paramString1.DTn = true;
      if (!bd(paramString1.DTg))
      {
        paramString1 = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.o(197995);
        throw paramString1;
      }
    }
    catch (JSONException paramString5)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.EcP.b(paramString1);
      AppMethodBeat.o(197995);
    }
    return false;
  }
  
  public final boolean bB(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    ae.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new s();
    ((s)localObject).dmf = com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "query");
    try
    {
      ((s)localObject).dmf = URLDecoder.decode(((s)localObject).dmf, "UTF-8");
      label59:
      ((s)localObject).businessType = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "type", 0);
      ((s)localObject).scene = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "scene", 0);
      int i;
      if (com.tencent.mm.plugin.websearch.api.ad.B(paramMap, "isHomePage"))
      {
        i = 1;
        ((s)localObject).DSW = i;
        ((s)localObject).dDY = bu.m(paramMap.get("webview_instance_id"), -1);
        ((s)localObject).DTb.add(com.tencent.mm.plugin.websearch.api.ad.A(paramMap, "prefixQuery"));
        i = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "requestType", 0);
        ((s)localObject).tEX = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subtype", 0);
        ((s)localObject).DTi = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "isWeAppMore", 0);
        if (((s)localObject).DTi == 1)
        {
          ((s)localObject).DTj = new ejs();
          ((s)localObject).DTj.FXW = com.tencent.mm.plugin.websearch.api.ad.WL(3);
          ((s)localObject).DTj.ImD = com.tencent.mm.modelappbrand.b.hNh;
          ((s)localObject).DTj.HqA = com.tencent.mm.plugin.websearch.api.ad.b(paramMap, "subType", 0);
          ((s)localObject).DTj.session_id = com.tencent.mm.modelappbrand.b.hNg;
          paramMap = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISk, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((s)localObject).DTj.HDz = ((String)paramMap);
          }
        }
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((s)localObject).dDY) });
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
          paramMap = this.EcQ;
          if (paramMap.EcX != null)
          {
            com.tencent.mm.kernel.g.ajj().b(paramMap.EcX.getType(), paramMap.EcR);
            com.tencent.mm.kernel.g.ajj().a(paramMap.EcX);
            paramMap.EcX = null;
          }
          if (paramMap.EcX == null)
          {
            paramMap.EcX = new g((s)localObject);
            com.tencent.mm.kernel.g.ajj().a(paramMap.EcX.getType(), paramMap.EcR);
            com.tencent.mm.kernel.g.ajj().a(paramMap.EcX, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(((s)localObject).dDY).aIf(ag.ePU());
          }
        }
        str = ((s)localObject).dmf;
        i = ((s)localObject).businessType;
        j = ((s)localObject).dDY;
      } while (bu.isNullOrNil(str));
      if (this.tGb != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.tGb);
        this.tGb = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).jUf = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFV = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFX = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFZ = com.tencent.mm.plugin.fts.a.c.b.tGz;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tFY = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).tGa = this.xfN;
        this.tGb = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.tGb.tET = Integer.valueOf(j);
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
  
  public final boolean by(Map<String, Object> paramMap)
  {
    int j = 1;
    AppMethodBeat.i(77961);
    ae.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
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
        ae.e("MicroMsg.WebSearch.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.Ecw = true;
        if (this.Ecx != null) {
          this.Ecx.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      ae.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for pre getdata back");
      AppMethodBeat.o(77961);
      return false;
      if (this.Ecx != null) {
        this.Ecx.countDown();
      }
      i = j;
      if (this.Ecy != null)
      {
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.Ecy.dDY), this.Ecy });
        i = j;
        continue;
        if (this.Ecx != null) {
          this.Ecx.countDown();
        }
        i = 0;
      }
    }
    paramMap = bA(paramMap);
    this.EcP.b(paramMap);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final void eRQ()
  {
    AppMethodBeat.i(77972);
    String str = com.tencent.mm.plugin.websearch.api.ad.WO(0);
    ae.i("MicroMsg.WebSearch.WebSearchLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.EcA = true;
      AppMethodBeat.o(77972);
      return;
    }
    this.EcA = q(new HashSet(Arrays.asList(str.split(","))));
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
      ae.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramn instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.ajj().b(paramn.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramn;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.cVp() });
          paramn = new JSONObject();
        }
      }
      try
      {
        paramn.put("ret", -1);
        label128:
        paramn = paramn.toString();
        a(paramString.ePt(), paramn, paramString.ePu(), paramString.ePy(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramn = paramString.ePw();
        paramInt1 = paramString.ePx();
        ae.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.cVp() });
        a(paramString.ePt(), paramn, paramString.ePu(), paramString.ePy(), paramString.ePv());
        if (paramInt1 > 0)
        {
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.j.a.a.b.fes();
          com.tencent.mm.pluginsdk.j.a.a.b.Zd(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramn instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.ajj().b(paramn.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramn;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            ae.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(paramString.ePt()).aIf("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramn = paramString.ePw();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(paramString.ePt()).aIf(paramn);
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
    public com.tencent.mm.plugin.websearch.api.a EcG;
    public a EcV;
    private ThreadPoolExecutor deK;
    
    private a()
    {
      AppMethodBeat.i(77957);
      this.deK = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(s params)
    {
      AppMethodBeat.i(77958);
      if (this.EcV != null) {
        this.EcV.stopped = true;
      }
      this.EcV = new a((byte)0);
      this.EcV.DTs = params;
      i.a(i.this, params);
      this.deK.execute(this.EcV);
      AppMethodBeat.o(77958);
    }
    
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
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if ((bu.isNullOrNil(this.DTs.dmf)) && (this.DTs.DTp != 2))
        {
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.DTs.businessType), Integer.valueOf(this.DTs.scene), Integer.valueOf(this.DTs.DSW), Integer.valueOf(this.DTs.dEf), this.DTs.pSq, Integer.valueOf(this.DTs.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.DTs.scene)
        {
        }
        for (;;)
        {
          ae.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.DTs.dmf, Integer.valueOf(this.DTs.dDY) });
          if (i.a.a(i.a.this) != null) {
            com.tencent.mm.kernel.g.ajj().a(i.a.a(i.a.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.DTs.DSX != null)
          {
            localObject = localLinkedList;
            if (!this.DTs.DSX.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (i.aC(this.DTs.dmf, this.DTs.scene, this.DTs.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.a.a.e)i.a(i.this).aHr(this.DTs.dmf);
              l = System.currentTimeMillis() - l;
              ae.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.g.yxI.f(14717, new Object[] { this.DTs.dmf, Integer.valueOf(x.aBE()), Integer.valueOf(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lPc.size()), Long.valueOf(l), Integer.valueOf(this.DTs.scene) });
            }
          }
          if (this.stopped)
          {
            ae.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.DTs.dmf);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label489:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.DTs.dmf + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.eUD().EbT.t(this.DTs.scene, this.DTs.dmf, this.DTs.businessType);
            i.a.a(i.a.this, i.a.c(this.DTs));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.a.a.e)localObject).lPc).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.a.a.e.a locala = (com.tencent.mm.plugin.websearch.a.a.e.a)((Iterator)localObject).next();
                duv localduv = new duv();
                localduv.nIJ = locala.userName;
                localduv.IaI = locala.DVh;
                localduv.nJO = locala.bVF;
                localduv.Gtk = locala.iWF;
                localduv.jga = locala.fhy;
                localduv.FNF = locala.desc;
                localLinkedList.add(localduv);
              }
              i.a.a(i.a.this).bc(localLinkedList);
            }
            com.tencent.mm.kernel.g.ajj().a(i.a.a(i.a.this).getType(), i.this);
            com.tencent.mm.kernel.g.ajj().a(i.a.a(i.a.this), 0);
            ae.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(i.a.a(i.a.this).getType()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.i
 * JD-Core Version:    0.7.0.1
 */