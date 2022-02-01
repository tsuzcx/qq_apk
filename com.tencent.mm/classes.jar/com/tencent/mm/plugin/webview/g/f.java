package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class f
{
  private static List<String> DXC;
  private static List<String> DXD;
  
  static
  {
    AppMethodBeat.i(79245);
    ArrayList localArrayList = new ArrayList();
    DXC = localArrayList;
    localArrayList.add("updatePageAuth");
    DXD = new ArrayList();
    AppMethodBeat.o(79245);
  }
  
  /* Error */
  public static boolean a(final l paraml, final a parama)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: invokestatic 52	com/tencent/mm/plugin/webview/g/a:ma	(I)V
    //   10: aload_0
    //   11: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   14: ldc 60
    //   16: invokeinterface 66 2 0
    //   21: checkcast 68	java/lang/String
    //   24: ldc 70
    //   26: invokestatic 76	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_3
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: invokestatic 80	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   36: ifne +17 -> 53
    //   39: ldc 82
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_3
    //   48: aastore
    //   49: invokestatic 86	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore_2
    //   53: new 88	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   64: ldc 91
    //   66: invokeinterface 66 2 0
    //   71: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   86: ldc 104
    //   88: invokeinterface 66 2 0
    //   93: checkcast 68	java/lang/String
    //   96: ldc 106
    //   98: invokestatic 76	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_3
    //   102: aload_0
    //   103: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   106: ldc 108
    //   108: invokeinterface 66 2 0
    //   113: checkcast 68	java/lang/String
    //   116: ldc 70
    //   118: invokestatic 76	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 4
    //   123: aload_0
    //   124: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   127: ldc 110
    //   129: invokeinterface 66 2 0
    //   134: checkcast 68	java/lang/String
    //   137: astore 5
    //   139: ldc 112
    //   141: ldc 114
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_2
    //   150: aastore
    //   151: invokestatic 119	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 58	com/tencent/mm/plugin/webview/c/l:xaW	Ljava/util/Map;
    //   158: ldc 121
    //   160: invokeinterface 66 2 0
    //   165: checkcast 68	java/lang/String
    //   168: ldc 70
    //   170: invokestatic 76	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   173: astore 7
    //   175: new 123	java/util/HashMap
    //   178: dup
    //   179: invokespecial 124	java/util/HashMap:<init>	()V
    //   182: astore 6
    //   184: aload 7
    //   186: invokestatic 80	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   189: ifne +135 -> 324
    //   192: new 126	org/json/JSONObject
    //   195: dup
    //   196: aload 7
    //   198: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 133	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   208: astore 8
    //   210: aload 8
    //   212: invokeinterface 139 1 0
    //   217: ifeq +107 -> 324
    //   220: aload 8
    //   222: invokeinterface 143 1 0
    //   227: checkcast 68	java/lang/String
    //   230: astore 9
    //   232: aload 6
    //   234: aload 9
    //   236: aload 7
    //   238: aload 9
    //   240: invokevirtual 147	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   243: invokeinterface 151 3 0
    //   248: pop
    //   249: goto -39 -> 210
    //   252: astore 7
    //   254: ldc 112
    //   256: ldc 70
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload 7
    //   266: aastore
    //   267: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: ldc 112
    //   272: ldc 156
    //   274: iconst_4
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_2
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload_3
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: aload 4
    //   290: aastore
    //   291: dup
    //   292: iconst_3
    //   293: aload 5
    //   295: aastore
    //   296: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: new 6	com/tencent/mm/plugin/webview/g/f$1
    //   302: dup
    //   303: aload_3
    //   304: aload_2
    //   305: aload 6
    //   307: aload 5
    //   309: aload_1
    //   310: aload_0
    //   311: invokespecial 162	com/tencent/mm/plugin/webview/g/f$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/g/f$a;Lcom/tencent/mm/plugin/webview/c/l;)V
    //   314: invokestatic 168	com/tencent/mm/plugin/webview/a/a:af	(Ljava/lang/Runnable;)V
    //   317: ldc 47
    //   319: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_1
    //   323: ireturn
    //   324: aload 4
    //   326: invokestatic 80	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   329: ifne -59 -> 270
    //   332: new 126	org/json/JSONObject
    //   335: dup
    //   336: aload 4
    //   338: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   341: astore 7
    //   343: aload 7
    //   345: invokevirtual 133	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   348: astore 8
    //   350: aload 8
    //   352: invokeinterface 139 1 0
    //   357: ifeq -87 -> 270
    //   360: aload 8
    //   362: invokeinterface 143 1 0
    //   367: checkcast 68	java/lang/String
    //   370: astore 9
    //   372: aload 6
    //   374: aload 9
    //   376: aload 7
    //   378: aload 9
    //   380: invokevirtual 147	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   383: invokeinterface 151 3 0
    //   388: pop
    //   389: goto -39 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paraml	l
    //   0	392	1	parama	a
    //   31	274	2	str1	String
    //   29	275	3	str2	String
    //   121	216	4	str3	String
    //   137	171	5	str4	String
    //   182	191	6	localHashMap	HashMap
    //   173	64	7	localObject	Object
    //   252	13	7	localJSONException	org.json.JSONException
    //   341	36	7	localJSONObject	JSONObject
    //   208	153	8	localIterator	Iterator
    //   230	149	9	str5	String
    // Exception table:
    //   from	to	target	type
    //   184	210	252	org/json/JSONException
    //   210	249	252	org/json/JSONException
    //   324	350	252	org/json/JSONException
    //   350	389	252	org/json/JSONException
  }
  
  private static void d(Map paramMap)
  {
    AppMethodBeat.i(79242);
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
    AppMethodBeat.o(79242);
  }
  
  public static abstract interface a
  {
    public abstract void a(l paraml, String paramString, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.f
 * JD-Core Version:    0.7.0.1
 */