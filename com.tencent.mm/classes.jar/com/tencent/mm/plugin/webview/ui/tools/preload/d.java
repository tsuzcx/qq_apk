package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static List<String> rBo;
  private static List<String> rBp = new ArrayList();
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    rBo = localArrayList;
    localArrayList.add("request");
    rBo.add("updatePageAuth");
    rBo.add("notifyPageInfo");
  }
  
  public static boolean Ua(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.TmplWebViewJsAPi", "[needProcess]function is null, err");
      return false;
    }
    return rBo.contains(paramString);
  }
  
  public static boolean a(i parami, e parame, d.a parama)
  {
    if (parami.rAO.equals("request")) {
      return a(parami, parama);
    }
    if (parami.rAO.equals("updatePageAuth")) {
      return b(parami, parame, parama);
    }
    if (parami.rAO.equals("notifyPageInfo")) {
      return c(parami, parame, parama);
    }
    parama.a(parami, parami.rAO + ":fail", null);
    return true;
  }
  
  /* Error */
  private static boolean a(i parami, d.a parama)
  {
    // Byte code:
    //   0: bipush 70
    //   2: invokestatic 100	com/tencent/mm/plugin/webview/preload/a:if	(I)V
    //   5: aload_0
    //   6: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   9: ldc 106
    //   11: invokeinterface 112 2 0
    //   16: checkcast 64	java/lang/String
    //   19: ldc 114
    //   21: invokestatic 118	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: invokestatic 41	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   31: ifne +17 -> 48
    //   34: ldc 120
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_3
    //   43: aastore
    //   44: invokestatic 124	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   47: astore_2
    //   48: new 78	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   55: aload_0
    //   56: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   59: ldc 126
    //   61: invokeinterface 112 2 0
    //   66: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   81: ldc 131
    //   83: invokeinterface 112 2 0
    //   88: checkcast 64	java/lang/String
    //   91: ldc 133
    //   93: invokestatic 118	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_3
    //   97: aload_0
    //   98: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   101: ldc 135
    //   103: invokeinterface 112 2 0
    //   108: checkcast 64	java/lang/String
    //   111: ldc 114
    //   113: invokestatic 118	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 4
    //   118: aload_0
    //   119: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   122: ldc 137
    //   124: invokeinterface 112 2 0
    //   129: checkcast 64	java/lang/String
    //   132: astore 5
    //   134: ldc 43
    //   136: ldc 139
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_2
    //   145: aastore
    //   146: invokestatic 143	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: getfield 104	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:ndL	Ljava/util/Map;
    //   153: ldc 145
    //   155: invokeinterface 112 2 0
    //   160: checkcast 64	java/lang/String
    //   163: ldc 114
    //   165: invokestatic 118	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 7
    //   170: new 147	java/util/HashMap
    //   173: dup
    //   174: invokespecial 148	java/util/HashMap:<init>	()V
    //   177: astore 6
    //   179: new 150	org/json/JSONObject
    //   182: dup
    //   183: aload 7
    //   185: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   188: astore 7
    //   190: aload 7
    //   192: invokevirtual 157	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   195: astore 8
    //   197: aload 8
    //   199: invokeinterface 163 1 0
    //   204: ifeq +106 -> 310
    //   207: aload 8
    //   209: invokeinterface 167 1 0
    //   214: checkcast 64	java/lang/String
    //   217: astore 9
    //   219: aload 6
    //   221: aload 9
    //   223: aload 7
    //   225: aload 9
    //   227: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokeinterface 175 3 0
    //   235: pop
    //   236: goto -39 -> 197
    //   239: astore 7
    //   241: ldc 43
    //   243: ldc 114
    //   245: iconst_1
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 7
    //   253: aastore
    //   254: invokestatic 178	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: ldc 43
    //   259: ldc 180
    //   261: iconst_4
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_2
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload_3
    //   272: aastore
    //   273: dup
    //   274: iconst_2
    //   275: aload 4
    //   277: aastore
    //   278: dup
    //   279: iconst_3
    //   280: aload 5
    //   282: aastore
    //   283: invokestatic 183	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: invokestatic 189	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   289: new 191	com/tencent/mm/plugin/webview/ui/tools/preload/d$1
    //   292: dup
    //   293: aload_3
    //   294: aload_2
    //   295: aload 6
    //   297: aload 5
    //   299: aload_1
    //   300: aload_0
    //   301: invokespecial 194	com/tencent/mm/plugin/webview/ui/tools/preload/d$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/ui/tools/preload/d$a;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/i;)V
    //   304: invokevirtual 200	com/tencent/mm/sdk/platformtools/ai:O	(Ljava/lang/Runnable;)I
    //   307: pop
    //   308: iconst_1
    //   309: ireturn
    //   310: new 150	org/json/JSONObject
    //   313: dup
    //   314: aload 4
    //   316: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   319: astore 7
    //   321: aload 7
    //   323: invokevirtual 157	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   326: astore 8
    //   328: aload 8
    //   330: invokeinterface 163 1 0
    //   335: ifeq -78 -> 257
    //   338: aload 8
    //   340: invokeinterface 167 1 0
    //   345: checkcast 64	java/lang/String
    //   348: astore 9
    //   350: aload 6
    //   352: aload 9
    //   354: aload 7
    //   356: aload 9
    //   358: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokeinterface 175 3 0
    //   366: pop
    //   367: goto -39 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	parami	i
    //   0	370	1	parama	d.a
    //   26	269	2	str1	String
    //   24	270	3	str2	String
    //   116	199	4	str3	String
    //   132	166	5	str4	String
    //   177	174	6	localHashMap	java.util.HashMap
    //   168	56	7	localObject	Object
    //   239	13	7	localJSONException	JSONException
    //   319	36	7	localJSONObject	JSONObject
    //   195	144	8	localIterator	Iterator
    //   217	140	9	str5	String
    // Exception table:
    //   from	to	target	type
    //   179	197	239	org/json/JSONException
    //   197	236	239	org/json/JSONException
    //   310	328	239	org/json/JSONException
    //   328	367	239	org/json/JSONException
  }
  
  private static boolean b(i parami, e parame, d.a parama)
  {
    a.jdMethod_if(80);
    if (parame == null)
    {
      y.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] callbacker is null, err");
      a.jdMethod_if(82);
      parama.a(parami, "updatePageAuth:fail", null);
      return false;
    }
    try
    {
      Object localObject = parame.f(90003, null);
      if (localObject != null)
      {
        String str = ((Bundle)localObject).getString("geta8key_data_req_url");
        if (rBp.contains(str))
        {
          y.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] updatePageAuth fail, url:%s already run");
          parama.a(parami, "updatePageAuth:fail updating", null);
          a.jdMethod_if(82);
          return false;
        }
        rBp.add(str);
        localObject = new h(str, ((Bundle)localObject).getString("geta8key_data_username"), ((Bundle)localObject).getInt("geta8key_data_scene"), ((Bundle)localObject).getInt("geta8key_data_reason"), ((Bundle)localObject).getInt("geta8key_data_flag"), ((Bundle)localObject).getString("geta8key_data_net_type"), ((Bundle)localObject).getInt("geta8key_session_id", 0), ((Bundle)localObject).getString("geta8key_data_appid"), ((Bundle)localObject).getString("key_function_id"), ((Bundle)localObject).getInt("key_wallet_region", 0), ((Bundle)localObject).getByteArray("k_a8key_cookie"));
        parame = new d.2(str, (h)localObject, parama, parami, parame);
        au.Dk().a(233, parame);
        au.Dk().a((m)localObject, 0);
        return true;
      }
    }
    catch (RemoteException parame)
    {
      y.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", parame, "", new Object[0]);
      a.jdMethod_if(82);
      parama.a(parami, "updatePageAuth:fail", null);
    }
    return false;
  }
  
  private static void c(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        c((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  private static boolean c(i parami, e parame, d.a parama)
  {
    if (parame == null)
    {
      y.e("MicroMsg.TmplWebViewJsAPi", "[notifyPageInfo] callbacker is null, err");
      parama.a(parami, "notifyPageInfo:fail", null);
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)parami.ndL.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)parami.ndL.get("injectPageDataResult"));
      localBundle.putString(e.j.uIa, localJSONObject.toString());
      parame.f(90005, localBundle);
      parama.a(parami, "notifyPageInfo:ok", null);
      return false;
    }
    catch (JSONException parame)
    {
      y.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", parame, "", new Object[0]);
      parama.a(parami, "notifyPageInfo:fail", null);
      return false;
    }
    catch (RemoteException parame)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", parame, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.d
 * JD-Core Version:    0.7.0.1
 */