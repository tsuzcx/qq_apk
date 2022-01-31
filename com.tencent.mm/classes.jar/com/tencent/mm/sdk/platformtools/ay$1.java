package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

final class ay$1
  extends ContentObserver
{
  private long uhQ;
  
  ay$1(Handler paramHandler, Context paramContext)
  {
    super(paramHandler);
  }
  
  /* Error */
  public final void onChange(boolean paramBoolean, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 27
    //   2: new 29	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 31
    //   8: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: iload_1
    //   12: invokevirtual 38	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15: ldc 40
    //   17: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_2
    //   21: invokevirtual 49	android/net/Uri:toString	()Ljava/lang/String;
    //   24: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 56	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   36: ifnull +12 -> 48
    //   39: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   42: invokevirtual 66	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   45: ifnonnull +58 -> 103
    //   48: ldc 27
    //   50: ldc 68
    //   52: iconst_1
    //   53: anewarray 70	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   61: aastore
    //   62: invokestatic 74	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_0
    //   66: getfield 17	com/tencent/mm/sdk/platformtools/ay$1:val$context	Landroid/content/Context;
    //   69: invokevirtual 80	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   72: aload_0
    //   73: invokevirtual 86	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   76: invokestatic 90	com/tencent/mm/sdk/platformtools/ay:crA	()Landroid/database/ContentObserver;
    //   79: pop
    //   80: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   83: ifnull +13 -> 96
    //   86: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   89: invokevirtual 94	java/lang/ref/WeakReference:clear	()V
    //   92: invokestatic 97	com/tencent/mm/sdk/platformtools/ay:crB	()Ljava/lang/ref/WeakReference;
    //   95: pop
    //   96: aload_0
    //   97: iload_1
    //   98: aload_2
    //   99: invokespecial 99	android/database/ContentObserver:onChange	(ZLandroid/net/Uri;)V
    //   102: return
    //   103: aload_2
    //   104: invokevirtual 49	android/net/Uri:toString	()Ljava/lang/String;
    //   107: invokestatic 102	com/tencent/mm/sdk/platformtools/ay:BG	()Ljava/lang/String;
    //   110: invokevirtual 108	java/lang/String:matches	(Ljava/lang/String;)Z
    //   113: ifne +16 -> 129
    //   116: aload_2
    //   117: invokevirtual 49	android/net/Uri:toString	()Ljava/lang/String;
    //   120: invokestatic 102	com/tencent/mm/sdk/platformtools/ay:BG	()Ljava/lang/String;
    //   123: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   126: ifeq -30 -> 96
    //   129: aload_0
    //   130: getfield 17	com/tencent/mm/sdk/platformtools/ay$1:val$context	Landroid/content/Context;
    //   133: invokevirtual 80	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   136: aload_2
    //   137: invokestatic 116	com/tencent/mm/sdk/platformtools/ay:cbO	()[Ljava/lang/String;
    //   140: aconst_null
    //   141: aconst_null
    //   142: ldc 118
    //   144: invokevirtual 122	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore 9
    //   149: aload 9
    //   151: ifnull +474 -> 625
    //   154: aload 9
    //   156: astore 10
    //   158: aload 9
    //   160: invokeinterface 128 1 0
    //   165: ifeq +460 -> 625
    //   168: aload 9
    //   170: astore 10
    //   172: aload 9
    //   174: aload 9
    //   176: ldc 130
    //   178: invokeinterface 134 2 0
    //   183: invokeinterface 138 2 0
    //   188: astore 8
    //   190: aload 9
    //   192: astore 10
    //   194: aload 9
    //   196: aload 9
    //   198: ldc 140
    //   200: invokeinterface 134 2 0
    //   205: invokeinterface 144 2 0
    //   210: lstore 4
    //   212: aload 9
    //   214: astore 10
    //   216: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   219: ldc2_w 151
    //   222: ldiv
    //   223: lstore 6
    //   225: aload 9
    //   227: astore 10
    //   229: ldc 27
    //   231: new 29	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 154
    //   237: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 8
    //   242: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 156
    //   247: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: lload 4
    //   252: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc 161
    //   257: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: lload 6
    //   262: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 56	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 9
    //   273: astore 10
    //   275: lload 6
    //   277: lload 4
    //   279: lsub
    //   280: invokestatic 167	java/lang/Math:abs	(J)J
    //   283: ldc2_w 168
    //   286: lcmp
    //   287: ifgt +338 -> 625
    //   290: aload 9
    //   292: astore 10
    //   294: lload 6
    //   296: aload_0
    //   297: getfield 171	com/tencent/mm/sdk/platformtools/ay$1:uhQ	J
    //   300: lsub
    //   301: lconst_1
    //   302: lcmp
    //   303: ifle +322 -> 625
    //   306: aload 9
    //   308: astore 10
    //   310: aload 8
    //   312: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   315: ifne +310 -> 625
    //   318: aload 9
    //   320: astore 10
    //   322: aload 8
    //   324: invokevirtual 179	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   327: ldc 181
    //   329: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   332: ifne +33 -> 365
    //   335: aload 9
    //   337: astore 10
    //   339: aload 8
    //   341: ldc 183
    //   343: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   346: ifne +19 -> 365
    //   349: aload 9
    //   351: astore 10
    //   353: aload 8
    //   355: ldc 185
    //   357: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: istore_3
    //   361: iload_3
    //   362: ifeq +263 -> 625
    //   365: aload 9
    //   367: astore 10
    //   369: aload_0
    //   370: lload 6
    //   372: putfield 171	com/tencent/mm/sdk/platformtools/ay$1:uhQ	J
    //   375: lload 4
    //   377: lstore 6
    //   379: aload 8
    //   381: astore 10
    //   383: aload 9
    //   385: ifnull +18 -> 403
    //   388: aload 9
    //   390: invokeinterface 188 1 0
    //   395: aload 8
    //   397: astore 10
    //   399: lload 4
    //   401: lstore 6
    //   403: aload 10
    //   405: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   408: ifne -312 -> 96
    //   411: ldc 27
    //   413: new 29	java/lang/StringBuilder
    //   416: dup
    //   417: ldc 190
    //   419: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   422: aload 10
    //   424: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 192
    //   429: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: lload 6
    //   434: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 194	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   446: ifnull +118 -> 564
    //   449: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   452: invokevirtual 66	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   455: ifnull +109 -> 564
    //   458: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   461: invokevirtual 66	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   464: checkcast 196	com/tencent/mm/sdk/platformtools/ay$a
    //   467: invokeinterface 199 1 0
    //   472: goto -376 -> 96
    //   475: astore 11
    //   477: aconst_null
    //   478: astore 9
    //   480: lconst_0
    //   481: lstore 4
    //   483: aconst_null
    //   484: astore 8
    //   486: aload 9
    //   488: astore 10
    //   490: ldc 27
    //   492: new 29	java/lang/StringBuilder
    //   495: dup
    //   496: ldc 201
    //   498: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   501: aload 11
    //   503: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   506: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 207	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: lload 4
    //   517: lstore 6
    //   519: aload 8
    //   521: astore 10
    //   523: aload 9
    //   525: ifnull -122 -> 403
    //   528: aload 9
    //   530: invokeinterface 188 1 0
    //   535: lload 4
    //   537: lstore 6
    //   539: aload 8
    //   541: astore 10
    //   543: goto -140 -> 403
    //   546: astore_2
    //   547: aconst_null
    //   548: astore 10
    //   550: aload 10
    //   552: ifnull +10 -> 562
    //   555: aload 10
    //   557: invokeinterface 188 1 0
    //   562: aload_2
    //   563: athrow
    //   564: aload_0
    //   565: getfield 17	com/tencent/mm/sdk/platformtools/ay$1:val$context	Landroid/content/Context;
    //   568: invokevirtual 80	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   571: aload_0
    //   572: invokevirtual 86	android/content/ContentResolver:unregisterContentObserver	(Landroid/database/ContentObserver;)V
    //   575: invokestatic 90	com/tencent/mm/sdk/platformtools/ay:crA	()Landroid/database/ContentObserver;
    //   578: pop
    //   579: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   582: ifnull +13 -> 595
    //   585: invokestatic 60	com/tencent/mm/sdk/platformtools/ay:crz	()Ljava/lang/ref/WeakReference;
    //   588: invokevirtual 94	java/lang/ref/WeakReference:clear	()V
    //   591: invokestatic 97	com/tencent/mm/sdk/platformtools/ay:crB	()Ljava/lang/ref/WeakReference;
    //   594: pop
    //   595: ldc 27
    //   597: ldc 209
    //   599: invokestatic 194	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: goto -506 -> 96
    //   605: astore_2
    //   606: goto -56 -> 550
    //   609: astore 11
    //   611: lconst_0
    //   612: lstore 4
    //   614: aconst_null
    //   615: astore 8
    //   617: goto -131 -> 486
    //   620: astore 11
    //   622: goto -136 -> 486
    //   625: lconst_0
    //   626: lstore 4
    //   628: aconst_null
    //   629: astore 8
    //   631: goto -256 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	1
    //   0	634	1	paramBoolean	boolean
    //   0	634	2	paramUri	android.net.Uri
    //   360	2	3	bool	boolean
    //   210	417	4	l1	long
    //   223	315	6	l2	long
    //   188	442	8	str	java.lang.String
    //   147	382	9	localCursor	android.database.Cursor
    //   156	400	10	localObject	java.lang.Object
    //   475	27	11	localException1	java.lang.Exception
    //   609	1	11	localException2	java.lang.Exception
    //   620	1	11	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   129	149	475	java/lang/Exception
    //   129	149	546	finally
    //   158	168	605	finally
    //   172	190	605	finally
    //   194	212	605	finally
    //   216	225	605	finally
    //   229	271	605	finally
    //   275	290	605	finally
    //   294	306	605	finally
    //   310	318	605	finally
    //   322	335	605	finally
    //   339	349	605	finally
    //   353	361	605	finally
    //   369	375	605	finally
    //   490	515	605	finally
    //   158	168	609	java/lang/Exception
    //   172	190	609	java/lang/Exception
    //   194	212	609	java/lang/Exception
    //   216	225	609	java/lang/Exception
    //   229	271	609	java/lang/Exception
    //   275	290	609	java/lang/Exception
    //   294	306	609	java/lang/Exception
    //   310	318	609	java/lang/Exception
    //   322	335	609	java/lang/Exception
    //   339	349	609	java/lang/Exception
    //   353	361	609	java/lang/Exception
    //   369	375	620	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay.1
 * JD-Core Version:    0.7.0.1
 */