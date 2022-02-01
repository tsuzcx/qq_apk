package com.tencent.mm.util;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public abstract class HotpotService
  extends Service
{
  private static final HandlerThread[] YyI = { null };
  private static a YyJ = null;
  
  public HotpotService()
  {
    synchronized (YyI)
    {
      if (YyI[0] == null)
      {
        YyI[0] = new HandlerThread("HPS_CheckExec");
        YyI[0].start();
        YyJ = new a(YyI[0].getLooper());
      }
      return;
    }
  }
  
  /* Error */
  public static Bundle a(android.content.Context paramContext, java.lang.Class<? extends HotpotService> paramClass, int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 58	android/os/IBinder
    //   4: astore 17
    //   6: aload 17
    //   8: iconst_0
    //   9: aconst_null
    //   10: aastore
    //   11: new 6	com/tencent/mm/util/HotpotService$1
    //   14: dup
    //   15: aload 17
    //   17: invokespecial 61	com/tencent/mm/util/HotpotService$1:<init>	([Landroid/os/IBinder;)V
    //   20: astore 5
    //   22: new 63	android/os/Bundle
    //   25: dup
    //   26: aload_0
    //   27: invokevirtual 69	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   30: invokespecial 72	android/os/Bundle:<init>	(Ljava/lang/ClassLoader;)V
    //   33: astore 18
    //   35: aload 18
    //   37: ldc 74
    //   39: aload 5
    //   41: invokevirtual 78	android/os/Bundle:putBinder	(Ljava/lang/String;Landroid/os/IBinder;)V
    //   44: new 80	android/content/Intent
    //   47: dup
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 83	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   53: astore 5
    //   55: aload 5
    //   57: aload 18
    //   59: invokevirtual 87	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   62: pop
    //   63: new 21	com/tencent/mm/util/HotpotService$d
    //   66: dup
    //   67: iconst_0
    //   68: invokespecial 90	com/tencent/mm/util/HotpotService$d:<init>	(B)V
    //   71: astore 19
    //   73: aload_0
    //   74: aload 5
    //   76: aload 19
    //   78: iconst_1
    //   79: invokevirtual 94	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   82: ifne +12 -> 94
    //   85: ldc 96
    //   87: ldc 98
    //   89: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aconst_null
    //   93: areturn
    //   94: aconst_null
    //   95: astore 14
    //   97: aconst_null
    //   98: astore 6
    //   100: aconst_null
    //   101: astore 10
    //   103: aconst_null
    //   104: astore 8
    //   106: aconst_null
    //   107: astore 15
    //   109: aconst_null
    //   110: astore 16
    //   112: aconst_null
    //   113: astore 12
    //   115: aload 12
    //   117: astore 7
    //   119: aload 15
    //   121: astore 5
    //   123: aload 16
    //   125: astore 9
    //   127: aload 14
    //   129: astore 13
    //   131: invokestatic 110	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   134: astore 11
    //   136: aload 12
    //   138: astore 7
    //   140: aload 11
    //   142: astore 8
    //   144: aload 15
    //   146: astore 5
    //   148: aload 11
    //   150: astore 6
    //   152: aload 16
    //   154: astore 9
    //   156: aload 11
    //   158: astore 10
    //   160: aload 14
    //   162: astore 13
    //   164: invokestatic 110	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   167: astore 12
    //   169: aload 12
    //   171: astore 7
    //   173: aload 11
    //   175: astore 8
    //   177: aload 12
    //   179: astore 5
    //   181: aload 11
    //   183: astore 6
    //   185: aload 12
    //   187: astore 9
    //   189: aload 11
    //   191: astore 10
    //   193: aload 14
    //   195: astore 13
    //   197: aload 17
    //   199: monitorenter
    //   200: aload 17
    //   202: iconst_0
    //   203: aaload
    //   204: ifnonnull +11 -> 215
    //   207: aload 17
    //   209: ldc2_w 111
    //   212: invokevirtual 118	java/lang/Object:wait	(J)V
    //   215: aload 17
    //   217: iconst_0
    //   218: aaload
    //   219: ifnonnull +48 -> 267
    //   222: ldc 96
    //   224: ldc 120
    //   226: iconst_1
    //   227: anewarray 114	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: invokevirtual 126	java/lang/Class:getName	()Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload 17
    //   242: monitorexit
    //   243: aload 12
    //   245: invokevirtual 133	android/os/Parcel:recycle	()V
    //   248: aload 11
    //   250: invokevirtual 133	android/os/Parcel:recycle	()V
    //   253: aload_0
    //   254: aload 19
    //   256: invokevirtual 137	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   259: goto -215 -> 44
    //   262: astore 5
    //   264: goto -220 -> 44
    //   267: aload 12
    //   269: astore 7
    //   271: aload 11
    //   273: astore 8
    //   275: aload 12
    //   277: astore 5
    //   279: aload 11
    //   281: astore 6
    //   283: aload 12
    //   285: astore 9
    //   287: aload 11
    //   289: astore 10
    //   291: aload 14
    //   293: astore 13
    //   295: aload 17
    //   297: monitorexit
    //   298: aload 12
    //   300: astore 7
    //   302: aload 11
    //   304: astore 8
    //   306: aload 12
    //   308: astore 5
    //   310: aload 11
    //   312: astore 6
    //   314: aload 12
    //   316: astore 9
    //   318: aload 11
    //   320: astore 10
    //   322: aload 14
    //   324: astore 13
    //   326: aload 11
    //   328: iload_2
    //   329: invokevirtual 141	android/os/Parcel:writeInt	(I)V
    //   332: aload 12
    //   334: astore 7
    //   336: aload 11
    //   338: astore 8
    //   340: aload 12
    //   342: astore 5
    //   344: aload 11
    //   346: astore 6
    //   348: aload 12
    //   350: astore 9
    //   352: aload 11
    //   354: astore 10
    //   356: aload 14
    //   358: astore 13
    //   360: aload 11
    //   362: aload_3
    //   363: iconst_0
    //   364: invokevirtual 145	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   367: aload 17
    //   369: iconst_0
    //   370: aaload
    //   371: astore 14
    //   373: aload 12
    //   375: astore 7
    //   377: aload 11
    //   379: astore 8
    //   381: aload 12
    //   383: astore 5
    //   385: aload 11
    //   387: astore 6
    //   389: aload 12
    //   391: astore 9
    //   393: aload 11
    //   395: astore 10
    //   397: aload 14
    //   399: astore 13
    //   401: aload 14
    //   403: iconst_1
    //   404: aload 11
    //   406: aload 12
    //   408: iconst_0
    //   409: invokeinterface 149 5 0
    //   414: pop
    //   415: aload 12
    //   417: astore 7
    //   419: aload 11
    //   421: astore 8
    //   423: aload 12
    //   425: astore 5
    //   427: aload 11
    //   429: astore 6
    //   431: aload 12
    //   433: astore 9
    //   435: aload 11
    //   437: astore 10
    //   439: aload 14
    //   441: astore 13
    //   443: aload 12
    //   445: invokevirtual 153	android/os/Parcel:readInt	()I
    //   448: istore 4
    //   450: iload 4
    //   452: ifne +215 -> 667
    //   455: aload 12
    //   457: astore 7
    //   459: aload 11
    //   461: astore 8
    //   463: aload 12
    //   465: astore 5
    //   467: aload 11
    //   469: astore 6
    //   471: aload 12
    //   473: astore 9
    //   475: aload 11
    //   477: astore 10
    //   479: aload 14
    //   481: astore 13
    //   483: ldc 96
    //   485: ldc 155
    //   487: iconst_2
    //   488: anewarray 114	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: iload_2
    //   494: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: aload_1
    //   501: invokevirtual 126	java/lang/Class:getName	()Ljava/lang/String;
    //   504: aastore
    //   505: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   508: aload 12
    //   510: astore 7
    //   512: aload 11
    //   514: astore 8
    //   516: aload 12
    //   518: astore 5
    //   520: aload 11
    //   522: astore 6
    //   524: aload 12
    //   526: astore 9
    //   528: aload 11
    //   530: astore 10
    //   532: aload 14
    //   534: astore 13
    //   536: aload 12
    //   538: aload_0
    //   539: invokevirtual 69	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   542: invokevirtual 168	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   545: checkcast 63	android/os/Bundle
    //   548: astore 14
    //   550: aload 12
    //   552: invokevirtual 133	android/os/Parcel:recycle	()V
    //   555: aload 11
    //   557: invokevirtual 133	android/os/Parcel:recycle	()V
    //   560: aload_0
    //   561: aload 19
    //   563: invokevirtual 137	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   566: aload 14
    //   568: areturn
    //   569: astore_0
    //   570: aload 14
    //   572: areturn
    //   573: astore 15
    //   575: aload 12
    //   577: astore 7
    //   579: aload 11
    //   581: astore 8
    //   583: aload 12
    //   585: astore 5
    //   587: aload 11
    //   589: astore 6
    //   591: aload 12
    //   593: astore 9
    //   595: aload 11
    //   597: astore 10
    //   599: aload 14
    //   601: astore 13
    //   603: aload 17
    //   605: monitorexit
    //   606: aload 12
    //   608: astore 7
    //   610: aload 11
    //   612: astore 8
    //   614: aload 12
    //   616: astore 5
    //   618: aload 11
    //   620: astore 6
    //   622: aload 12
    //   624: astore 9
    //   626: aload 11
    //   628: astore 10
    //   630: aload 14
    //   632: astore 13
    //   634: aload 15
    //   636: athrow
    //   637: astore_1
    //   638: aload 7
    //   640: astore 5
    //   642: aload 8
    //   644: astore 6
    //   646: aload_1
    //   647: athrow
    //   648: astore_1
    //   649: aload 5
    //   651: invokevirtual 133	android/os/Parcel:recycle	()V
    //   654: aload 6
    //   656: invokevirtual 133	android/os/Parcel:recycle	()V
    //   659: aload_0
    //   660: aload 19
    //   662: invokevirtual 137	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   665: aload_1
    //   666: athrow
    //   667: iload 4
    //   669: iconst_1
    //   670: if_icmpne +131 -> 801
    //   673: aload 12
    //   675: astore 7
    //   677: aload 11
    //   679: astore 8
    //   681: aload 12
    //   683: astore 5
    //   685: aload 11
    //   687: astore 6
    //   689: aload 12
    //   691: astore 9
    //   693: aload 11
    //   695: astore 10
    //   697: aload 14
    //   699: astore 13
    //   701: ldc 96
    //   703: ldc 170
    //   705: iconst_2
    //   706: anewarray 114	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: iload_2
    //   712: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: aastore
    //   716: dup
    //   717: iconst_1
    //   718: aload_1
    //   719: invokevirtual 126	java/lang/Class:getName	()Ljava/lang/String;
    //   722: aastore
    //   723: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   726: aload 12
    //   728: astore 7
    //   730: aload 11
    //   732: astore 8
    //   734: aload 12
    //   736: astore 5
    //   738: aload 11
    //   740: astore 6
    //   742: aload 12
    //   744: astore 9
    //   746: aload 11
    //   748: astore 10
    //   750: aload 14
    //   752: astore 13
    //   754: aload 12
    //   756: invokevirtual 174	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   759: checkcast 18	com/tencent/mm/util/HotpotService$c
    //   762: athrow
    //   763: astore 7
    //   765: aload 9
    //   767: astore 5
    //   769: aload 10
    //   771: astore 6
    //   773: aload 13
    //   775: invokeinterface 178 1 0
    //   780: ifeq +85 -> 865
    //   783: aload 9
    //   785: astore 5
    //   787: aload 10
    //   789: astore 6
    //   791: new 15	com/tencent/mm/util/HotpotService$b
    //   794: dup
    //   795: aload 7
    //   797: invokespecial 181	com/tencent/mm/util/HotpotService$b:<init>	(Ljava/lang/Throwable;)V
    //   800: athrow
    //   801: aload 12
    //   803: astore 7
    //   805: aload 11
    //   807: astore 8
    //   809: aload 12
    //   811: astore 5
    //   813: aload 11
    //   815: astore 6
    //   817: aload 12
    //   819: astore 9
    //   821: aload 11
    //   823: astore 10
    //   825: aload 14
    //   827: astore 13
    //   829: ldc 96
    //   831: ldc 183
    //   833: iconst_1
    //   834: anewarray 114	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: aload_1
    //   840: invokevirtual 126	java/lang/Class:getName	()Ljava/lang/String;
    //   843: aastore
    //   844: invokestatic 185	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   847: aload 12
    //   849: invokevirtual 133	android/os/Parcel:recycle	()V
    //   852: aload 11
    //   854: invokevirtual 133	android/os/Parcel:recycle	()V
    //   857: aload_0
    //   858: aload 19
    //   860: invokevirtual 137	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   863: aconst_null
    //   864: areturn
    //   865: aload 9
    //   867: astore 5
    //   869: aload 10
    //   871: astore 6
    //   873: aload 17
    //   875: monitorenter
    //   876: aload 17
    //   878: iconst_0
    //   879: aconst_null
    //   880: aastore
    //   881: aload 17
    //   883: monitorexit
    //   884: aload 9
    //   886: invokevirtual 133	android/os/Parcel:recycle	()V
    //   889: aload 10
    //   891: invokevirtual 133	android/os/Parcel:recycle	()V
    //   894: aload_0
    //   895: aload 19
    //   897: invokevirtual 137	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   900: goto -856 -> 44
    //   903: astore 5
    //   905: goto -861 -> 44
    //   908: astore_1
    //   909: aload 9
    //   911: astore 5
    //   913: aload 10
    //   915: astore 6
    //   917: aload 17
    //   919: monitorexit
    //   920: aload 9
    //   922: astore 5
    //   924: aload 10
    //   926: astore 6
    //   928: aload_1
    //   929: athrow
    //   930: astore_0
    //   931: goto -68 -> 863
    //   934: astore_0
    //   935: goto -270 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	938	0	paramContext	android.content.Context
    //   0	938	1	paramClass	java.lang.Class<? extends HotpotService>
    //   0	938	2	paramInt	int
    //   0	938	3	paramBundle	Bundle
    //   448	223	4	i	int
    //   20	160	5	localObject1	Object
    //   262	1	5	localThrowable1	Throwable
    //   277	591	5	localObject2	Object
    //   903	1	5	localThrowable2	Throwable
    //   911	12	5	localObject3	Object
    //   98	829	6	localObject4	Object
    //   117	612	7	localParcel1	Parcel
    //   763	33	7	localThrowable3	Throwable
    //   803	1	7	localParcel2	Parcel
    //   104	704	8	localObject5	Object
    //   125	796	9	localObject6	Object
    //   101	824	10	localObject7	Object
    //   134	719	11	localParcel3	Parcel
    //   113	735	12	localParcel4	Parcel
    //   129	699	13	localObject8	Object
    //   95	731	14	localObject9	Object
    //   107	38	15	localObject10	Object
    //   573	62	15	localObject11	Object
    //   110	43	16	localObject12	Object
    //   4	914	17	arrayOfIBinder	IBinder[]
    //   33	25	18	localBundle	Bundle
    //   71	825	19	locald	d
    // Exception table:
    //   from	to	target	type
    //   253	259	262	java/lang/Throwable
    //   560	566	569	java/lang/Throwable
    //   207	215	573	finally
    //   222	243	573	finally
    //   131	136	637	com/tencent/mm/util/HotpotService$c
    //   164	169	637	com/tencent/mm/util/HotpotService$c
    //   197	200	637	com/tencent/mm/util/HotpotService$c
    //   295	298	637	com/tencent/mm/util/HotpotService$c
    //   326	332	637	com/tencent/mm/util/HotpotService$c
    //   360	367	637	com/tencent/mm/util/HotpotService$c
    //   401	415	637	com/tencent/mm/util/HotpotService$c
    //   443	450	637	com/tencent/mm/util/HotpotService$c
    //   483	508	637	com/tencent/mm/util/HotpotService$c
    //   536	550	637	com/tencent/mm/util/HotpotService$c
    //   603	606	637	com/tencent/mm/util/HotpotService$c
    //   634	637	637	com/tencent/mm/util/HotpotService$c
    //   701	726	637	com/tencent/mm/util/HotpotService$c
    //   754	763	637	com/tencent/mm/util/HotpotService$c
    //   829	847	637	com/tencent/mm/util/HotpotService$c
    //   131	136	648	finally
    //   164	169	648	finally
    //   197	200	648	finally
    //   295	298	648	finally
    //   326	332	648	finally
    //   360	367	648	finally
    //   401	415	648	finally
    //   443	450	648	finally
    //   483	508	648	finally
    //   536	550	648	finally
    //   603	606	648	finally
    //   634	637	648	finally
    //   646	648	648	finally
    //   701	726	648	finally
    //   754	763	648	finally
    //   773	783	648	finally
    //   791	801	648	finally
    //   829	847	648	finally
    //   873	876	648	finally
    //   917	920	648	finally
    //   928	930	648	finally
    //   131	136	763	java/lang/Throwable
    //   164	169	763	java/lang/Throwable
    //   197	200	763	java/lang/Throwable
    //   295	298	763	java/lang/Throwable
    //   326	332	763	java/lang/Throwable
    //   360	367	763	java/lang/Throwable
    //   401	415	763	java/lang/Throwable
    //   443	450	763	java/lang/Throwable
    //   483	508	763	java/lang/Throwable
    //   536	550	763	java/lang/Throwable
    //   603	606	763	java/lang/Throwable
    //   634	637	763	java/lang/Throwable
    //   701	726	763	java/lang/Throwable
    //   754	763	763	java/lang/Throwable
    //   829	847	763	java/lang/Throwable
    //   894	900	903	java/lang/Throwable
    //   881	884	908	finally
    //   857	863	930	java/lang/Throwable
    //   659	665	934	java/lang/Throwable
  }
  
  protected abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);
  
  /* Error */
  public final IBinder onBind(Intent paramIntent)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/mm/util/HotpotService:YyJ	Lcom/tencent/mm/util/HotpotService$a;
    //   3: getfield 194	com/tencent/mm/util/HotpotService$a:YyO	Landroid/os/Handler;
    //   6: iconst_1
    //   7: invokevirtual 199	android/os/Handler:removeMessages	(I)V
    //   10: aload_1
    //   11: aload_0
    //   12: invokevirtual 200	com/tencent/mm/util/HotpotService:getClassLoader	()Ljava/lang/ClassLoader;
    //   15: invokevirtual 203	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   18: aload_1
    //   19: invokevirtual 207	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   22: ldc 74
    //   24: invokevirtual 211	android/os/Bundle:getBinder	(Ljava/lang/String;)Landroid/os/IBinder;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnonnull +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: invokestatic 110	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   37: astore_1
    //   38: aload_1
    //   39: new 8	com/tencent/mm/util/HotpotService$2
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 214	com/tencent/mm/util/HotpotService$2:<init>	(Lcom/tencent/mm/util/HotpotService;)V
    //   47: invokevirtual 218	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   50: aload_2
    //   51: iconst_1
    //   52: aload_1
    //   53: aconst_null
    //   54: iconst_0
    //   55: invokeinterface 149 5 0
    //   60: pop
    //   61: aload_1
    //   62: invokevirtual 133	android/os/Parcel:recycle	()V
    //   65: getstatic 34	com/tencent/mm/util/HotpotService:YyJ	Lcom/tencent/mm/util/HotpotService$a;
    //   68: invokevirtual 221	com/tencent/mm/util/HotpotService$a:ieq	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 133	android/os/Parcel:recycle	()V
    //   80: getstatic 34	com/tencent/mm/util/HotpotService:YyJ	Lcom/tencent/mm/util/HotpotService$a;
    //   83: invokevirtual 221	com/tencent/mm/util/HotpotService$a:ieq	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 133	android/os/Parcel:recycle	()V
    //   95: getstatic 34	com/tencent/mm/util/HotpotService:YyJ	Lcom/tencent/mm/util/HotpotService$a;
    //   98: invokevirtual 221	com/tencent/mm/util/HotpotService$a:ieq	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_2
    //   104: aload_1
    //   105: astore_3
    //   106: aload_2
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: goto -19 -> 91
    //   113: astore_2
    //   114: goto -38 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	HotpotService
    //   0	117	1	paramIntent	Intent
    //   27	65	2	localIBinder	IBinder
    //   103	4	2	localObject1	Object
    //   109	1	2	localObject2	Object
    //   113	1	2	localThrowable	Throwable
    //   105	4	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   34	38	73	java/lang/Throwable
    //   34	38	88	finally
    //   38	61	103	finally
    //   38	61	113	java/lang/Throwable
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  static final class a
  {
    private static final long YyM;
    private static final long YyN;
    final Handler YyO;
    private long YyP;
    private long YyQ;
    private int YyR;
    
    static
    {
      AppMethodBeat.i(211378);
      YyM = TimeUnit.SECONDS.toMillis(5L);
      YyN = TimeUnit.SECONDS.toMillis(20L);
      AppMethodBeat.o(211378);
    }
    
    public a(Looper paramLooper)
    {
      AppMethodBeat.i(211368);
      this.YyP = 0L;
      this.YyQ = 0L;
      this.YyR = 0;
      this.YyO = new Handler(paramLooper)
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(211418);
          if (paramAnonymousMessage.what == 1) {
            HotpotService.a.a(HotpotService.a.this);
          }
          AppMethodBeat.o(211418);
        }
      };
      AppMethodBeat.o(211368);
    }
    
    /* Error */
    private boolean ieo()
    {
      // Byte code:
      //   0: ldc 158
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 160	java/io/BufferedReader
      //   8: dup
      //   9: new 162	java/io/FileReader
      //   12: dup
      //   13: ldc 164
      //   15: invokespecial 167	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   18: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   21: astore 9
      //   23: aconst_null
      //   24: astore 8
      //   26: aload 9
      //   28: invokevirtual 174	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   31: ldc 176
      //   33: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   36: astore 7
      //   38: aload 7
      //   40: bipush 13
      //   42: aaload
      //   43: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   46: lstore_1
      //   47: aload 7
      //   49: bipush 14
      //   51: aaload
      //   52: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   55: lstore_3
      //   56: aload 7
      //   58: bipush 15
      //   60: aaload
      //   61: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   64: lstore 5
      //   66: aload 7
      //   68: bipush 16
      //   70: aaload
      //   71: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   74: lload_1
      //   75: lload_3
      //   76: ladd
      //   77: lload 5
      //   79: ladd
      //   80: ladd
      //   81: lstore_1
      //   82: lload_1
      //   83: aload_0
      //   84: getfield 56	com/tencent/mm/util/HotpotService$a:YyP	J
      //   87: lsub
      //   88: lstore_3
      //   89: aload_0
      //   90: lload_1
      //   91: putfield 56	com/tencent/mm/util/HotpotService$a:YyP	J
      //   94: lload_3
      //   95: ldc2_w 34
      //   98: lcmp
      //   99: ifle +33 -> 132
      //   102: ldc 81
      //   104: ldc 190
      //   106: iconst_1
      //   107: anewarray 4	java/lang/Object
      //   110: dup
      //   111: iconst_0
      //   112: lload_3
      //   113: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   116: aastore
      //   117: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aload 9
      //   122: invokevirtual 196	java/io/BufferedReader:close	()V
      //   125: ldc 158
      //   127: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: iconst_1
      //   131: ireturn
      //   132: ldc 81
      //   134: ldc 198
      //   136: iconst_1
      //   137: anewarray 4	java/lang/Object
      //   140: dup
      //   141: iconst_0
      //   142: lload_3
      //   143: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   146: aastore
      //   147: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: aload 9
      //   152: invokevirtual 196	java/io/BufferedReader:close	()V
      //   155: ldc 158
      //   157: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: iconst_0
      //   161: ireturn
      //   162: astore 8
      //   164: ldc 158
      //   166: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   169: aload 8
      //   171: athrow
      //   172: astore 7
      //   174: aload 8
      //   176: ifnull +50 -> 226
      //   179: aload 9
      //   181: invokevirtual 196	java/io/BufferedReader:close	()V
      //   184: ldc 158
      //   186: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   189: aload 7
      //   191: athrow
      //   192: astore 7
      //   194: ldc 81
      //   196: aload 7
      //   198: ldc 202
      //   200: iconst_0
      //   201: anewarray 4	java/lang/Object
      //   204: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   207: ldc 158
      //   209: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: iconst_1
      //   213: ireturn
      //   214: astore 9
      //   216: aload 8
      //   218: aload 9
      //   220: invokevirtual 210	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   223: goto -39 -> 184
      //   226: aload 9
      //   228: invokevirtual 196	java/io/BufferedReader:close	()V
      //   231: goto -47 -> 184
      //   234: astore 7
      //   236: goto -62 -> 174
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	239	0	this	a
      //   46	45	1	l1	long
      //   55	88	3	l2	long
      //   64	14	5	l3	long
      //   36	31	7	arrayOfString	java.lang.String[]
      //   172	18	7	localObject1	Object
      //   192	5	7	localThrowable1	Throwable
      //   234	1	7	localObject2	Object
      //   24	1	8	localObject3	Object
      //   162	55	8	localThrowable2	Throwable
      //   21	159	9	localBufferedReader	java.io.BufferedReader
      //   214	13	9	localThrowable3	Throwable
      // Exception table:
      //   from	to	target	type
      //   26	94	162	java/lang/Throwable
      //   102	120	162	java/lang/Throwable
      //   132	150	162	java/lang/Throwable
      //   164	172	172	finally
      //   5	23	192	java/lang/Throwable
      //   120	125	192	java/lang/Throwable
      //   150	155	192	java/lang/Throwable
      //   184	192	192	java/lang/Throwable
      //   216	223	192	java/lang/Throwable
      //   226	231	192	java/lang/Throwable
      //   179	184	214	java/lang/Throwable
      //   26	94	234	finally
      //   102	120	234	finally
      //   132	150	234	finally
    }
    
    /* Error */
    private boolean iep()
    {
      // Byte code:
      //   0: ldc 211
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 160	java/io/BufferedReader
      //   8: dup
      //   9: new 162	java/io/FileReader
      //   12: dup
      //   13: ldc 213
      //   15: invokespecial 167	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   18: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   21: astore 7
      //   23: aconst_null
      //   24: astore 6
      //   26: aload 7
      //   28: invokevirtual 174	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   31: pop
      //   32: aload 7
      //   34: invokevirtual 174	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   37: pop
      //   38: aload 7
      //   40: invokevirtual 174	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   43: astore 5
      //   45: aload 7
      //   47: invokevirtual 174	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   50: astore 8
      //   52: aload 5
      //   54: ldc 215
      //   56: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   59: iconst_1
      //   60: aaload
      //   61: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   64: lstore_1
      //   65: aload 8
      //   67: ldc 215
      //   69: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   72: iconst_1
      //   73: aaload
      //   74: invokestatic 188	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   77: lload_1
      //   78: ladd
      //   79: lstore_1
      //   80: lload_1
      //   81: aload_0
      //   82: getfield 58	com/tencent/mm/util/HotpotService$a:YyQ	J
      //   85: lsub
      //   86: lstore_3
      //   87: aload_0
      //   88: lload_1
      //   89: putfield 58	com/tencent/mm/util/HotpotService$a:YyQ	J
      //   92: lload_3
      //   93: ldc2_w 42
      //   96: lcmp
      //   97: ifle +33 -> 130
      //   100: ldc 81
      //   102: ldc 217
      //   104: iconst_1
      //   105: anewarray 4	java/lang/Object
      //   108: dup
      //   109: iconst_0
      //   110: lload_3
      //   111: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   114: aastore
      //   115: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   118: aload 7
      //   120: invokevirtual 196	java/io/BufferedReader:close	()V
      //   123: ldc 211
      //   125: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: iconst_1
      //   129: ireturn
      //   130: ldc 81
      //   132: ldc 219
      //   134: iconst_1
      //   135: anewarray 4	java/lang/Object
      //   138: dup
      //   139: iconst_0
      //   140: lload_3
      //   141: invokestatic 193	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   144: aastore
      //   145: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   148: aload 7
      //   150: invokevirtual 196	java/io/BufferedReader:close	()V
      //   153: ldc 211
      //   155: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   158: iconst_0
      //   159: ireturn
      //   160: astore 6
      //   162: ldc 211
      //   164: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: aload 6
      //   169: athrow
      //   170: astore 5
      //   172: aload 6
      //   174: ifnull +50 -> 224
      //   177: aload 7
      //   179: invokevirtual 196	java/io/BufferedReader:close	()V
      //   182: ldc 211
      //   184: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   187: aload 5
      //   189: athrow
      //   190: astore 5
      //   192: ldc 81
      //   194: aload 5
      //   196: ldc 221
      //   198: iconst_0
      //   199: anewarray 4	java/lang/Object
      //   202: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   205: ldc 211
      //   207: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   210: iconst_1
      //   211: ireturn
      //   212: astore 7
      //   214: aload 6
      //   216: aload 7
      //   218: invokevirtual 210	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   221: goto -39 -> 182
      //   224: aload 7
      //   226: invokevirtual 196	java/io/BufferedReader:close	()V
      //   229: goto -47 -> 182
      //   232: astore 5
      //   234: goto -62 -> 172
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	237	0	this	a
      //   64	25	1	l1	long
      //   86	55	3	l2	long
      //   43	10	5	str1	java.lang.String
      //   170	18	5	localObject1	Object
      //   190	5	5	localThrowable1	Throwable
      //   232	1	5	localObject2	Object
      //   24	1	6	localObject3	Object
      //   160	55	6	localThrowable2	Throwable
      //   21	157	7	localBufferedReader	java.io.BufferedReader
      //   212	13	7	localThrowable3	Throwable
      //   50	16	8	str2	java.lang.String
      // Exception table:
      //   from	to	target	type
      //   26	92	160	java/lang/Throwable
      //   100	118	160	java/lang/Throwable
      //   130	148	160	java/lang/Throwable
      //   162	170	170	finally
      //   5	23	190	java/lang/Throwable
      //   118	123	190	java/lang/Throwable
      //   148	153	190	java/lang/Throwable
      //   182	190	190	java/lang/Throwable
      //   214	221	190	java/lang/Throwable
      //   224	229	190	java/lang/Throwable
      //   177	182	212	java/lang/Throwable
      //   26	92	232	finally
      //   100	118	232	finally
      //   130	148	232	finally
    }
    
    public final void ieq()
    {
      AppMethodBeat.i(211374);
      this.YyO.sendEmptyMessageDelayed(1, YyM);
      AppMethodBeat.o(211374);
    }
  }
  
  public static final class b
    extends Exception
  {
    b(Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static final class c
    extends Exception
  {
    public final Throwable YyT;
    
    c(Throwable paramThrowable)
    {
      super();
      this.YyT = paramThrowable;
    }
  }
  
  static final class d
    implements ServiceConnection
  {
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.util.HotpotService
 * JD-Core Version:    0.7.0.1
 */