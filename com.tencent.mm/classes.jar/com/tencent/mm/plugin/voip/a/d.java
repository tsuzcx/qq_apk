package com.tencent.mm.plugin.voip.a;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.az.a;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bb.a;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.a;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
{
  private static final String SYS_INFO;
  public static Context tFk;
  private static final Uri tFl;
  
  static
  {
    AppMethodBeat.i(5019);
    tFk = null;
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
    tFl = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    AppMethodBeat.o(5019);
  }
  
  public static Notification c(s.c paramc)
  {
    AppMethodBeat.i(5018);
    if (com.tencent.mm.compatible.util.d.fw(16))
    {
      paramc = paramc.build();
      AppMethodBeat.o(5018);
      return paramc;
    }
    paramc = paramc.build();
    AppMethodBeat.o(5018);
    return paramc;
  }
  
  public static boolean cPr()
  {
    return true;
  }
  
  public static int cPs()
  {
    return Build.VERSION.SDK_INT;
  }
  
  /* Error */
  private static boolean cPt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: sipush 5007
    //   10: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: new 155	java/util/Properties
    //   16: dup
    //   17: invokespecial 156	java/util/Properties:<init>	()V
    //   20: astore 6
    //   22: new 158	java/io/FileInputStream
    //   25: dup
    //   26: new 160	java/io/File
    //   29: dup
    //   30: invokestatic 166	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   33: ldc 168
    //   35: invokespecial 171	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   38: invokespecial 174	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 5
    //   43: aload 5
    //   45: astore 4
    //   47: aload 6
    //   49: aload 5
    //   51: invokevirtual 178	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload 5
    //   56: astore 4
    //   58: aload 6
    //   60: ldc 180
    //   62: aconst_null
    //   63: invokevirtual 184	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: iload_1
    //   69: istore_0
    //   70: aload 6
    //   72: ifnull +23 -> 95
    //   75: aload 5
    //   77: astore 4
    //   79: aload 6
    //   81: ldc 186
    //   83: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: istore_3
    //   87: iload_1
    //   88: istore_0
    //   89: iload_3
    //   90: ifeq +5 -> 95
    //   93: iconst_1
    //   94: istore_0
    //   95: aload 5
    //   97: invokestatic 197	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   100: ldc 199
    //   102: ldc 201
    //   104: iload_0
    //   105: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   108: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 215	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: sipush 5007
    //   117: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iload_0
    //   121: ireturn
    //   122: astore 4
    //   124: aconst_null
    //   125: astore 5
    //   127: aload 5
    //   129: ifnull +12 -> 141
    //   132: aload 5
    //   134: astore 4
    //   136: aload 5
    //   138: invokevirtual 218	java/io/FileInputStream:close	()V
    //   141: aload 5
    //   143: invokestatic 197	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   146: iload_2
    //   147: istore_0
    //   148: goto -48 -> 100
    //   151: astore 6
    //   153: aload 4
    //   155: astore 5
    //   157: aload 6
    //   159: astore 4
    //   161: aload 5
    //   163: invokestatic 197	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   166: sipush 5007
    //   169: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload 4
    //   174: athrow
    //   175: astore 4
    //   177: goto -36 -> 141
    //   180: astore 6
    //   182: aload 4
    //   184: astore 5
    //   186: aload 6
    //   188: astore 4
    //   190: goto -29 -> 161
    //   193: astore 4
    //   195: goto -68 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   69	79	0	bool1	boolean
    //   6	82	1	bool2	boolean
    //   4	143	2	bool3	boolean
    //   86	4	3	bool4	boolean
    //   1	77	4	localObject1	Object
    //   122	1	4	localIOException1	java.io.IOException
    //   134	39	4	localObject2	Object
    //   175	8	4	localIOException2	java.io.IOException
    //   188	1	4	localObject3	Object
    //   193	1	4	localIOException3	java.io.IOException
    //   41	144	5	localObject4	Object
    //   20	60	6	localObject5	Object
    //   151	7	6	localObject6	Object
    //   180	7	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   13	43	122	java/io/IOException
    //   13	43	151	finally
    //   136	141	175	java/io/IOException
    //   47	54	180	finally
    //   58	68	180	finally
    //   79	87	180	finally
    //   136	141	180	finally
    //   47	54	193	java/io/IOException
    //   58	68	193	java/io/IOException
    //   79	87	193	java/io/IOException
  }
  
  public static boolean cPu()
  {
    AppMethodBeat.i(5014);
    bb localbb = new bb();
    a.ymk.l(localbb);
    boolean bool = localbb.coz.bVD;
    AppMethodBeat.o(5014);
    return bool;
  }
  
  public static boolean cPv()
  {
    AppMethodBeat.i(5016);
    bk localbk = new bk();
    a.ymk.l(localbk);
    boolean bool = localbk.coT.bVD;
    AppMethodBeat.o(5016);
    return bool;
  }
  
  public static boolean cPw()
  {
    AppMethodBeat.i(5017);
    az localaz = new az();
    a.ymk.l(localaz);
    boolean bool = localaz.cou.cov;
    AppMethodBeat.o(5017);
    return bool;
  }
  
  public static boolean fj(Context paramContext)
  {
    AppMethodBeat.i(5008);
    boolean bool = false;
    if (cPt() == true) {
      bool = fm(paramContext);
    }
    ab.d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(5008);
    return bool;
  }
  
  public static boolean fk(Context paramContext)
  {
    AppMethodBeat.i(5009);
    boolean bool = false;
    if (cPt() == true) {
      bool = fl(paramContext);
    }
    ab.d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(5009);
    return bool;
  }
  
  /* Error */
  private static boolean fl(Context paramContext)
  {
    // Byte code:
    //   0: sipush 5010
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 288	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_0
    //   11: aload_0
    //   12: getstatic 124	com/tencent/mm/plugin/voip/a/d:tFl	Landroid/net/Uri;
    //   15: iconst_1
    //   16: anewarray 188	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 290
    //   24: aastore
    //   25: ldc_w 292
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 298	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 6
    //   35: aload 6
    //   37: ifnull +367 -> 404
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: invokeinterface 303 1 0
    //   51: ifle +353 -> 404
    //   54: aload 6
    //   56: astore 5
    //   58: aload 6
    //   60: invokeinterface 306 1 0
    //   65: ifeq +339 -> 404
    //   68: aload 6
    //   70: astore 5
    //   72: aload 6
    //   74: iconst_0
    //   75: invokeinterface 310 2 0
    //   80: istore_2
    //   81: aload_0
    //   82: astore 4
    //   84: iload_2
    //   85: istore_1
    //   86: aload 6
    //   88: ifnull +15 -> 103
    //   91: aload 6
    //   93: invokeinterface 311 1 0
    //   98: iload_2
    //   99: istore_1
    //   100: aload_0
    //   101: astore 4
    //   103: ldc 199
    //   105: ldc_w 313
    //   108: iconst_3
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iload_1
    //   115: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: ldc_w 320
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: ldc_w 321
    //   130: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: aastore
    //   134: invokestatic 324	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: iconst_m1
    //   138: istore_2
    //   139: iload_1
    //   140: iconst_m1
    //   141: if_icmpeq +253 -> 394
    //   144: aload 4
    //   146: ifnull +248 -> 394
    //   149: iload_1
    //   150: ldc_w 321
    //   153: ior
    //   154: istore_3
    //   155: new 326	android/content/ContentValues
    //   158: dup
    //   159: invokespecial 327	android/content/ContentValues:<init>	()V
    //   162: astore_0
    //   163: aload_0
    //   164: ldc_w 290
    //   167: iload_3
    //   168: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 331	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   174: aload 4
    //   176: getstatic 124	com/tencent/mm/plugin/voip/a/d:tFl	Landroid/net/Uri;
    //   179: aload_0
    //   180: ldc_w 292
    //   183: aconst_null
    //   184: invokevirtual 335	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   187: istore_1
    //   188: ldc 199
    //   190: ldc_w 337
    //   193: iconst_5
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: iload_3
    //   200: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: ldc_w 320
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: ldc_w 321
    //   215: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: dup
    //   220: iconst_3
    //   221: ldc_w 339
    //   224: aastore
    //   225: dup
    //   226: iconst_4
    //   227: iload_1
    //   228: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 324	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: iload_1
    //   236: ifle +117 -> 353
    //   239: sipush 5010
    //   242: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore 7
    //   249: aconst_null
    //   250: astore_0
    //   251: aconst_null
    //   252: astore 4
    //   254: aload_0
    //   255: astore 5
    //   257: ldc 199
    //   259: ldc_w 341
    //   262: iconst_2
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 7
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: ldc_w 321
    //   276: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   279: aastore
    //   280: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: aload_0
    //   284: ifnull +115 -> 399
    //   287: aload_0
    //   288: invokeinterface 311 1 0
    //   293: iconst_m1
    //   294: istore_1
    //   295: goto -192 -> 103
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 5
    //   302: aload 5
    //   304: ifnull +10 -> 314
    //   307: aload 5
    //   309: invokeinterface 311 1 0
    //   314: sipush 5010
    //   317: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_0
    //   321: athrow
    //   322: astore_0
    //   323: iload_2
    //   324: istore_1
    //   325: ldc 199
    //   327: ldc_w 346
    //   330: iconst_2
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload_0
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: ldc_w 321
    //   343: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: goto -115 -> 235
    //   353: sipush 5010
    //   356: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private static boolean fm(Context paramContext)
  {
    // Byte code:
    //   0: sipush 5011
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 288	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 124	com/tencent/mm/plugin/voip/a/d:tFl	Landroid/net/Uri;
    //   13: iconst_4
    //   14: anewarray 188	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 348
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 290
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 350
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: ldc_w 352
    //   40: aastore
    //   41: ldc_w 292
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 298	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 6
    //   51: aload 6
    //   53: ifnull +147 -> 200
    //   56: aload 6
    //   58: astore_0
    //   59: aload 6
    //   61: invokeinterface 303 1 0
    //   66: ifle +134 -> 200
    //   69: aload 6
    //   71: astore_0
    //   72: aload 6
    //   74: invokeinterface 306 1 0
    //   79: ifeq +121 -> 200
    //   82: aload 6
    //   84: astore_0
    //   85: aload 6
    //   87: iconst_0
    //   88: invokeinterface 310 2 0
    //   93: istore_1
    //   94: aload 6
    //   96: astore_0
    //   97: aload 6
    //   99: iconst_1
    //   100: invokeinterface 310 2 0
    //   105: istore_2
    //   106: aload 6
    //   108: astore_0
    //   109: aload 6
    //   111: iconst_2
    //   112: invokeinterface 310 2 0
    //   117: istore_3
    //   118: aload 6
    //   120: astore_0
    //   121: aload 6
    //   123: iconst_3
    //   124: invokeinterface 310 2 0
    //   129: istore 4
    //   131: iload_1
    //   132: ldc_w 321
    //   135: iand
    //   136: ldc_w 321
    //   139: if_icmpne +20 -> 159
    //   142: iload_3
    //   143: ldc_w 321
    //   146: iand
    //   147: ifne +12 -> 159
    //   150: iload 4
    //   152: ldc_w 321
    //   155: iand
    //   156: ifeq +14 -> 170
    //   159: iload_2
    //   160: ldc_w 321
    //   163: iand
    //   164: ldc_w 321
    //   167: if_icmpne +27 -> 194
    //   170: iconst_1
    //   171: istore 5
    //   173: aload 6
    //   175: ifnull +10 -> 185
    //   178: aload 6
    //   180: invokeinterface 311 1 0
    //   185: sipush 5011
    //   188: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: iload 5
    //   193: ireturn
    //   194: iconst_0
    //   195: istore 5
    //   197: goto -24 -> 173
    //   200: aload 6
    //   202: ifnull +10 -> 212
    //   205: aload 6
    //   207: invokeinterface 311 1 0
    //   212: sipush 5011
    //   215: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iconst_0
    //   219: ireturn
    //   220: astore 7
    //   222: aconst_null
    //   223: astore 6
    //   225: aload 6
    //   227: astore_0
    //   228: ldc_w 354
    //   231: ldc_w 356
    //   234: iconst_2
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 7
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: ldc_w 321
    //   248: invokestatic 318	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: invokestatic 344	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 6
    //   257: ifnull -45 -> 212
    //   260: aload 6
    //   262: invokeinterface 311 1 0
    //   267: goto -55 -> 212
    //   270: astore 6
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_0
    //   275: ifnull +9 -> 284
    //   278: aload_0
    //   279: invokeinterface 311 1 0
    //   284: sipush 5011
    //   287: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void fn(Context paramContext)
  {
    AppMethodBeat.i(5012);
    Toast.makeText(paramContext, 2131304692, 0).show();
    AppMethodBeat.o(5012);
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(5015);
    ux localux = new ux();
    localux.cLs.cut = 2;
    a.ymk.l(localux);
    boolean bool = localux.cLt.cLu;
    AppMethodBeat.o(5015);
    return bool;
  }
  
  public static int wp(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(5013);
    try
    {
      int j = bo.getInt(g.Nq().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(5013);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.d
 * JD-Core Version:    0.7.0.1
 */