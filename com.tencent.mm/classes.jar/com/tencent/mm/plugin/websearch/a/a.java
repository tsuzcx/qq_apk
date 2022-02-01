package com.tencent.mm.plugin.websearch.a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.i;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchUIComponent;)V", "TAG", "", "appendSearchTag", "params", "getReportType", "", "getSearchData", "getSearchSuggestionData", "getUIComponent", "onSearchDataReady", "", "newQuery", "", "json", "requestId", "onSearchInputChange", "query", "custom", "onSearchInputConfirm", "onSearchSuggestionDataReady", "openSearchWebView", "openWeAppPage", "setSearchInputWord", "setSearchTagResult", "startSearchItemDetailPage", "Companion", "ui-websearch_release"})
public final class a
  extends com.tencent.mm.plugin.websearch.webview.h<eql>
{
  public static final a PAl;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(198196);
    PAl = new a((byte)0);
    AppMethodBeat.o(198196);
  }
  
  public a(com.tencent.mm.plugin.websearch.a.a.b paramb)
  {
    super((com.tencent.mm.plugin.websearch.webview.c)paramb);
    AppMethodBeat.i(198194);
    this.TAG = "MicroMsg.WebSearch.TagSearchJSApi";
    AppMethodBeat.o(198194);
  }
  
  private final com.tencent.mm.plugin.websearch.a.a.b gRn()
  {
    com.tencent.mm.plugin.websearch.webview.d locald2 = this.PBs;
    com.tencent.mm.plugin.websearch.webview.d locald1 = locald2;
    if (!(locald2 instanceof com.tencent.mm.plugin.websearch.a.a.b)) {
      locald1 = null;
    }
    return (com.tencent.mm.plugin.websearch.a.a.b)locald1;
  }
  
  @JavascriptInterface
  public final String appendSearchTag(String paramString)
  {
    AppMethodBeat.i(198126);
    Log.i(this.TAG, "appendSearchTag ".concat(String.valueOf(paramString)));
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("query", "");
      String str1 = ((JSONObject)localObject).optString("searchId", "");
      String str2 = ((JSONObject)localObject).optString("sessionId", "");
      localObject = ((JSONObject)localObject).optString("requestId", "");
      com.tencent.mm.plugin.websearch.a.a.b localb = gRn();
      if (localb != null)
      {
        p.j(paramString, "tag");
        p.j(str2, "sessionId");
        p.j(str1, "searchId");
        p.j(localObject, "requestId");
        localb.L(paramString, str2, str1, (String)localObject);
      }
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198126);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198126);
    }
    return paramString;
  }
  
  public final void biX(String paramString)
  {
    AppMethodBeat.i(198192);
    p.k(paramString, "json");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("json", paramString);
      label27:
      paramString = this.PBs;
      if (paramString != null)
      {
        paramString = paramString.esG();
        if (paramString != null)
        {
          i locali = i.PBA;
          localObject = ((JSONObject)localObject).toString();
          p.j(localObject, "requestObj.toString()");
          i.a(paramString, "onSearchSuggestionDataReady", (String)localObject);
          AppMethodBeat.o(198192);
          return;
        }
      }
      AppMethodBeat.o(198192);
      return;
    }
    catch (Exception paramString)
    {
      break label27;
    }
  }
  
  public final int duR()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final String getSearchData(String paramString)
  {
    AppMethodBeat.i(198120);
    Log.i(this.TAG, "getSearchData ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      Object localObject = gRn();
      HashMap localHashMap;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).gRr();
        if (localObject != null)
        {
          p.k(paramString, "paramsStr");
          try
          {
            paramString = new JSONObject(paramString);
            localHashMap = new HashMap();
            Iterator localIterator = paramString.keys();
            if (localIterator != null) {
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                Map localMap = (Map)localHashMap;
                p.j(str, "it");
                localMap.put(str, paramString.opt(str));
                continue;
                paramString = String.valueOf(gRB());
              }
            }
          }
          catch (Exception paramString) {}
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198120);
        return paramString;
        paramString = new com.tencent.mm.plugin.websearch.api.x(((d)localObject).bb((Map)localHashMap));
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramString);
      }
    }
    paramString = String.valueOf(gRC());
    AppMethodBeat.o(198120);
    return paramString;
  }
  
  /* Error */
  @JavascriptInterface
  public final String getSearchSuggestionData(String paramString)
  {
    // Byte code:
    //   0: ldc 251
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 87	com/tencent/mm/plugin/websearch/a/a:TAG	Ljava/lang/String;
    //   9: ldc 253
    //   11: aload_1
    //   12: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 117	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +271 -> 293
    //   25: aload_0
    //   26: invokespecial 93	com/tencent/mm/plugin/websearch/a/a:gRn	()Lcom/tencent/mm/plugin/websearch/a/a/b;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull +205 -> 236
    //   34: aload_3
    //   35: invokeinterface 195 1 0
    //   40: astore 5
    //   42: aload 5
    //   44: ifnull +192 -> 236
    //   47: aload_1
    //   48: ldc 197
    //   50: invokestatic 77	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   53: new 124	org/json/JSONObject
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 127	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: new 255	com/tencent/mm/plugin/websearch/api/v
    //   65: dup
    //   66: invokespecial 256	com/tencent/mm/plugin/websearch/api/v:<init>	()V
    //   69: astore 4
    //   71: aload 4
    //   73: aload_3
    //   74: ldc 128
    //   76: ldc 129
    //   78: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: ldc_w 258
    //   84: invokestatic 263	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 266	com/tencent/mm/plugin/websearch/api/v:fwe	Ljava/lang/String;
    //   90: aload 4
    //   92: aload_3
    //   93: ldc_w 268
    //   96: iconst_0
    //   97: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   100: putfield 276	com/tencent/mm/plugin/websearch/api/v:businessType	I
    //   103: aload 4
    //   105: aload_3
    //   106: ldc_w 278
    //   109: iconst_0
    //   110: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   113: putfield 280	com/tencent/mm/plugin/websearch/api/v:scene	I
    //   116: aload 4
    //   118: aload_3
    //   119: ldc_w 282
    //   122: iconst_0
    //   123: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   126: putfield 285	com/tencent/mm/plugin/websearch/api/v:PxU	I
    //   129: aload 4
    //   131: aload 5
    //   133: invokevirtual 288	com/tencent/mm/plugin/websearch/a/d:gQm	()I
    //   136: putfield 291	com/tencent/mm/plugin/websearch/api/v:fPp	I
    //   139: aload_3
    //   140: ldc_w 293
    //   143: ldc 129
    //   145: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   148: astore_1
    //   149: aload_1
    //   150: checkcast 295	java/lang/CharSequence
    //   153: astore 5
    //   155: aload 5
    //   157: ifnull +154 -> 311
    //   160: aload 5
    //   162: invokeinterface 298 1 0
    //   167: ifne +83 -> 250
    //   170: goto +141 -> 311
    //   173: aload_1
    //   174: ifnull +13 -> 187
    //   177: aload 4
    //   179: getfield 302	com/tencent/mm/plugin/websearch/api/v:PxZ	Ljava/util/LinkedList;
    //   182: aload_1
    //   183: invokevirtual 308	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   186: pop
    //   187: aload_3
    //   188: ldc_w 310
    //   191: iconst_0
    //   192: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   195: istore_2
    //   196: aload 4
    //   198: aload_3
    //   199: ldc_w 312
    //   202: iconst_0
    //   203: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   206: putfield 315	com/tencent/mm/plugin/websearch/api/v:BHR	I
    //   209: iload_2
    //   210: tableswitch	default:+26 -> 236, 0:+55->265, 1:+26->236, 2:+26->236
    //   237: nop
    //   238: dcmpl
    //   239: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   242: astore_1
    //   243: ldc 251
    //   245: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_1
    //   249: areturn
    //   250: iconst_0
    //   251: istore_2
    //   252: goto +61 -> 313
    //   255: iconst_0
    //   256: istore_2
    //   257: goto +62 -> 319
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -89 -> 173
    //   265: new 317	com/tencent/mm/plugin/websearch/api/s
    //   268: dup
    //   269: aload 4
    //   271: invokespecial 318	com/tencent/mm/plugin/websearch/api/s:<init>	(Lcom/tencent/mm/plugin/websearch/api/v;)V
    //   274: astore_1
    //   275: invokestatic 242	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   278: aload_1
    //   279: checkcast 244	com/tencent/mm/an/q
    //   282: invokevirtual 250	com/tencent/mm/an/t:b	(Lcom/tencent/mm/an/q;)Z
    //   285: pop
    //   286: goto -50 -> 236
    //   289: astore_1
    //   290: goto -54 -> 236
    //   293: invokestatic 154	com/tencent/mm/plugin/websearch/a/a:gRC	()Lorg/json/JSONObject;
    //   296: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   299: astore_1
    //   300: ldc 251
    //   302: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_1
    //   306: areturn
    //   307: astore_1
    //   308: goto -218 -> 90
    //   311: iconst_1
    //   312: istore_2
    //   313: iload_2
    //   314: ifne -59 -> 255
    //   317: iconst_1
    //   318: istore_2
    //   319: iload_2
    //   320: ifeq -60 -> 260
    //   323: goto -150 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	a
    //   0	326	1	paramString	String
    //   195	125	2	i	int
    //   29	170	3	localObject1	Object
    //   69	201	4	localv	com.tencent.mm.plugin.websearch.api.v
    //   40	121	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   53	71	289	java/lang/Exception
    //   90	155	289	java/lang/Exception
    //   160	170	289	java/lang/Exception
    //   177	187	289	java/lang/Exception
    //   187	209	289	java/lang/Exception
    //   265	286	289	java/lang/Exception
    //   71	90	307	java/lang/Exception
  }
  
  public final void i(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(198191);
    p.k(paramString1, "json");
    p.k(paramString2, "requestId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("newQuery", paramBoolean);
      localJSONObject.put("json", paramString1);
      localJSONObject.put("requestId", paramString2);
      label55:
      paramString1 = this.PBs;
      if (paramString1 != null)
      {
        paramString1 = paramString1.esG();
        if (paramString1 != null)
        {
          paramString2 = i.PBA;
          paramString2 = localJSONObject.toString();
          p.j(paramString2, "requestObj.toString()");
          i.a(paramString1, "onSearchDataReady", paramString2);
          AppMethodBeat.o(198191);
          return;
        }
      }
      AppMethodBeat.o(198191);
      return;
    }
    catch (Exception paramString1)
    {
      break label55;
    }
  }
  
  public final void mk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198188);
    p.k(paramString1, "query");
    p.k(paramString2, "custom");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("query", paramString1);
      localJSONObject.put("custom", paramString2);
      label44:
      paramString1 = this.PBs;
      if (paramString1 != null)
      {
        paramString1 = paramString1.esG();
        if (paramString1 != null)
        {
          paramString2 = i.PBA;
          paramString2 = localJSONObject.toString();
          p.j(paramString2, "requestObj.toString()");
          i.a(paramString1, "onSearchInputChange", paramString2);
          AppMethodBeat.o(198188);
          return;
        }
      }
      AppMethodBeat.o(198188);
      return;
    }
    catch (Exception paramString1)
    {
      break label44;
    }
  }
  
  @JavascriptInterface
  public final String openSearchWebView(String paramString)
  {
    AppMethodBeat.i(198185);
    Log.i(this.TAG, "openSearchWebView ".concat(String.valueOf(paramString)));
    int m;
    try
    {
      paramString = new JSONObject(paramString);
      str2 = paramString.optString("query");
      i = paramString.optInt("scene", 0);
      j = paramString.optInt("type", 0);
      k = paramString.optInt("subType", 0);
      str3 = paramString.optString("searchId", "");
      str4 = paramString.optString("sessionId", "");
      paramString.optString("subSessionId", "");
      m = paramString.optInt("actionType", 0);
      localObject = paramString.optString("extParams", "");
      paramString.optString("docID", "");
      paramString.optInt("hideSearchBar", 0);
      paramString.optString("navBarColor", "");
      paramString.optString("statusBarStyle", "");
      paramString = paramString.optJSONObject("nativeConfig");
      if (paramString == null) {
        break label444;
      }
      paramString = paramString.optString("title");
      if (paramString != null) {
        break label441;
      }
    }
    catch (Exception paramString)
    {
      String str2;
      int i;
      int j;
      int k;
      String str3;
      String str4;
      Map localMap;
      eql localeql;
      String str1;
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198185);
      return paramString;
    }
    paramString = String.valueOf(gRB());
    AppMethodBeat.o(198185);
    return paramString;
    localMap = ai.a(i, false, j, (String)localObject);
    localMap.put("query", str2);
    localMap.put("searchId", str3);
    localMap.put("subType", String.valueOf(k));
    localMap.put("sessionId", str4);
    localMap.put("subSessionId", ai.ane(i));
    localeql = new eql();
    Object localObject = gRn();
    if (localObject != null)
    {
      localObject = (eql)((com.tencent.mm.plugin.websearch.a.a.b)localObject).esL();
      if (localObject != null)
      {
        str1 = ((eql)localObject).talker;
        localObject = str1;
        if (str1 == null) {}
      }
    }
    for (;;)
    {
      localeql.talker = ((String)localObject);
      localObject = c.PAp;
      p.j(localMap, "urlParams");
      localeql.url = c.aZ(localMap);
      localeql.fwe = str2;
      localeql.scene = i;
      localeql.jQi = str3;
      localeql.sessionId = str4;
      localeql.fIY = ai.ane(i);
      localeql.title = paramString;
      paramString = gRn();
      if (paramString == null) {
        break;
      }
      paramString.a(localeql);
      break;
      label441:
      break label447;
      label444:
      paramString = "";
      label447:
      switch (m)
      {
      }
      break;
      localObject = "";
    }
  }
  
  /* Error */
  @JavascriptInterface
  public final String openWeAppPage(String paramString)
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 87	com/tencent/mm/plugin/websearch/a/a:TAG	Ljava/lang/String;
    //   10: ldc_w 411
    //   13: iconst_1
    //   14: anewarray 413	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokestatic 416	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: new 124	org/json/JSONObject
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 127	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   32: astore 8
    //   34: aload 8
    //   36: ldc_w 418
    //   39: ldc 129
    //   41: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 9
    //   46: aload 8
    //   48: ldc_w 420
    //   51: ldc 129
    //   53: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 7
    //   58: aload 7
    //   60: ldc_w 420
    //   63: invokestatic 143	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   66: aload 7
    //   68: checkcast 295	java/lang/CharSequence
    //   71: ldc_w 422
    //   74: checkcast 295	java/lang/CharSequence
    //   77: invokestatic 428	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   80: istore 6
    //   82: aload 7
    //   84: astore_1
    //   85: iload 6
    //   87: ifeq +674 -> 761
    //   90: aload 7
    //   92: astore_1
    //   93: new 124	org/json/JSONObject
    //   96: dup
    //   97: aload 7
    //   99: invokestatic 434	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   102: ldc_w 436
    //   105: invokevirtual 439	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokespecial 127	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   111: astore 10
    //   113: aload 7
    //   115: astore_1
    //   116: aload 10
    //   118: ldc_w 422
    //   121: invokevirtual 442	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   124: pop
    //   125: aload 7
    //   127: astore_1
    //   128: aload 7
    //   130: checkcast 295	java/lang/CharSequence
    //   133: astore 11
    //   135: aload 7
    //   137: astore_1
    //   138: new 444	kotlin/n/k
    //   141: dup
    //   142: ldc_w 446
    //   145: invokespecial 447	kotlin/n/k:<init>	(Ljava/lang/String;)V
    //   148: aload 11
    //   150: ldc_w 449
    //   153: invokevirtual 453	kotlin/n/k:e	(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 7
    //   158: aload 7
    //   160: astore_1
    //   161: new 455	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 456	java/lang/StringBuilder:<init>	()V
    //   168: aload 7
    //   170: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc_w 462
    //   176: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 10
    //   181: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore 7
    //   189: aload 7
    //   191: astore_1
    //   192: aload 8
    //   194: ldc_w 468
    //   197: iconst_0
    //   198: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: istore_3
    //   202: aload 8
    //   204: ldc 135
    //   206: ldc 129
    //   208: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 10
    //   213: aload 8
    //   215: ldc_w 470
    //   218: ldc 129
    //   220: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 11
    //   225: aload 8
    //   227: ldc_w 472
    //   230: iconst_1
    //   231: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   234: istore 4
    //   236: aload 8
    //   238: ldc_w 278
    //   241: sipush 1000
    //   244: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   247: istore 5
    //   249: aload 8
    //   251: ldc_w 474
    //   254: iconst_0
    //   255: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   258: istore_2
    //   259: aload 8
    //   261: ldc_w 476
    //   264: ldc 129
    //   266: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: astore 7
    //   271: aload 8
    //   273: ldc_w 478
    //   276: ldc 129
    //   278: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   281: astore 13
    //   283: new 124	org/json/JSONObject
    //   286: dup
    //   287: invokespecial 160	org/json/JSONObject:<init>	()V
    //   290: astore 14
    //   292: aload 14
    //   294: ldc_w 480
    //   297: aload 7
    //   299: invokevirtual 164	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: iload_2
    //   304: ifge +454 -> 758
    //   307: iconst_0
    //   308: istore_2
    //   309: new 482	com/tencent/mm/f/a/xw
    //   312: dup
    //   313: invokespecial 483	com/tencent/mm/f/a/xw:<init>	()V
    //   316: astore 12
    //   318: aload 12
    //   320: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   323: astore 15
    //   325: aload_0
    //   326: getfield 99	com/tencent/mm/plugin/websearch/webview/b:PBs	Lcom/tencent/mm/plugin/websearch/webview/d;
    //   329: astore 7
    //   331: aload 7
    //   333: ifnull +431 -> 764
    //   336: aload 7
    //   338: invokeinterface 491 1 0
    //   343: astore 7
    //   345: aload 15
    //   347: aload 7
    //   349: putfield 497	com/tencent/mm/f/a/xw$a:context	Landroid/content/Context;
    //   352: aload 12
    //   354: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   357: aload 9
    //   359: putfield 499	com/tencent/mm/f/a/xw$a:userName	Ljava/lang/String;
    //   362: aload 12
    //   364: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   367: aload_1
    //   368: putfield 502	com/tencent/mm/f/a/xw$a:fWP	Ljava/lang/String;
    //   371: aload 12
    //   373: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   376: iload_3
    //   377: putfield 504	com/tencent/mm/f/a/xw$a:appVersion	I
    //   380: aload 12
    //   382: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   385: ldc_w 506
    //   388: putfield 509	com/tencent/mm/f/a/xw$a:fXd	Ljava/lang/String;
    //   391: aload 12
    //   393: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   396: aload 14
    //   398: invokevirtual 180	org/json/JSONObject:toString	()Ljava/lang/String;
    //   401: putfield 512	com/tencent/mm/f/a/xw$a:fXe	Ljava/lang/String;
    //   404: aload 13
    //   406: invokestatic 518	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   409: ifeq +212 -> 621
    //   412: aload 12
    //   414: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   417: aload 9
    //   419: putfield 521	com/tencent/mm/f/a/xw$a:fXc	Ljava/lang/String;
    //   422: aload 12
    //   424: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   427: iload_2
    //   428: putfield 524	com/tencent/mm/f/a/xw$a:fWQ	I
    //   431: iload 5
    //   433: sipush 201
    //   436: if_icmpeq +17 -> 453
    //   439: iload 5
    //   441: bipush 14
    //   443: if_icmpeq +10 -> 453
    //   446: iload 5
    //   448: bipush 22
    //   450: if_icmpne +213 -> 663
    //   453: aload 12
    //   455: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   458: sipush 1006
    //   461: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   464: aload 8
    //   466: ldc_w 527
    //   469: ldc 129
    //   471: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   474: astore_1
    //   475: aload 8
    //   477: ldc_w 529
    //   480: ldc 129
    //   482: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   485: astore 7
    //   487: aload 8
    //   489: ldc_w 531
    //   492: ldc 129
    //   494: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   497: astore 8
    //   499: aload 12
    //   501: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   504: new 455	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 456	java/lang/StringBuilder:<init>	()V
    //   511: aload_1
    //   512: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: bipush 58
    //   517: invokevirtual 534	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   520: aload 7
    //   522: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: bipush 58
    //   527: invokevirtual 534	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   530: aload 10
    //   532: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: bipush 58
    //   537: invokevirtual 534	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   540: aload 11
    //   542: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: bipush 58
    //   547: invokevirtual 534	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   550: iload 4
    //   552: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: bipush 58
    //   557: invokevirtual 534	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   560: aload 8
    //   562: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: putfield 540	com/tencent/mm/f/a/xw$a:fvd	Ljava/lang/String;
    //   571: getstatic 546	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   574: aload 12
    //   576: checkcast 548	com/tencent/mm/sdk/event/IEvent
    //   579: invokevirtual 552	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   582: pop
    //   583: invokestatic 151	com/tencent/mm/plugin/websearch/a/a:gRB	()Lorg/json/JSONObject;
    //   586: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   589: astore_1
    //   590: ldc_w 409
    //   593: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: aload_1
    //   597: areturn
    //   598: astore 7
    //   600: aload_0
    //   601: getfield 87	com/tencent/mm/plugin/websearch/a/a:TAG	Ljava/lang/String;
    //   604: aload 7
    //   606: checkcast 554	java/lang/Throwable
    //   609: ldc 129
    //   611: iconst_0
    //   612: anewarray 413	java/lang/Object
    //   615: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto +143 -> 761
    //   621: aload 12
    //   623: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   626: aload 13
    //   628: putfield 521	com/tencent/mm/f/a/xw$a:fXc	Ljava/lang/String;
    //   631: goto -209 -> 422
    //   634: astore_1
    //   635: aload_0
    //   636: getfield 87	com/tencent/mm/plugin/websearch/a/a:TAG	Ljava/lang/String;
    //   639: aload_1
    //   640: checkcast 554	java/lang/Throwable
    //   643: ldc_w 559
    //   646: iconst_0
    //   647: anewarray 413	java/lang/Object
    //   650: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: invokestatic 154	com/tencent/mm/plugin/websearch/a/a:gRC	()Lorg/json/JSONObject;
    //   656: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   659: astore_1
    //   660: goto -70 -> 590
    //   663: iload 5
    //   665: iconst_3
    //   666: if_icmpne +17 -> 683
    //   669: aload 12
    //   671: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   674: sipush 1005
    //   677: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   680: goto -216 -> 464
    //   683: iload 5
    //   685: bipush 16
    //   687: if_icmpne +17 -> 704
    //   690: aload 12
    //   692: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   695: sipush 1042
    //   698: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   701: goto -237 -> 464
    //   704: iload 5
    //   706: bipush 20
    //   708: if_icmpne +62 -> 770
    //   711: aload 12
    //   713: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   716: sipush 1053
    //   719: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   722: goto -258 -> 464
    //   725: aload 12
    //   727: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   730: sipush 1106
    //   733: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   736: goto -272 -> 464
    //   739: aload 12
    //   741: getfield 487	com/tencent/mm/f/a/xw:fWN	Lcom/tencent/mm/f/a/xw$a;
    //   744: sipush 1000
    //   747: putfield 525	com/tencent/mm/f/a/xw$a:scene	I
    //   750: goto -286 -> 464
    //   753: astore 7
    //   755: goto -452 -> 303
    //   758: goto -449 -> 309
    //   761: goto -569 -> 192
    //   764: aconst_null
    //   765: astore 7
    //   767: goto -422 -> 345
    //   770: iload 5
    //   772: bipush 42
    //   774: if_icmpeq -49 -> 725
    //   777: iload 5
    //   779: bipush 52
    //   781: if_icmpne -42 -> 739
    //   784: goto -59 -> 725
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	787	0	this	a
    //   0	787	1	paramString	String
    //   258	170	2	i	int
    //   201	176	3	j	int
    //   234	317	4	k	int
    //   247	535	5	m	int
    //   80	6	6	bool	boolean
    //   56	465	7	localObject1	Object
    //   598	7	7	localException1	Exception
    //   753	1	7	localException2	Exception
    //   765	1	7	localObject2	Object
    //   32	529	8	localObject3	Object
    //   44	374	9	str1	String
    //   111	420	10	localObject4	Object
    //   133	408	11	localObject5	Object
    //   316	424	12	localxw	com.tencent.mm.f.a.xw
    //   281	346	13	str2	String
    //   290	107	14	localJSONObject	JSONObject
    //   323	23	15	locala	com.tencent.mm.f.a.xw.a
    // Exception table:
    //   from	to	target	type
    //   93	113	598	java/lang/Exception
    //   116	125	598	java/lang/Exception
    //   128	135	598	java/lang/Exception
    //   138	158	598	java/lang/Exception
    //   161	189	598	java/lang/Exception
    //   24	82	634	java/lang/Exception
    //   192	292	634	java/lang/Exception
    //   309	331	634	java/lang/Exception
    //   336	345	634	java/lang/Exception
    //   345	422	634	java/lang/Exception
    //   422	431	634	java/lang/Exception
    //   453	464	634	java/lang/Exception
    //   464	590	634	java/lang/Exception
    //   600	618	634	java/lang/Exception
    //   621	631	634	java/lang/Exception
    //   669	680	634	java/lang/Exception
    //   690	701	634	java/lang/Exception
    //   711	722	634	java/lang/Exception
    //   725	736	634	java/lang/Exception
    //   739	750	634	java/lang/Exception
    //   292	303	753	java/lang/Exception
  }
  
  @JavascriptInterface
  public final String setSearchInputWord(String paramString)
  {
    AppMethodBeat.i(198163);
    Log.i(this.TAG, "setSearchInputWord ".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramString.optString("word", ""), paramString.optBoolean("isInputChange", false)));
      paramString = String.valueOf(gRB());
      AppMethodBeat.o(198163);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = String.valueOf(gRC());
      AppMethodBeat.o(198163);
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String setSearchTagResult(String paramString)
  {
    AppMethodBeat.i(198141);
    Log.i(this.TAG, "setSearchTagResult ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      Object localObject = gRn();
      d locald;
      if (localObject != null)
      {
        locald = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).gRr();
        if (locald != null) {
          p.k(paramString, "paramsStr");
        }
      }
      for (;;)
      {
        try
        {
          localObject = locald.PAt;
          if (localObject != null)
          {
            com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject);
            locald.PAt = null;
          }
          paramString = new JSONObject(paramString);
          ccm localccm = new ccm();
          localccm.CPw = paramString.optInt("scene", 0);
          localccm.SessionId = paramString.optString("sessionId", "");
          localccm.Tkx = paramString.optString("requestId", "");
          localccm.Tky = paramString.optString("searchId", "");
          localccm.RYJ = paramString.optString("query", "");
          localccm.lpy = paramString.optString("content", "");
          localccm.Tkv = paramString.optInt("h5Version", 0);
          localObject = new com.tencent.mm.plugin.websearch.api.q(localccm, locald.gQm());
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localObject);
          locald.PAt = ((com.tencent.mm.plugin.websearch.api.q)localObject);
          JSONObject localJSONObject = paramString.optJSONObject("screenshot");
          paramString = locald.gRp();
          if (paramString == null) {
            continue;
          }
          paramString = paramString.esG();
          if ((localJSONObject != null) && (paramString != null))
          {
            localObject = locald.gRp();
            if (localObject == null) {
              continue;
            }
            localObject = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).getActivityContext();
            int i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, localJSONObject.optInt("x", 0));
            localObject = locald.gRp();
            if (localObject == null) {
              continue;
            }
            localObject = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).getActivityContext();
            int j = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, localJSONObject.optInt("y", 0));
            localObject = locald.gRp();
            if (localObject == null) {
              continue;
            }
            localObject = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).getActivityContext();
            int k = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, localJSONObject.optInt("w", 0));
            localObject = locald.gRp();
            if (localObject == null) {
              continue;
            }
            localObject = ((com.tencent.mm.plugin.websearch.a.a.b)localObject).getActivityContext();
            int m = com.tencent.mm.ci.a.fromDPToPix((Context)localObject, localJSONObject.optInt("h", 0));
            paramString = BitmapUtil.cropBitmap(paramString.getBitmap(), i, j, k, m, true);
            localObject = locald.PAt;
            if (localObject != null) {
              ((com.tencent.mm.plugin.websearch.api.q)localObject).aD(paramString);
            }
          }
          paramString = locald.gRp();
          if (paramString != null)
          {
            localObject = localccm.Tkx;
            p.j(localObject, "request.RequestId");
            paramString.biY((String)localObject);
          }
        }
        catch (Exception paramString)
        {
          continue;
        }
        paramString = String.valueOf(gRB());
        AppMethodBeat.o(198141);
        return paramString;
        paramString = null;
        continue;
        localObject = null;
        continue;
        localObject = null;
        continue;
        localObject = null;
        continue;
        localObject = null;
      }
    }
    paramString = String.valueOf(gRC());
    AppMethodBeat.o(198141);
    return paramString;
  }
  
  /* Error */
  @JavascriptInterface
  public final String startSearchItemDetailPage(String paramString)
  {
    // Byte code:
    //   0: ldc_w 669
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 87	com/tencent/mm/plugin/websearch/a/a:TAG	Ljava/lang/String;
    //   10: ldc_w 671
    //   13: aload_1
    //   14: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokevirtual 117	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 124	org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 127	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: ldc_w 278
    //   36: iconst_0
    //   37: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   40: istore_2
    //   41: aload_1
    //   42: ldc_w 268
    //   45: iconst_0
    //   46: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   49: istore_3
    //   50: aload_1
    //   51: ldc_w 336
    //   54: iconst_0
    //   55: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   58: istore 4
    //   60: aload_1
    //   61: ldc_w 673
    //   64: ldc 129
    //   66: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 6
    //   71: aload_1
    //   72: ldc_w 675
    //   75: ldc 129
    //   77: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 7
    //   82: aload_1
    //   83: ldc_w 476
    //   86: ldc 129
    //   88: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 8
    //   93: aload_1
    //   94: ldc_w 677
    //   97: ldc 129
    //   99: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 9
    //   104: aload_1
    //   105: ldc_w 679
    //   108: iconst_0
    //   109: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   112: istore 5
    //   114: iload_3
    //   115: lookupswitch	default:+612->727, 1:+56->171, 2:+422->537, 4:+422->537, 16:+422->537
    //   157: nop
    //   158: dcmpl
    //   159: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: astore_1
    //   163: ldc_w 669
    //   166: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: areturn
    //   171: aload_1
    //   172: ldc_w 681
    //   175: invokestatic 77	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   178: aload_1
    //   179: ldc_w 418
    //   182: ldc 129
    //   184: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 9
    //   189: aload_1
    //   190: ldc_w 683
    //   193: ldc 129
    //   195: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 10
    //   200: aload_1
    //   201: ldc_w 685
    //   204: ldc 129
    //   206: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 11
    //   211: aload_1
    //   212: ldc_w 687
    //   215: iconst_0
    //   216: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   219: istore_2
    //   220: aload_1
    //   221: ldc_w 689
    //   224: ldc 129
    //   226: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 12
    //   231: new 691	com/tencent/mm/protocal/protobuf/aez
    //   234: dup
    //   235: invokespecial 692	com/tencent/mm/protocal/protobuf/aez:<init>	()V
    //   238: astore 13
    //   240: aload 13
    //   242: aload_1
    //   243: ldc_w 694
    //   246: iconst_0
    //   247: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   250: putfield 697	com/tencent/mm/protocal/protobuf/aez:mVM	I
    //   253: aload 13
    //   255: aload_1
    //   256: ldc_w 699
    //   259: ldc 129
    //   261: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   264: putfield 702	com/tencent/mm/protocal/protobuf/aez:mVP	Ljava/lang/String;
    //   267: aload 13
    //   269: aload_1
    //   270: ldc_w 704
    //   273: ldc 129
    //   275: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 707	com/tencent/mm/protocal/protobuf/aez:mVO	Ljava/lang/String;
    //   281: aload 13
    //   283: aload_1
    //   284: ldc_w 709
    //   287: ldc 129
    //   289: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   292: putfield 712	com/tencent/mm/protocal/protobuf/aez:mVN	Ljava/lang/String;
    //   295: aload_1
    //   296: ldc 135
    //   298: ldc 129
    //   300: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore 6
    //   305: aload_1
    //   306: ldc 128
    //   308: ldc 129
    //   310: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 7
    //   315: aload_1
    //   316: ldc_w 472
    //   319: iconst_0
    //   320: invokevirtual 272	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   323: istore_3
    //   324: aload_1
    //   325: ldc_w 714
    //   328: ldc 129
    //   330: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   333: astore_1
    //   334: aload 9
    //   336: invokestatic 719	com/tencent/mm/plugin/websearch/api/am:biS	(Ljava/lang/String;)V
    //   339: new 721	android/content/Intent
    //   342: dup
    //   343: invokespecial 722	android/content/Intent:<init>	()V
    //   346: astore 8
    //   348: aload 8
    //   350: ldc_w 724
    //   353: aload 9
    //   355: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   358: pop
    //   359: aload 8
    //   361: ldc_w 730
    //   364: aload 10
    //   366: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   369: pop
    //   370: aload 8
    //   372: ldc_w 732
    //   375: aload 11
    //   377: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   380: pop
    //   381: aload 8
    //   383: ldc_w 734
    //   386: aload 12
    //   388: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   391: pop
    //   392: aload 8
    //   394: ldc_w 736
    //   397: iload_2
    //   398: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   401: pop
    //   402: aload 8
    //   404: ldc_w 741
    //   407: iconst_0
    //   408: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   411: pop
    //   412: aload 8
    //   414: ldc_w 743
    //   417: aload 13
    //   419: invokevirtual 747	com/tencent/mm/protocal/protobuf/aez:toByteArray	()[B
    //   422: invokevirtual 750	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   425: pop
    //   426: new 752	android/os/Bundle
    //   429: dup
    //   430: invokespecial 753	android/os/Bundle:<init>	()V
    //   433: astore 9
    //   435: aload 9
    //   437: ldc_w 755
    //   440: aload 6
    //   442: invokevirtual 758	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload 9
    //   447: ldc_w 760
    //   450: aload 7
    //   452: invokevirtual 758	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 9
    //   457: ldc_w 741
    //   460: iconst_0
    //   461: invokevirtual 764	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   464: aload 9
    //   466: ldc_w 766
    //   469: iload_3
    //   470: invokevirtual 764	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   473: aload 9
    //   475: ldc_w 768
    //   478: aload_1
    //   479: invokevirtual 758	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aload 8
    //   484: ldc_w 770
    //   487: bipush 10
    //   489: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   492: pop
    //   493: aload 8
    //   495: ldc_w 772
    //   498: aload 9
    //   500: invokevirtual 775	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   503: pop
    //   504: invokestatic 780	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   507: ldc_w 782
    //   510: ldc_w 784
    //   513: aload 8
    //   515: invokestatic 789	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   518: goto -362 -> 156
    //   521: astore_1
    //   522: invokestatic 154	com/tencent/mm/plugin/websearch/a/a:gRC	()Lorg/json/JSONObject;
    //   525: invokestatic 114	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   528: astore_1
    //   529: ldc_w 669
    //   532: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   535: aload_1
    //   536: areturn
    //   537: aload 7
    //   539: ldc_w 675
    //   542: invokestatic 143	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   545: aload 9
    //   547: ldc_w 677
    //   550: invokestatic 143	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   553: aload 6
    //   555: ldc_w 673
    //   558: invokestatic 143	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   561: aload 8
    //   563: ldc_w 476
    //   566: invokestatic 143	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   569: new 721	android/content/Intent
    //   572: dup
    //   573: invokespecial 722	android/content/Intent:<init>	()V
    //   576: astore_1
    //   577: aload_1
    //   578: ldc_w 791
    //   581: aload 7
    //   583: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   586: pop
    //   587: aload_1
    //   588: ldc_w 793
    //   591: iconst_0
    //   592: invokevirtual 796	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   595: pop
    //   596: aload_1
    //   597: ldc_w 798
    //   600: iload_2
    //   601: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   604: pop
    //   605: aload_1
    //   606: ldc_w 312
    //   609: iload 4
    //   611: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   614: pop
    //   615: aload_1
    //   616: ldc_w 800
    //   619: aload 8
    //   621: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   624: pop
    //   625: aload 9
    //   627: invokestatic 518	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   630: ifne +23 -> 653
    //   633: aload_1
    //   634: ldc_w 802
    //   637: aload 9
    //   639: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   642: pop
    //   643: aload_1
    //   644: ldc_w 804
    //   647: aload 9
    //   649: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   652: pop
    //   653: iload 5
    //   655: ifle +13 -> 668
    //   658: aload_1
    //   659: ldc_w 806
    //   662: iload 5
    //   664: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   667: pop
    //   668: aload_1
    //   669: ldc_w 808
    //   672: bipush 65
    //   674: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   677: pop
    //   678: aload_1
    //   679: ldc_w 770
    //   682: bipush 10
    //   684: invokevirtual 739	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   687: pop
    //   688: aload 6
    //   690: invokestatic 518	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   693: ifne +13 -> 706
    //   696: aload_1
    //   697: ldc_w 810
    //   700: aload 6
    //   702: invokevirtual 728	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   705: pop
    //   706: invokestatic 780	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   709: ldc_w 812
    //   712: ldc_w 814
    //   715: aload_1
    //   716: invokestatic 789	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   719: goto -563 -> 156
    //   722: astore 9
    //   724: goto -298 -> 426
    //   727: goto -571 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	730	0	this	a
    //   0	730	1	paramString	String
    //   40	561	2	i	int
    //   49	421	3	j	int
    //   58	552	4	k	int
    //   112	551	5	m	int
    //   69	632	6	str1	String
    //   80	502	7	str2	String
    //   91	529	8	localObject1	Object
    //   102	546	9	localObject2	Object
    //   722	1	9	localIOException	java.io.IOException
    //   198	167	10	str3	String
    //   209	167	11	str4	String
    //   229	158	12	str5	String
    //   238	180	13	localaez	com.tencent.mm.protocal.protobuf.aez
    // Exception table:
    //   from	to	target	type
    //   23	114	521	java/lang/Exception
    //   156	169	521	java/lang/Exception
    //   171	412	521	java/lang/Exception
    //   412	426	521	java/lang/Exception
    //   426	518	521	java/lang/Exception
    //   537	653	521	java/lang/Exception
    //   658	668	521	java/lang/Exception
    //   668	706	521	java/lang/Exception
    //   706	719	521	java/lang/Exception
    //   412	426	722	java/io/IOException
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchJSApi$Companion;", "", "()V", "startSearchItemDetailPageBizContact", "", "requestObj", "Lorg/json/JSONObject;", "startSearchItemDetailPageUrl", "url", "", "publishIdFromSearch", "payScene", "", "srcUserName", "searchScene", "subType", "h5PayCookie", "ui-websearch_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    b(a parama, String paramString, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a
 * JD-Core Version:    0.7.0.1
 */