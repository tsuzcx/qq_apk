package com.tencent.mm.plugin.voip.f;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.widget.Toast;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.a.bx;
import com.tencent.mm.autogen.a.bx.a;
import com.tencent.mm.autogen.a.bz;
import com.tencent.mm.autogen.a.bz.a;
import com.tencent.mm.autogen.a.ci;
import com.tencent.mm.autogen.a.ci.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m
{
  private static final String SYS_INFO;
  public static Context UMe;
  private static final Uri UMf;
  
  static
  {
    AppMethodBeat.i(115542);
    UMe = null;
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
    localStringBuilder.append("] MODEL:[" + q.aPo());
    localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    localStringBuilder.append("] TAGS:[" + Build.TAGS);
    localStringBuilder.append("] TYPE:[" + Build.TYPE);
    localStringBuilder.append("] USER:[" + Build.USER + "]");
    SYS_INFO = localStringBuilder.toString();
    UMf = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    AppMethodBeat.o(115542);
  }
  
  public static int RW(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(115536);
    try
    {
      int j = Util.getInt(i.aRC().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(115536);
    return i;
  }
  
  public static void bd(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(292750);
    Toast.makeText(paramContext, paramInt, 0).show();
    AppMethodBeat.o(292750);
  }
  
  public static Notification e(f.d paramd)
  {
    AppMethodBeat.i(292781);
    if (d.rc(16))
    {
      paramd = paramd.DA();
      AppMethodBeat.o(292781);
      return paramd;
    }
    paramd = paramd.DA();
    AppMethodBeat.o(292781);
    return paramd;
  }
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static boolean icb()
  {
    return true;
  }
  
  /* Error */
  private static boolean icc()
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
    //   10: ldc 211
    //   12: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: aload 6
    //   17: astore 4
    //   19: aload 7
    //   21: astore 5
    //   23: new 213	java/util/Properties
    //   26: dup
    //   27: invokespecial 214	java/util/Properties:<init>	()V
    //   30: astore 8
    //   32: aload 6
    //   34: astore 4
    //   36: aload 7
    //   38: astore 5
    //   40: new 216	com/tencent/mm/vfs/u
    //   43: dup
    //   44: invokestatic 222	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   47: ldc 224
    //   49: invokespecial 227	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: invokestatic 233	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   55: astore 6
    //   57: aload 6
    //   59: astore 4
    //   61: aload 6
    //   63: astore 5
    //   65: aload 8
    //   67: aload 6
    //   69: invokevirtual 237	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   72: aload 6
    //   74: astore 4
    //   76: aload 6
    //   78: astore 5
    //   80: aload 8
    //   82: ldc 239
    //   84: aconst_null
    //   85: invokevirtual 243	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   107: ldc 245
    //   109: invokevirtual 249	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: istore_3
    //   113: iload_1
    //   114: istore_0
    //   115: iload_3
    //   116: ifeq +5 -> 121
    //   119: iconst_1
    //   120: istore_0
    //   121: aload 6
    //   123: invokestatic 255	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   126: ldc 156
    //   128: ldc_w 257
    //   131: iload_0
    //   132: invokestatic 260	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   135: invokevirtual 167	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 263	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 211
    //   143: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload_0
    //   147: ireturn
    //   148: astore 5
    //   150: aload 4
    //   152: ifnull +12 -> 164
    //   155: aload 4
    //   157: astore 5
    //   159: aload 4
    //   161: invokevirtual 268	java/io/InputStream:close	()V
    //   164: aload 4
    //   166: invokestatic 255	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   169: iload_2
    //   170: istore_0
    //   171: goto -45 -> 126
    //   174: astore 4
    //   176: aload 5
    //   178: invokestatic 255	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   181: ldc 211
    //   183: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload 4
    //   188: athrow
    //   189: astore 5
    //   191: goto -27 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   91	80	0	bool1	boolean
    //   9	105	1	bool2	boolean
    //   7	163	2	bool3	boolean
    //   112	4	3	bool4	boolean
    //   17	148	4	localInputStream1	java.io.InputStream
    //   174	13	4	localObject1	Object
    //   21	83	5	localObject2	Object
    //   148	1	5	localIOException1	java.io.IOException
    //   157	20	5	localInputStream2	java.io.InputStream
    //   189	1	5	localIOException2	java.io.IOException
    //   4	118	6	localInputStream3	java.io.InputStream
    //   1	105	7	str	String
    //   30	51	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   23	32	148	java/io/IOException
    //   40	57	148	java/io/IOException
    //   65	72	148	java/io/IOException
    //   80	90	148	java/io/IOException
    //   105	113	148	java/io/IOException
    //   23	32	174	finally
    //   40	57	174	finally
    //   65	72	174	finally
    //   80	90	174	finally
    //   105	113	174	finally
    //   159	164	174	finally
    //   159	164	189	java/io/IOException
  }
  
  public static boolean icd()
  {
    AppMethodBeat.i(115537);
    bz localbz = new bz();
    localbz.publish();
    boolean bool = localbz.hBZ.isStarted;
    AppMethodBeat.o(115537);
    return bool;
  }
  
  public static boolean ice()
  {
    AppMethodBeat.i(115539);
    ci localci = new ci();
    localci.publish();
    boolean bool = localci.hCs.isStarted;
    AppMethodBeat.o(115539);
    return bool;
  }
  
  public static boolean icf()
  {
    AppMethodBeat.i(115540);
    bx localbx = new bx();
    localbx.publish();
    boolean bool = localbx.hBU.hBV;
    AppMethodBeat.o(115540);
    return bool;
  }
  
  public static boolean isVoipStarted()
  {
    AppMethodBeat.i(115538);
    acn localacn = new acn();
    localacn.ifU.hId = 2;
    localacn.publish();
    boolean bool = localacn.ifV.calling;
    AppMethodBeat.o(115538);
    return bool;
  }
  
  /* Error */
  private static boolean kA(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 341
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 347	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore_0
    //   11: aload_0
    //   12: getstatic 127	com/tencent/mm/plugin/voip/f/m:UMf	Landroid/net/Uri;
    //   15: iconst_1
    //   16: anewarray 160	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 349
    //   24: aastore
    //   25: ldc_w 351
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 357	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 5
    //   35: aload 5
    //   37: ifnull +341 -> 378
    //   40: aload 5
    //   42: invokeinterface 362 1 0
    //   47: ifle +331 -> 378
    //   50: aload 5
    //   52: invokeinterface 365 1 0
    //   57: ifeq +321 -> 378
    //   60: aload 5
    //   62: iconst_0
    //   63: invokeinterface 368 2 0
    //   68: istore_2
    //   69: aload_0
    //   70: astore 4
    //   72: iload_2
    //   73: istore_1
    //   74: aload 5
    //   76: ifnull +15 -> 91
    //   79: aload 5
    //   81: invokeinterface 369 1 0
    //   86: iload_2
    //   87: istore_1
    //   88: aload_0
    //   89: astore 4
    //   91: ldc 156
    //   93: ldc_w 371
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: iload_1
    //   103: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: ldc_w 378
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: ldc_w 379
    //   118: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: invokestatic 382	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: iconst_m1
    //   126: istore_2
    //   127: iload_1
    //   128: iconst_m1
    //   129: if_icmpeq +236 -> 365
    //   132: aload 4
    //   134: ifnull +231 -> 365
    //   137: iload_1
    //   138: ldc_w 379
    //   141: ior
    //   142: istore_3
    //   143: new 384	android/content/ContentValues
    //   146: dup
    //   147: invokespecial 385	android/content/ContentValues:<init>	()V
    //   150: astore_0
    //   151: aload_0
    //   152: ldc_w 349
    //   155: iload_3
    //   156: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokevirtual 389	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   162: aload 4
    //   164: getstatic 127	com/tencent/mm/plugin/voip/f/m:UMf	Landroid/net/Uri;
    //   167: aload_0
    //   168: ldc_w 351
    //   171: aconst_null
    //   172: invokevirtual 393	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   175: istore_1
    //   176: ldc 156
    //   178: ldc_w 395
    //   181: iconst_5
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: iload_3
    //   188: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: ldc_w 378
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: ldc_w 379
    //   203: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: ldc_w 397
    //   212: aastore
    //   213: dup
    //   214: iconst_4
    //   215: iload_1
    //   216: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: invokestatic 382	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: iload_1
    //   224: ifle +116 -> 340
    //   227: ldc_w 341
    //   230: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: iconst_1
    //   234: ireturn
    //   235: astore 4
    //   237: aconst_null
    //   238: astore 5
    //   240: aconst_null
    //   241: astore_0
    //   242: ldc 156
    //   244: ldc_w 399
    //   247: iconst_2
    //   248: anewarray 4	java/lang/Object
    //   251: dup
    //   252: iconst_0
    //   253: aload 4
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: ldc_w 379
    //   261: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 402	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 5
    //   270: ifnull +100 -> 370
    //   273: aload 5
    //   275: invokeinterface 369 1 0
    //   280: iconst_m1
    //   281: istore_1
    //   282: aload_0
    //   283: astore 4
    //   285: goto -194 -> 91
    //   288: astore_0
    //   289: aload 5
    //   291: ifnull +10 -> 301
    //   294: aload 5
    //   296: invokeinterface 369 1 0
    //   301: ldc_w 341
    //   304: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_0
    //   308: athrow
    //   309: astore_0
    //   310: iload_2
    //   311: istore_1
    //   312: ldc 156
    //   314: ldc_w 404
    //   317: iconst_2
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: aload_0
    //   324: aastore
    //   325: dup
    //   326: iconst_1
    //   327: ldc_w 379
    //   330: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: invokestatic 402	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: goto -114 -> 223
    //   340: ldc_w 341
    //   343: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: iconst_0
    //   347: ireturn
    //   348: astore_0
    //   349: goto -37 -> 312
    //   352: astore 4
    //   354: aconst_null
    //   355: astore 5
    //   357: goto -115 -> 242
    //   360: astore 4
    //   362: goto -120 -> 242
    //   365: iconst_m1
    //   366: istore_1
    //   367: goto -144 -> 223
    //   370: iconst_m1
    //   371: istore_1
    //   372: aload_0
    //   373: astore 4
    //   375: goto -284 -> 91
    //   378: iconst_m1
    //   379: istore_2
    //   380: goto -311 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramContext	Context
    //   73	299	1	i	int
    //   68	312	2	j	int
    //   142	46	3	k	int
    //   70	93	4	localContext1	Context
    //   235	19	4	localObject1	Object
    //   283	1	4	localContext2	Context
    //   352	1	4	localObject2	Object
    //   360	1	4	localObject3	Object
    //   373	1	4	localContext3	Context
    //   33	323	5	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   6	11	235	finally
    //   242	268	288	finally
    //   143	176	309	finally
    //   176	223	348	finally
    //   11	35	352	finally
    //   40	69	360	finally
  }
  
  /* Error */
  private static boolean kB(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 406
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 347	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: getstatic 127	com/tencent/mm/plugin/voip/f/m:UMf	Landroid/net/Uri;
    //   13: iconst_4
    //   14: anewarray 160	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 408
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 349
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 410
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: ldc_w 412
    //   40: aastore
    //   41: ldc_w 351
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 357	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +121 -> 172
    //   54: aload_0
    //   55: invokeinterface 362 1 0
    //   60: ifle +112 -> 172
    //   63: aload_0
    //   64: invokeinterface 365 1 0
    //   69: ifeq +103 -> 172
    //   72: aload_0
    //   73: iconst_0
    //   74: invokeinterface 368 2 0
    //   79: istore_1
    //   80: aload_0
    //   81: iconst_1
    //   82: invokeinterface 368 2 0
    //   87: istore_2
    //   88: aload_0
    //   89: iconst_2
    //   90: invokeinterface 368 2 0
    //   95: istore_3
    //   96: aload_0
    //   97: iconst_3
    //   98: invokeinterface 368 2 0
    //   103: istore 4
    //   105: iload_1
    //   106: ldc_w 379
    //   109: iand
    //   110: ldc_w 379
    //   113: if_icmpne +20 -> 133
    //   116: iload_3
    //   117: ldc_w 379
    //   120: iand
    //   121: ifne +12 -> 133
    //   124: iload 4
    //   126: ldc_w 379
    //   129: iand
    //   130: ifeq +14 -> 144
    //   133: iload_2
    //   134: ldc_w 379
    //   137: iand
    //   138: ldc_w 379
    //   141: if_icmpne +25 -> 166
    //   144: iconst_1
    //   145: istore 5
    //   147: aload_0
    //   148: ifnull +9 -> 157
    //   151: aload_0
    //   152: invokeinterface 369 1 0
    //   157: ldc_w 406
    //   160: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iload 5
    //   165: ireturn
    //   166: iconst_0
    //   167: istore 5
    //   169: goto -22 -> 147
    //   172: aload_0
    //   173: ifnull +9 -> 182
    //   176: aload_0
    //   177: invokeinterface 369 1 0
    //   182: ldc_w 406
    //   185: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: iconst_0
    //   189: ireturn
    //   190: astore 6
    //   192: aconst_null
    //   193: astore_0
    //   194: ldc_w 414
    //   197: ldc_w 416
    //   200: iconst_2
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload 6
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: ldc_w 379
    //   214: invokestatic 376	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: aastore
    //   218: invokestatic 402	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload_0
    //   222: ifnull -40 -> 182
    //   225: aload_0
    //   226: invokeinterface 369 1 0
    //   231: goto -49 -> 182
    //   234: astore 6
    //   236: aload_0
    //   237: ifnull +9 -> 246
    //   240: aload_0
    //   241: invokeinterface 369 1 0
    //   246: ldc_w 406
    //   249: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 6
    //   254: athrow
    //   255: astore 6
    //   257: goto -63 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramContext	Context
    //   79	31	1	i	int
    //   87	51	2	j	int
    //   95	26	3	k	int
    //   103	27	4	m	int
    //   145	23	5	bool	boolean
    //   190	17	6	localObject1	Object
    //   234	19	6	localObject2	Object
    //   255	1	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	50	190	finally
    //   194	221	234	finally
    //   54	105	255	finally
  }
  
  public static boolean ky(Context paramContext)
  {
    AppMethodBeat.i(115531);
    boolean bool = false;
    if (icc() == true) {
      bool = kB(paramContext);
    }
    Log.d("VoipUtil", "isLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(115531);
    return bool;
  }
  
  public static boolean kz(Context paramContext)
  {
    AppMethodBeat.i(115532);
    boolean bool = false;
    if (icc() == true) {
      bool = kA(paramContext);
    }
    Log.d("VoipUtil", "setLbePermissionEnable ret:".concat(String.valueOf(bool)));
    AppMethodBeat.o(115532);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.m
 * JD-Core Version:    0.7.0.1
 */