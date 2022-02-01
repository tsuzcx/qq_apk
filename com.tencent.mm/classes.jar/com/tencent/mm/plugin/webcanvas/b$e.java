package com.tencent.mm.plugin.webcanvas;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.ac.a.b;
import com.tencent.mm.plugin.ac.e;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.core.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$1$1", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineAPI;", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "profilerPath", "", "dump", "", "tag", "data", "dumpToFile", "", "dumpFileName", "content", "getBasePkgVersion", "", "measureText", "", "text", "fontWeight", "fontStyle", "fontSize", "fontFamily", "pixelRatio", "", "toast", "webview-sdk_release"})
public final class b$e
  extends e
{
  private final f Dyx;
  private final String OdV;
  
  b$e(com.tencent.mm.plugin.appbrand.jsruntime.a parama, m paramm, b paramb, com.tencent.magicbrush.handler.glfont.i parami)
  {
    super(parama, paramm);
    AppMethodBeat.i(214041);
    parama = new com.tencent.mm.plugin.ac.a(this.Dyt.bOJ(), "wxCanvas", JsapiPermissionWrapper.FnD);
    int i = parama.hashCode();
    paramm = new f(null, null, i);
    paramb = parama.DzO;
    parami = new Bundle();
    parami.putString("name", parama.name);
    paramm.a(paramb, parami);
    paramb = com.tencent.mm.plugin.webview.core.l.DIR;
    com.tencent.mm.plugin.webview.core.l.a(true, parama.DzN, (d)new a.b(paramm, i));
    this.Dyx = paramm;
    this.OdV = (com.tencent.mm.loader.j.b.arU() + "jsengine/trace/");
    AppMethodBeat.o(214041);
  }
  
  private static void RO(String paramString)
  {
    AppMethodBeat.i(221749);
    c.g((d.g.a.a)new b.e.1(paramString));
    AppMethodBeat.o(221749);
  }
  
  /* Error */
  private final boolean eb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 173
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 179	com/tencent/mm/compatible/util/e:abf	()Z
    //   11: ifne +22 -> 33
    //   14: aload_0
    //   15: getfield 51	com/tencent/mm/plugin/webcanvas/b$e:Dyt	Lcom/tencent/mm/plugin/webcanvas/b;
    //   18: invokestatic 183	com/tencent/mm/plugin/webcanvas/b:b	(Lcom/tencent/mm/plugin/webcanvas/b;)Ljava/lang/String;
    //   21: ldc 185
    //   23: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc 173
    //   28: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aconst_null
    //   34: astore 7
    //   36: aconst_null
    //   37: astore 6
    //   39: aload 7
    //   41: astore 5
    //   43: new 192	com/tencent/mm/vfs/e
    //   46: dup
    //   47: aload_0
    //   48: getfield 149	com/tencent/mm/plugin/webcanvas/b$e:OdV	Ljava/lang/String;
    //   51: invokespecial 193	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   54: astore 8
    //   56: aload 7
    //   58: astore 5
    //   60: aload 8
    //   62: invokevirtual 196	com/tencent/mm/vfs/e:exists	()Z
    //   65: ifne +13 -> 78
    //   68: aload 7
    //   70: astore 5
    //   72: aload 8
    //   74: invokevirtual 199	com/tencent/mm/vfs/e:mkdirs	()Z
    //   77: pop
    //   78: aload 7
    //   80: astore 5
    //   82: new 201	com/tencent/mm/vfs/l
    //   85: dup
    //   86: new 192	com/tencent/mm/vfs/e
    //   89: dup
    //   90: aload 8
    //   92: aload_1
    //   93: invokespecial 204	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   96: iconst_0
    //   97: invokespecial 207	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;Z)V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_2
    //   103: invokevirtual 210	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   106: iconst_1
    //   107: istore_3
    //   108: aload_1
    //   109: invokevirtual 213	com/tencent/mm/vfs/l:close	()V
    //   112: ldc 173
    //   114: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iload_3
    //   118: ireturn
    //   119: astore_1
    //   120: aload_0
    //   121: getfield 51	com/tencent/mm/plugin/webcanvas/b$e:Dyt	Lcom/tencent/mm/plugin/webcanvas/b;
    //   124: invokestatic 183	com/tencent/mm/plugin/webcanvas/b:b	(Lcom/tencent/mm/plugin/webcanvas/b;)Ljava/lang/String;
    //   127: ldc 215
    //   129: aload_1
    //   130: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: goto -27 -> 112
    //   142: astore_2
    //   143: aload 6
    //   145: astore_1
    //   146: aload_1
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 51	com/tencent/mm/plugin/webcanvas/b$e:Dyt	Lcom/tencent/mm/plugin/webcanvas/b;
    //   153: invokestatic 183	com/tencent/mm/plugin/webcanvas/b:b	(Lcom/tencent/mm/plugin/webcanvas/b;)Ljava/lang/String;
    //   156: ldc 227
    //   158: aload_2
    //   159: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: iload 4
    //   170: istore_3
    //   171: aload_1
    //   172: ifnull -60 -> 112
    //   175: aload_1
    //   176: invokevirtual 213	com/tencent/mm/vfs/l:close	()V
    //   179: iload 4
    //   181: istore_3
    //   182: goto -70 -> 112
    //   185: astore_1
    //   186: aload_0
    //   187: getfield 51	com/tencent/mm/plugin/webcanvas/b$e:Dyt	Lcom/tencent/mm/plugin/webcanvas/b;
    //   190: invokestatic 183	com/tencent/mm/plugin/webcanvas/b:b	(Lcom/tencent/mm/plugin/webcanvas/b;)Ljava/lang/String;
    //   193: ldc 215
    //   195: aload_1
    //   196: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   202: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: iload 4
    //   207: istore_3
    //   208: goto -96 -> 112
    //   211: astore_1
    //   212: aload 5
    //   214: ifnull +8 -> 222
    //   217: aload 5
    //   219: invokevirtual 213	com/tencent/mm/vfs/l:close	()V
    //   222: ldc 173
    //   224: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_1
    //   228: athrow
    //   229: astore_2
    //   230: aload_0
    //   231: getfield 51	com/tencent/mm/plugin/webcanvas/b$e:Dyt	Lcom/tencent/mm/plugin/webcanvas/b;
    //   234: invokestatic 183	com/tencent/mm/plugin/webcanvas/b:b	(Lcom/tencent/mm/plugin/webcanvas/b;)Ljava/lang/String;
    //   237: ldc 215
    //   239: aload_2
    //   240: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   243: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   41	214	5	localObject1	java.lang.Object
    //   37	107	6	localObject2	java.lang.Object
    //   34	45	7	localObject3	java.lang.Object
    //   54	37	8	locale	com.tencent.mm.vfs.e
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
    AppMethodBeat.i(221750);
    p.h(paramString1, "tag");
    p.h(paramString2, "data");
    if (!bu.flY())
    {
      ad.w(b.b(this.Dyt), "try to dump data without debugger");
      AppMethodBeat.o(221750);
      return;
    }
    paramString1 = "CPU_" + this.Dyt.getAppId() + '_' + paramString1 + '_' + System.currentTimeMillis() + ".cpuprofile";
    if (eb(paramString1, paramString2))
    {
      paramString1 = this.OdV + paramString1;
      RO(paramString1 + " exported.");
      ad.i(b.b(this.Dyt), paramString1 + " exported.");
      AppMethodBeat.o(221750);
      return;
    }
    RO(paramString1 + " export failed!");
    ad.e(b.b(this.Dyt), paramString1 + " export failed!");
    AppMethodBeat.o(221750);
  }
  
  public final f eLg()
  {
    return this.Dyx;
  }
  
  @JavascriptInterface
  public final int getBasePkgVersion()
  {
    AppMethodBeat.i(214044);
    try
    {
      i = b.a(this.Dyt.eKX());
      AppMethodBeat.o(214044);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(b.b(this.Dyt), "getBasePkgVersion ex " + localException.getMessage());
        int i = 0;
      }
    }
  }
  
  @JavascriptInterface
  public final Number measureText(String paramString1, String paramString2, String paramString3, Number paramNumber, String paramString4)
  {
    AppMethodBeat.i(214042);
    p.h(paramString1, "text");
    p.h(paramString2, "fontWeight");
    p.h(paramString3, "fontStyle");
    p.h(paramNumber, "fontSize");
    p.h(paramString4, "fontFamily");
    com.tencent.magicbrush.handler.glfont.i locali = this.Dyy;
    if (com.tencent.mm.sdk.platformtools.i.DEBUG) {
      ad.d(b.b(this.Dyt), "measureText text=" + paramString1 + " fontWeight=" + paramString2 + ", fontStyle=" + paramString3 + ", fontSize=" + paramNumber + ", fontFamily=" + paramString4);
    }
    float f = paramNumber.floatValue();
    paramNumber = paramString3.toLowerCase();
    p.g(paramNumber, "(this as java.lang.String).toLowerCase()");
    boolean bool = p.i(paramNumber, "italic");
    paramString3 = paramString3.toLowerCase();
    p.g(paramString3, "(this as java.lang.String).toLowerCase()");
    locali.useFont(paramString4, paramString2, f, bool, p.i(paramString3, "bold"));
    paramString1 = (Number)Float.valueOf(locali.measureText(paramString1));
    AppMethodBeat.o(214042);
    return paramString1;
  }
  
  @JavascriptInterface
  public final float pixelRatio()
  {
    AppMethodBeat.i(214043);
    float f = g.bBm();
    AppMethodBeat.o(214043);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.e
 * JD-Core Version:    0.7.0.1
 */