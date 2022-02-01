package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.MenuItem;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wm.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bo
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(296064);
    com.tencent.mm.ipcinvoker.s.D(new Runnable()
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
        //   10: getfield 31	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1:qrn	Ljava/lang/String;
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
        //   46: aload_3
        //   47: ldc 78
        //   49: invokevirtual 82	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   52: astore_2
        //   53: new 84	com/tencent/mm/ui/widget/a/f
        //   56: dup
        //   57: aload_0
        //   58: getfield 35	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1:val$context	Landroid/content/Context;
        //   61: iconst_0
        //   62: iconst_0
        //   63: invokespecial 87	com/tencent/mm/ui/widget/a/f:<init>	(Landroid/content/Context;IZ)V
        //   66: astore 4
        //   68: aload 4
        //   70: new 13	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$1
        //   73: dup
        //   74: aload_0
        //   75: aload_2
        //   76: invokespecial 90	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$1:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bo$1;Lorg/json/JSONArray;)V
        //   79: putfield 94	com/tencent/mm/ui/widget/a/f:Vtg	Lcom/tencent/mm/ui/base/u$g;
        //   82: aload 4
        //   84: new 15	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$2
        //   87: dup
        //   88: aload_0
        //   89: aload_3
        //   90: aload_1
        //   91: aload 4
        //   93: invokespecial 97	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$2:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bo$1;Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mm/ui/widget/a/f;)V
        //   96: putfield 101	com/tencent/mm/ui/widget/a/f:GAC	Lcom/tencent/mm/ui/base/u$i;
        //   99: aload 4
        //   101: new 17	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$3
        //   104: dup
        //   105: aload_0
        //   106: aload_1
        //   107: invokespecial 104	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1$3:<init>	(Lcom/tencent/mm/plugin/webview/luggage/jsapi/bo$1;Ljava/lang/String;)V
        //   110: putfield 108	com/tencent/mm/ui/widget/a/f:aeLi	Lcom/tencent/mm/ui/widget/a/f$b;
        //   113: aload 4
        //   115: invokevirtual 111	com/tencent/mm/ui/widget/a/f:dDn	()V
        //   118: ldc 45
        //   120: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   123: return
        //   124: astore_1
        //   125: ldc 116
        //   127: aload_1
        //   128: ldc 64
        //   130: iconst_0
        //   131: anewarray 4	java/lang/Object
        //   134: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   137: aload_0
        //   138: getfield 33	com/tencent/mm/plugin/webview/luggage/jsapi/bo$1:Iuv	Lcom/tencent/mm/plugin/webview/luggage/jsapi/bv$a;
        //   141: aconst_null
        //   142: aconst_null
        //   143: invokevirtual 128	com/tencent/mm/plugin/webview/luggage/jsapi/bv$a:j	(Ljava/lang/String;Lorg/json/JSONObject;)V
        //   146: ldc 45
        //   148: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   151: return
        //   152: astore_1
        //   153: aload_2
        //   154: astore_1
        //   155: goto -109 -> 46
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	158	0	this	1
        //   29	78	1	localObject1	Object
        //   124	4	1	localJSONException	JSONException
        //   152	1	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
        //   154	1	1	localObject2	Object
        //   27	127	2	localObject3	Object
        //   16	74	3	localJSONObject	JSONObject
        //   23	91	4	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   5	17	124	org/json/JSONException
        //   35	46	152	java/io/UnsupportedEncodingException
      }
    });
    AppMethodBeat.o(296064);
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareCustomContent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bo
 * JD-Core Version:    0.7.0.1
 */