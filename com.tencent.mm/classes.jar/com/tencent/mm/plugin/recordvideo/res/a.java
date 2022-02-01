package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.d.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "", "()V", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "downloadFileSuccessCallback", "Lkotlin/Function0;", "", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "fileExist", "getFileExist", "()Z", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "afterUnZipRes", "success", "checkFile", "checkRes", "getConfigJson", "Lorg/json/JSONArray;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResTmpPath", "getResType", "", "getSubType", "getTag", "init", "moveFileToTargetPath", "fileName", "reportEdit", "unInit", "unzipFolder", "zipFileString", "outPathString", "unzipRes", "filePath", "type", "subType", "version", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a NRF = new a.a((byte)0);
  public boolean NRG;
  public kotlin.g.a.a<ah> NRH;
  final IListener<cd> oDs = (IListener)new BaseVideoResLogic.checkResUpdateCacheFileEventListener.1(this, f.hfK);
  
  /* Error */
  private final int aA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 113	java/util/zip/ZipInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokestatic 119	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: invokespecial 122	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_1
    //   15: aload 4
    //   17: invokevirtual 126	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnonnull +358 -> 382
    //   27: aconst_null
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +263 -> 295
    //   35: aload_1
    //   36: invokestatic 132	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   39: aload_1
    //   40: invokevirtual 138	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   43: astore 5
    //   45: aload 5
    //   47: ldc 140
    //   49: invokestatic 144	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   52: aload 5
    //   54: checkcast 146	java/lang/CharSequence
    //   57: ldc 148
    //   59: checkcast 146	java/lang/CharSequence
    //   62: invokestatic 154	kotlin/n/n:i	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   65: ifne +314 -> 379
    //   68: aload 5
    //   70: checkcast 146	java/lang/CharSequence
    //   73: ldc 156
    //   75: checkcast 146	java/lang/CharSequence
    //   78: invokestatic 154	kotlin/n/n:i	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   81: ifeq +6 -> 87
    //   84: goto +295 -> 379
    //   87: aload_1
    //   88: invokevirtual 159	java/util/zip/ZipEntry:isDirectory	()Z
    //   91: ifeq +63 -> 154
    //   94: aload 5
    //   96: iconst_0
    //   97: aload 5
    //   99: invokevirtual 165	java/lang/String:length	()I
    //   102: iconst_1
    //   103: isub
    //   104: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
    //   107: astore 5
    //   109: aload 5
    //   111: ldc 171
    //   113: invokestatic 144	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   116: new 173	com/tencent/mm/vfs/u
    //   119: dup
    //   120: new 175	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   127: aload_2
    //   128: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: bipush 47
    //   133: invokevirtual 183	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   136: aload 5
    //   138: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 189	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   147: invokevirtual 192	com/tencent/mm/vfs/u:jKY	()Z
    //   150: pop
    //   151: goto -136 -> 15
    //   154: new 173	com/tencent/mm/vfs/u
    //   157: dup
    //   158: new 175	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   165: aload_2
    //   166: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: bipush 47
    //   171: invokevirtual 183	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   174: aload 5
    //   176: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 189	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   185: astore 5
    //   187: aload 5
    //   189: invokevirtual 196	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   192: astore 6
    //   194: aload 6
    //   196: ifnull +9 -> 205
    //   199: aload 6
    //   201: invokevirtual 192	com/tencent/mm/vfs/u:jKY	()Z
    //   204: pop
    //   205: aload 5
    //   207: invokestatic 200	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   210: astore 5
    //   212: aload 5
    //   214: ldc 202
    //   216: invokestatic 144	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   219: sipush 1024
    //   222: newarray byte
    //   224: astore 6
    //   226: aload 4
    //   228: aload 6
    //   230: invokevirtual 206	java/util/zip/ZipInputStream:read	([B)I
    //   233: istore_3
    //   234: iload_3
    //   235: iconst_m1
    //   236: if_icmpeq +51 -> 287
    //   239: aload 5
    //   241: aload 6
    //   243: iconst_0
    //   244: iload_3
    //   245: invokevirtual 212	java/io/OutputStream:write	([BII)V
    //   248: goto -22 -> 226
    //   251: astore_1
    //   252: aload 4
    //   254: astore_2
    //   255: aload_1
    //   256: astore 4
    //   258: aload_2
    //   259: astore_1
    //   260: aload_0
    //   261: invokevirtual 214	com/tencent/mm/plugin/recordvideo/res/a:getTag	()Ljava/lang/String;
    //   264: aload 4
    //   266: checkcast 216	java/lang/Throwable
    //   269: ldc 217
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_2
    //   279: checkcast 225	java/io/Closeable
    //   282: invokestatic 231	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   285: iconst_m1
    //   286: ireturn
    //   287: aload 5
    //   289: invokevirtual 234	java/io/OutputStream:close	()V
    //   292: goto -277 -> 15
    //   295: aload 4
    //   297: checkcast 225	java/io/Closeable
    //   300: invokestatic 231	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore 4
    //   307: aconst_null
    //   308: astore_2
    //   309: aload_2
    //   310: astore_1
    //   311: aload_0
    //   312: invokevirtual 214	com/tencent/mm/plugin/recordvideo/res/a:getTag	()Ljava/lang/String;
    //   315: aload 4
    //   317: checkcast 216	java/lang/Throwable
    //   320: ldc 217
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload_2
    //   330: checkcast 225	java/io/Closeable
    //   333: invokestatic 231	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   336: bipush 254
    //   338: ireturn
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_1
    //   343: checkcast 225	java/io/Closeable
    //   346: invokestatic 231	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   349: aload_2
    //   350: athrow
    //   351: astore_2
    //   352: aload 4
    //   354: astore_1
    //   355: goto -13 -> 342
    //   358: astore_2
    //   359: goto -17 -> 342
    //   362: astore_1
    //   363: aload 4
    //   365: astore_2
    //   366: aload_1
    //   367: astore 4
    //   369: goto -60 -> 309
    //   372: astore 4
    //   374: aconst_null
    //   375: astore_2
    //   376: goto -118 -> 258
    //   379: goto -364 -> 15
    //   382: aload 5
    //   384: astore_1
    //   385: aload 5
    //   387: astore 6
    //   389: aload_1
    //   390: astore 5
    //   392: aload 6
    //   394: astore_1
    //   395: goto -365 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	a
    //   0	398	1	paramString1	String
    //   0	398	2	paramString2	String
    //   233	12	3	i	int
    //   11	285	4	localObject1	Object
    //   305	59	4	localIOException	java.io.IOException
    //   367	1	4	str	String
    //   372	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   20	371	5	localObject2	Object
    //   192	201	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	251	java/io/FileNotFoundException
    //   35	84	251	java/io/FileNotFoundException
    //   87	151	251	java/io/FileNotFoundException
    //   154	194	251	java/io/FileNotFoundException
    //   199	205	251	java/io/FileNotFoundException
    //   205	226	251	java/io/FileNotFoundException
    //   226	234	251	java/io/FileNotFoundException
    //   239	248	251	java/io/FileNotFoundException
    //   287	292	251	java/io/FileNotFoundException
    //   0	13	305	java/io/IOException
    //   0	13	339	finally
    //   15	22	351	finally
    //   35	84	351	finally
    //   87	151	351	finally
    //   154	194	351	finally
    //   199	205	351	finally
    //   205	226	351	finally
    //   226	234	351	finally
    //   239	248	351	finally
    //   287	292	351	finally
    //   260	278	358	finally
    //   311	329	358	finally
    //   15	22	362	java/io/IOException
    //   35	84	362	java/io/IOException
    //   87	151	362	java/io/IOException
    //   154	194	362	java/io/IOException
    //   199	205	362	java/io/IOException
    //   205	226	362	java/io/IOException
    //   226	234	362	java/io/IOException
    //   239	248	362	java/io/IOException
    //   287	292	362	java/io/IOException
    //   0	13	372	java/io/FileNotFoundException
  }
  
  public static int bCZ()
  {
    return 1;
  }
  
  private final boolean bIK()
  {
    Object localObject = s.X(gJs(), "config.json");
    Log.i(getTag(), s.X("absConfigPath is:", localObject));
    if (y.ZC((String)localObject)) {
      localObject = y.bEn((String)localObject);
    }
    for (;;)
    {
      int k;
      try
      {
        localObject = new JSONArray((String)localObject);
        int m = ((JSONArray)localObject).length();
        if (m > 0)
        {
          i = 0;
          k = i + 1;
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          String[] arrayOfString = gJr();
          int n = arrayOfString.length;
          int j = 0;
          if (j < n)
          {
            String str = arrayOfString[j];
            str = s.X(gJs(), localJSONObject.optString(str));
            Log.i(getTag(), "file index:" + i + " path:" + str);
            if (!y.ZC(str))
            {
              Log.e(getTag(), s.X("file not exist.path:", str));
              return false;
            }
            j += 1;
            continue;
          }
          if (k < m) {
            break label228;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(getTag(), (Throwable)localException, "video res parse config error!", new Object[0]);
        return false;
      }
      Log.i(getTag(), "config not exist.");
      return false;
      label228:
      int i = k;
    }
  }
  
  private final String gJu()
  {
    return s.X(gJs(), "temp/");
  }
  
  private final void r(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    Object localObject;
    try
    {
      Log.i(getTag(), "unzipRes: %s", new Object[] { paramString });
      if (!y.ZC(paramString)) {
        break label610;
      }
      y.bDX(gJu());
      i = aA(paramString, gJu());
      Log.i(getTag(), "unzip file ret:" + i + "  " + gJu());
      paramString = y.eB(s.X(gJu(), gJt()), false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (j)paramString.next();
          Log.i(getTag(), "unzip file path:" + ((j)localObject).acpB + " name:" + ((j)localObject).name + " size:" + ((j)localObject).size);
        }
      }
      bool = false;
    }
    finally {}
    boolean bool;
    if (i == 0) {}
    int k;
    int j;
    try
    {
      if (!y.ZC(gJu() + gJt() + "config.json")) {
        break label757;
      }
      paramString = y.bEn(gJu() + gJt() + "config.json");
      Log.i(getTag(), "meta json: %s", new Object[] { paramString });
      paramString = new JSONArray(paramString);
      i = 0;
      k = paramString.length();
      if (k <= 0) {
        break label699;
      }
      j = i + 1;
      localObject = paramString.getJSONObject(i);
      String[] arrayOfString = gJr();
      int m = arrayOfString.length;
      i = 0;
      label340:
      if (i >= m) {
        break label868;
      }
      str1 = ((JSONObject)localObject).optString(arrayOfString[i]);
      s.s(str1, "item.optString(it)");
      String str2 = gJu() + gJt() + str1;
      String str3 = s.X(gJs(), str1);
      Log.i(getTag(), "file tmp:" + str2 + "  real:" + str3);
      if (y.ZC(str2)) {
        if (!y.ZC(str3))
        {
          Log.i(getTag(), s.X("move file ", str1));
          y.qn(str2, str3);
        }
        else if (!s.p(g.getMD5(str2), g.getMD5(str3)))
        {
          y.deleteFile(str3);
          y.qn(str2, str3);
          Log.i(getTag(), s.X("replace file ", str1));
        }
      }
    }
    catch (Exception paramString)
    {
      String str1;
      Log.printErrStackTrace(getTag(), (Throwable)paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
      gJp().gJD();
      Log.i(getTag(), "unzip failed");
      paramString = this.NRH;
      if (paramString != null) {
        paramString.invoke();
      }
      y.ew(gJu(), true);
      Bq(false);
      label610:
      return;
      Log.i(getTag(), s.X("already has file ", str1));
    }
    finally
    {
      gJp().gJD();
      Log.i(getTag(), "unzip failed");
      localObject = this.NRH;
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
      y.ew(gJu(), true);
      Bq(false);
    }
    Log.e(getTag(), "fuck! config does not matching file list!!!!!!!!");
    for (;;)
    {
      label699:
      y.deleteFile(s.X(gJs(), "config.json"));
      y.qn(gJu() + gJt() + "config.json", s.X(gJs(), "config.json"));
      bool = true;
      label757:
      if (!bool)
      {
        gJp().gJD();
        Log.i(getTag(), "unzip failed");
      }
      for (;;)
      {
        paramString = this.NRH;
        if (paramString != null) {
          paramString.invoke();
        }
        y.ew(gJu(), true);
        Bq(bool);
        break;
        gJp().gJC();
        Log.i(getTag(), "unzip success");
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().bu(paramInt1, paramInt2, paramInt3);
        this.NRG = true;
      }
      label868:
      do
      {
        i = j;
        break;
        i += 1;
        break label340;
      } while (j < k);
    }
  }
  
  public void Bq(boolean paramBoolean) {}
  
  public final void bIJ()
  {
    Log.i(getTag(), s.X("checkRes ", Integer.valueOf(gJq())));
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(gJq());
    gJp().bIJ();
  }
  
  public abstract b gJp();
  
  public abstract int gJq();
  
  public abstract String[] gJr();
  
  public abstract String gJs();
  
  public abstract String gJt();
  
  public final JSONArray gJv()
  {
    if (this.NRG) {
      return new JSONArray(y.bEn(s.X(gJs(), "config.json")));
    }
    return null;
  }
  
  public final void gJw()
  {
    if (this.NRG)
    {
      gJp().gJz();
      return;
    }
    gJp().gJA();
  }
  
  public abstract String getTag();
  
  public final void init()
  {
    Log.i(getTag(), "init");
    this.oDs.alive();
    if (bIK()) {
      this.NRG = true;
    }
    while (this.NRG)
    {
      gJp().gJx();
      return;
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      String str = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(gJq(), 1);
      if (y.ZC(str))
      {
        Log.i(getTag(), "cache file exist %s", new Object[] { str });
        s.s(str, "cacheFile");
        r(str, gJq(), 1, 1);
      }
    }
    gJp().gJy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.a
 * JD-Core Version:    0.7.0.1
 */