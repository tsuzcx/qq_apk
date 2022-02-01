package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.k.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final Pattern BaV;
  private static final IPCRunCgi.b BaW;
  public boolean AKM;
  private final HashSet<String> BaO;
  private byte[] BaP;
  private boolean BaQ;
  private boolean BaR;
  private int BaS;
  private d BaT;
  private final HashMap<String, String> BaU;
  private String kGt;
  private String mAppId;
  private int mScene;
  private int mWf;
  private String tsj;
  private int uoX;
  
  static
  {
    AppMethodBeat.i(189739);
    BaV = Pattern.compile(".*#.*wechat_redirect");
    BaW = new IPCRunCgi.b()
    {
      public final com.tencent.mm.al.b a(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(189716);
        paramAnonymousb = k.a.f(paramAnonymousb);
        AppMethodBeat.o(189716);
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(189739);
  }
  
  public c()
  {
    AppMethodBeat.i(189721);
    this.BaO = new HashSet();
    this.mScene = 0;
    this.uoX = 0;
    this.kGt = "";
    this.mAppId = "";
    this.tsj = "";
    this.BaP = new byte[0];
    this.BaQ = true;
    this.BaR = false;
    this.BaS = 0;
    this.AKM = false;
    this.BaU = new HashMap();
    this.mWf = ((int)System.currentTimeMillis());
    this.BaT = new d();
    AppMethodBeat.o(189721);
  }
  
  private static void a(String paramString, int paramInt, aoj paramaoj, a<aoj> parama)
  {
    AppMethodBeat.i(189736);
    int i = paramaoj.Ctr;
    String str = paramaoj.gKr;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189736);
      return;
      if ((str == null) || (str.length() == 0))
      {
        ad.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(189736);
        return;
      }
      parama.A(paramInt, paramString, str);
      AppMethodBeat.o(189736);
      return;
      parama.b(paramInt, paramString, paramaoj.DpW, paramaoj);
    }
  }
  
  /* Error */
  private com.tencent.mm.al.b ai(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 260
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 264	com/tencent/mm/modelsimple/k$a:ai	(Ljava/lang/String;I)Lcom/tencent/mm/al/b;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 270	com/tencent/mm/al/b:gUS	Lcom/tencent/mm/al/b$b;
    //   20: getfield 276	com/tencent/mm/al/b$b:gUX	Lcom/tencent/mm/bx/a;
    //   23: checkcast 278	com/tencent/mm/protocal/protobuf/aoi
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 281	com/tencent/mm/protocal/protobuf/aoi:OpCode	I
    //   34: aload 5
    //   36: new 283	com/tencent/mm/protocal/protobuf/cmf
    //   39: dup
    //   40: invokespecial 284	com/tencent/mm/protocal/protobuf/cmf:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 288	com/tencent/mm/protocal/protobuf/cmf:aEE	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cmf;
    //   47: putfield 292	com/tencent/mm/protocal/protobuf/aoi:DpN	Lcom/tencent/mm/protocal/protobuf/cmf;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 75	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   56: putfield 295	com/tencent/mm/protocal/protobuf/aoi:Scene	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 81	com/tencent/mm/plugin/webview/e/c:kGt	Ljava/lang/String;
    //   65: putfield 298	com/tencent/mm/protocal/protobuf/aoi:mAQ	Ljava/lang/String;
    //   68: aload 5
    //   70: iload_2
    //   71: putfield 301	com/tencent/mm/protocal/protobuf/aoi:CCe	I
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 77	com/tencent/mm/plugin/webview/e/c:uoX	I
    //   80: putfield 304	com/tencent/mm/protocal/protobuf/aoi:Cxm	I
    //   83: invokestatic 310	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   86: ldc_w 312
    //   89: invokevirtual 318	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: checkcast 320	android/net/ConnectivityManager
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +232 -> 329
    //   100: aload_3
    //   101: invokevirtual 324	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +223 -> 329
    //   109: aload_3
    //   110: invokevirtual 329	android/net/NetworkInfo:getType	()I
    //   113: iconst_1
    //   114: if_icmpne +197 -> 311
    //   117: ldc_w 331
    //   120: astore_3
    //   121: aload 5
    //   123: aload_3
    //   124: putfield 334	com/tencent/mm/protocal/protobuf/aoi:nlG	Ljava/lang/String;
    //   127: aload 5
    //   129: aload_0
    //   130: getfield 108	com/tencent/mm/plugin/webview/e/c:mWf	I
    //   133: putfield 337	com/tencent/mm/protocal/protobuf/aoi:DpS	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 85	com/tencent/mm/plugin/webview/e/c:tsj	Ljava/lang/String;
    //   142: putfield 340	com/tencent/mm/protocal/protobuf/aoi:DpT	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 93	com/tencent/mm/plugin/webview/e/c:BaS	I
    //   151: putfield 343	com/tencent/mm/protocal/protobuf/aoi:DpU	I
    //   154: aload 5
    //   156: new 283	com/tencent/mm/protocal/protobuf/cmf
    //   159: dup
    //   160: invokespecial 284	com/tencent/mm/protocal/protobuf/cmf:<init>	()V
    //   163: aload_0
    //   164: getfield 83	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   167: invokevirtual 288	com/tencent/mm/protocal/protobuf/cmf:aEE	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cmf;
    //   170: putfield 346	com/tencent/mm/protocal/protobuf/aoi:DpK	Lcom/tencent/mm/protocal/protobuf/cmf;
    //   173: aload 5
    //   175: new 348	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   178: dup
    //   179: invokespecial 349	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   182: aload_0
    //   183: getfield 87	com/tencent/mm/plugin/webview/e/c:BaP	[B
    //   186: invokevirtual 353	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   189: putfield 354	com/tencent/mm/protocal/protobuf/aoi:DpV	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   192: ldc 117
    //   194: ldc_w 356
    //   197: bipush 11
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_0
    //   209: getfield 81	com/tencent/mm/plugin/webview/e/c:kGt	Ljava/lang/String;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: aload_0
    //   216: getfield 75	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   219: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_3
    //   225: iload_2
    //   226: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_4
    //   232: aload_0
    //   233: getfield 77	com/tencent/mm/plugin/webview/e/c:uoX	I
    //   236: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_5
    //   242: aload 5
    //   244: getfield 334	com/tencent/mm/protocal/protobuf/aoi:nlG	Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: bipush 6
    //   251: aload_0
    //   252: getfield 108	com/tencent/mm/plugin/webview/e/c:mWf	I
    //   255: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aastore
    //   259: dup
    //   260: bipush 7
    //   262: aload_0
    //   263: getfield 83	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   266: aastore
    //   267: dup
    //   268: bipush 8
    //   270: aload_0
    //   271: getfield 85	com/tencent/mm/plugin/webview/e/c:tsj	Ljava/lang/String;
    //   274: aastore
    //   275: dup
    //   276: bipush 9
    //   278: aload_0
    //   279: getfield 93	com/tencent/mm/plugin/webview/e/c:BaS	I
    //   282: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: bipush 10
    //   289: aload_0
    //   290: getfield 87	com/tencent/mm/plugin/webview/e/c:BaP	[B
    //   293: invokestatic 360	com/tencent/mm/sdk/platformtools/bt:cy	([B)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc_w 260
    //   303: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: monitorexit
    //   308: aload 4
    //   310: areturn
    //   311: aload_3
    //   312: invokevirtual 363	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   315: ifnull +14 -> 329
    //   318: aload_3
    //   319: invokevirtual 363	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   322: invokevirtual 366	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   325: astore_3
    //   326: goto -205 -> 121
    //   329: ldc_w 368
    //   332: astore_3
    //   333: goto -212 -> 121
    //   336: astore_1
    //   337: aload_0
    //   338: monitorexit
    //   339: aload_1
    //   340: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	c
    //   0	341	1	paramString	String
    //   0	341	2	paramInt	int
    //   95	238	3	localObject	Object
    //   13	296	4	localb	com.tencent.mm.al.b
    //   26	217	5	localaoi	com.tencent.mm.protocal.protobuf.aoi
    // Exception table:
    //   from	to	target	type
    //   2	96	336	finally
    //   100	105	336	finally
    //   109	117	336	finally
    //   121	306	336	finally
    //   311	326	336	finally
  }
  
  public static int axm(String paramString)
  {
    AppMethodBeat.i(189726);
    paramString = com.tencent.mm.protocal.c.aDh(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(189726);
      return -1;
    }
    int i = paramString.eBD();
    AppMethodBeat.o(189726);
    return i;
  }
  
  private void b(final String paramString, final int paramInt, final a<aoj> parama)
  {
    try
    {
      AppMethodBeat.i(189734);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(189717);
          ad.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.a(c.this)) });
          c.b(c.this).remove(paramString);
          if ((paramAnonymousb.gUT.gUX instanceof aoj))
          {
            paramAnonymousb = (aoj)paramAnonymousb.gUT.gUX;
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, parama);
            AppMethodBeat.o(189717);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          ad.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(189717);
        }
      });
      AppMethodBeat.o(189734);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Map<String, String> gx(List<bgq> paramList)
  {
    AppMethodBeat.i(189737);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(189737);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bgq localbgq = (bgq)paramList.next();
      localHashMap.put(localbgq.sdv, localbgq.vJI);
    }
    AppMethodBeat.o(189737);
    return localHashMap;
  }
  
  private static boolean iu(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void SR(int paramInt)
  {
    this.mWf = paramInt;
  }
  
  public final void SS(int paramInt)
  {
    this.BaS = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<aoj> parama)
  {
    try
    {
      AppMethodBeat.i(189731);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(189731);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<aoj> parama)
  {
    try
    {
      AppMethodBeat.i(189730);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(189730);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, a<aoj> parama)
  {
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(189732);
        if ((!paramBoolean) && (axo(paramString)))
        {
          paramString = a.Bbb;
          AppMethodBeat.o(189732);
          return paramString;
        }
        if (paramBoolean) {
          break label146;
        }
        locald = this.BaT;
        if (!bt.isNullOrNil(paramString)) {
          break label86;
        }
        ad.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      }
      finally {}
      if (i != 0)
      {
        paramString = a.Bba;
        AppMethodBeat.o(189732);
        continue;
        label86:
        Object localObject = d.awm(paramString);
        localObject = (d.a)locald.Bbe.get(localObject);
        if ((localObject != null) && (((d.a)localObject).ARc != locald.Bbh) && (((d.a)localObject).Bbj != locald.Bbi))
        {
          i = 1;
          continue;
        }
      }
      else
      {
        label146:
        if ((paramInt == 5) && (this.BaR))
        {
          ad.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          paramString = a.Bba;
          AppMethodBeat.o(189732);
          continue;
        }
        if ((paramBoolean) && (this.BaO.contains(paramString)))
        {
          paramString = a.Bbb;
          AppMethodBeat.o(189732);
          continue;
        }
        this.BaO.add(paramString);
        if (parama != null) {
          parama.bf(paramInt, paramString);
        }
        i = paramInt;
        if (paramInt == -1) {
          i = axn(paramString);
        }
        this.BaQ = false;
        ad.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s", new Object[] { paramString });
        b(paramString, i, parama);
        paramString = a.Bbb;
        AppMethodBeat.o(189732);
        continue;
      }
      int i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(189735);
      IPCRunCgi.a(ai(paramString, paramInt), BaW, parama);
      AppMethodBeat.o(189735);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.BaP = paramArrayOfByte;
  }
  
  public final String awT(String paramString)
  {
    AppMethodBeat.i(189725);
    synchronized (this.BaU)
    {
      ad.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.BaU.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ad.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.BaU.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.BaU.get(paramString);
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject2 = this.BaU;
      if (!bt.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = bt.by((String)localObject1, paramString);
      AppMethodBeat.o(189725);
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
  
  public final void axj(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.tsj = str;
  }
  
  public final JsapiPermissionWrapper axk(String paramString)
  {
    AppMethodBeat.i(189722);
    paramString = this.BaT.axk(paramString);
    AppMethodBeat.o(189722);
    return paramString;
  }
  
  public final GeneralControlWrapper axl(String paramString)
  {
    AppMethodBeat.i(189723);
    paramString = this.BaT.axl(paramString);
    AppMethodBeat.o(189723);
    return paramString;
  }
  
  public final int axn(String paramString)
  {
    AppMethodBeat.i(189727);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(189727);
      return 0;
    }
    if (this.BaQ)
    {
      AppMethodBeat.o(189727);
      return 0;
    }
    if (BaV.matcher(paramString).find())
    {
      AppMethodBeat.o(189727);
      return 2;
    }
    if (b.axi(paramString))
    {
      AppMethodBeat.o(189727);
      return 8;
    }
    AppMethodBeat.o(189727);
    return 1;
  }
  
  public final boolean axo(String paramString)
  {
    AppMethodBeat.i(189728);
    boolean bool = this.BaO.contains(paramString);
    AppMethodBeat.o(189728);
    return bool;
  }
  
  public final void destroy()
  {
    this.AKM = true;
  }
  
  public final boolean ekU()
  {
    AppMethodBeat.i(189729);
    if (this.BaO.size() > 0)
    {
      AppMethodBeat.o(189729);
      return true;
    }
    AppMethodBeat.o(189729);
    return false;
  }
  
  public final boolean ff(String paramString, int paramInt)
  {
    AppMethodBeat.i(189724);
    if (axk(paramString).Vw(paramInt) == 1)
    {
      AppMethodBeat.o(189724);
      return true;
    }
    AppMethodBeat.o(189724);
    return false;
  }
  
  public final void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void setFlag(int paramInt)
  {
    this.uoX = paramInt;
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
    this.kGt = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(189720);
      BaZ = new a("INTERCEPTED", 0);
      Bba = new a("NO_NEED", 1);
      Bbb = new a("WILL_GET", 2);
      Bbc = new a("FAILED", 3);
      Bbd = new a[] { BaZ, Bba, Bbb, Bbc };
      AppMethodBeat.o(189720);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.c
 * JD-Core Version:    0.7.0.1
 */