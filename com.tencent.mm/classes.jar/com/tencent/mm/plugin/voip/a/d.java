package com.tencent.mm.plugin.voip.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tencent.mm.h.a.aw;
import com.tencent.mm.h.a.aw.a;
import com.tencent.mm.h.a.az;
import com.tencent.mm.h.a.az.a;
import com.tencent.mm.h.a.bi;
import com.tencent.mm.h.a.bi.a;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static final String SYS_INFO;
  public static Context pZI = null;
  private static final Uri pZJ = Uri.parse("content://com.lbe.security.miui.permmgr/active");
  
  static
  {
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
  }
  
  public static void M(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static Notification a(Notification.Builder paramBuilder)
  {
    if (com.tencent.mm.compatible.util.d.gG(16)) {
      return paramBuilder.getNotification();
    }
    return paramBuilder.build();
  }
  
  public static boolean bSi()
  {
    return true;
  }
  
  public static int bSj()
  {
    return Build.VERSION.SDK_INT;
  }
  
  /* Error */
  private static boolean bSk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: new 160	java/util/Properties
    //   10: dup
    //   11: invokespecial 161	java/util/Properties:<init>	()V
    //   14: astore 6
    //   16: new 163	java/io/FileInputStream
    //   19: dup
    //   20: new 165	java/io/File
    //   23: dup
    //   24: invokestatic 171	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   27: ldc 173
    //   29: invokespecial 176	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: invokespecial 179	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore 5
    //   37: aload 5
    //   39: astore 4
    //   41: aload 6
    //   43: aload 5
    //   45: invokevirtual 183	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   48: aload 5
    //   50: astore 4
    //   52: aload 6
    //   54: ldc 185
    //   56: aconst_null
    //   57: invokevirtual 189	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 6
    //   62: iload_1
    //   63: istore_0
    //   64: aload 6
    //   66: ifnull +23 -> 89
    //   69: aload 5
    //   71: astore 4
    //   73: aload 6
    //   75: ldc 191
    //   77: invokevirtual 197	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: istore_3
    //   81: iload_1
    //   82: istore_0
    //   83: iload_3
    //   84: ifeq +5 -> 89
    //   87: iconst_1
    //   88: istore_0
    //   89: aload 5
    //   91: invokestatic 202	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   94: ldc 204
    //   96: new 16	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 206
    //   102: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: iload_0
    //   106: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 215	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iload_0
    //   116: ireturn
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +12 -> 136
    //   127: aload 5
    //   129: astore 4
    //   131: aload 5
    //   133: invokevirtual 218	java/io/FileInputStream:close	()V
    //   136: aload 5
    //   138: invokestatic 202	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   141: iload_2
    //   142: istore_0
    //   143: goto -49 -> 94
    //   146: astore 6
    //   148: aload 4
    //   150: astore 5
    //   152: aload 6
    //   154: astore 4
    //   156: aload 5
    //   158: invokestatic 202	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   161: aload 4
    //   163: athrow
    //   164: astore 4
    //   166: goto -30 -> 136
    //   169: astore 6
    //   171: aload 4
    //   173: astore 5
    //   175: aload 6
    //   177: astore 4
    //   179: goto -23 -> 156
    //   182: astore 4
    //   184: goto -62 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	80	0	bool1	boolean
    //   6	76	1	bool2	boolean
    //   4	138	2	bool3	boolean
    //   80	4	3	bool4	boolean
    //   1	71	4	localObject1	Object
    //   117	1	4	localIOException1	java.io.IOException
    //   129	33	4	localObject2	Object
    //   164	8	4	localIOException2	java.io.IOException
    //   177	1	4	localObject3	Object
    //   182	1	4	localIOException3	java.io.IOException
    //   35	139	5	localObject4	Object
    //   14	60	6	localObject5	Object
    //   146	7	6	localObject6	Object
    //   169	7	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   7	37	117	java/io/IOException
    //   7	37	146	finally
    //   131	136	164	java/io/IOException
    //   41	48	169	finally
    //   52	62	169	finally
    //   73	81	169	finally
    //   131	136	169	finally
    //   41	48	182	java/io/IOException
    //   52	62	182	java/io/IOException
    //   73	81	182	java/io/IOException
  }
  
  public static boolean bSl()
  {
    az localaz = new az();
    a.udP.m(localaz);
    return localaz.bHl.bus;
  }
  
  public static boolean bSm()
  {
    td localtd = new td();
    localtd.ccJ.bNb = 2;
    a.udP.m(localtd);
    return localtd.ccK.ccL;
  }
  
  public static boolean bSn()
  {
    bi localbi = new bi();
    a.udP.m(localbi);
    return localbi.bHE.bus;
  }
  
  public static boolean bSo()
  {
    aw localaw = new aw();
    a.udP.m(localaw);
    return localaw.bHf.bHg;
  }
  
  public static boolean en(Context paramContext)
  {
    boolean bool = false;
    if (bSk() == true) {
      bool = eq(paramContext);
    }
    y.d("VoipUtil", "isLbePermissionEnable ret:" + bool);
    return bool;
  }
  
  public static boolean eo(Context paramContext)
  {
    boolean bool = false;
    if (bSk() == true) {
      bool = ep(paramContext);
    }
    y.d("VoipUtil", "setLbePermissionEnable ret:" + bool);
    return bool;
  }
  
  /* Error */
  private static boolean ep(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: getstatic 118	com/tencent/mm/plugin/voip/a/d:pZJ	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 193	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 313
    //   18: aastore
    //   19: ldc_w 315
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 321	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 6
    //   29: aload 6
    //   31: ifnull +349 -> 380
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: invokeinterface 326 1 0
    //   45: ifle +335 -> 380
    //   48: aload 6
    //   50: astore 5
    //   52: aload 6
    //   54: invokeinterface 329 1 0
    //   59: ifeq +321 -> 380
    //   62: aload 6
    //   64: astore 5
    //   66: aload 6
    //   68: iconst_0
    //   69: invokeinterface 333 2 0
    //   74: istore_2
    //   75: aload_0
    //   76: astore 4
    //   78: iload_2
    //   79: istore_1
    //   80: aload 6
    //   82: ifnull +15 -> 97
    //   85: aload 6
    //   87: invokeinterface 334 1 0
    //   92: iload_2
    //   93: istore_1
    //   94: aload_0
    //   95: astore 4
    //   97: ldc 204
    //   99: ldc_w 336
    //   102: iconst_3
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload_1
    //   109: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc_w 344
    //   118: aastore
    //   119: dup
    //   120: iconst_2
    //   121: ldc_w 345
    //   124: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 348	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: iconst_m1
    //   132: istore_2
    //   133: iload_1
    //   134: iconst_m1
    //   135: if_icmpeq +235 -> 370
    //   138: aload 4
    //   140: ifnull +230 -> 370
    //   143: iload_1
    //   144: ldc_w 345
    //   147: ior
    //   148: istore_3
    //   149: new 350	android/content/ContentValues
    //   152: dup
    //   153: invokespecial 351	android/content/ContentValues:<init>	()V
    //   156: astore_0
    //   157: aload_0
    //   158: ldc_w 313
    //   161: iload_3
    //   162: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 355	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   168: aload 4
    //   170: getstatic 118	com/tencent/mm/plugin/voip/a/d:pZJ	Landroid/net/Uri;
    //   173: aload_0
    //   174: ldc_w 315
    //   177: aconst_null
    //   178: invokevirtual 359	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   181: istore_1
    //   182: ldc 204
    //   184: ldc_w 361
    //   187: iconst_5
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: iload_3
    //   194: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: ldc_w 344
    //   203: aastore
    //   204: dup
    //   205: iconst_2
    //   206: ldc_w 345
    //   209: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_3
    //   215: ldc_w 363
    //   218: aastore
    //   219: dup
    //   220: iconst_4
    //   221: iload_1
    //   222: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 348	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: iload_1
    //   230: ifle +105 -> 335
    //   233: iconst_1
    //   234: ireturn
    //   235: astore 7
    //   237: aconst_null
    //   238: astore_0
    //   239: aconst_null
    //   240: astore 4
    //   242: aload_0
    //   243: astore 5
    //   245: ldc 204
    //   247: ldc_w 365
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload 7
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: ldc_w 345
    //   264: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 368	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_0
    //   272: ifnull +103 -> 375
    //   275: aload_0
    //   276: invokeinterface 334 1 0
    //   281: iconst_m1
    //   282: istore_1
    //   283: goto -186 -> 97
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 5
    //   290: aload 5
    //   292: ifnull +10 -> 302
    //   295: aload 5
    //   297: invokeinterface 334 1 0
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: iload_2
    //   306: istore_1
    //   307: ldc 204
    //   309: ldc_w 370
    //   312: iconst_2
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_0
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: ldc_w 345
    //   325: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: aastore
    //   329: invokestatic 368	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: goto -103 -> 229
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_0
    //   338: goto -31 -> 307
    //   341: astore_0
    //   342: goto -52 -> 290
    //   345: astore 7
    //   347: aconst_null
    //   348: astore 5
    //   350: aload_0
    //   351: astore 4
    //   353: aload 5
    //   355: astore_0
    //   356: goto -114 -> 242
    //   359: astore 7
    //   361: aload_0
    //   362: astore 4
    //   364: aload 6
    //   366: astore_0
    //   367: goto -125 -> 242
    //   370: iconst_m1
    //   371: istore_1
    //   372: goto -143 -> 229
    //   375: iconst_m1
    //   376: istore_1
    //   377: goto -280 -> 97
    //   380: iconst_m1
    //   381: istore_2
    //   382: goto -307 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramContext	Context
    //   79	298	1	i	int
    //   74	308	2	j	int
    //   148	46	3	k	int
    //   76	287	4	localContext	Context
    //   36	318	5	localObject	Object
    //   27	338	6	localCursor	android.database.Cursor
    //   235	22	7	localThrowable1	java.lang.Throwable
    //   345	1	7	localThrowable2	java.lang.Throwable
    //   359	1	7	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	5	235	java/lang/Throwable
    //   0	5	286	finally
    //   5	29	286	finally
    //   149	182	304	java/lang/Throwable
    //   182	229	337	java/lang/Throwable
    //   38	48	341	finally
    //   52	62	341	finally
    //   66	75	341	finally
    //   245	271	341	finally
    //   5	29	345	java/lang/Throwable
    //   38	48	359	java/lang/Throwable
    //   52	62	359	java/lang/Throwable
    //   66	75	359	java/lang/Throwable
  }
  
  /* Error */
  private static boolean eq(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 311	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 118	com/tencent/mm/plugin/voip/a/d:pZJ	Landroid/net/Uri;
    //   7: iconst_4
    //   8: anewarray 193	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc_w 372
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: ldc_w 313
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: ldc_w 374
    //   28: aastore
    //   29: dup
    //   30: iconst_3
    //   31: ldc_w 376
    //   34: aastore
    //   35: ldc_w 315
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 321	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +141 -> 188
    //   50: aload 6
    //   52: astore_0
    //   53: aload 6
    //   55: invokeinterface 326 1 0
    //   60: ifle +128 -> 188
    //   63: aload 6
    //   65: astore_0
    //   66: aload 6
    //   68: invokeinterface 329 1 0
    //   73: ifeq +115 -> 188
    //   76: aload 6
    //   78: astore_0
    //   79: aload 6
    //   81: iconst_0
    //   82: invokeinterface 333 2 0
    //   87: istore_1
    //   88: aload 6
    //   90: astore_0
    //   91: aload 6
    //   93: iconst_1
    //   94: invokeinterface 333 2 0
    //   99: istore_2
    //   100: aload 6
    //   102: astore_0
    //   103: aload 6
    //   105: iconst_2
    //   106: invokeinterface 333 2 0
    //   111: istore_3
    //   112: aload 6
    //   114: astore_0
    //   115: aload 6
    //   117: iconst_3
    //   118: invokeinterface 333 2 0
    //   123: istore 4
    //   125: iload_1
    //   126: ldc_w 345
    //   129: iand
    //   130: ldc_w 345
    //   133: if_icmpne +20 -> 153
    //   136: iload_3
    //   137: ldc_w 345
    //   140: iand
    //   141: ifne +12 -> 153
    //   144: iload 4
    //   146: ldc_w 345
    //   149: iand
    //   150: ifeq +14 -> 164
    //   153: iload_2
    //   154: ldc_w 345
    //   157: iand
    //   158: ldc_w 345
    //   161: if_icmpne +21 -> 182
    //   164: iconst_1
    //   165: istore 5
    //   167: aload 6
    //   169: ifnull +10 -> 179
    //   172: aload 6
    //   174: invokeinterface 334 1 0
    //   179: iload 5
    //   181: ireturn
    //   182: iconst_0
    //   183: istore 5
    //   185: goto -18 -> 167
    //   188: aload 6
    //   190: ifnull +10 -> 200
    //   193: aload 6
    //   195: invokeinterface 334 1 0
    //   200: iconst_0
    //   201: ireturn
    //   202: astore 7
    //   204: aconst_null
    //   205: astore 6
    //   207: aload 6
    //   209: astore_0
    //   210: ldc_w 378
    //   213: ldc_w 380
    //   216: iconst_2
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload 7
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: ldc_w 345
    //   230: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: invokestatic 368	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aload 6
    //   239: ifnull -39 -> 200
    //   242: aload 6
    //   244: invokeinterface 334 1 0
    //   249: goto -49 -> 200
    //   252: astore 6
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +9 -> 266
    //   260: aload_0
    //   261: invokeinterface 334 1 0
    //   266: aload 6
    //   268: athrow
    //   269: astore 6
    //   271: goto -15 -> 256
    //   274: astore 7
    //   276: goto -69 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramContext	Context
    //   87	43	1	i	int
    //   99	59	2	j	int
    //   111	30	3	k	int
    //   123	27	4	m	int
    //   165	19	5	bool	boolean
    //   43	200	6	localCursor	android.database.Cursor
    //   252	15	6	localObject1	Object
    //   269	1	6	localObject2	Object
    //   202	21	7	localThrowable1	java.lang.Throwable
    //   274	1	7	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	45	202	java/lang/Throwable
    //   0	45	252	finally
    //   53	63	269	finally
    //   66	76	269	finally
    //   79	88	269	finally
    //   91	100	269	finally
    //   103	112	269	finally
    //   115	125	269	finally
    //   210	237	269	finally
    //   53	63	274	java/lang/Throwable
    //   66	76	274	java/lang/Throwable
    //   79	88	274	java/lang/Throwable
    //   91	100	274	java/lang/Throwable
    //   103	112	274	java/lang/Throwable
    //   115	125	274	java/lang/Throwable
  }
  
  public static int oX(String paramString)
  {
    try
    {
      int i = bk.getInt(g.AA().getValue(paramString), 0);
      return i;
    }
    catch (Exception localException)
    {
      y.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: " + paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.d
 * JD-Core Version:    0.7.0.1
 */