package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.content.Context;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

public final class c
  extends g
{
  private boolean bKQ;
  private String data;
  private String kpt;
  private boolean rBg = false;
  private long rBh;
  private long rBi;
  private boolean rBj = false;
  private String rBk;
  private c.a rBl;
  boolean rBm = false;
  private int state = 1;
  
  public c(Context paramContext, TmplParams paramTmplParams)
  {
    super(paramContext, paramTmplParams);
  }
  
  private void Dc(int paramInt)
  {
    y.i("MicroMsg.Preload.WebView", "transferToState() state:%d, newState:%d", new Object[] { Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    if (this.rBl != null) {
      this.rBl.Dd(paramInt);
    }
  }
  
  /* Error */
  protected final void anb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 81	com/tencent/mm/plugin/webview/ui/tools/preload/g:anb	()V
    //   6: aload_0
    //   7: getfield 28	com/tencent/mm/plugin/webview/ui/tools/preload/c:state	I
    //   10: iconst_1
    //   11: if_icmpeq +27 -> 38
    //   14: ldc 39
    //   16: ldc 83
    //   18: iconst_1
    //   19: anewarray 43	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_0
    //   25: getfield 28	com/tencent/mm/plugin/webview/ui/tools/preload/c:state	I
    //   28: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: invokestatic 86	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield 90	com/tencent/mm/plugin/webview/ui/tools/preload/c:riT	Lcom/tencent/mm/plugin/webview/preload/TmplParams;
    //   42: getfield 95	com/tencent/mm/plugin/webview/preload/TmplParams:rjC	I
    //   45: bipush 113
    //   47: iconst_1
    //   48: invokestatic 101	com/tencent/mm/plugin/webview/preload/a:aa	(III)V
    //   51: aload_0
    //   52: ldc 103
    //   54: new 105	com/tencent/mm/plugin/webview/ui/tools/preload/c$1
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 108	com/tencent/mm/plugin/webview/ui/tools/preload/c$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/preload/c;)V
    //   62: invokevirtual 112	com/tencent/mm/plugin/webview/ui/tools/preload/c:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   65: aload_0
    //   66: invokevirtual 116	com/tencent/mm/plugin/webview/ui/tools/preload/c:getContext	()Landroid/content/Context;
    //   69: invokestatic 122	com/tencent/mm/cb/a:fj	(Landroid/content/Context;)I
    //   72: istore_2
    //   73: aload_0
    //   74: invokevirtual 116	com/tencent/mm/plugin/webview/ui/tools/preload/c:getContext	()Landroid/content/Context;
    //   77: invokestatic 126	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   80: fstore_1
    //   81: ldc 39
    //   83: ldc 128
    //   85: iconst_2
    //   86: anewarray 43	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: iload_2
    //   92: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: fload_1
    //   99: invokestatic 133	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   102: aastore
    //   103: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: iload_2
    //   107: ifle +54 -> 161
    //   110: fload_1
    //   111: fconst_0
    //   112: fcmpl
    //   113: ifle +48 -> 161
    //   116: iload_2
    //   117: i2f
    //   118: fload_1
    //   119: fdiv
    //   120: f2i
    //   121: istore_2
    //   122: ldc 39
    //   124: ldc 135
    //   126: iconst_1
    //   127: anewarray 43	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: iload_2
    //   133: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_0
    //   141: new 137	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 139
    //   147: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: iload_2
    //   151: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aconst_null
    //   158: invokevirtual 112	com/tencent/mm/plugin/webview/ui/tools/preload/c:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   161: ldc 39
    //   163: ldc 152
    //   165: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -133 -> 35
    //   171: astore_3
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_3
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	c
    //   80	39	1	f	float
    //   72	79	2	i	int
    //   171	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	171	finally
    //   38	106	171	finally
    //   116	161	171	finally
    //   161	168	171	finally
  }
  
  public final void cgI()
  {
    y.i("MicroMsg.Preload.WebView", "[loadUrlAndData]");
    super.cgI();
    a.aa(this.riT.rjC, 112, 1);
  }
  
  public final void cgJ()
  {
    y.i("MicroMsg.Preload.WebView", "[initJsEnvironment]");
    super.cgJ();
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public final String getUrl()
  {
    if (this.state == 4) {
      return this.rBk;
    }
    return super.getUrl();
  }
  
  public final void o(boolean paramBoolean, String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.state != 3)
        {
          y.w("MicroMsg.Preload.WebView", "[updateAuth]delay update auth, return, state:%d", new Object[] { Integer.valueOf(this.state) });
          this.rBj = true;
          this.bKQ = paramBoolean;
          this.kpt = paramString;
          return;
        }
        this.rBk = paramString;
        Dc(4);
        if (paramBoolean)
        {
          y.i("MicroMsg.Preload.WebView", "[updateAuth]ok fullUrl:%s", new Object[] { paramString });
          HashMap localHashMap = new HashMap();
          localHashMap.put("fullUrl", paramString);
          paramString = i.a.U(localHashMap).toString();
          evaluateJavascript("javascript:window.onPageAuthOK(" + paramString + ")", new c.3(this));
          a.aa(this.riT.rjC, 133, 1);
          continue;
        }
        y.i("MicroMsg.Preload.WebView", "[updateAuth]fail");
      }
      finally {}
      evaluateJavascript("javascript:window.onPageAuthFail()", new c.4(this));
      a.aa(this.riT.rjC, 134, 1);
    }
  }
  
  public final void setOnStateChange(c.a parama)
  {
    this.rBl = parama;
  }
  
  /* Error */
  public final void w(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/mm/plugin/webview/ui/tools/preload/c:state	I
    //   6: iconst_2
    //   7: if_icmpeq +48 -> 55
    //   10: ldc 39
    //   12: ldc 225
    //   14: iconst_1
    //   15: anewarray 43	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 28	com/tencent/mm/plugin/webview/ui/tools/preload/c:state	I
    //   24: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: invokestatic 86	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 30	com/tencent/mm/plugin/webview/ui/tools/preload/c:rBg	Z
    //   36: aload_0
    //   37: aload_1
    //   38: putfield 70	com/tencent/mm/plugin/webview/ui/tools/preload/c:data	Ljava/lang/String;
    //   41: aload_0
    //   42: lload_2
    //   43: putfield 74	com/tencent/mm/plugin/webview/ui/tools/preload/c:rBh	J
    //   46: aload_0
    //   47: lload 4
    //   49: putfield 77	com/tencent/mm/plugin/webview/ui/tools/preload/c:rBi	J
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_3
    //   57: invokespecial 64	com/tencent/mm/plugin/webview/ui/tools/preload/c:Dc	(I)V
    //   60: ldc 39
    //   62: ldc 227
    //   64: iconst_3
    //   65: anewarray 43	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: invokevirtual 232	java/lang/String:length	()I
    //   74: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_2
    //   81: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: lload 4
    //   89: invokestatic 237	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: ldc 39
    //   98: ldc 239
    //   100: iconst_1
    //   101: anewarray 43	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: aastore
    //   108: invokestatic 242	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: new 184	java/util/HashMap
    //   114: dup
    //   115: invokespecial 186	java/util/HashMap:<init>	()V
    //   118: astore 6
    //   120: new 200	org/json/JSONObject
    //   123: dup
    //   124: invokespecial 243	org/json/JSONObject:<init>	()V
    //   127: astore 7
    //   129: aload 7
    //   131: ldc 245
    //   133: lload_2
    //   134: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload 7
    //   140: ldc 250
    //   142: lload 4
    //   144: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 6
    //   150: ldc 252
    //   152: aload 7
    //   154: invokeinterface 255 3 0
    //   159: pop
    //   160: aload 6
    //   162: ldc_w 256
    //   165: aload_1
    //   166: invokeinterface 255 3 0
    //   171: pop
    //   172: aload 6
    //   174: invokestatic 198	com/tencent/mm/plugin/webview/ui/tools/jsapi/i$a:U	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   177: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: aload_0
    //   182: new 137	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 258
    //   189: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 208
    //   198: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: new 260	com/tencent/mm/plugin/webview/ui/tools/preload/c$2
    //   207: dup
    //   208: aload_0
    //   209: invokespecial 261	com/tencent/mm/plugin/webview/ui/tools/preload/c$2:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/preload/c;)V
    //   212: invokevirtual 112	com/tencent/mm/plugin/webview/ui/tools/preload/c:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    //   215: aload_0
    //   216: getfield 32	com/tencent/mm/plugin/webview/ui/tools/preload/c:rBj	Z
    //   219: ifeq -167 -> 52
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 178	com/tencent/mm/plugin/webview/ui/tools/preload/c:bKQ	Z
    //   227: aload_0
    //   228: getfield 180	com/tencent/mm/plugin/webview/ui/tools/preload/c:kpt	Ljava/lang/String;
    //   231: invokevirtual 263	com/tencent/mm/plugin/webview/ui/tools/preload/c:o	(ZLjava/lang/String;)V
    //   234: goto -182 -> 52
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: astore 8
    //   244: ldc 39
    //   246: ldc_w 265
    //   249: iconst_1
    //   250: anewarray 43	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 8
    //   257: aastore
    //   258: invokestatic 268	com/tencent/mm/sdk/platformtools/y:l	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: goto -113 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	c
    //   0	264	1	paramString	String
    //   0	264	2	paramLong1	long
    //   0	264	4	paramLong2	long
    //   118	55	6	localHashMap	HashMap
    //   127	26	7	localJSONObject	JSONObject
    //   242	14	8	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   2	52	237	finally
    //   55	129	237	finally
    //   129	148	237	finally
    //   148	234	237	finally
    //   244	261	237	finally
    //   129	148	242	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.c
 * JD-Core Version:    0.7.0.1
 */