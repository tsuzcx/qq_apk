package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.g.a;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.c.a.e.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.protocal.protobuf.ewd;
import com.tencent.mm.protocal.protobuf.fvd;
import com.tencent.mm.protocal.protobuf.ghx;
import com.tencent.mm.protocal.protobuf.gmm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
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
  implements com.tencent.mm.am.h
{
  static final long WBs;
  private static MultiProcessMMKV eMf;
  public com.tencent.mm.plugin.fts.a.a.c HtE;
  private com.tencent.mm.plugin.fts.a.l MVp;
  h.a WAw;
  public IListener WBC;
  public int WBK;
  public ghx WBL;
  public Map<String, Integer> WBM;
  long WBN;
  public IListener WBO;
  private com.tencent.mm.plugin.websearch.c.a.c WBP;
  public final h WBQ;
  public b WBR;
  public c WBS;
  public final MMHandler WBt;
  private volatile w WBz;
  public ghx Wop;
  
  static
  {
    AppMethodBeat.i(77974);
    WBs = com.tencent.mm.ui.e.jhM() + 500;
    AppMethodBeat.o(77974);
  }
  
  public j()
  {
    AppMethodBeat.i(77960);
    this.WBK = 0;
    this.WBM = new HashMap();
    this.WBC = new WebSearchLogic.1(this, com.tencent.mm.app.f.hfK);
    this.WBO = new WebSearchLogic.2(this, com.tencent.mm.app.f.hfK);
    this.WBP = new com.tencent.mm.plugin.websearch.c.a.b();
    this.WBR = new b((byte)0);
    this.WAw = new h.a()
    {
      public final void handleCallback(h.b paramAnonymousb)
      {
        AppMethodBeat.i(295565);
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "handleCallback %s", new Object[] { paramAnonymousb });
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(295565);
          return;
        }
        int i = ((Integer)paramAnonymousb.WBq).intValue();
        paramAnonymousb = (j.a)paramAnonymousb.WBr;
        if (paramAnonymousb == null)
        {
          AppMethodBeat.o(295565);
          return;
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[] { Integer.valueOf(i), paramAnonymousb.hVo, j.c(j.this) });
        k.auP(i).b(paramAnonymousb.data, paramAnonymousb.WBW, paramAnonymousb.hVo, paramAnonymousb.hMD);
        AppMethodBeat.o(295565);
      }
    };
    this.WBS = new c((byte)0);
    this.MVp = new com.tencent.mm.plugin.fts.a.l()
    {
      public final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(295559);
        switch (paramAnonymousm.resultCode)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(295559);
          return;
          if ((paramAnonymousm.HtF == null) || (paramAnonymousm.HtF.size() == 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "local contact search size 0");
            k.auP(((Integer)j.d(j.this).Hsv).intValue()).biN("");
            AppMethodBeat.o(295559);
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
            Iterator localIterator = paramAnonymousm.HtF.iterator();
            while (localIterator.hasNext())
            {
              o localo = (o)localIterator.next();
              if (localo.type == 131072) {
                localJSONArray2.put(j.a(localo, paramAnonymousm.FWt));
              }
            }
            localJSONObject2.put("items", localJSONArray2);
          }
          catch (Exception paramAnonymousm)
          {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchLogic", paramAnonymousm, "onSearchDone", new Object[0]);
            AppMethodBeat.o(295559);
            return;
          }
          localJSONObject2.put("title", MMApplicationContext.getContext().getString(c.i.fts_on_suggest_sns_title));
          localJSONObject2.put("count", localJSONArray2.length());
          localJSONObject2.put("type", 3);
          localJSONArray1.put(localJSONObject2);
          localJSONObject1.put("data", localJSONArray1);
          localJSONObject1.put("ret", 0);
          k.auP(((Integer)j.d(j.this).Hsv).intValue()).biN(localJSONObject1.toString());
          AppMethodBeat.o(295559);
          return;
          k.auP(((Integer)j.d(j.this).Hsv).intValue()).biN("");
        }
      }
    };
    Log.d("MicroMsg.WebSearch.WebSearchLogic", "create WebSearchLogic");
    this.WBC.alive();
    this.WBO.alive();
    this.WBt = new MMHandler("WebSearchLogic_worker");
    this.WBQ = new h(this.WBt);
    AppMethodBeat.o(77960);
  }
  
  public static final JSONObject a(o paramo, com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(77971);
    Object localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramo.Hsz);
    Object localObject3 = d.atS(paramo.Hsz);
    boolean bool2;
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    switch (paramo.subtype)
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
          localObject3 = com.tencent.mm.plugin.fts.a.a.g.a((CharSequence)localObject3, paramj, bool1, bool2);
          ((com.tencent.mm.plugin.fts.a.a.g)localObject3).HsJ = g.a.HsS;
          ((com.tencent.mm.plugin.fts.a.a.g)localObject3).HsO = "<em class=\"highlight\">";
          ((com.tencent.mm.plugin.fts.a.a.g)localObject3).HsP = "</em>";
          localObject3 = com.tencent.mm.plugin.fts.a.f.a((com.tencent.mm.plugin.fts.a.a.g)localObject3).HsX.toString();
          label197:
          if (i != 0)
          {
            paramj = com.tencent.mm.plugin.fts.a.a.g.a((CharSequence)localObject1, paramj, bool1, bool2);
            paramj.HsJ = g.a.HsS;
            paramj.HsO = "<em class=\"highlight\">";
            paramj.HsP = "</em>";
            paramj = com.tencent.mm.plugin.fts.a.f.a(paramj).HsX.toString();
            paramj = (String)localObject2 + paramj;
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("nickName", d.atS(paramo.Hsz));
              ((JSONObject)localObject1).put("userName", paramo.Hsz);
              if (j != 0) {
                ((JSONObject)localObject1).put("nickNameHighlight", localObject3);
              }
              if (i != 0) {
                ((JSONObject)localObject1).put("extraHighlight", paramj);
              }
            }
            catch (JSONException paramo)
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
      localObject1 = ((az)localObject4).field_nickname;
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_nickname);
      i = 1;
      j = 0;
      break;
      localObject1 = ((az)localObject4).kal;
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_description);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject2 = ((au)localObject4).aJs();
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((az)localObject4).field_username;
      }
      localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_wxid);
      bool2 = false;
      bool1 = false;
      i = 1;
      j = 0;
      break;
      localObject1 = paramo.content;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject4 = ((String)localObject1).split("​");
        j = localObject4.length;
        i = 0;
        label500:
        if (i < j)
        {
          localObject2 = localObject4[i];
          if (((String)localObject2).startsWith(paramj.Hte)) {
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
        localObject1 = paramo.content;
        localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_province);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = paramo.content;
        localObject2 = MMApplicationContext.getContext().getString(c.i.search_contact_tag_city);
        bool2 = false;
        bool1 = false;
        i = 1;
        j = 0;
        break;
        localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aEd(((az)localObject4).field_contactLabelIds);
        localObject2 = new StringBuffer();
        localObject4 = paramj.Htg;
        j = localObject4.length;
        i = 0;
        while (i < j)
        {
          CharSequence localCharSequence = localObject4[i];
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (d.aEh(str).contains(localCharSequence))
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
        paramj = (com.tencent.mm.plugin.fts.a.a.j)localObject1;
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
    this.WBQ.a(1, paramString2, paramString1, this.WAw);
    AppMethodBeat.o(77969);
  }
  
  static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(295620);
    if (eMf == null) {
      eMf = MultiProcessMMKV.getMMKV("WebSearchLogic", 2);
    }
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    AppMethodBeat.o(295620);
    return localMultiProcessMMKV;
  }
  
  /* Error */
  private w cd(Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc_w 462
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 464
    //   10: iconst_0
    //   11: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   14: istore_2
    //   15: new 469	com/tencent/mm/plugin/websearch/api/w
    //   18: dup
    //   19: invokespecial 470	com/tencent/mm/plugin/websearch/api/w:<init>	()V
    //   22: astore 4
    //   24: aload 4
    //   26: aload_1
    //   27: ldc_w 472
    //   30: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   33: putfield 479	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   36: aload 4
    //   38: aload_1
    //   39: ldc_w 481
    //   42: iconst_0
    //   43: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   46: putfield 483	com/tencent/mm/plugin/websearch/api/w:offset	I
    //   49: aload 4
    //   51: aload_1
    //   52: ldc_w 485
    //   55: iconst_0
    //   56: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   59: putfield 488	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   62: aload 4
    //   64: iload_2
    //   65: putfield 490	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   68: aload 4
    //   70: aload_1
    //   71: ldc_w 492
    //   74: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   77: putfield 495	com/tencent/mm/plugin/websearch/api/w:Wod	Ljava/lang/String;
    //   80: aload 4
    //   82: aload_1
    //   83: ldc_w 497
    //   86: iconst_0
    //   87: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   90: putfield 500	com/tencent/mm/plugin/websearch/api/w:Wof	I
    //   93: aload 4
    //   95: aload_1
    //   96: ldc_w 502
    //   99: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 505	com/tencent/mm/plugin/websearch/api/w:Woe	Ljava/lang/String;
    //   105: aload 4
    //   107: aload_1
    //   108: ldc_w 507
    //   111: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 510	com/tencent/mm/plugin/websearch/api/w:Woq	Ljava/lang/String;
    //   117: aload_1
    //   118: ldc_w 512
    //   121: invokestatic 516	com/tencent/mm/plugin/websearch/api/aj:av	(Ljava/util/Map;Ljava/lang/String;)Z
    //   124: ifeq +422 -> 546
    //   127: iconst_1
    //   128: istore_2
    //   129: aload 4
    //   131: iload_2
    //   132: putfield 519	com/tencent/mm/plugin/websearch/api/w:Wob	I
    //   135: aload 4
    //   137: aload_1
    //   138: ldc_w 521
    //   141: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 524	com/tencent/mm/plugin/websearch/api/w:xVe	Ljava/lang/String;
    //   147: aload_1
    //   148: ldc_w 526
    //   151: invokeinterface 532 2 0
    //   156: ifeq +15 -> 171
    //   159: aload 4
    //   161: aload_1
    //   162: ldc_w 526
    //   165: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 534	com/tencent/mm/plugin/websearch/api/w:sessionId	Ljava/lang/String;
    //   171: aload 4
    //   173: aload_1
    //   174: ldc_w 536
    //   177: iconst_1
    //   178: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   181: putfield 539	com/tencent/mm/plugin/websearch/api/w:hVr	I
    //   184: aload 4
    //   186: aload_1
    //   187: ldc_w 541
    //   190: iconst_2
    //   191: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   194: putfield 544	com/tencent/mm/plugin/websearch/api/w:Woh	I
    //   197: aload 4
    //   199: aload_1
    //   200: ldc_w 546
    //   203: iconst_0
    //   204: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   207: putfield 549	com/tencent/mm/plugin/websearch/api/w:Woi	I
    //   210: aload 4
    //   212: aload_1
    //   213: ldc_w 551
    //   216: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 554	com/tencent/mm/plugin/websearch/api/w:Woj	Ljava/lang/String;
    //   222: aload 4
    //   224: aload_1
    //   225: ldc_w 556
    //   228: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   231: putfield 559	com/tencent/mm/plugin/websearch/api/w:hOG	Ljava/lang/String;
    //   234: aload 4
    //   236: aload_1
    //   237: ldc_w 526
    //   240: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   243: putfield 534	com/tencent/mm/plugin/websearch/api/w:sessionId	Ljava/lang/String;
    //   246: aload 4
    //   248: aload_1
    //   249: ldc_w 561
    //   252: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 564	com/tencent/mm/plugin/websearch/api/w:hVn	Ljava/lang/String;
    //   258: aload 4
    //   260: aload_1
    //   261: ldc_w 566
    //   264: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   267: putfield 569	com/tencent/mm/plugin/websearch/api/w:Wor	Ljava/lang/String;
    //   270: aload 4
    //   272: aload_1
    //   273: ldc_w 571
    //   276: invokestatic 516	com/tencent/mm/plugin/websearch/api/aj:av	(Ljava/util/Map;Ljava/lang/String;)Z
    //   279: putfield 575	com/tencent/mm/plugin/websearch/api/w:Wov	Z
    //   282: aload_1
    //   283: ldc_w 577
    //   286: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   289: astore_3
    //   290: new 265	org/json/JSONObject
    //   293: dup
    //   294: aload_3
    //   295: ldc_w 579
    //   298: invokestatic 585	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   301: invokespecial 586	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   304: astore 5
    //   306: aload 4
    //   308: aload 5
    //   310: ldc_w 588
    //   313: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   316: putfield 594	com/tencent/mm/plugin/websearch/api/w:Woy	Ljava/lang/String;
    //   319: aload 4
    //   321: aload 5
    //   323: ldc_w 596
    //   326: invokevirtual 600	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   329: putfield 603	com/tencent/mm/plugin/websearch/api/w:Woz	I
    //   332: aload 5
    //   334: ldc_w 605
    //   337: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: astore_3
    //   341: aload 5
    //   343: ldc_w 607
    //   346: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore 5
    //   351: aload_3
    //   352: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   355: ifne +76 -> 431
    //   358: aload 5
    //   360: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   363: ifne +68 -> 431
    //   366: new 609	com/tencent/mm/protocal/protobuf/aem
    //   369: dup
    //   370: invokespecial 610	com/tencent/mm/protocal/protobuf/aem:<init>	()V
    //   373: astore 6
    //   375: aload 6
    //   377: ldc_w 605
    //   380: putfield 613	com/tencent/mm/protocal/protobuf/aem:key	Ljava/lang/String;
    //   383: aload 6
    //   385: aload_3
    //   386: putfield 616	com/tencent/mm/protocal/protobuf/aem:Zmy	Ljava/lang/String;
    //   389: new 609	com/tencent/mm/protocal/protobuf/aem
    //   392: dup
    //   393: invokespecial 610	com/tencent/mm/protocal/protobuf/aem:<init>	()V
    //   396: astore_3
    //   397: aload_3
    //   398: ldc_w 607
    //   401: putfield 613	com/tencent/mm/protocal/protobuf/aem:key	Ljava/lang/String;
    //   404: aload_3
    //   405: aload 5
    //   407: putfield 616	com/tencent/mm/protocal/protobuf/aem:Zmy	Ljava/lang/String;
    //   410: aload 4
    //   412: getfield 620	com/tencent/mm/plugin/websearch/api/w:Wol	Ljava/util/LinkedList;
    //   415: aload 6
    //   417: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   420: pop
    //   421: aload 4
    //   423: getfield 620	com/tencent/mm/plugin/websearch/api/w:Wol	Ljava/util/LinkedList;
    //   426: aload_3
    //   427: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   430: pop
    //   431: aload_1
    //   432: ldc_w 627
    //   435: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   438: astore_3
    //   439: aload_3
    //   440: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   443: ifne +122 -> 565
    //   446: new 629	org/json/JSONArray
    //   449: dup
    //   450: aload_3
    //   451: invokespecial 630	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   454: astore_3
    //   455: iconst_0
    //   456: istore_2
    //   457: iload_2
    //   458: aload_3
    //   459: invokevirtual 631	org/json/JSONArray:length	()I
    //   462: if_icmpge +103 -> 565
    //   465: aload_3
    //   466: iload_2
    //   467: invokevirtual 635	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   470: astore 5
    //   472: new 609	com/tencent/mm/protocal/protobuf/aem
    //   475: dup
    //   476: invokespecial 610	com/tencent/mm/protocal/protobuf/aem:<init>	()V
    //   479: astore 6
    //   481: aload 6
    //   483: aload 5
    //   485: ldc_w 636
    //   488: ldc_w 413
    //   491: invokevirtual 638	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   494: putfield 613	com/tencent/mm/protocal/protobuf/aem:key	Ljava/lang/String;
    //   497: aload 6
    //   499: aload 5
    //   501: ldc_w 640
    //   504: iconst_0
    //   505: invokevirtual 643	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   508: i2l
    //   509: putfield 646	com/tencent/mm/protocal/protobuf/aem:Zmx	J
    //   512: aload 6
    //   514: aload 5
    //   516: ldc_w 648
    //   519: ldc_w 413
    //   522: invokevirtual 638	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   525: putfield 616	com/tencent/mm/protocal/protobuf/aem:Zmy	Ljava/lang/String;
    //   528: aload 4
    //   530: getfield 620	com/tencent/mm/plugin/websearch/api/w:Wol	Ljava/util/LinkedList;
    //   533: aload 6
    //   535: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   538: pop
    //   539: iload_2
    //   540: iconst_1
    //   541: iadd
    //   542: istore_2
    //   543: goto -86 -> 457
    //   546: iconst_0
    //   547: istore_2
    //   548: goto -419 -> 129
    //   551: astore_3
    //   552: ldc 138
    //   554: aload_3
    //   555: ldc_w 650
    //   558: iconst_0
    //   559: anewarray 4	java/lang/Object
    //   562: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: aload_1
    //   566: ldc_w 656
    //   569: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   572: astore_3
    //   573: aload_3
    //   574: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   577: ifne +67 -> 644
    //   580: new 265	org/json/JSONObject
    //   583: dup
    //   584: aload_3
    //   585: invokespecial 586	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   588: astore_3
    //   589: new 658	com/tencent/mm/protocal/protobuf/fvd
    //   592: dup
    //   593: invokespecial 659	com/tencent/mm/protocal/protobuf/fvd:<init>	()V
    //   596: astore 5
    //   598: aload 5
    //   600: aload_3
    //   601: ldc_w 274
    //   604: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   607: putfield 662	com/tencent/mm/protocal/protobuf/fvd:UserName	Ljava/lang/String;
    //   610: aload 5
    //   612: aload_3
    //   613: ldc_w 664
    //   616: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   619: putfield 667	com/tencent/mm/protocal/protobuf/fvd:abTC	Ljava/lang/String;
    //   622: aload 5
    //   624: getfield 662	com/tencent/mm/protocal/protobuf/fvd:UserName	Ljava/lang/String;
    //   627: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   630: ifne +14 -> 644
    //   633: aload 4
    //   635: getfield 670	com/tencent/mm/plugin/websearch/api/w:Woc	Ljava/util/LinkedList;
    //   638: aload 5
    //   640: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   643: pop
    //   644: aload_1
    //   645: ldc_w 672
    //   648: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   651: astore_3
    //   652: aload_3
    //   653: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   656: ifne +78 -> 734
    //   659: new 629	org/json/JSONArray
    //   662: dup
    //   663: aload_3
    //   664: invokespecial 630	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   667: astore_3
    //   668: iconst_0
    //   669: istore_2
    //   670: iload_2
    //   671: aload_3
    //   672: invokevirtual 631	org/json/JSONArray:length	()I
    //   675: if_icmpge +59 -> 734
    //   678: aload_3
    //   679: iload_2
    //   680: invokevirtual 673	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   683: astore 5
    //   685: aload 4
    //   687: getfield 676	com/tencent/mm/plugin/websearch/api/w:Wog	Ljava/util/LinkedList;
    //   690: aload 5
    //   692: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   695: pop
    //   696: iload_2
    //   697: iconst_1
    //   698: iadd
    //   699: istore_2
    //   700: goto -30 -> 670
    //   703: astore_3
    //   704: ldc 138
    //   706: aload_3
    //   707: ldc_w 678
    //   710: iconst_0
    //   711: anewarray 4	java/lang/Object
    //   714: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: goto -73 -> 644
    //   720: astore_3
    //   721: ldc 138
    //   723: aload_3
    //   724: ldc_w 680
    //   727: iconst_0
    //   728: anewarray 4	java/lang/Object
    //   731: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   734: aload_1
    //   735: ldc_w 682
    //   738: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   741: astore_3
    //   742: aload_3
    //   743: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   746: ifne +69 -> 815
    //   749: new 265	org/json/JSONObject
    //   752: dup
    //   753: aload_3
    //   754: invokespecial 586	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   757: astore_3
    //   758: aload 4
    //   760: new 684	com/tencent/mm/protocal/protobuf/flq
    //   763: dup
    //   764: invokespecial 685	com/tencent/mm/protocal/protobuf/flq:<init>	()V
    //   767: putfield 689	com/tencent/mm/plugin/websearch/api/w:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   770: aload 4
    //   772: getfield 689	com/tencent/mm/plugin/websearch/api/w:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   775: aload_3
    //   776: ldc_w 691
    //   779: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   782: putfield 694	com/tencent/mm/protocal/protobuf/flq:abMd	Ljava/lang/String;
    //   785: aload 4
    //   787: getfield 689	com/tencent/mm/plugin/websearch/api/w:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   790: aload_3
    //   791: ldc_w 696
    //   794: invokevirtual 600	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   797: putfield 699	com/tencent/mm/protocal/protobuf/flq:abMc	I
    //   800: aload 4
    //   802: getfield 689	com/tencent/mm/plugin/websearch/api/w:Wok	Lcom/tencent/mm/protocal/protobuf/flq;
    //   805: aload_3
    //   806: ldc_w 701
    //   809: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   812: putfield 704	com/tencent/mm/protocal/protobuf/flq:abMe	Ljava/lang/String;
    //   815: aload_1
    //   816: ldc_w 706
    //   819: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   822: astore_3
    //   823: aload_3
    //   824: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   827: ifne +126 -> 953
    //   830: new 629	org/json/JSONArray
    //   833: dup
    //   834: aload_3
    //   835: invokespecial 630	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   838: astore_3
    //   839: iconst_0
    //   840: istore_2
    //   841: iload_2
    //   842: aload_3
    //   843: invokevirtual 631	org/json/JSONArray:length	()I
    //   846: if_icmpge +107 -> 953
    //   849: aload_3
    //   850: iload_2
    //   851: invokevirtual 709	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   854: astore 5
    //   856: new 711	com/tencent/mm/protocal/protobuf/duw
    //   859: dup
    //   860: invokespecial 712	com/tencent/mm/protocal/protobuf/duw:<init>	()V
    //   863: astore 6
    //   865: aload 6
    //   867: aload 5
    //   869: ldc_w 714
    //   872: invokevirtual 718	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   875: putfield 721	com/tencent/mm/protocal/protobuf/duw:abaM	J
    //   878: aload 6
    //   880: aload 5
    //   882: ldc_w 723
    //   885: invokevirtual 718	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   888: putfield 726	com/tencent/mm/protocal/protobuf/duw:abaN	J
    //   891: aload 6
    //   893: aload 5
    //   895: ldc_w 728
    //   898: invokevirtual 600	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   901: putfield 731	com/tencent/mm/protocal/protobuf/duw:abaL	I
    //   904: aload 4
    //   906: getfield 734	com/tencent/mm/plugin/websearch/api/w:Wom	Ljava/util/LinkedList;
    //   909: aload 6
    //   911: invokevirtual 625	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   914: pop
    //   915: iload_2
    //   916: iconst_1
    //   917: iadd
    //   918: istore_2
    //   919: goto -78 -> 841
    //   922: astore_3
    //   923: ldc 138
    //   925: aload_3
    //   926: ldc_w 736
    //   929: iconst_0
    //   930: anewarray 4	java/lang/Object
    //   933: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: goto -121 -> 815
    //   939: astore_3
    //   940: ldc 138
    //   942: aload_3
    //   943: ldc_w 738
    //   946: iconst_0
    //   947: anewarray 4	java/lang/Object
    //   950: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: aload 4
    //   955: aload_1
    //   956: ldc_w 740
    //   959: invokeinterface 744 2 0
    //   964: iconst_m1
    //   965: invokestatic 748	com/tencent/mm/sdk/platformtools/Util:nullAsInt	(Ljava/lang/Object;I)I
    //   968: putfield 751	com/tencent/mm/plugin/websearch/api/w:hVk	I
    //   971: aload 4
    //   973: invokestatic 289	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   976: invokestatic 757	com/tencent/mm/sdk/platformtools/LocaleUtil:getCurrentLanguage	(Landroid/content/Context;)Ljava/lang/String;
    //   979: putfield 760	com/tencent/mm/plugin/websearch/api/w:language	Ljava/lang/String;
    //   982: aload 4
    //   984: aload_1
    //   985: ldc_w 762
    //   988: iconst_0
    //   989: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   992: putfield 763	com/tencent/mm/plugin/websearch/api/w:subtype	I
    //   995: aload 4
    //   997: aload_1
    //   998: ldc_w 765
    //   1001: iconst_0
    //   1002: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1005: putfield 768	com/tencent/mm/plugin/websearch/api/w:Won	I
    //   1008: aload 4
    //   1010: getfield 768	com/tencent/mm/plugin/websearch/api/w:Won	I
    //   1013: iconst_1
    //   1014: if_icmpne +115 -> 1129
    //   1017: aload 4
    //   1019: new 770	com/tencent/mm/protocal/protobuf/gmm
    //   1022: dup
    //   1023: invokespecial 771	com/tencent/mm/protocal/protobuf/gmm:<init>	()V
    //   1026: putfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1029: aload 4
    //   1031: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1034: iconst_3
    //   1035: invokestatic 779	com/tencent/mm/plugin/websearch/api/aj:asY	(I)I
    //   1038: putfield 782	com/tencent/mm/protocal/protobuf/gmm:YQo	I
    //   1041: aload 4
    //   1043: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1046: getstatic 787	com/tencent/mm/modelappbrand/c:opQ	Ljava/lang/String;
    //   1049: putfield 790	com/tencent/mm/protocal/protobuf/gmm:achB	Ljava/lang/String;
    //   1052: aload 4
    //   1054: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1057: aload_1
    //   1058: ldc_w 762
    //   1061: iconst_0
    //   1062: invokestatic 467	com/tencent/mm/plugin/websearch/api/aj:c	(Ljava/util/Map;Ljava/lang/String;I)I
    //   1065: putfield 793	com/tencent/mm/protocal/protobuf/gmm:YZM	I
    //   1068: aload 4
    //   1070: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1073: getstatic 796	com/tencent/mm/modelappbrand/c:opP	Ljava/lang/String;
    //   1076: putfield 799	com/tencent/mm/protocal/protobuf/gmm:session_id	Ljava/lang/String;
    //   1079: aload 4
    //   1081: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1084: aload 4
    //   1086: getfield 549	com/tencent/mm/plugin/websearch/api/w:Woi	I
    //   1089: putfield 802	com/tencent/mm/protocal/protobuf/gmm:achC	I
    //   1092: invokestatic 806	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   1095: invokevirtual 812	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   1098: getstatic 818	com/tencent/mm/storage/at$a:acPK	Lcom/tencent/mm/storage/at$a;
    //   1101: aconst_null
    //   1102: invokevirtual 823	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1105: astore_3
    //   1106: aload_3
    //   1107: ifnull +22 -> 1129
    //   1110: aload_3
    //   1111: instanceof 330
    //   1114: ifeq +15 -> 1129
    //   1117: aload 4
    //   1119: getfield 775	com/tencent/mm/plugin/websearch/api/w:Woo	Lcom/tencent/mm/protocal/protobuf/gmm;
    //   1122: aload_3
    //   1123: checkcast 330	java/lang/String
    //   1126: putfield 826	com/tencent/mm/protocal/protobuf/gmm:abro	Ljava/lang/String;
    //   1129: aload_0
    //   1130: getfield 96	com/tencent/mm/plugin/webview/fts/j:WBK	I
    //   1133: iconst_1
    //   1134: if_icmpne +327 -> 1461
    //   1137: aload 4
    //   1139: aload_0
    //   1140: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1143: putfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1146: aload 4
    //   1148: getfield 479	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   1151: astore_3
    //   1152: invokestatic 835	com/tencent/mm/plugin/webview/fts/a/a/a:itg	()Lcom/tencent/mm/plugin/webview/fts/a/a/a;
    //   1155: pop
    //   1156: aload_3
    //   1157: invokestatic 839	com/tencent/mm/plugin/webview/fts/a/a/a:bjG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/fts/a/a/a/a;
    //   1160: astore_3
    //   1161: aload_3
    //   1162: ifnonnull +308 -> 1470
    //   1165: ldc_w 413
    //   1168: astore_3
    //   1169: aload_3
    //   1170: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1173: ifne +18 -> 1191
    //   1176: aload 4
    //   1178: aload_3
    //   1179: putfield 479	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   1182: aload 4
    //   1184: aload_0
    //   1185: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1188: putfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1191: aload 4
    //   1193: getfield 490	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   1196: bipush 33
    //   1198: if_icmpne +117 -> 1315
    //   1201: aload_0
    //   1202: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1205: ifnull +110 -> 1315
    //   1208: aload 4
    //   1210: getfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1213: ifnonnull +15 -> 1228
    //   1216: aload 4
    //   1218: new 843	com/tencent/mm/protocal/protobuf/ghx
    //   1221: dup
    //   1222: invokespecial 844	com/tencent/mm/protocal/protobuf/ghx:<init>	()V
    //   1225: putfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1228: aload 4
    //   1230: getfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1233: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1236: ifnonnull +18 -> 1254
    //   1239: aload 4
    //   1241: getfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1244: new 850	com/tencent/mm/protocal/protobuf/ry
    //   1247: dup
    //   1248: invokespecial 851	com/tencent/mm/protocal/protobuf/ry:<init>	()V
    //   1251: putfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1254: aload_0
    //   1255: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1258: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1261: ifnull +49 -> 1310
    //   1264: aload 4
    //   1266: getfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1269: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1272: aload_0
    //   1273: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1276: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1279: getfield 854	com/tencent/mm/protocal/protobuf/ry:YWS	Ljava/lang/String;
    //   1282: putfield 854	com/tencent/mm/protocal/protobuf/ry:YWS	Ljava/lang/String;
    //   1285: ldc 138
    //   1287: ldc_w 856
    //   1290: iconst_1
    //   1291: anewarray 4	java/lang/Object
    //   1294: dup
    //   1295: iconst_0
    //   1296: aload_0
    //   1297: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1300: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1303: getfield 854	com/tencent/mm/protocal/protobuf/ry:YWS	Ljava/lang/String;
    //   1306: aastore
    //   1307: invokestatic 859	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1310: aload_0
    //   1311: aconst_null
    //   1312: putfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1315: aload 4
    //   1317: getfield 488	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   1320: ldc_w 860
    //   1323: if_icmpne +74 -> 1397
    //   1326: aload_0
    //   1327: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1330: ifnull +67 -> 1397
    //   1333: aload_0
    //   1334: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1337: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1340: getfield 863	com/tencent/mm/protocal/protobuf/ry:YWP	I
    //   1343: iconst_1
    //   1344: if_icmpne +53 -> 1397
    //   1347: new 865	android/os/Bundle
    //   1350: dup
    //   1351: invokespecial 866	android/os/Bundle:<init>	()V
    //   1354: astore_3
    //   1355: aload_3
    //   1356: ldc_w 868
    //   1359: iconst_1
    //   1360: invokevirtual 872	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1363: aload_3
    //   1364: ldc_w 874
    //   1367: aload_1
    //   1368: ldc_w 874
    //   1371: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1374: invokevirtual 877	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1377: aload 4
    //   1379: aload_3
    //   1380: putfield 881	com/tencent/mm/plugin/websearch/api/w:OMx	Landroid/os/Bundle;
    //   1383: aload 4
    //   1385: aload_0
    //   1386: getfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1389: putfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1392: aload_0
    //   1393: aconst_null
    //   1394: putfield 841	com/tencent/mm/plugin/webview/fts/j:WBL	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1397: aload_1
    //   1398: ldc_w 883
    //   1401: invokestatic 476	com/tencent/mm/plugin/websearch/api/aj:au	(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   1404: astore_1
    //   1405: aload_1
    //   1406: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1409: ifne +43 -> 1452
    //   1412: new 265	org/json/JSONObject
    //   1415: dup
    //   1416: aload_1
    //   1417: invokespecial 586	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1420: astore_1
    //   1421: aload 4
    //   1423: aload_1
    //   1424: ldc_w 485
    //   1427: iconst_0
    //   1428: invokevirtual 643	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1431: putfield 886	com/tencent/mm/plugin/websearch/api/w:Wou	I
    //   1434: aload 4
    //   1436: aload_1
    //   1437: ldc_w 888
    //   1440: invokevirtual 891	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1443: ldc_w 893
    //   1446: invokevirtual 591	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1449: putfield 896	com/tencent/mm/plugin/websearch/api/w:hAT	Ljava/lang/String;
    //   1452: ldc_w 462
    //   1455: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1458: aload 4
    //   1460: areturn
    //   1461: aload 4
    //   1463: aconst_null
    //   1464: putfield 829	com/tencent/mm/plugin/websearch/api/w:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1467: goto -321 -> 1146
    //   1470: ldc 138
    //   1472: ldc_w 898
    //   1475: iconst_4
    //   1476: anewarray 4	java/lang/Object
    //   1479: dup
    //   1480: iconst_0
    //   1481: aload_3
    //   1482: getfield 903	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCe	Ljava/lang/String;
    //   1485: aastore
    //   1486: dup
    //   1487: iconst_1
    //   1488: aload_3
    //   1489: getfield 906	com/tencent/mm/plugin/webview/fts/a/a/a/a:appid	Ljava/lang/String;
    //   1492: aastore
    //   1493: dup
    //   1494: iconst_2
    //   1495: aload_3
    //   1496: getfield 909	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCc	Ljava/lang/String;
    //   1499: aastore
    //   1500: dup
    //   1501: iconst_3
    //   1502: aload_3
    //   1503: getfield 912	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCd	Ljava/lang/String;
    //   1506: aastore
    //   1507: invokestatic 859	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1510: aload_0
    //   1511: new 843	com/tencent/mm/protocal/protobuf/ghx
    //   1514: dup
    //   1515: invokespecial 844	com/tencent/mm/protocal/protobuf/ghx:<init>	()V
    //   1518: putfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1521: aload_0
    //   1522: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1525: lconst_1
    //   1526: putfield 915	com/tencent/mm/protocal/protobuf/ghx:aceo	J
    //   1529: aload_0
    //   1530: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1533: new 850	com/tencent/mm/protocal/protobuf/ry
    //   1536: dup
    //   1537: invokespecial 851	com/tencent/mm/protocal/protobuf/ry:<init>	()V
    //   1540: putfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1543: aload_0
    //   1544: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1547: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1550: aload_3
    //   1551: getfield 906	com/tencent/mm/plugin/webview/fts/a/a/a/a:appid	Ljava/lang/String;
    //   1554: putfield 916	com/tencent/mm/protocal/protobuf/ry:appid	Ljava/lang/String;
    //   1557: aload_0
    //   1558: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1561: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1564: aload_3
    //   1565: getfield 909	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCc	Ljava/lang/String;
    //   1568: invokestatic 919	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   1571: putfield 922	com/tencent/mm/protocal/protobuf/ry:Tqb	I
    //   1574: aload_0
    //   1575: getfield 828	com/tencent/mm/plugin/webview/fts/j:Wop	Lcom/tencent/mm/protocal/protobuf/ghx;
    //   1578: getfield 848	com/tencent/mm/protocal/protobuf/ghx:acep	Lcom/tencent/mm/protocal/protobuf/ry;
    //   1581: aload_3
    //   1582: getfield 912	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCd	Ljava/lang/String;
    //   1585: putfield 925	com/tencent/mm/protocal/protobuf/ry:xmx	Ljava/lang/String;
    //   1588: aload_3
    //   1589: getfield 903	com/tencent/mm/plugin/webview/fts/a/a/a/a:WCe	Ljava/lang/String;
    //   1592: astore_3
    //   1593: goto -424 -> 1169
    //   1596: astore_1
    //   1597: goto -145 -> 1452
    //   1600: astore_3
    //   1601: goto -1170 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1604	0	this	j
    //   0	1604	1	paramMap	Map<String, Object>
    //   14	905	2	i	int
    //   289	177	3	localObject1	Object
    //   551	4	3	localException1	Exception
    //   572	107	3	localObject2	Object
    //   703	4	3	localException2	Exception
    //   720	4	3	localException3	Exception
    //   741	109	3	localObject3	Object
    //   922	4	3	localException4	Exception
    //   939	4	3	localException5	Exception
    //   1105	488	3	localObject4	Object
    //   1600	1	3	localObject5	Object
    //   22	1440	4	localw	w
    //   304	590	5	localObject6	Object
    //   373	537	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   446	455	551	java/lang/Exception
    //   457	539	551	java/lang/Exception
    //   580	644	703	java/lang/Exception
    //   659	668	720	java/lang/Exception
    //   670	696	720	java/lang/Exception
    //   749	815	922	java/lang/Exception
    //   830	839	939	java/lang/Exception
    //   841	915	939	java/lang/Exception
    //   1412	1452	1596	java/lang/Exception
    //   290	431	1600	finally
  }
  
  public static void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(295616);
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
        MultiProcessMMKV localMultiProcessMMKV = aBP();
        localMultiProcessMMKV.encode("websearch_preget_extReqParams", paramString);
        localMultiProcessMMKV.encode("websearch_preget_version", aj.asY(0));
        AppMethodBeat.o(295616);
        return;
      }
      finally
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
    //   0: ldc_w 954
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 138
    //   8: ldc_w 956
    //   11: invokestatic 958	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 98	java/util/HashMap
    //   17: dup
    //   18: invokespecial 99	java/util/HashMap:<init>	()V
    //   21: astore 13
    //   23: aload 13
    //   25: ldc_w 541
    //   28: ldc_w 960
    //   31: invokeinterface 963 3 0
    //   36: pop
    //   37: aload 13
    //   39: ldc_w 472
    //   42: aload 4
    //   44: invokeinterface 963 3 0
    //   49: pop
    //   50: aload 13
    //   52: ldc_w 464
    //   55: iload 5
    //   57: invokestatic 966	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: invokeinterface 963 3 0
    //   65: pop
    //   66: aload 13
    //   68: ldc_w 485
    //   71: ldc_w 968
    //   74: invokeinterface 963 3 0
    //   79: pop
    //   80: aload 13
    //   82: ldc_w 512
    //   85: ldc_w 970
    //   88: invokeinterface 963 3 0
    //   93: pop
    //   94: aload 13
    //   96: ldc_w 492
    //   99: aload 7
    //   101: invokeinterface 963 3 0
    //   106: pop
    //   107: aload 13
    //   109: ldc_w 536
    //   112: iload 8
    //   114: invokestatic 975	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokeinterface 963 3 0
    //   122: pop
    //   123: aload 11
    //   125: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifne +275 -> 403
    //   131: new 629	org/json/JSONArray
    //   134: dup
    //   135: aload 11
    //   137: invokespecial 630	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   140: astore 4
    //   142: aload 4
    //   144: ifnonnull +657 -> 801
    //   147: new 629	org/json/JSONArray
    //   150: dup
    //   151: invokespecial 976	org/json/JSONArray:<init>	()V
    //   154: astore 4
    //   156: new 265	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 266	org/json/JSONObject:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: ldc_w 636
    //   170: ldc_w 978
    //   173: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload 7
    //   179: ldc_w 648
    //   182: invokestatic 981	com/tencent/mm/plugin/websearch/api/aj:gtA	()Ljava/lang/String;
    //   185: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload 4
    //   191: aload 7
    //   193: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   196: pop
    //   197: new 265	org/json/JSONObject
    //   200: dup
    //   201: invokespecial 266	org/json/JSONObject:<init>	()V
    //   204: astore 7
    //   206: aload 7
    //   208: ldc_w 636
    //   211: ldc_w 986
    //   214: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 7
    //   220: ldc_w 648
    //   223: iconst_1
    //   224: invokevirtual 989	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   227: pop
    //   228: aload 4
    //   230: aload 7
    //   232: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   235: pop
    //   236: new 265	org/json/JSONObject
    //   239: dup
    //   240: invokespecial 266	org/json/JSONObject:<init>	()V
    //   243: astore 7
    //   245: aload 7
    //   247: ldc_w 636
    //   250: ldc_w 556
    //   253: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 7
    //   259: ldc_w 648
    //   262: aload_1
    //   263: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload 4
    //   269: aload 7
    //   271: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   274: pop
    //   275: new 265	org/json/JSONObject
    //   278: dup
    //   279: invokespecial 266	org/json/JSONObject:<init>	()V
    //   282: astore 7
    //   284: aload 7
    //   286: ldc_w 636
    //   289: ldc_w 991
    //   292: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload 7
    //   298: ldc_w 648
    //   301: aload 6
    //   303: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload 4
    //   309: aload 7
    //   311: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   314: pop
    //   315: aload 12
    //   317: ifnull +176 -> 493
    //   320: aload 12
    //   322: ldc_w 993
    //   325: invokeinterface 744 2 0
    //   330: checkcast 330	java/lang/String
    //   333: astore 6
    //   335: aload 6
    //   337: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   340: ifne +90 -> 430
    //   343: new 629	org/json/JSONArray
    //   346: dup
    //   347: aload 6
    //   349: invokestatic 997	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokespecial 630	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   355: astore 6
    //   357: iconst_0
    //   358: istore 5
    //   360: iload 5
    //   362: aload 6
    //   364: invokevirtual 631	org/json/JSONArray:length	()I
    //   367: if_icmpge +63 -> 430
    //   370: aload 6
    //   372: iload 5
    //   374: invokevirtual 709	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   377: astore 7
    //   379: aload 7
    //   381: ifnull +11 -> 392
    //   384: aload 4
    //   386: aload 7
    //   388: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
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
    //   411: ldc 138
    //   413: aload 6
    //   415: ldc_w 413
    //   418: iconst_0
    //   419: anewarray 4	java/lang/Object
    //   422: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: goto -110 -> 315
    //   428: astore 6
    //   430: aload 12
    //   432: ldc_w 999
    //   435: invokeinterface 744 2 0
    //   440: checkcast 330	java/lang/String
    //   443: astore 6
    //   445: aload 6
    //   447: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   450: ifne +43 -> 493
    //   453: new 265	org/json/JSONObject
    //   456: dup
    //   457: invokespecial 266	org/json/JSONObject:<init>	()V
    //   460: astore 7
    //   462: aload 7
    //   464: ldc_w 636
    //   467: ldc_w 999
    //   470: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   473: pop
    //   474: aload 7
    //   476: ldc_w 648
    //   479: aload 6
    //   481: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   484: pop
    //   485: aload 4
    //   487: aload 7
    //   489: invokevirtual 984	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   492: pop
    //   493: aload 13
    //   495: ldc_w 627
    //   498: aload 4
    //   500: invokevirtual 1000	org/json/JSONArray:toString	()Ljava/lang/String;
    //   503: invokeinterface 963 3 0
    //   508: pop
    //   509: aload 13
    //   511: ldc_w 526
    //   514: aload_2
    //   515: invokeinterface 963 3 0
    //   520: pop
    //   521: aload 13
    //   523: ldc_w 561
    //   526: aload_3
    //   527: invokeinterface 963 3 0
    //   532: pop
    //   533: aload 13
    //   535: ldc_w 556
    //   538: aload_1
    //   539: invokeinterface 963 3 0
    //   544: pop
    //   545: aload 12
    //   547: ifnull +12 -> 559
    //   550: aload 13
    //   552: aload 12
    //   554: invokeinterface 1004 2 0
    //   559: aload_0
    //   560: aload 13
    //   562: invokespecial 176	com/tencent/mm/plugin/webview/fts/j:cd	(Ljava/util/Map;)Lcom/tencent/mm/plugin/websearch/api/w;
    //   565: astore 4
    //   567: iload 9
    //   569: iconst_1
    //   570: if_icmpeq +9 -> 579
    //   573: iload 9
    //   575: iconst_2
    //   576: if_icmpne +10 -> 586
    //   579: aload 4
    //   581: iload 9
    //   583: putfield 886	com/tencent/mm/plugin/websearch/api/w:Wou	I
    //   586: aload 10
    //   588: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   591: ifne +196 -> 787
    //   594: aload 10
    //   596: invokestatic 1005	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   599: astore_3
    //   600: aload 4
    //   602: aload_3
    //   603: putfield 896	com/tencent/mm/plugin/websearch/api/w:hAT	Ljava/lang/String;
    //   606: aload_3
    //   607: invokestatic 448	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   610: ifne +144 -> 754
    //   613: iload 9
    //   615: iconst_2
    //   616: if_icmpne +138 -> 754
    //   619: ldc 138
    //   621: ldc_w 1007
    //   624: iconst_1
    //   625: anewarray 4	java/lang/Object
    //   628: dup
    //   629: iconst_0
    //   630: aload_1
    //   631: aastore
    //   632: invokestatic 859	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: new 469	com/tencent/mm/plugin/websearch/api/w
    //   638: dup
    //   639: invokespecial 470	com/tencent/mm/plugin/websearch/api/w:<init>	()V
    //   642: astore 6
    //   644: aload 6
    //   646: iconst_0
    //   647: putfield 490	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   650: aload 6
    //   652: aload_1
    //   653: putfield 559	com/tencent/mm/plugin/websearch/api/w:hOG	Ljava/lang/String;
    //   656: aload 6
    //   658: iload 9
    //   660: putfield 886	com/tencent/mm/plugin/websearch/api/w:Wou	I
    //   663: aload 6
    //   665: aload_3
    //   666: putfield 896	com/tencent/mm/plugin/websearch/api/w:hAT	Ljava/lang/String;
    //   669: new 265	org/json/JSONObject
    //   672: dup
    //   673: invokespecial 266	org/json/JSONObject:<init>	()V
    //   676: astore_3
    //   677: aload_3
    //   678: ldc_w 1009
    //   681: aload 6
    //   683: getfield 896	com/tencent/mm/plugin/websearch/api/w:hAT	Ljava/lang/String;
    //   686: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   689: pop
    //   690: aload_3
    //   691: ldc_w 1011
    //   694: ldc_w 1013
    //   697: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload_3
    //   702: ldc_w 1015
    //   705: aload_2
    //   706: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   709: pop
    //   710: aload 6
    //   712: aload_3
    //   713: invokevirtual 1016	org/json/JSONObject:toString	()Ljava/lang/String;
    //   716: putfield 1017	com/tencent/mm/plugin/websearch/api/w:content	Ljava/lang/String;
    //   719: aload_0
    //   720: getfield 167	com/tencent/mm/plugin/webview/fts/j:WBQ	Lcom/tencent/mm/plugin/webview/fts/h;
    //   723: iconst_0
    //   724: aload 6
    //   726: getfield 1017	com/tencent/mm/plugin/websearch/api/w:content	Ljava/lang/String;
    //   729: invokestatic 1020	com/tencent/mm/plugin/webview/fts/h:aHT	(Ljava/lang/String;)Ljava/lang/String;
    //   732: invokevirtual 1024	com/tencent/mm/plugin/webview/fts/h:N	(ILjava/lang/Object;)V
    //   735: new 1026	com/tencent/mm/plugin/websearch/api/ab
    //   738: dup
    //   739: aload 6
    //   741: invokespecial 1029	com/tencent/mm/plugin/websearch/api/ab:<init>	(Lcom/tencent/mm/plugin/websearch/api/w;)V
    //   744: astore_2
    //   745: invokestatic 1033	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   748: aload_2
    //   749: iconst_0
    //   750: invokevirtual 1038	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   753: pop
    //   754: aload 4
    //   756: iconst_1
    //   757: putfield 1041	com/tencent/mm/plugin/websearch/api/w:Wos	Z
    //   760: aload_0
    //   761: getfield 167	com/tencent/mm/plugin/webview/fts/j:WBQ	Lcom/tencent/mm/plugin/webview/fts/h;
    //   764: iconst_1
    //   765: aload_1
    //   766: invokevirtual 1024	com/tencent/mm/plugin/webview/fts/h:N	(ILjava/lang/Object;)V
    //   769: aload_0
    //   770: getfield 125	com/tencent/mm/plugin/webview/fts/j:WBR	Lcom/tencent/mm/plugin/webview/fts/j$b;
    //   773: aload 4
    //   775: invokevirtual 1043	com/tencent/mm/plugin/webview/fts/j$b:c	(Lcom/tencent/mm/plugin/websearch/api/w;)V
    //   778: ldc_w 954
    //   781: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   784: iconst_0
    //   785: ireturn
    //   786: astore_3
    //   787: aconst_null
    //   788: astore_3
    //   789: goto -183 -> 606
    //   792: astore_2
    //   793: goto -39 -> 754
    //   796: astore 6
    //   798: goto -305 -> 493
    //   801: goto -645 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	this	j
    //   0	804	1	paramString1	String
    //   0	804	2	paramString2	String
    //   0	804	3	paramString3	String
    //   0	804	4	paramString4	String
    //   0	804	5	paramInt1	int
    //   0	804	6	paramString5	String
    //   0	804	7	paramString6	String
    //   0	804	8	paramInt2	int
    //   0	804	9	paramInt3	int
    //   0	804	10	paramString7	String
    //   0	804	11	paramString8	String
    //   0	804	12	paramMap	Map<String, String>
    //   21	540	13	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   131	142	401	finally
    //   156	315	409	org/json/JSONException
    //   343	357	428	finally
    //   360	379	428	finally
    //   384	392	428	finally
    //   594	606	786	finally
    //   677	754	792	finally
    //   453	493	796	java/lang/Exception
  }
  
  public final boolean cb(final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77961);
    int i = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
    String str = aj.au(paramMap, "requestId");
    if (!aj.av(paramMap, "isBackButtonClick")) {
      k.auP(i).d(aj.c(paramMap, "type", 0), aj.au(paramMap, "query"), paramMap);
    }
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData: %s,wid: %s,rid: %s", new Object[] { paramMap.toString(), Integer.valueOf(i), str });
    this.WBQ.a(1, str, Integer.valueOf(i), new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77954);
        w localw = j.a(j.this, paramMap);
        j.b(j.this).c(localw);
        AppMethodBeat.o(77954);
      }
    }, this.WAw);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295562);
        JSONObject localJSONObject = new JSONObject();
        if ((paramMap != null) && (paramMap.size() > 0)) {}
        try
        {
          localJSONObject.put("requestId", paramMap.get("requestId"));
          localJSONObject.put("type", paramMap.get("type"));
          localJSONObject.put("url", paramMap.get("url"));
          localJSONObject.put("parentSearchID", paramMap.get("parentSearchID"));
          label104:
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putString("sos_fts_search_data_tmp", localJSONObject.toString()).commit();
          AppMethodBeat.o(295562);
          return;
        }
        catch (JSONException localJSONException)
        {
          break label104;
        }
      }
    });
    AppMethodBeat.o(77961);
    return false;
  }
  
  public final boolean ce(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(77970);
    Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSuggestionData %s", new Object[] { paramMap });
    Object localObject = new w();
    ((w)localObject).hAB = aj.au(paramMap, "query");
    try
    {
      ((w)localObject).hAB = URLDecoder.decode(((w)localObject).hAB, "UTF-8");
      label59:
      ((w)localObject).businessType = aj.c(paramMap, "type", 0);
      ((w)localObject).scene = aj.c(paramMap, "scene", 0);
      int i;
      if (aj.av(paramMap, "isHomePage"))
      {
        i = 1;
        ((w)localObject).Wob = i;
        ((w)localObject).hVk = Util.nullAsInt(paramMap.get("webview_instance_id"), -1);
        ((w)localObject).Wog.add(aj.au(paramMap, "prefixQuery"));
        i = aj.c(paramMap, "requestType", 0);
        ((w)localObject).subtype = aj.c(paramMap, "subtype", 0);
        ((w)localObject).Won = aj.c(paramMap, "isWeAppMore", 0);
        ((w)localObject).sessionId = aj.au(paramMap, "sessionId");
        if (((w)localObject).Won == 1)
        {
          ((w)localObject).Woo = new gmm();
          ((w)localObject).Woo.YQo = aj.asY(3);
          ((w)localObject).Woo.achB = com.tencent.mm.modelappbrand.c.opQ;
          ((w)localObject).Woo.YZM = aj.c(paramMap, "subType", 0);
          ((w)localObject).Woo.session_id = com.tencent.mm.modelappbrand.c.opP;
          paramMap = com.tencent.mm.kernel.h.baE().ban().get(at.a.acPK, null);
          if ((paramMap != null) && ((paramMap instanceof String))) {
            ((w)localObject).Woo.abro = ((String)paramMap);
          }
        }
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "getSearchData, webviewID = %d", new Object[] { Integer.valueOf(((w)localObject).hVk) });
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
          paramMap = this.WBS;
          if (paramMap.WBZ != null)
          {
            com.tencent.mm.kernel.h.aZW().b(paramMap.WBZ.getType(), paramMap.WBT);
            com.tencent.mm.kernel.h.aZW().a(paramMap.WBZ);
            paramMap.WBZ = null;
          }
          if (paramMap.WBZ == null)
          {
            paramMap.WBZ = new g((w)localObject);
            com.tencent.mm.kernel.h.aZW().a(paramMap.WBZ.getType(), paramMap.WBT);
            com.tencent.mm.kernel.h.aZW().a(paramMap.WBZ, 0);
            continue;
            k.auP(((w)localObject).hVk).biN(am.iqe());
          }
        }
        str = ((w)localObject).hAB;
        i = ((w)localObject).businessType;
        j = ((w)localObject).hVk;
      } while (Util.isNullOrNil(str));
      if (this.HtE != null)
      {
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(this.HtE);
        this.HtE = null;
      }
      switch (i)
      {
      default: 
        paramMap = null;
      }
      while (paramMap != null)
      {
        localObject = new com.tencent.mm.plugin.fts.a.a.l();
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).qRb = 16;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).query = str;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).Htx = paramMap;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).Htz = 5;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtB = com.tencent.mm.plugin.fts.a.c.b.Hue;
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtA = new HashSet();
        ((com.tencent.mm.plugin.fts.a.a.l)localObject).HtC = this.MVp;
        this.HtE = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, (com.tencent.mm.plugin.fts.a.a.l)localObject);
        this.HtE.Hsv = Integer.valueOf(j);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(77968);
    int i;
    if (paramp != null) {
      i = paramp.getType();
    }
    for (;;)
    {
      Log.v("MicroMsg.WebSearch.WebSearchLogic", "onSceneEnd websearch (type : %s), errType : %s, errCode : %s, errMsg : %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramp instanceof a))
      {
        com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
        paramString = (a)paramp;
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getKeyword() });
          paramp = new JSONObject();
        }
      }
      try
      {
        paramp.put("ret", -1);
        label128:
        paramp = paramp.toString();
        a(paramString.ipD(), paramp, paramString.ipE(), paramString.ipI(), null);
        AppMethodBeat.o(77968);
        return;
        i = 0;
        continue;
        paramp = paramString.ipG();
        paramInt1 = paramString.ipH();
        Log.i("MicroMsg.WebSearch.WebSearchLogic", "callback %s", new Object[] { paramString.getKeyword() });
        a(paramString.ipD(), paramp, paramString.ipE(), paramString.ipI(), paramString.ipF());
        if (paramInt1 > 0)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "updateCode %d, need update", new Object[] { Integer.valueOf(paramInt1) });
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
          com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(27);
        }
        AppMethodBeat.o(77968);
        return;
        if ((paramp instanceof com.tencent.mm.plugin.websearch.api.b))
        {
          com.tencent.mm.kernel.h.aZW().b(paramp.getType(), this);
          paramString = (com.tencent.mm.plugin.websearch.api.b)paramp;
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "net scene fail %s", new Object[] { paramString.getQuery() });
            k.auP(paramString.ipD()).biN("{}");
            AppMethodBeat.o(77968);
            return;
          }
          paramp = paramString.ipG();
          k.auP(paramString.ipD()).biN(paramp);
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
    boolean WBW;
    int WBb;
    String data;
    Bundle hMD;
    String hVo;
    
    public a(int paramInt, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
    {
      this.WBb = paramInt;
      this.data = paramString1;
      this.WBW = paramBoolean;
      this.hVo = paramString2;
      this.hMD = paramBundle;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(295550);
      String str = "NetReqResult{webviewId=" + this.WBb + ", data='" + this.data + '\'' + ", isNewQuery=" + this.WBW + ", reqId='" + this.hVo + '\'' + ", extData=" + this.hMD + '}';
      AppMethodBeat.o(295550);
      return str;
    }
  }
  
  public final class b
    implements Comparable
  {
    public a WBH;
    public a WBX;
    private ThreadPoolExecutor hsF;
    
    private b()
    {
      AppMethodBeat.i(77957);
      this.hsF = new ThreadPoolExecutor(0, 10, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
      AppMethodBeat.o(77957);
    }
    
    public final void c(w paramw)
    {
      AppMethodBeat.i(77958);
      if (this.WBX != null) {
        this.WBX.cBt = true;
      }
      this.WBX = new a((byte)0);
      this.WBX.WnS = paramw;
      j.a(j.this, paramw);
      this.hsF.execute(this.WBX);
      AppMethodBeat.o(77958);
    }
    
    public final int compareTo(Object paramObject)
    {
      return 0;
    }
    
    public final class a
      implements Runnable
    {
      w WnS;
      public volatile boolean cBt;
      
      private a() {}
      
      public final void run()
      {
        AppMethodBeat.i(77956);
        if (Thread.interrupted())
        {
          AppMethodBeat.o(77956);
          return;
        }
        if ((Util.isNullOrNil(this.WnS.hAB)) && (this.WnS.Wou != 2))
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "error query %d %d %d %d %s %d", new Object[] { Integer.valueOf(this.WnS.businessType), Integer.valueOf(this.WnS.scene), Integer.valueOf(this.WnS.Wob), Integer.valueOf(this.WnS.hVr), this.WnS.xVe, Integer.valueOf(this.WnS.offset) });
          AppMethodBeat.o(77956);
          return;
        }
        switch (this.WnS.scene)
        {
        }
        for (;;)
        {
          Log.i("MicroMsg.WebSearch.WebSearchLogic", "start New NetScene %s ,  %d", new Object[] { this.WnS.hAB, Integer.valueOf(this.WnS.hVk) });
          if (j.b.a(j.b.this) != null) {
            com.tencent.mm.kernel.h.aZW().a(j.b.a(j.b.this));
          }
          LinkedList localLinkedList = null;
          Object localObject;
          if (this.WnS.Woc != null)
          {
            localObject = localLinkedList;
            if (!this.WnS.Woc.isEmpty()) {}
          }
          else
          {
            localObject = localLinkedList;
            if (j.aP(this.WnS.hAB, this.WnS.scene, this.WnS.businessType))
            {
              long l = System.currentTimeMillis();
              localObject = (com.tencent.mm.plugin.websearch.c.a.e)j.a(j.this).biG(this.WnS.hAB);
              l = System.currentTimeMillis() - l;
              Log.i("MicroMsg.WebSearch.WebSearchLogic", "match contact cost %d ms", new Object[] { Long.valueOf(l) });
              com.tencent.mm.plugin.report.service.h.OAn.b(14717, new Object[] { this.WnS.hAB, Integer.valueOf(ab.bBV()), Integer.valueOf(((com.tencent.mm.plugin.websearch.c.a.e)localObject).tbH.size()), Long.valueOf(l), Integer.valueOf(this.WnS.scene) });
            }
          }
          if (this.cBt)
          {
            Log.i("MicroMsg.WebSearch.WebSearchLogic", "was cancelled");
            AppMethodBeat.o(77956);
            return;
            localObject = new JSONObject();
          }
          try
          {
            ((JSONObject)localObject).put("word", this.WnS.hAB);
            ((JSONObject)localObject).put("id", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis()));
            ((JSONObject)localObject).put("showType", 0);
            label489:
            ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).addSOSHistory(this.WnS.hAB + "​0", ((JSONObject)localObject).toString());
            continue;
            com.tencent.mm.plugin.webview.modeltools.g.ivW().WAG.C(this.WnS.scene, this.WnS.hAB, this.WnS.businessType);
            j.b.a(j.b.this, j.b.d(this.WnS));
            if (localObject != null)
            {
              localLinkedList = new LinkedList();
              localObject = new ArrayList(((com.tencent.mm.plugin.websearch.c.a.e)localObject).tbH).iterator();
              while (((Iterator)localObject).hasNext())
              {
                e.a locala = (e.a)((Iterator)localObject).next();
                fvd localfvd = new fvd();
                localfvd.UserName = locala.userName;
                localfvd.abTC = locala.Wrk;
                localfvd.vhX = locala.nickName;
                localfvd.Zpa = locala.remark;
                localfvd.pSk = locala.kDc;
                localfvd.crB = locala.desc;
                localLinkedList.add(localfvd);
              }
              j.b.a(j.b.this).cg(localLinkedList);
            }
            com.tencent.mm.kernel.h.aZW().a(j.b.a(j.b.this).getType(), j.this);
            com.tencent.mm.kernel.h.aZW().a(j.b.a(j.b.this), 0);
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
    public com.tencent.mm.plugin.websearch.api.b WBZ;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.j
 * JD-Core Version:    0.7.0.1
 */