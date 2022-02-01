package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static DexClassLoader b = null;
  private static Looper c = null;
  private static d d = null;
  public String a;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(53977);
    this.a = "";
    this.a = (paramContext.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin");
    AppMethodBeat.o(53977);
  }
  
  public static d a(Context paramContext)
  {
    AppMethodBeat.i(53978);
    if (d == null) {
      d = new d(paramContext);
    }
    paramContext = d;
    AppMethodBeat.o(53978);
    return paramContext;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString, final a parama)
  {
    AppMethodBeat.i(53980);
    new Thread()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 33	java/net/URL
        //   8: dup
        //   9: ldc 35
        //   11: invokespecial 38	java/net/URL:<init>	(Ljava/lang/String;)V
        //   14: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   17: checkcast 44	java/net/HttpURLConnection
        //   20: astore 4
        //   22: aload 4
        //   24: invokevirtual 48	java/net/HttpURLConnection:getContentLength	()I
        //   27: istore_2
        //   28: aload 4
        //   30: sipush 5000
        //   33: invokevirtual 51	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   36: aload 4
        //   38: invokevirtual 54	java/net/HttpURLConnection:connect	()V
        //   41: aload 4
        //   43: invokevirtual 58	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   46: astore 4
        //   48: new 60	java/io/File
        //   51: dup
        //   52: aload_0
        //   53: getfield 15	com/tencent/smtt/utils/d$2:a	Ljava/lang/String;
        //   56: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
        //   59: invokestatic 67	com/tencent/smtt/utils/f:d	(Ljava/io/File;)Ljava/io/FileOutputStream;
        //   62: astore 5
        //   64: aload 5
        //   66: astore 7
        //   68: aload 4
        //   70: astore 6
        //   72: sipush 8192
        //   75: newarray byte
        //   77: astore 8
        //   79: iconst_0
        //   80: istore_1
        //   81: aload 5
        //   83: astore 7
        //   85: aload 4
        //   87: astore 6
        //   89: aload 4
        //   91: aload 8
        //   93: invokevirtual 73	java/io/InputStream:read	([B)I
        //   96: istore_3
        //   97: iload_3
        //   98: ifle +97 -> 195
        //   101: iload_1
        //   102: iload_3
        //   103: iadd
        //   104: istore_1
        //   105: aload 5
        //   107: astore 7
        //   109: aload 4
        //   111: astore 6
        //   113: aload 5
        //   115: aload 8
        //   117: iconst_0
        //   118: iload_3
        //   119: invokevirtual 79	java/io/OutputStream:write	([BII)V
        //   122: aload 5
        //   124: astore 7
        //   126: aload 4
        //   128: astore 6
        //   130: iload_1
        //   131: bipush 100
        //   133: imul
        //   134: iload_2
        //   135: idiv
        //   136: istore_3
        //   137: aload 5
        //   139: astore 7
        //   141: aload 4
        //   143: astore 6
        //   145: aload_0
        //   146: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   149: iload_3
        //   150: invokeinterface 83 2 0
        //   155: goto -74 -> 81
        //   158: astore 8
        //   160: aload 5
        //   162: astore 7
        //   164: aload 4
        //   166: astore 6
        //   168: aload_0
        //   169: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   172: aload 8
        //   174: invokeinterface 86 2 0
        //   179: aload 4
        //   181: invokevirtual 89	java/io/InputStream:close	()V
        //   184: aload 5
        //   186: invokevirtual 90	java/io/OutputStream:close	()V
        //   189: ldc 25
        //   191: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   194: return
        //   195: aload 5
        //   197: astore 7
        //   199: aload 4
        //   201: astore 6
        //   203: aload_0
        //   204: getfield 17	com/tencent/smtt/utils/d$2:b	Lcom/tencent/smtt/utils/d$a;
        //   207: invokeinterface 95 1 0
        //   212: aload 4
        //   214: invokevirtual 89	java/io/InputStream:close	()V
        //   217: aload 5
        //   219: invokevirtual 90	java/io/OutputStream:close	()V
        //   222: ldc 25
        //   224: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   227: return
        //   228: astore 4
        //   230: ldc 25
        //   232: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   235: return
        //   236: astore 4
        //   238: ldc 25
        //   240: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   243: return
        //   244: astore 5
        //   246: aconst_null
        //   247: astore 7
        //   249: aconst_null
        //   250: astore 4
        //   252: aload 4
        //   254: invokevirtual 89	java/io/InputStream:close	()V
        //   257: aload 7
        //   259: invokevirtual 90	java/io/OutputStream:close	()V
        //   262: ldc 25
        //   264: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   267: aload 5
        //   269: athrow
        //   270: astore 4
        //   272: goto -55 -> 217
        //   275: astore 4
        //   277: goto -93 -> 184
        //   280: astore 4
        //   282: goto -25 -> 257
        //   285: astore 4
        //   287: goto -25 -> 262
        //   290: astore 5
        //   292: aconst_null
        //   293: astore 7
        //   295: goto -43 -> 252
        //   298: astore 5
        //   300: aload 6
        //   302: astore 4
        //   304: goto -52 -> 252
        //   307: astore 8
        //   309: aconst_null
        //   310: astore 5
        //   312: aconst_null
        //   313: astore 4
        //   315: goto -155 -> 160
        //   318: astore 8
        //   320: aconst_null
        //   321: astore 5
        //   323: goto -163 -> 160
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	326	0	this	2
        //   80	54	1	i	int
        //   27	109	2	j	int
        //   96	54	3	k	int
        //   20	193	4	localObject1	Object
        //   228	1	4	localException1	Exception
        //   236	1	4	localException2	Exception
        //   250	3	4	localObject2	Object
        //   270	1	4	localException3	Exception
        //   275	1	4	localException4	Exception
        //   280	1	4	localException5	Exception
        //   285	1	4	localException6	Exception
        //   302	12	4	localObject3	Object
        //   62	156	5	localFileOutputStream1	java.io.FileOutputStream
        //   244	24	5	localObject4	Object
        //   290	1	5	localObject5	Object
        //   298	1	5	localObject6	Object
        //   310	12	5	localObject7	Object
        //   70	231	6	localObject8	Object
        //   66	228	7	localFileOutputStream2	java.io.FileOutputStream
        //   77	39	8	arrayOfByte	byte[]
        //   158	15	8	localException7	Exception
        //   307	1	8	localException8	Exception
        //   318	1	8	localException9	Exception
        // Exception table:
        //   from	to	target	type
        //   72	79	158	java/lang/Exception
        //   89	97	158	java/lang/Exception
        //   113	122	158	java/lang/Exception
        //   130	137	158	java/lang/Exception
        //   145	155	158	java/lang/Exception
        //   203	212	158	java/lang/Exception
        //   217	222	228	java/lang/Exception
        //   184	189	236	java/lang/Exception
        //   5	48	244	finally
        //   212	217	270	java/lang/Exception
        //   179	184	275	java/lang/Exception
        //   252	257	280	java/lang/Exception
        //   257	262	285	java/lang/Exception
        //   48	64	290	finally
        //   72	79	298	finally
        //   89	97	298	finally
        //   113	122	298	finally
        //   130	137	298	finally
        //   145	155	298	finally
        //   168	179	298	finally
        //   203	212	298	finally
        //   5	48	307	java/lang/Exception
        //   48	64	318	java/lang/Exception
      }
    }.start();
    AppMethodBeat.o(53980);
  }
  
  public void a(final String paramString, final WebView paramWebView, final Context paramContext)
  {
    AppMethodBeat.i(53979);
    final RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    final TextView localTextView = new TextView(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localTextView.setText("加载中，请稍后...");
    localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramWebView.addView(localRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.a + File.separator + "DebugPlugin.tbs";
    f.b(new File((String)localObject));
    a((String)localObject, new a()
    {
      public void a()
      {
        AppMethodBeat.i(53870);
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(53948);
            Toast.makeText(d.1.this.b, "下载成功", 0).show();
            d.1.this.c.setVisibility(4);
            d.this.a(d.1.this.d, d.1.this.a, d.1.this.b, d.a());
            AppMethodBeat.o(53948);
          }
        });
        AppMethodBeat.o(53870);
      }
      
      public void a(int paramAnonymousInt)
      {
        AppMethodBeat.i(53871);
        paramWebView.post(new d.1.2(this, paramAnonymousInt));
        AppMethodBeat.o(53871);
      }
      
      public void a(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(53872);
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(53881);
            Toast.makeText(d.1.this.b, "下载失败，请检查网络", 0).show();
            AppMethodBeat.o(53881);
          }
        });
        AppMethodBeat.o(53872);
      }
    });
    AppMethodBeat.o(53979);
  }
  
  @SuppressLint({"NewApi"})
  public void a(String paramString, WebView paramWebView, Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(53981);
    TbsLog.i("debugtbs", "showPluginView -- url: " + paramString + "; webview: " + paramWebView + "; context: " + paramContext);
    Object localObject1 = this.a + File.separator + "DebugPlugin.tbs";
    Object localObject2 = this.a + File.separator + "DebugPlugin.apk";
    Object localObject3 = new File((String)localObject1);
    localObject1 = new File((String)localObject2);
    c = paramLooper;
    if (((File)localObject3).exists())
    {
      ((File)localObject1).delete();
      ((File)localObject3).renameTo((File)localObject1);
    }
    if (!((File)localObject1).exists())
    {
      TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
      a(paramString, paramWebView, paramContext);
      AppMethodBeat.o(53981);
      return;
    }
    TbsLog.d("debugtbs", "showPluginView -- going to show plugin view with ".concat(String.valueOf(localObject2)));
    try
    {
      Object localObject4 = b.a(paramContext, true, new File((String)localObject2));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(localObject4))
      {
        TbsLog.e("debugtbs", "verifyPlugin apk: " + (String)localObject2 + " signature failed - sig: " + (String)localObject4);
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        ((File)localObject3).delete();
        ((File)localObject1).delete();
        AppMethodBeat.o(53981);
        return;
      }
      localObject3 = this.a + File.separator + "opt";
      localObject4 = new File((String)localObject3);
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdirs();
      }
      if (b == null) {
        b = new DexClassLoader((String)localObject2, (String)localObject3, null, paramContext.getClassLoader());
      }
      localObject2 = new HashMap();
      ((Map)localObject2).put("url", paramString);
      ((Map)localObject2).put("tbs_version", WebView.getTbsSDKVersion(paramContext));
      ((Map)localObject2).put("tbs_core_version", WebView.getTbsCoreVersion(paramContext));
      if (c != null) {
        ((Map)localObject2).put("looper", paramLooper);
      }
      paramString = b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, localObject2 });
      if ((paramString instanceof FrameLayout))
      {
        paramString = (FrameLayout)paramString;
        paramWebView.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
        TbsLog.i("debugtbs", "show " + paramString + " successful in " + paramWebView);
        AppMethodBeat.o(53981);
        return;
      }
    }
    catch (Exception paramString)
    {
      f.b((File)localObject1);
      AppMethodBeat.o(53981);
      return;
    }
    TbsLog.e("debugtbs", "get debugview failure: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(53981);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.utils.d
 * JD-Core Version:    0.7.0.1
 */