package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.bc;
import com.tencent.tencentmap.mapsdk.a.cy;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.t;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ni
{
  private static volatile ni a;
  private static String d = "/rastermap/world";
  private static String e = "/tencentmapsdk/rastermap/handdraw";
  private Context b;
  private ReentrantReadWriteLock c;
  private final int f;
  
  private ni(Context paramContext)
  {
    AppMethodBeat.i(149471);
    this.c = new ReentrantReadWriteLock();
    this.f = 128;
    this.b = paramContext;
    AppMethodBeat.o(149471);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128 + paramInt2 % 128;
  }
  
  public static ni a(Context paramContext)
  {
    AppMethodBeat.i(149470);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ni(paramContext.getApplicationContext());
      }
      paramContext = a;
      AppMethodBeat.o(149470);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(149470);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 4)) {
      return;
    }
    int i = paramArrayOfByte[0];
    paramArrayOfByte[0] = paramArrayOfByte[3];
    paramArrayOfByte[3] = i;
    i = paramArrayOfByte[1];
    paramArrayOfByte[1] = paramArrayOfByte[2];
    paramArrayOfByte[2] = i;
  }
  
  private String[] a(bc parambc, boolean paramBoolean)
  {
    AppMethodBeat.i(149472);
    int i = parambc.a() / 128;
    int j = parambc.b() / 128;
    int k = i / 10;
    int m = j / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = parambc.e();
    switch (parambc.d())
    {
    default: 
      localObject = null;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(149472);
      return null;
      localObject = a((cy)localObject);
      continue;
      localObject = a();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("glGrid");
    localStringBuilder.append("/");
    localStringBuilder.append(parambc.c());
    localStringBuilder.append("/");
    localStringBuilder.append(k);
    localStringBuilder.append("/");
    localStringBuilder.append(m);
    localStringBuilder.append("/");
    if (!paramBoolean)
    {
      localObject = new File(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    localStringBuilder.append(parambc.c());
    localStringBuilder.append("_");
    localStringBuilder.append(i);
    localStringBuilder.append("_");
    localStringBuilder.append(j);
    parambc = localStringBuilder.toString() + ".idx";
    localObject = localStringBuilder.toString() + ".dat";
    AppMethodBeat.o(149472);
    return new String[] { parambc, localObject };
  }
  
  private int b(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  private byte[] b(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  /* Error */
  public android.graphics.Bitmap a(bc parambc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 133
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: iconst_1
    //   11: invokespecial 135	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Lcom/tencent/tencentmap/mapsdk/a/bc;Z)[Ljava/lang/String;
    //   14: astore 8
    //   16: aload 8
    //   18: ifnull +36 -> 54
    //   21: aload 8
    //   23: arraylength
    //   24: iconst_2
    //   25: if_icmpne +29 -> 54
    //   28: aload 8
    //   30: iconst_0
    //   31: aaload
    //   32: ldc 137
    //   34: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifne +17 -> 54
    //   40: aload 8
    //   42: aload 8
    //   44: arraylength
    //   45: anewarray 122	java/lang/String
    //   48: invokestatic 146	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   51: ifeq +10 -> 61
    //   54: ldc 133
    //   56: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aconst_null
    //   60: areturn
    //   61: new 101	java/io/File
    //   64: dup
    //   65: aload 8
    //   67: iconst_0
    //   68: aaload
    //   69: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: aload 5
    //   76: invokevirtual 111	java/io/File:exists	()Z
    //   79: ifeq +13 -> 92
    //   82: aload 5
    //   84: invokevirtual 150	java/io/File:length	()J
    //   87: lconst_0
    //   88: lcmp
    //   89: ifne +10 -> 99
    //   92: ldc 133
    //   94: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aconst_null
    //   98: areturn
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 70	com/tencent/tencentmap/mapsdk/a/bc:a	()I
    //   104: aload_1
    //   105: invokevirtual 72	com/tencent/tencentmap/mapsdk/a/bc:b	()I
    //   108: invokespecial 152	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(II)I
    //   111: istore_2
    //   112: iload_2
    //   113: ifge +10 -> 123
    //   116: ldc 133
    //   118: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: iconst_4
    //   124: newarray byte
    //   126: astore 7
    //   128: aload_0
    //   129: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   132: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   135: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   138: new 163	java/io/RandomAccessFile
    //   141: dup
    //   142: aload 5
    //   144: ldc 165
    //   146: invokespecial 168	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   149: astore 5
    //   151: iload_2
    //   152: iconst_4
    //   153: imul
    //   154: i2l
    //   155: lstore_3
    //   156: aload 5
    //   158: lload_3
    //   159: invokevirtual 172	java/io/RandomAccessFile:seek	(J)V
    //   162: aload 5
    //   164: aload 7
    //   166: iconst_0
    //   167: iconst_4
    //   168: invokevirtual 176	java/io/RandomAccessFile:read	([BII)I
    //   171: pop
    //   172: aload_0
    //   173: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   176: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   179: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   182: aload 5
    //   184: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   187: aload_0
    //   188: aload 7
    //   190: invokespecial 186	com/tencent/tencentmap/mapsdk/maps/a/ni:a	([B)V
    //   193: aload_0
    //   194: aload 7
    //   196: invokespecial 188	com/tencent/tencentmap/mapsdk/maps/a/ni:b	([B)I
    //   199: istore_2
    //   200: iload_2
    //   201: ifge +62 -> 263
    //   204: ldc 133
    //   206: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore 5
    //   215: aload_0
    //   216: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   219: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   222: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   225: aload 5
    //   227: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   230: ldc 133
    //   232: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 5
    //   241: aload_0
    //   242: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   245: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   248: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   251: aload 5
    //   253: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   256: ldc 133
    //   258: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_1
    //   262: athrow
    //   263: new 101	java/io/File
    //   266: dup
    //   267: aload 8
    //   269: iconst_1
    //   270: aaload
    //   271: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   274: astore 5
    //   276: aload 5
    //   278: invokevirtual 111	java/io/File:exists	()Z
    //   281: ifne +10 -> 291
    //   284: ldc 133
    //   286: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aconst_null
    //   290: areturn
    //   291: aload_0
    //   292: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   295: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   298: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   301: new 163	java/io/RandomAccessFile
    //   304: dup
    //   305: aload 5
    //   307: ldc 165
    //   309: invokespecial 168	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   312: astore 5
    //   314: iload_2
    //   315: i2l
    //   316: lstore_3
    //   317: aload 5
    //   319: lload_3
    //   320: invokevirtual 172	java/io/RandomAccessFile:seek	(J)V
    //   323: aload 5
    //   325: aload 7
    //   327: iconst_0
    //   328: iconst_4
    //   329: invokevirtual 176	java/io/RandomAccessFile:read	([BII)I
    //   332: pop
    //   333: aload_0
    //   334: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   337: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   340: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   343: aload_0
    //   344: aload 7
    //   346: invokespecial 186	com/tencent/tencentmap/mapsdk/maps/a/ni:a	([B)V
    //   349: aload_0
    //   350: aload 7
    //   352: invokespecial 188	com/tencent/tencentmap/mapsdk/maps/a/ni:b	([B)I
    //   355: istore_2
    //   356: iload_2
    //   357: ifgt +57 -> 414
    //   360: aload 5
    //   362: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   365: ldc 133
    //   367: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aconst_null
    //   371: areturn
    //   372: astore_1
    //   373: aconst_null
    //   374: astore_1
    //   375: aload_1
    //   376: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   379: aload_0
    //   380: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   383: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   386: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   389: ldc 133
    //   391: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aconst_null
    //   395: areturn
    //   396: astore_1
    //   397: aload_0
    //   398: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   401: invokevirtual 156	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   404: invokevirtual 179	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   407: ldc 133
    //   409: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_1
    //   413: athrow
    //   414: iload_2
    //   415: newarray byte
    //   417: astore 7
    //   419: aload 5
    //   421: aload 7
    //   423: iconst_0
    //   424: iload_2
    //   425: invokevirtual 176	java/io/RandomAccessFile:read	([BII)I
    //   428: pop
    //   429: aload 5
    //   431: invokevirtual 191	java/io/RandomAccessFile:close	()V
    //   434: aload_1
    //   435: invokevirtual 194	com/tencent/tencentmap/mapsdk/a/bc:f	()Landroid/graphics/BitmapFactory$Options;
    //   438: astore 5
    //   440: aload 5
    //   442: ifnull +54 -> 496
    //   445: aload 7
    //   447: iconst_0
    //   448: iload_2
    //   449: aload 5
    //   451: invokestatic 200	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   454: astore 5
    //   456: aload_1
    //   457: aload 5
    //   459: invokevirtual 203	com/tencent/tencentmap/mapsdk/a/bc:a	(Landroid/graphics/Bitmap;)V
    //   462: ldc 133
    //   464: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: aload 5
    //   469: areturn
    //   470: astore_1
    //   471: aload 5
    //   473: invokevirtual 191	java/io/RandomAccessFile:close	()V
    //   476: ldc 133
    //   478: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: aconst_null
    //   482: areturn
    //   483: astore_1
    //   484: aload 5
    //   486: invokevirtual 191	java/io/RandomAccessFile:close	()V
    //   489: ldc 133
    //   491: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   494: aload_1
    //   495: athrow
    //   496: aload 7
    //   498: iconst_0
    //   499: iload_2
    //   500: invokestatic 206	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   503: astore 5
    //   505: goto -49 -> 456
    //   508: astore 5
    //   510: goto -76 -> 434
    //   513: astore_1
    //   514: goto -38 -> 476
    //   517: astore 5
    //   519: goto -30 -> 489
    //   522: astore 5
    //   524: aload 6
    //   526: astore 5
    //   528: goto -72 -> 456
    //   531: astore_1
    //   532: aload 5
    //   534: astore_1
    //   535: goto -160 -> 375
    //   538: astore_1
    //   539: goto -298 -> 241
    //   542: astore_1
    //   543: goto -328 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	ni
    //   0	546	1	parambc	bc
    //   111	389	2	i	int
    //   155	165	3	l	long
    //   72	432	5	localObject1	Object
    //   508	1	5	localException1	java.lang.Exception
    //   517	1	5	localException2	java.lang.Exception
    //   522	1	5	localException3	java.lang.Exception
    //   526	7	5	localObject2	Object
    //   1	524	6	localObject3	Object
    //   126	371	7	arrayOfByte	byte[]
    //   14	254	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   138	151	211	java/lang/Exception
    //   138	151	237	finally
    //   291	314	372	java/lang/Exception
    //   291	314	396	finally
    //   317	333	396	finally
    //   375	379	396	finally
    //   419	429	470	java/io/IOException
    //   419	429	483	finally
    //   429	434	508	java/lang/Exception
    //   471	476	513	java/lang/Exception
    //   484	489	517	java/lang/Exception
    //   434	440	522	java/lang/Exception
    //   445	456	522	java/lang/Exception
    //   496	505	522	java/lang/Exception
    //   317	333	531	java/lang/Exception
    //   156	172	538	finally
    //   156	172	542	java/lang/Exception
  }
  
  public String a()
  {
    AppMethodBeat.i(149477);
    if (this.b == null)
    {
      AppMethodBeat.o(149477);
      return null;
    }
    String str = p.b(this.b) + "/" + e + "/" + lm.a() + "/";
    AppMethodBeat.o(149477);
    return str;
  }
  
  public String a(cy paramcy)
  {
    AppMethodBeat.i(149476);
    if (this.b == null)
    {
      AppMethodBeat.o(149476);
      return null;
    }
    Object localObject = p.a(this.b).a().getPath() + d;
    String str = (String)localObject + "/" + nn.b() + "/" + nn.a() + "/" + nn.c() + "/";
    localObject = str;
    if (paramcy != null) {
      localObject = str + paramcy.name() + "/";
    }
    AppMethodBeat.o(149476);
    return localObject;
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(149475);
    String str = null;
    if (paramInt == 0) {
      str = p.a(this.b).a().getPath() + d;
    }
    if (paramInt == 1) {
      str = p.b(this.b) + e;
    }
    boolean bool = t.c(str);
    AppMethodBeat.o(149475);
    return bool;
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, bc parambc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc 242
    //   10: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_1
    //   14: ifnonnull +17 -> 31
    //   17: ldc 242
    //   19: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iload 5
    //   24: istore 4
    //   26: aload_0
    //   27: monitorexit
    //   28: iload 4
    //   30: ireturn
    //   31: aload_1
    //   32: arraylength
    //   33: istore_3
    //   34: iload_3
    //   35: ifgt +20 -> 55
    //   38: ldc 242
    //   40: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload 5
    //   45: istore 4
    //   47: goto -21 -> 26
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: aload_2
    //   57: iconst_0
    //   58: invokespecial 135	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(Lcom/tencent/tencentmap/mapsdk/a/bc;Z)[Ljava/lang/String;
    //   61: astore 12
    //   63: aload 12
    //   65: ifnull +36 -> 101
    //   68: aload 12
    //   70: arraylength
    //   71: iconst_2
    //   72: if_icmpne +29 -> 101
    //   75: aload 12
    //   77: iconst_0
    //   78: aaload
    //   79: ldc 137
    //   81: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifne +17 -> 101
    //   87: aload 12
    //   89: aload 12
    //   91: arraylength
    //   92: anewarray 122	java/lang/String
    //   95: invokestatic 146	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   98: ifeq +15 -> 113
    //   101: ldc 242
    //   103: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iload 5
    //   108: istore 4
    //   110: goto -84 -> 26
    //   113: new 101	java/io/File
    //   116: dup
    //   117: aload 12
    //   119: iconst_1
    //   120: aaload
    //   121: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   124: astore 10
    //   126: aload 10
    //   128: invokevirtual 111	java/io/File:exists	()Z
    //   131: istore 4
    //   133: iload 4
    //   135: ifne +35 -> 170
    //   138: aload 10
    //   140: invokevirtual 245	java/io/File:createNewFile	()Z
    //   143: istore 4
    //   145: iload 4
    //   147: ifne +23 -> 170
    //   150: ldc 242
    //   152: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: iload 5
    //   157: istore 4
    //   159: goto -133 -> 26
    //   162: astore 13
    //   164: iconst_0
    //   165: istore 4
    //   167: goto -22 -> 145
    //   170: new 163	java/io/RandomAccessFile
    //   173: dup
    //   174: aload 10
    //   176: ldc 247
    //   178: invokespecial 168	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   181: astore 10
    //   183: aload 10
    //   185: ifnonnull +15 -> 200
    //   188: ldc 242
    //   190: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: iload 5
    //   195: istore 4
    //   197: goto -171 -> 26
    //   200: aload_0
    //   201: iload_3
    //   202: invokespecial 249	com/tencent/tencentmap/mapsdk/maps/a/ni:b	(I)[B
    //   205: astore 13
    //   207: aload_0
    //   208: aload 13
    //   210: invokespecial 186	com/tencent/tencentmap/mapsdk/maps/a/ni:a	([B)V
    //   213: aload_0
    //   214: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   217: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   220: invokevirtual 256	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   223: aload 10
    //   225: invokevirtual 257	java/io/RandomAccessFile:length	()J
    //   228: lstore 6
    //   230: aload 10
    //   232: lload 6
    //   234: invokevirtual 172	java/io/RandomAccessFile:seek	(J)V
    //   237: aload 10
    //   239: aload 13
    //   241: invokevirtual 260	java/io/RandomAccessFile:write	([B)V
    //   244: aload 10
    //   246: aload_1
    //   247: invokevirtual 260	java/io/RandomAccessFile:write	([B)V
    //   250: aload 10
    //   252: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   255: aload_0
    //   256: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   259: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   262: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   265: new 101	java/io/File
    //   268: dup
    //   269: aload 12
    //   271: iconst_0
    //   272: aaload
    //   273: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 111	java/io/File:exists	()Z
    //   281: istore 4
    //   283: iload 4
    //   285: ifne +75 -> 360
    //   288: aload_1
    //   289: invokevirtual 245	java/io/File:createNewFile	()Z
    //   292: istore 4
    //   294: iload 4
    //   296: ifne +64 -> 360
    //   299: ldc 242
    //   301: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: iload 5
    //   306: istore 4
    //   308: goto -282 -> 26
    //   311: aload 10
    //   313: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   316: aload_0
    //   317: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   320: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   323: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   326: goto -61 -> 265
    //   329: astore_1
    //   330: aload 10
    //   332: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   335: aload_0
    //   336: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   339: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   342: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   345: ldc 242
    //   347: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_1
    //   351: athrow
    //   352: astore 10
    //   354: iconst_0
    //   355: istore 4
    //   357: goto -63 -> 294
    //   360: new 163	java/io/RandomAccessFile
    //   363: dup
    //   364: aload_1
    //   365: ldc 247
    //   367: invokespecial 168	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   370: astore_1
    //   371: aload_1
    //   372: ifnonnull +15 -> 387
    //   375: ldc 242
    //   377: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: iload 5
    //   382: istore 4
    //   384: goto -358 -> 26
    //   387: aload_1
    //   388: invokevirtual 257	java/io/RandomAccessFile:length	()J
    //   391: lstore 8
    //   393: lload 8
    //   395: lconst_0
    //   396: lcmp
    //   397: ifne +42 -> 439
    //   400: ldc_w 262
    //   403: newarray byte
    //   405: astore 10
    //   407: aload 10
    //   409: iconst_m1
    //   410: invokestatic 266	java/util/Arrays:fill	([BB)V
    //   413: aload_0
    //   414: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   417: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   420: invokevirtual 256	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   423: aload_1
    //   424: aload 10
    //   426: invokevirtual 260	java/io/RandomAccessFile:write	([B)V
    //   429: aload_0
    //   430: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   433: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   436: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   439: aload_0
    //   440: aload_2
    //   441: invokevirtual 70	com/tencent/tencentmap/mapsdk/a/bc:a	()I
    //   444: aload_2
    //   445: invokevirtual 72	com/tencent/tencentmap/mapsdk/a/bc:b	()I
    //   448: invokespecial 152	com/tencent/tencentmap/mapsdk/maps/a/ni:a	(II)I
    //   451: istore_3
    //   452: iload_3
    //   453: ifge +52 -> 505
    //   456: aload_1
    //   457: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   460: ldc 242
    //   462: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: iload 5
    //   467: istore 4
    //   469: goto -443 -> 26
    //   472: astore 10
    //   474: aload_0
    //   475: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   478: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   481: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   484: goto -45 -> 439
    //   487: astore_1
    //   488: aload_0
    //   489: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   492: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   495: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   498: ldc 242
    //   500: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: aload_1
    //   504: athrow
    //   505: iload_3
    //   506: iconst_4
    //   507: imul
    //   508: i2l
    //   509: lstore 8
    //   511: aload_1
    //   512: lload 8
    //   514: invokevirtual 172	java/io/RandomAccessFile:seek	(J)V
    //   517: lload 6
    //   519: l2i
    //   520: istore_3
    //   521: aload_0
    //   522: iload_3
    //   523: invokespecial 249	com/tencent/tencentmap/mapsdk/maps/a/ni:b	(I)[B
    //   526: astore_2
    //   527: aload_0
    //   528: aload_2
    //   529: invokespecial 186	com/tencent/tencentmap/mapsdk/maps/a/ni:a	([B)V
    //   532: aload_0
    //   533: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   536: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   539: invokevirtual 256	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   542: aload_1
    //   543: aload_2
    //   544: invokevirtual 260	java/io/RandomAccessFile:write	([B)V
    //   547: aload_1
    //   548: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   551: aload_0
    //   552: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   555: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   558: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   561: ldc 242
    //   563: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: iconst_1
    //   567: istore 4
    //   569: goto -543 -> 26
    //   572: astore_2
    //   573: aload_1
    //   574: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   577: aload_0
    //   578: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   581: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   584: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   587: goto -26 -> 561
    //   590: astore_2
    //   591: aload_1
    //   592: invokestatic 184	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   595: aload_0
    //   596: getfield 42	com/tencent/tencentmap/mapsdk/maps/a/ni:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   599: invokevirtual 253	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   602: invokevirtual 261	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   605: ldc 242
    //   607: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   610: aload_2
    //   611: athrow
    //   612: astore_2
    //   613: goto -96 -> 517
    //   616: astore_1
    //   617: aload 11
    //   619: astore_1
    //   620: goto -249 -> 371
    //   623: astore_1
    //   624: goto -313 -> 311
    //   627: astore 10
    //   629: aconst_null
    //   630: astore 10
    //   632: goto -449 -> 183
    //   635: astore_1
    //   636: lconst_0
    //   637: lstore 6
    //   639: goto -328 -> 311
    //   642: astore 10
    //   644: lconst_0
    //   645: lstore 8
    //   647: goto -254 -> 393
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	ni
    //   0	650	1	paramArrayOfByte	byte[]
    //   0	650	2	parambc	bc
    //   33	490	3	i	int
    //   24	544	4	bool1	boolean
    //   4	462	5	bool2	boolean
    //   228	410	6	l1	long
    //   391	255	8	l2	long
    //   124	207	10	localObject1	Object
    //   352	1	10	localException1	java.lang.Exception
    //   405	20	10	arrayOfByte1	byte[]
    //   472	1	10	localException2	java.lang.Exception
    //   627	1	10	localException3	java.lang.Exception
    //   630	1	10	localObject2	Object
    //   642	1	10	localException4	java.lang.Exception
    //   1	617	11	localObject3	Object
    //   61	209	12	arrayOfString	String[]
    //   162	1	13	localException5	java.lang.Exception
    //   205	35	13	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	13	50	finally
    //   17	22	50	finally
    //   31	34	50	finally
    //   38	43	50	finally
    //   55	63	50	finally
    //   68	101	50	finally
    //   101	106	50	finally
    //   113	133	50	finally
    //   138	145	50	finally
    //   150	155	50	finally
    //   170	183	50	finally
    //   188	193	50	finally
    //   200	223	50	finally
    //   250	265	50	finally
    //   265	283	50	finally
    //   288	294	50	finally
    //   299	304	50	finally
    //   311	326	50	finally
    //   330	352	50	finally
    //   360	371	50	finally
    //   375	380	50	finally
    //   387	393	50	finally
    //   400	423	50	finally
    //   429	439	50	finally
    //   439	452	50	finally
    //   456	465	50	finally
    //   474	484	50	finally
    //   488	505	50	finally
    //   511	517	50	finally
    //   521	542	50	finally
    //   547	561	50	finally
    //   561	566	50	finally
    //   573	587	50	finally
    //   591	612	50	finally
    //   138	145	162	java/lang/Exception
    //   223	230	329	finally
    //   230	250	329	finally
    //   288	294	352	java/lang/Exception
    //   423	429	472	java/lang/Exception
    //   423	429	487	finally
    //   542	547	572	java/lang/Exception
    //   542	547	590	finally
    //   511	517	612	java/lang/Exception
    //   360	371	616	java/lang/Exception
    //   230	250	623	java/lang/Exception
    //   170	183	627	java/lang/Exception
    //   223	230	635	java/lang/Exception
    //   387	393	642	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ni
 * JD-Core Version:    0.7.0.1
 */