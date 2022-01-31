package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

class ml$a
  extends AsyncTask<Context, Void, Boolean>
{
  private ml$a(ml paramml) {}
  
  /* Error */
  protected Boolean a(Context... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 28	com/tencent/tencentmap/mapsdk/a/mh:a	()I
    //   5: istore_3
    //   6: new 30	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 33
    //   19: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: ldc 39
    //   27: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_1
    //   32: ifnull +27 -> 59
    //   35: aload_1
    //   36: arraylength
    //   37: ifle +22 -> 59
    //   40: aload 6
    //   42: aload_0
    //   43: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   46: aload_1
    //   47: iconst_0
    //   48: aaload
    //   49: invokevirtual 45	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   52: invokestatic 48	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;Landroid/content/Context;)Ljava/lang/String;
    //   55: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 50	java/net/URL
    //   62: dup
    //   63: aload 6
    //   65: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 57	java/net/URL:<init>	(Ljava/lang/String;)V
    //   71: invokevirtual 61	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   74: checkcast 63	javax/net/ssl/HttpsURLConnection
    //   77: astore_1
    //   78: aload_1
    //   79: sipush 3000
    //   82: invokevirtual 67	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   85: aload_1
    //   86: invokevirtual 70	javax/net/ssl/HttpsURLConnection:connect	()V
    //   89: aload_1
    //   90: invokevirtual 74	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: astore 6
    //   95: aload 6
    //   97: invokestatic 79	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/InputStream;)[B
    //   100: astore 7
    //   102: aload 7
    //   104: ifnull +9 -> 113
    //   107: aload 7
    //   109: arraylength
    //   110: ifne +75 -> 185
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   121: aload 6
    //   123: ifnull +8 -> 131
    //   126: aload 6
    //   128: invokestatic 85	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   131: iload_3
    //   132: invokestatic 28	com/tencent/tencentmap/mapsdk/a/mh:a	()I
    //   135: if_icmpeq +5 -> 140
    //   138: iconst_1
    //   139: istore_2
    //   140: iload_2
    //   141: ifeq +39 -> 180
    //   144: aload_0
    //   145: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   148: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   151: ifnull +29 -> 180
    //   154: aload_0
    //   155: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   158: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   161: iload_3
    //   162: invokestatic 91	com/tencent/tencentmap/mapsdk/a/mh:a	(Landroid/content/Context;I)V
    //   165: aload_0
    //   166: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   169: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   172: invokestatic 96	com/tencent/tencentmap/mapsdk/a/mw:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/mw;
    //   175: iconst_1
    //   176: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/mw:a	(I)Z
    //   179: pop
    //   180: iconst_0
    //   181: invokestatic 105	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   184: areturn
    //   185: new 107	java/lang/String
    //   188: dup
    //   189: aload 7
    //   191: invokespecial 110	java/lang/String:<init>	([B)V
    //   194: astore 7
    //   196: aload_0
    //   197: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   200: aload 7
    //   202: iload_3
    //   203: invokestatic 113	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;Ljava/lang/String;I)I
    //   206: istore_2
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   215: aload 6
    //   217: ifnull +8 -> 225
    //   220: aload 6
    //   222: invokestatic 85	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   225: iload_2
    //   226: invokestatic 28	com/tencent/tencentmap/mapsdk/a/mh:a	()I
    //   229: if_icmpeq +65 -> 294
    //   232: iconst_1
    //   233: istore 4
    //   235: iload 4
    //   237: istore 5
    //   239: iload 4
    //   241: ifeq +47 -> 288
    //   244: iload 4
    //   246: istore 5
    //   248: aload_0
    //   249: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   252: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   255: ifnull +33 -> 288
    //   258: aload_0
    //   259: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   262: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   265: iload_2
    //   266: invokestatic 91	com/tencent/tencentmap/mapsdk/a/mh:a	(Landroid/content/Context;I)V
    //   269: aload_0
    //   270: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   273: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   276: invokestatic 96	com/tencent/tencentmap/mapsdk/a/mw:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/mw;
    //   279: iconst_1
    //   280: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/mw:a	(I)Z
    //   283: pop
    //   284: iload 4
    //   286: istore 5
    //   288: iload 5
    //   290: invokestatic 105	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   293: areturn
    //   294: iconst_0
    //   295: istore 4
    //   297: goto -62 -> 235
    //   300: astore 7
    //   302: aconst_null
    //   303: astore_1
    //   304: aconst_null
    //   305: astore 6
    //   307: new 30	java/lang/StringBuilder
    //   310: dup
    //   311: ldc 115
    //   313: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload 7
    //   318: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   321: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 6
    //   327: ifnull +8 -> 335
    //   330: aload 6
    //   332: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokestatic 85	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   343: iload_3
    //   344: invokestatic 28	com/tencent/tencentmap/mapsdk/a/mh:a	()I
    //   347: if_icmpeq +62 -> 409
    //   350: iconst_1
    //   351: istore 4
    //   353: iload 4
    //   355: istore 5
    //   357: iload 4
    //   359: ifeq -71 -> 288
    //   362: iload 4
    //   364: istore 5
    //   366: aload_0
    //   367: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   370: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   373: ifnull -85 -> 288
    //   376: aload_0
    //   377: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   380: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   383: iload_3
    //   384: invokestatic 91	com/tencent/tencentmap/mapsdk/a/mh:a	(Landroid/content/Context;I)V
    //   387: aload_0
    //   388: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   391: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   394: invokestatic 96	com/tencent/tencentmap/mapsdk/a/mw:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/mw;
    //   397: iconst_1
    //   398: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/mw:a	(I)Z
    //   401: pop
    //   402: iload 4
    //   404: istore 5
    //   406: goto -118 -> 288
    //   409: iconst_0
    //   410: istore 4
    //   412: goto -59 -> 353
    //   415: astore 7
    //   417: aconst_null
    //   418: astore_1
    //   419: aconst_null
    //   420: astore 6
    //   422: aload 6
    //   424: ifnull +8 -> 432
    //   427: aload 6
    //   429: invokevirtual 82	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   432: aload_1
    //   433: ifnull +7 -> 440
    //   436: aload_1
    //   437: invokestatic 85	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   440: iload_3
    //   441: invokestatic 28	com/tencent/tencentmap/mapsdk/a/mh:a	()I
    //   444: if_icmpeq +48 -> 492
    //   447: iconst_1
    //   448: istore_2
    //   449: iload_2
    //   450: ifeq +39 -> 489
    //   453: aload_0
    //   454: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   457: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   460: ifnull +29 -> 489
    //   463: aload_0
    //   464: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   467: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   470: iload_3
    //   471: invokestatic 91	com/tencent/tencentmap/mapsdk/a/mh:a	(Landroid/content/Context;I)V
    //   474: aload_0
    //   475: getfield 13	com/tencent/tencentmap/mapsdk/a/ml$a:a	Lcom/tencent/tencentmap/mapsdk/a/ml;
    //   478: invokestatic 88	com/tencent/tencentmap/mapsdk/a/ml:a	(Lcom/tencent/tencentmap/mapsdk/a/ml;)Landroid/content/Context;
    //   481: invokestatic 96	com/tencent/tencentmap/mapsdk/a/mw:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/mw;
    //   484: iconst_1
    //   485: invokevirtual 99	com/tencent/tencentmap/mapsdk/a/mw:a	(I)Z
    //   488: pop
    //   489: aload 7
    //   491: athrow
    //   492: iconst_0
    //   493: istore_2
    //   494: goto -45 -> 449
    //   497: astore 7
    //   499: aconst_null
    //   500: astore 8
    //   502: aload_1
    //   503: astore 6
    //   505: aload 8
    //   507: astore_1
    //   508: goto -86 -> 422
    //   511: astore 7
    //   513: aload_1
    //   514: astore 8
    //   516: aload 6
    //   518: astore_1
    //   519: aload 8
    //   521: astore 6
    //   523: goto -101 -> 422
    //   526: astore 7
    //   528: goto -106 -> 422
    //   531: astore 7
    //   533: aconst_null
    //   534: astore 8
    //   536: aload_1
    //   537: astore 6
    //   539: aload 8
    //   541: astore_1
    //   542: goto -235 -> 307
    //   545: astore 7
    //   547: aload_1
    //   548: astore 8
    //   550: aload 6
    //   552: astore_1
    //   553: aload 8
    //   555: astore 6
    //   557: goto -250 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	a
    //   0	560	1	paramVarArgs	Context[]
    //   1	493	2	i	int
    //   5	466	3	j	int
    //   233	178	4	bool1	boolean
    //   237	168	5	bool2	boolean
    //   13	543	6	localObject1	java.lang.Object
    //   100	101	7	localObject2	java.lang.Object
    //   300	17	7	localThrowable1	java.lang.Throwable
    //   415	75	7	localObject3	java.lang.Object
    //   497	1	7	localObject4	java.lang.Object
    //   511	1	7	localObject5	java.lang.Object
    //   526	1	7	localObject6	java.lang.Object
    //   531	1	7	localThrowable2	java.lang.Throwable
    //   545	1	7	localThrowable3	java.lang.Throwable
    //   500	54	8	arrayOfContext	Context[]
    // Exception table:
    //   from	to	target	type
    //   59	78	300	java/lang/Throwable
    //   59	78	415	finally
    //   78	95	497	finally
    //   95	102	511	finally
    //   107	113	511	finally
    //   185	207	511	finally
    //   307	325	526	finally
    //   78	95	531	java/lang/Throwable
    //   95	102	545	java/lang/Throwable
    //   107	113	545	java/lang/Throwable
    //   185	207	545	java/lang/Throwable
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if ((ml.b(this.a) != null) && (ml.b(this.a).get() != null)) {
      ((ml.b)ml.b(this.a).get()).a(paramBoolean.booleanValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ml.a
 * JD-Core Version:    0.7.0.1
 */