package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i$a
{
  private static String a(String paramString1, String paramString2, Map<String, Object> paramMap, JSONObject paramJSONObject, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(9813);
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
            localJSONObject.put("__params", ao(paramMap));
            if (!paramBoolean) {
              break;
            }
            paramString1 = m(localJSONObject, paramString3);
            AppMethodBeat.o(9813);
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
        ab.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(9813);
        return null;
      }
    }
    paramString1 = localJSONObject.toString();
    AppMethodBeat.o(9813);
    return paramString1;
  }
  
  public static String a(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(9810);
    paramString1 = a("callback", paramString1, paramMap, null, paramBoolean, paramString2);
    AppMethodBeat.o(9810);
    return paramString1;
  }
  
  public static String a(String paramString1, JSONObject paramJSONObject, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(9811);
    paramString1 = a("event", paramString1, null, paramJSONObject, paramBoolean, paramString2);
    AppMethodBeat.o(9811);
    return paramString1;
  }
  
  /* Error */
  private static i ajl(String paramString)
  {
    // Byte code:
    //   0: sipush 9816
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 96	java/lang/String:length	()I
    //   14: ifne +18 -> 32
    //   17: ldc 57
    //   19: ldc 98
    //   21: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 9816
    //   27: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: new 6	com/tencent/mm/plugin/webview/ui/tools/jsapi/i
    //   35: dup
    //   36: invokespecial 99	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:<init>	()V
    //   39: astore_3
    //   40: new 18	org/json/JSONObject
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 100	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_3
    //   50: aload_0
    //   51: ldc 24
    //   53: invokevirtual 104	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 108	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:type	Ljava/lang/String;
    //   59: aload_3
    //   60: aload_0
    //   61: ldc 38
    //   63: invokevirtual 104	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: putfield 111	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrN	Ljava/lang/String;
    //   69: aload_3
    //   70: aload_0
    //   71: ldc 113
    //   73: invokevirtual 104	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 116	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrQ	Ljava/lang/String;
    //   79: aload_3
    //   80: new 118	java/util/HashMap
    //   83: dup
    //   84: invokespecial 119	java/util/HashMap:<init>	()V
    //   87: putfield 123	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   90: aload_0
    //   91: ldc 125
    //   93: invokevirtual 129	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   96: astore 4
    //   98: aload_3
    //   99: getfield 116	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrQ	Ljava/lang/String;
    //   102: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +139 -> 244
    //   108: getstatic 141	com/tencent/mm/protocal/c:whw	[Ljava/lang/String;
    //   111: aload_3
    //   112: getfield 116	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrQ	Ljava/lang/String;
    //   115: invokestatic 147	org/apache/commons/b/a:contains	([Ljava/lang/Object;Ljava/lang/Object;)Z
    //   118: ifeq +126 -> 244
    //   121: aload_3
    //   122: aload 4
    //   124: putfield 151	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrO	Lorg/json/JSONObject;
    //   127: aload 4
    //   129: ifnull +210 -> 339
    //   132: aload 4
    //   134: invokevirtual 155	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   137: astore 5
    //   139: aload 5
    //   141: invokeinterface 161 1 0
    //   146: ifeq +193 -> 339
    //   149: aload 5
    //   151: invokeinterface 165 1 0
    //   156: checkcast 32	java/lang/String
    //   159: astore 6
    //   161: aload 4
    //   163: aload 6
    //   165: invokevirtual 104	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_2
    //   169: aload_2
    //   170: astore_0
    //   171: aload_2
    //   172: ifnonnull +6 -> 178
    //   175: ldc 167
    //   177: astore_0
    //   178: ldc 169
    //   180: aload 6
    //   182: invokevirtual 173	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   185: ifeq +138 -> 323
    //   188: ldc 57
    //   190: ldc 175
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 6
    //   200: aastore
    //   201: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: new 181	org/json/JSONArray
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 182	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 183	org/json/JSONArray:length	()I
    //   217: anewarray 32	java/lang/String
    //   220: astore_2
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_2
    //   225: arraylength
    //   226: if_icmpge +59 -> 285
    //   229: aload_2
    //   230: iload_1
    //   231: aload_0
    //   232: iload_1
    //   233: invokevirtual 186	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   236: aastore
    //   237: iload_1
    //   238: iconst_1
    //   239: iadd
    //   240: istore_1
    //   241: goto -18 -> 223
    //   244: aload_3
    //   245: aconst_null
    //   246: putfield 151	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:vrO	Lorg/json/JSONObject;
    //   249: goto -122 -> 127
    //   252: astore_0
    //   253: ldc 57
    //   255: new 59	java/lang/StringBuilder
    //   258: dup
    //   259: ldc 188
    //   261: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: aload_0
    //   265: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   268: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 81	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: sipush 9816
    //   280: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: aconst_null
    //   284: areturn
    //   285: aload_3
    //   286: getfield 123	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   289: aload 6
    //   291: aload_2
    //   292: invokeinterface 193 3 0
    //   297: pop
    //   298: goto -159 -> 139
    //   301: astore_0
    //   302: ldc 57
    //   304: ldc 195
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload_0
    //   313: invokevirtual 68	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -181 -> 139
    //   323: aload_3
    //   324: getfield 123	com/tencent/mm/plugin/webview/ui/tools/jsapi/i:pJb	Ljava/util/Map;
    //   327: aload 6
    //   329: aload_0
    //   330: invokeinterface 193 3 0
    //   335: pop
    //   336: goto -197 -> 139
    //   339: sipush 9816
    //   342: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_3
    //   346: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramString	String
    //   222	19	1	i	int
    //   168	124	2	localObject	Object
    //   39	307	3	locali	i
    //   96	66	4	localJSONObject	JSONObject
    //   137	13	5	localIterator	Iterator
    //   159	169	6	str	String
    // Exception table:
    //   from	to	target	type
    //   40	127	252	java/lang/Exception
    //   132	139	252	java/lang/Exception
    //   139	169	252	java/lang/Exception
    //   178	204	252	java/lang/Exception
    //   244	249	252	java/lang/Exception
    //   302	320	252	java/lang/Exception
    //   323	336	252	java/lang/Exception
    //   204	221	301	java/lang/Exception
    //   223	237	301	java/lang/Exception
    //   285	298	301	java/lang/Exception
  }
  
  public static JSONObject ao(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(9815);
    if ((paramMap == null) || (paramMap.size() == 0))
    {
      paramMap = new JSONObject();
      AppMethodBeat.o(9815);
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
        ab.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + paramMap.getMessage());
        AppMethodBeat.o(9815);
        return null;
      }
    }
    AppMethodBeat.o(9815);
    return localJSONObject;
  }
  
  public static String b(String paramString1, Map<String, Object> paramMap, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(9812);
    paramString1 = a("event", paramString1, paramMap, null, paramBoolean, paramString2);
    AppMethodBeat.o(9812);
    return paramString1;
  }
  
  static List<i> i(String paramString1, boolean paramBoolean, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(9817);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
      AppMethodBeat.o(9817);
      return null;
    }
    if (paramBoolean) {}
    try
    {
      Object localObject = new JSONObject(paramString1);
      paramString1 = ((JSONObject)localObject).getJSONArray("__json_message");
      localObject = ((JSONObject)localObject).getString("__sha_key");
      paramString2 = n.getSHA1(paramString1.toString().replaceAll("\\\\/", "/") + paramString2);
      if (!((String)localObject).equals(paramString2))
      {
        ab.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", new Object[] { localObject, paramString2, paramString1.toString().replaceAll("\\\\/", "/") });
        h.qsU.idkeyStat(894L, 6L, 1L, false);
        AppMethodBeat.o(9817);
        return null;
      }
      for (;;)
      {
        int j = paramString1.length();
        if (j != 0) {
          break;
        }
        AppMethodBeat.o(9817);
        return null;
        paramString1 = new JSONArray(paramString1);
      }
      paramString2 = new LinkedList();
      while (i < paramString1.length())
      {
        paramString2.add(ajl(paramString1.getString(i)));
        i += 1;
      }
      AppMethodBeat.o(9817);
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + paramString1.getMessage());
      AppMethodBeat.o(9817);
      return null;
    }
    return paramString2;
  }
  
  private static String m(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(9814);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("__json_message", paramJSONObject);
      paramJSONObject = paramJSONObject.toString().replaceAll("\\\\/", "/");
      ab.i("MicroMsg.MsgWrapper", "js digest verification contentStr = ", new Object[] { paramJSONObject });
      paramJSONObject = n.getSHA1(paramJSONObject + paramString);
      ab.i("MicroMsg.MsgWrapper", "js digest verification shaStr = ", new Object[] { paramJSONObject });
      localJSONObject.put("__sha_key", paramJSONObject);
      paramJSONObject = localJSONObject.toString();
      AppMethodBeat.o(9814);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.MsgWrapper", "build fail, exception = " + paramJSONObject.getMessage());
      AppMethodBeat.o(9814);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */