package com.tencent.mm.plugin.sns.ad.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static long PNQ;
  
  public static void O(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(310023);
    ArrayList localArrayList = new ArrayList();
    long l2;
    int j;
    Cursor localCursor;
    u.a locala;
    if (paramInt1 != paramInt2)
    {
      l2 = System.currentTimeMillis();
      if (paramInt2 == 0)
      {
        Log.e("AdExpireDeleteHelper", "query startTime==0");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 1);
      }
      gZG();
      int k = 0;
      j = 0;
      localCursor = al.hgE().lB(paramInt1, paramInt2);
      i = k;
      if (localCursor != null)
      {
        i = k;
        if (localCursor.moveToFirst()) {
          locala = new u.a();
        }
      }
    }
    for (int i = j;; i = j)
    {
      j = i + 1;
      Object localObject1;
      SnsInfo localSnsInfo;
      long l1;
      Object localObject2;
      if (j <= 50)
      {
        localObject1 = new AdSnsInfo();
        ((AdSnsInfo)localObject1).convertFrom(localCursor);
        localSnsInfo = ((AdSnsInfo)localObject1).convertToSnsInfo();
        String str = t.uA(localSnsInfo.field_snsId);
        l1 = 21600L;
        localObject2 = localSnsInfo.getAdInfo();
        i = localSnsInfo.field_createTime;
        boolean bool = ((AdSnsInfo)localObject1).isExposured();
        if (localObject2 != null)
        {
          if (!bool) {
            break label587;
          }
          l1 = ((ADInfo)localObject2).exposureNoActionExpireTime * 60L;
          i = ((AdSnsInfo)localObject1).field_exposureTime;
        }
        long l3 = Util.secondsToNow(i);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("expire check, snsId=").append(str).append(", isExposured=").append(bool).append(", exposureCnt=").append(((AdSnsInfo)localObject1).field_exposureCount).append(", exposureTime=").append(l1).append(", field_createTime=").append(localSnsInfo.field_createTime).append(", checktime=").append(l3).append(", gettime=").append(i).append(", exposureTime=").append(((AdSnsInfo)localObject1).field_exposureTime).append(", adCreateTIme=").append(((AdSnsInfo)localObject1).field_createAdTime);
        Log.i("AdExpireDeleteHelper", ((StringBuilder)localObject2).toString());
        if ((l3 < l1) || (com.tencent.mm.plugin.sns.data.m.a(ap.E(localSnsInfo), paramString))) {
          break label607;
        }
        localArrayList.add(Long.valueOf(localSnsInfo.field_snsId));
        if (!bool) {
          locala.q(((AdSnsInfo)localObject1).getAdInfo().uxInfo, str, 2, 0);
        }
      }
      label587:
      label607:
      for (;;)
      {
        label383:
        if (!localCursor.moveToNext())
        {
          locala.report();
          i = j;
          if (localCursor != null) {
            localCursor.close();
          }
          l1 = System.currentTimeMillis();
          j = localArrayList.size();
          if ((paramInt2 == 0) && (i - j > 2)) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 29);
          }
          Log.i("AdExpireDeleteHelper", "checkExpireAd, topAdTime=" + paramInt1 + ", belowAdTime=" + paramInt2 + ", adCount=" + i + ", delCount=" + j + ", timeCost=" + (l1 - l2));
          if (!localArrayList.isEmpty())
          {
            paramString = localArrayList.iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                l1 = ((Long)paramString.next()).longValue();
                Log.i("AdExpireDeleteHelper", "deleteAdWithNoCheck, id=" + t.uA(l1));
                a.av(l1, 1);
                continue;
                l1 = ((ADInfo)localObject2).noExposureExpireTime * 60L;
                i = ((AdSnsInfo)localObject1).field_createAdTime;
                break;
                if (localSnsInfo == null) {
                  break label383;
                }
                l1 = localSnsInfo.field_snsId;
                if (!com.tencent.mm.plugin.sns.model.m.uF(l1)) {
                  break label383;
                }
                localObject1 = new com.tencent.mm.plugin.sns.model.m(l1, 1, localSnsInfo.getAdInfo().adInfoSyncBuffer);
                com.tencent.mm.kernel.h.baF();
                com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
                break label383;
              }
            }
            localArrayList.clear();
          }
          AppMethodBeat.o(310023);
          return;
        }
      }
    }
  }
  
  /* Error */
  private static void gZG()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: ldc_w 296
    //   7: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   13: getstatic 298	com/tencent/mm/plugin/sns/ad/d/d:PNQ	J
    //   16: lsub
    //   17: lstore 5
    //   19: lload 5
    //   21: ldc2_w 299
    //   24: lcmp
    //   25: ifge +45 -> 70
    //   28: ldc 29
    //   30: new 124	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 302
    //   37: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: lload 5
    //   42: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: ldc_w 304
    //   48: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 298	com/tencent/mm/plugin/sns/ad/d/d:PNQ	J
    //   54: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: ldc_w 296
    //   66: invokestatic 294	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   73: putstatic 298	com/tencent/mm/plugin/sns/ad/d/d:PNQ	J
    //   76: invokestatic 312	com/tencent/mm/model/cn:getSyncServerTimeSecond	()I
    //   79: istore 4
    //   81: iload 4
    //   83: ldc_w 313
    //   86: isub
    //   87: istore_3
    //   88: iload_3
    //   89: istore_0
    //   90: iload_3
    //   91: ifge +5 -> 96
    //   94: iconst_0
    //   95: istore_0
    //   96: ldc 29
    //   98: new 124	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 315
    //   105: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: iload 4
    //   110: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 219
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_0
    //   119: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: new 17	java/util/ArrayList
    //   131: dup
    //   132: invokespecial 21	java/util/ArrayList:<init>	()V
    //   135: astore 10
    //   137: new 70	com/tencent/mm/plugin/sns/ad/d/u$a
    //   140: dup
    //   141: invokespecial 71	com/tencent/mm/plugin/sns/ad/d/u$a:<init>	()V
    //   144: astore 11
    //   146: invokestatic 56	com/tencent/mm/plugin/sns/model/al:hgE	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   149: iload 4
    //   151: iload_0
    //   152: invokevirtual 62	com/tencent/mm/plugin/sns/storage/f:lB	(II)Landroid/database/Cursor;
    //   155: astore 8
    //   157: new 124	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   164: astore 9
    //   166: iload_2
    //   167: istore_0
    //   168: aload 8
    //   170: ifnull +242 -> 412
    //   173: aload 8
    //   175: invokeinterface 68 1 0
    //   180: istore 7
    //   182: iload_2
    //   183: istore_0
    //   184: iload 7
    //   186: ifeq +226 -> 412
    //   189: iload_2
    //   190: istore_0
    //   191: iload 4
    //   193: ifle +219 -> 412
    //   196: iload_1
    //   197: istore_0
    //   198: iload_0
    //   199: iconst_1
    //   200: iadd
    //   201: istore_1
    //   202: new 73	com/tencent/mm/plugin/sns/storage/AdSnsInfo
    //   205: dup
    //   206: invokespecial 74	com/tencent/mm/plugin/sns/storage/AdSnsInfo:<init>	()V
    //   209: astore 12
    //   211: aload 12
    //   213: aload 8
    //   215: invokevirtual 78	com/tencent/mm/plugin/sns/storage/AdSnsInfo:convertFrom	(Landroid/database/Cursor;)V
    //   218: aload 12
    //   220: invokevirtual 191	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   223: astore 13
    //   225: aload 12
    //   227: invokevirtual 106	com/tencent/mm/plugin/sns/storage/AdSnsInfo:isExposured	()Z
    //   230: istore 7
    //   232: aload 12
    //   234: getfield 316	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_snsId	J
    //   237: invokestatic 93	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   240: astore 14
    //   242: aload 13
    //   244: getfield 319	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   247: ifle +66 -> 313
    //   250: aload 13
    //   252: getfield 319	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   255: iload 4
    //   257: if_icmpge +56 -> 313
    //   260: iload 7
    //   262: ifne +51 -> 313
    //   265: aload 10
    //   267: aload 12
    //   269: getfield 316	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_snsId	J
    //   272: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: invokeinterface 190 2 0
    //   280: pop
    //   281: aload 11
    //   283: aload 12
    //   285: invokevirtual 191	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   288: getfield 195	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   291: aload 14
    //   293: iconst_3
    //   294: iconst_0
    //   295: invokevirtual 199	com/tencent/mm/plugin/sns/ad/d/u$a:q	(Ljava/lang/String;Ljava/lang/String;II)Lcom/tencent/mm/plugin/sns/ad/d/u$a;
    //   298: pop
    //   299: aload 9
    //   301: aload 14
    //   303: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 321
    //   309: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 29
    //   315: new 124	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 323
    //   322: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload 14
    //   327: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 325
    //   333: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 13
    //   338: getfield 319	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   341: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 327
    //   347: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 7
    //   352: invokevirtual 136	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   355: ldc 146
    //   357: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 12
    //   362: getfield 116	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureTime	I
    //   365: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: ldc 138
    //   370: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 12
    //   375: getfield 141	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureCount	I
    //   378: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: ldc_w 329
    //   384: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 4
    //   389: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: iload_1
    //   399: istore_0
    //   400: aload 8
    //   402: invokeinterface 202 1 0
    //   407: ifne -209 -> 198
    //   410: iload_1
    //   411: istore_0
    //   412: ldc 29
    //   414: new 124	java/lang/StringBuilder
    //   417: dup
    //   418: ldc_w 331
    //   421: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   424: aload 9
    //   426: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 223
    //   434: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 10
    //   439: invokeinterface 212 1 0
    //   444: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: ldc_w 333
    //   450: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: iload_0
    //   454: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload 8
    //   465: ifnull +10 -> 475
    //   468: aload 8
    //   470: invokeinterface 208 1 0
    //   475: aload 11
    //   477: invokevirtual 205	com/tencent/mm/plugin/sns/ad/d/u$a:report	()V
    //   480: aload 10
    //   482: invokeinterface 228 1 0
    //   487: ifne +186 -> 673
    //   490: aload 10
    //   492: invokeinterface 232 1 0
    //   497: astore 8
    //   499: aload 8
    //   501: invokeinterface 237 1 0
    //   506: ifeq +160 -> 666
    //   509: aload 8
    //   511: invokeinterface 241 1 0
    //   516: checkcast 180	java/lang/Long
    //   519: invokevirtual 244	java/lang/Long:longValue	()J
    //   522: iconst_5
    //   523: invokestatic 252	com/tencent/mm/plugin/sns/model/a:av	(JI)V
    //   526: goto -27 -> 499
    //   529: astore 8
    //   531: ldc 29
    //   533: new 124	java/lang/StringBuilder
    //   536: dup
    //   537: ldc_w 335
    //   540: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: aload 8
    //   545: invokevirtual 338	java/lang/Throwable:toString	()Ljava/lang/String;
    //   548: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: ldc_w 296
    //   560: invokestatic 294	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: return
    //   564: astore 12
    //   566: ldc 29
    //   568: new 124	java/lang/StringBuilder
    //   571: dup
    //   572: ldc_w 340
    //   575: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   578: aload 12
    //   580: invokevirtual 338	java/lang/Throwable:toString	()Ljava/lang/String;
    //   583: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: goto -194 -> 398
    //   595: astore 9
    //   597: ldc 29
    //   599: new 124	java/lang/StringBuilder
    //   602: dup
    //   603: ldc_w 342
    //   606: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   609: aload 9
    //   611: invokevirtual 338	java/lang/Throwable:toString	()Ljava/lang/String;
    //   614: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 8
    //   625: ifnull -150 -> 475
    //   628: aload 8
    //   630: invokeinterface 208 1 0
    //   635: goto -160 -> 475
    //   638: astore 8
    //   640: goto -165 -> 475
    //   643: astore 9
    //   645: aload 8
    //   647: ifnull +10 -> 657
    //   650: aload 8
    //   652: invokeinterface 208 1 0
    //   657: ldc_w 296
    //   660: invokestatic 294	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   663: aload 9
    //   665: athrow
    //   666: aload 10
    //   668: invokeinterface 291 1 0
    //   673: ldc_w 296
    //   676: invokestatic 294	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   679: return
    //   680: astore 8
    //   682: goto -207 -> 475
    //   685: astore 8
    //   687: goto -30 -> 657
    //   690: astore 9
    //   692: aconst_null
    //   693: astore 8
    //   695: goto -98 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   89	365	0	i	int
    //   3	408	1	j	int
    //   1	189	2	k	int
    //   87	4	3	m	int
    //   79	309	4	n	int
    //   17	24	5	l	long
    //   180	171	7	bool	boolean
    //   155	355	8	localObject1	Object
    //   529	100	8	localObject2	Object
    //   638	13	8	localObject3	Object
    //   680	1	8	localObject4	Object
    //   685	1	8	localObject5	Object
    //   693	1	8	localObject6	Object
    //   164	261	9	localStringBuilder	StringBuilder
    //   595	15	9	localObject7	Object
    //   643	21	9	localObject8	Object
    //   690	1	9	localObject9	Object
    //   135	532	10	localArrayList	ArrayList
    //   144	332	11	locala	u.a
    //   209	165	12	localAdSnsInfo	AdSnsInfo
    //   564	15	12	localObject10	Object
    //   223	114	13	localADInfo	ADInfo
    //   240	86	14	str	String
    // Exception table:
    //   from	to	target	type
    //   480	499	529	finally
    //   499	526	529	finally
    //   666	673	529	finally
    //   202	260	564	finally
    //   265	313	564	finally
    //   313	398	564	finally
    //   157	166	595	finally
    //   173	182	595	finally
    //   400	410	595	finally
    //   412	463	595	finally
    //   566	592	595	finally
    //   628	635	638	finally
    //   597	623	643	finally
    //   468	475	680	finally
    //   650	657	685	finally
    //   146	157	690	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.d
 * JD-Core Version:    0.7.0.1
 */