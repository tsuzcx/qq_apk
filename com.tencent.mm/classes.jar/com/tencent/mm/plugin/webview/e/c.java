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
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bos;
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
  private static final Pattern DWN;
  private static final IPCRunCgi.b DWO;
  public boolean DGd;
  private final HashSet<String> DWG;
  private int DWH;
  private boolean DWI;
  private boolean DWJ;
  private int DWK;
  private d DWL;
  private final HashMap<String, String> DWM;
  private String lEN;
  private String mAppId;
  private int mScene;
  private byte[] uYJ;
  private String vDf;
  private int wDn;
  
  static
  {
    AppMethodBeat.i(213970);
    DWN = Pattern.compile(".*#.*wechat_redirect");
    DWO = new IPCRunCgi.b()
    {
      public final com.tencent.mm.al.b a(com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(213947);
        paramAnonymousb = k.a.f(paramAnonymousb);
        AppMethodBeat.o(213947);
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(213970);
  }
  
  public c()
  {
    AppMethodBeat.i(213952);
    this.DWG = new HashSet();
    this.mScene = 0;
    this.wDn = 0;
    this.lEN = "";
    this.mAppId = "";
    this.vDf = "";
    this.uYJ = new byte[0];
    this.DWI = true;
    this.DWJ = false;
    this.DWK = 0;
    this.DGd = false;
    this.DWM = new HashMap();
    this.DWH = ((int)System.currentTimeMillis());
    this.DWL = new d();
    AppMethodBeat.o(213952);
  }
  
  private static void a(String paramString, int paramInt, boolean paramBoolean, avj paramavj, a<avj> parama)
  {
    AppMethodBeat.i(213967);
    int i = paramavj.FqN;
    String str = paramavj.hDa;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(213967);
      return;
      if ((str == null) || (str.length() == 0))
      {
        ad.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(213967);
        return;
      }
      parama.z(paramInt, paramString, str);
      AppMethodBeat.o(213967);
      return;
      parama.a(paramInt, paramBoolean, paramString, paramavj.Guc, paramavj);
    }
  }
  
  public static int aIg(String paramString)
  {
    AppMethodBeat.i(213957);
    paramString = com.tencent.mm.protocal.c.aOb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(213957);
      return -1;
    }
    int i = paramString.fgc();
    AppMethodBeat.o(213957);
    return i;
  }
  
  /* Error */
  private com.tencent.mm.al.b ao(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 275
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 279	com/tencent/mm/modelsimple/k$a:ao	(Ljava/lang/String;I)Lcom/tencent/mm/al/b;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 285	com/tencent/mm/al/b:hNK	Lcom/tencent/mm/al/b$b;
    //   20: getfield 291	com/tencent/mm/al/b$b:hNQ	Lcom/tencent/mm/bx/a;
    //   23: checkcast 293	com/tencent/mm/protocal/protobuf/avi
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 296	com/tencent/mm/protocal/protobuf/avi:OpCode	I
    //   34: aload 5
    //   36: new 298	com/tencent/mm/protocal/protobuf/cwt
    //   39: dup
    //   40: invokespecial 299	com/tencent/mm/protocal/protobuf/cwt:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 303	com/tencent/mm/protocal/protobuf/cwt:aPy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cwt;
    //   47: putfield 307	com/tencent/mm/protocal/protobuf/avi:GtT	Lcom/tencent/mm/protocal/protobuf/cwt;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 75	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   56: putfield 310	com/tencent/mm/protocal/protobuf/avi:Scene	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 81	com/tencent/mm/plugin/webview/e/c:lEN	Ljava/lang/String;
    //   65: putfield 313	com/tencent/mm/protocal/protobuf/avi:nDo	Ljava/lang/String;
    //   68: aload 5
    //   70: iload_2
    //   71: putfield 316	com/tencent/mm/protocal/protobuf/avi:FzW	I
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 77	com/tencent/mm/plugin/webview/e/c:wDn	I
    //   80: putfield 319	com/tencent/mm/protocal/protobuf/avi:FuX	I
    //   83: invokestatic 325	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   86: ldc_w 327
    //   89: invokevirtual 333	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: checkcast 335	android/net/ConnectivityManager
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +232 -> 329
    //   100: aload_3
    //   101: invokevirtual 339	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +223 -> 329
    //   109: aload_3
    //   110: invokevirtual 344	android/net/NetworkInfo:getType	()I
    //   113: iconst_1
    //   114: if_icmpne +197 -> 311
    //   117: ldc_w 346
    //   120: astore_3
    //   121: aload 5
    //   123: aload_3
    //   124: putfield 349	com/tencent/mm/protocal/protobuf/avi:orm	Ljava/lang/String;
    //   127: aload 5
    //   129: aload_0
    //   130: getfield 108	com/tencent/mm/plugin/webview/e/c:DWH	I
    //   133: putfield 352	com/tencent/mm/protocal/protobuf/avi:GtY	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 85	com/tencent/mm/plugin/webview/e/c:vDf	Ljava/lang/String;
    //   142: putfield 355	com/tencent/mm/protocal/protobuf/avi:GtZ	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 93	com/tencent/mm/plugin/webview/e/c:DWK	I
    //   151: putfield 358	com/tencent/mm/protocal/protobuf/avi:Gua	I
    //   154: aload 5
    //   156: new 298	com/tencent/mm/protocal/protobuf/cwt
    //   159: dup
    //   160: invokespecial 299	com/tencent/mm/protocal/protobuf/cwt:<init>	()V
    //   163: aload_0
    //   164: getfield 83	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   167: invokevirtual 303	com/tencent/mm/protocal/protobuf/cwt:aPy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cwt;
    //   170: putfield 361	com/tencent/mm/protocal/protobuf/avi:GtQ	Lcom/tencent/mm/protocal/protobuf/cwt;
    //   173: aload 5
    //   175: new 363	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   178: dup
    //   179: invokespecial 364	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   182: aload_0
    //   183: getfield 87	com/tencent/mm/plugin/webview/e/c:uYJ	[B
    //   186: invokevirtual 368	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   189: putfield 369	com/tencent/mm/protocal/protobuf/avi:Gub	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   192: ldc 117
    //   194: ldc_w 371
    //   197: bipush 11
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_0
    //   209: getfield 81	com/tencent/mm/plugin/webview/e/c:lEN	Ljava/lang/String;
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
    //   233: getfield 77	com/tencent/mm/plugin/webview/e/c:wDn	I
    //   236: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_5
    //   242: aload 5
    //   244: getfield 349	com/tencent/mm/protocal/protobuf/avi:orm	Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: bipush 6
    //   251: aload_0
    //   252: getfield 108	com/tencent/mm/plugin/webview/e/c:DWH	I
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
    //   271: getfield 85	com/tencent/mm/plugin/webview/e/c:vDf	Ljava/lang/String;
    //   274: aastore
    //   275: dup
    //   276: bipush 9
    //   278: aload_0
    //   279: getfield 93	com/tencent/mm/plugin/webview/e/c:DWK	I
    //   282: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: bipush 10
    //   289: aload_0
    //   290: getfield 87	com/tencent/mm/plugin/webview/e/c:uYJ	[B
    //   293: invokestatic 375	com/tencent/mm/sdk/platformtools/bt:cE	([B)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 155	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc_w 275
    //   303: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: monitorexit
    //   308: aload 4
    //   310: areturn
    //   311: aload_3
    //   312: invokevirtual 378	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   315: ifnull +14 -> 329
    //   318: aload_3
    //   319: invokevirtual 378	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   322: invokevirtual 381	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   325: astore_3
    //   326: goto -205 -> 121
    //   329: ldc_w 383
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
    //   26	217	5	localavi	com.tencent.mm.protocal.protobuf.avi
    // Exception table:
    //   from	to	target	type
    //   2	96	336	finally
    //   100	105	336	finally
    //   109	117	336	finally
    //   121	306	336	finally
    //   311	326	336	finally
  }
  
  private void b(final String paramString, final int paramInt, final a<avj> parama)
  {
    try
    {
      AppMethodBeat.i(213965);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
        {
          AppMethodBeat.i(213948);
          ad.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.a(c.this)) });
          c.b(c.this).remove(paramString);
          if ((paramAnonymousb.hNL.hNQ instanceof avj))
          {
            paramAnonymousb = (avj)paramAnonymousb.hNL.hNQ;
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, parama);
            AppMethodBeat.o(213948);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          ad.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(213948);
        }
      });
      AppMethodBeat.o(213965);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Map<String, String> gU(List<bos> paramList)
  {
    AppMethodBeat.i(213968);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(213968);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bos localbos = (bos)paramList.next();
      localHashMap.put(localbos.ujy, localbos.yhw);
    }
    AppMethodBeat.o(213968);
    return localHashMap;
  }
  
  private static boolean iV(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void WP(int paramInt)
  {
    this.DWH = paramInt;
  }
  
  public final void WQ(int paramInt)
  {
    this.DWK = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<avj> parama)
  {
    try
    {
      AppMethodBeat.i(213962);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(213962);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<avj> parama)
  {
    try
    {
      AppMethodBeat.i(213961);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(213961);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, a<avj> parama)
  {
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(213963);
        if ((!paramBoolean) && (aIi(paramString)))
        {
          paramString = a.DWT;
          AppMethodBeat.o(213963);
          return paramString;
        }
        if (paramBoolean) {
          break label146;
        }
        locald = this.DWL;
        if (!bt.isNullOrNil(paramString)) {
          break label86;
        }
        ad.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      }
      finally {}
      if (i != 0)
      {
        paramString = a.DWS;
        AppMethodBeat.o(213963);
        continue;
        label86:
        Object localObject = d.aHc(paramString);
        localObject = (d.a)locald.DWW.get(localObject);
        if ((localObject != null) && (((d.a)localObject).DzO != locald.DWZ) && (((d.a)localObject).DXb != locald.DXa))
        {
          i = 1;
          continue;
        }
      }
      else
      {
        label146:
        if ((paramInt == 5) && (this.DWJ))
        {
          ad.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          paramString = a.DWS;
          AppMethodBeat.o(213963);
          continue;
        }
        if ((paramBoolean) && (this.DWG.contains(paramString)))
        {
          paramString = a.DWT;
          AppMethodBeat.o(213963);
          continue;
        }
        this.DWG.add(paramString);
        if (parama != null) {
          parama.bn(paramInt, paramString);
        }
        i = paramInt;
        if (paramInt == -1) {
          i = aIh(paramString);
        }
        this.DWI = false;
        ad.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s", new Object[] { paramString });
        b(paramString, i, parama);
        paramString = a.DWT;
        AppMethodBeat.o(213963);
        continue;
      }
      int i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(213966);
      IPCRunCgi.a(ao(paramString, paramInt), DWO, parama);
      AppMethodBeat.o(213966);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String aHL(String paramString)
  {
    AppMethodBeat.i(213956);
    synchronized (this.DWM)
    {
      ad.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.DWM.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ad.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.DWM.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.DWM.get(paramString);
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject2 = this.DWM;
      if (!bt.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = bt.bI((String)localObject1, paramString);
      AppMethodBeat.o(213956);
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
  
  public final void aId(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.vDf = str;
  }
  
  public final JsapiPermissionWrapper aIe(String paramString)
  {
    AppMethodBeat.i(213953);
    paramString = this.DWL.aIe(paramString);
    AppMethodBeat.o(213953);
    return paramString;
  }
  
  public final GeneralControlWrapper aIf(String paramString)
  {
    AppMethodBeat.i(213954);
    paramString = this.DWL.aIf(paramString);
    AppMethodBeat.o(213954);
    return paramString;
  }
  
  public final int aIh(String paramString)
  {
    AppMethodBeat.i(213958);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(213958);
      return 0;
    }
    if (this.DWI)
    {
      AppMethodBeat.o(213958);
      return 0;
    }
    if (DWN.matcher(paramString).find())
    {
      AppMethodBeat.o(213958);
      return 2;
    }
    if (b.aIc(paramString))
    {
      AppMethodBeat.o(213958);
      return 8;
    }
    AppMethodBeat.o(213958);
    return 1;
  }
  
  public final boolean aIi(String paramString)
  {
    AppMethodBeat.i(213959);
    boolean bool = this.DWG.contains(paramString);
    AppMethodBeat.o(213959);
    return bool;
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.uYJ = paramArrayOfByte;
  }
  
  public final void destroy()
  {
    this.DGd = true;
  }
  
  public final boolean ePg()
  {
    AppMethodBeat.i(213960);
    if (this.DWG.size() > 0)
    {
      AppMethodBeat.o(213960);
      return true;
    }
    AppMethodBeat.o(213960);
    return false;
  }
  
  public final boolean fK(String paramString, int paramInt)
  {
    AppMethodBeat.i(213955);
    if (aIe(paramString).ZB(paramInt) == 1)
    {
      AppMethodBeat.o(213955);
      return true;
    }
    AppMethodBeat.o(213955);
    return false;
  }
  
  public final void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void setFlag(int paramInt)
  {
    this.wDn = paramInt;
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
    this.lEN = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(213951);
      DWR = new a("INTERCEPTED", 0);
      DWS = new a("NO_NEED", 1);
      DWT = new a("WILL_GET", 2);
      DWU = new a("FAILED", 3);
      DWV = new a[] { DWR, DWS, DWT, DWU };
      AppMethodBeat.o(213951);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.c
 * JD-Core Version:    0.7.0.1
 */