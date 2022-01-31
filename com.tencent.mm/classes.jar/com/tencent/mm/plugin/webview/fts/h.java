package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.ih.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class h
  implements com.tencent.mm.ai.f
{
  static final long uPe;
  public com.tencent.mm.plugin.fts.a.a.a mSV;
  private com.tencent.mm.plugin.fts.a.l pym;
  private al rzq;
  public cyi uIS;
  private com.tencent.mm.plugin.websearch.c.a.c uPA;
  public h.a uPB;
  public b uPC;
  private Set<String> uPf;
  volatile boolean uPh;
  volatile boolean uPi;
  volatile CountDownLatch uPj;
  private volatile s uPk;
  volatile boolean uPm;
  public com.tencent.mm.sdk.b.c uPn;
  public int uPv;
  public cyi uPw;
  public Map<String, Integer> uPx;
  long uPy;
  public com.tencent.mm.sdk.b.c uPz;
  
  static
  {
    AppMethodBeat.i(5762);
    uPe = com.tencent.mm.ui.d.dAU() + 500;
    AppMethodBeat.o(5762);
  }
  
  public h()
  {
    AppMethodBeat.i(5747);
    this.rzq = new al("WebSearchLogic_worker");
    this.uPv = 0;
    this.uPx = new HashMap();
    this.uPn = new h.1(this);
    this.uPz = new h.2(this);
    this.uPA = new com.tencent.mm.plugin.websearch.c.a.b();
    this.uPB = new h.a(this, (byte)0);
    this.uPC = new b((byte)0);
    this.pym = new h.5(this);
    ab.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.uPn.alive();
    this.uPz.alive();
    this.uPf = new HashSet();
    this.uPf.add("netType");
    this.uPf.add("currentPage");
    this.uPf.add("requestId");
    this.uPf.add("parentSearchID");
    daC();
    AppMethodBeat.o(5747);
  }
  
  private static boolean JJ(int paramInt)
  {
    return paramInt == 201;
  }
  
  public static final JSONObject a(com.tencent.mm.plugin.fts.a.a.l paraml, com.tencent.mm.plugin.fts.a.a.g paramg)
  {
    AppMethodBeat.i(5758);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paraml.mRV);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.NA(paraml.mRV);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paraml.mRU)
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
          localObject3 = com.tencent.mm.plugin.fts.a.a.d.a((CharSequence)localObject3, paramg, bool1, bool2);
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).mSa = d.a.mSj;
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).mSf = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.d)localObject3).mSg = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.d)localObject3).mSp.toString();
          label197:
          if (i != 0)
          {
            paramg = com.tencent.mm.plugin.fts.a.a.d.a((CharSequence)localObject1, paramg, bool1, bool2);
            paramg.mSa = d.a.mSj;
            paramg.mSf = "<em class=\"highlight\">";
            paramg.mSg = "</em>";
            paramg = com.tencent.mm.plugin.fts.a.f.a(paramg).mSp.toString();
            paramg = (String)localObject2 + paramg;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.NA(paraml.mRV));
              ((JSONObject)localObject1).put("userName", paraml.mRV);
              if (j != 0) {
                ((JSONObject)localObject1).put("nickNameHighlight", localObject3);
              }
              if (i != 0) {
                ((JSONObject)localObject1).put("extraHighlight", paramg);
              }
            }
            catch (JSONException paraml)
            {
              label331:
              break label331;
            }
            AppMethodBeat.o(5758);
            return localObject1;
            bool2 = true;
            label343:
            bool1 = true;
            label346:
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
    label362:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((aq)localObject4).field_nickname;
      localObject2 = ah.getContext().getString(2131302992);
      i = 1;
      j = 0;
      break;
      localObject1 = ((aq)localObject4).dqT;
      localObject2 = ah.getContext().getString(2131302987);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((ad)localObject4).Hq();
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = ((aq)localObject4).field_username;
      }
      localObject2 = ah.getContext().getString(2131302996);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paraml.content;
      if (!bo.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label501:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramg.mSw)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = ah.getContext().getString(2131302991);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label501;
        localObject1 = paraml.content;
        localObject2 = ah.getContext().getString(2131302993);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paraml.content;
        localObject2 = ah.getContext().getString(2131302986);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSMainDB().OW(((aq)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramg.mSy;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.Pa(str).contains(localCharSequence))
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
          localObject2 = ah.getContext().getString(2131302995);
          bool2 = false;
          bool1 = false;
          i = 1;
          j = 0;
          break;
        }
        paramg = (com.tencent.mm.plugin.fts.a.a.g)localObject1;
        break label264;
        break label197;
      }
      bool2 = false;
      break label343;
      bool2 = false;
      bool1 = false;
      break label346;
      bool2 = false;
      break label362;
      bool2 = false;
    }
  }
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(5756);
    this.rzq.ac(new h.4(this, paramInt, paramString2, paramString1, paramBoolean, paramBundle));
    AppMethodBeat.o(5756);
  }
  
  private boolean aC(LinkedList<up> paramLinkedList)
  {
    AppMethodBeat.i(5753);
    HashSet localHashSet = new HashSet();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext()) {
      localHashSet.add(((up)paramLinkedList.next()).key);
    }
    boolean bool = this.uPf.equals(localHashSet);
    AppMethodBeat.o(5753);
    return bool;
  }
  
  /* Error */
  private static Set<String> aF(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: sipush 5750
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 424
    //   10: invokestatic 430	com/tencent/mm/plugin/websearch/api/aa:t	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 300	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   18: ifne +94 -> 112
    //   21: new 135	java/util/HashSet
    //   24: dup
    //   25: invokespecial 136	java/util/HashSet:<init>	()V
    //   28: astore_2
    //   29: new 432	org/json/JSONArray
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 433	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_2
    //   41: astore_0
    //   42: iload_1
    //   43: aload_3
    //   44: invokevirtual 434	org/json/JSONArray:length	()I
    //   47: if_icmpge +57 -> 104
    //   50: aload_3
    //   51: iload_1
    //   52: invokevirtual 438	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore_0
    //   56: new 410	com/tencent/mm/protocal/protobuf/up
    //   59: dup
    //   60: invokespecial 439	com/tencent/mm/protocal/protobuf/up:<init>	()V
    //   63: pop
    //   64: aload_2
    //   65: aload_0
    //   66: ldc_w 440
    //   69: ldc_w 388
    //   72: invokevirtual 444	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokeinterface 146 2 0
    //   80: pop
    //   81: iload_1
    //   82: iconst_1
    //   83: iadd
    //   84: istore_1
    //   85: goto -45 -> 40
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: ldc 119
    //   93: aload_2
    //   94: ldc_w 388
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 448	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: sipush 5750
    //   107: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: areturn
    //   112: invokestatic 454	java/util/Collections:emptySet	()Ljava/util/Set;
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
  
  private s aG(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5754);
    int i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
    s locals = new s();
    locals.cnv = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    locals.offset = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "offset", 0);
    locals.businessType = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
    locals.scene = i;
    locals.uIG = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "sugId");
    locals.uII = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "sugType", 0);
    locals.uIH = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "prefixSug");
    locals.uIT = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "poiInfo");
    if (com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isHomePage")) {
      i = 1;
    }
    Object localObject5;
    Object localObject6;
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
            localObject5 = ((JSONArray)localObject1).getJSONObject(i);
            localObject6 = new up();
            ((up)localObject6).key = ((JSONObject)localObject5).optString("key", "");
            ((up)localObject6).wMM = ((JSONObject)localObject5).optInt("uintValue", 0);
            ((up)localObject6).wMN = ((JSONObject)localObject5).optString("textValue", "");
            locals.uIO.add(localObject6);
            i += 1;
            continue;
            i = 0;
          }
        }
        catch (Exception localException1)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
        }
      }
    }
    Object localObject2 = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "matchUser");
    if (!bo.isNullOrNil((String)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject5 = new cpj();
      ((cpj)localObject5).jJA = ((JSONObject)localObject2).optString("userName");
      ((cpj)localObject5).xYv = ((JSONObject)localObject2).optString("matchWord");
      if (!TextUtils.isEmpty(((cpj)localObject5).jJA)) {
        locals.uIF.add(localObject5);
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
          localObject5 = ((JSONArray)localObject2).getString(i);
          locals.uIJ.add(localObject5);
          i += 1;
          continue;
          localException2 = localException2;
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
        }
      }
      catch (Exception localException3)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
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
            localObject5 = ((JSONArray)localObject3).optJSONObject(i);
            localObject6 = new bgl();
            ((bgl)localObject6).xvK = ((JSONObject)localObject5).optLong("from");
            ((bgl)localObject6).xvL = ((JSONObject)localObject5).optLong("to");
            ((bgl)localObject6).xvJ = ((JSONObject)localObject5).optInt("field");
            locals.uIP.add(localObject6);
            i += 1;
            continue;
            localException4 = localException4;
            ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
          }
        }
        catch (Exception localException5)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
        }
        locals.cCT = bo.f(paramMap.get("webview_instance_id"), -1);
        locals.axa = com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext());
        locals.mRU = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0);
        if (com.tencent.mm.plugin.appbrand.s.r.aNU())
        {
          locals.uIQ = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0);
          if (locals.uIQ == 1)
          {
            locals.uIR = new dbf();
            localObject4 = new ih();
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
            locals.uIR.yhq = ((ih)localObject4).cxG.cxH;
            locals.uIR.yhs = com.tencent.mm.modelappbrand.b.fpR;
            locals.uIR.yhr = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0);
            locals.uIR.session_id = com.tencent.mm.modelappbrand.b.fpQ;
            locals.uIR.yht = locals.uIL;
            localObject4 = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEW, null);
            if ((localObject4 != null) && ((localObject4 instanceof String))) {
              locals.uIR.ygb = ((String)localObject4);
            }
          }
        }
        if (this.uPv != 1) {
          break label1269;
        }
      }
      locals.uIS = this.uIS;
    }
    Object localObject4 = locals.cnv;
    com.tencent.mm.plugin.webview.fts.b.a.a.daG();
    localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.agL((String)localObject4);
    if (localObject4 == null) {}
    for (localObject4 = "";; localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPU)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        locals.cnv = ((String)localObject4);
        locals.uIS = this.uIS;
      }
      if ((locals.scene == 33) && (this.uPw != null))
      {
        if (locals.uIS == null) {
          locals.uIS = new cyi();
        }
        if (locals.uIS.yft == null) {
          locals.uIS.yft = new mc();
        }
        if (this.uPw.yft != null)
        {
          locals.uIS.yft.wAE = this.uPw.yft.wAE;
          ab.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.uPw.yft.wAE });
        }
        this.uPw = null;
      }
      if ((locals.businessType == 262144) && (this.uPw != null) && (this.uPw.yft.wAB == 1))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("isRefresh", 1);
        ((Bundle)localObject4).putString("widgetId", com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "widgetId"));
        locals.uIV = ((Bundle)localObject4);
        locals.uIS = this.uPw;
        this.uPw = null;
      }
      AppMethodBeat.o(5754);
      return locals;
      label1269:
      locals.uIS = null;
      break;
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPU, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).cwc, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPS, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPT });
      this.uIS = new cyi();
      this.uIS.yfs = 1L;
      this.uIS.yft = new mc();
      this.uIS.yft.cwc = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).cwc;
      this.uIS.yft.wAx = bo.apV(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPS);
      this.uIS.yft.kXm = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).uPT;
    }
  }
  
  public static void bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(5752);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", Integer.valueOf(paramInt));
    localHashMap.put("statSessionId", paramString);
    paramString = new d(localHashMap, 1);
    com.tencent.mm.kernel.g.Rc().a(paramString, 0);
    AppMethodBeat.o(5752);
  }
  
  private boolean j(Set<String> paramSet)
  {
    AppMethodBeat.i(5749);
    if ((paramSet == null) || (this.uPf.containsAll(paramSet)))
    {
      AppMethodBeat.o(5749);
      return true;
    }
    AppMethodBeat.o(5749);
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2)
  {
    AppMethodBeat.i(5751);
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "preGetSearchData");
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
      paramString6.put("textValue", com.tencent.mm.plugin.websearch.api.aa.bXn());
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
      paramString1 = aG(localHashMap);
      paramString1.uIW = true;
      if (!aC(paramString1.uIO))
      {
        paramString1 = new IllegalStateException("pre get data must use same commKvSets with hardcode set");
        AppMethodBeat.o(5751);
        throw paramString1;
      }
    }
    catch (JSONException paramString5)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramString5, "", new Object[0]);
      }
      this.uPB.b(paramString1);
      AppMethodBeat.o(5751);
    }
    return false;
  }
  
  public final boolean aE(Map<String, Object> paramMap)
  {
    int j = 1;
    AppMethodBeat.i(5748);
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s", new Object[] { paramMap.toString() });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(bo.f(paramMap.get("webview_instance_id"), -1)).c(com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0), com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query"), paramMap);
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
        ab.e("MicroMsg.WebSearch.WebSearchLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
        this.uPi = true;
        if (this.uPj != null) {
          this.uPj.countDown();
        }
        i = 0;
      }
    }
    while (i != 0)
    {
      ab.i("MicroMsg.WebSearch.WebSearchLogic", "waiting for pre getdata back");
      AppMethodBeat.o(5748);
      return false;
      if (this.uPj != null) {
        this.uPj.countDown();
      }
      i = j;
      if (this.uPk != null)
      {
        ab.i("MicroMsg.WebSearch.WebSearchLogic", "do not send this call, wait for pre get, webivewId %d, %s", new Object[] { Integer.valueOf(this.uPk.cCT), this.uPk });
        i = j;
        continue;
        if (this.uPj != null) {
          this.uPj.countDown();
        }
        i = 0;
      }
    }
    paramMap = aG(paramMap);
    this.uPB.b(paramMap);
    AppMethodBeat.o(5748);
    return false;
  }
  
  public final boolean aH(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(5757);
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject1 = new s();
    ((s)localObject1).cnv = com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "query");
    try
    {
      ((s)localObject1).cnv = URLDecoder.decode(((s)localObject1).cnv, "UTF-8");
      label59:
      ((s)localObject1).businessType = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "type", 0);
      ((s)localObject1).scene = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "scene", 0);
      int i;
      Object localObject2;
      if (com.tencent.mm.plugin.websearch.api.aa.u(paramMap, "isHomePage"))
      {
        i = 1;
        ((s)localObject1).uIE = i;
        ((s)localObject1).cCT = bo.f(paramMap.get("webview_instance_id"), -1);
        ((s)localObject1).uIJ.add(com.tencent.mm.plugin.websearch.api.aa.t(paramMap, "prefixQuery"));
        i = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "requestType", 0);
        ((s)localObject1).mRU = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subtype", 0);
        ab.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((s)localObject1).cCT) });
        if (com.tencent.mm.plugin.appbrand.s.r.aNU())
        {
          ((s)localObject1).uIQ = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "isWeAppMore", 0);
          if (((s)localObject1).uIQ == 1)
          {
            ((s)localObject1).uIR = new dbf();
            localObject2 = new ih();
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            ((s)localObject1).uIR.yhq = ((ih)localObject2).cxG.cxH;
            ((s)localObject1).uIR.yhs = com.tencent.mm.modelappbrand.b.fpR;
            ((s)localObject1).uIR.yhr = com.tencent.mm.plugin.websearch.api.aa.d(paramMap, "subType", 0);
            ((s)localObject1).uIR.session_id = com.tencent.mm.modelappbrand.b.fpQ;
            paramMap = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEW, null);
            if ((paramMap != null) && ((paramMap instanceof String))) {
              ((s)localObject1).uIR.ygb = ((String)paramMap);
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
        for (;;)
        {
          AppMethodBeat.o(5757);
          return false;
          i = 0;
          break;
          localObject2 = this.uPC;
          if (((b)localObject2).uPI != null)
          {
            com.tencent.mm.kernel.g.Rc().b(((b)localObject2).uPI.getType(), ((b)localObject2).uPD);
            com.tencent.mm.kernel.g.Rc().a(((b)localObject2).uPI);
            ((b)localObject2).uPI = null;
          }
          if (((b)localObject2).uPI == null)
          {
            if (!com.tencent.mm.plugin.appbrand.s.r.aNU()) {
              if (JJ(((s)localObject1).scene)) {
                paramMap = new com.tencent.mm.modelappbrand.r(((s)localObject1).cnv, ((s)localObject1).scene, ((s)localObject1).cCT);
              }
            }
            for (;;)
            {
              ((b)localObject2).uPI = paramMap;
              com.tencent.mm.kernel.g.Rc().a(((b)localObject2).uPI.getType(), ((b)localObject2).uPD);
              com.tencent.mm.kernel.g.Rc().a(((b)localObject2).uPI, 0);
              break;
              paramMap = new f((s)localObject1);
              continue;
              paramMap = new f((s)localObject1);
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(((s)localObject1).cCT).aiZ(af.cZy());
          }
        }
        localObject2 = ((s)localObject1).cnv;
        i = ((s)localObject1).businessType;
        j = ((s)localObject1).cCT;
      } while (bo.isNullOrNil((String)localObject2));
      if (this.mSV != null)
      {
        ((n)com.tencent.mm.kernel.g.G(n.class)).cancelSearchTask(this.mSV);
        this.mSV = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject1 = new i();
        ((i)localObject1).hdl = 16;
        ((i)localObject1).query = ((String)localObject2);
        ((i)localObject1).mSP = paramMap;
        ((i)localObject1).mSR = 5;
        ((i)localObject1).mST = com.tencent.mm.plugin.fts.a.c.b.mTt;
        ((i)localObject1).mSS = new HashSet();
        ((i)localObject1).mSU = this.pym;
        this.mSV = ((n)com.tencent.mm.kernel.g.G(n.class)).search(2, (i)localObject1);
        this.mSV.mRQ = Integer.valueOf(j);
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
  
  public final void daC()
  {
    AppMethodBeat.i(5759);
    String str = com.tencent.mm.plugin.websearch.api.aa.Jp(0);
    ab.i("MicroMsg.WebSearch.WebSearchLogic", "config commKV %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      this.uPm = true;
      AppMethodBeat.o(5759);
      return;
    }
    this.uPm = j(new HashSet(Arrays.asList(str.split(","))));
    AppMethodBeat.o(5759);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(5755);
    int i;
    if (paramm != null) {
      i = paramm.getType();
    }
    for (;;)
    {
      ab.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      if ((paramm instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.Rc().b(paramm.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramm;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ab.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.bBW() });
          paramm = new JSONObject();
        }
      }
      try
      {
        paramm.put("ret", -1);
        label128:
        paramm = paramm.toString();
        a(paramString.cZa(), paramm, paramString.cZb(), paramString.cZd(), null);
        AppMethodBeat.o(5755);
        return;
        i = 0;
        continue;
        paramm = paramString.act();
        paramInt1 = paramString.acu();
        ab.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.bBW() });
        a(paramString.cZa(), paramm, paramString.cZb(), paramString.cZd(), paramString.cZc());
        if (paramInt1 > 0)
        {
          ab.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          b.c.dmg();
          com.tencent.mm.pluginsdk.g.a.a.b.LE(27);
        }
        AppMethodBeat.o(5755);
        return;
        if ((paramm instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.Rc().b(paramm.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramm;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            ab.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramString.cZa()).aiZ("{}");
            AppMethodBeat.o(5755);
            return;
          }
          paramm = paramString.act();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(paramString.cZa()).aiZ(paramm);
        }
        AppMethodBeat.o(5755);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label128;
      }
    }
  }
  
  public final class b
  {
    public com.tencent.mm.plugin.websearch.api.b uPI;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.h
 * JD-Core Version:    0.7.0.1
 */