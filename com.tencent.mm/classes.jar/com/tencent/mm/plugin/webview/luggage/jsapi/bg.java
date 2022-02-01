package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public class bg
  extends bo<f>
{
  public final void a(final Context paramContext, final String paramString, final bn.a parama)
  {
    AppMethodBeat.i(187883);
    p.y(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 45
        //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 53	org/json/JSONObject
        //   8: dup
        //   9: aload_0
        //   10: getfield 31	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1:jvL	Ljava/lang/String;
        //   13: invokespecial 56	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   16: astore_3
        //   17: aload_3
        //   18: ldc 58
        //   20: invokevirtual 62	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   23: astore 4
        //   25: ldc 64
        //   27: astore_2
        //   28: aload_2
        //   29: astore_1
        //   30: aload 4
        //   32: ifnull +14 -> 46
        //   35: aload 4
        //   37: invokevirtual 68	org/json/JSONObject:toString	()Ljava/lang/String;
        //   40: ldc 70
        //   42: invokestatic 76	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   45: astore_1
        //   46: new 78	com/tencent/mm/ui/widget/a/e
        //   49: dup
        //   50: aload_0
        //   51: getfield 35	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1:val$context	Landroid/content/Context;
        //   54: iconst_0
        //   55: iconst_0
        //   56: invokespecial 81	com/tencent/mm/ui/widget/a/e:<init>	(Landroid/content/Context;IZ)V
        //   59: astore_2
        //   60: aload_2
        //   61: new 13	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$1
        //   64: dup
        //   65: aload_0
        //   66: invokespecial 84	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$1:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bg$1;)V
        //   69: putfield 88	com/tencent/mm/ui/widget/a/e:HrX	Lcom/tencent/mm/ui/base/n$c;
        //   72: aload_2
        //   73: new 15	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$2
        //   76: dup
        //   77: aload_0
        //   78: aload_3
        //   79: aload_1
        //   80: aload_2
        //   81: invokespecial 91	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$2:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bg$1;Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mm/ui/widget/a/e;)V
        //   84: putfield 95	com/tencent/mm/ui/widget/a/e:HrY	Lcom/tencent/mm/ui/base/n$d;
        //   87: aload_2
        //   88: new 17	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$3
        //   91: dup
        //   92: aload_0
        //   93: aload_1
        //   94: invokespecial 98	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1$3:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bg$1;Ljava/lang/String;)V
        //   97: putfield 102	com/tencent/mm/ui/widget/a/e:GHn	Lcom/tencent/mm/ui/widget/a/e$b;
        //   100: aload_2
        //   101: invokevirtual 105	com/tencent/mm/ui/widget/a/e:csG	()V
        //   104: ldc 45
        //   106: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   109: return
        //   110: astore_1
        //   111: ldc 110
        //   113: aload_1
        //   114: ldc 64
        //   116: iconst_0
        //   117: anewarray 4	java/lang/Object
        //   120: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   123: aload_0
        //   124: getfield 33	com/tencent/mm/plugin/webview/luggage/jsapi/bg$1:ohm	Lcom/tencent/mm/plugin/webview/luggage/jsapi/bn$a;
        //   127: aconst_null
        //   128: aconst_null
        //   129: invokevirtual 122	com/tencent/mm/plugin/webview/luggage/jsapi/bn$a:f	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   132: ldc 45
        //   134: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   137: return
        //   138: astore_1
        //   139: aload_2
        //   140: astore_1
        //   141: goto -95 -> 46
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	144	0	this	1
        //   29	65	1	localObject1	Object
        //   110	4	1	localJSONException	org.json.JSONException
        //   138	1	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
        //   140	1	1	localObject2	Object
        //   27	113	2	localObject3	Object
        //   16	63	3	localJSONObject1	JSONObject
        //   23	13	4	localJSONObject2	JSONObject
        // Exception table:
        //   from	to	target	type
        //   5	17	110	org/json/JSONException
        //   35	46	138	java/io/UnsupportedEncodingException
      }
    });
    AppMethodBeat.o(187883);
  }
  
  public final void b(com.tencent.luggage.d.a<f>.a parama) {}
  
  public final int bQV()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareCustomContent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bg
 * JD-Core Version:    0.7.0.1
 */