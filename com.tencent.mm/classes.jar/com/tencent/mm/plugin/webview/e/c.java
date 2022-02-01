package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.k.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final Pattern Cth;
  private static final IPCRunCgi.b Cti;
  public boolean Cdd;
  private final HashSet<String> Ctb;
  private boolean Ctc;
  private boolean Ctd;
  private int Cte;
  private d Ctf;
  private final HashMap<String, String> Ctg;
  private String lhM;
  private String mAppId;
  private int mScene;
  private int nyE;
  private byte[] tWa;
  private String uAC;
  private int vxT;
  
  static
  {
    AppMethodBeat.i(205368);
    Cth = Pattern.compile(".*#.*wechat_redirect");
    Cti = new IPCRunCgi.b()
    {
      public final com.tencent.mm.ak.b a(com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(205345);
        paramAnonymousb = k.a.f(paramAnonymousb);
        AppMethodBeat.o(205345);
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(205368);
  }
  
  public c()
  {
    AppMethodBeat.i(205350);
    this.Ctb = new HashSet();
    this.mScene = 0;
    this.vxT = 0;
    this.lhM = "";
    this.mAppId = "";
    this.uAC = "";
    this.tWa = new byte[0];
    this.Ctc = true;
    this.Ctd = false;
    this.Cte = 0;
    this.Cdd = false;
    this.Ctg = new HashMap();
    this.nyE = ((int)System.currentTimeMillis());
    this.Ctf = new d();
    AppMethodBeat.o(205350);
  }
  
  private static void a(String paramString, int paramInt, arn paramarn, a<arn> parama)
  {
    AppMethodBeat.i(205365);
    int i = paramarn.DLI;
    String str = paramarn.hkR;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205365);
      return;
      if ((str == null) || (str.length() == 0))
      {
        ac.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(205365);
        return;
      }
      parama.A(paramInt, paramString, str);
      AppMethodBeat.o(205365);
      return;
      parama.b(paramInt, paramString, paramarn.EKZ, paramarn);
    }
  }
  
  public static int aCE(String paramString)
  {
    AppMethodBeat.i(205355);
    paramString = com.tencent.mm.protocal.c.aIy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(205355);
      return -1;
    }
    int i = paramString.eQY();
    AppMethodBeat.o(205355);
    return i;
  }
  
  /* Error */
  private com.tencent.mm.ak.b am(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 274
    //   5: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 278	com/tencent/mm/modelsimple/k$a:am	(Ljava/lang/String;I)Lcom/tencent/mm/ak/b;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 284	com/tencent/mm/ak/b:hvr	Lcom/tencent/mm/ak/b$b;
    //   20: getfield 290	com/tencent/mm/ak/b$b:hvw	Lcom/tencent/mm/bw/a;
    //   23: checkcast 292	com/tencent/mm/protocal/protobuf/arm
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 295	com/tencent/mm/protocal/protobuf/arm:OpCode	I
    //   34: aload 5
    //   36: new 297	com/tencent/mm/protocal/protobuf/crm
    //   39: dup
    //   40: invokespecial 298	com/tencent/mm/protocal/protobuf/crm:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 302	com/tencent/mm/protocal/protobuf/crm:aJV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/crm;
    //   47: putfield 306	com/tencent/mm/protocal/protobuf/arm:EKQ	Lcom/tencent/mm/protocal/protobuf/crm;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 75	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   56: putfield 309	com/tencent/mm/protocal/protobuf/arm:Scene	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 81	com/tencent/mm/plugin/webview/e/c:lhM	Ljava/lang/String;
    //   65: putfield 312	com/tencent/mm/protocal/protobuf/arm:ncR	Ljava/lang/String;
    //   68: aload 5
    //   70: iload_2
    //   71: putfield 315	com/tencent/mm/protocal/protobuf/arm:DUB	I
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 77	com/tencent/mm/plugin/webview/e/c:vxT	I
    //   80: putfield 318	com/tencent/mm/protocal/protobuf/arm:DPI	I
    //   83: invokestatic 324	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   86: ldc_w 326
    //   89: invokevirtual 332	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: checkcast 334	android/net/ConnectivityManager
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +232 -> 329
    //   100: aload_3
    //   101: invokevirtual 338	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +223 -> 329
    //   109: aload_3
    //   110: invokevirtual 343	android/net/NetworkInfo:getType	()I
    //   113: iconst_1
    //   114: if_icmpne +197 -> 311
    //   117: ldc_w 345
    //   120: astore_3
    //   121: aload 5
    //   123: aload_3
    //   124: putfield 348	com/tencent/mm/protocal/protobuf/arm:nOG	Ljava/lang/String;
    //   127: aload 5
    //   129: aload_0
    //   130: getfield 108	com/tencent/mm/plugin/webview/e/c:nyE	I
    //   133: putfield 351	com/tencent/mm/protocal/protobuf/arm:EKV	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 85	com/tencent/mm/plugin/webview/e/c:uAC	Ljava/lang/String;
    //   142: putfield 354	com/tencent/mm/protocal/protobuf/arm:EKW	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 93	com/tencent/mm/plugin/webview/e/c:Cte	I
    //   151: putfield 357	com/tencent/mm/protocal/protobuf/arm:EKX	I
    //   154: aload 5
    //   156: new 297	com/tencent/mm/protocal/protobuf/crm
    //   159: dup
    //   160: invokespecial 298	com/tencent/mm/protocal/protobuf/crm:<init>	()V
    //   163: aload_0
    //   164: getfield 83	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   167: invokevirtual 302	com/tencent/mm/protocal/protobuf/crm:aJV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/crm;
    //   170: putfield 360	com/tencent/mm/protocal/protobuf/arm:EKN	Lcom/tencent/mm/protocal/protobuf/crm;
    //   173: aload 5
    //   175: new 362	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   178: dup
    //   179: invokespecial 363	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   182: aload_0
    //   183: getfield 87	com/tencent/mm/plugin/webview/e/c:tWa	[B
    //   186: invokevirtual 367	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   189: putfield 368	com/tencent/mm/protocal/protobuf/arm:EKY	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   192: ldc 117
    //   194: ldc_w 370
    //   197: bipush 11
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_0
    //   209: getfield 81	com/tencent/mm/plugin/webview/e/c:lhM	Ljava/lang/String;
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
    //   233: getfield 77	com/tencent/mm/plugin/webview/e/c:vxT	I
    //   236: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_5
    //   242: aload 5
    //   244: getfield 348	com/tencent/mm/protocal/protobuf/arm:nOG	Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: bipush 6
    //   251: aload_0
    //   252: getfield 108	com/tencent/mm/plugin/webview/e/c:nyE	I
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
    //   271: getfield 85	com/tencent/mm/plugin/webview/e/c:uAC	Ljava/lang/String;
    //   274: aastore
    //   275: dup
    //   276: bipush 9
    //   278: aload_0
    //   279: getfield 93	com/tencent/mm/plugin/webview/e/c:Cte	I
    //   282: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: bipush 10
    //   289: aload_0
    //   290: getfield 87	com/tencent/mm/plugin/webview/e/c:tWa	[B
    //   293: invokestatic 374	com/tencent/mm/sdk/platformtools/bs:cx	([B)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 155	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc_w 274
    //   303: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: monitorexit
    //   308: aload 4
    //   310: areturn
    //   311: aload_3
    //   312: invokevirtual 377	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   315: ifnull +14 -> 329
    //   318: aload_3
    //   319: invokevirtual 377	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   322: invokevirtual 380	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   325: astore_3
    //   326: goto -205 -> 121
    //   329: ldc_w 382
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
    //   13	296	4	localb	com.tencent.mm.ak.b
    //   26	217	5	localarm	com.tencent.mm.protocal.protobuf.arm
    // Exception table:
    //   from	to	target	type
    //   2	96	336	finally
    //   100	105	336	finally
    //   109	117	336	finally
    //   121	306	336	finally
    //   311	326	336	finally
  }
  
  private void b(final String paramString, final int paramInt, final a<arn> parama)
  {
    try
    {
      AppMethodBeat.i(205363);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(205346);
          ac.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.a(c.this)) });
          c.b(c.this).remove(paramString);
          if ((paramAnonymousb.hvs.hvw instanceof arn))
          {
            paramAnonymousb = (arn)paramAnonymousb.hvs.hvw;
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, parama);
            AppMethodBeat.o(205346);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          ac.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(205346);
        }
      });
      AppMethodBeat.o(205363);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Map<String, String> gI(List<bki> paramList)
  {
    AppMethodBeat.i(205366);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(205366);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bki localbki = (bki)paramList.next();
      localHashMap.put(localbki.tlp, localbki.wTM);
    }
    AppMethodBeat.o(205366);
    return localHashMap;
  }
  
  private static boolean iI(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void UZ(int paramInt)
  {
    this.nyE = paramInt;
  }
  
  public final void Va(int paramInt)
  {
    this.Cte = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<arn> parama)
  {
    try
    {
      AppMethodBeat.i(205360);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(205360);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<arn> parama)
  {
    try
    {
      AppMethodBeat.i(205359);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(205359);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, a<arn> parama)
  {
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(205361);
        if ((!paramBoolean) && (aCG(paramString)))
        {
          paramString = a.Ctn;
          AppMethodBeat.o(205361);
          return paramString;
        }
        if (paramBoolean) {
          break label146;
        }
        locald = this.Ctf;
        if (!bs.isNullOrNil(paramString)) {
          break label86;
        }
        ac.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      }
      finally {}
      if (i != 0)
      {
        paramString = a.Ctm;
        AppMethodBeat.o(205361);
        continue;
        label86:
        Object localObject = d.aBE(paramString);
        localObject = (d.a)locald.Ctq.get(localObject);
        if ((localObject != null) && (((d.a)localObject).Cjp != locald.Ctt) && (((d.a)localObject).Ctv != locald.Ctu))
        {
          i = 1;
          continue;
        }
      }
      else
      {
        label146:
        if ((paramInt == 5) && (this.Ctd))
        {
          ac.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          paramString = a.Ctm;
          AppMethodBeat.o(205361);
          continue;
        }
        if ((paramBoolean) && (this.Ctb.contains(paramString)))
        {
          paramString = a.Ctn;
          AppMethodBeat.o(205361);
          continue;
        }
        this.Ctb.add(paramString);
        if (parama != null) {
          parama.bk(paramInt, paramString);
        }
        i = paramInt;
        if (paramInt == -1) {
          i = aCF(paramString);
        }
        this.Ctc = false;
        ac.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s", new Object[] { paramString });
        b(paramString, i, parama);
        paramString = a.Ctn;
        AppMethodBeat.o(205361);
        continue;
      }
      int i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(205364);
      IPCRunCgi.a(am(paramString, paramInt), Cti, parama);
      AppMethodBeat.o(205364);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void aCB(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.uAC = str;
  }
  
  public final JsapiPermissionWrapper aCC(String paramString)
  {
    AppMethodBeat.i(205351);
    paramString = this.Ctf.aCC(paramString);
    AppMethodBeat.o(205351);
    return paramString;
  }
  
  public final GeneralControlWrapper aCD(String paramString)
  {
    AppMethodBeat.i(205352);
    paramString = this.Ctf.aCD(paramString);
    AppMethodBeat.o(205352);
    return paramString;
  }
  
  public final int aCF(String paramString)
  {
    AppMethodBeat.i(205356);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(205356);
      return 0;
    }
    if (this.Ctc)
    {
      AppMethodBeat.o(205356);
      return 0;
    }
    if (Cth.matcher(paramString).find())
    {
      AppMethodBeat.o(205356);
      return 2;
    }
    if (b.aCA(paramString))
    {
      AppMethodBeat.o(205356);
      return 8;
    }
    AppMethodBeat.o(205356);
    return 1;
  }
  
  public final boolean aCG(String paramString)
  {
    AppMethodBeat.i(205357);
    boolean bool = this.Ctb.contains(paramString);
    AppMethodBeat.o(205357);
    return bool;
  }
  
  public final String aCl(String paramString)
  {
    AppMethodBeat.i(205354);
    synchronized (this.Ctg)
    {
      ac.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.Ctg.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ac.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.Ctg.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.Ctg.get(paramString);
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      localObject2 = this.Ctg;
      if (!bs.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = bs.bG((String)localObject1, paramString);
      AppMethodBeat.o(205354);
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
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.tWa = paramArrayOfByte;
  }
  
  public final void destroy()
  {
    this.Cdd = true;
  }
  
  public final boolean eAq()
  {
    AppMethodBeat.i(205358);
    if (this.Ctb.size() > 0)
    {
      AppMethodBeat.o(205358);
      return true;
    }
    AppMethodBeat.o(205358);
    return false;
  }
  
  public final boolean fn(String paramString, int paramInt)
  {
    AppMethodBeat.i(205353);
    if (aCC(paramString).XF(paramInt) == 1)
    {
      AppMethodBeat.o(205353);
      return true;
    }
    AppMethodBeat.o(205353);
    return false;
  }
  
  public final void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void setFlag(int paramInt)
  {
    this.vxT = paramInt;
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
    this.lhM = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(205349);
      Ctl = new a("INTERCEPTED", 0);
      Ctm = new a("NO_NEED", 1);
      Ctn = new a("WILL_GET", 2);
      Cto = new a("FAILED", 3);
      Ctp = new a[] { Ctl, Ctm, Ctn, Cto };
      AppMethodBeat.o(205349);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.c
 * JD-Core Version:    0.7.0.1
 */