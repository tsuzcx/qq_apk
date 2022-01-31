package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.id;
import com.tencent.mm.h.a.id.a;
import com.tencent.mm.h.a.nc;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.c.a.e.a;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.bww;
import com.tencent.mm.protocal.c.ccd;
import com.tencent.mm.protocal.c.ckt;
import com.tencent.mm.protocal.c.cmx;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  implements com.tencent.mm.ah.f
{
  static final long qZw = com.tencent.mm.ui.d.cxX() + 500;
  private ai bjo = new ai("WebSearchLogic_worker");
  public com.tencent.mm.plugin.fts.a.a.a kxg;
  private com.tencent.mm.plugin.fts.a.l mVF = new g.5(this);
  public ckt qTK;
  volatile boolean qZA;
  volatile CountDownLatch qZB;
  private volatile com.tencent.mm.plugin.websearch.api.s qZC;
  volatile boolean qZE;
  public com.tencent.mm.sdk.b.c qZF = new com.tencent.mm.sdk.b.c() {};
  public int qZN = 0;
  public ckt qZO;
  long qZP;
  public com.tencent.mm.sdk.b.c qZQ = new g.2(this);
  private com.tencent.mm.plugin.websearch.c.a.c qZR = new com.tencent.mm.plugin.websearch.c.a.b();
  public g.a qZS = new g.a(this, (byte)0);
  public g.b qZT = new g.b(this, (byte)0);
  private Set<String> qZx;
  volatile boolean qZz;
  
  public g()
  {
    y.d("MicroMsg.FTS.WebSearchLogic", "create WebSearchLogic");
    this.qZF.cqo();
    this.qZQ.cqo();
    this.qZx = new HashSet();
    this.qZx.add("netType");
    this.qZx.add("currentPage");
    this.qZx.add("requestId");
    this.qZx.add("parentSearchID");
    caD();
  }
  
  public static final JSONObject a(com.tencent.mm.plugin.fts.a.a.l paraml, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paraml.kwg);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.Cy(paraml.kwg);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paraml.kwf)
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
        label260:
        if (j != 0)
        {
          localObject3 = com.tencent.mm.plugin.fts.a.a.d.a((CharSequence)localObject3, paramg, bool1, bool2);
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).kwl = d.a.kwu;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).kwq = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).kwr = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.d)localObject3).kwz.toString();
          label193:
          if (i != 0)
          {
            paramg = com.tencent.mm.plugin.fts.a.a.d.a((CharSequence)localObject1, paramg, bool1, bool2);
            paramg.kwl = d.a.kwu;
            paramg.kwq = "<em class=\"highlight\">";
            paramg.kwr = "</em>";
            paramg = com.tencent.mm.plugin.fts.a.f.a(paramg).kwz.toString();
            paramg = (String)localObject2 + paramg;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.Cy(paraml.kwg));
              ((JSONObject)localObject1).put("userName", paraml.kwg);
              if (j != 0) {
                ((JSONObject)localObject1).put("nickNameHighlight", localObject3);
              }
              if (i != 0) {
                ((JSONObject)localObject1).put("extraHighlight", paramg);
              }
              return localObject1;
            }
            catch (JSONException paraml)
            {
              label329:
              label332:
              return localObject1;
            }
            bool2 = true;
            bool1 = true;
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
    label348:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((ao)localObject4).field_nickname;
      localObject2 = ae.getContext().getString(R.l.search_contact_tag_nickname);
      i = 1;
      j = 0;
      break;
      localObject1 = ((ao)localObject4).cCJ;
      localObject2 = ae.getContext().getString(R.l.search_contact_tag_description);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((ad)localObject4).vk();
      localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = ((ao)localObject4).field_username;
      }
      localObject2 = ae.getContext().getString(R.l.search_contact_tag_wxid);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paraml.content;
      if (!bk.bl((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label487:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramg.kwG)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = ae.getContext().getString(R.l.search_contact_tag_mobile);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label487;
        localObject1 = paraml.content;
        localObject2 = ae.getContext().getString(R.l.search_contact_tag_province);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paraml.content;
        localObject2 = ae.getContext().getString(R.l.search_contact_tag_city);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB().DN(((ao)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramg.kwI;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.DR(str).contains(localCharSequence))
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
          localObject2 = ae.getContext().getString(R.l.search_contact_tag_tag);
          bool2 = false;
          bool1 = false;
          i = 1;
          j = 0;
          break;
        }
        paramg = (com.tencent.mm.plugin.fts.a.a.g)localObject1;
        break label260;
        break label193;
      }
      bool2 = false;
      break label329;
      bool2 = false;
      bool1 = false;
      break label332;
      bool2 = false;
      break label348;
      bool2 = false;
    }
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    this.bjo.O(new g.4(this, paramInt, paramString2, paramString1, paramBoolean, paramBundle));
  }
  
  /* Error */
  private static Set<String> aj(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 421
    //   4: invokestatic 425	com/tencent/mm/plugin/websearch/api/aa:s	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 286	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   12: ifne +90 -> 102
    //   15: new 120	java/util/HashSet
    //   18: dup
    //   19: invokespecial 121	java/util/HashSet:<init>	()V
    //   22: astore_0
    //   23: new 427	org/json/JSONArray
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 428	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: astore_2
    //   36: iload_1
    //   37: aload_3
    //   38: invokevirtual 429	org/json/JSONArray:length	()I
    //   41: if_icmpge +59 -> 100
    //   44: aload_3
    //   45: iload_1
    //   46: invokevirtual 433	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   49: astore_2
    //   50: new 435	com/tencent/mm/protocal/c/rb
    //   53: dup
    //   54: invokespecial 436	com/tencent/mm/protocal/c/rb:<init>	()V
    //   57: pop
    //   58: aload_0
    //   59: aload_2
    //   60: ldc_w 438
    //   63: ldc_w 382
    //   66: invokevirtual 442	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: invokeinterface 131 2 0
    //   74: pop
    //   75: iload_1
    //   76: iconst_1
    //   77: iadd
    //   78: istore_1
    //   79: goto -45 -> 34
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_0
    //   85: ldc 104
    //   87: aload_2
    //   88: ldc_w 382
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 446	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload_0
    //   99: astore_2
    //   100: aload_2
    //   101: areturn
    //   102: invokestatic 452	java/util/Collections:emptySet	()Ljava/util/Set;
    //   105: areturn
    //   106: astore_2
    //   107: goto -22 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramMap	Map<String, Object>
    //   33	46	1	i	int
    //   7	53	2	localObject	Object
    //   82	6	2	localException1	Exception
    //   99	2	2	localMap	Map<String, Object>
    //   106	1	2	localException2	Exception
    //   31	14	3	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   15	23	82	java/lang/Exception
    //   23	32	106	java/lang/Exception
    //   36	75	106	java/lang/Exception
  }
  
  private com.tencent.mm.plugin.websearch.api.s ak(Map<String, Object> paramMap)
  {
    int i = aa.c(paramMap, "scene", 0);
    com.tencent.mm.plugin.websearch.api.s locals = new com.tencent.mm.plugin.websearch.api.s();
    locals.bGm = aa.s(paramMap, "query");
    locals.offset = aa.c(paramMap, "offset", 0);
    locals.businessType = aa.c(paramMap, "type", 0);
    locals.scene = i;
    locals.qTy = aa.s(paramMap, "sugId");
    locals.qTA = aa.c(paramMap, "sugType", 0);
    locals.qTz = aa.s(paramMap, "prefixSug");
    locals.qTL = aa.s(paramMap, "poiInfo");
    if (aa.t(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new rb();
            ((rb)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((rb)localObject6).sOI = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((rb)localObject6).sOJ = ((JSONObject)localObject5).optString("textValue", "");
            locals.qTG.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = aa.s(paramMap, "matchUser");
    if (!bk.bl((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new ccd();
      ((ccd)localObject5).hPY = ((JSONObject)localObject2).optString("userName");
      ((ccd)localObject5).tRz = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((ccd)localObject5).hPY)) {
        locals.qTx.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          locals.qTB.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new azi();
            ((azi)localObject6).tvz = ((JSONObject)localObject5).optLong("from");
            ((azi)localObject6).tvA = ((JSONObject)localObject5).optLong("to");
            ((azi)localObject6).tvy = ((JSONObject)localObject5).optInt("field");
            locals.qTH.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.bVm = bk.e(paramMap.get("webview_instance_id"), -1);
        locals.auI = x.fB(ae.getContext());
        locals.kwf = aa.c(paramMap, "subType", 0);
        if (com.tencent.mm.plugin.appbrand.u.r.aqr())
        {
          locals.qTI = aa.c(paramMap, "isWeAppMore", 0);
          if (locals.qTI == 1)
          {
            locals.qTJ = new cmx();
            localObject4 = new id();
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
            locals.qTJ.tZx = ((id)localObject4).bQn.bQo;
            locals.qTJ.tZz = com.tencent.mm.modelappbrand.b.dZM;
            locals.qTJ.tZy = aa.c(paramMap, "subType", 0);
            locals.qTJ.session_id = com.tencent.mm.modelappbrand.b.dZL;
            locals.qTJ.tZA = locals.qTD;
            au.Hx();
            localObject4 = com.tencent.mm.model.c.Dz().get(ac.a.uuP, null);
            if ((localObject4 != null) && ((localObject4 instanceof String))) {
              locals.qTJ.tYI = ((String)localObject4);
            }
          }
        }
        if (this.qZN != 1) {
          break label1257;
        }
      }
      locals.qTK = this.qTK;
    }
    Object localObject4 = locals.bGm;
    com.tencent.mm.plugin.webview.fts.b.a.a.caH();
    localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.RI((String)localObject4);
    if (localObject4 == null) {}
    for (localObject4 = "";; localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ran)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        locals.bGm = ((String)localObject4);
        locals.qTK = this.qTK;
      }
      if ((locals.scene == 33) && (this.qZO != null))
      {
        if (locals.qTK == null) {
          locals.qTK = new ckt();
        }
        if (locals.qTK.tYb == null) {
          locals.qTK.tYb = new jr();
        }
        if (this.qZO.tYb != null)
        {
          locals.qTK.tYb.sEy = this.qZO.tYb.sEy;
          y.i("MicroMsg.FTS.WebSearchLogic", "websearch from url [%s]", new Object[] { this.qZO.tYb.sEy });
        }
        this.qZO = null;
      }
      if ((locals.businessType == 262144) && (this.qZO != null) && (this.qZO.tYb.sEv == 1))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("isRefresh", 1);
        ((Bundle)localObject4).putString("widgetId", aa.s(paramMap, "widgetId"));
        locals.qTN = ((Bundle)localObject4);
        locals.qTK = this.qZO;
        this.qZO = null;
      }
      return locals;
      label1257:
      locals.qTK = null;
      break;
      y.i("MicroMsg.FTS.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ran, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).bOL, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ral, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ram });
      this.qTK = new ckt();
      this.qTK.tYa = 1L;
      this.qTK.tYb = new jr();
      this.qTK.tYb.bOL = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).bOL;
      this.qTK.tYb.sEr = bk.ZR(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ral);
      this.qTK.tYb.iQN = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).ram;
    }
  }
  
  private boolean as(LinkedList<rb> paramLinkedList)
  {
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((rb)paramLinkedList.next()).key);
    }
    return this.qZx.equals(localHashSet);
  }
  
  private boolean i(Set<String> paramSet)
  {
    return (paramSet == null) || (this.qZx.containsAll(paramSet));
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
  {
    y.i("MicroMsg.FTS.WebSearchLogic", "preGetSearchData");
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
      paramString6.put("textValue", aa.boM());
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
      paramString1 = ak(localHashMap);
      paramString1.qTO = true;
      if (!as(paramString1.qTG)) {
        throw new IllegalStateException("pre get data must use same commKvSets with hardcode set");
      }
    }
    catch (JSONException paramString5)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.qZS.b(paramString1);
    }
    return false;
  }
  
  public final boolean ai(Map<String, Object> paramMap)
  {
    int j = 1;
    y.i("MicroMsg.FTS.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(bk.e(paramMap.get("webview_instance_id"), -1)).c(aa.c(paramMap, "type", 0), aa.s(paramMap, "query"), paramMap);
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
        y.e("MicroMsg.FTS.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.qZA = true;
        if (this.qZB != null) {
          this.qZB.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      y.i("MicroMsg.FTS.WebSearchLogic", "waiting for pre getdata back");
      return false;
      if (this.qZB != null) {
        this.qZB.countDown();
      }
      i = j;
      if (this.qZC != null)
      {
        y.i("MicroMsg.FTS.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.qZC.bVm), this.qZC });
        i = j;
        continue;
        if (this.qZB != null) {
          this.qZB.countDown();
        }
        i = 0;
      }
    }
    paramMap = ak(paramMap);
    this.qZS.b(paramMap);
    return false;
  }
  
  public final boolean al(Map<String, Object> paramMap)
  {
    y.i("MicroMsg.FTS.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject1 = new com.tencent.mm.plugin.websearch.api.s();
    ((com.tencent.mm.plugin.websearch.api.s)localObject1).bGm = aa.s(paramMap, "query");
    try
    {
      ((com.tencent.mm.plugin.websearch.api.s)localObject1).bGm = URLDecoder.decode(((com.tencent.mm.plugin.websearch.api.s)localObject1).bGm, "UTF-8");
      label53:
      ((com.tencent.mm.plugin.websearch.api.s)localObject1).businessType = aa.c(paramMap, "type", 0);
      ((com.tencent.mm.plugin.websearch.api.s)localObject1).scene = aa.c(paramMap, "scene", 0);
      int i;
      Object localObject2;
      if (aa.t(paramMap, "isHomePage"))
      {
        i = 1;
        ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTw = i;
        ((com.tencent.mm.plugin.websearch.api.s)localObject1).bVm = bk.e(paramMap.get("webview_instance_id"), -1);
        ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTB.add(aa.s(paramMap, "prefixQuery"));
        i = aa.c(paramMap, "requestType", 0);
        ((com.tencent.mm.plugin.websearch.api.s)localObject1).kwf = aa.c(paramMap, "subtype", 0);
        y.i("MicroMsg.FTS.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.websearch.api.s)localObject1).bVm) });
        if (com.tencent.mm.plugin.appbrand.u.r.aqr())
        {
          ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTI = aa.c(paramMap, "isWeAppMore", 0);
          if (((com.tencent.mm.plugin.websearch.api.s)localObject1).qTI == 1)
          {
            ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ = new cmx();
            localObject2 = new id();
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
            ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ.tZx = ((id)localObject2).bQn.bQo;
            ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ.tZz = com.tencent.mm.modelappbrand.b.dZM;
            ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ.tZy = aa.c(paramMap, "subType", 0);
            ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ.session_id = com.tencent.mm.modelappbrand.b.dZL;
            au.Hx();
            paramMap = com.tencent.mm.model.c.Dz().get(ac.a.uuP, null);
            if ((paramMap != null) && ((paramMap instanceof String))) {
              ((com.tencent.mm.plugin.websearch.api.s)localObject1).qTJ.tYI = ((String)paramMap);
            }
          }
        }
        switch (i)
        {
        }
      }
      int j;
      do
      {
        do
        {
          return false;
          i = 0;
          break;
          localObject2 = this.qZT;
          if (((g.b)localObject2).raa != null)
          {
            au.Dk().b(((g.b)localObject2).raa.getType(), ((g.b)localObject2).qZU);
            au.Dk().c(((g.b)localObject2).raa);
            ((g.b)localObject2).raa = null;
          }
        } while (((g.b)localObject2).raa != null);
        if (!com.tencent.mm.plugin.appbrand.u.r.aqr()) {
          if (BR(((com.tencent.mm.plugin.websearch.api.s)localObject1).scene)) {
            paramMap = new com.tencent.mm.modelappbrand.r(((com.tencent.mm.plugin.websearch.api.s)localObject1).bGm, ((com.tencent.mm.plugin.websearch.api.s)localObject1).scene, ((com.tencent.mm.plugin.websearch.api.s)localObject1).bVm);
          }
        }
        for (;;)
        {
          ((g.b)localObject2).raa = paramMap;
          au.Dk().a(((g.b)localObject2).raa.getType(), ((g.b)localObject2).qZU);
          au.Dk().a(((g.b)localObject2).raa, 0);
          return false;
          paramMap = new e((com.tencent.mm.plugin.websearch.api.s)localObject1);
          continue;
          paramMap = new e((com.tencent.mm.plugin.websearch.api.s)localObject1);
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(((com.tencent.mm.plugin.websearch.api.s)localObject1).bVm).TP(af.bZC());
        return false;
        localObject2 = ((com.tencent.mm.plugin.websearch.api.s)localObject1).bGm;
        i = ((com.tencent.mm.plugin.websearch.api.s)localObject1).businessType;
        j = ((com.tencent.mm.plugin.websearch.api.s)localObject1).bVm;
      } while (bk.bl((String)localObject2));
      if (this.kxg != null)
      {
        ((n)com.tencent.mm.kernel.g.t(n.class)).cancelSearchTask(this.kxg);
        this.kxg = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject1 = new i();
        ((i)localObject1).kwX = 16;
        ((i)localObject1).bVk = ((String)localObject2);
        ((i)localObject1).kxa = paramMap;
        ((i)localObject1).kxc = 5;
        ((i)localObject1).kxe = com.tencent.mm.plugin.fts.a.c.b.kxE;
        ((i)localObject1).kxd = new HashSet();
        ((i)localObject1).kxf = this.mVF;
        this.kxg = ((n)com.tencent.mm.kernel.g.t(n.class)).search(2, (i)localObject1);
        this.kxg.kwb = Integer.valueOf(j);
        return false;
        paramMap = new int[1];
        paramMap[0] = 131072;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label53;
    }
  }
  
  public final void caD()
  {
    String str = aa.BB(0);
    y.i("MicroMsg.FTS.WebSearchLogic", "config commKV %s", new Object[] { str });
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
      y.v("MicroMsg.FTS.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramm instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        au.Dk().b(paramm.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", new Object[] { paramString.qTu });
          paramm = new JSONObject();
        }
      }
      try
      {
        paramm.put("ret", -1);
        label122:
        paramm = paramm.toString();
        a(paramString.qTt, paramm, paramString.bZj(), paramString.bVq, null);
        do
        {
          do
          {
            return;
            i = 0;
            break;
            paramm = paramString.Jv();
            paramInt1 = paramString.Jw();
            y.i("MicroMsg.FTS.WebSearchLogic", "callback %s", new Object[] { paramString.qTu });
            a(paramString.qTt, paramm, paramString.bZj(), paramString.bVq, paramString.qTv);
          } while (paramInt1 <= 0);
          y.i("MicroMsg.FTS.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.c.clv();
          com.tencent.mm.pluginsdk.g.a.a.b.DL(27);
          return;
        } while (!(paramm instanceof com.tencent.mm.plugin.websearch.api.b));
        au.Dk().b(paramm.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.b)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          y.i("MicroMsg.FTS.WebSearchLogic", "net scene fail %s", new Object[] { paramString.Db });
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramString.qTt).TP("{}");
          return;
        }
        paramm = paramString.Jv();
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(paramString.qTt).TP(paramm);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label122;
      }
    }
  }
  
  private final class a$a
    implements Runnable
  {
    com.tencent.mm.plugin.websearch.api.s dZR;
    public volatile boolean hMo;
    
    private a$a() {}
    
    public final void run()
    {
      if (Thread.interrupted()) {
        return;
      }
      if (bk.bl(this.dZR.bGm))
      {
        y.i("MicroMsg.FTS.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.dZR.businessType), Integer.valueOf(this.dZR.scene), Integer.valueOf(this.dZR.qTw), Integer.valueOf(this.dZR.bVt), this.dZR.jfE, Integer.valueOf(this.dZR.offset) });
        return;
      }
      switch (this.dZR.scene)
      {
      }
      LinkedList localLinkedList;
      Object localObject;
      for (;;)
      {
        y.i("MicroMsg.FTS.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.dZR.bGm, Integer.valueOf(this.dZR.bVm) });
        if (g.a.a(g.this) != null) {
          au.Dk().c(g.a.a(g.this));
        }
        localLinkedList = null;
        if (this.dZR.qTx != null)
        {
          localObject = localLinkedList;
          if (!this.dZR.qTx.isEmpty()) {}
        }
        else
        {
          localObject = localLinkedList;
          if (g.ae(this.dZR.bGm, this.dZR.scene, this.dZR.businessType))
          {
            long l = System.currentTimeMillis();
            localObject = (com.tencent.mm.plugin.websearch.c.a.e)g.a(g.this.qZU).RA(this.dZR.bGm);
            l = System.currentTimeMillis() - l;
            y.i("MicroMsg.FTS.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
            com.tencent.mm.plugin.report.service.h.nFQ.f(14717, new Object[] { this.dZR.bGm, Integer.valueOf(com.tencent.mm.model.s.Hb()), Integer.valueOf(((com.tencent.mm.plugin.websearch.c.a.e)localObject).kxO.size()), Long.valueOf(l), Integer.valueOf(this.dZR.scene) });
          }
        }
        if (!this.hMo) {
          break;
        }
        y.i("MicroMsg.FTS.WebSearchLogic", "was cancelled");
        return;
        ((n)com.tencent.mm.kernel.g.t(n.class)).addSOSHistory(this.dZR.bGm);
      }
      com.tencent.mm.plugin.webview.modeltools.g.ccI().qYX.j(this.dZR.scene, this.dZR.bGm, this.dZR.businessType);
      g.a.a(g.this, g.a.c(this.dZR));
      if (localObject != null)
      {
        localLinkedList = new LinkedList();
        localObject = ((com.tencent.mm.plugin.websearch.c.a.e)localObject).kxO.iterator();
        while (((Iterator)localObject).hasNext())
        {
          e.a locala = (e.a)((Iterator)localObject).next();
          ccd localccd = new ccd();
          localccd.hPY = locala.userName;
          localccd.tRz = locala.qWf;
          localccd.hRf = locala.aVr;
          localccd.sPt = locala.fGK;
          localccd.ffm = locala.cMT;
          localccd.sxZ = locala.desc;
          localLinkedList.add(localccd);
        }
        g.a.a(g.this).ar(localLinkedList);
      }
      au.Dk().a(g.a.a(g.this).getType(), g.this.qZU);
      au.Dk().a(g.a.a(g.this), 0);
      y.i("MicroMsg.FTS.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(g.a.a(g.this).getType()) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.g
 * JD-Core Version:    0.7.0.1
 */