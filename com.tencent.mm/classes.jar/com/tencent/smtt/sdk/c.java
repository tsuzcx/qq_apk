package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class c
{
  private static c e;
  private static boolean g = false;
  private String a;
  private String b;
  private String c;
  private String d;
  private final Map<Integer, a> f;
  
  private c()
  {
    AppMethodBeat.i(219556);
    this.a = "EmergenceMsgPublisher";
    this.b = "tbs_emergence";
    this.c = "emergence_executed_ids";
    this.d = "emergence_ids";
    this.f = new LinkedHashMap();
    AppMethodBeat.o(219556);
  }
  
  public static c a()
  {
    AppMethodBeat.i(219562);
    if (e == null) {
      e = new c();
    }
    c localc = e;
    AppMethodBeat.o(219562);
    return localc;
  }
  
  private void a(Context paramContext, c.b paramb, a parama)
  {
    AppMethodBeat.i(219577);
    if (parama != null)
    {
      a("Executed command: " + paramb.b + ", extra: " + paramb.c);
      parama.a(paramb.c);
      paramContext = paramContext.getSharedPreferences(this.b, 4);
      Object localObject1 = paramContext.getString(this.c, "");
      parama = new HashSet();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        if ((localObject1 != null) && (localObject1.length > 0)) {
          try
          {
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              parama.add(Integer.valueOf(Integer.parseInt(localObject1[i])));
              i += 1;
            }
            parama.add(Integer.valueOf(paramb.a));
          }
          finally {}
        }
      }
      paramb = new StringBuilder();
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paramb.append((Integer)parama.next());
        paramb.append(",");
      }
      paramContext = paramContext.edit();
      paramContext.putString(this.c, paramb.toString());
      paramContext.commit();
    }
    AppMethodBeat.o(219577);
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(219569);
    TbsLog.d(this.a, paramString);
    AppMethodBeat.o(219569);
  }
  
  /* Error */
  public Map<Integer, c.b> a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 181
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 183	java/util/HashMap
    //   11: dup
    //   12: invokespecial 184	java/util/HashMap:<init>	()V
    //   15: astore 7
    //   17: aload_1
    //   18: aload_0
    //   19: getfield 43	com/tencent/smtt/sdk/c:b	Ljava/lang/String;
    //   22: iconst_0
    //   23: invokevirtual 99	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: astore 8
    //   28: aload_1
    //   29: ifnonnull +17 -> 46
    //   32: aload_0
    //   33: ldc 186
    //   35: invokespecial 92	com/tencent/smtt/sdk/c:a	(Ljava/lang/String;)V
    //   38: ldc 181
    //   40: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload 7
    //   45: areturn
    //   46: aload 8
    //   48: aload_0
    //   49: getfield 51	com/tencent/smtt/sdk/c:d	Ljava/lang/String;
    //   52: ldc 101
    //   54: invokeinterface 107 3 0
    //   59: astore_1
    //   60: aload_1
    //   61: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifeq +17 -> 81
    //   67: aload_0
    //   68: ldc 188
    //   70: invokespecial 92	com/tencent/smtt/sdk/c:a	(Ljava/lang/String;)V
    //   73: ldc 181
    //   75: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload 7
    //   80: areturn
    //   81: aload_0
    //   82: ldc 190
    //   84: aload_1
    //   85: invokestatic 193	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokespecial 92	com/tencent/smtt/sdk/c:a	(Ljava/lang/String;)V
    //   94: aload_1
    //   95: ldc 199
    //   97: invokevirtual 124	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +141 -> 243
    //   105: aload_1
    //   106: arraylength
    //   107: istore_3
    //   108: iconst_0
    //   109: istore_2
    //   110: iload_2
    //   111: iload_3
    //   112: if_icmpge +131 -> 243
    //   115: aload_1
    //   116: iload_2
    //   117: aaload
    //   118: astore 9
    //   120: aload 9
    //   122: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +111 -> 236
    //   128: aload 9
    //   130: ldc 118
    //   132: invokevirtual 124	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   135: astore 10
    //   137: aload 10
    //   139: ifnull +97 -> 236
    //   142: aload 10
    //   144: arraylength
    //   145: iconst_4
    //   146: if_icmpne +90 -> 236
    //   149: new 9	com/tencent/smtt/sdk/c$b
    //   152: dup
    //   153: invokespecial 200	com/tencent/smtt/sdk/c$b:<init>	()V
    //   156: astore 9
    //   158: aload 9
    //   160: aload 10
    //   162: iconst_0
    //   163: aaload
    //   164: invokestatic 130	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: putfield 142	com/tencent/smtt/sdk/c$b:a	I
    //   170: aload 9
    //   172: aload 10
    //   174: iconst_1
    //   175: aaload
    //   176: invokestatic 130	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   179: putfield 76	com/tencent/smtt/sdk/c$b:b	I
    //   182: aload 9
    //   184: aload 10
    //   186: iconst_2
    //   187: aaload
    //   188: invokestatic 193	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   191: putfield 86	com/tencent/smtt/sdk/c$b:c	Ljava/lang/String;
    //   194: aload 9
    //   196: aload 10
    //   198: iconst_3
    //   199: aaload
    //   200: invokestatic 206	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   203: putfield 209	com/tencent/smtt/sdk/c$b:d	J
    //   206: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   209: aload 9
    //   211: getfield 209	com/tencent/smtt/sdk/c$b:d	J
    //   214: lcmp
    //   215: ifge +21 -> 236
    //   218: aload 7
    //   220: aload 9
    //   222: getfield 142	com/tencent/smtt/sdk/c$b:a	I
    //   225: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aload 9
    //   230: invokeinterface 221 3 0
    //   235: pop
    //   236: iload_2
    //   237: iconst_1
    //   238: iadd
    //   239: istore_2
    //   240: goto -130 -> 110
    //   243: aload 8
    //   245: aload_0
    //   246: getfield 47	com/tencent/smtt/sdk/c:c	Ljava/lang/String;
    //   249: ldc 101
    //   251: invokeinterface 107 3 0
    //   256: astore_1
    //   257: aload_0
    //   258: ldc 223
    //   260: aload_1
    //   261: invokestatic 193	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   264: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   267: invokespecial 92	com/tencent/smtt/sdk/c:a	(Ljava/lang/String;)V
    //   270: aload_1
    //   271: ldc 118
    //   273: invokevirtual 124	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   276: astore_1
    //   277: aload_1
    //   278: ifnull +109 -> 387
    //   281: new 225	java/util/ArrayList
    //   284: dup
    //   285: invokespecial 226	java/util/ArrayList:<init>	()V
    //   288: astore 8
    //   290: aload_1
    //   291: arraylength
    //   292: istore 6
    //   294: iconst_0
    //   295: istore_2
    //   296: iload 4
    //   298: istore_3
    //   299: iload_2
    //   300: iload 6
    //   302: if_icmpge +51 -> 353
    //   305: aload_1
    //   306: iload_2
    //   307: aaload
    //   308: astore 9
    //   310: aload 9
    //   312: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   315: ifne +31 -> 346
    //   318: iconst_m1
    //   319: istore_3
    //   320: aload 9
    //   322: invokestatic 130	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   325: istore 5
    //   327: iload 5
    //   329: istore_3
    //   330: iload_3
    //   331: ifle +15 -> 346
    //   334: aload 8
    //   336: iload_3
    //   337: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: invokeinterface 229 2 0
    //   345: pop
    //   346: iload_2
    //   347: iconst_1
    //   348: iadd
    //   349: istore_2
    //   350: goto -54 -> 296
    //   353: iload_3
    //   354: aload 8
    //   356: invokeinterface 233 1 0
    //   361: if_icmpge +26 -> 387
    //   364: aload 7
    //   366: aload 8
    //   368: iload_3
    //   369: invokeinterface 237 2 0
    //   374: invokeinterface 241 2 0
    //   379: pop
    //   380: iload_3
    //   381: iconst_1
    //   382: iadd
    //   383: istore_3
    //   384: goto -31 -> 353
    //   387: ldc 181
    //   389: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: aload 7
    //   394: areturn
    //   395: astore 9
    //   397: goto -67 -> 330
    //   400: astore 10
    //   402: goto -196 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	c
    //   0	405	1	paramContext	Context
    //   109	241	2	i	int
    //   107	277	3	j	int
    //   1	296	4	k	int
    //   325	3	5	m	int
    //   292	11	6	n	int
    //   15	378	7	localHashMap	java.util.HashMap
    //   26	341	8	localObject1	Object
    //   118	203	9	localObject2	Object
    //   395	1	9	localObject3	Object
    //   135	62	10	arrayOfString	String[]
    //   400	1	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   320	327	395	finally
    //   158	206	400	finally
  }
  
  public void a(Context paramContext, Integer paramInteger, a parama)
  {
    AppMethodBeat.i(219589);
    Map localMap = a(paramContext);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localMap.get((Integer)localIterator.next());
      if (localb == null)
      {
        a("Unexpected null command!");
      }
      else if (localb.b == paramInteger.intValue())
      {
        a(paramContext, localb, parama);
        AppMethodBeat.o(219589);
        return;
      }
    }
    if (!g)
    {
      this.f.put(paramInteger, parama);
      a("Emergence config did not arrived yet, code[" + paramInteger + "] has been suspended");
    }
    AppMethodBeat.o(219589);
  }
  
  public void b(Context paramContext)
  {
    AppMethodBeat.i(219598);
    Map localMap = a(paramContext);
    a("On notify emergence, validate commands: ".concat(String.valueOf(localMap)));
    g = true;
    Iterator localIterator1 = this.f.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator1.next();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Integer localInteger2 = (Integer)localIterator2.next();
        if (((c.b)localMap.get(localInteger2)).b == localInteger1.intValue()) {
          a(paramContext, (c.b)localMap.get(localInteger2), (a)this.f.get(localInteger1));
        }
      }
    }
    if (!this.f.isEmpty())
    {
      a("Emergency code[" + this.f.keySet() + "] did not happen, clear suspended queries");
      this.f.clear();
    }
    AppMethodBeat.o(219598);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.c
 * JD-Core Version:    0.7.0.1
 */