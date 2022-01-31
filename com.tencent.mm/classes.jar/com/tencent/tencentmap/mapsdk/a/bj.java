package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Session;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bj
{
  static AtomicInteger d = new AtomicInteger();
  String a;
  String b;
  bf c;
  av e;
  bb f;
  aq g;
  volatile az h;
  ConcurrentHashMap<String, bk> i;
  ConcurrentHashMap<String, bk> j;
  bj.a k;
  AtomicBoolean l;
  Object m;
  AtomicBoolean n;
  public ConcurrentLinkedQueue<mm> o;
  private Boolean p;
  
  private void a(String paramString)
  {
    bk localbk = (bk)this.i.remove(paramString);
    if (localbk != null)
    {
      this.h.a(localbk);
      localbk.c();
    }
    paramString = (bk)this.j.remove(paramString);
    if (paramString != null) {
      paramString.c();
    }
  }
  
  /* Error */
  private bk c(ar paramar)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:size	()I
    //   7: ifne +77 -> 84
    //   10: aload_0
    //   11: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   14: invokevirtual 79	com/tencent/tencentmap/mapsdk/a/az:a	()Ljava/util/List;
    //   17: invokeinterface 85 1 0
    //   22: ifeq +58 -> 80
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   31: invokevirtual 79	com/tencent/tencentmap/mapsdk/a/az:a	()Ljava/util/List;
    //   34: invokeinterface 85 1 0
    //   39: ifeq +39 -> 78
    //   42: aload_0
    //   43: getstatic 90	com/tencent/tencentmap/mapsdk/a/ba:a	Lcom/tencent/tencentmap/mapsdk/a/ba;
    //   46: aload_0
    //   47: getfield 92	com/tencent/tencentmap/mapsdk/a/bj:e	Lcom/tencent/tencentmap/mapsdk/a/av;
    //   50: invokevirtual 95	com/tencent/tencentmap/mapsdk/a/ba:c	(Lcom/tencent/tencentmap/mapsdk/a/av;)Lcom/tencent/tencentmap/mapsdk/a/az;
    //   53: putfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   56: new 97	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: ldc 104
    //   69: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_0
    //   81: invokespecial 117	com/tencent/tencentmap/mapsdk/a/bj:f	()V
    //   84: aload_0
    //   85: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:size	()I
    //   91: ifne +59 -> 150
    //   94: aload_0
    //   95: getfield 119	com/tencent/tencentmap/mapsdk/a/bj:m	Ljava/lang/Object;
    //   98: astore 4
    //   100: aload 4
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 119	com/tencent/tencentmap/mapsdk/a/bj:m	Ljava/lang/Object;
    //   107: ldc2_w 120
    //   110: invokevirtual 125	java/lang/Object:wait	(J)V
    //   113: aload 4
    //   115: monitorexit
    //   116: new 97	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: ldc 127
    //   129: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: getfield 129	com/tencent/tencentmap/mapsdk/a/bj:a	Ljava/lang/String;
    //   136: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 131
    //   141: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   150: aload_0
    //   151: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   154: invokevirtual 133	com/tencent/tencentmap/mapsdk/a/az:c	()Ljava/util/List;
    //   157: invokeinterface 134 1 0
    //   162: istore_3
    //   163: iconst_0
    //   164: istore_2
    //   165: aload_0
    //   166: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   169: invokevirtual 79	com/tencent/tencentmap/mapsdk/a/az:a	()Ljava/util/List;
    //   172: invokeinterface 85 1 0
    //   177: ifeq +399 -> 576
    //   180: aload_0
    //   181: monitorenter
    //   182: aload_0
    //   183: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   186: invokevirtual 79	com/tencent/tencentmap/mapsdk/a/az:a	()Ljava/util/List;
    //   189: invokeinterface 85 1 0
    //   194: ifeq +39 -> 233
    //   197: aload_0
    //   198: getstatic 90	com/tencent/tencentmap/mapsdk/a/ba:a	Lcom/tencent/tencentmap/mapsdk/a/ba;
    //   201: aload_0
    //   202: getfield 92	com/tencent/tencentmap/mapsdk/a/bj:e	Lcom/tencent/tencentmap/mapsdk/a/av;
    //   205: invokevirtual 95	com/tencent/tencentmap/mapsdk/a/ba:c	(Lcom/tencent/tencentmap/mapsdk/a/av;)Lcom/tencent/tencentmap/mapsdk/a/az;
    //   208: putfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   211: new 97	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   218: aload_0
    //   219: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc 136
    //   224: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: monitorexit
    //   235: aconst_null
    //   236: astore 5
    //   238: aconst_null
    //   239: astore 4
    //   241: aload 4
    //   243: astore 6
    //   245: iload_2
    //   246: iload_3
    //   247: if_icmpge +272 -> 519
    //   250: aload_0
    //   251: getfield 138	com/tencent/tencentmap/mapsdk/a/bj:f	Lcom/tencent/tencentmap/mapsdk/a/bb;
    //   254: aload_0
    //   255: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   258: aload_1
    //   259: invokevirtual 143	com/tencent/tencentmap/mapsdk/a/bb:a	(Lcom/tencent/tencentmap/mapsdk/a/az;Lcom/tencent/tencentmap/mapsdk/a/am;)Lcom/tencent/tencentmap/mapsdk/a/bg;
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +203 -> 469
    //   269: aload 5
    //   271: aload_0
    //   272: invokestatic 148	com/tencent/tencentmap/mapsdk/a/bl:a	(Lcom/tencent/tencentmap/mapsdk/a/bg;Lcom/tencent/tencentmap/mapsdk/a/bj;)Z
    //   275: ifeq +182 -> 457
    //   278: aload_0
    //   279: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   282: aload 5
    //   284: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   287: invokevirtual 155	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: checkcast 58	com/tencent/tencentmap/mapsdk/a/bk
    //   293: astore 6
    //   295: aload 6
    //   297: ifnonnull +222 -> 519
    //   300: new 97	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   307: aload_0
    //   308: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   311: ldc 157
    //   313: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload 5
    //   318: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: ldc 127
    //   323: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_0
    //   327: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   330: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   333: ldc 127
    //   335: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_0
    //   339: getfield 129	com/tencent/tencentmap/mapsdk/a/bj:a	Ljava/lang/String;
    //   342: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc 159
    //   347: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload_2
    //   351: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc 164
    //   356: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: iload_3
    //   360: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   369: new 58	com/tencent/tencentmap/mapsdk/a/bk
    //   372: dup
    //   373: aload_0
    //   374: aload 5
    //   376: aload_0
    //   377: getfield 166	com/tencent/tencentmap/mapsdk/a/bj:k	Lcom/tencent/tencentmap/mapsdk/a/bj$a;
    //   380: invokespecial 169	com/tencent/tencentmap/mapsdk/a/bk:<init>	(Lcom/tencent/tencentmap/mapsdk/a/bj;Lcom/tencent/tencentmap/mapsdk/a/bg;Lcom/tencent/tencentmap/mapsdk/a/cd;)V
    //   383: astore 4
    //   385: aload_0
    //   386: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   389: aload 5
    //   391: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   394: aload 4
    //   396: invokevirtual 173	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: iload_2
    //   401: iconst_1
    //   402: iadd
    //   403: istore_2
    //   404: aload_0
    //   405: getfield 119	com/tencent/tencentmap/mapsdk/a/bj:m	Ljava/lang/Object;
    //   408: astore 6
    //   410: aload 6
    //   412: monitorenter
    //   413: aload_0
    //   414: getfield 119	com/tencent/tencentmap/mapsdk/a/bj:m	Ljava/lang/Object;
    //   417: ldc2_w 174
    //   420: invokevirtual 125	java/lang/Object:wait	(J)V
    //   423: aload 6
    //   425: monitorexit
    //   426: goto -185 -> 241
    //   429: astore_1
    //   430: aload_0
    //   431: monitorexit
    //   432: aload_1
    //   433: athrow
    //   434: astore 5
    //   436: ldc 177
    //   438: aload 5
    //   440: invokestatic 180	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   443: goto -330 -> 113
    //   446: astore_1
    //   447: aload 4
    //   449: monitorexit
    //   450: aload_1
    //   451: athrow
    //   452: astore_1
    //   453: aload_0
    //   454: monitorexit
    //   455: aload_1
    //   456: athrow
    //   457: aload_0
    //   458: aload 5
    //   460: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   463: invokespecial 181	com/tencent/tencentmap/mapsdk/a/bj:a	(Ljava/lang/String;)V
    //   466: goto -66 -> 400
    //   469: new 97	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   476: aload_0
    //   477: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   480: ldc 183
    //   482: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_0
    //   486: getfield 129	com/tencent/tencentmap/mapsdk/a/bj:a	Ljava/lang/String;
    //   489: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   498: goto -98 -> 400
    //   501: astore 7
    //   503: ldc 177
    //   505: aload 7
    //   507: invokestatic 180	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   510: goto -87 -> 423
    //   513: astore_1
    //   514: aload 6
    //   516: monitorexit
    //   517: aload_1
    //   518: athrow
    //   519: aload 6
    //   521: ifnonnull +52 -> 573
    //   524: new 185	com/tencent/tencentmap/mapsdk/a/bs
    //   527: dup
    //   528: new 97	java/lang/StringBuilder
    //   531: dup
    //   532: ldc 187
    //   534: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   537: aload 5
    //   539: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: ldc 127
    //   544: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_0
    //   548: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   551: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   554: ldc 127
    //   556: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_0
    //   560: getfield 129	com/tencent/tencentmap/mapsdk/a/bj:a	Ljava/lang/String;
    //   563: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokespecial 190	com/tencent/tencentmap/mapsdk/a/bs:<init>	(Ljava/lang/String;)V
    //   572: athrow
    //   573: aload 6
    //   575: areturn
    //   576: aconst_null
    //   577: astore 5
    //   579: aconst_null
    //   580: astore 4
    //   582: goto -341 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	bj
    //   0	585	1	paramar	ar
    //   164	240	2	i1	int
    //   162	198	3	i2	int
    //   98	483	4	localObject1	Object
    //   236	154	5	localbg	bg
    //   434	104	5	localInterruptedException1	java.lang.InterruptedException
    //   577	1	5	localObject2	Object
    //   501	5	7	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   27	78	429	finally
    //   78	80	429	finally
    //   430	432	429	finally
    //   103	113	434	java/lang/InterruptedException
    //   103	113	446	finally
    //   113	116	446	finally
    //   436	443	446	finally
    //   447	450	446	finally
    //   182	233	452	finally
    //   233	235	452	finally
    //   453	455	452	finally
    //   413	423	501	java/lang/InterruptedException
    //   413	423	513	finally
    //   423	426	513	finally
    //   503	510	513	finally
    //   514	517	513	finally
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 194	com/tencent/tencentmap/mapsdk/a/bj:n	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: iconst_0
    //   9: iconst_1
    //   10: invokevirtual 200	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   13: istore 4
    //   15: iload 4
    //   17: ifeq +383 -> 400
    //   20: aload_0
    //   21: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   24: invokevirtual 202	com/tencent/tencentmap/mapsdk/a/az:f	()Ljava/util/List;
    //   27: invokeinterface 206 1 0
    //   32: astore 6
    //   34: iload_3
    //   35: istore_1
    //   36: aload 6
    //   38: invokeinterface 211 1 0
    //   43: ifeq +359 -> 402
    //   46: aload 6
    //   48: invokeinterface 215 1 0
    //   53: checkcast 150	com/tencent/tencentmap/mapsdk/a/bg
    //   56: astore 7
    //   58: new 97	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 217
    //   64: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 219	com/tencent/tencentmap/mapsdk/a/bj:g	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   71: invokevirtual 223	com/tencent/tencentmap/mapsdk/a/aq:c	()Ljava/lang/String;
    //   74: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 225
    //   79: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 7
    //   84: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   93: aload 7
    //   95: getfield 228	com/tencent/tencentmap/mapsdk/a/bg:d	Z
    //   98: ifne +86 -> 184
    //   101: aload 7
    //   103: getfield 229	com/tencent/tencentmap/mapsdk/a/bg:a	Ljava/lang/String;
    //   106: ldc 231
    //   108: invokevirtual 237	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +73 -> 184
    //   114: new 97	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 239
    //   120: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 7
    //   125: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   134: goto -100 -> 34
    //   137: astore 5
    //   139: iconst_1
    //   140: istore_1
    //   141: new 97	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   148: aload_0
    //   149: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   152: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/az:e	()Ljava/lang/String;
    //   155: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 243
    //   160: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload 5
    //   168: invokestatic 245	com/tencent/tencentmap/mapsdk/a/bc:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: iload_1
    //   172: ifeq +11 -> 183
    //   175: aload_0
    //   176: getfield 194	com/tencent/tencentmap/mapsdk/a/bj:n	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   179: iconst_0
    //   180: invokevirtual 249	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   183: return
    //   184: aload_0
    //   185: getfield 50	com/tencent/tencentmap/mapsdk/a/bj:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   188: aload 7
    //   190: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   193: invokevirtual 252	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   196: ifeq +136 -> 332
    //   199: new 97	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   206: aload_0
    //   207: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: ldc 254
    //   212: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 7
    //   217: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: ldc_w 256
    //   223: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   232: aload_0
    //   233: getfield 50	com/tencent/tencentmap/mapsdk/a/bj:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   236: aload 7
    //   238: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   241: invokevirtual 155	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 58	com/tencent/tencentmap/mapsdk/a/bk
    //   247: astore 5
    //   249: aload_0
    //   250: getfield 60	com/tencent/tencentmap/mapsdk/a/bj:h	Lcom/tencent/tencentmap/mapsdk/a/az;
    //   253: aload 5
    //   255: invokevirtual 259	com/tencent/tencentmap/mapsdk/a/az:c	(Lcom/tencent/tencentmap/mapsdk/a/bk;)Z
    //   258: ifeq -224 -> 34
    //   261: new 97	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   268: aload_0
    //   269: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: ldc_w 261
    //   275: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: ldc_w 263
    //   286: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield 69	com/tencent/tencentmap/mapsdk/a/bj:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   299: aload 7
    //   301: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   304: aload 5
    //   306: invokevirtual 173	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: goto -276 -> 34
    //   313: astore 5
    //   315: iload_2
    //   316: istore_1
    //   317: iload_1
    //   318: ifeq +11 -> 329
    //   321: aload_0
    //   322: getfield 194	com/tencent/tencentmap/mapsdk/a/bj:n	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   325: iconst_0
    //   326: invokevirtual 249	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   329: aload 5
    //   331: athrow
    //   332: new 97	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   339: aload_0
    //   340: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: ldc_w 265
    //   346: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload 7
    //   351: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: ldc_w 267
    //   357: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 115	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   366: new 58	com/tencent/tencentmap/mapsdk/a/bk
    //   369: dup
    //   370: aload_0
    //   371: aload 7
    //   373: aload_0
    //   374: getfield 166	com/tencent/tencentmap/mapsdk/a/bj:k	Lcom/tencent/tencentmap/mapsdk/a/bj$a;
    //   377: invokespecial 169	com/tencent/tencentmap/mapsdk/a/bk:<init>	(Lcom/tencent/tencentmap/mapsdk/a/bj;Lcom/tencent/tencentmap/mapsdk/a/bg;Lcom/tencent/tencentmap/mapsdk/a/cd;)V
    //   380: astore 5
    //   382: aload_0
    //   383: getfield 50	com/tencent/tencentmap/mapsdk/a/bj:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   386: aload 7
    //   388: invokevirtual 152	com/tencent/tencentmap/mapsdk/a/bg:a	()Ljava/lang/String;
    //   391: aload 5
    //   393: invokevirtual 173	java/util/concurrent/ConcurrentHashMap:putIfAbsent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   396: pop
    //   397: goto -148 -> 249
    //   400: iconst_0
    //   401: istore_1
    //   402: iload_1
    //   403: ifeq -220 -> 183
    //   406: aload_0
    //   407: getfield 194	com/tencent/tencentmap/mapsdk/a/bj:n	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   410: iconst_0
    //   411: invokevirtual 249	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   414: return
    //   415: astore 5
    //   417: iconst_0
    //   418: istore_1
    //   419: goto -102 -> 317
    //   422: astore 5
    //   424: goto -107 -> 317
    //   427: astore 5
    //   429: iconst_0
    //   430: istore_1
    //   431: goto -290 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	bj
    //   35	396	1	i1	int
    //   3	313	2	i2	int
    //   1	34	3	i3	int
    //   13	3	4	bool	boolean
    //   137	30	5	localThrowable1	Throwable
    //   247	58	5	localbk1	bk
    //   313	17	5	localObject1	Object
    //   380	12	5	localbk2	bk
    //   415	1	5	localObject2	Object
    //   422	1	5	localObject3	Object
    //   427	1	5	localThrowable2	Throwable
    //   32	15	6	localIterator	Iterator
    //   56	331	7	localbg	bg
    // Exception table:
    //   from	to	target	type
    //   20	34	137	java/lang/Throwable
    //   36	134	137	java/lang/Throwable
    //   184	249	137	java/lang/Throwable
    //   249	310	137	java/lang/Throwable
    //   332	397	137	java/lang/Throwable
    //   20	34	313	finally
    //   36	134	313	finally
    //   184	249	313	finally
    //   249	310	313	finally
    //   332	397	313	finally
    //   4	15	415	finally
    //   141	171	422	finally
    //   4	15	427	java/lang/Throwable
  }
  
  public at a(long paramLong, boolean paramBoolean)
  {
    at localat = new at(b(), paramLong);
    localat.a(paramBoolean);
    return localat;
  }
  
  public void a()
  {
    if (!this.p.booleanValue()) {}
    for (;;)
    {
      synchronized (this.p)
      {
        if (!this.p.booleanValue())
        {
          if (this.h.f().isEmpty()) {
            bc.a(this + " initConfigs from registry");
          }
        }
        else
        {
          try
          {
            az localaz = ba.a.c(this.e);
            if ((localaz == null) || (localaz.f().isEmpty())) {
              continue;
            }
            a(localaz);
          }
          catch (Throwable localThrowable)
          {
            bc.b(this + " init from registry error, and initConfigs from " + this.h);
            a(this.h);
            continue;
          }
          this.p = Boolean.valueOf(true);
          return;
          a(this.h);
        }
      }
      bc.a(this.a + " initConfigs from " + this.h);
      a(this.h);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.l.get()) {
      throw new RuntimeException("all service conn is closed, can not set allConnNum.");
    }
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      try
      {
        localObject = (bk)((Map.Entry)localObject).getValue();
        ((bk)localObject).d().a(paramInt);
        ((bk)localObject).a();
      }
      catch (Exception localException)
      {
        bc.b(this + " setConnNum(" + paramInt + ") error", localException);
      }
    }
  }
  
  public void a(ar paramar)
  {
    bk localbk = c(paramar);
    localbk.b(paramar);
    bc.c(this.g.c() + " " + localbk.d() + " send msg " + paramar.e().h());
  }
  
  public void a(av paramav)
  {
    this.e = paramav;
  }
  
  public void a(az paramaz)
  {
    bc.c(this + " " + this.a + " refreshEndPoints start ");
    Object localObject1 = paramaz.a();
    Object localObject2 = this.j.entrySet().iterator();
    label382:
    for (;;)
    {
      String str;
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        Iterator localIterator = ((List)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((bg)localIterator.next()).a().equals(str));
      }
      for (int i1 = 1;; i1 = 0)
      {
        for (;;)
        {
          if (i1 != 0) {
            break label382;
          }
          try
          {
            a(str);
            bc.a(this + " removeNotexistService " + str);
          }
          catch (Exception localException2)
          {
            bc.b(this + " removeNotexistService " + str + " error " + localException2, localException2);
          }
        }
        break;
        localObject1 = paramaz.b().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bg)((Iterator)localObject1).next();
          try
          {
            a(((bg)localObject2).a());
            bc.a(this + " refresh removeInactiveService " + ((bg)localObject2).a());
          }
          catch (Exception localException1)
          {
            bc.b(this + " refresh removeInactiveService " + localObject2 + " error " + localException1, localException1);
          }
        }
        this.h = paramaz;
        f();
        this.l.set(false);
        bc.c(this + " refreshEndPoints end, serviceInfos=" + this.h);
        return;
      }
    }
  }
  
  public void a(bb parambb)
  {
    this.f = parambb;
  }
  
  public void a(bk parambk)
  {
    try
    {
      if (!parambk.a.isOpen())
      {
        this.h.a(parambk);
        if ((bk)this.j.remove(parambk.d().a()) != null) {
          bc.a(this + " remove aliveServiceMap " + parambk + " for " + this.a);
        }
      }
      else
      {
        bc.b(parambk.d().a() + " warn failed service has alive session,can not remove");
        return;
      }
    }
    catch (Exception parambk)
    {
      bc.b(this + " onAllSessoinClose error " + this.a + " " + parambk);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    ap.a().c(this.e);
  }
  
  protected int b()
  {
    return d.incrementAndGet();
  }
  
  public void b(ar paramar)
  {
    try
    {
      c(paramar).b(paramar);
      return;
    }
    catch (Exception localException)
    {
      bc.a(this + " tryAgainSend msg Exception " + localException, localException);
      paramar.e().a(new bo("second send " + localException.toString(), localException));
      be localbe1;
      return;
    }
    catch (Throwable localThrowable)
    {
      bc.a(this + " tryAgainSend msg Throwable " + localThrowable, localThrowable);
      paramar.e().a(new bo(localThrowable.toString(), localThrowable));
      be localbe2;
      return;
    }
    finally
    {
      if (paramar.e().g())
      {
        be localbe3 = be.a(-8, paramar.e().h());
        localbe3.a(paramar.e());
        this.g.e().a(localbe3);
      }
    }
  }
  
  public void b(bk parambk)
  {
    try
    {
      if (this.j.containsKey(parambk.d().a())) {
        bc.a(this + " also has alive service " + parambk + " in map.");
      }
      this.h.b(parambk);
      this.j.putIfAbsent(parambk.d().a(), parambk);
      synchronized (this.m)
      {
        this.m.notifyAll();
        bc.a(this + " put aliveServiceMap " + parambk + " for " + this.a);
        return;
      }
      return;
    }
    catch (Exception parambk)
    {
      bc.b(this + " onSessionOpen error " + this.a + " " + parambk);
    }
  }
  
  public av c()
  {
    return this.e;
  }
  
  public bb d()
  {
    return this.f;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.a + "'s Router(ID=" + this.e.getID() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bj
 * JD-Core Version:    0.7.0.1
 */