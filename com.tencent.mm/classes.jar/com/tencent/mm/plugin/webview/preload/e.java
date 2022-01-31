package com.tencent.mm.plugin.webview.preload;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class e
{
  private static List<String> uYU;
  private static List<String> uYV;
  
  static
  {
    AppMethodBeat.i(7056);
    ArrayList localArrayList = new ArrayList();
    uYU = localArrayList;
    localArrayList.add("request");
    uYU.add("updatePageAuth");
    uYV = new ArrayList();
    AppMethodBeat.o(7056);
  }
  
  /* Error */
  private static boolean a(i parami, e.a parama)
  {
    // Byte code:
    //   0: sipush 7051
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: bipush 70
    //   8: invokestatic 52	com/tencent/mm/plugin/webview/preload/a:kS	(I)V
    //   11: aload_0
    //   12: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   15: ldc 60
    //   17: invokeinterface 66 2 0
    //   22: checkcast 68	java/lang/String
    //   25: ldc 70
    //   27: invokestatic 76	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: invokestatic 80	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +17 -> 54
    //   40: ldc 82
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_3
    //   49: aastore
    //   50: invokestatic 86	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   53: astore_2
    //   54: new 88	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   61: aload_0
    //   62: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   65: ldc 91
    //   67: invokeinterface 66 2 0
    //   72: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_0
    //   84: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   87: ldc 104
    //   89: invokeinterface 66 2 0
    //   94: checkcast 68	java/lang/String
    //   97: ldc 106
    //   99: invokestatic 76	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   107: ldc 108
    //   109: invokeinterface 66 2 0
    //   114: checkcast 68	java/lang/String
    //   117: ldc 70
    //   119: invokestatic 76	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   128: ldc 110
    //   130: invokeinterface 66 2 0
    //   135: checkcast 68	java/lang/String
    //   138: astore 5
    //   140: ldc 112
    //   142: ldc 114
    //   144: iconst_1
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_2
    //   151: aastore
    //   152: invokestatic 119	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_0
    //   156: getfield 58	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   159: ldc 121
    //   161: invokeinterface 66 2 0
    //   166: checkcast 68	java/lang/String
    //   169: ldc 70
    //   171: invokestatic 76	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 7
    //   176: new 123	java/util/HashMap
    //   179: dup
    //   180: invokespecial 124	java/util/HashMap:<init>	()V
    //   183: astore 6
    //   185: new 126	org/json/JSONObject
    //   188: dup
    //   189: aload 7
    //   191: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   194: astore 7
    //   196: aload 7
    //   198: invokevirtual 133	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   201: astore 8
    //   203: aload 8
    //   205: invokeinterface 139 1 0
    //   210: ifeq +108 -> 318
    //   213: aload 8
    //   215: invokeinterface 143 1 0
    //   220: checkcast 68	java/lang/String
    //   223: astore 9
    //   225: aload 6
    //   227: aload 9
    //   229: aload 7
    //   231: aload 9
    //   233: invokevirtual 147	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokeinterface 151 3 0
    //   241: pop
    //   242: goto -39 -> 203
    //   245: astore 7
    //   247: ldc 112
    //   249: ldc 70
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload 7
    //   259: aastore
    //   260: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 112
    //   265: ldc 156
    //   267: iconst_4
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload_2
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: aload_3
    //   278: aastore
    //   279: dup
    //   280: iconst_2
    //   281: aload 4
    //   283: aastore
    //   284: dup
    //   285: iconst_3
    //   286: aload 5
    //   288: aastore
    //   289: invokestatic 159	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: new 161	com/tencent/mm/plugin/webview/preload/e$1
    //   295: dup
    //   296: aload_3
    //   297: aload_2
    //   298: aload 6
    //   300: aload 5
    //   302: aload_1
    //   303: aload_0
    //   304: invokespecial 164	com/tencent/mm/plugin/webview/preload/e$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/preload/e$a;Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/i;)V
    //   307: invokestatic 170	com/tencent/mm/plugin/webview/a/a:O	(Ljava/lang/Runnable;)V
    //   310: sipush 7051
    //   313: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: iconst_1
    //   317: ireturn
    //   318: new 126	org/json/JSONObject
    //   321: dup
    //   322: aload 4
    //   324: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   327: astore 7
    //   329: aload 7
    //   331: invokevirtual 133	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   334: astore 8
    //   336: aload 8
    //   338: invokeinterface 139 1 0
    //   343: ifeq -80 -> 263
    //   346: aload 8
    //   348: invokeinterface 143 1 0
    //   353: checkcast 68	java/lang/String
    //   356: astore 9
    //   358: aload 6
    //   360: aload 9
    //   362: aload 7
    //   364: aload 9
    //   366: invokevirtual 147	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: invokeinterface 151 3 0
    //   374: pop
    //   375: goto -39 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	parami	i
    //   0	378	1	parama	e.a
    //   32	266	2	str1	String
    //   30	267	3	str2	String
    //   122	201	4	str3	String
    //   138	163	5	str4	String
    //   183	176	6	localHashMap	HashMap
    //   174	56	7	localObject	Object
    //   245	13	7	localJSONException	org.json.JSONException
    //   327	36	7	localJSONObject	JSONObject
    //   201	146	8	localIterator	Iterator
    //   223	142	9	str5	String
    // Exception table:
    //   from	to	target	type
    //   185	203	245	org/json/JSONException
    //   203	242	245	org/json/JSONException
    //   318	336	245	org/json/JSONException
    //   336	375	245	org/json/JSONException
  }
  
  public static boolean a(i parami, com.tencent.mm.plugin.webview.stub.e parame, e.a parama)
  {
    AppMethodBeat.i(7050);
    boolean bool;
    if (parami.vrQ.equals("request"))
    {
      bool = a(parami, parama);
      AppMethodBeat.o(7050);
      return bool;
    }
    if (parami.vrQ.equals("updatePageAuth"))
    {
      bool = b(parami, parame, parama);
      AppMethodBeat.o(7050);
      return bool;
    }
    parama.a(parami, parami.vrQ + ":fail", null);
    AppMethodBeat.o(7050);
    return true;
  }
  
  public static boolean ahJ(String paramString)
  {
    AppMethodBeat.i(7049);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.TmplWebViewJsAPi", "[needProcess]function is null, err");
      AppMethodBeat.o(7049);
      return false;
    }
    boolean bool = uYU.contains(paramString);
    AppMethodBeat.o(7049);
    return bool;
  }
  
  private static boolean b(final i parami, final com.tencent.mm.plugin.webview.stub.e parame, final e.a parama)
  {
    AppMethodBeat.i(7053);
    a.kS(80);
    if (parame == null)
    {
      ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] callbacker is null, err");
      a.kS(82);
      parama.a(parami, "updatePageAuth:fail", null);
      AppMethodBeat.o(7053);
      return false;
    }
    try
    {
      Object localObject = parame.i(90003, null);
      if (localObject != null)
      {
        String str = ((Bundle)localObject).getString("geta8key_data_req_url");
        if (uYV.contains(str))
        {
          ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] updatePageAuth fail, url:%s already run");
          parama.a(parami, "updatePageAuth:fail updating", null);
          a.kS(82);
          AppMethodBeat.o(7053);
          return false;
        }
        uYV.add(str);
        localObject = new j(str, ((Bundle)localObject).getString("geta8key_data_username"), ((Bundle)localObject).getInt("geta8key_data_scene"), ((Bundle)localObject).getInt("geta8key_data_reason"), ((Bundle)localObject).getInt("geta8key_data_flag"), ((Bundle)localObject).getString("geta8key_data_net_type"), ((Bundle)localObject).getInt("geta8key_session_id", 0), ((Bundle)localObject).getString("geta8key_data_appid"), ((Bundle)localObject).getString("key_function_id"), ((Bundle)localObject).getInt("key_wallet_region", 0), ((Bundle)localObject).getByteArray("k_a8key_cookie"));
        parame = new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            AppMethodBeat.i(7048);
            g.Rc().b(233, this);
            e.coC().remove(this.uRW);
            ab.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]errType:%d, errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramAnonymousString = this.uZb.ajl();
            if (bo.isNullOrNil(paramAnonymousString))
            {
              ab.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] fail fullurl is null");
              a.kS(82);
              parama.a(parami, parami.vrQ + ":fail", null);
              AppMethodBeat.o(7048);
              return;
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {}
            for (;;)
            {
              try
              {
                paramAnonymousm = new Bundle();
                paramAnonymousm.putString("geta8key_result_req_url", this.uZb.ajm());
                paramAnonymousm.putString("geta8key_result_full_url", paramAnonymousString);
                List localList = this.uZb.ajs();
                if (!bo.es(localList))
                {
                  Object localObject1 = localList.iterator();
                  if (!((Iterator)localObject1).hasNext()) {
                    break label558;
                  }
                  Object localObject2 = (avl)((Iterator)localObject1).next();
                  if ((localObject2 != null) && (!bo.isNullOrNil(((avl)localObject2).wxP)) && (!bo.isNullOrNil(((avl)localObject2).qsu))) {
                    continue;
                  }
                  ab.e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
                  paramAnonymousInt1 = 1;
                  if (paramAnonymousInt1 == 0)
                  {
                    localObject1 = new String[localList.size()];
                    localObject2 = new String[localList.size()];
                    paramAnonymousInt1 = 0;
                    if (paramAnonymousInt1 < localList.size())
                    {
                      Object localObject3 = (avl)localList.get(paramAnonymousInt1);
                      String str = ((avl)localObject3).wxP;
                      localObject3 = ((avl)localObject3).qsu;
                      ab.i("MicroMsg.TmplWebViewJsAPi", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), str, localObject3 });
                      localObject1[paramAnonymousInt1] = str;
                      localObject2[paramAnonymousInt1] = localObject3;
                      paramAnonymousInt1 += 1;
                      continue;
                    }
                    paramAnonymousm.putStringArray("geta8key_result_http_header_key_list", (String[])localObject1);
                    paramAnonymousm.putStringArray("geta8key_result_http_header_value_list", (String[])localObject2);
                  }
                }
                parame.i(90004, paramAnonymousm);
              }
              catch (RemoteException paramAnonymousm)
              {
                ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", paramAnonymousm, "", new Object[0]);
                continue;
              }
              paramAnonymousm = new HashMap();
              paramAnonymousm.put("fullUrl", paramAnonymousString);
              ab.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]values:%s", new Object[] { paramAnonymousm });
              a.kS(81);
              parama.a(parami, parami.vrQ + ":ok", paramAnonymousm);
              AppMethodBeat.o(7048);
              return;
              a.kS(82);
              parama.a(parami, parami.vrQ + ":fail", null);
              AppMethodBeat.o(7048);
              return;
              label558:
              paramAnonymousInt1 = 0;
            }
          }
        };
        g.Rc().a(233, parame);
        g.Rc().a((m)localObject, 0);
        AppMethodBeat.o(7053);
        return true;
      }
    }
    catch (RemoteException parame)
    {
      ab.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", parame, "", new Object[0]);
      a.kS(82);
      parama.a(parami, "updatePageAuth:fail", null);
      AppMethodBeat.o(7053);
    }
    return false;
  }
  
  private static void d(Map paramMap)
  {
    AppMethodBeat.i(7052);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        d((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(7052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.e
 * JD-Core Version:    0.7.0.1
 */