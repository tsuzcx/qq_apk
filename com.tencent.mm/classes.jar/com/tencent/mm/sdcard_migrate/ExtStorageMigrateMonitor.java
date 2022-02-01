package com.tencent.mm.sdcard_migrate;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mmkv.MMKV;
import com.tencent.tinker.entry.ApplicationLike;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class ExtStorageMigrateMonitor
{
  private static final String EQm;
  private static final az EQn;
  private static final boolean[] EQo;
  private static final PendingOps EQp;
  private static final a EQq;
  
  static
  {
    AppMethodBeat.i(176861);
    EQm = d.cvL;
    EQn = new az("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1L));
    EQo = new boolean[] { false };
    EQp = new PendingOps((byte)0);
    EQq = new a()
    {
      private static void a(int paramAnonymousInt, String paramAnonymousString1, Throwable arg2, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176852);
        Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        localObject = "[@" + ((SimpleDateFormat)localObject).format(new Date()) + "|" + ExtStorageMigrateMonitor.EQm + "]";
        if ((paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length == 0)) {
          paramAnonymousString2 = (String)localObject + paramAnonymousString2;
        }
        for (;;)
        {
          paramAnonymousVarArgs = paramAnonymousString2;
          if (??? != null)
          {
            paramAnonymousVarArgs = new StringWriter();
            localObject = new PrintWriter(paramAnonymousVarArgs);
            ???.printStackTrace((PrintWriter)localObject);
            ((PrintWriter)localObject).flush();
            paramAnonymousVarArgs = paramAnonymousString2 + "\n" + paramAnonymousVarArgs.toString();
            ((PrintWriter)localObject).close();
          }
          synchronized (ExtStorageMigrateMonitor.eEm())
          {
            if (ExtStorageMigrateMonitor.eEm()[0] != 0) {
              ExtStorageMigrateMonitor.Q(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
            }
            while (paramAnonymousInt == 3)
            {
              AppMethodBeat.o(176852);
              return;
              paramAnonymousString2 = (String)localObject + String.format(paramAnonymousString2, paramAnonymousVarArgs);
              break;
            }
            ExtStorageMigrateMonitor.eEn().R(paramAnonymousInt, paramAnonymousString1, paramAnonymousVarArgs);
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(192888);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(3, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(192888);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176855);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176855);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176853);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(4, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176853);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176856);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        a(6, paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176856);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(176854);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        a(5, paramAnonymousString1, null, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(176854);
      }
    };
    AppMethodBeat.o(176861);
  }
  
  private static void a(ax paramax)
  {
    AppMethodBeat.i(192900);
    if (paramax != null) {
      try
      {
        paramax.EVG.close();
        AppMethodBeat.o(192900);
        return;
      }
      catch (Throwable paramax) {}
    }
    AppMethodBeat.o(192900);
  }
  
  public static void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192897);
    if (!EQn.aFJ("idkey_" + paramLong1 + "_" + paramLong2))
    {
      AppMethodBeat.o(192897);
      return;
    }
    synchronized (EQo)
    {
      if (EQo[0] != 0)
      {
        o(paramLong1, paramLong2, 1L);
        AppMethodBeat.o(192897);
        return;
      }
      EQp.q(paramLong1, paramLong2, 1L);
    }
  }
  
  public static a eEi()
  {
    return EQq;
  }
  
  public static void eEj()
  {
    AppMethodBeat.i(176860);
    String str = d.cKY.getApplication().getPackageName();
    if (!d.cvL.equals(str))
    {
      AppMethodBeat.o(176860);
      return;
    }
    g.fhq().wY(500L).d(new a()
    {
      private static Void aOw()
      {
        AppMethodBeat.i(176857);
        synchronized (ExtStorageMigrateMonitor.eEm())
        {
          ExtStorageMigrateMonitor.eEm()[0] = 1;
          ??? = ExtStorageMigrateMonitor.eEo();
          if (??? == null) {
            break label134;
          }
          Iterator localIterator = ExtStorageMigrateMonitor.PendingOps.a((ExtStorageMigrateMonitor.PendingOps)???).iterator();
          if (localIterator.hasNext())
          {
            ExtStorageMigrateMonitor.PendingOps.a locala = (ExtStorageMigrateMonitor.PendingOps.a)localIterator.next();
            ExtStorageMigrateMonitor.p(locala.id, locala.key, locala.value);
          }
        }
        ??? = ExtStorageMigrateMonitor.PendingOps.b((ExtStorageMigrateMonitor.PendingOps)???).iterator();
        Object localObject3;
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Q(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).bLg);
        }
        ExtStorageMigrateMonitor.eEp();
        label134:
        ??? = ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.eEn()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.a)((Iterator)???).next();
          ExtStorageMigrateMonitor.p(((ExtStorageMigrateMonitor.PendingOps.a)localObject3).id, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).key, ((ExtStorageMigrateMonitor.PendingOps.a)localObject3).value);
        }
        ExtStorageMigrateMonitor.PendingOps.a(ExtStorageMigrateMonitor.eEn()).clear();
        ??? = ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.eEn()).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (ExtStorageMigrateMonitor.PendingOps.b)((Iterator)???).next();
          ExtStorageMigrateMonitor.Q(((ExtStorageMigrateMonitor.PendingOps.b)localObject3).level, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).tag, ((ExtStorageMigrateMonitor.PendingOps.b)localObject3).bLg);
        }
        ExtStorageMigrateMonitor.PendingOps.b(ExtStorageMigrateMonitor.eEn()).clear();
        AppMethodBeat.o(176857);
        return null;
      }
    });
    AppMethodBeat.o(176860);
  }
  
  /* Error */
  private static PendingOps eEk()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 199
    //   7: invokestatic 203	com/tencent/mm/sdk/platformtools/ax:aFC	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   10: astore_0
    //   11: aload_0
    //   12: ldc 205
    //   14: invokevirtual 209	com/tencent/mm/sdk/platformtools/ax:decodeBytes	(Ljava/lang/String;)[B
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +94 -> 113
    //   22: invokestatic 215	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: iconst_0
    //   29: aload_2
    //   30: arraylength
    //   31: invokevirtual 219	android/os/Parcel:unmarshall	([BII)V
    //   34: getstatic 223	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:CREATOR	Landroid/os/Parcelable$Creator;
    //   37: aload_1
    //   38: invokeinterface 229 2 0
    //   43: checkcast 10	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps
    //   46: astore_2
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 232	android/os/Parcel:recycle	()V
    //   55: aload_0
    //   56: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   59: ldc 197
    //   61: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_2
    //   65: areturn
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 232	android/os/Parcel:recycle	()V
    //   77: ldc 197
    //   79: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: athrow
    //   84: astore_1
    //   85: getstatic 78	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQq	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   88: ldc 236
    //   90: aload_1
    //   91: ldc 238
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokeinterface 242 5 0
    //   102: aload_0
    //   103: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   106: ldc 197
    //   108: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: aload_0
    //   114: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   117: ldc 197
    //   119: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   131: ldc 197
    //   133: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -12 -> 127
    //   142: astore_1
    //   143: goto -16 -> 127
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -64 -> 85
    //   152: astore_2
    //   153: goto -84 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	139	0	localax	ax
    //   25	49	1	localParcel	Parcel
    //   84	7	1	localThrowable1	Throwable
    //   124	13	1	localObject1	Object
    //   138	1	1	localObject2	Object
    //   142	1	1	localObject3	Object
    //   146	1	1	localThrowable2	Throwable
    //   17	48	2	localObject4	Object
    //   66	17	2	localObject5	Object
    //   152	1	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   22	26	66	finally
    //   11	18	84	java/lang/Throwable
    //   51	55	84	java/lang/Throwable
    //   73	77	84	java/lang/Throwable
    //   77	84	84	java/lang/Throwable
    //   5	11	124	finally
    //   11	18	138	finally
    //   51	55	138	finally
    //   73	77	138	finally
    //   77	84	138	finally
    //   85	102	142	finally
    //   5	11	146	java/lang/Throwable
    //   26	47	152	finally
  }
  
  /* Error */
  public static void eEl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_1
    //   4: ldc 244
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 10	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 72	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:<init>	(B)V
    //   17: astore_3
    //   18: ldc 199
    //   20: invokestatic 203	com/tencent/mm/sdk/platformtools/ax:aFC	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/ax;
    //   23: astore_2
    //   24: aload_2
    //   25: astore_0
    //   26: invokestatic 246	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:eEk	()Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +31 -> 62
    //   34: aload_3
    //   35: invokestatic 249	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   38: aload_2
    //   39: invokestatic 249	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   42: invokeinterface 255 2 0
    //   47: pop
    //   48: aload_3
    //   49: invokestatic 257	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:b	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   52: aload_2
    //   53: invokestatic 257	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:b	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   56: invokeinterface 255 2 0
    //   61: pop
    //   62: aload_3
    //   63: invokestatic 249	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   66: getstatic 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQp	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;
    //   69: invokestatic 249	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   72: invokeinterface 255 2 0
    //   77: pop
    //   78: aload_3
    //   79: invokestatic 257	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:b	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   82: getstatic 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQp	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;
    //   85: invokestatic 257	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:b	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   88: invokeinterface 255 2 0
    //   93: pop
    //   94: invokestatic 215	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload_3
    //   101: aload_2
    //   102: iconst_0
    //   103: invokevirtual 261	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:writeToParcel	(Landroid/os/Parcel;I)V
    //   106: aload_2
    //   107: astore_1
    //   108: aload_0
    //   109: ldc 205
    //   111: aload_2
    //   112: invokevirtual 265	android/os/Parcel:marshall	()[B
    //   115: invokevirtual 269	com/tencent/mm/sdk/platformtools/ax:encode	(Ljava/lang/String;[B)Z
    //   118: pop
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 232	android/os/Parcel:recycle	()V
    //   127: getstatic 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQp	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;
    //   130: invokestatic 249	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:a	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   133: invokeinterface 272 1 0
    //   138: getstatic 74	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQp	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;
    //   141: invokestatic 257	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps:b	(Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$PendingOps;)Ljava/util/List;
    //   144: invokeinterface 272 1 0
    //   149: aload_0
    //   150: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   153: ldc 244
    //   155: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_2
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 232	android/os/Parcel:recycle	()V
    //   168: ldc 244
    //   170: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_2
    //   174: athrow
    //   175: astore_1
    //   176: getstatic 78	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:EQq	Lcom/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor$a;
    //   179: ldc 236
    //   181: aload_1
    //   182: ldc_w 274
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokeinterface 242 5 0
    //   194: aload_0
    //   195: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   198: ldc 244
    //   200: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_0
    //   207: aload_0
    //   208: invokestatic 234	com/tencent/mm/sdcard_migrate/ExtStorageMigrateMonitor:a	(Lcom/tencent/mm/sdk/platformtools/ax;)V
    //   211: ldc 244
    //   213: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: athrow
    //   218: astore_1
    //   219: goto -12 -> 207
    //   222: astore_1
    //   223: goto -16 -> 207
    //   226: astore_1
    //   227: goto -51 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	207	0	localObject1	Object
    //   3	162	1	localObject2	Object
    //   175	7	1	localThrowable1	Throwable
    //   204	13	1	localObject3	Object
    //   218	1	1	localObject4	Object
    //   222	1	1	localObject5	Object
    //   226	1	1	localThrowable2	Throwable
    //   23	101	2	localObject6	Object
    //   159	15	2	localObject7	Object
    //   17	84	3	localPendingOps	PendingOps
    // Exception table:
    //   from	to	target	type
    //   94	98	159	finally
    //   100	106	159	finally
    //   108	119	159	finally
    //   26	30	175	java/lang/Throwable
    //   34	62	175	java/lang/Throwable
    //   62	94	175	java/lang/Throwable
    //   123	127	175	java/lang/Throwable
    //   127	149	175	java/lang/Throwable
    //   164	168	175	java/lang/Throwable
    //   168	175	175	java/lang/Throwable
    //   9	24	204	finally
    //   26	30	218	finally
    //   34	62	218	finally
    //   62	94	218	finally
    //   123	127	218	finally
    //   127	149	218	finally
    //   164	168	218	finally
    //   168	175	218	finally
    //   176	194	222	finally
    //   9	24	226	java/lang/Throwable
  }
  
  private static void o(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(185089);
    e.vIY.idkeyStat(paramLong1, paramLong2, paramLong3, true);
    AppMethodBeat.o(185089);
  }
  
  static class PendingOps
    implements Parcelable
  {
    public static final Parcelable.Creator<PendingOps> CREATOR;
    private final List<a> EQr;
    private final List<b> EQs;
    
    static
    {
      AppMethodBeat.i(192896);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(192896);
    }
    
    private PendingOps()
    {
      AppMethodBeat.i(192892);
      this.EQr = Collections.synchronizedList(new ArrayList(16));
      this.EQs = Collections.synchronizedList(new ArrayList(32));
      AppMethodBeat.o(192892);
    }
    
    final void R(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(192894);
      this.EQs.add(new b(paramInt, paramString1, paramString2));
      AppMethodBeat.o(192894);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final void q(long paramLong1, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(192893);
      this.EQr.add(new a(paramLong1, paramLong2, paramLong3));
      AppMethodBeat.o(192893);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(192895);
      paramParcel.writeInt(-33554431);
      paramParcel.writeInt(this.EQr.size());
      Iterator localIterator = this.EQr.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (a)localIterator.next();
        paramParcel.writeLong(((a)localObject).id);
        paramParcel.writeLong(((a)localObject).key);
        paramParcel.writeLong(((a)localObject).value);
      }
      paramParcel.writeInt(this.EQs.size());
      localIterator = this.EQs.iterator();
      while (localIterator.hasNext())
      {
        localObject = (b)localIterator.next();
        paramParcel.writeInt(((b)localObject).level);
        paramParcel.writeString(((b)localObject).tag);
        paramParcel.writeString(((b)localObject).bLg);
      }
      AppMethodBeat.o(192895);
    }
    
    static final class a
    {
      long id;
      long key;
      long value;
      
      a(long paramLong1, long paramLong2, long paramLong3)
      {
        this.id = paramLong1;
        this.key = paramLong2;
        this.value = paramLong3;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(192890);
        String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
        AppMethodBeat.o(192890);
        return str;
      }
    }
    
    static final class b
    {
      String bLg;
      int level;
      String tag;
      
      b(int paramInt, String paramString1, String paramString2)
      {
        this.level = paramInt;
        this.tag = paramString1;
        this.bLg = paramString2;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(192891);
        String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.bLg + "}";
        AppMethodBeat.o(192891);
        return str;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor
 * JD-Core Version:    0.7.0.1
 */