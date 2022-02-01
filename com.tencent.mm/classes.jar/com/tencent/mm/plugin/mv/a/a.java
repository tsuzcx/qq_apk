package com.tencent.mm.plugin.mv.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.File;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "", "name", "", "width", "", "height", "durationMs", "", "thumbPath", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "getFilePath", "Companion", "plugin-mv_release"})
public final class a
{
  private static final String Apg;
  private static int Aph = 0;
  private static final List<a> Api;
  public static final a Apj;
  private static final String TAG = "MicroMsg.Mv.DefaultVideoInfo";
  public long durationMs;
  public final int height;
  public final String name;
  String thumbPath;
  public final int width;
  
  static
  {
    AppMethodBeat.i(256746);
    Apj = new a((byte)0);
    TAG = "MicroMsg.Mv.DefaultVideoInfo";
    StringBuilder localStringBuilder = new StringBuilder();
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    Apg = localContext.getCacheDir().toString() + "/mv_video";
    Aph = -1;
    Api = j.listOf(new a("mv_default_bg_video.mp4"));
    AppMethodBeat.o(256746);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256744);
    this.name = paramString1;
    this.width = 634;
    this.height = 1080;
    this.durationMs = 5000L;
    this.thumbPath = paramString2;
    AppMethodBeat.o(256744);
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(256743);
    String str = Apg + "/" + this.name;
    AppMethodBeat.o(256743);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo$Companion;", "", "()V", "DefaultVideos", "", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "getDefaultVideos", "()Ljava/util/List;", "MusicDefaultVideoRoot", "", "getMusicDefaultVideoRoot", "()Ljava/lang/String;", "TAG", "lastRandomIndex", "", "checkCopyAssets", "", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "getVideoInfo", "plugin-mv_release"})
  public static final class a
  {
    /* Error */
    public static void a(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: ldc 46
      //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: invokestatic 55	com/tencent/mm/plugin/mv/a/a:access$getTAG$cp	()Ljava/lang/String;
      //   11: new 57	java/lang/StringBuilder
      //   14: dup
      //   15: ldc 59
      //   17: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   20: aload_1
      //   21: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: ldc 68
      //   26: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   29: aload_2
      //   30: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   36: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   39: aload_0
      //   40: aload_1
      //   41: invokevirtual 82	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
      //   44: astore 6
      //   46: aload 6
      //   48: ifnonnull +9 -> 57
      //   51: ldc 46
      //   53: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: return
      //   57: aload 6
      //   59: ldc 87
      //   61: invokestatic 93	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   64: aload 6
      //   66: arraylength
      //   67: ifne +96 -> 163
      //   70: iconst_1
      //   71: istore_3
      //   72: iload_3
      //   73: ifeq +138 -> 211
      //   76: aload_0
      //   77: aload_1
      //   78: invokevirtual 97	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   81: checkcast 99	java/io/Closeable
      //   84: astore 6
      //   86: aload 6
      //   88: checkcast 101	java/io/InputStream
      //   91: astore_0
      //   92: aload_2
      //   93: invokestatic 107	com/tencent/mm/vfs/s:LM	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   96: checkcast 99	java/io/Closeable
      //   99: astore_2
      //   100: aload_2
      //   101: checkcast 109	java/io/OutputStream
      //   104: astore_1
      //   105: aload_0
      //   106: ldc 111
      //   108: invokestatic 93	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   111: aload_1
      //   112: ldc 113
      //   114: invokestatic 93	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   117: aload_0
      //   118: aload_1
      //   119: invokestatic 119	kotlin/f/a:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
      //   122: pop2
      //   123: aload_2
      //   124: aconst_null
      //   125: invokestatic 124	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   128: aload 6
      //   130: aconst_null
      //   131: invokestatic 124	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   134: ldc 46
      //   136: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: return
      //   140: astore_0
      //   141: invokestatic 55	com/tencent/mm/plugin/mv/a/a:access$getTAG$cp	()Ljava/lang/String;
      //   144: aload_0
      //   145: checkcast 45	java/lang/Throwable
      //   148: ldc 125
      //   150: iconst_0
      //   151: anewarray 4	java/lang/Object
      //   154: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   157: ldc 46
      //   159: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   162: return
      //   163: iconst_0
      //   164: istore_3
      //   165: goto -93 -> 72
      //   168: astore_1
      //   169: ldc 46
      //   171: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   174: aload_1
      //   175: athrow
      //   176: astore_0
      //   177: aload_2
      //   178: aload_1
      //   179: invokestatic 124	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   182: ldc 46
      //   184: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   187: aload_0
      //   188: athrow
      //   189: astore_1
      //   190: ldc 46
      //   192: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   195: aload_1
      //   196: athrow
      //   197: astore_0
      //   198: aload 6
      //   200: aload_1
      //   201: invokestatic 124	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   204: ldc 46
      //   206: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   209: aload_0
      //   210: athrow
      //   211: aload_2
      //   212: invokestatic 133	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
      //   215: pop
      //   216: aload 6
      //   218: arraylength
      //   219: istore 4
      //   221: iconst_0
      //   222: istore_3
      //   223: iload_3
      //   224: iload 4
      //   226: if_icmpge +73 -> 299
      //   229: aload 6
      //   231: iload_3
      //   232: aaload
      //   233: astore 5
      //   235: getstatic 137	com/tencent/mm/plugin/mv/a/a:Apj	Lcom/tencent/mm/plugin/mv/a/a$a;
      //   238: astore 7
      //   240: aload_0
      //   241: new 57	java/lang/StringBuilder
      //   244: dup
      //   245: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   248: aload_1
      //   249: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: bipush 47
      //   254: invokevirtual 141	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   257: aload 5
      //   259: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   262: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   265: new 57	java/lang/StringBuilder
      //   268: dup
      //   269: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   272: aload_2
      //   273: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: bipush 47
      //   278: invokevirtual 141	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   281: aload 5
      //   283: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   286: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   289: invokestatic 143	com/tencent/mm/plugin/mv/a/a$a:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
      //   292: iload_3
      //   293: iconst_1
      //   294: iadd
      //   295: istore_3
      //   296: goto -73 -> 223
      //   299: ldc 46
      //   301: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   304: return
      //   305: astore_0
      //   306: aload 5
      //   308: astore_1
      //   309: goto -111 -> 198
      //   312: astore_0
      //   313: aconst_null
      //   314: astore_1
      //   315: goto -138 -> 177
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	318	0	paramAssetManager	android.content.res.AssetManager
      //   0	318	1	paramString1	String
      //   0	318	2	paramString2	String
      //   71	225	3	i	int
      //   219	8	4	j	int
      //   1	306	5	str	String
      //   44	186	6	localObject	Object
      //   238	1	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   39	46	140	java/lang/Exception
      //   51	56	140	java/lang/Exception
      //   57	70	140	java/lang/Exception
      //   76	86	140	java/lang/Exception
      //   128	139	140	java/lang/Exception
      //   198	211	140	java/lang/Exception
      //   211	221	140	java/lang/Exception
      //   235	292	140	java/lang/Exception
      //   100	123	168	java/lang/Throwable
      //   169	176	176	finally
      //   86	100	189	java/lang/Throwable
      //   123	128	189	java/lang/Throwable
      //   177	189	189	java/lang/Throwable
      //   190	197	197	finally
      //   86	100	305	finally
      //   123	128	305	finally
      //   177	189	305	finally
      //   100	123	312	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a
 * JD-Core Version:    0.7.0.1
 */