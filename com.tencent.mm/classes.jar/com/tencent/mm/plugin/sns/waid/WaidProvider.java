package com.tencent.mm.plugin.sns.waid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.ArrayList;
import java.util.Iterator;

public class WaidProvider
  extends ContentProvider
{
  private static final String AUTHORITY;
  private static String[] RYQ;
  private long RYR;
  private int RYS;
  private a RYT;
  private volatile boolean RYU;
  private final Object mLock;
  private UriMatcher mUriMatcher;
  
  static
  {
    AppMethodBeat.i(100606);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_WAIDPROVIDER();
    RYQ = new String[] { "pkg", "appWaid", "errCode" };
    AppMethodBeat.o(100606);
  }
  
  public WaidProvider()
  {
    AppMethodBeat.i(100598);
    this.mUriMatcher = new UriMatcher(-1);
    this.RYS = 0;
    this.mLock = new Object();
    this.RYU = false;
    AppMethodBeat.o(100598);
  }
  
  /* Error */
  private boolean a(com.tencent.mm.pointers.PInt arg1)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 81
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 83
    //   11: new 85	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 87
    //   17: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   23: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc 102
    //   28: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:RYU	Z
    //   35: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   47: ifeq +17 -> 64
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:RYU	Z
    //   55: ldc 81
    //   57: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:RYU	Z
    //   69: aload_1
    //   70: iconst_1
    //   71: putfield 118	com/tencent/mm/pointers/PInt:value	I
    //   74: new 9	com/tencent/mm/plugin/sns/waid/WaidProvider$b
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 121	com/tencent/mm/plugin/sns/waid/WaidProvider$b:<init>	(Lcom/tencent/mm/plugin/sns/waid/WaidProvider;)V
    //   82: invokevirtual 124	com/tencent/mm/plugin/sns/waid/WaidProvider$b:start	()V
    //   85: ldc 83
    //   87: ldc 126
    //   89: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   95: lstore_3
    //   96: aload_0
    //   97: getfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:RYU	Z
    //   100: ifne +69 -> 169
    //   103: aload_0
    //   104: getfield 74	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 74	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   114: invokevirtual 135	java/lang/Object:wait	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: goto -23 -> 96
    //   122: astore 5
    //   124: aload_1
    //   125: monitorexit
    //   126: ldc 81
    //   128: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload 5
    //   133: athrow
    //   134: astore_1
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore 5
    //   141: ldc 83
    //   143: new 85	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 137
    //   149: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload 5
    //   154: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   157: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -49 -> 117
    //   169: ldc 83
    //   171: new 85	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 143
    //   177: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   183: lload_3
    //   184: lsub
    //   185: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc 148
    //   190: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   196: aload_0
    //   197: getfield 150	com/tencent/mm/plugin/sns/waid/WaidProvider:RYR	J
    //   200: lsub
    //   201: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc 152
    //   206: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:RYS	I
    //   213: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:RYS	I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:RYS	I
    //   232: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   235: ifne +25 -> 260
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:RYU	Z
    //   243: ldc 83
    //   245: ldc 157
    //   247: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: ldc 81
    //   252: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -197 -> 60
    //   260: ldc 83
    //   262: ldc 159
    //   264: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: ldc 81
    //   269: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: goto -212 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	WaidProvider
    //   1	256	2	bool	boolean
    //   95	89	3	l	long
    //   122	10	5	localObject	Object
    //   139	14	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   110	117	122	finally
    //   117	119	122	finally
    //   141	166	122	finally
    //   4	60	134	finally
    //   64	96	134	finally
    //   96	110	134	finally
    //   124	134	134	finally
    //   169	255	134	finally
    //   260	272	134	finally
    //   110	117	139	java/lang/Exception
  }
  
  private static MatrixCursor aB(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(306391);
    MatrixCursor localMatrixCursor = new MatrixCursor(RYQ, 1);
    MatrixCursor.RowBuilder localRowBuilder = localMatrixCursor.newRow();
    localRowBuilder.add("pkg", paramString1);
    localRowBuilder.add("appWaid", paramString2);
    localRowBuilder.add("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(306391);
    return localMatrixCursor;
  }
  
  /* Error */
  private Cursor c(Uri paramUri, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 187
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   10: lstore 7
    //   12: ldc 189
    //   14: astore 11
    //   16: ldc 189
    //   18: astore 12
    //   20: aload_0
    //   21: invokespecial 193	com/tencent/mm/plugin/sns/waid/WaidProvider:htj	()Lcom/tencent/mm/plugin/sns/waid/WaidProvider$a;
    //   24: astore 13
    //   26: aload 12
    //   28: astore 10
    //   30: aload_2
    //   31: ifnull +23 -> 54
    //   34: aload 12
    //   36: astore 10
    //   38: aload_2
    //   39: arraylength
    //   40: ifle +14 -> 54
    //   43: aload_2
    //   44: iconst_0
    //   45: aaload
    //   46: invokestatic 199	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 202	java/lang/String:trim	()Ljava/lang/String;
    //   52: astore 10
    //   54: ldc 83
    //   56: new 85	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 204
    //   62: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload 10
    //   67: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 206
    //   72: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 13
    //   77: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   80: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 211
    //   85: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokestatic 217	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   91: invokevirtual 221	java/lang/Object:hashCode	()I
    //   94: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: new 115	com/tencent/mm/pointers/PInt
    //   106: dup
    //   107: invokespecial 222	com/tencent/mm/pointers/PInt:<init>	()V
    //   110: astore 12
    //   112: aload_0
    //   113: aload 12
    //   115: invokespecial 224	com/tencent/mm/plugin/sns/waid/WaidProvider:a	(Lcom/tencent/mm/pointers/PInt;)Z
    //   118: ifne +26 -> 144
    //   121: ldc 83
    //   123: ldc 226
    //   125: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: ldc 189
    //   130: ldc 189
    //   132: iconst_m1
    //   133: invokestatic 228	com/tencent/mm/plugin/sns/waid/WaidProvider:aB	(Ljava/lang/String;Ljava/lang/String;I)Landroid/database/MatrixCursor;
    //   136: astore_1
    //   137: ldc 187
    //   139: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: areturn
    //   144: aload 13
    //   146: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   149: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifeq +83 -> 235
    //   155: ldc 83
    //   157: ldc 236
    //   159: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc 189
    //   164: astore_1
    //   165: aload 11
    //   167: astore_2
    //   168: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   171: lload 7
    //   173: lsub
    //   174: l2i
    //   175: istore 4
    //   177: aload 13
    //   179: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   182: astore 11
    //   184: aload 13
    //   186: getfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   189: istore 5
    //   191: aload 12
    //   193: getfield 118	com/tencent/mm/pointers/PInt:value	I
    //   196: istore 6
    //   198: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:hti	()Z
    //   201: ifne +194 -> 395
    //   204: ldc 241
    //   206: ldc 243
    //   208: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 13
    //   213: aload 10
    //   215: invokestatic 248	com/tencent/mm/plugin/sns/waid/c:a	(Lcom/tencent/mm/plugin/sns/waid/WaidProvider$a;Ljava/lang/String;)V
    //   218: aload_1
    //   219: aload_2
    //   220: invokestatic 199	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   223: iload_3
    //   224: invokestatic 228	com/tencent/mm/plugin/sns/waid/WaidProvider:aB	(Ljava/lang/String;Ljava/lang/String;I)Landroid/database/MatrixCursor;
    //   227: astore_1
    //   228: ldc 187
    //   230: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_1
    //   234: areturn
    //   235: invokestatic 251	com/tencent/mm/plugin/sns/waid/b:htf	()Z
    //   238: ifne +21 -> 259
    //   241: ldc 83
    //   243: ldc 253
    //   245: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: ldc 189
    //   250: astore_1
    //   251: iconst_2
    //   252: istore_3
    //   253: aload 11
    //   255: astore_2
    //   256: goto -88 -> 168
    //   259: aload_0
    //   260: getfield 67	com/tencent/mm/plugin/sns/waid/WaidProvider:mUriMatcher	Landroid/content/UriMatcher;
    //   263: aload_1
    //   264: invokevirtual 257	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   267: iconst_1
    //   268: if_icmpeq +22 -> 290
    //   271: ldc 83
    //   273: ldc_w 259
    //   276: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: iconst_3
    //   280: istore_3
    //   281: ldc 189
    //   283: astore_1
    //   284: aload 11
    //   286: astore_2
    //   287: goto -119 -> 168
    //   290: aload 10
    //   292: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   295: ifeq +298 -> 593
    //   298: aload 13
    //   300: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   303: astore_1
    //   304: aload 13
    //   306: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   309: aload_1
    //   310: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifne +46 -> 359
    //   316: ldc 83
    //   318: new 85	java/lang/StringBuilder
    //   321: dup
    //   322: ldc_w 265
    //   325: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc 206
    //   334: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 13
    //   339: getfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   342: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: iconst_4
    //   352: istore_3
    //   353: aload 11
    //   355: astore_2
    //   356: goto -188 -> 168
    //   359: aload_1
    //   360: invokestatic 268	com/tencent/mm/plugin/sns/waid/b:bbs	(Ljava/lang/String;)Ljava/lang/String;
    //   363: astore_2
    //   364: ldc 83
    //   366: ldc_w 270
    //   369: aload_2
    //   370: invokestatic 273	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   373: invokevirtual 276	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   376: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_2
    //   380: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   383: istore 9
    //   385: iload 9
    //   387: ifeq +201 -> 588
    //   390: iconst_5
    //   391: istore_3
    //   392: goto -224 -> 168
    //   395: new 278	org/json/JSONObject
    //   398: dup
    //   399: invokespecial 279	org/json/JSONObject:<init>	()V
    //   402: astore 12
    //   404: aload 12
    //   406: ldc_w 281
    //   409: aload 11
    //   411: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload 12
    //   417: ldc_w 287
    //   420: iload 5
    //   422: invokevirtual 290	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   425: pop
    //   426: aload 12
    //   428: ldc_w 292
    //   431: aload 10
    //   433: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   436: pop
    //   437: aload 12
    //   439: ldc 51
    //   441: iload_3
    //   442: invokevirtual 290	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   445: pop
    //   446: aload 12
    //   448: ldc_w 294
    //   451: iload 6
    //   453: invokevirtual 290	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 12
    //   459: ldc_w 296
    //   462: iload 4
    //   464: invokevirtual 290	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   467: pop
    //   468: aload 12
    //   470: invokevirtual 297	org/json/JSONObject:toString	()Ljava/lang/String;
    //   473: invokestatic 300	com/tencent/mm/plugin/sns/waid/c:bbu	(Ljava/lang/String;)Ljava/lang/String;
    //   476: astore 11
    //   478: ldc 241
    //   480: ldc_w 302
    //   483: aload 11
    //   485: invokestatic 273	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   488: invokevirtual 276	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: getstatic 308	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   497: sipush 18666
    //   500: iconst_2
    //   501: anewarray 71	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: sipush 2000
    //   509: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: aastore
    //   513: dup
    //   514: iconst_1
    //   515: aload 11
    //   517: aastore
    //   518: invokevirtual 311	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   521: goto -310 -> 211
    //   524: astore 11
    //   526: ldc 241
    //   528: new 85	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 313
    //   535: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload 11
    //   540: invokestatic 319	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   543: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -341 -> 211
    //   555: astore_1
    //   556: ldc 83
    //   558: new 85	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 321
    //   565: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload_1
    //   569: invokevirtual 324	java/lang/Throwable:toString	()Ljava/lang/String;
    //   572: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: ldc 187
    //   583: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: aconst_null
    //   587: areturn
    //   588: iconst_0
    //   589: istore_3
    //   590: goto -422 -> 168
    //   593: aload 10
    //   595: astore_1
    //   596: goto -292 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	WaidProvider
    //   0	599	1	paramUri	Uri
    //   0	599	2	paramArrayOfString	String[]
    //   1	589	3	i	int
    //   175	288	4	j	int
    //   189	232	5	k	int
    //   196	256	6	m	int
    //   10	162	7	l	long
    //   383	3	9	bool	boolean
    //   28	566	10	localObject1	Object
    //   14	502	11	str	String
    //   524	15	11	localThrowable	java.lang.Throwable
    //   18	451	12	localObject2	Object
    //   24	314	13	locala	a
    // Exception table:
    //   from	to	target	type
    //   395	521	524	finally
    //   7	12	555	finally
    //   20	26	555	finally
    //   38	54	555	finally
    //   54	137	555	finally
    //   144	162	555	finally
    //   168	211	555	finally
    //   211	228	555	finally
    //   235	248	555	finally
    //   259	279	555	finally
    //   290	304	555	finally
    //   304	351	555	finally
    //   359	385	555	finally
    //   526	552	555	finally
  }
  
  /* Error */
  private a htj()
  {
    // Byte code:
    //   0: ldc_w 326
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/sns/waid/WaidProvider$a
    //   9: dup
    //   10: invokespecial 327	com/tencent/mm/plugin/sns/waid/WaidProvider$a:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: invokevirtual 330	com/tencent/mm/plugin/sns/waid/WaidProvider:getCallingPackage	()Ljava/lang/String;
    //   19: putfield 333	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYV	Ljava/lang/String;
    //   22: invokestatic 338	android/os/Binder:getCallingUid	()I
    //   25: istore_1
    //   26: aload_3
    //   27: aload_0
    //   28: invokevirtual 342	com/tencent/mm/plugin/sns/waid/WaidProvider:getContext	()Landroid/content/Context;
    //   31: invokevirtual 348	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: iload_1
    //   35: invokevirtual 354	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   38: putfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   41: aload_3
    //   42: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   45: ifnull +207 -> 252
    //   48: aload_3
    //   49: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   52: arraylength
    //   53: ifle +199 -> 252
    //   56: aload_3
    //   57: getfield 333	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYV	Ljava/lang/String;
    //   60: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +88 -> 151
    //   66: aload_3
    //   67: iconst_1
    //   68: putfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   71: aload_3
    //   72: aload_3
    //   73: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   76: iconst_0
    //   77: aaload
    //   78: putfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   81: ldc_w 326
    //   84: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: areturn
    //   89: astore 4
    //   91: ldc 83
    //   93: new 85	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 359
    //   100: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload 4
    //   105: invokevirtual 324	java/lang/Throwable:toString	()Ljava/lang/String;
    //   108: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: goto -95 -> 22
    //   120: astore 4
    //   122: ldc 83
    //   124: new 85	java/lang/StringBuilder
    //   127: dup
    //   128: ldc_w 361
    //   131: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload 4
    //   136: invokevirtual 324	java/lang/Throwable:toString	()Ljava/lang/String;
    //   139: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -107 -> 41
    //   151: aload_3
    //   152: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   155: astore 4
    //   157: aload 4
    //   159: arraylength
    //   160: istore_2
    //   161: iconst_0
    //   162: istore_1
    //   163: iload_1
    //   164: iload_2
    //   165: if_icmpge +64 -> 229
    //   168: aload 4
    //   170: iload_1
    //   171: aaload
    //   172: astore 5
    //   174: aload_3
    //   175: getfield 333	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYV	Ljava/lang/String;
    //   178: aload 5
    //   180: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +39 -> 222
    //   186: aload_3
    //   187: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   190: arraylength
    //   191: iconst_1
    //   192: if_icmple +22 -> 214
    //   195: aload_3
    //   196: iconst_2
    //   197: putfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   200: aload_3
    //   201: aload 5
    //   203: putfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   206: ldc_w 326
    //   209: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_3
    //   213: areturn
    //   214: aload_3
    //   215: iconst_3
    //   216: putfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   219: goto -19 -> 200
    //   222: iload_1
    //   223: iconst_1
    //   224: iadd
    //   225: istore_1
    //   226: goto -63 -> 163
    //   229: aload_3
    //   230: iconst_4
    //   231: putfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   234: aload_3
    //   235: aload_3
    //   236: getfield 357	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYW	[Ljava/lang/String;
    //   239: iconst_0
    //   240: aaload
    //   241: putfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   244: ldc_w 326
    //   247: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_3
    //   251: areturn
    //   252: aload_3
    //   253: iconst_5
    //   254: putfield 239	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYX	I
    //   257: aload_3
    //   258: aload_3
    //   259: getfield 333	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYV	Ljava/lang/String;
    //   262: putfield 209	com/tencent/mm/plugin/sns/waid/WaidProvider$a:RYY	Ljava/lang/String;
    //   265: ldc_w 326
    //   268: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_3
    //   272: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	WaidProvider
    //   25	201	1	i	int
    //   160	6	2	j	int
    //   13	259	3	locala	a
    //   89	15	4	localObject1	Object
    //   120	15	4	localObject2	Object
    //   155	14	4	arrayOfString	String[]
    //   172	30	5	str	String
    // Exception table:
    //   from	to	target	type
    //   14	22	89	finally
    //   22	41	120	finally
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(100601);
    AppMethodBeat.o(100601);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(100600);
    AppMethodBeat.o(100600);
    return null;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(100599);
    this.mUriMatcher.addURI(AUTHORITY, "appWaid", 1);
    this.RYR = System.currentTimeMillis();
    this.RYT = new a();
    a locala = this.RYT;
    try
    {
      Log.i("InitTaskMgr", "start");
      Iterator localIterator = locala.RYN.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        locala.Qjm.post(localRunnable);
        continue;
        Log.i("ad.waid.WaidProvider", "onCreate, this.hash=" + hashCode());
      }
    }
    catch (Exception localException)
    {
      Log.e("InitTaskMgr", "startInit exp=" + localException.toString());
    }
    for (;;)
    {
      AppMethodBeat.o(100599);
      return true;
      localException.RYN.clear();
      localException.Qjn.quitSafely();
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(100602);
    paramUri = c(paramUri, paramArrayOfString2);
    AppMethodBeat.o(100602);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected static final class a
  {
    String RYV;
    String[] RYW;
    int RYX;
    String RYY;
  }
  
  final class b
    extends Thread
  {
    private int RYZ;
    private int hHM;
    
    public b()
    {
      AppMethodBeat.i(306354);
      this.hHM = 0;
      this.RYZ = 12000;
      int j = 12000 - WaidProvider.a(WaidProvider.this) * 4000;
      if (j < 2000) {}
      for (;;)
      {
        this.RYZ = i;
        AppMethodBeat.o(306354);
        return;
        i = j;
      }
    }
    
    private void htk()
    {
      AppMethodBeat.i(306358);
      synchronized (WaidProvider.b(WaidProvider.this))
      {
        Log.i("ad.waid.WaidProvider", "break Wait, waitTime=" + this.hHM);
        WaidProvider.c(WaidProvider.this);
        WaidProvider.b(WaidProvider.this).notifyAll();
        AppMethodBeat.o(306358);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(306361);
      Log.i("ad.waid.WaidProvider", "CheckThread run, thread.hash=" + hashCode());
      for (;;)
      {
        if (b.hti())
        {
          Log.i("ad.waid.WaidProvider", "init done");
          htk();
          AppMethodBeat.o(306361);
          return;
        }
        Log.d("ad.waid.WaidProvider", "wait, delay=200");
        try
        {
          Thread.sleep(200L);
          this.hHM += 200;
          label77:
          if (this.hHM < this.RYZ) {
            continue;
          }
          Log.e("ad.waid.WaidProvider", "wait expired, expiredDuration=" + this.RYZ);
          htk();
          AppMethodBeat.o(306361);
          return;
        }
        catch (Exception localException)
        {
          break label77;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.WaidProvider
 * JD-Core Version:    0.7.0.1
 */