package com.tencent.mm.plugin.sns.ad.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static long DsD;
  
  public static void G(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(201887);
    ArrayList localArrayList = new ArrayList();
    long l2;
    int j;
    Cursor localCursor;
    l.a locala;
    if (paramInt1 != paramInt2)
    {
      l2 = System.currentTimeMillis();
      if (paramInt2 == 0)
      {
        Log.e("AdExpireDeleteHelper", "query startTime==0");
        h.CyF.dN(1612, 1);
      }
      eWJ();
      int k = 0;
      j = 0;
      localCursor = aj.faR().iG(paramInt1, paramInt2);
      i = k;
      if (localCursor != null)
      {
        i = k;
        if (localCursor.moveToFirst()) {
          locala = new l.a();
        }
      }
    }
    label673:
    for (int i = j;; i = j)
    {
      long l1;
      if (i >= 20)
      {
        Log.i("AdExpireDeleteHelper", "reach max count:".concat(String.valueOf(i)));
        locala.report();
        if (localCursor != null) {
          localCursor.close();
        }
        l1 = System.currentTimeMillis();
        j = localArrayList.size();
        Log.i("AdExpireDeleteHelper", "checkExpireAd, topAdTime=" + paramInt1 + ", belowAdTime=" + paramInt2 + ", adCount=" + i + ", delCount=" + j + ", timeCost=" + (l1 - l2));
        if (!localArrayList.isEmpty())
        {
          paramString = localArrayList.iterator();
          while (paramString.hasNext())
          {
            l1 = ((Long)paramString.next()).longValue();
            Log.i("AdExpireDeleteHelper", "deleteAdWithNoCheck, id=" + r.Jb(l1));
            com.tencent.mm.plugin.sns.model.a.U(l1, 1);
          }
        }
      }
      else
      {
        j = i + 1;
        Object localObject1 = new AdSnsInfo();
        ((AdSnsInfo)localObject1).convertFrom(localCursor);
        SnsInfo localSnsInfo = ((AdSnsInfo)localObject1).convertToSnsInfo();
        String str = r.Jb(localSnsInfo.field_snsId);
        l1 = 21600L;
        Object localObject2 = localSnsInfo.getAdInfo();
        i = localSnsInfo.field_createTime;
        boolean bool = ((AdSnsInfo)localObject1).isExposured();
        if (localObject2 != null)
        {
          if (bool)
          {
            l1 = ((ADInfo)localObject2).exposureNoActionExpireTime * 60L;
            i = ((AdSnsInfo)localObject1).field_exposureTime;
          }
        }
        else
        {
          label375:
          long l3 = Util.secondsToNow(i);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("expire check, snsId=").append(str).append(", isExposured=").append(bool).append(", exposureCnt=").append(((AdSnsInfo)localObject1).field_exposureCount).append(", exposureTime=").append(l1).append(", field_createTime=").append(localSnsInfo.field_createTime).append(", checktime=").append(l3).append(", gettime=").append(i).append(", exposureTime=").append(((AdSnsInfo)localObject1).field_exposureTime).append(", adCreateTIme=").append(((AdSnsInfo)localObject1).field_createAdTime);
          Log.i("AdExpireDeleteHelper", ((StringBuilder)localObject2).toString());
          if ((l3 < l1) || (k.a(an.C(localSnsInfo), paramString))) {
            break label600;
          }
          localArrayList.add(Long.valueOf(localSnsInfo.field_snsId));
          if (!bool) {
            locala.m(((AdSnsInfo)localObject1).getAdInfo().uxInfo, str, 2, 0);
          }
        }
        for (;;)
        {
          if (localCursor.moveToNext()) {
            break label673;
          }
          i = j;
          break;
          l1 = ((ADInfo)localObject2).noExposureExpireTime * 60L;
          i = ((AdSnsInfo)localObject1).field_createAdTime;
          break label375;
          label600:
          if (localSnsInfo != null)
          {
            l1 = localSnsInfo.field_snsId;
            if (m.Jg(l1))
            {
              localObject1 = new m(l1, 1, localSnsInfo.getAdInfo().adInfoSyncBuffer);
              g.aAi();
              g.aAg().hqi.a((q)localObject1, 0);
            }
          }
        }
        localArrayList.clear();
      }
      AppMethodBeat.o(201887);
      return;
    }
  }
  
  /* Error */
  private static void eWJ()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: ldc_w 309
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   11: getstatic 311	com/tencent/mm/plugin/sns/ad/e/a:DsD	J
    //   14: lsub
    //   15: lstore_3
    //   16: lload_3
    //   17: ldc2_w 312
    //   20: lcmp
    //   21: ifge +44 -> 65
    //   24: ldc 29
    //   26: new 99	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 315
    //   33: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: lload_3
    //   37: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   40: ldc_w 317
    //   43: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 311	com/tencent/mm/plugin/sns/ad/e/a:DsD	J
    //   49: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   52: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: ldc_w 309
    //   61: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: invokestatic 27	java/lang/System:currentTimeMillis	()J
    //   68: putstatic 311	com/tencent/mm/plugin/sns/ad/e/a:DsD	J
    //   71: invokestatic 325	com/tencent/mm/model/cl:aWB	()I
    //   74: istore_2
    //   75: iload_2
    //   76: ldc_w 326
    //   79: isub
    //   80: istore_1
    //   81: iload_1
    //   82: ifge +661 -> 743
    //   85: ldc 29
    //   87: new 99	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 328
    //   94: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: iload_2
    //   98: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 110
    //   103: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_0
    //   107: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: new 17	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 21	java/util/ArrayList:<init>	()V
    //   123: astore 9
    //   125: new 70	com/tencent/mm/plugin/sns/ad/e/l$a
    //   128: dup
    //   129: invokespecial 71	com/tencent/mm/plugin/sns/ad/e/l$a:<init>	()V
    //   132: astore 10
    //   134: aconst_null
    //   135: astore 6
    //   137: aconst_null
    //   138: astore 7
    //   140: invokestatic 56	com/tencent/mm/plugin/sns/model/aj:faR	()Lcom/tencent/mm/plugin/sns/storage/c;
    //   143: iload_2
    //   144: iload_0
    //   145: invokevirtual 62	com/tencent/mm/plugin/sns/storage/c:iG	(II)Landroid/database/Cursor;
    //   148: astore 8
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: astore 6
    //   158: new 99	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   165: astore 11
    //   167: aload 8
    //   169: ifnull +285 -> 454
    //   172: aload 8
    //   174: astore 7
    //   176: aload 8
    //   178: astore 6
    //   180: aload 8
    //   182: invokeinterface 68 1 0
    //   187: istore 5
    //   189: iload 5
    //   191: ifeq +263 -> 454
    //   194: iload_2
    //   195: ifle +259 -> 454
    //   198: aload 8
    //   200: astore 6
    //   202: new 163	com/tencent/mm/plugin/sns/storage/AdSnsInfo
    //   205: dup
    //   206: invokespecial 164	com/tencent/mm/plugin/sns/storage/AdSnsInfo:<init>	()V
    //   209: astore 7
    //   211: aload 8
    //   213: astore 6
    //   215: aload 7
    //   217: aload 8
    //   219: invokevirtual 168	com/tencent/mm/plugin/sns/storage/AdSnsInfo:convertFrom	(Landroid/database/Cursor;)V
    //   222: aload 8
    //   224: astore 6
    //   226: aload 7
    //   228: invokevirtual 252	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   231: astore 12
    //   233: aload 8
    //   235: astore 6
    //   237: aload 7
    //   239: invokevirtual 190	com/tencent/mm/plugin/sns/storage/AdSnsInfo:isExposured	()Z
    //   242: istore 5
    //   244: aload 8
    //   246: astore 6
    //   248: aload 7
    //   250: getfield 329	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_snsId	J
    //   253: invokestatic 155	com/tencent/mm/plugin/sns/data/r:Jb	(J)Ljava/lang/String;
    //   256: astore 13
    //   258: aload 8
    //   260: astore 6
    //   262: aload 12
    //   264: getfield 332	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   267: ifle +81 -> 348
    //   270: aload 8
    //   272: astore 6
    //   274: aload 12
    //   276: getfield 332	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   279: iload_2
    //   280: if_icmpge +68 -> 348
    //   283: iload 5
    //   285: ifne +63 -> 348
    //   288: aload 8
    //   290: astore 6
    //   292: aload 9
    //   294: aload 7
    //   296: getfield 329	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_snsId	J
    //   299: invokestatic 247	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   302: invokeinterface 251 2 0
    //   307: pop
    //   308: aload 8
    //   310: astore 6
    //   312: aload 10
    //   314: aload 7
    //   316: invokevirtual 252	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   319: getfield 256	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   322: aload 13
    //   324: iconst_3
    //   325: iconst_0
    //   326: invokevirtual 260	com/tencent/mm/plugin/sns/ad/e/l$a:m	(Ljava/lang/String;Ljava/lang/String;II)Lcom/tencent/mm/plugin/sns/ad/e/l$a;
    //   329: pop
    //   330: aload 8
    //   332: astore 6
    //   334: aload 11
    //   336: aload 13
    //   338: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 334
    //   344: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 8
    //   350: astore 6
    //   352: ldc 29
    //   354: new 99	java/lang/StringBuilder
    //   357: dup
    //   358: ldc_w 336
    //   361: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: aload 13
    //   366: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 338
    //   372: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 12
    //   377: getfield 332	com/tencent/mm/plugin/sns/storage/ADInfo:contractAdEndTime	I
    //   380: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc_w 340
    //   386: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 5
    //   391: invokevirtual 214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: ldc 221
    //   396: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 7
    //   401: getfield 200	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureTime	I
    //   404: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: ldc 216
    //   409: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 7
    //   414: getfield 219	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureCount	I
    //   417: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc_w 342
    //   423: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: iload_2
    //   427: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload 8
    //   438: astore 7
    //   440: aload 8
    //   442: astore 6
    //   444: aload 8
    //   446: invokeinterface 263 1 0
    //   451: ifne -253 -> 198
    //   454: aload 8
    //   456: astore 7
    //   458: aload 8
    //   460: astore 6
    //   462: ldc 29
    //   464: new 99	java/lang/StringBuilder
    //   467: dup
    //   468: ldc_w 344
    //   471: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: aload 11
    //   476: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 346
    //   485: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 9
    //   490: invokeinterface 97 1 0
    //   495: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 8
    //   506: ifnull +10 -> 516
    //   509: aload 8
    //   511: invokeinterface 91 1 0
    //   516: aload 10
    //   518: invokevirtual 88	com/tencent/mm/plugin/sns/ad/e/l$a:report	()V
    //   521: aload 9
    //   523: invokeinterface 129 1 0
    //   528: ifne +198 -> 726
    //   531: aload 9
    //   533: invokeinterface 133 1 0
    //   538: astore 6
    //   540: aload 6
    //   542: invokeinterface 138 1 0
    //   547: ifeq +172 -> 719
    //   550: aload 6
    //   552: invokeinterface 142 1 0
    //   557: checkcast 144	java/lang/Long
    //   560: invokevirtual 147	java/lang/Long:longValue	()J
    //   563: iconst_5
    //   564: invokestatic 161	com/tencent/mm/plugin/sns/model/a:U	(JI)V
    //   567: goto -27 -> 540
    //   570: astore 6
    //   572: ldc 29
    //   574: new 99	java/lang/StringBuilder
    //   577: dup
    //   578: ldc_w 348
    //   581: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   584: aload 6
    //   586: invokevirtual 349	java/lang/Throwable:toString	()Ljava/lang/String;
    //   589: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: ldc_w 309
    //   601: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: return
    //   605: astore 12
    //   607: aload 8
    //   609: astore 7
    //   611: aload 8
    //   613: astore 6
    //   615: ldc 29
    //   617: new 99	java/lang/StringBuilder
    //   620: dup
    //   621: ldc_w 351
    //   624: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   627: aload 12
    //   629: invokevirtual 349	java/lang/Throwable:toString	()Ljava/lang/String;
    //   632: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: goto -205 -> 436
    //   644: astore 8
    //   646: aload 7
    //   648: astore 6
    //   650: ldc 29
    //   652: new 99	java/lang/StringBuilder
    //   655: dup
    //   656: ldc_w 353
    //   659: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   662: aload 8
    //   664: invokevirtual 349	java/lang/Throwable:toString	()Ljava/lang/String;
    //   667: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 7
    //   678: ifnull -162 -> 516
    //   681: aload 7
    //   683: invokeinterface 91 1 0
    //   688: goto -172 -> 516
    //   691: astore 6
    //   693: goto -177 -> 516
    //   696: astore 7
    //   698: aload 6
    //   700: ifnull +10 -> 710
    //   703: aload 6
    //   705: invokeinterface 91 1 0
    //   710: ldc_w 309
    //   713: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: aload 7
    //   718: athrow
    //   719: aload 9
    //   721: invokeinterface 302 1 0
    //   726: ldc_w 309
    //   729: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   732: return
    //   733: astore 6
    //   735: goto -219 -> 516
    //   738: astore 6
    //   740: goto -30 -> 710
    //   743: iload_1
    //   744: istore_0
    //   745: goto -660 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	744	0	i	int
    //   80	664	1	j	int
    //   74	353	2	k	int
    //   15	22	3	l	long
    //   187	203	5	bool	boolean
    //   135	416	6	localObject1	Object
    //   570	15	6	localThrowable1	java.lang.Throwable
    //   613	36	6	localObject2	Object
    //   691	13	6	localThrowable2	java.lang.Throwable
    //   733	1	6	localThrowable3	java.lang.Throwable
    //   738	1	6	localThrowable4	java.lang.Throwable
    //   138	544	7	localObject3	Object
    //   696	21	7	localObject4	Object
    //   148	464	8	localCursor	Cursor
    //   644	19	8	localThrowable5	java.lang.Throwable
    //   123	597	9	localArrayList	ArrayList
    //   132	385	10	locala	l.a
    //   165	310	11	localStringBuilder	StringBuilder
    //   231	145	12	localADInfo	ADInfo
    //   605	23	12	localThrowable6	java.lang.Throwable
    //   256	109	13	str	String
    // Exception table:
    //   from	to	target	type
    //   521	540	570	java/lang/Throwable
    //   540	567	570	java/lang/Throwable
    //   719	726	570	java/lang/Throwable
    //   202	211	605	java/lang/Throwable
    //   215	222	605	java/lang/Throwable
    //   226	233	605	java/lang/Throwable
    //   237	244	605	java/lang/Throwable
    //   248	258	605	java/lang/Throwable
    //   262	270	605	java/lang/Throwable
    //   274	283	605	java/lang/Throwable
    //   292	308	605	java/lang/Throwable
    //   312	330	605	java/lang/Throwable
    //   334	348	605	java/lang/Throwable
    //   352	436	605	java/lang/Throwable
    //   140	150	644	java/lang/Throwable
    //   158	167	644	java/lang/Throwable
    //   180	189	644	java/lang/Throwable
    //   444	454	644	java/lang/Throwable
    //   462	504	644	java/lang/Throwable
    //   615	641	644	java/lang/Throwable
    //   681	688	691	java/lang/Throwable
    //   140	150	696	finally
    //   158	167	696	finally
    //   180	189	696	finally
    //   202	211	696	finally
    //   215	222	696	finally
    //   226	233	696	finally
    //   237	244	696	finally
    //   248	258	696	finally
    //   262	270	696	finally
    //   274	283	696	finally
    //   292	308	696	finally
    //   312	330	696	finally
    //   334	348	696	finally
    //   352	436	696	finally
    //   444	454	696	finally
    //   462	504	696	finally
    //   615	641	696	finally
    //   650	676	696	finally
    //   509	516	733	java/lang/Throwable
    //   703	710	738	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.a
 * JD-Core Version:    0.7.0.1
 */