package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class mw
{
  private static volatile mw a;
  private static String d = "/rastermap/world";
  private static String e = "/tencentmapsdk/rastermap/handdraw";
  private Context b;
  private ReentrantReadWriteLock c = new ReentrantReadWriteLock();
  private final int f = 128;
  
  private mw(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128 + paramInt2 % 128;
  }
  
  public static mw a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new mw(paramContext.getApplicationContext());
      }
      return a;
    }
    finally {}
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
  
  private String[] a(oi paramoi, boolean paramBoolean)
  {
    int i = paramoi.a() / 128;
    int j = paramoi.b() / 128;
    int k = i / 10;
    int m = j / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramoi.e();
    switch (paramoi.d())
    {
    default: 
      localObject = null;
    }
    while (localObject == null)
    {
      return null;
      localObject = a((qb)localObject);
      continue;
      localObject = a();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("glGrid");
    localStringBuilder.append("/");
    localStringBuilder.append(paramoi.c());
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
    localStringBuilder.append(paramoi.c());
    localStringBuilder.append("_");
    localStringBuilder.append(i);
    localStringBuilder.append("_");
    localStringBuilder.append(j);
    return new String[] { localStringBuilder.toString() + ".idx", localStringBuilder.toString() + ".dat" };
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
  public android.graphics.Bitmap a(oi paramoi)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: iconst_1
    //   6: invokespecial 122	com/tencent/tencentmap/mapsdk/a/mw:a	(Lcom/tencent/tencentmap/mapsdk/a/oi;Z)[Ljava/lang/String;
    //   9: astore 8
    //   11: aload 8
    //   13: ifnull +36 -> 49
    //   16: aload 8
    //   18: arraylength
    //   19: iconst_2
    //   20: if_icmpne +29 -> 49
    //   23: aload 8
    //   25: iconst_0
    //   26: aaload
    //   27: ldc 124
    //   29: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +17 -> 49
    //   35: aload 8
    //   37: aload 8
    //   39: arraylength
    //   40: anewarray 106	java/lang/String
    //   43: invokestatic 133	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   46: ifeq +5 -> 51
    //   49: aconst_null
    //   50: areturn
    //   51: new 89	java/io/File
    //   54: dup
    //   55: aload 8
    //   57: iconst_0
    //   58: aaload
    //   59: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 99	java/io/File:exists	()Z
    //   69: ifeq -20 -> 49
    //   72: aload 5
    //   74: invokevirtual 137	java/io/File:length	()J
    //   77: lconst_0
    //   78: lcmp
    //   79: ifeq -30 -> 49
    //   82: aload_0
    //   83: aload_1
    //   84: invokevirtual 58	com/tencent/tencentmap/mapsdk/a/oi:a	()I
    //   87: aload_1
    //   88: invokevirtual 60	com/tencent/tencentmap/mapsdk/a/oi:b	()I
    //   91: invokespecial 139	com/tencent/tencentmap/mapsdk/a/mw:a	(II)I
    //   94: istore_2
    //   95: iload_2
    //   96: iflt -47 -> 49
    //   99: iconst_4
    //   100: newarray byte
    //   102: astore 7
    //   104: aload_0
    //   105: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   108: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   111: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   114: new 150	java/io/RandomAccessFile
    //   117: dup
    //   118: aload 5
    //   120: ldc 152
    //   122: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   125: astore 5
    //   127: iload_2
    //   128: iconst_4
    //   129: imul
    //   130: i2l
    //   131: lstore_3
    //   132: aload 5
    //   134: lload_3
    //   135: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   138: aload 5
    //   140: aload 7
    //   142: iconst_0
    //   143: iconst_4
    //   144: invokevirtual 163	java/io/RandomAccessFile:read	([BII)I
    //   147: pop
    //   148: aload_0
    //   149: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   152: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   155: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   158: aload 5
    //   160: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   163: aload_0
    //   164: aload 7
    //   166: invokespecial 173	com/tencent/tencentmap/mapsdk/a/mw:a	([B)V
    //   169: aload_0
    //   170: aload 7
    //   172: invokespecial 175	com/tencent/tencentmap/mapsdk/a/mw:b	([B)I
    //   175: istore_2
    //   176: iload_2
    //   177: iflt -128 -> 49
    //   180: new 89	java/io/File
    //   183: dup
    //   184: aload 8
    //   186: iconst_1
    //   187: aaload
    //   188: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   191: astore 5
    //   193: aload 5
    //   195: invokevirtual 99	java/io/File:exists	()Z
    //   198: ifeq -149 -> 49
    //   201: aload_0
    //   202: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   205: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   208: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   211: new 150	java/io/RandomAccessFile
    //   214: dup
    //   215: aload 5
    //   217: ldc 152
    //   219: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   222: astore 5
    //   224: iload_2
    //   225: i2l
    //   226: lstore_3
    //   227: aload 5
    //   229: lload_3
    //   230: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   233: aload 5
    //   235: aload 7
    //   237: iconst_0
    //   238: iconst_4
    //   239: invokevirtual 163	java/io/RandomAccessFile:read	([BII)I
    //   242: pop
    //   243: aload_0
    //   244: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   247: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   250: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   253: aload_0
    //   254: aload 7
    //   256: invokespecial 173	com/tencent/tencentmap/mapsdk/a/mw:a	([B)V
    //   259: aload_0
    //   260: aload 7
    //   262: invokespecial 175	com/tencent/tencentmap/mapsdk/a/mw:b	([B)I
    //   265: istore_2
    //   266: iload_2
    //   267: ifgt +84 -> 351
    //   270: aload 5
    //   272: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   275: aconst_null
    //   276: areturn
    //   277: astore_1
    //   278: aconst_null
    //   279: astore 5
    //   281: aload_0
    //   282: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   285: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   288: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   291: aload 5
    //   293: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_1
    //   299: aconst_null
    //   300: astore 5
    //   302: aload_0
    //   303: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   306: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   309: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   312: aload 5
    //   314: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   317: aload_1
    //   318: athrow
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_1
    //   322: aload_1
    //   323: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   326: aload_0
    //   327: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   330: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   333: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   336: aconst_null
    //   337: areturn
    //   338: astore_1
    //   339: aload_0
    //   340: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   343: invokevirtual 143	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   346: invokevirtual 166	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   349: aload_1
    //   350: athrow
    //   351: iload_2
    //   352: newarray byte
    //   354: astore 7
    //   356: aload 5
    //   358: aload 7
    //   360: iconst_0
    //   361: iload_2
    //   362: invokevirtual 163	java/io/RandomAccessFile:read	([BII)I
    //   365: pop
    //   366: aload 5
    //   368: invokevirtual 178	java/io/RandomAccessFile:close	()V
    //   371: aload 7
    //   373: iconst_0
    //   374: iload_2
    //   375: invokestatic 184	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   378: astore 5
    //   380: aload_1
    //   381: aload 5
    //   383: invokevirtual 187	com/tencent/tencentmap/mapsdk/a/oi:a	(Landroid/graphics/Bitmap;)V
    //   386: aload 5
    //   388: areturn
    //   389: astore_1
    //   390: aload 5
    //   392: invokevirtual 178	java/io/RandomAccessFile:close	()V
    //   395: aconst_null
    //   396: areturn
    //   397: astore_1
    //   398: aconst_null
    //   399: areturn
    //   400: astore_1
    //   401: aload 5
    //   403: invokevirtual 178	java/io/RandomAccessFile:close	()V
    //   406: aload_1
    //   407: athrow
    //   408: astore 5
    //   410: goto -39 -> 371
    //   413: astore 5
    //   415: goto -9 -> 406
    //   418: astore 5
    //   420: aload 6
    //   422: astore 5
    //   424: goto -44 -> 380
    //   427: astore_1
    //   428: aload 5
    //   430: astore_1
    //   431: goto -109 -> 322
    //   434: astore_1
    //   435: goto -133 -> 302
    //   438: astore_1
    //   439: goto -158 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	mw
    //   0	442	1	paramoi	oi
    //   94	281	2	i	int
    //   131	99	3	l	long
    //   62	340	5	localObject1	Object
    //   408	1	5	localException1	java.lang.Exception
    //   413	1	5	localException2	java.lang.Exception
    //   418	1	5	localException3	java.lang.Exception
    //   422	7	5	localObject2	Object
    //   1	420	6	localObject3	Object
    //   102	270	7	arrayOfByte	byte[]
    //   9	176	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   114	127	277	java/lang/Exception
    //   114	127	298	finally
    //   201	224	319	java/lang/Exception
    //   201	224	338	finally
    //   227	243	338	finally
    //   322	326	338	finally
    //   356	366	389	java/io/IOException
    //   390	395	397	java/lang/Exception
    //   356	366	400	finally
    //   366	371	408	java/lang/Exception
    //   401	406	413	java/lang/Exception
    //   371	380	418	java/lang/Exception
    //   227	243	427	java/lang/Exception
    //   132	148	434	finally
    //   132	148	438	java/lang/Exception
  }
  
  public String a()
  {
    if (this.b == null) {
      return null;
    }
    return r.b(this.b) + "/" + e + "/" + mh.a() + "/";
  }
  
  public String a(qb paramqb)
  {
    Object localObject;
    if (this.b == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      localObject = r.a(this.b).e().getPath() + d;
      str = (String)localObject + "/" + nb.b() + "/" + nb.a() + "/" + nb.c() + "/";
      localObject = str;
    } while (paramqb == null);
    return str + paramqb.name() + "/";
  }
  
  public boolean a(int paramInt)
  {
    String str = null;
    if (paramInt == 0) {
      str = r.a(this.b).e().getPath() + d;
    }
    if (paramInt == 1) {
      str = r.b(this.b) + e;
    }
    return v.c(str);
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, oi paramoi)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: iload 6
    //   14: istore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 4
    //   20: ireturn
    //   21: aload_1
    //   22: arraylength
    //   23: istore_3
    //   24: iload 6
    //   26: istore 4
    //   28: iload_3
    //   29: ifle -13 -> 16
    //   32: aload_0
    //   33: aload_2
    //   34: iconst_0
    //   35: invokespecial 122	com/tencent/tencentmap/mapsdk/a/mw:a	(Lcom/tencent/tencentmap/mapsdk/a/oi;Z)[Ljava/lang/String;
    //   38: astore 13
    //   40: iload 6
    //   42: istore 4
    //   44: aload 13
    //   46: ifnull -30 -> 16
    //   49: iload 6
    //   51: istore 4
    //   53: aload 13
    //   55: arraylength
    //   56: iconst_2
    //   57: if_icmpne -41 -> 16
    //   60: iload 6
    //   62: istore 4
    //   64: aload 13
    //   66: iconst_0
    //   67: aaload
    //   68: ldc 124
    //   70: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifne -57 -> 16
    //   76: iload 6
    //   78: istore 4
    //   80: aload 13
    //   82: aload 13
    //   84: arraylength
    //   85: anewarray 106	java/lang/String
    //   88: invokestatic 133	java/util/Arrays:equals	([Ljava/lang/Object;[Ljava/lang/Object;)Z
    //   91: ifne -75 -> 16
    //   94: new 89	java/io/File
    //   97: dup
    //   98: aload 13
    //   100: iconst_1
    //   101: aaload
    //   102: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore 11
    //   107: aload 11
    //   109: invokevirtual 99	java/io/File:exists	()Z
    //   112: istore 4
    //   114: iload 4
    //   116: ifne +19 -> 135
    //   119: aload 11
    //   121: invokevirtual 222	java/io/File:createNewFile	()Z
    //   124: istore 5
    //   126: iload 6
    //   128: istore 4
    //   130: iload 5
    //   132: ifeq -116 -> 16
    //   135: new 150	java/io/RandomAccessFile
    //   138: dup
    //   139: aload 11
    //   141: ldc 224
    //   143: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   146: astore 11
    //   148: iload 6
    //   150: istore 4
    //   152: aload 11
    //   154: ifnull -138 -> 16
    //   157: aload_0
    //   158: iload_3
    //   159: invokespecial 226	com/tencent/tencentmap/mapsdk/a/mw:b	(I)[B
    //   162: astore 14
    //   164: aload_0
    //   165: aload 14
    //   167: invokespecial 173	com/tencent/tencentmap/mapsdk/a/mw:a	([B)V
    //   170: aload_0
    //   171: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   174: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   177: invokevirtual 233	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   180: aload 11
    //   182: invokevirtual 234	java/io/RandomAccessFile:length	()J
    //   185: lstore 7
    //   187: aload 11
    //   189: lload 7
    //   191: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   194: aload 11
    //   196: aload 14
    //   198: invokevirtual 237	java/io/RandomAccessFile:write	([B)V
    //   201: aload 11
    //   203: aload_1
    //   204: invokevirtual 237	java/io/RandomAccessFile:write	([B)V
    //   207: aload 11
    //   209: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   212: aload_0
    //   213: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   216: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   219: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   222: new 89	java/io/File
    //   225: dup
    //   226: aload 13
    //   228: iconst_0
    //   229: aaload
    //   230: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 99	java/io/File:exists	()Z
    //   238: istore 4
    //   240: iload 4
    //   242: ifne +18 -> 260
    //   245: aload_1
    //   246: invokevirtual 222	java/io/File:createNewFile	()Z
    //   249: istore 5
    //   251: iload 6
    //   253: istore 4
    //   255: iload 5
    //   257: ifeq -241 -> 16
    //   260: new 150	java/io/RandomAccessFile
    //   263: dup
    //   264: aload_1
    //   265: ldc 224
    //   267: invokespecial 155	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   270: astore_1
    //   271: iload 6
    //   273: istore 4
    //   275: aload_1
    //   276: ifnull -260 -> 16
    //   279: aload_1
    //   280: invokevirtual 234	java/io/RandomAccessFile:length	()J
    //   283: lstore 9
    //   285: lload 9
    //   287: lconst_0
    //   288: lcmp
    //   289: ifne +41 -> 330
    //   292: ldc 239
    //   294: newarray byte
    //   296: astore 11
    //   298: aload 11
    //   300: iconst_m1
    //   301: invokestatic 243	java/util/Arrays:fill	([BB)V
    //   304: aload_0
    //   305: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   308: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   311: invokevirtual 233	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   314: aload_1
    //   315: aload 11
    //   317: invokevirtual 237	java/io/RandomAccessFile:write	([B)V
    //   320: aload_0
    //   321: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   324: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   327: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   330: aload_0
    //   331: aload_2
    //   332: invokevirtual 58	com/tencent/tencentmap/mapsdk/a/oi:a	()I
    //   335: aload_2
    //   336: invokevirtual 60	com/tencent/tencentmap/mapsdk/a/oi:b	()I
    //   339: invokespecial 139	com/tencent/tencentmap/mapsdk/a/mw:a	(II)I
    //   342: istore_3
    //   343: iload_3
    //   344: ifge +103 -> 447
    //   347: aload_1
    //   348: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   351: iload 6
    //   353: istore 4
    //   355: goto -339 -> 16
    //   358: astore_1
    //   359: aload_0
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    //   363: astore 14
    //   365: iconst_0
    //   366: istore 5
    //   368: goto -242 -> 126
    //   371: astore 11
    //   373: aconst_null
    //   374: astore 11
    //   376: goto -228 -> 148
    //   379: astore_1
    //   380: lconst_0
    //   381: lstore 7
    //   383: aload 11
    //   385: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   388: aload_0
    //   389: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   392: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   395: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   398: goto -176 -> 222
    //   401: astore_1
    //   402: aload 11
    //   404: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   407: aload_0
    //   408: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   411: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   414: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   417: aload_1
    //   418: athrow
    //   419: astore 11
    //   421: aload_0
    //   422: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   425: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   428: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   431: goto -101 -> 330
    //   434: astore_1
    //   435: aload_0
    //   436: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   439: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   442: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   445: aload_1
    //   446: athrow
    //   447: iload_3
    //   448: iconst_4
    //   449: imul
    //   450: i2l
    //   451: lstore 9
    //   453: aload_1
    //   454: lload 9
    //   456: invokevirtual 159	java/io/RandomAccessFile:seek	(J)V
    //   459: lload 7
    //   461: l2i
    //   462: istore_3
    //   463: aload_0
    //   464: iload_3
    //   465: invokespecial 226	com/tencent/tencentmap/mapsdk/a/mw:b	(I)[B
    //   468: astore_2
    //   469: aload_0
    //   470: aload_2
    //   471: invokespecial 173	com/tencent/tencentmap/mapsdk/a/mw:a	([B)V
    //   474: aload_0
    //   475: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   478: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   481: invokevirtual 233	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   484: aload_1
    //   485: aload_2
    //   486: invokevirtual 237	java/io/RandomAccessFile:write	([B)V
    //   489: aload_1
    //   490: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   493: aload_0
    //   494: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   497: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   500: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   503: goto +69 -> 572
    //   506: astore_2
    //   507: aload_1
    //   508: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   511: aload_0
    //   512: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   515: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   518: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   521: goto +51 -> 572
    //   524: astore_2
    //   525: aload_1
    //   526: invokestatic 171	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   529: aload_0
    //   530: getfield 35	com/tencent/tencentmap/mapsdk/a/mw:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   533: invokevirtual 230	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   536: invokevirtual 238	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   539: aload_2
    //   540: athrow
    //   541: astore_2
    //   542: goto -83 -> 459
    //   545: astore_1
    //   546: aload 12
    //   548: astore_1
    //   549: goto -278 -> 271
    //   552: astore_1
    //   553: goto -170 -> 383
    //   556: astore 11
    //   558: iconst_0
    //   559: istore 5
    //   561: goto -310 -> 251
    //   564: astore 11
    //   566: lconst_0
    //   567: lstore 9
    //   569: goto -284 -> 285
    //   572: iconst_1
    //   573: istore 4
    //   575: goto -559 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	mw
    //   0	578	1	paramArrayOfByte	byte[]
    //   0	578	2	paramoi	oi
    //   23	442	3	i	int
    //   14	560	4	bool1	boolean
    //   124	436	5	bool2	boolean
    //   4	348	6	bool3	boolean
    //   185	275	7	l1	long
    //   283	285	9	l2	long
    //   105	211	11	localObject1	Object
    //   371	1	11	localException1	java.lang.Exception
    //   374	29	11	localCloseable	java.io.Closeable
    //   419	1	11	localException2	java.lang.Exception
    //   556	1	11	localException3	java.lang.Exception
    //   564	1	11	localException4	java.lang.Exception
    //   1	546	12	localObject2	Object
    //   38	189	13	arrayOfString	String[]
    //   162	35	14	arrayOfByte	byte[]
    //   363	1	14	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	24	358	finally
    //   32	40	358	finally
    //   53	60	358	finally
    //   64	76	358	finally
    //   80	114	358	finally
    //   119	126	358	finally
    //   135	148	358	finally
    //   157	180	358	finally
    //   207	222	358	finally
    //   222	240	358	finally
    //   245	251	358	finally
    //   260	271	358	finally
    //   279	285	358	finally
    //   292	314	358	finally
    //   320	330	358	finally
    //   330	343	358	finally
    //   347	351	358	finally
    //   383	398	358	finally
    //   402	419	358	finally
    //   421	431	358	finally
    //   435	447	358	finally
    //   453	459	358	finally
    //   463	484	358	finally
    //   489	503	358	finally
    //   507	521	358	finally
    //   525	541	358	finally
    //   119	126	363	java/lang/Exception
    //   135	148	371	java/lang/Exception
    //   180	187	379	java/lang/Exception
    //   180	187	401	finally
    //   187	207	401	finally
    //   314	320	419	java/lang/Exception
    //   314	320	434	finally
    //   484	489	506	java/lang/Exception
    //   484	489	524	finally
    //   453	459	541	java/lang/Exception
    //   260	271	545	java/lang/Exception
    //   187	207	552	java/lang/Exception
    //   245	251	556	java/lang/Exception
    //   279	285	564	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mw
 * JD-Core Version:    0.7.0.1
 */