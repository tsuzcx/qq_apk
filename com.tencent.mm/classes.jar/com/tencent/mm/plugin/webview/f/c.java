package com.tencent.mm.plugin.webview.f;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static final Pattern PYC;
  private static final IPCRunCgi.b PYD;
  private String EOD;
  private byte[] EfT;
  private int GIg;
  public boolean PFQ;
  private bov PYA;
  private final HashMap<String, String> PYB;
  private final HashSet<String> PYp;
  private int PYq;
  private boolean PYr;
  private boolean PYs;
  private int PYt;
  private String PYu;
  private bot PYv;
  private String PYw;
  private d PYx;
  private String PYy;
  private String PYz;
  private String mAppId;
  private int mScene;
  private String pRV;
  
  static
  {
    AppMethodBeat.i(206169);
    PYC = Pattern.compile(".*#.*wechat_redirect");
    PYD = new IPCRunCgi.b()
    {
      public final com.tencent.mm.an.d a(com.tencent.mm.an.d paramAnonymousd)
      {
        AppMethodBeat.i(205715);
        paramAnonymousd = l.a.g(paramAnonymousd);
        AppMethodBeat.o(205715);
        return paramAnonymousd;
      }
    };
    AppMethodBeat.o(206169);
  }
  
  public c()
  {
    AppMethodBeat.i(206124);
    this.PYp = new HashSet();
    this.mScene = 0;
    this.GIg = 0;
    this.pRV = "";
    this.mAppId = "";
    this.EOD = "";
    this.EfT = new byte[0];
    this.PYr = true;
    this.PYs = false;
    this.PYt = 0;
    this.PFQ = false;
    this.PYu = null;
    this.PYv = null;
    this.PYw = null;
    this.PYy = "";
    this.PYz = "";
    this.PYA = null;
    this.PYB = new HashMap();
    this.PYq = l.boo();
    this.PYx = new d();
    AppMethodBeat.o(206124);
  }
  
  private static void a(String paramString, int paramInt, boolean paramBoolean, bot parambot, a<bot> parama)
  {
    AppMethodBeat.i(206163);
    int i = parambot.SZN;
    String str = parambot.lpy;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206163);
      return;
      if ((str == null) || (str.length() == 0))
      {
        Log.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(206163);
        return;
      }
      parama.F(paramInt, paramString, str);
      AppMethodBeat.o(206163);
      return;
      parama.a(paramInt, paramBoolean, paramString, parambot.Tao, parambot);
    }
  }
  
  /* Error */
  private com.tencent.mm.an.d aL(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 282
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 286	com/tencent/mm/modelsimple/l$a:aL	(Ljava/lang/String;I)Lcom/tencent/mm/an/d;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 292	com/tencent/mm/an/d:lBR	Lcom/tencent/mm/an/d$b;
    //   20: invokestatic 297	com/tencent/mm/an/d$b:b	(Lcom/tencent/mm/an/d$b;)Lcom/tencent/mm/cd/a;
    //   23: checkcast 299	com/tencent/mm/protocal/protobuf/bos
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 302	com/tencent/mm/protocal/protobuf/bos:RLe	I
    //   34: aload 5
    //   36: new 304	com/tencent/mm/protocal/protobuf/eaf
    //   39: dup
    //   40: invokespecial 305	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 309	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   47: putfield 313	com/tencent/mm/protocal/protobuf/bos:Tac	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 85	com/tencent/mm/plugin/webview/f/c:mScene	I
    //   56: putfield 316	com/tencent/mm/protocal/protobuf/bos:CPw	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 91	com/tencent/mm/plugin/webview/f/c:pRV	Ljava/lang/String;
    //   65: putfield 319	com/tencent/mm/protocal/protobuf/bos:UserName	Ljava/lang/String;
    //   68: aload 5
    //   70: aload_0
    //   71: getfield 113	com/tencent/mm/plugin/webview/f/c:PYy	Ljava/lang/String;
    //   74: putfield 322	com/tencent/mm/protocal/protobuf/bos:Tak	Ljava/lang/String;
    //   77: aload 5
    //   79: aload_0
    //   80: getfield 115	com/tencent/mm/plugin/webview/f/c:PYz	Ljava/lang/String;
    //   83: putfield 325	com/tencent/mm/protocal/protobuf/bos:Tal	Ljava/lang/String;
    //   86: aload 5
    //   88: iload_2
    //   89: putfield 328	com/tencent/mm/protocal/protobuf/bos:RNa	I
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 87	com/tencent/mm/plugin/webview/f/c:GIg	I
    //   98: putfield 331	com/tencent/mm/protocal/protobuf/bos:RIs	I
    //   101: invokestatic 337	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   104: ldc_w 339
    //   107: invokevirtual 345	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   110: checkcast 347	android/net/ConnectivityManager
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +271 -> 386
    //   118: aload_3
    //   119: invokevirtual 351	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +262 -> 386
    //   127: aload_3
    //   128: invokevirtual 356	android/net/NetworkInfo:getType	()I
    //   131: iconst_1
    //   132: if_icmpne +236 -> 368
    //   135: ldc_w 358
    //   138: astore_3
    //   139: aload 5
    //   141: aload_3
    //   142: putfield 361	com/tencent/mm/protocal/protobuf/bos:sSU	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 130	com/tencent/mm/plugin/webview/f/c:PYq	I
    //   151: putfield 364	com/tencent/mm/protocal/protobuf/bos:Tag	I
    //   154: aload 5
    //   156: aload_0
    //   157: getfield 95	com/tencent/mm/plugin/webview/f/c:EOD	Ljava/lang/String;
    //   160: putfield 367	com/tencent/mm/protocal/protobuf/bos:Tah	Ljava/lang/String;
    //   163: aload 5
    //   165: aload_0
    //   166: getfield 103	com/tencent/mm/plugin/webview/f/c:PYt	I
    //   169: putfield 370	com/tencent/mm/protocal/protobuf/bos:Tai	I
    //   172: aload 5
    //   174: new 304	com/tencent/mm/protocal/protobuf/eaf
    //   177: dup
    //   178: invokespecial 305	com/tencent/mm/protocal/protobuf/eaf:<init>	()V
    //   181: aload_0
    //   182: getfield 93	com/tencent/mm/plugin/webview/f/c:mAppId	Ljava/lang/String;
    //   185: invokevirtual 309	com/tencent/mm/protocal/protobuf/eaf:btQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/eaf;
    //   188: putfield 373	com/tencent/mm/protocal/protobuf/bos:SZZ	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   191: aload 5
    //   193: new 375	com/tencent/mm/protocal/protobuf/eae
    //   196: dup
    //   197: invokespecial 376	com/tencent/mm/protocal/protobuf/eae:<init>	()V
    //   200: aload_0
    //   201: getfield 97	com/tencent/mm/plugin/webview/f/c:EfT	[B
    //   204: invokevirtual 380	com/tencent/mm/protocal/protobuf/eae:dc	([B)Lcom/tencent/mm/protocal/protobuf/eae;
    //   207: putfield 381	com/tencent/mm/protocal/protobuf/bos:Taj	Lcom/tencent/mm/protocal/protobuf/eae;
    //   210: aload 5
    //   212: aload_0
    //   213: getfield 117	com/tencent/mm/plugin/webview/f/c:PYA	Lcom/tencent/mm/protocal/protobuf/bov;
    //   216: putfield 384	com/tencent/mm/protocal/protobuf/bos:Tan	Lcom/tencent/mm/protocal/protobuf/bov;
    //   219: iconst_5
    //   220: iload_2
    //   221: if_icmpne +12 -> 233
    //   224: aload 5
    //   226: aload_0
    //   227: getfield 111	com/tencent/mm/plugin/webview/f/c:PYw	Ljava/lang/String;
    //   230: putfield 387	com/tencent/mm/protocal/protobuf/bos:SZI	Ljava/lang/String;
    //   233: ldc 140
    //   235: ldc_w 389
    //   238: bipush 13
    //   240: anewarray 4	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_1
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_0
    //   250: getfield 91	com/tencent/mm/plugin/webview/f/c:pRV	Ljava/lang/String;
    //   253: aastore
    //   254: dup
    //   255: iconst_2
    //   256: aload_0
    //   257: getfield 85	com/tencent/mm/plugin/webview/f/c:mScene	I
    //   260: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aastore
    //   264: dup
    //   265: iconst_3
    //   266: iload_2
    //   267: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_4
    //   273: aload_0
    //   274: getfield 87	com/tencent/mm/plugin/webview/f/c:GIg	I
    //   277: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_5
    //   283: aload 5
    //   285: getfield 361	com/tencent/mm/protocal/protobuf/bos:sSU	Ljava/lang/String;
    //   288: aastore
    //   289: dup
    //   290: bipush 6
    //   292: aload_0
    //   293: getfield 130	com/tencent/mm/plugin/webview/f/c:PYq	I
    //   296: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: bipush 7
    //   303: aload_0
    //   304: getfield 93	com/tencent/mm/plugin/webview/f/c:mAppId	Ljava/lang/String;
    //   307: aastore
    //   308: dup
    //   309: bipush 8
    //   311: aload_0
    //   312: getfield 95	com/tencent/mm/plugin/webview/f/c:EOD	Ljava/lang/String;
    //   315: aastore
    //   316: dup
    //   317: bipush 9
    //   319: aload_0
    //   320: getfield 103	com/tencent/mm/plugin/webview/f/c:PYt	I
    //   323: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   326: aastore
    //   327: dup
    //   328: bipush 10
    //   330: aload_0
    //   331: getfield 97	com/tencent/mm/plugin/webview/f/c:EfT	[B
    //   334: invokestatic 393	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   337: aastore
    //   338: dup
    //   339: bipush 11
    //   341: aload_0
    //   342: getfield 113	com/tencent/mm/plugin/webview/f/c:PYy	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: bipush 12
    //   349: aload_0
    //   350: getfield 115	com/tencent/mm/plugin/webview/f/c:PYz	Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: ldc_w 282
    //   360: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_0
    //   364: monitorexit
    //   365: aload 4
    //   367: areturn
    //   368: aload_3
    //   369: invokevirtual 396	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   372: ifnull +14 -> 386
    //   375: aload_3
    //   376: invokevirtual 396	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   379: invokevirtual 399	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   382: astore_3
    //   383: goto -244 -> 139
    //   386: ldc_w 401
    //   389: astore_3
    //   390: goto -251 -> 139
    //   393: astore_1
    //   394: aload_0
    //   395: monitorexit
    //   396: aload_1
    //   397: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	c
    //   0	398	1	paramString	String
    //   0	398	2	paramInt	int
    //   113	277	3	localObject	Object
    //   13	353	4	locald	com.tencent.mm.an.d
    //   26	258	5	localbos	bos
    // Exception table:
    //   from	to	target	type
    //   2	114	393	finally
    //   118	123	393	finally
    //   127	135	393	finally
    //   139	219	393	finally
    //   224	233	393	finally
    //   233	363	393	finally
    //   368	383	393	finally
  }
  
  private void b(final String paramString, final int paramInt, final a<bot> parama)
  {
    try
    {
      AppMethodBeat.i(206160);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
        {
          AppMethodBeat.i(209603);
          Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.c(c.this)) });
          c.d(c.this).remove(paramString);
          if ((d.c.b(paramAnonymousd.lBS) instanceof bot))
          {
            paramAnonymousd = (bot)d.c.b(paramAnonymousd.lBS);
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, parama);
            AppMethodBeat.o(209603);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          Log.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(209603);
        }
      });
      AppMethodBeat.o(206160);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int blB(String paramString)
  {
    AppMethodBeat.i(206139);
    paramString = com.tencent.mm.protocal.c.bst(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(206139);
      return -1;
    }
    int i = paramString.hoG();
    AppMethodBeat.o(206139);
    return i;
  }
  
  public static Map<String, String> iZ(List<ckf> paramList)
  {
    AppMethodBeat.i(206165);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(206165);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ckf localckf = (ckf)paramList.next();
      localHashMap.put(localckf.CRg, localckf.Izj);
    }
    AppMethodBeat.o(206165);
    return localHashMap;
  }
  
  private static boolean ly(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void Ht(int paramInt)
  {
    this.PYq = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<bot> parama)
  {
    try
    {
      AppMethodBeat.i(206150);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(206150);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<bot> parama)
  {
    try
    {
      AppMethodBeat.i(206149);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(206149);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, final a<bot> parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(206153);
        if ((!paramBoolean) && (blD(paramString)))
        {
          paramString = a.PYJ;
          AppMethodBeat.o(206153);
          return paramString;
        }
        if ((!paramBoolean) && (this.PYx.has(paramString)))
        {
          paramString = a.PYI;
          AppMethodBeat.o(206153);
          continue;
        }
        if (paramInt != 5) {
          break label100;
        }
      }
      finally {}
      if (this.PYs)
      {
        Log.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
        paramString = a.PYI;
        AppMethodBeat.o(206153);
      }
      else
      {
        label100:
        if ((!paramBoolean) && (this.PYp.contains(paramString)))
        {
          paramString = a.PYJ;
          AppMethodBeat.o(206153);
        }
        else
        {
          this.PYp.add(paramString);
          if (parama != null) {
            parama.bv(paramInt, paramString);
          }
          final int i = paramInt;
          if (paramInt == -1) {
            i = dc(paramString, false);
          }
          boolean bool = this.PYr;
          this.PYr = false;
          Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s, force=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
          if ((bool) && (this.PYv != null) && (paramString.equals(this.PYv.Tao)))
          {
            Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result");
            h.ZvG.be(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(206268);
                Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result CallBack");
                c.a(c.this, c.a(c.this), i, 0, 0, "", c.b(c.this), parama);
                AppMethodBeat.o(206268);
              }
            });
            paramString = a.PYJ;
            AppMethodBeat.o(206153);
          }
          else
          {
            b(paramString, i, parama);
            paramString = a.PYJ;
            AppMethodBeat.o(206153);
          }
        }
      }
    }
  }
  
  public final void a(bov parambov)
  {
    this.PYA = parambov;
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(206162);
      IPCRunCgi.a(aL(paramString, paramInt), PYD, parama, null);
      AppMethodBeat.o(206162);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void aG(byte[] paramArrayOfByte)
  {
    this.EfT = paramArrayOfByte;
  }
  
  public final void anT(int paramInt)
  {
    this.PYt = paramInt;
  }
  
  public final GeneralControlWrapper blA(String paramString)
  {
    AppMethodBeat.i(206134);
    paramString = this.PYx.blA(paramString);
    AppMethodBeat.o(206134);
    return paramString;
  }
  
  public final int blC(String paramString)
  {
    AppMethodBeat.i(292842);
    int i = dc(paramString, false);
    AppMethodBeat.o(292842);
    return i;
  }
  
  public final boolean blD(String paramString)
  {
    AppMethodBeat.i(206145);
    boolean bool = this.PYp.contains(paramString);
    AppMethodBeat.o(206145);
    return bool;
  }
  
  public final String bld(String paramString)
  {
    AppMethodBeat.i(206137);
    synchronized (this.PYB)
    {
      Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.PYB.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.PYB.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.PYB.get(paramString);
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = this.PYB;
      if (!Util.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = Util.nullAs((String)localObject1, paramString);
      AppMethodBeat.o(206137);
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
  
  public final void blu(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.EOD = str;
  }
  
  public final void blv(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.PYy = str;
  }
  
  public final void blw(String paramString)
  {
    this.PYz = paramString;
  }
  
  public final void blx(String paramString)
  {
    AppMethodBeat.i(206128);
    Log.i("MicroMsg.LuggageGetA8Key", "setOuterUrlForIframe(%s)", new Object[] { paramString });
    this.PYw = paramString;
    AppMethodBeat.o(206128);
  }
  
  public final JsapiPermissionWrapper bly(String paramString)
  {
    AppMethodBeat.i(206130);
    paramString = this.PYx.blE(paramString);
    AppMethodBeat.o(206130);
    return paramString;
  }
  
  public final boolean blz(String paramString)
  {
    AppMethodBeat.i(206132);
    boolean bool = this.PYx.has(paramString);
    AppMethodBeat.o(206132);
    return bool;
  }
  
  public final int dc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(206143);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(206143);
      return 0;
    }
    if (this.PYr)
    {
      AppMethodBeat.o(206143);
      return 0;
    }
    if (PYC.matcher(paramString).find())
    {
      AppMethodBeat.o(206143);
      return 2;
    }
    if ((!paramBoolean) && (b.blt(paramString)))
    {
      AppMethodBeat.o(206143);
      return 8;
    }
    AppMethodBeat.o(206143);
    return 1;
  }
  
  public final void destroy()
  {
    this.PFQ = true;
  }
  
  public final boolean gUz()
  {
    AppMethodBeat.i(206146);
    if (this.PYp.size() > 0)
    {
      AppMethodBeat.o(206146);
      return true;
    }
    AppMethodBeat.o(206146);
    return false;
  }
  
  public final String gWG()
  {
    return this.PYy;
  }
  
  public final String gWH()
  {
    return this.PYz;
  }
  
  public final int getSessionId()
  {
    return this.PYq;
  }
  
  public final String getUsername()
  {
    return this.pRV;
  }
  
  public final boolean ha(String paramString, int paramInt)
  {
    AppMethodBeat.i(206135);
    if (bly(paramString).arj(paramInt) == 1)
    {
      AppMethodBeat.o(206135);
      return true;
    }
    AppMethodBeat.o(206135);
    return false;
  }
  
  public final void m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(206127);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(206127);
      return;
    }
    if ((paramArrayOfByte1.length <= 0) || (paramArrayOfByte2.length <= 0))
    {
      AppMethodBeat.o(206127);
      return;
    }
    bos localbos = new bos();
    bot localbot = new bot();
    try
    {
      localbos.parseFrom(paramArrayOfByte1);
      localbot.parseFrom(paramArrayOfByte2);
      this.PYu = localbos.Tac.Ufy;
      label80:
      if ((Util.isNullOrNil(this.PYu)) || (localbot.Tao == null))
      {
        Log.e("MicroMsg.LuggageGetA8Key", "ReqUrl or FullUrl is null");
        AppMethodBeat.o(206127);
        return;
      }
      this.PYv = localbot;
      AppMethodBeat.o(206127);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      break label80;
    }
  }
  
  public final void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void setFlag(int paramInt)
  {
    this.GIg = paramInt;
  }
  
  public final void setScene(int paramInt)
  {
    this.mScene = paramInt;
  }
  
  public final void setUsername(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.pRV = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(216294);
      PYH = new a("INTERCEPTED", 0);
      PYI = new a("NO_NEED", 1);
      PYJ = new a("WILL_GET", 2);
      PYK = new a("FAILED", 3);
      PYL = new a[] { PYH, PYI, PYJ, PYK };
      AppMethodBeat.o(216294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.c
 * JD-Core Version:    0.7.0.1
 */