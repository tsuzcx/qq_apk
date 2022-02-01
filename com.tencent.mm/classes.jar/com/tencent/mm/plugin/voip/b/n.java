package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.bh.a;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.g.a.bj.a;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.bs.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
{
  public static Context ClL;
  private static final Uri ClM;
  private static final String SYS_INFO;
  
  static
  {
    AppMethodBeat.i(115542);
    ClL = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    localStringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    localStringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    localStringBuilder.append("] BOARD:[" + Build.BOARD);
    localStringBuilder.append("] DEVICE:[" + Build.DEVICE);
    localStringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
    localStringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
    localStringBuilder.append("] HOST:[" + Build.HOST);
    localStringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
    localStringBuilder.append("] MODEL:[" + Build.MODEL);
    localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    localStringBuilder.append("] TAGS:[" + Build.TAGS);
    localStringBuilder.append("] TYPE:[" + Build.TYPE);
    localStringBuilder.append("] USER:[" + Build.USER + "]");
    SYS_INFO = localStringBuilder.toString();
    ClM = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    AppMethodBeat.o(115542);
  }
  
  public static int II(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(115536);
    try
    {
      int j = bt.getInt(g.acA().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(115536);
    return i;
  }
  
  public static Notification e(s.c paramc)
  {
    AppMethodBeat.i(115541);
    if (d.lz(16))
    {
      paramc = paramc.build();
      AppMethodBeat.o(115541);
      return paramc;
    }
    paramc = paramc.build();
    AppMethodBeat.o(115541);
    return paramc;
  }
  
  public static boolean eAc()
  {
    return true;
  }
  
  /* Error */
  private static boolean eAd()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_1
    //   10: ldc 191
    //   12: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: aload 6
    //   17: astore 4
    //   19: aload 7
    //   21: astore 5
    //   23: new 193	java/util/Properties
    //   26: dup
    //   27: invokespecial 194	java/util/Properties:<init>	()V
    //   30: astore 8
    //   32: aload 6
    //   34: astore 4
    //   36: aload 7
    //   38: astore 5
    //   40: new 196	com/tencent/mm/vfs/e
    //   43: dup
    //   44: invokestatic 202	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   47: ldc 204
    //   49: invokespecial 207	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: invokestatic 213	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   55: astore 6
    //   57: aload 6
    //   59: astore 4
    //   61: aload 6
    //   63: astore 5
    //   65: aload 8
    //   67: aload 6
    //   69: invokevirtual 217	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   72: aload 6
    //   74: astore 4
    //   76: aload 6
    //   78: astore 5
    //   80: aload 8
    //   82: ldc 219
    //   84: aconst_null
    //   85: invokevirtual 223	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 7
    //   90: iload_1
    //   91: istore_0
    //   92: aload 7
    //   94: ifnull +27 -> 121
    //   97: aload 6
    //   99: astore 4
    //   101: aload 6
    //   103: astore 5
    //   105: aload 7
    //   107: ldc 225
    //   109: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: istore_3
    //   113: iload_1
    //   114: istore_0
    //   115: iload_3
    //   116: ifeq +5 -> 121
    //   119: iconst_1
    //   120: istore_0
    //   121: aload 6
    //   123: invokestatic 235	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   126: ldc 154
    //   128: ldc 237
    //   130: iload_0
    //   131: invokestatic 240	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   134: invokevirtual 165	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokestatic 243	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 191
    //   142: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iload_0
    //   146: ireturn
    //   147: astore 5
    //   149: aload 4
    //   151: ifnull +12 -> 163
    //   154: aload 4
    //   156: astore 5
    //   158: aload 4
    //   160: invokevirtual 248	java/io/InputStream:close	()V
    //   163: aload 4
    //   165: invokestatic 235	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   168: iload_2
    //   169: istore_0
    //   170: goto -44 -> 126
    //   173: astore 4
    //   175: aload 5
    //   177: invokestatic 235	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   180: ldc 191
    //   182: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 4
    //   187: athrow
    //   188: astore 5
    //   190: goto -27 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   91	79	0	bool1	boolean
    //   9	105	1	bool2	boolean
    //   7	162	2	bool3	boolean
    //   112	4	3	bool4	boolean
    //   17	147	4	localInputStream1	java.io.InputStream
    //   173	13	4	localObject1	Object
    //   21	83	5	localObject2	Object
    //   147	1	5	localIOException1	java.io.IOException
    //   156	20	5	localInputStream2	java.io.InputStream
    //   188	1	5	localIOException2	java.io.IOException
    //   4	118	6	localInputStream3	java.io.InputStream
    //   1	105	7	str	String
    //   30	51	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   23	32	147	java/io/IOException
    //   40	57	147	java/io/IOException
    //   65	72	147	java/io/IOException
    //   80	90	147	java/io/IOException
    //   105	113	147	java/io/IOException
    //   23	32	173	finally
    //   40	57	173	finally
    //   65	72	173	finally
    //   80	90	173	finally
    //   105	113	173	finally
    //   158	163	173	finally
    //   158	163	188	java/io/IOException
  }
  
  public static boolean eAe()
  {
    AppMethodBeat.i(115537);
    bj localbj = new bj();
    a.IbL.l(localbj);
    boolean bool = localbj.dmp.aLU;
    AppMethodBeat.o(115537);
    return bool;
  }
  
  public static boolean eAf()
  {
    AppMethodBeat.i(115539);
    bs localbs = new bs();
    a.IbL.l(localbs);
    boolean bool = localbs.dmI.aLU;
    AppMethodBeat.o(115539);
    return bool;
  }
  
  public static boolean eAg()
  {
    AppMethodBeat.i(115540);
    bh localbh = new bh();
    a.IbL.l(localbh);
    boolean bool = localbh.dmk.dml;
    AppMethodBeat.o(115540);
    return bool;
  }
  
  public static boolean gC(Context paramContext)
  {
    AppMethodBeat.i(115531);
    boolean bool = false;
    if (eAd() == true) {
      bool = gF(paramContext);
    }
    ad.d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(115531);
    return bool;
  }
  
  public static boolean gD(Context paramContext)
  {
    AppMethodBeat.i(115532);
    boolean bool = false;
    if (eAd() == true) {
      bool = gE(paramContext);
    }
    ad.d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(115532);
    return bool;
  }
  
  /* Error */
  private static boolean gE(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 319
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 325	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_0
    //   11: aload_0
    //   12: getstatic 125	com/tencent/mm/plugin/voip/b/n:ClM	Landroid/net/Uri;
    //   15: iconst_1
    //   16: anewarray 158	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 327
    //   24: aastore
    //   25: ldc_w 329
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 335	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +367 -> 404
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: invokeinterface 341 1 0
    //   51: ifle +353 -> 404
    //   54: aload 6
    //   56: astore 5
    //   58: aload 6
    //   60: invokeinterface 344 1 0
    //   65: ifeq +339 -> 404
    //   68: aload 6
    //   70: astore 5
    //   72: aload 6
    //   74: iconst_0
    //   75: invokeinterface 347 2 0
    //   80: istore_2
    //   81: aload_0
    //   82: astore 4
    //   84: iload_2
    //   85: istore_1
    //   86: aload 6
    //   88: ifnull +15 -> 103
    //   91: aload 6
    //   93: invokeinterface 348 1 0
    //   98: iload_2
    //   99: istore_1
    //   100: aload_0
    //   101: astore 4
    //   103: ldc 154
    //   105: ldc_w 350
    //   108: iconst_3
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iload_1
    //   115: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: ldc_w 357
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: ldc_w 358
    //   130: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: iconst_m1
    //   138: istore_2
    //   139: iload_1
    //   140: iconst_m1
    //   141: if_icmpeq +253 -> 394
    //   144: aload 4
    //   146: ifnull +248 -> 394
    //   149: iload_1
    //   150: ldc_w 358
    //   153: ior
    //   154: istore_3
    //   155: new 363	android/content/ContentValues
    //   158: dup
    //   159: invokespecial 364	android/content/ContentValues:<init>	()V
    //   162: astore_0
    //   163: aload_0
    //   164: ldc_w 327
    //   167: iload_3
    //   168: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 368	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   174: aload 4
    //   176: getstatic 125	com/tencent/mm/plugin/voip/b/n:ClM	Landroid/net/Uri;
    //   179: aload_0
    //   180: ldc_w 329
    //   183: aconst_null
    //   184: invokevirtual 372	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   187: istore_1
    //   188: ldc 154
    //   190: ldc_w 374
    //   193: iconst_5
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: iload_3
    //   200: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: ldc_w 357
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: ldc_w 358
    //   215: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: dup
    //   220: iconst_3
    //   221: ldc_w 376
    //   224: aastore
    //   225: dup
    //   226: iconst_4
    //   227: iload_1
    //   228: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: iload_1
    //   236: ifle +117 -> 353
    //   239: ldc_w 319
    //   242: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore 7
    //   249: aconst_null
    //   250: astore_0
    //   251: aconst_null
    //   252: astore 4
    //   254: aload_0
    //   255: astore 5
    //   257: ldc 154
    //   259: ldc_w 378
    //   262: iconst_2
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 7
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: ldc_w 358
    //   276: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: aastore
    //   280: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload_0
    //   284: ifnull +115 -> 399
    //   287: aload_0
    //   288: invokeinterface 348 1 0
    //   293: iconst_m1
    //   294: istore_1
    //   295: goto -192 -> 103
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 5
    //   302: aload 5
    //   304: ifnull +10 -> 314
    //   307: aload 5
    //   309: invokeinterface 348 1 0
    //   314: ldc_w 319
    //   317: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: iload_2
    //   324: istore_1
    //   325: ldc 154
    //   327: ldc_w 383
    //   330: iconst_2
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload_0
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: ldc_w 358
    //   343: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: goto -115 -> 235
    //   353: ldc_w 319
    //   356: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: iconst_0
    //   360: ireturn
    //   361: astore_0
    //   362: goto -37 -> 325
    //   365: astore_0
    //   366: goto -64 -> 302
    //   369: astore 7
    //   371: aconst_null
    //   372: astore 5
    //   374: aload_0
    //   375: astore 4
    //   377: aload 5
    //   379: astore_0
    //   380: goto -126 -> 254
    //   383: astore 7
    //   385: aload_0
    //   386: astore 4
    //   388: aload 6
    //   390: astore_0
    //   391: goto -137 -> 254
    //   394: iconst_m1
    //   395: istore_1
    //   396: goto -161 -> 235
    //   399: iconst_m1
    //   400: istore_1
    //   401: goto -298 -> 103
    //   404: iconst_m1
    //   405: istore_2
    //   406: goto -325 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramContext	Context
    //   85	316	1	i	int
    //   80	326	2	j	int
    //   154	46	3	k	int
    //   82	305	4	localContext	Context
    //   42	336	5	localObject	Object
    //   33	356	6	localCursor	android.database.Cursor
    //   247	22	7	localThrowable1	java.lang.Throwable
    //   369	1	7	localThrowable2	java.lang.Throwable
    //   383	1	7	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	11	247	java/lang/Throwable
    //   6	11	298	finally
    //   11	35	298	finally
    //   155	188	322	java/lang/Throwable
    //   188	235	361	java/lang/Throwable
    //   44	54	365	finally
    //   58	68	365	finally
    //   72	81	365	finally
    //   257	283	365	finally
    //   11	35	369	java/lang/Throwable
    //   44	54	383	java/lang/Throwable
    //   58	68	383	java/lang/Throwable
    //   72	81	383	java/lang/Throwable
  }
  
  /* Error */
  private static boolean gF(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 325	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 125	com/tencent/mm/plugin/voip/b/n:ClM	Landroid/net/Uri;
    //   13: iconst_4
    //   14: anewarray 158	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 386
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 327
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 388
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: ldc_w 390
    //   40: aastore
    //   41: ldc_w 329
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 335	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 6
    //   51: aload 6
    //   53: ifnull +147 -> 200
    //   56: aload 6
    //   58: astore_0
    //   59: aload 6
    //   61: invokeinterface 341 1 0
    //   66: ifle +134 -> 200
    //   69: aload 6
    //   71: astore_0
    //   72: aload 6
    //   74: invokeinterface 344 1 0
    //   79: ifeq +121 -> 200
    //   82: aload 6
    //   84: astore_0
    //   85: aload 6
    //   87: iconst_0
    //   88: invokeinterface 347 2 0
    //   93: istore_1
    //   94: aload 6
    //   96: astore_0
    //   97: aload 6
    //   99: iconst_1
    //   100: invokeinterface 347 2 0
    //   105: istore_2
    //   106: aload 6
    //   108: astore_0
    //   109: aload 6
    //   111: iconst_2
    //   112: invokeinterface 347 2 0
    //   117: istore_3
    //   118: aload 6
    //   120: astore_0
    //   121: aload 6
    //   123: iconst_3
    //   124: invokeinterface 347 2 0
    //   129: istore 4
    //   131: iload_1
    //   132: ldc_w 358
    //   135: iand
    //   136: ldc_w 358
    //   139: if_icmpne +20 -> 159
    //   142: iload_3
    //   143: ldc_w 358
    //   146: iand
    //   147: ifne +12 -> 159
    //   150: iload 4
    //   152: ldc_w 358
    //   155: iand
    //   156: ifeq +14 -> 170
    //   159: iload_2
    //   160: ldc_w 358
    //   163: iand
    //   164: ldc_w 358
    //   167: if_icmpne +27 -> 194
    //   170: iconst_1
    //   171: istore 5
    //   173: aload 6
    //   175: ifnull +10 -> 185
    //   178: aload 6
    //   180: invokeinterface 348 1 0
    //   185: ldc_w 384
    //   188: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: iload 5
    //   193: ireturn
    //   194: iconst_0
    //   195: istore 5
    //   197: goto -24 -> 173
    //   200: aload 6
    //   202: ifnull +10 -> 212
    //   205: aload 6
    //   207: invokeinterface 348 1 0
    //   212: ldc_w 384
    //   215: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore 7
    //   222: aconst_null
    //   223: astore 6
    //   225: aload 6
    //   227: astore_0
    //   228: ldc_w 392
    //   231: ldc_w 394
    //   234: iconst_2
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 7
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: ldc_w 358
    //   248: invokestatic 355	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 6
    //   257: ifnull -45 -> 212
    //   260: aload 6
    //   262: invokeinterface 348 1 0
    //   267: goto -55 -> 212
    //   270: astore 6
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_0
    //   275: ifnull +9 -> 284
    //   278: aload_0
    //   279: invokeinterface 348 1 0
    //   284: ldc_w 384
    //   287: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload 6
    //   292: athrow
    //   293: astore 6
    //   295: goto -21 -> 274
    //   298: astore 7
    //   300: goto -75 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramContext	Context
    //   93	43	1	i	int
    //   105	59	2	j	int
    //   117	30	3	k	int
    //   129	27	4	m	int
    //   171	25	5	bool	boolean
    //   49	212	6	localCursor	android.database.Cursor
    //   270	21	6	localObject1	Object
    //   293	1	6	localObject2	Object
    //   220	21	7	localThrowable1	java.lang.Throwable
    //   298	1	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   6	51	220	java/lang/Throwable
    //   6	51	270	finally
    //   59	69	293	finally
    //   72	82	293	finally
    //   85	94	293	finally
    //   97	106	293	finally
    //   109	118	293	finally
    //   121	131	293	finally
    //   228	255	293	finally
    //   59	69	298	java/lang/Throwable
    //   72	82	298	java/lang/Throwable
    //   85	94	298	java/lang/Throwable
    //   97	106	298	java/lang/Throwable
    //   109	118	298	java/lang/Throwable
    //   121	131	298	java/lang/Throwable
  }
  
  public static void gG(Context paramContext)
  {
    AppMethodBeat.i(115535);
    Toast.makeText(paramContext, 2131764868, 0).show();
    AppMethodBeat.o(115535);
  }
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(115538);
    yb localyb = new yb();
    localyb.dMo.dsi = 2;
    a.IbL.l(localyb);
    boolean bool = localyb.dMp.dMq;
    AppMethodBeat.o(115538);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.n
 * JD-Core Version:    0.7.0.1
 */