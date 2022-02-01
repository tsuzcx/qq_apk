package com.tencent.mm.plugin.webview.f;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
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
  private static final Pattern JbU;
  private static final IPCRunCgi.b JbV;
  private int AOS;
  public boolean IJS;
  private final HashSet<String> JbJ;
  private int JbK;
  private boolean JbL;
  private boolean JbM;
  private int JbN;
  private String JbO;
  private bhj JbP;
  private d JbQ;
  private String JbR;
  private String JbS;
  private final HashMap<String, String> JbT;
  private String mAppId;
  private String mRa;
  private int mScene;
  private byte[] yEg;
  private String zjn;
  
  static
  {
    AppMethodBeat.i(224481);
    JbU = Pattern.compile(".*#.*wechat_redirect");
    JbV = new IPCRunCgi.b()
    {
      public final com.tencent.mm.ak.d a(com.tencent.mm.ak.d paramAnonymousd)
      {
        AppMethodBeat.i(224456);
        paramAnonymousd = l.a.f(paramAnonymousd);
        AppMethodBeat.o(224456);
        return paramAnonymousd;
      }
    };
    AppMethodBeat.o(224481);
  }
  
  public c()
  {
    AppMethodBeat.i(224461);
    this.JbJ = new HashSet();
    this.mScene = 0;
    this.AOS = 0;
    this.mRa = "";
    this.mAppId = "";
    this.zjn = "";
    this.yEg = new byte[0];
    this.JbL = true;
    this.JbM = false;
    this.JbN = 0;
    this.IJS = false;
    this.JbO = null;
    this.JbP = null;
    this.JbR = "";
    this.JbS = "";
    this.JbT = new HashMap();
    this.JbK = ((int)System.currentTimeMillis());
    this.JbQ = new d();
    AppMethodBeat.o(224461);
  }
  
  private static void a(String paramString, int paramInt, boolean paramBoolean, bhj parambhj, a<bhj> parama)
  {
    AppMethodBeat.i(224478);
    int i = parambhj.KCD;
    String str = parambhj.iAc;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(224478);
      return;
      if ((str == null) || (str.length() == 0))
      {
        Log.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(224478);
        return;
      }
      parama.C(paramInt, paramString, str);
      AppMethodBeat.o(224478);
      return;
      parama.a(paramInt, paramBoolean, paramString, parambhj.LRH, parambhj);
    }
  }
  
  public static int aZG(String paramString)
  {
    AppMethodBeat.i(224467);
    paramString = com.tencent.mm.protocal.c.bgb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(224467);
      return -1;
    }
    int i = paramString.gtt();
    AppMethodBeat.o(224467);
    return i;
  }
  
  /* Error */
  private com.tencent.mm.ak.d at(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 290
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 294	com/tencent/mm/modelsimple/l$a:at	(Ljava/lang/String;I)Lcom/tencent/mm/ak/d;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 300	com/tencent/mm/ak/d:iLK	Lcom/tencent/mm/ak/d$b;
    //   20: getfield 306	com/tencent/mm/ak/d$b:iLR	Lcom/tencent/mm/bw/a;
    //   23: checkcast 308	com/tencent/mm/protocal/protobuf/bhi
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 311	com/tencent/mm/protocal/protobuf/bhi:OpCode	I
    //   34: aload 5
    //   36: new 313	com/tencent/mm/protocal/protobuf/dqi
    //   39: dup
    //   40: invokespecial 314	com/tencent/mm/protocal/protobuf/dqi:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 318	com/tencent/mm/protocal/protobuf/dqi:bhy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dqi;
    //   47: putfield 322	com/tencent/mm/protocal/protobuf/bhi:LRx	Lcom/tencent/mm/protocal/protobuf/dqi;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 82	com/tencent/mm/plugin/webview/f/c:mScene	I
    //   56: putfield 325	com/tencent/mm/protocal/protobuf/bhi:Scene	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 88	com/tencent/mm/plugin/webview/f/c:mRa	Ljava/lang/String;
    //   65: putfield 328	com/tencent/mm/protocal/protobuf/bhi:UserName	Ljava/lang/String;
    //   68: aload 5
    //   70: aload_0
    //   71: getfield 108	com/tencent/mm/plugin/webview/f/c:JbR	Ljava/lang/String;
    //   74: putfield 331	com/tencent/mm/protocal/protobuf/bhi:LRF	Ljava/lang/String;
    //   77: aload 5
    //   79: aload_0
    //   80: getfield 110	com/tencent/mm/plugin/webview/f/c:JbS	Ljava/lang/String;
    //   83: putfield 334	com/tencent/mm/protocal/protobuf/bhi:LRG	Ljava/lang/String;
    //   86: aload 5
    //   88: iload_2
    //   89: putfield 337	com/tencent/mm/protocal/protobuf/bhi:KMd	I
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 84	com/tencent/mm/plugin/webview/f/c:AOS	I
    //   98: putfield 340	com/tencent/mm/protocal/protobuf/bhi:KHa	I
    //   101: invokestatic 346	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   104: ldc_w 348
    //   107: invokevirtual 354	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   110: checkcast 356	android/net/ConnectivityManager
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +248 -> 363
    //   118: aload_3
    //   119: invokevirtual 360	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +239 -> 363
    //   127: aload_3
    //   128: invokevirtual 365	android/net/NetworkInfo:getType	()I
    //   131: iconst_1
    //   132: if_icmpne +213 -> 345
    //   135: ldc_w 367
    //   138: astore_3
    //   139: aload 5
    //   141: aload_3
    //   142: putfield 370	com/tencent/mm/protocal/protobuf/bhi:pLm	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 123	com/tencent/mm/plugin/webview/f/c:JbK	I
    //   151: putfield 373	com/tencent/mm/protocal/protobuf/bhi:LRB	I
    //   154: aload 5
    //   156: aload_0
    //   157: getfield 92	com/tencent/mm/plugin/webview/f/c:zjn	Ljava/lang/String;
    //   160: putfield 376	com/tencent/mm/protocal/protobuf/bhi:LRC	Ljava/lang/String;
    //   163: aload 5
    //   165: aload_0
    //   166: getfield 100	com/tencent/mm/plugin/webview/f/c:JbN	I
    //   169: putfield 379	com/tencent/mm/protocal/protobuf/bhi:LRD	I
    //   172: aload 5
    //   174: new 313	com/tencent/mm/protocal/protobuf/dqi
    //   177: dup
    //   178: invokespecial 314	com/tencent/mm/protocal/protobuf/dqi:<init>	()V
    //   181: aload_0
    //   182: getfield 90	com/tencent/mm/plugin/webview/f/c:mAppId	Ljava/lang/String;
    //   185: invokevirtual 318	com/tencent/mm/protocal/protobuf/dqi:bhy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/dqi;
    //   188: putfield 382	com/tencent/mm/protocal/protobuf/bhi:LRu	Lcom/tencent/mm/protocal/protobuf/dqi;
    //   191: aload 5
    //   193: new 384	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   196: dup
    //   197: invokespecial 385	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   200: aload_0
    //   201: getfield 94	com/tencent/mm/plugin/webview/f/c:yEg	[B
    //   204: invokevirtual 389	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   207: putfield 390	com/tencent/mm/protocal/protobuf/bhi:LRE	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   210: ldc 133
    //   212: ldc_w 392
    //   215: bipush 13
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_1
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload_0
    //   227: getfield 88	com/tencent/mm/plugin/webview/f/c:mRa	Ljava/lang/String;
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: aload_0
    //   234: getfield 82	com/tencent/mm/plugin/webview/f/c:mScene	I
    //   237: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: dup
    //   242: iconst_3
    //   243: iload_2
    //   244: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_4
    //   250: aload_0
    //   251: getfield 84	com/tencent/mm/plugin/webview/f/c:AOS	I
    //   254: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_5
    //   260: aload 5
    //   262: getfield 370	com/tencent/mm/protocal/protobuf/bhi:pLm	Ljava/lang/String;
    //   265: aastore
    //   266: dup
    //   267: bipush 6
    //   269: aload_0
    //   270: getfield 123	com/tencent/mm/plugin/webview/f/c:JbK	I
    //   273: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: bipush 7
    //   280: aload_0
    //   281: getfield 90	com/tencent/mm/plugin/webview/f/c:mAppId	Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: bipush 8
    //   288: aload_0
    //   289: getfield 92	com/tencent/mm/plugin/webview/f/c:zjn	Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: bipush 9
    //   296: aload_0
    //   297: getfield 100	com/tencent/mm/plugin/webview/f/c:JbN	I
    //   300: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: bipush 10
    //   307: aload_0
    //   308: getfield 94	com/tencent/mm/plugin/webview/f/c:yEg	[B
    //   311: invokestatic 396	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   314: aastore
    //   315: dup
    //   316: bipush 11
    //   318: aload_0
    //   319: getfield 108	com/tencent/mm/plugin/webview/f/c:JbR	Ljava/lang/String;
    //   322: aastore
    //   323: dup
    //   324: bipush 12
    //   326: aload_0
    //   327: getfield 110	com/tencent/mm/plugin/webview/f/c:JbS	Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: ldc_w 290
    //   337: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload_0
    //   341: monitorexit
    //   342: aload 4
    //   344: areturn
    //   345: aload_3
    //   346: invokevirtual 399	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   349: ifnull +14 -> 363
    //   352: aload_3
    //   353: invokevirtual 399	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   356: invokevirtual 402	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   359: astore_3
    //   360: goto -221 -> 139
    //   363: ldc_w 404
    //   366: astore_3
    //   367: goto -228 -> 139
    //   370: astore_1
    //   371: aload_0
    //   372: monitorexit
    //   373: aload_1
    //   374: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	c
    //   0	375	1	paramString	String
    //   0	375	2	paramInt	int
    //   113	254	3	localObject	Object
    //   13	330	4	locald	com.tencent.mm.ak.d
    //   26	235	5	localbhi	bhi
    // Exception table:
    //   from	to	target	type
    //   2	114	370	finally
    //   118	123	370	finally
    //   127	135	370	finally
    //   139	340	370	finally
    //   345	360	370	finally
  }
  
  private void b(final String paramString, final int paramInt, final a<bhj> parama)
  {
    try
    {
      AppMethodBeat.i(224476);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
        {
          AppMethodBeat.i(224457);
          Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.c(c.this)) });
          c.d(c.this).remove(paramString);
          if ((paramAnonymousd.iLL.iLR instanceof bhj))
          {
            paramAnonymousd = (bhj)paramAnonymousd.iLL.iLR;
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousd, parama);
            AppMethodBeat.o(224457);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          Log.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(224457);
        }
      });
      AppMethodBeat.o(224476);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Map<String, String> ij(List<ccc> paramList)
  {
    AppMethodBeat.i(224479);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(224479);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ccc localccc = (ccc)paramList.next();
      localHashMap.put(localccc.xMX, localccc.Cyk);
    }
    AppMethodBeat.o(224479);
    return localHashMap;
  }
  
  private static boolean kg(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void DU(int paramInt)
  {
    this.JbK = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<bhj> parama)
  {
    try
    {
      AppMethodBeat.i(224473);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(224473);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<bhj> parama)
  {
    try
    {
      AppMethodBeat.i(224472);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(224472);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, final a<bhj> parama)
  {
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(224474);
        if ((!paramBoolean) && (aZI(paramString)))
        {
          paramString = a.Jcb;
          AppMethodBeat.o(224474);
          return paramString;
        }
        if (paramBoolean) {
          break label146;
        }
        locald = this.JbQ;
        if (!Util.isNullOrNil(paramString)) {
          break label86;
        }
        Log.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      }
      finally {}
      if (i != 0)
      {
        paramString = a.Jca;
        AppMethodBeat.o(224474);
        continue;
        label86:
        Object localObject = d.aYy(paramString);
        localObject = (d.a)locald.Jce.get(localObject);
        if ((localObject != null) && (((d.a)localObject).IBv != locald.Jch) && (((d.a)localObject).Jcj != locald.Jci))
        {
          i = 1;
          continue;
        }
      }
      else
      {
        label146:
        if ((paramInt == 5) && (this.JbM))
        {
          Log.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          paramString = a.Jca;
          AppMethodBeat.o(224474);
          continue;
        }
        if ((!paramBoolean) && (this.JbJ.contains(paramString)))
        {
          paramString = a.Jcb;
          AppMethodBeat.o(224474);
          continue;
        }
        this.JbJ.add(paramString);
        if (parama != null) {
          parama.by(paramInt, paramString);
        }
        i = paramInt;
        if (paramInt == -1) {
          i = cO(paramString, false);
        }
        paramBoolean = this.JbL;
        this.JbL = false;
        Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s", new Object[] { paramString });
        if ((paramBoolean) && (this.JbP != null) && (paramString.equals(this.JbP.LRH)))
        {
          Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result");
          h.RTc.aX(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(224455);
              Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result CallBack");
              c.a(c.this, c.a(c.this), i, 0, 0, "", c.b(c.this), parama);
              AppMethodBeat.o(224455);
            }
          });
          paramString = a.Jcb;
          AppMethodBeat.o(224474);
          continue;
        }
        b(paramString, i, parama);
        paramString = a.Jcb;
        AppMethodBeat.o(224474);
        continue;
      }
      final int i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(224477);
      IPCRunCgi.a(at(paramString, paramInt), JbV, parama);
      AppMethodBeat.o(224477);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void aZB(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.zjn = str;
  }
  
  public final void aZC(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.JbR = str;
  }
  
  public final void aZD(String paramString)
  {
    this.JbS = paramString;
  }
  
  public final JsapiPermissionWrapper aZE(String paramString)
  {
    AppMethodBeat.i(224463);
    paramString = this.JbQ.aZE(paramString);
    AppMethodBeat.o(224463);
    return paramString;
  }
  
  public final GeneralControlWrapper aZF(String paramString)
  {
    AppMethodBeat.i(224464);
    paramString = this.JbQ.aZF(paramString);
    AppMethodBeat.o(224464);
    return paramString;
  }
  
  public final int aZH(String paramString)
  {
    AppMethodBeat.i(258655);
    int i = cO(paramString, false);
    AppMethodBeat.o(258655);
    return i;
  }
  
  public final boolean aZI(String paramString)
  {
    AppMethodBeat.i(224470);
    boolean bool = this.JbJ.contains(paramString);
    AppMethodBeat.o(224470);
    return bool;
  }
  
  public final String aZj(String paramString)
  {
    AppMethodBeat.i(224466);
    synchronized (this.JbT)
    {
      Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.JbT.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.JbT.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.JbT.get(paramString);
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = this.JbT;
      if (!Util.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = Util.nullAs((String)localObject1, paramString);
      AppMethodBeat.o(224466);
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
  
  public final void age(int paramInt)
  {
    this.JbN = paramInt;
  }
  
  public final void av(byte[] paramArrayOfByte)
  {
    this.yEg = paramArrayOfByte;
  }
  
  public final int cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224469);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(224469);
      return 0;
    }
    if (this.JbL)
    {
      AppMethodBeat.o(224469);
      return 0;
    }
    if (JbU.matcher(paramString).find())
    {
      AppMethodBeat.o(224469);
      return 2;
    }
    if ((!paramBoolean) && (b.aZA(paramString)))
    {
      AppMethodBeat.o(224469);
      return 8;
    }
    AppMethodBeat.o(224469);
    return 1;
  }
  
  public final void destroy()
  {
    this.IJS = true;
  }
  
  public final boolean gbE()
  {
    AppMethodBeat.i(224471);
    if (this.JbJ.size() > 0)
    {
      AppMethodBeat.o(224471);
      return true;
    }
    AppMethodBeat.o(224471);
    return false;
  }
  
  public final boolean gs(String paramString, int paramInt)
  {
    AppMethodBeat.i(224465);
    if (aZE(paramString).aiW(paramInt) == 1)
    {
      AppMethodBeat.o(224465);
      return true;
    }
    AppMethodBeat.o(224465);
    return false;
  }
  
  public final void k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(224462);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(224462);
      return;
    }
    if ((paramArrayOfByte1.length <= 0) || (paramArrayOfByte2.length <= 0))
    {
      AppMethodBeat.o(224462);
      return;
    }
    bhi localbhi = new bhi();
    bhj localbhj = new bhj();
    try
    {
      localbhi.parseFrom(paramArrayOfByte1);
      localbhj.parseFrom(paramArrayOfByte2);
      this.JbO = localbhi.LRx.MTo;
      label80:
      if ((Util.isNullOrNil(this.JbO)) || (localbhj.LRH == null))
      {
        Log.e("MicroMsg.LuggageGetA8Key", "ReqUrl or FullUrl is null");
        AppMethodBeat.o(224462);
        return;
      }
      this.JbP = localbhj;
      AppMethodBeat.o(224462);
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
    this.AOS = paramInt;
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
    this.mRa = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(224460);
      JbZ = new a("INTERCEPTED", 0);
      Jca = new a("NO_NEED", 1);
      Jcb = new a("WILL_GET", 2);
      Jcc = new a("FAILED", 3);
      Jcd = new a[] { JbZ, Jca, Jcb, Jcc };
      AppMethodBeat.o(224460);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.c
 * JD-Core Version:    0.7.0.1
 */