package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class u$c
  implements az.a
{
  private static Pattern wgi;
  private static Pattern wgj;
  private Context context;
  private String ffp;
  private String imagePath;
  private boolean kFs;
  private int opType;
  private String wgk;
  private String wgl;
  private u.a wgm;
  
  static
  {
    AppMethodBeat.i(80466);
    wgi = Pattern.compile("image/[A-Za-z0-9]+");
    wgj = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
    AppMethodBeat.o(80466);
  }
  
  public u$c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramContext, paramString1, paramString2, paramBoolean, 0, null);
  }
  
  public u$c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, u.a parama)
  {
    this.context = paramContext;
    this.ffp = paramString1;
    this.wgl = paramString2;
    this.kFs = paramBoolean;
    this.opType = paramInt;
    this.wgm = parama;
  }
  
  private void a(String paramString1, String paramString2, InputStream paramInputStream)
  {
    AppMethodBeat.i(80464);
    ab.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[] { paramString1, paramString2 });
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(paramString1))
    {
      paramString1 = wgi.matcher(paramString1);
      localObject1 = localObject2;
      if (paramString1.find()) {
        localObject1 = paramString1.group().substring(paramString1.group().lastIndexOf('/') + 1);
      }
    }
    paramString1 = (String)localObject1;
    if (bo.isNullOrNil((String)localObject1))
    {
      paramString1 = (String)localObject1;
      if (!bo.isNullOrNil(paramString2))
      {
        paramString2 = wgj.matcher(paramString2);
        paramString1 = (String)localObject1;
        if (paramString2.find()) {
          paramString1 = paramString2.group().substring(paramString2.group().lastIndexOf('.') + 1);
        }
      }
    }
    paramString2 = paramString1;
    int i;
    if (bo.isNullOrNil(paramString1))
    {
      paramString1 = new s(this.ffp);
      i = paramString1.mPath.lastIndexOf('.');
      if (i != -1) {
        break label226;
      }
    }
    label226:
    for (paramString2 = "jpg";; paramString2 = paramString1.mPath.substring(i + 1))
    {
      this.imagePath = n.TY(paramString2);
      paramString1 = new FileOutputStream(this.imagePath);
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
        this.wgk = this.context.getString(2131298889, new Object[] { n.dpF() });
        n.a(this.imagePath, this.context);
      }
      AppMethodBeat.o(80464);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    AppMethodBeat.i(80463);
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
          AppMethodBeat.o(80463);
          return;
        }
        catch (Exception paramHttpURLConnection)
        {
          ab.printErrStackTrace("MicroMsg.WebViewUtil", paramHttpURLConnection, "", new Object[0]);
        }
        localException = localException;
        ab.e("MicroMsg.WebViewUtil", localException.getMessage());
      }
      AppMethodBeat.o(80463);
    }
  }
  
  /* Error */
  private void dpL()
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 200	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   13: invokespecial 201	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 205	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 179	java/net/HttpURLConnection
    //   22: astore_2
    //   23: aload_2
    //   24: ldc 207
    //   26: invokevirtual 210	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: ldc 212
    //   32: aload_0
    //   33: getfield 65	com/tencent/mm/pluginsdk/ui/tools/u$c:wgl	Ljava/lang/String;
    //   36: invokevirtual 215	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_2
    //   40: iconst_1
    //   41: invokevirtual 219	java/net/HttpURLConnection:setAllowUserInteraction	(Z)V
    //   44: aload_2
    //   45: invokevirtual 223	java/net/HttpURLConnection:getResponseCode	()I
    //   48: istore_1
    //   49: iload_1
    //   50: sipush 200
    //   53: if_icmpeq +106 -> 159
    //   56: iload_1
    //   57: sipush 301
    //   60: if_icmpeq +10 -> 70
    //   63: iload_1
    //   64: sipush 302
    //   67: if_icmpne +68 -> 135
    //   70: aload_2
    //   71: ldc 225
    //   73: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 4
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: ifnonnull +10 -> 93
    //   86: aload_2
    //   87: ldc 230
    //   89: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_3
    //   93: ldc 78
    //   95: ldc 232
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_3
    //   104: aastore
    //   105: invokestatic 85	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: invokestatic 91	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   112: ifne +23 -> 135
    //   115: aload_0
    //   116: aload_3
    //   117: putfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   120: aload_0
    //   121: invokespecial 234	com/tencent/mm/pluginsdk/ui/tools/u$c:dpL	()V
    //   124: aload_2
    //   125: aconst_null
    //   126: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   129: ldc 198
    //   131: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: return
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 61	com/tencent/mm/pluginsdk/ui/tools/u$c:context	Landroid/content/Context;
    //   140: ldc 237
    //   142: invokevirtual 239	android/content/Context:getString	(I)Ljava/lang/String;
    //   145: putfield 164	com/tencent/mm/pluginsdk/ui/tools/u$c:wgk	Ljava/lang/String;
    //   148: aload_2
    //   149: aconst_null
    //   150: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   153: ldc 198
    //   155: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: aload_2
    //   160: invokevirtual 242	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   163: astore 4
    //   165: aload_2
    //   166: invokevirtual 183	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   169: astore_3
    //   170: aload_0
    //   171: aload 4
    //   173: aload_2
    //   174: ldc 244
    //   176: invokevirtual 228	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   179: aload_3
    //   180: invokespecial 246	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   183: aload_2
    //   184: aload_3
    //   185: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   188: ldc 198
    //   190: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_3
    //   200: ldc 78
    //   202: ldc 248
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload 4
    //   212: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload_3
    //   220: aload_2
    //   221: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   224: ldc 198
    //   226: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_3
    //   236: aload_3
    //   237: aload_2
    //   238: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   241: ldc 198
    //   243: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload 4
    //   248: athrow
    //   249: astore 4
    //   251: aconst_null
    //   252: astore 5
    //   254: aload_2
    //   255: astore_3
    //   256: aload 5
    //   258: astore_2
    //   259: goto -23 -> 236
    //   262: astore 4
    //   264: aload_2
    //   265: astore 5
    //   267: aload_3
    //   268: astore_2
    //   269: aload 5
    //   271: astore_3
    //   272: goto -36 -> 236
    //   275: astore 4
    //   277: goto -41 -> 236
    //   280: astore 4
    //   282: aconst_null
    //   283: astore 5
    //   285: aload_2
    //   286: astore_3
    //   287: aload 5
    //   289: astore_2
    //   290: goto -90 -> 200
    //   293: astore 4
    //   295: aload_2
    //   296: astore 5
    //   298: aload_3
    //   299: astore_2
    //   300: aload 5
    //   302: astore_3
    //   303: goto -103 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	c
    //   48	20	1	i	int
    //   22	278	2	localObject1	Object
    //   80	223	3	localObject2	Object
    //   76	96	4	str	String
    //   194	17	4	localException1	Exception
    //   230	17	4	localObject3	Object
    //   249	1	4	localObject4	Object
    //   262	1	4	localObject5	Object
    //   275	1	4	localObject6	Object
    //   280	1	4	localException2	Exception
    //   293	1	4	localException3	Exception
    //   252	49	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	194	java/lang/Exception
    //   5	23	230	finally
    //   23	49	249	finally
    //   70	78	249	finally
    //   86	93	249	finally
    //   93	124	249	finally
    //   135	148	249	finally
    //   159	170	249	finally
    //   170	183	262	finally
    //   200	219	275	finally
    //   23	49	280	java/lang/Exception
    //   70	78	280	java/lang/Exception
    //   86	93	280	java/lang/Exception
    //   93	124	280	java/lang/Exception
    //   135	148	280	java/lang/Exception
    //   159	170	280	java/lang/Exception
    //   170	183	293	java/lang/Exception
  }
  
  /* Error */
  public final boolean acS()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 250
    //   7: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 67	com/tencent/mm/pluginsdk/ui/tools/u$c:kFs	Z
    //   14: ifne +23 -> 37
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 61	com/tencent/mm/pluginsdk/ui/tools/u$c:context	Landroid/content/Context;
    //   22: ldc 251
    //   24: invokevirtual 239	android/content/Context:getString	(I)Ljava/lang/String;
    //   27: putfield 164	com/tencent/mm/pluginsdk/ui/tools/u$c:wgk	Ljava/lang/String;
    //   30: ldc 250
    //   32: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_1
    //   36: ireturn
    //   37: aload_0
    //   38: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   41: invokestatic 91	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +10 -> 54
    //   47: ldc 250
    //   49: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: iconst_0
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   58: invokestatic 256	android/webkit/URLUtil:isDataUrl	(Ljava/lang/String;)Z
    //   61: ifeq +262 -> 323
    //   64: aload_0
    //   65: ldc 125
    //   67: invokestatic 131	com/tencent/mm/pluginsdk/ui/tools/n:TY	(Ljava/lang/String;)Ljava/lang/String;
    //   70: putfield 133	com/tencent/mm/pluginsdk/ui/tools/u$c:imagePath	Ljava/lang/String;
    //   73: aload_3
    //   74: astore_2
    //   75: aload_0
    //   76: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   79: ldc_w 258
    //   82: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   85: istore_1
    //   86: iload_1
    //   87: ifle +20 -> 107
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   97: iload_1
    //   98: bipush 7
    //   100: iadd
    //   101: invokevirtual 115	java/lang/String:substring	(I)Ljava/lang/String;
    //   104: putfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   107: aload_3
    //   108: astore_2
    //   109: new 135	java/io/FileOutputStream
    //   112: dup
    //   113: aload_0
    //   114: getfield 133	com/tencent/mm/pluginsdk/ui/tools/u$c:imagePath	Ljava/lang/String;
    //   117: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_3
    //   121: aload_0
    //   122: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   125: iconst_0
    //   126: invokestatic 268	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +8 -> 139
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 271	java/io/FileOutputStream:write	([B)V
    //   139: aload_3
    //   140: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   143: aload_3
    //   144: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   147: aload_0
    //   148: aload_0
    //   149: getfield 61	com/tencent/mm/pluginsdk/ui/tools/u$c:context	Landroid/content/Context;
    //   152: ldc 153
    //   154: iconst_1
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: invokestatic 156	com/tencent/mm/pluginsdk/ui/tools/n:dpF	()Ljava/lang/String;
    //   163: aastore
    //   164: invokevirtual 162	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   167: putfield 164	com/tencent/mm/pluginsdk/ui/tools/u$c:wgk	Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 133	com/tencent/mm/pluginsdk/ui/tools/u$c:imagePath	Ljava/lang/String;
    //   174: aload_0
    //   175: getfield 61	com/tencent/mm/pluginsdk/ui/tools/u$c:context	Landroid/content/Context;
    //   178: invokestatic 167	com/tencent/mm/pluginsdk/ui/tools/n:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   181: aload_3
    //   182: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   185: ldc 250
    //   187: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: iconst_1
    //   191: ireturn
    //   192: astore_2
    //   193: ldc 78
    //   195: ldc_w 273
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_2
    //   205: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -27 -> 185
    //   215: astore_2
    //   216: aload 4
    //   218: astore_3
    //   219: aload_2
    //   220: astore 4
    //   222: aload_3
    //   223: astore_2
    //   224: ldc 78
    //   226: ldc_w 275
    //   229: iconst_1
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload 4
    //   237: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_3
    //   245: ifnull -60 -> 185
    //   248: aload_3
    //   249: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   252: goto -67 -> 185
    //   255: astore_2
    //   256: ldc 78
    //   258: ldc_w 273
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_2
    //   268: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   271: aastore
    //   272: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -90 -> 185
    //   278: astore 4
    //   280: aload_2
    //   281: astore_3
    //   282: aload 4
    //   284: astore_2
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   293: ldc 250
    //   295: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_2
    //   299: athrow
    //   300: astore_3
    //   301: ldc 78
    //   303: ldc_w 273
    //   306: iconst_1
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload_3
    //   313: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -27 -> 293
    //   323: aload_0
    //   324: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   327: invokestatic 278	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
    //   330: ifeq +236 -> 566
    //   333: new 200	java/net/URL
    //   336: dup
    //   337: aload_0
    //   338: getfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   341: invokespecial 201	java/net/URL:<init>	(Ljava/lang/String;)V
    //   344: invokevirtual 205	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   347: checkcast 280	javax/net/ssl/HttpsURLConnection
    //   350: astore_2
    //   351: aload_2
    //   352: ldc 207
    //   354: invokevirtual 281	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   357: aload_2
    //   358: ldc 212
    //   360: aload_0
    //   361: getfield 65	com/tencent/mm/pluginsdk/ui/tools/u$c:wgl	Ljava/lang/String;
    //   364: invokevirtual 282	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: aload_2
    //   368: iconst_1
    //   369: invokevirtual 283	javax/net/ssl/HttpsURLConnection:setAllowUserInteraction	(Z)V
    //   372: aload_2
    //   373: invokevirtual 284	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   376: istore_1
    //   377: iload_1
    //   378: sipush 200
    //   381: if_icmpeq +100 -> 481
    //   384: iload_1
    //   385: sipush 301
    //   388: if_icmpeq +10 -> 398
    //   391: iload_1
    //   392: sipush 302
    //   395: if_icmpne +65 -> 460
    //   398: aload_2
    //   399: ldc 225
    //   401: invokevirtual 285	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   404: astore 4
    //   406: aload 4
    //   408: astore_3
    //   409: aload 4
    //   411: ifnonnull +10 -> 421
    //   414: aload_2
    //   415: ldc 230
    //   417: invokevirtual 285	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   420: astore_3
    //   421: ldc 78
    //   423: ldc 232
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload_3
    //   432: aastore
    //   433: invokestatic 85	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: aload_3
    //   437: invokestatic 91	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   440: ifne +20 -> 460
    //   443: aload_0
    //   444: aload_3
    //   445: putfield 63	com/tencent/mm/pluginsdk/ui/tools/u$c:ffp	Ljava/lang/String;
    //   448: aload_0
    //   449: invokespecial 234	com/tencent/mm/pluginsdk/ui/tools/u$c:dpL	()V
    //   452: aload_2
    //   453: aconst_null
    //   454: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   457: goto -272 -> 185
    //   460: aload_0
    //   461: aload_0
    //   462: getfield 61	com/tencent/mm/pluginsdk/ui/tools/u$c:context	Landroid/content/Context;
    //   465: ldc 237
    //   467: invokevirtual 239	android/content/Context:getString	(I)Ljava/lang/String;
    //   470: putfield 164	com/tencent/mm/pluginsdk/ui/tools/u$c:wgk	Ljava/lang/String;
    //   473: aload_2
    //   474: aconst_null
    //   475: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   478: goto -293 -> 185
    //   481: aload_2
    //   482: invokevirtual 286	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   485: astore 4
    //   487: aload_2
    //   488: invokevirtual 287	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   491: astore_3
    //   492: aload_0
    //   493: aload 4
    //   495: aload_2
    //   496: ldc 244
    //   498: invokevirtual 285	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   501: aload_3
    //   502: invokespecial 246	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   505: aload_2
    //   506: aload_3
    //   507: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   510: goto -325 -> 185
    //   513: astore 4
    //   515: aconst_null
    //   516: astore_2
    //   517: aconst_null
    //   518: astore_3
    //   519: ldc 78
    //   521: ldc_w 289
    //   524: iconst_1
    //   525: anewarray 4	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: aload 4
    //   532: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   535: aastore
    //   536: invokestatic 175	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   539: aload_3
    //   540: aload_2
    //   541: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   544: goto -359 -> 185
    //   547: astore 4
    //   549: aconst_null
    //   550: astore_2
    //   551: aconst_null
    //   552: astore_3
    //   553: aload_3
    //   554: aload_2
    //   555: invokestatic 236	com/tencent/mm/pluginsdk/ui/tools/u$c:a	(Ljava/net/HttpURLConnection;Ljava/io/InputStream;)V
    //   558: ldc 250
    //   560: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: aload 4
    //   565: athrow
    //   566: aload_0
    //   567: invokespecial 234	com/tencent/mm/pluginsdk/ui/tools/u$c:dpL	()V
    //   570: goto -385 -> 185
    //   573: astore 4
    //   575: aconst_null
    //   576: astore 5
    //   578: aload_2
    //   579: astore_3
    //   580: aload 5
    //   582: astore_2
    //   583: goto -30 -> 553
    //   586: astore 4
    //   588: aload_2
    //   589: astore 5
    //   591: aload_3
    //   592: astore_2
    //   593: aload 5
    //   595: astore_3
    //   596: goto -43 -> 553
    //   599: astore 4
    //   601: goto -48 -> 553
    //   604: astore 4
    //   606: aconst_null
    //   607: astore 5
    //   609: aload_2
    //   610: astore_3
    //   611: aload 5
    //   613: astore_2
    //   614: goto -95 -> 519
    //   617: astore 4
    //   619: aload_2
    //   620: astore 5
    //   622: aload_3
    //   623: astore_2
    //   624: aload 5
    //   626: astore_3
    //   627: goto -108 -> 519
    //   630: astore_2
    //   631: goto -346 -> 285
    //   634: astore 4
    //   636: goto -414 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	this	c
    //   85	311	1	i	int
    //   74	62	2	localObject1	Object
    //   192	13	2	localException1	Exception
    //   215	5	2	localException2	Exception
    //   223	1	2	localObject2	Object
    //   255	26	2	localException3	Exception
    //   284	340	2	localObject3	Object
    //   630	1	2	localObject4	Object
    //   1	289	3	localObject5	Object
    //   300	13	3	localException4	Exception
    //   408	219	3	localObject6	Object
    //   3	233	4	localObject7	Object
    //   278	5	4	localObject8	Object
    //   404	90	4	str	String
    //   513	18	4	localException5	Exception
    //   547	17	4	localObject9	Object
    //   573	1	4	localObject10	Object
    //   586	1	4	localObject11	Object
    //   599	1	4	localObject12	Object
    //   604	1	4	localException6	Exception
    //   617	1	4	localException7	Exception
    //   634	1	4	localException8	Exception
    //   576	49	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   181	185	192	java/lang/Exception
    //   75	86	215	java/lang/Exception
    //   92	107	215	java/lang/Exception
    //   109	121	215	java/lang/Exception
    //   248	252	255	java/lang/Exception
    //   75	86	278	finally
    //   92	107	278	finally
    //   109	121	278	finally
    //   224	244	278	finally
    //   289	293	300	java/lang/Exception
    //   333	351	513	java/lang/Exception
    //   333	351	547	finally
    //   351	377	573	finally
    //   398	406	573	finally
    //   414	421	573	finally
    //   421	452	573	finally
    //   460	473	573	finally
    //   481	492	573	finally
    //   492	505	586	finally
    //   519	539	599	finally
    //   351	377	604	java/lang/Exception
    //   398	406	604	java/lang/Exception
    //   414	421	604	java/lang/Exception
    //   421	452	604	java/lang/Exception
    //   460	473	604	java/lang/Exception
    //   481	492	604	java/lang/Exception
    //   492	505	617	java/lang/Exception
    //   121	130	630	finally
    //   134	139	630	finally
    //   139	181	630	finally
    //   121	130	634	java/lang/Exception
    //   134	139	634	java/lang/Exception
    //   139	181	634	java/lang/Exception
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(80461);
    if (1 == this.opType)
    {
      this.wgm.Dc(this.imagePath);
      AppMethodBeat.o(80461);
      return true;
    }
    if (!bo.isNullOrNil(this.wgk)) {
      Toast.makeText(this.context, this.wgk, 1).show();
    }
    for (;;)
    {
      AppMethodBeat.o(80461);
      return true;
      Toast.makeText(this.context, this.context.getString(2131306032), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u.c
 * JD-Core Version:    0.7.0.1
 */