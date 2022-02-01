package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class z$c
  implements QueueWorkerThread.ThreadObject
{
  private static Pattern Kxd;
  private static Pattern Kxe;
  private String Kxf;
  private String Kxg;
  private z.a Kxh;
  private Context context;
  private String imagePath;
  private String imageUrl;
  private int opType;
  private boolean qoo;
  
  static
  {
    AppMethodBeat.i(103154);
    Kxd = Pattern.compile("image/[A-Za-z0-9]+");
    Kxe = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
    AppMethodBeat.o(103154);
  }
  
  public z$c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramContext, paramString1, paramString2, paramBoolean, 0, null);
  }
  
  public z$c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, z.a parama)
  {
    this.context = paramContext;
    this.imageUrl = paramString1;
    this.Kxg = paramString2;
    this.qoo = paramBoolean;
    this.opType = paramInt;
    this.Kxh = parama;
  }
  
  private void a(String paramString1, String paramString2, InputStream paramInputStream)
  {
    AppMethodBeat.i(177338);
    Log.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[] { paramString1, paramString2 });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = Kxd.matcher(paramString1);
      localObject1 = localObject2;
      if (paramString1.find()) {
        localObject1 = paramString1.group().substring(paramString1.group().lastIndexOf('/') + 1);
      }
    }
    paramString1 = (String)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      paramString1 = (String)localObject1;
      if (!Util.isNullOrNil(paramString2))
      {
        paramString2 = Kxe.matcher(paramString2);
        paramString1 = (String)localObject1;
        if (paramString2.find()) {
          paramString1 = paramString2.group().substring(paramString2.group().lastIndexOf('.') + 1);
        }
      }
    }
    paramString2 = paramString1;
    int i;
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = new x(this.imageUrl);
      i = paramString1.mPath.lastIndexOf('.');
      if (i != -1) {
        break label224;
      }
    }
    label224:
    for (paramString2 = "jpg";; paramString2 = paramString1.mPath.substring(i + 1))
    {
      this.imagePath = bfN(paramString2);
      paramString1 = com.tencent.mm.vfs.s.dw(this.imagePath, false);
      paramString2 = new byte[8192];
      for (;;)
      {
        i = paramInputStream.read(paramString2);
        if (i == -1) {
          break;
        }
        paramString1.write(paramString2, 0, i);
      }
    }
    try
    {
      paramString1.flush();
      paramString1.close();
      if (this.opType == 0)
      {
        this.Kxf = this.context.getString(2131758218, new Object[] { s.getToastSysCameraPath() });
        s.refreshMediaScanner(this.imagePath, this.context);
      }
      AppMethodBeat.o(177338);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    AppMethodBeat.i(184502);
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.getInputStream().close();
      paramHttpURLConnection.disconnect();
      if (paramInputStream == null) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramInputStream.close();
          AppMethodBeat.o(184502);
          return;
        }
        catch (Exception paramHttpURLConnection)
        {
          Log.printErrStackTrace("MicroMsg.WebViewUtil", paramHttpURLConnection, "", new Object[0]);
        }
        localException = localException;
        Log.e("MicroMsg.WebViewUtil", localException.getMessage());
      }
      AppMethodBeat.o(184502);
    }
  }
  
  private String bfN(String paramString)
  {
    AppMethodBeat.i(224526);
    this.imagePath = (s.getSysCameraDirPath() + String.format(Locale.US, "mmexport%s.%s", new Object[] { MD5Util.getMD5String(this.imageUrl), paramString }));
    if (com.tencent.mm.vfs.s.YS(this.imagePath)) {
      com.tencent.mm.vfs.s.deleteFile(this.imagePath);
    }
    paramString = this.imagePath;
    AppMethodBeat.o(224526);
    return paramString;
  }
  
  /* Error */
  private void gsO()
  {
    // Byte code:
    //   0: ldc 241
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 243	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   13: invokespecial 244	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 248	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 185	java/net/HttpURLConnection
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 250
    //   26: invokevirtual 253	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: ldc 255
    //   32: aload_0
    //   33: getfield 65	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxg	Ljava/lang/String;
    //   36: invokevirtual 258	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_2
    //   40: iconst_1
    //   41: invokevirtual 262	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
    //   44: aload_2
    //   45: invokevirtual 266	java/net/HttpURLConnection:getResponseCode	()I
    //   48: istore_1
    //   49: iload_1
    //   50: sipush 200
    //   53: if_icmpeq +110 -> 163
    //   56: iload_1
    //   57: sipush 301
    //   60: if_icmpeq +10 -> 70
    //   63: iload_1
    //   64: sipush 302
    //   67: if_icmpne +71 -> 138
    //   70: aload_2
    //   71: ldc_w 268
    //   74: invokevirtual 271	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore 4
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: ifnonnull +11 -> 95
    //   87: aload_2
    //   88: ldc_w 273
    //   91: invokevirtual 271	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_3
    //   95: ldc 78
    //   97: ldc_w 275
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_3
    //   107: aastore
    //   108: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_3
    //   112: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   115: ifne +23 -> 138
    //   118: aload_0
    //   119: aload_3
    //   120: putfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   123: aload_0
    //   124: invokespecial 277	com/tencent/mm/pluginsdk/ui/tools/z$c:gsO	()V
    //   127: aload_2
    //   128: aconst_null
    //   129: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   132: ldc 241
    //   134: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 61	com/tencent/mm/pluginsdk/ui/tools/z$c:context	Landroid/content/Context;
    //   143: ldc_w 280
    //   146: invokevirtual 282	android/content/Context:getString	(I)Ljava/lang/String;
    //   149: putfield 169	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxf	Ljava/lang/String;
    //   152: aload_2
    //   153: aconst_null
    //   154: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   157: ldc 241
    //   159: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: aload_2
    //   164: invokevirtual 285	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   167: astore 4
    //   169: aload_2
    //   170: invokevirtual 189	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   173: astore_3
    //   174: aload_0
    //   175: aload 4
    //   177: aload_2
    //   178: ldc_w 287
    //   181: invokevirtual 271	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   184: aload_3
    //   185: invokespecial 289	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   188: aload_2
    //   189: aload_3
    //   190: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   193: ldc 241
    //   195: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_3
    //   205: ldc 78
    //   207: ldc_w 291
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload 4
    //   218: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_3
    //   226: aload_2
    //   227: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   230: ldc 241
    //   232: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore 4
    //   238: aconst_null
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_3
    //   242: aload_3
    //   243: aload_2
    //   244: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   247: ldc 241
    //   249: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 4
    //   254: athrow
    //   255: astore 4
    //   257: aconst_null
    //   258: astore 5
    //   260: aload_2
    //   261: astore_3
    //   262: aload 5
    //   264: astore_2
    //   265: goto -23 -> 242
    //   268: astore 4
    //   270: aload_2
    //   271: astore 5
    //   273: aload_3
    //   274: astore_2
    //   275: aload 5
    //   277: astore_3
    //   278: goto -36 -> 242
    //   281: astore 4
    //   283: goto -41 -> 242
    //   286: astore 4
    //   288: aconst_null
    //   289: astore 5
    //   291: aload_2
    //   292: astore_3
    //   293: aload 5
    //   295: astore_2
    //   296: goto -91 -> 205
    //   299: astore 4
    //   301: aload_2
    //   302: astore 5
    //   304: aload_3
    //   305: astore_2
    //   306: aload 5
    //   308: astore_3
    //   309: goto -104 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	c
    //   48	20	1	i	int
    //   22	284	2	localObject1	Object
    //   81	228	3	localObject2	Object
    //   77	99	4	str	String
    //   199	18	4	localException1	Exception
    //   236	17	4	localObject3	Object
    //   255	1	4	localObject4	Object
    //   268	1	4	localObject5	Object
    //   281	1	4	localObject6	Object
    //   286	1	4	localException2	Exception
    //   299	1	4	localException3	Exception
    //   258	49	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	199	java/lang/Exception
    //   5	23	236	finally
    //   23	49	255	finally
    //   70	79	255	finally
    //   87	95	255	finally
    //   95	127	255	finally
    //   138	152	255	finally
    //   163	174	255	finally
    //   174	188	268	finally
    //   205	225	281	finally
    //   23	49	286	java/lang/Exception
    //   70	79	286	java/lang/Exception
    //   87	95	286	java/lang/Exception
    //   95	127	286	java/lang/Exception
    //   138	152	286	java/lang/Exception
    //   163	174	286	java/lang/Exception
    //   174	188	299	java/lang/Exception
  }
  
  /* Error */
  public final boolean doInBackground()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc_w 293
    //   9: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: getfield 67	com/tencent/mm/pluginsdk/ui/tools/z$c:qoo	Z
    //   16: ifne +25 -> 41
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 61	com/tencent/mm/pluginsdk/ui/tools/z$c:context	Landroid/content/Context;
    //   24: ldc_w 294
    //   27: invokevirtual 282	android/content/Context:getString	(I)Ljava/lang/String;
    //   30: putfield 169	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxf	Ljava/lang/String;
    //   33: ldc_w 293
    //   36: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_1
    //   40: ireturn
    //   41: aload_0
    //   42: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   45: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   48: ifeq +11 -> 59
    //   51: ldc_w 293
    //   54: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   63: invokestatic 299	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
    //   66: ifeq +357 -> 423
    //   69: ldc 125
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   76: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   79: ifne +16 -> 95
    //   82: aload_0
    //   83: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   86: ldc_w 301
    //   89: invokevirtual 304	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   92: ifne +19 -> 111
    //   95: aload_0
    //   96: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   99: ldc_w 301
    //   102: invokevirtual 307	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   105: invokevirtual 304	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   108: ifeq +7 -> 115
    //   111: ldc_w 309
    //   114: astore_2
    //   115: aload_0
    //   116: aload_0
    //   117: aload_2
    //   118: invokespecial 129	com/tencent/mm/pluginsdk/ui/tools/z$c:bfN	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 131	com/tencent/mm/pluginsdk/ui/tools/z$c:imagePath	Ljava/lang/String;
    //   124: aload 4
    //   126: astore_3
    //   127: aload 5
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   134: ldc_w 311
    //   137: invokevirtual 315	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   140: istore_1
    //   141: iload_1
    //   142: ifle +24 -> 166
    //   145: aload 4
    //   147: astore_3
    //   148: aload 5
    //   150: astore_2
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   156: iload_1
    //   157: bipush 7
    //   159: iadd
    //   160: invokevirtual 115	java/lang/String:substring	(I)Ljava/lang/String;
    //   163: putfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   166: aload 4
    //   168: astore_3
    //   169: aload 5
    //   171: astore_2
    //   172: aload_0
    //   173: getfield 131	com/tencent/mm/pluginsdk/ui/tools/z$c:imagePath	Ljava/lang/String;
    //   176: iconst_0
    //   177: invokestatic 137	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   180: astore 4
    //   182: aload 4
    //   184: astore_3
    //   185: aload 4
    //   187: astore_2
    //   188: aload_0
    //   189: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   192: iconst_0
    //   193: invokestatic 321	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   196: astore 5
    //   198: aload 5
    //   200: ifnull +16 -> 216
    //   203: aload 4
    //   205: astore_3
    //   206: aload 4
    //   208: astore_2
    //   209: aload 4
    //   211: aload 5
    //   213: invokevirtual 324	java/io/OutputStream:write	([B)V
    //   216: aload 4
    //   218: astore_3
    //   219: aload 4
    //   221: astore_2
    //   222: aload 4
    //   224: invokevirtual 152	java/io/OutputStream:flush	()V
    //   227: aload 4
    //   229: astore_3
    //   230: aload 4
    //   232: astore_2
    //   233: aload 4
    //   235: invokevirtual 155	java/io/OutputStream:close	()V
    //   238: aload 4
    //   240: astore_3
    //   241: aload 4
    //   243: astore_2
    //   244: aload_0
    //   245: aload_0
    //   246: getfield 61	com/tencent/mm/pluginsdk/ui/tools/z$c:context	Landroid/content/Context;
    //   249: ldc 156
    //   251: iconst_1
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: invokestatic 161	com/tencent/mm/pluginsdk/ui/tools/s:getToastSysCameraPath	()Ljava/lang/String;
    //   260: aastore
    //   261: invokevirtual 167	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   264: putfield 169	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxf	Ljava/lang/String;
    //   267: aload 4
    //   269: astore_3
    //   270: aload 4
    //   272: astore_2
    //   273: aload_0
    //   274: getfield 131	com/tencent/mm/pluginsdk/ui/tools/z$c:imagePath	Ljava/lang/String;
    //   277: aload_0
    //   278: getfield 61	com/tencent/mm/pluginsdk/ui/tools/z$c:context	Landroid/content/Context;
    //   281: invokestatic 173	com/tencent/mm/pluginsdk/ui/tools/s:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 155	java/io/OutputStream:close	()V
    //   294: ldc_w 293
    //   297: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: iconst_1
    //   301: ireturn
    //   302: astore_2
    //   303: ldc 78
    //   305: ldc_w 326
    //   308: iconst_1
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: aload_2
    //   315: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: goto -28 -> 294
    //   325: astore 4
    //   327: aload_3
    //   328: astore_2
    //   329: ldc 78
    //   331: ldc_w 328
    //   334: iconst_1
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: aload 4
    //   342: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_3
    //   350: ifnull -56 -> 294
    //   353: aload_3
    //   354: invokevirtual 155	java/io/OutputStream:close	()V
    //   357: goto -63 -> 294
    //   360: astore_2
    //   361: ldc 78
    //   363: ldc_w 326
    //   366: iconst_1
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: aload_2
    //   373: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   376: aastore
    //   377: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: goto -86 -> 294
    //   383: astore_3
    //   384: aload_2
    //   385: ifnull +7 -> 392
    //   388: aload_2
    //   389: invokevirtual 155	java/io/OutputStream:close	()V
    //   392: ldc_w 293
    //   395: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: aload_3
    //   399: athrow
    //   400: astore_2
    //   401: ldc 78
    //   403: ldc_w 326
    //   406: iconst_1
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_2
    //   413: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: aastore
    //   417: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -28 -> 392
    //   423: aload_0
    //   424: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   427: invokestatic 331	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   430: ifeq +242 -> 672
    //   433: new 243	java/net/URL
    //   436: dup
    //   437: aload_0
    //   438: getfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   441: invokespecial 244	java/net/URL:<init>	(Ljava/lang/String;)V
    //   444: invokevirtual 248	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   447: checkcast 333	javax/net/ssl/HttpsURLConnection
    //   450: astore_2
    //   451: aload_2
    //   452: ldc 250
    //   454: invokevirtual 334	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   457: aload_2
    //   458: ldc 255
    //   460: aload_0
    //   461: getfield 65	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxg	Ljava/lang/String;
    //   464: invokevirtual 335	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload_2
    //   468: iconst_1
    //   469: invokevirtual 336	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
    //   472: aload_2
    //   473: invokevirtual 337	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   476: istore_1
    //   477: iload_1
    //   478: sipush 200
    //   481: if_icmpeq +104 -> 585
    //   484: iload_1
    //   485: sipush 301
    //   488: if_icmpeq +10 -> 498
    //   491: iload_1
    //   492: sipush 302
    //   495: if_icmpne +68 -> 563
    //   498: aload_2
    //   499: ldc_w 268
    //   502: invokevirtual 338	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 4
    //   507: aload 4
    //   509: astore_3
    //   510: aload 4
    //   512: ifnonnull +11 -> 523
    //   515: aload_2
    //   516: ldc_w 273
    //   519: invokevirtual 338	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   522: astore_3
    //   523: ldc 78
    //   525: ldc_w 275
    //   528: iconst_1
    //   529: anewarray 4	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: aload_3
    //   535: aastore
    //   536: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: aload_3
    //   540: invokestatic 91	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   543: ifne +20 -> 563
    //   546: aload_0
    //   547: aload_3
    //   548: putfield 63	com/tencent/mm/pluginsdk/ui/tools/z$c:imageUrl	Ljava/lang/String;
    //   551: aload_0
    //   552: invokespecial 277	com/tencent/mm/pluginsdk/ui/tools/z$c:gsO	()V
    //   555: aload_2
    //   556: aconst_null
    //   557: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   560: goto -266 -> 294
    //   563: aload_0
    //   564: aload_0
    //   565: getfield 61	com/tencent/mm/pluginsdk/ui/tools/z$c:context	Landroid/content/Context;
    //   568: ldc_w 280
    //   571: invokevirtual 282	android/content/Context:getString	(I)Ljava/lang/String;
    //   574: putfield 169	com/tencent/mm/pluginsdk/ui/tools/z$c:Kxf	Ljava/lang/String;
    //   577: aload_2
    //   578: aconst_null
    //   579: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   582: goto -288 -> 294
    //   585: aload_2
    //   586: invokevirtual 339	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   589: astore 4
    //   591: aload_2
    //   592: invokevirtual 340	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   595: astore_3
    //   596: aload_0
    //   597: aload 4
    //   599: aload_2
    //   600: ldc_w 287
    //   603: invokevirtual 338	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   606: aload_3
    //   607: invokespecial 289	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   610: aload_2
    //   611: aload_3
    //   612: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   615: goto -321 -> 294
    //   618: astore 4
    //   620: aconst_null
    //   621: astore_2
    //   622: aconst_null
    //   623: astore_3
    //   624: ldc 78
    //   626: ldc_w 342
    //   629: iconst_1
    //   630: anewarray 4	java/lang/Object
    //   633: dup
    //   634: iconst_0
    //   635: aload 4
    //   637: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   640: aastore
    //   641: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   644: aload_3
    //   645: aload_2
    //   646: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   649: goto -355 -> 294
    //   652: astore 4
    //   654: aconst_null
    //   655: astore_2
    //   656: aconst_null
    //   657: astore_3
    //   658: aload_3
    //   659: aload_2
    //   660: invokestatic 279	com/tencent/mm/pluginsdk/ui/tools/z$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   663: ldc_w 293
    //   666: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   669: aload 4
    //   671: athrow
    //   672: aload_0
    //   673: invokespecial 277	com/tencent/mm/pluginsdk/ui/tools/z$c:gsO	()V
    //   676: goto -382 -> 294
    //   679: astore 4
    //   681: aconst_null
    //   682: astore 5
    //   684: aload_2
    //   685: astore_3
    //   686: aload 5
    //   688: astore_2
    //   689: goto -31 -> 658
    //   692: astore 4
    //   694: aload_2
    //   695: astore 5
    //   697: aload_3
    //   698: astore_2
    //   699: aload 5
    //   701: astore_3
    //   702: goto -44 -> 658
    //   705: astore 4
    //   707: goto -49 -> 658
    //   710: astore 4
    //   712: aconst_null
    //   713: astore 5
    //   715: aload_2
    //   716: astore_3
    //   717: aload 5
    //   719: astore_2
    //   720: goto -96 -> 624
    //   723: astore 4
    //   725: aload_2
    //   726: astore 5
    //   728: aload_3
    //   729: astore_2
    //   730: aload 5
    //   732: astore_3
    //   733: goto -109 -> 624
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	this	c
    //   140	356	1	i	int
    //   71	202	2	localObject1	Object
    //   302	13	2	localException1	Exception
    //   328	1	2	localObject2	Object
    //   360	29	2	localException2	Exception
    //   400	13	2	localException3	Exception
    //   450	280	2	localObject3	Object
    //   126	228	3	localOutputStream1	OutputStream
    //   383	16	3	localObject4	Object
    //   509	224	3	localObject5	Object
    //   4	286	4	localOutputStream2	OutputStream
    //   325	16	4	localException4	Exception
    //   505	93	4	str	String
    //   618	18	4	localException5	Exception
    //   652	18	4	localObject6	Object
    //   679	1	4	localObject7	Object
    //   692	1	4	localObject8	Object
    //   705	1	4	localObject9	Object
    //   710	1	4	localException6	Exception
    //   723	1	4	localException7	Exception
    //   1	730	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   289	294	302	java/lang/Exception
    //   130	141	325	java/lang/Exception
    //   151	166	325	java/lang/Exception
    //   172	182	325	java/lang/Exception
    //   188	198	325	java/lang/Exception
    //   209	216	325	java/lang/Exception
    //   222	227	325	java/lang/Exception
    //   233	238	325	java/lang/Exception
    //   244	267	325	java/lang/Exception
    //   273	284	325	java/lang/Exception
    //   353	357	360	java/lang/Exception
    //   130	141	383	finally
    //   151	166	383	finally
    //   172	182	383	finally
    //   188	198	383	finally
    //   209	216	383	finally
    //   222	227	383	finally
    //   233	238	383	finally
    //   244	267	383	finally
    //   273	284	383	finally
    //   329	349	383	finally
    //   388	392	400	java/lang/Exception
    //   433	451	618	java/lang/Exception
    //   433	451	652	finally
    //   451	477	679	finally
    //   498	507	679	finally
    //   515	523	679	finally
    //   523	555	679	finally
    //   563	577	679	finally
    //   585	596	679	finally
    //   596	610	692	finally
    //   624	644	705	finally
    //   451	477	710	java/lang/Exception
    //   498	507	710	java/lang/Exception
    //   515	523	710	java/lang/Exception
    //   523	555	710	java/lang/Exception
    //   563	577	710	java/lang/Exception
    //   585	596	710	java/lang/Exception
    //   596	610	723	java/lang/Exception
  }
  
  public final boolean onPostExecute()
  {
    AppMethodBeat.i(103149);
    if (1 == this.opType)
    {
      this.Kxh.abE(this.imagePath);
      AppMethodBeat.o(103149);
      return true;
    }
    if (!Util.isNullOrNil(this.Kxf)) {
      Toast.makeText(this.context, this.Kxf, 1).show();
    }
    for (;;)
    {
      AppMethodBeat.o(103149);
      return true;
      Toast.makeText(this.context, this.context.getString(2131768791), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.z.c
 * JD-Core Version:    0.7.0.1
 */