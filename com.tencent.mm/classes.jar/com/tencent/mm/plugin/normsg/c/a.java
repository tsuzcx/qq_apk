package com.tencent.mm.plugin.normsg.c;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class a
  implements b.g
{
  public static final a<String> ufx;
  private long ufA;
  private long ufB;
  private long ufC;
  private int ufD;
  private boolean ufE;
  private long ufF;
  private long ufy;
  private long ufz;
  
  static
  {
    AppMethodBeat.i(149041);
    a locala = new a((byte)0);
    ufx = locala;
    locala.add("");
    ufx.add(":tools");
    ufx.add(":toolsmp");
    ufx.add(":appbrand0");
    ufx.add(":appbrand1");
    ufx.add(":appbrand2");
    ufx.add(":appbrand3");
    ufx.add(":appbrand4");
    AppMethodBeat.o(149041);
  }
  
  private a()
  {
    AppMethodBeat.i(149024);
    this.ufy = 0L;
    this.ufz = 0L;
    this.ufA = 0L;
    this.ufB = 0L;
    this.ufC = 0L;
    this.ufD = 0;
    this.ufE = false;
    this.ufF = 0L;
    cXc();
    AppMethodBeat.o(149024);
  }
  
  private void G(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(149034);
      long l = System.currentTimeMillis();
      if (l - this.ufz > 86400000L)
      {
        h.vKh.e("Normsg_AED", "action: " + paramInt + ", pkg: " + paramString1 + ", view: " + paramString2, null);
        this.ufz = l;
        cXd();
      }
      if ((com.tencent.mm.compatible.util.g.XL()) && (c.cXh())) {
        cXe();
      }
      AppMethodBeat.o(149034);
      return;
    }
    finally {}
  }
  
  /* Error */
  private static String IA(int paramInt)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 162	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   8: ldc 164
    //   10: invokevirtual 170	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13: checkcast 172	android/app/ActivityManager
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +11 -> 29
    //   21: ldc 156
    //   23: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 46
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 176	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +62 -> 97
    //   38: aload_2
    //   39: invokeinterface 182 1 0
    //   44: astore_2
    //   45: aload_2
    //   46: invokeinterface 187 1 0
    //   51: ifeq +46 -> 97
    //   54: aload_2
    //   55: invokeinterface 191 1 0
    //   60: checkcast 193	android/app/ActivityManager$RunningAppProcessInfo
    //   63: astore_3
    //   64: aload_3
    //   65: getfield 196	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   68: iload_0
    //   69: if_icmpne -24 -> 45
    //   72: aload_3
    //   73: getfield 200	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   76: astore_2
    //   77: ldc 156
    //   79: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_2
    //   83: areturn
    //   84: astore_2
    //   85: ldc 202
    //   87: aload_2
    //   88: ldc 204
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: sipush 16384
    //   101: invokevirtual 214	android/app/ActivityManager:getRunningServices	(I)Ljava/util/List;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +62 -> 168
    //   109: aload_1
    //   110: invokeinterface 182 1 0
    //   115: astore_1
    //   116: aload_1
    //   117: invokeinterface 187 1 0
    //   122: ifeq +46 -> 168
    //   125: aload_1
    //   126: invokeinterface 191 1 0
    //   131: checkcast 216	android/app/ActivityManager$RunningServiceInfo
    //   134: astore_2
    //   135: aload_2
    //   136: getfield 217	android/app/ActivityManager$RunningServiceInfo:pid	I
    //   139: iload_0
    //   140: if_icmpne -24 -> 116
    //   143: aload_2
    //   144: getfield 220	android/app/ActivityManager$RunningServiceInfo:process	Ljava/lang/String;
    //   147: astore_1
    //   148: ldc 156
    //   150: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_1
    //   154: areturn
    //   155: astore_1
    //   156: ldc 202
    //   158: aload_1
    //   159: ldc 222
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aconst_null
    //   169: astore_1
    //   170: new 224	java/io/BufferedReader
    //   173: dup
    //   174: new 226	java/io/FileReader
    //   177: dup
    //   178: getstatic 232	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   181: ldc 234
    //   183: invokestatic 240	com/tencent/mm/plugin/normsg/c/d:ajp	(Ljava/lang/String;)Ljava/lang/String;
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: iload_0
    //   193: invokestatic 246	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 252	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   200: invokespecial 253	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   203: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   206: astore_2
    //   207: aload_2
    //   208: astore_1
    //   209: aload_2
    //   210: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +21 -> 236
    //   218: aload_2
    //   219: astore_1
    //   220: aload_3
    //   221: invokevirtual 262	java/lang/String:trim	()Ljava/lang/String;
    //   224: astore_3
    //   225: aload_2
    //   226: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   229: ldc 156
    //   231: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: areturn
    //   236: aload_2
    //   237: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   240: ldc 156
    //   242: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: ldc 46
    //   247: areturn
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: astore_1
    //   253: ldc 202
    //   255: aload_3
    //   256: ldc_w 270
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload_2
    //   267: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   270: goto -30 -> 240
    //   273: astore_3
    //   274: aload_1
    //   275: astore_2
    //   276: aload_3
    //   277: astore_1
    //   278: aload_2
    //   279: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   282: ldc 156
    //   284: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_1
    //   288: athrow
    //   289: astore_3
    //   290: aload_1
    //   291: astore_2
    //   292: aload_3
    //   293: astore_1
    //   294: goto -16 -> 278
    //   297: astore_3
    //   298: goto -47 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramInt	int
    //   16	138	1	localObject1	Object
    //   155	4	1	localThrowable1	Throwable
    //   169	125	1	localObject2	Object
    //   33	50	2	localObject3	Object
    //   84	4	2	localThrowable2	Throwable
    //   134	158	2	localObject4	Object
    //   63	172	3	localObject5	Object
    //   248	8	3	localThrowable3	Throwable
    //   273	4	3	localObject6	Object
    //   289	4	3	localObject7	Object
    //   297	1	3	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   29	34	84	java/lang/Throwable
    //   38	45	84	java/lang/Throwable
    //   45	77	84	java/lang/Throwable
    //   97	105	155	java/lang/Throwable
    //   109	116	155	java/lang/Throwable
    //   116	148	155	java/lang/Throwable
    //   170	207	248	java/lang/Throwable
    //   170	207	273	finally
    //   209	214	289	finally
    //   220	225	289	finally
    //   253	266	289	finally
    //   209	214	297	java/lang/Throwable
    //   220	225	297	java/lang/Throwable
  }
  
  public static a cWZ()
  {
    return b.ufG;
  }
  
  private void cXb()
  {
    try
    {
      AppMethodBeat.i(149029);
      long l = System.currentTimeMillis();
      if (l - this.ufB >= 259200000L)
      {
        this.ufC = 0L;
        this.ufB = l;
        cXd();
      }
      AppMethodBeat.o(149029);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void cXc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 281
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 283	java/io/File
    //   11: dup
    //   12: invokestatic 162	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   15: invokevirtual 287	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: ldc_w 289
    //   21: invokestatic 240	com/tencent/mm/plugin/normsg/c/d:ajp	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 292	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_3
    //   28: new 294	java/io/DataInputStream
    //   31: dup
    //   32: new 296	java/io/BufferedInputStream
    //   35: dup
    //   36: new 298	java/io/FileInputStream
    //   39: dup
    //   40: aload_3
    //   41: invokespecial 301	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 304	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 305	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore 4
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: invokevirtual 309	java/io/DataInputStream:readInt	()I
    //   60: i2l
    //   61: ldc2_w 310
    //   64: lcmp
    //   65: ifeq +115 -> 180
    //   68: aload 4
    //   70: astore_3
    //   71: new 313	java/lang/IllegalStateException
    //   74: dup
    //   75: ldc_w 315
    //   78: invokespecial 316	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   81: astore 5
    //   83: aload 4
    //   85: astore_3
    //   86: ldc_w 281
    //   89: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload 4
    //   94: astore_3
    //   95: aload 5
    //   97: athrow
    //   98: astore 5
    //   100: aload 4
    //   102: astore_3
    //   103: ldc 202
    //   105: aload 5
    //   107: ldc_w 318
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 4
    //   119: astore_3
    //   120: aload_0
    //   121: lconst_0
    //   122: putfield 73	com/tencent/mm/plugin/normsg/c/a:ufy	J
    //   125: aload 4
    //   127: astore_3
    //   128: aload_0
    //   129: lconst_0
    //   130: putfield 75	com/tencent/mm/plugin/normsg/c/a:ufz	J
    //   133: aload 4
    //   135: astore_3
    //   136: aload_0
    //   137: lconst_0
    //   138: putfield 77	com/tencent/mm/plugin/normsg/c/a:ufA	J
    //   141: aload 4
    //   143: astore_3
    //   144: aload_0
    //   145: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   148: putfield 79	com/tencent/mm/plugin/normsg/c/a:ufB	J
    //   151: aload 4
    //   153: astore_3
    //   154: aload_0
    //   155: lconst_0
    //   156: putfield 81	com/tencent/mm/plugin/normsg/c/a:ufC	J
    //   159: aload 4
    //   161: astore_3
    //   162: aload_0
    //   163: invokespecial 139	com/tencent/mm/plugin/normsg/c/a:cXd	()V
    //   166: aload 4
    //   168: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   171: ldc_w 281
    //   174: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: aload 4
    //   182: astore_3
    //   183: aload_0
    //   184: aload 4
    //   186: invokevirtual 321	java/io/DataInputStream:readLong	()J
    //   189: putfield 73	com/tencent/mm/plugin/normsg/c/a:ufy	J
    //   192: aload 4
    //   194: astore_3
    //   195: aload_0
    //   196: aload 4
    //   198: invokevirtual 321	java/io/DataInputStream:readLong	()J
    //   201: putfield 75	com/tencent/mm/plugin/normsg/c/a:ufz	J
    //   204: aload 4
    //   206: astore_3
    //   207: aload_0
    //   208: aload 4
    //   210: invokevirtual 321	java/io/DataInputStream:readLong	()J
    //   213: putfield 77	com/tencent/mm/plugin/normsg/c/a:ufA	J
    //   216: aload 4
    //   218: astore_3
    //   219: aload_0
    //   220: aload 4
    //   222: invokevirtual 321	java/io/DataInputStream:readLong	()J
    //   225: putfield 79	com/tencent/mm/plugin/normsg/c/a:ufB	J
    //   228: aload 4
    //   230: astore_3
    //   231: aload 4
    //   233: invokevirtual 321	java/io/DataInputStream:readLong	()J
    //   236: lstore_1
    //   237: lload_1
    //   238: lconst_0
    //   239: lcmp
    //   240: ifle +23 -> 263
    //   243: aload 4
    //   245: astore_3
    //   246: aload_0
    //   247: getfield 81	com/tencent/mm/plugin/normsg/c/a:ufC	J
    //   250: lconst_0
    //   251: lcmp
    //   252: ifgt +11 -> 263
    //   255: aload 4
    //   257: astore_3
    //   258: aload_0
    //   259: lload_1
    //   260: putfield 81	com/tencent/mm/plugin/normsg/c/a:ufC	J
    //   263: aload 4
    //   265: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   268: ldc_w 281
    //   271: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: goto -97 -> 177
    //   277: astore_3
    //   278: aload_0
    //   279: monitorexit
    //   280: aload_3
    //   281: athrow
    //   282: astore 4
    //   284: aconst_null
    //   285: astore_3
    //   286: aload_3
    //   287: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   290: ldc_w 281
    //   293: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload 4
    //   298: athrow
    //   299: astore 4
    //   301: goto -15 -> 286
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: goto -209 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	a
    //   236	24	1	l	long
    //   27	231	3	localObject1	Object
    //   277	4	3	localObject2	Object
    //   285	2	3	localCloseable	java.io.Closeable
    //   50	214	4	localDataInputStream	java.io.DataInputStream
    //   282	15	4	localObject3	Object
    //   299	1	4	localObject4	Object
    //   307	1	4	localObject5	Object
    //   81	15	5	localIllegalStateException	java.lang.IllegalStateException
    //   98	8	5	localThrowable1	Throwable
    //   304	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   55	68	98	java/lang/Throwable
    //   71	83	98	java/lang/Throwable
    //   86	92	98	java/lang/Throwable
    //   95	98	98	java/lang/Throwable
    //   183	192	98	java/lang/Throwable
    //   195	204	98	java/lang/Throwable
    //   207	216	98	java/lang/Throwable
    //   219	228	98	java/lang/Throwable
    //   231	237	98	java/lang/Throwable
    //   246	255	98	java/lang/Throwable
    //   258	263	98	java/lang/Throwable
    //   2	28	277	finally
    //   166	177	277	finally
    //   263	274	277	finally
    //   286	299	277	finally
    //   28	52	282	finally
    //   55	68	299	finally
    //   71	83	299	finally
    //   86	92	299	finally
    //   95	98	299	finally
    //   103	117	299	finally
    //   120	125	299	finally
    //   128	133	299	finally
    //   136	141	299	finally
    //   144	151	299	finally
    //   154	159	299	finally
    //   162	166	299	finally
    //   183	192	299	finally
    //   195	204	299	finally
    //   207	216	299	finally
    //   219	228	299	finally
    //   231	237	299	finally
    //   246	255	299	finally
    //   258	263	299	finally
    //   28	52	304	java/lang/Throwable
  }
  
  /* Error */
  private void cXd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 322
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 283	java/io/File
    //   11: dup
    //   12: invokestatic 162	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   15: invokevirtual 287	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: ldc_w 289
    //   21: invokestatic 240	com/tencent/mm/plugin/normsg/c/d:ajp	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 292	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_1
    //   28: new 324	java/io/DataOutputStream
    //   31: dup
    //   32: new 326	java/io/BufferedOutputStream
    //   35: dup
    //   36: new 328	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 329	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 332	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: invokespecial 333	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: ldc_w 334
    //   57: invokevirtual 337	java/io/DataOutputStream:writeInt	(I)V
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: aload_0
    //   64: getfield 73	com/tencent/mm/plugin/normsg/c/a:ufy	J
    //   67: invokevirtual 341	java/io/DataOutputStream:writeLong	(J)V
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 75	com/tencent/mm/plugin/normsg/c/a:ufz	J
    //   77: invokevirtual 341	java/io/DataOutputStream:writeLong	(J)V
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 77	com/tencent/mm/plugin/normsg/c/a:ufA	J
    //   87: invokevirtual 341	java/io/DataOutputStream:writeLong	(J)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_2
    //   93: aload_0
    //   94: getfield 79	com/tencent/mm/plugin/normsg/c/a:ufB	J
    //   97: invokevirtual 341	java/io/DataOutputStream:writeLong	(J)V
    //   100: aload_2
    //   101: astore_1
    //   102: aload_2
    //   103: aload_0
    //   104: getfield 81	com/tencent/mm/plugin/normsg/c/a:ufC	J
    //   107: invokevirtual 341	java/io/DataOutputStream:writeLong	(J)V
    //   110: aload_2
    //   111: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   114: ldc_w 322
    //   117: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: ldc 202
    //   130: aload_3
    //   131: ldc_w 343
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_2
    //   142: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   145: ldc_w 322
    //   148: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: goto -31 -> 120
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   166: ldc_w 322
    //   169: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_2
    //   173: athrow
    //   174: astore_2
    //   175: goto -13 -> 162
    //   178: astore_3
    //   179: goto -53 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	a
    //   27	101	1	localObject1	Object
    //   154	4	1	localObject2	Object
    //   161	2	1	localCloseable	java.io.Closeable
    //   50	92	2	localDataOutputStream	java.io.DataOutputStream
    //   159	14	2	localObject3	Object
    //   174	1	2	localObject4	Object
    //   123	8	3	localThrowable1	Throwable
    //   178	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	51	123	java/lang/Throwable
    //   2	28	154	finally
    //   110	120	154	finally
    //   141	151	154	finally
    //   162	174	154	finally
    //   28	51	159	finally
    //   53	60	174	finally
    //   62	70	174	finally
    //   72	80	174	finally
    //   82	90	174	finally
    //   92	100	174	finally
    //   102	110	174	finally
    //   128	141	174	finally
    //   53	60	178	java/lang/Throwable
    //   62	70	178	java/lang/Throwable
    //   72	80	178	java/lang/Throwable
    //   82	90	178	java/lang/Throwable
    //   92	100	178	java/lang/Throwable
    //   102	110	178	java/lang/Throwable
  }
  
  /* Error */
  private void cXe()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 344
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 85	com/tencent/mm/plugin/normsg/c/a:ufE	Z
    //   12: ifne +48 -> 60
    //   15: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   18: lstore_1
    //   19: lload_1
    //   20: aload_0
    //   21: getfield 87	com/tencent/mm/plugin/normsg/c/a:ufF	J
    //   24: lsub
    //   25: ldc2_w 345
    //   28: lcmp
    //   29: ifge +12 -> 41
    //   32: ldc_w 344
    //   35: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 87	com/tencent/mm/plugin/normsg/c/a:ufF	J
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 85	com/tencent/mm/plugin/normsg/c/a:ufE	Z
    //   51: getstatic 352	com/tencent/mm/plugin/secinforeport/a/d:wcE	Lcom/tencent/mm/plugin/secinforeport/a/d;
    //   54: ldc_w 353
    //   57: invokevirtual 356	com/tencent/mm/plugin/secinforeport/a/d:Lw	(I)V
    //   60: ldc_w 344
    //   63: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -28 -> 38
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   18	25	1	l	long
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	69	finally
    //   41	60	69	finally
    //   60	66	69	finally
  }
  
  public static String eF(String paramString)
  {
    AppMethodBeat.i(149038);
    int i = paramString.indexOf(':');
    if (i != -1)
    {
      paramString = paramString.substring(i);
      AppMethodBeat.o(149038);
      return paramString;
    }
    AppMethodBeat.o(149038);
    return "";
  }
  
  private void ea(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(149033);
      long l = System.currentTimeMillis();
      if (l - this.ufy > 86400000L)
      {
        h.vKh.e("Normsg_AED", "findview, pkg: " + paramString + ", res_count: " + paramInt, null);
        this.ufy = l;
        cXd();
      }
      if ((com.tencent.mm.compatible.util.g.XL()) && (c.cXh())) {
        cXe();
      }
      AppMethodBeat.o(149033);
      return;
    }
    finally {}
  }
  
  private void h(int paramInt, View paramView)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149032);
        if (paramView == null)
        {
          AppMethodBeat.o(149032);
          return;
        }
        if (paramInt != 16)
        {
          AppMethodBeat.o(149032);
          continue;
        }
      }
      finally {}
      try
      {
        if (this.ufD == 0)
        {
          AppMethodBeat.o(149032);
          continue;
        }
        if (((paramView instanceof Button)) && (paramView.getId() == this.ufD))
        {
          this.ufC += 1L;
          cXd();
        }
        AppMethodBeat.o(149032);
      }
      finally
      {
        AppMethodBeat.o(149032);
      }
    }
  }
  
  private static String hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149039);
    Object localObject;
    try
    {
      com.tencent.mm.kernel.g.afz().aeD();
      localObject = ((c)localObject).eJy();
    }
    catch (b paramString1)
    {
      try
      {
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.a.gaa;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.qu("100373");
        if ((localObject != null) && (((c)localObject).isValid())) {
          break label89;
        }
        ad.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
        AppMethodBeat.o(149039);
        return paramString2;
      }
      catch (b paramString1)
      {
        ad.printErrStackTrace("MircoMsg.AEDHLP", paramString1, "check point 1-1, explained by src code.", new Object[0]);
        AppMethodBeat.o(149039);
        return paramString2;
      }
      paramString1 = paramString1;
      ad.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
      AppMethodBeat.o(149039);
      return paramString2;
    }
    label89:
    if (localObject == null)
    {
      ad.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
      AppMethodBeat.o(149039);
      return paramString2;
    }
    paramString1 = (String)((Map)localObject).get(paramString1);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(149039);
      return paramString1;
    }
    AppMethodBeat.o(149039);
    return paramString2;
  }
  
  public final void Iy(int paramInt)
  {
    try
    {
      this.ufD = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149025);
    String str;
    if (paramView != null)
    {
      paramView = paramView.toString();
      str = IA(paramInt);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MircoMsg.AEDHLP", "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b", new Object[] { Integer.valueOf(paramInt), str, paramView, Boolean.valueOf(bool) });
      paramInt = i;
      if (paramList != null) {
        paramInt = paramList.size();
      }
      ea(str, paramInt);
      if ((c.cXf()) && (str != null) && (str.contains(d.ajp(">\020r\033c\001xV"))) && (paramList != null)) {
        paramList.clear();
      }
      AppMethodBeat.o(149025);
      return;
      paramView = "";
      break;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(149026);
    if (paramView != null) {}
    for (String str1 = paramView.toString();; str1 = "")
    {
      String str2 = IA(paramInt2);
      ad.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[] { Integer.valueOf(paramInt2), str2, str1, Integer.valueOf(paramInt1) });
      h(paramInt1, paramView);
      G(paramInt1, str2, str1);
      if ((!c.cXf()) || (str2 == null) || (!str2.contains(d.ajp(">\020r\033c\001xV")))) {
        break;
      }
      AppMethodBeat.o(149026);
      return false;
    }
    AppMethodBeat.o(149026);
    return true;
  }
  
  public final long cXa()
  {
    try
    {
      AppMethodBeat.i(149028);
      long l = this.ufC;
      cXb();
      AppMethodBeat.o(149028);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void k(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 496
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: ldc_w 496
    //   15: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   24: lstore_2
    //   25: lload_2
    //   26: aload_0
    //   27: getfield 77	com/tencent/mm/plugin/normsg/c/a:ufA	J
    //   30: lsub
    //   31: ldc2_w 101
    //   34: lcmp
    //   35: ifle +74 -> 109
    //   38: new 498	java/io/StringWriter
    //   41: dup
    //   42: invokespecial 499	java/io/StringWriter:<init>	()V
    //   45: astore 5
    //   47: new 501	java/io/PrintWriter
    //   50: dup
    //   51: aload 5
    //   53: invokespecial 504	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   56: astore 4
    //   58: aload_1
    //   59: aload 4
    //   61: invokevirtual 508	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   64: aload 4
    //   66: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   69: getstatic 108	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   72: ldc_w 510
    //   75: new 112	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 512
    //   82: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 513	java/io/StringWriter:toString	()Ljava/lang/String;
    //   90: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual 136	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   100: aload_0
    //   101: lload_2
    //   102: putfield 77	com/tencent/mm/plugin/normsg/c/a:ufA	J
    //   105: aload_0
    //   106: invokespecial 139	com/tencent/mm/plugin/normsg/c/a:cXd	()V
    //   109: ldc_w 496
    //   112: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -97 -> 18
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 4
    //   127: aload 4
    //   129: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   132: goto -63 -> 69
    //   135: aload 4
    //   137: invokestatic 268	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   140: ldc_w 496
    //   143: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: goto -14 -> 135
    //   152: astore_1
    //   153: goto -26 -> 127
    //   156: astore_1
    //   157: aconst_null
    //   158: astore 4
    //   160: goto -25 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	a
    //   0	163	1	paramThrowable	Throwable
    //   24	78	2	l	long
    //   56	103	4	localPrintWriter	java.io.PrintWriter
    //   45	41	5	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   2	8	118	finally
    //   12	18	118	finally
    //   21	47	118	finally
    //   64	69	118	finally
    //   69	109	118	finally
    //   109	115	118	finally
    //   127	132	118	finally
    //   135	148	118	finally
    //   47	58	123	java/lang/Throwable
    //   58	64	148	finally
    //   58	64	152	java/lang/Throwable
    //   47	58	156	finally
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(149027);
    ad.printErrStackTrace("MircoMsg.AEDHLP", paramThrowable, "[tomys] unexpected error happens.", new Object[0]);
    k(paramThrowable);
    AppMethodBeat.o(149027);
  }
  
  public static final class a<T>
    extends HashSet<T>
  {
    public final boolean add(T paramT)
    {
      AppMethodBeat.i(149014);
      if (contains(paramT))
      {
        paramT = new UnsupportedOperationException();
        AppMethodBeat.o(149014);
        throw paramT;
      }
      boolean bool = super.add(paramT);
      AppMethodBeat.o(149014);
      return bool;
    }
    
    public final boolean addAll(Collection paramCollection)
    {
      AppMethodBeat.i(149015);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(149015);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(149016);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(149016);
      throw localUnsupportedOperationException;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(149017);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(149017);
      throw paramObject;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(149018);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(149018);
      throw paramCollection;
    }
  }
  
  static final class b
  {
    static final a ufG;
    
    static
    {
      AppMethodBeat.i(149019);
      ufG = new a((byte)0);
      AppMethodBeat.o(149019);
    }
  }
  
  public static final class c
  {
    static boolean cXf()
    {
      AppMethodBeat.i(149021);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(d.ajp("Þä¦Ê¡ã¡"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cb(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149021);
          return true;
        }
        AppMethodBeat.o(149021);
      }
      return false;
    }
    
    /* Error */
    public static int cXg()
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 23	java/lang/StringBuilder
      //   8: dup
      //   9: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   12: astore_3
      //   13: aload_3
      //   14: ldc 71
      //   16: invokestatic 32	com/tencent/mm/plugin/normsg/c/d:ajp	(Ljava/lang/String;)Ljava/lang/String;
      //   19: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   22: pop
      //   23: ldc 2
      //   25: invokevirtual 51	java/lang/Object:hashCode	()I
      //   28: bipush 31
      //   30: iushr
      //   31: iconst_1
      //   32: ior
      //   33: istore_0
      //   34: aload_3
      //   35: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   38: astore_2
      //   39: iload_0
      //   40: ifeq +68 -> 108
      //   43: ldc 2
      //   45: invokevirtual 51	java/lang/Object:hashCode	()I
      //   48: istore_1
      //   49: iload_1
      //   50: bipush 31
      //   52: iushr
      //   53: iconst_1
      //   54: ior
      //   55: iconst_1
      //   56: ixor
      //   57: istore_0
      //   58: aload_3
      //   59: iconst_0
      //   60: aload_3
      //   61: invokevirtual 44	java/lang/StringBuilder:length	()I
      //   64: invokevirtual 48	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   67: pop
      //   68: aload_3
      //   69: iload_0
      //   70: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   73: pop
      //   74: aload_2
      //   75: aload_3
      //   76: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   79: invokestatic 58	com/tencent/mm/plugin/normsg/c/a:cb	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   82: iload_0
      //   83: invokestatic 77	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
      //   86: istore_0
      //   87: ldc 69
      //   89: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_0
      //   93: ireturn
      //   94: astore_2
      //   95: aload_3
      //   96: iload_0
      //   97: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: ldc 69
      //   103: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: aload_2
      //   107: athrow
      //   108: ldc 69
      //   110: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   113: iload_0
      //   114: ireturn
      //   115: astore_2
      //   116: ldc 2
      //   118: invokevirtual 51	java/lang/Object:hashCode	()I
      //   121: bipush 31
      //   123: iushr
      //   124: iconst_1
      //   125: ior
      //   126: istore_0
      //   127: aload_3
      //   128: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: astore_2
      //   132: iload_0
      //   133: ifeq +68 -> 201
      //   136: ldc 2
      //   138: invokevirtual 51	java/lang/Object:hashCode	()I
      //   141: istore_1
      //   142: iload_1
      //   143: bipush 31
      //   145: iushr
      //   146: iconst_1
      //   147: ior
      //   148: iconst_1
      //   149: ixor
      //   150: istore_0
      //   151: aload_3
      //   152: iconst_0
      //   153: aload_3
      //   154: invokevirtual 44	java/lang/StringBuilder:length	()I
      //   157: invokevirtual 48	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   160: pop
      //   161: aload_3
      //   162: iload_0
      //   163: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   166: pop
      //   167: aload_2
      //   168: aload_3
      //   169: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: invokestatic 58	com/tencent/mm/plugin/normsg/c/a:cb	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   175: iload_0
      //   176: invokestatic 77	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
      //   179: istore_0
      //   180: ldc 69
      //   182: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   185: iload_0
      //   186: ireturn
      //   187: astore_2
      //   188: aload_3
      //   189: iload_0
      //   190: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   193: pop
      //   194: ldc 69
      //   196: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   199: aload_2
      //   200: athrow
      //   201: ldc 69
      //   203: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: iload_0
      //   207: ireturn
      //   208: astore_2
      //   209: goto -21 -> 188
      //   212: astore_2
      //   213: goto -118 -> 95
      // Local variable table:
      //   start	length	slot	name	signature
      //   33	174	0	i	int
      //   48	98	1	j	int
      //   38	37	2	str1	String
      //   94	13	2	localObject1	Object
      //   115	1	2	localObject2	Object
      //   131	37	2	str2	String
      //   187	13	2	localObject3	Object
      //   208	1	2	localObject4	Object
      //   212	1	2	localObject5	Object
      //   12	177	3	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   43	49	94	finally
      //   13	23	115	finally
      //   136	142	187	finally
      //   151	161	208	finally
      //   58	68	212	finally
    }
    
    static boolean cXh()
    {
      AppMethodBeat.i(149023);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(d.ajp("Àú¿ÑÄ"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cb(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149023);
          return true;
        }
        AppMethodBeat.o(149023);
      }
      return false;
    }
    
    public static boolean isEnabled()
    {
      AppMethodBeat.i(149020);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(d.ajp("Úà¯ßºÔ"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cb(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149020);
          return true;
        }
        AppMethodBeat.o(149020);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.a
 * JD-Core Version:    0.7.0.1
 */