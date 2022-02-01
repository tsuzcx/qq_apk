package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.modelsimple.n.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
{
  private static final Pattern WPg;
  private static final IPCRunCgi.b WPh;
  public byte[] JZn;
  public String KJc;
  public int MEW;
  public int OqQ;
  public final HashSet<String> WOP;
  public int WOQ;
  private boolean WOR;
  private boolean WOS;
  private boolean WOT;
  public int WOU;
  public String WOV;
  public cdf WOW;
  public String WOX;
  public d WOY;
  public String WOZ;
  public String WPa;
  public cdi WPb;
  private ccw WPc;
  public cdh WPd;
  public int WPe;
  private final HashMap<String, String> WPf;
  public boolean WwD;
  public String mAppId;
  public int mScene;
  public String sWX;
  
  static
  {
    AppMethodBeat.i(294998);
    WPg = Pattern.compile(".*#.*wechat_redirect");
    WPh = new IPCRunCgi.b()
    {
      public final com.tencent.mm.am.c a(com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(294846);
        paramAnonymousc = n.a.f(paramAnonymousc);
        AppMethodBeat.o(294846);
        return paramAnonymousc;
      }
    };
    AppMethodBeat.o(294998);
  }
  
  public c()
  {
    AppMethodBeat.i(294853);
    this.WOP = new HashSet();
    this.mScene = 0;
    this.MEW = 0;
    this.sWX = "";
    this.mAppId = "";
    this.KJc = "";
    this.JZn = new byte[0];
    this.WOR = true;
    this.WOS = true;
    this.WOT = false;
    this.WOU = 0;
    this.WwD = false;
    this.WOV = null;
    this.WOW = null;
    this.WOX = null;
    this.WOZ = "";
    this.WPa = "";
    this.WPb = null;
    this.WPc = new ccw();
    this.WPd = new cdh();
    this.WPf = new HashMap();
    this.WOQ = n.bMd();
    this.WOY = new d();
    ccw localccw = this.WPc;
    localccw.aaml |= 0x2;
    AppMethodBeat.o(294853);
  }
  
  private static void a(String paramString, int paramInt, boolean paramBoolean, cdf paramcdf, a<cdf> parama)
  {
    AppMethodBeat.i(294905);
    int i = paramcdf.aamK;
    String str = paramcdf.nUB;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(294905);
      return;
      if ((str == null) || (str.length() == 0))
      {
        Log.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(294905);
        return;
      }
      parama.J(paramInt, paramString, str);
      AppMethodBeat.o(294905);
      return;
      parama.a(paramInt, paramBoolean, paramString, paramcdf.aanm, paramcdf);
    }
  }
  
  /* Error */
  private com.tencent.mm.am.c aW(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 359
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 363	com/tencent/mm/modelsimple/n$a:aW	(Ljava/lang/String;I)Lcom/tencent/mm/am/c;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 369	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   20: invokestatic 374	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   23: checkcast 376	com/tencent/mm/protocal/protobuf/cde
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 379	com/tencent/mm/protocal/protobuf/cde:YIq	I
    //   34: aload 5
    //   36: new 381	com/tencent/mm/protocal/protobuf/etl
    //   39: dup
    //   40: invokespecial 382	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 386	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   47: putfield 390	com/tencent/mm/protocal/protobuf/cde:aana	Lcom/tencent/mm/protocal/protobuf/etl;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 98	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   56: putfield 393	com/tencent/mm/protocal/protobuf/cde:IJG	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 104	com/tencent/mm/plugin/webview/e/c:sWX	Ljava/lang/String;
    //   65: putfield 396	com/tencent/mm/protocal/protobuf/cde:UserName	Ljava/lang/String;
    //   68: aload 5
    //   70: aload_0
    //   71: getfield 128	com/tencent/mm/plugin/webview/e/c:WOZ	Ljava/lang/String;
    //   74: putfield 399	com/tencent/mm/protocal/protobuf/cde:aani	Ljava/lang/String;
    //   77: aload 5
    //   79: aload_0
    //   80: getfield 130	com/tencent/mm/plugin/webview/e/c:WPa	Ljava/lang/String;
    //   83: putfield 402	com/tencent/mm/protocal/protobuf/cde:aanj	Ljava/lang/String;
    //   86: aload 5
    //   88: iload_2
    //   89: putfield 405	com/tencent/mm/protocal/protobuf/cde:YKo	I
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 100	com/tencent/mm/plugin/webview/e/c:MEW	I
    //   98: putfield 408	com/tencent/mm/protocal/protobuf/cde:YFu	I
    //   101: invokestatic 414	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   104: ldc_w 416
    //   107: invokevirtual 422	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   110: checkcast 424	android/net/ConnectivityManager
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +365 -> 480
    //   118: aload_3
    //   119: invokevirtual 428	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +356 -> 480
    //   127: aload_3
    //   128: invokevirtual 433	android/net/NetworkInfo:getType	()I
    //   131: iconst_1
    //   132: if_icmpne +300 -> 432
    //   135: ldc_w 435
    //   138: astore_3
    //   139: aload 5
    //   141: aload_3
    //   142: putfield 438	com/tencent/mm/protocal/protobuf/cde:vYk	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 155	com/tencent/mm/plugin/webview/e/c:WOQ	I
    //   151: putfield 441	com/tencent/mm/protocal/protobuf/cde:aane	I
    //   154: aload 5
    //   156: aload_0
    //   157: getfield 108	com/tencent/mm/plugin/webview/e/c:KJc	Ljava/lang/String;
    //   160: putfield 444	com/tencent/mm/protocal/protobuf/cde:aanf	Ljava/lang/String;
    //   163: aload 5
    //   165: aload_0
    //   166: getfield 118	com/tencent/mm/plugin/webview/e/c:WOU	I
    //   169: putfield 447	com/tencent/mm/protocal/protobuf/cde:aang	I
    //   172: aload 5
    //   174: new 381	com/tencent/mm/protocal/protobuf/etl
    //   177: dup
    //   178: invokespecial 382	com/tencent/mm/protocal/protobuf/etl:<init>	()V
    //   181: aload_0
    //   182: getfield 106	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   185: invokevirtual 386	com/tencent/mm/protocal/protobuf/etl:btH	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/etl;
    //   188: putfield 450	com/tencent/mm/protocal/protobuf/cde:aamX	Lcom/tencent/mm/protocal/protobuf/etl;
    //   191: aload 5
    //   193: new 452	com/tencent/mm/protocal/protobuf/gol
    //   196: dup
    //   197: invokespecial 453	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   200: aload_0
    //   201: getfield 110	com/tencent/mm/plugin/webview/e/c:JZn	[B
    //   204: invokevirtual 457	com/tencent/mm/protocal/protobuf/gol:df	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   207: putfield 458	com/tencent/mm/protocal/protobuf/cde:aanh	Lcom/tencent/mm/protocal/protobuf/gol;
    //   210: aload 5
    //   212: aload_0
    //   213: getfield 132	com/tencent/mm/plugin/webview/e/c:WPb	Lcom/tencent/mm/protocal/protobuf/cdi;
    //   216: putfield 461	com/tencent/mm/protocal/protobuf/cde:aanl	Lcom/tencent/mm/protocal/protobuf/cdi;
    //   219: aload 5
    //   221: aload_0
    //   222: getfield 463	com/tencent/mm/plugin/webview/e/c:WPe	I
    //   225: putfield 466	com/tencent/mm/protocal/protobuf/cde:aamC	I
    //   228: aload 5
    //   230: aload_0
    //   231: getfield 468	com/tencent/mm/plugin/webview/e/c:OqQ	I
    //   234: putfield 471	com/tencent/mm/protocal/protobuf/cde:aajd	I
    //   237: iconst_5
    //   238: iload_2
    //   239: if_icmpne +211 -> 450
    //   242: aload 5
    //   244: aload_0
    //   245: getfield 126	com/tencent/mm/plugin/webview/e/c:WOX	Ljava/lang/String;
    //   248: putfield 474	com/tencent/mm/protocal/protobuf/cde:aamF	Ljava/lang/String;
    //   251: aload_0
    //   252: getfield 137	com/tencent/mm/plugin/webview/e/c:WPc	Lcom/tencent/mm/protocal/protobuf/ccw;
    //   255: astore_3
    //   256: aload_3
    //   257: ifnull +18 -> 275
    //   260: aload 5
    //   262: aload_0
    //   263: getfield 137	com/tencent/mm/plugin/webview/e/c:WPc	Lcom/tencent/mm/protocal/protobuf/ccw;
    //   266: invokevirtual 478	com/tencent/mm/protocal/protobuf/ccw:toByteArray	()[B
    //   269: invokestatic 481	com/tencent/mm/platformtools/w:aN	([B)Lcom/tencent/mm/protocal/protobuf/gol;
    //   272: putfield 482	com/tencent/mm/protocal/protobuf/cde:aamD	Lcom/tencent/mm/protocal/protobuf/gol;
    //   275: ldc 173
    //   277: ldc_w 484
    //   280: bipush 15
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload_1
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: aload_0
    //   292: getfield 104	com/tencent/mm/plugin/webview/e/c:sWX	Ljava/lang/String;
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: aload_0
    //   299: getfield 98	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   302: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: dup
    //   307: iconst_3
    //   308: iload_2
    //   309: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: aastore
    //   313: dup
    //   314: iconst_4
    //   315: aload_0
    //   316: getfield 100	com/tencent/mm/plugin/webview/e/c:MEW	I
    //   319: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   322: aastore
    //   323: dup
    //   324: iconst_5
    //   325: aload 5
    //   327: getfield 438	com/tencent/mm/protocal/protobuf/cde:vYk	Ljava/lang/String;
    //   330: aastore
    //   331: dup
    //   332: bipush 6
    //   334: aload_0
    //   335: getfield 155	com/tencent/mm/plugin/webview/e/c:WOQ	I
    //   338: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: bipush 7
    //   345: aload_0
    //   346: getfield 106	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   349: aastore
    //   350: dup
    //   351: bipush 8
    //   353: aload_0
    //   354: getfield 108	com/tencent/mm/plugin/webview/e/c:KJc	Ljava/lang/String;
    //   357: aastore
    //   358: dup
    //   359: bipush 9
    //   361: aload_0
    //   362: getfield 118	com/tencent/mm/plugin/webview/e/c:WOU	I
    //   365: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: dup
    //   370: bipush 10
    //   372: aload_0
    //   373: getfield 110	com/tencent/mm/plugin/webview/e/c:JZn	[B
    //   376: invokestatic 488	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   379: aastore
    //   380: dup
    //   381: bipush 11
    //   383: aload_0
    //   384: getfield 128	com/tencent/mm/plugin/webview/e/c:WOZ	Ljava/lang/String;
    //   387: aastore
    //   388: dup
    //   389: bipush 12
    //   391: aload_0
    //   392: getfield 130	com/tencent/mm/plugin/webview/e/c:WPa	Ljava/lang/String;
    //   395: aastore
    //   396: dup
    //   397: bipush 13
    //   399: aload_0
    //   400: getfield 463	com/tencent/mm/plugin/webview/e/c:WPe	I
    //   403: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: bipush 14
    //   410: aload_0
    //   411: getfield 468	com/tencent/mm/plugin/webview/e/c:OqQ	I
    //   414: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   417: aastore
    //   418: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: ldc_w 359
    //   424: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_0
    //   428: monitorexit
    //   429: aload 4
    //   431: areturn
    //   432: aload_3
    //   433: invokevirtual 491	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   436: ifnull +44 -> 480
    //   439: aload_3
    //   440: invokevirtual 491	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   443: invokevirtual 494	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   446: astore_3
    //   447: goto -308 -> 139
    //   450: aload_0
    //   451: aconst_null
    //   452: putfield 126	com/tencent/mm/plugin/webview/e/c:WOX	Ljava/lang/String;
    //   455: goto -204 -> 251
    //   458: astore_1
    //   459: aload_0
    //   460: monitorexit
    //   461: aload_1
    //   462: athrow
    //   463: astore_3
    //   464: ldc 173
    //   466: aload_3
    //   467: ldc_w 496
    //   470: iconst_0
    //   471: anewarray 4	java/lang/Object
    //   474: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: goto -202 -> 275
    //   480: ldc_w 498
    //   483: astore_3
    //   484: goto -345 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	c
    //   0	487	1	paramString	String
    //   0	487	2	paramInt	int
    //   113	334	3	localObject	Object
    //   463	4	3	localException	java.lang.Exception
    //   483	1	3	str	String
    //   13	417	4	localc	com.tencent.mm.am.c
    //   26	300	5	localcde	com.tencent.mm.protocal.protobuf.cde
    // Exception table:
    //   from	to	target	type
    //   2	114	458	finally
    //   118	123	458	finally
    //   127	135	458	finally
    //   139	237	458	finally
    //   242	251	458	finally
    //   251	256	458	finally
    //   260	275	458	finally
    //   275	427	458	finally
    //   432	447	458	finally
    //   450	455	458	finally
    //   464	477	458	finally
    //   260	275	463	java/lang/Exception
  }
  
  private void b(final String paramString, final int paramInt, final a<cdf> parama)
  {
    try
    {
      AppMethodBeat.i(294890);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
        {
          AppMethodBeat.i(294851);
          Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.c(c.this)) });
          c.d(c.this).remove(paramString);
          if ((c.c.b(paramAnonymousc.otC) instanceof cdf))
          {
            paramAnonymousc = (cdf)c.c.b(paramAnonymousc.otC);
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousc, parama);
            AppMethodBeat.o(294851);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          Log.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(294851);
        }
      });
      AppMethodBeat.o(294890);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int bld(String paramString)
  {
    AppMethodBeat.i(294860);
    paramString = com.tencent.mm.protocal.c.bsk(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(294860);
      return -1;
    }
    int i = paramString.iPC();
    AppMethodBeat.o(294860);
    return i;
  }
  
  public static Map<String, String> mi(List<dam> paramList)
  {
    AppMethodBeat.i(294926);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(294926);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      dam localdam = (dam)paramList.next();
      localHashMap.put(localdam.ILw, localdam.OzQ);
    }
    AppMethodBeat.o(294926);
    return localHashMap;
  }
  
  private static boolean nj(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final a a(String paramString, int paramInt, a<cdf> parama)
  {
    try
    {
      AppMethodBeat.i(295132);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(295132);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<cdf> parama)
  {
    try
    {
      AppMethodBeat.i(295124);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(295124);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, final a<cdf> parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(295146);
        if ((!paramBoolean) && (ble(paramString)))
        {
          paramString = a.WPn;
          AppMethodBeat.o(295146);
          return paramString;
        }
        if ((!paramBoolean) && (this.WOY.has(paramString)))
        {
          paramString = a.WPm;
          AppMethodBeat.o(295146);
          continue;
        }
        if (paramInt != 5) {
          break label100;
        }
      }
      finally {}
      if (this.WOT)
      {
        Log.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
        paramString = a.WPm;
        AppMethodBeat.o(295146);
      }
      else
      {
        label100:
        if ((!paramBoolean) && (this.WOP.contains(paramString)))
        {
          paramString = a.WPn;
          AppMethodBeat.o(295146);
        }
        else
        {
          this.WOP.add(paramString);
          if (parama != null) {
            parama.cb(paramInt, paramString);
          }
          final int i = paramInt;
          if (paramInt == -1) {
            i = dJ(paramString, false);
          }
          boolean bool = this.WOR;
          this.WOR = false;
          Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s, force=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
          if ((bool) && (this.WOW != null) && (paramString.equals(this.WOW.aanm)))
          {
            Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result");
            h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(294847);
                Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result CallBack");
                c.a(c.this, c.a(c.this), i, 0, 0, "", c.b(c.this), parama);
                AppMethodBeat.o(294847);
              }
            });
            paramString = a.WPn;
            AppMethodBeat.o(295146);
          }
          else
          {
            b(paramString, i, parama);
            paramString = a.WPn;
            AppMethodBeat.o(295146);
          }
        }
      }
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(295150);
      IPCRunCgi.a(aW(paramString, paramInt), WPh, parama, null);
      AppMethodBeat.o(295150);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String bkG(String paramString)
  {
    AppMethodBeat.i(295077);
    synchronized (this.WPf)
    {
      Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.WPf.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.WPf.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.WPf.get(paramString);
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = this.WPf;
      if (!Util.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = Util.nullAs((String)localObject1, paramString);
      AppMethodBeat.o(295077);
      return paramString;
      label175:
      int i = paramString.indexOf("#");
      if (i < 0) {
        localObject1 = paramString;
      } else {
        localObject1 = paramString.substring(0, i);
      }
    }
  }
  
  public final JsapiPermissionWrapper blb(String paramString)
  {
    AppMethodBeat.i(295054);
    paramString = this.WOY.blf(paramString);
    AppMethodBeat.o(295054);
    return paramString;
  }
  
  public final GeneralControlWrapper blc(String paramString)
  {
    AppMethodBeat.i(295063);
    paramString = this.WOY.blc(paramString);
    AppMethodBeat.o(295063);
    return paramString;
  }
  
  public final boolean ble(String paramString)
  {
    AppMethodBeat.i(295117);
    boolean bool = this.WOP.contains(paramString);
    AppMethodBeat.o(295117);
    return bool;
  }
  
  public final int dJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(295087);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(295087);
      return 0;
    }
    if (this.WOR)
    {
      AppMethodBeat.o(295087);
      return 0;
    }
    if (WPg.matcher(paramString).find())
    {
      AppMethodBeat.o(295087);
      return 2;
    }
    if ((!paramBoolean) && (b.bla(paramString)))
    {
      AppMethodBeat.o(295087);
      return 8;
    }
    AppMethodBeat.o(295087);
    return 1;
  }
  
  public final int getScene()
  {
    return this.mScene;
  }
  
  public final int getSessionId()
  {
    return this.WOQ;
  }
  
  public final String getUsername()
  {
    return this.sWX;
  }
  
  public final boolean ia(String paramString, int paramInt)
  {
    AppMethodBeat.i(295069);
    if (blb(paramString).axr(paramInt) == 1)
    {
      AppMethodBeat.o(295069);
      return true;
    }
    AppMethodBeat.o(295069);
    return false;
  }
  
  public final String iwl()
  {
    return this.WOZ;
  }
  
  public final String iwm()
  {
    return this.WPa;
  }
  
  public final void setUsername(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.sWX = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(294861);
      WPl = new a("INTERCEPTED", 0);
      WPm = new a("NO_NEED", 1);
      WPn = new a("WILL_GET", 2);
      WPo = new a("FAILED", 3);
      WPp = new a[] { WPl, WPm, WPn, WPo };
      AppMethodBeat.o(294861);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.c
 * JD-Core Version:    0.7.0.1
 */