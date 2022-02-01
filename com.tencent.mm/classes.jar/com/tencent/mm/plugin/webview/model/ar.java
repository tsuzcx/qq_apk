package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.luggage.l.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.sdk.platformtools.InetUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ar
{
  private List<Integer> WMl;
  private final Map<String, Boolean> WMm;
  public final Set<String> WMn;
  private String WMo;
  
  public ar()
  {
    AppMethodBeat.i(298177);
    this.WMo = null;
    this.WMl = new ArrayList();
    this.WMm = new HashMap();
    this.WMn = new HashSet();
    AppMethodBeat.o(298177);
  }
  
  private boolean bku(String paramString)
  {
    AppMethodBeat.i(298183);
    try
    {
      String str = Uri.parse(paramString).getHost();
      if ((InetUtil.isIPv4Address(str)) || (InetUtil.isIPv6Address(str)))
      {
        if (this.WMo == null) {
          this.WMo = h.atl();
        }
        boolean bool = paramString.contains(this.WMo);
        AppMethodBeat.o(298183);
        return bool;
      }
      AppMethodBeat.o(298183);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(298183);
    }
    return false;
  }
  
  private boolean bkv(String paramString)
  {
    AppMethodBeat.i(79034);
    if ((Util.isNullOrNil(paramString)) || (!c.agu(paramString)))
    {
      AppMethodBeat.o(79034);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.contains("localhost")) || (paramString.contains("127.0.0.1")) || (paramString.contains("::1")) || (bku(paramString)))
    {
      if ((this.WMl != null) && (this.WMl.size() > 0))
      {
        Iterator localIterator = this.WMl.iterator();
        while (localIterator.hasNext())
        {
          int i = ((Integer)localIterator.next()).intValue();
          if ((paramString.contains("localhost:".concat(String.valueOf(i)))) || (paramString.contains("127.0.0.1:".concat(String.valueOf(i)))))
          {
            Log.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[] { paramString, Integer.valueOf(i) });
            AppMethodBeat.o(79034);
            return false;
          }
        }
      }
      Log.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[] { paramString });
      AppMethodBeat.o(79034);
      return true;
    }
    AppMethodBeat.o(79034);
    return false;
  }
  
  /* Error */
  public com.tencent.xweb.WebResourceResponse a(String paramString, com.tencent.xweb.WebResourceRequest paramWebResourceRequest, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.e parame)
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +34 -> 40
    //   9: aload_2
    //   10: invokeinterface 167 1 0
    //   15: invokevirtual 170	android/net/Uri:toString	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload_1
    //   20: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +22 -> 45
    //   26: ldc 143
    //   28: ldc 172
    //   30: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 161
    //   35: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -23 -> 19
    //   45: aload_1
    //   46: ldc 177
    //   48: invokevirtual 180	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   51: ifeq +98 -> 149
    //   54: ldc 143
    //   56: ldc 182
    //   58: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload 4
    //   63: aload_1
    //   64: iconst_2
    //   65: invokeinterface 190 3 0
    //   70: invokestatic 196	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   73: astore_1
    //   74: new 198	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 199	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_2
    //   82: aload_1
    //   83: getstatic 205	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 90
    //   88: aload_2
    //   89: invokevirtual 211	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: new 213	com/tencent/xweb/WebResourceResponse
    //   96: dup
    //   97: ldc 215
    //   99: ldc 217
    //   101: new 219	java/io/ByteArrayInputStream
    //   104: dup
    //   105: aload_2
    //   106: invokevirtual 223	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   109: invokespecial 226	java/io/ByteArrayInputStream:<init>	([B)V
    //   112: invokespecial 229	com/tencent/xweb/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   115: astore_1
    //   116: ldc 161
    //   118: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_1
    //   122: areturn
    //   123: astore_1
    //   124: ldc 143
    //   126: ldc 231
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc 161
    //   144: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aconst_null
    //   148: areturn
    //   149: iload_3
    //   150: ifeq +55 -> 205
    //   153: aload_0
    //   154: aload_1
    //   155: invokespecial 236	com/tencent/mm/plugin/webview/model/ar:bkv	(Ljava/lang/String;)Z
    //   158: ifeq +47 -> 205
    //   161: ldc 143
    //   163: ldc 238
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: aastore
    //   173: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: new 213	com/tencent/xweb/WebResourceResponse
    //   179: dup
    //   180: ldc 215
    //   182: ldc 217
    //   184: new 219	java/io/ByteArrayInputStream
    //   187: dup
    //   188: iconst_0
    //   189: newarray byte
    //   191: invokespecial 226	java/io/ByteArrayInputStream:<init>	([B)V
    //   194: invokespecial 229	com/tencent/xweb/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   197: astore_1
    //   198: ldc 161
    //   200: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload_1
    //   204: areturn
    //   205: invokestatic 246	com/tencent/mm/plugin/webview/ui/tools/e:isEnabled	()Z
    //   208: ifeq +324 -> 532
    //   211: invokestatic 249	com/tencent/mm/plugin/webview/ui/tools/e:ixp	()Ljava/lang/String;
    //   214: astore_2
    //   215: aload_1
    //   216: invokestatic 58	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   219: astore 4
    //   221: aload 4
    //   223: invokevirtual 62	android/net/Uri:getHost	()Ljava/lang/String;
    //   226: astore 9
    //   228: aload_2
    //   229: ifnull +303 -> 532
    //   232: aload 9
    //   234: ifnull +298 -> 532
    //   237: aload_2
    //   238: new 251	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   245: aload 9
    //   247: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: getstatic 262	com/tencent/mm/plugin/normsg/a/d:MtP	Lcom/tencent/mm/plugin/normsg/a/d;
    //   253: ldc_w 264
    //   256: invokevirtual 267	com/tencent/mm/plugin/normsg/a/d:aQf	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 273	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   268: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifeq +261 -> 532
    //   274: aload 4
    //   276: invokevirtual 281	android/net/Uri:getQueryParameterNames	()Ljava/util/Set;
    //   279: astore_2
    //   280: aload_2
    //   281: ifnull +47 -> 328
    //   284: aload_2
    //   285: ldc_w 283
    //   288: invokevirtual 288	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   291: iconst_2
    //   292: iconst_3
    //   293: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
    //   296: invokeinterface 296 2 0
    //   301: ifeq +27 -> 328
    //   304: ldc 143
    //   306: ldc_w 298
    //   309: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_1
    //   313: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   316: ifeq +73 -> 389
    //   319: ldc_w 303
    //   322: ldc_w 305
    //   325: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: invokestatic 308	com/tencent/mm/plugin/webview/ui/tools/e:isBlock	()Z
    //   331: ifeq +201 -> 532
    //   334: ldc 143
    //   336: ldc_w 310
    //   339: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_1
    //   343: invokestatic 88	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   346: ifeq +193 -> 539
    //   349: ldc_w 303
    //   352: ldc_w 305
    //   355: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: new 213	com/tencent/xweb/WebResourceResponse
    //   361: dup
    //   362: ldc_w 312
    //   365: ldc_w 314
    //   368: new 219	java/io/ByteArrayInputStream
    //   371: dup
    //   372: iconst_0
    //   373: newarray byte
    //   375: invokespecial 226	java/io/ByteArrayInputStream:<init>	([B)V
    //   378: invokespecial 229	com/tencent/xweb/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   381: astore_1
    //   382: ldc 161
    //   384: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aload_1
    //   388: areturn
    //   389: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   392: ldc_w 322
    //   395: iconst_0
    //   396: invokevirtual 328	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   399: astore_2
    //   400: new 251	java/lang/StringBuilder
    //   403: dup
    //   404: ldc_w 330
    //   407: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   410: aload_1
    //   411: invokestatic 273	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   414: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: astore 4
    //   422: aload_2
    //   423: aload 4
    //   425: lconst_0
    //   426: invokeinterface 339 4 0
    //   431: lstore 5
    //   433: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   436: lstore 7
    //   438: lload 7
    //   440: lload 5
    //   442: lsub
    //   443: getstatic 351	java/util/concurrent/TimeUnit:HOURS	Ljava/util/concurrent/TimeUnit;
    //   446: ldc2_w 352
    //   449: invokevirtual 357	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   452: lcmp
    //   453: ifle -125 -> 328
    //   456: aload_2
    //   457: invokeinterface 361 1 0
    //   462: aload 4
    //   464: lload 7
    //   466: invokeinterface 367 4 0
    //   471: invokeinterface 370 1 0
    //   476: pop
    //   477: getstatic 376	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   480: sipush 16195
    //   483: aload_1
    //   484: ldc_w 378
    //   487: ldc_w 380
    //   490: invokevirtual 384	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   493: iconst_0
    //   494: iconst_1
    //   495: invokevirtual 388	com/tencent/mm/plugin/report/f:b	(ILjava/lang/String;ZZ)V
    //   498: getstatic 376	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   501: ldc2_w 389
    //   504: lconst_0
    //   505: lconst_1
    //   506: iconst_0
    //   507: invokevirtual 394	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   510: goto -182 -> 328
    //   513: astore_2
    //   514: ldc_w 303
    //   517: aload_2
    //   518: ldc_w 396
    //   521: iconst_0
    //   522: anewarray 4	java/lang/Object
    //   525: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   528: goto -200 -> 328
    //   531: astore_1
    //   532: ldc 161
    //   534: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: aconst_null
    //   538: areturn
    //   539: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   542: ldc_w 322
    //   545: iconst_0
    //   546: invokevirtual 328	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   549: astore_2
    //   550: new 251	java/lang/StringBuilder
    //   553: dup
    //   554: ldc_w 402
    //   557: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   560: aload_1
    //   561: invokestatic 273	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   564: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: astore_1
    //   571: aload_2
    //   572: aload_1
    //   573: lconst_0
    //   574: invokeinterface 339 4 0
    //   579: lstore 5
    //   581: invokestatic 345	java/lang/System:currentTimeMillis	()J
    //   584: lstore 7
    //   586: lload 7
    //   588: lload 5
    //   590: lsub
    //   591: getstatic 351	java/util/concurrent/TimeUnit:HOURS	Ljava/util/concurrent/TimeUnit;
    //   594: ldc2_w 352
    //   597: invokevirtual 357	java/util/concurrent/TimeUnit:toMillis	(J)J
    //   600: lcmp
    //   601: ifle -243 -> 358
    //   604: aload_2
    //   605: invokeinterface 361 1 0
    //   610: aload_1
    //   611: lload 7
    //   613: invokeinterface 367 4 0
    //   618: invokeinterface 370 1 0
    //   623: pop
    //   624: getstatic 376	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   627: ldc2_w 389
    //   630: lconst_1
    //   631: lconst_1
    //   632: iconst_0
    //   633: invokevirtual 394	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   636: goto -278 -> 358
    //   639: astore_1
    //   640: ldc_w 303
    //   643: aload_1
    //   644: ldc_w 396
    //   647: iconst_0
    //   648: anewarray 4	java/lang/Object
    //   651: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   654: goto -296 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	657	0	this	ar
    //   0	657	1	paramString	String
    //   0	657	2	paramWebResourceRequest	com.tencent.xweb.WebResourceRequest
    //   0	657	3	paramBoolean	boolean
    //   0	657	4	parame	com.tencent.mm.plugin.webview.stub.e
    //   431	158	5	l1	long
    //   436	176	7	l2	long
    //   226	20	9	str	String
    // Exception table:
    //   from	to	target	type
    //   61	116	123	java/lang/Exception
    //   389	510	513	finally
    //   205	228	531	finally
    //   237	280	531	finally
    //   284	328	531	finally
    //   328	358	531	finally
    //   358	382	531	finally
    //   514	528	531	finally
    //   640	654	531	finally
    //   539	636	639	finally
  }
  
  public final void atK(int paramInt)
  {
    AppMethodBeat.i(298204);
    if ((paramInt <= 0) || (paramInt > 65535)) {
      Log.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (!this.WMl.contains(Integer.valueOf(paramInt))) {
      this.WMl.add(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(298204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ar
 * JD-Core Version:    0.7.0.1
 */