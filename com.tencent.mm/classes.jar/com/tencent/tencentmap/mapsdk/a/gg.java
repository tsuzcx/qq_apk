package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gg
  extends gf
  implements ex
{
  private gv a = new gv("HttpSchedulerClient");
  private ev b;
  
  /* Error */
  private static void a(ev paramev, org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_1
    //   4: invokevirtual 36	org/json/JSONArray:length	()I
    //   7: if_icmpge +172 -> 179
    //   10: aload_1
    //   11: iload_2
    //   12: invokevirtual 40	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   15: astore 8
    //   17: aload 8
    //   19: ldc 42
    //   21: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   24: astore 5
    //   26: aload 8
    //   28: ldc 50
    //   30: invokevirtual 48	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   33: astore 6
    //   35: aload 8
    //   37: ldc 52
    //   39: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 7
    //   44: aload 8
    //   46: ldc 58
    //   48: invokevirtual 56	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 8
    //   53: aload 5
    //   55: ifnull +116 -> 171
    //   58: aload 6
    //   60: ifnull +111 -> 171
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: aload 5
    //   68: invokevirtual 36	org/json/JSONArray:length	()I
    //   71: if_icmpge +100 -> 171
    //   74: new 60	com/tencent/tencentmap/mapsdk/a/ew
    //   77: dup
    //   78: aload 5
    //   80: iload_3
    //   81: invokevirtual 64	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   84: aload 7
    //   86: invokespecial 67	com/tencent/tencentmap/mapsdk/a/ew:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore 9
    //   91: aload 9
    //   93: aload 8
    //   95: invokestatic 73	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   98: putfield 77	com/tencent/tencentmap/mapsdk/a/ew:d	I
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: aload 6
    //   108: invokevirtual 36	org/json/JSONArray:length	()I
    //   111: if_icmpge +47 -> 158
    //   114: aload 6
    //   116: iload 4
    //   118: invokevirtual 64	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   121: astore 10
    //   123: new 79	com/tencent/tencentmap/mapsdk/a/en
    //   126: dup
    //   127: invokespecial 80	com/tencent/tencentmap/mapsdk/a/en:<init>	()V
    //   130: astore 11
    //   132: aload 11
    //   134: aload 10
    //   136: invokevirtual 83	com/tencent/tencentmap/mapsdk/a/en:a	(Ljava/lang/String;)Z
    //   139: ifeq +46 -> 185
    //   142: aload 9
    //   144: getfield 87	com/tencent/tencentmap/mapsdk/a/ew:c	Ljava/util/List;
    //   147: aload 11
    //   149: invokeinterface 93 2 0
    //   154: pop
    //   155: goto +30 -> 185
    //   158: aload_0
    //   159: aload 9
    //   161: invokevirtual 98	com/tencent/tencentmap/mapsdk/a/ev:a	(Lcom/tencent/tencentmap/mapsdk/a/ew;)V
    //   164: iload_3
    //   165: iconst_1
    //   166: iadd
    //   167: istore_3
    //   168: goto -103 -> 65
    //   171: iload_2
    //   172: iconst_1
    //   173: iadd
    //   174: istore_2
    //   175: goto -173 -> 2
    //   178: astore_0
    //   179: return
    //   180: astore 9
    //   182: goto -18 -> 164
    //   185: iload 4
    //   187: iconst_1
    //   188: iadd
    //   189: istore 4
    //   191: goto -87 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramev	ev
    //   0	194	1	paramJSONArray	org.json.JSONArray
    //   1	174	2	i	int
    //   64	104	3	j	int
    //   102	88	4	k	int
    //   24	55	5	localJSONArray1	org.json.JSONArray
    //   33	82	6	localJSONArray2	org.json.JSONArray
    //   42	43	7	str1	String
    //   15	79	8	localObject	java.lang.Object
    //   89	71	9	localew	ew
    //   180	1	9	localThrowable	java.lang.Throwable
    //   121	14	10	str2	String
    //   130	18	11	localen	en
    // Exception table:
    //   from	to	target	type
    //   2	53	178	java/lang/Exception
    //   65	91	178	java/lang/Exception
    //   91	101	178	java/lang/Exception
    //   104	155	178	java/lang/Exception
    //   158	164	178	java/lang/Exception
    //   91	101	180	java/lang/Throwable
  }
  
  public final List<ew> a()
  {
    if ((this.b != null) && (this.b.a().equals(ey.b())))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.b().entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
      return localArrayList;
    }
    em.j().post(new gh(this));
    return null;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.a.a(paramString1, paramArrayOfByte);
    em.j().post(new gh(this));
  }
  
  public final String b()
  {
    return "accessscheduler";
  }
  
  public final void c()
  {
    hj.d().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gg
 * JD-Core Version:    0.7.0.1
 */