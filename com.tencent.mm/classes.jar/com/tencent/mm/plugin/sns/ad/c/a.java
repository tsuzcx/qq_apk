package com.tencent.mm.plugin.sns.ad.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static long znn;
  
  public static void H(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(218996);
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor;
    f.a locala;
    if (paramInt1 != paramInt2)
    {
      ae.i("AdExpireDeleteHelper", "checkExpireAd, topAdTime=" + paramInt1 + ", belowAdTime=" + paramInt2);
      dUH();
      localCursor = ah.dXH().hM(paramInt1, paramInt2);
      if ((localCursor != null) && (localCursor.moveToFirst())) {
        locala = new f.a();
      }
    }
    label650:
    label725:
    for (;;)
    {
      Object localObject1 = new e();
      ((e)localObject1).convertFrom(localCursor);
      p localp = ((e)localObject1).ebV();
      String str = r.zV(localp.field_snsId);
      Object localObject2 = new StringBuilder("ad xml ");
      e locale = localp.ecy();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localp.field_stringSeq);
      localStringBuffer.append(locale.field_adxml);
      localStringBuffer.append(" <createtime " + localp.field_createTime + ">");
      localStringBuffer.append(" <exposuretime " + locale.field_exposureTime + ">");
      localStringBuffer.append(" <adcreatetime " + locale.field_createAdTime + "> ");
      localStringBuffer.append(locale.ebP().HUD);
      ae.d("AdExpireDeleteHelper", localStringBuffer.toString());
      long l1 = 21600L;
      localObject2 = localp.dVi();
      paramInt1 = localp.field_createTime;
      boolean bool;
      if ((((e)localObject1).field_localFlag & 0x80) > 0)
      {
        bool = true;
        if (localObject2 != null)
        {
          if (!bool) {
            break label631;
          }
          l1 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zLQ * 60L;
          paramInt1 = ((e)localObject1).field_exposureTime;
        }
        label351:
        long l2 = bu.rZ(paramInt1);
        if ((l2 < l1) || (k.a(al.v(localp), paramString))) {
          break label650;
        }
        localArrayList.add(Long.valueOf(localp.field_snsId));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("prepare to delete ad, snsId=").append(str).append(", exposureTime=").append(l1).append(", field_createTime=").append(localp.field_createTime).append(", checktime=").append(l2).append(", gettime=").append(paramInt1).append(", isExposured=").append(bool).append(", exposureTime=").append(((e)localObject1).field_exposureTime).append(", adCreateTIme=").append(((e)localObject1).field_createAdTime);
        ae.i("AdExpireDeleteHelper", ((StringBuilder)localObject2).toString());
        if (!bool) {
          locala.m(((e)localObject1).dVi().dGD, str, 2, 0);
        }
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label725;
        }
        locala.report();
        if (localCursor != null)
        {
          ae.d("AdExpireDeleteHelper", "test for adcount " + localCursor.getCount());
          localCursor.close();
        }
        if (localArrayList.isEmpty()) {
          break label734;
        }
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          com.tencent.mm.plugin.sns.model.a.T(((Long)paramString.next()).longValue(), 1);
        }
        bool = false;
        break;
        label631:
        l1 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).zLP * 60L;
        paramInt1 = ((e)localObject1).field_createAdTime;
        break label351;
        l1 = localp.field_snsId;
        ae.i("AdExpireDeleteHelper", "try to update snsid " + r.zV(l1));
        if (m.Aa(l1))
        {
          localObject1 = new m(l1, 1, localp.dVi().zMt);
          g.ajS();
          g.ajQ().gDv.a((n)localObject1, 0);
        }
      }
    }
    localArrayList.clear();
    label734:
    AppMethodBeat.o(218996);
  }
  
  /* Error */
  private static void dUH()
  {
    // Byte code:
    //   0: ldc_w 310
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 315	java/lang/System:currentTimeMillis	()J
    //   9: getstatic 317	com/tencent/mm/plugin/sns/ad/c/a:znn	J
    //   12: lsub
    //   13: lstore_3
    //   14: lload_3
    //   15: ldc2_w 318
    //   18: lcmp
    //   19: ifge +44 -> 63
    //   22: ldc 23
    //   24: new 25	java/lang/StringBuilder
    //   27: dup
    //   28: ldc_w 321
    //   31: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   34: lload_3
    //   35: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc_w 323
    //   41: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 317	com/tencent/mm/plugin/sns/ad/c/a:znn	J
    //   47: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   50: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 326	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc_w 310
    //   59: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: invokestatic 315	java/lang/System:currentTimeMillis	()J
    //   66: putstatic 317	com/tencent/mm/plugin/sns/ad/c/a:znn	J
    //   69: invokestatic 331	com/tencent/mm/model/ch:aDd	()I
    //   72: istore_2
    //   73: iload_2
    //   74: ldc_w 332
    //   77: isub
    //   78: istore_1
    //   79: iload_1
    //   80: istore_0
    //   81: iload_1
    //   82: ifge +5 -> 87
    //   85: iconst_0
    //   86: istore_0
    //   87: ldc 23
    //   89: new 25	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 334
    //   96: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: iload_2
    //   100: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: ldc 36
    //   105: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload_0
    //   109: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 48	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 17	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 21	java/util/ArrayList:<init>	()V
    //   125: astore 9
    //   127: new 71	com/tencent/mm/plugin/sns/ad/c/f$a
    //   130: dup
    //   131: invokespecial 72	com/tencent/mm/plugin/sns/ad/c/f$a:<init>	()V
    //   134: astore 10
    //   136: aconst_null
    //   137: astore 6
    //   139: invokestatic 57	com/tencent/mm/plugin/sns/model/ah:dXH	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   142: iload_2
    //   143: iload_0
    //   144: invokevirtual 63	com/tencent/mm/plugin/sns/storage/f:hM	(II)Landroid/database/Cursor;
    //   147: astore 7
    //   149: aload 7
    //   151: astore 6
    //   153: new 25	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   160: astore 8
    //   162: aload 7
    //   164: ifnull +259 -> 423
    //   167: aload 7
    //   169: astore 6
    //   171: aload 7
    //   173: invokeinterface 69 1 0
    //   178: istore 5
    //   180: iload 5
    //   182: ifeq +241 -> 423
    //   185: iload_2
    //   186: ifle +237 -> 423
    //   189: aload 7
    //   191: astore 6
    //   193: new 74	com/tencent/mm/plugin/sns/storage/e
    //   196: dup
    //   197: invokespecial 75	com/tencent/mm/plugin/sns/storage/e:<init>	()V
    //   200: astore 11
    //   202: aload 7
    //   204: astore 6
    //   206: aload 11
    //   208: aload 7
    //   210: invokevirtual 79	com/tencent/mm/plugin/sns/storage/e:convertFrom	(Landroid/database/Cursor;)V
    //   213: aload 7
    //   215: astore 6
    //   217: aload 11
    //   219: invokevirtual 214	com/tencent/mm/plugin/sns/storage/e:dVi	()Lcom/tencent/mm/plugin/sns/storage/a;
    //   222: astore 12
    //   224: aload 7
    //   226: astore 6
    //   228: aload 11
    //   230: getfield 155	com/tencent/mm/plugin/sns/storage/e:field_localFlag	I
    //   233: sipush 128
    //   236: iand
    //   237: ifle +333 -> 570
    //   240: iconst_1
    //   241: istore 5
    //   243: aload 7
    //   245: astore 6
    //   247: aload 11
    //   249: getfield 335	com/tencent/mm/plugin/sns/storage/e:field_snsId	J
    //   252: invokestatic 94	com/tencent/mm/plugin/sns/data/r:zV	(J)Ljava/lang/String;
    //   255: astore 13
    //   257: aload 7
    //   259: astore 6
    //   261: aload 12
    //   263: getfield 338	com/tencent/mm/plugin/sns/storage/a:zMy	I
    //   266: ifle +81 -> 347
    //   269: aload 7
    //   271: astore 6
    //   273: aload 12
    //   275: getfield 338	com/tencent/mm/plugin/sns/storage/a:zMy	I
    //   278: iload_2
    //   279: if_icmpge +68 -> 347
    //   282: iload 5
    //   284: ifne +63 -> 347
    //   287: aload 7
    //   289: astore 6
    //   291: aload 9
    //   293: aload 11
    //   295: getfield 335	com/tencent/mm/plugin/sns/storage/e:field_snsId	J
    //   298: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: invokeinterface 192 2 0
    //   306: pop
    //   307: aload 7
    //   309: astore 6
    //   311: aload 10
    //   313: aload 11
    //   315: invokevirtual 214	com/tencent/mm/plugin/sns/storage/e:dVi	()Lcom/tencent/mm/plugin/sns/storage/a;
    //   318: getfield 217	com/tencent/mm/plugin/sns/storage/a:dGD	Ljava/lang/String;
    //   321: aload 13
    //   323: iconst_3
    //   324: iconst_0
    //   325: invokevirtual 221	com/tencent/mm/plugin/sns/ad/c/f$a:m	(Ljava/lang/String;Ljava/lang/String;II)Lcom/tencent/mm/plugin/sns/ad/c/f$a;
    //   328: pop
    //   329: aload 7
    //   331: astore 6
    //   333: aload 8
    //   335: aload 13
    //   337: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 340
    //   343: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 7
    //   349: astore 6
    //   351: ldc 23
    //   353: new 25	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 342
    //   360: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload 13
    //   365: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc_w 344
    //   371: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 12
    //   376: getfield 338	com/tencent/mm/plugin/sns/storage/a:zMy	I
    //   379: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc_w 346
    //   385: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload 5
    //   390: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: ldc_w 348
    //   396: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: iload_2
    //   400: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 48	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 7
    //   411: astore 6
    //   413: aload 7
    //   415: invokeinterface 224 1 0
    //   420: ifne -231 -> 189
    //   423: aload 7
    //   425: astore 6
    //   427: ldc 23
    //   429: new 25	java/lang/StringBuilder
    //   432: dup
    //   433: ldc_w 350
    //   436: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   439: aload 8
    //   441: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 352
    //   450: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 9
    //   455: invokeinterface 355 1 0
    //   460: invokevirtual 34	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   463: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 48	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 7
    //   471: ifnull +10 -> 481
    //   474: aload 7
    //   476: invokeinterface 236 1 0
    //   481: aload 10
    //   483: invokevirtual 227	com/tencent/mm/plugin/sns/ad/c/f$a:report	()V
    //   486: aload 9
    //   488: invokeinterface 239 1 0
    //   493: ifne +212 -> 705
    //   496: aload 9
    //   498: invokeinterface 243 1 0
    //   503: astore 6
    //   505: aload 6
    //   507: invokeinterface 248 1 0
    //   512: ifeq +186 -> 698
    //   515: aload 6
    //   517: invokeinterface 252 1 0
    //   522: checkcast 182	java/lang/Long
    //   525: invokevirtual 256	java/lang/Long:longValue	()J
    //   528: iconst_5
    //   529: invokestatic 262	com/tencent/mm/plugin/sns/model/a:T	(JI)V
    //   532: goto -27 -> 505
    //   535: astore 6
    //   537: ldc 23
    //   539: new 25	java/lang/StringBuilder
    //   542: dup
    //   543: ldc_w 357
    //   546: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   549: aload 6
    //   551: invokevirtual 358	java/lang/Throwable:toString	()Ljava/lang/String;
    //   554: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 361	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: ldc_w 310
    //   566: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: return
    //   570: iconst_0
    //   571: istore 5
    //   573: goto -330 -> 243
    //   576: astore 11
    //   578: aload 7
    //   580: astore 6
    //   582: ldc 23
    //   584: new 25	java/lang/StringBuilder
    //   587: dup
    //   588: ldc_w 363
    //   591: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   594: aload 11
    //   596: invokevirtual 358	java/lang/Throwable:toString	()Ljava/lang/String;
    //   599: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 361	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: goto -199 -> 409
    //   611: astore 8
    //   613: aload 7
    //   615: astore 6
    //   617: aload 8
    //   619: astore 7
    //   621: ldc 23
    //   623: new 25	java/lang/StringBuilder
    //   626: dup
    //   627: ldc_w 365
    //   630: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   633: aload 7
    //   635: invokevirtual 358	java/lang/Throwable:toString	()Ljava/lang/String;
    //   638: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 361	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload 6
    //   649: ifnull -168 -> 481
    //   652: aload 6
    //   654: invokeinterface 236 1 0
    //   659: goto -178 -> 481
    //   662: astore 6
    //   664: goto -183 -> 481
    //   667: astore 8
    //   669: aload 6
    //   671: astore 7
    //   673: aload 8
    //   675: astore 6
    //   677: aload 7
    //   679: ifnull +10 -> 689
    //   682: aload 7
    //   684: invokeinterface 236 1 0
    //   689: ldc_w 310
    //   692: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   695: aload 6
    //   697: athrow
    //   698: aload 9
    //   700: invokeinterface 303 1 0
    //   705: ldc_w 310
    //   708: invokestatic 306	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   711: return
    //   712: astore 6
    //   714: goto -233 -> 481
    //   717: astore 7
    //   719: goto -30 -> 689
    //   722: astore 8
    //   724: aload 6
    //   726: astore 7
    //   728: aload 8
    //   730: astore 6
    //   732: goto -55 -> 677
    //   735: astore 7
    //   737: aconst_null
    //   738: astore 6
    //   740: goto -119 -> 621
    // Local variable table:
    //   start	length	slot	name	signature
    //   80	64	0	i	int
    //   78	4	1	j	int
    //   72	328	2	k	int
    //   13	22	3	l	long
    //   178	394	5	bool	boolean
    //   137	379	6	localObject1	Object
    //   535	15	6	localThrowable1	java.lang.Throwable
    //   580	73	6	localObject2	Object
    //   662	8	6	localThrowable2	java.lang.Throwable
    //   675	21	6	localObject3	Object
    //   712	13	6	localThrowable3	java.lang.Throwable
    //   730	9	6	localObject4	Object
    //   147	536	7	localObject5	Object
    //   717	1	7	localThrowable4	java.lang.Throwable
    //   726	1	7	localThrowable5	java.lang.Throwable
    //   735	1	7	localThrowable6	java.lang.Throwable
    //   160	280	8	localStringBuilder	StringBuilder
    //   611	7	8	localThrowable7	java.lang.Throwable
    //   667	7	8	localObject6	Object
    //   722	7	8	localObject7	Object
    //   125	574	9	localArrayList	ArrayList
    //   134	348	10	locala	f.a
    //   200	114	11	locale	e
    //   576	19	11	localThrowable8	java.lang.Throwable
    //   222	153	12	locala1	com.tencent.mm.plugin.sns.storage.a
    //   255	109	13	str	String
    // Exception table:
    //   from	to	target	type
    //   486	505	535	java/lang/Throwable
    //   505	532	535	java/lang/Throwable
    //   698	705	535	java/lang/Throwable
    //   193	202	576	java/lang/Throwable
    //   206	213	576	java/lang/Throwable
    //   217	224	576	java/lang/Throwable
    //   228	240	576	java/lang/Throwable
    //   247	257	576	java/lang/Throwable
    //   261	269	576	java/lang/Throwable
    //   273	282	576	java/lang/Throwable
    //   291	307	576	java/lang/Throwable
    //   311	329	576	java/lang/Throwable
    //   333	347	576	java/lang/Throwable
    //   351	409	576	java/lang/Throwable
    //   153	162	611	java/lang/Throwable
    //   171	180	611	java/lang/Throwable
    //   413	423	611	java/lang/Throwable
    //   427	469	611	java/lang/Throwable
    //   582	608	611	java/lang/Throwable
    //   652	659	662	java/lang/Throwable
    //   139	149	667	finally
    //   153	162	667	finally
    //   171	180	667	finally
    //   193	202	667	finally
    //   206	213	667	finally
    //   217	224	667	finally
    //   228	240	667	finally
    //   247	257	667	finally
    //   261	269	667	finally
    //   273	282	667	finally
    //   291	307	667	finally
    //   311	329	667	finally
    //   333	347	667	finally
    //   351	409	667	finally
    //   413	423	667	finally
    //   427	469	667	finally
    //   582	608	667	finally
    //   474	481	712	java/lang/Throwable
    //   682	689	717	java/lang/Throwable
    //   621	647	722	finally
    //   139	149	735	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.a
 * JD-Core Version:    0.7.0.1
 */