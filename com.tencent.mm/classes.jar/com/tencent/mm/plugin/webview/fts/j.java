package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mmkv.MMKV;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
  implements com.tencent.mm.ak.i
{
  static final long IOO;
  private static MMKV mmkv;
  private com.tencent.mm.plugin.fts.a.l Bdt;
  public fap IDS;
  h.a INN;
  public final MMHandler IOP;
  private volatile v IOW;
  public IListener IOZ;
  public int IPh;
  public fap IPi;
  public Map<String, Integer> IPj;
  long IPk;
  public IListener IPl;
  private com.tencent.mm.plugin.websearch.b.a.c IPm;
  public final h IPn;
  public b IPo;
  public j.c IPp;
  public com.tencent.mm.plugin.fts.a.a.a wXa;
  
  static
  {
    AppMethodBeat.i(77974);
    IOO = com.tencent.mm.ui.d.gGT() + 500;
    AppMethodBeat.o(77974);
  }
  
  public j()
  {
    AppMethodBeat.i(77960);
    this.IPh = 0;
    this.IPj = new HashMap();
    this.IOZ = new j.1(this);
    this.IPl = new IListener() {};
    this.IPm = new com.tencent.mm.plugin.websearch.b.a.b();
    this.IPo = new b((byte)0);
    this.INN = new j.6(this);
    this.IPp = new j.c(this, (byte)0);
    this.Bdt = new j.7(this);
    Log.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.IOZ.alive();
    this.IPl.alive();
    this.IOP = new MMHandler("WebSearchLogic_worker");
    this.IPn = new h(this.IOP);
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramm.wVX);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.arL(paramm.wVX);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.wVW)
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
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).wWg = com.tencent.mm.plugin.fts.a.a.e.a.wWp;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).wWl = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).wWm = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).wWu.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.wWg = com.tencent.mm.plugin.fts.a.a.e.a.wWp;
            paramh.wWl = "<em class=\"highlight\">";
            paramh.wWm = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).wWu.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.arL(paramm.wVX));
              ((JSONObject)localObject1).put("userName", paramm.wVX);
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
      localObject1 = ((ax)localObject4).field_nickname;
      localObject2 = MMApplicationContext.getContext().getString(2131765066);
      i = 1;
      j = 0;
      break;
      localObject1 = ((ax)localObject4).fuR;
      localObject2 = MMApplicationContext.getContext().getString(2131765061);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((as)localObject4).ajx();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((ax)localObject4).field_username;
      }
      localObject2 = MMApplicationContext.getContext().getString(2131765071);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paramm.content;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label500:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramh.wWB)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = MMApplicationContext.getContext().getString(2131765065);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label500;
        localObject1 = paramm.content;
        localObject2 = MMApplicationContext.getContext().getString(2131765067);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramm.content;
        localObject2 = MMApplicationContext.getContext().getString(2131765060);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((n)com.tencent.mm.kernel.g.ah(n.class)).getFTSMainDB().aym(((ax)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.wWD;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.ayq(str).contains(localCharSequence))
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
          localObject2 = MMApplicationContext.getContext().getString(2131765070);
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
  
  private void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(77969);
    paramString1 = new j.a(paramInt, paramString1, paramBoolean, paramString2, paramBundle);
    this.IPn.a(1, paramString2, paramString1, this.INN);
    AppMethodBeat.o(77969);
  }
  
  private v bE(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = ai.b(paramMap, "scene", 0);
    v localv = new v();
    localv.dDv = ai.N(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = i;
    localv.IDG = ai.N(paramMap, "sugId");
    localv.IDI = ai.b(paramMap, "sugType", 0);
    localv.IDH = ai.N(paramMap, "prefixSug");
    localv.IDT = ai.N(paramMap, "poiInfo");
    if (ai.O(paramMap, "isHomePage")) {
      i = 1;
    }
    for (;;)
    {
      localv.IDE = i;
      localv.rjq = ai.N(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.N(paramMap, "sessionId");
      }
      localv.dVS = ai.b(paramMap, "sceneActionType", 1);
      localv.IDK = ai.b(paramMap, "displayPattern", 2);
      localv.IDL = ai.b(paramMap, "sugPosition", 0);
      localv.IDM = ai.N(paramMap, "sugBuffer");
      localv.dPI = ai.N(paramMap, "requestId");
      localv.sessionId = ai.N(paramMap, "sessionId");
      localv.dVO = ai.N(paramMap, "subSessionId");
      localv.IDU = ai.N(paramMap, "tagId");
      localv.IDY = ai.O(paramMap, "fromTagSearch");
      Object localObject1 = ai.N(paramMap, "extClientParams");
      try
      {
        Object localObject5 = new JSONObject(URLDecoder.decode((String)localObject1, "utf-8"));
        localv.IEb = ((JSONObject)localObject5).optString("ShareSceneId");
        localv.IEc = ((JSONObject)localObject5).optInt("SnsContentType");
        localObject1 = ((JSONObject)localObject5).optString("exposedFingerWord");
        localObject5 = ((JSONObject)localObject5).optString("matchedFingerWord");
        Object localObject6;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject6 = new aca();
          ((aca)localObject6).key = "exposedFingerWord";
          ((aca)localObject6).LmD = ((String)localObject1);
          localObject1 = new aca();
          ((aca)localObject1).key = "matchedFingerWord";
          ((aca)localObject1).LmD = ((String)localObject5);
          localv.IDO.add(localObject6);
          localv.IDO.add(localObject1);
        }
        label431:
        localObject1 = ai.N(paramMap, "extReqParams");
        if (!Util.isNullOrNil((String)localObject1)) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject5 = ((JSONArray)localObject1).getJSONObject(i);
              localObject6 = new aca();
              ((aca)localObject6).key = ((JSONObject)localObject5).optString("key", "");
              ((aca)localObject6).LmC = ((JSONObject)localObject5).optInt("uintValue", 0);
              ((aca)localObject6).LmD = ((JSONObject)localObject5).optString("textValue", "");
              localv.IDO.add(localObject6);
              i += 1;
              continue;
              i = 0;
            }
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException1, "commKvJSONArray", new Object[0]);
          }
        }
        Object localObject2 = ai.N(paramMap, "matchUser");
        if (!Util.isNullOrNil((String)localObject2)) {}
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localObject5 = new eou();
          ((eou)localObject5).UserName = ((JSONObject)localObject2).optString("userName");
          ((eou)localObject5).NmU = ((JSONObject)localObject2).optString("matchWord");
          if (!TextUtils.isEmpty(((eou)localObject5).UserName)) {
            localv.IDF.add(localObject5);
          }
          localObject2 = ai.N(paramMap, "prefixQuery");
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
              localObject5 = ((JSONArray)localObject2).getString(i);
              localv.IDJ.add(localObject5);
              i += 1;
              continue;
              localException2 = localException2;
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException2, "matchUserJSONArray", new Object[0]);
            }
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException3, "prefixQueryJSONArray", new Object[0]);
          }
          Object localObject3 = ai.N(paramMap, "tagInfo");
          if (!Util.isNullOrNil((String)localObject3)) {}
          try
          {
            localObject3 = new JSONObject((String)localObject3);
            localv.IDN = new egk();
            localv.IDN.Ngs = ((JSONObject)localObject3).optString("tagText");
            localv.IDN.Ngr = ((JSONObject)localObject3).optInt("tagType");
            localv.IDN.Ngt = ((JSONObject)localObject3).optString("tagExtValue");
            localObject3 = ai.N(paramMap, "numConditions");
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
                localObject5 = ((JSONArray)localObject3).optJSONObject(i);
                localObject6 = new ctz();
                ((ctz)localObject6).Mzn = ((JSONObject)localObject5).optLong("from");
                ((ctz)localObject6).Mzo = ((JSONObject)localObject5).optLong("to");
                ((ctz)localObject6).Mzm = ((JSONObject)localObject5).optInt("field");
                localv.IDP.add(localObject6);
                i += 1;
                continue;
                localException4 = localException4;
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException4, "tagInfoObj", new Object[0]);
              }
            }
            catch (Exception localException5)
            {
              Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", localException5, "numConditionsArray", new Object[0]);
            }
            localv.dVL = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
            localv.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            localv.wVW = ai.b(paramMap, "subType", 0);
            localv.IDQ = ai.b(paramMap, "isWeAppMore", 0);
            Object localObject4;
            if (localv.IDQ == 1)
            {
              localv.IDR = new fel();
              localv.IDR.KRN = ai.aft(3);
              localv.IDR.NzF = com.tencent.mm.modelappbrand.b.iIn;
              localv.IDR.Mzg = ai.b(paramMap, "subType", 0);
              localv.IDR.session_id = com.tencent.mm.modelappbrand.b.iIm;
              localv.IDR.NzG = localv.IDL;
              localObject4 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oam, null);
              if ((localObject4 != null) && ((localObject4 instanceof String))) {
                localv.IDR.MOt = ((String)localObject4);
              }
            }
            if (this.IPh == 1) {
              localv.IDS = this.IDS;
            }
            for (;;)
            {
              localObject4 = localv.dDv;
              com.tencent.mm.plugin.webview.fts.b.a.a.gaG();
              localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.aXY((String)localObject4);
              if (localObject4 == null)
              {
                localObject4 = "";
                if (!TextUtils.isEmpty((CharSequence)localObject4))
                {
                  localv.dDv = ((String)localObject4);
                  localv.IDS = this.IDS;
                }
                if ((localv.scene == 33) && (this.IPi != null))
                {
                  if (localv.IDS == null) {
                    localv.IDS = new fap();
                  }
                  if (localv.IDS.NwR == null) {
                    localv.IDS.NwR = new qu();
                  }
                  if (this.IPi.NwR != null)
                  {
                    localv.IDS.NwR.KXJ = this.IPi.NwR.KXJ;
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.IPi.NwR.KXJ });
                  }
                  this.IPi = null;
                }
                if ((localv.businessType == 262144) && (this.IPi != null) && (this.IPi.NwR.KXG == 1))
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putInt("isRefresh", 1);
                  ((Bundle)localObject4).putString("widgetId", ai.N(paramMap, "widgetId"));
                  localv.CAJ = ((Bundle)localObject4);
                  localv.IDS = this.IPi;
                  this.IPi = null;
                }
                paramMap = ai.N(paramMap, "specialSearch");
                if (Util.isNullOrNil(paramMap)) {}
              }
              try
              {
                paramMap = new JSONObject(paramMap);
                localv.IDX = paramMap.optInt("type", 0);
                localv.dDL = paramMap.optJSONObject("params").optString("reqKey");
                label1452:
                AppMethodBeat.o(77967);
                return localv;
                localv.IDS = null;
                continue;
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPJ, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dNI, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPH, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPI });
                this.IDS = new fap();
                this.IDS.NwQ = 1L;
                this.IDS.NwR = new qu();
                this.IDS.NwR.dNI = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).dNI;
                this.IDS.NwR.KXC = Util.safeParseInt(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPH);
                this.IDS.NwR.qHp = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPI;
                localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).IPJ;
              }
              catch (Exception paramMap)
              {
                break label1452;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label431;
      }
    }
  }
  
  static MMKV gaC()
  {
    AppMethodBeat.i(210850);
    if (mmkv == null) {
      mmkv = MMKV.mmkvWithID("WebSearchLogic", 2);
    }
    MMKV localMMKV = mmkv;
    AppMethodBeat.o(210850);
    return localMMKV;
  }
  
  public static void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(210849);
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "setPreGetParams: %s", new Object[] { paramString });
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString == null) {
          break label101;
        }
        paramString = paramString.optString("extReqParams");
        MMKV localMMKV = gaC();
        localMMKV.encode("websearch_preget_extReqParams", paramString);
        localMMKV.encode("websearch_preget_version", ai.aft(0));
        AppMethodBeat.o(210849);
        return;
      }
      catch (Throwable paramString)
      {
        Log.e("MicroMsg.WebSearch.WebSearchLogic", "setPreGetParams err", new Object[] { paramString });
      }
      paramString = null;
      continue;
      label101:
      paramString = "";
    }
  }
  
  /* Error */
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, String paramString6, int paramInt2, int paramInt3, String paramString7, String paramString8, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc_w 929
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 125
    //   8: ldc_w 931
    //   11: invokestatic 933	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 87	java/util/HashMap
    //   17: dup
    //   18: invokespecial 88	java/util/HashMap:<init>	()V
    //   21: astore 13
    //   23: aload 13
    //   25: ldc_w 501
    //   28: ldc_w 935
    //   31: invokeinterface 938 3 0
    //   36: pop
    //   37: aload 13
    //   39: ldc_w 432
    //   42: aload 4
    //   44: invokeinterface 938 3 0
    //   49: pop
    //   50: aload 13
    //   52: ldc_w 424
    //   55: iload 5
    //   57: invokestatic 941	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: invokeinterface 938 3 0
    //   65: pop
    //   66: aload 13
    //   68: ldc_w 445
    //   71: ldc_w 943
    //   74: invokeinterface 938 3 0
    //   79: pop
    //   80: aload 13
    //   82: ldc_w 472
    //   85: ldc_w 945
    //   88: invokeinterface 938 3 0
    //   93: pop
    //   94: aload 13
    //   96: ldc_w 452
    //   99: aload 7
    //   101: invokeinterface 938 3 0
    //   106: pop
    //   107: aload 13
    //   109: ldc_w 496
    //   112: iload 8
    //   114: invokestatic 950	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokeinterface 938 3 0
    //   122: pop
    //   123: aload 11
    //   125: invokestatic 407	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +467 -> 595
    //   131: new 589	org/json/JSONArray
    //   134: dup
    //   135: aload 11
    //   137: invokespecial 590	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   140: astore 4
    //   142: aload 4
    //   144: ifnonnull +486 -> 630
    //   147: new 589	org/json/JSONArray
    //   150: dup
    //   151: invokespecial 951	org/json/JSONArray:<init>	()V
    //   154: astore 4
    //   156: new 253	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 254	org/json/JSONObject:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: ldc_w 596
    //   170: ldc_w 953
    //   173: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload 7
    //   179: ldc_w 608
    //   182: invokestatic 956	com/tencent/mm/plugin/websearch/api/ai:ait	()Ljava/lang/String;
    //   185: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload 4
    //   191: aload 7
    //   193: invokevirtual 959	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   196: pop
    //   197: new 253	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 254	org/json/JSONObject:<init>	()V
    //   204: astore 7
    //   206: aload 7
    //   208: ldc_w 596
    //   211: ldc_w 961
    //   214: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 7
    //   220: ldc_w 608
    //   223: iconst_1
    //   224: invokevirtual 964	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 4
    //   230: aload 7
    //   232: invokevirtual 959	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   235: pop
    //   236: new 253	org/json/JSONObject
    //   239: dup
    //   240: invokespecial 254	org/json/JSONObject:<init>	()V
    //   243: astore 7
    //   245: aload 7
    //   247: ldc_w 596
    //   250: ldc_w 516
    //   253: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 7
    //   259: ldc_w 608
    //   262: aload_1
    //   263: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload 4
    //   269: aload 7
    //   271: invokevirtual 959	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   274: pop
    //   275: new 253	org/json/JSONObject
    //   278: dup
    //   279: invokespecial 254	org/json/JSONObject:<init>	()V
    //   282: astore 7
    //   284: aload 7
    //   286: ldc_w 596
    //   289: ldc_w 966
    //   292: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload 7
    //   298: ldc_w 608
    //   301: aload 6
    //   303: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload 4
    //   309: aload 7
    //   311: invokevirtual 959	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   314: pop
    //   315: aload 13
    //   317: ldc_w 587
    //   320: aload 4
    //   322: invokevirtual 967	org/json/JSONArray:toString	()Ljava/lang/String;
    //   325: invokeinterface 938 3 0
    //   330: pop
    //   331: aload 13
    //   333: ldc_w 486
    //   336: aload_2
    //   337: invokeinterface 938 3 0
    //   342: pop
    //   343: aload 13
    //   345: ldc_w 521
    //   348: aload_3
    //   349: invokeinterface 938 3 0
    //   354: pop
    //   355: aload 13
    //   357: ldc_w 516
    //   360: aload_1
    //   361: invokeinterface 938 3 0
    //   366: pop
    //   367: aload 12
    //   369: ifnull +12 -> 381
    //   372: aload 13
    //   374: aload 12
    //   376: invokeinterface 971 2 0
    //   381: aload_0
    //   382: aload 13
    //   384: invokespecial 164	com/tencent/mm/plugin/webview/fts/j:bE	(Ljava/util/Map;)Lcom/tencent/mm/plugin/websearch/api/v;
    //   387: astore_3
    //   388: iload 9
    //   390: iconst_1
    //   391: if_icmpeq +9 -> 400
    //   394: iload 9
    //   396: iconst_2
    //   397: if_icmpne +9 -> 406
    //   400: aload_3
    //   401: iload 9
    //   403: putfield 846	com/tencent/mm/plugin/websearch/api/v:IDX	I
    //   406: aload 10
    //   408: invokestatic 407	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   411: ifne +210 -> 621
    //   414: aload 10
    //   416: invokestatic 973	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   419: astore_2
    //   420: aload_3
    //   421: aload_2
    //   422: putfield 856	com/tencent/mm/plugin/websearch/api/v:dDL	Ljava/lang/String;
    //   425: aload_2
    //   426: invokestatic 407	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifne +134 -> 563
    //   432: iload 9
    //   434: iconst_2
    //   435: if_icmpne +128 -> 563
    //   438: ldc 125
    //   440: ldc_w 975
    //   443: iconst_1
    //   444: anewarray 4	java/lang/Object
    //   447: dup
    //   448: iconst_0
    //   449: aload_1
    //   450: aastore
    //   451: invokestatic 819	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: new 429	com/tencent/mm/plugin/websearch/api/v
    //   457: dup
    //   458: invokespecial 430	com/tencent/mm/plugin/websearch/api/v:<init>	()V
    //   461: astore 4
    //   463: aload 4
    //   465: iconst_0
    //   466: putfield 450	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   469: aload 4
    //   471: aload_1
    //   472: putfield 519	com/tencent/mm/plugin/websearch/api/v:dPI	Ljava/lang/String;
    //   475: aload 4
    //   477: iload 9
    //   479: putfield 846	com/tencent/mm/plugin/websearch/api/v:IDX	I
    //   482: aload 4
    //   484: aload_2
    //   485: putfield 856	com/tencent/mm/plugin/websearch/api/v:dDL	Ljava/lang/String;
    //   488: new 253	org/json/JSONObject
    //   491: dup
    //   492: invokespecial 254	org/json/JSONObject:<init>	()V
    //   495: astore_2
    //   496: aload_2
    //   497: ldc_w 977
    //   500: ldc_w 979
    //   503: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   506: pop
    //   507: aload_2
    //   508: ldc_w 981
    //   511: aload 4
    //   513: getfield 856	com/tencent/mm/plugin/websearch/api/v:dDL	Ljava/lang/String;
    //   516: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 4
    //   522: aload_2
    //   523: invokevirtual 982	org/json/JSONObject:toString	()Ljava/lang/String;
    //   526: putfield 983	com/tencent/mm/plugin/websearch/api/v:content	Ljava/lang/String;
    //   529: aload 4
    //   531: getfield 983	com/tencent/mm/plugin/websearch/api/v:content	Ljava/lang/String;
    //   534: astore_2
    //   535: aload_0
    //   536: getfield 155	com/tencent/mm/plugin/webview/fts/j:IPn	Lcom/tencent/mm/plugin/webview/fts/h;
    //   539: iconst_0
    //   540: aload_2
    //   541: invokevirtual 987	com/tencent/mm/plugin/webview/fts/h:p	(ILjava/lang/Object;)V
    //   544: new 989	com/tencent/mm/plugin/websearch/api/aa
    //   547: dup
    //   548: aload 4
    //   550: invokespecial 992	com/tencent/mm/plugin/websearch/api/aa:<init>	(Lcom/tencent/mm/plugin/websearch/api/v;)V
    //   553: astore_2
    //   554: invokestatic 996	com/tencent/mm/kernel/g:azz	()Lcom/tencent/mm/ak/t;
    //   557: aload_2
    //   558: iconst_0
    //   559: invokevirtual 1001	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   562: pop
    //   563: aload_3
    //   564: iconst_1
    //   565: putfield 1004	com/tencent/mm/plugin/websearch/api/v:IDV	Z
    //   568: aload_0
    //   569: getfield 155	com/tencent/mm/plugin/webview/fts/j:IPn	Lcom/tencent/mm/plugin/webview/fts/h;
    //   572: iconst_1
    //   573: aload_1
    //   574: invokevirtual 987	com/tencent/mm/plugin/webview/fts/h:p	(ILjava/lang/Object;)V
    //   577: aload_0
    //   578: getfield 110	com/tencent/mm/plugin/webview/fts/j:IPo	Lcom/tencent/mm/plugin/webview/fts/j$b;
    //   581: aload_3
    //   582: invokevirtual 1006	com/tencent/mm/plugin/webview/fts/j$b:b	(Lcom/tencent/mm/plugin/websearch/api/v;)V
    //   585: ldc_w 929
    //   588: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: iconst_0
    //   592: ireturn
    //   593: astore 4
    //   595: aconst_null
    //   596: astore 4
    //   598: goto -456 -> 142
    //   601: astore 6
    //   603: ldc 125
    //   605: aload 6
    //   607: ldc_w 387
    //   610: iconst_0
    //   611: anewarray 4	java/lang/Object
    //   614: invokestatic 614	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   617: goto -302 -> 315
    //   620: astore_2
    //   621: aconst_null
    //   622: astore_2
    //   623: goto -198 -> 425
    //   626: astore_2
    //   627: goto -64 -> 563
    //   630: goto -474 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	this	j
    //   0	633	1	paramString1	String
    //   0	633	2	paramString2	String
    //   0	633	3	paramString3	String
    //   0	633	4	paramString4	String
    //   0	633	5	paramInt1	int
    //   0	633	6	paramString5	String
    //   0	633	7	paramString6	String
    //   0	633	8	paramInt2	int
    //   0	633	9	paramInt3	int
    //   0	633	10	paramString7	String
    //   0	633	11	paramString8	String
    //   0	633	12	paramMap	Map<String, String>
    //   21	362	13	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   131	142	593	java/lang/Throwable
    //   156	315	601	org/json/JSONException
    //   414	425	620	java/lang/Throwable
    //   496	563	626	java/lang/Throwable
  }
  
  public final boolean bC(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77961);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    String str = ai.N(paramMap, "requestId");
    if (!ai.O(paramMap, "isBackButtonClick")) {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(i).d(ai.b(paramMap, "type", 0), ai.N(paramMap, "query"), paramMap);
    }
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s,wid: %s,rid: %s", new Object[] { paramMap.toString(), Integer.valueOf(i), str });
    this.IPn.a(1, str, Integer.valueOf(i), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77954);
        v localv = j.a(j.this, paramMap);
        j.b(j.this).b(localv);
        AppMethodBeat.o(77954);
      }
    }, this.INN);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean bF(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new v();
    ((v)localObject).dDv = ai.N(paramMap, "query");
    try
    {
      ((v)localObject).dDv = URLDecoder.decode(((v)localObject).dDv, "UTF-8");
      label59:
      ((v)localObject).businessType = ai.b(paramMap, "type", 0);
      ((v)localObject).scene = ai.b(paramMap, "scene", 0);
      int i;
      if (ai.O(paramMap, "isHomePage"))
      {
        i = 1;
        ((v)localObject).IDE = i;
        ((v)localObject).dVL = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        ((v)localObject).IDJ.add(ai.N(paramMap, "prefixQuery"));
        i = ai.b(paramMap, "requestType", 0);
        ((v)localObject).wVW = ai.b(paramMap, "subtype", 0);
        ((v)localObject).IDQ = ai.b(paramMap, "isWeAppMore", 0);
        if (((v)localObject).IDQ == 1)
        {
          ((v)localObject).IDR = new fel();
          ((v)localObject).IDR.KRN = ai.aft(3);
          ((v)localObject).IDR.NzF = com.tencent.mm.modelappbrand.b.iIn;
          ((v)localObject).IDR.Mzg = ai.b(paramMap, "subType", 0);
          ((v)localObject).IDR.session_id = com.tencent.mm.modelappbrand.b.iIm;
          paramMap = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oam, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((v)localObject).IDR.MOt = ((String)paramMap);
          }
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((v)localObject).dVL) });
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
          paramMap = this.IPp;
          if (paramMap.IPx != null)
          {
            com.tencent.mm.kernel.g.azz().b(paramMap.IPx.getType(), paramMap.IPq);
            com.tencent.mm.kernel.g.azz().a(paramMap.IPx);
            paramMap.IPx = null;
          }
          if (paramMap.IPx == null)
          {
            paramMap.IPx = new g((v)localObject);
            com.tencent.mm.kernel.g.azz().a(paramMap.IPx.getType(), paramMap.IPq);
            com.tencent.mm.kernel.g.azz().a(paramMap.IPx, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(((v)localObject).dVL).aXm(al.fYh());
          }
        }
        str = ((v)localObject).dDv;
        i = ((v)localObject).businessType;
        j = ((v)localObject).dVL;
      } while (Util.isNullOrNil(str));
      if (this.wXa != null)
      {
        ((n)com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
        this.wXa = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).kXb = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWU = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWW = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWY = com.tencent.mm.plugin.fts.a.c.b.wXy;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWX = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).wWZ = this.Bdt;
        this.wXa = ((n)com.tencent.mm.kernel.g.ah(n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.wXa.wVS = Integer.valueOf(j);
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
  
  public final h gaB()
  {
    return this.IPn;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(77968);
    int i;
    if (paramq != null) {
      i = paramq.getType();
    }
    for (;;)
    {
      Log.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd websearch (type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramq instanceof com.tencent.mm.plugin.websearch.api.a))
      {
        com.tencent.mm.kernel.g.azz().b(paramq.getType(), this);
        paramString = (com.tencent.mm.plugin.websearch.api.a)paramq;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getKeyword() });
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("ret", -1);
        label128:
        paramq = paramq.toString();
        a(paramString.fXz(), paramq, paramString.fXA(), paramString.fXE(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramq = paramString.fXC();
        paramInt1 = paramString.fXD();
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.fXz(), paramq, paramString.fXA(), paramString.fXE(), paramString.fXB());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.j.a.a.b.gnC();
          com.tencent.mm.pluginsdk.j.a.a.b.ahP(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.g.azz().b(paramq.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramq;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramString.fXz()).aXm("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramq = paramString.fXC();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(paramString.fXz()).aXm(paramq);
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
  
  public final class b
    implements Comparable
  {
    public com.tencent.mm.plugin.websearch.api.a IPe;
    public a IPv;
    private ThreadPoolExecutor dvM;
    
    private b()
    {
      AppMethodBeat.i(77957);
      this.dvM = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(v paramv)
    {
      AppMethodBeat.i(77958);
      if (this.IPv != null) {
        this.IPv.stopped = true;
      }
      this.IPv = new a((byte)0);
      this.IPv.IDt = paramv;
      j.a(j.this, paramv);
      this.dvM.execute(this.IPv);
      AppMethodBeat.o(77958);
    }
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      v IDt;
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
        if ((Util.isNullOrNil(this.IDt.dDv)) && (this.IDt.IDX != 2))
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.IDt.businessType), Integer.valueOf(this.IDt.scene), Integer.valueOf(this.IDt.IDE), Integer.valueOf(this.IDt.dVS), this.IDt.rjq, Integer.valueOf(this.IDt.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.IDt.scene)
        {
        }
        for (;;)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.IDt.dDv, Integer.valueOf(this.IDt.dVL) });
          if (j.b.a(j.b.this) != null) {
            com.tencent.mm.kernel.g.azz().a(j.b.a(j.b.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.IDt.IDF != null)
          {
            localObject = localLinkedList;
            if (!this.IDt.IDF.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (j.aE(this.IDt.dDv, this.IDt.scene, this.IDt.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.b.a.e)j.a(j.this).aXo(this.IDt.dDv);
              l = System.currentTimeMillis() - l;
              Log.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.h.CyF.a(14717, new Object[] { this.IDt.dDv, Integer.valueOf(ab.aVb()), Integer.valueOf(((com.tencent.mm.plugin.websearch.b.a.e)localObject).mWl.size()), Long.valueOf(l), Integer.valueOf(this.IDt.scene) });
            }
          }
          if (this.stopped)
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.IDt.dDv);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label489:
            ((n)com.tencent.mm.kernel.g.ah(n.class)).addSOSHistory(this.IDt.dDv + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.gds().IOd.v(this.IDt.scene, this.IDt.dDv, this.IDt.businessType);
            j.b.a(j.b.this, j.b.c(this.IDt));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.b.a.e)localObject).mWl).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.b.a.e.a locala = (com.tencent.mm.plugin.websearch.b.a.e.a)((Iterator)localObject).next();
                eou localeou = new eou();
                localeou.UserName = locala.userName;
                localeou.NmU = locala.IGC;
                localeou.oUJ = locala.nickName;
                localeou.LoI = locala.remark;
                localeou.ked = locala.fMb;
                localeou.KHk = locala.desc;
                localLinkedList.add(localeou);
              }
              j.b.a(j.b.this).by(localLinkedList);
            }
            com.tencent.mm.kernel.g.azz().a(j.b.a(j.b.this).getType(), j.this);
            com.tencent.mm.kernel.g.azz().a(j.b.a(j.b.this), 0);
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "doScene(type : %s)", new Object[] { Integer.valueOf(j.b.a(j.b.this).getType()) });
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
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j
 * JD-Core Version:    0.7.0.1
 */