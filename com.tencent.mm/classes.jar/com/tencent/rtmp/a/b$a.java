package com.tencent.rtmp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class b$a
  implements Runnable
{
  private WeakReference<b> a;
  private String b;
  
  public b$a(b paramb, String paramString)
  {
    AppMethodBeat.i(65975);
    this.a = new WeakReference(paramb);
    this.b = paramString;
    AppMethodBeat.o(65975);
  }
  
  private float a(String paramString)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(65976);
    paramString = paramString.split(":");
    Object localObject;
    String str;
    if (paramString.length == 3)
    {
      localObject = paramString[0];
      str = paramString[1];
      paramString = paramString[2];
    }
    for (;;)
    {
      if ((localObject == null) || (str != null)) {
        f1 = 0.0F + Float.valueOf(str).floatValue() * 60.0F;
      }
      float f2 = f1;
      if (paramString != null) {
        f2 = f1 + Float.valueOf(paramString).floatValue();
      }
      AppMethodBeat.o(65976);
      return f2;
      if (paramString.length == 2)
      {
        str = paramString[0];
        paramString = paramString[1];
        localObject = null;
      }
      else if (paramString.length == 1)
      {
        paramString = paramString[0];
        str = null;
        localObject = null;
      }
      else
      {
        paramString = null;
        str = null;
        localObject = null;
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 32	com/tencent/rtmp/a/b$a:a	Ljava/lang/ref/WeakReference;
    //   9: invokevirtual 67	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   12: checkcast 8	com/tencent/rtmp/a/b
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 34	com/tencent/rtmp/a/b$a:b	Ljava/lang/String;
    //   21: invokestatic 70	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnonnull +9 -> 35
    //   29: ldc 63
    //   31: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: return
    //   35: new 72	java/io/BufferedReader
    //   38: dup
    //   39: new 74	java/io/InputStreamReader
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 77	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 80	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 84	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +21 -> 80
    //   62: aload 4
    //   64: invokevirtual 88	java/lang/String:length	()I
    //   67: ifeq +13 -> 80
    //   70: aload 4
    //   72: ldc 90
    //   74: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifne +35 -> 112
    //   80: ldc 96
    //   82: ldc 98
    //   84: invokestatic 104	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokestatic 108	com/tencent/rtmp/a/b:c	(Lcom/tencent/rtmp/a/b;)V
    //   95: aload_2
    //   96: invokevirtual 111	java/io/BufferedReader:close	()V
    //   99: ldc 63
    //   101: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: astore_2
    //   106: ldc 63
    //   108: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: return
    //   112: aload_2
    //   113: invokevirtual 84	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   116: astore 4
    //   118: aload 4
    //   120: ifnull +236 -> 356
    //   123: aload 4
    //   125: ldc 113
    //   127: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +226 -> 356
    //   133: aload 4
    //   135: ldc 115
    //   137: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   140: astore 6
    //   142: aload 6
    //   144: arraylength
    //   145: iconst_2
    //   146: if_icmpne +210 -> 356
    //   149: aload_2
    //   150: invokevirtual 84	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   153: astore 7
    //   155: new 117	com/tencent/rtmp/a/c
    //   158: dup
    //   159: invokespecial 118	com/tencent/rtmp/a/c:<init>	()V
    //   162: astore 5
    //   164: aload 5
    //   166: aload_0
    //   167: aload 6
    //   169: iconst_0
    //   170: aaload
    //   171: invokespecial 120	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
    //   174: putfield 123	com/tencent/rtmp/a/c:a	F
    //   177: aload 5
    //   179: aload_0
    //   180: aload 6
    //   182: iconst_1
    //   183: aaload
    //   184: invokespecial 120	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
    //   187: putfield 125	com/tencent/rtmp/a/c:b	F
    //   190: aload 5
    //   192: aload 7
    //   194: putfield 127	com/tencent/rtmp/a/c:c	Ljava/lang/String;
    //   197: aload 7
    //   199: ldc 129
    //   201: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   204: istore_1
    //   205: iload_1
    //   206: iconst_m1
    //   207: if_icmpeq +15 -> 222
    //   210: aload 5
    //   212: aload 7
    //   214: iconst_0
    //   215: iload_1
    //   216: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   219: putfield 140	com/tencent/rtmp/a/c:d	Ljava/lang/String;
    //   222: aload 7
    //   224: ldc 142
    //   226: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   229: istore_1
    //   230: iload_1
    //   231: iconst_m1
    //   232: if_icmpeq +101 -> 333
    //   235: iload_1
    //   236: iconst_1
    //   237: iadd
    //   238: aload 7
    //   240: invokevirtual 88	java/lang/String:length	()I
    //   243: if_icmpge +90 -> 333
    //   246: aload 7
    //   248: iload_1
    //   249: iconst_1
    //   250: iadd
    //   251: aload 7
    //   253: invokevirtual 88	java/lang/String:length	()I
    //   256: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   259: ldc 144
    //   261: invokevirtual 48	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   264: astore 6
    //   266: aload 6
    //   268: arraylength
    //   269: iconst_4
    //   270: if_icmpne +63 -> 333
    //   273: aload 5
    //   275: aload 6
    //   277: iconst_0
    //   278: aaload
    //   279: invokestatic 149	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   282: invokevirtual 152	java/lang/Integer:intValue	()I
    //   285: putfield 155	com/tencent/rtmp/a/c:e	I
    //   288: aload 5
    //   290: aload 6
    //   292: iconst_1
    //   293: aaload
    //   294: invokestatic 149	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   297: invokevirtual 152	java/lang/Integer:intValue	()I
    //   300: putfield 158	com/tencent/rtmp/a/c:f	I
    //   303: aload 5
    //   305: aload 6
    //   307: iconst_2
    //   308: aaload
    //   309: invokestatic 149	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 152	java/lang/Integer:intValue	()I
    //   315: putfield 161	com/tencent/rtmp/a/c:g	I
    //   318: aload 5
    //   320: aload 6
    //   322: iconst_3
    //   323: aaload
    //   324: invokestatic 149	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   327: invokevirtual 152	java/lang/Integer:intValue	()I
    //   330: putfield 164	com/tencent/rtmp/a/c:h	I
    //   333: aload_3
    //   334: ifnull +22 -> 356
    //   337: aload_3
    //   338: invokestatic 167	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
    //   341: ifnull +15 -> 356
    //   344: aload_3
    //   345: invokestatic 167	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
    //   348: aload 5
    //   350: invokeinterface 173 2 0
    //   355: pop
    //   356: aload 4
    //   358: ifnonnull -246 -> 112
    //   361: aload_2
    //   362: invokevirtual 111	java/io/BufferedReader:close	()V
    //   365: ldc 63
    //   367: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: return
    //   371: astore_2
    //   372: ldc 63
    //   374: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   377: return
    //   378: astore_2
    //   379: aconst_null
    //   380: astore_2
    //   381: aload_2
    //   382: ifnull +38 -> 420
    //   385: aload_2
    //   386: invokevirtual 111	java/io/BufferedReader:close	()V
    //   389: ldc 63
    //   391: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    //   395: astore_2
    //   396: ldc 63
    //   398: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: return
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_2
    //   405: aload_2
    //   406: ifnull +7 -> 413
    //   409: aload_2
    //   410: invokevirtual 111	java/io/BufferedReader:close	()V
    //   413: ldc 63
    //   415: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_3
    //   419: athrow
    //   420: ldc 63
    //   422: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   425: return
    //   426: astore_2
    //   427: goto -14 -> 413
    //   430: astore_3
    //   431: goto -26 -> 405
    //   434: astore_3
    //   435: goto -54 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	a
    //   204	47	1	i	int
    //   24	72	2	localObject1	Object
    //   105	257	2	localIOException1	java.io.IOException
    //   371	1	2	localIOException2	java.io.IOException
    //   378	1	2	localIOException3	java.io.IOException
    //   380	6	2	localObject2	Object
    //   395	1	2	localIOException4	java.io.IOException
    //   404	6	2	localObject3	Object
    //   426	1	2	localIOException5	java.io.IOException
    //   15	330	3	localb	b
    //   402	17	3	localObject4	Object
    //   430	1	3	localObject5	Object
    //   434	1	3	localIOException6	java.io.IOException
    //   55	302	4	str1	String
    //   162	187	5	localc	c
    //   140	181	6	arrayOfString	String[]
    //   153	99	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   95	99	105	java/io/IOException
    //   361	365	371	java/io/IOException
    //   16	25	378	java/io/IOException
    //   35	51	378	java/io/IOException
    //   385	389	395	java/io/IOException
    //   16	25	402	finally
    //   35	51	402	finally
    //   409	413	426	java/io/IOException
    //   51	57	430	finally
    //   62	80	430	finally
    //   80	87	430	finally
    //   91	95	430	finally
    //   112	118	430	finally
    //   123	205	430	finally
    //   210	222	430	finally
    //   222	230	430	finally
    //   235	333	430	finally
    //   337	356	430	finally
    //   51	57	434	java/io/IOException
    //   62	80	434	java/io/IOException
    //   80	87	434	java/io/IOException
    //   91	95	434	java/io/IOException
    //   112	118	434	java/io/IOException
    //   123	205	434	java/io/IOException
    //   210	222	434	java/io/IOException
    //   222	230	434	java/io/IOException
    //   235	333	434	java/io/IOException
    //   337	356	434	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.rtmp.a.b.a
 * JD-Core Version:    0.7.0.1
 */