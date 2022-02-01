package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.c;
import com.tencent.mm.plugin.websearch.webview.g;
import com.tencent.mm.plugin.webview.fts.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchJSApi;", "Lcom/tencent/mm/plugin/websearch/webview/MultiProcessWebSearchJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;", "(Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;)V", "FUNC_DEVICE_MOTION_FIRED_CALLBACK", "", "getFUNC_DEVICE_MOTION_FIRED_CALLBACK", "()Ljava/lang/String;", "deviceMotionMonitor", "params", "setPreGetParams", "", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  public static final a.a Xfj;
  private final String Xfk;
  
  static
  {
    AppMethodBeat.i(296997);
    Xfj = new a.a((byte)0);
    AppMethodBeat.o(296997);
  }
  
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(296977);
    this.Xfk = "onDeviceMotionFired";
    AppMethodBeat.o(296977);
  }
  
  private static final void a(WebSearchWebView paramWebSearchWebView, String paramString, a parama)
  {
    AppMethodBeat.i(296986);
    s.u(paramWebSearchWebView, "$it");
    s.u(parama, "this$0");
    try
    {
      Log.i("MicroMsg.WebSearch.WebSearchJSApi", s.X("startCheck , Runnable = ", paramWebSearchWebView.getRandomStr()));
      paramWebSearchWebView.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + paramString + ')', null);
      AppMethodBeat.o(296986);
      return;
    }
    catch (Exception paramWebSearchWebView)
    {
      Log.e("MicroMsg.WebSearch.WebSearchJSApi", "onSendEventToJSBridge fail, event=%s, ex=%s", new Object[] { parama.Xfk, paramWebSearchWebView.getMessage() });
      AppMethodBeat.o(296986);
    }
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(296995);
    s.u(parama, "this$0");
    Object localObject = parama.WrO;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((c)localObject).getWebView())
    {
      Log.i("MicroMsg.WebSearch.WebSearchJSApi", s.X("startCheck , deviceMotionMonitor onshake. uiWebView = ", localObject));
      localObject = parama.WrO;
      if (localObject == null) {
        break label108;
      }
      localObject = ((c)localObject).getWebView();
      if (localObject == null) {
        break label108;
      }
      parama = new a..ExternalSyntheticLambda1((WebSearchWebView)localObject, p.a.b(parama.Xfk, null, false, ((WebSearchWebView)localObject).getRandomStr()), parama);
      if (!MMHandlerThread.isMainThread()) {
        break;
      }
      parama.run();
      AppMethodBeat.o(296995);
      return;
    }
    MMHandlerThread.postToMainThread(parama);
    label108:
    AppMethodBeat.o(296995);
  }
  
  private static final void bmf(String paramString)
  {
    AppMethodBeat.i(296981);
    j.setPreGetParams(paramString);
    AppMethodBeat.o(296981);
  }
  
  /* Error */
  @JavascriptInterface
  public final String deviceMotionMonitor(String paramString)
  {
    // Byte code:
    //   0: ldc 187
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +232 -> 238
    //   9: new 189	org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +92 -> 111
    //   22: aconst_null
    //   23: astore_1
    //   24: ldc 94
    //   26: ldc 192
    //   28: aload_1
    //   29: invokestatic 105	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc 194
    //   37: aload_1
    //   38: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +143 -> 184
    //   44: invokestatic 206	com/tencent/mm/plugin/websearch/webview/p:iqU	()Lcom/tencent/mm/plugin/websearch/webview/p;
    //   47: astore_1
    //   48: new 208	com/tencent/mm/plugin/webview/ui/tools/fts/preload/a$$ExternalSyntheticLambda0
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 210	com/tencent/mm/plugin/webview/ui/tools/fts/preload/a$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/a;)V
    //   56: astore_2
    //   57: aload_1
    //   58: getfield 214	com/tencent/mm/plugin/websearch/webview/p:Wse	Z
    //   61: ifeq +62 -> 123
    //   64: aload_1
    //   65: getfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   68: ifnull +55 -> 123
    //   71: ldc 220
    //   73: ldc 222
    //   75: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: invokestatic 226	com/tencent/mm/plugin/webview/ui/tools/fts/preload/a:iqR	()Lorg/json/JSONObject;
    //   81: invokevirtual 227	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: astore_1
    //   85: ldc 187
    //   87: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: ldc 94
    //   95: ldc 229
    //   97: iconst_1
    //   98: anewarray 134	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto +130 -> 238
    //   111: aload_1
    //   112: ldc 231
    //   114: ldc 232
    //   116: invokevirtual 236	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_1
    //   120: goto -96 -> 24
    //   123: aload_1
    //   124: iconst_1
    //   125: putfield 214	com/tencent/mm/plugin/websearch/webview/p:Wse	Z
    //   128: invokestatic 242	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   131: pop
    //   132: aload_1
    //   133: new 244	com/tencent/mm/pluginsdk/l/d
    //   136: dup
    //   137: invokespecial 246	com/tencent/mm/pluginsdk/l/d:<init>	()V
    //   140: putfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   143: aload_1
    //   144: getfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   147: new 248	com/tencent/mm/plugin/websearch/webview/p$1
    //   150: dup
    //   151: aload_1
    //   152: aload_2
    //   153: invokespecial 251	com/tencent/mm/plugin/websearch/webview/p$1:<init>	(Lcom/tencent/mm/plugin/websearch/webview/p;Lcom/tencent/mm/plugin/websearch/webview/p$a;)V
    //   156: invokevirtual 254	com/tencent/mm/pluginsdk/l/d:a	(Lcom/tencent/mm/pluginsdk/l/d$a;)V
    //   159: aload_1
    //   160: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   163: putfield 264	com/tencent/mm/plugin/websearch/webview/p:lastShakeTime	J
    //   166: goto -88 -> 78
    //   169: astore_1
    //   170: invokestatic 267	com/tencent/mm/plugin/webview/ui/tools/fts/preload/a:fqu	()Lorg/json/JSONObject;
    //   173: invokevirtual 227	org/json/JSONObject:toString	()Ljava/lang/String;
    //   176: astore_1
    //   177: ldc 187
    //   179: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: areturn
    //   184: ldc_w 269
    //   187: aload_1
    //   188: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq -113 -> 78
    //   194: invokestatic 206	com/tencent/mm/plugin/websearch/webview/p:iqU	()Lcom/tencent/mm/plugin/websearch/webview/p;
    //   197: astore_1
    //   198: ldc 220
    //   200: ldc_w 271
    //   203: invokestatic 110	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_1
    //   207: getfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   210: ifnull +15 -> 225
    //   213: aload_1
    //   214: getfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   217: invokevirtual 274	com/tencent/mm/pluginsdk/l/d:cuD	()V
    //   220: aload_1
    //   221: aconst_null
    //   222: putfield 218	com/tencent/mm/plugin/websearch/webview/p:shakeSensor	Lcom/tencent/mm/pluginsdk/l/d;
    //   225: aload_1
    //   226: iconst_0
    //   227: putfield 214	com/tencent/mm/plugin/websearch/webview/p:Wse	Z
    //   230: aload_1
    //   231: iconst_0
    //   232: putfield 277	com/tencent/mm/plugin/websearch/webview/p:isStartShake	Z
    //   235: goto -157 -> 78
    //   238: aconst_null
    //   239: astore_1
    //   240: goto -222 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	a
    //   0	243	1	paramString	String
    //   56	97	2	localExternalSyntheticLambda0	a..ExternalSyntheticLambda0
    // Exception table:
    //   from	to	target	type
    //   9	18	92	finally
    //   24	78	169	java/lang/Exception
    //   78	90	169	java/lang/Exception
    //   93	108	169	java/lang/Exception
    //   111	120	169	java/lang/Exception
    //   123	166	169	java/lang/Exception
    //   184	225	169	java/lang/Exception
    //   225	235	169	java/lang/Exception
  }
  
  @JavascriptInterface
  public final void setPreGetParams(String paramString)
  {
    AppMethodBeat.i(297015);
    h.ahAA.g(new a..ExternalSyntheticLambda2(paramString), "MicroMsg.WebSearch.WebSearchJSApi");
    AppMethodBeat.o(297015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.a
 * JD-Core Version:    0.7.0.1
 */