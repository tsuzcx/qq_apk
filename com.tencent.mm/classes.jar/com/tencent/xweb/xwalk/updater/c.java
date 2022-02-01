package com.tencent.xweb.xwalk.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.b.a;
import com.tencent.xweb.internal.b.d;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.util.i;
import com.tencent.xweb.util.i.a;
import com.tencent.xweb.util.l;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWalkUpdateConfigUtil;

public abstract class c
{
  public static boolean aiqp = false;
  protected String TAG = kjo() + "Scheduler";
  protected boolean aiqq = false;
  protected d aiqr;
  
  private static boolean BA(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static long a(b.a parama, String paramString)
  {
    long l1 = 0L;
    if (!TextUtils.isEmpty(parama.aiiF))
    {
      l1 = b(parama, paramString);
      XWalkEnvironment.addXWalkInitializeLog(paramString, "has scheduler, schedule after " + l1 / 60L / 1000L + " minutes to update");
      return l1 + System.currentTimeMillis();
    }
    if (parama.aiiI > 0)
    {
      long l2 = parama.aiiI * 60 * 1000;
      if (0L == l2)
      {
        Log.w(paramString, "getUpdateTimeFromPeriod, invalid period");
        XWalkEnvironment.addXWalkInitializeLog(paramString, "has period, schedule after " + l1 / 60L / 1000L + " minutes to update");
        return l1 + System.currentTimeMillis();
      }
      int i;
      if ((parama.aiiB.aijj > 0) && (parama.aiiB.aijj <= 10000))
      {
        i = parama.aiiB.aijj;
        label168:
        if ((parama.aiiB.aijk <= 0) || (parama.aiiB.aijk > 10000)) {
          break label274;
        }
      }
      label274:
      for (int j = parama.aiiB.aijk;; j = 10000)
      {
        int k = j - i + 1;
        j = k;
        if (k <= 0) {
          j = 1;
        }
        double d = (XWalkGrayValueUtil.getGrayValue() - i) * l2 / j;
        l1 = ((l2 * (XWalkGrayValueUtil.getGrayValue() + 1 - i) / j - d) * Math.random() + d);
        break;
        i = 0;
        break label168;
      }
    }
    XWalkEnvironment.addXWalkInitializeLog(paramString, "no schedule time, return 100");
    return 100L;
  }
  
  private void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      paramEditor.putLong("nTimeToUpdate", System.currentTimeMillis() + paramInt * 7200000L);
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "resetNextUpdateTime, update after " + paramInt * 7200000L / 60000L + " minutes");
      return;
    }
    finally
    {
      paramEditor = finally;
      throw paramEditor;
    }
  }
  
  private boolean a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.aiqq = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    String[] arrayOfString;
    if (!TextUtils.isEmpty(kjY().aiiP))
    {
      localObject = kjY().aiiP;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        arrayOfString = ((String)localObject).split(";");
        if ((arrayOfString != null) && (arrayOfString.length != 0)) {
          break label303;
        }
        this.aiqq = true;
      }
      if (this.aiqq)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isMatchTimeRangeBind, parse range schedule config failed");
        l.y(903L, kjp() + 163, 1L);
      }
      localObject = localArrayList.iterator();
    }
    label303:
    label311:
    label568:
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label570;
      }
      a locala = (a)((Iterator)localObject).next();
      int i;
      if ((paramDouble2 > locala.aiqs.aikh) || (paramDouble2 < locala.aiqs.aikg)) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label568;
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isMatchTimeRangeBind, matched time range zone, currentHour:" + paramDouble1 + " scheduleHour:" + paramDouble2 + ", timeRange:" + new StringBuilder("[ ").append(locala.aiqs.aikg).append(",").append(locala.aiqs.aikh).append("] => [").append(locala.aiqt.aikg).append(",").append(locala.aiqt.aikh).append("], scale=").append(locala.x(paramDouble1, paramDouble2)).toString());
        return true;
        localObject = kjq();
        break;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          localObject = arrayOfString[i];
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            locala = new a();
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label372;
            }
            localObject = null;
            label353:
            if (localObject != null) {
              break label488;
            }
            this.aiqq = true;
          }
        }
        for (;;)
        {
          i += 1;
          break label311;
          break;
          label372:
          localObject = ((String)localObject).trim().replace("=>", "_").split("_");
          if ((localObject == null) || (localObject.length != 2))
          {
            Log.e("Scheduler", "strRanges error");
            localObject = null;
            break label353;
          }
          locala.aiqs = j.bHR(localObject[0]);
          if (locala.aiqs == null)
          {
            Log.e("Scheduler", "parse rangeFrom failed");
            localObject = null;
            break label353;
          }
          locala.aiqt = j.bHR(localObject[1]);
          localObject = locala;
          if (locala.aiqt != null) {
            break label353;
          }
          Log.e("Scheduler", "parse rangeTo failed");
          localObject = null;
          break label353;
          label488:
          localArrayList.add(localObject);
        }
        if ((paramDouble1 > locala.aiqt.aikh) || (paramDouble1 < locala.aiqt.aikg)) {
          i = 0;
        } else if (XWalkGrayValueUtil.getTodayGrayValueByKey("DOWNLOAD_SCHEDULE") <= locala.x(paramDouble1, paramDouble2) * 10000.0D * paramDouble3) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    label570:
    return false;
  }
  
  public static double ag(double paramDouble)
  {
    double d;
    if (paramDouble >= 0.0D)
    {
      d = paramDouble;
      if (paramDouble <= 24.0D) {}
    }
    else
    {
      d = 0.0D;
    }
    return d;
  }
  
  public static double b(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble1 > paramDouble3) || (paramDouble3 < paramDouble2))
    {
      Log.e("Scheduler", "getRandomTime, currentHour is bigger than endHour");
      return 0.0D;
    }
    if (paramDouble2 < paramDouble1) {}
    for (;;)
    {
      return Math.random() * (paramDouble3 - paramDouble1) + paramDouble1;
      paramDouble1 = paramDouble2;
    }
  }
  
  /* Error */
  private static long b(b.a parama, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/xweb/internal/b$a:aiiF	Ljava/lang/String;
    //   4: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +26 -> 33
    //   10: aconst_null
    //   11: astore 13
    //   13: aload 13
    //   15: ifnull +9 -> 24
    //   18: aload 13
    //   20: arraylength
    //   21: ifne +319 -> 340
    //   24: aload_1
    //   25: ldc_w 283
    //   28: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: lconst_0
    //   32: lreturn
    //   33: new 150	java/util/ArrayList
    //   36: dup
    //   37: invokespecial 151	java/util/ArrayList:<init>	()V
    //   40: astore 14
    //   42: aload_0
    //   43: getfield 54	com/tencent/xweb/internal/b$a:aiiF	Ljava/lang/String;
    //   46: ldc_w 288
    //   49: invokevirtual 168	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: astore 13
    //   54: aload 13
    //   56: arraylength
    //   57: istore 11
    //   59: iconst_0
    //   60: istore 10
    //   62: iload 10
    //   64: iload 11
    //   66: if_icmpge +147 -> 213
    //   69: aload 13
    //   71: iload 10
    //   73: aaload
    //   74: astore 15
    //   76: aload 15
    //   78: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +48 -> 129
    //   84: aload 15
    //   86: invokestatic 294	com/tencent/xweb/util/i:bIb	(Ljava/lang/String;)Lcom/tencent/xweb/util/i$a;
    //   89: astore 15
    //   91: aload 15
    //   93: getfield 299	com/tencent/xweb/util/i$a:aimD	Z
    //   96: ifeq +85 -> 181
    //   99: aload 15
    //   101: invokevirtual 302	com/tencent/xweb/util/i$a:intValue	()I
    //   104: istore 12
    //   106: iload 12
    //   108: iflt +30 -> 138
    //   111: iload 12
    //   113: sipush 10000
    //   116: if_icmpgt +22 -> 138
    //   119: aload 14
    //   121: aload 15
    //   123: invokeinterface 266 2 0
    //   128: pop
    //   129: iload 10
    //   131: iconst_1
    //   132: iadd
    //   133: istore 10
    //   135: goto -73 -> 62
    //   138: ldc_w 304
    //   141: new 24	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 306
    //   148: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: iload 12
    //   153: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 311
    //   159: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: getfield 54	com/tencent/xweb/internal/b$a:aiiF	Ljava/lang/String;
    //   166: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 254	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aconst_null
    //   176: astore 13
    //   178: goto -165 -> 13
    //   181: ldc_w 304
    //   184: new 24	java/lang/StringBuilder
    //   187: dup
    //   188: ldc_w 313
    //   191: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: getfield 54	com/tencent/xweb/internal/b$a:aiiF	Ljava/lang/String;
    //   198: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 254	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aconst_null
    //   208: astore 13
    //   210: goto -197 -> 13
    //   213: aload 14
    //   215: invokeinterface 316 1 0
    //   220: ifne +9 -> 229
    //   223: aconst_null
    //   224: astore 13
    //   226: goto -213 -> 13
    //   229: aload 14
    //   231: invokeinterface 316 1 0
    //   236: newarray int
    //   238: astore 13
    //   240: iconst_0
    //   241: istore 10
    //   243: iload 10
    //   245: aload 14
    //   247: invokeinterface 316 1 0
    //   252: if_icmpge +85 -> 337
    //   255: aload 14
    //   257: iload 10
    //   259: invokeinterface 320 2 0
    //   264: checkcast 296	com/tencent/xweb/util/i$a
    //   267: invokevirtual 302	com/tencent/xweb/util/i$a:intValue	()I
    //   270: istore 11
    //   272: iload 10
    //   274: ifle +47 -> 321
    //   277: iload 11
    //   279: aload 13
    //   281: iload 10
    //   283: iconst_1
    //   284: isub
    //   285: iaload
    //   286: if_icmpge +35 -> 321
    //   289: ldc_w 304
    //   292: new 24	java/lang/StringBuilder
    //   295: dup
    //   296: ldc_w 322
    //   299: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 54	com/tencent/xweb/internal/b$a:aiiF	Ljava/lang/String;
    //   306: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 254	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aconst_null
    //   316: astore 13
    //   318: goto -305 -> 13
    //   321: aload 13
    //   323: iload 10
    //   325: iload 11
    //   327: iastore
    //   328: iload 10
    //   330: iconst_1
    //   331: iadd
    //   332: istore 10
    //   334: goto -91 -> 243
    //   337: goto -324 -> 13
    //   340: new 324	java/text/SimpleDateFormat
    //   343: dup
    //   344: ldc_w 326
    //   347: invokespecial 327	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   350: astore 15
    //   352: new 329	java/util/Date
    //   355: dup
    //   356: invokespecial 330	java/util/Date:<init>	()V
    //   359: astore 14
    //   361: aload_0
    //   362: getfield 333	com/tencent/xweb/internal/b$a:aiiG	Ljava/lang/String;
    //   365: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   368: ifne +452 -> 820
    //   371: aload 15
    //   373: aload_0
    //   374: getfield 333	com/tencent/xweb/internal/b$a:aiiG	Ljava/lang/String;
    //   377: invokevirtual 337	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   380: astore 15
    //   382: aload 15
    //   384: astore 14
    //   386: new 329	java/util/Date
    //   389: dup
    //   390: invokespecial 330	java/util/Date:<init>	()V
    //   393: invokevirtual 340	java/util/Date:getTime	()J
    //   396: aload 14
    //   398: invokevirtual 340	java/util/Date:getTime	()J
    //   401: lsub
    //   402: l2d
    //   403: ldc2_w 341
    //   406: ddiv
    //   407: dstore_2
    //   408: dload_2
    //   409: d2i
    //   410: istore 11
    //   412: iload 11
    //   414: istore 10
    //   416: dload_2
    //   417: dconst_0
    //   418: dcmpg
    //   419: ifge +9 -> 428
    //   422: iload 11
    //   424: iconst_1
    //   425: isub
    //   426: istore 10
    //   428: dload_2
    //   429: invokestatic 345	java/lang/Math:abs	(D)D
    //   432: ldc2_w 346
    //   435: dcmpl
    //   436: ifle +381 -> 817
    //   439: iconst_0
    //   440: istore 10
    //   442: aload_0
    //   443: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   446: getfield 111	com/tencent/xweb/internal/b$d:aijj	I
    //   449: ifle +141 -> 590
    //   452: aload_0
    //   453: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   456: getfield 111	com/tencent/xweb/internal/b$d:aijj	I
    //   459: sipush 10000
    //   462: if_icmpgt +128 -> 590
    //   465: aload_0
    //   466: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   469: getfield 111	com/tencent/xweb/internal/b$d:aijj	I
    //   472: istore 11
    //   474: aload_0
    //   475: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   478: getfield 114	com/tencent/xweb/internal/b$d:aijk	I
    //   481: ifle +115 -> 596
    //   484: aload_0
    //   485: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   488: getfield 114	com/tencent/xweb/internal/b$d:aijk	I
    //   491: sipush 10000
    //   494: if_icmpgt +102 -> 596
    //   497: aload_0
    //   498: getfield 106	com/tencent/xweb/internal/b$a:aiiB	Lcom/tencent/xweb/internal/b$d;
    //   501: getfield 114	com/tencent/xweb/internal/b$d:aijk	I
    //   504: istore 12
    //   506: invokestatic 120	org/xwalk/core/XWalkGrayValueUtil:getGrayValue	()I
    //   509: iload 11
    //   511: isub
    //   512: i2d
    //   513: ldc2_w 273
    //   516: dmul
    //   517: iload 12
    //   519: iload 11
    //   521: isub
    //   522: iconst_1
    //   523: iadd
    //   524: i2d
    //   525: ddiv
    //   526: dstore 4
    //   528: iconst_0
    //   529: istore 11
    //   531: iload 11
    //   533: aload 13
    //   535: arraylength
    //   536: if_icmpge +68 -> 604
    //   539: dload 4
    //   541: aload 13
    //   543: iload 11
    //   545: iaload
    //   546: i2d
    //   547: dcmpg
    //   548: ifle +56 -> 604
    //   551: iload 11
    //   553: iconst_1
    //   554: iadd
    //   555: istore 11
    //   557: goto -26 -> 531
    //   560: astore 15
    //   562: aload_1
    //   563: ldc_w 349
    //   566: aload 15
    //   568: invokestatic 353	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   571: invokevirtual 357	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   574: invokestatic 83	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: ldc2_w 171
    //   580: ldc2_w 358
    //   583: lconst_1
    //   584: invokestatic 181	com/tencent/xweb/util/l:y	(JJJ)V
    //   587: goto -201 -> 386
    //   590: iconst_0
    //   591: istore 11
    //   593: goto -119 -> 474
    //   596: sipush 10000
    //   599: istore 12
    //   601: goto -95 -> 506
    //   604: invokestatic 362	com/tencent/xweb/util/i:khC	()D
    //   607: dstore_2
    //   608: aload_0
    //   609: getfield 366	com/tencent/xweb/internal/b$a:aiiD	F
    //   612: f2d
    //   613: invokestatic 368	com/tencent/xweb/xwalk/updater/c:ag	(D)D
    //   616: dstore 6
    //   618: aload_0
    //   619: getfield 366	com/tencent/xweb/internal/b$a:aiiD	F
    //   622: f2d
    //   623: aload_0
    //   624: getfield 371	com/tencent/xweb/internal/b$a:aiiE	F
    //   627: f2d
    //   628: invokestatic 373	com/tencent/xweb/xwalk/updater/c:w	(DD)D
    //   631: dstore 8
    //   633: iload 11
    //   635: iload 10
    //   637: isub
    //   638: istore 10
    //   640: aload_1
    //   641: new 24	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 375
    //   648: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload 14
    //   653: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   656: ldc_w 380
    //   659: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: dload 4
    //   664: invokevirtual 215	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   667: ldc_w 382
    //   670: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: iload 10
    //   675: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: iload 10
    //   686: ifgt +128 -> 814
    //   689: aload_0
    //   690: getfield 385	com/tencent/xweb/internal/b$a:aiiM	Z
    //   693: ifeq +66 -> 759
    //   696: dload_2
    //   697: dload 6
    //   699: dcmpl
    //   700: ifle +59 -> 759
    //   703: aload_1
    //   704: ldc_w 387
    //   707: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: iconst_1
    //   711: istore 10
    //   713: dconst_0
    //   714: dload 6
    //   716: dload 8
    //   718: invokestatic 389	com/tencent/xweb/xwalk/updater/c:b	(DDD)D
    //   721: dstore_2
    //   722: aload_1
    //   723: ldc_w 391
    //   726: dload_2
    //   727: invokestatic 394	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   730: invokevirtual 357	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   733: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: dload_2
    //   737: ldc2_w 395
    //   740: dmul
    //   741: ldc2_w 397
    //   744: iload 10
    //   746: iconst_1
    //   747: isub
    //   748: i2l
    //   749: lmul
    //   750: l2d
    //   751: dadd
    //   752: invokestatic 401	com/tencent/xweb/util/i:khB	()J
    //   755: l2d
    //   756: dadd
    //   757: d2l
    //   758: lreturn
    //   759: dload_2
    //   760: dload 8
    //   762: dcmpl
    //   763: iflt +16 -> 779
    //   766: aload_1
    //   767: ldc_w 403
    //   770: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: iconst_1
    //   774: istore 10
    //   776: goto -63 -> 713
    //   779: dload_2
    //   780: dload 6
    //   782: dload 8
    //   784: invokestatic 389	com/tencent/xweb/xwalk/updater/c:b	(DDD)D
    //   787: dstore 4
    //   789: aload_1
    //   790: ldc_w 405
    //   793: dload 4
    //   795: invokestatic 394	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   798: invokevirtual 357	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   801: invokestatic 286	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: dload 4
    //   806: dload_2
    //   807: dsub
    //   808: ldc2_w 395
    //   811: dmul
    //   812: d2l
    //   813: lreturn
    //   814: goto -101 -> 713
    //   817: goto -375 -> 442
    //   820: goto -434 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	parama	b.a
    //   0	823	1	paramString	String
    //   407	400	2	d1	double
    //   526	279	4	d2	double
    //   616	165	6	d3	double
    //   631	152	8	d4	double
    //   60	715	10	i	int
    //   57	581	11	j	int
    //   104	496	12	k	int
    //   11	531	13	localObject1	Object
    //   40	612	14	localObject2	Object
    //   74	309	15	localObject3	Object
    //   560	7	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   361	382	560	finally
  }
  
  private static String[] bIs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split(";");
  }
  
  private boolean bP(long paramLong1, long paramLong2)
  {
    long l = kjW();
    if ((paramLong1 > paramLong2 + l) || (l + paramLong1 < paramLong2)) {
      return true;
    }
    XWalkEnvironment.addXWalkInitializeLog(this.TAG, "checkNeedFetchConfig, no need");
    return false;
  }
  
  protected static boolean jH(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return true;
      if (paramString1 != null) {
        break;
      }
    } while (paramString1 == paramString2);
    return false;
    return paramString1.equals(paramString2);
  }
  
  public static long kjW()
  {
    long l1 = a.keX().aU("force_cmd_period", "tools", 0) * 60000L;
    if (BA(l1)) {}
    long l2;
    do
    {
      do
      {
        return l1;
        l2 = XWalkUpdateConfigUtil.getBaseConfigUpdatePeriod();
        l1 = l2;
      } while (BA(l2));
      l2 = a.keX().kfg();
      l1 = l2;
    } while (BA(l2));
    return 86400000L;
  }
  
  public static boolean v(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 0.0D) || (paramDouble1 > 24.0D)) {}
    while ((paramDouble2 < 0.0D) || (paramDouble2 > 24.0D) || (paramDouble2 < paramDouble1)) {
      return false;
    }
    return true;
  }
  
  public static double w(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 < paramDouble1) {
      paramDouble1 = 24.0D;
    }
    do
    {
      return paramDouble1;
      if (paramDouble2 < 0.0D) {
        break;
      }
      paramDouble1 = paramDouble2;
    } while (paramDouble2 <= 32.0D);
    return 24.0D;
  }
  
  protected abstract String Pd(boolean paramBoolean);
  
  public boolean Pe(boolean paramBoolean)
  {
    try
    {
      paramBoolean = ay(paramBoolean, 0);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String Pf(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(kjY().aiiO))) {
      return kjY().aiiO;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(kjY().aiiN))) {
      return kjY().aiiN;
    }
    return Pd(paramBoolean);
  }
  
  protected boolean a(d paramd1, d paramd2)
  {
    if ((paramd1.version != paramd2.version) || (paramd1.aiiK != paramd2.aiiK) || (paramd1.aiiL != paramd2.aiiL) || (paramd1.aiqx != paramd2.aiqx) || (paramd1.aiiA != paramd2.aiiA) || (!jH(paramd1.aiiJ, paramd2.aiiJ)) || (!jH(paramd1.aiqA, paramd2.aiqA)) || (!jH(paramd1.strAbi, paramd2.strAbi))) {}
    while ((paramd1.aiqx) && (!jH(paramd1.patchMd5, paramd2.patchMd5))) {
      return false;
    }
    return true;
  }
  
  public void aJR(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo());
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateFailed, shared mode, current nTryUseSharedCoreCount:".concat(String.valueOf(paramInt)));
      paramInt += 1;
      kjY().aiqE = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      Log.w(this.TAG, "onUpdateFailed, network not available");
      return;
    }
    Object localObject = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo());
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt == -3) || (paramInt == -4))
    {
      kjY().aiqx = false;
      kjY().aiiC = kjY().aiqA;
      kjY().aiiK = false;
      e(kjY());
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateFailed, switch to full package update");
      i = j;
    }
    while (i > 3L)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateFailed, failed too many times, abandon current scheduler");
      kjO();
      return;
      i = j;
      if (paramInt <= -2)
      {
        i = j;
        if (paramInt >= -5) {
          i = (int)(j + 3L);
        }
      }
    }
    kjY().aiqD = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean ay(boolean paramBoolean, int paramInt)
  {
    if (paramInt > 2) {}
    for (;;)
    {
      label388:
      label441:
      try
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate, abort because depth > 2");
        paramBoolean = false;
        return paramBoolean;
      }
      finally {}
      if (!kjQ())
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate, abort because no scheduler");
        paramBoolean = false;
      }
      else if ((kkb()) || (aiqp))
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate, force update");
        l.y(903L, kjp() + 157, 1L);
        paramBoolean = true;
      }
      else
      {
        Object localObject1 = a.keX().qM("DELAY_UPDATE_TIME", "tools");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = i.bIa((String)localObject1);
          if ((((i.a)localObject1).aimD) && (((i.a)localObject1).doubleValue() >= 0.0D) && (((i.a)localObject1).doubleValue() <= 24.0D)) {
            ((i.a)localObject1).doubleValue();
          }
        }
        long l2 = System.currentTimeMillis();
        double d1 = kjZ();
        if (this.aiqq)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate, parse update speed failed");
          l.y(903L, kjp() + 163, 1L);
        }
        double d2 = kka();
        if (this.aiqq)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate, parse update forward speed failed");
          l.y(903L, kjp() + 163, 1L);
        }
        long l1 = kjY().aiqB;
        int i = 0;
        long l3;
        long l4;
        int j;
        if (l1 <= 1000L)
        {
          if (!paramBoolean)
          {
            paramBoolean = true;
            continue;
          }
          l1 = (3600000.0D * Math.random());
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "no scheduled time, just random a time in one hour");
          l.y(903L, kjp() + 155, 1L);
          l1 = l2 - l1;
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "scheduled time is after " + (l1 - l2) / 60000L + " minutes later");
          l3 = l2 - l1;
          l4 = i.khB();
          long l5 = l4 + l2;
          if (l1 - 180000L >= l5 - 86400000L) {
            break label981;
          }
          j = 1;
          break label912;
          if (i == 0)
          {
            Log.i(this.TAG, "no scheduled time, ignore dangers time");
            if ((l3 < 0L) || (l3 > 3600000L)) {
              break label906;
            }
            bool = true;
            l.y(903L, kjp() + 154, 1L);
            break label955;
            if ((l3 >= 0L) || (-l3 >= d2)) {
              break label898;
            }
            paramBoolean = true;
            l.y(903L, kjp() + 161, 1L);
            if ((bool) && (!paramBoolean)) {
              l.y(903L, kjp() + 150, 1L);
            }
            if ((!bool) && (paramBoolean)) {
              l.y(903L, kjp() + 151, 1L);
            }
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "shouldUpdateDefault = " + bool + ", shouldUpdateFromConfig = " + paramBoolean);
            if (paramBoolean)
            {
              XWalkEnvironment.addXWalkInitializeLog(this.TAG, "time to update");
              l.y(903L, kjp() + 152, 1L);
              paramBoolean = true;
            }
          }
          else
          {
            if (j != 0)
            {
              XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isPastDaySchedule need reschedule to next day");
              kkc();
              l.y(903L, 146L, 1L);
              paramBoolean = ay(false, paramInt + 1);
              continue;
            }
            if (k != 0)
            {
              XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isFutureDaySchedule no need download now");
              l.y(903L, 147L, 1L);
              paramBoolean = false;
              continue;
            }
            if (m == 0) {
              continue;
            }
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "dangerous time do not update");
            l.y(903L, 148L, 1L);
            paramBoolean = false;
            continue;
          }
          if (kjS())
          {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "time to update because in free update time zone");
            l.y(903L, kjp() + 153, 1L);
            paramBoolean = true;
            continue;
          }
          d1 /= 18000000.0D;
          d2 = i.khC();
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(l1);
          paramInt = ((Calendar)localObject1).get(11);
          double d3 = ((Calendar)localObject1).get(12);
          double d4 = paramInt;
          if (a(d2, d3 / 60.0D + d4, d1))
          {
            l.y(903L, kjp() + 162, 1L);
            paramBoolean = true;
            continue;
          }
          if ((i != 0) && (Math.abs(l2 - kjY().aiqB) > 7776000000L))
          {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time has passed");
            kkc();
            l.y(903L, kjp() + 156, 1L);
            break label999;
          }
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "has scheduler waiting for update, but time is not up");
          break label999;
          label898:
          continue;
          label901:
          paramBoolean = false;
          continue;
          label906:
          boolean bool = false;
          break label955;
          label912:
          if (180000L + l1 <= l5) {
            break label987;
          }
        }
        label955:
        label981:
        label987:
        for (int k = 1;; k = 0)
        {
          if ((l4 >= 180000L) && (l4 + 180000L <= 86400000L)) {
            break label993;
          }
          m = 1;
          break label388;
          if ((l3 < 0L) || (l3 >= d1)) {
            break label901;
          }
          paramBoolean = true;
          break label441;
          i = 1;
          break;
          j = 0;
          break label912;
        }
        label993:
        int m = 0;
        continue;
        label999:
        paramBoolean = false;
      }
    }
  }
  
  public double bIt(String paramString)
  {
    return f(paramString, i.khC());
  }
  
  public d d(d paramd)
  {
    int j = 1;
    d locald = kjY();
    if (paramd == null)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, got no schedule need download");
      if (kjQ())
      {
        if (locald != null) {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, clear current scheduler, version:" + locald.version);
        }
        e(null);
      }
      return null;
    }
    int i;
    if (a(paramd, locald))
    {
      i = 0;
      if (!jH(paramd.aiiN, locald.aiiN))
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, update UPDATE_SPEED_CONFIG");
        locald.aiiN = paramd.aiiN;
        i = 1;
      }
      if (!jH(paramd.aiiO, locald.aiiO))
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, update UPDATE_FORWARD_SPEED_CONFIG");
        locald.aiiO = paramd.aiiO;
        i = 1;
      }
      if (jH(paramd.aiiP, locald.aiiP)) {
        break label263;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, update UPDATE_SCHEDULE_TIME_RANGE_BIND");
      locald.aiiP = paramd.aiiP;
      i = j;
    }
    label263:
    for (;;)
    {
      if (i != 0) {
        e(locald);
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, got same scheduler, use current version");
      return locald;
      if (kjQ())
      {
        l.y(903L, 149L, 1L);
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onUpdateScheduleConfig, got newer scheduler, version: " + paramd.version);
      }
      e(paramd);
      return paramd;
    }
  }
  
  public void e(d paramd)
  {
    try
    {
      this.aiqr = paramd;
      if (paramd == null) {
        this.aiqr = new d();
      }
      this.aiqr.aiqu = kjo();
      paramd = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo()).edit();
      paramd.putString("strMd5", this.aiqr.aiiJ);
      paramd.putString("strUrl", this.aiqr.aiiC);
      paramd.putString("strFullPackageUrl", this.aiqr.aiqA);
      paramd.putString("strConfigVer", this.aiqr.aiiU);
      paramd.putBoolean("bIsPatchUpdate", this.aiqr.aiqx);
      paramd.putBoolean("bCanUseCellular", this.aiqr.aiiK);
      paramd.putBoolean("bUseCdn", this.aiqr.aiiL);
      paramd.putLong("nTimeToUpdate", this.aiqr.aiqB);
      paramd.putInt("version", this.aiqr.version);
      paramd.putInt("nTryCnt", this.aiqr.aiqD);
      paramd.putInt("nPatchTargetVersion", this.aiqr.aiqy);
      paramd.putInt("nTryUseSharedCoreCount", this.aiqr.aiqE);
      paramd.putString("patchMd5", this.aiqr.patchMd5);
      paramd.putString("strVersionDetail", this.aiqr.aiqC);
      paramd.putBoolean("bTryUseSharedCore", this.aiqr.aijL);
      paramd.putBoolean("skipSubFileMD5Check", this.aiqr.aiqH);
      paramd.putString("strAbi", this.aiqr.strAbi);
      paramd.putString("path", this.aiqr.path);
      paramd.putInt("versionId", this.aiqr.aiiA);
      paramd.putFloat("timeHourStart", this.aiqr.aiqF);
      paramd.putFloat("timeHourEnd", this.aiqr.aiqG);
      paramd.putString("UPDATE_SPEED_CONFIG", this.aiqr.aiiN);
      paramd.putString("UPDATE_FORWARD_SPEED_CONFIG", this.aiqr.aiiO);
      paramd.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.aiqr.aiiP);
      paramd.commit();
      return;
    }
    finally {}
  }
  
  public double f(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 1.0D;
      paramString = bIs(paramString);
      if ((paramString == null) || (paramString.length == 0))
      {
        this.aiqq = true;
        return 1.0D;
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = j.bHR((String)localObject);
          if ((localObject != null) && (paramDouble >= ((j)localObject).aikg) && (paramDouble <= ((j)localObject).aikh)) {
            return ((j)localObject).ae(paramDouble);
          }
        }
        i += 1;
      }
    }
  }
  
  public void kjO()
  {
    XWalkEnvironment.addXWalkInitializeLog(this.TAG, "abandon current scheduler");
    e(null);
  }
  
  public String kjP()
  {
    if (kjQ())
    {
      Object localObject = new Date(kjY().aiqB);
      StringBuilder localStringBuilder = new StringBuilder().append(this.TAG).append(": has scheduler for ver = ").append(kjY().version).append(" version id = ").append(kjY().aiiA).append(" update time in ").append(((Date)localObject).toString());
      if (!TextUtils.isEmpty(kjY().aiiN))
      {
        localObject = " update speed config:" + kjY().aiiN;
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(kjY().aiiO)) {
          break label221;
        }
        localObject = " update forward speed config:" + kjY().aiiO;
        label162:
        localStringBuilder = localStringBuilder.append((String)localObject);
        if (TextUtils.isEmpty(kjY().aiiP)) {
          break label228;
        }
      }
      label221:
      label228:
      for (localObject = " update time range config:" + kjY().aiiP;; localObject = "")
      {
        return (String)localObject;
        localObject = "";
        break;
        localObject = "";
        break label162;
      }
    }
    return this.TAG + ": has no scheduler";
  }
  
  /* Error */
  public boolean kjQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 155	com/tencent/xweb/xwalk/updater/c:kjY	()Lcom/tencent/xweb/xwalk/updater/d;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: invokevirtual 155	com/tencent/xweb/xwalk/updater/c:kjY	()Lcom/tencent/xweb/xwalk/updater/d;
    //   13: getfield 467	com/tencent/xweb/xwalk/updater/d:version	I
    //   16: ifle +18 -> 34
    //   19: aload_0
    //   20: invokevirtual 155	com/tencent/xweb/xwalk/updater/c:kjY	()Lcom/tencent/xweb/xwalk/updater/d;
    //   23: getfield 542	com/tencent/xweb/xwalk/updater/d:aiiC	Ljava/lang/String;
    //   26: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq +9 -> 40
    //   34: iconst_0
    //   35: istore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: iload_1
    //   39: ireturn
    //   40: iconst_1
    //   41: istore_1
    //   42: goto -6 -> 36
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	c
    //   29	13	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	45	finally
  }
  
  public boolean kjR()
  {
    String[] arrayOfString = bIs(kjr());
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {}
    label109:
    for (;;)
    {
      return false;
      double d = i.khC();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label109;
        }
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = j.bHR((String)localObject);
          if ((localObject != null) && (d >= ((j)localObject).aikg) && (d <= ((j)localObject).aikh))
          {
            if (XWalkGrayValueUtil.getTodayGrayValue() >= 10000.0D * ((j)localObject).XAR) {
              break;
            }
            return true;
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean kjS()
  {
    Object localObject1 = a.keX().qM("free_update_time_zone", "tools");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    double d;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (!((String)localObject1).contains("-"));
            localObject2 = ((String)localObject1).split("-");
          } while ((localObject2 == null) || (localObject2.length != 2));
          localObject1 = i.bIa(localObject2[0]);
        } while (!((i.a)localObject1).aimD);
        localObject2 = i.bIa(localObject2[1]);
      } while ((!((i.a)localObject2).aimD) || (!v(((i.a)localObject1).doubleValue(), ((i.a)localObject2).doubleValue())));
      d = i.khC();
    } while ((d < ((i.a)localObject1).doubleValue()) || (d > ((i.a)localObject2).doubleValue()));
    return true;
  }
  
  public void kjT()
  {
    try
    {
      SharedPreferences.Editor localEditor = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo()).edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      kjY().aiqv = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void kjU()
  {
    try
    {
      SharedPreferences.Editor localEditor = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo()).edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      kjY().aiqv = 0L;
      kjY().aiqB = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void kjV()
  {
    kjY().aiqv = System.currentTimeMillis();
    kjY().aiqw = com.tencent.xweb.util.b.khw();
    SharedPreferences.Editor localEditor = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo()).edit();
    localEditor.putLong("nLastFetchConfigTime", kjY().aiqv);
    localEditor.putString("strLastFetchAbi", kjY().aiqw);
    localEditor.commit();
  }
  
  public boolean kjX()
  {
    boolean bool = true;
    try
    {
      if ((!com.tencent.xweb.util.b.khw().equalsIgnoreCase(kjY().aiqw)) && (!TextUtils.isEmpty(kjY().aiqw)) && (!"true".equalsIgnoreCase(com.tencent.xweb.b.kfi().qM("disable_abi_switch_reset_config_time", "tools"))))
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "checkNeedFetchConfig, disable_abi_switch_reset_config_time is true");
        return bool;
      }
    }
    finally
    {
      for (;;)
      {
        localObject1 = finally;
        try
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "checkNeedFetchConfig, identify abi switch error:".concat(String.valueOf(localObject1)));
          if (kjR())
          {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "checkNeedFetchConfig, in FreeFetchConfigTimeZone");
            continue;
          }
        }
        finally {}
        long l1 = System.currentTimeMillis();
        if (bP(l1, kjY().aiqv))
        {
          long l2 = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForSchduler(kjo()).getLong("nLastFetchConfigTime", 0L);
          kjY().aiqv = l2;
          if (bP(l1, l2))
          {
            XWalkEnvironment.addXWalkInitializeLog(this.TAG, "checkNeedFetchConfig, need fetch config");
            continue;
          }
        }
        bool = false;
      }
    }
  }
  
  /* Error */
  public d kjY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: new 157	com/tencent/xweb/xwalk/updater/d
    //   22: dup
    //   23: invokespecial 693	com/tencent/xweb/xwalk/updater/d:<init>	()V
    //   26: putfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   29: aload_0
    //   30: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   33: aload_0
    //   34: invokevirtual 29	com/tencent/xweb/xwalk/updater/c:kjo	()Ljava/lang/String;
    //   37: putfield 696	com/tencent/xweb/xwalk/updater/d:aiqu	Ljava/lang/String;
    //   40: aload_0
    //   41: invokevirtual 29	com/tencent/xweb/xwalk/updater/c:kjo	()Ljava/lang/String;
    //   44: invokestatic 501	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesForSchduler	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   52: aload_1
    //   53: ldc_w 819
    //   56: lconst_0
    //   57: invokeinterface 864 4 0
    //   62: putfield 822	com/tencent/xweb/xwalk/updater/d:aiqv	J
    //   65: aload_0
    //   66: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   69: aload_1
    //   70: ldc_w 834
    //   73: ldc_w 795
    //   76: invokeinterface 869 3 0
    //   81: putfield 832	com/tencent/xweb/xwalk/updater/d:aiqw	Ljava/lang/String;
    //   84: aload_1
    //   85: ldc_w 704
    //   88: invokeinterface 871 2 0
    //   93: ifne +11 -> 104
    //   96: aload_0
    //   97: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   100: astore_1
    //   101: goto -87 -> 14
    //   104: aload_0
    //   105: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   108: aload_1
    //   109: ldc_w 698
    //   112: ldc_w 795
    //   115: invokeinterface 869 3 0
    //   120: putfield 482	com/tencent/xweb/xwalk/updater/d:aiiJ	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   127: aload_1
    //   128: ldc_w 750
    //   131: iconst_0
    //   132: invokeinterface 509 3 0
    //   137: putfield 479	com/tencent/xweb/xwalk/updater/d:aiiA	I
    //   140: aload_0
    //   141: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   144: aload_1
    //   145: ldc_w 752
    //   148: ldc_w 872
    //   151: invokeinterface 876 3 0
    //   156: putfield 755	com/tencent/xweb/xwalk/updater/d:aiqF	F
    //   159: aload_0
    //   160: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   163: aload_1
    //   164: ldc_w 761
    //   167: ldc_w 872
    //   170: invokeinterface 876 3 0
    //   175: putfield 764	com/tencent/xweb/xwalk/updater/d:aiqG	F
    //   178: aload_0
    //   179: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   182: aload_1
    //   183: ldc_w 704
    //   186: ldc_w 795
    //   189: invokeinterface 869 3 0
    //   194: putfield 542	com/tencent/xweb/xwalk/updater/d:aiiC	Ljava/lang/String;
    //   197: aload_0
    //   198: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   201: aload_1
    //   202: ldc_w 706
    //   205: ldc_w 795
    //   208: invokeinterface 869 3 0
    //   213: putfield 487	com/tencent/xweb/xwalk/updater/d:aiqA	Ljava/lang/String;
    //   216: aload_0
    //   217: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   220: aload_1
    //   221: ldc_w 708
    //   224: ldc_w 795
    //   227: invokeinterface 869 3 0
    //   232: putfield 711	com/tencent/xweb/xwalk/updater/d:aiiU	Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   239: aload_1
    //   240: ldc_w 713
    //   243: iconst_0
    //   244: invokeinterface 880 3 0
    //   249: putfield 476	com/tencent/xweb/xwalk/updater/d:aiqx	Z
    //   252: aload_0
    //   253: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   256: aload_1
    //   257: ldc 133
    //   259: lconst_0
    //   260: invokeinterface 864 4 0
    //   265: putfield 595	com/tencent/xweb/xwalk/updater/d:aiqB	J
    //   268: aload_0
    //   269: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   272: aload_1
    //   273: ldc_w 722
    //   276: iconst_0
    //   277: invokeinterface 509 3 0
    //   282: putfield 467	com/tencent/xweb/xwalk/updater/d:version	I
    //   285: aload_0
    //   286: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   289: aload_1
    //   290: ldc_w 539
    //   293: iconst_0
    //   294: invokeinterface 509 3 0
    //   299: putfield 557	com/tencent/xweb/xwalk/updater/d:aiqD	I
    //   302: aload_0
    //   303: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   306: aload_1
    //   307: ldc_w 724
    //   310: iconst_0
    //   311: invokeinterface 509 3 0
    //   316: putfield 727	com/tencent/xweb/xwalk/updater/d:aiqy	I
    //   319: aload_0
    //   320: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   323: aload_1
    //   324: ldc_w 503
    //   327: iconst_0
    //   328: invokeinterface 509 3 0
    //   333: putfield 517	com/tencent/xweb/xwalk/updater/d:aiqE	I
    //   336: aload_0
    //   337: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   340: aload_1
    //   341: ldc_w 728
    //   344: ldc_w 795
    //   347: invokeinterface 869 3 0
    //   352: putfield 493	com/tencent/xweb/xwalk/updater/d:patchMd5	Ljava/lang/String;
    //   355: aload_0
    //   356: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   359: aload_1
    //   360: ldc_w 730
    //   363: ldc_w 795
    //   366: invokeinterface 869 3 0
    //   371: putfield 733	com/tencent/xweb/xwalk/updater/d:aiqC	Ljava/lang/String;
    //   374: aload_0
    //   375: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   378: aload_1
    //   379: ldc_w 719
    //   382: iconst_0
    //   383: invokeinterface 880 3 0
    //   388: putfield 470	com/tencent/xweb/xwalk/updater/d:aiiK	Z
    //   391: aload_0
    //   392: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   395: aload_1
    //   396: ldc_w 721
    //   399: iconst_0
    //   400: invokeinterface 880 3 0
    //   405: putfield 473	com/tencent/xweb/xwalk/updater/d:aiiL	Z
    //   408: aload_0
    //   409: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   412: aload_1
    //   413: ldc_w 735
    //   416: iconst_1
    //   417: invokeinterface 880 3 0
    //   422: putfield 738	com/tencent/xweb/xwalk/updater/d:aijL	Z
    //   425: aload_0
    //   426: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   429: aload_1
    //   430: ldc_w 740
    //   433: iconst_1
    //   434: invokeinterface 880 3 0
    //   439: putfield 743	com/tencent/xweb/xwalk/updater/d:aiqH	Z
    //   442: aload_0
    //   443: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   446: aload_1
    //   447: ldc_w 744
    //   450: ldc_w 795
    //   453: invokeinterface 869 3 0
    //   458: putfield 490	com/tencent/xweb/xwalk/updater/d:strAbi	Ljava/lang/String;
    //   461: aload_0
    //   462: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   465: aload_1
    //   466: ldc_w 746
    //   469: ldc_w 795
    //   472: invokeinterface 869 3 0
    //   477: putfield 748	com/tencent/xweb/xwalk/updater/d:path	Ljava/lang/String;
    //   480: aload_0
    //   481: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   484: aload_1
    //   485: ldc_w 766
    //   488: ldc_w 795
    //   491: invokeinterface 869 3 0
    //   496: putfield 461	com/tencent/xweb/xwalk/updater/d:aiiN	Ljava/lang/String;
    //   499: aload_0
    //   500: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   503: aload_1
    //   504: ldc_w 768
    //   507: ldc_w 795
    //   510: invokeinterface 869 3 0
    //   515: putfield 458	com/tencent/xweb/xwalk/updater/d:aiiO	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   522: aload_1
    //   523: ldc_w 770
    //   526: ldc_w 795
    //   529: invokeinterface 869 3 0
    //   534: putfield 160	com/tencent/xweb/xwalk/updater/d:aiiP	Ljava/lang/String;
    //   537: aload_0
    //   538: getfield 692	com/tencent/xweb/xwalk/updater/c:aiqr	Lcom/tencent/xweb/xwalk/updater/d;
    //   541: astore_1
    //   542: goto -528 -> 14
    //   545: astore_1
    //   546: aload_0
    //   547: monitorexit
    //   548: aload_1
    //   549: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	c
    //   13	529	1	localObject1	Object
    //   545	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	545	finally
    //   18	101	545	finally
    //   104	542	545	finally
  }
  
  public double kjZ()
  {
    this.aiqq = false;
    return bIt(Pf(false)) * 3600000.0D;
  }
  
  protected abstract String kjo();
  
  public int kjp()
  {
    return 0;
  }
  
  protected String kjq()
  {
    return a.keX().qM("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  protected String kjr()
  {
    return a.keX().qM("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
  
  public double kka()
  {
    this.aiqq = false;
    return bIt(Pf(true)) * 3600000.0D;
  }
  
  protected boolean kkb()
  {
    return false;
  }
  
  public void kkc()
  {
    double d = i.khC();
    if ((d < kjY().aiqF) || (d < 6.0D)) {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay, currentHour:" + d + ", so still schedule in today");
    }
    for (long l1 = -(d * 3600000.0D);; l1 = i.khB())
    {
      l1 = (b(0.0D, ag(kjY().aiqF), w(kjY().aiqF, kjY().aiqG)) * 3600000.0D + l1);
      long l2 = System.currentTimeMillis();
      kjY().aiqB = (l2 + l1);
      e(kjY());
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "rescheduleToNextDay, " + l1 / 60000L + " minutes later");
      return;
    }
  }
  
  public static final class a
  {
    public j aiqs;
    public j aiqt;
    
    public a()
    {
      AppMethodBeat.i(212983);
      this.aiqs = new j();
      this.aiqt = new j();
      AppMethodBeat.o(212983);
    }
    
    final double x(double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(212987);
      paramDouble2 = this.aiqs.ae(paramDouble2);
      paramDouble1 = this.aiqt.ae(paramDouble1);
      AppMethodBeat.o(212987);
      return paramDouble2 * paramDouble1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.c
 * JD-Core Version:    0.7.0.1
 */