package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bd;

public class ld
  extends jd
{
  private Context a;
  private bd b;
  private byte[] c;
  private String d;
  private String e;
  private f f;
  private nr g;
  
  public ld(kx paramkx)
  {
    AppMethodBeat.i(149137);
    this.b = new bd();
    this.c = null;
    this.d = "UNKNOW";
    this.e = "";
    this.a = paramkx.i();
    this.d = this.a.getClass().getSimpleName();
    this.a = this.a.getApplicationContext();
    this.f = paramkx.b();
    this.g = paramkx.o();
    AppMethodBeat.o(149137);
  }
  
  /* Error */
  public byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 51	com/tencent/tencentmap/mapsdk/maps/a/ld:a	Landroid/content/Context;
    //   9: ifnull +17 -> 26
    //   12: aload_1
    //   13: ifnull +13 -> 26
    //   16: aload_1
    //   17: invokevirtual 93	java/lang/String:trim	()Ljava/lang/String;
    //   20: invokevirtual 97	java/lang/String:length	()I
    //   23: ifne +10 -> 33
    //   26: ldc 88
    //   28: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: getfield 73	com/tencent/tencentmap/mapsdk/maps/a/ld:f	Lcom/tencent/map/lib/f;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 44	com/tencent/tencentmap/mapsdk/maps/a/ld:e	Ljava/lang/String;
    //   44: invokestatic 103	com/tencent/map/lib/util/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   47: ifeq +42 -> 89
    //   50: aload_0
    //   51: getfield 73	com/tencent/tencentmap/mapsdk/maps/a/ld:f	Lcom/tencent/map/lib/f;
    //   54: invokevirtual 108	com/tencent/map/lib/f:E	()Ljava/lang/String;
    //   57: invokestatic 103	com/tencent/map/lib/util/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   60: ifne +29 -> 89
    //   63: aload_0
    //   64: new 110	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 112
    //   70: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 73	com/tencent/tencentmap/mapsdk/maps/a/ld:f	Lcom/tencent/map/lib/f;
    //   77: invokevirtual 108	com/tencent/map/lib/f:E	()Ljava/lang/String;
    //   80: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: putfield 44	com/tencent/tencentmap/mapsdk/maps/a/ld:e	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 34	com/tencent/tencentmap/mapsdk/maps/a/ld:b	Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   93: aload_1
    //   94: invokevirtual 124	com/tencent/tencentmap/mapsdk/a/bd:a	(Ljava/lang/String;)Z
    //   97: ifne +10 -> 107
    //   100: ldc 88
    //   102: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_1
    //   108: astore_3
    //   109: aload_1
    //   110: ifnull +28 -> 138
    //   113: aload_1
    //   114: ldc 126
    //   116: ldc 128
    //   118: invokevirtual 132	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: ldc 134
    //   123: invokestatic 138	com/tencent/tencentmap/mapsdk/maps/a/jq:b	()Ljava/lang/String;
    //   126: invokevirtual 132	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   129: ldc 140
    //   131: invokestatic 138	com/tencent/tencentmap/mapsdk/maps/a/jq:b	()Ljava/lang/String;
    //   134: invokevirtual 132	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   137: astore_3
    //   138: aload_3
    //   139: invokestatic 143	com/tencent/tencentmap/mapsdk/maps/a/jq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 4
    //   144: aload 4
    //   146: ldc 145
    //   148: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +113 -> 264
    //   154: aload 4
    //   156: ldc 151
    //   158: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +103 -> 264
    //   164: aload 4
    //   166: ldc 153
    //   168: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   171: ifeq +93 -> 264
    //   174: iconst_1
    //   175: istore_2
    //   176: iload_2
    //   177: ifne +302 -> 479
    //   180: aload 4
    //   182: ldc 155
    //   184: invokevirtual 158	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   187: ifne +512 -> 699
    //   190: aload 4
    //   192: ldc 160
    //   194: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   197: ifne +502 -> 699
    //   200: aload 4
    //   202: ldc 165
    //   204: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   207: ifne +492 -> 699
    //   210: new 110	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   217: aload 4
    //   219: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: getfield 44	com/tencent/tencentmap/mapsdk/maps/a/ld:e	Ljava/lang/String;
    //   226: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 40	com/tencent/tencentmap/mapsdk/maps/a/ld:d	Ljava/lang/String;
    //   233: invokestatic 170	com/tencent/tencentmap/mapsdk/maps/a/ka:c	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore_1
    //   243: invokestatic 175	com/tencent/tencentmap/mapsdk/a/dp:a	()Lcom/tencent/tencentmap/mapsdk/a/dp;
    //   246: aload_1
    //   247: ldc 177
    //   249: invokevirtual 180	com/tencent/tencentmap/mapsdk/a/dp:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/dq;
    //   252: astore_3
    //   253: aload_3
    //   254: ifnonnull +90 -> 344
    //   257: ldc 88
    //   259: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: aconst_null
    //   263: areturn
    //   264: iconst_0
    //   265: istore_2
    //   266: goto -90 -> 176
    //   269: astore_3
    //   270: aload_1
    //   271: ldc 134
    //   273: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   276: ifeq +43 -> 319
    //   279: aload_3
    //   280: instanceof 182
    //   283: ifeq +43 -> 326
    //   286: aload_3
    //   287: checkcast 182	com/tencent/tencentmap/mapsdk/a/dt
    //   290: getfield 185	com/tencent/tencentmap/mapsdk/a/dt:a	I
    //   293: istore_2
    //   294: aload_0
    //   295: getfield 79	com/tencent/tencentmap/mapsdk/maps/a/ld:g	Lcom/tencent/tencentmap/mapsdk/maps/a/nr;
    //   298: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   301: aload 4
    //   303: aload 4
    //   305: bipush 63
    //   307: invokevirtual 195	java/lang/String:indexOf	(I)I
    //   310: iconst_1
    //   311: iadd
    //   312: invokevirtual 199	java/lang/String:substring	(I)Ljava/lang/String;
    //   315: iload_2
    //   316: invokevirtual 204	com/tencent/tencentmap/mapsdk/maps/a/nr:a	(JLjava/lang/String;I)V
    //   319: ldc 88
    //   321: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aconst_null
    //   325: areturn
    //   326: aload_3
    //   327: instanceof 206
    //   330: ifeq +364 -> 694
    //   333: aload_3
    //   334: checkcast 206	com/tencent/tencentmap/mapsdk/a/du
    //   337: getfield 208	com/tencent/tencentmap/mapsdk/a/du:b	I
    //   340: istore_2
    //   341: goto -47 -> 294
    //   344: aload 4
    //   346: ldc 210
    //   348: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   351: ifne +12 -> 363
    //   354: aload_0
    //   355: getfield 34	com/tencent/tencentmap/mapsdk/maps/a/ld:b	Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   358: aload 4
    //   360: invokevirtual 212	com/tencent/tencentmap/mapsdk/a/bd:b	(Ljava/lang/String;)V
    //   363: aload 4
    //   365: ldc 165
    //   367: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   370: ifeq +97 -> 467
    //   373: aload_3
    //   374: getfield 216	com/tencent/tencentmap/mapsdk/a/dq:a	[B
    //   377: ifnull +90 -> 467
    //   380: aload_3
    //   381: getfield 216	com/tencent/tencentmap/mapsdk/a/dq:a	[B
    //   384: arraylength
    //   385: ifne +82 -> 467
    //   388: aload_0
    //   389: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/ld:c	[B
    //   392: ifnonnull +67 -> 459
    //   395: sipush 256
    //   398: sipush 256
    //   401: getstatic 222	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   404: invokestatic 228	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   407: astore_1
    //   408: new 230	android/graphics/Canvas
    //   411: dup
    //   412: aload_1
    //   413: invokespecial 233	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   416: iconst_0
    //   417: sipush 255
    //   420: sipush 255
    //   423: sipush 255
    //   426: invokevirtual 237	android/graphics/Canvas:drawARGB	(IIII)V
    //   429: new 239	java/io/ByteArrayOutputStream
    //   432: dup
    //   433: invokespecial 240	java/io/ByteArrayOutputStream:<init>	()V
    //   436: astore 4
    //   438: aload_1
    //   439: getstatic 246	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   442: bipush 100
    //   444: aload 4
    //   446: invokevirtual 250	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   449: pop
    //   450: aload_0
    //   451: aload 4
    //   453: invokevirtual 254	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   456: putfield 36	com/tencent/tencentmap/mapsdk/maps/a/ld:c	[B
    //   459: aload_3
    //   460: aload_0
    //   461: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/ld:c	[B
    //   464: putfield 216	com/tencent/tencentmap/mapsdk/a/dq:a	[B
    //   467: aload_3
    //   468: getfield 216	com/tencent/tencentmap/mapsdk/a/dq:a	[B
    //   471: astore_1
    //   472: ldc 88
    //   474: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: aload_1
    //   478: areturn
    //   479: new 256	java/net/URL
    //   482: dup
    //   483: aload 4
    //   485: invokespecial 257	java/net/URL:<init>	(Ljava/lang/String;)V
    //   488: invokevirtual 261	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   491: checkcast 263	java/net/HttpURLConnection
    //   494: astore_1
    //   495: aload_1
    //   496: ldc_w 265
    //   499: ldc 177
    //   501: invokevirtual 269	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload_1
    //   505: sipush 10000
    //   508: invokevirtual 272	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   511: aload_1
    //   512: invokevirtual 275	java/net/HttpURLConnection:getResponseCode	()I
    //   515: sipush 200
    //   518: if_icmpne +57 -> 575
    //   521: aload_1
    //   522: invokevirtual 279	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   525: astore_3
    //   526: aload_3
    //   527: invokestatic 284	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/InputStream;)[B
    //   530: astore 5
    //   532: aload 4
    //   534: ldc 210
    //   536: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   539: ifne +12 -> 551
    //   542: aload_0
    //   543: getfield 34	com/tencent/tencentmap/mapsdk/maps/a/ld:b	Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   546: aload 4
    //   548: invokevirtual 212	com/tencent/tencentmap/mapsdk/a/bd:b	(Ljava/lang/String;)V
    //   551: aload_1
    //   552: ifnull +7 -> 559
    //   555: aload_1
    //   556: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   559: aload_3
    //   560: ifnull +7 -> 567
    //   563: aload_3
    //   564: invokestatic 290	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   567: ldc 88
    //   569: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: aload 5
    //   574: areturn
    //   575: aload_1
    //   576: ifnull +7 -> 583
    //   579: aload_1
    //   580: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   583: ldc 88
    //   585: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: aconst_null
    //   589: areturn
    //   590: astore_1
    //   591: aconst_null
    //   592: astore_1
    //   593: aconst_null
    //   594: astore_3
    //   595: aload_3
    //   596: ifnull +7 -> 603
    //   599: aload_3
    //   600: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   603: aload_1
    //   604: ifnull -21 -> 583
    //   607: aload_1
    //   608: invokestatic 290	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   611: goto -28 -> 583
    //   614: astore_1
    //   615: aconst_null
    //   616: astore_3
    //   617: aconst_null
    //   618: astore 4
    //   620: aload 4
    //   622: ifnull +8 -> 630
    //   625: aload 4
    //   627: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   630: aload_3
    //   631: ifnull +7 -> 638
    //   634: aload_3
    //   635: invokestatic 290	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   638: ldc 88
    //   640: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: aload_1
    //   644: athrow
    //   645: astore 5
    //   647: aconst_null
    //   648: astore_3
    //   649: aload_1
    //   650: astore 4
    //   652: aload 5
    //   654: astore_1
    //   655: goto -35 -> 620
    //   658: astore 5
    //   660: aload_1
    //   661: astore 4
    //   663: aload 5
    //   665: astore_1
    //   666: goto -46 -> 620
    //   669: astore_3
    //   670: aconst_null
    //   671: astore 4
    //   673: aload_1
    //   674: astore_3
    //   675: aload 4
    //   677: astore_1
    //   678: goto -83 -> 595
    //   681: astore 4
    //   683: aload_3
    //   684: astore 4
    //   686: aload_1
    //   687: astore_3
    //   688: aload 4
    //   690: astore_1
    //   691: goto -96 -> 595
    //   694: iconst_m1
    //   695: istore_2
    //   696: goto -402 -> 294
    //   699: aload 4
    //   701: astore_1
    //   702: goto -459 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	ld
    //   0	705	1	paramString	String
    //   175	521	2	i	int
    //   108	146	3	localObject1	Object
    //   269	199	3	localException	java.lang.Exception
    //   525	124	3	localInputStream	java.io.InputStream
    //   669	1	3	localThrowable1	java.lang.Throwable
    //   674	14	3	str1	String
    //   142	534	4	localObject2	Object
    //   681	1	4	localThrowable2	java.lang.Throwable
    //   684	16	4	str2	String
    //   530	43	5	arrayOfByte	byte[]
    //   645	8	5	localObject3	Object
    //   658	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   243	253	269	java/lang/Exception
    //   479	495	590	java/lang/Throwable
    //   479	495	614	finally
    //   495	526	645	finally
    //   526	551	658	finally
    //   495	526	669	java/lang/Throwable
    //   526	551	681	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ld
 * JD-Core Version:    0.7.0.1
 */