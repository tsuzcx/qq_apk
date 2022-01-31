package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.List;
import java.util.Map;

public final class a
  implements b.g
{
  public static final a.a<String> pgT;
  private long pgU;
  private long pgV;
  private long pgW;
  private long pgX;
  private long pgY;
  private int pgZ;
  private boolean pha;
  private long phb;
  
  static
  {
    AppMethodBeat.i(10388);
    a.a locala = new a.a((byte)0);
    pgT = locala;
    locala.add("");
    pgT.add(":tools");
    pgT.add(":toolsmp");
    pgT.add(":appbrand0");
    pgT.add(":appbrand1");
    pgT.add(":appbrand2");
    pgT.add(":appbrand3");
    pgT.add(":appbrand4");
    AppMethodBeat.o(10388);
  }
  
  private a()
  {
    AppMethodBeat.i(10371);
    this.pgU = 0L;
    this.pgV = 0L;
    this.pgW = 0L;
    this.pgX = 0L;
    this.pgY = 0L;
    this.pgZ = 0;
    this.pha = false;
    this.phb = 0L;
    bXu();
    AppMethodBeat.o(10371);
  }
  
  /* Error */
  private static String AR(int paramInt)
  {
    // Byte code:
    //   0: sipush 10384
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 96	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: ldc 98
    //   11: invokevirtual 104	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast 106	android/app/ActivityManager
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +12 -> 31
    //   22: sipush 10384
    //   25: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 42
    //   30: areturn
    //   31: aload_1
    //   32: invokevirtual 110	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +63 -> 100
    //   40: aload_2
    //   41: invokeinterface 116 1 0
    //   46: astore_2
    //   47: aload_2
    //   48: invokeinterface 122 1 0
    //   53: ifeq +47 -> 100
    //   56: aload_2
    //   57: invokeinterface 126 1 0
    //   62: checkcast 128	android/app/ActivityManager$RunningAppProcessInfo
    //   65: astore_3
    //   66: aload_3
    //   67: getfield 131	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   70: iload_0
    //   71: if_icmpne -24 -> 47
    //   74: aload_3
    //   75: getfield 135	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   78: astore_2
    //   79: sipush 10384
    //   82: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: areturn
    //   87: astore_2
    //   88: ldc 137
    //   90: aload_2
    //   91: ldc 139
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_1
    //   101: sipush 16384
    //   104: invokevirtual 149	android/app/ActivityManager:getRunningServices	(I)Ljava/util/List;
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +63 -> 172
    //   112: aload_1
    //   113: invokeinterface 116 1 0
    //   118: astore_1
    //   119: aload_1
    //   120: invokeinterface 122 1 0
    //   125: ifeq +47 -> 172
    //   128: aload_1
    //   129: invokeinterface 126 1 0
    //   134: checkcast 151	android/app/ActivityManager$RunningServiceInfo
    //   137: astore_2
    //   138: aload_2
    //   139: getfield 152	android/app/ActivityManager$RunningServiceInfo:pid	I
    //   142: iload_0
    //   143: if_icmpne -24 -> 119
    //   146: aload_2
    //   147: getfield 155	android/app/ActivityManager$RunningServiceInfo:process	Ljava/lang/String;
    //   150: astore_1
    //   151: sipush 10384
    //   154: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_1
    //   158: areturn
    //   159: astore_1
    //   160: ldc 137
    //   162: aload_1
    //   163: ldc 157
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aconst_null
    //   173: astore_1
    //   174: new 159	java/io/BufferedReader
    //   177: dup
    //   178: new 161	java/io/FileReader
    //   181: dup
    //   182: getstatic 167	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   185: ldc 169
    //   187: invokestatic 175	com/tencent/mm/plugin/normsg/b/d:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: iload_0
    //   197: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: aastore
    //   201: invokestatic 187	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokespecial 190	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   207: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: aload_2
    //   214: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   217: astore_3
    //   218: aload_3
    //   219: ifnull +22 -> 241
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: invokevirtual 200	java/lang/String:trim	()Ljava/lang/String;
    //   228: astore_3
    //   229: aload_2
    //   230: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   233: sipush 10384
    //   236: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_3
    //   240: areturn
    //   241: aload_2
    //   242: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   245: sipush 10384
    //   248: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: ldc 42
    //   253: areturn
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_2
    //   258: astore_1
    //   259: ldc 137
    //   261: aload_3
    //   262: ldc 208
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_2
    //   272: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   275: goto -30 -> 245
    //   278: astore_3
    //   279: aload_1
    //   280: astore_2
    //   281: aload_3
    //   282: astore_1
    //   283: aload_2
    //   284: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   287: sipush 10384
    //   290: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_1
    //   294: athrow
    //   295: astore_3
    //   296: aload_1
    //   297: astore_2
    //   298: aload_3
    //   299: astore_1
    //   300: goto -17 -> 283
    //   303: astore_3
    //   304: goto -47 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramInt	int
    //   17	141	1	localObject1	Object
    //   159	4	1	localThrowable1	Throwable
    //   173	127	1	localObject2	Object
    //   35	51	2	localObject3	Object
    //   87	4	2	localThrowable2	Throwable
    //   137	161	2	localObject4	Object
    //   65	175	3	localObject5	Object
    //   254	8	3	localThrowable3	Throwable
    //   278	4	3	localObject6	Object
    //   295	4	3	localObject7	Object
    //   303	1	3	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   31	36	87	java/lang/Throwable
    //   40	47	87	java/lang/Throwable
    //   47	79	87	java/lang/Throwable
    //   100	108	159	java/lang/Throwable
    //   112	119	159	java/lang/Throwable
    //   119	151	159	java/lang/Throwable
    //   174	211	254	java/lang/Throwable
    //   174	211	278	finally
    //   213	218	295	finally
    //   224	229	295	finally
    //   259	271	295	finally
    //   213	218	303	java/lang/Throwable
    //   224	229	303	java/lang/Throwable
  }
  
  public static String Wf(String paramString)
  {
    AppMethodBeat.i(10385);
    int i = paramString.indexOf(':');
    if (i != -1)
    {
      paramString = paramString.substring(i);
      AppMethodBeat.o(10385);
      return paramString;
    }
    AppMethodBeat.o(10385);
    return "";
  }
  
  public static a bXr()
  {
    return a.b.phc;
  }
  
  private void bXt()
  {
    try
    {
      AppMethodBeat.i(10376);
      long l = System.currentTimeMillis();
      if (l - this.pgX >= 259200000L)
      {
        this.pgY = 0L;
        this.pgX = l;
        bXv();
      }
      AppMethodBeat.o(10376);
      return;
    }
    finally {}
  }
  
  /* Error */
  private void bXu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 10377
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 236	java/io/File
    //   11: dup
    //   12: invokestatic 96	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   15: invokevirtual 240	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: ldc 242
    //   20: invokestatic 175	com/tencent/mm/plugin/normsg/b/d:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 245	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore_3
    //   27: new 247	java/io/DataInputStream
    //   30: dup
    //   31: new 249	java/io/BufferedInputStream
    //   34: dup
    //   35: new 251	java/io/FileInputStream
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 257	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 258	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: invokevirtual 262	java/io/DataInputStream:readInt	()I
    //   59: i2l
    //   60: ldc2_w 263
    //   63: lcmp
    //   64: ifeq +115 -> 179
    //   67: aload 4
    //   69: astore_3
    //   70: new 266	java/lang/IllegalStateException
    //   73: dup
    //   74: ldc_w 268
    //   77: invokespecial 269	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   80: astore 5
    //   82: aload 4
    //   84: astore_3
    //   85: sipush 10377
    //   88: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload 4
    //   93: astore_3
    //   94: aload 5
    //   96: athrow
    //   97: astore 5
    //   99: aload 4
    //   101: astore_3
    //   102: ldc 137
    //   104: aload 5
    //   106: ldc_w 271
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload 4
    //   118: astore_3
    //   119: aload_0
    //   120: lconst_0
    //   121: putfield 68	com/tencent/mm/plugin/normsg/b/a:pgU	J
    //   124: aload 4
    //   126: astore_3
    //   127: aload_0
    //   128: lconst_0
    //   129: putfield 70	com/tencent/mm/plugin/normsg/b/a:pgV	J
    //   132: aload 4
    //   134: astore_3
    //   135: aload_0
    //   136: lconst_0
    //   137: putfield 72	com/tencent/mm/plugin/normsg/b/a:pgW	J
    //   140: aload 4
    //   142: astore_3
    //   143: aload_0
    //   144: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   147: putfield 74	com/tencent/mm/plugin/normsg/b/a:pgX	J
    //   150: aload 4
    //   152: astore_3
    //   153: aload_0
    //   154: lconst_0
    //   155: putfield 76	com/tencent/mm/plugin/normsg/b/a:pgY	J
    //   158: aload 4
    //   160: astore_3
    //   161: aload_0
    //   162: invokespecial 234	com/tencent/mm/plugin/normsg/b/a:bXv	()V
    //   165: aload 4
    //   167: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   170: sipush 10377
    //   173: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: aload 4
    //   181: astore_3
    //   182: aload_0
    //   183: aload 4
    //   185: invokevirtual 274	java/io/DataInputStream:readLong	()J
    //   188: putfield 68	com/tencent/mm/plugin/normsg/b/a:pgU	J
    //   191: aload 4
    //   193: astore_3
    //   194: aload_0
    //   195: aload 4
    //   197: invokevirtual 274	java/io/DataInputStream:readLong	()J
    //   200: putfield 70	com/tencent/mm/plugin/normsg/b/a:pgV	J
    //   203: aload 4
    //   205: astore_3
    //   206: aload_0
    //   207: aload 4
    //   209: invokevirtual 274	java/io/DataInputStream:readLong	()J
    //   212: putfield 72	com/tencent/mm/plugin/normsg/b/a:pgW	J
    //   215: aload 4
    //   217: astore_3
    //   218: aload_0
    //   219: aload 4
    //   221: invokevirtual 274	java/io/DataInputStream:readLong	()J
    //   224: putfield 74	com/tencent/mm/plugin/normsg/b/a:pgX	J
    //   227: aload 4
    //   229: astore_3
    //   230: aload 4
    //   232: invokevirtual 274	java/io/DataInputStream:readLong	()J
    //   235: lstore_1
    //   236: lload_1
    //   237: lconst_0
    //   238: lcmp
    //   239: ifle +23 -> 262
    //   242: aload 4
    //   244: astore_3
    //   245: aload_0
    //   246: getfield 76	com/tencent/mm/plugin/normsg/b/a:pgY	J
    //   249: lconst_0
    //   250: lcmp
    //   251: ifgt +11 -> 262
    //   254: aload 4
    //   256: astore_3
    //   257: aload_0
    //   258: lload_1
    //   259: putfield 76	com/tencent/mm/plugin/normsg/b/a:pgY	J
    //   262: aload 4
    //   264: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   267: sipush 10377
    //   270: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: goto -97 -> 176
    //   276: astore_3
    //   277: aload_0
    //   278: monitorexit
    //   279: aload_3
    //   280: athrow
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   289: sipush 10377
    //   292: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload 4
    //   297: athrow
    //   298: astore 4
    //   300: goto -15 -> 285
    //   303: astore 5
    //   305: aconst_null
    //   306: astore 4
    //   308: goto -209 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	a
    //   235	24	1	l	long
    //   26	231	3	localObject1	Object
    //   276	4	3	localObject2	Object
    //   284	2	3	localCloseable	java.io.Closeable
    //   49	214	4	localDataInputStream	java.io.DataInputStream
    //   281	15	4	localObject3	Object
    //   298	1	4	localObject4	Object
    //   306	1	4	localObject5	Object
    //   80	15	5	localIllegalStateException	java.lang.IllegalStateException
    //   97	8	5	localThrowable1	Throwable
    //   303	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   54	67	97	java/lang/Throwable
    //   70	82	97	java/lang/Throwable
    //   85	91	97	java/lang/Throwable
    //   94	97	97	java/lang/Throwable
    //   182	191	97	java/lang/Throwable
    //   194	203	97	java/lang/Throwable
    //   206	215	97	java/lang/Throwable
    //   218	227	97	java/lang/Throwable
    //   230	236	97	java/lang/Throwable
    //   245	254	97	java/lang/Throwable
    //   257	262	97	java/lang/Throwable
    //   2	27	276	finally
    //   165	176	276	finally
    //   262	273	276	finally
    //   285	298	276	finally
    //   27	51	281	finally
    //   54	67	298	finally
    //   70	82	298	finally
    //   85	91	298	finally
    //   94	97	298	finally
    //   102	116	298	finally
    //   119	124	298	finally
    //   127	132	298	finally
    //   135	140	298	finally
    //   143	150	298	finally
    //   153	158	298	finally
    //   161	165	298	finally
    //   182	191	298	finally
    //   194	203	298	finally
    //   206	215	298	finally
    //   218	227	298	finally
    //   230	236	298	finally
    //   245	254	298	finally
    //   257	262	298	finally
    //   27	51	303	java/lang/Throwable
  }
  
  /* Error */
  private void bXv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 10378
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 236	java/io/File
    //   11: dup
    //   12: invokestatic 96	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   15: invokevirtual 240	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: ldc 242
    //   20: invokestatic 175	com/tencent/mm/plugin/normsg/b/d:Wd	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 245	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 276	java/io/DataOutputStream
    //   30: dup
    //   31: new 278	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 280	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 281	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 284	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: invokespecial 285	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: ldc_w 286
    //   56: invokevirtual 289	java/io/DataOutputStream:writeInt	(I)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 68	com/tencent/mm/plugin/normsg/b/a:pgU	J
    //   66: invokevirtual 293	java/io/DataOutputStream:writeLong	(J)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 70	com/tencent/mm/plugin/normsg/b/a:pgV	J
    //   76: invokevirtual 293	java/io/DataOutputStream:writeLong	(J)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 72	com/tencent/mm/plugin/normsg/b/a:pgW	J
    //   86: invokevirtual 293	java/io/DataOutputStream:writeLong	(J)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 74	com/tencent/mm/plugin/normsg/b/a:pgX	J
    //   96: invokevirtual 293	java/io/DataOutputStream:writeLong	(J)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 76	com/tencent/mm/plugin/normsg/b/a:pgY	J
    //   106: invokevirtual 293	java/io/DataOutputStream:writeLong	(J)V
    //   109: aload_2
    //   110: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   113: sipush 10378
    //   116: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: astore_1
    //   127: ldc 137
    //   129: aload_3
    //   130: ldc_w 295
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_2
    //   141: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   144: sipush 10378
    //   147: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -31 -> 119
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   165: sipush 10378
    //   168: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_2
    //   172: athrow
    //   173: astore_2
    //   174: goto -13 -> 161
    //   177: astore_3
    //   178: goto -53 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	a
    //   26	101	1	localObject1	Object
    //   153	4	1	localObject2	Object
    //   160	2	1	localCloseable	java.io.Closeable
    //   49	92	2	localDataOutputStream	java.io.DataOutputStream
    //   158	14	2	localObject3	Object
    //   173	1	2	localObject4	Object
    //   122	8	3	localThrowable1	Throwable
    //   177	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   27	50	122	java/lang/Throwable
    //   2	27	153	finally
    //   109	119	153	finally
    //   140	150	153	finally
    //   161	173	153	finally
    //   27	50	158	finally
    //   52	59	173	finally
    //   61	69	173	finally
    //   71	79	173	finally
    //   81	89	173	finally
    //   91	99	173	finally
    //   101	109	173	finally
    //   127	140	173	finally
    //   52	59	177	java/lang/Throwable
    //   61	69	177	java/lang/Throwable
    //   71	79	177	java/lang/Throwable
    //   81	89	177	java/lang/Throwable
    //   91	99	177	java/lang/Throwable
    //   101	109	177	java/lang/Throwable
  }
  
  /* Error */
  private void bXw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 10382
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 80	com/tencent/mm/plugin/normsg/b/a:pha	Z
    //   12: ifne +48 -> 60
    //   15: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   18: lstore_1
    //   19: lload_1
    //   20: aload_0
    //   21: getfield 82	com/tencent/mm/plugin/normsg/b/a:phb	J
    //   24: lsub
    //   25: ldc2_w 297
    //   28: lcmp
    //   29: ifge +12 -> 41
    //   32: sipush 10382
    //   35: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 82	com/tencent/mm/plugin/normsg/b/a:phb	J
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 80	com/tencent/mm/plugin/normsg/b/a:pha	Z
    //   51: getstatic 304	com/tencent/mm/plugin/secinforeport/a/d:qEo	Lcom/tencent/mm/plugin/secinforeport/a/d;
    //   54: ldc_w 305
    //   57: invokevirtual 308	com/tencent/mm/plugin/secinforeport/a/d:CU	(I)V
    //   60: sipush 10382
    //   63: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void cV(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(10380);
      long l = System.currentTimeMillis();
      if (l - this.pgU > 86400000L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.g("Normsg_AED", "findview, pkg: " + paramString + ", res_count: " + paramInt, null);
        this.pgU = l;
        bXv();
      }
      if ((com.tencent.mm.compatible.util.h.Mn()) && (a.c.bXz())) {
        bXw();
      }
      AppMethodBeat.o(10380);
      return;
    }
    finally {}
  }
  
  private void e(int paramInt, View paramView)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(10379);
        if (paramView == null)
        {
          AppMethodBeat.o(10379);
          return;
        }
        if (paramInt != 16)
        {
          AppMethodBeat.o(10379);
          continue;
        }
      }
      finally {}
      try
      {
        if (this.pgZ == 0)
        {
          AppMethodBeat.o(10379);
          continue;
        }
        if (((paramView instanceof Button)) && (paramView.getId() == this.pgZ))
        {
          this.pgY += 1L;
          bXv();
        }
        AppMethodBeat.o(10379);
      }
      finally
      {
        AppMethodBeat.o(10379);
      }
    }
  }
  
  private static String fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10386);
    Object localObject;
    try
    {
      g.RJ().QQ();
      localObject = ((c)localObject).dvN();
    }
    catch (b paramString1)
    {
      try
      {
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eEW;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100373");
        if ((localObject != null) && (((c)localObject).isValid())) {
          break label89;
        }
        ab.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
        AppMethodBeat.o(10386);
        return paramString2;
      }
      catch (b paramString1)
      {
        ab.printErrStackTrace("MircoMsg.AEDHLP", paramString1, "check point 1-1, explained by src code.", new Object[0]);
        AppMethodBeat.o(10386);
        return paramString2;
      }
      paramString1 = paramString1;
      ab.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
      AppMethodBeat.o(10386);
      return paramString2;
    }
    label89:
    if (localObject == null)
    {
      ab.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
      AppMethodBeat.o(10386);
      return paramString2;
    }
    paramString1 = (String)((Map)localObject).get(paramString1);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(10386);
      return paramString1;
    }
    AppMethodBeat.o(10386);
    return paramString2;
  }
  
  private void z(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(10381);
      long l = System.currentTimeMillis();
      if (l - this.pgV > 86400000L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.g("Normsg_AED", "action: " + paramInt + ", pkg: " + paramString1 + ", view: " + paramString2, null);
        this.pgV = l;
        bXv();
      }
      if ((com.tencent.mm.compatible.util.h.Mn()) && (a.c.bXz())) {
        bXw();
      }
      AppMethodBeat.o(10381);
      return;
    }
    finally {}
  }
  
  public final void AQ(int paramInt)
  {
    try
    {
      this.pgZ = paramInt;
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
    AppMethodBeat.i(10372);
    String str;
    if (paramView != null)
    {
      paramView = paramView.toString();
      str = AR(paramInt);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MircoMsg.AEDHLP", "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b", new Object[] { Integer.valueOf(paramInt), str, paramView, Boolean.valueOf(bool) });
      paramInt = i;
      if (paramList != null) {
        paramInt = paramList.size();
      }
      cV(str, paramInt);
      if ((a.c.bXx()) && (str != null) && (str.contains(d.Wd(">\020r\033c\001xV"))) && (paramList != null)) {
        paramList.clear();
      }
      AppMethodBeat.o(10372);
      return;
      paramView = "";
      break;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(10373);
    if (paramView != null) {}
    for (String str1 = paramView.toString();; str1 = "")
    {
      String str2 = AR(paramInt2);
      ab.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[] { Integer.valueOf(paramInt2), str2, str1, Integer.valueOf(paramInt1) });
      e(paramInt1, paramView);
      z(paramInt1, str2, str1);
      if ((!a.c.bXx()) || (str2 == null) || (!str2.contains(d.Wd(">\020r\033c\001xV")))) {
        break;
      }
      AppMethodBeat.o(10373);
      return false;
    }
    AppMethodBeat.o(10373);
    return true;
  }
  
  public final long bXs()
  {
    try
    {
      AppMethodBeat.i(10375);
      long l = this.pgY;
      bXt();
      AppMethodBeat.o(10375);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void j(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 10383
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: sipush 10383
    //   15: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   24: lstore_2
    //   25: lload_2
    //   26: aload_0
    //   27: getfield 72	com/tencent/mm/plugin/normsg/b/a:pgW	J
    //   30: lsub
    //   31: ldc2_w 311
    //   34: lcmp
    //   35: ifle +74 -> 109
    //   38: new 479	java/io/StringWriter
    //   41: dup
    //   42: invokespecial 480	java/io/StringWriter:<init>	()V
    //   45: astore 5
    //   47: new 482	java/io/PrintWriter
    //   50: dup
    //   51: aload 5
    //   53: invokespecial 485	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   56: astore 4
    //   58: aload_1
    //   59: aload 4
    //   61: invokevirtual 489	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   64: aload 4
    //   66: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   69: getstatic 318	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   72: ldc_w 491
    //   75: new 322	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 493
    //   82: invokespecial 325	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 494	java/io/StringWriter:toString	()Ljava/lang/String;
    //   90: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 337	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual 341	com/tencent/mm/plugin/report/service/h:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   100: aload_0
    //   101: lload_2
    //   102: putfield 72	com/tencent/mm/plugin/normsg/b/a:pgW	J
    //   105: aload_0
    //   106: invokespecial 234	com/tencent/mm/plugin/normsg/b/a:bXv	()V
    //   109: sipush 10383
    //   112: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   129: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   132: goto -63 -> 69
    //   135: aload 4
    //   137: invokestatic 206	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   140: sipush 10383
    //   143: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(10374);
    ab.printErrStackTrace("MircoMsg.AEDHLP", paramThrowable, "[tomys] unexpected error happens.", new Object[0]);
    j(paramThrowable);
    AppMethodBeat.o(10374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a
 * JD-Core Version:    0.7.0.1
 */