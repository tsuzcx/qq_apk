package com.tencent.mm.plugin.websearch.webview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi;", "T", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchImageJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IWebSearchQueryUIComponent;)V", "TAG", "", "getMMWebSearchData", "params", "getQueryUIComponent", "getSearchData", "getSearchSuggestionData", "onMMWebSearchDataReady", "", "newQuery", "", "json", "requestId", "onSearchDataReady", "onSearchInputChange", "query", "custom", "onSearchInputConfirm", "onSearchSuggestionDataReady", "openEmojiDesignerPage", "openEmojiProductPage", "openWeAppPage", "openWeAppProfile", "setSearchInputWord", "startSearchItemDetailPage", "Companion", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class o<T>
  extends l<T>
{
  public static final a Wsb = new a((byte)0);
  private final String TAG = "MicroMsg.WebSearch.TagSearchJSApi";
  
  public o(e<T> parame)
  {
    super((d)parame);
  }
  
  private final e<T> iqT()
  {
    c localc = this.WrO;
    if ((localc instanceof e)) {
      return (e)localc;
    }
    return null;
  }
  
  public final void biN(String paramString)
  {
    s.u(paramString, "json");
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("json", paramString);
      label22:
      paramString = this.WrO;
      if (paramString != null)
      {
        paramString = paramString.getWebView();
        if (paramString != null)
        {
          m localm = m.WrX;
          localObject = ((JSONObject)localObject).toString();
          s.s(localObject, "requestObj.toString()");
          m.a(paramString, "onSearchSuggestionDataReady", (String)localObject);
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      break label22;
    }
  }
  
  @JavascriptInterface
  public final String getMMWebSearchData(String paramString)
  {
    Log.i("MicroMsg.WebSearch.BaseWebSearchJSApi", s.X("getSearchDataMore ", paramString));
    if (paramString != null)
    {
      Object localObject = iqT();
      if (localObject != null)
      {
        localObject = ((e)localObject).fyE();
        if (localObject != null) {
          ((n)localObject).biM(paramString);
        }
      }
      paramString = iqR().toString();
      s.s(paramString, "returnSuccess().toString()");
      return paramString;
    }
    paramString = fqu().toString();
    s.s(paramString, "returnFail().toString()");
    return paramString;
  }
  
  @JavascriptInterface
  public String getSearchData(String paramString)
  {
    Log.i(this.TAG, s.X("getSearchData ", paramString));
    if (paramString != null)
    {
      Object localObject = iqT();
      if (localObject != null)
      {
        localObject = ((e)localObject).fyE();
        if (localObject != null) {
          ((n)localObject).aEN(paramString);
        }
      }
      return iqR().toString();
    }
    return fqu().toString();
  }
  
  /* Error */
  @JavascriptInterface
  public String getSearchSuggestionData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/mm/plugin/websearch/webview/o:TAG	Ljava/lang/String;
    //   4: ldc 178
    //   6: aload_1
    //   7: invokestatic 144	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   10: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ifnull +249 -> 263
    //   17: aload_0
    //   18: invokespecial 87	com/tencent/mm/plugin/websearch/webview/o:iqT	()Lcom/tencent/mm/plugin/websearch/webview/e;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +189 -> 212
    //   26: aload_3
    //   27: invokeinterface 154 1 0
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +176 -> 212
    //   39: aload_1
    //   40: ldc 180
    //   42: invokestatic 71	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: new 103	org/json/JSONObject
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: new 184	com/tencent/mm/plugin/websearch/api/w
    //   57: dup
    //   58: invokespecial 185	com/tencent/mm/plugin/websearch/api/w:<init>	()V
    //   61: astore 4
    //   63: aload 4
    //   65: aload_3
    //   66: ldc 186
    //   68: ldc 187
    //   70: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: ldc 193
    //   75: invokestatic 198	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 201	com/tencent/mm/plugin/websearch/api/w:hAB	Ljava/lang/String;
    //   81: aload 4
    //   83: aload_3
    //   84: ldc 203
    //   86: iconst_0
    //   87: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   90: putfield 211	com/tencent/mm/plugin/websearch/api/w:businessType	I
    //   93: aload 4
    //   95: aload_3
    //   96: ldc 213
    //   98: iconst_0
    //   99: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   102: putfield 215	com/tencent/mm/plugin/websearch/api/w:scene	I
    //   105: aload 4
    //   107: aload_3
    //   108: ldc 217
    //   110: iconst_0
    //   111: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   114: putfield 220	com/tencent/mm/plugin/websearch/api/w:Wob	I
    //   117: aload 4
    //   119: aload 5
    //   121: invokevirtual 224	com/tencent/mm/plugin/websearch/webview/n:ipD	()I
    //   124: putfield 227	com/tencent/mm/plugin/websearch/api/w:hVk	I
    //   127: aload_3
    //   128: ldc 229
    //   130: ldc 187
    //   132: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: checkcast 231	java/lang/CharSequence
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull +130 -> 274
    //   147: aload 5
    //   149: invokeinterface 234 1 0
    //   154: ifne +65 -> 219
    //   157: goto +117 -> 274
    //   160: aload_1
    //   161: ifnull +13 -> 174
    //   164: aload 4
    //   166: getfield 238	com/tencent/mm/plugin/websearch/api/w:Wog	Ljava/util/LinkedList;
    //   169: aload_1
    //   170: invokevirtual 244	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: aload_3
    //   175: ldc 246
    //   177: iconst_0
    //   178: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   181: istore_2
    //   182: aload 4
    //   184: aload_3
    //   185: ldc 248
    //   187: iconst_0
    //   188: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   191: putfield 250	com/tencent/mm/plugin/websearch/api/w:subtype	I
    //   194: iload_2
    //   195: tableswitch	default:+17 -> 212, 0:+39->234
    //   213: nop
    //   214: if_icmpgt -18944 -> -18730
    //   217: lushr
    //   218: areturn
    //   219: iconst_0
    //   220: istore_2
    //   221: goto +55 -> 276
    //   224: iconst_0
    //   225: istore_2
    //   226: goto +56 -> 282
    //   229: aconst_null
    //   230: astore_1
    //   231: goto -71 -> 160
    //   234: new 252	com/tencent/mm/plugin/websearch/api/t
    //   237: dup
    //   238: aload 4
    //   240: invokespecial 255	com/tencent/mm/plugin/websearch/api/t:<init>	(Lcom/tencent/mm/plugin/websearch/api/w;)V
    //   243: astore_1
    //   244: invokestatic 261	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   247: aload_1
    //   248: checkcast 263	com/tencent/mm/am/p
    //   251: iconst_0
    //   252: invokevirtual 268	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   255: pop
    //   256: goto -44 -> 212
    //   259: astore_1
    //   260: goto -48 -> 212
    //   263: invokestatic 168	com/tencent/mm/plugin/websearch/webview/o:fqu	()Lorg/json/JSONObject;
    //   266: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   269: areturn
    //   270: astore_1
    //   271: goto -190 -> 81
    //   274: iconst_1
    //   275: istore_2
    //   276: iload_2
    //   277: ifne -53 -> 224
    //   280: iconst_1
    //   281: istore_2
    //   282: iload_2
    //   283: ifeq -54 -> 229
    //   286: goto -126 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	o
    //   0	289	1	paramString	String
    //   181	102	2	i	int
    //   21	164	3	localObject1	Object
    //   61	178	4	localw	com.tencent.mm.plugin.websearch.api.w
    //   32	116	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	63	259	java/lang/Exception
    //   81	142	259	java/lang/Exception
    //   147	157	259	java/lang/Exception
    //   164	174	259	java/lang/Exception
    //   174	194	259	java/lang/Exception
    //   234	256	259	java/lang/Exception
    //   63	81	270	java/lang/Exception
  }
  
  public final void h(boolean paramBoolean, String paramString1, String paramString2)
  {
    s.u(paramString1, "json");
    s.u(paramString2, "requestId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("newQuery", paramBoolean);
      localJSONObject.put("json", paramString1);
      localJSONObject.put("requestId", paramString2);
      label51:
      paramString1 = this.WrO;
      if (paramString1 != null)
      {
        paramString1 = paramString1.getWebView();
        if (paramString1 != null)
        {
          paramString2 = m.WrX;
          paramString2 = localJSONObject.toString();
          s.s(paramString2, "requestObj.toString()");
          m.a(paramString1, "onSearchDataReady", paramString2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      break label51;
    }
  }
  
  public final void i(boolean paramBoolean, String paramString1, String paramString2)
  {
    s.u(paramString1, "json");
    s.u(paramString2, "requestId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("newQuery", paramBoolean);
      localJSONObject.put("json", paramString1);
      localJSONObject.put("requestId", paramString2);
      label51:
      paramString1 = this.WrO;
      if (paramString1 != null)
      {
        paramString1 = paramString1.getWebView();
        if (paramString1 != null)
        {
          paramString2 = m.WrX;
          paramString2 = localJSONObject.toString();
          s.s(paramString2, "requestObj.toString()");
          m.a(paramString1, "onMMWebSearchDataReady", paramString2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      break label51;
    }
  }
  
  public final void nW(String paramString1, String paramString2)
  {
    s.u(paramString1, "query");
    s.u(paramString2, "custom");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("query", paramString1);
      localJSONObject.put("custom", paramString2);
      label38:
      paramString1 = this.WrO;
      if (paramString1 != null)
      {
        paramString1 = paramString1.getWebView();
        if (paramString1 != null)
        {
          paramString2 = m.WrX;
          paramString2 = localJSONObject.toString();
          s.s(paramString2, "requestObj.toString()");
          m.a(paramString1, "onSearchInputConfirm", paramString2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      break label38;
    }
  }
  
  public final void nX(String paramString1, String paramString2)
  {
    s.u(paramString1, "query");
    s.u(paramString2, "custom");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("query", paramString1);
      localJSONObject.put("custom", paramString2);
      label38:
      paramString1 = this.WrO;
      if (paramString1 != null)
      {
        paramString1 = paramString1.getWebView();
        if (paramString1 != null)
        {
          paramString2 = m.WrX;
          paramString2 = localJSONObject.toString();
          s.s(paramString2, "requestObj.toString()");
          m.a(paramString1, "onSearchInputChange", paramString2);
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      break label38;
    }
  }
  
  @JavascriptInterface
  public final String openEmojiDesignerPage(String paramString)
  {
    Log.i(this.TAG, "openEmojiDesignerPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("precedingScene", 0);
      int j = ((JSONObject)localObject).optInt("entranceScene", 0);
      boolean bool = ((JSONObject)localObject).optBoolean("fromPop", true);
      paramString = ((JSONObject)localObject).optString("searchId", "");
      String str1 = ((JSONObject)localObject).optString("docId", "");
      String str2 = ((JSONObject)localObject).optString("designerId", "");
      String str3 = ((JSONObject)localObject).optString("designerName", "");
      String str4 = ((JSONObject)localObject).optString("designerThumbUrl", "");
      int k = ((JSONObject)localObject).optInt("scene", 0);
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", i);
      ((Intent)localObject).putExtra("download_entrance_scene", j);
      ((Intent)localObject).putExtra("from_popup", bool);
      ((Intent)localObject).putExtra("searchID", paramString);
      ((Intent)localObject).putExtra("docID", str1);
      ((Intent)localObject).putExtra("extra_scence", 27);
      ((Intent)localObject).putExtra("id", str2);
      ((Intent)localObject).putExtra("name", str3);
      ((Intent)localObject).putExtra("headurl", str4);
      ((Intent)localObject).putExtra("extra_scence", k);
      paramString = iqT();
      if (paramString != null)
      {
        com.tencent.mm.br.c.b(paramString.getActivityContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", (Intent)localObject);
        paramString = iqR().toString();
        s.s(paramString, "returnSuccess().toString()");
        return paramString;
      }
      paramString = fqu().toString();
      s.s(paramString, "returnFail().toString()");
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openEmojiDesignerPage", new Object[0]);
      paramString = fqu().toString();
      s.s(paramString, "returnFail().toString()");
    }
    return paramString;
  }
  
  @JavascriptInterface
  public final String openEmojiProductPage(String paramString)
  {
    Log.i(this.TAG, "openEmojiProductPage %s", new Object[] { paramString });
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("productId");
      int i = ((JSONObject)localObject).optInt("precedingScene", 0);
      int j = ((JSONObject)localObject).optInt("entranceScene", 0);
      boolean bool = ((JSONObject)localObject).optBoolean("fromPop", true);
      String str1 = ((JSONObject)localObject).optString("searchId", "");
      String str2 = ((JSONObject)localObject).optString("docId", "");
      int k = ((JSONObject)localObject).optInt("scene", 0);
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", i);
      ((Intent)localObject).putExtra("download_entrance_scene", j);
      ((Intent)localObject).putExtra("from_popup", bool);
      ((Intent)localObject).putExtra("extra_id", paramString);
      ((Intent)localObject).putExtra("searchID", str1);
      ((Intent)localObject).putExtra("docID", str2);
      ((Intent)localObject).putExtra("extra_scence", k);
      paramString = iqT();
      if (paramString != null)
      {
        com.tencent.mm.br.c.b(paramString.getActivityContext(), "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject);
        return iqR().toString();
      }
      paramString = fqu().toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openEmojiProductPage", new Object[0]);
    }
    return fqu().toString();
  }
  
  /* Error */
  @JavascriptInterface
  public final String openWeAppPage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/mm/plugin/websearch/webview/o:TAG	Ljava/lang/String;
    //   4: ldc_w 374
    //   7: iconst_1
    //   8: anewarray 286	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: new 103	org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 8
    //   28: aload 8
    //   30: ldc_w 376
    //   33: ldc 187
    //   35: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 9
    //   40: aload 8
    //   42: ldc_w 378
    //   45: ldc 187
    //   47: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 7
    //   52: aload 7
    //   54: ldc_w 378
    //   57: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   60: aload 7
    //   62: checkcast 231	java/lang/CharSequence
    //   65: ldc_w 380
    //   68: checkcast 231	java/lang/CharSequence
    //   71: invokestatic 385	kotlin/n/n:i	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   74: istore 6
    //   76: aload 7
    //   78: astore_1
    //   79: iload 6
    //   81: ifeq +713 -> 794
    //   84: aload 7
    //   86: astore_1
    //   87: new 103	org/json/JSONObject
    //   90: dup
    //   91: aload 7
    //   93: invokestatic 391	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   96: ldc_w 393
    //   99: invokevirtual 396	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   105: astore 10
    //   107: aload 7
    //   109: astore_1
    //   110: aload 10
    //   112: ldc_w 380
    //   115: invokevirtual 400	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   118: pop
    //   119: aload 7
    //   121: astore_1
    //   122: aload 7
    //   124: ldc_w 378
    //   127: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   130: aload 7
    //   132: astore_1
    //   133: aload 7
    //   135: checkcast 231	java/lang/CharSequence
    //   138: astore 11
    //   140: aload 7
    //   142: astore_1
    //   143: new 402	kotlin/n/k
    //   146: dup
    //   147: ldc_w 404
    //   150: invokespecial 405	kotlin/n/k:<init>	(Ljava/lang/String;)V
    //   153: aload 11
    //   155: ldc_w 407
    //   158: invokevirtual 411	kotlin/n/k:e	(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 7
    //   163: aload 7
    //   165: astore_1
    //   166: new 413	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   173: aload 7
    //   175: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 420
    //   181: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 10
    //   186: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore 7
    //   194: aload 7
    //   196: astore_1
    //   197: aload 8
    //   199: ldc_w 426
    //   202: iconst_0
    //   203: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   206: istore_3
    //   207: aload 8
    //   209: ldc_w 301
    //   212: ldc 187
    //   214: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 10
    //   219: aload 8
    //   221: ldc_w 303
    //   224: ldc 187
    //   226: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 11
    //   231: aload 8
    //   233: ldc_w 428
    //   236: iconst_1
    //   237: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   240: istore 4
    //   242: aload 8
    //   244: ldc 213
    //   246: sipush 1000
    //   249: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   252: istore 5
    //   254: aload 8
    //   256: ldc_w 430
    //   259: iconst_0
    //   260: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   263: istore_2
    //   264: aload 8
    //   266: ldc_w 432
    //   269: ldc 187
    //   271: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 7
    //   276: aload 8
    //   278: ldc_w 434
    //   281: ldc 187
    //   283: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   286: astore 13
    //   288: new 103	org/json/JSONObject
    //   291: dup
    //   292: invokespecial 105	org/json/JSONObject:<init>	()V
    //   295: astore 14
    //   297: aload 14
    //   299: ldc_w 436
    //   302: aload 7
    //   304: invokevirtual 109	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   307: pop
    //   308: iload_2
    //   309: ifge +479 -> 788
    //   312: iconst_0
    //   313: istore_2
    //   314: new 438	com/tencent/mm/autogen/a/zp
    //   317: dup
    //   318: invokespecial 439	com/tencent/mm/autogen/a/zp:<init>	()V
    //   321: astore 12
    //   323: aload 12
    //   325: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   328: astore 15
    //   330: aload_0
    //   331: invokespecial 87	com/tencent/mm/plugin/websearch/webview/o:iqT	()Lcom/tencent/mm/plugin/websearch/webview/e;
    //   334: astore 7
    //   336: aload 7
    //   338: ifnonnull +324 -> 662
    //   341: aconst_null
    //   342: astore 7
    //   344: aload 15
    //   346: aload 7
    //   348: putfield 449	com/tencent/mm/autogen/a/zp$a:context	Landroid/content/Context;
    //   351: aload 12
    //   353: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   356: aload 9
    //   358: putfield 451	com/tencent/mm/autogen/a/zp$a:userName	Ljava/lang/String;
    //   361: aload 12
    //   363: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   366: aload_1
    //   367: putfield 454	com/tencent/mm/autogen/a/zp$a:icO	Ljava/lang/String;
    //   370: aload 12
    //   372: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   375: iload_3
    //   376: putfield 456	com/tencent/mm/autogen/a/zp$a:appVersion	I
    //   379: aload 12
    //   381: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   384: ldc_w 458
    //   387: putfield 461	com/tencent/mm/autogen/a/zp$a:idc	Ljava/lang/String;
    //   390: aload 12
    //   392: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   395: aload 14
    //   397: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   400: putfield 464	com/tencent/mm/autogen/a/zp$a:idd	Ljava/lang/String;
    //   403: aload 13
    //   405: invokestatic 470	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   408: ifeq +266 -> 674
    //   411: aload 12
    //   413: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   416: aload 9
    //   418: putfield 473	com/tencent/mm/autogen/a/zp$a:idb	Ljava/lang/String;
    //   421: aload 12
    //   423: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   426: iload_2
    //   427: putfield 476	com/tencent/mm/autogen/a/zp$a:icP	I
    //   430: iload 5
    //   432: lookupswitch	default:+359->791, 3:+295->727, 14:+281->713, 16:+309->741, 20:+323->755, 22:+281->713, 42:+337->769, 52:+337->769, 201:+281->713
    //   509: fconst_1
    //   510: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   513: sipush 1000
    //   516: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   519: aload 8
    //   521: ldc_w 479
    //   524: ldc 187
    //   526: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   529: astore_1
    //   530: aload 8
    //   532: ldc_w 481
    //   535: ldc 187
    //   537: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   540: astore 7
    //   542: aload 8
    //   544: ldc_w 483
    //   547: ldc 187
    //   549: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   552: astore 8
    //   554: aload 12
    //   556: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   559: new 413	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   566: aload_1
    //   567: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   570: bipush 58
    //   572: invokevirtual 486	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   575: aload 7
    //   577: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: bipush 58
    //   582: invokevirtual 486	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   585: aload 10
    //   587: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   590: bipush 58
    //   592: invokevirtual 486	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   595: aload 11
    //   597: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   600: bipush 58
    //   602: invokevirtual 486	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   605: iload 4
    //   607: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: bipush 58
    //   612: invokevirtual 486	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   615: aload 8
    //   617: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 424	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: putfield 492	com/tencent/mm/autogen/a/zp$a:hzx	Ljava/lang/String;
    //   626: aload 12
    //   628: invokevirtual 496	com/tencent/mm/autogen/a/zp:publish	()Z
    //   631: pop
    //   632: invokestatic 163	com/tencent/mm/plugin/websearch/webview/o:iqR	()Lorg/json/JSONObject;
    //   635: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   638: areturn
    //   639: astore 7
    //   641: aload_0
    //   642: getfield 80	com/tencent/mm/plugin/websearch/webview/o:TAG	Ljava/lang/String;
    //   645: aload 7
    //   647: checkcast 356	java/lang/Throwable
    //   650: ldc 187
    //   652: iconst_0
    //   653: anewarray 286	java/lang/Object
    //   656: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   659: goto +135 -> 794
    //   662: aload 7
    //   664: invokeinterface 344 1 0
    //   669: astore 7
    //   671: goto -327 -> 344
    //   674: aload 12
    //   676: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   679: aload 13
    //   681: putfield 473	com/tencent/mm/autogen/a/zp$a:idb	Ljava/lang/String;
    //   684: goto -263 -> 421
    //   687: astore_1
    //   688: aload_0
    //   689: getfield 80	com/tencent/mm/plugin/websearch/webview/o:TAG	Ljava/lang/String;
    //   692: aload_1
    //   693: checkcast 356	java/lang/Throwable
    //   696: ldc_w 497
    //   699: iconst_0
    //   700: anewarray 286	java/lang/Object
    //   703: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: invokestatic 168	com/tencent/mm/plugin/websearch/webview/o:fqu	()Lorg/json/JSONObject;
    //   709: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   712: areturn
    //   713: aload 12
    //   715: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   718: sipush 1006
    //   721: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   724: goto -205 -> 519
    //   727: aload 12
    //   729: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   732: sipush 1005
    //   735: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   738: goto -219 -> 519
    //   741: aload 12
    //   743: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   746: sipush 1042
    //   749: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   752: goto -233 -> 519
    //   755: aload 12
    //   757: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   760: sipush 1053
    //   763: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   766: goto -247 -> 519
    //   769: aload 12
    //   771: getfield 443	com/tencent/mm/autogen/a/zp:icM	Lcom/tencent/mm/autogen/a/zp$a;
    //   774: sipush 1106
    //   777: putfield 477	com/tencent/mm/autogen/a/zp$a:scene	I
    //   780: goto -261 -> 519
    //   783: astore 7
    //   785: goto -477 -> 308
    //   788: goto -474 -> 314
    //   791: goto -283 -> 508
    //   794: goto -597 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	this	o
    //   0	797	1	paramString	String
    //   263	164	2	i	int
    //   206	170	3	j	int
    //   240	366	4	k	int
    //   252	179	5	m	int
    //   74	6	6	bool	boolean
    //   50	526	7	localObject1	Object
    //   639	24	7	localException1	Exception
    //   669	1	7	localContext	android.content.Context
    //   783	1	7	localException2	Exception
    //   26	590	8	localObject2	Object
    //   38	379	9	str1	String
    //   105	481	10	localObject3	Object
    //   138	458	11	localObject4	Object
    //   321	449	12	localzp	com.tencent.mm.autogen.a.zp
    //   286	394	13	str2	String
    //   295	101	14	localJSONObject	JSONObject
    //   328	17	15	locala	com.tencent.mm.autogen.a.zp.a
    // Exception table:
    //   from	to	target	type
    //   87	107	639	java/lang/Exception
    //   110	119	639	java/lang/Exception
    //   122	130	639	java/lang/Exception
    //   133	140	639	java/lang/Exception
    //   143	163	639	java/lang/Exception
    //   166	194	639	java/lang/Exception
    //   18	76	687	java/lang/Exception
    //   197	297	687	java/lang/Exception
    //   314	336	687	java/lang/Exception
    //   344	421	687	java/lang/Exception
    //   421	430	687	java/lang/Exception
    //   508	519	687	java/lang/Exception
    //   519	639	687	java/lang/Exception
    //   641	659	687	java/lang/Exception
    //   662	671	687	java/lang/Exception
    //   674	684	687	java/lang/Exception
    //   713	724	687	java/lang/Exception
    //   727	738	687	java/lang/Exception
    //   741	752	687	java/lang/Exception
    //   755	766	687	java/lang/Exception
    //   769	780	687	java/lang/Exception
    //   297	308	783	java/lang/Exception
  }
  
  @JavascriptInterface
  public final String openWeAppProfile(String paramString)
  {
    Log.i(this.TAG, "openWeAppProfile %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = paramString.optString("searchId", "");
      String str = paramString.optString("docId", "");
      int i = paramString.optInt("scene", 0);
      int j = paramString.optInt("fromScene", 0);
      int k = paramString.optInt("type", 0);
      paramString = paramString.optString("weAppUsername", "");
      Bundle localBundle = new Bundle();
      localBundle.putInt("stat_scene", 8);
      localBundle.putString("stat_search_id", (String)localObject);
      str = localObject + ':' + str + ':' + i + ':' + k;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_username", paramString);
      ((Intent)localObject).putExtra("key_can_swipe_back", true);
      ((Intent)localObject).putExtra("key_from_scene", j);
      ((Intent)localObject).putExtra("key_scene_note", str);
      ((Intent)localObject).putExtra("_stat_obj", localBundle);
      paramString = iqT();
      if (paramString != null)
      {
        com.tencent.mm.br.c.b(paramString.getActivityContext(), "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject);
        return iqR().toString();
      }
      paramString = fqu().toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramString, "openWeAppProfile", new Object[0]);
    }
    return fqu().toString();
  }
  
  @JavascriptInterface
  public String setSearchInputWord(String paramString)
  {
    Log.i(this.TAG, s.X("setSearchInputWord ", paramString));
    try
    {
      paramString = new JSONObject(paramString);
      com.tencent.mm.ae.d.uiThread((a)new b(this, paramString.optString("word", ""), paramString.optBoolean("isInputChange", false)));
      paramString = iqR().toString();
      return paramString;
    }
    catch (Exception paramString) {}
    return fqu().toString();
  }
  
  /* Error */
  @JavascriptInterface
  public String startSearchItemDetailPage(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/mm/plugin/websearch/webview/o:TAG	Ljava/lang/String;
    //   4: ldc_w 556
    //   7: aload_1
    //   8: invokestatic 144	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   11: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 103	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 213
    //   26: iconst_0
    //   27: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   30: istore_2
    //   31: aload_1
    //   32: ldc 203
    //   34: iconst_0
    //   35: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   38: istore_3
    //   39: aload_1
    //   40: ldc_w 558
    //   43: iconst_0
    //   44: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   47: istore 4
    //   49: aload_1
    //   50: ldc_w 560
    //   53: ldc 187
    //   55: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 6
    //   60: aload_1
    //   61: ldc_w 562
    //   64: ldc 187
    //   66: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 7
    //   71: aload_1
    //   72: ldc_w 432
    //   75: ldc 187
    //   77: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 8
    //   82: aload_1
    //   83: ldc_w 564
    //   86: ldc 187
    //   88: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 9
    //   93: aload_1
    //   94: ldc_w 566
    //   97: iconst_0
    //   98: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   101: istore 5
    //   103: iload_3
    //   104: lookupswitch	default:+599->703, 1:+51->155, 2:+410->514, 4:+410->514, 16:+410->514
    //   149: nop
    //   150: if_icmpgt -18944 -> -18794
    //   153: lushr
    //   154: areturn
    //   155: aload_1
    //   156: ldc_w 568
    //   159: invokestatic 71	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   162: aload_1
    //   163: ldc_w 376
    //   166: ldc 187
    //   168: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 9
    //   173: aload_1
    //   174: ldc_w 570
    //   177: ldc 187
    //   179: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 10
    //   184: aload_1
    //   185: ldc_w 572
    //   188: ldc 187
    //   190: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 11
    //   195: aload_1
    //   196: ldc_w 574
    //   199: iconst_0
    //   200: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   203: istore_2
    //   204: aload_1
    //   205: ldc_w 576
    //   208: ldc 187
    //   210: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   213: astore 12
    //   215: new 578	com/tencent/mm/protocal/protobuf/ahl
    //   218: dup
    //   219: invokespecial 579	com/tencent/mm/protocal/protobuf/ahl:<init>	()V
    //   222: astore 13
    //   224: aload 13
    //   226: aload_1
    //   227: ldc_w 581
    //   230: iconst_0
    //   231: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   234: putfield 584	com/tencent/mm/protocal/protobuf/ahl:pSt	I
    //   237: aload 13
    //   239: aload_1
    //   240: ldc_w 586
    //   243: ldc 187
    //   245: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: putfield 589	com/tencent/mm/protocal/protobuf/ahl:pSw	Ljava/lang/String;
    //   251: aload 13
    //   253: aload_1
    //   254: ldc_w 591
    //   257: ldc 187
    //   259: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: putfield 594	com/tencent/mm/protocal/protobuf/ahl:pSv	Ljava/lang/String;
    //   265: aload 13
    //   267: aload_1
    //   268: ldc_w 596
    //   271: ldc 187
    //   273: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   276: putfield 599	com/tencent/mm/protocal/protobuf/ahl:pSu	Ljava/lang/String;
    //   279: aload_1
    //   280: ldc_w 301
    //   283: ldc 187
    //   285: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 6
    //   290: aload_1
    //   291: ldc 186
    //   293: ldc 187
    //   295: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   298: astore 7
    //   300: aload_1
    //   301: ldc_w 428
    //   304: iconst_0
    //   305: invokevirtual 207	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   308: istore_3
    //   309: aload_1
    //   310: ldc_w 601
    //   313: ldc 187
    //   315: invokevirtual 191	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   318: astore_1
    //   319: aload 9
    //   321: invokestatic 606	com/tencent/mm/plugin/websearch/api/an:biA	(Ljava/lang/String;)V
    //   324: new 311	android/content/Intent
    //   327: dup
    //   328: invokespecial 312	android/content/Intent:<init>	()V
    //   331: astore 8
    //   333: aload 8
    //   335: ldc_w 608
    //   338: aload 9
    //   340: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   343: pop
    //   344: aload 8
    //   346: ldc_w 610
    //   349: aload 10
    //   351: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   354: pop
    //   355: aload 8
    //   357: ldc_w 612
    //   360: aload 11
    //   362: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   365: pop
    //   366: aload 8
    //   368: ldc_w 614
    //   371: aload 12
    //   373: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   376: pop
    //   377: aload 8
    //   379: ldc_w 616
    //   382: iload_2
    //   383: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   386: pop
    //   387: aload 8
    //   389: ldc_w 618
    //   392: iconst_0
    //   393: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   396: pop
    //   397: aload 8
    //   399: ldc_w 620
    //   402: aload 13
    //   404: invokevirtual 624	com/tencent/mm/protocal/protobuf/ahl:toByteArray	()[B
    //   407: invokevirtual 627	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   410: pop
    //   411: new 505	android/os/Bundle
    //   414: dup
    //   415: invokespecial 506	android/os/Bundle:<init>	()V
    //   418: astore 9
    //   420: aload 9
    //   422: ldc_w 629
    //   425: aload 6
    //   427: invokevirtual 517	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aload 9
    //   432: ldc_w 631
    //   435: aload 7
    //   437: invokevirtual 517	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload 9
    //   442: ldc_w 618
    //   445: iconst_0
    //   446: invokevirtual 512	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   449: aload 9
    //   451: ldc_w 633
    //   454: iload_3
    //   455: invokevirtual 512	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   458: aload 9
    //   460: ldc_w 635
    //   463: aload_1
    //   464: invokevirtual 517	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 8
    //   469: ldc_w 637
    //   472: bipush 10
    //   474: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   477: pop
    //   478: aload 8
    //   480: ldc_w 639
    //   483: aload 9
    //   485: invokevirtual 530	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   488: pop
    //   489: invokestatic 644	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   492: ldc_w 646
    //   495: ldc_w 648
    //   498: aload 8
    //   500: invokestatic 354	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   503: goto -355 -> 148
    //   506: astore_1
    //   507: invokestatic 168	com/tencent/mm/plugin/websearch/webview/o:fqu	()Lorg/json/JSONObject;
    //   510: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   513: areturn
    //   514: aload 7
    //   516: ldc_w 562
    //   519: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   522: aload 9
    //   524: ldc_w 564
    //   527: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   530: aload 6
    //   532: ldc_w 560
    //   535: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   538: aload 8
    //   540: ldc_w 432
    //   543: invokestatic 130	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   546: new 311	android/content/Intent
    //   549: dup
    //   550: invokespecial 312	android/content/Intent:<init>	()V
    //   553: astore_1
    //   554: aload_1
    //   555: ldc_w 650
    //   558: aload 7
    //   560: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   563: pop
    //   564: aload_1
    //   565: ldc_w 652
    //   568: iconst_0
    //   569: invokevirtual 325	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   572: pop
    //   573: aload_1
    //   574: ldc_w 654
    //   577: iload_2
    //   578: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   581: pop
    //   582: aload_1
    //   583: ldc 248
    //   585: iload 4
    //   587: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   590: pop
    //   591: aload_1
    //   592: ldc_w 656
    //   595: aload 8
    //   597: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   600: pop
    //   601: aload 9
    //   603: invokestatic 470	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   606: ifne +23 -> 629
    //   609: aload_1
    //   610: ldc_w 658
    //   613: aload 9
    //   615: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   618: pop
    //   619: aload_1
    //   620: ldc_w 660
    //   623: aload 9
    //   625: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   628: pop
    //   629: iload 5
    //   631: ifle +13 -> 644
    //   634: aload_1
    //   635: ldc_w 662
    //   638: iload 5
    //   640: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   643: pop
    //   644: aload_1
    //   645: ldc_w 664
    //   648: bipush 65
    //   650: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   653: pop
    //   654: aload_1
    //   655: ldc_w 637
    //   658: bipush 10
    //   660: invokevirtual 318	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   663: pop
    //   664: aload 6
    //   666: invokestatic 470	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   669: ifne +13 -> 682
    //   672: aload_1
    //   673: ldc_w 666
    //   676: aload 6
    //   678: invokevirtual 330	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   681: pop
    //   682: invokestatic 644	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   685: ldc_w 668
    //   688: ldc_w 670
    //   691: aload_1
    //   692: invokestatic 354	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   695: goto -547 -> 148
    //   698: astore 9
    //   700: goto -289 -> 411
    //   703: goto -555 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	o
    //   0	706	1	paramString	String
    //   30	548	2	i	int
    //   38	417	3	j	int
    //   47	539	4	k	int
    //   101	538	5	m	int
    //   58	619	6	str1	String
    //   69	490	7	str2	String
    //   80	516	8	localObject1	Object
    //   91	533	9	localObject2	Object
    //   698	1	9	localIOException	java.io.IOException
    //   182	168	10	str3	String
    //   193	168	11	str4	String
    //   213	159	12	str5	String
    //   222	181	13	localahl	com.tencent.mm.protocal.protobuf.ahl
    // Exception table:
    //   from	to	target	type
    //   14	103	506	java/lang/Exception
    //   148	155	506	java/lang/Exception
    //   155	397	506	java/lang/Exception
    //   397	411	506	java/lang/Exception
    //   411	503	506	java/lang/Exception
    //   514	629	506	java/lang/Exception
    //   634	644	506	java/lang/Exception
    //   644	682	506	java/lang/Exception
    //   682	695	506	java/lang/Exception
    //   397	411	698	java/io/IOException
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchQueryJSApi$Companion;", "", "()V", "startSearchItemDetailPageBizContact", "", "requestObj", "Lorg/json/JSONObject;", "startSearchItemDetailPageUrl", "url", "", "publishIdFromSearch", "payScene", "", "srcUserName", "searchScene", "subType", "h5PayCookie", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(o<T> paramo, String paramString, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.o
 * JD-Core Version:    0.7.0.1
 */