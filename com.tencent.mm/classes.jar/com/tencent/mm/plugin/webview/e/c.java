package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b;
import com.tencent.mm.modelsimple.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static final Pattern EoO;
  private static final IPCRunCgi.b EoP;
  public boolean DYb;
  private final HashSet<String> EoF;
  private int EoG;
  private boolean EoH;
  private boolean EoI;
  private int EoJ;
  private String EoK;
  private avz EoL;
  private d EoM;
  private final HashMap<String, String> EoN;
  private String lJm;
  private String mAppId;
  private int mScene;
  private String vPj;
  private byte[] vkz;
  private int wSY;
  
  static
  {
    AppMethodBeat.i(213801);
    EoO = Pattern.compile(".*#.*wechat_redirect");
    EoP = new IPCRunCgi.b()
    {
      public final com.tencent.mm.ak.b a(com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(213777);
        paramAnonymousb = l.a.f(paramAnonymousb);
        AppMethodBeat.o(213777);
        return paramAnonymousb;
      }
    };
    AppMethodBeat.o(213801);
  }
  
  public c()
  {
    AppMethodBeat.i(213782);
    this.EoF = new HashSet();
    this.mScene = 0;
    this.wSY = 0;
    this.lJm = "";
    this.mAppId = "";
    this.vPj = "";
    this.vkz = new byte[0];
    this.EoH = true;
    this.EoI = false;
    this.EoJ = 0;
    this.DYb = false;
    this.EoK = null;
    this.EoL = null;
    this.EoN = new HashMap();
    this.EoG = ((int)System.currentTimeMillis());
    this.EoM = new d();
    AppMethodBeat.o(213782);
  }
  
  private static void a(String paramString, int paramInt, boolean paramBoolean, avz paramavz, a<avz> parama)
  {
    AppMethodBeat.i(213798);
    int i = paramavz.FJl;
    String str = paramavz.hFS;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(213798);
      return;
      if ((str == null) || (str.length() == 0))
      {
        ae.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
        AppMethodBeat.o(213798);
        return;
      }
      parama.z(paramInt, paramString, str);
      AppMethodBeat.o(213798);
      return;
      parama.a(paramInt, paramBoolean, paramString, paramavz.GNB, paramavz);
    }
  }
  
  public static int aJz(String paramString)
  {
    AppMethodBeat.i(213788);
    paramString = com.tencent.mm.protocal.c.aPy(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(213788);
      return -1;
    }
    int i = paramString.fjS();
    AppMethodBeat.o(213788);
    return i;
  }
  
  /* Error */
  private com.tencent.mm.ak.b ap(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 284
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: iload_2
    //   10: invokestatic 288	com/tencent/mm/modelsimple/l$a:ap	(Ljava/lang/String;I)Lcom/tencent/mm/ak/b;
    //   13: astore 4
    //   15: aload 4
    //   17: getfield 294	com/tencent/mm/ak/b:hQD	Lcom/tencent/mm/ak/b$b;
    //   20: getfield 300	com/tencent/mm/ak/b$b:hQJ	Lcom/tencent/mm/bw/a;
    //   23: checkcast 302	com/tencent/mm/protocal/protobuf/avy
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_2
    //   31: putfield 305	com/tencent/mm/protocal/protobuf/avy:OpCode	I
    //   34: aload 5
    //   36: new 307	com/tencent/mm/protocal/protobuf/cxn
    //   39: dup
    //   40: invokespecial 308	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   43: aload_1
    //   44: invokevirtual 312	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   47: putfield 316	com/tencent/mm/protocal/protobuf/avy:GNs	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   50: aload 5
    //   52: aload_0
    //   53: getfield 80	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   56: putfield 319	com/tencent/mm/protocal/protobuf/avy:Scene	I
    //   59: aload 5
    //   61: aload_0
    //   62: getfield 86	com/tencent/mm/plugin/webview/e/c:lJm	Ljava/lang/String;
    //   65: putfield 322	com/tencent/mm/protocal/protobuf/avy:nIJ	Ljava/lang/String;
    //   68: aload 5
    //   70: iload_2
    //   71: putfield 325	com/tencent/mm/protocal/protobuf/avy:FSu	I
    //   74: aload 5
    //   76: aload_0
    //   77: getfield 82	com/tencent/mm/plugin/webview/e/c:wSY	I
    //   80: putfield 328	com/tencent/mm/protocal/protobuf/avy:FNv	I
    //   83: invokestatic 334	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   86: ldc_w 336
    //   89: invokevirtual 342	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   92: checkcast 344	android/net/ConnectivityManager
    //   95: astore_3
    //   96: aload_3
    //   97: ifnull +232 -> 329
    //   100: aload_3
    //   101: invokevirtual 348	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +223 -> 329
    //   109: aload_3
    //   110: invokevirtual 353	android/net/NetworkInfo:getType	()I
    //   113: iconst_1
    //   114: if_icmpne +197 -> 311
    //   117: ldc_w 355
    //   120: astore_3
    //   121: aload 5
    //   123: aload_3
    //   124: putfield 358	com/tencent/mm/protocal/protobuf/avy:oxI	Ljava/lang/String;
    //   127: aload 5
    //   129: aload_0
    //   130: getfield 117	com/tencent/mm/plugin/webview/e/c:EoG	I
    //   133: putfield 361	com/tencent/mm/protocal/protobuf/avy:GNx	I
    //   136: aload 5
    //   138: aload_0
    //   139: getfield 90	com/tencent/mm/plugin/webview/e/c:vPj	Ljava/lang/String;
    //   142: putfield 364	com/tencent/mm/protocal/protobuf/avy:GNy	Ljava/lang/String;
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 98	com/tencent/mm/plugin/webview/e/c:EoJ	I
    //   151: putfield 367	com/tencent/mm/protocal/protobuf/avy:GNz	I
    //   154: aload 5
    //   156: new 307	com/tencent/mm/protocal/protobuf/cxn
    //   159: dup
    //   160: invokespecial 308	com/tencent/mm/protocal/protobuf/cxn:<init>	()V
    //   163: aload_0
    //   164: getfield 88	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   167: invokevirtual 312	com/tencent/mm/protocal/protobuf/cxn:aQV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/cxn;
    //   170: putfield 370	com/tencent/mm/protocal/protobuf/avy:GNp	Lcom/tencent/mm/protocal/protobuf/cxn;
    //   173: aload 5
    //   175: new 372	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   178: dup
    //   179: invokespecial 373	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   182: aload_0
    //   183: getfield 92	com/tencent/mm/plugin/webview/e/c:vkz	[B
    //   186: invokevirtual 377	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:setBuffer	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   189: putfield 378	com/tencent/mm/protocal/protobuf/avy:GNA	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   192: ldc 127
    //   194: ldc_w 380
    //   197: bipush 11
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload_0
    //   209: getfield 86	com/tencent/mm/plugin/webview/e/c:lJm	Ljava/lang/String;
    //   212: aastore
    //   213: dup
    //   214: iconst_2
    //   215: aload_0
    //   216: getfield 80	com/tencent/mm/plugin/webview/e/c:mScene	I
    //   219: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_3
    //   225: iload_2
    //   226: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   229: aastore
    //   230: dup
    //   231: iconst_4
    //   232: aload_0
    //   233: getfield 82	com/tencent/mm/plugin/webview/e/c:wSY	I
    //   236: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: dup
    //   241: iconst_5
    //   242: aload 5
    //   244: getfield 358	com/tencent/mm/protocal/protobuf/avy:oxI	Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: bipush 6
    //   251: aload_0
    //   252: getfield 117	com/tencent/mm/plugin/webview/e/c:EoG	I
    //   255: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aastore
    //   259: dup
    //   260: bipush 7
    //   262: aload_0
    //   263: getfield 88	com/tencent/mm/plugin/webview/e/c:mAppId	Ljava/lang/String;
    //   266: aastore
    //   267: dup
    //   268: bipush 8
    //   270: aload_0
    //   271: getfield 90	com/tencent/mm/plugin/webview/e/c:vPj	Ljava/lang/String;
    //   274: aastore
    //   275: dup
    //   276: bipush 9
    //   278: aload_0
    //   279: getfield 98	com/tencent/mm/plugin/webview/e/c:EoJ	I
    //   282: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: bipush 10
    //   289: aload_0
    //   290: getfield 92	com/tencent/mm/plugin/webview/e/c:vkz	[B
    //   293: invokestatic 384	com/tencent/mm/sdk/platformtools/bu:cH	([B)Ljava/lang/String;
    //   296: aastore
    //   297: invokestatic 165	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc_w 284
    //   303: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: monitorexit
    //   308: aload 4
    //   310: areturn
    //   311: aload_3
    //   312: invokevirtual 387	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   315: ifnull +14 -> 329
    //   318: aload_3
    //   319: invokevirtual 387	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   322: invokevirtual 390	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   325: astore_3
    //   326: goto -205 -> 121
    //   329: ldc_w 392
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
    //   26	217	5	localavy	avy
    // Exception table:
    //   from	to	target	type
    //   2	96	336	finally
    //   100	105	336	finally
    //   109	117	336	finally
    //   121	306	336	finally
    //   311	326	336	finally
  }
  
  private void b(final String paramString, final int paramInt, final a<avz> parama)
  {
    try
    {
      AppMethodBeat.i(213796);
      a(paramString, paramInt, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
        {
          AppMethodBeat.i(213778);
          ae.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(c.c(c.this)) });
          c.d(c.this).remove(paramString);
          if ((paramAnonymousb.hQE.hQJ instanceof avz))
          {
            paramAnonymousb = (avz)paramAnonymousb.hQE.hQJ;
            c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, paramAnonymousb, parama);
            AppMethodBeat.o(213778);
            return;
          }
          c.a(c.this, paramString, paramInt, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, null, parama);
          ae.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
          AppMethodBeat.o(213778);
        }
      });
      AppMethodBeat.o(213796);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Map<String, String> he(List<bpk> paramList)
  {
    AppMethodBeat.i(213799);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(213799);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bpk localbpk = (bpk)paramList.next();
      localHashMap.put(localbpk.uuW, localbpk.yxn);
    }
    AppMethodBeat.o(213799);
    return localHashMap;
  }
  
  private static boolean iZ(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 4) && (paramInt2 == -2005);
  }
  
  public final void Ap(int paramInt)
  {
    this.EoG = paramInt;
  }
  
  public final void Xw(int paramInt)
  {
    this.EoJ = paramInt;
  }
  
  public final a a(String paramString, int paramInt, a<avz> parama)
  {
    try
    {
      AppMethodBeat.i(213793);
      paramString = a(paramString, false, paramInt, parama);
      AppMethodBeat.o(213793);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, a<avz> parama)
  {
    try
    {
      AppMethodBeat.i(213792);
      paramString = a(paramString, -1, parama);
      AppMethodBeat.o(213792);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final a a(String paramString, boolean paramBoolean, int paramInt, final a<avz> parama)
  {
    for (;;)
    {
      d locald;
      try
      {
        AppMethodBeat.i(213794);
        if ((!paramBoolean) && (aJB(paramString)))
        {
          paramString = a.EoV;
          AppMethodBeat.o(213794);
          return paramString;
        }
        if (paramBoolean) {
          break label146;
        }
        locald = this.EoM;
        if (!bu.isNullOrNil(paramString)) {
          break label86;
        }
        ae.e("MicroMsg.LuggageGetA8KeyPermission", "has fail, url is null");
      }
      finally {}
      if (i != 0)
      {
        paramString = a.EoU;
        AppMethodBeat.o(213794);
        continue;
        label86:
        Object localObject = d.aIw(paramString);
        localObject = (d.a)locald.EoY.get(localObject);
        if ((localObject != null) && (((d.a)localObject).DRw != locald.Epb) && (((d.a)localObject).Epd != locald.Epc))
        {
          i = 1;
          continue;
        }
      }
      else
      {
        label146:
        if ((paramInt == 5) && (this.EoI))
        {
          ae.w("MicroMsg.LuggageGetA8Key", "disable iframe request");
          paramString = a.EoU;
          AppMethodBeat.o(213794);
          continue;
        }
        if ((paramBoolean) && (this.EoF.contains(paramString)))
        {
          paramString = a.EoV;
          AppMethodBeat.o(213794);
          continue;
        }
        this.EoF.add(paramString);
        if (parama != null) {
          parama.bm(paramInt, paramString);
        }
        i = paramInt;
        if (paramInt == -1) {
          i = aJA(paramString);
        }
        paramBoolean = this.EoH;
        this.EoH = false;
        ae.i("MicroMsg.LuggageGetA8Key", "WebView-Trace startGetA8Key, url: %s", new Object[] { paramString });
        if ((paramBoolean) && (this.EoL != null) && (paramString.equals(this.EoL.GNB)))
        {
          ae.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result");
          h.MqF.aO(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(213776);
              ae.i("MicroMsg.LuggageGetA8Key", "WebView-Trace Use Outer GetA8key Result CallBack");
              c.a(c.this, c.a(c.this), i, 0, 0, "", c.b(c.this), parama);
              AppMethodBeat.o(213776);
            }
          });
          paramString = a.EoV;
          AppMethodBeat.o(213794);
          continue;
        }
        b(paramString, i, parama);
        paramString = a.EoV;
        AppMethodBeat.o(213794);
        continue;
      }
      final int i = 0;
    }
  }
  
  public final void a(String paramString, int paramInt, IPCRunCgi.a parama)
  {
    try
    {
      AppMethodBeat.i(213797);
      IPCRunCgi.a(ap(paramString, paramInt), EoP, parama);
      AppMethodBeat.o(213797);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int aJA(String paramString)
  {
    AppMethodBeat.i(213789);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
      AppMethodBeat.o(213789);
      return 0;
    }
    if (this.EoH)
    {
      AppMethodBeat.o(213789);
      return 0;
    }
    if (EoO.matcher(paramString).find())
    {
      AppMethodBeat.o(213789);
      return 2;
    }
    if (b.aJv(paramString))
    {
      AppMethodBeat.o(213789);
      return 8;
    }
    AppMethodBeat.o(213789);
    return 1;
  }
  
  public final boolean aJB(String paramString)
  {
    AppMethodBeat.i(213790);
    boolean bool = this.EoF.contains(paramString);
    AppMethodBeat.o(213790);
    return bool;
  }
  
  public final String aJe(String paramString)
  {
    AppMethodBeat.i(213787);
    synchronized (this.EoN)
    {
      ae.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", new Object[] { paramString });
      localObject1 = this.EoN.keySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ae.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", new Object[] { localObject2, this.EoN.get(localObject2) });
      }
    }
    Object localObject2 = (String)this.EoN.get(paramString);
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      localObject2 = this.EoN;
      if (!bu.isNullOrNil(paramString)) {
        break label175;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)((HashMap)localObject2).get(localObject1);
      paramString = bu.bI((String)localObject1, paramString);
      AppMethodBeat.o(213787);
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
  
  public final void aJw(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.vPj = str;
  }
  
  public final JsapiPermissionWrapper aJx(String paramString)
  {
    AppMethodBeat.i(213784);
    paramString = this.EoM.aJx(paramString);
    AppMethodBeat.o(213784);
    return paramString;
  }
  
  public final GeneralControlWrapper aJy(String paramString)
  {
    AppMethodBeat.i(213785);
    paramString = this.EoM.aJy(paramString);
    AppMethodBeat.o(213785);
    return paramString;
  }
  
  public final void ag(byte[] paramArrayOfByte)
  {
    this.vkz = paramArrayOfByte;
  }
  
  public final void destroy()
  {
    this.DYb = true;
  }
  
  public final boolean eSS()
  {
    AppMethodBeat.i(213791);
    if (this.EoF.size() > 0)
    {
      AppMethodBeat.o(213791);
      return true;
    }
    AppMethodBeat.o(213791);
    return false;
  }
  
  public final boolean fV(String paramString, int paramInt)
  {
    AppMethodBeat.i(213786);
    if (aJx(paramString).aah(paramInt) == 1)
    {
      AppMethodBeat.o(213786);
      return true;
    }
    AppMethodBeat.o(213786);
    return false;
  }
  
  public final void k(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(213783);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
    {
      AppMethodBeat.o(213783);
      return;
    }
    if ((paramArrayOfByte1.length <= 0) || (paramArrayOfByte2.length <= 0))
    {
      AppMethodBeat.o(213783);
      return;
    }
    avy localavy = new avy();
    avz localavz = new avz();
    try
    {
      localavy.parseFrom(paramArrayOfByte1);
      localavz.parseFrom(paramArrayOfByte2);
      this.EoK = localavy.GNs.HId;
      label80:
      if ((bu.isNullOrNil(this.EoK)) || (localavz.GNB == null))
      {
        ae.e("MicroMsg.LuggageGetA8Key", "ReqUrl or FullUrl is null");
        AppMethodBeat.o(213783);
        return;
      }
      this.EoL = localavz;
      AppMethodBeat.o(213783);
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
    this.wSY = paramInt;
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
    this.lJm = str;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(213781);
      EoT = new a("INTERCEPTED", 0);
      EoU = new a("NO_NEED", 1);
      EoV = new a("WILL_GET", 2);
      EoW = new a("FAILED", 3);
      EoX = new a[] { EoT, EoU, EoV, EoW };
      AppMethodBeat.o(213781);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.c
 * JD-Core Version:    0.7.0.1
 */