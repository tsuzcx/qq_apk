package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "", "()V", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "downloadFileSuccessCallback", "Lkotlin/Function0;", "", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "fileExist", "getFileExist", "()Z", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "afterUnZipRes", "success", "checkFile", "checkRes", "getConfigJson", "Lorg/json/JSONArray;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResTmpPath", "getResType", "", "getSubType", "getTag", "init", "moveFileToTargetPath", "fileName", "reportEdit", "unInit", "unzipFolder", "zipFileString", "outPathString", "unzipRes", "filePath", "type", "subType", "version", "Companion", "plugin-recordvideo_release"})
public abstract class a
{
  public static final a.a HUP = new a.a((byte)0);
  public boolean HUN;
  public kotlin.g.a.a<x> HUO;
  final IListener<bu> lKQ = (IListener)new b(this);
  
  private final boolean bkR()
  {
    Object localObject = fxD() + "config.json";
    Log.i(getTag(), "absConfigPath is:".concat(String.valueOf(localObject)));
    if (u.agG((String)localObject))
    {
      localObject = u.bBS((String)localObject);
      try
      {
        localObject = new JSONArray((String)localObject);
        int k = ((JSONArray)localObject).length();
        int i = 0;
        while (i < k)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          String[] arrayOfString = fxC();
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            String str = arrayOfString[j];
            str = fxD() + localJSONObject.optString(str);
            Log.i(getTag(), "file index:" + i + " path:" + str);
            if (!u.agG(str))
            {
              Log.e(getTag(), "file not exist.path:".concat(String.valueOf(str)));
              return false;
            }
            j += 1;
          }
          i += 1;
        }
        return true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(getTag(), (Throwable)localException, "video res parse config error!", new Object[0]);
        return false;
      }
    }
    Log.i(getTag(), "config not exist.");
    return false;
  }
  
  private final String fxF()
  {
    return fxD() + "temp/";
  }
  
  /* Error */
  private final int gj(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 201	java/util/zip/ZipInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokestatic 205	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: invokespecial 208	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_1
    //   15: aload 4
    //   17: invokevirtual 212	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   20: astore 6
    //   22: aload 6
    //   24: ifnull +412 -> 436
    //   27: aload 6
    //   29: astore 5
    //   31: aload 6
    //   33: astore_1
    //   34: aload 5
    //   36: ifnull +350 -> 386
    //   39: aload_1
    //   40: ifnonnull +6 -> 46
    //   43: invokestatic 217	kotlin/g/b/p:iCn	()V
    //   46: aload_1
    //   47: invokevirtual 222	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   50: astore 5
    //   52: aload 5
    //   54: ldc 224
    //   56: invokestatic 228	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   59: aload 5
    //   61: checkcast 230	java/lang/CharSequence
    //   64: ldc 232
    //   66: checkcast 230	java/lang/CharSequence
    //   69: invokestatic 238	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   72: ifne +361 -> 433
    //   75: aload 5
    //   77: checkcast 230	java/lang/CharSequence
    //   80: ldc 240
    //   82: checkcast 230	java/lang/CharSequence
    //   85: invokestatic 238	kotlin/n/n:g	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   88: ifeq +6 -> 94
    //   91: goto +342 -> 433
    //   94: aload_1
    //   95: ifnonnull +6 -> 101
    //   98: invokestatic 217	kotlin/g/b/p:iCn	()V
    //   101: aload_1
    //   102: invokevirtual 243	java/util/zip/ZipEntry:isDirectory	()Z
    //   105: ifeq +118 -> 223
    //   108: aload 5
    //   110: invokevirtual 244	java/lang/String:length	()I
    //   113: istore_3
    //   114: aload 5
    //   116: ifnonnull +49 -> 165
    //   119: new 246	kotlin/t
    //   122: dup
    //   123: ldc 248
    //   125: invokespecial 249	kotlin/t:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: astore_1
    //   130: aload 4
    //   132: astore_2
    //   133: aload_1
    //   134: astore 4
    //   136: aload_2
    //   137: astore_1
    //   138: aload_0
    //   139: invokevirtual 119	com/tencent/mm/plugin/recordvideo/res/a:getTag	()Ljava/lang/String;
    //   142: aload 4
    //   144: checkcast 182	java/lang/Throwable
    //   147: ldc 250
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_2
    //   157: checkcast 252	java/io/Closeable
    //   160: invokestatic 258	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   163: iconst_m1
    //   164: ireturn
    //   165: aload 5
    //   167: iconst_0
    //   168: iload_3
    //   169: iconst_1
    //   170: isub
    //   171: invokevirtual 262	java/lang/String:substring	(II)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ldc_w 264
    //   181: invokestatic 228	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   184: new 266	com/tencent/mm/vfs/q
    //   187: dup
    //   188: new 103	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   195: aload_2
    //   196: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 268
    //   202: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 5
    //   207: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 269	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   216: invokevirtual 272	com/tencent/mm/vfs/q:ifL	()Z
    //   219: pop
    //   220: goto -205 -> 15
    //   223: new 266	com/tencent/mm/vfs/q
    //   226: dup
    //   227: new 103	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   234: aload_2
    //   235: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 268
    //   241: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 5
    //   246: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokespecial 269	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   255: astore 5
    //   257: aload 5
    //   259: invokevirtual 276	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   262: astore 6
    //   264: aload 6
    //   266: ifnull +9 -> 275
    //   269: aload 6
    //   271: invokevirtual 272	com/tencent/mm/vfs/q:ifL	()Z
    //   274: pop
    //   275: aload 5
    //   277: invokestatic 280	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   280: astore 5
    //   282: aload 5
    //   284: ldc_w 282
    //   287: invokestatic 228	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   290: new 284	kotlin/g/b/aa$d
    //   293: dup
    //   294: invokespecial 285	kotlin/g/b/aa$d:<init>	()V
    //   297: astore 6
    //   299: sipush 1024
    //   302: newarray byte
    //   304: astore 7
    //   306: aload 4
    //   308: aload 7
    //   310: invokevirtual 289	java/util/zip/ZipInputStream:read	([B)I
    //   313: istore_3
    //   314: aload 6
    //   316: iload_3
    //   317: putfield 293	kotlin/g/b/aa$d:aaBA	I
    //   320: iload_3
    //   321: iconst_m1
    //   322: if_icmpeq +56 -> 378
    //   325: aload 5
    //   327: aload 7
    //   329: iconst_0
    //   330: aload 6
    //   332: getfield 293	kotlin/g/b/aa$d:aaBA	I
    //   335: invokevirtual 299	java/io/OutputStream:write	([BII)V
    //   338: goto -32 -> 306
    //   341: astore_1
    //   342: aload 4
    //   344: astore_2
    //   345: aload_1
    //   346: astore 4
    //   348: aload_2
    //   349: astore_1
    //   350: aload_0
    //   351: invokevirtual 119	com/tencent/mm/plugin/recordvideo/res/a:getTag	()Ljava/lang/String;
    //   354: aload 4
    //   356: checkcast 182	java/lang/Throwable
    //   359: ldc 250
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload_2
    //   369: checkcast 252	java/io/Closeable
    //   372: invokestatic 258	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   375: bipush 254
    //   377: ireturn
    //   378: aload 5
    //   380: invokevirtual 302	java/io/OutputStream:close	()V
    //   383: goto -368 -> 15
    //   386: aload 4
    //   388: checkcast 252	java/io/Closeable
    //   391: invokestatic 258	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   394: iconst_0
    //   395: ireturn
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_1
    //   399: aload_1
    //   400: checkcast 252	java/io/Closeable
    //   403: invokestatic 258	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   406: aload_2
    //   407: athrow
    //   408: astore_2
    //   409: aload 4
    //   411: astore_1
    //   412: goto -13 -> 399
    //   415: astore_2
    //   416: goto -17 -> 399
    //   419: astore 4
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -75 -> 348
    //   426: astore 4
    //   428: aconst_null
    //   429: astore_2
    //   430: goto -294 -> 136
    //   433: goto -418 -> 15
    //   436: aconst_null
    //   437: astore 5
    //   439: goto -405 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	this	a
    //   0	442	1	paramString1	String
    //   0	442	2	paramString2	String
    //   113	210	3	i	int
    //   11	399	4	localObject1	Object
    //   419	1	4	localIOException	java.io.IOException
    //   426	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   29	409	5	localObject2	Object
    //   20	311	6	localObject3	Object
    //   304	24	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	22	129	java/io/FileNotFoundException
    //   43	46	129	java/io/FileNotFoundException
    //   46	91	129	java/io/FileNotFoundException
    //   98	101	129	java/io/FileNotFoundException
    //   101	114	129	java/io/FileNotFoundException
    //   119	129	129	java/io/FileNotFoundException
    //   165	220	129	java/io/FileNotFoundException
    //   223	264	129	java/io/FileNotFoundException
    //   269	275	129	java/io/FileNotFoundException
    //   275	306	129	java/io/FileNotFoundException
    //   306	320	129	java/io/FileNotFoundException
    //   325	338	129	java/io/FileNotFoundException
    //   378	383	129	java/io/FileNotFoundException
    //   15	22	341	java/io/IOException
    //   43	46	341	java/io/IOException
    //   46	91	341	java/io/IOException
    //   98	101	341	java/io/IOException
    //   101	114	341	java/io/IOException
    //   119	129	341	java/io/IOException
    //   165	220	341	java/io/IOException
    //   223	264	341	java/io/IOException
    //   269	275	341	java/io/IOException
    //   275	306	341	java/io/IOException
    //   306	320	341	java/io/IOException
    //   325	338	341	java/io/IOException
    //   378	383	341	java/io/IOException
    //   0	13	396	finally
    //   15	22	408	finally
    //   43	46	408	finally
    //   46	91	408	finally
    //   98	101	408	finally
    //   101	114	408	finally
    //   119	129	408	finally
    //   165	220	408	finally
    //   223	264	408	finally
    //   269	275	408	finally
    //   275	306	408	finally
    //   306	320	408	finally
    //   325	338	408	finally
    //   378	383	408	finally
    //   138	156	415	finally
    //   350	368	415	finally
    //   0	13	419	java/io/IOException
    //   0	13	426	java/io/FileNotFoundException
  }
  
  private final void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    Object localObject;
    try
    {
      Log.i(getTag(), "unzipRes: %s", new Object[] { paramString });
      if (!u.agG(paramString)) {
        break label640;
      }
      u.bBD(fxF());
      i = gj(paramString, fxF());
      Log.i(getTag(), "unzip file ret:" + i + "  " + fxF());
      paramString = u.dP(fxF() + fxE(), false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (f)paramString.next();
          Log.i(getTag(), "unzip file path:" + ((f)localObject).UUr + " name:" + ((f)localObject).name + " size:" + ((f)localObject).size);
        }
      }
      bool = false;
    }
    finally {}
    boolean bool;
    if (i == 0) {}
    for (;;)
    {
      int j;
      try
      {
        if (!u.agG(fxF() + fxE() + "config.json")) {
          break label816;
        }
        paramString = u.bBS(fxF() + fxE() + "config.json");
        Log.i(getTag(), "meta json: %s", new Object[] { paramString });
        paramString = new JSONArray(paramString);
        i = 0;
        int k = paramString.length();
        if (i >= k) {
          break label732;
        }
        localObject = paramString.getJSONObject(i);
        String[] arrayOfString = fxC();
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label920;
        }
        str1 = ((JSONObject)localObject).optString(arrayOfString[j]);
        p.j(str1, "item.optString(it)");
        String str2 = fxF() + fxE() + str1;
        String str3 = fxD() + str1;
        Log.i(getTag(), "file tmp:" + str2 + "  real:" + str3);
        if (u.agG(str2)) {
          if (!u.agG(str3))
          {
            Log.i(getTag(), "move file ".concat(String.valueOf(str1)));
            u.oo(str2, str3);
          }
          else if ((p.h(g.getMD5(str2), g.getMD5(str3)) ^ true))
          {
            u.deleteFile(str3);
            u.oo(str2, str3);
            Log.i(getTag(), "replace file ".concat(String.valueOf(str1)));
          }
        }
      }
      catch (Exception paramString)
      {
        String str1;
        Log.printErrStackTrace(getTag(), (Throwable)paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        fxA().fxO();
        Log.i(getTag(), "unzip failed");
        paramString = this.HUO;
        if (paramString != null) {
          paramString.invoke();
        }
        u.dK(fxF(), true);
        wQ(false);
        label640:
        return;
        Log.i(getTag(), "already has file ".concat(String.valueOf(str1)));
      }
      finally
      {
        fxA().fxO();
        Log.i(getTag(), "unzip failed");
        localObject = this.HUO;
        if (localObject != null) {
          ((kotlin.g.a.a)localObject).invoke();
        }
        u.dK(fxF(), true);
        wQ(false);
      }
      Log.e(getTag(), "fuck! config does not matching file list!!!!!!!!");
      break label911;
      label732:
      u.deleteFile(fxD() + "config.json");
      u.oo(fxF() + fxE() + "config.json", fxD() + "config.json");
      bool = true;
      label816:
      if (!bool)
      {
        fxA().fxO();
        Log.i(getTag(), "unzip failed");
      }
      for (;;)
      {
        paramString = this.HUO;
        if (paramString != null) {
          paramString.invoke();
        }
        u.dK(fxF(), true);
        wQ(bool);
        break;
        fxA().fxN();
        Log.i(getTag(), "unzip success");
        com.tencent.mm.pluginsdk.k.a.a.b.hii().aT(paramInt1, paramInt2, paramInt3);
        this.HUN = true;
      }
      label911:
      j += 1;
      continue;
      label920:
      i += 1;
    }
  }
  
  public final void bkQ()
  {
    Log.i(getTag(), "checkRes " + fxB());
    com.tencent.mm.pluginsdk.k.a.a.b.hii();
    com.tencent.mm.pluginsdk.k.a.a.b.apP(fxB());
    fxA().bkQ();
  }
  
  public abstract b fxA();
  
  public abstract int fxB();
  
  public abstract String[] fxC();
  
  public abstract String fxD();
  
  public abstract String fxE();
  
  public final JSONArray fxG()
  {
    if (this.HUN) {
      return new JSONArray(u.bBS(fxD() + "config.json"));
    }
    return null;
  }
  
  public final void fxH()
  {
    if (this.HUN)
    {
      fxA().fxK();
      return;
    }
    fxA().fxL();
  }
  
  public abstract String getTag();
  
  public final void init()
  {
    Log.i(getTag(), "init");
    this.lKQ.alive();
    if (bkR()) {
      this.HUN = true;
    }
    while (this.HUN)
    {
      fxA().fxI();
      return;
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      String str = com.tencent.mm.pluginsdk.k.a.a.b.lV(fxB(), 1);
      if (u.agG(str))
      {
        Log.i(getTag(), "cache file exist %s", new Object[] { str });
        p.j(str, "cacheFile");
        r(str, fxB(), 1, 1);
      }
    }
    fxA().fxJ();
  }
  
  public void wQ(boolean paramBoolean) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-recordvideo_release"})
  public static final class b
    extends IListener<bu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb, bu parambu) {}
      
      public final void run()
      {
        AppMethodBeat.i(225114);
        a locala = this.HUR.HUQ;
        String str = this.HUS.fxB.filePath;
        p.j(str, "event.data.filePath");
        a.a(locala, str, this.HUS.fxB.fxC, this.HUS.fxB.subType, this.HUS.fxB.fxD);
        AppMethodBeat.o(225114);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.a
 * JD-Core Version:    0.7.0.1
 */