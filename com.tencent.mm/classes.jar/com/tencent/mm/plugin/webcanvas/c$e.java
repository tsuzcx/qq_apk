package com.tencent.mm.plugin.webcanvas;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$2$1", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineAPI;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "profilerPath", "", "dump", "", "tag", "data", "dumpToFile", "", "dumpFileName", "content", "getBasePkgVersion", "", "getInfo", "", "key", "measureText", "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "pixelRatio", "", "toast", "webview-sdk_release"})
public final class c$e
  extends com.tencent.mm.plugin.ac.g
{
  private final f DQe;
  private final String DQf;
  
  c$e(com.tencent.mm.plugin.appbrand.jsruntime.a parama, m paramm, c paramc, i parami)
  {
    super(parama, paramm);
    AppMethodBeat.i(213877);
    parama = new com.tencent.mm.plugin.ac.a(this.DQa.bPH(), "wxCanvas", "wxf337cbaa27790d8e", JsapiPermissionWrapper.FGb);
    int i = parama.hashCode();
    paramm = new f(null, null, i);
    paramc = parama.DRw;
    parami = new Bundle();
    parami.putString("name", parama.name);
    parami.putString("appId", parama.appId);
    paramm.a(paramc, parami);
    paramc = com.tencent.mm.plugin.webview.core.l.EaP;
    com.tencent.mm.plugin.webview.core.l.a(true, parama.DRv, (d)new a.b(paramm, i));
    this.DQe = paramm;
    this.DQf = (com.tencent.mm.loader.j.b.asj() + "jsengine/trace/");
    AppMethodBeat.o(213877);
  }
  
  private static void Sx(String paramString)
  {
    AppMethodBeat.i(213881);
    com.tencent.mm.ac.c.h((d.g.a.a)new q(paramString) {});
    AppMethodBeat.o(213881);
  }
  
  /* Error */
  private final boolean ed(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 181
    //   5: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 187	com/tencent/mm/compatible/util/e:abo	()Z
    //   11: ifne +22 -> 33
    //   14: aload_0
    //   15: getfield 55	com/tencent/mm/plugin/webcanvas/c$e:DQa	Lcom/tencent/mm/plugin/webcanvas/c;
    //   18: invokestatic 191	com/tencent/mm/plugin/webcanvas/c:b	(Lcom/tencent/mm/plugin/webcanvas/c;)Ljava/lang/String;
    //   21: ldc 193
    //   23: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc 181
    //   28: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aconst_null
    //   34: astore 7
    //   36: aconst_null
    //   37: astore 6
    //   39: aload 7
    //   41: astore 5
    //   43: new 200	com/tencent/mm/vfs/k
    //   46: dup
    //   47: aload_0
    //   48: getfield 159	com/tencent/mm/plugin/webcanvas/c$e:DQf	Ljava/lang/String;
    //   51: invokespecial 201	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: aload 7
    //   58: astore 5
    //   60: aload 8
    //   62: invokevirtual 204	com/tencent/mm/vfs/k:exists	()Z
    //   65: ifne +13 -> 78
    //   68: aload 7
    //   70: astore 5
    //   72: aload 8
    //   74: invokevirtual 207	com/tencent/mm/vfs/k:mkdirs	()Z
    //   77: pop
    //   78: aload 7
    //   80: astore 5
    //   82: new 209	com/tencent/mm/vfs/r
    //   85: dup
    //   86: new 200	com/tencent/mm/vfs/k
    //   89: dup
    //   90: aload 8
    //   92: aload_1
    //   93: invokespecial 212	com/tencent/mm/vfs/k:<init>	(Lcom/tencent/mm/vfs/k;Ljava/lang/String;)V
    //   96: iconst_0
    //   97: invokespecial 215	com/tencent/mm/vfs/r:<init>	(Lcom/tencent/mm/vfs/k;Z)V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_2
    //   103: invokevirtual 218	com/tencent/mm/vfs/r:write	(Ljava/lang/String;)V
    //   106: iconst_1
    //   107: istore_3
    //   108: aload_1
    //   109: invokevirtual 221	com/tencent/mm/vfs/r:close	()V
    //   112: ldc 181
    //   114: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iload_3
    //   118: ireturn
    //   119: astore_1
    //   120: aload_0
    //   121: getfield 55	com/tencent/mm/plugin/webcanvas/c$e:DQa	Lcom/tencent/mm/plugin/webcanvas/c;
    //   124: invokestatic 191	com/tencent/mm/plugin/webcanvas/c:b	(Lcom/tencent/mm/plugin/webcanvas/c;)Ljava/lang/String;
    //   127: ldc 223
    //   129: aload_1
    //   130: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -27 -> 112
    //   142: astore_2
    //   143: aload 6
    //   145: astore_1
    //   146: aload_1
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 55	com/tencent/mm/plugin/webcanvas/c$e:DQa	Lcom/tencent/mm/plugin/webcanvas/c;
    //   153: invokestatic 191	com/tencent/mm/plugin/webcanvas/c:b	(Lcom/tencent/mm/plugin/webcanvas/c;)Ljava/lang/String;
    //   156: ldc 235
    //   158: aload_2
    //   159: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: iload 4
    //   170: istore_3
    //   171: aload_1
    //   172: ifnull -60 -> 112
    //   175: aload_1
    //   176: invokevirtual 221	com/tencent/mm/vfs/r:close	()V
    //   179: iload 4
    //   181: istore_3
    //   182: goto -70 -> 112
    //   185: astore_1
    //   186: aload_0
    //   187: getfield 55	com/tencent/mm/plugin/webcanvas/c$e:DQa	Lcom/tencent/mm/plugin/webcanvas/c;
    //   190: invokestatic 191	com/tencent/mm/plugin/webcanvas/c:b	(Lcom/tencent/mm/plugin/webcanvas/c;)Ljava/lang/String;
    //   193: ldc 223
    //   195: aload_1
    //   196: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: iload 4
    //   207: istore_3
    //   208: goto -96 -> 112
    //   211: astore_1
    //   212: aload 5
    //   214: ifnull +8 -> 222
    //   217: aload 5
    //   219: invokevirtual 221	com/tencent/mm/vfs/r:close	()V
    //   222: ldc 181
    //   224: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: aload_0
    //   231: getfield 55	com/tencent/mm/plugin/webcanvas/c$e:DQa	Lcom/tencent/mm/plugin/webcanvas/c;
    //   234: invokestatic 191	com/tencent/mm/plugin/webcanvas/c:b	(Lcom/tencent/mm/plugin/webcanvas/c;)Ljava/lang/String;
    //   237: ldc 223
    //   239: aload_2
    //   240: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   243: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokestatic 198	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -27 -> 222
    //   252: astore_2
    //   253: aload_1
    //   254: astore 5
    //   256: aload_2
    //   257: astore_1
    //   258: goto -46 -> 212
    //   261: astore_2
    //   262: goto -116 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	e
    //   0	265	1	paramString1	String
    //   0	265	2	paramString2	String
    //   107	101	3	bool1	boolean
    //   1	205	4	bool2	boolean
    //   41	214	5	localObject1	Object
    //   37	107	6	localObject2	Object
    //   34	45	7	localObject3	Object
    //   54	37	8	localk	com.tencent.mm.vfs.k
    // Exception table:
    //   from	to	target	type
    //   108	112	119	java/lang/Exception
    //   43	56	142	java/lang/Exception
    //   60	68	142	java/lang/Exception
    //   72	78	142	java/lang/Exception
    //   82	101	142	java/lang/Exception
    //   175	179	185	java/lang/Exception
    //   43	56	211	finally
    //   60	68	211	finally
    //   72	78	211	finally
    //   82	101	211	finally
    //   149	168	211	finally
    //   217	222	229	java/lang/Exception
    //   101	106	252	finally
    //   101	106	261	java/lang/Exception
  }
  
  @JavascriptInterface
  public final void dump(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213882);
    p.h(paramString1, "tag");
    p.h(paramString2, "data");
    if (!bv.fpT())
    {
      ae.w(c.b(this.DQa), "try to dump data without debugger");
      AppMethodBeat.o(213882);
      return;
    }
    paramString1 = "CPU_" + this.DQa.getAppId() + '_' + paramString1 + '_' + System.currentTimeMillis() + ".cpuprofile";
    if (ed(paramString1, paramString2))
    {
      paramString1 = this.DQf + paramString1;
      Sx(paramString1 + " exported.");
      ae.i(c.b(this.DQa), paramString1 + " exported.");
      AppMethodBeat.o(213882);
      return;
    }
    Sx(paramString1 + " export failed!");
    ae.e(c.b(this.DQa), paramString1 + " export failed!");
    AppMethodBeat.o(213882);
  }
  
  public final f eOO()
  {
    return this.DQe;
  }
  
  @JavascriptInterface
  public final int getBasePkgVersion()
  {
    AppMethodBeat.i(213880);
    try
    {
      i = c.a(this.DQa.eOF());
      AppMethodBeat.o(213880);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e(c.b(this.DQa), "getBasePkgVersion ex " + localException.getMessage());
        int i = 0;
      }
    }
  }
  
  @JavascriptInterface
  public final Object getInfo(String paramString)
  {
    AppMethodBeat.i(213883);
    p.h(paramString, "key");
    switch (paramString.hashCode())
    {
    }
    do
    {
      AppMethodBeat.o(213883);
      return null;
    } while (!paramString.equals("sessionId"));
    paramString = (com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
    if (paramString != null)
    {
      int i = paramString.bOi();
      AppMethodBeat.o(213883);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(213883);
    return Integer.valueOf(0);
  }
  
  @JavascriptInterface
  public final Number measureText(String paramString1, String paramString2, String paramString3, Number paramNumber, String paramString4)
  {
    AppMethodBeat.i(213878);
    p.h(paramString1, "text");
    p.h(paramString2, "fontWeight");
    p.h(paramString3, "fontStyle");
    p.h(paramNumber, "fontSize");
    p.h(paramString4, "fontFamily");
    i locali = this.DQg;
    if (j.DEBUG) {
      ae.d(c.b(this.DQa), "measureText text=" + paramString1 + " fontWeight=" + paramString2 + ", fontStyle=" + paramString3 + ", fontSize=" + paramNumber + ", fontFamily=" + paramString4);
    }
    float f = paramNumber.floatValue();
    paramNumber = paramString3.toLowerCase();
    p.g(paramNumber, "(this as java.lang.String).toLowerCase()");
    boolean bool = p.i(paramNumber, "italic");
    paramString3 = paramString3.toLowerCase();
    p.g(paramString3, "(this as java.lang.String).toLowerCase()");
    locali.useFont(paramString4, paramString2, f, bool, p.i(paramString3, "bold"));
    paramString1 = (Number)Float.valueOf(locali.measureText(paramString1));
    AppMethodBeat.o(213878);
    return paramString1;
  }
  
  @JavascriptInterface
  public final float pixelRatio()
  {
    AppMethodBeat.i(213879);
    float f = com.tencent.mm.plugin.appbrand.y.g.bCg();
    AppMethodBeat.o(213879);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.e
 * JD-Core Version:    0.7.0.1
 */