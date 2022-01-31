package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public final class dy
  implements dx
{
  private static dy a = null;
  private SparseArray<dw> b = new SparseArray(5);
  private List<dr> c = new ArrayList(5);
  private dv d;
  private Context e = null;
  private boolean f = true;
  private boolean g = true;
  
  private dy(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null) {}
    for (this.e = localContext;; this.e = paramContext)
    {
      this.f = paramBoolean;
      this.d = dv.a(this.e);
      return;
    }
  }
  
  private static ct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = cm.a();
        if (localObject == null) {
          break label85;
        }
        int i = ((cm)localObject).h();
        paramArrayOfByte = e.b(paramArrayOfByte, ((cm)localObject).i(), i, ((cm)localObject).k());
        if (paramArrayOfByte != null)
        {
          localObject = new dd();
          ((dd)localObject).a(paramArrayOfByte);
          paramArrayOfByte = new ct();
          cy.b(" covert to ResponsePackage ", new Object[0]);
          paramArrayOfByte = (ct)((dd)localObject).b("detail", paramArrayOfByte);
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        cy.a(paramArrayOfByte);
      }
      return null;
      label85:
      paramArrayOfByte = null;
    }
  }
  
  public static dy a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new dy(paramContext, true);
        cy.h(" create uphandler up:true", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static dy a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new dy(paramContext, paramBoolean);
        cy.h(" create uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.f != paramBoolean)
      {
        a.f = paramBoolean;
        cy.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    dr[] arrayOfdr = c();
    if (arrayOfdr != null)
    {
      int j = arrayOfdr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfdr[i].a(paramInt1, paramInt2, 0L, 0L, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private static boolean a(SparseArray<dw> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (dw)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        cy.c(" no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      return true;
    }
    try
    {
      cy.b(" key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      cy.a(paramSparseArray);
      cy.d(" handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private static byte[] b(ds paramds)
  {
    if (paramds != null) {
      try
      {
        Object localObject1 = paramds.a();
        if (localObject1 != null)
        {
          cy.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((cs)localObject1).b, ((cs)localObject1).d, ((cs)localObject1).c, Integer.valueOf(((cs)localObject1).f) });
          Object localObject2 = new dd();
          ((dd)localObject2).a();
          ((dd)localObject2).b("test");
          ((dd)localObject2).a("test");
          ((dd)localObject2).a("detail", localObject1);
          localObject1 = ((dd)localObject2).b();
          localObject2 = cm.a();
          if (localObject2 != null)
          {
            int i = ((cm)localObject2).h();
            localObject1 = e.a((byte[])localObject1, ((cm)localObject2).i(), i, ((cm)localObject2).k());
            return localObject1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        cy.d(" parseSendDatas error", new Object[0]);
        cy.a(localThrowable);
        paramds.b();
      }
    }
    return null;
  }
  
  /* Error */
  private dr[] c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/tencentmap/mapsdk/a/dy:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 42	com/tencent/tencentmap/mapsdk/a/dy:c	Ljava/util/List;
    //   13: invokeinterface 219 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 42	com/tencent/tencentmap/mapsdk/a/dy:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 133	com/tencent/tencentmap/mapsdk/a/dr
    //   29: invokeinterface 223 2 0
    //   34: checkcast 225	[Lcom/tencent/tencentmap/mapsdk/a/dr;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	dy
    //   37	7	1	arrayOfdr	dr[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private dv d()
  {
    try
    {
      dv localdv = this.d;
      return localdv;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<dw> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/tencentmap/mapsdk/a/dy:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 37	com/tencent/tencentmap/mapsdk/a/dy:b	Landroid/util/SparseArray;
    //   13: invokevirtual 228	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 230	com/tencent/tencentmap/mapsdk/a/cz
    //   22: dup
    //   23: invokespecial 231	com/tencent/tencentmap/mapsdk/a/cz:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 37	com/tencent/tencentmap/mapsdk/a/dy:b	Landroid/util/SparseArray;
    //   31: invokestatic 234	com/tencent/tencentmap/mapsdk/a/cz:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	dy
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  /* Error */
  public final void a(ds paramds)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 9
    //   12: aload_0
    //   13: getfield 46	com/tencent/tencentmap/mapsdk/a/dy:f	Z
    //   16: ifeq +10 -> 26
    //   19: aload_0
    //   20: invokevirtual 239	com/tencent/tencentmap/mapsdk/a/dy:b	()Z
    //   23: ifne +61 -> 84
    //   26: aload_1
    //   27: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   30: iconst_2
    //   31: if_icmpne +17 -> 48
    //   34: ldc 243
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   48: aload_1
    //   49: getfield 248	com/tencent/tencentmap/mapsdk/a/ds:b	I
    //   52: ifeq +23 -> 75
    //   55: ldc 250
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_1
    //   64: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   67: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: return
    //   75: ldc 252
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: getfield 44	com/tencent/tencentmap/mapsdk/a/dy:e	Landroid/content/Context;
    //   88: invokestatic 256	com/tencent/tencentmap/mapsdk/a/e:m	(Landroid/content/Context;)Z
    //   91: ifne +27 -> 118
    //   94: ldc_w 258
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload_1
    //   105: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   108: iconst_2
    //   109: if_icmpne -35 -> 74
    //   112: aload_1
    //   113: iconst_0
    //   114: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   117: return
    //   118: aload_1
    //   119: ifnonnull +14 -> 133
    //   122: ldc_w 260
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 170	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: return
    //   133: aload_1
    //   134: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   137: istore 4
    //   139: aload_1
    //   140: invokevirtual 262	com/tencent/tencentmap/mapsdk/a/ds:e	()Ljava/lang/String;
    //   143: astore 14
    //   145: aload 14
    //   147: ifnull +17 -> 164
    //   150: ldc_w 264
    //   153: aload 14
    //   155: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   158: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +38 -> 199
    //   164: ldc_w 275
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 170	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_1
    //   175: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   178: iconst_2
    //   179: if_icmpne +8 -> 187
    //   182: aload_1
    //   183: iconst_0
    //   184: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   187: aload_0
    //   188: iload 4
    //   190: iconst_m1
    //   191: iconst_0
    //   192: ldc_w 277
    //   195: invokespecial 279	com/tencent/tencentmap/mapsdk/a/dy:a	(IIZLjava/lang/String;)V
    //   198: return
    //   199: aload_1
    //   200: invokestatic 281	com/tencent/tencentmap/mapsdk/a/dy:b	(Lcom/tencent/tencentmap/mapsdk/a/ds;)[B
    //   203: astore 15
    //   205: aload_1
    //   206: invokevirtual 283	com/tencent/tencentmap/mapsdk/a/ds:d	()Ljava/lang/String;
    //   209: astore 13
    //   211: aconst_null
    //   212: astore 12
    //   214: aload 13
    //   216: ifnull +23 -> 239
    //   219: new 285	java/lang/StringBuilder
    //   222: dup
    //   223: ldc_w 287
    //   226: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: aload 13
    //   231: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore 12
    //   239: invokestatic 69	com/tencent/tencentmap/mapsdk/a/cm:a	()Lcom/tencent/tencentmap/mapsdk/a/cm;
    //   242: astore 16
    //   244: aload 12
    //   246: astore 13
    //   248: aload 16
    //   250: ifnull +59 -> 309
    //   253: aload 16
    //   255: invokevirtual 297	com/tencent/tencentmap/mapsdk/a/cm:l	()Ljava/lang/String;
    //   258: astore 16
    //   260: aload 12
    //   262: astore 13
    //   264: aload 16
    //   266: ifnull +43 -> 309
    //   269: aload 12
    //   271: astore 13
    //   273: ldc_w 264
    //   276: aload 16
    //   278: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifne +28 -> 309
    //   284: aload 12
    //   286: ifnonnull +110 -> 396
    //   289: new 285	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 299
    //   296: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload 16
    //   301: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore 13
    //   309: aload 13
    //   311: ifnull +1056 -> 1367
    //   314: new 285	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   321: aload 14
    //   323: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 13
    //   328: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore 12
    //   336: ldc_w 302
    //   339: iconst_3
    //   340: anewarray 4	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: iload 4
    //   347: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: aastore
    //   351: dup
    //   352: iconst_1
    //   353: aload 12
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: aload_1
    //   359: invokevirtual 158	java/lang/Object:getClass	()Ljava/lang/Class;
    //   362: invokevirtual 163	java/lang/Class:toString	()Ljava/lang/String;
    //   365: aastore
    //   366: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload 15
    //   371: ifnonnull +56 -> 427
    //   374: ldc_w 304
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload_0
    //   385: iload 4
    //   387: iconst_m1
    //   388: iconst_0
    //   389: ldc_w 306
    //   392: invokespecial 279	com/tencent/tencentmap/mapsdk/a/dy:a	(IIZLjava/lang/String;)V
    //   395: return
    //   396: new 285	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   403: aload 12
    //   405: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 308
    //   411: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 16
    //   416: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 13
    //   424: goto -115 -> 309
    //   427: aload_0
    //   428: invokespecial 310	com/tencent/tencentmap/mapsdk/a/dy:d	()Lcom/tencent/tencentmap/mapsdk/a/dv;
    //   431: astore 14
    //   433: aload 14
    //   435: ifnonnull +25 -> 460
    //   438: ldc_w 312
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokestatic 170	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: aload_0
    //   449: iload 4
    //   451: iconst_m1
    //   452: iconst_0
    //   453: ldc_w 314
    //   456: invokespecial 279	com/tencent/tencentmap/mapsdk/a/dy:a	(IIZLjava/lang/String;)V
    //   459: return
    //   460: aload_0
    //   461: getfield 44	com/tencent/tencentmap/mapsdk/a/dy:e	Landroid/content/Context;
    //   464: invokestatic 317	com/tencent/tencentmap/mapsdk/a/e:f	(Landroid/content/Context;)Ljava/lang/String;
    //   467: pop
    //   468: invokestatic 322	com/tencent/tencentmap/mapsdk/a/c:m	()Lcom/tencent/tencentmap/mapsdk/a/c;
    //   471: invokevirtual 325	com/tencent/tencentmap/mapsdk/a/c:h	()J
    //   474: pop2
    //   475: new 327	java/util/Date
    //   478: dup
    //   479: invokespecial 328	java/util/Date:<init>	()V
    //   482: invokevirtual 331	java/util/Date:getTime	()J
    //   485: pop2
    //   486: iload 8
    //   488: istore 7
    //   490: aload 14
    //   492: aload 12
    //   494: aload 15
    //   496: aload_1
    //   497: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/dv:a	(Ljava/lang/String;[BLcom/tencent/tencentmap/mapsdk/a/ds;)[B
    //   500: astore 13
    //   502: aload 13
    //   504: ifnonnull +856 -> 1360
    //   507: iload 4
    //   509: bipush 100
    //   511: if_icmpne +849 -> 1360
    //   514: iload 8
    //   516: istore 7
    //   518: ldc_w 336
    //   521: aload 12
    //   523: invokevirtual 273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifne +834 -> 1360
    //   529: iload 8
    //   531: istore 7
    //   533: aload 14
    //   535: ldc_w 336
    //   538: aload 15
    //   540: aload_1
    //   541: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/dv:a	(Ljava/lang/String;[BLcom/tencent/tencentmap/mapsdk/a/ds;)[B
    //   544: astore 12
    //   546: iload 8
    //   548: istore 7
    //   550: aload 12
    //   552: invokestatic 338	com/tencent/tencentmap/mapsdk/a/dy:a	([B)Lcom/tencent/tencentmap/mapsdk/a/ct;
    //   555: astore 12
    //   557: aload 12
    //   559: ifnull +792 -> 1351
    //   562: iload 8
    //   564: istore 7
    //   566: aload 12
    //   568: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   571: istore_3
    //   572: iload_3
    //   573: istore_2
    //   574: iload 10
    //   576: istore 9
    //   578: iload 8
    //   580: istore 7
    //   582: aload 12
    //   584: getfield 342	com/tencent/tencentmap/mapsdk/a/ct:a	B
    //   587: istore 5
    //   589: iload 5
    //   591: ifne +78 -> 669
    //   594: iconst_1
    //   595: istore 7
    //   597: ldc_w 344
    //   600: iconst_2
    //   601: anewarray 4	java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: aload 12
    //   608: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   611: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: aload 12
    //   619: getfield 342	com/tencent/tencentmap/mapsdk/a/ct:a	B
    //   622: invokestatic 349	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   625: aastore
    //   626: invokestatic 101	com/tencent/tencentmap/mapsdk/a/cy:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: iload 7
    //   631: istore 8
    //   633: aload_1
    //   634: ifnull +8 -> 642
    //   637: aload 12
    //   639: ifnonnull +36 -> 675
    //   642: iload_3
    //   643: istore_2
    //   644: iload 8
    //   646: istore 9
    //   648: iload 8
    //   650: istore 7
    //   652: aload_0
    //   653: iload 4
    //   655: iload_3
    //   656: iload 8
    //   658: aconst_null
    //   659: invokespecial 279	com/tencent/tencentmap/mapsdk/a/dy:a	(IIZLjava/lang/String;)V
    //   662: aload_1
    //   663: iload 8
    //   665: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   668: return
    //   669: iconst_0
    //   670: istore 7
    //   672: goto -75 -> 597
    //   675: iload_3
    //   676: istore_2
    //   677: iload 8
    //   679: istore 9
    //   681: iload 8
    //   683: istore 7
    //   685: invokestatic 322	com/tencent/tencentmap/mapsdk/a/c:m	()Lcom/tencent/tencentmap/mapsdk/a/c;
    //   688: astore 13
    //   690: aload 13
    //   692: ifnull +128 -> 820
    //   695: iload_3
    //   696: istore_2
    //   697: iload 8
    //   699: istore 9
    //   701: iload 8
    //   703: istore 7
    //   705: aload 12
    //   707: getfield 350	com/tencent/tencentmap/mapsdk/a/ct:d	Ljava/lang/String;
    //   710: ifnull +26 -> 736
    //   713: iload_3
    //   714: istore_2
    //   715: iload 8
    //   717: istore 9
    //   719: iload 8
    //   721: istore 7
    //   723: aload 13
    //   725: aload 12
    //   727: getfield 350	com/tencent/tencentmap/mapsdk/a/ct:d	Ljava/lang/String;
    //   730: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   733: invokevirtual 351	com/tencent/tencentmap/mapsdk/a/c:b	(Ljava/lang/String;)V
    //   736: iload_3
    //   737: istore_2
    //   738: iload 8
    //   740: istore 9
    //   742: iload 8
    //   744: istore 7
    //   746: new 327	java/util/Date
    //   749: dup
    //   750: invokespecial 328	java/util/Date:<init>	()V
    //   753: astore 14
    //   755: iload_3
    //   756: istore_2
    //   757: iload 8
    //   759: istore 9
    //   761: iload 8
    //   763: istore 7
    //   765: aload 13
    //   767: aload 12
    //   769: getfield 354	com/tencent/tencentmap/mapsdk/a/ct:e	J
    //   772: aload 14
    //   774: invokevirtual 331	java/util/Date:getTime	()J
    //   777: lsub
    //   778: invokevirtual 357	com/tencent/tencentmap/mapsdk/a/c:a	(J)V
    //   781: iload_3
    //   782: istore_2
    //   783: iload 8
    //   785: istore 9
    //   787: iload 8
    //   789: istore 7
    //   791: ldc_w 359
    //   794: iconst_2
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 13
    //   802: invokevirtual 361	com/tencent/tencentmap/mapsdk/a/c:g	()Ljava/lang/String;
    //   805: aastore
    //   806: dup
    //   807: iconst_1
    //   808: aload 13
    //   810: invokevirtual 325	com/tencent/tencentmap/mapsdk/a/c:h	()J
    //   813: invokestatic 366	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   816: aastore
    //   817: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   820: iload_3
    //   821: istore_2
    //   822: iload 8
    //   824: istore 9
    //   826: iload 8
    //   828: istore 7
    //   830: aload 12
    //   832: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   835: bipush 101
    //   837: if_icmpeq +43 -> 880
    //   840: iload_3
    //   841: istore_2
    //   842: iload 8
    //   844: istore 9
    //   846: iload 8
    //   848: istore 7
    //   850: aload 12
    //   852: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   855: bipush 103
    //   857: if_icmpeq +23 -> 880
    //   860: iload_3
    //   861: istore_2
    //   862: iload 8
    //   864: istore 9
    //   866: iload 8
    //   868: istore 7
    //   870: aload 12
    //   872: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   875: bipush 105
    //   877: if_icmpne +24 -> 901
    //   880: iload_3
    //   881: istore_2
    //   882: iload 8
    //   884: istore 9
    //   886: iload 8
    //   888: istore 7
    //   890: aload_0
    //   891: getfield 44	com/tencent/tencentmap/mapsdk/a/dy:e	Landroid/content/Context;
    //   894: invokestatic 371	com/tencent/tencentmap/mapsdk/a/ck:a	(Landroid/content/Context;)Lcom/tencent/tencentmap/mapsdk/a/ck;
    //   897: invokevirtual 373	com/tencent/tencentmap/mapsdk/a/ck:e	()Lcom/tencent/tencentmap/mapsdk/a/cm;
    //   900: pop
    //   901: iload_3
    //   902: istore_2
    //   903: iload 8
    //   905: istore 9
    //   907: iload 8
    //   909: istore 7
    //   911: aload 12
    //   913: getfield 376	com/tencent/tencentmap/mapsdk/a/ct:c	[B
    //   916: astore 13
    //   918: aload 13
    //   920: ifnonnull +78 -> 998
    //   923: iload_3
    //   924: istore_2
    //   925: iload 8
    //   927: istore 9
    //   929: iload 8
    //   931: istore 7
    //   933: ldc_w 378
    //   936: iconst_0
    //   937: anewarray 4	java/lang/Object
    //   940: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   943: goto -301 -> 642
    //   946: astore 12
    //   948: iload 9
    //   950: istore 8
    //   952: iload 8
    //   954: istore 7
    //   956: aload_0
    //   957: iload 4
    //   959: iload_2
    //   960: iconst_0
    //   961: aload 12
    //   963: invokevirtual 379	java/lang/Throwable:toString	()Ljava/lang/String;
    //   966: invokespecial 279	com/tencent/tencentmap/mapsdk/a/dy:a	(IIZLjava/lang/String;)V
    //   969: iload 8
    //   971: istore 7
    //   973: ldc_w 381
    //   976: iconst_1
    //   977: anewarray 4	java/lang/Object
    //   980: dup
    //   981: iconst_0
    //   982: aload 12
    //   984: invokevirtual 379	java/lang/Throwable:toString	()Ljava/lang/String;
    //   987: aastore
    //   988: invokestatic 170	com/tencent/tencentmap/mapsdk/a/cy:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   991: aload_1
    //   992: iload 8
    //   994: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   997: return
    //   998: iload_3
    //   999: istore_2
    //   1000: iload 8
    //   1002: istore 9
    //   1004: iload 8
    //   1006: istore 7
    //   1008: aload_0
    //   1009: invokespecial 383	com/tencent/tencentmap/mapsdk/a/dy:e	()Landroid/util/SparseArray;
    //   1012: astore 14
    //   1014: aload 14
    //   1016: ifnull +21 -> 1037
    //   1019: iload_3
    //   1020: istore_2
    //   1021: iload 8
    //   1023: istore 9
    //   1025: iload 8
    //   1027: istore 7
    //   1029: aload 14
    //   1031: invokevirtual 228	android/util/SparseArray:size	()I
    //   1034: ifgt +37 -> 1071
    //   1037: iload_3
    //   1038: istore_2
    //   1039: iload 8
    //   1041: istore 9
    //   1043: iload 8
    //   1045: istore 7
    //   1047: ldc_w 385
    //   1050: iconst_0
    //   1051: anewarray 4	java/lang/Object
    //   1054: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1057: goto -415 -> 642
    //   1060: astore 12
    //   1062: aload_1
    //   1063: iload 7
    //   1065: invokevirtual 246	com/tencent/tencentmap/mapsdk/a/ds:b	(Z)V
    //   1068: aload 12
    //   1070: athrow
    //   1071: iload_3
    //   1072: istore_2
    //   1073: iload 8
    //   1075: istore 9
    //   1077: iload 8
    //   1079: istore 7
    //   1081: aload_1
    //   1082: invokevirtual 241	com/tencent/tencentmap/mapsdk/a/ds:c	()I
    //   1085: istore 5
    //   1087: iload_3
    //   1088: istore_2
    //   1089: iload 8
    //   1091: istore 9
    //   1093: iload 8
    //   1095: istore 7
    //   1097: aload 12
    //   1099: getfield 339	com/tencent/tencentmap/mapsdk/a/ct:b	I
    //   1102: istore 6
    //   1104: iload 6
    //   1106: ifne +268 -> 1374
    //   1109: iload_3
    //   1110: istore_2
    //   1111: iload 8
    //   1113: istore 9
    //   1115: iload 8
    //   1117: istore 7
    //   1119: ldc_w 387
    //   1122: iconst_0
    //   1123: anewarray 4	java/lang/Object
    //   1126: invokestatic 116	com/tencent/tencentmap/mapsdk/a/cy:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1129: goto -487 -> 642
    //   1132: iload_3
    //   1133: istore_2
    //   1134: iload 8
    //   1136: istore 9
    //   1138: iload 8
    //   1140: istore 7
    //   1142: ldc_w 389
    //   1145: iconst_1
    //   1146: anewarray 4	java/lang/Object
    //   1149: dup
    //   1150: iconst_0
    //   1151: iload 5
    //   1153: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1156: aastore
    //   1157: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1160: goto -518 -> 642
    //   1163: iload 6
    //   1165: bipush 101
    //   1167: if_icmpeq +134 -> 1301
    //   1170: iload_3
    //   1171: istore_2
    //   1172: iload 8
    //   1174: istore 9
    //   1176: iload 8
    //   1178: istore 7
    //   1180: ldc_w 391
    //   1183: iconst_2
    //   1184: anewarray 4	java/lang/Object
    //   1187: dup
    //   1188: iconst_0
    //   1189: iload 5
    //   1191: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1194: aastore
    //   1195: dup
    //   1196: iconst_1
    //   1197: iload 6
    //   1199: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1202: aastore
    //   1203: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1206: goto -564 -> 642
    //   1209: iload 6
    //   1211: bipush 105
    //   1213: if_icmpeq +88 -> 1301
    //   1216: iload_3
    //   1217: istore_2
    //   1218: iload 8
    //   1220: istore 9
    //   1222: iload 8
    //   1224: istore 7
    //   1226: ldc_w 391
    //   1229: iconst_2
    //   1230: anewarray 4	java/lang/Object
    //   1233: dup
    //   1234: iconst_0
    //   1235: iload 5
    //   1237: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1240: aastore
    //   1241: dup
    //   1242: iconst_1
    //   1243: iload 6
    //   1245: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1248: aastore
    //   1249: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1252: goto -610 -> 642
    //   1255: iload 6
    //   1257: bipush 103
    //   1259: if_icmpeq +42 -> 1301
    //   1262: iload_3
    //   1263: istore_2
    //   1264: iload 8
    //   1266: istore 9
    //   1268: iload 8
    //   1270: istore 7
    //   1272: ldc_w 393
    //   1275: iconst_2
    //   1276: anewarray 4	java/lang/Object
    //   1279: dup
    //   1280: iconst_0
    //   1281: iload 5
    //   1283: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1286: aastore
    //   1287: dup
    //   1288: iconst_1
    //   1289: iload 6
    //   1291: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1294: aastore
    //   1295: invokestatic 152	com/tencent/tencentmap/mapsdk/a/cy:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1298: goto -656 -> 642
    //   1301: iload_3
    //   1302: istore_2
    //   1303: iload 8
    //   1305: istore 9
    //   1307: iload 8
    //   1309: istore 7
    //   1311: aload 14
    //   1313: iload 6
    //   1315: aload 13
    //   1317: invokestatic 395	com/tencent/tencentmap/mapsdk/a/dy:a	(Landroid/util/SparseArray;I[B)Z
    //   1320: pop
    //   1321: goto -679 -> 642
    //   1324: astore 12
    //   1326: goto -264 -> 1062
    //   1329: astore 12
    //   1331: iconst_m1
    //   1332: istore_2
    //   1333: iload 11
    //   1335: istore 8
    //   1337: goto -385 -> 952
    //   1340: astore 12
    //   1342: iload_3
    //   1343: istore_2
    //   1344: iload 7
    //   1346: istore 8
    //   1348: goto -396 -> 952
    //   1351: iconst_m1
    //   1352: istore_3
    //   1353: iload 9
    //   1355: istore 8
    //   1357: goto -724 -> 633
    //   1360: aload 13
    //   1362: astore 12
    //   1364: goto -818 -> 546
    //   1367: aload 14
    //   1369: astore 12
    //   1371: goto -1035 -> 336
    //   1374: iload 5
    //   1376: lookupswitch	default:+36->1412, 4:+-167->1209, 100:+-213->1163, 102:+-121->1255
    //   1413: impdep1
    //   1414: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1415	0	this	dy
    //   0	1415	1	paramds	ds
    //   573	771	2	i	int
    //   571	782	3	j	int
    //   137	821	4	k	int
    //   587	788	5	m	int
    //   1102	212	6	n	int
    //   488	857	7	bool1	boolean
    //   7	1349	8	bool2	boolean
    //   10	1344	9	bool3	boolean
    //   1	574	10	bool4	boolean
    //   4	1330	11	bool5	boolean
    //   212	700	12	localObject1	Object
    //   946	37	12	localThrowable1	Throwable
    //   1060	38	12	localObject2	Object
    //   1324	1	12	localObject3	Object
    //   1329	1	12	localThrowable2	Throwable
    //   1340	1	12	localThrowable3	Throwable
    //   1362	8	12	localObject4	Object
    //   209	1152	13	localObject5	Object
    //   143	1225	14	localObject6	Object
    //   203	336	15	arrayOfByte	byte[]
    //   242	173	16	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   582	589	946	java/lang/Throwable
    //   652	662	946	java/lang/Throwable
    //   685	690	946	java/lang/Throwable
    //   705	713	946	java/lang/Throwable
    //   723	736	946	java/lang/Throwable
    //   746	755	946	java/lang/Throwable
    //   765	781	946	java/lang/Throwable
    //   791	820	946	java/lang/Throwable
    //   830	840	946	java/lang/Throwable
    //   850	860	946	java/lang/Throwable
    //   870	880	946	java/lang/Throwable
    //   890	901	946	java/lang/Throwable
    //   911	918	946	java/lang/Throwable
    //   933	943	946	java/lang/Throwable
    //   1008	1014	946	java/lang/Throwable
    //   1029	1037	946	java/lang/Throwable
    //   1047	1057	946	java/lang/Throwable
    //   1081	1087	946	java/lang/Throwable
    //   1097	1104	946	java/lang/Throwable
    //   1119	1129	946	java/lang/Throwable
    //   1142	1160	946	java/lang/Throwable
    //   1180	1206	946	java/lang/Throwable
    //   1226	1252	946	java/lang/Throwable
    //   1272	1298	946	java/lang/Throwable
    //   1311	1321	946	java/lang/Throwable
    //   490	502	1060	finally
    //   518	529	1060	finally
    //   533	546	1060	finally
    //   550	557	1060	finally
    //   566	572	1060	finally
    //   582	589	1060	finally
    //   652	662	1060	finally
    //   685	690	1060	finally
    //   705	713	1060	finally
    //   723	736	1060	finally
    //   746	755	1060	finally
    //   765	781	1060	finally
    //   791	820	1060	finally
    //   830	840	1060	finally
    //   850	860	1060	finally
    //   870	880	1060	finally
    //   890	901	1060	finally
    //   911	918	1060	finally
    //   933	943	1060	finally
    //   956	969	1060	finally
    //   973	991	1060	finally
    //   1008	1014	1060	finally
    //   1029	1037	1060	finally
    //   1047	1057	1060	finally
    //   1081	1087	1060	finally
    //   1097	1104	1060	finally
    //   1119	1129	1060	finally
    //   1142	1160	1060	finally
    //   1180	1206	1060	finally
    //   1226	1252	1060	finally
    //   1272	1298	1060	finally
    //   1311	1321	1060	finally
    //   597	629	1324	finally
    //   490	502	1329	java/lang/Throwable
    //   518	529	1329	java/lang/Throwable
    //   533	546	1329	java/lang/Throwable
    //   550	557	1329	java/lang/Throwable
    //   566	572	1329	java/lang/Throwable
    //   597	629	1340	java/lang/Throwable
  }
  
  public final boolean a()
  {
    return this.f;
  }
  
  public final boolean a(dr paramdr)
  {
    boolean bool;
    if (paramdr == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramdr)) {
          this.c.add(paramdr);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(dw paramdw)
  {
    boolean bool;
    if (paramdw == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(101, paramdw);
        bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/tencentmap/mapsdk/a/dy:e	Landroid/content/Context;
    //   6: invokestatic 408	com/tencent/tencentmap/mapsdk/a/e:l	(Landroid/content/Context;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 48	com/tencent/tencentmap/mapsdk/a/dy:g	Z
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	dy
    //   9	16	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   20	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dy
 * JD-Core Version:    0.7.0.1
 */