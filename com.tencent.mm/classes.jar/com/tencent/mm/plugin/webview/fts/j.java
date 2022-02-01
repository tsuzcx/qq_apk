package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qs;
import com.tencent.mm.f.a.sa;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.fpm;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  implements com.tencent.mm.an.i
{
  static final long PLf;
  private static MultiProcessMMKV cQO;
  public com.tencent.mm.plugin.fts.a.a.a BIV;
  private l GXs;
  h.a PKf;
  long PLA;
  public IListener PLB;
  private com.tencent.mm.plugin.websearch.b.a.c PLC;
  public final h PLD;
  public b PLE;
  public c PLF;
  public final MMHandler PLg;
  private volatile v PLm;
  public IListener PLp;
  public int PLx;
  public fli PLy;
  public Map<String, Integer> PLz;
  public fli Pyi;
  
  static
  {
    AppMethodBeat.i(77974);
    PLf = com.tencent.mm.ui.e.hFA() + 500;
    AppMethodBeat.o(77974);
  }
  
  public j()
  {
    AppMethodBeat.i(77960);
    this.PLx = 0;
    this.PLz = new HashMap();
    this.PLp = new IListener() {};
    this.PLB = new IListener() {};
    this.PLC = new com.tencent.mm.plugin.websearch.b.a.b();
    this.PLE = new b((byte)0);
    this.PKf = new h.a()
    {
      public final void a(h.b paramAnonymousb)
      {
        AppMethodBeat.i(214236);
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "handleCallback %s", new Object[] { paramAnonymousb });
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(214236);
          return;
        }
        int i = ((Integer)paramAnonymousb.PLd).intValue();
        paramAnonymousb = (j.a)paramAnonymousb.PLe;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(214236);
          return;
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramAnonymousb.fPt, j.c(j.this) });
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).a(paramAnonymousb.data, paramAnonymousb.PLJ, paramAnonymousb.fPt, paramAnonymousb.fHg);
        AppMethodBeat.o(214236);
      }
    };
    this.PLF = new c((byte)0);
    this.GXs = new l()
    {
      public final void b(k paramAnonymousk)
      {
        AppMethodBeat.i(257082);
        switch (paramAnonymousk.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(257082);
          return;
          if ((paramAnonymousk.BIW == null) || (paramAnonymousk.BIW.size() == 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((Integer)j.d(j.this).BHN).intValue()).biX("");
            AppMethodBeat.o(257082);
            return;
          }
          JSONObject localJSONObject1;
          JSONArray localJSONArray1;
          JSONObject localJSONObject2;
          JSONArray localJSONArray2;
          try
          {
            localJSONObject1 = new JSONObject();
            localJSONArray1 = new JSONArray();
            localJSONObject2 = new JSONObject();
            localJSONArray2 = new JSONArray();
            Iterator localIterator = paramAnonymousk.BIW.iterator();
            while (localIterator.hasNext())
            {
              m localm = (m)localIterator.next();
              if (localm.type == 131072) {
                localJSONArray2.put(j.a(localm, paramAnonymousk.BHY));
              }
            }
            localJSONObject2.put("items", localJSONArray2);
          }
          catch (Exception paramAnonymousk)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramAnonymousk, "onSearchDone", new Object[0]);
            AppMethodBeat.o(257082);
            return;
          }
          localJSONObject2.put("title", MMApplicationContext.getContext().getString(c.i.fts_on_suggest_sns_title));
          localJSONObject2.put("count", localJSONArray2.length());
          localJSONObject2.put("type", 3);
          localJSONArray1.put(localJSONObject2);
          localJSONObject1.put("data", localJSONArray1);
          localJSONObject1.put("ret", 0);
          com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((Integer)j.d(j.this).BHN).intValue()).biX(localJSONObject1.toString());
          AppMethodBeat.o(257082);
          return;
          com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((Integer)j.d(j.this).BHN).intValue()).biX("");
        }
      }
    };
    Log.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.PLp.alive();
    this.PLB.alive();
    this.PLg = new MMHandler("WebSearchLogic_worker");
    this.PLD = new h(this.PLg);
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(m paramm, com.tencent.mm.plugin.fts.a.a.h paramh)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramm.BHS);
    Object localObject3 = com.tencent.mm.plugin.fts.a.d.azM(paramm.BHS);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramm.BHR)
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
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).BIb = com.tencent.mm.plugin.fts.a.a.e.a.BIk;
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).BIg = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.e)localObject3).BIh = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.e)localObject3).BIp.toString();
          label197:
          if (i != 0)
          {
            paramh = com.tencent.mm.plugin.fts.a.a.e.a((CharSequence)localObject1, paramh, bool1, bool2);
            paramh.BIb = com.tencent.mm.plugin.fts.a.a.e.a.BIk;
            paramh.BIg = "<em class=\"highlight\">";
            paramh.BIh = "</em>";
            paramh = com.tencent.mm.plugin.fts.a.f.a(paramh).BIp.toString();
            paramh = (String)localObject2 + paramh;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", com.tencent.mm.plugin.fts.a.d.azM(paramm.BHS));
              ((JSONObject)localObject1).put("userName", paramm.BHS);
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
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_nickname);
      i = 1;
      j = 0;
      break;
      localObject1 = ((ax)localObject4).hDq;
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_description);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((as)localObject4).apf();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((ax)localObject4).field_username;
      }
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_wxid);
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
          if (((String)localObject2).startsWith(paramh.BIw)) {
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_mobile);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        i += 1;
        break label500;
        localObject1 = paramm.content;
        localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_province);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramm.content;
        localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_city);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aHF(((ax)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramh.BIy;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.aHJ(str).contains(localCharSequence))
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
          localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_tag);
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
    paramString1 = new a(paramInt, paramString1, paramBoolean, paramString2, paramBundle);
    this.PLD.a(1, paramString2, paramString1, this.PKf);
    AppMethodBeat.o(77969);
  }
  
  static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(228399);
    if (cQO == null) {
      cQO = MultiProcessMMKV.getMMKV("WebSearchLogic", 2);
    }
    MultiProcessMMKV localMultiProcessMMKV = cQO;
    AppMethodBeat.o(228399);
    return localMultiProcessMMKV;
  }
  
  private v bJ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77967);
    int i = ai.b(paramMap, "scene", 0);
    v localv = new v();
    localv.fwe = ai.aa(paramMap, "query");
    localv.offset = ai.b(paramMap, "offset", 0);
    localv.businessType = ai.b(paramMap, "type", 0);
    localv.scene = i;
    localv.PxW = ai.aa(paramMap, "sugId");
    localv.PxY = ai.b(paramMap, "sugType", 0);
    localv.PxX = ai.aa(paramMap, "prefixSug");
    localv.Pyj = ai.aa(paramMap, "poiInfo");
    if (ai.ab(paramMap, "isHomePage")) {
      i = 1;
    }
    for (;;)
    {
      localv.PxU = i;
      localv.uMC = ai.aa(paramMap, "searchId");
      if (paramMap.containsKey("sessionId")) {
        localv.sessionId = ai.aa(paramMap, "sessionId");
      }
      localv.fPw = ai.b(paramMap, "sceneActionType", 1);
      localv.Pya = ai.b(paramMap, "displayPattern", 2);
      localv.Pyb = ai.b(paramMap, "sugPosition", 0);
      localv.Pyc = ai.aa(paramMap, "sugBuffer");
      localv.fIY = ai.aa(paramMap, "requestId");
      localv.sessionId = ai.aa(paramMap, "sessionId");
      localv.fPs = ai.aa(paramMap, "subSessionId");
      localv.Pyk = ai.aa(paramMap, "tagId");
      localv.Pyo = ai.ab(paramMap, "fromTagSearch");
      Object localObject1 = ai.aa(paramMap, "extClientParams");
      try
      {
        Object localObject5 = new JSONObject(URLDecoder.decode((String)localObject1, "utf-8"));
        localv.Pyr = ((JSONObject)localObject5).optString("ShareSceneId");
        localv.Pys = ((JSONObject)localObject5).optInt("SnsContentType");
        localObject1 = ((JSONObject)localObject5).optString("exposedFingerWord");
        localObject5 = ((JSONObject)localObject5).optString("matchedFingerWord");
        Object localObject6;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject6 = new aci();
          ((aci)localObject6).key = "exposedFingerWord";
          ((aci)localObject6).SnW = ((String)localObject1);
          localObject1 = new aci();
          ((aci)localObject1).key = "matchedFingerWord";
          ((aci)localObject1).SnW = ((String)localObject5);
          localv.Pye.add(localObject6);
          localv.Pye.add(localObject1);
        }
        label431:
        localObject1 = ai.aa(paramMap, "extReqParams");
        if (!Util.isNullOrNil((String)localObject1)) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject5 = ((JSONArray)localObject1).getJSONObject(i);
              localObject6 = new aci();
              ((aci)localObject6).key = ((JSONObject)localObject5).optString("key", "");
              ((aci)localObject6).SnV = ((JSONObject)localObject5).optInt("uintValue", 0);
              ((aci)localObject6).SnW = ((JSONObject)localObject5).optString("textValue", "");
              localv.Pye.add(localObject6);
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
        Object localObject2 = ai.aa(paramMap, "matchUser");
        if (!Util.isNullOrNil((String)localObject2)) {}
        try
        {
          localObject2 = new JSONObject((String)localObject2);
          localObject5 = new ezc();
          ((ezc)localObject5).UserName = ((JSONObject)localObject2).optString("userName");
          ((ezc)localObject5).UzH = ((JSONObject)localObject2).optString("matchWord");
          if (!TextUtils.isEmpty(((ezc)localObject5).UserName)) {
            localv.PxV.add(localObject5);
          }
          localObject2 = ai.aa(paramMap, "prefixQuery");
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
              localv.PxZ.add(localObject5);
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
          Object localObject3 = ai.aa(paramMap, "tagInfo");
          if (!Util.isNullOrNil((String)localObject3)) {}
          try
          {
            localObject3 = new JSONObject((String)localObject3);
            localv.Pyd = new eqm();
            localv.Pyd.UsW = ((JSONObject)localObject3).optString("tagText");
            localv.Pyd.UsV = ((JSONObject)localObject3).optInt("tagType");
            localv.Pyd.UsX = ((JSONObject)localObject3).optString("tagExtValue");
            localObject3 = ai.aa(paramMap, "numConditions");
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
                localObject6 = new ddb();
                ((ddb)localObject6).TKT = ((JSONObject)localObject5).optLong("from");
                ((ddb)localObject6).TKU = ((JSONObject)localObject5).optLong("to");
                ((ddb)localObject6).TKS = ((JSONObject)localObject5).optInt("field");
                localv.Pyf.add(localObject6);
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
            localv.fPp = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
            localv.language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            localv.BHR = ai.b(paramMap, "subType", 0);
            localv.Pyg = ai.b(paramMap, "isWeAppMore", 0);
            Object localObject4;
            if (localv.Pyg == 1)
            {
              localv.Pyh = new fpm();
              localv.Pyh.RSO = ai.anh(3);
              localv.Pyh.UNh = com.tencent.mm.modelappbrand.b.lyp;
              localv.Pyh.SbT = ai.b(paramMap, "subType", 0);
              localv.Pyh.session_id = com.tencent.mm.modelappbrand.b.lyo;
              localv.Pyh.UNi = localv.Pyb;
              localObject4 = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Voo, null);
              if ((localObject4 != null) && ((localObject4 instanceof String))) {
                localv.Pyh.Uam = ((String)localObject4);
              }
            }
            if (this.PLx == 1) {
              localv.Pyi = this.Pyi;
            }
            for (;;)
            {
              localObject4 = localv.fwe;
              com.tencent.mm.plugin.webview.fts.b.a.a.gTy();
              localObject4 = com.tencent.mm.plugin.webview.fts.b.a.a.bjT((String)localObject4);
              if (localObject4 == null)
              {
                localObject4 = "";
                if (!TextUtils.isEmpty((CharSequence)localObject4))
                {
                  localv.fwe = ((String)localObject4);
                  localv.Pyi = this.Pyi;
                }
                if ((localv.scene == 33) && (this.PLy != null))
                {
                  if (localv.Pyi == null) {
                    localv.Pyi = new fli();
                  }
                  if (localv.Pyi.UKh == null) {
                    localv.Pyi.UKh = new qn();
                  }
                  if (this.PLy.UKh != null)
                  {
                    localv.Pyi.UKh.RYS = this.PLy.UKh.RYS;
                    Log.i("MicroMsg.WebSearch.WebSearchLogic", "websearch from url [%s]", new Object[] { this.PLy.UKh.RYS });
                  }
                  this.PLy = null;
                }
                if ((localv.businessType == 262144) && (this.PLy != null) && (this.PLy.UKh.RYP == 1))
                {
                  localObject4 = new Bundle();
                  ((Bundle)localObject4).putInt("isRefresh", 1);
                  ((Bundle)localObject4).putString("widgetId", ai.aa(paramMap, "widgetId"));
                  localv.IGp = ((Bundle)localObject4);
                  localv.Pyi = this.PLy;
                  this.PLy = null;
                }
                paramMap = ai.aa(paramMap, "specialSearch");
                if (Util.isNullOrNil(paramMap)) {}
              }
              try
              {
                paramMap = new JSONObject(paramMap);
                localv.Pyn = paramMap.optInt("type", 0);
                localv.fwv = paramMap.optJSONObject("params").optString("reqKey");
                label1452:
                AppMethodBeat.o(77967);
                return localv;
                localv.Pyi = null;
                continue;
                Log.i("MicroMsg.WebSearch.WebSearchLogic", "test-widget-ui args %s, %s, %s, %s", new Object[] { ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLY, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).appid, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLW, ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLX });
                this.Pyi = new fli();
                this.Pyi.UKg = 1L;
                this.Pyi.UKh = new qn();
                this.Pyi.UKh.appid = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).appid;
                this.Pyi.UKh.RYL = Util.safeParseInt(((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLW);
                this.Pyi.UKh.ugq = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLX;
                localObject4 = ((com.tencent.mm.plugin.webview.fts.b.a.a.a)localObject4).PLY;
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
  
  public static void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(228397);
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
        MultiProcessMMKV localMultiProcessMMKV = aal();
        localMultiProcessMMKV.encode("websearch_preget_extReqParams", paramString);
        localMultiProcessMMKV.encode("websearch_preget_version", ai.anh(0));
        AppMethodBeat.o(228397);
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
    //   0: ldc_w 947
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 128
    //   8: ldc_w 949
    //   11: invokestatic 951	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 96	java/util/HashMap
    //   17: dup
    //   18: invokespecial 97	java/util/HashMap:<init>	()V
    //   21: astore 13
    //   23: aload 13
    //   25: ldc_w 533
    //   28: ldc_w 953
    //   31: invokeinterface 956 3 0
    //   36: pop
    //   37: aload 13
    //   39: ldc_w 464
    //   42: aload 4
    //   44: invokeinterface 956 3 0
    //   49: pop
    //   50: aload 13
    //   52: ldc_w 456
    //   55: iload 5
    //   57: invokestatic 959	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: invokeinterface 956 3 0
    //   65: pop
    //   66: aload 13
    //   68: ldc_w 477
    //   71: ldc_w 961
    //   74: invokeinterface 956 3 0
    //   79: pop
    //   80: aload 13
    //   82: ldc_w 504
    //   85: ldc_w 963
    //   88: invokeinterface 956 3 0
    //   93: pop
    //   94: aload 13
    //   96: ldc_w 484
    //   99: aload 7
    //   101: invokeinterface 956 3 0
    //   106: pop
    //   107: aload 13
    //   109: ldc_w 528
    //   112: iload 8
    //   114: invokestatic 968	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokeinterface 956 3 0
    //   122: pop
    //   123: aload 11
    //   125: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +275 -> 403
    //   131: new 621	org/json/JSONArray
    //   134: dup
    //   135: aload 11
    //   137: invokespecial 622	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   140: astore 4
    //   142: aload 4
    //   144: ifnonnull +574 -> 718
    //   147: new 621	org/json/JSONArray
    //   150: dup
    //   151: invokespecial 969	org/json/JSONArray:<init>	()V
    //   154: astore 4
    //   156: new 256	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 257	org/json/JSONObject:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: ldc_w 628
    //   170: ldc_w 971
    //   173: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload 7
    //   179: ldc_w 640
    //   182: invokestatic 974	com/tencent/mm/plugin/websearch/api/ai:anV	()Ljava/lang/String;
    //   185: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload 4
    //   191: aload 7
    //   193: invokevirtual 977	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   196: pop
    //   197: new 256	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 257	org/json/JSONObject:<init>	()V
    //   204: astore 7
    //   206: aload 7
    //   208: ldc_w 628
    //   211: ldc_w 979
    //   214: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 7
    //   220: ldc_w 640
    //   223: iconst_1
    //   224: invokevirtual 982	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 4
    //   230: aload 7
    //   232: invokevirtual 977	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   235: pop
    //   236: new 256	org/json/JSONObject
    //   239: dup
    //   240: invokespecial 257	org/json/JSONObject:<init>	()V
    //   243: astore 7
    //   245: aload 7
    //   247: ldc_w 628
    //   250: ldc_w 548
    //   253: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 7
    //   259: ldc_w 640
    //   262: aload_1
    //   263: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload 4
    //   269: aload 7
    //   271: invokevirtual 977	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   274: pop
    //   275: new 256	org/json/JSONObject
    //   278: dup
    //   279: invokespecial 257	org/json/JSONObject:<init>	()V
    //   282: astore 7
    //   284: aload 7
    //   286: ldc_w 628
    //   289: ldc_w 984
    //   292: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload 7
    //   298: ldc_w 640
    //   301: aload 6
    //   303: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload 4
    //   309: aload 7
    //   311: invokevirtual 977	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   314: pop
    //   315: aload 12
    //   317: ifnull +113 -> 430
    //   320: aload 12
    //   322: ldc_w 986
    //   325: invokeinterface 736 2 0
    //   330: checkcast 321	java/lang/String
    //   333: astore 6
    //   335: aload 6
    //   337: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +90 -> 430
    //   343: new 621	org/json/JSONArray
    //   346: dup
    //   347: aload 6
    //   349: invokestatic 990	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokespecial 622	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   355: astore 6
    //   357: iconst_0
    //   358: istore 5
    //   360: iload 5
    //   362: aload 6
    //   364: invokevirtual 623	org/json/JSONArray:length	()I
    //   367: if_icmpge +63 -> 430
    //   370: aload 6
    //   372: iload 5
    //   374: invokevirtual 701	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   377: astore 7
    //   379: aload 7
    //   381: ifnull +11 -> 392
    //   384: aload 4
    //   386: aload 7
    //   388: invokevirtual 977	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   391: pop
    //   392: iload 5
    //   394: iconst_1
    //   395: iadd
    //   396: istore 5
    //   398: goto -38 -> 360
    //   401: astore 4
    //   403: aconst_null
    //   404: astore 4
    //   406: goto -264 -> 142
    //   409: astore 6
    //   411: ldc 128
    //   413: aload 6
    //   415: ldc_w 404
    //   418: iconst_0
    //   419: anewarray 4	java/lang/Object
    //   422: invokestatic 646	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: goto -110 -> 315
    //   428: astore 6
    //   430: aload 13
    //   432: ldc_w 619
    //   435: aload 4
    //   437: invokevirtual 991	org/json/JSONArray:toString	()Ljava/lang/String;
    //   440: invokeinterface 956 3 0
    //   445: pop
    //   446: aload 13
    //   448: ldc_w 518
    //   451: aload_2
    //   452: invokeinterface 956 3 0
    //   457: pop
    //   458: aload 13
    //   460: ldc_w 553
    //   463: aload_3
    //   464: invokeinterface 956 3 0
    //   469: pop
    //   470: aload 13
    //   472: ldc_w 548
    //   475: aload_1
    //   476: invokeinterface 956 3 0
    //   481: pop
    //   482: aload 12
    //   484: ifnull +12 -> 496
    //   487: aload 13
    //   489: aload 12
    //   491: invokeinterface 995 2 0
    //   496: aload_0
    //   497: aload 13
    //   499: invokespecial 167	com/tencent/mm/plugin/webview/fts/j:bJ	(Ljava/util/Map;)Lcom/tencent/mm/plugin/websearch/api/v;
    //   502: astore_3
    //   503: iload 9
    //   505: iconst_1
    //   506: if_icmpeq +9 -> 515
    //   509: iload 9
    //   511: iconst_2
    //   512: if_icmpne +9 -> 521
    //   515: aload_3
    //   516: iload 9
    //   518: putfield 878	com/tencent/mm/plugin/websearch/api/v:Pyn	I
    //   521: aload 10
    //   523: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifne +183 -> 709
    //   529: aload 10
    //   531: invokestatic 996	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   534: astore_2
    //   535: aload_3
    //   536: aload_2
    //   537: putfield 888	com/tencent/mm/plugin/websearch/api/v:fwv	Ljava/lang/String;
    //   540: aload_2
    //   541: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   544: ifne +134 -> 678
    //   547: iload 9
    //   549: iconst_2
    //   550: if_icmpne +128 -> 678
    //   553: ldc 128
    //   555: ldc_w 998
    //   558: iconst_1
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_1
    //   565: aastore
    //   566: invokestatic 851	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   569: new 461	com/tencent/mm/plugin/websearch/api/v
    //   572: dup
    //   573: invokespecial 462	com/tencent/mm/plugin/websearch/api/v:<init>	()V
    //   576: astore 4
    //   578: aload 4
    //   580: iconst_0
    //   581: putfield 482	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   584: aload 4
    //   586: aload_1
    //   587: putfield 551	com/tencent/mm/plugin/websearch/api/v:fIY	Ljava/lang/String;
    //   590: aload 4
    //   592: iload 9
    //   594: putfield 878	com/tencent/mm/plugin/websearch/api/v:Pyn	I
    //   597: aload 4
    //   599: aload_2
    //   600: putfield 888	com/tencent/mm/plugin/websearch/api/v:fwv	Ljava/lang/String;
    //   603: new 256	org/json/JSONObject
    //   606: dup
    //   607: invokespecial 257	org/json/JSONObject:<init>	()V
    //   610: astore_2
    //   611: aload_2
    //   612: ldc_w 1000
    //   615: ldc_w 1002
    //   618: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   621: pop
    //   622: aload_2
    //   623: ldc_w 1004
    //   626: aload 4
    //   628: getfield 888	com/tencent/mm/plugin/websearch/api/v:fwv	Ljava/lang/String;
    //   631: invokevirtual 263	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   634: pop
    //   635: aload 4
    //   637: aload_2
    //   638: invokevirtual 1005	org/json/JSONObject:toString	()Ljava/lang/String;
    //   641: putfield 1006	com/tencent/mm/plugin/websearch/api/v:content	Ljava/lang/String;
    //   644: aload 4
    //   646: getfield 1006	com/tencent/mm/plugin/websearch/api/v:content	Ljava/lang/String;
    //   649: astore_2
    //   650: aload_0
    //   651: getfield 158	com/tencent/mm/plugin/webview/fts/j:PLD	Lcom/tencent/mm/plugin/webview/fts/h;
    //   654: iconst_0
    //   655: aload_2
    //   656: invokevirtual 1010	com/tencent/mm/plugin/webview/fts/h:t	(ILjava/lang/Object;)V
    //   659: new 1012	com/tencent/mm/plugin/websearch/api/aa
    //   662: dup
    //   663: aload 4
    //   665: invokespecial 1015	com/tencent/mm/plugin/websearch/api/aa:<init>	(Lcom/tencent/mm/plugin/websearch/api/v;)V
    //   668: astore_2
    //   669: invokestatic 1019	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   672: aload_2
    //   673: iconst_0
    //   674: invokevirtual 1024	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   677: pop
    //   678: aload_3
    //   679: iconst_1
    //   680: putfield 1027	com/tencent/mm/plugin/websearch/api/v:Pyl	Z
    //   683: aload_0
    //   684: getfield 158	com/tencent/mm/plugin/webview/fts/j:PLD	Lcom/tencent/mm/plugin/webview/fts/h;
    //   687: iconst_1
    //   688: aload_1
    //   689: invokevirtual 1010	com/tencent/mm/plugin/webview/fts/h:t	(ILjava/lang/Object;)V
    //   692: aload_0
    //   693: getfield 117	com/tencent/mm/plugin/webview/fts/j:PLE	Lcom/tencent/mm/plugin/webview/fts/j$b;
    //   696: aload_3
    //   697: invokevirtual 1029	com/tencent/mm/plugin/webview/fts/j$b:b	(Lcom/tencent/mm/plugin/websearch/api/v;)V
    //   700: ldc_w 947
    //   703: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   706: iconst_0
    //   707: ireturn
    //   708: astore_2
    //   709: aconst_null
    //   710: astore_2
    //   711: goto -171 -> 540
    //   714: astore_2
    //   715: goto -37 -> 678
    //   718: goto -562 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	j
    //   0	721	1	paramString1	String
    //   0	721	2	paramString2	String
    //   0	721	3	paramString3	String
    //   0	721	4	paramString4	String
    //   0	721	5	paramInt1	int
    //   0	721	6	paramString5	String
    //   0	721	7	paramString6	String
    //   0	721	8	paramInt2	int
    //   0	721	9	paramInt3	int
    //   0	721	10	paramString7	String
    //   0	721	11	paramString8	String
    //   0	721	12	paramMap	Map<String, String>
    //   21	477	13	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   131	142	401	java/lang/Throwable
    //   156	315	409	org/json/JSONException
    //   343	357	428	java/lang/Throwable
    //   360	379	428	java/lang/Throwable
    //   384	392	428	java/lang/Throwable
    //   529	540	708	java/lang/Throwable
    //   611	678	714	java/lang/Throwable
  }
  
  public final boolean bH(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77961);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    String str = ai.aa(paramMap, "requestId");
    if (!ai.ab(paramMap, "isBackButtonClick")) {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(i).d(ai.b(paramMap, "type", 0), ai.aa(paramMap, "query"), paramMap);
    }
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s,wid: %s,rid: %s", new Object[] { paramMap.toString(), Integer.valueOf(i), str });
    this.PLD.a(1, str, Integer.valueOf(i), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77954);
        v localv = j.a(j.this, paramMap);
        j.b(j.this).b(localv);
        AppMethodBeat.o(77954);
      }
    }, this.PKf);
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean bK(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new v();
    ((v)localObject).fwe = ai.aa(paramMap, "query");
    try
    {
      ((v)localObject).fwe = URLDecoder.decode(((v)localObject).fwe, "UTF-8");
      label59:
      ((v)localObject).businessType = ai.b(paramMap, "type", 0);
      ((v)localObject).scene = ai.b(paramMap, "scene", 0);
      int i;
      if (ai.ab(paramMap, "isHomePage"))
      {
        i = 1;
        ((v)localObject).PxU = i;
        ((v)localObject).fPp = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        ((v)localObject).PxZ.add(ai.aa(paramMap, "prefixQuery"));
        i = ai.b(paramMap, "requestType", 0);
        ((v)localObject).BHR = ai.b(paramMap, "subtype", 0);
        ((v)localObject).Pyg = ai.b(paramMap, "isWeAppMore", 0);
        if (((v)localObject).Pyg == 1)
        {
          ((v)localObject).Pyh = new fpm();
          ((v)localObject).Pyh.RSO = ai.anh(3);
          ((v)localObject).Pyh.UNh = com.tencent.mm.modelappbrand.b.lyp;
          ((v)localObject).Pyh.SbT = ai.b(paramMap, "subType", 0);
          ((v)localObject).Pyh.session_id = com.tencent.mm.modelappbrand.b.lyo;
          paramMap = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Voo, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((v)localObject).Pyh.Uam = ((String)paramMap);
          }
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((v)localObject).fPp) });
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
          paramMap = this.PLF;
          if (paramMap.PLM != null)
          {
            com.tencent.mm.kernel.h.aGY().b(paramMap.PLM.getType(), paramMap.PLG);
            com.tencent.mm.kernel.h.aGY().a(paramMap.PLM);
            paramMap.PLM = null;
          }
          if (paramMap.PLM == null)
          {
            paramMap.PLM = new g((v)localObject);
            com.tencent.mm.kernel.h.aGY().a(paramMap.PLM.getType(), paramMap.PLG);
            com.tencent.mm.kernel.h.aGY().a(paramMap.PLM, 0);
            continue;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((v)localObject).fPp).biX(al.gQS());
          }
        }
        str = ((v)localObject).fwe;
        i = ((v)localObject).businessType;
        j = ((v)localObject).fPp;
      } while (Util.isNullOrNil(str));
      if (this.BIV != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.BIV);
        this.BIV = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.j();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).nRn = 16;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIP = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIR = 5;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIT = com.tencent.mm.plugin.fts.a.c.b.BJu;
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIS = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.j)localObject).BIU = this.GXs;
        this.BIV = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.j)localObject);
        this.BIV.BHN = Integer.valueOf(j);
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
  
  public final h gTv()
  {
    return this.PLD;
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
        com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
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
        a(paramString.gQm(), paramq, paramString.gQn(), paramString.gQr(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramq = paramString.gQp();
        paramInt1 = paramString.gQq();
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.gQm(), paramq, paramString.gQn(), paramString.gQr(), paramString.gQo());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.k.a.a.b.hii();
          com.tencent.mm.pluginsdk.k.a.a.b.apP(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.h.aGY().b(paramq.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramq;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramString.gQm()).biX("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramq = paramString.gQp();
          com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(paramString.gQm()).biX(paramq);
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
  
  static final class a
  {
    int PKO;
    boolean PLJ;
    String data;
    Bundle fHg;
    String fPt;
    
    public a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
    {
      this.PKO = paramInt;
      this.data = paramString1;
      this.PLJ = paramBoolean;
      this.fPt = paramString2;
      this.fHg = paramBundle;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221709);
      String str = "NetReqResult{webviewId=" + this.PKO + ", data='" + this.data + '\'' + ", isNewQuery=" + this.PLJ + ", reqId='" + this.fPt + '\'' + ", extData=" + this.fHg + '}';
      AppMethodBeat.o(221709);
      return str;
    }
  }
  
  public final class b
    implements Comparable
  {
    public a PLK;
    public com.tencent.mm.plugin.websearch.api.a PLu;
    private ThreadPoolExecutor fov;
    
    private b()
    {
      AppMethodBeat.i(77957);
      this.fov = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void b(v paramv)
    {
      AppMethodBeat.i(77958);
      if (this.PLK != null) {
        this.PLK.aFI = true;
      }
      this.PLK = new a((byte)0);
      this.PLK.PxJ = paramv;
      j.a(j.this, paramv);
      this.fov.execute(this.PLK);
      AppMethodBeat.o(77958);
    }
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      v PxJ;
      public volatile boolean aFI;
      
      private a() {}
      
      public final void run()
      {
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if ((Util.isNullOrNil(this.PxJ.fwe)) && (this.PxJ.Pyn != 2))
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.PxJ.businessType), Integer.valueOf(this.PxJ.scene), Integer.valueOf(this.PxJ.PxU), Integer.valueOf(this.PxJ.fPw), this.PxJ.uMC, Integer.valueOf(this.PxJ.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.PxJ.scene)
        {
        }
        for (;;)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.PxJ.fwe, Integer.valueOf(this.PxJ.fPp) });
          if (j.b.a(j.b.this) != null) {
            com.tencent.mm.kernel.h.aGY().a(j.b.a(j.b.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.PxJ.PxV != null)
          {
            localObject = localLinkedList;
            if (!this.PxJ.PxV.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (j.aH(this.PxJ.fwe, this.PxJ.scene, this.PxJ.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.b.a.e)j.a(j.this).biZ(this.PxJ.fwe);
              l = System.currentTimeMillis() - l;
              Log.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.h.IzE.a(14717, new Object[] { this.PxJ.fwe, Integer.valueOf(ab.bee()), Integer.valueOf(((com.tencent.mm.plugin.websearch.b.a.e)localObject).pWR.size()), Long.valueOf(l), Integer.valueOf(this.PxJ.scene) });
            }
          }
          if (this.aFI)
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.PxJ.fwe);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label489:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.PxJ.fwe + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.f.gWq().PKu.x(this.PxJ.scene, this.PxJ.fwe, this.PxJ.businessType);
            j.b.a(j.b.this, j.b.c(this.PxJ));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.b.a.e)localObject).pWR).iterator();
              while (((Iterator)localObject).hasNext())
              {
                com.tencent.mm.plugin.websearch.b.a.e.a locala = (com.tencent.mm.plugin.websearch.b.a.e.a)((Iterator)localObject).next();
                ezc localezc = new ezc();
                localezc.UserName = locala.userName;
                localezc.UzH = locala.PAT;
                localezc.rWI = locala.nickName;
                localezc.Sqe = locala.remark;
                localezc.mVD = locala.idS;
                localezc.RIC = locala.desc;
                localLinkedList.add(localezc);
              }
              j.b.a(j.b.this).bV(localLinkedList);
            }
            com.tencent.mm.kernel.h.aGY().a(j.b.a(j.b.this).getType(), j.this);
            com.tencent.mm.kernel.h.aGY().a(j.b.a(j.b.this), 0);
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
  
  public final class c
  {
    public com.tencent.mm.plugin.websearch.api.b PLM;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j
 * JD-Core Version:    0.7.0.1
 */