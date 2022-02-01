package com.tencent.mm.plugin.webview.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  public Bundle EeL;
  public Map<String, Object> EfA;
  public String Efy;
  public JSONObject Efz;
  public String lcx;
  public String type;
  public Map<String, Object> xqN;
  
  public l()
  {
    AppMethodBeat.i(213751);
    this.EfA = new HashMap();
    AppMethodBeat.o(213751);
  }
  
  public static Map<String, Object> aB(Bundle paramBundle)
  {
    AppMethodBeat.i(213753);
    if (paramBundle == null)
    {
      AppMethodBeat.o(213753);
      return null;
    }
    Object localObject = paramBundle.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(213753);
      return null;
    }
    HashMap localHashMap = new HashMap();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramBundle.get(str));
    }
    AppMethodBeat.o(213753);
    return localHashMap;
  }
  
  public static Bundle bH(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(213752);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      AppMethodBeat.o(213752);
      return null;
    }
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap.get(str);
      if ((localObject instanceof String[])) {
        localBundle.putStringArray(str, (String[])localObject);
      } else if ((localObject instanceof Bundle)) {
        localBundle.putBundle(str, (Bundle)localObject);
      } else {
        localBundle.putString(str, String.valueOf(localObject));
      }
    }
    AppMethodBeat.o(213752);
    return localBundle;
  }
  
  public final Map<String, Object> eSE()
  {
    return this.EfA;
  }
  
  public static final class a
  {
    private static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
    {
      AppMethodBeat.i(213746);
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("__msg_type", paramString1);
          if (paramString1.equals("callback"))
          {
            localJSONObject.put("__callback_id", paramString2);
            if (paramJSONObject == null)
            {
              localJSONObject.put("__params", bf(paramMap));
              if (!paramBoolean) {
                break;
              }
              paramString1 = k(localJSONObject, paramString3);
              AppMethodBeat.o(213746);
              return paramString1;
            }
          }
          else
          {
            if (!paramString1.equals("event")) {
              continue;
            }
            localJSONObject.put("__event_id", paramString2);
            continue;
          }
          localJSONObject.put("__params", paramJSONObject);
        }
        catch (Exception paramString1)
        {
          ae.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramString1.getMessage());
          AppMethodBeat.o(213746);
          return null;
        }
      }
      paramString1 = localJSONObject.toString();
      AppMethodBeat.o(213746);
      return paramString1;
    }
    
    public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(213743);
      paramString1 = a("callback", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(213743);
      return paramString1;
    }
    
    public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(213744);
      paramString1 = a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
      AppMethodBeat.o(213744);
      return paramString1;
    }
    
    /* Error */
    private static l aIl(String paramString)
    {
      // Byte code:
      //   0: ldc 96
      //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ifnull +10 -> 16
      //   9: aload_0
      //   10: invokevirtual 100	java/lang/String:length	()I
      //   13: ifne +17 -> 30
      //   16: ldc 58
      //   18: ldc 102
      //   20: invokestatic 82	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   23: ldc 96
      //   25: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   28: aconst_null
      //   29: areturn
      //   30: new 6	com/tencent/mm/plugin/webview/c/l
      //   33: dup
      //   34: invokespecial 103	com/tencent/mm/plugin/webview/c/l:<init>	()V
      //   37: astore_3
      //   38: new 19	org/json/JSONObject
      //   41: dup
      //   42: aload_0
      //   43: invokespecial 104	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   46: astore_0
      //   47: aload_3
      //   48: aload_0
      //   49: ldc 25
      //   51: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   54: putfield 112	com/tencent/mm/plugin/webview/c/l:type	Ljava/lang/String;
      //   57: aload_3
      //   58: aload_0
      //   59: ldc 39
      //   61: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   64: putfield 115	com/tencent/mm/plugin/webview/c/l:Efy	Ljava/lang/String;
      //   67: aload_3
      //   68: aload_0
      //   69: ldc 117
      //   71: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   74: putfield 120	com/tencent/mm/plugin/webview/c/l:lcx	Ljava/lang/String;
      //   77: aload_3
      //   78: new 122	java/util/HashMap
      //   81: dup
      //   82: invokespecial 123	java/util/HashMap:<init>	()V
      //   85: putfield 127	com/tencent/mm/plugin/webview/c/l:xqN	Ljava/util/Map;
      //   88: aload_0
      //   89: ldc 129
      //   91: invokevirtual 133	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   94: astore 4
      //   96: aload_3
      //   97: getfield 120	com/tencent/mm/plugin/webview/c/l:lcx	Ljava/lang/String;
      //   100: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   103: ifne +139 -> 242
      //   106: getstatic 145	com/tencent/mm/protocal/c:FFw	[Ljava/lang/String;
      //   109: aload_3
      //   110: getfield 120	com/tencent/mm/plugin/webview/c/l:lcx	Ljava/lang/String;
      //   113: invokestatic 151	org/apache/commons/b/a:contains	([Ljava/lang/Object;Ljava/lang/Object;)Z
      //   116: ifeq +126 -> 242
      //   119: aload_3
      //   120: aload 4
      //   122: putfield 155	com/tencent/mm/plugin/webview/c/l:Efz	Lorg/json/JSONObject;
      //   125: aload 4
      //   127: ifnull +209 -> 336
      //   130: aload 4
      //   132: invokevirtual 159	org/json/JSONObject:keys	()Ljava/util/Iterator;
      //   135: astore 5
      //   137: aload 5
      //   139: invokeinterface 165 1 0
      //   144: ifeq +192 -> 336
      //   147: aload 5
      //   149: invokeinterface 169 1 0
      //   154: checkcast 33	java/lang/String
      //   157: astore 6
      //   159: aload 4
      //   161: aload 6
      //   163: invokevirtual 108	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   166: astore_2
      //   167: aload_2
      //   168: astore_0
      //   169: aload_2
      //   170: ifnonnull +6 -> 176
      //   173: ldc 171
      //   175: astore_0
      //   176: ldc 173
      //   178: aload 6
      //   180: invokevirtual 177	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   183: ifeq +137 -> 320
      //   186: ldc 58
      //   188: ldc 179
      //   190: iconst_1
      //   191: anewarray 4	java/lang/Object
      //   194: dup
      //   195: iconst_0
      //   196: aload 6
      //   198: aastore
      //   199: invokestatic 183	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   202: new 185	org/json/JSONArray
      //   205: dup
      //   206: aload_0
      //   207: invokespecial 186	org/json/JSONArray:<init>	(Ljava/lang/String;)V
      //   210: astore_0
      //   211: aload_0
      //   212: invokevirtual 187	org/json/JSONArray:length	()I
      //   215: anewarray 33	java/lang/String
      //   218: astore_2
      //   219: iconst_0
      //   220: istore_1
      //   221: iload_1
      //   222: aload_2
      //   223: arraylength
      //   224: if_icmpge +58 -> 282
      //   227: aload_2
      //   228: iload_1
      //   229: aload_0
      //   230: iload_1
      //   231: invokevirtual 190	org/json/JSONArray:getString	(I)Ljava/lang/String;
      //   234: aastore
      //   235: iload_1
      //   236: iconst_1
      //   237: iadd
      //   238: istore_1
      //   239: goto -18 -> 221
      //   242: aload_3
      //   243: aconst_null
      //   244: putfield 155	com/tencent/mm/plugin/webview/c/l:Efz	Lorg/json/JSONObject;
      //   247: goto -122 -> 125
      //   250: astore_0
      //   251: ldc 58
      //   253: new 60	java/lang/StringBuilder
      //   256: dup
      //   257: ldc 192
      //   259: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   262: aload_0
      //   263: invokevirtual 69	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   266: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   272: invokestatic 82	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   275: ldc 96
      //   277: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   280: aconst_null
      //   281: areturn
      //   282: aload_3
      //   283: getfield 127	com/tencent/mm/plugin/webview/c/l:xqN	Ljava/util/Map;
      //   286: aload 6
      //   288: aload_2
      //   289: invokeinterface 197 3 0
      //   294: pop
      //   295: goto -158 -> 137
      //   298: astore_0
      //   299: ldc 58
      //   301: ldc 199
      //   303: iconst_1
      //   304: anewarray 4	java/lang/Object
      //   307: dup
      //   308: iconst_0
      //   309: aload_0
      //   310: invokevirtual 69	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   313: aastore
      //   314: invokestatic 201	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   317: goto -180 -> 137
      //   320: aload_3
      //   321: getfield 127	com/tencent/mm/plugin/webview/c/l:xqN	Ljava/util/Map;
      //   324: aload 6
      //   326: aload_0
      //   327: invokeinterface 197 3 0
      //   332: pop
      //   333: goto -196 -> 137
      //   336: ldc 96
      //   338: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   341: aload_3
      //   342: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	343	0	paramString	String
      //   220	19	1	i	int
      //   166	123	2	localObject	Object
      //   37	305	3	locall	l
      //   94	66	4	localJSONObject	JSONObject
      //   135	13	5	localIterator	Iterator
      //   157	168	6	str	String
      // Exception table:
      //   from	to	target	type
      //   38	125	250	java/lang/Exception
      //   130	137	250	java/lang/Exception
      //   137	167	250	java/lang/Exception
      //   176	202	250	java/lang/Exception
      //   242	247	250	java/lang/Exception
      //   299	317	250	java/lang/Exception
      //   320	333	250	java/lang/Exception
      //   202	219	298	java/lang/Exception
      //   221	235	298	java/lang/Exception
      //   282	295	298	java/lang/Exception
    }
    
    public static String b(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
    {
      AppMethodBeat.i(213745);
      paramString1 = a("event", paramString1, paramMap, null, paramBoolean, paramString2);
      AppMethodBeat.o(213745);
      return paramString1;
    }
    
    public static JSONObject bf(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(213748);
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = new JSONObject();
        AppMethodBeat.o(213748);
        return paramMap;
      }
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          String str1 = (String)paramMap.get("jsapi_callback_json_special_key");
          localJSONObject = new JSONObject();
          Iterator localIterator = paramMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          String str2 = (String)localIterator.next();
          if ((str2 != null) && (!str2.equals("jsapi_callback_json_special_key"))) {
            if ((str1 != null) && (str2.equals(str1))) {
              localJSONObject.put(str1, new JSONArray((String)paramMap.get(str1)));
            } else {
              localJSONObject.put(str2, paramMap.get(str2));
            }
          }
        }
        catch (Exception paramMap)
        {
          ae.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + paramMap.getMessage());
          AppMethodBeat.o(213748);
          return null;
        }
      }
      AppMethodBeat.o(213748);
      return localJSONObject;
    }
    
    private static String k(JSONObject paramJSONObject, String paramString)
    {
      AppMethodBeat.i(213747);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__json_message", paramJSONObject);
        paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
        ae.i("MicroMsg.MsgWrapper", "js digest verification contentStr = %s", new Object[] { paramJSONObject });
        paramJSONObject = n.ev(paramJSONObject + paramString);
        ae.i("MicroMsg.MsgWrapper", "js digest verification shaStr = %s", new Object[] { paramJSONObject });
        localJSONObject.put("__sha_key", paramJSONObject);
        paramJSONObject = localJSONObject.toString();
        AppMethodBeat.o(213747);
        return paramJSONObject;
      }
      catch (Exception paramJSONObject)
      {
        ae.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
        AppMethodBeat.o(213747);
      }
      return null;
    }
    
    static List<l> k(String paramString1, boolean paramBoolean, String paramString2)
    {
      int i = 0;
      AppMethodBeat.i(213750);
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        ae.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
        AppMethodBeat.o(213750);
        return null;
      }
      if (paramBoolean) {}
      try
      {
        Object localObject = new JSONObject(paramString1);
        paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
        localObject = ((JSONObject)localObject).getString("__sha_key");
        paramString2 = n.ev(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
        if (!((String)localObject).equals(paramString2))
        {
          ae.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
          g.yxI.idkeyStat(894L, 6L, 1L, false);
          AppMethodBeat.o(213750);
          return null;
        }
        for (;;)
        {
          int j = paramString1.length();
          if (j != 0) {
            break;
          }
          AppMethodBeat.o(213750);
          return null;
          paramString1 = new JSONArray(paramString1);
        }
        paramString2 = new LinkedList();
        while (i < paramString1.length())
        {
          paramString2.add(aIl(paramString1.getString(i)));
          i += 1;
        }
        AppMethodBeat.o(213750);
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(213750);
        return null;
      }
      return paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.l
 * JD-Core Version:    0.7.0.1
 */