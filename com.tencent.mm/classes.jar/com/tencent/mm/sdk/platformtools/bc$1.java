package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

final class bc$1
  extends ContentObserver
{
  private long ypW;
  
  bc$1(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
  }
  
  /* Error */
  public final void onChange(boolean paramBoolean, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 34
    //   7: new 36	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 38
    //   13: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_1
    //   17: invokevirtual 45	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   20: ldc 47
    //   22: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
    //   29: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   41: ifnull +12 -> 53
    //   44: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   47: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   50: ifnonnull +63 -> 113
    //   53: ldc 34
    //   55: ldc 75
    //   57: iconst_1
    //   58: anewarray 77	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   66: aastore
    //   67: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: getfield 17	com/tencent/mm/sdk/platformtools/bc$1:val$context	Landroid/content/Context;
    //   74: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   77: aload_0
    //   78: invokevirtual 92	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   81: invokestatic 96	com/tencent/mm/sdk/platformtools/bc:dtz	()Landroid/database/ContentObserver;
    //   84: pop
    //   85: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   88: ifnull +13 -> 101
    //   91: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   94: invokevirtual 100	java/lang/ref/WeakReference:clear	()V
    //   97: invokestatic 103	com/tencent/mm/sdk/platformtools/bc:dtA	()Ljava/lang/ref/WeakReference;
    //   100: pop
    //   101: aload_0
    //   102: iload_1
    //   103: aload_2
    //   104: invokespecial 105	android/database/ContentObserver:onChange	(ZLandroid/net/Uri;)V
    //   107: ldc 26
    //   109: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: return
    //   113: aload_2
    //   114: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
    //   117: invokestatic 111	com/tencent/mm/sdk/platformtools/bc:access$200	()Ljava/lang/String;
    //   120: invokevirtual 117	java/lang/String:matches	(Ljava/lang/String;)Z
    //   123: ifne +16 -> 139
    //   126: aload_2
    //   127: invokevirtual 56	android/net/Uri:toString	()Ljava/lang/String;
    //   130: invokestatic 111	com/tencent/mm/sdk/platformtools/bc:access$200	()Ljava/lang/String;
    //   133: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   136: ifeq -35 -> 101
    //   139: aload_0
    //   140: getfield 17	com/tencent/mm/sdk/platformtools/bc$1:val$context	Landroid/content/Context;
    //   143: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   146: aload_2
    //   147: invokestatic 125	com/tencent/mm/sdk/platformtools/bc:dtB	()[Ljava/lang/String;
    //   150: aconst_null
    //   151: aconst_null
    //   152: ldc 127
    //   154: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   157: astore 9
    //   159: aload 9
    //   161: ifnull +479 -> 640
    //   164: aload 9
    //   166: astore 10
    //   168: aload 9
    //   170: invokeinterface 137 1 0
    //   175: ifeq +465 -> 640
    //   178: aload 9
    //   180: astore 10
    //   182: aload 9
    //   184: aload 9
    //   186: ldc 139
    //   188: invokeinterface 143 2 0
    //   193: invokeinterface 147 2 0
    //   198: astore 8
    //   200: aload 9
    //   202: astore 10
    //   204: aload 9
    //   206: aload 9
    //   208: ldc 149
    //   210: invokeinterface 143 2 0
    //   215: invokeinterface 153 2 0
    //   220: lstore 4
    //   222: aload 9
    //   224: astore 10
    //   226: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   229: ldc2_w 160
    //   232: ldiv
    //   233: lstore 6
    //   235: aload 9
    //   237: astore 10
    //   239: ldc 34
    //   241: new 36	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 163
    //   247: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 8
    //   252: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 165
    //   257: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: lload 4
    //   262: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: ldc 170
    //   267: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: lload 6
    //   272: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 9
    //   283: astore 10
    //   285: lload 6
    //   287: lload 4
    //   289: lsub
    //   290: invokestatic 176	java/lang/Math:abs	(J)J
    //   293: ldc2_w 177
    //   296: lcmp
    //   297: ifgt +343 -> 640
    //   300: aload 9
    //   302: astore 10
    //   304: lload 6
    //   306: aload_0
    //   307: getfield 180	com/tencent/mm/sdk/platformtools/bc$1:ypW	J
    //   310: lsub
    //   311: lconst_1
    //   312: lcmp
    //   313: ifle +327 -> 640
    //   316: aload 9
    //   318: astore 10
    //   320: aload 8
    //   322: invokestatic 185	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   325: ifne +315 -> 640
    //   328: aload 9
    //   330: astore 10
    //   332: aload 8
    //   334: invokevirtual 188	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   337: ldc 190
    //   339: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   342: ifne +33 -> 375
    //   345: aload 9
    //   347: astore 10
    //   349: aload 8
    //   351: ldc 192
    //   353: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   356: ifne +19 -> 375
    //   359: aload 9
    //   361: astore 10
    //   363: aload 8
    //   365: ldc 194
    //   367: invokevirtual 121	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   370: istore_3
    //   371: iload_3
    //   372: ifeq +268 -> 640
    //   375: aload 9
    //   377: astore 10
    //   379: aload_0
    //   380: lload 6
    //   382: putfield 180	com/tencent/mm/sdk/platformtools/bc$1:ypW	J
    //   385: lload 4
    //   387: lstore 6
    //   389: aload 8
    //   391: astore 10
    //   393: aload 9
    //   395: ifnull +18 -> 413
    //   398: aload 9
    //   400: invokeinterface 197 1 0
    //   405: aload 8
    //   407: astore 10
    //   409: lload 4
    //   411: lstore 6
    //   413: aload 10
    //   415: invokestatic 185	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   418: ifne -317 -> 101
    //   421: ldc 34
    //   423: new 36	java/lang/StringBuilder
    //   426: dup
    //   427: ldc 199
    //   429: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   432: aload 10
    //   434: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 201
    //   439: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: lload 6
    //   444: invokevirtual 168	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   456: ifnull +123 -> 579
    //   459: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   462: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   465: ifnull +114 -> 579
    //   468: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   471: invokevirtual 73	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   474: checkcast 205	com/tencent/mm/sdk/platformtools/bc$a
    //   477: invokeinterface 208 1 0
    //   482: goto -381 -> 101
    //   485: astore 11
    //   487: aconst_null
    //   488: astore 9
    //   490: lconst_0
    //   491: lstore 4
    //   493: aconst_null
    //   494: astore 8
    //   496: aload 9
    //   498: astore 10
    //   500: ldc 34
    //   502: new 36	java/lang/StringBuilder
    //   505: dup
    //   506: ldc 210
    //   508: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: aload 11
    //   513: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   516: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: lload 4
    //   527: lstore 6
    //   529: aload 8
    //   531: astore 10
    //   533: aload 9
    //   535: ifnull -122 -> 413
    //   538: aload 9
    //   540: invokeinterface 197 1 0
    //   545: lload 4
    //   547: lstore 6
    //   549: aload 8
    //   551: astore 10
    //   553: goto -140 -> 413
    //   556: astore_2
    //   557: aconst_null
    //   558: astore 10
    //   560: aload 10
    //   562: ifnull +10 -> 572
    //   565: aload 10
    //   567: invokeinterface 197 1 0
    //   572: ldc 26
    //   574: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   577: aload_2
    //   578: athrow
    //   579: aload_0
    //   580: getfield 17	com/tencent/mm/sdk/platformtools/bc$1:val$context	Landroid/content/Context;
    //   583: invokevirtual 86	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   586: aload_0
    //   587: invokevirtual 92	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   590: invokestatic 96	com/tencent/mm/sdk/platformtools/bc:dtz	()Landroid/database/ContentObserver;
    //   593: pop
    //   594: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   597: ifnull +13 -> 610
    //   600: invokestatic 67	com/tencent/mm/sdk/platformtools/bc:dty	()Ljava/lang/ref/WeakReference;
    //   603: invokevirtual 100	java/lang/ref/WeakReference:clear	()V
    //   606: invokestatic 103	com/tencent/mm/sdk/platformtools/bc:dtA	()Ljava/lang/ref/WeakReference;
    //   609: pop
    //   610: ldc 34
    //   612: ldc 218
    //   614: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: goto -516 -> 101
    //   620: astore_2
    //   621: goto -61 -> 560
    //   624: astore 11
    //   626: lconst_0
    //   627: lstore 4
    //   629: aconst_null
    //   630: astore 8
    //   632: goto -136 -> 496
    //   635: astore 11
    //   637: goto -141 -> 496
    //   640: lconst_0
    //   641: lstore 4
    //   643: aconst_null
    //   644: astore 8
    //   646: goto -261 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	1
    //   0	649	1	paramBoolean	boolean
    //   0	649	2	paramUri	android.net.Uri
    //   370	2	3	bool	boolean
    //   220	422	4	l1	long
    //   233	315	6	l2	long
    //   198	447	8	str	java.lang.String
    //   157	382	9	localCursor	android.database.Cursor
    //   166	400	10	localObject	java.lang.Object
    //   485	27	11	localException1	java.lang.Exception
    //   624	1	11	localException2	java.lang.Exception
    //   635	1	11	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   139	159	485	java/lang/Exception
    //   139	159	556	finally
    //   168	178	620	finally
    //   182	200	620	finally
    //   204	222	620	finally
    //   226	235	620	finally
    //   239	281	620	finally
    //   285	300	620	finally
    //   304	316	620	finally
    //   320	328	620	finally
    //   332	345	620	finally
    //   349	359	620	finally
    //   363	371	620	finally
    //   379	385	620	finally
    //   500	525	620	finally
    //   168	178	624	java/lang/Exception
    //   182	200	624	java/lang/Exception
    //   204	222	624	java/lang/Exception
    //   226	235	624	java/lang/Exception
    //   239	281	624	java/lang/Exception
    //   285	300	624	java/lang/Exception
    //   304	316	624	java/lang/Exception
    //   320	328	624	java/lang/Exception
    //   332	345	624	java/lang/Exception
    //   349	359	624	java/lang/Exception
    //   363	371	624	java/lang/Exception
    //   379	385	635	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc.1
 * JD-Core Version:    0.7.0.1
 */